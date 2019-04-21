<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@page import="jkt.hms.masters.business.MasHospital"%>
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet"> 
</script>--%>
<script type="text/javascript">
//var csrfTokenName='<csrf:tokenname />';
//var csrfTokenValue='<csrf:tokenvalue />';
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';
</script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<head>
<title>Login Details</title>
<script type="text/javascript" src="/hms/jsp/js/csrfToken.js"></script>
</head>
 <script src="/hms/jsp/js/common.js" type="text/javascript"></script>
 
 
<%

if (response.containsHeader("SET-COOKIE")) {  
    String path = request.getContextPath();  
    String sessionid = request.getSession().getId();
    String se="";
    if(request.isSecure()){
    	se= "; Secure"; 
    }
    response.setHeader("SET-COOKIE", "JSESSIONID=" + sessionid  + "; Path=/ "+se+"; HttpOnly");  
}  

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<Object[]> lastLoginDetailsList = new ArrayList<Object[]>();
	
	if(map.get("lastLoginDetailsList")!= null){
		lastLoginDetailsList = (List)map.get("lastLoginDetailsList");
	}
	String successLoginDate = "";
	String successLoginTime = "";
	if(map.get("successLoginDate")!=null){
		successLoginDate = HMSUtil.convertDateToStringWithoutTime((Date)map.get("successLoginDate"));
	}
	if(map.get("successLoginTime")!=null){
		successLoginTime =(String)map.get("successLoginTime");
	}
%>
<form name="loginDetails" method="post">
<h4>Last Successful Login Details </h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
	<th>Date
	</th>
	<th>Time
	</th>
	</tr>
	<tr>
	<td><%=successLoginDate %></td>
	<td><%=successLoginTime %></td>
	</tr>
	</table>
<div class="clear"></div>
<h4>Last Unsuccessful Login Details </h4>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
	<th>Date
	</th>
	<th>Time
	</th>
	<th>IP Address
	</th>
</tr>
<%
	for(Object[] obj :lastLoginDetailsList){
%>
<tr>
	<td><%=HMSUtil.convertDateToStringWithoutTime((Date)obj[0]) %></td>
	<td><%=obj[1] %></td>
	<td><%=obj[2] %></td>
</tr>
<%} %> 
</table>

<div class="clear"></div>
<div align="center">
<input type="button" name="Ignore" value="Ignore" onclick="submitStatus('ignore');"/>
<input type="button" name="Report" value="Report" onclick="submitStatus('report');"/>
</div>
<script>
function submitStatus(flag){
	if(window.event!=undefined && flag==''){
			
	}else if(flag!=''){
		if(validateMetaCharacters(flag))
			/* window.opener.location.href='/hms/hms/login?method=updateLastLoginDetails&flag='+flag+'&'+csrfTokenName+'='+csrfTokenValue; */
			window.opener.location.href='/hms/hms/login?method=updateLastLoginDetails&flag='+flag;
	}
	window.close();
}
window.onunload = function(){
	if (((window.event.clientX || event.clientX) < 0) || ((window.event.clientY || event.clientY)<0)) // close button
{
	/* window.opener.location.href='/hms/hms/login?method=updateLastLoginDetails&flag=ignore&'+csrfTokenName+'='+csrfTokenValue; */
		window.opener.location.href='/hms/hms/login?method=updateLastLoginDetails&flag=ignore';
}};

</script>

<!-- <script type="text/javascript">

window.onload = function(){ 
	
   	var formlist = document.getElementsByTagName("form");
   	if(formlist.length > 0)
   	{
   		for(var i=0; i<formlist.length; i++)
   		{
   			var ele = document.createElement("input");
   		 
         	ele.setAttribute("name",csrfTokenName);
         	ele.setAttribute("type","hidden");
         	ele.setAttribute("value",csrfTokenValue);
   			
       		formlist[i].appendChild(ele);
       	}
    }
}
</script> -->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


