<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.IpdInvestigationMonitoring"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>

<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/common.js"></script>
 
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
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<%
Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<IpdInvestigationMonitoring> invMontList = new ArrayList<IpdInvestigationMonitoring>();
if(map.get("invMontList")!=null){
	invMontList = (List<IpdInvestigationMonitoring>)map.get("invMontList");
}
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
Inpatient inpatient =(Inpatient)map.get("inpatient");
int inpatientId= 0;

String uhid="";
String patientName="";
String gender="";
String meritalStatus="";
String age="";
String patientCategory="";
String departmentName="";
if(inpatient!=null){
	inpatientId = inpatient.getId();
	Patient patient=inpatient.getHin();
	uhid=inpatient.getHinNo();	
	if(patient.getPFirstName()!=null)
		patientName=patient.getPFirstName();
	if(patient.getPMiddleName()!=null)
		patientName=patient.getPMiddleName()+" "+patientName;
	if(patient.getPLastName()!=null)
		patientName=patient.getPLastName()+" "+patientName;
	if(patient.getSex()!=null)
		gender=patient.getSex().getAdministrativeSexName();
	if(patient.getMaritalStatus()!=null)
	meritalStatus=patient.getMaritalStatus().getMaritalStatusName();
	age=patient.getAge();
	session.setAttribute("inpatient",inpatient);
}

%>
<div class="titleBg"><h2>Investigation Trend</h2></div>

<h4>Patient Details</h4>
<div class="clear"></div>
<%@include file="PatientDetails.jsp" %>
<form name="investigationTrend" method="post" action="">
<input name="inpatientId" type="hidden"	value="<%=inpatient.getId()%>" />
<div class="clear"></div>
<div class="Block">
<label><span>*</span>From Date</label>
<input type="text"	class="date" id="fromDateId" name="fromDate"
	   value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30"   validate="From Date,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"border="0" validate="Pick a date,date,no"
	onclick="setdate('<%=currentDate%>',document.investigationTrend.fromDate,event);" />

<label><span>*</span>To Date</label>
<input type="text" class="date" id="toDateId" name="toDate" value="<%=currentDate %>" readonly="readonly"
	MAXLENGTH="30"  validate="To Date,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"
	onclick="setdate('<%=currentDate%>',document.investigationTrend.toDate,event);" />
	
	<div class="clear"></div>
	<label>Investigation Name</label>
	<select name="chargeCode"  onchange="submitProtoAjax('investigationTrend','/hms/hms/ipd?method=getInvResultForTrend&inpatientId=<%=inpatientId%>&chargeCodeId='+this.value);">
	<option value="0">Select</option>
	<%
		for(IpdInvestigationMonitoring obj : invMontList){
	%>
	<option value="<%=obj.getChargeCode().getId()%>"><%=obj.getChargeCode().getChargeCodeName() %></option>
	<%} %>
	
	</select>
	
<div class="clear"></div>
</div>
<div id="testDiv">

</div>
<script>
function popwindowresult(url)
{  
 newwindow=window.open(url,'name','left=100,top=100,height=700,width=850,scrollbars=yes,resizable=1');
 if (window.focus) 
 {
 newwindow.focus();
 }
 newwindow.createPopup();
}

</script>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	

