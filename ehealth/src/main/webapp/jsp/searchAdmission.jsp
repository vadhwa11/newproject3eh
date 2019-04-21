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
Date 26 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="titleBg">
<h2>Update Patient Admission</h2>
</div>
<div class="clear"></div>
<form name="search" method="post" action=""><%--	
			<label class="bodytextB">Service No.:</label>
			<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" class="textbox_date" MAXLENGTH="30" onblur="getHinNo('search','registration?method=getHinNoForUpdateAdt&flag=admission')"/>
			--%>
<div class="Block">
<div id="hinDiv"><label> <%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text"
	name="<%=HIN_NO%>" value="" maxlength="30"
	onblur="submitProtoAjax('search','adt?method=getAdmissionNoList&flag=admission');" />
</div>

<div id="testDiv"><label><span>*</span> <%=prop.getProperty("com.jkt.hms.ipd_no") %> </label> <input
	type="text" name="<%=AD_NO %>" value="" maxlength="30"
	validate="<%=prop.getProperty("com.jkt.hms.ipd_no") %>,String,yes" /></div>
<div class="clear"></div>
</div>
<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','adt?method=showUpdateAdmissionJsp');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	accesskey="r"
	onClick="submitForm('search','/hms/hms/adt?method=showUpdateSearchJsp&jsp=admission&appId=A205');" />
 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>





