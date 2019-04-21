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
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
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
	List<StoreDefectiveDrugM> storeDefectiveMList = new ArrayList<StoreDefectiveDrugM>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if(map.get("storeDefectiveMList")!= null){
		storeDefectiveMList = (List)map.get("storeDefectiveMList");
	}
	
%>



<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>Pending List For Defective Item Approval</h2>
</div>

<form name="pendingListForDefectiveItemApproval" method="post">
<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>

<div class="clear"></div>
<div id="pageNavPosition"></div>
<table border="0" cellpadding="0" cellspacing="0">

					<tr>
						<th>Defective No.</th>
						<th>Date</th>
						<th>Department</th>
					</tr>
				<tbody id="tableData">	
				<%
					if(storeDefectiveMList.size()>0){
						for(StoreDefectiveDrugM storeDefectiveDrugM :storeDefectiveMList){
				%>
					<tr onclick="submitForm('pendingListForDefectiveItemApproval','stores?method=showDefectiveItemApprovalJsp&defectiveMId=<%=storeDefectiveDrugM.getId()%>');">
					<td><%= storeDefectiveDrugM.getEntryNo() %></td>
					<td><%=HMSUtil.convertDateToStringWithoutTime(storeDefectiveDrugM.getEntryDate()) %></td>
					<td><%=storeDefectiveDrugM.getDepartment().getDepartmentName()%></td>
					
					
					
					</tr>
					
					<%}} %>
					</tbody>
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

<script type="text/javascript">
var pager = new Pager('tableData',5);
pager.init();
pager.showPageNav('pager', 'pageNavPosition');
pager.showPage(1);


</script>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


