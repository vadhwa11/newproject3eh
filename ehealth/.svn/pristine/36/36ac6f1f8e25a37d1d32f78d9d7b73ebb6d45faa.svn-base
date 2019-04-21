<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.IpProgressNote"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<IpProgressNote> IpProgressNoteList = new ArrayList<IpProgressNote>();
String wardRemarks ="";
if(request.getAttribute("map") !=null){
	map=(Map<String, Object>)request.getAttribute("map");
}
if(map.get("wardRemarksList") !=null){
	IpProgressNoteList =(List<IpProgressNote>)map.get("wardRemarksList");
}
int i=1;
if(IpProgressNoteList.size() >0){
	for(IpProgressNote remarks :IpProgressNoteList){
		wardRemarks =wardRemarks+i +" : "+remarks.getProgressNote();
	%>
<label class="valueAuto"><%=i %> : <%=remarks.getProgressNote()%></label>
<div class="clear"></div>
<%	i++;
	}
}

%>
