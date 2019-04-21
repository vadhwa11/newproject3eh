<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}


%>

<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<form name="deatthCert" method="post">
<div class="titleBg">
<h2>Death Certificate</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>UHID</label>
<input  type="text" name="uhid" id="uhId" value="" onblur="submitProtoAjaxWithDivName('deatthCert','/hms/hms/ipd?method=getIPDNoFortDeathCertificate','deathCertDiv')"   />
<div id="deathCertDiv"></div>

</div>
<div class="clear"></div>
<input type="button" value="print" onclick="submitForm('deatthCert','/hms/hms/mis?method=printBDCertificate&selectedRadio=death')" />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	