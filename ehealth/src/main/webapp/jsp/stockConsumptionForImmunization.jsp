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
<%@page import="jkt.hms.masters.business.StoreReservationCampGroup"%>
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
	Calendar tillDate= Calendar.getInstance();
	String tillDateView="";
	tillDate.add(Calendar.DATE, 30);
	String tmonth=String.valueOf((tillDate.get(Calendar.MONTH))+1);
    String tdate=String.valueOf(tillDate.get(Calendar.DATE));
	if(tmonth.length()<2){
		tmonth="0"+tmonth;
		}
		if(tdate.length()<2){
			tdate="0"+tdate;
		}
	tillDateView=tdate+"/"+tmonth+"/"+tillDate.get(calendar.YEAR);
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
	List<StoreReservationCampGroup> campGroupList = new ArrayList<StoreReservationCampGroup>();
	
	String max="";
	if(map.get("max") != null){
		max = (String) map.get("max");
	}
	if(map.get("storeReservationMList") != null){
		storeReservationMList = (List)map.get("storeReservationMList");
	}
	if(map.get("campGroupList") != null){
		campGroupList = (List)map.get("campGroupList");
	}

	
%>
<form name="stockConsumptionForImmunization" method="post">
<div class="titleBg">
<h2>Stock Consumption</h2>
</div>
<div class="clear"></div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class="clear"></div>
<div id = "testDiv">
<div class="Block">

<label>Group</label>
  <select name="group" id="groupId" validate="MO,string,yes" onchange="submitProtoAjax('stockConsumptionForImmunization','pubHealth?method=responseForStockConsumptionForImmunization&reservationId='+this.value);">
<option value="">Select</option>
<%if(storeReservationMList.size()>0){
	 for(StoreReservationM storeReservationM: storeReservationMList){
	%>
<option value="<%=storeReservationM.getId()%>"><%=storeReservationM.getGroup().getGroupName() %></option>
<%}} %>
</select> 
 
<%-- <select name="campName" id="campname" onchange="submitProtoAjax('stockConsumptionForImmunization','pubHealth?method=responseForStockConsumptionForImmunization&reservationId='+this.value);"">
<option value="">Select</option>
<%if(storeReservationMList.size()>0){
	 for(StoreReservationM storeReservationM: storeReservationMList){
	%>

<option value="<%=storeReservationM.getId()%>"><%=storeReservationM.getCampName() %></option>
<%}} %>
</select> --%>
 

 <div class="clear"></div>

</div>
<div class="clear"></div>

<div class="clear"></div>

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
					  	<th>Consumed Qty</th>
					  	<th>Return Stock</th>
					  <!-- 	<th>Till date</th>
					  	<th>Extension</th>
					  	<th>Extension Date</th> -->
						
						
					</tr>
					<%
					int i =1;
					
					%>
					<tr>
		<td><input type="text" size="2" value="<%=i%>" name="<%=SR_NO%>" id="srNoId<%=i %>" class="readOnly" readonly="readonly" /></td>
		<td><input type="text" size="6" tabindex="1"    value="" readonly="readonly" name="pvms" id="pvms<%=i %>" />
		<input type="hidden" value="" name="itemId" id="itemId<%=i %>" /></td>
		
							
	<td><input type="text" value="" tabindex="1" validate="Item Name,string,yes" name="nomenclature" size="20" id="nomenclature<%=i %>" onblur="checkForDefectiveDrugs(this.value, 'nomenclature','<%=i %>');;"  />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-10">
			new Ajax.Autocompleter('nomenclature<%=i %>','ac2update','stores?method=getItemListForIndent1',{minChars:1,parameters:'requiredField=nomenclature'});
			</script></td>
		<td><input type="text" size="6" tabindex="1" disabled value="" name="au" id="au<%=i %>"  class="readOnly" readonly="readonly"  />
		<input type="text" size="6" tabindex="1"  value="" name="auId" id="auId<%=i %>"  class="readOnly" readonly="readonly"  /></td>
		<td><select name="batchName"  id="batchName<%=i%>" onchange="getExpiryDateByAjax(this.value,<%=i%>);" tabindex="1">
					<option value="">Select</option></select></td>
		<td><input type="text" size="8" value="" validate="DOE,date,no" name="doe"  id="doe<%=i %>"/></td>
		<td><input type="text" size="7" tabindex=1 value="" validate="Stock,float,no" name="stock" id="stock<%=i%>" readonly />
		</td>
		<td><input type="text" size="7" tabindex=1 value="" validate="Reserved Stock,float,yes" maxlength="10" name="reservedStock" id="reservedStock<%=i%>"  />
		</td>
		
		<td><input type="text" size="7" tabindex=1 value="" maxlength="10" name="consumedQty" id="consumedQty<%=i%>"  />
	 </td>
	 <td><input type="text" size="7" tabindex=1 value="" maxlength="10" name="returnQty" id="returnQty<%=i%>"  />
	 </td>
		<%-- <td><input type="text" size="8" value="<%=tillDateView %>" readonly="readonly" validate="Till Date,date,no"  name="tillDate" id="tillDate<%=i %>"  />
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date+i%>',document.stockReservationForImmunization.tillDate,event)" />
	 </td>
		
			<td><Select name="extension"  id="extension<%=i%>">
			<option value="">Select</option>
				<option value="yes">yes</option>
				<option value="No">No</option>
			</Select></td>
			<td><input type="text" size="8" value="" readonly="readonly" validate="Extention Date,date,no" name="extensionDate" id="extensionDate<%=i %>"  />
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date+i%>',document.stockReservationForImmunization.extensionDate<%=i %>,event)" />
	 </td> --%>
					</tr>
			</table>
	</div>		
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>"  />
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<label>Remarks</label>
<textarea name="remarks"   validate="Remarks,remarks,no" cols="0" rows="0" class="large" maxlength="198" tabindex="1" ></textarea>
<div class="clear"></div>
<input	type="button" name="Reserved" type="submit" value="Submit" class="button" onclick="submitForm('stockConsumptionForImmunization','pubHealth?method=submitConsumptionForImmunization');" />


<script type="text/javascript">



function calculateReturnQty(inc){
	var incc=inc;
		var consumedQty =0;
		var reservedQty =0;
		var returnQty =0;
		
		if (!isNaN(document.getElementById('consumedQty'+inc).value))
			consumedQty = parseFloat(document.getElementById('consumedQty'+inc).value);
		if (!isNaN(document.getElementById('reservedStock'+inc).value))
			reservedQty = parseFloat(document.getElementById('reservedStock'+inc).value);
		
		
		if(!isNaN(consumedQty) != "" && !isNaN(reservedQty)!= ""){
			
			if(reservedQty>consumedQty){
				returnQty =parseFloat(reservedQty)-parseFloat(consumedQty);
			document.getElementById('returnQty'+inc).value = returnQty;
			}else if(grnQty==storedQty){
				document.getElementById('returnQty'+inc).value = returnQty;	
			
			}else{
				alert("Reserved Quantity Is Greater Than Consumed Quantity ")
			}
		}/* else{
				if(pendingQty >= storedQty){
					
					pendingQty =parseFloat(pendingQty)-parseFloat(storedQty);
					
				document.getElementById('pendingQty'+inc).value = pendingQty;
				}
				else{
					alert("Stored Quantity Is Greater Than Pending Quantity ")
				}
			
		} */
	
	}

</script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>