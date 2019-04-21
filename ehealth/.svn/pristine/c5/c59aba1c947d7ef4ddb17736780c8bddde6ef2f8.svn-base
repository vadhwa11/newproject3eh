<%@page import="jkt.hms.masters.business.HospitalDoctorUnitM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitT"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.UserApplications"%>
<%@page import="jkt.hms.util.HospitalUnitDays" %>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<HospitalDoctorUnitM> hospitalDoctorUnitMList= new ArrayList<HospitalDoctorUnitM>();
if(map.get("hospitalDoctorUnitMList") !=null){
	hospitalDoctorUnitMList=(List<HospitalDoctorUnitM>)map.get("hospitalDoctorUnitMList");
	
}
List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
List<MasEmployee> empList = new ArrayList<MasEmployee>();



if(map.get("employeeDepartmentList") != null){
	employeeDepartmentList = (List<MasEmployeeDepartment>)map.get("employeeDepartmentList");
}
if(map.get("empList") != null){
	empList = (List<MasEmployee>)map.get("empList");
}
%>

	




<label>Unit Code<span>*</span></label>
<select id="unitCodeId"  name="unitCodeId"  tabindex=1  >
	<option value="0">Select</option>
	<%

	if(hospitalDoctorUnitMList.size()>0){
		for(HospitalDoctorUnitM empDep :hospitalDoctorUnitMList){%>
			
		<option value="<%=empDep.getId()%>" ><%=empDep.getUnitCode()%></option>
		
	<%}
		}%>
</select>

<input type="button" name="search" value="Search" class="button"  onclick="if(checkUnitCode()){submitProtoAjaxWithDivName('hospUnit','/hms/hms/hospital?method=showDataFromSearch','nameDiv');}"tabindex=1 /> 

<div id="nameDiv">		
<div class="clear"></div>

<h4>Create Hospital Unit</h4>
<div class="clear"></div>

<label>Deptartment<span>*</span></label>
<select id="empDeptId"  name="empDeptId"  tabindex=1 >
	<option value="0">Select</option>
	<%

	if(employeeDepartmentList.size()>0){
		for(MasEmployeeDepartment empDep :employeeDepartmentList){%>
			
		<option value="<%=empDep.getId() %>" ><%=empDep.getEmpDeptName()%></option>
		
	<%}
		}%>
</select>

<label>Unit Code<span>*</span></label>
<input id="unitCode" type="text"   name="unitCode" value=""   tabindex=1 />


<div class="clear"></div>
<!-- changed by srikanth start -->
			<div>
			<%
			for(HospitalUnitDays day:HospitalUnitDays.values()){
				%>
				
					<label class="medium1" style=" margin-right:20px">
					<input type="checkbox" name="unitradio" id="<%=day.getLabelValue()%>" value="<%=day.getLabelValue()%>" class="checkboxMargin" />
					<%=day.getLabelName()%></label>
			<% }%>
			</div>
			<!-- changed by srikanth end -->

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="cmntable" style="width:890px;float:left;">
<table width="100%" border="0" cellspacing="0" cellpadding="0"  id="empDetails">
	<tr>
		<th scope="col"></th>
		<th scope="col">Employee Name</th>
		<th scope="col">Designation</th>
		<th scope="col">Head</th>
		
	</tr>

   <%int i = 1;%>
	<tr>
	<td><input type="radio" value="<%=i%>" name="selectedChrage"  class="radioAuto" /></td>
	
	
	<td>
	<select id="empNameId<%=i%>"  name="empNameId<%=i%>"  tabindex=1  onblur="populateRankDesignation(this.value,<%=i%>);">
	<option value="0">Select</option>
	<%

	if(empList.size()>0){
		for(MasEmployee emp :empList){%>
			
		<option value="<%=emp.getId() %>" ><%=emp.getEmployeeName()%></option>
		
	<%}
		}%>
	</select>
	
	</td>
	<td id="testDiv<%=i%>"> <input  type="text"   id="desigation<%=i%>"   name="desigation<%=i%>" value=""  readonly="readonly"  size="30"/>
		<input type="hidden" value="0" name="huDId<%=i %>" id="huDId<%=i %>" />
	</td>

	<td> <input id="head<%=i%>"   name="head" value="y"  type="checkbox" class="radioCheck"  MAXLENGTH="8" tabindex=1 onclick="validateCheckBoxForHead(this,<%=i%>);"/>
	<input type="hidden" name="hiddenHeadValue<%=i %>" id="hiddenHeadValue<%=i%>" value=""/>
	
	</td>
	</tr>
	</table>
	</div>
	
	<div class="floatRight" style="margin-right:150px;">
	<input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" />
	<input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
	<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
	<input type="hidden" value="0" name="huMId" id="huMId" />
</div>
<div class="clear"></div>	
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('hospUnit','hospital?method=submitHospitalUnit&flag=s','validateHeader');" accesskey="a" tabindex=1 />
 <input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="" accesskey="u" tabindex=1 />
  <input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="" accesskey="d" tabindex=1 />
  <input type="reset" name="Reset" id="reset"  value="Reset" class="button" onclick="resetCheck();" accesskey="r" />


</div>
