<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="jkt.hrms.recruitment.masters.business.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.util.RecruitmentUtil"%>

<%	
Map map=(Map)request.getAttribute("map");

Map<String,Boolean> flags =(Map)map.get("roleMap");
Boolean adminFlag 	= flags.get("adminFlag");
Boolean recFlag	    = flags.get("recFlag");
Boolean hrFlag 		= flags.get("hrFlag");
Boolean techFlag 	= flags.get("techFlag");
Boolean ownerFlag	= flags.get("ownerFlag");
Boolean assignToFlag = flags.get("assignToFlag");
Boolean ownerShipTimeFlag = flags.get("ownerShipTimeFlag");

Map detailsOfResume=(Map)map.get("detailsOfResume");
String resumeStatus= (String)map.get("resumeStatus");
List resumepersonaldetails =(List) detailsOfResume.get("resumePersonalDetails");
List<Resumeskillmaster> resumeskilldesc = (List)detailsOfResume.get("skillMasterList");
List<Resumeskill> resumeskill = (List)detailsOfResume.get("resumeSkill");
List resumeRemarksList = (List)detailsOfResume.get("resumeRemarks");
List listOfUploads=(List)detailsOfResume.get("listOfUploads");
List listOfEvaluationSheets = (List)detailsOfResume.get("listOfEvaluationSheets");
Resumepersonaldetails resumepersonaldetailsObj=(Resumepersonaldetails)resumepersonaldetails.get(0);

int checkStatus = resumepersonaldetailsObj.getResumeStatus().getId();

String message = "";
if(map.get("message")!=null)
{
	message = (String)map.get("message");
}
%>


<%@page import="java.text.SimpleDateFormat;"%>
<div class="titleBg">
<h2>View</h2>
</div>
<div class="clear"></div>
<form name="viewResume" method="post" action="#">
<div class="Block"><input type="hidden"
	name="<%=RequestConstants.RESUMEID%>"
	value="<%=resumepersonaldetailsObj.getId()%>" /> <%  RecruitmentUtil.sortById( resumeRemarksList );
	Resumeremarks resumeRemarks = (Resumeremarks)resumeRemarksList.get(0);
%>
<h4><%=message %></h4>
<div class="clear"></div>
<h4>Current Status : <%=resumepersonaldetailsObj.getResumeStatus().getResumestatusmaster().getStatusDesc() %></h4>
<div class="clear"></div>
<h4>Resume was Last updated by <%= resumeRemarks.getRemarksBy()%>
on <%= HMSUtil.convertDateToStringTypeDate(resumeRemarks.getDateRemarks())%>
</h4>
<div class="clear"></div>

<%	String allPrimarySkills="";
String allSecondarySkills="";
if(resumeskill != null)
{
for(Resumeskill resumeskillObj:resumeskill)
{
int skillId=resumeskillObj.getSkillId();
if((resumeskillObj.getSkillType()).equalsIgnoreCase("primary"))
{
for(Resumeskillmaster resumeskilldescObj : resumeskilldesc)
{
if(skillId==resumeskilldescObj.getId())
{
allPrimarySkills= allPrimarySkills.concat(resumeskilldescObj.getSkillDesc());
allPrimarySkills= allPrimarySkills.concat(", ");
}
}
}
if((resumeskillObj.getSkillType()).equalsIgnoreCase("secondary"))
{
for(Resumeskillmaster resumeskilldescObj : resumeskilldesc)
{
int skillDescId=resumeskilldescObj.getId();
if(skillId==skillDescId)
{
allSecondarySkills = allSecondarySkills.concat(resumeskilldescObj.getSkillDesc());
allSecondarySkills = allSecondarySkills.concat(", ");
}
}
}
}
}	
if(allPrimarySkills.length() > 0)
{
allPrimarySkills = allPrimarySkills.substring(0,allPrimarySkills.length()-2);
}
if(allSecondarySkills.length() > 0)
{	
allSecondarySkills = allSecondarySkills.substring(0,allSecondarySkills.length()-2);
}%>

