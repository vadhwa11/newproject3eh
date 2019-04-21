<%@page import="jkt.hms.masters.business.MmSafetyProcedureMaterials"%>
<%@page import="jkt.hms.masters.business.PrqQuotationVendorDetails"%>
<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="jkt.hms.masters.business.PrqQuotationItemDetails"%>
<%@page import="jkt.hms.masters.business.PrqQuotationHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>

<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
serverdate = '<%=date+"/"+month1+"/"+year1%>'

	
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<PrqQuotationItemDetails> itemDetails=new ArrayList<PrqQuotationItemDetails>();
	List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterial=new ArrayList<MmSafetyProcedureMaterials>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if(map.get("mmSafetyProcedureMaterial")!=null){
		mmSafetyProcedureMaterial=(List<MmSafetyProcedureMaterials>)map.get("mmSafetyProcedureMaterial");
	}
	
	   if(map.get("prqItem")!=null)
	   {
		itemDetails=(List<PrqQuotationItemDetails>)map.get("prqItem");
	   }
	  	%>
<%if(itemDetails.size()>0) 
{

%>
<label>Quotation Date </label>
<%if(itemDetails.size()>0){ %>
        
<input type="text" name="quotationRequisitionDate"	id="sdate" value="<%=itemDetails.get(0).getVendorDetails().getHeader() != null ? HMSUtil.changeDateToddMMyyyy(itemDetails.get(0).getVendorDetails().getHeader().getQuotationDate()) :"" %>" class="date" maxlength="30"  readonly="readonly" validate="Quotation Date,date,no"/>
<%} else{%>
<input type="text" name="quotationRequisitionDate"	id="sdate" value="" class="date" maxlength="30" validate="Quotation Date,date,no"/>
<%} %>

<label>Quotation By</label>
<%if(itemDetails.size()>0){ %>
<input type="text"  name="quotationBy" id="quotationBy" value="<%=itemDetails.get(0).getVendorDetails().getHeader() != null ? itemDetails.get(0).getVendorDetails().getHeader().getQuotationBy().getEmployee().getFirstName():"" %>" readonly="readonly" validate="Quotation By,alphanumeric,no"/>
<%} else{%>
<input type="text"  name="quotationBy" id="quotationBy" value="" validate="Quotation By,alphanumeric,no"/>
<%} %>

<div class="clear"></div>
<label>Approved By</label>
<%if(itemDetails.size()>0){ %>
<input type="text"  name="quotationApproved" id="quotationApproved" value="<%=itemDetails.get(0).getVendorDetails().getHeader() != null ? itemDetails.get(0).getVendorDetails().getHeader().getApprovalBy().getEmployee().getFirstName() :""%>" readonly="readonly" validate="Approved By,alphanumeric,no"/>
<%} else{%>
<input type="text"  name="quotationApproved" id="quotationApproved" value="" validate="Approved By,alphanumeric,no"/>
<%}} %>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<h4>Item Details</h4>
<div class="cmntable">
<%

int i=1;
if(itemDetails.size()>0)
	{%>
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="10%">Item Code</th>
			<th width="10%">Item Name</th>
			<th width="10%">Unit</th>
			<th width="10%">Qty Required</th>
			<th width="10%">Quotation Requisition Qty</th>
			<th width="13%">Select</th>
			
		</tr>
	</thead>
	<tbody>
	<%
	        
	    List<Integer> itemList=new ArrayList<Integer>(); 

			if (itemDetails.size() > 0) {
				for (PrqQuotationItemDetails st : itemDetails) {
					  if(!itemList.contains(st.getItem().getId()))
					{
						itemList.add(st.getItem().getId()); 
						 
					
		%>
		<tr>
			<td><%=i %></td>
			<td><%=st.getItem().getPvmsNo() %></td>
			<td><%=st.getItem().getNomenclature() %></td>
			<td><%=st.getItem().getItemConversion().getItemUnitName() %></td>
			<td><%=st.getReqQty().intValue() %></td>
			<td><%=st.getApprovedQty().intValue() %></td>
			<td><input type="checkbox"	name="checkbox" id="checkbox<%=i %>" value="<%=st.getId() %>" tabindex=1 onchange=" vendorDisplay(this.value,'checkbox<%=i %>','Q')"/></td>
			</tr>
			<%
		i++;
					}}}}%>
		</tbody>
	</table>
<table>
<% 
if(mmSafetyProcedureMaterial.size()>0)
			{
					%>
					<thead>
		<tr>
			<th width="13%">Sl No.</th>
			
			<th width="10%">Item Name</th>
			<th width="10%">Item Code</th>
			<th width="13%">Required Quantity</th>
			<th width="13%">Rate</th>
			<th width="13%">Amount</th>
			<th width="13%">Select</th>
			</tr>
	</thead>
	<tbody>
	<%for(MmSafetyProcedureMaterials mm:mmSafetyProcedureMaterial){ %>
	 <input type="hidden" name="requestId"  id="requestId" value="<%=mm.getInspectionReport().getRequest().getId()%>"/> 
	 <input type="hidden" name="inspectionId"  id="inspectionId" value="<%=mm.getInspectionReport().getId()%>"/> 
			<tr>
				<td><%=i %></td>
				<td><%=mm.getItem().getNomenclature() %></td>
				<td><%=mm.getItem().getPvmsNo()  %></td>
				<td><%=mm.getRequiredQty()  %></td>
				<td><%=mm.getItem().getCostPrice()  %></td>
				<td><%=mm.getItem().getCostPrice().multiply(mm.getRequiredQty()).setScale(2) %></td>
				<td ><input type="checkbox"	name="mcheckbox" id="checkbox<%=i %>" value="<%=mm.getId() %>" tabindex="1" onchange=" vendorDisplay(this.value,'checkbox<%=i%>','R')"/></td>
				
			</tr>
				<%i++;;}} %>
	</tbody>
</table>
<%i=i-1; %>
<input type="hidden" name="itemCount"  id="itemCount" value="<%=i%>"/> 
</div>
<div class="Block">
<div id="vendorDiv">	</div>
</div>