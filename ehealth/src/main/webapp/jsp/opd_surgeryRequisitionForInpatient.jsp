<%@page import="jkt.hms.masters.business.HospitalDoctorUnitM"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!-- by govind end-->
	<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
	<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
	<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/opd.js"></script>
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script>jQuery.noConflict();</script>
<script src="/hms/jsp/js/ipd.js"></script>
	<!-- by govind end-->
<script type="text/javascript">
function checkSubmitSurgery() {
	 var chargeCode=document.getElementById('chargeCodeName1').value
	var index1 = chargeCode.lastIndexOf("[");
   var index2 = chargeCode.lastIndexOf("]");
   index1++;
   var id = chargeCode.substring(index1,index2);
   if(id ==""){
   	alert("Please Enter The Surgery For the patient.")
		return false ;
	}
	return true;
}	

	// by govind 
	var callbck_index =function(ret_OUT){setValue(ret_OUT);};
	var semantictag_IN;
	var acceptability_IN;
	var state_IN ;
	var returnlimit_IN;
	var retterm_value ={};
	//by govind end
</script>

<script type="text/javascript" language="javascript">
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
		serverdate = '<%=date+"/"+month+"/"+year%>';
</script>

<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}

		int hospitalId=0;
		int orderNo=0;
		String userName = "";
		String empName="";
		String patientName="";
		String servicePersonName="";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<HospitalDoctorUnitM>hospitalDoctorUnitMList=new ArrayList<HospitalDoctorUnitM>();

		if(map.get("inpatientList")!=null)
		{
			inpatientList=(List<Inpatient>)map.get("inpatientList");
		}
		
		if(map.get("hospitalDoctorUnitMList")!=null)
		{
			hospitalDoctorUnitMList=(List<HospitalDoctorUnitM>)map.get("hospitalDoctorUnitMList");
		}
		
		//added by govind 14-10-2016
		/* List<OpdSurgeryHeader> surgeryHeaderList=new ArrayList<OpdSurgeryHeader>();
		if(map.get("surgeryHeaderList")!=null)
		{
			surgeryHeaderList=(List<OpdSurgeryHeader>)map.get("surgeryHeaderList");
		} */
		List<OpdSurgeryDetail> surgeryDetailList=new ArrayList<OpdSurgeryDetail>();
		if(map.get("surgeryDetailList")!=null)
		{
			surgeryDetailList=(List<OpdSurgeryDetail>)map.get("surgeryDetailList");
		}
		//added by govind 14-10-2016 end
		
	 /* List patientDetailList = new ArrayList();
	 List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	 List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	 List<Visit> visitList = new ArrayList<Visit>();
			
	if(map.get("patientDetailList") != null){
		patientDetailList=(List)map.get("patientDetailList");
	}
	
	if(map.get("departmentList") != null){
		departmentList=(List)map.get("departmentList");
	}
	
	if(map.get("visitList") != null){
		visitList=(List)map.get("visitList");
	}
	int vdeptId = 0;
	int vempId = 0;
	for(Visit visit:visitList){
		vdeptId = visit.getDepartment().getId(); 
		vempId = visit.getDoctor().getId();
	}

	if(map.get("empName") != null){
		empName=(String)map.get("empName");
	}
	
	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
	}	
		
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if(map.get("orderNo") != null){
		orderNo=(Integer)map.get("orderNo");
		}
	int prescribedDepartmentId=0;
	if(map.get("deptId") != null){
		prescribedDepartmentId=(Integer)map.get("deptId");
		}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Patient patient=(Patient)patientDetailList.get(0);
	if(patient.getPFirstName()!= null){
		patientName=patient.getPFirstName();
	}
	if(patient.getPMiddleName()!= null){
		patientName=patientName+" "+patient.getPMiddleName();
	}
	if(patient.getPLastName()!= null){
		patientName=patientName+" "+patient.getPLastName();
	}
	
	if(patient.getSFirstName()!= null){
		servicePersonName=patient.getSFirstName();
	}
	if(patient.getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+patient.getSMiddleName();
	}
	if(patient.getSLastName()!= null){
		servicePersonName=servicePersonName+" "+patient.getSLastName();
	} */
	
