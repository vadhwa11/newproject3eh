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
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
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
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<%
		Map<String, Object> map = new HashMap<String, Object>();

        List<Inpatient> inpatients = new ArrayList<Inpatient>();
        List<MasBed> beds  = new ArrayList<MasBed>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("inPatientSet") != null){
			inpatients= (List<Inpatient>)map.get("inPatientSet");
		}
		if(map.get("beds") != null){
			beds= (List<MasBed>)map.get("beds");
		}
	
	%>
	
	<% Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap= (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");%>
	
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="titleBg">
<h2>Print pass</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div style="display: none">
		<jsp:include page="searchResultBlock.jsp" />
		</div>

<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="patientAdmission" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1, "slno"], [2,"hin"], [3,"patName"], [4,"preason"],[5,"attendName"]];
	 statusTd = 6;
	</script>
</div>
<div style="float: right;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1">
<option value="0">Select</option>
</select>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>

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
	data_header[3][0] = "Print Reason"
	data_header[3][1] = "data";
	data_header[3][2] = "30%";
	data_header[3][3] = "preason";
	
	data_header[4] = new Array;
	data_header[4][0] = "Attendant name"
	data_header[4][1] = "data";
	data_header[4][2] = "30%";
	data_header[4][3] = "attendName";
	

	data_arr = new Array();
	<%-- <%
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
			
			String doctorName=patient.getEmployee().getFirstName();
			if(patient.getEmployee().getMiddleName()!=null){
				doctorName+=" "+patient.getEmployee().getMiddleName();	
			}
			if(patient.getEmployee().getLastName()!=null){
				doctorName+=" "+patient.getEmployee().getLastName();	
			}
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getVisit().getHin().getId()%>
			data_arr[<%= counter%>][1] = <%=loopIndex%>
			data_arr[<%= counter%>][2] = "<%=patient.getVisit().getHin().getHinNo()%>"
			data_arr[<%= counter%>][3] = "<%=patientName%>"
			data_arr[<%= counter%>][4] = " "
			data_arr[<%= counter%>][5] = "<%=doctorName%> "
			data_arr[<%= counter%>][6] = "<%=patient.getReferredDept().getDepartmentName()%>"
			<%counter++;
			loopIndex++;
		}
		
	}}
		%> --%>
		
		data_arr[0] = new Array();
		data_arr[0][0] = ""
		data_arr[0][1] = ""
		data_arr[0][2] = ""
		data_arr[0][3] = ""
		data_arr[0][4] = " "
		data_arr[0][5] = ""
		
		data_arr[1] = new Array();
		data_arr[1][0] = ""
		data_arr[1][1] = ""
		data_arr[1][2] = ""
		data_arr[1][3] = ""
		data_arr[1][4] = " "
		data_arr[1][5] = ""
		
		
	
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
<div class="paddingTop15"></div>

<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="button" class="button" value="Print" onClick="" />

<input type="button" class="button" value="Reset" id="reset" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<!-- </form> -->
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="paddingTop15"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="paddingTop15"></div>

<div class="paddingTop15"></div>


