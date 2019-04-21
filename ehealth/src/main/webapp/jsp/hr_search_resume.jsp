<%@page	import="java.util.*,java.util.Collections,java.util.Map,java.util.StringTokenizer,java.util.List,java.util.Iterator,jkt.hrms.recruitment.masters.business.*,jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.*"%>
<%@page import="jkt.hrms.masters.business.MasQualification"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>

<%
Calendar calendar = Calendar.getInstance();
String month = String.valueOf((calendar.get(Calendar.MONTH))+1);
String date  = String.valueOf(calendar.get(Calendar.DATE));
int    year  = calendar.get(calendar.YEAR);
if(month.length()<2)
{
month="0"+month;
}
if(date.length()<2)
{
date="0"+date;
}
%>
<script>serverdate = '<%=date+"/"+month+"/"+year%>'; <!-- This serverdate is being used by calendar.js -->
</script>
<%
Map map = null;
List<Resumepersonaldetails> searchResumeList = null;
List<Users> rmsIdList = null;
List<Resumeskillmaster> skillList = null;
List<Resumestatusmaster> statusMasterList = null;
List<MstrProject> projectList = null;
List<Resumejobprofile> jobProfiles = null;
List<MasQualification> qualificationList = new ArrayList();
List<MasDepartment> departmentList = new ArrayList();
String name = "";
String status= "" ;
String experience ="";
String currentSalary="";
String expectedSalary = "";
String owner = "";
String statusVal="";
int skillId=0;
int counter = 0;
boolean error = false;
String initialPrimarySkills = "";
String primarySkills = "";
String concatPrimarySkills = "";
Integer min = 0;
Integer max = RequestConstants.PAGE_RECORDS;
Integer totalRecords = 0;
Users user = (Users)session.getAttribute("users");
boolean roleFlag = false;
boolean isAdmin = false;
Integer jobProfile = Integer.valueOf(0);
String project = "";
String fromDate = "";
String toDate = "";
if(request.getParameter(RequestConstants.JOBPROFILE)!= null && !request.getParameter(RequestConstants.JOBPROFILE).equals(""))
{
jobProfile = Integer.valueOf(request.getParameter(RequestConstants.JOBPROFILE));
}
if(request.getParameter(RequestConstants.PROJECTNAME)!= null && !request.getParameter(RequestConstants.PROJECTNAME).equals(""))
{
project = request.getParameter(RequestConstants.PROJECTNAME);
}
if(request.getParameter(RequestConstants.FROMDATE)!=null && !request.getParameter(RequestConstants.FROMDATE).equals(""))
{
fromDate=request.getParameter(RequestConstants.FROMDATE);
}
if(request.getParameter(RequestConstants.TODATE)!=null && !request.getParameter(RequestConstants.TODATE).equals(""))
{
toDate=request.getParameter(RequestConstants.TODATE);
}
if(request.getAttribute("map") != null)
{
map = (Map)request.getAttribute("map");
error = (Boolean)map.get("errorSearch");
skillList = (ArrayList<Resumeskillmaster>)map.get("skillList");
statusMasterList = (ArrayList<Resumestatusmaster>)map.get("statusMasterList");
projectList = (List)map.get("projectList");
if(map.get("departmentList")!= null){
	departmentList = (List)map.get("departmentList");
}
jobProfiles = (ArrayList<Resumejobprofile>)map.get("jobProfiles");
statusVal=(String)map.get("statusVal");
if(map.get("roleFlag")!=null)
{
roleFlag = (Boolean)map.get("roleFlag");
}
if(map.get("isAdmin")!=null)
{
isAdmin = (Boolean)map.get("isAdmin");
}
if(map.get("qualificationList")!=null)
{
	qualificationList = (List)map.get("qualificationList");
}
}%>
<script language="javascript">
function setFocusOnPage()
{
if(<%=statusVal.equals("s")%>)
{
var currTabElem = document.getElementById("b1");
currTabElem.setAttribute("class", "enbutton");
currTabElem.setAttribute("className", "enbutton");

currTabElem = document.getElementById("b2");
currTabElem.setAttribute("class", "disbutton");
currTabElem.setAttribute("className", "disbutton");
}
else
{
var currTabElem = document.getElementById("b2");
currTabElem.setAttribute("class", "enbutton");
currTabElem.setAttribute("className", "enbutton");

currTabElem = document.getElementById("b1");
currTabElem.setAttribute("class", "disbutton");
currTabElem.setAttribute("className", "disbutton");
}
}

