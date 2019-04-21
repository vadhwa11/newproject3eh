<%@page import="jkt.hms.masters.business.PharmacyLabQueue"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.io.File"%>
<%@page import="java.util.concurrent.PriorityBlockingQueue"%>
<%@page import="jkt.hms.util.PatientVisitBean"%>
<%@page import="java.util.*"%>
<%@page import="java.util.*"%>
<META HTTP-EQUIV="REFRESH" CONTENT="30"> 
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
body {margin:0px; padding:0px;}

.banner-div-main { 
	width:100%;
	height:auto;
	margin:0 auto;
	padding:0px;}

.flex-container a:hover,
.flex-slider a:hover {
  outline: none;
}
.slides,
.slides > li,
.flex-control-nav,
.flex-direction-nav {
  margin: 0;
  padding: 0;
  list-style: none;
}
.flex-pauseplay span {
  text-transform: capitalize;
}
/* ======= * BASE STYLES * =============*/
.flexslider {
  margin: 0;
  padding: 0;
}
.flexslider .slides > li {
  display: none;
  -webkit-backface-visibility: hidden;
}
.flexslider .slides img {
  width: 100%;
  display: block;
}
.flexslider .slides:after {
  content: "\0020";
  display: block;
  clear: both;
  visibility: hidden;
  line-height: 0;
  height: 0;
}
html[xmlns] .flexslider .slides {
  display: block;
}
* html .flexslider .slides {
  height: 1%;
}
.no-js .flexslider .slides > li:first-child {
  display: block;
}

/* =======    DEFAULT THEME  ==========*/

.flexslider {
  margin: 0 0 0px;
  background: #ffffff;
  border: 0px solid #d1d1d1;
  position: relative;
  border-top:0px;
  zoom: 1;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  -webkit-box-shadow: '' 0 1px 4px rgba(0, 0, 0, 0.2);
  -moz-box-shadow: '' 0 1px 4px rgba(0, 0, 0, 0.2);
  -o-box-shadow: '' 0 1px 4px rgba(0, 0, 0, 0.2);
  box-shadow: '' 0 1px 4px rgba(0, 0, 0, 0.2);
}
.flexslider .slides {
  zoom: 1;
}
.flexslider .slides img {
  height: auto;
  -moz-user-select: none;
}
.flex-viewport {
  max-height: 2000px;
  -webkit-transition: all 1s ease;
  -moz-transition: all 1s ease;
  -ms-transition: all 1s ease;
  -o-transition: all 1s ease;
  transition: all 1s ease;
}
.loading .flex-viewport {
  max-height: 300px;
}
.carousel li {
  margin-right: 5px;
}
.flex-direction-nav { background:blue;
display:none;
  *height: 0;
}
.flex-direction-nav a {
  text-decoration: none;
  display: block;
  width: 40px;
  height: 40px;
  margin: -20px 0 0;
  position: absolute;
  top: 50%;
  z-index: 10;
  overflow: hidden;
  opacity: 0;
  cursor: pointer;
  color: rgba(0, 0, 0, 0.8);
  text-shadow: 1px 1px 0 rgba(255, 255, 255, 0.3);
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -ms-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}
.flex-direction-nav a:before { 
  
  font-size: 40px;
  display: inline-block;  
  color: rgba(0, 0, 0, 0.8);
  text-shadow: 1px 1px 0 rgba(255, 255, 255, 0.3);
}
.flex-direction-nav a.flex-next:before {
  //content: '\f002';  
}
.flex-direction-nav .flex-prev { background:url(../images/pre.png) no-repeat; left: -50px;text-indent: -9999px;  
}
.flex-direction-nav .flex-next { background:url(../images/next.png) no-repeat 28px 1px; text-indent: 9999px;  
  right: -50px;
  text-align: right;
}
.flexslider:hover .flex-direction-nav .flex-prev {
  opacity: 0.7;
  left: 10px;
}
.flexslider:hover .flex-direction-nav .flex-prev:hover {
  opacity: 1;
}
.flexslider:hover .flex-direction-nav .flex-next {
  opacity: 0.7;
  right: 10px;
}
.flexslider:hover .flex-direction-nav .flex-next:hover {
  opacity: 1;
}
.flex-direction-nav .flex-disabled {
  opacity: 0!important;
  filter: alpha(opacity=0);
  cursor: default;
  z-index: -1;
}
.flex-pauseplay a {
  display: block;
  width: 20px;
  height: 20px;
  position: absolute;
  bottom: 5px;
  left: 10px;
  opacity: 0.8;
  z-index: 10;
  overflow: hidden;
  cursor: pointer;
  color: #000;
}
.flex-pauseplay a:before {
  font-family: "flexslider-icon";
  font-size: 20px;
  display: inline-block;
  content: '\f004';
}
.flex-pauseplay a:hover {
  opacity: 1;
}
.flex-pauseplay a.flex-play:before {
  content: '\f003';
}
.flex-control-nav {display: none;
  width: 100%;
  position: absolute;
  bottom: -40px;
  text-align: center;
}
.flex-control-nav li {
  margin: 0 6px;
  display: inline-block;
  zoom: 1;
  *display: inline;
}
.flex-control-paging li a {
  width: 11px;
  height: 11px;
  display: block;
  background: #666;
  background: rgba(0, 0, 0, 0.5);
  cursor: pointer;
  text-indent: -9999px;
  -webkit-box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.3);
  -moz-box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.3);
  -o-box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.3);
  box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.3);
  -webkit-border-radius: 20px;
  -moz-border-radius: 20px;
  border-radius: 20px;
}
.flex-control-paging li a:hover {
  background: #333;
  background: rgba(0, 0, 0, 0.7);
}
.flex-control-paging li a.flex-active {
  background: #000;
  background: rgba(0, 0, 0, 0.9);
  cursor: default;
}
.flex-control-thumbs {
  margin: 5px 0 0;
  position: static;
  overflow: hidden;
}
.flex-control-thumbs li {
  width: 25%;
  float: left;
  margin: 0;
}
.flex-control-thumbs img {
  width: 100%;
  height: auto;
  display: block;
  opacity: .7;
  cursor: pointer;
  -moz-user-select: none;
  -webkit-transition: all 1s ease;
  -moz-transition: all 1s ease;
  -ms-transition: all 1s ease;
  -o-transition: all 1s ease;
  transition: all 1s ease;
}
.flex-control-thumbs img:hover {
  opacity: 1;
}
.flex-control-thumbs .flex-active {
  opacity: 1;
  cursor: default;
}

