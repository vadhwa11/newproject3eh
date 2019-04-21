<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp
 * Purpose of the JSP -  This is for ADT Message.
 * @author  Ritu
 * Create Date: 14th Jan,2008
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@ page isThreadSafe="false" %>
<%--   --%>

<%
String currentDate="";
String currentTime="";
Map<String, Object> dateAndTimeMap=HMSUtil.getCurrentDateAndTime();
currentDate=(String)dateAndTimeMap.get("currentDate");
currentTime=(String)dateAndTimeMap.get("currentTime");
List<MasChargeCode> chargeCodeList=new ArrayList<MasChargeCode>();
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String hinNo = "";
String adNo = "";
int currenVisitNo=0;
boolean successfullyAdded=false;
boolean successfullyVisitCreated = false;
boolean duplicateRegStatus=false;

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if (map.get("massageStatus") != null) {
	successfullyAdded = (Boolean) map.get("massageStatus");
	System.out.println("123#successfullyAdded "+successfullyAdded);
}
if(map.get("message") != null){
	message = (String)map.get("message");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if(map.get("successfullyVisitCreated") != null){
	successfullyVisitCreated = (Boolean)map.get("successfullyVisitCreated");
}


String billNo ="";
if(map.get("billNo") != null){
	billNo = (String)map.get("billNo");
}
String flag = "";
if(map.get("flag") != null){
	flag = (String)map.get("flag");
}
List<MasAuthorizer> authorizerList=new ArrayList<MasAuthorizer>();
if(map.get("authorizerList")!= null){
	authorizerList=(List<MasAuthorizer>)map.get("authorizerList");
}
if(map.get("chargeCodeList") != null)
{
	chargeCodeList = (List<MasChargeCode>)map.get("chargeCodeList");
}
if(map.get("duplicateRegStatus") != null){
	duplicateRegStatus = (Boolean)map.get("duplicateRegStatus");
}
String loginName = "";
Users user = new Users();
if (session.getAttribute("users") != null) {
	user = (Users) session.getAttribute("users");
	loginName = user.getLoginName();
}

String departmentList="";
ArrayList<String> serviceCentreList=new ArrayList<String>();
if(map.get("departmentId") != null){
	serviceCentreList =(ArrayList<String>)map.get("departmentId");
	if(null !=serviceCentreList && serviceCentreList.size()>0){
	for(String s:serviceCentreList){
		if(s!=null && !s.equals("")){
		departmentList=departmentList+","+s;
		}
	}
	}
}
int hinId=0;
int hospitalId=0;

if(map.get("hinId") != null){
	hinId =(Integer)map.get("hinId");
}
if(map.get("hospitalId") != null){
	hospitalId =(Integer)map.get("hospitalId");
}

if(map.get("hinNo") != null){
	hinNo =(String)map.get("hinNo");
}

String pname="";
if(map.get("pname") != null){
pname =(String) map.get("pname");
}
String mobileno="";
if(map.get("mobileno") != null){
mobileno =(String) map.get("mobileno");
}
%>
<%@page import="jkt.hms.masters.business.Users"%>
<form name="messageAdt" method="post">
<div class="Block">
<input type="hidden" name="departmentId" value="<%=departmentList %>">
<input type="hidden" name="pHinId" value="<%=hinId %>">
<input type="hidden" name="departmentId" value="<%=departmentList %>">
<input type="hidden" name="hospitalId" value="<%=hospitalId %>">

<input type="hidden" name="uhid" value="<%=hinNo %>" />
<input type="hidden" name="pname" value="<%=pname %>" />
<input type="hidden" name="mobileno" value="<%=mobileno %>" />
<div class="paddingTop15"></div>
<% 
if(!duplicateRegStatus){
%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<%	
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
		
		if(flag==null || !flag.equalsIgnoreCase("regFrmOthrSrc")) {
		if(map.get("currenVisitNo") != null){
			currenVisitNo = (Integer)map.get("currenVisitNo");}
		boolean showAnotherVisit=false;
%>
<jsp:include page="testImageUpload.jsp">
<jsp:param value="<%=hinNo %>" name="hinNo"/>
<jsp:param value="<%=hinId %>" name="hinId"/>
<jsp:param value="<%=showAnotherVisit %>" name="showAnotherVisit"/> 
</jsp:include>
<%
if(request.getParameter("quickRegistration")!=null && request.getParameter("quickRegistration").equalsIgnoreCase("yes")){
	%>
<input type="button" name="no" value="Visit" class="button"	onclick="submitForm('messageAdt','/hms/hms/registration?method=showQuickRegistrationJsp&quickVisit=yes&hinNo=<%=hinNo %>&hinId=<%=hinId %>','checkTargetForNo');" />

<%}else{ 
%>
<input type="button" name="no" value="Visit" class="button"	onclick="submitForm('messageAdt','/hms/hms/registration?method=showPatientVisitJsp&hinNo=<%=hinNo %>','checkTargetForNo');" />
<% }
} %>
<div class="clear"></div>
<div class="clear"></div>

<% 
if(successfullyAdded) 
{
	
%>
<h4><%=message %></h4>
<%} 
else{
%>

<h4>
<%=message %></h4>
<%} %>
</div>
<input type="hidden" name="hinNo" id="hinNo" value="<%=hinNo%>" />
<!-- added by amit das on 29-06-2016 -->
<% if(flag!=null && flag.equalsIgnoreCase("regFrmOthrSrc")) {
	if(map.get("successfullyAdded") != null){
		successfullyAdded = (Boolean)map.get("successfullyAdded");
	}
	if(successfullyAdded && successfullyVisitCreated){
%>

<input type="button" name="yes" value="Print Registration Card" class="button"	
onclick="submitFormForDirectPrint('messageAdt','/hms/hms/registration?method=printRegistrationCard&hinNo=<%=hinNo %>');" /> 
<input type="button" name="" class="button" 
value="Print Token" onclick="submitFormForDirectPrint('messageAdt','/hms/hms/registration?method=printTokenCard')"/>
<% } else if(successfullyAdded){ %>
<input type="button" name="yes" value="Print Registration Card" class="button"	
onclick="submitFormForDirectPrint('messageAdt','/hms/hms/registration?method=printRegistrationCard&hinNo=<%=hinNo %>');" /> 
<% }else if(successfullyVisitCreated) { %>
<input type="button" name="" class="button" 
value="Print Token" onclick="submitFormForDirectPrint('messageAdt','/hms/hms/registration?method=printTokenCard')"/>
<% }  }else{ %>
<input type="button" name="yes" value="Yes" class="button"	
onclick="submitFormForDirectPrint('messageAdt','/hms/hms/registration?method=printRegistrationCard&hinNo=<%=hinNo %>');" /> 
<%
if(request.getParameter("quickRegistration")!=null && request.getParameter("quickRegistration").equalsIgnoreCase("yes")){
	%>
<input type="button" name="no" value="No" class="button" onclick="submitForm('messageAdt','/hms/hms/registration?method=showQuickRegistrationJsp','checkTargetForNo');" />
<%}else{ %>
<input type="button" name="no" value="No" class="button" onclick="submitForm('messageAdt','/hms/hms/registration?method=showRegistrationJsp','checkTargetForNo');" />


<%} %>
 <%if(null !=serviceCentreList && serviceCentreList.size()>0){ %>
 <input type="button" name="" class="button" 
value="Print Token" onclick="submitFormForDirectPrint('messageAdt','/hms/hms/registration?method=printTokenCard')"/>

 <input type="button" name="Prescription" class="button" 
value="Print OP Card" onclick="submitFormForDirectPrint('messageAdt','/hms/hms/registration?method=printPrescriptionCard')"/>

<input type="button" name="Prescription" class="button" 
value="Print Card Header" onclick="submitFormForDirectPrint('messageAdt','/hms/hms/registration?method=printPrescriptionCard&header=true')"/>
 <%} %>

 <div class="clear"></div>

<div class="clear"></div>
<div class="Block">
<script type="text/javascript">
function displayAuthorizedText(obj){
	if(obj.checked){
	

	document.getElementById("refDoctorId").disabled = false;
	

	}else{
	document.getElementById("refDoctorId").disabled = true;
	document.getElementById('refDoctorId').value = "";

	}
	}
</script>
<div class="division"></div>

<div class="clear"></div>
<%-- <jsp:include page="testImageUpload.jsp">
<jsp:param value="<%=hinNo%>" name="hinNo"/>
</jsp:include> --%>
<div class="clear"></div>
<div class="division"></div>
	<!--<SCRIPT LANGUAGE="JavaScript">
	    var _info = navigator.userAgent;
	    var _ns = false;
	    var _ns6 = false;
	    var _ie = (_info.indexOf("MSIE") > 0 && _info.indexOf("Win") > 0 && _info.indexOf("Windows 3.1") < 0);
	//</SCRIPT> <COMMENT> <SCRIPT LANGUAGE="JavaScript1.1">
	        var _ns = (navigator.appName.indexOf("Netscape") >= 0 && ((_info.indexOf("Win") > 0 && _info.indexOf("Win16") < 0 && java.lang.System.getProperty("os.version").indexOf("3.5") < 0) || (_info.indexOf("Sun") > 0) || (_info.indexOf("Linux") > 0) || (_info.indexOf("AIX") > 0) || (_info.indexOf("OS/2") > 0)));
	        var _ns6 = ((_ns == true) && (_info.indexOf("Mozilla/5") >= 0));
	//</SCRIPT> </COMMENT>  Applet For Bill  <SCRIPT LANGUAGE="JavaScript">
	    if (_ie == true) document.writeln('<OBJECT classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93" WIDTH = "300" HEIGHT = "40"  codebase=../applets/jinstall-112-win32.cab#Version=1,1,2,0"><NOEMBED><XMP>');
	    else if (_ns == true && _ns6 == false) document.writeln('<EMBED type="application/x-java-applet;version=1.1.2" CODE = "PrinterApplet.class" CODEBASE = "../applets" ARCHIVE = "jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar" WIDTH = "300" HEIGHT = "40" REPORT_URL = "../servlets/jasperprint" scriptable=false pluginspage="http://java.sun.com/products/plugin/1.1.2/plugin-install.html"><NOEMBED><XMP>');
	//</SCRIPT> <APPLET id="appletId" name="appl" CODE="PrinterApplet.class"
		CODEBASE="../applets"
		ARCHIVE="jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar"
		WIDTH="257" HEIGHT="40"></XMP>
		<PARAM NAME=CODE VALUE="PrinterApplet.class">
		<PARAM NAME=CODEBASE VALUE="../applets">
		<PARAM NAME=ARCHIVE
			VALUE="jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar">
		<PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.2">
		<PARAM NAME="scriptable" VALUE="true">
		<PARAM NAME="REPORT_URL"
			VALUE="../servlets/jasperprint?billNo=<%=billNo %>&loginName=<%=loginName %>&billtype=servicing">
	</APPLET> </NOEMBED> </EMBED> </OBJECT>
-->
<%}   }
	if(map.get("adNo") != null)
	{
		adNo = (String)map.get("adNo");
%>
	<input type="button" name="yes" value="Yes" class="button"
	onclick="submitForm('messageAdt','/hms/hms/adt?method=showIPAdmissionReport&adNo=<%=adNo %>','checkTargetForYes');" />
	<input type="button" name="no" value="No" class="button"
	onclick="submitForm('messageAdt','/hms/hms/adt?method=showAdmissionJsp','checkTargetForNo');" />
<%}%>
<%
	if(formName != "")
{%>
<input type="button" value="Close" class="button" onclick="window.close()">
<%}
}
else{ %>
	<h4><%=message %></h4>
	<%
if(request.getParameter("quickRegistration")!=null && request.getParameter("quickRegistration").equalsIgnoreCase("yes")){
	%>
<input type="button" name="no" value="No" class="button" onclick="submitForm('messageAdt','/hms/hms/registration?method=showQuickRegistrationJsp','checkTargetForNo');" />
<%}else{ %>
<input type="button" name="no" value="No" class="button" onclick="submitForm('messageAdt','/hms/hms/registration?method=showRegistrationJsp','checkTargetForNo');" />


<%} %>
<% }
%>
<script type="text/javascript">
function openPopupWindow()
{
	var hinNo = document.getElementById('hinNo').value;
	var url="/hms/hms/registration?method=displayRegisPhoto&hinNo=<%=hinNo%>";
 	newwindow=window.open(url,'name',"left=100,top=100,height=400,width=350,status=1,scrollbars=1,resizable=0");
}

</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</div>
</form>
