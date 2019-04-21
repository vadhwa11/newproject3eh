<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * billingPackageList.jsp  
 * Purpose of the JSP -  This is for Package master list
 * @author  Ritu
 * Create Date: 15 July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.BlPackageHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<SCRIPT SRC="/hms/jsp/js/ssm.js" language="JavaScript1.2">
	
	//Dynamic-FX slide in menu v6.5 (By maXimus, http://maximus.ravecore.com/)
	//Updated July 8th, 03' for doctype bug
	//For full source, and 100's more DHTML scripts, visit http://www.dynamicdrive.com
	
	</SCRIPT>


<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%
	Map map = new HashMap();
	List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("packageList") != null){
		packageList = (List<BlPackageHeader>)map.get("packageList");
	}
	request.setAttribute("packageList",packageList);
	%>

<div class="titleBg">
<h2>Billing Package</h2>
</div>
<div class="clear"></div>
<%
	if(map.get("message") != null){
	String message = (String)map.get("message");
	%>
<h4><span><%=message %></span></h4>
<% 
	}
	%>
<div class="clear"></div>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>

<div class="clear"></div>
<form name="packageList" method="post" action=""><input
	type="hidden" id="frozenId" name="frozen" value="" /> <input
	type="hidden" id="pkgCodeId" name="<%=PACKAGE_CODE %>" value="" /> <input
	type="hidden" id="pkgDescId" name="<%= PACKAGE_DESCRIPTION%>" value="" />
<div class="clear"></div>
<div class="leftMenu">Billing Package
<div class="clear"></div>
<input type="button" class="button" value="Create Package"
	onclick="submitForm('packageList','packageBilling?method=showPackageMasterJsp');" />
<input type="button" class="button" value="Update Package"
	onclick="submitForm('packageList','packageBilling?method=showUpdatePackageMasterJsp','validateRadioForPackage','checkPkgStatus');" />
<input type="button" class="button" value="Add Services"
	onclick="submitForm('packageList','packageBilling?method=showPackageServicesJsp','validateRadioForPackage','checkPkgStatus');" />
<input type="button" class="button" value="Add Medicines"
	onclick="submitForm('packageList','packageBilling?method=showPackageMedicinesJsp','validateRadioForPackage','checkPkgStatus');" />
<div class="clear"></div>
</div>

<div class="floatRight1">
<div class="clear"></div>
<div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2 class="smallCmntable"></div>

<script type="text/javascript" language="javascript">
	
	formFields = [
	[0, "<%=PACKAGE_ID%>", "id"],[1, "<%=RADIO_FOR_TABLE%>"],[2, "<%=PACKAGE_CODE %>"], [3,"<%= PACKAGE_DESCRIPTION%>"], [4,"<%= DEPARTMENT_ID%>"], [5,"<%=  EFFECTIVE_DATE_FROM%>"],[6,"<%= EFFECTIVE_DATE_TO%>"],[7,"<%=TOTAL_PACKAGE_VALUE%>"],[8,"frozen"],[9,"days"],[10,"icdname"],[11,"rate"]];
	
	</script></div>
<div id="edited"></div>
<div id="statusMessage">
<h4></h4>
</div>
</div>
</div>

