<%@page import="jkt.hms.masters.business.MmAuctionParticipent"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MmAuctionParticipent> auctionParticipentList= new ArrayList<MmAuctionParticipent>();
if(map.get("auctionParticipentList") !=null){
	auctionParticipentList=(List<MmAuctionParticipent>)map.get("auctionParticipentList");
}
%>
<%
	if(auctionParticipentList.size()>0){
%>
	<%=auctionParticipentList.get(0).getAmount()%>
<% } %>