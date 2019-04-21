<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@ page isThreadSafe="false" %>
<%--  --%>


<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">

function getTokenInfo(){
	
}
</script>
<%
Map<String,Object> map=null;
map=new HashMap<String,Object>();
String message = "";
int hospitalId=0;
String[] departmentId=null;
int hinId=0;
String hinNo="";

boolean duplicateVisitSatatus=false;

if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
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
if(map.get("hinId") != null){
	hinId =(Integer)map.get("hinId");
}
if(map.get("hospitalId") != null){
	hospitalId =(Integer)map.get("hospitalId");
}

if(map.get("hinNo") != null){
	hinNo =(String)map.get("hinNo");
}

if(map.get("duplicateVisitSatatus") != null){
	duplicateVisitSatatus =(Boolean)map.get("duplicateVisitSatatus");
}

int opsessionId=0;
if(map.get("opsessionId") != null){
	opsessionId =(Integer)map.get("opsessionId");
}

String uhid=null;
if(map.get("hinNo") != null){
	uhid =(String) map.get("hinNo");
}

String pname=null;
if(map.get("pname") != null){
	pname =(String) map.get("pname");
}

String ages=null;
if(map.get("ages") != null){
	ages =(String) map.get("ages");
}

String gender=null;
if(map.get("gender") != null){
	gender =(String) map.get("gender");
}

String mobileno=null;
if(map.get("mobileno") != null){
	mobileno =(String) map.get("mobileno");
}

%>
<div class="Block">
<h4><%=message %></h4>
</div>
<div class="clear"></div>
<form name="printToken"  method="post">

<input type="hidden" name="pHinId" value="<%=hinId %>" id="pHinId">
<input type="hidden" name="departmentId" value="<%=departmentList %>" id="departmentId">
<input type="hidden" name="hospitalId" value="<%=hospitalId %>">
<input type="hidden" name="opsessionId" value="<%=opsessionId %>">
<input type="hidden" name="uhid" value="<%=uhid %>" />
<input type="hidden" name="pname" value="<%=pname %>" />
<input type="hidden" name="ages" value="<%=ages %>" />
<input type="hidden" name="gender" value="<%=gender %>" />
<input type="hidden" name="mobileno" value="<%=mobileno %>" />
<%if(!duplicateVisitSatatus){ %>
<!-- <input type="button" name="" class="button" 
value="Yes" onclick="submitForm('printToken','/hms/hms/registration?method=printTokenCard')"/> -->
<!-- Commented by Amit Das on 19-05-2016 -->
<!-- applet tag added by amit das on 19-05-2016 -->
<%-- <APPLET name="appl" CODE="PrinterApplet.class" CODEBASE="../applets"
	ARCHIVE="jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar"
	WIDTH="257" HEIGHT="40"></XMP>
	<PARAM NAME=CODE VALUE="PrinterApplet.class">
	<PARAM NAME=CODEBASE VALUE="../applets">
	<PARAM NAME=ARCHIVE
		VALUE="jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar">
	<PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.2">
	<PARAM NAME="scriptable" VALUE="true">
	<PARAM NAME="REPORT_URL"
		VALUE="../servlets/jasperprint?pHinId=<%=hinId %>&hospitalId=<%=hospitalId %>&report=Patient_Token_Card">
</APPLET> --%>
<!-- Commented applet code by Amit Das on 29-06-2016 -->
<!-- added by amit das on 29-06-2016 -->
<input type="button" name="" class="button" 
value="Yes" onclick="submitFormForDirectPrint('printToken','/hms/hms/registration?method=printTokenCard')"/>
<%
if(request.getParameter("quickRegistration")!=null && request.getParameter("quickRegistration").equalsIgnoreCase("yes")){
	%>
<input type="button" name="no" value="No" class="button" onclick="submitForm('printToken','/hms/hms/registration?method=showQuickRegistrationJsp&quickVisit=yes')" />
<%}else{ %>
<input type="button" name="no" value="No" class="button" onclick="submitForm('printToken','/hms/hms/registration?method=showPatientVisitJsp')" />
<%} %>
<input type="button" name="Prescription" class="button" 
value="Print OP Card" onclick="submitFormForDirectPrint('printToken','/hms/hms/registration?method=printPrescriptionCard')"/>
<input type="button" name="Prescription" class="button" 
value="Print Card Header" onclick="submitFormForDirectPrint('printToken','/hms/hms/registration?method=printPrescriptionCard&header=true')"/>
<div class="Block">

<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<jsp:include page="testImageUpload.jsp">
<jsp:param value="<%=hinNo %>" name="hinNo"/> 
<jsp:param value="<%=hinId %>" name="hinId"/>
</jsp:include>
<%}else{ %>
<%
if(request.getParameter("quickRegistration")!=null && request.getParameter("quickRegistration").equalsIgnoreCase("yes")){
	%>
<input type="button" name="no" value="No" class="button" onclick="submitForm('printToken','/hms/hms/registration?method=showQuickRegistrationJsp&quickVisit=yes')" />
<%}else{ %>
<input type="button" name="no" value="No" class="button" onclick="submitForm('printToken','/hms/hms/registration?method=showPatientVisitJsp')" />
<%} %><%} %>
</div>
<script type="text/javascript">

function UrlExists(url)
{
    /* var http = new XMLHttpRequest("/dev/usb/lp0");
    http.open('HEAD', url, false);
    http.send();
    return http.status!=404; */
    var url="file:///dev/usb/lp0";
    if(url){
        var req = new XMLHttpRequest();
        req.open('GET', url, false);
        req.send();
        alert(req.status==200)
        return req.status==200;
        
    } else {
    	 alert(req.status)
        return false;
    }
}
<% map.clear();%>
</script>
