<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>

<%--For AutoComplete Through Ajax--%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.BlTempOpBillHeader"%>
<%@page import="jkt.hms.masters.business.BlTempOpBillDetails"%>
<%@page import="jkt.hms.masters.business.MasChargeCodeRates"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>
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
</script>
<form name="billServicing" method="post" action=""
	onload="form.reset();">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<OpdSurgeryHeader> orderHdList = new ArrayList<OpdSurgeryHeader>();
	List<OpdSurgeryDetail> orderdtList = new ArrayList<OpdSurgeryDetail>();
	List<BlTempOpBillHeader> tempBillList = new ArrayList<BlTempOpBillHeader>();

	List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
	List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
	List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("employeeList") != null) {
		employeeList = (List<MasEmployee>) map.get("employeeList");
	}
	if (map.get("patientList") != null) {
		patientList = (List<Patient>) map.get("patientList");
		
	}
	if (map.get("orderHdList") != null) {
		orderHdList = (List<OpdSurgeryHeader>) map.get("orderHdList");
	}
	if (map.get("orderdtList") != null) {
		orderdtList = (List<OpdSurgeryDetail>) map.get("orderdtList");
	}
	if (map.get("tempBillList") != null) {
		tempBillList = (List<BlTempOpBillHeader>) map.get("tempBillList");
	}
	if (map.get("mainChargeCodeList") != null) {
		mainChargeCodeList = (List<MasMainChargecode>) map.get("mainChargeCodeList");
	}
	if (map.get("subChargeCodeList") != null) {
		subChargeCodeList = (List<MasSubChargecode>) map.get("subChargeCodeList");
	}
	if (map.get("authorizerList") != null) {
		authorizerList = (List<MasAuthorizer>) map.get("authorizerList");
	}
	if (map.get("bankList") != null) {
		bankList = (List<MasBankMaster>) map.get("bankList");
	}
	if (map.get("sexList") != null) {
		sexList = (List<MasAdministrativeSex>) map.get("sexList");
	}
	if (map.get("templateList") != null) {
		templateList = (List<OpdTemplate>) map.get("templateList");
	}
	BigDecimal chargeAmountAfterDis = new BigDecimal(0.00);
	
	if(map.get("chargeAmountAfterDis") != null){
		chargeAmountAfterDis = (BigDecimal)map.get("chargeAmountAfterDis");
	}
	
	String registered = "";
	if (map.get("registered") != null) {
		registered = (String) map.get("registered");
	}
	String maxBlNo = "";
	if (map.get("maxBlNo") != null) {
		maxBlNo = (String) map.get("maxBlNo");
	}
	int orderNo = 0;
	if (map.get("orderNo") != null) {
		orderNo = (Integer) map.get("orderNo");
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
	BlTempOpBillHeader tempOpBillHeader = new BlTempOpBillHeader();
	float refundAmt = 0;
%>

<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>


<div class="titleBg">
<h2>OT Bill Servicing</h2>
</div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><label>Bill No.</label> <label class="value"><%=maxBlNo%></label>

<label>Bill Date</label> <label class="value"><%= date%></label> <label>Bill
Time</label> <label class="value"><%= time%></label>

<div class="clear"></div>

<%	int patientTypeId=0;
	String adv = "";
	int hin = 0;
	String pastDue = "";
	String registrationType = "";
	if (registered.equals("yes")) {
		if (patientList.size() > 0) {
			Patient patient = patientList.get(0);
			hin = patient.getId();
			if(patient.getRegistrationType()!= null){
				registrationType = patient.getRegistrationType();
			}
			if (patient.getPastDue() != null)
				pastDue = patient.getPastDue();

			patientTypeId = patient.getPatientType().getId();
%>
	<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
	<label class="value"><%=patient.getHinNo()%></label>

	<label>Patient Name</label>
<%
	String Pname = patient.getPFirstName();
	if(patient.getPMiddleName() != null)
		{
			Pname = Pname.concat(" ").concat(patient.getPMiddleName());
		}
		if(patient.getPLastName() != null)
		{
			Pname = Pname.concat(" ").concat(patient.getPLastName());
		}
%>
 	<label class="value"><%=Pname%></label>

	<label>Age</label>
	<label class="value"><%=patient.getAge()%></label>
<%
	if (orderNo!=0) {
%>
<div class="clear"></div>
<label>Order No.</label> <label class="value"><%=orderNo%></label> <input
	type="hidden" name="<%=ORDER_NO %>" value="<%=orderNo %>" /> <%
	}
			String doctorName = "";
			int visitNo	 = 0;
			int visitId = 0;
			int tokenNo = 0;
			int employeeId=0;
			if (orderHdList.size() > 0) {
				doctorName = orderHdList.get(0).getEmployee().getFirstName();
				if (orderHdList.get(0).getEmployee().getMiddleName() != null) {
					doctorName = doctorName.concat(" ").concat(orderHdList.get(0).getEmployee().getMiddleName());
				}
				if (orderHdList.get(0).getEmployee().getLastName() != null){
					doctorName = doctorName.concat(" ").concat(orderHdList.get(0).getEmployee().getLastName());
				}
				
				if (orderHdList.get(0).getEmployee().getId() != null){
					employeeId = orderHdList.get(0).getEmployee().getId();
				}

				if(orderHdList.get(0).getVisit() != null){
					visitNo = orderHdList.get(0).getVisit().getVisitNo();
					visitId = orderHdList.get(0).getVisit().getId();
					tokenNo = orderHdList.get(0).getVisit().getTokenNo();
				}
%> <label>Visit No.</label> <label class="value"> <%=visitNo%></label> <label>Consultant
Name</label> <label class="value"> <%=doctorName%></label> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%= visitId%>" />
	<input type="hidden" name="<%=TOKEN_NO %>" value="<%= tokenNo%>" />
	<input type="hidden" name="<%=EMPLOYEE_ID %>" id="cnsltDocId" value=<%=employeeId %> >
	 <%
	} else {
%> <label><span>*</span> Consultant Name</label> <select
	name="<%=EMPLOYEE_ID %>" id="cnsltDocId"
	validate="Consultant Name,string,yes" tabindex=1
	onchange="displayName();">
	<option value="0">Select</option>
	<%
		for (MasEmployee employee : employeeList) {
			if (employee.getEmpCategory() != null) {
				if (employee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)) {

					String doctorMiddleName = "";
					String doctorLastName = "";
					if (employee.getMiddleName() != null)
						doctorMiddleName = employee.getMiddleName();
					if (employee.getMiddleName() != null)
						doctorLastName = employee.getLastName();
	%>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()+" " + doctorMiddleName + " "+ doctorLastName%></option>
	<%
		}
						}
					}
	%>
</select> <%
 	}
 %> <%
 	String sign = "";
 			if (!pastDue.equals("")) {
 				sign = pastDue.substring(0, 1);
 				if (sign.equals("-")) {
 					adv = pastDue.substring(1);
 				}
 			}
 			if (!adv.equals("")) {
 %> <label>Total Advance</label> <label class="value"><%=adv%></label> <%
 	}
 %> <label>Patient Type</label> <label class="value"><%=patient.getPatientType().getPatientTypeName() %></label>
<%
 	if(patient.getCompany() != null){
 		if(patient.getPatientType().getId() == 1){
 %> <label>Company</label> <%}else if(patient.getPatientType().getId() == 4){ %>
<label>Project</label> <%} %> <label class="value"><%=patient.getCompany().getCompanyName() %></label>
<input type="hidden" id="companyId" name="companyId"
	value="<%=patient.getCompany().getId() %>" /> <%} %> <input
	type="hidden" id="patientTypeId" name="<%=PATIENT_TYPE_ID%>"
	value="<%=patientTypeId %>" /> <input type="hidden"
	id="patientTypeCode" name="patientTypeCode"
	value="<%=patient.getPatientType().getPatientTypeCode()%>" /> <input
	type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" /> <input
	type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>" />
	<%
		String PatName = patient.getPFirstName();
		if(patient.getPMiddleName() != null)
		{
			PatName = PatName.concat(" ").concat(patient.getPMiddleName());
		}
		if(patient.getPLastName() != null)
		{
			PatName = PatName.concat(" ").concat(patient.getPLastName());
		}
	%>
<input type="hidden" name="<%=PATIENT_NAME%>"	value="<%=PatName%>" />
<input type="hidden" name="<%=AGE%>" value="<%=patient.getAge() %>" />
<input type="hidden" name="<%=SEX_ID%>"
	value="<%=patient.getSex().getId() %>" />
	<%if(patient.getNextOfKinName() != null){ %>
	<input	type="hidden" name="<%=RELATIVE_NAME%>"
	value="<%=patient.getNextOfKinName() %>" />
<%} %>
	<input	type="hidden" name="<%=REGISTRATION_TYPE%>"
	value="<%=patient.getRegistrationType() %>" />
	<%
 	}
 	} else {
 %> <label><span>*</span> Patient Name</label> <input type="text"
	name="<%=PATIENT_NAME%>" value="" validate="Patient Name,string,yes"
	MAXLENGTH="40" tabindex=1 /> <label> <span>*</span> Age</label> <input
	type="text" name="<%=AGE%>" value="" validate="Age,string,yes"
	MAXLENGTH="3" tabindex=1 /> <label><span>*</span> Sex</label> <select
	name="<%=SEX_ID %>" validate="Sex,string,yes">
	<option value="0">Select</option>
	<%
		for (MasAdministrativeSex sexObj : sexList) {
	%>
	<option value="<%=sexObj.getId() %>"><%=sexObj.getAdministrativeSexName()%></option>
	<%
		}
	%>
</select>
<div class="clear"></div>
<label><span>*</span> Consultant Name</label> <select
	name="<%=EMPLOYEE_ID %>" id="cnsltDocId"
	validate="Consultant Name,string,yes" tabindex=1
	onchange="displayName();">
	<option value="0">Select</option>
	<%
		for (MasEmployee employee : employeeList) {
			if (employee.getEmpCategory() != null) {
				if (employee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)) {

					String doctorMiddleName = "";
					String doctorLastName = "";
					if (employee.getMiddleName() != null)
						doctorMiddleName = employee.getMiddleName();
					if (employee.getMiddleName() != null)
						doctorLastName = employee.getLastName();
	%>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()+" " + doctorMiddleName + " "+ doctorLastName%></option>
	<%
		}
						}
					}
	%>
