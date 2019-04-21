<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hrms.recruitment.masters.business.*"%>
<%@page import="jkt.hms.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%	
Map map=(Map)request.getAttribute("map");
List<Resumeskillmaster> skillMasterList=(List<Resumeskillmaster>)map.get("skillMasterList");
List<MasCountry> countryList = (List<MasCountry>)map.get("countryList");
List<Resumestatusmaster> statusMasterList = (List<Resumestatusmaster>)map.get("statusMasterList");
List<Resumepersonaldetails> resumeList = (List<Resumepersonaldetails>)map.get("resumeList");
List<Resumedudetail> duList = (List<Resumedudetail>)map.get("duList");
List<Resumeprojectsdetail> projectDetails = (List<Resumeprojectsdetail>)map.get("projectDetails");
List<MasRank> jobProfiles = (List<MasRank>)map.get("jobProfiles");
String errorString = (String)map.get("errorString");
String status = "";
int skillId=0;
String primarySkills = "";
String concatPrimarySkills = "";
String initialPrimarySkills ="";
%>
<%@page import="jkt.hrms.masters.business.MasQualification"%>
<%@page import="java.util.ArrayList"%>
<script>
<%	Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String date=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(date.length()<2){
date="0"+date;
}
%>
serverdate = '<%=date+"/"+month+"/"+year%>'
date1 = '<%=date+"/"+month+"/"+year%>'
</script>
<div class="titleBg">
<div class="floatRight">Fields marked with <span>*</span> are
mandatory&nbsp;&nbsp;</div>
<h2>Add Resume</h2>
</div>

