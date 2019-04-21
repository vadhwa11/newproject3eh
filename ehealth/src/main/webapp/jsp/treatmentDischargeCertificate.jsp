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
<h2 align="left" class="style1">Treatment / Discharge Certificate</h2>
</div>
<form name="search" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="clear"></div>
<div class="Block">
<div id="hinDiv">
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> 
<input type="text"	name="<%=HIN_NO%>" value="" MAXLENGTH="50"	onchange="submitProtoAjax('search','adt?method=getIpNo')" />
</div>
 <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="trearmentDischargeCertificate">


<div id="testDiv"> 
<label>IP No.</label>
<select name="inpatientId">
</select>
</div>

<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('search','adt?method=generateReportForTrearmentDischargeCertificate');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
</div>
</form>
