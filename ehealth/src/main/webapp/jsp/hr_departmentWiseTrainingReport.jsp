<%@page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				
	%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
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

<form name="departementWiseTrainingReport" method="post" action="">
<div class="titleBg">
<h2>Department Wise Training Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label>Department Code</label> <select
	name="<%=DEPARTMENT_ID %>" validate="Training Name,string,no">
	<option value="0">Select</option>
	<%
	for(MasDepartment masDepartment :departmentList){
%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>

	<%
	}
%>
</select>

<div class="clear"></div>

<div class="division"></div>

<input name="Print" type="button" class="button" value="Print"
	onclick="submitForm('departementWiseTrainingReport','training?method=printDepartemntWiseTrainingReport');" />

<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

