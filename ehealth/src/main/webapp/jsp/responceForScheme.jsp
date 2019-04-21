
<%@page import="jkt.hms.util.ComaparatorForScheme"%>
<%@page import="jkt.hms.util.ComparatorForTwoFields"%>
<%@page import="java.util.Collections"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	List<MasScheme> schemeList=new ArrayList<MasScheme>();
	
	// Addded by Amit Das
	String pageName = null;
	String schemeName_op = null;
	int schemeId_op = 0;
	String currentScheme = "";
	boolean schemeFlag = false;
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	
	if (map.get("schemeList") != null) {
		schemeList = (List<MasScheme>) map.get("schemeList");
	
	}
	
	if (map.get("page") != null) {
		pageName = (String) map.get("page");
	}
	
	// Added by Amit Das
	if (map.get("schemeName_op") != null && !map.get("schemeName_op").equals("-")) {
		schemeName_op = (String) map.get("schemeName_op");
	}
	// Added by Amit Das
	if (map.get("schemeId_op") != null && !map.get("schemeId_op").equals("-")) {
		schemeId_op = (Integer) map.get("schemeId_op");
	}
	// Added by Amit Das
	if (map.get("currentScheme") != null) {
		currentScheme = (String)map.get("currentScheme");
	}

	// Added by Amit Das
	 Collections.sort(schemeList, new ComaparatorForScheme());
	 
	for(int i =0;i<schemeList.size();i++){
		if(schemeList.get(i).getSchemeName().equalsIgnoreCase(currentScheme))
			schemeList.remove(i);
	}
	//added by govin 29-07-2017 for IP Billing
	String type="";
	if (map.get("type") != null) {
		type = (String)map.get("type");
	}
	
	%>
<% if(!type.equals("") && type.equalsIgnoreCase("ip")) {System.out.println("A") ; %>	
<select id="schemeId1" name="schemeList" onchange="onChangeScheme();">

<%}else{	//added by govin 29-07-2017 for IP Billing end%>
<%if(pageName!=null && pageName.equalsIgnoreCase("discount")) { System.out.println("B") ;%>	
<select id="schemeId" name="schemeId"	validate="Scheme,int,no" onchange="onChangeScheme();">

<% } else {System.out.println("C") ; %>
<select name="schemeList" id="schemeList" onchange="onChangeScheme();">
<% } %>
<%}%>
 <option value="0">Select</option>
 
<%List<Integer> schemeIds=new ArrayList<Integer>(); %>
<%for(MasScheme scheme:schemeList){ %>
<%if(!schemeIds.contains(scheme.getId())){ 
schemeIds.add(scheme.getId());%>
<% if(schemeName_op!=null && schemeName_op.equalsIgnoreCase(scheme.getSchemeName())) { schemeFlag = true;%>
<option value="<%=scheme.getId()%>" selected="selected"><%=scheme.getSchemeName()%></option>
<% } else {%>
<option value="<%=scheme.getId()%>"><%=scheme.getSchemeName()%></option>
<% } %>
<%} %>
<%} %>
<%-- <% if(!schemeFlag && schemeName_op!=null) {%>
<option value="<%=schemeId_op%>" selected="selected"><%=schemeName_op%></option>
<% } %> --%>
</select>

