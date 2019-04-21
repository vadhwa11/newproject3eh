<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PatientEpisode"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<html lang="hi" >
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientVisitSearch.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>

<%@page import="java.io.InputStream" %>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.text.SimpleDateFormat"%>

<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript" src="/hms/JavaScriptServlet">
</script> --%>
<script type="text/javascript">
/* var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />'; */
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>
<script type="text/javascript" src="/hms/jsp/js/csrfToken.js"></script>


<script src="/hms/jsp/js/dynamic-window-height/jquery.min.js"></script>
<!-- <title>EHA Hospital Management System</title> -->
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
	<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
	
	<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/jquery.min.js"></script>
	
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">

function expandCollaps(obj)
{
	if(obj.parentNode.getElementsByClassName("collaps").length>=1)
		{
		obj.parentNode.getElementsByTagName("img")[0].src="../jsp/images/minusIcon.gif";
		obj.parentNode.getElementsByClassName("collaps")[0].setAttribute("class", "expand");
		}
	else if(obj.parentNode.getElementsByClassName("expand").length>=1)
		{
		obj.parentNode.getElementsByTagName("img")[0].src="../jsp/images/plusIcon.gif";
		obj.parentNode.getElementsByClassName("expand")[0].setAttribute("class", "collaps");
		}
		
//alert(obj.parentNode.getElementsByClassName("collaps").length);	
 }
 
 
		function clearTestDivDown(flag,id,resultType,resultStatus,confidential){
			document.getElementById('testDivDown').innerHTML = "";
			if(flag == 'rhLab'){
				window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
			}
			if(flag == 'rdRadio'){
				//window.showModalDialog('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','dialogHeight=120,dialogWidth=120','dialogLeft=100,dialogTop=160,dialogHeight=120,dialogWidth=120,,status=2,scrollbars=1,resizable=0,center=1');
				window.open('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
			}
			if(flag == 'rhSenLab'){
				window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=25,top=160,height=400,width=970,status=1,scrollbars=1,resizable=1');
				//submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'','testDivDown');
			}
			if(flag == 'rEntryDetailLab'){
				if(resultType == 's'){
					window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');
				}else{
					window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
				}
			}
		}
	function submitResultPrintAfterValidation(){
		var flag = validateRadioForOrderNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			printId.setAttribute("type","submit");
			submitForm('patientAndAdDetails','/hms/hms/lab?method=printOrderStatusReport');
		}
	}
	function fillOrderNo(printValueObj){
		document.getElementById('orderNoIdForReport').value = printValueObj.value;
	}
	</script>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<Visit> visitList = new ArrayList<Visit>();
		List<PatientEpisode> patientEpisodeList = new ArrayList<PatientEpisode>(); // added by amit das on 06-09-2016
		String diagnosis="";
		String diagnosisName="";
		int episodeId = 0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("diagnosis")!=null){
			diagnosis=(String)map.get("diagnosis");
		}
		if(map.get("visitList") != null)	{
			visitList = (List<Visit>)map.get("visitList");
		}
		if(map.get("inPatientList") != null){
			inPatientList =(List<Inpatient>)map.get("inPatientList");
		}
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		
		// addded by amit das on 06-09-2016
		if(map.get("patientEpisodeList") != null){
			patientEpisodeList=(List<PatientEpisode>)map.get("patientEpisodeList");
		} 
		
		// addded by amit das on 06-09-2016
		if(map.get("episodeId") != null){
			episodeId=(Integer)map.get("episodeId");
		} 
		
		
				
		Patient patient=patientList.get(0);
		String patientName="";
		if(patient.getPFirstName()!= null){
			patientName=patient.getPFirstName();
			}
			if(patient.getPMiddleName()!= null){
			patientName=patientName+" "+patient.getPMiddleName();
			}
			if(patient.getPLastName()!= null){
			patientName=patientName+" "+patient.getPLastName();
			}
		String  age=patient.getAge();	
		String gender=patient.getSex().getAdministrativeSexName();
		String hisUrl=null;
		if(map.get("historyUrl")!=null){
			hisUrl=map.get("historyUrl").toString();
		}
		  
		int currentVisitId=0;
		if(map.get("currentVisitId")!=null){
			currentVisitId=(Integer)map.get("currentVisitId");
		}
		System.out.println("currentVisitId -------->>>"+currentVisitId);
	%>
