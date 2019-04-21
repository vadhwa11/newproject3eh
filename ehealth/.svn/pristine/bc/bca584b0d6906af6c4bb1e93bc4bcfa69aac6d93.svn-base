<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.masters.business.MasBulkMain"%>

<%@page import="java.util.Calendar"%><html xmlns="http://www.w3.org/1999/xhtml">
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

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
<%
List<MasBulkMain>mainList=new ArrayList<MasBulkMain>();
Map<String, Object> map = new HashMap<String, Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
if(map.get("mainList")!=null){
	mainList=(ArrayList)map.get("mainList");
}


%>
	<form  action="printBulkReport" name="dpsmsReport" method="post">
	<div class="Block">
	<h4>BULK SMS Report</h4>
	<div class="clear"></div>
	<label >Group Name :</label>
<select name="mainGroupId" id="mainGroupId">
	<option value="">Select</option>
	   <% for(MasBulkMain main: mainList){%>
	   <option value="<%=main.getId()%>"><%=main.getGroupName() %></option>
	   <%} %>
</select>
		<label >From Date :</label>
		<input type="text"  name="fromDate" value="" class="date"  readonly="readonly" validate="Due date ,date,yes"  MAXLENGTH="30" />
        <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="setdate('',document.dpsmsReport.fromDate,event)"/>

	<label >To Date :</label>
	
	<input type="text"  name="toDate" value="" class="date"  readonly="readonly" validate="Due date ,date,yes"  MAXLENGTH="30" />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.dpsmsReport.toDate,event)"/>
<div class="clear"></div>
	<input type="button"   name="ok" class="button" value="Print" onclick="submitForm('dpsmsReport','sms?method=printBulkReport');"  />
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>