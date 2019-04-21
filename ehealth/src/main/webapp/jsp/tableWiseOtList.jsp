<%@page import="jkt.hms.masters.business.OtBookSurgeon"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@ page import="jkt.hms.masters.business.MasDepartment" %>
<%@ page import="jkt.hms.masters.business.HospitalDoctorUnitM" %>
<%@ page import="jkt.hms.masters.business.MasEmployee" %>
<%@ page import="jkt.hms.masters.business.MasBed" %>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript">
<%
Box box = HMSUtil.getBox(request);
Map<String, Object> utilMap = new HashMap<String, Object>();
Map<String, Object> map = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
Date toDate  = new Date();
Date fromDate = new Date();

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
serverdate = '<%=date+"/"+month+"/"+year%>';
</script>
<script type="text/javascript" language="javascript">

<%
Map<String, Object> DataMap = new HashMap<String, Object>();

if (request.getAttribute("map") != null) {
	DataMap = (Map<String, Object>) request.getAttribute("map");
}

List<OtBooking> otBookingList=new ArrayList<OtBooking>();
if(DataMap.get("otBookingList")!=null){
	otBookingList=(List<OtBooking>)DataMap.get("otBookingList");
}

Date fromDate2=null;
Date toDate2=null;

if(DataMap.get("fromDate")!=null){
	fromDate2=(Date)DataMap.get("fromDate");
}
if(DataMap.get("toDate")!=null){
	toDate2=(Date)DataMap.get("toDate");
}
String fromDateStr="";
String toDateStr="";

if(fromDate2!=null){
	fromDateStr=HMSUtil.convertDateToStringTypeDateOnly(fromDate2);
}
if(toDate2!=null){
	toDateStr=HMSUtil.convertDateToStringTypeDateOnly(toDate2);
}

List<MasDepartment> theaterList=new ArrayList<MasDepartment>();
if(DataMap.get("theaterList")!=null){
	theaterList=(List<MasDepartment>)DataMap.get("theaterList");
}

List<HospitalDoctorUnitM> doctorUnitList = new ArrayList<HospitalDoctorUnitM>();
if(DataMap.get("doctorUnit")!=null){
	doctorUnitList=(List<HospitalDoctorUnitM>)DataMap.get("doctorUnit");
}

List<MasEmployee> doctorsList=new ArrayList<MasEmployee>();
if(DataMap.get("doctorsList")!=null){
	doctorsList=(List<MasEmployee>)DataMap.get("doctorsList");
}

int theaterId=0;
if(DataMap.get("theaterId")!=null){
	theaterId=(Integer)DataMap.get("theaterId");
}

int unitId=0;
if(DataMap.get("unitId")!=null){
	unitId=(Integer)DataMap.get("unitId");
}

int tableId=0;
if(DataMap.get("tableId")!=null){
	tableId=(Integer)DataMap.get("tableId");
}

int doctorId=0;
if(DataMap.get("doctorId")!=null){
	doctorId=(Integer)DataMap.get("doctorId");
}

MasBed table=null;
if(DataMap.get("table")!=null){
	table=(MasBed)DataMap.get("table");
}

%>

</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action=""  method="POST"  name="tableWiseOtList">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h2>OT Pending Patients</h2>
<div class="Block">
 <label class="medium"> From Date<span>*</span>
		</label> <input type="text" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=fromDateStr!=""?fromDateStr:currentDate %>" class="date" readonly="readonly"
			maxlength="30" validate="fromDate,date,yes" style="width:80px" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender"
			onclick="javascript:setdate('<%=currentDate %>',document.tableWiseOtList.<%=FROM_DATE%>,event)" />

		<label style="width:75px"> To Date<span>*</span>
		</label> <input type="text" id="ToDateId" name="<%=TO_DATE %>"
			value="<%=toDateStr!=""?toDateStr:currentDate %>" class="date" readonly="readonly"
			maxlength="30" validate="toDate,date,yes"  style="width:80px"/> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender"
			onclick="javascript:setdate('<%=currentDate %>',document.tableWiseOtList.<%=TO_DATE%>,event)" />
			
		<label style="width:110px">Operation Theater</label>
		<select id="theaterId" name="theaterId" style="width:150px">
		<option value="0">Select</option>
		<%if(theaterList.size()>0){for(MasDepartment theater:theaterList){ if(theaterId!=0 && theater.getId().equals(theaterId)){%>
		<option value="<%=theater.getId()%>" selected="selected"><%=theater.getDepartmentName() %></option>
		<%}else{ %>
		<option value="<%=theater.getId()%>"><%=theater.getDepartmentName() %></option>
		<%}} }%>
		</select>
		
		<label style="width:50px">Unit</label>
		<select id="unitId" name="unitId" style="width:150px" onchange="displayTable(this.value);">
		<option value="0">Select</option>
		<%if(doctorUnitList.size()>0){for(HospitalDoctorUnitM unit:doctorUnitList){ if(unitId!=0 && unit.getId().equals(unitId)){%>
		<option value="<%=unit.getId()%>" selected="selected"><%=unit.getUnitCode() %></option>
		<%}else{ %>
		<option value="<%=unit.getId()%>"><%=unit.getUnitCode() %></option>
		<% }}}%>
		</select>
		
		<label style="width:50px">Table</label>
		<select id="tableId" name="tableId" style="width:150px">
		<option value="0">Select</option>
		<%if(table!=null && table.getId().equals(tableId)){ %>
		<option value="<%=table.getId()%>" selected="selected"><%=table.getBedNo() %></option>
				<%} %>
		</select>
		
		<label style="width:85px">Doctor</label>
		<select id="doctorId" name="doctorId" style="width:150px">
		<option value="0">Select</option>
		<%if(doctorsList.size()>0){ for(MasEmployee doctor:doctorsList){ if(doctorId!=0 && doctor.getId().equals(doctorId)){ %>
		<option value="<%=doctor.getId()%>" selected="selected"><%=doctor.getEmployeeName() %></option>
		<%}else{ %>
		<option value="<%=doctor.getId()%>"><%=doctor.getEmployeeName() %></option>
		<%} }}%>
		</select>
		
			
