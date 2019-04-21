<%@page import="jkt.hms.masters.business.MmSafetyProcedureMaterials"%>
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
	List<MmSafetyProcedureMaterials> mmSafetyProcedureMaterial=new ArrayList<MmSafetyProcedureMaterials>();
	List<MmMasRequestStatus> stat=new ArrayList<MmMasRequestStatus>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	if(map.get("itemList")!=null){
		pendingList=(List<PrqQuotationItemDetails>)map.get("itemList");
	}
	if(map.get("stats")!=null){
		stat=(List<MmMasRequestStatus>)map.get("stats");
	}
	if(map.get("mmSafetyProcedureMaterials")!=null){
		mmSafetyProcedureMaterial=(List<MmSafetyProcedureMaterials>)map.get("mmSafetyProcedureMaterials");
	}
	
	System.out.println("------jsp----==="+pendingList.size());
  %>



<h4>Item Details</h4>
<div class="cmntable">
<form name="itemGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<%
	   int i=1;
	if (pendingList.size() > 0) { %>
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="10%">Item Name</th>
			<th width="10%">Item Code</th>
			<th width="13%">Unit</th>
			<th width="13%">Quotation Qty</th>
			<th width="13%">QR Tech. Spec</th>
			<th width="13%">Vendor Tech. Spec</th>
			<th width="13%"><input type="checkbox" name="selectCheckBox1" id="selectCheckBox1" onchange="toggl()"></input>SelectAll</th>
				
			</tr>
	</thead>
         <%
	      for (PrqQuotationItemDetails st : pendingList) {
					String technicalSpecification="";
					if(st.getItem().getSpecification()!=null)
						technicalSpecification=st.getItem().getSpecification();
					String technicalSpecification1="";
					if(st.getTechSpecs()!=null)
						technicalSpecification1=st.getTechSpecs();
						%>
		<tbody>
		<tr>
			<td>
			<%=i %>
			</td>
			<td><%=st.getItem().getNomenclature() %></td>
			<td><%=st.getItem().getPvmsNo() %></td>
			<td><%=st.getItem().getItemConversion().getItemUnitName() %></td>
			<td><%=st.getApprovedQty().intValue()%></td>
			<td><%=technicalSpecification%>	</td>
			<td><%=technicalSpecification1%></td>
			<td><input type="checkbox"	name="itemCheckbox<%=i %>" id="itemCheckbox<%=i %>" value="<%=st.getId() %>" tabindex="1"/></td>
				</tr>
			<%
			i++;
					}}
					
			if(mmSafetyProcedureMaterial.size()>0)
			{
			%>
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="10%">Item Name</th>
			<th width="10%">Item Code</th>
			<th width="13%">Required Quantity</th>
			<th width="13%">Select</th>
			</tr>
	</thead>
	   <%for(MmSafetyProcedureMaterials mm:mmSafetyProcedureMaterial){ %>
	<tbody>
			<tr>
				<td><%=i %></td>
				<td><%=mm.getItem().getNomenclature() %></td>
				<td><%=mm.getItem().getPvmsNo()  %></td>
				<td><%=mm.getRequiredQty().intValue()  %></td>
				<td ><input type="checkbox"	name="maintenanceCheckbox<%=i %>" id="maintenanceCheckbox<%=i %>" value="<%=mm.getId() %>" tabindex="1"/></td>
				<input type="hidden" name="requestId"  id="requestId" value="<%=mm.getInspectionReport().getRequest().getId()%>"/> 
					 <input type="hidden" name="inspectionId"  id="inspectionId" value="<%=mm.getInspectionReport().getId()%>"/> 
			</tr>
				<%i++;}} %>
	</tbody>
</table>
   <input type="hidden" name="itemCount"  id="itemCount" value="<%=i-1%>"/> 
  
   </div>
      <div class="Block">
     <label>Technical Approval</label>
      <select  name="status" validate="Status,string,yes" onchange="vailidate(this)" ><option value="">Select</option>
	 <%for(MmMasRequestStatus stats :stat){ %>
	 <option value="<%=stats.getStatusCode() %>"><%=stats.getStatusName() %></option>
	 <%} %>
	 </select>
     <label id="reason">Reason</label>
    <textarea rows="" cols="" id="remarks" name="remarks"></textarea>

    </div>
    <input name="button"  type="button"	value="Submit" class="button"	onclick="if(validate()){submitForm('searchPanel','procurement?method=saveTechnicalApproval')}"; />
   <input name="button"  type="reset"	value="Reset" class="button"	onclick=""; />
   </form>
   
  