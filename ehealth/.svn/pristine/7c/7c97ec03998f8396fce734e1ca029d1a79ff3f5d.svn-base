
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>

<script>
var rowId=undefined;
var status;
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
	function cheackBeforeSumit(){

	var hospital=document.hospitaParam.DA.value;
	if(hospital==""||hospital=="0"){
	alert("Pls Select Hospital..");
	return false;
	}
	var city=document.hospitaParam.<%=CITY %>.value;
	if(city==""||city=="0"){
	alert("Pls Select City..");
	return false;
	}
	var state=document.hospitaParam.<%=STATE_ID %>.value;
	if(state==""||state=="0"){
	alert("Pls Select State..");
	return false;
	}
	var country=document.hospitaParam.<%=COUNTRY_ID %>.value;
	if(country==""||country=="0"){
	alert("Pls Select country..");
	return false;
	}
	var currency=document.hospitaParam.<%=CURRENCY_ID %>.value;
	if(currency==""||currency=="0"){
	alert("Pls Select currency..");
	return false;
	}
	return true;

	}
</script>
<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
String message="";
List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
List<MasCountry> countryList = new ArrayList<MasCountry>();
List<MasState> stateList = new ArrayList<MasState>();
List<HospitalParameters> hospitalParamList = new ArrayList<HospitalParameters>();
List<MasHospital> hospitalList = new ArrayList<MasHospital>();
List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
List<HospitalParameters> existingHospParamList = new ArrayList<HospitalParameters>();
int masHospitalId=0;

HospitalParameters hospitalParameters=new HospitalParameters();
if(map.get("masHospitalId") != null){
	masHospitalId= (Integer)map.get("masHospitalId");
}
if(map.get("masDepartmentList") != null){
	masDepartmentList= (List)map.get("masDepartmentList");
}
if(map.get("existingHospParamList") != null){
	existingHospParamList= (List)map.get("existingHospParamList");
}
if(map.get("countryList") != null){
	countryList= (List<MasCountry>)map.get("countryList");
}
if(map.get("stateList") != null){
	stateList= (List<MasState>)map.get("stateList");
}
if(map.get("hospitalParamList") != null){
	hospitalParamList= (List<HospitalParameters>)map.get("hospitalParamList");
}
List<MasDistrict> districtList = new ArrayList<MasDistrict>();
if(map.get("districtList") != null){
	districtList= (List<MasDistrict>)map.get("districtList");
}
if(map.get("hospitalList") != null){
	hospitalList= (List<MasHospital>)map.get("hospitalList");
}
if(map.get("currencyList") != null){
	currencyList= (List<MasCurrency>)map.get("currencyList");
}
if(map.get("message")!=null){
	message=(String)map.get("message");
}

String address="";
String eMail="";
String url="";
String cuurrentUnit="";
String cstNumber="";
String lstNumber="";
String registrationNumber="";
String pinCode="";
String stdCode="";
String phoneNumber="";
String faxNumber="";
String mobileNumber="";
String gramophoneNumber="";

int opOnAcct=0;
int ipPayType=0;
int opPayType=0;
int includeSt=0;
int provDiagMust=0;
int billPrintType=0;
int allowRegFee=0;
int allowRefund=0;
int marqueeText=0;
int LastChangedDate=0;

int city=0;

%>
<script type="text/javascript">
function getHospitalDetails(val){
if(val=="0"){
alert("Pls select hospital");
return false;
}

submitForm('hospitaParam','/hms/eha/sysParam?method=getHospitalDetails&DA='+val+'')
}

