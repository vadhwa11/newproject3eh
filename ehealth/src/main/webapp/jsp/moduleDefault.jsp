
<%@page import="jkt.hms.masters.business.StoreSlowMovingDrugs"%>
<%@ page import="java.util.*"%>


<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/jquery.min.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/jquery-ui.css">
<script>jQuery.noConflict();</script>
<script type="text/javascript"> 
    function copyToClipboard() {
  // Create a "hidden" input
  var aux = document.createElement("input");
  // Assign it the value of the specified element
  aux.setAttribute("value", document.body.innerHTML);
  // Append it to the body
  document.body.appendChild(aux);
  // Highlight its content
  aux.select();
  // Copy the highlighted text
  document.execCommand("copy");
  // Remove it from the body
  document.body.removeChild(aux);
  
}

    
   var $x = jQuery.noConflict();
       
   $x(document).ready(function(){
       $x(window).keyup(function(e){
         if(e.keyCode == 44){
           copyToClipboard();
           //alert("Print screen not allowed!");
         };
       });
   });
</script>


<%
Map<String,Object> newmap = new HashMap<String,Object>();
List<StoreSlowMovingDrugs> storeSlowMovingDrugList = new ArrayList<StoreSlowMovingDrugs>();
if(request.getAttribute("map") != null){
	newmap=(Map<String, Object>)request.getAttribute("map");
}
String moduleName = ""; 
String appIdEmp="";
if(newmap.get("moduleName")!= null){
	moduleName = (String)newmap.get("moduleName");
}
if(newmap.get("storeSlowMovingDrugList")!= null){
	storeSlowMovingDrugList = (List)newmap.get("storeSlowMovingDrugList");
}
if(session.getAttribute("appId")!= null){
	appIdEmp = (String)session.getAttribute("appId");
}

%>
<%@ page import="java.util.Map"%>
<%@ page import="jkt.hms.masters.business.MasApplication"%>

<%@ include file="header.jsp"%>
<%if(storeSlowMovingDrugList.size()>0){ 
	for(StoreSlowMovingDrugs storeSlowMovingDrugs:storeSlowMovingDrugList){


%>
<marquee behavior="scroll" direction="left" onmousedown="this.stop();" onmouseup="this.start();"  style="font-size: 16px; color: red"  ><%=storeSlowMovingDrugs.getItemName()+"("+storeSlowMovingDrugs.getItemCode()+")" %></marquee>
<%}} %>

<%if("E504".equalsIgnoreCase(appIdEmp) || "E328".equalsIgnoreCase(appIdEmp) || "E1017".equalsIgnoreCase(appIdEmp)){%>
	<%@ include file="empaneledNavigation1.jsp"%>
<%}else{%>
	<%@ include file="navigation1.jsp"%>
<%} %>
<form name="moduleDefault" method="post" action="">


<div class="default-module"><p>Welcome to <%=moduleName %></p></div>
<div class="clear"></div>
<%-- <input type="hidden" name="seq" value="<%=session.getAttribute("csrf")%>"/> --%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<%@ include file="footer.jsp"%>


<script type="text/javascript">
function disableBack() {window.history.forward() } 


	disableBack();
	window.inhibited_load=disableBack;
	window.onpageshow=function(evt){if(evt.persisted)disableBack()}
	window.inhibited_unload=function(){void(0)}
<%-- window.onload = function(){
   	var formlist = document.getElementsByTagName("form");
   	if(formlist.length > 0)
   	{
   		for(var i=0; i<formlist.length; i++)
   		{
   			var ele = document.createElement("input");
       		ele.setAttribute("id","csrfToken");
       		ele.setAttribute("name","csrfToken");
       		ele.setAttribute("type","hidden");
       		ele.setAttribute("value","<%=session.getAttribute("csrfToken")%>");
       		
   			formlist[i].appendChild(ele);
       	}
    }
} --%>
</script>