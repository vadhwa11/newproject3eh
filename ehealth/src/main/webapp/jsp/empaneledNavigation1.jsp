<!DOCTYPE html>
<%@page import="jkt.hms.masters.business.MasApplication"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/jquery.min.js"></script>

<script type="text/javascript">
$.noConflict();

$(document).ready(function(){
  $('#menu li a').click(function(){
	  
    $('li a').removeClass("active");
    $(this).addClass("active");
});
});

$(document).ready(function(){
  $('#menu li ul li a').click(function(){
    $('li a').removeClass("active");
    $(this).parent().parent().parent().children().get(0).setAttribute("class", "active");
});
});
<%
String empaneledAppId="";
if(session.getAttribute("appId")!=null){
	empaneledAppId=(String)session.getAttribute("appId");
}
boolean flag1 =false;
boolean flag2 =false; 
boolean flag3 =false; 
if(empaneledAppId!=null && !"".equalsIgnoreCase(empaneledAppId)){  
		if("E328".equalsIgnoreCase(empaneledAppId)) 	//Reception			
		{
			flag1 = true;
		}
		if("E504".equalsIgnoreCase(empaneledAppId)) 	//OPD			
		{
			flag2 = true;
		}
		
		if("E1017".equalsIgnoreCase(empaneledAppId)) 	//OPD			
		{
			flag3 = true;
		}  
}
%>

</script> 
<%if(flag1){%>
	<div class="clear"></div>
<form name="navigation" method="post" > 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="main_menu">
<ul id="menu_new">  
<li><a href="/hms/hms/lab?method=pendingEmpanelledLab" id="">Sample Collection</a></li> 
<li><a href="/hms/hms/lab?method=showPendingSampleValidationJspForEmpanelled" id="">Sample Validation</a></li> 
<li><a href="/hms/hms/investigation?method=showPendingResultEntryLabJspForEmpanelled" id="">Result Entry</a></li> 
<li><a href="/hms/hms/investigation?method=showPendingForResultValidationLabJspForEmpanelled" id="">Result Validation</a></li> 
<!-- <li><a href="#" id="" >Samp</a>
<ul> 
<li><a href="#" id=""  onclick="">Second Child</a></li> 	  
</ul>
</li>  -->
</ul>
<div class="clear"></div> 
</div>     
</form> 
<div class="clear"></div> 
<%} %>
<%if(flag2){%>
	<div class="clear"></div>
<form name="navigation" method="post" > 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="main_menu">
<ul id="menu_new">  
<li><a href="#" id="">Sample Acceptence</a></li>  
<li><a href="#" id="">Result Entry</a></li> 
<li><a href="#" id="">Result Validation</a></li> 
<!-- <li><a href="#" id="" >Samp</a>
<ul> 
<li><a href="#" id=""  onclick="">Second Child</a></li> 	  
</ul>
</li>  -->
</ul>
<div class="clear"></div> 
</div>     
</form> 
<div class="clear"></div> 
<%} %>
<%if(flag3){%>
<div class="clear"></div>
<form name="navigation" method="post" > 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="main_menu">
<ul id="menu_new">  
<li><a href="/hms/hms/stores?method=empanelled" id="">Prescription</a></li>  
<!-- <li><a href="#" id="" >Samp</a>
<ul> 
<li><a href="#" id=""  onclick="">Second Child</a></li> 	  
</ul>
</li>  -->
</ul>
<div class="clear"></div> 
</div>     
</form> 
<div class="clear"></div>  
<%} %>

<div class="clear"></div>
<div class="indicationMainDiv">
<%-- <%
	if(!appName.equals("")){
		screenPath = parentName+" > "+appName;
%> --%>
<div class="indication-nav"><%-- <%=screenPath %> --%></div>
<%-- <%} %> --%>
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="clear"></div>
<div id="mainIn">
  

