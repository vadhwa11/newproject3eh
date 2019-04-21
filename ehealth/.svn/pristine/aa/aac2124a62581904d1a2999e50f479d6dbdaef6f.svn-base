<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.util.RequestConstants"%><script type="text/javascript" src="/hms/jsp/js/common.js"></script>
 

<%
	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String message ="";
	String messageType ="success";
	String balanceNo="";
	String balanceNoForPrint="";
	String adjustmentNo="";
	String poNumber="";
	Box box=null;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	
	if (map.get("box") != null) {
		box = (Box) map.get("box");
	}
	if(map.get("message") !=null){
		message=""+map.get("message");
	}
	if(map.get("messageType") !=null){
		messageType=""+map.get("messageType");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	String mlcType = "";
	if(map.get("mortuaryType") !=null){
		mlcType=""+map.get("mortuaryType");
	}
	int medicoLegalId = 0;
	if(map.get("medicoLegalId") !=null){
		medicoLegalId=(Integer)map.get("medicoLegalId");
	}
	String hinNo = "";
	if(map.get("hinNo") !=null){
		hinNo=(String)map.get("hinNo");
	}
	
	request.setAttribute("box",box);
%>

<div id="contentHolder">
<form name="message" method="post">
<div class="clear"></div>
<%

if(!message.equals(""))
	{
	if(messageType.equals("success")){
	%>
<h4><span><%=message %></span></h4>
<%}%> <%if(messageType.equals("failure")){%>


<h4><span><%=message %> </span></h4>

<%}}%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="mlcType" value="<%=mlcType%>" />
<input type="hidden" name="medicoLegalId" value="<%=medicoLegalId%>" />
<label><span>Do You Want to Print Report</span></label>

<input type="button" name="Back" value="Yes" class="cmnButton" onclick="submitForm('message','/hms/hms/mlc?method=generateReportofAccident');" />

<input type="button" value="no" class="button"	onClick="submitF orm('message','<%=url%>');" />

<!-- <label>Issue to patient</label>
<input type="checkbox" name="issueToPatient" id="issueToPatientId" value="y" /> -->

   <input type="button" name="add" id="addbutton" value="Wound Certficate" class="button"	onClick="submitForm('message','mlc?method=generateReportofAccidentWound&hinNo=<%=hinNo%>&medicoLegalId=<%=medicoLegalId %>');"	accesskey="r" tabindex=1 /> 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


</div>