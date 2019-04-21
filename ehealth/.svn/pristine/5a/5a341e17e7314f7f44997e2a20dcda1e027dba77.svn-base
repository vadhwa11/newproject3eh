<!DOCTYPE html>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.SortedSet"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.QueueManagment"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitM"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<html>
<head>
<META HTTP-EQUIV="REFRESH" CONTENT="15">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Token Display</title>      
<style>
body {
	background: #fff;
	margin: 0px;
	padding: 0px;
}

/*----------==========----Token Display Css Start----==========----------------*/
.newTokenDisplayHeader {
	font-family: Arial, sans-serif;
	background: #1983b1;
	color: #fff;
	font-size: 2.5vw;
	font-weight: bold;
	padding: 0.2% 0;
	text-align: center;
	width: 100%;
	-webkit-border-radius: 6px 6px 0px 0px;
	-moz-border-radius: 6px 6px 0px 0px;
	border-radius: 6px 6px 0px 0px;
}

.newTokenDisplayHeader img {margin-top:3px;}
.newTokenDisplay {
	padding: 10px 8px;
	background: #4f5050;
}

.newTokenDisplay table {
	border-collapse: collapse;	
	-webkit-border-radius: 0px 0px 6px 6px;
	-moz-border-radius: 0px 0px 6px 6px;
	border-radius: 0px 0px 6px 6px;
}
.newTokenDisplay table th.colConterAuto {
	font-size:3.3vw;
	font-family: Arial, sans-serif;
	color: #fff;
	font-weight: bold;
	text-align: center;
	border:solid 1px #86a1cf;
	padding-top:5px;
	padding-bottom:5px;
	background: #4472c4;
	height:auto;
}

.newTokenDisplay table th.colAuto {
	font-size:2vw;
	font-family: Arial, sans-serif;
	color: #fff;
	font-weight: bold;
	text-align: center;
	border:solid 1px #86a1cf;
	padding-top:5px;
	padding-bottom:5px;
	background: #4472c4;
	height:auto;
}

.newTokenDisplay table th.colOne {
	font-size:2.5vw;
	font-family: Arial, sans-serif;
	color: #fff;
	font-weight: bold;
	text-align: center;
	border:solid 1px #86a1cf;
	padding-top:5px;
	padding-bottom:5px;
	background: #4472c4;
	width: 50%;
}

.newTokenDisplay table th.colTwo {
	font-size:2.5vw;
	font-family: Arial, sans-serif;
	color: #fff;
	font-weight: bold;
	text-align: center;
	border:solid 1px #86a1cf;
	padding-top:5px;
	padding-bottom:5px;
	background: #4472c4;
	width: 50%;
}

.newTokenDisplay table th.colThree {
	font-size:2.5vw;
	font-family: Arial, sans-serif;
	color: #fff;
	font-weight: bold;
	text-align: center;
	border:solid 1px #86a1cf;
	padding-top:5px;
	padding-bottom:5px;
	background: #4472c4;
	width: 33.33%;
}

.newTokenDisplay table th.colFour {
	font-size:2.5vw;
	font-family: Arial, sans-serif;
	color: #fff;
	font-weight: bold;
	text-align: center;
	border:solid 1px #86a1cf;
	padding-top:5px;
	padding-bottom:5px;
	background: #4472c4;
	width: 25%;
}

.newTokenDisplay table th.colFive {
	font-size:2.5vw;
	font-family: Arial, sans-serif;
	color: #fff;
	font-weight: bold;
	text-align: center;
	border:solid 1px #86a1cf;
	padding-top:5px;
	padding-bottom:5px;
	background: #4472c4;
	width: 20%;
}

.newTokenDisplay table th.colSix {
	font-size:2.5vw;
	font-family: Arial, sans-serif;
	color: #fff;
	font-weight: bold;
	text-align: center;
	border:solid 1px #86a1cf;
	padding-top:5px;
	padding-bottom:5px;
	background: #4472c4;
	width: 16.66%;
}
.newTokenDisplay table th.colSeven {
	font-size:2vw;
	font-family: Arial, sans-serif;
	color: #fff;
	font-weight: bold;
	text-align: center;
	border:solid 1px #86a1cf;
	padding-top:5px;
	padding-bottom:5px;
	background: #4472c4;
	width: 14.28%;
}

