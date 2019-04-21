<%@page import="jkt.hms.masters.business.AmbulanceRegister"%>
<%@page import="jkt.hms.masters.business.RsbyCardDetails"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasCharityType"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
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


<form name="ipBilling" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	List<Inpatient> patientDetailsList = new ArrayList<Inpatient>();
	List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
	List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
	List<Object[]> employeeList = new ArrayList<Object[]>();
	List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
	List<MasCharityType> masCharityList = new ArrayList<MasCharityType>();
	List<MasPatientType> masPTypeList= new ArrayList<MasPatientType>();
	List<MasPatientType> masPTypeLists= new ArrayList<MasPatientType>();
	List<MasPatientType> masPTypeListo = new ArrayList<MasPatientType>();
	List<DgOrderdt> orderdtList = new ArrayList<DgOrderdt>();
	List<RsbyCardDetails> rsbyCardDetailList = new ArrayList<RsbyCardDetails>();
	List<AmbulanceRegister>AmbulanceRegisterList=new ArrayList<AmbulanceRegister>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (map.get("masPTypeListo") != null) {
		masPTypeListo = (List<MasPatientType>) map.get("masPTypeListo");
	}
	if (map.get("masPTypeList") != null) {
		masPTypeList = (List<MasPatientType>) map.get("masPTypeList");
	}
	if (map.get("masPTypeLists") != null) {
		masPTypeLists = (List<MasPatientType>) map.get("masPTypeLists");
	}
	if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
	}
	if (map.get("masCharityList") != null) {
		masCharityList = (List<MasCharityType>) map.get("masCharityList");
	}
	if(map.get("patientDetailsList") != null){
		patientDetailsList = (List<Inpatient>)map.get("patientDetailsList");
	}
	if(detailsMap.get("mainChargeCodeList") != null){
		mainChargeCodeList = (List<MasMainChargecode>)detailsMap.get("mainChargeCodeList");
	}
	if(detailsMap.get("subChargeCodeList") != null){
		subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
	}
	if(detailsMap.get("chargeCodeList") != null){
		chargeCodeList = (List<MasChargeCode>)detailsMap.get("chargeCodeList");
	}
	if (map.get("bankList") != null) {
		bankList = (List<MasBankMaster>) map.get("bankList");
	}
	if (map.get("employeeList") != null) {
		employeeList = (List<Object[]>) map.get("employeeList");
	}
	if (map.get("authorizerList") != null) {
		authorizerList = (List<MasAuthorizer>) map.get("authorizerList");
	}
	if(map.get("orderdtList") != null){
		orderdtList = (List<DgOrderdt>)map.get("orderdtList");
	}
	
	if(map.get("rsbyCardDetailList") != null){
		rsbyCardDetailList = (List<RsbyCardDetails>)map.get("rsbyCardDetailList");
	}
	if(map.get("AmbulanceRegisterList") != null){
		AmbulanceRegisterList = (List<AmbulanceRegister>)map.get("AmbulanceRegisterList");
	}
	String flag1="";
	if(map.get("flag1")!=null){
		flag1=(String)map.get("flag1");
	}
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	

	int hinId = 0;
	int patientTypeId = 0;
	String adv = "";
	String pastDue = "";
	
	if(patientDetailsList.size() > 0){
		
		
     %> <!--Block One Starts-->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="titleBg">
<h2>Bill Servicing Details (IP)</h2>
</div>
<div class="Block">
<h4>Patient Details</h4>
<div class="clear"></div>
<% 
String registrationType = "";
		for(Inpatient inpatient : patientDetailsList){
	   		 Patient patient = inpatient.getHin();
	   		 hinId = patient.getId();
	   		 if(inpatient.getHin().getRegistrationType()!= null){
			 	registrationType = inpatient.getHin().getRegistrationType();
			 }
   			 patientTypeId = patient.getPatientType()!=null?patient.getPatientType().getId():0;
   			
   			 if (patient.getPastDue() != null)
				pastDue = patient.getPastDue();
%>
<label>Bill Date</label> 
<input type="text" value="<%= date%>"/>


<input type="hidden" id="discTypeDB" name="discTypeDB"> <!-- added by amit das on 06-07-2017 -->
<label>Patient Name</label>
<input type="text" value="<%=patient.getPFirstName()%>"/>

<label>Age</label>
<input type="text" value="<%=patient.getAge() %>"/>

<div class="clear"></div>
<label>Gender</label>
<input type="text" value="<%=patient.getSex()!=null?patient.getSex().getAdministrativeSexName():"" %>"/>

<label>Mobile No</label>
<input type="text" value="<%=patient.getMobileNumber()!=null ? patient.getMobileNumber():"" %>"/>

<!-- Added By Amit Das -->
<input type="hidden" value="<%=inpatient.getId()%>" id="inpatientIdForCard" name="inpatientIdForCard"/>
<%-- <input type="hidden" value="<%=(patient.getRsbyCardNo()!=null && !patient.getRsbyCardNo().equals(""))? patient.getRsbyCardNo():""%>" name="patientRsbyCardNo" id="patientRsbyCardNo" />
 --%>
 
 
<%-- <label>Patient Type</label> 
<input type="text" value="<%=patient.getPatientType().getPatientTypeName() %>"/> --%>
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
  <%if(patient.getBplStatus()!=null && patient.getBplStatus().equalsIgnoreCase("y")){ %>
   <input type="text"  readonly="readonly" value="BPL" />
  
  <%}else if (patient.getBplStatus()!=null && patient.getBplStatus().equalsIgnoreCase("y")){%>
   <input type="text"  readonly="readonly" value="APL" />
  
  <%}else{ %>
   <input type="text"  readonly="readonly" value="" />
  
  <%} %>
   <label>Social Category</label> 
 <input type="text"  readonly="readonly" value="<%=patient.getPatientType()!=null?patient.getPatientType().getPatientTypeName():""%>" />
   <label>Other Category</label> 
 <input type="text"  readonly="readonly" value="<%=familyIdo%>" />
 <div class="clear"></div>
<div class="clear"></div>
<label><span>*</span> Consultant Name</label> <select
	name="<%=EMPLOYEE_ID %>" id="cnsltDocId"
	validate="Consultant Name,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
		for (Object[] employee : employeeList) {

					
	%>
	<option value="<%=employee[0]%>"><%=employee[1]
											+ " " + (employee[2]!=null?employee[2]:"" ) + " "
											+ (employee[3]!=null?employee[3]:"" )%></option>
	<%
		
					
					}
	%>
</select>
<label>Ward</label> 
<%
		    String adNo = "";
	    	String ward = "";
	    	int deptID = 0;
		    int inpatientId = 0;
		   	if(inpatient.getAdStatus().equalsIgnoreCase("A") || inpatient.getAdStatus().equalsIgnoreCase("R") ){
					inpatientId = inpatient.getId();
					adNo = inpatient.getAdNo();
					ward = inpatient.getDepartment().getDepartmentName();
					deptID = inpatient.getDepartment().getId();
			}
	    %>
<input type="text" value="<%=ward%>"/>

<label>IPD No.</label> 
<input type="text" value=" <%=adNo%>"/>

<label>Scheme</label>
<!--  <div id="schemeDiv"> commented by govind -->
<%--  <input type="text" name="scheme" value="<%=(inpatient.getScheme()!=null && inpatient.getScheme().getSchemeName()!=null)?inpatient.getScheme().getSchemeName() : "-"%>" readonly="readonly" id="scheme" class="readOnly"> --%>
<%--  <input type="text" name="schemeId" value="<%=inpatient.getScheme()!=null?inpatient.getScheme().getId():"0"%>" readonly="readonly" id="schemeId" > --%>
<!-- </div> -->

<div id="schemeDiv">
 <select name="schemeList" id="schemeId1" onchange="onChangeScheme();">
 <option value="0">Select</option>
</select>
</div>

<%-- <label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> 
<label	class="value"><%=patient.getHinNo() %></label>  --%>

<input type="hidden" name="inpatientDeptID" value="<%=deptID%>"></input>
<div class="clear"></div>
 <%
 	String sign = "";
 			if (!pastDue.equals("")) {
 				sign = pastDue.substring(0, 1);
 				if (sign.equals("-")) {
 					adv = pastDue.substring(1);
 				}
 			}
 			if (!adv.equals("")) {
 %><%--  <label>Total Advance</label> <label class="value"> <%=adv%></label> --%>
<%
	}
%> <%-- <label>Patient Type</label> <label class="value"><%=patient.getPatientType().getPatientTypeName() %></label> --%>

<%
 	if(patient.getCompany() != null){
 		if(patient.getPatientType().getId() == 1){
 %>

<label>Company</label> <%}else if(patient.getPatientType().getId() == 4){ %>
<label>Project</label> <%} %> <label class="value"><%=patient.getCompany().getCompanyName() %></label>
<input type="hidden" id="companyId" name="companyId"
	value="<%=patient.getCompany().getId() %>" /> <%} %>
	 <input
	type="hidden" id="patientTypeId" name="<%=PATIENT_TYPE_ID %>"
	value="<%=patientTypeId %>" />

<div class="clear"></div>

<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
<input type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>">
<input	type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>">
<input	type="hidden" name="<%=AD_NO %>" value="<%=adNo%>">

<script type="text/javascript">

<%
	if(inpatient.getDoctor() != null){
%>
document.getElementById('cnsltDocId').value = '<%=inpatient.getDoctor().getId()%>'
<%}%>
</script> <%} %>
</div>
<script type="text/javascript">
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
</script> <script type="text/javascript">
		var amtArray = new Array();
	<%
			int count = 0;
			
			for (MasChargeCode masChargeCode : chargeCodeList)
			{
	%>
						amtArray[<%=count%>] = new Array();
						amtArray[<%=count%>][0]=<%=masChargeCode.getId()%>;
						amtArray[<%=count%>][1] = <%=masChargeCode.getCharge()%>;									
								
	<%
								count++;
			}
	%>
</script> <input type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
<div class="clear"></div>
<%-- <h4>Charge Details</h4>
<div class="clear"></div>
<div class="Block"><input type=hidden value=0 name=pagecounter2><input
	type="hidden" name="pageNo" id="pageNo" value="" /> <label>Main
Charge</label> <select id="mainChargeCodeId" name="<%=MAIN_CHARGECODE_ID %>"
	onchange="populateSubChargeCodeForBilling(this.value,'ipBilling');">
	<option value="0">Select</option>
	<%
		for (MasMainChargecode mainChargecode : mainChargeCodeList) {
	%>
	<option value="<%=mainChargecode.getId() %>"><%=mainChargecode.getMainChargecodeName()%></option>
	<%
		}
	%>
</select> <label>Sub Charge:</label> <select id="subChargeCodeId"
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
<div class="clear"></div></div> --%>

<%-- <%
	int inc = 1;
%> --%>

<div class="cmntable" style="width:1105px; float:left;">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetailsTable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Charge Code</th>
		<th scope="col">Qty</th>
		<th scope="col">Rate</th>
		<th scope="col"style="display: none;">Std. Deduction</th>
		<th scope="col">Amount</th>
		<th scope="col">Discount(%)</th>
		<th scope="col">Discount Amt</th>
		<th scope="col" >Proportional Discount</th>
		<th scope="col">Net Amount</th>
		<th scope="col"style="display: none;">Print Required</th>
		<th scope="col">&nbsp;</th>
	</tr>
	
	<%
	int inc = 0;
	int payment=0;
	int orderHdId=0;
	System.out.println(AmbulanceRegisterList.size()+"flag1===>>"+flag1);
	if(flag1.equalsIgnoreCase("amb")){
	for(AmbulanceRegister orderDt:AmbulanceRegisterList){
	System.out.println("orderDt.getChargeCode().getChargeCodeName()----->>>"+orderDt.getChargeCode().getChargeCodeName());
	%> 
	<tr>
		<input type="text"  name="flag1" value="<%=flag1 %>" />
		<td><input type="hidden" name="<%=ORDER_BOOKING_ID %>"value="<%=orderHdId %>" />
		<input type="hidden" name="AmbulanceRegisterid" value="<%=orderDt.getId() %>" />
		<input type="radio"	value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>

		<td><input type="text" name="chargeCode<%=inc%>"	id="chargeCode<%=inc%>"
			value="<%=orderDt.getChargeCode().getChargeCodeName() %>[<%=orderDt.getChargeCode().getChargeCodeCode() %>]"
			onblur="if(validateChargeCodeForBillingAutoComplete(this.value, '<%=inc %>','ip')){submitProtoAjaxWithDivNameForBilling('ipBilling','/hms/hms/opBilling?method=fillChargeCode&charge<%=inc %>='+encodeURIComponent(this.value)+'&rowVal=<%=inc%>&hin=<%=hinId%>&type=ip&schemeList='+document.getElementById('schemeId1').value,'rateVal<%=inc %>');}"
			readonly="readonly" tabindex="1" />

		<div id="ac2update<%=inc%>" style="display: none;" class="autocomplete"></div>

		 <script type="text/javascript" language="javascript" charset="utf-8">
		 function eventCallback(element, entry){
			 var comanyId='';
			 /* if(document.getElementById('companyId') !=null)
			 {
			 comanyId=document.getElementById('companyId').value;
			 } */
			 	return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value+"&companyId="+comanyId;
			}
		</script> 
		
		<input type="hidden" id="chargeId<%=inc %>"
			name="<%=CHARGE_CODE_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getId()%>" /></td>

		<td><input type="text" size="5" id="qty<%=inc%>"name="<%=QUANTITY %><%=inc%>"
			 value="<%=orderDt.getDistance().intValue() %>" validate="Qty,int,no" maxlength="5" readonly="readonly"
			onblur="if(validateQtyForBilling(this.value,this.id,<%=inc %>)){calculateNetAmount(<%=inc %>);calculateTotalAmtForIp();};"/></td>
			 
		<td  id="rateVal<%=inc %>" >
		<input type="text" size="12" value="<%=orderDt.getCharge().intValue() %>" id="rate<%=inc%>" name="<%=RATE%><%=inc%>"
		 validate="Rate,float,no" readonly="readonly" onblur="calculateNetAmount(<%=inc %>);calculateTotalAmtForIp();" /></td>

		
		<td style="display:none;"><input type="text" size="12" value="" id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"validate="Standard Deduction,float,no" readonly="readonly" /></td>

		
		<td><input type="text" size="13" value="<%=orderDt.getDistance().intValue()*orderDt.getCharge().intValue()%>"	id="amount<%=inc%>" name="<%=AMOUNT%><%=inc%>"
			validate="Amount,float,no" readonly="readonly" /></td>

		
		<td><input type="text" value="" id="dispercent<%=inc%>"	name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" 
		size="10"	validate="Discount Persentage,string,no"
		onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmtForIp()};"
			maxlength="3" disabled="disabled" size="10" /></td>
		<td><input type="text" value="" id="disamount<%=inc%>" name="<%=DISCOUNT %><%=inc%>"
		onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmtForIp()};"
		validate="Discount Amount,string,no" maxlength="7" disabled="disabled" size="10" /></td>
		

		 <td><input type="text" value="0" id="prprtnlDis<%=inc%>"name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
			validate="Proporational Discount,string,no" readonly="readonly"	size="10" /></td>
			
		<td><input type="text" value="<%=orderDt.getDistance().intValue()*orderDt.getCharge().intValue()%>"	id="netamount<%=inc%>" name="<%=NET_AMOUNT %><%=inc%>"
			validate="Net Amount,float,no" readonly="readonly" size="10" /></td>
		<td style="display:none;">
		
			<input type="checkbox" value="" id="lalPathId<%=inc%>"	name="lalPath<%=inc%>"
			readonly="readonly" size="10" onclick="orderassignYesNoLalPath(<%=inc%>);" disabled="disabled"/>
			
			<input type="hidden" value="n" id="lalPathText<%=inc%>"	name="lalPathText<%=inc%>"
			readonly="readonly" size="10"  />
		 <input type="hidden" value="" name="companyId2<%=inc%>" id="companyId2<%=inc%>" />
		  <input type="hidden" value="" name="billTypeId<%=inc%>" id="billTypeId<%=inc%>" />
			
			<input type="hidden" value="" name="patientCategory<%=inc%>" id="patientCategory<%=inc%>" />
		</td>
		<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
		<input id="discntPercentId<%=inc %>" type="hidden"	name="discntPercent<%=inc %>"
			value="<%=orderDt.getChargeCode().getDiscountPercentage()%>" />
		<input type="hidden" name="<%=MAIN_CHARGECODE_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getMainChargecode().getId()%>"  id="ordermainChargeCodeId<%=inc %>"/>
		<input type="hidden" name="<%=SUB_CHARGECODE_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getSubChargecode().getId()%>"  id="ordersubChargeCodeId<%=inc %>"/>
		<%if(orderDt.getChargeCode().getAccount()!=null){ %>
		<input type="hidden" name="<%=FA_ACCOUNT_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getAccount().getId()%>" />
		<%} %>
		
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
	<%payment=orderDt.getDistance().intValue()*orderDt.getCharge().intValue();}
	
	
	
	} else if (orderdtList.size() > 0) {
			for (int i = 0; i < orderdtList.size(); i++) {
				
				DgOrderdt orderDt = new DgOrderdt();
				orderDt = orderdtList.get(i);
				if (orderDt.getPaymentMade().equals("n")) {
					orderHdId = orderDt.getOrderhd().getId();
					inc++;
	%>
	
		<tr>

		<td><input type="hidden" name="<%=ORDER_BOOKING_ID %>"value="<%=orderHdId %>" />
		<input type="hidden" name="<%=DG_ORDER_DETAIL_ID %><%=inc %>"value="<%=orderDt.getId() %>" />
		<input type="radio"	value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>

		<td><input type="text" name="chargeCode<%=inc%>"	id="chargeCode<%=inc%>"
			value="<%=orderDt.getChargeCode().getChargeCodeName() %>[<%=orderDt.getChargeCode().getChargeCodeCode() %>]"
			onblur="if(validateChargeCodeForBillingAutoComplete(this.value, '<%=inc %>','ip')){submitProtoAjaxWithDivNameForBilling('ipBilling','/hms/hms/opBilling?method=fillChargeCode&charge<%=inc %>='+encodeURIComponent(this.value)+'&rowVal=<%=inc%>&hin=<%=hinId%>&type=ip&schemeList='+document.getElementById('schemeId1').value,'rateVal<%=inc %>');}"
			readonly="readonly" tabindex="1" />

		<div id="ac2update<%=inc%>" style="display: none;" class="autocomplete"></div>

		 <script type="text/javascript" language="javascript" charset="utf-8">
		 function eventCallback(element, entry){
			 var comanyId='';
			 /* if(document.getElementById('companyId') !=null)
			 {
			 comanyId=document.getElementById('companyId').value;
			 } */
			 	return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value+"&companyId="+comanyId;
			}
		</script> 
		
		<input type="hidden" id="chargeId<%=inc %>"
			name="<%=CHARGE_CODE_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getId()%>" /></td>

		<td><input type="text" size="5" id="qty<%=inc%>"name="<%=QUANTITY %><%=inc%>"
			 value="<%=orderDt.getOrderQty() %>" validate="Qty,int,no" maxlength="5" readonly="readonly"
			onblur="if(validateQtyForBilling(this.value,this.id,<%=inc %>)){calculateNetAmount(<%=inc %>);calculateTotalAmtForIp();};"/></td>
			 
		<td  id="rateVal<%=inc %>" >
		<input type="text" size="12" value="" id="rate<%=inc%>" name="<%=RATE%><%=inc%>"
		 validate="Rate,float,no" readonly="readonly" onblur="calculateNetAmount(<%=inc %>);calculateTotalAmtForIp();" /></td>

		
		<td style="display:none;"><input type="text" size="12" value="" id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"validate="Standard Deduction,float,no" readonly="readonly" /></td>

		
		<td><input type="text" size="13" value=""	id="amount<%=inc%>" name="<%=AMOUNT%><%=inc%>"
			validate="Amount,float,no" readonly="readonly" /></td>

		
		<td><input type="text" value="" id="dispercent<%=inc%>"	name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" 
		size="10"	validate="Discount Persentage,string,no"
		onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmtForIp()};"
			maxlength="3" disabled="disabled" size="10" /></td>
		<td><input type="text" value="" id="disamount<%=inc%>" name="<%=DISCOUNT %><%=inc%>"
		onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmtForIp()};"
		validate="Discount Amount,string,no" maxlength="7" disabled="disabled" size="10" /></td>
		

		 <td><input type="text" value="0" id="prprtnlDis<%=inc%>"name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
			validate="Proporational Discount,string,no" readonly="readonly"	size="10" /></td>
			
		<td><input type="text" value=""	id="netamount<%=inc%>" name="<%=NET_AMOUNT %><%=inc%>"
			validate="Net Amount,float,no" readonly="readonly" size="10" /></td>
		<td style="display:none;">
		
			<input type="checkbox" value="" id="lalPathId<%=inc%>"	name="lalPath<%=inc%>"
			readonly="readonly" size="10" onclick="orderassignYesNoLalPath(<%=inc%>);" disabled="disabled"/>
			
			<input type="hidden" value="n" id="lalPathText<%=inc%>"	name="lalPathText<%=inc%>"
			readonly="readonly" size="10"  />
		 <input type="hidden" value="" name="companyId2<%=inc%>" id="companyId2<%=inc%>" />
		  <input type="hidden" value="" name="billTypeId<%=inc%>" id="billTypeId<%=inc%>" />
			
			<input type="hidden" value="" name="patientCategory<%=inc%>" id="patientCategory<%=inc%>" />
		</td>
		<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
		<input id="discntPercentId<%=inc %>" type="hidden"	name="discntPercent<%=inc %>"
			value="<%=orderDt.getChargeCode().getDiscountPercentage()%>" />
		<input type="hidden" name="<%=MAIN_CHARGECODE_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getMainChargecode().getId()%>"  id="ordermainChargeCodeId<%=inc %>"/>
		<input type="hidden" name="<%=SUB_CHARGECODE_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getSubChargecode().getId()%>"  id="ordersubChargeCodeId<%=inc %>"/>
		<%if(orderDt.getChargeCode().getAccount()!=null){ %>
		<input type="hidden" name="<%=FA_ACCOUNT_ID%><%=inc %>"
			value="<%=orderDt.getChargeCode().getAccount().getId()%>" />
		<%} %>
		
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
					 BigDecimal chargeAmt = new BigDecimal(0.00);
					BigDecimal netAmt = new BigDecimal(0.00);
					/* totalBillAmt = new BigDecimal(0.00);;
					totalNetAmt = new BigDecimal(0.00);; 	 */			
					}
			}

	}
	else
	{
		inc++;
	%>
	
	<tr>
		<td><input type="radio" value="<%=inc%>" name="selectedChrage"
			class="radioCheck" /></td>
		<td><input type="text" name="chargeCode<%=inc%>" id="chargeCode<%=inc%>"
			onblur="if(validateChargeCodeForBillingAutoComplete(this.value, '<%=inc %>','ip')){submitProtoAjaxWithDivNameForBilling('ipBilling','/hms/hms/opBilling?method=fillChargeCode&charge1='+encodeURIComponent(this.value)+'&rowVal=1&hin=<%=hinId%>&type=ip&schemeList='+document.getElementById('schemeId1').value,'rateVal<%=inc%>');}"
			tabindex="1" />
		<div id="ac2update<%=inc%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		function eventCallback(element, entry){
				return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value; 
			}
		new Ajax.Autocompleter('chargeCode<%=inc%>','ac2update<%=inc%>','billing?method=getChargeCode',{parameters:'requiredField=chargeCode<%=inc%>'});
		</script></td>
		
		<td><input type="text" id="qty<%=inc%>" size="5"
			name="<%=QUANTITY %><%=inc%>" value="" validate="Qty,int,no"
			onblur="if(validateQtyForBilling(this.value,this.id,<%=inc %>)){calculateNetAmount(<%=inc %>);calculateTotalAmtForIp()};"
			maxlength="4"  /></td>
		<td id="rateVal<%=inc%>"><input type="text" value="" size="12"
			id="rate<%=inc%>" name="<%=RATE%><%=inc%>" validate="Rate,float,no"
			maxlength="12"  /></td>
		<td style="display: none;"><input type="text" value="" size="12"
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" maxlength="12"
			 /></td>
		<td><input type="text" value="" size="13" id="amount<%=inc%>"
			name="<%=AMOUNT%><%=inc%>" validate="Amount,float,no" maxlength="12"
			 /></td>
		<td><input type="text" value="" size="10" id="dispercent<%=inc%>"
			name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" size="10"
			validate="Discount Persentage,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmtForIp()};"
			maxlength="3"  size="10" /></td>
		<td><input type="text" value="" size="10" id="disamount<%=inc%>"
			name="<%=DISCOUNT %><%=inc%>" validate="Discount Amount,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmtForIp()};"
			maxlength="7"  size="10" /></td>
		<td ><input type="text" value="" size="10" id="prprtnlDis<%=inc%>"
			name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
			validate="Proporational Discount,string,no"
			size="10" /></td>
		<td><input type="text" value="" size="10" id="netamount<%=inc%>"
			name="<%=NET_AMOUNT %><%=inc%>" validate="Net Amount,float,no"
			 size="10" /></td>
		<td style="display: none;">
		<input type="checkbox" id="printReq<%=inc%>" name="printReq<%=inc%>" value="y" 
				onclick="getOldAdNo(<%=inc%>);" disabled="disabled" />
		</td>
		<td><input type="button" id="addBtn<%=inc%>" name="add" value="" class="buttonAdd"
			onclick="addRow();" tabindex="1" /></td>
	</tr>
	<%} %>
