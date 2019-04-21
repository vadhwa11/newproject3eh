 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.login.controller.CalculatorApplication"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-store" />
<link href="../jsp/images/ico.ico" rel="shortcut icon" />
<title>eHealth Kerala</title>
<script src="/hms/jsp/js/dynamic-window-height/jquery.min.js?n=1"></script>
<link href="/hms/jsp/css/style.css?n=1" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js?n=1"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js?n=1"></script>
	
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/calculator.js"></script> -->

<%@page import="jkt.hms.masters.business.MasHospital"%>
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet"> 
</script>   --%>
<script type="text/javascript"> 
// var csrfTokenName='<csrf:tokenname />';
// var csrfTokenValue='<csrf:tokenvalue />';
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';

</script>
<script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script>
<%

  if(session.getAttribute("userId") == null)
  {
	 response.sendRedirect("/hms/hms/login?method=logout");
  }

%>

<!-- script for fixed header table starts -->


<!--[if IE]>
<style type="text/css">
/* IE Specific Style addition to constrain table from automatically growing in height */
div.TableContainer {
 height: auto; 
 overflow-x:hidden;
 overflow-y:auto;
}
</style>
<![endif]-->

<script type="text/JavaScript" src="/hms/jsp/js/sortTable.js?n=1"></script>
<script>
// Function to scroll to top before sorting to fix an IE bug
// Which repositions the header off the top of the screen
// if you try to sort while scrolled to bottom.
function GoTop() {
 document.getElementById('TableContainer').scrollTop = 0;
}

// For those browsers that fully support the CSS :hover pseudo class the "table.scrollTable tr:hover" definition above 
// will work fine, but Internet Explorer 6 only supports "hover" for "<a>" tag elements, so we need to use the following 
// JavaScript to mimic support (at least until IE7 comes out, which does support "hover" for all elements)

// Create a JavaScript function that dynamically assigns mouseover and mouseout events to all 
// rows in a table which is assigned the "scrollTable" class name,  in order to simulate a "hover" 
// effect on each of the tables rows
HoverRow = function() {

 // If an IE browser
 if (document.all) {
  var table_rows = 0;
	
  // Find the table that uses the "scrollTable" classname
  var allTableTags=document.getElementsByTagName("table"); 
  for (i=0; i<allTableTags.length; i++) { 
   // If this table uses the "scrollTable" class then get a reference to its body and first row
   if (allTableTags[i].className=="scrollTable") { 
    table_body = allTableTags[i].getElementsByTagName("tbody");
    table_rows = table_body[0].getElementsByTagName("tr");
    i = allTableTags.length + 1; // Force an exit from the loop - only interested in first table match
   } 
  } 

  // For each row add a onmouseover and onmouseout event that adds, then remove the "hoverMe" class
  // (but leaving untouched all other class assignments) to the row in order to simulate a "hover"
  // effect on the entire row
  for (var i=0; i<table_rows.length; i++) {
   // ignore rows with the title and total class assigned to them
   if (table_rows[i].className != "title" && table_rows[i].className != "total") {
    table_rows[i].onmouseover=function() {this.className += " hoverMe";}
    table_rows[i].onmouseout=function() {this.className=this.className.replace(new RegExp(" hoverMe\\b"), "");}
   }
  } // End of for loop
  
 } // End of "If an IE browser"

}
// If this browser suports attaching events (IE) then make the HoverRow function run on page load
// Hote: HoverRow has to be re-run each time the table gets sorted
if (window.attachEvent) window.attachEvent("onload", HoverRow);

function ajaxFunctionForShowCalculator() 
{
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
   window.open('/hms/hms/login?method=showCalculator'+'&'+csrfTokenName+'='+csrfTokenValue,'mywindow','target="_blank", width=275,height=200');;
   <%-- var url="/hms/hms/login?method=showCalculator";
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      
      	
      
    }
  } --%>
}
</script>

<!-- script for fixed header table ends -->
<script type="text/javascript">

function disableKey(event) {

  if (!event) event = window.event;

  if (!event) return;


  var keyCode = event.keyCode ? event.keyCode : event.charCode;


  //window.status = keyCode;

  // keyCode for F% on Opera is 57349 ?!



  if (keyCode == 116) {

   window.status = "F5 key detected! Attempting to disabling default response.";

   window.setTimeout("window.status='';", 2000);

   // Standard DOM (Mozilla):

   if (event.preventDefault) event.preventDefault();

   //IE (exclude Opera with !event.preventDefault):

   if (document.all && window.event && !event.preventDefault) {

     event.cancelBubble = true;

     event.returnValue = false;

     event.keyCode = 0;

   }

   return false;

  }

}

 

document.onkeydown = disableKey; // register listener function  



var message="Function Disabled!";

