
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showExternalIssueReportJsp";
  obj.submit();
  }
</script> <script type="text/javascript" language="javascript">
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
	</script> <script type="text/javascript">
function check(){
var SDate = document.externalIssueReport.<%= FROM_DATE%>.value;
var EDate = document.externalIssueReport.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script> <%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	
	

	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasUnit> searchMasUnitList = new ArrayList<MasUnit>();
	if(map.get("searchMasUnitList")!=null)
		searchMasUnitList = (List) map.get("searchMasUnitList");


%>
<div id="contentspace">
<div class="titleBg"">
<h2>External Issue Report</h2>
</div>
<div class="clear"></div>
<form name="externalIssueReport" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<div class="clear"></div>
<label class="bodytextB1"><span>*</span> From Date :</label> <input
	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"
	class="textbox_date" MAXLENGTH="30"
	validate="Pick a from date,date,yes" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=currentDate%>',document.externalIssueReport.<%=FROM_DATE%>,event)" />

<label class="bodytextB1"><span>*</span> To Date :</label> <input
	type="text" name="<%=TO_DATE%>" value="<%=currentDate%>"
	class="textbox_date" MAXLENGTH="30" validate="Pick a to date,date,yes"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	tabindex="1"
	onClick="setdate('<%=currentDate%>',document.externalIssueReport.<%=TO_DATE%>,event)" />

<div class="clear"></div>
<label class="bodytextB1"><span>*</span> Unit Name:</label> <select
	name="<%=UNIT_ID%>" validate="Unit Name,String,yes">
	<option value=0>Select</option>
	<%
				for (MasUnit masUnit :searchMasUnitList ) {
				
				%>
	<option value=<%=masUnit.getId()%>><%=masUnit.getUnitName()%>
	</option>
	<%	
					}
		
				%>
</select>
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<center><input type="button" name="add" id="addbutton"
	value="Ok" class="button"
	onClick="submitForm('externalIssueReport','stores?method=generateExternalIssueReport','check()');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button"
	onClick="clearButton('externalIssueReport');" accesskey="a" tabindex=1 />
</center>
</form>
</div>