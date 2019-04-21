<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%@page import="jkt.hms.masters.business.MasDepartment"%>

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


List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
if(map.get("departmentList")!=null)
{
	departmentList = (List)map.get("departmentList");
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
<h2>Employee salary Comparison</h2>
</div>
<form name="EmpSalComp" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><label><span>*</span>Department
Name</label> <select name="department" id="department"
	validate='Department,string,yes'>
	<option value="0">Select</option>
	<% for(MasDepartment masDepartment:departmentList){%>

	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%>
	</option>
	<%} %>
</select>

<div class="clear"></div>
<label><span>*</span> Period 1</label> <input name="period1" type="text"
	readonly validate='Period 1,date,yes' value="" class="date" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	id="calFromDate"
	onclick="javascript:setdate('',document.EmpSalComp.period1,event)" />
<div class="clear"></div>
<div id="divToDate"><label><span>*</span>Period 2</label> <input
	type="text" name="period2" readonly validate='Period 2,date,yes'
	value="" class="date" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" id="calToDate"
	onclick="javascript:setdate('',document.EmpSalComp.period2,event)" />
</div>


<div class="clear"></div>
<input type="button" value="print" class="buttonBig" name="print"
	onclick="submitForm('EmpSalComp','/hms/hrms/report?method=printEmpSalComp');" />
</form>
