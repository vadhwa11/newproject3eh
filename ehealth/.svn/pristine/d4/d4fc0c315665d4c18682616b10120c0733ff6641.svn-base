<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<script src="/hms/jsp/js/dynamic-window-height/jquery.min.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/JavaScript" src="/hms/jsp/js/sortTable.js"></script>
<%-- 
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet"></script>
<%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %> --%>


<link href="../jsp/images/ico.ico" rel="shortcut icon">
	<title>eHealth Kerala</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache" />

	<%-- 	<meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <!-- ... --> --%>


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


/* window.onload = function() {
   	var formlist = document.getElementsByTagName("form");
   	if(formlist.length > 0)
   	{
   		 for(var i=0; i<formlist.length; i++)
   		{
   			//alert("<csrf:tokenname/>")
   			//alert("<csrf:tokenvalue />")
   			 var ele = document.createElement("input");
       		ele.setAttribute("name","${_csrf.parameterName}");
       		ele.setAttribute("type","hidden");
       		ele.setAttribute("value","${_csrf.token}");
       		
   			formlist[i].appendChild(ele); 
       	} 
    }
}  */
var displayCookieeName = '<%=RequestConstants.DISPLAY_NAME_COOKIEE%>';
window.onload = function(){
    var nameEQ = '<%=RequestConstants.DISPLAY_NAME_COOKIEE%>' + '=';
    
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0){ 
        	document.getElementById(displayCookieeName).value = c.substring(nameEQ.length,c.length);
        }	
    }
};

function showTokenDisplay(){
	displayCookieeName = document.getElementById(displayCookieeName).value;
	url = '/hms/hms/opd?method=showWaitingQueueTokenJsp&flag=open&displayName='+displayCookieeName;
	newwindow=window.open(url,"","status=no,scrollbars=no,resizable=yes,"+'height=' + screen.height + ',width=' + screen.width+"+fullscreen=yes");
   	newwindow.moveTo(1024,0);
	 
}

function showNewTokenDisplay(){
	displayCookieeName = document.getElementById(displayCookieeName).value;
	url = '/hms/hms/opd?method=showDrWiseWaitingQueueTokenJsp&flag=open&displayName='+displayCookieeName;
	newwindow=window.open(url,"","status=no,scrollbars=no,resizable=yes,"+'height=' + screen.height + ',width=' + screen.width+"+fullscreen=yes");
   	newwindow.moveTo(1024,0);
	 
}
</script>
	<%
		
	%>

	<script type="text/javascript"> 
// var csrfTokenName='<csrf:tokenname />';
// var csrfTokenValue='<csrf:tokenvalue />';
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';

