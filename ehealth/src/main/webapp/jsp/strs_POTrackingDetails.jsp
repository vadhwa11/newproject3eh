<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="java.math.BigDecimal"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<%
		String userName = "";
int poId=0;
String poDate=null;
String poNo="";
String supplierName="";
	 	if (session.getAttribute("userName") != null) {
	 		userName = (String) session.getAttribute("userName");
	 	}
		Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");

	 	Map<String, Object> map = new HashMap<String, Object>();
	 	if (request.getAttribute("map") != null) {
	 		map = (Map<String, Object>) request.getAttribute("map");
	 	}
	 	List<StorePoHeader> poDetailsList = new ArrayList<StorePoHeader>();
	 	StorePoHeader poHeader=new StorePoHeader();
	 	if(map.get("poDetailsList")!=null){
	 		poDetailsList=(List<StorePoHeader>)map.get("poDetailsList");
	 	}
		if(poDetailsList != null) {
			poHeader = (StorePoHeader) poDetailsList.get(0);
			poId =poHeader.getId();
			poDate=HMSUtil.changeDateToddMMyyyy(poHeader.getPoDate());
			poNo=poHeader.getPoNumber();
			supplierName=poHeader.getSupplier().getSupplierName();
		}
		Set<StorePoDetail> storePoDetailsSet = new HashSet<StorePoDetail>();
		storePoDetailsSet = poHeader.getStorePoDetails();
	%>
	<div class="titleBg">
<h2> PO Tracking Details </h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>PO No.</label>
<label class="value"><%=poNo %></label>

<label>PO Date</label>
<label class="value"><%=poDate %></label>

<label>Supplier Name</label>
<label class="value"><%=supplierName %></label>
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<!-- Table Starts -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th> Sl.No.</th>
		<th> Item Name</th>
		<th> A/U</th>
		<th> Order Qty</th>
		<th> Received Qty</th>
		<th> Pending Qty</th>
	</tr>
		<%
		int temp=0;
		int inc = 0;
		String itemName="";
		String au="";
		BigDecimal orderQty=null;
		BigDecimal receivedQty=null;
		BigDecimal pendingQty=null;
		BigDecimal freeQty=null;
	if(storePoDetailsSet.size()>=inc){
		 for(StorePoDetail poDetail:storePoDetailsSet){
			 inc++;

			 if(poDetail.getItem()!=null){
				 itemName=poDetail.getItem().getNomenclature();
			 }else{
				 itemName="-";
			 }
			 if(poDetail.getItem().getItemConversion()!=null){
				au=poDetail.getItem().getItemConversion().getItemUnitName();
			 }else{
				 au="-";
			 }
		if(poDetail.getQuantityOrdered()!=null){
			orderQty=poDetail.getQuantityOrdered();
		}else {
			orderQty=new BigDecimal(0);
		}
		if(poDetail.getQuantityReceived()!=null){
			receivedQty=poDetail.getQuantityReceived();
		}else{
			receivedQty=new BigDecimal(0);
		}
		if(poDetail.getFreeQuantity()!=null){
			freeQty=poDetail.getFreeQuantity();
		}
		pendingQty=(orderQty.add(freeQty)).subtract(receivedQty);

		%>
		<tr>
		<td>
		<label><%=inc %></label>
		</td>
		<td>
		<input type="text" value="<%=itemName %>" name="itemName" id="itemNameId<%=inc %>" readonly="readonly"/>	</td>
		<td>
		<input type="text" value="<%=au %>" name="au" id="auId<%=inc %>" readonly="readonly"/> </td>
		<td>
		<input type="text" name="orderQty" value="<%=orderQty %>" id="orderQtyId<%=inc %>" readonly="readonly"/></td>
		<td>
		<input type="text" name="receivedQty" value="<%=receivedQty %>" id="receivedQtyId<%=inc %>" readonly="readonly"/></td>
		<td>
		<input type="text" name="pendingQty" value="<%=pendingQty %>" id="pendingQtyId<%=inc %>" readonly="readonly"/></td>

		</tr>
		<%
		} }%>
		</table>

<div class="clear"></div>
<input name="" type="button" class="button"	value="Close" onclick="cancelForm();"/>
<script language="Javascript">
function cancelForm(){
  	 close();
   	}
   	</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		