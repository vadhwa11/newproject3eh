<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showOTPatientSearchForDisposalJsp";
  obj.submit();
}
</script>

<div class="titleBg">
<h2>Search Human Body Parts Disposal</h2>
</div>
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<h4>Patient Search</h4>
<div class="Block">
<div class="clear"></div>
<div class="clear"></div>
<label> HIN:</label> <input type="text" name="<%=HIN_NO%>" value=""
	MAXLENGTH="50"
	onchange="submitProtoAjaxWithDivName('search','ot?method=getHinNoList&flag=entry','entryDiv')" />

<div id="entryDiv"><label><span>*</span> Entry No:</label> <input
	type="text" name="entryNo" value="" class="textbox_date" MAXLENGTH="50"
	validate="Entry No.,String,yes" /></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','ot?method=showHumanBodyPartsDisposalJsp&flag=existingRecord');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	accesskey="r" /> <input type="button" name="Back" class="button"
	value="Back" onclick="showBack('search')" /></form>
</div>