</table>
</div>

<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" />
<div class="clear"></div>


<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
	id="hiddenValueCharge" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="Block">
<label>Bill Amount</label> 	
<%if(flag1.equals("amb")){ %>
<input type="text" value="<%=payment %>" id="totalAmtId" name="<%=TOTAL_AMOUNT %>" />
<!-- <label>Outstanding Amount</label> -->
<%}else{ %>
<input type="text"  id="totalAmtId" name="<%=TOTAL_AMOUNT %>" />
<%} %>
<input type="hidden" id="outstandingId" name="<%=OUTSTANDING %>"
	class="readOnlySmall" readonly="readonly" />
	<%--  <%
	if(patientTypeId == 8){
%> 
<label>Staff Health Scheme</label> <%}else{ %>  --%>
<label>Total Discount</label><%--  <%} %> --%> <input type="text" id="compDiscountId" name="compDiscount"
	 readonly="readonly" value="" onchange="checkDiscount();" /> <input
	type="hidden" id="totalDisId" name="<%=DISCOUNT_AMOUNT %>"
	class="readOnlySmall" readonly="readonly" /> 
<label style="display: none;">Total Charity</label> <input type="text" id="charityId" name="charity" style="display: none;"
	class="readOnlySmall" readonly="readonly" value="" /> 
