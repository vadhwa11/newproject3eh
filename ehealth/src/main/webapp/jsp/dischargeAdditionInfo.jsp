<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * chargeCodePopUp.jsp  
 * Purpose of the JSP -  This is for Charge code.
 * @author  Ritu
 * Create Date: 2nd Apr,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script> 
<form name="dischargeAddInfo" method="post">

<div class="titleBg">
<h2>Additional Information For Discharge</h2>
</div>
<div class="clear"></div>
<div class="Block"><label>Movement Code</label> <input type="text"
	name="<%=MOVEMENT_CODE %>" value="" MAXLENGTH="15"
	onblur="fillPatientName(this.value);" /> <label>Warrant No.</label> <input
	type="text" name="<%=WARRANT_NO%>" value="" MAXLENGTH="15" />

<div class="clear"></div>
<label>SHR</label> <input type="text" name="<%=SHR %>" value=""
	MAXLENGTH="15" /> <label>Remarks</label> <textarea
	name="<%=REMARKS %>" cols="44" rows="3" validate="Remarks,string,no"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"></textarea>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="hidden" name="<%=DISCHARGE_ID %>" id="disId" value=""><script
	type="text/javascript">
     for(var i = 0; i < window.opener.document.getElementsByName('parent').length; i++){
		if(window.opener.document.getElementsByName('parent')[i].checked == true){
         	var discId = window.opener.document.getElementsByName('parent')[i].value;
			document.getElementById('disId').value = discId;
			}
		}
     </script>

<div id="edited"></div>
<input type="button" name="save" value="save" class="button"
	onclick="submitForm('dischargeAddInfo','/hms/hms/adt?method=saveAdditionalInfoForDischarge&formName=dischargeAddInfo');" />
<input type="hidden" name="Print" value="Print" class="button"
	onclick="submitForm('dischargeAddInfo','/hms/hms/mis?method=showPatientMovementOrderjsp2');"
	accesskey="r" /> <input type="reset" name="Reset" value="Reset"
	class="buttonHighlight" onclick="location.reload();" accesskey="r" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>




