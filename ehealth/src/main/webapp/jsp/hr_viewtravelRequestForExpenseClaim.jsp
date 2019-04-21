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
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<EtrExpdetails> etrExpDetailList = new ArrayList<EtrExpdetails>();
				List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
				List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
				List<EtrTravelreq> etrTravelReqListForAdvanceList = new ArrayList<EtrTravelreq>();
				List<EtrTicketdetails> etrTicketDetailsList = new ArrayList<EtrTicketdetails>();
				Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("users")!= null){
					users = (Users)map.get("users");
				}
				if(map.get("etrExpDetailList")!= null){
					etrExpDetailList = (List)map.get("etrExpDetailList");
				}
				if(map.get("etrTicketDetailsList")!= null){
					etrTicketDetailsList = (List)map.get("etrTicketDetailsList");
				}
				if(map.get("standardAllowanceList")!= null){
					standardAllowanceList = (List)map.get("standardAllowanceList");
				}
				if(map.get("etrTravelRequestList")!= null){
					etrTravelRequestList = (List)map.get("etrTravelRequestList");
				}
				if(map.get("etrTravelReqListForAdvanceList")!= null){
					etrTravelReqListForAdvanceList = (List)map.get("etrTravelReqListForAdvanceList");
				}
				if(map.get("etrExpSubmitList")!= null){
					etrExpSubmitList = (List)map.get("etrExpSubmitList");
				}
				if(map.get("masCityList")!= null){
					masCityList = (List)map.get("masCityList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				if(map.get("countryList")!= null){
					countryList = (List)map.get("countryList");
				}
				if(map.get("currencyList")!= null){
					currencyList = (List)map.get("currencyList");
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
						 //etrTicketDetailId = etrTicketdetails.getId();
						 //fillBookDetailId = etrTicketdetails.getFbdt().getId();
						 tripName = etrTravelreq.getTrip().getCodeDesc();
						 long mills_per_day = 1000 * 60 * 60 * 24; 
						  noOfDays = ((toDate.getTime() - fromDate.getTime()) / mills_per_day)+1; 
						  if(etrTravelreq.getAdvAmt() != null){
						 advanceTaken = etrTravelreq.getAdvAmt();
						  }
					}
				}
				Date actualFromDate = new Date();
				Date actualToDate =  new Date();
				String deptTime = "";
				String arrivalTime = "";
				String travelStartTime = "";
				String travelEndTime = "";
				String totalTime = "";
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
					if(etrExpsubmit.getExpenseStartTime()!= null){
						travelStartTime = etrExpsubmit.getExpenseStartTime();
					}
					if(etrExpsubmit.getExpenseTotalTime()!= null){
						totalTime = etrExpsubmit.getExpenseTotalTime();
					}
					if(etrExpsubmit.getExpenseEndTime()!= null){
						travelEndTime = etrExpsubmit.getExpenseEndTime();
					}
					etrExpDetailsSet = etrExpsubmit.getEtrExpdetails();
				}
				}
			%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.EtrExpsubmit"%>
<%@page import="jkt.hrms.masters.business.EtrExpdetails"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
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
 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}