</script>
	</head>
	<body onclick="parent_disable()">
		<!-- <form name="header" method="post"> -->
		<%
			String userName = "";
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			Map map = new HashMap();
			if (request.getAttribute("map") != null) {
				map = (Map) request.getAttribute("map");
			}

			String message = "";

			if (map.get("message") != null) {
				message = (String) map.get("message");
			}

			String currentDate = "";
			DateFormat dateFormat = new SimpleDateFormat("EEEE d MMM yyyy HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			currentDate = dateFormat.format(cal.getTime());
		%>

		<%
			if (!message.trim().equals("")) {
		%>
		<script type="text/javascript">
		setTimeout(function(){ window.location.href = window.location.href.substring(0, window.location.href.indexOf('hms')+'hms'.length); },1200);
	</script>
		<%
			}
		%>
<div id="header">
<div id="header-wrapper">
<div class="logo" title="e-Health Kerala"></div>
<div class="date-time-wrapper" style="margin-left:10px;"><%=currentDate%></div>
<div class="LoginTokenDisplay" onclick="showTokenDisplay();">Token Display</div>
<div class="LoginTokenDisplay" onclick="showNewTokenDisplay();">New Token Display</div>
</div>
</div>

<div class="clear"></div>
<div id="main">
<form name="loginForm" method="post" autocomplete="off">
<div id="login">
<h2>Sign In
<ins class="imp">
<%
out.print(message);
%>
</ins>
<span>Fields marked with "<ins class="imp">*</ins>" are mandatory</span>
</h2>

<label class="login"> Username <span>*</span></label>
<input id="loginName" type="text" name="<%=LOGIN_NAME%>" value="" validate='User Name,metachar,yes' maxlength="12" autocomplete="off" />

<script>
 document.loginForm.<%=LOGIN_NAME%>.focus();
 </script>

					<%-- <input type="text" id="csfr" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> --%>

					<label class="login">Password <span>*</span></label> <input
						type="password" id="password" name="<%=PASSWORD%>" value=""
						validate='Password,metachar,yes' onclick="checkUsername();"
						onblur="hospitalList('loginForm','${_csrf.parameterName}','${_csrf.token}')"
						maxlength="12" autocomplete="off" />
					<div class="clear"></div>

					<div id="defaultList" style="display: block;">
						<label class="login">Institution <span>*</span></label> <input
							type="hidden" name="departmentId" id="department" value="0" /> <input
							type="hidden" name="hospital" id="hospital" value="0" /> <select
							name="hospitalName" id="hospitalName">
							<option value="0">Select</option>
						</select>

						<!-- <input type="hidden" name="hospitalName" id="hospitalName" value="1"/>
<input type="hidden" name="departmentName" id="departmentName" value="24" /> -->
						<label class="login">Service Centre <span>*</span></label> <select
							id="departmentName" name="departmentName" tabindex=1>
							<option value="0">Select</option>
						</select>
					</div>
					<div id="responseList" style="display: none;"></div>
					<div class="clear"></div>
					<input name="Login2" type="button" value="Sign In" alt="Sign In"
						title="Sign In" class="button" onClick="getUserSessionDetails();" />
					<a href="#" title="forgot password">Forgot Password ?</a>
					<div class="clear"></div>
					<span id="errorMsg"></span>
					<%
						if (map.get("message") != null) {
							message = (String) map.get("message");
					%>
					<%-- <label id="loginMsg" style="display: block;"><%=message%></label> --%>
					<%
						}
					%>
				</div>
				<!-- <input name="Login2" type="submit" value="Sign In" 	alt="Sign In" title="Sign In" class="button"
	 />
	<input name="Login2" type="submit" value="Sign In" 	alt="Sign In" title="Sign In" class="button"
	 /> -->
				<div class="clear"></div>

				<%-- <input type="hidden" 
		name="${_csrf.parameterName}"
		value="${_csrf.token}" /> --%>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}">
					<input type="hidden" id="<%=RequestConstants.DISPLAY_NAME_COOKIEE%>" />
			</form>
		</div>

		<div class="clear"></div>
		<script type="text/javascript">
/* $(document).ready(function() {
	  function setHeight() {
	    windowHeight = $(window).innerHeight();
	    $('#main').css('min-height', 450);
	    //$('#main').css('min-height', windowHeight);
	  };
	  setHeight();
	  
	  $(window).resize(function() {
	    setHeight();
	  });
	}); */
</script>
		<div class="clear"></div>
		<div class="clear"></div>
		<div id="footer">
			<!--<img src="/hms/jsp/images/HP- logo.png"	alt="HP" class="floatLeft" /> 
