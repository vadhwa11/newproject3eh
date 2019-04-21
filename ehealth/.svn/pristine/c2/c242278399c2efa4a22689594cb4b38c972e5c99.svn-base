<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hrms.masters.business.MasSection"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreItemConversion"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="jkt.hms.masters.business.MasSalesTaxType"%>
<%@page import="jkt.hms.masters.business.MasStorePharmaIndex"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script language="javascript">
function openPopupWindow(tender_no){
	var url="/hms/hms/pharmacy?method=showManufacturerJsp";
	newwindow=window.open(url,'name','top=50,status=1,scrollbars=yes, left=50, height=600,width=1000');
}
</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
map = (Map<String,Object>) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
List<MasStoreItem> searchItemList = new ArrayList<MasStoreItem>();

List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();

List<MasItemType> itemTypeList = new ArrayList<MasItemType>();

List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();

List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();

List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();

List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();

List<MasItemType> masItemTypeList = new ArrayList<MasItemType>();

List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();

searchItemList = (List<MasStoreItem>)map.get("searchItemList");
storeSectionList = (List<MasStoreSection>)map.get("storeSectionList");
itemCategoryList = (List<MasItemCategory>)map.get("itemCategoryList");

masItemClassList = (List<MasItemClass>)map.get("masItemClassList");
itemConversionList = (List<MasStoreItemConversion>)map.get("itemConversionList");
if(map.get("groupList") != null){
groupList = (List<MasStoreGroup>)map.get("groupList") ;
}
if(map.get("itemTypeList") != null){
	itemTypeList = (List<MasItemType>)map.get("itemTypeList") ;
	}

if(map.get("masHospitalTypeList") != null){
	masHospitalTypeList = (List<MasHospitalType>)map.get("masHospitalTypeList") ;
	}

List<RouteOfAdministration> routeOfAdministrationList = new ArrayList<RouteOfAdministration>();

if(map.get("routeOfAdministrationList") != null){
	routeOfAdministrationList = (List<RouteOfAdministration>)map.get("routeOfAdministrationList") ;
	}
int orderNo=0;
if(map.get("orderNo") != null){
	orderNo=(Integer)map.get("orderNo");
	}

String userName = "";
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
if(map.get("message") != null){
	 String  message = (String)map.get("message");
	   %>
	   <h4><span><%=message %></span></h4>
	 <%} %><script type="text/javascript">

</script>
<div class="titleBg">
<h2>Item Master Global (Medical)</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Item Code</label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>Item Name</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2"  class="radiobutMargin" />
<input type="text" id="searchField" name="<%=SEARCH_FIELD%>" value="" validate="Code,string,no" maxlength="10" tabindex=1 />
<input type="hidden" name="colCode" value="pvms_no"/>
<input type="hidden" name="colName" value="nomenclature"/>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchItemGlobalMed','checkSearch')"	tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_item_list"/>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 />
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults">
<div id="searchtable"></div>
<%
if(searchItemList.size()>0)
{
String strForCode = (String)map.get("pvmsNo");
String strForCodeDescription = (String)map.get("nomenclature");
if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
{
%> <h4><a href="pharmacy?method=showItemGlobalMedJsp">Show All Records</a></h4> <%
 	}
 	}

 	if (searchItemList.size() == 0 && map.get("search") != null) {
 %><h4> <a href="pharmacy?method=showItemGlobalMedJsp">Show All Records</a></h4> <%
 	}
 %> <script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"],
