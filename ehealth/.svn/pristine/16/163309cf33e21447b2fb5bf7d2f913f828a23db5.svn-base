<%@page import="jkt.hms.masters.business.LocationParameterMapping"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
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
List<MasPostCode> maspostCode = new ArrayList<MasPostCode>();
if(map.get("maspostCode") !=null){
	maspostCode=(List<MasPostCode>)map.get("maspostCode");
}
List<LocationParameterMapping>  mappingsList = new ArrayList<LocationParameterMapping>();
if(map.get("mappingsList") !=null){
	mappingsList=(List<LocationParameterMapping>)map.get("mappingsList");
}

%>

 <div id="parameterDiv">
<select name="paramId" id="paramId"  multiple="multiple" size="7"  class="listBig3">
<%	if(maspostCode.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasPostCode masPost : maspostCode) {
					
				  %>
				  <option value="<%=masPost.getId ()%>"><%=masPost.getPostCodeName()%></option>
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
					if(parlia.getPostCode()!=null){
				  %>
				  <option value="<%=parlia.getPostCode().getId ()%>"><%=parlia.getPostCode().getPostCodeName()%></option>
				  <%
					}	}
				   %>
               <% }%>
 
     
</select>


</div>
<input type="hidden" name="basicSec"  value="postOffice"/>


