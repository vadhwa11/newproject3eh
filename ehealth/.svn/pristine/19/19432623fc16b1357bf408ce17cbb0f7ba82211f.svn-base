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

 <div id="talukDiv">
  
<label>Taluk</label><select name="taluk" id="taluk" onchange="submitProtoAjaxWithDivNameToShowStatus('search','/hms/hms/pubHealth?method=getVillageListHouseSurvey','tDivs');" >
   	<option value="0">Select</option>
   	   <%	if(talukList.size() >0){%>
	 <%
	 for (MasTaluk tal : talukList) {
	  %>
  <option value="<%=tal.getId ()%>"><%=tal.getTalukName()%></option>
		  <%
  	 	}}
	   %>

</select>
 

 
</div>