[1,"<%= GROUP_ID %>"],
[2,"<%= ITEM_TYPE_ID %>"],
[3,"<%= SECTION_ID %>"],
[4,"<%= CODE%>"],
[5,"<%= SEARCH_NAME %>"],
[6,"commonName"],
[7,"<%= STORE_ITEM_CONVERSION_ID %>"],
[8,"<%= ITEM_CLASS_ID %>"],
[9,"<%= ITEM_CATEGORY_ID %>"],
[10,"<%= SPECIFICATION %>"],
[11,"<%= EXPIRY %>"],
[12,"<%= HIGH_VALUE_DRUG %>"],
[13,"<%= DANGEROUS_DRUG %>"],
[14,"<%= RATE_CONTRACT_ITEM %>"],
[15,"<%= CONTROLLED_DRUG %>"],
[16,"otc"],
[17,"<%= TEMPERATURE %>"],
[18,"minTemperature"],
[19,"maxTemperature"],
[20,"standardAvailability"],
[21,"<%= CHANGED_BY %>"],
[22,"<%= CHANGED_DATE %>"],
[23,"<%= CHANGED_TIME %>"],
[24,"<%= STATUS %>"],
[25,"kmscl_item_code"],
[26,"kmsclCategory"],
[27,"dispensingUnit"],
[28,"insulin"],[29,"expiryDays"]
,[30,"uomQty"]
,[31,"phItem"],
[32,"BagQuantityId"],
[33,"mixable"],
[34,"mixtureQuantity"],
[35,"mixtureUnit"],[36,"route"],
[37,"tapered"]];
statusTd = 24;
</script></div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<form name="item" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden"	name="<%=POJO_NAME %>" value="MasStoreItem" />
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="Nomenclature"/>
<input	type="hidden" name="title" value="Item"/>
<input type="hidden"	name="<%=JSP_NAME %>" value="item"/>
<input type="hidden"	name="<%=POJO_PROPERTY_CODE %>" value="PvmsNo"/>
<div class="clear"></div>
<div class="Block">

<label><span>*</span> Group</label> 
<select id="<%= GROUP_ID %>"	name="<%= GROUP_ID %>" validate="Group,string,yes" tabindex=1 onblur="submitProtoAjaxWithDivName('item','pharmacy?method=getItemTypeGLList&group='+this.value,'nameDiv');" >
	<option value="0">Select</option>
	<%
		for (MasStoreGroup masStoreGroup : groupList) {
	%>
	<option value="<%=masStoreGroup.getId ()%>"><%=masStoreGroup.getGroupName()%></option>
	<%
		}
	%>

	
</select>
<div id="nameDiv">
<label><span>*</span> Item Type</label> 
<select id="<%= ITEM_TYPE_ID %>"	name="<%=ITEM_TYPE_ID %>" validate="Item Type,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasItemType masItemType : itemTypeList) {
	%>
	<option value="<%=masItemType.getId ()%>"><%=masItemType.getItemTypeName()%></option>
	<%
		}
	%>

	
</select>


<label><span>*</span> Section</label> 
<select id="sectionId"	name="<%= SECTION_ID %>" validate="Section,string,yes" 	tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasStoreSection masStoreSection : storeSectionList) {
	%>
	<option value="<%=masStoreSection.getId ()%>"><%=masStoreSection.getSectionName()%></option>
	<%
		}
	%>

	
</select>
<label><span>*</span>Class</label> 
<select	name="<%= ITEM_CLASS_ID %>" id="<%=ITEM_CLASS_ID %>" validate="Class Name,string,yes"	tabindex="1">
	<option value="0">Select</option>
	<%
			for (MasItemClass masItemClass : masItemClassList) {
		%>
	<option value="<%=masItemClass.getId ()%>"><%=masItemClass.getItemClassName()%></option>
	<%
			}
		%>
</select>
<label><span>*</span>Category</label> 
<select	name="<%= ITEM_CATEGORY_ID %>" id="<%=ITEM_CATEGORY_ID %>" validate="Category,string,yes"	tabindex=1>
	<option value="0">Select</option>
	<%
			for (MasItemCategory masItemCategory : itemCategoryList) {
		%>
	<option value="<%=masItemCategory.getId ()%>"><%=masItemCategory.getItemCategoryName()%></option>
	<%
			}
		%>
</select>

</div>
<div id="bagDiv" style="display: none">
<label><span>*</span>Bag Capacity(In ml)</label>
<input type="text"	id="BagQuantityId" name="BagQuantity" 
validate="Bag Quantity,string,no" MAXLENGTH="50" style="width: 60px;" 	maxlength="3"  tabindex=1 />
<div class="clear"></div>
</div>
<label><span>*</span> Item Code</label> 
<input	type="text" id="pvmsNo" name="<%= CODE%>" value="<%=orderNo %>" readonly="readonly"	validate="Item Code,string,yes" onblur="checkPvmsForAlreadyExist();"	MAXLENGTH="10" tabindex=1 /> 

