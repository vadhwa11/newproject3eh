
<%@page import="jkt.hms.masters.business.PhClassDetails"%>
<%@page import="jkt.hms.masters.business.PhVillageSurvey"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

List<Object[]> phAtpJphnJhiDetailsLists = new ArrayList<Object[]>();
if(map.get("phAtpJphnJhiDetailsList") != null){
	   phAtpJphnJhiDetailsLists = (List<Object[]>)map.get("phAtpJphnJhiDetailsList");
	}

%>
<div id="testDivs">
<div class="Clear"></div>

      <%-- <%if(phAtpJphnJhiDetailsLists.size()==0){%>  --%>

 <input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="if(checkField()){submitProtoAjaxWithDivName('cashVoucher','/hms/hms/pubHealth?method=submitAtpJphnJhi','testDiv');}" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<%-- <%} %> --%>
<div class="Clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"      id="voucherDetails" class="cmntable">
       <tr>
   		<th scope="col">Date</th>
		<th scope="col" colspan="4"  align="right">Pending Day Block</th>
		<th scope="col" colspan="4" align="right">Current Day Block</th>
		<th scope="col">Routine Activities</th>
		<th scope="col">Other Activities</th>
		<th scope="col">After Noon Activities</th>
		<th scope="col">Remarks</th>
		<th scope="col">Status</th>
			<!-- <th scope="col">Flag Consecutive Visit</th> -->
        
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
		 <th></th>
		</tr>
		
		
		       
               
       </tr>
   
        <%if(phAtpJphnJhiDetailsLists.size()>0){ 
       for(Object[] pd : phAtpJphnJhiDetailsLists){ %>
  
     <tr>
  <td>
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
      </td>
	  	   
	   <td>
	   <%if(pd[13]!=null){ %>
      <%=pd[13]%>
      <%}else{%>
		-
      <%} %>
	   </td>
	    <td>
	   <%if(pd[14]!=null){ %>
      <%=pd[14]%>
      <%}else{%>
		-
      <%} %>
	
      <%--    <td>
      <%if(pd.getDateAtp()!=null){ %>
      <%=HMSUtil.convertDateToStringWithoutTime(pd.getDateAtp())%>
      	
      <%}else{%>
      	-
      <%} %>
	 </td>
	   <td>
      <%if(pd.getPendingDayBlock()!=null && pd.getPendingDayBlock().getForDay()!=null){ %>
      <%=pd.getPendingDayBlock().getForDay()%>
      <%}else{%>
		-
      <%} %>
	 	</td>
      <td>
      <%if(pd.getPendingDayBlock()!=null && pd.getPendingDayBlock().getHouseId()!=null){ %>
      <%=pd.getPendingDayBlock().getHouseId()%>
      <%}else{%>
		-
      <%} %>
	   </td>
	   
	<td>-</td>    
	<td>-</td>
	  <td>
      <%if(pd.getDayBlock()!=null && pd.getDayBlock().getForDay()!=null){ %>
      <%=pd.getDayBlock().getForDay()%>
      <%}else{%>
		-
      <%} %>
	 	</td>
  <td>
      <%if(pd.getDayBlock()!=null && pd.getDayBlock().getHouseId()!=null){ %>
      <%=pd.getDayBlock().getHouseId()%>
      <%}else{%>
		-
      <%} %>
	 	</td> 
   
	<td>-</td>    
	<td>-</td>        
<td>
      <%if(pd.getRoutineActivity()!=null){%>
       Meeting 1
       <%}else{ %>
    -
       <%} %>
       </td> 
<td>
      <%if(pd.getOtherActivity()!=null){%>
       Training
       <%}else{ %>
    -
       <%} %>
       </td>   
<td>
      <%if(pd.getAfterNoonActivity()!=null){%>
        Training
       <%}else{ %>
    -
       <%} %>
       </td>    
	<td>
      <%if(pd.getRemarks()!=null){%>
       <%=pd.getRemarks() %>
       <%}else{ %>
    -
       <%} %>
       </td>    
  --%>
  	   </tr>
  	   <%}} else{%>
  	   <tr><td colspan="12"><h4> No Record Found </h4></td>
  	      </tr>
  	   <%} %>
  	
  </table>
  
  </div>



	
