<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<%@page import="jkt.hms.masters.business.HesEquipmentCallLogEntry"%><script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
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
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	List<HesEquipmentCallLogEntry> equipmentList = new ArrayList<HesEquipmentCallLogEntry>();
	includedJsp = (String) map.get("includedJsp");
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>

<form name="equipmentCallLogSearchForm" method="post"">
<h2>Equipment Call Log Entry </h2>
<div class="clear"></div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form action="" method="post">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" /> <input type="hidden"
	name="searchthread" value="1" /> <input type="hidden" name="showposts"
	value="1" /> <input type="hidden" name="searchthreadid" value="85875" />
<div class="paddingTop15"></div>
<div class="clear"></div>

  <label>Date </label> <input type="text" name="<%=ON_DATE%>"
	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.equipmentCallLogSearchForm.<%= ON_DATE%>,event);" />
	
<label>Equipment Name :</label>
<select name="searchEquipment">
	<option value="" >-Select Equipment Name-</option>
<%
		for (HesEquipmentCallLogEntry hesEquipmentCallLogObj : equipmentList )
		{
%>
			<option value=<%=hesEquipmentCallLogObj.getEquipmentMaster().getId()%>><%=hesEquipmentCallLogObj.getEquipmentMaster().getEquipmentName()%></option>
<%
		}
%>
</select>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<label>Entry No :</label> <select name="searchEntryNo">
	<option value="" >-Select Entry No-</option>
<%
		for (HesEquipmentCallLogEntry hesEquipmentCallLogNo : equipmentList )
		{
%>
			<option value=<%=hesEquipmentCallLogNo.getId()%>><%=hesEquipmentCallLogNo.getEntryNo()%></option>
<%
		}
%>
</select>
          
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="image" src="/hms/jsp/images/go.gif" class="button"
	onClick="submitForm('equipmentCallLogSearchForm','hes?method=searchEquipmentCallLogEntryForm');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
<div class="clear"></div>

<jsp:include page="searchResultBlock.jsp" /> <%
 	if (includedJsp != null) {
 %>
<div class="clear"></div>
<jsp:include page="hes_Equipment_CallLog.jsp" /> <%
 	}
 %> <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script> <input type="button" name="Modify" class="button" value="Modify"
	onClick="submitForm('equipmentCallLogSearchForm','hes?method=showEquipmentCallLogUpdateJsp');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

