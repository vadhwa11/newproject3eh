<%@page import="jkt.hms.masters.business.LocationParameterMapping"%>
<%@page import="jkt.hms.masters.business.PhMasElectricalSection"%>
<%@page import="jkt.hms.masters.business.MasLsg"%>
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
List<PhMasElectricalSection> masElSection = new ArrayList<PhMasElectricalSection>();
if(map.get("masElSection") !=null){
	masElSection=(List<PhMasElectricalSection>)map.get("masElSection");
}
List<LocationParameterMapping>  mappingsList = new ArrayList<LocationParameterMapping>();
if(map.get("mappingsList") !=null){
	mappingsList=(List<LocationParameterMapping>)map.get("mappingsList");
}

%>

 <div id="tDivss">
 
 <label>Electrical Section</label>
<select name="paramId" id="paramId"  multiple="multiple" size="7"  class="listBig3">
<%	if(masElSection.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (PhMasElectricalSection phElSection : masElSection) {
					
				  %>
				  <option value="<%=phElSection.getId ()%>"><%=phElSection.getElectricalSectionName()%></option>
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
					if(parlia.getElectricalSection()!=null){
				  %>
				  <option value="<%=parlia.getId ()%>"><%=parlia.getElectricalSection().getElectricalSectionName()%></option>
				  <%
					}	}
				   %>
               <% }%>
 
     
</select>
</div>



