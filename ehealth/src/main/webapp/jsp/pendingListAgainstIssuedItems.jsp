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
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.ItemGroup"%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
		month1="0"+month1;
		}
		if(date1.length()<2){
		date1="0"+date1;
		}
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>'
	</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	Box box = HMSUtil.getBox(request);
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
	List<StoreIssueM> issueNoList = new ArrayList<StoreIssueM>();
	List<StoreInternalIndentM> indentNoList = new ArrayList<StoreInternalIndentM>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	if(map.get("storeIssueMList")!=null){
		storeIssueMList=(List<StoreIssueM>)map.get("storeIssueMList");
	}
	if(map.get("issueNoList")!=null){
		issueNoList=(List<StoreIssueM>)map.get("issueNoList");
	}
	if(map.get("indentNoList")!=null){
		indentNoList=(List<StoreInternalIndentM>)map.get("indentNoList");
	}	 	
%>
<form name="pendingListagainstIssuedItems" method="post">
<div class="titleBg">
<h2>Pending Receipt Against Issued Items</h2>
</div>
<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class="Block">
<%--<label>Demand No.</label> <input type="text"
	name="<%=DEMAND_NO %>" value="" readonly="readonly"
	MAXLENGTH="8" class="readOnly" /> --%>
	
	<label>From Date</label>
	 <input type="text" name="fromDate" id="fromDate" value="<%=date %>" readonly="readonly" class="date"  validate="fromDate,date,no"/>
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.pendingListagainstIssuedItems.fromDate,event)" />
	 
<label>To Date</label>
	 <input type="text" name="toDate" id="toDate" value="<%=date %>" readonly="readonly" class="date" validate="toDate,date,no" />
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.pendingListagainstIssuedItems.toDate,event)" />
	 
<div class="clear"></div>

<label>Issue No.</label>
<select name="Issue_no"	 >
			<option value="0">Select</option>
			<%if(issueNoList.size()>0){
				for(StoreIssueM storeIssueM : issueNoList){
				%>
		<option value="<%=storeIssueM.getId()%>"><%=storeIssueM.getIssueNo() %></option>
	<%}} %>		
</select>
<label>Indent No.</label>
<select name="indentNo"	>
			<option value="0">Select</option>
			<%if(indentNoList.size()>0){
				for(StoreInternalIndentM storeInternalIndentM : indentNoList){
				%>
		<option value="<%=storeInternalIndentM.getId()%>"><%=storeInternalIndentM.getDemandNo()%></option>
	<%}} %>		
</select>

<div class="clear"></div>
<input type="button" name="Search" type="submit" value="Search"	onClick="submitForm('pendingListagainstIssuedItems','stores?method=searchAcknowledgementList')" class="button" />
<div class="clear"></div>
</div>

<h4>Item Details</h4>
<div id="pageNavPosition"></div>
	<%
				int  counter=1;
				if (storeIssueMList != null && storeIssueMList.size() > 0) { %>
<div class="cmntable">
			<table>			
					<tr>
						<th>Sl No.</th>
						<th>Indent No.</th>
						<th>Indent Date</th>
						<th>Store/Sub Store</th>
						<th>Issue No.</th>
						<th>Issue Date</th>
					</tr>
				<tbody id="tableData">	
				<%
			 		for (StoreIssueM storeIssueM:storeIssueMList) {	
			 			 		
		%>
					<tr onclick="submitForm('pendingListagainstIssuedItems','stores?method=createGridIssueData&<%=ISSUE_NO%>=<%=storeIssueM.getId()%>&issue_No=<%=storeIssueM.getIssueNo()%>&rowNum=<%=counter%>+&'+csrfTokenName+'='+csrfTokenValue)">
					<td><%=counter%></td>
					<td> <%=storeIssueM.getRequestNo() != null ?storeIssueM.getRequestNo().getDemandNo():""%></td>
					<td><%=storeIssueM.getRequestNo() != null?HMSUtil.convertDateToStringWithoutTime(storeIssueM.getRequestNo().getDemandDate()):""%></td>
					<td><%= storeIssueM.getIssueNo()%><input type="hidden" name="<%=ISSUE_NO%><%=counter%>" value="<%= storeIssueM.getId()%>">
					 <input type="hidden" name="<%=ISSUE_UNIT_ID%><%=counter%>" value="<%= storeIssueM.getIssueNo()%>"></td>
					<td><%=HMSUtil.convertDateToStringWithoutTime(storeIssueM.getIssueDate())%>
					<input type="hidden"
							name="issueDate<%=counter%>" validate="issueDate,date,no"
							value="<%=HMSUtil.convertDateToStringWithoutTime(storeIssueM.getIssueDate())%>"></td>
					<td><%= storeIssueM.getDepartment().getDepartmentName()%>
					<input type="hidden" name="<%=DEPT_ID%><%=counter%>" validate="deptId,int,no"
							value="<%=storeIssueM.getDepartment().getId()%>"></td>						
					</tr>					
		<%
		++counter;	}		 		
		 		
		  	%>
		  	</tbody>	
</table>
</div>
<input type="hidden" name="counter" id="counter" value="<%=counter %>" validate="counter,int,no"/>
<%
		 }
		else{
		%>
<h4><span>No Record Exists</span></h4>
<div class="clear"></div>
<%}%>					
</form>	

<script type="text/javascript">
var pager = new Pager('tableData',5);
pager.init();
pager.showPageNav('pager', 'pageNavPosition');
pager.showPage(1);
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">



