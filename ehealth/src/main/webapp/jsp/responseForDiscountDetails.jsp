<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response of discount details for update.
 * @author  Ritu
 * Create Date: 30th Jun,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * discount.jsp
 * Purpose of the JSP -  This is for Discount.
 * @author  Ritu
 * Create Date: 12th Nov,2007
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>
<%@page import="jkt.hms.masters.business.MasDiscountDiagnosis"%>
<%@page import="jkt.hms.masters.business.MasDiscountExclude"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@ page import="java.util.*"%>
<%@page import="java.util.List"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="jkt.hms.masters.business.MasBillType"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasRoomType"%>
<%@page import="jkt.hms.masters.business.MasCompany"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.MasDiscount"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<SCRIPT SRC="/hms/jsp/js/ssm.js" language="JavaScript1.2"></SCRIPT>
<script>
<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>

<%
	  	Map<String,Object> map = new HashMap<String, Object>();
	  	List<MasDiscount> discountList = new ArrayList<MasDiscount>();
	  	List<MasDiscount> disList = new ArrayList<MasDiscount>();
		
		
	  	List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
		List<MasCompany> companyList = new ArrayList<MasCompany>();
		List<MasBillType> billTypeList = new ArrayList<MasBillType>();
		List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<Object[]> ChargeCodeList = new ArrayList<Object[]>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployeeDependent> employeeDependentList = new ArrayList<MasEmployeeDependent>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
		
		//added by mritunjay Kumar Singh
	List<MasPatientType> patientTypeForSocialCategory=new ArrayList<MasPatientType>();
	List<MasPatientType> patientTypeForOtherCategory=new ArrayList<MasPatientType>();
	List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
	List<MasScheme> schemeList = new ArrayList<MasScheme>();
	List<MasDepartment> departments=new ArrayList<MasDepartment>();
	List<MasItemType> itemTypeList=new ArrayList<MasItemType>();
	List<MasStoreSection> sectionList=new ArrayList<MasStoreSection>();
	List<MasItemCategory> categorieList=new ArrayList<MasItemCategory>();
	List<MasItemClass> itemClasseList=new ArrayList<MasItemClass>();
	List<Object[]> storeItemList = new ArrayList<Object[]>();
	List<Object[]> itemList=new ArrayList<Object[]>();
	List<Object[]> chargeCodeList=new ArrayList<Object[]>();

	
	List<MasDiscountExclude> discountExcludeList = new ArrayList<MasDiscountExclude>();
	List<MasDiscountDiagnosis> diagnosiList = new ArrayList<MasDiscountDiagnosis>();
	

	MasDiscount masDiscount=null;
	
	
		if(request.getAttribute("map") != null){
	  		map = (Map)request.getAttribute("map");
	  	}
		if (map.get("disList") != null) {
			disList = (List) map.get("disList");
			if(disList.size()>0)
			{
				masDiscount=(MasDiscount)disList.get(0);
			}
		}

		if(map.get("itemList")!=null)
		{
			itemList=(List<Object[]>)map.get("itemList");
		}
		
		if(map.get("chargeCodeList")!=null)
		{
			chargeCodeList=(List<Object[]>)map.get("chargeCodeList");
		}
		if(map.get("discountList") != null){
	  		discountList = (List<MasDiscount>)map.get("discountList");
	  	}
	  	if(map.get("patientTypeList") != null){
	  		patientTypeList = (List)map.get("patientTypeList");
	  	}
	  	if(map.get("hospitalNameList")!=null){
	  		 hospitalNameList=(List<MasHospital>)map.get("hospitalNameList");
	  		}
	  	if(map.get("mhospitalTypetList")!=null){
	  		
	  		mhospitalTypetList = (List<MasHospitalType>)map.get("mhospitalTypetList");
	  	}
	  	if(map.get("companyList") != null){
	  		companyList = (List)map.get("companyList");
	  	}
	  	if(map.get("billTypeList") != null){
	  		billTypeList = (List)map.get("billTypeList");
	  	}
	  	if(map.get("roomTypeList") != null){
	  		roomTypeList = (List)map.get("roomTypeList");
	  	}
	  	if(map.get("mainChargeCodeList") != null){
	  		mainChargeCodeList = (List)map.get("mainChargeCodeList");
	  	}
	  	if(map.get("subChargeCodeList") != null){
	  		subChargeCodeList = (List)map.get("subChargeCodeList");
	  	}
	  	if(map.get("ChargeCodeList") != null){
	  		ChargeCodeList = (List)map.get("ChargeCodeList");
	  	}
	  	if(map.get("employeeList") != null){
	  		employeeList = (List)map.get("employeeList");
	  	}
	  	if(map.get("employeeDependentList") != null){
	  		employeeDependentList = (List)map.get("employeeDependentList");
	  	}
	  	if(map.get("accountList") != null){
	  		accountList = (List)map.get("accountList");
	  	}
	 	if(map.get("storeItemList") != null){
	  	storeItemList = (List)map.get("storeItemList");
	  	}
	 	
	 	if(map.get("patientTypeForSocialCategory") != null){
			patientTypeForSocialCategory= (List<MasPatientType>)map.get("patientTypeForSocialCategory");
		}
		if(map.get("patientTypeForOtherCategory") != null){
			patientTypeForOtherCategory= (List<MasPatientType>)map.get("patientTypeForOtherCategory");
		}		
		if(map.get("groupList") != null){
			groupList= (List<MasStoreGroup>)map.get("groupList");
		}
		if(map.get("schemeList") != null){
			schemeList= (List<MasScheme>)map.get("schemeList");
		}
		if(map.get("departments") != null){
			departments= (List<MasDepartment>)map.get("departments");
		}
		if(map.get("itemTypeList")!=null)
		{
			itemTypeList=(List<MasItemType>)map.get("itemTypeList");
		}

		if(map.get("sectionList")!=null)
		{
			sectionList=(List<MasStoreSection>)map.get("sectionList");
		}

		if(map.get("categorieList")!=null)
		{
			categorieList=(List<MasItemCategory>)map.get("categorieList");
		}

		if(map.get("itemClasseList")!=null)
		{
			itemClasseList=(List<MasItemClass>)map.get("itemClasseList");
		}
		
		if(map.get("diagnosiList")!=null)
		{
			diagnosiList=(List<MasDiscountDiagnosis>)map.get("diagnosiList");
		}
		System.out.println(diagnosiList.size());
		if(map.get("discountExcludeList")!=null)
		{
			discountExcludeList=(List<MasDiscountExclude>)map.get("discountExcludeList");
		}
		String message = "";
	  	if(map.get("message") != null){
			message = (String)map.get("message");
			}

	Map utilMap = new HashMap();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();

	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	
	
	  %>
