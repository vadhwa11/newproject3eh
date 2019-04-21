<%@page import="jkt.hms.masters.business.MasDocument"%>
<%@page import="jkt.hms.util.Box"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitM"%>

<script type="text/javascript">
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>
<script type="text/javascript" src="/hms/jsp/js/csrfToken.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Appointment</title>

<%
Box box=HMSUtil.getBox(request);
String uhid="";


if(!box.getString("uhid").equalsIgnoreCase(""))
{
	uhid=box.getString("uhid");
}
if(!box.getString("futureConsultFlag").equalsIgnoreCase(""))
{
%>
<meta http-equiv="refresh" content="${pageContext.session.maxInactiveInterval};url=/hms/hms/login?method=logout"/>	
<script src="/hms/jsp/js/dynamic-window-height/jquery.min.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<div id="mainIn">
<%}%>

 
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>

<%
boolean recordExists=false;

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentTimeHHMM();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");

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
<script type="text/javascript">
function getPriorityNumber(priorityNo){
	var property=document.getElementById("Id"+priorityNo);
	property.style.border = 'solid 1px #be4c39';
	property.style.background = '#be4c39';
	var preSelectedQueueNo = document.getElementById("preQueue").value;
	document.getElementById("preQueue").value=priorityNo;
	
	if(preSelectedQueueNo!='0' && priorityNo!=preSelectedQueueNo){
		document.getElementById("Id"+preSelectedQueueNo).style.background = '#0f75bf';
	}
}

</script>
<script type="text/javascript">

             function check()
            {
            	document.getElementById("preQueue").value=0;//added by govind 2017
                if (document.getElementById('appointmentDateId').value==""
                 || document.getElementById('appointmentDateId').value==undefined)
                {
                    alert ("Please Enter Appointment Date");
                    document.getElementById('departmentId').selectedIndex="0";
                    return false;
                }
                return true;
            } 

         
        </script>
<%

String currentTime="";
Map<String, Object> map = new HashMap<String, Object>();

Map<String, Object> dateAndTimeMap=HMSUtil.getCurrentDateAndTime();
currentDate=(String)dateAndTimeMap.get("currentDate");
currentTime=(String)dateAndTimeMap.get("currentTime");

List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
List<HospitalDoctorUnitM> unitExisted=new ArrayList<HospitalDoctorUnitM>();
//List<Object[]> doctorList = new ArrayList<Object[]>();

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
String futureConsultationFlag="";
//String uhid="";
if (map.get("futureConsultationFlag") != null) 
{
	futureConsultationFlag = (String) map.get("futureConsultationFlag");
}
if (map.get("uhid") != null) 
{
	uhid = (String) map.get("uhid");
}
String pName = "";
if (map.get("pName") != null) 
{
	pName = (String) map.get("pName");
}
String age = "";
if (map.get("age") != null) 
{
	age = (String) map.get("age");
}
String gender = "";
if (map.get("gender") != null) 
{
	gender = (String) map.get("gender");
}
String mobileNo = "";
if (map.get("mobileNo") != null) 
{
	mobileNo = (String) map.get("mobileNo");
}
if (map.get("departmentList") != null) 
{
	departmentList = (List<MasDepartment>) map.get("departmentList");
}
/* if(map.get("doctorList") != null)
{
	doctorList = (List<Object[]>)map.get("doctorList");
} */
if(map.get("recordExists")!=null)
{
        recordExists=(Boolean)map.get("recordExists");
}
//Commented by Arbind on 14-12-2017
/* List<MasSession> masSessionList=new ArrayList<MasSession>();
if(map.get("masSessionList")!=null)
{
	masSessionList=(List<MasSession>)map.get("masSessionList");
}
//added by govind 09-01-2017
List<Object[]> employeeByCategoryList = new ArrayList<Object[]>();
if(map.get("employeeByCategoryList")!= null){
	 employeeByCategoryList = (List<Object[]>)map.get("employeeByCategoryList");
}
//added by govind 09-01-2017 end */

