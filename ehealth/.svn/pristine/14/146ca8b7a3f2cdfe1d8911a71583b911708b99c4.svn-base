
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.StoreIssueM"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=showInternalIssueReportJsp";
  obj.submit();
  }
</script>
<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(Calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>


<script type="text/javascript">
function check(){
var SDate = document.inertnalIssue.<%= FROM_DATE%>.value;
var EDate = document.inertnalIssue.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
	if(!displayAlert("Please ensure that the To Date is greater than or equal to the From Date."))
		alert("Please ensure that the To Date is greater than or equal to the From Date.");
	getShadowWithObj(document.calldate.next_day);
//document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();

Map map = new HashMap();
List<StoreIssueM> issueNumberList = new ArrayList<StoreIssueM>();


if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}

if(map.get("issueNumberList") != null){
	issueNumberList =(List<StoreIssueM>) map.get("issueNumberList");
}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
%>

<form name="inertnalIssue" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>

<div class="titleBg">
<h2>Internal Issue Report</h2>
</div>
<div class="Block">
<label><span>*</span>From Date</label> <input
	type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="date"
	maxlength="30" validate="Pick a from date,date,yes" readonly="readonly"
	onblur="submitProtoAjaxWithDivName('inertnalIssue','stores?method=issueListReport','issueNumberDiv')"
	onclick="submitProtoAjaxWithDivName('inertnalIssue','stores?method=issueListReport','issueNumberDiv')"/>

<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onclick="setdate('<%=currentDate%>',document.inertnalIssue.<%=FROM_DATE%>,event);submitProtoAjaxWithDivName('inertnalIssue','stores?method=issueListReport','issueNumberDiv')"
	/>
<label><span>*</span>To Date</label> <input type="text"
	name="<%=TO_DATE%>" value="<%=currentDate %>" maxlength="30" class="date"
	validate="Pick a to date,date,yes" readonly="readonly"
	onblur="submitProtoAjaxWithDivName('inertnalIssue','stores?method=issueListReport','issueNumberDiv')"
	/> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onmouseover="submitProtoAjaxWithDivName('inertnalIssue','stores?method=issueListReport','issueNumberDiv')"
	onclick="setdate('<%=currentDate%>',document.inertnalIssue.<%=TO_DATE%>,event);submitProtoAjaxWithDivName('inertnalIssue','stores?method=issueListReport','issueNumberDiv')"
	  />

<div class="clear"></div>
<div id='issueNumberDiv'>
<label>Issue Number </label>
<select name="issueNumber"
	validate="Issue Number,String,no" onblur="submitProtoAjaxWithDivName('inertnalIssue','stores?method=issueListReport','issueNumberDiv')"
    onmouseup="submitProtoAjaxWithDivName('inertnalIssue','stores?method=issueListReport','issueNumberDiv')"
    onclick="submitProtoAjaxWithDivName('inertnalIssue','stores?method=issueListReport','issueNumberDiv')"
     onfocus="submitProtoAjaxWithDivName('inertnalIssue','stores?method=issueListReport','issueNumberDiv')"
	>
	<option value="">Select</option>

	<%for (StoreIssueM issueHeaIssueM :issueNumberList ) {%>
	<option value="<%=issueHeaIssueM.getIssueNo()%>"><%=issueHeaIssueM.getIssueNo() %></option>
	<%
	}
	%>
</select>
</div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button"
	onclick="submitForm('inertnalIssue','stores?method=generateInternalIssueReport','check()');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button"
	onclick="clearButton('inertnalIssue');" accesskey="a" tabindex=1 />
</div>
</form>




