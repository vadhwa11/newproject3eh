<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * departmentIndentjsp
 * Purpose of the JSP -  This is for Department Indent.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 08th Feb, 2008
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>
<%@page import="jkt.hms.masters.business.StoreTemperatureMonitoringM"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
	

<%
	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<StoreTemperatureMonitoringM> transferPendingList = new ArrayList<StoreTemperatureMonitoringM>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if(map.get("transferPendingList")!= null){
		transferPendingList = (List)map.get("transferPendingList");
	}
	System.out.println("transferPendingList=="+transferPendingList.size());
	
%>


<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>Transfer Pending List</h2>
</div>

<form name="pendingListForTransfer" method="post">


<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>


<div class="division"></div>

<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>


<div class="paddingTop15"></div>
<div class="clear"></div>

<h4>Item Details</h4>
<table border="0" cellpadding="0" cellspacing="0">

				<tr>
						<th>Ref/Cr</th>
						<th>Stored Qty</th>
						<!-- <th>Min Temperature</th>
						<th>Max Temperature</th> -->
					</tr>
				<%
					if(transferPendingList.size()>0){
						for(StoreTemperatureMonitoringM temperatureMonitoringM :transferPendingList){
				%>
					<tr onclick="submitForm('pendingListForTransfer','coldChain?method=showRefrigeratorColdRoomReAllocationJsp&refrigeratorId=<%=temperatureMonitoringM.getRefrigerator().getId()%>&temperatureMonitoringId=<%=temperatureMonitoringM.getId()%>');">
					<td><%=temperatureMonitoringM.getRefrigerator()!= null?temperatureMonitoringM.getRefrigerator().getNomenclature():"" %></td>
					<td><%=temperatureMonitoringM.getStoredQty() != null?temperatureMonitoringM.getStoredQty().intValue():"" %></td>
					<%-- <td><%=temperatureMonitoringM.getMinTemp()!= null?(temperatureMonitoringM.getMinTemp()).intValue():""%></td>
					<td><%=temperatureMonitoringM.getMaxTemp()!= null?(temperatureMonitoringM.getMaxTemp()).intValue():""%></td> --%>
					
					
					
					</tr>
					
					<%}} %>
			</table>

 
<div class="clear"></div>
<%-- 
<label><span>*</span> Status</label>
<select	name="status"	validate="Approved By,String,yes" id="approvedBy" tabindex=1>
	<option value="0">Select</option>
	<option value="Approve">Approve</option>
	<option value="Approve">Reject</option>
	<option value="Approve">Send Back</option>
	
</select>
<input type="button" name="Next/Update" type="submit" value="display"	onClick="submitForm('departmentWiseIndentApprovalPendingList','stores?method=showInstitutionAnnualIndentCreationJsp');" class="button" />
--%>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

