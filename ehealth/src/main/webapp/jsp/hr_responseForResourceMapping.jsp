<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject>projectList = new ArrayList<MstrProject>();
				List<PrjRoleResMappingHeader> roleResourceMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("roleResourceMappingHeaderList")!= null){
					roleResourceMappingHeaderList = (List)map.get("roleResourceMappingHeaderList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				
				
				String message = "";
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
				Integer empId = 0;
				String[] empIds = new String[roleResourceMappingHeaderList.size()];
				if(roleResourceMappingHeaderList.size()>0){
					int i =0 ;
					for(PrjRoleResMappingHeader prjRoleResMappingHeader :roleResourceMappingHeaderList){
						empId = prjRoleResMappingHeader.getEmployee().getId();
						empIds[i] = empId.toString();
						i++;
					}
					
				}
				
				
	%>
	






<%@page import="jkt.hrms.masters.business.PrjRoleResMappingHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<select id="empId"  name="<%=EMPLOYEE_ID%>" validate="Project,string,yes" multiple="multiple" size="3" class="list"  >
<option value="0">Select</option>
<%
	for(MasEmployee masEmployee : employeeList){
	%>

	<option id="<%=masEmployee.getId() %>" value="<%=masEmployee.getId() %>" ><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName() %></option>
	<%
	}
		 %>
</select>
<script>
<%
for(MasEmployee masEmployee : employeeList){
	
	for(int j=0;j<empIds.length; j++){
		if(masEmployee.getId() == Integer.parseInt(empIds[j])){
			%>
			document.getElementById(<%=Integer.parseInt(empIds[j])%>).selected = true;
			
		<%}
	}
}
%>

</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
