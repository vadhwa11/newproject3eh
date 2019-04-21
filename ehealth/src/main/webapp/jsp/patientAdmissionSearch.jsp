<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientAdmissionSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="jkt.hms.masters.business.DialysisSchudeling"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
 
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	
	/*<!-- commented by mritunjay Kumar Singh  on 12/03/2015  -->*/
	/* errorMsg=errorMsg+document.getElementById("pMName").value;
	errorMsg=errorMsg+document.getElementById("pLName").value; */
	
	errorMsg=errorMsg+document.getElementById("mobilNo").value;
	errorMsg=errorMsg+document.getElementById("doctorName").value;
	errorMsg=errorMsg+document.getElementById("department").value;
	errorMsg=errorMsg+document.getElementById("admdepartment").value;
	<%--
	errorMsg=errorMsg+document.getElementById("serviceNo").value;
	errorMsg=errorMsg+document.getElementById("sFName").value;
	errorMsg=errorMsg+document.getElementById("sMName").value;
	errorMsg=errorMsg+document.getElementById("sLName").value;
		if(document.getElementById("serviceTypeId").value !=0)
	errorMsg=errorMsg+document.getElementById("serviceTypeId").value;
		if(document.getElementById("rankId").value !=0)
	errorMsg=errorMsg+document.getElementById("rankId").value;
		if(document.getElementById("unitId").value !=0)
	errorMsg=errorMsg+document.getElementById("unitId").value;
	--%>
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>

<form name="patientAdmissionSearch" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();

// 		Map<String, Object> patientMap = new HashMap<String, Object>();
		//List<MasRank> rankList = new ArrayList<MasRank>();
		//List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		//List<MasUnit> unitList = new ArrayList<MasUnit>();
