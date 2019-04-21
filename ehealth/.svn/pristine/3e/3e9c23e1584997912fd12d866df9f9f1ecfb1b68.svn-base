<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.HrTrainingService"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hms.masters.business.HrStudentCertificate"%>


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
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript">
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
</script>
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
	String max="";
	String message="";
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List <HrStudentCertificate> hrStudentCertificateList = new ArrayList<HrStudentCertificate>();
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(map.get("hrStudentCertificateList")!=null)
	{
		hrStudentCertificateList=(List<HrStudentCertificate>)map.get("hrStudentCertificateList");
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


<div class="titleBg">
<h2>Student Certificate For Admission</h2>
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
	<%for (HrStudentCertificate estimate1 :hrStudentCertificateList ) {
		String toDeptName="";
		if(estimate1.getEntryNo()!=null){
			toDeptName=" [ "+estimate1.getEntryNo()+" ]";
		}

	%>
	<option value=<%=estimate1.getId()%>><%=estimate1.getEntryNo()%></option>
	<%}%>
</select> 
<input type="image" name="button" class="button" onClick="submitForm('s','training?method=searchCertificateStudentAdmission');" />
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







<form action="" method="post" name="addmissionForm" id="addmissionForm"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block"><label><span>*</span>Entry No :</label> <input type="text" id="entryNo" name="entryNo" validate="Entry No,string,yes" value="<%=max%>" readonly="readonly"/>
<label><span>*</span>Date :</label> 
 <input type="text" class="date" tabindex="1" validate="Date,string,yes"
	id="entryDate" name="entryDate" readonly="readonly"
	MAXLENGTH="30" value="<%=currentDate %>"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0"  validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate %>',document.addmissionForm.entryDate,'event')" />
<label><span>*</span>Title :</label> <select name="titleId" id="titleId" validate="Title,string,yes">
	<option value="0">Select</option>
	<%for(MasTitle title : titleList){ %>
	<option value="<%=title.getId()%>"><%=title.getTitleName()%></option>
	<%}%>
</select>
<div class="clear"></div>
<label><span>*</span>Name :</label> <input type="text" id="Name" name="Name" validate="Name,string,yes"MAXLENGTH="30"/> 

<label>Age :</label> <input type="text" id="age" name="age" onkeypress="return isNumberKey(event)" MAXLENGTH="3"/> 
	
<label>Residence Of :</label> <input type="text" name="residence" id="residence" validate="Residence Name,string,no"MAXLENGTH="100"/>
<div class="clear"></div>
<label><span>*</span>Medical Fit For :</label> <select name="typeId" id="typeId" validate="Medical Fit For,string,yes">
	<option value="0">Select</option>
	<option value="1">Hostel</option>
	<option value="2">School</option>
	<option value="3">College</option>
	
</select> <label><span>*</span>Doctor Name :</label> <select name="empId" id="empId" validate="Doctor Name,string,yes">
	<option value="0">Select</option>
	<%for(MasEmployee employee : employeeList){ %>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()+' '+employee.getMiddleName()+' '+employee.getLastName()%></option>
	<%}%>
	
</select> <label><span>*</span>Case No :</label> <input type="text"  name="caseNo"  id="caseNo" validate="Case NO,string,yes" MAXLENGTH="50"/></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" name="Submit11" value="Submit" onClick="submitForm('addmissionForm','training?method=addCertificateStudentAdmission');" ></input>
<%-- 
<input type="button" class="button" name="modify" value="Modify"></input>
<input type="button" class="button" name="search" value="Search"></input>
--%>
<input type="button" class="button" name="Print" value="Print" onclick="printReport();"></input>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script type="text/javascript" language="javascript">
function printReport()
{
	 alert("Please search for a patient to print");
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