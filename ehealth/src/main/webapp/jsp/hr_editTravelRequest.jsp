<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.MstrCode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.PrjSiteResMap"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.EtrTrvdetails"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.EtrTrvreqcmts"%>
<%@page import="jkt.hrms.masters.business.EtrApptbl"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hrms.masters.business.MstrSiteHeader"%>

<script type="text/javascript" language="javascript"
	src="../jsp/js/proto.js"></script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MstrProject> mstrProjectList = new ArrayList<MstrProject>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MstrSiteHeader> mstrSiteList = new ArrayList<MstrSiteHeader>();
	List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
	List<EtrTravelreq> singleTravelRequestList = new ArrayList<EtrTravelreq>();
	List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
	List<MstrCode> mstrCodeForTripList = new ArrayList<MstrCode>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<PrjSiteResMap> prjSiteMapList = new ArrayList<PrjSiteResMap>();
	List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
	List<MasCountry> countryList = new ArrayList<MasCountry>();
	List<EtrTravelreq> viewTravelRequestList = new ArrayList<EtrTravelreq>();
	List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
	List<PrjSiteResMap> prjSiteResMapList = new ArrayList<PrjSiteResMap>();
	List<EtrTrvdetails> updateTicketTravelRequestList = new ArrayList<EtrTrvdetails>();
	Users users = new Users();
	PrjSiteResMap prjSiteResMap = new PrjSiteResMap();
	String message = "";
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (map.get("singleTravelRequestList") != null) {
		singleTravelRequestList = (List) map
				.get("singleTravelRequestList");
	}
	if (map.get("updateTicketTravelRequestList") != null) {
		updateTicketTravelRequestList = (List) map
				.get("updateTicketTravelRequestList");
	}
	if (map.get("prjSiteResMap") != null) {
		prjSiteResMap = (PrjSiteResMap) map.get("prjSiteResMap");
	}
	if (map.get("prjSiteResMapList") != null) {
		prjSiteResMapList = (List<PrjSiteResMap>) map
				.get("prjSiteResMapList");

	}
	if (map.get("viewTravelRequestList") != null) {
		viewTravelRequestList = (List) map.get("viewTravelRequestList");
	}
	if (map.get("etrTravelReqList") != null) {
		etrTravelReqList = (List) map.get("etrTravelReqList");
	}
	if (map.get("mstrProjectList") != null) {
		mstrProjectList = (List) map.get("mstrProjectList");
	}
	if (map.get("countryList") != null) {
		countryList = (List) map.get("countryList");
	}
	if (map.get("departmentList") != null) {
		departmentList = (List) map.get("departmentList");
	}
	if (map.get("mstrSiteList") != null) {
		mstrSiteList = (List) map.get("mstrSiteList");
	}
	if (map.get("masCityList") != null) {
		masCityList  = (List) map.get("masCityList");
	}
	if (map.get("currencyList") != null) {
		currencyList = (List) map.get("currencyList");
	}
	if (map.get("mstrCodeForTripList") != null) {
		mstrCodeForTripList = (List) map.get("mstrCodeForTripList");
	}
	if (map.get("employeeList") != null) {
		employeeList = (List) map.get("employeeList");
	}
	if (map.get("prjSiteMapList") != null) {
		prjSiteMapList = (List) map.get("prjSiteMapList");
	}
	
	if (map.get("mstrCodeForTravelModeList") != null) {
		mstrCodeForTravelModeList = (List) map
				.get("mstrCodeForTravelModeList");
	}
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}
	if (map.get("users") != null) {
		users = (Users) map.get("users");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String locationName = "";
	String empName = "";
	String designation = "";
	String department = "";
	String orgnization = "";
	int employeeId = 0;
	if(employeeList.size()>0){
		for(MasEmployee masEmployee :employeeList){
			if(masEmployee.getLocation() != null){
			locationName = masEmployee.getLocation().getLocationName();
			}
			
			empName = masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode();
				
			if(masEmployee.getDepartment() != null){
				department = masEmployee.getDepartment().getDepartmentName();
				}
			if(masEmployee.getRank() != null){
				designation = masEmployee.getRank().getRankName();
				}
			if(masEmployee.getHospital() != null){
				orgnization = masEmployee.getHospital().getHospitalName();
				}
			employeeId = masEmployee.getId();
		}
	}
	int travelRequestId = 0;
	String refNo = "";
	Date fromDate = new Date();
	Date toDate = new Date();
	int tripId = 0;
	String ticketBooking = "";
	String cabBooking = "";
	String hotelBooking = "";
	String needAdvance = "";
	BigDecimal advanceAmount = new BigDecimal("0");
	int currencyId = 0;
	String expectedOnDate = "";
	String description = "";
	int projectBasedOrNonProjectBased = 0;
	int projectId = 0;
	long noOfDays = 0l;
	String hotelBookingDesc = "";
	String cabBookingDesc = "";
	String siteName = "";
	String status = "";
	String tripName = "";
	String projectName = "";
	String comments = "";
	int siteId = 0;
	String url = "";
	Set<EtrApptbl> etrApptblSet = new HashSet();
	Set<EtrTrvdetails> etrTrvdetailsSet = new HashSet();
	if (viewTravelRequestList.size() > 0) {
		for (EtrTravelreq etrTravelreq : viewTravelRequestList) {
			travelRequestId = etrTravelreq.getId();
			refNo = etrTravelreq.getRefNo();
			if (etrTravelreq.getJfdate() != null) {
				fromDate = etrTravelreq.getJfdate();
			}
			if (etrTravelreq.getJtdate() != null) {
				toDate = etrTravelreq.getJtdate();
			}

			if (etrTravelreq.getTrip().getId() != null) {
				tripId = etrTravelreq.getTrip().getId();
				tripName = etrTravelreq.getTrip().getCodeDesc();
			}
			if (etrTravelreq.getNAFTicket() != null) {
				ticketBooking = etrTravelreq.getNAFTicket();
			}
			if (etrTravelreq.getNAFLocalCab() != null) {
				cabBooking = etrTravelreq.getNAFLocalCab();
			}
			if (etrTravelreq.getTrvStatus() != null) {
				status = etrTravelreq.getTrvStatus();
			}
			if (etrTravelreq.getNAFHotel() != null) {
				hotelBooking = etrTravelreq.getNAFHotel();
			}
			if (etrTravelreq.getHotelDesc() != null) {
				hotelBookingDesc = etrTravelreq.getHotelDesc();
			}
			if (etrTravelreq.getLocalCabDesc() != null) {
				cabBookingDesc = etrTravelreq.getLocalCabDesc();
			}
			if (etrTravelreq.getAvdReq() != null) {
				needAdvance = etrTravelreq.getAvdReq();
			}
			if (etrTravelreq.getAdvAmt() != null) {
				advanceAmount = etrTravelreq.getAdvAmt();
			}

			if (etrTravelreq.getAdvcurid() != null) {
				if (etrTravelreq.getAdvcurid().getId() != null) {
					currencyId = etrTravelreq.getAdvcurid().getId();
				}
			}

			if (etrTravelreq.getAdvExpDate() != null) {
				expectedOnDate = HMSUtil
						.convertDateToStringWithoutTime(etrTravelreq
								.getAdvExpDate());
			}
			if (etrTravelreq.getAdvDesc() != null) {
				description = etrTravelreq.getAdvDesc();
			}
			if (etrTravelreq.getProjectTrip() != null) {
				projectBasedOrNonProjectBased = etrTravelreq
						.getProjectTrip();
			}
			 if(etrTravelreq.getPrj()!= null){
			if (etrTravelreq.getPrj().getId() != null) {
				projectId = etrTravelreq.getPrj().getId();
				projectName = etrTravelreq.getPrj().getPrjName();
			}}
			 if(etrTravelreq.getSite()!= null){
			if(etrTravelreq.getSite().getId()!= null){
				 siteId = etrTravelreq.getSite().getId();
				 siteName = etrTravelreq.getSite().getSiteName();
			 }}
			 
			 if(etrTravelreq.getHotelDesc()!= null){
				 hotelBookingDesc = etrTravelreq.getHotelDesc();
			 }
			 if(etrTravelreq.getLocalCabDesc()!= null){
				 cabBookingDesc = etrTravelreq.getLocalCabDesc();
			 }
			long mills_per_day = 1000 * 60 * 60 * 24;
			noOfDays = ((toDate.getTime() - fromDate.getTime())
					/ mills_per_day)+1;

			etrApptblSet = etrTravelreq.getEtrApptbls();
			etrTrvdetailsSet = etrTravelreq.getEtrTrvdetails();

			if(etrTravelreq.getComment()!= null){
				 comments = etrTravelreq.getComment();
			 }

		}
	}
%>


<script type="text/javascript">
	
	<%
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
 //---------------display value textboxes to grid-------------------------
  function updateRow(){
	    document.getElementById('fromDate').value = document.getElementById('fromDateId').value;
	    document.getElementById('toDate').value = document.getElementById('toDateId').value;
	    document.getElementById('noOfDays').value = document.getElementById('noOfDaysId').value;
	     var w = document.getElementById('trip').selectedIndex;
		 var selectedText = document.getElementById('trip').options[w].text;
	    document.getElementById('tripNameId').value = selectedText;
	    
	    var w = document.getElementById('projectId').selectedIndex;
		 var selectedText = document.getElementById('projectId').options[w].text;
		 if(w != 0)
	    	document.getElementById('projectNameId').value =selectedText;
	     else 
	     	document.getElementById('projectNameId').value = "";
	     	
	    var w = document.getElementById('siteId').selectedIndex;
		 var selectedText = document.getElementById('siteId').options[w].text;
		 if(w != 0)
	    document.getElementById('siteNameId').value = selectedText;
	    else 
	     	document.getElementById('siteNameId').value = "";
	    document.getElementById('fromDateId').value = "";
	    document.getElementById('toDateId').value = "";
	    document.getElementById('noOfDaysId').value = "";
	    document.getElementById('trip').value = "0";
	    document.getElementById('projectId').value = "0";
	     document.getElementById('siteId').value = "0";
  }
 
	function updateTicketBookingDetails(){
		var i = document.getElementById('count').value;
	
		 var w = document.getElementById('cityId').selectedIndex;
		 
		 var selectedText = document.getElementById('cityId').options[w].text;
		 
		 if(document.getElementById('cityId').value != "0")
			 document.getElementById('fromCityId'+i).value = selectedText;
		document.getElementById('fromCityHiddenId'+i).value = document.getElementById('cityId').value;	
		 
		 var w1 = document.getElementById('cityId1').selectedIndex;
		 var selectedText = document.getElementById('cityId1').options[w1].text;
		 if(document.getElementById('cityId1').value != "0")
			 document.getElementById('toCityId'+i).value = selectedText;
		document.getElementById('toCityHiddenId'+i).value = document.getElementById('cityId1').value;	
			 
			 
		 var w2 = document.getElementById('travelModeId').selectedIndex;
		 var selectedText = document.getElementById('travelModeId').options[w2].text;
		 document.getElementById('travelMode'+i).value =selectedText;
		 document.getElementById('travelModeHiddenId'+i).value = document.getElementById('travelModeId').value;	
			 
		 
		 document.getElementById('bookingDate'+i).value = document.getElementById('bookingDateId').value;
		 document.getElementById('ticketTime'+i).value = document.getElementById('beforeTimeId').value;
		 document.getElementById('remarkId'+i).value = document.getElementById('remarksId').value;
		
		 var w3 = document.getElementById('countryId').selectedIndex;
		 var selectedText = document.getElementById('countryId').options[w3].text;
		 if(document.getElementById('countryId').value != "0")
		 	document.getElementById('fromCountryId'+i).value = selectedText;
		 	document.getElementById('fromCountryHiddenId'+i).value = document.getElementById('countryId').value;	
		 	
		 var w4 = document.getElementById('countryId1').selectedIndex;
		 var selectedText = document.getElementById('countryId1').options[w4].text;
		 if(document.getElementById('countryId1').value != "0")
		 	document.getElementById('toCountryId'+i).value = selectedText;
		 	document.getElementById('toCountryHiddenId'+i).value = document.getElementById('countryId1').value;
		 	
		 	document.getElementById('cityId').value = "0";	
			document.getElementById('cityId1').value = "0";
			document.getElementById('travelModeId').value = "0";
			document.getElementById('bookingDateId').value= "";
			document.getElementById('beforeTimeId').value = "";
			document.getElementById('remarksId').value = "";
			document.getElementById('countryId').value = "";
			document.getElementById('countryId1').value = "";
	}
	
	//---------------display value grid to textboxes-------------------------
	function displayEditValue(){
	 	document.getElementById('fromDateId').value = document.getElementById('fromDate').value;
	    document.getElementById('toDateId').value = document.getElementById('toDate').value;
		document.getElementById('noOfDaysId').value = document.getElementById('noOfDays').value;
	    document.getElementById('trip').value = document.getElementById('triphiddenId').value;															
		document.getElementById('projectId').value = document.getElementById('projectHiddenId').value;	
		document.getElementById('siteId').value = document.getElementById('siteHiddenId').value;
	}
	function displayEditTicketValue(i){
		
		document.getElementById('cityId').value = document.getElementById('fromCityHiddenId'+i).value;
		document.getElementById('cityId1').value = document.getElementById('toCityHiddenId'+i).value ;
		document.getElementById('travelModeId').value = document.getElementById('travelModeHiddenId'+i).value;
		document.getElementById('bookingDateId').value = document.getElementById('bookingDate'+i).value;
		document.getElementById('beforeTimeId').value = document.getElementById('ticketTime'+i).value ;
		 document.getElementById('remarksId').value = document.getElementById('remarkId'+i).value;
		 document.getElementById('countryId').value =document.getElementById('fromCountryHiddenId'+i).value;
		 document.getElementById('countryId1').value = document.getElementById('toCountryHiddenId'+i).value
		 document.getElementById('count').value = i;
	}

	function selectProject(){
		obj = document.getElementById('prjectBasedId');
		   	if(obj.checked){
				document.getElementById('projectId').value = "";
		   		document.getElementById('projectId').disabled = false;
		   		document.getElementById('siteId').value = "";
		   		document.getElementById('siteId').disabled = false;
		   	}else{
		   		document.getElementById('projectId').disabled =true;
		   		document.getElementById('siteId').disabled =true;
		   		
		   	}
		  }
		  
	function selectOthers(){
		obj = document.getElementById('othersId');
	   	if(obj.checked){
			document.getElementById('departmentId').value = "";
	   		document.getElementById('departmentId').disabled = false;
	   		document.getElementById('employeeId').value = "";
	   		document.getElementById('employeeId').disabled = false;
	   	}else{
	   		document.getElementById('departmentId').disabled =true;
	   		document.getElementById('employeeId').disabled =true;
	   	}
	  }
	  
	  function calculateNoOfDays(){
		var fDate = document.getElementById('fromDateId').value;
		var tDate = document.getElementById('toDateId').value;
		var	startDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var endDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		var oneday = 1000 * 60 * 60 * 24
		
		var diffDays = Math.abs((startDate.getTime() - endDate.getTime()));
		var tDays = (Math.round(diffDays/oneday))+1;
		document.getElementById('noOfDaysId').value = tDays;

	}
	
	  
	function selectTrip(val){
		if(val == "10"){
			document.getElementById('cityId').value = "";
	   		document.getElementById('cityId').disabled = false;
	   		document.getElementById('cityId1').value = "";
	   		document.getElementById('cityId1').disabled = false;
			document.getElementById('countryId').disabled = true;
			document.getElementById('countryId1').disabled = true;
			document.getElementById('countryId').value = "";
			document.getElementById('countryId1').value = "";
		}else if(val == "11"){
			document.getElementById('countryId').value = "";
	   		document.getElementById('countryId').disabled = false;
	   		document.getElementById('countryId1').value = "";
	   		document.getElementById('countryId1').disabled = false;
			document.getElementById('cityId').disabled = true;
			document.getElementById('cityId1').disabled = true;
			document.getElementById('cityId').value = "";
			document.getElementById('cityId1').value = "";
		}else{
			document.getElementById('cityId').value = "";
	   		document.getElementById('cityId').disabled = false;
	   		document.getElementById('cityId1').value = "";
	   		document.getElementById('cityId1').disabled = false;
			document.getElementById('countryId').value = "";
	   		document.getElementById('countryId').disabled = false;
	   		document.getElementById('countryId1').value = "";
	   		document.getElementById('countryId1').disabled = false;
		}
		
		
	}
	
		function checkFromDate(){
		var fDate = document.getElementById('fromDateId').value;
		var tDate =document.getElementById('toDateId').value;
		
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		var cDate = new Date();
		var month = cDate.getMonth() + 1
		var day = cDate.getDate()
		var year = cDate.getFullYear()
		var seperator = "/"
		var currentDate  = new Date(month + seperator + day + seperator + year);
		if(fDate != "" && tDate != ""){
			if(fromDate < currentDate){
				alert(" From Date should be greater than equal to  Current Date.");
				document.getElementById('fromDateId').value = "";
				return false;
		
			}else if(toDate < fromDate)
			{
				alert(" To Date should be greater than  From Date.");
				document.getElementById('fromDateId').value = "";
			     document.getElementById('toDateId').value = "";
				return false;
			}
		}
		return true;
	}
	function checkTicketBookingDate(){
		var fDate = document.getElementById('fromDateId').value;
		var ticketDate = document.getElementById('bookingDateId').value;
		
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var ticketBookingDate =new Date(ticketDate.substring(6),(ticketDate.substring(3,5) - 1) ,ticketDate.substring(0,2))
		if(fDate != "" && ticketDate != ""){
		if(fromDate < ticketBookingDate || fromDate > ticketBookingDate)
		{
			alert(" Ticket Booking Date should be greater than equal to  From Date.");
			document.getElementById('bookingDateId').value = "";
			return false;
		}else if (ticketBookingDate < fromDate ){
			alert(" Ticket Booking Date should be greater than equal to  From Date.");
			document.getElementById('bookingDateId').value = "";
			return false;
		}
		}
		return true;
	}

	function checkExpectedDate(){
	
		var fDate =  document.getElementById('fromDateId').value;
		var eDate = document.getElementById('expectedOnId').value;
		
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var expectedDate =new Date(eDate.substring(6),(eDate.substring(3,5) - 1) ,eDate.substring(0,2))
		if(fDate != "" && eDate != ""){
		if(fromDate < expectedDate)
		{
			alert(" Advance Expected Date should be equal and less than  From Date.");
			
			document.getElementById('expectedOnId').value= "";
			return false;
		}
		}
		return true;
	}
    
</script>

<form name="editTravelRequest" method="post" action="">
<div class="titleBg">
<h2>Edit Travel Request</h2>
</div>
<div class="clear"></div>
<%
	if (message != null) {
%>
<h4><%=message%></h4>
<%
	}
%>
<div class="clear"></div>
<div class="Block"><label>Ref.No</label> <input
	name="<%=REFERENCE_NO %>" value="" validate="No. Of Days,string,yes"
	maxlength="8" /> <script type="text/javascript">
          		  document.editTravelRequest.<%=REFERENCE_NO%>.value='<%=refNo%>';
            </script> <label>Employee</label> <input name="<%=EMPLOYEE_ID %>"
	value="<%=empName%> "
	validate="Start Time,string,yes" maxlength="8" /> 
	<input type="hidden" name="<%=EMPLOYEE_HIDDEN_ID %>"  value="<%=employeeId%>">
	<input type="hidden" name="<%=TRV_STATUS%>"  value="<%=status%>"> 
	
	<label>Designation</label> 
	
	<input name="<%=RANK_ID %>"
	value="<%=designation%>" />
<div class="clear"></div>
<label>Department </label> <input name="<%=DEPARTMENT_ID %>"
	value="<%=department%>"
	maxlength="8" /> <label>Location </label> <input name="<%=LOCATION_ID %>" value="<%=locationName%>" maxlength="8" />

<label>Organization </label>
 <input name="<%=HOSPITAL_ID %>" value="<%=orgnization%>" maxlength="8" />
 <div class="clear"></div>
  <label>From Date </label>
	 <input id="fromDateId"
	type="text" name="<%=FROM_DATE %>" value="" class="date"
	readonly="readonly" validate="From date ,date,no" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.getElementById('fromDateId'),event);" /> <label>
