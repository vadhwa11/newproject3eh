<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.util.RequestConstants"%><script type="text/javascript" src="/hms/jsp/js/common.js"></script>
 

<%
	Map<String,Object> map = new HashMap<String,Object>();
	/* String url=""; */
	String msg ="";
	String messageType ="success";
	/* String balanceNo="";
	String balanceNoForPrint="";
	String adjustmentNo="";
	String poNumber=""; */
	Box box=null;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	
	if (map.get("box") != null) {
		box = (Box) map.get("box");
	}
	if(map.get("msg") !=null){
		msg=""+map.get("msg");
	}
	if(map.get("messageType") !=null){
		messageType=""+map.get("messageType");
	}
	/* if(map.get("url") !=null){
		url=""+map.get("url");
	}
	String mlcType = "";
	if(map.get("mortuaryType") !=null){
		mlcType=""+map.get("mortuaryType");
	}
	int medicoLegalDdetailsId = 0;
	if(map.get("medicoId") !=null){  
		medicoLegalDdetailsId=(Integer)map.get("medicoId");
	} */
	
	int mortuaryRegdDetailId = 0;
	if(map.get("mortuaryRegdDetailId") !=null){
		mortuaryRegdDetailId=(Integer)map.get("mortuaryRegdDetailId");
	}
	
	request.setAttribute("box",box);
%>

<div id="contentHolder">
<form name="message" method="post">
<div class="clear"></div>
<%

if(!msg.equals(""))
	{
	if(messageType.equals("success")){
	%>
<h4><span><%=msg %></span></h4>
<%}%> <%if(messageType.equals("failure")){%>


<h4><span><%=msg %> </span></h4>

<%}}%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="mortuaryRegdDetailId" id="mortuaryRegdDetailId" value="<%=mortuaryRegdDetailId%>" />

<input type="button"  value="Print Report" class="cmnButton" onclick="printReport();" />

<input type="button" value="Back" class="button"	onClick="getBackPage();" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>


<script>
function getBackPage(){
	
	window.location="/hms/hms/mlc?method=showPostmortemRegisteredDetails";
	
	
}

function printReport(){
	
	var mortuaryId=document.getElementById('mortuaryRegdDetailId').value;
	window.location="/hms/hms/mlc?method=generateReportPostmortemDetailesNote&mortuaryRegdDetailId="+mortuaryId;
	
}
</script>