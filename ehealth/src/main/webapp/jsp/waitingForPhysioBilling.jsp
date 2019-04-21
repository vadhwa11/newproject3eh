<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp
 * Purpose of the JSP -  This is for Birth Message.
 * @author  Diapli
 * Create Date: 26 April,2008
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="jkt.hms.masters.business.Visit"%> 

<%
 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	List<Visit> patientList = new ArrayList<Visit>();
 %>

<%@page import="jkt.hms.util.HMSUtil"%>
<form name="messageMisBirth"  method="post">
<div class="titleBg">
<h2></h2>
</div>
<%
	if (map.get("patientList") != null) {
		patientList = (List<Visit>) map.get("patientList");
	}
%>
<div class="Block">

</div>
<table>
<thead>
<tr>
<th>Registration No.</th>
<th>Patient Name</th>
<th>Age</th>
<th>Visit Date</th>
<th>Doctor Name</th>
<th>Visit No.</th>
<th>Token No.</th>
<th>&nbsp;</th>
</tr>
</thead>
<%
	for (Visit v : patientList) {
%>
<tr>
<td><%=v.getHin().getHinNo()%>  </td>
<td><%=v.getHin().getPFirstName().concat(" ").concat(
						v.getHin().getPLastName())%></td>
<td><%=v.getAge()%></td>
<td><%=v.getVisitDate()%></td>
<td><%=v.getDoctor().getFirstName().concat(" ").concat(v.getDoctor().getLastName())%></td>
<td><%=v.getVisitNo()%></td>
<td><%=v.getTokenNo()%></td>
<td><input  type="button" value="Billing" class="button" onclick="getBillingPage('<%=v.getHin().getHinNo().trim()%>',<%=v.getId() %>,<%=v.getDoctor().getId() %>);" /></td>
</tr>

<%
	}
%>
</table> 

<script>
function getBillingPage(hinNo,visitId,docId){
	//var hinNo="";
	submitForm('messageMisBirth','opBilling?method=getPatientDetailsForOpBilling&registered=yes&hinNo='+hinNo+'&visitId='+visitId+'&docId='+docId);
}

</script> 
<div class="clear"></div>
 <br />
<br />


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
