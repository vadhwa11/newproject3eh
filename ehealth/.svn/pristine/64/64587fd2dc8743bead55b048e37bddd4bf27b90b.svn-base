<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="jkt.hrms.masters.business.MstrSponsor"%>
<%@page import="jkt.hrms.masters.business.MstrTherapeutic"%>
<%@page import="jkt.hrms.masters.business.MstrProjecttype"%>
<%@page import="jkt.hrms.masters.business.MstrProjectStatus"%>
<%@page import="jkt.hrms.masters.business.MstrTrialphase"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="jkt.hrms.masters.business.MstrSponsor"%>
<%@page import="jkt.hrms.masters.business.MstrTherapeutic"%>
<%@page import="jkt.hrms.masters.business.MstrProjecttype"%>
<%@page import="jkt.hrms.masters.business.MstrProjectStatus"%>
<%@page import="jkt.hrms.masters.business.MstrTrialphase"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script> 

<%
				Map<String, Object> map = new HashMap<String, Object>();
					List<MstrProject> projectList = new ArrayList<MstrProject>();
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
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				
				
	%>

<jsp:include page="hr_searchResultBlockForProjectTracking.jsp" /> 
<form name="requlatoryMenu" method="post" action="" >



<div class="leftMenu">Regulatory Submission

	<div class="clear"></div>	
	
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="RegulatorySubmission" onClick="submitForm('requlatoryMenu','projectTracking?method=showRegulatorSubmissionJsp','validateRadio');" value="Regulatory Submission" height="34" width="188" />
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="Query Entry" onClick="submitForm('requlatoryMenu','projectTracking?method=showQueryEntryJsp','validateRadio');" value="Query Entry" height="34" width="188" />
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="Answer Entry" onClick="submitForm('requlatoryMenu','projectTracking?method=showAnsEntryJsp','validateRadio');" value="Answer Entry" height="34" width="188" />
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="Query Flw Entry" onClick="submitForm('requlatoryMenu','projectTracking?method=showQueryFlwEntryJsp','validateRadio');" value="Query Follow Entry" height="34" width="188" />
	
	
	
</div>

<div id="searchresults" tabindex=2 class="floatRight">
<div id="searchtable" tabindex=2 class="small" ></div>

<script type="text/javascript">

formFields = [
[0, "<%= PROJECT_ID%>", "id"], [1,"radioId"], [2,"<%= PROJECT_NAME %>"],[3,"<%=DESCRIPTION%>"],[4,"<%= PROJECT_CODE%>"],[5,"<%= PROTOCOL_NO%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=LOI_NO%>"],
[10,"<%=PROJECT_TYPE_ID%>"],[11,"<%=PROJECT_TRIAL_PHASE_ID%>"],[12,"<%=PROJECT_STATUS_ID%>"],[13,"<%=BUDGET%>"],[14,"<%=CURRENCY_ID%>"],[15,"<%=START_DATE%>"],[16,"<%=END_DATE%>"],[17,"<%=LOI_DATE%>"],[18,"<%=PURCHASE_ORDER_NO%>"],[19,"<%=PURCHASE_ORDER_DATE%>"],[20,"<%=CONTRACT_NO%>"],[21,"<%=CONTRACT_DATE%>"]
,[22,"<%=BILLABLE%>"],[23,"<%=THP_ID%>"],[24,"<%=SPONSOR_ID%>"],[25,"<%=STATUS%>"]];
statusTd = 25;
</script>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Select"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "radioId";

data_header[1] = new Array;
data_header[1][0] = "Project Name"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= PROJECT_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "10%"
data_header[2][3] = "<%=DESCRIPTION%>";

data_header[3] = new Array;
data_header[3][0] = "Code"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= PROJECT_CODE%>";

data_header[4] = new Array;
data_header[4][0] = "Protocol No"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= PROTOCOL_NO%>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "LOI No"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=LOI_NO %>";

data_header[9] = new Array;
data_header[9][0] = "Type"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=PROJECT_TYPE_ID %>";

data_header[10] = new Array;
data_header[10][0] = "Project Trial Phase"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=PROJECT_TRIAL_PHASE_ID %>";

data_header[11] = new Array;
data_header[11][0] = "Project Status"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=PROJECT_STATUS_ID %>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=BUDGET %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "<%=CURRENCY_ID %>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "<%=START_DATE %>";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = "15%";
data_header[15][3] = "<%=END_DATE%>";

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = "15%";
data_header[16][3] = "<%=LOI_DATE%>";

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = "15%";
data_header[17][3] = "<%=PURCHASE_ORDER_NO%>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = "15%";
data_header[18][3] = "<%=PURCHASE_ORDER_DATE%>";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = "15%";
data_header[19][3] = "<%=CONTRACT_NO%>";

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = "15%";
data_header[20][3] = "<%=CONTRACT_DATE%>";

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = "15%";
data_header[21][3] = "<%=BILLABLE%>";

data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = "15%";
data_header[22][3] = "<%=THP_ID%>";

data_header[23] = new Array;
data_header[23][0] = ""
data_header[23][1] = "hide";
data_header[23][2] = "15%";
data_header[23][3] = "<%=SPONSOR_ID%>";

data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = "15%";
data_header[24][3] = "<%=STATUS%>";

data_arr = new Array();

<%