</select> <%
 	}
 %> <input type="hidden" id="cnsltDocTextId"
	name="<%=CONSULTING_DOCTOR%>" value="" /> <script
	type="text/javascript">
	(document.getElementById("cnsltDocId").focus());
	</script>



<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Charge Details</h4>

<div class="clear"></div>
<div class="Block"><label>Main Charge</label> <select
	id="mainChargeCodeId" name="<%=MAIN_CHARGECODE_ID %>"
	onchange="populateSubChargeCodeForBilling(this.value,'billServicing');">
	<option value="0">Select</option>
	<%
		for (MasMainChargecode mainChargecode : mainChargeCodeList) {
	%>
	<option value="<%=mainChargecode.getId() %>"><%=mainChargecode.getMainChargecodeName()%></option>
	<%
		}
	%>
</select> <script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasMainChargecode mainChargecode : mainChargeCodeList)
			{
				for (MasSubChargecode subChargecode : subChargeCodeList)
				{
					if(subChargecode.getMainChargecode() != null){
						if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId() )){
			%>
							subChargeCodeArray[<%=counter1%>] = new Array();
							subChargeCodeArray[<%=counter1%>][0]=<%=mainChargecode.getId()%>;
							subChargeCodeArray[<%=counter1%>][1] = <%=subChargecode.getId()%>;
							subChargeCodeArray[<%=counter1%>][2] = "<%=subChargecode.getSubChargecodeName()%>";
					<%
						counter1++;
					}
				}
			}
		}

		%>
		</script> <label>Sub Charge</label> <select id="subChargeCodeId"
	name="<%=SUB_CHARGECODE_ID %>">
	<option value="0">Select</option>
	<%
		for (MasSubChargecode subChargecode : subChargeCodeList) {
	%>
	<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName()%></option>
	<%
		}
	%>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" />
