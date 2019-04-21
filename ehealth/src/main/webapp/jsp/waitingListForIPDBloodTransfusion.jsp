<%--
 * Copyright 2011 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showUserAssinedTemplet.jsp  
 * Purpose of the JSP   This is for Assigned Templet To User 
 * @author Ujjwal Kashyap
 * Create Date: 1st Jun,2012 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryHeader"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>


<%@page import="jkt.hms.masters.business.UserTemplate"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<BloodRequestEntryHeader> requestEntryList = new ArrayList<BloodRequestEntryHeader>();
	List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
	
	if(map.get("requestEntryList")!=null){
		requestEntryList =(List) map.get("requestEntryList");
		
	}
	
System.out.println("requestEntryList.size()---jsp->>"+requestEntryList.size());
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
	}
	
	%>


<div class="paddingTop15"></div>
<div class="clear"></div>
<h2>Waiting for Blood Transfusion</h2>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
</div>
<form name="ipBloodTransWaiting" method="post">
<script	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "uhid"], [1,"ptName"], [2,"hinNo"], [3,"ipNo"]];
	 statusTd =3;
	</script>
<div class="clear"></div>

<div class="clear"></div>
<script type="text/javascript" language="javascript">
	data_header = new Array();
	data_header[0] = new Array;
	data_header[0][0] = "UHID"
	data_header[0][1] = "hide";
	data_header[0][2] = "7%";
	data_header[0][3] = "uhid"

	data_header[1] = new Array;
	data_header[1][0] = "Patient Name"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "ptName";

	data_header[2] = new Array;
	data_header[2][0] = "Hin No"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "hinNo";

	data_header[3] = new Array;
	data_header[3][0] = "Ip No"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "ipNo"

	


	data_arr = new Array();
	<%

	    int  counter=0;
	
		if (requestEntryList != null && requestEntryList.size() > 0) { %>

	<% 	for(BloodRequestEntryHeader requestEntryHeader : requestEntryList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= requestEntryHeader.getId()%>
			data_arr[<%= counter%>][1] = "<%=requestEntryHeader.getInpatient().getHin().getHinNo()%>"
			data_arr[<%= counter%>][2] = "<%=requestEntryHeader.getInpatient().getHin().getPFirstName()%>"
				
			data_arr[<%= counter%>][3] = "<%=requestEntryHeader.getInpatient().getAdNo()%> "
				data_arr[<%= counter%>][4] = "<%=requestEntryHeader.getInpatient().getAdNo()%> "
		
		<%

				counter++;
		    	}
			}
		%>

    formName = "ipBloodTransWaiting"

	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;

	}

	makeTable(start,end);

	</script>



<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('ipBloodTransWaiting','ipd?method=showPatientListJsp');"/>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>