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
<script>
var subChargeArray1 = new Array();
var chargeCodeArray = new Array();
var empDepArray = new Array();
</script>
<%
	  	Map<String,Object> map = new HashMap<String, Object>();
	  	List<MasDiscount> discountList = new ArrayList<MasDiscount>();

	  	List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
		List<MasCompany> companyList = new ArrayList<MasCompany>();
		List<MasBillType> billTypeList = new ArrayList<MasBillType>();
		List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<Object[]> ChargeCodeList = new ArrayList<Object[]>();
		// List<MasEmployee> employeeList = new ArrayList<MasEmployee>(); //commented by amit das on 11-05-2017
		List<Object[]> employeeList = new ArrayList<Object[]>(); //added by amit das on 11-05-2017
		List<MasEmployeeDependent> employeeDependentList = new ArrayList<MasEmployeeDependent>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<Object[]> storeItemList = new ArrayList<Object[]>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
		
		//added by mritunjay Kumar Singh
	List<MasPatientType> patientTypeForSocialCategory=new ArrayList<MasPatientType>();
	List<MasPatientType> patientTypeForOtherCategory=new ArrayList<MasPatientType>();
	List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
	List<MasScheme> schemeList = new ArrayList<MasScheme>();
	List<MasDepartment> departments=new ArrayList<MasDepartment>();
	
	
		if(request.getAttribute("map") != null){
	  		map = (Map)request.getAttribute("map");
	  	}
		if(map.get("discountList") != null){
	  		discountList = (List<MasDiscount>)map.get("discountList");
	  	}
		String schemeName="";
		String serviceName="";
		if(map.get("schemeName") != null){
			schemeName = (String)map.get("schemeName");
	  	}
		if(map.get("serviceName") != null){
			serviceName = (String)map.get("serviceName");
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
		
		String message = "";
	  	if(map.get("message") != null){
			message = (String)map.get("message");
		}

	Map utilMap = new HashMap();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();

	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
	  %>
<%
	if(!message.equals("")){
%>
<H4><span><%=message %></span></H4>

<%} %>

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

<div class="titleBg">
<h2>Tariff Master</h2>
</div>
<div class="Block">
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<div class="clear"></div>
<!-- <div class="search" id="threadsearch"><a href=""></a> 
<script
	type="text/javascript"> vbmenu_register("threadsearch"); </script>
	</div>
<div class="clear"></div>
thread search menu
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>-->
<form name="search" action="" method="post"> 
<label> Patient Type </label> 

<select id="" 	name="patientCatSearch" validate="Patient Category,alphanumeric,no">
	<option value="">Select</option>
	<option value="IP">InPatient</option>
	<option value="OP">OutPatient</option>
</select> 
<label style="width:120px;">Service Name</label>
<%if(!serviceName.equals("")){ %>
<input type="text" name="serviceName" id="serviceName" validate="Service Name,alphanumeric,no" value="<%=serviceName %>" onkeypress="return searchKeyPress(event);"/>
<%}else{ %>
<input type="text" name="serviceName" id="serviceName" validate="Service Name,alphanumeric,no" value="" onkeypress="return searchKeyPress(event);"/>
<%} %>
<label style="width:120px;">Scheme Name</label>
<%if(!schemeName.equals("")){ %>
<input type="text" name="schemeName" id="schemeName" validate="Scheme Name,alphanumeric,no" value="<%=schemeName %>" onkeypress="return searchKeyPress(event);"/>
<%}else{ %>
<input type="text" name="schemeName" id="schemeName" validate="Scheme Name,alphanumeric,no" value="" onkeypress="return searchKeyPress(event);"/>
<%} %>
<input type="hidden" name="searchFlag" id="searchFlag" value="1"/>
<%-- <label id="comSearchLable" style="display: none;"> Company</label>
<div id="comSearchId" style="display: none;">
<select	name="companySearch" validate="Company,string,no">
	<option value="0">Select</option>
	<%
for(MasCompany masCompany : companyList){
if (masCompany.getPatientType().getId().intValue()==1) {
%>
	<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
	<%} }%>
</select></div> --%>
<%-- <label id="insSearchLable" style="display: none;"> Company</label>
<div id="insSearchId" style="display: none;"><select
	name="companySearch" validate="InsuranceHmo,string,no">
	<option value="0">Select</option>
	<%
for(MasCompany masCompany : companyList){
	if (masCompany.getPatientType().getId().intValue()==7) {
%>
	<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
	<%} }%>
</select></div> --%>
<%-- <label id="prjSearchlbl" style="display: none;"> Project</label>
<div id="prjSearchDiv" style="display: none;">
<select	name="projectSearch" validate="Project,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
for(MasCompany masCompany : companyList){
if (masCompany.getPatientType().getId().intValue()==4) {
%>
	<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
	<%} }%>
</select></div> --%>
<label id="empSearchlbl" style="display: none;"> Employee</label>
<%-- <div id="empSearchDiv" style="display: none;">
<select	name="employeeSearch" id="empId" validate="Employee,string,no"	onchange="employeeDepntListForSearch();populateEmpDep(this);"	tabindex="1">
	<option value="0">Select</option>
	<%
for(MasEmployee masEmployee : employeeList){
%>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+ masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select></div> --%>

<%-- <label id="empDepSearchlbl" style="display: none;">  Employee Dependent</label>
<div id="empDepSearchDiv" style="display: none;"><select
	name="empDependentSearch" id="empDepId"
	validate="Employee Dependent,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
for(MasEmployeeDependent masEmployeeDependent : employeeDependentList){

%>
	<option value="<%=masEmployeeDependent.getId()%>"><%=masEmployeeDependent.getEmployeeDependentName()%></option>
	<%}%>
</select>

</div> --%>
<!-- <label> Patient Category </label> 
<select	name="patientCatSearch" validate="Patient Category,string,no">
	<option value="">Select</option>
	<option value="IP">InPatient</option>
	<option value="OP">OutPatient</option>
</select>  -->

<%-- <label id="mcSearchLblId"> Main Charge </label> 
<select id="mcSearchId"	name="mainChargeSearch" validate="Main Charge,string,no" onChange="populateSubChargeCodeForSearch(this.value)">
	<option value="0">Select</option>
	<%
for(MasMainChargecode masMainChargecode :mainChargeCodeList) {
%>
	<option value="<%=masMainChargecode.getId()%>"><%=masMainChargecode.getMainChargecodeName()%></option>
	<%}%>
</select> 
<label id="scSearchLblId">Sub Charge </label> 
<select id="scSearchId"	name="subChargeSearch" validate="Sub Charge,string,no"	onChange="populateChargeForSearch(this.value)">
	<option value="0">Select</option>
	<%
for(MasSubChargecode masSubChargecode :subChargeCodeList) {

%>
	<option value="<%=masSubChargecode.getId()%>"><%=masSubChargecode.getSubChargecodeName()%></option>
	<%}%>
</select>

<label id="chargeSearchId">Charge Code </label> 
<select	id="chargeCodeSearchId" name="chargeCodeSearch"
	validate="Charge Code,string,no">
	<option value="0">Select</option>
	<%
for(Object[] masChargeCode :ChargeCodeList) {

%>
	<option value="<%=masChargeCode[1]%>"><%=masChargeCode[0]%></option>
	<%}%>

</select>  --%>


<%-- <label>Hospital Type</label>
    <select name="instTypeId" id="instType" onchange="populateInst('tempId')" validate="Institute Type,int,no">
             	<option value="0">Select</option>
                 	<%for(MasHospitalType mht : mhospitalTypetList){ %>
            	 <option value="<%=mht.getId() %>"><%=mht.getHospitalTypeName()%></option>
   					<%} %>
	</select>
<label>Hospital Name</label>
<select name="hospitalId" id="hospital" onchange="populateInst('tempId')" validate="Hospital,int,no">
             	<option value="0">Select</option>
                 	<%for(MasHospital mh:hospitalNameList){ %>
            	 <option value="<%=mh.getId() %>"><%=mh.getHospitalName()%></option>
   					<%} %>
</select>
<div class="clear"></div> --%>


<input type="hidden" name="colCode" value="">
<input type="hidden" name="colName" value="">                                                                          <!-- searchDiscountList -->
<input type="button" name="Search" value="Search"  class="button"	onClick="submitForm('search','billingMaster?method=showDiscountJsp');" />
<input type="hidden" name="Report" value="Generate Report" 	class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 />

<div class="clear"></div>
<!-- <input type="button" name="Search" value="Search" class="buttonbig" onclick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex="1"/> -->
<!-- <input type="button" name="Report" value="Generate Report"	class="buttonbig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 />  -->
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_Discount" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>	
<!-- </div> -->
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
		if(map.get("flag") != null){
	%>
<div class="paddingTop15"></div>
<h4><a href="billingMaster?method=showDiscountJsp">Show All Records</a></h4> <%} %>
<script type="text/javascript">

formFields = [
  			[0, "<%= COMMON_ID%>", "id"], [1,"<%= PATIENT_TYPE_ID%>"], [2,"<%= COMPANY %>"], [3,"<%= INSURANCE_AMOUNT %>"],[4,"<%= EMPLOYEE_ID %>"],  [5,"<%= EMPLOYEE_DEPENDENT_ID%>"],
  			[6,"<%= PROJECT_ID %>"],[7,"<%= PATIENT_CATEGORY %>"],[8,"<%=BILL_TYPE_ID%>"],[9,"<%=ROOM_TYPE_ID%>"] ,[10,"<%=ITEM_ID%>"] ,[11,"<%=MAIN_CHARGECODE_ID%>"] ,[12,"<%=SUB_CHARGECODE_ID%>"],
  			[13,"<%=CHARGE_CODE_ID%>"],[14,"<%=EFFECTIVE_DATE_FROM%>"],[15,"<%=EFFECTIVE_DATE_TO%>"],[16,"<%=DISCOUNT_TYPE%>"],[17,"<%=DISCOUNT_PERCENTAGE%>"],[18,"<%=DISCOUNT_VALUE%>"],
  			[19,"<%=ACCOUNT_ID%>"],  [20,"<%= CHANGED_BY%>"], [21,"<%= CHANGED_DATE %>"],[22,"<%= CHANGED_TIME %>"],[23,"<%=STATUS%>"],[24,"Incomecategory"],[25,"OtherCategory"],[26,"fromAge"],[27,"toAge"]];
  	 statusTd = 23;

	<%-- formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= PATIENT_TYPE_ID%>"], [2,"<%= COMPANY %>"], [3,"<%= INSURANCE_AMOUNT %>"],[4,"<%= EMPLOYEE_ID %>"],  [5,"<%= EMPLOYEE_DEPENDENT_ID%>"],
			[6,"<%= PROJECT_ID %>"],[7,"<%= PATIENT_CATEGORY %>"],[8,"<%=BILL_TYPE_ID%>"],[9,"<%=ROOM_TYPE_ID%>"] ,[10,"<%=ITEM_ID%>"] ,[11,"<%=MAIN_CHARGECODE_ID%>"] ,[12,"<%=SUB_CHARGECODE_ID%>"],
			[13,"<%=CHARGE_CODE_ID%>"],[14,"<%=EFFECTIVE_DATE_FROM%>"],[15,"<%=EFFECTIVE_DATE_TO%>"],[16,"<%=DISCOUNT_TYPE%>"],[17,"<%=DISCOUNT_PERCENTAGE%>"],[18,"<%=DISCOUNT_VALUE%>"],
			[19,"<%=ACCOUNT_ID%>"],  [20,"<%= CHANGED_BY%>"], [21,"<%= CHANGED_DATE %>"],[22,"<%= CHANGED_TIME %>"],[23,"<%=STATUS%>"]];
	 statusTd = 23; --%>
</script>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Social Category"
data_header[0][1] = "hide";
data_header[0][2] = "20%";
data_header[0][3] = "<%= PATIENT_TYPE_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Company"
data_header[1][1] = "hide";
data_header[1][2] = "40%";
data_header[1][3] = "<%= COMPANY %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "25%";
data_header[2][3] = "<%= INSURANCE_AMOUNT%>";

data_header[3] = new Array;
data_header[3][0] = "Employee"
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "<%=EMPLOYEE_ID %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=EMPLOYEE_DEPENDENT_ID %>"

data_header[5] = new Array;
data_header[5][0] = "Project"
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=PROJECT_ID %>"

data_header[6] = new Array;
data_header[6][0] = "Patient Type"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=PATIENT_CATEGORY %>";

data_header[7] = new Array;
data_header[7][0] = "Bill Type"
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=BILL_TYPE_ID %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "20%";
data_header[8][3] = "<%= ROOM_TYPE_ID%>"

data_header[9] = new Array;
data_header[9][0] = "Item"
data_header[9][1] = "hide";
data_header[9][2] = "40%";
data_header[9][3] = "<%= ITEM_ID %>";

data_header[10] = new Array;
data_header[10][0] = "Main Service Head"
data_header[10][1] = "hide";
data_header[10][2] = "25%";
data_header[10][3] = "<%=MAIN_CHARGECODE_ID %>";

data_header[11] = new Array;
data_header[11][0] = "Sub Service Head "
data_header[11][1] = "hide";
data_header[11][2] = "40%";
data_header[11][3] = "<%=SUB_CHARGECODE_ID %>";

data_header[12] = new Array;
data_header[12][0] = "Service"
data_header[12][1] = "data";
data_header[12][2] = "20%";
data_header[12][3] = "<%=CHARGE_CODE_ID%>"

data_header[13] = new Array;
data_header[13][0] = "Date Effective From"
data_header[13][1] = "data";
data_header[13][2] = "15%";
data_header[13][3] = "<%=EFFECTIVE_DATE_FROM %>"

data_header[14] = new Array;
data_header[14][0] = "Date Effective To"
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "<%=EFFECTIVE_DATE_TO %>";

data_header[15] = new Array;
data_header[15][0] = "Discount Type"
data_header[15][1] = "hide";
data_header[15][2] = "15%";
data_header[15][3] = "<%=DISCOUNT_TYPE %>";

data_header[16] = new Array;
data_header[16][0] = "Percentage"
data_header[16][1] = "data";
data_header[16][2] = "20%";
data_header[16][3] = "<%= DISCOUNT_PERCENTAGE%>"

data_header[17] = new Array;
data_header[17][0] = "Discount Value"
data_header[17][1] = "data";
data_header[17][2] = "40%";
data_header[17][3] = "<%= DISCOUNT_VALUE %>";

data_header[18] = new Array;
data_header[18][0] = "Account"
data_header[18][1] = "hide";
data_header[18][2] = "25%";
data_header[18][3] = "<%=ACCOUNT_ID %>";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = "40%";
data_header[19][3] = "<%=CHANGED_BY %>";

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "<%=CHANGED_DATE %>"

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = 0;
data_header[21][3] = "<%=CHANGED_TIME %>"

data_header[22] = new Array;
data_header[22][0] = "Status"
data_header[22][1] = "data";
data_header[22][2] = "15%";
data_header[22][3] = "<%= STATUS%>";

data_header[23] = new Array;
data_header[23][0] = "Income Category"
data_header[23][1] = "hide";
data_header[23][2] = "15%";
data_header[23][3] = "Incomecategory";

data_header[24] = new Array;
data_header[24][0] = "Other Category"
data_header[24][1] = "hide";
data_header[24][2] = "15%";
data_header[24][3] = "OtherCategory";

data_header[25] = new Array;
data_header[25][0] = "From Age"
data_header[25][1] = "hide";
data_header[25][2] = "15%";
data_header[25][3] = "fromAge";

data_header[26] = new Array;
data_header[26][0] = "To Age"
data_header[26][1] = "hide";
data_header[26][2] = "15%";
data_header[26][3] = "toAge";


data_header[27] = new Array;
data_header[27][0] = "Scheme"
data_header[27][1] = "data";
data_header[27][2] = "15%";
data_header[27][3] = "scheme";


//[24,"Incomecategory"],[25,"OtherCategory"],[26,"fromAge"],[27,"toAge"]
data_arr = new Array();
<%
int counter = 0;
System.out.println("in jsp,........................."+subChargeCodeList.size());
System.out.println("in jsp,........................."+mainChargeCodeList.size());
System.out.println("in jsp,........................."+ChargeCodeList.size());

for(MasDiscount  discount :discountList){

%>

data_arr[<%= counter%>] = new Array();

data_arr[<%= counter%>][0] = <%= discount.getId()%>

<%-- <%
	for(MasPatientType patientType : patientTypeList){

		if(discount.getPatientType()!=null && discount.getPatientType().getId().equals(patientType.getId()) && discount.getStatus().equals("y")){
%>
data_arr[<%= counter%>][1] = "<%=patientType.getPatientTypeName()%>"
<%
		}else if(discount.getPatientType()!=null &&  discount.getPatientType().getId().equals(patientType.getId()) && discount.getStatus().equals("n")){
			%>
data_arr[<%= counter%>][1] = "<%=patientType.getPatientTypeName()%>";
		<%
		}else if(discount.getPatientType()==null){
			%>
			data_arr[<%= counter%>][1] =''
			<%
		}
		}%> --%>
// commented by amit das on 09-06-2017
// added by amit das on 09-06-2017
	data_arr[<%= counter%>][1] = '<%=discount.getPatientType()!=null?discount.getPatientType().getId():""%>'
	
		
<%-- <%
	for(MasCompany company : companyList){
		if(discount.getCompany() != null){
		if (discount.getPatientType().getId().intValue()==1 || discount.getPatientType().getId().intValue()==7) {
		if(discount.getCompany().getId() == company.getId() && discount.getStatus().equals("y")){
%>
data_arr[<%= counter%>][2] = "<%=company.getCompanyName()%>"
<%
		}else if(discount.getCompany().getId() == company.getId() && discount.getStatus().equals("n")){
			%>
data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=company.getCompanyName()%>";
		<%}
		}
		}else{%>
			data_arr[<%= counter%>][2] = "";
		<%
		}
		}%> --%>
// commented by amit das on 09-06-2017
// added by amit das on 09-06-2017
data_arr[<%= counter%>][2] = '<%=discount.getCompany()!=null?discount.getCompany().getId():""%>'
	
data_arr[<%= counter%>][3] = '<%=discount.getInsuranceAmt()!=null?discount.getInsuranceAmt():""%>'


<%-- <%
	// for(MasEmployee employee: employeeList){    // commented by amit das on 11-05-2017
		for(Object[] empObject : employeeList){    // added by amit das on 11-05-2017
		if(discount.getEmployee() != null){
			//if(discount.getEmployee().getId() == employee.getId() && discount.getStatus().equals("y")){ // commented by amit das on 11-05-2017
			if(discount.getEmployee().getId() == (Integer)empObject[0] && discount.getStatus().equals("y")){	 // added by amit das on 11-05-2017
%>
data_arr[<%= counter%>][4] = "<%=employee.getFirstName()%>" // commented by amit das on 11-05-2017
data_arr[<%= counter%>][4] = "<%=(String)empObject[1]%>"
<%
			/* }else if(discount.getEmployee().getId() == employee.getId() && discount.getStatus().equals("n")){ */
				}else if(discount.getEmployee().getId() == (Integer)empObject[0] && discount.getStatus().equals("n")){
			%>
			data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=employee.getFirstName()%>";
			// commented by amit das on 11-05-2017
			data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=(String)empObject[1]%>";
		<%}
		}else{%>
			data_arr[<%= counter%>][4] = "";
		<%}
		} } %> --%>
		// commented by amit das on 09-06-2017
		// added by amit das on 09-06-2017
		data_arr[<%= counter%>][4] = '<%=discount.getEmployee()!=null ? discount.getEmployee().getFirstName():""%>' 		

<%-- <%
	for(MasEmployeeDependent employeeDependent : employeeDependentList){
		if(discount.getEmployeeDependent() != null){
		if(discount.getEmployeeDependent().getId() == employeeDependent.getId() && discount.getStatus().equals("y")){
%>
data_arr[<%= counter%>][5] = "<%=employeeDependent.getEmployeeDependentName()%>"
<%
		}else if(discount.getEmployeeDependent().getId() == employeeDependent.getId() && discount.getStatus().equals("n")){
			%>
data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=employeeDependent.getEmployeeDependentName()%>";
		<%}
		}else{%>
			data_arr[<%= counter%>][5] = "";
		<%}
		}%> --%>
		
		// commented by amit das on 09-06-2017
		// added by amit das on 09-06-2017	
		data_arr[<%= counter%>][5] = '<%=discount.getEmployeeDependent()!=null? discount.getEmployeeDependent().getEmployeeDependentName():""%>'


<%-- <%
	for(MasCompany company : companyList){
		if (discount.getCompany() !=null && discount.getPatientType().getId().intValue()==4) {
		if(discount.getCompany().getId() == company.getId() && discount.getStatus().equals("y")){
%>
data_arr[<%= counter%>][6] = "<%=company.getCompanyName()%>"
<%
		}else if(discount.getCompany().getId() == company.getId() && discount.getStatus().equals("n")){
			%>
data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=company.getCompanyName()%>";
		<%}
		}else{%>
			data_arr[<%= counter%>][6] = "";
		<%}
		}%> --%>
		
		// commented by amit das on 09-06-2017
		// added by amit das on 09-06-2017	
		data_arr[<%= counter%>][6] = '<%=discount.getCompany()!=null ? discount.getCompany().getCompanyName():""%>'
		


		data_arr[<%= counter%>][7] = "<%=discount.getPatientCategory()!=null?discount.getPatientCategory():""%>"

<%-- <%
	for(MasBillType billType : billTypeList){
		if(discount.getBillType() != null){
if(discount.getBillType().getId() == billType.getId() && discount.getStatus().equals("y")){
%>
data_arr[<%= counter%>][8] = "<%=billType.getBillTypeName()%>"
<%
		}else if(discount.getBillType().getId() == billType.getId() && discount.getStatus().equals("n")){
			%>
data_arr[<%= counter%>][8] = "<font id='error'>*</font>Parent InActivated--<%=billType.getBillTypeName()%>";
		<%}}else{%>
			data_arr[<%= counter%>][8] = "";
		<%}
		}%> --%>
		// commented by amit das on 09-06-2017
		// added by amit das on 09-06-2017	
		data_arr[<%= counter%>][8] = '<%=discount.getBillType()!=null ? discount.getBillType().getBillTypeName():""%>'
		


<%
	for(MasRoomType roomType : roomTypeList){
		if(discount.getRoomType() != null){
if(discount.getRoomType().getId() == roomType.getId() && discount.getStatus().equals("y")){
%>
data_arr[<%= counter%>][9] = "<%=roomType.getRoomTypeName()%>"
<%
		}else if(discount.getRoomType().getId() == roomType.getId() && discount.getStatus().equals("n")){
			%>
data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=roomType.getRoomTypeName()%>";
		<%}}else{%>
			data_arr[<%= counter%>][9] = "";
		<%}
		}%>

<%-- <%
	for(Object[] item : storeItemList){
		if(discount.getItemId() != null){
	StringBuffer output_str = new StringBuffer();
	StringTokenizer s = new StringTokenizer(item[1].toString(),"\"");

	while (s.hasMoreTokens())
	{
	output_str.append(s.nextToken());
	if (s.hasMoreTokens())
	{
	output_str.append("\\");
	output_str.append("\"");
	}
	}
if(discount.getItemId()== item[0] && discount.getStatus().equals("y")){

	%>
	data_arr[<%= counter%>][10] = "<%= output_str.toString()%>";

<%
		}else if(discount.getItemId() == item[0] && discount.getStatus().equals("n")){
			%>
data_arr[<%= counter%>][10] = "<font id='error'>*</font>Parent InActivated--<%=output_str.toString()%>";
		<%}}else{%>
			data_arr[<%= counter%>][10] = "";
		<%}
		}%> --%>
		
		data_arr[<%= counter%>][10] = "";

	<%
	for(MasMainChargecode mainChargecode : mainChargeCodeList){
		if(discount.getMainChargecode() != null){
if(discount.getMainChargecode().getId() == mainChargecode.getId() && discount.getStatus().equals("y")){
%>
data_arr[<%= counter%>][11] = "<%=mainChargecode.getMainChargecodeName()%>"
<%
		}else if(discount.getMainChargecode().getId() == mainChargecode.getId() && discount.getStatus().equals("n")){
			%>
data_arr[<%= counter%>][11] = "<font id='error'>*</font>Parent InActivated--<%=mainChargecode.getMainChargecodeName()%>";
		<%}}else{%>
			data_arr[<%= counter%>][11] = "";
		<%}
		}%>

<%
	for(MasSubChargecode subChargecode : subChargeCodeList){
		if(discount.getSubChargecode() != null){
if(discount.getSubChargecode().getId() == subChargecode.getId() && discount.getStatus().equals("y")){
%>
data_arr[<%= counter%>][12] = "<%=subChargecode.getSubChargecodeName()%>"
<%
		}else if(discount.getSubChargecode().getId() == subChargecode.getId() && discount.getStatus().equals("n")){
			%>
data_arr[<%= counter%>][12] = "<font id='error'>*</font>Parent InActivated--<%=subChargecode.getSubChargecodeName()%>";
		<%}}else{%>
			data_arr[<%= counter%>][12] = "";
		<%}
		}%>


<%


if(discount.getChargeCode() != null){
	
for(Object[] chargeObject : ChargeCodeList){

	
if(discount.getChargeCode().getId().equals((Integer)chargeObject[1])){

	StringBuffer output_str = new StringBuffer();
	StringTokenizer s = new StringTokenizer(chargeObject[0].toString(),"\"");

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
	data_arr[<%= counter%>][13] = "<%= output_str.toString()%>";

<%
break;
		
}else if(discount.getChargeCode().getId() == (Integer)chargeObject[1] && discount.getStatus().equals("n")){
			%>
data_arr[<%= counter%>][13] = "<font id='error'>*</font>Parent InActivated--<%=chargeObject[0]%>";
		<%} 
} 
		}else{%>
			data_arr[<%= counter%>][13] = "";
		<%}
		 %>

	<%
		if(discount.getEffectiveDateFrom() != null){
	%>
	data_arr[<%= counter%>][14] = "<%= HMSUtil.convertDateToStringWithoutTime(discount.getEffectiveDateFrom()) %>"
	<%}else{%>
		data_arr[<%= counter%>][14] = "";
		<%}%>

		<%
		if(discount.getEffectiveDateTo() != null){
	%>
	data_arr[<%= counter%>][15] = "<%= HMSUtil.convertDateToStringWithoutTime(discount.getEffectiveDateTo()) %>"
	<%}else{%>
		data_arr[<%= counter%>][15] = "";
		<%}%>

	<%
		if(discount.getDiscountType() != null){
	%>
	data_arr[<%= counter%>][16] = "<%= discount.getDiscountType() %>"
	<%}else{%>
		data_arr[<%= counter%>][16] = "";
		<%}%>
	<%
		if(discount.getDiscountPercentage() != null){
			
%>
		data_arr[<%= counter%>][17] = "<%= discount.getDiscountPercentage() %>"
		<%}else{%>
		data_arr[<%= counter%>][17] = "";
		<%}%>

		<%
		if(discount.getDiscountValue() != null){
%>
		data_arr[<%= counter%>][18] = "<%= discount.getDiscountValue() %>"
		<%}else{%>
		data_arr[<%= counter%>][18] = "";
		<%}%>

<%-- 
<%
	for(FaMasAccount account : accountList){
		if(discount.getAccount() != null){
if(discount.getAccount().getId().equals(account.getId()) && discount.getStatus().equals("y")){
%>
data_arr[<%= counter%>][19] = "<%=account.getAccDesc()%>"
<%
		}else if(discount.getAccount().getId().equals(account.getId()) && discount.getStatus().equals("n")){
			%>
data_arr[<%= counter%>][19] = "<font id='error'>*</font>Parent InActivated--<%=account.getAccDesc()%>";
		<%}}else{%>
			data_arr[<%= counter%>][19] = "";
		<%}
		}%> --%>
		data_arr[<%= counter%>][19] = "";

data_arr[<%= counter%>][20] = "<%= discount.getLastChgBy() %>"
data_arr[<%= counter%>][21] = "<%= discount.getLastChgDate()!=null?HMSUtil.convertDateToStringWithoutTime(discount.getLastChgDate()):"" %>"
data_arr[<%= counter%>][22] = "<%= discount.getLastChgTime() %>"
<% if(discount.getStatus().equals("y")){ %>
data_arr[<%= counter%>][23] = "Active"
<%}else{%>
data_arr[<%= counter%>][23] = "InActive"
<%}%>

<%
if(discount.getBplStatus()!=null && discount.getBplStatus().equalsIgnoreCase("y"))
{
%>
data_arr[<%= counter%>][24] = "BPL"

<%
}else if(discount.getBplStatus()!=null && discount.getBplStatus().equalsIgnoreCase("n"))
{%>
data_arr[<%= counter%>][24] = "APL"

<%
	}else
	{
%>
data_arr[<%= counter%>][24] = ""

<%}%>
	data_arr[<%= counter%>][25] = "<%=discount.getOtherCategory()!=null?discount.getOtherCategory().getPatientTypeName():""%>"
		data_arr[<%= counter%>][26] = "<%=discount.getFromAge()!=null?(discount.getFromAge().intValue()+" Year"):""%>"
			data_arr[<%= counter%>][27] = "<%=discount.getToAge()!=null?(discount.getToAge().intValue()+" Year"):""%>"
			data_arr[<%= counter%>][28] = "<%=(discount.getScheme()!=null && discount.getScheme().getSchemeName()!=null)?(discount.getScheme().getSchemeName()):""%>"
<%
		     counter++;
			
	}
