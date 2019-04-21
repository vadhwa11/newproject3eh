<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");

		}
		List<Object[]> doclist=new ArrayList<Object[]>();
		if(map.get("doclist") != null){
			doclist = (List)map.get("doclist");
		}
		%>
<div id="docDiv">
<label><span>*</span> Consulting Doc.</label> 
 <select
	name="<%=CONSULTING_DOCTOR %>" id="consultingDocId" tabindex="41" title="Consulting Doctor & Total Current Visit">
	<option value="0">Select</option>
	<%for(Object[] emp:doclist ){ %>
	<option value="<%=emp[0] %>"> <%=emp[1]+" "+emp[2] %></option>
	<%} %>
	</select>
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