<div class="Block">

	<label>Patient Name</label><input type="text" value="<%=patientName %>"  readonly="readonly" />
     <label>Age</label><input type="text" class="dateTextSmall" value="<%=age!=null && !age.equals("")?age:"" %>"  readonly="readonly" />
	 <label>Gender</label><input type="text"  class="dateTextSmall" value="<%=gender %>"  readonly="readonly" />
     <div class="clear"></div>
     <label>Past Episodes</label>
	<select name="episodeList"	id="episodeList" size="1" onchange="getPatientVisitsByEpisode(this);">
					 	<option value="0">Select</option>
					 	<% for(PatientEpisode patientEpisode : patientEpisodeList) { 
					 		if(episodeId==patientEpisode.getId()){
					 		%>
					 		<option selected="selected" value="<%=patientEpisode.getId()%>">(<%=patientEpisode.getEpisodeNumber()%>)<%=patientEpisode.getEpisodeName()%></option>
					 	<% } else { %>
					 		<option value="<%=patientEpisode.getId()%>">(<%=patientEpisode.getEpisodeNumber()%>)<%=(patientEpisode.getEpisodeName()!=null)?patientEpisode.getEpisodeName():""%></option>
					 	
					 	<%} }%>
	</select>
</div>	
<form name="patientAndAdDetails" action="" method="post">
<script type="text/javascript">
	function getAdVisitDetails(){
		
	if(document.getElementById('detailId').value =="Admission"){

			submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAdVisitDetails&id='+document.getElementById('opOrId').value);
	}
		submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAllEnquiry&opOrString='+document.getElementById('opOrString').value+'&detailId='+document.getElementById('detailId').value+'&id='+document.getElementById('opOrId').value+'&hinId='+document.getElementById('hinId').value+'&adVisitNo='+document.getElementById('adVisitNo').value)
	}
	function displayAdNo(id,opOrString,extPara,adVisitNo){
		//alert("id-->>"+id)
		document.getElementById('opOrId').value=id;
		document.getElementById('adVisitNo').value=adVisitNo;
		
		//alert("id -->>"+id);
		//alert("opOrString ----- --->>"+opOrString)
		if(opOrString =="0"){
			 	document.getElementById('opOrString').value ="IP"
				document.getElementById('hinId').value=0
        		obj =document.getElementById("detailId");
				obj.length = 0;
	        	obj.length++;
				obj.options[obj.length-1].value="Admission"
				obj.options[obj.length-1].text="Admission";
				obj.length++;
			 
				obj.options[obj.length-1].value="Diagnostics"
					obj.options[obj.length-1].text="Case Note/Diagnosis";
					obj.length++;
				obj.options[obj.length-1].value="Prescriptions"
				obj.options[obj.length-1].text="Treatment";
				obj.length++;
				obj.options[obj.length-1].value="Investigation"
				obj.options[obj.length-1].text="Investigation";
				obj.length++;
				obj.options[obj.length-1].value="Procedures"
				obj.options[obj.length-1].text="Procedures";
			submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAdVisitDetails&id='+document.getElementById('opOrId').value);
		}else{
			document.getElementById('opOrString').value ="OP"
				document.getElementById('hinId').value=extPara
			obj =document.getElementById("detailId");
				obj.length = 0;
	        	obj.length++;
				obj.options[obj.length-1].value="Visit"
				obj.options[obj.length-1].text="Visit";
				
				obj.length++;
				obj.options[obj.length-1].value="diag"
				obj.options[obj.length-1].text="Diagnosis";
				
				obj.length++;
				obj.options[obj.length-1].value="Investigation"
				obj.options[obj.length-1].text="Investigation";
			
				obj.length++;
				obj.options[obj.length-1].value="Prescriptions"
				obj.options[obj.length-1].text="Prescriptions";
				obj.length++;
				obj.options[obj.length-1].value="Procedures"
				obj.options[obj.length-1].text="Procedures";
				
				obj.length++;
				obj.options[obj.length-1].value="Vitals"
				obj.options[obj.length-1].text="Vitals";
				
				obj.length++;
				obj.options[obj.length-1].value="pre-opc"
				obj.options[obj.length-1].text="Pre-Consultation";
				
				obj.length++;
				obj.options[obj.length-1].value="examination"
				obj.options[obj.length-1].text="Examination";
				
				
				submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAllEnquiry&currentVisitId='+<%=currentVisitId%>+'&opOrString='+document.getElementById('opOrString').value+'&detailId=Visit'+'&id='+document.getElementById('opOrId').value+'&visitId ='+id+'&adVisitNo='+document.getElementById('adVisitNo').value)
		}
	}
	
	</script>
