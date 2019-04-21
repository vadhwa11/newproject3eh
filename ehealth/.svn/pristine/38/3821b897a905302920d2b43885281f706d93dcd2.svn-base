<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<META content="Evrsoft First Page" name=GENERATOR>
<SCRIPT language=javascript src="/hms/jsp/js/common.js" type=text/javascript></SCRIPT>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js" type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js" type=text/javascript></SCRIPT>

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
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");



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

<div class="titleBg"><H2>Bill Printing Refund Report</H2></div>
<div class=clear></DIV>

<form name="billRefundReport" action="" method="post" >

<div class="Block">
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="hinNoId" value="" id="hinNoId" MAXLENGTH="50" onchange="submitProtoAjaxWithDivName('billRefundReport','billing?method=getRefund','billNoDiv')" validate="hinNoId,metachar,no"/>


<label>Refund No.</label>
<div id="billNoDiv">
<input type="text" id="billNo" name="billNo"  value=""  MAXLENGTH="15" onblur="openPopUp();" onchange="openPopUp();" validate="Refund No.,metachar,no"/>
</div>
<div class=clear></div>
</div>

<div class=clear></div>

<input type="button" id="Report" name="Report" value="Generate Report" class="buttonBig" style="display: none;"
		onClick="submitForm('billRefundReport','generalMaster?method=generateReportsForBilling');"
		accesskey="g" tabindex=1 />
				
		<input type="hidden" name="billtype" id="billtype" value="refundsDup"  validate="billType,metachar,no"/>

<script>
	function openPopUp()
	{
		var billNo = "";
		billNo = document.getElementById('billNo').value;
		if(billNo == 0)
		{
			document.getElementById('Report').style.display = 'none';
		}
		else
		{
			document.getElementById('Report').style.display = 'block';
		}
	}
	document.getElementById('hinNoId').focus();
 
</script>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>