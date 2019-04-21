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
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>





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
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<%
		Map map = new HashMap();
		List<Inpatient> admissionNoList = new ArrayList<Inpatient>();

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		String flag = "";
		String url = "";
		String billType = "";

		if(map.get("flag") != null){
			flag = (String)map.get("flag");
		}
		if(map.get("billType") != null){
			billType = (String)map.get("billType");
		}

		if(flag.equals("finalBill")){
			url = "submitForm('search','billing?method=getPatientDetailsForFinalBill','checkAdNo')";

		}else if(flag.equals("finalSettlement")){
			url = "submitProtoAjaxWithDivName('patientSettlementSearch','billing?method=getFinalBillNo','billNoDiv')";

		}else if(flag.equals("billDispensing")){
			url = "submitForm('ipBillDispensingSearch','billing?method=searchPatientForIPBillDispensing')";

		}else if(flag.equals("cancelChargeSlip")){
			url = "submitProtoAjaxWithDivName('searchChargeSlipCancel','billing?method=searchChargeSlipForCancellation','chargeSlipDiv');";

		}else if(flag.equals("advice") && billType.equals("servicing")){
			url = "submitProtoAjaxWithDivName('search','billing?method=searchChargeSlipNoForPymntAdv','chargeSlipDiv');";

		}else if(flag.equals("advice") && billType.equals("dispensing")){
			url = "submitProtoAjaxWithDivName('search','opBilling?method=getBillNoForPaymentAdvice&"+BILL_TYPE+"="+billType+"&flag=advice','testDiv');";

		}else if(flag.equals("cancelDispensingBill")){
			url = "submitProtoAjaxWithDivName('searchChargeSlipCancel','billing?method=searchBillForCancellation','chargeSlipDiv');";

		}else if(flag.equals("billing")){
			/* url = "submitForm('search','billing?method=getPatientDetails','checkAdNo')"; */
		url = "submitForm('search','billing?method=getPatientDetailsForFinalBill','checkAdNo')";

		}else if(flag.equals("patientIssue")){
			url = "submitProtoAjax('patientDrugIssue','billing?method=getPatientDrugIssueDetails','checkAdNo')";
		}
		else if(flag.equals("finalbillingDup")){
			url = "submitProtoAjaxWithDivName('ipFinalBillReport','/hms/hms/billing?method=getInpatientId','appDiv');";
		}

		if (map.get("adNoList") != null)
			admissionNoList =(List<Inpatient>)map.get("adNoList");
		System.out.println("admissionNoList==="+admissionNoList.size());
%>
<%
	     	String adNo = "";
int hin_id=0;
String name="";
	       	if (admissionNoList!=null && admissionNoList.size() > 0 )
	     	{
	     		for (Inpatient inpatient : admissionNoList) {
	     			adNo =inpatient.getAdNo();
	     			hin_id=inpatient.getHin().getId();
	     			name=inpatient.getHin().getPFirstName();
	     		}
	     	}
	     	%>

<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
	<input type="hidden" name="<%=HIN_ID%>" id="<%=HIN_ID%>" value="<%=hin_id%>"/>
	<input type="text" name="<%=AD_NO%>" id="adNoId" value="<%=adNo%>"
	MAXLENGTH="30" onblur="<%=url %>" />
	<label>Patient Name</label>
	<input type="text" name="patientName" id="patientName"
			value="<%=name %>" MAXLENGTH="30"  /> 
<script>
			 	document.getElementById('adNoId').focus();
			<%
				if(adNo.equals(""))
				{
			%>
			 		alert("No IP No Found for <%=prop.getProperty("com.jkt.hms.registration_no") %>")
	    	<%
	    		}
			%>
			 </script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
