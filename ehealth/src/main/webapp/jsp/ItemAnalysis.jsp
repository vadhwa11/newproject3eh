<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.util.HMSUtil"%>
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
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

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
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
	function getData(){
	var  itemCategoryName="all";
	var manufacturerName="all";
	var supplierName="all";
	var itemCode="all";
	var pvmsNo=document.getElementById("nameItem").value;
	if(pvmsNo!=""){
	 var index1 = pvmsNo.lastIndexOf("[");
		      index1++;
		   
		    var index2 = pvmsNo.lastIndexOf("]");
		      pvmsNo = pvmsNo.substring(index1,index2);
	}
	var supplierId=document.getElementById("supplierId").value;
	if(supplierId!=0){
	var selectedIndex=document.getElementById("supplierId").selectedIndex

	supplierName=document.getElementById("supplierId").options[selectedIndex].text
	}
	var categoryId=document.getElementById("categoryId").value;
	if(categoryId!=0){
	var selectedIndex=document.getElementById("categoryId").selectedIndex

	itemCategoryName=document.getElementById("categoryId").options[selectedIndex].text
	}
	var manufactuererId=document.getElementById("manufactuererId").value;
	if(manufactuererId!=0){
	var selectedIndex=document.getElementById("manufactuererId").selectedIndex

	manufacturerName=document.getElementById("manufactuererId").options[selectedIndex].text
	}
	submitForm('vendorAnalysis','/hms/hms/stores?method=printVendorAnalysisReport&supplierName='+supplierName+'&manufacturerName='+manufacturerName+'&itemCategoryName='+itemCategoryName+'&pvmsNo='+pvmsNo+'');
	}
</script>



<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	 List<MasItemCategory>  itemCategoryList=new ArrayList<MasItemCategory>();
	 List<MasStoreSupplier>  supplierList=new ArrayList<MasStoreSupplier>();
	 List<MasManufacturer>manufacturerList=new ArrayList<MasManufacturer>();
	if(map.get("itemCategoryList")!=null){
		itemCategoryList=(List<MasItemCategory>)map.get("itemCategoryList");
	}
	if(map.get("supplierList")!=null){
		supplierList=(List<MasStoreSupplier>)map.get("supplierList");
	}
	if(map.get("manufacturerList")!=null){
		manufacturerList=(List<MasManufacturer>)map.get("manufacturerList");
	}
	%>
<form name="vendorAnalysis" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Vendor Analysis Report(Item Wise)</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> From Date </label> <input
	type="text" name="<%= FROM_DATE %>" value="<%=currentDate%>"
	class="date" maxlength="30" tabindex=1 validate="fromDate,date,yes"/> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.vendorAnalysis.<%= FROM_DATE%>,event);" />
<label><span>*</span> To Date </label> <input type="text"
	name="<%= TO_DATE %>" value="<%=currentDate%>" class="date"
	maxlength="30" tabindex=1 validate="toDate,date,yes"/> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.vendorAnalysis.<%= TO_DATE%>,true);" />
<div class="clear"></div>
<label>Supplier</label> <select name="supplierId" id="supplierId"
	  tabindex=1>
	<option value="0">Select</option>
	<% 
				  for (MasStoreSupplier  masStoreSupplier : supplierList){
			  %>
	<option value="<%=masStoreSupplier.getId ()%>"><%=masStoreSupplier.getSupplierName()%></option>
	<%}%>
</select> <label>Category</label> <select name="categoryId" id="categoryId"
	  tabindex=1>
	<option value="0">Select</option>
	<% 
				  for (MasItemCategory  masItemCategory : itemCategoryList){
			  %>
	<option value="<%=masItemCategory.getId ()%>"><%=masItemCategory.getItemCategoryName()%></option>
	<%}%>
</select> <label>Manufactuerer</label> <select name="manufactuererId"
	id="manufactuererId" tabindex=1  >
	<option value="0">Select</option>
	<% 
				  for (MasManufacturer  masManufacturer : manufacturerList){
			  %>
	<option value="<%=masManufacturer.getId ()%>"><%=masManufacturer.getManufacturerName()%></option>
	<%}%>
</select>
<div class="clear"></div>
<label>Item Name/Item Code</label> <input type="text" id="nameItem"
	name="nameItem" class="bigcaption" tabindex="1"   />
<div id="ac6update" class="autocomplete" style="display: none;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('nameItem','ac6update','stores?method=getItems',{parameters:'requiredField='+document.getElementById("nameItem").value+''});
			</script> <input type="hidden" name="reportName"
	value="VendorAnalysisReport_itemwise" />
<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"	onclick="getData()"> </input>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>