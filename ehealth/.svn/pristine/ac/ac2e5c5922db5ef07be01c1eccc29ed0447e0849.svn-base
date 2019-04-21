<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
%>	

<form name="ipFinalBillReport" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	  Map<String,Object> map = new HashMap<String,Object>();

	  if (request.getAttribute("map") != null) {
	  	map = (Map<String,Object>) request.getAttribute("map");

	  }
	  String message = "";
	  if(map.get("message") != null){
	  	message = (String)map.get("message");
	  	
	  	}
%>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>IP Final Bill Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId"
	value="" MAXLENGTH="30"
onblur="if(checkHin()){submitProtoAjax('ipFinalBillReport','billing?method=getAdNoForReport&flag=finalbillingDup');}" />

<div id="testDiv"><label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label>
<input type="text" name="<%=AD_NO%>" id="adNoId" value="" MAXLENGTH="30"
onblur="submitProtoAjaxWithDivName('ipFinalBillReport','/hms/hms/billing?method=getInpatientId','appDiv');"/>
</div>

<div class="clear"></div>
<label>Summary</label> <input type="radio" name="reportType"
	value="<%=SUMMARY  %>" class="inputRadiobutton" checked="checked"
	maxlength="30" tabindex=1 /> <label class="medium">Detail </label> <input
	type="radio" name="reportType" value="<%=DETAIL  %>" class="inputRadiobutton"
	maxlength="30" tabindex=1 />
<div class="clear"></div>


<div class="clear"></div>
<!--<div id="appDiv">

<SCRIPT LANGUAGE="JavaScript">
    var _info = navigator.userAgent; 
    var _ns = false; 
    var _ns6 = false;
    var _ie = (_info.indexOf("MSIE") > 0 && _info.indexOf("Win") > 0 && _info.indexOf("Windows 3.1") < 0);
//</SCRIPT> <COMMENT> <SCRIPT LANGUAGE="JavaScript1.1">
        var _ns = (navigator.appName.indexOf("Netscape") >= 0 && ((_info.indexOf("Win") > 0 && _info.indexOf("Win16") < 0 && java.lang.System.getProperty("os.version").indexOf("3.5") < 0) || (_info.indexOf("Sun") > 0) || (_info.indexOf("Linux") > 0) || (_info.indexOf("AIX") > 0) || (_info.indexOf("OS/2") > 0)));
        var _ns6 = ((_ns == true) && (_info.indexOf("Mozilla/5") >= 0));
//</SCRIPT> </COMMENT> <SCRIPT LANGUAGE="JavaScript">
    if (_ie == true) document.writeln('<OBJECT classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93" WIDTH = "300" HEIGHT = "40"  codebase="../applets/jinstall-112-win32.cab#Version=1,1,2,0"><NOEMBED><XMP>');
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
		VALUE="../servlets/jasperprint?inpatientId=0&billtype=finalBillDup">
	</APPLET> </NOEMBED> </EMBED> </OBJECT>	
</div>
-->
<input type="button" class="buttonBig" value="Generate Report"
	onclick="if(checkAdNo()){submitForm('ipFinalBillReport','/hms/hms/billing?method=printIPFinalBillReport');}">
</div>
<div id="error"></div>
<script type="text/javascript">
function checkAdNo(){
	if(document.getElementById('adNoId').value == "" ){
		alert("Please enter IP No.");
		return false;
	}
	return true;
}

function checkHin(){
	if(document.getElementById('hinNoId').value == "" ){
		return false;
	}
	return true;
}

</script>


</form>