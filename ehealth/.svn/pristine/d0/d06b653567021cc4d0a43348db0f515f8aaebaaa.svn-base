<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Calendar"%>
<%@include file="hr_verify_resume.jsp"%>
<%String passportNumber=(String)map.get("passportNumber");
List<MasQualification> qualificationList = new ArrayList();
if(map.get("qualificationList")!=null)
{
	qualificationList = (List)map.get("qualificationList");
}

List<MasDepartment> departmentList = new ArrayList();
if(map.get("departmentList")!=null)
{
	departmentList = (List)map.get("departmentList");
}


List<MasRank> designationList = new ArrayList();
if(map.get("designationList")!=null)
{
	designationList = (List)map.get("designationList");
}
List<MasTitle> titleList = new ArrayList();
if(map.get("titleList")!=null)
{
	titleList = (List)map.get("titleList");
}
%>

<script language="javascript">
function changeCountry1(val,formName)
{
obj = eval("document."+formName+".state");

if(val=="India"){
document.getElementById('statediv').innerHTML = '<SELECT NAME="state" id="state" onChange="populateCity(this.selectedIndex)" validate="State,string,yes" class="select1"></SELECT>';
populateCombo("state", state, formName);
obj.value = "Delhi";
document.getElementById('citydiv').innerHTML = '<select id="city" name="city" onChange="changeCity(this)" validate="City,string,yes" class="select1"></select>'
populateCity(9);
}
else{
document.getElementById('statediv').innerHTML = '<input type="text" name="state" id="state" value="" validate="State,alphaspace,yes" maxlength="30"/>'
document.getElementById('citydiv').innerHTML =  '<input type="text" name="city"  id="city" value="" validate="City,alphaspace,yes" maxlength="30"/>'
}	

document.getElementById('othercity').style.display = 'none';
}
function enablePassport()
{
<% if(passportNumber!=null && !passportNumber.equalsIgnoreCase(""))
{
%>	 

document.getElementById('passNo').readonly=true;
document.getElementById('passStatus').value="Yes";
document.getElementById('pass1').style.display = 'block';
<%}%>
}

