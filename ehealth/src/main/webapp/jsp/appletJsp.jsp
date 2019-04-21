<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.Users"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	String billNo = "";
	String billtype = "";
	if(map.get("billNo") != null){
		billNo = (String)map.get("billNo");
	}
	if(map.get("billtype") != null){
		billtype = (String)map.get("billtype");
	}
	
	String loginName = "";
	Users user = new Users();
	if (session.getAttribute("users") != null) {
		user = (Users) session.getAttribute("users");
		loginName = user.getLoginName();
	}
	
%>
<SCRIPT LANGUAGE="JavaScript"><!--
    var _info = navigator.userAgent; 
    var _ns = false; 
    var _ns6 = false;
    var _ie = (_info.indexOf("MSIE") > 0 && _info.indexOf("Win") > 0 && _info.indexOf("Windows 3.1") < 0);
//--></SCRIPT>
<COMMENT>
<SCRIPT LANGUAGE="JavaScript1.1"><!--
        var _ns = (navigator.appName.indexOf("Netscape") >= 0 && ((_info.indexOf("Win") > 0 && _info.indexOf("Win16") < 0 && java.lang.System.getProperty("os.version").indexOf("3.5") < 0) || (_info.indexOf("Sun") > 0) || (_info.indexOf("Linux") > 0) || (_info.indexOf("AIX") > 0) || (_info.indexOf("OS/2") > 0)));
        var _ns6 = ((_ns == true) && (_info.indexOf("Mozilla/5") >= 0));
//--></SCRIPT>
</COMMENT>

<SCRIPT LANGUAGE="JavaScript"><!--
    if (_ie == true) document.writeln('<OBJECT classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93" WIDTH = "300" HEIGHT = "40"  codebase="../applets/jinstall-112-win32.cab#Version=1,1,2,0"><NOEMBED><XMP>');
    else if (_ns == true && _ns6 == false) document.writeln('<EMBED type="application/x-java-applet;version=1.1.2" CODE = "PrinterApplet.class" CODEBASE = "../applets" ARCHIVE = "jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar" WIDTH = "300" HEIGHT = "40" REPORT_URL = "../servlets/jasperprint" scriptable=false pluginspage="http://java.sun.com/products/plugin/1.1.2/plugin-install.html"><NOEMBED><XMP>');
//--></SCRIPT>
<APPLET name="appl" CODE="PrinterApplet.class" CODEBASE="../applets"
	ARCHIVE="jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar"
	WIDTH="257" HEIGHT="40"></XMP>
	<PARAM NAME=CODE VALUE="PrinterApplet.class">
	<PARAM NAME=CODEBASE VALUE="../applets">
	<PARAM NAME=ARCHIVE
		VALUE="jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar">
	<PARAM NAME="type" VALUE="application/x-java-applet;version=1.2.2">
	<PARAM NAME="scriptable" VALUE="true">
	<%
   if( billtype.equals("finalBillDup") ||  billtype.equals("finalBillDupdetails")){
	   int inpatientId = 0;
	   if(map.get("billNo") != null){
		   inpatientId = (Integer)map.get("billNo");
	   }
	   
    %>

	<PARAM NAME="REPORT_URL"
		VALUE="../servlets/jasperprint?inpatientId=<%=inpatientId %>&billtype=<%=billtype %>">
	<%}else{ %>
	<PARAM NAME="REPORT_URL"
		VALUE="../servlets/jasperprint?billNo=<%=billNo %>&loginName=<%=loginName %>&billtype=<%=billtype %>">
	<%} %>
	<!--<PARAM NAME="REPORT_URL"
		VALUE="../servlets/jasperprint?billNo=<%=billNo %>&loginName=<%=loginName %>&billtype=<%=billtype %>">
-->
</APPLET>
</NOEMBED>
</EMBED>
</OBJECT>
</body>
</html>