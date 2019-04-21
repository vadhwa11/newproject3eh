<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
	
<%
int loginDeptId = 0;
if(session.getAttribute("deptId") != null){
	loginDeptId = (Integer)session.getAttribute("deptId");
}
String loginDeptType = "";
if(session.getAttribute("deptType") != null){
	loginDeptType = (String)session.getAttribute("deptType");
}
%>
<script type="text/javascript" language="javascript">
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
<script type="text/javascript">
function check()
	{
		var r = document.getElementById('mainChargeCodeId').value;
		if(r=="0")
		{
			if(!displayAlert("Please select Main Group"))
				alert("Please select Main Group");
			getShadow("mainChargeCodeId");
			return false;
		}
		else
		{
			return true;
		}
	}
	function validationFromAge(val)
	{
		if(val=="")
			{
			document.getElementById("fromageUnitId").value="";
			document.getElementById("toageId").value="";
			document.getElementById("toageUnitId").value="";
			
			}
	}
	
	function toAgeValidation()
	{
		if((document.getElementById("fromageId")!=null && document.getElementById("fromageId").value=="") || document.getElementById("fromageUnitId")!=null && document.getElementById("fromageUnitId").value=="")
			{
			document.getElementById("toageId").value="";
			document.getElementById("toageUnitId").value="";
			alert("Please select From Age first");
			
			}
	}
	
	function generateDiagnosticRegister(){
		
		var result = true;
		
		var fromAge = document.getElementById("fromageId");
		var toAge =	document.getElementById("toageId");
		var fromAgeUnit = document.getElementById("fromageUnitId");
		var toAgeUnit =	document.getElementById("toageUnitId");
		
		if(fromAge!=null && fromAge.value!="") 
			{
			
			 if(fromAgeUnit!=null && fromAgeUnit.value=="") 
				 {
				 alert("Please select from age unit");
				 return;
				 }
			 else if(toAge!=null && toAge.value!="") 
				  {
				    if(fromAgeUnit.value!=toAgeUnit.value)
				    	{
				    	 alert("To age unit should be same as from age");
				    	 return;
				    	}
				    else if(fromAge.value > toAge.value)
				    	{
				    	alert("From age should be less than to age");
				    	return;
				    	}
				    	
				  }
			  else
				  {
				  alert("Please enter to age");
				   return;
				  }
			
			}
		
		<% if(loginDeptType.equals("RADIO")){ %>
			submitForm('diagnosticRegisterDoctorWise','lab?method=generatePatientDiagnosticRegister','validateFromToDate');
		<% }else{ %>
			submitForm('diagnosticRegisterDoctorWise','lab?method=generatePatientDiagnosticRegisterLab','validateFromToDate');
		<% } %>		
	}
	
