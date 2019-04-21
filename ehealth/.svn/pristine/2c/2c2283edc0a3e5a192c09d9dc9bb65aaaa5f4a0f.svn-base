<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>

<%		
		Map<String, Object> map = new HashMap<String, Object>();
		List <String> cardNoList=new ArrayList<String>();
		List <String> empNameList=new ArrayList<String>();
		List <String> inTimeList=new ArrayList<String>();
		List <String> outTimeList=new ArrayList<String>();
		List employeeAttendanceList = new ArrayList();
		List <String> dateList=new ArrayList<String>();
		String message = "";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("cardNoList")!= null){
			cardNoList = (List)map.get("cardNoList");
		}
		if(map.get("dateList")!= null){
			dateList = (List)map.get("dateList");
		}
		if(map.get("empNameList")!= null){
			empNameList = (List)map.get("empNameList");
			}
		if(map.get("inTimeList")!= null){
			inTimeList = (List)map.get("inTimeList");
			}
		if(map.get("outTimeList")!= null){
			outTimeList = (List)map.get("outTimeList");
			}
		if(map.get("employeeAttendanceList")!= null){
			employeeAttendanceList = (List)map.get("employeeAttendanceList");
			}
		if(map.get("message")!= null){
			message = (String)map.get("message");
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

<%@page import="jkt.hrms.recruitment.masters.business.Uploads"%>
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


<form name="attendanceLoader" method="post" action=""
	enctype="multipart/form-data"><!--Main Div starts here-->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


<div class="titleBg">
<h2>Attendance Loader</h2>
</div>
<div class="Block">
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<label class="auto"><span>*</span> Date</label>
<input type="text" name="<%=ATTENDANCE_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(new Date()) %>"
	class="date" readonly="readonly" validate="To date ,date,yes"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',document.attendanceLoader.<%=ATTENDANCE_DATE%>,event)" />


<%
		if(cardNoList.size()==0){
%> <input type="file" name="upload" class="browse">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input name="save" type="button" class="inputButtonAutu" value="Load Data"
	onClick="submitForm('attendanceLoader','attendance?method=importAttendanceFile&'+csrfTokenName+'='+csrfTokenValue);" />
<%}
		
		if(cardNoList.size() != 0 && empNameList.size() != 0 && dateList.size()!=0 && inTimeList.size()!=0 && outTimeList.size()!=0){%>
<input name="save" id="processId" type="button" class="buttonBig"
	value="Process Data"
	onClick="submitForm('attendanceLoader1','attendance?method=processDataInAttendanceFile&'+csrfTokenName+'='+csrfTokenValue);" />
<%} %>


<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<%
	if(map.get("discardedCardNos")!= null){
%>
<h4><%=(Integer)map.get("discardedCardNos") %> No of Attandence are
not loaded because of unavailblity of card No</h4>
<%} %>
</div>
</form>
<form name="attendanceLoader1" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="division"></div>
<!--table starts-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Card No</th>
		<th scope="col">Emp Name</th>
		<th scope="col">TimeIn</th>
		<th scope="col">TimeOut</th>
		<th scope="col">Date</th>
	</tr>
	<%
 
	 int count=0;
	 if(cardNoList.size()>0){
		for(int i = 0; i < cardNoList.size(); i++){
			 
 %>

	<tr>
		<td><%=cardNoList.get(i)%> <input type="hidden" id="cardNoId"
			name="<%=CARD_NO%><%=count%>" value="<%=cardNoList.get(i)%>" /></td>


		<td><%=empNameList.get(i) %> <input type="hidden" id="employeeId"
			name="<%=EMPLOYEE_NAME%><%=count%>" value="<%=empNameList.get(i)%>" /></td>

		<%if(!inTimeList.get(i).equals("0")){ %>
		<td><%=inTimeList.get(i) %> <input type="hidden"
			name="<%=TIME_IN%><%=count%>" value="<%=inTimeList.get(i)%>" /></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%}if(!outTimeList.get(i).equals("0")){ %>
		<td><%=outTimeList.get(i) %> <input type="hidden"
			name="<%=TIME_OUT%><%=count%>" value="<%=outTimeList.get(i)%>" /> <%}else{ %>

		<td>&nbsp;</td>
		<%} %>
		<td><%=dateList.get(i) %> <input type="hidden"
			name="<%=DISPLAY_DATE%><%=count%>" value="<%=dateList.get(i)%>" /></td>
	</tr>
	<%    
 			
  count++;	
				}
			}
			 
  %>
</table>
<input type="hidden" id="countId" name="counter" value="<%=count%>">
<!--table ends-->
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Last Changed By</label> <label
	class="value"><%=userName%></label> <label>Last Changed DATE</label> <label
	class="value"><%=currentDate%></label> <label>Last Changed Time</label>
<label class="value"><%=currentTime%></label></div>
<div class="clear"></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" /></form>
<div class="clear"></div>
<div class="paddingTop40"></div>