// 		List<Patient> patientList = new ArrayList<Patient>();
        List<OpdPatientDetails> patientList = new ArrayList<OpdPatientDetails>();
        List<Object[]> doctorList = new ArrayList<Object[]>();
        List<PatientAddress> patientAddress = new ArrayList<PatientAddress>();
        List<MasDepartment> masDepartments = new ArrayList<MasDepartment>();
        List<MasDepartment> referringDepartment = new ArrayList<MasDepartment>();
        List<DialysisSchudeling>dialysisSchedulingList = new ArrayList<DialysisSchudeling>();
        List<Patient> patientBabyAdmissionWaitingList = new ArrayList<Patient>();
        List<Patient> directPatientBabyList = new ArrayList<Patient>();
        
       
        if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		/* if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		} */
		if(map.get("patientList") != null){
			patientList= (List<OpdPatientDetails>)map.get("patientList");
		}
		if(map.get("patientBabyAdmissionWaitingList") != null){
			patientBabyAdmissionWaitingList= (List<Patient>)map.get("patientBabyAdmissionWaitingList");
		}
		
		if(map.get("directPatientBabyList") != null){
			directPatientBabyList= (List<Patient>)map.get("directPatientBabyList");
		}
		System.out.println("directPatientBabyList-jsp--"+directPatientBabyList.size());
		if(map.get("patientAddress") != null){
			patientAddress= (List<PatientAddress>)map.get("patientAddress");
		}
		//added by dhananjay
		 List<Patient> ipPatientList=new ArrayList<Patient>();
		if(map.get("ipPatientList") != null){
			ipPatientList= (List<Patient>)map.get("ipPatientList");
		}
		//end
		if(map.get("doctorList") != null){
			doctorList= (List<Object[]>)map.get("doctorList");
		}
		if(map.get("masDepartments") != null){
			masDepartments= (List<MasDepartment>)map.get("masDepartments");
		}
		
		if(map.get("referringDepartment") != null){
			referringDepartment= (List<MasDepartment>)map.get("referringDepartment");
		}
		if(map.get("dialysisSchedulingList") != null){
			dialysisSchedulingList= (List<DialysisSchudeling>)map.get("dialysisSchedulingList");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		String hinIdMother="";
		if(map.get("hinIdMother") != null){
			hinIdMother= (String)map.get("hinIdMother");
		}
		String hinNo = null;
		String patientFName = null;
		String mobileNo = null;
		String doctorId = null;
		String departmentId = null;
		String admDepartmentId = null;
		
		if(map.get(HIN_NO) != null){
			hinNo = (String)map.get(HIN_NO);
		}
		
		if(map.get(P_FIRST_NAME) != null){
			patientFName = (String)map.get(P_FIRST_NAME);
		}
		
		if(map.get(MOBILE_NO) != null){
			mobileNo = (String)map.get(MOBILE_NO);
		}
		
		if(map.get(DOCTOR_NAME) != null){
			 doctorId = (String)map.get(DOCTOR_NAME);
		}
		
		if(map.get(DEPARTMENT_ID) != null){
			departmentId = (String)map.get(DEPARTMENT_ID);
		}
		
		if(map.get("admDepartmentId") != null){
			admDepartmentId = (String)map.get("admDepartmentId");
		}
		
		
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	</script>
	<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 21 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="titleBg">
<h2>Pending Ip Admission</h2>
</div>
<div class="Block">
<label><%=prop.getProperty("com.jkt.hms.uhid") %></label> 

<input type="text" name="<%=HIN_NO %>" value="<%=hinNo!=null?hinNo:""%>" MAXLENGTH="50" id="hinNo" validate="hinNo,metachar,no" onblur="if(this.value!=''){submitForm('patientAdmissionSearch','/hms/hms/adt?method=showAdmissionJsp');}" />

<!-- commented by mritunjay Kumar Singh  on 12/03/2015  -->
<%-- <label> First Name</label> 
<input type="text" name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" id="pFName" /> 
<label>Middle Name</label> 
<input type="text" name="<%=P_MIDDLE_NAME %>" value="" MAXLENGTH="15" id="pMName" />
<div class="clear"></div>
<label>Last Name</label> 
<input type="text" name="<%=P_LAST_NAME%>" value="" MAXLENGTH="15" id="pLName" /> --%>
<label>Patient Name</label> 

<input type="text" name="<%=P_FIRST_NAME %>" value="<%=patientFName!=null?patientFName:""%>" MAXLENGTH="15" id="pFName" validate="Patient Name,metachar,no"/> 

<label>Mobile No. </label> 

<input type="text" name="<%=MOBILE_NO %>" value="<%=mobileNo!=null?mobileNo:""%>" MAXLENGTH="10" id="mobilNo" validate="Mobile No.,metachar,no"/>

<div class="clear"></div>
<label>Admitting Doctor</label> 

<select name="<%=DOCTOR_NAME%>" id="doctorName" validate="doctorName,metachar,no">
<option value="">
select
</option>
<%
for(Object[] employee:doctorList)
{
	String pName="";
	if(employee[1]!=null && !employee[1].equals("")) 
	{
		pName+=employee[1];
		if(employee[2]!=null &&!employee[2].equals("")) 
		{
			pName+=" "+employee[2];
		}
		
		if(employee[3]!=null &&!employee[3].equals("") )
		{
			pName+=" "+ employee[3];
		}
		
	%>

	
	<option value="<%=employee[0]%>" <%=!StringUtils.isBlank(doctorId)&& employee[0].equals(Integer.parseInt( doctorId))?"selected":"" %>><%=pName%></option>
	<%
	}
}
%>
</select>

<label>Admitting Department</label> 
<select name="<%=DEPARTMENT_ID%>" id="department" validate="department,metachar,no">
<option value="">Select</option>
<%for(MasDepartment department:masDepartments) {
%>

<option value="<%=department.getId()%>" <%=!StringUtils.isBlank(departmentId)&& Integer.parseInt(departmentId)==department.getId()?"selected":"" %>><%=department.getDepartmentName()%></option>
<% }%>
</select>

<label>Referring Department</label> 
<select name="admdepartment" id="admdepartment" validate="department,metachar,no">
<option value="">Select</option>
<%for(MasDepartment department:referringDepartment) {
%>

<option value="<%=department.getId()%>" <%=!StringUtils.isBlank(admDepartmentId)&& Integer.parseInt(admDepartmentId)==department.getId()?"selected":"" %>><%=department.getDepartmentName()%></option>
<% }%>
</select>
<div class="clear"></div>
		<input type="button" name="search" id="addbutton"
			onclick="if(checkBlankSearch()){submitForm('patientAdmissionSearch','/hms/hms/adt?method=showAdmissionJsp');}"
			value="Search" class="button" accesskey="a" />
	</div>

<%-- <input type="text" name="<%=DOCTOR_NAME%>" value="" MAXLENGTH="15" id="doctorName" />
 --%>


<%--
			<br />
			<label class="bodytextB1">Service No:</label> 
			<input type="text" name="<%=SERVICE_NO %>" value="" class="textbox_size20" MAXLENGTH="20" id="serviceNo"/>		

			<label class="bodytextB1">Ser. First Name:</label>
			<input type="text" name="<%=S_FIRST_NAME %>"  value="" class="textbox_size20" MAXLENGTH="15" id="sFName"/>
	 				
			<label class="bodytextB1">Ser. Mid Name:</label> 
			<input type="text" name="<%=S_MIDDLE_NAME %>"  value="" class="textbox_size20" MAXLENGTH="15" id="sMName"/>
			<label class="bodytextB1">Ser. Last Name:</label> 
			<input type="text" name="<%=S_LAST_NAME%>"  value="" class="textbox_size20" style="width: 110px;" MAXLENGTH="15" id="sLName"/>
			<br />
				<br />	
	 		<label	class="bodytextB1">Service Type:</label>
			<select name="<%=SERVICE_TYPE_ID %>" class="NewSelectBox" id="serviceTypeId">
			<option value="0"><--Select Ser Type--></option>						
			<% 
			for(MasServiceType masServiceType : serviceTypeList)
			{
			%>
			<option value="<%=masServiceType.getId()%>" ><%=masServiceType.getServiceTypeName()%></option>
			<%
			}
			%>
			</select>	
			<label	class="bodytextB1">Rank:</label>
			<select name="<%=RANK_ID %>" class="NewSelectBox" id="rankId">
			<option value="0"><--Select Rank--></option>						
			<% for(MasRank masRank : rankList)
			{
			%>
			<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
			<%
			}
			%>
			</select>
								
	 		<label	class="bodytextB1">Unit:</label>
			<select name="<%=UNIT_ID %>" class="NewSelectBox" id="unitId">
				<option value="0"><--Select Unit--></option>						
				<%
				for(MasUnit masUnit : unitList)
				{
				%>
				<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
				<%
				}
				%>
			</select>
 	     <br/>
 	     --%>


<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<div class="clear"></div>

<%--
<%String msg ="";
if (patientList != null && serviceNoOrHinNo.equalsIgnoreCase("yes")) {
for(Patient patient2 : patientList){
if(patient2.getPatientStatus().equals("In Patient")){
msg=patient2.getPFirstName()+" "+patient2.getPMiddleName()+" "+patient2.getPLastName()+" ("+patient2.getRelation().getRelationName()+" of "+patient2.getRank().getRankName()+" "+patient2.getSFirstName()+" "+patient2.getSMiddleName()+" "+patient2.getSLastName()+") Already Admitted   ";
if(!msg.equals("")){
	%>
	<h2><font id="error"><%=msg %></font></h2>
		<%}msg="";}}}%>
		--%>
		<!-- <div style="display: none"> -->
		<jsp:include page="searchResultBlock.jsp" />
		<!-- </div> -->

<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="patientAdmission" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1, "slno"], [2,"hin"], [3,"patName"], [4,"add"],[5,"admittedby"],[6,"dep"],[7,"unit"],[8,"referringdoctor"],[9,"hinIdMother"]];
	 statusTd = 9;
	</script>
