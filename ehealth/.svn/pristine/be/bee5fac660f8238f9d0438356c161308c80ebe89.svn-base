<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@ page import="jkt.hms.masters.business.HospitalDoctorUnitT"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="jkt.hms.masters.business.MasStoreItem"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@ page import="jkt.hms.masters.business.MasIcd"%>
<%@ page import="jkt.hms.masters.business.UserApplications"%>
<%@page import="jkt.hms.util.HospitalUnitDays" %>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<HospitalDoctorUnitT> dataUnitTList= new ArrayList<HospitalDoctorUnitT>();
if(map.get("dataUnitTList") !=null){
	dataUnitTList=(List<HospitalDoctorUnitT>)map.get("dataUnitTList");
	
}
List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
List<MasEmployee> empList = new ArrayList<MasEmployee>();



if(map.get("employeeDepartmentList") != null){
	employeeDepartmentList = (List<MasEmployeeDepartment>)map.get("employeeDepartmentList");
}
if(map.get("empList") != null){
	empList = (List<MasEmployee>)map.get("empList");
}

int empDeptId=0;
int huMId=0;
String unitCode="";

String monday="";
String tuesday="";
String wednesday="";
String thursday="";
String friday="";
String saturday="";
String sunday="";

if(dataUnitTList.size()>0){
	for (HospitalDoctorUnitT h :dataUnitTList) {
	empDeptId=h.getUnitM().getEmpDept().getId();
	unitCode=h.getUnitM().getUnitCode();
	huMId=h.getUnitM().getId();
	
	if("y".equals(h.getUnitM().getMonday())){
		monday=HospitalUnitDays.MONDAY.getLabelValue();
	}if("y".equals(h.getUnitM().getTuesday())){
		tuesday=HospitalUnitDays.TUESDAY.getLabelValue();
	}if("y".equals(h.getUnitM().getWednesday())){
		wednesday=HospitalUnitDays.WEDNESDAY.getLabelValue();
	}if("y".equals(h.getUnitM().getThursday())){
		thursday=HospitalUnitDays.THURSDAY.getLabelValue();
	}if("y".equals(h.getUnitM().getFriday())){
		friday=HospitalUnitDays.FRIDAY.getLabelValue();
	}if("y".equals(h.getUnitM().getSaturday())){
		saturday=HospitalUnitDays.SATURDAY.getLabelValue();
	}if("y".equals(h.getUnitM().getSunday())){
		sunday=HospitalUnitDays.SUNDAY.getLabelValue();
	}
	
}
}
boolean headDocFlag=false;
if(map.get("headDocFlag")!=null){
	headDocFlag=Boolean.parseBoolean(map.get("headDocFlag").toString());
}
%>

	

<div id="nameDiv">
		
		<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="Block">
<h4>Create Hospital Unit </h4>
<div class="clear"></div>




<label>Deptartment<span>*</span></label>
<select id="empDeptId"  name="empDeptId"  tabindex=1 >
	<option value="0">Select</option>
	<%

	if(employeeDepartmentList.size()>0){
		for(MasEmployeeDepartment empDep :employeeDepartmentList)
		{
		if(empDeptId==empDep.getId()){
		
		%>
		<option value="<%=empDep.getId() %>" selected="selected" ><%=empDep.getEmpDeptName()%></option>
			<%}else{ %>
		<option value="<%=empDep.getId() %>" ><%=empDep.getEmpDeptName()%></option>
		
	<%}}
		}%>
</select>

<label>Unit Code<span>*</span></label>
<%if(unitCode!=""){ %>
<input id="unitCode" type="text"   name="unitCode" value="<%=unitCode%>"   tabindex=1 />
<%}else{ %>
<input id="unitCode" type="text"   name="unitCode" value=""   tabindex=1 />
<%} %>


