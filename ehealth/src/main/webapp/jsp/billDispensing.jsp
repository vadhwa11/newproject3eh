<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.MasCharityType"%>
<%--For AutoComplete Through Ajax--%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasStoreItemGeneric"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.BlTempOpBillHeader"%>
<%@page import="jkt.hms.masters.business.BlTempBillDispensingDetails"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">

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



function eventCallback(element, entry){
		return entry + "&itemTypeId=" + document.getElementById('itemTypeId').value+
						"&itemCatgryId="+document.getElementById('itemCatgryId').value+
						"&itemGrpId="+document.getElementById('itemGrpId').value+
						"&itemGenId="+document.getElementById('itemGenId').value;
}
</script>
<form name="billDispensing" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<PatientPrescriptionHeader> presHdList = new ArrayList<PatientPrescriptionHeader>();
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	List<MasItemCategory> itemCatgryList = new ArrayList<MasItemCategory>();
	List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
	List<MasStoreItemGeneric> itemGenList = new ArrayList<MasStoreItemGeneric>();
	List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
	List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<BlTempOpBillHeader> tempBillList = new ArrayList<BlTempOpBillHeader>();
	List<Object[]> itemWiseList = new ArrayList<Object[]>();
	List<MasPatientType> masPTypeList= new ArrayList<MasPatientType>();
	List<MasPatientType> masPTypeLists= new ArrayList<MasPatientType>();
	List<MasPatientType> masPTypeListo = new ArrayList<MasPatientType>();
	List<MasCharityType> masCharityList = new ArrayList<MasCharityType>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("masPTypeListo") != null) {
		masPTypeListo = (List<MasPatientType>) map.get("masPTypeListo");
	}
	if (map.get("masPTypeLists") != null) {
		masPTypeLists = (List<MasPatientType>) map.get("masPTypeLists");
	}
	if (map.get("masPTypeList") != null) {
		masPTypeList = (List<MasPatientType>) map.get("masPTypeList");
	}
	if (map.get("detailsMap") != null) {
		detailsMap = (Map<String, Object>) map.get("detailsMap");
	}
	if (map.get("masCharityList") != null) {
		masCharityList = (List<MasCharityType>) map.get("masCharityList");
	}
	if(detailsMap.get("employeeList") != null){
		employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
	}
	if (map.get("patientList") != null) {
		patientList = (List<Patient>) map.get("patientList");
	}

	if (map.get("presHdList") != null) {
		presHdList = (List<PatientPrescriptionHeader>) map.get("presHdList");
	}
	if (detailsMap.get("itemTypeList") != null) {
		itemTypeList = (List<MasItemType>) detailsMap.get("itemTypeList");
	}
	if (detailsMap.get("itemCatgryList") != null) {
		itemCatgryList = (List<MasItemCategory>) detailsMap.get("itemCatgryList");
	}
	if (detailsMap.get("itemGroupList") != null) {
		itemGroupList = (List<MasStoreGroup>) detailsMap.get("itemGroupList");
	}
	if (detailsMap.get("itemGenList") != null) {
		itemGenList = (List<MasStoreItemGeneric>) detailsMap.get("itemGenList");
	}
	if (detailsMap.get("authorizerList") != null) {
		authorizerList = (List<MasAuthorizer>) detailsMap.get("authorizerList");
	}
	if (detailsMap.get("bankList") != null) {
		bankList = (List<MasBankMaster>) detailsMap.get("bankList");
	}
	if (detailsMap.get("sexList") != null) {
		sexList = (List<MasAdministrativeSex>) detailsMap.get("sexList");
	}

	if (map.get("tempBillList") != null) {
		tempBillList = (List<BlTempOpBillHeader>) map.get("tempBillList");
	}
	if (map.get("itemWiseList") != null) {
		itemWiseList = (List<Object[]>) map.get("itemWiseList");
	}

	String registered = "";
	if (map.get("registered") != null) {
		registered = (String) map.get("registered");
	}

	String maxBlNo = "";
	if (map.get("maxBlNo") != null) {
		maxBlNo = (String) map.get("maxBlNo");
	}
	String prescriptionNo = "";
	if (map.get("prescriptionNo") != null) {
		prescriptionNo = (String) map.get("prescriptionNo");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
		} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");

	PatientPrescriptionHeader presHd = new PatientPrescriptionHeader();
	Set<PatientPrescriptionDetails> presDtSet = new HashSet<PatientPrescriptionDetails>();
	if(presHdList.size() > 0){
		presHd = presHdList.get(0);
		presDtSet = presHd.getPatientPrescriptionDetails();
	}
	BlTempOpBillHeader tempOpBillHeader = new BlTempOpBillHeader();
	Set<BlTempBillDispensingDetails> tempBlDtSet = new HashSet<BlTempBillDispensingDetails>();
%>

<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<div class="titleBg">
<h2>Bill Dispensing</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%-- <label>Bill No.</label> <label class="value"><%=maxBlNo%></label> --%>

<label>Bill Date</label>
<input type="text" value="<%=date%>"/>
 <%-- <label class="value"><%= date%></label> --%>
<%--  <label>Bill Time</label> <label class="value"><%= time%></label> --%>


<%
	int hinId =0 ;
	int patientTypeId = 0;
	String adv = "";
	String pastDue = "";