<%
	if(orderdtList.size() == 0 && tempBillList.size() == 0){
%>
<label>Select Template</label>
<select name="template" id="template" onchange="submitProtoAjax('billServicing','/hms/hms/opBilling?method=getTemplateDetailsForBilling&type=op');" onblur="submitProtoAjax('billServicing','/hms/hms/opBilling?method=getTemplateDetailsForBilling&type=op')">
<option value="">Select</option>
<%
	for(OpdTemplate opdTemplate : templateList){
		%>
		<option value="<%=opdTemplate.getId() %>"><%=opdTemplate.getTemplateName() %></option>
	<%}
%>
<%} %>
</select>
<div class="clear"></div>
<div id="testDiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Charge Description</th>
		<th scope="col">Qty</th>
		<th scope="col">Rate</th>
		<th scope="col">Std. Deduction</th>
		<th scope="col">Amount</th>
		<th scope="col">Disc(%)</th>
		<th scope="col">Disc Amt</th>
		<th scope="col" style="display: none;">Charity</th>
		<th scope="col">Net Amount</th>
		<th scope="col">Print Required</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%
		int inc = 0;
	BigDecimal billAmt = new BigDecimal(0.00);
Date currentDate = new Date();
		BigDecimal totalBillAmt = new BigDecimal("0");
		BigDecimal totalNetAmt = new BigDecimal("0");
		BigDecimal charge = new BigDecimal("0");
		int orderHdId = 0;
		if (orderdtList.size() > 0) {
			
			for (int i = 0; i < orderdtList.size(); i++) {
				inc++;
				OpdSurgeryDetail orderDt = new OpdSurgeryDetail();
				orderDt = orderdtList.get(i);
		//		if (orderDt.getPaymentMade().equals("n")) {
 				
	    			
					orderHdId = orderDt.getOpdSurgery().getId();
					 Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
						if(orderDt.getChargeCode().getMasChargeCodeRates() != null){
							chargeSet = orderDt.getChargeCode().getMasChargeCodeRates();
							if(chargeSet.size() > 0){
								for(MasChargeCodeRates chargeRate : chargeSet){
									if(currentDate.compareTo(chargeRate.getEffectiveFromDate()) >= 0 && (chargeRate.getEffectiveToDate() == null || currentDate.compareTo(chargeRate.getEffectiveToDate()) <= 0)){
										
										//charge = chargeRate.getRate();
										charge = new BigDecimal(orderDt.getChargeCode().getCharge());
										break;
									}else{
										//charge = new BigDecimal(orderDt.getChargeCode().getCharge());
										charge = new BigDecimal(orderDt.getChargeCode().getCharge());
									}

								}

							}else{
								//charge = new BigDecimal(orderDt.getChargeCode().getCharge());
								charge = new BigDecimal(orderDt.getChargeCode().getCharge());
							}

						}else{
							//charge = new BigDecimal(orderDt.getChargeCode().getCharge());
							charge = new BigDecimal(orderDt.getChargeCode().getCharge());
						}

	%>
	<tr>

		<td><input type="hidden" name="<%=ORDER_BOOKING_ID %>"
			value="<%=orderHdId %>" /> <input type="hidden"
			name="<%=DG_ORDER_DETAIL_ID %><%=inc %>"
			value="<%=orderDt.getId() %>" /> <input type="radio"
			value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>

		<td><input type="text" name="chargeCode<%=inc%>" id="chargeCode<%=inc%>"
			value="<%=orderDt.getChargeCode().getChargeCodeName() %>[<%=orderDt.getChargeCode().getChargeCodeCode() %>]"
			onblur="if(validateChargeCodeForBillingAutoComplete(this.value, '<%=inc%>','op')){submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge1='+encodeURIComponent(this.value)+'&rowVal=1&hin=<%=hin%>&type=op','rateVal');}"
			readonly="readonly" tabindex="1" />
		<div id="ac2update<%=inc%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		function eventCallback(element, entry){
					return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value;
		}
		</script>

		<input type="hidden" id="chargeId<%=inc %>"
			name="<%=CHARGE_CODE_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getId()%>" /></td>

		<td><input type="text" size="5" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc%>" value="1"
			validate="Qty,int,no"
			onblur="if(validateQtyForBilling(this.value,this.id,<%=inc %>)){calculateNetAmount(<%=inc %>);calcProportionalDisc(<%=inc %>);calculateTotalAmt();};"
			maxlength="5" readonly="readonly" /></td>
		<td id="rateVal"><input type="text" size="12"
			value="<%=charge %>" id="rate<%=inc%>" name="<%=RATE%><%=inc%>"
			validate="Rate,float,no" readonly="readonly"
			onblur="calculateNetAmount(<%=inc %>);calculateTotalAmt();" /></td>

		<%
		BigDecimal stdDedGen = new BigDecimal(0.00);
		BigDecimal stdDedSpl = new BigDecimal(0.00);
		if(registrationType.equals("G")){
			if(orderDt.getChargeCode().getStdDeductionGen() != null){
				stdDedGen = orderDt.getChargeCode().getStdDeductionGen();
			}
		%>

		<td><input type="text" size="12" value="<%=stdDedGen %>"
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%}else if(registrationType.equals("S")){
			if(orderDt.getChargeCode().getStdDeductionSpl() != null){
				stdDedSpl = orderDt.getChargeCode().getStdDeductionSpl();
			}
			%>
		<td><input type="text" size="12" value="<%=stdDedSpl %>"
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%}else{ %>
		<td><input type="text" size="12" value=""
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%} %>
		<%

			billAmt = new BigDecimal(1).multiply(charge);
			if(stdDedGen.compareTo(new BigDecimal(0)) > 0){
				billAmt = billAmt.subtract(stdDedGen);
			}else if(stdDedSpl.compareTo(new BigDecimal(0)) > 0){
				billAmt = billAmt.subtract(stdDedSpl);
			}
		%>
		<td><input type="text" size="13" value="<%=billAmt %>"
			id="amount<%=inc%>" name="<%=AMOUNT%><%=inc%>"
			validate="Amount,float,no" readonly="readonly" /></td>

		<%
			if(orderDt.getChargeCode().getDiscountable().equals("y")){
				BigDecimal discPer = new BigDecimal(0);
				if(orderDt.getChargeCode().getDiscountPercentage() != null){
					discPer = orderDt.getChargeCode().getDiscountPercentage();
				}

		%>
		<td><input type="text" value="<%=discPer %>"
			id="dispercent<%=inc%>" name="<%=DISCOUNT_PERCENTAGE %><%=inc%>"
			size="5" validate="Discount Persentage,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
			maxlength="3" /></td>
		<td><input type="text" value="" id="disamount<%=inc%>"
			name="<%=DISCOUNT %><%=inc%>" validate="Discount Amount,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
			maxlength="7" size="7" /></td>
		<%}else{ %>
		<td><input type="text" value="" id="dispercent<%=inc%>"
			name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" size="5"
			validate="Discount Persentage,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
			maxlength="3" disabled="disabled" /></td>
		<td><input type="text" value="" id="disamount<%=inc%>"
			name="<%=DISCOUNT %><%=inc%>" validate="Discount Amount,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
			maxlength="7" disabled="disabled" size="10" /></td>
		<%} %>

		<td style="display: none;"><input type="text" value="" id="prprtnlDis<%=inc%>"
			name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>" style="display: none;" 
			validate="Proporational Discount,string,no" readonly="readonly"
			size="10" /></td>
			
		<td><input type="text" value="<%=billAmt%>"
			id="netamount<%=inc%>" name="<%=NET_AMOUNT %><%=inc%>"
			validate="Net Amount,float,no" readonly="readonly" size="10" /></td>

		<td>
		
				<input type="checkbox" id="printReq<%=inc%>" name="printReq<%=inc%>" value="y"
				onclick="getOldAdNo(<%=inc%>);" disabled="disabled" />
		
		</td>

		<td><input type="button" name="add" value="" class="buttonAdd"
			onclick="addRow();" tabindex="1" /></td>
		<input id="discntPercentId<%=inc %>" type="hidden"
			name="discntPercent<%=inc %>"
			value="<%=orderDt.getChargeCode().getDiscountPercentage()%>" />
		<input type="hidden" name="<%=MAIN_CHARGECODE_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getMainChargecode().getId()%>" />
		<input type="hidden" name="<%=SUB_CHARGECODE_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getSubChargecode().getId()%>" />
		<input type="hidden" name="<%=FA_ACCOUNT_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getAccount().getId()%>" />
		<%
int subLdId =0 ;
if (orderDt.getChargeCode().getSubAccount() != null) {
	subLdId = orderDt.getChargeCode().getSubAccount().getId();
}
%>
		<input type="hidden" name="<%=FA_SUB_LED_ID%><%=inc %>"
			value="<%=subLdId%>" />

		<%
		if(orderDt.getChargeCode().getMainChargecode().getDepartment() != null){
	%>
		<input type="hidden" name="<%=DEPARTMENT_TYPE_CODE%><%=inc %>"
			value="<%=orderDt.getChargeCode().getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode()%>" />
		<input type="hidden" name="<%=DEPARTMENT_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getMainChargecode().getDepartment().getId()%>" />

		<%}
	%>
		<%
			if(orderDt.getChargeCode().getDiscountable().equals("y") ){
		%>
		<script type="text/javascript">
				document.getElementById('dispercent<%=inc%>').readOnly = false;
				document.getElementById('disamount<%=inc%>').readOnly = false;
			</script>
		<%}else{ %>
		<script type="text/javascript">
				document.getElementById('dispercent<%=inc%>').readOnly = true;
				document.getElementById('disamount<%=inc%>').readOnly = true;
			</script>
		<%} %>

		<%
			if(orderDt.getChargeCode().getEditable().equals("y") ){
		%>
		<script type="text/javascript">
				document.getElementById('rate<%=inc%>').readOnly = false;
			</script>
		<%}else{ %>
		<script type="text/javascript">
				document.getElementById('rate<%=inc%>').readOnly = true;
			</script>
		<%} %>
	</tr>

	<%
					BigDecimal chargeAmt = new BigDecimal(1).multiply(charge);
					//BigDecimal netAmt = new BigDecimal(orderDt.getOrderQty()).multiply(charge);
					totalBillAmt = totalBillAmt.add(chargeAmt);
					totalNetAmt = totalNetAmt.add(billAmt);
				
 		//}
			}

	}else if (tempBillList.size() > 0) {
			tempOpBillHeader = tempBillList.get(0);
			Set<BlTempOpBillDetails> tempBlDtSet = new HashSet<BlTempOpBillDetails>();
			tempBlDtSet = tempOpBillHeader.getBlTempOpBillDetails();
	%>
	<input type="hidden" name="tempBillHdId"
		value="<%=tempOpBillHeader.getId() %>" />
	<%	for (BlTempOpBillDetails tempBlDetails : tempBlDtSet) {
			inc = inc+1;
			Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
			if(tempBlDetails.getChargeCode().getMasChargeCodeRates() != null){
				chargeSet = tempBlDetails.getChargeCode().getMasChargeCodeRates();
				if(chargeSet.size() > 0){
					for(MasChargeCodeRates chargeRate : chargeSet){
							if(currentDate.compareTo(chargeRate.getEffectiveFromDate()) >= 0 && (chargeRate.getEffectiveToDate() == null || currentDate.compareTo(chargeRate.getEffectiveToDate()) <= 0)){
							//charge = chargeRate.getRate();
							charge = chargeAmountAfterDis;
							break;
						}else{
							//charge = new BigDecimal(tempBlDetails.getChargeCode().getCharge());
							charge = chargeAmountAfterDis;
						}

					}

				}else{
					//charge = new BigDecimal(tempBlDetails.getChargeCode().getCharge());
					charge = chargeAmountAfterDis;
				}

			}else{
				//charge = new BigDecimal(tempBlDetails.getChargeCode().getCharge());
				charge = chargeAmountAfterDis;
			}
	%>
	<tr>

		<td><input type="hidden" name="tempBillDetailsId<%=inc %>"
			value="<%=tempBlDetails.getId() %>" /> <input type="radio"
			value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>

		<td><input type="text" name="chargeCode<%=inc%>"
			id="chargeCode<%=inc%>"
			value="<%=tempBlDetails.getChargeCode().getChargeCodeName() %>[<%=tempBlDetails.getChargeCode().getChargeCodeCode() %>]"
			onblur="if(validateChargeCodeForBillingAutoComplete(this.value, '<%=inc %>','op')){submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge1='+encodeURIComponent(this.value)+'&rowVal=1&hin=<%=hin%>&type=op','rateVal');}"
			readonly="readonly" tabindex="1" />

		<div id="ac2update<%=inc%>" style="display: none;"
			class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		 function eventCallback(element, entry){
					return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value;
			}
		</script> <input type="hidden" id="chargeId<%=inc %>"
			name="<%=CHARGE_CODE_ID%><%=inc %>"
			value="<%=tempBlDetails.getChargeCode().getId()%>" /></td>

		<td><input type="text" size="5" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc%>"
			value="<%=tempBlDetails.getQuantity() %>" validate="Qty,int,no"
			onblur="if(validateQtyForBilling(this.value,this.id,<%=inc %>)){calculateNetAmount(<%=inc %>);calcProportionalDisc(<%=inc %>);calculateTotalAmt();};"
			maxlength="5" readonly="readonly" /></td>
		<td id="rateVal"><input type="text" size="12"
			value="<%=charge %>" id="rate<%=inc%>" name="<%=RATE%><%=inc%>"
			validate="Rate,float,no" readonly="readonly"
			onblur="calculateNetAmount(<%=inc %>);calculateTotalAmt();" /></td>

		<%if(registrationType.equals("G")){ %>

		<td><input type="text" size="12"
			value="<%=tempBlDetails.getChargeCode().getStdDeductionGen()%>"
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%}else if(registrationType.equals("S")){ %>
		<td><input type="text" size="12"
			value="<%=tempBlDetails.getChargeCode().getStdDeductionSpl()%>"
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%}else{ %>
		<td><input type="text" size="12" value=""
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%} %>
		<td><input type="text" size="13"
			value="<%=tempBlDetails.getAmount() %>" id="amount<%=inc%>"
			name="<%=AMOUNT%><%=inc%>" validate="Amount,float,no"
			readonly="readonly" /></td>

		<td>
		<%	BigDecimal discPer = new BigDecimal(0);
			if(tempBlDetails.getDiscountPercent() != null){
				discPer = tempBlDetails.getDiscountPercent();
			}
		%> <input type="text" value="<%=discPer %>" id="dispercent<%=inc%>"
			name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" size="5"
			validate="Discount Persentage,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
			maxlength="3" disabled="disabled" size="5" /></td>

		<td>
		<%	BigDecimal discAmt = new BigDecimal(0);
			if(tempBlDetails.getDiscountAmt() != null){
				discAmt = tempBlDetails.getDiscountAmt();
			}
		%> <input type="text" value="<%=discAmt %>" id="disamount<%=inc%>"
			name="<%=DISCOUNT %><%=inc%>" validate="Discount Amount,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
			maxlength="7" disabled="disabled" size="7" /></td>
		<td style="display: none;">
		<%	BigDecimal prptDiscAmt = new BigDecimal(0);
			if(tempBlDetails.getProportionalDiscountAmount() != null){
				prptDiscAmt = tempBlDetails.getProportionalDiscountAmount();
			}
		%> <input type="text" value="<%=prptDiscAmt %>" style="display: none;"
			id="prprtnlDis<%=inc%>" name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
			validate="Proporational Discount,string,no" readonly="readonly"
			size="10" /></td>
		<td><input type="text" value="<%=tempBlDetails.getNetAmt() %>"
			id="netamount<%=inc%>" name="<%=NET_AMOUNT %><%=inc%>"
			validate="Net Amount,float,no" readonly="readonly" size="10" /></td>

		<td>
		<input type="checkbox" id="printReq<%=inc%>" name="printReq<%=inc%>" value="y"
		onclick="getOldAdNo(<%=inc%>);" disabled="disabled" />
		</td>

		<td><input type="button" name="add" value="" class="buttonAdd"
			onclick="addRow();" onblur="addRow();" tabindex="1" /></td>

		<input id="discntPercentId<%=inc %>" type="hidden"
			name="discntPercent<%=inc %>"
			value="<%=tempBlDetails.getChargeCode().getDiscountPercentage()%>" />
		<input type="hidden" name="<%=MAIN_CHARGECODE_ID%><%=inc %>"
			value="<%=tempBlDetails.getChargeCode().getMainChargecode().getId()%>" />
		<input type="hidden" name="<%=SUB_CHARGECODE_ID%><%=inc %>"
			value="<%=tempBlDetails.getChargeCode().getSubChargecode().getId()%>" />
		<input type="hidden" name="<%=FA_ACCOUNT_ID%><%=inc %>"
			value="<%=tempBlDetails.getChargeCode().getAccount().getId()%>" />
		<%
int subLdId =0 ;
if (tempBlDetails.getChargeCode().getSubAccount() != null) {
	subLdId = tempBlDetails.getChargeCode().getSubAccount().getId();
}
%>
		<input type="hidden" name="<%=FA_SUB_LED_ID%><%=inc %>"
			value="<%=subLdId%>" />

		<%
		if(tempBlDetails.getChargeCode().getMainChargecode().getDepartment() != null){
	%>
		<input type="hidden" name="<%=DEPARTMENT_TYPE_CODE%><%=inc %>"
			value="<%=tempBlDetails.getChargeCode().getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode()%>" />
		<input type="hidden" name="<%=DEPARTMENT_ID%><%=inc %>"
			value="<%=tempBlDetails.getChargeCode().getMainChargecode().getDepartment().getId()%>" />

		<%}
	%>
	</tr>

	<%

			}

		} else {
			inc = inc +1;
	%>
	<tr>

		<td><input type="radio" value="<%=inc%>" name="selectedChrage"
			class="radioCheck" /></td>
		<td><input type="text" name="chargeCode<%=inc%>"
			id="chargeCode<%=inc%>"
			onblur="if(validateChargeCodeForBillingAutoComplete(this.value, '<%=inc %>','op')){submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge1='+encodeURIComponent(this.value)+'&rowVal=1&hin=<%=hin%>&type=op','rateVal');}"
			tabindex="1" />
		<div id="ac2update<%=inc%>" style="display: none;"
			class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			   function eventCallback(element, entry){
					return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value;
				}
			    new Ajax.Autocompleter('chargeCode<%=inc%>','ac2update<%=inc%>','opBilling?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode<%=inc%>', callback: eventCallback});

			</script></td>
		<td><input type="text" size="5" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc%>" value="" validate="Qty,int,no"
			onblur="if(validateQtyForBilling(this.value,this.id,<%=inc %>)){calculateNetAmount(<%=inc %>);calcProportionalDisc(<%=inc %>);calculateTotalAmt();}"
			maxlength="5" readonly="readonly" /></td>
		<td id="rateVal"><input type="text" size="12" value=""
			id="resrate<%=inc%>" name="<%=RATE%><%=inc%>"
			validate="Rate,float,no" readonly="readonly" /></td>

		<%if(registrationType.equals("G")){ %>

		<td><input type="text" size="12" value=""
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%}else if(registrationType.equals("S")){ %>
		<td><input type="text" size="12" value=""
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%}else{ %>
		<td><input type="text" size="12" value=""
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%} %>
		<td><input type="text" value="" id="amount<%=inc%>" size="13"
			name="<%=AMOUNT%><%=inc%>" validate="Amount,float,no"
			readonly="readonly" /></td>
		<td><input type="text" value="" id="dispercent<%=inc%>"
			name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" size="5"
			validate="Discount Persentage,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt();}"
			maxlength="3" disabled="disabled" /></td>
		<td><input type="text" value="" id="disamount<%=inc%>"
			name="<%=DISCOUNT %><%=inc%>" validate="Discount Amount,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
			maxlength="7" disabled="disabled" size="7" /></td>
		<td style="display: none;"><input type="text" value="" id="prprtnlDis<%=inc%>"
			name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>" style="display: none;" 
			validate="Proporational Discount,string,no" readonly="readonly"
			size="10" /></td>
		<td><input type="text" value="" id="netamount<%=inc%>"
			name="<%=NET_AMOUNT %><%=inc%>" validate="Net Amount,string,no"
			readonly="readonly" size="10" /></td>

		<td>
		<input type="checkbox" id="printReq<%=inc%>" name="printReq<%=inc%>" value="y"
		onclick="getOldAdNo(<%=inc%>);" disabled="disabled" />
		</td>

		<td><input type="button" id="addBtn<%=inc%>" name="add" value="" class="buttonAdd"
			onclick="addRow();" tabindex="1" /></td>
	</tr>
	<%
		}
	%>
