<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * appSetup.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<form name="otListChangeSub" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<script type="text/javascript" language="javascript">
var deptSelected=false;
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

		function activateOptions(optionValue) {
			if (optionValue == 'otName') {
				document.getElementById('newOt').disabled = false;
				document.getElementById('newSlNo').disabled = true;
				document.getElementById('newBookingDate').disabled = true;
			}

			if (optionValue == 'slNo') {
				document.getElementById('newOt').disabled = true;
				document.getElementById('newSlNo').disabled = false;
				document.getElementById('newBookingDate').disabled = true;
			}
			if (optionValue == 'bookingDate') {
				document.getElementById('newOt').disabled = true;
				document.getElementById('newSlNo').disabled = true;
				document.getElementById('newBookingDate').disabled = false;
			}
		}

		function checkForSelection() {
			for (var i = 0; i < document.getElementsByName('changeCriteria').length; i++) {
				if (document.getElementsByName('changeCriteria')[i].checked == true) {
					var optionValue = document
							.getElementsByName('changeCriteria')[i].value;
					if (optionValue == 'otName') {
						if (document.getElementById('newOt').value == "0") {
							alert("Select OT!!");
							getShadow('newOt');
							return false;
						}
					}
					if (optionValue == 'slNo') {
						if (document.getElementById('newSlNo').value == "0") {
								alert("Select S.No. !!");
							getShadow('newSlNo');
							return false;
						}

					}
					if (optionValue == 'bookingDate') {
						if (document.getElementById('newBookingDate').value == "") {
								alert("Enter Booking Date!!");
							getShadow('newBookingDate');
							return false;
						}
					}
				}
			}
			return true;

		}
	</script>
	<div class="titleBg">
		<h2>OT List Change</h2>
	</div>
	<div class="clear"></div>

	<%
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int otId = 0;
		int slNo = 0;
		Date bookingDate = new Date();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Box box = HMSUtil.getBox(request);
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList2 = new ArrayList<OtBooking>();
		List<MasOtDistribution> masOtList = new ArrayList<MasOtDistribution>();
		int bookingId = 0;
		String url = null;

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		if (map.get("message") != null) {
			String message = (String) map.get("message");
	%>
	<span><%=message%></span>
	<%
		}
		if (map.get("otBookingList") != null) {
			otBookingList = (List) map.get("otBookingList");
		}
		if (map.get("otBookingList2") != null) {
			otBookingList2 = (List) map.get("otBookingList2");
		}
		if (map.get("masOtList") != null) {
			masOtList = (List) map.get("masOtList");
		}
	%>
	<!--Block One Starts-->
	<%
		for (OtBooking otBooking : otBookingList) {
	%>
	<%
		bookingId = otBooking.getId();
	%>
	<input type="hidden" name="selectedId" value="<%=bookingId%>"
		id="selectedId" />
	<div class="Block">
		<label>Name</label>

		<%
			String patName = "";
				patName = otBooking.getHin().getPFirstName();
				if (otBooking.getHin().getPLastName() != null) {
					patName = patName + " " + otBooking.getHin().getPLastName();
				}
		%>
		<input type="text" value="<%=patName%>" name="patName" id="patName"
			readonly="readonly" /> <label>Age</label> <input type="text"
			value="<%=otBooking.getHin().getAge()%>" name="AGE" id="age"
			readonly="readonly" /> <label>Current OT</label><input type="text"
			value="<%=otBooking.getOt().getOtName()%>" name="otName" id="otName"
			readonly="readonly" /> <input type="hidden" name="selectedOtId"
			value="<%=otBooking.getOt().getId()%>" id="selectedOtId" />
		<%
			otId = otBooking.getOt().getId();
		%>
		<label>Current Sl. No.</label> <input type="text" name="selectedSlNo"
			value="<%=otBooking.getSlNo()%>" id="selectedSlNo"
			readonly="readonly" />
		<%
			slNo = otBooking.getSlNo();
		%>

		<label>Booking Date</label> <input type="text"
			name="SelectedBookingDate" readonly="readonly"
			value="<%=HMSUtil.convertDateToStringWithoutTime(otBooking
						.getSurgeryDate())%>"
			id="SelectedBookingDate" />
		<%
			bookingDate = otBooking.getSurgeryDate();
		%>
		<div class="clear"></div>
	</div>
	<%
		}
	%>
	<!--Block one Ends-->

	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div class="Block">
		<input name="changeCriteria" type="radio" id="changeCriteria"
			value="otName" class="radioCheck"
			onclick="activateOptions(this.value);" checked="checked" /><label>Change
			to OT </label> <select id="newOt" name="<%=NEW_OT%>" validate="OT,number,no"
			onchange="checkForAppmtDate()">
			<option value="0">Select</option>
			<%
				for (MasOtDistribution masOtDistribution : masOtList) {

					if (masOtDistribution.getOt().getId() != otId) {
			%>
			<option value="<%=masOtDistribution.getOt().getId()%>"><%=masOtDistribution.getOt().getOtName()%></option>
			<%
				}
				}
			%>
		</select>

		<div class="clear"></div>

		<input name="changeCriteria" type="radio" id="changeCriteria"
			value="slNo" class="radioCheck"
			onclick="activateOptions(this.value);"><label>Change
				S.No. to</label> <select id="newSlNo" name="<%=NEW_SL_NO%>"
			validate="OT,number,no" onchange="checkForAppmtDate()"
			disabled="disabled">
				<option value="0">Select</option>
				<%
					for (OtBooking otBooking : otBookingList2) {
						if (otBooking.getOt().getId() == otId
								&& otBooking.getSlNo() != slNo
								&& otBooking.getSlNo() != 0) {
				%>
				<option value="<%=otBooking.getSlNo()%>"><%=otBooking.getSlNo()%></option>
				<%
					}
					}
				%>
				<option value="0">Stand By</option>
		</select>

			<div class="clear"></div> <input name="changeCriteria" type="radio"
			id="changeCriteria" value="bookingDate" class="radioCheck"
			onclick="activateOptions(this.value);" /> <label>Change
				Booking Date to</label> <input type="text" id="newBookingDate"
			name="newBookingDate" value="" maxlength="30" readonly="readonly"
			class="date" disabled="disabled" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" onchange="isApptGrCurrentDate1();"
			onClick="setdate('<%=currentDate%>',document.otListChangeSub.newBookingDate,event);" />
			<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div class="division"></div>
	<input name="Input" type="button" class="button" value="Submit"
		onClick="if(checkForSelection()){submitForm('otListChangeSub','ot?method=updateOTSchedule','isOtGrCurrentDate1');}" />
	<input name="Input" type="button" class="button" value="Cancel"
		onClick="submitForm('otListChangeSub','ot?method=showOTListChangeJsp')" />

	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<!--Block Three Starts-->
	<!--Bottom labels starts-->

	<div class="bottom">
		<label>Changed By </label> <label class="value"><%=userName%></label>
		<label>Changed Date </label> <label class="value"><%=currentDate%></label>
		<label>Changed Time </label> <label class="value"><%=time%></label>
		<div class="clear"></div>



		<!--Bottom labels ends-->
</form>
</div>
<!--main content placeholder ends here-->