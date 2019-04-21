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
<%@page import="jkt.hms.masters.business.Users"%>
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

function vendorDisplay(obj,id)
{
	//alert(obj+""+id);
	 var itemCount=document.getElementById('itemCount').value;
	// alert(itemCount);
	 var selected=0;
	 for(var i=1;i<=itemCount;i++)
		 {
		 if(document.getElementById('checkbox'+i).checked)
			 {
			 selected++;
			 }
		 }
  // alert(selected);
	 if(selected>1)
		 {
		 alert('Please only one Item!!'+selected);
		 document.getElementById(id).checked=false;
		 return;
		 }
	 if(document.getElementById(id).checked)
		 {
		 submitProtoAjaxWithDivName('itemGrid','/hms/hms/procurement?method=vendorListNegotiation&requisitionId='+obj+'','vendorDivId');
		 }
	 else
		 {
		 document.getElementById('vendorDivId').innerHTML="";
		 }
}


function onApproveSelection(obj,index)
{
	
		if(obj.checked)
		{
			document.getElementById('rejectCheckbox'+index).checked=false;
		}
}

function onDisapproveSelection(obj,index)
{
	
		if(obj.checked)
		{
			document.getElementById('approveCheckbox'+index).checked=false;
		}
}

</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<PrqQuotationItemDetails> itemDetails=new ArrayList<PrqQuotationItemDetails>();
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
	   if(map.get("prqItem")!=null)
	   {
		itemDetails=(List<PrqQuotationItemDetails>)map.get("prqItem");
	   } 
	  	%>
	  	<%if(map.get("msg")!=null) {%>
	  	<%=map.get("msg") %>
	  	<%} %>
<div class="titleBg">
<h2>Negotiation Process</h2>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<form name="itemGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">

<div class="clear"></div>
<%if(itemDetails.size()>0) 
{

%>
<label>Quotation No. </label>
<%if(itemDetails.size()>0){ %>
        
<input type="text" name="quotationRequisitionNo"	id="quotationRequisitionNo" value="<%=itemDetails.get(0).getVendorDetails().getHeader() != null ? itemDetails.get(0).getVendorDetails().getHeader().getQuotationNo() :"" %>" class="date" maxlength="30" tabindex=1 readonly="readonly"/>
<input type="hidden" name="requitionId"	id="requitionId" value="<%=itemDetails.get(0).getVendorDetails().getHeader() != null ? itemDetails.get(0).getVendorDetails().getHeader().getId() :"" %>" class="date" maxlength="30" tabindex=1 readonly="readonly"/>
<%} else{%>
<input type="text" name="quotationRequisitionNO"	id="quotationRequisitionNO" value="" maxlength="30" tabindex=1 />
<%} %>
<label>Quotation Date </label>
<%if(itemDetails.size()>0){ %>
        
<input type="text" name="quotationRequisitionDate"	id="sdate" value="<%=itemDetails.get(0).getVendorDetails().getHeader() != null ? HMSUtil.changeDateToddMMyyyy(itemDetails.get(0).getVendorDetails().getHeader().getQuotationDate()) :"" %>" class="date" maxlength="30" tabindex=1 readonly="readonly"/>
<%} else{%>
<input type="text" name="quotationRequisitionDate"	id="sdate" value="" class="date" maxlength="30" tabindex=1 />
<%} %>

<label>Quotation By</label>
<%if(itemDetails.size()>0){ %>
<input type="text"  name="quotationBy" id="quotationBy" value="<%=itemDetails.get(0).getVendorDetails().getHeader() != null ? itemDetails.get(0).getVendorDetails().getHeader().getQuotationBy().getEmployee().getFirstName():"" %>" readonly="readonly"/>
<%} else{%>
<input type="text"  name="quotationBy" id="quotationBy" value=""/>
<%} %>

<div class="clear"></div>
<label>Approved By</label>
<%if(itemDetails.size()>0){ %>
<input type="text"  name="quotationApproved" id="quotationApproved" value="<%=itemDetails.get(0).getVendorDetails().getHeader() != null ? itemDetails.get(0).getVendorDetails().getHeader().getApprovalBy().getEmployee().getFirstName() :""%>" readonly="readonly"/>
<%} else{%>
<input type="text"  name="quotationApproved" id="quotationApproved" value=""/>
<%}} %>

</div>
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
			<td><input type="checkbox"	name="checkbox" id="checkbox<%=i %>" value="<%=st.getId() %>" tabindex=1 onchange=" vendorDisplay(this.value,'checkbox<%=i %>')"/>
			<input type="hidden" name="itemId" id="itemId" value="<%=st.getItem().getId() %>>">
			</td>
			</tr>
			<%
		i++;
					}}}}%>
		</tbody>
	</table>
	<%i=i-1; %>
<input type="hidden" name="itemCount"  id="itemCount" value="<%=i%>"/> 
</div>
<div class="Block">
<div id="vendorDivId"></div>
</div>
</form>
<script type="text/javascript">
function msgDisplay(obj,index)
{
	var venderCount=document.getElementById('vendorCount').value;
	var approvecount=0;
	for(var i=1;i<=venderCount;i++)
	 {
		if(document.getElementById('approveCheckbox'+i).checked)
		 {
			approvecount++;
		 if(approvecount>1)
			 {
			 document.getElementById('approveCheckbox'+index).checked=false;
			 alert('You can approve only one vendor');
			 return;

			 }
		
		 }
	 }
	if(document.getElementById('newAmt'+document.getElementById('approveCheckbox'+index).value).value == ""){
		document.getElementById('newAmt'+document.getElementById('approveCheckbox'+index).value).value=document.getElementById('oldAmt'+document.getElementById('approveCheckbox'+index).value).value;
	}
	 for(var i=1;i<=venderCount&&i!=index;i++)
	 {
	 if(!document.getElementById('rejectCheckbox'+i).checked)
		 {
		 alert('please reject first one and set Reason');
		 document.getElementById('approveCheckbox'+index).checked=false;
		 return;
		 }
	 } }
	 
	 function submitNegotiation()
	 {
		 var venderCount=document.getElementById('vendorCount').value;
		 var approvecount=0;
		 for(var i=1;i<=venderCount;i++)
		 {
			if(document.getElementById('approveCheckbox'+i).checked)
			 {
				approvecount++;
			
			 }
		 }
		 if(approvecount==0)
		 {
		 alert('Please select atleast one vendor');
		 return;
		 }
			for(var i=1;i<=venderCount;i++)
			 {
				if(document.getElementById('approveCheckbox'+i).checked)
				 {
					document.getElementById('newAmt'+document.getElementById('approveCheckbox'+i).value).setAttribute("validate", "New Price,float,yes");
				 }
				else
					{
					document.getElementById('newAmt'+document.getElementById('approveCheckbox'+i).value).setAttribute("validate", "New Price,float,no");
					}
			 }
			submitForm('itemGrid','procurement?method=saveNegotiation');
	 }
</script>
