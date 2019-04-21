<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@page import="jkt.hms.masters.business.MasOpSession"%>
<%@page import="jkt.hms.util.Box"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%--  <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript" src="/hms/JavaScriptServlet">
</script> --%>
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
<!-- <title>EHA Hospital Management System</title> -->
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
List<Object[]> doctorList = new ArrayList<Object[]>();

List<MasHospitalType> masHospitalTypeList=new ArrayList<MasHospitalType>();
List<MasDistrict> districtList = new ArrayList<MasDistrict>();
boolean unitExistance=false;


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

if (map.get("departmentList") != null) 
{
	departmentList = (List<MasDepartment>) map.get("departmentList");
}
if(map.get("doctorList") != null)
{
	doctorList = (List<Object[]>)map.get("doctorList");
}
if(map.get("recordExists")!=null)
{
        recordExists=(Boolean)map.get("recordExists");
}
List<MasSession> masSessionList=new ArrayList<MasSession>();
if(map.get("masSessionList")!=null)
{
	masSessionList=(List<MasSession>)map.get("masSessionList");
}
//added by govind 09-01-2017
List<MasEmployee> employeeByCategoryList = new ArrayList<MasEmployee>();
if(map.get("employeeByCategoryList")!= null){
	 employeeByCategoryList = (List<MasEmployee>)map.get("employeeByCategoryList");
}

if(map.get("districtList")!= null){
	districtList = (List<MasDistrict>)map.get("districtList");
}

if(map.get("masHospitalTypeList")!= null){
	masHospitalTypeList = (List<MasHospitalType>)map.get("masHospitalTypeList");
}

if(map.get("unitExistance")!=null){
	unitExistance=((Boolean) map.get("unitExistance")).booleanValue();
}
//added by govind 09-01-2017 end
int minday = 0;
int maxday = 0;
%>
<div class="titleBg">
<h2>Online Appointment</h2>
</div>

<h2><%=futureConsultationFlag %></h2>
<div class="Block">
<form name="otherHospitalOnlineAppointment" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" id ="minday" name="minday" value="<%=minday %>" />
<input type="hidden" id ="maxday" name="maxday" value="<%=maxday %>" />
<input type="hidden" name="preQueue" id="preQueue" value="0">

<label>UHID<span>*</span></label> 
<input type="text" tabindex="1" name="uhid" value="<%=uhid %>" maxlength="20" validate="uhid,metachar,yes" onblur="patientDetails(this.value);"/>

 <label>Patient Name</label> <input type="text"
			tabindex="1" name="pnameId" id="pnameId" maxlength="50"
			value="" readonly="readonly" style="width: 310px;" />	
			<div class="clear"></div>
			<label>Gender</label><input
			type="text" tabindex="1" name="gender" id="genderId" value=""
			readonly="readonly" />					
			
			<label>Age</label> <input type="text" tabindex="1" name="age"
			id="ageId" maxlength="3" value="" readonly="readonly" />
<label>Mobile No.</label> 
<input type="text" name="mob" id="mobileNoId" maxlength="13" tabindex="1" validate="mob,phone,no"/>
<div class="clear"></div>


                       
                       
                       <label>District</label>
<select name="district" tabindex="1" id="districtId">
<option value="0">Select</option>
<% for(MasDistrict masDistrict : districtList){%>
<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName() %></option>
<%}%>
</select>
                 
<%-- <label>District</label>
<select name="district" tabindex="1" id="districtId">
<option value="0">Select</option>
<% for(MasDistrict masDistrict : districtList){%>
<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName() %></option>
<%}%>
</select> --%>

<label>Hospital Type</label>
<select name="hospitalType" tabindex="1" id="hospitalTypeId"  
onChange="Javascript: populMasHospitalNameByType(this.value);">
<option value="0">Select</option>
<% for(MasHospitalType masHospitalType : masHospitalTypeList){%>
<option value="<%=masHospitalType.getId() %>"><%=masHospitalType.getHospitalTypeName() %></option>
<%}%>
</select>

<label>Hospital Name<span>*</span></label>
<select name="hospitalName" tabindex="1" id="hospitalNameId" onchange="getServiceCenter(this.value);getSessionByHospital(this.value);" >
<option value="0">Select</option>
</select>

<div class="clear"></div>
 
 
<%--	 <label>Date</label> 
<label>Time</label>--%>
<input type="hidden" name="currentDate" value="<%=currentDate %>" readonly="readonly" tabindex="1" validate="currentDate,date,no"/>
 <input type="hidden" name="currentTime" value="<%=currentTime %>" readonly="readonly" tabindex="1"/>
<label>Service Center<span>*</span></label> 
<select name="department" tabindex="1" id="departmentId" validate="department,metachar,yes"
	onchange="getCounterTiming(this.value);getServiceCentreSession(this.value);getDoctorUnit(this.value);fnGetDoctorDepartment(this.value);"
	onblur="">
	<option value="0">Select</option>
	</select>