<fieldset><legend>Skill Summary</legend> <%=resumepersonaldetailsObj.getFirstName()+" "+resumepersonaldetailsObj.getMiddleName()+" "+resumepersonaldetailsObj.getLastName()%>
has <%=resumepersonaldetailsObj.getExperienceYear() %> years and <%=resumepersonaldetailsObj.getExperienceMonth() %>
months of Experience in <%=allPrimarySkills+", "+allSecondarySkills%>.</fieldset>

<div class="clear"></div>


<%
String middlename = "";
if((resumepersonaldetailsObj.getMiddleName() != null) && !(resumepersonaldetailsObj.getMiddleName().equals("")))
{
	middlename = resumepersonaldetailsObj.getMiddleName();

}
%> <label>Name</label> <label><%=  resumepersonaldetailsObj.getFirstName() + " "+middlename + " "  + resumepersonaldetailsObj.getLastName()%></label>


<label>E-mail Id</label> <label class="auto"> <%if(resumepersonaldetailsObj.getEmailId()!= null && !(resumepersonaldetailsObj.getEmailId().equals("")))
{%> <a class="black"
	href="mailto:<%=resumepersonaldetailsObj.getEmailId()%>"><u><%=resumepersonaldetailsObj.getEmailId()%></u></a>
<%}else{%> -- &nbsp; <%} %> </label>

<div class="clear"></div>

<label>Resume Status</label> <label class="value"> <%=resumeStatus%>
</label> <label>Date Of Birth</label> <label class="value"><%=resumepersonaldetailsObj.getDateOfBirth() %></label>

<label>Year Of Passing</label> <label class="value"> <%if(resumepersonaldetailsObj.getYearpassing()!= null && !(resumepersonaldetailsObj.getYearpassing().equals("")))
{%> <%=resumepersonaldetailsObj.getYearpassing() %> <%}else{%> -- &nbsp; <%}%>
</label>

<div class="clear"></div>

<label>Address</label> <%if(resumepersonaldetailsObj.getAddress1()!= null){ %>
<label class="auto"><%=resumepersonaldetailsObj.getAddress1()%>
| <%=resumepersonaldetailsObj.getAddress2()%> | <%=resumepersonaldetailsObj.getAddress3()%>
</label> <%}%>

<div class="clear"></div>
<%
String country = "--";
String state = "--";
String city = "--";
if(resumepersonaldetailsObj.getCountry()!= null)
{
	
	country = resumepersonaldetailsObj.getCountry().getCountryName();
}
if(resumepersonaldetailsObj.getState()!= null)
{
	
	state = resumepersonaldetailsObj.getState().getStateName();
}
if(resumepersonaldetailsObj.getCity()!= null)
{
	
	city = resumepersonaldetailsObj.getCity().getDistrictName();
}
%> <label>Country</label> <label class="value"><%=country %></label> <label>State</label>
<label class="value"><%=state %></label> <label>City</label> <label
	class="value"><%=city %></label>

<div class="clear"></div>


<label>Mobile No.</label> <label class="value"><%=resumepersonaldetailsObj.getMobile()%></label>

<label>Contact No</label> <label class="value"> <%if(resumepersonaldetailsObj.getResidencePhone()!= null && !(resumepersonaldetailsObj.getResidencePhone().equals("")))
{%> <%=resumepersonaldetailsObj.getResidencePhone()%> <%}else{%> -- &nbsp;
<%}%> </label>

<div class="clear"></div>

<label>Other Contact No.</label> <label class="value"> <%if(resumepersonaldetailsObj.getOtherPhone()!=null && !(resumepersonaldetailsObj.getOtherPhone().equals("")))
{%> <%=resumepersonaldetailsObj.getOtherPhone() %> <%}else{%> -- &nbsp; <%}%>
</label> <label>Highest Degree</label> <label class="value"><%=resumepersonaldetailsObj.getEducation() %></label>

