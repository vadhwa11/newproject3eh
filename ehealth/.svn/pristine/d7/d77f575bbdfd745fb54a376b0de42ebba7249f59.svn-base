
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
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>


<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
	var icdArray = new Array();

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
	</script>

<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	Map map = new HashMap();
	String includedJsp = "";
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

	List inPatientDetailList = new ArrayList();
	List<MasIcd> icdNoList = new ArrayList<MasIcd>();
	if (map.get("icdNoList") != null) {
	icdNoList = (List<MasIcd>) map.get("icdNoList");
	}
	if (inPatientDetailList != null) {
	inPatientDetailList = (List) map.get("inPatientDetailList");
	}

	String userName = "";
	String deptName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	String admissionNumber = null;
	int hinId = 0;
	int inpatientId = 0;
	String temp ="";
	if (inPatientDetailList != null) {
	String patientName = "";
	String consultantName = "";
	Inpatient inPatientDetail = (Inpatient) inPatientDetailList
	.get(0);
	hinId = inPatientDetail.getHin().getId();
	inpatientId = inPatientDetail.getId();
	if (inPatientDetail.getHin().getPFirstName() != null) {
	patientName = inPatientDetail.getHin().getPFirstName();
	}
	if (inPatientDetail.getHin().getPMiddleName() != null) {
	patientName =patientName+" "+ inPatientDetail.getHin().getPMiddleName();
	}
	if (inPatientDetail.getHin().getPLastName() != null) {
	patientName =patientName+" "+ inPatientDetail.getHin().getPLastName();
	}
	if (inPatientDetail.getDoctor().getFirstName() != null) {
	consultantName = inPatientDetail.getDoctor().getFirstName();
	}
	if (inPatientDetail.getDoctor().getMiddleName() != null) {
	consultantName =consultantName+" "+ inPatientDetail.getDoctor()
	.getMiddleName();
	}
	if (inPatientDetail.getDoctor().getLastName() != null) {
	consultantName =consultantName+" "+ inPatientDetail.getDoctor().getLastName();
	}

	MasIcd masIcd = (MasIcd) inPatientDetail.getDiagnosis();
	admissionNumber = inPatientDetail.getAdNo();
	session.setAttribute("admissionNumber", admissionNumber);
	%>

<div class="titleBg">
<h2>Patient Diagnosis Entry (ICD Code)</h2>
</div>
<div class="clear"></div>
<h4><%=deptName%></h4>
<div class="clear"></div>

<%
	if(map.get("message") != null){
	String message = (String)map.get("message");
	out.println(message);
	}
	%>
<form name="patientDiagnosis" method="post" action="">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label><label class="value"><%=inPatientDetail.getHinNo()%></label>

<label>Patient Name</label> <label
	class="value"> <%=patientName%></label> <label>IPD No.</label> <%
	if (inPatientDetail.getAdNo() != null) {
	%> <label class="value"> <%=inPatientDetail.getAdNo()%></label> <%
	} else {
	%> <label class="value">-</label> <%
	}
	%> <label>Ward Name</label> <%
	if (inPatientDetail.getDepartment() != null) {
	%> <label class="value"> <%=inPatientDetail.getDepartment()
	.getDepartmentName()%></label> <%
	} else {
	%> <label class="value">-</label> <%
	}
	%> <label>Age</label> <%
	if (inPatientDetail.getAge() != null) {
	%> <label class="value"> <%=inPatientDetail.getAge()%></label> <%
	} else {
	%> <label class="value">-</label> <%
	}
	%> <label>Sex</label> <%
	if (inPatientDetail.getHin().getSex() != null) {
	%> <label class="value"> <%=inPatientDetail.getHin().getSex()
	.getAdministrativeSexName()%></label> <%
	} else {
	%> <label class="value">-</label> <%
	}
	%> <label>Consultant</label> <label class="value"><%=consultantName%></label>
<label>Diagnosis</label> <%
	Set<DischargeIcdCode> set = (Set<DischargeIcdCode>) inPatientDetail.getDischargeIcdCodes();
	if (set.size() > 0) {
	int dilStatusId = 0;
	String diagnosisStatus = "";

	for (DischargeIcdCode dischargeIcdCode : set) {
	if (dischargeIcdCode.getInpatient().getId() == inPatientDetail.getId()) {
	if (dischargeIcdCode.getId() > dilStatusId) {
	if(dischargeIcdCode.getIcd() !=null){
	diagnosisStatus = ""+ dischargeIcdCode.getIcd().getIcdName();
	dilStatusId = dischargeIcdCode.getId();
	temp =""+ dischargeIcdCode.getIcd().getIcdName()+"["+dischargeIcdCode.getIcd().getIcdCode()+"]";
	}
	}
	}
	}
	%> <label class="valueAuto"><%=diagnosisStatus%></label> <%
	} else if (inPatientDetail.getDiagnosis() != null) {
	temp =inPatientDetail.getDiagnosis().getIcdName()+"["+inPatientDetail.getDiagnosis().getIcdCode()+"]";
	%> <label class="valueAuto"><%=inPatientDetail.getDiagnosis().getIcdName() %></label>
<%
	} else {
	%> <label class="value">-</label> <%
	}
	%>
<div class="clear"></div>
<label>Initial Diagnosis</label> <%if(inPatientDetail.getInitDiagnosis() !=null) %>
<label class="valueAuto"><%=inPatientDetail.getInitDiagnosis()%></label>

<%
	}
	%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Diagnosis</h4>