function showLastFieldss()
{
document.searchResume.<%=RequestConstants.ALLPARAMETER%>.value='<%=request.getParameter(RequestConstants.ALLPARAMETER)%>';
document.searchResume.<%=RequestConstants.ANYPARAMETER%>.value='<%=request.getParameter(RequestConstants.ANYPARAMETER)%>';
document.searchResume.<%=RequestConstants.EXCLUDEPARAMETER%>.value='<%=request.getParameter(RequestConstants.EXCLUDEPARAMETER)%>';
document.searchResume.<%=RequestConstants.FIRSTNAME%>.value='<%=request.getParameter(RequestConstants.FIRSTNAME)%>';
document.searchResume.<%=RequestConstants.LASTNAME%>.value='<%=request.getParameter(RequestConstants.LASTNAME)%>';
document.searchResume.<%=RequestConstants.OPERATOR1%>.value='<%=request.getParameter(RequestConstants.OPERATOR1)%>';
document.searchResume.<%=RequestConstants.EXPERIENCE%>.value='<%if(request.getParameter(RequestConstants.EXPERIENCE)==null){out.print("");}else{out.print(request.getParameter(RequestConstants.EXPERIENCE));}%>';
document.searchResume.<%=RequestConstants.SKILLS%>.value='<%=request.getParameter(RequestConstants.SKILLS)%>';
document.searchResume.<%=RequestConstants.LOCATION%>.value='<%=request.getParameter(RequestConstants.LOCATION)%>';
document.searchResume.<%=RequestConstants.STATUS%>.value='<%=request.getParameter(RequestConstants.STATUS)%>';
document.searchResume.<%=RequestConstants.EDUCATION%>.value='<%=request.getParameter(RequestConstants.EDUCATION)%>';
document.searchResume.<%=RequestConstants.RESUMEID%>.value='<%=request.getParameter(RequestConstants.RESUMEID)%>';
<%String advance = "";
String onsite="";
String archive="";%>
<%if(request.getParameter("enableAdvance")!=null && request.getParameter("enableAdvance").equals("on"))
{
advance = "checked";
}%>
<%if(request.getParameter(RequestConstants.ONSITEAVAILABILITY)!=null && request.getParameter(RequestConstants.ONSITEAVAILABILITY).equals("on"))
{
onsite = "checked";
}%>
<%if(request.getParameter(RequestConstants.ARCHIEVEDRECORDS)!=null && request.getParameter(RequestConstants.ARCHIEVEDRECORDS).equals("on"))
{
archive = "checked";
}%>
}
function showLastFieldsas()
{
document.searchResume.<%=RequestConstants.ALLPARAMETER%>.value='<%=request.getParameter(RequestConstants.ALLPARAMETER)%>';
document.searchResume.<%=RequestConstants.ANYPARAMETER%>.value='<%=request.getParameter(RequestConstants.ANYPARAMETER)%>';
document.searchResume.<%=RequestConstants.EXCLUDEPARAMETER%>.value='<%=request.getParameter(RequestConstants.EXCLUDEPARAMETER)%>';
}		

