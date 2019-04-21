
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<Object[]> travelRequestList = new ArrayList<Object[]>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MasLocation> locationList = new ArrayList<MasLocation>();
				List<MasRank> rankList = new ArrayList<MasRank>();
				List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				
				Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				
				if(map.get("etrTravelRequestList")!= null){
					etrTravelRequestList = (List)map.get("etrTravelRequestList");
				}
				if(map.get("travelRequestList")!= null){
					travelRequestList = (List)map.get("travelRequestList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("locationList")!= null){
					locationList = (List)map.get("locationList");
				}
				if(map.get("rankList")!= null){
					rankList = (List)map.get("rankList");
				}
				if(map.get("message") != null){
					String message = (String)map.get("message");
					out.println(message);
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
				String designation = "";
				String department = "";
				String orgnization = "";
				if(employeeList.size()>0){
					for(MasEmployee masEmployee :employeeList){
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
<%@page import="jkt.hrms.masters.business.EtrApptbl"%>
<%@page import="jkt.hrms.masters.business.EtrFillbookeddtls"%>
<%@page import="jkt.hrms.masters.business.EtrExpsubmit"%>
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

<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.MasLocation"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<div class="titleBg"> <h2>View Travel Request </h2></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="Block">
<label>Employee</label>
<label class="large"><%=empName %></label>
<label >Designation </label>
<label class="large"><%=designation %></label>
<label>Department </label>
<label class="large"><%=department %></label>

<%

%>
<label>Location </label>

<label class="large"><%=locationName%> </label>
<div class="clear"></div>
<label >Organization </label>
<label class="large"><%=orgnization %>  </label>

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
<label>Status</label>
<select  name="searchStatusId" validate="Project Status,string,no"  >
<option value="">Select</option>
<option value="NewRequest">New Request</option>
<option value="Approved">Approve</option>
</select>
<div class="clear"></div>
<label>From Date </label>
<input id="fromDateId" type="text"  name="<%=FROM_DATE %>" value="" class="date"  readonly="readonly" validate="LOI date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('fromDateId'),event)"/>

<label>To Date </label>
<input id="toDateId" type="text"  name="<%=TO_DATE %>" value="" class="date"  readonly="readonly" validate="LOI date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('toDateId'),event)"/>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','etravel?method=searchTravelRequest')" tabindex=1  />
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
<a href="etravel?method=showTravelRequestJsp">Show All Records</a>

<%
}
%>
<form name="travelRequest" method="post" action="" >
<div class="division"></div>
<div id="pageNavPosition"></div>

<table id="searchresulttable">
<tr>
<th>Select</th>
<th>Travel Ref No.</th>
<th>From Date</th>
<th>To Date</th>
<th>Request Status</th>
<th>Advance Status</th>
<th>Ticket Status</th>
<th>Exp Claim Status</th>
</tr>
<tbody id="tableData">
<%

	int count = 0;
	int i = 0;
	int travelRequestId = 0;
	String klass = "even";
	String statusTime = "";
	String statusDate = "";
	String advanceStatusTime = "";
	String advanceStatusDate = "";
	String bookStatus = "";
	String bookedStatusTime = "";
	String bookedStatusDate = "";
	String expenseStatusTime = "";
	String expenseStatusDate = "";
	Set<EtrApptbl> etrApptblSet= new HashSet();
	Set<EtrExpsubmit> etrExpSubmitSet= new HashSet();
	Set<EtrFillbookeddtls> etrFillBookDetailSet= new HashSet();
	if(etrTravelRequestList.size()>0){
		for (EtrTravelreq etrTravelreq1: etrTravelRequestList) {
			 travelRequestId = etrTravelreq1.getId();
			Date fromdate = etrTravelreq1.getJfdate();
			Date toDate = etrTravelreq1.getJtdate();
			
			
			String reqStatus = "";
			if(etrTravelreq1.getTrvStatus()!= null){
				reqStatus = etrTravelreq1.getTrvStatus();
			}
			String advanceStatus = "";
			if(etrTravelreq1.getAdvStatus() != null){
			 advanceStatus = etrTravelreq1.getAdvStatus();
			}
			
			if(etrTravelreq1.getBookStatus() != null){
				bookStatus = etrTravelreq1.getBookStatus();
			}
			String exClaimStatus = "";
			if(etrTravelreq1.getExpClaimSts()!= null){
				exClaimStatus = etrTravelreq1.getExpClaimSts();
			}
			etrApptblSet = etrTravelreq1.getEtrApptbls();
			etrFillBookDetailSet = etrTravelreq1.getEtrFillbookeddtls(); 
			//etrExpSubmitSet = etrTravelreq1.getEtrExpsubmits();
			
			if(reqStatus.equals("NewRequest")){
				if(etrTravelreq1.getCreatedAt()!= null){
				statusDate = (String)HMSUtil.convertDateToStringWithoutTime(etrTravelreq1.getCreatedAt());
				}
			//	if(etrTravelreq1.getLastChgBy()!= null){
				//	statusTime = (String)(etrTravelreq1.getLastChgBy());
					//}
				
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
			
	//-------------------------------------------		
			if(exClaimStatus.equals("Submitted")){
				if(etrTravelreq1.getSubmitExpenseDate()!= null){
					expenseStatusDate = HMSUtil.convertDateToStringWithoutTime(etrTravelreq1.getSubmitExpenseDate());
				}
				if(etrTravelreq1.getSubmitExpenseTime()!= null){
					expenseStatusTime = etrTravelreq1.getSubmitExpenseTime();
				}
			 }else if(exClaimStatus.equals("Paid")){
				  if(etrExpSubmitSet.size()>0){
					 for(EtrExpsubmit etrExpsubmit:etrExpSubmitSet){
						 if(etrExpsubmit.getExpenseSettlementDate() != null){
							 expenseStatusDate   = (String)HMSUtil.convertDateToStringWithoutTime(etrExpsubmit.getExpenseSettlementDate());
						 }
						 if(etrExpsubmit.getExpenseSettlementTime()!= null){
							 expenseStatusTime =(String)etrExpsubmit.getExpenseSettlementTime();
						 }
						}
					}
				}else if(exClaimStatus.equals("Approved")){
					if(etrExpSubmitSet.size()>0){
						 for(EtrExpsubmit etrExpsubmit:etrExpSubmitSet){
							 if(etrExpsubmit.getApproveExpenseDate() != null){
								 expenseStatusDate   = (String)HMSUtil.convertDateToStringWithoutTime(etrExpsubmit.getApproveExpenseDate());
							 }
							 if(etrExpsubmit.getApproveExpenseTime()!= null){
								 expenseStatusTime =(String)etrExpsubmit.getApproveExpenseTime();
							 }
							}
					}
					
				}else if(exClaimStatus.equals("")){
					expenseStatusDate = "";
					expenseStatusTime = "";
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
<input type="hidden" name="<%=TRAVEL_REQUEST_ID %>" id="travelRequestId" value="<%=travelRequestId %>" />
<tr class=<%= klass%> id="<%=count%>" >
<td><input name="rb"  class="radioCheck" id="rb<%=i%>" type="radio" value='<%=travelRequestId%>' onChange="getTrainingId(this.value)";  /></td>
<td><%=etrTravelreq1.getRefNo()%></td>
<td><%=HMSUtil.convertDateToStringWithoutTime(fromdate) %></td>
<td><%=HMSUtil.convertDateToStringWithoutTime(toDate) %></td>
<td><%=reqStatus +"-"+statusDate+"-"+statusTime%></td>

<%if(advanceStatus.equals("Paid")){
	if(etrTravelreq1.getAdvancePaidDate()!= null){
		advanceStatusDate = (String)HMSUtil.convertDateToStringWithoutTime(etrTravelreq1.getAdvancePaidDate());
	}
	if(etrTravelreq1.getAdvancePaidTime()!= null){
		advanceStatusTime = (String)(etrTravelreq1.getAdvancePaidTime());
	}
%>	
<td><%=advanceStatus+"-"+advanceStatusDate+" "+advanceStatusTime %></td>
<%}else{ %>
<td><%=advanceStatus%></td>
<%} %>

<%
if(bookStatus.equals("Booked")){
	if(etrFillBookDetailSet.size()>0){
		 for(EtrFillbookeddtls  etrFillbookeddtls:etrFillBookDetailSet){
			 if(etrFillbookeddtls.getCreatedAt() != null){
			 bookedStatusDate   =HMSUtil.convertDateToStringWithoutTime(etrFillbookeddtls.getCreatedAt());
			 }
			 if(etrFillbookeddtls.getTktDesc()!= null){
			 bookedStatusTime = (String)etrFillbookeddtls.getTktDesc();
			 }
			}
		}
%>
<td><%=bookStatus+"-"+bookedStatusDate+"-"+bookedStatusTime %>
<%}else if(bookStatus.equals("Booking Cancellation Approved")){
	if(etrApptblSet.size()>0){
		 for(EtrApptbl etrApptbl:etrApptblSet){
			 if(etrApptbl.getCancelApprDate() != null){
				 bookedStatusDate   = (String)HMSUtil.convertDateToStringWithoutTime(etrApptbl.getCancelApprDate());
			 }
			 if(etrApptbl.getCancelApprTime()!= null){
				 bookedStatusTime =(String)etrApptbl.getCancelApprTime();
			 }
			}
		}
	
	
	%>
<td><%=bookStatus+"-"+bookedStatusDate+"-"+bookedStatusTime %>	
<%	
}else{	
 %>
<td><%=bookStatus %>
<%} %>

<input type="hidden" name="bookStatus" id="bookStatusId<%=i %>" value="<%=bookStatus %>" /></td>
<td><%=exClaimStatus+"-"+expenseStatusDate+"-"+expenseStatusTime %><input type="hidden" name="exclaimStatus" id="exclaimstatusId<%=i %>" value="<%=exClaimStatus %>" /></td>
<input type="hidden" name="reqStatus" id="reqStatusId<%=i %>" value="<%=reqStatus %>" /></td>
</tr>


 		<%
 		i++;
 			
 		


		}
	}
%>
</tbody>
</table>
<input type="hidden" id="countId" value="<%=i %>">
<script type="text/javascript">
for (i=0;i<document.travelRequest.rb.length;i++)
	{
	 if (document.travelRequest.rb[i].checked)
      {
             rbgroup_value = document.travelRequest.rb[i].value;
             document.travelRequest.<%=TRAVEL_REQUEST_ID%>.value =rbgroup_value;
      }
	}




function getTrainingId(val)
	{
	 	document.travelRequest.<%=TRAVEL_REQUEST_ID%>.value =val;
  	}

</script>
 <script>
	  var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
		
		
	function test(){
	var count = document.getElementById('countId').value;
	for(var i=0;i<count;i++){
		if(document.getElementById('rb'+i).checked){
			val = document.getElementById('bookStatusId'+i).value;
			if(val != 'Booked'){
				alert("Plz Booked Tickets");
				return false;
			}else{
				return true;
			}
		}
	}
	}
	
	
	
	
	function test1(){
	var count = document.getElementById('countId').value;
	for(var i=0;i<count;i++){
		if(document.getElementById('rb'+i).checked){
			val = document.getElementById('exclaimstatusId'+i).value;
			if(val == 'Submitted'){
				return true;
				}else if(val == 'Paid'){	
					return true;
				}else if(val == 'Approved'){	
					return true;
				}else if(val == 'sendBack'){	
					return true;
				}else{
					alert("Please Submit Expense")
					return false;
					
			}
		}
	}
	}
	
	function test11(){
	var count = document.getElementById('countId').value;
	for(var i=0;i<count;i++){
		if(document.getElementById('rb'+i).checked){
			val = document.getElementById('exclaimstatusId'+i).value;
			 if(val == 'Paid'){	
					alert("Expenses can't Update");
					return false;
				}else if(val == 'Approved'){	
					alert("Expenses can't Update");
					return false;
				}else{
					return true;
					
			}
		}
	}
	}
	
	function test2(){
	var count = document.getElementById('countId').value;
	for(var i=0;i<count;i++){
		if(document.getElementById('rb'+i).checked){
			val = document.getElementById('exclaimstatusId'+i).value;
			if(val == 'Submitted'){
				alert("Expense Already Submitted");
				return false;
			}else if(val == 'Paid'){	
				alert("Expense Already Submitted");
				return false;
			}else if(val == 'Approved'){
				alert("Expense Already Submitted");
				return false;
			}else if(val == 'sendBack'){
				alert("Expense Already Submitted");
				return false;
			}else{
				return true;
			}
		}
	}
	}

	  </script>
<div class="clear"></div>

<input name="New Request" type="button"  class="button" value="New Request" onClick="submitForm('travelRequest','etravel?method=addNewTravelRequest');" />
<input name="ViewRequest" type="button"  class="button" value="View" onClick="submitForm('travelRequest','etravel?method=viewTravelRequest','validateRadio1');" />
<input name="ViewRequest" type="button"  class="button" value="Edit" onClick="submitForm('travelRequest','etravel?method=editTravelRequest','validateRadio1');" />
<input type="button" class="button" value ="View Booking"   accesskey="r" onClick="submitForm('travelRequest','etravel?method=viewBookedDetails&<%=TRAVEL_REQUEST_ID %>=travelRequestId','validateRadio1','test');"/>

<input type="button"  name ="SubmitExpenses" value ="Submit Expenses" class="buttonBig"   accesskey="r" onClick="submitForm('travelRequest','etravel?method=submitTravelExpenses','validateRadio1','test2','test33');"/>

<input type="button"  name ="ViewExpenses" value ="View Expenses" class="buttonBig"  accesskey="r" onClick="submitForm('travelRequest','etravel?method=viewTravelExpenses','validateRadio1','test1');" />

<input type="button" class="buttonBig"  value ="Update Expenses"   accesskey="r" onClick="submitForm('travelRequest','etravel?method=showUpdateExpensesJsp','validateRadio1','test1','test11');"/>
<input type="button"  name ="ViewExpenses" value ="Download" class="button"  accesskey="r"  onClick="if(validateRadio1()){javascript:openPopupWindow()};" />


<!--  <input type="button"  name ="ViewExpenses" value ="Download" class="button"  accesskey="r" onClick="submitForm('travelRequest','etravel?method=viewBookingDetailsAttachment','validateRadio1','test');"  onClick="if(validateRadio1()){javascript:openPopupWindow();,'test'}" />-->

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

<script type="text/javascript">
function openPopupWindow()
			{ 
			var id = 0; 
				 for(var i = 0; i < document.getElementsByName('rb').length; i++){
					  if(document.getElementsByName('rb')[i].checked == true)
		              {
						id = document.getElementsByName('rb')[i].value;
					  }		
		  		}
		  		var url="/hms/hrms/etravel?method=viewBookingDetailsAttachment&rb="+id+"";
		 		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		 	
			}
</script>
		
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
			
<script type="text/javascript">
function validateRadio1(){
			
			 for(var i = 0; i < document.getElementsByName('rb').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('rb')[i].checked == true)
              {
				
				return true;
			  }		
  		}
  		alert("Please select the Travel Request")
		return false;
		
	}
function test33(){
				
  	var count = document.getElementById('countId').value;
	for(var i=0;i<count;i++){
		if(document.getElementById('rb'+i).checked){
			val = document.getElementById('reqStatusId'+i).value;
			 if(val != 'Approved'){	
					alert("This Request is not Approved for submitting the Expenses");
					return false;
				}	
				else{
					return true;
					
				}
		}
	}
		
	
}


</script>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