<div class="clear"></div>
<div class="Block"><label class="medium">Z03</label> <input
	type="checkbox" name="<%=Z03 %>" class="radioCheck" value="z03"/><label
	class="medium">Z09</label> <input type="checkbox" name="<%=Z09 %>"
	class="radioCheck" value="z09"/><input type="button"
	class="buttonAdd" value=" " onclick="addRow();" align="right" /> <input
	type="button" class="buttonDel" value=" "
	onclick="removeRowForUpdateDischarge(this,'tblSample');" align="right" />
<div class="clear"></div>
<label class="medium">Icd Code</label> <input name="" value=""
	id="icdCode" onblur="getIcd();" /> <input name="" value="" id="temp"
	type="hidden" /> <IMG SRC="/hms/jsp/images/search.gif" WIDTH="26"
	HEIGHT="26" style="cursor: pointer;"
	onClick="javascript:openPopupWindow();"
	title="Click here to Search ICD Codes"/>
<div class="clear"></div></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<table colspan="7" id="tblSample">
	<tbody>
		<tr>
			<th>check</th>
			<th>S.No</th>
			<th>Diagnosis</th>
			<th>Provisional Diagnosis</th>
			<th>Final Diagnosis</th>

		</tr>
		<tr>
			<td width="2%"><input type="checkbox" class="radioCheck"
				name="checkbox" id="checkbox" value="" /></td>
			<td width="1%"><label>1:</label></td>

			<td width="10%"><input type="text" align="right" name="icd"
				id="icd" size="50" value=""onblur="checkForFillItems(this);" />
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('icd','ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'});
	</script></td>

			<td><input type="radio" align="right" name="parent" value="p"
				checked="true" id="parent" class="radioCheck" /></td>
			<td><input type="radio" align="right" name="parent" value="f"
				id="parent1" class="radioCheck" /></td>

		</tr>
	</tbody>
</table>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Previous Diagnosis</h4>
<div class="clear"></div>
<table id="indentDetails" colspan="7">
	<tbody>
		<tr>
			<th>S.No.</th>
			<th>Date</th>
			<th>Time</th>
			<th>Diagnosis</th>
			<th>Provisional Diagnosis</th>
			<th>Final Diagnosis</th>

		</tr>

		<%
	int i = 1;
	if (map.get("disList") != null) {
	List disList = (List) map.get("disList");
	Iterator itr = disList.iterator();
	String icdName ="";
	String diagnosisStatus ="";
	while (itr.hasNext()) {
	DischargeIcdCode dischargeIcdCode = (DischargeIcdCode) itr.next();
	if(dischargeIcdCode.getIcd() !=null){
		icdName = dischargeIcdCode.getIcd().getIcdName();
	diagnosisStatus = dischargeIcdCode.getDiagnosisStatus();
	}
	%>


		<tr>
			<td><input type="text" size="2" value="<%=i%>"
				readonly="readonly" /></td>
			<td><%=HMSUtil.convertDateToStringWithoutTime(dischargeIcdCode.getAddEditDate())%></td>
			<td><%=dischargeIcdCode.getAddEditTime()%></td>
			<td><!--  <input type="text" align="rclass="bodytextB_blue"ht" value="<%=icdName %>" name="icd" id="icd" class="bigcaption"    /> -->
			<%=icdName%></td>
			<%if (diagnosisStatus.equals("p")) {%>
			<td>Provisional</td>
			<%	} else {%>
			<td>-</td>
			<%}	if (diagnosisStatus.equals("f")) {	%>
			<td>Final</td>
			<%	} else {%>
			<td>-</td>
			<%}	%>
		</tr>
		<%
	  i++;
	   }
	 }
	%>

	</tbody>
</table>

