<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@ page import="jkt.hrms.masters.business.MasInstitute"%>
<%@ page import="jkt.hrms.masters.business.MasApplicant"%>
<%@ page import="jkt.hrms.masters.business.MasDurationType"%>
<%@ page import="jkt.hrms.masters.business.MasSplQualification"%>
<%@ page import="jkt.hrms.masters.business.MasCourse"%>
<%@ page import="jkt.hrms.masters.business.MasQualification"%>

<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>


<html xmlns="http://www.w3.org/1999/xhtml">

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>EHA Hospital Management System</title>
<link href="../HrmsJsp/EHA/css/style.css" rel="stylesheet"
	type="text/css"></link>
<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/calendar.js"></script>
<script type="text/javascript" src="../HrmsJsp/EHA/js/tabcontent.js"></script>
<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/common.js"></script>

<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/hms.js"></script>

<script type="text/javascript"
	src="../HrmsJsp/EHA/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="../HrmsJsp/EHA/js/animatedcollapse.js"></script>

<script type="text/javascript">
animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('title3', 'fade=0,speed=400,group=pets')

animatedcollapse.init()
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/calendar.js"></script>
<script type="text/javascript" src="../HrmsJsp/EHA/js/tabcontent.js"></script>
<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<script type="text/javascript">


