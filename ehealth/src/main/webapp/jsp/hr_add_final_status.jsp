<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hrms.recruitment.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hrms.masters.business.*"%>




<script>
<%
		Calendar calendar=Calendar.getInstance();
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
</script>


<% 
	   	Map map=(Map)request.getAttribute("map");
	   	String name=(String)map.get("name");
	  	List resumeStatusList=(List)map.get("resumeStatus");
	  	List designationMasterList=(List)map.get("designationMasterList");
	    List locationMasterList=(List)map.get("locationMasterList");
		List currencyMasterList=(List)map.get("currencyMasterList");	
	  	Resumestatus resumeStatus=(Resumestatus)resumeStatusList.get(0);
	  	List statusMasterList=(List)map.get("statusMasterList");
	  	Iterator statusMasterIterator=statusMasterList.iterator();
	  	String offer = (String)map.get("offer");
	  	
	  %>
<div class="titleBg">
<h2>Offer/Joining Details</h2>
</div>
<form name="addFinalStatus" action="" method="post">
<div class="Block"><input type="hidden"
	name="<%=RequestConstants.RESUMEID%>"
	value="<%=resumeStatus.getResumeId()%>" /> <!--  <a href="/jktintranet/jkt/resume?method=showHistory&resumeId=<%=resumeStatus.getResumeId()%>&jspName=status&candidateName=<%=name%>">View History</a>-->


