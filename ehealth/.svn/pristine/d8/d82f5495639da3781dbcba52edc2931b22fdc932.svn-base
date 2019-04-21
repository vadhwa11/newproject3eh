<%@ page import="static jkt.hms.util.RequestConstants.*"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<h2>OPD OnCo Surgery Format</h2>


<form name="search" target="_blank" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<label>HIN:</label> <input type="text" id="hinNo." name="<%=HIN_NO%>"
	validate="HIN,string,yes" value="" class="textbox_date" MAXLENGTH="20"
	onblur="getVisitNo('search','opd?method=getOpdReportList&flag=visit')" />
<div id="visitDiv"><label> Visit No</label> <input type="text"
	name="<%=VISIT_NUMBER%>" value="" class="textbox_date" MAXLENGTH="50" />
</div>

<div class="clear"></div>

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','opd?method=showOpdOncosurgeryCaseSheetReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>