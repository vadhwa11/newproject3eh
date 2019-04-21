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
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	


	
%>
<form name="departmentIndent" method="post">
<div class="titleBg">
<h2>Department Issue</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>From Date</label>
 <input type="text" name="<%=FROMDATE %>" value="<%=date %>" readonly="readonly" class="date"  />
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= FROMDATE%>,event)" />
 
 <label>To Date</label>
 <input type="text" name="<%=TODATE %>" value="<%=date %>" readonly="readonly" class="date"  />
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= TODATE%>,event)" />
	 <label>From Department</label>
<select name="<%=FROM_WARD%>"	>
			<option value="0">Select</option>
	
			</select>
<div class="clear"></div>	 
 <input type="button" name="Search" type="submit" class="button"value="Search" onClick="" />
 <div class="clear"></div>	
</div>
<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="clear"></div>

<h4>Pending Indents</h4>
<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table width="98%" colspan="7" id="grnDetails" class="scrollTable">
				<thead class="fixedHeader headerFormat">
					<tr>

						<th>S.No.</th>
						<th>Indent No.</th>
						<th>Indent Date</th>
						<th>From Department</th>
						<th>Requested By</th>
						<th>Approved By</th>
					</tr>
					
					<tr>
						<td width="%5"><input type="text" size="5" value="" name="srno" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="indentNo" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" value="" name="indent Date" class="readOnly" readonly="readonly"  /></td>
						<td><input type="text" size="8" value="" name="fromDepartment" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="requestedBy" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="approvedBy" class="readOnly" readonly="readonly" /></td>
						<%-- <td width="12%"> <input type="text"	value="<%=gridData[i].get("qtymmf")%>"  name="qtymmf" validate="MMF Qty,num,no" /> </td>--%>
						
			</table>
			</div>
			</td>
		</tr>
	</tbody>
</table>


<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>
<h4> Issue Details</h4>
<div class="clear"></div>
<div class="Block">
<%--<label>Demand No.</label> <input type="text"
	name="<%=DEMAND_NO %>" value="" readonly="readonly"
	MAXLENGTH="8" class="readOnly" /> --%>
	
	<label>Issue Date</label>
	 <input type="text" name="<%=ISSUE_DATE %>" value="<%=date %>" readonly="readonly" class="date"  />
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= DEMAND_DATE%>,event)" />
	 


<label>To Department </label>
<select name="<%=FROM_WARD%>"	>
			<option value="0">Select</option>
	
			</select>

<label>Indent Date</label>
	 <input type="text" name="<%=ISSUE_DATE %>" value="<%=date %>" readonly="readonly" class="date"  />
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= DEMAND_DATE%>,event)" />

<div class="clear"></div>
<%-- <label><span>*</span> Approved By</label> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Approved By,String,no">
	<option value="0">Select</option>
	
</select>--%>
 <label><span>*</span> Request By</label> <select
	name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Request By,String,no">
	<option value="0">Select</option>
	
</select>

 <label><span>*</span> Approved By</label> <select
	name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Request By,String,no">
	<option value="0">Select</option>
	
</select>
 <label><span>*</span> Issued By </label> <select
	name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Request By,String,no">
	<option value="0">Select</option>
	
</select>
<div class="clear"></div>
<label><span>*</span> Indent No.</label> 
<select
	name="itemGroupId"
	validate="Item Group,String,no">
	<option value="0">Select</option>
	
</select>
<div class="clear"></div>
</div>

<div class="clear"></div>

<div class="paddingTop15"></div>

<h4>Item Details </h4>
<div class="clear"></div>
 <input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="" />
  <div class="clear"></div>
<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table width="98%" colspan="7" id="grnDetails" class="scrollTable">
				<thead class="fixedHeader headerFormat">
					<tr>

						<th>S.No.</th>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						
						<th>BarCode</th>
						<th>Batch No.</th>
						<th>DOM</th>
						 <th>DOE</th>
						<th>Available Stock</th>
						<th>Batch Stock</th>
						<th>Requested Qty</th>
						<th>Department Stock</th>
						<th>Issue Qty</th>
						<th>Balance Qty</th>
						<th>Remarks</th>
					</tr>
					
					<tr>
						<td width="%5"><input type="checkbox" size="5" value="" name="srno" /></td>
							
						<td><input type="text" size="8" value="" name="pvms"  /></td>
							
							
						<td><input type="text" value="" name="nomenclature"  /></td>
						<td><input type="text" size="8" value="" name="au"   /></td>
						<td><input type="text" size="8" value="" name="barCode"  /></td>
						<td><input type="text" size="8" value="" name="batchNo"  /></td>
						<td><input type="text" size="8" value="" name="manufactureDate"  /></td>
						<td><input type="text" size="8" value="" name="expiryDate" validate="Stock In Hand,num,no"  /></td>
						<%-- <td width="12%"> <input type="text"	value="<%=gridData[i].get("qtymmf")%>"  name="qtymmf" validate="MMF Qty,num,no" /> </td>--%>
						<td><input type="text" size="8" value="" name="avaliableStock" validate="Requested Qty,num,no" /></td>
						<td><input type="text" size="8" value="" name="batchStock" validate="Demanded Qty,num,no" /></td>
						<td><input type="text" size="8" value="" name="requestedQty" validate="Remarks,num,no" /></td>
						<td><input type="text" size="8" value="" name="departmentStock" validate="Remarks,num,no" /></td>
						<td><input type="text" size="8" value="" name="issueQty" validate="Remarks,num,no" /></td>
						<td><input type="text" size="8" value="" name="balanceQty" validate="Remarks,num,no" /></td>
						<td><input type="text" size="8" value="" name="remarks" validate="Remarks,num,no" /></td>
						
					</tr>
					
					
			</table>
			</div>
			</td>
		</tr>
	</tbody>
</table>
 <input type="hidden" name="hospitalId" value="" />
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>




<div class="clear"></div>
<input type="button" name="Submit" type="submit" value="Submit"	onClick="" class="button">
<input	type="button" name="Submit/Close" type="submit" value="Submit/Close" 	onClick="" class="buttonBig">
<input type="button"	name="Reset" type="submit" onClick="" value="Reset"	class="button">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>


