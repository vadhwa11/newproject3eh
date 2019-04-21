<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showPostAnaesthesiaPatientDetails";
  obj.submit();
}
</script>

<div class="titleBg">
<h2>Search OT Specimen Dispatch Entry</h2>
</div>

<form name="search" method="post" action="">

<div class="Block">
<div class="clear"></div>
<label> HIN:</label> <input type="text" name="<%=HIN_NO%>" value=""
	MAXLENGTH="50"
	onchange="submitProtoAjax('search','ot?method=getOTSpecimenDispatchList&flag=visit')" />
<div id="testDiv"><label><span>*</span> Entry No.:</label> <input
	type="text" id="visitNo" name="<%=VISIT_NUMBER%>" value=""
	MAXLENGTH="6" validate="Entry No.,String,yes" /></div>
<div class="clear"></div>
</div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','ot?method=showOtSpecimenDispatchEntry');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	accesskey="r" /> <input type="button" name="Back" class="button"
	value="Back" onclick="showBack('search')" /> 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>





