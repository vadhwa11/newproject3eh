<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : searchPatientForAdvance.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 23.06.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	List<Patient> patientList = new ArrayList<Patient>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if (map.get("patientMap") != null) {
		patientMap = (Map<String, Object>) map.get("patientMap");
	}
	if (patientMap.get("patientDetailsList") != null) {
		patientList = (List<Patient>) patientMap.get("patientDetailsList");
	}
	HospitalParameters hospitalParameters=new HospitalParameters();
	
	if(map.get("hospitalParameters") != null){
		hospitalParameters = (HospitalParameters)map.get("hospitalParameters");
	}
	int allowAdvForOp = 0;
	
	
	String message = "";
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}
	if(!message.equals("")){
%>
<%@page import="jkt.hms.masters.business.HospitalParameters"%>
<script>
alert('<%=message %>');
</script>
<%} %>
<script>
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("pMName").value;
	errorMsg=errorMsg+document.getElementById("pLName").value;
	
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}


</script>
<!--Block One Starts-->
<form name="billingDepositsSearch" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 26 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>


<div class="clear"></div>

<div class="titleBg">
<h2>Search Patient</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar"><label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text"
	id="hinNo" name="<%=HIN_NO %>" value=""
	onblur="if(this.value != ''){submitForm('billingDepositsSearch','opd?method=searchPatientForMLC');}"
	MAXLENGTH="50" /> 
	<%--<label>Patient First Name</label> <input type="text"
	id="pFName" name="<%=P_FIRST_NAME %>" value=""
	onblur="if(this.value != ''){submitForm('billingDepositsSearch','opd?method=searchPatientForJSSK');}"
	MAXLENGTH="15" /> <label>Patient Mid Name</label> <input type="text"
	id="pMName" name="<%=P_MIDDLE_NAME %>" value=""
	onblur="if(this.value != ''){submitForm('billingDepositsSearch','opd?method=searchPatientForJSSK');}"
	MAXLENGTH="15" /><label>Patient Last Name</label> <input type="text" id="pLName"
	name="<%=P_LAST_NAME%>" value="" MAXLENGTH="15" />
	 --%>

<div class="clear"></div>

<div class="clear"></div>
</div>
</div>
</div>
 


 </form>
<!-- 
<input type="button" name="search" 
	onclick="submitForm('billingDepositsSearch','billing?method=searchPatient','checkBlankSearch');"
	value="Search" class="button" accesskey="a" /> -->
<div class="clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="patientAdvance" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 <script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"hin"], [2,"patName"]];
	// statusTd = 7;
	</script></form>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "hin"
	
	data_header[1] = new Array;
	data_header[1][0] = "Patient Name"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "patName";
	
			
	data_arr = new Array();
	<%
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(Patient patient : patientList){
		if(patient.getPatientStatus().equals("In Patient") ){
			allowAdvForOp = 1;
		}else{
			if(hospitalParameters != null){
				if(hospitalParameters.getAllowOpAdvance() != null){
					allowAdvForOp = hospitalParameters.getAllowOpAdvance();
				}
			}
		}
		if(allowAdvForOp == 1)
		{
			String PatientName = "";
			if(patient.getPFirstName() != null && patient.getPLastName() != null)
			{
				PatientName = patient.getPFirstName() + patient.getPLastName();
			}
			else if(patient.getPFirstName() != null)
			{
				PatientName = patient.getPFirstName();
			}
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getId()%>
			data_arr[<%= counter%>][1] = "<%=patient.getHinNo()%>"
			data_arr[<%= counter%>][2] = "<%=PatientName%>"
	<%
		     counter++;
		 }
	}
		}		
%>
	
   formName = "patientAdvance"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>

<%
patientList=null;

%>