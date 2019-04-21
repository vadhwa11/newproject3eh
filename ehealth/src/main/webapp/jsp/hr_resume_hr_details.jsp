<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page
	import="jkt.hrms.recruitment.masters.business.Resumestatusmaster"%>
<%@page import="jkt.hrms.recruitment.masters.business.Resumehrdetails"%>
<%@page import="jkt.hms.util.RequestConstants"%>

<script type="text/javascript">

</script>

<% 
	   	Map map=(Map)request.getAttribute("map");
	   	Integer resumeId=(Integer)map.get("resumeId");
	  	String name=(String)map.get("name");
	  	List hrDetails=(List)map.get("hrDetails");
	  	Resumehrdetails resumehrDetails=null;
	  	String status =(String) map.get("status");
	  	if(!hrDetails.isEmpty()){
		   resumehrDetails	= (Resumehrdetails)hrDetails.get(0);
		}
	   	List statusMasterList=(List)map.get("statusMasterList");
	  	Iterator statusMasterIterator=statusMasterList.iterator();
	  	session.setAttribute("resumehrDetails",resumehrDetails);
	  %>
<div class="titleBg">
<h2>HR Details</h2>
</div>
<div class="clear"></div>
<form name="addHrDetails" action="" method="post">
<div class="Block"><input type="hidden"
	name="<%=RequestConstants.RESUMEID%>" value="<%=resumeId%>" /> <!--<span><a href="hms/resume?method=showHistory&resumeId=<%= resumeId%>&jspName=hr&candidateName=<%=name%>" class="viewhistory">View History</a></span>
			
			 -->
<div class="clear"></div>
<label>Name</label> <label class="value"><%=name%></label> <label><span>*</span>
Marital Status</label> <select name="<%=RequestConstants.MARITALSTATUS%>"
	onChange="" validate="Marital Status,string,yes">
	<option value="">Select</option>
	<option value="Single">Single</option>
	<option value="Married">Married</option>
</select> <%
				if(resumehrDetails!=null){
			%> <script>
				document.addHrDetails.<%=RequestConstants.MARITALSTATUS%>.value="<%=resumehrDetails.getMaritalStatus()%>";
			</script> <%
				}
			%> <label><span>*</span> Interviewers Name</label> <input type="text"
	name="<%=RequestConstants.INTERVIEWERNAME%>" value=""
	validate="Interviewers Name,alphaAndSpace,yes" maxlength="50" /> <%
				if(resumehrDetails!=null){
			%> <script>
				document.addHrDetails.<%=RequestConstants.INTERVIEWERNAME%>.value="<%=resumehrDetails.getInterviewerName()%>";
			</script> <%
				}
			%>


