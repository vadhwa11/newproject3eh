<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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
	List<MasScheme> schemeList = new ArrayList<MasScheme>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
	
 	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
 	
	if(map.get("departmentList") != null){
		departmentList = (List<MasEmployeeDepartment>) map.get("departmentList");
	}
	
	if(map.get("schemeList") != null){
		schemeList = (List<MasScheme>) map.get("schemeList");
	}
	
	if(map.get("patientTypeList") != null){
		patientTypeList = (List<MasPatientType>) map.get("patientTypeList");
	}
			
	%>
<div class="titleBg">
<h2>Hospital Service Ulilization Report</h2>
</div>
<div class="clear"></div>

<form name="printHospitalServiceUlilization" target="_blank" method="post" action="">

<div class="Block">
<label>From Date<span>*</span></label> 
<input type="text"	id="opClinicalFromDateId" validate="fromDate,char,yes" name="<%=FROM_DATE%>" value="<%=currentDate %>"	class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.printHospitalServiceUlilization.<%=FROM_DATE%>,event)" />


<label> To Date <span>*</span></label> 
<input type="text" id="opClinicalToDateId"  validate="toDate,char,yes" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.printHospitalServiceUlilization.<%=TO_DATE%>,event)" />


<label>Service Center</label> 
<select id="departmentd" validate="departmentd,metachar,no"
	name="<%=DEPARTMENT_ID %>">
	<option value="">Select</option>
	<% for (MasEmployeeDepartment MasEmployeeDepartment : departmentList) {
						%>
	<option value="<%=MasEmployeeDepartment.getId() %>"><%=MasEmployeeDepartment.getEmpDeptName()%></option>
	<% } %>
</select>
<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('printHospitalServiceUlilization','adt?method=printHospitalServiceUlilization');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>