<label>University</label> <label class="value"> <%if(resumepersonaldetailsObj.getInstitution()!= null && !(resumepersonaldetailsObj.getInstitution().equals("")))
{%> <%=resumepersonaldetailsObj.getInstitution() %> <%}else{%> -- &nbsp; <%}%>
</label>

<div class="clear"></div>

<%String experience = resumepersonaldetailsObj.getExperienceYear()+"."+resumepersonaldetailsObj.getExperienceMonth(); 
if(resumepersonaldetailsObj.getExperienceYear()>=31)
{
experience = "+30";
} %> <label>Experience</label> <label class="value"><%=experience %></label>

<label>Current Company</label> <label class="value"> <%if(resumepersonaldetailsObj.getCurrentEmployer() != null && !(resumepersonaldetailsObj.getCurrentEmployer().equals("")))
{%> <%=resumepersonaldetailsObj.getCurrentEmployer()%> <%}else{%> -- <%}	%>
</label> <label>Previous Company</label> <label class="value"> <%if(resumepersonaldetailsObj.getPreviousEmployer() != null && !(resumepersonaldetailsObj.getPreviousEmployer().equals("")))
{%> <%=resumepersonaldetailsObj.getPreviousEmployer()%> <%}else{%> --
&nbsp; <%}	%> </label>

<div class="clear"></div>


<label>Domain</label> <label class="value"> <%if(resumepersonaldetailsObj.getDomainKnowledge() != null && !(resumepersonaldetailsObj.getDomainKnowledge().equals("")))
{%> <%=resumepersonaldetailsObj.getDomainKnowledge() %> <%}else{%> -- <%}%>
</label> <label>Current CTC</label> <label class="value"> <%if(!(resumepersonaldetailsObj.getCurrentCtc().equals("")))
{%> <%=resumepersonaldetailsObj.getCurrentCtc()%> <%}else{%> -- &nbsp; <%}%>
</label> <label>Expected CTC</label> <label class="value"> <%if(resumepersonaldetailsObj.getExpectedCtc() != null && !(resumepersonaldetailsObj.getExpectedCtc().equals("")))
{%> <%=resumepersonaldetailsObj.getExpectedCtc()%> <%}else{%> -- &nbsp; <%}%>
</label>

<div class="clear"></div>


<label>Current Designation</label> <label class="value"> <%if(!(resumepersonaldetailsObj.getCurrentDesignation().equals("")))
{%> <%=resumepersonaldetailsObj.getCurrentDesignation() %> <%}else{%> --
&nbsp; <%}%> </label> <label>Salary Remarks</label> <label class="value">
<%if((resumepersonaldetailsObj.getSalaryRemarks() != null) && !(resumepersonaldetailsObj.getSalaryRemarks().equals("")))
{%> <%=resumepersonaldetailsObj.getSalaryRemarks()%> <%}else{%> -- &nbsp;
<%}%> </label> <label>Passport Status</label> <label class="value"> <%String passportStatus;
if((resumepersonaldetailsObj.getPassportStatus() != null) && !(resumepersonaldetailsObj.getPassportStatus().equals("")))
{%> <%passportStatus= resumepersonaldetailsObj.getPassportStatus();%> <%}else{%>
<%passportStatus = "Details Not Avaliable";%> <%}%> <%=passportStatus %> </label>

<div class="clear"></div>

