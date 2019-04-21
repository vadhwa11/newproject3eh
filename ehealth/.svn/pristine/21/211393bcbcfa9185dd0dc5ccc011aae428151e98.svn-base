<%@page import="jkt.hms.masters.business.DgOrderhd"%>
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
List<DgOrderhd>dgOrderhdList = new ArrayList<DgOrderhd>();
if(map.get("dgOrderhdList") !=null){
	dgOrderhdList=(List<DgOrderhd>)map.get("dgOrderhdList");
}
%>



<label>Order No.</label>
<select name="orderId" id="orderId" >

<%	if(dgOrderhdList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%for(DgOrderhd dgOrderhd :dgOrderhdList){
				  %>
				  <option value="<%=dgOrderhd.getId ()%>"><%=dgOrderhd.getOrderNo()%></option>
				  <%
				  	 	}
				   %>
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>






