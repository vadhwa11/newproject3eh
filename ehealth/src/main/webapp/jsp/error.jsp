<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="jkt.hms.util.RequestConstants"%>
<html>
<link href="../jsp/images/ico.ico" rel="shortcut icon">
	<title>eHealth Kerala</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache" />
<head>

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
</script>
	</head>
	<body onclick="parent_disable()">
		<div id="header">
			<div id="header-wrapper">
			</div>
		</div>
		<div></div>

		<div class="clear"></div>
		<div id="main">
			<form name="loginForm" method="post">
			<div id="error">
			<h1>
			<div class="clear"></div>
			<img src="${pageContext.request.contextPath}/images/error.png" width="23" height="23" align="top" style="margin:3px 5px;" /> 
			<div class="clear"></div>
			<ins class="imp"></ins>
			</h1>
			<h3 style="color:#ff0000; text-align:center; padding-top:10px;">Some Error Occurred  </h3>
			<h3 style="text-align:center;">Please <a href="<%=request.getContextPath()%>/" style="font-size:20px;">click here</a> to login and continue. </h3>
				<%-- 	<h3>1.	You have kept the browser window idle for a long time.</h3>
					<h3>2.	You may have logged in from another browser window.<br /></h3>
					<h3>3.	If the problem persists, please clear the temporary
						files from your browser and try again.</h3>
					<h3>4.	Please <a href="<%=request.getContextPath()%>/">click here</a> to login and continue. </h3> --%>

				</div>
			</form>
		</div>
		<div id="footer">

			</a> <br /> <span>Disclaimer:This site is best viewed with a
				resolution of 1170 x 768 (or higher) and supports Microsoft IE9,
				Chrome 23, Firefox 16.<span class="ver">[ ver: 1.1.5 ]</span>
			</span>

		</div>
	</body>
</html>