<label>Appointment Date<span>*</span></label> <input type="text" id="appointmentDateId" onblur="checkAppointmentDate(); validateExpDate(this,'appointmentDateId')"
					   onkeyup="mask(this.value,this,'2,5','/');" 
                               name="appointmentDate" tabindex="1" 
                               value="" class="date"
                               validate="Appointment Date,date,yes"
                                onchange=""
                               MAXLENGTH="30" />

                       <div id="sdobcalId">
                               <img id="" src="/hms/jsp/images/cal.gif" width="16" height="16"
                                       border="0"
                                       onclick="setdate('<%=currentDate %>',document.otherHospitalOnlineAppointment.appointmentDate,event)"
                                       validate="Pick a date,date,no" 
                                        tabindex="1" />
                       </div>
                       
                        <label>Appointment Time<span>*</span></label>
<%-- <input type="text" name="appointmentTime" value="<%=currentTime %>" onKeyUp="mask(this.value,this,'2',':');" tabindex="1"/> --%>
<!-- <select name="visitTime" tabindex="1" id="visitTime" validate="visitTime,metachar,yes"> -->
<select name="visitTime" tabindex="1" id="visitTime" validate="visitTime,string,yes" onblur="getToken();getSessionForDepartment();">
<option value="">select</option>

</select>

<div id="unitDiv" style="display:none">
<label>Unit</label>
<select name="HospitalUnit" id="HospitalUnit" onchange="getUnitDoctors(this.value);">
<option value="0">Select</option>
</select>
</div>
	
<label>Session<span>*</span></label> 
<div id="divSession">
 <%
			 Date currentSessionTime=new Date();
	SimpleDateFormat parser = new SimpleDateFormat("hh:mm a");
	String ct=parser.format(currentSessionTime);
	Date cur = parser.parse(ct);
	
%>
 <select id="opsession" name="opsession" validate="Session,string,yes" tabindex="1" onchange="submitProtoAjax('otherHospitalOnlineAppointment','/hms/hms/appointment?method=getPriorityQueueByDepartIdOtherHosp')">
			<option value="0">Select</option>
			<%--  <%if(null !=masSessionList && masSessionList.size()>0) {
			for(MasSession masSession:masSessionList){ 
					
					 Date fromTime = parser.parse(masSession.getFromTime());
					Date toTime = parser.parse(masSession.getToTime());
					
					 
					if(cur.after(fromTime) && cur.before(toTime)){
				%>
				<option value="<%=masSession.getId()%>"><%=masSession.getSessionName()%></option>
				<%}} %>
			
			<%} %> --%>
			</select> 
</div>

<label>List of Duty Doctors</label> <select
				name="loddrs" id="loddrs" tabindex="1" validate="loddrs,metachar,no" >
				<option value="">select</option>

 <%for(MasEmployee md : employeeByCategoryList){ %>
     <option value="<%=md.getId()%>"><%=md.getEmployeeName()%></option>
     <%} %> 
			</select>

<input type="hidden" name="queueNo" id="queueNumberId" value="" tabindex="1" validate="queueNo,metachar,no"/>

<div class="clear"></div>
<div class="paddingTop5"></div>	

<div id="testDiv">

</div>


<div class="clear"></div>
<div class="paddingTop5"></div>			
<input type="button" name="Submit11" value="Submit" tabindex="" class="button" tabindex="1"
			onClick="if(checkFilledField() && minmaxDayCheck()){submitForm('otherHospitalOnlineAppointment','/hms/hms/appointment?method=submitPatientAppointment&appointmentType=otherHospitalApp')}"/>
</form>
</div>

<%
if(!box.getString("futureConsultFlag").equalsIgnoreCase(""))
{
%>
</div>
<%}%>
<script type="text/javascript">

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
	
	if(document.getElementById('HospitalUnit')!=null && document.getElementById('HospitalUnit').options.length >1){
		if(document.getElementById('HospitalUnit').value=="0" || document.getElementById('HospitalUnit').value==""){
			alert("Please Select Unit !");
			result= false;
		}
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
}
// added by govind on 10-01-2017
function minmaxDayCheck(){
	    var curDate = new Date();

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

	    if(c==1){
	    	return true;
	    }else{
	    	alert("Please select Appointment date between "+minStr+" and "+maxStr);
	    	document.getElementById("appointmentDateId").value="";
	    	document.getElementById("preQueue").value=0;

	    	if(document.getElementsByClassName('cmntable'))
	    		document.getElementsByClassName('cmntable')[0].innerHTML = '';
	    	return false;
	    }
}

function addDays(date, days) {
    var result = new Date(date);
    result.setDate(result.getDate() + days);
    return result;
}

// added by govind on 10-01-2017 end

