

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasInstitute"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.HrMasCourse"%>
<%@page import="jkt.hrms.masters.business.HrMasInstructor"%>


<%
				Map map = new HashMap();
				if (request.getAttribute("map") != null) {
					map = (Map) request.getAttribute("map");
				}
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<HrMasCourse> courseList = new ArrayList<HrMasCourse>();
				List<HrMasInstructor> instructorList = new ArrayList<HrMasInstructor>();
				List<HrMasLocation> locationList = new ArrayList<HrMasLocation>();
				List<HrTrainingEffective> trainingEffectiveList = new ArrayList<HrTrainingEffective>();
				List<HrMasInstitute> instituteList = new ArrayList<HrMasInstitute>();
				List<HrTrainingEvaluation> trainingEvaluationList = new ArrayList<HrTrainingEvaluation>();
				Map<String,Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map) HMSUtil.getCurrentDateAndTime();
				String date = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");
				
				if (map.get("locationList") != null) {
					locationList = (List) map.get("locationList");
				}
				if (map.get("trainingEvaluationList") != null) {
					trainingEvaluationList = (List) map.get("trainingEvaluationList");
				}
				if (map.get("employeeList") != null) {
					employeeList = (List) map.get("employeeList");
				}
				if (map.get("courseList") != null) {
					courseList = (List) map.get("courseList");
				}
				if (map.get("instructorList") != null) {
					instructorList = (List) map.get("instructorList");
				}
				if (map.get("instituteList") != null) {
					instituteList = (List) map.get("instituteList");
				}
				if (map.get("trainingEffectiveList") != null) {
					trainingEffectiveList = (List) map.get("trainingEffectiveList");
				}
			
				String userName = "";
				if (session.getAttribute("userName") != null) {
					userName = (String) session.getAttribute("userName");
				}
				if (map.get("message") != null) {
					String message = (String) map.get("message");
					out.println(message);
				}
				Users users = new Users();
				if(map.get("users")!= null){
					users = (Users)map.get("users");
				}
				int employeeId = 0;
				String employeeName = "";
				for(MasEmployee masEmployee :employeeList){
					employeeId = masEmployee.getId();
				}
%>
<%@page import="jkt.hrms.masters.business.HrTrainingEffective"%>
<%@page import="jkt.hrms.masters.business.HrMasLocation"%>
<%@page import="jkt.hrms.masters.business.HrTrainingEvaluation"%>
<%@page import="jkt.hms.masters.business.Users"%>
<script type="text/javascript">
	
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
	
	</script>




<div class="clear"></div>
<div class="titleBg">
<h2>Training Evaluation</h2>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript">
	formFields = [
			[0, "<%= TRAINING_EVALUATION_ID%>", "id"], [1,"<%= EMPLOYEE_ID%>"], [2,"<%= FEED_BACK_DATE %>"], [3,"<%= HELD_ON_DATE %>"], [4,"<%= COURSE_ID %>"],  [5,"<%= INSTRUCTOR_ID %>"], [6,"<%=LOCATION_ID %>"], [7,"<%=PRE_COURSE_A %>"], [8,"<%=PRE_COURSE_B%>"], [9,"<%=PRE_COURSE_C %>"], [10,"<%= COURSE_CONTENT_A %>"], [11,"<%= COURSE_CONTENT_B %>"], [12,"<%=COURSE_CONTENT_C%>"], [13,"<%= JOB_APPLICABILITY_A %>"],[14,"<%= JOB_APPLICABILITY_B%>"], [15,"<%= JOB_APPLICABILITY_C1%>"],[16,"<%= JOB_APPLICABILITY_C2%>"], [17,"<%= TUTOR_A %>"],[18,"<%= TUTOR_B %>"],[19,"<%=TUTOR_C%>"],
[20,"<%= TUTOR_D%>"],[21,"<%= TUTOR_E%>"],[22,"<%= TUTOR_F%>"],[23,"<%= GENERAL_A%>"],[24,"<%= GENERAL_B%>"],[25,"<%= AVERAGE_RATING%>"],[26,"<%= REMARK%>"],[27,"<%= CHANGED_BY%>"],[28,"<%= CHANGED_DATE%>"],[29,"<%= CHANGED_TIME%>"],[30,"<%= STATUS%>"],[31,"<%= EMPLOYEE_HIDDEN_ID%>"], ];
	 statusTd = 30;
	</script></div>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<form name="trainingEvaluation" method="post" action=""><label><span>*</span>
Employee Name</label> <%
	for(MasEmployee masEmployee :employeeList){
%> <label><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName() %></label>
<input type="hidden" name="<%=EMPLOYEE_HIDDEN_ID %>"
	value="<%=masEmployee.getId()  %>" /> <%} %> <label><span>*</span>Course
