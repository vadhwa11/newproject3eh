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
<%@page import="jkt.hms.masters.business.StoreReservationM"%>
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

<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>


<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
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
	List<StoreReservationM> storeReservationMList = new ArrayList<StoreReservationM>();
	if(map.get("storeReservationMList") != null){
		storeReservationMList = (List)map.get("storeReservationMList");
	}
	

	
%>
<form name="unreservedStock" method="post">
<div class="titleBg">
<h2>UnReserved Stock</h2>
</div>
<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>

<div id = "testDiv">
<div class="Block">
<label>Reservation No.</label>
<select name="reservationId" onchange="submitProtoAjax('unreservedStock','stores?method=responseForUnReservedItems&reservationId='+this.value);">
<option value="">Select</option>
<%if(storeReservationMList.size()>0){
	for(StoreReservationM reservationM :storeReservationMList){
	%>
	<option value="<%=reservationM.getId()%>"><%=reservationM.getReservationNo() %></option>
<%}} %>
</select>

<div class="clear"></div>
</div>
<!-- <input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" /> -->
<!--   <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="" /> -->
	<div class="cmntable">
			<table width="100%"  id="blockDetails" >
				
					<tr>

						<th>S.No.</th>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Batch No.</th>
					 	<th>DOE</th>
					  	<th>Stock</th>
					  	<th>Reserved Stock</th>
					  	<th>UnReserved Stock</th>
					  	<th>Till date</th>
					  	<%-- <th>Extension</th>
					  	<th>Extension Date</th>--%>
						
						
					</tr>
					<%
					int i =1;
					
					%>
					<tr>
		<td><input type="checkbox" size="2" value="" name="srNo" class="radioCheck" id="srNoId<%=i %>"  /></td>
		<td><input type="text" size="6" tabindex="1" readonly="readonly" value="" name="pvms" id="pvms<%=i %>" />
		<input type="hidden" value="" name="itemid" id="itemId<%=i %>" /></td>
		
							
	<td><input type="text" value="" tabindex="1" name="nomenclature" size="20" id="nomenclature<%=i %>" onblur="checkForDefectiveDrugs(this.value, 'nomenclature','<%=i %>');;"  />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-10">
			new Ajax.Autocompleter('nomenclature<%=i %>','ac2update','stores?method=getItemListForIndent',{minChars:1,parameters:'requiredField=nomenclature'});
			</script></td>
		<td><input type="text" size="6" tabindex="1" disabled value="" name="au" id="au<%=i %>" class="readOnly" readonly="readonly" /></td>
		<td><select name="<%=BATCH_ID%>" id="batchId<%=i%>" onchange="getExpiryDateByAjax(this.value,<%=i%>);" tabindex="1">
					<option value="">Select</option></select></td>
		<td><input type="text" size="8" value=""  name="doe"  id="doe<%=i %>"/></td>
		<td><input type="text" size="7" tabindex=1 value="" name="stock" id="stock<%=i%>" readonly />
		</td>
		<td><input type="text" size="7" tabindex=1 readonly="readonly" value="" name="reservedStock" id="reservedStock<%=i%>"  />
		</td>
		<td><input type="text" size="7" tabindex=1 value="" maxlength="10" name="unReservedStock" id="unReservedStock<%=i%>" onblur="checkStock(this.value,<%=i%>);"  />
		</td>
		<td>
<%-- 		<input type="text" size="8" value=""  name="tillDate" id="tillDate<%=i %>"  /> --%>
		<input type="text" size="8" value="" readonly="readonly"  name="tillDate" id="tillDate<%=i %>"  />
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date+i%>',document.unreservedStock.tillDate,event)" />
	 
	 </td>
		
		<%-- 	<td><Select name="extension" id="extension<%=i%>">
			<option value="">Select</option>
				<option value="y">yes</option>
				<option value="n">No</option>
			</Select></td>
			<td><input type="text" size="8" value=""  name="extensionDate" id="extensionDate<%=i %>"  />
	 </td>--%>
					</tr>
			</table>
	</div>		
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<label>Remarks</label>
<textarea name="remarks"   validate="Remarks,string,no" cols="0" rows="0" class="large" maxlength="300" tabindex="1" ></textarea>
<div class="clear"></div>
<input	type="button" name="UnReserved" type="submit" value="UnReserved" class="button" onclick="submitForm('unreservedStock','stores?method=submitUnResrvedStock');" />



<script type="text/javascript">

function checkStock(val,inc){
	var reservedStock =  document.getElementById('reservedStock'+inc).value;	
	if(parseFloat(val) > parseFloat(reservedStock)){
		alert("Unreserved Stock  cannot be greater than Reserved Stock Quantity.")
		document.getElementById('unReservedStock'+inc).value = "";
		return false;	
	}	
	return true;	
}



</script>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


