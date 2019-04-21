
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<META content="Evrsoft First Page" name=GENERATOR><SCRIPT
	language=javascript src="/hms/jsp/js/common.js" type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT> <SCRIPT language=javascript
	src="/hms/jsp/js/calendar.js" type=text/javascript></SCRIPT> <SCRIPT>
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
		
<LINK href="/hms/jsp/css/hms_style.css" type=text/css rel=stylesheet>
<LINK href="/hms/jsp/css/phaseII.css" type=text/css rel=stylesheet>

<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
	         String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (map.get("message") != null) {
			String message = (String) map.get("message");
			out.println(message);
		}
	%> <%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%> <%@page
	import="jkt.hms.util.HMSUtil"%> <%@page
	import="java.net.URL"%> <script
	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> <script type="text/javascript"
	language="javascript">
	</script> <script type="text/javascript">
<%-- function check(){
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
} --%>
function check(){
	var currentDate=new Date();
	var start= new Date(document.getElementById("fromDate").value.split("/")[2], (parseInt(document.getElementById("fromDate").value.split("/")[1])-1),(parseInt( document.getElementById("fromDate").value.split("/")[0])));
	//alert(start);
   var end= new Date(document.getElementById("toDate").value.split("/")[2], (parseInt(document.getElementById("toDate").value.split("/")[1])-1), document.getElementById("toDate").value.split("/")[0]);
   //alert(end+"====="+end);
flag=true;
if(currentDate<=end){
	alert("To Date Incorrect");
    flag=false;
}
//alert("==="+(start<=end) +"==="+(end.getTime()>=start.getTime()));
if(start>=end){
	alert("From Date Incorrect");
	flag=false;
	}

if(flag)
{
	return flag;
}
	else
	{
		return flag;
}

}
</script>
<form name="charity" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Charity Register Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> From Date</label> <input
	type="text" name="<%= FROM_DATE%>" value="<%=date %>" class="date" id="fromDate"
	MAXLENGTH="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=FROM_DATE%>',document.charity.<%=FROM_DATE%>,true);" />

<label><span>*</span> To Date</label> <input type="text" id="toDate"
	name="<%= TO_DATE%>" value="<%=date %>" class="date" MAXLENGTH="30"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=FROM_DATE%>',document.charity.<%=TO_DATE%>,true);" />

<div class="clear"></div>

<div class="clear"></div>
<%--- Report Button   --%> <input type="button" name="Report"
	value="Generate Report" class="buttonBig"
	onClick="if(check()){submitForm('charity','billing?method=printCharityRegisterReport')};"
	accesskey="g" tabindex=1 /> <input type="reset" name="clear"
	id="clearbutton" value="Clear" class="button" " accesskey="a"
	tabindex=1 />
</div>	
</form>