Held On </label> <input type="text" name="<%=HELD_ON_DATE %>" value=""
	class="date" readonly="readonly" validate="Held On date date ,date,yes"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',document.trainingEvaluation.<%=HELD_ON_DATE%>,event)" />
<label><span>*</span> Course Code</label> <select name="<%=COURSE_ID %>"
	validate="Course Name,string,yes">
	<option value="0">Select</option>
	<%for(HrMasCourse hrMasCourse :courseList){ %>
	<option value="<%=hrMasCourse.getId() %>"><%=hrMasCourse.getCourseName()%></option>
	<%} %>
</select>

<div class="clear"></div>
<label><span>*</span> Instructor Name</label> <select
	name="<%=INSTRUCTOR_ID %>" validate="Instructor Name,string,yes">
	<option value="0">Select</option>
	<%for(HrMasInstructor hrMasInstructor :instructorList){ %>
	<option value="<%=hrMasInstructor.getId() %>"><%=hrMasInstructor.getInstructorName()%></option>
	<%} %>
</select> <label><span>*</span>Feed Back Date </label> <input type="text"
	name="<%=FEED_BACK_DATE %>" value="" class="date" readonly="readonly"
	validate="Feed back date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.trainingEvaluation.<%=FEED_BACK_DATE%>,event)" />

<label><span>*</span> Location</label> <select name="<%=LOCATION_ID %>"
	validate="Location Name,string,yes">
	<option value="0">Select</option>
	<% for(HrMasLocation hrMasLocation :locationList){ %>
	<option value="<%=hrMasLocation.getId() %>"><%=hrMasLocation.getLocationName()%></option>
	<%} %>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Pre-Course</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label class="large"> A) Clarity of course objectives</label> <select
	class="small" name="<%=PRE_COURSE_A %>"
	validate="Pre-CourseA,string,no">
	<option value="0">-Select---</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label> <label class="large1">B)
Understanding between you and your supervisor regarding your purpose of
attending the course.</label> <select class="small" name="<%=PRE_COURSE_B %>"
	validate="Pre-CourseB,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label>
<div class="clear"></div>
<label class="large"> C) Your level of competence in course
skills/knowledge prior to attending this course.</label> <select class="small"
	name="<%=PRE_COURSE_C %>" validate="Pre-CourseC,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Course Content</h4>
<div class="clear"></div>
<div class="Block"><label class="large"> A)The match
between course content and your particular needs</label> <select class="small"
	name="<%=COURSE_CONTENT_A %>" validate="Course ContentA,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label> <label class="large1">
B)Understanding between you and your supervisor regarding your purpose
of attending the course.</label> <select class="small"
	name="<%=COURSE_CONTENT_B %>" validate="Course ContentB,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label>
<div class="clear"></div>
<label class="large"> C)Your level of competence in course
skills/knowledge prior to attending this course. </label> <select class="small"
	name="<%=COURSE_CONTENT_C %>" validate="Course ContentC,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label>
<div class="clear"></div>
</div>
<h4>Job Applicability</h4>
<div class="clear"></div>
<div class="Block"><label class="large"> A)Extent to which
you learned new skill/knowledge /behaviour</label> <select class="small"
	name="<%=JOB_APPLICABILITY_A %>"
	validate="Job ApplicabilityA,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label> <label class="large1">
B)Extent to which the course will help you perform your job more
effectively.</label> <select class="small" name="<%=JOB_APPLICABILITY_B %>"
	validate="Job ApplicabilityB,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label>
<div class="clear"></div>
<label class="large"> C)List two more immediate job applications
that you can see benefiting from the skills/knowledge/behaviour learned
on this course. </label>
<div class="paddRight"><input type="text"
	name="<%=JOB_APPLICABILITY_C1 %>" value=""
	validate="Job ApplicabilityC1,string,no" maxlength="100" /></div>
<input type="text" name="<%=JOB_APPLICABILITY_C2 %>" value=""
	validate="Job ApplicabilityC2,string,no" maxlength="100" />

<div class="clear"></div>
</div>
<h4>Tutors</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label class="large"> A) Level of knowledge about the subject</label> <select
	class="small" name="<%=TUTOR_A %>" validate="TutorA,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label> <label class="large1">
B)Standard of presentation.</label> <select class="small" name="<%=TUTOR_B %>"
	validate="TutorB,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label>
<div class="clear"></div>
<label class="large"> C)Approchability and friendliness.</label> <select
	class="small" name="<%=TUTOR_C %>" validate="TutorC,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label> <label class="large1">
D)Provision of feedback of course participant.</label> <select class="small"
	name="<%=TUTOR_D %>" validate="TutorD,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label>
