

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasInstitute"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.HrMasCourse"%>
<%@page import="jkt.hrms.masters.business.HrMasInstructor"%>

<style>
.Block label.large1 {
	width: 320px;
	margin-left: 20px;
}

.Block {
	border: 1px solid #cccccc;
	padding: 10px 0px 10px 0px;
}

.paddRight250 {
	float: right;
	padding-right: 250px;
}

.paddRight {
	float: right;
	padding-right: 250px;
}
</style>
<%
				Map map = new HashMap();
				if (request.getAttribute("map") != null) {
					map = (Map) request.getAttribute("map");
				}
				List<HrMasInstitute> instituteList = new ArrayList<HrMasInstitute>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<HrMasCourse> courseList = new ArrayList<HrMasCourse>();
				List<HrMasInstructor> instructorList = new ArrayList<HrMasInstructor>();
				List<HrTrainingEffective> trainingEffectiveList = new ArrayList<HrTrainingEffective>();
				Map<String,Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map) HMSUtil.getCurrentDateAndTime();
				String date = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");
				
				if (map.get("instituteList") != null) {
					instituteList = (List) map.get("instituteList");
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
				int employeeId = 0;
				String employeeName = "";
				for(MasEmployee masEmployee :employeeList){
					employeeId = masEmployee.getId();
					employeeName = masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName();
				}
 %>

<%@page import="jkt.hrms.masters.business.HrTrainingEffective"%>
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
<script type="text/javascript">

	function checkheldOnDate(){
		var eDate = document.trainingEffectivness.<%= EVALUATION_DATE%>.value;
		var hDate = document.trainingEffectivness.<%= HELD_ON_DATE %>.value;
	
		var	evaluationDate =new Date(eDate.substring(6),(eDate.substring(3,5) - 1) ,eDate.substring(0,2))
		var heldOnDate =new Date(hDate.substring(6),(hDate.substring(3,5) - 1) ,hDate.substring(0,2))
		if(evaluationDate != "" && heldOnDate != ""){
		if(heldOnDate < evaluationDate)
		{
			alert("Held On Date  should be  greater than or equal to the Evaluation Date.");
			document.trainingEffectivness.<%= EVALUATION_DATE%>.value = "";
			document.trainingEffectivness.<%= HELD_ON_DATE %>.value = "";
			return false;
			}
		}
		return true;
	}
</script>



<div class="clear"></div>
<div class="titleBg">
<h2>Training Effectivness</h2>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript">
	formFields = [
			[0, "<%= TRAINING_EFFECTIVNESS_ID%>", "id"], [1,"<%= EMPLOYEE_ID%>"], [2,"<%= EVALUATION_DATE %>"], [3,"<%= HELD_ON_DATE %>"], [4,"<%= COURSE_ID %>"],  [5,"<%= INSTRUCTOR_ID %>"], [6,"<%=INSTITUTE_ID %>"], [7,"<%=COURSE_EXPLAIN_A %>"], [8,"<%=COURSE_EXPLAIN_B %>"], [9,"<%=COURSE_MATERIAL %>"], [10,"<%= REVIEW_A %>"], [11,"<%= REVIEW_B %>"], [12,"<%=REVIEW_C%>"], [13,"<%= REVIEW_D %>"],[14,"<%= AVERAGE_POINTS%>"], [15,"<%= REMARK%>"],[16,"<%= CHANGED_BY%>"], [17,"<%= CHANGED_DATE %>"],[18,"<%= CHANGED_TIME %>"],[19,"<%=STATUS%>"],[20,"<%=EMPLOYEE_HIDDEN_ID%>"] ];
	 statusTd = 19;
	</script></div>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<form name="trainingEffectivness" method="post" action=""><label><span>*</span>
Evaluation Date</label> <input type="text" name="<%=EVALUATION_DATE %>" value=""
	class="date" readonly="readonly" validate="Evaluation date ,date,yes"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',document.trainingEffectivness.<%=EVALUATION_DATE%>,event)" />
<label><span>*</span> Held On Date</label> <input type="text"
	name="<%=HELD_ON_DATE %>" value="" class="date" readonly="readonly"
	validate="Held On date date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.trainingEffectivness.<%=HELD_ON_DATE%>,event)" />
<div class="clear"></div>
</div>
<h4>Employee Details</h4>
<div class="clear"></div>
<div class="Block"><label><span>*</span> Employee Name</label> <label><%=employeeName %></label>
<input type="hidden" name="<%=EMPLOYEE_HIDDEN_ID %>"
	value="<%=employeeId  %>" /> <label><span>*</span> Course Code</label>
<select name="<%=COURSE_ID %>" validate="Course Name,string,yes">
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
</select> <label><span>*</span>Institute Name</label> <select
	name="<%=INSTITUTE_ID %>" validate="Institute Name,string,yes">
	<option value="0">Select</option>
	<%for(HrMasInstitute hrMasInstitute :instituteList){ %>
	<option value="<%=hrMasInstitute.getId() %>"><%=hrMasInstitute.getInstituteName()%></option>
	<%} %>
</select>
<div class="clear"></div>
</div>
<h4>Effectiveness Analysis</h4>
<div class="clear"></div>
<div class="Block"><label> Course Explain</label>
<div class="clear"></div>

<label class="auto"> A) Included topics were not necessary for
the attendee's job</label>
<div class="paddRight250"><select name="<%=COURSE_EXPLAIN_A %>"
	validate="Course Explain A,string,no">
	<option value="0">Select</option>
	<option value="yes">yes</option>
	<option value="no">No</option>
