<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet"> 
</script> --%>
<link href="/hms/jsp/css/videoPlayer-js.css" rel="stylesheet">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
<!-- Bootstrap JS -->
<!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
<script src="/hms/jsp/js/VideoPlayer.js"></script>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.QueueManagment"%>
<%@page import="jkt.hms.masters.business.MasImagesDisplay"%>
<!-- <META HTTP-EQUIV="Refresh" CONTENT="3" >
<meta http-equiv="refresh" content="10;  url=/hms/hms/opd?method=showPopupTokenJsp" /> -->
<script type="text/javascript"> 
 /* var csrfTokenName='<csrf:tokenname />';
 var csrfTokenValue='<csrf:tokenvalue />'; */
  var csrfTokenName='${_csrf.parameterName}';
  var csrfTokenValue='${_csrf.token}';
</script>
<link href="/hms/jsp/js/js-image-slider.css" rel="stylesheet" type="text/css" />
    <script src="/hms/jsp/js/js-image-slider.js" type="text/javascript"></script>
<script src="/hms/jsp/js/csrfToken.js" type="text/javascript"></script>
 <script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<style scoped>
.item img{
    margin: 0 auto;
}
social.h2.h2color {
color:orange;
font-size: 10px;
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
<style type="text/css">
.bb {
  -moz-animation-duration: 400ms;
  -moz-animation-name: blink;
  -moz-animation-iteration-count: infinite;
  -moz-animation-direction: alternate;
  
  -webkit-animation-duration: 400ms;
  -webkit-animation-name: blink;
  -webkit-animation-iteration-count: infinite;
  -webkit-animation-direction: alternate;
  
  animation-duration: 400ms;
  animation-name: blink;
  animation-iteration-count: infinite;
  animation-direction: alternate;
}

@-moz-keyframes blink {
  from {
    opacity: 1;
  }
  
  to {
    opacity: 0;
  }
}

@-webkit-keyframes blink {
  from {
    opacity: 1;
  }
  
  to {
    opacity: 0;
  }
}

@keyframes blink {
  from {
    opacity: 1;
  }
  
  to {
    opacity: 0;
  }
}
</style>
<%
//response.setIntHeader("Refresh",5);

int deptId=0;
int token=0;
String deptName="";
byte[] img=null;
Map map = new HashMap();
List<MasImagesDisplay> masimgList = new ArrayList<MasImagesDisplay>();
List<MasImagesDisplay> videoList = new ArrayList<MasImagesDisplay>();
MasDepartment masDepartment = null;
MasHospital masHospital = null;
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
if (map.get("deptName") != null) {
	deptName = (String)map.get("deptName");
}
if (map.get("masDepartment") != null) {
	masDepartment = (MasDepartment)map.get("masDepartment");
}

if (map.get("masHospital") != null) {
	masHospital = (MasHospital)map.get("masHospital");
}

if (map.get("masimgList") != null) {
	masimgList = (List<MasImagesDisplay>)map.get("masimgList");
	
}

if (map.get("videoList") != null) {
	videoList = (List<MasImagesDisplay>)map.get("videoList");
	
}
if (map.get("deptId") != null) {
	deptId = (Integer)map.get("deptId");
}
if (map.get("imgediplay") != null) {
	img = (byte[])map.get("imgediplay");
}
%>


<body>
<div class="depatNameDiv"><center><font class="BigFont"><%=deptName %></font></center></div>

<div class="tokenDivmainWidth"> 
<div class="tokenNumberDiv">
<center>Token Number</center>
</div>



<div class="tokenDetailsDisplay" id="tokenDetailsDisplay">
<!-- <div style="width: 50%; float:left;overflow: hidden;"> -->
<form name="token">


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>

<div id="sliderFrame">
        <div id="slider">
            

<%
int videoId=0;
String videoserverPath="";
if(videoList.size()>0){
for(MasImagesDisplay imgg:videoList){
	videoId=imgg.getId();
	videoserverPath=imgg.getVideoPath();
	System.out.print("videoId  "+videoId);

	if(null !=imgg.getUploadImages()){
		
	}}
}
int countt=0;
int imageID1=0;
int imageID2=0;
int imageID3=0;
String imagePath="";
String hos="";
if(masimgList.size()>0){
for(MasImagesDisplay imgg:masimgList){
	imagePath=imgg.getImagesPath();
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
<%} else{%>
<!-- <h4><center>Image Not Available</center></h4> -->	
<%}

%> 

  </div>    
    </div>
<div class="tokenVideo_DivQueue">

<!-- Content -->
 <%--  <video width="100%" height="100%" controls>
  <source src="/hms/hms/opd?method=openVideoForDisplay&imageIdd=<%=videoserverPath%>" type="video/mp4,video/webm,video/3gp,video/ogg,video/x-ms-vob	">
  
  Your browser does not support the video tag.
</video>  --%>

<video width="100%" height="100%" controls autoplay loop="loop">
  <source src="/hms/images/demo-video.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>

<%--  <video id="MY_VIDEO_1" class="video-js vjs-default-skin" controls="t" autoplay="true" loop="true" width="100%" height="60%" 
data-setup="{}">
         <source src="/hms/hms/opd?method=openVideoForDisplay&imageId=<%=videoId%>"></source> 
         <source src="/hms/hms/opd?method=openVideoForDisplay&imageIdd=<%=videoserverPath%>"></source> 
       <!--  <source src="http://localhost:8088/"></source> -->
        
</video>  --%>
</div>


<div id="my-pics" class="tokenMyPicDiv" data-ride="carousel">
<!-- <div style="width: 50%; float:right;overflow: hidden;"> -->		
<!-- Carousel container -->
<!-- Indicators -->
<!-- <ol class="carousel-indicators">
<li data-target="#my-pics" data-slide-to="0" class="active"></li>
<li data-target="#my-pics" data-slide-to="1"></li>
<li data-target="#my-pics" data-slide-to="2"></li>

</ol> -->

<div class="imageBorderDiv" role="listbox">

<!-- Slide 1 -->
<div class="item">
<%-- <img src="/hms/hms/opd?method=openImageForDisplay&imagepath=<%=imagePath %>" alt="Sunset over beach" style="width:100%; height:95%; " > --%>
<img src="/hms/images/healthcare.jpg" alt="Sunset over beach" class="imageSize" >
<div class="carousel-caption">
</div>
</div>

 <!-- Slide 2 -->
<%-- <div class="item">
<img src="/hms/hms/opd?method=openImageForDisplay&imageId=<%=imageID2%>" alt="Rob Roy Glacier"  style="width:100%; height:95%; " >
<div class="carousel-caption">

</div>
</div>

<!-- Slide 3 -->
<div class="item">
<img src="/hms/hms/opd?method=openImageForDisplay&imageId=<%=imageID3 %>" alt="Longtail boats at Phi Phi"  style="width:100%; height:95%; " >
<div class="carousel-caption">

</div> --%>
</div>

</div> 

<!-- Previous/Next controls -->
<!-- <a class="left carousel-control" href="#my-pics" role="button" data-slide="prev" >
<span class="icon-prev" aria-hidden="true"></span>
<span class="sr-only">Previous</span>
</a>
<a class="right carousel-control" href="#my-pics" role="button" data-slide="next" >
<span class="icon-next" aria-hidden="true"></span>
<span class="sr-only">Next</span>
</a> -->
<%-- <%} else{%>
<h4><center>Image Not Available</center></h4>
	
<%}

%>  --%>
</div>



<div class="clear"></div>
<div class="marqueeDivMain">
<div>
<marquee behavior="scroll" direction="left" scrollamount="6">Hospital Name: <span class="hNameColor"><%=(masHospital!=null)?masHospital.getHospitalName():""%> </span>Department Name: <span class="hNameColor"><%=(masDepartment!=null)?masDepartment.getDepartmentName():"" %></span></span>  <span class="hNameColor"></span>
</marquee>
</div>
</div>
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
<script>
var formName = 'token';
var action = '/hms/hms/opd?method=showPopupTokens';
var divName = 'tokenDetailsDisplay';
getWaitingTokens();
function getWaitingTokens(){
		submitProtoAjaxWithDivName(formName,action,divName);
}
var myVar = setInterval(getWaitingTokens, 10000);
</script>









