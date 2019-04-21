<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp  
 * Purpose of the JSP -  This is for ADT Message.
 * @author  Ritu
 * Create Date: 14th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String backUrl = "";
int inpatientId = 0;
int hinId=0;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}


if(map.get("hinId") != null){
	hinId = Integer.parseInt(""+map.get("hinId"));
}
%>
<div class="titleBg">
<h2>Expiry Certificate</h2>
</div>
<form name="messageExpiry" method="post">
<div class="Block">
<div class="clear"></div>
<label>UHID<span>*</span></label>
<input type="text" name="UHID" value="" maxlength="25" validate="UHID,string,yes"/>
<%-- <input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageExpiry','/hms/hms/adt?method=printExpiryDetails&inpatientId='+<%=inpatientId%>);" /> --%>
	<input type="button" name="Search" value="Search" class="button"
	onclick="submitForm('messageExpiry','/hms/hms/opd?method=showPatientExpieryCerificate');" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


