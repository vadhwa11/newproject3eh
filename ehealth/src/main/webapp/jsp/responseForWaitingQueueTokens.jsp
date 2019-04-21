<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.QueueManagmentDetails"%>
<%@page import="jkt.hms.masters.business.QueueManagment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

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
List<QueueManagment> currentqueueList = null;
List<QueueManagment> queueList = null;
Map map = new HashMap();
List<QueueManagmentDetails> queueManagmentDetaillist = new ArrayList<QueueManagmentDetails>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}

if (map.get("queueManagmentDetaillist") != null) {
	queueManagmentDetaillist = (List<QueueManagmentDetails>)map.get("queueManagmentDetaillist");
}

if (map.get("currentqueueList") != null) {
	currentqueueList = (List<QueueManagment>)map.get("currentqueueList");
}
int docId=0;
if (map.get("docId") != null) {
	docId = (Integer)map.get("docId");
}
Map<Integer,String> temList=new HashMap<Integer,String>();
Map<Integer,String> depList=new HashMap<Integer,String>();
%>

<table border="0" bordercolor="#FFCC00" style="background-color: #3399FF;" width="100%" cellpadding="" cellspacing="">
<tr>
<div class="banner-div-main">  
<section class="slider">
<div class="flexslider">
<ul class="slides">
<li>
<table width="30%" cellspacing="0" cellpadding="5" border="0" class="tokenDivmain">
  <tbody>
  <form name="token">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <tr>
      <th align="center">Department</th>
      <th align="center">Doctor</th>
      <th style="text-align:center !important;">Current Token</th>
    <!--   <th align="center">Next Token No.</th> -->
    
  <%--//changed by govind 9-12-2016  </tr>
    <% if(queueManagmentDetaillist!=null && queueManagmentDetaillist.size()>0) { 
		for(QueueManagmentDetails qManagmentDetails : queueManagmentDetaillist){
			currentqueueList = qManagmentDetails.getCurrentqueueList();
	    	queueList = qManagmentDetails.getQueueList();
	%>
    <tr>
      <td align="center"><%=qManagmentDetails.getDepartment().getDepartmentName()%></td>
      
      <% if(currentqueueList!=null && currentqueueList.size()!=0) {   	
      %>
     
     <%--  <td align="center">
      <% if(queueList!=null && queueList.size()!=0) {
      %>
      <span>
      <%=queueList.get(0).getTotalHospitalVisit()+"/"%><%=queueList.get(0).getTokenNo()%>
      </span>
      <% } %>
      </td> --%>
    <%--  <td align="center">
      <span style="color: #000 !important">
      <%=(currentqueueList.get(0).getDocotor()!=null)?(((currentqueueList.get(0).getDocotor().getFirstName()!=null)?currentqueueList.get(0).getDocotor().getFirstName():"")+((currentqueueList.get(0).getDocotor().getFirstName()!=null)?currentqueueList.get(0).getDocotor().getMiddleName():"")+((currentqueueList.get(0).getDocotor().getFirstName()!=null)?currentqueueList.get(0).getDocotor().getLastName():"")):""%>
      </span>
      </td>
      <td align="center">
      <span class="blinkTokenNumberText">
      <%-- <%=currentqueueList.get(0).getTotalHospitalVisit()+"/"%><%=currentqueueList.get(0).getTokenNo()%> --%>
      <!-- commented by amit das on 30-6-2016 -->
    <%--  <%=currentqueueList.get(0).getTokenNo()%> <!-- added by amit das on 30-6-2016 -->
      </span>
      </td> 
      
      <% } else { %>
      	<%-- <td align="center">
      	 <span class="blinkTokenNumberText">
      		<%=(queueList.size()>=2)?queueList.get(1).getTotalHospitalVisit()+"/":""%><%=(queueList.size()>=2)?queueList.get(1).getTokenNo():""%>
      	</span>
      	</td> --%>
      	
     <%-- <td align="center">
      <span style="color: #000 !important">
      <% if(queueList!=null && queueList.size()>0){ %>
      <%=(queueList.get(0).getDocotor()!=null)?(((queueList.get(0).getDocotor().getFirstName()!=null)?queueList.get(0).getDocotor().getFirstName():"")+((queueList.get(0).getDocotor().getFirstName()!=null)?queueList.get(0).getDocotor().getMiddleName():"")+((queueList.get(0).getDocotor().getFirstName()!=null)?queueList.get(0).getDocotor().getLastName():"")):""%>
      <% } %>
      </span>
      </td> 
      <td align="center">
       	<span style="color: #000;font-size: 3.0vw; !important">
      		<%-- <%=(queueList!=null && queueList.size()!=0 && queueList.get(0)!=null)?queueList.get(0).getTotalHospitalVisit()+"/":""%><%=(queueList!=null && queueList.size()!=0 && queueList.get(0)!=null)?queueList.get(0).getTokenNo():""%> --%>
      		<!-- commented by amit das on 30-6-2016 -->
     <%-- 		<%=(queueList!=null && queueList.size()!=0 && queueList.get(0)!=null)?queueList.get(0).getTokenNo():""--%>
      		 <!-- added by amit das on 30-6-2016 -->
    <%--   	</span>
      	</td>
      <% } %>
      
    </tr>
    <% } } %> --%>
    <% 
    if(currentqueueList!=null && currentqueueList.size()>0) { 
    	for(QueueManagment current:currentqueueList ){
    		
    		if(current.getDocotor()!=null && current.getDocotor().getFirstName()!=null){
    			temList.put(current.getDocotor().getId(), current.getDocotor().getFirstName());
    		}
    	}
    }
    	
    if(currentqueueList!=null && currentqueueList.size()>0) { 
for(QueueManagment current:currentqueueList ){
if(temList.containsKey(current.getDocotor().getId()) && temList.size()>0){
	
%>
    <tr>
     <td align="left"><%=current.getDepartment().getDepartmentName()%></td>
      <td align="left">
      <span style="color: #000 !important">
      <%=current.getDocotor().getFirstName()%>
      </span>
      </td>
       <td style="text-align:center !important;">
      <span class="blinkTokenNumberText">
      <%=current.getTokenNo()%> 
      </span>
      </td> 
</tr>
<%} temList.remove(current.getDocotor().getId());}} //changed by govind 9-12-2016 end
temList.clear();
%>

<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
  </tbody>
  </form>
</table>
</li>
<li>
<table width="30%" cellspacing="0" cellpadding="5" border="0" class="tokenDivmain">
  <tbody>
    <tr>
      <th align="center">Department</th>
      <th align="center">Doctor</th>
      <th style="text-align:center !important;">Current Token</th>
    <!--   <th align="center">Next Token No.</th> -->
    </tr>
  </tbody>

<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
</table>
<form name="token">
</form>
</li>
<li>
<table width="30%" cellspacing="0" cellpadding="5" border="0" class="tokenDivmain">
  <tbody>
    <tr>
      <th align="center">Department</th>
      <th align="center">Doctor</th>
      <th style="text-align:center !important;">Current Token</th>
    <!--   <th align="center">Next Token No.</th> -->
    </tr>
  </tbody>

<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
<tr><td>department</td><td>doctor</td><td>token</td></tr>
</table>
<form name="token">
</form>
</li>
</ul>
</div>
</section>
</div>
</tr>
</table>