</script>
<%@page import="jkt.hms.masters.business.HospitalParameters"%>
<div class="titleBg">
<h2>Hospital Brief</h2>
</div>
<h4><span><%=message %></span></h4>
<form name="hospitaParam" method="post"><!-- <textarea name="textarea" class="large" readonly="readonly"></textarea>-->
<div class="Block">
<h4>Location</h4>
<%--<label class="medium">Hospital ID <span>*</span> </label>
<input name="<%=HOSPITAL_ID %>" type="text" class="" /> --%> <label><span>*</span>Hospital
Name </label> <% if(masHospitalId!=0){%> <select name="DA"
	onchange="getHospitalDetails(this.value)" validate="Hospital,metachar,yes">
	<option value="0">Select</option>
	<%
 for (MasHospital masHospital : hospitalList)
 {
	 if(masHospitalId==masHospital.getId()){
		 %>
	<option value="<%=masHospital.getId() %>" selected="selected"><%=masHospital.getHospitalName()%></option>
	<%}else{ %>
	<option value="<%=masHospital.getId() %>"><%=masHospital.getHospitalName()%></option>
	<% }}%>

</select> <%}else{ %> <select name="DA" onchange="getHospitalDetails(this.value)"  >
	<option value="0">Select</option>
	<%
 for (MasHospital masHospital : hospitalList)
				{
		if(hospitalParamList!=null&&hospitalParamList.size()>0)
		{
		if(hospitalParamList.get(0).getHospital().getId().equals(masHospital.getId()))
		{
		%>
	<option value="<%=masHospital.getId()%>" selected="selected"><%=masHospital.getHospitalName()%></option>
	<%}else{%>
	<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>
	<% }
		}else
		{%>
	<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>
	<%}}%>
</select> <%} %> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {%> <input
	type="hidden" name="hospitalParamId" validate="hospitalParamId,int,no"
	value="<%=hospitalParamList.get(0).getId() %>" /> <%}else{ %> <input
	type="hidden" name="hospitalParamId" value="" validate="hospitalParamId,int,no"/> <%} %> <label>Address</label>
<%if(hospitalParamList!=null&&hospitalParamList.size()>0) {%> <textarea class="textareaMediua"
	name="<%=ADDRESS %>" cols="0" rows="0"><%=hospitalParamList.get(0).getAddressLine1() %></textarea>
<%}else{ %> <textarea name="<%=ADDRESS %>" cols="0" rows="0"></textarea> <%} %>
<label>Country</label> <select name="<%=COUNTRY_ID %>" >
	<option value="0">Select</option>
	<%
			 	for (MasCountry masCountry : countryList)
				{
			 		if(hospitalParamList!=null&&hospitalParamList.size()>0) {
				if((masCountry.getId()).equals(hospitalParamList.get(0).getCountry().getId()))

		 		{%>
	<option value="<%=masCountry.getId()%>" selected="selected"><%=masCountry.getCountryName()%></option>
	<%}
			else{
			%>

	<option value="<%=masCountry.getId()%>"><%=masCountry.getCountryName()%></option>
	<%}}else{%>
	<option value="<%=masCountry.getId()%>"><%=masCountry.getCountryName()%></option>
	<%}} %>
</select>
<div class="clear"></div>
<label>State/ Province</label> <select name="<%=STATE_ID %>" validate="State,metachar,no">
	<option value="0">Select</option>
	<%
			 	for (MasState masState : stateList)
				{
			 		if(hospitalParamList!=null&&hospitalParamList.size()>0) {
			 	if((masState.getId()).equals(hospitalParamList.get(0).getState().getId()))

		 		{%>
	<option value="<%=masState.getId()%>" selected="selected"><%=masState.getStateName()%></option>
	<%}
				else{
				%>
	<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
	<%}}else{%>
	<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
	<%}} %>

</select> <label>City</label> <select name="<%=CITY %>" validate="City,metachar,no">
	<option value="0">Select</option>
	<%
			 	for (MasDistrict masDistrict : districtList)
				{
			 		if(hospitalParamList!=null&&hospitalParamList.size()>0)
			 		{
						if((masDistrict.getId()).equals(hospitalParamList.get(0).getCity().getId()))

		 				{

		 		%>
	<option value="<%=masDistrict.getId()%>" selected="selected"><%=masDistrict.getDistrictName()%></option>
	<%}
						else{

						%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
	<%}
						}else{%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
	<%}} %>
