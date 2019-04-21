<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if(map.get("poHeaderList")!=null){
		poHeaderList = (List<StorePoHeader>) map.get("poHeaderList");
	}
%>



<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<div class="Block">

<div id="testDiv">
<div id="poDiv">
<label><span>*</span>PO No</label>
<select name="poId" id="poId" tabindex=1 onchange="submitProtoAjaxWithDivName('createGrn','/hms/hms/stores?method=responseForPoGrid&poId='+this.value,'poDiv');" validate="Po No.,string,yes">
<option value="">Select</option>
<%
if(poHeaderList.size()>0){
	for(StorePoHeader storePoHeader:poHeaderList){

%>
<option value="<%=storePoHeader.getId() %>"><%=storePoHeader.getPoNumber() %></option>
<%}} %>
</select>
<label><span>*</span> PO Date</label>
<input type="text" name="poDate"	value="" class="date" readonly="readonly" validate="Po Date,date,yes"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.grnGrid.poDate,event)" />

<label><span>*</span> Date Received</label>
<input type="text" name="dateReceived"	value="" class="date" readonly="readonly" validate="Date Received,date,yes"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.grnGrid.dateReceived,event)" />
<div class="clear"></div>
<label><span>*</span>Invoice No</label>
<input type="text" name="invoiceNo" id="invoiceId" value="" validate="Invoice No,string,yes"  />

<label><span>*</span> Invoice Date</label>
<input type="text" name="invoiceDate"	value="" class="date" readonly="readonly" validate="Invoice Date,date,yes"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.grnGrid.invoiceDate,event)" />

<label>Delivery Challan No</label>
<input type="text" name="challanNo" id="challanNo" value="" validate="Challan No,string,yes" />
<div class="clear"></div>

<div class="clear"></div>

</div>
</div>
</div>


