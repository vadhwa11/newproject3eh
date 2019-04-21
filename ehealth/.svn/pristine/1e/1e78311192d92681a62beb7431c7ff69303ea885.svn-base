
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.HrPatientFitnessCertificate"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="jkt.hms.masters.business.HrPatientSickCertificate"%><script type="text/javascript" src="../jsp/js/calendar.js"></script>
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
<script src="/hms/jsp/js/ajax.js"  language="javascript" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js"  language="javascript" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js"  language="javascript" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js"  language="javascript" type="text/javascript"></script>
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
	String userName="";
	String message="";
	
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<HrPatientSickCertificate> hrPatientSickCertificateList = new ArrayList<HrPatientSickCertificate>();
	if(map.get("titleList")!=null)
	{
		titleList = (List<MasTitle>)map.get("titleList");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("max")!=null)
	{
		max=(String)map.get("max");
	}
	if(map.get("employeeList")!=null)
	{
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("hrPatientSickCertificateList")!=null)
	{
		hrPatientSickCertificateList = (List<HrPatientSickCertificate>)map.get("hrPatientSickCertificateList");
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
<%@page import="jkt.hms.util.HMSUtil"%>
<div class="titleBg">
<h2>Patient Sickness Certificate</h2>
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
	<%for (HrPatientSickCertificate estimate :hrPatientSickCertificateList ) {
		String toDeptName="";
		if(estimate.getEntryNo()!=null){
			toDeptName=" [ "+estimate.getEntryNo()+" ]";
		}

	%>
	<option value=<%=estimate.getId()%>><%=estimate.getEntryNo()%></option>
	<%}%>
</select> 
<input type="image" name="button" class="button" onClick="submitForm('s','training?method=searchPatientSicknessCertificate');" />
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
<form action="" method="post" name="PatientSicknessForm" id="PatientSicknessForm">
<div class="Block"><label><span>* </span>Entry No :</label> <input type="text" id="entryNo" name="entryNo" validate="Entry No,string,yes" value="<%=max%>" readonly="readonly"/>
<label><span>* </span>Date :</label> 
 <input type="text" class="date" tabindex="1" validate="Date,string,yes"
	id="entryDate" name="entryDate" readonly="readonly"
	MAXLENGTH="30" value="<%=currentDate %>"/> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate %>',document.PatientSicknessForm.entryDate,'event')" />
<label><span>* </span>Reg No :</label><input type="text" name="hinNo" id="hinNo" onblur="ajaxFunctionForPatientNameTitle(PatientSicknessForm);"/>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label><span>* </span>Title :</label> 
<input type="hidden" name="titleId" id="titleId" validate="TitleId,string,yes" MAXLENGTH="50" readonly="readonly"/>
<input type="text" name="titleName" id="titleName" validate="TitleName,string,yes" MAXLENGTH="50" readonly="readonly"/>


<label><span>* </span>Name :</label> <input type="text" id="name" name="Name" validate="Name,string,yes"MAXLENGTH="50" readonly="readonly"/> 


<label><span>* </span>Suffering From :</label> 
<input type="text" id="sufferDate" name="sufferDate" validate="Suffer,string,yes"MAXLENGTH="50"/>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label><span>* </span>Period of absence(In Day's) :</label> <input type="text" id="absentDays" name="absentDays" onkeypress="return isNumberKey(event)" validate="Period of Absence,string,yes"/>

<label><span>* </span>Effect From :</label> 
 <input type="text" class="date" tabindex="1" validate="Suffering,string,yes"
	id="effectFromDate" name="effectFromDate" readonly="readonly" value="<%=currentDate %>"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate %>',document.PatientSicknessForm.effectFromDate,'event')" />

<label><span>* </span>Effect To :</label> 
 <input type="text" class="date" tabindex="1" validate="Suffering,string,yes"
	id="effectToDate" name="effectToDate" readonly="readonly" value="<%=currentDate %>"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="javascript:setdate('<%=currentDate %>',document.PatientSicknessForm.effectToDate,'event')" />
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" name="Submit11" value="Submit" onclick="submitForm('PatientSicknessForm','training?method=addPatientSicknessCertificate');"></input>
<%--
<input type="button" class="button" name="modify" value="Modify"></input>
<input type="button" class="button" name="search" value="Search"></input>
--%>
<input type="button" class="button" name="Print" value="Print" onclick="printReport();"></input>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
<script type="text/javascript" language="javascript">
function printReport()
{
	 alert("Please search for a patient to print");
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