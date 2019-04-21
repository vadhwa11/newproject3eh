<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.EtrTrvdetails"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hrms.masters.business.MstrCode"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				//List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
				List<MasCountry> countryList = new ArrayList<MasCountry>();
				List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				List<EtrTicketdetails> etrTicketDetailsList = new ArrayList<EtrTicketdetails>();
				Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("users")!= null){
					users = (Users)map.get("users");
				}
				if(map.get("etrTicketDetailsList")!= null){
					etrTicketDetailsList = (List)map.get("etrTicketDetailsList");
				}
				if(map.get("masCityList")!= null){
					masCityList = (List)map.get("masCityList");
				}
				if(map.get("countryList")!= null){
					countryList = (List)map.get("countryList");
				}
				if(map.get("currencyList")!= null){
					currencyList = (List)map.get("currencyList");
				}
				if(map.get("mstrCodeForTravelModeList")!= null){
					mstrCodeForTravelModeList = (List)map.get("mstrCodeForTravelModeList");
				}
				String message = "";
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				int travelRequestId = 0;
				String refNo = "";
				Date fromDate = new Date();
				Date toDate = new Date();
				String empName = "";
				int employeeId = 0;
				String rankName = "";
				String deptName = "";
				String locationName = "";
				String organization = "";
				String travelType = "";
				int travelTypeId= 0;
				String hotelDesc = "";
				String cabDesc = "";
				int etrTicketDetailId = 0;
				int fillBookDetailId = 0;
				
				//Set<EtrTrvdetails> etrTrvdetailsSet = new HashSet();
				if(etrTicketDetailsList.size()>0){
					for(EtrTicketdetails etrTicketdetails:etrTicketDetailsList){
						travelRequestId = etrTicketdetails.getFbdt().getTrv().getId();
						 refNo =etrTicketdetails.getFbdt().getTrv().getRefNo();
						 fromDate =etrTicketdetails.getFbdt().getTrv().getJfdate();
						 toDate = etrTicketdetails.getFbdt().getTrv().getJtdate();
						 empName = etrTicketdetails.getFbdt().getTrv().getEmp().getFirstName()+" "+etrTicketdetails.getFbdt().getTrv().getEmp().getMiddleName()+" "+etrTicketdetails.getFbdt().getTrv().getEmp().getLastName();
						 employeeId = etrTicketdetails.getFbdt().getTrv().getEmp().getId();
						 rankName = etrTicketdetails.getFbdt().getTrv().getEmp().getRank().getRankName();
						 if(etrTicketdetails.getFbdt().getTrv().getEmp().getLocation()!= null){
							 locationName = (String)etrTicketdetails.getFbdt().getTrv().getEmp().getLocation().getLocationName();
						 }
						 if(etrTicketdetails.getFbdt().getTrv().getEmp().getHospital()!= null){
							 organization = (String)etrTicketdetails.getFbdt().getTrv().getEmp().getHospital().getHospitalName();
						 }
						 deptName = etrTicketdetails.getFbdt().getTrv().getEmp().getDepartment().getDepartmentName();
						 if(etrTicketdetails.getFbdt().getTrv().getTrip().getId()!= null){
							 travelTypeId = etrTicketdetails.getFbdt().getTrv().getTrip().getId();
							travelType = etrTicketdetails.getFbdt().getTrv().getTrip().getCodeDesc();
						}
						 hotelDesc = etrTicketdetails.getFbdt().getHotelDesc();
						 cabDesc  = etrTicketdetails.getFbdt().getLocalCABDesc();
						 etrTicketDetailId = etrTicketdetails.getId();
						 fillBookDetailId = etrTicketdetails.getFbdt().getId();
					}
				}
				
			%>



<%@page import="jkt.hrms.masters.business.EtrTicketdetails"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<form name="viewBookedDetails" method="post" action="" >
<div class="titleBg"> <h2>View Booked Details</h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>

<div class="clear"></div>
<div class="Block">
<label>Ref.No</label>
<input name="<%=REFERENCE_NO %>"  value="<%=refNo %>"  validate="No. Of Days,string,yes"   maxlength="8" />

<label>Employee</label>
<input name = "<%=EMPLOYEE_ID %>" value="<%=empName %> "   validate="Start Time,string,yes"   maxlength="8" />
<input type="hidden"  name="<%=EMPLOYEE_HIDDEN_ID %>" value="<%=employeeId%>">

<label>Designation </label>
<input name="<%=RANK_ID %>" value="<%=rankName%>"   />
<div class="clear"></div>
<label>Department </label>
<input name="<%=DEPARTMENT_ID %>"  value="<%=deptName %>"    maxlength="8" />

<label>Location </label>
<input name="<%=LOCATION_ID %>"  value="<%=locationName %>"    maxlength="8" />


<label>Organization </label>
<input name="<%=HOSPITAL_ID %>"  value="<%=organization %>"    maxlength="8" />
<div class="clear"></div>
<label>From Date </label>
<input type="text"  name="<%=FROM_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>"   readonly="readonly" validate="From date ,date,yes"  MAXLENGTH="30" />
 
<label> To Date </label>
<input type="text"  name="<%=TO_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>"   readonly="readonly" onblur="calculateNoOfDays();" validate="To date ,date,yes"  MAXLENGTH="30" />

<label> Fill Date </label>
<input type="text"  name="<%=FILL_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>" class="date"  readonly="readonly" onblur="calculateNoOfDays();" validate="To date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.filledBookedDetails.<%=FILL_DATE%>,event)"/>
 <div class="clear"></div>
</div>
<input type="hidden" id="travelRequestId" name="<%=TRAVEL_REQUEST_ID %>" value="<%=travelRequestId %>" /> 
<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>

