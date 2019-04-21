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
	List<PrqQuotationItemDetails> pendingList= new ArrayList<PrqQuotationItemDetails>();
	List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterials=new ArrayList<MmSafetyProcedureMaterials>();
	List<MmMasRequestStatus> stat=new ArrayList<MmMasRequestStatus>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	if(map.get("prqQuotationVendorDetails")!=null){
		pendingList=(List<PrqQuotationItemDetails>)map.get("prqQuotationVendorDetails");
	}
	if(map.get("stats")!=null){
		stat=(List<MmMasRequestStatus>)map.get("stats");
	}
	if(map.get("mmSafetyProcedureMaterial")!=null){
		mmSafetyProcedureMaterials=(List<MmSafetyProcedureMaterials>)map.get("mmSafetyProcedureMaterial");
	}
  %>



<h4>Vendor Details</h4>
<div class="cmntable">

<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
  <%  int i=1;
			if (pendingList.size() > 0) {%>
	<thead>
		<tr>
			<th width="13%">Si No.</th>
			<th width="10%">Vendor Type</th>
			<th width="10%">vendor Name</th>
			<th width="13%">Quoted Price</th>
			<th width="13%">L cat.</th>
			<th width="13%">Remarks</th>
			<th width="13%">Select</th>
			</tr>
	</thead>
	<tbody>
           <%int l=0;
			for (int a=0;a<pendingList.size() && l<3;a++) {
				if(a>0){
				//	temp=pendingList.get(a).getTotalAmount();
					//System.out.println(pendingList.get(a-1).getTotalAmount().equals(pendingList.get(a).getTotalAmount()));
				if(pendingList.get(a-1).getTotalAmount().equals(pendingList.get(a).getTotalAmount())){
					l=l;
				}
				else{
					l=l+1;
				}
				}else{l=l+1;}
					%>
		<tr>
			<td><%=i %></td>
			<td><%=pendingList.get(a).getVendorDetails().getVendor().getSupplierType().getSupplierTypeName()%></td>
			<td><%=pendingList.get(a).getVendorDetails().getVendor().getSupplierName()%></td>
			<td><%=pendingList.get(a).getTotalAmount()%></td>
			<td>L<%=l%><input type="hidden" value="L<%=l%>" name="lcat<%=i%>" id="lcat<%=i%>"/></td>
			<td><input type="text" name="remarks" value=""	tabindex=1   id="remarks" /></td>
			<td><input type="checkbox"	name="itemCheckbox<%=i%>" id="itemCheckbox<%=i%>" value="y" tabindex="1"/>
			<input type="hidden"	name="vendorId<%=i%>" id="vendorId<%=i%>" value="<%=pendingList.get(a).getVendorDetails().getId()%>" tabindex="1"/>
			<input type="hidden"	name="itemId<%=i%>" id="itemId<%=i%>" value="<%=pendingList.get(a).getId()%>" tabindex="1"/>
			<input type="hidden"	name="headerId" id="headerId" value="<%=pendingList.get(a).getVendorDetails().getHeader().getId()%>" tabindex="1"/>
			</td>
				</tr>
			<%
		i++;
					}%>
				
	</tbody>
	<%}else if(mmSafetyProcedureMaterials.size()>0){ %>
	<thead>
		<tr>
			<th width="13%">Si No.</th>
			<th width="10%">Vendor Type</th>
			<th width="10%">vendor Name</th>
			<th width="13%">Remarks</th>
			<th width="13%">Select</th>
			</tr>
	</thead>
	<%for(MmSafetyProcedureMaterials spm:mmSafetyProcedureMaterials) {%>
	<tbody>
		<tr>
			<td><%= i%></td>
			<td><%= spm.getInspectionReport().getVendor().getSupplierType().getSupplierTypeName()%></td>
			<td><%= spm.getInspectionReport().getVendor().getSupplierName()%></td>
			<td><input type="text" name="remarks" value=""	tabindex=1   id="remarks" /></td>
			<td><input type="checkbox"	name="maintinenceCheckbox<%=i %>"  id="maintinenceCheckbox<%=i %>" value="<%=spm.getId() %>" tabindex="1"/></td>
		</tr>
	</tbody>
	<%i++;}}else{ %>
	No Records Available.
	<%} %>
</table>
   <input type="hidden" name="vendorCount"  id="vendorCount" value="<%=i-1%>"/> 
  
   </div>
     <div class="Block">
     <label>Commercial Approval</label>
      <select  name="status" validate="Status,string,yes" onchange="vailidat(this)" ><option value="">Select</option>
	 <%for(MmMasRequestStatus stats :stat){ %>
	 <option value="<%=stats.getStatusCode() %>"><%=stats.getStatusName() %></option>
	 <%} %>
	 </select>
     <label id="reason">Reason</label>
    <textarea rows="" cols="" id="remarks" name="remarks"></textarea>

    </div>
     <input name="button"  type="button"	value="Submit" class="button"	onclick="if(validate()){submitForm('itemGrid','procurement?method=saveCommercialApproval')}" />
   <input name="button"  type="reset"	value="Reset" class="button"	onclick=""; />
   
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		