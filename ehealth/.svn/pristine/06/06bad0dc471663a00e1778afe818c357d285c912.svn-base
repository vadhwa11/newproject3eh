<%@page import="java.util.LinkedHashMap"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
<%@page import="java.util.Map.Entry"%>
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
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>


<script type="text/javascript">
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Review</title>

<%
Map<String, Map<String,Object>> tokenCounterTimeSlotmap = new LinkedHashMap<String, Map<String,Object>>();
Box box=HMSUtil.getBox(request);
String uhid="";
int deptId=0;
int empId=0;
int reviewInterval=0;
String appointmentDate= null;

if(!box.getString("uhid").equalsIgnoreCase(""))
{
	uhid=box.getString("uhid");
}
if(!box.getString("deptId").equalsIgnoreCase(""))
{
	deptId=box.getInt("deptId");
}
if(!box.getString("futureConsultFlag").equalsIgnoreCase(""))
{
%>
<meta http-equiv="refresh" content="${pageContext.session.maxInactiveInterval};url=/hms/hms/login?method=logout"/>	
<script src="/hms/jsp/js/dynamic-window-height/jquery.min.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<%}%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="/hms/jsp/js/jquery-ui.js" type="text/javascript"></script>


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
function getPriorityNumber(element){
	var priorityNo = element.value;
	var fieldSetElementId = element.parentElement.id;
	var property=document.getElementById("Id"+priorityNo);
	var visitTime = fieldSetElementId.substr(0,fieldSetElementId.indexOf(':'))+':00';
	document.getElementById('visitTime').value = visitTime;
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
            	document.getElementById("preQueue").value=0;
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

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}


if(map.get("tokenCounterTimeSlotmap") != null){
	tokenCounterTimeSlotmap = (Map<String,Map<String,Object>>)map.get("tokenCounterTimeSlotmap");
}

int opSession = 0;
if(map.get("opSession") != null){
	opSession = (Integer)map.get("opSession");
}


String futureConsultationFlag="";
if (map.get("futureConsultationFlag") != null) 
{
	futureConsultationFlag = (String) map.get("futureConsultationFlag");
}
if (map.get("uhid") != null) 
{
	uhid = (String) map.get("uhid");
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
if(map.get("empId") != null) {
	empId = (Integer) map.get("empId");
}

if(map.get("reviewInterval") != null) {
	reviewInterval = (Integer) map.get("reviewInterval");
}

if(map.get("appointmentDate") != null) {
	appointmentDate = HMSUtil.convertDateToStringWithoutTime((Date)map.get("appointmentDate"));
}

int minday = 0;
if(map.get("minday") != null) {
	minday = (Integer) map.get("minday");
}

int maxday = 0;
if(map.get("maxday") != null) {
	maxday = (Integer) map.get("maxday");
}

List<String> appSetupDaysList = null;
if(map.get("appSetupDaysList") != null) {
	appSetupDaysList = (List<String>) map.get("appSetupDaysList");
}
 
List<String> unitDays = null;
if(map.get("unitDays") != null) {
	unitDays = (List<String>) map.get("unitDays");
}
 

%>
<h2><%=futureConsultationFlag %></h2>
<div class="Block">
<form name="OnlineAppointment" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="loddrs" id="loddrs" value="<%=empId%>"><!-- Added by Arbind on 15-12-2017 -->
<input type="hidden" name="preQueue" id="preQueue" value="0" >
<input type="hidden" name="visitTime" id="visitTime" >
<input type="hidden" tabindex="1" name="uhid" value="<%=uhid %>" maxlength="20" validate="uhid,metachar,yes" onblur="patientDetails(this.value);"/>
<input type="hidden" name="department" id="departmentId" value="<%=deptId %>" />
<input type="hidden" tabindex="1" id="uhid" name="uhid" value="<%=uhid %>" maxlength="20" validate="uhid,metachar,yes" onblur="patientDetails(this.value);"/>
<input type="hidden" id ="days" name="days" value="" readonly="readonly" tabindex="1"/>
<input type="hidden" id ="currentDateId" name="currentDate" value="<%=currentDate %>" readonly="readonly" tabindex="1" validate="currentDate,date,no"/>
<input type="hidden" name="currentTime" value="<%=currentTime %>" readonly="readonly" tabindex="1"/>
<input type="hidden" id ="minday" name="minday" value="<%=minday %>" />
<input type="hidden" id ="maxday" name="maxday" value="<%=maxday %>" />
<select id="HospitalUnit" name="HospitalUnit" style="display:none">
<option value="0">Select</option>
</select> 





<div class="personRevHederFixed">
<div class="titleBg">
<h2>Personal Review</h2>
</div>
<div class="clear"></div>
<% if(appSetupDaysList!=null && appSetupDaysList.size()>0) {
	for(String appSetupDay : appSetupDaysList){	
		if(unitDays.contains(appSetupDay)){
%>
<input type="checkbox" style="display: none"  checked="checked" class="messageCheckbox" name=<%=appSetupDay.toLowerCase()%> />
<% }else {%>
<input type="checkbox" style="display: none" class="messageCheckbox" name=<%=appSetupDay.toLowerCase()%> />
<%  } 
   } 
} %>

<div class="paddingTop5"></div>
<label>Review Interval(Days)</label>
<input type="text" id="reviewInterval" name="reviewInterval" value="<%=reviewInterval%>" tabindex="0" style="width:35px;height:25px;" maxlength="3" onblur="if(checkFiled()){getTokensForReviewInterval();}">
<label>Appointment Date<span>*</span></label>
<%-- <input type="text" id="appointmentDateId" name="appointmentDate" value="<%=appointmentDate%>" style="height:25px;" class="date" tabindex="1" value="" onblur="if(checkAppointmentAvailability() && minmaxDayCheck(this.value)){checkAppointmentDate(); validateExpDate(this,'appointmentDateId'); getDoctorUnit(this);} " validate="Appointment Date,date,yes" maxlength="30">
<img id="" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('16/04/2018',document.OnlineAppointment.appointmentDate,event);" validate="Pick a date,date,no" tabindex="1"> --%>
<input type="text" id="appointmentDateId" name="appointmentDate" value="<%=appointmentDate%>" onchange="getTokensForPersonalReview();" style="height:25px;"  tabindex="1" validate="Appointment Date,date,yes" maxlength="30">
<label>Session<span>*</span></label>
<select id="opsession" name="opsession" validate="Session,string,yes" tabindex="1">
<!-- <option value="18">op</option> -->
</select>
<input type="button" name="Submit11" value="Submit" tabindex="" class="button" onclick="if(checkFilledField()){submitPersonalReview();}">

<h4 class="h4fixWidth">SELECT QUEUE PRIORITY</h4>
<div class="tokenMsgPopUp" id='tokenMsgPopUp'></div>
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="tokenDivQueMain" id="tokenDivQueMain">

<% for(Entry<String,Map<String,Object>> entry : tokenCounterTimeSlotmap.entrySet()) { 
	String timeSlot = 	entry.getKey();
	Map<String,Object> priorityQueueByDepartMap = entry.getValue();
	List<Integer> tokenList = (List<Integer>)priorityQueueByDepartMap.get("tokenList");
	
	
%>
<%if(tokenList.size()!=0){ %>
<fieldset id="<%=timeSlot%>">
<legend>
<%=timeSlot %>
</legend>

<tr>
<%
for(Integer tokenNo : tokenList){
%>
<input type="button" id="Id<%=tokenNo%>" name="OnlineToken" value="<%=tokenNo%>" onclick="getPriorityNumber(this)">
<%} %>
</tr>

</fieldset>
<%} %>
 
 <div class="clear"></div>
 <% } %>
 

</div>
</form>
<div id='submitResponse' style="display: none;"></div>
</div>


 
 <div id="successResponseDiv" class="white_content">
 	<p id="successMessage"></p>
	<br />	
	<input type="button" id="" name="" value="Close" onclick = "window.close();" style="margin-left:183px;">		
 </div>

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
	return result;
	
}


function changeReviewInterval(i){
	var selectedAppointmentDateStr	 =	i.value;
	var parts = selectedAppointmentDateStr.split('/');
	var selectedAppointmentDate = new Date(parts[2],parts[1]-1,parts[0]);
	var currentDate = new Date();
	var timeDiff = Math.abs(selectedAppointmentDate.getTime()-currentDate.getTime());
	var daysDiff = Math.ceil(timeDiff/(1000*60*60*24));
	document.getElementById('reviewInterval').value = daysDiff;
		
	console.log(selectedAppointmentDate);
	
}


	function getServiceCentreSession() {
		document.getElementById('testDiv').innerHTML = '';
		var hospitalId = '<%=session.getAttribute("hospitalId")%>'; 
	var departmentId=document.getElementById('departmentId').value;
	
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
					if(opt.value == <%=opSession%>){
						opt.selected = true; 
					}
						
				    select.appendChild(opt);
				}
		    }
		    
		  }; 
		  xhttp.open("GET", "/hms/hms/registration?method=getSessionForDepartment&appointType=personal'+&deptId="+deptId,true);
		  xhttp.send();
	  }
	  
}

