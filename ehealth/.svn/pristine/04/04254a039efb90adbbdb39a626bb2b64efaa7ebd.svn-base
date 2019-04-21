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
				List<Object[]>mstrProjectList = new ArrayList<Object[]>();
				List<Object[]>departmentList = new ArrayList<Object[]>();
				List<Object[]> mstrSiteList = new ArrayList<Object[]>();
				List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				List<MstrCode> mstrCodeForTripList = new ArrayList<MstrCode>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<PrjSiteResMap> prjSiteMapList = new ArrayList<PrjSiteResMap>();
				List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
				List<MasCountry> countryList = new ArrayList<MasCountry>();
				List<EtrTravelreq> viewTravelRequestList = new ArrayList<EtrTravelreq>();
				List<EtrTravelreq> etrTravelReqList  = new ArrayList<EtrTravelreq>();
				List<PrjSiteResMap>prjSiteResMapList=new ArrayList<PrjSiteResMap>();
				Users users = new Users();
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("viewTravelRequestList")!= null){
					viewTravelRequestList = (List)map.get("viewTravelRequestList");
				}
				if(map.get("prjSiteResMapList")!= null){
					prjSiteResMapList = (List)map.get("prjSiteResMapList");
				}
				if(map.get("etrTravelReqList")!= null){
					etrTravelReqList = (List)map.get("etrTravelReqList");
				}
				if(map.get("mstrProjectList")!= null){
					mstrProjectList = (List)map.get("mstrProjectList");
				}
				if(map.get("countryList")!= null){
					countryList = (List)map.get("countryList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				if(map.get("mstrSiteList")!= null){
					mstrSiteList = (List)map.get("mstrSiteList");
				}
				if(map.get("masCityList")!= null){
					masCityList = (List)map.get("masCityList");
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
				if(map.get("prjSiteMapList")!= null){
					prjSiteMapList = (List)map.get("prjSiteMapList");
				}
				if(map.get("mstrCodeForTravelModeList")!= null){
					mstrCodeForTravelModeList = (List)map.get("mstrCodeForTravelModeList");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				int userEmployeeId = 0;
				if(map.get("employeeId")!= null){
					userEmployeeId = (Integer)map.get("employeeId");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				String empName = "";
				String rankName = "";
				String empCode = "";
				String deptName = "";
				String locationName = "";
				String organizationName = "";
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
				int employeeId = 0;
				String hotelBookingDesc = "";
				String cabBookingDesc = "";
				String travelStatus = "";
				String comments = null;
				Set<EtrApptbl> etrApptblSet = new HashSet();
				Set<EtrTrvdetails> etrTrvdetailsSet= new HashSet();
				if(viewTravelRequestList.size()>0){
					for(EtrTravelreq etrTravelreq :viewTravelRequestList){
						travelRequestId = etrTravelreq.getId();
						 refNo =etrTravelreq.getRefNo();
						 fromDate =etrTravelreq.getJfdate();
						 toDate = etrTravelreq.getJtdate();
						 empName =etrTravelreq.getEmp().getEmployeeCode() +"-"+etrTravelreq.getEmp().getFirstName()+" "+etrTravelreq.getEmp().getMiddleName()+" "+etrTravelreq.getEmp().getLastName();
						 deptName = etrTravelreq.getEmp().getDepartment().getDepartmentName();
						 locationName = etrTravelreq.getEmp().getLocation().getLocationName();
						 organizationName = etrTravelreq.getEmp().getHospital().getHospitalName();
						 rankName = etrTravelreq.getEmp().getRank().getRankName();
						 if(etrTravelreq.getTrip().getId()!= null){
								travelTypeId = etrTravelreq.getTrip().getId();
						 		tripName = etrTravelreq.getTrip().getCodeDesc();
						 }
						 employeeId = etrTravelreq.getEmp().getId();
						 if(etrTravelreq.getNAFTicket() != null){
						 ticketBooking = etrTravelreq.getNAFTicket();
						 }
						 if(etrTravelreq.getNAFLocalCab() != null){
							 cabBooking = etrTravelreq.getNAFLocalCab();
						}
						 
						 if(etrTravelreq.getComment() != null){
							 comments = etrTravelreq.getComment();
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
						}}
						 if(etrTravelreq.getSite()!= null){
						 if(etrTravelreq.getSite().getId()!= null){
							 siteId = etrTravelreq.getSite().getId();
						 }}
						 if(etrTravelreq.getTrvStatus()!= null){
							 travelStatus = etrTravelreq.getTrvStatus();
						 }
						 
						 long mills_per_day = 1000 * 60 * 60 * 24; 
						  noOfDays = ((toDate.getTime() - fromDate.getTime() ) / mills_per_day)+1; 
						 
						 etrApptblSet = etrTravelreq.getEtrApptbls();
						 etrTrvdetailsSet = etrTravelreq.getEtrTrvdetails();
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
	function selectProject(){
		obj = document.getElementById('prjectBasedId');
		   	if(obj.checked){
				document.getElementById('projectId').value = "";
		   		document.getElementById('projectId').disabled = false;
		   	}else{
		   		document.getElementById('projectId').disabled =true;
		   		
		   	}
		  }
		  
	function showComboAccordingStatus(travelStatus){
	if(travelStatus=='forward'){
		document.getElementById('otherId').style.display='block';
		document.getElementById('linemanager').style.display='block';
		
	}
		else if(travelStatus=='approve'){
			document.getElementById('otherId').style.display ='none'
			document.getElementById('linemanager').style.display ='none'
		}
		else if(travelStatus=='reject'){
		document.getElementById('otherId').style.display='none';
		document.getElementById('linemanager').style.display ='none'
		
		}
		else if(travelStatus=='sendBack'){
		document.getElementById('otherId').style.display='none';
		document.getElementById('linemanager').style.display ='none'
		}
	}
	  
	  
	  function InForwardStatusCase(travelStatus){
		if(document.getElementById('otherId1').checked){
		document.getElementById('departmentId').style.display = 'inline';
		document.getElementById('employeeId').style.display = 'inline';
		}else{
		document.getElementById('departmentId').style.display = 'none';
		document.getElementById('employeeId').style.display = 'none';
		}
	 }
	
	
	  function calculateNoOfDays(){
		var fDate = document.getElementById('fromDateId').value;
		var tDate = document.getElementById('toDateId').value;
		var	startDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var endDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		var oneday = 1000 * 60 * 60 * 24
		
		var diffDays = Math.abs((startDate.getTime() - endDate.getTime()));
		var totalDays = Math.round(diffDays/oneday);
		document.getElementById('noOFDaysId').value = totalDays;

	}
		
		
	  
	  
	 
	  
	  
	function selectTrip(val){
		if(val == "10"){
			document.getElementById('cityId').value = "";
	   		document.getElementById('cityId').disabled = false;
	   		document.getElementById('cityId1').value = "";
	   		document.getElementById('cityId1').disabled = false;
			document.getElementById('countryId').disabled = true;
			document.getElementById('countryId1').disabled = true;
		}else if(val == "11"){
			document.getElementById('countryId').value = "";
	   		document.getElementById('countryId').disabled = false;
	   		document.getElementById('countryId1').value = "";
	   		document.getElementById('countryId1').disabled = false;
			document.getElementById('cityId').disabled = true;
			document.getElementById('cityId1').disabled = true;
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
//-------------------------------------------------------------	  
	  

</script>

<form name="viewTravelRequest" method="post" action="" >
<div class="titleBg"> <h2>View Travel Approval </h2></div>
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
<input name = "<%=EMPLOYEE_ID %>" value="<%=empName%> "   disabled="disabled" />
<input type="hidden"  name="<%=EMPLOYEE_HIDDEN_ID %>" value="<%=employeeId%>">

<label>Designation </label>
<input name="<%=RANK_ID %>" value="<%=rankName %>" disabled="disabled"   />
<div class="clear"></div>
<label>Department </label>
<input name="<%=DEPARTMENT_ID %>"  value="<%=deptName%>"    disabled="disabled"/>
<label>Location </label>
<input name=""  value="<%=locationName %>"   maxlength="8" disabled="disabled"/>

<label>Organization </label>
<input name="<%=START_TIME %>" value="<%=organizationName %>"    maxlength="8" disabled="disabled" />
<div class="clear"></div>
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

 <label>No.Of Days </label>
<input id="noOFDaysId" name="<%=NO_OF_DAYS %>" disabled="disabled"   validate="No. Of Days,string,yes" onfocus="calculateNoOfDays();"  maxlength="8" />
<script type="text/javascript">
          		  document.viewTravelRequest.<%=NO_OF_DAYS%>.value='<%=noOfDays%>';
            </script>
  <div class="clear"></div>           
<label>Travel Type </label>
<select id="trip" name="<%=TRIP_ID %>" validate="Trip,string,yes" onchange="selectTrip(this.value);" disabled="disabled">
<option value="0">Select</option>
<%for(MstrCode mstrCode :mstrCodeForTripList){ %>
<option value="<%=mstrCode.getId() %>"><%=mstrCode.getCodeDesc() %></option>
<%} %>
</select>
<script type="text/javascript">
          		  document.getElementById('trip').value='<%=travelTypeId%>';
            </script>

<label>Project Based</label>
<input id="prjectBasedId" type="radio" name="<%=PROJECT_BASED_TRIP %>" value="2" class="radioCheck"  onclick="selectProject();" />
<label class="auto">Yes</label>

<input id="nonProjectBasedId" type="radio" name="<%=PROJECT_BASED_TRIP %>"   value="1" checked="checked" class="radioCheck" onclick="selectProject();"/>
<label class="medium">No</label>
<%
if(projectBasedOrNonProjectBased == 2){
%>
<script type="text/javascript">
          		
          		  document.getElementById('nonProjectBasedId').checked = true;
</script>
<%
	}else if(projectBasedOrNonProjectBased ==1){
%>
<script type="text/javascript">
          		  document.getElementById('prjectBasedId').checked = true;
            </script>
<%
	}
%>

<label>Project </label>
<select id="projectId" name="<%=PROJECT_ID %>"  validate="Project,string,no" disabled="disabled" onchange="submitProtoAjax('newTravelRequest','etravel?method=getProjectSiteDetailFromAjax');" >
<option value="0">Select</option>
<%
	for(Object[] mstrProject :mstrProjectList){
%>
<option value="<%=mstrProject[0] %>"><%=mstrProject[1] %></option>
<%} %>
</select>
<script type="text/javascript">
          		  document.viewTravelRequest.<%=PROJECT_ID%>.value='<%=projectId%>';
            </script>
            <div class="clear"></div>
<label>Site </label>
<select id="siteId" name="<%=SITE_ID %>"  validate="Project,string,no" disabled="disabled"  >
<option value="0">Select</option>
<%
	for(Object[] mstrSite :mstrSiteList){
%>
<option value="<%=mstrSite[0]%>"><%=mstrSite[1] %></option>
<%}

%>
</select>
<script type="text/javascript">
          		  document.getElementById('siteId').value='<%=siteId%>';
            </script>

<label>Comments </label>            
<textarea  id="CommentId" type="textarea" name="comments" value="<%=comments %>" class="medium"  validate="HotelDesc,string,no"   MAXLENGTH="500" tabindex=1 disabled="disabled"></textarea>
<script type="text/javascript">
          		  document.viewTravelRequest.comments.value='<%=comments%>';
</script>            
            
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
<%if(etrTravelreq1.getPrj()!= null){
if(etrTravelreq1.getPrj().getPrjName()!= null){ %>
<td><%=etrTravelreq1.getPrj().getPrjName()%></td>
<%}}else{%>
<td>--</td>
<%} %>
<%if(etrTravelreq1.getSite()!= null){
if(etrTravelreq1.getSite().getSiteName()!= null){ %>
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
<label class="large">Assistance For Ticket Booking</label>

<div class="clear"></div>
<table id="ticketBooking" class="medium">
<tr>
<th>From Place</th>
<th>To Place</th>
<th>Travel Type</th>
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

<label>Need Advance</label>

<div class="clear"></div>
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
<option value="<%=masCurrency.getId() %>"><%=masCurrency.getCurrencyName() %></option>

<%} %>
</select>

<script type="text/javascript">
          		  document.viewTravelRequest.<%=CURRENCY_ID%>.value='<%=currencyId%>';
            </script>
<div class="clear"></div>
<label>Description </label>
<input id="descriptionId" name="<%=DESCRIPTION %>"  class="large"  validate="Start Time,string,no" disabled="disabled"  maxlength="50" />
<div class="clear"></div>
<script type="text/javascript">
          		  document.viewTravelRequest.<%=DESCRIPTION%>.value='<%=description%>';
            </script>
            <div class="clear"></div>
 </div>
 <div class="clear"></div>
<input type="hidden" name="<%=TRAVEL_REQUEST_ID %>"  value="<%=travelRequestId %>" />
<div class="clear"></div>
<div class="division"></div>

<div class="Block">
<div class="clear"></div>
<label><span>*</span>Status</label>
<select id="statusId" name="<%=STATUS %>" validate="Status,string,no" onchange="showComboAccordingStatus(this.value);" >
<option value="0">Select</option>
<option value="approve">Approve</option>
<option value="reject">Reject</option>
<option value="forward">Forward</option>
<option value="sendBack">Send Back</option>
</select>
<div id="linemanager" style="display:none;">
<label>Manager</label>
<select id="lineManagerId" name="<%=LINE_MANAGER %>" validate="LineManager,string,no" >
<option value="0">Select</option>
<%
	//int employeeId = users.getEmployee().getId();
	for(MasEmployee masEmployee :employeeList){
		if(masEmployee.getLineManager()!= null){
			if(masEmployee.getLineManager().getId().equals(userEmployeeId)){
	%>
<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getLineManager().getFirstName()+" "+masEmployee.getLineManager().getLastName() %></option>
<%}}} %>
</select>
</div>
<div id="otherId" style="display:none;">
<label>Other</label>
<input id="otherId1" type="checkbox" name="other"  value=""  class="radioCheck" onclick="InForwardStatusCase();"  />
</div>
<div class="clear"></div>
<div id="departmentId" style="display:none;">
<label>Department </label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>"   onChange="populateEmployee(this.value,'viewTravelRequest')">
<option value="0">Select</option>
<%
	for(Object[] masDepartment:departmentList){
%>
<option value="<%=masDepartment[0]%>"><%=masDepartment[1]%></option>
<%} %>
</select>
</div>

<div id="employeeId" style="display:none;">
<label>Head </label>
<select id="employeeId" name="<%=HEAD_ID %>" validate="Head,string,no"  >
<option value="0">Select</option>
<%for(MasEmployee masEmployee :employeeList){ %>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
<%} %>
</select>
</div>
<div class="clear"></div>
<label>Remark</label>
<input type="text"  name="<%=REMARK %>"  class="large" value="">
<div class="clear"></div>
<script type="text/javascript">
<%
int counter=0;
for (Object[] masDepartment :departmentList) 
{
for (MasEmployee masEmployee :employeeList) 
{
if(masEmployee.getDepartment() != null){
if(masDepartment[0].equals(masEmployee.getDepartment().getId())){
%>
empArr[<%=counter%>] = new Array();
empArr[<%=counter%>][0] = <%=masDepartment[0]%>;
empArr[<%=counter%>][1] = <%=masEmployee.getId()%>;									
empArr[<%=counter%>][2] = "<%=masEmployee.getFirstName() +" "+masEmployee.getLastName()%>";
<%
counter++;
}
}
}
}
%>
</script> 
<input type="hidden" name="travelStatus" id="travelStatusId" value="<%=travelStatus %>" />
<input name="EditRequest" type="button" class="button" value="Submit" onClick="submitForm('viewTravelRequest','etravel?method=updateTravelApprovalRequest','test');"/>

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />

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
function test(){
	//var count = document.getElementById('countId').value;
	//alert("dfdfdf"+count);
	//for(var i=0;i<count;i++){
		//if(document.getElementById('rb'+i).checked){
		//alert(document.getElementById('travelStatusId'+i).value)
			val = document.getElementById('travelStatusId').value;
			//alert(val)
			if(val == 'Approved'){
				alert("Already Approved Travel");
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
	var status = document.getElementById('statusId').value;
	//alert(status);
	if(status == "0"){
		errMsg += "Status Code can not be blank.\n";
	}
	
	if(errMsg != ""){
		alert(errMsg);
		return false;
	}else
		return true;
}




</script>			



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