To Date </label> <input id="toDateId" type="text" name="<%=TO_DATE %>" value=""
	class="date" readonly="readonly" onblur="calculateNoOfDays();"
	validate="To date ,date,no" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.getElementById('toDateId'),event)" />


<label>No.Of Days </label> <input id="noOfDaysId"
	name="<%=NO_OF_DAYS %>" validate="No. Of Days,string,no" maxlength="8"
	onfocus="calculateNoOfDays();" />
	<div class="clear"></div>
	
	
	 <label>Travel Type </label> <select
	id="trip" name="<%=TRIP_ID %>" validate="Trip,string,no"
	onchange="selectTrip(this.value);">
	<option value="0">Select</option>
	<%
		for (MstrCode mstrCode : mstrCodeForTripList) {
	%>
	<option value="<%=mstrCode.getId() %>"><%=mstrCode.getCodeDesc()%></option>
	<%
		}
	%>
</select>


<label>Project Based</label> <input id="prjectBasedId" type="radio"
	name="<%=PROJECT_BASED_TRIP %>" value="2" class="radioCheck"
	onclick="selectProject();" />
	
	 <label class="auto">yes</label> 
	 <input id="nonProjectBasedId" type="radio" name="<%=PROJECT_BASED_TRIP %>" value="1" checked="checked" class="radioCheck" onclick="selectProject();" />
	 <label class="medium">No</label>
	  <%
 	if (projectBasedOrNonProjectBased == 1) {
 %> <script type="text/javascript">
          		
          		  document.getElementById('nonProjectBasedId').checked = true;
</script> <%
 	} else if (projectBasedOrNonProjectBased == 2) {
 %> <script type="text/javascript">
          		  document.getElementById('prjectBasedId').checked = true;
            </script> <%
 	}
 %> 
 

 <label>Project </label> <select id="projectId"
	name="<%=PROJECT_ID %>" validate="Project,string,no"
	onchange="submitProtoAjax('editTravelRequest','etravel?method=getProjectSiteDetailFromAjax');">
	<option value="0">Select</option>
	<%
		for (MstrProject mstrProject : mstrProjectList) {
	%>
	<option value="<%=mstrProject.getId() %>"><%=mstrProject.getPrjName()%></option>
	<%
		}
	%>
