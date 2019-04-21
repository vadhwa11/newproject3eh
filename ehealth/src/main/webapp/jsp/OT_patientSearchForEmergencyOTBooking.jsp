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
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>

<script type="text/javascript">
   function checkBlank(){
     var hin=document.getElementById('hinNo').value;
     var fName=document.getElementById('fName').value;
     var mName=document.getElementById('mName').value;
     var lName=document.getElementById('lName').value;
       if(hin =="" & fName=="" & mName=="" & lName=="")
       {
    	   if(!displayAlert("Please Enter any Value For Search!!"))
        	   alert("Please Enter any Value For Search!!");
          return false;
       }else
         return true;
   }
 </script>
<div class="clear"></div>
<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		List<Patient> patientList = new ArrayList<Patient>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		
		if(patientMap.get("patientList") != null){
			patientList= (List<Patient>)patientMap.get("patientList");
		}
		String message="";
		if(map.get("message") != null){
		    message = (String)map.get("message");
		  }
    %>
    <h4><span><%=message%></span></h4>
    
<div class="clear"></div>
<h2>Emergency OT Booking</h2><div class="clear"></div>
<div class="Block"> 
<label>UHID</label>
<input type="text"	name="<%=HIN_NO %>" id="hinNo" value=""	maxlength="50" /> 
<label>Patient  Name</label> <input type="text" name="<%=P_FIRST_NAME %>" id="fName" value=""  maxlength="15" />
<%-- <label>Patient Mid Name</label> <input	type="text" name="<%=P_MIDDLE_NAME %>" id="mName" value="" maxlength="15" /><div class="clear"></div>
<label>Patient Last Name</label> <input type="text" name="<%=P_LAST_NAME%>" value="" id="lName" maxlength="15" /> --%>
<div class="clear"></div>


<input type="button" name="Submit" id="addbutton"
	onclick="{submitForm('search','/hms/hms/ot?method=searchPatientDetailsForEmergencyOTBooking');}"
	value="Search" class="button" accesskey="a" /> <!-- <input type="button" name="existingRecord" value="Existing Record's" id="addbutton" onclick="submitForm('search','/hms/hms/ot?method=searchHumanBodyPartsDisposal');"   class="button" accesskey="a" /> -->

</div>
</form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" /><div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="patientSearchForEmergencyOTBooking" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div id="edited">
</div>
<script type="text/javascript">
	formFields = [
			[0, "<%=HIN_ID%>", "id"], [1,"hin"], [2,"patName"], [3,"age"], [4,"gender"]];
	 statusTd = 4;
	</script></form>
</div>
<div class="clear"></div>
<script type="text/javascript" language="javascript">

	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "HIN"
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "hin";
	
	data_header[1] = new Array;
	data_header[1][0] = "Patient Name"
	data_header[1][1] = "data";
	data_header[1][2] = "20%";
	data_header[1][3] = "patName";
	
	data_header[2] = new Array;
	data_header[2][0] = "Age"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";
	data_header[2][3] = "age"

	data_header[3] = new Array;
	data_header[3][0] = "Gender"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "gender"
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { 
		System.out.println("v-patientList------jsp---->"+patientList.size());
			for(Patient patient : patientList){
				System.out.println("v-patient.getId()-----jsp----->"+patient.getId());
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%=patient.getId()%>
			data_arr[<%= counter%>][1] = "<%=patient.getHinNo()%>"
			<%
					String middleName = "";
					String lastName = "";
					if(patient.getPMiddleName() != null){
						middleName = patient.getPMiddleName();
					}
					if(patient.getPLastName() != null){
						lastName = patient.getPLastName();
					}
					
					%>
			data_arr[<%= counter%>][2] = "<%=patient.getPFirstName()%> <%=middleName%> <%=lastName%>"
			data_arr[<%= counter%>][3] = "<%=patient.getAge()%>"

		<% String gender="";
			if(patient.getSex() !=null){
				gender=patient.getSex().getAdministrativeSexName();
			}else{
				gender="-";
			}
		%>
			data_arr[<%= counter%>][4] = "<%=gender%>"	
			
		<%
			     counter++;
		    	}
			}
		%>
    	  formName = "patientSearchForEmergencyOTBooking"
    			
    			start = 0
    			if(data_arr.length < rowsPerPage){
    				end = data_arr.length;
    			}
    			else{
    				end = rowsPerPage;
    			
    			}
    			
    			makeTable(start,end);
	</script>
	
