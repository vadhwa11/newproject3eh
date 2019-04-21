<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hrms.recruitment.masters.business.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.*"%>
<%
	Map map = null; 
	if(request.getAttribute("map") != null)
	{
	map = (Map)request.getAttribute("map");
	}
	List<Resumepersonaldetails> resumeListToBeShortListed = (List<Resumepersonaldetails>)map.get("resumeListToBeShortListed");
	session.setAttribute("searchResumeList",resumeListToBeShortListed);
	List<ResourceRequisition> manPowerRequisitionList = (List)map.get("manPowerRequisitionList");
	List<Users> rmsIdList = null;
	if(map.get("rmsIdList") != null){
		rmsIdList = (List<Users>)map.get("rmsIdList");
		}
	
%>
<%@page import="java.math.BigDecimal"%>

<script type="text/javascript" src="/hms/jsp/js/balloontip.js">

/***********************************************
* Rich HTML Balloon Tooltip- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>
<div class="titleBg">
<h2>Shortlist Resume</h2>
</div>

<div class="clear"></div>

<form name="shortlistResume" method="post">

<div class="clear"></div>
<h4><u>Resume List :</u></h4>
<div class="clear"></div>
<%
 	int i = 0;
	String klass = "";
 	if(resumeListToBeShortListed.size()!=0){ %>
<table cellspacing="0" cellpadding="0" width="100%">
	<tr>
		<th><input type="checkbox" name="allIds" value="yes"
			onClick="checkAll()" class="radioCheck" /></th>
		<th>R Id</th>
		<th>Candidate's Name</th>
		<th>Present Location</th>
		<th>Exp(in yrs)</th>
		<th>Expected CTC</th>
		<th>Status</th>
	</tr>
	<tbody>
		<%
 				
 				for(Resumepersonaldetails resume : resumeListToBeShortListed ){
 				
 				if(i%2 == 0)
 				{
 					klass="even";
 				}
 				else
 				{
 					klass="odd";
 				}
 				String expectedCTC = resume.getResumeStatus().getExpectedCTC();
 				if(expectedCTC == null)
 				{
 					expectedCTC = "--";
 				}
 				i++;
 				String city = "--";
 				if(resume.getCity()!=null)
 				{
 					city = resume.getCity().getDistrictName();
 				}
 				%>

		<tr class=<%=klass%>">
			<td><input type="checkbox" name="id<%=i%>"
				value="<%=resume.getId()%>" onClick="unCheck(this)"
				class="radioCheck" /></td>
			<td><%=resume.getId()%></td>
			<td><%=resume.getFirstName() + " " +resume.getLastName()%></td>
			<td><%=city%></td>
			<td><%=resume.getExperienceYear()%></td>
			<td><%=expectedCTC%></td>
			<td><%=resume.getResumeStatus().getResumestatusmaster().getStatusDesc()%>
			</td>
		</tr>
		<%} %>
	</tbody>
</table>
<%} 
 	else
 	{%>
<h4>No uploaded Resumes are there .Upload Resume first .</h4>
<%}
 	%>
<div class="clear"></div>
<div class="division"></div>
<h4><u>Select Request :</u></h4>
<div class="clear"></div>

<%if(manPowerRequisitionList.size()!=0){ %>
<table width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<th>Select</th>
		<th>Request Id</th>
		<th>Intitiator Name</th>
		<th>Employee Type</th>
		<th>Department Name</th>
		<th>Total no. of positions</th>
		<th>No. of positions occupied</th>
		<th>Status</th>
	</tr>
	<tbody>
		<%
 			 i = 0;
 			 klass= "";
 			for(ResourceRequisition manpowerRequest : manPowerRequisitionList){
 			if(i%2 == 0)
 			{
 				klass= "even";
 			}
 			else
 			{
 				klass="odd";
 			}
 			String status = "";
 			if(manpowerRequest.getHrResourceRequisitionStatus().getCurrentLevel()==3)
 			{
 			status = "approved by CEO";
 			}
 				
 			
	  		String expRange = "--";
	  		String positionPurpose = "--";
	  		String salaryRange = "--";
	  		if(manpowerRequest.getExpLowerRange()!= null && manpowerRequest.getExpUpperRange()!=null)
	  		{
	  			expRange = manpowerRequest.getExpLowerRange()+" to " + manpowerRequest.getExpUpperRange()+" yrs";
	  		}
	  		if(manpowerRequest.getPositionPurpose()!= null)
	  		{
	  			positionPurpose = manpowerRequest.getPositionPurpose();
	  		}
	  		if(manpowerRequest.getSalaryLowerRange()!=null && manpowerRequest.getSalaryUpperRange()!=null)
	  		{
	  			salaryRange ="Rs "+ manpowerRequest.getSalaryLowerRange() +" to "+ manpowerRequest.getSalaryUpperRange() ;
	  		}
	  		
	  		
 		%>
		<div id="balloon<%=i%>" class="balloonstyle"><label>Request
		Id</label> <label class="value"><%=manpowerRequest.getId()%></label> <label>Date</label><label
			class="value"> <%=manpowerRequest.getRequisitionDate()%></label> <label>Name
		of Initiator</label> <label class="value"><%=manpowerRequest.getInitiator().getFirstName() + " " +manpowerRequest.getInitiator().getLastName()%></label>
		<label>Employee Type</label><label class="value"><%=manpowerRequest.getEmployeeType().getEmpType()%></label>
		<label>Department</label> <label class="value"><%=manpowerRequest.getDepartment().getDepartmentName()%></label>
		<label>Desirable Exp</label> <label class="value"><%=expRange %></label>
		<label>Total No. Of Positions</label> <label class="value"><%=manpowerRequest.getTotalNoPosition()%></label>
		<label>Salary Range </label> <label class="value"><%=salaryRange%></label>
		<label>Deptt. Manpower Cost</label><label class="value"><%=new BigDecimal(Float.toString(manpowerRequest.getTotalDepartmentCTC())).intValue() %>/-</label>
		<%if(manpowerRequest.getMarketCtc()!=null){%> <label>Current Mkt
		CTC</label><label class="value"><%=manpowerRequest.getMarketCtc()%>/-</label>
		<label>Tentative Manpower Cost</label><label class="value"><%=new BigDecimal(manpowerRequest.getTotalDepartmentCTC()).intValue()+ (manpowerRequest.getMarketCtc() * manpowerRequest.getTotalNoPosition())%>/-</label>

		<%} %>
		</div>
		<tr class="<%=klass%>">
			<td><input name="rb" class="radioCheck" id="rb<%=i%>"
				type="radio" value='<%=manpowerRequest.getId()%>' /></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=manpowerRequest.getId()%>)"
				rel="balloon<%=i%>"><%=manpowerRequest.getId()%></a></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=manpowerRequest.getId()%>)"
				rel="balloon<%=i%>"><%=manpowerRequest.getInitiator().getFirstName()+" "+manpowerRequest.getInitiator().getLastName()%></a></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=manpowerRequest.getId()%>)"
				rel="balloon<%=i%>"><%=manpowerRequest.getEmployeeType().getEmpType() %></a></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=manpowerRequest.getId()%>)"
				rel="balloon<%=i%>"><%=manpowerRequest.getDepartment().getDepartmentName() %></a></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=manpowerRequest.getId()%>)"
				rel="balloon<%=i%>"><%=manpowerRequest.getTotalNoPosition() %></a></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=manpowerRequest.getId()%>)"
				rel="balloon<%=i%>"><%=manpowerRequest.getNoOfPositionOccupied() %></a></td>
			<td><a
				href="javascript:showRequisitionScreen(<%=manpowerRequest.getId()%>)"
				rel="balloon<%=i%>"><%=status %></a></td>
		</tr>
		<script>
 			document.getElementById('rb0').checked = 'checked';
 		</script>
 		<%
 		i++;
 			}
 		%>	
</tbody>
</table>
<%}
else
{%>
<h4>No Manpower Requests Are Present</h4>
<%}%>
<div class="clear"></div>
<select name="assignedTo" style="display: none;">
	<%for (Users user1 : rmsIdList)
	{
	String name1 = user1.getUserName()+"-"+user1.getEmployee().getEmployeeCode();%>
	<option value="<%=user1.getId()%>"><%=name1%></option>
	<%}%>
</select>
<div class="paddingTop40"></div>
<%if(resumeListToBeShortListed.size()!=0){ %> 
<input type="button" name="assignto" value="Submit" class="button"	onClick="checkAndSubmit()"> 
<%} %> 
<input type="button" name="back" value="Back" class="button" onClick="history.back()">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>
 	function checkAndSubmit()
 	{
 	url='';
 	for(i = 0 ;i<<%=manPowerRequisitionList.size()%>;i++)
 	{
 		radioButton = document.getElementById('rb'+i);
 		
 		if(radioButton.checked == true)
 		{
 		 url = '/hms/hrms/resume?method=changeAssignedTo&requestId='+ radioButton.value;
 		}
 	}
 	if(url == '')
 		{
 		alert('Please select a manpower request');
 		}
 		else
 		{
 		submitForm('shortlistResume',url,'chkCheckBoxesForAuthorization');
 		}
 	}
 	
 	function changeAssignedTo()
	{
	if(document.shortlistResume.assignedTo.value == "")
	{
	errorMsg += "First Select Any Authority Member. \n";
	return false;	
	}
	checkCCList();
	return true;
	}
	
	function checkCCList()
	{
	var myString = document.shortlistResume.<%=RequestConstants.CCLIST%>.value;
	var ccArray = myString.split(",");
	if(myString != null && myString!="")
	{
	for(var i=0;i<ccArray.length;i++)
		{
		if(!validateEmail(ccArray[i]))
			{
			errorMsg +="Please Enter the valid CC List. \n";
			return false;
			}
		}
	}
	}
	
	function chkCheckBoxesForAuthorization()
	{
	if(document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').substring(document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').length-3)=='yes'){
	document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.setAttribute('validate',document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').substring(0,document.searchResults.<%=RequestConstants.MAIL_SUBJECT%>.getAttribute('validate').length-3)+'no')	
	}
	inps = document.getElementsByTagName('input');
	flag=false;
	for(i=0;i<inps.length;i++)
	{
	if(inps[i].type == 'checkbox' && inps[i].name != "allIds" && inps[i].name != "<%=RequestConstants.ONSITEAVAILABILITY%>" && inps[i].name != "<%=RequestConstants.ARCHIEVEDRECORDS%>" && inps[i].name!="enableAdvance")
		{
		if(inps[i].checked)
		{
		name = 'status' + i;
		alert(document.searchResults.name.innerHtml);
	
		flag=true;
	
		break;
		}
		}
	}
	if(!flag)
	{
		errorMsg +="Please select one of the candidate.";
		return false;
	}
	return true;
}




function unCheck(obj)
{
	if(obj.checked==false)
	{
	document.shortlistResume.allIds.checked=false;
	}
}


function checkAll()
{
	var no = <%=resumeListToBeShortListed.size()%>;
	
	for(j=1;j<=no;j++)
	{
		var obj = "document.shortlistResume." + "id" +j;
		obj=eval(obj);
		if(obj.disabled==true)
		{
		}
		else
		{
			if(document.shortlistResume.allIds.checked==true)
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


function chkCheckBoxesForAuthorization()
{
inps = document.getElementsByTagName('input');
flag=false;
for(i=0;i<inps.length;i++)
{
if(inps[i].type == 'checkbox' && inps[i].name != "allIds")
{
if(inps[i].checked)
{
name = 'status' + i;
flag=true;
	
break;
}
}
}
if(!flag)
{
errorMsg +="Please select one of the candidate.";
return false;
}
return true;
}
 </script>