<div class="titleBg">
<h2>Patient History and Details</h2>
</div>
<div class="clear"></div>

<input name="opOrString" id="opOrString" type="hidden" /> <input
	name="opOrId" id="opOrId" type="hidden" /><input
	name="adVisitNo" id="adVisitNo" type="hidden" /> <input name="hinId"
	id="hinId" type="hidden" value="0" />	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


<!-- added by amit das on 12-09-2016 -->
<input name="hinNo" id="hinNo" type="hidden" value="<%=patient.getHinNo()%>" />
<input name="visitId" id="visitId" type="hidden" value="<%=currentVisitId%>" />
<!-- ended by amit das on 12-09-2016 -->


</form>
	
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div class="Blockdiv1- floatLeft-"  id="searchtable" tabindex=2></div>
<form name="patientAndAdDetailsGrid" method="post" action="">
<script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1,"<%= RADIO_FOR_TABLE%>"] [2,"Status"], [3,"AdVisit"], [4,"Date"], [5,"Time"], [6,"Doctor"], [7,"Diagnosis"], [8,"DisDate"], [9,"DisTime"], [10,"Department"], [11,"Hospital"], [12,"Dsscs"], [12,"Speciality"]];
	 statusTd = 10;
	</script>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
	</form>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Details</h4>
<div class="clear"></div>
<div id="status2" style="display: none"></div>
<div id="status1"><select name="<%=ADMISSION_STATUS %>" id="detailId"  onchange="getAdVisitDetails();">
	<option value="">Select</option>
