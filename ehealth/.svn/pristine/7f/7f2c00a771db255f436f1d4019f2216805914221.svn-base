<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
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
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<script type="text/javascript" language="javascript">
function openPopupWindow()
{
	 var url="/hms/hms/ipd?method=showPatientSearchJsp";
	 newwindow=window.open(url,'name',"height=600,width=800,status=1,scrollbars=1,resizable=1");
}
function checkHinNo(hinNo){
if(hinNo ==""){
	return false;
}else{
	return true
}
}
</script>

<%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);
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
	if (map.get("patientSet") != null)
		patientSet = (Set) map.get("patientSet");
	List<Object> list = null;
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

		if (map.get("hinNo") != null) {
			hinNo =  ""+map.get("hinNo");
		}
		if (map.get("andNo") != null) {
			andNo =  (String)map.get("andNo");
		}
		Set<Inpatient> inpatientSet=new HashSet<Inpatient>();
		if (map.get("inpatientSet") != null) {
			inpatientSet =  (Set)map.get("inpatientSet");
		}

%>

<div class="clear"></div>

<div class="titleBg">
<h2>Intake/Output Chart</h2>
</div>
<div class="clear"></div>

<form name="intakeOutputChartReportForm" target=_blank action=""
	method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


<div class="Block">
<label><span>*</span>From Date</label>
<input type="text"	class="date" id="fromDateId" name="<%=FROM_DATE %>"
	   value="<%=currenDate %>" readonly="readonly" MAXLENGTH="30" validate="From Date,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"border="0" validate="Pick a date"
	onclick="setdate('<%=currenDate%>',document.intakeOutputChartReportForm.<%= FROM_DATE%>,event);" />

<label><span>*</span>To Date</label>
<input type="text" class="date" id="toDateId" name="<%=TO_DATE %>" value="<%=currenDate %>" readonly="readonly"
	MAXLENGTH="30" validate="To Date,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onclick="setdate('<%=currenDate%>',document.intakeOutputChartReportForm.<%= TO_DATE%>,event);" />

<div class="clear"></div>
<div class="clear"></div>

<label><span>*</span><%=prop.getProperty("com.jkt.hms.registration_no") %></label>

 <%if(map.get("hinNo") !=null){ %>
<input	type="text"  name="<%=HIN_NO %>" value="<%=hinNo%>"MAXLENGTH="30" validate="UHID,metachar,yes"
	onblur="if(checkHinNo(this.value)){submitProtoAjax('intakeOutputChartReportForm','discharge?method=getAdmissionNumberList');}" />
<%}else{ %>
<input type="text"  name="hinNo" value="" MAXLENGTH="30" validate="hinNo,metachar,yes"
	onblur="if(checkHinNo(this.value)){submitProtoAjax('intakeOutputChartReportForm','discharge?method=getAdmissionNumberList');}" />
<%} %>
<!-- <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer;" onClick="javascript:openPopupWindow();"/> -->

<div id="testDiv"><label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label>
<input type="text" name="<%=ADMISSION_NUMBER %>" validate="admissionNumber,metachar,no" value="<%=andNo%>" ></input></div>
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="Submit" id="addbutton"	onClick="submitForm('intakeOutputChartReportForm','ipd?method=showIntakeOutputChartReport');"
 		value="Generate Report"	class="button" accesskey="a" />
<input type="reset"	name="Reset" value="Cancel" class="button" onclick="location.reload();"	accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<label id="errorMsg" style="display: none;"	class="biglabel"></label>
</form>

