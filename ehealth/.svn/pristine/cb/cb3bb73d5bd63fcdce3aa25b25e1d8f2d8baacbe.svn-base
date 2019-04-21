<%@page import="jkt.hms.masters.business.MmSafetyProcedureMaterials"%>
<%@page import="jkt.hms.masters.business.PrqQuotationVendorDetails"%>
<%@page import="jkt.hms.masters.business.PrqQuotationItemDetails"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
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


<%
	Map<String, Object> map= new HashMap<String, Object>();
	List<PrqQuotationItemDetails> details= new ArrayList<PrqQuotationItemDetails>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	if(map.get("itemDetails")!=null){
		details=(List<PrqQuotationItemDetails>)map.get("itemDetails");
	}
	
  %>
 


<h4>Vendor Details</h4>
<div class="cmntable">

<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
  <%  int i=1;
   if (details.size() > 0) {%>
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="10%">vendor Name</th>
			<th width="10%">Address</th>
			<th width="13%">Unit Price</th> <!-- added by amit das on 06-06-2016 -->
			<th width="13%">Quoted Price</th>
			<th width="13%">New Price</th>
			<th width="13%">L cat.</th>
			<th width="13%">Approved</th>
			<th width="13%">Reject</th>
		     <th width="13%">Reason</th>
			</tr>
	</thead>
	<tbody>
           <%int l=0;
           List<Integer> vendorList=new ArrayList<Integer>(); 

			for (PrqQuotationItemDetails detail:details) {
				String add="";
				if(detail.getVendorDetails().getVendor().getAddress1()!=null)
				{
					add=detail.getVendorDetails().getVendor().getAddress1();
				}
				if(!vendorList.contains(detail.getVendorDetails().getId()))
				{
					vendorList.add(detail.getVendorDetails().getId()); 
					 
				%>
		<tr>
			<td><%=i %></td>
			<td><%=detail.getVendorDetails().getVendor().getSupplierName() %></td>
			<td><%=add %></td>
			<td><%=detail.getRate()!=null ? detail.getRate().intValue():""  %> <!-- added by amit das on 06-06-2016 -->
			<td><%=detail.getTotalAmount()!=null ? detail.getTotalAmount().intValue():""  %>
			<input type="hidden" name="oldAmt<%=detail.getVendorDetails().getId() %>" id="oldAmt<%=detail.getVendorDetails().getId() %>" value="<%=detail.getTotalAmount()!=null ? detail.getTotalAmount().intValue():""  %>" />
			</td>
			<td><input type="text" name="newAmt<%=detail.getVendorDetails().getId() %>" id="newAmt<%=detail.getVendorDetails().getId() %>" value="" /></td>
			<td><input type="text" name="lcat" value="L<%=detail.getLCategory() %>"/></td>

			<td><input type="checkbox"	name="approveCheckbox" id="approveCheckbox<%=i %>" value="<%=detail.getVendorDetails().getId() %>" tabindex="1" onchange=" msgDisplay(this,'<%=i %>');onApproveSelection(this,'<%=i%>');"/></td>
			<td><input type="checkbox"	name="rejectCheckbox" id="rejectCheckbox<%=i %>" value="<%=detail.getVendorDetails().getId() %>" tabindex="1" onchange="onDisapproveSelection(this,'<%=i%>');"/></td>
			<td><input type="textbox" name="reject<%=detail.getVendorDetails().getId() %>" id="reject" value=""/></td>
			<input type="hidden" name="headerId"  id="headerId" value="<%=detail.getVendorDetails().getHeader().getId()%>"/> 
				</tr>
			<%
		i++;
				}}}%>
				
</tbody>
</table>
   <input type="hidden" name="vendorCount"  id="vendorCount" value="<%=i-1%>"/> 
   
  </div>
  <div class="block">
   <input name="button"  type="button"	value="Submit" class="button"	onclick="submitNegotiation();" />
  <input name="button"  type="reset"	value="Reset" class="button" />
   </div>
     
   
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		