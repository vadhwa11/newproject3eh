
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.HrTrainingService"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>


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
	<script type="text/javascript">
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	
		
	ArrayList searchTitleList = (ArrayList)map.get("searchTitleList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
    Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	
	String time = (String)utilMap.get("currentTime");
	String entryNo ="MS/VBCH/CERT/";
	String max="";
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	List<HrTrainingService> hrTrainingEntryNumList = new ArrayList<HrTrainingService>();
	List<HrTrainingService> hrTrainingServicefulList = new ArrayList<HrTrainingService>();

	if(map.get("trainingServiceList")!=null)
	{
		hrTrainingEntryNumList=(List<HrTrainingService>)map.get("trainingServiceList");
		
	}
	if(map.get("hrTrainingServicefulList")!=null)
	{
		hrTrainingServicefulList=(List<HrTrainingService>)map.get("hrTrainingServicefulList");
	}
	
	
	if(map.get("max")!=null)
	{
		max=(String)map.get("max");
	}
	if(map.get("titleList")!=null)
	{
		titleList = (List<MasTitle>)map.get("titleList");
	}
	if(map.get("employeeList")!=null)
	{
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("bloodGroupList")!=null)
	{
		bloodGroupList = (List<MasBloodGroup>)map.get("bloodGroupList");
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
%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<div class="titleBg">
<h2>Training And Service Certificate Entry</h2>
</div>
<div class="clear"></div>

<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script>
	</div>
<form name="s" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<%--------------- Start of Search Panel ---------------------------%>
<label><span>*</span> Entry No:</label>
<select name="<%= CODE%>"
	validate="Demand NO No,string,yes">
	<option value="">Select</option>
	<%for (HrTrainingService estimate1 :hrTrainingServicefulList ) {
		String toDeptName="";
		if(estimate1.getEntryNumber()!=null){
			toDeptName=" [ "+estimate1.getEntryNumber()+" ]";
		}

	%>
	<option value=<%=estimate1.getId()%>><%=estimate1.getEntryNumber()%></option>
	<%}%>
</select> 
<input type="image" name="button" class="button" onClick="submitForm('s','training?method=searchTrainingServiceCertificate');" />
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

 


 </form>



<div class="clear"></div>
<form action="" method="post" name="TrainingServiceForm" id="TrainingServiceForm">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block">
<label>Entry No :</label> 
<%for (HrTrainingService estimate :hrTrainingEntryNumList ) {
		
		%>
			<label class="value"><%=estimate.getEntryNumber() %></label>
<input type="hidden" name="entryNo" value="<%=estimate.getEntryNumber() %>" /> 			

<label><span>*</span>Date :</label> 
 <input type="text" class="date" tabindex="1" validate="Date,string,yes" value="<%=HMSUtil.convertDateToStringWithoutTime(estimate.getDate())%>"
	id="entryDate" name="entryDate" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate %>',document.TrainingServiceForm.entryDate,'event')" />
<label><span>*</span>Title :</label> <select name="titleId" id="titleId" validate="Title,string,yes">
	<option value="0">Select</option>
	<%for(MasTitle title : titleList){ 
	if(estimate.getTitleId().getId().equals(title.getId()))
	{
	%>
	<option value="<%=title.getId()%>" selected="selected"><%=title.getTitleName()%></option>
	<%}
	if(!estimate.getTitleId().getId().equals(title.getId()))
	{
	%>
	<option value="<%=title.getId()%>" ><%=title.getTitleName()%></option>
	<%}} %>
	
	
</select>
<div class="clear"></div>
<label><span>*</span>Name :</label> <input type="text" name= "Name" id="Name" value="<%=estimate.getName() %>" validate="Name,string,yes"MAXLENGTH="30"/> 

<label><span>*</span>Age :</label> <input type="text" id="age" name="age" value="<%= estimate.getAge() %>" onkeypress="return isNumberKey(event)" validate="age, integer, yes" MAXLENGTH="3"/> 
<label><span>*</span>Blood Group :</label> <select name="bloodId" id="bloodId" validate="Blood Group,string,yes">
	<option value="0">Select</option>
	<%for(MasBloodGroup blood : bloodGroupList){ 
	if(estimate.getBloodGroup().getId().equals(blood.getId()))
	{
	%>
	<option value="<%=blood.getId()%>" selected="selected"><%=blood.getBloodGroupName()%></option>
	<%}
	if(!estimate.getBloodGroup().getId().equals(blood.getId()))
	{
	%>
	<option value="<%=blood.getId()%>" ><%=blood.getBloodGroupName()%></option>
	<%}} %>
	
	</select> 
	<% if (estimate.getVillage()!=null)
	{
	%>
<label>Village Name :</label> <input type="text" id="village" name="village" value="<%= estimate.getVillage()%>" validate="Village Name,string,no"MAXLENGTH="50"/>
<%
	}
else {
%>
<label>Village Name :</label> <input type="text" id="village" name="village" value="" validate="Village Name,string,no"MAXLENGTH="50"/>
<%} %>


<div class="clear"></div>
<label><span>*</span>Type :</label> <select name="typeId" id="typeId" validate="Type,string,yes">

<%
if(estimate.getType().equals("1"))
{
%>
	<option value="" >Select</option>
	<option value="1" selected="selected">Service</option>
	<option value="2" >Training</option>
	<%}
if(estimate.getType().equals("2"))
{
%>
	<option value="" >Select</option>
	<option value="1" >Service</option>
	<option value="2" selected="selected">Training</option>
	<%} %>
	</select> 
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
<label><span>*</span>Case No :</label> <input type="text" name="caseNo"  id="caseNo" value="<%= estimate.getCaseNo()%>" validate="Case NO,string,yes"MAXLENGTH="50"/></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<input type="button" class="button" name="modify" value="Modify" onClick="submitForm('TrainingServiceForm','training?method=editTrainingServiceCertificate');" accesskey="a" tabindex=1 /></input>


<input type="button" class="button" name="Print" value="Print" onclick="printReport();"></input>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=TRAINING_ID%>" value="<%=hrTrainingEntryNumList.get(0).getId()%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%} %>
</form>
<script type="text/javascript" language="javascript">
function printReport()
{
	 document.TrainingServiceForm.action="training?method=printTrainingServiceCertificate"
     document.TrainingServiceForm.submit();
}
 </script>
 <div class="clear"></div>
 <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
<SCRIPT language=Javascript>//script for entering only integer
      <!--
      function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

         return true;
      }
      //-->
</SCRIPT>