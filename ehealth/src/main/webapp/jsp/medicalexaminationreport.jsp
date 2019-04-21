
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.ArrayList"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="jkt.hms.masters.business.HrPatientSickCertificate"%><script type="text/javascript" src="../jsp/js/calendar.js"></script>
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
String entryNo ="MS/VBCH/CERT/";
String max="";
String userName="";
String message="";

List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();

if(map.get("departmentList")!=null)
{
	departmentList = (List<MasDepartment>)map.get("departmentList");
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

int counter=1;
if(map.get("counter")!=null)
{
	counter = (Integer)map.get("counter");
}
if(counter>0)
{
	entryNo = entryNo+counter;
}
if(map.get("message") != null){
	   message = (String)map.get("message");
	   %>
	   
	    <h4><span><%=message %></span></h4>
	 <%} %>








<div class="titleBg">
<h2>12    Medical Examination Report (Pre- Employment/ Periodical)</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>
<form action="" method="post" name="MedicalExamForm" id="MedicalExamForm">


<div class="Block">
<label>Examination type</label>
<select name="typeId" id="typeId" validate="Type,string,yes">
	<option value="0">select</option>
	<option value="1">Pre-employment</option>
	<option value="2">Post-employment</option>
	</select> 
<label>Employee Name</label>
<input type="text" id="empName" name="empName" />
<label>Emp No</label>
<input type="text" id="empCode" name="empCode"/>
<div class="clear"></div>
<div class="clear"></div>
<label>Department</label>
<select name="departmentId" id="departmentId" validate="Department,string,yes">
	<option value="0">Select</option>
	<%for(MasDepartment depart : departmentList){ %>
	<option value="<%=depart.getId()%>"><%=depart.getDepartmentName()%></option>
	<%}%>
	</select> 
<label>Date Of Birth</label>
<input type="text" class="date" tabindex="1" validate="Date Of Birth,string,yes"
	id="dateOfBirth" name="dateOfBirth" readonly="readonly" value="<%=currentDate %>"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate %>',document.MedicalExamForm.dateOfBirth,'event')" />




<label>Date Of joining</label>
<input type="text" class="date" tabindex="1" validate="Date Of Birth,string,yes"
	id="dateOfJoin" name="dateOfJoin" readonly="readonly" value="<%=currentDate %>"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate %>',document.MedicalExamForm.dateOfJoin,'event')" />
	
<div class="clear"></div>
<div class="clear"></div>
<label>Blood Group  </label>
<select name="bloodId" id="bloodId" validate="Blood Group,string,yes">
	<option value="0">Select</option>
	<%for(MasBloodGroup blood : bloodGroupList){ %>
	<option value="<%=blood.getId()%>"><%=blood.getBloodGroupName()%></option>
	<%}%>
	</select> 
<label>Height  </label>
<input type="text" class="date" />

<label>Identification Mark  </label>
<input type="text" class="date" />
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="Big" value="Search Employee" />
<input type="button" class="Big" value="Search Exam data" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


