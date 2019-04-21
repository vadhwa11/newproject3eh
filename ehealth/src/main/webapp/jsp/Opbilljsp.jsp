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

<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.BlFinalBillDetails"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>



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
		List<Object[]> billList1 = new ArrayList<Object[]>();
		
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("billList") != null)
			billList1 =(List<Object[]>)map.get("billList");
	
%>
<%
	       	if (billList1!=null && billList1.size() > 0 ) 
	     	{ 
	     	%>

			<select id="billNo" name="billNo" onchange="openPopUp();">
			<option value="0">Select</option>
<% 
     		for (Object[] obj : billList1) 
     		{
%>
				<option value="<%=obj[0]%>"><%=obj[0]+" - "+HMSUtil.convertDateToStringWithoutTime((Date)obj[1])%></option>
<% 
	     	}
%>
			</select>
<%  
			} 
%>
				<!--
		     	 
		     	 <DIV class=clear></DIV>
	<%--- Report Button   --%> 
	<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('billServiceReport','billing?method=printBillPrintingServicingReport');" accesskey="g" tabindex=1/>
		     	 
	    	
-->