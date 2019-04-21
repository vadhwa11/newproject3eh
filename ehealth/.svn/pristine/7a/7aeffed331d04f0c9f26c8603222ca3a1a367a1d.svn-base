<%@page import="jkt.hms.masters.business.MasSession"%>
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

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dialysis Scheduling</title>

<%
Box box=HMSUtil.getBox(request);
String uhid="";
if(!box.getString("uhid").equalsIgnoreCase(""))
{
	uhid=box.getString("uhid");
}
%>

 
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
<!-- <script type="text/javascript">
function getPriorityNumber(priorityNo){
	
	var property=document.getElementById("Id"+priorityNo);
	//alert("You have Selected "+property.value+"Queue");
	//document.getElementById("queueNumberId").value=priorityNo;
	
	//document.getElementById("Id"+priorityNo).style.color = 'green';
		property.style.background = 'green';
		//property.style.color = 'green';
		
		//var checkQueue=document.getElementById("preQueue").value;
		
		
			var val=document.getElementById("preQueue").value;
			//alert(val);
			if(val>0){
			var ch=document.getElementById("preQueue").value;
			var propert=document.getElementById("Id"+ch);
			
			//document.getElementById("Id"+ch).style.color = '#0f75bf';
			propert.style.background = '#0f75bf';
			//propert.style.color = '#0f75bf';
			
			document.getElementById("preQueue").value=property.value;
			document.getElementById("Id"+ch).value=ch;
			}
			else{
				document.getElementById("preQueue").value=property.value;
				
			}
		
		
		
	
}
</script> -->
<script type="text/javascript">

            function check()
            {
                if (document.getElementById('appointmentDaysId').value==""
                 || document.getElementById('appointmentDaysId').value==undefined)
                {
                    alert ("Please Enter Appointment Days");
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

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}

if (map.get("uhid") != null) 
{
	uhid = (String) map.get("uhid");
}

if (map.get("departmentList") != null) 
{
	departmentList = (List<MasDepartment>) map.get("departmentList");
}



%>
<div class="titleBg">

<h2>Dialysis Scheduling</h2>


</div>

<div class="Block">


<form name="dialysisScheduling" method="post">

<input type="hidden" name="preQueue" id="preQueue" value="0">
<label>UHID<span>*</span></label> 
<input type="text" tabindex="1" name="uhid" value="<%=uhid %>" maxlength="20" validate="uhid,metachar,yes" />
<label>Days</label>
<select name=appointmentDays id="appointmentDaysId">
<option value="">Select</option>
<option value="Sunday">Sunday</option>
<option value="Monday">Monday</option>
<option value="Tuesday">Tuesday</option>
<option value="Wednesday">Wednesday</option>
<option value="Thursday">Thursday</option>
<option value="Friday">Friday</option>
<option value="Saturday">Saturday</option>

</select>

<%-- <label>Appointment Date<span>*</span></label> <input type="text" id="appointmentDateId" onblur="checkAppointmentDate(); validateExpDate(this,'appointmentDateId')"
					   onkeyup="mask(this.value,this,'2,5','/');" 
                               name="appointmentDate" tabindex="1" 
                               value="" class="date"
                               validate="Appointment Date,date,yes"
                                onchange=""
                               MAXLENGTH="30" />

                       <div id="sdobcalId">
                               <img id="" src="/hms/jsp/images/cal.gif" width="16" height="16"
                                       border="0"
                                       onclick="setdate('<%=currentDate %>',document.dialysisScheduling.appointmentDate,event)"
                                       validate="Pick a date,date,no" 
                                        tabindex="1" />
                       </div>
  --%>
 
<%--  <label>Date</label><input type="text" name="currentDate" value="<%=currentDate %>" readonly="readonly" tabindex="1" validate="currentDate,date,no"/> --%>

<label>Service Center<span>*</span></label> 
	<select name="department" tabindex="1" id="departmentId" validate="department,metachar,yes" 	onchange="if(check()){submitProtoAjax('dialysisScheduling','/hms/hms/appointment?method=getPriorityQueueByDepartIdDialysis')}">
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
 
 
<div class="clear"></div>
 
<%-- <label>Time</label><input type="text" name="currentTime" value="<%=currentTime %>" readonly="readonly" tabindex="1"/> --%>






<label>Mobile No.</label> 
<input type="text" name="mob" maxlength="13" tabindex="1" validate="mob,phone,no"/>

<input type="hidden" name="queueNo" id="queueNumberId" value="" tabindex="1" validate="queueNo,metachar,no"/>

<div class="clear"></div>


<h4>Select Queue Priority</h4>
<div id="testDiv">

</div>
		
<input type="hidden" name="<%=FROMTIMESLOT%>" id="f" value="" tabindex="1"/>
		
<input type="hidden" name="<%=TOTIMESLOT%>"  id="t" value="" tabindex="1"/>
			
<input type="button" name="Submit11" value="Submit" tabindex="" class="button" tabindex="1"		onClick="if(checkFilledField()){submitForm('dialysisScheduling','/hms/hms/appointment?method=submitDialysisScheduling')}"/>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>

<script type="text/javascript">
function getPriorityNumber(priorityNo){
	//alert("dsfdsf");

	var property=document.getElementById("Id"+priorityNo);
	var f=document.getElementById("fromTimeSlot"+priorityNo).value;
	var t=document.getElementById("toTimeSlot"+priorityNo).value;
		
		property.style.background = 'green';

		
			var val=document.getElementById("preQueue").value;
			//alert("val=="+val);
			if(val>0){
			var ch=document.getElementById("preQueue").value;
			var propert=document.getElementById("Id"+ch);
			
		
			propert.style.background = '#0f75bf';
			
			document.getElementById("preQueue").value=property.value;
			document.getElementById("Id"+ch).value=ch;
			}
			else{
				document.getElementById("preQueue").value=property.value;
				
			}
			document.getElementById("f").value=f;
			document.getElementById("t").value=t;
		
		
	
}
</script>
<script type="text/javascript">

function checkFilledField(){
	var deptId = document.getElementById('departmentId').value;
	var OnlineToken=document.getElementById('preQueue').value;
	
	if (deptId == "0") {
		alert("Select Service Center ");
		
		return false;
	}
	else{
		return true;
	}
	
	if (OnlineToken == 0) {
		
		alert("Select Time ");
		
		return false;
	}
	else{
		return true;
	}
	
	
}

var today = new Date();
today.setHours(0,0,0,0);

function checkAppointmentDate(){

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
</script>

