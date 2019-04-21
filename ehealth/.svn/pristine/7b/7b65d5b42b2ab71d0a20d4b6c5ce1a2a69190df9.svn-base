<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.net.URL"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
List<AppPatientAppointments> patientAppointList = new ArrayList<AppPatientAppointments>();
if(map.get("patientAppointList") != null){
	patientAppointList = (List<AppPatientAppointments>)map.get("patientAppointList");
}
%>
<div class="clear"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="patientList" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
 <script type="text/javascript">
	<%-- formFields = [
	[0, "appId", "id"],[1, "<%=RADIO_FOR_TABLE%>"],[2,"<%=PATIENT_NAME%>"], [3,"<%=Age %>"], [4,"<%= SEX %>"],[5,"appointmentTime"]]; --%>
	
</script></div>
<div id="edited"></div>
<div id="statusMessage">
<h4></h4>
</div>


	<div class="clear"></div>
	<div class="division"></div>
		
	
	
	<table>
	
	<tr>
	<th>UHID</th>
	<th>Patient Name</th>
	<th>Department</th>
	<th>Hospital</th>
	<th>Appointment Date</th>
	</tr>
	<%
	int  i=0;
	int appId=0;
	String hinNo="";
	String patientname="";
	String department="";
	int departmentId=0;
	String hospital="";
	
	String st="";
	Iterator iterator=patientAppointList.iterator();
	while(iterator.hasNext())
	{
	AppPatientAppointments patientAppointments= (AppPatientAppointments) iterator.next();
	appId=patientAppointments.getId();
	patientname=patientAppointments.getPatientName();
	department=patientAppointments.getDepartment().getDepartmentName();
	departmentId=patientAppointments.getDepartment().getId();
	
	hospital=patientAppointments.getHospital().getHospitalName();
	hinNo=patientAppointments.getHin().getHinNo();
	
	%>
	<tr onclick="pVisitDetailsList('<%=hinNo%>','<%=departmentId%>','<%=department%>')">
	<td><%=hinNo%></td>
	<td><%=patientname%></td>
	<td><%=department%></td>
	<td><%=hospital%></td>
	<td><%=HMSUtil.convertDateTypeToStringWithoutTime(patientAppointments.getAppointmentDate()) %> </td>
	
	</tr>
	<% 
	}
	
	%>
	</table>
	<%-- data_arr[<%= i%>] = new Array();

	data_arr[<%= i%>][0] ="<%=appId%>"

	data_arr[<%= i%>][1] = '<input type="radio" onclick="pVisitDetailsList(\'<%=hinNo %>\')" class="radiogrid"  name="parent" value="<%= appId%>" id="parent" />'
	data_arr[<%= i%>][2] ="<%=patientname%>"
	data_arr[<%= i%>][3] ="<%=department%>"
	data_arr[<%= i%>][4] ="<%=hospital%>"
	data_arr[<%= i%>][5] ="<%=HMSUtil.convertDateTypeToStringWithoutTime(patientAppointments.getAppointmentDate()) %>"
	
	<%
	i++;
	}

	}catch(Exception e){
	e.printStackTrace();
	}
	%>
		
		formName = "patientList"
	start = 0
	if(data_arr.length < rowsPerPage)
	end = data_arr.length;
	else
	end = rowsPerPage;
		makeTable(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover'); --%>
	<!-- </script>  -->
	
	
	<%if(patientAppointList.size() >0){ %>
<input type="button" name="Submit" id="addbutton" value="OK" class="button"
	onclick="submitForm('patientList','/hms/hms/registration?method=showAppRegisterJsp','validateRadio');" />
	<%} %>
	
	
	
	</form>
	
	
	<script type="text/javascript">

	function validateRadio(){

			 for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true)
              {

				return true;
			  }
  		}
  		alert("Please select the patient")
		return false;

	}</script>