<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.util.RequestConstants"%><script type="text/javascript" src="/hms/jsp/js/common.js"></script>
 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	String balanceNo="";
	String balanceNoForPrint="";
	String adjustmentNo="";
	String poNumber="";
	Box box=null;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	
	if (map.get("box") != null) {
		box = (Box) map.get("box");
	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		messageTOBeVisibleToTheUser=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("messageType") !=null){
		messageType=""+map.get("messageType");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	
	request.setAttribute("box",box);
%>


<form name="message" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<%
if(balanceNo!=""){
	balanceNo=" And Balance No.  "+balanceNo;
}
if(!messageTOBeVisibleToTheUser.equals(""))
	{
	if(messageType.equals("success")){
	%>
<h4><span><%=messageTOBeVisibleToTheUser %><%=balanceNo%></span></h4>
<%}%> <%if(messageType.equals("failure")){%>


<h4><span><%=messageTOBeVisibleToTheUser %> </span></h4>

<%}}%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" value="Back" class="button"	onClick="submitForm('message','<%=url%>');" /></form>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>