</select>


<div class="clear"></div>
<div id="testDiv"><label>Site </label> <select id="siteId"
	name="<%=SITE_ID %>" validate="Site,string,no">
	<option value="0">Select</option>
	<%
		for (MstrSiteHeader mstrSite : mstrSiteList) {
	%>
	<option value="<%=mstrSite.getId() %>"><%=mstrSite.getSiteName()%></option>
	<%
		}
	%>
</select></div>

<label>Comment </label>
<input type="text"  name="<%=COMMENTS%>" class="large" value="<%=comments%>"  validate="Comments,string,no"   maxlength="400" />

<div class="clear"></div>

</div>
<div class="clear"></div>
<table id="searchresulttable" class="medium">
	<%
		int counter = 0;
		String klass = "even";

		String id = "";
		id = "id" + counter;
		counter++;

		if (counter % 2 == 0) {
			klass = "even";
		} else {
			klass = "odd";
		}
	%>
	<tr>

		<th>FromDate</th>
		<th>ToDate</th>
		<th>Days</th>
		<th>Type</th>
		<th>Project</th>
		<th>Site</th>
		<th>Tic.Book</th>
		<th>Adv.Book</th>
		<th>Hotel</th>
		<th>Cab</th>
	</tr>
	<tbody id="tableData">

		<tr class=<%= klass%> onclick="displayEditValue();" id="<%=counter%>">
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="text" size="10" name="fromEditDate" id="fromDate"
				value="<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>"
				class="readOnly" /></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="text" size="10" name="toEditDate" id="toDate"
				value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>"
				class="readOnly" /></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="text" size="3" name="noOfEditDays" id="noOfDays" value="<%=noOfDays%>"
				class="readOnly" /></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="text" name="tripEditId" id="tripNameId" value="<%=tripName%>"
				class="readOnly" /><input type="hidden" id="triphiddenId"
				name="tripHiddenId" value="<%=tripId %>" /></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="text" name="projectEditId" id="projectNameId"
				value="<%=projectName%>" class="readOnly" /><input type="hidden"
				id="projectHiddenId" name="projectHiddenId" value="<%=projectId %>" /></a></td>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="text" name="siteEditId" id="siteNameId" value="<%=siteName%>"
				class="readOnly" /><input type="hidden" id="siteHiddenId"
				name="siteHiddenId" value="<%=siteId %>" /></a></td>
			<%
				if (ticketBooking.equals("y")) {
			%>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="checkbox" name="ticketEditBooking" checked="checked" value=""
				class="radioCheck" /></a></td>
			<%
				} else {
			%>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="checkbox" name="ticketEditBooking" value="" class="radioCheck" /></a></td>
			<%
				}
			%>
			<%
				if (needAdvance.equals("y")) {
			%>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="checkbox" name="needEditAdvance" checked="checked" value=""
				class="radioCheck" /></a></td>
			<%
				} else {
			%>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="checkbox" name="needEditAdvance" value="" class="radioCheck" /></a></td>
			<%
				}
			%>
			<%
				if (hotelBooking.equals("y")) {
			%>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="checkbox" name="hotelEditBooking" checked="checked" value=""
				class="radioCheck" /></a></td>
			<%
				} else {
			%>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="checkbox" name="hotelEditBooking" value="" class="radioCheck" /></td>
			<%
				}
			%>
			<%
				if (cabBooking.equals("y")) {
			%>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="checkbox" name="cabEditBooking" checked="checked" value=""
				class="radioCheck" /></a></td>
			<%
				} else {
			%>
			<td><a
				href="javascript:Request(document.getElementById('<%=counter %>'),'editTravelRequest')"><input
				type="checkbox" name="cabEditBooking" value="" class="radioCheck" /></a></td>
			<%
				}
			%>
		</tr>
	</tbody>
