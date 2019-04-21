<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"	type=text/javascript></SCRIPT>

<SCRIPT>
		<%
	
			Calendar calendar=Calendar.getInstance();
			String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
			String dateCal=String.valueOf(calendar.get(Calendar.DATE));
			int year=calendar.get(calendar.YEAR);
			if(month.length()<2){
				month="0"+month;
			}
			if(dateCal.length()<2){
				dateCal="0"+dateCal;
			}
			
		%>
			serverdate = '<%=dateCal+"/"+month+"/"+year%>'
		</SCRIPT>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String message = "";
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
	%>


<script type="text/javascript">
function check(){
var SDate = document.report.<%= FROM_DATE%>.value;
var EDate = document.report.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	if(!message.equals("")){
%>
<h4><span><%=message %></span></h4>
<%} %>












<form name="pharmacySalesViewSearch" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Indent Approval</h2>
</div>
<div class="clear"></div>
<div class="Block" >
<label > Indent No </label> 
<input type="text"	name="" value="1/2015" 	maxlength="30" tabindex=1 / readonly="readonly">
<label > Indent Date</label> 
<input type="text"	name="<%= TO_DATE%>" value="<%=date %>" class="date" MAXLENGTH="30"	readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=FROM_DATE%>',document.pharmacySalesViewSearch.<%=TO_DATE%>,true);" />

<label>From Department</label> 
<select name="deptId" id="departId" >
<option value="0">Select</option>

</select>
<div class="clear" ></div>

<label>To Department</label> 
<select name="deptId" id="departId" >
<option value="0">Select</option>

</select>

<label >Requested By </label> 
<select name="deptId" id="departId" >
<option value="0">Select</option>

</select>

<label >Approved By </label> 
<select name="deptId" id="departId" >
<option value="0">Select</option>

</select>

<div class="clear" ></div>

<label> Item Group </label> 
<select name="deptId" id="departId" >
<option value="0">Select</option>

</select>

<label> Indent Type </label> 
<input type="text"	name="" value="" 	maxlength="30" tabindex=1 />







<!-- <label class="auto">Pending</label> 
<input type="radio"	name="dispensType" value="pending" checked="checked" class="radioCheck">
<label class="auto">Issued</label> 
<input type="radio"	name="dispensType" value="issued" class="radioCheck"> 
<label	class="auto">All</label> 
<input type="radio" name="dispensType"	value="all" class="radioCheck"> 
<div class="clear"></div> -->
</div>





<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<table>
<tr><th>SI No.</th><th>Item Code</th><th>Item Name</th><th>Unit</th><th>Stock</th><th>Required Qty</th><th>Indent Qty</th><th>Status</th><th>Remarks</th></tr>
<tr><td>1</td><td>1201</td><td>Tab Azol</td><td>1</td><td>500</td><td>50</td><td><input type="text" value="50"></td><td><select name="deptId" id="departId" >
<option value="0">Select</option>
<option value="0">Approved</option>
<option value="0">Rejected</option>
</select></td><td><input type="text"></td></tr>
</table>
       
       
       
       
       
       
       <div class="clear"></div>
       <div class="clear"></div>
       <div class="clear"></div>
       <label style="text-align: left;width: 100px"> Remarks </label> 
       <textarea rows="8" cols="50"></textarea>
       
       <div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="search" value="Approve" class="button" onClick="submitForm('pharmacySalesViewSearch','billing?method=getPharmacySalesDetails');"	accesskey="g" tabindex=1 />
<input type="button" class="button" value="Reject"
	onclick="" align="right" /> 

	
	 <!-- <a href="/hms/hms/stores?method=showDetailPendingDispensing" >Dispensing details(Grid Onclick)</a> -->
<input type="hidden" size="2" value="fgfg" name="noOfRecords"
	id="noOfRecords" />
<div class="paddingTop15"></div>

<%-- <%
			String includedJsp ="";
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}
			
			if(!includedJsp.equals("")){
			%>
<jsp:include page="<%=includedJsp%>" flush="true" />
<%} %> --%>