///////////////////////////////////
function clickIE4(){
if (event.button==2){
alert(message);
return false;
}
}

function clickNS4(e){
if (document.layers||document.getElementById&&!document.all){
if (e.which==2||e.which==3){
alert(message);
return false;
}
}
}

if (document.layers){
document.captureEvents(Event.MOUSEDOWN);
document.onmousedown=clickNS4;
}
else if (document.all&&!document.getElementById){
document.onmousedown=clickIE4;
}

document.oncontextmenu=new Function("alert(message);return false")
</script>

</head>
<!-- <body onbeforeunload="submitForm('header','/hms/hms/login?method=logout')"> -->
<body>
<%-- <div id="body">
<form name="header" method="post"><!--header Starts-->
<div class="header">
<!--
<div style="color:#058CBC; font:bold 15px/30px arial;float:left;line-height:38px; padding-left:5px;text-decoration:underline;">XYZ Hospital</div>
--> <!---for header text--->
<div class="hdText">
<img src="/hms/jsp/images/careIsLogo.gif" class="floatRight" alt="careIs Logo" />

<div class="hdTextFix">&nbsp; <%	 String noticeData = "";
String userName ="";
if(session.getAttribute("notice")!=null){
	  noticeData = session.getAttribute("notice").toString(); 
}
if(session.getAttribute("userName")!=null){
userName = (String)session.getAttribute("userName");	
}
String branchName = "";
//if(session.getAttribute("branchName")!=null){
	//branchName = (String)session.getAttribute("branchName");	
	//}
if(session.getAttribute("userName")!=null){
	userName = (String)session.getAttribute("userName");	
	}
String deptName ="";
if(session.getAttribute("deptName")!=null){
	deptName = (String)session.getAttribute("deptName");	
%> <%=userName%> | Dept: <%=deptName%>
<%if(session.getAttribute("branchName")!=null && session.getAttribute("branchName")!= "" ){
	branchName = (String)session.getAttribute("branchName");	
	%>
 | Branch:<%=branchName %> <%}} %>
</div>
<span class="paddLeft30">

<script type="text/javascript">

function getNoticeData(){
//alert("hi");
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
    	if(xmlHttp.readyState==4)
    	{
    	  
    		var notice =xmlHttp.responseXML.getElementsByTagName('notice')[0];
    		 var desc  = notice.getElementsByTagName("desc")[0];
    		
    		
    		//alert("notice value::::"+desc.childNodes[0].nodeValue);
    		if(desc.childNodes[0].nodeValue!='nodesc'){
    			document.getElementById('noticeLabel').value = desc.childNodes[0].nodeValue;
    		}else{
    			document.getElementById('noticeLabel').value = '';
    		}
    		//document.getElementById('noticeLabel').value = desc.childNodes[0].nodeValue; 
	 		//document.getElementById("noticeDiv").innerHTML = '<marquee>'+noticeData+'</marquee>' ;
	 		  
	 	}
    }
	//alert('hello');
   	 var url='/hms/hms/login?method=getNoticeData';
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
}


/*
var currentDate = new Date()
var day = currentDate.getDate()
var month = currentDate.getMonth()
var year = currentDate.getFullYear()
document.write(day + "/" + month + "/" + year)	
*/
function getCalendarDate()
{
var months = new Array(13);
months[0]  = "January";
months[1]  = "February";
months[2]  = "March";
months[3]  = "April";
months[4]  = "May";
months[5]  = "June";
months[6]  = "July";
months[7]  = "August";
months[8]  = "September";
months[9]  = "October";
months[10] = "November";
months[11] = "December";

<%

String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
	          "August", "September", "October", "November",
	          "December"};

Calendar now = Calendar.getInstance();

int currentDays=now.get(Calendar.DATE);
String currentMonth=monthName[now.get(Calendar.MONTH)];
int currentYear=now.get(Calendar.YEAR);
%>
var monthname   = '<%=currentMonth%>';
var monthday    = '<%=currentDays%>';
var year        = '<%=currentYear%>';
<%--
var now         = new Date();
var monthnumber = now.getMonth();
var monthname   = months[monthnumber];
var monthday    = now.getDate();
var year        = now.getYear(); --%>


 <%-- 
if(year < 2000) { year = year + 1900; }
var dateString = monthname + ' ' + monthday + ', ' + year;
return dateString;
}						

var calendarDate = getCalendarDate();
document.write(calendarDate);	
</script> </span> <span class="paddLeft30"> <%
Calendar calendar = new GregorianCalendar();
String suffix;
int hour = calendar.get(Calendar.HOUR);
int minute = calendar.get(Calendar.MINUTE);
if(calendar.get(Calendar.AM_PM) == 0)
	suffix = "AM";
