<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showPostAnaesthesiaPatientDetails";
  obj.submit();
}
</script>
<div class="titleBg">
<h2>Search OT Post Anesthesia Procedure</h2>
</div>
<form name="search" method="post" action="">
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label> HIN</label> <input type="text" name="<%=HIN_NO%>" value=""
	MAXLENGTH="50"
	onchange="submitProtoAjax('search','ot?method=getOpdReportList&flag=visit')" />
<div id="testDiv"><label>Yearly No.</label> <input type="text"
	id="visitNo" name="<%=VISIT_NUMBER%>" value="" MAXLENGTH="6"
	validate="Yearly No.,String,yes" /></div>
<div class="clear"></div>
</div>

<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('search','ot?method=showOtPostAnesthesiaProcedure');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /> <input type="button"
	name="Back" class="button" value="Back" onclick="showBack('search')" />


 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
</div>





