

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>

<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>

<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>




<script>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>


<%

	Map<String, Object> map = new HashMap<String, Object>();

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

//	List<Visit> visitList = new ArrayList<Visit>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<Object[]> patientPresriptionDetailList = new ArrayList<Object[]>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientPresriptionDetailList") != null){
		patientPresriptionDetailList = (List)map.get("patientPresriptionDetailList");	
	}
String message = "";
if(map.get("message")!=null){
	message = (String)map.get("message");
}
%>



<form name="ct" method="post">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
<div class="clear"></div>
<h4><%=message %></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Continuous Treatment</h2>
</div>
<div class="clear"></div>

<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><label>UHID <span>*</span></label> <input
	type="text" name="uhidNo" id="uhidNo" value=""
	validate="UHID,metachar,yes"
	onblur="if(this.value!=''){submitProtoAjax('ct','/hms/hms/stores?method=getPatientDetailsForCT');}" />

<div id="testDiv"></div>

</div>



<div class="clear"></div>

<div class="division"></div>
<div class="clear"></div>




<input name="Submit11" tabindex="1" id="Submit11" class="button" type="button"
	value="Save" 
	onclick="submitForm('ct','/hms/hms/stores?method=saveCtDetails','validateRows');" />
<input type="reset" name="Reset" value="Reset" class="button"
	accesskey="r" /> 
<script type="text/javascript">
function validateRows(){
		var count = document.getElementById('cTCount').value;
		
		for(var i=1;i<=count;i++){
			if(document.getElementById('ctCheck'+i).checked){
				return true;
			}

		}
		alert("Please select at least one row.");
		return false;
	}


</script>


</form>
