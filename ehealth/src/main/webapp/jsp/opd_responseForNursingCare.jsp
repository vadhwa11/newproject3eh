<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasNursingCare> masNursingCares = new ArrayList<MasNursingCare>();
List<MasChargeCode> masChargeCodes = new ArrayList<MasChargeCode>();
if(map.get("minorcarelist") != null){
	masNursingCares = (List<MasNursingCare>)map.get("minorcarelist");
}
if(map.get("chargeCodeList") != null){
	masChargeCodes = (List<MasChargeCode>)map.get("chargeCodeList");
}
Integer minor_major=null;
if(map.get("minor_major") != null){
	minor_major = (Integer)map.get("minor_major");
}


%>

<ul>
	<%if(minor_major!=null && minor_major==1){ %>
			<%	if(masNursingCares.size() !=0){
			for (MasNursingCare ncare:masNursingCares) {
		   %>
			<li style="width: auto;"><%=ncare.getNursingName()%>&nbsp;[<%=ncare.getId()%>]</li>
			<%}}else{%>
			<li>----------No Items found-------------</li>
			<%} %>
	<%} %>
	
	<%if(minor_major!=null && minor_major==2){ %>
			<%if(masChargeCodes.size() !=0){
			for (MasChargeCode msc:masChargeCodes) {
		    %>
			<li style="width: auto;"><%=msc.getChargeCodeName()%>[<%=msc.getId()%>]</li>
			<%}}else{%>
			<li>----------No Items found-------------</li>
			<%} %>
	<%} %>
</ul>

	

