<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForBillNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * @author  Create Date: 18.02.2008   
	 * Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.BlDispensingHeader"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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
		List<BlOpBillHeader> billServicingNoList = new ArrayList<BlOpBillHeader>();		
		List<BlDispensingHeader> billDispensingNoList = new ArrayList<BlDispensingHeader>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		String url = "";
		String flag = "";
		if(map.get("flag") != null){
			flag = (String)map.get("flag");
		}
		String billType = "";
		if(map.get("billType") != null){
			billType = (String)map.get("billType");
		}
		String patientType = "";
		if(map.get("patientType") != null){
			patientType = (String)map.get("patientType");
		}
		
		if(flag.equals("advice")){
			if(patientType.equals("op")){
				url = "submitForm('search','opBilling?method=getPatientDetailsForPaymentAdvice&"+BILL_TYPE+"="+billType+"','checkBillNo')";
			}else if(patientType.equals("ip")){
				url = "submitForm('search','billing?method=getPatientDetailsForIPPaymentAdvice&"+BILL_TYPE+"="+billType+"','checkBillNo')";
			}
		}
		else if(flag.equals("refund"))
			url = "submitProtoAjaxWithDivName('search','opBilling?method=getPaymentAdviceNoForCashRefund&"+BILL_TYPE+"="+billType+"','pymtAdvDiv')";
		
		if (map.get("billServicingNoList") != null)
			billServicingNoList =(List<BlOpBillHeader>)map.get("billServicingNoList");
		
		if (map.get("billDispensingNoList") != null)
			billDispensingNoList =(List<BlDispensingHeader>)map.get("billDispensingNoList");
		
		String name = "";
		for (BlOpBillHeader billHeader : billServicingNoList) {
			name =billHeader.getHin().getPFirstName();
			break;
		}
		
%>

<label>Patient Name</label>
	<input type="text" name="patientName" id="patientName"
			value="<%=name %>" MAXLENGTH="30"  /> 

<label> Bill No.</label>
<select name="<%=BILL_NO%>" id="billNoId" onblur="<%=url %>" validate="Bill No.,metachar,no">
	<option value="">Select</option>
	<%
	     	String billNo = "";
	       	if (billServicingNoList!=null && billServicingNoList.size() > 0 ) 
	     	{ 
	     		for (BlOpBillHeader billHeader : billServicingNoList) {
	     			billNo = billHeader.getBillNo();
	     	%>
	<option value="<%=billNo%>"><%=billNo%></option>
	<script>
			 	document.getElementById('billNoId').focus();
			 	 </script>
	<%}
	     	}else if(billDispensingNoList != null && billDispensingNoList.size() > 0){
	     		for (BlDispensingHeader dispensingHeader : billDispensingNoList) {
	     			billNo = dispensingHeader.getBillNo();
	     	%>
	<option value="<%=billNo%>"><%=billNo%></option>

	<%}
	     		}%>
</select>
<%if(billServicingNoList.size() > 0 && billDispensingNoList.size() > 0){
			%>
<script>	 
			 	alert("No Bill No. Found for hin.")
			 </script>
<%} %>
</div>
<script>
			 	document.getElementById('billNoId').focus();
		</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
