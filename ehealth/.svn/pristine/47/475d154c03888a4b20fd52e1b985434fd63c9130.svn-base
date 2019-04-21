<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="jkt.hms.masters.business.PhAtpJphnJhiDetails"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.PhAtpJphnJhiHeader"%>
<%@page import="jkt.hms.masters.business.PhDayBlock"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script type="text/javascript">

       <%
               Calendar calendar=Calendar.getInstance();
               String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
               String curDate=String.valueOf(calendar.get(Calendar.DATE));
               int year=calendar.get(calendar.YEAR);
               if(month.length()<2){
                       month="0"+month;
               }
               if(curDate.length()<2){
                       curDate="0"+curDate;
               }

       %>
               serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<%
       Map<String, Object> map = new HashMap<String, Object>();
       if (request.getAttribute("map") != null) {
               map = (Map<String, Object>) request.getAttribute("map");
       }
       Map<String,Object> utilMap = new HashMap<String,Object>();
       utilMap = (Map)HMSUtil.getCurrentDateAndTime();
       String date = (String)utilMap.get("currentDate");
       String time = (String)utilMap.get("currentTime");
       String userName = "";
       if (session.getAttribute("userName") != null) {
               userName = (String) session.getAttribute("userName");
       }
       List<Object[]> phAtpJphnJhiDetailsList = new ArrayList<Object[]>();
       if(map.get("phAtpJphnJhiDetailsList") != null){
    	   phAtpJphnJhiDetailsList = (List<Object[]>)map.get("phAtpJphnJhiDetailsList");
  	 	}

       List<PhDayBlock> dayBlockList = new ArrayList<PhDayBlock>();
       if(map.get("phDayBlockList") != null){
   		dayBlockList = (List<PhDayBlock>)map.get("phDayBlockList");
  	 	}
       
       List<MmMasRequestStatus> mmMasRequestStatusList = new ArrayList<MmMasRequestStatus>();
       if(map.get("mmMasRequestStatusList") != null){
    	   mmMasRequestStatusList = (List<MmMasRequestStatus>)map.get("mmMasRequestStatusList");
  	 	}
       String remarksHeader ="";
  	 	int status=0;
  	 	String supervision="";
  	 	
        System.out.println("supervision"+supervision);
        System.out.println("status"+status);
        System.out.println("remarksHeader"+remarksHeader);
        
        System.out.println("phAtpJphnJhiDetailsList"+phAtpJphnJhiDetailsList.size());
  
   		
%>
      
     
<div id="testDiv">
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
	  	</td>   
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




<%-- 	


<%
 
	for(Object[] pd : phAtpJphnJhiDetailsList){ 
		if(pd[23]!=null)
		{
    remarksHeader=(String)pd[23];
		}
		if(pd[24]!=null)
		{
  			status=(Integer)pd[24];
  	        System.out.println("status"+status);
		}
		if(pd[13]!=null)
		{
  			supervision=(String)pd[13];
		}
  System.out.println("supervision"+supervision);

  %>
 <tr> 
  <td>
     
       <input type="hidden" value="<%=pd[19]%>" name="detId" id="detId" />
       <input type="hidden" value="<%=pd[20]%>" name="hdrId" id="hdrId" />   
      <%if(pd[0]!=null){ %>
      <%=HMSUtil.convertDateToStringWithoutTime((Date)pd[0])%>
      	
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
      <%if(pd[7]!=null){ %>
      <%=pd[7]%>
      <%}else{%>
		-
      <%} %>
	   </td>
	      <td>
      <%if(pd[8]!=null){ %>
      <%=pd[8]%>
      <%}else{%>
		-
      <%} %>
	   </td>
	      <td>
      <%if(pd[9]!=null){ %>
 <%=pd[9] %>
      <%}else{%>
		-
      <%} %>
	   </td>
	      <td>
      <%if(pd[10]!=null){ %>
<%=pd[10] %>
      <%}else{%>
		-
      <%} %>
	   </td>
	      <td>
      <%if(pd[11]!=null){ %>
   <%=pd[11] %>
      <%}else{%>
		-
      <%} %>
	   </td>
	  	   
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
   
       <%}%> --%>
       
       </table>
    
     
       
<!--  ====================================================End cash voucher table==============================-->

       
       
       
       <div class="Block">
       
       
       <label>Remarks</label>
       <%

       
       if(remarksHeader!=null){ %>
           <textarea rows="" cols="" name="remarksHdr"   id="remarksHdr"><%=remarksHeader %> </textarea>
           <%}else{ %>
           <textarea rows="" cols="" name="remarksHdr"   id="remarksHdr"> </textarea>
           <%} %>
      
       
        <label>ATP Status</label>
        <select name="appStatus" id="appStatus" >
       <option value="0">Select</option>
       <%for(MmMasRequestStatus mmMasRequestStatus :mmMasRequestStatusList){%>
          <%if(status!=0 && mmMasRequestStatus.getId().equals(status)){ 
        	  System.out.println("status name"+status);
          
          %>
          <option value="<%=mmMasRequestStatus.getId() %>" selected="selected"><%=mmMasRequestStatus.getStatusName() %></option>
          <%}else{ %>
       		<option value="<%=mmMasRequestStatus.getId() %>"><%=mmMasRequestStatus.getStatusName() %></option>
    	<%}} %>
       </select> 
       
        </div>
        
        



<div class="clear"></div>


 <input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('cashVoucher','pubHealth?method=submitAtpJphnJhiApproval');" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />


 <%}else{ %>
 <h2> Not Record found</h2>
 <%} %>

</div>
 <div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %> </label>

<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
 <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
  <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
   <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>



<div class="clear"></div>
<div class="clear"></div>


</div>