<label>Passport Number</label> <label class="value"> <%if((resumepersonaldetailsObj.getPassportNo() != null) && !(resumepersonaldetailsObj.getPassportNo().equals("")))
{%> <%=resumepersonaldetailsObj.getPassportNo()%> <%}else{%> -- &nbsp; <%}%>
</label> <label>Passport Expiry Date</label> <label class="value"> <%if(resumepersonaldetailsObj.getPassportExpiryDate() != null && !(resumepersonaldetailsObj.getPassportExpiryDate().equals("")))
{%> <%=resumepersonaldetailsObj.getPassportExpiryDate()%> <%}else{%> --
&nbsp; <%}%> </label> <label>Visa Remarks</label> <label class="value"> <%if(resumepersonaldetailsObj.getVisaRemarks() != null && !(resumepersonaldetailsObj.getVisaRemarks().equals("")))
{%> <%=resumepersonaldetailsObj.getVisaRemarks()%> <%}else{%> -- &nbsp; <%}%>
</label> <%	List<String> primaryskillDesc=new ArrayList<String>();
List<String> secondaryskillDesc=new ArrayList<String>();
for(Resumeskill resumeskillObj : resumeskill)
{
if((resumeskillObj.getSkillType()).equalsIgnoreCase("primary"))
{
for(Resumeskillmaster resumeskilldescObj : resumeskilldesc)
{
int skillId=resumeskillObj.getSkillId();
int skillDescId=resumeskilldescObj.getId();
if(skillId==skillDescId)
{
primaryskillDesc.add(resumeskilldescObj.getSkillDesc());
}
}
}

if((resumeskillObj.getSkillType()).equalsIgnoreCase("secondary"))
{
Iterator resumeSkillDescIterator=resumeskilldesc.iterator();
while(resumeSkillDescIterator.hasNext())
{
Resumeskillmaster resumeskilldescObj=(Resumeskillmaster)resumeSkillDescIterator.next();
int skillId=resumeskillObj.getSkillId();
int skillDescId=resumeskilldescObj.getId();
if(skillId==skillDescId)
{
secondaryskillDesc.add(resumeskilldescObj.getSkillDesc());
}
}

}

}%>

<div class="clear"></div>

<label>Primary Skills</label> <label class="value"> <%int i=0;
int j=primaryskillDesc.size();
for(i=0;i<j;i++){
String primarySkills=(String)primaryskillDesc.get(i);%> <%=primarySkills%>

<%}%> </label> <label>Secondary Skills</label> <label class="valueFixedWidth">
<% 	
j=secondaryskillDesc.size();
for(i=0;i<j;i++)
{
String secondarySkills=(String)secondaryskillDesc.get(i);
%> <%=secondarySkills%> <%
}
%> </label> <label>Department</label> <label class="value"> <%if(resumepersonaldetailsObj.getDU()!=null)
{%> <%=resumepersonaldetailsObj.getDU().getDepartmentName()%> <%}else{%>
-- &nbsp; <%}%> </label>

<div class="clear"></div>
<%--
<label>Project Name</label>
<label class="value">
<%if(resumepersonaldetailsObj.getProject()!=null)
{%>
<%=resumepersonaldetailsObj.getProject().getPrjName()%>
<%}else{%>
-- &nbsp;
<%}%>			
</label>
 --%> <label>Job Profile</label> <label class="value"> <%if(resumepersonaldetailsObj.getJobProfile()!=null)
{%> <%=resumepersonaldetailsObj.getJobProfile().getRankName()%> <%}else{%>
-- &nbsp; <%}%> </label> <label>Joining Time</label> <label class="value">
<%if(resumepersonaldetailsObj.getJoiningPeriod() != null && !(resumepersonaldetailsObj.getJoiningPeriod().equals("")))
{%> <%=resumepersonaldetailsObj.getJoiningPeriod()%>&nbsp;days <%}else{%>
-- &nbsp; <%}%> </label>

<div class="clear"></div>

<label>Onsite Availability</label> <label class="value"> <%if(resumepersonaldetailsObj.isOnSiteAvailability())
{
%> Availlable <%}
else
{
%> Not Availlable <%} %> </label> <label>Active/InActive</label> <label
	class="value"> <%if(resumepersonaldetailsObj.isActive())
{
%> Active <%}
else
{
%> Inactive <%} %> </label> <label>Resume Through</label> <%
String resumeThrough = "";
String nameOfSource  = "";
if(resumepersonaldetailsObj.getResumeThrough()!= null)
resumeThrough = resumepersonaldetailsObj.getResumeThrough();
nameOfSource  = resumepersonaldetailsObj.getNameOfSource();
if(nameOfSource == null)
{
nameOfSource = "--";
}
%> <label class="value"><%=resumeThrough %></label>

