
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * index.jsp  
 * Purpose of the JSP -  This is for index.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 11th Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@ page import="java.util.Map"%>
<%@ page import="jkt.hms.masters.business.MasApplication"%>
<%@ include file="header.jsp"%>

<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/jquery.min.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/jquery-ui.css">

<script type="text/javascript">
function myFunction() { 
	    if((navigator.userAgent.indexOf("Opera") || navigator.userAgent.indexOf('OPR')) != -1 ) 
	   {
	      return "Opera";
	   }
	   else if(navigator.userAgent.indexOf("Chrome") != -1 )
	   {
		   return "Chrome";// alert('Chrome');
	   }
	   else if(navigator.userAgent.indexOf("Safari") != -1)
	   {
	       return "Safari";//alert('Safari');
	   }
	   else if(navigator.userAgent.indexOf("Firefox") != -1 ) 
	   {
		   return "Firefox";// alert('Firefox');
	   }
	   /* else if((navigator.userAgent.indexOf("MSIE") != -1 ) || (!!document.documentMode == true )) //IF IE > 10
	   {
	     return //alert('IE'); 
	   }-*/   
	  
   }

    function copyToClipboard() {
    	/* if(myFunction()=="Chrome"){
        	alert("Print screen not allowed!");	
    	}  */
        
	  // Create a "hidden" input
	  var aux = document.createElement("input");
	  // Assign it the value of the specified element
	  aux.setAttribute("value", document.body);
	  // Append it to the body
	  document.body.appendChild(aux);
	  // Highlight its content
	  aux.select();
	  // Copy the highlighted text
	  document.queryCommandSupported("copy") ;
	  document.queryCommandEnabled("copy");
	  document.execCommand("copy");
	  // Remove it from the body
	  document.body.removeChild(aux);
  
}
    
var $x = jQuery.noConflict();
    
$x(document).ready(function(){
    $x(window).keyup(function(e){
      if(e.keyCode == 44){
        copyToClipboard();
        /* if(myFunction()=="Firefox"){
        	alert("Print screen not allowed!");	
        } */
        
      };
    });
});


</script>

<%
        Map mainMap=(Map)request.getAttribute("map");
		String contentJsp=(String)mainMap.get("contentJsp");
		String empanelledDashBoard=(String)session.getAttribute("empanelledDashBoard");
		if(contentJsp != null){ 
			

%>
<%if("empanelledDashBoard".equalsIgnoreCase(empanelledDashBoard)){%>
	<%@ include file="empaneledNavigation1.jsp"%>
<%}else{%>
	<%@ include file="navigation1.jsp"%>
<%} %>



<jsp:include page="<%=contentJsp%>" flush="true" />

<%@ include file="footer.jsp"%>
<%
		}
		else{%>

<jsp:include page="default.jsp" flush="true" />



<% 		}

%>
<script type="text/javascript">
function disableBack() { window.history.forward() } 


	disableBack();
	window.inhibited_load=disableBack;
	window.onpageshow=function(evt){if(evt.persisted)disableBack()}
	window.inhibited_unload=function(){void(0)}
	<%-- 
window.onload = function(){
   	var formlist = document.getElementsByTagName("form");
   	if(formlist.length > 0)
   	{
   		 for(var i=0; i<formlist.length; i++)
   		{
   			//alert("csrfTokenName")
   			//alert("csrfTokenValue")
   			 var ele = document.createElement("input");
       		ele.setAttribute("id","csrfTokenName");
       		ele.setAttribute("name","csrfTokenName");
       		ele.setAttribute("type","hidden");
       		ele.setAttribute("value","csrfTokenValue");
       		
   			formlist[i].appendChild(ele); 
       	} 
    }
} --%>

</script>
<!-- 
 <script>
document.addEventListener("contextmenu", function(e){
    e.preventDefault();
}, false);
</script> 
-->
<%-- <%@ include file="footer.jsp"%> --%>
