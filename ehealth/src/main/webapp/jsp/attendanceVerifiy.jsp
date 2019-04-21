<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>

<%		
		String message = "";
        String locName = "";
		List<HrAttendanceLoader> hrAttendanceLoaderList = new ArrayList<HrAttendanceLoader>();
		List<HrMasLocation> hrMasLocationList = new ArrayList<HrMasLocation>();
		Map map = new HashMap();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}

		if(map.get("hrAttendanceLoaderList") != null){
			 hrAttendanceLoaderList = (ArrayList)map.get("hrAttendanceLoaderList");
		}
		if(map.get("hrMasLocationList") != null){
			hrMasLocationList = (ArrayList)map.get("hrMasLocationList");
		}
		if(map.get("locName") != null){
			locName = (String)map.get("locName");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");	 
		String currentTime = (String)utilMap.get("currentTime");
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
%>

<%@page import="jkt.hrms.masters.business.HrAttendanceLoader"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.HrMasLocation"%>
<script>
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


<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>


<!--Main Div starts here-->
<script>


</script>

<form name="attendanceVerify" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Verify Attendance</h2>
</div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>

<div class="Block"><label class="auto"><span>*</span> Date</label>
<input id="fromDateId" type="text" name="date" value="" class="date"
	readonly="readonly" validate="From date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.getElementById('fromDateId'),event)" /> <label
	class="auto"><span>*</span> Location</label> <select
	name="<%=ATT_LOCATION_ID%>" id="location"
	validate="Location,string,yes" class="auto" onchange="displayName()">
	<option value="0">Select</option>
	<%
	for(HrMasLocation  hrMasLocation:hrMasLocationList){
%>
	<option value="<%=hrMasLocation.getId() %>"><%=hrMasLocation.getLocationName() %></option>

	<%
	}
%>
</select> <input type="hidden" name="locationID" id="locationId" value="" /> <input
	type="hidden" name="locationName" id="locationName" value="" />
<div class="clear"></div>
<input name="show" type="button" class="buttonBig" value="Show Data"
	onClick="submitForm('attendanceVerify','attendance?method=showAttendanceVerifyJsp');" />
</form>
<div class="clear"></div>
<div class="division"></div>


<form name="attendanceVerifyDet" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<% 
if(hrAttendanceLoaderList.size()>0){
%> <label class="auto" name="locName"><%=locName %></label> <%	
}
%>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<!--table starts-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Card No</th>
		<th scope="col">Emp Name</th>
		<th scope="col">TimeIn</th>
		<th scope="col">TimeOut</th>
		<th scope="col">Total Hr</th>
		<th scope="col">Email ID</th>
		<th scope="col">Validate</th>
	</tr>
	<tbody id="tableData">
		<%
 
	 int count=0;
	 if(hrAttendanceLoaderList.size()>0){
		for(HrAttendanceLoader hrAttendanceLoader :hrAttendanceLoaderList){
			String inTime =hrAttendanceLoader.getTimeIn();
			String outTime =hrAttendanceLoader.getTimeOut();
		    String inDate = "01/01/2009";				
			
			Map parameterMap = new HashMap();
			parameterMap.put("inDate",inDate);
			parameterMap.put("outDate",inDate);
			parameterMap.put("inTime",inTime);
			parameterMap.put("outTime",outTime);
			String totalTimeDiff = "";
			Map diffMap = new HashMap();
			
			diffMap = HMSUtil.calculateHourDiffForAttendance(parameterMap);
			
			if(diffMap.get("totalTimeDiff")!= null){
				totalTimeDiff = (String)diffMap.get("totalTimeDiff");
			}
				

			 
 %>
		<%
  	String classFortd = "";
 try{
  if(totalTimeDiff !=null && !totalTimeDiff.equals("") && (new BigDecimal(totalTimeDiff)).compareTo(new BigDecimal(8)) <= 0){ 
	  classFortd = "highlight";
  } else{ 
	  classFortd = "";
 }}catch(Exception e)
 {
	 e.printStackTrace();
 }
  %>

		<tr>
			<td class="<%=classFortd %>"><input type="hidden" id="id"
				name="id<%=count%>" value="<%=hrAttendanceLoader.getId()%>" /> <%=hrAttendanceLoader.getCardNo()%>
			</td>
			<td class="<%=classFortd %>"><%=hrAttendanceLoader.getEmployeeName()%>
			</td>
			<td class="<%=classFortd %>"><input type="text" id="timeIn"
				name="<%=TIME_IN%><%=count%>"
				value="<%=hrAttendanceLoader.getTimeIn()%>" /></td>
			<td class="<%=classFortd %>"><input type="text" id="timeOut"
				name="<%=TIME_OUT%><%=count%>"
				value="<%=hrAttendanceLoader.getTimeOut()%>" /></td>

			<td class="<%=classFortd %>"><%=totalTimeDiff %></td>
			<td class="<%=classFortd %>"><%= hrAttendanceLoader.getEmployee().getEmail()%>
			</td>
			<td class="<%=classFortd %>"><%= hrAttendanceLoader.getValidate()%>
			</td>


		</tr>

		<%
	count++;
	}}
%>
	</tbody>
</table>

<input type="hidden" id="count" name="count" value="<%=count%>" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="save" type="button" class="buttonBig" value="Validate"
	onClick="submitForm('attendanceVerifyDet','attendance?method=saveAttendanceVerify');" />
</form>



<script>

function displayName(){
	var idd  =  document.getElementById('location').value;
	var w = document.getElementById('location').selectedIndex;
	var name = document.getElementById('location').options[w].text;
		document.getElementById('locationId').value = idd;
	document.getElementById('locationName').value = name;
}


		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
</script>






