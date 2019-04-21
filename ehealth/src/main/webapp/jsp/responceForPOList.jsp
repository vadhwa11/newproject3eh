<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForPO List.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 12:07:2010   Name: Anand
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="java.util.*"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>



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
	<label>PO Number</label>
	
<%	
		Map map = new HashMap();
		List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
		
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if(map.get("poNumberList") != null){
			poHeaderList =(List<StorePoHeader>) map.get("poNumberList");
		}
	
%>

<select name="ponumber">
	<option value="">Select</option>
	
	<%for (StorePoHeader poHeader :poHeaderList ) {%>
	<option value="<%=poHeader.getPoNumber()%>"><%=poHeader.getPoNumber() %></option>
	<%
	}
	%>
</select>

		     	 <!--
		     	 
		     	 <DIV class=clear></DIV>
	<%--- Report Button   --%> 
	<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('billServiceReport','billing?method=printBillPrintingServicingReport');" accesskey="g" tabindex=1/>
		     	 
	    	
-->