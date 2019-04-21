<%@page import="jkt.hms.masters.business.StoreInternalReturnM"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
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
	List<StoreInternalReturnM>returnMList = new ArrayList<StoreInternalReturnM>();
	if(map.get("returnMList") != null){
		returnMList = (List)map.get("returnMList");
	}
	
	%>

<div class="titleBg">
<h2>Pending List For Department Return Acknowledgement</h2>
</div>
<form name="pendingListForReturnAcknowledgement" method="post">
<div class="clear"></div>

<!-- thread search menu -->
	
<div class="cmntable">
<div id="pageNavPosition"></div>
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>Return No.</th>
			<th>Return Date</th>
			<th>From Department</th>
		
			
	
		</tr>
	<tbody id="tableData">
		<%
		int i = 1;
		if(returnMList.size()>0){ 
		for(StoreInternalReturnM storeInternalReturnM: returnMList){%>
		<tr onclick="submitForm('pendingListForReturnAcknowledgement','stores?method=showDepartemntReturnAcknowledgementJsp&storeInternalReturnMId=<%=storeInternalReturnM.getId()%>');">
			<td><%=i %></td>
			<td><%=storeInternalReturnM.getReturnNo() != null?storeInternalReturnM.getReturnNo():"" %></td>
			<td><%=storeInternalReturnM.getReturnDate() != null?HMSUtil.convertDateToStringWithoutTime(storeInternalReturnM.getReturnDate()):""%></td>
			<td><%=storeInternalReturnM.getFromDepartment()!= null?storeInternalReturnM.getFromDepartment().getDepartmentName():"" %></td>
			
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