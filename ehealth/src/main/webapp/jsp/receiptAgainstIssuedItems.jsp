
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
<%@page import="java.math.BigDecimal"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>


<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
// 	List<MasEmployee> employeeDeptByList = new ArrayList<MasEmployee>();


		/* else if(session.getAttribute("approvedByEmployeeList") != null)
		{
			approvedByEmployeeList = (ArrayList)session.getAttribute("approvedByEmployeeList");
		} */
	List<Object[]> storeInternalIndentMList = new ArrayList<Object[]>();
	List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
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
	String issue_No1="";
	if (map.get("issue_No")!=null)
	{
		issue_No1 = (String)map.get("issue_No");
	}
	
	Box box=HMSUtil.getBox(request);

	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
		
		if(map.get("storeIssueMList")!=null){
			storeIssueMList=(List<StoreIssueM>)map.get("storeIssueMList");
		}
		
		
		String messageType ="";
		
		Map<String, Object> utilMap1 = new HashMap<String, Object>();
		utilMap1 = (Map) HMSUtil.getCurrentDateAndTime();
		String date1 = (String) utilMap.get("currentDate");
		String message = "";
		if (map.get("visitList") != null) {
			message = (String) map.get("message");
		}

%>


<%-- Start of Content Div --%>
<%-- Start of Main Form --%>

<%-- Title --%>
<h4><span id="msgId"></span></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Acknowledgement Form</h2>
</div>
<form name="ack" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear" ></div>
<div class="clear" ></div>


<div>
<!--<input type="button"tabindex="1" name="print" type="button" class="button" value="Print" onClick="submitForm('issueDispensaryForm','stores?method=showGrnReportJsp');">
--></div>


<label>Issue Department</label>
<select	name="<%=ISSUE_DEPT%>" id="issueDept"	validate="Issue Department,String,yes"	onchange="populateIssueNoAndDate(this.value,'ack')" tabindex=1>
	<option value="0">Select</option>
	<%
	for (MasDepartment masDepartment :departmentList) {
					%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(ISSUE_DEPT)) %> selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%
						}
					%>
</select>


<label>Acknowledge By</label>
<select name="<%=ACK_BY %>"	id="acknowledgedBy" > <!-- validate="Acknowledgment By,String,yes" tabindex=1> --> 
<option value="0">Select</option>
	<% 
					for (MasEmployee approvedBy :approvedByEmployeeList ) {
			%>
	<option value=<%=approvedBy.getId()%>
		<%=HMSUtil.isSelected(approvedBy.getId().toString(),box.getString(ACK_BY)) %>><%=approvedBy.getFirstName()+" "+approvedBy.getLastName()%></option>
	<%

					}
				%>
</select>


<label > Acknowledgement Date</label> 

<input type="text"	name="<%=ACK_DATE %>"	value="<%=box.get(ACK_DATE)==""?currentDate:box.get(ACK_DATE)%>"	class="date" readonly validate="Pick a date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=FROM_DATE%>',document.ack.<%=FROM_DATE%>,true);" />

<div class="clear" ></div>

<label> Receipt By </label> 
<input type="text"	name="" value="<%=deptName%>" 	maxlength="30" tabindex=1 />


<label> Issue No </label> 
<input type="text"	value="<%=issue_No1%>" id="issueNo" name="<%=ISSUE_NO%>"	maxlength="30" tabindex=1 />

<label> Issue Date </label> 
<input type="text"	name="" value="" id="IssueDate" 	maxlength="30" tabindex=1 />

<div class="clear" ></div>


<div class="clear"></div>

<div class="clear"></div>

<!-- <input type="button" name="Submit" value="Search" class="button" onClick="submitForm('ack','stores?method=showAckJsp');"	accesskey="g" tabindex=1 /> -->
<!-- <input type="button" class="button" value="Reset"
	onclick="" align="right" />  -->
<div class="clear"></div>
<div class="division"></div>










