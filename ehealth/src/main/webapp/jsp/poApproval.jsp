<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
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

 function submit()
 {
	
 }
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MmMasRequestStatus> status=new ArrayList<MmMasRequestStatus>();
	List<StorePoDetail> storePoDetails=new ArrayList<StorePoDetail>();
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
	if(map.get("status")!=null)
	{
		status=(List<MmMasRequestStatus>)map.get("status");
	}
	if(map.get("poDetails")!=null)
	{
		storePoDetails=(List<StorePoDetail>)map.get("poDetails");
	}
     System.out.println("====="+storePoDetails.size());
	%>

<div class="titleBg">
<h2>PO  Approval</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->
<div class="Block">
<form name="searchPanel" method="post">
<div class="clear"></div>
 <%if(storePoDetails.size()>0) {%>
<label>PO Creation Date </label>
<%
String poDate="";
if(storePoDetails.get(0).getPo()!=null && storePoDetails.get(0).getPo().getPoDate()!=null)
{
	poDate=HMSUtil.convertDateToStringTypeDateOnly(storePoDetails.get(0).getPo().getPoDate())  ;
}
%>
<input type="text" name="poCreationDate"	value="<%=poDate %>" class="date" maxlength="30" tabindex=1 />



<label>Vendor Name </label>
<input type="text" name="vendorName" id="vendorname" value="<%=storePoDetails.get(0).getPo().getSupplier().getSupplierName()%>"/>


<label>Delivery Date </label>
<%
String delDate="";
if(storePoDetails.get(0).getPo()!=null && storePoDetails.get(0).getPo().getDeliveryDate()!=null)
{
	delDate=HMSUtil.convertDateToStringTypeDateOnly(storePoDetails.get(0).getPo().getDeliveryDate());
}
%>
<input type="text" name="deliveryDate" value="<%=delDate%>" class="date" maxlength="30" tabindex=1 />

<div class="clear"></div>

<label>Delivery To</label>
<%
String delivery="";
if(storePoDetails.get(0).getPo()!=null && storePoDetails.get(0).getPo().getDeliveryTo().getHospitalName() !=null)
{
	delivery=storePoDetails.get(0).getPo().getDeliveryTo().getHospitalName();
			}
%>
<input type="text" name="deliveryTo" id="deliveryTo" value="<%=delivery %>"/>

<label>Delivery Address</label>
<%
String deliveryAdd="";
if(storePoDetails.get(0).getPo()!=null && storePoDetails.get(0).getPo().getDeliveryAddress()!=null)
{
	deliveryAdd=storePoDetails.get(0).getPo().getDeliveryAddress();
			}
%>
<input type="text" name="deliveryTo" id="deliveryTo" value="<%=deliveryAdd %>"/>


<label>PO Approval Date </label>
<input type="text" name="poApprovalDate" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.poApprovalDate,true);" />

</div>
<div class="clear"></div>

<h4>Item Details</h4>

	
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Item Code</th>
			<th width="10%">Item Name</th>
			<th width="10%">unit</th>
			<th width="20%">Qty</th>
			<th width="10%">Amount</th>
			<!-- <th width="10%">Discount%</th>
			<th width="10%">tax%</th>
			<th width="10%">Net Amount</th> -->
			<th width="13%">SelectAll<input type="checkbox" name="selectCheckBox1" id="selectCheckBox1" onchange="toggl()"></input></th>
				

		</tr>
	</thead>
	<tbody>
	         <% int i=1;
	         if(storePoDetails.size()>0){
	        	 
	        	 for(StorePoDetail detail:storePoDetails)
	        	 {%>
	       <tr>
		<td><%=i %></td>
		    <td width="5%"><%=detail.getItem().getPvmsNo()%></td>
			<td width="5%"> <%=detail.getItem().getNomenclature() %></td>
			<td width="5%"><%=detail.getItem().getItemConversion().getItemUnitName() %></td>
			<td width="5%"><%=detail.getQuantityOrdered()%></td>
			<td width="5%"><%=detail.getAmount() %></td>
			<%-- <td width="5%"><%=detail.getDiscountPercent() %></td>
			<td width="5%"><%=detail.getTaxPercent() %></td>
			<td width="5%"><%=detail.getDiscountAmount()%></td> --%>
			
			<td><input name="itemCheckBox<%=i %>" id="itemCheckBox<%=i %>" type="checkbox" value="<%=detail.getId() %>" />
			<input type="hidden" name="headerId" id="headerId" value="<%=detail.getPo().getId() %>"/>
			</td>
			</tr>
	      <%i++;
	        	 }}%>
	</tbody>
</table>
</div>
<input type="hidden" name="itemCount" id="itemCount" value="<%=i-1%>"/>
 

<div class="clear"></div>
<div class="clear"></div>

<div class="Block">
     <label>Status</label>
      <select  name="status" validate="Status,string,yes" onchange="vailidate(this)" ><option value="">Select</option>
	 <%for(MmMasRequestStatus stats :status){ %>
	 <option value="<%=stats.getStatusCode() %>"><%=stats.getStatusName() %></option>
	 <%} %>
	 </select>
     <label id="reason">Reason</label>
    <textarea rows="" cols="" id="remarks" name="remarks"></textarea>

    </div>

<input name="button"  type="button"	value="Submit" class="button"	onclick="submitForm('searchPanel','procurement?method=poApproval')"; />
<input name="button"  type="button"	value="Reset" class="button"	onclick=""; />

<%} %>

<div class="clear"></div>
<div id="pagination">
Page <span class="selected">1</span>
</div>

<script>
   function vailidate(id){
	   if(id.value!=""){
		   document.getElementById("reason").innerHTML="Reason";
		   document.getElementById("remarks").setAttribute("validate","Remark,string,no");
		   if(id.value=='RJ'){
			   document.getElementById("reason").innerHTML="Reason<span> *</span>";
			   document.getElementById("remarks").setAttribute("validate","Remark,string,yes");
		   }
	   }
   }
   </script>
   <script type="text/javascript" language="javascript"
						charset="utf-8">
				function toggl() {
					 var count=parseInt(document.getElementById("itemCount").value);
				        for(var i=1;i<=count;i++){
				        	if(document.getElementById('selectCheckBox1').checked)
				        		{
				        		 document.getElementById('itemCheckBox'+i).checked=true;
				        		}
				        	else
				        		{
				        		 document.getElementById('itemCheckBox'+i).checked=false;

				        		}
				        }				        }
				</script>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>