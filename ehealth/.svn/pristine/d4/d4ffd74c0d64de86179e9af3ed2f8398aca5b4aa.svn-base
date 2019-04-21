<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hrms.masters.business.MasLocation"%>
<%@page import="jkt.hms.util.EmployeeComparator"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!--  <link  rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />-->

<%Map<String,Object> map =new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map) request.getAttribute("map");
}
Map<String,Object> mapEmployee = new HashMap<String,Object>();


List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
if(map.get("employeeList")!=null){
	employeeList=(List<MasEmployee>)map.get("employeeList");
}

List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
if(map.get("departmentList")!=null)
{
	departmentList = (List)map.get("departmentList");
}

List<MasRank> rankList = new ArrayList<MasRank>();
if(map.get("rankList")!=null)
{
	rankList = (List)map.get("rankList");
}

List<MasLocation> locationList = new ArrayList<MasLocation>();
if(map.get("locationList")!=null)
{
	locationList = (List) map.get("locationList");
}



%>


<script>
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


<div class="titleBg">
<h2>Employee List</h2>
</div>
<form name="EmployeeList" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><label>Department
Name</label> <select name="Dept" id="Dept" onchange="populate">
	<option value="0">Select</option>
	<% for(MasDepartment masDepartment:departmentList){%>

	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%>
	</option>
	<%} %>
</select> <label>Employee Name </label> <select name="EmpId" id="EmpTypeId">
	<option value="0">Select</option>
	<%
    	Collections.sort(employeeList, new EmployeeComparator());
			for(MasEmployee masEmployee:employeeList)
			{
				
		%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" " + masEmployee.getMiddleName()+ " " +masEmployee.getLastName()+"--"+masEmployee.getEmployeeCode()%>
	</option>
	<%} %>
</select> <label>Designation</label> <select name="DesignationId"
	id="DesignationId">
	<option value="0">Select</option>
	<% for(MasRank masRank:rankList){%>

	<option value="<%=masRank.getId() %>"><%=masRank.getRankCode()+"--"+masRank.getRankName()%>
	</option>
	<%} %>
</select> <label>Location</label> <select name="LocationId" id="LocationId">
	<option value="0">Select</option>
	<% for(MasLocation masLocation:locationList){%>

	<option value="<%=masLocation.getId() %>"><%=masLocation.getLocationCode()+"-"+masLocation.getLocationName()%>
	</option>
	<%} %>
</select>
<div class="clear"></div>
<input type="button" value="print" class="buttonBig" name="print"
	onclick="submitForm('EmployeeList','/hms/hrms/report?method=printEmployeeList');" />
</form>
