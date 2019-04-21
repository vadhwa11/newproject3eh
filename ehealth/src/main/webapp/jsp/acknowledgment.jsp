
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * issueToDispensary.jsp
	 * Purpose of the JSP -  This is for issue to Dispensary.
	 * @author  Vivek
	 * @author  Abha
	 * Create Date: 21th Feb,2008
	 * Revision Date:
	 * Revision By:
	 * @version 1.8
	--%>

<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="java.math.BigDecimal"%><script type="text/javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<script type="text/javascript">
	function rowValue(id,date){
		document.getElementById("IssueId").value=id;
		document.getElementById("IssueDate").value=date;
	}
	</script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>


<%
	Map map = new HashMap();
	String userName="";
	/* String date=""; */
	String time="";
	String deptName="";
    int userId=0;
	int pageNo=1;
	int indentId=0;
	PagedArray pagedArray = null;
	HashMap[] gridData =null;
	int internalIndentId=0;
	int listSize=0;
	int issueId=0;
	String max="";
	int issueIdForBarcode=0;
	int deptId=0;
	String indentIssueDate="";
	int storeIssueMId=0;
// 	List<MasEmployee> employeeDeptByList = new ArrayList<MasEmployee>();


		/* else if(session.getAttribute("approvedByEmployeeList") != null)
		{
			approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByEmployeeList");
		} */
	List<Object[]> storeInternalIndentMList = new ArrayList<Object[]>();
	List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("approvedByEmployeeList") != null)
	{
		
		approvedByEmployeeList = (List<MasEmployee>) map.get("approvedByEmployeeList");
		session.setAttribute("approvedByEmployeeList",approvedByEmployeeList);
		
	}
	if (map.get("departmentList")!=null)
	{
		departmentList = (ArrayList)map.get("departmentList");
	}
	if(map.get(RequestConstants.DEPT_ID)!=null&&!"".equals(map.get(RequestConstants.DEPT_ID))){
		deptId=Integer.parseInt(map.get(RequestConstants.DEPT_ID).toString());
	}
	if(map.get("indentIssueDate")!=null&&!"".equals(map.get("indentIssueDate"))){
		indentIssueDate=map.get("indentIssueDate").toString();
	}
	String issue_No1="";
	if (map.get("issue_No")!=null)
	{
		issue_No1 = (String)map.get("issue_No");
	}
	if (map.get("storeIssueMId")!=null)
	{
		storeIssueMId =Integer.parseInt( map.get("storeIssueMId").toString());
	}
	
	Box box=HMSUtil.getBox(request);

	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
		
		if(map.get("storeIssueMList")!=null){
			storeIssueMList=(List<StoreIssueM>)map.get("storeIssueMList");
		}
		if(map.get("employeeList")!=null){
			employeeList=(List<MasEmployee>)map.get("employeeList");
		}
		
		
		
		String messageType ="";
		
		Map<String, Object> utilMap1 = new HashMap<String, Object>();
		utilMap1 = (Map) HMSUtil.getCurrentDateAndTime();
		String date1 = (String) utilMap.get("currentDate");
		String message = "";
		if (map.get("message") != null) {
			message = (String) map.get("message");%>
			<h4><span><%=message %></span></h4>
		<%}
		
		Users users=(Users)session.getAttribute(RequestConstants.USERS);
		

%>


<%-- Start of Content Div --%>
<%-- Start of Main Form --%>

<%-- Title --%>
<h4>
	<span id="msgId"></span>
</h4>
<div class="clear"></div>
<div class="titleBg">
	<h2>Acknowledgement Form</h2>
</div>
<form name="ack" method="post">
	<div class="clear"></div>
	<div class="clear"></div>


	<div>
		<!--<input type="button"tabindex="1" name="print" type="button" class="button" value="Print" onClick="submitForm('issueDispensaryForm','stores?method=showGrnReportJsp');">
