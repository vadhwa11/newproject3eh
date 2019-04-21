<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<StorePoHeader> vendorList = new ArrayList<StorePoHeader>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if(map.get("vendorList")!=null){
		vendorList = (List<StorePoHeader>) map.get("vendorList");
	}
%>



<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<div id="grnDiv">
<div class="Block">
<label><span>*</span>Vendor</label>
<select name="vendorId" id="vendorId" onchange="submitProtoAjax('createGrn','/hms/hms/stores?method=responseForPoNo&vendorId='+this.value);" validate="Vendor,string,yes" tabindex=1>
<option value="">Select</option>
<%
List<Integer> vendor=new ArrayList<Integer>(); 
if(vendorList.size()>0){
	System.out.println("list in jsp"+vendorList.size());
	for(StorePoHeader supplier :vendorList){
		if(supplier.getSupplier().getId()!=null && supplier.getPoNumber()!=null && supplier.getStatus().getId()!=null){
		if(!vendor.contains(supplier.getSupplier().getId()))
		{
			vendor.add(supplier.getSupplier().getId()); 
%>
<option value="<%=supplier.getSupplier().getId() %>"><%=supplier.getSupplier().getSupplierName() %></option>
<%}}}}%>
</select>
<div id="testDiv">
<label><span>*</span>PO No</label>
<select name="poId" id="poId" tabindex=1  >
</select>

<label><span>*</span> Date Received</label>
<input type="text" name="dateReceived"	value="" class="date" readonly="readonly"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.grnGrid.dateReceived,event)" />
<div class="clear"></div>
<label>Invoice No</label>
<select name="indentNo" id="indentCombo" tabindex=1></select>

<label><span>*</span> Invoice Date</label>
<input type="text" name="invoiceDate"	value="" class="date" readonly="readonly"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.grnGrid.invoiceDate,event)" />

<label>Delivery Challan No</label>
<input type="text" name="challanNo" id="challanNo" value="" />
<div class="clear"></div>
<label><span>*</span> PO Date</label>
<input type="text" name="poDate"	value="" class="date" readonly="readonly"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.grnGrid.poDate,event)" />
<div class="clear"></div>

</div>
</div>
</div>

