<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * sample.jsp  
 * Purpose of the JSP -  This is for sample.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 10th April,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.11
--%>


<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="jkt.hms.masters.business.DgMasCollection"%>
<%@page import="jkt.hms.masters.business.DgUom"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Visit> visitList = new ArrayList<Visit>();
	 
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if (map.get("visitList") != null) {
		visitList = (List<Visit>) map.get("visitList");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");   
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
 %>
<h4>
	<span><%=message %></span>
</h4>
<%} %>
<div class="titleBg">
	<h2>Search Patient</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
	<div id="searcharea">
		<div id="searchbar">
			<form name="searchUnserviced" method="post" action="">
				<label>UHID</label> <input type="text" id="spNameId" name="uhid"
					value="" tabindex="1" MAXLENGTH="128" />
				<div class="clear"></div>
				<input type="button" name="search" value="Search" class="button"
					tabindex="1"
					onClick="submitForm('searchUnserviced','/hms/hms/registration?method=searchUnservicedPatient')" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

		</div>
	</div>
	<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
	<div id="searchtable" tabindex=1></div>
	<%-- <% 
		if(searchSampleList.size()>0)
		 {
			String strForCode = (String)map.get("sampleCode");
			String strForCodeDescription = (String)map.get("sampleName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
	<h4>
		<a href="laboratory?method=showSampleJsp">Show All Records</a>
	</h4>
	<%
			}
		 }
	 if(searchSampleList.size()==0 && map.get("search") != null)
	  {
	 %>
	<h4>
		<a href="laboratory?method=showSampleJsp">Show All Records</a>
	</h4>
	<%
     }
	%> --%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"lastVisitId"], [2,"hospId"],[3,"departId"],[4,"hinId"], [5,"uhid"],[6,"pname"],
			[7,"age"],[8,"mobileNo"],[9,"visitDate"],[10,"departmentName"],[11,"hospitalName"],[12,"doctorName"],[13,"status"]];
	 statusTd = 13;
	</script>
</div>
<%if(visitList.size()>0){ %>
<form name="patientUnserviced" method="post">
<div class="Block">
	<input type="hidden" name="lastVisitId" /> <input type="hidden"
		name="hospId" /> <input type="hidden" name="departId" /> <input
		type="hidden" name="hinId" /> <label> UHID</label> <input type="text"
		name="uhid" readonly="readonly"/> <label>Name</label> <input type="text" name="pname" readonly="readonly"/>
	<label>Age</label> <input type="text" name="age" readonly="readonly"/>
	<div class="clear"></div> 
		<label> Mobile No.</label> 
		<input type="text" name="mobileNo" readonly="readonly"/>
		 <label>Last Visit Date</label> <input type="text" name="visitDate" readonly="readonly"/> 
		<label>Department</label> <input type="text" name="departmentName" readonly="readonly"/>
		<div class="clear"></div>
		<label>Hospital</label><input type="text" name="hospitalName" readonly="readonly"/>  
		<label>Doctor</label> <input type="text" name="doctorName" readonly="readonly"/>
		<div class="clear"></div> 
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>

	<div id="edited"></div>
	<input type="hidden" name="add" id="addbutton" value="Add" onClick="#" accesskey="a" tabindex=1 /> 
	<input type="button" name="edit" id="editbutton" value="Submit" style="display: none;" class="button"
		onClick="submitForm('patientUnserviced','registration?method=submitUnservicedPatient')"
		accesskey="u" tabindex=1 /> <input type="hidden" name="Delete"
		id="deletebutton" value="Activate" style="display: none;"
		class="button"
		onClick="#"
		accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
		id="reset" value="Reset" class="buttonHighlight"
		onclick="resetCheck();" accesskey="r" /> <input type="hidden"
		name="<%=STATUS %>" value="" /> <input type="hidden"
		name="<%= COMMON_ID%>" value="" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label> <label class="value"><%=userName%></label>
		<label>Changed Date:</label> <label class="value"><%=date%></label> <label>Changed
			Time:</label> <label class="value"><%=time%></label> <input type="hidden"
			name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
			name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</div>
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<%} %>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "lastVisitId";
data_header[0][1] = "hide";
data_header[0][2] = 0;
data_header[0][3] = "lastVisitId";

data_header[1] = new Array;
data_header[1][0] = "hospId";
data_header[1][1] = "hide";
data_header[1][2] = 0;
data_header[1][3] = "hospId";

