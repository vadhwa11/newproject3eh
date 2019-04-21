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

<form name="search" method="post" action="">

<div class="clear"></div>
<div class="titleBg">
<h2>Patient Billing Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<label>Out Patient</label> <input type="radio" name="patientType"
	value="1" checked="checked" class="inputRadiobutton"
	onclick="displayFields(this.value);"><label>In Patient</label>
<input type="radio" name="patientType" value="2" class="inputRadiobutton"
	onclick="displayFields(this.value);">
<div class="clear"></div>

<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId"
value="" MAXLENGTH="30" onblur="if(checkHin()){callUrl();}" />
<!-- 		<div id="visitNoDiv">
			<label> Visit No.</label>
			<input type="text" name="<%=VISIT_NUMBER%>" id="visitNoId" value="" MAXLENGTH="30" />
			</div> -->

<div id="testDiv" style="display: none">
<label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label>
<input type="text" name="<%=AD_NO%>" id="adNoId" value="" MAXLENGTH="30" /></div>

<div class="clear"></div>
<div class="clear"></div>

<input type="button" name="Report" value="Generate Report"
	class="buttonBig"
	onClick="submitForm('search','opBilling?method=printPatientBillingReport');"
	accesskey="g" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button" " accesskey="a" onClick="submitForm('search','opBilling?method=showPatientBillingReportJsp');"
	tabindex=1 />
</div>	
<script type="text/javascript">

function displayFields(val){

if(val==2){
//	document.getElementById('visitNoDiv').style.display = 'none';
	document.getElementById('testDiv').style.display = 'block';

}else if(val==1){
// document.getElementById('visitNoDiv').style.display = 'block';
	document.getElementById('testDiv').style.display = 'none';
}
}
function callUrl(){

	for(var i = 0; i < document.getElementsByName('patientType').length; i++){
			  if(document.getElementsByName('patientType')[i].checked == true )
              {
              	if(document.getElementsByName('patientType')[i].value == "1" )
              	{	
				//	submitProtoAjaxWithDivName('search','opBilling?method=getVisitNoForReport','visitNoDiv');
              	}else if(document.getElementsByName('patientType')[i].value == "2"){
              		submitProtoAjaxWithDivName('search','billing?method=getAdNoForReport','testDiv');
              	}
          	}
      }

}
</script>	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	


