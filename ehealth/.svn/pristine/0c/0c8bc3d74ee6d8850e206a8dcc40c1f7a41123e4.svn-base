<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<MasInstituteDepartment>list= new ArrayList<MasInstituteDepartment>();
if(map.get("departmentList") != null){
	list = (List)map.get("departmentList");
}
String referType = "";
if(map.get("referType") != null){
	referType = (String)map.get("referType");
}


%>
<option value='0'>Select</option>
<%	

if(list.size() !=0){
	Integer dept=0;
	//Changed by Arbind on 15-03-2017
		/* if(session.getAttribute("deptId")!=null){
				dept=(Integer)session.getAttribute("deptId");
		} */
	if(map.get("deptId") != null){
		dept = (Integer) map.get("deptId");
	}
	if(referType.equals("referInternal")){
		for (MasInstituteDepartment msd :list) {
	  	MasDepartment masDepartment=msd.getDepartment();
%>	
		<option value="<%=masDepartment.getId()%>" ><%=masDepartment.getDepartmentName()%></option>
	<%}%>
<%}else if(referType.equals("referExternal")){
	for (MasInstituteDepartment msd :list) {
	  	MasDepartment masDepartment=msd.getDepartment();
%>
	<%if(dept.equals(masDepartment.getId())){%>		
	    <option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{%>
		<option value="<%=masDepartment.getId()%>" ><%=masDepartment.getDepartmentName()%></option>
	<%}%>


<%}} else if(referType.equals("referInternalRecall")){  //Added by Arbind on 15-03-2017
	for (MasInstituteDepartment msd :list) {
	  	MasDepartment masDepartment=msd.getDepartment();
%>
	<%if(dept.equals(masDepartment.getId())){%>		
	    <option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{%>
		<option value="<%=masDepartment.getId()%>" ><%=masDepartment.getDepartmentName()%></option>
	<%}%>


<%}}}%>


