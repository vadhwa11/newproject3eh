<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> 
<div class="titleBg">
<h2>Patient Medical Case Sheet Format</h2>
</div>
<div class="clear"></div>
<form name="search" target="_blank" method="post" action="">
<div class="Block"><label>HIN</label> <input type="text"
	id="hinNo." name="<%=HIN_NO%>" validate="HIN,string,yes" value=""
	MAXLENGTH="20"
	onblur="getVisitNo('search','opd?method=getOpdReportList&flag=visit')" />
<div id="visitDiv"><label> Visit No.</label> <input type="text"
	name="<%=VISIT_NUMBER%>" value="" MAXLENGTH="50" /></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','opd?method=showPatientMedicalCaseSheetReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	






