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
					List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
					List<MstrProject> allProjectList = new ArrayList<MstrProject>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("allProjectList")!= null){
					allProjectList = (List)map.get("allProjectList");
				}
				if(map.get("siteHeaderList")!= null){
					siteHeaderList = (List)map.get("siteHeaderList");
				}
				int projectId1 = 0;
					if(map.get("projectId")!= null){
						projectId1 = (Integer)map.get("projectId");
					}
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				int projectId = 0;
				if(projectList.size()>0){
					for(MstrProject mstrProject :projectList){
						projectId = mstrProject.getId();
					}
				}
				
				
	%>
<%@page import="jkt.hrms.masters.business.MstrSiteHeader"%>
<script type="text/javascript">
function showAddPatient()
	{	
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showAddPatient&projectId="+id;
  		 obj.submit();
  		 return true;
	}
	
	function showAddPatient1()
	{	
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=ModifyPatientSchedule";
  		 obj.submit();
  		 return true;
	}
	function showDCFEntry()
	{	
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=searchPatientForSite";
  		 obj.submit();
  		 return true;
	}
	function showDCFView()
	{	
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showDCFViewJsp";
  		 obj.submit();
  		 return true;
	}
	
function showScheduleSetting()
	{	
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showScheduleSettingJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	}
function updateScheduleSetting()
	{	
		 var id = '<%=projectId%>';
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=updateScheduleSettingJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	}
</script>

<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>

<jsp:include page="hr_searchResultBlockForProjectTracking.jsp" /> 

<form name="projectTracking" method="post" action="" >



<div class="leftMenu">Project Tracking

	<div class="clear"></div>	
	
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="SiteVitals" onClick="if(validateRadio()){showAddPatient()};" value="Add Patient" height="34" width="188" />
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="SiteVitals" onClick="if(validateRadio()){showAddPatient1()};" value="Modify Patient Schedule" height="34" width="188" />
	
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="SiteVitals" onClick="if(validateRadio()){showDCFEntry()};" value="DCF ENTRY" height="34" width="188" />
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="dcfEntry"   onClick="if(validateRadio()){showDCFView()};" value="DCF View" height="34" width="188" />
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" onClick="if(validateRadio()){showScheduleSetting()};" height="34" value="Schedule Setting" width="188" />
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" onClick="if(validateRadio()){updateScheduleSetting()};" height="34" value="Update Setting" width="188" />
	
	
</div>
<div class="Block">
<label style="width: 114px;"><span>*</span>Project </label>
<select  name="<%=PROJECT_ID %>" validate="Project,string,yes" onchange="submitForm('projectTracking','projectTracking?method=showSitesListForProjectTracking');" >
<option value="0">Select</option>
<%
for(MstrProject mstrProject: projectList){
if(mstrProject.getId().equals(projectId1)){
%>
<option value="<%=mstrProject.getId() %>" selected="selected"><%=mstrProject.getPrjName() %></option>
<%}else{ %>
<option value="<%=mstrProject.getId() %>" ><%=mstrProject.getPrjName() %></option>
<%}} %>
</select>
</div>
<div id="searchresults" tabindex=2 class="floatRight">
<div id="searchtable" tabindex=2 class="small" ></div>

<script type="text/javascript">

formFields = [
[0, "<%= SITE_ID%>", "id"], [1,"radioId"], [2,"<%= SITE_NAME %>"],[3,"<%=SITE_CODE%>"],[4,"<%= SITE_CONTACT_NO%>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%= SITE_BRANCH %>"],[9,"<%= SITE_RATING_ID %>"],[10,"<%= SITE_EMAIL_ID %>"],[11,"<%=STATUS%>"]];
statusTd = 11;
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
data_header[1][0] = "Site Name"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%=SITE_NAME%>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "10%"
data_header[2][3] = "<%=SITE_CODE%>";

data_header[3] = new Array;
data_header[3][0] = "Contact No"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= SITE_CONTACT_NO%>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY%>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Branch"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=SITE_BRANCH%>";

data_header[8] = new Array;
data_header[8][0] = "Rating"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=SITE_RATING_ID%>";

data_header[9] = new Array;
data_header[9][0] = "Email Id"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=SITE_EMAIL_ID%>";


data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=STATUS%>";

data_arr = new Array();

<%


Iterator itr=siteHeaderList.iterator();
int  counter=0;
while(itr.hasNext())
{


	MstrSiteHeader mstrSiteHeader= (MstrSiteHeader)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= mstrSiteHeader.getId()%>

data_arr[<%= counter%>][1] = '<input name="siteId"  class="radioCheck"  id="rb" type="radio" value="<%=mstrSiteHeader.getId()%>" />';
	

data_arr[<%= counter%>][2] = "<%=mstrSiteHeader.getSiteName()%>";


data_arr[<%= counter%>][3] = "<%=mstrSiteHeader.getSiteCode()%>";


data_arr[<%= counter%>][4] = "<%=mstrSiteHeader.getSiteContactNo()%>";

data_arr[<%= counter%>][5] = "<%= mstrSiteHeader.getLastChgBy() %>"
<% if(mstrSiteHeader.getLastChgDate() != null){%>
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(mstrSiteHeader.getLastChgDate()) %>"
<%}%>
data_arr[<%= counter%>][7] = "<%= mstrSiteHeader.getLastChgTime() %>"

data_arr[<%= counter%>][8] = "<%= mstrSiteHeader.getSiteBranch() %>"
data_arr[<%= counter%>][9] = "<%= mstrSiteHeader.getRating().getRatingName() %>"
data_arr[<%= counter%>][10] = "<%= mstrSiteHeader.getSiteEmailId() %>"

<% 
if(mstrSiteHeader.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>
<%

counter++;
}
%>


formName = "projectTracking"

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
			
			 for(var i = 0; i < document.getElementsByName('siteId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('siteId')[i].checked == true)
              {
				
				return true;
			  }		
  		}
  		alert("Please select the Site")
		return false;
		
	}

</script>
			
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

