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

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
		<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
	
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<PhMasLocality> masloc = new ArrayList<PhMasLocality>();
if(map.get("masloc") !=null){
	masloc=(List<PhMasLocality>)map.get("masloc");
}
List<LocationParameterMapping>  mappingsList = new ArrayList<LocationParameterMapping>();
if(map.get("mappingsList") !=null){
	mappingsList=(List<LocationParameterMapping>)map.get("mappingsList");
}
List<MasVillage>village=new ArrayList<MasVillage>();
if(map.get("village") !=null){
	village=(List<MasVillage>)map.get("village");
}

%>
 <div id="parameterDiv">
 <div id="teDivss">
 <div class="clear"></div>

<label>Locality</label>

<select name="paramId" id="paramId"  multiple="multiple" size="3" class="listBig3">
<%  if(null !=masloc && masloc.size() >0){ %>
			
				
				 <%
				 for (PhMasLocality phMaloc : masloc) {
					 if(null !=phMaloc.getLocalityName()){
				  %>
				  <option value="<%=phMaloc.getId()%>"><%=phMaloc.getLocalityName()%></option>
				  <%
					 }}}%>

</select>
<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
 <%	if(mappingsList.size() >0){  %>
			
				 <%
				 for (LocationParameterMapping parlia : mappingsList) {
					if(parlia.getLocality()!=null){
						
				  %>
				  <option value="<%=parlia.getLocality().getId ()%>"><%=parlia.getLocality().getLocalityName()%></option>
				  <%
					}}
				   %>
               <% }%>
 
     
</select>
</div>
</div>
<input type="hidden" name="basicSec"  value="localilty"/>
 
