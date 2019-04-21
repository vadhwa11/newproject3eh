<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hrInsuranceDetails.jsp  
 * Purpose of the JSP -  This is for Insurance Master details 
 * @author  Mansi
 * Create Date: 18th Dec,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>


<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hrms.masters.business.HrMasInsurance"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%-- <%@page import="jkt.hrms.masters.business.HrInsuranceDetails"%>
 --%><script type="text/javascript" language="javascript" src="/erp/jsp/js/common.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.datePicker.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script language="javascript">

var $j = jQuery.noConflict();
</script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	int rowNum=0;
	if(map.get("rowNum")!=null){
		rowNum=(Integer)map.get("rowNum");
	}

%>

<label>Transaction Date</label>
<input type="text" class="date" name="transactionDate" id="transactionDateId<%=rowNum %>" value="<%=date %>" />
<label>Transaction Amount</label>
<input type="text"  name="transactionAmount" id="transactionAmountId<%=rowNum %>" value="" />
<label>Narration</label>
<input type="text"  name="Narration" id="narrationId<%=rowNum %>" value="" />
<label>Transaction Type</label>
<select name="transactionType" id="transactionTypeId<%=rowNum %>" value="">
<option value="DR"> DR</option>
<option value="CR"> CR</option>
</select>
<div class="clear"></div>
<input type="button" value="close" onclick="setvalueToParent(<%=rowNum %>);window.close();" />

<script>
function setvalueToParent(rowNum){
	alert("in method");
	window.opener.document.getElementById('transactionDateId'+rowNum).value=document.getElementById('transactionDateId'+rowNum).value;
	window.opener.document.getElementById('transactionAmountId'+rowNum).value=document.getElementById('transactionAmountId'+rowNum).value;
	window.opener.document.getElementById('narrationId'+rowNum).value=document.getElementById('narrationId'+rowNum).value;

	window.opener.document.getElementById('transactionType'+rowNum).value=document.getElementById('transactionType'+rowNum).value;

}
</script>