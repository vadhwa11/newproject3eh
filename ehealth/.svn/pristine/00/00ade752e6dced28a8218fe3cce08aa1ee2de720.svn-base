<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<META content="Evrsoft First Page" name=GENERATOR>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js"  	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"  type=text/javascript></SCRIPT>

<SCRIPT>
		<%

			Calendar calendar=Calendar.getInstance();
			String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
			String dateCal=String.valueOf(calendar.get(Calendar.DATE));
			int year=calendar.get(calendar.YEAR);
			if(month.length()<2){
				month="0"+month;
			}
			if(dateCal.length()<2){
				dateCal="0"+dateCal;
			}

		%>
			serverdate = '<%=dateCal+"/"+month+"/"+year%>'
		</SCRIPT>
	<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}


			String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   %>
			   <h4><span><%=message %></span></h4>
			   <%} %>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<div class="titleBg"><H2>Bill  Dispensing</H2></div>
<DIV class=clear></DIV>
	<form name="billDispencingReport" action="" method=post>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="Block">

<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="hinNoId" value="" id="hinNoId" MAXLENGTH="50" onchange="submitProtoAjaxWithDivName('billDispencingReport','billing?method=getDisBillNo','billNoDiv')" validate="hinNoId,metachar,yes" />


<label>Bill No.</label>
<div id="billNoDiv">
<input type="text" id="billNo" name="billNo"  value=""  MAXLENGTH="15" validate="Bill No.,metachar,yes"/>
</div>
<!--  onblur="openPopUp();" onchange="openPopUp();" -->
<!--

<LABEL>Bill No </LABEL>
 <input type="text" name="textfield" />
  -->
<div class=clear></div>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('billDispencingReport','billing?method=printBillPrintingDispencingReport');" accesskey="g" tabindex=1/>
</div>

<script>

	/* function openPopUp()
	{
		var billNo = "";
		billNo = document.getElementById('billNo').value;
		window.open('opBilling?method=showPopUpForReportApplet&billNo='+billNo+'&billtype=dispensingDup','mywindow','target="_blank", width=300,height=10');
	}
	document.getElementById('hinNoId').focus(); */
</script>
</form>
