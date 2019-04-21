
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
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

<script type="text/javascript" language="javascript" src="../jsp/js/proto.js"></script>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject>mstrProjectList = new ArrayList<MstrProject>();
				List<MstrSiteHeader> mstrSiteList = new ArrayList<MstrSiteHeader>();
				List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				List<MstrCode> mstrCodeForTripList = new ArrayList<MstrCode>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<PrjSiteResMap> prjSiteMapList = new ArrayList<PrjSiteResMap>();
				List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
				List<MasCountry> countryList = new ArrayList<MasCountry>();
				List<EtrTravelreq> viewTravelRequestList = new ArrayList<EtrTravelreq>();
				Users users = new Users();
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("viewTravelRequestList")!= null){
					viewTravelRequestList = (List)map.get("viewTravelRequestList");
				}
				
				if(map.get("mstrProjectList")!= null){
					mstrProjectList = (List)map.get("mstrProjectList");
				}
				if(map.get("countryList")!= null){
					countryList = (List)map.get("countryList");
				}
				
				if(map.get("mstrSiteList")!= null){
					mstrSiteList = (List)map.get("mstrSiteList");
				}
				if(map.get("masCityList")!= null){
					masCityList  = (List)map.get("masCityList");
				}
				if(map.get("currencyList")!= null){
					currencyList = (List)map.get("currencyList");
				}
				if(map.get("mstrCodeForTripList")!= null){
					mstrCodeForTripList = (List)map.get("mstrCodeForTripList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				
				if(map.get("mstrCodeForTravelModeList")!= null){
					mstrCodeForTravelModeList = (List)map.get("mstrCodeForTravelModeList");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("users")!= null){
					users = (Users)map.get("users");
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
				int travelTypeId  = 0;
				String tripName = "";
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
				String projectName = "";
				String siteName = "";
				int siteId = 0;
				long noOfDays = 0l;
				String hotelBookingDesc = "";
				String cabBookingDesc = "";
				String comments = "";
				int employeeId = 0;
				String empName = "";
				String rankName ="";
				String locationName = "";
				String employeeCode = "";
				String organizationName = "";
				String deptName = "";
				String advanceStatus = "";
				Set<EtrApptbl> etrApptblSet = new HashSet();
				Set<EtrTrvdetails> etrTrvdetailsSet= new HashSet();
				if(viewTravelRequestList.size()>0){
					for(EtrTravelreq etrTravelreq :viewTravelRequestList){
						travelRequestId = etrTravelreq.getId();
						 refNo =etrTravelreq.getRefNo();
						 fromDate =etrTravelreq.getJfdate();
						 toDate = etrTravelreq.getJtdate();
						 if(etrTravelreq.getTrip().getId()!= null){
								travelTypeId = etrTravelreq.getTrip().getId();
						 		tripName = etrTravelreq.getTrip().getCodeDesc();
						 }
						 if(etrTravelreq.getNAFTicket() != null){
						 ticketBooking = etrTravelreq.getNAFTicket();
						 }
						 if(etrTravelreq.getNAFLocalCab() != null){
							 cabBooking = etrTravelreq.getNAFLocalCab();
						}
						 if(etrTravelreq.getNAFHotel() != null){
							 hotelBooking =etrTravelreq.getNAFHotel();
						}
						 
						 if(etrTravelreq.getAvdReq() != null){
							 needAdvance = etrTravelreq.getAvdReq();
						}
						 if(etrTravelreq.getAdvAmt() != null){
							 advanceAmount = etrTravelreq.getAdvAmt();
						}
						 
							  if(etrTravelreq.getAdvcurid()!= null){
							   if(etrTravelreq.getAdvcurid().getId() != null){
								   currencyId = etrTravelreq.getAdvcurid().getId();
								}
							  }
								 
							  if(etrTravelreq.getAdvExpDate() != null){
									 expectedOnDate =HMSUtil.convertDateToStringWithoutTime(etrTravelreq.getAdvExpDate());
								}
						 if(etrTravelreq.getAdvDesc()!= null){
							 description = etrTravelreq.getAdvDesc();
						}
						 if(etrTravelreq.getProjectTrip()!= null){
							 projectBasedOrNonProjectBased = etrTravelreq.getProjectTrip();
						}
						 if(etrTravelreq.getPrj()!= null){
						 if(etrTravelreq.getPrj().getId()!= null){
							 projectId = etrTravelreq.getPrj().getId();
							 projectName = etrTravelreq.getPrj().getPrjDesc();
						}
						 } 
						 if(etrTravelreq.getHotelDesc()!= null){
							 hotelBookingDesc = etrTravelreq.getHotelDesc();
						 }
						 if(etrTravelreq.getLocalCabDesc()!= null){
							 cabBookingDesc = etrTravelreq.getLocalCabDesc();
						 }
						 if(etrTravelreq.getEmp().getId()!= null){
							 employeeId = etrTravelreq.getEmp().getId();
							 empName = etrTravelreq.getEmp().getFirstName()+" "+etrTravelreq.getEmp().getLastName();
							 employeeCode = etrTravelreq.getEmp().getEmployeeCode();
							 
						 }
						 if(etrTravelreq.getEmp().getRank().getId()!= null){
							 empName = etrTravelreq.getEmp().getRank().getRankName();
							 
						 }
						 
						 if(etrTravelreq.getEmp().getLocation().getId()!= null){
							 locationName = etrTravelreq.getEmp().getLocation().getLocationName();
						 }
						 if(etrTravelreq.getEmp().getHospital().getId()!= null){
							 organizationName = etrTravelreq.getEmp().getHospital().getHospitalName();
						 }
						 if(etrTravelreq.getEmp().getDepartment().getId()!= null){
							 deptName = etrTravelreq.getEmp().getDepartment().getDepartmentName();
						 }
						 long mills_per_day = 1000 * 60 * 60 * 24; 
						  noOfDays = ((toDate.getTime() - fromDate.getTime() ) / mills_per_day)+1; 
						 
						 etrApptblSet = etrTravelreq.getEtrApptbls();
						 etrTrvdetailsSet = etrTravelreq.getEtrTrvdetails();
						 
						 if(etrTravelreq.getSite()!= null){
						 if(etrTravelreq.getSite().getId()!= null){
							 siteId = etrTravelreq.getSite().getId();
						 }
						 }
						 if(etrTravelreq.getComment()!= null){
							 comments = etrTravelreq.getComment();
						 }
						 if(etrTravelreq.getAdvStatus()!= null){
							 advanceStatus = etrTravelreq.getAdvStatus();
						 }
					}
				}
			// for(PrjSiteResMap prjSiteResMap1:prjSiteResMapList){
					//siteName = prjSiteResMap1.getSiteHeader().getSiteName();
					//siteId = prjSiteResMap1.getSiteHeader().getId();
				//}
				
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


<form name="viewTravelRequest" method="post" action="" >
<div class="titleBg"> <h2>Pay Advance</h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="Block">
<label>Ref.No</label>
<input name="<%=REFERENCE_NO %>"  value=""  validate="No. Of Days,string,yes"   disabled="disabled" />
<script type="text/javascript">
          		  document.viewTravelRequest.<%=REFERENCE_NO%>.value='<%=refNo%>';
            </script>
<label>Employee</label>
<input name = "<%=EMPLOYEE_ID %>" value="<%=employeeCode+"-"+empName %> "   disabled="disabled" />
<input type="hidden"  name="<%=EMPLOYEE_HIDDEN_ID %>" value="<%=employeeId%>">

<label>Designation </label>
<input name="<%=RANK_ID %>" value="<%=rankName%>" disabled="disabled"   />
<div class="clear"></div>
<label>Department </label>
<input name="<%=DEPARTMENT_ID %>"  value="<%=deptName%>"    disabled="disabled"/>
<label>Location </label>
<input name="<%=LOCATION_ID %>"  value="<%=locationName%>"    maxlength="8" disabled="disabled"/>
<label>Branch </label>
<input name="<%=START_TIME %>"    maxlength="8" disabled="disabled" />
<div class="clear"></div>
<label>Organization </label>
<input name="<%=HOSPITAL_ID %>" value="<%=organizationName%>"     maxlength="8" disabled="disabled" />
<label>From Date </label>
<input id="fromDateId" type="text"  name="<%=FROM_DATE %>" value=""   disabled="disabled" validate="From date ,date,yes"  MAXLENGTH="30" />
 
 <script type="text/javascript">
          		  document.viewTravelRequest.<%=FROM_DATE%>.value='<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>';
            </script>
 <label> To Date </label>
<input id="toDateId" type="text"  name="<%=TO_DATE %>" value=""   disabled="disabled"  validate="To date ,date,yes"  MAXLENGTH="30" />
 
 <script type="text/javascript">
          		  document.viewTravelRequest.<%=TO_DATE%>.value='<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>';
            </script>
 <div class="clear"></div>
 <label>No.Of Days </label>
<input id="noOFDaysId" name="<%=NO_OF_DAYS %>" disabled="disabled"   validate="No. Of Days,string,no"  maxlength="8" />
<script type="text/javascript">
          		  document.viewTravelRequest.<%=NO_OF_DAYS%>.value='<%=noOfDays%>';
            </script>
<label>Travel Type </label>
<select id="trip" name="<%=TRIP_ID %>" validate="Trip,string,yes"  disabled="disabled">
<option value="0">Select</option>
<%for(MstrCode mstrCode :mstrCodeForTripList){ %>
<option value="<%=mstrCode.getId() %>"><%=mstrCode.getCodeDesc() %></option>
<%} %>
</select>
<script type="text/javascript">
          		  document.getElementById('trip').value='<%=travelTypeId%>';
            </script>

<label>Project Based</label>
<input id="prjectBasedId" type="radio" name="<%=PROJECT_BASED_TRIP %>" disabled="disabled" value="2" class="radioCheck"  />
<label class="auto">Yes</label>

<input id="nonProjectBasedId" type="radio" name="<%=PROJECT_BASED_TRIP %>"  disabled="disabled" value="1" checked="checked" class="radioCheck" />
<label class="medium">No</label>
<%
if(projectBasedOrNonProjectBased ==1){
%>
<script type="text/javascript">
          		
          		  document.getElementById('nonProjectBasedId').checked = true;
</script>
<%
	}else if(projectBasedOrNonProjectBased ==2){
%>
<script type="text/javascript">
          		  document.getElementById('prjectBasedId').checked = true;
            </script>
<%
	}
%>
<div class="clear"></div>
<label>Project </label>
<select id="projectId" name="<%=PROJECT_ID %>"  validate="Project,string,no" disabled="disabled" / >
<option value="0">Select</option>
<%
	for(MstrProject mstrProject :mstrProjectList){
%>
<option value="<%=mstrProject.getId() %>"><%=mstrProject.getPrjName() %></option>
<%} %>
</select>
<script type="text/javascript">
          		  document.viewTravelRequest.<%=PROJECT_ID%>.value='<%=projectId%>';
            </script>
<label>Site </label>
<select id="siteId" name="<%=SITE_ID %>"  validate="Site,string,no" disabled="disabled"  >
<option value="0">Select</option>
<%
	for(MstrSiteHeader mstrSite :mstrSiteList){
%>
<option value="<%=mstrSite.getId() %>"><%=mstrSite.getSiteName() %></option>
<%} %>
</select>

<script type="text/javascript">
          		  document.getElementById('siteId').value='<%=siteId%>';
            </script>
           
<label>Comment </label>
<input type="text" id="remarksId" name="<%=COMMENTS %>" value="<%=comments%>" disabled="disabled"  validate="Comments,string,no"   maxlength="8" />


<div class="clear"></div>
</div>
<div class="clear"></div>
<table class="medium">
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
	<%
	if(viewTravelRequestList.size()>0){
		for(EtrTravelreq etrTravelreq1 :viewTravelRequestList){
			travelRequestId = etrTravelreq1.getId();
			fromDate =etrTravelreq1.getJfdate();
			 toDate = etrTravelreq1.getJtdate();
			 if(etrTravelreq1.getTrip().getId()!= null){
				// tripId = etrTravelreq.getTrip().getId();
			 tripName = etrTravelreq1.getTrip().getCodeDesc();
			 }
			 if(etrTravelreq1.getNAFTicket() != null){
			 ticketBooking = etrTravelreq1.getNAFTicket();
			 }
			 if(etrTravelreq1.getNAFLocalCab() != null){
				 cabBooking = etrTravelreq1.getNAFLocalCab();
			}
			 if(etrTravelreq1.getNAFHotel() != null){
				 hotelBooking =etrTravelreq1.getNAFHotel();
			}
			 //if(etrTravelreq1.getPrj().getId()!= null){
				// projectId = etrTravelreq1.getPrj().getId();
				 //projectName = etrTravelreq.getPrj().getPrjDesc();
			//}
			 if(etrTravelreq1.getAvdReq() != null){
				 needAdvance = etrTravelreq1.getAvdReq();
			}	
		
	%>
<tr>
<td><%=HMSUtil.convertDateToStringWithoutTime(fromDate)%></td>
<td><%=HMSUtil.convertDateToStringWithoutTime(toDate)%></td>
<td><%=noOfDays%></td>
<td><%=tripName%></td>
<%
if(etrTravelreq1.getPrj()!= null){
if(etrTravelreq1.getPrj().getId()!= null){ %>
<td><%=etrTravelreq1.getPrj().getPrjName()%></td>
<%}}else{%>
<td>--</td>
<%} %>
<%if(etrTravelreq1.getSite()!= null){		
if(etrTravelreq1.getSite().getId()!= null){ %>
<td><%=etrTravelreq1.getSite().getSiteName()%></td>
<%}}else{ %>
<td>--</td>
<%} %>
<%if(ticketBooking.equals("y")){ %>
<td><input  type="checkbox" name="<%=TICKET_BOOKING%>" checked="checked" value="" disabled="disabled" class="radioCheck" /></td>
<%}else{ %>
<td><input  type="checkbox" name="<%=TICKET_BOOKING%>" value="" disabled="disabled" class="radioCheck" /></td>
<%} %>
<%if(needAdvance.equals("y")){ %>
<td><input  type="checkbox" name="<%=NEED_ADVANCE%>" checked="checked" value="" disabled="disabled" class="radioCheck" /></td>
<%}else{ %>
<td><input  type="checkbox" name="<%=NEED_ADVANCE%>"  value="" disabled="disabled" class="radioCheck" /></td>
<%} %>
<%if(hotelBooking.equals("y")){ %>
<td><input  type="checkbox" name="<%=HOTEL_BOOKING%>" checked="checked" value="" disabled="disabled" class="radioCheck" /></td>
<%}else{ %>
<td><input  type="checkbox" name="<%=HOTEL_BOOKING%>" value="" disabled="disabled" class="radioCheck" /></td>
<%} %>
<%if(cabBooking.equals("y")){ %>
<td><input  type="checkbox" name="<%=CAB_BOOKING%>" checked="checked" value="" disabled="disabled" class="radioCheck" /></td>
<%}else{ %>
<td><input  type="checkbox" name="<%=CAB_BOOKING%>"  value="" disabled="disabled" class="radioCheck" /></td>
<%} %>
</tr>
<% }
 }
%>
</table>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<label class="auto">Ticket Booking</label>

<div class="clear"></div>
<table id="ticketBooking" class="medium">
<tr>
<th>From Place</th>
<th>To Place</th>
<th>Travel Mode</th>
<th>Date</th>
<th>Remarks</th>
<th>From Country</th>
<th>To Country</th>
</tr>

<%		
		int etrvDetailId = 0;
		String fromPlace = "";
		String toPlace = "";
		String fromCountry = "";
		String toCountry = "";
		for(EtrTrvdetails etrTrvdetails :etrTrvdetailsSet){
			
			if(etrTrvdetails.getId()!= null){
				etrvDetailId = etrTrvdetails.getId();
			}
			
			for(MasDistrict masDistrict :masCityList){
				if(etrTrvdetails.getFrmPlce() != null){
				if(etrTrvdetails.getFrmPlce().getId() != null){
			//if(etrTrvdetails.getFrmPlce().getId() .equals(mstrCity.getId())){
				fromPlace = etrTrvdetails.getFrmPlce().getDistrictName();
			}else{
				fromPlace = "";
			}
		  }
		}
	 //}
			for(MasDistrict masDistrict :masCityList){
				if(etrTrvdetails.getToPlce() != null){
				if(etrTrvdetails.getToPlce().getId() != null){
			//if(etrTrvdetails.getToPlce().getId() .equals(mstrCity.getId())){
				toPlace = etrTrvdetails.getToPlce().getDistrictName();
			}else{
				toPlace = "";
			}
		  }
		}
	// }
			for(MasCountry masCountry :countryList){
				if(etrTrvdetails.getFromCountry() != null){
				if(etrTrvdetails.getFromCountry().getId() != null){
			//if(etrTrvdetails.getFromCountry().getId() .equals(masCountry.getId())){
				fromCountry = etrTrvdetails.getFromCountry().getCountryName();
			}else{
				fromCountry = "";
			}
		  }
		}
	 //}
			for(MasCountry masCountry :countryList){
				if(etrTrvdetails.getToCountry() != null){
				if(etrTrvdetails.getToCountry().getId() != null){
			//if(etrTrvdetails.getToCountry().getId() .equals(masCountry.getId())){
				toCountry = etrTrvdetails.getToCountry().getCountryName();
			}else{
				toCountry = "";
			}
		  }
		}
	// }
%>
<tr>
<td><%= fromPlace %></td>
<td><%=toPlace %></td>
<td><%=etrTrvdetails.getTrip().getCodeDesc() %></td>


<%if(etrTrvdetails.getBDate()!= null){ %>
<td><%=HMSUtil.convertDateToStringWithoutTime(etrTrvdetails.getBDate()) %></td>
<%}else{%>
<td>--</td>

<%} %>


<%
if(etrTrvdetails.getRemarks()!= null){ %>
<td><%=etrTrvdetails.getRemarks() %></td>
<%}else{ %>
<td>--</td>
<%} %>


<td><%=fromCountry %></td>

<td><%=toCountry%></td>


</tr>
<%} %>
</table>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<label class="auto">Advance</label>


<div class="Block">
<div class="clear"></div>
<label>Amount </label>
<input id="amountId" name="<%=TRAVEL_ADVANCE_AMOUNT %>"   validate="Start Time,string,no" disabled="disabled"  maxlength="8" />
<script type="text/javascript">
          		  document.viewTravelRequest.<%=TRAVEL_ADVANCE_AMOUNT%>.value='<%=advanceAmount%>';
            </script>
<label>Expected On </label>
<input id="expectedOnId"  type="text"  name="<%=EXPECTED_ON_DATE %>" value="" class="date"  disabled="disabled" validate="From date ,date,no"  MAXLENGTH="30" />
 <script type="text/javascript">
          		  document.viewTravelRequest.<%=EXPECTED_ON_DATE%>.value='<%=expectedOnDate%>';
            </script>
<label>Currency</label>
<select id="currencyId" name="<%=CURRENCY_ID %>" validate="Wednesday Shift Code,string,no" disabled="disabled" >
<option value="0">Select</option>
<%
for(MasCurrency masCurrency :currencyList){ 
%>
<option value="<%=masCurrency.getId() %>"><%=masCurrency.getCurrencyCode() %></option>

<%} %>
</select>

<script type="text/javascript">
          		  document.viewTravelRequest.<%=CURRENCY_ID%>.value='<%=currencyId%>';
            </script>
<div class="clear"></div>
<label>Description </label>
<input id="descriptionId" name="<%=DESCRIPTION %>"   validate="Start Time,string,no" disabled="disabled"  maxlength="8" />
<div class="clear"></div>
<script type="text/javascript">
          		  document.viewTravelRequest.<%=DESCRIPTION%>.value='<%=description%>';
            </script>
            <div class="clear"></div>
 </div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <div class="Block">
<div class="clear"></div>
<label>Hotel Remark</label>
<input  id="hotelBookingId" type="text" name="<%=HOTEL_BOOKING_DESC %>" disabled="disabled" value="<%=hotelBookingDesc %>" class="large"  validate="HotelDesc,string,no"   MAXLENGTH="500" tabindex=1/>
<script type="text/javascript">
          		  document.viewTravelRequest.<%=HOTEL_BOOKING_DESC%>.value='<%=hotelBookingDesc%>';
            </script>
            <div class="clear"></div>
<label>CAB Remark</label>
<input id="cabBookingId" type="text" name="<%=CAB_BOOKING_DESC %>" disabled="disabled" class="large"   value="<%=cabBookingDesc %>" validate="Remarks,string,no"  MAXLENGTH="500" tabindex=1/>
<script type="text/javascript">
          		  document.viewTravelRequest.<%=CAB_BOOKING_DESC%>.value='<%=cabBookingDesc%>';
            </script>
<div class="clear"></div>
<div>
<input type="hidden" name="<%=TRAVEL_REQUEST_ID %>"  value="<%=travelRequestId %>" />
<input type="hidden" name="advanceStatus" id="advanceStatusId" value="<%=advanceStatus%>" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Mode Of Payment </label>
<select id="modeOfPaymentId" name="<%=PAYMENT_MODE %>"   validate="Mode of Payment,string,no" >
<option value="0">Select</option>
<option value="cheque">Cheque</option>
<option value="cash">Cash</option>
<option value="accTransfer">a/c Transfer</option>
<option value="dd">DD</option>
<option value="travelersCheque">Travelers Cheque</option>
</select>
<label><span>*</span>Disbursement Date </label>
<input id="disDateId" type="text"  name="<%=DISBURSEMENT_DATE %>" value="" class="date"  readonly="readonly" validate="Disbursement date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('disDateId'),event)"/>
 <label><span>*</span>Amount Paid</label>
 <input id="advanceAmountId" type="text"  name="<%=ADVANCE_PAID%>" value="<%=advanceAmount%>"  validate="Advance Paid,float,no"   maxlength="8" />
<div class="clear"></div>
</div>
<input name="button" type="button" class="button" value="Submit" onClick="submitForm('viewTravelRequest','etravel?method=paidTravelAdvanceAmount','test');"/>
<input type="button" name="back" id="back" value="Back" class="button" onClick="backPayAdvance();" accesskey="b" tabindex=1 />


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
			
<script type="text/javascript">
formName = "viewTravelRequest"
function test(){
	
			val = document.getElementById('advanceStatusId').value;
			//alert(val)
			if(val == 'Paid'){
				alert("Already Paid Advance");
				return false;
			}else{
				if(validateFieldsForDisplay())
					return true;
					else
					return false;
			}
		}
	


function validateFieldsForDisplay(){
	var errMsg = "";
	var status = document.getElementById('modeOfPaymentId').value;
	var disbursementdate = document.getElementById('disDateId').value;
	var advanceAmount = document.getElementById('advanceAmountId').value;
	
	//alert(status);
	if(status == "0"){
		errMsg += "Status Code can not be blank.\n";
	}
	if(disbursementdate == ""){
		errMsg += "Disbursement Date can not be blank.\n";
	}
	if(advanceAmount == 0){
		errMsg += "Advance Amount can not be blank.\n";
	}
	
	if(errMsg != ""){
		alert(errMsg);
		return false;
	}else
		return true;
}

function backPayAdvance()
 {
   obj = eval('document.'+formName)
     obj.action = "etravel?method=showTravelAdvanceJsp";
     obj.submit();
     return true;
 
 }





</script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