</table>

<div class="clear"></div>
<input name="update" type="button" class="button" value="Update"
	onClick="updateRow();" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" value="0" name="hiddenValueForGrid"
	id="hiddenValueForGrid" />

<div class="clear"></div>
<div id="ticketBookinDiv"><label class="auto">
Ticket Booking</label>

<div class="Block">
<div class="clear"></div>
<label>From Country </label> <select id="countryId"
	name="<%=COUNTRY_ID %>" validate="Country,string,no">
	<option value="0">Select</option>
	<%
		for (MasCountry masCountry : countryList) {
	%>
	<option value="<%=masCountry.getId() %>"><%=masCountry.getCountryName()%></option>

	<%
		}
	%>
</select> <label>To Country </label> <select id="countryId1"
	name="<%=COUNTRY_ID1 %>" validate="Country ,string,no">
	<option value="0">Select</option>
	<%
		for (MasCountry masCountry : countryList) {
	%>
	<option value="<%=masCountry.getId() %>"><%=masCountry.getCountryName()%></option>
	<%
		}
	%>
</select>

<div class="clear"></div>
<label>From Place </label> <select id="cityId" name="<%=CITY_ID %>"
	validate="City,string,no">
	<option value="0">Select</option>
	<%
	for(MasDistrict masDistrict :masCityList){
	%>
	<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName()%></option>

	<%
		}
	%>
