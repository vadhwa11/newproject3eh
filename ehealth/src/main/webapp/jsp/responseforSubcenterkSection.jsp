<%@page import="jkt.hms.masters.business.MasHospital"%>
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

List<LocationParameterMapping> phMasLocalityList = new ArrayList<LocationParameterMapping>();
if(map.get("phMasLocalityList") !=null){
	phMasLocalityList=(List<LocationParameterMapping>)map.get("phMasLocalityList");
}

List<MasHospital > subcenterList = new ArrayList<MasHospital>();
if(map.get("subcenterList") !=null){
	subcenterList=(List<MasHospital>)map.get("subcenterList");
}


%>

 <div id="parameterDiv">
 <div class="clear"></div>
  <div id="teDivss">

<select name="paramId" id="paramId"  multiple="multiple" size="7" class="listBig3">
<%	if(subcenterList.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasHospital hs : subcenterList) {
					
				  %>
				  <option value="<%=hs.getId ()%>"><%=hs.getHospitalName()%></option>
				  <%
				  	 	}}
				   %>

</select>


<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
  <%	    if(phMasLocalityList.size() >0){%>
			
				
	
				 <%
				 for (LocationParameterMapping lo : phMasLocalityList) {
					 if(lo.getSubCentre()!=null){
				  %>
				  <option value="<%=lo.getSubCentre().getId ()%>"><%=lo.getSubCentre().getHospitalName()%></option>
				  <%
					 }	}}
				   %>

</select>   


</div>

<input type="hidden" name="basicSec" value="subcenterdelete"/>


