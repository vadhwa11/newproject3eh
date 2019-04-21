<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%
	Map map=new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map)request.getAttribute("map");
	}
	String savedName = "";
	String msg="";
 	if(map.get("savedName") != null){
 		savedName=(String)map.get("savedName");
 		msg="Pre-Consultation is done for "+savedName;
	}
%>


<form name="preopd" method="post" action="">
<span><h2><%=msg %></h2></span>
<div class="clear"></div>
<input name="No" type="button" align="right" class="button" value="Nurse Waiting List"	onclick="submitForm('preopd','opd?method=showWaitingPatientListJsp');" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>