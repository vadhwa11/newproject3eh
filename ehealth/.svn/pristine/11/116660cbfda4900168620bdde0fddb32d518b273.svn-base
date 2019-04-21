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
<h2>OPD Register Below One Year</h2>
</div>
<div class="clear"></div>
<form name="opdRegisterBelowAge" target="_blank" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">

<label> New</label>
<input type="radio"	name="visitType" value="new" checked="checked" class="radioCheck">
<label> Repeat</label>
<input type="radio" name="visitType" value="repeat" class="radioCheck">
<label> New/Repeat</label>
<input type="radio" name="visitType" value="newRepeat" class="radioCheck">

<div class="clear"></div>

<label>Below One Year</label>
<label>From Age</label>
<select name="fromAge">
<option value="">Select</option>
<option value="1 Days">1 Days</option>
<option value="2 Days">2 Days</option>
<option value="3 Days">3 Days</option>
<option value="4 Days">4 Days</option>
<option value="5 Days">5 Days</option>
<option value="6 Days">6 Days</option>
<option value="7 Days">7 Days</option>
<option value="8 Days">8 Days</option>
<option value="9 Days">9 Days</option>
<option value="10 Days">10 Days</option>
<option value="11 Days">11 Days</option>
<option value="12 Days">12 Days</option>
<option value="13 Days">13 Days</option>
<option value="14 Days">14 Days</option>
<option value="15 Days">15 Days</option>
<option value="16 Days">16 Days</option>
<option value="17 Days">17 Days</option>
<option value="18 Days">18 Days</option>
<option value="19 Days">19 Days</option>
<option value="20 Days">20 Days</option>
<option value="21 Days">21 Days</option>
<option value="22 Days">22 Days</option>
<option value="23 Days">23 Days</option>
<option value="24 Days">24 Days</option>
<option value="25 Days">25 Days</option>
<option value="26 Days">26 Days</option>
<option value="27 Days">27 Days</option>
<option value="28 Days">28 Days</option>
<option value="29 Days">29 Days</option>
<option value="30 Days">30 Days</option>
<option value="31 Days">31 Days</option>
<option value="1 Months">1 Months</option>
<option value="2 Months">2 Months</option>
<option value="3 Months">3 Months</option>
<option value="4 Months">4 Months</option>
<option value="5 Months">5 Months</option>
<option value="6 Months">6 Months</option>
<option value="7 Months">7 Months</option>
<option value="8 Months">8 Months</option>
<option value="9 Months">9 Months</option>
<option value="10 Months">10 Months</option>
<option value="11 Months">11 Months</option>
<option value="12 Months">12 Months</option>
</select>

<label>To Age</label>
<select name="toAge">
<option value="">Select</option>
<option value="">Select</option>
<option value="1 Days">1 Days</option>
<option value="2 Days">2 Days</option>
<option value="3 Days">3 Days</option>
<option value="4 Days">4 Days</option>
<option value="5 Days">5 Days</option>
<option value="6 Days">6 Days</option>
<option value="7 Days">7 Days</option>
<option value="8 Days">8 Days</option>
<option value="9 Days">9 Days</option>
<option value="10 Days">10 Days</option>
<option value="11 Days">11 Days</option>
<option value="12 Days">12 Days</option>
<option value="13 Days">13 Days</option>
<option value="14 Days">14 Days</option>
<option value="15 Days">15 Days</option>
<option value="16 Days">16 Days</option>
<option value="17 Days">17 Days</option>
<option value="18 Days">18 Days</option>
<option value="19 Days">19 Days</option>
<option value="20 Days">20 Days</option>
<option value="21 Days">21 Days</option>
<option value="22 Days">22 Days</option>
<option value="23 Days">23 Days</option>
<option value="24 Days">24 Days</option>
<option value="25 Days">25 Days</option>
<option value="26 Days">26 Days</option>
<option value="27 Days">27 Days</option>
<option value="28 Days">28 Days</option>
<option value="29 Days">29 Days</option>
<option value="30 Days">30 Days</option>
<option value="31 Days">31 Days</option>
<option value="1 Months">1 Months</option>
<option value="2 Months">2 Months</option>
<option value="3 Months">3 Months</option>
<option value="4 Months">4 Months</option>
<option value="5 Months">5 Months</option>
<option value="6 Months">6 Months</option>
<option value="7 Months">7 Months</option>
<option value="8 Months">8 Months</option>
<option value="9 Months">9 Months</option>
<option value="10 Months">10 Months</option>
<option value="11 Months">11 Months</option>
<option value="12 Months">12 Months</option>
</select>

<div class="clear"></div>

<label><span>*</span> From Date</label>
<input type="text"	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>"	readonly="readonly" MAXLENGTH="30" class="date"	validate="From Date, date, yes" />
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currenDate %>',document.opdRegisterBelowAge.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date</label>
<input type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>" class="date"	readonly="readonly" MAXLENGTH="30" validate="To Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('<%=currenDate %>',document.opdRegisterBelowAge.<%=TO_DATE%>,event)" />

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
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('opdRegisterBelowAge','registration?method=generateOPDRegisterBelowAgeReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
</form>