else
	suffix = "PM";


%> <script type="text/javascript">
<%-- var currentTime = new Date()
var hours = currentTime.getHours()
var minutes = currentTime.getMinutes()

if (minutes < 10)
minutes = "0" + minutes

var suffix = "AM";
if (hours >= 12) {
suffix = "PM";
hours = hours - 12;
}
if (hours == 0) {
hours = 12;
} --%>
<%-- 
document.write('<%=hour%>' + ":" + '<%=minute%>' + " " + '<%=suffix%>')
//-->
</script> </span> <span class="paddLeft30"> <%
if(!userName.equals("")){
%> <a href="/hms/hms/login?method=showHomeJsp">Home</a> |<%} %> 
</span> 
<a	href="javascript:openPopUpForTele()">Contact</a>
<%
if(!userName.equals("")){
%> | <a href="javascript:openPopUp()">Communication</a>
<%} %>

 <%
if(!userName.equals("")){
%> | <a href="#" name="logout"
	onclick="submitForm('header','/hms/hms/login?method=logout')">Logout</a>
<%} %>

<script>
function openPopUp()
		{
				window.open('/hms/hms/hes?method=showCommunicationJsp','mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300');

		}

function openPopUpForTele(){
//submitForm('header','')
window.open('/hms/hms/login?method=getTelephoneDirectory','mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=1100,height=2300');
}
</script>

</div>
<!---header text ends--->

<div>
<!-- <img height="58" width="64" alt="Rog Kalyan Samiti" class="floatRight" src="/hms/jsp/images/rks.gif" />
<img height="52" width="351" alt="SVBCH Logo" class="floatLeft" src="/hms/jsp/images/logo.gif" /> -->
<div class="clear"></div>
<div  class="floatLeft" >
<!-- <a class="hLink" href="javascript:openPopUpForTele()" class="floatLeft">Telephone Directory</a> -->
</div>


</div>
<%if(session.getAttribute("masHospital")!=null){ %>
<!--  <div class="hName"><%=((MasHospital)session.getAttribute("masHospital")).getHospitalName() %>
</div>-->
<%}%> <!-- 
<input type="button" value="Calculator" name="Button" onclick="ajaxFunctionForShowCalculator();"/>
 -->
<div class="clear"></div>
<input type="hidden" id="notice" name="notice" value="" />
<div>
<!-- <a class="hLink" onclick="ajaxFunctionForShowCalculator();" class="floatRight">Calculator</a> -->
<marquee direction="left">
<input type="text" readonly="readonly" id="noticeLabel" value="<%=noticeData %>" style="width: 1000px;" /></marquee>

</div>
</div>

<!--header Ends-->
<div class="clear"></div>
<script type="text/javascript">
	window.setInterval('getNoticeData()',5000000);
</script>

</form>--%>
<%
String userName ="";
if(session.getAttribute("userName")!=null){
userName = (String)session.getAttribute("userName");	
}
String empName ="";
if(session.getAttribute("empName")!=null){
	empName = (String)session.getAttribute("empName");	
}
String hospitalName ="";
if(session.getAttribute("hospitalName")!=null){
	hospitalName = (String)session.getAttribute("hospitalName");	
}
String deptName ="";
if(session.getAttribute("deptName")!=null){
	deptName = (String)session.getAttribute("deptName");	
}
int empId = 0;
if(session.getAttribute("empId")!=null){
	empId = (Integer)session.getAttribute("empId");	
}

String currentDate = "";
DateFormat dateFormat = new SimpleDateFormat("EEEE d MMM yyyy HH:mm:ss");
Calendar cal = Calendar.getInstance();
currentDate = dateFormat.format(cal.getTime());



Map<String,Object> deptmap = new HashMap<String,Object>();
if (request.getAttribute("map") != null) 
{
	deptmap = (Map) request.getAttribute("map");
}
List<MasDepartment> deptList = new ArrayList<MasDepartment>();
if (deptmap.get("deptList")!=null)
	deptList  = (List)deptmap.get("deptList");
else if(session.getAttribute("deptList")!=null){
	deptList  = (List)session.getAttribute("deptList");
}


%>
<form name="header" method="post">

<div id="header">
<div id="header-wrapper">
<div class="logo" title="e-Health Kerala"></div>

