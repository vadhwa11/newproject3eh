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
List<MasDistrict> masDistrict= new ArrayList<MasDistrict>();
if(map.get("masDistrict") !=null){
	masDistrict=(List<MasDistrict>)map.get("masDistrict");
}



%>


 <div id="parameterDiv">
 
 <label>District</label>
<select name="distId" id="distId" onchange="submitProtoAjaxWithDivNameToShowStatus('phMapping','/hms/hms/pubHealth?method=getAssamblyList&disId='+this.value,'teDivss');">
<%	if(masDistrict.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasDistrict parlia : masDistrict) {
					
				  %>
				  <option value="<%=parlia.getId ()%>"><%=parlia.getDistrictName()%></option>
				  <%
				  	 	}}
				   %>


</select>
 <div class="clear"></div>
 
  <div id="teDivss">

<select name="paramId" id="paramId"  multiple="multiple" size="7" class="listBig3">



</select>


<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
     
</select>
</div>
</div>




