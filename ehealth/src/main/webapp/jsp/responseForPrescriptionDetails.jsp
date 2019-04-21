<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : orderStatusForWardManagment.jsp
	 * Tables Used         :
	 * Description         : For Viewing All Order No For IPD .
	 * @author Name        : Naresh Kumar
	 * Revision Date	   : Revision By:
	 * @version 1.0
--%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientStoreIndentDetails"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>


<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<PatientPrescriptionDetails> prescpDetailsList = new ArrayList<PatientPrescriptionDetails>();
		List<PatientStoreIndentDetails> patientIndDetailsList = new ArrayList<PatientStoreIndentDetails>();

		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}

		if (map.get("prescpDetailsList") != null){
			prescpDetailsList =(List<PatientPrescriptionDetails>)map.get("prescpDetailsList");
		}
		if (map.get("patientIndDetailsList") != null){
			patientIndDetailsList =(List<PatientStoreIndentDetails>)map.get("patientIndDetailsList");
		}

	%>

<div class="clear"></div>

<div class="clear"></div>
<h4>Prescription Item Details</h4>
<div class="clear"></div>
<%
		if (prescpDetailsList != null && prescpDetailsList.size() > 0)
		{
		%>

<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Item Code</th>
		<th scope="col">Item Name</th>
		<th scope="col">Dose</th>
		<th scope="col">Days</th>
		<th scope="col">Frequency</th>
		<th scope="col">Quantity</th>
	</tr>
	<tbody id="tableData">
		<%
			for(PatientPrescriptionDetails prescDt : prescpDetailsList){
	%>
		<tr>
			<td><%=prescDt.getItem().getPvmsNo() %></td>
			<td><%=prescDt.getItem().getNomenclature() %></td>
			<td><%=prescDt.getDosage()%></td>
			<td><%=prescDt.getNoOfDays()%></td>
			<td><%=prescDt.getFrequency().getFrequencyName() %></td>
			<td><%=prescDt.getTotal() %></td>
		</tr>
		<%} %>
	</tbody>
</table>

<%}else if (patientIndDetailsList != null && patientIndDetailsList.size() > 0)
{ %>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Item Code</th>
		<th scope="col">Item Name</th>
		<th scope="col">Quantity</th>
	</tr>
	<tbody id="tableData">
		<%
			for(PatientStoreIndentDetails prescDt : patientIndDetailsList){
	%>
		<tr>
			<td><%=prescDt.getItem().getPvmsNo() %></td>
			<td><%=prescDt.getItem().getNomenclature() %></td>
			<td><%=prescDt.getQtyRequest() %></td>
		</tr>
		<%} %>
	</tbody>
</table>
<%}else{ %>
<h4>No Record Found!</h4>
<%}%>