<label><span>*</span> Item Name</label>
<input type="text"	name="<%= SEARCH_NAME%>" value="" validate="Nomenclature,string,yes"	MAXLENGTH="250" style="width: 550px;" tabindex=1 />

<label><span>*</span> Common Name</label>
<input type="text"	id="commonName" name="commonName" value="" validate="Common Name,string,yes"	maxlength="50"  tabindex=1 />


<label><span>*</span> Unit</label> 
<select	name="<%= STORE_ITEM_CONVERSION_ID %>" validate="A/U,string,yes"	tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasStoreItemConversion masStoreItemConversion : itemConversionList) {
	%>
	<option value="<%=masStoreItemConversion.getId ()%>"><%=masStoreItemConversion.getItemUnitName()%></option>
	<%
		}
	%>
</select>

<label>Dispensing Unit</label> 
<select	name="dispensingUnit" id="dispensingUnit" validate="Dispensing unit,string,no"	tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasStoreItemConversion masStoreItemConversion : itemConversionList) {
	%>
	<option value="<%=masStoreItemConversion.getItemUnitName()%>"><%=masStoreItemConversion.getItemUnitName()%></option>
	<%
		}
	%>
</select>


<label>UOM Qty</label> 
<input type="text"	name="uomQty"  	id="uomQty" value="" validate="UOM Qty,float,no"	MAXLENGTH="15" tabindex=1 />



<label>KMSCL Item Code</label> 
<input type="text"	name="kmscl_item_code" value="" validate="KMSCL Item Code,string,no"	MAXLENGTH="50" tabindex=1 />


<label>KMSCL Category</label> 
<select name="kmsclCategory" id="kmsclCategory" validate="KMSCL Category,string,no">
	    <option value="">Select</option>
	    <option value="Primary">Primary</option>
	    <option value="Secondary">Secondary</option>
    </select>

<label>Specification</label> 
<input type="text"	name="<%= SPECIFICATION%>" value="" validate="Specification,string,no"	MAXLENGTH="50" tabindex=1 />

<label>Expiry</label>
<select name="<%=EXPIRY%>"	>
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

<div class="clear"></div>
<!-- added by amit das on 21-11-2016 -->
<label>Mixable</label> 
<select name="mixable" id="mixable" validate="Mixable,string,no">
	    <option value="N">No</option>
	    <option value="Y">Yes</option>
    </select>


<!-- added by amit das on 21-11-2016 -->
<label>Mixture Quantity</label> 
<input type="text"	name="mixtureQuantity" id="mixtureQuantity" value="" validate="Mixture Quantity,int,no"	MAXLENGTH="50" tabindex=1 />


<label>Mixture Unit</label> 
<select	name="mixtureUnit" id="mixtureUnit" validate="Mixture unit,string,no"	tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasStoreItemConversion masStoreItemConversion : itemConversionList) {
	%>
	<option value="<%=masStoreItemConversion.getItemUnitName()%>"><%=masStoreItemConversion.getItemUnitName()%></option>
	<%
		}
	%>
</select>

<div class="clear"></div>
<label>High Value Drug</label>
<input	type="checkbox" name="<%=HIGH_VALUE_DRUG %>" value="y"	class="inputRadiobutton" />

 <label>Schedule H Drug</label> 
<input type="checkbox"	name="<%=DANGEROUS_DRUG %>" value="y" class="inputRadiobutton" /> 



 <label>High Risk Medicine </label>
 <input type="checkbox"	name="<%=RATE_CONTRACT_ITEM %>" value="y" class="inputRadiobutton" />
 
 <div class="clear"></div>
 
 <label>Controlled Drug</label>
 <input type="checkbox"	name="<%=CONTROLLED_DRUG %>" value="y" class="inputRadiobutton" /> 


 <label>OTC</label>
 <input type="checkbox"	name="otc" value="y" class="inputRadiobutton" /> 

 <label>Insulin Injection</label>
 <input type="checkbox"	name="insulin" 	id="insulin" value="y" class="inputRadiobutton" /> 
 
<div class="clear"></div>
<label>Temperature</label> 
<select name="<%=TEMPERATURE %>"	id="<%=TEMPERATURE %>" tabindex=1 onchange="chaneTempField(this.value)">
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>