getSessionForDepartment();



</script>

<script>

function minmaxDayCheck(apptDateStr){
	 
	if (apptDateStr.trim() != '') {
			var curDate = new Date();
			var apptDate = new Date(apptDateStr.substring(6), (apptDateStr
					.substring(3, 5) - 1), apptDateStr.substring(0, 2));

			var minday = parseInt(document.getElementById("minday").value);
			var maxday = parseInt(document.getElementById("maxday").value);

			var actDate = addDays(curDate, minday);
			var minStr = actDate.getDate() + "/" + (actDate.getMonth() + 1)
					+ "/" + actDate.getFullYear();
			var minDate = addDays(curDate, minday - 1);
			var maxDate = addDays(curDate, maxday);
			var maxStr = maxDate.getDate() + "/" + (maxDate.getMonth() + 1)
					+ "/" + maxDate.getFullYear();

			var c = 1;
			if (apptDate >= minDate) {
			} else {
				c++;
			}
			if (apptDate <= maxDate) {
			} else {
				c++;
			}

			if (c == 1) {
				return true;
			} else {
				alert("Please select Appointment date between " + minStr
						+ " and " + maxStr);
				document.getElementById("appointmentDateId").value = "";
				document.getElementById("preQueue").value = 0;
				return false;
			}
		}
	}

	function addDays(date, days) {
		var result = new Date(date);
		result.setDate(result.getDate() + days);
		return result;
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
			
			var unitData=result.split(",");
			
			document.getElementById('visitTime').options.length = 1;
			var select = document.getElementById('visitTime');
	
			for(var index=0;index<unitData.length;index++){
				var hospUnitData=unitData[index].split(":");
				var opt = document.createElement('option');
				opt.value = hospUnitData[0].trim()+":00";
			    opt.innerHTML = hospUnitData[1].trim();
			    select.appendChild(opt);
			    
			}
	    }
	  };
	  xhttp.open("GET", "appointment?method=getCounterTimingForDepartment&department="+deptId, true);
	  xhttp.send();
}