function hideParameter()
{
if(document.searchResume.enableAdvance.checked==false)
{
document.getElementById("lbAll").style.visibility = "hidden";
document.getElementById("lbAny").style.visibility = "hidden";
document.getElementById("lbExclude").style.visibility = "hidden";
document.getElementById("txtAll").style.visibility = "hidden";
document.getElementById("txtAny").style.visibility = "hidden";
document.getElementById("txtExclude").style.visibility = "hidden";
checkValue=false;
}	
else
{
document.getElementById("lbAll").style.visibility = "visible";
document.getElementById("lbAny").style.visibility = "visible";
document.getElementById("lbExclude").style.visibility = "visible";
document.getElementById("txtAll").style.visibility = "visible";
document.getElementById("txtAny").style.visibility = "visible";
document.getElementById("txtExclude").style.visibility = "visible";
checkValue=true;
}
}	
function validateAndSub()
{
if(document.advsearchResume.<%=RequestConstants.ALLPARAMETER%>.value==""
&& document.advsearchResume.<%=RequestConstants.ANYPARAMETER%>.value==""
&& document.advsearchResume.<%=RequestConstants.EXCLUDEPARAMETER%>.value=="")
{
alert("Please select Any Search Criteria");
return false;
}
else
{			
submitForm('advsearchResume','/hms/hrms/resume?method=searchResume&statusVal=<%=statusVal%>'+'&checkValue='+ 'false');
}
}
function enableCheck()
{
document.searchResume.enableAdvance.checked=true;
document.getElementById("lbAll").style.visibility = "visible";
document.getElementById("lbAny").style.visibility = "visible";
document.getElementById("lbExclude").style.visibility = "visible";
document.getElementById("txtAll").style.visibility = "visible";
document.getElementById("txtAny").style.visibility = "visible";
document.getElementById("txtExclude").style.visibility = "visible";
showLastFieldsas();
}
checkValue=<%=session.getAttribute("checkValue")%>;
</script>
<div class="titleBg">
<h2>Search Resume</h2>
</div>
<div class="clear"></div>
<!--tab content starts-->
<div id="countrytabs">
<label><a href="#" rel="country1" class="selected">Search</a></label> 
<label><a href="#" rel="country2">Advance Search</a></label></div>
<div class="tabcontainer"><!---Search Starts--->
<div id="country1" class="tabcontent">
<form name="searchResume" action="" method="post">
<div class="clear"></div>
<h4>Search</h4>
<div class="clear"></div>
<% if(statusVal.equalsIgnoreCase("s"))
{     
%>
<div id="all" style="display: block">
<%
String flag = "";
if(request.getParameter("flag") != null)
{
flag = (String)request.getParameter("flag");
}
String showAllResume =(String)session.getAttribute("showAllResume");
if(showAllResume == null || showAllResume.equals("") ||flag.equals("true"))
{%> <a href='#' onclick="showallresumes(); return false">Show All
Resumes</a> <%}%>
</div>
<div class="clear"></div>
<label>First Name</label> <input type="text"
	name="<%=RequestConstants.FIRSTNAME%>" value=""
	validate="First Name,name,no" maxlength="25" /> <label>Last
Name</label> <input type="text" name="<%=RequestConstants.LASTNAME%>" value=""
	validate="Last Name,char,no" maxlength="25" /> <label>Resume
ID</label> <input type="text" name="<%=RequestConstants.RESUMEID%>" value=""
	validate="Resume Id,int,no" maxlength="25" />
<div class="clear"></div>
<label>Status</label> <select name="<%=RequestConstants.STATUS%>">
	<option value="">Select</option>
	<% for(Resumestatusmaster resumeStatusMaster : statusMasterList)
{
status=resumeStatusMaster.getStatusDesc();
if(!(status.equalsIgnoreCase("Backed Out")))
{ %>
	<option value="<%=resumeStatusMaster.getId()%>"><%=resumeStatusMaster.getStatusDesc()%></option>
	<%}
}%>
</select> <label>Role/Designation</label> <select
	name="<%=RequestConstants.JOBPROFILE%>">
	<option value="">Select</option>
	<%for(Resumejobprofile job : jobProfiles)
{
if(jobProfile.equals(job.getId()))
{%>
	<option value="<%=job.getId()%>" selected="selected"><%=job.getJobProfile() %></option>
	<%}else {%>
	<option value="<%=job.getId()%>"><%=job.getJobProfile() %></option>
	<%}
} %>
</select> 
<label id="se">By Education</label> <select id="ee"
	name="<%=RequestConstants.EDUCATION%>"
	validate="Highest Degree,string,no">
	<option value="">Select</option>
	<%for(MasQualification qualification:qualificationList){ %>
	<option value="<%=qualification.getQualificationName() %>"><%= qualification.getQualificationName()%></option>
	<%} %>
</select>
<div class="clear"></div>
<label>Experience</label> <select name=<%=RequestConstants.OPERATOR1%>
	onchange="enableExp(this.value)" class="smallest">
	<option value="" selected>Select</option>
	<option value="1">&lt</option>
	<option value="2">&gt</option>
	<option value="3">=</option>
</select> 
<label >years</label>
<select name="<%=RequestConstants.EXPERIENCE%>" enabled="true"	class="smallest">
	<option value="" selected>Select</option>
	<%for(int i = 1; i <=30; i++)
{%>
	<option value="<%=i%>"><%=i%></option>
	<% }%>
</select> 
<label>Location</label> 
<input type="text" name="<%=RequestConstants.LOCATION%>" value="" validate="Location,alphaspace,no" maxlength="30" /> 
<div class="clear"></div>
 <label>Primary Skills</label> <select
	name="<%=RequestConstants.SKILLS%>">
	<option value="">Select</option>
	<%	for(Resumeskillmaster skillMaster: skillList)
{
if(skillMaster.getSkillParent()==0)
{%>
	<option value="<%=skillMaster.getId()%>"><%=skillMaster.getSkillDesc()%></option>
	<%	 	}	
}
%>
</select> <label>Department</label> <select
	name="<%=RequestConstants.DEPARTMENT_ID%>">
	<option value="">Select</option>
	<%for(MasDepartment masDepartment: departmentList)
	{%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%     
	}%>
</select>
<label>From Date</label> 
<%--  </!><input type="text" name="<%=RequestConstants.FROMDATE %>" readonly="readonly" value="<%=fromDate%>"	
validate="From Date,dateOfInterview,no" class="date" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
onclick="javascript:setdate('',document.searchResume.<%=RequestConstants.FROMDATE %>,event)" />--%>
<input type="text" name="<%=RequestConstants.FROMDATE %>"  
value="<%=fromDate%>"  maxlength="6" class="date"  validate="From Date,dateOfInterview,no"/>
<img id="" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" 
onclick="setdate('',document.searchResume.<%=RequestConstants.FROMDATE %>,event)" 
validate="Pick a date"  tabindex="14" />
<div class="clear"></div>

<label>To Date</label> 
<%--<input type="text" name="<%=RequestConstants.TODATE %>" class="date" readonly="readonly"
value="<%=toDate%>" validate="To Date,dateOfInterview,no" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
onclick="javascript:setdate('',document.searchResume.<%=RequestConstants.TODATE%>,event)" />
--%>
<input type="text" name="<%=RequestConstants.TODATE %>"  
value="<%=toDate%>"  maxlength="6" class="date"  validate="To Date,dateOfInterview,no"/>
<img id="" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" 
onclick="setdate('',document.searchResume.<%=RequestConstants.TODATE %>,event)" 
validate="Pick a date"  tabindex="14" />
<div class="clear"></div>
<label>Onsite Availability</label> <label class="value"> <input
	type="checkbox" name="<%=RequestConstants.ONSITEAVAILABILITY %>"
	class="radioCheck" <%=onsite %> /> </label> <label>Archived Records</label> <label
	class="value"> <input type="checkbox"
	name="<%=RequestConstants.ARCHIEVEDRECORDS %>" class="radioCheck"
	<%=archive %> /> </label> <label>Advance Search</label> <label class="value">
<input type="checkbox" name="enableAdvance" class="radioCheck"	onclick="hideParameter()" <%=advance %> /> </label>
<div class="clear"></div>
<label id="lbAll" style="visibility: hidden;">All (in Resume)</label>
<input type="text" style="visibility: hidden;" id="txtAll" name="<%=RequestConstants.ALLPARAMETER%>" value="" maxlength="50" /> 
<label id="lbAny" style="visibility: hidden;">Any (in Resume)</label> 
<input type="text" style="visibility: hidden;" id="txtAny" name="<%=RequestConstants.ANYPARAMETER%>" value="" maxlength="50" /> 
<label id="lbExclude" style="visibility: hidden;">Exclude (in Resume)</label>
<input type="text" style="visibility: hidden;" id="txtExclude"	name="<%=RequestConstants.EXCLUDEPARAMETER%>" value="" maxlength="50" />
<div class="clear"></div>
<input type="button" name="Search" value="Search" class="button" onclick="submitForm('searchResume','/hms/hrms/resume?method=searchResume&statusVal=<%=statusVal%>','validateCriteria')" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Reset" value="Reset" class="buttonHighlight"	onclick="resetForm()" />
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<!---Search Ends---> <script>
document.searchResume.<%=RequestConstants.FIRSTNAME%>.focus();	
</script> <!---Advance Search Starts--->

<div id="country2" class="tabcontent">
<form name="advsearchResume" action="" method="post">
<div class="clear"></div>
<h4>Advanced Search</h4>
<div class="clear"></div>
<div class="Block"><label>All (in Resume)</label> <input
	type="text" id="txtAll" name="<%=RequestConstants.ALLPARAMETER%>"
	value="" maxlength="50" /> <label>Any (in Resume)</label> <input
	type="text" id="txtAny" name="<%=RequestConstants.ANYPARAMETER%>"
	value="" maxlength="50" /> <label>Exclude (in Resume)</label> <input
	type="text" id="txtExclude"
	name="<%=RequestConstants.EXCLUDEPARAMETER%>" value="" maxlength="50" />
<div class="clear"></div>
<input type="button" name="Search" value="Search" class="button"
	onclick="validateAndSub()" /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<%	} 				
