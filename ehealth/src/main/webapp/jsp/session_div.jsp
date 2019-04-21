<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasSession> masSessionList = new ArrayList<MasSession>();
if(map.get("masSessionList") != null){
	masSessionList = (List<MasSession>)map.get("masSessionList");
}

String jspParam="";
if(map.get("jspParam")!=null){
	jspParam=(String)map.get("jspParam");
}
System.out.println("masSessionList jsp "+masSessionList.size());

%>
<%
			 Date currentSessionTime=new Date();
	SimpleDateFormat parser = new SimpleDateFormat("hh:mm a");
	String ct=parser.format(currentSessionTime);
	Date cur = parser.parse(ct);
	
%>
<select <%=jspParam %>>
			 <%if(null !=masSessionList && masSessionList.size()>0) {
			for(MasSession masSession:masSessionList){ 
					
					 Date fromTime = parser.parse(masSession.getFromTime());
					Date toTime = parser.parse(masSession.getToTime());
					
					 
					if(cur.after(fromTime) && cur.before(toTime)){
				%>
				<option value="<%=masSession.getId()%>"><%=masSession.getSessionName()%></option>
				<%}} %>
			
			<%} %>
			</select> 