<label>Min Temperature</label> 
<input type="text" name="minTemperature" id="minTemperatureId"	value="" validate="Min Temperature,float,no" tabindex=1 />


<label>Max Temperature</label> 
<input	type="text" name="maxTemperature" id="maxTemperatureId" value=""	validate="Max Temperature,float,no" tabindex=1 />

<label>Expiry Days</label> 
<input	type="text" name="expiryDays" id="expiryDays" value=""	validate="Expiry Days,int,no" tabindex=1 />

<label>Standard Availability</label> 

<select name="standardAvailability"	id="standardAvailability" tabindex=1 multiple="multiple" class="multiple1" size="5" style="width:360px;" >
	<%
		for (MasHospitalType masHospitalType : masHospitalTypeList) {
	%>
	<option value="<%=masHospitalType.getHospitalTypeCode()%>"><%=masHospitalType.getHospitalTypeName()%></option>
	<%
		}
	%>
	
</select>

<div class="clear"></div>
<label>PH Item</label>
 <input type="checkbox"	name="phItem"  id="phItem"  value="y" class="inputRadiobutton" /> 

<label>Route</label> 
<select name="route"	id="route"   tabindex=1 >
	<option value="0">Select</option>
	<%
		for (RouteOfAdministration route : routeOfAdministrationList) {
	%>
	<option value="<%=route.getId()%>"><%=route.getRouteName()%></option>
	<%
		}
	%>

	
</select>

 <label>Tapered</label>
 <input type="checkbox"	name="tapered"  value="y" class="inputRadiobutton" /> 
 
<div class="clear"></div>
 
<div id="edited"></div>
<div class="clear"></div>

