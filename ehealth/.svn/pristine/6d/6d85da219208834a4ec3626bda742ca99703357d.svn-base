<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.HrPatientSickCertificate"%>
<%@page import="jkt.hms.masters.business.HrMedicalRecord"%>


<script type="text/javascript" src="../jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">


<%

Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String getDate=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(getDate.length()<2){
getDate="0"+getDate;
}
%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>
<%
Map map = new HashMap();
if (request.getAttribute("map") != null) {
map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
String userName="";
String message="";

List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
List <HrMedicalRecord> medicalRecordList=new ArrayList();
if(map.get("departmentList")!=null)
{
	departmentList = (List<MasDepartment>)map.get("departmentList");
}
if(map.get("medicalRecordList")!=null)
{
	medicalRecordList = (List<HrMedicalRecord>)map.get("medicalRecordList");
	
}
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}

if(map.get("employeeList")!=null)
{
	employeeList = (List<MasEmployee>)map.get("employeeList");
}

if(map.get("bloodGroupList")!=null)
{
	bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
}

if(map.get("message") != null){
	   message = (String)map.get("message");
	   %>
	   
	    <h4><span><%=message %></span></h4>
	 <%} %>
<div class="titleBg">
<h2>12    Medical Examination Report (Pre- Employment/ Periodical)</h2>  `
</div>
<div class="clear"></div>
<form action="" method="post" name="medicalExamFormMain" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">

<label>Examination type</label>
<select name="<%=TYPE_ID %>" id="typeId" validate="Type,string,no" onchange="">
	<option value="0">select</option>
	<option value="1">Pre-employment</option>
	<option value="2">Post-employment</option>
	</select> 
	
	


<label>Emp No</label>
<input type="text" id="empCode" name="empCode"  />

<label>Employee Name</label>
<input type="text" id="name" name="empName"  />
<div class="clear"></div>
<div class="clear"></div>

<label>Department</label>
<select name="<%=DEPARTMENT_ID%>" id="departmentId" validate="Department,string,no">
	<option value="0">Select</option>
	<%for(MasDepartment department : departmentList){ %>
	<option value="<%=department.getId()%>"><%=department.getDepartmentName()%></option>
	<%}%>
	</select> 
	
<!--
	
<label>Date Of Birth</label>
<input type="text" class="date" tabindex="1" validate="Date Of Birth,string,yes"
	id="dateOfBirth" name="dateOfBirth" readonly="readonly" value="<%=currentDate %>"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate %>',document.medicalExamForm.dateOfBirth,'event')" />




<label>Date Of joining</label>
<input type="text" class="date" tabindex="1" validate="Date Of Birth,string,yes"
	id="dateOfJoin" name="dateOfJoin" readonly="readonly" value="<%=currentDate %>"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate %>',document.medicalExamForm.dateOfJoin,'event')" />
	
	-->
<label>Blood Group  </label>
<select name="<%=BlOOD_ID%>" id="bloodId" validate="Blood Group,string,no">
	<option value="0">Select</option>
	<%for(MasBloodGroup blood : bloodGroupList){ %>
	<option value="<%=blood.getId()%>"><%=blood.getBloodGroupName()%></option>
	<%}%>
	</select> 
<label>Height  </label>
<input class="small" type="text" name="height" id="height" />

<div class="clear"></div>
<div class="clear"></div>


<label>Identification Mark  </label>
<input type="text" name="identification" id="identification" />
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Search" onClick="submitForm('medicalExamFormMain','training?method=searchMedicalExaminationReport');"/>
<input type="button" class="button" value="Cancel" />
</form>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div class="clear"></div>
<div id="searchtable" tabindex="2"></div>
<div class="clear"></div>
<form name="medicalExamForm" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<script type="text/javascript">
formFields =
	[[0, "<%= COMMON_ID%>", "id"], [1,"empCode"], [2,"empName"], [3,"<%=TYPE_ID%>"],[4,"<%=DEPARTMENT_ID%>"], [5,"<%=BlOOD_ID%>"] ];

statusTd =5;
</script></div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Employee Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "empCode"

data_header[1] = new Array;
data_header[1][0] = "Employee Name"
data_header[1][1] = "data";
data_header[1][2] = "10";
data_header[1][3] = "empName"

data_header[2] = new Array;
data_header[2][0] = "Exam Type"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=TYPE_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Department"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%=DEPARTMENT_ID%>"

data_header[4] = new Array;
data_header[4][0] = "Blood Group"
data_header[4][1] = "data";
data_header[4][2] = "40%";
data_header[4][3] = "<%=BlOOD_ID%>"

data_arr = new Array();
<%
	if(medicalRecordList.size() >0)
	{
		Iterator itr=  medicalRecordList.iterator();
		int  counter=0;
		while(itr.hasNext())
		{
  			HrMedicalRecord  medicalRecord = (HrMedicalRecord)itr.next();
  		
%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= medicalRecord.getId()%>
			data_arr[<%= counter%>][1] = "<%= medicalRecord.getEmpCode()%>"
			data_arr[<%= counter%>][2] = "<%= medicalRecord.getEmpName()%>"
				<%if(medicalRecord.getExamType().equals("1")){%>
			data_arr[<%= counter%>][3] = "Pre-Employment"
				<%}else{%>
				data_arr[<%= counter%>][3] = "Post-Employment"
				<%}%>
			data_arr[<%= counter%>][4] = "<%= medicalRecord.getDepartment().getDepartmentName()%>"
			data_arr[<%= counter%>][5] = "<%= medicalRecord.getBloodGroup().getBloodGroupName()%>"



	<%
counter++;}}
%>
formName = "medicalExamForm"
	nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
</script>