</table>
</div>
<!--table ends--> <input type="hidden" value="<%=inc %>"
	name="hiddenValueCharge" id="hiddenValueCharge" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label>Bill Amount</label> <%
if(tempOpBillHeader.getBillAmt() != null){
	totalBillAmt = tempOpBillHeader.getBillAmt();
}
%> <input type="text" id="totalAmtId" name="<%=BILL_AMOUNT %>"
	class="readOnlySmall" value="<%=totalBillAmt %>" readOnly /> <%
	if(patientTypeId == 8 || patientTypeId == 2){
%> <label>Staff Health Scheme</label> <%}else{ %> <label>Total
Discount</label> <%} %> <%
BigDecimal compDisc = new BigDecimal(0);
if(tempOpBillHeader.getDiscount() != null){
	compDisc = tempOpBillHeader.getDiscount();
}
%> <input type="text" id="compDiscountId" name="compDiscount"
	class="readOnlySmall" readonly="readonly" value="<%=compDisc %>" /> <script
	type="text/javascript">

	var authorizerArr = new Array();

</script> <label style="display: none;">Total Charity</label> <%
BigDecimal charity = new BigDecimal(0);
if(tempOpBillHeader.getCharity() != null){
	charity = tempOpBillHeader.getCharity();
}
%> <input type="text" id="charityId" name="charity"
	class="readOnlySmall" readonly="readonly" value="<%=charity %>" style="display: none;" /> <%
	if(tempOpBillHeader.getConsultant() != null){
	%> <script type="text/javascript">
		document.getElementById('cnsltDocId').value = '<%=tempOpBillHeader.getConsultant().getId()%>';
	</script> <%}