<div class="clear"></div>
<label><span>*</span> Location Pref.</label> <input type="text"
	name="<%=RequestConstants.LOCATION%>" value=""
	validate="Location Pref.,alphaAndSpace,yes" maxlength="25" /> <%
				if(resumehrDetails!=null){
			%> <script>
				document.addHrDetails.<%=RequestConstants.LOCATION%>.value="<%=resumehrDetails.getLocationPreference()%>";
			</script> <%
				}
			%> <label>Family Details</label> <%
				if(resumehrDetails!=null){
			%> <textarea id="<%=RequestConstants.FAMILYDETAILS%>"
	name="<%=RequestConstants.FAMILYDETAILS%>"
	validate="Family Details,'',no" onkeydown="refreshLength1(this.id,150)"
	onkeyup="refreshLength(this.id,150)"><%=resumehrDetails.getFamilyDetails()%></textarea>

<%
				}else{
			%> <textarea id="<%=RequestConstants.FAMILYDETAILS%>"
	name="<%=RequestConstants.FAMILYDETAILS%>"
	validate="Family Details,'',no" onkeydown="refreshLength1(this.id,150)"
	onkeyup="refreshLength(this.id,150)"></textarea> <%
				}
			%> <label>Current Reporting Structure</label> <%
				if(resumehrDetails!=null){
			%> <textarea id="<%=RequestConstants.CURRENTREPORTING%>"
	name="<%=RequestConstants.CURRENTREPORTING%>"
	validate="Current Reporting Structure,'',no"
	onkeydown="refreshLength1(this.id,150)"
	onkeyup="refreshLength(this.id,150)"><%=resumehrDetails.getReportingStructure()%></textarea>


<%
				}else{
			%> <textarea id="<%=RequestConstants.CURRENTREPORTING%>"
	name="<%=RequestConstants.CURRENTREPORTING%>"
	validate="Current Reporting Structure,'',no"
	onkeydown="refreshLength1(this.id,150)"
	onkeyup="refreshLength(this.id,150)"></textarea> <%
				}
			%> <label>Reasons for leaving present job</label> <%
			if(resumehrDetails!=null){
			%> <textarea id="<%=RequestConstants.REASONOFLEAVING%>"
	name="<%=RequestConstants.REASONOFLEAVING%>"
	validate="Reasons for leaving present job,'',no"
	onkeydown="refreshLength1(this.id,150)"
	onkeyup="refreshLength(this.id,150)"><%=resumehrDetails.getReasonToLeave()%></textarea><br />
<%
			}else{
			%> <textarea id="<%=RequestConstants.REASONOFLEAVING%>"
	name="<%=RequestConstants.REASONOFLEAVING%>"
	validate="Reasons for leaving present job,'',no"
	onkeydown="refreshLength1(this.id,150)"
	onkeyup="refreshLength(this.id,150)"></textarea><br />
<%
				}
			%> <label>Overall Assessment & Remarks</label> <%
				if(resumehrDetails!=null){
			%> <textarea id="<%=RequestConstants.OVERALLASSESSMENT%>"
	name="<%=RequestConstants.OVERALLASSESSMENT%>"
	validate="Overall Assessment & Remarks,remarks,no"
	onkeydown="refreshLength1(this.id,150)"
	onkeyup="refreshLength(this.id,150)"><%=resumehrDetails.getOverallAssesment()%></textarea>
<%
				}else{
			%> <textarea id="<%=RequestConstants.OVERALLASSESSMENT%>"
	name="<%=RequestConstants.OVERALLASSESSMENT%>"
	validate="Overall Assessment & Remarks,remarks,no"
	onkeydown="refreshLength1(this.id,150)"
	onkeyup="refreshLength(this.id,150)"></textarea> <%}
			String disable = "";
			if("HR Selected".equalsIgnoreCase(status))
			{
				disable="disabled";
			} %> <label><span>*</span> HR Ratings</label> <select
	name="<%=RequestConstants.HRRATING%>" onChange=""
	validate="HR Rating,string,yes">
	<option value="">Select</option>
	<option value="Excellent">Excellent</option>
	<option value="Very Good">Very Good</option>
	<option value="Good">Good</option>
	<option value="Satisfactory">Satisfactory</option>
	<option value="Poor">Poor</option>
</select> <%
				if(resumehrDetails!=null){
			%> <script>
				document.addHrDetails.<%=RequestConstants.HRRATING%>.value="<%=resumehrDetails.getHrRatings()%>";
			</script> <%
				}
			%>
<div class="clear"></div>
<label><span>*</span> Result</label> <select id="recomend"
	name="<%=RequestConstants.RECOMENDED%>"
	onChange="changeDirectorApproval()" validate="Result,string,yes"
	<%=disable%>>
	<option value="">Select</option>
	<option value="Selected">Selected</option>
	<option value="On Hold">On Hold</option>
	<option value="Rejected">Rejected</option>
</select> <%if(resumehrDetails!=null)
				{%> <script>
						document.addHrDetails.<%=RequestConstants.RECOMENDED%>.value="<%=resumehrDetails.getRecommended()%>";
					</script> <%}%>
<div class="clear"></div>
</div>


<%if(! "HR Selected".equalsIgnoreCase(status))
			{%> <input type="button" name="<%=RequestConstants.ADD%>" value="Add"
	class="button"
	onClick="submitForm('addHrDetails','resume?method=addHRDetails')" /><br />
<br />
<%}%> <input type="button" name="back" value="Back" class="button"
	onClick="history.back()"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>



<script>
	  document.addHrDetails.<%=RequestConstants.MARITALSTATUS%>.focus();
	  changeDirectorApproval();
	  function changeDirectorApproval()
	  {
	  	if(document.addHrDetails.<%=RequestConstants.RECOMENDED%>.value=="yes")
	  	{
	  		document.getElementById('direct1').style.display = "block";
	  	}
	  	else
	  	{
	  		document.getElementById('direct1').style.display = "none";
	  	}
	  }
	  
	 <%
	if(resumehrDetails !=null && resumehrDetails.getResumepersonaldetails().getResumeStatus().getResumestatusmaster().getId() > 9 )
 	{
	%>
	disablefields('input');
	disablefields('select');
	disablefields('textarea');
	hideObjects('img');
	hideObjects('span');
 	<%
 	}
 	%>	
 	</script>