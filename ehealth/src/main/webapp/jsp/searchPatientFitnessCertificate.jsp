
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.HrTrainingService"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="jkt.hms.masters.business.HrPatientFitnessCertificate"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="../jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">

var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
</script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript">
	<%

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}
	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
    Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String entryNo ="MS/VBCH/CERT/";
	String message="";
	String userName="";
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<HrPatientFitnessCertificate> hrPatientFitnessCertificateList=new ArrayList<HrPatientFitnessCertificate>();
	if(map.get("hrPatientFitnessCertificateList")!=null)
	{
		hrPatientFitnessCertificateList = (List<HrPatientFitnessCertificate>)map.get("hrPatientFitnessCertificateList");
	}
	
	List<HrPatientFitnessCertificate> hrPatientFitnessCertificateFulList=new ArrayList<HrPatientFitnessCertificate>();
	if(map.get("hrPatientFitnessCertificateList")!=null)
	{
		hrPatientFitnessCertificateFulList = (List<HrPatientFitnessCertificate>)map.get("hrPatientFitnessCertificateFulList");
	}
	
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("titleList")!=null)
	{
		titleList = (List<MasTitle>)map.get("titleList");
	}
	if(map.get("employeeList")!=null)
	{
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("departmentList")!=null)
	{
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	int counter=1;
	if(map.get("counter")!=null)
	{
		counter = (Integer)map.get("counter");
	}
	if(counter>0)
	{
		entryNo = entryNo+counter;
	}

if(map.get("message") != null){
		   message = (String)map.get("message");
		   %>
		   
		    <h4><span><%=message %></span></h4>
		 <%} %>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%><div class="titleBg">
<h2>Patient Fitness Certificate (Government)</h2>
</div>
<div class="clear"></div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script>
	</div>
<form name="s" method="post">
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<%--------------- Start of Search Panel ---------------------------%>
<label><span>*</span> Entry No:</label>
<select name="<%= CODE%>"
	validate="Demand NO No,string,yes">
	<option value="">Select</option>
	<%for (HrPatientFitnessCertificate estimate :hrPatientFitnessCertificateFulList ) {
		String toDeptName="";
		if(estimate.getEntryNo()!=null){
			toDeptName=" [ "+estimate.getEntryNo()+" ]";
		}

	%>
	<option value=<%=estimate.getId()%>><%=estimate.getEntryNo()%></option>
	<%}%>
</select> 
<input type="image" name="button" class="button" onClick="submitForm('s','training?method=searchPatientFitnessCertificate');" />
<div class="clear"></div>
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('issueIdPrint','ac2update','budget?method=getIssueNoListForAutoComplete',{parameters:'requiredField=issueIdPrint'});
		</script>

<script type="text/javascript" language="javascript">
function submitprint(formName){
	var issueId=document.getElementById('issueIdPrint').value;
	if(issueId!=""){
		obj = eval('document.'+formName)
		obj.action = "/hms/hms/budget?method=printDepartmentIssue";
		obj.submit();
	}else{
		alert("Please Insert Issue No. for Print");
		return false;
	}
  }
</script>
</div>

 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>



<div class="clear"></div>
<form action="" method="post" name="PatientFitnessForm" id="PatientFitnessForm">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block"><label><span>*</span>Entry No :</label> 
<%for (HrPatientFitnessCertificate estimate :hrPatientFitnessCertificateList ) {
		
		%>
			<label class="value"><%=estimate.getEntryNo() %></label>
<input type="hidden" name="entryNo" value="<%=estimate.getEntryNo() %>" /> 	



<label><span>*</span>Date :</label> 
 <input type="text" class="date" tabindex="1" validate="Date,string,yes"
	id="entryDate" name="entryDate" readonly="readonly" MAXLENGTH="30" value="<%=HMSUtil.convertDateToStringWithoutTime(estimate.getDate()) %>"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate %>',document.PatientFitnessForm.entryDate,'event')" />
	
<label><span>*</span>Reg No :</label><input type="text" name="hinNo" id="hinNo" value="<%= estimate.getRegNo() %>"onblur=""/>


<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label><span>*</span>Title :</label> 

<input type="text" name="title" id="title" validate="Title,string,yes" MAXLENGTH="50" value=<%=estimate.getTitleId().getTitleName() %>  readonly="readonly">
<input type="hidden" name="titleId" id="titleId" value="<%=estimate.getTitleId().getId()%>" />


<label><span>*</span>Name :</label> <input type="text" name="Name" id="Name" validate="Name,string,yes" MAXLENGTH="50" value="<%= estimate.getName() %>"  readonly="readonly"/>
 <label><span>*</span>Doctor Name :</label> <select name="empId" id="empId" validate="Doctor Name,string,yes">
	<option value="0">Select</option>
	<%for(MasEmployee employee : employeeList){
	
	if(estimate.getDoctor().getId().equals(employee.getId()))
	{
	%>
	<option value="<%=employee.getId()%>" selected="selected"><%=employee.getFirstName()+' '+employee.getMiddleName()+' '+employee.getLastName()%></option>
	<%}
	if(!estimate.getDoctor().getId().equals(employee.getId()))
	{
	%>
	<option value="<%=employee.getId()%>" ><%=employee.getFirstName()+' '+employee.getMiddleName()+' '+employee.getLastName()%></option>
	<%}} %>
	</select> 
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label><span>*</span>Department :</label> <select name="departmentId" id="departmentId" validate="Department Name,string,yes">
	<option value="0">Select</option>
	<%for(MasDepartment department : departmentList){ 
	if(estimate.getDepartmentId().getId().equals(department.getId()))
	{
	%>
	<option value="<%=department.getId()%>" selected="selected"><%=department.getDepartmentName()%></option>
	<%}
	if(!estimate.getTitleId().getId().equals(department.getId()))
	{
	%>
	<option value="<%=department.getId()%>" ><%=department.getDepartmentName()%></option>
	<%}} %>
	
	</select>

<label><span>*</span>Resume Duty On :</label> 
<input type="text" class="date" tabindex="1" validate="Date,string,yes"
	id="resumeDate" name="resumeDate" readonly="readonly"
	MAXLENGTH="30" value="<%=HMSUtil.convertDateToStringWithoutTime(estimate.getResumeDate()) %>"/> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate %>',document.PatientFitnessForm.entryDate,'event')" />

<label><span>*</span>Case No :</label> <input type="text" name="caseNo" id="caseNo" value="<%= estimate.getCaseNo()%>" validate="Case NO,string,yes"/></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" name="Submit11" value="Update" onClick="submitForm('PatientFitnessForm','training?method=editPatientFitnessCertificate');"></input>

<input type="button" class="button" name="Print" value="Print" onclick="printReport();"></input>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="hidden" name="<%=TRAINING_ID%>" value="<%=hrPatientFitnessCertificateList.get(0).getId()%>" />


<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%} %>
</form>
<script type="text/javascript" language="javascript">
function printReport()
{
	 document.PatientFitnessForm.action="training?method=printPatientFitnessCertificate"
     document.PatientFitnessForm.submit();
}
 </script>
 
  </script>
 <div class="clear"></div>
 <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>