<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%

	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	List<Object[]> sessionList = new ArrayList<Object[]>();
	List<Object[]> hospitalSessionList = new ArrayList<Object[]>();
	if (map.get("sessionList") != null) {
		sessionList = (List<Object[]>) map.get("sessionList");
 	}
	if (map.get("hospitalSessionList") != null) {
		hospitalSessionList = (List<Object[]>) map.get("hospitalSessionList");
 	}
	Box box = HMSUtil.getBox(request);
	
%>


<%
	if(sessionList.size()>0){
%>
<label>Session</label>
<select
	id="sessionId" name="sessionId" onchange="getDetails(this.value,'<%=box.getInt("departmentId") %>');" Validate="Session,string,yes">
<option value="0">Select</option>
<%
	for(Object[] obj : sessionList){
%>
<option value="<%=obj[0]%>"><%=obj[1] %></option>
<%} %>
</select>
<script>
setTimeout("getDetails('0','<%=box.getInt("departmentId") %>')",500);
</script>
<%}else if(hospitalSessionList.size()>0){
	for(Object[] obj:hospitalSessionList){
%>

<input type="hidden" id="sessionId" name="sessionId" value="<%=obj[0]%>" />
<script>
setTimeout("getDetails('<%=obj[0]%>','<%=box.getInt("departmentId") %>')",500);
</script>

<%}}%>