/* 	if (registered.equals("yes")) { */
		if (patientList.size() > 0) {
			Patient patient = patientList.get(0);
			hinId = patient.getId();
			if (patient.getPastDue() != null)
				pastDue = patient.getPastDue();

			patientTypeId = patient.getPatientType().getId();
%>
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" value="<%=patient.getHinNo() %>"/>


<label>Patient Name</label>
<input type="text" value="<%=patient.getPFirstName()%> <%=patient.getPMiddleName()%>
<%=patient.getPLastName()%>"/>
 <%-- <%
 	if (patient.getPFirstName() != null) {
 %> <label class="value"><%=patient.getPFirstName()%> <%=patient.getPMiddleName()%>
<%=patient.getPLastName()%></label> <%
	}
%>  --%>
<label>Age</label> 
<input type="text" value="<%=patient.getAge()%>"/>

<label>Gender</label>
<input type="text" value="<%=patient.getSex().getAdministrativeSexCode() %>"/>

<label>Mobile</label>
<input type="text" value="<%=patient.getMobileNumber()%>"/>
<div class="clear"></div>
 <%
 String familyId="";
 for(MasPatientType mpt:masPTypeList){
	 familyId = mpt.getPatientTypeName();
 }
 %>
  <%
 String familyIdS="";
 for(MasPatientType mpt:masPTypeLists){
	 familyIdS = mpt.getPatientTypeName();
 }
 %>
 <%
 String familyIdo="";
 for(MasPatientType mpt:masPTypeListo){
	 familyIdo = mpt.getPatientTypeName();
 }
 %>
  <label>Fmaily Income Category</label> 
 <input type="text"  readonly="readonly" value="<%=familyId%>" />
   <label>Social Category</label> 
 <input type="text"  readonly="readonly" value="<%=familyIdS%>" />
   <label>Other Category</label> 
 <input type="text"  readonly="readonly" value="<%=familyIdo%>" />
 <div class="clear"></div>
<div class="clear"></div>
<label>Patient Type</label> 
<input type="text" value="<%=patient.getPatientType().getPatientTypeName() %>"/>
<%-- <label class="value"><%=patient.getPatientType().getPatientTypeName() %></label> --%>
<%
	if (!prescriptionNo.equals("")) {
%>

<label>Prescription No.</label> <label class="value"> <%=prescriptionNo%></label>
<input type="hidden" name="<%=PRESCRIPTION_NO %>"
	value="<%=prescriptionNo %>" /> <%
 	}

	String doctorName = "";
	if(presHdList.size() > 0){
		doctorName = presHd.getVisit().getDoctor().getFirstName();
		if(presHd.getVisit().getDoctor().getMiddleName() != null){
			doctorName = doctorName.concat(" ").concat(presHd.getVisit().getDoctor().getMiddleName());
		}
		if(presHd.getVisit().getDoctor().getLastName() != null){
			doctorName = doctorName.concat(" ").concat(presHd.getVisit().getDoctor().getLastName());
		}
%> <label>Consultant Name1</label> <label class="value"><%=doctorName%></label>
<input type="hidden" name="<%=EMPLOYEE_ID %>" value="<%=  presHd.getVisit().getDoctor().getId()%>"/>

<%}else{ %> <label><span>*</span> Consultant Name</label> <select
	name="<%=EMPLOYEE_ID %>" id="cnsltDocId"
	validate="Consultant Name,string,yes" tabindex="1"
	onchange="displayName();">
	<option value="0">Select</option>
	<%
		for (MasEmployee  employee : employeeList){
		if(employee.getEmpCategory() != null){
		if(employee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){

		String doctorMiddleName = "";
		String doctorLastName = "";
		if(employee.getMiddleName() != null)
			doctorMiddleName = employee.getMiddleName();
		if(employee.getMiddleName() != null)
			doctorLastName = employee.getLastName();

	%>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%  } }
		}%>
</select> <%	}%> <%
 	String sign = "";
 			if (!pastDue.equals("")) {
 				sign = pastDue.substring(0, 1);
 				if (sign.equals("-")) {
 					adv = pastDue.substring(1);
 				}
 			}
 			if (!adv.equals("")) {
 %> <label>Total Advance</label> <label class="value"> <%=adv%></label>
<%
	}
%> <%-- <label>Patient Type</label> <label class="value"><%=patient.getPatientType().getPatientTypeName() %></label> --%>

<%
 	if(patient.getCompany() != null){
 		if(patient.getPatientType().getId() == 1){
 %> <label>Company</label> <%}else if(patient.getPatientType().getId() == 4){ %>
<label>Project</label> <%} %> <label class="value"><%=patient.getCompany().getCompanyName() %></label>
<input type="hidden" id="companyId" name="companyId"
	value="<%=patient.getCompany().getId() %>" /> <%} %> <input
	type="hidden" id="patientTypeId" name="<%=PATIENT_TYPE_ID %>"
	value="<%=patientTypeId %>" /> <input type="hidden"
	name="<%=HIN_ID %>" value="<%=patient.getId() %>" /> <input
	type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>" />
<input type="hidden" name="<%=PATIENT_NAME%>"
	value="<%=patient.getPFirstName() %> <%=patient.getPMiddleName()%> <%=patient.getPLastName()%>" />
<input type="hidden" name="<%=AGE%>" value="<%=patient.getAge() %>" />
<input type="hidden" name="<%=SEX_ID%>"
	value="<%=patient.getSex().getId() %>" /> <%
 	}
	/* }else  */{

		 %> 
<!-- <label><span>*</span> Patient Name11</label>  -->
<input type="hidden"
	name="<%=PATIENT_NAME%>" value="" validate="Patient Name,string,yes"
	MAXLENGTH="40" tabindex=1 /> 
	<!-- <label><span>*</span> Age</label> --> <input
	type="hidden" name="<%=AGE%>" value="" validate="Age,string,yes"
	MAXLENGTH="3" tabindex=1 />
<div class="clear"></div>
<%-- <label><span>*</span> Sex</label> <select name="<%=SEX_ID %>"
	validate="Sex,string,yes">
	<option value="0">Select</option>
	<%
				for (MasAdministrativeSex sexObj : sexList) {
			%>
	<option value="<%=sexObj.getId() %>"><%=sexObj.getAdministrativeSexName()%></option>
	<%
				}
			%>
</select> <label><span>*</span> Consultant Name</label>  --%><%-- <select
	name="<%=EMPLOYEE_ID %>" validate="Consultant Name,string,yes"
	id="cnsltDocId" tabindex=1 onchange="displayName();">
	<option value="0">Select</option>
	<%
		for (MasEmployee  employee : employeeList){
			if(employee.getEmpCategory() != null){
				if(employee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){

				String doctorMiddleName = "";
				String doctorLastName = "";
				if(employee.getMiddleName() != null)
					doctorMiddleName = employee.getMiddleName();
				if(employee.getMiddleName() != null)
					doctorLastName = employee.getLastName();

	%>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%   }
		}
	}%>
</select> --%> <%
		 	}
		 %>
<input type="hidden" id="cnsltDocTextId"
	name="<%=CONSULTING_DOCTOR%>" value="" />
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="paddingTop15"></div>

<h4>Item Details</h4>
<div class="clear"></div>
<div class="Block"><!-- <label>Item Type</label> --> <select
	id="itemTypeId" name="<%=ITEM_TYPE_ID %>" style="visibility: hidden">
	<option value="0">Select</option>
	<%
		for (MasItemType itemType : itemTypeList) {
	%>
	<option value="<%=itemType.getId() %>"><%=itemType.getItemTypeName()%></option>
	<%
		}
	%>
