<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Iterator"%>
<%@page
	import="jkt.hrms.recruitment.masters.business.Resumestatusmaster"%>
<%@page import="jkt.hrms.recruitment.masters.business.Resumetechnical"%>
<%@page import="jkt.hms.util.RequestConstants"%>

<script type="text/javascript">
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
	  	Resumetechnical technicalDetails=null;
	 	Integer resumeId=(Integer)map.get("resumeId");
		String name=(String)map.get("name");
		List statusMasterList=(List)map.get("statusMasterList");
	  	Iterator statusMasterIterator=statusMasterList.iterator();
	  	List technicalDetailsList=(List)map.get("techDetailsList");
	  	String status = (String)map.get("status");
	  	if(!technicalDetailsList.isEmpty()){
	  	  	technicalDetails=(Resumetechnical)technicalDetailsList.get(0);
		}
	  	map.put("technicalDetails",technicalDetails);
	  	session.setAttribute("map",map);
%>
<form name="addTechDetails" action="" method="post"
	enctype="multipart/form-data">
<div class="titleBg">
<h2>Technical/Functional Evaluation</h2>
</div>
<div class="clear"></div>
<input type="hidden" name="<%=RequestConstants.RESUMEID%>"
	value="<%=resumeId%>" />
<div class="Block"><!--  <h4><a href="/hms/hrms/resume?method=showHistory&resumeId=<%= resumeId%>&jspName=technical&candidateName=<%=name%>" class="viewhistory">View History</a></h4>-->
<div class="clear"></div>

<label>Name</label> <input type="text" value='<%=name%>' name="Name" />

<label><span>*</span> Interviewer Name</label> <input type="text"
	name="<%=RequestConstants.INTERVIEWERNAME%>" value=""
	validate="Interviewer Name,fullName,yes" maxlength="20" /> <script>
