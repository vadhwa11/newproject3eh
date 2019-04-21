<%@page import="jkt.hms.masters.business.BloodRequestEntryHeader"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningHeader"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryHeader"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>

<%@page import="java.text.SimpleDateFormat"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script> -->

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
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		
		List<BloodRequestEntryHeader> bloodRequestList=new ArrayList<BloodRequestEntryHeader>();
		
		
	 	
		Map<String, Object> utilMap = new HashMap<String, Object>();utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String message = "";
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		
		
		if(map.get("bloodRequestList") != null){
			bloodRequestList= (List<BloodRequestEntryHeader>)map.get("bloodRequestList");
		}
		
		
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
			}
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		%>
<h4>
	<span><%=message %></span>
</h4>
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


<div class="titleBg">
	<h2>Pending List Of Cross Matching List</h2>
</div>
<div class="Block">
<h4>Patient Search</h4>	
	<form name="crossMatchSearch" action="" method="post">
		<label> <span>*</span> From Date
		</label> <input type="text" class="date" id="fromDateId"
			name="<%=FROM_DATE%>" value="<%=currentDate%>" readonly="readonly"
			MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.crossMatchSearch.<%=FROM_DATE%>,event)" />

		<label><span>*</span>To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE%>" value="<%=currentDate%>" class="date"
			readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.crossMatchSearch.<%=TO_DATE%>,event)" />

		<label>Sample Validation No.</label> <input type="text"
			name="<%=HIN_NO%>" value="" MAXLENGTH="50" />
		<div class="clear"></div>

		<label>UID</label> <input type="text" name="<%=HIN_NO%>" value=""
			MAXLENGTH="50" /> <label>IP Number</label> <input type="text"
			name="<%=AD_NO%>" value="" MAXLENGTH="50" /> <label>Requested
			By</label> <input type="text" name="<%=AD_NO%>" value="" MAXLENGTH="50" />


		<%-- <label> <span>*</span> P Type</label> <select name="<%=PATIENT_TYPE%>">
	<option value="">Select</option>
	<option value="Out Patient">Out Patient</option>
	<option value="In Patient">In Patient</option>
</select> --%>

		<div class="clear"></div>



		<%-- <label>Order By</label>
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

		<label>Patient Name</label> <input type="text" id="pfirstName"
			name="<%=P_FIRST_NAME%>" value="" MAXLENGTH="15" />

		<%-- 	 <label>Patient
Last Name</label> <input type="text" name="<%=P_LAST_NAME %>" value=""
	MAXLENGTH="15" /> --%>

		<div class="clear"></div>
		<input type="button" name="" id="addbutton"
			onclick="submitForm('patientSearch','/hms/hms/bloodBank?method=searchPatientForBloodIssue','check()');"
			value="Search" class="button" accesskey="a" />
		<div class="clear"></div>
		<table width="100%" colspan="7" id="charg" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<th>Required Date</th>
					
					<th>UID Number</th>
					<th>IP Number</th>
					<th>Patient Name</th>
					<th>Age</th>
					<th>Doctor Name</th>
					<!-- <th>Ward</th> -->
					<!-- <th><span>*</span>Result</th> -->
				</tr>
			</thead>


			<% 
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	       
				if (null != bloodRequestList && bloodRequestList.size() > 0) {
					for (BloodRequestEntryHeader bldRequestlist : bloodRequestList) {
						String IpNmber="";
						String refferDoctor="";
						String date1=null;
						if(null !=bldRequestlist.getOrderDate()){
						date1=DATE_FORMAT.format(bldRequestlist.getOrderDate());
						
						}
					
						if(null !=bldRequestlist.getInpatient()){
							IpNmber=bldRequestlist.getInpatient().getAdNo();
							refferDoctor=bldRequestlist.getInpatient().getDoctor().getEmployeeName();
						}
						
			%>
			<tr style="cursor: pointer;"
				onclick="submitForm('crossMatchSearch','/hms/hms/bloodBank?method=showCrossMatchingJsp&bloodRequestHeaderId=<%=bldRequestlist.getId()%>')">

				<td><%=date1%></td>
				
				<td><%=bldRequestlist.getHin().getHinNo()%></td>
				
				<td><%=IpNmber%></td>
				<td><%=bldRequestlist.getHin().getPFirstName()%></td>
				<td><%=bldRequestlist.getHin().getAge()%></td>
				<td><%=refferDoctor%></td>
				<!-- <td>2</td> -->
			</tr>

			<%
				}
			%>
		
		<%
			} else {
		%>
		<h4>No Data Found</h4>
		<%
			}
		%>
	</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	<div class="clear"></div>
</div>
<div class="clear"></div>

<%-- <jsp:include page="searchResultBlock.jsp" /> --%>
<div class="clear"></div>
<div id="searchresults" tabindex="2">
	<div id="searchtable" tabindex="2"></div>

</div>
