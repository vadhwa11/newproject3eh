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
List<LocationParameterMapping>  mappingsList = new ArrayList<LocationParameterMapping>();
if(map.get("mappingsList") !=null){
	mappingsList=(List<LocationParameterMapping>)map.get("mappingsList");
}
List<MasVillage>village=new ArrayList<MasVillage>();
if(map.get("village") !=null){
	village=(List<MasVillage>)map.get("village");
}
List<MasDistrict> district = new ArrayList<MasDistrict>();
if(map.get("district") !=null){
	district=(List<MasDistrict>)map.get("district");
}
String flag="";
if(map.get("flag")!=null){
	flag=(String)map.get("flag");
}
System.out.println("mappingsList.size()=---- jsp ---->"+mappingsList.size());
%>
 <div id="parameterDiv">
 <div id="teDivss">
 <div class="clear"></div>
 <div class="clear"></div>
 
 <%-- <label>Village</label>
 <select id="village" name="village">
 <option valu="0">Select</option>
 <%for(MasVillage vill:village){ %>
<option valu="<%=vill.getId()%>"><%=vill.getVillageName() %></option> 
 
 <%} %>
 </select> --%>
 
 <label>District</label><select name="distr" id="distr" onblur="submitProtoAjaxWithDivNameToShowStatus('phMapping','/hms/hms/pubHealth?method=getTalukListForVillageMapping&flag=<%=flag %>&district='+this.value,'tDiv');" >
<option value="0">Select</option>
<%	if(district.size() >0){%>
				 <%
				 for (MasDistrict dis : district) {
					
				  %>
				  <option value="<%=dis.getId ()%>"><%=dis.getDistrictName()%></option>
				  <%
				  	 	}}
				   %>

</select>
<div id="tDiv">
 <label>Taluk</label>
<select>
   <option value="0">Select</option>  
</select>
<div class="clear"></div>
 <label>village</label>
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
 <div class="clear"></div>
 
 
<%-- <label>Locality</label>

<select name="paramId" id="paramId"  multiple="multiple" size="3" class="listBig3">
<%	
System.out.println("masloc.size() ----->>"+village.size());
if(masloc.size() >0){ %>
			
				
				 <%
				 for (PhMasLocality phMaloc : masloc) {
				  %>
				  <option value="<%=phMaloc.getId()%>"><%=phMaloc.getLocalityName()%></option>
				  <%
				  	 	}}else if(village.size()>0){
				  	 		for(MasVillage village1:village){
				   %>
				  <option value="<%=village1.getId()%>"><%=village1.getVillageName()%></option> 
				   <%} }%>

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
				  <option value="<%=parlia.getId ()%>"><%=parlia.getLocality().getLocalityName()%></option>
				  <%
					}else if(parlia.getVillage()!=null){%>
				 <option value="<%=parlia.getId ()%>"><%=parlia.getVillage().getVillageName()%></option>		
						
					<%}	}
				   %>
               <% }%>
 
     
</select> --%>
</div>
</div>

 