<input type="button" name="add" id="addbutton" value="Add"	class="button" onclick="submitForm('item','pharmacy?method=addItemGlobalMed','ValidateTemp')" accesskey="a" tabindex=1 style="display: inline" />
<input	type="button" name="edit" id="editbutton" value="Update"	style="display: none" class="button" onclick="submitForm('item','pharmacy?method=editItemGlobalMed&flag='+this.value,'ValidateTemp')"	accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" style="display: none" value="Activate" class="button"	onclick="submitForm('item','pharmacy?method=deleteItemGlobalMed&flag='+this.value)" accesskey="d"	tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="buttonHighlight" onclick="submitFormForButton('item','pharmacy?method=showItemGlobalMedJsp)" accesskey="d"	tabindex=1 accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="bottom">

<label>Changed By</label> 
<label class="value"><%=userName%></label>
<label>Changed Date</label> 
<label class="value"><%=date%></label> 
<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>

<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Item Group"
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= GROUP_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Item Type"
data_header[1][1] = "hide";
data_header[1][2] = 0;
data_header[1][3] = "<%= ITEM_TYPE_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Section"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= SECTION_ID %>";

data_header[3] = new Array;
data_header[3][0] = "Item Code."
data_header[3][1] = "data";
data_header[3][2] = "14%";
data_header[3][3] = "<%= CODE%>"

data_header[4] = new Array;
data_header[4][0] = "Item Name"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= SEARCH_NAME %>";


data_header[5] = new Array;
data_header[5][0] = "Common Name"
data_header[5][1] = "hide";
data_header[5][2] = "14%";
data_header[5][3] = "commonName";



data_header[6] = new Array;
data_header[6][0] = "Unit"
data_header[6][1] = "data";
data_header[6][2] = 0;
data_header[6][3] = "<%=STORE_ITEM_CONVERSION_ID %>"


data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=ITEM_CLASS_ID %>"


data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=ITEM_CATEGORY_ID %>"



	data_header[9] = new Array;
	data_header[9][0] = ""
	data_header[9][1] = "hide";
	data_header[9][2] = 0;
	data_header[9][3] = "<%=SPECIFICATION %>";


	data_header[10] = new Array;
	data_header[10][0] = ""
	data_header[10][1] = "hide";
	data_header[10][2] = 0;
	data_header[10][3] = "<%=EXPIRY %>";
data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=HIGH_VALUE_DRUG %>"


data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=DANGEROUS_DRUG %>"


data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%=RATE_CONTRACT_ITEM %>"

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%=CONTROLLED_DRUG %>"



data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "otc";


data_header[16] = new Array;
data_header[16][0] = "TEMPERATURE"
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%=TEMPERATURE %>";

data_header[17] = new Array;
data_header[17][0] = "Min TEMPERATURE"
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "minTemperature";


data_header[18] = new Array;
data_header[18][0] = "Max TEMPERATURE"
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "maxTemperature";

data_header[19] = new Array;
data_header[19][0] = "Standard Availability"
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "standardAvailability";


data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "<%=CHANGED_BY %>";

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "<%=CHANGED_DATE %>";

data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = 0;
data_header[22][3] = "<%=CHANGED_TIME %>";


data_header[23] = new Array;
data_header[23][0] = "Status"
data_header[23][1] = "data";
data_header[23][2] = 0;
data_header[23][3] = "<%=STATUS %>";




data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = 0;
data_header[24][3] = "kmscl_item_code";


data_header[25] = new Array;
data_header[25][0] = ""
data_header[25][1] = "hide";
data_header[25][2] = 0;
data_header[25][3] = "kmsclCategory";


data_header[26] = new Array;
data_header[26][0] = ""
data_header[26][1] = "hide";
data_header[26][2] = 0;
data_header[26][3] = "dispensingUnit";

data_header[27] = new Array;
data_header[27][0] = ""
data_header[27][1] = "hide";
data_header[27][2] = 0;
data_header[27][3] = "insulin";

data_header[28] = new Array;
data_header[28][0] = ""
data_header[28][1] = "hide";
data_header[28][2] = 0;
data_header[28][3] = "expiryDays";


data_header[29] = new Array;
data_header[29][0] = ""
data_header[29][1] = "hide";
data_header[29][2] = 0;
data_header[29][3] = "uomQty";


data_header[30] = new Array;
data_header[30][0] = ""
data_header[30][1] = "hide";
data_header[30][2] = 0;
data_header[30][3] = "phItem";

data_header[31] = new Array;
data_header[31][0] = ""
data_header[31][1] = "hide";
data_header[31][2] = 0;
data_header[31][3] = "BagQuantityId";

data_header[32] = new Array;
data_header[32][0] = ""
data_header[32][1] = "hide";
data_header[32][2] = 0;
data_header[32][3] = "mixable";


data_header[33] = new Array;
data_header[33][0] = ""
data_header[33][1] = "hide";
data_header[33][2] = 0;
data_header[33][3] = "mixtureQuantity";



data_header[34] = new Array;
data_header[34][0] = ""
data_header[34][1] = "hide";
data_header[34][2] = 0;
data_header[34][3] = "mixtureUnit";





data_header[35] = new Array;
data_header[35][0] = ""
data_header[35][1] = "hide";
data_header[35][2] = 0;
data_header[35][3] = "route";


data_header[36] = new Array;
data_header[36][0] = ""
data_header[36][1] = "hide";
data_header[36][2] = 0;
data_header[36][3] = "tapered";

data_arr = new Array();

<%	int counter = 0;
for(MasStoreItem masStoreItem : searchItemList){

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreItem.getId()%>

<% if(masStoreItem.getGroup() != null){ %>
<%	Iterator itrGroupList = groupList.iterator();
while(itrGroupList.hasNext())
{
MasStoreGroup masStoreGroup = (MasStoreGroup)itrGroupList.next();
if(masStoreItem.getGroup().getId().equals(masStoreGroup.getId()) && masStoreGroup.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][1] = "<%=masStoreGroup.getGroupName()%>"
<%}else if(masStoreItem.getId().equals(masStoreGroup.getId()) && masStoreGroup.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masStoreGroup.getGroupName()%>";
<%}
}	%>
<%}%>




<% 



if(masStoreItem.getItemType() != null){%>
<%
Iterator itrGridTypeList =itemTypeList.iterator();


while(itrGridTypeList.hasNext())
{
MasItemType masItemType = (MasItemType)itrGridTypeList.next();

if(masStoreItem.getItemType().getId().equals(masItemType.getId()) && masItemType.getStatus().equalsIgnoreCase("y")){

%>
data_arr[<%= counter%>][2] = "<%=masItemType.getItemTypeName()%>"
<%}else if(masStoreItem.getItemType().getId().equals(masItemType.getId()) && masItemType.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masItemType.getItemTypeName()%>";
<%} }	%>
<%}%>

<% if(masStoreItem.getSection() != null){%>
<%
Iterator itrGridSectionList =storeSectionList.iterator();
while(itrGridSectionList.hasNext())
{
MasStoreSection masStoreSection = (MasStoreSection)itrGridSectionList.next();
if(masStoreItem.getSection().getId().equals(masStoreSection.getId()) && masStoreSection.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][3] = "<%=masStoreSection.getSectionName()%>"
<%}else if(masStoreItem.getId().equals(masStoreSection.getId()) && masStoreSection.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masStoreSection.getSectionName()%>";
<%} }	%>
<%}%>