<div class="clear"></div>			
<input type="button" name="OK" value="SEARCH" class="button" onclick="submitForm('tableWiseOtList','ot?method=showTableWiseOtList','validateFromToDate');">
<input type="button" onclick="printData();" value="PRINT">		
</div>

<div class="clear"></div><br>
<div class="cmnTable" id="cmnTable">

<%if(otBookingList.size()>0){ %>
<table id="tbl">
<thead>
<tr>
<th>Surgery Date</th>
<th>UHID</th>
<th>Patient Name</th>
<th>Surgery</th>
<th>Unit</th>
<th>Department</th>
<th>Doctor</th>
<th>Table</th>
</tr>
</thead>
<%for(OtBooking booking:otBookingList){ %>
<tr>
<td><%=HMSUtil.convertDateToStringTypeDateOnly(booking.getSurgeryDate())%></td>
<td><%=booking.getHin().getHinNo() %></td>
<td><%=booking.getHin().getPFirstName() %></td>
<td><%=booking.getOpdSurseryHeader().getOpdSurgeryDetails().iterator().next().getChargeCode().getChargeCodeName() %></td>
<td><%=booking.getUnit().getUnitCode() %></td>
<td><%=booking.getOpdSurseryHeader().getPrescribedDepartment().getDepartmentName() %></td>

<%int inc=0;int flag=booking.getOtBookSurgeons().size();for(OtBookSurgeon surgeon:booking.getOtBookSurgeons()){ if(surgeon.getRole()!=null&&surgeon.getRole().equalsIgnoreCase("Surgeon")){inc++;%>
<td><%=surgeon.getEmployee().getEmployeeName() %></td>
<% }else if(inc==0){ flag--;if(flag==0){%>
<td> </td>
<%}}} %>

<td><%=booking.getBed().getBedNo() %></td>
</tr>
<%} %>
</table>

<%}else{ %>
<h4>NO RECORDS FOUND</h4>
<%} %>

</div>

</form>
</body>
</html>
<script>

function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.tableWiseOtList.fromDate);
	obj2 = eval(document.tableWiseOtList.toDate);
		
	if(obj1.value != "" && obj2.value != "")
	{
	
	 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			
		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
						alert("From Date should be smaller than To Date\n");
					    return false;
				}
			}
			
		else
		{
				alert("From Date should not be greater than Current date\n");
			    return false;
		}
	
	}
	return true;
}

function displayTable(unitId){
	
	var theaterId=document.getElementById("theaterId").value;
	if(theaterId=="0"){
		alert("Please Select Theater !");
		return;
	}
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
	    	  var data=this.responseText;
		    	
		    	var dt=data.toString();
				var result = dt.slice(1, -1);
				
				var unitData=result.split(",");
				
				document.getElementById('tableId').options.length = 1;
				var select = document.getElementById('tableId');
				
		
				for(var index=0;index<unitData.length;index++){
					
					var hospUnitData=unitData[index].split(":");
					var opt = document.createElement('option');
					opt.value = hospUnitData[0].trim();
				    opt.innerHTML = hospUnitData[1].trim();
				    select.appendChild(opt);
				    
				}
	      }
	    }
	  

	       var url="/hms/hms/ot?method=displayOtTableForUnit&unitId="+unitId+"&fromtableWiseReport=yes"+"&theaterId="+theaterId;
 	 	//url = url+'&'+csrfTokenName+'='+csrfTokenValue;
	    xmlHttp.open("GET",url,false);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
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
			
			document.getElementById('doctorId').options.length = 1;
			var select = document.getElementById('doctorId');
			
	
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

function printData(){
	submitForm('tableWiseOtList','ot?method=PrintTableWisePatients','validateFromToDate');
}
</script>