<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * message.jsp  
 * Purpose of the JSP -  This is for Message.
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-color.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-settings.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	Map<String,Object> map = new HashMap<String,Object>();
	String message="";
	String url="";
	String combinedIds = "";
	String nextCombinedIds = "";
	String forOutSideLab = "";
	int modalityId = 0;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		message=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	
	if(map.get("CombinedIds") != null){
		combinedIds = (String)map.get("CombinedIds");
	}
	
	if(map.get("nextCombinedIds") != null){
		nextCombinedIds = (String)map.get("nextCombinedIds");
	}
	
	if(map.get("forOutSideLab") != null){
		forOutSideLab = (String)map.get("forOutSideLab");
	}
	
	if(map.get("modalityId") != null){
		modalityId = (Integer)map.get("modalityId");
	}
	
%>
<script type="text/javascript">
function checkTargetForYesTemp(){
	var aTags = document.getElementsByTagName('input');
	for (i=0; i < aTags.length; i++) {
			aTags[i].setAttribute("target", "_blank");
		}
	return true;
}
</script>

<form name="message" method="post" target="_blank">
<div class="clear"></div>
<h4><span><%=message %></span></h4>

<div class="clear"></div>

<% if(!forOutSideLab.trim().equalsIgnoreCase("y")) {%>

<input type="hidden" name="combinedIds" id="combinedIds"
	value="<%=combinedIds%>" /> <input type="hidden"
	name="nextCombinedIds" id="nextCombinedIds"
	value="<%=nextCombinedIds%>" /> <input type="button" name="yes"
	value="yes" id="buttonTemplate" class="button"
	onclick="submitForm('message','/hms/hms/investigation?method=showPrintResultEntryForLab');" />
<input type="button" name="no" value="No" class="button"
	onClick="submitForm('message','<%=url%>','checkTargetForNo');" /> <input
	type="button" name="next" value="Next" class="button"
	onclick="submitForm('message','/hms/hms/investigation?method=nextForResultEntryLab','checkTargetForNo');" />
<input type="button" name="back" value="Back" class="button"
	onClick="submitForm('message','/hms/hms/investigation?method=showPendingResultEntryLabJsp','checkTargetForNo');" />
<!-- <input type="button" value="ResultValidation" class="cmnButton" onClick="submitFormForButton('message','/hms/hms/investigation?method=showPendingForResultValidationJsp','checkTargetForNo');" />  -->
<%} %>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
