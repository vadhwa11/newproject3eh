<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>



<div class="titleBg">
<h2>Patient Registration From Other Sources</h2>
</div>
<div class="clear"></div>
<div class="Block">
<form name="patientRegistration" method="post">
<h4>Appointment Id</h4> 
<div class="clear"></div>
<div class="clear"></div>
<label>Barcode Scan</label>
 <input type="radio" tabindex="1" name="radio1" value="qrScan" id="aadhaarType" class="inputRadiobutton" style="margin-right:35px !important;"
				onclick="showRelatedDiv(this)" />
<label>Barcode Text</label>
 <input type="radio" tabindex="1" name="radio1" value="eKyc" id="aadhaarType" class="inputRadiobutton" style="margin-right:35px !important;"
				onclick="showRelatedDiv(this)" />
<input type="text" style="display: none;" name="appointmentId" id="appointmentId" value="" maxlength="30" tabindex=1 validate="Appointment Id,int,yes"/> 

<input type="button" class="buttonBig"  id="Search" value="Search" onclick="getPatientDetails()"></input>



<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<div class="division"></div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


<div class="clear"></div>
<div class="clear"></div>

<div id="patientDiv">
</div>
</form>

</div>
<script type="text/javascript">
function submitPatientDetails(){
	submitForm('patientRegistration','/hms/hms/registration?method=submitPatientInformationFromOtherSource');
}

function getPatientDetails(){
	submitProtoAjaxWithDivName('patientRegistration','/hms/hms/registration?method=getPatientRegistrationDataFromOtherSrc','patientDiv');
}


function showRelatedDiv(i){
	var appointmentId;
	if(i.value == 'eKyc'){
			document.getElementById('appointmentId').style.display = 'block';
	} else if(i.value == 'qrScan'){
		appointmentId =	prompt("Scan Barcode");
		document.getElementById('appointmentId').value = appointmentId;
		document.getElementById('appointmentId').style.display = 'block';
		document.getElementById('Search').click();
	}
}

</script>