</select> <label>To Place </label> <select id="cityId1" name="<%=CITY_ID1 %>"
	validate="City,string,no">
	<option value="0">Select</option>
	<%
	for(MasDistrict masDistrict :masCityList){
	%>
	<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName()%></option>
	<%
		}
	%>
</select> <label>Travel Mode </label> <select id="travelModeId"
	name="<%=TRAVEL_MODE_ID %>" validate="Travel Mode,string,no">
	<option value="0">Select</option>
	<%
		for (MstrCode mstrCode : mstrCodeForTravelModeList) {
	%>
	<option value="<%=mstrCode.getId() %>"><%=mstrCode.getCodeDesc()%></option>
	<%
		}
	%>
</select>

<div class="clear"></div>
<label>Date </label> <input id="bookingDateId" type="text"
	name="<%=TICKET_BOOKING_DATE %>" value="" class="date"
	readonly="readonly" validate="Ticket Booking ,date,no" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.getElementById('bookingDateId'),event)" />

<label>Remarks </label> <input id="remarksId" name="<%=REMARKS %>"
	validate="Remarks,string,no" maxlength="8" /> <label>Before
Time </label> <input id="beforeTimeId" name="<%=BEFORE_TIME %>"
	validate="Before Time,string,no" maxlength="8" /> 
	<input type="hidden"
	id="count" name="count" value="" />
