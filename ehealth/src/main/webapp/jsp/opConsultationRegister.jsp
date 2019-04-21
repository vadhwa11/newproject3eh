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
<h2>OP Consultation Register</h2>
</div>
<div class="clear"></div>

<form name="opConsultationRegister" target="_blank" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="doctorsDiv" value="n">
<div class="Block">
<label class="autoSpace">From Date<span>*</span></label> 
<input type="text"	id="opNominalFromDateId" validate="fromDate,char,yes" name="<%=FROM_DATE%>" value="<%=currentDate %>"	class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.opConsultationRegister.<%=FROM_DATE%>,event)" />
<label class="autoSpace"> Time</label>
<input type="text" class="small" id="fromTime" name="fromTime" value="00:00" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<label class="autoSpace"> To Date <span>*</span></label> 
<input type="text" id="opNominalToDateId"  validate="toDate,char,yes" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.opConsultationRegister.<%=TO_DATE%>,event)" />
<label class="autoSpace"> Time</label>
<input type="text" class="small" id="toTime" name="toTime" value="23:59" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<div class="clear"></div>
<label>Department</label> 
<select id="departmentd" validate="departmentd,metachar,no" name="<%=DEPARTMENT_ID %>"
	onchange="submitProtoAjaxWithDivName('opConsultationRegister','/hms/hms/adt?method=getServiceCentreDoctors','testDiv');">
	<option value="">Select</option>
	<% for (MasEmployeeDepartment masDepartment : departmentList) {
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getEmpDeptName()%></option>
	<% } %>
</select>
<div id="testDiv">
	<label class="autoSpace">Service Centre</label> 
	<select id="serviceCentreId" validate="serviceCentre,metachar,no" name="serviceCentreId">
		<option value="">Select</option>
		<% for (MasDepartment masDept : instDepartmentList) { %>
			<option value="<%=masDept.getId() %>"><%=masDept.getDepartmentName()%></option>
		<% } %>
	</select>
</div>
<label class="autoSpace">Age</label> 
<input type="text" class="small" id="fromAge" name="fromAge" validate="fromAge,metachar,no">
<select id="fromAgeType" name="fromAgeType" class="medium2">
	<option value="years">Years</option>
	<option value="months">Months</option>
	<option value="days">Days</option>
</select>
<label class="auto">To</label>
<input type="text" class="small" id="toAge" name="toAge" validate="toAge,metachar,no">
<select id="toAgeType" name="toAgeType" class="medium2">
	<option value="years">Years</option>
	<option value="months">Months</option>
	<option value="days">Days</option>
</select>
<div class="clear"></div>

<label>Gender</label> 

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


<label>Scheme</label> 

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

<label class="autoSpace"> BPL</label><input type="checkbox" tabindex="1" name="<%=BPL_STATUS %>" id="<%=BPL_STATUS %>" value="y"/>
 
<div class="clear"></div>

<label>Monthly Income</label> 
<input type="text" id="fromMonthlyIncome" name="fromMonthlyIncome" class="small" validate="fromMonthlyIncome,metachar,no">
<label class="auto">To</label> 
<input type="text" id="toMonthlyIncome" name="toMonthlyIncome" class="small" validate="toMonthlyIncome,metachar,no">

<label>Social Category</label> 

<select id="patientTypeId" name="<%=PATIENT_TYPE_ID%>" tabindex="1" validate="patientTypeId,metachar,no">
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

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('opConsultationRegister','adt?method=printOPConsultationRegister');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
</form>

