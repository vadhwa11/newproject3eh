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
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.masters.business.OtPreOperativeCheckList"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>


<title>Patient Search For Consent Entry</title>
<div class="clear"></div>
<form name="search1" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		String otProcedure="";
		String url="";
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		
		if(patientMap.get("patientList") != null){
			patientList= (List<OtBooking>)patientMap.get("patientList");
		}
		
		if(patientMap.get("sexList") != null){
			sexList= (List<MasAdministrativeSex>)patientMap.get("sexList");
		}
		if(map.get("otProcedure") != null){
			otProcedure= (String)map.get("otProcedure");
		}
		if(otProcedure.equals("yes"))
		{
			
		}
		else if(otProcedure.equals("no"))
		{
			
		}
	%> <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %>
     <%
     if(otProcedure.equals("yes")){ %>
<div class="titleBg">
<h2>OT Consent Entry Search</h2>
</div>
<%} else if(otProcedure.equals("no")){ %>
<div class="titleBg">
<h2>Pre Anesthesia Procedure Notes Search</h2>
</div>
<%} %>
<div class="Block">
<h4>Patient Search</h4>
<div class="clear"></div>
<div class="clear"></div>
<label>UHID</label> <input type="text" id="uhid" name="uhid"  maxlength="20"></input>
 <label>Patient Name</label> <input type="text" id="pname" name="pname" maxlength="20"></input>
<label>IP No.</label> <input type="text" id="ipno" name="ipno" maxlength="20"></input>
<label>Gender</label> 
<select id="gender" name="gender">
<option value="0">Select </option>
<%Iterator iterator=sexList.iterator();
while(iterator.hasNext())
{   
	  MasAdministrativeSex administrativeSex= (MasAdministrativeSex)iterator.next(); %>
	  <option value="<%=administrativeSex.getId()%>"><%=administrativeSex.getAdministrativeSexName() %></option>
	  
	  <%} %>
</select>
<div class="clear"></div>
<div class="clear"></div>
<script type="text/javascript">
   function checkBlank(){
     var uhid=document.getElementById('uhid').value;
     var pname=document.getElementById('pname').value;
     var ipno=document.getElementById('ipno').value;
     var lName=document.getElementById('gender').value;
       if(uhid =="" && pname=="" && ipno=="" &&( gender=="" || gender=="0" ))
       {
    	   if(!displayAlert("Please Enter any Value For Search!!"))
        	   alert("Please Enter any Value For Search!!");
          return false;
       }else
         return true;
   }
 </script> 
 <input type="button" name="Submit" id="addbutton"  value="Search" class="button" accesskey="a" 
 onclick="if(checkBlank()){submitForm('search1','/hms/hms/ot?method=showIntraOperativeCheckList&otProcedure=<%=otProcedure%>');}" />
 <%--
<input type="button" name="Submit" id="addbutton"  value="New Record Search" class="buttonBig2" accesskey="a" 
 onclick="if(checkBlank()){submitForm('search1','/hms/hms/ot?method=showOtPatientDetails&otProcedure=<%=otProcedure%>');}" />
<%if(otProcedure.equals("yes")){ %>
<input name="searchButton" type="button" class="buttonBig2"	value="Existing Record Search"
	onclick="submitForm ('search','ot?method=searchOtProcedureNotes')" />
<%} else if(otProcedure.equals("no")){ %> 
<input name="searchButton" type="button" class="buttonBig2" value="Existing Record Search"
	onclick="submitForm ('search','ot?method=searchPreAnaesthesiaProcedureNotes')" />
<%} %> --%>
</div>
</form>
<div class="clear"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="intraOperativeTimeOut" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


 <script type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"servNo"], [2,"hin"], [3,"patName"], [4,"serviceType"], [5,"sPersonName"], [6,"rank"], [7,"unit"],, [8,"bookingId"]];
	 statusTd = 7;
	</script>
</div></form>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Service No"
	data_header[0][1] = "hide";
	data_header[0][2] = "7%";
	data_header[0][3] = "servNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Service Type"
	data_header[3][1] = "hide";
	data_header[3][2] = "10%";
	data_header[3][3] = "serviceType"
	
	data_header[4] = new Array;
	data_header[4][0] = "Service Person Name"
	data_header[4][1] = "hide";
	data_header[4][2] = "15%";
	data_header[4][3] = "sPersonName";
	
	data_header[5] = new Array;
	data_header[5][0] = "Rank"
	data_header[5][1] = "hide";
	data_header[5][2] = "10%";
	data_header[5][3] = "rank";
	
	data_header[6] = new Array;
	data_header[6][0] = "Unit"
	data_header[6][1] = "hide";
	data_header[6][2] = "10%";
	data_header[6][3] = "unit"
	
		data_header[6] = new Array;
	data_header[6][0] = "Booking ID"
	data_header[6][1] = "hide";
	data_header[6][2] = "10%";
	data_header[6][3] = "bookingId"
	
	
	
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(OtBooking otBooking : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= otBooking.getHin().getId()%>
			data_arr[<%= counter%>][1] = ""
			data_arr[<%= counter%>][2] = "<%=otBooking.getHin().getHinNo()%>"
			<%
					String middleName = "";
					String lastName = "";
					if(otBooking.getHin().getPMiddleName() != null){
						middleName = otBooking.getHin().getPMiddleName();
					}
					if(otBooking.getHin().getPLastName() != null){
						lastName = otBooking.getHin().getPLastName();
					}
					
					%>
			data_arr[<%= counter%>][3] = "<%=otBooking.getHin().getPFirstName()%> <%=middleName%> <%=lastName%>"
			data_arr[<%= counter%>][4] = ""
			data_arr[<%= counter%>][5] = ""
			data_arr[<%= counter%>][6] = ""
			data_arr[<%= counter%>][7] = ""
			
			data_arr[<%= counter%>][8] = "<%=otBooking.getId()%>"
				
		
		<%
				
				     counter++;
		    	}
			}
		%>
	
    	formName = "intraOperativeTimeOut"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