%> <label>Round Off</label> <%
	BigDecimal roundOff = new BigDecimal(0);
	if(tempOpBillHeader.getRoundOff() != null){
		roundOff = tempOpBillHeader.getRoundOff();
	}
	%> <input type="text" id="roundId" name="<%=ROUND_OF_VALUE %>"
	value="<%= roundOff%>" class="readOnlySmall" readonly="readonly" /> <label
	class="medium">Net Amount</label> <%
	if(tempOpBillHeader.getNetAmt() != null){
		totalNetAmt = tempOpBillHeader.getNetAmt();
	}
	%>
	<input type="text" id="totalNetId" name="<%=TOTAL_AMOUNT%>"
	value="<%=totalNetAmt %>" class="readOnlySmall" readOnly />
	<input type="hidden" id="totalNetId1" name="<%=TOTAL_AMOUNT%>"
	value="<%=totalNetAmt %>" class="readOnlySmall" readOnly />


<div class="clear"></div>

<label>Discount On Bill</label> <%
BigDecimal chrtyOnBill = new BigDecimal(0);
if(tempOpBillHeader.getDiscountOnBill() != null){
	chrtyOnBill = tempOpBillHeader.getDiscountOnBill();
}
%> <input type="text" id="discountOnBillId"
	name="<%=DISCOUNT_ON_BILL %>" class="small" value="<%=chrtyOnBill %>"
	onblur="calculateDiscPercentForOpService(this.value,'op');divideDiscAmtToCharges(this.value,'op');calculateDiscAmtForBill(this.value,'op');"
	validate="Discount On Bill,float,no" maxlength="5" /> <label
	class="smallAuto">(%)</label>
	<label style="display: none;">Bill Discount Amount</label> <input style="display: none;"
	type="text" id="discountAmtBillId" name="discountAmtBillId" value=""
	class="small" onblur="calculateDiscPercentForOpService(this.value,'op');"
	validate="Bill Discount Amount,float,no" maxlength="5" />
	<%
	if (registered.equals("yes")) {
		if (!adv.equals("") && patientTypeId == 3 ) {
%> <label>Advance Adjustment</label> <input type="checkbox"
	id="advAdjCheckId" class="radioCheck" value=""
	onclick="displayAdvanceText(this);" /> <label id="amtLabel"
	style="display: none;" class="auto">Amount</label> <%
	BigDecimal advAdjAmt = new BigDecimal(0);
	if(tempOpBillHeader.getAdvanceAdjustment() != null){
		advAdjAmt = tempOpBillHeader.getAdvanceAdjustment();
	}
	%> <input type="text" id="advAdjId" name="<%=ADVANCE_ADJUSTMENT %>"
	value="<%=advAdjAmt %>" class="small" style="display: none;"
	maxlength="9" onblur="checkAdvanceAmt(this.value,'<%=adv %>');" /> <%

	}else if(adv.equals("") && patientTypeId != 3){
 %> <label class="medium">Outstanding</label> <%
	BigDecimal osAmt = new BigDecimal(0);
	if(tempOpBillHeader.getOutstanding() != null){
		osAmt = tempOpBillHeader.getOutstanding();
	}
	%> <input type="text" id="outstandingId" name="<%=OUTSTANDING %>"
	class="small" value="<%=osAmt %>"
	onblur="checkOutstandingAmt(this.value);" maxlength="9" /> <%
 	}
	}
 %> <label class="medium"><span id="mandatorySignId"
	style="display: none;">* </span>Authorizer</label> <select
	name="<%=AUTHORIZER_ID %>" id="authorizerId" disabled="disabled"
	class="small">
	<option value="0">Select</option>
	<%
	int counter=0;
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
%> <label>Payable Amt</label> <%
	if(tempOpBillHeader.getNetAmt() != null){
		totalNetAmt = tempOpBillHeader.getNetAmt();
	}
	%> <input type="text" id="payableAmtId" name="<%=PAYABLE_AMOUNT %>"
	value="<%=totalNetAmt %>" class="readOnlySmall" readOnly /> <%
	BigDecimal chrtyAmt = new BigDecimal(0);
	if(tempOpBillHeader.getDiscountAmt() != null){
		chrtyAmt = tempOpBillHeader.getDiscountAmt();
	}
	%> <input type="hidden" id="totalDisId" name="<%=DISCOUNT_AMOUNT %>"
	value="<%=chrtyAmt %>" class="small" readonly="readonly" /> <input
	type="hidden" name="counter" id="counter" value="<%=inc %>" />


