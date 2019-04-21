<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%><%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

//List<MasInstituteDepartment> masInstituteDepartmentEmpList = new ArrayList<MasInstituteDepartment>();
List<Object[]> empSCMappingStringList = new ArrayList<Object[]>();

/* if(map.get("masInstituteDepartmentEmpList")!= null){
	masInstituteDepartmentEmpList = (List<MasInstituteDepartment>)map.get("masInstituteDepartmentEmpList");
} */
if(map.get("empSCMappingStringList")!= null){
	empSCMappingStringList = (List)map.get("empSCMappingStringList");
}
int scId=0;
if(empSCMappingStringList.size() > 0){
	for(Object[] obj:empSCMappingStringList){
		 scId = (Integer)obj[1];
		
	}
}

List<MasInstituteDepartment> instDeptList = new ArrayList<MasInstituteDepartment>();

 if(map.get("instDeptList")!= null){
	instDeptList = (List<MasInstituteDepartment>)map.get("instDeptList");
}
 
 List<MasEmployee> employeeByCategoryList = new ArrayList<MasEmployee>();
 

 if(map.get("employeeByCategoryList")!= null){
	 employeeByCategoryList = (List<MasEmployee>)map.get("employeeByCategoryList");
}
 /*
int scId=0;
if(map.get("scId")!=null){
	 scId=(Integer)map.get("scId");
}  */
%>








  <div id="inst">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3">
     <%for(MasEmployee md : employeeByCategoryList){ %>
     <option value="<%=md.getId()%>"><%=md.getEmployeeName()%></option>
     <%} %> 
</select>


<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3" >
<%if(empSCMappingStringList.size()>0){ %>
       <%for(Object[] d : empSCMappingStringList){ 
    	   
       %>
            	 <option value="<%=d[0]%>" selected><%=d[2]%></option>
   					<%} %>
   					<%} %>
</select>



<div class="clear"></div>
<div class="clear"></div>
 
<labelWithoutBox> </labelWithoutBox>
<labelWithoutBox> </labelWithoutBox>
<labelWithoutBox> </labelWithoutBox>

<%if(empSCMappingStringList.size()>0){ %>

  <input type="hidden" value="<%=scId%>" name="scId"/>
  <input type="button" class="button" name="Assign" value="Update" onclick="if(chk()){submitForm('task','/hms/hms/generalMaster?method=saveEmpSCMapping');}">
  <%}else{ %>
    <input type="hidden" value="0" name="scId"/>
  <input type="button" class="button" name="Assign" value="Save" onclick="if(chk()){submitForm('task','/hms/hms/generalMaster?method=saveEmpSCMapping');}">
<% }%> 

</div>