%>

formName = "discountMaster"

nonEditable = ['<%= PATIENT_TYPE_ID%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);
<%-- pgNo = '<%=pageNo%>';

totalPages = Math.ceil(data_arr.length/rowsPerPage);

if(totalPages == 0){
pgNo = pgNo-1;
}
if(pgNo!=null && pgNo>0)
	{
	goToPage(pgNo);

	} --%>



intializeHover('searchresulttable', 'TR', ' tableover');
</script>	
	
	</div>
<form name="discountMaster" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<input type="hidden" value="false" name="localdiscount" />

<div id="testDiv">
<%-- <div class="clear"></div>
<label id="">Schemes</label>
<select	id="chargeCodeSearchId" name="chargeCodeSearch"
	validate="Charge Code,string,no">
	<option value="0">Select</option>
	<%
for(Object[] masChargeCode :ChargeCodeList) {

%>
	<option value="<%=masChargeCode[1]%>"><%=masChargeCode[0]%></option>
	<%}%>

</select> --%> 
<div class="clear"></div>
<label>Scheme</label>
<div id="schemeDiv">
 <select id="schemeId" name="schemeId"	validate="Scheme,int,yes" onchange="onChangeScheme();">
	<option value="0">Select</option>
	 <%
for(MasScheme masScheme : schemeList){
%>
	<option value="<%=masScheme.getId() %>"><%=masScheme.getSchemeName()%></option>
	<%} %> 
</select>
</div>

			<label>Family Income Status</label>
			<label style="width:82px;">
			<input type="radio" value="bpl" name="bplStatus" id="bplStatus1" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();"  /> &nbsp; 
			BPL</label>
			 
			 <label style="width:82px;"><input type="radio" value="apl" name="bplStatus" id="bplStatus2" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();" /> 
			  &nbsp; APL</label>
			 
			
			<label>Social Category</label>
			 <select onblur="" tabindex="1" name="patientTypeId" id="patientTypeId" style="background-color: yellow;" onchange="onChangeSearchCriteria();" >
				<option value="0">Select</option>
				<%for(MasPatientType patientType:patientTypeForSocialCategory) {%>				
				<option value="<%=patientType.getId()%>"><%=patientType.getPatientTypeName()%></option>
				<%}%>
			</select>
			
			<label>Other Category</label> 
			<select name="otherCategory"  id="otherCategoryId">
							<option value="0">Select</option>
			
				<%for(MasPatientType patientType:patientTypeForOtherCategory) {%>
				<option value="<%=patientType.getId()%>"><%=patientType.getPatientTypeName()%></option>
				<%} %>
			</select>

<label> Patient Type</label> 
<select	name="<%=PATIENT_CATEGORY%>" id="<%=PATIENT_CATEGORY%>" validate="Patient Category,string,no"  onchange="showRelatedSchemes();onChagePatientType(this.value);">
	<option value="0">Select</option>
	<option value="IP">InPatient</option>
	<option value="OP">OutPatient</option>
</select>

<label id="departmentTypeLabel">Department</label> 
<select	id="<%=DEPARTMENT_ID %>" name="<%=DEPARTMENT_ID%>"	validate="Department,string,no">
	<option value="0">Select</option>
	<%
for(MasDepartment masDepartment :departments) {
%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}%>
</select>

<label id="roomTypeLabel"> Room Type </label> 
<select name="<%= ROOM_TYPE_ID %>" id="<%= ROOM_TYPE_ID %>"	validate="Room Type,string,no">
	<option value="0">Select</option>
	<%
for(MasRoomType masRoomType :roomTypeList){
%>
	<option value="<%=masRoomType.getId()%>"><%=masRoomType.getRoomTypeName()%></option>
	<%}%>
</select> 

<label><span>*</span> Bill Type </label> 
<select id="billTypeId"	name="<%= BILL_TYPE_ID %>" validate="Bill Type,int,yes"	onchange="displayDrugList(this.id);">
	<option value="0">Select</option>
	<%
for(MasBillType masBillType :billTypeList){
%>
	<option value="<%=masBillType.getId()%>"><%=masBillType.getBillTypeName()%></option>
	<%}%>
</select> 

<!-- <label id="mainchargeId"> <span>*</span>Main Service Head </label>  --> <!-- commented by amit das on 17-06-2016 -->
<label id="mainchargeId"> <span></span>Main Service Head </label>
<select	id="mainChargeCodeId" name="<%=MAIN_CHARGECODE_ID %>"	validate="Main Service Head,string,yes" 
onChange="populateSubChargeCode(this.value,'discountMaster');getCxcludeCharge();">
	<option value="0">Select</option>
	<%
for(MasMainChargecode masMainChargecode :mainChargeCodeList) {
%>
	<option value="<%=masMainChargecode.getId()%>"><%=masMainChargecode.getMainChargecodeName()%></option>
	<%}%>
</select>
 <script type="text/javascript">
		<%
			int count = 0;
			for (MasMainChargecode masMainChargecode :mainChargeCodeList)
			{
				for (MasSubChargecode masSubChargecode :subChargeCodeList)
				{
					if(masMainChargecode.getId().equals(masSubChargecode.getMainChargecode().getId())){
								%>
									subChargeArray1[<%=count%>] = new Array();
									subChargeArray1[<%=count%>][0] = <%=masMainChargecode.getId()%>;
									subChargeArray1[<%=count%>][1] = <%=masSubChargecode.getId()%>;
									subChargeArray1[<%=count%>][2] = "<%=masSubChargecode.getSubChargecodeName()%>";

								<%
								count++;
						}	} } %>
		</script> 
<label id="subChargeId">Sub Service Head </label> 
<select	id="subChargeCodeId" name="<%=SUB_CHARGECODE_ID %>"	validate="Sub Service Head,string,no"	
onChange="populateCharge(this.value,'discountMaster');displayMainCharge(this.value);getCxcludeCharge();">
	<option value="0">Select</option>
	<%
for(MasSubChargecode masSubChargecode :subChargeCodeList) {
%>
	<option value="<%=masSubChargecode.getId()%>"><%=masSubChargecode.getSubChargecodeName()%></option>
	<%}%>
</select> 
<script type="text/javascript">
		<%
			int count1 = 0;
			for (MasSubChargecode masSubChargecode :subChargeCodeList)
			{

				for (Object[] masChargeCode :ChargeCodeList)
				{
					if(masSubChargecode.getId().equals(masChargeCode[2])){
								%>
									chargeCodeArray[<%=count1%>] = new Array();
									chargeCodeArray[<%=count1%>][0] = <%=masSubChargecode.getId()%>;
									chargeCodeArray[<%=count1%>][1] = <%=masChargeCode[1]%>;

				<%
					StringBuffer output_str = new StringBuffer();
					StringTokenizer s = new StringTokenizer(masChargeCode[0].toString(),"\"");

					while (s.hasMoreTokens())
					{
					output_str.append(s.nextToken());
					if (s.hasMoreTokens())
					{
					output_str.append("\\");
					output_str.append("\"");
					}
					}		%>
									chargeCodeArray[<%=count1%>][2] = "<%=output_str%>";

								<%
								count1++;
						}	} } %>
		</script> 
<label id="chargeId">Service </label> 
<select id="chargeCodeId"	name="<%= CHARGE_CODE_ID%>" validate="Service,string,no"	onchange="displayMainSubCharge(this.value);getCxcludeCharge();">
	<option value="0">Select</option>
	<%
for(Object[] masChargeCode :ChargeCodeList) {
%>
	<option value="<%=masChargeCode[1]%>"><%=masChargeCode[0]%></option>
	<%}%>
</select>

<div style="display: inline;" id="divForItemGroup">
<label id="">Item Group </label> 
<select id="<%= GROUP_ID%>"	name="<%= GROUP_ID%>" validate="Item Group,int,no"	onchange="onChangeItemGRoup();">
	<option value="0">Select</option>
	<%
for(MasStoreGroup masStoreGroup:groupList) {
%>
	<option value="<%=masStoreGroup.getId()%>"><%=masStoreGroup.getGroupName()%></option>
	<%}%>
</select>

<label id="">Item Type </label> 
<select id="<%= ITEM_TYPE%>"	name="<%= ITEM_TYPE%>" validate="Item Type,int,no"	onchange="onChangeItemType();">
	<option value="0">Select</option>
</select>

<label id="">Item Section </label> 
<select id="<%= SECTION_ID%>"	name="<%= SECTION_ID%>" validate="Item Section,int,no"	onchange="onChangeItemSection();">
	<option value="0">Select</option>
</select>

<label id="">Item Category </label> 
<select id="<%= ITEM_CATEGORY_ID%>"	name="<%= ITEM_CATEGORY_ID%>" validate="Item Category,int,no"	onchange="onChangeItemCategory();">
	<option value="0">Select</option>
	
</select>

<label id="">Item Class </label> 
<select id="<%= ITEM_CLASS_ID%>"	name="<%= ITEM_CLASS_ID%>" validate="Item Class,int,no"	onchange="onChangeItemClass();">
	<option value="0">Select</option>
</select>

<label id="" >Drug </label>
<select	name="drug" id="drug" validate="Drug,string,no">
	<option value="0">Select</option>
	<%
for(Object[] masStoreItem :storeItemList) {
%>
<option value="<%=masStoreItem[0]%>"><%=masStoreItem[1]%></option>
	<%}%>
</select>
</div>
<label id="fromAgelabel"> From Age</label> 
<input type="text"	name="fromAge" id="fromAge" value="" class="" validate="From Age,int,no"	MAXLENGTH="2" /> 
<label id="toAgeLabel" > To Age</label> 
<input type="text"	name="toAge"  id="toAge" class="" validate="To Age,int,no"	MAXLENGTH="2" /> 


<%-- <label id="companyLable" style="display: none;"><span>*</span> Company</label>
<div id="company" style="display: none;">
<select	name="<%=COMPANY%>" validate="Company,string,no">
	<option value="0">Select</option>
	<%
for(MasCompany masCompany : companyList){
if (masCompany.getPatientType().getId().intValue()==1) {
%>
	<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
	<%} }%>
</select>
</div>

<label id="insuranceLable" style="display: none;"><span>*</span> Company</label>
<div id="insurance" style="display: none;">
<select	name="<%=COMPANY%>" validate="InsuranceHmo,string,no">
	<option value="0">Select</option>
	<%
for(MasCompany masCompany : companyList){
	if (masCompany.getPatientType().getId().intValue()==7) {
%>
	<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
	<%} }%>
</select></div>

<label id="insAmtlbl" style="display: none;"><span>*</span> Amount</label>
<div id="insAmt" style="display: none;"><input type="text" id="" name="<%=INSURANCE_AMOUNT %>" value="" tabindex="1" title="" MAXLENGTH="9" />
</div>
<label id="employeelbl" style="display: none;"><span>*</span> Employee</label>
<div id="employeeDiv" style="display: none;">
<select	name="<%=EMPLOYEE_ID%>" id="employeeId" validate="Employee,string,no"
	onchange="employeeDepntList();populateEmpDep(this);" tabindex="1">
	<option value="0">Select</option>
	<%
for(MasEmployee masEmployee : employeeList){
%>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+ masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select></div> --%>

<script type="text/javascript">

		<%
			int c = 0; 
			//for (MasEmployee emp :employeeList) //commented by amit das on 11-05-2017
				for (Object[] empObject :employeeList) //added by amit das on 11-05-2017
			{

				for (MasEmployeeDependent empDep : employeeDependentList)
				{
					// if(emp.getId().equals(empDep.getEmployee().getId())){ // commented by amit das on 11-05-2017
						if(((Integer)empObject[0]).equals(empDep.getEmployee().getId())){ // added by amit das on 11-05-2017
								%>
									empDepArray[<%=c%>] = new Array();
									<%-- empDepArray[<%=c%>][0] = <%=emp.getId()%>; --%>
									empDepArray[<%=c%>][0] = <%=(Integer)empObject[0]%>;  /* added by amit das on 11-05-2017 */
									empDepArray[<%=c%>][1] = <%=empDep.getId()%>;
									empDepArray[<%=c%>][2] = "<%=empDep.getEmployeeDependentName()%>";

								<%
								c++;
						}	} } %>
		</script>
		
		<%--  <label id="employeeDependentlbl" style="display: none;"><span>*</span>Employee
Dependent</label>
<div id="employeeDependentDiv" style="display: none;">
<select	name="<%=EMPLOYEE_DEPENDENT_ID%>" id="employeeDependentId"
	validate="Employee Dependent,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
for(MasEmployeeDependent masEmployeeDependent : employeeDependentList){

%>
	<option value="<%=masEmployeeDependent.getId()%>"><%=masEmployeeDependent.getEmployeeDependentName()%></option>
	<%}%>
</select>
</div>
<label id="prjlbl" style="display: none;"><span>*</span> Project</label>
<div id="prjDiv" style="display: none;">
<select	name="<%=PROJECT_ID%>" validate="Project,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
for(MasCompany masCompany : companyList){
if (masCompany.getPatientType().getId().intValue()==4) {
%>
	<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
	<%} }%>
</select></div> --%>


<%-- <label><span>*</span> Patient Category</label> 
<select	name="<%=PATIENT_CATEGORY%>" validate="Patient Category,string,yes">
	<option value="0">Select</option>
	<option value="IP">InPatient</option>
	<option value="OP">OutPatient</option>
</select>  --%>

<%-- <label> Room Type </label> 
<select name="<%= ROOM_TYPE_ID %>"	validate="Room Type,string,no">
	<option value="0">Select</option>
	<%
for(MasRoomType masRoomType :roomTypeList){
%>
	<option value="<%=masRoomType.getId()%>"><%=masRoomType.getRoomTypeName()%></option>
	<%}%>
</select> --%>

<%-- <label id="drugId" style="display: none;">Drug </label>
<div id="drigItemId" style="display: none;">
<select	name="<%=ITEM_ID %>" validate="Drug,string,no">
	<option value="0">Select</option>
	<%
for(Object[] masStoreItem :storeItemList) {
%>
	<option value="<%=masStoreItem[0]%>"><%=masStoreItem[1]%></option>
	<%}%>
</select>
</div> --%>



<!-- <label><sapn>*</sapn>Alternate Charge Desc</label>
<input  type="text" name="" value="" maxlength="30"/> -->

<label><span>*</span> From Date</label> 
<input type="text"	name="<%=EFFECTIVE_DATE_FROM%>" id="<%=EFFECTIVE_DATE_FROM%>" value="<%=curDate+"/"+month+"/"+year%>" class="date"	
readonly="readonly" validate="Effective Date From,date,yes"	MAXLENGTH="30"   /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,yes"	
onclick="setdate('<%=curDate+"/"+month+"/"+year%>',document.discountMaster.<%=EFFECTIVE_DATE_FROM%>,event)" />
<label>To Date</label>
<input type="text"	name="<%=EFFECTIVE_DATE_TO%>" id="<%=EFFECTIVE_DATE_TO%>" value="" class="date" readonly="readonly" validate="Effective Date To,date,no" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no" onclick="setdate('',document.discountMaster.<%=EFFECTIVE_DATE_TO%>,event)" />

<label><span>*</span> Tarriff Type </label> 
<select	name="<%=DISCOUNT_TYPE%>" validate="Discount Type,string,yes"	MAXLENGTH="8" onchange="setFixedDiscountType(this.value);">
	<option value="0">Select</option>
	<option value="D">Discount</option>
	<option value="T">Tarriff</option>
	<option value="F">Fixed Value</option>
</select>

<!-- <label><span>*</span>Tarif Type</label>
<input  type="text" name="" value=""/> -->
<label id="varId"> Discount(%)</label>
<input 	id="varianceId" type="text" name="<%=DISCOUNT_PERCENTAGE %>" value=""	validate="Discount percentage,float,no"  MAXLENGTH="8" tabindex=1	onblur="disableField(this.id,this.value);" />
<label id="disLblId"> Discount Value</label> 
<input id="disValId" type="text"	name="<%=DISCOUNT_VALUE %>" value="" validate="Discount value,float,no"	 MAXLENGTH="9" tabindex=1 onblur="disableField(this.id,this.value)" />


<label id="accounCodeId">Account Type Name</label> 
<select	id="accountId" name="<%= ACCOUNT_ID%>"	validate="Account Type Name,string,no">
	<option value="0">Select</option>
	<%
for(FaMasAccount masAccount :accountList) {
%>
	<option value="<%=masAccount.getId()%>"><%=masAccount.getAccDesc()%></option>
	<%}%>
</select>

<div class="clear"></div>
<div id="excludecharge" style="display: inline;">
<label id="">Exclude</label> 
<select multiple="5"	id="excludechargeId" name="excludechargeId" class="listBig" >
	
</select>

</div>

<div id="excludeitem" style="display: inline;">
<label id="">Exclude</label> 
<select multiple="5"	id="excludeitemId" name="excludeitemId" class="listBig" >
	
</select>

</div>

<div class="clear"></div>

<label id="icdLabel">ICD Code</label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="55" onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDListwithID',{parameters:'requiredField=icd'});
</script>
<div class="clear"></div>
<label id="<%=DIAGNOSIS_ID%>Label">Diagnosis</label>
<select name="<%=DIAGNOSIS_ID%>" size="5" multiple="65" id="diagnosisId" class="listBig2">
</select>

<input type="button" class="buttonDel" id="buttonDelLabel" value="" onclick="deleteDgItems(this,'diagnosisId');" align="right" />
<div class="clear"></div>

<!-- <div class="clear"></div>
<label id="">Final Income Status</label>
<select>
<option value="0">Select</option>
<option>APL</option>
<option>BPL</option>
</select>
<label id="">Social Category</label>
<select>
<option value="0">Select</option>
<option>SC</option>
<option>ST</option>
<option>OBC</option>
</select>
<label id="">Others</label>
<input type="text" value=""/>
<div class="clear"></div>
<label id="">Gender Field</label>
<select>
<option value="0">Select</option>
<option>Male</option>
<option>Female</option>
<option>Other</option>
</select>
<label id="">Diagnosis</label>
<select>
<option value="0">Select</option>

</select>
<label id="">Exclusions</label>
<select>
<option value="0">Select</option>

</select> -->
<div class="clear"></div>
<div id="edited"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitDiscountMaster();" accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('discountMaster','billingMaster?method=editDiscountDetails','chkDate')" accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('discountMaster','billingMaster?method=deleteDiscount&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="button" name="Reset"	value="Reset" class="buttonHighlight" accesskey="r"	onclick="clearFieldsOnReset();" />
<div class="clear"></div>
</div>
</div>

<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>
<label>Changed Date:</label>
<label class="value"><%=currentDate%></label>

<label>Changed Time:</label>
<label class="value"><%=currentTime%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
</div>
<input type="hidden" id="pageNoEdit" name="pageNoEdit" value="<%=pageNo %>"/>
</form>
<div class="clear"></div>




<script type="text/javascript">
function validateFieldsForDisplay(){
		var errMsg = "";
		var mainChargeCode = document.getElementById('mainChargeCodeId').value;
		var subChargeCode = document.getElementById('subChargeCodeId').value;
		var chargeCode = document.getElementById('chargeCodeId').value;
		if(document.getElementById('billTypeId').value == "2"){
		if(mainChargeCode == "0" && subChargeCode == "0" && chargeCode ==  "0"  ){
			errMsg += "Please fill MainchargeCode or subchargecode or chargecode   .\n";
		}
	}
		if(errMsg != ""){
			//alert(errMsg);
			return false;
		}

		return true;
}






function setFixedDiscountType(){
	var discountType = document.discountMaster.<%=DISCOUNT_TYPE %>.value;
	if(discountType != ""){
		if(discountType == 'F'){
			document.getElementById('varianceId').style.display = "none";
			document.getElementById('accountId').style.display = "none";
			document.getElementById('varId').style.display = "none";
			document.getElementById('accounCodeId').style.display = "none";
			document.getElementById('disLblId').innerHTML = 'Fixed Value';
			/* document.getElementById('disValId').setAttribute('validate','Fixed Value,float,yes');
			document.getElementById('varianceId').setAttribute('validate','Discount(%),float,no'); */
		}
		else {
			document.getElementById('varianceId').style.display = "block";
			document.getElementById('accountId').style.display = "block";
			document.getElementById('varId').style.display = "block";
			document.getElementById('accounCodeId').style.display = "block";
			if(discountType == 'D' || discountType == "0"){
				document.getElementById('disLblId').innerHTML = 'Discount Value';
				document.getElementById('varId').innerHTML = 'Discount(%)';
				/* document.getElementById('varianceId').setAttribute('validate','Discount(%),float,no'); */
			}else if(discountType == "T"){
				document.getElementById('disLblId').innerHTML = 'Tariff Value';
				document.getElementById('varId').innerHTML = 'Tariff(%)';
				/* document.getElementById('varianceId').setAttribute('validate','Tariff(%),float,no'); */
			}
			/* document.getElementById('disValId').setAttribute('validate','Fixed Value,float,no'); */
		}

	}

}


function displayDrugList(id){

	var billType;
	billType = document.getElementById(id).value;

	if(id== 'btSearchId'){
		if(billType == "1"){
				document.getElementById('drugSearchId').style.display = "inline";
				document.getElementById('drigItemSearchId').style.display = "inline";
				document.getElementById('mcSearchLblId').style.display = "none";
				document.getElementById('mcSearchId').style.display = "none";
				document.getElementById('scSearchLblId').style.display = "none";
				document.getElementById('scSearchId').style.display = "none";
				document.getElementById('chargeSearchId').style.display = "none";
				document.getElementById('chargeCodeSearchId').style.display = "none";

			}else{
				document.getElementById('drugSearchId').style.display = "none";
				document.getElementById('drigItemSearchId').style.display = "none";
				document.getElementById('mcSearchLblId').style.display = "inline";
				document.getElementById('mcSearchId').style.display = "inline";
				document.getElementById('scSearchLblId').style.display = "inline";
				document.getElementById('scSearchId').style.display = "inline";
				document.getElementById('chargeSearchId').style.display = "inline";
				document.getElementById('chargeCodeSearchId').style.display = "inline";
			}

	}else if(id== 'billTypeId'){
		if(billType == "<%=dispensingId%>"){
			document.getElementById('divForItemGroup').style.display = "inline";
			document.getElementById('mainChargeCodeId').style.display = "none";
			document.getElementById('mainchargeId').style.display = "none";
			document.getElementById('subChargeId').style.display = "none";
			document.getElementById('subChargeCodeId').style.display = "none";
			document.getElementById('chargeId').style.display = "none";
			document.getElementById('chargeCodeId').style.display = "none";
			document.getElementById('excludecharge').style.display="none";
			document.getElementById('excludeitem').style.display="inline";
			document.getElementById('excludechargeId').options.length="0";
			document.getElementById('excludeitemId').options.length="0";
		}else if(billType == "<%=serviceId%>"){
			document.getElementById('divForItemGroup').style.display = "none";
			document.getElementById('mainChargeCodeId').style.display = "inline";
			document.getElementById('mainchargeId').style.display = "inline";
			document.getElementById('subChargeId').style.display = "inline";
			document.getElementById('subChargeCodeId').style.display = "inline";
			document.getElementById('chargeId').style.display = "inline";
			document.getElementById('chargeCodeId').style.display = "inline";
			document.getElementById('excludeitem').style.display="none";
			document.getElementById('excludecharge').style.display="inline";
			document.getElementById('excludechargeId').options.length="0";
			document.getElementById('excludeitemId').options.length="0";
		}
		else
			{
			document.getElementById('divForItemGroup').style.display = "none";
			document.getElementById('mainChargeCodeId').style.display = "none";
			document.getElementById('mainchargeId').style.display = "none";
			document.getElementById('subChargeId').style.display = "none";
			document.getElementById('subChargeCodeId').style.display = "none";
			document.getElementById('chargeId').style.display = "none";
			document.getElementById('chargeCodeId').style.display = "none";
			document.getElementById('excludecharge').style.display="none";
			document.getElementById('excludeitem').style.display="none";
			document.getElementById('excludechargeId').options.length="0";
			document.getElementById('excludeitemId').options.length="0";
			}
	}
	}


function displayCompanyList()
{

		var company = document.discountMaster.<%=PATIENT_TYPE_ID %>.value;

		if(company == "1"){
		document.getElementById('company').style.display = "inline";
		document.getElementById('companyLable').style.display = "inline";
	//	document.getElementById('employeeDependentDiv').style.display = "none";
	//	document.getElementById('employeeDependentlbl').style.display = "none";

		}else if (company != "1"){
		document.getElementById('company').style.display = "none";
		document.getElementById('companyLable').style.display = "none";
	//	document.getElementById('employeeDependentDiv').style.display = "none";
	//	document.getElementById('employeeDependentlbl').style.display = "none";
		}

		if(company == "7"){
		document.getElementById('insurance').style.display = "inline";
		document.getElementById('insuranceLable').style.display = "inline";
		document.getElementById('insAmtlbl').style.display = "inline";
		document.getElementById('insAmt').style.display = "inline";
	//	document.getElementById('employeeDependentDiv').style.display = "none";
	//	document.getElementById('employeeDependentlbl').style.display = "none";

		}else if (company != "7"){
		document.getElementById('insurance').style.display = "none";
		document.getElementById('insuranceLable').style.display = "none";
		document.getElementById('insAmtlbl').style.display = "none";
		document.getElementById('insAmt').style.display = "none";
	//	document.getElementById('employeeDependentDiv').style.display = "none";
	//	document.getElementById('employeeDependentlbl').style.display = "none";
		}
		if(company == "4"){
		document.getElementById('prjDiv').style.display = "inline";
		document.getElementById('prjlbl').style.display = "inline";
		}else if (company != "4"){
		document.getElementById('prjDiv').style.display = "none";
		document.getElementById('prjlbl').style.display = "none";
		}
	/*	if(company == "8" || company == "2"){
		document.getElementById('employeeDiv').style.display = "inline";
		document.getElementById('employeelbl').style.display = "inline";
		}else if (company != "8"){
		document.getElementById('employeeDiv').style.display = "none";
		document.getElementById('employeelbl').style.display = "none";
		}*/


}
function employeeDepntList()
{
	var company = document.discountMaster.<%=PATIENT_TYPE_ID %>.value;

	if(company == "2"){
	document.getElementById('employeeDependentDiv').style.display = "inline";
	document.getElementById('employeeDependentlbl').style.display = "inline";
	}else if (company != "2"){
	document.getElementById('employeeDependentDiv').style.display = "none";
	document.getElementById('employeeDependentlbl').style.display = "none";
	}
	if(company=="8")
	{
				obj=document.getElementById("employeeId");
				//document.getElementById("pFirstNameId").value=obj.options[obj.selectedIndex].text;
				//document.getElementById("pFirstNameId").readonly=true;
	}

}


function chkDate(){
		var err = "";
		var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2));
		obj1 = document.discountMaster.effectiveDateFrom.value;
		obj2 = document.discountMaster.effectiveDateTo.value;
		fromDate=new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
		toDate=new Date(obj2.substring(6),(obj2.substring(3,5) - 1) ,obj2.substring(0,2));
/*	if(obj1 != ""){
			if(fromDate>currentDate)
				err += "From Date should be less than or equal to current date.\n"
		}*/
		if(obj2 != ""){
			if(toDate<currentDate)
				err += "To Date should be greater than or equal to current date.\n"

		}
		if(obj1!="" && obj2 !=""){

			if(fromDate>toDate)
				err += "From date should be less than or equal to To Date.\n"
		}
		if(err!="")
			alert(err)
		else
			return true;
	}

function displayCompanyListForSearch()
{
		var company = document.search.patientTypeSearch.value;

		if(company == "1"){
		document.getElementById('comSearchId').style.display = "inline";
		document.getElementById('comSearchLable').style.display = "inline";
	//	document.getElementById('empDepSearchDiv').style.display = "none";
	//	document.getElementById('empDepSearchlbl').style.display = "none";

		}else if (company != "1"){
		document.getElementById('comSearchId').style.display = "none";
		document.getElementById('comSearchLable').style.display = "none";
	//	document.getElementById('empDepSearchDiv').style.display = "none";
	//	document.getElementById('empDepSearchlbl').style.display = "none";
		}

		if(company == "7"){
		document.getElementById('insSearchId').style.display = "inline";
		document.getElementById('insSearchLable').style.display = "inline";
	//	document.getElementById('empDepSearchDiv').style.display = "none";
	//	document.getElementById('empDepSearchlbl').style.display = "none";

		}else if (company != "7"){
		document.getElementById('insSearchId').style.display = "none";
		document.getElementById('insSearchLable').style.display = "none";
	//	document.getElementById('empDepSearchDiv').style.display = "none";
	//	document.getElementById('empDepSearchlbl').style.display = "none";
		}
		if(company == "4"){
		document.getElementById('prjSearchDiv').style.display = "inline";
		document.getElementById('prjSearchlbl').style.display = "inline";
		}else if (company != "4"){
		document.getElementById('prjSearchDiv').style.display = "none";
		document.getElementById('prjSearchlbl').style.display = "none";
		}
	/*	if(company == "8" || company == "2"){
		document.getElementById('empSearchDiv').style.display = "inline";
		document.getElementById('empSearchlbl').style.display = "inline";
		}else if (company != "8"){
		document.getElementById('empSearchDiv').style.display = "none";
		document.getElementById('empSearchlbl').style.display = "none";
		}*/


}

function employeeDepntListForSearch()
{
	var company = document.search.patientTypeSearch.value;

	if(company == "2"){
	document.getElementById('empDepSearchDiv').style.display = "inline";
	document.getElementById('empDepSearchlbl').style.display = "inline";
	}else if (company != "2"){
	document.getElementById('empDepSearchDiv').style.display = "none";
	document.getElementById('empDepSearchlbl').style.display = "none";
	}
	if(company=="8")
	{
				obj=document.getElementById("empId");
				//document.getElementById("pFirstNameId").value=obj.options[obj.selectedIndex].text;
				//document.getElementById("pFirstNameId").readonly=true;
	}

}


function populateSubChargeCodeForSearch(val){

	obj1 = document.getElementById('scSearchId');
	obj1.length = 1;

	for(i=0;i<subChargeArray1.length;i++){
		if(subChargeArray1[i][0]==val){
			obj1.length++;
			obj1.options[obj1.length-1].value=subChargeArray1[i][1];
			obj1.options[obj1.length-1].text=subChargeArray1[i][2];
		}
	}
}


function populateChargeForSearch(val){
	obj = document.getElementById('chargeCodeSearchId');
	obj.length = 1;
	for(i=0;i<chargeCodeArray.length;i++){
		if(chargeCodeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=chargeCodeArray[i][1];
			obj.options[obj.length-1].text=chargeCodeArray[i][2];
		}
	}
}


function populateEmpDep(obj1){
var val = obj1.value;
var obj ;
	if(obj1.id == 'employeeId'){
		obj = document.getElementById('employeeDependentId');
	}
	else if(obj1.id = 'empId'){
		obj = document.getElementById('empDepId');
	}
	obj.length = 1;

	for(i=0;i<empDepArray.length;i++){
		if(empDepArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=empDepArray[i][1];
			obj.options[obj.length-1].text=empDepArray[i][2];
		}
	}


}


function clearFieldsOnReset(){
	document.discountMaster.action = "/hms/hms/billingMaster?method=showDiscountJsp";
	document.discountMaster.submit();
}

function displayMainSubCharge(charge){
<%
	for(Object[] chargeCode : ChargeCodeList){
%>
	chargeId = '<%=chargeCode[1]%>';
	if(charge == chargeId){
		document.getElementById('mainChargeCodeId').value = '<%=chargeCode[3]%>';
		document.getElementById('subChargeCodeId').value = '<%=chargeCode[2]%>';
	}

<%	}
%>

}


function displayMainCharge(subcharge){
<%
	for(MasSubChargecode subChargeCode : subChargeCodeList){
%>
	subchargeId = '<%=subChargeCode.getId()%>';
	if(subcharge == subchargeId){
		document.getElementById('mainChargeCodeId').value = '<%=subChargeCode.getMainChargecode().getId()%>';
	}

<%	}
%>


}

function disableField(fieldId,val){
	if(val != ""){
		if(fieldId == "varianceId"){
			document.getElementById('disValId').readOnly = true;
		}else if(fieldId == "disValId"){
			document.getElementById('varianceId').readOnly = true;
		}
	}else{
		if(fieldId == "varianceId"){
			document.getElementById('disValId').readOnly = false;
		}else if(fieldId == "disValId"){
			document.getElementById('varianceId').readOnly = false;
		}

	}

}

function onChangeItemGRoup()
{
	 document.getElementById('<%=ITEM_TYPE%>').value="0";
	document.getElementById('<%=SECTION_ID%>').value="0";
	document.getElementById('<%=ITEM_CATEGORY_ID%>').value="0";
	document.getElementById('<%=ITEM_CLASS_ID%>').value="0"; 
	document.getElementById('drug').value="0"; 
	submitProtoAjaxWithDivName('discountMaster','/hms/hms/billingMaster?method=getItemCategoryDetails&'+csrfTokenName+'='+csrfTokenValue,'divForItemGroup');
	getCxcludeItem();
}
function onChangeItemType()
{
	document.getElementById('<%=SECTION_ID%>').value="0";
	document.getElementById('<%=ITEM_CATEGORY_ID%>').value="0";
	document.getElementById('<%=ITEM_CLASS_ID%>').value="0"; 
	document.getElementById('drug').value="0"; 
	submitProtoAjaxWithDivName('discountMaster','/hms/hms/billingMaster?method=getItemCategoryDetails&'+csrfTokenName+'='+csrfTokenValue,'divForItemGroup');
	getCxcludeItem();
}
function onChangeItemSection()
{
	document.getElementById('<%=ITEM_CATEGORY_ID%>').value="0";
	document.getElementById('<%=ITEM_CLASS_ID%>').value="0"; 
	document.getElementById('drug').value="0"; 
	submitProtoAjaxWithDivName('discountMaster','/hms/hms/billingMaster?method=getItemCategoryDetails&'+csrfTokenName+'='+csrfTokenValue,'divForItemGroup');
	getCxcludeItem();
}
function onChangeItemCategory()
{
	document.getElementById('drug').value="0"; 
	submitProtoAjaxWithDivName('discountMaster','/hms/hms/billingMaster?method=getItemCategoryDetails&'+csrfTokenName+'='+csrfTokenValue,'divForItemGroup');
	getCxcludeItem();
}
function onChangeItemClass()
{
	document.getElementById('drug').value="0"; 
	submitProtoAjaxWithDivName('discountMaster','/hms/hms/billingMaster?method=getItemCategoryDetails&'+csrfTokenName+'='+csrfTokenValue,'divForItemGroup');
	getCxcludeItem();
}

function getCxcludeCharge()
{
submitProtoAjaxWithDivName('discountMaster','/hms/hms/billingMaster?method=getChargeForExclude&'+csrfTokenName+'='+csrfTokenValue,'excludecharge');
}

function getCxcludeItem()
{
submitProtoAjaxWithDivName('discountMaster','/hms/hms/billingMaster?method=getItemForExclude&'+csrfTokenName+'='+csrfTokenValue,'excludeitem');
}

onChangeItemGRoup();

function fillDiagnosisCombo(val) {

      
  	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	   
	    if(id ==""){
		  return;
		}else{
		   		obj =document.getElementById('diagnosisId');
				obj.length = document.getElementById('diagnosisId').length;
               var valu=document.getElementById('diagnosisId').value;
				var b="false";
				for(var i=0;i<obj.length;i++){
						    
	                    	var val1=obj.options[i].value;
	                    	var length=obj.length-1;
                           	
	                    	if(id==val1)
	                    	{
	                        	alert("ICD  Already taken");
	                        	document.getElementById('icd').value =""
	                        	b=true;
	                       	}
	                              	
	                    }
               
	                    if(b=="false")
	                    {
	                    	obj.length++;
	    					obj.options[obj.length-1].value=id
	    					obj.options[obj.length-1].text=val
	    					obj.options[obj.length-1].selected=true
	    					document.getElementById('icd').value =""
	    			                    
	                    }
			}
		
  }
function deleteDgItems(value){
	 if(confirm("are you sure want to delete ?")){
	 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex)

	    }
    }
    
    function onChagePatientType(val)
    {
    	if(val=="IP")
    			{
    		document.getElementById('<%=DEPARTMENT_ID %>').value="0";
    		document.getElementById('departmentTypeLabel').style.display="inline";
    		document.getElementById('<%=DEPARTMENT_ID %>').style.display="inline";
    		document.getElementById('roomTypeLabel').style.display="inline";
    		document.getElementById('<%=ROOM_TYPE_ID%>').style.display="inline";
    			}
    	else
    		{
    		document.getElementById('<%=DEPARTMENT_ID %>').value="0";
    		document.getElementById('departmentTypeLabel').style.display="none";
    		document.getElementById('<%=DEPARTMENT_ID %>').style.display="none";
    		document.getElementById('roomTypeLabel').style.display="none";
    		document.getElementById('<%=ROOM_TYPE_ID%>').style.display="none";
    		}
    }
    
    
    function showRelatedSchemes()
    {
    	var element = document.getElementById("patientCategory");
    	var patientCategory = element.options[element.selectedIndex].value;
    	submitProtoAjaxWithDivName('discountMaster','/hms/hms/billingMaster?method=listSchemeForDiscount&patientType='+patientCategory+'&'+csrfTokenName+'='+csrfTokenValue,'schemeDiv');
    }
    

