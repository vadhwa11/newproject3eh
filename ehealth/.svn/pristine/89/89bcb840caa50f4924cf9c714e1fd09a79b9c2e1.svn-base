<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="jkt.hrms.masters.business.MstrTask"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> masProjectList = new ArrayList<MstrProject>();
				List<MstrTask> masTaskList = new ArrayList<MstrTask>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("masProjectList")!= null){
					masProjectList = (List)map.get("masProjectList");
				}
				if(map.get("masTaskList")!= null){
					masTaskList = (List)map.get("masTaskList");
				}
				
	%> <script type="text/javascript">



	function(){
		var fDate = document.employeeAttendanceCardReport.<%= FROM_DATE%>.value;
		var tDate = document.employeeAttendanceCardReport.<%= TO_DATE %>.value;
	
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(fromDate = "")
		{
			alert(" From Date should not be blank.");
		}
		
		if(toDate = "")
		{
			alert(" To Date should not be blank.");
		}
		
		if(toDate < fromDate)
		{
			alert(" From Date is greater than  To Date.");
			document.employeeAttendanceCardReport.<%= FROM_DATE%>.value = "";
			document.employeeAttendanceCardReport.<%= TO_DATE %>.value = "";
			return false;
		}
		return true;
	}
	</script> <script>
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

<form name="timeSheetProjectWise" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Time Sheet Project Wise Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> Project</label> <select
	name="prj_Id" id="prj_Id" validate="Project ,string,yes">
	<option value="0">Select</option>
	<%
	for(MstrProject mstrProject :masProjectList){
%>
	<option value="<%=mstrProject.getId() %>"><%=mstrProject.getPrjName()%>-<%=mstrProject.getPrjCode()%></option>

	<%
	}
%>
</select>



<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<label><span>*</span>From Date</label> <input type="text" id="dobId"
	name="<%=FROM_DATE %>" value="" class="date" readonly="readonly"
	validate="From date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.timeSheetProjectWise.<%=FROM_DATE%>,event)" />
<div class="clear"></div>
<label><span>*</span>To Date</label> <input type="text"
	name="<%=TO_DATE %>" value="" class="date" readonly="readonly"
	validate="To date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.timeSheetProjectWise.<%=TO_DATE%>,event)" />

<div class="clear"></div>


<div class="clear"></div>
<div class="division"></div>

<input name="Ok" type="button" class="button" value="View Report"
	onClick="submitForm('timeSheetProjectWise','report?method=printTimeSheetProjectWiseReport');" />
<input name="xlOk" type="button" class="button" value="Export To Excel"
	onClick="submitForm('timeSheetProjectWise','report?method=exportToExcelTimeSheetProjectWiseReport');" />

<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" /></div>
</form>