<label>Name</label> <label class="value"><%=name%></label> <input
	type="hidden" name="statusValue" value="" /> <%if(resumeStatus.getStatusId().equals(14) && offer!=null && !offer.equals("true")) {
			
			%> <input type="hidden" name="statusId" value="13" />
<div id="probation"><label> Probation Period</label> <select
	name="<%=RequestConstants.PROBATION_PERIOD %>"
	validate="Probation Period ,int,no">
	<option value="0">Select</option>
	<option value="6">6 months</option>
	<option value="12">12 months</option>
</select>
<div class="clear"></div>
</div>

<%} %> <%if(offer.equals("true")&& (resumeStatus.getStatusId().equals(10) ||resumeStatus.getStatusId().equals(15)||resumeStatus.getStatusId().equals(17)||resumeStatus.getStatusId().equals(18)||resumeStatus.getStatusId().equals(14))){ %>
<div id="ifselected"><input type="hidden" name="statusId"
	value="11" /> <label>Designation Proposed</label> <label><%= resumeStatus.getResumepersonaldetails().getResourceRequisition().getProposedDesignation()%></label>


<div class="clear"></div>
<label><span>* </span>Designation Assigned</label> <select
	name="<%=RequestConstants.DESIGNATION%>" validate="Designation,int,no"
	class="select6">
	<option value="0">Select</option>
	<% 
					for(int i=0;i<designationMasterList.size();i++)
					{
						MasRank designationMaster=(MasRank)designationMasterList.get(i);
		   %>
	<option value="<%=designationMaster.getId()%>"><%=designationMaster.getRankName()%></option>

	<% 
					}
			%>
</select> <label><span>* </span>Offered CTC</label> <input type="text"
	name="<%=RequestConstants.CTC%>" value="" validate="Offered CTC,num,no"
	maxlength="10" /> <label><span>* </span>Currency</label> <select
	name="<%=RequestConstants.CURRENCY%>" validate="Currency,string,no"
	class="select1">
	<option value="">Select</option>

	<%
			    String currencySelected=resumeStatus.getCurrency();
				Iterator currencyMasterIterator=currencyMasterList.iterator();
				
				while(currencyMasterIterator.hasNext())
				{	
					MasCurrency currencyMaster=(MasCurrency)currencyMasterIterator.next();
					
					String currencyId=currencyMaster.getId().toString();
					String currencyName=currencyMaster.getCurrencyName();
					if(currencyId.equals(currencySelected))
					{
				%>

	<option selected value="<%=currencyMaster.getCurrencyCode()%>"><%=currencyName%></option>


	<%	
					}else
					{
				%>
	<option value="<%=currencyMaster.getCurrencyCode()%>"><%=currencyName%></option>
	<%
					}
				}
				%>
</select>

<div class="clear"></div>

<label><span>* </span>Date of Joining</label> <input type="text"
	name="<%=RequestConstants.DATEOFJOINING%>" value="" class="date"
	validate="Date of Joining,employeeDateOfJoining,no" readonly
	tabindex=500 /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('',document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>,event)" />

<label>Salary Remarks</label> <input type="text"
	name="<%=RequestConstants.SALARYREMARKS%>" value="" maxlength="35" />
<label><span>* </span>Location Allocated</label> <select
	name="<%=RequestConstants.LOCATION%>"
	validate="Location Allocated,string,no" class="select1">
	<option value="" selected>Select</Option>
	<% for(int i=0;i<locationMasterList.size();i++)
					{
						MasLocation locationMaster=(MasLocation)locationMasterList.get(i);%>
	<option value="<%=locationMaster.getLocationName()%>"><%=locationMaster.getLocationName()%></option>
	<% 	}%>
</select>

<div class="clear"></div>
<label><span>* </span>Project Assigned</label> <input
	name="<%=RequestConstants.PROJECTASSIGNED%>" value="" type="text"
	class="size30" validate="Project Assigned,alphaNumeric,no"
	maxlength="50" /> <label>Relocation Reimbursement <br />
(in Rs)</label> <input name="<%=RequestConstants.RELOCATION_REIMBURSEMENT%>"
	value="" type="text" validate="Relocation Reimbursement,int,no"
	maxlength="7" /> <label>Notice Period Reimbursement</label> <input
	name="<%=RequestConstants.NOTICE_PERIOD_REIMBURSEMENTS%>" value=""
	type="text" validate="Relocation Reimbursement,int,no" maxlength="7" />
<div class="clear"></div>
<label>Notice Period <br />
(in days)</label> <input name="<%=RequestConstants.NOTICE_PERIOD%>" value=""
	type="text" validate="Notice Period ,int,no" maxlength="3" /></div>
<%} %>
<div class="clear"></div>
<label><span>* </span>Remarks</label> <textarea
	name="<%=RequestConstants.REMARKS%>" validate="Remarks,remarks,yes"
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="1500"></textarea>
<div class="clear"></div>
</div>
<script>
				var status = "";
				if("HR Selected"!=status)
				{
					document.addFinalStatus.<%=RequestConstants.STATUS%>.value=status;
				}
				document.addFinalStatus.statusValue.value=status;
				<%
				Integer designationId = 0;
				if(resumeStatus.getDesignation()!=null)
				{
					designationId = resumeStatus.getDesignation().getId();
				}
				%>			
				if(document.addFinalStatus.<%=RequestConstants.STATUS%>.value == "Selected" || document.addFinalStatus.<%=RequestConstants.STATUS%>.value == "Offered"){
					document.getElementById('ifselected').style.display = 'block'; 
					document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.value="<%=designationId%>";
					document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.value= "<%=resumeStatus.getDateOfJoin()%>" ;
					<%
						String currentCTC=resumeStatus.getCurrentCTC();
						if(resumeStatus.getCurrentCTC()==null)
							currentCTC="";
						String expectedCTC=resumeStatus.getExpectedCTC();
						if(resumeStatus.getExpectedCTC()==null)
							expectedCTC="";
						String salaryRemarks=resumeStatus.getSalaryRemarks();
						if(resumeStatus.getSalaryRemarks()==null)
							salaryRemarks="";
						String remarks=resumeStatus.getRemarks();
						if(resumeStatus.getRemarks()==null)
							remarks="";	
					
					%>
					document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.value= "<%=currentCTC%>" ;
					document.addFinalStatus.<%=RequestConstants.EXPECTEDSALARY%>.value= "<%=expectedCTC%>" ;
					document.addFinalStatus.<%=RequestConstants.SALARYREMARKS%>.value= "<%=salaryRemarks%>" ;
					document.addFinalStatus.<%=RequestConstants.REMARKS%>.value= "<%=remarks%>" ;
					document.addFinalStatus.<%=RequestConstants.LOCATION%>.value= "<%=resumeStatus.getLocation()%>" ;
					document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.value= "<%=resumeStatus.getProjectAssign()%>" ;
					document.addFinalStatus.<%=RequestConstants.RELOCATION_REIMBURSEMENT%>.value= "<%=resumeStatus.getRelocationReimbursement()%>" ;
					document.addFinalStatus.<%=RequestConstants.NOTICE_PERIOD%>.value= "<%=resumeStatus.getNoticePeriod()%>" ;
				
				document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').length-2)+'yes')
				document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').length-2)+'yes')
				document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.getAttribute('validate').length-2)+'yes')
				document.addFinalStatus.<%=RequestConstants.CURRENCY%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.CURRENCY%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.CURRENCY%>.getAttribute('validate').length-2)+'yes')
				document.addFinalStatus.<%=RequestConstants.LOCATION%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.LOCATION%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.LOCATION%>.getAttribute('validate').length-2)+'yes')
				document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.getAttribute('validate').length-2)+'yes')					
					
				}/*else
				{
					document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.CURRENCY%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.CURRENCY%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.CURRENCY%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.LOCATION%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.LOCATION%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.LOCATION%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.getAttribute('validate').length-3)+'no')
				}*/
			</script> <%if(offer.equals("true")&& (resumeStatus.getStatusId().equals(10) ||resumeStatus.getStatusId().equals(15)||resumeStatus.getStatusId().equals(17)||resumeStatus.getStatusId().equals(18)||resumeStatus.getStatusId().equals(14))){ %>
<input type="button" name="<%=RequestConstants.ADD%>"
	value="Save Offer Details" class="buttonBig" onClick="submitThisForm()" />
<%}else if (resumeStatus.getStatusId().equals(14)){ %> <input
	type="button" name="<%=RequestConstants.ADD%>"
	value="Send For Joining Approval" class="buttonBig"
	onClick="submitThisForm()" /> <%} %> <input type="button" name="back"
	value="Back" class="button" onClick="history.back()"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<script><!--

	function checkCtc()
	{   
	    var expectedCTC=parseInt(document.addFinalStatus.<%=RequestConstants.EXPECTEDSALARY%>.value);
	    var currentCTC=parseInt(document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.value);
		if(isNaN(expectedCTC))
			return true;
                if((currentCTC <= expectedCTC) || (expectedCTC == "")){
                	return true;
                }          
                else if(currentCTC > expectedCTC){
                   errorMsg += "Current CTC cannot be greater than Expected CTC \n";
                   return false;
                }
	}
	
	function showSelected()
	{
		var status=document.addFinalStatus.<%=RequestConstants.STATUS%>.value;
		var oldStatus = document.addFinalStatus.statusValue.value;
		if(status == 'Backed Out')
		{
			document.getElementById('probation').style.display = "none";
			if(!confirm("You are about to change the status of this Candidate as Backed Out.\nAre you sure."))
			{
				document.addFinalStatus.<%=RequestConstants.STATUS%>.value=oldStatus;
				if(oldStatus == 'Offered')
				{
					document.getElementById('ifselected').style.display = 'block'; 
					document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.value="<%=designationId%>";
					document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.value= "<%=resumeStatus.getDateOfJoin()%>" ;
					document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.value= "<%=resumeStatus.getCtc()%>" ;
					document.addFinalStatus.<%=RequestConstants.LOCATION%>.value= "<%=resumeStatus.getLocation()%>" ;
					document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.value= "<%=resumeStatus.getProjectAssign()%>" ;
					
					return true;
				}
			}
			else{
				document.getElementById('ifselected').style.display = 'none'; 
				document.addFinalStatus.statusValue.value=status;
				return true;
			}
		}
		if(status == 'Offered')
		{  
	  		document.getElementById('ifselected').style.display='block'; 
			document.getElementById('probation').style.display = "none";
			document.addFinalStatus.statusValue.value=status;
			document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.focus();
			if(document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').substring(document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').length-2)=='no'){
				document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').length-2)+'yes')
				document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').length-2)+'yes')
				document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.getAttribute('validate').length-2)+'yes')
				document.addFinalStatus.<%=RequestConstants.CURRENCY%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.CURRENCY%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.CURRENCY%>.getAttribute('validate').length-2)+'yes')
				document.addFinalStatus.<%=RequestConstants.LOCATION%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.LOCATION%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.LOCATION%>.getAttribute('validate').length-2)+'yes')
				document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.getAttribute('validate').length-2)+'yes')
			}
		  	else{ 
		  		document.getElementById('ifselected').style.display='none';
		  		document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.CURRENCY%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.LOCATION%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').length-3)+'no')
	  			if(document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').substring(document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').length-2)=='yes')
	  			{
					document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.CURRENCY%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.CURRENCY%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.CURRENCY%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.LOCATION%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.LOCATION%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.LOCATION%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.getAttribute('validate').length-3)+'no')
				}
	  		}
		}
		else
		{
			    document.getElementById('ifselected').style.display='none';
		  		document.getElementById('probation').style.display ='block';
		  		document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.value='0';
		  		document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.EXPECTEDSALARY%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.CURRENCY%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.LOCATION%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.SALARYREMARKS%>.value='';
		  		document.addFinalStatus.<%=RequestConstants.REMARKS%>.value='';
	  			if(document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').substring(document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').length-2)=='es')
	  			{
					document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.DESIGNATION%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.DATEOFJOINING%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.CURRENTCTC%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.CURRENCY%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.CURRENCY%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.CURRENCY%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.LOCATION%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.LOCATION%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.LOCATION%>.getAttribute('validate').length-3)+'no')
					document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.setAttribute('validate',document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.getAttribute('validate').substring(0,document.addFinalStatus.<%=RequestConstants.PROJECTASSIGNED%>.getAttribute('validate').length-3)+'no')
				}
		}
			
	}
	
	
	function submitThisForm(){
		//if(document.addFinalStatus.<%=RequestConstants.STATUS%>.value == 'Selected'){
			submitForm('addFinalStatus','resume?method=addResumeStatus&resumeId')
			//}
		//else{
			//submitForm('addFinalStatus','resume?method=addResumeStatus&resumeId')
		//}
	}
	document.addFinalStatus.<%=RequestConstants.STATUS%>.focus();
	</script>
