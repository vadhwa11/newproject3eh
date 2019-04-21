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
List<MasVillage> villageList = new ArrayList<MasVillage>();
if(map.get("villageList") !=null){
	villageList=(List<MasVillage>)map.get("villageList");
}
%>
 <div id="tDivs">
  
<label><span>*</span>New Village</label><select name="village" id="village" validate="New Village,string,yes" onchange="submitProtoAjaxWithDivNameToShowStatus('detail','/hms/hms/pubHealth?method=getWardForTransferedMemberList&village='+this.value,'tDivss');" >
				<option value="0">Select</option>
<%	if(villageList.size() >0){%>
			

	
				 <%
				 for (MasVillage val : villageList) {
					
				  %>
				  <option value="<%=val.getId()%>"><%=val.getVillageName()%></option>
				  <%
				  	 	}
}else{
%>
		<option value="0">No Data</option>					 
	<%			 
}
				   %>

</select>

<div class="clear"></div>
<div id="tDivss">
 <div class="clear"></div>
			<label><span>*</span>New Ward</label>
			 <select name="ward" id="ward" validate="New Ward,string,yes">
			 	<option value="0">Select</option>	
			</select>
				
		<label><span>*</span>New Sub Center</label>
			 <select name="subcenter" id="subcenter" validate="New Sub Center,string,yes">
			 	<option value="0">Select</option>	
			</select>




</div>
</div>