if (error)
{ %>
<h4>Records Not Found!</h4>


<script>
<!-- showLastFieldss();-->
</script> <%}
else { %> <script>
<!-- showLastFieldsas();-->
</script> <% }
 %> <%
if(session.getAttribute("checkValue")!=null && (Boolean)session.getAttribute("checkValue"))
{
%> <script>
	enableCheck();
	</script> <% }%>
</div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>

<!---Advance Search Ends---></div>


<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("label") //"link" or "linkparent"
countries.init()

</script>


<!--tab content ends-->

<div class="clear"></div>




<div id="searchresults" style="display: none">
<form name="searchResults" action="" method="post">
<% if(request.getAttribute("map") != null)
{	
session.setAttribute("searchMap", map);
map=(Map)request.getAttribute("map");
searchResumeList = (List)map.get("searchResumeList");
skillList = (List)map.get("skillList");
totalRecords = (Integer)map.get("totalRecords");
if(totalRecords==null)
totalRecords=0;

if(map.get("rmsIdList") != null){
rmsIdList = (List)map.get("rmsIdList");
}
min = (Integer)map.get("min");
max = (Integer)map.get("max");
if(min==null)
min=0;
if(max==null)
max=0;
}
if(searchResumeList != null )
{
if(statusVal.equalsIgnoreCase("s"))
{
%> <script>
document.searchResume.<%=RequestConstants.FIRSTNAME%>.value='<%=request.getParameter(RequestConstants.FIRSTNAME)%>';
document.searchResume.<%=RequestConstants.LASTNAME%>.value='<%=request.getParameter(RequestConstants.LASTNAME)%>';
document.searchResume.<%=RequestConstants.OPERATOR1%>.value='<%=request.getParameter(RequestConstants.OPERATOR1)%>';
document.searchResume.<%=RequestConstants.EXPERIENCE%>.value='<%if(request.getParameter(RequestConstants.EXPERIENCE)==null){out.print("");}else{out.print(request.getParameter(RequestConstants.EXPERIENCE));}%>';
document.searchResume.<%=RequestConstants.SKILLS%>.value='<%=request.getParameter(RequestConstants.SKILLS)%>';
document.searchResume.<%=RequestConstants.LOCATION%>.value='<%=request.getParameter(RequestConstants.LOCATION)%>';
document.searchResume.<%=RequestConstants.STATUS%>.value='<%=request.getParameter(RequestConstants.STATUS)%>';
document.searchResume.<%=RequestConstants.EDUCATION%>.value='<%=request.getParameter(RequestConstants.EDUCATION)%>';

document.getElementById("searchresults").style.display="block";

if(document.searchResume.<%=RequestConstants.ALLPARAMETER%>.value !="" || document.searchResume.<%=RequestConstants.ANYPARAMETER%>.value!="" || document.searchResume.<%=RequestConstants.EXCLUDEPARAMETER%>.value!="")
{
enableCheck();
}

</script> <% }
else if(statusVal.equalsIgnoreCase("as"))
{%> <script>
document.searchResume.<%=RequestConstants.ALLPARAMETER%>.value='<%=request.getParameter(RequestConstants.ALLPARAMETER)%>';
document.searchResume.<%=RequestConstants.ANYPARAMETER%>.value='<%=request.getParameter(RequestConstants.ANYPARAMETER)%>';
document.searchResume.<%=RequestConstants.EXCLUDEPARAMETER%>.value='<%=request.getParameter(RequestConstants.EXCLUDEPARAMETER)%>';

</script> <%}	

if(totalRecords > RequestConstants.PAGE_RECORDS)
{%> <a href='#' onClick="checkFirst()"> First Page </a>&nbsp;&nbsp;&nbsp;
<% if( min != 0 ) {  %> <a href='#'
	onClick="submitForm('searchResume','search','/jktintranet/jkt/resume?method=paging&min=<%= min - RequestConstants.PAGE_RECORDS %>&max=<%= min %>')">
Previous Page </a>&nbsp;&nbsp;&nbsp; <% } if( max < totalRecords) {  %> <a
	href='#'
	onClick="submitForm('searchResume','search','/jktintranet/jkt/resume?method=paging&min=<%= max  %>&max=<%= max + RequestConstants.PAGE_RECORDS  %>')">
Next Page </a>&nbsp;&nbsp;&nbsp; <%  } %> <a href='#' onClick="checkLast()">
Last Page </a> <%}
if(searchResumeList.size() >= 1 )
{ %> <script>
document.getElementById("searchresults").style.display="block";
</script> <% if(roleFlag){%> <%}%>

<div class="clear"></div>
<label><a>Total Records <%= totalRecords%></a></label>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table width="100%" cellpadding="0" cellspacing="0" name="resume">
	<tr>
		<th><input type="checkbox" name="allIds" value="yes"
			onClick="checkAll()" class="radioCheck" /></th>
		<th>Resume Id</th>
		<th>Request Id</th>
		<th>Candidate's Name</th>
		<th>Present Location</th>
		<th>Exp(in yrs)</th>
		<th>Primary Skills</th>
		<th>Status</th>
	</tr>

	<%}%>
	<tbody id="searchresulttable">
		<%	int resumeStatusId=0;
Integer preResumeID = null;
int counterBgColor = 0;
for(Resumepersonaldetails resumepersonaldetails : searchResumeList)
{
Integer currentResumeID =  resumepersonaldetails.getId();
String emailId = resumepersonaldetails.getEmailId();
name = resumepersonaldetails.getFirstName()+" "+resumepersonaldetails.getMiddleName()+" "+resumepersonaldetails.getLastName();

experience = resumepersonaldetails.getExperienceYear()+"."+resumepersonaldetails.getExperienceMonth();
currentSalary = resumepersonaldetails.getCurrentCtc();
expectedSalary = resumepersonaldetails.getExpectedCtc();
owner = resumepersonaldetails.getAddResumeBy().getUserName();
boolean addFlag = false;


if(resumepersonaldetails.getAssignedTo() != null){
if(resumepersonaldetails.getAssignedTo().equals(user.getId())){
addFlag = true;
}
else
addFlag = false; 				 	 
}	
else if(resumepersonaldetails.getAddBy() != null) {
if(resumepersonaldetails.getAddBy().equals(user.getId())){
addFlag = true;
}
else
addFlag = false; 
}

for(Resumestatusmaster resumeStatusMaster : statusMasterList)
{
int resumeStatusMasterId=resumeStatusMaster.getId();
resumeStatusId=resumepersonaldetails.getResumeStatus().getStatusId();
if(resumeStatusMasterId == resumeStatusId)
{
status = resumeStatusMaster.getStatusDesc();
break;
}
}

if(resumeStatusId==13)
{
	//status = "waiting for joining approval";
}
primarySkills = "";
initialPrimarySkills = "";
int skillLoop=0;
for (Iterator personalDetailsIterator = resumepersonaldetails.getResumeSkill().iterator(); personalDetailsIterator.hasNext();) 
{
Resumeskill resumeskill = (Resumeskill) personalDetailsIterator.next();
if(resumeskill.getSkillType().equals("Primary"))
{
skillId = resumeskill.getSkillId();
for(Iterator iter1=skillList.iterator(); iter1.hasNext();)
{
Resumeskillmaster skillMaster = (Resumeskillmaster)iter1.next();
if(skillId == skillMaster.getId())
{
	concatPrimarySkills = primarySkills.concat(skillMaster.getSkillDesc()).concat(",");
	if(skillLoop<3)
	{
		initialPrimarySkills=concatPrimarySkills;
		skillLoop++;
	}
	primarySkills = concatPrimarySkills;
}
}
}
}
if(primarySkills.length() > 0)
{
initialPrimarySkills = initialPrimarySkills.substring(0,initialPrimarySkills.length() - 1);
primarySkills = primarySkills.substring(0,primarySkills.length() - 1);
}

Resumeremarks resumeRemarks=null;
for (Iterator iter = resumepersonaldetails.getResumeRemarks().iterator(); iter.hasNext();) {
resumeRemarks = (Resumeremarks)iter.next();
}
String remarks="";
String fullRemarks="";
if(resumeRemarks!=null && resumeRemarks.getRemarks().length()>20)
{
remarks = remarks.concat(resumeRemarks.getRemarks().substring(0,20));
remarks = remarks.concat("...");
}
else if(resumeRemarks !=null){
remarks = remarks.concat(resumeRemarks.getRemarks());
}
else 
remarks = ""; 
fullRemarks = fullRemarks.concat(resumeRemarks.getRemarks());
fullRemarks = fullRemarks.concat("\n\n");
fullRemarks = fullRemarks.concat("Added By: ");
fullRemarks = fullRemarks.concat(resumeRemarks.getRemarksBy());
fullRemarks = fullRemarks.concat("\n");
fullRemarks = fullRemarks.concat("Added On: ");
fullRemarks = fullRemarks.concat(HMSUtil.convertDateToStringTypeDate(resumeRemarks.getDateRemarks()));
counterBgColor++;
%>

		<%if(!status.equals("Blacklisted"))
{
if(counterBgColor %2 == 0)
{%>
		<tr class="even">
			<%}	else{%>

			<tr class="odd">
				<%}
}else{%>

				<tr class="black">
					<%} %>
					<%if(!status.equals("Blacklisted")){%>
					<td><input type="checkbox" name="id<%=counter%>"
						value="<%=currentResumeID%>" onClick="unCheck(this)"
						class="radioCheck" /></td>
					<%}else{	%>
					<td><input type="checkbox" name="id<%=counter%>"
						value="<%=currentResumeID%>" class="radioCheck" disabled="true" /></td>
					<%}%>
					<% String city = "--";
if(resumepersonaldetails.getCity()!= null)
{
city = resumepersonaldetails.getCity().getDistrictName();
}

String requisitionId = "--";
if(resumepersonaldetails.getResourceRequisition()!= null)
{
	requisitionId = resumepersonaldetails.getResourceRequisition().getId().toString();
}
%>
					<td
						onClick="location.href='/hms/hrms/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><%=currentResumeID%></td>
					<td
						onClick="location.href='/hms/hrms/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><%=requisitionId%></td>
					<td
						onClick="location.href='/hms/hrms/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><%=name%></td>
					<td
						onClick="location.href='/hms/hrms/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><%=city%></td>
					<td
						onClick="location.href='/hms/hrms/resume?method=viewResume&resumeID=<%=currentResumeID%>'"><%=experience%></td>
					<td
						onClick="location.href='/hms/hrms/resume?method=viewResume&resumeID=<%=currentResumeID%>'"
						title="<%=primarySkills%>"><%=initialPrimarySkills%></td>
					<td
						onClick="location.href='/hms/hrms/resume?method=viewResume&resumeID=<%=currentResumeID%>'"
						name='status<%=counter%>'><%=status%></td>
				</tr>
				<%++counter;
}	
}	%>
			
	</tbody>
