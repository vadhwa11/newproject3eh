
<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* registration.jsp
* Purpose of the JSP -  This is for Registration.
* @author  Rajesh
* Create Date: 14th Nov,2008
* Revision Date:
* Revision By:
* @version 1
--%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>

<h2>Search</h2>
<div class="clear"></div>

<form  method="post" name="labMachineBarCode">
<div class="Block">
<div class="clear"></div>
<label>UHID</label>
<input type="text" name="<%=HIN_NO %>" id="<%=HIN_ID %>" onblur="submitProtoAjaxWithDivName('labMachineBarCode','lab?method=getOrderListForPatient','ordetrDiv')" />
<div id="ordetrDiv"></div>
	<div id="sampleDiv"></div>
</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>
function generatePrin(a,b,c){
	submitForm('labMachineBarCode','lab?method=generateReportForLabMachineBarcode&diag_no='+a+'&inv_id='+b+'&order_id'+c+'');	
	
}
</script>