<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemBrandWindow.jsp  
 * Purpose of the JSP -  This is for Item Brand Window.
 * @author  Vivek
 * @author  Deepti
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.util.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>


<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script> 
<%
	Map map = new HashMap();
	List<StoreIssueT> storeIssueTList= new ArrayList<StoreIssueT>();
	
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}

	
	if(map.get("storeIssueTList")!=null)
	{
		storeIssueTList = (List) map.get("storeIssueTList");
	}
	%>


<script type="text/javascript">
	function cancelForm()
	{
  	 close();
   	}
	</script>




<div class="titleBg">
<h2>Issued Items List</h2>
</div>

<form name="itemBrandForm" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(storeIssueTList!=null && storeIssueTList.size()!=0)
	{
	%>
<h2>Issued Details</h2>
<div class="clear"></div>

Item: <%=storeIssueTList.get(0).getItem().getNomenclature()%> [ <%=storeIssueTList.get(0).getItem().getPvmsNo()%>
]
<div class="clear"></div>

<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th>Batch No</th>
			<th>A/U</th>

			<th>Exp Date</th>
			<th>Qty Issued</th>
			<th>Remarks</th>
		</tr>
	</thead>

	<tbody>
		<%
	try
	{
	  for (Iterator iterator = storeIssueTList.iterator(); iterator.hasNext();) 
	  {
	  StoreIssueT storeIssueT = (StoreIssueT) iterator.next();
	  %>
		<tr>
			<%-- <td width="5%">
  		<input type="text" name="<%=RequestConstants.BRAND_NAME %>"  readonly="readonly" value="<%=storeIssueT.getBrand().getBrandName() %>"/>
  	</td>--%>
			<td width="10%"><input type="text" readonly="readonly" size="10"
				value="<%=storeIssueT.getBatchNo() %>" /></td>
			<td width="13%"><input type="text"
				name="<%=RequestConstants.AU %>" size="8" readonly="readonly"
				value="<%=storeIssueT.getItem().getItemConversion().getPurchaseUnit().getUnitName()%>" />
			</td>

			<%
  	String expiryDate = "";
  	try
  	{
		SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		expiryDate=formatterOut.format(storeIssueT.getExpiryDate());
  	}
  	catch(Exception e)
  	{
  		expiryDate="";
  	}
  	%>
			<td width="13%"><input type="text" readonly="readonly"
				name="<%=RequestConstants.EXPIRY_DATE %>" value="<%=expiryDate%>" />
			</td>

			<td width="13%"><input type="text"
				name="<%=RequestConstants.QTY_ISSUED_TEMP%>"
				value="<%=storeIssueT.getQtyIssued()%>" readonly="readonly" /></td>

			<td width="13%"><input type="text"
				name="<%=RequestConstants.REMARKS_TEMP%>"
				value="<%=storeIssueT.getRemarks()==null?"":storeIssueT.getRemarks() %>"
				readonly="readonly" /></td>
			<tr />
			<%
  	 }
  	 }
  catch(Exception w)
  {
	  w.printStackTrace();
  }%>
		
	</tbody>
</table>
<div class="clear"></div>
<input type="button" name="close" id="addbutton" value="Close"
	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 /> <% } %>
</form>





