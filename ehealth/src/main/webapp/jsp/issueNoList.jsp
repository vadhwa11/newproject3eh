<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();

//List storeIssueMList= new ArrayList();
if(map.get("storeIssueMList") != null){
	storeIssueMList = (List)map.get("storeIssueMList");
}
%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%><ul>
	<%	if(storeIssueMList.size() !=0){
		for (StoreIssueM storeIssueM:storeIssueMList) {
			//StoreGrnM storeGrnM = (StoreGrnM) iterator.next();
			String toDeptName="";
		    String issueNo = storeIssueM.getIssueNo();
		    String issueId="";
		    issueId = ""+storeIssueM.getId();
			if(storeIssueM.getToStore()!=null){
				issueNo=issueNo+" [ "+storeIssueM.getToStore().getDepartmentName()+" ]  # "+issueId;
			}

%>

	<li style="width: auto;"><%=issueNo%></li>
	<% }%>
	<%}else{%>
	<li>----------No Issue No found-------------</li>
	<%} %>
</ul>