</select> <label>Pin Code </label> <%	if(hospitalParamList!=null&&hospitalParamList.size()>0) { %>
<input name="<%=PINCODE %>" type="text"
	value="<%=hospitalParamList.get(0).getPinCode() %>" validate="PinCode,int,no"/> <%}else{ %> <input
	name="<%=PINCODE %>" type="text" value="" validate="PinCode,int,no"/> <%} %>
</div>
<div class="Block">
<h4>Settings</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label class="auto">Allow OP on Account
? </label> <%	if(hospitalParamList!=null&&hospitalParamList.size()>0) {
if(hospitalParamList.get(0).getOpOnAcct().equals(new Integer(1)))
{%> <input name="<%=OP_ON_ACCT %>" type="checkbox" checked="checked"
	class="radioCheck" /> <%}else if(hospitalParamList.get(0).getOpOnAcct().equals(new Integer(0))){%>
<input name="<%=OP_ON_ACCT %>" type="checkbox" class="radioCheck" /> <%}}else{ %>
<input name="<%=OP_ON_ACCT %>" type="checkbox" class="radioCheck" /> <%} %>
<label>Allow Detail Bill Printing </label> <%	if(hospitalParamList!=null&&hospitalParamList.size()>0) {
if(hospitalParamList.get(0).getBillPrintType().equals(new Integer(1)))
{%> <input name="<%=BILL_PRINT_TYPE %>" type="checkbox"
	checked="checked" class="radioCheck" /> <%}else if(hospitalParamList.get(0).getBillPrintType().equals(new Integer(0))){%>
<input name="<%=BILL_PRINT_TYPE %>" type="checkbox" class="radioCheck" />
<%}}else{ %> <input name="<%=BILL_PRINT_TYPE %>" type="checkbox"
	class="radioCheck" /> <%}%> <label class="auto" style="padding:0px 12px 0px 5px;">Provisional Diagnosis Mandatory </label> <%	if(hospitalParamList!=null&&hospitalParamList.size()>0) {
if(hospitalParamList.get(0).getProvDiagMust().equals(new Integer(1)))
{%> <input name="<%=PROVISIONAL_DIAG %>" type="checkbox"
	checked="checked" class="radioCheck" /> <%}else if(hospitalParamList.get(0).getProvDiagMust().equals(new Integer(0))){%>
<input name="<%=PROVISIONAL_DIAG %>" type="checkbox" class="radioCheck" />
<%} }else{%> <input name="<%=PROVISIONAL_DIAG %>" type="checkbox"
	class="radioCheck" /> <%} %>
<div class="clear"></div>
<label class="auto" style="padding:0px 12px 0px 5px;">Allow Registration / Re-visit
Free? </label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {

if(hospitalParamList.get(0).getAllowRegFee().equals(new Integer(1)))
{%> <input name="<%=ALLOW_REG_FEE %>" type="checkbox" checked="checked"
	class="radioCheck" /> <%}else if(hospitalParamList.get(0).getOpOnAcct().equals(new Integer(0))){%>
<input name="<%=ALLOW_REG_FEE %>" type="checkbox" class="radioCheck" />
<%} }else{%> <input name="<%=ALLOW_REG_FEE %>" type="checkbox"
	class="radioCheck" /> <%} %> <label>Allow Advance for OP</label> <%	if(hospitalParamList!=null&&hospitalParamList.size()>0) {
	if(hospitalParamList.get(0).getAllowOpAdvance() != null){
if(hospitalParamList.get(0).getAllowOpAdvance().equals(new Integer(1)))
{%> <input name="allowOpAdvance" type="checkbox" checked="checked"
	class="radioCheck" /> <%}else if(hospitalParamList.get(0).getAllowOpAdvance().equals(new Integer(0))){%>
<input name="allowOpAdvance" type="checkbox" class="radioCheck" /> <%}}else{
	%> <input name="allowOpAdvance" type="checkbox" class="radioCheck" />
<%}}else{ %> <input name="allowOpAdvance" type="checkbox"
	class="radioCheck" /> <%}%>
