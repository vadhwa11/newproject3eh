<%@page import="jkt.hms.masters.business.MasHospital"%>
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
List<MasHospital>phcList = new ArrayList<MasHospital>();
if(map.get("phcList") !=null){
	phcList=(List<MasHospital>)map.get("phcList");
}
%>

<div id="testDiv">
<label> Primary Health Center</label> 
<select id="phcId"	name="phcId" validate="PHC,string,no" 	tabindex=1>
<%	if(phcList.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasHospital primaryHealthCenter : phcList) {
					
				  %>
				  <option value="<%=primaryHealthCenter.getId()%>"><%=primaryHealthCenter.getHospitalName()%></option>
				  <%
				  	 	}
				   %>
			
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>


	

</div>

<!-- <div id="categoryDiv">
<label>Item Category</label>
<select name="categoryId" id="categoryId" validate="Item Group,String,no" >
	<option value="0">Select</option>
</select>
<label>Item Class</label>
<select name="classId" id="classId" validate="Item Group,String,no" >
	<option value="0">Select</option>
</select>

</div>	
 -->