function check(){

static int cnt=1;
var SDate = document.applicantEducation.<%=START_DATE%>+cnt.value;
var EDate = document.applicantEducation.<%=END_DATE%>+cnt.value;

if (SDate == '' || EDate == '') {
alert("Plesae enter both....");
return false;
}

var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the End Date is greater than or equal to the Start Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>




<!--Main Div starts here-->
<div id="main"><!--tab content starts--> <%  	MasApplicant masApplicant=null;
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String time = (String)utilMap.get("currentTime");
	 
	 		Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
	
			
			
			
			List<MasDurationType> masDurationTypeList=new ArrayList<MasDurationType>();
			List<MasCourse> courseList=new ArrayList<MasCourse>();
			List<MasSplQualification> splQualificationList = new ArrayList<MasSplQualification>();
			List<MasInstitute> instituteList = new ArrayList<MasInstitute>();
			
			List<MasQualification> qualificationList=new 	ArrayList<MasQualification>();
			
			
		
			
			
			
			if(map.get("masDurationTypeList") != null){
				masDurationTypeList = (List<MasDurationType>)map.get("masDurationTypeList");
			}
			if(map.get("courseList") != null){
				courseList = (List<MasCourse>)map.get("courseList");
			}
			
			if(map.get("instituteList") != null){
				instituteList = (List<MasInstitute>)map.get("instituteList");
			}
			if(map.get("qualificationList") != null){
				qualificationList = (List<MasQualification>)map.get("qualificationList");
			}
	
			
			
			
			if(map.get("masApplicant") != null){
				masApplicant =(MasApplicant) map.get("masApplicant");
			}
			
			
			
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String bangaloreDistrictCode = properties.getProperty("bangaloreDistrictCode");
			String karnatakaStateCode = properties.getProperty("karnatakaStateCode");
			String indiaCode = properties.getProperty("indiaCode");
		String 	selectedTitleForReg=properties.getProperty("selectedTitleForReg");			
			
			
			%>



<form name="applicantEducation" action="" id="applicantEducation"
	method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%for(int count=1;count<=3;count++){
%>
<div class="titleBg"><a
	href="javascript:animatedcollapse.toggle('<%="title"+count%>')">
<h2>Applicant Education Details <%=count%></h2>
</a></div>
<div class="Block"><label class="auto">Applicant Code</label> <input
	value="<%=masApplicant.getApplicantCode() %>" type="text" class="small" />

<input
	value="<%=masApplicant.getFirstName()+masApplicant.getLastName() %>"
	type="text" />

<div class="clear"></div>
<div class="division"></div>
<div class="paddLeft55"><label class="auto">Education</label> <input
	name="<%=EDUCATION_TYPE+count%>" type="radio" value="education"
	class="radioCheck" /> <label class="auto">Training</label> <input
	name="<%=EDUCATION_TYPE+count%>" type="radio" value="training"
	class="radioCheck" /> <label class="auto">Special
Qualification</label> <input name="<%=EDUCATION_TYPE+count%>" type="radio"
	value="special" class="radioCheck" />

<div class="clear"></div>
</div>

<div class="division"></div>
<label>Qualification Obt. <span>*</span></label> <select
	id="<%=QUALIFICATION_OBTAINED+count%>"
	name="<%=QUALIFICATION_OBTAINED+count%>" class="select_adt"
	validate="String,string,no">
	<option value="0">Select</option>
	<%
			 	for (MasQualification masQualification : qualificationList) 

				{ 
				
	      %>
	<option value="<%=masQualification.getId()%>"><%=masQualification.getQualificationName()%></option>
	<%
								}
						
				%>
</select> <label>Institute</label> <select name="<%=INSTITUTE_LIST+count%>"
	id="<%=INSTITUTE_LIST+count%>" class="select_adt"
	validate="String,string,no">
	<option value="0">Select</option>
	<% 	for (MasInstitute masInstitue : instituteList) 

				{ 
				
	      %>
	<option value="<%=masInstitue.getId()%>"><%=masInstitue.getInstituteName()%></option>
	<%
								}
						
				%>
</select> <label>Course </label> <select name="<%=COURSE+count%>"
	id="<%=COURSE+count%>" class="select_adt" validate="String,string,no">
	<option value="0">Select</option>
	<% 	for (MasCourse masCourse : courseList) 

				{ 
				
	      %>
	<option value="<%=masCourse.getId()%>"><%=masCourse.getCourseName()%></option>
	<%
								}
						
				%>
</select>

<div class="clear"></div>

<label>Special Qualification</label> <select
	name="<%=SPL_QUALIFICATION+count%>" id="<%=SPL_QUALIFICATION+count%>"
	class="select_adt" validate="String,string,no">
	<option value="0">Select</option>
	<% 	for (MasSplQualification masSplQualification : splQualificationList) 

				{ 
				
	      %>
	<option value="<%=masSplQualification.getId()%>"><%=masSplQualification.getSplQualificationName()%></option>
	<%
								}
						
				%>
</select> <label>Start Date</label> <input type="text" value=""
	name="<%=START_DATE+count %>" id="<%=START_DATE+count %>" tabindex="1"
	class="date" readonly="readonly" validate="Start Date,date,no"
	MAXLENGTH="30" /> <a
	href="javascript:setdate('',document.applicantEducation.<%=START_DATE+count %>)">
<img src="../HrmsJsp/EHA/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" tabindex="1" class="calender" /> </a> <label>End
Date</label> <input type="text" value="" name="<%=END_DATE+count %>"
	id="<%=END_DATE+count %>" tabindex="1" class="date" readonly="readonly" />
<a
	href="javascript:setdate('',document.applicantEducation.<%=END_DATE+count %>)">
<img src="../HrmsJsp/EHA/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" tabindex="1" class="calender" /> </a>

<div class="clear"></div>

<label>Course Duration </label> <input name="<%=COURSE_DURATION+count%>"
	type="text" class="small" /> <select name="<%=DURATION_TYPE+count%>"
	id="<%=DURATION_TYPE+count%>" class="select_adt"
	validate="String,string,no">
	<option value="0">Select</option>
	<% 	for (MasDurationType masDurationType : masDurationTypeList) 

				{ 
				
	      %>
	<option value="<%=masDurationType.getId()%>"><%=masDurationType.getDurationTypeName()%></option>
	<%
								}
						
				%>
</select> <label>Qualified Date</label> <input type="text" value=""
	name="<%=QUALIFIED_DATE+count %>" id="<%=QUALIFIED_DATE+count %>"
	tabindex="1" class="date" readonly="readonly" /> <a
	href="javascript:setdate('',document.applicantEducation.<%=QUALIFIED_DATE+count %>)">
<img src="../HrmsJsp/EHA/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" tabindex="1" class="calender" /> </a> <label>Grade
Percentage</label> <input name="<%=PERCENTAGE+count%>" type="text" class="small" />

<div class="clear"></div>

<label>Awards</label> <input name="<%=AWARDS+count%>" type="text"
	class="large" />

<div class="clear"></div>

<label>Skills</label> <textarea name="<%=SKILLS+count%>" cols="0"
	rows="0" class="large"></textarea>
<div class="clear"></div>


<div class="division"></div>
</div>
<% }%> <input name="save" type="button" value="Save &amp; Continue"
	class="buttonBig"
	onClick="submitForm('applicantEducation','applicantReg?method=saveEducationalDetails');" />
<input name="save" type="button" value="Update" class="button" /> <input
	name="save" type="button" value="Back" class="button" />
<div class="clear"></div>
</div>
</html>