-->
	</div>
	<%----------------------Start of show pending Indent------------------%>
	<div id="update">
		<% int  counter=1; int slNumber = 0;%>
		<div id="pageNavPosition"></div>
		<h4>Pending Indent</h4>
		<div class="clear"></div> 
			<table id="searchresulttable" width="100%" cellspacing="0"
				cellpadding="0">
				<tr>
					<th>SI No.</th>
					<th>Indent No</th>
					<th>Indent Date</th>
					<th>Issue No</th>
					<th>Issue Date</th>
					<th>Department</th>
				</tr>
				<tbody id="tableData">
					<%if (storeIssueMList != null && storeIssueMList.size() > 0) {  %>
					<%
			String klass = "even";
		 		for (StoreIssueM storeIssueM:storeIssueMList) {
			
		 		if(counter%2==0){
		 			klass = "even";
		 		}
		 		else
		 		{
		 			klass= "odd";
		 		}
		 		
		%>

					<tr class=<%= klass%> id="<%=counter%>"
						onclick="rowValue('<%= storeIssueM.getIssueNo()%>','<%= storeIssueM.getIssueDate()%>')">
						<td><%=counter%></td>
						<td><a href="javascript:getIssue('<%=counter%>','ack')">
								<%=storeIssueM.getRequestNo() != null ?storeIssueM.getRequestNo().getDemandNo():""%>
						</a></td>
						<td><%=storeIssueM.getRequestNo() != null?HMSUtil.convertDateToStringWithoutTime(storeIssueM.getRequestNo().getDemandDate()):""%></td>
						<td><%= storeIssueM.getIssueNo()%><input type="hidden"
							name="<%=ISSUE_NO%><%=counter%>"
							value="<%= storeIssueM.getId()%>"  > <input
								type="hidden" name="<%=ISSUE_UNIT_ID%><%=counter%>"
								value="<%= storeIssueM.getIssueNo()%>"  ></td>
						<td><%=HMSUtil.convertDateToStringWithoutTime(storeIssueM.getIssueDate())%><input type="hidden"
							name="issueDate<%=counter%>" validate="issueDate<%=counter%>,date,no"
							value="<%=HMSUtil.convertDateToStringWithoutTime(storeIssueM.getIssueDate())%>"></td>
						<td><input type="hidden" name="<%=DEPT_ID%><%=counter%>"  
							value="<%=storeIssueM.getDepartment().getId()%>"><%= storeIssueM.getDepartment().getDepartmentName()%></td>


						<%-- <td><%= storeIssueM.getStatus()%></td> --%>

					</tr>

					<%
		++counter;	}
		 		
		 		
		  	%>
				</tbody>
			</table> <input type="hidden" name="pageEditNo" id="pageEditNo"
			value="<%=pageNo %>" validate="pageEditNo,int,no"/> <input type="hidden" name="counter"
			id="counter" value="<%=counter %>" validate="counter,int,no"/> <%
		 }
		else{
		%>
			<h4>
				<span>No Record Exists</span>
			</h4>
			<div class="clear"></div> <%}%>
		
	</div>


	<div class="clear"></div>
	<div class="division"></div>


	<label>Issue Department</label> <select name="<%=ISSUE_DEPT%>"
		id="issueDept" validate="issueDept,metachar,no"
		onchange="populateIssueNoAndDate(this.value,'ack')" tabindex=1>
		<option value="0">Select</option>
		<%
		System.out.println("deptId=="+deptId);
	for (MasDepartment masDepartment :departmentList) {
		 if(deptId==masDepartment.getId()){ 	 
			 %>
		<option value=<%=masDepartment.getId()%>
			<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(ISSUE_DEPT)) %>
			selected="selected"><%=masDepartment.getDepartmentName()%></option>

		<% }
						}
					%>
	</select> <label>Acknowledge By</label>
	<input type="text" readonly="readonly" value="<%=users.getEmployee().getEmployeeName()%>" validate="Acknowledge By,string,no"/> 
	<input type="hidden" name="<%=ACK_BY %>" value="<%=users.getEmployee().getId()%>"/>
	 <%-- <select name="<%=ACK_BY %>"
		id="acknowledgedBy">
		<!-- validate="Acknowledgment By,String,yes" tabindex=1> --> 
		<% 
					for (MasEmployee approvedBy :approvedByEmployeeList ) {
			%>
		<option value=<%=approvedBy.getId()%>
			<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(ACK_BY)) %>><%=approvedBy.getFirstName()+" "+approvedBy.getLastName()%></option>
		<%

					}
				%>
	</select> --%> <label> Acknowledgement Date</label> <input type="text"
		name="<%=ACK_DATE %>"
		value="<%=box.get(ACK_DATE)==""?currentDate:box.get(ACK_DATE)%>"
		class="date" readonly validate="Pick a date,date,yes" /> <img
		src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
		validate="Pick a date"
		onclick="javascript:setdate('<%=FROM_DATE%>',document.ack.<%=FROM_DATE%>,true);" />

	<div class="clear"></div>

	<label> Receipt By </label> <input type="text" name=""
		value="<%=deptName%>" maxlength="30" tabindex=1 validate="Receipt By,metachar,no"/> <label>
		Issue No </label> <input type="text" value="<%=issue_No1%>" id="issueNo"
		name="<%=ISSUE_NO%>" maxlength="30" tabindex=1  /><input type="hidden"
		value="<%=storeIssueMId%>" name="issueId" /> <label>
		Issue Date </label> <input type="text" name="indentIssueDate" value="<%=indentIssueDate%>" id="IssueDate"
		maxlength="30" tabindex=1 />

	<div class="clear"></div>
	<label>Received By</label>
	<select name="receivedBy" id="receivedBy" validate="Received By,metachar,no">
	<option value="">Select</option>
	<%if(employeeList.size()>0){
		for(MasEmployee masEmployee :employeeList){
		%>
		<option value="<%=masEmployee.getId()%>"><%=masEmployee.getEmployeeName() %></option>
	<%}} %>
	</select>


	<div class="clear"></div>

	<div class="clear"></div>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<% if (pagedArray == null) { %>
	<h4>Details</h4>
	<table width="100%" colspan="7" id="indentDetails" class="grid_header"
		border="1" cellpadding="0" cellspacing="0">
		<thead>
			<tr>

				<th>S.No.</th>
				<th>Item Code</th>
				<th>Item Name</th>
				<th>UOM</th>
				<th>Batch No.</th>
				<th>Demand Qty</th>
				<th>Issue Qty</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan=6>No Data Found</td>
			</tr>
		</tbody>
	</table>


	<% } else { %>
	<h4>Acknowledgment Details</h4>

	<table width="90%" colspan="7" id="indentDetails" class="grid_header"
		border="1" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th></th>
				<th>S.No.</th>
				<th>Item Code</th>
				<th>Item name</th>
				<th>Batch No</th>
				<th>DOM.</th>
				<th>DOE.</th>
				<th>Qty Requested</th>
				<th>Actual Issue Qty</th>
				<th>Received Qty</th>
				<th>Surplus Qty</th>
				<th>Deficiency</th>
				<th>Remarks</th>

			</tr>
		</thead>
		<tbody>
			<%
				    gridData = (HashMap[])pagedArray.getPagedArray();
					int iFirstRow = pagedArray.getFirstRowIdx();
				    for(int i=0;i<gridData.length;i++)
				    { %>
			<tr>

				<td width="5%"><input type="checkbox" size="2" /></td>
				<td width="5%"><input type="text" size="2"
					value="<%=iFirstRow++%>" name="srno" class="readOnly"
					readonly="readonly" /></td>
				<td width="10%"><input type="text" size="5"
					value="<%=gridData[i].get("pvms")%>" name="pvms" class="readOnly"
					readonly="readonly" /></td>
				<td width="40%"><input type="text" size="30"
					value="<%=gridData[i].get("nomenclature")%>" name="nomenclature"
					class="readOnly" readonly="readonly" /></td>
				<td width="12%"><input type="text" size="6"
					value="<%=gridData[i].get("batchNo")%>" name="batchNo"
					class="readOnly" readonly="readonly"   />
					<td width="5%"><input type="text" size="5"
						value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
						name="au" class="readOnly" readonly="readonly" /></td> <%--<td width="8%"> <input type="text"	size="" value="<%=gridData[i].get("brandname")%>" name="brandname" validate="Brand Name,string,no" readonly="readonly"/> </td> --%>

				</td>

				<td width="10%"><input type="text" size="12"
					value="<%=gridData[i].get("expiry_date") != null?gridData[i].get("expiry_date"):""%>" name="expiry_date"
					class="readOnly" readonly="readonly" />
					<td width="10%"><input type="text" size="6"
						value="<%=((BigDecimal)gridData[i].get("qtyRequest")).intValue()%>" name="qtyRequest"
						class="readOnly" readonly="readonly" validate="Demand Qty,float,no" />
				</td>
					<td width="10%"><input type="text" size="6"
						value="<%=((BigDecimal)gridData[i].get("qtyIssued")).intValue()%>" name="qtyIssued"
						id="qtyIssued<%=i %>" class="readOnly" readonly="readonly"
						validate="Issue Qty,num,no" /></td>
					<td width="10%"><input type="text" size="6" maxlength="4"
						id="qtyReceived<%=i%>" value="" name="qtyReceived"
						onblur="checkReceivedQty('<%=i%>')" validate="Issue Qty,float,no" />
				</td>

					<td width="10%"><input type="text" size="6" value=""
						name="qtyIssued" readonly="readonly" id="surplus<%=i%>"
						validate="Issue Qty,float,no" /></td>

					<td width="10%"><input type="text" size="6" value=""
						name="qtyIssued" id="defiency<%=i%>" class="readOnly"
						readonly="readonly" validate="Received Qty,float,no" /></td>

					<td width="10%"><input type="text" size="6" value=""
						name="qtyIssued" maxlength="100" validate="Issue Qty,float,no" /></td>
			</tr>
			<% } %>
		</tbody>
	</table>

	<input type="button" name="add" id="addbutton" value="Submit"
		class="button" accesskey="a" tabindex=1
		onClick="submitForm('ack','stores?method=addAck&flag=a');" /> <input
		type="button" name="add" id="addbutton" value="Reject" class="button"
		onClick="submitForm('ack','stores?method=addAck&flag=r');" accesskey="a"
		tabindex=1 />

	<div style="padding-left: 250px;"></div>
	</div>

	<div class="clear"></div>


	<% } %>
 
	<script>

