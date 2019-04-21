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
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="java.util.ArrayList"%>
	

<%
	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
	
	if(map.get("storeInternalIndentMList") != null){
		storeInternalIndentMList = (List<StoreInternalIndentM>)map.get("storeInternalIndentMList");
	}
	
	
%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<form name="annualIndentProcessingByKMSCLPendingList" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Annual Indent Processing BY KMSCL Pending List</h2>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>


<div class="division"></div>

<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>


<div class="paddingTop15"></div>
<div class="clear"></div>

<table border="0" cellpadding="0" cellspacing="0">

					<tr>
						<th>Indent No.</th>
						<th>Indent Date</th>
						<%-- <th>Indent To</th>--%>
						<th>Hospital</th>
					<%--	<th>Requested By</th> --%>
						
						
					</tr>
					<%
					if(storeInternalIndentMList.size()>0){
						for(StoreInternalIndentM storeInternalIndentM : storeInternalIndentMList){
							
					
					
					%>
					<tr onclick="submitForm('annualIndentProcessingByKMSCLPendingList','stores?method=showAnnualIndentProcessingbyKMSCL&storeInternalMId=<%=storeInternalIndentM.getId() %>');">
					<td><%=storeInternalIndentM.getDemandNo()!= null?storeInternalIndentM.getDemandNo():"" %></td>
					<td><%=storeInternalIndentM.getDemandDate()!= null?HMSUtil.convertDateToStringWithoutTime(storeInternalIndentM.getDemandDate()):"" %></td>
				<%-- 	<td><%=storeInternalIndentM.getToStore()!= null?storeInternalIndentM.getToStore().getDepartmentName():"" %></td>--%>
					<td><%=storeInternalIndentM.getHospital()!= null?storeInternalIndentM.getHospital().getHospitalName():"" %></td>
				<%-- 	<td><%=storeInternalIndentM.getRequestedBy()!= null?storeInternalIndentM.getRequestedBy().getFirstName()+""+storeInternalIndentM.getRequestedBy().getLastName():"" %></td>--%>
					
					
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
</form>


