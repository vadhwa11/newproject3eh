<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Name: Ritu
	 * Create Date: 22.07.2009   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="java.math.BigDecimal"%>


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
List<BigDecimal> dispensingPriceList = new ArrayList<BigDecimal>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		BigDecimal dispensingPrice = new BigDecimal(0);
		
		if (map.get("dispensingPriceList") != null){
			dispensingPriceList =(List<BigDecimal>)map.get("dispensingPriceList");
		}
		if(dispensingPriceList.get(0) != null){
			dispensingPrice = dispensingPriceList.get(0);
		}
%>
<input type="text" id="chargeAmtId" name=<%=DISPENSING_PRICE %>
	value="<%=dispensingPrice %>" readonly="readonly" />
<input type="hidden" name="<%=RATE %>" id="rateId"
	value="<%= dispensingPrice %>" />
<script>
		 	document.getElementById('qtyId').value = '1'
		 
		 </script>
		 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