<div class="clear"></div>

</div>
<div class="clear"></div>
<table id="ticketBookingtableId" class="medium">
	<tr>

		<th>From Place</th>
		<th>To Place</th>
		<th>Travel Type</th>
		<th>Date</th>
		<th>Time</th>
		<th>Remarks</th>
		<th>From Country</th>
		<th>To Country</th>
	</tr>

	<%
		int i = 1;
		int etrvDetailId = 0;
		String tlass = "even";
		int counter1 = 0;
		String fromPlace = "";
		String toPlace = "";
		String fromCountry = "";
		String toCountry = "";
		int fromPlaceId = 0;
		int toPlaceId = 0;
		int fromCountryId = 0;
		int toCountryId = 0;
		for (EtrTrvdetails etrTrvdetails : etrTrvdetailsSet) {

			if (etrTrvdetails.getId() != null) {
				etrvDetailId = etrTrvdetails.getId();
			}

			for(MasDistrict masDistrict :masCityList){
				if (etrTrvdetails.getFrmPlce() != null) {
					if (etrTrvdetails.getFrmPlce().getId() != null) {
						fromPlace = etrTrvdetails.getFrmPlce()
								.getDistrictName();
						fromPlaceId = etrTrvdetails.getFrmPlce().getId();
					} else {
						fromPlace = "";
					}
				}
			}

			for(MasDistrict masDistrict :masCityList){
				if (etrTrvdetails.getToPlce() != null) {
					if (etrTrvdetails.getToPlce().getId() != null) {
						toPlace = etrTrvdetails.getToPlce().getDistrictName();
						toPlaceId = etrTrvdetails.getToPlce().getId();
					} else {
						toPlace = "";
					}
				}
			}

			for (MasCountry masCountry : countryList) {
				if (etrTrvdetails.getFromCountry() != null) {
					if (etrTrvdetails.getFromCountry().getId() != null) {
						fromCountry = etrTrvdetails.getFromCountry()
								.getCountryName();
						fromCountryId = etrTrvdetails.getFromCountry()
								.getId();
					} else {
						fromCountry = "";
					}
				}
			}

			for (MasCountry masCountry : countryList) {
				if (etrTrvdetails.getToCountry() != null) {
					if (etrTrvdetails.getToCountry().getId() != null) {
						toCountry = etrTrvdetails.getToCountry()
								.getCountryName();
						toCountryId = etrTrvdetails.getToCountry().getId();
					} else {
						toCountry = "";
					}
				}
			}

			String id1 = "";
			id1 = "id1" + counter1;
			counter1++;

			if (counter1 % 2 == 0) {
				tlass = "even";
			} else {
				tlass = "odd";
			}
	%>
	<tr class=<%=tlass%> id="<%=counter1%>"
		onclick="displayEditTicketValue(<%=i %>);">

		<td><a
			href="javascript:Request(document.getElementById('<%=counter1%>'),'editTravelRequest')"><input
			type="text" size="10" name="fromEditCityId" id="fromCityId<%=i %>"
			value="<%=fromPlace%>" class="readOnly" /><input type="hidden"
			id="fromCityHiddenId<%=i %>" name="fromCityHiddenId<%=i %>"
			value="<%=fromPlaceId%>" /></a></td>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter1%>'),'editTravelRequest')"><input
			type="text" size="10" name="toEditCityId" id="toCityId<%=i %>" value="<%=toPlace%>"
			class="readOnly" /><input type="hidden" id="toCityHiddenId<%=i %>"
			name="toCityHiddenId<%=i %>" value="<%=toPlaceId %>" /></a></td>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter1%>'),'editTravelRequest')"><input
			type="text" size="7" name="editTravelModeId<%=i %>" id="travelMode<%=i %>"
			value="<%=etrTrvdetails.getTrip().getCodeDesc()%>" class="readOnly" /><input
			type="hidden" id="travelModeHiddenId<%=i %>"
			name="travelModeHiddenId<%=i %>"
			value="<%=etrTrvdetails.getTrip().getId() %>" /></a></td>
			<%if(etrTrvdetails.getBDate()!= null){ %>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter1%>'),'editTravelRequest')"><input
			type="text" size="10" name="editBookingDate<%=i %>" id="bookingDate<%=i %>"
			value="<%=HMSUtil.convertDateToStringWithoutTime(etrTrvdetails.getBDate())%>"
			class="readOnly" /></a></td>
			<%}if(etrTrvdetails.getBeforeTime()!= null){ %>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter1%>'),'editTravelRequest')"><input
			type="text" size="7" name="editTicketTime<%=i %>" id="ticketTime<%=i %>"
			value="<%=etrTrvdetails.getBeforeTime()%>" class="readOnly" /></a></td>
			<%}if(etrTrvdetails.getRemarks()!= null){ %>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter1%>'),'editTravelRequest')"><input
			type="text" size="10" name="editRemak<%=i %>" id="remarkId<%=i %>"
			value="<%=etrTrvdetails.getRemarks()%>" class="readOnly" /></a></td>
			<%} %>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter1%>'),'editTravelRequest')"><input
			type="text"size="10"  name="fromEditCountryId" id="fromCountryId<%=i %>"
			value="<%=fromCountry%>" class="readOnly" /><input type="hidden"
			id="fromCountryHiddenId<%=i %>" name="fromCountryHiddenId<%=i %>"
			value="<%=fromCountryId %>" /></a></td>
		<td><a
			href="javascript:Request(document.getElementById('<%=counter1%>'),'editTravelRequest')"><input
			type="text" size="10" name="toEditCountryId" id="toCountryId<%=i %>"
			value="<%=toCountry%>" class="readOnly" /><input type="hidden"
			id="toCountryHiddenId<%=i %>" name="toCountryHiddenId<%=i %>"
			value="<%=toCountryId %>" /> </a></td>
	</tr>
	<input type="hidden"
	name="<%=ETR_TRV_DETAIL_ID %><%=i %>" value="<%=etrvDetailId %>" />
	<%
		i++;
		}
	%>