<label class="">Net Amount</label> 
<%if(flag1.equals("amb")){ %>
<input type="text" value="<%=payment %>" id="totalNetId" name="<%=TOTAL_NET_AMOUNT%>" value="0.00"  readOnly />
<%}else{ %>
<input type="text" id="totalNetId" name="<%=TOTAL_NET_AMOUNT%>" value="0.00"  readOnly />
<%} %>
<input type="hidden" id="totalNetId1" name="<%=TOTAL_NET_AMOUNT%>1" value="0.00"  readOnly />

<div class="clear"></div>
<%-- <label>Total Amount</label> 
<input type="text" class="readOnlySmall"
	id="totalAmtId" name="<%=TOTAL_AMOUNT %>" readonly="readonly" /> --%>
<div class="clear"></div>
<label>Pay Status</label>
<select name="paymentMethod" id="paymentMethodId" onchange="diplayPayment(this.value);" >
			<option value="P">Payment</option>
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
<%-- 
	
<input type="hidden" id="totalNetId1" name="<%=TOTAL_AMOUNT%>"
	value="" class="readOnlySmall" readOnly /> --%>

<!-- divideDiscAmtToCharges(this.value,'ip');calculateDiscAmtForBill(this.value,'Ip'); -->
<%-- <label class="">Discount on Total Bill</label> 
<input type="text" id="discountOnBillId" name="<%=DISCOUNT_ON_BILL %>" 
	onblur="calculateRsDisOnBill(this.value);"
	validate="Discount On Bill,float,no" maxlength="5" value="0.00" />
	<label 	class="smallAuto">(%)</label>
