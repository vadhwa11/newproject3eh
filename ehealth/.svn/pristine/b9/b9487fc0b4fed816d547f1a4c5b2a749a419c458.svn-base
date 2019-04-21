<%@page import="java.io.File"%>
<%@page import="java.util.concurrent.PriorityBlockingQueue"%>
<%@page import="jkt.hms.util.PatientVisitBean"%>
<%@page import="java.util.*"%>
<%@page import="java.util.*"%>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * window_popupJsp.jsp
 * Purpose of the JSP -  This is for Window.
 * @author Ramdular
 * Create Date: 14th Sep,2010
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>
<!-- <link href="http://vjs.zencdn.net/4.12/video-js.css" rel="stylesheet"> -->

<link href="/hms/jsp/css/videoPlayer-js.css" rel="stylesheet">
<script src="hms/jsp/js/jquery.min.js"></script>
<!-- Bootstrap JS -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="http://vjs.zencdn.net/4.12/video.js"></script>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.QueueManagment"%>
<%@page import="jkt.hms.masters.business.MasImagesDisplay"%>
<!-- <META HTTP-EQUIV="Refresh" CONTENT="3" >
<meta http-equiv="refresh" content="10;  url=/hms/hms/opd?method=showPopupTokenJsp" /> -->

<link href="/jsp/js/js-image-slider.css" rel="stylesheet" type="text/css" />
    <script src="/jsp/js/js-image-slider.js" type="text/javascript"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<style scoped>
.item img{
    margin: 0 auto;
}

.box{
width:50px;height:100px;border:1px solid black;float:left;
}

#container{
width:100%;
height:200px;
float:left;
overflow-x:scroll;
}
</style>
<%
int deptId=0;
int token=0;
String deptName="";
byte[] img=null;
Map map = new HashMap();
List<MasImagesDisplay> masimgList = new ArrayList<MasImagesDisplay>();
List<QueueManagment> queueList = new ArrayList<QueueManagment>();

if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
if (map.get("deptName") != null) {
	deptName = (String)map.get("deptName");
}
if (map.get("queueList") != null) {
	queueList = (List<QueueManagment>)map.get("queueList");
}
if (map.get("masimgList") != null) {
	masimgList = (List<MasImagesDisplay>)map.get("masimgList");
	
}
if (map.get("deptId") != null) {
	deptId = (Integer)map.get("deptId");
}
if (map.get("imgediplay") != null) {
	img = (byte[])map.get("imgediplay");
}
%>


<body>
<center><font class="BigFont"><%=deptName %></font></center>

<div style="width:100%; hecolor: navy;  border: 2px solid blue; padding: 5px;">


<div style="width: 725px; height:500px color: navy; background-color: lightblue; border: 2px solid blue; padding: 5px; float: left;">
<!-- <div style="width: 50%; float:left;overflow: hidden;"> -->
<table border="1" bordercolor="#FFCC00" style="background-color:#FFFFCC" width="100%" cellpadding="" cellspacing="">
<tr>
<center>Token Number</center>

</tr>

<% 
int count=0;
int t1=0;
int q1=0;
int t2=0;
int q2=0;
int t3=0;
int q3=0;
int t4=0;
int q4=0;
if(queueList.size()>0){

for(QueueManagment obj:queueList){
	if(count==0){
		t1=obj.getTokenNo();
		q1=obj.getTotalHospitalVisit();
	}
	
	if(count==1){
		t2=obj.getTokenNo();
		q2=obj.getTotalHospitalVisit();
	}
	if(count==2){
		t3=obj.getTokenNo();
		q3=obj.getTotalHospitalVisit();
	}
	if(count==3){
		t4=obj.getTokenNo();
		q4=obj.getTotalHospitalVisit();
	}
	count++;
}
}
%>
<tr>
	<td style="padding: 56px;"><div class="Box"><b><h2><center><%=q1 %>/<%=t1%></center></h2></b></div></td>	
	<td style="padding: 56px;"><div class="Box"><b><h2><center><%=q2 %>/<%=t2%></center></h2></b></div></td>	
