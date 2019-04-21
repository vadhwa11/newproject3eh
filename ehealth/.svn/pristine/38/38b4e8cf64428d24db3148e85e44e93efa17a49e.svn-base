
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<Object[]> labWorksheetList = new ArrayList<Object[]>();
if(map.get("labWorksheetList") != null){
	labWorksheetList = (List<Object[]>)map.get("labWorksheetList");
	}


System.out.println("labWorksheetList"+labWorksheetList.size());



%>


<div id="testDiv">
<div class="Block">
  <div id="pageNavPosition"></div>


<% 	   if(labWorksheetList.size()>0){  %>

<table width="100%" border="0" cellspacing="0" cellpadding="0"    class="cmntable">
   <tr>
   		<th>Sl</th>
   		<th>Sample</th>
		<th>Name</th>
		<th>Age</th>
		<th>Gender</th>
		<th>UHID</th>
		<th>Doctor</th>
		<th>Investigation</th>
		<th>Priority</th>
		<th>Status</th>
		</tr>
		
		
		       
            <tbody id="tableData">
       
<%
int i=1;
	for(Object[] pd : labWorksheetList){ 
	

  %>
 <tr>
 <td><%=i%></td> 
  <td>
     
          
      <%if(pd[7]!=null){ %>
      <%=pd[7]%>
      	
      <%}else{%>
      	-
      <%} %>
	 </td>
	   <td>
      <%if(pd[1]!=null){ %>
      <%=pd[1]%>
      <%}else{%>
		-
      <%} %>
	 	</td>
      <td>
      <%if(pd[2]!=null){ %>
      <%=pd[2]%>
      <%}else{%>
		-
      <%} %>
	   </td>
	 <td>
      <%if(pd[3]!=null){ %>
      <%=pd[3]%>
      <%}else{%>
		-
      <%} %>
	 	</td>
      <td>
      <%if(pd[4]!=null){ %>
      <%=pd[4]%>
      <%}else{%>
		-
      <%} %>
	   </td>
	   <td>
      <%if(pd[3]!=null){ %>
      <%=pd[3]%>
      <%}else{%>
		-
      <%} %>
	 	</td>
      <td>
      <%if(pd[5]!=null){ %>
      <%=pd[5]%>
      <%}else{%>
		-
      <%} %>
	   </td>
	 <td>
      <%if(pd[6]!=null){ %>
      <%=pd[6]%>
      <%}else{%>
		-
      <%} %>
	 	</td>
     
      <td>
      <%if(pd[10]!=null){ %>
      <%=pd[10]%>
      <%}else{%>
		-
      <%} %>
	   </td>
	    
            </tr>
   
       <%i++; 
       }%>

</tbody>
       </table>
            	<script>
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
</script>
  <%}else{ %>
 <h2> Not Record found</h2>
 <%} %>
 </div>
  </div>