</script>




<script type="text/javascript">
document.getElementById('bplStatus1').checked=false;
document.getElementById('bplStatus1').checked=false;
document.getElementById('<%=PATIENT_CATEGORY%>').value="0";
document.getElementById('<%=DEPARTMENT_ID %>').value="0";
document.getElementById('<%=ROOM_TYPE_ID%>').value="0";
document.getElementById('departmentTypeLabel').style.display="none";
document.getElementById('<%=DEPARTMENT_ID %>').style.display="none";
document.getElementById('roomTypeLabel').style.display="none";
document.getElementById('<%=ROOM_TYPE_ID%>').style.display="none";
document.getElementById('billTypeId').value="<%=serviceId%>";
document.getElementById('divForItemGroup').style.display="none";
document.getElementById('<%=GROUP_ID %>').value="0";
document.getElementById('<%=ITEM_TYPE %>').value="0";
document.getElementById('<%=SECTION_ID %>').value="0";
document.getElementById('<%=ITEM_CATEGORY_ID %>').value="0";
document.getElementById('<%=ITEM_CLASS_ID %>').value="0";
document.getElementById('drug').value="0";
document.getElementById('excludeitem').style.display="none";
document.getElementById('excludechargeId').options.length="0";
document.getElementById('excludeitemId').options.length="0";
document.getElementById('schemeId').value="0";
document.getElementById('toAgeLabel').style.display="none";
document.getElementById('toAge').style.display="none";
document.getElementById('fromAgelabel').style.display="none";
document.getElementById('fromAge').style.display="none";
document.getElementById('icdLabel').style.display="none";
document.getElementById('icd').style.display="none";
document.getElementById('diagnosisId').style.display="none";
document.getElementById('diagnosisIdLabel').style.display="none";
showRelatedSchemes();