<label style="display: none;">Bill Charity Amount</label> <input style="display: none;"
	type="text" id="discountAmtBillId" name="discountAmtBillId" value=""
	class="" onblur="calculateDiscPercentForOpService(this.value,'ip');"
	validate="Bill Charity Amount,float,no" maxlength="5" />
	<script type="text/javascript">
	var authorizerArr = new Array();
	</script>
<label class="">Discount On Total Bill</label>
<input type="text" id="discountOnBIllRsId" name="discountOnBIllRsId"  onblur="calculatePerDisOnBill(this.value);" value="0.00"/> 
<label 	class="smallAuto">(Rs)</label> --%>
<%-- <label class=""><span id="mandatorySignId"
	style="display: none;">*</span> Authorizer</label> <select
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
</select>  --%>
<label>Round Off</label> 
<input type="text" id="roundId"	name="<%=ROUND_OF_VALUE %>"  readonly="readonly" />

<label>Payable Amount</label>
<input type="text" id="totalPayId" name="<%=TOTAL_NET_AMOUNT%>" value=""  />

<input type="hidden" value="<%=pastDue%>" class="readOnly" id="balanceAmount" name="balanceAmount" readonly="readonly" /> 

 <div class="clear"></div>
			
<label><input type="checkbox" id="advAdjCheckId" name="" value="" class="radiobutMargin" onclick="displayOPAdvance(this);" /> Adjust Against Credit</label>

