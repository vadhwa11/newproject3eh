<%@page import="jkt.hrms.masters.business.MasSection"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasStoreItemGeneric"%>
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
function openPopupWindow(tender_no)
{
var url="/hms/hms/pharmacy?method=showManufacturerJsp";
newwindow=window.open(url,'name','top=50,status=1,scrollbars=yes, left=50, height=600,width=1000');
}

function displayBagQuantityText(){
	var itemTypeSelect = document.getElementById("itemType");
	var selectedText = itemTypeSelect.options[itemTypeSelect.selectedIndex].text;
	//alert(selectedText)
	if(selectedText.match(/Blood/) ||selectedText.match(/blood/) ||selectedText.match(/bb/) ||selectedText.match(/Bag/) ){
		document.getElementById('bagDiv').style.display = 'block';
		itemTypeSelect.setAttribute("validate","yes");
		}
	else{
		document.getElementById('bagDiv').style.display = 'none';
		itemTypeSelect.setAttribute("validate","no");
	}
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
List<MasStoreItemGeneric> itemGenericList = new ArrayList<MasStoreItemGeneric>();


List<MasStoreSection> storeSectionList = new ArrayList<MasStoreSection>();

List<MasItemType> itemTypeList = new ArrayList<MasItemType>();

List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();

List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();

List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();

List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();

List<MasItemType> masItemTypeList = new ArrayList<MasItemType>();


searchItemList = (List<MasStoreItem>)map.get("searchItemList");
itemGenericList = (List<MasStoreItemGeneric>)map.get("itemGenericList");
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
<h2>Item Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label class="auto">Item Code</label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheckCol" />
<label class="auto"> Item Name </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2"  class="radioCheckCol1" />

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Code,string,no" maxlength="10" tabindex=1 />
<input	type="hidden" name="colCode" value="pvms_no"/>
<input	type="hidden" name="colName" value="nomenclature"/>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchItem','checkSearch')"	tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_item_list"/>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 />
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
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
%> <h4><a href="pharmacy?method=showItemJsp">Show All Records</a></h4> <%
 	}
 	}

 	if (searchItemList.size() == 0 && map.get("search") != null) {
 %><h4> <a href="pharmacy?method=showItemJsp">Show All Records</a></h4> <%
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
[10,"<%= ITEM_GENERIC_ID %>"],
[11,"<%= HIGH_VALUE_DRUG %>"],
[12,"<%= DANGEROUS_DRUG %>"],
[13,"<%= RATE_CONTRACT_ITEM %>"],
[14,"<%= CONTROLLED_DRUG %>"],
[15,"<%= MIN_STOCK %>"],
[16,"<%= MAX_STOCK %>"],
[17,"<%= LEAD_TIME %>"],
[18,"<%= SPECIFICATION %>"],
[19,"<%= SLOW_MOVING_DAYS %>"],
[20,"<%= FAST_MOVING_DAYS %>"],
[21,"<%= NON_MOVING_DAYS %>"],
[22,"<%= EXPIRY %>"],
[23,"<%= ALLERGY %>"],
[24,"ved"],
[25,"abc"],
[26,"<%= TEMPERATURE %>"],
[27,"minTemperature"],
[28,"maxTemperature"],
[29,"standardAvailability"],
[30,"<%= CHANGED_BY %>"],
[31,"<%= CHANGED_DATE %>"],
[32,"<%= CHANGED_TIME %>"],
[33,"<%= STATUS %>"]]
statusTd = 33;
</script></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
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
<select id="<%= GROUP_ID %>"	name="<%= GROUP_ID %>" validate="Group,string,yes" tabindex=1 onblur="submitProtoAjaxWithDivName('item','pharmacy?method=getItemTypeList&group='+this.value,'nameDiv');" >
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
<select id="<%= ITEM_TYPE_ID %>"	name="<%=ITEM_TYPE_ID %>" validate="Item Type,string,yes" tabindex=1 >
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


</div>

<label><span>*</span> Item Code</label> 
<input	type="text" id="pvmsNo" name="<%= CODE%>" value="<%=orderNo %>" readonly="readonly"	validate="Item Code,string,yes" onblur="checkPvmsForAlreadyExist();"	MAXLENGTH="10" tabindex=1 /> 

<label><span>*</span> Item Name</label>
<input type="text"	name="<%= SEARCH_NAME%>" value="" validate="Nomenclature,string,yes"	MAXLENGTH="250" style="width: 460px;" tabindex=1 />

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
<label><span>*</span>Class</label> 
<select	name="<%= ITEM_CLASS_ID %>" id="<%=ITEM_CLASS_ID %>" validate="Class Name,string,yes"	tabindex=1>
	<option value="0">Select</option>
	<%
			for (MasItemClass masItemClass : masItemClassList) {
		%>
	<option value="<%=masItemClass.getId ()%>"><%=masItemClass.getItemClassName()%></option>
	<%
			}
		%>