function checkReceivedQty(i)
{
	
	var received_qty=document.getElementById('qtyReceived'+i).value;
	var qtyIssued1=document.getElementById('qtyIssued'+i).value;
	var qtyIssued=parseInt(qtyIssued1)  ;
	 if(qtyIssued<received_qty)
		{
		document.getElementById('surplus'+i).value=received_qty-qtyIssued ;
		document.getElementById('defiency'+i).value=0;
		}
	else if(parseInt(qtyIssued)>received_qty){
		document.getElementById('defiency'+i).value=qtyIssued-received_qty ;
		document.getElementById('surplus'+i).value=0;
	}
		
	else if(qtyIssued==received_qty){
		document.getElementById('defiency'+i).value=0; ;
		document.getElementById('surplus'+i).value=0;
	} 
	 	
}



function getIssue(counter)
{ 
	//alert("issue_no"+issue_no);
	document.ack.method="post";
	var issueNo = issueNo;
	
	//var issueDept = 24;
	//var acknowledgedBy = 946;
	/* if (issueNo==0 || issueDept==0 || acknowledgedBy==0)
	{
		alert("Pl. Check your Inputs!...  ");
		return;
	} */
	submitForm('ack','stores?method=createGridIssueData&rowNum='+counter+"&currPage=1");
	<%-- submitForm('ack','stores?method=createGridIssueData&<%=ISSUE_NO%>='+issueNo+"&currPage=1"); --%>
}
//this function will be called by the Bean (not from JSP)
function goPage(pidx) {
	//ack.currPage.value = pidx;
	//ack.method="post";
	 obj = eval('document.ack');
	 obj.currPage.value = pidx;
	 obj.method="post";
	submitForm('ack','stores?method=createGridIssueData');
}
 

function Request(obj,formName){
	
	if(formName == 'pendingIndent'){
		
		obj1 = eval('document.'+formName)
		alert(formName);
		var hin = obj;
	//	submitProtoAjaxWithDivName('showKitIssue','/hms/hms/stores?method=getAcknowledgementDetails&id='+hin,'batchDiv');

		alert(hin);
		url = "/hms/hms/stores?method=getAcknowledgementDetails&id="+hin;
	   	obj1 .action = url;
		obj1 .submit(); 
	}
}
			var pager = new Pager('tableData',5);
			pager.init();
			pager.showPageNav('pager', 'pageNavPosition');
			pager.showPage(1);
		  </script>
	<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<%----------------------End of show pending Indent---------------------%>
