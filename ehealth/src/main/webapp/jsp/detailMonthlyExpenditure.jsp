<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReport.jsp  
 * Purpose of the JSP -  This is for Voucher Report.
 * @author  Ujjwal
 * Create Date: 10th May , 2011 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BudVoucherHeader"%>

<%@page import="jkt.hms.masters.business.BudEstimateEntry"%>
<%@page import="jkt.hms.masters.business.BudMinorHead"%><script type="text/javascript" language="javascript">
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
	<div class="titleBg">
<h2>Monthly Planned Expenditure Report</h2>
</div>
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
					
			 	List<BudEstimateEntry> budVoucherHeadersList = new ArrayList<BudEstimateEntry>();
			 	
			 	List<BudMinorHead> budMinorHeadList = new ArrayList<BudMinorHead>();
			 	if (map.get("budVoucherHeadersList") != null) {
			 		budVoucherHeadersList = (List<BudEstimateEntry>) map.get("budVoucherHeadersList");
			 	}
			 	if(map.get("budMinorHeadList")!=null){
			 		budMinorHeadList=(List<BudMinorHead>)map.get("budMinorHeadList");
			 	}
			 %>

<form name="voucherReport" method="post" action="">
<div class="clear"></div>
<div class="Block">
<label> Sector Type</label> 
<select name="sectorType" id="sectorType" validate="Sector Type,string,yes" >
<option value="0">Select</option>
<%for(BudEstimateEntry budVoucherHeaderss:budVoucherHeadersList){ %>
<option value="<%=budVoucherHeaderss.getSectorType()%>">
<%=budVoucherHeaderss.getSectorType()%></option>
<%}%>
</select>
<label> Minor Head Name</label> 
<select name="minor_head_name" id="minor_head_name" validate="Minor Head Name,string,yes" >
<option value="0">Select</option>
<%for(BudMinorHead budVoucherHeaders:budMinorHeadList){ %>
<option value="<%=budVoucherHeaders.getId()%>">
<%=budVoucherHeaders.getMinorHeadName()%></option>
<%}%>
</select>


<input type="button" name="OK" value="OK" class="button" onClick="submitForm('voucherReport','budget?method=printMonthlyExpenditure');" />
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