<div class="clear"></div>
</div>

<script type="text/javascript">
var bankArray=new Array();
</script>

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Payment Details</h4>
<div class="clear"></div>
<input type="button" name="delete" class="buttonDel"
	onclick="removeRowForPayment();" />
<div class="clear"></div>
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
			id="amt<%=i%>" value="<%=totalNetAmt %>" validate="Amount,string,no"
			maxlength="9"
			onblur="if(validateAmount(this.value,<%=i %>)){calculateOutstandingAmt();};" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i%>"
			id="cqeId<%=i %>" maxlength="20" readonly="readonly"
			onblur="validateCheque(this.value,<%=i%> );" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i%>"
			id="chqDate<%=i %>" readonly="readonly"
			onblur="validateChequeAndCreditCardDate();" /> <img
			id="calId<%=i %>" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" style="display: none;" validate="Pick a date"
			class="calender"
			onclick="setdate('<%=date %>',document.getElementById('chqDate<%=i %>'),event);" />
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
			onclick="addRowForPayment('billServicing');" /></td>

	</tr>
</table>
<input type="hidden" value="<%=registrationType %>"
	name="registrationType" /> <input type="hidden" value="1"
	name="hiddenValuePayment" id="hiddenValuePayment" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block"><label><span>*</span> Actual Collected
