<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script> 

<%
				Map<String, Object> map = new HashMap<String, Object>();
					List<MstrProject> projectList = new ArrayList<MstrProject>();
					List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
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
				if(map.get("fesStudyHeaderList")!= null){
					fesStudyHeaderList = (List)map.get("fesStudyHeaderList");
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
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<script type="text/javascript">
function showSiteVitals()
	{	
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showSiteVitalsJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	}


	
function showSiteResourceMapping()
	{	
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showSiteResourceMappingJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	
	}
	function addPatient()
	{	
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showAddPatient&projectId="+id;
  		 obj.submit();
  		 return true;
	
	}
function showSiteOtherVitals()
	{	
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
		 obj.action = "projectTracking?method=showSiteOtherVitalsJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	  
	}	
function showSiteMilesStone()
	{	
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showSiteMilesStoneJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	  
	}	
</script>

<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>

<jsp:include page="hr_searchResultBlockForProjectTracking.jsp" /> 
<form name="siteSetting" method="post" action="" >



<div class="leftMenu">Site Setting

	<div class="clear"></div>	
	
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="Site Vitals" onClick="if(validateRadio()){showSiteVitals()};" value="Site Vitals" height="34" width="188" />
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="Milstone" onClick="if(validateRadio()){showSiteMilesStone()};" value="Milestone" height="34" width="188" />
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="Other Vitals" onClick="if(validateRadio()){showSiteOtherVitals()};" value="Other Vitals" height="34" width="188" />
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="Site Calendar1" onClick="submitForm('siteSetting','projectTracking?method=showSiteCalendarJsp','validateRadio');" value="Site Calendar" height="34" width="188" />
	
	<input type="image" src="/hms/jsp/images/buttonIcons/patientDiagnosis.jpg" class="buttonBig" name="SiteResourceMapping" onClick="if(validateRadio()){showSiteResourceMapping()};" value="Site Resource Mapping" height="34" width="188" />
	
	
	
</div>
<div class="Block">
<label style="width:114px; "><span>*</span>Project </label>
<select  name="<%=PROJECT_ID %>" validate="Patient Visit,string,yes" onchange="submitForm('siteSetting','projectTracking?method=showProjectSitesList');" >
<option value="0">Select</option>
<%
for(MstrProject mstrProject: allProjectList){
	if(mstrProject.getId().equals(projectId)){
%>
<option value="<%=mstrProject.getId() %>" selected="selected"><%=mstrProject.getPrjName() %></option>
<%}else{ %>
<option value="<%=mstrProject.getId() %>" ><%=mstrProject.getPrjName() %></option>
<%} }%>
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


Iterator itr=fesStudyHeaderList.iterator();
int  counter=0;
while(itr.hasNext())
{


	PrjFesStudyHeader prjFesStudyHeader= (PrjFesStudyHeader)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjFesStudyHeader.getSiteHeader().getId()%>

data_arr[<%= counter%>][1] = '<input name="siteId"  class="radioCheck"  id="rb" type="radio" value="<%=prjFesStudyHeader.getSiteHeader().getId()%>" />';
	

data_arr[<%= counter%>][2] = "<%=prjFesStudyHeader.getSiteHeader().getSiteName()%>";


data_arr[<%= counter%>][3] = "<%=prjFesStudyHeader.getSiteHeader().getSiteCode()%>";

<%if(prjFesStudyHeader.getSiteHeader().getSiteContactNo()!= null){%>
data_arr[<%= counter%>][4] = "<%=prjFesStudyHeader.getSiteHeader().getSiteContactNo()%>";
<%}else{%>
data_arr[<%= counter%>][4] = ""
<%}%>
data_arr[<%= counter%>][5] = "<%= prjFesStudyHeader.getLastChgBy() %>"
<% if(prjFesStudyHeader.getLastChgDate() != null){%>
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(prjFesStudyHeader.getLastChgDate()) %>"
<%}%>
data_arr[<%= counter%>][7] = "<%= prjFesStudyHeader.getLastChgTime() %>"
<%if(prjFesStudyHeader.getSiteHeader().getSiteBranch()!= null){%>
data_arr[<%= counter%>][8] = "<%= prjFesStudyHeader.getSiteHeader().getSiteBranch() %>"
<%}else{%>
data_arr[<%= counter%>][8] = ""
<%}%>
<%if(prjFesStudyHeader.getSiteHeader().getRating()!= null){%>
data_arr[<%= counter%>][9] = "<%= prjFesStudyHeader.getSiteHeader().getRating().getRatingName() %>"
<%}else{%>
data_arr[<%= counter%>][9] = ""
<%}%>
<%if( prjFesStudyHeader.getSiteHeader().getSiteEmailId()!= null){%>
data_arr[<%= counter%>][10] = "<%= prjFesStudyHeader.getSiteHeader().getSiteEmailId() %>"
<%}else{%>
data_arr[<%= counter%>][10] = ""
<%}%>
<% 
if(prjFesStudyHeader.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>
<%

counter++;
}
%>


formName = "siteSetting"

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

