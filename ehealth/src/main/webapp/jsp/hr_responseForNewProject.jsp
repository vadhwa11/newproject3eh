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
				
				
				
				String message = "";
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
			
				
	%>







<input type="text" id="projectId"  name="<%=PROJECT_NAME %>"   validate="Project,string,yes"    />

<script type="text/javascript">
	document.getElementById('sponsorId').value = 0;
	document.getElementById('descId').value = "";
	document.getElementById('thpId').value = 0;
	document.getElementById('protocolNoId').value = "";
	document.getElementById('projctCodeId').value = "";
	document.getElementById('loiNoId').value = "";
	document.getElementById('projectTypeId').value = 0;
	document.getElementById('trialPhaseId').value = 0;
	document.getElementById('projectstatusId').value = 0;
	document.getElementById('currencyId').value = 0;
	document.getElementById('exten').style.display = 'none' ;
	document.getElementById('extensionss').value = 'n' ;
	</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