</select></div>

<div class="clear"></div>

<label class="auto"> B) The Trainer failed to explain well
through the course content was quite effect</label>
</td>

<div class="paddRight250"><select name="<%=COURSE_EXPLAIN_B %>"
	validate="Course Explain B,string,no">
	<option value="0">Select</option>
	<option value="yes">yes</option>
	<option value="no">No</option>
</select></div>
<div class="clear"></div>
<label class="auto">C) Course Material</label>
<div class="paddRight250"><select name="<%=COURSE_MATERIAL %>"
	validate="Course Explain Material,string,no">
	<option value="0">Select</option>
	<option value="yes">Succeeded in raising effectivnes</option>
	<option value="no">Failed to raising effectivnes</option>
</select></div>
<div class="clear"></div>
</div>
<div class="clear"></div>

<h4>Review The Course</h4>
<div class="clear"></div>
<div class="Block"><label class="auto"> A) Expected /
Desired skill enhancements have been achieved</label>
<div class="paddRight250"><select name="<%=REVIEW_A %>"
	validate="Review A,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=8;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select></div>
<div class="clear"></div>
<label class="auto"> B) Improvement in the effectivness of the
individual has been achieved </label>
<div class="paddRight250"><select name="<%=REVIEW_B %>"
	validate="Review B,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=8;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select></div>
<div class="clear"></div>
<label class="auto"> C) Productivity (where applicable) has
improved </label>
<div class="paddRight250"><select name="<%=REVIEW_C %>"
	validate="Review C,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=8;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select></div>