<%
if(!userName.equals("")){
%>

<div class="login-wrapper">
<%
   if(session.getAttribute("empanelledId") != null)
   {
	   %>
<div class="new-user"><%=session.getAttribute("storesName")%></div>		
<div class="ehealth-user"><a href="#" onclick="checkForDoctorWaitingPatients('logoutOtherUser');" title="logout" class="logout-icon"></a></div>
<%
   }
   else
   {
	   %>
<div class="new-user">
<p>
<%=empName%> 
<br/>
<span id="deptDiv"><%=deptName%></span>
</p>
</div>
			
<div class="ehealth-user">
<a href="#" onclick="submitForm('header','/hms/hms/login?method=showHomeJsp')" title="Home" class="home-icon"></a>
<a href="#" onclick="checkForDoctorWaitingPatients('logout');" title="logout" class="logout-icon"></a>
</div>
<%
}
  
%>
<input type="hidden" value="<%=deptName%>" id="deptNameHdId" class="readOnly" readonly size="30" validate="deptName,metachar,no"/>

<%} %>
</div>

<div class="headerCenterDiv">
<div class="date-time-wrapper"><%=currentDate %></div>
<div class="departmentDivMain"><p><%=hospitalName %></p></div>

<div class="changePasswordMain">
<div class="changePLeftDiv">Change Service Center</div>
<select name="ward" id="wardHdId">
	<option value="">--Select --</option>
		<%
		for (MasDepartment dept : deptList) 
		{
				if(deptName.equals(dept.getDepartmentName())){
		%>
	<option value="<%=dept.getId()%>" selected="selected"><%=dept.getDepartmentName()%></option>
	<%}else{%>
		<option value="<%=dept.getId()%>"><%=dept.getDepartmentName()%></option>
	<%}
		}
		%>
</select>
<input name="ok" class="okButton" value="OK" tabindex="2" type="button"  onclick="checkForDoctorWaitingPatients('departmentChange');"/>
</div>
</div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</div>
</div>

</form>

<script>

function changeServiceCentre()
{
var obj = document.getElementById("wardHdId");

var dept = document.getElementById("deptNameHdId").value;


if (obj.value=="")
{
	alert("Pl. Select the Department to be Changed!.....");
	return false;
}


var val = obj.value;

var deptName = "";
for(i=0;i<obj.length;i++)
{
 	if (obj.options[i].value==val)
 	{
 	deptName = obj.options[i].text;
 	break;
 	}
}
//document.header.method="post";
if(val == ""){
	deptName = dept;
}

var url = "superAdmin?method=changeWardInSession&ward="+val+"&deptName="+deptName+"&flag=fromHeader";


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
     	if(items.childNodes.length!=0){
     	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var information = items.childNodes[loop];
	        var message  = information.getElementsByTagName("message")[0];
	        var dept  = information.getElementsByTagName("departmentName")[0];
	        var deptId  = information.getElementsByTagName("departmentId")[0];
	        document.getElementById('deptDiv').innerHTML=dept.childNodes[0].nodeValue;
	        document.getElementById('deptNameHdId').value = dept.childNodes[0].nodeValue;
	        alert(message.childNodes[0].nodeValue);
	        if(document.getElementById('deptNameId')){
	        	document.getElementById('deptNameId').value = dept.childNodes[0].nodeValue;
	        }
	        if(document.getElementById('wardId')){
	        	document.getElementById('wardId').value = deptId.childNodes[0].nodeValue;
	        }
	        
	        }
	        }

	}
}

 url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

   xmlHttp.open("GET",url,true);
   xmlHttp.setRequestHeader("Content-Type", "text/xml");
   xmlHttp.send(null);


}

function checkForDoctorWaitingPatients(action){
	var url = "registration?method=checkForDoctorWaitingPatients";
    
 	jQuery(function ($) {
    	$.ajax({
			type:"POST",
			url: url+'&'+csrfTokenName+'='+csrfTokenValue,
			cache: false,
			success: function(msg){									 
				if(parseInt(msg)>0){
						if(confirm("All the patients will be transferred to common pool and session will be terminated , Do you want to continue ?")){
							url = 'opd?method=transferToCommonPool&employeeId=<%=empId%>';
						    jQuery(function ($) {
						    	$.ajax({
									type:"POST",
									url: url+'&'+csrfTokenName+'='+csrfTokenValue,
									cache: false,
									success: function(msg){									 
										if(msg.indexOf("success") != -1){
													alert("Successfully transferred all patients to Common Pool !");
													performAction(action);
														
									}else{
												alert("Transfer can not be done for these patients !");
												performAction(action);
									}
									},
									error: function(msg)
									{					
										alert("An error has occurred while contacting the server");
										
									}
									
									});
						    });  
								
						}else{
							performAction(action);
						}
				}else{
					performAction(action);
				}
			},
			error: function(msg)
			{					
				alert("An error has occurred while contacting the server");
				
			}
			
			});
    });   

}

function performAction(action){
	if(action=='logout'){
		submitForm('header','/hms/hms/login?method=logout');
	}else if(action=='logoutOtherUser'){
		submitForm('header','/hms/hms/login?method=logoutOtherUser')
	}else{
		changeServiceCentre();
	}
}

</script>