</table>
<script>
		var pager = new Pager('searchresulttable',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
</script>
<div class="paddingTop15"></div>

<div class="Block"><label> Mail Subject</label> <input
	name=<%=RequestConstants.MAIL_SUBJECT%> value="" type="text"
	validate="Mail Subject,alphaspace,no" maxlength="50" />
<div class="clear"></div>
<label> Mail Text</label> <textarea
	name="<%=RequestConstants.MAIL_BODY%>"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="2000" class="medium"></textarea>
<div class="clear"></div>
<div id="messagebar"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="ExcelReport" value="Excel Report"
	class="buttonBig" onClick="generateExcel()" /> <input type="button"
	name="mail" value="Broadcast" class="buttonBig"
	onClick="submitForm('searchResults','/hms/hrms/resume?method=broadcastMail&listSize=<%=counter%>','chkCheckBoxes')" />

<!--  <input type="button" name="shortlist" value="Shortlist" class="button" onClick="checkStatus()" >-->

<%if(isAdmin && !(request.getParameter(RequestConstants.STATUS).equalsIgnoreCase("Joined"))){ %>
<input type="button" name="ChangeOwner" value="Change Owner"
	class="button"
	onClick="submitForm('searchResults','searchresults','/jktintranet/jkt/resume?method=showChangeOwner&listSize=<%=counter%>','chkCheckBoxesForAuthorization')">
<%} %>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
</div>



<script>
hideParameter();
</script>

<script type="text/javascript">
function validateCriteria()
{
if(document.searchResume.<%=RequestConstants.FIRSTNAME%>.value == '' 
&& document.searchResume.<%=RequestConstants.LASTNAME%>.value == '' 
&& document.searchResume.<%=RequestConstants.OPERATOR1%>.value == ''
&& document.searchResume.<%=RequestConstants.EXPERIENCE%>.value == '' 
&& document.searchResume.<%=RequestConstants.SKILLS%>.value == ''
&& document.searchResume.<%=RequestConstants.LOCATION%>.value == ''
&& document.searchResume.<%=RequestConstants.STATUS%>.value == ''
&& document.searchResume.<%=RequestConstants.EDUCATION%>.value==''
&& document.searchResume.<%=RequestConstants.ALLPARAMETER%>.value==''
&& document.searchResume.<%=RequestConstants.ANYPARAMETER%>.value==''
&& document.searchResume.<%=RequestConstants.RESUMEID%>.value==''
&& document.searchResume.<%=RequestConstants.EXCLUDEPARAMETER%>.value==''
&& document.searchResume.<%=RequestConstants.FROMDATE%>.value==''
&& document.searchResume.<%=RequestConstants.TODATE%>.value==''
&& document.searchResume.<%=RequestConstants.JOBPROFILE%>.value==''
&& document.searchResume.<%=RequestConstants.DEPARTMENT_ID%>.value==''
&& document.searchResume.<%=RequestConstants.ONSITEAVAILABILITY%>.checked==false)
{
errorMsg += "Please select Any Search Criteria"
return false;
}
return true;
}

function resetForm()
{
document.searchResume.reset();
document.searchResume.<%=RequestConstants.FIRSTNAME%>.value = '';
document.searchResume.<%=RequestConstants.LASTNAME%>.value = '';
document.searchResume.<%=RequestConstants.OPERATOR1%>.value = '';
document.searchResume.<%=RequestConstants.EXPERIENCE%>.value = '';
document.searchResume.<%=RequestConstants.SKILLS%>.value = '';
document.searchResume.<%=RequestConstants.LOCATION%>.value = '';
document.searchResume.<%=RequestConstants.STATUS%>.value = '';
document.searchResume.<%=RequestConstants.ALLPARAMETER%>.value = '';
document.searchResume.<%=RequestConstants.ANYPARAMETER%>.value = '';
document.searchResume.<%=RequestConstants.EXCLUDEPARAMETER%>.value = '';
document.searchResume.<%=RequestConstants.JOBPROFILE%>.value = '';
document.searchResume.<%=RequestConstants.RESUMEID%>.value = '';
document.searchResume.<%=RequestConstants.FROMDATE%>.value = '';
document.searchResume.<%=RequestConstants.TODATE%>.value = '';

hideParameter();
}
function showallresumes() 
{
var a ='';
if(document.searchResume.<%=RequestConstants.ARCHIEVEDRECORDS%>.checked)
{
a='on';
}
resetForm();
if(a == 'on')
{
document.searchResume.<%=RequestConstants.ARCHIEVEDRECORDS%>.checked = true ;
}
document.searchResume.action = "/hms/hrms/resume?method=searchResume&showAllResume=All&statusVal=<%=statusVal%>"+"&checkValue="+ checkValue;
document.searchResume.submit();
}



function generateExcel()
{
inps = document.getElementsByTagName('input');
for(i=0;i<inps.length;i++)
{
if(inps[i].type == 'checkbox' && inps[i].name != "allIds" &&  inps[i].name != "enableAdvance")
{
if(inps[i].disabled)
{
inps[i].disabled=false;
}
}
}
for(i=0;i<inps.length;i++)
{
if(inps[i].type == 'checkbox' && inps[i].name != "allIds" &&  inps[i].name != "enableAdvance")
{
if(inps[i].checked)
{
flag=true;
break;
}
if(inps[i].disabled)
{
inps[i].disabled=false;
}
else
{
flag=false;
}
}
}
if(!flag)
{
alert("Please select one of the candidate. \n");
return false;
}
else 
{
document.searchResults.action = "/hms/hrms/resume?method=searchResumeExcelReport";
document.searchResults.target="_blank";
document.searchResults.submit();
}
document.searchResults.target="_self";
return true;
}

function searchResultDisplay()
{
document.getElementById("searchresults").style.display = "none";
document.searchResume.<%=RequestConstants.FIRSTNAME%>.focus();	
}

function checkedId(obj)
{
inps = document.getElementsByTagName('input')
if(document.searchResults.allIds.checked)
{
for(i=0;i<inps.length;i++)
{
if(inps[i].type == 'checkbox' && inps[i].name != "allIds")
{
inps[i].checked=true;
}			
}
}
else
{
for(i=0;i<inps.length;i++)
{
if(inps[i].type == 'checkbox' && inps[i].name != "allIds")
{
inps[i].checked=false;
}			
}
} 
}
function enableExp( strValue )
{
if(strValue !='')
{	
document.searchResume.<%=RequestConstants.EXPERIENCE%>.disabled = false;
return true;
}
else
{
document.searchResume.<%=RequestConstants.EXPERIENCE%>.disabled = true;
document.searchResume.<%=RequestConstants.EXPERIENCE%>.value = '';
return true;
}
}

function chkCheckBoxes()
{
inps = document.getElementsByTagName('input')
flag=true;
for(i=0;i<inps.length;i++)
{
if(inps[i].type == 'checkbox' && inps[i].disabled == false && inps[i].name != "allIds" && inps[i].name != "<%=RequestConstants.ONSITEAVAILABILITY%>" && inps[i].name != "<%=RequestConstants.ARCHIEVEDRECORDS%>" && inps[i].name!="enableAdvance")
{
if(document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').substring(document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').length-2)=='no')
{
document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.setAttribute('validate',document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').substring(0,document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').length-2)+'yes')
}
if(inps[i].name!= "enableAdvance" && inps[i].checked)
{
flag=false;
break;
}
}
}
if(flag)
{
errorMsg+= "Please select one of the candidate. \n";
return false;
}
return true;
}
function chkCheckBoxesForAuthorization()
{
if(document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').substring(document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').length-3)=='yes'){
document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.setAttribute('validate',document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').substring(0,document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').length-3)+'no')
}
inps = document.getElementsByTagName('input');
flag=false;
for(i=0;i<inps.length;i++)
{
if(inps[i].type == 'checkbox' && inps[i].name != "allIds" && inps[i].name != "<%=RequestConstants.ONSITEAVAILABILITY%>" && inps[i].name != "<%=RequestConstants.ARCHIEVEDRECORDS%>" && inps[i].name!="enableAdvance")
{
if(inps[i].checked)
{
name = 'status' + i;
flag=true;
	
break;
}
}
}
if(!flag)
{
errorMsg +="Please select one of the candidate.";
return false;
}
return true;
}

