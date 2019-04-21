<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
	  Map<String,Object> map = new HashMap<String,Object>();

	  if (request.getAttribute("map") != null) {
	  	map = (Map<String,Object>) request.getAttribute("map");

	  }
	  int issueId = 0;
	  if(map.get("issueId") != null){
		  issueId = (Integer)map.get("issueId");
	  }
	String msg = "";
	 if(map.get("msg") != null){
		  msg = (String)map.get("msg");
	  }
	 int presId=0;
	 if(map.get("presId") != null && !map.get("presId").equals("")){
		 presId = Integer.parseInt((String)map.get("presId"));
	  }
	  %>

<script>
  	window.opener.document.getElementById('issueId').value ='<%=issueId%>';
  	window.opener.document.getElementById('presId').value ='<%=presId%>';
  	
  	<%-- window.opener.document.getElementById('msgId').value ='<%=msg%>'; --%>
</script>
<input type="hidden" name="issueId" id="issueId" value="<%=issueId %>"/>
<input type="hidden" name="presId" id="presId" value="<%=presId %>"/>


<script>
/* window.close(); */
</script>