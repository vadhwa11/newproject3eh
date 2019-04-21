<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>

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
<div class="titleBg"><H2>Bill Receipt Report</H2></div>
<div class=clear></div>
<form name="billServiceReport" action="" method="post" >
<div class="Block">
<label>Advance</label>
<input type="radio" id="aa" name="a" value="adv" class="inputRadiobutton" checked="checked" maxlength="30" tabindex=1 />
<label>Final Settlement </label>
<input type="radio" id="aa" name="a" value="fs" class="inputRadiobutton" maxlength="30" tabindex=1 />
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="hinNoId" value="" id="hinNoId" MAXLENGTH="50" onchange="setValueOnBlur();submitProtoAjaxWithDivName('billServiceReport','billing?method=getRecieptNo','billNoDiv')" validate="hinNoId,metachar,no" />
<label>Receipt No.</label>
<div id="billNoDiv">
<input type="text" id="BillNo" name="BillNo"  value=""  MAXLENGTH="15" onblur="setValueOnBlur();openPopUp();" onchange="setValueOnBlur();openPopUp();" validate="Receipt No.,metachar,no"/>
</div>
<div class=clear></div>
</div>
<div class=clear></div>
<div class="division"></div>
<input type="button" id="Report" name="Report" value="Generate Report" class="buttonBig" style="display: none;"	onClick="submitForm('billServiceReport','generalMaster?method=generateReportsForBilling');"	accesskey="g" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="radioType" value="" id="radioType"/>
<input type="hidden" name="billtype" value="" id="billtype" validate="billtype,metachar,no"/>
<script type="text/javascript">
	function openPopUp()
	{
		var billNo = "";
		var billType="";
		billNo = document.getElementById('billNo').value;
		billType =document.getElementById('billtype').value;
		if(billNo == 0)
		{
			document.getElementById('Report').style.display = 'none';
		}
		else
		{
			var radioType = document.getElementById('radioType').value;
			document.getElementById('Report').style.display = 'inline';
			if(radioType == 'adv')
			{
				document.getElementById('billtype').value = "receiptDup";
			}
			else
			{
				document.getElementById('billtype').value = "receiptfsDup";
			}
		}
	}

	function setValueOnBlur()
	{
		for(var i = 0; i < document.getElementsByName('a').length; i++)
		{
			if(document.getElementsByName('a')[i].checked == true)
			{
				document.getElementById('radioType').value =document.getElementsByName('a')[i].value;
			//	alert("document.getElementById('radioType').value ---"+document.getElementById('radioType').value );
			}
		}
	}
document.getElementById('hinNoId').focus();
 </script>

 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

