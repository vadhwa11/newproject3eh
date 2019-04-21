<%@page import="jkt.hms.masters.business.StorePoHeader"%>
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

	function checkData(){
    var start= new Date(document.getElementById("fromDate").value.split("/")[2], document.getElementById("fromDate").value.split("/")[1], document.getElementById("fromDate").value.split("/")[0]);
     var end= new Date(document.getElementById("toDate").value.split("/")[2], document.getElementById("toDate").value.split("/")[1], document.getElementById("toDate").value.split("/")[0]);
     if(start<=end){
         return true;
     }else{alert("Date is Incorrect.");return false;}
}
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<StorePoHeader> headers=new ArrayList<StorePoHeader>();
	List<StorePoHeader> header=new ArrayList<StorePoHeader>();
	
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
	if(map.get("header")!=null)
	{
		header=(List<StorePoHeader>)map.get("header");
	}
	if(map.get("vendorlist")!=null)
	{
		headers=(List<StorePoHeader>)map.get("vendorlist");
	}
	System.out.println("===="+headers.size());
	%>

<div class="titleBg">
<h2>Pending For PO Approval</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->
<div class="Block">
<form name="searchPanel" method="post">
<div class="clear"></div>
<label>From Date </label>
<input type="text" name="<%= FROM_DATE %>"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 id="fromDate"/>
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.<%= FROM_DATE%>,event);" />
<label>To Date </label>
<input type="text" name="<%= TO_DATE %>" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 id="toDate" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.<%= TO_DATE%>,true);" />

<label>Vendor Name </label>
<select name="vendorName" value=""	tabindex=1   id="vendorName" validate="VendorName,String,yes">
<option value=""> Select</option>
<%

List<Integer> itemList=new ArrayList<Integer>(); 
	for(StorePoHeader prqHdr1:header){
		  if(!itemList.contains(prqHdr1.getSupplier().getId()))
		{
			itemList.add(prqHdr1.getSupplier().getId());
			String supName="";
	if(prqHdr1.getSupplier()!=null && prqHdr1.getSupplier().getSupplierName()!=null){
		supName=prqHdr1.getSupplier().getSupplierName();
	}%>
	 <option value="<%=prqHdr1.getSupplier().getId()%>"><%=supName%></option>
	 <%} }%>
</select>
<div class="clear"></div>
<label>PO No. </label>
<input type="text" name="poNo" value=""	tabindex=1   id="poNo" />
<div class="clear"></div>
<input name="button"  type="button"	value="Search" class="button"	onclick="if(checkData()){submitForm('searchPanel','procurement?method=showPendingForPOApprovalJsp')}";; />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<div class="clear"></div>
<h4>Item Details</h4>	
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
		<th>Sl No.</th>
		<th>Date</th>
		<th>PO No.</th>
	    <th>Vendor Name</th>
			
		</tr>
	</thead>
	<tbody>
		<% 
			int sn=1;
		    if(headers.size()>0){
           for(StorePoHeader vendorDetails:headers){
        	   String supName="";
        		if(vendorDetails.getSupplier()!=null && vendorDetails.getSupplier().getSupplierName()!=null){
        			supName=vendorDetails.getSupplier().getSupplierName();} %>
         <form name="vendorList<%=sn%>" method="post">
         	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
         <input type="hidden" name="requitionId" value="<%=vendorDetails.getId()%>" />
        <tr onclick="submitForm('vendorList<%=sn%>', 'procurement?method=showPOApprovalJsp')" style="cursor: pointer;">
        <td><%=sn %></td>
        <td><%=HMSUtil.changeDateToddMMyyyy(vendorDetails.getPoDate())%></td>
        <td><%= vendorDetails.getPoNumber()%></td>
        <td><%=supName%></td> 
      </tr>
       
       </form>
        <% sn++;}}%>
	</tbody>
</table>
</div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div id="pagination">
Page <span class="selected">1</span>
</div>