<label class="auto" style="padding:0px 12px 0px 5px;">Allow Discharge without Clearance </label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {
if(hospitalParamList.get(0).getAllowDischrgWithoutClrnc().equals(new Integer(1)))
{%> <input name="<%=ALLOW_DISCHRG_WITHOUT_CLRNC %>" type="checkbox"
	checked="checked" class="radioCheck" /> <%}else if(hospitalParamList.get(0).getAllowDischrgWithoutClrnc().equals(new Integer(0))){%>
<input name="<%=ALLOW_DISCHRG_WITHOUT_CLRNC %>" type="checkbox"
	class="radioCheck" /> <%}}else{ %> <input
	name="<%=ALLOW_DISCHRG_WITHOUT_CLRNC %>" type="checkbox"
	class="radioCheck" /> <%} %> 
<div class="clear"></div>	
<label>Include VAT in Bills </label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {
if(hospitalParamList.get(0).getIncludeSt().equals(new Integer(1)))
{%> <input name="<%=INCLUDE_ST %>" type="checkbox" checked="checked"
	class="radioCheck" /> <%}else if(hospitalParamList.get(0).getIncludeSt().equals(new Integer(0))){%>
<input name="<%=INCLUDE_ST %>" type="checkbox" class="radioCheck" /> <%}}else{ %>
<input name="<%=INCLUDE_ST %>" type="checkbox" class="radioCheck" /> <%} %>

<!--
* Code For Block and Post office dropdown restrict on registration page and direct save district name as in block and postoffice
* Code by Mukesh Narayan Singh
* Date 12 July 2010
 --> <label>Block Required</label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {
if(hospitalParamList.get(0).getBlock()!=null){
	if(hospitalParamList.get(0).getBlock().equalsIgnoreCase("Y"))
{%> <input name="<%=BLOCK %>" type="checkbox"
	checked="checked" class="radioCheck" /> <%}else if(hospitalParamList.get(0).getBlock().equalsIgnoreCase("N")){%>
<input name="<%=BLOCK %>" type="checkbox"
	class="radioCheck" /> <%}}else{ %> <input
	name="<%=BLOCK %>" type="checkbox" class="radioCheck" />
<%}
}else{
	%>
	<input
	name="<%=BLOCK %>" type="checkbox" class="radioCheck" />
	<%
}%>


<!--
* Code For Post office dropdown restrict on registration page and direct save block name as post office
* Code by Mukesh Narayan Singh
* Date 12 July 2010
 --> <label>Post Office Required</label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {
if(hospitalParamList.get(0).getPostOffice()!=null){
	if(hospitalParamList.get(0).getPostOffice().equalsIgnoreCase("Y"))
{%> <input name="<%=POST_OFFICE %>" type="checkbox"
	checked="checked" class="radioCheck" /> <%}else if(hospitalParamList.get(0).getPostOffice().equalsIgnoreCase("N")){%>
<input name="<%=POST_OFFICE %>" type="checkbox"
	class="radioCheck" /> <%}}else{ %> <input
	name="<%=POST_OFFICE %>" type="checkbox" class="radioCheck" />
<%}
}else{
	%>
	<input
	name="<%=POST_OFFICE %>" type="checkbox" class="radioCheck" />
	<%
}%>

<div class="clear"></div>