<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "radio";
	data_header[0][2] = "5%";
	data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Package Code"
	data_header[1][1] = "data";
	data_header[1][2] = "8%";
	data_header[1][3] = "<%= PACKAGE_CODE%>"
	
	data_header[2] = new Array;
	data_header[2][0] = "Package Description"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";
	data_header[2][3] = "<%= PACKAGE_DESCRIPTION%>";
	
	data_header[3] = new Array;
	data_header[3][0] = "Department"
	data_header[3][1] = "hide";
	data_header[3][2] = "5%";
	data_header[3][3] = "<%=DEPARTMENT_ID %>";
	
	data_header[4] = new Array;
	data_header[4][0] = "Effective From Date"
	data_header[4][1] = "hide";
	data_header[4][2] = "6%";
	data_header[4][3] = "<%=EFFECTIVE_DATE_FROM %>";
	
	
	
	data_header[5] = new Array;
	data_header[5][0] = "Effective To Date"
	data_header[5][1] = "hide";
	data_header[5][2] = "6%";
	data_header[5][3] = "<%=EFFECTIVE_DATE_TO %>";
	
	data_header[6] = new Array;
	data_header[6][0] = "Package Value"
	data_header[6][1] = "hide";
	data_header[6][2] = "10%";
	data_header[6][3] = "<%=TOTAL_PACKAGE_VALUE %>";
	

	data_header[7] = new Array;
	data_header[7][0] = ""
	data_header[7][1] = "hide";
	data_header[7][2] = "10%";
	data_header[7][3] = "frozen";
	
	data_header[8] = new Array;
	data_header[8][0] = "Days"
	data_header[8][1] = "data";
	data_header[8][2] = "10%";
	data_header[8][3] = "days";
	data_header[9] = new Array;
	data_header[9][0] = "Icd Name"
	data_header[9][1] = "data";
	data_header[9][2] = "10%";
	data_header[9][3] = "icdname";
	data_header[10] = new Array;
	data_header[10][0] = "Rate"
	data_header[10][1] = "data";
	data_header[10][2] = "10%";
	data_header[10][3] = "rate";
	

	data_arr = new Array();
	
	<%
		int i=0;
		for(BlPackageHeader packageHeader : packageList){
	
	%>
	data_arr[<%= i%>] = new Array();
	
	data_arr[<%= i%>][0] =<%=packageHeader.getId()%>
	
	data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= packageHeader.getId()%>" id="parent" />'
	
	data_arr[<%= i%>][2] ='<%=packageHeader.getPackageCode()%>'
		<%
		if(packageHeader.getPackageDesc() != null){
	%>
	
	data_arr[<%= i%>][3] ='<%=packageHeader.getPackageDesc()%>'
		<%}%>
		<%
		if(packageHeader.getDepartment() != null){
	%>
	data_arr[<%= i%>][4] ='<%=packageHeader.getDepartment().getDepartmentName()%>'
		<%}%>
		<%
		if(packageHeader.getEffectiveFromDate() != null){
	%>
	
	data_arr[<%= i%>][5] ='<%=HMSUtil.convertDateToStringWithoutTime(packageHeader.getEffectiveFromDate())%>'
		<%}%>
	<%
		if(packageHeader.getEffectiveToDate() != null){
	%>
		data_arr[<%= i%>][6] ='<%=HMSUtil.convertDateToStringWithoutTime(packageHeader.getEffectiveToDate())%>'
	<%}%>
	<%
		if(packageHeader.getDiscountedValueOfPackage() != null){
	%>
		data_arr[<%= i%>][7] =<%=packageHeader.getDiscountedValueOfPackage()%>
	<%}else{%>
		data_arr[<%= i%>][7] = "";
	<%}%>
	
	<%
		if(packageHeader.getFrozen() != null){
	%>
		
 	data_arr[<%= i%>][8] = '<%=packageHeader.getFrozen()%>';
 	<%}else{
 	%>
 	data_arr[<%= i%>][8] = "";
 	<%}%>
<%--	data_arr[<%= i%>][9] = ''
--%>	
<%
if(packageHeader.getDays()!= null){
%>
data_arr[<%= i%>][9] =<%=packageHeader.getDays()%>
<%}else{%>
data_arr[<%= i%>][9] = "-";
<%}%>
<%
if(packageHeader.getIcdName()!=null){
%>
data_arr[<%= i%>][10] ='<%=packageHeader.getIcdName()%>';
<%}else{%>
data_arr[<%= i%>][10] = "-";
<%}%>
<%
if(packageHeader.getTotalValueOfPackage()!= null){
%>
data_arr[<%= i%>][11] =<%=packageHeader.getTotalValueOfPackage()%>;
<%}else{%>
data_arr[<%= i%>][11] = "-";
<%}%>
    <%
	i++;
		}%>
	
	
	formName = "packageList"
	
	
	start = 0
	if(data_arr.length < rowsPerPage)
	end = data_arr.length;
	else
	end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script> <script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div id="testDiv"></div>

<script type="text/javascript">
		function checkPkgStatus(){
			var status = document.getElementById('frozenId').value;
			if(status == 'y'){
				alert("This Package has been Frozen, further modification are not allowed. ")
				return false;
			}else {
				return true;
			}
		}
	
	</script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
