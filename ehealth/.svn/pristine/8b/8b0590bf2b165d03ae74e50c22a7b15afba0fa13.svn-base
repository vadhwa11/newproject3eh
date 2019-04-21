<%@page import="jkt.hms.masters.business.PhMasElectricalSection"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.LocationParameterMapping"%>
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
List<PhMasElectricalSection>electricSectionList=new ArrayList<PhMasElectricalSection>();
if(map.get("electricSectionList") !=null){
	electricSectionList=(List<PhMasElectricalSection>)map.get("electricSectionList");
}
System.out.println("electricSectionList  size in jsp-->"+electricSectionList.size());
List<LocationParameterMapping> phMasLocalityList = new ArrayList<LocationParameterMapping>();
if(map.get("phMasLocalityList") !=null){
	phMasLocalityList=(List<LocationParameterMapping>)map.get("phMasLocalityList");
}
%>
 <div id="parameterDiv">
 <div id="tDiv">
  
<%-- <label>Taluk</label><select name="taluk" id="taluk" onchange="submitProtoAjaxWithDivNameToShowStatus('phMapping','/hms/hms/pubHealth?method=getvilageElSectionList&taluk='+this.value,'tDivs');" >
      <%	if(talukList.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasTaluk tal : talukList) {
					
				  %>
				  <option value="<%=tal.getId ()%>"><%=tal.getTalukName()%></option>
				  <%
				  	 	}}
				   %>

</select> --%>
 <div id="tDivs">

<!-- <label>Village</label>
<select name="village" id="village">
				<option value="0">Select</option>
</select>
 -->

<div class="clear"></div> 
<label>Electrical Section </label>
<select name="paramId" id="paramId" multiple="multiple" size="3" class="listBig3">
				<option value="0">Select</option>
				<%for(PhMasElectricalSection elecSection:electricSectionList){ %>
				<option value="<%=elecSection.getId()%>"><%= elecSection.getElectricalSectionName()%></option>
				<%} %>
</select>


<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>


<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
<%if(null !=phMasLocalityList && phMasLocalityList.size()>0) {
for(LocationParameterMapping locationMapping:phMasLocalityList){
	if(null !=locationMapping.getElectricalSection()){
%>
<option value="<%=locationMapping.getElectricalSection().getId()%>"><%= locationMapping.getElectricalSection().getElectricalSectionName()%></option>
<%} }}%>
     
</select>
</div>
</div>
</div>
<input type="hidden" name="basicSec"  value="electricSection"/>

