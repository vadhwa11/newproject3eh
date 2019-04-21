<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<div class="titleBg">
<h2>OPD Ophthalmology Follow Up Form Format</h2>
</div>
<div class="clear"></div>
<form name="search" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="Block"><label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text"
	id="hinNo" name="<%=HIN_NO%>" validate="Reg No,string,yes" value=""
	MAXLENGTH="20"
	onblur="getVisitNo('search','opd?method=getVisitList&flag=visit')" />
<div id="visitDiv"><label> <%=prop.getProperty("com.jkt.hms.opd_no") %></label> <input type="text"
	name="<%=VISIT_NUMBER%>" validate="Visit No,string,yes" value="" MAXLENGTH="50" /></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','opd?method=showOpdOphthalmologyFollowUpFormCaseSheetReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>
<div class="clear"></div>
<div class="division"></div>




