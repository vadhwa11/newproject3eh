<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hrms.recruitment.masters.business.*"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<Resumepersonaldetails> resumeList = new ArrayList<Resumepersonaldetails>();
				List<RequestStatusMaster> requestStatusMasterList = new ArrayList<RequestStatusMaster>();
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
				if(map.get("resumeList")!= null){
					resumeList = (List)map.get("resumeList");
				}
				if(map.get("requestStatusMasterList")!= null){
					requestStatusMasterList = (List)map.get("requestStatusMasterList");
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
					employeeId = masEmployee.getId();
				
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");	 
				session.setAttribute("map",map);
%>
<%@page import="jkt.hms.util.RequestConstants"%>
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
<h2>Joining Approval</h2>
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
</div>
<input type="hidden" name="<%=HOSPITAL_ID %>" value="<%=hospitalId%>" />
<input type="hidden" name="<%=EMPLOYEE_ID %>" value="<%=employeeId%>" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="save" type="button" class="button" value="Search" onClick="checkAndSubmit()" /> 
<!--  <input name="save" type="button" class="button" value="Back" onClick="javascript:history.back()"/>-->
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<div class="clear"></div>
<div id="update">
<form name="requestResource" method="post">
<% int  counter=0;%>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<%if (resumeList != null && resumeList.size()> 0) {  %>
<table id="searchresulttable" width="100%" cellspacing="0"
	cellpadding="0">
	<tr>
		<th><input type="checkbox" name="allIds" value="yes"
			onClick="checkAll()" class="radioCheck" /></th>
		<th>Name</th>
		<th>Offered Designation</th>
		<th>Offered CTC</th>
		<th>Date Of Joining</th>
		<th>Status</th>
		<th>CTC Annexure</th>
	</tr>



	<%
		String klass = "even";
		
	
	 	for(Resumepersonaldetails resumepersonaldetails : resumeList){
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
	 		
	 		String offeredCTC = resumepersonaldetails.getResumeStatus().getCtc();
	 		if(offeredCTC == null)
	 		{
	 			offeredCTC = "--";
	 		}
	 		
	 		String status = resumepersonaldetails.getResumeStatus().getResumestatusmaster().getStatusDesc(); 
	 		if(resumepersonaldetails.getResumeStatus().getResumestatusmaster().getId().equals(13)){
	 			status = "Waiting for Joining Approval";
	 		}
	 		if(resumepersonaldetails.getResumeStatus().getResumestatusmaster().getId().equals(20)){
	 			status = "Waiting for Offer Approval";
	 		}
	 		Integer relocationReimbursement = 0;
	 		if(resumepersonaldetails.getResumeStatus().getRelocationReimbursement()!=null)
	 		{
	 			relocationReimbursement = resumepersonaldetails.getResumeStatus().getRelocationReimbursement();
	 		}
	 		
	 		Integer noticePeriod = 0;
	 		if(resumepersonaldetails.getResumeStatus().getNoticePeriod()!=null)
	 		{
	 			noticePeriod = resumepersonaldetails.getResumeStatus().getNoticePeriod();
	 		}
	 		
	 		String hrRemarks = "--";
	 		if(resumepersonaldetails.getResumeStatus().getHrRemarks()!=null)
	 		{
	 			hrRemarks = resumepersonaldetails.getResumeStatus().getHrRemarks();
	 		}
	 		Integer probationPeriod = 0;
	 		if(resumepersonaldetails.getResumeStatus().getProbationPeriod()!=null)
	 		{
	 			probationPeriod = resumepersonaldetails.getResumeStatus().getProbationPeriod();
	 		}
	%>
	<tbody id="tableData">
		<div id="balloon<%=counter%>" class="balloonstyle"><label>Resume
		Id</label> <label class="value"><%= resumepersonaldetails.getId() %></label> <label>Candidate
		Name</label> <label class="value"><%= resumepersonaldetails.getFirstName() + " " + resumepersonaldetails.getLastName() %></label>
		<label>Offered CTC </label> <label class="value"><%=resumepersonaldetails.getResumeStatus().getCtc()+"/-" %></label>
		<label>Offered Designation </label> <label class="value"><%=resumepersonaldetails.getResumeStatus().getDesignation().getRankName() %></label>
		<label>Location Allocated</label> <label class="value"><%=resumepersonaldetails.getResumeStatus().getLocation()%></label>
		<label>Relocation Reimbursement</label> <label class="value"><%=relocationReimbursement +"/-"%></label>
		<label>Notice Period</label> <label class="value"><%=noticePeriod + " days" %></label>
		<label>Date of Joining</label> <label class="value"><%=resumepersonaldetails.getResumeStatus().getDateOfJoin() %></label>
		<label>Project Assigned</label> <label class="value"><%=resumepersonaldetails.getResumeStatus().getProjectAssign() %></label>
		<label>Hr Remarks</label> <label class="value"><%=hrRemarks %></label>
		<%if(resumepersonaldetails.getResumeStatus().getStatusId().equals(13)) {%>
		<label>Probation Period</label> <label class="value"><%=probationPeriod +" months"%></label>
		<%} %>
		</div>


		<tr class=<%= klass%> id="<%=counter%>">
			<td><input type="checkbox" name=<%=id %>
				value="<%=resumepersonaldetails.getId()%>" onClick="unCheck(this)"
				class="radioCheck" /></td>
			<td><a href="#" rel="balloon<%=counter %>"><%=resumepersonaldetails.getFirstName() + " " +resumepersonaldetails.getLastName()%></a></td>
			<td><a href="#" rel="balloon<%=counter %>"><%=resumepersonaldetails.getResumeStatus().getDesignation().getRankName()%></a></td>
			<td><a href="#" rel="balloon<%=counter %>"><%=offeredCTC%></a></td>
			<td><a href="#" rel="balloon<%=counter %>"><%=resumepersonaldetails.getResumeStatus().getDateOfJoin() %></a></td>
			<td><a href="#" rel="balloon<%=counter %>"><%= status%></a></td>
			<td><a
				href="resume?method=previewCTCAnnexureHrHead&<%=RequestConstants.RESUMEID %>=<%=resumepersonaldetails.getId() %>"
				rel="balloon<%=counter %>"><img
				src="/hms/jsp/images/preview.jpeg" /></a></td>
		</tr>

	</tbody>
	<%
	  	}
	  	%>
</table>
<script>
	  	intializeHover('searchresulttable', 'tr', ' tableover');
	  </script> 
<script>
var pager = new Pager('tableData',5); 
pager.init(); 
pager.showPageNav('pager', 'pageNavPosition'); 
pager.showPage(1);
</script>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="block"> 
	<label>Status</label>
	<select name="resumetStatus">
		<option value='14'>Approve Offer</option>
		<option value='18'>Approve Joining</option>
		<option value='15'>Disapprove</option>
		<option value='16'>On hold</option>
		<option value='17'>Send back</option>
	</select>
	<div id="remarks" style="display:block;">
	<label>Remarks</label>
	<textarea id="remarks1" name="hrRemarks" onkeydown="refreshLengthWithoutMeter1(this.id,250)" onkeyup="refreshLengthWithoutMeter(this.id,250)"></textarea>
	</div>
	<input type="button"  class=button value="Go" onClick ="updatestatus()"/>
	<div class="clear"></div>
<%
}else{
%>
<label><h4>No Record Exists</h4></label>
<%} %><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
	obj.getAttribute('class') += 'tableover';
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
submitForm('requestResource','resume?method=updateResumeStatus')
}

function remarks()
{
	if(document.getElementById('resumeStatus').value = '15')
	{ 
	document.getElementById('remarks').style.display = 'block';	
	}
}

<%if(map.get("preview")!=null)
{
%>
my = window.open("../Reports/ctcAnnexure.html","_blank","scrollbars=yes", "resizable=yes", "copyhistory=no", "width=600 "," height=900");
my.focus();
<%}%>
</script>
