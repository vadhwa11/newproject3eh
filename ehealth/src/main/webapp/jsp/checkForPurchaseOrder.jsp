<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
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
	Map<String, Object> map = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	List<StorePoHeader>storePoHeaderList=new ArrayList<StorePoHeader>();
	if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
	}
	if(map.get("storePoHeaderList")!=null){
		storePoHeaderList=(List<StorePoHeader>)map.get("storePoHeaderList");
	}
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<form name="stockRegisterReport" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Check For Purchase Order</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Select PO Number</label> 
<select	name="<%=PO_ID %>" id="sourceCombo" tabindex=1>
	<option value="0">Select</option>
	<%for(StorePoHeader storePoHeader:storePoHeaderList) {%>
	<option value="<%=storePoHeader.getId()%>"><%=storePoHeader.getPoNumber()%></option>
	<% }%>
</select> 
<input type="hidden" name="reportName" value="PurchaseOrderReport" validate="reportName,metachar,no"/>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=printReportForStores');"></input>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>