data_header[2] = new Array;
data_header[2][0] = "departId";
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "departId";

data_header[3] = new Array;
data_header[3][0] = "hinId";
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "hinId";

data_header[4] = new Array;
data_header[4][0] = "UHID";
data_header[4][1] = "data";
data_header[4][2] = "25%";
data_header[4][3] = "uhid";

data_header[5] = new Array;
data_header[5][0] = "Patient Name";
data_header[5][1] = "data";
data_header[5][2] = "25%";
data_header[5][3] = "pname";

data_header[6] = new Array;
data_header[6][0] = "Age";
data_header[6][1] = "data";
data_header[6][2] = "25%";
data_header[6][3] = "age"; 

data_header[7] = new Array;
data_header[7][0] = "Mobile No";
data_header[7][1] = "data";
data_header[7][2] = "25%";
data_header[7][3] = "mobileNo";

data_header[8] = new Array;
data_header[8][0] = "Visit Date";
data_header[8][1] = "data";
data_header[8][2] = "25%";
data_header[8][3] = "visitDate";

data_header[9] = new Array;
data_header[9][0] = "Department Name";
data_header[9][1] = "data";
data_header[9][2] = "25%";
data_header[9][3] = "departmentName";

data_header[10] = new Array;
data_header[10][0] = "Hospital Name";
data_header[10][1] = "data";
data_header[10][2] = "25%";
data_header[10][3] = "hospitalName";

data_header[11] = new Array;
data_header[11][0] = "Doctor Name";
data_header[11][1] = "data";
data_header[11][2] = "25%";
data_header[11][3] = "doctorName";

data_header[12] = new Array;
data_header[12][0] = "Status";
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "status";
data_arr = new Array();

<%

 
          int  counter=0;
          for(Visit visit:visitList)
           { 
        	int hinId = 0;
      		String uhid = "";
      		String name = "";
      		String age = "";
      		String mobNo = "";
      		String department = "";
      		String hospital = "";
      		String doctor = "";
      		String visitDate = "";
      		int departId = 0;
      		int hospId = 0;
      		int visitId = 0;
      		visitId = visit.getId();
			departId = visit.getDepartment().getId();
			hospId = visit.getHospital().getId();
			hinId = visit.getHin().getId();
			uhid = visit.getHin().getHinNo();
			name = visit.getHin().getFullName();
			if(visit.getHin().getAge()!=null){
				age = visit.getHin().getAge();
			}
			

			if (null != visit.getHin().getMobileNumber()) {
				mobNo = visit.getHin().getMobileNumber();
			}
			department = visit.getDepartment().getDepartmentName();
			hospital = visit.getHospital().getHospitalName();
			if (null != visit.getDoctor())
				doctor = visit.getDoctor().getEmployeeName();
			if (null != visit.getVisitDate()) {
				visitDate = HMSUtil.convertDateToStringWithoutTime(visit
						.getVisitDate());
			}
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%=visitId%>
data_arr[<%= counter%>][1] = "<%=visitId%>"
data_arr[<%= counter%>][2] = "<%=hospId%>"
data_arr[<%= counter%>][3] = "<%=departId%>"
data_arr[<%= counter%>][4] = "<%=hinId%>"
data_arr[<%= counter%>][5] = "<%= uhid%>"
data_arr[<%= counter%>][6] = "<%=name%>"
data_arr[<%= counter%>][7] = "<%=age%>" 
data_arr[<%= counter%>][8] = "<%=mobNo%>" 
data_arr[<%= counter%>][9] = "<%=visitDate%>" 
data_arr[<%= counter%>][10] = "<%=department%>" 
data_arr[<%= counter%>][11] = "<%=hospital%>" 
data_arr[<%= counter%>][12] = "<%=doctor%>" 
data_arr[<%= counter%>][13] = "" 

<%
		     counter++;
}
%>
 
formName = "patientUnserviced"

nonEditable = ['<%= CODE%>'];
	start = 0
	if (data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start, end);

	intializeHover('searchresulttable', 'TR', ' tableover');
</script>
<%-- 


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>

<%@page import="java.util.Date"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.util.List"%>

