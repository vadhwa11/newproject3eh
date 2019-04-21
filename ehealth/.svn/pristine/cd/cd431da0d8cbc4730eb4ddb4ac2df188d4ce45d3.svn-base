<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%><%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

List<MasEmployeeDepartment> empDeptHospList = new ArrayList<MasEmployeeDepartment>();

if(map.get("empDeptHospList")!= null){
	empDeptHospList = (List<MasEmployeeDepartment>)map.get("empDeptHospList");
}


List<MasEmployeeDepartment> employeeDepartmentHosList = new ArrayList<MasEmployeeDepartment>();

if(map.get("employeeDepartmentHosList")!= null){
	employeeDepartmentHosList = (List<MasEmployeeDepartment>)map.get("employeeDepartmentHosList");
}

int hrInsitEmpDepId=0;
if(map.get("hrInsitEmpDepId")!=null){
	 hrInsitEmpDepId=(Integer)map.get("hrInsitEmpDepId");
} 
%>








  <div id="inst">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3">
    <%for(MasEmployeeDepartment md : empDeptHospList){ %>
     <option value="<%=md.getId()%>"><%=md.getEmpDeptName()%></option>
     <%} %>
</select>


<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3" >
<%if(employeeDepartmentHosList.size()>0){ %>
       <%for(MasEmployeeDepartment d : employeeDepartmentHosList){ %>
            	 <option value="<%=d.getId()%>" selected="selected"><%=d.getEmpDeptName()%></option>
   					<%} %>
   					<%} %>
</select>

<div class="clear"></div>
<div class="clear"></div>
 
<labelWithoutBox> </labelWithoutBox>
<labelWithoutBox> </labelWithoutBox>
<labelWithoutBox> </labelWithoutBox>

<%if(employeeDepartmentHosList.size()>0){ %>

  <input type="hidden" value="<%=hrInsitEmpDepId%>" name="hrInsitEmpDepId"/>
  <input type="button" class="button" name="Assign" value="Edit Move" onclick="if(chk()){submitForm('task','/hms/hms/generalMaster?method=saveInstWiseEmpDept&flag=u');}">
  <%}else{ %>
    <input type="hidden" value="0" name="hrInsitEmpDepId"/>
  <input type="button" class="button" name="Assign" value="Save" onclick="if(chk()){submitForm('task','/hms/hms/generalMaster?method=saveInstWiseEmpDept&flag=s');}">
<% }%> 

</div>





