<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
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
		Map map = new HashMap();
	 	if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
 			Map<String, Object> utilMap = new HashMap<String, Object>();

			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	List<MasEmployeeDepartment> departmentList = new ArrayList<MasEmployeeDepartment>();
		 	List<MasDepartment> instDepartmentList = new ArrayList<MasDepartment>();
		 	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		 	if(map.get("departmentList") != null){
				departmentList = (List<MasEmployeeDepartment>) map.get("departmentList");
			}
		 	if(map.get("instDepartmentList") != null){
		 		instDepartmentList = (List<MasDepartment>) map.get("instDepartmentList");
			}
		 	if(map.get("sexList") != null){
				sexList = (List<MasAdministrativeSex>) map.get("sexList");
			}
%>


<div class="titleBg">
<h2>OPD Register</h2>
</div>
<form name="opdRegister" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="doctorsDiv" value="n">
<div class="Block">
<label class="medium">New<input type="radio" name="visitType" value="new" checked="checked" class="radioCheckCol2"></label>
<label class="medium">Repeat<input type="radio" name="visitType" value="repeat" class="radioCheckCol2"></label>
<label class="auto">New/Repeat<input type="radio" name="visitType" value="newRepeat" class="radioCheckCol2"></label>

<!-- <label class="autoSpace"> Parked<input type="radio"	name="visitType" value="parked"  class="radioCheckCol2"></label> -->
<label class="auto">Incomplete Visit<input type="radio" name="visitType" value="incomplete" class="radioCheckCol2"></label>
<label class="auto">Patient Absconded/No Show<input type="radio" name="visitType" value="absconded" class="radioCheckCol2"></label>
<label>Cash Received</label> <input type="checkbox" tabindex="1" name="cashreceived" id="cashreceived" value="y"/>
<div class="clear"></div>

<label class="medium"><span>*</span> From Date</label>
<input type="text"	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currenDate %>"	readonly="readonly" MAXLENGTH="30" class="date"	validate="From Date, date, yes" />
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currenDate %>',document.opdRegister.<%=FROM_DATE%>,event)" />
<label class="medium"> Time</label>
<input type="text" class="small" id="fromTime" name="fromTime" value="00:00" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<label class="medium"><span>*</span> To Date</label>
<input type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>" class="date"	readonly="readonly" MAXLENGTH="30" validate="To Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('<%=currenDate %>',document.opdRegister.<%=TO_DATE%>,event)" />
<label class="medium"> Time</label>
<input type="text" class="small" id="toTime" name="toTime" value="23:59" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<div class="clear"></div>
<label class="medium">Department</label> 
<select id="departmentd" validate="departmentd,metachar,no" name="<%=DEPARTMENT_ID %>"
	onchange="submitProtoAjaxWithDivName('opdRegister','/hms/hms/adt?method=getServiceCentreDoctors','testDiv');">
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
</div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('opdRegister','registration?method=showOPDRegisterReport&flag=1');" />
<!-- //Note: Revert the changes for story NO :37<input type="button" name="OK1" value="Print HTML" class="button" onClick="submitForm('opdRegister','registration?method=showOPDRegisterReport&flag=2');" />
 -->
 <input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
</form>

