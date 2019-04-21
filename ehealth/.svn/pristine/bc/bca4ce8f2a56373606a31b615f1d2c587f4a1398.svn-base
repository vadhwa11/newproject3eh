<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* messageForWard.jsp  
* Purpose of the JSP -  This is Messages for Ward
* @author  Mansi
* @author  Deepali
* Create Date: 21st Feb,2008 
* Revision Date:      
* Revision By: 
* @version 1.2
--%>


<%@page import="jkt.hms.masters.business.OpdGeneralSurgerySpeciality"%>
<%@page import="jkt.hms.masters.business.MasSpecialtyTemplate"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
message = (String)map.get("message");
}
String backUrl="";
if(map.get("backUrl") != null){
	backUrl = (String)map.get("backUrl");
}
String printUrl="";
if(map.get("printUrl") !=null){
	printUrl=""+map.get("printUrl");
}
int hinId=0;
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}
int visitId = 0;
if(map.get("visitId") != null){
	visitId = (Integer)map.get("visitId");
}


int opdPatientDetailId=0;
if(map.get("opdPatientDetailId") != null){
	opdPatientDetailId = (Integer)map.get("opdPatientDetailId");
}


String tempalteName="";
if (map.get("tempalteName") != null) {
	tempalteName = (String) map.get("tempalteName");
	}
System.out.println("tempalteName ---------->>>"+tempalteName);
%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message For Ward</title>
</head>
<body>
<form name="message" method="post"><br />
<h4><%= message %></h4> <br />
<div class="clear"></div>
  <input	type="hidden" name="hinId" id="hinId" value="<%=hinId%>" />
  <input	type="hidden" name="opdPatientDetailId" id="opdPatientDetailId" value="<%=opdPatientDetailId%>" />
  <input id="visitId" name="visitId" id="visitId" type="hidden" value="<%=visitId != 0?visitId:0%>" />
<%
	

if(!printUrl.equals("")){
%>
<div class="division"></div>
<input type="button" value="Print" class="button" onClick="submitForm('message','<%=printUrl%>');" />
<input type="button" value="Back" class="button" onClick="submitForm('message','<%=backUrl%>');" />

<%} %>

<% if(tempalteName.equals("General Surgery")){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Excel" onclick="submitFormForSpecialityReportExcel();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="<%=tempalteName%>">
<%}%> 
<% if(tempalteName.equals("Neonatal")){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="<%=tempalteName%>">
<%}%> 

<% if(tempalteName.equals("Antenatal Card")){ %>
<input name="button4" type="button" align="right" class="buttonBig"	value="Speciality Print" onclick="submitFormForSpecialityReport();" />
<input name="specialityTemplateName" id="specialityTemplateName" type="hidden" value="<%=tempalteName%>">
<%}%> 


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script>
function submitFormForSpecialityReportExcel()
{
	submitForm('message','ipd?method=showPatientSpecialityReportExcel');
	}

function submitFormForSpecialityReport(){
			submitForm('message','ipd?method=showPatientSpecialityReport');
			//checkTargetForNo();
		}
</script></form>	
</body>
</html>