document.addTechDetails.<%=RequestConstants.INTERVIEWERNAME%>.focus();
</script> <label><span>*</span> Relevant Exp.</label> <select
	name="<%=RequestConstants.YEARS%>"
	validate="Relevant Exp. in Years,string,yes" class="smallest">
	<option value="">--</option>
	<%	for(int i=0;i<=30;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
	<option value="31">+30</option>
</select> <label class="smallAuto">Yrs</label> <select
	name="<%=RequestConstants.MONTHS%>"
	validate="Relevant Exp. in Months,string,yes" class="smallest">
	<option value="">--</option>
	<%for(int i=0;i<=11;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="smallAuto">Months</label>

<div class="clear"></div>

<label><span>*</span> Date of Interview</label> <input type="text"
	name="<%=RequestConstants.DATEOFINTERVIEW%>" value=""
	validate="Date of Interview,dateOfInteview,yes" class="date"
	tabindex="500" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('',document.addTechDetails.<%=RequestConstants.DATEOFINTERVIEW%>,event)" />


<label><span>*</span> Technical Knowledge</label> <select
	name="<%=RequestConstants.TECHSTATUS%>" onChange=""
	validate="Technical knowledge,string,yes">
	<option value="">Select</option>
	<option value="Excellent">Excellent</option>
	<option value="Very Good">Very Good</option>
	<option value="Good">Good</option>
	<option value="Satisfactory">Satisfactory</option>
	<option value="Poor">Poor</option>
</select> <label>Strengths(Technical / Functional)</label> <%
if(technicalDetails!=null){
%> <textarea id="strength" name="<%=RequestConstants.STRENGTHS%>"
	validate="Strengths,'',no" onkeydown="refreshLength1(this.id,200)"
	onkeyup="refreshLength(this.id,200)" maxlength="1500"><%=technicalDetails.getMajorStrength()%></textarea>
<%
}else{
%> <textarea id="strength" name="<%=RequestConstants.STRENGTHS%>"
	validate="Strengths,'',no" onkeydown="refreshLength1(this.id,200)"
	onkeyup="refreshLength(this.id,200)" maxlength="1500"></textarea> <%
}
%>

<div class="clear"></div>



<label>Weakness(Technical / Functional)</label> <%
if(technicalDetails!=null){
%> <textarea id="weakness" name="<%=RequestConstants.WEAKNESS%>"
	validate="Weakness,'',no" onkeydown="refreshLength1(this.id,200)"
	onkeyup="refreshLength(this.id,200)" maxlength="1500"><%=technicalDetails.getMajorWeakness()%></textarea>

<%
}else{
%> <textarea id="weakness" name="<%=RequestConstants.WEAKNESS%>"
	validate="Weakness,'',no" onkeydown="refreshLength1(this.id,200)"
	onkeyup="refreshLength(this.id,200)" maxlength="1500"></textarea> <%
}
%> <label>Any special area probed</label> <%if(technicalDetails!=null){%>
<textarea id="areaprobed" name="<%=RequestConstants.AREAPROBED%>"
	validate="Special Area Probed,'',no"
	onkeydown="refreshLength1(this.id,200)"
	onkeyup="refreshLength(this.id,200)"><%=technicalDetails.getAreaProbed()%></textarea>
<%}else{%> <textarea id="areaprobed"
	name="<%=RequestConstants.AREAPROBED%>"
	validate="Special Area Probed,'',no"
	onkeydown="refreshLength1(this.id,200)"
	onkeyup="refreshLength(this.id,200)" maxlength="1500"></textarea> <%}%> <label><span>*</span>
Result of Interview</label> <select id="stat"
	name="<%=RequestConstants.RESULT%>"
	onChange="showReasonHold(this.value);"
	validate="Result of Interview,string,yes">
	<option value="">Select</option>
	<option value="Tech Selected"
		<% if(technicalDetails!=null && technicalDetails.getStatus().equals("Tech Selected")){%>
		selected <%}%>>Recommended</option>
	<option value="Tech On Hold"
		<% if(technicalDetails!=null && technicalDetails.getStatus().equals("Tech On Hold")){%>
		selected <%}%>>Put - OnHold</option>
	<option value="Tech Rejected"
		<% if(technicalDetails!=null && technicalDetails.getStatus().equals("Tech Rejected")){%>
		selected <%}%>>Rejected</option>
</select>

<div class="clear"></div>

<div id="ifselected" style="display: none;"><label><span>*</span>
Reason</label> <textarea id="reasononhold" name="<%=RequestConstants.REASON%>"
	validate="Reason,remarks,no" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)"
	onkeydown="refreshLength1(this.id)" onkeyup="refreshLength(this.id)"
	maxlength="1500"></textarea></div>
<div class="clear"></div>

<%if(technicalDetails == null || !(technicalDetails.getResumepersonaldetails().getResumeStatus().getResumestatusmaster().getId() >6)){ %>
<label><span>*</span> Upload Evaluation Sheet<br />
(max. size 2MB)</label> <input type="file" name="<%=RequestConstants.UPLOAD%>"
	class="browse" validate="Upload Resume,'',yes" />
<div class="clear"></div>
<div class="clear"></div>
<label>Observer1:</label> <input type="text"
	name="<%=RequestConstants.OBSERVER1%>" validate="Observer1,string,no"
	value="" maxlength="45" /> <label>Observer2:</label> <input
	type="text" name="<%=RequestConstants.OBSERVER2%>"
	validate="Observer2,string,no" value="" maxlength="45" /> <label>Observer3:</label>
<input type="text" name="<%=RequestConstants.OBSERVER3%>"
	validate="Observer3,string,no" value="" maxlength="45" />
<div class="clear"></div>
<%}%>
</div>
<script type="text/javascript">
if(document.addTechDetails.<%=RequestConstants.RESULT%>.value=="OnHold"){
document.addTechDetails.<%=RequestConstants.REASON%>.setAttribute('validate', document.addTechDetails.<%=RequestConstants.REASON%>.getAttribute('validate').substring(0,document.addTechDetails.<%=RequestConstants.REASON%>.getAttribute('validate').length-2)+"yes");
      	document.getElementById('ifselected').style.display='block';
}
</script> <%  if(technicalDetails!=null){ %> <script>
document.addTechDetails.<%=RequestConstants.INTERVIEWERNAME%>.value="<%=technicalDetails.getInterviewerName()%>";
document.addTechDetails.<%=RequestConstants.DATEOFINTERVIEW%>.value="<%=technicalDetails.getDateOfInterview()%>";
document.addTechDetails.<%=RequestConstants.TECHSTATUS%>.value="<%=technicalDetails.getTechnicalKnowledge()%>";
document.addTechDetails.<%=RequestConstants.EXPERIENCE%>.value="<%=technicalDetails.getRelevantExperience()%>";
document.addTechDetails.<%=RequestConstants.RESULT%>.value="<%=technicalDetails.getStatus()%>";
if(document.addTechDetails.<%=RequestConstants.RESULT%>.value=="OnHold"){
document.addTechDetails.<%=RequestConstants.REASON%>.value="<%=technicalDetails.getReasonHold()%>";
}
</script>

<div class="clear"></div>
<%  }  %> <%if((technicalDetails == null) || !( technicalDetails.getResumepersonaldetails().getResumeStatus().getResumestatusmaster().getId()>6))
{%> <input type="button" name="<%=RequestConstants.ADD%>" value="Add"
	class="button"
	onClick="submitForm('addTechDetails','resume?method=addTechDetails&'+csrfTokenName+'='+csrfTokenValue)" />
<%}
else
{%> <script>
document.getElementById('stat').disabled=true;
</script> <%}
%> <input type="button" name="back" value="Back" class="button"
	onClick="history.back()" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
function showReasonHold(strValue){
	if( strValue == 'Tech On Hold' || strValue == 'Tech Rejected'){
		document.getElementById('ifselected').style.display='block'; 
		document.addTechDetails.<%=RequestConstants.REASON%>.focus();
if(document.addTechDetails.<%=RequestConstants.REASON%>.getAttribute('validate').substring(document.addTechDetails.<%=RequestConstants.REASON%>.getAttribute('validate').length-2) == "no")
document.addTechDetails.<%=RequestConstants.REASON%>.setAttribute('validate', document.addTechDetails.<%=RequestConstants.REASON%>.getAttribute('validate').substring(0,document.addTechDetails.<%=RequestConstants.REASON%>.getAttribute('validate').length-2)+"yes");
}
else{
	document.getElementById('ifselected').style.display='none';
	document.addTechDetails.<%=RequestConstants.REASON%>.value='';
if(document.addTechDetails.<%=RequestConstants.REASON%>.getAttribute('validate').substring(document.addTechDetails.<%=RequestConstants.REASON%>.getAttribute('validate').length-3) == "yes")
document.addTechDetails.<%=RequestConstants.REASON%>.setAttribute('validate',document.addTechDetails.<%=RequestConstants.REASON%>.getAttribute('validate').substring(0,document.addTechDetails.<%=RequestConstants.REASON%>.getAttribute('validate').length-3)+"no");
	}
}
function clearValues()
{
document.addTechDetails.<%=RequestConstants.STRENGTHS%>.value="";
document.addTechDetails.<%=RequestConstants.WEAKNESS%>.value="";
document.addTechDetails.<%=RequestConstants.AREAPROBED%>.value="";
}


 
 <%if(technicalDetails !=null && technicalDetails.getResumepersonaldetails().getResumeStatus().getResumestatusmaster().getId()>6)
 {%>
	disablefields('input');
	disablefields('select');
	disablefields('textarea');
	hideObjects('img');
	hideObjects('span');
 <%}
 %>	
	
 </script>
