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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

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

<div class="Block">

<label>Item Code</label>
	 <input type="text" name="<%=DEMAND_DATE %>" value="" readonly="readonly"   />
	 <label>Item Name</label>
	 <input type="text" name="<%=DEMAND_DATE %>" value="" readonly="readonly"   />
	  <label>Unit</label>
	 <input type="text" name="<%=DEMAND_DATE %>" value="" readonly="readonly"  />

<div class="clear"></div>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<h4>State Item Details</h4>


<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>


<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table width="98%" colspan="7" id="grnDetails" class="scrollTable">
				<thead class="fixedHeader headerFormat">
					<tr>

						<th>State</th>
						<th>Year1</th>
						<th>Year2</th>
						<th>Previous Year Consumption Qty</th>
						 <th>Available Stock</th>
						<th>Required Qty</th>
						  <th>Additional qty</th>
						<th>Demanded Qty</th>
						<th>Pending Indent Qty</th>
						<th>Remarks</th>
						
					</tr>
					
					<tr>
						<td width="%5"><input type="text" size="5" value="" name="srno" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="year1IndentQty" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="year2IndentQty" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="previousYearConsumption" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="stock" validate="Stock In Hand,num,no" class="readOnly" readonly="readonly" /></td>
						<%-- <td width="12%"> <input type="text"	value="<%=gridData[i].get("qtymmf")%>"  name="qtymmf" validate="MMF Qty,num,no" /> </td>--%>
						<td><input type="text" size="8" value="" class="readOnly" name="additionaalQty" validate="Stock In Hand,num,no"  readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="qtyRequest" class="readOnly" validate="Requested Qty,num,no" /></td>
						<td><input type="text" size="8" value="" name="demandedQty" class="readOnly" validate="Demanded Qty,num,no" /></td>
						<td><input type="text" size="8" value="" name="demandedQty" class="readOnly" validate="Demanded Qty,num,no" /></td>
						<td><input type="text" size="8" value="" name="remarks" class="readOnly" validate="Remarks,num,no" /></td>
						
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

<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<h4>District Wise Item Details</h4>


<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>


<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table width="98%" colspan="7" id="grnDetails" class="scrollTable">
				<thead class="fixedHeader headerFormat">
					<tr>

						<th>District</th>
						<th>Year1</th>
						<th>Year2</th>
						<th>Previous Year Consumption Qty</th>
						 <th>Available Stock</th>
						<th>Required Qty</th>
						  <th>Additional qty</th>
						<th>Demanded Qty</th>
						<th>Pending Indent Qty</th>
						<th>Remarks</th>
						
					</tr>
					
					<tr>
						<td width="%5"><input type="text" size="5" value="" name="srno" class="readOnly" readonly="readonly" /></td>
							
						<td><input type="text" size="8" value="" name="year1IndentQty" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="year2IndentQty" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="previousYearConsumption" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="stock" validate="Stock In Hand,num,no" class="readOnly" readonly="readonly" /></td>
						<%-- <td width="12%"> <input type="text"	value="<%=gridData[i].get("qtymmf")%>"  name="qtymmf" validate="MMF Qty,num,no" /> </td>--%>
						<td><input type="text" size="8" value="" class="readOnly" name="additionaalQty" validate="Stock In Hand,num,no"  readonly="readonly" /></td>
						<td><input type="text" size="8" value="" class="readOnly" name="qtyRequest" validate="Requested Qty,num,no" /></td>
						<td><input type="text" size="8" value="" class="readOnly" name="demandedQty" validate="Demanded Qty,num,no" /></td>
						<td><input type="text" size="8" value="" class="readOnly" name="demandedQty" validate="Demanded Qty,num,no" /></td>
						<td><input type="text" size="8" value="" class="readOnly" name="remarks" validate="Remarks,num,no" /></td>
						
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




<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<h4>Institute Wise Item Details</h4>


<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>


<table border="0" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td>
			<div id="TableContainer" class="TableContainer">
			<table width="98%" colspan="7" id="grnDetails" class="scrollTable">
				<thead class="fixedHeader headerFormat">
					<tr>

						<th>Institute</th>
						<th>Year1</th>
						<th>Year2</th>
						<th>Previous Year Consumption Qty</th>
						 <th>Available Stock</th>
						<th>Required Qty</th>
						 <th>Additional qty</th>
						<th>Demanded Qty</th>
							<th>Pending Indent Qty</th>
						<th>Remarks</th>
						
					</tr>
					
					<tr>
						<td width="%5"><input type="text" size="5" value="" name="srno" class="readOnly" readonly="readonly" /></td>
							
						<td><input type="text" size="8" value="" name="year1IndentQty" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="year2IndentQty" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="previousYearConsumption" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="stock" validate="Stock In Hand,num,no" class="readOnly" readonly="readonly" /></td>
						<%-- <td width="12%"> <input type="text"	value="<%=gridData[i].get("qtymmf")%>"  name="qtymmf" validate="MMF Qty,num,no" /> </td>--%>
						<td><input type="text" size="8" value="" class="readOnly" name="additionaalQty" validate="Stock In Hand,num,no"  readonly="readonly" /></td>
						<td><input type="text" size="8" value="" class="readOnly" name="qtyRequest" validate="Requested Qty,num,no" /></td>
						<td><input type="text" size="8" value="" class="readOnly" name="demandedQty" validate="Demanded Qty,num,no" /></td>
						<td><input type="text" size="8" value="" name="demandedQty" class="readOnly" validate="Demanded Qty,num,no" /></td>
						<td><input type="text" size="8" value="" class="readOnly" name="remarks" validate="Remarks,num,no" /></td>
						
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




<div class="clear"></div>
<input	type="button" name="Close" type="submit" value="Close" 	onClick="upd();" class="button">

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>