</select></div>
<div class="clear"></div>
<div id="testDiv"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="b" value="Go Back" class="button"	onClick="window.close();" />
 <%if(hisUrl!=null){%>  
 <input type="button" name="History" value="History" class="button"	onClick="popwindowresultHistory('<%=hisUrl%>')" />  
  <%}%>  
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript" language="javascript">
	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "radio";
	data_header[0][2] = "1%";
	data_header[0][3] = "<%=RADIO_FOR_TABLE%>"

	data_header[1] = new Array;
	data_header[1][0] = "Status"
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "servNo"

	data_header[2] = new Array;
	data_header[2][0] = "IPD No./Visit No"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "hin";

	data_header[3] = new Array;
	data_header[3][0] = "Date"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "patName";

	data_header[4] = new Array;
	data_header[4][0] = "Time"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "serviceType"

	data_header[5] = new Array;
	data_header[5][0] = "Doctor"
	data_header[5][1] = "data";
	data_header[5][2] = "15%";
	data_header[5][3] = "sPersonName";
	
	
	data_header[6] = new Array;
	data_header[6][0] = "Diagnosis"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "Diagnosis";
	

	data_header[7] = new Array;
	data_header[7][0] = "Dis Date"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "rank";

	data_header[8] = new Array;
	data_header[8][0] = "Dis Time"
	data_header[8][1] = "data";
	data_header[8][2] = "10%";
	data_header[8][3] = "unit";
	
	data_header[9] = new Array;
	data_header[9][0] = "Department"
	data_header[9][1] = "data";
	data_header[9][2] = "10%";
	data_header[9][3] = "Department"
	
	data_header[10] = new Array;
	data_header[10][0] = "Hospital"
	data_header[10][1] = "data";
	data_header[10][2] = "10%";
	data_header[10][3] = "Hospital"
	
	data_header[11] = new Array;
	data_header[11][0] = "Dis Summary/Case Sheet"
	data_header[11][1] = "data";
	data_header[11][2] = "10%";
	data_header[11][3] = "Dsscs"
	
	data_header[12] = new Array;
	data_header[12][0] = "Speciality"
	data_header[12][1] = "data";
	data_header[12][2] = "10%";
	data_header[12][3] = "Dsscs"
	

	data_arr = new Array();
	<%	String opOrString ="0";
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) {
			String previousDiagnosis =null;%>
	<% 	for(Inpatient inpatient : inPatientList){
		previousDiagnosis =null;
		if(inpatient.getOpdPatientDetails()!=null){
	 	
		if(inpatient.getOpdPatientDetails().getProvisionalDiagnosis()!=null)
			previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"[P] "+inpatient.getOpdPatientDetails().getProvisionalDiagnosis():"[P] "+inpatient.getOpdPatientDetails().getProvisionalDiagnosis();
			if(inpatient.getOpdPatientDetails().getFinalDiagnosis()!=null)
				previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"[F] "+inpatient.getOpdPatientDetails().getFinalDiagnosis():"[F] "+inpatient.getOpdPatientDetails().getFinalDiagnosis();
			if(inpatient.getOpdPatientDetails().getInitialDiagnosis()!=null)
				previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"[O] "+inpatient.getOpdPatientDetails().getInitialDiagnosis():"[O] "+inpatient.getOpdPatientDetails().getInitialDiagnosis();		
		}
	
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio" id="parent" name="parent" value="<%= inpatient.getId()%>" id="parent" onclick="displayAdNo(<%=inpatient.getId()%>,<%=opOrString%>,<%=opOrString%>,<%=inpatient.getAdNo()%>)" />'
			data_arr[<%= counter%>][2] = "IP"
			data_arr[<%= counter%>][3] = "<%=inpatient.getAdNo()%>"
			<%String admDate ="";
			SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
			 admDate=formatterOut.format(formatterIn.parse(""+inpatient.getDateOfAddmission()));
			 %>
			data_arr[<%= counter%>][4] = "<%=admDate%>"
			data_arr[<%= counter%>][5] = "<%=inpatient.getTimeOfAddmission()%> "
				<%
				   String inDoctName=inpatient.getDoctor().getFirstName();
					if(inpatient.getDoctor().getMiddleName()!=null)
					{
						inDoctName = inDoctName+" "+inpatient.getDoctor().getMiddleName();
					}
					if(inpatient.getDoctor().getLastName()!=null){
						inDoctName = inDoctName+" "+inpatient.getDoctor().getLastName();
					}
				%>
			data_arr[<%= counter%>][6] = "<%=inDoctName%> "
			<%if(diagnosis!=null||(!diagnosis.equals(""))){%>
			data_arr[<%= counter%>][7] = "<%=diagnosis%> "
				<%}else{%>
				data_arr[<%= counter%>][7] = " "
				<%}%>
				data_arr[<%= counter%>][7] = "<%=diagnosis%> "
			<%if(inpatient.getDischargeDate() !=null){%>
			<%String disDate ="";
			SimpleDateFormat formatterIn2 = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat formatterOut2 = new  SimpleDateFormat("dd/MM/yyyy");
			 disDate=formatterOut2.format(formatterIn2.parse(""+inpatient.getDischargeDate()));
			 %>
			data_arr[<%= counter%>][8] = "<%=disDate%> "
			<%}else{%>
			data_arr[<%= counter%>][8] = "-"
			<%}%>
			<%if(inpatient.getDischargeTime() !=null){%>
			data_arr[<%= counter%>][9] = "<%=inpatient.getDischargeTime()%> "
			<%}else{%>
				data_arr[<%= counter%>][9]="-"
			<%}%>
				data_arr[<%= counter%>][10] = "<%=inpatient.getDepartment().getDepartmentName()%>"
				data_arr[<%= counter%>][11] = "<%=inpatient.getHospital().getHospitalName()%> "
					data_arr[<%= counter%>][12] = '<input type="button" id="parent" name="parent" value="Discharge Summary" id="parent" onclick="displayDischargeSummary(<%=inpatient.getAdNo()%>,<%=inpatient.getHospital().getId()%>);" />'
						data_arr[<%= counter%>][13] =" "
				<%counter++;}
	}%>

		<%
		try{
			opOrString="1";
	    int  counter2=counter;
		if (visitList != null && visitList.size() > 0) {
			 String previousDiagnosis =null;
			%>
	<% 	for(Visit visit : visitList){
		
		previousDiagnosis =null;
		if(visit.getOpdPatientDetails().size()>0){
	 	OpdPatientDetails op =((OpdPatientDetails)(visit.getOpdPatientDetails().toArray()[0]));
		if(op.getProvisionalDiagnosis()!=null)
			previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"[P] "+op.getProvisionalDiagnosis():"[P] "+op.getProvisionalDiagnosis();
			if(op.getFinalDiagnosis()!=null)
				previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"[F] "+op.getFinalDiagnosis():"[F] "+op.getFinalDiagnosis();
			if(op.getInitialDiagnosis()!=null)
				previousDiagnosis = previousDiagnosis!=null?previousDiagnosis+"[O] "+op.getInitialDiagnosis():"[O] "+op.getInitialDiagnosis();		
		}
			diagnosisName=HMSUtil.getdiagNosis(visit.getId());
	%>
	  		data_arr[<%= counter2%>] = new Array();
			data_arr[<%= counter2%>][0] = <%= visit.getId()%>
			data_arr[<%= counter2%>][1] = '<input type="radio" id="parent" name="parent" value="<%= visit.getHin().getId()%>" onclick="displayAdNo(<%=visit.getId()%>,<%=opOrString%>,<%=visit.getHin().getId()%>,<%=visit.getVisitNo()%>)" />'
			data_arr[<%= counter2%>][2] = "OP"
			data_arr[<%= counter2%>][3] = "<%=visit.getVisitNo()%>"
			<%
			String visitDate ="";
			String departmentName="";
			String hospitalName="";
			SimpleDateFormat formatterIn3 = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat formatterOut3 = new  SimpleDateFormat("dd/MM/yyyy");
			 visitDate=formatterOut3.format(formatterIn3.parse(""+visit.getVisitDate()));
			 %>
			data_arr[<%= counter2%>][4] = "<%=visitDate%>  "
			data_arr[<%= counter2%>][5] = "<%=visit.getVisitTime()%> "
		<%
			String visitDoctName ="";
			if(visit.getDoctor()!=null)
			{
				visitDoctName = visitDoctName+" "+visit.getDoctor().getFirstName();
			}
			
			if(visit.getDoctor()!=null)
			{
				visitDoctName = visitDoctName+" "+visit.getDoctor().getMiddleName();
			}
			if(visit.getDoctor()!=null)
			{
				visitDoctName = visitDoctName+" "+visit.getDoctor().getLastName();
			}
			if(visit.getDepartment()!=null)
			{
				departmentName = visit.getDepartment().getDepartmentName();
			}
			
			if(visit.getHospital() !=null)
			{
				hospitalName= visit.getHospital().getHospitalName();
			}
	      %>
			data_arr[<%= counter2%>][6] = "<%=visitDoctName%> "
			
				data_arr[<%= counter2%>][7] = "<%=previousDiagnosis!=null?previousDiagnosis:""%> "
				
			<%if(visit.getAddEditDate() !=null){%>
			data_arr[<%= counter2%>][8] = "<%=HMSUtil.convertDateToStringWithoutTime(visit.getAddEditDate())%>"
			<%}else{%>
			data_arr[<%= counter2%>][8] = ""
			<%}%>
			<%if(visit.getAddEditTime() !=null){%>
				data_arr[<%= counter2%>][9] = "<%=visit.getAddEditTime()%>"
			<%}else{%>
				data_arr[<%= counter2%>][9]=""
			<%}%>
			
			data_arr[<%= counter2%>][10]="<%=departmentName%>"
			
			data_arr[<%= counter2%>][11]="<%=hospitalName%>"
			data_arr[<%= counter2%>][12] = '<input type="button" id="parent" name="parent" value="Case Sheet" onclick="displayCaseSheetReport(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getHospital().getId()%>)" />'
			<%
			Set<OpdPatientDetails> opdPatientDetailsSet = new HashSet<OpdPatientDetails>();
			if(visit.getOpdPatientDetails() != null){
				opdPatientDetailsSet = visit.getOpdPatientDetails();
				if(opdPatientDetailsSet.size()>0){
				  for(OpdPatientDetails opdPatientDetails :opdPatientDetailsSet){	
					if(opdPatientDetails.getTemplateName() != null){
			%>
			data_arr[<%= counter2%>][13] = '<input type="button" id="parent" name="parent" value="Speciality" onclick="displaySpecialityReport(<%=visit.getId()%>,<%=visit.getVisitNo()%>,<%=visit.getHospital().getId()%>,<%=opdPatientDetails.getId()%>)" />'
			<%}else{%>
			 data_arr[<%= counter2%>][13] = ""; 
			
			<%}}}else{%>
			 data_arr[<%= counter2%>][13] = ""; 
			<%}}%>
			

			<%counter2++;
		}
	      }
		}catch(Exception ee ){
			ee.printStackTrace();
		}
				%>
    formName = "patientAndAdDetailsGrid" 

	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;

	}

	makeTable(start,end);

	</script>

