<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
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
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
//List<MasStoreGroup>  itemGroupList=new ArrayList<MasStoreGroup>();
//List<MasItemCategory> itemCategoryList=new ArrayList<MasItemCategory> ();
List<MasStoreItem>  itemList=new ArrayList<MasStoreItem>();

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

	//  if(map.get("itemCategoryList") != null){
	//   itemCategoryList = (List<MasItemCategory>)map.get("itemCategoryList");
	// }
	//   if(map.get("itemGroupList") !=null){
	//	   itemGroupList = (List<MasStoreGroup>)map.get("itemGroupList");
	//  }
	   if(map.get("itemList") !=null){
		   itemList =(List<MasStoreItem>)map.get("itemList");
	   }
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if(map.get("employeeList") !=null){
			employeeList =(List<MasEmployee>)map.get("employeeList");
		   }
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<form name="pharamacyConsumption" method="post">
<div class="titleBg">
<h2>Pharmacy Consumption Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label>
<input type="text" name="<%= FROM_DATE %>" value="<%=currentDate%>" class="date" maxlength="30" tabindex=1 validate="fromDate,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.pharamacyConsumption.<%= FROM_DATE%>,event);" />
<label><span>*</span> To Date </label>
<input type="text" name="<%= TO_DATE %>" value="<%=currentDate%>" class="date" maxlength="30" tabindex=1 validate="toDate,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.pharamacyConsumption.<%= TO_DATE%>,true);" />
<div class="clear"></div>
<label>Item</label> <select id="ItemId" name="<%=ITEM_ID%>">
	<option value="0">All</option>
	<%
	  if(itemList.size()>0){
	      for(MasStoreItem masStoreItem:itemList){
  	      %>
	       <option value="<%=masStoreItem.getId()%>"><%=masStoreItem.getNomenclature()%></option>
	<%} }%>
</select>

<label>Employee</label> <select id="empId" name="empId">
	<option value="0">All</option>
	<%
	  if(employeeList.size()>0){
	      for(MasEmployee masEmp:employeeList){

  	      %>
	       <option value="<%=masEmp.getId()%>"><%=masEmp.getFirstName()+" "+masEmp.getMiddleName()+" "+masEmp.getLastName()%></option>
	<%} }%>
</select>

<div class="clear"></div>
<label> Summary Type</label> <input type="radio" name="reportName" class="inputRadiobutton"
	value="PharmacyConsumptionSummary1" checked="checked" /> <label>
Detail Type</label> <input type="radio" name="reportName" class="inputRadiobutton"
	value="PharmacyConsumption1" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="buttonBig" value="Generate Report" onclick="submitForm('pharamacyConsumption','/hms/hms/stores?method=printPharmacyConsumptionReport');"></input>
<div class="clear"></div>
<div class="division"></div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>