<% if(masStoreItem.getPvmsNo() != null){%>
data_arr[<%= counter%>][4] = "<%= masStoreItem.getPvmsNo() %>"
<%}else{%>
data_arr[<%= counter%>][4] = ""
<%}%>

<% if(masStoreItem.getNomenclature() != null){
StringBuffer output_str = new StringBuffer();
StringTokenizer s = new StringTokenizer(masStoreItem.getNomenclature().toString(),"\"");

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
data_arr[<%= counter%>][5] = "<%= output_str.toString()%>";
<%}%>

<% if(masStoreItem.getCommonName() != null){%>
data_arr[<%= counter%>][6] = "<%= masStoreItem.getCommonName()%>"
<%}else{%>
data_arr[<%= counter%>][6] = ""
<%}%>


<% if(masStoreItem.getItemConversion() != null){
%>
<%	Iterator itrGridItemConversionList = itemConversionList.iterator();
while(itrGridItemConversionList.hasNext())
{
MasStoreItemConversion masStoreItemConversion = (MasStoreItemConversion)itrGridItemConversionList.next();
if(masStoreItem.getItemConversion()!=null && masStoreItem.getItemConversion().getId().equals(masStoreItemConversion.getId()) && masStoreItemConversion.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][7] = "<%=masStoreItemConversion.getItemUnitName()%>"
<%}else if(masStoreItem.getItemConversion()!=null && masStoreItem.getItemConversion().getId().equals(masStoreItemConversion.getId()) && masStoreItemConversion.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=masStoreItemConversion.getItemUnitName()%>";
<%}
}	%>
<%}%>

<% if(masStoreItem.getItemClass() != null){%>
<%	Iterator itrGridItemClassList = masItemClassList.iterator();
while(itrGridItemClassList.hasNext())
{
MasItemClass masItemClass = (MasItemClass)itrGridItemClassList.next();
if(masStoreItem.getItemClass().getId().equals(masItemClass.getId()) && masItemClass.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][8] = "<%=masItemClass.getItemClassName()%>"
<%}else if(masStoreItem.getItemClass().getId().equals(masItemClass.getId()) && masItemClass.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][8] = "<font id='error'>*</font>Parent InActivated--<%=masItemClass.getItemClassName()%>";
<%}
}	%>
<%}%>

<% if(masStoreItem.getItemCategory() != null){%>
<%	Iterator itrGridItemCategoryList = itemCategoryList.iterator();
while(itrGridItemCategoryList.hasNext())
{
MasItemCategory masItemCategory = (MasItemCategory)itrGridItemCategoryList.next();
if(masStoreItem.getItemCategory().getId().equals(masItemCategory.getId()) && masItemCategory.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][9] = "<%=masItemCategory.getItemCategoryName()%>"
<%}else if(masStoreItem.getId().equals(masItemCategory.getId()) && masItemCategory.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=masItemCategory.getItemCategoryName()%>";
<%}
}	%>
<%}%>


<% if(masStoreItem.getSpecification() != null){%>
data_arr[<%= counter%>][10] = "<%= masStoreItem.getSpecification() %>"
<%}else{%>
data_arr[<%= counter%>][10] = ""
<%}%>

<% if(masStoreItem.getExpiry() != null){%>
data_arr[<%= counter%>][11] = "<%= masStoreItem.getExpiry() %>"
<%}else{%>
data_arr[<%= counter%>][11] = ""
<%}%>

<% if(masStoreItem.getHighValueDrug() != null){%>
data_arr[<%= counter%>][12] = "<%= masStoreItem.getHighValueDrug() %>"
<%}%>


