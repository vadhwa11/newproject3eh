<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}


%>

<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<form name="fitness" method="post">
<div class="titleBg">
<h2>Driving Certificate</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>UHID</label>
<input  type="text" name="hinNo" id="hinNo" value="" />
<div class="clear"></div>
<input type="button" value="PHYSICAL FITNESS" onclick="submitForm('fitness','/hms/hms/registration?method=drivingFitnessCertificate&flag=p')" />
<input type="button" value="MEDICAL CERTIFICATE" onclick="submitForm('fitness','/hms/hms/registration?method=drivingFitnessCertificate&flag=m')" />
<input type="button" value="VISUAL STANDARDS FOR DRIVING" onclick="submitForm('fitness','/hms/hms/registration?method=drivingFitnessCertificate&flag=v')" />
<input type="button" value="Reset" onclick="submitForm('fitness','/hms/hms/registration?method=showDrivingCertificatejsp')" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</div>
</form>
	