Iterator itr=projectList.iterator();
int  counter=0;
while(itr.hasNext())
{


	MstrProject mstrProject= (MstrProject)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= mstrProject.getId()%>

data_arr[<%= counter%>][1] = '<input name="projectId"  class="radioCheck"  id="rb" type="radio" value="<%=mstrProject.getId()%>" />';
	

data_arr[<%= counter%>][2] = "<%=mstrProject.getPrjName()%>";


data_arr[<%= counter%>][3] = "<%=mstrProject.getPrjDesc()%>";


data_arr[<%= counter%>][4] = "<%=mstrProject.getPrjCode()%>";

data_arr[<%= counter%>][5] = "<%=mstrProject.getPrjProtocalno()%>"
data_arr[<%= counter%>][6] = "<%= mstrProject.getLastChgBy() %>"
<% if(mstrProject.getLastChgDate() != null){%>
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(mstrProject.getLastChgDate()) %>"
<%}%>
data_arr[<%= counter%>][8] = "<%= mstrProject.getLastChgTime() %>"
data_arr[<%= counter%>][9] = "<%=mstrProject.getPrjLoino() %>"
<%
if(projectTypeList.size()>0){
	 for(MstrProjecttype mstrProjecttype :projectTypeList){
		if(mstrProjecttype.getId().equals(mstrProject.getProjectType().getId())){	 
	
%>

data_arr[<%= counter%>][10] = "<%=mstrProjecttype.getProjectName()%>"
<%}}} %>
<%
	if(trialPhaseList.size()>0){
		for(MstrTrialphase mstrTrialphase :trialPhaseList){	
		 if(mstrTrialphase.getId().equals(mstrProject.getTrialPhase().getId())){
%>
data_arr[<%= counter%>][11] = "<%=mstrTrialphase.getTrialPhaseName()%>"
<%
		}}}
%>
<%
	if(projectStatusList.size()>0){
		for(MstrProjectStatus mstrProjectStatus :projectStatusList){	
		 if(mstrProjectStatus.getId().equals(mstrProject.getProjectStatus().getId())){
%>
data_arr[<%= counter%>][12] = "<%=mstrProjectStatus.getPrjsName()%>"
<%
		}}}
%>

data_arr[<%= counter%>][13] = "<%=mstrProject.getPrjExpectedbudget()%>"
<%
	if(currencyList.size()>0){
		for(MasCurrency masCurrency :currencyList){	
			if(mstrProject.getCurrency().getId() != null ){
		 if(masCurrency.getId().equals(mstrProject.getCurrency().getId())){
%>
data_arr[<%= counter%>][14] = "<%=masCurrency.getCurrencyName()%>"
<%
		 }}}}
%>
data_arr[<%= counter%>][15] = "<%=HMSUtil.convertDateToStringWithoutTime(mstrProject.getPrjStdt())%>"
<% if(mstrProject.getPrjEddt() != null){%>
data_arr[<%= counter%>][16] = "<%=HMSUtil.convertDateToStringWithoutTime(mstrProject.getPrjEddt())%>"<%
	}else{
%>
data_arr[<%= counter%>][17] = ""
<%
	}
%>
<% if(mstrProject.getPrjLoidt() != null){%>
data_arr[<%= counter%>][17] = "<%=HMSUtil.convertDateToStringWithoutTime(mstrProject.getPrjLoidt())%>";
<%
	}else{
%>
data_arr[<%= counter%>][17] = ""
<%
	}
%>
<% if(mstrProject.getPurchaseOrderNo() != null){%>
data_arr[<%= counter%>][18] = "<%=mstrProject.getPurchaseOrderNo()%>";
<%
	}else{
%>
data_arr[<%= counter%>][18] = ""
<%
	}
%>
<% if(mstrProject.getPurchasOrderDate() != null){%>
data_arr[<%= counter%>][19] = "<%=HMSUtil.convertDateToStringWithoutTime(mstrProject.getPurchasOrderDate())%>";
<%
	}else{
%>
data_arr[<%= counter%>][19] = ""
<%
	}
%>
<% if(mstrProject.getContractNo() != null){%>
data_arr[<%= counter%>][20] = "<%=mstrProject.getContractNo()%>";
<%
	}else{
%>
data_arr[<%= counter%>][20] = ""
<%
	}
%>
<% if(mstrProject.getContractDate() != null){%>
data_arr[<%= counter%>][21] = "<%=HMSUtil.convertDateToStringWithoutTime(mstrProject.getContractDate())%>";
<%
	}else{
%>
data_arr[<%= counter%>][21] = ""
<%
	}
%>
data_arr[<%= counter%>][22] = "<%=mstrProject.getBillable()%>";
<%
	if(therapeuticAreaList.size()>0){
		for(MstrTherapeutic mstrTherapeutic :therapeuticAreaList){	
			if(mstrProject.getThp()!= null){
		 if(mstrTherapeutic.getId().equals(mstrProject.getThp().getId())){
%>
data_arr[<%= counter%>][23] = "<%=mstrTherapeutic.getThpDesc()%>"
<%
		 }}}}
%>
<%
if(sponsorList.size()>0){
	for(MstrSponsor mstrSponsor :sponsorList){
	if(mstrSponsor.getId().equals(mstrProject.getSponsor().getId())){
%>

data_arr[<%= counter%>][23] = "<%=mstrSponsor.getSponsorName()%>";
<%
		}
			}
}
%>


<% 

if(mstrProject.getStatus().equals("y")){ %>
data_arr[<%= counter%>][24] = "Active"
<%}else{%>
data_arr[<%= counter%>][24] = "InActive"
<%}%>
<%

counter++;
}
%>


formName = "requlatoryMenu"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	




<script type="text/javascript">

function validateRadio(){
			
			 for(var i = 0; i < document.getElementsByName('projectId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('projectId')[i].checked == true)
              {
				
				return true;
			  }		
  		}
  		alert("Please select the Project")
		return false;
		
	}

</script>
			
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

