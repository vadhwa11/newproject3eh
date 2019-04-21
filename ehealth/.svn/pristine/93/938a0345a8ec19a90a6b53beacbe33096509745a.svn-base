<%@page import="jkt.hms.masters.business.LocationParameterMapping"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<Object[]> subCentreList = new ArrayList<Object[]>();
if(map.get("subCentreList") !=null){
	subCentreList=(List<Object[]>)map.get("subCentreList");
}


%>


<div id="teDivss">

	<label><span>*</span>New Sub Center</label>
			 <select name="subcenter" id="subcenter" validate="New Sub Center,string,yes">
			 			
			 <%	if(subCentreList.size() >0){%>
			
					<option value="0">Select</option>
	
				 <%
				 for (Object[]  wa : subCentreList) {
					
				  %>
				  <option value="<%=wa[0]%>"><%=wa[1]%></option>
								  <%
				  	 	}
}else{
%>
		<option value="0">No Data</option>					 
	<%			 
}
				   %>

</select>
</div>




