<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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

<div class="clear"></div>
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
<h2><%=prop.getProperty("com.jkt.hms.ipd") %> slip</h2>
</div>
<div class="clear"></div>
<form name="ipAdmissionReport" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<%-- <!--<label>Service No.</label><input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" MAXLENGTH="20" onblur="submitProtoAjax('ipAdmissionReport','adt?method=getAdmissionNoList&flag=admission')"/>--> --%>
<div id="testDiv"><label> <%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <input type="text"
	id="frwSlno" name="<%=AD_NO%>" value="" class="textbox_date"
	MAXLENGTH="30" validate="<%=prop.getProperty("com.jkt.hms.ipd_no") %>,metachar,yes" /></div>
<div class="clear"></div>
</div>

<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('ipAdmissionReport','adt?method=showIPAdmissionReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>

<script type="text/javascript" language="javascript">

	function validateFromToDate(){

		var nowDate=new Date();

		var obj1 = eval(document.ipAdmissionReport.fromDate)
		var obj2 = eval(document.ipAdmissionReport.toDate)

		if(obj1.value != "" && obj2.value != "")
		{

		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));

			if(validFromDate<=nowDate)
				{
					if(validFromDate > validToDate)
					{
							alert("From Date should be smaller than To Date\n");
							return false;
					}
				}

			else
				{
				alert("From Date should not be greater than Current date\n");
				return false;
				}

		}
		return true;
	}
</script>
 