<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.BlDispensingHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.PatientStoreIndentHeader"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>


<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">

	<%

	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

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
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientStoreIndentHeader> patientStrInHdList =  new ArrayList<PatientStoreIndentHeader>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("patientStrInHdList") != null){
		patientStrInHdList = (List<PatientStoreIndentHeader>)map.get("patientStrInHdList");
	}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}

%> <%
	if(patientStrInHdList.size() > 0){
%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Demand No.</th>
		<th scope="col">Demand Date</th>
		<th scope="col"><%=prop.getProperty("com.jkt.hms.registration_no") %></th>
		<th scope="col"><%=prop.getProperty("com.jkt.hms.opd_no")%></th>
		<th scope="col">Patient Name</th>
		<th scope="col">Department</th>
	</tr>
	<tbody id="tableData">
		<% int i=1;
   	 		for(PatientStoreIndentHeader patIndentHeader : patientStrInHdList){
   	    %>
		<tr style="cursor: pointer;"
			onclick="submitForm('patientDrugIssueSearch','billing?method=getPatientDrugIssueDetails&patientIndentHdId=<%=patIndentHeader.getId() %>');">
			<td><%=i %></td>
			<td><%=patIndentHeader.getDemandNo() %></td>
			<td><%=HMSUtil.convertDateToStringWithoutTime(patIndentHeader.getDemandDate()) %></td>
			<td><%=patIndentHeader.getHin().getHinNo() %></td>
			<td>
			<%if(patIndentHeader.getInpatient()!=null){ %>
			<%=patIndentHeader.getInpatient().getAdNo() %>
			<%}else{ %>
			<%="03" %>
			<%} %>
			</td>
			
			<td><%=patIndentHeader.getHin().getPFirstName()+" "+patIndentHeader.getHin().getPMiddleName()+ " "+patIndentHeader.getHin().getPLastName()%></td>
			<td><%=patIndentHeader.getDepartment().getDepartmentName() %></td>
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
		pager.showPage(1);
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
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    for(var i=1;i<=counter;i++){
    	if(document.getElementById('issueId'+i).checked){
    		url += "&batchId"+i+"="+document.getElementById('issueId'+i).value+"&qty"+i+"="+document.getElementById('qtyId'+i).value;
    		}
    }
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }


</script></form>