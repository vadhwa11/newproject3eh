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
<%@page import="jkt.hms.util.HMSUtil"%>
 
<!-- <link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" /> -->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
  
<title>Pending Pre-Anesthesia Procedure Notes</title>
<div class="clear"></div>
<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		List<OpdSurgeryHeader>  patientList = new ArrayList<OpdSurgeryHeader> ();
		List<MasAdministrativeSex>  sexList = new ArrayList<MasAdministrativeSex> ();
		String otProcedure="";
		String url="";
		String minorOt="";
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("minorOt")!=null){
			minorOt=(String)map.get("minorOt");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		
		if(patientMap.get("patientList") != null){
			patientList= (List<OpdSurgeryHeader> )patientMap.get("patientList");
		}
		
		if(patientMap.get("sexList") != null){
			sexList= (List<MasAdministrativeSex> )patientMap.get("sexList");
		}
		
		  if(map.get("otProcedure") != null){
			otProcedure= (String)map.get("otProcedure");
		}
		  System.out.println("otProcedure=in jsp===="+otProcedure);
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
    %> <%if(otProcedure.equals("yes")){ %>
<div class="titleBg">
<h2>OT Procedure Notes Search</h2>
</div>
<%} else if(otProcedure.equals("no")){ %>
<div class="titleBg">
<h2>Pre Anesthesia Procedure Notes Search</h2>
</div>
<%} %>
<div class="clear"></div>
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
  <%
  if(minorOt.equalsIgnoreCase("yes")){ %>
  <input type="button" name="search" id="search" onclick="submitForm('search','/hms/hms/ot?method=showMinorOtPatientDetails&otProcedure=no');"
	value="Search" class="button" />
<%}	else if(otProcedure.equals("no")){ %>
<input type="button" name="search" id="search" onclick="submitForm('search','/hms/hms/ot?method=showOtPatientDetails&otProcedure=no');"
	value="Search" class="button" /><%}else if(otProcedure.equals("yes")){ %>
 <input type="button" name="search" id="search" onclick="submitForm('search','/hms/hms/ot?method=showOtPatientDetails&otProcedure=yes');"
	value="Search" class="button" /><%} %>
</div>
  </form>
  <%if(patientList!=null && patientList.size()>0) {%>
<div class="clear"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%if(otProcedure.equals("no")){ %>
<form name="preAnaesthesiaPatientSearch" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%}else if(otProcedure.equals("yes")){ %>
<form name="otProcedureNotesEntry" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%} %>
<table>
	<tr>
	 <th>SI No.</th>
	 <th>UHID</th>
	 <th>Patient Name</th>
     <th>IP No.</th>
     <th>Age</th>
     <th>Gender</th>
     </tr>
	  
	<%
	int  counter=0;
	for(OpdSurgeryHeader opdSurgeryHeader : patientList){
		counter++;
		 
		String age="";
		String patientName="";
	      
    	try
    	{
    		
      	  if(opdSurgeryHeader.getHin().getPFirstName()!= null)
      	  {
      		  patientName=opdSurgeryHeader.getHin().getPFirstName();
      	  }
      	  if(opdSurgeryHeader.getHin().getPMiddleName()!= null)
      	  {
      		  patientName +=" "+opdSurgeryHeader.getHin().getPMiddleName();
      	  }
      	  if(opdSurgeryHeader.getHin().getPLastName()!= null)
      	  {
      		  patientName +=" "+opdSurgeryHeader.getHin().getPLastName();
      	  }
    			if(opdSurgeryHeader.getInpatient()!=null && opdSurgeryHeader.getInpatient().getAge()!=null)
    			{
    				age=opdSurgeryHeader.getInpatient().getAge();
    			}else if(opdSurgeryHeader.getVisit()!=null && opdSurgeryHeader.getVisit().getAge()!=null)
    			{
    				age=opdSurgeryHeader.getVisit().getAge();
    			}
    	
    	}
    	catch (Exception e)
    	{
    	patientName = "-";
    	}
	 	
		%>
		<%if(otProcedure.equalsIgnoreCase("no")){ %>	
    	<tr onclick="submitForm('preAnaesthesiaPatientSearch','/hms/hms/ot?method=showPreAneaesthesiaProcNotesEntryJsp&surgeryHdId=<%=opdSurgeryHeader.getId()%>')" style="cursor: pointer;">

<%}else if(otProcedure.equalsIgnoreCase("yes")){ %>
		<tr onclick="submitForm('otProcedureNotesEntry','/hms/hms/ot?method=showOtProcedureNotesEntryJsp&surgeryHdId=<%=opdSurgeryHeader.getId()%>')" style="cursor: pointer;">

	<%} %>
		
		<td><%= counter%></td> 
		<td><%=opdSurgeryHeader.getHin().getHinNo() %></td>
	    <td><%=patientName%></td>
		<td><%=opdSurgeryHeader.getInpatient()!=null?opdSurgeryHeader.getInpatient().getAdNo():"" %></td>
		<td><%=age%></td>
		<td><%=opdSurgeryHeader.getHin().getSex().getAdministrativeSexName() %></td>
	 	</tr>
	<%} %>
</table>
 </form>
 
 <%} else{%>
 <h4>No Record Found..</h4>
 <%}%>