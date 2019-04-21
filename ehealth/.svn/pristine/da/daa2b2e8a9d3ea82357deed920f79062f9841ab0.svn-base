<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%
List<AppPatientAppointments> queueList=new ArrayList<AppPatientAppointments>();
Map<String, String> queueMap = new HashMap<String, String>();
List<AppSetup>  aapSetupList=new ArrayList<AppSetup>();

Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
if (map.get("queueMap") != null) 
{
	queueMap = (Map<String,String>) map.get("queueMap");
}
if (map.get("queueList") != null) 
{
	queueList = (List<AppPatientAppointments>) map.get("queueList");
}
if(map.get("aapSetupList") != null)
{
	aapSetupList=(List<AppSetup>)map.get("aapSetupList");
	
}
int tokens =0;
if(map.get("startToken") != null)
{
	tokens=Integer.valueOf(map.get("startToken")+"");
}
int totalToken =0;
if(map.get("totalToken") != null)
{
	totalToken=Integer.valueOf(map.get("totalToken")+"");
	
}

int totalAppointments =0;
if(map.get("totalAppointments") != null)
{
	totalAppointments=Integer.valueOf(map.get("totalAppointments")+"");
}
int maxAppointmentCount =0;
if(map.get("maxAppointmentCount") != null)
{
	maxAppointmentCount=Integer.valueOf(map.get("maxAppointmentCount")+"");
	
}

%>
<%if(aapSetupList.size()==0){ %>
<h4>No appointments available for the selected service center</h4>
<%}else{ %>
<h4>Select Queue Priority</h4>
<!-- <input type="button" name="Submit11" value="Submit" tabindex="" class="button" tabindex="1"
			onClick="if(checkFilledField()){if(checkUnit()){submitForm('OnlineAppointment','/hms/hms/appointment?method=submitPatientAppointment&appointmentType=')}}"/>
 -->
 <input type="button" name="Submit11" value="Submit" tabindex="" class="button" tabindex="1"
			onClick="if(checkFilledField()){submitForm('OnlineAppointment','/hms/hms/appointment?method=submitPatientAppointment&Review=R')}"/>  <!-- &appointmentType= -->
 
 <div class="clear"></div>
<div class="paddingTop5"></div>	
<div class="cmntable" onclick="minmaxDayCheck();">
<table align="center" cellspacing="0" cellpadding="0" border="0">
<tr>
<%
int maxAppointmentNo=0;
int appointmentInterval=0;
int startToken=0;
int mindays=0;
int maxdays=0;

int count=0;
if(null !=aapSetupList && aapSetupList.size()>0){
	for(AppSetup appsetup:aapSetupList){
		if(null !=appsetup.getTotalToken())
			if(maxAppointmentCount>0 && maxAppointmentCount <=appsetup.getTotalToken()){
				maxAppointmentNo = maxAppointmentCount;
		
			}else{
			maxAppointmentNo=0;  
		
			}
		if(null !=appsetup.getTotalInterval())
		appointmentInterval=appsetup.getTotalInterval();
		
		if(null !=appsetup.getStartToken())
			if(tokens>0 && tokens <= totalToken && tokens <= totalAppointments ){
				startToken=tokens;
			}else{
				startToken=0;
			}
		
		if(null !=appsetup.getMinNoOfDays()){
			mindays=appsetup.getMinNoOfDays();
		}
		if(null !=appsetup.getMaxNoOfDays()){
			maxdays=appsetup.getMaxNoOfDays();
		}
	}
}%>
<input type="hidden" value="<%=mindays %>" name="minday" id="minday"/>
<input type="hidden" value="<%=maxdays %>" name="maxday" id="maxday"/>


<%

String ccount="";
int j = 15;
int k = 1;
for(int i=0;i<= maxAppointmentNo-queueList.size() && startToken!=0 && startToken <= totalAppointments && startToken<= totalToken;i++){

	count=startToken;	
ccount=String.valueOf(count);

if(i == j*k){ %>
	<tr>
<% }
	if(!(queueMap.containsKey(ccount))){
%>
<td><input type="button" id="Id<%=count%>" name="OnlineToken" value="<%=count%>" onclick="getPriorityNumber(this.value)"></td>

<%}  else{i--; %>
<% }   if(i==(j*k-1)){%>
	</tr>
<% k++;}
	startToken=startToken+appointmentInterval;
}
%>
</table>
</div>
<%}%>
<style>
table {border:0 !important; margin:0px 0px 10px 0px !important; }
table td {border:0 !important;}
</style>
