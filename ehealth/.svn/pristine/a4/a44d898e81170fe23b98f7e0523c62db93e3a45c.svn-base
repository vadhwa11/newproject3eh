<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * poMain.jsp
 * Purpose of the JSP -  This is for PO Main form .
 * @author  Deepti Tevatia
 * Create Date: 12th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
function search(){
	var rowV=document.getElementById("rowVal").value;
	for(var i=0;i<rowV;i++){
		if(document.getElementById("radio"+i)!=null){
	if(document.getElementById("radio"+i).checked==true){
	var parent=document.getElementById("radio"+i).value;
		submitForm('poMain','purchaseOrder?method=poModifyJsp&parent='+parent);
		}
		}
		}
		}
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");

	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
	List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
	includedJsp = (String) map.get("includedJsp");
	List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();
	if (map.get("poNumberList") != null) {
		poNumberList = (List<StorePoHeader>)map.get("poNumberList");
	}
	try {
		supplierList = (List<MasStoreSupplier>) map.get("supplierList");
		poDetailList = (List<StorePoDetail>) map.get("poDetailList");
		poHeaderList = (List<StorePoHeader>) map.get("poHeaderList");
	} catch (Exception exp) {
		exp.printStackTrace();
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>


<form name="poMain" method="post">
<div class="clear"></div>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<!-- <input type="button" name="Modify" value="Modify" class="button"  onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');" /> -->
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form action="" method="post">
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" />
<input type="hidden" name="searchthread" value="1" />
<input type="hidden" name="showposts" value="1" />
<input	type="hidden" name="searchthreadid" value="85875" />
<div class="paddingTop15"></div>
<div class="clear"></div>
<label>From Date </label> <input type="text" name="<%= FROM_DATE %>"
	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.poMain.<%= FROM_DATE%>,event);" />
<label>To Date </label> <input type="text" name="<%= TO_DATE %>"
	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.poMain.<%= TO_DATE%>,event);" />


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<label>P.O.No :</label> <select name="<%=PO_ID%>">
	<option value="0">Select</option>
	<%
	for(StorePoHeader obj: poNumberList){
		%>
<option value="<%=obj.getId() %>"><%=obj.getPoNumber() %></option>
	<%} %>
</select> <%--
<label>Supplier Name :</label>
<select	name="<%= SUPPLIER_ID %>" id="supplierId" validate="Vendor Name,String,no">
<option value="0">--Select--</option>
<%
			for (MasStoreSupplier masStoreSupplier :supplierList ) {
%>
<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
<%
			}
%>
</select>
--%>
<input type="image" class="button" onClick="submitForm('poMain','purchaseOrder?method=searchPO');" />	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" /> <%
 	if (includedJsp != null) {
 %>
<div class="clear"></div>
<jsp:include page="poDetail.jsp" /> <%
 	}
 %> <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Modify" class="button" value="Modify"	onClick="search();" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
