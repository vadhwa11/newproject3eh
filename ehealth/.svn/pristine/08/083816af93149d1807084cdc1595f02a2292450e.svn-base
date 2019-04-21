
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<script type="text/javascript">
  
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
<%

Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
if(map.get("departmentList") != null){
	departmentList=(List)map.get("departmentList");
}

%>
function check(){
var SDate = document.otPost.<%= FROM_DATE%>.value;
var EDate = document.otPost.<%= TO_DATE %>.value;


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
	
	
	
%>
<form name="otPost" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>OT List</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label><span>*</span>From Date :</label> <input type="text"
	id="fromDate" name="<%=FROM_DATE %>" class="date" value=""
	MAXLENGTH="30" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.otPost.<%=FROM_DATE%>,event);" />

<label><span>*</span>To Date :</label> <input type="text"
	name="<%=TO_DATE%>" value="" class="date" MAXLENGTH="30"
	validate="Pick a to date,date,yes" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.otPost.<%=TO_DATE%>,event);" />


<label>Department</label> 
<select name="deptId" id="departmentId" onchange="changeValue(this.value)"
	validate="Department,string,no">
	<option value="0">Select</option>
	<%
       int deptId=0;
      
	   //Iterator itr= departmentList.iterator();
       for(MasDepartment masDepartment : departmentList)
       {
    	 %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<% 	}
     
	%>
</select>


<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button"
	onClick="submitForm('otPost','ot?method=generateOtListDetailsReport','check()');"
	accesskey="a" tabindex=1 /> <input type="reset" name="clear"
	id="clearbutton" value="Clear" class="button" accesskey="a" tabindex=1 />
</form>






