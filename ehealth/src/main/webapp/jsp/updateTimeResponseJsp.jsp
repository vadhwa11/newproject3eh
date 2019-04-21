

<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");


//if(request.getParameter("hdb")!=null){
	//counter1=Integer.parseInt(request.getParameter("hdb"));
//}
%>
<label	class="value"><%=time %></label>
<input type="hidden" name="orderTime" value="<%=time %>" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
