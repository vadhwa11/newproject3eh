<%@page import="jkt.hms.masters.business.PhAtpJphnJhiHeader"%>
<%@page import="jkt.hms.masters.business.PhVillageSurvey"%>
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
List<PhAtpJphnJhiHeader> atpJphnJhiHeaders= new ArrayList<PhAtpJphnJhiHeader>();
if(map.get("atpJphnJhiHeaders") !=null){
	atpJphnJhiHeaders=(List<PhAtpJphnJhiHeader>)map.get("atpJphnJhiHeaders");
}


%>
 
 <div id="testDivs">
 <label>Name</label>
 <select name="nameId"  id="nameId" onchange="submitProtoAjaxWithDivName('approval','/hms/hms/pubHealth?method=getDetailByName','testDiv');">
 <option value="0">Select</option>
 <%
 if(atpJphnJhiHeaders.size()>0){
 for(PhAtpJphnJhiHeader list : atpJphnJhiHeaders){
	if(list.getApprovedBy()!=null) 	{ %>

 <option value="<%=list.getApprovedBy().getId()%>"><%=list.getApprovedBy().getEmployeeName()%></option>
 
 <%}}} %>
 </select>
 
 
	</div> 


<div class="clear"></div>
<div id="testDiv">


</div>


</div>