if(map.get("unitExisted")!=null){
	unitExisted=(List<HospitalDoctorUnitM>)map.get("unitExisted");
}

int minday = 0;
int maxday = 0;
%>


<div class="titleBg">
<h2>Online Appointment</h2>
</div>

<h2><%=futureConsultationFlag %></h2>
<div class="Block">
<form name="OnlineAppointment" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" id ="minday" name="minday" value="<%=minday %>" />
<input type="hidden" id ="maxday" name="maxday" value="<%=maxday %>" />
<input type="hidden" name="preQueue" id="preQueue" value="0">
<label>UHID<span>*</span></label> 
<input type="text" tabindex="1" name="uhid" value="<%=uhid %>" maxlength="20" validate="uhid,metachar,yes" onblur="patientDetails(this.value);"/>
 <label>Patient Name</label> <input type="text"
			tabindex="1" name="pnameId" id="pnameId" maxlength="50"
			value="<%=pName %>" readonly="readonly" style="width: 310px;" />	
			<div class="clear"></div>
			<label>Gender</label><input
			type="text" tabindex="1" name="gender" id="genderId" value="<%=gender %>"
			readonly="readonly" />					
			
			<label>Age</label> <input type="text" tabindex="1" name="age" value="<%=age %>"
			id="ageId" maxlength="3" value="" readonly="readonly" />
<label>Mobile No.</label> 
<input type="text" name="mob" id="mobileNoId" maxlength="13" value="<%=mobileNo %>" readonly="readonly" tabindex="1" validate="mob,phone,no"/>
<div class="clear"></div>

<label>Service Center<span>*</span></label> 
<select name="department" tabindex="1" id="departmentId" validate="department,metachar,yes" 
onchange="" onblur="getCounterTiming(this.value);fnGetDoctorDepartment();">
<option value="0">Select</option>
<% 
for(MasDepartment masDepartment : departmentList)
		{
%>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
<%
		} 
%>
</select>

<label>Appointment Date<span>*</span></label> <input type="text" id="appointmentDateId" onblur="checkAppointmentDate();validateExpDate(this,'appointmentDateId');minmaxDayCheck();"
					   onkeyup="mask(this.value,this,'2,5','/');" 
                               name="appointmentDate" tabindex="1" 
                               value="" class="date" 
                               validate="Appointment Date,date,yes"
                                onchange=""
                               MAXLENGTH="30" />

                       <div id="sdobcalId">
                               <img id="" src="/hms/jsp/images/cal.gif" width="16" height="16"
                                       border="0"
                                       onclick="setdate('<%=currentDate %>',document.OnlineAppointment.appointmentDate,event)"
                                       validate="Pick a date,date,no" 
                                        tabindex="1" />
                       </div>

 <label>Appointment Time</label>
 <input type="hidden" name="currentDate" value="<%=currentDate %>" readonly="readonly" tabindex="1" validate="currentDate,date,no"/>
<input type="hidden" name="currentTime" value="<%=currentTime %>" readonly="readonly" tabindex="1"/>
<!-- <input type="text" name="visitTime" value="08:00" maxlength="5"   onKeyUp="mask(this.value,this,'2',':');" tabindex="1"/> -->
<select name="visitTime" tabindex="1" id="visitTime" validate="visitTime,string,yes" onblur="getToken();getSessionForDepartment(this.value);">
<option value="">select</option>
</select>


<div class="clear"></div>
<label>Session<span>*</span></label> 
<%
			 Date currentSessionTime=new Date();
	SimpleDateFormat parser = new SimpleDateFormat("hh:mm a");
	String ct=parser.format(currentSessionTime);
	Date cur = parser.parse(ct);

	
%>
  <select id="opsession" name="opsession" validate="Session,string,yes" tabindex="1" onchange="getToken();">
			  <option value="0">Select</option>
 			
 </select> 
 
