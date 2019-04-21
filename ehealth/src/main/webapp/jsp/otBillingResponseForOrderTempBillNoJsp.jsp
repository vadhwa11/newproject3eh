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

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlTempOpBillHeader"%>



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
		List<OpdSurgeryHeader> orderNoList = new ArrayList<OpdSurgeryHeader>();
		List<BlTempOpBillHeader> tempBillList = new ArrayList<BlTempOpBillHeader>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		if (map.get("orderNoList") != null)
			orderNoList =(List<OpdSurgeryHeader>)map.get("orderNoList");
		
		if (map.get("tempBillList") != null)
			tempBillList =(List<BlTempOpBillHeader>)map.get("tempBillList");

%>
<div id="testDiv"><label>Order No.</label> <%

			if (orderNoList!=null && orderNoList.size() > 0 ) 
	     	{ 
			%> <select id="orderNoId" name="<%=ORDER_NO%>"
	validate="Order No,string,no" tabindex="1"
	onchange="disableFields(this);submitForm('otBillServicingOpSearch','ot?method=getPatientDetailsForOpBilling&registered=yes','checkHinValue');">
	<option value="">Select</option>
	<% 
	     	
	     		for (OpdSurgeryHeader orderhd : orderNoList) {
				     
				%>
	<option value="<%=orderhd.getOrderNo()%>"><%=orderhd.getOrderNo()%>
	</option>
	<% } 
	     		
	     	}
			%>
			
	     	 <label>Temporary Bill
No. </label> <%
			if (tempBillList!=null && tempBillList.size() > 0 ) 
	     	{ 
			%> <select id="tempBillNoId" name="tempBillNo"
	validate="Order No,string,no" tabindex="1"
	onblur="disableFields(this);submitForm('billServicingOpSearch','opBilling?method=getPatientDetailsForOpBilling&registered=yes','checkHinValue');">
	<option value="">Select</option>
	<% 
	     	
	     		for (BlTempOpBillHeader tempBlHd : tempBillList) {
				     
				%>
	<option value="<%=tempBlHd.getTempBillNo()%>"><%=tempBlHd.getTempBillNo()%>
	</option>
	<% } 
	     	
	     	 %>
</select> <%}else{ %> <input type="text" id="tempBillNoId" name="tempBillNo"
	value="" validate="Temporary Bill No,string,no" MAXLENGTH="30"
	tabindex=1
	onblur="disableFields(this);submitForm('billServicingOpSearch','opBilling?method=getPatientDetailsForOpBilling&registered=yes','checkHinValue');" />

<%} %> <script type="text/javascript">
	document.getElementById('orderNoId').focus();
</script></div>