function getToken(){
	var apdate =document.getElementById("appointmentDateId").value;
	submitProtoAjax('OnlineAppointment','/hms/hms/appointment?method=getPriorityQueueByDepartId&appointmentDate='+apdate+'&appointType=personal');
}

function checkFiled(){
	var reviewIntervalId = document.getElementById('reviewInterval').value;
	if ( reviewIntervalId != '' && reviewIntervalId > 0 ) {
		if(isNaN(reviewIntervalId)){
			alert("The review interval contains illegal characters.");
			reviewInterval = "";
			reviewIntervalId.focus();
			return false;
		}else{
			return true;	
		}
		
	} else if(reviewInterval=='') {
		alert("Please Enter At Least One Digit ");
		return false;
	}
}

function getTokensForReviewInterval(){
	var reviewInterval = document.getElementById('reviewInterval').value;
	var currentDate = new Date();
	var appointmentDate = new Date(currentDate.getTime()+24*60*60*1000*parseInt(reviewInterval));
	var year = appointmentDate.getFullYear();
	var month = appointmentDate.getMonth()+1;
	var days = appointmentDate.getDate();
	if(month<10){
		month = '0'+month;
	}
	if(days<10){
		days = '0'+days;
	}
	
	
	if(minmaxDayCheck(days+"/"+month+"/"+year)){
	new Ajax.Request(
			'registration?method=showOnlineAppointmentPreviewResponseJsp&futureConsultFlag=1&uhid='+uhid+'&deptId='+departmentId+'&preference=reviewInterval'+'&'
					+ csrfTokenName + '=' + csrfTokenValue+'&'+getNameAndData('OnlineAppointment'),
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						var data=response.responseText;
						document.getElementById('tokenDivQueMain').innerHTML = data;
						var newAppointmentDate = document.getElementById('appointmentDateAfterInterval').value;
						document.getElementById('appointmentDateId').value = newAppointmentDate;
						document.getElementById('tokenMsgPopUp').innerHTML = '';
						findReviewdate();
					}
				}
			});
	}
}