function checkAllIds(obj)
{
if(document.searchResults.allIds.checked)
{
alert('All ids are selected for Report Generation');
obj.checked=true;
}	
}

function advanceSearch()
{
submitForm('searchResume','/hms/hrms/resume?method=showSearchPage&statusVal=as');
}

function simpleSearch()
{
submitForm('searchResume','/hms/hrms/resume?method=showSearchPage&statusVal=s');
}
function checkAll()
{
var no = <%=counter%>;

for(i=0;i<no;i++)
{
var obj = "document.searchResults." + "id" +i;
obj=eval(obj);
if(obj.disabled==true)
{
}
else
{
if(document.searchResults.allIds.checked==true)
{
obj.checked=true;
}
else
{
obj.checked=false;
}
}
}
}
function checkFirst()
{
if(<%=min==0%>)
{
alert("You are already on the first page");
}
else
{
submitForm('searchResume','search','/jktintranet/jkt/resume?method=paging&min=0&max=<%= RequestConstants.PAGE_RECORDS %>');
}
}
function checkLast()
{
if(<%= max>=totalRecords %>)
{
alert("You are already on the Last page");
}
else
{
submitForm('searchResume','search','/jktintranet/jkt/resume?method=paging&min=<%= totalRecords % RequestConstants.PAGE_RECORDS == 0 ? totalRecords - RequestConstants.PAGE_RECORDS : totalRecords - totalRecords % RequestConstants.PAGE_RECORDS %>&max=<%= totalRecords  %>');
}
}

function unCheck(obj)
{
if(obj.checked==false)
{
document.searchResults.allIds.checked=false;
}
}

function changeAssignedTo()
	{
	if(document.searchResults.assignedTo.value == "")
	{
	errorMsg += "First Select Any Authority Member. \n";
	return false;	
	}
	checkCCList();
	return true;
	}
	
function checkCCList()
{
	var myString = document.searchResults.<%=RequestConstants.CCLIST%>.value;
	var ccArray = myString.split(",");
	if(myString != null && myString!="")
	{
	for(var i=0;i<ccArray.length;i++)
		{
		if(!validateEmail(ccArray[i]))
		{
		errorMsg +="Please Enter the valid CC List. \n";
		return false;
		}
	}
	}
}

function checkStatus()
{
	submitForm('searchResults','/hms/hrms/resume?method=showShortListResumeJsp','chkCheckBoxesForAuthorization');
}
</script>