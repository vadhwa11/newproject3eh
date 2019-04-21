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
<h2>GRN</h2>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>


<div class="division"></div>

<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>
<h4>Details</h4>
<div class="clear"></div>
<div class="Block">
<%--<label>Demand No.</label> <input type="text"
	name="<%=DEMAND_NO %>" value="" readonly="readonly"
	MAXLENGTH="8" class="readOnly" /> --%>
	
	<label>GRN Date</label>
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=date %>" readonly="readonly" class="date"  validate="demandDate,date,no"/>
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= DEMAND_DATE%>,event)" />
	 


<label>Source </label>
<select name="<%=FROM_WARD%>" >
			<option value="0">KMSCL Issue Note</option>
			<option value="0">Purchase Order from KMSCL</option>
			<option value="0">Local Purchase</option>
			<option value="0">Indent Issue from other Institute</option>
			<option value="0">Other(LSG,Donation)</option>
	
			</select>

			

<%-- <label>From </label>
<select name="<%=FROM_WARD%>"	>
			<option value="0">Select</option>
	
			</select>--%>
 <label>Vendor </label> <select name="<%=TO_WARD%>" >
	<option value="0">Select</option>
	
</select>

<div class="clear"></div>
<%-- <label><span>*</span> Approved By</label> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Approved By,String,no">
	<option value="0">Select</option>
	
</select>--%>
 <label><span>*</span> Indent No./SO No.</label> <select
	name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>">
	<option value="0">Select</option>
	
</select>
<label>Date Received</label>
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=date %>" readonly="readonly" class="date" validate="demandDate,date,no" />
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= DEMAND_DATE%>,event)" />
	 

<label><span>*</span> Invoice No.</label> 
<select
	name="itemGroupId">
	<option value="0">Select</option>
	
</select>
<div class="clear"></div>
<label>Invoice Date</label>
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=date %>" readonly="readonly" class="date"  validate="demandDate,date,no"/>
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= DEMAND_DATE%>,event)" />
	 <label>Delivery Challan No.</label>
<input type="text" name="invoiceAmount" value="<%=date %>" readonly="readonly"  />
	
<label>Invoice Amount</label>
<input type="text" name="invoiceAmount" value="<%=date %>" readonly="readonly" />
<div class="clear"></div>
 <label><span>*</span> Received By</label> 
<select
	name="itemGroupId">
	<option value="0">Select</option>
	
</select>

	<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="clear"></div>

<h4>Indent Details</h4>
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
						
						<th>Barcode</th>
						<th>Batch No.</th>
						<th>DOM</th>
						 <th>DOE</th>
						<th>Manufacture</th>
						<th>Supplier Name</th>
						<th>Approved Qty</th>
						<th>Received Qty</th>
						<th>Surplus</th>
						<th>Deficiency </th>
						<th>Unit Rate </th>
						<th>Disc(%)</th>
						<th>Vat(%)</th>
						<th>Tax(%)</th>
						<th>Total Amt</th>
						<th>Remarks</th>
						<th>Select All</th>
					</tr>
					
					<tr>
						<td width="%5"><input type="text" size="5" value="" name="srno" class="readOnly"  /></td>
							
						<td><input type="text" size="8" value="" name="pvms" class="readOnly"  /></td>
							
							
						<td><input type="text" value="" name="nomenclature" class="readOnly"/></td>
						<td><input type="text" size="8" value="" name="au" class="readOnly" /></td>
						<td><input type="text" size="8" value="" name="barCode"  /></td>
						<td><input type="text" size="8" value="" name="batchNo"  /></td>
						<td><input type="text" size="8" value="" name="dom"  />
						 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= DEMAND_DATE%>,event)" /></td>
						<td><input type="text" size="8" value="" name="doe" validate="Stock In Hand,float,no"  />
						 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= DEMAND_DATE%>,event)" /></td>
						<%-- <td width="12%"> <input type="text"	value="<%=gridData[i].get("qtymmf")%>"  name="qtymmf" validate="MMF Qty,num,no" /> </td>--%>
						<td><Select name="manufacture">
						
						</Select></td>
						<td><input type="text" size="8" value="" name="supplierName"   /></td>
						<td><input type="text" size="8" value="" name="reapproved Qty"   class="readOnly"/></td>
						<td><input type="text" size="8" value="" name="receivedQty"   /></td>
						<td><input type="text" size="8" value="" name="surplus"   /></td>
						<td><input type="text" size="8" value="" name="Deficeincy" class="readOnly"   /></td>
						<td><input type="text" size="8" value="" name="unitRate"   /></td>
						<td><input type="text" size="8" value="" name="disc"   /></td>
						<td><input type="text" size="8" value="" name="Vat"   /></td>
						<td><input type="text" size="8" value="" name="tak"   /></td>
						<td><input type="text" size="8" value="" name="totalAmt" class="readOnly"  /></td>
						<td><input type="text" size="8" value="" name="remarks" validate="Remarks,remarks,no" /></td>
						
						<td align="center" width="10%"><input type="checkbox"
							name=<%=ITEMS_TO_BE_DELETED%> value=""
							class="radioCheck"></td>
						<td><input type="hidden" value=""
							name="id" /></td>
					</tr>
					
					<tr class="locatorArrow">
						<td colspan=7></td>
					</tr>
			</table>
			</div>
			</td>
		</tr>
	</tbody>
</table>
 

<div class="paddingTop40"></div>
<div class="clear"></div>




<div class="clear"></div>
<input type="button" name="Submit" type="submit" value="Submit"	onClick="openPopupWindow();" class="button">
<input	type="button" name="Reset" type="submit" value="Reset" 	class="button">
<input	type="button" name="Search" type="submit" value="Search" class="button">

<script type="text/javascript">

<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