.flexslider ul li table {
	width:33.3%; 	
	border:solid 1px #8bbeff;
	border-top:0px ;
	float:left;
	}

.flexslider ul li table th { font-size: 1.9vw;
	font-family:Arial, sans-serif;
	color:#fff;
	font-weight:bold;
	text-align:center;
	padding-top:12px;
	padding-bottom:12px;	
	}
/*  .flexslider ul li table th:first-child {background:#0170c2;}  */
/* .flexslider ul li table th:nth-child(2)  {
	border-right:solid 1px #8bbeff;
	background:#0170c2;	
	} */
/* .flexslider ul li table th:nth-child(3) {background:#205867;}
.flexslider ul li table th:nth-child(4)  {
	border-right:solid 1px #8bbeff;
	background:#205867;	
	} */
/* .flexslider ul li table th:nth-child(5) {background:#57257e;}
.flexslider ul li table th:nth-child(6)  {background:#57257e;} */

.flexslider ul li table td { font-size: 1.7vw;
	font-family:Arial, sans-serif;
	color:#fcff00;
	font-weight:bold;
	text-align:center;
	border-top:solid 1px #8bbeff;
	border-right:solid 1px #8bbeff;
	padding-top:10px;
	padding-bottom:10px;	
	}

/* .flexslider ul li table td:first-child { background:#3399ff;}
.flexslider ul li table td:nth-child(2) { background:#3399ff;}

.flexslider ul li table td:nth-child(3) { background:#2b849c;}
.flexslider ul li table td:nth-child(4) { background:#2b849c;}

.flexslider ul li table td:nth-child(5) { background:#7b36b1;}
.flexslider ul li table td:nth-child(6) { background:#7b36b1;}		 */
	
	
.tokenNumberDetails { font-family:Arial, sans-serif;
	background: #1983b1;	
    color: #fff;
    font-size: 2.5vw;
    font-weight: bold;
    padding: 0.6% 0;
    text-align: center;
    width: 100%;	
	}

