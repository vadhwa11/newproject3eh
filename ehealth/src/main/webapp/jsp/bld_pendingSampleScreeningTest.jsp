
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>

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
		String deptName="";
		String deptType ="";
		String message = "";
		int deptId=0;
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
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
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		%>
<h4><span><%=message %></span></h4>
<%} %>
<script type="text/javascript" language="javascript">s
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
<h2>Pending Cross Matching</h2>
</div>
<div class="clear"></div>

<div class="Block">
<h4>Patient Search</h4>
<div class="clear"></div>
<div class="clear"></div>
<label>  From Date<span>*</span></label> 
<input type="text" class="date"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label>To Date<span>*</span></label> 
<input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

<label>Sample Validation Number</label> 
<input type="text" name="<%=HIN_NO %>" value=""
	MAXLENGTH="50" /> 

<div class="clear"></div>

<label>UID</label> 
<input type="text" name="<%=HIN_NO %>" value=""
	MAXLENGTH="50" /> 
	
	<label>IP No.</label> <input type="text"
	name="<%=AD_NO %>" value="" MAXLENGTH="50" />
	
	<label>Requested By</label> <select name="<%=PATIENT_TYPE%>">
	<option value="">Select</option>
	<option value="Out Patient">Out Patient</option>
	<option value="In Patient">In Patient</option>
</select>
<div class="clear"></div>
<label>Patient Name</label> 

<input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" /> 

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<input type="button" name="search" id="addbutton" value="Search" class="button"	
onclick="submitForm('patientSearch','/hms/hms/bloodBank?method=searchPatientForBloodSampleScreening');"	accesskey="a" />
</div>


<div class="clear"></div>
<div class="Block">
<table width="100%" border="0"  cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			 <th>Date</th>
			<th>Request Number</th>
			<th>Sample Validate Number </th>
			<th>Patient Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>IP Number</th>
			<th>Doctor Name</th>
			<!-- <th><span>*</span>Result</th> -->
		</tr>
		<tr>
			<td>
			30/03/2015
			<!--  <td><input type="text" size="" value=""
				name="" readonly="readonly" /> 
				 -->
				</td>
			
			<td>
			
			<!-- <input type="text" size="" id="investigationName"
				name="" value=""
				onblur="" /> -->
				7/2015
			</td>
			<td>
			343
			<!-- <input type="text" size="" id="investigationName"
				name="" value=""
				onblur="" /> -->
			</td>
			<td>
			Avni
			<!-- <input type="text" size="" id="investigationName"
				name="" value=""
				onblur="" /> -->
			</td>
			<td>
			<!-- 
			<input type="text" size="" id="investigationName"
				name="" value=""
				onblur="" /> -->
				34
			</td>
			<td>
			
			<!-- <input type="text" size="" id="investigationName"
				name="" value=""
				onblur="" /> -->
				Male
			</td>
			
			<td>
			
			<!-- <input type="text" size="" id="investigationName"
				name="" value=""
				onblur="" /> -->
				2921
			</td>
			<td>
			Amit
			<!-- <input type="text" size="" id="investigationName"
				name="" value=""
				onblur="" /> -->
			</td>
			
		</tr>
	
	</thead>
</table>
</div>
<div class="clear"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<%-- <jsp:include page="searchResultBlock.jsp" /> --%>
<div class="clear"></div>

</div>

