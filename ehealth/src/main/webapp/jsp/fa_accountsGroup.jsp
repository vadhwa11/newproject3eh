<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="java.math.BigDecimal"%>

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
<form name="faAccountGroup" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("faMasAccountGroupList") != null){
		faMasAccountGroupList = (List<FaMasAccountGroup>)map.get("faMasAccountGroupList");
	}

%> <%
	if(faMasAccountGroupList.size() > 0){
%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="titleBg">
<h4>Account Group Master</h4>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<input type="radio" name="<%=SELECTED_RADIO %>" value="1" checked="checked"	class="radioAuto" />
<label>Code</label>
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radioAuto" />
<label>Name</label>
<input type="text" id="searchField" name="<%=SEARCH_FIELD %>" value="" validate="account Group,string,no" maxlength="8" tabindex=1 onkeypress="return submitenter(this,event,'account?method=searchAccountGroup')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('faAccountGroup','account?method=searchAccountGroup','checkSearch')" tabindex=1 />
<input type="button" name="Report" value="Generate Report" class="buttonBig" onclick="submitForm('faAccountGroup','account?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_fa_acc_group"/><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<%-- <h4><a href="accounts?method=showAccountsGroupMasterJsp">Show All Records</a></h4>--%>
</div>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0" class="sortable">
	<tr>
		<th scope="col">Code</th>
		<th scope="col">Group</th>
		<th scope="col">Opening Balance</th>
		<th scope="col">YTD - Cr.</th>
		<th scope="col">YTD - Dr.</th>
		<th scope="col">Closing Balance</th>
		

	</tr>
	<tbody id="tableData">
		<%	String trColor = "";
   	 		for(FaMasAccountGroup accountGroup : faMasAccountGroupList){
   	 		if(accountGroup.getAccountGroupDesc().equalsIgnoreCase("Assets")){
	 				trColor="#D6FCA9";
	 			}else if(accountGroup.getAccountGroupDesc().equalsIgnoreCase("Liability")){
	 				trColor="#FDBFA1";
	 			} else if(accountGroup.getAccountGroupDesc().equalsIgnoreCase("Income")){
	 				trColor="#C2F7FA";
	 			}else if(accountGroup.getAccountGroupDesc().equalsIgnoreCase("Expenditure")){
	 				trColor="#FDF1B1";
	 			}
   	 		
   	 	//String url = "account?method=showAccountSubGroup&accountId="+accountGroup.getId();	
   	    %>
		<tr bgcolor="<%=trColor %>" onclick="submitForm('faAccountGroup','account?method=showViewAccountSubGroup&accountId=<%=accountGroup.getId()%>')">
			<td><%=accountGroup.getAccountGroupCode() %></td>
			<td><%=accountGroup.getAccountGroupDesc() %></td>
			<%
	   	    	if(accountGroup.getOpBalanceCr() != null && accountGroup.getOpBalanceCr().compareTo(new BigDecimal(0)) > 0){
	   	    %>
			<td class="right"><%=accountGroup.getOpBalanceCr()%>  Cr</td>
			<%}else if(accountGroup.getOpBalanceDr() !=null && accountGroup.getOpBalanceDr().compareTo(new BigDecimal(0)) > 0){ %>
			<td class="right"><%=accountGroup.getOpBalanceDr() %>   Dr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>
			
			<%
	   	    	if(accountGroup.getYtdAmountCr() != null && accountGroup.getYtdAmountCr().compareTo(new BigDecimal(0)) > 0){
	   	    %>
			<td class="right"><%=accountGroup.getYtdAmountCr()%>  Cr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>
			
			<% if(accountGroup.getYtdAmountDr() !=null && accountGroup.getYtdAmountDr().compareTo(new BigDecimal(0)) > 0){ %>
			<td class="right"><%=accountGroup.getYtdAmountDr() %>   Dr</td>
			<%}else{ %>
			<td class="right">-</td>
			<%} %>
			
			<%
	   	    	if(accountGroup.getClBalanceCr() != null && accountGroup.getClBalanceCr().compareTo(new BigDecimal(0)) > 0){
	   	    %>
			<td class="right"><%=accountGroup.getClBalanceCr()%>  Cr</td>
			<%}else if(accountGroup.getClBalanceDr() !=null && accountGroup.getClBalanceDr().compareTo(new BigDecimal(0)) > 0){ %>
			<td class="right"><%=accountGroup.getClBalanceDr() %>   Dr</td>
			<%}else{ %>
			<td class="right">-</td>
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


</script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>