<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<SCRIPT	language=javascript src="/hms/jsp/js/common.js" type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js" type=text/javascript></SCRIPT> 
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js" type=text/javascript></SCRIPT> 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> 
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
			 String date1=dateCal+"/"+month+"/"+year;
			 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			  String time1=sdf.format(calendar.getTime());
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
		
		%>
<script type="text/javascript">
function check() {
	var SDate = document.cashRegister.<%= FROM_DATE%>.value;
	var EDate = document.cashRegister.<%= TO_DATE %>.value;

	var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

	if(startDate > endDate) {
 			alert("Please ensure that the To Date is greater than or equal to the From Date.");
		return false;
 	}
	return true;
}
</script>

<form name="cashRegister" method="post" action="">
<div class="titleBg">
<h2>Daily Cash Register Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label class="autoSpace"><span>*</span> From Date</label> 
<input type="text" name="<%= FROM_DATE%>" value="<%= date%>" id="fromDate"
	validate="From Date,yes" class="date" MAXLENGTH="30" readonly="readonly" /> 
	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=FROM_DATE%>',document.cashRegister.<%=FROM_DATE%>,event);" />
<label class="autoSpace"><span>*</span> To Date</label> 
<input type="text" name="<%= TO_DATE%>" value="<%= date%>" id="toDate" validate="To Date,yes"
	class="date" MAXLENGTH="30" readonly="readonly" /> 
	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=TO_DATE%>',document.cashRegister.<%=TO_DATE%>,event);" />

<div class="clear"></div>
<label>UHID</label>
<input type="text" name="uhid" value="" id="uhid"/>

<label>Name</label>
<input type="text" name="name" value="" id="name"/>

<label>Mobile No.</label>
<input type="text" name="mobileNo" value="" id="Mobile No"/>
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Report" value="Generate Report" class="buttonBig"
	onClick="if(check()){submitForm('cashRegister','billing?method=printBillingCashRegisterReport')};"
	accesskey="g" tabindex=1 /> 
	
	<input type="reset" name="clear"
	id="clearbutton" value="Clear" class="button" " accesskey="a"
	tabindex=1 />
<div class="clear"></div>
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
