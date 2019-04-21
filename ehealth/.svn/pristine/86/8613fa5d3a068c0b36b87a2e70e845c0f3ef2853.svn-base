<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.BudObjectHead"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.BudEstimateEntry"%>

<%
		Map map = new HashMap();
		List<BudEstimateEntry> searchEstimateEntryListObj = new ArrayList<BudEstimateEntry>();

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}

		if (map.get("searchEstimateEntryListObj") != null)
			searchEstimateEntryListObj =(List)map.get("searchEstimateEntryListObj");
     if (searchEstimateEntryListObj!=null && searchEstimateEntryListObj.size() > 0 )
	     	{
	     %> <select name="<%=VISIT_NUMBER %>" id="visitNoReport"
	validate="Visit No,string,no">
	<option value="">Select</option>
	<%

	     		for (BudEstimateEntry visit : searchEstimateEntryListObj) {
	   		%>
	<option value="<%=visit.getId()%>"><%=visit.getObjectHeadId().getObjectHeadName()%>
	</option>
	<% }
	     	 %>
</select> 
<%} else{
		     	  %> <input type="text" name="<%=VISIT_NUMBER %>" value=""
	MAXLENGTH="6" readonly="readonly" validate="Visit No,String,yes" /> <%} %>

