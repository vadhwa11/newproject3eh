<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript">
	<%URL myURL = application
					.getResource("/WEB-INF/commonFile.properties");
			InputStream in = myURL.openStream();
			Properties prop = new Properties();
			prop.load(in);
 
			Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
		serverdate = '<%=date + "/" + month + "/" + year%>'
	</script>

<div class="titleBg">
<h2>Birth / Death Report and Certification</h2>
</div>
<form name="bdReport" target="_blank" method="post" action="">
<div class="Block">
<div id="hinDiv"><label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30"
	validate="hinNo,metachar,no"
	onchange="submitProtoAjaxWithDivName('bdReport','mis?method=getAdmissionNoList&flag=admission&onlyReport=yes','testDiv')" />
</div>
<div id="testDiv"><label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label>
<input type="text" id="frwSlno" name="<%=AD_NO%>" value=""
	MAXLENGTH="30" validate="adNo,metachar,no"/></div>
<div class="clear"></div>
<label>Certificate</label>
<input type="radio" name="<%=SELECTED_RADIO%>" value="birth" checked="checked" validate="Cert,string,no" class="radiobutMargin"/> <label>Birth</label>
<input type="radio" name="<%=SELECTED_RADIO%>" value="death" validate="Birth,string,no" class="radiobutMargin"/> <label>Death</label>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('bdReport','/hms/hms/mis?method=printBDCertificate');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>



 