<%@page import="jkt.hms.masters.business.MmInspectionReport"%>
<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="jkt.hms.masters.business.PrqQuotationVendorDetails"%>
<%@page import="jkt.hms.masters.business.PrqQuotationHeader"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
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
    	 window.location.href='procurement?method=showPendingTechnicalApprovalJsp&fromDate='+document.getElementById("fromDate").value+'&toDate='+document.getElementById("toDate").value;
         return true;
     }else{alert("Date is Incorrect.");return false;}
}
</script>
<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MmServiceRequest> mmServiceRequests=new ArrayList<MmServiceRequest>();
	List<PrqQuotationHeader> hdr=new ArrayList<PrqQuotationHeader>();
	List<MmMasRequestStatus> stats=new ArrayList<MmMasRequestStatus>();
	List<PrqQuotationVendorDetails> vendor=new ArrayList<PrqQuotationVendorDetails>();
	List<MmInspectionReport> inspectionReports=new ArrayList<MmInspectionReport>();
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
	if(map.get("mmServiceRequests")!=null){
		mmServiceRequests=(List<MmServiceRequest>)map.get("mmServiceRequests");
	}
	
	if(map.get("hdPrqQuotationHeaders")!=null)
	{
		hdr=(List<PrqQuotationHeader>)map.get("hdPrqQuotationHeaders");
	}
	if(map.get("vendorDetails")!=null)
	{
		vendor=(List<PrqQuotationVendorDetails>)map.get("vendorDetails");
	}
	if(map.get("inspectionReports")!=null)
	{
		inspectionReports=(List<MmInspectionReport>)map.get("inspectionReports");
	}
	  System.out.println("vendorList==="+inspectionReports.size());
	%>

<div class="titleBg">
<h2>Pending List For Technical Approval</h2>
</div>
<div class="Block">
<form name="searchPanel" method="post">
<label>From Date </label>
<input type="text" name="<%= FROM_DATE %>" readonly="readonly"	value="<%= currentDate %>"  class="date" maxlength="30" tabindex=1 id="fromDate"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.<%= FROM_DATE%>,event);" />
<label>To Date </label>
<input type="text" name="<%= TO_DATE %>" readonly="readonly" value="<%= currentDate %>" class="date" onblur="return checkData()" maxlength="30" tabindex=1 id="toDate" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.<%= TO_DATE%>,true);" />

<label>Quotation/Request No. </label>
<select name="quotationNo" validate="Quotation No,string,yes"	tabindex=1   id="quotationNo" >
<option value=""> Select</option>
 <%for(PrqQuotationHeader prqHdr1:hdr){
    	
    	String prqQuotation="";
					if(prqHdr1.getQuotationNo()!=null)
						prqQuotation=prqHdr1.getQuotationNo();
					%>
	 <option value="<%=prqHdr1.getId()%>@Q"><%=prqQuotation%></option>
	 <%} %>
	 
	 <% for(MmInspectionReport spm:inspectionReports)
	 {
		%> 
		<option value="<%=spm.getRequest().getId()%>@R"><%=spm.getRequest().getServiceRequestNo()%></option>
		<%
	 }
	 
	 %>
</select>
<div class="clear"></div>

<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('searchPanel','procurement?method=showPendingTechnicalApprovalJsp')" />
<!-- <input name="button"  type="button"	value="CreatePODirectPurchase" class="buttonBig2""	onclick=""; /> -->



	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
<div class="clear"></div>
<div class="paddingTop5"></div>	
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" cellpadding="0" cellspacing="0">
	<%int sn=1;
	if(hdr.size()>0 || inspectionReports.size()>0)
	{ %><thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Quotation\Request Date </th>
			<th width="10%">Quotation\Request No.</th>
			<th width="10%">Requested By</th>
			</tr>
			</thead>
			<tbody>
			<% 
			
           for(PrqQuotationHeader prqHdr1:hdr){ %>
         <form name="popendingList<%=sn %>" method="post">
         <input type="hidden" name="quotationRequisitionNo" value="<%=prqHdr1.getId()%>@Q" />
         <input type="hidden" name="flag" value="<%= prqHdr1.getQuotationNo()%>"/>
        <tr onclick="submitForm('popendingList<%=sn%>', 'procurement?method=showTechnicalApprovalJsp')" style="cursor: pointer;">
        <td><%=sn %>
        </td><td><%=HMSUtil.changeDateToddMMyyyy(prqHdr1.getQuotationDate())%></td>
        <td><%= prqHdr1.getQuotationNo()%></td>
        <td><%=prqHdr1.getQuotationBy().getEmployee().getEmployeeName()%></td> 
       </tr>
       
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       
       </form>
        <% sn++;} %>
	   </tbody>
	  <%} //else if(inspectionReports.size()>0){ %>
<!-- 	<thead> -->
<!-- 		<tr> -->
<!-- 			<th width="13%">Sl No.</th> -->
<!-- 			<th width="10%">Request Date</th> -->
<!-- 			<th width="10%">Request No.</th> -->
<!-- 			<th width="10%">vendor Name</th> -->
<!-- 			</tr> -->
<!-- 	</thead> -->
	<tbody>
	<%for(MmInspectionReport spm:inspectionReports) {%>
	    
		 <form name="popendingList1<%=sn %>" method="post">
		  <input type="hidden" name="quotationRequisitionNo" value="<%=spm.getRequest().getId() %>@R" />
		     <input type="hidden" name="flag" value="<%= spm.getRequest().getServiceRequestNo()%>"/>
		    <tr onclick="submitForm('popendingList1<%=sn%>', 'procurement?method=showTechnicalApprovalJsp')" style="cursor: pointer;">
			<td><%= sn%></td>
			<td><%= HMSUtil.changeDateToddMMyyyy(spm.getRequest().getRequestDate())%></td>
			<td><%= spm.getRequest().getServiceRequestNo()%></td>
			<td><%= spm.getLastChgBy().getEmployee().getEmployeeName()%></td>
		</tr>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		
		</form>
	
	<%sn++;}//}%>
	</tbody>
	  <%-- <%else{ %>
	No Records Available.
	<%} %> --%>
</table>
   </div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<div id="pagination">Page <span class="selected">1</span></div>

