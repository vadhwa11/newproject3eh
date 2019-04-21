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
<form name="physicalStock" method="post">
<div class="titleBg">
<h2>Stock Taking Items Addition</h2>
</div>
<div class="clear"></div>
<h4>Store Items Search</h4>
<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class="clear"></div>
<div class="Block">
<%--<label>Demand No.</label> <input type="text"
	name="<%=DEMAND_NO %>" value="" readonly="readonly"
	MAXLENGTH="8" class="readOnly" /> --%>
<label>Item Code</label>
<input type="text" name="itemCode"  value=""/>
	<label>Item Code</label>
<input type="text" name="itemCode"  value=""/> 
<input type="button" name="Search" type="submit" value="Search"	onClick="" class="button" />
<div class="clear"></div>

	<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="clear"></div>

<h4>Item Details</h4>
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
						<th>Brand</th>
						<th>Batch No.</th>
						<th>Expiry Date</th>
						 <th>Price</th>
						<th>Add</th>
						
						
					</tr>
					
					<tr>
						<td width="%5">1</td>
						<td><input type="text" size="8" value="" name="pvms"   /></td>
						<td><input type="text" value="" name="nomenclature"/></td>
						<td><Select name="">
								<option value=""></option></Select></td>
						
						<td><input type="text" size="8" value="" name="batchNo" /></td>
						<td><input type="text" size="8" value="" class="date" name="expiryDate"  />
						<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= DEMAND_DATE%>,event)" /></td>
						<td><input type="text" size="8" value="" name="price" validate="Stock In Hand,num,no"   /></td>
						<%-- <td width="12%"> <input type="text"	value="<%=gridData[i].get("qtymmf")%>"  name="qtymmf" validate="MMF Qty,num,no" /> </td>--%>
						<td><input type="checkbox" size="8" value="" name="qtyRequest" validate="Requested Qty,num,no" /></td>
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
<input	type="button" name="Add" type="submit" value="Add" class="button" onclick="submitForm('physicalStock','stores?method=displayStockTakingItemsAddition');" />
<input type="button" name="Close" type="submit" value="Close"	onClick="" class="button" />

<script type="text/javascript">

<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>