<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForResult.jsp  
 * Purpose of the JSP -  This is for ResultEntry
 * @author  Abha

 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/opd.js" type="text/javascript"></script>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String url = "";
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
Map<String,Object> infoMap = new HashMap<String,Object>();
if(map.get("messageTOBeVisibleToTheUser") !=null){
	message=""+map.get("messageTOBeVisibleToTheUser");
}
if(map.get("url") != null){
url = (String)map.get("url");
}
%> <%
String resultType="";
String resultNo="";
	if(map.get("resultNo") != null){
		resultNo = (String)map.get("resultNo");
	}
	if(map.get("resultType") != null){
		resultType = (String)map.get("resultType");
	}
	int resultId=0;
	if(map.get("resultId")!= null){
		resultId= (Integer)map.get("resultId");
	}
%>
<form name="messageResult" method="post">
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%-- <%if(resultType.equalsIgnoreCase("t")) {%> <input type="button" name="yes"
	value="Print" class="button" onclick="printResult('<%=resultNo%>','<%=resultType %>');" />
<% }else{%> 
<input type="button" name="yes" value="Print" class="button" onclick="printResult('<%=resultNo%>','<%=resultType %>');"	/>
<%} %>  --%>
<input type="button" name="no" value="No" class="button"	onclick="submitForm('messageResult','/hms/hms/investigation?method=searchPatientForResultValidation','checkTargetForNo');" />
<input type="button" name="next" value="Next" class="button"	onclick="submitForm('messageResult','/hms/hms/investigation?method=nextForResultValidation&resultId=<%=resultId %>','checkTargetForNo');" />
<input type="button" value="View Result" class="buttonBig"	onclick="printResultView('<%=resultNo%>','<%=resultType %>');" target="_blank" accesskey="a" /> 
<%-- <input type="button" name="print" id="print" onclick="printResultView('<%=resultId%>');" target="_blank" value="VIEW" class="button" accesskey="a" />
      <input type="button" name="PrintReport" id="printOut" onclick="printResultView('<%=resultId%>');" target="_blank" value="PRINT" class="button" accesskey="a" /> --%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<%-- onclick="submitForm('messageResult','/hms/hms/investigation?method=showPrintResultValidation&resultNo=<%=resultNo %>&resultType=<%=resultType %>');"Print --%>
<script type="text/javascript" language="javascript">
	
	function printResult(orderNo,resultType){
	submitForm('messageResult','/hms/hms/investigation?method=showPrintResultValidation&resultNo='+orderNo+'&resultType='+resultType);	
	}
	
	function printResultView(orderNo,resultType){
	//submitForm('trackerForm','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo);
	openPopupForLabResultsNew(csrfTokenName+'='+csrfTokenValue,orderNo);
	}
	
	function openPopupForLabResultsNew(csrf, orderNo,resultType) {

		/* submitForm('opdMain','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo); */
		window
				.open(
						"/hms/hms/investigation?method=showPrintResultValidation&resultNo="
								+ orderNo + "&"+"resultType="+resultType+ "&"+ csrf + "&" + csrfTokenName + "="
								+ csrfTokenValue,
						"_blank",
						"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
	}
</script>