</table>

<div class="clear"></div>
</div>
<div class="clear"></div>
<input name="update" type="button" class="button" value="Update"
	onClick="updateTicketBookingDetails();" />
	<div class="clear"></div>
<div class="division"></div>

<div class="auto" id="needAdvanceDiv"><label>Advance</label>


<div class="Block">
<div class="clear"></div>
<label>Amount </label> <input id="amountId"
	name="<%=TRAVEL_ADVANCE_AMOUNT %>"
	validate="Travel Advance Amount,float,no" maxlength="8" /> <script
	type="text/javascript">
          		  document.editTravelRequest.<%=TRAVEL_ADVANCE_AMOUNT%>.value='<%=advanceAmount%>';
            </script>
 <label>Expected On </label> 
 <input id="expectedOnId" type="text" name="<%=EXPECTED_ON_DATE %>" value="" class="date" readonly="readonly" validate="From date ,date,no" MAXLENGTH="30" />
  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.editTravelRequest.<%=EXPECTED_ON_DATE%>,event)" />
<script type="text/javascript">
          		  document.editTravelRequest.<%=EXPECTED_ON_DATE%>.value='<%=expectedOnDate%>';
            </script> <label>Currency</label> <select id="currencyId"
	name="<%=CURRENCY_ID %>" validate="currency,string,no">
	<option value="0">Select</option>
	<%
		for (MasCurrency masCurrency : currencyList) {
	%>
	<option value="<%=masCurrency.getId() %>"><%=masCurrency.getCurrencyCode()%></option>

	<%
		}
	%>