function submitPersonalReview(){
	new Ajax.Request(
			'appointment?method=submitPatientAppointment&appointmentType=&Review=R'+'&'
					+ csrfTokenName + '=' + csrfTokenValue+'&'+getNameAndData('OnlineAppointment'),
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						var data=response.responseText;
						document.getElementById('submitResponse').innerHTML = data;
						var responseMsg = 	document.getElementById('message').value;
						if(responseMsg.indexOf('Appointment confirmed. Date of appoinment')>=0) {
							document.getElementById('successMessage').innerHTML = responseMsg;
							document.getElementById('successResponseDiv').style.display='block';document.getElementById('fade').style.display='block';
							document.getElementById('tokenMsgPopUp').innerHTML = '';
							//alert(responseMsg);
							//window.close();
						} else if(responseMsg.indexOf('already taken')>=0) {
							document.getElementById('tokenMsgPopUp').innerHTML = responseMsg;
							submitProtoAjaxWithDivName('OnlineAppointment','registration?method=showOnlineAppointmentPreviewResponseJsp&futureConsultFlag=1&uhid='+uhid+'&deptId='+departmentId+'&preference=appointmentDate','tokenDivQueMain');
							
						} else {
							document.getElementById('tokenMsgPopUp').innerHTML = responseMsg;
						}
						
					}
				}
			});
}

        Date.prototype.addDays = function(days) {
            this.setDate(this.getDate() + parseInt(days));
            return this;
        };
        Date.prototype.addWeeks = function(days) {
            this.setDate(this.getDate() + parseInt(days*7));
            return this;
        };
        
        Date.isLeapYear = function (year) { 
            return (((year % 4 === 0) && (year % 100 !== 0)) || (year % 400 === 0)); 
        };

        Date.getDaysInMonth = function (year, month) {
            return [31, (Date.isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][month];
        };

        Date.prototype.isLeapYear = function () { 
            return Date.isLeapYear(this.getFullYear()); 
        };

        Date.prototype.getDaysInMonth = function () { 
            return Date.getDaysInMonth(this.getFullYear(), this.getMonth());
        };

        Date.prototype.addMonths = function (months) {
            var n = this.getDate();
            var month = this.getMonth() ;
        
            this.setMonth(month);  
            
             this.setMonth(this.getMonth() + parseInt(months));
            this.setDate(Math.min(n, this.getDaysInMonth()));
            return this;
        };
        function convertDate(date) {
  var yyyy = date.getFullYear().toString();
  var mm = (date.getMonth()+1).toString();
  var dd  = date.getDate().toString();

  return mm + '/'+dd + '/' + yyyy;
  
  }
        function findReviewdate(){
                var today = new Date();
                today=calculateReviewDate(today,'txtOriginalResultLabel');
                $( "#appointmentDateId" ).datepicker('option', 'minDate', today);
                $( "#appointmentDateId" ).datepicker( "option", "numberOfMonths", 2);
                $( "#appointmentDateId" ).datepicker("show");
                document.getElementById('appointmentDateId').value = convertDate(today);
        }
        
        function calculateReviewDate(today,elementName){
               today.addDays(document.getElementById("reviewInterval").value);
                var day = today.getDay();
                 var inputElements = document.getElementsByClassName('messageCheckbox');
                 var dateSelected = false;
                 for (i=day;i<=7;i++){
        
                        if(i!=0 && inputElements[i-1] && inputElements[i-1].checked){
                                  dateSelected = true;
                           break;
                      }
                         else {
                              today.addDays(1);
                      }
                 }
                 if(!dateSelected){
                         
                         for (i=0;i<day;i++){
                                 if(inputElements[i].checked){
                                          dateSelected = true;
                                   break;
                              }else {
                                      today.addDays(1);
                              }
                         }                 
                 }
                 fillDates();
                   
                 return today;
                }
        
        function getTokensForPersonalReview(){
        	var uhid=document.getElementById("uhid").value;
        	var departmentId=document.getElementById('departmentId').value;
        	new Ajax.Request(
    				'registration?method=showOnlineAppointmentPreviewResponseJsp&futureConsultFlag=1&'+getNameAndData('OnlineAppointment')+'&uhid='+uhid+'&deptId='+departmentId+'&preference=appointmentDate'+'&'
    						+ csrfTokenName + '=' + csrfTokenValue,
    				{
    					onSuccess : function(response) {
    						if (response.responseText.trim() != '') {
    							var data=response.responseText;
    							document.getElementById('tokenDivQueMain').innerHTML = data;
    							document.getElementById('tokenMsgPopUp').innerHTML = '';
    						}
    					}
    				});
        	
        }

        function fillDates(){
        $('#appointmentDateId').datepicker({
            beforeShowDay: function( date ) {
                                var chckBoxes = document.getElementsByClassName('messageCheckbox');
                                
                                var day = date.getDay();
                                
                                if(day==0 )
                                {
                                day = 6 ;
                                }else
                                {
                                day = day-1;
                                }

                                if(chckBoxes[day] && chckBoxes[day].checked){
                                return [true, 'css-class-to-highlight'];
                                }else {

                                return [false, ''];
                                }

            },
			maxDate: '+<%=maxday%>d'
		});   
        }
        findReviewdate();
</script>

  <style>
  .black_overlay{
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index:1001;
	-moz-opacity: 0.6;
	opacity:.60;
	filter: alpha(opacity=60);
}

.white_content {
	display: none;
	position: absolute;
	top: 25%;
	left: 25%;
	width:440px;
	height:100px
	border-radius:5px;
	padding: 16px;
	border: 2px solid #0099BF;
	background-color: white;
	z-index:1002;
	overflow: auto;
}

#ui-datepicker-div .ui-corner-all .ui-datepicker-title span, #ui-datepicker-div table.ui-datepicker-calendar th span {color:#000 !important;}
.ui-datepicker-month {color:#000 !important;}
.ui-datepicker-year {color:#000 !important;}
/* .ui-state-hover .ui-icon,
.ui-state-focus .ui-icon {opacity: -5; background: url(/images/ui-icons_222222_256x240.png) -10px -2px; } */

 </style> 