</select>

<div class="clear"></div>
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






 <label> Generic</label> <select name="<%=ITEM_GENERIC_ID%>"	validate="Generic,string,no">
	<%
		for (MasStoreItemGeneric masStoreItemGeneric : itemGenericList) {
	%>
	<option value="<%=masStoreItemGeneric.getId ()%>"><%=masStoreItemGeneric.getGenericName()%></option>
	<%
		}
	%>
</select>
<div id="bagDiv" style="display: none">
<label><span>*</span>Bag Capacity</label>
<input type="text"	id="BagQuantity" name="BagQuantity" value="" validate="Bag Quantity,string,no" MAXLENGTH="50" style="width: 60px;" 	maxlength="3"  tabindex=1 />
<label class="small">ml</label>
</div>
<div class="clear"></div>
<label>High Value Drug</label>
<input	type="checkbox" name="<%=HIGH_VALUE_DRUG %>" value="y"	class="radioCheck" />

 <label>Schedule H Drug</label> 
<input type="checkbox"	name="<%=DANGEROUS_DRUG %>" value="y" class="radioCheck" /> 



 <label>High Risk Medicine </label>
 <input type="checkbox"	name="<%=RATE_CONTRACT_ITEM %>" value="y" class="radioCheck" style="margin:0px 90px 0px 0px;" />
 
 <label>Controlled Drug</label>
 <input type="checkbox"	name="<%=CONTROLLED_DRUG %>" value="y" class="radioCheck" style="margin:0px;" /> 


<div class="clear"></div>

<label>Min Stock</label> 
<input type="text" name="<%= MIN_STOCK%>"	value="" validate="Min Stock,float,no" tabindex=1 /> 

<label>Max Stock</label> 
<input	type="text" name="<%= MAX_STOCK%>" value=""	validate="Max Stock,float,no" tabindex=1 />


<label>Lead Time</label> 
<input type="text" name="<%= LEAD_TIME%>" value=""	validate="Lead Time,string,no" MAXLENGTH="10" tabindex=1 /> 

<div class="clear"></div>

<label>Specification</label> 
<input type="text"	name="<%= SPECIFICATION%>" value="" validate="Specification,string,no"	MAXLENGTH="50" tabindex=1 />

<label>Slow Moving Days</label> 
<input type="text"	name="<%= SLOW_MOVING_DAYS%>" value=""	validate="Slow Moving Days,int,no" MAXLENGTH="50" tabindex=1 />

<label>Fast Moving Days</label> 
<input type="text"	name="<%= FAST_MOVING_DAYS%>" value=""	validate="Fast Moving Days,int,no" MAXLENGTH="50" tabindex=1 />

<div class="clear"></div>
<label>Non Moving Days</label> 
<input type="text" name="<%= NON_MOVING_DAYS%>" value=""	validate="Non Moving Days,int,no" MAXLENGTH="50" tabindex=1 />

<label>Expiry</label>
<select name="<%=EXPIRY%>"	>
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

<label>Allergy</label> 
<input type="text" name="<%= ALLERGY%>" value=""	validate="Allergy,String,no" MAXLENGTH="50" tabindex=1 /> 

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

<label>Temperature</label> 
<select name="<%=TEMPERATURE %>"	id="<%=TEMPERATURE %>" tabindex=1>
	<option value="">Select</option>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>

<div class="clear"></div>
<label>Min Temperature</label> 
<input type="text" name="minTemperature"	value="" validate="Min Temperature,float,no" tabindex=1 />


<label>Max Temperature</label> 
<input	type="text" name="maxTemperature" value=""	validate="Max Temperature,float,no" tabindex=1 />

<label>Standard Availability</label> 
<select name="standardAvailability"	id="standardAvailability" tabindex=1>
	<option value="">Select</option>
	<option value="SC">Sub Centre</option>
	<option value="PHC">PHC</option>
	<option value="CHC">CHC</option>
	<option value="DH">DH</option>
	<option value="WC">W&C</option>
	</select>
<div class="clear"></div>