</select> <script type="text/javascript">
          		  document.editTravelRequest.<%=CURRENCY_ID%>.value='<%=currencyId%>';
            </script>
<div class="clear"></div>
<label>Description </label> <input id="descriptionId"
	name="<%=DESCRIPTION %>" class="large" validate="description,string,no" maxlength="8" />
<div class="clear"></div>
<script type="text/javascript">
          		  document.editTravelRequest.<%=DESCRIPTION%>.value='<%=description%>';
            </script>

</div>

<input type="hidden" name="<%=TRAVEL_REQUEST_ID %>"
	value="<%=travelRequestId %>" /> 
<div class="clear"></div>
</div>

<div class="division"></div>
<div class="clear"></div>
<div class="Block">
<label>Hotel Remark</label>
<input type="text" id="hotelBookingId" name="<%=HOTEL_BOOKING_DESC %>" class="large"  value="<%=hotelBookingDesc%>"   validate="Comments,string,no"   maxlength="100" />
<script type="text/javascript">
          		  document.editTravelRequest.<%=HOTEL_BOOKING_DESC%>.value='<%=hotelBookingDesc%>';
            </script>
            <div class="clear"></div>
<label>CAB Remark</label>
<input type="text" id="cabBookingId"  name="<%=CAB_BOOKING_DESC %>" class="large"   value="<%=cabBookingDesc %>" validate="Remarks,string,no"  MAXLENGTH="100"/>
<script type="text/javascript">
          		  document.editTravelRequest.<%=CAB_BOOKING_DESC%>.value='<%=cabBookingDesc%>';
            </script>
<div class="clear"></div>
<label>Cancellation Remark</label>

<input type="text" name="<%=REMARKS_FOR_CANCELATION %>" value=""
	validate="Remarks,string,no" class="large" MAXLENGTH="60" tabindex=1 />
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>
<input name="Update" type="button" class="button" value="Update"
	onClick="submitForm('editTravelRequest','etravel?method=updateTravelRequest','checkFromDate','checkTicketBookingDate','checkExpectedDate');" />
<input name="Cancel" type="button" class="button" value="Cancel" onClick="submitForm('editTravelRequest','etravel?method=cancelNewTravelRequest');" />
<input name="ViewRequest" type="button" class="button" value="Reset"
	onClick="submitForm('newTravelRequest','etravel?method=showTestJsp');" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>
<label>Last Changed By</label> 
<label class="value"><%=userName%></label>

<label>Last Changed DATE</label> 
<label class="value"><%=date%></label>

<label>Last Changed Time</label>
 <label class="value"><%=time%></label>


</div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
	 <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