//added by govind on 21-05-2017
function getServiceCenter(id){

	submitProtoAjaxWithDivName('otherHospitalOnlineAppointment','/hms/hms/registration?method=getServiceCenterByHospital&hospitalId='+id,'departmentId');
	
}
function fnGetDoctorDepartment(departmentId) {
	var hospitalId = document.getElementById('hospitalNameId').value;
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

function getSessionByHospital(id){
	var sesParam="id=\"opsession\" name=\"opsession\" validate=\"Session,string,yes\" tabindex=\"1\"";
	document.getElementById('testDiv').innerHTML='';
	//	submitProtoAjaxWithDivName('otherHospitalOnlineAppointment','/hms/hms/registration?method=getSessionByHospital&hospitalId='+id+'&jspParam='+sesParam,'divSession');
}
//added by govind on 21-05-2017 end

function getDoctorUnit(departmentId){
	var hospitalId=document.getElementById("hospitalNameId").value;
	var appointmentDate=document.getElementById("appointmentDateId").value;
	document.getElementById('HospitalUnit').options.length = 1;
	<%-- var unitExisting="<%=unitExistance%>"; --%>
	isUnitExist(hospitalId);
	if(appointmentDate!=""&&departmentId!="0" && document.getElementById('HospitalUnit')!=null){

		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange=function() {
			  
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
		    	var response=xhttp.responseText;
		    	if (response.trim() != '') {
					var data=response;
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
					/* if(document.getElementById('HospitalUnit').options.length >1){
						document.getElementById('HospitalUnit').selectedIndex="1";
						getUnitDoctors(document.getElementById('HospitalUnit').value);
					} */
				}
		    }
		  };
		  xhttp.open("GET", '/hms/hms/registration?method=getDoctorUnit&departmentId=' + departmentId+ '&hospitalId=' + hospitalId +'&appointmentDate='+appointmentDate, true);
		  xhttp.send();
	}
	  
}

function isUnitExist(hospitalId){
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange=function() {
		  
	    if (xhttp.readyState == 4 && xhttp.status == 200) {
	    	var response=xhttp.responseText;
	    	if (response.trim() != '') {
				var data=response;
				var dt=data.toString();
				if(dt=="yes"){
					document.getElementById("unitDiv").style.display='block';
				}else if(dt=="no"){
					document.getElementById("unitDiv").style.display='none';
				}
				
			}
	    }
	  };
	  xhttp.open("GET", '/hms/hms/registration?method=isUnitExist&hospitalId=' + hospitalId, true);
	  xhttp.send();
}

function getUnitDoctors(unitId){
	document.getElementById('loddrs').options.length = 1;
	if(unitId=="0" || unitId==""){
		return;
	}
	var hospitalId=document.getElementById("hospitalNameId").value;
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var data=this.responseText;
	    	
	    	var dt=data.toString();
			var result = dt.slice(1, -1);
			
			var unitData=result.split(",");
			
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
	  xhttp.open("GET", "/hms/hms/registration?method=getUnitDoctors&unitId="+ unitId+"&hospitalId="+hospitalId, true);
	  xhttp.send();
	
	
}

function getMinMaxDays(){
	var deptId = document.getElementById('departmentId').value;
	var hospitalId = document.getElementById('hospitalNameId').value;
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
			
	    }
	  };
	  xhttp.open("GET", "registration?method=getMinMaxDaysForAppointment&deptId="+deptId+"&hospitalName="+hospitalId, true);
	  xhttp.send();
}


function getServiceCentreSession(departmentId){
	var hospitalId=document.getElementById('hospitalNameId').value;
	if(departmentId!="0"){
		new Ajax.Request(
				'appointment?method=getServiceCentreSession&departmentId=' + departmentId+ '&hospitalId=' + hospitalId +'&'
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

function validateExpDate(dt,fieldId){
	
	if(dt.value!=""){
	if (isDate(dt.value,fieldId)==false){
	return false;
	}else if(isDate(dt.value,fieldId)==true){
		//getSessionForDepartment();
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
	
	function getSessionForDepartment(){
		var deptId = document.getElementById('departmentId').value;
		var apdate =document.getElementById("appointmentDateId").value;
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
			  xhttp.open("GET", "/hms/hms/registration?method=getSessionForDepartment&deptId="+deptId,true);
			  xhttp.send();
		  }
	}
	
	function getCounterTiming(){
		var deptId = document.getElementById('departmentId').value;
		var hospitalId = document.getElementById('hospitalNameId').value;
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
		  xhttp.open("GET", "appointment?method=getCounterTimingForDepartmentNew&department="+deptId+"&hospitalId="+hospitalId, true);
		  xhttp.send();
	}
	
	function getToken(){
		var apdate =document.getElementById("appointmentDateId").value;
		submitProtoAjax('otherHospitalOnlineAppointment','/hms/hms/appointment?method=getPriorityQueueByDepartIdOtherHosp&appointmentDate='+apdate);
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
									var unitId = document.getElementById('HospitalUnit').value;
									getUnitDoctors(unitId);
								}
								
							}
							
						}
					});
		}
		  
			
	}
</script>