<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<% if (pagedArray == null) { %>
<h4>Details</h4>
<table width="100%" colspan="7" id="indentDetails" class="grid_header"	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th>S.No.</th>
			<th>Item Code</th>
			<th>Item Name</th>
			<th>UOM</th>
			<!-- <th>Brand Name</th> -->
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
			<!-- <th>Brand Name</th> -->
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
		
		<td width="5%"><input type="checkbox" size="2"
				
				 /></td>
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
				class="readOnly" readonly="readonly" validate="Batch No.,string,no" />
			<td width="5%"><input type="text" size="5"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				name="au" class="readOnly" readonly="readonly" /></td>
			<%--<td width="8%"> <input type="text"	size="" value="<%=gridData[i].get("brandname")%>" name="brandname" validate="Brand Name,string,no" readonly="readonly"/> </td> --%>
			
			</td>
			
			<td width="10%"><input type="text" size="12"
				value="<%=gridData[i].get("expiry_date")%>" name="expiry_date"
				class="readOnly" readonly="readonly" />
			<td width="10%"><input type="text" size="6"
				value="<%=gridData[i].get("qtyRequest")%>" name="qtyRequest" 
				class="readOnly" readonly="readonly" validate="Demand Qty,num,no" />
			</td>
			<td width="10%"><input type="text" size="6"
				value="<%=gridData[i].get("qtyIssued")%>" name="qtyIssued" id="qtyIssued<%=i %>"
				class="readOnly" readonly="readonly" validate="Issue Qty,num,no" />
			</td>
			 <%--<td width="12%"> <input type="hidden"	value="<%=gridData[i].get("brand")%>" name="brand"  readonly="readonly"/> </td> --%>

			<td width="10%"><input type="text" size="6" maxlength="4" id="qtyReceived<%=i%>"
				value="" name="qtyReceived"  onblur="checkReceivedQty('<%=i%>')"
				validate="Issue Qty,num,no" />
			</td>
				
				<td width="10%"><input type="text" size="6"
				value="" name="qtyIssued" readonly="readonly" id="surplus<%=i%>"
					  validate="Issue Qty,num,no" />
			</td>
			
			<td width="10%"><input type="text" size="6"
				value="" name="qtyIssued" id="defiency<%=i%>"
				class="readOnly" readonly="readonly" validate="Received Qty,num,no" />
			</td>
			
			<td width="10%"><input type="text" size="6"
				value="" name="qtyIssued" maxlength="100"
				validate="Issue Qty,num,no" />
			</td>
				
				
		</tr>
		<% } %>
	</tbody>
</table>

<input type="button" name="add" id="addbutton" value="Submit"
	class="button" accesskey="a" tabindex=1 onClick="submitForm('ack','stores?method=addAck');"  /> 
	
	
	<input type="button" name="add" id="addbutton" value="Reject"
	class="button" onClick="submitForm('ack','stores?method=addAck');"
	accesskey="a" tabindex=1 />

<div style="padding-left: 250px;">
<%-- <div style="float: left;"><%= pagedArray.showIndex()%></div>
<div style="float: left;"><%= pagedArray.getPageIndexHiddenTag()%> --%>
</div>
</div>

<div class="clear"></div>


<% } %>











<script>

function checkReceivedQty(i)
{
	
	var received_qty=document.getElementById('qtyReceived'+i).value
	var qtyIssued1=document.getElementById('qtyIssued'+i).value
	var qtyIssued=parseInt(qtyIssued1)
		//alert(received_qty+"---"+parseInt(qtyIssued));
	
	 if(qtyIssued<received_qty)
		{
		document.getElementById('surplus'+i).value=received_qty-qtyIssued 
		document.getElementById('defiency'+i).value=0
		}
	else if(parseInt(qtyIssued)>received_qty){
		document.getElementById('defiency'+i).value=qtyIssued-received_qty 
		document.getElementById('surplus'+i).value=0
	}
		
	else{
		
	} 
	
	

	
}



function getIssue(issueNo,issue_no)
{ 
	//alert("issue_no"+issue_no);
	document.ack.method="post";
	var issueNo = issueNo;
	
	var issueDept = 24;
	var acknowledgedBy = 946;
	/* if (issueNo==0 || issueDept==0 || acknowledgedBy==0)
	{
		alert("Pl. Check your Inputs!...  ");
		return;
	} */
	submitForm('ack','stores?method=createGridIssueData&<%=ISSUE_NO%>='+issueNo+'&<%=ISSUE_UNIT_ID%>='+issue_no+"&currPage=1");
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

</form>
<%----------------------End of show pending Indent---------------------%>
	