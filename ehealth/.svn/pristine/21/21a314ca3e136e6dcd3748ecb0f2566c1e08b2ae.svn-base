<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ADT_ICD_Search.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 04.08.2008    Name: Othivadivel K R
	 * Revision Date:      Revision By:
	 * @version 1.0
	 * @see
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasIcd"%>

<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet">
</script>
<script type="text/javascript">
var csrfTokenName='${_csrf.parameterName}';
var csrfTokenValue='${_csrf.token}';
</script>
<head>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"
	id="vbulletin_css" />
	<script lang="javascript" src="/hms/jsp/js/csrfToken.js" type="text/javascript"></script>
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>	
 <link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
  <script src="/hms/jsp/js/jquery-1.10.2.js"></script>
  <script src="/hms/jsp/js/jquery-ui.js"></script>
  <script src="/hms/jsp/js/canvasjs.min.js"></script>
  <script>jQuery.noConflict();</script>
<SCRIPT LANGUAGE="JavaScript">

	function jsSelData(hinNo) {

		opener.jsSetIcdData(hinNo);
		self.close();
	}
	function jsSetIcdDataOnExam(hinNo) {

		opener.jsSetIcdData(hinNo);
		self.close();
	}

	function sub(opt)
	{
	var tmp=ICDSearchForm.icd_name.value
	if (ICDSearchForm.icd_name.value=="")
    {
    	alert("Pls. Check your Input..... ");
    	return;
    }else if(tmp.length <2){
     alert("Length should be more than 3 Characters");
    	return;
     }
    else
	{
		submitForm('ICDSearchForm','adt?method=showICDSearchJsp');
	}
	}


</SCRIPT>

<title>ICD Search</title>

<style type="text/css">
<!--
.schInput {
	BACKGROUND-COLOR: #ffffff;
	BORDER-BOTTOM: #bfbfbf 1px solid;
	BORDER-LEFT: #bfbfbf 1px solid;
	BORDER-RIGHT: #bfbfbf 1px solid;
	BORDER-TOP: #bfbfbf 1px solid;
	COLOR: #4a4a4a;
	FONT-FAMILY: Arial;
	FONT-SIZE: 11px;
	height: 15px;
}

#linetblhdr {
	BACKGROUND-COLOR: #EBE7E7;
	BORDER-BOTTOM: #d1bfe8 1px solid;
	BORDER-LEFT: #d1bfe8 1px solid;
	BORDER-RIGHT: #d1bfe8 1px solid;
	BORDER-TOP: #d1bfe8 1px solid;
	COLOR: #000000;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	font-weight: 400;
	MARGIN: 1px;
	vertical-align: middle;
	cursor: hand
}

#sel {
	BACKGROUND-COLOR: #CAE7EF;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	cursor: hand
}
-->
</style>

</head>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<Object[]> masIcdList = new ArrayList<Object[]>();
	MasIcd masIcd = new MasIcd();

	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");

		if (map.get("masIcdList")!=null)
			masIcdList = (List<Object[]>)map.get("masIcdList");
	}

%>



<div id="mainIn">
<form name="ICDSearchForm" action="" method="post">
<div class="titleBg">
<h2>ICD Search</h2>
</div>
<div class="clear"></div>
<div class="Block">
	<label>Search By </label>
	<label class="autoSpace"><input type="radio" class="radioCheckCol2" name="icdredio" id="icdredioCode" value="Code"/>Code</label>
	<label class="autoSpace"><input type="radio" class="radioCheckCol2" name="icdredio" id="icdredioName" value="Name"/>Name</label>
	<div class="clear"></div>
	<label id="searchLabel">ICD Name</label>
	<input type="text" name="icd_name" value="<%=box.get("icd_name")%>" />
	<input	type="submit" name="Submit" id="searchButton" value="Search" class="button" accesskey="a" />
	<input type="hidden" name="searchopt" id="searchopt" value="1"/>
	
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<!-- <div >
<img id="progessBar" width="80" height="80" src="/hms/jsp/images/progressbar.gif">
</div> -->


<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<th>ICD Code</th>
		<th>ICD Name</th>
		<th>Snomed Id</th>
		<th>Snomed Name</th>
	</tr>
	<%if(masIcdList.size()>0) { %>
	<% for(Object[] icd : masIcdList)
	{
		
	%>
	<tr id="linetblhdr" onmouseover="this.id='sel'"
		onmouseout="this.id='linetblhdr'"
		onclick="javascript:callParentFunction('<%=icd[1]%>[<%=icd[0]%>@@@<%=icd[2]%>]'); setSnomedName('<%=icd[3]%>') ">
		<td><%=icd[0]%></td>
		<td><%=icd[1].toString().toUpperCase()%></td>
		<td><%=icd[2]%></td>
		<td>
		<%if(icd[3]!=null){ %>
		<%=icd[3].toString().toUpperCase()%></td>
		<%}else{ %>
		--
		<%} %>
	</tr>
	<%
	}
	%>
	<% }
	else
	{
	%>
	<tr>
		<td>No Data Found</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<% } %>
</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>

<%
masIcdList.clear();
%>

<script type="text/javascript">
jQuery(function ($) {
	 $("#icdredioCode").change(function(){
		 $("#searchLabel").html("ICD Code");
		 $("#searchopt").val("2");
		 opt=2;
	 });
	$("#icdredioName").change(function(){
		$("#searchLabel").html("ICD Name");
		 $("#searchopt").val("1");
	 });
	$("#searchButton").click(function(){
		sub();
	 });
});

function callParentFunction(val)
{
	
	window.self.close();
	window.opener.setIcdCodeAndNameFromChildWindow(val);
	
}

function setSnomedName(val1)
{
	window.opener.document.getElementById("snomed").value=val1;
}
</script>