<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : searchPatientForFinalSettlement.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 23.06.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<form name="patientSettlementSearch" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<%
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
	%>


<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 26 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<div class="titleBg">
<h2>Search Patient</h2>
</div>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text" name="<%=HIN_NO %>" value=""
	id="hinNoId" MAXLENGTH="50"
	onblur="if(checkHin()){submitProtoAjax('patientSettlementSearch','billing?method=getAdNo&flag=finalSettlement');}" />

<div id="testDiv"><label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <input type="text"
	name="<%=AD_NO %>" id="adNoId" value="" MAXLENGTH="15"
	onblur="submitProtoAjaxWithDivName('patientSettlementSearch','billing?method=getFinalBillNo','billNoDiv')" />
</div>
<div id="billNoDiv"><label><%=prop.getProperty("com.jkt.hms.opd.final_bill_no") %>.</label> <input
	type="text" id="finalBillId" name="finalBillNo" value=""
	onblur="if(this.value != ''){submitForm('patientSettlementSearch','billing?method=getBillingDetailsForSettlement');}"
	MAXLENGTH="15" /></div>
<div class="clear"></div>

<input type="button" name="search" onclick="submitForm('patientSettlementSearch','billing?method=getBillingDetailsForSettlement','checkAdNoFinalBillNo');"  value="Search" class="button" accesskey="a" />

<div class="clear"></div>
</div>
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>

<script type="text/javascript">
	function checkAdNoFinalBillNo(){
		if(document.getElementById('adNoId').value == "" && document.getElementById('finalBillId').value == ""){
			alert("Please enter IP No or Final Bill No.");
			return false;
		
		}
	return true;
	}
document.getElementById('hinNoId').focus();
</script> 


 </form>
