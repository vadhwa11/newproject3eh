

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>

<% 

	System.out.println("message jsp");
	Map<String,Object> map = new HashMap<String,Object>();
	int deptId=0;
	
	
	String url="";
	String indentNo="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	String printMessage="";
	Box box=null;
	String visitNo="";
	String serviceNo="";
	String hinNo="";
	String issueNo = "";
	int hospitalId=0;
	int visitId=0;

	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (map.get("box") != null) {
		box = (Box) map.get("box");
	}
	if(map.get("message")!=null){
		printMessage=map.get("message").toString();
	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		messageTOBeVisibleToTheUser=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("messageType") !=null){
		messageType=""+map.get("messageType");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	if(url==""){
		url="/hms/hms/billing?method=showPharmacySalesViewJsp";
	}
	if(map.get("indentNo") !=null){
		indentNo=""+map.get("indentNo");
	}
	if(map.get("deptId") !=null){
		deptId=(Integer)map.get("deptId");
	}
	request.setAttribute("box",box);
	
	
	if(map.get("visitNo")!=null){
		visitNo=map.get("visitNo").toString();
	}

	if(map.get("hinNo")!=null){
		hinNo=map.get("hinNo").toString();
	}else{
		hinNo=request.getParameter("hinNo");
	}
	if(map.get("visitId")!=null){
		visitId=(Integer)map.get("visitId");
	}
	
	
	// Added by Amit Das on 19-02-2016
	if(map.get("issueNo")!=null){
		issueNo=map.get("issueNo").toString();
	}
	String doctorNameforphmcy="";
	if(map.get("doctorNameforphmcy")!=null){
		doctorNameforphmcy=map.get("doctorNameforphmcy").toString();
	}
	int opdDetailsId=0;
	if(map.get("hospitalId")!=null){
		hospitalId=(Integer)map.get("hospitalId");
	}
	if(map.get("opdDetailsId")!=null){
		opdDetailsId=(Integer)map.get("opdDetailsId");
	}
	
	
	String printUrl = "/hms/hms/stores?method=printPricriptionIssue&visitNo="+visitNo+"&hinNo="+hinNo+"&hospitalId="+hospitalId+"&issueNo="+issueNo+"&visitId="+visitId+"&doctorName="+doctorNameforphmcy+"&opdDetailsId="+opdDetailsId+"&flag=1" ;	
	String printUrlHtml= "/hms/hms/stores?method=printPricriptionIssue&visitNo="+visitNo+"&hinNo="+hinNo+"&hospitalId="+hospitalId+"&issueNo="+issueNo+"&visitId="+visitId+"&doctorName="+doctorNameforphmcy+"&opdDetailsId="+opdDetailsId+"&flag=2" ;	
	
%>
<form name="message" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>
<%=printMessage%> 
</h4> 
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<input type="button" value="Print Prescription" class="buttonBig" onClick="checkTargetForYes();submitFormForDirectPrint('message','<%=printUrl %>');checkTargetForNo();" />
<%--//Note: Revert the changes for story NO :37 
<input type="button" value="Print Prescription HTML" class="buttonBig" onClick="checkTargetForYes();submitFormForDirectPrint('message','<%=printUrlHtml%>');checkTargetForNo();" />
 --%>
<input type="button" value="Back" class="button" onClick="submitForm('message','<%=url%>');checkTargetForNo();" />
<!--<input type="button" value="Export To Excel" name="exportExcel" class="buttonBig" onClick="submitForm('message','/hms/hms/stores?method=generateExcelForDepot1');"  />
-->
<input type="hidden" name="indentNo" id="indentNo" value="<%=indentNo%>">
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
</form>