<div class="clear"></div>


<%
String billtypedispensing="";
String billtypeservic="";
URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("account.properties");
try {
	Properties prop = new Properties();
	prop.load(new FileInputStream(new File(resourcePath.getFile())));
	billtypedispensing = prop
			.getProperty("billtypedispensing");
	billtypeservic = prop
			.getProperty("billtypeservic");
} catch (IOException e) {
	e.printStackTrace();
}

int dispensingId=0;
int serviceId=0;
for(MasBillType billType:billTypeList)
{
	if(billType.getBillTypeCode().equalsIgnoreCase(billtypeservic))
	{
		serviceId=billType.getId();
	}
	else if(billType.getBillTypeCode().equalsIgnoreCase(billtypedispensing))
	{
		dispensingId=billType.getId();
	}
}
%>

<%if(masDiscount!=null) {
String schemeDisplay="display:none;";
%>
<input type="hidden" name="discountId" value="<%=masDiscount.getId() %>" />

<div class="clear"></div>
<label>Scheme</label>
 <select id="schemeId" name="schemeId"	validate="Scheme,int,no" onchange="onChangeScheme();">
	<option value="0">Select</option>
	 <%
for(MasScheme masScheme : schemeList){
%>
<%if(masDiscount.getScheme()!=null && masDiscount.getScheme().getId()==masScheme.getId()){
	schemeDisplay="display:inline;";
	%>
<option value="<%=masScheme.getId() %>" selected="selected"><%=masScheme.getSchemeName()%></option>
<%}else{ %>
<%-- <option value="<%=masScheme.getId() %>"><%=masScheme.getSchemeName()%></option> --%>
<%} %>
	
	<%} %> 
</select>

			<label>Family Income Status</label>
			
			<%if(masDiscount.getBplStatus()!=null && masDiscount.getBplStatus().equalsIgnoreCase("y")){ %>
			<label class="auto">BPL</label>
			 <input type="radio" value="bpl" name="bplStatus" id="bplStatus1" checked="checked" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();"  /> 
			 <label class="auto">APL</label>
			 <input type="radio" value="apl" name="bplStatus" id="bplStatus2" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();" /> 
			
			<%}else if(masDiscount.getBplStatus()!=null && masDiscount.getBplStatus().equalsIgnoreCase("n")){ %>
			<label class="auto">BPL</label>
			 <input type="radio" value="bpl" name="bplStatus" id="bplStatus1" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();"  /> 
			 <label class="auto">APL</label>
			 <input type="radio" value="apl" name="bplStatus" id="bplStatus2" checked="checked" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();" /> 
			<%}else{ %>
			<label class="auto">BPL</label>
			 <input type="radio" value="bpl" name="bplStatus" id="bplStatus1" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();"  /> 
			 <label class="auto">APL</label>
			 <input type="radio" value="apl" name="bplStatus" id="bplStatus2" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();" /> 
			
			<%}%>
			
			
			<label>Social Category</label>
			 <select onblur="" tabindex="1" name="patientTypeId" id="patientTypeId" style="background-color: yellow;" onchange="onChangeSearchCriteria();" >
				<option value="0">Select</option>
				<%for(MasPatientType patientType:patientTypeForSocialCategory) {%>	
				<%if(masDiscount.getPatientType()!=null && masDiscount.getPatientType().getId()==patientType.getId()){ %>			
				<option value="<%=patientType.getId()%>" selected="selected"><%=patientType.getPatientTypeName()%></option>
				<%}else{ %>
								<option value="<%=patientType.getId()%>"><%=patientType.getPatientTypeName()%></option>
				
				<%} %>
				<%}%>
			</select>
			
			<label>Other Category</label> 
			<select name="otherCategory"  id="otherCategoryId">
								<option value="0">Select</option>
				
				<%for(MasPatientType patientType:patientTypeForOtherCategory) {%>
				<%if(masDiscount.getOtherCategory()!=null && masDiscount.getOtherCategory().getId()==patientType.getId()){ %>			
				<option value="<%=patientType.getId()%>" selected="selected"><%=patientType.getPatientTypeName()%></option>
				<%}else{ %>
								<option value="<%=patientType.getId()%>"><%=patientType.getPatientTypeName()%></option>
				
				<%} %>
				<%} %>
			</select>

<% String ipDisplay="display:none;";%>
<label> Patient Type</label> 
<select	name="<%=PATIENT_CATEGORY%>" id="<%=PATIENT_CATEGORY%>" validate="Patient Category,string,no"  onchange="onChagePatientType(this.value);">
	<option value="0">Select</option>
	<%if(masDiscount.getPatientCategory()!=null && masDiscount.getPatientCategory().equalsIgnoreCase("ip")){ %>	
			<%  ipDisplay="display:inline;";%>
			
	<option value="IP" selected="selected">InPatient</option>
				<%}else{%>
					<option value="IP">InPatient</option>
				
				<%} %>
				<%if(masDiscount.getPatientCategory()!=null && masDiscount.getPatientCategory().equalsIgnoreCase("op")){ %>			
	<option value="OP" selected="selected">OutPatient</option>
				<%}else{%>
	<option value="OP">OutPatient</option>
				
				<%} %>
</select>


<label id="departmentTypeLabel" style="<%=ipDisplay %>">Department</label> 
<select	id="<%=DEPARTMENT_ID %>" name="<%=DEPARTMENT_ID%>"	validate="Department,string,no" style="<%=ipDisplay %>">
	<option value="0">Select</option>
	<%
for(MasDepartment masDepartment :departments) {
%>
<%if(masDiscount.getDepartment()!=null && masDiscount.getDepartment().getId()==masDepartment.getId()){ %>
	<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{ %>
		<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	
	<%} %>
	<%}%>
</select>

<label id="roomTypeLabel" style="<%=ipDisplay %>"> Room Type </label> 
<select name="<%= ROOM_TYPE_ID %>" id="<%= ROOM_TYPE_ID %>"	validate="Room Type,string,no" style="<%=ipDisplay %>">
	<option value="0">Select</option>
	<%
for(MasRoomType masRoomType :roomTypeList){
%>
<%if(masDiscount.getRoomType()!=null && masDiscount.getRoomType().getId()==masRoomType.getId()){ %>
	<option value="<%=masRoomType.getId()%>" selected="selected"><%=masRoomType.getRoomTypeName()%></option>
	<%}else{ %>
	<option value="<%=masRoomType.getId()%>"><%=masRoomType.getRoomTypeName()%></option>	
	<%} %>
	<%}%>
</select> 


<% String billServiceDisplay="display:none;";
   String billDispensingDisplay="display:none;";
   int billTypeId=0;
%>

<label><span>*</span> Bill Type </label> 
<select id="billTypeId"	name="<%= BILL_TYPE_ID %>" validate="Bill Type,int,yes"	onchange="displayDrugList(this.id);">
	<option value="0">Select</option>
	<%
for(MasBillType masBillType :billTypeList){
	%>
	
	<%if(masDiscount.getBillType()!=null && masDiscount.getBillType().getId()==masBillType.getId()){ 
		billTypeId=masBillType.getId();
	%>
	<option value="<%=masBillType.getId()%>" selected="selected"><%=masBillType.getBillTypeName()%></option>
	<%}else{ %>
	<option value="<%=masBillType.getId()%>"><%=masBillType.getBillTypeName()%></option>
	<%} %>
	<%}%>
</select> 

<%if(billTypeId==serviceId){ 
	billServiceDisplay="display:inline;";
	    billDispensingDisplay="display:none;";
}else{ 
	billServiceDisplay="display:none;";
    billDispensingDisplay="display:inline;";
} %>

<label id="mainchargeId" style="<%=billServiceDisplay%>">Main Service Head </label> 
<select	id="mainChargeCodeId" name="<%=MAIN_CHARGECODE_ID %>"	validate="Main Service Head,string,no" 
onChange="populateSubChargeCode(this.value,'discountMaster');getCxcludeCharge();" style="<%=billServiceDisplay%>">
	<option value="0">Select</option>
	<%
for(MasMainChargecode masMainChargecode :mainChargeCodeList) {
%>

<%if(masDiscount.getMainChargecode()!=null && masDiscount.getMainChargecode().getId()==masMainChargecode.getId()){ %>
	<option value="<%=masMainChargecode.getId()%>" selected="selected"><%=masMainChargecode.getMainChargecodeName()%></option>
	<%}else{ %>
	<option value="<%=masMainChargecode.getId()%>"><%=masMainChargecode.getMainChargecodeName()%></option>
	<%} %>
	
	<%}%>
</select>
 
<label id="subChargeId" style="<%=billServiceDisplay%>">Sub Service Head </label> 
<select	id="subChargeCodeId" name="<%=SUB_CHARGECODE_ID %>"	validate="Sub Service Head,string,no"	
onChange="populateCharge(this.value,'discountMaster');displayMainCharge(this.value);getCxcludeCharge();" style="<%=billServiceDisplay%>">
	<option value="0">Select</option>
	<%
for(MasSubChargecode masSubChargecode :subChargeCodeList) {
%>

<%if(masDiscount.getSubChargecode()!=null && masDiscount.getSubChargecode().getId().intValue()==masSubChargecode.getId().intValue()){
	%>
	<option value="<%=masSubChargecode.getId()%>" selected="selected"><%=masSubChargecode.getSubChargecodeName()%></option>
	<%}else{ %>
	<option value="<%=masSubChargecode.getId()%>"><%=masSubChargecode.getSubChargecodeName()%></option>
	<%} %>
	
	<%}%>
</select> 

<label id="chargeId" style="<%=billServiceDisplay%>">Service </label> 
<select id="chargeCodeId"	name="<%= CHARGE_CODE_ID%>" validate="Service,string,no"	onchange="displayMainSubCharge(this.value)" style="<%=billServiceDisplay%>">
	<option value="0">Select</option>
	<%
for(Object[] masChargeCode :ChargeCodeList) {
%>

<%if(masDiscount.getChargeCode()!=null && masDiscount.getChargeCode().getId()==((Number)masChargeCode[1]).intValue()){ %>
	<option value="<%=masChargeCode[1]%>" selected="selected"><%=masChargeCode[0]%></option>
	<%}else{ %>
	<option value="<%=masChargeCode[1]%>"><%=masChargeCode[0]%></option>
	<%} %>
	<%}%>
</select>

<div style="<%=billDispensingDisplay%>" id="divForItemGroup">
<label id="">Item Group </label> 
<select id="<%= GROUP_ID%>"	name="<%= GROUP_ID%>" validate="Item Group,int,no"	onchange="onChangeItemGRoup()">
	<option value="0">Select</option>
	<%
for(MasStoreGroup masStoreGroup:groupList) {
	%>
	<%if(masDiscount.getGroup()!=null &&  masDiscount.getGroup().getId()==masStoreGroup.getId()) 
	{%>
	<option value="<%=masStoreGroup.getId()%>" selected="selected"><%=masStoreGroup.getGroupName()%></option>
	<%} else{ %>
	<option value="<%=masStoreGroup.getId()%>"><%=masStoreGroup.getGroupName()%></option>
	<%}%>
	<%}%>
</select>

<label id="">Item Type </label> 
<select id="<%= ITEM_TYPE%>"	name="<%= ITEM_TYPE%>" validate="Item Type,int,no"	onchange="onChangeItemType()">
	<option value="0">Select</option>
	<%
for(MasItemType itemType:itemTypeList) {
	%>
	<%if(masDiscount.getItemType()!=null &&  masDiscount.getItemType().getId()==itemType.getId()) 
	{%>
	<option value="<%=itemType.getId()%>" selected="selected"><%=itemType.getItemTypeName()%></option>
	<%} else{ %>
	<option value="<%=itemType.getId()%>"><%=itemType.getItemTypeName()%></option>
	<%}%>
	<%}%>
</select>

<label id="">Item Section </label> 
<select id="<%= SECTION_ID%>"	name="<%= SECTION_ID%>" validate="Item Section,int,no"	onchange="onChangeItemSection()">
	<option value="0">Select</option>
	<%
for(MasStoreSection masStoreSection:sectionList) {
	%>
	<%if(masDiscount.getItemSection()!=null &&  masDiscount.getItemSection().getId()==masStoreSection.getId()) 
	{%>
	<option value="<%=masStoreSection.getId()%>" selected="selected"><%=masStoreSection.getSectionName()%></option>
	<%} else{ %>
	<option value="<%=masStoreSection.getId()%>"><%=masStoreSection.getSectionName()%></option>
	<%}%>
	<%}%>
</select>

<label id="">Item Category </label> 
<select id="<%= ITEM_CATEGORY_ID%>"	name="<%= ITEM_CATEGORY_ID%>" validate="Item Category,int,no"	onchange="onChangeItemCategory()">
	<option value="0">Select</option>
	<%
for(MasItemCategory itemCategory:categorieList) {
	%>
	<%if(masDiscount.getItemCategory()!=null &&  masDiscount.getItemCategory().getId()==itemCategory.getId()) 
	{%>
	<option value="<%=itemCategory.getId()%>" selected="selected"><%=itemCategory.getItemCategoryName()%></option>
	<%} else{ %>
	<option value="<%=itemCategory.getId()%>"><%=itemCategory.getItemCategoryName()%></option>
	<%}%>
	<%}%>
	
</select>

<label id="">Item Class </label> 
<select id="<%= ITEM_CLASS_ID%>"	name="<%= ITEM_CLASS_ID%>" validate="Item Class,int,no"	onchange="onChangeItemClass()">
	<option value="0">Select</option>
	<%
for(MasItemClass itemClass:itemClasseList) {
	%>
	<%if(masDiscount.getItemClass()!=null &&  masDiscount.getItemClass().getId()==itemClass.getId()) 
	{%>
	<option value="<%=itemClass.getId()%>" selected="selected"><%=itemClass.getItemClassName()%></option>
	<%} else{ %>
	<option value="<%=itemClass.getId()%>"><%=itemClass.getItemClassName()%></option>
	<%}%>
	<%}%>
	</select>
	<label id="" >Drug </label>
<select	name="drug" id="drug" validate="Drug,string,no">
	<option value="0">Select</option>
	
	<%
for(Object[] masStoreItem :storeItemList) {
%>
<%if(masDiscount.getItem()!=null &&  masDiscount.getItem().getId()==((Number)masStoreItem[0]).intValue()) 
	{%>
<option value="<%=masStoreItem[0]%>" selected="selected"><%=masStoreItem[1]%></option>
	<%} else{ %>
<option value="<%=masStoreItem[0]%>"><%=masStoreItem[1]%></option>
	<%}%>
	
	<%}%>
</select>
</div>
<label id="fromAgelabel" style="<%=schemeDisplay%>"> From Age</label> 
<input type="text" style="<%=schemeDisplay%>"	name="fromAge" id="fromAge" value="<%=masDiscount.getFromAge()!=null ? masDiscount.getFromAge().intValue():"" %>" class="" validate="From Age,int,no"	MAXLENGTH="2" />
 

<label id="toAgeLabel"  style="<%=schemeDisplay%>"> To Age</label> 
<input type="text"	name="toAge"  id="toAge" class="" value="<%=masDiscount.getToAge()!=null ? masDiscount.getToAge().intValue():"" %>" validate="To Age,int,no"	MAXLENGTH="2"  style="<%=schemeDisplay%>"/> 
		
<label><span>*</span> From Date</label> 
<%
String fromDate="";
if(masDiscount.getEffectiveDateFrom()!=null && !masDiscount.getEffectiveDateFrom().equals("")){
	fromDate=HMSUtil.convertDateToStringTypeDateOnly(masDiscount.getEffectiveDateFrom()).trim();
}
else
{
	fromDate=curDate+"/"+month+"/"+year;
}

String toDate="";
if(masDiscount.getEffectiveDateTo()!=null && !masDiscount.getEffectiveDateTo().equals("")){
	toDate=HMSUtil.convertDateToStringTypeDateOnly(masDiscount.getEffectiveDateTo()).trim();
}

%>
<input type="text"	name="<%=EFFECTIVE_DATE_FROM%>" id="<%=EFFECTIVE_DATE_FROM%>" value="<%=fromDate%>" class="date"	
readonly="readonly" validate="Effective Date From,date,yes"	MAXLENGTH="30"   /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,yes"	
onclick="setdate('<%=fromDate%>',document.discountMaster.<%=EFFECTIVE_DATE_FROM%>,event)" />
<div class="clear"></div>
<label>To Date</label>

<input type="text"	name="<%=EFFECTIVE_DATE_TO%>" id="<%=EFFECTIVE_DATE_TO%>" value="<%=toDate %>" class="date" readonly="readonly" validate="Effective Date To,date,no" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no" onclick="setdate('<%=toDate %>',document.discountMaster.<%=EFFECTIVE_DATE_TO%>,event)" />



<label><span>*</span> Tarriff Type </label> 
<select id="<%=DISCOUNT_TYPE%>"	name="<%=DISCOUNT_TYPE%>" validate="Discount Type,string,yes"	MAXLENGTH="8" onchange="setFixedDiscountType(this.value);">
	<option value="0">Select</option>
	<option value="D">Discount</option>
	<option value="T">Tarriff</option>
	<option value="F">Fixed Value</option>
</select>

<script type="text/javascript">
document.getElementById('<%=DISCOUNT_TYPE%>').value="<%=masDiscount.getDiscountType()!=null?masDiscount.getDiscountType():"" %>";
</script>

<label id="varId"> Discount(%)</label>
<input 	id="varianceId" type="text" name="<%=DISCOUNT_PERCENTAGE %>" value="<%=masDiscount.getDiscountPercentage()!=null?masDiscount.getDiscountPercentage():"" %>"	validate="Discount percentage,float,no" MAXLENGTH="8" tabindex=1	onblur="disableField(this.id,this.value);" />
<label id="disLblId"> Discount Value</label> 
<input id="disValId" type="text"	name="<%=DISCOUNT_VALUE %>" value="<%=masDiscount.getDiscountValue()!=null?masDiscount.getDiscountValue():(masDiscount.getFixedValue()!=null?masDiscount.getFixedValue():"") %>" validate="Discount value,float,no"	MAXLENGTH="9" tabindex=1 onblur="disableField(this.id,this.value)" />


<label id="accounCodeId">Account Type Name</label> 
<select	id="accountId" name="<%= ACCOUNT_ID%>"	validate="Account Type Name,string,no">
	<option value="0">Select</option>
	<%
for(FaMasAccount masAccount :accountList) {
%>
<%if(masDiscount.getAccountId()!=null && masDiscount.getAccountId().intValue()==masAccount.getId()){ %>
	<option value="<%=masAccount.getId()%>" selected="selected"><%=masAccount.getAccDesc()%></option>

<%}else{ %>
	<option value="<%=masAccount.getId()%>"><%=masAccount.getAccDesc()%></option>

<%} %>
	<%}%>
</select>

<div class="clear"></div>
<div id="excludecharge" style="<%=billServiceDisplay%>">
<label id="">Exclude</label> 
<select multiple="5"	id="excludechargeId" name="excludechargeId" class="listBig" >
	<%
	for(Object[] charge : chargeCodeList)
	{
	%>
	
	<%boolean isSelected=false;
	for(MasDiscountExclude discountExclude:discountExcludeList){
		if(discountExclude.getCharge()!=null && discountExclude.getCharge().getId()==((Number)charge[1]).intValue())
		{
			isSelected=true;
			break;
		}
	}
	%>
	<%if(isSelected){ %>
	<option value="<%=charge[1]%>" selected="selected"><%=charge[0]%></option>
	
	<%}else { %>
	<option value="<%=charge[1]%>"><%=charge[0]%></option>
	
	<%} %>
	
	<%} %>
</select>

</div>

<div id="excludeitem" style="<%=billDispensingDisplay %>">
<label id="">Exclude</label> 

<select multiple="5"	id="excludeitemId" name="excludeitemId" class="listBig" >	<%
	for(Object[] item:itemList)
	{	
	%>
	
	<%boolean isSelected=false;
	for(MasDiscountExclude discountExclude:discountExcludeList){
		if(discountExclude.getItem()!=null && discountExclude.getItem().getId()==((Number)item[0]).intValue())
		{
			isSelected=true;
			break;
		}
	}
	%>
	<%if(isSelected){ %>
		<option value="<%=item[0]%>" selected="selected"><%=item[1]%></option>
	
	<%}else { %>
		<option value="<%=item[0]%>"><%=item[1]%></option>
	
	<%} %>
	<%} %>
</select>

</div>

<div class="clear"></div>

<label id="icdLabel" style="<%=schemeDisplay%>">ICD Code</label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd" style="<%=schemeDisplay%>"	class="auto"  size="55" onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDListwithID',{parameters:'requiredField=icd'});
</script>
<div class="clear"></div>
<label id="<%=DIAGNOSIS_ID%>Label" style="<%=schemeDisplay%>">Diagnosis</label>
<select name="<%=DIAGNOSIS_ID%>" size="5" multiple="65" id="diagnosisId" class="listBig2" style="<%=schemeDisplay%>">
<%for(MasDiscountDiagnosis diagnosis:diagnosiList){ %>
<option value="<%=diagnosis.getIcd().getId() %>"><%=diagnosis.getIcd().getIcdName()%></option>
<%} %>
</select>
<input type="button" class="buttonDel" id="buttonDelLabel" value="" style="<%=schemeDisplay%>" 	onclick="deleteDgItems(this,'diagnosisId');" align="right" />
<div class="clear"></div>
<div class="clear"></div>


<div id="edited"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	 style="display: none;"onClick="submitDiscountMaster();" accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update"  class="button" onClick="submitForm('discountMaster','billingMaster?method=editDiscountDetails','chkDate')" accesskey="u" tabindex=1 />
<%if(masDiscount.getStatus().equals("y")){ %>
<input type="button" name="Delete"	id="deletebutton" value="InActivate" class="button"  onclick="submitForm('discountMaster','billingMaster?method=deleteDiscount&flag='+this.value)" accesskey="d" tabindex=1 />
<%}else{ %>
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button"  onclick="submitForm('discountMaster','billingMaster?method=deleteDiscount&flag='+this.value)" accesskey="d" tabindex=1 />
<%} %> 
<input type="button" name="Reset"	value="Reset" class="buttonHighlight" accesskey="r"	onclick="clearFieldsOnReset();" />
<div class="clear"></div>
<script type="text/javascript">
setFixedDiscountType(document.getElementById('<%=DISCOUNT_TYPE%>').value);
</script>

<%}%>