.currentTokenDiv { width:100%; height:auto; //background:#2b849c;}
.currentTokenLeft { float:left;
	width:30%;
	font-family:Arial, sans-serif;
	font-size: 2.5vw;
    font-weight: bold;
	margin:0px;
	padding:0px 0px 0px 40px;
	}
.nextTokenRight { float:right;
	width:30%;
	font-family:Arial, sans-serif;
	font-size: 2.5vw;
    font-weight: bold;
	margin:0px;
	padding:0px 0px 0px 40px;
	}

.clear, .Clear{
	clear: both;
	overflow: hidden;
	padding: 0px;
	margin: 0px;
	height: 1px;
}
.currentTokenDiv span {color:#ff0000;}

/*----blinking Css start------*/
/* .blink_me {
    -webkit-animation-name: blinker;
    -webkit-animation-duration: 1s;
    -webkit-animation-timing-function: linear;
    -webkit-animation-iteration-count: infinite;
    
    -moz-animation-name: blinker;
    -moz-animation-duration: 1s;
    -moz-animation-timing-function: linear;
    -moz-animation-iteration-count: infinite;
    
    animation-name: blinker;
    animation-duration: 1s;
    animation-timing-function: linear;
    animation-iteration-count: infinite;
}
 */
@-moz-keyframes blinker {  
    0% { opacity: 1.0; }
    50% { opacity: 0.0; }
    100% { opacity: 1.0; }
}

@-webkit-keyframes blinker {  
    0% { opacity: 1.0; }
    50% { opacity: 0.0; }
    100% { opacity: 1.0; }
}

@keyframes blinker {  
    0% { opacity: 1.0; }
    50% { opacity: 0.0; }
    100% { opacity: 1.0; }
}
/*----blinking Css end------*/

/* =========== RESPONSIVE  =================*/

@media screen and (max-width: 860px) {
  .flex-direction-nav .flex-prev {
    opacity: 1;
    left: 10px;
  }
  .flex-direction-nav .flex-next {
    opacity: 1;
    right: 10px;
  }
}
</style>

<script src="/hms/jsp/js/js-image-slider.js" type="text/javascript"></script>

 <!-- jQuery -->  
  <script src="/hms/jsp/js/jquery_min.js" type="text/javascript"></script>
  <script>window.jQuery || document.write('<script src="js/libs/jquery-1.7.min.js">\x3C/script>')</script>
  <!-- FlexSlider -->
  <script src="/hms/jsp/js/jquery.flexslider.js" type="text/javascript"></script>
  
  <script type="text/javascript">
    $(function(){
      SyntaxHighlighter.all();
    });
    $(window).load(function(){
      $('.flexslider').flexslider({
        animation: "slide",
        start: function(slider){
          $('body').removeClass('loading');
        }
      });
    });
  </script>
  
<script type="text/javascript">
function myFunction() {
	$('#blink_me').each(function() {
	    var elem = $(this);
	    var count = 1;
	    var intervalId = setInterval(function() {
	        if (elem.css('visibility') == 'hidden') {
	            elem.css('visibility', 'visible');
	            if (count++ === 10) {
	                clearInterval(intervalId);
	            }
	        } else {
	            elem.css('visibility', 'hidden');
	        }    
	    }, 400);
	});
}

</script>

</head>
<%@page import="java.text.SimpleDateFormat"%>


<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.util.List"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>


<%@ page import="java.util.Properties"%>

<%
        
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
	int prescriptionCount = 0;
	int slideCount = 0;
	int rowCount = 10;
	int k=0;

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String currentTime = (String)utilMap.get("currentTime");
	
	 // List<PatientPrescriptionHeader> patientPrescriptionList = new ArrayList<PatientPrescriptionHeader>(); // commented by amit das on 20-01-2017
	 List<PharmacyLabQueue> pharmacyLabQueueList = new ArrayList<PharmacyLabQueue>(); // added by amit das on 20-01-2017
	Map<Integer,Object> prescriptiontokenMap=new HashMap<Integer,Object>(); 
	Map<Integer,Object> prescriptionQueueMap=new HashMap<Integer,Object>();
	MasDepartment department = null;
	
       if(request.getAttribute("map") != null)
       {
    	   utilMap=(Map<String, Object>)request.getAttribute("map");
       }
      /*  if(null !=utilMap.get("patientPrescriptionList")){
    	   patientPrescriptionList=  (List<PatientPrescriptionHeader>)utilMap.get("patientPrescriptionList");
       } */ // commented by amit das on 20-01-2017
       
       if(null !=utilMap.get("pharmacyLabQueueList")){
    	   pharmacyLabQueueList=  (List<PharmacyLabQueue>)utilMap.get("pharmacyLabQueueList");
       } 
       
       if(utilMap.get("masDepartment")!=null){
    	   department = 	(MasDepartment)utilMap.get("masDepartment");
       }
       
      //  if(null !=patientPrescriptionList && patientPrescriptionList.size()>0){ // commented by amit das on 20-01-2017
    	   if(null !=pharmacyLabQueueList && pharmacyLabQueueList.size()>0){ // added by amit das on 20-01-2017
    	    prescriptionCount=0;
    	 //   for(PatientPrescriptionHeader pph:patientPrescriptionList){ // commented by amit das on 20-01-2017
    		  for(PharmacyLabQueue pph : pharmacyLabQueueList){ // added by amit das on 20-01-2017
    		 /*   prescriptiontokenMap.put(prescriptionCount, pph.getPharmacyLabQueue().getTotalHospitalVisit());
    		   prescriptionQueueMap.put(prescriptionCount, pph.getPharmacyLabQueue().getTokenNo()); */ // commented by amit das on 20-01-2017
    		   prescriptiontokenMap.put(prescriptionCount, pph.getTotalHospitalVisit()); // added by amit das on 20-01-2017
    		   prescriptionQueueMap.put(prescriptionCount, pph.getTokenNo());  // added by amit das on 20-01-2017
    		   
    		   prescriptionCount++;
    		   
    	   }
       }
%>
<body>

<body onload="myFunction()">

<div class="tokenNumberDetails">
Token Display :  
<%=(department!=null)? department.getDepartmentName():"" %>
</div>

<div class="currentTokenDiv">
<%if(prescriptionCount>0){%>
<div class="currentTokenLeft">Current Token:- <span id="blink_me"><%=prescriptiontokenMap.get(0) %> / <%=prescriptionQueueMap.get(0)%></span></div>
<%} %>

<%if(prescriptionCount>1){%>
<div class="nextTokenRight">Next Token:- <span><%=prescriptiontokenMap.get(1) %> / <%=prescriptionQueueMap.get(1)%></span></div>
<%} %>
<div class="clear"></div>
</div>

<div class="banner-div-main">  
<section class="slider">
<div class="flexslider">
<ul class="slides">
<% // if(null !=patientPrescriptionList && patientPrescriptionList.size()>0){ // commented by amit das on 17-01-2017
//added by amit das on 17-01-2017	
if(prescriptionCount>0) {

	slideCount = prescriptionCount/30;
	
	if(prescriptionCount%30>0)
		slideCount = slideCount+1;

	for(int j=1; j<=slideCount; j++){
%>
<li>
<table width="30%" border="0" cellspacing="0" cellpadding="5" >
<tbody>
    <tr style="background:#0170c2;">
      <th>Hospital Sr. No.</th>
      <th style="border-right:solid 1px #8bbeff;">Queue No.</th>
    </tr>
<% for(;k<rowCount;k++) {%>    
<tr style="background:#3399ff;">  
 <%  
		if(k==0) {
	 	if(null !=prescriptiontokenMap.get(k)){ %>
        <td style="color:#fff; background:#FF0000;"> <%= prescriptiontokenMap.get(k) %></td>
     	<%}else{%>
    	 <td>&nbsp; </td>
       <% } 
	    if(null !=prescriptionQueueMap.get(k)){ %>
      <td style="color:#fff; background:#FF0000;"><%= prescriptionQueueMap.get(k) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} 
	   } else {
		   if(null !=prescriptiontokenMap.get(k)){ %>
	        <td> <%= prescriptiontokenMap.get(k) %></td>
	     	<%}else{%>
	    	 <td>&nbsp; </td>
	       <% } 
		    if(null !=prescriptionQueueMap.get(k)){ %>
	      <td><%= prescriptionQueueMap.get(k) %></td>
	     <%}else{ %> 
	     <td >&nbsp;</td>
	     <%} 
	   }
    
	 %>
  </tr>
 <% } %>
 </tbody>
 </table>
 
<table width="30%" border="0" cellspacing="0" cellpadding="5" >
<tbody>
    <tr style="background:#205867;">
      <th>Hospital Sr. No.</th>
      <th style="border-right:solid 1px #8bbeff;">Queue No.</th>
    </tr>  
 <%   
 	rowCount = rowCount+10;
 	for(;k<rowCount;k++){ %>
		<tr style="background:#2b849c;">
	 		<%if(null !=prescriptiontokenMap.get(k)){ %>
	        <td> <%= prescriptiontokenMap.get(k) %></td>
	     	<%}else{%>
	    	 <td>&nbsp; </td>
	       <% } 
		    if(null !=prescriptionQueueMap.get(k)){ %>
	      <td><%= prescriptionQueueMap.get(k) %></td>
	     <%}else{ %> 
	     <td >&nbsp;</td>
	     <%} %>
	    </tr>
	 <% } %>
 </tbody>
 </table>
 
 
 <table width="30%" border="0" cellspacing="0" cellpadding="5" >
<tbody>
    <tr style="background:#57257e;">
      <th>Hospital Sr. No.</th>
      <th style="border-right:solid 1px #8bbeff;">Queue No.</th>
    </tr>
 <%   
 	rowCount = rowCount+10;
 	for(;k<rowCount;k++){ %>
		<tr style="background:#7b36b1;">
	 		<%if(null !=prescriptiontokenMap.get(k)){ %>
	        <td> <%= prescriptiontokenMap.get(k) %></td>
	     	<%}else{%>
	    	 <td>&nbsp; </td>
	       <% } 
		    if(null !=prescriptionQueueMap.get(k)){ %>
	      <td><%= prescriptionQueueMap.get(k) %></td>
	     <%}else{ %> 
	     <td >&nbsp;</td>
	     <%} %>
	    </tr>
	 <% } 
	 
 	rowCount = rowCount+10;
	 %>
 </tbody>
 </table>
 </li>
<% } %> 
<% } %>
 
</ul>
</div>
</section>
</div>

</body>