<div class="PaddingTop40"></div>
<script type="text/javascript">
function popwindowresult(url)
{  
 newwindow=window.open(url,'name','height=700,width=850,scrollbars=1');
 if (window.focus) 
 {
 newwindow.focus();
 }
 newwindow.createPopup();
}
function popwindowresultHistory(url)
{  
 newwindow=window.open(url,'name','height=700,width=850,scrollbars=1');
 if (window.focus) 
 {
 newwindow.focus();
 }
 newwindow.createPopup();
}
/* function saveClinicalObservation(dgHeaderId,inc){
alert("clinicalObservation=="+document.getElementById('observationId'+inc).value);
var clinicalObservation = document.getElementById('observationId'+inc).value;
ajaxFunctionForClinicalObservation('patientAndAdDetailsGrid','enquiry?method=saveClinicalObservation&dgHeaderId='+dgHeaderId+'&clinicalObservation='+clinicalObservation );
}   */
function saveClinicalObservation(dgHeaderId,chargeCodeId,inc) {
//	alert("flag ----  -->>"+flag)
var flag;
var clinicalObservation = document.getElementById('observationId'+inc).value;
var observationId2=document.getElementById('observationId2'+inc).value;
var observationId3=document.getElementById('observationId3'+inc).value;
var observationId4=document.getElementById('observationId4'+inc).value;
var observationId5=document.getElementById('observationId5'+inc).value;
	if(document.getElementById('observationId'+inc).disabled==false && document.getElementById('observationId'+inc)!=null && document.getElementById('observationId'+inc).value!=''){
		flag='1';
	}else if(document.getElementById('observationId2'+inc).disabled==false && document.getElementById('observationId2'+inc)!=null && document.getElementById('observationId2'+inc).value!=''){
		flag='2';
	}else if( document.getElementById('observationId3'+inc).disabled==false && document.getElementById('observationId3'+inc)!=null && document.getElementById('observationId3'+inc).value!=''){
		flag='3';
	}else if(document.getElementById('observationId4'+inc).disabled==false && document.getElementById('observationId4'+inc)!=null && document.getElementById('observationId4'+inc).value!=''){
		alert("flag 4 --->>"+document.getElementById('observationId4'+inc));
		flag='4';
	}else if(document.getElementById('observationId5'+inc).disabled==false && document.getElementById('observationId5'+inc)!=null && document.getElementById('observationId5'+inc).value!=''){
		flag='5';
	}
	
	alert("flag ----  -->>"+flag)
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
      	if(items.childNodes.length!=0){
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var information = items.childNodes[loop];
	        var message  = information.getElementsByTagName("message")[0];
	        alert(message.childNodes[0].nodeValue)
	        }
	        }

 	}
 }
