<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.BlDispensingHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
	
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<form name="pharmacySalesView" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<BlDispensingHeader> dispensingDetailsList = new ArrayList<BlDispensingHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("dispensingDetailsList") != null){
		dispensingDetailsList = (List<BlDispensingHeader>)map.get("dispensingDetailsList");
	}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
%> <%
	if(dispensingDetailsList.size() > 0){
%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Dispensing Details</h4>
<div class="clear"></div>

<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Bill No</th>
		<th scope="col">Bill Date</th>
		<th scope="col">HIN</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Bill Amount</th>
		<th scope="col">Doctor Prescribed</th>
		<th scope="col">Patient Type</th>
	</tr>
	<tbody id="tableData">
		<% 
   	 		for(BlDispensingHeader dispensingHeader : dispensingDetailsList){   	
   	    %>
		<tr style="cursor: pointer;"
			onclick="submitProtoAjax('pharmacySalesView','billing?method=getItemWiseDetails&dispensingId=<%=dispensingHeader.getId() %>')">
			<td><%=dispensingHeader.getBillNo() %></td>
			<td><%=HMSUtil.convertDateToStringWithoutTime(dispensingHeader.getBillDate()) %></td>
			<%
	   	    	if(dispensingHeader.getHinNo() != null){
	   	    %>
			<td><%=dispensingHeader.getHinNo() %></td>
			<%}else{ %>
			<td></td>
			<%} %>
			<td><%=dispensingHeader.getPatientName() %></td>
			<td><%=dispensingHeader.getBillAmt() %></td>
			<td><%=dispensingHeader.getConsultant().getFirstName()+ " "+dispensingHeader.getConsultant().getMiddleName()+ " "+ dispensingHeader.getConsultant().getLastName() %></td>
			<%
   	 			if(dispensingHeader.getHin() != null){
   	 		%>
			<td><%=dispensingHeader.getHin().getPatientStatus() %></td>
			<%	}else{
   	 		%>
			<td>Unregistered</td>
			<%} %>
		</tr>
		<%
  } %>
	</tbody>
</table>
<div class="clear"></div>
<%}else{ %>
<div class="clear"></div>
<h4>No Record found!</h4>

<%} %>

<input type="hidden" name="pageEditNo" id="pageEditNo" value="<%=pageNo %>"/>
<div id="testDiv"></div>

<div class="paddingTop40"></div>
<script>
		var pager = new Pager('tableData',10); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(<%=pageNo%>);
	  </script> <script>

function checkAllBatch(){
	var count = document.getElementById('countId').value;
	if(document.getElementById('issueAllId').checked == true){
		for(var i=1;i<=count;i++){
			if(document.getElementById('issueId'+i).disabled == false)
				document.getElementById('issueId'+i).checked = true;
		}
	}else if(document.getElementById('issueAllId').checked == false){
		for(var i=1;i<count;i++){
			document.getElementById('issueId'+i).checked = false;
		}
	
	}
	
}

function validateRows(){
	var count = document.getElementById('countId').value;
	for(var i=1;i<=count;i++){
		if(document.getElementById('issueId'+i).checked){
			return true;
		}
		
	}
	alert("Please select at least one row.");
	return false;
}


function submitProtoAjaxForIssueBatch(formName,action){
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	if(items.childNodes.length!=0){
      	
      	for (loop = 0; loop < items.childNodes.length; loop++) {
      	
	   	 var item = items.childNodes[loop];
	   	
	   	 var message = item.getElementsByTagName("message")[0];
	   	 if(message.childNodes[0] == undefined)
	       {
    			submitForm('pharmacySalesView','opBilling?method=issueItemBatchFromPharmacy','validateRows');
	       }else{
	       		alert(message.childNodes[0].nodeValue);
	       }
	   	  
	   	  }
	   	  }
	   	
      }
    }
    
    var counter = document.getElementById('countId').value;
    var url=action+"&counter="+counter;
    for(var i=1;i<=counter;i++){
    	if(document.getElementById('issueId'+i).checked){
    		url += "&batchId"+i+"="+document.getElementById('issueId'+i).value+"&qty"+i+"="+document.getElementById('qtyId'+i).value;
    		}
    }
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
        
  }		


</script>	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>