<% if(masStoreItem.getDangerousDrug() != null){%>
data_arr[<%= counter%>][13] = "<%= masStoreItem.getDangerousDrug() %>"
<%}%>

<% if(masStoreItem.getRateContractItem() != null){%>
data_arr[<%= counter%>][14] = "<%= masStoreItem.getRateContractItem() %>"
<%}%>


<% if(masStoreItem.getControlledDrug() != null){%>
data_arr[<%= counter%>][15] = "<%= masStoreItem.getControlledDrug() %>"
<%}%>


<% if(masStoreItem.getOtcType() != null){%>
data_arr[<%= counter%>][16] = "<%= masStoreItem.getOtcType() %>"
<%}%>


<% if(masStoreItem.getTemprature() != null){%>
data_arr[<%= counter%>][17] = "<%= masStoreItem.getTemprature() %>"
<%}else{%>
data_arr[<%= counter%>][17] = ""
<%}%>



<% if(masStoreItem.getTempratureMin() != null){%>
data_arr[<%= counter%>][18] = "<%= masStoreItem.getTempratureMin() %>"
<%}else{%>
data_arr[<%= counter%>][18] = ""
<%}%>

<% if(masStoreItem.getTempratureMax() != null){%>
data_arr[<%= counter%>][19] = "<%= masStoreItem.getTempratureMax() %>"
	<%}else{%>
	data_arr[<%= counter%>][19] = ""
	<%}%>
	
	<%if(masStoreItem.getStandardAvailability()!=null){%>
data_arr[<%= counter%>][20] = "<%=masStoreItem.getStandardAvailability()%>";
<%}else{%>
data_arr[<%= counter%>][20] = ""
<%}%>

data_arr[<%= counter%>][21] = "<%= masStoreItem.getLastChgBy()!=null?(masStoreItem.getLastChgBy().getId()!=null?masStoreItem.getLastChgBy().getId():"0" ):"0"%>"


<%if(masStoreItem.getLastChgDate()!=null){%>
data_arr[<%= counter%>][22] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreItem.getLastChgDate()) %>"
<%}else{%>
	data_arr[<%= counter%>][22] = "<%=(String)HMSUtil.getCurrentDateAndTime().get("currentDate")%>";

<%}%>
<%if(masStoreItem.getLastChgTime()!=null){%>
data_arr[<%= counter%>][23] = "<%= masStoreItem.getLastChgTime() %>"
<%}else{
	%>
	data_arr[<%= counter%>][23] = "<%=(String)HMSUtil.getCurrentDateAndTime().get("currentTime")%>";
<%}%>


<% if(masStoreItem.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][24] = "Active"
<%}else{%>
data_arr[<%= counter%>][24] = "InActive"
<%}%>

<% if(masStoreItem.getKmsclItemCode() != null){%>
data_arr[<%= counter%>][25] = "<%= masStoreItem.getKmsclItemCode() %>"
<%}else{%>
data_arr[<%= counter%>][25] = ""
<%}%>

<% if(masStoreItem.getKmsclCategory() != null){%>
data_arr[<%= counter%>][26] = "<%= masStoreItem.getKmsclCategory() %>"
<%}else{%>
data_arr[<%= counter%>][26] = ""
<%}%>

<% if(masStoreItem.getDispUnit()!= null){%>
data_arr[<%= counter%>][27] = "<%= masStoreItem.getDispUnit() %>"
<%}else{%>
data_arr[<%= counter%>][27] = ""
<%}%>


<% if(masStoreItem.getInsulinInjection() != null){%>
data_arr[<%= counter%>][28] = "<%= masStoreItem.getInsulinInjection() %>"
<%}%>

