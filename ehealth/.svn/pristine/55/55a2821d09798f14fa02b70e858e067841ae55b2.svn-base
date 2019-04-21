
<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=showDailyOPDInvestigationsReportJsp";
  obj.submit();
  }
</script>

<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
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
	</script>

<script type="text/javascript">
function check(){
var SDate = document.dailyOPDInvestigations.<%= FROM_DATE%>.value;
var EDate = document.dailyOPDInvestigations.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasDepartment> searchMasDepartmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> searchMasEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("searchMasDepartmentList")!=null)
		searchMasDepartmentList = (List) map.get("searchMasDepartmentList");
	if(map.get("searchMasEmployeeList")!=null)
		searchMasEmployeeList = (List) map.get("searchMasEmployeeList");
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");

%>

<form name="dailyOPDInvestigations" method="post" action="">
<div class="titleBg">
<h2>Daily OPD Investigations</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> From Date </label> <input
	type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>"
	class="date" MAXLENGTH="30" validate="Pick a from date,date,yes"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.dailyOPDInvestigations.<%=FROM_DATE%>,true)" />

<label><span>*</span> To Date </label> <input type="text"
	name="<%=TO_DATE%>" value="<%=currentDate %>" class="date"
	MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.dailyOPDInvestigations.<%=TO_DATE%>,true)" />


<label><span>*</span> Department</label> <select id="deptId"
	name="<%=DEPARTMENT_ID%>"
	onchange="populateDoctorNamePopulate(this.value,'dailyOPDInvestigations')"
	validate="Department,string,yes">
	<option value="0">Select</option>
	<%
				for (MasDepartment masDepartment :searchMasDepartmentList ) {

				%>
	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%>
	</option>
	<%
					}


				%>
</select> <script type="text/javascript">

		document.getElementById('deptId').value = '<%=deptId%>';


		</script><div class="clear"></div> <label><span>*</span> Doctor Name</label> <select
	name="<%=EMPLOYEE_ID %>"  id="employeeId" validate="Doctor Name,string,yes">
	<option value="0">Select</option>
	<%
			for(MasEmployee emp : searchMasEmployeeList){

				if(emp.getDepartment()!=null){
					if(emp.getDepartment()!=null && emp.getDepartment().getId() == deptId){

		%>
	
	
<option value="<%=emp.getId() %>"><%=emp.getEmployeeName() %></option>
	<%}}
				}%>
</select>


 <script type="text/javascript">
			<%
				int i = 0;
					for(MasDepartment masDepartment : searchMasDepartmentList){
						for (MasEmployee masEmployee : searchMasEmployeeList)
						{
							Set<EmpScMapping> set = (Set<EmpScMapping>) masEmployee.getEmpScMappings();
							if(set.size()>0){
								for (EmpScMapping esm : set) {
								if(masDepartment.getId().equals(esm.getDepartment().getId())){
									if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
								%>
									doctorArr[<%=i%>] = new Array();
									doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
									doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
									doctorArr[<%=i%>][2] = "<%=masEmployee.getEmployeeName()%>";

								<%
								i++;
								 }
								}
								}
							}
						}
					}
				%>


			</script>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button"
	onClick="submitForm('dailyOPDInvestigations','opd?method=generateDailyOPDInvestigationsReport','check()');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button"
	onClick="clearButton('dailyOPDInvestigations');" accesskey="a"
	tabindex=1 /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<div class="clear"></div>
<div class="division"></div>