</script>
<%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String deptType = "";
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(map.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)map.get("subChargeCodeList");
		}
		if(map.get("departmentList")!= null){
			departmentList = (List<MasDepartment>)map.get("departmentList");
		}
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}
		List<MasAdministrativeSex> sexList = null;
		List<MasMaritalStatus> maritalStatusList = null;
		List<MasEmployee> doctorList = null;
		List<Object[]> chargeCodeList = new ArrayList<Object[]>();
		if(map.get("sexList") != null){
			sexList = (List<MasAdministrativeSex>)map.get("sexList");
		}
		if(map.get("maritalStatusList") != null){
			maritalStatusList = (List<MasMaritalStatus>)map.get("maritalStatusList");
		}
		if(map.get("employeeList") != null){
			doctorList = (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("chargeCodeList")!= null){
			chargeCodeList = (List<Object[]>)map.get("chargeCodeList");
		}int deptId=0;
		if(map.get("deptId")!= null){
			deptId = (Integer)map.get("deptId");
		}
	%>

<h2>Diagnostic Register</h2>
<form name="diagnosticRegisterDoctorWise" target="_blank" action=""
	method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div class="clear"></div>
	<div class="Block">
		  <label class="medium-"> From Date<span>*</span>
		</label> <input type="text" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=currentDate %>" class="date" readonly="readonly"
			maxlength="30" validate="fromDate,date,yes"/> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender"
			onclick="setdate('<%=currentDate %>',document.diagnosticRegisterDoctorWise.<%=FROM_DATE%>,event)" />

		<label>To Date<span>*</span>
		</label> <input type="text" id="ToDateId" name="<%=TO_DATE %>"
			value="<%=currentDate %>" class="date" readonly="readonly"
			maxlength="30" validate="toDate,date,yes"/> <img id="calendar" src="/hms/jsp/images/cal.gif"
			width="16" height="16" border="0" validate="Pick a date"
			class="calender"
			onclick="setdate('<%=currentDate %>',document.diagnosticRegisterDoctorWise.<%=TO_DATE%>,event)" />
		<div class="clear"></div>
		<div class="clear"></div>
		 <label class="medium-"> From Age</label> <select
			id="fromageId" name="fromAge" tabindex="1" class="smallest" onchange="validationFromAge(this.value);">
			<option value="">Select</option>
			<%
				for(int age1 = 1;age1<=100;age1++){
				%>
			<option value="<%=age1%>"><%= age1%></option>
			<%}%>
		</select> <select id="fromageUnitId" name="fromAgeUnit" tabindex="1"
			class="smallest">
			<option value="">Select</option>
			<option value="Years">Years</option>
			<option value="Months">Months</option>
			<option value="Days">Days</option>
		</select> <label> To Age</label> <select id="toageId" name="toAge" tabindex="1"
			class="smallest" onchange="toAgeValidation();">
			<option value="">Select</option>
			<%	for(int age1 = 1;age1<=100;age1++){	%>
			<option value="<%=age1%>"><%= age1%></option>
			<%}%>
		</select> <select id="toageUnitId" name="toAgeUnit" tabindex="1" class="smallest" onchange="toAgeValidation();">
			<option value="">Select</option>
			<option value="Years">Years</option>
			<option value="Months">Months</option>
			<option value="Days">Days</option>
		</select>
		<div class="clear"></div>
		<label>Gender </label> <select name="<%=SEX_ID %>" id="srSexId"
			validate="Gender,metachar,no" tabindex="1">
			<option value="0">Select</option>
			<% for(MasAdministrativeSex masAdministrativeSex : sexList){%>

			<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
			<%  	 	} %>
		</select> <label> Marital Status</label> <select name="<%=MARITAL_STATUS_ID %>"
			id="mrstatus" tabindex="1" validate="Marital,metachar,no">
			<option value="0">Select</option>
			<%
	 for(MasMaritalStatus masMaritalStatus : maritalStatusList){	
	%>
			<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
			<%}%>
		</select>
		<div class="clear"></div>
		<label>Department</label> <select name="<%= DEPARTMENT_ID%>" validate="Department,metachar,no"
			tabindex=1 onchange="populateSubCharge(this.value);">
			<option value="0">Select</option>
			<% 
				for (MasDepartment  masDepartment : departmentList){
					if(deptId == masDepartment.getId()){
					%>
			<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
			<%}else{ %>
			<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
			<%}
	}%>
		</select>
		<script>
var subchargeArray = new Array();
<%
int counter1 = 0;
for (MasDepartment dept : departmentList)
{
	for (MasSubChargecode subCharge : subChargeCodeList) 
	{
			if(dept.getId().equals(subCharge.getMainChargecode().getDepartment().getId() )){
			%>
				subchargeArray[<%=counter1%>] = new Array();
				subchargeArray[<%=counter1%>][0]=<%=dept.getId()%>;
				subchargeArray[<%=counter1%>][1] = <%=subCharge.getId()%>;									
				subchargeArray[<%=counter1%>][2] = "<%=subCharge.getSubChargecodeName()%>";

			<%
			counter1++;
			}
	}
}
%>
</script>
		<label>Sub Charge</label> <select id="subChargeId"
			name="<%= SUB_CHARGECODE_ID %>" onchange="populateTest(this.value);"
			tabindex=1>
			<option value="0">Select</option>
			<% 
	for (MasSubChargecode  masSubChargecode : subChargeCodeList){
		if(masSubChargecode.getMainChargecode().getDepartment().getId().equals(session.getAttribute("deptId"))){
					%>
			<option value="<%=masSubChargecode.getId ()%>"><%=masSubChargecode.getSubChargecodeName()%></option>
			<%}
	}%>
		</select>
		<script>
var chargeArray = new Array();
<%

int counter = 0;
for (MasSubChargecode subCharge : subChargeCodeList) 
{
		for (Object[] charge: chargeCodeList)
	{
			if(subCharge.getId().equals(charge[3] )){
					%>
				chargeArray[<%=counter%>] = new Array();
				chargeArray[<%=counter%>][0]=<%=subCharge.getId()%>;
				chargeArray[<%=counter%>][1] = <%=charge[0]%>;									
				chargeArray[<%=counter%>][2] = "<%=charge[1]%>";

					<%
					counter++;
			}
	}
}

%>

</script>
		<div class="clear"></div>
		<label>Investigation</label> <select name="<%= INVESTIGATION_ID %>"
			id="testId" tabindex=1 onchange="getResultType(this.value)">
			<option value="0">Select</option>
			<% 
				for (Object[]  obj : chargeCodeList){
					if(obj[2].equals(session.getAttribute("deptId"))){
					%>
			<option value="<%=obj[0]%>"><%=(String)obj[1]%></option>
			<%}
	}%>
		</select> <label>Result Type</label> <select id="resultType" name="resultType">
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<option value="s">Single</option>
			<option value="m">Multiple</option>
			<option value="t">Template</option>
			<option value="v">Sensitive</option>
			<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
			<option value="t" selected="selected">Template</option>
			<%} %>
		</select>
		<%---
