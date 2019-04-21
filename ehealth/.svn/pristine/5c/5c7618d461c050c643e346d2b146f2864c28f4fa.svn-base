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
<%@page import="jkt.hms.masters.business.HmsNoticeBoard"%>
<%@page import="jkt.hms.masters.business.StoreBalanceM"%>
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
	List<StoreBalanceM> storeBalanceMList = new ArrayList<StoreBalanceM>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if(map.get("storeBalanceMList")!= null){
		storeBalanceMList = (List)map.get("storeBalanceMList");
	}
	
%>



<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>Pending List For Opening Entry Approval</h2>
</div>

<form name="pendingListForOpeningApproval" method="post">


<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>


<div class="division"></div>

<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>


<div class="paddingTop15"></div>
<div class="clear"></div>


<table border="0" cellpadding="0" cellspacing="0">

					<tr>
						<th>Balance Entry No.</th>
						<th>Balance Entry Date</th>
					</tr>
				<%
					if(storeBalanceMList.size()>0){
						for(StoreBalanceM storeBalanceM:storeBalanceMList){
				%>
					<tr onclick="submitForm('pendingListForOpeningApproval','stores?method=displayOpeningBalanceData&storeBalanceMId=<%=storeBalanceM.getId()%>');">
					<td><%=storeBalanceM.getBalanceNo() %></td>
					<td><%=HMSUtil.convertDateToStringTypeDateOnly(storeBalanceM.getBalanceDate()) %></td>
					
					
					
					</tr>
					
					<%}} %>
			</table>

 
<div class="clear"></div>
<%-- 
<label><span>*</span> Status</label>
<select	name="status"	validate="Approved By,metachar,yes" id="approvedBy" tabindex=1>
	<option value="0">Select</option>
	<option value="Approve">Approve</option>
	<option value="Approve">Reject</option>
	<option value="Approve">Send Back</option>
	
</select>
<input type="button" name="Next/Update" type="submit" value="display"	onClick="submitForm('departmentWiseIndentApprovalPendingList','stores?method=showInstitutionAnnualIndentCreationJsp');" class="button" />
--%>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
