<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String,Object> utilMap = new HashMap<String,Object>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
				
				String userName = "";
				if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
				}
				if(map.get("message") != null){
					 String  message = (String)map.get("message");
					   %>
					   <h4><span><%=message %></span></h4>
					 <%} %> 


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

<form name="postPayrollProcess" method="post" action="">
<div class="titleBg">
<h2>Post Payroll Process</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> Month</label> <select
	name="<%=MONTH %>" validate="Month,string,yes"">
	<option value="0">Select</option>
	<option value="01">January</option>
	<option value="02">February</option>
	<option value="03">March</option>
	<option value="04">April</option>
	<option value="05">May</option>
	<option value="06">June</option>
	<option value="07">July</option>
	<option value="08">August</option>
	<option value="09">September</option>
	<option value="10">October</option>
	<option value="11">November</option>
	<option value="12">December</option>
</select> <label><span>*</span> Year</label> <select name="<%=YEAR %>"
	validate="Year,string,yes"">
	<option value="0">Select</option>
	<option value="2001">2001</option>
	<option value="2002">2002</option>
	<option value="2003">2003</option>
	<option value="2004">2004</option>
	<option value="2005">2005</option>
	<option value="2006">2006</option>
	<option value="2007">2007</option>
	<option value="2008">2008</option>
	<option value="2009">2009</option>
	<option value="2010">2010</option>
	<option value="2011">2011</option>
	<option value="2012">2012</option>
</select> <label> Department Name</label> <select id="employeeId"
	name="<%=DEPARTMENT_ID %>" validate="Department,string,no">
	<option value="0">Select</option>
	<%
		for(MasDepartment masDepartment :departmentList){
%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%} %>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="save" type="button" class="button" value="Process"	onClick="submitForm('postPayrollProcess','payroll?method=processPostPayrollDetail');" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

