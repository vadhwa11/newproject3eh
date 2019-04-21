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
List<PhAtpJphnJhiDetails> atpJphnJhiDetails= new ArrayList<PhAtpJphnJhiDetails>();
if(map.get("atpJphnJhiDetails") !=null){
	atpJphnJhiDetails=(List<PhAtpJphnJhiDetails>)map.get("atpJphnJhiDetails");
}

String remarksHeader ="";
	int status=0;
	String supervision="";
	
System.out.println("supervision"+supervision);
System.out.println("status"+status);
System.out.println("remarksHeader"+remarksHeader);

%>
<div class="Clear"></div>
<div id="tDivss">

<table width="100%" border="0" cellspacing="0" cellpadding="0"  id="voucherDetails" class="cmntable">
       
		<tr>
		<th>Date</th>
		<th>Day Block</th>
		<th>Ward</th>
		<th>Status</th>
		<th></th>
		</tr>
		
   
        <%if(atpJphnJhiDetails.size()>0){ 
       for(PhAtpJphnJhiDetails pd : atpJphnJhiDetails){ %>
  <input type="hidden"  name="detId" value="<%=pd.getId() %>" />
     <tr>
       <td>
      <%if(pd.getDateAtp()!=null){ %>
      <%=pd.getDateAtp()%>
      	
      <%}else{%>
      	-
      <%} %>
	 </td>
	
	   <td>
      <%if(pd.getDayBlock()!=null){ %>
      <%=pd.getDayBlock().getForDay()%>
      <%}else{%>
	<td>-</td>
      <%} %>
	 	</td>
	<td>
	 <%
	 PhDayBlock ds=(PhDayBlock)pd.getDayBlock();
	 Set<String> wardNmae=new HashSet<String>();
	 Set<PhDayBlockDetail> dtail=(Set<PhDayBlockDetail>)ds.getPhDayBlockDetails();
	 for(PhDayBlockDetail vf:dtail) { 
	 if(vf.getWard()!=null){ 
		 if(vf.getWard().getWardName().equals(vf.getWard().getWardName())){ 
			 if(wardNmae.add(vf.getWard().getWardName())){
	 %>
      <%=vf.getWard().getWardName()%>
      <%}}}else{%>
		<td>-</td>
	      <%} }%>
	
	</td>
	
	 
	  <td>
	
    <select name="status" >
    <option value="">Select</option>
    <option value="sf">Satisfactory</option>
     <option value="ni">Needs Improvement</option>
      <option value="ns">Not Satisfactory</option>
    </select>  
	 </td>
  	   </tr>
  	   <%}
	      
       } else{%>
  	   <tr><td colspan="12"><h4> No Record Found </h4></td>
  	      </tr>
  	   <%} %>
  	
  </table>
  </div>
  
<input type="button"  class="button" name="Submit" value="Submit" onclick="submitForm('observation','/hms/hms/pubHealth?method=submitStatus');">
 
 
  
  
  