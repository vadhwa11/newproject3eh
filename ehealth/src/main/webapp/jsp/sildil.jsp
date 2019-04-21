
<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
	var icdArray = new Array();
	
	</script>
<script>
	<%
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(date.length()<2){
	date="0"+date;
	}
	%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<script type="text/javascript">
	function openPopupWindow()
	{
	var url="/hms/hms/adt?method=showICDSearchJsp";
	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}
	
	function jsSetIcdData(icd_no)
	{
	document.getElementById("icdCode").value=icd_no;
	document.getElementById("icdCode").focus();
	}
	function changePrint(){
	document.getElementById('printId').style.display = "inline";
	} 
	</script>

<%	String adt ="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	String timeInHHmm="";
	String [] temp = null;
	temp = currentTime.split(":");
	for (int i = 0 ; i < temp.length-1 ; i++) {
	
	timeInHHmm=timeInHHmm+(String)temp[i];
	if(i==0)
	{
	timeInHHmm=timeInHHmm+":";
	}
	
	}
	Map map = new HashMap();
	String includedJsp="";
	if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
	.getResource("adt.properties");
	try {
	properties.load(resourcePath.openStream());
	} catch (Exception e) {
	e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List inPatientDetailList = new ArrayList();
	List<MasIcd> icdNoList = new ArrayList<MasIcd>();
	if(map.get("icdNoList") != null){
	icdNoList = (List<MasIcd>)map.get("icdNoList");
	}
	if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(inPatientDetailList != null)
	{
	inPatientDetailList=(List)map.get("inPatientDetailList");
	}
	
	String userName = "";
	String deptName = "";
	if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	}
	if(map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	
	if(map.get("adt") != null) {
	adt = (String) map.get("adt");
	}
	int deptId=0;
	if(map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}
	String admissionNumber=null;
	int hinId=0;
	int inpatientId=0;
	String patientName= "";
	String status="";
	String tempStr ="";
	if(inPatientDetailList != null)
	{
	
	String consultantName= "";
	String serviceNo=null;
	Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
	hinId=inPatientDetail.getHin().getId();
	inpatientId=inPatientDetail.getId();
	status=inPatientDetail.getConditionStatus();
	//  String patientName=inPatientDetail.getHin().getPFirstName()+inPatientDetail.getHin().getPMiddleName()+inPatientDetail.getHin().getPLastName();
	if(inPatientDetail.getHin().getPFirstName() != null)
	{
	patientName=inPatientDetail.getHin().getPFirstName();
	}
	if(inPatientDetail.getHin().getPMiddleName() != null)
	{
	patientName +=inPatientDetail.getHin().getPMiddleName();
	}
	if(inPatientDetail.getHin().getPLastName() != null)
	{
	patientName +=inPatientDetail.getHin().getPLastName();
	}
	if(inPatientDetail.getDoctor().getFirstName() != null)
	{
	consultantName=inPatientDetail.getDoctor().getFirstName();	
	}
	if(inPatientDetail.getDoctor().getMiddleName() != null)
	{
	consultantName+=inPatientDetail.getDoctor().getMiddleName();
	}
	if(inPatientDetail.getDoctor().getLastName() != null)
	{
	consultantName+=inPatientDetail.getDoctor().getLastName();
	}
	if(inPatientDetail.getHin().getServiceNo() != null && inPatientDetail.getHin().getServiceNo() != "")
	{
	serviceNo= inPatientDetail.getHin().getServiceNo();
	
	
	}
	
	
	MasIcd masIcd=(MasIcd)inPatientDetail.getDiagnosis();
	admissionNumber=inPatientDetail.getAdNo();
	String unitName="";
	String rankName="";
	if(inPatientDetail.getHin().getUnit() != null)
	{
	unitName=inPatientDetail.getHin().getUnit().getUnitName();
	}else{
	unitName="-";
	}
	if(inPatientDetail.getHin().getRank() != null)
	{
	
	rankName=inPatientDetail.getHin().getRank().getRankName();
	}else{
	rankName="-";
	}
	session.setAttribute("admissionNumber",admissionNumber);
	%>



<div class="titleBg">
<h2>SIL/DIL</h2>
</div>
<div class="clear"></div>
<h4><%=deptName%></h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<form name="silDilStatus" method="post" action="">
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><input name="adt" type="hidden"
	value="<%=adt%>"> <label>Patient Name</label> <label
	class="valueMedium"> <%= patientName %></label> <label>IP No.</label> <%if(inPatientDetail.getAdNo() != null){ %>
<input name="<%=AD_NO%>" value="<%=inPatientDetail.getAdNo() %>"
	id="<%=AD_NO%>" type="hidden"> <label class="value"> <%=inPatientDetail.getAdNo() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Ward Name</label> <%if(inPatientDetail.getDepartment() != null){ %>
<label class="value"> <%=inPatientDetail.getDepartment().getDepartmentName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>
<label>Age</label> <%if(inPatientDetail.getAge() != null){ %> <label
	class="valueMedium"> <%=inPatientDetail.getAge() %></label> <%}else{ %> <label
	class="valueMedium">-</label> <%} %> <label>Sex</label> <%if(inPatientDetail.getHin().getSex() != null){ %>
<label class="value"> <%=inPatientDetail.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Consultant</label>
<label class="value"><%=consultantName %></label> <label>Diagnosis</label>
<%
	Set<DischargeIcdCode> set = (Set<DischargeIcdCode>) inPatientDetail
	.getDischargeIcdCodes();
	if (set.size() > 0) {
	int dilStatusId = 0;
	String diagnosisStatus = "";
	
	for (DischargeIcdCode dischargeIcdCode : set) {
	if (dischargeIcdCode.getInpatient().getId() == inPatientDetail.getId()) {
	if (dischargeIcdCode.getId() > dilStatusId) {
	if(dischargeIcdCode.getIcd() !=null){
	diagnosisStatus = ""+ dischargeIcdCode.getIcd().getIcdName();
	dilStatusId = dischargeIcdCode.getId();
	if(dischargeIcdCode.getIcd() !=null)
	tempStr =dischargeIcdCode.getIcd().getIcdName()+"["+dischargeIcdCode.getIcd().getIcdCode()+"]";
	}
	}
	}
	}
	%> <label class="valueAuto"><%=diagnosisStatus%></label> <%
	} else if (inPatientDetail.getDiagnosis() != null) {
	if(inPatientDetail.getDiagnosis() !=null)
	tempStr =inPatientDetail.getDiagnosis().getIcdName()+"["+inPatientDetail.getDiagnosis().getIcdCode()+"]";
	
	%> <label class="valueAuto"><%=inPatientDetail.getDiagnosis().getIcdName() %></label>
<%
	} else {
	%> <label class="valueAuto">-</label> <%
	}
	%>
<div class="clear"></div>
<label>Init Diagnosis</label> <%if(inPatientDetail.getInitDiagnosis() !=null) %>
<label class="valueAuto"><%=inPatientDetail.getInitDiagnosis() %></label>

<div class="clear"></div>

<label>NOK Name</label> <%if((inPatientDetail.getHin().getNextOfKinName() !=null) || !(inPatientDetail.getHin().getNextOfKinName().trim().equals(""))){	%>
<label class="value"> <%=""+inPatientDetail.getHin().getNextOfKinName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>NOK Phone
No.</label> <%if(inPatientDetail.getHin().getNextOfKinPhoneNumber() !=null) {%> <label
	class="value"><%=inPatientDetail.getHin().getNextOfKinPhoneNumber()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>NOK Address</label>
<%if(inPatientDetail.getHin().getNextOfKinAddress() !=null) {%> <label
	class="valueAuto"><%=inPatientDetail.getHin().getNextOfKinAddress()%></label>
<%}else{ %> <label class="valueAuto">-</label> <%} %>

<div class="clear"></div>

<label>NOK Relation</label> <%if(inPatientDetail.getHin().getNextOfKinRelation() !=null) {%>
<label class="value"><%=inPatientDetail.getHin().getNextOfKinRelation().getRelationName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>

<%
	}
	%>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>SIL/DIL:</h4>
<div class="clear"></div>
<div class="cmntable">
<table width="100%" colspan="7" id="tblSample">

	<tr>
		<th>S.No</th>
		<th>Patient Name</th>
		<th width="5%" colspan="2">Date</th>
		<th width="3%">Time</th>
		<th width="6%">Diagnosis</th>
		<th width="6%"></th>
		<th width="1%">SIL</th>
		<th width="1%">DIL</th>
		<th width="1%">NORMAL</th>
		<th width="10%">Condition</th>
		<th width="5%">Placed By</th>
		<th width="5%">NOK</th>
		<th width="10%">Treatment</th>
	</tr>
	<tr>
		<td width="1%">1</td>
		<td width="10%"><%= patientName %></td>
		<td><input type="text" id="mlcDateId" name="date" size="8"
			value="<%=currentDate %>" readonly="readonly" validate="Date,date,no"
			MAXLENGTH="30" /></td>
		<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onclick="javascript:setdate('',document.silDilStatus.date,'event')" />
		</td>


		<td width="10%"><input type="text" align="right"
			name="silDilTime" maxlength="5" value="<%=currentTime %>" size="6" />

		</td>
		<td width="10%"><input type="text" size="8" name="icdCode"
			id="icdCode" onblur="if(getIcdStringSilDil()){fillDiagnosisCombo();}" />
		<IMG SRC="/hms/jsp/images/search.gif" WIDTH="26" HEIGHT="26"
			onClick="javascript:openPopupWindow();"> <input type="text"
			value="<%=tempStr %>" id="icd" name="icd"
			onblur="fillDiagnosisCombo();" size="50" />
		<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('icd','ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'});
	</script></td>
		<td width="10%"><select name="<%=DIAGNOSIS_ID%>" size="3"
			multiple="3" class="list" id="diagnosisId">
			<option value="0">Select</option>
		</select></td>
		<td width="1%" align="center">
		<% if(status.equals("SIL")){ %> <input type="radio" class="radioCheck"
			name="parent" checked="true" value="sil" id="parent1" /> <%}else{ %> <input
			type="radio" class="class=" radioCheck" "   name="parent" value="sil"
			id="parent1" /> <%} %>
		</td>
		<td width="1%">
		<% if(status.equals("DIL")){ %> <input type="radio" align="right"
			class="radioCheck" name="parent" checked="true" value="dil"
			id="parent1" /> <%}else{ %> <input type="radio" align="right"
			class="radioCheck" name="parent" value="dil" id="parent1" /> <%} %>
		</td>
		<td width="1%">
		<% if(status.equals("Normal")){ %> <input type="radio"
			class="radioCheck" name="parent" value="normal" checked="true"
			id="parent" /> <%}else{ %> <input type="radio" class="radioCheck"
			name="parent" value="normal" id="parent" /> <%} %>
		</td>
		<td width="6%"><select name="remarks" id="conditionId"
			class="small">
			<option value="0">Select</option>
			<option value="improved">Improved</option>
			<option value="static">Static</option>
			<option value="critical">Critical</option>
		</select></td>
		<td width="2%"><select id="placedBy" name="placedBy"
			validate="Placed By,num,Yes">
			<option value="">Select</option>
			<% 
	for (MasEmployee  obj : employeeList){
	if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
	
	String doctorMiddleName = "";
	String doctorLastName = "";
	
	doctorMiddleName = obj.getMiddleName();
	
	
	doctorLastName = obj.getLastName();
	
	%>
			<option value="<%=obj.getId()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
			<%  }
	}%>
		</select></td>
		<td width="2%"><select name="nokType" id="nokType" class="small">
			<option value="no">NO</option>
			<option value="yes">Yes</option>

		</select></td>
		<td width="3%"><input type="text" align="right" name="treatment"
			maxlength="250" /></td>
	</tr>

</table>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>SIL/DIL History</h4>
<div class="clear"></div>


<table width="100%" colspan="7" id="tblSample">

	<tr>
		<th width="1%"></th>
		<th width="1%">S.No</th>
		<th width="7%">DATE</th>
		<th width="20%">Diagnosis</th>
		<th width="1%">Patient Condition</th>
		<th width="5%">Condition</th>
		<th width="5%">Treatment</th>
		<th width="5%">NOK</th>

	</tr>

	<%
	int i=1;
	if(map.get("siList") != null)
	{
	List siList=(List)map.get("siList");
	Iterator itr=siList.iterator();
	while(itr.hasNext())
	{
	SilDilStatus silDilStatus=(SilDilStatus)itr.next();
	String nomenclature = "";
	if(silDilStatus.getIcd() !=null){
	nomenclature=silDilStatus.getIcd().getIcdName();
	}
	String patientCondition=silDilStatus.getConditionStatus();
	String remarks=silDilStatus.getRemarks();
	String treatment=silDilStatus.getTreatment();
	String dateOfDiagnosis =HMSUtil.changeDateToddMMyyyy(silDilStatus.getLastChgDate());
	String nok=silDilStatus.getNok();
	String silDilTime=silDilStatus.getLastChgTime();
	if(nok==null)
	{
	nok="-";
	}
	%>


	<tr>
		<td width="1%"><input type="radio" class="radioCheck"
			name="historyId" value="sil" id="historyId" onclick="changePrint();" />
		</td>
		<td width="1%"><%=i %></td>

		<td width="7%"><%=dateOfDiagnosis+"/"+silDilTime %></td>
		<td width="20%"><input readonly="readonly"
			value="<%= nomenclature %>"></td>

		<td width="1%"><%=patientCondition %></td>

		<td width="5%"><%=remarks %></td>
		<td width="5%"><%=treatment %></td>
		<td width="5%"><%=nok %></td>
	</tr>
	<%	
	i++;
	}
	
	}
	%>

</table>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="hdb" value="1" id="hdb" /> <input
	type="hidden" name="inpatientId" value="<%=inpatientId %>"
	id="inpatientId" /> <input type="hidden" name="hinId"
	value="<%=hinId %>" id="hinId" /> <input type="hidden" name="date2"
	value="<%=currentDate %>"> <input type="hidden" name="time"
	value="<%=timeInHHmm%>"> <input type="hidden" name="deptName"
	value="<%=deptName%>"> <input type="hidden" name="deptId"
	value="<%=deptId%>"> <input type="hidden" name="userName"
	value="<%=userName%>"> <input type="button" name="Submit"
	value="Submit" align="right" class="button"
	onClick="if(checkForICD()){submitForm('silDilStatus','/hms/hms/ipd?method=submitSilDilStatus');}" />
<div id="printId" style="display: none";><input type="button"
	name="Submit" value="Print" align="right" class="button"
	onClick="submitForm('silDilStatus','/hms/hms/adt?method=showSiDiReport');" />
</div>

<input type="button" class="button" value="Back" align="right"
	onClick="submitForm('silDilStatus','ipd?method=showPatientListJsp');" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">
	
	
	
	function checkICDCode()
	{
	var icdCode=document.getElementById("icdId").value
	
	if(icdCode == 0)
	{
	alert("Please Select the ICD Code to submit.")
	return false;
	}
	return true;
	}
	
	
	function checkForICD(){
	
	// var diagnosisLength=parseInt(document.getElementById("diagnosisId").length)
	//if(diagnosisLength == 1){
	//  var icd=document.getElementById("icd").value
	//	if(icd != "")
	//	{
	//	    var index1 = icd.lastIndexOf("[");
	//	    var indexForBrandName=index1;
	//	    var index2 = icd.lastIndexOf("]");
	//	    index1++;
	//	    var brandId = icd.substring(index1,index2);
	//	    var indexForBrandName=indexForBrandName--;
	//	    var brandName=icd.substring(0,indexForBrandName);
	
	//   	 if(brandId =="")
	//    {
	//      alert("Please select the correct value for ICD.")
	//    return false;
	//  }
	
	//}else{
	// alert("Please Select the ICD Code to submit.")
	// return false;
	//}
	
	// }
	var msg ="";
	if(document.getElementById("conditionId").value =="0"){
	msg ="Please select Condition \n"
	
	}
	if(document.getElementById("placedBy").value ==""){
	msg = msg + "Please select Placed By"
	
	}
	if(msg ==""){
	return true;
	}else{
	alert(msg);
	return false
	}
	}
	
	function fillDiagnosisCombo() {
	var val =document.getElementById("icd").value
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var id = val.substring(index1,index2);
	if(id !=""){
	obj =document.getElementById('diagnosisId'); 
	obj.length = document.getElementById('diagnosisId').length;
	
	obj.length++;
	obj.options[obj.length-1].value=id
	obj.options[obj.length-1].text=val
	obj.options[obj.length-1].selected=true
	document.getElementById('icd').value =""
	}
	
	}
	function checkRadio(){
	alert(document.getElementsByName('historyId').checked)
	if(document.getElementsByName('historyId').checked == true){ 
	return true;
	}else{
	alert("Please Select radio")
	return false
	}
	}
	
	
	</script>




