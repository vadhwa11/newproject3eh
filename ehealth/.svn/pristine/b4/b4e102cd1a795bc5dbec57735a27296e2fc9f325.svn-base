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

<%@page import="jkt.hms.masters.business.BlPaymentAdviceHeader"%>
<%@page import="jkt.hms.masters.business.BlPymntAdviceDispHeader"%>
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
		List<BlPaymentAdviceHeader> pymtAdvServNoList = new ArrayList<BlPaymentAdviceHeader>();
		List<BlPymntAdviceDispHeader> pymtAdvDispNoList = new ArrayList<BlPymntAdviceDispHeader>();

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		String url = "";
		
		String billType = "";
		if(map.get("billType") != null){
			billType = (String)map.get("billType");
		}
	
		if (map.get("pymtAdvServNoList") != null)
			pymtAdvServNoList =(List<BlPaymentAdviceHeader>)map.get("pymtAdvServNoList");
		
		if (map.get("pymtAdvDispNoList") != null)
			pymtAdvDispNoList =(List<BlPymntAdviceDispHeader>)map.get("pymtAdvDispNoList");
		
%>
<label> Payment Advice No.</label>
<select name="<%=PAYMENT_ADVICE_NO%>" id="pymtAdviceNoId"
	onblur="if(this.value != '' ){submitForm('search','opBilling?method=getDetailsForCashRefund');}">
	<option value="">Select</option>
	<%
	     	String pymntAdviceNo = "";
	       	if (pymtAdvServNoList!=null && pymtAdvServNoList.size() > 0 ) 
	     	{ 
	     		for (BlPaymentAdviceHeader adviceHeader : pymtAdvServNoList) {
	     			pymntAdviceNo = adviceHeader.getPaymentAdviceNo();
	     	%>
	<option value="<%=pymntAdviceNo%>"><%=pymntAdviceNo%></option>
	<script>
			 	document.getElementById('pymtAdviceNoId').focus();
			 	 </script>
	<%}
	     	}else if(pymtAdvDispNoList != null && pymtAdvDispNoList.size() > 0){
	     		for (BlPymntAdviceDispHeader adviceDispHeader : pymtAdvDispNoList) {
	     			pymntAdviceNo = adviceDispHeader.getPaymentAdviceNo();
	     	%>
	<option value="<%=pymntAdviceNo%>"><%=pymntAdviceNo%></option>
	<script>
			 	document.getElementById('pymtAdviceNoId').focus();
			 	 </script>
	<%}
	     		}%>
</select>
<%if(pymtAdvServNoList.size() > 0 && pymtAdvDispNoList.size() > 0){
			%>
<script>	 
			 	alert("No Payment Advice No. found.")
			 </script>
<%} %>
</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
