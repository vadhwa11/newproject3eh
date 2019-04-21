<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * storeInvoiceResponse.jsp  
 * Purpose of the JSP -  This is for Local Purchase.
 * @author  Othivadivel K R
 * Create Date: 23.07.2009 
 
 * Revision Date:      
 * Revision By: 
 * @version 1.15
--%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>

<%@page import="jkt.hms.masters.business.MasLionc"%>
<%@page import="jkt.hms.util.HMSUtil"%> 
<%@page import="java.math.BigDecimal"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> poQtyMap = new HashMap<String, Object>();
	int pageNo = 1;
	int poId = 0;
	int srNo = 0;
	String max = "";
	BigDecimal netAmount = null;
	
	
	List<MasLionc> masLionClassList = new ArrayList<MasLionc>();
	
	
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	if (map.get("masLionClassList") != null) {
		masLionClassList = (List<MasLionc>)map.get("masLionClassList");
	}
	session.setAttribute("masLionClassList", masLionClassList);
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	BigDecimal invoiceAmount = new BigDecimal(0);
	String status="o";
	


	

	
%>


	<label>Lionc Code</label> 
	<select id="lioncCode" name="<%=LIONC_CODE%>" validate="Lionc Code,string,no"	class="large" tabindex=1>
	<option value="">Select</option>
	<%for (MasLionc masLionc : masLionClassList) { %>	 
	<option value="<%=masLionc.getId()%>"><%=masLionc.getComponent() %></option>  
	  	
<%}%>
</select>	  	
	

	 




<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
