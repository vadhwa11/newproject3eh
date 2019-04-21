<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> addOrEdit = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("addOrEdit")!= null){
			addOrEdit = (Map)map.get("addOrEdit");
		}
		Boolean teamSkills=false;
		if(addOrEdit.get("teamSkills")!= null){
			teamSkills = (Boolean)addOrEdit.get("teamSkills");
		}
%>
 <form name="<%=LEAVE_DETAILS%>" method="post" action="">
<div class="titleBg">
<h2>Leave Details</h2>
</div>
<div class="clear"></div>
<div class="Block">

<h4><a href="/hms/hrms/leave?method=showMyDetails">My Details</a></h4>
<div class="clear"></div>
<%-- <% if(teamSkills){ %> --%>
<h4><a href="/hms/hrms/leave?method=showTeamDetails">Team
Member Details</a></h4>
<div class="clear"></div>
<%-- <% }%> --%>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
