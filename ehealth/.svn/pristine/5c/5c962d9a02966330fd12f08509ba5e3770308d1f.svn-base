<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				Set<EtrApptbl> etrApptblSet = new HashSet<EtrApptbl>();
				Set<EtrFillbookeddtls> etrFillBookDetailSet= new HashSet();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("etrTravelRequestList")!= null){
					etrTravelRequestList = (List)map.get("etrTravelRequestList");
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
				if(employeeList.size()>0){
					for(MasEmployee masEmployee:employeeList){
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
					}
				}
	%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
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

<div class="titleBg"> <h2>Modify Ticket Booking </h2></div>
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


<form name="updateTicketBookingDetails" method="post" action="" >
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
int i = 1;
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
	  for(EtrTravelreq etrTravelreq:etrTravelRequestList){	
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
			
			//-----------------------------
			if(reqStatus.equals("NewRequest")){
				if(etrTravelreq.getCreatedAt()!= null){
				statusDate = (String)HMSUtil.convertDateToStringWithoutTime(etrTravelreq.getCreatedAt());
				}
			//	if(etrTravelreq.getLastChgBy()!= null){
			//		statusTime = (String)(etrTravelreq.getLastChgBy());
			//		}
				
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
			
		  //----------------------
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
<td><input name="<%=TRAVEL_REQUEST_ID%>"  class="radioCheck" id="rb<%=i%>" type="radio"  value="<%=travelRequestId%>" onChange="getTrainingId(this.value)";   /></td>

<td><%=etrTravelreq.getEmp().getFirstName()+" "+etrTravelreq.getEmp().getMiddleName()+" "+etrTravelreq.getEmp().getLastName() %></a></td>
<td><%=etrTravelreq.getRefNo() %></a></td>
<td><%=HMSUtil.convertDateToStringWithoutTime(etrTravelreq.getJfdate()) %></a>

<input type="hidden" name="fromDate" id="fromDateId<%=i %>" value="<%=HMSUtil.convertDateToStringWithoutTime(etrTravelreq.getJfdate())%>" /></td>
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
			// if(etrFillbookeddtls.getTicketBookTime()!= null){
			// bookedStatusTime = (String)etrFillbookeddtls.getTicketBookTime();
			// }
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


 <script>
	  var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
		
		
function test1(){
	var count = document.getElementById('countId').value;
	for(var i=1;i<count;i++){
		if(document.getElementById('rb'+i).checked){
			var fDate = document.getElementById('fromDateId'+i).value;
			var fromDate = new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2));
			var cDate = new Date();
			var month = cDate.getMonth() + 1
			var day = cDate.getDate()
			var year = cDate.getFullYear()
			var seperator = "/"
			var currentDate  = new Date(month + seperator + day + seperator + year);
			if(fromDate != "" && currentDate != ""){
			if(fromDate < currentDate ){
				alert("Can't Update From Date is less than equal to Current Date ");
				return false;
			}
			}
		}		
	}
	return true;
	}
	
	function validateRadio(){
			
			 for(var i = 0; i < document.getElementsByName('<%=TRAVEL_REQUEST_ID%>').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('<%=TRAVEL_REQUEST_ID%>')[i].checked == true)
              {
				
				return true;
			  }		
  		}
  		alert("Please select the Travel Request")
		return false;
		
	}
function getTrainingId(val)
	{
	 	document.updateTicketBookingDetails.<%=TRAVEL_REQUEST_ID%>.value =val;
  	}

</script>

	  </script>
<div class="clear"></div>
<input name="Submit" type="button" class="buttonBig" value="Modify Ticket Booking" onClick="submitForm('updateTicketBookingDetails','etravel?method=editBookingDetail','validateRadio','test1');"/>

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


