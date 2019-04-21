<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%

Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

}


List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();

if(map.get("masDepartmentList")!=null){
	masDepartmentList = (List<MasDepartment>) map.get("masDepartmentList");
}

%>
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/laundry?method=showInternalIssueReportLaundryJsp";
  obj.submit();
  }
</script>
<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<script type="text/javascript">
function check(){
var SDate = document.inertnalIssueLaundry.<%= FROM_DATE%>.value;
var EDate = document.inertnalIssueLaundry.<%= TO_DATE %>.value;
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
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
%>
<form name="inertnalIssueLaundry" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="titleBg">
<h2>Internal Issue Report(Laundry)</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label>
<input	type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>"	MAXLENGTH="30" validate="fromDate,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.inertnalIssueLaundry.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date </label>
<input type="text" name="<%=TO_DATE%>" value="<%=currentDate %>" MAXLENGTH="30" validate="toDate,date,yes" readonly="readonly" />
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="2" onClick="setdate('<%=currentDate%>',document.inertnalIssueLaundry.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label>To Store</label> <select id="toStoreId"
	name="<%=TO_STORE_ID%>" tabindex="3" validate="To Store,metachar,no">
	<option value="0">Select</option>
	<%
if(masDepartmentList.size()>0){
for(MasDepartment masDepartment : masDepartmentList){
%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%
}
} %>
</select>
<label>Issue Type</label> <select id="IssueType"
	name="IssueType" tabindex="4" validate="IssueType,metachar,no">
	<option value="LDN">Laundry</option>
	<option value="ALL">All Department</option>
	
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button" onClick="submitForm('inertnalIssueLaundry','laundry?method=generateInternalIssueLaundryReport','check()');" accesskey="a" tabindex="5" />
<input type="button" name="clear"	id="clearbutton" value="Clear" class="button"	onClick="clearButton('inertnalIssueLaundry');" accesskey="a" tabindex="6" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>