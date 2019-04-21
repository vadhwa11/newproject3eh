<%@ page import="java.util.*"%>

<form name="message" action="" method="post">
<div class="Block">
	<%  
    Map map=(Map)request.getAttribute("map");	
	String sentSuccessFully = "";
	String notSentSuccessFully = "";
	String msg = "";
    if(map!=null){
    	if(map.get("sentSuccessfullyMsg")!=null)
    	{
	    	sentSuccessFully = (String)map.get("sentSuccessfullyMsg");
    	}
    	if(map.get("notSentSuccessfullyMsg")!=null)
    	{    	
	    	notSentSuccessFully = (String)map.get("notSentSuccessfullyMsg");
    	}
    	if(map.get("message")!=null)
    	{
    		msg = (String)map.get("message");
    	}
	}%>
	<center>
		<%if(sentSuccessFully!=null && !sentSuccessFully.equals(""))
		{%>
			<h4>Mail Sent Successfully To:</h4>
			<label class="value"> <%=sentSuccessFully%></label><br>
			<div class="clear"></div>
		<%}
		if(notSentSuccessFully!=null && !notSentSuccessFully.equals(""))
		{%>
			<h4>Mail Sending Unsuccesful To:</h2>
			<label class="value"> <%=notSentSuccessFully%></value><br>
			<div class="clear"></div>
		<%}
		
		if(msg!=null && !msg.equals(""))
		{%>
			<h2><font color=#339900><%=msg %></font></h2>
			<div class="clear"></div>
		<%}%>
		
		<a href="resume?method=showSearchPage">Click Here</a> to search more records
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	</center>