<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> 
<div class="titleBg">
<h2>Patient Prescription Format</h2>
</div>
<% 

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

%>

<form name="search" target="_blank" method="post" action="">
<div class="Block">
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> 
<input type="text" id="hinNo" name="<%=HIN_NO%>"	validate="HIN,string,yes" value="" MAXLENGTH="20"	onblur="submitProtoAjaxWithDivNameToShowStatus('search','/hms/hms/stores?method=getVisitList&hinNo='+this.value,'teDivss');" />

<div id="teDivss">
<label> <%=prop.getProperty("com.jkt.hms.opd_no")%></label> 
<input type="text"	name="<%=VISIT_NUMBER%>" value="" MAXLENGTH="50" />



<label>Prescription No.</label> 
<select name="prescriptionId" id="prescriptionId">
<option value="0"></option>
</select>	
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="OK" value="Genrate Report" class="buttonBig"
	onClick="submitForm('search','stores?method=showPatientPrescriptionIssueQtyReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<div class="clear"></div>
<div class="division"></div>





