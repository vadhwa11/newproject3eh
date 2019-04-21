<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionDetails"%>
<%@page import="java.math.BigDecimal"%><html>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map<String,Object>)request.getAttribute("map");
}
List<InpatientPrescriptionDetails> inPatientPrescriptionDetailsList = new ArrayList<InpatientPrescriptionDetails>();

inPatientPrescriptionDetailsList = (List<InpatientPrescriptionDetails>)map.get("inPatientPrescriptionDetailsList");

if(inPatientPrescriptionDetailsList.size()>0){
%>
 <div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Prescription details</h4>
<div class="clear"></div>
<input	type="button" name="add" onClick="jsAdd()" value="Add Prescription"	class="buttonBig3" />

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Collected<input name="checkall" class="radioCheck" value="Collected All" id="addbutton" onclick="CheckAll(this);" align="right" type="checkbox"></th>
 		<th scope="col">Item Code</th>
		<th scope="col">Item Name</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No of Days</th>
 		<th scope="col">Qty.</th>
	</tr>
	<%
	int i=1;
	int ipdId =0;
	for(InpatientPrescriptionDetails over : inPatientPrescriptionDetailsList)
	{

		int qty=0;
		if(over.getTotal()!=null)
		{
 			qty = over.getTotal();
		}
		ipdId = over.getPrescription().getId();
		%>
	<tr>
		<td><input type="hidden" id="collected<%=i%>" name="collected_value" value="n" />
		<input id="checkId<%=i%>" name="collected" type="checkbox"  class="radioCheck" value="n" onclick="numberForCheckBoxClicked(<%=i%>);" />
		</td>
		<input type="hidden" name="rowLength" id="rowLength" value="<%=inPatientPrescriptionDetailsList.size()%>"/>
		<td><input type="hidden" name="itemC<%=i%>" id="itemC<%=i%>" value="<%=over.getItem().getPvmsNo()%>"><%=over.getItem().getPvmsNo() %></td>
		<td><input type="hidden" name="itemN<%=i%>" id="itemN<%=i%>" value="<%=over.getItem().getNomenclature()%>[<%=over.getItem().getPvmsNo()%>]"><%=over.getItem().getNomenclature()%></td>
		<td><input type="hidden" name="dosage<%=i%>" id="dosage<%=i%>" value="<%=over.getDosage()%>"><%=over.getDosage()%></td>
		<td><input type="hidden" name="frequency<%=i%>" id="frequency<%=i%>" value="<%=over.getFrequency().getId()%>"><%=over.getFrequency().getFrequencyName()%></td>
		<td><input type="hidden" name="nofday<%=i%>" id="nofday<%=i%>" value="<%=over.getNoOfDays()%>"><%=over.getNoOfDays()%></td>
	 	<td><input type="hidden" name="qty<%=i%>" id="qty<%=i%>" value="<%=qty%>"><%=qty%></td>
		<input type="hidden" id="itemI<%=i %>" name="itemI<%=i%>" value="<%=over.getItem().getId()%>"/>
	</tr>
	<% i++;} %>
	<input type="hidden" name="inpId" id="inpId" value="<%=ipdId%>" />
</table>
<%}else{%>
<div class="clear"></div>
<h4>No Records Found!!</h4>
<div id="statusMessage"></div>
<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</html>
		