<%@page import="jkt.hms.masters.business.LocationParameterMapping"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
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
List<MasTaluk> talukList = new ArrayList<MasTaluk>();
if(map.get("talukList") !=null){
	talukList=(List<MasTaluk>)map.get("talukList");
}
List<MasWard> ward = new ArrayList<MasWard>();
if(map.get("ward") !=null){
	ward=(List<MasWard>)map.get("ward");
}
List<MasLsg> lsg = new ArrayList<MasLsg>();
if(map.get("lsg") !=null){
	lsg=(List<MasLsg>)map.get("lsg");
}
List<MasVillage> village = new ArrayList<MasVillage>();

if(map.get("village") !=null){
	village=(List<MasVillage>)map.get("village");
}
List<LocationParameterMapping> mappingsList = new ArrayList<LocationParameterMapping>();
if(map.get("mappingsList") !=null){
	mappingsList=(List<LocationParameterMapping>)map.get("mappingsList");
}
String flag="";
if(map.get("flag") !=null){
	flag=(String)map.get("flag");
	
}
%>
 <div id="parameterDiv">
 <div id="tDivs">
<div class="clear"></div>

 <label>village</label>
 <%if(null !=village){ %>
<select name="paramId" id="paramId" multiple="multiple" size="3" class="listBig3">
				<option value="0">Select</option>
				<%for(MasVillage masVillage:village){ %>
				<option value="<%=masVillage.getId ()%>"><%=masVillage.getVillageName()%></option>
				<%}} %>
</select> 
<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>
<%if(null !=mappingsList && mappingsList.size()>0){ %>
<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
   <%for(LocationParameterMapping lpm:mappingsList){ %>
   <option value="<%=lpm.getVillage().getId ()%>"><%=lpm.getVillage().getVillageName()%></option>
 <%}%>    
</select>

<%}else{ %>
<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
<!-- <option value=""></option> -->
</select>
<%} %>
</div>
</div>
<input type="hidden" name="basicSec"  value="village"/>


