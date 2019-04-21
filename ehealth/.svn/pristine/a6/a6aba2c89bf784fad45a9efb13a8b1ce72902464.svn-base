

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hrms.recruitment.masters.business.*"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<ResourceRequisition> resourceRequisitionList = new ArrayList<ResourceRequisition>();
				List<RequestStatusMaster> requestStatusMasterList = new ArrayList<RequestStatusMaster>();
				List<ResourceRequisition> requListForView = new ArrayList<ResourceRequisition>();
				Users users=null;
				String message=null;
				int resourceRequisitionId = 0;
				int hospitalId = 0;
				int employeeId = 0;
				
	
				String userFirstName="";
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
					session.setAttribute("map", map);
				}
				if(map.get("resourceRequisitionList")!= null){
					resourceRequisitionList = (List)map.get("resourceRequisitionList");
					
				}
				if(map.get("requListForView")!= null){
					requListForView = (List)map.get("requListForView");
					
				}
				if(map.get("requestStatusMasterList")!= null){
					requestStatusMasterList = (List)map.get("requestStatusMasterList");
					
				}
				MasRank intermediateApproverDesignation = null;
				if(map.get("intermediateApproverDesignation")!= null){
					intermediateApproverDesignation = (MasRank)map.get("intermediateApproverDesignation");
					
				}

				MasRank finalApproverDesignation = null;
				if(map.get("finalApproverDesignation")!= null){
					finalApproverDesignation = (MasRank)map.get("finalApproverDesignation");
					
				}
				
				if(map.get("message") != null){
					   message = (String)map.get("message");
					   //out.println(message);
				}
				
				if(map.get("users")!= null){
					users = (Users)map.get("users");
					userFirstName = users.getEmployee().getFirstName();
				}


				
				if(session.getAttribute("users") != null){
					users = (Users)session.getAttribute("users");
					MasEmployee masEmployee = users.getEmployee();
					//
					employeeId = masEmployee.getId();
				
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");	 

%>
<%@page import="java.math.BigDecimal"%>
<script>
<%	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
	date1 = '<%=date+"/"+month+"/"+year%>'
	
function check(){
	var SDate = document.resourceSearch.<%= FROM_DATE%>.value;
	var EDate = document.resourceSearch.<%= TO_DATE %>.value;


	var	endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

	if(startDate > endDate)
	{
		alert("Please ensure that the To Date is greater than or equal to the From Date.");
		// document.calldate.next_day.focus();
		return false;
	}
}
</script>
<script type="text/javascript" src="/hms/jsp/js/balloontip.js">

/***********************************************
* Rich HTML Balloon Tooltip- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>
<div class="titleBg">
<h2>Requisition Approval</h2>
</div>
<div class="clear"></div>
<form name="requisitionApproval" method="post">
<div class="Block">
<%
	if(message!= null){
	%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>

<label class="auto">From Date </label> <input type="text"
	name="<%= FROM_DATE_FOR_VALIDATION%>" value=""
	validate="From Date,date,yes" class="date" MAXLENGTH="15" / tabindex=1
	readonly /> <img src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onclick="setdate('',document.requisitionApproval.<%=FROM_DATE_FOR_VALIDATION%>,event)" />

<label class="auto">To Date </label> <input
	name="<%=TO_DATE_FOR_VALIDATION %>" type="text" class="date"
	MAXLENGTH="15" / tabindex=1 readonly /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" class="calendar"
	border="0" validate="Pick a date"
	onClick="setdate('',document.requisitionApproval.<%=TO_DATE_FOR_VALIDATION%>,event)" />

<input type="hidden" name="<%=HOSPITAL_ID %>" value="<%=hospitalId%>" />
<input type="hidden" name="<%=EMPLOYEE_ID %>" value="<%=employeeId%>" />
<input name="save" type="button" class="button" value="Search"
	onClick="checkAndSubmit()" /> <!--  <input name="save" type="button" class="button" value="Back" onClick="javascript:history.back()"/>-->
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="division"></div>

<div class="clear"></div>
<div id="update">
<form name="requestResource" method="post">
<% int  counter=0;%>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<%if (resourceRequisitionList != null && resourceRequisitionList.size()> 0) {  %>
<table id="searchresulttable" width="100%" cellspacing="0"
	cellpadding="0">
	<tr>
		<th><input type="checkbox" name="allIds" value="yes"
			onClick="checkAll()" class="radioCheck" /></th>
		<th>Req. Id</th>
		<th>Intitiator Name</th>
		<th>Employee Type</th>
		<th>Department Name</th>
		<th>Total no. of positions</th>
		<th>Status</th>
	</tr>



	<%
		String klass = "even";
		
	
	 	for(ResourceRequisition resourceRequisition : resourceRequisitionList){
	 		String id = "";
	 		id = "id" + counter;
	 		counter++;
	 		
	 		if(counter%2==0){
	 			klass = "even"; 
	 		}
	 		else
	 		{
	 			klass= "odd";
	 		}
	 		
	%>
	<tbody id="tableData">

		<%
	  		String expRange = "--";
	  		String positionPurpose = "--";
	  		String salaryRange = "--";
	  		if(resourceRequisition.getExpLowerRange()!= null && resourceRequisition.getExpUpperRange()!=null)
	  		{
	  			expRange = resourceRequisition.getExpLowerRange()+" to " + resourceRequisition.getExpUpperRange()+" yrs";
	  		}
	  		if(resourceRequisition.getPositionPurpose()!= null)
	  		{
	  			positionPurpose = resourceRequisition.getPositionPurpose();
	  		}
	  		if(resourceRequisition.getSalaryLowerRange()!=null && resourceRequisition.getSalaryUpperRange()!=null)
	  		{
	  			salaryRange ="Rs "+ resourceRequisition.getSalaryLowerRange() +" to "+ resourceRequisition.getSalaryUpperRange() ;
	  		}
	  		
	  		%>
		<div id="balloon<%=counter%>" class="balloonstyle"><label>Request
		Id</label> <label class="value"><%=resourceRequisition.getId()%></label> <label>Date</label><label
			class="value"> <%=resourceRequisition.getRequisitionDate()%></label>
		<label>Name of Initiator</label> <label class="value"><%=resourceRequisition.getInitiator().getFirstName() + " " +resourceRequisition.getInitiator().getLastName()%></label>
		<label>Employee Type</label><label class="value"><%=resourceRequisition.getEmployeeType().getEmpType()%></label>
		<label>Department</label> <label class="value"><%=resourceRequisition.getDepartment().getDepartmentName()%></label>
		<label>Desirable Exp</label> <label class="value"><%=expRange %></label>
		<label>Total No. Of Positions</label> <label class="value"><%=resourceRequisition.getTotalNoPosition()%></label>
		<label>Salary Range </label> <label class="value"><%=salaryRange%></label>
		<label>Deptt. Manpower Cost</label><label class="value"><%=new BigDecimal(Float.toString(resourceRequisition.getTotalDepartmentCTC())).intValue() %>/-</label>
		<%if(resourceRequisition.getMarketCtc()!=null){%> <label>Current
		Mkt CTC</label><label class="value"><%=resourceRequisition.getMarketCtc()%>/-</label>
		<label>Tentative Manpower Cost</label><label class="value"><%=new BigDecimal(Float.toString(resourceRequisition.getTotalDepartmentCTC())).intValue()+ (resourceRequisition.getMarketCtc() * resourceRequisition.getTotalNoPosition())%>/-</label>

		<%} %>
		</div>
		<%
	  		String requistionStatus = "";
	  		if(intermediateApproverDesignation.getId().equals(resourceRequisition.getApprovingManager().getRank().getId()) && resourceRequisition.getHrResourceRequisitionStatus().getCurrentLevel().equals(1)|| ( resourceRequisition.getApprovingManager().getRank().getId().equals(finalApproverDesignation.getId()) &&  resourceRequisition.getHrResourceRequisitionStatus().getCurrentLevel().equals(2)))
	  		{
	  			requistionStatus = "Initiated By " + resourceRequisition.getInitiator().getFirstName() + " " + resourceRequisition.getInitiator().getLastName();
	  		}
	  		else
	  		{
	  			requistionStatus = resourceRequisition.getHrResourceRequisitionStatus().getRequestStatusMaster().getStatusDesc() + " by " + resourceRequisition.getHrResourceRequisitionStatus().getMasEmployee().getFirstName() + " " +resourceRequisition.getHrResourceRequisitionStatus().getMasEmployee().getLastName();
	  		}
	  		
	  		%>
		<tr class=<%= klass%> id="<%=counter%>">
			<td><input type="checkbox" name=<%=id %>
				value="<%=resourceRequisition.getId()%>" onClick="unCheck(this)"
				class="radioCheck" /></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=resourceRequisition.getId()%>)"
				rel="balloon<%=counter%>"><%=resourceRequisition.getId()%></a></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=resourceRequisition.getId()%>)"
				rel="balloon<%=counter%>"><%=resourceRequisition.getInitiator().getFirstName()+" "+resourceRequisition.getInitiator().getLastName()%></a></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=resourceRequisition.getId()%>)"
				rel="balloon<%=counter%>"><%=resourceRequisition.getEmployeeType().getEmpType()%></a></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=resourceRequisition.getId()%>)"
				rel="balloon<%=counter%>"><%=resourceRequisition.getDepartment().getDepartmentName()%></a></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=resourceRequisition.getId()%>)"
				rel="balloon<%=counter%>"><%=resourceRequisition.getTotalNoPosition()%></a></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=resourceRequisition.getId()%>)"
				rel="balloon<%=counter%>"><%=requistionStatus%></a></td>
		</tr>

	</tbody>
	<%
	  	}
	  	%>
</table>
<script>
	  	intializeHover('searchresulttable', 'tr', ' tableover');
	  </script> <script>
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
	  </script>
<div class="clear"></div>

<div class="block"><label>Status</label> <select
	name="requestStatus">
	<% for(RequestStatusMaster requestStatus : requestStatusMasterList){%>
	<option value=<%=requestStatus.getId()%>><%= requestStatus.getStatusDesc()%></option>
	<%} %>
</select> <label>Comments</label> <textarea id="<%=COMMENTS %>"
	name="<%=COMMENTS %>" validate="Comments,'',no"
	onkeydown="refreshLengthWithoutMeter1(this.id,250)"
	onkeyup="refreshLengthWithoutMeter(this.id,250)"></textarea> <input
	type="button" class=button value="Go" onClick="updatestatus()" />
<div class="clear"></div>
</div>
<%		
	 }
	else{
	%> <label>No Record Exists</label> <%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>

<script>

	

function checkAll()
{
var no = <%=counter%>;

for(i=0;i<no;i++)
{
var obj = "document.requestResource." + "id" +i;
obj=eval(obj);
if(obj.disabled==true)
{
}
else
{
if(document.requestResource.allIds.checked==true)
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
document.requestResource.allIds.checked=false;
}
}

function checkAndSubmit()
{
	val = dateCompare1('requisitionApproval');
	
	if(val == true){
	submitForm('requisitionApproval','recruitment?method=showRequestApprovalScreen');
	}
	else
	{
		document.requisitionApproval.reset();
	}
}
function changeClass(obj)
{
	obj.getAttribute('class') += ' tableover';
}
function chkCheckBoxesForAuthorization()
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
			alert("Please select atleast one request.");
			return false;
		}
		return true;
	}

function updatestatus()
{
val = chkCheckBoxesForAuthorization();
if(val==true)
submitForm('requestResource','recruitment?method=updateRequisitionStatus')
}

function showRequisitionScreen(requestId)
{
	document.location.href = "recruitment?method=showResourceDetailForUpdate&requisitionId="+requestId;
}
</script>