function changeProject()
{
document.getElementById("othersprojectlabel").style.visibility = "hidden";
document.getElementById("othersprojecttext").style.visibility = "hidden";
document.getElementById("othersprojecttext").value = "";
var projinc=0;
var du = document.getElementById('du');
var project = document.getElementById('project');
var j=0;
for(var i=project.options.length-1;i>=0;i--)
{
project.remove(i);
}
<%
for(Resumeprojectsdetail proj : projectDetails)
{	
%>	
if(<%=(proj.getDu()).getId()%>==du.value)
{
project.options[projinc]=new Option('<%=proj.getProjectName()%>','<%=proj.getId()%>', false, false);
projinc++;
}
<%}%>
if(du.value!="")
project.options[projinc]=new Option('Others',0, false, false);
else
project.options[projinc]=new Option('Please select DU',"", false, false);	
}
</script>
<% 
if(errorString.equalsIgnoreCase("Verified"))
{
	String firstName=(String)map.get("firstName");
	String lastName=(String)map.get("lastName");
	String emailId=(String)map.get("emailId");
	String dateOfBirth = (String)map.get("dateOfBirth");
	String resumeThrough = (String)map.get("resumeThrough");
	String currentEmployer =(String)map.get("currentEmployer");
	String previousEmployer=(String)map.get("previousEmployer");
	String nameOfSource=(String)map.get(RequestConstants.NAMEOFSOURCE);
	
	if(nameOfSource == null){
		nameOfSource ="" ;  		
	}
	String labelNameForSource = "";
	if(resumeThrough.equalsIgnoreCase("Placement Consultancy")){
		labelNameForSource = "Placement Consultancy";
			}
	if(resumeThrough.equalsIgnoreCase("Internal Reference")){
		labelNameForSource = "Name of Reference";
		}
	if(resumeThrough.equalsIgnoreCase("Job Portal")){
		labelNameForSource = "Job Portal Name";
		}
	

%>
<form name="addresume" method="post" enctype="multipart/form-data">
<div class="Block">
<%if((resumeThrough.equalsIgnoreCase("Direct")) || ( resumeThrough.equalsIgnoreCase("Advertisement")))
		{ 
		}
		else
		{%> 
<label><span>* </span> <%=labelNameForSource %></label> 
<input	type="text" name="<%=RequestConstants.NAMEOFSOURCE%>"	value="<%=nameOfSource%>" validate="<%=labelNameForSource %>,char,yes"	maxlength="50" enabled="true" />
<div class="clear"></div>
<%} %> <label><span>*</span> Title</label> 
<select	name="<%=RequestConstants.TITLE%>" validate="Title,int,yes">
	<option value='0'>Select</option>
	<%for(MasTitle title : titleList){ %>
	<option value="<%=title.getId() %>"><%=title.getTitleName() %></option>
	<%} %>
</select> <label>First Name</label> <input type='text' readonly="readonly"
	class="readOnly" name="<%=RequestConstants.FIRSTNAME%>"
	value='<%=firstName%>' validate="First Name,char,no" maxlength="15" />

<label>Middle Name</label> <input type="text"
	name="<%=RequestConstants.MIDNAME%>" value=""
	validate="Middle Name,char,no" maxlength="25" />
<div class="clear"></div>
<label>Last Name</label> <input type="text"
	name="<%=RequestConstants.LASTNAME%>" readonly="readonly"
	class="readOnly" value='<%=lastName%>' validate="Last Name,char,no"
	maxlength="15" /> <label>Date of Birth</label> <input type="text"
	id="dob" readonly="readonly" class="readOnly"
	name="<%=RequestConstants.DATEOFBIRTH%>" value='<%=dateOfBirth %>'
	validate="Date Of Birth,char,no" maxlength="25" /> <label>Email
Id</label> <input type="text" name="<%=RequestConstants.EMAIL%>"
	readonly="readonly" class="readOnly" value='<%=emailId%>'
	validate="Email Id,char,no" maxlength="50" />
<div class="clear"></div>
<%String otherCity = "";
			  
%>
<h4><u>Address</u></h4>
<div class="clear"></div>
<label>Line 1</label> <input type="text"
	name="<%=RequestConstants.ADDRESSLINE1 %>" maxlength="40"
	validate="Address Line 1,'string',no" /> <label>Line 2</label> <input
	type="text" name="<%=RequestConstants.ADDRESSLINE2 %>" maxlength="40"
	validate="Address Line 2,'string',no" /> <label>Line 3</label> <input
	type="text" name="<%=RequestConstants.ADDRESSLINE3 %>" maxlength="40"
	validate="Address Line 3,'string',no" />

<div class="clear"></div>
<%--<%@include file="hr_address1.jsp"%>--%>
<jsp:include page="hr_address1.jsp"></jsp:include>
<div class="clear"></div>



<label>Contact No.</label> <input type="text"
	name="<%=RequestConstants.HOMEPHONE%>" value=""
	validate="Contact No,phone,no" maxlength="11" /> <label>Mobile
No.</label> <input type="text" name="<%=RequestConstants.MOBILEPHONE%>" value=""
	validate="Mobile,mobilephone,no" maxlength="12" /> <label>Other
Contact No.</label> <input type="text" name="<%=RequestConstants.OTHERPHONE%>"
	value="" validate="Other Phone,phone,no" maxlength="11" />
<div class="clear"></div>


<div class="clear"></div>

<label><span>*</span> Highest Degree</label> <select
	name="<%=RequestConstants.EDUCATION%>"
	validate="Highest Degree,string,yes">
	<option value="">Select</option>
	<%for(MasQualification qualification : qualificationList){ %>
	<option value="<%=qualification.getQualificationName() %>"><%=qualification.getQualificationName() %></option>
	<%} %>
</select> <label>Year of Passing</label> <select
	name=<%=RequestConstants.YEARPASSING%>>
	<option value="">Select</option>
	<%	int yearPassed=year;
while(yearPassed>= (year-100))
{%>
	<option value="<%=yearPassed%>"><%=yearPassed%></option>
	<%yearPassed--;
}%>
</select>
<div class="clear"></div>

<label>University</label> <input type="text"
	name="<%=RequestConstants.UNIVERSITY%>" value=""
	validate="University,alphaspace,no" maxlength="50" /> <label>Expertise</label>
<input type="text" name="<%=RequestConstants.DOMAIN%>" value=""
	validate="Expertise,alphaspace,no" maxlength="50" /> <label><span>*</span>
Experience</label> <select name="<%=RequestConstants.YEARS%>"
	validate="Exp years,string,yes" class="smallest">
	<option value="">--</option>
	<%	for(int i=0;i<=30;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
	<option value="31">+30</option>
</select> <label class="smallAuto">Yrs</label> <select
	name="<%=RequestConstants.MONTHS%>" validate="Exp months,string,yes"
	class="smallest">
	<option value="">--</option>
	<%for(int i=0;i<=11;i++){%>
	<option value="<%=i%>"><%=i%></option>
	<%}%>
</select> <label class="smallAuto">Mths</label>

<div class="clear"></div>

<label>Role/Designation</label> <select
	name="<%=RequestConstants.JOBPROFILE %>">
	<option value="">Select</option>
	<%for(MasRank profile: designationList)
{ %>
	<option value="<%=profile.getId()%>"><%=profile.getRankName()%></option>
	<%}%>
</select> <label>Current Employer</label> <input type="text"
	name="<%=RequestConstants.CURRENTEMPLOYER%>" readonly="readonly"
	class="readOnly" value="<%=currentEmployer%>"
	validate="Current Employer Name,resumeCompany,no" maxlength="50" /> <label>Previous
Employer</label> <%
	if(!previousEmployer.equals(""))
	{%> <input type="text" name="<%=RequestConstants.PREVIOUSEMPLOYER%>"
	readonly="readonly" class="readOnly" value="<%=previousEmployer%>"
	validate="Previous Employer Name,resumeCompany,no" maxlength="50" /> <%}else
	{%> <input type="text" name="<%=RequestConstants.PREVIOUSEMPLOYER%>"
	value="<%=previousEmployer%>"
	validate="Previous Employer Name,resumeCompany,no" maxlength="50" /> <%
	}
	%>
<div class="clear"></div>

<label>Current/Last CTC</label> <input type="text"
	name="<%=RequestConstants.CURRENTCTC%>" value=""
	validate="Current CTC,num,no" maxlength="10" /> <label>Expected
CTC</label> <input type="text" name="<%=RequestConstants.EXPECTEDSALARY%>"
	value="" validate="Expected CTC,num,no" maxlength="10" /> <label>Current/Last
Designation</label> <input type="text" name="<%=RequestConstants.CURRENTROLE%>"
	value="" validate="Current Designation,string,no" maxlength="40" />

<div class="clear"></div>

<label>Salary Remarks</label> <input type="text"
	name="<%=RequestConstants.SALARYREMARKS%>" value="" maxlength="40" />
<label>Department</label> <select id="du"
	name="<%=RequestConstants.DU_ID%>">
	<option value="">Select</option>
	<%for(MasDepartment dept:departmentList)
{	%>
	<option value="<%=dept.getId()%>"><%=dept.getDepartmentName()%></option>
	<%  } %>
</select> <label>Joining Time</label> <input type="text"
	name="<%=RequestConstants.JOININGTIME%>" value=""
	validate="Joining Time,num,no" maxlength="3" class="date" /> <label
	class="smallAuto">days</label>
<div class="clear"></div>


<%--
<label>Project Name</label>
<select id="project" name="<%=RequestConstants.PROJECT_ID%>" size="3" validate="Project Name,string,no" class="list" onclick="showOthers()">
<option value="">Select</option>
<%for(MstrProject project : projectList){ %>
<option value="<%=project.getId() %>"><%=project.getPrjName() %></option>
<%} %>
</select>
 --%> <label id="othersprojectlabel" style="visibility: hidden;">Others</label>
<input type="text" id="othersprojecttext" style="visibility: hidden;"
	name="<%=RequestConstants.OTHERPROJECT%>" value=""
	validate="Project Name, string,no" maxlength="90" /> <label><span>*</span>
Passport </label> <select id="passStatus"
	name="<%=RequestConstants.PASSPORTSTATUS %>"
	onchange="changePassport()">
	<option value="Yes">Yes</option>
	<option value="No" selected="selected">No</option>
	<option value="Details Not Available">Details Not Avaliable</option>
</select>

<div class="clear"></div>

<label>Onsite Availability</label> <label class="value"> <input
	type="checkbox" id="onsiteavb" class="radioCheck"
	name="<%=RequestConstants.ONSITEAVAILABILITY%>" /></label>

<div id="pass1" style="display: none"><label><span>*</span>
Passport Number</label> <input id="passNo" type="text"
	name="<%=RequestConstants.PASSPORTNUMBER%>"
	validate="Passport No,passport,no" value="<%=passportNumber %>"
	maxlength="8" /> <label><span>*</span> Passport Expiry Date</label> <input
	id="passDate" type="text"
	name="<%=RequestConstants.PASSPORTEXPIRYDATE%>" value="" tabindex="500"
	class="date" readonly /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('',document.addresume.<%=RequestConstants.PASSPORTEXPIRYDATE%>,event)" />

<div class="clear"></div>

<label>Visa Remarks</label> <textarea id="visa"
	name="<%=RequestConstants.VISAREMARKS%>"
	validate="Visa Remarks,remarks,no"
	onkeydown="refreshLength1('visa',250)"
	onkeyup="refreshLength('visa',250)"></textarea></div>

<%
if(passportNumber!= null && !passportNumber.equalsIgnoreCase(""))
{
%> <script>
enablePassport();
</script> <%		
}
%> <label><span>*</span> Primary Skills</label> <select
	id="primarySkills" name="<%=RequestConstants.PRIMARYSKILLS%>" size="6"
	validate="Primary Skills,string,yes" multiple onclick='changePrimary()'
	onchange='changePrimary()' class="list">
	<%for(Resumeskillmaster skillMaster: skillMasterList)
{
if(skillMaster.getSkillParent()==0){%>
	<option value="<%=skillMaster.getId()%>"><%=skillMaster.getSkillDesc()%></option>
	<%}
}%>
</select> <label>Secondary Skills</label> <select id="secondarySkills"
	name="<%=RequestConstants.SECONDARYSKILLS%>" size="6"
	validate="Secondary Skills,string,no" multiple class="list">
	<option value="">Please select primary skill</option>
</select>

<div class="clear"></div>
<!--<label>Resume Through </label>
<label class="value" name="<%=RequestConstants.RESUMETHROUGH%>" ><%=resumeThrough %></label>
<input type="text" name="<%=RequestConstants.RESUMETHROUGH%>" value="<%=resumeThrough %>" validate="Resume Through,char,yes" maxlength="50" />-->

<!-- <%if(resumeThrough.equals("Internal Reference")){%>
<label><span>*</span> Employee Name</label>
<input type="text" name="<%=RequestConstants.REFERENCEBY%>" value="" validate="Employee Name,fullName,yes" maxlength="50" />
<%} %> --> <label><span>*</span> Remarks</label> <textarea
	id="rootcause" name="<%=RequestConstants.REMARKS%>"
	validate="Remarks,remarks,yes"
	onkeydown="refreshLength1('rootcause',250)"
	onkeyup="refreshLength('rootcause',250)"></textarea> <label><span>*</span>
Upload Resume<br />
(max. size 2MB)</label> <input type="file" name="<%=RequestConstants.UPLOAD%>"
	class="browse" validate="Upload Resume,'',yes" />


<div class="clear"></div>



</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="<%=RequestConstants.ADD%>" value="Add" class="button" onClick="addResume()" /> 
<input type="reset"	name="<%=RequestConstants.RESET%>" value="Reset" class="buttonHighlight" onClick="resetForm()" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<%}	%>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script>
function resetForm(){
var secondary = document.getElementById('secondarySkills');
var projects = document.getElementById('project');
var j=0;

populateCombo("country", country, "addresume");
document.addresume.country.value = "India";
changeCountry1(document.addresume.country.value,'addresume');
changeCity(document.addresume.state)

for(var i=secondary.options.length-1;i>=0;i--)
{
secondary.remove(i);
}
secondary.options[0]=new Option('Please select primary skill','', false, false);

for(var i=projects.options.length-1;i>=0;i--)
{
projects.remove(i);
}
projects.options[0]=new Option('Please Select DU','', false, false);

document.addresume.<%=RequestConstants.PASSPORTSTATUS %>.value =='No'
document.getElementById('passNo').value='';
document.getElementById('passDate').value='';

document.getElementById('pass1').style.display = 'none';
document.getElementById('visa').style.display = 'none';
alert('in reset Form');
resetForm1();
}

function disableField(obj) {
if (obj.value == "") {
document.addresume.<%=RequestConstants.VISAREMARKS%>.value="";
document.addresume.<%=RequestConstants.VISAREMARKS%>.disabled = true;
}
else {
visaSelect[visaSelect.length]=obj.value;
document.addresume.<%=RequestConstants.VISAREMARKS%>.disabled = false;
document.addresume.<%=RequestConstants.VISAREMARKS%>.focus();
}
}

function changePassport()
{
if(document.addresume.<%=RequestConstants.PASSPORTSTATUS %>.value =='Yes')
{
document.getElementById('pass1').style.display = 'block';
document.getElementById('visa').style.display = 'block';
}
else if(document.addresume.<%=RequestConstants.PASSPORTSTATUS %>.value =='No')
{
document.getElementById('passNo').value='';
document.getElementById('passDate').value='';
document.getElementById('visa').value='';

document.getElementById('pass1').style.display = 'none';
document.getElementById('visa').style.display = 'none';
}
else
{
document.getElementById('passNo').value='';
document.getElementById('passDate').value='';
document.getElementById('visa').value = '';
document.getElementById('pass1').style.display = 'none';
document.getElementById('visa').style.display = 'none';
}
}



function changePrimary()
{
var primary = document.getElementById('primarySkills');
var secondary = document.getElementById('secondarySkills');
var j=0;
for(var i=secondary.options.length-1;i>=0;i--)
{
secondary.remove(i);
}
for(var i=0;i<primary.options.length;i++)
{
if(primary.options[i].selected)
{
<%for(Resumeskillmaster skillmaster: skillMasterList)
{%>
if(primary.options[i].value==<%=skillmaster.getSkillParent()%>)
{
secondary.options[j]=new Option(' <%=skillmaster.getSkillDesc()%>','<%=skillmaster.getId()%>', false, false);
j=j+1;
}
<%}%>
}
}
}

function checkPass()
{
var isValid1 = true;
if(document.addresume.<%=RequestConstants.PASSPORTSTATUS %>.value =='Yes')
{
if(document.addresume.<%=RequestConstants.PASSPORTNUMBER %>.value == ''){
errorMsg += "Passport Number Not selected\n";
isValid1 = false;
}
if(document.addresume.<%=RequestConstants.PASSPORTEXPIRYDATE %>.value.length == 0){
errorMsg += "Passport Date Not Selected\n";
isValid1 = false;
}
if(!isValid1)
{
return false;
}
return true;
}
return true;
}

function addResume()
{
var check=false;
var errorMessage="";
var skillCheck=false;
var ctcCheck = false;

var expectedCTC=parseInt(document.addresume.<%=RequestConstants.EXPECTEDSALARY%>.value);
var currentCTC=parseInt(document.addresume.<%=RequestConstants.CURRENTCTC%>.value);

if(currentCTC == "" || expectedCTC ==""){
ctcCheck=true;         
}
else if(currentCTC > expectedCTC ){
errorMessage+='Current CTC cannot be greater than Expected CTC \n';
ctcCheck=false;
}
else{
ctcCheck=true;
}

var primarySkills=document.addresume.<%=RequestConstants.PRIMARYSKILLS%>;
var selectedPrimarySkills=new Array();
var p=0;
if(primarySkills.length>0)
{
for(var a=0;a<primarySkills.length;a++)
{	
var flag=primarySkills.options[a].selected;
if(flag)
{
selectedPrimarySkills[p]=primarySkills.options[a].value;
p++;
}
}
}

var secondarySkills=document.addresume.<%=RequestConstants.SECONDARYSKILLS%>;
var selectedSecondarySkills=new Array();
var skillAlReadySelected=new Array();
var m=0;

if(secondarySkills.length>0)
{
for(var a=0;a<secondarySkills.length;a++)
{	
var flag=secondarySkills.options[a].selected;
if(flag)
{
selectedSecondarySkills[m]=secondarySkills.options[a].value;
m++;
}
}
var n=0;
for(var common=0;common<selectedSecondarySkills.length;common++)
{
for(var nappy=0;nappy<selectedPrimarySkills.length;nappy++)
{
if(selectedSecondarySkills[common]==selectedPrimarySkills[nappy])
{
skillAlReadySelected[n]=selectedSecondarySkills[common];
n++;
}
}
}
}
if(skillAlReadySelected.length>0)
{
errorMessage+='Selected Primary and Secondary Skills should not be same';
skillCheck=false;
}
else
skillCheck=true;

if(skillCheck && ctcCheck){
submitForm('addresume','/hms/hrms/resume?method=addResume&'+csrfTokenName+'='+csrfTokenValue,'chkPassingYear','checkPass','fileName');
}else
{
alert(errorMessage);	
}
}	

var str="";
function checkUpLength(obj)
{
var len = obj.value.length;
if(len>1500)
{
obj.value = str;
}
len = obj.value.length;
}

function checkDownLength(obj)
{
var len = obj.value.length;
if(len<=1500)
{
str=obj.value;
}
checkUpLength(obj);
}

function checkTextAreaLength(str, varlength,name) {
if (str.length >= varlength) {
alert("Total number of characters in " + name + " exceeded maximum allowed length (" + varlength + ")");
return false;
}
}

function showOthers()
{
if(document.getElementById('project').value!="" && document.getElementById('project').value==0)
{
document.getElementById("othersprojectlabel").style.visibility = "visible";
document.getElementById("othersprojecttext").style.visibility = "visible";
}
else
{
document.getElementById("othersprojectlabel").style.visibility = "hidden";
document.getElementById("othersprojecttext").style.visibility = "hidden";
document.getElementById("othersprojecttext").value = "";
}

}
function onsite()
{
var onsiteav = document.getElementById('onsiteavb');
if(onsiteav.checked)
{
document.getElementById('onsiteavb').value=true;
alert("true");
}
else
{
document.getElementById('onsiteavb').value=false;
alert("false");
}

}



	function resetForm1()
		{
		document.getElementById('rootcauselen2').style.display='none';
		document.getElementById('rootcauselen1').innerHTML = '(500 Characters left)';
		document.addresume.reset();
		}
	
	

</script>

