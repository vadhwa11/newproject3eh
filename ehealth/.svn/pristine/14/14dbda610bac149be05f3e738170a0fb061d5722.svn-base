<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="jkt.hrms.masters.business.MstrSponsor"%>
<%@page import="jkt.hrms.masters.business.MstrTherapeutic"%>
<%@page import="jkt.hrms.masters.business.MstrProjecttype"%>
<%@page import="jkt.hrms.masters.business.MstrProjectStatus"%>
<%@page import="jkt.hrms.masters.business.MstrTrialphase"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject>projectList = new ArrayList<MstrProject>();
				List<MstrSponsor> sponsorList = new ArrayList<MstrSponsor>();
				List<MstrTherapeutic> therapeuticAreaList = new ArrayList<MstrTherapeutic>();
				List<MstrProjecttype> projectTypeList = new ArrayList<MstrProjecttype>();
				List<MstrProjectStatus> projectStatusList = new ArrayList<MstrProjectStatus>();
				List<MstrTrialphase> trialPhaseList = new ArrayList<MstrTrialphase>();
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("sponsorList")!= null){
					sponsorList = (List)map.get("sponsorList");
				}
				if(map.get("therapeuticAreaList")!= null){
					therapeuticAreaList = (List)map.get("therapeuticAreaList");
				}
				if(map.get("projectTypeList")!= null){
					projectTypeList = (List)map.get("projectTypeList");
				}
				if(map.get("projectStatusList")!= null){
					projectStatusList = (List)map.get("projectStatusList");
				}
				if(map.get("trialPhaseList")!= null){
					trialPhaseList = (List)map.get("trialPhaseList");
				}
				if(map.get("currencyList")!= null){
					currencyList = (List)map.get("currencyList");
				}
				
				String message = "";
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
			
				
	%>







<select  name="<%=PROJECT_ID %>" validate="Project,string,yes"  onchange="display(this.value);" >
<option value="">Select</option>
<%
	for(MstrProject mstrProject : projectList){
%>
<option value="<%=mstrProject.getId() %>"><%=mstrProject.getPrjName() %></option>
<%} %>
</select>
<%
	for(MstrProject mstrProject : projectList){
%>
<input type="hidden" name="<%=PROJECT_NAME %>"  value="<%=mstrProject.getPrjName() %>" />
<%} %>


<script type="text/javascript">
	document.getElementById('exten').style.display = 'none' ;
	document.getElementById('extensionss').value = 'y' ;
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