<div id="advanceadjistdiv" style="display:none;">		
<input type="text" id="adjusetCreditId" name="adjusetCreditId" value="0.00"	onblur="adjustAmt(this.value);"	 validate="Discount On Bill,float,no" maxlength="5" />
<label>Available Credit Balance</label>
<input type="text" id="avAdvAmtId" name="avAdvAmtId" readonly="readonly" value="<%=pastDue %>" maxlength="9" />
		
	<%-- <% BigDecimal payableAmt = new BigDecimal(0);
	if(tempOpBillHeader.getNetAmt() != null){
		totalNetAmt = tempOpBillHeader.getNetAmt();
	}
	if(!pastDue.equals("") && !pastDue.substring(0,1).equals("-"))
		payableAmt=totalNetAmt.add(new BigDecimal(pastDue.toString()));
	else if(!pastDue.equals("") && pastDue.substring(0,1).equals("-"))
		payableAmt=totalNetAmt;>
 --%>
<input type="hidden" id="payableAmtId" name="<%=PAYABLE_AMOUNT %>" value="" class="readOnly" readOnly /> 
<label>Ballance to Be Paid</label>
<input type="text" id="balToBePiadId" name="balToBePiadId" value="" class="readOnly" readonly />
<!-- <input type="text" id="balToBePiadId" name="balToBePiadId" value="" class="" /> -->
</div>	

