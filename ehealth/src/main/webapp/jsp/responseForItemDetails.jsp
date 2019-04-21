<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasStoreItemDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%

Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
map = (Map<String,Object>) request.getAttribute("map");
}
List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
if(map.get("itemList") != null){
	itemList = (List<MasStoreItem>)map.get("itemList") ;
	}
List<MasStoreItemDetails> itemDetailsList = new ArrayList<MasStoreItemDetails>();
if(map.get("itemDetailsList") != null){
	itemDetailsList = (List<MasStoreItemDetails>)map.get("itemDetailsList") ;
	}
MasStoreItemDetails storeItemDetails = new MasStoreItemDetails();
MasStoreItem item = new MasStoreItem();
if(itemDetailsList.size()>0){
	storeItemDetails = itemDetailsList.get(0);
	item = storeItemDetails.getItem();
}else{
	item = itemList.get(0);
}

String flag ="";
if(map.get("flag")!=null){
	flag = (String)map.get("flag");
}

%>


<label><span>*</span> Group</label> 
<input	type="text" id="group" name="group" value="<%=item.getGroup().getGroupName() %>" readonly="readonly"/>

<div id="nameDiv">
<label><span>*</span> Item Type</label> 
<input	type="text" id="itemType" name="itemType" value="<%=(item.getItemType()!=null?item.getItemType().getItemTypeName():"") %>" readonly="readonly"/>


<label><span>*</span> Section</label> 
<input	type="text" id="section" name="section" value="<%=(item.getSection()!=null?item.getSection().getSectionName():"") %>" readonly="readonly"/>
<div class="clear"></div>

<label><span>*</span>Class</label> 
<input	type="text" id="itemClass" name="itemClass" value="<%=(item.getItemClass()!=null?item.getItemClass().getItemClassName():"") %>" readonly="readonly"/>

<label><span>*</span>Category</label> 
<input	type="text" id="itemCategory" name="itemCategory" value="<%=(item.getItemCategory()!=null?item.getItemCategory().getItemCategoryName():"") %>" readonly="readonly"/>


</div>

<label><span>*</span> Item Code</label> 
<input	type="text" id="pvmsNo" name="<%= CODE%>" value="<%=item.getPvmsNo() %>" disabled="disabled" readonly="readonly"	validate="Item Code,string,yes" onblur="checkPvmsForAlreadyExist();"	MAXLENGTH="10" tabindex=1 /> 
<div class="clear"></div>
<label><span>*</span> Item Name</label>
<input type="text"	name="<%= SEARCH_NAME%>" value="<%=item.getNomenclature() %>" disabled="disabled" validate="Nomenclature,string,yes"	MAXLENGTH="250" style="width: 558px;" tabindex=1 />

<label><span>*</span> Common Name</label>
<input type="text"	id="commonName" name="commonName" value="<%=item.getCommonName()!=null?item.getCommonName():"" %>" disabled="disabled" validate="Common Name,string,no"	maxlength="50"  tabindex=1 />




<div class="clear"></div>

<label><span>*</span> Unit</label> 
<input type="text"	id="<%= STORE_ITEM_CONVERSION_ID %>" name="<%= STORE_ITEM_CONVERSION_ID %>" value="<%=item.getItemConversion()!=null?item.getItemConversion().getItemUnitName():"" %>" disabled="disabled" validate="Common Name,string,yes"	maxlength="50"  tabindex=1 />




<label>KMSCL Item Code</label> 
<input type="text"	name="kmscl_item_code" value="<%=item.getKmsclItemCode()!=null?item.getKmsclItemCode():"" %>" validate="KMSCL Item Code,string,no"	MAXLENGTH="50" tabindex=1 />


<div class="clear"></div>

<%
if(flag.equalsIgnoreCase("med")){
%>

<label>High Value Drug</label>
<input	type="checkbox" name="<%=HIGH_VALUE_DRUG %>" id="hvd" value="y" disabled="disabled"	class="radioCheck" />

 <label>Schedule H Drug</label> 
<input type="checkbox"	name="<%=DANGEROUS_DRUG %>" value="y" id="dd" disabled="disabled" class="radioCheck" /> 



 <label>High Risk Medicine </label>
 <input type="checkbox"	name="<%=RATE_CONTRACT_ITEM %>" id="hrm" disabled="disabled" value="y" class="radioCheck" />
 
 <div class="clear"></div>
 
 <label>Controlled Drug</label>
 <input type="checkbox"	name="<%=CONTROLLED_DRUG %>" id="cd" disabled="disabled" value="y" class="radioCheck" /> 
 
  <label>OTC</label>
 <input type="checkbox"	name="otc" value="y" id="otc" disabled="disabled" class="radioCheck" /> 
 
 <script>
<%
	if(item.getHighValueDrug()!=null && !item.getHighValueDrug().equalsIgnoreCase("y")){
%>
document.getElementById('hvd').checked=true;

<%}%>
<%
if(item.getDangerousDrug()!=null && !item.getDangerousDrug().equalsIgnoreCase("y")){
%>
document.getElementById('dd').checked=true;

<%}%>
<%
if(item.getRateContractItem()!=null && !item.getRateContractItem().equalsIgnoreCase("y")){
%>
document.getElementById('hrm').checked=true;

<%}%>
<%
if(item.getControlledDrug()!=null && !item.getControlledDrug().equalsIgnoreCase("y")){
%>
document.getElementById('cd').checked=true;
<%}%>
<%
if(item.getOtcType()!=null && !item.getOtcType().equalsIgnoreCase("y")){
%>
document.getElementById('otc').checked=true;

<%}%>
</script>
 
<%} %>

