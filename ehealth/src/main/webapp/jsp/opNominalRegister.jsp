<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>

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
		serverdate = '<%=date+"/"+month+"/"+year%>';
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
 	
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	
	List<MasEmployeeDepartment> departmentList = new ArrayList<MasEmployeeDepartment>();
	List<MasDepartment> instDepartmentList = new ArrayList<MasDepartment>();
	List<MasScheme> schemeList = new ArrayList<MasScheme>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
	
 	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
 	
	if(map.get("departmentList") != null){
		departmentList = (List<MasEmployeeDepartment>) map.get("departmentList");
	}
 	if(map.get("instDepartmentList") != null){
 		instDepartmentList = (List<MasDepartment>) map.get("instDepartmentList");
	}
	if(map.get("schemeList") != null){
		schemeList = (List<MasScheme>) map.get("schemeList");
	}
	
	if(map.get("sexList") != null){
		sexList = (List<MasAdministrativeSex>) map.get("sexList");
	}
	
	if(map.get("patientTypeList") != null){
		patientTypeList = (List<MasPatientType>) map.get("patientTypeList");
	}
			
	%>
<div class="titleBg">
<h2>OP Nominal Register</h2>
</div>

<form name="opNominalRegister" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="doctorsDiv" value="nominal">
<div class="Block">
<label class="medium">From Date<span>*</span></label> 
<input type="text"	id="opNominalFromDateId" validate="fromDate,char,yes" name="<%=FROM_DATE%>" value="<%=currentDate %>"	class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.opNominalRegister.<%=FROM_DATE%>,event)" />
<label class="medium">Time</label>
<input type="text" class="small" id="fromTime" name="fromTime" value="00:00" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<label class="medium">To Date <span>*</span></label> 
<input type="text" id="opNominalToDateId"  validate="toDate,char,yes" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.opNominalRegister.<%=TO_DATE%>,event)" />
<label class="medium"> Time</label>
<input type="text" class="small" id="toTime" name="toTime" value="23:59" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<div class="clear"></div>
<label class="medium">Department</label> 
<select id="departmentd" validate="departmentd,metachar,no" name="<%=DEPARTMENT_ID %>"
	onchange="submitProtoAjaxWithDivName('opNominalRegister','/hms/hms/adt?method=getServiceCentreDoctors','testDiv');">
	<option value="">Select</option>
	<% for (MasEmployeeDepartment masDepartment : departmentList) {
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getEmpDeptName()%></option>
	<% } %>
</select>
<div id="testDiv">
	<label class="medium">Service Centre</label> 
	<select id="serviceCentreId" validate="serviceCentre,metachar,no" name="serviceCentreId">
		<option value="">Select</option>
		<% for (MasDepartment masDept : instDepartmentList) { %>
			<option value="<%=masDept.getId() %>"><%=masDept.getDepartmentName()%></option>
		<% } %>
	</select>
	
	
		<label class="medium">Doctors </label>
		<select name="employeeId" id="employeeId" >
			<option value="0">Select</option>
	</select>
	</div>
<div class="clear"></div>
<label class="medium">Age</label> 
<input type="text" class="small" id="fromAge" name="fromAge" validate="fromAge,metachar,no">
<select id="fromAgeType" name="fromAgeType" style="width:100px;">
	<option value="years">Years</option>
	<option value="months">Months</option>
	<option value="days">Days</option>
</select>
<label class="medium">To</label>
<input type="text" class="small" id="toAge" name="toAge" validate="toAge,metachar,no">
<select id="toAgeType" name="toAgeType" style="width:100px;">
	<option value="years">Years</option>
	<option value="months">Months</option>
	<option value="days">Days</option>
</select>

<label class="medium">Gender</label> 

<select id="gender" name="<%=SEX_ID %>" tabindex="1" validate="gender,metachar,no"
					onChange="changeGender();">
				<option value="">Select</option>	
					<%
               for(MasAdministrativeSex masAdministrativeSex : sexList)
               {
             %>
					<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
			<%
                       
               }
			%>
</select>

<div class="clear"></div>
<label class="medium">Scheme</label> 

<select id="scheme" name="<%=SCHEME_ID %>" tabindex="1" validate="scheme,metachar,no"
					onChange="changeGender();">
				<option value="">Select</option>	
					<%
               for(MasScheme masScheme : schemeList)
               {
             %>
					<option value="<%=masScheme.getId() %>"><%=masScheme.getSchemeName() %></option>
			<%
                       
               }
			%>
</select>

<%-- <label class="autoSpace"> BPL<input type="radio" name="<%=BPL_STATUS %>" value="y" class="radioCheckCol2"></label> --%>
<label class="a"> BPL</label><input class="checkboxMargin" type="checkbox" tabindex="1" name="<%=BPL_STATUS %>" id="<%=BPL_STATUS %>" value="y"/>
 
<label class="auto">Monthly Income</label> 
<input type="text" id="fromMonthlyIncome" name="fromMonthlyIncome" class="small" validate="fromMonthlyIncome,metachar,no">
<label class="medium">To</label> 
<input type="text" id="toMonthlyIncome" name="toMonthlyIncome" class="small" validate="toMonthlyIncome,metachar,no">

<div class="clear"></div>
<label class="auto">Social Category</label> 

<select id="patientTypeId" name="<%=PATIENT_TYPE_ID%>" tabindex="1" validate="patientTypeId,metachar,no" style="width:181px;">
				<option value="">Select</option>	
					<%
               for(MasPatientType masPatientType : patientTypeList)
               {
             %>
					<option value="<%=masPatientType.getId() %>"><%=masPatientType.getPatientTypeName() %></option>
			<%
                       
               }
			%>
</select> 
<label class="auto">Visit Type</label>
<select name="visitType"><option selected="selected">All</option><option>Appointment</option></select> 
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="if(validateTwoDates(fromDate, toDate)  && validateFromToTime(fromTime, toTime)){submitForm('opNominalRegister','adt?method=printOPNominalRegister&flag=1');}" />
<!-- //Note: Revert the changes for story NO :37
<input type="button" name="OK1" value="Print HTML" class="button" onClick="submitForm('opNominalRegister','adt?method=printOPNominalRegister&flag=2');" />
 -->
 <input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
</form>