<label class="auto" style="padding:0px 12px 0px 5px;">Dept. for Purchase Order Code VBCH Required</label>
<select name="<%=PURCHASE_ORDER_CODE_VBCH%>">
<option value="0">Select</option>
<%if(masDepartmentList.size()>0) {
	for(MasDepartment masDepartment:masDepartmentList){
		if(hospitalParamList!=null&&hospitalParamList.size()>0)
		{
		if(hospitalParamList.get(0).getDeptIdStoreCodeVBCH().equals(masDepartment.getId())){
			%>
			<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
			<%
		}else{
			%>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
			<%
		}
		}else{
			%>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
			<%
		}
	}
}%>
</select>
<label class="auto" style="padding:0px 12px 0px 5px;">Dept. for Purchase Order Code RKS Required</label>
<select name="<%=PURCHASE_ORDER_CODE_RKS%>">
<option value="0">Select</option>
<%if(masDepartmentList.size()>0) {
	for(MasDepartment masDepartment:masDepartmentList){
		if(hospitalParamList!=null&&hospitalParamList.size()>0)
		{
		if(hospitalParamList.get(0).getDeptIdStoreCodeRKS().equals(masDepartment.getId())){
			%>
			<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
			<%
		}else{
			%>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
			<%
		}
		}else{
			%>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
			<%
		}

	}
}%>
</select>

<div class="clear"></div>
<label class="auto" style="padding:0px 12px 0px 5px;">Dept. for Purchase Order Code Nursing College Required</label>
<select name="<%=PURCHASE_ORDER_CODE_NURSING_COLLEGE%>">
<option value="0">Select</option>
<%if(masDepartmentList.size()>0) {
	for(MasDepartment masDepartment:masDepartmentList){
		if(hospitalParamList!=null && hospitalParamList.size()>0)
		{
		if(hospitalParamList.get(0).getDeptIdStoreCodeNursingCollege()!=null &&  hospitalParamList.get(0).getDeptIdStoreCodeNursingCollege().equals(masDepartment.getId())){
			%>
			<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
			<%
		}else{
			%>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
			<%
		}
		}else{
			%>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
			<%
		}

	}
}%>
</select>
<div class="clear"></div>
</div>

<div class="paddingTop15"></div>
<h4>Charge Calculation Details</h4>
<div class="clear"></div>
<div class="Block">

<label>Nursing Care Calculation </label>
<%
	if(hospitalParamList!=null && hospitalParamList.size()>0){
	if(hospitalParamList.get(0).getNursingCareCalculation() != null)
	{
		if( hospitalParamList.get(0).getNursingCareCalculation().equals("y"))
		{
%>
			<input name="nursingCareCalculation" type="checkbox" checked="checked" class="radioCheck" />
<%
		}
		else if( hospitalParamList.get(0).getNursingCareCalculation().equals("n") )
		{
%>
			<input name="nursingCareCalculation" type="checkbox" class="radioCheck" />
<%
		}
	}
}
	else
	{
%>
		<input name="nursingCareCalculation" type="checkbox" class="radioCheck" />
<%
	}
%>

<label>Daily Charge Calculation </label>
<%
if(hospitalParamList!=null && hospitalParamList.size()>0){	
if(hospitalParamList.get(0).getDailyChargeCalculation() != null)
	{
		if(hospitalParamList.get(0).getDailyChargeCalculation().equals("y"))
		{
%>
			<input name="dailyChargeCalculation" type="checkbox" checked="checked" onclick="showOtherFields(this);"
			class="radioCheck" />
<%
		}
		else if(hospitalParamList.get(0).getDailyChargeCalculation().equals("n"))
		{
%>
			<input name="dailyChargeCalculation" type="checkbox" class="radioCheck"  onclick="showOtherFields(this);"/>
<%
		}
	}
}else
	{
%>
		<input name="dailyChargeCalculation" type="checkbox" class="radioCheck"  onclick="showOtherFields(this);"/>
<%
	}
%>

