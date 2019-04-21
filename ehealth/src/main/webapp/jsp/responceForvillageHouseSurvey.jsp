<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
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
List<MasVillage> village = new ArrayList<MasVillage>();
if(map.get("village") !=null){
	village=(List<MasVillage>)map.get("village");
}
%>

 <div id="testDiv">

<label><span>*</span> Village</label>
<select name="village" id="village" >
<option value="">Select</option>
<%	if(village.size() >0){%>
				
				 <%
				 for (MasVillage val : village) {

				  %>
				  <option value="<%=val.getId()%>"><%=val.getVillageName()%></option>
				  <%
				  	 	}}
				   %>

</select>

</div>


