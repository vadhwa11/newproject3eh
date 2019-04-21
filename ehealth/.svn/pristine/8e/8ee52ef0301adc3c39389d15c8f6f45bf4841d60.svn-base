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
			List<EtrTravelreq> etrTravelReqList = new ArrayList<EtrTravelreq>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				
				Set<EtrApptbl> etrApptblSet = new HashSet<EtrApptbl>();
				Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("users")!= null){
					users = (Users)map.get("users");
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
<form name="travelAdvance" method="post" action="" >
<div class="titleBg"> <h2>Pay Advance</h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>




<div id="pageNavPosition"></div>

<table id="searchresulttable"  width="100%" cellspacing="0" cellpadding="0">
<tr>
<th><input type="checkbox" name="allIds" value="yes" onClick="checkAll()" class="radioCheck"  /></th>
<th>Employee</th>
<th>Ref. No</th>
<th>Expected-On</th>
<th>Advance-Requested</th>
<th>Advance-Paid</th>
<th>Advance Status</th>
<th>Travel Status</th>

</tr>
<tbody id="tableData">
<%

	int count = 0;
	int i = 0;
	int travelRequestId = 0;
	String hotelDesc = "";
	String statusTime = "";
	String statusDate = "";
	String approver = "";
	String cabDesc = "";
	String klass = "even";
	String empName = "";
	if(etrTravelReqList.size()>0){
		for (EtrTravelreq etrTravelreq :etrTravelReqList) {
			travelRequestId = etrTravelreq.getId();
			if(etrTravelreq.getHotelDesc()!= null && ! etrTravelreq.getHotelDesc().equals("")){
				hotelDesc = etrTravelreq.getHotelDesc();
			}
			if(etrTravelreq.getLocalCabDesc()!= null && ! etrTravelreq.getLocalCabDesc().equals("")){
				cabDesc = etrTravelreq.getLocalCabDesc();
			}
			etrApptblSet = etrTravelreq.getEtrApptbls(); 
			if(etrApptblSet.size()>0){
				for(EtrApptbl etrApptbl :etrApptblSet){
					approver = etrApptbl.getAppr().getFirstName()+" "+etrApptbl.getAppr().getLastName();
					}
			   }
			
			String reqStatus = "";
			if(etrTravelreq.getTrvStatus()!= null){
				reqStatus = etrTravelreq.getTrvStatus();
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
		 		String url = "etravel?method=viewTravelRequestForPayAdvance&rb="+etrTravelreq.getId();	
		 		
		 	
%>

<tr class=<%= klass%> id="<%=count%>" >
<td><input name="<%=TRAVEL_REQUEST_ID%><%=i%>"  class="radioCheck" id="rb<%=i%>" type="checkbox"  value="<%=travelRequestId%>" onClick="unCheck(this)"  /></td>
<% //String empName1 = "";
	if(employeeList.size()>0){
		for(MasEmployee masEmployee :employeeList){
	
		if(etrTravelreq.getEmp()!= null){
			if(etrTravelreq.getEmp().getId().equals(masEmployee.getId())){
				//empName1 = masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName();
				
			
 %>
<td onclick="parent.location='<%=url %>'"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></a></td>
<%}
			
}}}else{ %>
<td>--</td>
<%} %>
<td onclick="parent.location='<%=url %>'"><%=etrTravelreq.getRefNo() %></a></td>
<%if(etrTravelreq.getAdvExpDate() != null){ %>
<td onclick="parent.location='<%=url %>'"><%=HMSUtil.convertDateToStringWithoutTime(etrTravelreq.getAdvExpDate()) %></td>
<%}else{ %>
<td onclick="parent.location='<%=url %>'">--</td>
<%} %>
<%if(etrTravelreq.getAdvAmt()!= null){ %>
<td onclick="parent.location='<%=url %>'"><%=etrTravelreq.getAdvAmt() %></a></td>
<%}else{ %>
<td onclick="parent.location='<%=url %>'">--</a></td>
<%} %>
<%if(etrTravelreq.getAdvancePaidAmt()!=null){ %>
<td><input class="small" type="text"  name="<%=ADVANCE_PAID%><%=i%>" id= "advAmount<%=i %>" value="<%=etrTravelreq.getAdvancePaidAmt()%>"  validate="Remarks,string,no"   maxlength="8" /></td>
<%}else{ %>
<td><input class="small" type="text"  name="<%=ADVANCE_PAID%><%=i%>" id= "advAmount<%=i %>" value=""  validate="Remarks,string,no"   maxlength="8" /></td>
<%} %>
<%
String advanceStatusTime = "";
String advanceStatusDate = "";
if(etrTravelreq.getAdvStatus()!= null){ 
if(etrTravelreq.getAdvStatus().equals("Paid")){
	if(etrTravelreq.getAdvancePaidDate()!= null){
		advanceStatusDate = (String)HMSUtil.convertDateToStringWithoutTime(etrTravelreq.getAdvancePaidDate());
	}
	if(etrTravelreq.getAdvancePaidTime()!= null){
		advanceStatusTime = (String)(etrTravelreq.getAdvancePaidTime());
	}
%>	
<td><%=etrTravelreq.getAdvStatus()+"-"+advanceStatusDate+" "+advanceStatusTime %><input type="hidden" name="advanceStatus" id="advanceStatusId<%=i %>" value="<%=etrTravelreq.getAdvStatus() %>" /></td>
<%}else{ %>
<td><%=etrTravelreq.getAdvStatus()%><input type="hidden" name="advanceStatus" id="advanceStatusId<%=i %>" value="<%=etrTravelreq.getAdvStatus() %>" /></td>
<%}}else{ %>

<td>--<input type="hidden" name="advanceStatus" id="advanceStatusId<%=i %>" value="" /></td>
<%} %>


<%if(reqStatus != null){ %>
<td><%=reqStatus+"-"+statusDate+"-"+statusTime%></td>
<%}else{ %>
<td>--</td>
<% }%>

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
<input id="disDateId" type="text"  name="<%=DISBURSEMENT_DATE %>" value="" class="date"  readonly="readonly" validate="From date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('disDateId'),event)"/>
 
<div class="clear"></div>
</div>
<script type="text/javascript">

function getTrainingId(val)
	{
		
	 	document.travelAdvance.<%=TRAVEL_REQUEST_ID%>.value =val;
  	}

</script>
 <script>
	  var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);

	  </script>
<script type="text/javascript">

	function checkAll()
		{
		var no = <%=count%>;
		
		for(i=0;i<no;i++)
		{
		var obj = "document.travelAdvance." + "<%=TRAVEL_REQUEST_ID%>" +i;
		
		obj=eval(obj);
		if(obj.disabled==true)
		{
		}
		else
		{
		if(document.travelAdvance.allIds.checked==true)
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
document.travelAdvance.allIds.checked=false;
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
		alert(flag);
			alert("Please select one of the Employee.");
			return false;
		}
		return true;
	}
	function paidAdvance()
		{
		val = chkCheckBoxes();
	if(val == true)
			submitForm('travelAdvance','etravel?method=paidTravelAdvanceByAccounts','test1');
		}
	
 	
/*function test(){
var msg = "";
	var count = document.getElementById('countId').value;
	for(var i=0;i<count;i++){
		if(document.getElementById('rb'+i).checked){
			if(document.getElementById('advanceStatusId'+i) != null){
				val = document.getElementById('advanceStatusId'+i).value;
				alert("kkkk--"+val)
				if(val == 'Paid'){
					msg = "Already Approved Travel";
					//alert("Already Approved Travel");
					//return false;
					break;
				}
			}
		}
	}
	if(msg != ""){
		alert(msg);
		return false;
	}
	return true;
	}*/


	function test1(){
	var count = document.getElementById('countId').value;
	for(var i=0;i<count;i++){
		if(document.getElementById('rb'+i).checked){
		//alert(document.getElementById('travelStatusId'+i).value)
			val = document.getElementById('advanceStatusId'+i).value;
			//alert(val)
			if(val == 'Paid'){
				alert("Already Paid Travel Advance");
				return false;
			}
			var amount = document.getElementById('advAmount'+i).value;
			if(amount <= 0)
					{
					alert("Amount Should't be less Then Zero");
				return false;
				}	
			
			else{
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
	var status = document.getElementById('modeOfPaymentId').value;
	var disbursementdate = document.getElementById('disDateId').value;
	//alert(status);
	if(status == "0"){
		errMsg += "Status Code can not be blank.\n";
	}
	if(disbursementdate == ""){
		errMsg += "Disbursement Date can not be blank.\n";
	}
	if(errMsg != ""){
		alert(errMsg);
		return false;
	}else
		return true;
}





</script>	  
<div class="clear"></div>
<input name="Submit" type="button" class="button" value="Submit" onClick="paidAdvance();"/>
<input name="Back" type="button" class="button" value="Back" onClick="submitForm('travelAdvance','etravel?method=showTravelRequestJsp');" />

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

