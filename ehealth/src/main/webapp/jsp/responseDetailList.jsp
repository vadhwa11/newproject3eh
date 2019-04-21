<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.PhAtpJphnJhiHeader"%>
<%@page import="jkt.hms.masters.business.PhVillageSurvey"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<Object[]> phAtpJphnJhiDetailsList = new ArrayList<Object[]>();
if(map.get("phAtpJphnJhiDetailsList") != null){
	   phAtpJphnJhiDetailsList = (List<Object[]>)map.get("phAtpJphnJhiDetailsList");
	}

String remarksHeader ="";
	int status=0;
	String supervision="";
	
System.out.println("supervision"+supervision);
System.out.println("status"+status);
System.out.println("remarksHeader"+remarksHeader);

System.out.println("phAtpJphnJhiDetailsList"+phAtpJphnJhiDetailsList.size());



%>
<div id="teDivs">

<% 	   if(phAtpJphnJhiDetailsList.size()>0){  %>
<table width="100%" border="0" cellspacing="0" cellpadding="0"      id="voucherDetails" class="cmntable">
   <tr>
   		<th scope="col">Date</th>
		<th scope="col" colspan="4"  align="right">Pending Day Block</th>
		<th scope="col" colspan="4" align="right">Current Day Block</th>
		<th scope="col">Routine Activities</th>
		<th scope="col">Other Activities</th>
		<th scope="col">After Noon Activities</th>
		<th scope="col">Supervision</th>
        
		</tr>
		<tr>
		<th></th>
		<th>Day Block</th>
		<th>No. of House</th>
		<th>Locality</th>
		<th>Ward</th>
		<th>Day Block</th>
		<th>No. of House</th>
		<th>Locality</th>
		<th>Ward</th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		</tr>
		
		
		       
               
       </tr>
       
<%
 
	for(Object[] pd : phAtpJphnJhiDetailsList){ 
		/* if(pd[23]!=null)
		{
    remarksHeader=(String)pd[23];
		}
		if(pd[24]!=null)
		{
  			status=(Integer)pd[24];
  	        System.out.println("status"+status);
		} */
		if(pd[8]!=null)
		{
  			supervision=(String)pd[8];
		}
  System.out.println("supervision"+supervision);

  %>
 <tr> 
  <td>
     
       <input type="hidden" value="<%=pd[0]%>" name="detId" id="detId" />
       <input type="hidden" value="<%=pd[1]%>" name="hdrId" id="hdrId" />   
      <%if(pd[6]!=null){ %>
      <%=HMSUtil.convertDateToStringWithoutTime((Date)pd[6])%>
      	
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
      <%if(pd[7]!=null){ %>
      <%=pd[7]%>
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
      <%if(pd[7]!=null){ %>
      <%=pd[7]%>
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
      <%if(pd[4]!=null){ %>
      <%=pd[4]%>
      <%}else{%>
		-
      <%} %>
	   </td>
	 
        <td>
      <%if(pd[10]!=null){
   if(pd[10].equals("m")){%>
       Meeting 1
      <%}}else{%>
		-
      <%} %>
	   </td>
	      <td>
      <%if(pd[11]!=null){ 
   if(pd[11].equals("t")){%>
      Training
      <%}}else{%>
		-
      <%} %>
	   </td>
	      <td>
      <%if(pd[12]!=null){
 if(pd[12].equals("t")){%>
    Training
      <%}}else{%>
		-
      <%} %>
	  	   
	   <td>
	   <select name="supervision">
	   
	   <option value="">Select</option>
	     <%if(!supervision.equalsIgnoreCase("") && supervision.equals("c")){ %>
	      <option value="c" selected="selected">Consecutive Visit</option>
	   <%}else if(!supervision.equalsIgnoreCase("") && supervision.equals("cv")){%>
	    
	   <option value="cv" selected="selected">Concurrent Visit</option>
	   <%}else{ %>
	   <option value="c">Consecutive Visit</option>
	    <option value="cv">Concurrent Visit</option>
	   <%} %>
	   </select>
	   
	   </td>
        </tr>
   
       <%}%>


       </table>
       
       
        <input type="button"  class="button" name="Submit" value="Submit" onclick="submitForm('approval','/hms/hms/pubHealth?method=submitHSAndMOapproval');">
  
       
  <%}else{ %>
 <h2> Not Record found</h2>
 <%} %>
 
  </div>
  
 