<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PrqQuotationHeader"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

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
	List<PrqQuotationHeader> hdr=new ArrayList<PrqQuotationHeader>();
	List<MasEmployee> user=new ArrayList<MasEmployee>();
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
	if(map.get("prqHdr")!=null){
		hdr=(List<PrqQuotationHeader>)map.get("prqHdr");
	}
	if(map.get("users")!=null){
		user=(List<MasEmployee>)map.get("users");
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
	%>

<div class="titleBg">
<h2>Pending list for submitting quotation</h2>
</div>
<div class="Block">
<form name="searchPanel" method="post">
<label>From Date </label>
<input type="text" name="<%= FROM_DATE %>"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 id="fromDate" validate="From Date,date,no"/>
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.<%= FROM_DATE%>,event);" />
<label>To Date </label>
<input type="text" name="<%= TO_DATE %>" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 id="toDate" validate="To Date,date,no" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.<%= TO_DATE%>,true);" />

<label>Quotation No.</label>
<input type="text" name="quotationRequisitionNo" value=""	tabindex=1   id="quotationRequisitionNo" validate="Quotation No,alphanumeric,no"/>

<div class="clear"></div>

<label>Quotation By </label>

<select name="quotationRequisitionBy" validate="Quotation By,alphanumeric,no">
<option value="">Select</option>
<%for(MasEmployee emp:user){ %>
	 <option value="<%=emp.getId()%> "><%=emp.getEmployeeName()%></option>
	 <%} %>
</select>

<label>Approved By </label>

<select name="quotationRequisitionApprovedBy" validate="Approved By,alphanumeric,no">
<option value="">Select</option>
<%for(MasEmployee emp:user){ %>
	 <option value="<%=emp.getId()%>"><%=emp.getEmployeeName()%></option>
	 <%} %>
</select>
<div class="clear"></div>
<input name="button"  type="button"	value="Search" class="button"	onclick="if(checkData()){submitForm('searchPanel','procurement?method=showPendingListForSubmittingQuotationJsp')}" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<form name="itemGrid" method="post">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="Block">   
<table>
        <tr><th>S.No</th><th>Date</th><th>Quotation Requisation no.</th><th> Quotation Requisation By</th><th>Quotation Requisation Approved By</th></tr>
        <% int sn=1;
        for(PrqQuotationHeader mmServiceRequest:hdr){ %>
        
        <tr onclick="submitForm('pendingList<%=sn %>', 'procurement?method=showQuotationSubmissionJsp')" style="cursor: pointer;"><td><%=sn %>
        <form name="pendingList<%=sn %>" method="post">
        <input type="hidden" name="requitionId" value="<%=mmServiceRequest.getId()%>" />
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        
        </form>
        
        </td><td><%=HMSUtil.changeDateToddMMyyyy(mmServiceRequest.getQuotationDate()) %></td>
        <td><%=mmServiceRequest.getQuotationNo() %></td>
        <td><%= mmServiceRequest.getQuotationBy().getEmployee().getEmployeeName()%></td>
        <td><%= mmServiceRequest.getQuotationBy().getEmployee().getEmployeeName()%></td></tr>
        <% sn++;} %>
         
    </table>
    </div>

 