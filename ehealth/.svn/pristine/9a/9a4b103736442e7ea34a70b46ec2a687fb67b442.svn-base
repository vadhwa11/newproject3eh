<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.*"%>

<%@page import="jkt.hms.masters.business.*"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	
		Map map = new HashMap();
		List<UserUsergroupApplication> userApplicationList = new ArrayList<UserUsergroupApplication>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
	    
		if (map.get("userApplicationList") != null){
			userApplicationList =(List<UserUsergroupApplication>)map.get("userApplicationList");
		}
%>

<div class="TableContainer" id="TableContainer">
<div class="clear"></div>
<table cellpadding="0" cellspacing="0" class="scrollTable">
	<thead>
		<tr>
			<th>S.No</th>
			<th>Application Name</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	
           		//Iterator iterator = userApplicationList.iterator();
           		//GroupApplication groupApplication = null;
           		int i=0;
           		for(UserUsergroupApplication userApp : userApplicationList){
   				//while (iterator.hasNext()) 
   				//{
   						i++;
	        %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<%if(userApp.getGroupApp().getApp().getParentId().equals("0") &&
							userApp.getGroupApp().getApp().getUrl().equals("#")){ %>
			<input type="hidden" id="userApp<%=i%>" name="userApp"
				value="<%=userApp.getGroupApp().getApp().getId()%>"> <b><i><%=userApp.getGroupApp().getApp().getName()%><i></b>
			<%}else {%>
			<td><%=userApp.getGroupApp().getApp().getName()%></td>
			<input type="hidden" id="userApp<%=i%>" name="userApp"
				value="<%=userApp.getGroupApp().getApp().getId()%>"> <%} %>
			
		</tr>
		<%}%>
		<input type="hidden" id="userAppcnt" name="userAppcnt" value="<%=i%>" />
	</tbody>
</table>
<input type="button" name="copyExist" value="Copy Rights" class="button"
	onClick="copyFromExist()" /></div>







<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
