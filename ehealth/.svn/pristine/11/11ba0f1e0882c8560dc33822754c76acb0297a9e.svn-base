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
List<PhVillageSurvey> villageDetail = new ArrayList<PhVillageSurvey>();
if(map.get("villageDetail") !=null){
	villageDetail=(List<PhVillageSurvey>)map.get("villageDetail");
}


%>

 
 
 <div id="tDivss">
 <div class="Block">
<%if(villageDetail.size()>0){ %>
<table>
	<tr><th>S No.</th><th>Name</th><th>Address</th><th>Contact No</th></tr>

	<% 
		 int  counter=1; 
 		for(PhVillageSurvey survey:villageDetail){ 
 			if(survey.getPlaceName() != null && !survey.getPlaceName().equals("")) {
	%> 
			<tr>
		    <td><%=counter %></td>
		    <td><%= survey.getPlaceName()%></td>
		    <td><%= survey.getAddress() != null ? survey.getAddress() : ""%></td>
		    <td><%= survey.getContactNo() != null ? survey.getContactNo() : ""%> </td>
		     </tr>
<%		++counter;
				} 
 		}
 	%> 
	</table>
	<%}else{ %>
	No Records Available.
	<%} %>
	</div> 


<div class="clear"></div>


</div>



 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 