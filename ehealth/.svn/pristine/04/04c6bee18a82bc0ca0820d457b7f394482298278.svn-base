<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>


  

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				Set<EtrTrvdetails> etrTrvdetailsSet= new HashSet();
				List<Object[]> employeeList = new ArrayList<Object[]>();
				List<Object[]> departmentList = new ArrayList<Object[]>();
				//Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				
				if(map.get("etrTravelRequestList")!= null){
					etrTravelRequestList = (List)map.get("etrTravelRequestList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
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
				
				
				int employeeId = 0;
				String tripName = "";
				String empName = "";
				String rankName = "";
				String empCode = "";
				String deptName = "";
				String locationName = "";
				String organizationName = "";
				if(etrTravelRequestList.size()>0){
					for(EtrTravelreq etrTravelreq :etrTravelRequestList){
						if(etrTravelreq.getEmp().getId()!= null){
							 employeeId = etrTravelreq.getEmp().getId();
							 empName =etrTravelreq.getEmp().getEmployeeCode() +"-"+etrTravelreq.getEmp().getFirstName()+" "+etrTravelreq.getEmp().getMiddleName()+" "+etrTravelreq.getEmp().getLastName();
							 deptName = etrTravelreq.getEmp().getDepartment().getDepartmentName();
							 locationName = etrTravelreq.getEmp().getLocation().getLocationName();
							 organizationName = etrTravelreq.getEmp().getHospital().getHospitalName();
							 rankName = etrTravelreq.getEmp().getRank().getRankName();
						}
					}
				}
				
	%>
<%@page import="jkt.hrms.masters.business.EtrApptbl"%>
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
	 function abcd()
	 {
	  alert("abcd");
	 }
</script>
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

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<script type="text/javascript" src="/hms/jsp/js/balloontip.js">

/***********************************************
* Rich HTML Balloon Tooltip- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>


<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.EtrTrvdetails"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="java.math.BigDecimal"%>

<div class="titleBg"> <h2>Travel Approval </h2></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Employee</label>
<select  name="searchEmployeeId" validate="Employee,string,no"  >
<option value="0">Select</option>
<%
	for(Object[] masEmployee:employeeList){
%>
<option value="<%=masEmployee[0] %>"><%=masEmployee[1]+"-"+masEmployee[2]+" "+masEmployee[3]+" "+masEmployee[4]%></option>
<%} %>
</select>
<label>Ref. No</label>
<select  name="searchRefNoId" validate="Ref No,string,no"  >
<option value="0">Select</option>
<%
	for(EtrTravelreq etrTravelreq:etrTravelRequestList){
%>
<option value="<%=etrTravelreq.getId() %>"><%=etrTravelreq.getRefNo()%></option>
<%} %>
</select>
<div class="clear"></div>
<label>From Date </label>
<input id="fromDateId" type="text"  name="<%=FROM_DATE %>" value="" class="date"  readonly="readonly" validate="LOI date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('fromDateId'),event)"/>

<label>To Date </label>
<input id="toDateId" type="text"  name="<%=TO_DATE %>" value="" class="date"  readonly="readonly" validate="LOI date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('toDateId'),event)"/>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','etravel?method=searchTravelApprovalRequest')" tabindex=1  />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<% 
if(map.get("search") != null)
{
%>
<a href="etravel?method=showTravelApprovalRequest">Show All Records</a>

<%
}
%>
<div class="division"></div>
<form name="showTravelApprovalRequest" method="post" action="" >
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>


<div class="clear"></div>

<div id="pageNavPosition"></div>

<table id="searchresulttable"  width="100%" cellspacing="0" cellpadding="0">
<tr>
<th><input type="checkbox" name="allIds" value="yes" onClick="checkAll()" class="radioCheck"  /></th>
<th>Employee</th>
<th>Ref. No</th>
<th>From Date</th>
<th>To Date</th>
<th>Trip Type</th>
<th>Ticket</th>
<th>Hotel</th>
<th>Cab</th>
<th>Advance</th>
<th>Travel Status</th>
</tr>
<tbody id="tableData">
<%

	int count = 0;
	int i = 0;
	int travelRequestId = 0;
	String hotelDesc = "";
	String cabDesc = "";
	String statusTime = "";
	String statusDate = "";
	BigDecimal advanceAmount = new BigDecimal("0");
	String klass = "even";
	Set<EtrApptbl> etrApptblSet= new HashSet();
	if(etrTravelRequestList.size()>0){
		for (EtrTravelreq etrTravelreq :etrTravelRequestList) {
			travelRequestId = etrTravelreq.getId();
			if(etrTravelreq.getHotelDesc()!= null && ! etrTravelreq.getHotelDesc().equals("")){
				hotelDesc = etrTravelreq.getHotelDesc();
			}
			if(etrTravelreq.getLocalCabDesc()!= null && ! etrTravelreq.getLocalCabDesc().equals("")){
				cabDesc = etrTravelreq.getLocalCabDesc();
			}
			if(etrTravelreq.getAdvAmt()!= null && ! etrTravelreq.getAdvAmt().equals("")){
				advanceAmount = etrTravelreq.getAdvAmt();
			}
			String reqStatus = "";
			if(etrTravelreq.getTrvStatus()!= null){
				reqStatus = etrTravelreq.getTrvStatus();
			}
			etrApptblSet = etrTravelreq.getEtrApptbls();
			
			Date approverdate = null;
			String approverTime = "";
			if(etrApptblSet.size()>0){
			 for(EtrApptbl  etrApptbl:etrApptblSet){
				 if(etrApptbl.getApprDate() != null){
				 approverdate   = etrApptbl.getApprDate();
				 }
				 if(etrApptbl.getApprTime()!= null){
				 approverTime = etrApptbl.getApprTime();
				 }
				}
			}
			
			
			
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
				  }else if(reqStatus.equals("sendback")){
					  
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
		 		String url = "etravel?method=viewTravelApprovalRequest&"+TRAVEL_REQUEST_ID +"="+etrTravelreq.getId();
		 	
		 		
		 		
%>




<tr class=<%= klass%> id="<%=count%>"  >
<td><input name="<%=TRAVEL_REQUEST_ID%><%=i%>"  class="radioCheck" id="rb<%=i%>" type="checkbox"  value="<%=travelRequestId%>" onClick="unCheck(this)" /></td>

<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')"><%=etrTravelreq.getEmp().getFirstName()+" "+etrTravelreq.getEmp().getMiddleName()+" "+etrTravelreq.getEmp().getLastName() %></a></td>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')"><%=etrTravelreq.getRefNo() %></a></td>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count%>'),'showTravelApprovalRequest')"><%=etrTravelreq.getJfdate() %></a></td> 
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')"><%=etrTravelreq.getJtdate()%></a></td>

<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')"><%=etrTravelreq.getTrip().getCodeDesc() %></a></td>
<%
if (etrTravelreq.getNAFTicket().equals("y")) {
	%> 
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')" rel="balloon<%=count%>"><input
				type="checkbox" name="ticketEditBooking" checked="checked" value=""
				class="radioCheck" disabled="disabled"/></a></td>
<%}else{
	%>
	<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')" rel="balloon<%=count%>"><input
				type="checkbox" name="ticketEditBooking" value=""
				class="radioCheck" disabled="disabled"/></a></td>
<%
	}
if(etrTravelreq.getNAFHotel().equals("y")){
%>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')" rel="bal<%=count%>"><input
				type="checkbox" name="hotelEditBooking" checked="checked" value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%}else{ %>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')" rel="bal<%=count%>"><input
				type="checkbox" name="hotelEditBooking"  value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%
	}
if(etrTravelreq.getNAFLocalCab().equals("y")){
%>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')" rel="cab<%=count%>"><input
				type="checkbox" name="cabEditBooking" checked="checked" value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%}else{ %>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')" rel="cab<%=count%>"><input
				type="checkbox" name="cabEditBooking"  value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%
	} 

if(etrTravelreq.getAvdReq().equals("y")){
%>	
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')" ><input
				type="checkbox" name="needEditAdvance" checked="checked" value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%}else{ %>
<td onclick="parent.location='<%=url %>'"><a href="javascript:Request(document.getElementById('<%=count %>'),'showTravelApprovalRequest')" ><input
				type="checkbox" name="needEditAdvance"  value=""
				class="radioCheck" disabled="disabled" /></a></td>
<%} %>
<td onclick="parent.location='<%=url %>'"><%=reqStatus+"-"+statusDate+"-"+statusTime %>

<input type="hidden" name="travelStatus" id="travelStatusId<%=i %>" value="<%=etrTravelreq.getTrvStatus() %>" /></td>

</tr>

 		<%
 		i++;
 		
		}
	}
%>
</tbody>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">
<div class="clear"></div>
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
<script type="text/javascript">

function getTrainingId(val)
	{
		
	 	document.showTravelApprovalRequest.<%=TRAVEL_REQUEST_ID%>.value =val;
  	}

</script>
 <script>
	  var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);

	  </script>
<div class="clear"></div>


<input type="button" name="mail" value="Submit" class="buttonBig"  onclick="sendMail();" />

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
// function disableCheckBoxes(cnt){
	//var count = document.getElementById('countId').value;
	//for(var i=0;i<count;i++){
		//if(i != cnt){
			//if(document.getElementById('rb'+cnt).checked){
				//document.getElementById('rb'+i).disabled = true;
			//}else{
				//document.getElementById('rb'+i).disabled = false;
			//}
		//}
	//}
//}
	function checkAll()
		{
		var no = <%=count%>;
		
		for(i=0;i<no;i++)
		{
		var obj = "document.showTravelApprovalRequest." + "<%=TRAVEL_REQUEST_ID%>" +i;
		
		obj=eval(obj);
		if(obj.disabled==true)
		{
		}
		else
		{
		if(document.showTravelApprovalRequest.allIds.checked==true)
		{
		obj.checked=true;
		}
		else
		{
		obj.checked=false;
		}
		}
		}
	}



function unCheck(obj)
{
if(obj.checked==false)
{
document.showTravelApprovalRequest.allIds.checked=false;
}
}

function chkCheckBoxes()
	{
	
		inps = document.getElementsByTagName('input');
		flag=false;
		for(i=0;i<inps.length;i++)
		{
 			if(inps[i].type == 'checkbox')
  			{
				if(inps[i].checked)
				{
       	            flag=true;
	 			     break;
				}
			}
		}
		if(!flag)
		{
			alert("Please select one of the Employee.");
			return false;
		}
		return true;
	}
	function sendMail()
		{
		val = chkCheckBoxes();
	if(val==true)
			submitForm('showTravelApprovalRequest','etravel?method=sendMailToApprover&listSize=<%=count%>','test1');
		}
	
 	function test1(){
	var count = document.getElementById('countId').value;
	for(var i=0;i<count;i++){
		if(document.getElementById('rb'+i).checked){
		//alert(document.getElementById('travelStatusId'+i).value)
			val = document.getElementById('travelStatusId'+i).value;
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