<% if(masStoreItem.getExpiryDays() != null){%>
data_arr[<%= counter%>][29] = "<%= masStoreItem.getExpiryDays() %>"
<%}else{%>
data_arr[<%= counter%>][29] = ""
<%}%>
<% if(masStoreItem.getADispQty() != null){%>
data_arr[<%= counter%>][30] = "<%= masStoreItem.getADispQty().intValue()%>"
	<%}else{%>
	data_arr[<%= counter%>][30] = ""
	<%}%>
	<% if(masStoreItem.getPhItem() != null){%>
	data_arr[<%= counter%>][31] = "<%= masStoreItem.getPhItem() %>"
	<%}else{%>
	data_arr[<%= counter%>][31] = ""
	<%}%>
	
	<% if(masStoreItem.getBagQuantity() != null){//added by govind 17-11-2016%>
	data_arr[<%= counter%>][32] = "<%= masStoreItem.getBagQuantity()%>"
		<%}else{%>
		data_arr[<%= counter%>][32] = "123"
		<%}%>		
	
		<% if(masStoreItem.getMixable() != null){//added by amit das  19-11-2016%>
			data_arr[<%= counter%>][33] = "<%= masStoreItem.getMixable()%>"
				<%}else{%>
				data_arr[<%= counter%>][33] = "N"
				<%}%>	
				
				<% if(masStoreItem.getMixtureQuantity() != null){//added by amit das 19-11-2016%>
					data_arr[<%= counter%>][34] = "<%= masStoreItem.getMixtureQuantity()%>"
						<%}else{%>
						data_arr[<%= counter%>][34] = "0"
						<%}%>	
						
				<% if(masStoreItem.getMixtureUnit() != null){//added by govind das 2-1-2017%>
				data_arr[<%= counter%>][35] = "<%= masStoreItem.getMixtureUnit()%>"
				<%}else{%>
				data_arr[<%= counter%>][35] = "0"
				<%}%>

						<% if(masStoreItem.getMixtureUnit() != null){//added by amit das 19-11-2016%>
							data_arr[<%= counter%>][35] = "<%= masStoreItem.getMixtureUnit()%>"
								<%}else{%>
								data_arr[<%= counter%>][35] = ""
								<%}%>		
								


								<% if(masStoreItem.getRoute() != null){%>
								<%	Iterator itrGridRouteList = routeOfAdministrationList.iterator();
								while(itrGridRouteList.hasNext())
								{
								RouteOfAdministration routeOfAdministration = (RouteOfAdministration)itrGridRouteList.next();
								if(masStoreItem.getRoute().getId().equals(routeOfAdministration.getId()) && routeOfAdministration.getStatus().equalsIgnoreCase("y")){
								%>
								data_arr[<%= counter%>][36] = "<%=routeOfAdministration.getRouteName()%>"
								<%}else if(masStoreItem.getRoute().getId().equals(routeOfAdministration.getId()) && routeOfAdministration.getStatus().equalsIgnoreCase("n")){%>
								data_arr[<%= counter%>][36] = "<font id='error'>*</font>Parent InActivated--<%=routeOfAdministration.getRouteName()%>";
								<%}
								}	%>
								<%}%>
								
								<% if(masStoreItem.getTapered() != null){%>
								data_arr[<%= counter%>][37] = "<%= masStoreItem.getTapered() %>"
								<%}else{%>
								data_arr[<%= counter%>][37] = ""
								<%}%>
<%
counter++;
}
%>

formName = "item"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>

<script>


function ValidateTemp(){
		var min ="";
		var max = "";
		  min = document.getElementById('minTemperatureId').value;
		  max = document.getElementById('maxTemperatureId').value;

		 if(min != "" && max != ""){
			 if( parseFloat(min)>parseFloat(max) )
			  {
 			  alert("Max. Temperature should be greater than Min Temperature")
			  document.getElementById('minTemperatureId').value ="";
 			 document.getElementById('maxTemperatureId').value ="";
 			  return false;
			  }
		  	}
		 
		 
		  return true;
  
		}
function chaneTempField(value){

	if(value == 'y'){
		document.getElementById('minTemperatureId').disabled =false ;
		document.getElementById('maxTemperatureId').disabled =false;
	}
	else{
		document.getElementById('minTemperatureId').value ="" ;
		document.getElementById('maxTemperatureId').value ="" ;
		document.getElementById('minTemperatureId').disabled =true ;
		document.getElementById('maxTemperatureId').disabled =true ;
	}
}
 function displayBagQuantity(value){
	var calssSelect = document.getElementById("classId");
	var classText = calssSelect.options[calssSelect.selectedIndex].text;
	
	if(classText=='Blood Bag'){
		document.getElementById("bagDiv").style.display = "block";
		//alert(classText);
		
	}
	
} 
</script>

