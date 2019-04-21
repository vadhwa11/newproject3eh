<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
List<UserWiseBranch> userBranchList = new ArrayList<UserWiseBranch>();
List<MasBranch> branchList = new ArrayList<MasBranch>();
if(map.get("branchList")!= null){
	branchList = (List)map.get("branchList");
}
if(map.get("userBranchList")!= null){
	userBranchList = (List)map.get("userBranchList");
}

%>







<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasBranch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%if(userBranchList.size()>0){ %>

<%@page import="jkt.hms.masters.business.UserWiseBranch"%><label>Branch <span>*</span></label> 
<select name="branchId" id="branchId" >
	<option value="0">Select</option>
	<%
	//
			for(UserWiseBranch userWiseBranch :userBranchList){
				for(MasBranch masBranch :branchList){
					if(masBranch.getId().equals(userWiseBranch.getBranch().getId())){
	%>
	<option value="<%=masBranch.getId() %>"><%=masBranch.getBranchDesc() %></option>
	<%}}}} %>
</select>