<%-- <label>Available Credit Balance</label>
<input type="text" id="avAdvAmtId" name="avAdvAmtId"
			class="" value="<%=pastDue %>" 
			maxlength="9" />
<input type="checkbox" id="advAdjCheckId" class="radioCheck" value=""
			onclick="displayIpAdvance(this);" /> <label
			class="auto">Adjust Against Credit</label>
<input type="text" id="adjusetCreditId" name="adjusetCreditId"  value=""
		onblur="adjustAmt(this.value);"	 validate="Discount On Bill,float,no" maxlength="5" />
<div class="clear"></div>
<label>Ballance to Be Paid</label>
<input type="text" id="balToBePiadId" name="balToBePiadId" value=""  /> --%>

<label>Remarks</label>
<textarea rows="4" cols="50" class="textareaMediua">
</textarea>
<div class="clear"></div>

<script type="text/javascript">
var bankArray=new Array();
</script>

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
			id="amt<%=i %>" value="<%=payment %>" validate="Amount,string,no" maxlength="9"
			readonly="readonly"
			onblur="if(validateAmountIp(this.value,<%=i %>)){calculateOutstandingAmtIp();}" />
			<input type="hidden" name="amtHidden<%=i%>"
			id="amtHidden<%=i %>" value="" validate="Amount,string,no" maxlength="9"
			readonly="readonly"/></td>
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
			onclick="addRowForPayment('ipBilling');" /></td>

	</tr>
</table>
</div>
<input type="button" name="delete" class="buttonDel" onclick="removeRowForPayment();" />

<div class="clear"></div>
<div class="paddingTop5"></div>

<label>Amount Tendred</label> <input type="text" class=""  id="actualColAmtId"
	onblur="amountToBeReturn();"
	name="<%=PAYABLE_AMOUNT %>" value=""  />
