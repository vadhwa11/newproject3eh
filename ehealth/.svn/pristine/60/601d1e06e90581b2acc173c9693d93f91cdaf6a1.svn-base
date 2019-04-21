<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.CssdInstrumentMaster"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<CssdInstrumentMaster> cssdInstrumentMasterList = new ArrayList<CssdInstrumentMaster>();
if(map.get("cssdInstrumentMasterList") != null){
	cssdInstrumentMasterList = (List)map.get("cssdInstrumentMasterList");
}
%>

<ul>
	<%	if(cssdInstrumentMasterList.size() !=0){
		for (Iterator iterator = cssdInstrumentMasterList.iterator(); iterator.hasNext();) {
			CssdInstrumentMaster cssdInstrumentMaster = (CssdInstrumentMaster) iterator.next();
		    String instrumentName = cssdInstrumentMaster.getInstrumentName();
		    String instrumentCode  = cssdInstrumentMaster.getInstrumentCode();
%>
	<li style="width: auto;"><%=instrumentName%>[<%=instrumentCode%>]</li>
	<%}}else{%>
	<li>----------No Items found-------------</li>
	<%} %>
</ul>