<%if(!errorString.equals("Verified")){
String firstName = "";
String lastName  = "";
String emailId   = "";
String resumeThrough="";
String dateOfBirth ="";
String currentEmployer ="";
String previousEmployer="";
String passportNumber="";
if(map!=null)
{
if(map.get("firstName")!=null)
{
firstName =(String)map.get("firstName");
}
if(map.get("lastName")!=null)
{
lastName =(String)map.get("lastName");
}
if(map.get("emailId")!=null)
{
emailId =(String)map.get("emailId");
}
if(map.get("dateOfBirth")!=null)
{
dateOfBirth = (String)map.get("dateOfBirth");					
}
if(map.get("resumeThrough")!=null)
{
resumeThrough = (String)map.get("resumeThrough");
}
if(map.get("currentEmployer")!=null)
{
currentEmployer = (String)map.get("currentEmployer");
}
if(map.get("previousEmployer")!=null)
{
previousEmployer = (String)map.get("previousEmployer");
}
if(map.get("passportNumber")!=null)
{
passportNumber = (String)map.get("passportNumber");
}
}
%>
<div class="clear"></div>
<form name="addresume" action="" method="post"
	enctype="multipart/form-data"
	onsubmit="return validateName('checkEmail11')">
<div class="Block"><label><span>*</span> Resume Through</label> <select
	name="<%=RequestConstants.RESUMETHROUGHVERIFICATION %>" value=""
	onChange="changeView()" validate="Resume Through,string,no">
	<option value="Direct"
		<%if(resumeThrough.equalsIgnoreCase("Direct")){%> selected <%}%>>Direct</option>
	<option value="Job Portal"
		<%if(resumeThrough.equalsIgnoreCase("Job Portal")){%> selected <%}%>>Job
	Portal</option>
	<option value="Placement Consultancy"
		<%if(resumeThrough.equalsIgnoreCase("Placement Consultancy")){%>
		selected <%}%>>Placement Consultancy</option>
	<option value="Advertisement"
		<%if(resumeThrough.equalsIgnoreCase("Advertisement")){%> selected
		<%}%>>Advertisement</option>
	<option value="Internal Reference"
		<%if(resumeThrough.equalsIgnoreCase("Internal Reference")){%> selected
		<%}%>>Employee Reference</option>
</select> <label><span>*</span> First Name</label> <input type="text"
	name="<%=RequestConstants.FIRSTNAMEFORVERIFICATION%>"
	value="<%=firstName %>" validate="FirstName,char,yes" maxlength="25"
	enabled="true" /> <label><span>*</span> Last Name</label> <input
	type="text" name="<%=RequestConstants.LASTNAMEFORVERIFICATION%>"
	value="<%=lastName %>" validate="LastName,char,yes" maxlength="25"
	enabled="true" />

<div class="clear"></div>

<label><span>*</span> Date of Birth</label> <input type="text" id="dob"
	name="<%=RequestConstants.DATEOFBIRTHFORVARIFICATION%>" class="date"
	value="<%=dateOfBirth %>" validate="Date Of Birth,dobHRMS,yes"
	tabindex="500" readonly /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('',document.addresume.<%=RequestConstants.DATEOFBIRTHFORVARIFICATION%>,event)" />

<label><span>*</span> Email Id</label> <input type="text"
	name="<%=RequestConstants.EMAILIDFORVERIFICATION%>"
	value="<%=emailId %>" validate="Email Id,email,yes" maxlength="50"
	enabled="true" /> <label><span>*</span> Current Employer</label> <input
	type="text" name="<%=RequestConstants.CURRENTEMPLOYERFORVERIFICAITON%>"
	value="<%=currentEmployer%>"
	validate="Current Employer,resumeCompany,yes" maxlength="50"
	enabled="true" />

<div class="clear"></div>

<label>Previous Employer</label> <input type="text"
	name="<%=RequestConstants.PREVIOUSEMPLOYERFORVERIFICATION%>"
	value="<%=previousEmployer%>"
	validate="Previous Employer,resumeCompany,no" maxlength="50"
	enabled="true" /> <label>Passport Number</label> <input type="text"
	name="<%=RequestConstants.PASSPORTNUMBERFORVERIFICATION%>"
	value="<%=passportNumber %>" validate="Passport Number,passport,no"
	enabled="true" maxlength="8" />


<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="submit" name="verify1" value="Verify" class="button" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%}
if(errorString != null && !errorString.equals(""))
{%>

<h4><%=errorString%></h4>
<div class="clear"></div>
<%if( resumeList != null && resumeList.size() >= 1) { %>
<div id="resumelist" style="display: none">

<table width="100%" cellpadding="0" cellspacing="0">
	<tr>
		<th>Resume ID</th>
		<th>Candidate's Name</th>
		<th>Present Location</th>
		<th>Years of Experience</th>
		<th>Current Employer</th>
		<th>Current CTC</th>
		<th>Expected CTC</th>
		<th>Primary Skills</th>
		<th>Remarks</th>
		<th>Status</th>
	</tr>

	<%int resumeStatusId=0;
int counterBgColor = 0;
for(Resumepersonaldetails resumepersonaldetails : resumeList)
{
primarySkills = "";
int skillLoop=0;
for (Resumeskill resumeskill : (Set<Resumeskill>)resumepersonaldetails.getResumeSkill())
{
if(resumeskill.getSkillType().equals("Primary"))
{
skillId = resumeskill.getSkillId();
for(Resumeskillmaster skillMaster : skillMasterList)
{
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
if(resumeRemarks.getRemarks().length()>20)
{
remarks = remarks.concat(resumeRemarks.getRemarks().substring(0,20));
remarks = remarks.concat("...");
}
else
{
remarks = remarks.concat(resumeRemarks.getRemarks());
}
remarks = remarks.concat("\n\n");
remarks = remarks.concat("Added By: ");
remarks = remarks.concat(resumeRemarks.getRemarksBy());
remarks = remarks.concat("\n");
remarks = remarks.concat("Added On: ");
remarks = remarks.concat(HMSUtil.convertDateToStringTypeDate(resumeRemarks.getDateRemarks()));

counterBgColor++;
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
String class1="";
if(!status.equals("Blacklisted"))
{
if(counterBgColor %2 == 0)
{
class1 = "even";
}else {
class1 = "odd";
}
}else{
class1="black";
}%>
	<tr class="<%=class1%>">
		<td><%=resumepersonaldetails.getId() %></td>
		<td><%=resumepersonaldetails.getFirstName()+" "+resumepersonaldetails.getLastName()%></td>
		<td><%=resumepersonaldetails.getCity()%></td>
		<td><%=resumepersonaldetails.getExperienceYear()+"."+resumepersonaldetails.getExperienceMonth()%></td>
		<td><%=resumepersonaldetails.getCurrentEmployer() %></td>
		<td><%=resumepersonaldetails.getCurrentCtc() %></td>
		<td><%=resumepersonaldetails.getExpectedCtc() %></td>
		<td title='<%=primarySkills %>'><%=initialPrimarySkills %></td>
		<td><%=remarks %></td>
		<td><%=status %></td>
	</tr>
	<%}%>

</table>
</div>
<script>
document.getElementById("resumelist").style.display="block";
</script> <%}
}%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>
function changeView()
{
if(document.addresume.<%=RequestConstants.RESUMETHROUGHVERIFICATION %>.value =='Vendor')
{
document.getElementById('email').style.visibility ='hidden';
}
else
{
document.getElementById('email').style.visibility ='visible';
}
}

function validateName(extraFunction)
{
errorMsg="";
ob1 = true;
if(eval("window."+extraFunction))
ob1 =  eval(extraFunction+"()")        	

if(validateFields('addresume')== true && ob1){
document.addresume.action = "/hms/hrms/resume?method=checkResumeUniqueness&jspName=addResume&"+csrfTokenName+"="+csrfTokenValue;
document.addresume.submit();
}
else{
if(errorMsg != "")
{  
alert(errorMsg);
return false;	
}
return true;
}
return true;
}

function checkEmail11()
{
if(document.addresume.<%=RequestConstants.RESUMETHROUGHVERIFICATION %>.value != 'Vendor' && document.addresume.<%=RequestConstants.EMAILIDFORVERIFICATION %>.value ==''){
errorMsg += "Email Id cannot be blank\n";
return false;
}
return true;
}

function fileName()
{
var file=document.addresume.<%=RequestConstants.UPLOAD%>.value;
var extension =file.substring(file.length-4);
if(file != "")
{
if(extension != '.doc' && extension != '.rtf' && extension != '.txt'&& extension != '.pdf')
{	
errorMsg +="Uploaded Resume can only be in .doc or .rtf or .txt and .pdf format\n";
return false;
}
}
else
{
errorMsg +="Upload Resume file not found, Please re-attach the file.\n";
return false;
}
return true;
}

function chkPassingYear(){
dobObj = document.addresume.<%=RequestConstants.DATEOFBIRTH%>.value;
yearObj= document.addresume.<%=RequestConstants.YEARPASSING%>.value;

empDOB= new Date(dobObj.substring(6),(dobObj.substring(3,5) - 1) ,dobObj.substring(0,2));
if(yearObj!="0"){
if(yearObj - empDOB.getFullYear() < 14 ){
errorMsg +="Year Of Passing is not valid.\n";
return false;
}
}
return true;
}
function populateCombo(field, arr, formname){
obj = eval("document."+formname+"."+field)
obj.length = arr.length;
obj.options[0].value='';
obj.options[0].text= arr[0];	
for(i=1;i<obj.length;i++){
obj.options[i].value = arr[i];
obj.options[i].text = arr[i];
}
}
</script>


