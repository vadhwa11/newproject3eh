<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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
		serverdate = '<%=date+"/"+month+"/"+year%>';
</script>

<%
	Map map = new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Set patientSet = null;
	String hinNo ="";
	String andNo ="";

	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
	}

	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currenDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	Date toDate  = null;
	Date fromDate=null;
	if (map.get("toDate") != null) {
			toDate = (Date) map.get("toDate");
			session.setAttribute("toDate", toDate);
		}
		if (map.get("fromDate") != null) {
			fromDate = (Date) map.get("fromDate");
			session.setAttribute("fromDate", fromDate);
		}

		if (map.get("departmentList") != null) {
			departmentList =(ArrayList)map.get("departmentList");
		}
%>

<div class="clear"></div>
<div class="titleBg">
<h2>Hand Over & Take Over Report</h2>
</div>
<div class="clear"></div>

<form name="hanTakeOverReport" target=_blank action="" method="post">
<div class="Block"><label>From Date</label>
<input type="text" class="date" id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>" readonly="readonly" maxlength="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"border="0" validate="Pick a date"
	onclick="setdate('<%=currenDate%>',document.hanTakeOverReport.<%= FROM_DATE%>,event);" />

<label>To Date</label>
<input type="text" class="date" id="toDateId" name="<%=TO_DATE %>" value="<%=currenDate %>" readonly="readonly"
	maxlength="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onclick="setdate('<%=currenDate%>',document.hanTakeOverReport.<%= TO_DATE%>,event);" />

<label><span>*</span> Ward</label>
<select	name="<%= DEPARTMENT_NAME %>" validate="Ward,string,yes"	tabindex=1>
	<option value="">Select</option>
	<%
				for (MasDepartment  masDepartment : departmentList){
				%>
	<option value="<%=masDepartment.getDepartmentName()%>"><%=masDepartment.getDepartmentName()%></option>

	<%}%>
</select>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit" id="addbutton"	onClick="submitForm('hanTakeOverReport','ipd?method=showHandTakeOverReport');" value="Generate Report" class="buttonBig" accesskey="a" />
<input type="reset"	name="Reset" value="Reset" class="button" onclick="location.reload();"	accesskey="r" />
<div class="clear"></div>
<label id="errorMsg" style="display: none;"	class="biglabel"></label><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
