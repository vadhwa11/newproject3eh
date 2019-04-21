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
<%@page import="jkt.hms.masters.business.StoreInternalReturnM"%>
<%@page import="jkt.hms.masters.business.StoreInternalReturnT"%>
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
List<StoreInternalReturnT>storeInternalReturnTList = new ArrayList<StoreInternalReturnT>();

	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	if(map.get("storeInternalReturnTList") != null){
		storeInternalReturnTList = (List)map.get("storeInternalReturnTList");
	}
	Date returnDate = null;
	String fromDepartmentName = "";
	int storeInternalIndentMId = 0;
	if(storeInternalReturnTList.size()>0)
		for(StoreInternalReturnT storeInternalReturnT : storeInternalReturnTList){
		StoreInternalReturnM storeInternalReturnM = storeInternalReturnT.getReturnMain();
		if(storeInternalReturnM.getReturnDate() != null){
			returnDate =(Date)storeInternalReturnM.getReturnDate();
		}
		if(storeInternalReturnM.getFromDepartment() != null){
			fromDepartmentName =(String)storeInternalReturnM.getFromDepartment().getDepartmentName();
		}
		storeInternalIndentMId = storeInternalReturnM.getId();	
		
	}

	
%>
<form name="departmentIndent" method="post">
<div class="titleBg">
<h2>Department Return</h2>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class="clear"></div>
<div class="Block">
<%--<label>Demand No.</label> <input type="text"
	name="<%=DEMAND_NO %>" value="" readonly="readonly"
	MAXLENGTH="8" class="readOnly" /> --%>
	
	<label>Return Date</label>
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=returnDate!= null?HMSUtil.convertDateToStringWithoutTime(returnDate):"" %>" readonly="readonly" class="date"  validate="returnDate,date,no"/>
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= DEMAND_DATE%>,event)" />
	 


<label>From Department</label>
<input  type="text" name="fromDepartment" value="<%=fromDepartmentName %>" validate="fromDepartment,metachar,no"/>
<input  type="hidden" name="storeInternalIndentMId" value="<%=storeInternalIndentMId %>" />
			

<%-- <label>From </label>
<select name="<%=FROM_WARD%>"	>
			<option value="0">Select</option>
	
			</select>--%>
<%--  <label>Return By </label> <select name="<%=TO_WARD%>"
	validate="To Ward,String,yes">
	<option value="0">Select</option>
	
</select> --%>

<div class="clear"></div>
<%-- <label><span>*</span> Approved By</label> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Approved By,String,no">
	<option value="0">Select</option>
	
</select>--%>
 <%-- <label><span>*</span>Received By</label> <select
	name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Request By,String,no">
	<option value="0">Select</option>
	
</select>
<label style="margin-left:-31px;">Stores Remarks</label>
<textarea name="dmoRemarks"  validate="Present Complaint,string,no" cols="0" rows="0"  maxlength="300" tabindex="1" ></textarea> --%>
<div class="clear"></div>

	<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>

<div class="paddingTop15"></div>

<div class="clear"></div>

<h4>Item Details</h4>

<table border="0" cellpadding="0" cellspacing="0">
	
			
					<tr>

						<th></th>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>A/U</th>
						<th>Batch No.</th>
						
						 <th>DOE</th>
						<th>Available Stock</th>
						<th>Qty Returned</th>
						<th>Received Qty</th>
						
					</tr>
					<%
					int i= 1;
					if(storeInternalReturnTList.size()>0){
						for(StoreInternalReturnT storeInternalReturnT : storeInternalReturnTList){
					
					
					%>
					<tr>
						<td><input type="checkbox" class="radioCheck" size="5" value="y" name="srno" id="srNoId<%=i %>"  readonly="readonly"  /></td>
						<td><input type="text" size="8" value="<%=storeInternalReturnT.getItem().getPvmsNo()!= null?storeInternalReturnT.getItem().getPvmsNo():"" %>" name="pvms"   />
						<input type="hidden" size="5" value="<%=storeInternalReturnT.getId()!= null?storeInternalReturnT.getId():"" %>" name="storeInternalReturnTId" id="storeInternalReturnTId<%=i %>"  readonly="readonly"  /></td>
						<td><input type="text" value="<%=storeInternalReturnT.getItem().getNomenclature()!= null?storeInternalReturnT.getItem().getNomenclature():"" %>" name="nomenclature"  /></td>
						<td><input type="text" size="8" value="<%=storeInternalReturnT.getItem() != null && storeInternalReturnT.getItem().getItemConversion()!= null?storeInternalReturnT.getItem().getItemConversion().getItemUnitName():"" %>" name="au"  /></td>
						<td><input type="text" size="8" value="<%=storeInternalReturnT.getBatchNo()!= null?storeInternalReturnT.getBatchNo():"" %>" name="year1IndentQty"  validate="year1IndentQty,float,no"/></td>
						
						<td><input type="text" size="8" value="<%=storeInternalReturnT.getExpiryDate() != null?storeInternalReturnT.getExpiryDate():"" %>" name="previousYearConsumption"  validate="previousYearConsumption,date,no"/></td>
						<td><input type="text" size="8" value="<%=storeInternalReturnT.getStock()!= null?storeInternalReturnT.getStock().getClosingStock().intValue():"0" %>" name="stock" validate="Stock In Hand,float,no"   /></td>
						
						<td><input type="text" size="8" value="<%=storeInternalReturnT.getReturnQty()!= null?storeInternalReturnT.getReturnQty().intValue():"0" %>" name="demandedQty" validate="Demanded Qty,float,no" /></td>
						<td><input type="text" size="8" value="" name="receivedQty" id="receivedQty<%=i %>" validate="Received Qty,float,no" /></td>
						
					<%i++;} }%>
			
</table>
 
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>"  />
<div class="paddingTop40"></div>
<div class="clear"></div>




<div class="clear"></div>
<input type="button" name="Submit" type="submit" value="Submit"	onClick="submitForm('departmentIndent','stores?method=submitDepartmentReturnApproval','validateRows');" class="button">

<script type="text/javascript">

<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
<script type="text/javascript">
function validateRows(){
	var count = document.getElementById('hdb').value;
	for(var i=1;i<count;i++){
		if(document.getElementById('srNoId'+i).checked){
			return true;
		}

	}
	alert("Please select at least one row.");
	return false;
}
</script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>