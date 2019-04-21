
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryHeader"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>

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
	    Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String userName = "";
		String message = "";
		
		List<BloodRequestEntryHeader> requestheaderList=new ArrayList<BloodRequestEntryHeader>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		if(map.get("requestheaderList") != null){
			requestheaderList= (List<BloodRequestEntryHeader>)map.get("requestheaderList");
		}
		
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(patientMap.get("patientDetailList") != null){
			patientDetailList= (List<BloodSampleCollection>)patientMap.get("patientDetailList");
		}
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
			}
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		}
		System.out.println();
		if(!message.equalsIgnoreCase("")){
		%>
<h4><span><%=message %></span></h4>
<%} %>

<script type="text/javascript">
	function check(){
		var FDate = document.patientSearch.<%= FROM_DATE%>.value;
		var TDate = document.patientSearch.<%= TO_DATE %>.value;
		
		if (FDate == '' || TDate == '') {
		alert("Please enter both Date....");
		return false;
	   }

		var toDate =new Date(TDate.substring(6),(TDate.substring(3,5) - 1) ,TDate.substring(0,2))
		var fromDate =new Date(FDate.substring(6),(FDate.substring(3,5) - 1) ,FDate.substring(0,2))
	    if(fromDate > toDate)
		{
			alert("Please ensure that To Date is greater than or equal to the From Date.");
			document.calldate.next_day.focus();
			return false;
		}
	}
</script>
<form name="patientSearch" action="" method="post">

<div class="titleBg">
<h2>Pending Blood Request</h2>
</div>
<div class="clear"></div>
<h4>Patient Search</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label> <span>*</span> From Date</label> <input type="text" class="date"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

<label> P Type</label> <select name="<%=PATIENT_TYPE%>">
	<option value="">Select</option>
	<option value="Out Patient">OP</option>
	<option value="In Patient">IP</option>
</select>

<div class="clear"></div>
<label>UHID </label> <input type="text" name="<%=HIN_NO %>" value=""
	MAXLENGTH="15" /> <label>IP No.</label> <input type="text"
	name="<%=AD_NO %>" value="" MAXLENGTH="15" /> 
	
	
	<label>Ward</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" /> 
<%-- 	<label>Order By</label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
				for(MasDepartment masDepartment : departmentList){
				%>
	<option value="<%=masDepartment.getId() %>"
		<%=HMSUtil.isSelected(masDepartment.getId(),Integer.valueOf(box.getInt(DEPARTMENT_ID)))%>><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select> --%>

<div class="clear"></div>
<label>Patient  Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" /> 
	
	<%-- <label>Patient
Last Name</label> <input type="text" name="<%=P_LAST_NAME %>" value=""
	MAXLENGTH="15" /> <label>&nbsp;</label> <input type="button"
	name="search" id="addbutton"
	onclick="submitForm('patientSearch','/hms/hms/bloodBank?method=searchPatientForSampleValidation');"
	value="Search" class="button" accesskey="a" /> --%>
	
	<input type="button" name="" value="Search" class="button" tabindex=1 />
	
<div class="clear"></div>

</form>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<%-- <jsp:include page="searchResultBlock.jsp" /> --%>
<%
	
		if(null !=requestheaderList && requestheaderList.size()>0){
		%>
<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Request Number</th>
			<th>Request Date</th>
			<th>UHID</th>
			<th>IP Number</th>
			<th>Patient Name</th>
			<th>Age</th>
			<th>Ward</th>
			<th>Doctor Name</th>
			<!-- <th></th>
			<th></th> -->
			<!-- <th><span>*</span>Result</th> -->
		</tr>
	</thead>
	<tbody>
	<% 
	String ipNumber="";
	String WardNumber="";
	String doctorName="";
	for(BloodRequestEntryHeader bllodRequest:requestheaderList){
		System.out.println("GGG "+bllodRequest.getOrderDate());
		if(null !=bllodRequest.getInpatient()){
			ipNumber=bllodRequest.getInpatient().getAdNo();
			WardNumber=bllodRequest.getInpatient().getAdWard().getDepartmentName();
			if(null !=bllodRequest.getInpatient().getDoctor())
			doctorName=bllodRequest.getInpatient().getDoctor().getEmployeeName();
		}
	
		%>
	
		<tr onclick="populateBloodRequestValidation('<%=bllodRequest.getId() %>')">
			 <td><%=bllodRequest.getOrderNo() %></td>
			 <%if(bllodRequest.getOrderDate() !=null){ %>
			<td><%=HMSUtil.convertDateToStringTypeDateOnly( bllodRequest.getOrderDate()) %></td>
			<%}else{ %>
				<td></td>
			
			<%} %>
			<td><%=bllodRequest.getHin().getHinNo() %></td>
			<td><%=ipNumber %></td>
	<!-- <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="" onblur="validateRequiredDate();" /> -->
			
			<td><%=bllodRequest.getHin().getPFirstName() %></td>
			<td><%=bllodRequest.getHin().getAge() %></td>
			<td><%=WardNumber %></td>
			<td><%=doctorName %></td>
			<!-- <td>
			<input type="submit" name="" value="Accept" class="button"
	tabindex=1 /></td>
	<td>
			<input type="submit" name="" value="Reject" class="button"
	tabindex=1 /></td> -->
		</tr>
		<%} %>
	</tbody>
</table>
<%} %>
</div>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<script type="text/javascript">
function populateBloodRequestValidation(Id){
	
	 //new Ajax.Request('bloodBank?method=resultEntryFormJsp&Id='+Id, {});
	window.location.href = 'bloodBank?method=bloodRequestValidationJsp&bloodrequestHeaderId='+Id; 
} 

</script>
</div>

