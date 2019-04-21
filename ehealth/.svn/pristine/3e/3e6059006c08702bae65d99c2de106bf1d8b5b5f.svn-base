<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlChargeSlipMain"%>
 
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
		List<BlChargeSlipMain> chargeSlipNoList = new ArrayList<BlChargeSlipMain>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		if (map.get("chargeSlipNoList") != null)
			chargeSlipNoList =(List<BlChargeSlipMain>)map.get("chargeSlipNoList");
	
		String billType = "";
		if(map.get("billType") != null){
			billType = (String)map.get("billType");
		}
		String url = "submitForm('search','billing?method=getPatientDetailsForIPPaymentAdvice&"+BILL_TYPE+"="+billType+"')";
%>
<label class="bodytextB">Charge Slip No.</label>
<%
			if (chargeSlipNoList !=null && chargeSlipNoList.size() > 0 ) 
	     	{ 
			%>
<select name="<%=CHARGE_SLIP_NO%>" validate="chargeSlipNo,metachar,no"
	onchange="<%=url %>">
	<option value="">Select</option>
	<% 
	     		for (BlChargeSlipMain chargeSlipMain : chargeSlipNoList) {
		%>
	<option value="<%=chargeSlipMain.getChargeSlipNo()%>"><%=chargeSlipMain.getChargeSlipNo()%>
	</option>
	<%  
	     		}
	     	 %>
</select>
<%}else{ %>
<input type="text" name="<%=CHARGE_SLIP_NO%>" id="chargeSlipId" value=""
	MAXLENGTH="30" onblur="" validate="chargeSlipNo,metachar,no"/>

<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
