<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>

<%@page import="java.io.InputStream"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
	<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 28 Sep 2010
 -->
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<script type="text/javascript">

	function validateFieldValues(){

		var fromDateId=document.getElementById("fromDateId").value;
		var ToDateId=document.getElementById("ToDateId").value;
		if(fromDateId=="")
		{
			alert("From Date Should not be Empty ! ");
			document.getElementById("fromDateId").value="";
			return false;
		}
		if(ToDateId=="")
		{
			alert("To Date Should not be Empty ! ");
			document.getElementById("ToDateId").value="";
			return false;
		}
		if(fromDateId != "" && ToDateId!="")
		{

				var fromDate = new Date(fromDateId.substring(6),(fromDateId.substring(3,5) - 1) ,fromDateId.substring(0,2))
				var ToDate = new Date(ToDateId.substring(6),(ToDateId.substring(3,5) - 1) ,ToDateId.substring(0,2))
					if(ToDate<fromDate)
				    {

					alert("To Date Should be greater than From Date !");
					document.getElementById("fromDateId").value="";
					document.getElementById("ToDateId").value="";
					return false;
				    }
	    }

	    return true;
	}
</script>

<%
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();

			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	String time = (String) utilMap.get("currentTime");

		 	List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
			List<MasScheme> schemeList = new ArrayList<MasScheme>();
			List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
			List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();

		 	if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
		 	if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>) map.get("departmentList");
			}
			if(map.get("wardList") != null){
				wardList = (List<MasDepartment>) map.get("wardList");
			}
			if(map.get("caseTypeList") != null){
				caseTypeList = (List<MasCaseType>) map.get("caseTypeList");
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

			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}

			String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");

	%>
<div class="titleBg">
<h2><%=prop.getProperty("com.jkt.hms.ipd") %> Register</h2>
</div>
<div class="clear"></div>
<form name="ipAdmissionRegister" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label><span>*</span> From Date</label>
<input type="text" id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>" readonly="readonly" MAXLENGTH="30" class="date" validate="From Date, date, yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currenDate %>',document.ipAdmissionRegister.<%=FROM_DATE%>,event)" />
<label class="medium"> Time</label>
<input type="text" class="small" id="fromTime" name="fromTime" value="00:00" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<label class="medium"><span>*</span> To Date</label>
<input type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>" readonly="readonly" MAXLENGTH="30" class="date" validate="To Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currenDate %>',document.ipAdmissionRegister.<%=TO_DATE%>,event)" />
<label class="medium"> Time</label>
<input type="text" class="small" id="toTime" name="toTime" value="23:59" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<label class="auto">Cash Received</label> <input type="checkbox" tabindex="1" name="cashreceived" id="cashreceived" value="y" class="checkboxMargin" />
<div class="clear"></div>
<label> Ward</label>
<select id="wardId"
	name="<%=WARD_ID %>">
	<option value="0">Select</option>
	<%
							for (MasDepartment masDepartment : wardList) {
								if(masDepartment.getDepartmentType()!=null && masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%			}
							}
					%>
</select>
<label class="medium">Age</label> 
<input type="text" id="fromAge" name="fromAge" class="small" validate="fromAge,metachar,no">
<select id="fromAgeType" name="fromAgeType" class="medium2">
	<option value="years">Years</option>
	<option value="months">Months</option>
	<option value="days">Days</option>
</select>
<label class="medium">To</label>
<input type="text" id="toAge" name="toAge" class="small" validate="toAge,metachar,no">
<select id="toAgeType" name="toAgeType" class="medium2">
	<option value="years">Years</option>
	<option value="months">Months</option>
	<option value="days">Days</option>
</select>
<%-- <label class="autoSpace"> BPL<input type="radio" name="<%=BPL_STATUS %>" value="y" class="radioCheckCol2"></label> --%>
<label class="medium"> BPL</label><input type="checkbox" tabindex="1" name="<%=BPL_STATUS %>" id="<%=BPL_STATUS %>" style="margin: 0px 85px 5px 5px;" value="y"/>
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
<label> Case Type</label>
<select name="<%=CASE_TYPE_ID %>"
	validate="Case Type,string,no" tabindex="1">
	<option value="0">Select</option>
	<%
for(MasCaseType masCaseType : caseTypeList){
%>
	<option value="<%=masCaseType.getId() %>"><%=masCaseType.getCaseTypeName() %></option>
	<%} %>
</select>
<div class="clear"></div>
<label>Monthly Income</label> 
<input type="text" id="fromMonthlyIncome" name="fromMonthlyIncome" class="small" style="width:77px;" validate="fromMonthlyIncome,metachar,no">
<label class="auto">To</label> 
<input type="text" id="toMonthlyIncome" name="toMonthlyIncome" style="width:77px;" validate="toMonthlyIncome,metachar,no">

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
<label>Department</label> 
<select id="departmentd" validate="departmentd,metachar,no"
	name="<%=DEPARTMENT_ID %>">
	<option value="">Select</option>
	<% for (MasDepartment masDepartment : departmentList) {
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<% } %>
</select>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="OK" value="OK" class="button" onClick="if(validateFieldValues()){submitForm('ipAdmissionRegister','adt?method=showIpAdmissionRegisterReport&type=ip&flag=1');}" />
<!-- //Note: Revert the changes for story NO :37
<input type="button" name="OK1" value="print HTML" class="button" onClick="if(validateFieldValues()){submitForm('ipAdmissionRegister','adt?method=showIpAdmissionRegisterReport&type=ip&flag=2');}" />
-->
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<!--<input type="button" name ="SIL/DIL as on" value ="SIL/DIL as on" class="button" onClick="submitForm('ipAdmissionRegister','adt?method=printSilDilRepotInAdt');" accesskey="r" />
<input type="button" name ="IP Adm as on" value ="IP Adm as on" class="button" onClick="submitForm('ipAdmissionRegister','adt?method=showIpAdmissionRegisterReport&type=asOn');" accesskey="r" />
--></form>


<script type="text/javascript">
function checkAsOn(){
 if(document.getElementById('hospitalStaffId').value=='y'){
		document.getElementById('divId').style.display = 'none';
		}else{
		alert("-")
		submitForm('ipAdmissionRegister','/hms/hms/adt?method=showIpAdmissionRegisterReportJsp');
		}

	}
</script>

