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
	List<StoreBroadcastEnquiryM> broadCastEnquiryMList = new ArrayList<StoreBroadcastEnquiryM>();
	
	if(map.get("broadCastEnquiryMList") != null){
		broadCastEnquiryMList = (List<StoreBroadcastEnquiryM>)map.get("broadCastEnquiryMList");
	}
	
	
%>


<%@page import="jkt.hms.masters.business.StoreBroadcastEnquiryM"%>
<form name="pendingListForEnquiryAcknowledgement" method="post">
<div class="titleBg">
<h2>Enquiry Acknowledgement Pending List</h2>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>


<div class="division"></div>

<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>


<div class="paddingTop15"></div>
<div class="clear"></div>

<h4>Indent Details</h4>
<table border="0" cellpadding="0" cellspacing="0">

					<tr>
						<th>BroadCast No.</th>
						<th>BroadCast Date</th>
						<th>BroadCast Type</th>
						<th>Institute</th>
						
						
					</tr>
					<%
					if(broadCastEnquiryMList.size()>0){
						for(StoreBroadcastEnquiryM storeBroadcastEnquiryM : broadCastEnquiryMList){
							
					
					
					%>
					<tr onclick="submitForm('pendingListForEnquiryAcknowledgement','stores?method=showEmergentIndentAcknowledgementJsp&storeBroadCastEnquiryMId=<%=storeBroadcastEnquiryM.getId() %>');">
					<td><%=storeBroadcastEnquiryM.getBroadcastNo()!= null?storeBroadcastEnquiryM.getBroadcastNo():"" %></td>
					<td><%=storeBroadcastEnquiryM.getBroadcastDate()!= null?HMSUtil.convertDateToStringWithoutTime(storeBroadcastEnquiryM.getBroadcastDate()):"" %></td>
					<td><%=storeBroadcastEnquiryM.getBroadcastType()!= null?storeBroadcastEnquiryM.getBroadcastType():"" %></td>
					<td><%=storeBroadcastEnquiryM.getInstitute()!= null?storeBroadcastEnquiryM.getInstitute().getHospitalName():"" %></td>
					
					
					
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


