<%--
	 * Copyright 2010 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : dietpendinglistjsp.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 21.10.2010    Name: Ramdular
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>


<script
	type="text/javascript" language="javascript">
	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		String time=String.valueOf(calendar.getTime());
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}%>
		 serverdate = '<%=date+"/"+month+"/"+year%>'
		function checkStartDate(){
		var toDate = document.patientEnquirySearch1.<%= TO_DATE %>.value;
		var cDate = new Date();
		var month = cDate.getMonth() + 1
		var day = cDate.getDate()
		var year = cDate.getFullYear()
		var seperator = "/"
		var currentDate  = new Date(month + seperator + day + seperator + year);
		var endDate =new Date(toDate.substring(6),(toDate.substring(3,5) - 1) ,toDate.substring(0,2))
		if(toDate=="")
		{
		 alert("Date should not be blank.");
		 return false;
		}
		return true;
	}

function displayPendingList(cnt)
{
	var parent = document.getElementById('parent'+cnt).value;
	submitProtoAjax('dietPendingPatientList','/hms/hms/diet?method=showPendingPatientDietDetails&id='+parent);

}

function checkLength(obj){

	var dietPatientHistory = document.getElementById('dietPatientHistory').value
	var dietPrescribedetails  = document.getElementById('dietPrescribedetails').value

	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if(dietPatientHistory!=null)
	{
       if(dietPatientHistory.length>mlength)
       {
		alert('Diet Patient History should contails 300 character only !!!');
		document.getElementById('dietPatientHistory').value = dietPatientHistory.substring(0,mlength);
		return false;
       }
	}
	if(dietPrescribedetails!=null)
	{
       if(dietPrescribedetails.length>mlength)
       {
		alert('Diet Prescribed Diet Details should contails 300 character only !!!');
		document.getElementById('dietPrescribedetails').value = dietPrescribedetails.substring(0,mlength);
		return false;
       }
	}
}


</script> <%
		Map<String, Object> map = new HashMap<String, Object>();
		String message="";
		List<OpdPatientDetails> pendingPatientDietList = new ArrayList<OpdPatientDetails>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currenDate = (String) utilMap.get("currentDate");
	 	String currentTime = (String) utilMap.get("currentTime");
	 	String userName=null;
	  	if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("pendingPatientDietList") != null){
			pendingPatientDietList= (List<OpdPatientDetails>)map.get("pendingPatientDietList");
		}
		int cnt=1;
	%>

<div class="titleBg">
<h2>Pending Patient Diet List</h2>
</div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form name="search" action="" method="post">
<label><%=prop.getProperty("com.jkt.hms.registration_no") %>:</label>
<input type="text" name="<%=HIN_NO %>" id="hinNo"	MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>
<label>Patient First Name : </label>
<input type="text"	name="<%=P_FIRST_NAME %>" id="patientFName"	MAXLENGTH="30" tabindex=1 />
<label>Patient Middle Name : </label>
<input type="text"	name="<%=P_MIDDLE_NAME %>" id="patientMName"	MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>
<label>Patient Last Name : </label>
<input	type="text" name="<%=P_LAST_NAME %>"	id="pateintLName" MAXLENGTH="30" tabindex=1 />
<input type="button" onClick="submitForm('search','/hms/hms/diet?method=searchPendingPatientDietList');" class="button" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>


<div class="clear"></div>
<form name="patientPendingDietSearch1" action="" method="post"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label>Date :</label>
<%
String toDate=null;
if(request.getParameter("toDate")!=null)
{
	toDate = (String)request.getParameter("toDate");

}else if(toDate==null)
{
	toDate = currenDate;
}
%>

<input type="text" id="toDateId" name="<%=TO_DATE%>" value="<%=toDate%>" class="date" readonly="readonly"	MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"
onclick="javascript:setdate('<%=currenDate %>',document.patientPendingDietSearch1.<%=TO_DATE%>,event)" ></img>
<input type="button" name="SearchList"	onclick="submitForm('patientPendingDietSearch1','/hms/hms/diet?method=searchPendingPatientDietList');"	value="Go" class="button" accesskey="a" />
</div>
</form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="dietPendingPatientList" method="post" action="">
<script	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1,"radio"], [2,"servNo"], [3,"hin"], [4,"patName"], [5,"dietType"],[6,"visitDate"], [7,"doctorName"], [8,"remarks"], [9,"department"]];
	 statusTd = 9;
	</script>

