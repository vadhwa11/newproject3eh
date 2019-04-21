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
List<PhMasParliyamentAssembly> parliament = new ArrayList<PhMasParliyamentAssembly>();
if(map.get("parliament") !=null){
	parliament=(List<PhMasParliyamentAssembly>)map.get("parliament");
}
List<LocationParameterMapping>  mappingsList = new ArrayList<LocationParameterMapping>();
if(map.get("mappingsList") !=null){
	mappingsList=(List<LocationParameterMapping>)map.get("mappingsList");
	//System.out.println(">>>JSPPPPPP>>>>"+mappingsList.size());
}



%>

 <div id="teDivss">
<select name="paramId" id="paramId"  multiple="multiple" size="7"  class="listBig3">
<%	if(parliament.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (PhMasParliyamentAssembly parlia : parliament) {
					
				  %>
				  <option value="<%=parlia.getId ()%>"><%=parlia.getName()%></option>
				  <%
				  	 	}}
				   %>


</select>
<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
 <%	if(mappingsList.size() >0){%>
			
				 <%
				 for (LocationParameterMapping parlia : mappingsList) {
					if(parlia.getAssembly()!=null){
				  %>
				  <option value="<%=parlia.getAssembly().getId()%>"><%=parlia.getAssembly().getName()%></option>
				  <%
					}	}
				   %>
               <% }%>
 
     
</select>

</div>
<input type="hidden" name="basicSec"  value="Assemebly"/>


