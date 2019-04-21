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
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 19 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="titleBg">
<h2>Update Patient Visit</h2>
</div>
<div class="clear"></div>

<form name="search" method="post" action=""><!--  	
			<label class="bodytextB">Service No.:</label>
			<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" class="textbox_date" MAXLENGTH="30" onblur="getHinNo('search','registration?method=getHinNoForUpdateAdt&flag=visit')"/>		
			-->
<div class="Block">
<div id="hinDiv"><label class="medium"> <span>*</span>  <%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30"
	onchange="submitProtoAjax('search','registration?method=getVisitNo')"
	validate="<%=prop.getProperty("com.jkt.hms.registration_no") %>,metachar,yes" /></div>

<label class="medium"> <span>*</span>  <%=prop.getProperty("com.jkt.hms.opd_no") %> </label>
<div id="testDiv"><input type="text" name="<%=VISIT_NUMBER %>"
	value="" MAXLENGTH="30" class="readOnly" readonly="readonly"
	validate="<%=prop.getProperty("com.jkt.hms.opd_no") %>,metachar,yes" /></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','registration?method=showUpdateVisitJsp&'+csrfTokenName+'='+csrfTokenValue);" />
<input type="reset" name="Reset" value="Reset" class="buttonHighlight"
	accesskey="r" /> 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>


<div id="error"></div>