</form>
<div class="clear"></div>
<div class="clear"></div>
<div id="testDiv">
</div>
</div>
<script type="text/javascript" language="javascript">
	data_header = new Array();
	data_header[0] = new Array;
	data_header[0][0] = ""
	data_header[0][1] = "data";
	data_header[0][2] = "10%";
	data_header[0][3] = "radio"

	data_header[1] = new Array;
	data_header[1][0] = "Sl. No."
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "servNo"

	data_header[2] = new Array;
	data_header[2][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "hin";

	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "patName";

	data_header[4] = new Array;
	data_header[4][0] = "Type of Diet"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "dietType"

	data_header[5] = new Array;
	data_header[5][0] = "Visit Date"
	data_header[5][1] = "data";
	data_header[5][2] = "10%";
	data_header[5][3] = "visitDate"

	data_header[6] = new Array;
	data_header[6][0] = "Doctor Name"
	data_header[6][1] = "data";
	data_header[6][2] = "15%";
	data_header[6][3] = "doctorName";

	data_header[7] = new Array;
	data_header[7][0] = "Remarks"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "remarks";

	data_header[8] = new Array;
	data_header[8][0] = "Department"
	data_header[8][1] = "data";
	data_header[8][2] = "10%";
	data_header[8][3] = "department"
	data_arr = new Array();
	<%

	    int  counter=0;
		if (pendingPatientDietList != null && pendingPatientDietList.size() > 0) { %>

	<% 	for(OpdPatientDetails patient : pendingPatientDietList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = "<%=patient.getVisit().getId()%>"
			data_arr[<%= counter%>][1] = '<input type="radio" class="radiogrid" name="parent" id="parent<%=cnt%>" value="<%=patient.getId()%>"  onclick="displayPendingList(<%=cnt%>);"/>'
			data_arr[<%= counter%>][2] = "<%=cnt%>"
		    data_arr[<%= counter%>][3] = "<%=patient.getVisit().getHin().getId()%>"

				<%
				  String parient_Name ="";
				  if(patient.getVisit().getHin().getPFirstName()!=null)
				  {
					  parient_Name = patient.getVisit().getHin().getPFirstName();
				  }
				  if(patient.getVisit().getHin().getPMiddleName()!=null)
				  {
					  parient_Name = parient_Name+" "+patient.getVisit().getHin().getPMiddleName();
				  }
				  if(patient.getVisit().getHin().getPLastName()!=null)
				  {
					  parient_Name = parient_Name+" "+patient.getVisit().getHin().getPLastName();
				  }
				%>
			data_arr[<%= counter%>][4] = "<%=parient_Name%> "
			<%

				if(patient.getDiet() != null){
					MasDiet diet = new MasDiet();
					diet = (MasDiet)patient.getDiet();
			%>
			data_arr[<%= counter%>][5] = "<%=diet.getDietName()%>";
			<%}else {%>
			data_arr[<%= counter%>][5] = "";
			<%}%>
			<%

			if(patient.getVisit().getVisitDate() != null){
		   %>
		   data_arr[<%= counter%>][6] = "<%=patient.getVisit().getVisitDate()%>";
		   <%}else {%>
		   data_arr[<%= counter%>][6] = "";
		    <%}%>

			<%
			String doctName ="";
				if(patient.getVisit().getDoctor() != null){
					doctName =patient.getVisit().getDoctor().getFirstName();
					if(patient.getVisit().getDoctor().getMiddleName()!=null)
					{
					 doctName = doctName +" "+patient.getVisit().getDoctor().getMiddleName();
					}
					if(patient.getVisit().getDoctor().getLastName()!=null)
					{
					 doctName = doctName +" "+patient.getVisit().getDoctor().getLastName();
					}
			%>
			data_arr[<%= counter%>][7] = "<%=doctName%>"
			<%}else {%>
			data_arr[<%= counter%>][7] = "";

			<%}
			if(patient.getDietRemarksId()!=null){
			%>
				data_arr[<%= counter%>][8] = "<%=patient.getDietRemarksId()%>"
			<%}else{%>
			data_arr[<%= counter%>][8] = ""
			<%}if(patient.getVisit().getDepartment()!=null){%>
			data_arr[<%= counter%>][9] = "<%=patient.getVisit().getDepartment().getDepartmentName()%>"
				<%}else{%>
				data_arr[<%= counter%>][9] = ""
				<%}%>
	<%
				cnt++;
				counter++;
		    	}
			}
		%>

		   formName = "dietPendingPatientList"

				start = 0
				if(data_arr.length < rowsPerPage){
					end = data_arr.length;
				}
				else{
					end = rowsPerPage;

				}

				makeTable(start,end);


</script>
<div class="clear"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currenDate%></label>
<label>Changed Time</label> <label class="value"><%=currentTime%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currenDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></div>
	<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script>