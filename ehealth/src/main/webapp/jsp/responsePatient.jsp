<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script>
var alt1 ="Already Registered Information with Service No :"
var alt='';
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<Patient> patientList = new ArrayList<Patient>();
	List<Patient> patientListForInfo = new ArrayList<Patient>();
	Patient patientList2 = new Patient();
	String alertMsg ="Already Registered Information with Service No :";
	String srNo= "";
	try{
	if(map.get("patientListForInfo") != null){
		patientListForInfo = (List<Patient>)map.get("patientListForInfo");
		if(patientListForInfo.size() >0){
			for(Patient patient3 :patientListForInfo ){
				srNo=patient3.getServiceNo();
				alertMsg = patient3.getPFirstName()+" "+patient3.getPMiddleName()+" "+patient3.getPLastName()+" ("+patient3.getRelation().getRelationName()+") ";
				%>
				alt =alt+'<%=alertMsg%>'+'\n'
				<%
			}
			
		}
	}
	}catch(Exception ee){
		ee.printStackTrace();		
	}
	if(map.get("patientList") != null){
		patientList = (List<Patient>)map.get("patientList");
		if(patientList.size() > 0){
			
%>
		alert("Patient is already registered..\n")
		
		document.getElementById('serviceTypeId').value = '0';
		document.getElementById('serviceNoId').value = '';
		document.getElementById('relationId').value = '0';
		document.getElementById('serviceStatusId').value = '0';
		document.getElementById('pFirstNameId').value = '';
		document.getElementById('sFNameId').value = '';
		document.getElementById('sMNameId').value = '';
		document.getElementById('sLNameId').value = '';
		document.getElementById('hinNoDivId').innerHTML = "";
			<%}else{
			%>
				getHin()
			<%
				}
			}
			if(!srNo.equals("")){
			%>
			alert(alt1+'<%=srNo%>'+'\n'+alt)
			<%}%>
</script>