%>


<%-- <form name="inpatientSurgeryRequisition" action="" method="post">
<%if(patient.getPatientStatus().equals("In Patient")){ %>

<div class="titleBg">
<h2>Surgery Requisition For In-Patient</h2>
</div>
<div class="clear"></div>

<%}else{ %>
<div class="titleBg">
<h2>Surgery Requisition For In-Patient</h2>
</div>
<div class="clear"></div>
<%} %>
<div class="clear"></div>

<script type="text/javascript">
   var icdArray=new Array();
</script> <!--Block One Starts--> <div class="blockTitle">Service Personnel Details</div><div class="blockTitleCurve"></div>
	<div class="clear"></div>
	
<div class="blockFrame">
	<div class="clear"></div>
	<label class="medium">Service Type</label>
	<%if(patient.getServiceType()!= null){ %>
	<label ><%=patient.getServiceType().getServiceTypeName() %></label>
	<%}else{ %>
	<label >-</label>
	<%} %>
	<label class="medium">Service No.</label>
	<%if(patient.getServiceNo()!= null){ %>
	<label ><%=patient.getServiceNo() %></label>
	<%}else{ %>
	<label >-</label>
	<%} %>
	<label class="medium"> Serv. Status </label>
	<%if(patient.getServiceStatus()!= null){ %>
	<label ><%=patient.getServiceStatus().getServiceStatusName() %></label>
	<%}else{ %>
	<label >-</label>
	<%} %>
	
	<label class="medium">Name</label>
	<%if(servicePersonName != null){ %>
	<label  style="width: auto;"><%=servicePersonName %></label>
	<%}else{ %>
	<label >-</label>
	<%} %>
	<div class="clear"></div>
	
	<label class="medium">Relation</label>
	<%if(patient.getRelation() != null){ %>
	<label ><%=patient.getRelation().getRelationName() %></label>
	<%}else{ %>
	<label >-</label>
	<%} %>
	<label class="medium">Rank</label>
	<%if(patient.getRank()!= null){ %>
	<label ><%=patient.getRank().getRankName() %></label>
	<%}else{ %>
	<label >-</label>
	<%} %>

	<label class="medium">Unit</label>
	<%if(patient.getUnit()!= null){ %>
	<label ><%=patient.getUnit().getUnitName() %></label>
	<%}else{ %>
	<label >-</label>
	<%} %>
	
	<label class="medium">Unit Address</label>
	<% if(patient.getUnit()!= null){%>
	<label ><%=patient.getUnit().getUnitAddress() %></label>
	<%}else{ %>
	<label >-</label>
	<%} %>
	<div class="division">
	</div>
	<!--Block One Ends-->
	
