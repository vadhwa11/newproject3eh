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
%>
 
<div id="testDivs">
  
	<label><span>*</span>New Taluk</label>
	<select name="taluk" id="taluk"  validate="New Taluk,string,yes" onchange="submitProtoAjaxWithDivNameToShowStatus('detail','/hms/hms/pubHealth?method=getVillageForTransferedMemberList&taluk='+this.value,'tDivs');" >
      <%	if(talukList.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasTaluk tal : talukList) {
					
				  %>
				  <option value="<%=tal.getId ()%>"><%=tal.getTalukName()%></option>
					  <%
				  	 	}
}else{
%>
		<option value="0">No Data</option>					 
	<%			 
}
				   %>

</select>
 <div id="tDivs">

			

		 <label><span>*</span>New Village</label>
				<select name="village" id="village" validate="New Village,string,yes">
					<option value="0">Select</option>	
			</select>

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



