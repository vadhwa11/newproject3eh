<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HrMeetingSchedule"%>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<%
Map<String,Object> map = new HashMap<String,Object>();
List<HrMeetingSchedule> lsList = new ArrayList<HrMeetingSchedule>();

if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
if(map.get("lsList") != null){
	lsList = (List<HrMeetingSchedule>)map.get("lsList");
}

List<HrMeetingSchedule> meetingNoList = new ArrayList<HrMeetingSchedule>();
if(map.get("meetingNoList") != null){
	meetingNoList = (List<HrMeetingSchedule>)map.get("meetingNoList");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  

boolean flag = false;
String message = "";
if(map.get("message") != null)
{
	 message =  (String)map.get("message");	  
	   
 }	 

if(map.get("dataSaved") != null)
{
	 
	flag =  (Boolean)map.get("dataSaved");
}
if(flag)
{
		out.println("<h4 id='divResult' class='success'>"+message+"</h4>");
}
else
{
	 out.println("<h4 id='divResult' class='failure'>"+message+"</h4>");
} 
%>
<script language="javascript">
var $j = jQuery.noConflict();
</script>
<form name="awaitedIndent" method="post" action="">
<div class="titleBg"><h2>List Of Meeting Scheduling</h2></div>
<div class="Block">
<label>From Date</label>
<input type="text" tabindex="1" class="calDate" name="fromDate" id="fromDate" value="<%=currentDate %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'fromDate');" maxlength="10" size="7"/>
<label>To Date</label>
<input type="text" tabindex="1" class="calDate" name="toDate" id="toDate" value="<%=currentDate %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'toDate');" maxlength="10" size="7"/>

<label>Meeting No.</label>
<select name="meetingId">
			<option value="0">Select</option>
			<%	for (HrMeetingSchedule m :meetingNoList ) {	%>
			<option value=<%=m.getId()%>><%=m.getMeetingNo()%></option>
			<% }%>
		</select>
		<div class="Clear"></div>
<input type="button" name="sss" class="button" value="SEARCH" 	onClick="submitForm('awaitedIndent','training?method=showListOfMeetingSchedulingJsp');" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<table class="cmntable">
<tr>
<th>Sl No.</th>
<th>Meeting No.</th>
<th>Meeting Date</th>
<th>Chaired By</th>
</tr>
<tbody id="tableData">
<%
int inc =1;
if(lsList.size()>0)
{
	for(HrMeetingSchedule ls : lsList)
	{
 		int meetingId = ls.getId();
%>
		<tr onclick="submitForm('awaitedIndent','training?method=showMinutesOfMeetingJsp&meetingId=<%=meetingId %>&flag=centre');">
		<td><%=inc %></td>
		<%
		if(ls.getMeetingNo() != null)
		{ 
%>
			<td><%=ls.getMeetingNo() %></td>
<%
		}
		else
		{
%>
			<td>-</td>
<%
		} 
	
%>
<%
		if(ls.getDate() != null)
		{ 
%>
			<td><%=HMSUtil.convertDateToStringWithoutTime(ls.getDate())%></td>
<%
		}
		else
		{ 
%>
			<td>-</td>
<%} %>
<td><%=(ls.getChairedBy()!=null?ls.getChairedBy():"") %></td>

</tr>
<%
		
inc++;
}}
else
{ %>
<tr><td colspan=9><label id="NoData" class="labelError">No Data Found</label></td></tr>
<%} %>

</tbody>
</table>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		 
	  </script>
 
<div class="clear paddingTop15"></div>
 
<!-- <input type="button" class="button" value="Back" onclick="submitFormForButton('awaitedIndent','training?method=showLegalDefaultJsp');" /> -->
 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

