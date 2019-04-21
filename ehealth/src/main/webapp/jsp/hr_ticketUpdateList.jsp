<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.EtrTrvdetails"%>
<%@page import="java.math.BigDecimal"%>
<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				Set<EtrApptbl> etrApptblSet = new HashSet<EtrApptbl>();
				List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
				Set<EtrFillbookeddtls> etrFillBookDetailSet= new HashSet();
				List<MasEmployee> userEmployeeList = new ArrayList<MasEmployee>();
				Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("userEmployeeList")!= null){
					userEmployeeList = (List)map.get("userEmployeeList");
				}
				
				if(map.get("etrTravelRequestList")!= null){
					etrTravelRequestList = (List)map.get("etrTravelRequestList");
				}
				if(map.get("etrTravelReqList")!= null){
					etrTravelReqList = (List)map.get("etrTravelReqList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
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
				String locationName = "";
				String empName = "";
				int empId = 0;
				String designation = "";
				String department = "";
				String orgnization = "";
				if(userEmployeeList.size()>0){
					for(MasEmployee masEmployee1 :userEmployeeList){
						if(masEmployee1.getLocation() != null){
						locationName = masEmployee1.getLocation().getLocationName();
						}
						empName = masEmployee1.getFirstName()+" "+masEmployee1.getMiddleName()+" "+masEmployee1.getLastName()+"-"+masEmployee1.getEmployeeCode();
							
						if(masEmployee1.getDepartment() != null){
							department = masEmployee1.getDepartment().getDepartmentName();
							}
						if(masEmployee1.getRank() != null){
							designation = masEmployee1.getRank().getRankName();
							}
						if(masEmployee1.getHospital() != null){
							orgnization = masEmployee1.getHospital().getHospitalName();
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


<%@page import="jkt.hrms.masters.business.EtrApptbl"%>
<%@page import="jkt.hrms.masters.business.EtrFillbookeddtls"%>

<div class="titleBg"> <h2>Ticket Update List </h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="Block">
<label>Employee</label>
<label class="large"><%=empName%></label>
<label>Designation </label>
<label class="large"> <%=designation%></label>
<div class="clear"></div>
<label>Department </label>
<label class="large"><%=department %> </label>

<label >Location </label>
<label class="large"><%=locationName %> </label>
<div class="clear"></div>
<label>Organization </label>
<label class="large"><%=orgnization%>  </label>

<div class="clear"></div>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Ref. No</label>
<select  name="searchRefNoId" validate="Project Status,string,no"  >
<option value="0">Select</option>
<%for(EtrTravelreq etrTravelreq :etrTravelRequestList){ %>
<option value="<%=etrTravelreq.getId() %>"><%=etrTravelreq.getRefNo()%></option>
<%} %>
</select>
<label>Employee</label>
<select  name="<%=EMPLOYEE_ID %>" validate="Employee ,string,no"  >
<option value="0">Select</option>
<%for(MasEmployee  masEmployee:employeeList){ %>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
<%} %>
</select>
<div class="clear"></div>
<label>From Date </label>
<input id="fromDateId" type="text"  name="<%=FROM_DATE %>" value="" class="date"  readonly="readonly" validate="LOI date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('fromDateId'),event)"/>

<label>To Date </label>
<input id="toDateId" type="text"  name="<%=TO_DATE %>" value="" class="date"  readonly="readonly" validate="LOI date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('toDateId'),event)"/>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','etravel?method=searchTravelBookingUpdateList')" tabindex=1  />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<% 
if(map.get("search") != null)
{
%>
<a href="etravel?method=showTicketUpdateListJsp">Show All Records</a>

<%
}
%>

<form name="ticketUpdateList" method="post" action="" >
<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>

<table id="searchresulttable"  width="100%" cellspacing="0" cellpadding="0">
<tr>
<th>Select</th>
<th>Employee</th>
<th>Ref. No</th>
<th>From Date</th>
<th>To Date</th>
<th>Trip Type</th>
<th>Ticket</th>
<th>Hotel</th>
<th>Cab</th>
<th>Approved By</th>
<th>Travel Status</th>
<th>Ticket Status</th>
</tr>
<tbody id="tableData">
<%

	int count = 0;
	int i = 0;
	int travelRequestId = 0;
	String hotelDesc = "";
	String approver = "";
	String cabDesc = "";
	String klass = "even";
	String statusTime = "";
	String statusDate = "";
	String bookStatus = "";
	String bookedStatusTime = "";
	String bookedStatusDate = "";
 if(etrTravelRequestList.size()>0){
	for (EtrTravelreq etrTravelreq :etrTravelRequestList) {
		if(etrTravelreq.getNAFHotel().equals("y") || etrTravelreq.getNAFLocalCab().equals("y") || etrTravelreq.getNAFTicket().equals("y")){
			travelRequestId = etrTravelreq.getId();
			
			String reqStatus = "";
			if(etrTravelreq.getTrvStatus()!= null){
				reqStatus = etrTravelreq.getTrvStatus();
			}
			if(etrTravelreq.getBookStatus() != null){
				bookStatus = etrTravelreq.getBookStatus();
			}
			etrApptblSet = etrTravelreq.getEtrApptbls(); 
			etrFillBookDetailSet =etrTravelreq.getEtrFillbookeddtls(); 
			if(etrApptblSet.size()>0){
				for(EtrApptbl etrApptbl :etrApptblSet){
					approver = etrApptbl.getAppr().getFirstName()+" "+etrApptbl.getAppr().getLastName();
					}
			   }
			
			Date approverdate = null;
			String approverTime = "";
			if(etrFillBookDetailSet.size()>0){
			 for(EtrFillbookeddtls  etrFillbookeddtls:etrFillBookDetailSet){
				 if(etrFillbookeddtls.getCreatedAt() != null){
				 approverdate   = etrFillbookeddtls.getCreatedAt();
				 }
				// if(etrFillbookeddtls.getTicketBookTime()!= null){
				 //approverTime = etrFillbookeddtls.getTicketBookTime();
				// }
				}
			}
	//-----------------------------
			if(reqStatus.equals("NewRequest")){
				if(etrTravelreq.getCreatedAt()!= null){
				statusDate = (String)HMSUtil.convertDateToStringWithoutTime(etrTravelreq.getCreatedAt());
				}
				//if(etrTravelreq.getLastChgBy()!= null){
				//	statusTime = (String)(etrTravelreq.getLastChgBy());
				//	}
				
			}else if(reqStatus.equals("Approved")){
				if(etrApptblSet.size()>0){
					 for(EtrApptbl etrApptbl:etrApptblSet){
						 if(etrApptbl.getApprDate() != null){
							 statusDate   = (String)HMSUtil.convertDateToStringWithoutTime(etrApptbl.getApprDate());
						 }
						 if(etrApptbl.getApprTime()!= null){
							 statusTime =(String)etrApptbl.getApprTime();
						 }
						}
					}
			}else if(reqStatus.equals("Reject")){
				if(etrApptblSet.size()>0){
					 for(EtrApptbl etrApptbl:etrApptblSet){
						 if(etrApptbl.getApprDate() != null){
							 statusDate   = (String)HMSUtil.convertDateToStringWithoutTime(etrApptbl.getApprDate());
						 }
						 if(etrApptbl.getApprTime()!= null){
							 statusTime =(String)etrApptbl.getApprTime();
						 }
						}
					}
			  }else if(reqStatus.equals("Forward")){
					if(etrApptblSet.size()>0){
						 for(EtrApptbl etrApptbl:etrApptblSet){
							 if(etrApptbl.getApprDate() != null){
								 statusDate   = (String)HMSUtil.convertDateToStringWithoutTime(etrApptbl.getApprDate());
							 }
							 if(etrApptbl.getApprTime()!= null){
								 statusTime =(String)etrApptbl.getApprTime();
							 }
							}
						}
				  }
			
	
	
	
	
	
			 	
	  			String id = "";
		 		id = "id" + count;
		 		count++;
		 		
		 		if(count%2==0){
		 			klass = "even"; 
		 		}
		 		else
		 		{
		 			klass= "odd";
		 		}
		 	 	
		 		
		 	
%>

<tr class=<%= klass%> id="<%=count%>" >
<td><input name="<%=TRAVEL_REQUEST_ID%><%=i%>"  class="radioCheck" id="rb<%=i%>" type="checkbox" onclick="disableCheckBoxes(<%=i %>);" value="<%=travelRequestId%>" onChange="getTrainingId(this.value)"; /></td>

<td><%=etrTravelreq.getEmp().getFirstName()+" "+etrTravelreq.getEmp().getMiddleName()+" "+etrTravelreq.getEmp().getLastName() %></a></td>
<td><%=etrTravelreq.getRefNo() %></a></td>
<td><%=HMSUtil.convertDateToStringWithoutTime(etrTravelreq.getJfdate()) %></a></td>
<td><%=HMSUtil.convertDateToStringWithoutTime(etrTravelreq.getJtdate()) %></td>
<td><%=etrTravelreq.getTrip().getCodeDesc() %></td>
<%
if (etrTravelreq.getNAFTicket().equals("y")) {
%> 
<td><input type="checkbox" name="ticketEditBooking" checked="checked" value="" disabled="disabled" class="radioCheck" /></td>
<%}else{ %>
<td><input type="checkbox" name="ticketEditBooking"  disabled="disabled" value="" class="radioCheck" /></td>
<%
	} 
if(etrTravelreq.getNAFHotel().equals("y")){
%>
<td><input type="checkbox" name="hotelEditBooking" checked="checked" value="" disabled="disabled" class="radioCheck" /></td>
<%}else{ %>
<td><input type="checkbox" name="hotelEditBooking" value="" disabled="disabled" class="radioCheck" /></td>
<%
	} 
if(etrTravelreq.getNAFLocalCab().equals("y")){
%>
<td><input type="checkbox" name="cabEditBooking" checked="checked" value="" disabled="disabled" class="radioCheck" /></td>
<%}else{ %>
<td><input type="checkbox" name="cabEditBooking"  value="" disabled="disabled" class="radioCheck" /></td>
<%} %>
<td><%=approver %></td>

<td><%=reqStatus+"-"+statusDate+"-"+statusTime%></td>
<%
if(bookStatus.equals("Booked")){
	if(etrFillBookDetailSet.size()>0){
		 for(EtrFillbookeddtls  etrFillbookeddtls:etrFillBookDetailSet){
			 if(etrFillbookeddtls.getCreatedAt() != null){
			 bookedStatusDate   =HMSUtil.convertDateToStringWithoutTime(etrFillbookeddtls.getCreatedAt());
			 }
//			 if(etrFillbookeddtls.getTicketBookTime()!= null){
	//		 bookedStatusTime = (String)etrFillbookeddtls.getTicketBookTime();
		//	 }
			}
		}
 }
%>
<td><%=bookStatus+"-"+bookedStatusDate+"-"+bookedStatusTime%><input type="hidden" name="bookStatus" id="bookStatusId<%=i %>" value="<%=etrTravelreq.getBookStatus() %>" /></td>
</tr>

 		<%
 		i++;
		 }
		}
	}
%>
</tbody>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">
<input type="hidden" id="countId" name="travelId" value="">
<script type="text/javascript">

function getTrainingId(val)
	{
		
	 	document.ticketUpdateList.travelId.value =val;
  	}

</script>
 <script>
	  var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);

	  </script>
<div class="clear"></div>
<input name="Submit" type="button" class="buttonBig" value="Enter Booking Details" onClick="submitForm('ticketUpdateList','etravel?method=filledBookedDetailsByAdmin','test');"/>

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
function disableCheckBoxes(cnt){
	var count = document.getElementById('countId').value;
	for(var i=0;i<count;i++){
		if(i != cnt){
			if(document.getElementById('rb'+cnt).checked){
				document.getElementById('rb'+i).disabled = true;
			}else{
				document.getElementById('rb'+i).disabled = false;
			}
		}
	}
}


function test(){
	var count = document.getElementById('countId').value;
	//alert("dfdfdf"+count);
	for(var i=0;i<count;i++){
		if(document.getElementById('rb'+i).checked){
		//alert(document.getElementById('bookStatusId'+i).value)
			val = document.getElementById('bookStatusId'+i).value;
			//alert(val)
			if(val == 'Booked'){
				alert("Ticket Already booked");
				return false;
			}else{
				return true;
			}
		}
	}
	}

</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