<%
	if(hospitalParamList!=null && hospitalParamList.size()>0)
	{
		if(hospitalParamList.get(0).getChargeCalculationType() != null && hospitalParamList.get(0).getChargeCalculationType().equals("auto") )
		{
%>
		<div id="dtDiv">
		<label class="auto">Auto</label>
		<input type="radio" name="calcType" id="calcType" value="auto" class="radioCheck" checked="checked" onclick="showTimeField(this.value);"/>
		<label class="auto">Manual</label>
		<input type="radio" name="calcType" id="calcType" value="manual" class="radioCheck" onclick="showTimeField(this.value);"/>
		</div>
<%
		}
		else if(hospitalParamList.get(0).getChargeCalculationType() != null && hospitalParamList.get(0).getChargeCalculationType().equals("manual"))
		{
%>
		<div id="dtDiv">
		<label class="auto">Auto</label>
		<input type="radio" name="calcType" id="calcType" value="auto" class="radioCheck" onclick="showTimeField(this.value);"/>
		<label class="auto">Manual</label>
		<input type="radio" name="calcType" id="calcType" value="manual" class="radioCheck" checked="checked" onclick="showTimeField(this.value);"/>
		</div>
<%
		}
		else
		{
%>
			<div id="dtDiv" style="display: none;">
			<label class="auto">Auto</label>
			<input type="radio" name="calcType" id="calcType" value="auto" class="radioCheck" onclick="showTimeField(this.value);"/>
			<label class="auto">Manual</label>
			<input type="radio" name="calcType" id="calcType" value="manual" class="radioCheck" onclick="showTimeField(this.value);"/>
			</div>
<%
		}
	}
	else
	{
%>
		<div id="dtDiv" style="display: none;">
		<label class="auto">Auto</label>
		<input type="radio" name="calcType" id="calcType" value="auto" class="radioCheck" onclick="showTimeField(this.value);"/>
		<label class="auto">Manual</label>
		<input type="radio" name="calcType" id="calcType" value="manual" class="radioCheck" onclick="showTimeField(this.value);"/>
		</div>
<%
	}
%>

<%
	if(hospitalParamList!=null&&hospitalParamList.size()>0)
	{
		if(hospitalParamList.get(0).getCalculationTime()!=null)
		{
%>
		<div id="timeDiv" style="display: none;">
		<label>Time</label>
		<input type="text" name="calculationTime" id="calculationTime" value="<%=hospitalParamList.get(0).getCalculationTime() %>" class="date"/>
		</div>
<%
		}
		else
		{
%>
		<div id="timeDiv" style="display: none;">
		<label>Time</label>
		<input type="text" name="calculationTime" id="calculationTime" value="" class="date"/>
		</div>
<%
		}
	}
	else
	{
%>
		<div id="timeDiv" style="display: none;">
		<label>Time</label>
		<input type="text" name="calculationTime" id="calculationTime" value="" class="date"/>
		</div>
<%
	}
%>
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Contacts</h4>
<div class="clear"></div>
<div class="Block"><label>STD Code </label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {%>
<input name="<%=STD_CODE %>" type="text"
	value="<%=hospitalParamList.get(0).getStdCode() %>"  /> <%}else {%> <input
	name="<%=STD_CODE %>" type="text" value=""  /> <%} %> <label>Phone
No.</label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {%> <input
	name="<%=PHONE_NO %>" type="text"
	value="<%=hospitalParamList.get(0).getPhoneNumber() %>" /> <%} else{%> <input
	name="<%=PHONE_NO %>" type="text" value="" /> <%} %> <label>Mobile
No.</label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {%> <input
	name="<%=MOBILE_NO %>" type="text"
	value="<%=hospitalParamList.get(0).getMobileNumber() %>"  /> <%}else{ %>
<input name="<%=MOBILE_NO %>" type="text" value=""  /> <%} %>
<div class="clear"></div>
<label>Fax No.</label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {%>
<input name="<%=FAX_NO %>" type="text"
	value="<%=hospitalParamList.get(0).getFaxNumber() %>"  /> <%}
