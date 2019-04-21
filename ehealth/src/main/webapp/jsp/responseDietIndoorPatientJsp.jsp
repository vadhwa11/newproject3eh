<%--
	 * Copyright 2010 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseDietIndoorPatientJsp.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 09.02.2010    Name: Ramdular
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>


<script type="text/javascript" language="javascript">
	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		String time=String.valueOf(calendar.getTime());
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}%>
		 serverdate = '<%=date+"/"+month+"/"+year%>'
		function checkStartDate(){
		var toDate = document.patientEnquirySearch1.<%= TO_DATE %>.value;
		var cDate = new Date();
		var month = cDate.getMonth() + 1
		var day = cDate.getDate()
		var year = cDate.getFullYear()
		var seperator = "/"
		var currentDate  = new Date(month + seperator + day + seperator + year);
		var endDate =new Date(toDate.substring(6),(toDate.substring(3,5) - 1) ,toDate.substring(0,2))
		if(toDate=="")
		{
		 alert("Date should not be blank.");
		 return false;
		}
		return true;
	}
</script>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		String message="";
		List indoorPatientDietList = new ArrayList();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<MasDiet> masDietList = new ArrayList<MasDiet>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currenDate = (String) utilMap.get("currentDate");
	 	String currentTime = (String) utilMap.get("currentTime");
	 	String userName=null;
	  	if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("indoorPatientDietList") != null){
			indoorPatientDietList= (List)map.get("indoorPatientDietList");
		}

		if(map.get("masEmployeeList") != null){
			masEmployeeList= (List<MasEmployee>)map.get("masEmployeeList");
		}
		if(map.get("masDietList") != null){
			masDietList= (List<MasDiet>)map.get("masDietList");
		}

		int cnt=1;
	%>

<div id="testDivItem">
<%
    int  counter=0;
	if (indoorPatientDietList != null && indoorPatientDietList.size() > 0) {

%>

<table>
	<tr>
		<th></th>
		<th>Sl. No.</th>
		<th>Name of Patient</th>
		<th><%=prop.getProperty("com.jkt.hms.registration_no")%></th>
		<th>Bed No.</th>
		<th>Type of Food</th>
		<th>Morning Tea Bread</th>
		<th>Eggs</th>
		<th>Lunch</th>
		<th>Evening Tea</th>
		<th>Banana</th>
		<th>Dinner</th>
	</tr>
<%
	for(int i=0;i<indoorPatientDietList.size();i++){
	INPATIENTDIETVIEW patient = (INPATIENTDIETVIEW)indoorPatientDietList.get(i);
%>
	<tr>
		<td><input type="checkbox" class="radiogrid" name="parent<%=cnt%>"
			id="parent<%=cnt%>" value="<%=patient.getHinId()%>" checked="checked"/></td>
		<td><%=cnt%></td>
		<%
	  	 String parient_Name ="";
		  if(patient.getPFirstName()!=null)
		  {
			  parient_Name = patient.getPFirstName();
		  }
		  if(patient.getPMiddleName()!=null)
		  {
			  parient_Name = parient_Name+" "+patient.getPMiddleName();
		  }
		  if(patient.getPLastName()!=null)
		  {
			  parient_Name = parient_Name+" "+patient.getPLastName();
		  }
	%>
		<td><%=parient_Name%></td>
		<td><%=patient.getHinNo()%><input type="hidden" name="<%=HIN_NO%><%=cnt%>" id="<%=HIN_NO%><%=cnt%>" value="<%=patient.getHinNo()%>" /></td>
		<td><%=patient.getBedId()%><input type="hidden" name="<%=BED_NO%><%=cnt%>" id="<%=BED_NO%><%=cnt%>" value="<%=patient.getBedId()%>" /></td>
		<td><select name="dietType<%=cnt%>" id="dietType<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<%for(MasDiet masDiet : masDietList){
				if(patient.getDietId()==null){%>
					<option value="<%=masDiet.getId()%>"><%=masDiet.getDietName()%></option>
				<%}else{
					if(patient.getDietId().equals(masDiet.getId())){%>
			<option	value="<%=patient.getDietId()%>" selected="selected"><%=masDiet.getDietName()%></option>
			<%}else{%><option value="<%=masDiet.getId()%>"><%=masDiet.getDietName()%></option>
		<%}}}%>
		</select></td>
		<td><select name="morningTea<%=cnt%>" id="morningTea<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<%if(patient.getMorningTeaBread().equalsIgnoreCase("Y")){ %>
			<option value="Y">Yes</option>
			<%}else if(patient.getMorningTeaBread().equalsIgnoreCase("N")){%>
			<option value="N">No</option>
			<%}%>
		</select></td>
		<td><select name="eggs<%=cnt%>" id="eggs<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<%if(patient.getEggs().equalsIgnoreCase("Y")){ %>
			<option value="Y">Yes</option>
			<%}else if(patient.getEggs().equalsIgnoreCase("N")){%>
			<option value="N">No</option>
			<%}%>
		</select></td>
		<td><select name="lunch<%=cnt%>" id="lunch<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<%if(patient.getLunch().equalsIgnoreCase("Y")){ %>
			<option value="Y">Yes</option>
			<%}else if(patient.getLunch().equalsIgnoreCase("N")){ %>
			<option value="N">No</option>
			<%}%>
		</select></td>
		<td><select name="eveningTea<%=cnt%>" id="eveningTea<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<%if(patient.getEveningTea().equalsIgnoreCase("N")){ %>
			<option value="N">No</option>
			<%}else if(patient.getEveningTea().equalsIgnoreCase("Y")){ %>
			<option value="Y">Yes</option>
			<%} %>
		</select></td>
		<td><select name="banana<%=cnt%>" id="banana<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<%if(patient.getBanana().equalsIgnoreCase("N")){ %>
			<option value="N">No</option>
			<%}else if(patient.getBanana().equalsIgnoreCase("Y")){%>
			<option value="Y">Yes</option>
			<%}%>
		</select></td>
		<td><select name="dinner<%=cnt%>" id="dinner<%=cnt%>"
			style="width: 60px; overflow: auto;">
			<%if(patient.getDinner().equalsIgnoreCase("N")){ %>
			<option value="N">No</option>
			<%}else if(patient.getDinner().equalsIgnoreCase("Y")){%>
			<option value="Y">Yes</option>
			<%}%>
		</select></td>
	</tr>
<%	cnt++;
	counter++;
	}
	%>
</table>
<%}else{%>
<font face="arial" size="4" color="red">No Records Found !</font>
<%} %>
<input type="hidden" name="counter" id="counter" value="<%=counter%>"></input>
</div>