<div class="clear"></div>

<label>Name of Source</label> <label class="value"><%=nameOfSource %></label>

<label>Attachment</label> <label class="value"> <% 
if(listOfUploads.size()!=0)
{
i=listOfUploads.size();
Iterator listOfUploadsIterator=listOfUploads.iterator();
while(i>0)
{
i--;
String fileName=(String)listOfUploads.get(i);
%> <a target="_blank" href="../uploads/rms_resume/<%=fileName%>">Resume<%=i+1%></a>;
<% 		

}

}
else
{
%> No Resume Attached <% 
}
%> </label> <label>Evaluation Sheet</label> <label class="value"> <% 
if(listOfEvaluationSheets.size()!=0)
{
i=listOfEvaluationSheets.size();
Iterator listOfUploadsIterator=listOfEvaluationSheets.iterator();
while(i>0)
{
i--;
String fileName=(String)listOfEvaluationSheets.get(i);
%> <a target="_blank" href="../uploads/evaluationSheets/<%=fileName%>">Sheet<%=i+1%></a>;
<% 		

}

}
else
{
%> No Sheet Attached <% 
}
%> </label>


<div class="clear"></div>

<label>Remarks</label> <label id="resumeremarks" class="auto"> <%
Iterator resumeRemarksIterator=resumeRemarksList.iterator();
int k = 1;
while(resumeRemarksIterator.hasNext())
{
resumeRemarks=(Resumeremarks)resumeRemarksIterator.next();
%> <%=k%>)Remarks: <%=resumeRemarks.getRemarks() %> | By:<%=resumeRemarks.getRemarksBy()%>
| Date:<%= HMSUtil.convertDateToStringTypeDate(resumeRemarks.getDateRemarks())%>
<br />
---------------- <br />
<%
k++;
}
String name=resumepersonaldetailsObj.getFirstName()+" "+resumepersonaldetailsObj.getMiddleName()+" "+resumepersonaldetailsObj.getLastName();
%> </label>
<div class="clear"></div>
<%if(resumepersonaldetailsObj.getResumeStatus().getHrRemarks() !=null){ %>
<label>HR Remarks</label> <label class="auto"><%=resumepersonaldetailsObj.getResumeStatus().getHrRemarks() %></label>
<div class="clear"></div>
<%} %> <%
if(hrFlag && (resumeStatus.equalsIgnoreCase("Shortlisted")|| resumeStatus.equalsIgnoreCase("Tech Interviewed")||resumeStatus.equalsIgnoreCase("Tech On hold"))){
%>

<h4>Technical/Functional Evaluation is still pending.</h4>

<div class="clear"></div>

<div class="clear"></div>

<%
}
%>
</div>
<div id="buttons"><input type="button" name="edit" value="Edit"
	class="button"
	onClick="submitForm('viewResume','resume?method=showEditResume')" /> <%
