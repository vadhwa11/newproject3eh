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
List<MasWard> wardList = new ArrayList<MasWard>();
if(map.get("wardList") !=null){
	wardList=(List<MasWard>)map.get("wardList");
}
%>
 
 <div id="tDivss">
  
	<label><span>*</span>New Ward</label>
	<select name="ward" id="ward" validate="New Ward,string,yes" onchange="submitProtoAjaxWithDivNameToShowStatus('detail','/hms/hms/pubHealth?method=getSubCentreForTransferedMemberList&ward='+this.value,'teDivss');" >
					<option value="0">Select</option>
<%	if(wardList.size() >0){%>
			
				
	
				 <%
				 for (MasWard wa : wardList) {
					
				  %>
				  <option value="<%=wa.getId()%>"><%=wa.getWardName()%></option>
				  <%
				  	 	}
}else{
%>
		<option value="0">No Data</option>					 
	<%			 
}
				   %>

</select>


<div id="teDivss">

	<label><span>*</span>New Sub Center</label>
			 <select name="subcenter" id="subcenter" validate="New Sub Center,string,yes">
			 	<option value="0">Select</option>	
			</select>	

</div>
</div>