else{ %> <input name="<%=FAX_NO %>" type="text" value=""  /> <%} %> <label>Gram</label>
<%if(hospitalParamList!=null&&hospitalParamList.size()>0) {%> <input
	name="<%=GRAMOPHONE_NUMBER %>" type="text"
	value="<%=hospitalParamList.get(0).getGramophoneNumber() %>"  /> <%}else{ %>
<input name="<%=GRAMOPHONE_NUMBER %>" type="text" value=""  /> <%}%> <label>E-mail</label>
<%if(hospitalParamList!=null&&hospitalParamList.size()>0) {%> <input
	name="<%=EMAIL_ID %>" type="text"
	value="<%=hospitalParamList.get(0).getEMail() %>"  /> <%}else{ %> <input
	name="<%=EMAIL_ID %>" type="text" value=""  /> <%} %>
<div class="clear"></div>
<label>URL</label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {%>
<input name="<%=URL %>" type="text"
	value="<%=hospitalParamList.get(0).getUrl() %>" /> <%}else{ %> <input
	name="<%=URL %>" type="text" value="" /> <%} %> <label>Registration
No.</label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {%> <input
	name="<%=REGISTRATION_NUMBER %>" type="text"
	value="<%=hospitalParamList.get(0).getRegistrationNumber() %>"  /> <%}else{ %>
<input name="<%=REGISTRATION_NUMBER %>" type="text" value=""  /> <%} %> <label>Registration
Date</label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {
if(hospitalParamList.get(0).getRegistrationDate()!=null){%> <input
	name="<%=REGISTRATION_DATE %>" type="text" readonly="readonly"
	value="<%=HMSUtil.convertDateToStringWithoutTime(hospitalParamList.get(0).getRegistrationDate()) %>"
	class="date" validate="Date,date,no"/> <%}
else{
	%> <input name="<%=REGISTRATION_DATE %>" type="text"
	readonly="readonly" value="" class="date" validate="Date,date,no"/> <%}}
	else{ %> <input name="<%=REGISTRATION_DATE %>" type="text"
	readonly="readonly" value="" class="date" validate="Date,date,no"/> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	id="calToDate"
	onclick="javascript:setdate('',document.hospitaParam.<%=REGISTRATION_DATE  %>,event)" />
<div class="clear"></div>
<label>Currency Unit <span>*</span></label> <select
	name="<%=CURRENCY_ID %>">
	<option value="0">Select</option>
	<%
			 	for (MasCurrency masCurrency : currencyList)
				{
			 		if(hospitalParamList!=null&&hospitalParamList.size()>0){
			if((masCurrency.getId()).equals(hospitalParamList.get(0).getCurrency().getId()))

		 		{

		 		%>
	<option value="<%=masCurrency.getId()%>" selected="selected"><%=masCurrency.getCurrencyName()%></option>
	<%}
			else{

			%>
	<option value="<%=masCurrency.getId()%>"><%=masCurrency.getCurrencyName()%></option>
	<%}}else{%>
	<option value="<%=masCurrency.getId()%>"><%=masCurrency.getCurrencyName()%></option>
	<%} }%>

</select></select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Default Payment Type For</h4>
<div class="clear"></div>
<div class="Block"><label>Out Patient </label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0){
if(hospitalParamList.get(0).getOpPayType().equals(new Integer(1)))
{%> <input name="<%=OP_PAY_TYPE %>" type="radio" value="y"
	checked="checked" class="radioCheck" /> <label class="small">Cash</label>
<input name="<%=OP_PAY_TYPE %>" type="radio" value="n"
	class="radioCheck" /> <label class="small">On Acc. </label> <%}else if(hospitalParamList.get(0).getOpPayType().equals(new Integer(0))){%>

<input name="<%=OP_PAY_TYPE %>" type="radio" value="y"
	class="radioCheck" /> <label class="small">Cash</label> <input
	name="<%=OP_PAY_TYPE %>" type="radio" value="n" checked="checked"
	class="radioCheck" /> <label class="small">On Acc. </label> <%}}else{%>
<input name="<%=OP_PAY_TYPE %>" type="radio" value="y"
	class="radioCheck" /> <label class="small">Cash</label> <input
	name="<%=OP_PAY_TYPE %>" type="radio" value="n" checked="checked"
	class="radioCheck" /> <label class="small">On Acc. </label> <%} %> <label>In
