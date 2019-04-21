<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<MasEmployee> empNameDepartmentList = new ArrayList<MasEmployee>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	int typeId=0;
	if(map.get("empNameDepartmentList")!=null)
	{
		empNameDepartmentList = (List<MasEmployee>)map.get("empNameDepartmentList");
	}
	if(map.get("departmentList")!=null)
	{
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	if(map.get("typeId")!=null)
	{
		typeId=(Integer)map.get("typeId");
	}
		
%>


<div id="forNameDept">
<% 
if (typeId==2)
{
for(MasEmployee emp : empNameDepartmentList)
{	
	
	%>
<label>Employee Name</label> <input type="text" id="name" name="name" value="<%= emp.getFirstName() %>" validate="Name,string,yes" />

<div class="clear"></div>
<div class="clear"></div>

<label>Department</label> 
<input type="hidden" name="departmentId" id="departmentId"  value="<%=emp.getDepartment().getId() %>" validate="Department,integer,yes" ></input>
<input type="text" name="departmentName" id="departmentName" value= "<%=emp.getDepartment().getDepartmentName() %>" validate="Department Name,string,yes" ></input>
<%
}}
else
{ %>
	<label>Employee Name</label> <input type="text" id="name" name="name" validate="Name,string,yes" />

	<div class="clear"></div>
	<div class="clear"></div>

	<label>Department</label> 
	
	<select name="departmentId" id="departmentId" validate="Type,string,yes" >
	    <option value="0">select</option>
		<% for (MasDepartment dept : departmentList) {%>
		<option value="<%=dept.getId()%>"><%=dept.getDepartmentName()%></option>
		
		
	<%}%>
	</select> 
<% 	
}
%>
</div>

  

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 