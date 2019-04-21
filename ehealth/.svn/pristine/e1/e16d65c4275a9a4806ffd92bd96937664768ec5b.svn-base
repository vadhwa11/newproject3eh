<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
	  Map<String,Object> map = new HashMap<String,Object>();

	  if (request.getAttribute("map") != null) {
	  	map = (Map<String,Object>) request.getAttribute("map");

	  }
	  int inpatientId = 0;
	  if(map.get("inpatientId") != null){
		  inpatientId = (Integer)map.get("inpatientId");
	  }
	  %>

<input type="hidden" name="inpatientId" id="inpatientId" value="<%=inpatientId %>"/>
<SCRIPT LANGUAGE="JavaScript"><!--
    var _info = navigator.userAgent; 
    var _ns = false; 
    var _ns6 = false;
    var _ie = (_info.indexOf("MSIE") > 0 && _info.indexOf("Win") > 0 && _info.indexOf("Windows 3.1") < 0);
//--></SCRIPT> <COMMENT> <SCRIPT LANGUAGE="JavaScript1.1"><!--
        var _ns = (navigator.appName.indexOf("Netscape") >= 0 && ((_info.indexOf("Win") > 0 && _info.indexOf("Win16") < 0 && java.lang.System.getProperty("os.version").indexOf("3.5") < 0) || (_info.indexOf("Sun") > 0) || (_info.indexOf("Linux") > 0) || (_info.indexOf("AIX") > 0) || (_info.indexOf("OS/2") > 0)));
        var _ns6 = ((_ns == true) && (_info.indexOf("Mozilla/5") >= 0));
//--></SCRIPT> </COMMENT> <SCRIPT LANGUAGE="JavaScript"><!--
    if (_ie == true) document.writeln('<OBJECT classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93" WIDTH = "300" HEIGHT = "40"  codebase="../applets/jinstall-112-win32.cab#Version=1,1,2,0"><NOEMBED><XMP>');
    else if (_ns == true && _ns6 == false) document.writeln('<EMBED type="application/x-java-applet;version=1.1.2" CODE = "PrinterApplet.class" CODEBASE = "../applets" ARCHIVE = "jasperreports-applet-3.7.0.jar,commons-logging-1.0.4.jar,commons-collections-2.1.1.jar" WIDTH = "300" HEIGHT = "40" REPORT_URL = "../servlets/jasperprint" scriptable=false pluginspage="http://java.sun.com/products/plugin/1.1.2/plugin-install.html"><NOEMBED><XMP>');
//--></SCRIPT> <APPLET id="appletId" name="appl" CODE="PrinterApplet.class"
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
		VALUE="../servlets/jasperprint?inpatientId=<%=inpatientId %>&billtype=finalBillDup">
		</APPLET> </NOEMBED> </EMBED> </OBJECT>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