</tr>
<tr>
	<td style="padding: 56px;"><div class="Box"><b><h2><center><%=q3 %>/<%=t3%></center></h2></b></div></td>	
	<td style="padding: 56px;"><div class="Box"><b><h2><center><%=q4 %>/<%=t4%></center></h2></b></div></td>	
</tr>

</tr>
</table>

</div>

<div id="sliderFrame">
        <div id="slider">
            

<%
int countt=0;
int imageID1=0;
int imageID2=0;
int imageID3=0;
String hos="";
if(masimgList.size()>0){
for(MasImagesDisplay imgg:masimgList){
	if(null !=imgg.getUploadImages()){
		if(countt==0){
		imageID1=imgg.getId();
		}
		if(countt==1){
			imageID2=imgg.getId();
		}
		if(countt==2){
			imageID3=imgg.getId();
		}
		countt++;
	%>

<%} 
}%>
  </div>    
    </div>
<div style="width: 625px; height:500px color: navy; background-color: lightblue; border: 2px solid blue; padding: 5px; float: right;">
<!-- <div style="width: 50%; float:right;overflow: hidden;"> -->
		
<!-- Carousel container -->
<div id="my-pics" class="carousel slide" data-ride="carousel">

<!-- Indicators -->
<ol class="carousel-indicators">
<li data-target="#my-pics" data-slide-to="0" class="active"></li>
<li data-target="#my-pics" data-slide-to="1"></li>
<li data-target="#my-pics" data-slide-to="2"></li>

</ol>

<!-- Content -->
<div class="carousel-inner" role="listbox">

<!-- Slide 1 -->
<div class="item active">
<img src="/hms/hms/opd?method=openImageForDisplay&imageId=<%=imageID1 %>" alt="Sunset over beach" style="width: 625px; height:300px " >
<div class="carousel-caption">
</div>
</div>

 <!-- Slide 2 -->
<div class="item">
<img src="/hms/hms/opd?method=openImageForDisplay&imageId=<%=imageID2 %>" alt="Rob Roy Glacier"  style="width: 625px; height:300px " >
<div class="carousel-caption">

</div>
</div>

<!-- Slide 3 -->
<div class="item">
<img src="/hms/hms/opd?method=openImageForDisplay&imageId=<%=imageID3 %>" alt="Longtail boats at Phi Phi"  style="width: 625px; height:300px " >
<div class="carousel-caption">

</div>
</div>

</div>

<!-- Previous/Next controls -->
<a class="left carousel-control" href="#my-pics" role="button" data-slide="prev" >
<span class="icon-prev" aria-hidden="true"></span>
<span class="sr-only">Previous</span>
</a>
<a class="right carousel-control" href="#my-pics" role="button" data-slide="next" >
<span class="icon-next" aria-hidden="true"></span>
<span class="sr-only">Next</span>
</a>
<%} else{%>
<h4><center>Image Not Available</center></h4>
	
<%}

%>
</div>
</div>

<div class="clear"></div>
<%
String hoName="";
String depName="";

if(queueList.size()>0){
	for(QueueManagment qList:queueList){
		hoName=qList.getHospital().getHospitalName();
		depName=qList.getDepartment().getDepartmentName();
	}
}

%>
<marquee  bgcolor="#00CCFF" scrollamount="30">
<div>Hospital Name: <span class="h2color"><%=hoName %></span>Department Name: <span class="h2color"><%=depName %></span>Timing:</span>  <span class="h2color">6AM to 9PM</span></div>

</marquee>
<!-- <center>
<video id="MY_VIDEO_1" class="video-js vjs-default-skin" controls="false" autoplay="true" loop="true" width="400" height="264" 
data-setup="{}">
        <source src="http://localhost:8088/hms/data/Pingu.mp4"></source>
</video>
</center> -->
</div>
<table>

</tr>
</table>
</body>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">








