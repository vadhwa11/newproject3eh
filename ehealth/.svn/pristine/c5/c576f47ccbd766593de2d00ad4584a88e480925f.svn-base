<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.BlTempOpBillHeader"%>


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>
<%	
		Map map = new HashMap();
		List<PatientPrescriptionHeader> prescriptionList = new ArrayList<PatientPrescriptionHeader>();
		List<BlTempOpBillHeader> tempBillList = new ArrayList<BlTempOpBillHeader>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("prescriptionList") != null)
			prescriptionList =(List<PatientPrescriptionHeader>)map.get("prescriptionList");
		
		if (map.get("tempBillList") != null)
			tempBillList =(List<BlTempOpBillHeader>)map.get("tempBillList");
%>
<%
	       	if (prescriptionList!=null && prescriptionList.size() > 0 ) 
	     	{ 
	     	%>
<label class="bodytextB">Prescription No.</label>
<select id="prescriptionNo" name="<%=PRESCRIPTION_NO %>" tabindex=1>
	<option value="">Select</option>
	<% 
	  
	     		for (PatientPrescriptionHeader prescriptionHeader : prescriptionList) {
	     			if(prescriptionHeader.getPrescriptionNo() != null){
	     	%>
	<option value="<%=prescriptionHeader.getPrescriptionNo()%>"><%=prescriptionHeader.getPrescriptionNo()%>
	</option>
	<% 
	     		}
	     		}%>
</select>
<%  } 
		     	 else
		     	 {
				 %>
<label> Prescription No.</label>
<input id="prescriptionNo" type="text" name="<%=PRESCRIPTION_NO %>"
	value="" tabindex=1 MAXLENGTH="30" />
<%} %>
<label>Temporary Bill No. </label>
<%
			if (tempBillList!=null && tempBillList.size() > 0 ) 
	     	{ 
			%>
<select id="tempBillNoId" name="tempBillNo"
	validate="Temporary Bill No,string,no" tabindex="1"
	onchange="disableFields(this);submitForm('billDispensingSearch','opBilling?method=searchPatientForBillDispensing&registered=yes','checkBlankSearch');">
	<option value="">Select</option>
	<% 
	     	
	     		for (BlTempOpBillHeader tempBlHd : tempBillList) {
				     
				%>
	<option value="<%=tempBlHd.getTempBillNo()%>"><%=tempBlHd.getTempBillNo()%>
	</option>
	<% } 
	     	
	     	 %>
</select>
<%}else{ %>


<input type="text" id="tempBillNoId" name="tempBillNo" value=""
	validate="Temporary Bill No,string,no" MAXLENGTH="30" tabindex=1
	onblur="disableFields(this);submitForm('billDispensingSearch','opBilling?method=searchPatientForBillDispensing&registered=yes','checkBlankSearch');" />

<%} %>

<script type="text/javascript">
	document.getElementById('prescriptionNo').focus();
</script>


		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</div>