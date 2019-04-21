<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * administrativeSex.jsp  
 * Purpose of the JSP -  
 * @author Ritu
 * Create Date: 14th April,2009 
 * Revision Date:      
 * Revision By:
 * @version 1.4  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.BlPackageMedicineDetails"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasStoreItemGeneric"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>

<%
	Map map = new HashMap();
	List<BlPackageMedicineDetails> packageMedicinesList = new ArrayList<BlPackageMedicineDetails>();
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
	List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
	List<MasStoreItemGeneric> itemGenList = new ArrayList<MasStoreItemGeneric>();
	List<Object[]> itemList = new ArrayList<Object[]>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	if(map.get("packageMedicinesList") != null){
		packageMedicinesList = (List<BlPackageMedicineDetails>)map.get("packageMedicinesList");
	}
	if(map.get("itemCategoryList") != null){
		itemCategoryList = (List<MasItemCategory>)map.get("itemCategoryList");
	}
	if (map.get("itemTypeList") != null) {
		itemTypeList = (List<MasItemType>) map.get("itemTypeList");
	}
	if (map.get("itemGroupList") != null) {
		itemGroupList = (List<MasStoreGroup>) map.get("itemGroupList");
	}
	if (map.get("itemGenList") != null) {
		itemGenList = (List<MasStoreItemGeneric>)map.get("itemGenList");
	}
	if(map.get("itemList") != null){
		itemList = (List<Object[]>)map.get("itemList");
	}
	if(map.get("departmentList") != null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	String code = "";
	String desc = "";
	if(map.get("packageCode") != null){
		code = (String)map.get("packageCode");
	}
	if(map.get("packageDesc") != null){
		desc = (String)map.get("packageDesc");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	int packageId = 0;
	if(map.get("packageId") != null){
		packageId = (Integer)map.get("packageId");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		   <%} %>

<div class="titleBg">
<h2>Package Medicines</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript">
 
 formFields = [
   [0, "<%= PACKAGE_MEDICINE_ID%>", "id"], [1,"<%= ITEM_CATEGORY_ID%>"], [2,"<%= ITEM_ID %>"], [3,"<%= QUANTITY %>"], [4,"<%=AMOUNT  %>"], [5,"<%= DISCOUNT_TYPE %>"], [6,"<%= DISCOUNT_PERCENTAGE %>"], [7,"<%= DISCOUNT_VALUE %>"], [8,"<%= CHANGED_BY %>"], [9,"<%= CHANGED_DATE %>"], [10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS %>"],[12,"<%= DEPARTMENT_ID%>"],[13,"prevDiscountValue"],[14,"<%=RATE%>"],[15,"<%=DISPENSING_PRICE%>"] ];
  statusTd = 11;
 </script></div>

<form name="packageMedicines" method="post" action="">

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><input type="hidden"
	name="<%=PACKAGE_MEDICINE_ID %>" value="" /> <input type="hidden"
	name="<%=PACKAGE_ID %>" value="<%=packageId %>" /> <label>Package
Code</label> <label class="value"><%=code %></label> <label>Package
Description</label> <label class="value"><%=desc %></label>
 <%-- <label><span>*</span>
Department</label> <select name="<%=DEPARTMENT_ID %>"
	validate="Department,string,yes">
	<option value="0">Select</option>
	<%
		for(MasDepartment department : departmentList){
	%>
	<option value="<%=department.getId() %>"><%= department.getDepartmentName()%></option>
	<%} %>
</select> --%>

<div class="clear"></div>
<label>Item Type</label> <select id="itemTypeId"
	name="<%=ITEM_TYPE_ID %>" onchange="populateItem(this)">
	<option value="0">Select</option>
	<%
		for (MasItemType itemType : itemTypeList) {
	%>
	<option value="<%=itemType.getId() %>"><%=itemType.getItemTypeName()%></option>
	<%
		}
	%>
</select> <label>Item Category</label> <select id="itemCtgrId"
	name="<%=ITEM_CATEGORY_ID %>" onchange="populateItem(this)">
	<option value="0">Select</option>
	<%
		for(MasItemCategory itemCategory : itemCategoryList){
	%>
	<option value="<%=itemCategory.getId() %>"><%=itemCategory.getItemCategoryName() %></option>
	<%} %>
</select> <label>Item Group</label> <select id="itemGrpId"
	name="<%=ITEM_GROUP_ID %>" onchange="populateItem(this)">
	<option value="0">Select</option>
	<%
		for (MasStoreGroup storeGroup : itemGroupList) {
	%>
	<option value="<%=storeGroup.getId() %>"><%=storeGroup.getGroupName()%></option>
	<%
		}
	%>
</select>
<div class="clear"></div>
<label>Item Generic</label> <select id="itemGenId"
	name="<%=ITEM_GENERIC_ID %>" onchange="populateItem(this)">
	<option value="0">Select</option>
	<%
		for (MasStoreItemGeneric itemGeneric : itemGenList) {
	%>
	<option value="<%=itemGeneric.getId() %>"><%=itemGeneric.getGenericName()%></option>
	<%
		}
	%>
</select> <script type="text/javascript">
  var amtArray = new Array();
  </script> <label><span>*</span> Item</label>
<div id="testDiv"><select name="<%=ITEM_ID %>"
	onchange="if(this.value !=0){submitProtoAjaxWithDivName('packageMedicines','packageBilling?method=getDispensingPriceForItem','priceDiv');}"
	validate="Item,string,yes">
	<option value="0">Select</option>
	<%
	int i=0;
	   System.out.println("itemList"+itemList.size());
		for(Object[] object : itemList){
	
		 StringBuffer output_str = new StringBuffer();
			StringTokenizer s = new StringTokenizer(object[1].toString(),"\""); 
			
			while (s.hasMoreTokens())
			{
			output_str.append(s.nextToken());
			if (s.hasMoreTokens())
			{
			output_str.append("\\");
			output_str.append("\"");
			}
%>
	<script>
			amtArray[<%=i%>] = new Array();
			amtArray[<%=i%>][0] = <%=object[0]%>;
			amtArray[<%=i%>][1] = "<%=object[1]%>";
			
	</script> 
	<option value="<%=object[0] %>"><%= output_str%></option>
	<%} i++;} %>
</select></div>



<label><span>*</span> Quantity</label> <input type="text"
	name="<%=QUANTITY %>" id="qtyId" value=""
	onblur="calculateDispensingPrice(this.value);" />
<div class="clear"></div>
<label><span>*</span> Amount</label>
<div id="priceDiv"><input type="text" id="chargeAmtId"
	name="<%= DISPENSING_PRICE%>" value="" readonly="readonly" /> <input
	type="hidden" name="<%=RATE %>" id="rateId" value="" /></div>

<%-- <label><span>*</span> Discount Type</label> <select
	name="<%=DISCOUNT_TYPE%>" id="discountTypeId"
	validate="Discount Type,string,yes" onchange="changeLabel(this.value)">
	<option value="">Select</option>
	<option value="D">Discount</option>
	<option value="T">Tariff</option>
</select> <label id="distrfPerLbl"><span>*</span> Discount(%)</label> <input
	type="text" name="<%=DISCOUNT_PERCENTAGE %>" id="discounPercentId"
	value="" validate="Discount percentage,float,yes"
	onblur="calculateDiscountAmt(this.value);" MAXLENGTH="3" tabindex=1 />
<div class="clear"></div>
<label id="distrfValLbl">Discount Value</label> <input type="text"
	name="<%=DISCOUNT_VALUE %>" id="discountValId" value=""
	onblur="calculateDiscountPercent(this.value);"
	validate="Discount value,float,no" MAXLENGTH="9" tabindex=1 /> <label>Net
Amount</label> <input type="text" name="<%=NET_VALUE_MEDICINES %>"
	id="discountAmtId" value="" readonly="readonly"
	validate="Discount value,float,no" MAXLENGTH="9" tabindex=1 /> <input
	type="hidden" name="prevDiscountValue" value="" /> --%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('packageMedicines','packageBilling?method=savePackageMedicines');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('packageMedicines','packageBilling?method=updatePackageMedicines')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('packageMedicines','generalMaster?method=deleteAdministrativeSex&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="button"
	name="back" value="Back" class="button"
	onClick="submitFormCancel('packageMedicines','packageBilling?method=showBillingPackageListJsp')" />

<input type="hidden" name="<%=STATUS %>" value="" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Item Category"
data_header[0][1] = "hide";
data_header[0][2] = "25%";
data_header[0][3] = "<%= ITEM_CATEGORY_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Item"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= ITEM_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Quantity"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= QUANTITY%>"

data_header[3] = new Array;
data_header[3][0] = "Amount"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%= AMOUNT%>";

data_header[4] = new Array;
data_header[4][0] = "Discount Type"
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=DISCOUNT_TYPE %>";


data_header[5] = new Array;
data_header[5][0] = "Discount Percentage"
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=DISCOUNT_PERCENTAGE %>";

data_header[6] = new Array;
data_header[6][0] = "Discount Value"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=DISCOUNT_VALUE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=CHANGED_BY %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%=CHANGED_DATE %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=CHANGED_TIME %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=STATUS %>";


data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "<%=DEPARTMENT_ID%>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "prevDiscountValue";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "<%=RATE%>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "<%=DISPENSING_PRICE%>";

data_arr = new Array();

<%
	int counter = 0;
	for(BlPackageMedicineDetails packageMedicineDetails : packageMedicinesList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= packageMedicineDetails.getId()%>
<%
	for(Object[] item : itemList){
		if(packageMedicineDetails.getItem().getId().equals(item[0])){
			for(MasItemCategory masItemCategory : itemCategoryList){
				if(item[2].equals(masItemCategory.getId())){
			
%>

data_arr[<%= counter%>][1] = "<%=masItemCategory.getItemCategoryName()%>"
<%}
			}
		}
}%>
<% 
for(Object[] storeItem : itemList){

if(packageMedicineDetails.getItem().getId().equals(storeItem[0])){
StringBuffer output_str = new StringBuffer();
StringTokenizer s = new StringTokenizer(storeItem[1].toString(),"\""); 

while (s.hasMoreTokens())
{
output_str.append(s.nextToken());
if (s.hasMoreTokens())
{
output_str.append("\\");
output_str.append("\"");
}
}
%>
data_arr[<%= counter%>][2] = "<%= output_str.toString()%>";
<%}
}%>

data_arr[<%= counter%>][3] = "<%= packageMedicineDetails.getQuantity() %>"
data_arr[<%= counter%>][4] = "<%= packageMedicineDetails.getItemAmount() %>"
data_arr[<%= counter%>][5] = "<%= packageMedicineDetails.getDiscountType() %>"
data_arr[<%= counter%>][6] = "<%= packageMedicineDetails.getDiscountPercent() %>"
data_arr[<%= counter%>][7] = "<%= packageMedicineDetails.getDiscountAmount() %>"
data_arr[<%= counter%>][8] = "<%= packageMedicineDetails.getLastChgBy() %>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(packageMedicineDetails.getLastChgDate()) %>"
data_arr[<%= counter%>][10] = "<%= packageMedicineDetails.getLastChgTime() %>"
<% if(packageMedicineDetails.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>
<%
if(packageMedicineDetails.getDepartment() != null){
%>
<%
	for(MasDepartment department : departmentList){
		if(packageMedicineDetails.getDepartment().getId().equals(department.getId())){
%>
data_arr[<%= counter%>][12] = "<%=department.getId()%>"
<%}}
}%>
data_arr[<%= counter%>][13] = "<%= packageMedicineDetails.getDiscountAmount() %>"
data_arr[<%= counter%>][14] = "<%= packageMedicineDetails.getDispensingPrice() %>"
data_arr[<%= counter%>][15] = "<%= packageMedicineDetails.getItemAmount() %>"

<%
       counter++;
}
%>
 
formName = "packageMedicines"

nonEditable = ['<%= ITEM_TYPE_ID%>','<%=ITEM_CATEGORY_ID%>','<%= ITEM_GROUP_ID%>','<%=ITEM_GENERIC_ID%>','<%=ITEM_ID%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  


function calculateDispensingPrice(qty){
	var charge = 0;
	if(qty != ""){
		if(validateInteger(qty)){
			charge = document.getElementById('chargeAmtId').value;
				document.getElementById('chargeAmtId').value = (parseFloat(qty)*parseFloat(charge)).toFixed(2);
		}else{
			alert("Qunatity should be integer.");
			return false;
		}
	}
}

function calculateDiscountAmt(disPercent){
	var charge = 0;	
	var disAmt= 0;
	charge = document.getElementById('chargeAmtId').value;
	if(disPercent != ""){
		if(validateFloat(disPercent)){
			disAmt = parseFloat(charge)*parseFloat(disPercent)/100;
			document.getElementById('discountValId').value = disAmt.toFixed(2);
			if(document.getElementById('discountTypeId').value == "D"){
				document.getElementById('discountAmtId').value = parseFloat(charge)	- parseFloat(disAmt.toFixed(2));
			}else if(document.getElementById('discountTypeId').value == "T"){
				document.getElementById('discountAmtId').value = parseFloat(charge)	+ parseFloat(disAmt.toFixed(2));
			}
		}else{
			alert("Discount Amount should be integer or decimal.");
			return false;
		}
	}

}

function calculateDiscountPercent(disAmt){
	var charge = 0;	
	var disPercent= 0;
	charge = document.getElementById('chargeAmtId').value;
	if(disAmt != ""){
		if(validateFloat(disAmt)){
			disPercent = parseFloat(disAmt)*100/parseFloat(charge);
			document.getElementById('discounPercentId').value = disPercent;
			if(document.getElementById('discountTypeId').value == "D"){
				document.getElementById('discountAmtId').value = parseFloat(charge)	- parseFloat(disAmt.toFixed(2));
			}else if(document.getElementById('discountTypeId').value == "T"){
				document.getElementById('discountAmtId').value = parseFloat(charge)	+ parseFloat(disAmt.toFixed(2));
			}
		}else{
			alert("Discount Percent should be integer or decimal.");
			return false;
		}
	}


}


function changeLabel(distype){
	if(distype != ""){
		if(distype == "D"){
			document.getElementById('distrfPerLbl').innerHTML = 'Discount (%)';
			document.getElementById('distrfValLbl').innerHTML = 'Discount Value';
		}else if(distype == "T"){
			document.getElementById('distrfPerLbl').innerHTML = 'Tariff (%)';
			document.getElementById('distrfValLbl').innerHTML = 'Tariff Value';
		}
		
	var charge = 0;	
	charge = document.getElementById('chargeAmtId').value;
	if(document.getElementById('discountValId').value != ""){
		if(distype == "D"){
			document.getElementById('discountAmtId').value = parseFloat(charge)	- parseFloat(document.getElementById('discountValId').value);
		}else if(distype == "T"){
			document.getElementById('discountAmtId').value = parseFloat(charge)	+ parseFloat(document.getElementById('discountValId').value);
		}
	}		
	}

}

function populateItem(obj){
	var itemTp = document.getElementById('itemTypeId').value;
	var itemCtgry = document.getElementById('itemCtgrId').value;
	var itemGrp = document.getElementById('itemGrpId').value;
	var itemGen = document.getElementById('itemGenId').value;
	submitProtoAjax('packageMedicines','packageBilling?method=getItemName&itemCategory='+itemCtgry+'&itemType='+itemTp+'&itemGroup='+itemGrp+'&itemGeneric='+itemGen);
	
}
</script>