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
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	String message = "";
	
		
	if(map.get("message") != null)
		message = (String)map.get("message");	
		
		
%>
<h4>
<%=message != null?message:"" %></h4>


<div class="titleBg">
<h2>Patient Online Appointment Visit</h2>
</div>
<div class="clear"></div>
<div class="Block">
<form name="onlineAppointmentVisit" method="post">
<!--<h4>Appointment No</h4> 
<div class="clear"></div>
<div class="clear"></div>
 <label>Barcode Scan</label>
 <input type="radio" tabindex="1" name="radio1" value="qrScan" id="aadhaarType" class="inputRadiobutton" style="margin-right:35px !important;"
				onclick="showRelatedDiv(this)" />
<label>Barcode Text</label>
 <input type="radio" tabindex="1" name="radio1" value="eKyc" id="aadhaarType" class="inputRadiobutton" style="margin-right:35px !important;"
				onclick="showRelatedDiv(this)" /> -->
				<label>Appointment No</label>
<input type="text"  name="appointmentNo" id="appointmentNo" value="" maxlength="30" tabindex=1 validate="Appointment Id,string,yes"/> 

<input type="button" class="buttonBig"  id="Search" value="Search" onclick="getOnlineAppointmentDetails()"></input>



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
	submitForm('onlineAppointmentVisit','/hms/hms/registration?method=submitOnlineAppointmentVisitDetails');
}

function getOnlineAppointmentDetails(){
	submitProtoAjaxWithDivName('onlineAppointmentVisit','/hms/hms/registration?method=getOnlineAppointmentDetails','patientDiv');
}




</script>