<label>Balaance To Be Retrunred</label><input type="text" id="balToBeRetrunId" name="balToBeRetrunId" class="" onblur="totalAdvCreditIp(this.value)"/>
<label>Remainig Credit</label><input type="text" id="remCreditId" name="remCreditId" class="" readonly="readonly"  onblur="totalAdvValueIp(this.value);"/>
<div class="clear"></div>

 
<label class="heightAuto"><input type="checkbox" id="charitYId" class="radiobutMargin" value="" onclick="transferCharity(this);" /> Refund Transfer To Charity</label>
<input type="text" id="charityTransferId" name="charityTransferId" class="" value=""
		onblur="onUpdateCharityCreditIp(this.value);"	 validate="Discount On Bill,float,no" maxlength="5" />
<label>Charity Name</label>
<select name="charityIdd" id="charityIdd" validate="Charity Name,string,no">
<option value="0">--Select--</option>
<%
if(masCharityList!=null && masCharityList.size()>0){
	for(MasCharityType charityy:masCharityList){ %>
	<option value="<%=charityy.getId() %>"><%=charityy.getCharityTypeName().trim() %></option>
	<%}} %>
</select>
</div></div>
<div class="clear"></div>
<input type="hidden" value="<%=registrationType %>"
	name="registrationType" /> <input type="hidden" value="1"
	name="hiddenValuePayment" id="hiddenValuePayment" />
<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
<div class="clear"></div>
<input type="button" class="button" value="Submit" name="Submit11"
	tabindex="1"
	onclick="if(checkFilledRow()){if(checkDiscount() && validateFieldsOnSubmit()){submitForm('ipBilling','billing?method=submitChargeSlipDetails','checkPayAmount','validateChequeAndCreditCardDate');}}"
	align="right" /> <input type="button" class="buttonHighlight"
	value="Reset" onclick="form.reset();resetAjaxValueForBilling();" />
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<% }else{%> No Record Found!! <%} %>
<div id="cardDiv"></div>
<script type="text/javascript">


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
			document.getElementById('outstandingId').value = abc;
				
			if(document.getElementById('payableAmtId') != null)
				document.getElementById('payableAmtId').value = amt;
		
			//document.getElementById('amt'+inc).value = amt;
		
			if(document.getElementById('actualColAmtId') != null)
				document.getElementById('actualColAmtId').value = amt;
				
			document.getElementById('totalDisId').value = "0";
		}
	}
	
	else
	{
	    if(validateChargeCodeForBillingAutoComplete(chargeCode, inc,'ip'))
	    {
	    	submitProtoAjaxWithDivNameForBilling('ipBilling','/hms/hms/opBilling?method=fillChargeCode&charge'+inc+'='+encodeURIComponent(chargeCode)+'&rowVal='+inc+'&hin=<%=hinId%>&type=ip','schemeList='+document.getElementById('schemeId1').value,'rateVal'+inc);
	    }
	}
}





function addRow(){
	var tbl = document.getElementById('chargeDetailsTable');
	var lastRow = tbl.rows.length;
	
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;
	
	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.name='selectedChrage';
	e0.value=(iteration);
	cell0.appendChild(e0);
	
	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.onblur=function(){
				if(validateChargeCodeForBillingAutoComplete(this.value, iteration,'ip')){submitProtoAjaxWithDivNameForBilling('ipBilling','/hms/hms/opBilling?method=fillChargeCode&charge'+iteration+'='+encodeURIComponent(this.value)+'&rowVal='+iteration+'&hin=<%=hinId%>&type=ip&schemeList='+document.getElementById('schemeId1').value,'rateVal'+iteration);}
				
			  };
	e1.name = 'chargeCode'+ (iteration);
	e1.id = 'chargeCode'+ (iteration);
	e1.tabIndex="1";
	
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
   	cell1.appendChild(e1);
   	e1.focus();
    cell1.appendChild(newdiv);
	
	new Ajax.Autocompleter('chargeCode'+iteration,'ac2update'+iteration,'billing?method=getChargeCode',{parameters:'requiredField=chargeCode'+iteration});
	    
	    
	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=QUANTITY%>'+ (iteration);
	e2.id = 'qty'+(iteration)
	e2.readOnly = true;
	e2.size='5';
	e2.onblur= function(){
					if(validateQtyForBilling(this.value,this.id,iteration)){calculateNetAmount(iteration);calculateTotalAmtForIp();};
					};
	cell2.appendChild(e2);
	
	
	var cell3 = row.insertCell(3);
	cell3.id='rateVal'+(iteration);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=RATE%>'+ (iteration);
	e3.readOnly = false;
	e3.size='12';
	e3.id='rate'+(iteration);
	cell3.appendChild(e3); 
	
	var cell4 = row.insertCell(4);
	cell4.style.display="none";
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=STANDARD_DEDUCTION%>'+ (iteration);
	e4.readOnly = true;
	e4.size='12';
	e4.id='standardDeductionId'+(iteration);
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
	e6.onblur = function(){
					if(checkDiscountAmt((iteration))){calculateDiscountAmt((iteration));calculateNetAmount(iteration);calculateTotalAmtForIp()};
				};
	e6.size = '10';
	e6.disabled = "disabled" ;
	e6.maxLength = '3';
	cell6.appendChild(e6); 
	
	var cell7 = row.insertCell(7);
	var e7 = document.createElement('input');
	e7.type = 'text';
	e7.name='<%=DISCOUNT%>'+ (iteration);
	e7.id='disamount'+(iteration);
	e7.disabled="disabled" ;
	e7.maxLength = '7';
	e7.size = '10';
	e7.onblur = function(){
					if(checkDiscountAmt((iteration))){calculateNetAmount(iteration);calculateTotalAmtForIp()};
				};
	cell7.appendChild(e7); 
	
	var cell8 = row.insertCell(8);
	var e8= document.createElement('input');
	e8.type = 'text';
	e8.name='<%=PROPORTIONAL_DISCOUNT%>'+ (iteration);
	e8.id='prprtnlDis'+(iteration);
	e8.readOnly = true;
	e8.size = '10';
	cell8.appendChild(e8);
	
	
	var cell8 = row.insertCell(9);
	var e8 = document.createElement('input');
	e8.type = 'text';
	e8.name='<%=NET_AMOUNT%>'+ (iteration);
	e8.id='netamount'+(iteration);
	e8.readOnly = true;
	e8.size = '10';
	cell8.appendChild(e8); 
	
	var cell9 = row.insertCell(10);
	cell9.style.display="none";
	var e9 = document.createElement('input');
	e9.type = 'checkbox';
	e9.name='printReq'+ (iteration);
	e9.id='printReq'+(iteration);
	e9.disabled = true;
	e9.onclick = function(){
			getOldAdNo(iteration);
	}
	cell9.appendChild(e9); 
	
	var cell10 = row.insertCell(11);
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
	var tbl = document.getElementById('chargeDetailsTable');
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
			calculateTotalAmtForIp();
		}
	}
}


