<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
 	String url = "";
 	if(map.get("url")!=null){
 		url =(String)map.get("url");
	}
 	int IpIssueMId =0;
	if(map.get("IpIssueMId")!=null){
		IpIssueMId =(Integer)map.get("IpIssueMId");
	}
 %>
<script type="text/javascript">
	function cancelForm(){
	window.opener.document.getElementById('storeGrnReturnMId').value=<%=storeGrnReturnMId%> ;
  	 close();
   	}
</script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<form name="messageForStock" method="post">
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input id="exit"  type="button" name="exit" value="Back"	class="button" onclick="submitForm('messageForStock','<%=url %>');" />
<input id="print" property="print" type="button" name="print" value="Print" class="button" onclick="submitForm('messageForStock','ipd?method=generateConsumptionReport&IpIssueMId=<%=IpIssueMId%>');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>
    self.close();
 </script>