<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.PatientBalance"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="java.util.*"%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%> 
<%@page import="jkt.hms.masters.business.MasCharityType"%>

<%--For AutoComplete Through Ajax--%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasChargeCodeRates"%>
<%@page import="jkt.hms.masters.business.Visit"%>


<%@page import="jkt.hms.masters.business.MasDiscount"%>
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
<form name="billServicing" method="post" action=""	onload="form.reset();">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> employeeList = new ArrayList<Object[]>();
	List<Patient> patientList = new ArrayList<Patient>();
	
	List<Object[]> mainChargeCodeList = new ArrayList<Object[]>();
	List<Object[]> subChargeCodeList = new ArrayList<Object[]>();
	List<Object[]> authorizerList = new ArrayList<Object[]>();
	List<Object[]> bankList = new ArrayList<Object[]>();
	
	
	List<MasDiscount> discountList = new ArrayList<MasDiscount>();
	List<Object[]> masCharityList = new ArrayList<Object[]>();
	List<PatientBalance> patientBalances = new ArrayList<PatientBalance>();
	// BlOpBillHeader patientOpBillHeader = new BlOpBillHeader(); // Added by Amit Das on 02-03-2016
	// commented by amit das on 22-08-2016
	MasScheme patientScheme = new MasScheme(); // added by amit das on 22-08-2016
	
	
	
	
	String pastDue = "";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	if (map.get("discountList") != null) {
		discountList = (List<MasDiscount>) map.get("discountList");
	}
	if (map.get("masCharityList") != null) {
		masCharityList = (List<Object[]>) map.get("masCharityList");
	}
	
	if (map.get("employeeList") != null) {
		employeeList = (List<Object[]>) map.get("employeeList");
	}
	if (map.get("patientList") != null) {
		patientList = (List<Patient>) map.get("patientList");
	}
	
	if (map.get("mainChargeCodeList") != null) {
		mainChargeCodeList = (List<Object[]>) map.get("mainChargeCodeList");
	}
	if (map.get("subChargeCodeList") != null) {
		subChargeCodeList = (List<Object[]>) map.get("subChargeCodeList");
	}
	if (map.get("authorizerList") != null) {
		authorizerList = (List<Object[]>) map.get("authorizerList");
	}
	if (map.get("bankList") != null) {
		bankList = (List<Object[]>) map.get("bankList");
	}
	
	if (map.get("patientBalances") != null) {
		patientBalances = (List<PatientBalance>) map.get("patientBalances");
	}
	List<ProcedureHeader> procHdList = new ArrayList<ProcedureHeader>();
	List<ProcedureDetails> procDtList = new ArrayList<ProcedureDetails>();
	if (map.get("procHdList") != null) {
		procHdList = (List<ProcedureHeader>) map.get("procHdList");
	}
	if (map.get("procDtList") != null) {
		procDtList = (List<ProcedureDetails>) map.get("procDtList");
	}
	List<OpdSurgeryHeader> surgeryHdList = new ArrayList<OpdSurgeryHeader>();
	List<OpdSurgeryDetail> surgeryDtList = new ArrayList<OpdSurgeryDetail>();
	if (map.get("surgeryHdList") != null) {
		surgeryHdList = (List<OpdSurgeryHeader>) map.get("surgeryHdList");
	}
	if (map.get("surgeryDtList") != null) {
		surgeryDtList = (List<OpdSurgeryDetail>) map.get("surgeryDtList");
	}
	
	String maxBlNo = "";
	if (map.get("maxBlNo") != null) {
		maxBlNo = (String) map.get("maxBlNo");
	}
	String orderNo = "";
	if (map.get("orderNo") != null) {
		orderNo = (String) map.get("orderNo");
	}
	
	// added by Amit Das on 02-03-2016 
	// edited by amit das on 22-08-2016
	if(map.get("patientOpBillHeader") != null){
		patientScheme= (MasScheme)map.get("patientOpBillHeader");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String nabhHospital = "";
	if (session.getAttribute("nabhHospital") != null) {
		nabhHospital = (String) session.getAttribute("nabhHospital");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	float refundAmt = 0;
	int hospitalId =0;
	if(session.getAttribute("hospitalId")!=null){
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	
%>

<div class="titleBg">
<h2>Bill Servicing </h2>
</div>
<div class="Block">
<h4>Patient Details</h4>
<div class="clear"></div>

<input type="hidden" id="discTypeDB" name="discTypeDB">
<input type="hidden" value=<%=nabhHospital %> name="nabhHospital" id="nabhHospital"/>
<%	int patientTypeId=0;
	String adv = "";
	int hin = 0;
	int hinId =0 ;
	String registrationType = "";
		if (patientList.size() > 0) {
			Patient patient = patientList.get(0);

			hin = patient.getId();
			hinId = patient.getId();
			if(patient.getRegistrationType()!= null){
				registrationType = patient.getRegistrationType();
			}
			if (patient.getPastDue() != null){
				pastDue = patient.getPastDue();
			}else{
				pastDue="0";
			}
%>  <label>UHID</label> 
<input	type="text" name="patientUhid" readonly="readonly" value="<%=patient.getHinNo()%>" /> 

<!-- Added By Amit Das -->
<input type="hidden" value="<%=patient.getId()%>" id="inpatientIdForCard" name="inpatientIdForCard"/>

<input type="hidden" value="0" name="refDept" id="refDept"/>
<label>Bill Date</label> 
<input	type="text" readonly="readonly" value="<%= date%>" />
<label>Patient Name</label> 
<%if (patient.getPFirstName() != null) {
 %> 
<input	type="text" readonly="readonly" value="<%=patient.getPFirstName()%>" /> 
<%}%>
<label>Age</label> 
<input	type="text" readonly="readonly" value="<%=patient.getAge()!=null ? patient.getAge():"" %>" /> 
<label>Gender</label>
<input	type="text" readonly="readonly" value="<%=patient.getSex()!=null ? patient.getSex().getAdministrativeSexName():""%>" /> 
<label>Mobile No.</label> 
<input	type="text" readonly="readonly" value="<%=patient.getMobileNumber()!=null ? patient.getMobileNumber():""%>" />

  <label>Family Income Category</label> 
  <%if(patient.getBplStatus()!=null && patient.getBplStatus().equalsIgnoreCase("y")){ %>
   <input type="text"  readonly="readonly" value="BPL" />
  
  <%}else if(patient.getBplStatus()!=null && patient.getBplStatus().equalsIgnoreCase("n")){ %>
   <input type="text"  readonly="readonly" value="APL" />
  
  <%}else { %>
   <input type="text"  readonly="readonly" value="-" />
  <%} %>
   <label>Social Category</label> 
 <input type="text"  readonly="readonly" value="<%=patient.getPatientType()!=null?patient.getPatientType().getPatientTypeName():""%>" />
   <label>Other Category</label> 
 <input type="text"  readonly="readonly" value="-" />
 <%
 String emp="";

 %>
<%	
			String doctorName = "";
			int visitNo	 = 0;
			int visitId = 0;
			int tokenNo = 0;
			if (procHdList.size() > 0) {
				if(procHdList.get(0).getOpdPatientDetails().getEmployee()!=null)
				{
				doctorName = procHdList.get(0).getOpdPatientDetails().getEmployee().getFirstName();
				if (procHdList.get(0).getOpdPatientDetails().getEmployee().getMiddleName() != null) {
					doctorName = doctorName.concat(" ").concat(procHdList.get(0).getOpdPatientDetails().getEmployee().getMiddleName());
				}
				if (procHdList.get(0).getOpdPatientDetails().getEmployee().getLastName() != null){
					doctorName = doctorName.concat(" ").concat(procHdList.get(0).getOpdPatientDetails().getEmployee().getLastName());
				}
				}
				if(procHdList.get(0).getVisit() != null){
					Visit v = procHdList.get(0).getVisit();
				
				visitId = procHdList.get(0).getVisit().getId();
				
				}
%>
<input	type="hidden" readonly="readonly" value="<%=visitNo%>"/>

 <label>Consultant Name</label><input	type="text" readonly="readonly" value="<%=doctorName%>"/>
<input type="hidden" value="<%=procHdList.get(0).getOpdPatientDetails().getEmployee()!=null?procHdList.get(0).getOpdPatientDetails().getEmployee().getId():""%>" name="<%=EMPLOYEE_ID %>" id="cnsltDocId"/> 
<input type="hidden" name="<%=VISIT_ID %>" value="<%= visitId%>" />
<input type="hidden" name="<%=TOKEN_NO %>" value="<%= tokenNo%>" />

<% }
	else if (surgeryHdList.size() > 0) {
		if(surgeryHdList.get(0).getEmployee()!=null)
			{
				doctorName = surgeryHdList.get(0).getEmployee().getFirstName();
			if (surgeryHdList.get(0).getEmployee().getMiddleName() != null) {
				doctorName = doctorName.concat(" ").concat(surgeryHdList.get(0).getEmployee().getMiddleName());
			}
			if (surgeryHdList.get(0).getEmployee().getLastName() != null){
				doctorName = doctorName.concat(" ").concat(surgeryHdList.get(0).getEmployee().getLastName());
			}
		}
		if(surgeryHdList.get(0).getVisit() != null){
			Visit v = surgeryHdList.get(0).getVisit();
			visitId = v.getId();
		
		}
%>
<input	type="hidden" readonly="readonly" value="<%=visitNo%>"/>

<label>Consultant Name</label><input	type="text" readonly="readonly" value="<%=doctorName%>"/>
<input type="hidden" value="<%=surgeryHdList.get(0).getEmployee()!=null?surgeryHdList.get(0).getEmployee().getId():""%>" name="<%=EMPLOYEE_ID %>" id="cnsltDocId"/> 
<input type="hidden" name="<%=VISIT_ID %>" value="<%= visitId%>" />
<input type="hidden" name="<%=TOKEN_NO %>" value="<%= tokenNo%>" />
<% } else { %>

<!-- <label><span>*</span> Consultant Name</label> -->
<select	 style='display:none' name="<%=EMPLOYEE_ID %>" id="cnsltDocId" onchange="displayName();showUrgentDetails();"
					validate="Consultant Name,string,no" tabindex=1>
	<option value="0">Select</option>
	<option value="00">Ref. Doctor</option>
	<%
		for (Object[] employee : employeeList) {
			if (employee[0] != null) {
				if (((MasEmpCategory)employee[0]).getEmpCategoryCode().equals(empCategoryCodeForDoctor)) {

					String doctorMiddleName = "";
					String doctorLastName = "";
					if (employee[2] != null)
						doctorMiddleName = (String)employee[2];
					if (employee[2] != null)
						doctorLastName = (String)employee[3];	%>
	<option value="<%=employee[4]%>"><%=(String)employee[1]+" " + doctorMiddleName + " "+ doctorLastName%></option>
	<%	}
						}
					}	%>
</select> <%  	} %>



<!-- end of scheme authorizer by Amit Das on 15-02-2016 -->

<div id="urgentDetails" style="display: none;" >
<!-- <label> Ref. Doctor</label> -->
<input type="hidden" name="refDoctor1"  id="refDoctor"  />
<input type="hidden" name="consultName"  id="consultId"  />
</div>
 <%
 	String sign = "";
 			if (!pastDue.equals("")) {
 				sign = pastDue.substring(0, 1);
 				if (sign.equals("-")) {
 					adv = pastDue.substring(1);
 				}
 			}
 			if (!adv.equals("")) {
 %> 
<label>Total Advance</label>
<input type="text"  readonly="readonly" value="<%=adv%>" /> 
  <%
 	}
 %>
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" />
<input type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>" />
<input type="hidden" name="<%=PATIENT_NAME%>"
	value="<%=patient.getPFirstName() %>" />
<input type="hidden" name="<%=AGE%>" value="<%=patient.getAge()!=null ? patient.getAge():""%>" />
<input type="hidden" name="<%=SEX_ID%>"	value="<%=patient.getSex().getId() %>" />
<%if(patient.getNextOfKinName() != null){ %>
	<input	type="hidden" name="<%=RELATIVE_NAME%>"	value="<%=patient.getNextOfKinName() %>" />
<%} %>

 <label>Patient Type</label> 
 <input type="text"  readonly="readonly" value="<%=patient.getPatientType()!=null?patient.getPatientType().getPatientTypeName():"" %>" />
<label>Outstanding</label> 
 <input type="text"  readonly="readonly" value="<%=patient.getPastDue()!=null?patient.getPastDue():"0.0" %>" />
<div class="clear"></div> 
 <label>Scheme</label>
 <!-- Added  By Amit Das on 02-03-2016 -->
 <input type="hidden" value="<%=(patientScheme!=null) ? patientScheme.getId():""%>" name="schemeId_op" id="schemeId_op">
 <input type="hidden" value="<%=(patientScheme!=null) ? patientScheme.getSchemeName():""%>" name="schemeName_op"  id="schemeName_op">

 <div id="schemeDiv">
 <select name="schemeList" id="schemeList" onchange="onChangeScheme();">
 <option value="0">Select</option>
</select>
</div>
 
<input	type="hidden" name="<%=MOBILE_NO%>" id=<%=MOBILE_NO%> value="<%=patient.getMobileNumber() %>" />
<input	type="hidden" name="<%=REGISTRATION_TYPE%>"	value="<%=patient.getRegistrationType()!=null?patient.getRegistrationType():"" %>" />

	<%	}	 
 %> 

<input type="hidden" id="cnsltDocTextId" name="<%=CONSULTING_DOCTOR%>" value="" /> 
 <script type="text/javascript">
	(document.getElementById("cnsltDocId").focus());
	</script>
<div class="clear"></div>
<h4>Charge Details</h4>
<div class="clear"></div>

<label>Main Service Head</label> 
<select	id="mainChargeCodeId" name="<%=MAIN_CHARGECODE_ID %>"
	onchange="populateSubChargeCodeForBilling(this.value,'billServicing');getChangeCheckBox();">
	<option value="0">Select</option>
	<%	for (Object[] mainChargecode : mainChargeCodeList) {	%>
	<option value="<%=mainChargecode[1] %>"><%=mainChargecode[0]%></option>
	<%}%>
</select>
 <script type="text/javascript">
		<%
			int counter1 = 0;
			for (Object[] mainChargecode : mainChargeCodeList)
			{
				for (Object[] subChargecode : subChargeCodeList)
				{
					if(subChargecode[0] != null){
						if(mainChargecode[1].equals(((MasMainChargecode)subChargecode[0]).getId() )){
			%>
							subChargeCodeArray[<%=counter1%>] = new Array();
							subChargeCodeArray[<%=counter1%>][0]=<%=mainChargecode[1]%>;
							subChargeCodeArray[<%=counter1%>][1] = <%=subChargecode[2]%>;
									<%
					StringBuffer output_str = new StringBuffer();
					StringTokenizer s = new StringTokenizer(subChargecode[1].toString(),"\"");

					while (s.hasMoreTokens())
					{
					output_str.append(s.nextToken());
					if (s.hasMoreTokens())
					{
					output_str.append("\\");
					output_str.append("\"");
					}
					}	%>
					subChargeCodeArray[<%=counter1%>][2] = "<%=output_str%>";
					<%	counter1++;
					}
				}
			}
		}		%></script>
<label>Sub Service Head </label> <select id="subChargeCodeId"	name="<%=SUB_CHARGECODE_ID %>">
	<option value="0">Select</option>
	<%	for (Object[] subChargecode : subChargeCodeList) {	%>
	<option value="<%=subChargecode[2] %>"><%=subChargecode[1]%></option>
	<%	}	%>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="cmntable" style="width:1105px; float:left;">
<div id="testDiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Service Description</th>
		<th scope="col">Qty</th>
		<th scope="col">Rate</th>
		<th scope="col">Amount</th>
		<th scope="col">Discount(%)</th>
		<th scope="col">Discount Amt</th>
		<th scope="col">Net Amount</th>
		<th scope="col">&nbsp;</th>
	</tr>

<%
	int inc = 0;
	BigDecimal billAmt = new BigDecimal(0.00);
    Date currentDate = new Date();
		BigDecimal totalBillAmt = new BigDecimal("0");
		BigDecimal totalNetAmt = new BigDecimal("0");
		BigDecimal charge = new BigDecimal("0");
		System.out.println("procDtList.size()---"+procDtList.size());
		if (procDtList.size() > 0) {
		int procHdId = 0;
			for (int i = 0; i < procDtList.size(); i++) {
				inc++;
				ProcedureDetails procedureDt = new ProcedureDetails();
				procedureDt = procDtList.get(i);
				if (procedureDt.getBillStatus().equals("p")) {
					if(procedureDt.getProcedure().getChargeCode()!=null){
					procHdId = procedureDt.getProcedureHeader().getId();
					 Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
						if(procedureDt.getProcedure().getChargeCode()!=null && procedureDt.getProcedure().getChargeCode().getMasChargeCodeRates() != null){
							chargeSet = procedureDt.getProcedure().getChargeCode().getMasChargeCodeRates();
							
						
							if(chargeSet.size() > 0){
								for(MasChargeCodeRates chargeRate : chargeSet){
									if(chargeRate.getHospital()!=null && chargeRate.getHospital().getId() == hospitalId){
									if(currentDate.compareTo(chargeRate.getEffectiveFromDate()) >= 0){
										charge = chargeRate.getRate();
										System.out.println("1111--"+charge);
										break;
									}else{
										charge = new BigDecimal(procedureDt.getProcedure().getChargeCode().getCharge());
										System.out.println("2222--"+charge);
									}
									}
								}
							}else{
								System.out.println("3333--"+charge);
								charge = new BigDecimal(procedureDt.getProcedure().getChargeCode().getCharge());
							}
						}else{		
							System.out.println("4444--"+charge);
							charge = new BigDecimal(procedureDt.getProcedure().getChargeCode().getCharge());							
						}
						
						System.out.println("charge--"+charge);
	%>
	<tr>

		<td><input type="hidden" name="procHdId" value="<%=procHdId %>" />
		<input type="hidden" name="procDtId<%=inc %>" value="<%=procedureDt.getId() %>" />
		<input type="radio"	value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>

		<td><input type="text" name="chargeCode<%=inc%>"	id="chargeCode<%=inc%>"
			value="<%=procedureDt.getProcedure().getChargeCode().getChargeCodeName() %>[<%=procedureDt.getProcedure().getChargeCode().getChargeCodeCode() %>]"
			onblur="if(validateChargeCodeForBillingAutoComplete(this.value, '<%=inc %>','op')){submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge<%=inc %>='+encodeURIComponent(this.value)+'&rowVal=<%=inc%>&hin=<%=hin%>&type=op&schemeList='+document.getElementById('schemeList').value,'rateVal<%=inc %>');}"
			readonly="readonly" tabindex="1" />

		<div id="ac2update<%=inc%>" style="display: none;" class="autocomplete"></div>

		 <script type="text/javascript" language="javascript" charset="utf-8">
		 function eventCallback(element, entry){
			 var comanyId='';
			
			 	return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value+"&companyId="+comanyId;
			}
		</script>  -
		
		<input type="hidden" id="chargeId<%=inc %>"
			name="<%=CHARGE_CODE_ID%><%=inc %>"
			value="<%=procedureDt.getProcedure().getChargeCode().getId()%>" /></td>
			<%
				int qty = 1;
			
			//	qty = procedureDt.getFrequency().getFrequencyCount()*procedureDt.getNoOfDays();
				
			%>
		<td><input type="text" size="5" id="qty<%=inc%>"name="<%=QUANTITY %><%=inc%>"
			 value="<%=qty %>" validate="Qty,int,no" maxlength="5" readonly="readonly"
			onblur="if(validateQtyForBilling(this.value,this.id,<%=inc %>)){calculateNetAmount(<%=inc %>);calculateTotalAmt();};"/></td>
			  
		<td  id="rateVal<%=inc %>">
		<input type="text" size="12" value="<%=charge %>" id="rate<%=inc%>" name="<%=RATE%><%=inc%>"
		 validate="Rate,float,no" readonly="readonly" onblur="calculateNetAmount(<%=inc %>);calculateTotalAmt();" /></td>

		
		<td><input type="text" size="13" value="<%=billAmt %>"	id="amount<%=inc%>" name="<%=AMOUNT%><%=inc%>"
			validate="Amount,float,no" readonly="readonly" /></td>

		<%
			if(procedureDt.getProcedure().getChargeCode().getDiscountable().equals("y")){
				BigDecimal discPer = new BigDecimal(0);
				if(procedureDt.getProcedure().getChargeCode().getDiscountPercentage() != null){
					discPer = procedureDt.getProcedure().getChargeCode().getDiscountPercentage();
				}
		%>
		<td><input type="text" value="<%=discPer %>" id="dispercent<%=inc%>" name="<%=DISCOUNT_PERCENTAGE %><%=inc%>"
		size="10" validate="Discount Persentage,string,no" maxlength="3" size="10"
		onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"/>
		 </td>
		<td><input type="text" value="" id="disamount<%=inc%>" name="<%=DISCOUNT %><%=inc%>"
		validate="Discount Amount,string,no" maxlength="7" size="10"
		onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"/></td>
		 
		<%}else{ %>
		<td><input type="text" value="" id="dispercent<%=inc%>"	name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" 
		size="10"	validate="Discount Persentage,string,no"
		onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
			maxlength="3" disabled="disabled" size="10" /></td>
		<td><input type="text" value="" id="disamount<%=inc%>" name="<%=DISCOUNT %><%=inc%>"
		onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
		validate="Discount Amount,string,no" maxlength="7" disabled="disabled" size="10" /></td>
		<%} %>

		 <input type="hidden" value="" id="prprtnlDis<%=inc%>"name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
			validate="Proporational Discount,string,no" readonly="readonly"	size="10" /> 
			
		<td><input type="text" value="<%=billAmt%>"	id="netamount<%=inc%>" name="<%=NET_AMOUNT %><%=inc%>"
			validate="Net Amount,float,no" readonly="readonly" size="10" /></td>
		<td style="display:none;">
		<%if(procedureDt.getProcedure().getChargeCode().getMainChargecode().getId() ==27 ){ %>
		<input type="checkbox" value="" id="lalPathId<%=inc%>"	name="lalPath<%=inc%>"
			readonly="readonly" size="10" onclick="orderassignYesNoLalPath(<%=inc%>);" />
			<%}else{ %>
			<input type="checkbox" value="" id="lalPathId<%=inc%>"	name="lalPath<%=inc%>"
			readonly="readonly" size="10" onclick="orderassignYesNoLalPath(<%=inc%>);" disabled="disabled"/>
			<%} %>
			<input type="hidden" value="n" id="lalPathText<%=inc%>"	name="lalPathText<%=inc%>"
			readonly="readonly" size="10"  />
		 <input type="hidden" value="" name="companyId2<%=inc%>" id="companyId2<%=inc%>" />
		  <input type="hidden" value="" name="billTypeId<%=inc%>" id="billTypeId<%=inc%>" />
			
			<input type="hidden" value="" name="patientCategory<%=inc%>" id="patientCategory<%=inc%>" />
		</td>
		<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
		<input id="discntPercentId<%=inc %>" type="hidden"	name="discntPercent<%=inc %>"
			value="<%=procedureDt.getProcedure().getChargeCode().getDiscountPercentage()%>" />
		<input type="hidden" name="<%=MAIN_CHARGECODE_ID%><%=inc %>"
			value="<%=procedureDt.getProcedure().getChargeCode().getMainChargecode().getId()%>"  id="ordermainChargeCodeId<%=inc %>"/>
		<input type="hidden" name="<%=SUB_CHARGECODE_ID%><%=inc %>"
			value="<%=procedureDt.getProcedure().getChargeCode().getSubChargecode().getId()%>"  id="ordersubChargeCodeId<%=inc %>"/>
		<%if(procedureDt.getProcedure().getChargeCode().getAccount()!=null){ %>
		<input type="hidden" name="<%=FA_ACCOUNT_ID%><%=inc %>"
			value="<%=procedureDt.getProcedure().getChargeCode().getAccount().getId()%>" />
		<%} %>
		
		<%
int subLdId =0 ;
if (procedureDt.getProcedure().getChargeCode().getSubAccount() != null) {
	subLdId = procedureDt.getProcedure().getChargeCode().getSubAccount().getId();
}
%>
		<input type="hidden" name="<%=FA_SUB_LED_ID%><%=inc %>"
			value="<%=subLdId%>" />

		<%
		if(procedureDt.getProcedure().getChargeCode().getMainChargecode()!=null && procedureDt.getProcedure().getChargeCode().getMainChargecode().getDepartment()!= null && procedureDt.getProcedure().getChargeCode().getMainChargecode().getDepartment().getDepartmentType() !=null ){
	%>
		<input type="hidden" name="<%=DEPARTMENT_TYPE_CODE%><%=inc %>"
			value="<%=procedureDt.getProcedure().getChargeCode().getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode()%>" />
		<input type="hidden" name="<%=DEPARTMENT_ID%><%=inc %>"
			value="<%=procedureDt.getProcedure().getChargeCode().getMainChargecode().getDepartment().getId()%>" />

		<%}
	%>
		<%
			if(procedureDt.getProcedure().getChargeCode().getDiscountable().equalsIgnoreCase("y") ){
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
			if(procedureDt.getProcedure().getChargeCode().getEditable().equals("y") ){
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
					BigDecimal chargeAmt = new BigDecimal(qty).multiply(charge);
					//BigDecimal netAmt = new BigDecimal(qty).multiply(charge);
					totalBillAmt = totalBillAmt.add(chargeAmt);
					totalNetAmt = totalNetAmt.add(billAmt);
				}
			}
			}

	}
		else if (surgeryDtList.size() > 0) {
			int surgeryHdId = 0;
		for (int i = 0; i < surgeryDtList.size(); i++) {
			inc++;
			OpdSurgeryDetail surgeryDt = new OpdSurgeryDetail();
			surgeryDt = surgeryDtList.get(i);
				if(surgeryDt.getChargeCode()!=null){
					surgeryHdId = surgeryDt.getOpdSurgery().getId();
				 Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
					if(surgeryDt.getChargeCode()!=null && surgeryDt.getChargeCode().getMasChargeCodeRates() != null){
						chargeSet = surgeryDt.getChargeCode().getMasChargeCodeRates();
						
					
						if(chargeSet.size() > 0){
							for(MasChargeCodeRates chargeRate : chargeSet){
								if(chargeRate.getHospital()!=null && chargeRate.getHospital().getId() == hospitalId){
								if(currentDate.compareTo(chargeRate.getEffectiveFromDate()) >= 0){
									charge = chargeRate.getRate();
									System.out.println("1111--"+charge);
									break;
								}else{
									charge = new BigDecimal(surgeryDt.getChargeCode().getCharge());
									System.out.println("2222--"+charge);
								}
								}
							}
						}else{
							System.out.println("3333--"+charge);
							charge = new BigDecimal(surgeryDt.getChargeCode().getCharge());
						}
					}else{		
						System.out.println("4444--"+charge);
						charge = new BigDecimal(surgeryDt.getChargeCode().getCharge());							
					}
					
					System.out.println("charge--"+charge);
%>
<tr>

	<td><input type="hidden" name="surgeryHdId" value="<%=surgeryHdId %>" />
	<input type="hidden" name="surgeryDtId<%=inc %>" value="<%=surgeryDt.getId() %>" />
	<input type="radio"	value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>

	<td><input type="text" name="chargeCode<%=inc%>"	id="chargeCode<%=inc%>"
		value="<%=surgeryDt.getChargeCode().getChargeCodeName() %>[<%=surgeryDt.getChargeCode().getChargeCodeCode() %>]"
		onblur="if(validateChargeCodeForBillingAutoComplete(this.value, '<%=inc %>','op')){submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge<%=inc %>='+encodeURIComponent(this.value)+'&rowVal=<%=inc%>&hin=<%=hin%>&type=op&schemeList='+document.getElementById('schemeList').value,'rateVal<%=inc %>');}"
		readonly="readonly" tabindex="1" />

	<div id="ac2update<%=inc%>" style="display: none;" class="autocomplete"></div>

	 <script type="text/javascript" language="javascript" charset="utf-8">
	 function eventCallback(element, entry){
		 var comanyId='';
		
		 	return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value+"&companyId="+comanyId;
		}
	</script>  -
	
	<input type="hidden" id="chargeId<%=inc %>"
		name="<%=CHARGE_CODE_ID%><%=inc %>"
		value="<%=surgeryDt.getChargeCode().getId()%>" /></td>
		<%
			int qty = 1;
		
		%>
	<td><input type="text" size="5" id="qty<%=inc%>"name="<%=QUANTITY %><%=inc%>"
		 value="<%=qty %>" validate="Qty,int,no" maxlength="5" readonly="readonly"
		onblur="if(validateQtyForBilling(this.value,this.id,<%=inc %>)){calculateNetAmount(<%=inc %>);calculateTotalAmt();};"/></td>
		  
	<td  id="rateVal<%=inc %>">
	<input type="text" size="12" value="<%=charge %>" id="rate<%=inc%>" name="<%=RATE%><%=inc%>"
	 validate="Rate,float,no" readonly="readonly" onblur="calculateNetAmount(<%=inc %>);calculateTotalAmt();" /></td>

	
	<td><input type="text" size="13" value="<%=billAmt %>"	id="amount<%=inc%>" name="<%=AMOUNT%><%=inc%>"
		validate="Amount,float,no" readonly="readonly" /></td>

	<%
		if(surgeryDt.getChargeCode().getDiscountable().equals("y")){
			BigDecimal discPer = new BigDecimal(0);
			if(surgeryDt.getChargeCode().getDiscountPercentage() != null){
				discPer = surgeryDt.getChargeCode().getDiscountPercentage();
			}
	%>
	<td><input type="text" value="<%=discPer %>" id="dispercent<%=inc%>" name="<%=DISCOUNT_PERCENTAGE %><%=inc%>"
	size="10" validate="Discount Persentage,string,no" maxlength="3" size="10"
	onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"/>
	 </td>
	<td><input type="text" value="" id="disamount<%=inc%>" name="<%=DISCOUNT %><%=inc%>"
	validate="Discount Amount,string,no" maxlength="7" size="10"
	onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"/></td>
	 
	<%}else{ %>
	<td><input type="text" value="" id="dispercent<%=inc%>"	name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" 
	size="10"	validate="Discount Persentage,string,no"
	onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
		maxlength="3" disabled="disabled" size="10" /></td>
	<td><input type="text" value="" id="disamount<%=inc%>" name="<%=DISCOUNT %><%=inc%>"
	onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
	validate="Discount Amount,string,no" maxlength="7" disabled="disabled" size="10" /></td>
	<%} %>

	 <input type="hidden" value="" id="prprtnlDis<%=inc%>"name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
		validate="Proporational Discount,string,no" readonly="readonly"	size="10" /> 
		
	<td><input type="text" value="<%=billAmt%>"	id="netamount<%=inc%>" name="<%=NET_AMOUNT %><%=inc%>"
		validate="Net Amount,float,no" readonly="readonly" size="10" /></td>
	<td style="display:none;">
	<%if(surgeryDt.getChargeCode().getMainChargecode().getId() ==27 ){ %>
	<input type="checkbox" value="" id="lalPathId<%=inc%>"	name="lalPath<%=inc%>"
		readonly="readonly" size="10" onclick="orderassignYesNoLalPath(<%=inc%>);" />
		<%}else{ %>
		<input type="checkbox" value="" id="lalPathId<%=inc%>"	name="lalPath<%=inc%>"
		readonly="readonly" size="10" onclick="orderassignYesNoLalPath(<%=inc%>);" disabled="disabled"/>
		<%} %>
		<input type="hidden" value="n" id="lalPathText<%=inc%>"	name="lalPathText<%=inc%>"
		readonly="readonly" size="10"  />
	 <input type="hidden" value="" name="companyId2<%=inc%>" id="companyId2<%=inc%>" />
	  <input type="hidden" value="" name="billTypeId<%=inc%>" id="billTypeId<%=inc%>" />
		
		<input type="hidden" value="" name="patientCategory<%=inc%>" id="patientCategory<%=inc%>" />
	</td>
	<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
	<input id="discntPercentId<%=inc %>" type="hidden"	name="discntPercent<%=inc %>"
		value="<%=surgeryDt.getChargeCode().getDiscountPercentage()%>" />
	<input type="hidden" name="<%=MAIN_CHARGECODE_ID%><%=inc %>"
		value="<%=surgeryDt.getChargeCode().getMainChargecode().getId()%>"  id="ordermainChargeCodeId<%=inc %>"/>
	<input type="hidden" name="<%=SUB_CHARGECODE_ID%><%=inc %>"
		value="<%=surgeryDt.getChargeCode().getSubChargecode().getId()%>"  id="ordersubChargeCodeId<%=inc %>"/>
	<%if(surgeryDt.getChargeCode().getAccount()!=null){ %>
	<input type="hidden" name="<%=FA_ACCOUNT_ID%><%=inc %>"
		value="<%=surgeryDt.getChargeCode().getAccount().getId()%>" />
	<%} %>
	
	<%
int subLdId =0 ;
if (surgeryDt.getChargeCode().getSubAccount() != null) {
subLdId = surgeryDt.getChargeCode().getSubAccount().getId();
}
%>
	<input type="hidden" name="<%=FA_SUB_LED_ID%><%=inc %>"
		value="<%=subLdId%>" />

	<%
	if(surgeryDt.getChargeCode().getMainChargecode()!=null && surgeryDt.getChargeCode().getMainChargecode().getDepartment()!= null && surgeryDt.getChargeCode().getMainChargecode().getDepartment().getDepartmentType() !=null ){
%>
	<input type="hidden" name="<%=DEPARTMENT_TYPE_CODE%><%=inc %>"
		value="<%=surgeryDt.getChargeCode().getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode()%>" />
	<input type="hidden" name="<%=DEPARTMENT_ID%><%=inc %>"
		value="<%=surgeryDt.getChargeCode().getMainChargecode().getDepartment().getId()%>" />

	<%}
%>
	<%
		if(surgeryDt.getChargeCode().getDiscountable().equalsIgnoreCase("y") ){
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
		if(surgeryDt.getChargeCode().getEditable().equals("y") ){
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
				BigDecimal chargeAmt = new BigDecimal(qty).multiply(charge);
				//BigDecimal netAmt = new BigDecimal(qty).multiply(charge);
				totalBillAmt = totalBillAmt.add(chargeAmt);
				totalNetAmt = totalNetAmt.add(billAmt);
			}
		
		}

}
	%>
</table>
</div>
</div>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" />

<!--table ends--> 
<input type="hidden" value="<%=inc %>" name="hiddenValueCharge" id="hiddenValueCharge" />
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="Block">
<label>Bill Amount</label> <%

%> 
<input type="text" id="totalAmtId" name="<%=BILL_AMOUNT %>"	class="readOnly" value="<%=totalBillAmt %>" readOnly /> 
<%-- <%
	if(patientTypeId == 8 || patientTypeId == 2){
%> 
<label>Staff Health Scheme</label> <%}else{ %>  --%><label>Total
Discount</label> <%-- <%} %> --%>


<input type="text" id="compDiscountId" name="compDiscount" value="" class="readOnly" readonly="readonly"  /> 
	
<script	type="text/javascript">

	var authorizerArr = new Array();

</script> 
	 <label>Net Amount</label> 
<input type="text" id="totalNetId" name="<%=TOTAL_AMOUNT%>" value="<%=totalNetAmt %>" class="readOnly" readonly />
<input type="hidden" id="totalNetId1" name="<%=TOTAL_AMOUNT%>1" value="<%=totalNetAmt %>" class="readOnly" readonly />

<!-- <label>Total Charity1</label> --> <%

%> <input type="hidden" id="charityId" name="charity"
	class="readOnly" readonly="readonly" value="" /> <div class="clear"></div>
<label>Pay Status</label>
<select name="paymentMethod" id="paymentMethodId" onchange="diplayPayment(this.value);" >
			<option value="P" selected="selected">Payment</option>
			<option value="W">Waiver</option>
			<option value="PL">Pay Later</option>
		</select>
		<div class="wAmt" id="wAmtId">
		<label>Wavier Amt</label>		
		<input type="text" vlaue="" name="waiveAmt" id="waiveAmtId" onblur="calcluateAmt(this.value);">	
		</div>
		<div class="ostAmt" id="ostAmtId">
		<label>OutStanding Amt</label>		
		<input type="text" vlaue="" name="outstadAmt" id="outstadAmtId" onblur="calcluateOstAmt(this.value);">	
		</div>
 
	
<label>Round Off</label>  <input type="text" id="roundId" name="<%=ROUND_OF_VALUE %>"
	value="" class="readOnly" readonly="readonly" />


<label> Payable Amount</label>

<input type="text" id="totalPayId" name="<%=TOTAL_AMOUNT%>" value="<%=totalNetAmt %>"  readonly="readonly"/>

<!-- added authorizer by Amit Das on 15-02-2016 -->
<div class="wAmt" id="authorizeDiv" style="display: none;">
		

 <label>Authorizer</label>
<select name="authorizerIdForScheme" id="authorizerIdForScheme" >
	<option value="0">Select</option>
	<%	for (Object[] authorizer : authorizerList) {	%>
	<option value="<%=authorizer[1] %>"><%=authorizer[0]%></option>
	<%}%>
	</select>
</div>
<!-- end of authorizer by Amit Das on 15-02-2016 -->


<input type="hidden" value="<%=pastDue%>" class="readOnly" id="balanceAmount" name="balanceAmount" 
		readonly="readonly" /> 
<div class="clear"></div>
 
<div id="advanceadjistdiv">	
<label class="auto">
<input type="checkbox" id="advAdjCheckId" name="" class="radiobutMargin" value="" onclick="displayOPAdvance(this);" />
Adjust Against Credit</label>
	
<input type="text" id="adjusetCreditId" style="display: none;" name="adjusetCreditId" class="inputSmall" value="0.00"
		onblur="adjustOPBillAmt(this.value);"	 validate="Discount On Bill,float,no" maxlength="5"  />
<label>Available Credit Balance</label>
<input type="text" id="avAdvAmtId" style="display: none;" name="avAdvAmtId" readonly="readonly" class="inputSmall" value="<%=pastDue %>" maxlength="9" />
<%
if (new BigDecimal (pastDue).compareTo(new BigDecimal(0)) < 0) {
%> 
<label>Advance Adjustment</label> <input type="checkbox"
	id="advAdjCheckId" class="radioCheck" value=""
	onclick="displayAdvanceText(this);" /> <label id="amtLabel"
	style="display: none;" class="auto">Amount</label> 
	<input type="text" id="advAdjId" name="<%=ADVANCE_ADJUSTMENT %>" value="" class="small" 
	style="display: none;" maxlength="9" onblur="checkAdvanceAmt(this.value,'<%=adv %>');" /> <%

	//}else if(adv.equals("") && patientTypeId != 3){
	} else if (new BigDecimal (pastDue).compareTo(new BigDecimal(0)) > 0 ) {
 %> <!-- <label >Outstanding11</label> --> 
 <input type="hidden" id="outstandingId" name="<%=OUTSTANDING %>"
	class="small" value=""
	onblur="checkOutstandingAmt(this.value);" maxlength="9" /> <%
 	}
	
 %> 
<!-- <label>Balance To Be Paid</label> --> <%
BigDecimal payableAmt = new BigDecimal(0);

	if(!pastDue.equals("") && !pastDue.substring(0,1).equals("-"))
		payableAmt=totalNetAmt.add(new BigDecimal(pastDue.toString()));
	else if(!pastDue.equals("") && pastDue.substring(0,1).equals("-"))
		payableAmt=totalNetAmt;
	%> <input type="hidden" id="payableAmtId" name="<%=PAYABLE_AMOUNT %>"
	value="<%=payableAmt %>" class="readOnly" readOnly /> 
	<input type="hidden" id="totalDisId" name="<%=DISCOUNT_AMOUNT %>"
	value="" class="small" readonly="readonly" /> <input
	type="hidden" name="counter" id="counter" value="<%=inc %>" />

<label>Ballance to Be Paid</label>
<input type="text" id="balToBePiadId" name="balToBePiadId" value="<%=totalNetAmt %>" class="inputSmall" readonly="readonly" />
<!-- <input type="text" id="balToBePiadId" name="balToBePiadId" value="" class="" /> -->
</div>	

<label class="medium">Remarks</label>
<textarea name=<%=REMARKS %> value="" rows="2"  cols="4" validate="Remarks,String,no" class="textareaMediua">  </textarea>

<div class="clear"></div>


<script type="text/javascript">
var bankArray=new Array();
</script>

<div class="clear"></div>
<div class="paymentDiv" id="paymentDiv">
<h4>Payment Details</h4>
<div class="clear"></div>

<div class="cmntable" style="width:1105px; float:left;">
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
			<option value="C" selected="selected">Cash</option>
			<option value="Q">Cheque</option>
			<option value="R">Credit Card</option>
		</select></td>
		<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i%>" 
			id="amt<%=i %>" value="<%=payableAmt %>" validate="Amount,string,no" 
			maxlength="9"
			onblur="if(validateAmount(this.value,<%=i %>)){calculateOutstandingAmt();};" />
			<input type="hidden" name="amtHidden<%=i%>"
			id="amtHidden<%=i %>" value="<%=payableAmt %>"/>
			</td>
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
				for (Object[] bankMaster : bankList) {
			%>
			<option value="<%=bankMaster[1] %>"><%=bankMaster[0]%></option>
			<script>
			bankArray[<%=j%>]= new Array();
			bankArray[<%=j%>][0] = "<%=bankMaster[1]%>";
			bankArray[<%=j%>][1] = "<%=bankMaster[0]%>";

		</script>
			<%
				j++;
				}
			%>
		</select></td>

		<td><input type="button" name="add" class="buttonAdd" onclick="addRowForPayment('billServicing');" /></td>
	</tr>
</table>
</div>
<input type="button" name="delete" class="buttonDel" onclick="removeRowForPayment();" />

<div class="clear"></div>
<div class="paddingTop5"></div>

<input type="hidden" value="<%=registrationType %>"
	name="registrationType" /> <input type="hidden" value="1"
	name="hiddenValuePayment" id="hiddenValuePayment" />
<div class="clear"></div>

<label><span>*</span> Amount Tendered</label> <input type="text" id="actualColAmtId" name="actualColAmtId" 
	onblur="showDifference();" value=""
	validate="Actual Collected Amount,float,no" maxlength="8" tabindex="1" />
<label> Balance To Be Returned</label>
<input type="text" value="" id="balToBeRId" name="balToBeRId" onblur="totalAdvCredit(this.value);"/>
<!-- <input type="text" value="0" style="border: 0px; font-size: 12; font: bold; padding-left: 5px;"
	id="netBalanceAmount" name="netBalanceAmount" readonly="readonly" /> -->
<label>Remaining Credit</label>
<input type="text" value="" id="remainCId" name="remainCId" onblur="totalAdvValue(this.value);"/>
<div class="clear"></div>


<label class="heightAuto"><input type="checkbox" id="charitYId" value="" class="radiobutMargin" onclick="transferCharity(this);" />  Refund Transfer To Charity</label>
<input type="text" id="charityTransferId" name="charityTransferId" class="" value=""
		onblur="onUpdateCharityCreditOp(this.value);"	 validate="Discount On Bill,float,no" maxlength="5" />
<label>Charity Name</label>
<select name="charityIdd" id="charityIdd" validate="Charity Name,string,no">
<option value="0">--Select--</option>
<%
if(masCharityList!=null && masCharityList.size()>0){
	for(Object[] charityy:masCharityList){ %>
	<option value="<%=charityy[2] %>"><%=charityy[0]%></option>
	<%}} %>
</select>

<div class="clear"></div>
</div>
<!-- <input type="text" value="0" style="border: 0px; font-size: 12; font: bold; padding-left: 5px;"
	id="netBalanceAmount" name="netBalanceAmount" readonly="readonly" /> -->
	<!-- 
<label><span>*</span> Advance Amount is :</label> - --><input type="hidden"
	style="border: 0px; font-size: 12; font: bold; padding-left: 5px;"
	id="netAdvanceAmount" name="netAdvanceAmount" readonly="readonly" value="<%=pastDue%>" />	
<script
	type="text/javascript">
  function showDifference1()
 {
 	var a=document.getElementById('actualColAmtId').value;
  	var a1=document.getElementById('payableAmtId').value;
  	if(a !=""){
  		if(parseFloat(a) < parseFloat(a1)){
  	  			alert("Collected Amount should not be less than Payable Amount.");
  			//getShadow("actualColAmtId");
  		document.getElementById('actualColAmtId').value = "";
  			return false;
  	}}
		/* document.getElementById('balToBeRId').value=parseFloat(a)-parseFloat(a1);
 	}else{
 		document.getElementById('balToBeRId').value = "";
 	} */
 	return true;
 } 


 </script>
<div class="clear"></div></div>

<table id="batchDetails" style="display: block;">
</table>

<input type="hidden" id="totalBatchId" name="batchNoCounter" value="0" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" tabindex="1" class="button" name="Submit11"
	value="Submit"
	onclick="if(checkFilledRow()){if(validateFieldsOnSubmit()){if(checkCollectedAmt()){submitForm('billServicing','opBilling?method=submitBillServicingDetails','validatePaymentAmt','validateChequeAndCreditCardDate');}}}"
	align="right" /> 
	

<input type="button" class="button" value="Back" onclick="submitFormCancel('billServicing','opBilling?method=showBillServicingJsp')" />
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

document.getElementById("wAmtId").disabled = true;
document.getElementById("wAmtId").style.display = 'none';
document.getElementById("ostAmtId").disabled = true;
document.getElementById("ostAmtId").style.display = 'none';


function validateRateValue(val,count,rate){
	if(val != ""){
		if(!validateFloat(val)){
			if(!displayAlert("Rate should be integer or decimal value"))
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
		if(!displayAlert("Rate can not be blank"))
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
				if(validateChargeCodeForBillingAutoComplete(this.value, (iteration),'op')){submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge'+iteration+'='+encodeURIComponent(this.value)+'&rowVal='+(iteration)+'&hin=<%=hin%>&type=op&schemeList='+document.getElementById("schemeList").value,'rateVal'+(iteration));}

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

    
	new Ajax.Autocompleter('chargeCode'+ (iteration),'ac2update'+iteration,'opBilling?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode'+ (iteration)+'&'+csrfTokenName+'='+csrfTokenValue, callback: eventCallback});


	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=QUANTITY%>'+ (iteration);
	e2.id = 'qty'+(iteration)
	//e2.tabIndex="1";
	e2.maxLength ='3';
	e2.readOnly = true;
	e2.onblur= function(){
					if(validateQtyForBilling(this.value,this.id,iteration)){calculateNetAmount(iteration);calculateTotalAmt();};
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

	<%-- var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=STANDARD_DEDUCTION%>'+ (iteration);
	e4.readOnly = true;
	e4.id='standardDeductionId'+(iteration);
	e4.size='12';
	cell4.appendChild(e4); --%>

	var cell5 = row.insertCell(4);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=AMOUNT%>'+ (iteration);
	e5.readOnly = true;
	e5.size='13';
	e5.id='amount'+(iteration);
	cell5.appendChild(e5);

	var cell6 = row.insertCell(5);
	var e6 = document.createElement('input');
	e6.type = 'text';
	e6.name='<%=DISCOUNT_PERCENTAGE%>'+ (iteration);
	e6.id='dispercent'+(iteration);
	e6.onChange = function(){
					if(checkDiscountAmt(iteration)){calculateDiscountAmt((iteration));calculateNetAmount(iteration);calculateTotalAmt();};
				};
	e6.size = '10';
	e6.disabled = true;
	e6.maxLength = '3';
	cell6.appendChild(e6);

	var cell7 = row.insertCell(6);
	var e7 = document.createElement('input');
	e7.type = 'text';
	e7.name='<%=DISCOUNT%>'+ (iteration);
	e7.id='disamount'+(iteration);
	e7.onblur = function(){
					if(checkDiscountAmt(iteration)){validateDiscAmt(this.value,iteration);disableDiscountPercent(iteration);calculateNetAmount(iteration);calculateTotalAmt();};
				};
	e7.maxLength = '7';
	e7.size = '10';
	e7.disabled = true;
	cell7.appendChild(e7);

	//var cell7 = row.insertCell(7);
	var e7= document.createElement('input');
	e7.type = 'hidden';
	e7.name='<%=PROPORTIONAL_DISCOUNT%>'+ (iteration);
	e7.id='prprtnlDis'+(iteration);
	cell7.appendChild(e7);

	var cell8 = row.insertCell(7);
	var e8 = document.createElement('input');
	e8.type = 'text';
	e8.name='<%=NET_AMOUNT%>'+ (iteration);
	e8.id='netamount'+(iteration);
	e8.readOnly = true;
	e8.size = '10';
	cell8.appendChild(e8);

	/* var cell10 = row.insertCell(10);
	var e10 = document.createElement('input');
	e10.type = 'checkbox';
	e10.name='lalPath'+ (iteration);
	e10.id='lalPathId'+(iteration);
	e10.readOnly = true;
	e10.onclick = function(){
		assignYesNoLalPath(iteration);
	};
	e10.size = '10';
	cell10.appendChild(e10); */
	
	/* var e101 = document.createElement('input');
	e101.type = 'hidden';
	e101.name='lalPathText'+ (iteration);
	e101.id='lalPathText'+(iteration);
	e10.disabled = true;
	e101.size = '10';
	cell10.appendChild(e101); */

	/* var e102 = document.createElement('input');
	e102.type = 'hidden';
	e102.name='companyId2'+ (iteration);
	e102.id='companyId2'+(iteration);
	e102.size = '10';
	cell10.appendChild(e102);
	 */
	/* var e103 = document.createElement('input');
	e103.type = 'hidden';
	e103.name='billTypeId'+ (iteration);
	e103.id='billTypeId'+(iteration);
	e103.size = '10';
	cell10.appendChild(e103); */
	
	/* var e104 = document.createElement('input');
	e104.type = 'hidden';
	e104.name='patientCategory'+ (iteration);
	e104.id='patientCategory'+(iteration);
	e104.size = '10';
	cell10.appendChild(e104); */

	var cell9 = row.insertCell(8);
	var e9 = document.createElement('input');
	e9.type = 'button';
	e9.id = 'addBtn'+(iteration);
	e9.name='add';
	e9.className = 'buttonAdd';
	e9.tabIndex="1";
	e9.onclick = function(){
					addRow();
	}
	cell9.appendChild(e9);
}

function removeRow()
{
	var tbl = document.getElementById('chargeDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-2==0){
  		if(!displayAlert("Can not delete all rows"))
  	  		alert("Can not delete all rows");
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

function openPopupForItem(val,rowVal){

var code = "";
	if(val != ""){
		var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var code = val.substring(index1,index2);
		if(code !=""){
			window.open('opBilling?method=showItemBatchNoPopUpForConsumption&chargeCode='+encodeURIComponent(code)+'&rowVal='+rowVal+'&hinId='+<%=hinId%>+'&patientTypeId=<%=patientTypeId%>&deptCode=PHAR','mywindow','target="_blank", width=780,height=300');

		}
	}
}

function numberForCheckBoxClicked()
{
	var obj1= document.getElementById('mainChargeCodeId');

	if(document.getElementById('checkId').checked==true)
			 {
		         obj1.options[9].selected="selected"
				 document.getElementById('checkId').value="y";

				 }
				 else
				 {

				  document.getElementById('checkId').value="n";
				  obj1.options[0].selected="selected"

				 }

}

function getChangeCheckBox()
{

	var mainCgargeId=document.getElementById('mainChargeCodeId').value;
	if(mainCgargeId==1)
	{
	document.getElementById('checkId').checked=true;
	document.getElementById('checkId').value="y";
	}
	else
	{
		document.getElementById('checkId').checked=false;
		document.getElementById('checkId').value="n";
	}
	}

function showUrgentDetails()
{

	var cnsltDocId=document.getElementById('cnsltDocId').value;

if(cnsltDocId=="00")
{

document.getElementById('urgentDetails').style.display = 'inline';
document.getElementById('refDoctor').value="";
}
else
{
	document.getElementById('refDoctor').value="";
document.getElementById('urgentDetails').style.display = 'none';
}
}
	function assignYesNoLalPath(rowval){
	if(document.getElementById('lalPathId'+rowval).checked == true){
		document.getElementById('lalPathText'+rowval).value='y'
		document.getElementById('companyId2'+rowval).value='35';
		document.getElementById('billTypeId'+rowval).value='2'
		document.getElementById('patientCategory'+rowval).value='OP';
		
	ajaxFunctionForRate('billServicing','/hms/hms/opBilling?method=fillRateAfterDiscount&chargeId='+document.getElementById("chargeId"+rowval).value+'&mainChargeId='+document.getElementById("mainChargeCodeId"+rowval).value+'&subChargeId='+document.getElementById("subChargeCodeId"+rowval).value+'&lalPathText='+document.getElementById("lalPathText"+rowval).value+'&patientTypeId2='+document.getElementById("patientTypeId2").value+'&companyId2='+document.getElementById("companyId2"+rowval).value+'&companyId='+document.getElementById("companyId").value+'&billTypeId='+document.getElementById("billTypeId"+rowval).value+'&patientCategory='+document.getElementById("patientCategory"+rowval).value+'&rowval='+rowval,rowval);
	}else{
		document.getElementById('lalPathText'+rowval).value='n'
		submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge'+rowval+'='+document.getElementById("chargeCode"+rowval).value+'&rowVal='+(rowval)+'&hin=<%=hin%>&type=op','rateVal');
		
	}
	}

	function orderassignYesNoLalPath(rowval){
	if(document.getElementById('lalPathId'+rowval).checked == true){
	document.getElementById('lalPathText'+rowval).value='y'
	document.getElementById('companyId2'+rowval).value='35';
	document.getElementById('billTypeId'+rowval).value='2'
	document.getElementById('patientCategory'+rowval).value='OP';
	
	ajaxFunctionForOrderRate('billServicing','/hms/hms/opBilling?method=fillOrderRateAfterDiscount&chargeId='+document.getElementById("chargeId"+rowval).value+'&ordermainChargeId='+document.getElementById("ordermainChargeCodeId"+rowval).value+'&ordersubChargeId='+document.getElementById("ordersubChargeCodeId"+rowval).value+'&lalPathText='+document.getElementById("lalPathText"+rowval).value+'&patientTypeId2='+document.getElementById("patientTypeId2").value+'&companyId2='+document.getElementById("companyId2"+rowval).value+'&companyId='+document.getElementById("companyId").value+'&billTypeId='+document.getElementById("billTypeId"+rowval).value+'&patientCategory='+document.getElementById("patientCategory"+rowval).value+'&rowval='+rowval,rowval);
	}else{
	
	document.getElementById('lalPathText'+rowval).value='n'
	submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge'+rowval+'='+document.getElementById("chargeCode"+rowval).value+'&rowVal='+(rowval)+'&hin=<%=hin%>&type=op','rateVal'+(rowval));
		}
		}
	
	
	function updateDiscountByScheme()
	{
		for(var i=1; i<=document.getElementById('hiddenValueCharge').value; i++)
		{
			if(document.getElementById('amount'+i) != null)
			{
				
				document.getElementById("chargeCode"+i).onblur();
			}
		}
	}
	
	
	function  onChangeScheme()
	{
		updateDiscountByScheme();
	}
	
	updateDiscountByScheme();
	
	/* alert(document.getElementById('resrate1'));
	document.getElementById('resrate1').onblur(); */
	
	// Added by Amit Das on 02-03-2016
	var schemeId_op = "";
	var schemeName_op = "";
	schemeId_op = document.getElementById("schemeId_op").value;
	schemeName_op = document.getElementById("schemeName_op").value;
	
	submitProtoAjaxWithDivName('billServicing','/hms/hms/billingMaster?method=listScheme&type=op&schemeId='+schemeId_op+'&schemeName='+schemeName_op,'schemeDiv');
	
	var container12 = document.getElementById ("schemeDiv");
     if (container12.addEventListener) {
    	 container12.addEventListener ('DOMSubtreeModified', updateDiscountByScheme, false);
     }
     
	/* document.getElementById('schemeDiv').bind("DOMSubtreeModified",function(){
		  alert('changed');
		});
	
	document.getElementById('schemeDiv').bind("append", function() { alert("its come"); updateDiscountByScheme(); });
	 */
	function diplayPayment(obj)
	{
		if(obj == "P"){
			var payableAmt=document.getElementById("totalAmtId").value;
			document.getElementById("totalPayId").value=payableAmt;
			document.getElementById("paymentDiv").disabled = false;
			document.getElementById("paymentDiv").style.display = 'block';
			document.getElementById("wAmtId").disabled = true;
			document.getElementById("wAmtId").style.display = 'none';
			document.getElementById("ostAmtId").disabled = true;
			document.getElementById("ostAmtId").style.display = 'none';
			document.getElementById("advAdjCheckId").disabled = false;
			document.getElementById("advAdjCheckId").style.display = 'block';
			document.getElementById("authorizeDiv").style.display = 'none'; <!-- edited authorizer by Amit Das on 15-02-2016 -->
			
		}
		else if(obj == "W"){
            var payableAmt=document.getElementById("totalPayId").value;
			document.getElementById("paymentDiv").disabled = true;
			document.getElementById("paymentDiv").style.display = 'none';
			document.getElementById("wAmtId").disabled = false;
			document.getElementById("wAmtId").style.display = 'block';
			document.getElementById("ostAmtId").disabled = true;
			document.getElementById("ostAmtId").style.display = 'none';
			document.getElementById("advAdjCheckId").disabled = true;
			document.getElementById("advAdjCheckId").style.display = 'none';
			document.getElementById("waiveAmtId").value=payableAmt;
			document.getElementById("authorizeDiv").style.display = 'block'; <!-- added authorizer by Amit Das on 15-02-2016 -->
		}
		else if(obj == "PL"){
			var payableAmt=document.getElementById("totalPayId").value;
			document.getElementById("paymentDiv").disabled = true;
			document.getElementById("paymentDiv").style.display = 'none';
			document.getElementById("wAmtId").disabled = true;
			document.getElementById("wAmtId").style.display = 'none';
			document.getElementById("ostAmtId").disabled = false;
			document.getElementById("ostAmtId").style.display = 'block';
			document.getElementById("advAdjCheckId").disabled = true;
			document.getElementById("advAdjCheckId").style.display = 'none';
			document.getElementById("outstadAmtId").value=payableAmt;
			document.getElementById("authorizeDiv").style.display = 'block'; <!-- added authorizer by Amit Das on 15-02-2016 -->
		}
	}
      function calcluateAmt(value)
      {
    	  var billAmt=document.getElementById("totalAmtId").value;
    	 var waveAmt=document.getElementById("waiveAmtId").value;
    	  var payAmt=document.getElementById("totalPayId").value;
   
    		document.getElementById("totalPayId").value=parseFloat(billAmt)-parseFloat(waveAmt);    		
      }
      function calcluateOstAmt(value)
      {
    	  var billAmt=document.getElementById("totalAmtId").value;
    	 var osAmt=document.getElementById("outstadAmtId").value;
    	  var payAmt=document.getElementById("totalPayId").value;
    
    		document.getElementById("totalPayId").value=parseFloat(billAmt)-parseFloat(osAmt);    		}
      
     
</script>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