</select> <label>Item Class</label> <select id="itemCatgryId"
	name="<%=ITEM_CATEGORY_ID %>">
	<option value="0">Select</option>
	<%
		for (MasItemCategory itemCategory : itemCatgryList) {
	%>
	<option value="<%=itemCategory.getId() %>"><%=itemCategory.getItemCategoryName()%></option>
	<%
		}
	%>
</select> <label>Item Group</label> <select id="itemGrpId"
	name="<%=ITEM_GROUP_ID %>">
	<option value="0">Select</option>
	<%
		for (MasStoreGroup storeGroup : itemGroupList) {
	%>
	<option value="<%=storeGroup.getId() %>"><%=storeGroup.getGroupName()%></option>
	<%
		}
	%>
</select> <!-- 	<label>Item Generic</label> --> <select id="itemGenId"
	name="<%=ITEM_GENERIC_ID %>" style="visibility: hidden">
	<option value="0">Select</option>
	<%
		for (MasStoreItemGeneric itemGeneric : itemGenList) {
	%>
	<option value="<%=itemGeneric.getId() %>"><%=itemGeneric.getGenericName()%></option>
	<%
		}
	%>
</select>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="delete" value="" class="buttonDel"
	onclick="removeRow();" />
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="itemDetails">
	<tr>
		<th scope="col"></th>
		<th scope="col">Description</th>
		<th scope="col">Qty</th>
		<th scope="col">Amount</th>
		<th scope="col">VAT</th>
		<th scope="col">Discount(%)</th>
		<th scope="col">Discount Amt</th>
		<th scope="col">Charity</th>
		<th scope="col">Net Amount</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%
		int inc = 0;
		BigDecimal totalBillAmt = new BigDecimal("0");
		BigDecimal totalNetAmt = new BigDecimal("0");
		int presHdId = 0;
		if (presDtSet.size() > 0) {
			for (PatientPrescriptionDetails presDetails : presDtSet) {
				inc = inc+1;
				presHdId = presDetails.getPrescription().getId();
	%>
	<tr>

		<td><input type="hidden"
			name="<%=PRESCRIPTION_HEADER_ID %><%=inc%>" value="<%=presHdId %>" />
		<input type="hidden" name="<%=PRESCRIPTION_DETAILS_ID %><%=inc %>"
			value="<%=presDetails.getId() %>" /> <input type="radio"
			value="<%=inc%>" name="selectedItem" class="radioCheck" /></td>

		<td id="nameDiv"><input type="hidden"
			name="<%=ITEM_CODE%><%=inc%>" size="15" id="itemCode<%=inc%>"
			value="<%=presDetails.getItem().getPvmsNo() %>" /> <input
			type="hidden" id="itemId<%=inc %>" name="<%=ITEM_ID%><%=inc%>"
			value="<%=presDetails.getItem().getId()%>" /> <input type="text"
			size="28"
			value="<%=presDetails.getItem().getNomenclature() %>[<%=presDetails.getItem().getPvmsNo() %>]"
			id="itemName<%=inc%>" name="<%=ITEM_NAME%><%=inc%>"
			onblur="if(validateItemCodeForAutoComplete(this.value,'<%=inc %>')){openPopupForItem(this.value,<%=inc %>);}"
			validate="Item Name,string,no" tabindex=1 /></td>

		<div id="ac2update<%=inc%>" style="display: none;"
			class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

	    new Ajax.Autocompleter('itemName<%=inc%>','ac2update<%=inc%>','opBilling?method=getItemCodeForAutoComplete',{parameters:'requiredField=itemName<%=inc%>', callback: eventCallback});

		</script>
		<td><input type="text" size="5" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc%>" value="<%=presDetails.getTotal() %>"
			validate="Qty,float,no" maxlength="3" /></td>
		<td><input type="text" size="10" value="" id="amount<%=inc%>"
			name="<%=AMOUNT%><%=inc%>" validate="Amount,float,no"
			 /></td>
		<td><input type="text" value="" id="salesTaxAmt<%=inc%>"
			name="<%=SALES_TAX_AMOUNT %><%=inc%>" 
			validate="Sales Tax Persentage,string,no" size="11" /></td>
		<td><input type="text" value="" id="dispercent<%=inc%>"
			name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" size="8"
			validate="Discount Persentage,string,no"
			onchange=" if(checkDiscountAmt(<%=inc %>)){calculateBatchWiseDiscount(<%=inc %>); calculateDiscountAmt(<%=inc%>);calculateNetAmtForDispensing(<%=inc %>);calculateTotalAmt();};"
			maxlength="3" /></td>
		<td><input type="text" value="" id="disamount<%=inc%>" size="10"
			name="<%=DISCOUNT %><%=inc%>" validate="Discount Amount,string,no"
			onchange="validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateBatchWiseDiscount(<%=inc %>);calculateNetAmtForDispensing(<%=inc %>);calculateTotalAmt();"
			maxlength="7" /></td>
		<td><input type="text" value="" id="prprtnlDis<%=inc%>"
			name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
			validate="Proporational Discount,string,no" 
			size="12" /></td>
		<td><input type="text" size="10" value="" id="netamount<%=inc%>"
			name="<%=NET_AMOUNT %><%=inc%>" validate="Net Amount,float,no"
			readonly="readonly" /> <input type="hidden"
			id="itemBatchCount<%=inc %>" value="" /> <input type="hidden"
			name="<%=FA_ACCOUNT_ID %><%=inc%>" id="accountId<%=inc%>"
			value="<%=presDetails.getItem().getAccountGroup().getId() %>" /> <%
int subLdId =0 ;
if (presDetails.getItem().getSubAccountGroup()!= null) {
	subLdId = presDetails.getItem().getSubAccountGroup().getId() ;
}
%> <input type="hidden" name="<%=FA_SUB_LED_ID %><%=inc%>"
			id="subAccountId<%=inc%>" value="<%=subLdId %>" /></td>
		<td><input type="button" name="add" value=""  id="add<%=inc %>" class="buttonAdd"
			onclick="addRow();" tabindex="1" /></td>
	</tr>
	<%
				}
		}else if(tempBillList.size() > 0) {
				tempOpBillHeader = tempBillList.get(0);
				tempBlDtSet = tempOpBillHeader.getBlTempBillDispensingDetails();
		%>
	<input type="hidden" name="tempBillHdId"
		value="<%=tempOpBillHeader.getId() %>" />
	<%
			for (Object[] tempBlDetails : itemWiseList) {
				inc = inc+1;
				BigDecimal	chrtyPercnt = new BigDecimal(0);
				BigDecimal	chrtyAmt = new BigDecimal(0);
				BigDecimal	prptChrtyAmt = new BigDecimal(0);
				if(tempBlDetails[5] != null){
					chrtyPercnt = (BigDecimal)tempBlDetails[5];
				}
				if(tempBlDetails[6] != null){
					chrtyAmt = (BigDecimal)tempBlDetails[6];
				}
				if(tempBlDetails[7] != null){
					prptChrtyAmt = (BigDecimal)tempBlDetails[7];
				}
		%>
	<tr>

		<td><input type="radio" value="<%=inc%>" name="selectedItem"
			class="radioCheck" /></td>

		<td id="nameDiv"><input type="hidden"
			name="<%=ITEM_CODE%><%=inc%>" size="15" id="itemCode<%=inc%>"
			value="<%=tempBlDetails[1] %>" /> <input type="hidden"
			id="itemId<%=inc %>" name="<%=ITEM_ID%><%=inc%>"
			value="<%=tempBlDetails[0]%>" /> <input type="text" size="28"
			value="<%=tempBlDetails[2] %>[<%=tempBlDetails[1] %>]"
			id="itemName<%=inc%>" name="<%=ITEM_NAME%><%=inc%>"
			onblur="if(validateItemCodeForAutoComplete(this.value,'<%=inc %>')){openPopupForItem(this.value,<%=inc %>);}"
			validate="Item Name,string,no" tabindex=1 /></td>

		<div id="ac2update<%=inc%>" style="display: none;"
			class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

	    new Ajax.Autocompleter('itemName<%=inc%>','ac2update<%=inc%>','opBilling?method=getItemCodeForAutoComplete',{parameters:'requiredField=itemName<%=inc%>', callback: eventCallback});

		</script>
		<td><input type="text" size="5" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc%>" value="<%=tempBlDetails[3] %>"
			validate="Qty,float,no" maxlength="3" readonly="readonly" /></td>
		<%
		BigDecimal amount = new BigDecimal(0);
		amount = (BigDecimal)tempBlDetails[4];
		%>

		<td><input type="text" size="10" value="<%=amount %>"
			id="amount<%=inc%>" name="<%=AMOUNT%><%=inc%>"
			validate="Amount,float,no" readonly="readonly" /></td>
		<%
			BigDecimal salesTaxPercnt = new BigDecimal(0);
			BigDecimal salesTaxAmt = new BigDecimal(0);

			if(tempBlDetails[11] != null){
				salesTaxPercnt =(BigDecimal) tempBlDetails[11];
				salesTaxAmt = (amount.multiply(salesTaxPercnt)).divide(new BigDecimal(100));
			}
		%>
		<td><input type="text" value="<%=salesTaxAmt %>"
			id="salesTaxAmt<%=inc%>" name="<%=SALES_TAX_AMOUNT %><%=inc%>"
			readonly="readonly" size="11"
			validate="Sales Tax Persentage,string,no" /></td>
		<td><input type="text" value="<%=chrtyPercnt%>"
			id="dispercent<%=inc%>" name="<%=DISCOUNT_PERCENTAGE %><%=inc%>"
			size="8" validate="Discount Persentage,string,no"
			onchange=" if(checkDiscountAmt(<%=inc %>)){calculateBatchWiseDiscount(<%=inc %>); calculateDiscountAmt(<%=inc%>);calculateNetAmtForDispensing(<%=inc %>);calculateTotalAmt();};"
			maxlength="3" /></td>
		<td><input type="text" value="<%=chrtyAmt %>"
			id="disamount<%=inc%>" size="10" name="<%=DISCOUNT %><%=inc%>"
			validate="Discount Amount,string,no"
			onchange="validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateBatchWiseDiscount(<%=inc %>);calculateNetAmtForDispensing(<%=inc %>);calculateTotalAmt();"
			maxlength="7" /></td>
		<td><input type="text" value="<%=prptChrtyAmt%>"
			id="prprtnlDis<%=inc%>" name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
			validate="Proporational Discount,string,no" readonly="readonly"
			size="12" /></td>
		<%
		BigDecimal netAmount = new BigDecimal(0);
		netAmount = (BigDecimal)tempBlDetails[8];
		%>
		<td><input type="text" size="10"
			value="<%=netAmount.add(salesTaxAmt) %>" id="netamount<%=inc%>"
			name="<%=NET_AMOUNT %><%=inc%>" validate="Net Amount,float,no"
			readonly="readonly" /> <input type="hidden"
			id="itemBatchCount<%=inc %>" value="" /> <input type="hidden"
			name="<%=FA_ACCOUNT_ID %><%=inc%>" id="accountId<%=inc%>"
			value="<%=tempBlDetails[9] %>" /> <%
int subLdId =0 ;
if (tempBlDetails[10] != null) {
	subLdId = (Integer)tempBlDetails[10];
}
%> <input type="hidden" name="<%=FA_SUB_LED_ID %><%=inc%>"
			id="subAccountId<%=inc%>" value="<%=subLdId %>" /></td>
		<td><input type="button" name="add" value="" id="add<%=inc %>" class="buttonAdd"
			onclick="addRow();" tabindex="1" /></td>
	</tr>

	<%
			}
			}else {
				inc = inc +1;
	%>
	<tr>

		<td><input type="radio" value="<%=inc%>"
			id="selectedItem<%=inc %>" name="selectedItem" class="radioCheck" /></td>


		<td id="nameDiv"><input type="hidden"
			name="<%=ITEM_CODE%><%=inc%>" size="15" id="itemCode<%=inc%>"
			value="" readonly="readonly" /> <input type="text" tabindex=1
			value="" id="itemName<%=inc%>" name="<%=ITEM_NAME%><%=inc%>"
			size="28" autocomplete="off" validate="Item Name,string,no"
			onblur="if(validateItemCodeForAutoComplete(this.value,'<%=inc %>')){openPopupForItem(this.value,<%=inc %>);}" />

		<div id="ac2update<%=inc%>" style="display: none;"
			class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

	    new Ajax.Autocompleter('itemName<%=inc%>','ac2update<%=inc%>','opBilling?method=getItemCodeForAutoComplete',{parameters:'requiredField=itemName<%=inc%>', callback: eventCallback});

		</script> <input type="hidden" id="itemId<%=inc %>" value="" /></td>

		<td><input type="text" size="5" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc%>" value="" validate="Qty,float,no"
			maxlength="3" readonly="readonly" /></td>
		<td><input type="text" size="10" value="" id="amount<%=inc%>"
			name="<%=AMOUNT%><%=inc%>" validate="Amount,float,no"
			readonly="readonly" /></td>
		<td><input type="text" value="" size="11"
			id="salesTaxAmt<%=inc%>" name="<%=SALES_TAX_AMOUNT %><%=inc%>"
			readonly="readonly" validate="Sales Tax Persentage,string,no" /></td>
		<td><input type="text" value="" id="dispercent<%=inc%>"
			name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" size="8"
			validate="Discount Persentage,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){calculateBatchWiseDiscount(<%=inc %>); calculateDiscountAmt(<%=inc%>);calculateNetAmtForDispensing(<%=inc %>);calculateTotalAmt();};"
			maxlength="3" /></td>
		<td><input type="text" value="" id="disamount<%=inc%>" size="10"
			name="<%=DISCOUNT %><%=inc%>" validate="Discount Amount,string,no"
			onchange="validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateBatchWiseDiscount(<%=inc %>);calculateNetAmtForDispensing(<%=inc %>);calculateTotalAmt();"
			maxlength="7" /></td>
		<td><input type="text" value="" id="prprtnlDis<%=inc%>"
			name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
			validate="Proporational Discount,string,no" readonly="readonly"
			size="12" /></td>
		<td><input type="text" size="10" value="" id="netamount<%=inc%>"
			name="<%=NET_AMOUNT %><%=inc%>" validate="Net Amount,float,no"
			readonly="readonly" /> <input type="hidden"
			id="itemBatchCount<%=inc %>" value="" /> <input type="hidden"
			name="<%=FA_ACCOUNT_ID %><%=inc%>" id="accountId<%=inc%>" value="" />
		<input type="hidden" name="<%=FA_SUB_LED_ID %><%=inc%>"
			id="subAccountId<%=inc%>" value="" /></td>
		<td><input type="button" name="add" value=""  id="add<%=inc %>"  class="buttonAdd"
			onclick="addRow();" tabindex="1" /></td>
	</tr>
	<%
		}
	%>
