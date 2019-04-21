<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
<div class="titleBg">
<h2 align="left" class="style1">MLC Certificate</h2>
</div>
<form name="search" target="_blank" method="post" action="">
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 28 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="clear"></div>
<div class="Block"><!--<label>Service No.</label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" MAXLENGTH="20" onblur="getHinNo('search','adt?method=getAdmissionNoList&flag=hin&wound=yes')"/>		
-->
<div id="hinDiv"><label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="50"
	onchange="submitProtoAjax('search','adt?method=getAdmissionNoList&flag=admission&wound=yes')" />
</div>

<div id="testDiv"><label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <input type="text"
	id="frwSlno" name="<%=AD_NO%>" value="" MAXLENGTH="30" /></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('search','adt?method=showWoundCertificateReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
