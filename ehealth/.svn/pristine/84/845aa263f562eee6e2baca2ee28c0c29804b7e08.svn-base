	<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
	<%@ page import="java.util.*"%>
	<%@ page import="jkt.hms.util.HMSUtil"%>

	<%@page import="jkt.hms.masters.business.Users"%>
	
	
<META content="Evrsoft First Page" name=GENERATOR>

	<SCRIPT language=javascript src="/hms/jsp/js/common.js"	type=text/javascript></SCRIPT>

	<SCRIPT language=javascript src="/hms/jsp/js/hms.js" type=text/javascript></SCRIPT>

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
	Map<String,Object> map1 = new HashMap<String,Object>();

    List<Users> userList = new ArrayList<Users>();



	if (request.getAttribute("map") != null) {
		map1 = (Map) request.getAttribute("map");
	}

	if(map1.get("userList") != null){
		userList = (List<Users> )map1.get("userList") ;
	}
	%>


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
	%>


<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*" %>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript">
	</script>

<script type="text/javascript">
function check(){
	var currentDate=new Date();
	var start= new Date(document.getElementById("fromDate").value.split("/")[2], (parseInt(document.getElementById("fromDate").value.split("/")[1])-1),(parseInt( document.getElementById("fromDate").value.split("/")[0])),(document.getElementById("fromTime").value.split(":")[0]), document.getElementById("fromTime").value.split(":")[1], document.getElementById("fromTime").value.split(":")[2]);
	//alert(start);
   var end= new Date(document.getElementById("toDate").value.split("/")[2], (parseInt(document.getElementById("toDate").value.split("/")[1])-1), document.getElementById("toDate").value.split("/")[0], document.getElementById("toTime").value.split(":")[0], document.getElementById("toTime").value.split(":")[1], document.getElementById("toTime").value.split(":")[2]);
   //alert(end+"====="+end);
flag=true;
if(currentDate<=end){
	alert("To Date and Time Incorrect");
    flag=false;
}
//alert("==="+(start<=end) +"==="+(end.getTime()>=start.getTime()));
if(start>=end){
	alert("From Date and Time Incorrect");
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
<form name="report" method="post" action="">
<div class="titleBg"><h2>Shift Change Over Report(Detail)</h2></div>
<div class="clear"></div>
	<div class="Block">

	<label> User Name</label>
	<select id="user" name="userName">
	<option value="0">Select</option>
	<%
		for(Users user : userList){
	%>
	<option value="<%=user.getId() %>"><%=user.getUserName() %> </option>
	<%} %>
	</select>

		<label><span>*</span> From Date</label>
	<input type="text" name="<%= FROM_DATE%>" value="<%= date%>" validate="From Date,yes" class="date" MAXLENGTH="30"  readonly="readonly" id="fromDate"/>
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=FROM_DATE%>',document.report.<%=FROM_DATE%>,true);"/>

	<label><span>*</span> To Date</label>
	<input type="text" name="<%= TO_DATE%>" value="<%= date%>" validate="To Date,yes" class="date" MAXLENGTH="30"  readonly="readonly" id="toDate"/>
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=TO_DATE%>',document.report.<%=TO_DATE%>,true);" />

	<div class="clear"></div>
	<label><span>*</span> From Time</label>
	<input type="text" name="<%= FROM_TIME%>" value="00:00:00" class="date"  validate="From Time,string,yes" onkeyup="mask(this.value,this,'2,5',':');" MAXLENGTH="8" id="fromTime" />
	<label class="smallAuto">(HH:MM:SS)</label>

	<label><span>*</span> To Time</label>
	<input type="text" name="<%= TO_TIME%>" value="23:59:59" class="date" validate="To Time,string,yes" onkeyup="mask(this.value,this,'2,5',':');" MAXLENGTH="8" id="toTime" />
	<label class="smallAuto">(HH:MM:SS)</label>

	<div class="clear"></div>

					<div class="clear"></div>
			
		<div class="clear"></div>
<%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="if(check()){submitForm('report','billing?method=printShiftChangeOverReportDetailReport')};" accesskey="g" tabindex=1/>
		<input type="reset" name="clear" id="clearbutton" value="Clear" class="button" " accesskey="a" tabindex=1/>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>