<div class="clear"></div>
<div id="edited"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button" onclick="submitForm('item','pharmacy?method=addItem')" accesskey="a" tabindex=1 style="display: inline" />
<input	type="button" name="edit" id="editbutton" value="Update"	style="display: none" class="button" onclick="submitForm('item','pharmacy?method=editItem&flag='+this.value)"	accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" style="display: none" value="Activate" class="button"	onclick="submitForm('item','pharmacy?method=deleteItem&flag='+this.value)" accesskey="d"	tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="buttonHighlight" onclick="submitFormForButton('item','pharmacy?method=showItemJsp)" accesskey="d"	tabindex=1 accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
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
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<div class="paddingTop40"></div></form>



<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Item Group"
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= GROUP_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Item Type"
data_header[1][1] = "data";
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
data_header[9][0] = "Generic Name"
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=ITEM_GENERIC_ID %>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=HIGH_VALUE_DRUG %>"


data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=DANGEROUS_DRUG %>"


data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=RATE_CONTRACT_ITEM %>"

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%=CONTROLLED_DRUG %>"


data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%=MIN_STOCK %>";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "<%=MAX_STOCK %>";

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%=LEAD_TIME %>";



data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%=SPECIFICATION %>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "<%=SLOW_MOVING_DAYS %>";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "<%=FAST_MOVING_DAYS %>";

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "<%=NON_MOVING_DAYS %>";

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "<%=EXPIRY %>";

data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = 0;
data_header[22][3] = "<%=ALLERGY %>";

data_header[23] = new Array;
data_header[23][0] = ""
data_header[23][1] = "hide";
data_header[23][2] = 0;
data_header[23][3] = "ved";


data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = 0;
data_header[24][3] = "abc";


data_header[25] = new Array;
data_header[25][0] = "TEMPERATURE"
data_header[25][1] = "hide";
data_header[25][2] = 0;
data_header[25][3] = "<%=TEMPERATURE %>";

data_header[26] = new Array;
data_header[26][0] = "Min TEMPERATURE"
data_header[26][1] = "hide";
data_header[26][2] = 0;
data_header[26][3] = "minTemperature";


data_header[27] = new Array;
data_header[27][0] = "Max TEMPERATURE"
data_header[27][1] = "hide";
data_header[27][2] = 0;
data_header[27][3] = "maxTemperature";

data_header[28] = new Array;
data_header[28][0] = "Standard Availability"
data_header[28][1] = "hide";
data_header[28][2] = 0;
data_header[28][3] = "standardAvailability";


data_header[29] = new Array;
data_header[29][0] = ""
data_header[29][1] = "hide";
data_header[29][2] = 0;
data_header[29][3] = "<%=CHANGED_BY %>";

data_header[30] = new Array;
data_header[30][0] = ""
data_header[30][1] = "hide";
data_header[30][2] = 0;
data_header[30][3] = "<%=CHANGED_DATE %>";

data_header[31] = new Array;
data_header[31][0] = ""
data_header[31][1] = "hide";
data_header[31][2] = 0;
data_header[31][3] = "<%=CHANGED_TIME %>";


data_header[32] = new Array;
data_header[32][0] = "Status"
data_header[32][1] = "data";
data_header[32][2] = 0;
data_header[32][3] = "<%=STATUS %>";


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
<%}else if(masStoreItem.getId().equals(masStoreGroup.getId()) && masStoreGroup.getStatus().equals("n")){%>
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
<%}else if(masStoreItem.getId().equals(masStoreSection.getId()) && masStoreSection.getStatus().equals("n")){%>
data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masStoreSection.getSectionName()%>";
<%} }	%>
<%}%>

<% if(masStoreItem.getPvmsNo() != null){%>
data_arr[<%= counter%>][4] = "<%= masStoreItem.getPvmsNo() %>"
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
if(masStoreItem.getItemConversion().getId().equals(masStoreItemConversion.getId()) && masStoreItemConversion.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][7] = "<%=masStoreItemConversion.getItemUnitName()%>";
<%}else if(masStoreItem.getId().equals(masStoreItemConversion.getId()) && masStoreItemConversion.getStatus().equalsIgnoreCase("n")){%>
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
<% if(masStoreItem.getItemGeneric() != null){%>
<%	Iterator itrGridItemGenericList = itemGenericList.iterator();
while(itrGridItemGenericList.hasNext())
{
MasStoreItemGeneric masStoreItemGeneric = (MasStoreItemGeneric)itrGridItemGenericList.next();
if(masStoreItem.getItemGeneric().getId().equals(masStoreItemGeneric.getId()) && masStoreItemGeneric.getStatus().equalsIgnoreCase("y")){
%>
data_arr[<%= counter%>][10] = "<%=masStoreItemGeneric.getGenericName()%>"
<%}else if(masStoreItem.getId().equals(masStoreItemGeneric.getId()) && masStoreItemGeneric.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][10] = "<font id='error'>*</font>Parent InActivated--<%=masStoreItemGeneric.getGenericName()%>";
<%}
}	%>
<%}else{%>
data_arr[<%= counter%>][10] = ""
<%}%>


<% if(masStoreItem.getHighValueDrug() != null){%>
data_arr[<%= counter%>][11] = "<%= masStoreItem.getHighValueDrug() %>"
<%}%>


<% if(masStoreItem.getDangerousDrug() != null){%>
data_arr[<%= counter%>][12] = "<%= masStoreItem.getDangerousDrug() %>"
<%}%>