<div class="clear"></div>

<label>Min Stock</label> 
<input type="text" name="<%= MIN_STOCK%>"	value="<%=storeItemDetails.getMinStock()!=null?storeItemDetails.getMinStock().intValue():"" %>" validate="Min Stock,float,no" tabindex=1 /> 

<label>Max Stock</label> 
<input	type="text" name="<%= MAX_STOCK%>" value="<%=storeItemDetails.getMaxStock()!=null?storeItemDetails.getMaxStock().intValue():"" %>"	validate="Max Stock,float,no" tabindex=1 />


<label>Lead Time</label> 
<input type="text" name="<%= LEAD_TIME%>" value="<%=storeItemDetails.getLeadTime()!=null?storeItemDetails.getLeadTime():"" %>"	validate="Lead Time,string,no" MAXLENGTH="10" tabindex=1 /> 

<div class="clear"></div>

<label>Specification</label> 
<input type="text"	name="<%= SPECIFICATION%>" value="<%=item.getSpecification()!=null?item.getSpecification():"" %>"  disabled="disabled" validate="Specification,string,no"	MAXLENGTH="50" tabindex=1 />

<label>Slow Moving Days</label> 
<input type="text"	name="<%= SLOW_MOVING_DAYS%>" value="<%=storeItemDetails.getSlowMovingDays()!=null?storeItemDetails.getSlowMovingDays():"" %>"	validate="Slow Moving Days,int,no" MAXLENGTH="50" tabindex=1 />

<label>Fast Moving Days</label> 
<input type="text"	name="<%= FAST_MOVING_DAYS%>" value="<%=storeItemDetails.getFastMovingDays()!=null?storeItemDetails.getFastMovingDays():"" %>"	validate="Fast Moving Days,int,no" MAXLENGTH="50" tabindex=1 />

<div class="clear"></div>
<label>Non Moving Days</label> 
<input type="text" name="<%= NON_MOVING_DAYS%>" value="<%=storeItemDetails.getNonMovingDays()!=null?storeItemDetails.getNonMovingDays():"" %>"	validate="Non Moving Days,int,no" MAXLENGTH="50" tabindex=1 />

<label>Expiry</label>
<select name="<%=EXPIRY%>" id="expiry"	disabled="disabled" >
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>


<div class="clear"></div>
<label>VED</label> 
<select name="ved" 	id="ved" tabindex=1>
	<option value="0">Select</option>
	<option value="V">Vital</option>
	<option value="E">Essential</option>
	<option value="D">Desirable</option>
</select>

<label>ABC</label> 
<select name="abc"	id="abc" tabindex=1>
	<option value="0">Select</option>
	<option value="A">A</option>
	<option value="B">B</option>
	<option value="C">C</option>
</select>


<%
if(flag.equalsIgnoreCase("med")){
%>

<label>Temperature</label> 
<select name="<%=TEMPERATURE %>"	disabled="disabled" id="<%=TEMPERATURE %>" tabindex=1>
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

<div class="clear"></div>
<label>Min Temperature</label> 
<input type="text" name="minTemperature"	disabled="disabled" value="<%=item.getTempratureMin()!=null?item.getTempratureMin():"" %>" validate="Min Temperature,float,no" tabindex=1 />


<label>Max Temperature</label> 
<input	type="text" name="maxTemperature" value="<%=item.getTempratureMax()!=null?item.getTempratureMax():"" %>"	disabled="disabled" validate="Max Temperature,float,no" tabindex=1 />
<%} %>
<label>Standard Availability</label> 

<input type="text" name="sa"	value="<%=item.getStandardAvailability()!=null?item.getStandardAvailability():""%>" readonly="readonly"/>


<label>ROL</label> 
<input type="text" name="<%=ROL%>"	value="<%=storeItemDetails.getRol()!=null?storeItemDetails.getRol():"" %>" validate="ROL,string,no" tabindex=1 />



<input type="hidden" name="storeItemDetailsId"	value="<%=storeItemDetails.getId()!=null?storeItemDetails.getId():"" %>" tabindex=1 />
<input type="hidden" name="itemId"	value="<%=item.getId()!=null?item.getId():"" %>" tabindex=1 />


<script>
<%
	if(item.getExpiry()!=null){
%>
document.getElementById('expiry').value='<%=item.getExpiry()%>'

<%}%>
<%
if(item.getVed()!=null){
%>
document.getElementById('ved').value='<%=item.getVed()%>'

<%}%>
<%
if(item.getAbc()!=null){
%>
document.getElementById('abc').value='<%=item.getAbc()%>'

<%}%>
<%
if(item.getTemprature()!=null){
%>
if(document.getElementById('temprature'))
	document.getElementById('temprature').value='<%=item.getTemprature()%>'

<%}%>
</script>