<div class="clear"></div>
<label class="auto">D) Requirement for the training for the
organization benefit </label>
<div class="paddRight250"><select name="<%=REVIEW_D %>"
	validate="Review D,string,no">
	<option value="0">Select</option>
	<%	for(int i=0;i<=8;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<label><span>*</span> Average Points </label>
<select name="<%=AVERAGE_POINTS %>" validate="Average Points,string,yes">
	<option value="0">Select</option>
	<%	for(int i=0;i<=8;i++){%>
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
	onClick="submitForm('trainingEffectivness','training?method=saveTrainingEffectivness','checkheldOnDate');"
	accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update"
	style="display: none;" class="button"
	onClick="submitForm('trainingEffectivness','training?method=editTrainingEffectivness')"
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
<input type="hidden" name="<%= TRAINING_EFFECTIVNESS_ID%>" value="" />
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
data_header[1][3] = "<%= EVALUATION_DATE %>";

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
data_header[5][3] = "<%= INSTITUTE_ID%>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "";
data_header[6][3] = "<%= COURSE_EXPLAIN_A%>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "";
data_header[7][3] = "<%= COURSE_EXPLAIN_B%>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "";
data_header[8][3] = "<%= COURSE_MATERIAL%>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "";
data_header[9][3] = "<%= REVIEW_A%>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "";
data_header[10][3] = "<%= REVIEW_B%>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "";
data_header[11][3] = "<%= REVIEW_C%>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "";
data_header[12][3] = "<%= REVIEW_D%>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%=AVERAGE_POINTS %>"

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%=REMARK %>"

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = "";
data_header[15][3] = "<%=CHANGED_BY %>";

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = "";
data_header[16][3] = "<%=CHANGED_DATE %>";

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = "";
data_header[17][3] = "<%=CHANGED_TIME %>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = "";
data_header[18][3] = "<%=STATUS %>";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = "";
data_header[19][3] = "<%=EMPLOYEE_HIDDEN_ID %>";

data_arr = new Array();

<%
Iterator itr=trainingEffectiveList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrTrainingEffective  hrTrainingEffective= (HrTrainingEffective)itr.next(); 
			if(hrTrainingEffective.getEmployee().getId().equals(employeeId)){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrTrainingEffective.getId()%>
<%
	for(MasEmployee masEmployee :employeeList){
			if(hrTrainingEffective.getEmployee().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode()%>"
<%
		}
	}

%>
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(hrTrainingEffective.getEvaluationDate())%>"

data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(hrTrainingEffective.getHeldOnDate())%>"
<%
	for(HrMasCourse hrMasCourse :courseList){
			if(hrTrainingEffective.getCourse().getId().equals(hrMasCourse.getId())){
%>
data_arr[<%= counter%>][4] = "<%=hrMasCourse.getCourseName()%>"
<%
		}
	}

%>		

<%
	for(HrMasInstructor hrMasInstructor:instructorList){
			if(hrTrainingEffective.getInstructor().getId().equals(hrMasInstructor.getId())){
%>
data_arr[<%= counter%>][5] = "<%=hrMasInstructor.getInstructorName()%>"
<%
		}
	}

%>		


<%
	for(HrMasInstitute hrMasInstitute :instituteList){
			if(hrTrainingEffective.getInstitute().getId().equals(hrMasInstitute.getId())){
%>
data_arr[<%= counter%>][6] = "<%=hrMasInstitute.getInstituteName()%>"
<%
		}
	}

%>		

 data_arr[<%= counter%>][7] = "<%=hrTrainingEffective.getCourseExplaina()%>"
            
            
 data_arr[<%= counter%>][8] = "<%=hrTrainingEffective.getCourseExplainb()%>"
            
 data_arr[<%= counter%>][9] = "<%=hrTrainingEffective.getCourseMaterial()%>"
data_arr[<%= counter%>][10] = "<%=hrTrainingEffective.getReviewA()%>"
data_arr[<%= counter%>][11] = "<%= hrTrainingEffective.getReviewB()%>"
data_arr[<%= counter%>][12] = "<%=hrTrainingEffective.getReviewC()%>"
data_arr[<%= counter%>][13] = "<%=hrTrainingEffective.getReviewD()%>"      
data_arr[<%= counter%>][14] = "<%= hrTrainingEffective.getAveragePoints()%>"       
data_arr[<%= counter%>][15] = "<%=hrTrainingEffective.getRemarks() %>"
data_arr[<%= counter%>][16] = "<%= hrTrainingEffective.getLastChgBy() %>"
data_arr[<%= counter%>][17] = "<%= HMSUtil.convertDateToStringWithoutTime(hrTrainingEffective.getLastChgDate()) %>"
data_arr[<%= counter%>][18] = "<%= hrTrainingEffective.getLastChgTime() %>"
<% if(hrTrainingEffective.getStatus().equals("y")){ %>
data_arr[<%= counter%>][19] = "Active"
<%}else{%>
data_arr[<%= counter%>][19] = "InActive"
<%}%>
data_arr[<%= counter%>][20] = "<%= hrTrainingEffective.getEmployee().getId() %>"
<%
		     counter++;
}}
%>
 
formName = "trainingEffectivness"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
