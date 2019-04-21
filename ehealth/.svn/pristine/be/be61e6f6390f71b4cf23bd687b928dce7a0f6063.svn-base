<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
List<MasStoreGroup>  groupList=new ArrayList<MasStoreGroup>();
List<MasItemCategory>itemCategoryList=new ArrayList<MasItemCategory> ();
List<MasItemType>  itemTypeList=new ArrayList<MasItemType>();

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

	if(map.get("groupList")!=null){
		groupList=(List<MasStoreGroup>)map.get("groupList");
	}
	if(map.get("itemCategoryList")!=null){
		itemCategoryList=(List<MasItemCategory>)map.get("itemCategoryList");
	}
	if(map.get("itemTypeList")!=null){
		itemTypeList=(List<MasItemType>)map.get("itemTypeList");
	}


%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<form name="fsnAnalysis" method="post">
<div class="titleBg">
<h2>FSN Analysis Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span>From Date </label> <input
	type="text" name="<%= FROM_DATE %>" value="<%=currentDate%>"
	class="date" maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.fsnAnalysis.<%= FROM_DATE%>,event);" />
<label><span>*</span>To Date </label> <input type="text"
	name="<%= TO_DATE %>" value="<%=currentDate%>" class="date"
	maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.fsnAnalysis.<%= TO_DATE%>,event);" />
<div class="clear"></div>
<label>Item Category </label> <select name="itemCategory"
	id="itemCategory">
	<option value="">select</option>
	<%for(MasItemCategory masItemCategory:itemCategoryList){ %>
	<option value="<%=masItemCategory.getId() %>"><%=masItemCategory.getItemCategoryName() %></option>
	<%} %>
</select> <label>Item Type </label> <select name="itemType" id="itemType">
	<option value="">select</option>
	<%for(MasItemType masItemType:itemTypeList){ %>
	<option value="<%=masItemType.getId() %>"><%=masItemType.getItemTypeName() %></option>
	<%} %>
</select>

<div class="clear"></div>
<label class="auto">Dangerous Drug</label> <input type="radio" Class="radioCheck"
	name="reportType" value="1" /> <label class="auto">Controlled
Drug</label> <input type="radio" Class="radioCheck" name="reportType" value="2" />
<label class="auto">Essential Drug </label> <input type="radio" Class="radioCheck"
	name="reportType" value="3" /> <label class="auto">High Value
Drug</label> <input type="radio" Class="radioCheck" name="reportType" value="4" />

<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"
	onclick="submitForm('fsnAnalysis','/hms/hms/stores?method=printFSNAnalysisReport');">
</input>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>