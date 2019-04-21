<!-- Made by Amit Das on 25-02-2016 -->
<%@page import="jkt.hms.masters.business.RsbyCardDetails"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="net.sf.jasperreports.engine.util.MaxFontSizeFinder"%>
<%@page import="jkt.hms.masters.business.IpdVitalcareHeader"%>
<%@page import="jkt.hms.masters.business.IpdVitalcareDetails"%>
<%@page import="jkt.hms.masters.business.IpdVitalSetup"%>
<%@page import="jkt.hms.masters.business.IpdCareHeader"%>
<%@page import="jkt.hms.masters.business.IpdCareDetails"%>
<%@page import="jkt.hms.masters.business.Ipdcaredetail"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>


<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>

<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date2=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date2.length()<2){
			date2="0"+date2;
		}
			
	%>
		serverdate = '<%=date2+"/"+month+"/"+year%>'
		
</script>

<%
	List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>(); // added by Amit Das on 02-03-2016
	List<Inpatient> inPatientList = new ArrayList<Inpatient>();
	String pageName = null;
	String message = "";


	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	// added by Amit Das on 02-03-2016
	if (map.get("authorizerList") != null) {
		authorizerList = (List<MasAuthorizer>) map.get("authorizerList");
	}
	

	if(map.get("message") != null){
		message = (String)map.get("message");
	}



	if(map.get("inPatientList") != null){
		inPatientList= (List<Inpatient>)map.get("inPatientList");
	}	
%>

<form name="schemeChangePatientSearch" method="post" onload="form.reset();">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4><%=message %></h4>
<div class="titleBg">
<h2>Patient Scheme</h2>
</div>
<div class="clear"></div>

<div class="Block">

<label>UHID</label> <input type="text"
	id="searchField" name="hinNo" value="" validate="UHID,alphanumeric,no"
	onblur=""
	maxlength="30" tabindex=1 />
<label>Patient Name</label> <input type="text"
	id="patientName" name="patientName" value="" validate="Patient Name,alphanumeric,no"
	onblur=""
	maxlength="30" tabindex=1 />
	
	
<div class="clear"></div>

<div class="clear"></div>
	
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" name="save" value="Search" onclick="submitForm('schemeChangePatientSearch','ipd?method=showChangeSchemeJsp','checkHinValue');" align="right" />
<input type="reset" class="button"  value="Reset"/>
<div class="clear"></div>
</div>
<div class="division"></div>

<div class="clear"></div>
<script type="text/javascript">
	function checkHinValue(){
		if(document.getElementById('searchField').value == "" && document.getElementById('patientName').value == "" ){
				alert("Please enter either UHID or Patient Name or Mobile Number");
			return false;
		}else{
			return true
		}
	
	}

document.getElementById('searchField').focus();

</script></form>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="patientListIp" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
	<script type="text/javascript">
	formFields = [
			[0, "hinId", "id"],[1,"hinNo"], [2,"patientName"], [3, "schemeName"], [4,"rsbyCardNo"], [5,"hospitalName"], [6,"documents"]];
	 statusTd = 6;
	</script>
	</div>
	
	</form>
	<script type="text/javascript" language="javascript">
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "UHID"
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "hinNo";
	
	data_header[1] = new Array;
	data_header[1][0] = "Patient Name"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "patientName";
	
	data_header[2] = new Array;
	data_header[2][0] = "Scheme"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "schemeName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Rsby Card No"
	data_header[3][1] = "data";
	data_header[3][2] = "15%";
	data_header[3][3] = "rsbyCardNo";
	
	data_header[4] = new Array;
	data_header[4][0] = "Hospital Name"
	data_header[4][1] = "data";
	data_header[4][2] = "30%";
	data_header[4][3] = "hospitalName";
	
	
	data_header[5] = new Array;
	data_header[5][0] = "Documents"
	data_header[5][1] = "data";
	data_header[5][2] = "30%";
	data_header[5][3] = "documents";

	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (inPatientList != null && inPatientList.size() > 0) { 
	 	for(Inpatient inpatient : inPatientList){
			%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getId()%>
			data_arr[<%= counter%>][1] = "<%= inpatient.getHinNo()%>" 
			data_arr[<%= counter%>][2] = "<%= inpatient.getHin().getFullName()%>"
			data_arr[<%= counter%>][3] = "<%=(inpatient.getScheme()!=null)?inpatient.getScheme().getSchemeName():"-"%>" 
			data_arr[<%= counter%>][4] = "<%=(inpatient.getHin().getRsbyCardNo()!=null) ? inpatient.getHin().getRsbyCardNo() : ""%>"
			data_arr[<%= counter%>][5] = "<%=inpatient.getHospital().getHospitalName()%>"
			data_arr[<%= counter%>][6] = "<%=inpatient.getDocuments()%>"
			<%
			counter++;
			//}
	 	}
		}
		%>
		formName = "patientListIp"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
		makeTable(start,end);
		//makeTable(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');  