</script>
<script type="text/javascript">
function showComboAccordingStatus(travelStatus){
	if(travelStatus=='forward'){
		document.getElementById('otherId').style.display='block';
	}
		else if(travelStatus=='approve'){
			document.getElementById('otherId').style.display ='none'
			}
		else if(travelStatus=='reject'){
		document.getElementById('otherId').style.display='none';
		
		}
		else if(travelStatus=='sendBack'){
		document.getElementById('otherId').style.display='none';
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
</script>




<form name="approveExpenses1" method="post" action="" >
<div class="titleBg"> <h2>Expense Settlement</h2></div>
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
<input type="text"  name="<%=FROM_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>"  readonly="readonly" validate="From date ,date,yes"  MAXLENGTH="30" />

<label>Journey To Date </label>
<input type="text"  name="<%=TO_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>"   readonly="readonly" onblur="calculateNoOfDays();" validate="To date ,date,yes"  MAXLENGTH="30" />
<div class="clear"></div>
<label>No.Of Days </label>
<input id="noOFDaysId" name="<%=NO_OF_DAYS %>"    validate="No. Of Days,string,yes"  readonly="readonly"  maxlength="8" />
<script type="text/javascript">
          		  document.getElementById('noOFDaysId').value='<%=noOfDays%>';
            </script>
<label> From Date </label>
<input type="text"  name="<%=ACTUAL_J_FROM_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(actualFromDate) %>" disabled="disabled" class="date"  readonly="readonly" validate="To date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.viewExpenses.<%=ACTUAL_J_FROM_DATE%>,event)"/>

 <label> To Date </label>
 <input type="text"  name="<%=ACTUAL_J_TO_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(actualToDate) %>"disabled="disabled"  class="date"  readonly="readonly"  validate="To date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.viewExpenses.<%=ACTUAL_J_FROM_DATE%>,event)"/>
  <div class="clear"></div>
 <label>Dep.Time </label>
<input id="beforeTimeId" name="<%=DEPARTURE_TIME %>" disabled="disabled" value="<%=deptTime %>" validate="Before Time,string,no"   maxlength="5"  title="Time Should be in 24 hr Format"   onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTime(this.value,this.id);" />
<label>Arrival Time </label>
<input id="beforeTimeId" name="<%=ARRIVAL_TIME %>" disabled="disabled"  validate="Before Time,string,no"   maxlength="5"  title="Time Should be in 24 hr Format"  value="<%=arrivalTime %>" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTime(this.value,this.id);" />
<label>Advance taken </label>
<input id="beforeTimeId" name="<%=ADVANCE_AMOUNT %>"  disabled="disabled"   maxlength="5"    value="<%=advanceTaken %>"  />
</div>
<input type="hidden" id="travelRequestId" name="<%=TRAVEL_REQUEST_ID %>" value="<%=travelRequestId %>" /> 
<div class="clear"></div>
<div class="division"></div>
<table class="medium">
<tr>
<th>F.Date</th>
<th>To Date</th>
<th>From</th>
<th>To</th>
<th>Currency</th>
<th>Amt</th>


</tr>
<%
	
	String from = "";
	int fromId = 0;
	String to = "";
	int toId = 0;
	
	if(etrTicketDetailsList.size()>0){
		for(EtrTicketdetails etrTicketdetails:etrTicketDetailsList){
	
%>

<tr>

<td><%=HMSUtil.convertDateToStringWithoutTime(fromDate)%></td>
<td><%=HMSUtil.convertDateToStringWithoutTime(toDate)%></td>

<%
if(travelTypeId==10){
	if (etrTicketdetails.getFrmplc() != null) {
			from = etrTicketdetails.getFrmplc().getDistrictName();
		} else {
			from = "";
		}
	  
%> 
<td><%=from %></td>
<% 
}else if(travelTypeId==11) {
			if (etrTicketdetails.getFromCountry() != null) {
				if (etrTicketdetails.getFromCountry().getId() != null) {
					from = etrTicketdetails.getFromCountry().getCountryName();
					//fromId = etrTicketdetails.getFromCountry().getId();
				} else {
					from = "";
				}
			}
            
%>
<td><%=from %></td>

<%} %>

<%
if(travelTypeId==10){
	if (etrTicketdetails.getFrmto() != null) {
		to = etrTicketdetails.getFrmto().getDistrictName();
		//toId = etrTicketdetails.getFrmto().getId();
	} else {
		to = "";
	}
%> 
<td><%=to %></td>
<% 
}else if(travelTypeId==11) {
	if (etrTicketdetails.getToCountry() != null) {
		to = etrTicketdetails.getToCountry().getCountryName();
		//toId = etrTicketdetails.getToCountry().getId();
	} else {
		to = "";
	}


%>
<td><%=to %></td>
<%} %>


<td><%=etrTicketdetails.getCur().getCurrencyCode() %></td>
<%if(etrTicketdetails.getAmt() != null){ %>
<td><%=etrTicketdetails.getAmt()%></td>
<%}else{ %>
<td>--</td>
<%} %>

</tr>


<% }} %>
</table>


<div class="clear"></div>
<div class="division"></div>
<%

BigDecimal totalAdvanceTaken = new BigDecimal(0);
BigDecimal totalsettledAmount = new BigDecimal(0);
BigDecimal balance = new BigDecimal(0);
BigDecimal totalApprovedAmt =  new BigDecimal(0);
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
	<label  style="text-align: left;font:normal 10px verdana ;background-color: white;color: black; ">Travel Start Time:<%=travelStartTime%></label>
<label  style="text-align: left;font:normal 10px verdana ;background-color: white;color: black; ">Travel End Time:<%=travelEndTime%></label>
<label style="text-align: left;font:normal 10px verdana ;background-color: white;color: black; ">Total Time:<%=totalTime%></label>
<label  style="text-align: left;font:normal 10px verdana ;background-color: white;color: black;">Tour Advance:<%=advanceTaken%></label> 
<label style="text-align: left;font:normal 10px verdana;background-color: white;color: black;">Tot. Advance:<%=totalAdvanceTaken%></label>
<label style="text-align: left;font:normal 10px verdana;background-color: white;color: black;">Total Settled:<%=totalsettledAmount%></label>
<label style="text-align: left;font:normal 10px verdana;background-color: white;color: black;">Balance:<%=balance%></label>

<table id="expenseDetail" class="medium">
<tr>
<th>Expense Type </th>
<th>F.Date</th>
<th>To Date</th>
<th>From</th>
<th>To</th>
<th>Currency</th>
<th>Stand. Amt</th>
<th>Actual Amt</th>
<th>Approved</th>
<th>Desc.</th>
</tr>
<%
int i = 0;
BigDecimal totalStndAmt =  new BigDecimal(0);
BigDecimal totalActAmt =  new BigDecimal(0);
if(etrExpDetailList.size()>0){
		for (EtrExpdetails etrExpdetails : etrExpDetailList) {
			//travelRequestId = (Integer)expenseClaim[0];
BigDecimal standardAmount = new BigDecimal(0);
//if(standardAllowanceList.size()>0){
//	for(MstrStandardAllowance mstrStandardAllowance :standardAllowanceList){
	//	
		//standardAmount = mstrStandardAllowance.getAmount();
	//}
//	}

%>

<tr>
<%if(etrExpdetails.getExptype()!= null){ %>
<td><%=etrExpdetails.getExptype().getCodeDesc()%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrExpdetails.getFrmdate()!= null){ %>
<td> <%=HMSUtil.convertDateToStringWithoutTime(etrExpdetails.getFrmdate())%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrExpdetails.getTodate()!= null){ %>
<td><%=HMSUtil.convertDateToStringWithoutTime(etrExpdetails.getTodate())%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(travelTypeId ==10){
	if(etrExpdetails.getFromPalce()!= null){
	%>
<td><%=etrExpdetails.getFromPalce().getDistrictName() %></td>
<%}else{ %>
<td>--</td>

<%}}else if(travelTypeId ==11){ 
	if(etrExpdetails.getFromCountry()!= null){
%>
<td><%=etrExpdetails.getFromCountry().getCountryName() %></td>
<%}else{ %>
<td>--</td>
<%}} %>
<%if(travelTypeId ==10){
	if(etrExpdetails.getToPlace()!= null){
	%>
<td><%=etrExpdetails.getToPlace().getDistrictName() %></td>
<%}else{ %>
<td>--</td>
<%}}else if(travelTypeId ==11){ 
	if(etrExpdetails.getToCountry()!= null){
%>
<td><%=etrExpdetails.getToCountry().getCountryName() %></td>
<%}else{ %>
<td>--</td>
<%}} %>
<%if(etrExpdetails.getCurid()!= null){ %>
<td><%=etrExpdetails.getCurid().getCurrencyCode()%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrExpdetails.getStandardAmount()!= null){ %>
<td><%=etrExpdetails.getStandardAmount() %></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrExpdetails.getAmount()!= null){ %>
<td><%=etrExpdetails.getAmount()%></td>
<%}else{ %>
<td>--</td>
<%} %>

<%if(etrExpdetails.getApprovedExpenseAmount()!= null){ %>
<td><%=etrExpdetails.getApprovedExpenseAmount()%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrExpdetails.getDescription()!= null){ %>
<td><%=etrExpdetails.getDescription() %></td>
<%}else{ %>
<td>--</td>
<%} %><input type="hidden" id="countId" name="<%=ETR_EXPDETAIL_ID%><%=i%>" value="<%=etrExpdetails.getId()%>">
</tr>
<%
totalStndAmt = totalStndAmt.add(standardAmount);
if(etrExpdetails.getAmount() != null){
totalActAmt =totalActAmt.add(etrExpdetails.getAmount());
}
if(etrExpdetails.getApprovedExpenseAmount() != null){
totalApprovedAmt = totalApprovedAmt.add(etrExpdetails.getApprovedExpenseAmount());
}
i++;}
}%>
</table>
<div class="clear"></div>
<label  style="text-align: left;font:normal 10px verdana ;background-color: white;color: black; ">Total Standard:<%=totalStndAmt%></label>
<label  style="text-align: left;font:normal 10px verdana ;background-color: white;color: black; ">Total Actual:<%=totalActAmt%></label>
<label style="text-align: left;font:normal 10px verdana ;background-color: white;color: black; ">Total App.:<%=totalApprovedAmt%></label>
<label  style="text-align: left;font:normal 10px verdana ;background-color: white;color: black; ">Variation:<%=totalStndAmt.subtract(totalActAmt)%></label>

<div class="clear"></div>
<input type="hidden" id="countId" name="counter" value="<%=i%>">
<script type="text/javascript">

function getTrainingId(val)
	{
		
	 	document.travelAdvance.<%=TRAVEL_REQUEST_ID%>.value =val;
  	}

</script>



<div class="clear"></div>

<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label>Mode Of Payment </label>
<select id="projectId" name="<%=PAYMENT_MODE %>"   validate="Mode of Payment,string,yes" >
<option value="0">Select</option>
<option value="cheque">Cheque</option>
<option value="cash">Cash</option>
<option value="accTransfer">a/c Transfer</option>
<option value="dd">DD</option>
<option value="travelersCheque">Travelers Cheque</option>
</select>
<label>Disbursement Date </label>
<input id="disDateId" type="text"  name="<%=DISBURSEMENT_DATE %>" value="" class="date"  readonly="readonly" validate="From date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('disDateId'),event)"/>
<div class="clear"></div>
</div>
<input name="button" type="button" class="button" value="Submit" onClick="submitForm('approveExpenses1','etravel?method=paidTravelExpenseSettlement');"/>

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

