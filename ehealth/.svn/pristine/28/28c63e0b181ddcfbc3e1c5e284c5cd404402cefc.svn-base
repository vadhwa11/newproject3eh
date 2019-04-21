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
<h2>Reprint Barcode</h2>
</div>
<div class="clear"></div>
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="Block"><!--<label class="medium">Service No.</label><input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" MAXLENGTH="30" onblur="getHinNo('search','registration?method=getHinNoForUpdateAdt&flag=registration')"/>-->
<div id="hinDiv"><label class="medium"> <%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input
	type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30" id="hinNo12"
	onchange="submitProtoAjax('search','registration?method=getPatientName')" onblur="checkHin();"
	validate="<%=prop.getProperty("com.jkt.hms.registration_no") %>,String,yes" /></div>
<div id="testDiv"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>

<input type="hidden" id="hinNo" name="hinNo" value=""/>
<input type="button" name="Report" value="Generate BarCode" class="buttonBig"
onClick="submitForm('search','registration?method=generateBarCode');"/>
</form>

<script>
function checkHin(){
	document.getElementById('hinNo').value = document.getElementById('hinNo12').value;
	return true;
}
</script>