</table>
<!--table ends--> <input type="hidden" value="<%=inc %>"
	name="hiddenValueItem" id="hiddenValueCharge" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<%
if(tempOpBillHeader.getBillAmt() != null){
	totalBillAmt = tempOpBillHeader.getBillAmt();
}
%> <label>Bill Amt</label> <input type="text" id="totalAmtId"
	name="<%=BILL_AMOUNT %>" 
	value="<%=totalBillAmt %>"  /> <%
	BigDecimal chrtyAmt = new BigDecimal(0);
	if(tempOpBillHeader.getDiscountAmt() != null){
		chrtyAmt = tempOpBillHeader.getDiscountAmt();
	}
	%> <%
	if(patientTypeId == 8 || patientTypeId == 2){
%> <label>Staff Health Scheme</label> <%}else{ %> 
<label>Total Discount</label> <%} %> <%
BigDecimal compDisc = new BigDecimal(0);
if(tempOpBillHeader.getDiscount() != null){
	compDisc = tempOpBillHeader.getDiscount();
}
%> <input type="text" id="compDiscountId" name="compDiscount"
	value="<%=compDisc %>" /> <script
	type="text/javascript">

	var authorizerArr = new Array();

</script> <label>Total Charity</label> <%
BigDecimal charity = new BigDecimal(0);
if(tempOpBillHeader.getCharity() != null){
	charity = tempOpBillHeader.getCharity();
}
%> <input type="text" id="charityId" name="charity"
	 value="<%=charity %>" /> <input type="hidden"
	id="totalDisId" name="<%=DISCOUNT_AMOUNT %>" value="<%=chrtyAmt %>"
	class="small" readonly="readonly" /> <script type="text/javascript">

		var authorizerArr = new Array();

		</script> <%
	if(tempOpBillHeader.getConsultant() != null){
	%> <script type="text/javascript">
		document.getElementById('cnsltDocId').value = '<%=tempOpBillHeader.getConsultant().getId()%>';
	</script> <%}
