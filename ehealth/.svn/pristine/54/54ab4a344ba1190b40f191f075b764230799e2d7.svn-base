
<%@ page import="java.util.*" %>

<script lang="javascript" src="/hms/jsp/js/csrfToken.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>

<%
String hinNo="";
if(request.getParameter("hinNo")!=null&& !request.getParameter("hinNo").equals("")){
	hinNo=request.getParameter("hinNo");
	session.setAttribute("patientHinNum", hinNo);
}
boolean showAnotherVisit=true;
if(request.getParameter("showAnotherVisit")!=null&& !request.getParameter("showAnotherVisit").equals("")){
	showAnotherVisit=Boolean.getBoolean(request.getParameter("showAnotherVisit"));
}
int hinId = 0;
if(request.getParameter("hinId")!=null&& !request.getParameter("hinId").equals("")){
	hinId=Integer.parseInt(request.getParameter("hinId"));
}

%>
	<!-- First, include the JPEGCam JavaScript Library -->
<!-- First, include the JPEGCam JavaScript Library -->
	<script type="text/javascript" src="/hms/jsp/webcam.js"></script>

	<!-- Configure a few settings -->
	<script language="JavaScript">
		 webcam.set_api_url( '/hms/jsp/uploadphoto.jsp?hinNo2=<%=hinNo%>' ); 
		
		/* webcam.set_api_url( '/hms/hms/registration?method=submitPatientInformation?' ); */
		
		webcam.set_quality( 90 ); // JPEG quality (1 - 100)
		webcam.set_shutter_sound( true ); // play shutter click sound
	</script>

	<!-- Next, write the movie to the page at 320x240 -->
	<script language="JavaScript">
		document.write( webcam.get_html(220, 160) );
	</script>
<div class="buttonDiv100">
<div class="clear"></div>
<div class="paddingTop5"></div>
	<!-- Some buttons for controlling things -->
	<form>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
		<input type=button value="Take Snapshot" onClick="take_snapshot()" class="button" />

		<input type=button value="Reset" class="button"  onClick="webcam.reset()">
		<%if(showAnotherVisit){ 
			if(request.getParameter("quickRegistration")!=null && request.getParameter("quickRegistration").equalsIgnoreCase("yes")){		
		%>
		<input type=button value="Another Visit" class="button"  onclick="submitForm('printToken','/hms/hms/registration?method=showQuickRegistrationJsp&quickVisit=yes&hinNo=<%=hinNo %>&hinId=<%=hinId %>');">
		
		<%}else{ %>
		<input type=button value="Another Visit" class="button"  onclick="submitForm('printToken','/hms/hms/registration?method=showPatientVisitJsp&hinNo=<%=hinNo %>');">
		<%}
			}%>
	</form>
	<div class="clear"></div>
	</div>
	<!-- Code to handle the server response (see test.php) -->
	<script language="JavaScript">
		webcam.set_hook( 'onComplete', 'my_completion_handler' );

		function take_snapshot() {
			
			// take snapshot and upload to server
			document.getElementById('upload_results').innerHTML = '';
			webcam.snap();
		}

		function my_completion_handler(msg) {
			// extract URL out of PHP output
			if (msg.match(/(http\:\/\/\S+)/)) {
				var image_url = RegExp.$1;
				// show JPEG image in page
				document.getElementById('upload_results').innerHTML ='';

				// reset camera for another shot
				webcam.reset();
			}
			//else alert("PHP Error: " + msg);
		}
	</script>

<div id="upload_results"></div>

<style>
.buttonDiv100{width:100%; text-align:center;}
.buttonDiv100 .button{padding: 0px 6px;}
</style>

