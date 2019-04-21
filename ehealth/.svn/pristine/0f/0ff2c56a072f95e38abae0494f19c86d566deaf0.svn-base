<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
    Map<String, Map<String,Object>> tokenCounterTimeSlotmap = new LinkedHashMap<String, Map<String,Object>>();
    Box box=HMSUtil.getBox(request);
    String uhid="";
    int deptId=0;
    int empId=0;
    int reviewInterval=0;
    String appointmentDate= null;

    if(!box.getString("uhid").equalsIgnoreCase(""))
    {
    	uhid=box.getString("uhid");
    }
    if(!box.getString("deptId").equalsIgnoreCase(""))
    {
    	deptId=box.getInt("deptId");
    }
boolean recordExists=false;
    Map<String,Object> utilMap = new HashMap<String,Object>();
    utilMap = (Map)HMSUtil.getCurrentTimeHHMM();
    String currentDate = (String)utilMap.get("currentDate");
    String time = (String)utilMap.get("currentTime");

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

String currentTime="";
Map<String, Object> map = new HashMap<String, Object>();

Map<String, Object> dateAndTimeMap=HMSUtil.getCurrentDateAndTime();
currentDate=(String)dateAndTimeMap.get("currentDate");
currentTime=(String)dateAndTimeMap.get("currentTime");

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}


if(map.get("tokenCounterTimeSlotmap") != null){
	tokenCounterTimeSlotmap = (Map<String,Map<String,Object>>)map.get("tokenCounterTimeSlotmap");
}

int opSession = 0;
if(map.get("opSession") != null){
	opSession = (Integer)map.get("opSession");
}


String futureConsultationFlag="";
if (map.get("futureConsultationFlag") != null) 
{
	futureConsultationFlag = (String) map.get("futureConsultationFlag");
}
if (map.get("uhid") != null) 
{
	uhid = (String) map.get("uhid");
}

if(map.get("recordExists")!=null)
{
        recordExists=(Boolean)map.get("recordExists");
}
List<MasSession> masSessionList=new ArrayList<MasSession>();
if(map.get("masSessionList")!=null)
{
	masSessionList=(List<MasSession>)map.get("masSessionList");
}
if(map.get("empId") != null) {
	empId = (Integer) map.get("empId");
}

if(map.get("reviewInterval") != null) {
	reviewInterval = (Integer) map.get("reviewInterval");
}

if(map.get("appointmentDate") != null) {
	appointmentDate = HMSUtil.convertDateToStringWithoutTime((Date)map.get("appointmentDate"));
}
%>

<input type="hidden" id='appointmentDateAfterInterval' value="<%=appointmentDate%>">
<% for(Entry<String,Map<String,Object>> entry : tokenCounterTimeSlotmap.entrySet()) { 
	String timeSlot = 	entry.getKey();
	Map<String,Object> priorityQueueByDepartMap = entry.getValue();
	List<Integer> tokenList = (List<Integer>)priorityQueueByDepartMap.get("tokenList");
	
	
%>
<%if(tokenList.size()!=0){ %>
<fieldset id="<%=timeSlot%>">
<legend>
<%=timeSlot %>
</legend>

<tr>
<%
for(Integer tokenNo : tokenList){
%>
<input type="button" id="Id<%=tokenNo%>" name="OnlineToken" value="<%=tokenNo%>" onclick="getPriorityNumber(this)">
<%} %>
</tr>

</fieldset>
<%} %>
 
 <div class="clear"></div>
 <% } %>