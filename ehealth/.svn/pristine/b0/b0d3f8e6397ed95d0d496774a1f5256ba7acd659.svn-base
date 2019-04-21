<%@page import="jkt.hms.masters.business.StoreStockTakingM"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

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
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	List<StoreStockTakingM> stocktakingMList = new ArrayList<StoreStockTakingM>();
	if(map.get("stocktakingMList") != null){
		stocktakingMList = (List)map.get("stocktakingMList");
	}
	
	%>

<div class="titleBg">
<h2>Pending list Physical Inventory Approval</h2>
</div>
<div class="clear"></div>
<form name="pendingListPhysicalInventoryApproval" method="post">
	
<div class="cmntable">
<div id="pageNavPosition"></div>
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>Physical Date</th>
			<th>Department</th>
			
			
	
		</tr>
	<tbody id="tableData">
		<%
		int i = 1;
		if(stocktakingMList.size()>0){ 
		for(StoreStockTakingM stockTakingM: stocktakingMList){%>
		<tr onclick="submitForm('pendingListPhysicalInventoryApproval','procurement?method=showPhysicalInventoryApprovalJsp&stockTakingMId=<%=stockTakingM.getId()%>');">
			<td><%=i %></td>
			<td><%=stockTakingM.getPhysicalDate() != null?HMSUtil.convertDateTypeToStringWithoutTime(stockTakingM.getPhysicalDate()):""%></td>
			<td><%=stockTakingM.getDepartment()!= null?stockTakingM.getDepartment().getDepartmentName():"" %></td>
			</tr>
	</tbody>
	<%i++;}} %>
</table>
</div>
<div class="paddingTop15"></div>



<div class="clear"></div>

<script>
	var pager = new Pager('tableData',10);
	pager.init();
	pager.showPageNav('pager', 'pageNavPosition');
	pager.showPage(1);


</script>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>