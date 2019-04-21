<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReport.jsp  
 * Purpose of the JSP -  This is for Appropration Register Report.
 * @author  Ujjwal
 * Create Date: 13th May , 2011 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BudVoucherHeader"%>

<%@page import="jkt.hms.masters.business.BudEstimateEntry"%><script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>  <br />
<h2>VoucherWise Expenditure Report</h2>
<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					
			 	List<BudEstimateEntry> budEstimateEntryList = new ArrayList<BudEstimateEntry>();
			 	
				
			 	if (map.get("budEstimateEntryList") != null) {
			 		budEstimateEntryList = 			(List<BudEstimateEntry>) map.get("budEstimateEntryList"); 	

			 	}
			 %>

<form name="voucherReport" method="post" action="">
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date</label>
<input type="text" id="fromDate" readonly="readonly" name="fromDate" value="" validate="Start Date,date,yes"  class="date"  />
<img src="/hms/jsp/images/cal.gif" onClick="javascript:setdate('',document.voucherReport.fromDate,event)" width="16" height="16" border="0" validate="Pick a date" class="calender" />
<label><span>*</span> To Date</label>
<input type="text" id="toDate" readonly="readonly" name="toDate" value="" validate="End Date,date,yes"  class="date"  />
<img src="/hms/jsp/images/cal.gif" onClick="javascript:setdate('',document.voucherReport.toDate,event)" width="16" height="16" border="0" validate="Pick a date" class="calender" />
<div class="clear"></div>
<label> Sector Type</label> 
<select name="sectorType" id="sectorType"  validate="Sector Type,string,yes">
<option value="0">Select</option>
<%for(BudEstimateEntry budVoucherHeaderss:budEstimateEntryList){ %>
<option value="<%=budVoucherHeaderss.getSectorType()%>">
<%=budVoucherHeaderss.getSectorType()%></option>
<%}%>
</select>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('voucherReport','budget?method=printMonthlyObjectWiseVoucherExpenditure');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

