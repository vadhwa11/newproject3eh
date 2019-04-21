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
List<MasWard> ward = new ArrayList<MasWard>();
if(map.get("ward") !=null){
	ward=(List<MasWard>)map.get("ward");
}
%>
 <div id="parameterDiv">
 <div id="tDivss">
  
<label>Ward</label><select name="ward" id="ward" onchange="submitProtoAjaxWithDivNameToShowStatus('phMapping','/hms/hms/pubHealth?method=getlocalityList&ward='+this.value,'teDivss');" >
<%	if(ward.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasWard wa : ward) {
					
				  %>
				  <option value="<%=wa.getId()%>"><%=wa.getWardName()%></option>
				  <%
				  	 	}}
				   %>

</select>


<div id="teDivss">
<div class="clear"></div>
<label>Locality</label>
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