<%if(unitExisted!=null && unitExisted.size()>0){ %>
  <label>Unit</label> 
  <select id="HospitalUnit" name="HospitalUnit" onblur="getUnitDoctors(this.value)">
  <option value="0">Select</option>
  <%for(HospitalDoctorUnitM hospitalDoctorUnitM : unitExisted){%>
  <option value="<%=hospitalDoctorUnitM.getId()%>"><%=hospitalDoctorUnitM.getUnitCode()%></option>
  <% } %>
  </select>

<%} %>

<label>List of Duty Doctors</label> 
<select name="loddrs" id="loddrs" tabindex="1" validate="loddrs,metachar,no" >
	<option value="">select</option>
</select>

<input type="hidden" name="queueNo" id="queueNumberId" value="" tabindex="1" validate="queueNo,metachar,no"/>

<div class="clear"></div>
<div class="paddingTop5"></div>	
<div id="testDiv">

</div>

<div class="clear"></div>
<div class="paddingTop5"></div>			
<input type="button" name="Submit11" id="submitToken" style="display: none;" value="Submit" tabindex="" class="button" tabindex="1"   
			onClick="if(checkFilledField()){if(checkUnit() && minmaxDayCheck()){submitForm('OnlineAppointment','/hms/hms/appointment?method=submitPatientAppointment&appointmentType=')}}"/> <!-- appointmentDetail=W& -->
</form>
</div>

<%
if(!box.getString("futureConsultFlag").equalsIgnoreCase(""))
{
%>
</div>
<%}%>
<script type="text/javascript">
function checkUnit(){
	if(document.getElementById("HospitalUnit")!=null){
		if(document.getElementById("HospitalUnit").options.length>1){
			var unitExisted = document.getElementById("HospitalUnit").options.length;
			if(unitExisted>1){
				if(document.getElementById("HospitalUnit").value=="0"){
					alert("Please Select Unit!");
					return false;
				}
			}
		}
		
	}
	return true;
}
function checkFilledField(){
	var deptId = document.getElementById('departmentId').value;
	var OnlineToken=document.getElementById('preQueue').value;
	var result=false;
	if (deptId == "0") {
		alert("Select Service Center ");
		
		result= false;
	}
	else{
		result= true;
	}
	
	if (OnlineToken == 0) {
		
		alert("Select token number ");
		
		result= false;
	}
	else{
		result= true;
	}	
	return result;
	
}

var today = new Date();
today.setHours(0,0,0,0);

function checkAppointmentDate(){
	document.getElementById("preQueue").value=0;//added by govind 2017
	var splitDate = document.getElementById("appointmentDateId").value.split("/");
	var refDate = new Date(splitDate[2]+" "+splitDate[1]+" "+splitDate[0]);
	if (refDate <= today)
		{
		 alert('Must enter a future date')
		document.getElementById("appointmentDateId").value = ""; 
		 document.getElementById("appointmentDateId").focus();
		 return false;
		}
	//Added by Arbind on 14-12-2017
	//document.getElementById('opsession').selectedIndex = "0";
	document.getElementById('testDiv').innerHTML = "";
}
// added by govind on 10-01-2017
function minmaxDayCheck(){
	    var curDate = new Date();
		var departmentId = document.getElementById('departmentId').value;
	    var apptDateStr = document.getElementById("appointmentDateId").value;
	    var apptDate = new Date(apptDateStr.substring(6),
	    		(apptDateStr.substring(3, 5)-1), apptDateStr.substring(0, 2));
	
	    var minday=parseInt(document.getElementById("minday").value);
	    var maxday=parseInt(document.getElementById("maxday").value);
	
	    var actDate=addDays(curDate, minday);
	    var minStr=actDate.getDate()+"/"+(actDate.getMonth()+1)+"/"+actDate.getFullYear();
	    var minDate=addDays(curDate, minday-1);
	    var maxDate=addDays(curDate, maxday);
	    var maxStr=maxDate.getDate()+"/"+(maxDate.getMonth()+1)+"/"+maxDate.getFullYear();
	
	
	
	    var c=1;
	    if(apptDate>=minDate){
	    }else{
	    	c++;
	    }
	    if(apptDate<=maxDate){
	    }else{
	    	c++;
	    }

	    if(apptDateStr!=''){
	    if(c==1){
	    	return true;
	    }else if(departmentId!=='0'){
	    	alert("Please select Appointment date between "+minStr+" and "+maxStr);
	    	document.getElementById("appointmentDateId").value="";
	    	document.getElementById("preQueue").value=0;
	    	if(document.getElementsByClassName('cmntable'))
	    		document.getElementsByClassName('cmntable')[0].innerHTML = ''; 
	    	return false;
	    }
	    }
}

