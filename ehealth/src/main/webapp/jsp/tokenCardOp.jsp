<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
%>

<div class="titleBg">
<h2>Patient Print Token Report</h2>
</div>
<form name="printToken" method="post" action="">
	<div class="clear"></div>
	<div class="Block">
		<input type="hidden" name="currentDate"  value="<%= currentDate%>">
		<div class="clear"></div>
		<label> UHID</label>
		<input type="text" name="uhid" id="uhid" maxlength="22" tabindex="1" validate="uhid,String,no"  onblur="checkk();" />
		<span style="color: #333333; border: 0px solid #c5d49a !important; width: auto !important; height: 23px !important; float: left; margin: 6px 10px 5px 5px !important;padding: 0px !important;">OR</span>
		<label> Serial No.</label>
		<input type="text" name="tokenNo" id="tokenNo" maxlength="22" tabindex="1" validate="tokenNo,integer,no"  onblur="checkk();" />
		<div id="printTokenOpList">
		</div>
		<!-- <input type="button" name="add" id="addbutton" value="Print Token" class="buttonBig"
			onClick="if(checkk()){submitForm('printToken','registration?method=printTokenCardOp')};"
			accesskey="a" tabindex=1 /> -->
	</div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script language="javascript">

function checkk(){
	uhid = document.getElementById("uhid").value;
	serialNo = document.getElementById("tokenNo").value;
	if(uhid == ''  &&  serialNo == '') {
		alert("Enter UHID or Serial No");
		return false;
	} else {
		getprintTokenOp();
	}
}

function getprintTokenOp(){
	var uhid = document.getElementById("uhid").value; 
	var tokenNo = document.getElementById("tokenNo").value;
	submitProtoAjaxNew('printToken','registration?method=getTokenCardOpList&uhid='+uhid+'&tokenNo='+tokenNo,'printTokenOpList');
}

</script>