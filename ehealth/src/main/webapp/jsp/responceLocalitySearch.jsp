<%@page import="jkt.hms.masters.business.LocationParameterMapping"%>
<%@page import="jkt.hms.masters.business.PhMasLocality"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
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
List<PhMasLocality> masloc = new ArrayList<PhMasLocality>();
if(map.get("masloc") !=null){
	masloc=(List<PhMasLocality>)map.get("masloc");
}

%>

 <div id="teDivss">

<label>Locality</label>

<select name="localityId" id="localityId" " >
<%	
if(null !=masloc && masloc.size() >0){ %>
			
				<option value="0">Select</option>
				 <%
				 for (PhMasLocality phMaloc : masloc) {
					 if(null !=phMaloc.getLocalityName()){
				  %>
				  <option value="<%=phMaloc.getId()%>"><%=phMaloc.getLocalityName()%></option>
				  <%
					 }}
				 
}else{%>
			  <option value="">No Record Found</option>
<%} %>

</select>


</div>

 
