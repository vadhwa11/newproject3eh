<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
List<UserWiseBranch> userWiseBranchList = new ArrayList<UserWiseBranch>();
if(map.get("userWiseBranchList")!= null){
	userWiseBranchList = (List)map.get("userWiseBranchList");
}
 int userId = 0;
if(map.get("userId")!=null){
	userId = (Integer)map.get("userId");
}
%>







<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.UserWiseBranch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%if(userWiseBranchList.size()>0){ %>
<label>Branch to be Changed</label> <select name="branch" id="branchId">
	<option value="">--Select Branch --</option>
	<%
		for (Iterator iterator = userWiseBranchList.iterator(); iterator.hasNext();) 
		{
			UserWiseBranch userWiseBranch = (UserWiseBranch)iterator.next();
			if(userId == userWiseBranch.getUser().getId()){
		%>
	<option value="<%=userWiseBranch.getBranch().getId()%>"><%=userWiseBranch.getBranch().getBranchDesc()%></option>
	<%
		}}

		%>
</select>
<%}%>