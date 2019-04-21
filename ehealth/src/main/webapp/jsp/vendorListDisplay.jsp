<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="jkt.hms.masters.business.MmInspectionReport"%>
<%@page import="jkt.hms.masters.business.PrqQuotationVendorDetails"%>
<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="jkt.hms.masters.business.PrqQuotationItemDetails"%>
<%@page import="jkt.hms.masters.business.PrqQuotationHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
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
	List<PrqQuotationVendorDetails> prqHdr=new ArrayList<PrqQuotationVendorDetails>();
	List<MmServiceRequest> mmServiceRequest=new ArrayList<MmServiceRequest>();
	List<MmInspectionReport> inspectionReport=new ArrayList<MmInspectionReport>();
	
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
	  if(map.get("mmServiceRequests")!=null)
	   {
		  mmServiceRequest=(List<MmServiceRequest>)map.get("mmServiceRequests");
	   }
     
	  if(map.get("inspectionReports")!=null)
	   {
		  inspectionReport=(List<MmInspectionReport>)map.get("inspectionReports");
	   }
	
	   if(map.get("prqItem")!=null)
	   {
		prqHdr=(List<PrqQuotationVendorDetails>)map.get("prqItem");
	   }
	  // System.out.println("0099---"+prqHdr.size());
	   /*  System.out.println("--==="+(prqHdr.get(0).size());
	    Date date1=null;
	    if(prqHdr.get(0).getHeader().getQuotationDate()!=null)
	  {
		  date1=prqHdr.get(0).getHeader().getQuotationDate();
	  }
	 //System.out.println("vendor.size="+prqHdr.size()+"headerSize="+hdr.size()); */
	if(prqHdr.size()>0){
	%>
<label>Quotation Date </label>
<%if(prqHdr.size()>0){ %>
        
<input type="text" name="quotationRequisitionDate"	id="sdate" value="<%=prqHdr.get(0).getHeader() != null ? HMSUtil.changeDateToddMMyyyy(prqHdr.get(0).getHeader().getQuotationDate()) :"" %>" class="date" maxlength="30" tabindex=1 readonly="readonly" validate="Q Date,date,no"/>
<%} else{%>
<input type="text" name="quotationRequisitionDate"	id="sdate" value="" class="date" maxlength="30" tabindex=1 validate="Q Date,date,no"/>
<%} %>

<label>Quotation By</label>
<%if(prqHdr.size()>0){ %>
<input type="text"  name="quotationBy" id="quotationBy" value="<%=prqHdr.get(0).getHeader() != null ? prqHdr.get(0).getHeader().getQuotationBy().getEmployee().getFirstName():"" %>" readonly="readonly" validate="Quotation By,aphanumeric,no"/>
<%} else{%>
<input type="text"  name="quotationBy" id="quotationBy" value="" validate="Quotation By,aphanumeric,no"/>
<%} %>

<div class="clear"></div>
<label>Approved By</label>
<%if(prqHdr.size()>0){ %>
<input type="text"  name="quotationApproved" id="quotationApproved" value="<%=prqHdr.get(0).getHeader() != null ? prqHdr.get(0).getHeader().getApprovalBy().getEmployee().getFirstName() :""%>" readonly="readonly" validate="Approved By,aphanumeric,no"/>
<%} else{%>
<input type="text"  name="quotationApproved" id="quotationApproved" value="" validate="Approved By,aphanumeric,no"/>
<%}} %>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<h4>Vendor Details</h4>



<div class="cmntable">
<%int i=1;
if(prqHdr.size()>0)
	{
	%>
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="10%">Vendor Name</th>
			<th width="10%">Address</th>
			<th width="13%">Select</th>
			
		</tr>
	</thead>
	<tbody>
	<%
	         
	     List<Integer> vendorIdList=new ArrayList<Integer>();
			if (prqHdr.size() > 0) {
				
		 	%>
				<%--<input type="text" name="requisationby" value="<%=prqHdr.get(0).getHeader().getQuotationBy().getEmployee().getFirstName() %>"	tabindex=1  id="requisationby" />
			<input type="text" name="requisationDate" value="<%=prqHdr.get(0).getHeader().getQuotationDate() %>"	tabindex=1  id="requisationDate" />
			<input type="text" name="quotationBy" value="<%=prqHdr.get(0).getHeader().getApprovalBy().getEmployee().getFirstName() %>"	tabindex=1  id="quotationBy" /> --%>
				<%
				
				for (PrqQuotationVendorDetails st : prqHdr) {
					if(!vendorIdList.contains(st.getVendor().getId()))
					{
						vendorIdList.add(st.getVendor().getId());
						String add="";
						if(st.getVendor().getAddress1()!=null)
						{
							add=st.getVendor().getAddress1();
						}
		%>
		<tr>
			<td>
			<%=i %>
			</td>
			<td><%=st.getVendor().getSupplierName() %></td>
			<td><%=add %></td>
			<td><input type="checkbox"	name="checkbox" id="checkbox<%=i %>" value="<%=st.getId() %>" tabindex=1   onchange="vender(this)"/></td>
			</tr>
			<%
		i++;
					}}}%>
				
	</tbody>
</table>
<%}
 if(inspectionReport.size()>0){
	
 %>
 <table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="13%">Sl No.</th>
				<th width="10%">request no.</th>
				<th width="10%">Vendor Name</th>
				<th width="13%">Select</th>
				
			</tr>
		</thead>
     <%for(MmInspectionReport mminspectionReport:inspectionReport){ %>
      <tbody>
       <tr>
       <td><%=i %></td>
       <td><%=mminspectionReport.getRequest().getServiceRequestNo() %></td>
       <td><%=mminspectionReport.getVendor().getSupplierName() %></td>
       <td>
			<input type="checkbox"	name="maintinanceChk" id="maintinanceChk<%=i %>" value="<%=mminspectionReport.getId() %>" tabindex=1   onchange="maintinenceItemList(this)"/>
			</td>
			</tr>
       </tbody>
     <% }%>
     </table>
     <%}i=i-1; %>
 <input type="hidden" name="venderCount"  id="venderCount" value="<%=i%>"/> 

</div>
<div class="Block">
	<div id="testDiv">	</div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		