function addDays(date, days) {
    var result = new Date(date);
    result.setDate(result.getDate() + days);
    return result;
}
// added by govind on 10-01-2017 end

function fnGetDoctorDepartment() {
	var departmentId = document.getElementById('departmentId').value;
	var hospitalId='<%=session.getAttribute("hospitalId")%>';
	new Ajax.Request(
			'opd?method=getDoctorDepartment&departmentId=' + departmentId+ '&hospitalId=' + hospitalId + '&'
					+ csrfTokenName + '=' + csrfTokenValue,
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						document.getElementById('loddrs').innerHTML = response.responseText
								.trim();
					}
				}
			});
	
	
}


function getServiceCentreSession(){
	var departmentId = document.getElementById('departmentId').value;
	var appointmentDate =document.getElementById("appointmentDateId").value;
	alert("departmentId"+departmentId);
	document.getElementById('testDiv').innerHTML='';
	var hospitalId='<%=session.getAttribute("hospitalId")%>';
	if(departmentId!="0"){
		new Ajax.Request(
				'appointment?method=getServiceCentreSession&departmentId=' + departmentId+ '&hospitalId=' + hospitalId +'&appointmentDate=' + appointmentDate +'&'
						+ csrfTokenName + '=' + csrfTokenValue,
				{
					onSuccess : function(response) {
						if (response.responseText.trim() != '') {
							var data=response.responseText;
							var dt=data.toString();
							var result = dt.slice(1, -1);
							
							var session=result.split(",");
							document.getElementById('opsession').options.length = 1;
							var select = document.getElementById('opsession');
					
							for(var index=0;index<session.length;index++){
								
								var sessionData=session[index].split(":");
								var opt = document.createElement('option');
								opt.value = sessionData[0].trim();
							    opt.innerHTML = sessionData[1].trim();
							    select.appendChild(opt);
							    
							}
							
						}
					}
				});
	}
		
}

function getDoctorUnit(){
	var departmentId=document.getElementById("departmentId").value;
	var hospitalId='<%=session.getAttribute("hospitalId")%>';
	var appointmentDate=document.getElementById("appointmentDateId").value;
	document.getElementById('HospitalUnit').options.length = 1;
	if(appointmentDate!=""&&departmentId!="0"){
		new Ajax.Request(
				'opd?method=getDoctorUnit&departmentId=' + departmentId+ '&hospitalId=' + hospitalId +'&appointmentDate='+appointmentDate+ '&'
						+ csrfTokenName + '=' + csrfTokenValue,
				{
					onSuccess : function(response) {
						if (response.responseText.trim() != '') {
							var data=response.responseText;
							var dt=data.toString();
							var result = dt.slice(1, -1);
							
							var unitData=result.split(",");
							//document.getElementById('HospitalUnit').options.length = 1;
							var select = document.getElementById('HospitalUnit');
					
							for(var index=0;index<unitData.length;index++){
								
								var hospUnitData=unitData[index].split(":");
								var opt = document.createElement('option');
								opt.value = hospUnitData[0].trim();
							    opt.innerHTML = hospUnitData[1].trim();
							    select.appendChild(opt);
							    
							}
							if(document.getElementById('HospitalUnit').options.length>1){
								document.getElementById('HospitalUnit').selectedIndex=1;
								//Added by Arbind on 14-12-2017
								var unitId = document.getElementById('HospitalUnit').value;
								getUnitDoctors(unitId);
							}
							
						}
						
					}
				});
	}
	  
		
}

