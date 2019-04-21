<%@page import="jkt.hms.masters.business.MasHospitalwiseChargecode"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasHospitalwiseChargecode> masHospitalwiseChargecodeList = new ArrayList<MasHospitalwiseChargecode>();

if(request.getAttribute("map")!=null)
{
	map=(Map<String, Object>)request.getAttribute("map");
}
if(map.get("masHospitalwiseChargecodeList")!=null)
{
	masHospitalwiseChargecodeList=(List<MasHospitalwiseChargecode>)map.get("masHospitalwiseChargecodeList");
}

%>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
