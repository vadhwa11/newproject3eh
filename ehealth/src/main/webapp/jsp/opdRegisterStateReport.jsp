<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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

<%
Map map = new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");

List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<MasState> stateList = new ArrayList<MasState>();

if (request.getAttribute("map") != null) 
{
	map = (Map) request.getAttribute("map");
}
if(map.get("employeeList")!=null)
{
		employeeList = (List<MasEmployee>)map.get("employeeList");
}
if(map.get("stateList")!=null)
{
	stateList = (List<MasState>)map.get("stateList");
}

%>


<div class="titleBg">
<h2>OPD Register</h2>
</div>
<div class="clear"></div>
<form name="opdRegisterState" target="_blank" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">

<label> New</label>
<input type="radio"	name="visitType" value="new" checked="checked" class="radioCheck">
<label> Repeat</label>
<input type="radio" name="visitType" value="repeat" class="radioCheck">
<label> New/Repeat</label>
<input type="radio" name="visitType" value="newRepeat" class="radioCheck">

<label>State</label>
<select name="state">
<option value="">Select</option>
<%
if(stateList.size()>0){
for(MasState masState : stateList){
%>
<option value="<%=masState.getId()%>"><%=masState.getStateName()!=null?masState.getStateName():""%></option>
<%} }%>

</select>
<div class="clear"></div>

<label><span>*</span> From Date</label>
<input type="text"	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>"	readonly="readonly" MAXLENGTH="30" class="date"	validate="From Date, date, yes" />
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currenDate %>',document.opdRegisterState.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date</label>
<input type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>" class="date"	readonly="readonly" MAXLENGTH="30" validate="To Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('<%=currenDate %>',document.opdRegisterState.<%=TO_DATE%>,event)" />

<label>User</label>
<select name="empId" id="empId">
	<option value="0">All</option>
	<%
	  if(employeeList.size()>0){
	      for(MasEmployee masEmp:employeeList){

  	      %>
	       <option value="<%=masEmp.getId()%>"><%=masEmp.getFirstName()+" "+masEmp.getMiddleName()+" "+masEmp.getLastName()%></option>
	<%} }%>
</select>

<div class="clear"></div>
<div class="division"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('opdRegisterState','registration?method=generateOPDRegisterStateReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
</form>