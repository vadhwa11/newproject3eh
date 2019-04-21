<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasTitle"%>
<%@ page import="jkt.hrms.masters.business.MasApplicant"%>
<%@ page import="jkt.hrms.masters.business.MasDurationType"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="jkt.hrms.masters.business.MasInstitute"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hrms.masters.business.MasJob"%>
<%@ page import="jkt.hrms.masters.business.MasSplQualification"%>
<%@ page import="jkt.hrms.masters.business.MasCourse"%>
<%@ page import="jkt.hrms.masters.business.MasQualification"%>
<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>


<html xmlns="http://www.w3.org/1999/xhtml">

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>EHA Hospital Management System</title>
<link href="../HrmsJsp/EHA/css/style.css" rel="stylesheet"
	type="text/css"></link>
<script type="text/javascript" src="../HrmsJsp/EHA/js/tabcontent.js"></script>
<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/common.js"></script>

<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/calendar.js"></script>

<script type="text/javascript"
	src="../HrmsJsp/EHA/js/jquery-1.2.2.pack.js"></script>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>



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
%>serverdate = '<%=dateCal+"/"+month+"/"+year%>'</script>
<script type="text/javascript">
function check(){
var SDate = document.applicantExperience.<%= PRE_SER_START_DATE%>.value;
var EDate = document.applicantExperience.<%= PRE_SER_END_DATE %>.value;

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
<div id="main"><!--tab content starts--> <%  	String applicantCode="";
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String time = (String)utilMap.get("currentTime");
	 
	 		Map<String, Object> map = new HashMap<String, Object>();
			if(request.getAttribute("map") != null){
				map=(Map<String, Object>)request.getAttribute("map");
			}
	
			String userName = "";
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
			
			
			List<MasDurationType> 	masDurationTypeList=new ArrayList<MasDurationType> ();
			
			
			
			List<MasCountry> countryList = new ArrayList<MasCountry>();
			List<MasState> stateList = new ArrayList<MasState>();
			List<MasDistrict> districtList = new ArrayList<MasDistrict>();
			MasApplicant masApplicant=null;
			List<MasJob> jobList = new ArrayList<MasJob>();
		
			
			
			
			if(map.get("masDurationTypeList") != null){
				masDurationTypeList = (List<MasDurationType>)map.get("masDurationTypeList");
			}
			
		
			if(map.get("countryList") != null){
				countryList =(List<MasCountry>)map.get("countryList");
			}
			if(map.get("stateList") != null)	{
				stateList = (List<MasState>)map.get("stateList");
			}
			if(map.get("districtList") != null){
				districtList =(List<MasDistrict>)map.get("districtList");
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
			
			
			%> <script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
			
		</script>


<form name="applicantExperience" action="" id="applicantExperience"
	method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block"><label class="auto">Applicant Code<span>*</span></label>
<input type="text" value="<%=masApplicant.getApplicantCode() %>" />

<div class="clear"></div>

<label>Total Experience<span>*</span></label> <input
	name="<%=TOTAL_EXPERIENCE%>" type="text" class="small" /> <select
	name="<%=DURATION_TYPE%>" class="small">

	<option value="0">Select</option>
	<% 	for (MasDurationType masDurationType : masDurationTypeList) 

				{ 
				
	      %>
	<option value="<%=masDurationType.getId()%>"><%=masDurationType.getDurationTypeName()%></option>
	<%
								}
						
				%>
</select>
<div class="clear"></div>
<label>Current Employer <span>*</span></label> <input
	name="<%=CURRENT_EMPLOYER%>" type="text" />
<div class="clear"></div>
<label>City <span>*</span></label> <select id="districtId"
	name="<%=DISTRICT%>" validate="String,string,no" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
    	for(MasDistrict masDistrict : districtList){
			if(masDistrict.getState() != null){
				if(masDistrict.getState().getStateCode().equals(karnatakaStateCode))
				{
					if(masDistrict.getDistrictCode().equals(bangaloreDistrictCode))
					{
	%>
	<option value="<%=masDistrict.getId()%>" selected="selected"><%=masDistrict.getDistrictName()%></option>
	<%				}else{ %>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%				}
				}
			}
      
							}
				%>
</select> <label>State <span>*</span></label><select id="stateId"
	name="<%=STATE%>" validate="String,string,no" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
    	for(MasState masState : stateList){
			if(masState.getCountry() != null){
				if(masState.getCountry().getCountryCode().equals(indiaCode))
				{
					if(masState.getStateCode().equals(karnatakaStateCode))
					{
	%>
	<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName() %></option>
	<%				}else{ %>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%				}
				}
			}
							}
				%>

</select> <label>Country <span>*</span></label> <select id="countryId"
	name="<%=COUNTRY%>" validate="String,string,no" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
			 	for (MasCountry masCountry :countryList) 

				{ 
			 		

					%>
	<option value="<%=masCountry.getId() %>" selected="selected"><%=masCountry.getCountryName() %></option>
	<%		
       
      
							}
				%>

</select>

<div class="clear"></div>


<label>Address <span>*</span></label> <textarea name="<%=ADDRESS %>"
	cols="0" rows="0"></textarea>

<div class="clear"></div>
<label>Current Serv Start Date <span>*</span></label> <input
	name="<%=CUR_SER_START_DATE %>" type="text" value=""
	id="<%=CUR_SER_START_DATE %>" tabindex="1" class="textbox_date"
	readonly="readonly" validate="Start Date,date,no" MAXLENGTH="30" /> <a
	href="javascript:setdate('',document.applicantExperience.<%=CUR_SER_START_DATE %>)">
<img src="../HrmsJsp/EHA/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" tabindex="1" class="calender"
	alt="date" /></a> <label>Current Serv End Date <span>*</span></label> <input
	name="<%=CUR_SER_END_DATE%>" type="text" value=""
	id="<%=CUR_SER_END_DATE %>" tabindex="1" class="textbox_date"
	readonly="readonly" validate="Start Date,date,no" MAXLENGTH="30" /> <a
	href="javascript:setdate('',document.applicantExperience.<%=CUR_SER_END_DATE %>)">
<img src="../HrmsJsp/EHA/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" tabindex="1" class="calender"
	alt="date" /></a>

<div class="clear"></div>



<label>Current Designation <span>*</span></label> <input
	name="<%=CURRENT_DESIGNATION %>" type="text" /> <label>Service
End Reason</label> <textarea name="<%=CUR_END_REASON%>" cols="0" rows="0"></textarea>

<div class="clear"></div>
<label>Previous Employer <span>*</span></label> <input
	name="<%=PREVIOUS_EMPLOYER%>" type="text" />
<div class="clear"></div>
<label>City <span>*</span></label> <select id="districtId"
	name="<%=PRE_DISTRICT%>" validate="String,string,no" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
    	for(MasDistrict masDistrict : districtList){
			if(masDistrict.getState() != null){
				if(masDistrict.getState().getStateCode().equals(karnatakaStateCode))
				{
					if(masDistrict.getDistrictCode().equals(bangaloreDistrictCode))
					{
	%>
	<option value="<%=masDistrict.getId()%>" selected="selected"><%=masDistrict.getDistrictName()%></option>
	<%				}else{ %>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%				}
				}
			}
      
							}
				%>
</select> <label>State <span>*</span></label><select id="stateId"
	name="<%=PRE_STATE%>" validate="String,string,no" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
    	for(MasState masState : stateList){
			if(masState.getCountry() != null){
				if(masState.getCountry().getCountryCode().equals(indiaCode))
				{
					if(masState.getStateCode().equals(karnatakaStateCode))
					{
	%>
	<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName() %></option>
	<%				}else{ %>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%				}
				}
			}
							}
				%>

</select> <label>Country <span>*</span></label> <select id="countryId"
	name="<%=PRE_COUNTRY%>" validate="String,string,no" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
			 	for (MasCountry masCountry :countryList) 

				{ 
			 		

					%>
	<option value="<%=masCountry.getId() %>" selected="selected"><%=masCountry.getCountryName() %></option>
	<%		
       
      
							}
				%>

</select>

<div class="clear"></div>



<label>Address <span>*</span></label> <textarea name="<%=PRE_ADDRESS%>"
	cols="0" rows="0"></textarea>

<div class="clear"></div>
<label>Previous Serv Start Date <span>*</span></label> <input
	name="<%=PRE_SER_START_DATE %>" type="text" value=""
	id="<%=PRE_SER_START_DATE %>" tabindex="1" class="textbox_date"
	readonly="readonly" validate="Start Date,date,no" MAXLENGTH="30" /> <a
	href="javascript:setdate('',document.applicantExperience.<%=PRE_SER_START_DATE %>)">
<img src="../HrmsJsp/EHA/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" tabindex="1" class="calender"
	alt="date" /></a> <label>Previous Serv End Date <span>*</span></label> <input
	name="<%=PRE_SER_END_DATE %>" type="text" value=""
	id="<%=PRE_SER_END_DATE %>" tabindex="1" class="textbox_date"
	readonly="readonly" validate="Start Date,date,no" MAXLENGTH="30" /> <a
	href="javascript:setdate('',document.applicantExperience.<%=PRE_SER_END_DATE %>)">
<img src="../HrmsJsp/EHA/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" tabindex="1" class="calender"
	alt="date" /></a>

<div class="clear"></div>



<label>Previous Designation <span>*</span></label> <input
	name="<%=PREVIOUS_DESIGNATION %>" type="text" /> <label>Service
End Reason</label> <textarea name="<%=PRE_END_REASON%>" cols="0" rows="0"></textarea>
<label>Awards</label> <textarea name="<%=AWARDS%>" cols="0" rows="0"></textarea>

<div class="clear"></div>

<label>Skills</label> <textarea name="<%=SKILLS %>" cols="0" rows="0"></textarea>
<label>Job Responsiblity</label> <textarea
	name="<%=JOB_RESPONSIBILTY %>" cols="0" rows="0"></textarea>

<div class="division"></div>

<div class="clear"></div>
</div>
<div class="division"></div>
<input name="save" type="button" value="Save" class="button"
	onClick="submitForm('applicantExperience','applicantReg?method=saveExperienceDetails');" />
<input name="save" type="button" value="Update" class="button" /> <input
	name="save" type="button" value="Back" class="button" />
<div class="clear"></div>
<div></div>
</form>

<!--Applicant Experience Ends-->
<div></div>
</html>