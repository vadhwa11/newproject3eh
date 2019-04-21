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
 <div id="parameterDiv">
 <div id="tDivs">
  
<%-- <label>Village</label><select name="village" id="village" onchange="submitProtoAjaxWithDivNameToShowStatus('phMapping','/hms/hms/pubHealth?method=getElectrickSectionList&village='+this.value,'tDivss');" >
<%	if(village.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasVillage val : village) {
					
				  %>
				  <option value="<%=val.getId()%>"><%=val.getVillageName()%></option>
				  <%
				  	 	}}
				   %>

</select>
 --%>
<div class="clear"></div>
<div id="tDivss">


<div class="clear"></div>
<label>Electrical Section</label>
<select name="paramId" id="paramId" multiple="multiple" size="3" class="listBig3">
				<option value="0">Select</option>
</select>


<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
     
</select>
</div>
</div>
</div>