<div class="clear"></div>
<label>ICD No</label>
<input type="text" class="transparent" size="14">
<input type="text" name="icdNo" value="" id="icdNo" validate="icdNo,alphanumeric,yes "/>
<label>ICD Diagnosis</label>
<input type="text" tabindex="1"	value="" id="icd"  name="icd"	class="auto"  size="60" />
<div id="ac2update"	style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
</script> --%>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<input type="button" name="OK" value="OK" class="button"
		onclick="generateDiagnosticRegister();" /> <input type="button"
		name="OK" value="PRINT" class="button"
		onclick="submitForm('diagnosticRegisterDoctorWise','lab?method=printDiagnosticRegister','validateFromToDate');" />
	<!-- <input type="reset" name="Reset" id="reset" value="Reset"
		class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> -->

</form>
<script type="text/javascript" language="javascript">

function getResultType(investigationId){
	
	if(investigationId!="0"){
		document.getElementById('resultType').options.length = 0;
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	var data=this.responseText;
		    	
		    	var dt=data.toString();
		    	//alert(dt);
				
		    	var select = document.getElementById('resultType');
		    	var opt = document.createElement('option');
		    	if(dt=="s"){
		    		opt.value = "s";
				    opt.innerHTML = "Single";
				    select.appendChild(opt);
		    	}else if(dt=="t"){
		    		opt.value = "t";
				    opt.innerHTML = "Template";
				    select.appendChild(opt);
		    	}else if(dt=="m"){
		    		opt.value = "m";
				    opt.innerHTML = "Multiple";
				    select.appendChild(opt);
		    	}else if(dt=="v"){
		    		opt.value = "v";
				    opt.innerHTML = "Sensitive";
				    select.appendChild(opt);
		    	}
		    	
		    }
		  };
		  xhttp.open("GET", "lab?method=getResultType&investigationId="+ investigationId, true);
		  xhttp.send();
		
	}else if(investigationId=="0"){
		
		document.getElementById('resultType').options.length = 0;
		var select = document.getElementById('resultType');
		
    	var opt1 = document.createElement('option');
    	opt1.value = "s";
	    opt1.innerHTML = "Single";
	    select.appendChild(opt1);
	    
	    var opt2 = document.createElement('option');
	    opt2.value = "t";
	    opt2.innerHTML = "Template";
	    select.appendChild(opt2);
	    
	    var opt3 = document.createElement('option');
	    opt3.value = "m";
	    opt3.innerHTML = "Multiple";
	    select.appendChild(opt3);
	    
	    var opt4 = document.createElement('option');
	    opt4.value = "v";
	    opt4.innerHTML = "Sensitive";
	    select.appendChild(opt4);
	}
	
}


function validateFromToDate(){
	
	var nowDate=new Date();
	
	obj1 = eval(document.diagnosticRegisterDoctorWise.fromDate)
	obj2 = eval(document.diagnosticRegisterDoctorWise.toDate)
		
	if(obj1.value != "" && obj2.value != "")
	{
	
	 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
			
		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
					//if(!displayAlert("From Date should be smaller than To Date\n"))
						alert("From Date should be smaller than To Date\n");
					//showShadow(obj1);
					return false;
				}
			}
			
		else
		{
			//if(!displayAlert("From Date should not be greater than Current date\n"))
				alert("From Date should not be greater than Current date\n");
			//showShadow(obj1);
			return false;
		}
	
	}
	return true;
}

function populateSubCharge(val){
	obj = document.getElementById('subChargeId');
	obj.length = 1;
	for(i=0;i<subchargeArray.length;i++){
		if(subchargeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=subchargeArray[i][1];
			obj.options[obj.length-1].text=subchargeArray[i][2];			
		}
	}
}

function populateTest(val){
	obj = document.getElementById('testId');
	obj.length = 1;
	for(i=0;i<chargeArray.length;i++){
		if(chargeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=chargeArray[i][1];
			obj.options[obj.length-1].text=chargeArray[i][2];			
		}
	}
}
</script>