<div class="clear"></div>
<label class="large"> E)Level of participant involvement.</label> <select
	class="small" name="<%=TUTOR_E %>" validate="TutorE,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label> <label class="large1">F)Overall
Standard of tutor(s).</label> <select class="small" name="<%=TUTOR_F %>"
	validate="TutorF,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>General</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label class="large"> A)Standard of course Administration</label> <select
	class="small" name="<%=GENERAL_A %>" validate="GeneralA,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label> <label class="large1">
B)Facilities at the training venue.</label> <select class="small"
	name="<%=GENERAL_B %>" validate="GeneralB,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="small">5=max.</label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<label><span>*</span> Average Rating </label>
<select class="small" name="<%=AVERAGE_RATING %>"
	validate="Average Rating,string,yes">
	<option value="0">Select</option>
	<%	for(int i=0;i<=5;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select>

<label>Remarks</label>
<input type="text" name="<%= REMARKS %>" value=""
	validate="Remarks,string,no" class="large" MAXLENGTH="60" tabindex=1 />
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('trainingEvaluation','training?method=saveTrainingEvaluation');"
	accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update"
	style="display: none;" class="button"
	onClick="submitForm('trainingEvaluation','training?method=editTrainingEvaluation')"
	accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate"
	class="button" style="display: none;"
	onClick="submitForm('training','training?method=deleteTrainingMaster&flag='+this.value)"
	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>


<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= TRAINING_EVALUATION_ID%>" value="" />

<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Emp Code"
data_header[0][1] = "data";
data_header[0][2] = "";
data_header[0][3] = "<%= EMPLOYEE_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Evaluation Date"
data_header[1][1] = "data";
data_header[1][2] = "";
data_header[1][3] = "<%= FEED_BACK_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "Held On Date"
data_header[2][1] = "data";
data_header[2][2] = "";
data_header[2][3] = "<%= HELD_ON_DATE%>";

data_header[3] = new Array;
data_header[3][0] = "Course Code"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "<%= COURSE_ID%>";


data_header[4] = new Array;
data_header[4][0] = "Instructor"
data_header[4][1] = "data";
data_header[4][2] = "";
data_header[4][3] = "<%= INSTRUCTOR_ID%>";

data_header[5] = new Array;
data_header[5][0] = "Institute"
data_header[5][1] = "data";
data_header[5][2] = "";
data_header[5][3] = "<%= LOCATION_ID%>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "";
data_header[6][3] = "<%= PRE_COURSE_A%>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "";
data_header[7][3] = "<%= PRE_COURSE_B%>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "";
data_header[8][3] = "<%= PRE_COURSE_C%>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "";
data_header[9][3] = "<%= COURSE_CONTENT_A%>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "";
data_header[10][3] = "<%= COURSE_CONTENT_B%>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "";
data_header[11][3] = "<%= COURSE_CONTENT_C%>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "";
data_header[12][3] = "<%= JOB_APPLICABILITY_A%>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%=JOB_APPLICABILITY_B %>"

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%=JOB_APPLICABILITY_C1 %>"

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = "";
data_header[15][3] = "<%=JOB_APPLICABILITY_C2 %>";

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = "";
data_header[16][3] = "<%=TUTOR_A %>";

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = "";
data_header[17][3] = "<%=TUTOR_B %>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = "";
data_header[18][3] = "<%=TUTOR_C %>";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = "";
data_header[19][3] = "<%=TUTOR_D %>";

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = "";
data_header[20][3] = "<%=TUTOR_E %>";

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = "";
data_header[21][3] = "<%=TUTOR_F %>";

data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = "";
data_header[22][3] = "<%=GENERAL_A%>";

data_header[23] = new Array;
data_header[23][0] = ""
data_header[23][1] = "hide";
data_header[23][2] = "";
data_header[23][3] = "<%=GENERAL_B%>";

data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = "";
data_header[24][3] = "<%=AVERAGE_RATING%>";

data_header[25] = new Array;
data_header[25][0] = ""
data_header[25][1] = "hide";
data_header[25][2] = "";
data_header[25][3] = "<%=REMARK%>";

data_header[26] = new Array;
data_header[26][0] = ""
data_header[26][1] = "hide";
data_header[26][2] = "";
data_header[26][3] = "<%=CHANGED_BY%>";

data_header[27] = new Array;
data_header[27][0] = ""
data_header[27][1] = "hide";
data_header[27][2] = "";
data_header[27][3] = "<%=CHANGED_DATE%>";

data_header[28] = new Array;
data_header[28][0] = ""
data_header[28][1] = "hide";
data_header[28][2] = "";
data_header[28][3] = "<%=CHANGED_TIME%>";

data_header[29] = new Array;
data_header[29][0] = ""
data_header[29][1] = "hide";
data_header[29][2] = "";
data_header[29][3] = "<%=STATUS%>";

data_header[30] = new Array;
data_header[30][0] = ""
data_header[30][1] = "hide";
data_header[30][2] = "";
data_header[30][3] = "<%=EMPLOYEE_HIDDEN_ID%>";

data_arr = new Array();

<%
Iterator itr=trainingEvaluationList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
            HrTrainingEvaluation  hrTrainingEvaluation= (HrTrainingEvaluation)itr.next(); 
            
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrTrainingEvaluation.getId()%>
<%
	for(MasEmployee masEmployee :employeeList){
			if(hrTrainingEvaluation.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode()%>"
<%
		}
	}

%>
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(hrTrainingEvaluation.getFeedbackDate())%>"

data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(hrTrainingEvaluation.getCourseHeldOnDate())%>"
<%
	for(HrMasCourse hrMasCourse :courseList){
			if(hrTrainingEvaluation.getCourse().getId().equals(hrMasCourse.getId())){
%>
data_arr[<%= counter%>][4] = "<%=hrMasCourse.getCourseName()%>"
<%
		}
	}

%>		

<%
	for(HrMasInstructor hrMasInstructor:instructorList){
			if(hrTrainingEvaluation.getInstructor().getId().equals(hrMasInstructor.getId())){
%>
data_arr[<%= counter%>][5] = "<%=hrMasInstructor.getInstructorName()%>"
<%
		}
	}

%>		


<%
	for(HrMasLocation hrMasLocation :locationList){
			if(hrTrainingEvaluation.getLocation().getId().equals(hrMasLocation.getId())){
%>
data_arr[<%= counter%>][6] = "<%=hrMasLocation.getLocationName()%>"
<%
		}
	}

%>		

 data_arr[<%= counter%>][7] = "<%=hrTrainingEvaluation.getPreCoursea()%>"
            
            
 data_arr[<%= counter%>][8] = "<%=hrTrainingEvaluation.getPreCourseb()%>"
            
 data_arr[<%= counter%>][9] = "<%=hrTrainingEvaluation.getPreCoursec()%>"
data_arr[<%= counter%>][10] = "<%=hrTrainingEvaluation.getCouseContenta()%>"
data_arr[<%= counter%>][11] = "<%= hrTrainingEvaluation.getCourseContentb()%>"
data_arr[<%= counter%>][12] = "<%=hrTrainingEvaluation.getCourseContentc()%>"
data_arr[<%= counter%>][13] = "<%=hrTrainingEvaluation.getJobApplicabilitya()%>"      
data_arr[<%= counter%>][14] = "<%= hrTrainingEvaluation.getJobApplicabilityb()%>"       
data_arr[<%= counter%>][15] = "<%=hrTrainingEvaluation.getJobApplicabilityc1() %>"
data_arr[<%= counter%>][16] = "<%= hrTrainingEvaluation.getJobApplicabilityc2() %>"
data_arr[<%= counter%>][17] = "<%= hrTrainingEvaluation.getTutorA() %>"
data_arr[<%= counter%>][18] = "<%= hrTrainingEvaluation.getTutorB() %>"
data_arr[<%= counter%>][19] = "<%= hrTrainingEvaluation.getTutorC() %>"
data_arr[<%= counter%>][20] = "<%= hrTrainingEvaluation.getTutorD() %>"
data_arr[<%= counter%>][21] = "<%= hrTrainingEvaluation.getTutorE() %>"
data_arr[<%= counter%>][22] = "<%= hrTrainingEvaluation.getTutorF() %>"
data_arr[<%= counter%>][23] = "<%= hrTrainingEvaluation.getGeneralA() %>"
data_arr[<%= counter%>][24] = "<%= hrTrainingEvaluation.getGeneralB() %>"
data_arr[<%= counter%>][25] = "<%= hrTrainingEvaluation.getAverageRating() %>"
data_arr[<%= counter%>][26] = "<%= hrTrainingEvaluation.getRemarks() %>"
data_arr[<%= counter%>][27] = "<%= hrTrainingEvaluation.getLastChgBy() %>"
data_arr[<%= counter%>][28] = "<%=HMSUtil.convertDateToStringWithoutTime(hrTrainingEvaluation.getLastChgDate()) %>"
data_arr[<%= counter%>][29] = "<%= hrTrainingEvaluation.getLastChgTime() %>"
<% if(hrTrainingEvaluation.getStatus().equals("y")){ %>
data_arr[<%= counter%>][30] = "Active"
<%}else{%>
data_arr[<%= counter%>][30] = "InActive"
<%}%>
data_arr[<%= counter%>][31] = "<%=hrTrainingEvaluation.getEmployee().getId()%>"
<%
		     counter++;
}
%>
 
formName = "trainingEvaluation"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