<input type="hidden" name="hdb" value="1" id="hdb" /> <input
	type="hidden" name="inpatientId" value="<%=inpatientId %>"
	id="inpatientId" /> <input type="hidden" name="hinId"
	value="<%=hinId %>" id="hinId" /> <input type="hidden" name="date"
	value="<%=currentDate %>"/><input type="hidden" name="time"
	value="<%=currentTime%>"/><input type="hidden" name="deptName"
	value="<%=deptName%>"/>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit" value="Submit" align="right"
	class="button"
	onClick="if(checkICD()){submitForm('patientDiagnosis','/hms/hms/ipd?method=addPatientDiagnosisInformation');}" />
<input type="button" class="buttonBig" value="Discharge Summery "
	align="right"
	onClick="submitForm('patientDiagnosis','/hms/hms/discharge?method=showDischargeInputJsp&parent=<%=inpatientId%>');" />
<input type="button" class="button" value="Back" align="right"
	onClick="submitForm('patientDiagnosis','ipd?method=showPatientListJsp');" />	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	

<div class="clear"></div>
<div class="division"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<script type="text/javascript">
	 function checkForFillItems(val){

  var tbl = document.getElementById('tblSample');


  for(var i=1;i<lastRow;i++){
  if(i==1){
  if(document.getElementById("icd").value==val){
  alert("you have already selected this item ");
  }
  }
  if(document.getElementById("icd"+i).value==val){
  alert("you have already selected this item ");
  document.getElementById("icd"+i).value=="";
  return false;
  }
  }
  }
	function addRow(){
	var icdString =document.getElementById("temp").value;
	//alert("icdString---"+icdString)
	if(icdString !="NO"){
	if(document.getElementById("icd").value==""){
	document.getElementById("icd").value =icdString
	document.getElementById("temp").value=""
	document.getElementById("icdCode").value =""
	return false;
	}
	}else{
	alert("ICD Code does not exists...!")
	document.getElementById("icdCode").value =""
	document.getElementById("temp").value =""
	return true
	}
	if(icdString != "NO"){
	var tbl = document.getElementById('tblSample');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb');
	hdb.value=iteration

	var cellRight2 = row.insertCell(0);
	var e2 = document.createElement('input');
	e2.type = 'checkbox';
	e2.className = 'radioCheck';
	cellRight2.appendChild(e2);

	var cellRight0 = row.insertCell(1);
	var e0 = document.createElement('label');
	e0.type = 'label';
	e0.innerHTML = iteration+':'
	e0.className = 'smalllabel'
	cellRight0.appendChild(e0);

	var cellRightSel = row.insertCell(2);
	var sel = document.createElement('input');
	sel.name = 'icd' + iteration;
	sel.size = "50";
	sel.id = 'icd' + iteration;

	sel.type = 'text';
	sel.value =icdString;
	sel.className = 'bigcaptionIcd2'
	sel.onblur=function(){
	 var tbl = document.getElementById('tblSample');

	var val=document.getElementById("icd"+iteration).value;
  for(var i=1;i<lastRow;i++){
  if(i==1){
  if(document.getElementById("icd").value==val){
  alert("you have already selected this item ");
  document.getElementById("icd"+iteration).value=""
  }
  }if(document.getElementById("icd"+i)!=null){
  if(document.getElementById("icd"+i).value != ""){
  if(document.getElementById("icd"+i).value==val){
  alert("you have already selected this item ");
  document.getElementById("icd"+iteration).value=""

  return false;
  }}}
  }
  }
	cellRightSel.appendChild(sel);
	new Ajax.Autocompleter('icd'+iteration,'ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'+iteration});


	var cellRight2 = row.insertCell(3);
	var e2 = document.createElement('input');
	e2.name='parent'+iteration;
	e2.id='parent'+iteration;
	e2.type = 'radio';
	e2.width='1%'
	e2.className = 'radioCheck';
	e2.checked='true';
	e2.value='p';
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(4);
	var e3 = document.createElement('input');
	e3.name='parent'+iteration;
	e3.id='parent1'+iteration;
	e3.type = 'radio';
	e3.className = 'radioCheck';
	e3.width='1%'
	e3.value='f';
	cellRight3.appendChild(e3);
	document.getElementById("icdCode").value =""
	document.getElementById("temp").value =""
	}else{
	alert("ICD Code does not exists...!")
	document.getElementById("icdCode").value =""
	document.getElementById("temp").value =""
	return true
	}

	}
	function removeRowForUpdateDischarge(argIndex,idName){

	var table=document.getElementById(idName);
	var tblRows  = table.getElementsByTagName("tr");
	if(tblRows.length==2){
	alert("There is only Single Row ");
	return false;
	}
	var check=0;

	for(i=tblRows.length-1;i>0;i--)
	{
	var tblCtrl =  tblRows[i].getElementsByTagName("input");


	for(j=0;j<tblCtrl.length;j++)
	{
	if(tblCtrl[j].type == 'checkbox')
	{
	if(tblCtrl [j].checked)
	check=check+1;
	}
	}
	}

	for(i=tblRows.length-1;i>0;i--)
	{
	var tblCtrl =  tblRows[i].getElementsByTagName("input");

	for(j=0;j<tblCtrl.length;j++)
	{
	if(tblCtrl[j].type == 'checkbox')
	{
	if(tblCtrl [j].checked)
	document.getElementById(idName).deleteRow(i);
	}
	}
	}
	}
	function removeRow()
	{
	var tbl = document.getElementById('tblSample');
	var lastRow = tbl.rows.length;
	if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}

	function checkICD()
	{

	var counter = document.getElementById('hdb').value;
	// alert("in function icd value of counter--"+counter)
	var str="";
	var inc="";
	var temp="";

	for(var i=1;i<=counter;i++)
	{

	temp=i+1;
	for(var j=temp;j<=counter;j++)
	{
	var k=j+"";
	var icdIdInF=document.getElementById('icd'+str).value
	var icdIdInS=document.getElementById('icd'+k).value
	//alert("value of ICD in iii loop--- "+icdIdInF+"---and value of ICD id in jjj loop---"+icdIdInS)
	if(icdIdInS != ""){
	var diagnosis="";
	if(document.getElementById('parent'+str).checked == true)
	{
	diagnosis=document.getElementById('parent'+str).value
	}else{
	diagnosis=document.getElementById('parent1'+str).value
	}
	var currDiagnosis="";
	if(document.getElementById('parent'+k).checked == true)
	{
	currDiagnosis=document.getElementById('parent'+k).value
	}
	else{
	currDiagnosis=document.getElementById('parent1'+k).value
	}

	if(icdIdInS ==icdIdInF && currDiagnosis==diagnosis )
	{
	alert("PLease Either Change the ICD Code for Serial Number "+k +" OR Change the Status of Diagnosis. ")
	return false;
	}

	}
	}
	if(i==1)
	{
	str=(i+1)+"";
	temp=i+1;
	}else{
	str=(i+1)+"";
	temp=i+1;
	}

	}
	return true;
	}

	function checkICDCodes()
	{
	var counter = document.getElementById('hdb').value;
	var str="";
	alert("In ICD code method")
	for(var i=0;i<counter-1;i++)
	{

	var icdId=document.getElementById('icdId'+str).value
	var diagnosis="";
	if(document.getElementById('parent'+str).checked == true)
	{
	diagnosis=document.getElementById('parent'+str).value
	}else{
	diagnosis=document.getElementById('parent1'+str).value
	}

	//var diagnosis=document.getElementById('parent1'+str).value
	var currICD=document.getElementById('icdId'+counter).value
	var currDiagnosis="";
	if(document.getElementById('parent'+counter).checked == true)
	{
	currDiagnosis=document.getElementById('parent'+counter).value
	}
	else{
	currDiagnosis=document.getElementById('parent1'+counter).value
	}

	//alert("value of icd id---"+icdId+"---value of diagnosis-----"+diagnosis)
	//alert("value of currICD-----"+currICD+"----value of current Diagnosis-----"+currDiagnosis)
	if(i==0)
	{
	str=(i+1+1)+"";

	}else{
	str=(i+1+1)+"";

	}
	if(currICD ==icdId && diagnosis==currDiagnosis )
	{
	alert("PLease Either Change the ICD Code for Serial Number "+counter +" OR Change the Status of Diagnosis. ")
	return false;
	}
	}
	return true;
	}
	function getIcd(){
	//=========To get Icd String with icd code==========================
	var icdCode =document.getElementById("icdCode").value
	if(icdCode !="")
	{
	var xmlHttp;
	try {
	// Firefox, Opera 8.0+, Safari
		xmlHttp=new XMLHttpRequest();
	}catch (e){
	// Internet Explorer
	try{
		xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		}catch (e){
			alert(e)
		try{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}catch (e){
			alert("Your browser does not support AJAX!");
			return false;
		}
	  }
	}

	xmlHttp.onreadystatechange=function()
	{
	if(xmlHttp.readyState==4){

	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	for (loop = 0; loop < items.childNodes.length; loop++) {
			var item = items.childNodes[loop];
			icdString  = item.getElementsByTagName("icdString")[0];

		if(icdString.childNodes[0].nodeValue){
			icdString=icdString.childNodes[0].nodeValue
			document.getElementById("temp").value =icdString
			}
		}
	  }
	}
	var url="/hms/hms/adt?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	xmlHttp.open("GET",url,true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

	}

	//==================End of Icd String block======================
  }


	</script>




