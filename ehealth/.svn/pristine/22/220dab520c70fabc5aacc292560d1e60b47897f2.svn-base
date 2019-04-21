<%@page import="jkt.hms.masters.business.AppInvestigationAppointments"%>
<%@page import="jkt.hms.masters.business.AppInvestigationSetup"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>    
    


<%
List<AppInvestigationSetup> appInvestigationSetupList = new ArrayList<AppInvestigationSetup>();

Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
if (map.get("appInvestigationSetupList") != null) 
{
	appInvestigationSetupList = (List<AppInvestigationSetup>) map.get("appInvestigationSetupList");
}
List<AppInvestigationAppointments> patientAppointmentsList = new ArrayList<AppInvestigationAppointments>();
Map<String,String> prioritymap=new HashMap<String,String>();

if(map.get("prioritymap") != null)
{
	prioritymap=(Map<String,String>)map.get("prioritymap");
	
}
%>
<div class="cmntable">
<table align="center">
<tr>
<%
int maxAppointmentNo=0;
int appointmentInterval=0;
int startToken=0;

int count=0;
if(null !=appInvestigationSetupList && appInvestigationSetupList.size()>0){
	for(AppInvestigationSetup appsetup:appInvestigationSetupList){
		if(null !=appsetup.getTotalToken())
		maxAppointmentNo=appsetup.getTotalToken();
		
		if(null !=appsetup.getTotalInterval())
		appointmentInterval=appsetup.getTotalInterval();
		
		if(null !=appsetup.getStartToken())
		startToken=appsetup.getStartToken();
		
		System.out.println("startToken "+startToken);
		System.out.println("appointmentInterval "+appointmentInterval);
		System.out.println("maxAppointmentNo "+maxAppointmentNo);
	}
}



String ccount="";

for(int i=0;i<maxAppointmentNo;i++){
	
count=startToken;
ccount=String.valueOf(count);

if(i<5){
	if(prioritymap.containsKey(ccount)){
%>
<td><input type="button" id="Id<%=count%>" name="OnlineToken" value="<%=count%>" onclick="getPriorityNumber(this.value)" style="background:maroon;" disabled="disabled"></td>

<%}else{%>
<td><input type="button" id="Id<%=count%>" name="OnlineToken" value="<%=count%>" onclick="getPriorityNumber(this.value)"></td>

<%} if(i==4){%>
	</tr>
<% }
}
else{ if(i==5){%>
<tr>
<% }
	if(prioritymap.containsKey(ccount)){
	%>
	<td><input type="button" id="Id<%=count%>" name="OnlineToken" value="<%=count%>" onclick="getPriorityNumber(this.value)" style="background:maroon;" disabled="disabled"></td>
	<%}else{%>
<td><input type="button" id="Id<%=count%>" name="OnlineToken" value="<%=count%>" onclick="getPriorityNumber(this.value)"></td>
	<% }
if(i==maxAppointmentNo){
System.out.println("maxAppointmentNo "+maxAppointmentNo);
%>
</tr>
<% }
}
	startToken=startToken+appointmentInterval;
}

%>
</table>
</div>

