
<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
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
		String userName = "";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String currentTime = (String)utilMap.get("currentTime");
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		Map<String, Object> map=new HashMap<String, Object>();
		List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
		if(map.get("mlcList")!=null){
			mlcList=(List<OpdPatientDetails>)map.get("mlcList");
		}
		List<PatientWiseMlc> patWise = new ArrayList<PatientWiseMlc>();
		if(map.get("patWise")!=null){
			patWise=(List<PatientWiseMlc>)map.get("patWise");
		}
		List<MedicoLegalDetails> dateByMedicoLegalDetailsList=new ArrayList<MedicoLegalDetails>();
		if(map.get("dateByMedicoLegalDetailsList")!=null){
			dateByMedicoLegalDetailsList=(List<MedicoLegalDetails>)map.get("dateByMedicoLegalDetailsList");
		}
		String CurrentDate=date+"/"+month+"/"+year;
		String fromDate = CurrentDate;
		String toDate = CurrentDate;
		String uhin = "";
		if(map.get("fromDate") != null) {
			fromDate = (String) map.get("fromDate");
		}
		
		if(map.get("toDate") != null) {
			toDate = (String) map.get("toDate");
		}
		
		if(map.get("uhin") != null) {
			uhin = (String) map.get("uhin");
		}
		
		
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	

</script>



<div class="titleBg">
<h2>MLC Report</h2>
</div>

<div class="clear"></div>

<form name="mlcSearch" method="post">
<div class="Block">
<label>UHID</label>
<input name="hinNo" id="hinNo" value="<%=uhin %>" validate="UHID,string,no" />
 
<label>From Date</label>
<input type="text" id="FromDateId" name="FromDateId" class="dateTextSmall" value="<%=fromDate%>" readonly="readonly">
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	onclick="setdate('<%=date%>',document.mlcSearch.FromDateId,event);" />

<label>To Date</label>
<input type="text" id="ToDateId"name="ToDateId" class="dateTextSmall" value="<%=toDate%>" readonly="readonly">
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	
	onclick="setdate('<%=date%>',document.mlcSearch.ToDateId,event);" />
	
<input type="button" name="search" value="Search" class="button"
	onClick="if(datevalidation()){submitForm('mlcSearch','/hms/hms/mlc?method=getMlcReportByDifferentParameter');}" />	
	



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>

<div class="clear"></div>

<form name="mlcGrid" method="post" action="">
	
	<input type="hidden" name="mlcNameForReport" value="" id="mlcNameForReport">
	<input type="hidden" name="UhidForMlcReport" value="" id="UhidForMlcReport">
	<input type="hidden" name="medicoId" value="" id="medicoId">
	
	<table>
	
	<tr>
	<!-- <th>UHID</th> -->
	<th>UHID</th>
	<th>Name</th>
	<th>MLC Type</th>
	
	
	<!-- <th>UHID Print Status</th> -->
	</tr>
	
		
		<% if (dateByMedicoLegalDetailsList != null && dateByMedicoLegalDetailsList.size() > 0){
		String dob="";
		String gender="";
		Date dd=null;
		String pdistrict="";
		String housname="";
		String streetname="";
		String citizenAddress="";
		for(MedicoLegalDetails patient : dateByMedicoLegalDetailsList){
			%>
	<%-- <tr onclick="submitForm('search','/hms/hms/registration?method=showMsgForRegJsp&patientHinNo=<%=patient.getId()%>')"> --%>	
	<tr  onclick="populateDataFrom('<%=patient.getMlcType()%>','<%=patient.getHin().getHinNo()%>');HighLightTR(this)" style="cursor: pointer;">
	
	
	<td><%=patient.getHin().getHinNo()%></td>
	<td><%=patient.getHin().getFullName()%></td>
		<td><%=patient.getMlcType()%></td>
		<% 
	}
	%>
	 

</tr>
<%}%>
	</table>
	
	<div class="clear"></div>
	<input type="button" name="Print" id="Printbutton" value="Print"	style="display: none;
class="button"	onclick="submitForm('mlcGrid','/hms/hms/mlc?method=generateReportForMLC');" accesskey="a" />
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 
	</form>

</div>
 

<script type="text/javascript" language="javascript">

function populateDataFrom(mlcType,uhid){
	//alert(mlcType)
	document.getElementById('mlcNameForReport').value=mlcType
	document.getElementById('UhidForMlcReport').value=uhid

	
	document.getElementById('Printbutton').style.display = "block";
}
function datevalidation(){
	var fdate = document.getElementById('FromDateId');
	var tdate = document.getElementById('ToDateId');
	
	frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
	todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));
	
	if(fdate.value != "" && tdate.value != ""){
	 if(frdate > todate){
	  alert("To Date should be greater than or equal to the From Date.");
	   return false;
	  }
	} else {
		if (fdate.value == "" && tdate.value != "") {
			alert("Please select From Date");
			return false;
		}
		if (tdate.value == "" && fdate.value != "") {
			alert("Please select To Date");
			return false;
		}
	}
	
	return true;	
		
		}
</script>

   <div class="clear"></div>
 <div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
<!--Block Two Ends-->
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>
	

	
	
	