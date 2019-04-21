<%@ page import="java.util.*"%>
<%@ page import="jkt.hrms.recruitment.masters.business.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List list = new ArrayList();
	
	
	if(map.get("error") != null){
		String error = (String)map.get("error");
%>
<%=error%>
<%		
	}else if(map.get("stateList") != null){
		
		list=(List<MasState>)map.get("stateList");
		List<MasState> stateList = list;
%>
<label><span>*</span> State</label>
<div id="messageForWait1" class="msg" style="display: none">
Getting State List...</div>
<select id="state" name="<%=RequestConstants.STATE %>"
	onchange="getCityListAjax('addresume','updatePage1')"
	validate="State,string,yes">
	<option value=0>Select</option>
	<%    
	
   			for(MasState state : stateList){
   				
  			 %>
	<option value='<%=state.getId()%>'><%=state.getStateName()%></option>
	<%	
				}
			%>

</select>


<%}else if(map.get("districtList") !=null){
		list = (List<MasDistrict>)map.get("districtList");
		List<MasDistrict> districtList = list;
	%>
<label><span>*</span> City</label>
<div id="messageForWaitCity1" class="msg" style="display: none">
Getting City List...</div>
<select id="district" name="<%=RequestConstants.DISTRICT %>"
	validate="City,string,yes">
	<option value='0'>Select</option>
	<%    
	
   			for(MasDistrict district : districtList){
   				
  			 %>
	<option value="<%=district.getId()%>"><%=district.getDistrictName()%></option>
	<%	
				}
			%>
	<option value='Other'>Other</option>
</select>

<%} %>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