function removeRowForPayment()
{
	var tbl = document.getElementById('paymentDetails');
	var tblRows  = tbl.getElementsByTagName("tr");
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	         
	
	for(counter=0;counter<document.getElementsByName('selectedPayMode').length;counter++)
	{
		if (document.getElementsByName('selectedPayMode')[counter].checked == true) 
		{
			tbl.deleteRow(counter+1);
			calculateOutstandingAmt();
		}
	}
}

function checkPayAmount(){
	
	/* document.getElementById('amt1').onblur(); 
	document.getElementById('receivedAmtId').onblur();
	document.getElementById('balToBeRetrunId').onblur(); */	
	var len = document.getElementById('hiddenValuePayment').value;
	var totalAmt = 0;
	var amt = 0;
	for(var i=1; i<=len; i++){
		if(document.getElementById('amt'+i))
			amt = parseFloat(amt)+parseFloat(document.getElementById('amt'+i).value);
	
	}
	totalAmt = document.getElementById('totalNetId').value;
	
	if(document.getElementById('amt1').value != ""){
		/* if(parseFloat(amt) > parseFloat(totalAmt)){
			alert("Payment Amount should not be greater than Net Amount.");
			return false;
		}else{ */
			return true;
		/* } */
	}else{
			return true;
	}
}
//document.getElementById('chargeCode1').focus();
for(var i=1; i<=document.getElementById('hiddenValueCharge').value; i++)
{
	if(document.getElementById('amount'+i) != null)
	{
		document.getElementById("chargeCode"+i).onblur();		
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
 //submitProtoAjaxWithDivName('ipBilling','/hms/hms/billingMaster?method=listScheme&type=ip','schemeId'); 
 
submitProtoAjaxWithDivName('ipBilling','/hms/hms/billingMaster?method=listScheme&type=ip','schemeDiv');

var container12 = document.getElementById ("schemeDiv");
 if (container12.addEventListener) {
	 container12.addEventListener ('DOMSubtreeModified', updateDiscountByScheme, false);
 }
function diplayPayment(obj)
{
	if(obj == "P"){
		var payableAmt=document.getElementById("totalAmtId").value;
		document.getElementById("payableAmtId").value=payableAmt;
		document.getElementById("paymentDiv").disabled = false;
		document.getElementById("paymentDiv").style.display = 'block';
		document.getElementById("wAmtId").disabled = true;
		document.getElementById("wAmtId").style.display = 'none';
		document.getElementById("ostAmtId").disabled = true;
		document.getElementById("ostAmtId").style.display = 'none';
		document.getElementById("advAdjCheckId").disabled = false;
		document.getElementById("advAdjCheckId").style.display = 'block';
		
	}
	else if(obj == "W"){
        var payableAmt=document.getElementById("payableAmtId").value;
		document.getElementById("paymentDiv").disabled = true;
		document.getElementById("paymentDiv").style.display = 'none';
		document.getElementById("wAmtId").disabled = false;
		document.getElementById("wAmtId").style.display = 'block';
		document.getElementById("ostAmtId").disabled = true;
		document.getElementById("ostAmtId").style.display = 'none';
		document.getElementById("advAdjCheckId").disabled = true;
		document.getElementById("advAdjCheckId").style.display = 'none';
		document.getElementById("waiveAmtId").value=payableAmt;
	}
	else if(obj == "PL"){
		var payableAmt=document.getElementById("payableAmtId").value;
		document.getElementById("paymentDiv").disabled = true;
		document.getElementById("paymentDiv").style.display = 'none';
		document.getElementById("wAmtId").disabled = true;
		document.getElementById("wAmtId").style.display = 'none';
		document.getElementById("ostAmtId").disabled = false;
		document.getElementById("ostAmtId").style.display = 'block';
		document.getElementById("advAdjCheckId").disabled = true;
		document.getElementById("advAdjCheckId").style.display = 'none';
		document.getElementById("outstadAmtId").value=payableAmt;
	}
}
function calcluateAmt(value)
{
	  var billAmt=document.getElementById("totalAmtId").value;
	 var waveAmt=document.getElementById("waiveAmtId").value;
	  var payAmt=document.getElementById("payableAmtId").value;
	  
		document.getElementById("totalPayId").value=parseFloat(billAmt)-parseFloat(waveAmt);   
}
function calcluateOstAmt(value)
{
	  var billAmt=document.getElementById("totalAmtId").value;
	 var osAmt=document.getElementById("outstadAmtId").value;
	  var payAmt=document.getElementById("payableAmtId").value;
		document.getElementById("totalPayId").value=parseFloat(billAmt)-parseFloat(osAmt);
}
</script>
</form>








