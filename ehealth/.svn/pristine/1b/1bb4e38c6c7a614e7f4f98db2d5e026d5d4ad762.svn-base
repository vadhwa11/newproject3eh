<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.RETURN_NO"%>
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
 	String issueNo="";
 	if(map.get("issueNo")!=null){
 		issueNo =(String)map.get("issueNo")  ;
	}
 	//
 	int fromDeptId=0;
 	if(map.get("fromDeptId")!=null){
 		fromDeptId =(Integer)map.get("fromDeptId")  ;
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
	int deptId1=0;
	if(map.get("deptId1")!=null){
		deptId1=(Integer)map.get("deptId1");
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
<input type="hidden" name="IpIssueMId" id="IpIssueMId" value="<%=IpIssueMId %>" />
<div class="clear"></div>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input id="exit"  type="button" name="exit" value="Back"	class="button" onclick="submitForm('messageForStock','<%=url %>');" />
<%if(deptId1==24 || deptId1==35 || deptId1==25){ %>
<input id="print" property="print" type="button" name="print" value="Print" class="button" onclick="submitForm('messageForStock','stores?method=generateConsumptionReport&IpIssueMId=<%=IpIssueMId%>');" />
<%}else{ %>
<input id="print" property="print" type="button" name="print" value="Print" class="button" onclick="submitForm('messageForStock','stores?method=printReturnFromDispensaryJsp&returnNo=<%=issueNo%>');" />

<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>
    self.close();
 </script>