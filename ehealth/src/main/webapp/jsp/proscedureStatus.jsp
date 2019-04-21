<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.IpdCareDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%

Map<String, Object> map = new HashMap<String, Object>();
List<IpdCareDetails> ipdCareDetailList=new ArrayList<IpdCareDetails>();
List<IpdCareDetails> localIpdCareDetailList=new ArrayList<IpdCareDetails>();
NursingcareSetup nursingcareSetup=null;

if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}

if (map.get("ipdCareDetailList") != null) {
	ipdCareDetailList = (List<IpdCareDetails>) map.get("ipdCareDetailList");
}

if (map.get("nursingcareSetup") != null) {
	nursingcareSetup = (NursingcareSetup) map.get("nursingcareSetup");
}

if(ipdCareDetailList.size()>0)
{
	//nursingcareSetup=ipdCareDetailList.get(0).getCareHeader().getNursingcareSetup();
localIpdCareDetailList=HMSUtil.getIpdCareDetails(ipdCareDetailList, nursingcareSetup.getNursing().getId());

}
%>

<div class="division"></div>
<div class="Clear"></div>
<div class=paddingTop25></div>
<div class="Clear"></div>
<h4>Procedure Details For Selected Procedure</h4>

<%if(nursingcareSetup==null) {%>
<table width="100%" border="0" cellpadding="2" cellspacing="2"	class="grid_header">


	<thead>
		<tr>
			<th>Status</th>
		</tr>
		</thead>
		<tbody>
		<tr>
		<td>No Data Exists</td>
		</tr>
		
		</tbody>
		</table>
<%} else if(nursingcareSetup.getStopCare()==null || nursingcareSetup.getStopCare().equalsIgnoreCase("y")){%>
<table width="100%" border="0" cellpadding="2" cellspacing="2"	class="grid_header">


	<thead>
		<tr>
		<th>Procedure Name</th>
		<th>Status</th>
		</tr>
		</thead>
		<tbody>
		<tr>
		<td><%=nursingcareSetup.getNursing().getNursingName() %></td>
		<td>Stoped</td>
		</tr>
		</tbody>
		</table>
<%}else{ %>
<table width="100%" border="0" cellpadding="2" cellspacing="2"	class="grid_header">

<thead>
		<tr>
		<th>Procedure Name</th>
		<%for(int i=1;i<=nursingcareSetup.getFrequency().getFrequencyCount().intValue();i++) {%>
		<th><%=i %></th>
		<%} %>
		</tr>
		</thead>
		<tbody>
		<tr>
		<td><%=nursingcareSetup.getNursing().getNursingName() %></td>
		<%
		int i=1;
		for(IpdCareDetails careDetails:localIpdCareDetailList){ %>
		<td>Done</td>
		<%i++;
		} %>
		<%for(;i<=nursingcareSetup.getFrequency().getFrequencyCount().intValue();i++) {%>
		<td>Pending</td>
		<%} %>
		</tr>
		</tbody>
		</table>

<%} %>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</body>
</html>