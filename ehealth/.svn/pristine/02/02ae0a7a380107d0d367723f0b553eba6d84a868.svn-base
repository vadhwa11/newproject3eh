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
<h2>Fitness Certificate</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>UHID</label>
<input  type="text" name=hinNo id="hinNo" value="" />
<div class="clear"></div>
<input type="button" value="print" onclick="submitForm('fitness','/hms/hms/registration?method=printFitnessCertificate')" />
<input type="button" value="Reset" onclick="submitForm('fitness','/hms/hms/registration?method=showFitnessCertificatejsp')" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</div>
</form>
	