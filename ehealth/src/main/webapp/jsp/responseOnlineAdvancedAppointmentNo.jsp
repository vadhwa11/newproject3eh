<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<script type="text/javascript" src="/hms/jsp/js/csrfToken.js"></script>
<meta http-equiv="refresh" content="${pageContext.session.maxInactiveInterval};url=/hms/hms/login?method=logout"/>	
<script src="/hms/jsp/js/dynamic-window-height/jquery.min.js"></script>
<!-- <title>EHA Hospital Management System</title> -->
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>


<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
function getPriorityNumber(priorityNo){
	
	var property=document.getElementById("Id"+priorityNo);
		property.style.background = 'green';
			var val=document.getElementById("preQueue").value;
			if(val>0){
			var ch=document.getElementById("preQueue").value;
			var propert=document.getElementById("Id"+ch);
			propert.style.background = '#0f75bf';
			document.getElementById("preQueue").value=property.value;
			document.getElementById("Id"+ch).value=ch;
			}
			else{
				document.getElementById("preQueue").value=property.value;				
			}	
}
</script>
<script type="text/javascript">
            function check()
            {
            	document.getElementById("preQueue").value=0;
                if (document.getElementById('appointmentDateId').value==""
                 || document.getElementById('appointmentDateId').value==undefined)
                {
                    alert ("Please Enter Appointment Date");
                    document.getElementById('departmentId').selectedIndex="0";
                    return false;
                }
                return true;
            }
        </script>
<%
List<AppPatientAppointments> queueList=new ArrayList<AppPatientAppointments>();
Map<String, String> queueMap = new HashMap<String, String>();
List<AppSetup>  aapSetupList=new ArrayList<AppSetup>();

Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
        System.out.print("Map "+map.size());
}
if (map.get("queueMap") != null) 
{
	queueMap = (Map<String,String>) map.get("queueMap");
	System.out.print("queueMap "+queueMap.size());
}
if(map.get("aapSetupList") != null)
{
	aapSetupList=(List<AppSetup>)map.get("aapSetupList");
	System.out.println("  aapSetupList "+aapSetupList.size());
}


Box box=HMSUtil.getBox(request);
String uhid="";
Integer department =0;
String appointmentDate="";
Integer doctorId=0;
String appointmentType="";
Integer hospitalId=0;
String csrfTokenName=null;
String Review="R";
if(!box.getString("uhid").equalsIgnoreCase(""))
{
	uhid=box.getString("uhid");
	System.out.println("uhid  "+uhid);
}
if(!box.getString("appointmentDate").equalsIgnoreCase(""))
{
	appointmentDate=box.getString("appointmentDate");
	System.out.println("appointmentDate  "+appointmentDate);
}

if(request.getParameter("department")!=null)
{
	department= Integer.parseInt(request.getParameter("department"));
	System.out.println("department "+department);
}

if(request.getParameter("hospitalId")!=null)
{
	hospitalId=Integer.parseInt(request.getParameter("hospitalId"));
	session.setAttribute(HOSPITAL_ID, hospitalId);
	System.out.println("hospitalId  "+hospitalId);
}
if(request.getParameter("csrfTokenName")!=null){
	csrfTokenName=request.getParameter("csrfTokenName");
}
%>
<br/>
<br/>
<br/>
<br/>
<span style="color: red;font-weight: bold;">
<%
if(map.get("message")!=null)
{
%>
<%= map.get("message")%>
<br><br>
<input type="hidden" id="message" value="<%=map.get("message")%>">
<input type="button" id="close" value="Close"  onclick="window.close();" />
<%}%>
</span>
<%if(aapSetupList.size()==0){ %>
<!-- <h4>No appointments available for the selected service center</h4> -->
<%}else{ %>
<h4>Select Queue Priority</h4>
<form name="OnlineAppointment" method="post" action="/hms/hms/appointment?method=submitPatientAppointment&appointmentType=">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="preQueue" id="preQueue" value="0">
<div class="cmntable" onclick="minmaxDayCheck();">
<table align="center" >
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
		maxAppointmentNo=appsetup.getTotalToken();
		
		if(null !=appsetup.getTotalInterval())
		appointmentInterval=appsetup.getTotalInterval();
		
		if(null !=appsetup.getStartToken())
		startToken=appsetup.getStartToken();
		if(null !=appsetup.getMinNoOfDays()){
			mindays=appsetup.getMinNoOfDays();
		}
		if(null !=appsetup.getMaxNoOfDays()){
			maxdays=appsetup.getMaxNoOfDays();
		}
		
		System.out.println("startToken "+startToken);
		System.out.println("appointmentInterval "+appointmentInterval);
		System.out.println("maxAppointmentNo "+maxAppointmentNo);
	}
}%>
<input type="hidden" value="<%=mindays %>" name="minday" id="minday"/>
<input type="hidden" value="<%=maxdays %>" name="maxday" id="maxday"/>
<input type="hidden" value="<%=department %>" name="department" id="departmentId"/>
<input type="hidden" value="<%=appointmentDate %>" name="appointmentDate" id="doctorId"/>
<input type="hidden" value="<%=doctorId %>" name="doctorId" id="doctorId"/>
<input type="hidden" value="<%=uhid %>" name="uhid" id="uhid"/>
<input type="hidden" value="<%=Review%>" name="Review" id="Review"/>

<input type="hidden" value="<%=csrfTokenName %> name="csrfTokenName" id="csrfTokenName"/>
<%

String ccount="";

for(int i=0;i<maxAppointmentNo;i++){
	
count=startToken;
ccount=String.valueOf(count);

if(i<5){
	if(queueMap.containsKey(ccount)){
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
	if(queueMap.containsKey(ccount)){
	%>
	<td><input type="button" id="Id<%=count%>" name="OnlineToken" value="<%=count%>" onclick="getPriorityNumber(this.value)" style="background:maroon;"  disabled="disabled"></td>
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
<div><input type="submit" id="submit" value="Save" onclick="if(checkFilledField());" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" id="close" value="Close"  onclick="window.close();" />
</div>

<!-- <input type="button" name="Submit11" value="Submit" tabindex="" class="button" onclick="submitForm('OnlineAppointment','/hms/hms/appointment?method=submitPatientAppointment&appointmentType=')"> --> 
<%}%>
</form>
<style>
table {border:0 !important; margin:0px 0px 10px 0px !important; }
table td {border:0 !important;}
</style>

<script type="text/javascript">
function checkFilledField(){

	//var deptId = document.getElementById('departmentId').value;
	var OnlineToken=document.getElementById('preQueue').value;
	alert(OnlineToken);
	if (OnlineToken == 0) {
		alert("Select token number ");
		result= false;
	}
	else{
		result= true;
	}	
	return result;
}
</script>
