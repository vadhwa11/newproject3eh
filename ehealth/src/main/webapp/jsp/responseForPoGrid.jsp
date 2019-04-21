<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
	List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
	List<MasManufacturer> manufactureList = new ArrayList<MasManufacturer>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if(map.get("poHeaderList")!=null){
		poHeaderList = (List<StorePoHeader>) map.get("poHeaderList");
	}
	if(map.get("poDetailList")!=null){
		poDetailList = (List<StorePoDetail>) map.get("poDetailList");
	}
	if(map.get("manufactureList")!=null){
		manufactureList = (List<MasManufacturer>) map.get("manufactureList");
	}
	String poNo = "";
	int poId = 0;
	Date poDate = new Date();
	if(poHeaderList.size()>0){
		StorePoHeader storePoHeader = poHeaderList.get(0);
		if(storePoHeader.getPoNumber() != null){
			poNo = storePoHeader.getPoNumber();
		}
		if(storePoHeader.getId() != null){
			poId = storePoHeader.getId();
		}
		if(storePoHeader.getPoDate() != null){
			poDate = storePoHeader.getPoDate();
		}
		
	}
%>



<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<div class="Block">


<div id="poDiv">
<label><span>*</span>PO No</label>
<select name="poId" id="poId" tabindex=1  validate="Po No.,string,yes">
<%
if(poHeaderList.size()>0){
	for(StorePoHeader storePoHeader:poHeaderList){

%>
<option value="<%=storePoHeader.getId() %>" selected="selected"><%=storePoHeader.getPoNumber() %></option>
<%}} %>
</select>
<label><span>*</span> PO Date</label>
<input type="text" name="poDate"	value="<%=poDate!= null?HMSUtil.convertDateToStringWithoutTime(poDate):"" %>" class="date" readonly="readonly"	MAXLENGTH="30" tabindex=1 validate="Po Date,date,yes" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.poDate,event)" />

<label><span>*</span> Date Received</label>
<input type="text" name="dateReceived"	value="" class="date" readonly="readonly"	MAXLENGTH="30" tabindex=1 validate="Date Received,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.dateReceived,event)" />
<div class="clear"></div>
<label><span>*</span>Invoice No</label>
<input type="text" name="invoiceNo" id="invoiceId" value=""  validate="Invoice No,string,yes"/>

<label><span>*</span> Invoice Date</label>
<input type="text" name="invoiceDate"	value="" class="date" readonly="readonly" validate="Invoice Date,date,yes"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.invoiceDate,event)" />

<label>Delivery Challan No</label>
<input type="text" name="challanNo" id="challanNo" value="" validate="Challan No,string,no"/>
<div class="clear"></div>

<div class="clear"></div>

</div>
</div>

<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Item Details</h4>
<div class="cmntable">
<table border="0" cellpadding="0" cellspacing="0" id="indentGrid" >


<tr>
						<th>Sl No.</th>
						<th>Item Code</th>
						<%-- <th>KMSCL Item Code</th>--%>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Batch No.</th>
						<th>DOM/DOS</th>
						<th>DOE/DWE</th>
						<th>Manufacture</th>
						<th>Approved Qty</th>
						<th>Received Qty</th>
					  	<th>Surplus</th>
						<th>Defficency</th>
						<th>Remarks</th>
						</tr>
					
						<%int i = 1;
						if(poDetailList.size()>0){
							for(StorePoDetail storePoDetail : poDetailList){
						
						
						
						
						
						%>
						
	<tr>
		<td><%=i %></td>
		<td><input type="text" size="5" value="<%=storePoDetail.getItem() != null && storePoDetail.getItem().getPvmsNo()!= null?storePoDetail.getItem().getPvmsNo():"" %>" name="pvms" id="pvms<%=i %>"  readonly="readonly" />
		<input type="hidden" size="5" value="<%=storePoDetail.getItem() != null && storePoDetail.getItem().getId()!= null?storePoDetail.getItem().getId():"" %>" name="itemId" id="itemId<%=i %>"  readonly="readonly" /></td>
		<%-- <td></td>--%>
		<td><input type="text" value="<%=storePoDetail.getItem() != null ?storePoDetail.getItem().getNomenclature():"" %>" validate="Item Name,string,yes" tabindex="1" name="nomenclature" size="30" id="nomenclature<%=i %>"  /></td>
		<td><input type="text" size="4" value="<%=storePoDetail.getItem().getItemConversion()!= null?storePoDetail.getItem().getItemConversion().getItemUnitName():"" %>" validate="Unit,string,yes" name="au" id="au<%=i %>" readonly="readonly" /></td>
		
		<td><input type="text" size="8" value="" name="batchNo" id = "batchNo<%=i %>" validate="Batch No,string,yes"  /></td>
		<td><input type="text" size="8" value="" name="manufacturingDate" id="manufacturingDate<%=i %>" validate="Manufacture Date,date,yes" />
	 	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.getElementById('manufacturingDate<%=i %>'),event)" />
		</td>
		<td><input type="text" size="8" value="" name="expiryDate" id="expiryDate<%=i %>" validate="Expiry Date,date,yes" />
	 	<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.getElementById('expiryDate<%=i %>'),event)" />
		</td>
		<td><Select name="manufacturerId" id="manufacturerId<%=i %>" validate="Manufacture,string,yes">
			<option value="">Select</option>
			<%if(manufactureList.size()>0){
				for(MasManufacturer masManufacturer :manufactureList){
				if(storePoDetail.getManufacturer()!=null && storePoDetail.getManufacturer().getId() == masManufacturer.getId()){
				%>
				<option value="<%=masManufacturer.getId()%>" selected="selected"><%=masManufacturer.getManufacturerName() %></option>
			<%} else { %>
				<option value="<%=masManufacturer.getId()%>"><%=masManufacturer.getManufacturerName() %></option>
			<%} } 
			}%>
		</Select></td>
		<%-- <td><input type="text" size="4" value="<%=storePoDetail.getManufacturer() != null?storePoDetail.getManufacturer().getManufacturerName():"" %>"  validate="Manufacture,string,yes" name="manufacture" id="manufacture<%=i %>"  />
		<input type="hidden" size="4" value="<%=storePoDetail.getManufacturer() != null ?storePoDetail.getManufacturer().getId():"" %>" name="manufacturerId" id="manufacturerId<%=i %>"  /></td>--%>
		<td><input type="text" size="8" value="<%=storePoDetail.getQuantityOrdered() != null ?storePoDetail.getQuantityOrdered():"" %>" name="issuedQty" validate="Approved Qty,float,yes" id="issuedQty<%=i %>" /></td>
		<td><input type="text" size="8" value="" name="quantityReceived" id="quantityReceived<%=i %>" onblur="calulateStock(<%=i %>);"  validate="Received Qty,float,yes" /></td>
		<td><input type="text" size="8" value="" name="surplus" id="surplus<%=i %>" validate="Surplus,float,no"  /></td>
		<td><input type="text" size="8" value="" name="deficient" id="deficient<%=i %>"  validate="Defficient,float,no"/></td>
		<td><input type="text" size="12" value="" name="remarks" id="remarks<%=i %>" validate="Remarks,string,no"  /></td>
		</tr>

	<%i++;}} %>
					</table>
		</div>


