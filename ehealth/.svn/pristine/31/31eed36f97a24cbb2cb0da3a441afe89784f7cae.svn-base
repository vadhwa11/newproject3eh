<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
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
<%
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate"); 
	%>
<div class="titleBg">
<h2>Medico Legal Report</h2>
</div>
<div class="clear"></div>

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
<div class="Block"><label> <%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="50"
	onchange="submitProtoAjax('search','adt?method=getMlcNo')" />

<div id="testDiv"><label> MLC No.</label> <input type="text"
	name="<%=MLC_NO%>" value="" MAXLENGTH="20" validate="Mlc No,string,yes" /></div>
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('search','adt?method=showMedicoLegalReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>





