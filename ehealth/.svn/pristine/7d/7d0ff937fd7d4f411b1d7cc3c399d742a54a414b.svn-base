<%@page import="jkt.hms.masters.business.PhAntenatalRegistrationSurvey"%>
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
List<PhAntenatalRegistrationSurvey> phAnti= new ArrayList<PhAntenatalRegistrationSurvey>();
if(map.get("phAnti") !=null){
	phAnti=(List<PhAntenatalRegistrationSurvey>)map.get("phAnti");
}
List<PhMemberSurvey> memId= new ArrayList<PhMemberSurvey>();
if(map.get("memId") !=null){
	memId=(List<PhMemberSurvey>)map.get("memId");
}
%>




  
     <select name="bName" id="bName" onchange="" multiple="multiple" style="height: 50px;" onclick="total();">
      <%	if(phAnti.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (PhAntenatalRegistrationSurvey tal : phAnti) {
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
		              for (PhAntenatalRegistrationSurvey rote : phAnti) {
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
 

