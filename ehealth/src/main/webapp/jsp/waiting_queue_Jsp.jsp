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
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="1">   -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.QueueManagment"%>
<%@page import="jkt.hms.masters.business.MasImagesDisplay"%>
<%@page import="jkt.hms.masters.business.Users"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"> 
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>
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

// added by amit das on 23-06-2017
if(map.get("userMap")!=null){
	userMap = (HashMap<Users,Integer>)map.get("userMap");
			
}	

if (map.get("masHospital") != null) {
	masHospital = (MasHospital)map.get("masHospital");
	
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
System.out.println("displayName jsp "+displayName);
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
int docId=0;
if (map.get("docId") != null) {
	docId = (Integer)map.get("docId");
}

int hospitalId=0;

if (map.get("hospitalId") != null) {
	hospitalId = (Integer)map.get("hospitalId");
	
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
 <!-- jQuery -->  
   <script src="/hms/jsp/js/jquery_min.js" type="text/javascript"></script>
   <script>window.jQuery || document.write('<script src="js/libs/jquery-1.7.min.js">\x3C/script>')</script>
  <!-- FlexSlider -->
  <script src="/hms/jsp/js/jquery.flexslider.js" type="text/javascript"></script>
  <script>jQuery.noConflict();</script>
  <script type="text/javascript">
    $(function(){
     // SyntaxHighlighter.all();
    });
   /* $(window).load(function(){
      $('.flexslider').flexslider({
        animation: "slide",
        start: function(slider){
          $('body').removeClass('loading');
        }
      });
    });*/
    
    function myFunction() {
    	$('.blinkTokenNumberText').each(function() {
    	//	alert("alert");
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
<!-- <body onload="myFunction();"> -->
<body>

<form name="tokenDisp" method="post">
<div class="tokenNumberDetails">
Token Display</div>
<div class="banner-div-main" >  
<section class="slider">
<div class="flexslider" id="tokenDiv">
<ul class="slides">
<% if(totalCount>0) {
    int k = 0,i=0;
    int rowcount = 10;
	slideCount = totalCount/10;
	
	if(totalCount%10>0)
		slideCount = slideCount+1;

	for(int j=1; j<=slideCount; j++){
%>
<li>
<table width="100%" cellspacing="0" cellpadding="5" border="2" class="tokenDivmain" >
<!-- <table width="100%" border="0" cellspacing="0" cellpadding="5" > -->
 <tbody>
    <tr>
      <th align="center">Department</th>
      <% if(masHospital!=null && masHospital.getCounterWiseTokenDisplay()!=null && masHospital.getCounterWiseTokenDisplay().equalsIgnoreCase("y")) {%>
      <th align="text-align:center !important;">Counter</th>
      <%} else { %>
      <th align="text-align:center !important;">Doctor</th>
      <% } %>
      <th style="text-align:center !important;">Current Token</th>
    </tr>
  </tbody>


<%   	
/* if(userList.size()>0) { 
for(Users user :userList){
	k++; */
// commented by amit das on 23-06-2017
if(userMap.size()>0){
	Set<Entry<Users, Integer>> userEntries = userMap.entrySet(); 
	for(Entry<Users, Integer> userEntry :userEntries){
		if(userEntry.getValue()!=0){ 
		k++;		
%>
 <tr>
     <td align="center">
     <%-- <%=user.getDepartment().getDepartmentName()%> --%> <!-- commented by amit das on 23-06-2017 -->
     
     <%=userEntry.getKey().getDepartment().getDepartmentName()%> <!-- added by amit das on 23-06-2017 -->
       <input type="hidden" id="deptId<%=i%>" value="<%=userEntry.getKey().getDepartment().getId()%>"/> 
     </td>
      <td align="text-align:center !important;">
      <span style="color: #000 !important">
      <%=userEntry.getKey().getEmployee().getFirstName()%>
      </span>      
       <input type="hidden" id="doctId<%=i%>" value="<%=userEntry.getKey().getEmployee().getId()%>"/> 
      </td>
       <td style="text-align:center !important;" >
      <span class="blinkTokenNumberText" id="blinkTokenNumberText<%=i%>"> 
        </span>
        <input type="hidden" id="tokenCount<%=i%>" value="0" /> 
        <input type="hidden" id="NewtokenNo<%=i%>" value="" /> 
        <input type="hidden" id="OldtokenNo<%=i%>" value="" /> 
        
         <input type="hidden" id="tokenStatus<%=i%>" value="N"/>
      </td> 
</tr>

<%	i++;
	}
}}
  
  rowcount = rowcount+10;
%>
</table>

</li>
<% } %> 

<%totCount=i; } %>
</ul>
<input type="hidden" id="totCount" value="<%=totCount%>"/>
<!-- <audio id="audio" src="../jsp/images/bell_sound.wav" ></audio> -->
<audio id="audio" src="../jsp/audio/Elevator-bell.mp3" ></audio>
</div>

</section>
</div>  
 <div class="clear"></div>

<div class="marqueeDiv_Main">

<div><marquee behavior="scroll" direction="left" scrollamount="6">Hospital Name: <span class="hNameColor"><%=(masHospital!=null)?masHospital.getHospitalName():""%></span><span class="hNameColor"></span>
</marquee>
</div>
</div>  
</form>

</body>
<script type="text/javascript">
callDivTokenFunct();
function callDivTokenFunct(){
	submitProtoAjaxWithDivName('tokenDisp','/hms/hms/opd?method=getOPTokenList&flag=open&displayName='+'<%=displayName%>','tokenDiv');
	setTimeout(callDivTokenFunct, 10000);
}

callColorTokenFunct();
function callColorTokenFunct(){
	//alert("test");
	var tot=document.getElementById("totCount").value;
	for(var i=0;i<tot;i++){
		makeTokenTable(i);
	}
setTimeout(callColorTokenFunct, 500);
}
 function changeColor(inc){
	  var audio = document.getElementById("audio");
      audio.play();
	    	    var elem =document.getElementById('blinkTokenNumberText'+inc);
	    	    var count = 1;
	    	    var intervalId = setInterval(function() {
	    	        if (elem.style.visibility == "hidden") {
	    	        	//alert("hidden");
	    	            elem.style.visibility = "visible";
	    	            if (count++ === 10) {
	    	                clearInterval(intervalId);
	    	            }
	    	        } else {
	    	            elem.style.visibility = "hidden";
	    	          //  alert("visible");
	    	        }    
	    	        elem.style.color = "blue";
	    	    }, 300);
	    	    elem.style.color = "black";
	    //	});
	    document.getElementById('tokenStatus'+inc).value="C";
 }

 function makeTokenTable(inc){
		var doctId=document.getElementById("doctId"+inc).value;  
		var deptIdDiv = document.getElementById("deptId"+inc);
		
		var deptId=document.getElementById("deptId"+inc).value;
		var NewtokenNo=document.getElementById('NewtokenNo'+inc).value;
		var tokenStatus=document.getElementById('tokenStatus'+inc).value;
		var tokenCount=document.getElementById('tokenCount'+inc).value;
		var OldtokenNo=document.getElementById('OldtokenNo'+inc).value;
		
		var waitingQueueRow = deptIdDiv.parentElement.parentElement;
		
		if(document.getElementById('blinkTokenNumberText'+inc).innerHTML>0){
			document.getElementById('OldtokenNo'+inc).value=document.getElementById('blinkTokenNumberText'+inc).innerHTML;
		}
		var OldtokenNo=document.getElementById('OldtokenNo'+inc).value;
	  	  var xmlHttp;
	  	  try {
	  	    // Firefox, Opera 8.0+, Safari
	  	    xmlHttp=new XMLHttpRequest();
	  	  }catch (e){
	  	    // Internet Explorer
	  	    try{
	  	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	  	    }catch (e){
	  	    	alert(e)
	  	      try{
	  	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	  	      }catch (e){
	  	        alert("Your browser does not support AJAX!");
	  	        return false;
	  	      }
	  	     }
	  	   }
	      xmlHttp.onreadystatechange=function()
	      {
	        if(xmlHttp.readyState==4){

	        	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

	  	  	for (loop = 0; loop < items.childNodes.length; loop++) {
	  	   	    var item = items.childNodes[loop];

	  	       var tokenNoItem  = item.getElementsByTagName("tokenNumber")[0];
	  	       var oldTokenItem  = item.getElementsByTagName("oldTokenNumber")[0];
	  	       var statusItem  = item.getElementsByTagName("tokenStatus")[0];
	  	   
	  	       if(oldTokenItem.childNodes[0]!=null){
	  	    	 var oldTokenNode=oldTokenItem.childNodes[0].nodeValue; 
	  	    	document.getElementById('OldtokenNo'+inc).value=oldTokenNode;
	  	       }
	  	     if(statusItem.childNodes[0]!=null){
	  	    	 var statusNode=statusItem.childNodes[0].nodeValue; 
	  	    	document.getElementById('tokenStatus'+inc).value=statusNode;
	  	       }
	  	       
	  	       if(tokenNoItem.childNodes[0]!=null){
	  	    	 
			  	   var tokeNo=tokenNoItem.childNodes[0].nodeValue;
			  	   document.getElementById('blinkTokenNumberText'+inc).innerHTML=tokeNo;			  	   
			  	 
			  	   document.getElementById('NewtokenNo'+inc).value=tokeNo;
			  	   
			  	  if(OldtokenNo!=tokeNo){
			  			 document.getElementById('tokenStatus'+inc).value="N";  
			  	   }
			  	   
			  	     if(tokenStatus=="N"){
			  	    	document.getElementById('tokenStatus'+inc).value="Y";
			  	  	 }	  	 
			  	 
				  	  if(tokenStatus=="Y"){
					  		changeColor(inc);
					  		//document.getElementById('tokenStatus'+inc).value="N";
					  }
			  	  

			  	    	  	  
	  	       }else{
	  	    	tokenCount=0;
	  	        var oldtokenNoItem  = item.getElementsByTagName("oldTokenNumber")[0];  <!-- added by amit das on 23-08-2017 for show last token no -->
	  	        var oldToken =  oldtokenNoItem.childNodes[0].nodeValue;  <!-- added by amit das on 23-08-2017 for show last token no -->
	  	      	if(oldToken!=null && oldToken!='null'){  <!-- added by amit das on 23-08-2017 for show last token no -->
	  	    	 document.getElementById('blinkTokenNumberText'+inc).innerHTML=oldToken;  <!-- added by amit das on 23-08-2017 for show last token no -->
	  	      	}  <!-- added by amit das on 23-08-2017 for show last token no -->
	  	      	
	  	       	if(document.getElementById('tokenStatus'+inc)!=null){
	  	    	document.getElementById('tokenStatus'+inc).value="N";
	  	       	}
	  	       	
	  	 		// waitingQueueRow.style.display = 'none';     // added by amit das on 16-06-2017
		  	       	
	  	       }
	  	    }
	        }
	      }
	   //if(csrfTokenValue!=null){
	     var url="/hms/hms/opd?method=getQueueListParticularDoctor&hospitalId="+<%=hospitalId%>+"&doctId="+doctId+"&deptId="
	    		 +deptId+"&NewtokenNo="+NewtokenNo+"&OldtokenNo="+OldtokenNo+"&tokenStatus="+tokenStatus;
	 	//url = url+'&'+csrfTokenName+'='+csrfTokenValue; 
	   //   }
	      xmlHttp.open("GET",url,true);
	      xmlHttp.setRequestHeader("Content-Type", "text/xml");
	      xmlHttp.send(null);
	  
 }
</script>