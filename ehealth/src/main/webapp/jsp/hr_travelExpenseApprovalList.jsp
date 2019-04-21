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
				List<Object[]> etrExpDetailList = new ArrayList<Object[]>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
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
<%@page import="jkt.hrms.masters.business.EtrExpdetails"%>
<%@page import="jkt.hrms.masters.business.EtrExpsubmit"%>

<div class="titleBg"> <h2>Travel Expense Approval List</h2></div>

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
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','etravel?method=searchTravelExpenseApprovelList')" tabindex=1  />
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
<a href="etravel?method=showTravelExpenseApprovalJsp">Show All Records</a>

<%
}
%>


<form name="travelExpenseApproval" method="post" action="" >

<div id="pageNavPosition"></div>
<div class="clear"></div>
<table id="searchresulttable"  width="100%" cellspacing="0" cellpadding="0">
<tr>
<th>Select</th>
<th>Employee</th>
<th>Ref. No</th>
<th>From Date</th>
<th>To Date</th>
<th>Actual Amount</th>
<th>Standard Amount</th>
<th>Expense Status</th>
</tr>
<tbody id="tableData">
<%

	int count = 0;
	int i = 0;
	int travelRequestId = 0;
	BigDecimal	amount = new BigDecimal("0");
	String expenseStatusTime = "";
	String expenseStatusDate = "";
	String klass = "even";
	if(etrExpDetailList.size()>0){
		for (Object[] object : etrExpDetailList) {
			travelRequestId = (Integer)object[0];
			
			String exClaimStatus = "";
			if(object[8]!= null){
				exClaimStatus =(String)object[8];
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
		 		
		 		
		 	 	
		 		String url = "etravel?method=approveTravelExpensesClaim&"+TRAVEL_REQUEST_ID +"="+travelRequestId;
		 		
		 	//	if(exClaimStatus.equals("Submitted")){
		//			if(object[11]!= null){
						// expenseStatusDate = HMSUtil.convertDateToStringWithoutTime((Date)object[11]);
				//	}
			//		if(object[12]!= null){
				//		expenseStatusTime = (String)object[12];
			//		}
		//		 }else if(exClaimStatus.equals("Paid")){
		//			 if(object[13]!= null){
		//					expenseStatusDate = HMSUtil.convertDateToStringWithoutTime((Date)object[13]);
		//				}
			//			if(object[14]!= null){
			//				expenseStatusTime = (String)object[14];
			//			}
			//		}else if(exClaimStatus.equals("Approved")){
			//			if(object[9]!= null){
			//				expenseStatusDate = HMSUtil.convertDateToStringWithoutTime((Date)object[9]);
			//			}
			//			if(object[10]!= null){
			//	/			expenseStatusTime = (String)object[10];
			//			}
						
			
			//		}else if(exClaimStatus.equals("")){
			//			expenseStatusDate = "";
			//			expenseStatusTime = "";
			//		}
		 	
%>

<tr class=<%= klass%> id="<%=count%>" onclick="parent.location='<%=url %>'" >
<td><input name="<%=TRAVEL_REQUEST_ID%><%=i%>"  class="radioCheck" id="rb<%=i%>" type="checkbox"  value="<%=travelRequestId%>" onClick="unCheck(this)" onChange="getTrainingId(this.value)"; /></td>
<td><a href="javascript:Request(document.getElementById('<%=count %>'),'travelExpenseApproval')"><%=(String)object[5] +" "+(String)object[6]%></a></td>
<td><a href="javascript:Request(document.getElementById('<%=count %>'),'travelExpenseApproval')"><%=(String)object[1]%></td>
<td><a href="javascript:Request(document.getElementById('<%=count %>'),'travelExpenseApproval')"><%=HMSUtil.convertDateToStringWithoutTime((Date)object[2]) %></a></td>
<td><a href="javascript:Request(document.getElementById('<%=count %>'),'travelExpenseApproval')"><%=HMSUtil.convertDateToStringWithoutTime((Date)object[3]) %></td>
<%if(object[4]!= null){ %>
<td><a href="javascript:Request(document.getElementById('<%=count %>'),'travelExpenseApproval')"><%=(BigDecimal)object[4]%></a></td>
<%}else{ %>
<td><a href="javascript:Request(document.getElementById('<%=count %>'),'travelExpenseApproval')">--</a></td>
<%} %>
<%if(object[7] != null){ %>
<td><a href="javascript:Request(document.getElementById('<%=count %>'),'travelExpenseApproval')"><%=(BigDecimal)object[7]%></a></td>
<%}else{ %>
<td><a href="javascript:Request(document.getElementById('<%=count %>'),'travelExpenseApproval')">--</a></td>
<%} %>


<td><a href="javascript:Request(document.getElementById('<%=count %>'),'travelExpenseApproval')"><%=exClaimStatus+"-"+expenseStatusDate+" "+expenseStatusTime %></a>
<input type="hidden" name="exclaimstatus" id="exclaimstatusId<%=i %>" value="<%=exClaimStatus%>" /></td>


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
	
function test2(){
    var count = document.getElementById('countId').value;
	
	for(var i=0;i<count;i++){
			val = document.getElementById('exclaimstatusId'+i).value;
			alert(val);
			if(val == 'Approved'){
				alert("Expense Already Approved");
				return false;
				break;
			}else if(val == 'Paid'){
				alert("Expense Already Approved");
				return false;
				break;
			}else{
				return true;
			}
		}
	}
	







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