function getUnitDoctors(unitId){
	if(unitId=="0" || unitId==""){
		return;
	}
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var data=this.responseText;
	    	
	    	var dt=data.toString();
			var result = dt.slice(1, -1);
			
			var unitData=result.split(",");
			
			document.getElementById('loddrs').options.length = 1;
			var select = document.getElementById('loddrs');
			
	
			for(var index=0;index<unitData.length;index++){
				
				var hospUnitData=unitData[index].split(":");
				var opt = document.createElement('option');
				opt.value = hospUnitData[0].trim();
			    opt.innerHTML = hospUnitData[1].trim();
			    select.appendChild(opt);
			    
			}
	    }
	  };
	  xhttp.open("GET", "opd?method=getUnitDoctors&unitId="+ unitId, true);
	  xhttp.send();
	
	
}

</script>

<script>
function validateExpDate(dt,fieldId){
	
	if(dt.value!=""){
	if (isDate(dt.value,fieldId)==false){
	return false;
	}else if(isDate(dt.value,fieldId)==true){
		
	}else{
		return false;	
	}
	}
	
	return true
	}
	
	function isDate(dtStr,fieldId){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strDay=dtStr.substring(0,pos1)
	var strMonth=dtStr.substring(pos1+1,pos2)
	
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
	if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)
	if (pos1==-1 || pos2==-1){
	alert("The date format should be : DD/MM/YYYY" );
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (strMonth.length<1 || month<1 || month>12){
	alert("Please enter a valid month");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (strDay.length<1 || day<1 || day>31 || day > daysInMonth[month]){
	alert("Please enter a valid day");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
	alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear+"");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
	alert("Please enter a valid date ");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	return true
	}
	
	function getCounterTiming(){
		var deptId = document.getElementById('departmentId').value;
		if(deptId=="0" || deptId==""){
			return;
		}
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var data=this.responseText;
		    	
		    	var dt=data.toString();
				var result = dt.slice(1, -1);
				
				var timeData=result.split(",");
				
				document.getElementById('visitTime').options.length = 1;
				var select = document.getElementById('visitTime');
		
				for(var index=0;index<timeData.length;index++){
					// var hospUnitData=unitData[index].split(":");
					var timeSlotData=timeData[index].split("=");
					var opt = document.createElement('option');
					opt.value = timeSlotData[0].trim();
				    opt.innerHTML = timeSlotData[1].trim();
				    select.appendChild(opt);
				    
				}
		    }
		    getMinMaxDays();
		  };
		  // xhttp.open("GET", "appointment?method=getCounterTimingForDepartment&department="+deptId, true);
		  xhttp.open("GET", "appointment?method=getCounterTimingForDepartmentNew&department="+deptId, true);
		  xhttp.send();
	}
	
	function getMinMaxDays(){
		var deptId = document.getElementById('departmentId').value;
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var data=this.responseText;
		    	var dayData = data.split(",");
				
				if(dayData[0]!='null'){
					document.getElementById('minday').value = dayData[0];
				}
		
				if(dayData[1]!='null'){
					document.getElementById('maxday').value = dayData[1];
				}
				minmaxDayCheck();
		    }
		  };
		  xhttp.open("GET", "registration?method=getMinMaxDaysForAppointment&deptId="+deptId, true);
		  xhttp.send();
	}
	
	function getToken(){
		var apdate =document.getElementById("appointmentDateId").value;
		submitProtoAjax('OnlineAppointment','/hms/hms/appointment?method=getPriorityQueueByDepartId&appointmentDate='+apdate);
	 	var url='/hms/hms/appointment?method=getPriorityQueueByDepartId&appointmentDate='+apdate+'&'+getNameAndData('OnlineAppointment');
 	 	var xhttp = new XMLHttpRequest();
		 xhttp.onreadystatechange = function() {
		 if (this.readyState == 4 && this.status == 200) {
		    	var data=this.responseText;
		    	if(data!=''){
		    		document.getElementById('testDiv').innerHTML = data;
		    		document.getElementById('submitToken').style.display = 'block'; 
		    	}else{
		    		document.getElementById('submitToken').style.display = 'none';
		    	}
		    }
		  };
		  xhttp.open("GET",url , true);
		  xhttp.send();
	}
	
	function daysInFebruary(m, y) {
		   return /8|3|5|10/.test(--m)?30:m==1?(!(y%4)&&y%100)||!(y%400)?29:28:31;
		}
	
	function getSessionForDepartment(appointmentTime){
		var deptId = document.getElementById('departmentId').value;
		var apdate =document.getElementById("appointmentDateId").value;
		appointmentTime = apdate+" "+appointmentTime+ " a";
		  if(deptId!="0"){
			  var xhttp = new XMLHttpRequest();
			   xhttp.onreadystatechange=function() {
				  
			    if (xhttp.readyState == 4 && xhttp.status == 200) {
			    	var data=this.responseText;
			    	var dt=data.toString();
					var result = dt.slice(1, -1);
					var deptData="";
					if(result!=""){
						deptData=result.split(",");
					}
					var select;
					if(document.getElementById('opsession')){
						document.getElementById('opsession').options.length = 0;
						select = document.getElementById('opsession');
					}
					
					for(var index=0;index<deptData.length;index++){
						var departmentData=deptData[index].split(":");
						var opt = document.createElement('option');
						opt.value = departmentData[0].trim();
						opt.innerHTML = departmentData[1].trim();
					    select.appendChild(opt);
						
					}
			    }
			   
			  }; 
			  xhttp.open("GET", "/hms/hms/appointment?method=getSessionForDepartment&deptId="+deptId+'&appointmentTime='+appointmentTime,true);
			  xhttp.send();
		  }
	}
	
	function openCalender(){
			setdate('<%=currentDate %>',document.OnlineAppointment.appointmentDate,event);
	}
	

	function patientDetails(hinNo) {
	var xmlHttp=null;
	try {
	// Firefox, Opera 8.0+, Safari
	xmlHttp=new XMLHttpRequest();
	}catch (e){
	// Internet Explorer
	try{
	xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	}catch (e){
		alert(e)
	try{
	 xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}catch (e){
	 alert("Your browser does not support AJAX!");
	 return false;
	}
	}
	}
	xmlHttp.onreadystatechange=function()
	{
	if(xmlHttp.readyState==4){
		var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		var serviceCenterId = 0;
		for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	   	   
	       var uhid  = item.getElementsByTagName("Uhid")[0];
	       var name  = item.getElementsByTagName("name")[0];
	       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
	       var age  = item.getElementsByTagName("page")[0];
	       var Gender  = item.getElementsByTagName("Gender")[0];
	     
		 	if(age !=undefined && age.childNodes[0] !=undefined){
		   		document.getElementById("ageId").value = age.childNodes[0].nodeValue;
		   	 	openCalender();
		 	}
		   document.getElementById("pnameId").value = name.childNodes[0].nodeValue;
		   if(mobileNo.childNodes[0] !=undefined)
		   document.getElementById("mobileNoId").value = mobileNo.childNodes[0].nodeValue;
		   document.getElementById("genderId").value = Gender.childNodes[0].nodeValue;
		   
		   if(item.getElementsByTagName("serviceCemterId")[0]){
			 serviceCenterId =   item.getElementsByTagName("serviceCemterId")[0].childNodes[0].nodeValue;
			 document.getElementById('departmentId').value = serviceCenterId;
			 getCounterTiming();
		   }
		  
		   
		   
		}
	}
	}
	var url="/hms/hms/registration?method=populatePatientVisitDetail&patientHinNo="+hinNo;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	xmlHttp.open("GET",url,false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

	}
</script>