%> <%
	BigDecimal roundOff = new BigDecimal(0);
	if(tempOpBillHeader.getRoundOff() != null){
		roundOff = tempOpBillHeader.getRoundOff();
	}
	%> <%
	if(tempOpBillHeader.getNetAmt() != null){
		totalNetAmt = tempOpBillHeader.getNetAmt();
	}
	%> 
	<div class="clear"></div>
<label>Round Off</label> <input type="text" id="roundId"
	name="<%=ROUND_OF_VALUE %>" value="<%=roundOff %>"
	 readonly="readonly" />
<label class="medium">Net Amt</label>
	<input type="text" id="totalNetId" name="<%=TOTAL_AMOUNT%>"
	value="<%=totalNetAmt %>"  readOnly />
	<input type="hidden" id="totalNetId1" name="<%=TOTAL_AMOUNT%>"
	value="<%=totalNetAmt %>" class="readOnlySmall" readOnly />


<%
BigDecimal chrtyOnBill = new BigDecimal(0);
if(tempOpBillHeader.getDiscountOnBill() != null){
	chrtyOnBill = tempOpBillHeader.getDiscountOnBill();
}
%> <label>Charity On Bill</label> <input type="text"
	id="discountOnBillId" name="<%=DISCOUNT_ON_BILL %>"
	value="<%=chrtyOnBill %>" class="small"
	onblur="divideDiscAmtToItem(this.value);calculateDiscAmtForBill(this.value,'DisOp');"
	validate="Charity On Bill,float,no" maxlength="5" /> <label
	class="smallAuto">(%)</label>
	<div class="clear"></div>
	<label>Bill Charity Amount</label> <input
	type="text" id="discountAmtBillId" name="discountAmtBillId" value=""
	 onblur="calculateDiscPercent(this.value);"
	validate="Bill Charity Amount,float,no" maxlength="5" />
	<% if(registered.equals("yes")){
		if (!adv.equals("") && (patientTypeId != 1 || patientTypeId != 4)) {
%> <%
	BigDecimal advAdjAmt = new BigDecimal(0);
	if(tempOpBillHeader.getAdvanceAdjustment() != null){
		advAdjAmt = tempOpBillHeader.getAdvanceAdjustment();
	}
	%> <label>Advance Adjustment</label> <input type="checkbox"
	id="advAdjCheckId" class="radioCheck" value=""
	onclick="displayAdvanceText(this);" /> <label id="amtLabel"
	style="display: none;" class="auto">Amount</label> <input type="text"
	id="advAdjId" name="<%=ADVANCE_ADJUSTMENT %>" value="<%=advAdjAmt %>"
	class="small" style="display: none;" maxlength="9"
	onblur="checkAdvanceAmt(this.value,'<%=adv %>');" /> <%
 	}else if(adv.equals("") && patientTypeId != 3){
 %> <%
	BigDecimal osAmt = new BigDecimal(0);
	if(tempOpBillHeader.getOutstanding() != null){
		osAmt = tempOpBillHeader.getOutstanding();
	}
	%> <label class="medium">Outstanding</label> <input type="text"
	id="outstandingId" name="<%=OUTSTANDING %>" value="<%=osAmt %>"
	class="small" onblur="checkOutstandingAmt(this.value);" maxlength="9" />
<%}
		}%> <%
	if(tempOpBillHeader.getNetAmt() != null){
		totalNetAmt = tempOpBillHeader.getNetAmt();
	}
	%> <label class="medium"><span id="mandatorySignId"
	style="display: none;">*</span> Authorizer</label> <select
	name="<%=AUTHORIZER_ID %>" id="authorizerId" disabled="disabled">
	<option value="0">Select</option>
	<%
		int counter =0 ;
		for (MasAuthorizer authorizer : authorizerList) {

	%>
	<option value="<%=authorizer.getId() %>"><%=authorizer.getAuthorizerName()%></option>
	<script type="text/javascript">

		authorizerArr[<%=counter%>] = new Array();
		authorizerArr[<%=counter%>][0] = <%=authorizer.getId()%>;
		authorizerArr[<%=counter%>][1] = "<%=authorizer.getAuthorizerCode()%>";
		authorizerArr[<%=counter%>][2] = "<%=authorizer.getAuthorizerName()%>";
		authorizerArr[<%=counter%>][3] = "<%=authorizer.getMinAuthorizeAmt()%>";
		authorizerArr[<%=counter%>][4] = "<%=authorizer.getMaxAuthorizeAmt()%>";

	</script>
	<%counter++;
		}
	%>
