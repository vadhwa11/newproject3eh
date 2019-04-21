<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript">
	function cancelForm(issueId){
	window.opener.document.getElementById('issueId').value=issueId
  	 close();
   	}


</script>

<%
 	int issueId = 0; 
	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
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
 	if(map.get("issueId") != null){
 		issueId= Integer.parseInt(""+map.get("issueId"));
 	}
 %>


<form name="itemBrandForm" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>


<%if(!messageTOBeVisibleToTheUser.equals(""))
	{
	if(messageType.equals("success")){
	%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; font-weight: bold; height: 23px;">
<%=messageTOBeVisibleToTheUser %></div>
</div>

<%}%> <%if(messageType.equals("failure")){%> <%=messageTOBeVisibleToTheUser %>

<%}}%> <br />
<br />
<input id="exit" property="exit" type="button" name="exit" value="Exit"
	class="button" onclick="cancelForm(<%=issueId %>);" /></form>

</div>