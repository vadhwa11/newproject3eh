
<%@page import="jkt.hms.masters.business.OpdPatientSecondOpinion"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Second Opinion List</title>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
</head>
<body>
<%
 Map<String,Object> map = new HashMap<String,Object>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();

	if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("sexList") != null){
		sexList= (ArrayList) map.get("sexList");
	}
	List<OpdPatientSecondOpinion> patientsecondOpinion=new ArrayList<OpdPatientSecondOpinion>();
	if (map.get("patientsecondOpinion") != null) {
		patientsecondOpinion = (List<OpdPatientSecondOpinion>)map.get("patientsecondOpinion");
	}

%>
<form action="" name="patientSecondOpenoin" method="post">
<div class="Block">
	<% 
	if(null !=patientsecondOpinion && !patientsecondOpinion.isEmpty()){
		
	%>
<h2>Second Opinion List</h2>
<div class="clear"></div>
<div class="paddingTop5"></div>  
	  
<table id="" width="100%" border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #C0C0C0;">
 <thead>
		<tr>
			<th>UHID</th>
			<th>Patient Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Status</th>
		</tr>
	
	<%
	for(OpdPatientSecondOpinion secondOpinion : patientsecondOpinion){
		String name="";
		if(secondOpinion.getOpinionHin().getPFirstName()!=null){
			name=secondOpinion.getOpinionHin().getPFirstName();
		}
		if(secondOpinion.getOpinionHin().getPMiddleName()!=null){
			name=name+" "+secondOpinion.getOpinionHin().getPMiddleName();
		}
		if(secondOpinion.getOpinionHin().getPLastName()!=null){
			name=name+" "+secondOpinion.getOpinionHin().getPLastName();
		}
		%>
	<tr style="cursor: pointer;" onclick="populateSecondOpinionForm('<%=secondOpinion.getId() %>','<%=secondOpinion.getUhidNo()%>','<%=secondOpinion.getVisit().getId()%>')">
		
		<td ><%=secondOpinion.getPatientDetailsStatus()!=null && secondOpinion.getPatientDetailsStatus().equalsIgnoreCase("y")?secondOpinion.getUhidNo():"xxxxxxxxxxxxxxx"%></td>
		<td ><%=secondOpinion.getPatientDetailsStatus()!=null && secondOpinion.getPatientDetailsStatus().equalsIgnoreCase("y")?name:"xxxxxxxxxxxxxxx"%></td>
		<td ><%=secondOpinion.getOpinionHin().getSex().getAdministrativeSexName()%></td>
		<td ><%=HMSUtil.calculateAge(secondOpinion.getOpinionHin().getDateOfBirth())%></td>
		<td ></td>
		</tr>
		<%}
	}else{%>
			<h2>Record Not found</h2>
	<%} %>		
		
	</thead>
	</table>
	
<div class="clear"></div>
<div class="paddingTop5"></div> 

<div id="opinionId" style="display:none">

<label>Provisional Diagnosis</label>
<textarea id="provisionalDiagnosis" name="provisionalDiagnosis" readonly="readonly" cols="0" rows="0" maxlength="300" tabindex="1" style="display:none;width:345px;"></textarea>

<label>Final Diagnosis</label>
<textarea id="finalDiagnosis" name="finalDiagnosis" readonly="readonly" cols="0" rows="0" maxlength="300" tabindex="1" style="display:none;width:345px;"></textarea>
<div class="clear"></div>
<div class="clear"></div>	
<label>Doctor comments</label>
<textarea id="docnote" name="docnote" readonly="readonly" cols="0" rows="0" maxlength="300" tabindex="1" style="display:none;width:345px;"></textarea>

<label>Doctor Remark</label> 
<textarea id="docRemark" name="docRemark" cols="0" rows="0" maxlength="300" tabindex="1" style="display:none;width:345px;"></textarea>

<div class="clear"></div>
<div class="paddingTop5"></div>

<!-- <label>EHR</label> -->
	<input type="hidden" id="secondOpinionId" name="secondOpinionId"  value="" />
	<input type="hidden" id="secondOpinionVisitId" name="secondOpinionVisitId"  value="" />
	<input type="hidden" id="patientEharIdUhid" name="hin_no"  value="" />
	<input type="hidden" id="visitNoId" name="visitNo"  value="" />
	<input type="hidden" id="patientDetailsStatus" name="patientDetailsStatus"  value="" />
	
	<input type="hidden" id="hin_id" name="hin_id"  value="" />
	<input type="button" id="patientEharId" name="ehr"  onClick="submitForm('patientSecondOpenoin','enquiry?method=showPatientEpfJsp')"
	value="EHR" style="display:none;width:130px;"/>
	
	<!-- <label>Investigation</label> -->
	<input type="button" id="InvestigationId" name="Investigation"  onClick="submitForm('patientSecondOpenoin','opd?method=showPatientInvestigationReport')"
	value="Investigation" style="display:none;width:130px;"/>
	<!-- <div class="clear"></div> -->
	<!-- <label>Prescription Print</label> -->
	<input name="button2" type="button" align="right" class="buttonBig"	value="Prescription Print"	onclick="submitForm('patientSecondOpenoin','opd?method=showPatientPrescriptionReport');" />
	
	<!-- <label>Case Sheet</label> -->
	<input name="button2" type="button" align="right" style="width:130px;" value="Case Sheet"	onclick="submitForm('patientSecondOpenoin','opd?method=showPatientMedicalCaseSheetReportNew');" />
	
<div class="clear"></div>
<div class="paddingTop15"></div>

<input type="button" id="patientEharId" name="save"  onClick="saveData();" value="save" />

</div>
</div>
<script>
function callParent(){
	
	if(confirm("Updated Successfully!!")==true){
	//window.close();
	}
}

function saveData(){
	  
	var secondOpinionId=document.getElementById("secondOpinionId").value;
	var secondOpinionVisitId=document.getElementById("secondOpinionVisitId").value;
	var docRemark=document.getElementById("docRemark").value;
	  var xmlHttp=null;
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
	    	  var data=this.responseText;
		    	alert(data);
		    	window.close();
	      }
	    }

	       var url="/hms/hms/opd?method=updatSecondOpinionPatient&secondOpinionId="+secondOpinionId+"&secondOpinionVisitId="+secondOpinionVisitId+"&docRemark="+docRemark;
   	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("POST",url,false);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	  
}
</script>
 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
</body>
</html>









