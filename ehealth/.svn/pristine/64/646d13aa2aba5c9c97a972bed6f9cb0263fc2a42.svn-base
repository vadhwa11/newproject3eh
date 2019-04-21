<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>
<META content="Evrsoft First Page" name=GENERATOR>
<SCRIPT	language=javascript src="/hms/jsp/js/common.js" type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js" type=text/javascript></SCRIPT>
<SCRIPT language=javascript	src="/hms/jsp/js/calendar.js" type=text/javascript></SCRIPT> 
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
	
		List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
		
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
	
		if(map.get("patientTypeList") != null){
			patientTypeList = (List<MasPatientType> )map.get("patientTypeList") ;
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		
	    String flag = "";
		if (map.get("flag") != null) {
			flag = (String)map.get("flag");
		}
		if (map.get("message") != null) {
			String message = (String) map.get("message");
			out.println(message);
		}
		String url = "";
		url = "billing?method=printPatientTypeWiseCashCollectionReport";
	
	%> <script type="text/javascript">
function check(){
	var currentdate=new Date();
	var SDate = document.search.<%= FROM_DATE%>.value;
	var EDate = document.search.<%= TO_DATE %>.value;


	var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

	if(endDate>currentdate)
		{
		alert("Please ensure that the To Date is less than or equal to the Current Date.");
		document.calldate.next_day.focus();
		return false;
		}
	else if(startDate > endDate)
	{
	alert("Please ensure that the To Date is greater than or equal to the From Date.");
	document.calldate.next_day.focus();
	return false;
	}
	else
	{
	return true;
	}
	}
</script>
<form name="search" method="post" action="">
<div class="titleBg">
<h2>Patient Type Wise Cash Collection Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date</label> <input
	type="text" name="<%= FROM_DATE%>" value="<%=date %>" class="date"
	MAXLENGTH="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=FROM_DATE%>',document.search.<%=FROM_DATE%>,true);" />

<label><span>*</span> To Date</label> <input type="text"
	name="<%= TO_DATE%>" value="<%=date %>" class="date" MAXLENGTH="30"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=FROM_DATE%>',document.search.<%=TO_DATE%>,true);" />

<label> Bill Type</label> <select name="<%=BILL_TYPE %>">
	<option value="all">All</option>
	<!-- <option value="dispensing">Dispensing</option> -->
	<option value="servicing">Servicing</option>
</select>
<div class="clear"></div>
<label> Patient Type</label> <select name="<%=PATIENT_TYPE %>">
	<option value="0">Select</option>
	<%
		for(MasPatientType patientType : patientTypeList){
	%>
	<option value="<%=patientType.getId() %>"><%=patientType.getPatientTypeName() %>
	</option>
	<%} %>
</select> <label>Summary</label> <input type="radio" class="inputRadiobutton"
	name="reportType" value="1" checked="checked" /> <label>Detail</label>
<input type="radio" class="inputRadiobutton" name="reportType" value="2" />
<div class="clear"></div>

<input type="hidden" name="flag" value="<%=flag %>" />
<div class="clear"></div>
<%--- Report Button   --%> <input type="button" name="Report"
	value="Generate Report" class="buttonBig"
	onClick="if(check()){submitForm('search','<%=url %>')};" accesskey="g" tabindex=1 />
<input type="reset" name="clear" id="clearbutton" value="Clear"
	class="button" " accesskey="a" tabindex=1 />
</div>	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	