Amount</label> <input type="text" id="actualColAmtId" name="actualCollectedAmt"
	onblur="showDifference();" value=""
	validate="Actual Collected Amount,float,no" maxlength="8" tabindex="1" />
<label><span>*</span> Balance Amount is :</label> <input type="text"
	style="border: 0px; font-size: 12; font: bold; padding-left: 5px;"
	id="netBalanceAmount" readonly="readonly"><script
	type="text/javascript">
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
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" tabindex="1" class="button" name="Submit11"
	value="Submit"
	onclick="if(checkFilledRow()){if(validateFieldsOnSubmit()){if(checkCollectedAmt()){submitForm('billServicing','ot?method=submitBillServicingDetails','validatePaymentAmt','validateChequeAndCreditCardDate');}}}"
	align="right" /> <%
 if(registered.equals("yes") && tempBillList.size() == 0){
%> <input type="button" tabindex="1" class="buttonBig" name="Submit12"
	value="Temporary Bill"
	onclick="if(checkFilledRow()){if(validateFieldsOnSubmit()){submitForm('billServicing','opBilling?method=submitTemporaryBillServicingDetails','validatePaymentAmt','validateChequeAndCreditCardDate');}}"
	align="right" /> <%} %> <input type="button" class="button" value="Back"
	onclick="submitFormCancel('billServicing','opBilling?method=showBillServicingJsp')" />
<input type="button" class="buttonHighlight" value="Reset"
	onclick="form.reset();resetAjaxValueForBilling();" />
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

function validateRateValue(val,count,rate){
	if(val != ""){
		if(!validateFloat(val)){
			alert("Rate should be integer or decimal value");

			if(document.getElementById('resrate'+count)){
				document.getElementById('resrate'+count).value=rate.toFixed(2);
			}
			else if(document.getElementById('rate'+count)){
				document.getElementById('rate'+count).value = rate.toFixed(2);
			}
			return false;
		}
	}else{
			alert("Rate can not be blank");
			if(document.getElementById('resrate'+count)){
				document.getElementById('resrate'+count).value=rate.toFixed(2);
			}
			else if(document.getElementById('rate'+count)){
				document.getElementById('rate'+count).value = rate.toFixed(2);
			}
			return false;
	}
	return true;
}

