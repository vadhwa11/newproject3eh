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
<%@page import="jkt.hrms.masters.business.EtrTicketdetails"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<EtrExpsubmit> etrExpSubmitList = new ArrayList<EtrExpsubmit>();
				List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
				List<MasCountry> countryList = new ArrayList<MasCountry>();
				List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				List<EtrTicketdetails> etrTicketDetailsList = new ArrayList<EtrTicketdetails>();
				List<MstrCode> mstrCodeForExpesnseTypeList = new ArrayList<MstrCode>();
				List<EtrTravelreq> etrTravelReqListForAdvanceList = new ArrayList<EtrTravelreq>();
				List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
				List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("users")!= null){
					users = (Users)map.get("users");
				}
				if(map.get("etrTravelRequestList")!= null){
					etrTravelRequestList = (List)map.get("etrTravelRequestList");
				}
				if(map.get("etrExpSubmitList")!= null){
					etrExpSubmitList = (List)map.get("etrExpSubmitList");
				}
				if(map.get("etrTicketDetailsList")!= null){
					etrTicketDetailsList = (List)map.get("etrTicketDetailsList");
				}
				if(map.get("standardAllowanceList")!= null){
					standardAllowanceList = (List)map.get("standardAllowanceList");
				}
				if(map.get("etrTravelReqListForAdvanceList")!= null){
					etrTravelReqListForAdvanceList = (List)map.get("etrTravelReqListForAdvanceList");
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
				if(map.get("mstrCodeForExpesnseTypeList")!= null){
					mstrCodeForExpesnseTypeList = (List)map.get("mstrCodeForExpesnseTypeList");
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
				String organization = "";
				String locationName = "";
				String travelType = "";
				int travelTypeId= 0;
				String hotelDesc = "";
				String cabDesc = "";
				int etrTicketDetailId = 0;
				int fillBookDetailId = 0;
				long noOfDays = 0l;
				String tripName = "";
				String projectName = "";
				String siteName = "";
				String ticketBooking = "";
				String cabBooking = "";
				String hotelBooking = "";
				String needAdvance = "";
				String expenseClaimStatus = "";
				BigDecimal advanceTaken = new BigDecimal("0");
				//Set<EtrTrvdetails> etrTrvdetailsSet = new HashSet();
				if(etrTravelRequestList.size()>0){
					for(EtrTravelreq etrTravelreq:etrTravelRequestList){
						travelRequestId = etrTravelreq.getId();
						 refNo =etrTravelreq.getRefNo();
						 fromDate =etrTravelreq.getJfdate();
						 toDate = etrTravelreq.getJtdate();
						 empName = etrTravelreq.getEmp().getFirstName()+" "+etrTravelreq.getEmp().getMiddleName()+" "+etrTravelreq.getEmp().getLastName();
						 employeeId = etrTravelreq.getEmp().getId();
						 rankName = etrTravelreq.getEmp().getRank().getRankName();
						 deptName = etrTravelreq.getEmp().getDepartment().getDepartmentName();
						 locationName =etrTravelreq.getEmp().getLocation().getLocationName();
						 organization = etrTravelreq.getEmp().getHospital().getHospitalName();
						 if(etrTravelreq.getTrip().getId()!= null){
							 travelTypeId = etrTravelreq.getTrip().getId();
							travelType = etrTravelreq.getTrip().getCodeDesc();
						}
						// etrTicketDetailId = etrTicketdetails.getId();
						// fillBookDetailId = etrTicketdetails.getFbdt().getId();
						 tripName = etrTravelreq.getTrip().getCodeDesc();
						 long mills_per_day = 1000 * 60 * 60 * 24; 
						  noOfDays = ((toDate.getTime() - fromDate.getTime()) / mills_per_day)+1; 
						  if(etrTravelreq.getAdvAmt() != null){
							 advanceTaken = etrTravelreq.getAdvAmt();
						  }
						  if(etrTravelreq.getPrj()!= null){
							  projectName  =  etrTravelreq.getPrj().getPrjName();
						  }
						  if(etrTravelreq.getSite()!= null){
							  siteName  = etrTravelreq.getSite().getSiteName();
						  }
						  if(etrTravelreq.getNAFTicket() != null){
								 ticketBooking = etrTravelreq.getNAFTicket();
								 }
								 if(etrTravelreq.getNAFLocalCab()!= null){
									 cabBooking = etrTravelreq.getNAFLocalCab();
								}
								 if(etrTravelreq.getNAFHotel() != null){
									 hotelBooking =etrTravelreq.getNAFHotel();
								}
								 
								 if(etrTravelreq.getAvdReq() != null){
									 needAdvance = etrTravelreq.getAvdReq();
								}	
								 if(etrTravelreq.getExpClaimSts()!= null){
									 expenseClaimStatus = etrTravelreq.getExpClaimSts();
								 }
					}
				}
				Date actualFromDate = new Date();
				Date actualToDate =  new Date();
				String deptTime = "";
				String arrivalTime = "";
				Set<EtrExpdetails> etrExpDetailsSet = new HashSet();
				if(etrExpSubmitList.size()>0){
					for(EtrExpsubmit etrExpsubmit :etrExpSubmitList){
					if(etrExpsubmit.getActFrmDate()!= null){
						actualFromDate = etrExpsubmit.getActFrmDate();
					}
					if(etrExpsubmit.getActTodate()!= null){
						actualToDate =etrExpsubmit.getActTodate();
					}
					if(etrExpsubmit.getActDeptTime()!= null){
						deptTime =etrExpsubmit.getActDeptTime();
					}
					if(etrExpsubmit.getActRtnTime()!= null){
						arrivalTime =etrExpsubmit.getActRtnTime();
					}
					if(etrExpsubmit.getEtrExpdetails() != null){
					etrExpDetailsSet = etrExpsubmit.getEtrExpdetails();
					}
				}
				}
				
			%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.EtrExpsubmit"%>
<%@page import="jkt.hrms.masters.business.EtrExpdetails"%>
<%@page import="jkt.hrms.masters.business.MstrStandardAllowance"%>
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
function openPopupWindow()
{
	var id = document.getElementById('travelRequestId').value;
	var url="/hms/hrms/etravel?method=viewExpensesAttachment&travelRequestId="+id+"";
 	newwindow=window.open(url,'name',"left=80,top=80,height=500,width=550,status=1,scrollbars=1,resizable=0");
}

function myCheck(){
var status = document.getElementById('expenseClaimStatus').value;
if (status != "Approved"){
	alert("Only Approved Request can Print !!!");
	return false;
}

return true;
}

</script>




<form name="viewExpenses" method="post" action="" >
<div class="titleBg"> <h2>View Expenses</h2></div>
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

<label>Trip </label>
<input name="<%=TRIP_ID %>"  value="<%=tripName %>"    maxlength="8" />
<label>Journey From Date </label>
<input type="text"  name="<%=FROM_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>"   readonly="readonly" validate="From date ,date,yes"  MAXLENGTH="30" />

<label>Journey To Date </label>
<input type="text"  name="<%=TO_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>"  readonly="readonly" onblur="calculateNoOfDays();" validate="To date ,date,yes"  MAXLENGTH="30" />
<div class="clear"></div>
<label>No.Of Days </label>
<input id="noOFDaysId" name="<%=NO_OF_DAYS %>"    validate="No. Of Days,string,yes"  readonly="readonly"  maxlength="8" />
<script type="text/javascript">
          		  document.getElementById('noOFDaysId').value='<%=noOfDays%>';
            </script>

<label>Advance taken </label>
<input id="beforeTimeId" name="<%=ADVANCE_AMOUNT %>"  disabled="disabled"   maxlength="5"    value="<%=advanceTaken %>"  />
<label>Expense Claim Status </label>
<input  id = "expenseClaimStatus" name="expenseClaimStatus" disabled="disabled"  validate="Before Time,string,no"   maxlength="5"    value="<%=expenseClaimStatus %>"  />

</div>
<input type="hidden" id="travelRequestId" name="<%=TRAVEL_REQUEST_ID %>" value="<%=travelRequestId %>" /> 
<div class="clear"></div>
<div class="division"></div>
<table>
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
<td><%=HMSUtil.convertDateToStringWithoutTime(fromDate)%></td>
<td><%=HMSUtil.convertDateToStringWithoutTime(toDate)%></td>
<td><%=noOfDays%></td>
<td><%=tripName%></td>


<td><%=projectName %></td>


<td><%=siteName %></td>

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

</table>



<div class="clear"></div>



<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>
<%

BigDecimal totalAdvanceTaken = new BigDecimal(0);
BigDecimal totalsettledAmount = new BigDecimal(0);
BigDecimal balance = new BigDecimal(0);
if(etrTravelReqListForAdvanceList.size()>0){
		for(EtrTravelreq etrTravelreqForAdvance :etrTravelReqListForAdvanceList){	
			
			
			if(etrTravelreqForAdvance.getAdvAmt()!= null){
			totalAdvanceTaken = totalAdvanceTaken.add(etrTravelreqForAdvance.getAdvAmt());
			}
			if(etrTravelreqForAdvance.getAdvancePaidAmt()!= null){
			totalsettledAmount = totalsettledAmount.add(etrTravelreqForAdvance.getAdvancePaidAmt());
			}
			
			balance = totalsettledAmount.subtract(totalAdvanceTaken);
	%>
	<%}} %>
<label  style="text-align: left;font:normal 10px verdana ;background-color: white;color: black;">Tour Advance:<%=advanceTaken%></label> 
<label style="text-align: left;font:normal 10px verdana;background-color: white;color: black;">Tot. Advance:<%=totalAdvanceTaken%></label>
<label style="text-align: left;font:normal 10px verdana;background-color: white;color: black;">Total Settled:<%=totalsettledAmount%></label>
<label style="text-align: left;font:normal 10px verdana;background-color: white;color: black;">Balance:<%=balance%></label>


<table id="expenseDetail">
<tr>
<th>Expense Type </th>
<th>From Date</th>
<th>To Date</th>
<th>From</th>
<th>To</th>
<th>Currency</th>
<th>Standard Amount</th>
<th>Amount</th>
<th>Remark</th>
</tr>
<%
BigDecimal totalStndAmt =  new BigDecimal(0);
BigDecimal totalActAmt =  new BigDecimal(0);
BigDecimal standardAmount = new BigDecimal(0);
int i = 0;
String from = "";
int fromId = 0;
String to = "";
String totalTime = "";
int toId = 0;
	if(etrExpDetailsSet.size()>0){
		for(EtrExpdetails etrExpdetails :etrExpDetailsSet){
			
			if(etrExpdetails.getExp().getExpenseTotalTime()!= null){
				totalTime = etrExpdetails.getExp().getExpenseTotalTime();
		}
		
	
	
	
	%>



<tr>
<td><%=etrExpdetails.getExptype().getCodeDesc() %></td>
<%if(etrExpdetails.getFrmdate() != null){

%>
<td><%=HMSUtil.convertDateToStringWithoutTime(etrExpdetails.getFrmdate()) %></td>
<%
}
%>


<td><%=HMSUtil.convertDateToStringWithoutTime(etrExpdetails.getTodate())%></td>
<%

if(travelTypeId==10){
    	if (etrExpdetails.getFromPalce() != null) {
			from = etrExpdetails.getFromPalce().getDistrictName();
		} else {
			from = "--";
		}
	  
}
else if(travelTypeId==11) {
			if (etrExpdetails.getFromCountry() != null){
				if (etrExpdetails.getFromCountry().getId() != null) {
					from = etrExpdetails.getFromCountry().getCountryName();
					//fromId = etrTicketdetails.getFromCountry().getId();
				} else {
					from = "--";
			    }
			}
}			
else if(travelTypeId == 907){
	if (etrExpdetails.getFromPalce() != null) {
		from = etrExpdetails.getFromPalce().getDistrictName();
	} else {
		from = "--";
	}
}
            
%>
<td><%=from %></td>

<%
if(travelTypeId==10){
	if (etrExpdetails.getToPlace()!= null) {
		to = etrExpdetails.getToPlace().getDistrictName();
		//toId = etrTicketdetails.getFrmto().getId();
	} else {
		to = "--";
	}
}
else if(travelTypeId==11) {
	if (etrExpdetails.getToCountry() != null) {
		to = etrExpdetails.getToCountry().getCountryName();
		//toId = etrTicketdetails.getToCountry().getId();
	} else {
		to = "--";
	}

}
else if(travelTypeId==907){
	if (etrExpdetails.getToPlace()!= null) {
		to = etrExpdetails.getToPlace().getDistrictName();
		//toId = etrTicketdetails.getFrmto().getId();
	} else {
		to = "--";
	}
}
%>
<td><%=to %></td>
<%
// } 

 
%>
<%if(etrExpdetails.getCurid()!= null) { %>
<td><%=etrExpdetails.getCurid().getCurrencyName()%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%
boolean matched = false;
String fixedTime = "12.00";
if(standardAllowanceList.size()>0){
	for(MstrStandardAllowance mstrStandardAllowance :standardAllowanceList){
		if(mstrStandardAllowance.getExpenseType().getId().equals(etrExpdetails.getExptype().getId())){
			if(etrExpdetails.getExptype().getFiftyPercentExpensePaid()!= null){
			if(etrExpdetails.getExptype().getFiftyPercentExpensePaid().equals("y")){
				if(!totalTime .equals("")){
				if(Float.parseFloat(totalTime) < Float.parseFloat(fixedTime) ){
					standardAmount = (mstrStandardAllowance.getAmount()).divide(new BigDecimal(2));
					
				}}else{
					standardAmount = mstrStandardAllowance.getAmount();
			
			
				}}
			}else{
		
			standardAmount = mstrStandardAllowance.getAmount();
			}
			matched = true;
			break;
		}}}

if(matched){
%>
<td><%=standardAmount.multiply(new BigDecimal(noOfDays))%><input type="hidden" name="<%=STANDARD_AMOUNT%><%=i%>" value="<%=standardAmount%>" class="small"  validate="Amount,string,no"  MAXLENGTH="30"  /></td>
 <% }
else{%>
	<td>--
	<input type="hidden" name="<%=STANDARD_AMOUNT%><%=i%>" value="0" class="small"  validate="Amount,string,no"  MAXLENGTH="30"  />
	</td>
<%}
%>
<%if(etrExpdetails.getAmount()!= null) { %>
<td><%=etrExpdetails.getAmount()%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrExpdetails.getDescription()!= null) { %>
<td><%=etrExpdetails.getDescription()%></td>
<%}else{ %>
<td>--</td>
<%} %>
</tr>
<%
totalStndAmt = totalStndAmt.add(standardAmount);
if(etrExpdetails.getAmount() != null){
totalActAmt =totalActAmt.add(etrExpdetails.getAmount());
}


%>
<%
i++;}
}%>
</table>

<label  style="text-align: left;font:normal 10px verdana ;background-color: white;color: black; ">Total Standard:<%=totalStndAmt%></label>
<label  style="text-align: left;font:normal 10px verdana ;background-color: white;color: black; ">Total Amount:<%=totalActAmt%></label>
<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<input name="button" type="button"    class="button" value="View Files" onClick="javascript:openPopupWindow();" />
<input name="back"   type="button"    class="button" value="Print"      onClick="submitForm('viewExpenses','etravel?method=printTravelExpenses','myCheck');"/>
<input name="print"  type="button"    class="button" value="Back"       onClick="submitForm('viewExpenses','etravel?method=showTravelRequestJsp');"/>

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