A Project By HP Powered By  <img src="/hms/jsp/images/jk-logo.jpg"	alt="JK Organisation" class="floatRight" />JKT<!-- <a href="#" target="_blank">
<img src="/hms/jsp/images/jkt-logo.jpg" class="floatRight" alt="JKT"	border="0" />-->


			</a> <br /> <span>Disclaimer:This site is best viewed with a
				resolution of 1170 x 768 (or higher) and supports Microsoft IE9,
				Chrome 23, Firefox 16.<span class="ver">[ ver: 1.1.7 ]</span>
			</span>

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
	if(loginName!='' && hospitalId!=0 && departmentId!=0){
	if(validateMetaCharacters(loginName) &&  validateMetaCharacters(hospitalId) &&  validateMetaCharacters(departmentId)){
		//var url ="/hms/hms/login?method=validate&loginName="+loginName+"&hospital="+hospitalId+"&departmentId="+departmentId+'&<csrf:tokenname/>=<csrf:tokenvalue />';
		/* var url ="/hms/hms/login?method=validate&loginName="+loginName+"&hospital="+hospitalId+"&departmentId="+departmentId+"&"+csrfTokenName+"="+csrfTokenValue; */
		var url ="/hms/hms/login?method=validate&loginName="+loginName+"&hospital="+hospitalId+"&departmentId="+departmentId;
		newwindow=window.open(url,'name',"left=100,top=100,height=300,width=580,status=1,scrollbars=1,resizable=1");
	}
	}else{
		var msg = '';
		if(loginName==''){
			msg +="User Name cannot be blank.\n";
		}
		/* if(password==''){
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
	
	
function getUserSessionDetails()
{
		 var $ = jQuery.noConflict();
		 var loginName = document.getElementById('loginName').value;
		 var password = document.getElementById('password').value;
		var hospitalId =document.getElementById('hospital').value;
		var departmentId =document.getElementById('department').value;
	    var data = "loginName="+loginName+"&hospitalId="+hospitalId+"&departmentId="+departmentId+"&"+csrfTokenName+"="+csrfTokenValue;
	   // var url = "/hms/hms/login?method=validate1&'+csrfTokenName+'='+csrfTokenValue";
	   var url = "/hms/hms/login?method=validate1";
	    var dataType="json";
	   if(loginName!='' && hospitalId!=0 && departmentId!=0){
	    
	    jQuery(function ($) {
	  
	    	$.ajax({
				type:"POST",
				url: url,
				data: data,	
				dataType: "json",			
				cache: false,
				success: function(msg)
				{									 
					var jsonData = msg;						
					var totalMatches = jsonData.length;
					//alert(msg);
					
					
					 if(jsonData[0].Session == "yes")
						{
						
							if (confirm("You have logged in another location/Device Press OK to logout from another machine and continue with new session on this machine?") == true) {
							
								if(validateMetaCharacters(loginName) &&  validateMetaCharacters(hospitalId) &&  validateMetaCharacters(departmentId)){
									// var url ="/hms/hms/login?method=validate&loginName="+loginName+"&hospital="+hospitalId+"&departmentId="+departmentId+'&'+csrfTokenName+'='+csrfTokenValue;
									/* var url ="/hms/hms/login?method=validate&loginName="+loginName+"&hospital="+hospitalId+"&departmentId="+departmentId+"&"+csrfTokenName+"="+csrfTokenValue; */
									var url ="/hms/hms/login?method=validate&loginName="+loginName+"&hospital="+hospitalId+"&departmentId="+departmentId;
									 newwindow=window.open(url,'Login Details',"left=100,top=100,height=300,width=580,status=1,scrollbars=1,resizable=1");
									//commented by Amit Das on 07-04-2016
									//window.open(url,"_self"); //added by Amit Das on 07-04-2016
								} 
								
						        
						    } else {
						       // alert("You pressed Cancel!");
						        return;
						    }
						
						
							
						}
					 	else
						{
						if(loginName!='' && hospitalId!=0 && departmentId!=0){
							if(validateMetaCharacters(loginName) &&  validateMetaCharacters(hospitalId) &&  validateMetaCharacters(departmentId)){
								// var url ="/hms/hms/login?method=validate&loginName="+loginName+"&hospital="+hospitalId+"&departmentId="+departmentId+'&'+csrfTokenName+'='+csrfTokenValue;
								/* var url ="/hms/hms/login?method=validate&loginName="+loginName+"&hospital="+hospitalId+"&departmentId="+departmentId+"&"+csrfTokenName+"="+csrfTokenValue; */
								var url ="/hms/hms/login?method=validate&loginName="+loginName+"&hospital="+hospitalId+"&departmentId="+departmentId;
								 newwindow=window.open(url,'Login Details',"left=100,top=100,height=300,width=580,status=1,scrollbars=1,resizable=1");
								//commented by Amit Das on 07-04-2016
								//window.open(url,"_self"); //added by Amit Das on 07-04-2016
							}
						}else{
								
								var msg = '';
								if(loginName==''){
									msg +="User Name cannot be blank.\n";
								}
								 if(password==''){
									msg +="Password cannot be blank.\n";
								} 
								if(hospitalId=='0'){
									msg +="Select Institution.\n";
								}
								if(departmentId=='0'){
									msg +="Select Service Centre.\n";
								}
								if(msg!=''){
									alert(msg);
									return false;
								}
							}
						}
					
					
					
					
				},
				error: function(msg)
				{					
					
					alert("An error has occurred while contacting the server");
					
					
				}
				
				
			});
	    });   
	 
		
		
	   }else{
			
			var msg = '';
			if(loginName==''){
				msg +="User Name cannot be blank.\n";
			}
			 if(password==''){
				msg +="Password cannot be blank.\n";
			} 
			if(hospitalId=='0'){
				msg +="Select Institution.\n";
			}
			if(departmentId=='0'){
				msg +="Select Service Centre.\n";
			}
			if(msg!=''){
				alert(msg);
				return false;
			}
		}
	


	
	

}

</script>

	<script>
var session = '<%out.print(session.getAttribute("userId"));%>';

var message = '<%out.print(map.get("message"));%>';

		if (session == 'null' && message != 'null') {
			//alert(message);
		}

		function disableBack() {
			window.history.forward();
		}
		disableBack()
		window.inhibited_load = disableBack;
		window.onpageshow = function(evt) {
			if (evt.persisted)
				disableBack()
		}
		window.inhibited_unload = function() {
			void (0)
		}
	</script>