</select> <%
	if(tempOpBillHeader.getAuthorizer() != null){
	%> <script type="text/javascript">
		document.getElementById('authorizerId').value = '<%=tempOpBillHeader.getAuthorizer().getId()%>';
		document.getElementById('authorizerId').disabled = false;
	</script> <%}
%>

<div"><label>Payable Amt</label> <input
	type="text" id="payableAmtId" name="<%=PAYABLE_AMOUNT %>"
	value="<%=totalNetAmt %>"  readOnly /></div>
<input type="hidden" id="compDiscountId" name="compDiscount" value="" />
<input type="hidden" id="charityId" name="charity" value="" /> <input
	type="hidden" name="counter" id="counter" value="<%=inc %>" />


<div class="clear"></div>
</div>

<script type="text/javascript">
var bankArray=new Array();
</script>

<div class="clear"></div>
<h4>Payment Details</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="delete" class="buttonDel"
	onclick="removeRowForPayment();" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	id="paymentDetails">

	<tr>
		<th scope="col"></th>
		<th scope="col">Payment Mode</th>
		<th scope="col">Amount</th>
		<th scope="col">Cheque/Credit Card No</th>
		<th scope="col">Cheque/Credit Date</th>
		<th scope="col">Bank</th>
		<th scope="col">&nbsp;</th>
	</tr>
	<%
		int i = 1;
	%>
	<tr>
		<td><input type="radio" value="<%=inc%>" name="selectedPayMode"
			class="radioCheck" /></td>
		<td><select name="<%=PAYMENT_MODE %><%=i%>"
			id="paymentModeId<%=i %>"
			onchange="checkPaymentMode(this.value,<%=i %>);">
			<option value="">Select</option>
			<option value="C" selected="selected">Cash</option>
			<option value="Q">Cheque</option>
			<option value="R">Credit Card</option>
		</select></td>

		<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i%>"
			id="amt<%=i %>" value="<%=totalNetAmt %>" validate="Amount,string,no"
			maxlength="9"
			onblur="if(validateAmount(this.value,<%=i %>)){calculateOutstandingAmt();};" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i%>"
			id="cqeId<%=i %>" maxlength="20" readonly="readonly"
			onblur="validateCheque(this.value,<%=i%> );" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i%>"
			id="chqDate<%=i %>" readonly="readonly" /> <img id="calId<%=i %>"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			style="display: none;" validate="Pick a date" class="calender"
			onclick="setdate('',document.getElementById('chqDate<%=i %>'),event)" />
		</td>
		<td><select name="<%=BANK_NAME %><%=i%>" id="bankId<%=i %>"
			disabled="disabled">
			<option value="0">Select</option>
			<%
				int j = 0;
				for (MasBankMaster bankMaster : bankList) {
			%>
			<option value="<%=bankMaster.getId() %>"><%=bankMaster.getBankName()%></option>
			<script>
			bankArray[<%=j%>]= new Array();
			bankArray[<%=j%>][0] = "<%=bankMaster.getId()%>";
			bankArray[<%=j%>][1] = "<%=bankMaster.getBankName()%>";

		</script>
			<%
				j++;
				}
			%>
		</select></td>

		<td><input type="button" name="add" class="buttonAdd"
			onclick="addRowForPayment('billDispensing');" /></td>

	</tr>
</table>
<input type="hidden" value="1" name="hiddenValuePayment"
	id="hiddenValuePayment" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">
<label><span>*</span> Amount Tendered</label> <input type="text" id="actualColAmtId" name="actualColAmtId"
	onblur="showDifference();" value=""
	validate="Actual Collected Amount,float,no" maxlength="8" tabindex="1" />
