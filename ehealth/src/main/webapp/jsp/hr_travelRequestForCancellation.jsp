<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				//List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				//Set<EtrTrvdetails> etrTrvdetailsSet= new HashSet();
				List<EtrApptbl> etrApproverList = new ArrayList<EtrApptbl>();
				List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
				List<MasCountry> countryList = new ArrayList<MasCountry>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				
				//if(map.get("etrTravelRequestList")!= null){
					//etrTravelRequestList = (List)map.get("etrTravelRequestList");
				//}
				if(map.get("etrApproverList")!= null){
					etrApproverList = (List)map.get("etrApproverList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("masCityList")!= null){
					masCityList = (List)map.get("masCityList");
				}
				if(map.get("countryList")!= null){
					countryList = (List)map.get("countryList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
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
				int employeeId = 0;
				String refNo = "";
				Date fromDate = new Date();
				Date toDate = new Date();
				int travelTypeId  = 0;
				String tripName = "";
				String empName = "";
				String rankName = "";
				String empCode = "";
				String deptName = "";
				String locationName = "";
				String organizationName = "";
				if(etrApproverList.size()>0){
					for(EtrApptbl etrApptbl:etrApproverList){
						if(etrApptbl.getTrv().getEmp().getId()!= null){
							employeeId = etrApptbl.getTrv().getEmp().getId();
							 refNo =etrApptbl.getTrv().getRefNo();
							 fromDate =etrApptbl.getTrv().getJfdate();
							 toDate = etrApptbl.getTrv().getJtdate();
							 if(etrApptbl.getTrv().getTrip().getId()!= null){
									travelTypeId = etrApptbl.getTrv().getTrip().getId();
							 		tripName = etrApptbl.getTrv().getTrip().getCodeDesc();
							 }
							 empName =etrApptbl.getTrv().getEmp().getEmployeeCode() +"-"+etrApptbl.getTrv().getEmp().getFirstName()+" "+etrApptbl.getTrv().getEmp().getMiddleName()+" "+etrApptbl.getTrv().getEmp().getLastName();
							 deptName = etrApptbl.getTrv().getEmp().getDepartment().getDepartmentName();
							 locationName = etrApptbl.getTrv().getEmp().getLocation().getLocationName();
							 organizationName = etrApptbl.getTrv().getEmp().getHospital().getHospitalName();
							 rankName = etrApptbl.getTrv().getEmp().getRank().getRankName();
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
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>



<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.EtrTrvdetails"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.EtrApptbl"%>
<form name="cancelApproveRequest" method="post" action="" >
<div class="titleBg"> <h2>Travel Cancellation Approval </h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>

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
<th>Advance</th>
<th>Ticket Status</th>

</tr>
<tbody id="tableData">
<%

	int count = 0;
	int i = 0;
	int travelRequestId = 0;
	String bookedStatusTime = "";
	String bookedStatusDate = "";
	String klass = "even";
	if(etrApproverList.size()>0){
		for (EtrApptbl etrApptbl :etrApproverList) {
			travelRequestId = etrApptbl.getId();
			//if(etrTravelreq.getHotelDesc()!= null && ! etrTravelreq.getHotelDesc().equals("")){
				//hotelDesc = etrTravelreq.getHotelDesc();
			//}
			//if(etrTravelreq.getLocalCabDesc()!= null && ! etrTravelreq.getLocalCabDesc().equals("")){
				//cabDesc = etrTravelreq.getLocalCabDesc();
			//}
			//if(etrTravelreq.getAdvAmt()!= null && ! etrTravelreq.getAdvAmt().equals("")){
				//advanceAmount = etrTravelreq.getAdvAmt();
			//}
			
			 //etrTrvdetailsSet = etrTravelreq.getEtrTrvdetails();
		
	//-----------------------------
			 	
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
		 		String url = "etravel?method=approveCancelBookedDetails&"+TRAVEL_REQUEST_ID +"="+etrApptbl.getTrv().getId();
		 	
		 	
		 		
%>




<tr class=<%= klass%> id="<%=count%>"  >
<td><input name="<%=TRAVEL_REQUEST_ID%><%=i%>"  class="radioCheck" id="rb<%=i%>" type="checkbox"  value="<%=travelRequestId%>" onClick="unCheck(this)" /></td>

<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')"><%=etrApptbl.getTrv().getEmp().getFirstName()+" "+etrApptbl.getTrv().getEmp().getMiddleName()+" "+etrApptbl.getTrv().getEmp().getLastName() %></a></td>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')"><%=etrApptbl.getTrv().getRefNo() %></a></td>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')"><%=HMSUtil.convertDateToStringWithoutTime(etrApptbl.getTrv().getJfdate()) %></a></td>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')"><%=HMSUtil.convertDateToStringWithoutTime(etrApptbl.getTrv().getJtdate()) %></a></td>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')"><%=etrApptbl.getTrv().getTrip().getCodeDesc() %></a></td>
<%
if (etrApptbl.getTrv().getNAFTicket().equals("y")) {
	%> 
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')" rel="balloon<%=count%>"><input
				type="checkbox" name="ticketEditBooking" checked="checked" value=""
				class="radioCheck" disabled="disabled"/></a></td>
<%}else{
	%>
	<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')" rel="balloon<%=count%>"><input
				type="checkbox" name="ticketEditBooking" value=""
				class="radioCheck" disabled="disabled"/></a></td>
<%
	}
if(etrApptbl.getTrv().getNAFHotel().equals("y")){
%>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')" rel="bal<%=count%>"><input
				type="checkbox" name="hotelEditBooking" checked="checked" value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%}else{ %>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')" rel="bal<%=count%>"><input
				type="checkbox" name="hotelEditBooking"  value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%
	}
if(etrApptbl.getTrv().getNAFLocalCab().equals("y")){
%>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')" rel="cab<%=count%>"><input
				type="checkbox" name="cabEditBooking" checked="checked" value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%}else{ %>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')" rel="cab<%=count%>"><input
				type="checkbox" name="cabEditBooking"  value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%
	} 

if(etrApptbl.getTrv().getAvdReq().equals("y")){
%>	
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')" ><input
				type="checkbox" name="needEditAdvance" checked="checked" value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%}else{ %>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'cancelApproveRequest')" ><input
				type="checkbox" name="needEditAdvance"  value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%} %>



<% if(etrApptbl.getTrv().getBookStatus() .equals("Booking Cancellation Approved")){
	
			 if(etrApptbl.getCancelApprDate() != null){
				 bookedStatusDate   = (String)HMSUtil.convertDateToStringWithoutTime(etrApptbl.getCancelApprDate());
			 }
			 if(etrApptbl.getCancelApprTime()!= null){
				 bookedStatusTime =(String)etrApptbl.getCancelApprTime();
			 }
	
	
	%>
<td><%=etrApptbl.getTrv().getBookStatus() +"-"+bookedStatusDate+"-"+bookedStatusTime %>	
<%	
}else{	
 %>
<td><%=etrApptbl.getTrv().getBookStatus()  %>
<%} %>


</tr>

 		<%
 		i++;
 		
		}
	}
%>
</tbody>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">

<script type="text/javascript">

function getTrainingId(val)
	{
		
	 	document.cancelApproveRequest.<%=TRAVEL_REQUEST_ID%>.value =val;
  	}

</script>
 <script>
	  var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);

	  </script>
<div class="clear"></div>



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

