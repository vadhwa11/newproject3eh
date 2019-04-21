<%@page import="java.util.Map.Entry"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.QueueManagmentDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.io.File"%>
<%@page import="java.util.concurrent.PriorityBlockingQueue"%>
<%@page import="jkt.hms.util.PatientVisitBean"%>
<%@page import="java.util.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.QueueManagment"%>
<%@page import="jkt.hms.masters.business.MasImagesDisplay"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%
/*  response.setIntHeader("Refresh",5); */
int deptId=0;
int token=0;
int totalCount= 0;
int slideCount = 0;
String deptName="";
String hosName ="";
String displayName = null;
String flag = null;
String displayCounter = null;
byte[] img=null;
MasHospital masHospital = null;
List<QueueManagment> currentqueueList = null;
List<QueueManagment> queueList = null;
HashMap<Users,Integer> userMap = null;
Map map = new HashMap();
List<MasImagesDisplay> masimgList = new ArrayList<MasImagesDisplay>();
List<MasImagesDisplay> videoList = new ArrayList<MasImagesDisplay>();
List<QueueManagmentDetails> queueManagmentDetaillist = new ArrayList<QueueManagmentDetails>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}


//added by amit das on 23-06-2017
if(map.get("userMap")!=null){
	userMap = (HashMap<Users,Integer>)map.get("userMap");
			
}	

if (map.get("masHospital") != null) {
	masHospital = (MasHospital)map.get("masHospital");
	 displayCounter = 	masHospital.getCounterWiseTokenDisplay();
}

if (map.get("queueManagmentDetaillist") != null) {
	queueManagmentDetaillist = (List<QueueManagmentDetails>)map.get("queueManagmentDetaillist");
}


if (map.get("masimgList") != null) {
	masimgList = (List<MasImagesDisplay>)map.get("masimgList");
	
}

if (map.get("videoList") != null) {
	videoList = (List<MasImagesDisplay>)map.get("videoList");
	
}

if (map.get("imgediplay") != null) {
	img = (byte[])map.get("imgediplay");
}

if (map.get("flag") != null) {
	flag = (String)map.get("flag");
}

if (map.get("displayName") != null) {
	displayName = (String)map.get("displayName");
}

if (map.get("queueManagmentDetaillist") != null) {
	queueManagmentDetaillist = (List<QueueManagmentDetails>)map.get("queueManagmentDetaillist");
}

if (map.get("currentqueueList") != null) {
	currentqueueList = (List<QueueManagment>)map.get("currentqueueList");
	totalCount = currentqueueList.size();
}
//added by govind 04-02-2017
List<Users> userList =new ArrayList<Users>();
if (map.get("userList") != null) {
	userList = (List<Users>)map.get("userList");
	totalCount = userList.size();
}
//added by govind 04-02-2017 end
Map<Integer,String> newTokenNoMap=new HashMap<Integer,String>();
Map<Integer,String> oldTokenNoMap=new HashMap<Integer,String>();
Map<Integer,String> tokenStatusMap=new HashMap<Integer,String>();

if (map.get("newTokenNoMap") != null) {
	
	newTokenNoMap = (Map) map.get("newTokenNoMap");
}
if (map.get("oldTokenNoMap") != null) {
	oldTokenNoMap = (Map) map.get("oldTokenNoMap");
}
if (map.get("tokenStatusMap") != null) {
	tokenStatusMap = (Map) map.get("tokenStatusMap");
}
int docId=0;
if (map.get("docId") != null) {
	docId = (Integer)map.get("docId");
}
Map<Integer,String> temList=new HashMap<Integer,String>();
Map<Integer,String> depList=new HashMap<Integer,String>();

if(currentqueueList!=null && currentqueueList.size()>0) { 
	for(QueueManagment current:currentqueueList ){
		
		if(current.getDocotor()!=null && current.getDocotor().getFirstName()!=null){
			temList.put(current.getDocotor().getId(), current.getDocotor().getFirstName());
		}
	}
}
int totCount=0;

%>

