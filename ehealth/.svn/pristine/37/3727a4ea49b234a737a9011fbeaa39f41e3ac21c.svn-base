<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<!-- 
Code for Logout after session Expired
Code By Mukesh Narayan Singh
Date 19 Aug 2010
 -->
<%-- <meta http-equiv="refresh" content="${pageContext.session.maxInactiveInterval};url=/hms/hms/login?method=logout" /> --%>

 <script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/dynamic-window-height/jquery.min.js"></script>
<script type="text/JavaScript" src="/hms/jsp/js/sortTable.js"></script>

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
</script>
</head>
<body onclick="parent_disable()">
<!-- <form name="header" method="post"> -->
<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

String userName ="";
if(session.getAttribute("userName")!=null){
userName = (String)session.getAttribute("userName");	
}

String currentDate = "";
DateFormat dateFormat = new SimpleDateFormat("EEEE d MMM yyyy HH:mm:ss");
Calendar cal = Calendar.getInstance();
currentDate = dateFormat.format(cal.getTime());
%>
<div id="header">
<div id="header-wrapper">
<div class="logo" title="e-Health Kerala"></div>
<div class="date-time-wrapper">
<%=currentDate %> 
</div>

<div class="login-wrapper">
<!-- <div class="new-user"><a href="#" onclick="submitForm('header','/hms/hms/login?method=showHomeJsp')" title="Registration of new user">Home</a></div>
<div class="ehealth-user"><a href="#" onclick="submitForm('header','/hms/hms/login?method=logout')" title="Login-eHealth User">Logout</a></div> -->
</div>

</div>
</div>
<!-- </form> -->
<div class="clear"></div>

<div class="clear"></div>
<div id="main">
<form name="loginForm" method="post" action="/hms/hms/login?method=validate" autocomplete="off">

<div id="login" >
<h2>Sign In <span>Fields marked with "<ins class="imp">*</ins>" are mandatory</span></h2>
<label class="login"> Username <span>*</span></label> 

<input id="loginName" type="text"
	name="<%=LOGIN_NAME%>" value="" validate='User Name,metachar,yes'
	maxlength="12" autocomplete="off"/> <script>
 document.loginForm.<%=LOGIN_NAME%>.focus();
 </script>

<%-- <input type="text" id="csfr" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> --%>

<label class="login">Password <span>*</span></label>

 <input type="password" id="password"
	name="<%=PASSWORD%>" value="" validate='Password,metachar,yes'
	onblur="hospitalList('loginForm')" maxlength="12" autocomplete="off" />
<div class="clear"></div>
<div id="defaultList" style="display: block;">
<label class="login">Institution <span>*</span></label>

<select name="hospitalName" id="hospital">
	<option value="0">Select</option>
</select>

<label class="login">Service Centre <span>*</span></label>

<select id="department"
	name="departmentName" tabindex=1>
	<option value="0">Select</option>
</select></div>
<div id="responseList" style="display: none;"></div>
<div class="clear"></div> 
<input name="Login2" type="button" value="Sign In" 	alt="Sign In" title="Sign In" class="button"
	onClick="openLoginDetailsPopup();" />
	
	<a href="#" title="forgot password">Forgot Password ?</a>
<div class="clear"></div>
<span id="errorMsg"></span> <%
					    if(map.get("error") != null){
					        String message = (String)map.get("error");
					%> <label id="loginMsg" style="display: block;"><%=message%></label>
<%}%>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


<div class="clear"></div>
<script type="text/javascript">
$(document).ready(function() {
	  function setHeight() {
	    windowHeight = $(window).innerHeight();
	    $('#main').css('min-height', 450);
	    //$('#main').css('min-height', windowHeight);
	  };
	  setHeight();
	  
	  $(window).resize(function() {
	    setHeight();
	  });
	});
</script>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="footer">
<!--<img src="/hms/jsp/images/HP- logo.png"	alt="HP" class="floatLeft" /> 
A Project By HP Powered By  <img src="/hms/jsp/images/jk-logo.jpg"	alt="JK Organisation" class="floatRight" />JKT<!-- <a href="#" target="_blank">
<img src="/hms/jsp/images/jkt-logo.jpg" class="floatRight" alt="JKT"	border="0" />-->
</a> <br /> <span>Disclaimer:This site is best viewed with a resolution of 1170 x 768 (or higher) and supports Microsoft IE9, Chrome 23, Firefox 16.<span class="ver">[ ver: 1.1.7 ]</span></span>
</div>
</body>
</html>

</div>
<script type="text/javascript">
var newwindow;
function parent_disable() {
if(newwindow && !newwindow.closed)
	newwindow.focus();
}
function openLoginDetailsPopup(){
	var loginName = document.getElementById('loginName').value;
	var hospitalId =document.getElementById('hospital').value;
	var departmentId =document.getElementById('department').value;
	if(loginName!='' &&  hospitalId!=0 && departmentId!=0){
	if(validateMetaCharacters(loginName) &&  validateMetaCharacters(hospitalId) &&  validateMetaCharacters(departmentId)){
		var url ="/hms/hms/login?method=validate&loginName="+loginName+"&password="+document.getElementById('password').value+"&hospital="+hospitalId+"&departmentId="+departmentId;
		newwindow=window.open(url,'name',"left=100,top=100,height=300,width=580,status=1,scrollbars=1,resizable=1");
	}
	}else{
		var msg = '';
		if(loginName==''){
			msg +="User Name cannot be blank.\n";
		}
		/* if(document.getElementById('password').value==''){
			msg +="Password cannot be blank.\n";
		} */
		if(hospitalId=='0'){
			msg +="Select Institution.\n";
		}
		if(departmentId=='0'){
			msg +="Select Department.\n";
		}
		if(msg!=''){
			alert(msg);
			return false;
		}
	}
	}

</script>
