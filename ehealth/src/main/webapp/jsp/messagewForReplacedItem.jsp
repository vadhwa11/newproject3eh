<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
String msg="";
if(map.get("msg")!=null){
	msg=(String)map.get("msg");
}
%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>

<link rel="stylesheet" href="/hms/jsp/css/style.css" type="text/css" />
<form name="msgForReplace" method="post">
<h4><%=msg %></h4>
<div class="clear"></div>
<input type="button"  value="close" onclick="closeWindow();"  />
<div class="clear"></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>	

<script>
function closeWindow()
{
	window.opener.location.href=	window.opener.location.href;
	
	window.close();	
}

</script>