<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

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





<div class="Block">
<form name="monthlyAttendenceStatus" method="post" action="">

<%
	Map<String,Object> map =new HashMap<String,Object>();
	if(request.getAttribute("map")!=null){
		map=(Map) request.getAttribute("map");
	}
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
	if(map.get("masDepartmentList")!=null){
		masDepartmentList=(List<MasDepartment>)map.get("masDepartmentList");
	}
%><div class="titleBg">
<h2>Monthly Attendance Sheet</h2></div>
        
         <div class="clear"></div>
    	 <label><span>*</span>Department</label>
    	<select name="<%=DEPARTMENT_ID %>" id="empcode">
    	<option value="">All</option>
    	<%
			for(MasDepartment masDepartment :masDepartmentList)
			{				
		%>
		<option value="<%= masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
		
		<%} %>
    	</select>
    	<label><span>*</span>Month </label>
<input id="fromDateId" type="text"  name="<%=FROM_DATE %>" value="" class="date"  readonly="readonly" validate="From date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('fromDateId'),event)"/>
    	<div class="clear"></div>
    	<input type="button" class="button" value="View Report" name="print" onclick="submitForm('monthlyAttendenceStatus','/hms/hrms/attendance?method=printMonthlyAttendanceStatusReport');"/>
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>