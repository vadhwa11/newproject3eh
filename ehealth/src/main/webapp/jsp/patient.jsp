<%@page import="jkt.hms.masters.business.Patient"%>
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
List<Patient>patient = new ArrayList<Patient>();
if(map.get("patientName") !=null){
	patient=(List<Patient>)map.get("patientName");
}
String patientName="";
	if(patient.size() !=0){



 for(Patient patient1 :patient){
 
  patientName=patient1.getPFirstName();
  System.out.println("patientName..........."+patientName);
  	 	}
  %>
  <script>
  document.getElementById("patientName").value=<%=patientName%>;
  </script>
 <%-- <input type="text" name="patientName" id="patientName"
			value="<%=patientName%>" MAXLENGTH="30"  />
 --%>
			
<%
}else{
	%>	
    <script>
  document.getElementById("patientName").value="";
  </script>
<%} %>



