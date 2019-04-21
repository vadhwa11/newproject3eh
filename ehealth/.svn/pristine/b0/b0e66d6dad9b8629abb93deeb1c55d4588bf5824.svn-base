<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * departmentIndentjsp
 * Purpose of the JSP -  This is for Department Indent.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 08th Feb, 2008
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>
<%@page import="jkt.hms.masters.business.StoreBroadcastStatus"%>
<%@page import="jkt.hms.masters.business.StoreBroadcastEnquiryM"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.ItemGroup"%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>

<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>


<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
		month1="0"+month1;
		}
		if(date1.length()<2){
		date1="0"+date1;
		}
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>'
	</script>


<%
	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<StoreBroadcastStatus>storeBroadCastList = new ArrayList<StoreBroadcastStatus>();
	
	if(map.get("hospitalList") != null){
		hospitalList = (List)map.get("hospitalList");
	}
	if(map.get("storeBroadCastList") != null){
		storeBroadCastList = (List)map.get("storeBroadCastList");
	}
	
%>
<form name="viewBroadCastDMO" method="post">
<div class="titleBg">
<h2>BroadCast DashBoard</h2>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>



<div class="clear"></div>

<div id="pageNavPosition"></div>
<table>
	<tr>
	
	<th>Institute Name</th>
	<th>Item</th>
	<th>Demanded Qty</th>
	<th>Spare Qty</th>
	<th>Status</th>
	
	</tr>
	<%
	int i = 1;	
	if(storeBroadCastList.size()>0){
			for(StoreBroadcastStatus storeBroadcastStatus :storeBroadCastList){
				if(storeBroadcastStatus.getInstituteStatus() != null && !storeBroadcastStatus.getInstituteStatus().equals("")){
	
	%>
	<tbody id="tableData">
	<tr>
	
	<td><%=storeBroadcastStatus.getInstitute()!= null?storeBroadcastStatus.getInstitute().getHospitalName():"" %></td>
	<td><%=storeBroadcastStatus.getEnquiryT().getItem().getNomenclature()!= null?storeBroadcastStatus.getEnquiryT().getItem().getNomenclature():"" %></td>
	<td><%=storeBroadcastStatus.getEnquiryT().getDemandedQtyExcessQty()!= null?storeBroadcastStatus.getEnquiryT().getDemandedQtyExcessQty().intValue():"" %></td>
	<td><%=storeBroadcastStatus.getSpareQty() != null?storeBroadcastStatus.getSpareQty().intValue():"" %></td>
	<td><%=storeBroadcastStatus.getInstituteStatus()!= null?storeBroadcastStatus.getInstituteStatus():"" %></td>
	
	</tr>
	
<% i++;}}}	%>
	</tbody>
</table>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>


<script type="text/javascript">
var pager = new Pager('tableData',5);
pager.init();
pager.showPageNav('pager', 'pageNavPosition');
pager.showPage(1);

function validateRows(){
	var count = document.getElementById('hdb').value;
	for(var i=1;i<count;i++){
		if(document.getElementById('srNo'+i).checked){
			return true;
		}

	}
	alert("Please select at least one row.");
	return false;
}

</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="button" name="Back" type="submit" value="Back"	onClick="submitForm('viewBroadCastDMO','stores?method=showBroadCastDashBoardForDMO');" class="button" />
		</form>


