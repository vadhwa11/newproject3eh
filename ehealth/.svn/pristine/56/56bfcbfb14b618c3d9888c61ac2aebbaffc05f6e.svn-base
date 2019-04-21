<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />


<%
 	String message= null;
 	int storeGrnReturnMId =0;
 	Map map = new HashMap();
 	String messageTOBeVisibleToTheUser="";
 	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
 	if(map.get("message")!=null){
 		message =(String)map.get("message");
	}
 	if(map.get("storeGrnReturnMId")!=null){
 		storeGrnReturnMId =Integer.parseInt(""+map.get("storeGrnReturnMId"))  ;
 		
	}
 %>
<script type="text/javascript">
	function cancelForm(){
	//window.opener.document.getElementById('storeGrnReturnMId').value=<%=storeGrnReturnMId%> ;
  	 close();
   	}
</script>


<form name="" method="post">

<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; font-weight: bold; height: 23px;">
<h4><span><%=message %></span></h4>
</div>
</div>

<input id="exit" property="exit" type="button" name="exit" value="Exit"
	class="button" onclick="cancelForm();" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

