<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
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
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
	}
	List<MasStoreGroup>searchGroupList=new ArrayList<MasStoreGroup>();
	if(map.get("searchGroupList")!=null){
		searchGroupList=(List<MasStoreGroup>)map.get("searchGroupList");
	}
	
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
 <!--Patient Photo Place holder-->
<form name="stockRegisterReport" method="post">
<div class="titleBg">
<h2>Central Store ROL Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Date </label> 
<input	type="text" name="<%= TO_DATE %>" value="<%=currentDate%>"	class="date" maxlength="30" tabindex=1 /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.stockRegisterReport.<%= TO_DATE%>,event);" />
<label><span>*</span> Item Group </label> 
<select name="<%=GROUP_ID %>" id="groupId">
<option value="0">Select</option>
<%for(MasStoreGroup grp:searchGroupList){ %>
<option value="<%=grp.getId() %>"><%=grp.getGroupName() %></option>
<%} %>
</select></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!--  <input type="button" class="buttonBig" value="Generate Report"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=printStockRegisterReport');"></input>-->
<input type="button" class="buttonBig" value="Generate Report New"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=printDateWiseCentralStoreROLReport');"></input>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>