function onChangeScheme()
{
	if(document.getElementById('schemeId').value=="0")
		{
		document.getElementById('toAgeLabel').style.display="none";
		document.getElementById('toAge').style.display="none";
		document.getElementById('fromAgelabel').style.display="none";
		document.getElementById('fromAge').style.display="none";
		document.getElementById('icdLabel').style.display="none";
		document.getElementById('icd').style.display="none";
		document.getElementById('diagnosisId').style.display="none";
		document.getElementById('diagnosisIdLabel').style.display="none";
		}
	else
		{
		document.getElementById('toAgeLabel').style.display="inline";
		document.getElementById('toAge').style.display="inline";
		document.getElementById('fromAgelabel').style.display="inline";
		document.getElementById('fromAge').style.display="inline";
		document.getElementById('icdLabel').style.display="inline";
		document.getElementById('icd').style.display="inline";
		document.getElementById('diagnosisId').style.display="inline";
		document.getElementById('diagnosisIdLabel').style.display="inline";
		}
}

function submitDiscountMaster()
{
	var billType=document.getElementById('billTypeId').value;
	if(billType == "<%=serviceId%>"){
		// document.getElementById('mainChargeCodeId').setAttribute('validate','Main Service Head,int,yes'); //commented by amit das on 17-06-2016
		 document.getElementById('mainChargeCodeId').setAttribute('validate','Main Service Head,int,no'); // added by amit das on 17-06-2016
		document.getElementById('<%=GROUP_ID %>').setAttribute('validate','Item Group,int,no');
	}else if(billType == "<%=dispensingId%>"){
		document.getElementById('mainChargeCodeId').setAttribute('validate','Main Service Head,int,no');
		document.getElementById('<%=GROUP_ID %>').setAttribute('validate','Item Group,int,yes');
	}
	else
		{
		document.getElementById('mainChargeCodeId').setAttribute('validate','Main Service Head,int,no');
		document.getElementById('<%=GROUP_ID %>').setAttribute('validate','Item Group,int,no');
		}
	var fromAge=document.getElementById('fromAge').value;
	var toAge=document.getElementById('toAge').value;
	
	if(fromAge!="" && !isNaN(fromAge) )
	{
	if(fromAge<0)
		{
		alert("From age is less than 0");
		return;
		}
	}
	
	if(fromAge!="" && toAge!="" && !isNaN(fromAge) && !isNaN(toAge))
		{
	 if(fromAge>toAge)
			{
		alert("From age is greater than to Age.");
		return;
		}
		
		}
	
	var fromDate=document.getElementById('<%=EFFECTIVE_DATE_FROM%>').value;
	var toDate=document.getElementById('<%=EFFECTIVE_DATE_TO%>').value;
	var currentDate=new Date('<%=month+"/"+curDate+"/"+year%>');
	if(fromDate!="")
		{
		 var bits = fromDate.split('/');
		  var d = new Date(bits[1]+"/"+bits[0]+"/"+bits[2]);
		  if(!isNaN(d.getTime()))
			  {
			  //alert(currentDate.getTime()+"  "+ d.getTime());
			  if(currentDate.getTime()>d.getTime())
				  {
				  alert("Effective From Date is less than current Date.");
				  return;
				  }
			  
			  }
		}
	
	if(toDate!="")
	{
	 var bits = toDate.split('/');
	  var d = new Date(bits[1]+"/"+ bits[0]+"/"+ bits[2]);
	  if(!isNaN(d.getTime()))
		  {
		  if(currentDate.getTime()>d.getTime())
			  {
			  alert("Effective To Date is less than current Date.");
			  return;
			  }
		  
		  var bits = fromDate.split('/');
		  var d1 = new Date(bits[1]+"/"+ bits[0]+"/"+bits[2]);
		  if(!isNaN(d1.getTime()))
			  {
			 
			  if(d1.getTime()>d.getTime())
				  {
				  alert("Effective From Date is greater than Effective To Date");
				  return;
				  }
			  
			  }
		  
		  }
	}
	
	var discountType = document.discountMaster.<%=DISCOUNT_TYPE %>.value;
	if(discountType != ""){
		if(discountType == 'F'){
			 document.getElementById('disValId').setAttribute('validate','Fixed Value,int,yes');
			document.getElementById('varianceId').setAttribute('validate','Discount(%),float,no');  //changed by amit das on 31-05-2017
		}
		else {
			/* if(document.getElementById('varianceId')!="" && document.getElementById('disValId')!="")
				{
				alert('Enter only Discount Value Or Discount(%)');
				return;
				} */
			if(discountType == 'D'){
				 document.getElementById('varianceId').setAttribute('validate','Discount(%),float,no'); //changed by amit das on 31-05-2017
				 document.getElementById('disValId').setAttribute('validate','Fixed Value,int,no');
				// alert("aa"+document.getElementById('disValId').value+"bb");
				 //alert("aa"+document.getElementById('varianceId').value+"bb");

				 //alert(document.getElementById('varianceId').value!="" && document.getElementById('disValId').value!="");
				 if(document.getElementById('varianceId').value!="" && document.getElementById('disValId').value!="")
					{
					alert('Enter only Discount Value Or Discount(%)');
					return;
					}
				 else  if(document.getElementById('varianceId').value=="" && document.getElementById('disValId').value=="")
					{
						alert('Enter Either Discount Value Or Discount(%)');
						return;
						}
				 
			}else if(discountType == "T"){
				 document.getElementById('varianceId').setAttribute('validate','Tariff(%),float,no');  //changed by amit das on 31-05-2017
				 if(document.getElementById('varianceId').value!="" && document.getElementById('disValId').value!="")
					{
					alert('Enter only Tarrif Value Or Tarrif(%)');
					return;
					}
				 else  if(document.getElementById('varianceId').value=="" && document.getElementById('disValId').value=="")
					{
						alert('Enter Either Tarrif Value Or Tarrif(%)');
						return;
						}
			}
			
		}

	}	
	submitForm('discountMaster','/hms/hms/billingMaster?method=saveDiscount','chkDate');
}
function searchKeyPress(e) {
	// look for window.event in case event isn't passed in
	e = e || window.event;
	if (e.keyCode == 13) {
		document.getElementById('search').click();
		return false;
	}
	return true;
}
</script>