<%@ page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();

		int hinId = 0;
		String uhid = "";
		String name = "";
		String age = "";
		String mobNo = "";
		String department = "";
		String hospital = "";
		String doctor = "";
		String date = "";
		int departId = 0;
		int hospId = 0;
		int visitId = 0;

		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
			if (map.get("visitList") != null) {
				visitList = (List<Visit>) map.get("visitList");
				if (visitList != null && visitList.size() > 0) {
					Visit visit = visitList.get(0);
					visitId = visit.getId();
					departId = visit.getDepartment().getId();
					hospId = visit.getHospital().getId();
					hinId = visit.getHin().getId();
					uhid = visit.getHin().getHinNo();
					name = visit.getHin().getPFirstName();
					if(visit.getHin().getAge()!=null){
						age = visit.getHin().getAge();
					}
					

					if (null != visit.getHin().getMobileNumber()) {
						mobNo = visit.getHin().getMobileNumber();
					}
					department = visit.getDepartment().getDepartmentName();
					hospital = visit.getHospital().getHospitalName();
					if (null != visit.getDoctor())
						doctor = visit.getDoctor().getEmployeeName();
					if (null != visit.getVisitDate()) {
						date = HMSUtil.convertDateToStringWithoutTime(visit
								.getVisitDate());
					}

				}

			}
		}
	%> 
	<div id="Block">
		<form name="searchUnserviced" method="post">
			<label> UHID</label> <input type="text" id="spNameId" name="uhid"
				value="" tabindex="1" title="Full Name of the Patient"
				MAXLENGTH="128" />
			<div class="clear"></div>

			<input type="button" name="search" value="Search" class="button"
				tabindex="1"
				onClick="submitForm('searchUnserviced','/hms/hms/registration?method=searchUnservicedPatient')" />

			<input type="reset" tabindex="1" name="Reset" value="Cancel"
				class="button"
				onclick="submitProtoAjax('patientRegistersearch','registration?method=getPatientName')"
				accesskey="r" />
			<div class="clear"></div>



		</form>
		<%if(visitList != null && visitList.size() > 0){%>
		<form name="patientUnserviced" method="post">

			<label> UHID</label><input type="hidden" name="lastVisitId"
				value="<%=visitId%>" /> <input type="hidden" name="hospId"
				value="<%=hospId%>" tabindex="1" title="Full Name of the Patient"
				MAXLENGTH="128" /> <input type="hidden" name="departId"
				value="<%=departId%>" tabindex="1" title="Full Name of the Patient"
				MAXLENGTH="128" /> <input type="hidden" name="hinId"
				value="<%=hinId%>" tabindex="1" title="Full Name of the Patient"
				MAXLENGTH="128" /> <input type="text" name="uhid" value="<%=uhid%>"
				tabindex="1" title="Full Name of the Patient" MAXLENGTH="128" readonly="readonly"/> <label>
				Name</label> <input type="text" name="pname" value="<%=name%>" tabindex="1"
				title="Full Name of the Patient" MAXLENGTH="128" readonly="readonly"/> <label>
				Age</label> <input type="text" name="age" value="<%=age%>" tabindex="1"
				title="Full Name of the Patient" MAXLENGTH="128" readonly="readonly"/>

			<div class="clear"></div>

			<label> Mobile No.</label> <input type="text" name="age"
				value="<%=mobNo%>" tabindex="1" title="Full Name of the Patient"
				MAXLENGTH="128" readonly="readonly"/> <label>Last Visit Date</label> <input
				type="text" name="visitDate" value="<%=date%>" tabindex="1"
				title="Full Name of the Patient" MAXLENGTH="128" readonly="readonly"/> <label>
				Department</label> <input type="text" name="departmentName"
				value="<%=department%>" tabindex="1"
				title="Full Name of the Patient" MAXLENGTH="128" />

			<div class="clear"></div>

			<label> Hospital</label> <input type="text" name="hospitalName"
				value="<%=hospital%>" tabindex="1" title="Full Name of the Patient"
				MAXLENGTH="128" /> <label> Doctor</label> <input type="text"
				name="doctorName" value="<%=doctor%>" tabindex="1"
				title="Full Name of the Patient" MAXLENGTH="128" />

			<div class="clear"></div>
			<input type="button" name="Submit" value="Submit" class="button"
				tabindex="1"
				onClick="submitForm('patientUnserviced','/hms/hms/registration?method=submitUnservicedPatient')" />

		</form>
	<%} %>
	</div>
</body>
</html> --%>