<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<div class="small floatRight"  id="smalltableId">

<%
Map map= new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<StoreIssueT> drugIssueDetailsList = new ArrayList<StoreIssueT>();
if(map.get("drugIssueDetailsList") !=null ){
	drugIssueDetailsList=(List<StoreIssueT>)map.get("drugIssueDetailsList");
}
 %>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
<thead>
		<tr>
			<th> Drug Name</th>
			<th> Qty Requested</th>
			<th> Qty Issued</th>
			<th> Note</th>
			</tr>
</thead>
<%if(drugIssueDetailsList!=null && drugIssueDetailsList.size()>0){ %>
	<%
	//String visitDate=null;
	for(StoreIssueT	issueT :drugIssueDetailsList){
	%>
		<tr>

			<td><%=issueT.getItem().getNomenclature() %></td>
			<td><%=issueT.getQtyRequest()%></td>
			<td><%=issueT.getQtyIssued()%></td>
			<%if(issueT.getRemarks() !=null ){ %>
			<td><%=issueT.getRemarks() %></td>
			<%}else{ %>
			<td>-</td>
			<%} %>

		</tr>
		<%} } else {%>
<label> Drug not issued !</label>
<%} %>
</table>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		