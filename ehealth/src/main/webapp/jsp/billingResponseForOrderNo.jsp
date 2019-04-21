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
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>



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
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		if (map.get("orderNoList") != null)
			orderNoList =(List<DgOrderhd>)map.get("orderNoList");

%>
<div id="testDiv"><label class="bodytextB">Order No.: </label> <select
	name="<%=ORDER_NO%>" validate="Order No,string,no"
	onchange="disableFields(this)">
	<option value="">Select</option>
	<% 
	     	if (orderNoList!=null && orderNoList.size() > 0 ) 
	     	{ 
	     		for (DgOrderhd orderhd : orderNoList) {
				     	boolean flag = false;
	    				Set<DgOrderdt> orderDtSet = new HashSet<DgOrderdt>();
	    				orderDtSet = orderhd.getDgOrderdts();
	    				for(DgOrderdt orderdt : orderDtSet){
	    					if(orderdt.getPaymentMade().equals("n")){
	    						flag = true;
	    						break;
	    					}
	    				}
	    				if(flag){
				%>
	<option value="<%=orderhd.getOrderNo()%>"><%=orderhd.getOrderNo()%>
	</option>
	<% } 
	     		}
			} 
	     	
	     	 %>
</select>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</div>