function getOldAdNo(inc)
{
	var chargeCode = document.getElementById('chargeCode'+inc).value;
	var totalNetamt = document.getElementById('totalNetId').value;
	
	if(document.getElementById('printReq'+inc).checked == true)
	{
		
		if(document.getElementById('dispercent'+inc).value != 0 && 
		   document.getElementById('disamount'+inc).value != 0)
		 {
		 	var amt = document.getElementById('amount'+inc).value;
			
			if(document.getElementById('dispercent'+inc) != null)
				document.getElementById('dispercent'+inc).value="0";
				
			if(document.getElementById('disamount'+inc) != null)
	   			document.getElementById('disamount'+inc).value="0";
	   		
	   		document.getElementById('netamount'+inc).value = amt;
			document.getElementById('compDiscountId').value = "0.00";
			document.getElementById('authorizerId').disabled = true;
		
			var abc = parseFloat(amt)+parseFloat(totalNetamt);
			
			document.getElementById('totalNetId').value = abc;
			document.getElementById('totalNetId1').value = abc;
		
			if(document.getElementById('outstandingId') != null)
				document.getElementById('outstandingId').value = abc;
				
			if(document.getElementById('payableAmtId') != null)
				document.getElementById('payableAmtId').value = abc;
		
			document.getElementById('amt1').value = abc;
				
			if(document.getElementById('actualColAmtId') != null)
				document.getElementById('actualColAmtId').value = abc;
		
			document.getElementById('totalDisId').value = "0";
		}
	}
	else
	{
		if(validateChargeCodeForBillingAutoComplete(chargeCode, inc ,'op'))
		{
			submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge'+inc+'='+encodeURIComponent(chargeCode)+'&rowVal='+inc+'&hin=<%=hin%>&type=op','rateVal'+inc);
		}
	}
}

function addRow(){
	var tbl = document.getElementById('chargeDetails');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;


	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.name='selectedChrage';
	e0.className='radioCheck';
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.onblur=function(){
				if(validateChargeCodeForBillingAutoComplete(this.value, (iteration),'op')){submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge'+iteration+'='+encodeURIComponent(this.value)+'&rowVal='+(iteration)+'&hin=<%=hin%>&type=op','rateVal'+(iteration));}

			  };
	e1.name = 'chargeCode'+ (iteration);
	e1.id = 'chargeCode' + (iteration);
	e1.tabIndex="1";
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
   	cell1.appendChild(e1);
	e1.focus();
    cell1.appendChild(newdiv);

	new Ajax.Autocompleter('chargeCode'+ (iteration),'ac2update'+iteration,'opBilling?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode'+ (iteration), callback: eventCallback});


	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=QUANTITY%>'+ (iteration);
	e2.id = 'qty'+(iteration)
	//e2.tabIndex="1";
	e2.maxLength ='3';
	e2.readOnly = true;
	e2.onblur= function(){
					if(validateQtyForBilling(this.value,this.id,iteration)){calculateNetAmount(iteration);calcProportionalDisc(iteration);calculateTotalAmt();};
					};
	cell2.appendChild(e2);
	e2.size='5';


	var cell3 = row.insertCell(3);
	cell3.id='rateVal'+(iteration);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=RATE%>'+ (iteration);
	e3.readOnly = true;
	e3.id='rate'+(iteration);
	e3.size='12';
	cell3.appendChild(e3);

	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=STANDARD_DEDUCTION%>'+ (iteration);
	e4.readOnly = true;
	e4.id='standardDeductionId'+(iteration);
	e4.size='12';
	cell4.appendChild(e4);

	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=AMOUNT%>'+ (iteration);
	e5.readOnly = true;
	e5.size='13';
	e5.id='amount'+(iteration);
	cell5.appendChild(e5);

	var cell6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.type = 'text';
	e6.name='<%=DISCOUNT_PERCENTAGE%>'+ (iteration);
	e6.id='dispercent'+(iteration);
	e6.onChange = function(){
					if(checkDiscountAmt(iteration)){calculateDiscountAmt((iteration));calculateNetAmount(iteration);calculateTotalAmt();};
				};
	e6.size = '5';
	e6.disabled = true;
	e6.maxLength = '3';
	cell6.appendChild(e6);

	var cell7 = row.insertCell(7);
	var e7 = document.createElement('input');
	e7.type = 'text';
	e7.name='<%=DISCOUNT%>'+ (iteration);
	e7.id='disamount'+(iteration);
	e7.onblur = function(){
					if(checkDiscountAmt(iteration)){validateDiscAmt(this.value,iteration);disableDiscountPercent(iteration);calculateNetAmount(iteration);calculateTotalAmt();};
				};
	e7.maxLength = '7';
	e7.size = '7';
	e7.disabled = true;
	cell7.appendChild(e7);

	var cell8 = row.insertCell(8);
	var e8= document.createElement('input');
	e8.type = 'text';
	e8.name='<%=NET_AMOUNT%>'+ (iteration);
	e8.id='netamount'+(iteration);
	e8.readOnly = true;
	e8.size = '10';
	cell8.appendChild(e8);

	var cell9 = row.insertCell(9);
	var e9 = document.createElement('input');
	e9.type = 'checkbox';
	e9.name='printReq'+ (iteration);
	e9.id='printReq'+(iteration);
	e9.disabled = true;
	e9.onclick = function(){
			getOldAdNo(iteration);
	}
	cell9.appendChild(e9);

	var cell10 = row.insertCell(10);
	var e10 = document.createElement('input');
	e10.type = 'button';
	e10.name='add';
	e10.id='addBtn'+(iteration);
	e10.className = 'buttonAdd';
	e10.tabIndex="1";
	e10.onclick = function(){
					addRow();
	}
	cell10.appendChild(e10);
	
}

function removeRow()
{
	var tbl = document.getElementById('chargeDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }

	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
		if (document.getElementsByName('selectedChrage')[counter].checked == true)
		{
		  	tbl.deleteRow(counter+1);
		 	calculateTotalAmt();
		 	if(document.getElementById('advAdjId'))
		 		document.getElementById('advAdjId').value = "";
		}
	}
}



function displayName(){
	var w = document.getElementById('cnsltDocId').selectedIndex;
	var selectedText = document.getElementById('cnsltDocId').options[w].text;
	document.getElementById('cnsltDocTextId').value = selectedText;
}



</script></form>