if(flag==1){
    url="enquiry?method=saveClinicalObservation&dgHeaderId="+dgHeaderId+"&clinicalObservation="+clinicalObservation+"&chargeCodeId="+chargeCodeId+'&flag='+flag;
}else if(flag==2){
	url="enquiry?method=saveClinicalObservation&dgHeaderId="+dgHeaderId+"&clinicalObservation="+observationId2+"&chargeCodeId="+chargeCodeId+'&flag='+flag;
}else if(flag==3){
	url="enquiry?method=saveClinicalObservation&dgHeaderId="+dgHeaderId+"&clinicalObservation="+observationId3+"&chargeCodeId="+chargeCodeId+'&flag='+flag;
}else if(flag==4){
	url="enquiry?method=saveClinicalObservation&dgHeaderId="+dgHeaderId+"&clinicalObservation="+observationId4+"&chargeCodeId="+chargeCodeId+'&flag='+flag;
}else if(flag==5){
	url="enquiry?method=saveClinicalObservation&dgHeaderId="+dgHeaderId+"&clinicalObservation="+observationId5+"&chargeCodeId="+chargeCodeId+'&flag='+flag;
}

	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
 }

</script>

<script>
function displayDischargeSummary(adNo,hinNo){
//	alert(hinNo);
	submitForm('patientAndAdDetailsGrid','/hms/hms/discharge?method=showDischargeSummaryRepor2t&hospitalId='+hinNo+'&admissionNumber='+adNo);
}