<label><span>*</span> Balance To Be Returned</label>
<input type="text" value="" id="balToBeRId" name="balToBeRId" onblur="totalAdvCredit(this.value);"/>
<!-- <input type="text" value="0" style="border: 0px; font-size: 12; font: bold; padding-left: 5px;"
	id="netBalanceAmount" name="netBalanceAmount" readonly="readonly" /> -->
<label><span>*</span>Remaining Credit</label>
<input type="text" value="" id="remainCId" name="remainCId"/>
<div class="clear"></div>

<input type="checkbox" id="charitYId" class="radioCheck" value=""
			onclick="transferCharity(this);" /> 
<label>Refund Transfer To Charity</label>
<input type="text" id="charityTransferId" name="charityTransferId" class="" value=""
		onblur="adjustOPBillAmt(this.value);"	 validate="Discount On Bill,float,no" maxlength="5" />
<label>Charity Name</label>
<select name="charityIdd" id="charityIdd" validate="Charity Name,string,no">
<option value="0">--Select--</option>
<%
if(masCharityList!=null && masCharityList.size()>0){
	for(MasCharityType charityy:masCharityList){ %>
	<option value="<%=charityy.getId() %>"><%=charityy.getCharityTypeName().trim() %></option>
	<%}} %>
</select>
<div class="clear"></div></div>
<div class="clear"></div>
<script>
 function showDifference()
 {
 	var a=document.getElementById('actualColAmtId').value;
  	var a1=document.getElementById('payableAmtId').value;
  	if(a !=""){
  	if(parseFloat(a) < parseFloat(a1)){
  			alert("Collected Amount should not be less than Payable Amount.");
  			document.getElementById('actualColAmtId').value = "";
  			return false;
  		}
	document.getElementById('netBalanceAmount').value=parseFloat(a)-parseFloat(a1);
 	}else{
 		document.getElementById('netBalanceAmount').value = "";
 	}
 }
</script>


<div class="clear"></div>
<table id="batchDetails" style="display: none">
	<%

	int k = 0;
		if(tempBlDtSet.size() > 0){
				for(BlTempBillDispensingDetails tempBillDispensingDetails : tempBlDtSet ){
					k = k+1;
					BigDecimal	batchChrtyPercnt = new BigDecimal(0);
					BigDecimal	batchChrtyAmt = new BigDecimal(0);
					BigDecimal	batchPrptChrtyAmt = new BigDecimal(0);
					BigDecimal	batchSalesTaxAmt = new BigDecimal(0);
					if(tempBillDispensingDetails.getDiscountPercent() != null){
						batchChrtyPercnt = tempBillDispensingDetails.getDiscountPercent();
					}
					if(tempBillDispensingDetails.getDiscountAmt() != null){
						batchChrtyAmt = tempBillDispensingDetails.getDiscountAmt();
					}
					if(tempBillDispensingDetails.getProportionalDisAmt() != null){
						batchPrptChrtyAmt = tempBillDispensingDetails.getProportionalDisAmt();
					}
					if(tempBillDispensingDetails.getSalesTaxAmt() != null){
						batchSalesTaxAmt = tempBillDispensingDetails.getSalesTaxAmt();
					}
	%>
	<tr>
		<td><input id="parentRowNo<%=k %>" name="parentRowNo" type="text"><input
			id="batchId<%=k %>" name="batchId<%=k %>" type="text"
			value="<%=tempBillDispensingDetails.getBatch().getId() %>"></td>
		<td><input id="issueQtyId<%=k %>" name="issueQty<%=k %>"
			type="text" value="<%= tempBillDispensingDetails.getQty()%>"></td>
		<td><input id="batchItemId<%=k %>" name="batchItemId<%=k %>"
			type="text" value="<%=tempBillDispensingDetails.getItem().getId() %>"></td>
		<td><input id="batchAmtId<%=k %>" name="batchAmt<%=k %>"
			type="text" value="<%=tempBillDispensingDetails.getAmount() %>"></td>
		<td><input id="batchDisPerId<%=k %>" name="batchDisPer<%=k %>"
			type="text" value="<%= batchChrtyPercnt%>"></td>
		<td><input id="batchDisAmtId<%=k %>" name="batchDisAmt<%=k %>"
			type="text" value="<%= batchChrtyAmt%>"></td>
		<td><input id="batchPrptDisAmtId<%=k %>"
			name="batchPrptDisAmt<%=k %>" type="text"
			value="<%=batchPrptChrtyAmt %>"></td>
		<td><input id="batchSalesTaxAmt<%=k %>"
			name="batchSalesTaxAmt<%=k %>" type="text"
			value="<%=batchSalesTaxAmt %>"></td>
		<td><input id="batchNetAmtId<%=k %>" name="batchNetAmt<%=k %>"
			type="text" value="<%=tempBillDispensingDetails.getNetAmt() %>"></td>
	</tr>

	<%
				}
			}%>
</table>
<input type="hidden" id="totalBatchId" name="batchNoCounter"
	value="<%=k %>" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit" name="Submit11"
	tabindex="1"
	onclick="if(checkFilledRowForDispensing()){if(validateFieldsOnSubmit()){if(checkCollectedAmt()){submitProtoAjaxForCheckBatchAvailability('billDispensing','opBilling?method=checkBatchNo');}}}"
	align="right" /> <%
 if(registered.equals("yes") && tempBillList.size() == 0){
%> <input type="button" tabindex="1" class="buttonBig" name="Submit12"
	value="Temporary Bill"
	onclick="if(checkFilledRowForDispensing()){if(validateFieldsOnSubmit()){submitForm('billDispensing','opBilling?method=submitTemporaryBillDispensingDetails','validatePaymentAmt','validateChequeAndCreditCardDate');}}"
	align="right" /> <%} %> <input type="button" class="button" value="Back"
	onclick="submitFormCancel('billDispensing','opBilling?method=showBillDispensingJsp');" />
<input type="button" class="buttonHighlight" value="Reset"
	onclick="form.reset();resetAjaxValueForBilling();" />
	<input
	type="hidden" name="rows" id="rr" value="1" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">