</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<!-- changed by srikanth start -->
			<div>
			<%
			for(HospitalUnitDays day:HospitalUnitDays.values()){
				if(monday.equals(day.getLabelValue()) || tuesday.equals(day.getLabelValue()) ||
						wednesday.equals(day.getLabelValue())||thursday.equals(day.getLabelValue())
						||friday.equals(day.getLabelValue())||saturday.equals(day.getLabelValue())
						||sunday.equals(day.getLabelValue())){
					%>
					<input type="checkbox" name="unitradio" id="<%=day.getLabelValue()%>" checked
						value="<%=day.getLabelValue()%>" />
					<label  style="width:75px;margin-left: -134px"><%=day.getLabelName()%></label>
				<% 		
				}else{
				%>
				<input type="checkbox" name="unitradio" id="<%=day.getLabelValue()%>" 
						value="<%=day.getLabelValue()%>" />
					<label  style="width:75px;margin-left: -134px"><%=day.getLabelName()%></label>
			<% }
				}%>
			</div>
			<!-- changed by srikanth end -->

<table width="100%" border="0" cellspacing="0" cellpadding="0"  id="empDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Employee Name</th>
		<th scope="col">Designation</th>
		<th scope="col">Head</th>
		
	</tr>
  <%	
  int i = 1;
     	  
          
		for (HospitalDoctorUnitT hospitalDoctorUnitT :dataUnitTList) {
			
%>
	<tr>
	<td>
	<input type="radio" value="<%=i%>" name="selectedChrage"  class="radioAuto" />
	
	</td>
	
	
	<td>
	<select id="empNameId<%=i%>"  name="empNameId<%=i%>"  tabindex=1  onblur="populateRankDesignation(this.value,<%=i%>);">
	<option value="0">Select</option>
	<%

	if(empList.size()>0){
		for(MasEmployee emp :empList){
			if(hospitalDoctorUnitT.getEmployee().getId()==emp.getId()){
				
				
		%>
		<option value="<%=emp.getId() %>" selected="selected"><%=emp.getEmployeeName()%></option>
		<%}else{ %>	
		<option value="<%=emp.getId() %>" ><%=emp.getEmployeeName()%></option>
		<%} %>
	<%}
		}%>
	</select>
	
	</td>
	<td id="testDiv<%=i%>"> <input  type="text"   id="desigation<%=i%>"   name="desigation<%=i%>" value="<%=hospitalDoctorUnitT.getEmployee().getRank().getRankName()%>"  readonly="readonly"  size="30"/></td>
<input type="hidden" value="<%=hospitalDoctorUnitT.getId()%>" name="huDId<%=i %>" id="huDId<%=i %>" />
	<td>
<%if(headDocFlag){
if(hospitalDoctorUnitT.getHeadFleg()!=null && hospitalDoctorUnitT.getHeadFleg().equals("y")){%>
	<input id="head<%=i%>"   name="head" value="y"  type="checkbox" checked="checked" class="radioCheck"  MAXLENGTH="8" tabindex=1 onclick="validateCheckBoxForHead(this,<%=i%>);"/>
	<%}else{ %>
	<input id="head<%=i%>"   name="head" value="y"  type="checkbox" class="radioCheck"  MAXLENGTH="8" tabindex=1 onclick="validateCheckBoxForHead(this,<%=i%>);" disabled="disabled"/>
	<%} }else{%>
	<input id="head<%=i%>"   name="head" value="y"  type="checkbox" class="radioCheck"  MAXLENGTH="8" tabindex=1 onclick="validateCheckBoxForHead(this,<%=i%>);" />
	<%} %>
	<input type="hidden" name="hiddenHeadValue<%=i%>" id="hiddenHeadValue<%=i%>" value="" />
	
	</td>
	</tr>
  <%
  ++i;
		}%>

	</table>
	<input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" />
	<input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
	<input type="hidden" value="<%=i-1%>" name="hiddenValueCharge" id="hiddenValueCharge" />
	<input type="hidden" value="<%=huMId %>" name="huMId" id="huMId" />

	
<div class="clear"></div>


</div>
<input type="button" name="add" id="addbutton" value="Update" class="button" onClick="submitForm('hospUnit','hospital?method=submitHospitalUnit&flag=u','validateHeader');" accesskey="a" tabindex=1 />
 <input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="" accesskey="u" tabindex=1 />
  <input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="" accesskey="d" tabindex=1 />
  <input type="reset" name="Reset" id="reset"  value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
		