<h4>Patient Details</h4>
<div class="Block">
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <%if(patient.getHinNo()!= null){ %>
<label class="value"><%=patient.getHinNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Patient Name</label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label>Age</label> <%if(patient.getAge()!= null){ %>
<label class="value"><%=patient.getAge() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Patient Status </label> <%if(patient.getPatientStatus() != null){ %>
<label class="value"><%=patient.getPatientStatus() %></label> <input
	type="hidden" name="patientStatus" id="patientStatus"
	value="<%=patient.getPatientStatus() %>" /> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Reg.Date </label> <%if(patient.getRegDate()!= null){ %>
<label class="value"><%=HMSUtil.convertDateToStringWithoutTime(patient.getRegDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Order No</label> <label
	class="value"><%=orderNo %></label>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">
<label><span>*</span> Department</label> 
<select name="deptId" id="departmentId" onchange="changeValue(this.value)"
	validate="Department,metachar,yes">
	<option value="0">Select</option>
	<%
       int deptId=0;
       int empId =0; 
	   //Iterator itr= departmentList.iterator();
       for(MasDepartment masDepartment : departmentList)
       {
    	if(masDepartment.getId() == vdeptId){
	%>
	<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<% 	}
     }
	%>
</select> <!--
   <label class="medium">Prescribed By: </label>
   <label ><%=empName %></label>
   
   <div id="ajaxResponse"></div>
   --> <label><span>*</span> Surgeon Name</label> <select
	name="surgeonName" id="surgeonName" onchange=""
	validate="Surgeon Name,String,yes">
	<option value="0">Select</option>
	<%
       
	  // Iterator itr1= doctorList.iterator();
       for(MasEmployee masEmployee : doctorList)
       {
    	   String masemp="";
    	   masemp=masEmployee.getFirstName();
    	   if(masEmployee.getMiddleName()!=null)
    	   {
    		   masemp =masemp+' '+masEmployee.getMiddleName();
    	   }
    	   if(masEmployee.getLastName()!=null)
    	   {
    		   masemp =masemp+' '+masEmployee.getLastName();
    	   }
    	   
    	  // if(vempId == masEmployee.getId()){
 	%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masemp%></option>
	<%}// }
	%>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Surgery</h4>
<div class="clear"></div>

<!--  <input type="button" class="ButtonDel"  alt="Delete" value=" " onclick="removeRow();" align="right" />
			 <input type="button" class="ButtonAdd"  alt="Add" value=" " onclick="" align="right" />
			  -->
	Start Code Comment by anamika		  
			   <input type="button" class="buttonDel" value=""
	onclick="removeRow();" align="right" /> <input type="button"
	class="buttonAdd" value="" onclick="addRowForSurgery();" align="right" />
End Code Comment by anamika	
<div class="clear"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col" style="width: 20px;">S.No</th>
		<th scope="col">Surgery Name</th>
		<th scope="col">Surgery Code</th>
		<th scope="col">Rate</th>

	</tr>

	<tr>
		<td><label>1</label></td>
		<td>
		<%int inc=1; %> <input type="text" value="" tabindex="1"
			id="chargeCodeName1" size="80" name="chargeCodeName1"
			onblur="if(validateSurgeryForAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('inpatientSurgeryRequisition','/hms/hms/opd?method=fillChargeCode&rowVal=1','chargeCodeVal');}" />
		<div id="ac2update<%=inc %>" style="display: none;"
			class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			   function eventCallback(element, entry){
					return entry + "&deptId="+document.getElementById("departmentId").value; 
				}
			  new Ajax.Autocompleter('chargeCodeName1','ac2update<%=inc%>','ot?method=getInvestigationListForRequestionForIP',{parameters:'requiredField=chargeCodeName1',callback: eventCallback});
			</script>
		<td id="chargeCodeVal"><input type="text" name="chargeCode1"
			id="chargeCode1" size="10" /></td>
		<td id="rateVal"><input type="text" name="rate1" id="rate1"
			size="8" readonly="readonly" tabindex="1" /></td>

		<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
		<!--
		   	<input type="hidden" value="" name="<%=CHARGE_CODE_ID%>" id="chargeCodeId" />
		   	--> <input type="hidden" name="chargeCode1" id="chargeCode1"
			size="10" /></td>

		<!--   <td id="chargeCodeVal">
		    	<input type="text" name="chargeCode1" id="chargeCode1" size="10"  />
		    </td>  -->
	</tr>
</table>

<div class="clear"></div>
<div class="division"></div>
<input name="Submit" type="button" align="right" class="button"
	value="Submit"
	onclick="if(checkSubmitSurgery()){submitForm('inpatientSurgeryRequisition','opd?method=submitSurgeryRequisitionDetailsForInpatient&orderNo=<%=orderNo %>');}" />
<input type="reset" class="buttonHighlight" name="reset" value="reset" />
<div class="clear"></div>
<div class="division"></div>
<div class="paddingTop40"></div>



<input type="hidden" name="hinId" value="<%=patient.getId() %>" /> <input
	type="hidden" name="prescribedDepartmentId"
	value="<%=prescribedDepartmentId %>" /> <input type="hidden"
	name="deptId" value="<%=deptId %>" /> <input type="hidden" name="date"
	value="<%=date %>" /> <input type="hidden" name="time"
	value="<%=time %>" /> <input type="hidden" name="userName"
	value="<%=userName %>" /></form>
<script type="text/javascript">
  
	function removeRow()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}
 function addRowForSurgery(){
		
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	 
	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('label');
	  sel.innerHTML=hdb.value;
	  sel.size='2'
	  cellRightSel.appendChild(sel);
	 
	  var cellRight1 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.onblur=function(){
	  	if(validateSurgeryForAutoComplete(this.value,iteration)){checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}
	  						
	  };
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  e0.size = '80'
	  cellRight1.appendChild(e0);
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
    cellRight1.appendChild(newdiv);

	// change by anamika------
	//new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getChargeCodeListForAutoComplete',{parameters:'requiredField=chargeCodeName'+iteration});
	new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'ot?method=getInvestigationListForRequestionForIP',{parameters:'requiredField=chargeCodeName'+iteration});
	

	  var cellRightSel = row.insertCell(2);
	  cellRightSel.id='chargeCodeVal'+iteration;
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration
	  sel.size = '10'
	  cellRightSel.appendChild(sel);

	  var cellRightSe2 = row.insertCell(3);
	  cellRightSe2.id='rateVal'+iteration;
	  var se2 = document.createElement('input');
	  se2.type = 'text';
	  se2.name='rate'+iteration;
	  se2.id='rate'+iteration;
	  se2.readOnly=true; 
	  se2.size = '8';
	  cellRightSe2.appendChild(se2);
	}
	function checkForChargeCode(val,inc,chargeCodeTdDiv){

	if(val != ""){
		
		var index1 = val.lastIndexOf("[");
		var indexForChargeCode = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var chargeId = val.substring(index1,index2);
		var indexForChargeCode = indexForChargeCode--;
		var chargeCode = val.substring(0,indexForChargeCode);
		    
		
		if(chargeId == "" ) {
	      	document.getElementById('chargeCodeName'+inc).value="";
	      	document.getElementById('chargeCode'+inc).value="";
	      	document.getElementById('clinicalNotes'+inc).value="";
	 	  	document.getElementById('qty'+inc).value="";
	      	return;
		}
		for(i=1;i<inc;i++){
			if(inc != 1){
				if(document.getElementById('chargeCodeName'+i).value==val) {
					alert("Test name already selected...!")
					document.getElementById('chargeCodeName'+inc).value=""
					document.getElementById('chargeCode'+inc).value=""
					var e=eval(document.getElementById('chargeCodeName'+inc)); 
					e.focus();
					return false;
				} 
			} 
		}
submitProtoAjaxWithDivName('inpatientSurgeryRequisition','/hms/hms/opd?method=fillChargeCode&rowVal='+inc,chargeCodeTdDiv);
		var nameOfChargeCodeArray = chargeCode.split('&');
		var tempChargeCodeString = "";
		for(var m=0; m<nameOfChargeCodeArray.length;m++) {
			tempChargeCodeString = tempChargeCodeString + nameOfChargeCodeArray[m]+"0";			
		}
		
		submitProtoAjaxWithDivNameToShowStatus('inpatientSurgeryRequisition','/hms/hms/opd?method=fillChargeCode&chargeCodeNAmeForAjax='+ tempChargeCodeString+'&rowVal=1',chargeCodeTdDiv);
		
		}else{
			document.getElementById('chargeCodeName'+inc).value = "";
			document.getElementById('qty'+inc).value = "";
			document.getElementById('chargeCode'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
			//document.getElementById('qty'+inc).value = "";
		}
	}     
	function fillChargeCodeId(val){
		//alert("in method--")

		if(val != "") {
		    var index1 = val.lastIndexOf("[");
		    var indexForChargeCode=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var chargeCodeId = val.substring(index1,index2);
		    var indexForChargeCode=indexForChargeCode--;
		    var chargeCodeName=val.substring(0,indexForChargeCode);
			if(chargeCodeId == "") {
		   		document.getElementById('chargeCodeName1').value="";
		    	document.getElementById('chargeCodeId').value="";
		   		return;
		   	} else {
	   		      document.getElementById('chargeCodeId').value=chargeCodeId;
	      	}
	 	}
	}
	
</script> --%>
<div class="titleBg">
<h2>Surgery Planning</h2>
</div>
<div class="Block">
<div class="clear"></div>
<form name="searchForsurgery" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>		
<!-- <script type="text/javascript">
   var icdArray=new Array();
</script> -->

<div class="clear"></div>

<%-- <label>
Tentative Date
</label>
<label class="value"><input style="width: 110px;" type="text" name="<%=DATE_OF_ADMISSION%>" validate="Adm. Date,string,yes" maxlength="30" id="admDate" onchange="populateListDateTime();" onclick="populateListDateTime();">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" id="imgId"  onclick="javascript:setdate('24/03/2015',document.admissionByHin.dateOfAdmission,event)">
</label> --%>
<!-- <label>
Department
</label>
<label class="value">
<select>
<option>select</option>
</select>
</label> -->
<%--<label>
Unit
</label>
<select name="unit" id="unit">
<option value="0">select</option>
<%for(HospitalDoctorUnitM HospitalDoctorUnitM :hospitalDoctorUnitMList){ --%>
<%--<option value="<%=HospitalDoctorUnitM.getId()%>"><%=HospitalDoctorUnitM.getUnitCode() %></option>
<%} %>
</select>--%>


<!-- <label>
OT
</label>
<label class="value">
<select>
<option>select</option>
</select>
</label> -->
<!-- <label>
Surgeon Name
</label>
<label class="value">
<select>
<option>select</option>
</select>
</label> -->
<%-- <label>
UHID
</label>

<input class="smalll" value="" name="<%=HIN_NO %>" id="<%=HIN_NO %>" validate="UHID,metachar,no"/>

<label>
Ip No.
</label>
<label class="value"  >
<input class="smalll" value=""  name="<%=AD_NO%>" id="<%=AD_NO%>" validate="Ip No.,metachar,no"/>
</label>
<div class="clear"></div>

<label>
Patient Name
</label>
<label class="value">
<input class="smalll" value="" name="<%=PATIENT_NAME%>" id="<%=PATIENT_NAME%>" validate="Patient Name,metachar,no"/>
</label>
<div class="clear"></div>
<input type="submit" class="button" value="Search" />

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>--%>
</form>
<form name="inpatientSurgeryRequisition" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
if(inpatientList.size()>0)
{
%>
<div class="floatLeft" style="width: 300px;">
				<input type="button" class="button" value="Delete"
					onclick="removeRow('investigationGrid');" /> <input type="button"
					class="button" onclick="addSurgicalRequRow();" value="Add" />
			</div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col" style="width: 20px;">S.No</th>
		<th scope="col">Admission Date</th>
		<th scope="col">UHID</th>
		<th scope="col">Patient Name</th>
		<th scope="col">IP No.</th>
		<th scope="col">Department</th>
		<th scope="col">Unit</th>
		<th scope="col">Procedure</th>
		<!-- <th scope="col">Tentative Date</th> -->
		<th scope="col">PAC Status</th>
		<th scope="col">Select</th>

	</tr>
	<%int i=0;
	String pName="";
	if(surgeryDetailList.size()>0){	
		for(OpdSurgeryDetail surgDetail:surgeryDetailList)
		{
			i++;
			pName=surgDetail.getOpdSurgery().getInpatient().getHin().getPFirstName();
			if(surgDetail.getOpdSurgery().getInpatient().getHin().getPMiddleName()!=null)
			{
				pName +=" "+surgDetail.getOpdSurgery().getInpatient().getHin().getPMiddleName();
			}
			if(surgDetail.getOpdSurgery().getInpatient().getHin().getPLastName()!=null)
			{
				pName +=" "+surgDetail.getOpdSurgery().getInpatient().getHin().getPLastName();
			}
			//Set<OpdSurgeryDetail> opdDet=surgHeader.getOpdSurgeryDetails();
			%>
		<tr>
		<td><%=i%></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getDateOfAddmission() %></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getHin().getHinNo() %></td>
		<td><%=pName%></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getAdNo() %></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getDepartment().getDepartmentName() %></td>
		<td></td> 
		<td><input type="text" class="opdTextBoxSmall" value="<%=surgDetail.getChargeCode().getChargeCodeName() %>" readonly="readonly" id="proscedureName<%=i%>"/>
		     <input type="hidden" id="procedureId<%=i %>"	value="<%=surgDetail.getChargeCode().getId() %>" />
		</td>
	
		<td><select>
		<option value="<%=surgDetail.getOpdSurgery().getPacStatus()%>" ><%=surgDetail.getOpdSurgery().getPacStatus()%></option>
		</select>
		</td>
				
		<td>
		</td>
	</tr>
	
		
	<%
		}
	}
	%>
	
	<%
	
	String admisDate="",UHID="",patName="",adNo="",deptName="",inpatientId="",hinId="";
	for(Inpatient inpatient:inpatientList)
	{ 
		i++;
	pName=inpatient.getHin().getPFirstName();
	if(inpatient.getHin().getPMiddleName()!=null)
	{
		pName +=" "+inpatient.getHin().getPMiddleName();
	}
	if(inpatient.getHin().getPLastName()!=null)
	{
		pName +=" "+inpatient.getHin().getPLastName();
	}
	//added by govind
	admisDate=inpatient.getDateOfAddmission().toString();
	UHID=inpatient.getHin().getHinNo();
	patName=pName;
	adNo=inpatient.getAdNo();
	deptName=inpatient.getDepartment().getDepartmentName();
	inpatientId=inpatient.getId().toString();
	hinId=inpatient.getHin().getId().toString();
	//added by govind
	%>

	<tr>
		<td><%=i%></td>
		<td><%=inpatient.getDateOfAddmission() %></td>
		<td><%=inpatient.getHin().getHinNo() %></td>
		<td><%=pName %></td>
		<td><%=inpatient.getAdNo() %></td>
		<td><%=inpatient.getDepartment().getDepartmentName() %></td>
		<td></td>
		<!-- changed by govind 14-10-2016 -->
		<%--<td><input type="text"  name="proscedureName<%=i%>" id="proscedureName<%=i%>" onblur="getProcedureId(this.value,<%=i %>)" />  --%> 
		<td><input type="text" class="opdTextBoxSmall textYellow" name="proscedureName<%=i%>" id="proscedureName<%=i%>" 
		onkeypress="selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'proscedureName<%=i%>');"
										onblur="checkMappedChargeIP(this.value,'<%=i%>');"										
		 />
		
	<%--	 <div id="ac2update3<%=i %>" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('proscedureName<%=i %>','ac2update3<%=i %>','ot?method=getInvestigationListForRequestionForIP',{parameters:'requiredField=proscedureName<%=i %>'});
			</script>--%> 
			<!-- changed by govind 14-10-2016 end -->
		<input type="hidden" name="procedureId<%=i %>" id="procedureId<%=i %>"	value="" />
		 
		
		</td>
		<%-- <td><input type="text" size="8" value="<%=date+"/"+month+"/"+year%>" name="tentativeDate<%=i%>" id="tentativeDate<%=i%>"
							validate="Date,date,no" />
							<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.inpatientSurgeryRequisition.tentativeDate1,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
							</td> --%>
		<td><select name="pacstatus<%=i%>" id="pacstatus<%=i%>">
		<option value="0">select</option>
		<option value="Pending">Pending</option>
		<option value="Cleared">Clear</option>
		<option value="Not Fit">Not Fit</option>
		</select>
		</td>
		
		<td><input type="checkbox" class="smalll" value="1" name="surgeryradio<%=i%>" id="surgeryradio<%=i%>" />
		<input type="hidden" name="<%=INPATIENT_ID %><%=i %>" value="<%=inpatient.getId() %>" validate="inpatientId,int,no" />
		<input type="hidden" name="<%=HIN_ID %><%=i %>" value="<%=inpatient.getHin().getId() %>" validate="hinId,int,no"/>
		</td>
	</tr>
	
	<%} %>
</table>
<input type="hidden" name="procCount" value="<%=i %>" id="procCount" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<!-- added by govind 14-10-2016 -->
<input type="hidden" id="admisDate" value="<%=admisDate%>"/>
<input type="hidden"  id="UHID" value="<%=UHID%>"/>
<input type="hidden"  id="patName" value="<%=patName%>"/>
<input type="hidden"  id="IPNo" value="<%=adNo%>"/>
<input type="hidden"  id="deptName" value="<%=deptName%>"/>
<input type="hidden"  id="<%=INPATIENT_ID %>" value="<%=inpatientId%>" validate="inpatientId,int,no" />
<input type="hidden"  id="<%=HIN_ID %>" value="<%=hinId%>" validate="hinId,int,no"/>
<!-- added by govind 14-10-2016 end -->
<div class="clear"></div>
<div class="paddingTop40"></div>
<input name="Submit" type="button" align="right" class="button" value="Save"
	onclick="submitSurgryRequisition();" />
<input type="reset" class="button" name="reset" value="reset" onclick="submitFormForButton('opSurgeryPlanning','opd?method=showSurgeryRequisitionJspFromPatientList1');"/>
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('opSurgeryPlanning','ipd?method=showPatientListJsp');"/>
<%} else{%>
<h4> No Patient Record Exist</h4>
<% 
}
%>



<div class="clear"></div>
<div class="paddingTop40"></div>
</form>
</div>
<div class="paddingTop40"></div>

<script type="text/javascript">
function getProcedureId(val,inc){
	if(val!=''){
		var index1 = val.indexOf("[");
		var index2 = val.indexOf("]");
		index1++;
		var procName = val.substring(0,index1-1);
		var procId = val.substring(index1,index2);
		
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var procCode = val.substring(index1,index2);
		document.getElementById('proscedureName'+inc).value=procName;
		document.getElementById('procedureId'+inc).value = procId;
		//document.getElementById('procedurecode'+inc).value = procCode;
		
		
	}else{
		if(document.getElementById('proscedureName'+inc)){
	      	document.getElementById('proscedureName'+inc).value="";
	      	document.getElementById('procedureId'+inc).value="";
	    	//document.getElementById('proDtId'+inc).value="";
	      //	document.getElementById('procRemarks'+inc).value="";
	      	//document.getElementById('procedurecode'+inc).value="";
			}
	}
	
}

function submitSurgryRequisition()
 {
	var countSurgery=document.getElementById("procCount").value;
	var selectedCount=0;
	for(var i=1;i<=countSurgery;i++)
		{
		if(document.getElementById("surgeryradio"+i)!=null){
		if(document.getElementById("surgeryradio"+i).checked)
			{
			selectedCount++;
			 document.getElementById("proscedureName"+i).setAttribute("validate", "Proscedure,metachar,yes");
			 document.getElementById("procedureId"+i).setAttribute("validate", "Proscedure,int,yes");
			// document.getElementById("tentativeDate"+i).setAttribute("validate", "Tentative Date,date,yes");
			 document.getElementById("pacstatus"+i).setAttribute("validate", "Pac Status,metachar,yes");
			}
		else
			{
			document.getElementById("proscedureName"+i).setAttribute("validate", "Proscedure,metachar,no");
			 document.getElementById("procedureId"+i).setAttribute("validate", "Proscedure,int,no");
			// document.getElementById("tentativeDate"+i).setAttribute("validate", "Tentative Date,date,no");
			 document.getElementById("pacstatus"+i).setAttribute("validate", "Pac Status,metachar,no");
			}
		}
		}
	if(selectedCount==0)
		{
		//alert("Please select at least one patient to submit"); //changed by govind
		alert("Please select at least one row to submit");
		return;
		}
	
	submitForm('inpatientSurgeryRequisition','opd?method=submitSurgeryRequisitionDetailsForInpatient');
	
	}
</script>

