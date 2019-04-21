<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitM"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<HospitalDoctorUnitM>unitMList=new ArrayList<HospitalDoctorUnitM>();
if(map.get("unitMList")!=null){
	unitMList=(List<HospitalDoctorUnitM>)map.get("unitMList");
}
List<Patient>hinList=new ArrayList<Patient>();
if(map.get("hinList")!=null){
hinList=(List<Patient>)map.get("hinList");
}
List<Inpatient>ipList=new ArrayList<Inpatient>();
if(map.get("ipList")!=null){
	ipList=(List<Inpatient>)map.get("ipList");
}
List<MasDepartment>deptList=new ArrayList<MasDepartment>();
if(map.get("deptList")!=null){
	deptList=(List<MasDepartment>)map.get("deptList");
}
String message="";
if(map.get("message")!=null){
	message=(String)map.get("message");
}
int visitId=0;
if(map.get("visitId")!=null){
	visitId=(Integer)map.get("visitId");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
%>
<form name="opSurgeryPlanning" method="post">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script>
<%

               Calendar calendar=Calendar.getInstance();
               String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
               String curDate=String.valueOf(calendar.get(Calendar.DATE));
               int year=calendar.get(calendar.YEAR);
               if(month.length()<2){
                       month="0"+month;
               }
               if(curDate.length()<2){
                       curDate="0"+curDate;
               }

       %>

               serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<div class="titleBg">
<h2>Surgery Appointment</h2>
</div>
<%if(message!=null && !message.equals("")){ %>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>

<h4>Patient Details</h4>
<div class="clear"></div>
<%
String uhid="-";
String name="-";
String Age="-";
String gender="-";
int hinId=0;
String Ward="-";
String AdNo="-";
if(ipList.size()>0){
	for(Inpatient ip:ipList){

		hinId=ip.getHin().getId();
	uhid=ip.getHin().getHinNo();
	name=ip.getHin().getPFirstName();
	if(ip.getHin().getAge()!=null){
	Age=ip.getHin().getAge();
	}
	if(ip.getHin().getSex()!=null){
		gender=ip.getHin().getSex().getAdministrativeSexName();
	}
	
	if(ip.getDepartment()!=null){
		Ward=ip.getDepartment().getDepartmentName();
	}
	AdNo=ip.getAdNo();
	
	}
}else{
for(Patient pt:hinList){
	hinId=pt.getId();
uhid=pt.getHinNo();
name=pt.getPFirstName();
if(pt.getAge()!=null){
Age=pt.getAge();
}
if(pt.getSex()!=null){
	gender=pt.getSex().getAdministrativeSexName();
}}}
%>
<div class="Block">
<label>UHID</label>
<label class="value"><%=uhid %></label>
<label>Patient Name</label>
<label class="value"><%=name %></label>
<label>Age</label>
<label class="value"><%=Age %></label>
<div class="clear"></div>
<label>Gender</label>
<label class="value"><%=gender %></label>
<%if(Ward!=null && !Ward.equals("-")){ %>
<label>Ward</label>
<label class="value"><%=Ward %></label>
<label>AdNo.</label>
<label class="value"><%=AdNo %></label>
<%} %>
<div class="clear"></div>
<input type="hidden" readonly="readonly" name="visitId" id="visitId" value="<%=visitId %>" />

</div>
<div class="clear"></div>
<div class="clear"></div>
<h4>Booking Details</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label>Booking Date</label>
  <input
	type="text" name="bookingDate" class="date" id="bookingDateId"
	value="<%=currentDate %>" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.opSurgeryPlanning.bookingDate,event);" />
	
<label>Unit</label>
<select name="unitNmae" id="unitId" onchange="submitProtoAjaxWithDivName('opSurgeryPlanning','ot?method=getUnitDays&hinId=<%=hinId %>','unitDaysDiv');">
<option value="0">Select</option>
<%for(HospitalDoctorUnitM hospitalDoctorUnitM:unitMList){ %>
<option value="<%=hospitalDoctorUnitM.getId()%>"><%=hospitalDoctorUnitM.getUnitCode() %></option>
<%} %>
</select>
<div id="unitDaysDiv"></div>
<div class="clear"></div>

</div>
<script>
function validateDays(){
	var bookingDateId=document.getElementById('bookingDateId').value;
	var dayName=document.getElementById('dayNameId').value;
	var dayName2;
//var d = new Date();
//alert(dayName)
//alert(bookingDateId);
var dateObject = new Date(bookingDateId);
//alert(dateObject)

var dateParts = bookingDateId.split("/");

var dateObject = new Date(dateParts[2], dateParts[1] - 1, dateParts[0]);
//alert(dateObject)
var n = dateObject.getDay(); 

//alert(n);
if(n==0){
	dayName2="Sunday";
}else if(n==1){
	dayName2="Monday";
}else if(n==2){
	dayName2="Tuesday";
}
else if(n==3){
	dayName2="Wednesday";
	
}else if(n==4){
	dayName2="Thursday";
	
}else if(n==5){
	dayName2="Friday";
	
}else if(n==6){
	dayName2="Saturday";
	
}
//alert("n---=====>>>"+dayName2);
if(dayName==dayName2){
	return true;
}else if(dayName!=dayName2){
alert("Day Mismatched !!");
document.getElementById('bookingDateId').value="";
document.getElementById('dayNameId').value="0";
document.getElementById('unitId').value="0";
return false;
}
return false;
}
function getProcedureId(val,inc){
	if(val!=''){
		var index1 = val.indexOf("[");
		var index2 = val.indexOf("]");
		index1++;
		var procName = val.substring(0,index1-1);
		var procId = val.substring(index1,index2);
		
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var procCode = val.substring(index1,index2);
		document.getElementById('proscedureName'+inc).value=procName;
		document.getElementById('procedureId'+inc).value = procId;
		//document.getElementById('procedurecode'+inc).value = procCode;
		
		
	}else{
		if(document.getElementById('proscedureName'+inc)){
	      	document.getElementById('proscedureName'+inc).value="";
	      	document.getElementById('procedureId'+inc).value="";
	    	//document.getElementById('proDtId'+inc).value="";
	      //	document.getElementById('procRemarks'+inc).value="";
	      	//document.getElementById('procedurecode'+inc).value="";
			}
	}
	
}
function submitSurgryRequisition()
{
	var countSurgery=document.getElementById("procCount").value;
	var selectedCount=0;
	var visitId=document.getElementById("visitId").value;
	alert(visitId)
	//alert("countSurgery--->>"+countSurgery)
	/* for(var i=1;i<=countSurgery;i++)
		{
		if(document.getElementById("surgeryradio"+i).checked)
			{
			//alert("in if");
			selectedCount++;
			 document.getElementById("proscedureName"+i).setAttribute("validate", "Proscedure,metachar,yes");
			 document.getElementById("procedureId"+i).setAttribute("validate", "Proscedure,int,yes");
			// document.getElementById("tentativeDate"+i).setAttribute("validate", "Tentative Date,date,yes");
			 document.getElementById("pacstatus"+i).setAttribute("validate", "Pac Status,metachar,yes");
			}
		else
			{
			document.getElementById("proscedureName"+i).setAttribute("validate", "Proscedure,metachar,no");
			 document.getElementById("procedureId"+i).setAttribute("validate", "Proscedure,int,no");
			// document.getElementById("tentativeDate"+i).setAttribute("validate", "Tentative Date,date,no");
			 document.getElementById("pacstatus"+i).setAttribute("validate", "Pac Status,metachar,no");
			}
		} */
	/* if(selectedCount==0)
		{
		alert("Please select at least one patient to submit");
		return;
		} */
	
	submitForm('opSurgeryPlanning','opd?method=submitSurgeryRequisitionDetailsForInpatient&visitId='+visitId);
	
	}
function setStatusPresc(i){
	//alert(i);
	if(document.getElementById('PresstatusId'+i).checked==true){
	document.getElementById('canPrescStatId'+i).value="y";
	
	
	}else if(document.getElementById('PresstatusId'+i).checked==false){
		document.getElementById('canPrescStatId'+i).value="n";	
	}
}
function checkForAdmission(){
	if(document.getElementById('areqId').checked==true){
		document.getElementById('AdmDiv').style.display="inline";
		document.getElementById('AdmDiv').style.display="inline";
		document.getElementById('arnameId').value="y";
	}else if(document.getElementById('areqId').checked==false){
		document.getElementById('AdmDiv').style.display="none";
		document.getElementById('AdmDiv').style.display="none";
		document.getElementById('arnameId').value="n";
	}
}
</script>
</form>