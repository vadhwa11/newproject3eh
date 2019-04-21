<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hrms.recruitment.masters.business.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hrms.masters.business.MasQualification"%>

<%	Map map=(Map)request.getAttribute("map");
	Map detailsOfResume=(Map)map.get("detailsOfResume");
	List resumePersonalDetailsList=(List)detailsOfResume.get("resumePersonalDetails");
	List<Resumeskill> resumeSkillList=(List)detailsOfResume.get("resumeSkill");
	List<Resumeskillmaster> resumeSkillDescList=(List)detailsOfResume.get("skillMasterList");
	List<Resumeremarks> resumeRemarksList=(List)detailsOfResume.get("resumeRemarks");
	List listOfUploads=(List)detailsOfResume.get("listOfUploads");
	RecruitmentUtil.sortById( resumeRemarksList );
	Resumepersonaldetails resumePersonalDetails=(Resumepersonaldetails)resumePersonalDetailsList.get(0);
	List<MasRank> jobProfiles = (List<MasRank>)map.get("jobProfiles");
	List<Resumedudetail> duList = (List<Resumedudetail>)map.get("duList");
	List<MstrProject> projectList = (List<MstrProject>)map.get("projectList");
	List<MasTitle> titleList = (List<MasTitle>)map.get("titleList");
	List<Resumeprojectsdetail> projectDetails = (List<Resumeprojectsdetail>)map.get("projectDetails");
	List<MasCountry> countryList = (List<MasCountry>)map.get("countryList");
	List<MasQualification> qualificationList = new ArrayList();
	if(map.get("qualificationList")!=null){
		qualificationList = (List)map.get("qualificationList");
	}
	String resumeThrough = resumePersonalDetails.getResumeThrough();
	String nameOfSource = resumePersonalDetails.getNameOfSource();
	if(nameOfSource == null)
	{
		nameOfSource = "--";
	}
	String labelNameForSource = "";
	if(resumeThrough!=null){
	if(resumeThrough.equalsIgnoreCase("Vendor")){
		labelNameForSource = "Vender Name";
			}
	if(resumeThrough.equalsIgnoreCase("Internal Reference")){
		labelNameForSource = "Name Of Reference";
		}
	if(resumeThrough.equalsIgnoreCase("Job Portal")){
		labelNameForSource = "Job Portal Name";
		}
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

%>
<%@page import="jkt.hrms.util.RecruitmentUtil"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<script type="text/javascript" language="javascript"
	src="/jktintranet/jsp/javascript/calendar.js"></script>
<script>
<%		Calendar calendar=Calendar.getInstance();
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

	
	function enablePassport()
	{
			
	//		document.getElementById('passStatus').disabled=true;
			document.getElementById('pass1').style.display = 'block';
			document.getElementById('passNo').readonly=true;
			
	}
	

	
</script>

<div class="titleBg">
<div class="floatRight">Fields marked with <span>*</span> are
mandatory&nbsp;&nbsp;</div>
<h2>Edit Resume</h2>
</div>

<form name="editresume" action="" method="post"
	enctype="multipart/form-data">
<div class="Block"><input type="hidden"
	name="<%=RequestConstants.RESUMEID%>"
	value="<%=resumePersonalDetails.getId()%>"><input type="hidden"
	name="<%=RequestConstants.EMAILIDFORVERIFICATION%>"
	value="<%=resumePersonalDetails.getEmailId() %>" /> <% if(resumePersonalDetails.getResumeThrough()!=null){%>
<label><span>* </span>Resume Through:</label> <input type="text"
	class="readOnly" readonly="readonly" name="<%= RESUMETHROUGH%>"
	value="<%=resumePersonalDetails.getResumeThrough()%>" /> <%} %> <%
            if(resumeThrough!=null && ((resumeThrough.equalsIgnoreCase("Direct")) || ( resumeThrough.equalsIgnoreCase("Advertisement"))))
			{ 
            	
			}
			else if(resumeThrough!=null)
			{%> <label><span>* </span><%=labelNameForSource %>:</label> <input
	type="text" name="<%=RequestConstants.NAMEOFSOURCE%>"
	value="<%=nameOfSource%>" validate="'',char,yes" maxlength="50"
	enabled="true" /> <%}
			 %> <label><span>* </span>Title :</label> <select
	name="<%=RequestConstants.TITLE%>" validate="Title,string,yes">
	<option value="0">Select</option>
	<%for(MasTitle title : titleList){ %>
	<option value="<%=title.getId() %>"><%=title.getTitleName() %></option>
	<%} %>
</select> <script>
				
				<%if(resumePersonalDetails.getTitle()!=null){%>
				
					document.editresume.<%=RequestConstants.TITLE%>.value= <%=resumePersonalDetails.getTitleId()%> ;
				<%}%>
				
			</script> <label>&nbsp;First Name:</label> <input type="text"
	name="<%=RequestConstants.FIRSTNAME%>"
	value="<%=resumePersonalDetails.getFirstName() %>"
	validate="First Name,name,no" maxlength="25" class="readOnly" ReadOnly />

<div class="clear"></div>

<label>Middle Name:</label> <input type="text"
	name="<%=RequestConstants.MIDNAME%>"
	value="<%=resumePersonalDetails.getMiddleName()%>"
	validate="Middle Name,char,no" maxlength="15" /> <script>
				document.editresume.<%=RequestConstants.MIDNAME%>.focus();
			</script> <label>Last Name:</label> <input type="text"
	name="<%=RequestConstants.LASTNAME%>"
	value="<%=resumePersonalDetails.getLastName() %>"
	validate="Last Name,char,yes" maxlength="25" class="readOnly" ReadOnly />


<label>Date of Birth:</label> <input type="text"
	name="<%=RequestConstants.DATEOFBIRTH%>" tabindex="500"
	value="<%=resumePersonalDetails.getDateOfBirth() %>"
	validate="Date of Birth,dateOfBirth,no" readonly />
<div class="clear"></div>
<%String otherCity = resumePersonalDetails.getOtherCity();
			  
			%>
<div class="clear"></div>
<h4>Address</h4>
<div class="clear"></div>
<label>Line 1</label> <input type="text"
	name="<%=RequestConstants.ADDRESSLINE1 %>" maxlength="40"
	validate="Address Line 1,'string',no" /> <label>Line 2</label> <input
	type="text" name="<%=RequestConstants.ADDRESSLINE2 %>" maxlength="40"
	validate="Address Line 2,'string',no" /> <label>Line 3</label> <input
	type="text" name="<%=RequestConstants.ADDRESSLINE3 %>" maxlength="40"
	validate="Address Line 3,'string',no" />
<div class="clear"></div>

<script type="text/javascript">
			document.editresume.<%=RequestConstants.ADDRESSLINE1 %>.value = "<%=resumePersonalDetails.getAddress1()%>";
			document.editresume.<%=RequestConstants.ADDRESSLINE2 %>.value = "<%=resumePersonalDetails.getAddress2()%>";
			document.editresume.<%=RequestConstants.ADDRESSLINE3 %>.value = "<%=resumePersonalDetails.getAddress3()%>";
			</script> <%@include file="hr_address1.jsp"%>
<div class="clear"></div>
<%
				Integer countryId = 0;
				Integer stateId = 0;
				Integer cityId = 0;
				
				if(resumePersonalDetails.getCountry()!=null)
				{
					countryId = resumePersonalDetails.getCountry().getId();
				}
				if(resumePersonalDetails.getState()!=null)
				{
					stateId = resumePersonalDetails.getState().getId();
				}
				if(resumePersonalDetails.getCity()!=null)
				{
					cityId = resumePersonalDetails.getCity().getId();
				}
				%> <script>
				document.editresume.<%=RequestConstants.COUNTRY%>.value="<%=countryId%>";
				getStateList(<%=countryId%>);
				document.editresume.state.value = "<%=stateId%>"
				getCityList(<%=stateId%>);
				document.editresume.<%=DISTRICT%>.value = "<%=cityId%>"
				</script> <%String emailMust = "yes";
			String visibility="visible";
			if(resumeThrough != null && resumeThrough.equalsIgnoreCase("vendor"))
			{
				emailMust="no";
				visibility="hidden";
			}
			%> <label><font class="star" id="emailStar"
	style="visibility: <%=visibility %>"> <font color="red">*</font>&nbsp;</font>Email:</label>
<input type="text" name="<%=RequestConstants.EMAIL%>"
	value="<%=resumePersonalDetails.getEmailId() %>"
	validate="Email Id,email,<%=emailMust %>" maxlength="50" enabled="true" />

<label>&nbsp;Contact No:</label> <input type="text"
	name="<%=RequestConstants.HOMEPHONE%>"
	value="<%=resumePersonalDetails.getResidencePhone() %>"
	validate="Contact,phone,no" maxlength="11" /> <label><span>*
</span>Mobile:</label> <input type="text" name="<%=RequestConstants.MOBILEPHONE%>"
	value="<%=resumePersonalDetails.getMobile() %>"
	validate="Mobile,mobilephone,yes" maxlength="12" />

<div class="clear"></div>
<label>Other Contact No:</label> <input type="text"
	name="<%=RequestConstants.OTHERPHONE%>"
	value="<%=resumePersonalDetails.getOtherPhone() %>"
	validate="Other Phone,phone,no" maxlength="11" /> <label><span>*
</span>Highest Degree:</label> <select name="<%=RequestConstants.EDUCATION%>"
	validate="Highest Degree,string,yes">
	<option value="">Select</option>
	<%for(MasQualification qualification : qualificationList){ %>
	<option value="<%=qualification.getQualificationName() %>"><%=qualification.getQualificationName() %></option>
	<%} %>
</select>

<div id="otherEdu" style="display: none"><label>Other:</label> <input
	type="text" name="<%=RequestConstants.OTHEREDUCATION%>"
	value="<%=resumePersonalDetails.getEducation()%>"
	validate="Other,alphaspace,no" maxlength="30" /></div>


<label>Year of Passing:</label> <select
	name=<%=RequestConstants.YEARPASSING%> class='select1'>
	<option value="0">Select</option>
	<%int yearPassed=year;
				while(yearPassed >= (year-100))
				{%>
	<option value="<%=yearPassed%>"><%=yearPassed%></option>
	<%yearPassed--;
				}%>
</select> <script>
				var edu = "<%=resumePersonalDetails.getEducation()%>";
				document.editresume.<%=RequestConstants.EDUCATION%>.value= edu ;
				var index = document.editresume.<%=RequestConstants.EDUCATION%>.selectedIndex;
				if((edu !="" && (index == 0 || index == -1)) || document.editresume.<%=RequestConstants.EDUCATION%>.value=="Other"){
					document.editresume.<%=RequestConstants.EDUCATION%>.value = "Other" ;
					document.getElementById('otherEdu').style.display = 'block'; 
					document.editresume.<%=RequestConstants.OTHEREDUCATION%>.value= edu ;
				}
				document.editresume.<%=RequestConstants.YEARPASSING%>.value="<%=resumePersonalDetails.getYearpassing() %>";
			</script>

<div class="clear"></div>
<label>University:</label> <input type="text"
	name="<%=RequestConstants.UNIVERSITY%>"
	value="<%=resumePersonalDetails.getInstitution() %>"
	validate="University,alphaspace,no" maxlength="50" /> <label>Expertise:</label>
<input type="text" name="<%=RequestConstants.DOMAIN%>"
	value="<%=resumePersonalDetails.getDomainKnowledge() %>"
	validate="Domain,alphaspace,no" maxlength="50" /> <label><span>*
</span>Experience:</label> <select name="<%=RequestConstants.YEARS%>"
	validate="Experience in Years,'',yes" class='smallest'>
	<option value="">--</option>
	<%for(int i=0;i<=30;i++)
			{%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
	<option value="31">+30</option>
</select> <label class="smallAuto">Yrs</label> <select
	name="<%=RequestConstants.MONTHS%>"
	validate="Experience in Months,'',yes" class='smallest'>
	<option value="">--</option>
	<%for(int i=0;i<=11;i++)
  			  {%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="smallAuto">Mths</label>

<div class="clear"></div>

<label>Job Profile :</label> <select
	name="<%=RequestConstants.JOBPROFILE %>" class='select1'>
	<option value="">Select</option>
	<%for(MasRank profile: jobProfiles)
				{ %>
	<option value="<%=profile.getId()%>"><%=profile.getRankName()%></option>
	<%}%>
</select> <script>
				var profileId = "<%=resumePersonalDetails.getJobProfileID()%>";
				if(<%=resumePersonalDetails.getJobProfileID()!=null%>)
				{
					document.editresume.<%=RequestConstants.JOBPROFILE%>.value= profileId ;
				}
			</script> <label><span>* </span>Current Employer:</label> <input type="text"
	name="<%=RequestConstants.CURRENTEMPLOYER%>"
	value="<%=resumePersonalDetails.getCurrentEmployer() %>"
	validate="Current Company,resumeCompany,yes" maxlength="50" /> <label>Previous
Employer:</label> <input type="text"
	name="<%=RequestConstants.PREVIOUSEMPLOYER%>"
	value="<%=resumePersonalDetails.getPreviousEmployer()%>"
	validate="Previous Employer Name,resumeCompany,no" maxlength="50" />

<div class="clear"></div>

<label>Current CTC:</label> <input type="text"
	name="<%=RequestConstants.CURRENTCTC%>"
	value="<%=resumePersonalDetails.getCurrentCtc()%>"
	validate="Current CTC,num,no" maxlength="10" /> <label>Expected
CTC:</label> <input type="text" name="<%=RequestConstants.EXPECTEDSALARY%>"
	value="<%=resumePersonalDetails.getExpectedCtc()%>"
	validate="Expected CTC,num,no" maxlength="10" /> <label>Current
Designation:</label> <input type="text" name="<%=RequestConstants.CURRENTROLE%>"
	value="<%=resumePersonalDetails.getCurrentDesignation() %>"
	validate="Current Designation,alphaspace,no" maxlength="20" />

<div class="clear"></div>

<label>Salary Remarks:</label> <input type="text"
	name="<%=RequestConstants.SALARYREMARKS%>"
	value="<%=resumePersonalDetails.getSalaryRemarks()%>" maxlength="35" />


<label>DU:</label> <select id="du" name="<%=RequestConstants.DU_ID%>"
	onchange="changeProject()">
	<option value="">Select</option>
	<%for(Resumedudetail du:duList)
			{	%>
	<option value="<%=du.getId()%>"><%=du.getDUName()%></option>
	<%  } %>
</select> <script>
				var duId = "<%=resumePersonalDetails.getDuID()%>";
				if(<%=resumePersonalDetails.getDuID()!=null%>)
				{
					document.editresume.<%=RequestConstants.DU_ID%>.value= duId ;
				}
			</script> <label>Joining Time:</label> <input type="text"
	name="<%=RequestConstants.JOININGTIME%>"
	value="<%=resumePersonalDetails.getJoiningPeriod()%>" class="date"
	validate="Joining Time,num,no" maxlength="25" /> <label
	class="smallAuto">days</label>
<div class="clear"></div>
<script>
				var joinTime = "<%=resumePersonalDetails.getJoiningPeriod()%>";
				if(<%=resumePersonalDetails.getJoiningPeriod()!=null%>)
				{
					document.editresume.<%=RequestConstants.JOININGTIME%>.value= joinTime ;
				}
				else
				{
					document.editresume.<%=RequestConstants.JOININGTIME%>.value="";
				}
			</script> <label>Project Name:</label> <select id="project"
	name="<%=RequestConstants.PROJECT_ID%>" size="3"
	validate="Project Name,string,no">
	<%for(MstrProject project : projectList){ %>
	<option value="<%=project.getId() %>"><%=project.getPrjName() %></option>
	<%} %>
</select> <%if(resumePersonalDetails.getProject()!=null){ %> <script>
				document.getElementById("project").value = <%=resumePersonalDetails.getProject().getId()%>;
			</script> <%} %> <label id="othersprojectlabel" style="visibility: hidden;">Others:</label>
<input type="text" style="visibility: hidden;" id="othersprojecttext"
	name="<%=RequestConstants.OTHERPROJECT%>" value=""
	validate="Project Name, string,no" maxlength="90" /> <label><span>*
</span>Passport :</label> <select name="<%=RequestConstants.PASSPORTSTATUS %>"
	onchange="changePassport()">
	<option value="Yes">Yes</option>
	<option value="No">No</option>
	<option value="Details Not Available">Details Not Avaliable</option>
</select> <%String passportStatus1;
			String displayPass = "none";
			String displayVisa = "none";
			if((resumePersonalDetails.getPassportStatus() != null) && !(resumePersonalDetails.getPassportStatus().equals("")))
			{
				passportStatus1= resumePersonalDetails.getPassportStatus();
				if(passportStatus1.equalsIgnoreCase("Yes"))
				{
					displayPass = "block";
					displayVisa = "block";
				}
				else if(!passportStatus1.equalsIgnoreCase("No"))
				{
					displayVisa = "block";
				}
				%> <%}else{%> <%passportStatus1 = "Details Not Available";
				displayVisa = "block";
				%> <%}%> <script>
				document.editresume.<%=RequestConstants.PASSPORTSTATUS%>.value='<%=passportStatus1%>';
			</script>
<div class="clear"></div>
<div id="pass1" style="display: <%=displayPass %>"><label><span>*
</span>Passport Number:</label> <input id="passNo" type="text"
	name="<%=RequestConstants.PASSPORTNUMBER%>"
	value="<%=resumePersonalDetails.getPassportNo()%>"
	validate="Passport No,passport,no" maxlength="8" /> <label><span>*
</span>Passport Expiry Date:</label> <%	String passportExpiryDate=resumePersonalDetails.getPassportExpiryDate();
				if(passportExpiryDate==null)
					passportExpiryDate="";
			%> <input id="passDate" type="text" class="date"
	name="<%=RequestConstants.PASSPORTEXPIRYDATE%>"
	value="<%=passportExpiryDate%>" tabindex="500" readonly /> <img
	src="/hms/jsp/images/cal.gif"
	onclick="javascript:setdate('',document.editresume.<%=RequestConstants.PASSPORTEXPIRYDATE%>,event)"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" /> <label>Visa Remarks:</label> <textarea id="visa"
	name="<%=RequestConstants.VISAREMARKS%>"
	validate="Visa Remarks,remarks,no"
	onkeydown="refreshLength1(this.id,250)"
	onkeyup="refreshLength(this.id,250)"></textarea>
<div class="clear"></div>
<label>Onsite Availability</label><label class="value"><input
	type="checkbox" id="onsiteavb" class="radioCheck"
	name="<%=RequestConstants.ONSITEAVAILABILITY%>"></label> <%
			if(resumePersonalDetails.isOnSiteAvailability())
			{ %> <script>
					document.editresume.<%=RequestConstants.ONSITEAVAILABILITY%>.checked=true;
			</script> <%} %>

<div class="clear"></div>
<script>
			document.editresume.<%=RequestConstants.VISAREMARKS%>.value="<%=resumePersonalDetails.getVisaRemarks()%>";
			</script></div>
<%
			if(resumePersonalDetails.getPassportNo()!= null && !resumePersonalDetails.getPassportNo().equalsIgnoreCase(""))
			{
			%> <script>
			enablePassport();
			</script> <%		
			}
			%> <label><span>* </span>Primary Skills:</label> <select
	id="primarySkills" name="<%=RequestConstants.PRIMARYSKILLS%>"
	validate="Primary skills,int,yes" size="6" multiple class='list'
	onchange='changePrimary()' onclick='changePrimary()'>
	<%
			for(Resumeskillmaster resumeSkillDesc : resumeSkillDescList)
			{
				String primarySkills=null;
				if(resumeSkillDesc.getSkillParent()==0)
				{
					for(Resumeskill resumeSkill : resumeSkillList)
					{
						int skillId=resumeSkillDesc.getId();
						int resumeSkillId=resumeSkill.getSkillId();
						if((skillId == resumeSkillId) && ((resumeSkill.getSkillType()).equalsIgnoreCase("primary")))
						{
							primarySkills = resumeSkillDesc.getSkillDesc();
							break;
						}
					}
					if(resumeSkillDesc.getSkillDesc().equalsIgnoreCase(primarySkills))
					{%>
	<option value="<%=resumeSkillDesc.getId()%>" selected><%=resumeSkillDesc.getSkillDesc()%></option>
	<%}else{%>
	<option value="<%=resumeSkillDesc.getId()%>"><%=resumeSkillDesc.getSkillDesc()%></option>
	<%}
			  	}
			}%>
</select> <label>Secondary Skills:</label> <select id="secondarySkills"
	name="<%=RequestConstants.SECONDARYSKILLS%>" size="6"
	validate="Secondary Skills,string,no" multiple class='list'>
	<%for(Resumeskillmaster resumeSkillDesc : resumeSkillDescList)
			{
				String secondarySkills=null;
				for(Resumeskill resumeSkill : resumeSkillList)
				{
					int skillId=resumeSkillDesc.getId();
					int resumeSkillId=resumeSkill.getSkillId();
					if((skillId==resumeSkillId) && ((resumeSkill.getSkillType()).equalsIgnoreCase("secondary")))
					{
							secondarySkills = resumeSkillDesc.getSkillDesc();
							break;
					}
				}
				if(resumeSkillDesc.getSkillDesc().equalsIgnoreCase(secondarySkills))
				{%>
	<option value="<%=resumeSkillDesc.getId()%>" selected><%=resumeSkillDesc.getSkillDesc()%></option>
	<%}else{%>
	<option value="<%=resumeSkillDesc.getId()%>"><%=resumeSkillDesc.getSkillDesc()%></option>
	<%}
			}%>
</select> <script type="text/javascript">
				document.editresume.<%=RequestConstants.YEARS%>.value="<%=resumePersonalDetails.getExperienceYear()%>";
				document.editresume.<%=RequestConstants.MONTHS%>.value="<%=resumePersonalDetails.getExperienceMonth()%>";
			</script> <label>Uploaded Resumes</label> <%int i=0;
			if(listOfUploads.size()!=0)
			{
				i=listOfUploads.size();
				Iterator listOfUploadsIterator=listOfUploads.iterator();
			while(i>0)
				{
					i--;
					String fileName=(String)listOfUploads.get(i);%> <a target="_blank"
	href="../uploads/rms_resume/<%=fileName%>">Resume<%=i+1%></a>&nbsp;&nbsp;

<%}
			}else{%>
<div class="msg">No Resume Attached</div>
<%}%>

<div class="clear"></div>



<label>Previous Remarks</label>
<div id="resumeremarks"><label class="value"> <%for(Resumeremarks resumeRemarks : resumeRemarksList)
					{%> <%=resumeRemarks.getRemarks() %> <br />
<%}%> </label></div>


<label><span>* </span>Remarks:</label> <textarea
	name="<%=RequestConstants.REMARKS%>"
	id="<%=RequestConstants.REMARKS %>" validate="Remarks,remarks,yes"
	onkeydown="refreshLength1(this.id,250)"
	onkeyup="refreshLength(this.id,250)"></textarea> <label>Upload
Resume<br />
(max. size 2MB)</label> <input type="file" name="<%=RequestConstants.UPLOAD%>"
	class="browse" />

<div class="clear"></div>
<label>Observer1:</label> <input type="text"
	name="<%=RequestConstants.OBSERVER1%>" validate="Observer1,remarks,no"
	value="" maxlength="45" /> <label>Observer2:</label> <input
	type="text" name="<%=RequestConstants.OBSERVER2%>"
	validate="Observer2,remarks,no" value="" maxlength="45" /> <label>Observer3:</label>
<input type="text" name="<%=RequestConstants.OBSERVER3%>"
	validate="Observer3,remarks,no" value="" maxlength="45" />
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label>
<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="<%=RequestConstants.EDIT%>" value="Update"
	class="button" onClick="return editResume()" /> <input type="button"
	name="back" value="Back" class="button" onClick="history.back()">
<div class="clear"></div>
<div class="paddingTop40"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>



<script>

	function changeRsumeThrough(obj){
		if(obj.value == "Vender"||obj.value == "Job Portal" || obj.value == "Internal Reference" ){
			document.getElementById('labelNameForSource') = obj.value + ' Name';
			document.getElementById('empcode').style.display = 'block';
			document.editresume.<%=RequestConstants.NAMEOFSOURCE%>.focus();
			if(document.editresume.<%=RequestConstants.NAMEOFSOURCE%>.getAttribute('validate').substring(document.editresume.<%=RequestConstants.REFERENCEBY%>.getAttribute('validate').length-2)=='no'){
			   document.editresume.<%=RequestConstants.NAMEOFSOURCE%>.setAttribute('validate',document.editresume.<%=RequestConstants.REFERENCEBY%>.getAttribute('validate').substring(0,document.editresume.<%=RequestConstants.REFERENCEBY%>.getAttribute('validate').length-2)+'yes')
			}
		}	
		else{
			document.getElementById('empcode').style.display = 'none';
			document.editresume.<%=RequestConstants.NAMEOFSOURCE%>.value = ""
		    if(document.editresume.<%=RequestConstants.NAMEOFSOURCE%>.getAttribute('validate').substring(document.editresume.<%=RequestConstants.REFERENCEBY%>.getAttribute('validate').length-3)=='yes'){
			   document.editresume.<%=RequestConstants.NAMEOFSOURCE%>.setAttribute('validate',document.editresume.<%=RequestConstants.REFERENCEBY%>.getAttribute('validate').substring(0,document.editresume.<%=RequestConstants.REFERENCEBY%>.getAttribute('validate').length-3)+'no')
			}
		}
		if(obj.value != "Vendor"){
			if(document.editresume.<%=RequestConstants.EMAIL%>.getAttribute('validate').substring(document.editresume.<%=RequestConstants.EMAIL%>.getAttribute('validate').length-2)=='no'){
			   document.editresume.<%=RequestConstants.EMAIL%>.setAttribute('validate',document.editresume.<%=RequestConstants.EMAIL%>.getAttribute('validate').substring(0,document.editresume.<%=RequestConstants.EMAIL%>.getAttribute('validate').length-2)+'yes')
			   document.getElementById('emailStar').style.visibility='visible';
			}
		}	
		else{
		    if(document.editresume.<%=RequestConstants.EMAIL%>.getAttribute('validate').substring(document.editresume.<%=RequestConstants.EMAIL%>.getAttribute('validate').length-3)=='yes'){
			   document.editresume.<%=RequestConstants.EMAIL%>.setAttribute('validate',document.editresume.<%=RequestConstants.EMAIL%>.getAttribute('validate').substring(0,document.editresume.<%=RequestConstants.EMAIL%>.getAttribute('validate').length-3)+'no')
			   document.getElementById('emailStar').style.visibility='hidden';
			}
		}
	}

	function disableField(obj) {
		if (obj.value == "") {
			document.editresume.<%=RequestConstants.VISAREMARKS%>.readOnly = true;
		} else {
			visaSelect[visaSelect.length]=obj.value;
			document.editresume.<%=RequestConstants.VISAREMARKS%>.readOnly = false;
		}
	}

	function editResume() {
	    <%if(resumePersonalDetails.getResumeThrough()!=null){%>
	    if(document.editresume.<%=RequestConstants.RESUMETHROUGH%>.value == "Internal Reference"){
    		if(document.editresume.<%=RequestConstants.NAMEOFSOURCE%>.value == ""){
        		if(document.editresume.<%=RequestConstants.NAMEOFSOURCE%>.getAttribute('validate').substring(document.editresume.<%=RequestConstants.REFERENCEBY%>.getAttribute('validate').length-2)=='no'){
					document.editresume.<%=RequestConstants.NAMEOFSOURCE%>.setAttribute('validate',document.editresume.<%=RequestConstants.REFERENCEBY%>.getAttribute('validate').substring(0,document.editresume.<%=RequestConstants.REFERENCEBY%>.getAttribute('validate').length-2)+'yes')
				}
			}
		}
		<%}%>
		document.editresume.<%=RequestConstants.EMAIL%>.disabled = false;
		document.editresume.<%=RequestConstants.FIRSTNAME%>.disabled = false;
		document.editresume.<%=RequestConstants.LASTNAME%>.disabled = false;
		var check=false;
		var errorMessage="";
		var skillCheck=false;
		var passportCheck=false;
		var ctcCheck=false;
		var passportExpiryDate=document.editresume.<%=RequestConstants.PASSPORTEXPIRYDATE%>.value;
		if(passportExpiryDate.length > 0)
		{
			var temp=document.editresume.<%=RequestConstants.PASSPORTNUMBER%>.value;
			if(temp.length==0){
				errorMessage+='Passport Number not selected \n';
				passportCheck=false;
			}else{
				passportCheck=true;
			}
		}else if(passportExpiryDate.length == 0)
			passportCheck=true;	
				
		var currentCTC=parseInt(document.editresume.<%=RequestConstants.CURRENTCTC%>.value);	
		var expectedCTC=parseInt(document.editresume.<%=RequestConstants.EXPECTEDSALARY%>.value);

		if(currentCTC == "" || expectedCTC == ""){
        	ctcCheck=true;         
		}
        else if(currentCTC > expectedCTC ){
        	errorMessage+='Current CTC cannot be greater than Expected CTC \n';
            ctcCheck=false;
		}
        else{
        	ctcCheck=true;
        }

		

		var primarySkills=document.editresume.<%=RequestConstants.PRIMARYSKILLS%>;
		var selectedPrimarySkills=new Array();
		var p=0;
		if(primarySkills.length>0)
		{
			for(var a=0;a<primarySkills.length;a++)
			{	
				var flag=primarySkills.options[a].selected;
				if(flag)
				{
					selectedPrimarySkills[p]=primarySkills.options[a].value;
					p++;
				}
			}
		}
		var secondarySkills=document.editresume.<%=RequestConstants.SECONDARYSKILLS%>;
		var selectedSecondarySkills=new Array();
		var skillAlReadySelected=new Array();
		var m=0;
		if(secondarySkills.length>0)
		{
			for(var a=0;a<secondarySkills.length;a++)
			{	
				var flag=secondarySkills.options[a].selected;
				if(flag)
				{
					selectedSecondarySkills[m]=secondarySkills.options[a].value;
					m++;
				}
			}
			var n=0;
			for(var common=0;common<selectedSecondarySkills.length;common++)
			{
				for(var nappy=0;nappy<selectedPrimarySkills.length;nappy++)
				{
					if(selectedSecondarySkills[common]==selectedPrimarySkills[nappy])
					{
						skillAlReadySelected[n]=selectedSecondarySkills[common];
						n++;
					}
				}
			}
		}
		if(skillAlReadySelected.length>0)
		{
			errorMessage+='Some or All of Secondary Skills are already selected';
			skillCheck=false;
		}
		else
			skillCheck=true;

		if(skillCheck && passportCheck  && ctcCheck){
			submitForm('editresume','resume?method=editResume&'+csrfTokenName+'='+csrfTokenValue,'chkPassingYear','checkPass','fileName');
		}else
		{
			alert(errorMessage);	
		}
	}

	function fileName()
	{
		var file=document.editresume.<%=RequestConstants.UPLOAD%>.value;
		var extension =file.substring(file.length-4);
		if(file != "")
		{
			if(extension != '.doc' && extension != '.rtf' && extension != '.txt' && extension != '.pdf')
			{	
				errorMsg +="Uploaded Resume can only be in .doc or .rtf or .txt and .pdf  format\n";
				return false;
			}
		}
		return true;
	}

	function chkPassingYear(){
		dobObj = document.editresume.<%=RequestConstants.DATEOFBIRTH%>;
		yearObj= document.editresume.<%=RequestConstants.YEARPASSING%>.value;
		empDOB= new Date(dobObj.value.substring(6),(dobObj.value.substring(3,5) - 1) ,dobObj.value.substring(0,2));
		if(document.editresume.<%=RequestConstants.YEARPASSING%>.value!="0"){
			if(yearObj - empDOB.getFullYear() < 14 ){
				errorMsg +="Year Of Passing is not valid.\n";
				return false;
			}
		}
		return true;
	}

	function changePassport()
	{
		if(document.editresume.<%=RequestConstants.PASSPORTSTATUS %>.value =='Yes')
		{
			document.getElementById('pass1').style.display = 'block';
			document.getElementById('visa').style.display = 'block';
		}
		else if(document.editresume.<%=RequestConstants.PASSPORTSTATUS %>.value =='No')
		{
			document.getElementById('passNo').value='';
			document.getElementById('passDate').value='';

			document.getElementById('pass1').style.display = 'none';
			document.getElementById('visa').style.display = 'none';
		}
		else
		{
			document.getElementById('passNo').value='';
			document.getElementById('passDate').value='';

			document.getElementById('pass1').style.display = 'none';
			document.getElementById('visa').style.display = 'block';
		}
	}

	function checkPass()
	{
		var isValid1 = true;
		if(document.editresume.<%=RequestConstants.PASSPORTSTATUS %>.value =='Yes')
		{
			if(document.editresume.<%=RequestConstants.PASSPORTNUMBER %>.value == ''){
    			errorMsg += "Passport Number Not selected\n";
    			isValid1 = false;
		   	}
		   	if(document.editresume.<%=RequestConstants.PASSPORTEXPIRYDATE %>.value.length == 0){
    			errorMsg += "Passport Date Not Selected\n";
    			isValid1 = false;
		   	}
		   	if(!isValid1)
		   	{

	   			return false;
		   	}
			return true;
		}
    	return true;
	}

	function changePrimary()
	{
		var primary = document.getElementById('primarySkills');
		var secondary = document.getElementById('secondarySkills');
		var j=0;
		for(var i=secondary.options.length-1;i>=0;i--)
		{
			secondary.remove(i);
		}
		for(var i=0;i<primary.options.length;i++)
		{
			if(primary.options[i].selected)
			{
				<%for(Resumeskillmaster Resumeskillmaster: resumeSkillDescList)
				{%>
					if(primary.options[i].value==<%=Resumeskillmaster.getSkillParent()%>)
					{
						secondary.options[j]=new Option(' <%=Resumeskillmaster.getSkillDesc()%>','<%=Resumeskillmaster.getId()%>', false, false);
						j=j+1;
					}
				<%}%>
			}
		}
	}
	
	var str="";
	function checkUpLength(obj)
	{
	  	var len = obj.value.length;
  		if(len>1500)
	  	{
  			obj.value = str;
	  	}
  		len = obj.value.length;
	}

	function checkDownLength(obj)
	{
  		var len = obj.value.length;
	  	if(len<=1500)
  		{
			str=obj.value;
		}
	  	checkUpLength(obj);
	}
	
	
	function showOthers()
	{
	 if(document.getElementById('project').value!="" && document.getElementById('project').value==0)
	 {
	  document.getElementById("othersprojectlabel").style.visibility = "visible";
  	  document.getElementById("othersprojecttext").style.visibility = "visible";
	 }
	 else
	 {
	  document.getElementById("othersprojectlabel").style.visibility = "hidden";
  	  document.getElementById("othersprojecttext").style.visibility = "hidden";
	 }
	}
	function populateAddressFields()
	{
	
	}
</script>