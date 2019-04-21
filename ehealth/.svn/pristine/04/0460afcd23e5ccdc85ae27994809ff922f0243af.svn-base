<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.QueueManagmentDetails"%>
<%@page import="jkt.hms.masters.business.QueueManagment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%

int deptId=0;
int token=0;
String deptName="";
byte[] img=null;
Map map = new HashMap();
List<QueueManagment> queueList = new ArrayList<QueueManagment>();
List<QueueManagment> currentqueueList = new ArrayList<QueueManagment>();
List<QueueManagment> waitingQueueList = new ArrayList<QueueManagment>(); // added by amit das on 22-06-2016
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
if (map.get("queueList") != null) {
	queueList = (List<QueueManagment>)map.get("queueList");
}

if (map.get("currentqueueList") != null) {
	currentqueueList = (List<QueueManagment>)map.get("currentqueueList");
}
// added by amit das on 22-06-2016
if (map.get("waitingQueueList") != null) {
	waitingQueueList = (List<QueueManagment>)map.get("waitingQueueList");
}


%>
<table border="0" bordercolor="#FFCC00" style="background-color: #3399FF;" width="100%" cellpadding="" cellspacing="">
<form name="token">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<% 
int count=0;
int t1=0;
int q1=0;
int t2=0;
int q2=0;



if(currentqueueList.size()>0){

for(QueueManagment obj:currentqueueList){
	if(obj.getTokenStatus().equalsIgnoreCase("y")){
		t1=obj.getTokenNo();
		q1=obj.getTotalHospitalVisit();
	}
}


if(queueList.size()>0){

for(QueueManagment obj:queueList){

	
	if(count==0){
		t2=obj.getTokenNo();
		q2=obj.getTotalHospitalVisit();
	}
	
	count++;
}
}

}





// added by amit das on 22-06-2016
count = 0;
if(waitingQueueList.size()>0){
for(QueueManagment obj:waitingQueueList){

	
	if(count==0){
		t1=obj.getTokenNo();
		q1=obj.getTotalHospitalVisit();
	}
	if(count==1){
		t2=obj.getTokenNo();
		q2=obj.getTotalHospitalVisit();
	}
	
	count++;
}
}

%>
<!-- tr data changed by amit das on 22-06-2016 --> 
<tr>
	<% if(currentqueueList==null || currentqueueList.size()==0) { %>
	<td><center><span class="tokenTextDiv">Token 1</span></br><div class="textPosition"><b><%=(q1!=0)?q1+"/":"" %><%=(t1!=0)?t1:""%></b></div></center></td>
	
	<td ><center><span class="tokenTextDiv">Token 2</span></br><div class="textPosition"><b><%=(q2!=0)?q2+"/":""%><%=(t2!=0)?t2:""%></b></div></center></td>
	<% } else {  %>
	<td><center><span class="tokenTextDiv">Token 1</span></br><div class="blinkTextPosition"><span id="blinkTextspan" class="blinkTextspan"><%=(q1!=0)?q1+"/":"" %><%=(t1!=0)?t1:""%></span></div></center></td>
	
	<td ><center><span class="tokenTextDiv">Token 2</span></br><div class="textPosition"><b><%=(q2!=0)?q2+"/":"" %><%=(t2!=0)?t2:""%></b></div></center></td>
	<% } %>	
</tr>


</form>
</table>