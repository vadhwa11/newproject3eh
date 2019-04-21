<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%><%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

List<PhHouseSurvey> phHouseSurveyList = new ArrayList<PhHouseSurvey>();

if(map.get("phHouseSurveyList")!= null){
	phHouseSurveyList = (List<PhHouseSurvey>)map.get("phHouseSurveyList");
}

%>


<div id="loc">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3">
<%if(phHouseSurveyList.size()>0){ %>


    <%for(PhHouseSurvey md : phHouseSurveyList){ %>
     <option value="<%=md.getId()%>" selected="selected"><%=md.getHouseHoldId()%>(<%=md.getAddress()%>,<%=md.getLsgHouseNo()%>)</option>
     <%} %>

	<%} %>
</select>


</div>