<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>


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
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
	List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
	if(map.get("itemGroupList") != null){
		itemGroupList = (List<MasStoreGroup>)map.get("itemGroupList") ;
	}
	if(map.get("masStoreItemList") != null){
		itemList = (List<MasStoreItem>)map.get("masStoreItemList") ;
	}
	if(map.get("storeItemBatchStockList") != null){
		storeItemBatchStockList = (List<StoreItemBatchStock>)map.get("storeItemBatchStockList") ;
	}
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
 <!--Patient Photo Place holder-->
<form name="stockRegisterReport" method="post">
<div class="titleBg">
<h2>Stock Register Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label> 
<input	type="text" name="<%= FROM_DATE %>" value="<%=currentDate%>"	class="date" maxlength="30" tabindex=1 validate="fromDate,date,yes"/> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.stockRegisterReport.<%= FROM_DATE%>,event);" />
<label><span>*</span> To Date </label> 
<input type="text"	name="<%= TO_DATE %>" value="<%=currentDate%>" class="date"	maxlength="30" tabindex=1 validate="toDate,date,yes"/> <img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.stockRegisterReport.<%= TO_DATE%>,true);" />
<div class="clear"></div>
<label>Item Group</label> 
<select name="<%=GROUP_NAME%>" id="itemGroupId"  
	onChange="submitProtoAjaxWithDivName('stockRegisterReport','/hms/hms/stores?method=getItemsForItemGroup','itemDiv');"
	onKeyUp="submitProtoAjaxWithDivName('stockRegisterReport','/hms/hms/stores?method=getItemsForItemGroup','itemDiv');">
	<option value="0">Select</option>
	<%for(MasStoreGroup masStoreGroup:itemGroupList){%>
	<option value="<%=masStoreGroup.getId()%>"><%=masStoreGroup.getGroupName()%></option>
	<%} %>
</select>
<div id="itemDiv">
<label>Item Name</label> 
<select name="<%=ITEM_NAME%>" id="itemName"  	
onChange="submitProtoAjaxWithDivName('stockRegisterReport','/hms/hms/stores?method=getBatchForItem','itemDiv1');"
onKeyUp="submitProtoAjaxWithDivName('stockRegisterReport','/hms/hms/stores?method=getBatchForItem','itemDiv1');">
	<option value="0">Select</option>
	<%for(MasStoreItem masStoreItem:itemList){%>
	<option value="<%=masStoreItem.getId()%>"><%=masStoreItem.getNomenclature()%></option>
	<%} %>
</select></div>

<div id="itemDiv1">

</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!--  <input type="button" class="buttonBig" value="Generate Report"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=printStockRegisterReport');"></input>-->
<input type="button" class="buttonBig" value="Generate Report New"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=printStockRegisterCentralStoreReport');"></input>
<input type="button" class="buttonBig" value="OpeningBal Report New"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=printStockRegisterCentralStoreReportOpening');"></input>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>