if(resumepersonaldetailsObj.getResumeStatus().getStatusId()>1){
if(true)
{	%> <input type="button" name="showTechDetails"
	value="Functional Details" class="buttonBig"
	onClick="submitForm('viewResume','resume?method=showTechDetails&<%=RequestConstants.RESUMEID%>=<%=resumepersonaldetailsObj.getId()%>&<%=RequestConstants.NAME%>=<%=name%>')" />
<%} %> <%

if(true)
{	%> <input type="button" name="showHRDetails" value="HR Details"
	class="button"
	onClick="submitForm('viewResume','resume?method=showHRDetails&<%=RequestConstants.RESUMEID%>=<%=resumepersonaldetailsObj.getId()%>&<%=RequestConstants.NAME%>=<%=name%>')" />
<%} %> <%
if(hrFlag && (resumepersonaldetailsObj.getResumeStatus().getStatusId().equals(10)||resumepersonaldetailsObj.getResumeStatus().getStatusId()>=14))
{	%> <input type="button" name="showFinalStatus" value="Offer Details"
	class="buttonBig"
	onClick="submitForm('viewResume','resume?method=showFinalStatus&<%=RequestConstants.RESUMEID%>=<%=resumepersonaldetailsObj.getId()%>&<%=RequestConstants.NAME%>=<%=name%>&offer=true')" />
<%if(resumepersonaldetailsObj.getResumeStatus().getStatusId().equals(14) || resumepersonaldetailsObj.getResumeStatus().getStatusId().equals(18)){ %>
<input type="button" name"offerLetter" value="Offer Letter"
	class="button" onclick="promptForOfferLetter()" /> <input
	type="button" name="showFinalStatus" value="CTC Annexure"
	class="button"
	onClick="submitForm('viewResume','resume?method=previewCTCAnnexure&<%=RequestConstants.RESUMEID%>=<%=resumepersonaldetailsObj.getId()%>&<%=RequestConstants.NAME%>=<%=name%>')" />
<input type="button" name="showFinalStatus" value="Joining Details"
	class="buttonBig"
	onClick="submitForm('viewResume','resume?method=showFinalStatus&<%=RequestConstants.RESUMEID%>=<%=resumepersonaldetailsObj.getId()%>&<%=RequestConstants.NAME%>=<%=name%>')" />
<%}
 if(resumepersonaldetailsObj.getResumeStatus().getStatusId().equals(18)){%>

<input type="button" name"appointmentLetter" value="appointment Letter"
	class="buttonBig" onclick="promptForAppLetter()" /> <%}
}%> <%if(resumepersonaldetailsObj.getResumeStatus().getStatusId().equals(11)||resumepersonaldetailsObj.getResumeStatus().getStatusId().equals(17)){ %>
<input type="button" name"ctcAnnexure" value="CTC Annexure"
	class="button"
	onclick="location.href='resume?method=showCTCAnnexureJsp&<%=RequestConstants.RESUMEID%>=<%=resumepersonaldetailsObj.getId()%>'" />
<%} %> <%if(resumepersonaldetailsObj.getResumeStatus().getStatusId()>=10){ %>
<input type="button" name="backout" value="Backed Out" class="button"
	onClick="alertBackout()"> <%}
}
%> <input type="button" name="back" value="Back" class="button"
	onClick="location.href='/hms/hrms/resume?method=showSearchPage'" /> <input
	type=hidden name="<%=RequestConstants.STATUS%>"
	value="<%=resumeStatus %>" /></div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<script>
function alertBeforeDeleting(){
if(confirm("Are you Sure, you want to delete this resume?"))
return true;
return false;
}

function alertBackout()
	{
	 x = confirm("You are about to change the status of this Candidate as Backed Out.\nAre you sure.");
	 if(x)
	 {
	 location.href = "resume?method=addResumeStatus&<%=RequestConstants.RESUMEID%>=<%=resumepersonaldetailsObj.getId()%>&statusId=12"
	 }
	 else
	 {
	  return false;
	 }
	}
	
function promptForAppLetter()
{
my = window.open("../jsp/promptForJoiningLetter.jsp?<%=RequestConstants.RESUMEID%>=<%=resumepersonaldetailsObj.getId()%>&name=<%=resumepersonaldetailsObj.getFirstName()%>","_blank","width=350, height=100;");
my.focus();

//location.href='resume?method=generateJoiningLetter&letterType=joiningLetter&<%=RequestConstants.RESUMEID%>=<%=resumepersonaldetailsObj.getId()%>'
}
function promptForOfferLetter()
{
my = window.open("../jsp/prompForOfferLetter.jsp?<%=RequestConstants.RESUMEID%>=<%=resumepersonaldetailsObj.getId()%>&name=<%=resumepersonaldetailsObj.getFirstName()%>","_blank","width=350, height=100;");
my.focus();
//location.href='resume?method=generateOfferLetter&letterType=offerLetter&<%=RequestConstants.RESUMEID%>=<%=resumepersonaldetailsObj.getId()%>'"
}
</script>
