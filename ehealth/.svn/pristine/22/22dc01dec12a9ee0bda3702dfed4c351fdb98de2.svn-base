
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@page import="jkt.hms.masters.dataservice.BillingMasterDataServiceImpl"%>

<META content="Evrsoft First Page" name=GENERATOR><SCRIPT
	language=javascript src="/hms/jsp/js/common.js" type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT> <SCRIPT language=javascript
	src="/hms/jsp/js/calendar.js" type=text/javascript></SCRIPT> <SCRIPT>
		<%
		List<MasScheme> schemes=null;
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
		
		</SCRIPT> <%
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
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   %>
			   <h4><span><%=message %></span></h4>
			   <%} %>
			   
			  <%if(map.get("schemeList")!=null) {
				  schemes=(List<MasScheme>)map.get("schemeList");
			  }
			  %>
	 <%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%> <%@page
	import="jkt.hms.util.HMSUtil"%> <%@page
	import="java.net.URL"%> <script
	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> <script type="text/javascript"
	language="javascript">
	</script> <script type="text/javascript">
function check(){
	var currentDate=new Date();
	var start= new Date(document.getElementById("fromDate").value.split("/")[2], (parseInt(document.getElementById("fromDate").value.split("/")[1])-1),(parseInt( document.getElementById("fromDate").value.split("/")[0])),(document.getElementById("fromTime").value.split(":")[0]), document.getElementById("fromTime").value.split(":")[1], document.getElementById("fromTime").value.split(":")[2]);
	//alert(start);
   var end= new Date(document.getElementById("toDate").value.split("/")[2], (parseInt(document.getElementById("toDate").value.split("/")[1])-1), document.getElementById("toDate").value.split("/")[0], document.getElementById("toTime").value.split(":")[0], document.getElementById("toTime").value.split(":")[1], document.getElementById("toTime").value.split(":")[2]);
   //alert(end+"====="+end);
flag=true;
/* if(currentDate<=end){
	alert("To Date and Time Incorrect");
    flag=false;
} */
//alert("==="+(start<=end) +"==="+(end.getTime()>=start.getTime()));
/* if(start>=end){
	alert("From Date and Time Incorrect");
	flag=false;
	} */

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
<div class="titleBg">
<h2>Daily Cash Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label class="autoSpace"><span>*</span> From Date</label> <input
	type="text" name="<%= FROM_DATE%>" value="<%= date%>" id="fromDate"
	validate="From Date,yes" class="date" MAXLENGTH="30"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=FROM_DATE%>',document.report.<%=FROM_DATE%>,true);" />
<label class="autoSpace"><span>*</span> Time</label> 
<input type="text" name="<%= FROM_TIME%>" value="00:00" id="fromTime" class="small"
	validate="From Time,string,no" onBlur="IsValidTime(this.value,this.id);"
	onkeyup="mask(this.value,this,'2',':');" MAXLENGTH="5" /> 
	<label class="smallAuto">(HH:MM)</label> 
<label class="autoSpace"><span>*</span> To Date</label> <input type="text"
	name="<%= TO_DATE%>" value="<%= date%>" id="toDate" validate="To Date,yes"
	class="date" MAXLENGTH="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=TO_DATE%>',document.report.<%=TO_DATE%>,true);" />

<label class="autoSpace"><span>*</span> Time</label> 
<input type="text" name="<%= TO_TIME%>" id="toTime" value="23:59" class="small"
	validate="To Time,string,no" onBlur="IsValidTime(this.value,this.id);"
	onkeyup="mask(this.value,this,'2',':');" MAXLENGTH="5" /> 
	<label class="smallAuto">(HH:MM)</label><span></span>
	
	<div class="clear"></div>
	<label>Scheme</label>
	<select name="scheme" id="scheme">
	<option value="0">select</option>
	<%for(MasScheme scheme:schemes){ %>
	<option value="<%=scheme.getId()%>"><%=scheme.getSchemeName()%></option>
	<%} %>
	</select>

<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<%--- Report Button   --%> <input type="button" name="Report"
	value="Generate Report" class="buttonBig"
	onClick="if(check()){submitForm('report','billing?method=printDailyCashReport')};"
	accesskey="g" tabindex=1 /> 

<%--- Excel Report Button   --%><!--  <input type="button" name="Report"
	value="Generate Excel Report" class="buttonBig"
	onClick="if(check()){submitForm('report','generalMaster?method=generateDailyCashExcelReports')};"
	accesskey="e" tabindex=1 /> -->
	
	<input type="reset" name="clear"
	id="clearbutton" value="Clear" class="button" " accesskey="a"
	tabindex=1 />
<div class="clear"></div>
</div>
<div class="division"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