</script>

<div class="clear"></div>
<form name="inpatientScheme" action="" method="post">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="paddingTop25"></div>

<div class="clear"></div>
<div id="test">

<input name="inpatientId" id="inpatientId" value="" type="hidden">

<label>Patient Name</label> 
<input name="pName" id="pName" value="" readonly="readonly" class="readOnly">

<label>UHID</label> 
<input name="uhid" id="uhid" value="" readonly="readonly" class="readOnly">

<div class="clear"></div>

<label>Current Scheme</label> 
<input name="currentScheme" id="currentScheme" value="" readonly="readonly" class="readOnly">
 
<label>New Scheme</label>
	 <div id="schemeDiv">
 		<select name="schemeList" id="schemeList" >
 			<option value="0">Select</option>
		</select>
</div>

<div class="clear"></div>
	
<!-- added authorizer by Amit Das on 02-03-2016 -->
<label>Authorizer</label>
<select name="authorizerId" id="authorizerId" >
	<option value="0">Select</option>
	<%	for (MasAuthorizer authorizer : authorizerList) {	%>
	<option value="<%=authorizer.getId() %>"><%=authorizer.getAuthorizerName()%></option>
	<%}%>
</select>

<!-- end of authorizer by Amit Das on 02-03-2016 -->


<label>Documents</label> 
<input name="documents" id="documents" value="" >


</div>
<div class="clear"></div>

<input type="button" class="button" value="Submit " align="left" onClick="if(validateForPatientScheme()){submitForm('inpatientScheme','ipd?method=updateInpatientScheme');}" />
 
</form>

<script>

function listScheme(inpatientId,currentSchemeName,rsbyCardNo,pName,uhid){
	document.getElementById("currentScheme").value = currentSchemeName;
	var rsbyCardFlag = "n";
	document.getElementById("pName").value = pName;
	document.getElementById("uhid").value = uhid;
	
	document.getElementById("inpatientId").value = inpatientId;
	if(rsbyCardNo!='')
		rsbyCardFlag = 'y';

submitProtoAjaxWithDivName('inpatientScheme','/hms/hms/billingMaster?method=listScheme&type=ip&inpatientId='+inpatientId+'&rsbyCardFlag='+rsbyCardFlag,'schemeDiv');
}

function validateForPatientScheme(){
	var e = document.getElementById("schemeId1");
	var schemeId = e.options[e.selectedIndex].value;
	e = document.getElementById("authorizerId");
	var authorizerId = e.options[e.selectedIndex].value;
	
	if(schemeId!=0 && authorizerId!=0){
		return true;
	} else if (authorizerId==0) {
		alert("Please choose authorizer");
		return false;
	}else {
		alert("Please choose scheme");
		return false;
	}	
}


function onChangeScheme()
{
	if(document.getElementById('schemeId1').value=="0")
		{
		
		}
	else
		{
		 		}
}


</script>


