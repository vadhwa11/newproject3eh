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

<script type="text/javascript" src="/hms/jsp/js/sortTable.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>

<script type="text/javascript">

function showSearch(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=searchOtSpecimenDispatchEntry";
  obj.submit();
}
</script>
<div class="titleBg">
<h2>Specimen Dispatch Entry Search</h2>
</div>
<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="Block">
<h4>Patient Search</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		
		if(patientMap.get("patientList") != null){
			patientList= (List<OtBooking>)patientMap.get("patientList");
		}
	%> <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %>


<div class="clear"></div>
<label>UHID</label> <input type="text" name="<%=HIN_NO %>" id="hinNo"value="" maxlength="50" />
<label>Patient  Name</label> <input type="text" name="<%=P_FIRST_NAME %>" id="fName" value="" maxlength="15" />
<%-- <label>Patient Mid Name</label> <input type="text" name="<%=P_MIDDLE_NAME %>" id="mName" value="" maxlength="15" /><div class="clear"></div>
<label>Patient Last Name</label> <input type="text" name="<%=P_LAST_NAME%>" value="" id="lName" maxlength="15" />
 --%>
<div class="clear"></div>

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
 </script> <input type="button" name="Submit" id="addbutton" 
	onclick="if(checkBlank()){submitForm('search','/hms/hms/ot?method=showSpecimenDispatchEntryPatientDetails');}"
	value="New Record Search" class="inputButtonAutu" accesskey="a" /> <input
	type="button" name="Search" class="inputButtonAutu"
	value="Existing Record Search" onclick="showSearch('search')" />
</div>
</form>
<div class="clear"></div>
<div class="clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="specimenDispatchEntryPatientSearch" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"hin"],[2,"bookingId"], [3,"patName"], [4,"age"], [5,"gender"]];
	 statusTd =5;
	</script></form>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "HIN"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "hin"
	
		data_header[1] = new Array;
	data_header[1][0] = "Booking Id"
	data_header[1][1] = "hide";
	data_header[1][2] = "15%";
	data_header[1][3] = "bookingId";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "patName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Age"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "age";
	
	data_header[4] = new Array;
	data_header[4][0] = "Gender"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "gender"
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(OtBooking patient : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getHin().getId()%>
			data_arr[<%= counter%>][1] = <%= patient.getHin().getHinNo()%>
			data_arr[<%= counter%>][2] = "<%=patient.getId()%>"
			<%
					String middleName = "";
					String lastName = "";
					if(patient.getHin().getPMiddleName() != null){
						middleName = patient.getHin().getPMiddleName();
					}
					if(patient.getHin().getPLastName() != null){
						lastName = patient.getHin().getPLastName();
					}
					String age="";
					String gender="";
					if(patient.getHin().getAge() !=null){
						age=patient.getHin().getAge();
					}
					if(patient.getHin().getSex() !=null){
						gender	=patient.getHin().getSex().getAdministrativeSexName();
					}else{
						
					}
					%>
			data_arr[<%= counter%>][3] = "<%=patient.getHin().getPFirstName()%> <%=middleName%> <%=lastName%>"
			data_arr[<%= counter%>][4] = "<%=age%>"
			data_arr[<%= counter%>][5] = "<%=gender%>"
		<%
				
				     counter++;
		    	}
			}
		%>
		
    formName = "specimenDispatchEntryPatientSearch"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
</div>