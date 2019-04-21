<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<%@page import="jkt.hms.util.RequestConstants"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

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
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currenDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");


	%>
	<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 28 Sep 2010
 -->
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<div class="titleBg">
<h2 align="left" class="style1">Treatment Certificate</h2>
</div>
<div class="clear"></div>
<form name="medicalCertificateReport" target="_blank" method="post"	action="">

<div class="Block">


<label><span>*</span> <%=prop.getProperty("com.jkt.hms.registration_no") %></label>
 <input	type="text" name="<%=HIN_NO%>" value="" validate="<%=prop.getProperty("com.jkt.hms.registration_no") %>,string,yes"	MAXLENGTH="50"	 onblur="submitProtoAjax('medicalCertificateReport','adt?method=getDiagnosis')"/>




<label> <span>*</span>From Date</label> 
<input type="text" class="date" name="<%=FROM_DATE%>" value=""  MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly"  onblur="submitProtoAjax('medicalCertificateReport','adt?method=getDiagnosis')"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currenDate%>',document.medicalCertificateReport.<%=FROM_DATE%>,event)" />

<label><span>*</span> To Date</label> 
<input type="text" class="date" name="<%=TO_DATE%>" value=""  MAXLENGTH="30" validate="Pick a to date,date,yes" readonly="readonly" onblur="submitProtoAjax('medicalCertificateReport','adt?method=getDiagnosis')"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currenDate%>',document.medicalCertificateReport.<%=TO_DATE%>,event)"  />

<div class="clear"></div>


<div id="testDiv">
<label>Diagnosis</label> 
<select name="<%=DIAGNOSIS_ID %>" multiple="multiple" class="multiple" size="2" disabled="disabled">  
</select>
</div>
	
	

<label>Fit/Unfit for</label> 
<input type="text"	name="<%=FIT_UNFIT_FOR%>" value="" MAXLENGTH="100" />
</div>
<div class="clear"></div>


<input type="button" name="OK" value="OK" class="button"	onClick="submitForm('medicalCertificateReport','adt?method=showMedicalCertificateReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" 	onclick="location.reload();" accesskey="r" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>