<% if(masStoreItem.getRateContractItem() != null){%>
data_arr[<%= counter%>][13] = "<%= masStoreItem.getRateContractItem() %>"
<%}%>


<% if(masStoreItem.getControlledDrug() != null){%>
data_arr[<%= counter%>][14] = "<%= masStoreItem.getControlledDrug() %>"
<%}%>

<% if(masStoreItem.getMinStock() != null){%>
data_arr[<%= counter%>][15] = "<%= masStoreItem.getMinStock() %>"
<%}else{%>
data_arr[<%= counter%>][15] = ""
<%}%>


<% if(masStoreItem.getMaxStock() != null){%>
data_arr[<%= counter%>][16] = "<%= masStoreItem.getMaxStock() %>"
<%}else{%>
data_arr[<%= counter%>][16] = ""
<%}%>


<% if(masStoreItem.getLeadTime() != null){%>
data_arr[<%= counter%>][17] = "<%= masStoreItem.getLeadTime() %>"
<%}else{%>
data_arr[<%= counter%>][17] = ""
<%}%>


<% if(masStoreItem.getSpecification() != null){%>
data_arr[<%= counter%>][18] = "<%= masStoreItem.getSpecification() %>"
<%}else{%>
data_arr[<%= counter%>][18] = ""
<%}%>

<% if(masStoreItem.getSlowMovingDays() != null){%>
data_arr[<%= counter%>][19] = "<%= masStoreItem.getSlowMovingDays() %>"
<%}else{%>
data_arr[<%= counter%>][19] = ""
<%}%>

<% if(masStoreItem.getFastMovingDays() != null){%>
data_arr[<%= counter%>][20] = "<%= masStoreItem.getFastMovingDays() %>"
<%}else{%>
data_arr[<%= counter%>][20] = ""
<%}%>

<% if(masStoreItem.getNonMovingDays() != null){%>
data_arr[<%= counter%>][21] = "<%= masStoreItem.getNonMovingDays() %>"
<%}else{%>
data_arr[<%= counter%>][21] = ""
<%}%>


<% if(masStoreItem.getExpiry() != null){%>
data_arr[<%= counter%>][22] = "<%= masStoreItem.getExpiry() %>"
<%}else{%>
data_arr[<%= counter%>][22] = ""
<%}%>

<% if(masStoreItem.getAllergy() != null){%>
data_arr[<%= counter%>][23] = "<%= masStoreItem.getAllergy() %>"
<%}else{%>
data_arr[<%= counter%>][23] = ""
<%}%>



<% if(masStoreItem.getVed() != null){%>
data_arr[<%= counter%>][24] = "<%= masStoreItem.getVed() %>"
<%}else{%>
data_arr[<%= counter%>][24] = ""
<%}%>




<% if(masStoreItem.getAbc() != null){%>
data_arr[<%= counter%>][25] = "<%= masStoreItem.getAbc() %>"
<%}else{%>
data_arr[<%= counter%>][25] = ""
<%}%>





<% if(masStoreItem.getTemprature() != null){%>
data_arr[<%= counter%>][26] = "<%= masStoreItem.getTemprature() %>"
<%}else{%>
data_arr[<%= counter%>][26] = ""
<%}%>



<% if(masStoreItem.getTempratureMin() != null){%>
data_arr[<%= counter%>][27] = "<%= masStoreItem.getTempratureMin() %>"
<%}%>
<% if(masStoreItem.getTempratureMax() != null){%>
data_arr[<%= counter%>][28] = "<%= masStoreItem.getTempratureMax() %>"
	<%}%>
	<%if(masStoreItem.getStandardAvailability()!=null){%>
data_arr[<%= counter%>][29] = "<%=masStoreItem.getStandardAvailability()%>";
<%}%>
<%if(masStoreItem.getLastChgBy()!=null){%>
data_arr[<%= counter%>][30] = "<%= masStoreItem.getLastChgBy() %>"
<%}else{
	%>
	data_arr[<%= counter%>][30] = "<%=userName%>";
<%}	%>


<%if(masStoreItem.getLastChgDate()!=null){%>
data_arr[<%= counter%>][31] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreItem.getLastChgDate()) %>"
<%}else{%>
	data_arr[<%= counter%>][31] = "<%=(String)HMSUtil.getCurrentDateAndTime().get("currentDate")%>";

<%}%>
<%if(masStoreItem.getLastChgTime()!=null){%>
data_arr[<%= counter%>][32] = "<%= masStoreItem.getLastChgTime() %>"
<%}else{
	%>
	data_arr[<%= counter%>][32] = "<%=(String)HMSUtil.getCurrentDateAndTime().get("currentTime")%>";
<%}%>


<% if(masStoreItem.getStatus().equalsIgnoreCase("Y") || masStoreItem.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][33] = "Active"
<%}else{%>
data_arr[<%= counter%>][33] = "InActive"
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

