<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showOtPatientDetails&otProcedure=no";
  obj.submit();
}
</script>
<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

	Map map = new HashMap();
	String userName="";
	int hospitalId=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
		
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>
<div class="titleBg">
<h2>Search Pre-Anesthesia Procedure Notes Entry</h2>
</div>

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="Block"><label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="50"
	onblur="submitProtoAjaxWithDivName('search','ot?method=getPreAnaesthesiaProcedureDetails&flag=yearlySerialNo','testDiv')" />
<div id="testDiv"><label><span>*</span>Yearly No.:</label> <input
	type="text" id="yearlySerialNo" name="yearlySerialNo" value=""
	MAXLENGTH="6" validate="Yearly No.,string,yes" /></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','ot?method=showPreAneaesthesiaProcNotesEntryJsp');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /> <input type="button"
	name="Back" class="button" value="Back" onclick="showBack('search')" />
</form>