// added by amit das on 12-09-2016
function getPatientVisitsByEpisode(i){
	var episodeId = i.options[i.selectedIndex].value;
	submitForm('patientAndAdDetails','/hms/hms/enquiry?method=showPatientDetails&episodeId='+episodeId);
}

</script>

<script>
function displayCaseSheetReport(visitId,visitNo,hospital){
	//alert("a----->>"+visitId+"<-----b------>>"+visitNo+"<-------c-------><-------d------>>"+hospital);
	submitForm('patientAndAdDetailsGrid','/hms/hms/opd?method=showPatientMedicalCaseSheetReportNew&visitId='+visitId+'&visitNo='+visitNo+'&hospitalId='+hospital);
}

function displaySpecialityReport(visitId,visitNo,hospital,opdPatientDetailId){
	submitForm('patientAndAdDetailsGrid','/hms/hms/opd?method=showPatientSpecialityReportForPreviousVisit&visitId='+visitId+'&visitNo='+visitNo+'&hospitalId='+hospital+'&opdPatientDetailId='+opdPatientDetailId);
}

//added by govind 2017-05-25
function saveOutsideLab(orderId,chargeCode,count){
	//alert("count "+count);
	outsideLab=document.getElementById("outsideLab"+count).value;
	outsideLabName=document.getElementById("outsideLabName"+count).value;
	outsideLabValue=document.getElementById("outsideLabValue"+count).value;
	submitForm('patientAndAdDetailsGrid','opd?method=submitOutsideLab&orderId='+orderId+'&chargeCode='+chargeCode+'&count='+count+
			"&outsideLab="+outsideLab+"&outsideLabName="+outsideLabName+"&outsideLabValue="+outsideLabValue);
	window.close();
}

function showSaveOutsideDiv(count){	
//alert("showSaveOutsideDiv count "+count);
		if(document.getElementById("outsideLab"+count).checked==true){

			document.getElementById("outsideLabName"+count).style.display='block';
			document.getElementById("outsideLabValue"+count).style.display='block';
			document.getElementById("saveBut"+count).style.display='block';
		}else{
			document.getElementById("outsideLabName"+count).style.display='none';
			document.getElementById("outsideLabValue"+count).style.display='none';
			document.getElementById("saveBut"+count).style.display='none';
		}
}
//added by govind 2017-05-25

</script>