function addRow(){
	var tbl = document.getElementById('itemDetails');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;

	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.className = 'radioCheck';
	e0.name='selectedItem';
	e0.id='selectedItem'+iteration;
	e0.className = 'radioCheck';
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell2 = row.insertCell(1);
	cell2.id = 'nameDiv'+iteration;
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=ITEM_NAME%>'+ (iteration);
	e2.id = 'itemName'+(iteration)
	e2.tabIndex="1";
	e2.size = '28';
	e2.autocomplete='off';
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
	e2.onblur= function(){
					if(validateItemCodeForAutoComplete(this.value,iteration)){openPopupForItem(this.value,iteration)};
					};

	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name='<%=ITEM_ID%>'+ (iteration);
	e21.id = 'itemId'+(iteration)
	cell2.appendChild(e2);
	e2.focus();
	cell2.appendChild(e21);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.readOnly = true;
	e1.name = '<%=ITEM_CODE%>'+ (iteration);
	e1.id = 'itemCode' + (iteration);
	cell2.appendChild(e1);
	cell2.appendChild(newdiv);

	new Ajax.Autocompleter('itemName'+iteration,'ac2update'+iteration,'opBilling?method=getItemCodeForAutoComplete',{parameters:'requiredField=itemName'+iteration, callback: eventCallback});

	var cell3 = row.insertCell(2);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=QUANTITY%>'+ (iteration);
	e3.id = 'qty'+(iteration)
	e3.maxLength ='3';
	e3.readOnly = true;
	e3.size='5';
	cell3.appendChild(e3);


	var cell4 = row.insertCell(3);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=AMOUNT%>'+ (iteration);
	e4.readOnly = true;
	e4.id='amount'+(iteration);
	e4.size = '10';
	cell4.appendChild(e4);

	var cell5 = row.insertCell(4);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='salesTaxAmt'+ (iteration);
	e5.id='salesTaxAmt'+(iteration);
	e5.size = '11';
	cell5.appendChild(e5);


	var cell6 = row.insertCell(5);
	var e6 = document.createElement('input');
	e6.type = 'text';
	e6.name='<%=DISCOUNT_PERCENTAGE%>'+ (iteration);
	e6.id='dispercent'+(iteration);
	e6.onchange = function(){
					if(checkDiscountAmt(iteration)){calculateBatchWiseDiscount(iteration);calculateDiscountAmt(iteration);calculateNetAmtForDispensing(iteration);calculateTotalAmt();};
				};
	e6.size = '8';
	e6.maxLength = '3';
	cell6.appendChild(e6);

	var cell7 = row.insertCell(6);
	var e7 = document.createElement('input');
	e7.type = 'text';
	e7.name='<%=DISCOUNT%>'+ (iteration);
	e7.id='disamount'+(iteration);
	e7.maxLength = '7';
	e7.size = '10';
	e7.onchange = function(){
					validateDiscAmt(this.value,iteration);disableDiscountPercent(iteration);calculateBatchWiseDiscount(iteration);calculateNetAmtForDispensing(iteration);calculateTotalAmt();
				};
	cell7.appendChild(e7);

	var cell8 = row.insertCell(7);
	var e8 = document.createElement('input');
	e8.type = 'text';
	e8.name='<%=PROPORTIONAL_DISCOUNT%>'+ (iteration);
	e8.id='prprtnlDis'+(iteration);
	e8.readOnly = true;
	e8.size = '12';
	cell8.appendChild(e8);

	var cell9 = row.insertCell(8);
	var e9 = document.createElement('input');
	e9.type = 'text';
	e9.name='<%=NET_AMOUNT%>'+ (iteration);
	e9.id='netamount'+(iteration);
	e9.readOnly = true;
	e9.size='10';
	cell9.appendChild(e9);

	var e10 = document.createElement('input');
	e10.type = 'hidden';
	e10.size = '10';
	e10.id='itemBatchCount'+(iteration);
	cell9.appendChild(e10);

	var e11 = document.createElement('input');
	e11.type = 'hidden';
	e11.size = '10';
	e11.name='<%=FA_ACCOUNT_ID%>'+ (iteration);
	e11.id='accountId'+(iteration);
	cell9.appendChild(e11);

	var e12 = document.createElement('input');
	e12.type = 'hidden';
	e12.size = '10';
	e12.name='<%=FA_SUB_LED_ID%>'+ (iteration);
	e12.id='subAccountId'+(iteration);
	cell9.appendChild(e12);


	var cell10 = row.insertCell(9);
	var e13 = document.createElement('input');
	e13.type = 'button';
	e13.name='add';
	e13.id='add'+iteration;
	e13.className = 'buttonAdd';
	e13.tabIndex="1";
	e13.onclick = function(){
					addRow();
	}
	cell10.appendChild(e13);


}

function removeRow()
{
	var tbl = document.getElementById('itemDetails');
	var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	var parentRowNo = 0;
	for(counter=0;counter<(tblRows.length-1);counter++)
	{
			if (document.getElementsByName('selectedItem')[counter].checked == true) {
				parentRowNo = document.getElementsByName('selectedItem')[counter].value;
				tbl.deleteRow(counter+1);
		  		calculateTotalAmt();
		  	}
	}
	var tblBat1 = document.getElementById('batchDetails');
	var rowcount = tblBat1.getElementsByTagName("tr").length;
	var checkedObjArray = new Array();
	var cCount = 0;
	for(var i=0;i<rowcount;i++){
			if(document.getElementsByName('parentRowNo')[i].value == parentRowNo){
				checkedObjArray[cCount] = tblBat1.tBodies[0].rows[i];
				cCount++;
			//	tblBat1.deleteRow(i);

		}
	}

	 if (checkedObjArray.length > 0) {
			var rIndex = checkedObjArray[0].sectionRowIndex;
			deleteRows(checkedObjArray);
		}

}
function deleteRows(rowObjArray)
{
		for (var i=0; i<rowObjArray.length; i++) {
			var rIndex = rowObjArray[i].sectionRowIndex;
			rowObjArray[i].parentNode.deleteRow(rIndex);
		}

}

function openPopupForItem(val,rowVal){

var code = "";
	if(val != ""){
		var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var code = val.substring(index1,index2);
		if(code !=""){
			window.open('opBilling?method=showItemBatchNoPopUp&itemCode='+encodeURIComponent(code)+'&rowVal='+rowVal+'&hinId='+<%=hinId%>+'&patientTypeId=<%=patientTypeId%>&deptCode=PHAR','mywindow','target="_blank", width=780,height=300');

		}
	}
}

(document.getElementById("cnsltDocId").focus());
 </script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
