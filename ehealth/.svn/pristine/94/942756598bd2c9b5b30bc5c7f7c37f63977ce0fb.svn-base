<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import=" java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueT"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<%
	Map map = new HashMap();
 	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
 	}
	List<StoreItemBatchStock> stockList= new ArrayList<StoreItemBatchStock>();
	try {
			if(map.get("stockList")!=null)
			{
				stockList=(List)map.get("stockList");
 			}
 	} catch (Exception exp) {
			exp.printStackTrace();
	}
 	String rowVal="";
 	
 	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
 		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
 		if(map.get("rowVal")!=null){
 			rowVal=(String)map.get("rowVal");
 		}
 		int i=1;
    %>
 <div class="titleBg">
<h2>View Stock Details</h2>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>
<form name="modifyWardConsumption" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
		if(stockList != null)
		{
	%> 
	<table>
	<tr>
	<th>Sr.No.</th>
	<th>Item Name</th>
	<th>Batch No.</th>
	<th>Expiry Date</th>
	<th>Closing Stock</th>
	<th>Issue Quantity</th>
	</tr>
	<%
	for(StoreItemBatchStock stock:stockList){ %>
	<tr>
	<input type="hidden" name="stockId" id="stockId" value="<%=stock.getId() %>" />
	<input type="hidden" name="itemId" id="itemId" value="<%=stock.getItem().getId() %>" />
	<input type="hidden" name="batchId" id="batchId" value="<%=stock.getBatchNo() %>" />
	<input type="hidden" name="closingStock" value="<%=stock.getClosingStock() %>" />
	<td><%=i %></td>
	<td><%=stock.getItem().getNomenclature() %></td>
	<td><%=stock.getBatchNo() %></td>
	<td><%=stock.getExpiryDate() %></td>
	<td><%=stock.getClosingStock() %></td>
	<td><input type="text" name="qtyIssued" id="qtyIssued" value="" /></td>
	</tr>
	
	<%} %>
	
	</table>
	<%} %>
	<input type="button" class="button" value="Back" align="left"
	onClick="cancelForm();" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script> <script type="text/javascript">
	function cancelForm(){
		var qtyIssue=document.getElementById("qtyIssued").value;
		var batchNo=document.getElementById("batchId").value;
		var itemId=document.getElementById("itemId").value;
		var stockId=document.getElementById("stockId").value;
		//alert("qtyIssue--->"+qtyIssue);
		//alert("batchNo--->"+batchNo);
		//alert("itemId--->"+itemId);
		//alert("stockId--->"+stockId);
		 window.opener.document.getElementById('qtyIssued1').value=qtyIssue;
		 window.opener.document.getElementById('batchId').value=batchNo;
		 window.opener.document.getElementById('itemId').value=itemId;
		 window.opener.document.getElementById('stockId').value=stockId;
  	 close();
   	}


</script></form>