.newTokenDisplay table th.colTen {
	font-size:1.8vw;
	font-family: Arial, sans-serif;
	color: #fff;
	font-weight: bold;
	text-align: center;
	border:solid 1px #86a1cf;
	padding-top:5px;
	padding-bottom:5px;
	background: #4472c4;
	width: 25%;
}
.newTokenDisplay table td {
	border-top: solid 1px #8eaadb;
	border-right: solid 1px #8eaadb;
	font-size:3.7vw;
	font-family: Arial, sans-serif;
	color: #000;
	font-weight: bold;
	text-align: center;
	padding-top:8px;
	padding-bottom:8px;
	line-height:82%;
}
/* .newTokenDisplay table tr:nth-child(odd) td {background: #fff;}
.newTokenDisplay table tr:nth-child(even) td {background: #d9e2f3;}  */


.newTokenDisplay table tr:nth-child(odd) th {background: #4472c4;}
.newTokenDisplay table tr:nth-child(even) th {background: #4f81bd;}

.textDetailsDiv {
	width: 96%;
	background: #ededed;
	font-size: 1.6vw;
	color: #444444;
	padding: 1%;
	margin: 0 auto;
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
	border-radius: 6px;
}

.textDetailsDiv p {
	width: auto;
	float: left;
	margin: 0px 80px 0px 0px;
}

.textDetailsDiv p span {
	font-weight: bold;
	color: #0476a8;
}

.queueText {font-family: Arial, sans-serif;
	color: #ff0000;
	font-size:2.5vw;
	font-weight: bold;
	padding: 0.1% 0;
	margin:0px;
	text-align: center;
	background:#fff;	
}
.footer {text-align:center; margin-top:144px;}
.footer img {height:50px; width:1275px; border:0px;}

.legendMain {margin:0 auto; margin-top:15px; width:1275px;height:54px;}
.legendText {font-size:20px;color:#000;font-family: Arial, sans-serif; font-weight:bold; width:auto; height:54px;float:left; margin:0px 15px 0px 5px;}
.colorDiv {width:35px; height:35px; float:left; margin:0px; margin-top:7px;}
.colBlack{background:#000;}
.colOrang{background:#FF8333;}
.colRed{background:#ff0000;}
.colYellow{background:#FFFA8B;}

/*----------==========----Token Display Css end----==========----------------*/
</style>
</head>

<body onload="callAudio()">
<%
	Map<String, Object> map = new HashMap<String, Object>();
List<Object[]> departmentList = new ArrayList<Object[]>();
List<Object[]> deptWisecounterList= new ArrayList<Object[]>();
List<HospitalDoctorUnitM> unitList= new ArrayList<HospitalDoctorUnitM>();


if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}

if (map.get("departmentList") != null) {
	departmentList = (List<Object[]>)map.get("departmentList");
}


if (map.get("deptWisecounterList") != null) {
	deptWisecounterList = (List<Object[]>)map.get("deptWisecounterList");
}


List<QueueManagment> currentqueueList = new ArrayList<QueueManagment>();


if (map.get("currentqueueList") != null) {
	currentqueueList = (List<QueueManagment>)map.get("currentqueueList");
}
if (map.get("unitList") != null) {
	unitList = (List<HospitalDoctorUnitM>)map.get("unitList");
}

int hospitalTypeId=0;
if (map.get("hospitalTypeId") != null) {
	hospitalTypeId = Integer.parseInt(map.get("hospitalTypeId")+"");
	
}

int departmentId = 0;
if (map.get("departmentId") != null) {
	departmentId = Integer.parseInt(map.get("departmentId")+"");
	
}

int hospitalId=0;
if (map.get("hospitalId") != null) {
	hospitalId = Integer.parseInt(map.get("hospitalId")+"");
	
}
System.out.println("hospital Id");
String displayStatused=null;
Map contextMaps = new HashMap();
if(application.getAttribute("contextMap")!=null){
	contextMaps =(Map)application.getAttribute("contextMap");
}
String displayAudioStatus=null;
int displayHospital=0;
String displayConsultationDate=null;
int displayDepartmentId=0;
if(contextMaps.get("displayAudioStatus")!=null){
	displayAudioStatus = (String)contextMaps.get("displayAudioStatus");
}
if(contextMaps.get("displayHospital")!=null){
	displayHospital= Integer.parseInt(contextMaps.get("displayHospital")+"");
}
if(contextMaps.get("displayConsultationDate")!=null){
	displayConsultationDate = (String)contextMaps.get("displayConsultationDate");
}
if(contextMaps.get("displayDepartmentId")!=null){
	displayDepartmentId =Integer.parseInt(contextMaps.get("displayDepartmentId")+"");
}

int counts=0; 
if(hospitalTypeId==9 || hospitalTypeId==11){
	if(displayAudioStatus!=null && displayHospital == hospitalId && departmentId == displayDepartmentId &&  counts <1 ){
		displayStatused=(String)contextMaps.get("displayAudioStatus");
		counts++;
	}else{
	
	}
	
}

int deptWiseArrayCnt = 0;

%>

<%
	for(Object[] dept : departmentList){
		deptWiseArrayCnt++;
		
		List<Object[]> drList = new ArrayList<Object[]>();
		if (map.get("drList"+deptWiseArrayCnt) != null) {
			drList = (List<Object[]>)map.get("drList"+deptWiseArrayCnt);
		}
		
		String[][] tokens = new String[3][drList.size()];
		if(map.get("tokens"+deptWiseArrayCnt) != null){
			tokens = (String[][])map.get("tokens"+deptWiseArrayCnt);
		} 
		String className ="";
		if(drList.size()==1){
			className = "colOne";
		}else if(drList.size()==2){
			className = "colTwo";
		}else if(drList.size()==3){
			className = "colThree";
		}else if(drList.size()==4){
			className = "colFour";
		}else if(drList.size()==5 ){
			className = "colFive";
		}else if(drList.size()==6 ){
			className = "colSix";
		}else if(drList.size()==7 ){
			className = "colSeven";
		}else if(drList.size()>7 ){
			className = "colAuto";
			
		}
		//SortedSet<String> counterSet = new TreeSet<String>();
		List<String> counterSet = new ArrayList<String>();
		if(map.get("counterSet"+deptWiseArrayCnt) != null){
			counterSet = (List<String>)map.get("counterSet"+deptWiseArrayCnt);
		}
		
		
		
%>
<audio id="audio" src="../jsp/audio/Elevator-bell.mp3" ></audio> 
<input type="hidden" id="displayStatused" name="displayStatused" value="<%=displayStatused %>" readonly="readonly" tabindex="1"/>
<div class="newTokenDisplay">

 <%	
 			if(dept[3]!=null) {
 			byte[] imageInByteArray = (byte[])dept[3];
 			//baos.close();
 			if(imageInByteArray!=null) {
 			String b64 = javax.xml.bind.DatatypeConverter
 					.printBase64Binary(imageInByteArray);
 		 %>

  
  		 
<div class="newTokenDisplayHeader"><%=dept[1] %> &nbsp;<img src="data:image/jpg;base64, <%=b64%>" alt="<%=((String)dept[1])%>" title="<%=((String)dept[1])%>"/></div>
      	 	<% } %>      	 	
      	 	
      	 	<%}else{ %>

<div class="newTokenDisplayHeader"><%=dept[1] %></div>

<%} %>
<%
if(drList.size() > 0){ %>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tbody>
    <tr>
    <%
    	
    		for(String counter : counterSet){
    %>
      <th class="colConterAuto"><%=counter %></th>
     
     <%
    		
     }%>
      </tr>
      <tr>
      <%for(int i=0;i<drList.size();i++){ 
    	  Object[] obj = drList.get(i);
			
      %>
      	 <th class="<%=className%>"><%=((String)obj[2]).trim() %></th>
      <%} %>
      </tr>
       <tr>
      <%for(int i=0;i<drList.size();i++){ 
    	  Object[] obj = drList.get(i);
			
      %>
      	 <th>
      	
 		 <%	
 			if(obj[3]!=null) {
 			byte[] imageInByteArray = (byte[])obj[3];
 			
 			if(imageInByteArray!=null) {
 			String b64 = javax.xml.bind.DatatypeConverter
 					.printBase64Binary(imageInByteArray);
 		 %>
  
  		  <img src="data:image/jpg;base64, <%=b64%>" alt="<%=((String)obj[2])%>" />
      	 	<% } } %>
      	 </th>
      <%} %>
      </tr>    
    <tr> 
      <% 
      for (int i=0; i<tokens.length; i++){
    	  String rowClr = "";
    	  if(i==0){
    		  rowClr ="#FFFA8B";
    		  
    	  }else{
    		  rowClr ="#ffffff";
    	  }
    	  %>
      <tr style="background: <%=rowClr%>;height:80px">
			<%for (int j =0; j<drList.size(); j++){
				String prefix= "";
				String clr = "";
				String token =tokens[i][j]!=null?tokens[i][j].trim():"";
				if(!token.equals("") && token.indexOf("#")>0){
				
					clr = token.substring(token.indexOf("#"));
					token = token.substring(0, token.indexOf("#"));
				}
				
				%>
				<td style="color: <%=clr%> "><%=prefix%> <%=(token) %></td>
			<%}
			%>
			</tr>
		<%}
      %>  
   </tbody>
</table>
<%}else{ %>
<p class="queueText">CONSULTATION NOT IN PROGRESS</p>
<%} %>
</div>
<%
		}%>
		<%
		ServletContext context=getServletContext(); 
    	Map contextMap=new HashMap(); 
    	contextMap.put("displayAudioStatus", "No");
    	contextMap.put("displayConsultationDate", null);
    	contextMap.put("displayDepartmentId", null);
    	contextMap.put("displayHospital", null);
	    context.setAttribute("contextMap", contextMap);
		%>
<!-- <div class="clear"></div>
<div class="paddingTop5"></div>
<br/> -->
<!-- <div class="textDetailsDiv">
<p><span>D:</span> Doctor</p>
<p><span>E:</span> Emergency</p>
<p><span>S:</span> Senior Citizen</p>
<p><span>C:</span> Child</p>
<p><span>P:</span> Physically Challenge</p>
<p><span>G:</span> General Queue</p>
<div class="clear"></div>
</div> -->
<div class="clear"></div>
<footer class="footer"><img src="../images/label.png"></footer>
<div class="clear"></div>
<div class="legendMain">
<div class="colorDiv colBlack"></div>
<div class="legendText">Common Pool <br/> <img src="/hms/jsp/images/common_pool.png"></div>
<div class="colorDiv colOrang"></div>
<div class="legendText">Opted for Doctor <br/> <img src="/hms/jsp/images/doctor_specific.png"></div>
<div class="colorDiv colRed"></div>
<div class="legendText">Emergency & Special <br/> <img src="/hms/jsp/images/emergency_special.png"></div>
<div class="colorDiv colYellow"></div>
<div class="legendText">Patient To Be With Doctor <br/> <img src="/hms/jsp/images/patient_called_by_dr.png"></div>
</div>
<div class="clear"></div>
<script>
function callAudio() {
    var audio = document.getElementById("audio");
	var displayStatused = document.getElementById("displayStatused").value;
	if(displayStatused!=null && new String(displayStatused).valueOf()== new String("Yes").valueOf()){
		audio.play();	
	}else if(new String(displayStatused).valueOf()== new String("No").valueOf()){

	}
}
</script>
</body>
</html>

