<%@page import="jkt.hms.masters.business.PharmacyLabQueue"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.io.File"%>
<%@page import="java.util.concurrent.PriorityBlockingQueue"%>
<%@page import="jkt.hms.util.PatientVisitBean"%>
<%@page import="java.util.*"%>
<%@page import="java.util.*"%>

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
	width:100%; 	
	border:solid 1px #8bbeff;
	border-top:0px ;
	}

.flexslider ul li table th { font-size: 1.9vw;
	font-family:Arial, sans-serif;
	color:#fff;
	font-weight:bold;
	text-align:center;
	padding-top:12px;
	padding-bottom:12px;	
	}
.flexslider ul li table th:first-child {background:#0170c2;}
.flexslider ul li table th:nth-child(2)  {
	border-right:solid 1px #8bbeff;
	background:#0170c2;	
	}
.flexslider ul li table th:nth-child(3) {background:#205867;}
.flexslider ul li table th:nth-child(4)  {
	border-right:solid 1px #8bbeff;
	background:#205867;	
	}
.flexslider ul li table th:nth-child(5) {background:#57257e;}
.flexslider ul li table th:nth-child(6)  {background:#57257e;}

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

.flexslider ul li table td:first-child { background:#3399ff;}
.flexslider ul li table td:nth-child(2) { background:#3399ff;}

.flexslider ul li table td:nth-child(3) { background:#2b849c;}
.flexslider ul li table td:nth-child(4) { background:#2b849c;}

.flexslider ul li table td:nth-child(5) { background:#7b36b1;}
.flexslider ul li table td:nth-child(6) { background:#7b36b1;}		
	
	
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
.currentTokenDiv p {
	font-family:Arial, sans-serif;
	font-size: 2.5vw;
    font-weight: bold;
	margin:0px;
	padding:0px 0px 0px 40px;
	}
.currentTokenDiv span {color:#ff0000;}

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

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String currentTime = (String)utilMap.get("currentTime");
	
	//List<PatientPrescriptionHeader> patientPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
	
	List<PharmacyLabQueue> pharmacyLabQueueList=new ArrayList<PharmacyLabQueue>();

Map<Integer,Object> prescriptiontokenMap=null;
prescriptiontokenMap=new HashMap<Integer,Object>();
Map<Integer,Object> prescriptionQueueMap=null;
prescriptionQueueMap=new HashMap<Integer,Object>();
	
       Map<String, Object> map = new HashMap<String, Object>();
       
       if(request.getAttribute("map") != null)
       {
               map=(Map<String, Object>)request.getAttribute("map");
       }
       if(null !=map.get("pharmacyLabQueueList")){
    	   pharmacyLabQueueList=  (List<PharmacyLabQueue> )map.get("pharmacyLabQueueList");
       }
       if(null !=pharmacyLabQueueList && pharmacyLabQueueList.size()>0){
    	   int prescriptionCount=1;
    	   for(PharmacyLabQueue pph:pharmacyLabQueueList){
    		   prescriptiontokenMap.put(prescriptionCount, pph.getTotalHospitalVisit());
    		   prescriptionQueueMap.put(prescriptionCount, pph.getTokenNo());
    		   prescriptionCount++;
    		   
    	   }
       }
%>
<body>
<div class="tokenNumberDetails">Token Display</div>
<div class="currentTokenDiv">
<%if(null !=pharmacyLabQueueList && pharmacyLabQueueList.size()>0){%>
<p>Current Token:- <span><%=prescriptiontokenMap.get(1) %> /<%=prescriptionQueueMap.get(1)%></span></p>
<%} %>
</div>
<div class="banner-div-main">  
<section class="slider">
<div class="flexslider">
<ul class="slides">
<li>
<%if(null !=pharmacyLabQueueList && pharmacyLabQueueList.size()>0){%>
<table width="100%" border="0" cellspacing="0" cellpadding="5">
<tbody>
    <tr>
      <th>Token No.</th>
      <th>Queue No.</th>
      <th>Token No.</th>
      <th>Queue No.</th>
      <th>Token No.</th>
      <th>Queue No.</th>
        </tr>
     <tr>
       
     <%if(null !=prescriptiontokenMap.get(1)){ %>
     <td style="color:#fff; background:#FF0000;"> <%= prescriptiontokenMap.get(1) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(1)){ %>
      <td style="color:#fff; background:#FF0000;"><%= prescriptionQueueMap.get(1) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(11)){ %>
     <td> <%= prescriptiontokenMap.get(11) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(11)){ %>
      <td ><%= prescriptionQueueMap.get(11) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
      <%if(null !=prescriptiontokenMap.get(21)){ %>
     <td> <%= prescriptiontokenMap.get(21) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(21)){ %>
      <td ><%= prescriptionQueueMap.get(21) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
    </tr>
   <tr>
    <%if(null !=prescriptiontokenMap.get(2)){ %>
     <td> <%= prescriptiontokenMap.get(2) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(2)){ %>
      <td ><%= prescriptionQueueMap.get(2) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
     
   <%if(null !=prescriptiontokenMap.get(12)){ %>
     <td> <%= prescriptiontokenMap.get(12) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(12)){ %>
      <td ><%= prescriptionQueueMap.get(12) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(22)){ %>
     <td> <%= prescriptiontokenMap.get(22) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(22)){ %>
      <td ><%= prescriptionQueueMap.get(22) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
       
      </tr>
      
       <tr>
     <%if(null !=prescriptiontokenMap.get(3)){ %>
     <td> <%= prescriptiontokenMap.get(3) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(3)){ %>
      <td ><%= prescriptionQueueMap.get(3) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(13)){ %>
     <td> <%= prescriptiontokenMap.get(13) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(13)){ %>
      <td ><%= prescriptionQueueMap.get(13) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(23)){ %>
     <td> <%= prescriptiontokenMap.get(23) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(23)){ %>
      <td ><%= prescriptionQueueMap.get(23) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
       
      </tr>
      
       <tr>
     <%if(null !=prescriptiontokenMap.get(4)){ %>
     <td> <%= prescriptiontokenMap.get(4) %></td>
     <%}else{%>
    	 <td> &nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(4)){ %>
      <td ><%= prescriptionQueueMap.get(4) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(14)){ %>
     <td> <%= prescriptiontokenMap.get(14) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   <%if(null !=prescriptionQueueMap.get(14)){ %>
      <td ><%= prescriptionQueueMap.get(14) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
   <%if(null !=prescriptionQueueMap.get(24)){ %>
      <td ><%= prescriptionQueueMap.get(24) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
      <%if(null !=prescriptiontokenMap.get(24)){ %>
     <td> <%= prescriptiontokenMap.get(24) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(12)){ %>
      <td ><%= prescriptionQueueMap.get(12) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
       <%if(null !=prescriptiontokenMap.get(12)){ %>
     <td> <%= prescriptiontokenMap.get(12) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
      </tr>
      
       <tr>
     <%if(null !=prescriptiontokenMap.get(5)){ %>
     <td> <%= prescriptiontokenMap.get(5) %></td>
     <%}else{%>
    	 <td> &nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(5)){ %>
      <td ><%= prescriptionQueueMap.get(5) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(15)){ %>
     <td> <%= prescriptiontokenMap.get(15) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(15)){ %>
      <td ><%= prescriptionQueueMap.get(15) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
      <%if(null !=prescriptiontokenMap.get(25)){ %>
     <td> <%= prescriptiontokenMap.get(25) %></td>
     <%}else{%>
    	 <td>&nbsp; </td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(25)){ %>
      <td ><%= prescriptionQueueMap.get(25) %></td>
     <%}else{ %> 
     <td >&nbsp;</td>
     <%} %>
       
      </tr>
     
       <tr>
       <%if(null !=prescriptiontokenMap.get(6)){ %>
     <td> <%= prescriptiontokenMap.get(6) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(6)){ %>
      <td ><%= prescriptionQueueMap.get(6) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
     
  <%if(null !=prescriptiontokenMap.get(16)){ %>
     <td> <%= prescriptiontokenMap.get(16) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(16)){ %>
      <td ><%= prescriptionQueueMap.get(16) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(26)){ %>
     <td> <%= prescriptiontokenMap.get(26) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(26)){ %>
      <td ><%= prescriptionQueueMap.get(26) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
     
     <tr>
       <%if(null !=prescriptiontokenMap.get(7)){ %>
     <td> <%= prescriptiontokenMap.get(7) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(7)){ %>
      <td ><%= prescriptionQueueMap.get(7) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
     
  <%if(null !=prescriptiontokenMap.get(17)){ %>
     <td> <%= prescriptiontokenMap.get(17) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(17)){ %>
      <td ><%= prescriptionQueueMap.get(17) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(27)){ %>
     <td> <%= prescriptiontokenMap.get(27) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(27)){ %>
      <td ><%= prescriptionQueueMap.get(27) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
     
     <tr>
       <%if(null !=prescriptiontokenMap.get(8)){ %>
     <td> <%= prescriptiontokenMap.get(8) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(8)){ %>
      <td ><%= prescriptionQueueMap.get(8) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
     
  <%if(null !=prescriptiontokenMap.get(18)){ %>
     <td> <%= prescriptiontokenMap.get(18) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(18)){ %>
      <td ><%= prescriptionQueueMap.get(18) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(28)){ %>
     <td> <%= prescriptiontokenMap.get(28) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(28)){ %>
      <td ><%= prescriptionQueueMap.get(28) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
     
     <tr>
       <%if(null !=prescriptiontokenMap.get(9)){ %>
     <td> <%= prescriptiontokenMap.get(9) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(9)){ %>
      <td ><%= prescriptionQueueMap.get(9) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
     
  <%if(null !=prescriptiontokenMap.get(19)){ %>
     <td> <%= prescriptiontokenMap.get(19) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(19)){ %>
      <td ><%= prescriptionQueueMap.get(19) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(29)){ %>
     <td> <%= prescriptiontokenMap.get(29) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(29)){ %>
      <td ><%= prescriptionQueueMap.get(29) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
     
     <tr>
       <%if(null !=prescriptiontokenMap.get(10)){ %>
     <td> <%= prescriptiontokenMap.get(10) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(10)){ %>
      <td ><%= prescriptionQueueMap.get(10) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
     
  <%if(null !=prescriptiontokenMap.get(20)){ %>
     <td> <%= prescriptiontokenMap.get(20) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(20)){ %>
      <td ><%= prescriptionQueueMap.get(20) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(30)){ %>
     <td> <%= prescriptiontokenMap.get(30) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(30)){ %>
      <td ><%= prescriptionQueueMap.get(30) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
     
    <%} %>
    
  </tbody>
</table>
</li>
<li>
<table width="100%" border="0" cellspacing="0" cellpadding="5">
<tbody>
    <tr>
      <th>Token No.</th>
      <th>Queue No.</th>
      <th>Token No.</th>
      <th>Queue No.</th>
      <th>Token No.</th>
      <th>Queue No.</th>
    </tr>
    <tr >
       <tr>
     <%if(null !=prescriptiontokenMap.get(31)){ %>
     <td> <%= prescriptiontokenMap.get(31) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(31)){ %>
      <td ><%= prescriptionQueueMap.get(31) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(32)){ %>
     <td> <%= prescriptiontokenMap.get(32) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(32)){ %>
      <td ><%= prescriptionQueueMap.get(32) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(33)){ %>
     <td> <%= prescriptiontokenMap.get(33) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(33)){ %>
      <td ><%= prescriptionQueueMap.get(33) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
    </tr>
    <tr >
      <tr>
     <%if(null !=prescriptiontokenMap.get(34)){ %>
     <td> <%= prescriptiontokenMap.get(34) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(34)){ %>
      <td ><%= prescriptionQueueMap.get(34) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(35)){ %>
     <td> <%= prescriptiontokenMap.get(35) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(35)){ %>
      <td ><%= prescriptionQueueMap.get(35) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(36)){ %>
     <td> <%= prescriptiontokenMap.get(36) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(36)){ %>
      <td ><%= prescriptionQueueMap.get(36) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(37)){ %>
     <td> <%= prescriptiontokenMap.get(37) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(37)){ %>
      <td ><%= prescriptionQueueMap.get(37) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(38)){ %>
     <td> <%= prescriptiontokenMap.get(38) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(38)){ %>
      <td ><%= prescriptionQueueMap.get(38) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(39)){ %>
     <td> <%= prescriptiontokenMap.get(39) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(39)){ %>
      <td ><%= prescriptionQueueMap.get(39) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(40)){ %>
     <td> <%= prescriptiontokenMap.get(40) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(40)){ %>
      <td ><%= prescriptionQueueMap.get(40) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(41)){ %>
     <td> <%= prescriptiontokenMap.get(41) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(41)){ %>
      <td ><%= prescriptionQueueMap.get(41) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(42)){ %>
     <td> <%= prescriptiontokenMap.get(42) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(42)){ %>
      <td ><%= prescriptionQueueMap.get(42) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(43)){ %>
     <td> <%= prescriptiontokenMap.get(43) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(43)){ %>
      <td ><%= prescriptionQueueMap.get(43) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(44)){ %>
     <td> <%= prescriptiontokenMap.get(44) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(44)){ %>
      <td ><%= prescriptionQueueMap.get(44) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(45)){ %>
     <td> <%= prescriptiontokenMap.get(45) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(45)){ %>
      <td ><%= prescriptionQueueMap.get(45) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(46)){ %>
     <td> <%= prescriptiontokenMap.get(46) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(46)){ %>
      <td ><%= prescriptionQueueMap.get(46) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(47)){ %>
     <td> <%= prescriptiontokenMap.get(47) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(47)){ %>
      <td ><%= prescriptionQueueMap.get(47) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(48)){ %>
     <td> <%= prescriptiontokenMap.get(48) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(48)){ %>
      <td ><%= prescriptionQueueMap.get(48) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(49)){ %>
     <td> <%= prescriptiontokenMap.get(49) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(49)){ %>
      <td ><%= prescriptionQueueMap.get(49) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(50)){ %>
     <td> <%= prescriptiontokenMap.get(50) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(50)){ %>
      <td ><%= prescriptionQueueMap.get(50) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(51)){ %>
     <td> <%= prescriptiontokenMap.get(51) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(51)){ %>
      <td ><%= prescriptionQueueMap.get(51) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(52)){ %>
     <td> <%= prescriptiontokenMap.get(52) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(52)){ %>
      <td ><%= prescriptionQueueMap.get(52) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(53)){ %>
     <td> <%= prescriptiontokenMap.get(53) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(53)){ %>
      <td ><%= prescriptionQueueMap.get(53) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(54)){ %>
     <td> <%= prescriptiontokenMap.get(54) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(54)){ %>
      <td ><%= prescriptionQueueMap.get(54) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(55)){ %>
     <td> <%= prescriptiontokenMap.get(55) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(55)){ %>
      <td ><%= prescriptionQueueMap.get(55) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(56)){ %>
     <td> <%= prescriptiontokenMap.get(56) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(56)){ %>
      <td ><%= prescriptionQueueMap.get(56) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(57)){ %>
     <td> <%= prescriptiontokenMap.get(57) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(57)){ %>
      <td ><%= prescriptionQueueMap.get(57) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(58)){ %>
     <td> <%= prescriptiontokenMap.get(58) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(58)){ %>
      <td ><%= prescriptionQueueMap.get(58) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(59)){ %>
     <td> <%= prescriptiontokenMap.get(59) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(59)){ %>
      <td ><%= prescriptionQueueMap.get(59) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(60)){ %>
     <td> <%= prescriptiontokenMap.get(60) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(60)){ %>
      <td ><%= prescriptionQueueMap.get(60) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
  </tbody>
</table>
</li>
<li>
<table width="100%" border="0" cellspacing="0" cellpadding="5">
<tbody>
    <tr>
      <th>Token No.</th>
      <th>Queue No.</th>
      <th>Token No.</th>
      <th>Queue No.</th>
      <th>Token No.</th>
      <th>Queue No.</th>
    </tr>
    <tr >
       <tr>
     <%if(null !=prescriptiontokenMap.get(61)){ %>
     <td> <%= prescriptiontokenMap.get(61) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(61)){ %>
      <td ><%= prescriptionQueueMap.get(61) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(62)){ %>
     <td> <%= prescriptiontokenMap.get(62) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(62)){ %>
      <td ><%= prescriptionQueueMap.get(62) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(63)){ %>
     <td> <%= prescriptiontokenMap.get(63) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(63)){ %>
      <td ><%= prescriptionQueueMap.get(63) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
    <tr >
      < <tr>
     <%if(null !=prescriptiontokenMap.get(64)){ %>
     <td> <%= prescriptiontokenMap.get(64) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(64)){ %>
      <td ><%= prescriptionQueueMap.get(64) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(65)){ %>
     <td> <%= prescriptiontokenMap.get(65) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(65)){ %>
      <td ><%= prescriptionQueueMap.get(65) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(66)){ %>
     <td> <%= prescriptiontokenMap.get(66) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(66)){ %>
      <td ><%= prescriptionQueueMap.get(66) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(67)){ %>
     <td> <%= prescriptiontokenMap.get(67) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(67)){ %>
      <td ><%= prescriptionQueueMap.get(67) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(68)){ %>
     <td> <%= prescriptiontokenMap.get(68) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(68)){ %>
      <td ><%= prescriptionQueueMap.get(68) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(69)){ %>
     <td> <%= prescriptiontokenMap.get(69) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(69)){ %>
      <td ><%= prescriptionQueueMap.get(69) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    </tr>
    <tr>
      <tr>
     <%if(null !=prescriptiontokenMap.get(70)){ %>
     <td> <%= prescriptiontokenMap.get(70) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(70)){ %>
      <td ><%= prescriptionQueueMap.get(70) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(71)){ %>
     <td> <%= prescriptiontokenMap.get(71) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(71)){ %>
      <td ><%= prescriptionQueueMap.get(71) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(72)){ %>
     <td> <%= prescriptiontokenMap.get(72) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(72)){ %>
      <td ><%= prescriptionQueueMap.get(72) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
   
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(73)){ %>
     <td> <%= prescriptiontokenMap.get(73) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(73)){ %>
      <td ><%= prescriptionQueueMap.get(73) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(74)){ %>
     <td> <%= prescriptiontokenMap.get(74) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(74)){ %>
      <td ><%= prescriptionQueueMap.get(74) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(75)){ %>
     <td> <%= prescriptiontokenMap.get(75) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(75)){ %>
      <td ><%= prescriptionQueueMap.get(75) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    <tr>
      <tr>
     <%if(null !=prescriptiontokenMap.get(76)){ %>
     <td> <%= prescriptiontokenMap.get(76) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(76)){ %>
      <td ><%= prescriptionQueueMap.get(76) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(77)){ %>
     <td> <%= prescriptiontokenMap.get(77) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(77)){ %>
      <td ><%= prescriptionQueueMap.get(77) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(78)){ %>
     <td> <%= prescriptiontokenMap.get(78) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(78)){ %>
      <td ><%= prescriptionQueueMap.get(78) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
   
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(79)){ %>
     <td> <%= prescriptiontokenMap.get(79) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(79)){ %>
      <td ><%= prescriptionQueueMap.get(79) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(80)){ %>
     <td> <%= prescriptiontokenMap.get(80) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(80)){ %>
      <td ><%= prescriptionQueueMap.get(80) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(81)){ %>
     <td> <%= prescriptiontokenMap.get(81) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(81)){ %>
      <td ><%= prescriptionQueueMap.get(81) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
   
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(82)){ %>
     <td> <%= prescriptiontokenMap.get(82) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(82)){ %>
      <td ><%= prescriptionQueueMap.get(82) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(83)){ %>
     <td> <%= prescriptiontokenMap.get(83) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(83)){ %>
      <td ><%= prescriptionQueueMap.get(83) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(84)){ %>
     <td> <%= prescriptiontokenMap.get(84) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(84)){ %>
      <td ><%= prescriptionQueueMap.get(84) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    
    <tr>
       <tr>
     <%if(null !=prescriptiontokenMap.get(85)){ %>
     <td> <%= prescriptiontokenMap.get(85) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(85)){ %>
      <td ><%= prescriptionQueueMap.get(85) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(86)){ %>
     <td> <%= prescriptiontokenMap.get(86) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(86)){ %>
      <td ><%= prescriptionQueueMap.get(86) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(87)){ %>
     <td> <%= prescriptiontokenMap.get(87) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(87)){ %>
      <td ><%= prescriptionQueueMap.get(87) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
    
    <tr>
      <tr>
     <%if(null !=prescriptiontokenMap.get(88)){ %>
     <td> <%= prescriptiontokenMap.get(88) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(88)){ %>
      <td ><%= prescriptionQueueMap.get(88) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
   <%if(null !=prescriptiontokenMap.get(89)){ %>
     <td> <%= prescriptiontokenMap.get(89) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(89)){ %>
      <td ><%= prescriptionQueueMap.get(89) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
      
      <%if(null !=prescriptiontokenMap.get(90)){ %>
     <td> <%= prescriptiontokenMap.get(90) %></td>
     <%}else{%>
    	 <td >&nbsp;</td>
    <% } %>
   
   <%if(null !=prescriptionQueueMap.get(90)){ %>
      <td ><%= prescriptionQueueMap.get(90) %></td>
     <%}else{ %> 
     <td ></td>
     <%} %>
       
      </tr>
      
    
  </tbody>
</table>
</li>
<!--<li> slider-4 </li>-->
</ul>
</div>
</section>
</div>

</body>









