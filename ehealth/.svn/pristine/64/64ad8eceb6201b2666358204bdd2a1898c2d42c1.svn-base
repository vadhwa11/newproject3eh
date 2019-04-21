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
<%@page import="jkt.hms.masters.business.StoreRefrigeratorAllocation"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
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


<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

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
	//List<StoreItemBatchStock> stockList = new ArrayList<StoreItemBatchStock>();
	List<StoreRefrigeratorAllocation> refrigeratorAllocationList = new ArrayList<StoreRefrigeratorAllocation>();
	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	/* if(map.get("stockList") != null){
		stockList = (List<StoreItemBatchStock>)map.get("stockList");
	} */
	
	 if(map.get("refrigeratorAllocationList") != null){
		 refrigeratorAllocationList = (List<StoreRefrigeratorAllocation>)map.get("refrigeratorAllocationList");
	 }
int itemId = 0;
String itemName = "";
String itemCode = "";
String au = "";
int rowVal = 0;
if(map.get("itemId") != null){
	itemId = (Integer)map.get("itemId");
}
if(map.get("itemName") != null){
	itemName = (String)map.get("itemName");
}
if(map.get("itemCode") != null){
	itemCode = (String)map.get("itemCode");
}
if(map.get("au") != null){
	au = (String)map.get("au");
}
if(map.get("rowVal") != null){
	rowVal = (Integer)map.get("rowVal");
}

	
%>
<form name="instituteWiseIndentPopup" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Item Details</h2>
</div>



<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<table border="0" cellpadding="0" cellspacing="0">
	
					<tr>
					<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<!-- <th>Batch No.</th> -->
						<th>Qty</th>
						
					</tr>
				<%if(refrigeratorAllocationList.size()>0){
					for(StoreRefrigeratorAllocation refrigeratorAllocation : refrigeratorAllocationList){
					%>
					
					<tr>
						<td><%=refrigeratorAllocation.getItem()!= null?refrigeratorAllocation.getItem().getPvmsNo():"" %></td>	
						<td><%=refrigeratorAllocation.getItem()!= null?refrigeratorAllocation.getItem().getNomenclature():"" %></td>
						<td><%=refrigeratorAllocation.getItem()!= null && refrigeratorAllocation.getItem().getItemConversion() != null?refrigeratorAllocation.getItem().getItemConversion().getItemUnitName():"" %></td>	
						<%-- <td><%=refrigeratorAllocation.getBatchNo()!= null?itemBatchStock.getBatchNo():"" %></td>	 --%>
						<td><%=refrigeratorAllocation.getStoredQty()!= null?refrigeratorAllocation.getStoredQty().intValue():"" %></td>	
						
					</tr>
				<%}} %>
			</table>
	
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>




