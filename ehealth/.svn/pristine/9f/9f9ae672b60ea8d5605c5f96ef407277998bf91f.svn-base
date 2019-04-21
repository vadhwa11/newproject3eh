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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript">

function showSearch(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=searchOtPostAnesthesiaProcedure";
  obj.submit();
}
</script>
<title>Pending Post Anesthesia Procedure Notes</title>
<div class="titleBg">
<h2>Pending Post Anesthesia Procedure Notes</h2>
</div>
<div class="clear"></div>
<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		
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
		
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
		 
    %>
<div class="Block">
<h4>Patient Search</h4>
<div class="clear"></div>
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
<div class="clear"></div>
 <input type="button"  onclick="submitForm('search','/hms/hms/ot?method=showPostAnaesthesiaPatientDetails');"
	value="Search" class="button" />

</div>
</form>

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
 
<!-- 
<input type="button" name="Submit" id="addbutton"
	onclick="if(checkBlank()){submitForm('search','/hms/hms/ot?method=showPostAnaesthesiaPatientDetails');}"
	value="Search" class="buttonBig2" accesskey="a" />
<input type="button" name="Search" class="buttonBig2"
	value="Existing Record Search" onclick="showSearch('search')" /> -->
<div class="clear"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="postAnaesthesiaPatientSearch" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  <script type="text/javascript">
 formFields = [
			[0, "<%=HIN_ID%>", "id"],  [1,"hin"],[2,"ipn"], [3,"patName"], [4,"age"], [5,"gender"], [6,"bookingId"]];
	 statusTd = 5; 
	</script>  
	</form>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "UHID"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "hin"
	
	data_header[1] = new Array;
	data_header[1][0] = "IP No."
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "ipn"
	
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
	
	data_header[5] = new Array;
	data_header[5][0] = "Booking Id"
	data_header[5][1] = "hide";
	data_header[5][2] = "10%";
	data_header[5][3] = "bookingId"
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { 	
			for(OtBooking otBooking : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
	  	 
			data_arr[<%= counter%>][1] = '<%= otBooking.getHin().getHinNo()%>'
		 /* IPN */
			  data_arr[<%= counter%>][2] = "<%=otBooking.getInpatient() != null ?otBooking.getInpatient().getAdNo() :""%>"   
			<%--   <%
			   
			   if(otBooking.getInpatient().getAdNo()  != null )
			   {
				   
			%>
			data_arr[<%= counter%>][2] = "<%=otBooking.getInpatient().getAdNo()%>"
			<%
			   }else{
			%> 
			data_arr[<%= counter%>][2] = ""
		   
				<%
			   }
			  %> --%>   
			<%
					String middleName = "";
					String lastName = "";
					if(otBooking.getHin().getPMiddleName() != null){
						middleName = otBooking.getHin().getPMiddleName();
					}
					if(otBooking.getHin().getPLastName() != null){
						lastName = otBooking.getHin().getPLastName();
					}
					String age="";
					String gender="";
					if(otBooking.getHin().getAge() !=null){
					age=otBooking.getHin().getAge();
					}
					if(otBooking.getHin().getSex() !=null){
						gender=otBooking.getHin().getSex().getAdministrativeSexName();
					}
					%>
			data_arr[<%= counter%>][3] = "<%=otBooking.getHin().getPFirstName()+" "+middleName+" "+lastName %>";
			data_arr[<%= counter%>][4] = "<%=age%>"
			data_arr[<%= counter%>][5] = "<%=gender%>"
			data_arr[<%= counter%>][6] = "<%=otBooking.getId()%>"
		<%     counter++;
		    	}
			}
		%>
		
    formName = "postAnaesthesiaPatientSearch"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;	
	}
	makeTable(start,end);		
	</script>