<table class="medium">
<tr>
<th>From </th>
<th>To</th>
<th>Mode</th>
<th>Class</th>
<th>Departure</th>
<th>Arrival</th>
<th>Ticket No</th>
<th>Ticket Type</th>
<th>Amount</th>
<th>Currency</th>
<!--  <th>Cancel</th>-->
</tr>
<%
	int i = 0;
	String from = "";
	int fromId = 0;
	String to = "";
	int toId = 0;
	
	if(etrTicketDetailsList.size()>0){
		for(EtrTicketdetails etrTicketdetails:etrTicketDetailsList){
			if(travelTypeId==10){
					if (etrTicketdetails.getFrmplc() != null) {
						if (etrTicketdetails.getFrmplc().getId() != null) {
							from = etrTicketdetails.getFrmplc().getDistrictName();
							fromId = etrTicketdetails.getFrmplc().getId();
						} else {
							from = "";
						}
					  }
					if (etrTicketdetails.getFrmto() != null) {
						if (etrTicketdetails.getFrmto().getId() != null) {
							to = etrTicketdetails.getFrmto().getDistrictName();
							toId = etrTicketdetails.getFrmto().getId();
						} else {
							to = "";
						}
					 }
				    
					}else if(travelTypeId==11) {
							if (etrTicketdetails.getFromCountry() != null) {
								if (etrTicketdetails.getFromCountry().getId() != null) {
									from = etrTicketdetails.getFromCountry().getCountryName();
									fromId = etrTicketdetails.getFromCountry().getId();
								} else {
									from = "";
								}
							}
						if (etrTicketdetails.getToCountry() != null) {
							if (etrTicketdetails.getToCountry().getId() != null) {
								to = etrTicketdetails.getToCountry().getCountryName();
								toId = etrTicketdetails.getToCountry().getId();
							} else {
								to = "";
							}
						}
			    }

	
%>

<tr>
<td><%=from %></td>
<td><%=to %></td>

<%if(etrTicketdetails.getMode()!= null){ %>
<td><%=etrTicketdetails.getMode().getCodeDesc() %></td>
<%}else{ %>
<td>--</td>
<%} %>

<%if(etrTicketdetails.getTicketClass()!= null){ %>
<td><%=etrTicketdetails.getTicketClass().getCodeDesc() %></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrTicketdetails.getDeptTime() != null){ %>
<td><%=etrTicketdetails.getDeptTime() %></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrTicketdetails.getArrTime() != null){ %>
<td><%=etrTicketdetails.getArrTime() %></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrTicketdetails.getTkNo() != null){ %>
<td><%=etrTicketdetails.getTkNo() %></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrTicketdetails.getTkType()!= null){ %>
<td><%=etrTicketdetails.getTkType().getCodeDesc()%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrTicketdetails.getAmt() != null){ %>
<td><%=etrTicketdetails.getAmt()%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrTicketdetails.getCur() != null){ %>
<td><%=etrTicketdetails.getCur().getCurrencyCode()%></td>
<%}else{ %>
<td>--</td>
<%} %>
<input type="hidden" name="<%=ETR_TICKET_DETAIL_ID %><%=i%>" value="<%=etrTicketDetailId %>"></td>
</tr>


<% i++;}} %>
</table>

<input type="hidden" id="countId" name="counter" value="<%=i%>">
<input type="hidden"  name="<%=ETR_FILL_BOOK_DETAIL_ID %>" value="<%=fillBookDetailId %>">

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!--  <h4><u>Hotel Booking</u></h4>
<div class="clear"></div>
<div class="frame">-->
<label class="auto">Hotel Remark</label>
<textarea   id="hotelBookingId" type="textarea" name="<%=HOTEL_BOOKING_DESC %>" value="<%=hotelDesc %>" class="medium" disabled="disabled" validate="HotelDesc,string,no"  MAXLENGTH="60" tabindex=1></textarea>
<script type="text/javascript">
          		  document.viewBookedDetails.<%=HOTEL_BOOKING_DESC%>.value='<%=hotelDesc%>';
            </script>
      
            
<!--  </div>
<label class="Auto">Cancel</label>
<input type="checkbox" name="hotelCancelChekBox"  value="" class="radioCheck" />
<label class="Auto">Comments</label>
<textarea id="cabBookingId"   type="textarea" name="hotelCancelComments"  value="" validate="Remarks,string,no"  MAXLENGTH="60" tabindex=1/></textarea>
<div class="clear"></div>
</div>
<div class="clear"></div>

<h4><u>CabBooking</u></h4>
<div class="clear"></div>
<div class="frame">-->
<label class="auto">Cab Remark</label>
<textarea    type="textarea" name="<%=CAB_BOOKING_DESC %>" value="" class="medium"  validate="HotelDesc,string,no" disabled="disabled"  MAXLENGTH="60" tabindex=1></textarea>
<script type="text/javascript">
          		  document.viewBookedDetails.<%=CAB_BOOKING_DESC%>.value='<%=cabDesc%>';
            </script>
<!--  <label class="Auto">Cancel</label>
<input type="checkbox" name="cabCancelCheckBox"  value="" class="radioCheck" />
<label class="Auto">Comments</label>
<textarea id="cabBookingId"   type="textarea" name="cabCancelComments"  value="" validate="Remarks,string,no"  MAXLENGTH="60" tabindex=1/></textarea>
<div class="clear"></div>

<div class="clear"></div>-->
<!--  <input name="button" type="button" class="button" value="Submit" onClick="submitForm('viewBookedDetails','etravel?method=cancelBookedDetails');"/> 
<div class="clear"></div>
</div>-->
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
		
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
			



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

