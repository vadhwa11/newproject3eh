
<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=showDailyDoctorWiseReportJsp";
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
var SDate = document.dailyDoctorWise.<%= FROM_DATE%>.value;
var EDate = document.dailyDoctorWise.<%= TO_DATE %>.value;


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

	int deptId = 0,hospitalId=0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
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
	//added by govind 30-11-2016
	List<EmpScMapping>list= new ArrayList<EmpScMapping>();
	if(map.get("doctorList") != null){
		list = (List)map.get("doctorList");
	}
	System.out.println("doctorList==jsp "+list.size());
	//added by govind 30-11-2016 end
%>
<form name="dailyDoctorWise" method="post" action="">
<div class="titleBg">
<h2>Daily Doctor Wise</h2>
</div>
<div class="clear"></div>

<div class="Block"><label><span>*</span> From Date </label> <input
	type="text" name="<%=FROM_DATE%>" value="<%=currentDate %>"
	class="date" MAXLENGTH="30" validate="From Date date,date,yes"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="date"
	onclick="javascript:setdate('<%=currentDate%>',document.dailyDoctorWise.<%=FROM_DATE%>,true)" />

<label><span>*</span> To Date </label> <input type="text"
	name="<%=TO_DATE%>" value="<%=currentDate %>" class="date"
	MAXLENGTH="30" validate="To Date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="date"
	onclick="javascript:setdate('<%=currentDate%>',document.dailyDoctorWise.<%=TO_DATE%>,true)" />

<label><span>*</span> Department</label> 
<!-- <select id="deptId"	name="<%--<%=DEPARTMENT_ID%>--%>"	onchange="populateDoctor(this.value,'dailyDoctorWise')" 	validate="Department,string,yes"> changed by govind 1-12-2016-->
<select id="deptId"	name="<%=DEPARTMENT_ID%>"	onchange="fnGetDoctorDepartment(this.value);" 	validate="Department,string,yes">
	<option value="0">Select</option>
	<%
				for (MasDepartment masDepartment :searchMasDepartmentList ) {
				
				%>
	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%>
	</option>
	<%	
					}
				
					
				%>
</select> 
<script type="text/javascript">
	
	document.getElementById('deptId').value = '<%=deptId%>';
		
</script>
<div class="clear"></div> 
<label> Doctor Name</label> 
<select	name="<%=CONSULTING_DOCTOR %>" id="refereddoctor" validate="Consulting Doctor,alphanumeric,no"	tabindex="1">
	<option value="0">Select</option>
	<%	if(list.size() !=0){
		for (EmpScMapping empsc :list) {
			MasEmployee	masEmployee=empsc.getEmployee();
			String name=masEmployee.getFirstName();
			if(masEmployee.getMiddleName()!=null && !masEmployee.getMiddleName().equals(""))
				name=name+" "+masEmployee.getMiddleName();
			if(masEmployee.getLastName()!=null && !masEmployee.getLastName().equals(""))
				name=name+" "+masEmployee.getLastName();	
				
%>				
<option value=<%=masEmployee.getId()%>><%=name%></option>
<%} }%>
<%-- //added by govind 30-11-2016 	<%
for(MasEmployee masEmployee : searchMasEmployeeList){
if(masEmployee.getEmpCategory()!= null && masEmployee.getDepartment()!=null){
	if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor))
	{
	if(deptId == masEmployee.getDepartment().getId())
	{
		%>--%>
	<!-- <option value="<%--<%=masEmployee.getId() %>--%>"><%--<%=masEmployee.getEmployeeName() %>--%></option> -->
<%--	<%}
	}
	}
} %> //added by govind 30-11-2016 end--%>
</select> 
<script type="text/javascript">
	<%
		int i = 0;
			for(MasDepartment masDepartment : searchMasDepartmentList){
				for (MasEmployee masEmployee : searchMasEmployeeList) 
				{
					if(masEmployee.getEmpScMappings()!=null){
					Set<EmpScMapping> set = (Set<EmpScMapping>) masEmployee.getEmpScMappings();
					if(set.size()>0){
						for (EmpScMapping esm : set) {
						if(esm.getDepartment()!=null && masDepartment.getId().equals(esm.getDepartment().getId())){
							if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
								if(masEmployee.getEmployeeName()!=null){
						%>
							doctorArr[<%=i%>] = new Array();
							doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
							doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;									
							doctorArr[<%=i%>][2] = "<%=masEmployee.getEmployeeName()%>";

						<%
						i++;}
							}
						}
						}
						}
				}
				}
			}
		%>

										
	</script>

<label>Summary</label> <input type="radio" name="<%=SELECTED_RADIO%>" 	value=1 class="radioCheck" checked="checked">
<label	class="auto">Detail</label><input type="radio"	name="<%=SELECTED_RADIO %>" class="radioCheck" value=2 />
	
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" id="referhospital" value="<%=hospitalId%>"/>
<input type="button" name="add" id="addbutton" value="Ok" class="button"
	onClick="submitForm('dailyDoctorWise','opd?method=generateDailyDoctorWiseReport','check()');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button"
	onClick="clearButton('dailyDoctorWise');" accesskey="a" tabindex=1 /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<div class="clear"></div>
<div class="division"></div>