</div>
<!-- <div style="float: right;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1">
<option value="0">Select</option>
</select>
</div> -->
<input type="hidden" name="hinIdMother" value="<%=hinIdMother != null?hinIdMother:""%>"/>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
</div>

<script type="text/javascript" language="javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Sl No."
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "slno";
	
	
	data_header[1] = new Array;
	data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.uhid") %>"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";
		
	data_header[3] = new Array;
	data_header[3][0] = "Address"
	data_header[3][1] = "data";
	data_header[3][2] = "30%";
	data_header[3][3] = "add";
	
	data_header[4] = new Array;
	data_header[4][0] = "Admitting  Doctor"
	data_header[4][1] = "data";
	data_header[4][2] = "30%";
	data_header[4][3] = "admittedby";
	
	data_header[5] = new Array;
	data_header[5][0] = "Department"
	data_header[5][1] = "data";
	data_header[5][2] = "30%";
	data_header[5][3] = "dep";
	
	data_header[6] = new Array;
	data_header[6][0] = "Unit"
	data_header[6][1] = "data";
	data_header[6][2] = "30%";
	data_header[6][3] = "unit";
	
	data_header[7] = new Array;
	data_header[7][0] = "Referring Doctor"
	data_header[7][1] = "data";
	data_header[7][2] = "30%";
	data_header[7][3] = "referringdoctor";
	
	data_header[8] = new Array;
	data_header[8][0] = "HinIdMother"
	data_header[8][1] = "hide";
	data_header[8][2] = "30%";
	data_header[8][3] = "hinIdMother";
	
	data_arr = new Array();
	<%
	
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) {
			int loopIndex=1;
			%>
	
	<% 	for(OpdPatientDetails patient : patientList){
		if(patient.getVisit().getHin().getPatientStatus().equals("Out Patient")){
			String patientName="";
			patientName=patient.getVisit().getHin().getPFirstName();
			if(patient.getVisit().getHin().getPMiddleName()!=null){
				patientName+=" "+patient.getVisit().getHin().getPMiddleName();	
			}
			if(patient.getVisit().getHin().getPLastName()!=null){
				patientName+=" "+patient.getVisit().getHin().getPLastName();	
			}
			String admittedDoctorName="";
			if(patient.getEmployee()!=null){
				admittedDoctorName=patient.getEmployee().getFirstName();
				if(patient.getEmployee().getMiddleName()!=null){
					admittedDoctorName+=" "+patient.getEmployee().getMiddleName();	
				}
				if(patient.getEmployee().getLastName()!=null){
					admittedDoctorName+=" "+patient.getEmployee().getLastName();	
				}
			}
				
			
			String refferingDoctor="-";
			if(patient.getEmployee()!=null)
			{
			refferingDoctor=patient.getEmployee().getFirstName();
			if(patient.getEmployee().getMiddleName()!=null){
				refferingDoctor+=" "+patient.getEmployee().getMiddleName();	
			}
			if(patient.getEmployee().getLastName()!=null){
				refferingDoctor+=" "+patient.getEmployee().getLastName();	
			}
			}
			String address="";
			if(patient.getVisit().getHin().getPatientAddress()!=null){
				address=patient.getVisit().getHin().getPatientAddress();
				address = address.replace("\n", "").replace("\r", "");
				address = address.replaceAll("\'","");
				address = address.replaceAll("^\"|\"$", "");
				
			}
			String unit = "";
			if(patient.getVisit().getUnit()!=null){
				unit = patient.getVisit().getUnit().getUnitCode();
			}
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getVisit().getHin().getId()%>
			data_arr[<%= counter%>][1] = <%=counter+1%>
			data_arr[<%= counter%>][2] = "<%=patient.getVisit().getHin().getHinNo()%>"
			data_arr[<%= counter%>][3] = "<%=patientName%>"
			data_arr[<%= counter%>][4] = "<%=address%>"
			data_arr[<%= counter%>][5] = "<%=admittedDoctorName%> "
			data_arr[<%= counter%>][6] = "<%=patient.getVisit()!=null && patient.getVisit().getDepartment()!=null?patient.getVisit().getDepartment().getDepartmentName():""%>"
			data_arr[<%= counter%>][7] = "<%=unit%>"
			data_arr[<%= counter%>][8] = "<%=refferingDoctor%>"
			data_arr[<%= counter%>][9] = ""
			<%counter++;
			loopIndex++;
		}
	}}
		if (ipPatientList != null && ipPatientList.size() > 0) {
			int loopIndex=1;
			%>
	
	<% 	for(Patient patient : ipPatientList){
		if(patient.getPatientStatus().equals("Out Patient")){
			String patientName="";
			patientName=patient.getPFirstName();
			if(patient.getPMiddleName()!=null){
				patientName+=" "+patient.getPMiddleName();	
			}
			if(patient.getPLastName()!=null){
				patientName+=" "+patient.getPLastName();	
			}
			String admittedDoctorName="";
/* 			if(patient.getEmployee()!=null){
				admittedDoctorName=patient.getEmployee().getFirstName();
				if(patient.getEmployee().getMiddleName()!=null){
					admittedDoctorName+=" "+patient.getEmployee().getMiddleName();	
				}
				if(patient.getEmployee().getLastName()!=null){
					admittedDoctorName+=" "+patient.getEmployee().getLastName();	
				}
			} */
				
			
			String refferingDoctor="-";
			/* if(patient.getReferredDoctor()!=null)
			{
			refferingDoctor=patient.getReferredDoctor().getFirstName();
			if(patient.getReferredDoctor().getMiddleName()!=null){
				refferingDoctor+=" "+patient.getReferredDoctor().getMiddleName();	
			} */
			/* if(patient.getReferredDoctor().getLastName()!=null){
				refferingDoctor+=" "+patient.getReferredDoctor().getLastName();	
			} 
			}*/
			
			String address="";
			if(patient.getPatientAddress()!=null){
				address=patient.getPatientAddress();	
				address.replaceFirst(",", "");
				address = address.replace("\n", "").replace("\r", "");
				address = address.replaceAll("\'","");
				address = address.replaceAll("^\"|\"$", "");
				
			}
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getId()%>
			data_arr[<%= counter%>][1] = <%=counter+1%>
			data_arr[<%= counter%>][2] = "<%=patient.getHinNo()%>"
			data_arr[<%= counter%>][3] = "<%=patientName%>"
			data_arr[<%= counter%>][4] = "<%=address%>"
			data_arr[<%= counter%>][5] = "<%=admittedDoctorName%> "
			data_arr[<%= counter%>][6] = ""
			data_arr[<%= counter%>][7] = "-"
			data_arr[<%= counter%>][8] = ""
				data_arr[<%= counter%>][9] = ""
			<%counter++;
			loopIndex++;
		}
	}}%>
		
		<%
	   
		if (dialysisSchedulingList != null && dialysisSchedulingList.size() > 0) {
			int loopIndex=1;
			%>
	
	<% 	for(DialysisSchudeling dialysisSchudeling : dialysisSchedulingList){
		//if(dialysisSchudeling.getHin().getPatientStatus().equals("Out Patient")){
			String patientName="";
			patientName=dialysisSchudeling.getHin().getPFirstName();
			if(dialysisSchudeling.getHin().getPMiddleName()!=null){
				patientName+=" "+dialysisSchudeling.getHin().getPMiddleName();	
			}
			if(dialysisSchudeling.getHin().getPLastName()!=null){
				patientName+=" "+dialysisSchudeling.getHin().getPLastName();	
			}
			/* String admittedDoctorName="";
			if(dialysisSchudeling.getHin().getEmployee()!=null){
				admittedDoctorName=patient.getEmployee().getFirstName();
				if(patient.getEmployee().getMiddleName()!=null){
					admittedDoctorName+=" "+patient.getEmployee().getMiddleName();	
				}
				if(patient.getEmployee().getLastName()!=null){
					admittedDoctorName+=" "+patient.getEmployee().getLastName();	
				}
			} */
				
			
			/* String refferingDoctor="-";
			if(patient.getReferredDoctor()!=null)
			{
			refferingDoctor=patient.getReferredDoctor().getFirstName();
			if(patient.getReferredDoctor().getMiddleName()!=null){
				refferingDoctor+=" "+patient.getReferredDoctor().getMiddleName();	
			}
			if(patient.getReferredDoctor().getLastName()!=null){
				refferingDoctor+=" "+patient.getReferredDoctor().getLastName();	
			}
			} */
			
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= dialysisSchudeling.getHin().getId()%>
			data_arr[<%= counter%>][1] = <%=counter+1%>
			data_arr[<%= counter%>][2] = "<%=dialysisSchudeling.getHin().getHinNo()%>"
			data_arr[<%= counter%>][3] = "<%=patientName%>"
			data_arr[<%= counter%>][4] = "-"
			data_arr[<%= counter%>][5] = " "
			data_arr[<%= counter%>][6] = ""
			data_arr[<%= counter%>][7] = "-"
			data_arr[<%= counter%>][8] = ""
				data_arr[<%= counter%>][9] = ""
			<%counter++;
			loopIndex++;
		//}
	}}
		%>
		
	<%	
		if (patientBabyAdmissionWaitingList != null && patientBabyAdmissionWaitingList.size() > 0) {
			int loopIndex=1;
			%>
	
	<% 	for(Patient patient : patientBabyAdmissionWaitingList){
		if(patient.getPatientStatus().equals("In Patient")){
			String patientName="";
			patientName=patient.getPFirstName();
			if(patient.getPMiddleName()!=null){
				patientName+=" "+patient.getPMiddleName();	
			}
			if(patient.getPLastName()!=null){
				patientName+=" "+patient.getPLastName();	
			}
			String admittedDoctorName="";
			 if(patient.getEmp()!=null){
				admittedDoctorName=patient.getEmp().getFirstName();
				if(patient.getEmp().getMiddleName()!=null){
					admittedDoctorName+=" "+patient.getEmp().getMiddleName();	
				}
				if(patient.getEmp().getLastName()!=null){
					admittedDoctorName+=" "+patient.getEmp().getLastName();	
				}
			}
				
			
			/* String refferingDoctor="-";
			if(patient.getRefDoctor()!=null)
			{
			refferingDoctor=patient.getRefDoctor().getFirstName();
			if(patient.getReferredDoctor().getMiddleName()!=null){
				refferingDoctor+=" "+patient.getReferredDoctor().getMiddleName();	
			}
			if(patient.getReferredDoctor().getLastName()!=null){
				refferingDoctor+=" "+patient.getReferredDoctor().getLastName();	
			}
			} */
			
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getId()%>
			data_arr[<%= counter%>][1] = <%=counter+1%>
			data_arr[<%= counter%>][2] = "<%=patient.getHinNo()%>"
			data_arr[<%= counter%>][3] = "<%=patientName%>"
			data_arr[<%= counter%>][4] = "-"
			data_arr[<%= counter%>][5] = "<%=admittedDoctorName%> "
			data_arr[<%= counter%>][6] = ""
			data_arr[<%= counter%>][7] = "-"
			data_arr[<%= counter%>][8] = ""
				data_arr[<%= counter%>][9] = "<%=patient.getMotherHinNo() != null?patient.getMotherHinNo():""%>"
			<%counter++;
			loopIndex++;
		}
	}}
		%>
		
		
		<%	
		if (directPatientBabyList != null && directPatientBabyList.size() > 0) {
			int loopIndex=1;
			%>
	
	<% 	for(Patient patient : directPatientBabyList){
		if(patient.getPatientStatus().equals("Out Patient")){
			String patientName="";
			patientName=patient.getPFirstName();
			if(patient.getPMiddleName()!=null){
				patientName+=" "+patient.getPMiddleName();	
			}
			if(patient.getPLastName()!=null){
				patientName+=" "+patient.getPLastName();	
			}
			String admittedDoctorName="";
			 if(patient.getEmp()!=null){
				admittedDoctorName=patient.getEmp().getFirstName();
				if(patient.getEmp().getMiddleName()!=null){
					admittedDoctorName+=" "+patient.getEmp().getMiddleName();	
				}
				if(patient.getEmp().getLastName()!=null){
					admittedDoctorName+=" "+patient.getEmp().getLastName();	
				}
			}
				
			
			/* String refferingDoctor="-";
			if(patient.getRefDoctor()!=null)
			{
			refferingDoctor=patient.getRefDoctor().getFirstName();
			if(patient.getReferredDoctor().getMiddleName()!=null){
				refferingDoctor+=" "+patient.getReferredDoctor().getMiddleName();	
			}
			if(patient.getReferredDoctor().getLastName()!=null){
				refferingDoctor+=" "+patient.getReferredDoctor().getLastName();	
			}
			} */
			
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getId()%>
			data_arr[<%= counter%>][1] = <%=counter+1%>
			data_arr[<%= counter%>][2] = "<%=patient.getHinNo()%>"
			data_arr[<%= counter%>][3] = "<%=patientName%>"
			data_arr[<%= counter%>][4] = "-"
			data_arr[<%= counter%>][5] = "<%=admittedDoctorName%> "
			data_arr[<%= counter%>][6] = ""
			data_arr[<%= counter%>][7] = "-"
			data_arr[<%= counter%>][8] = ""
			data_arr[<%= counter%>][9] = "<%=patient.getMotherHinNo() != null?patient.getMotherHinNo():"" %>"
			<%counter++;
			loopIndex++;
		}
	}}
		%>
		
		
	
    formName = "patientAdmission"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
	<%boolean search = false; %>
	<%if(   !StringUtils.isBlank(hinNo) || !StringUtils.isBlank(patientFName) || !StringUtils.isBlank(mobileNo) || !StringUtils.isBlank(departmentId) || !StringUtils.isBlank(admDepartmentId) || !StringUtils.isBlank(doctorId) )
	{
	 search = true;
	} %>
 	<%if(!search){%>
<META HTTP-EQUIV="REFRESH" CONTENT="20">
<%}%> 