<% if(totalCount>0) {
    int k = 0,i=0;
    int rowcount = 10;
	slideCount = totalCount/10;
	
	if(totalCount%10>0)
		slideCount = slideCount+1;

	for(int j=1; j<=slideCount; j++){
%>
<table width="100%" cellspacing="0" cellpadding="5" border="2" class="tokenDivmain" >
<!-- <table width="100%" border="0" cellspacing="0" cellpadding="5" > -->
 <tbody>
    <tr>
      <th align="center">Department</th>
      <% if(displayCounter!=null && displayCounter.equalsIgnoreCase("y")) {%>
      <th style="text-align:center !important;">Counter</th>
      <%} else { %>
      <th style="text-align:center !important;">Doctor</th>
      <% } %>
      <th style="text-align:center !important;">Current Token</th>
    </tr>
  </tbody>
 <%   	
 
if(userList.size()>0) { 
for(Users user :userList){
	k++;
	// uncommented by amit das on 22-08-2017
	/* if(userMap.size()>0){
		Set<Entry<Users, Integer>> userEntries = userMap.entrySet(); 
		for(Entry<Users, Integer> userEntry :userEntries){  
			if(userEntry.getValue()!=0){ */ // commented by amit das on 22-08-2017
			k++;		
%>
 <tr>
     <td align="center">
       <%=user.getDepartment().getDepartmentName()%> <!-- uncommented by amit das on 22-08-2017 -->
     
     <%-- <%=userEntry.getKey().getDepartment().getDepartmentName()%> --%>   <!-- commented by amit das on 22-08-2017 -->
      <%-- <input type="hidden" id="deptId<%=i%>" value="<%=userEntry.getKey().getDepartment().getId()%>"/>  --%>  <!-- commented by amit das on 22-08-2017 -->
      <input type="hidden" id="deptId<%=i%>" value="<%=user.getDepartment().getId()%>"/> 
     </td>
      <td style="text-align:center !important;">
      <span style="color: #000 !important">
       <% if(displayCounter!=null && displayCounter.equalsIgnoreCase("y")) {%>
      <%-- <%=(userEntry.getKey().getCurrentCounter()!=null)?userEntry.getKey().getCurrentCounter().getCounterNo():""%> --%> <!-- commented by amit das on 22-08-2017 -->
      		<%=(user.getCurrentCounter()!=null)?user.getCurrentCounter().getCounterNo():""%>
      <% } else { %>
      <%-- <%=userEntry.getKey().getEmployee().getFirstName()%> --%> <!-- commented by amit das on 22-08-2017 -->
      		<%=(user.getEmployee()!=null)?user.getEmployee().getFirstName():""%>
      <% } %>
      </span>      
       <%-- <input type="hidden" id="doctId<%=i%>" value="<%=userEntry.getKey().getEmployee().getId()%>"/> --%>  <!-- commented by amit das on 22-08-2017 -->
       <input type="hidden" id="doctId<%=i%>" value="<%=user.getEmployee().getId()%>"/> 
      </td>
       <td style="text-align:center !important;" >
      <span class="blinkTokenNumberText" id="blinkTokenNumberText<%=i%>"> 
      
        </span>
        <input type="hidden" id="tokenCount<%=i%>" name="tokenCount<%=i%>"  value="0"/> 
        <input type="hidden" id="NewtokenNo<%=i%>" name="NewtokenNo<%=i%>"  value="<%=newTokenNoMap!=null?newTokenNoMap.get(i):""%>"/> 
         <input type="hidden" id="OldtokenNo<%=i%>" name="OldtokenNo<%=i%>"  value="<%=oldTokenNoMap!=null?oldTokenNoMap.get(i):""%>"/> 
       <input type="hidden" id="tokenStatus<%=i%>" name="tokenStatus<%=i%>"  value="<%=tokenStatusMap!=null?tokenStatusMap.get(i):""%>"/>
      </td> 
</tr>

<%	i++;
	// } // commented by amit das on 22-08-2017
}}
  
  rowcount = rowcount+10;
%>
</table>

<% } %> 

<%totCount=i; } %>
<input type="hidden" id="totCount" name="totCount" value="<%=totCount%>"/>
<!-- <audio id="audio" src="../jsp/images/bell_sound.wav" ></audio> -->
<audio id="audio" src="../jsp/audio/Elevator-bell.mp3" ></audio>

