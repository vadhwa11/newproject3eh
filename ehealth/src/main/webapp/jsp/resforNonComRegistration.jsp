<%@page import="jkt.hms.masters.business.PhDiseaseRegistration"%>
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
<%@page import="jkt.hms.masters.business.PhBirthDeathReg"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<script type="text/javascript">
var nameArray= new Array();
</script>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<PhDiseaseRegistration> phNonComm= new ArrayList<PhDiseaseRegistration>();
if(map.get("phNonComm") !=null){
	phNonComm=(List<PhDiseaseRegistration>)map.get("phNonComm");
}
List<PhMemberSurvey> memId= new ArrayList<PhMemberSurvey>();
if(map.get("memId") !=null){
	memId=(List<PhMemberSurvey>)map.get("memId");
}
%>




  
     <select name="bName" id="bName" onchange="" multiple="multiple" style="height: 50px;" onclick="total();">
      <%	if(phNonComm.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (PhDiseaseRegistration tal : phNonComm) {
					 for(PhMemberSurvey se:memId){	
						 if(tal.getMemberId().toString().equals(se.getMemberId())){
				  %>
				  <option value="<%=se.getId()%>"><%=se.getName()%></option>
				  <%
					 }}	}}
				   %>
				
								</select>
								 <script type="text/javascript">	
		              <%
		              int m=0;
		              for (PhDiseaseRegistration rote : phNonComm) {
		            for(PhMemberSurvey name:memId){	
					if(rote.getMemberId().toString().equals(name.getMemberId())){  
		     			 %> 
		     			nameArray[<%=m%>]= new Array();
		     			nameArray[<%=m%>][0] = "<%=name.getId()%>";
		     			nameArray[<%=m%>][1] = "<%=name.getName()%>";
		     			
	     				<% 
					  m++;  
					}
		            } }%> 
            </script>   
				   

</select>
 