Patient </label> <%if(hospitalParamList!=null&&hospitalParamList.size()>0){
if(hospitalParamList.get(0).getIpPayType().equals(new Integer(1)))
{%> <input name="<%=IP_PAY_TYPE %>" type="radio" value="y"
	checked="checked" class="radioCheck" /> <label class="small">Cash</label>
<input name="<%=IP_PAY_TYPE %>" type="radio" value="n" class="radioCheck" />
	<label class="small">On Acc. </label> <%}else if(hospitalParamList.get(0).getIpPayType().equals(new Integer(0))){%>
<input name="<%=IP_PAY_TYPE %>" type="radio" value="y"
	class="radioCheck" /> <label class="small">Cash</label> <input
	name="<%=IP_PAY_TYPE %>" type="radio" value="n" checked="checked"
	class="radioCheck" /> <label class="small">On Acc. </label> <%}} else{%>
<input name="<%=IP_PAY_TYPE %>" type="radio" value="y"
	class="radioCheck" /> <label class="small">Cash</label> <input
	name="<%=IP_PAY_TYPE %>" type="radio" value="n" checked="checked"
	class="radioCheck" /> <label class="small">On Acc. </label> <%} %>


<div class="clear"></div>
 <label>Diet Scheduling</label>
  <%if(hospitalParamList!=null&&hospitalParamList.size()>0) {
if(hospitalParamList.get(0).getDietScheduling()!=null){
	if(hospitalParamList.get(0).getDietScheduling().equalsIgnoreCase("Y")){%>
<input name="dietScheduling" type="checkbox" checked="checked" class="radioCheck" />
 <%}else if(hospitalParamList.get(0).getDietScheduling().equalsIgnoreCase("N")){%>
<input name="dietScheduling" type="checkbox" class="radioCheck" />
 <%}}else{ %>
  <input name="dietScheduling" type="checkbox" class="radioCheck" />
<%}
}else{
	%>
	<input
	name="dietScheduling" type="checkbox" class="radioCheck" value="y" />
	<%
}%>

<div class="clear"></div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%if(existingHospParamList.size()>0){ %>
<input name="save" type="button" class="button" value="Update" onclick="if(cheackBeforeSumit()){submitForm('hospitaParam','/hms/eha/sysParam?method=submitHospitalParamJsp')}" />
<%}else{ %>
<input name="save" type="button" class="button" value="Save" onclick="if(cheackBeforeSumit()){submitForm('hospitaParam','/hms/eha/sysParam?method=submitHospitalParamJsp')}" />

<%} %>

<!--<input name="save" type="button" class="button" value="Help" />
<input name="save" type="button" class="button" value="Exit" />
-->
</div>
<script type="text/javascript">
function showOtherFields(obj){
	if(obj.checked){
		document.getElementById('dtDiv').style.display = 'block';
	}else{
		document.getElementById('dtDiv').style.display = 'none';
		document.getElementById('timeDiv').style.display = 'none';
		document.getElementById('calculationTime').value = "";
		for(var i=0;i<document.getElementsByName('calcType').length;i++){
			document.getElementsByName('calcType')[i].checked = false;
		}
	}
}

function showTimeField(val){
	if(val == "auto"){
		document.getElementById('timeDiv').style.display = 'block';
	}else{
		document.getElementById('timeDiv').style.display = 'none';
		document.getElementById('calculationTime').value = "";
	}

}
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
