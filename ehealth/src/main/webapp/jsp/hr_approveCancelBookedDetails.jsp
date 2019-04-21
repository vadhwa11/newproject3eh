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
				List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				List<MasCountry> countryList = new ArrayList<MasCountry>();
				List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				List<EtrTicketdetails> etrTicketDetailsList = new ArrayList<EtrTicketdetails>();
				List<Object[]> employeeList = new ArrayList<Object[]>();
				List<Object[]> departmentList = new ArrayList<Object[]>();
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
				if(map.get("etrTicketDetailsList")!= null){
					etrTicketDetailsList = (List)map.get("etrTicketDetailsList");
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
				if(map.get("mstrCodeForTravelModeList")!= null){
					mstrCodeForTravelModeList = (List)map.get("mstrCodeForTravelModeList");
				}
				int userEmployeeId = 0;
				if(map.get("employeeId")!= null){
					userEmployeeId = (Integer)map.get("employeeId");
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
				String travelType = "";
				int travelTypeId= 0;
				String locationName = "";
				String organizationName = "";
				int etrTicketDetailId = 0;
				int fillBookDetailId = 0;
				String cancellationRemark = "";
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
						 if(etrTravelreq.getTrip().getId()!= null){
							 travelTypeId = etrTravelreq.getTrip().getId();
							travelType = etrTravelreq.getTrip().getCodeDesc();
						}
						 if(etrTravelreq.getEmp().getLocation()!= null){
							 locationName =  etrTravelreq.getEmp().getLocation().getLocationName();
						 }
						 if(etrTravelreq.getEmp().getHospital()!= null){
							 organizationName =  etrTravelreq.getEmp().getHospital().getHospitalName();
						 }
						 //hotelDesc = etrTicketdetails.getFbdt().getHotelDesc();
						 //cabDesc  = etrTicketdetails.getFbdt().getLocalCABDesc();
						 //etrTicketDetailId = etrTicketdetails.getId();
						 //fillBookDetailId = etrTicketdetails.getFbdt().getId();
						 if(etrTravelreq.getCnclCmts()!= null){
						 cancellationRemark = etrTravelreq.getCnclCmts();
						 }
					}
				}
				
			%>

<script type="text/javascript">
function showComboAccordingStatus(travelStatus){
	if(travelStatus=='forward'){
		document.getElementById('otherId').style.display='block';
		document.getElementById('linemanager').style.display='block';
		
	}
		else if(travelStatus=='approve'){
			document.getElementById('otherId').style.display ='none'
			document.getElementById('linemanager').style.display='none';
			}
		else if(travelStatus=='reject'){
		document.getElementById('otherId').style.display='none';
		document.getElementById('linemanager').style.display='none';
		
		}
		else if(travelStatus=='sendBack'){
		document.getElementById('otherId').style.display='none';
		document.getElementById('linemanager').style.display='none';
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

<%@page import="jkt.hrms.masters.business.EtrTicketdetails"%>
<form name="viewBookedDetails" method="post" action="" >
<div class="titleBg"> <h2>Approve Cancel Booked Details</h2></div>
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
<input name="<%=HOSPITAL_ID %>"  value="<%=organizationName %>"    maxlength="8" />
<div class="clear"></div>
<label>From Date </label>
<input type="text"  name="<%=FROM_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>"   readonly="readonly" validate="From date ,date,yes"  MAXLENGTH="30" />
 
<label> To Date </label>
<input type="text"  name="<%=TO_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>"  readonly="readonly" onblur="calculateNoOfDays();" validate="To date ,date,yes"  MAXLENGTH="30" />
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
<th>Departure.</th>
<th>Arrival</th>
<th>Ticket No</th>
<th>Ticket Type</th>
<th>Amount</th>
<th>Currency</th>

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
<%if(etrTicketdetails.getDeptTime()!= null){ %>
<td><%=etrTicketdetails.getDeptTime() %></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrTicketdetails.getArrTime()!= null){ %>
<td><%=etrTicketdetails.getArrTime()%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrTicketdetails.getTkNo()!= null){ %>
<td><%=etrTicketdetails.getTkNo()%></td>
<%}else{ %>
<td>--</td>
<%} %>

<%if(etrTicketdetails.getTkType()!= null){ %>
<td><%=etrTicketdetails.getTkType().getCodeDesc() %></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrTicketdetails.getAmt()!= null){ %>
<td><%=etrTicketdetails.getAmt()%></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrTicketdetails.getCur()!= null){ %>
<td><%=etrTicketdetails.getCur().getCurrencyCode() %>
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
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Cancellation Remark</label>
<input type="text"  name="<%=COMMENTS %>" value="<%=cancellationRemark %>">
<label>Status</label>
<select name="<%=STATUS %>" validate="Status,string,no" onchange="showComboAccordingStatus(this.value);" >
<option value="0">Select</option>
<option value="approve">Approve</option>
<option value="reject">Reject</option>
<option value="forward">Forward</option>
<option value="sendBack">Send Back</option>
</select>
<div id="linemanager" style="display:none;">
<label>Manager</label>
<select id="lineManagerId" name="<%=LINE_MANAGER%>" validate="LineManager,string,no" >
<option value="0">Select</option>
<%
	
	for(Object[] masEmployee1 :employeeList){
		if(masEmployee1[5]!= null){
			if(masEmployee1[5].equals(userEmployeeId)){
				%>
<option value="<%=masEmployee1[5] %>" selected="selected" ><%=masEmployee1[6]+" "+masEmployee1[8] %></option>
<%break;}}} %>
</select>
</div>
<div id="otherId" style="display:none;">
<label>Other</label>
<input id="otherId1" type="checkbox" name="other"  value=""  class="radioCheck" onclick="InForwardStatusCase();"  />
</div>
<div class="clear"></div>
<div id="departmentId" style="display:none;">
<label>Department </label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>"   onChange="populateEmployee(this.value,'showTravelApprovalRequest')">
<option value="0">Select</option>
<%
	for(Object[] masDepartment:departmentList){
%>
<option value="<%=masDepartment[0]%>"><%=masDepartment[1] %></option>
<%} %>
</select>
</div>

<div id="employeeId" style="display:none;">
<label>Head </label>
<select id="employeeId" name="<%=HEAD_ID %>" validate="Head,string,no"  >
<option value="0">Select</option>
<%for(Object[] masEmployee2 :employeeList){ %>
<option value="<%=masEmployee2[0]%>"><%=masEmployee2[1]+" "+masEmployee2[2]+" "+masEmployee2[3]%></option>
<%} %>
</select>
</div>
<div class="clear"></div>
<label>Remark</label>
<input type="text"  name="<%=REMARK %>" class="large" value="">
<div class="clear"></div>
</div>
<script type="text/javascript">
<%
int counter=0;
for (Object[] masDepartment :departmentList) 
{
for (Object[] masEmployee :employeeList) 
{
if(masDepartment[0] != null){
if(masDepartment[0].equals(masEmployee[9])){
%>
empArr[<%=counter%>] = new Array();
empArr[<%=counter%>][0] = <%=masDepartment[0]%>;
empArr[<%=counter%>][1] = <%=masEmployee[0]%>;									
empArr[<%=counter%>][2] = "<%=masEmployee[1] +" "+masEmployee[2]%>";
<%
counter++;
}
}
}
}
%>
</script> 

<div class="clear"></div>
<input name="button" type="button" class="button" value="Submit" onClick="submitForm('viewBookedDetails','etravel?method=approveCancelBookedDetailsByAdmin');"/>
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

