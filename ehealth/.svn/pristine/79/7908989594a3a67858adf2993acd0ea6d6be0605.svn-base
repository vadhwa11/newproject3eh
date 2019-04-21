<%@page import="jkt.hms.masters.business.PhAtpJphnJhiDetails"%>
<%@page import="jkt.hms.masters.business.PhDayBlock"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.PhAtpJphnJhiHeader"%>


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
     var nameArray= new Array();
     var dayArray= new Array();
     var nameCArray= new Array();
     var	blockArray= new Array();         
               
               
</script>
<form name="cashVoucher" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
       List<PhAtpJphnJhiHeader> atpJphnJhiHeaders = new ArrayList<PhAtpJphnJhiHeader>();
       if(map.get("atpJphnJhiHeaders") != null){
    	   atpJphnJhiHeaders = (List<PhAtpJphnJhiHeader>)map.get("atpJphnJhiHeaders");
     	 	}
       List<PhAtpJphnJhiDetails> atpJphnJhiDetails = new ArrayList<PhAtpJphnJhiDetails>();
       if(map.get("atpJphnJhiDetails") != null){
    	   atpJphnJhiDetails= (List<PhAtpJphnJhiDetails>)map.get("atpJphnJhiDetails");
    	   System.out.println(atpJphnJhiDetails.size());
       }
       
   
      if(map.get("date")!=null){
    	Date bockDate=(Date)map.get("date");  
   	   System.out.println(bockDate);
      }
       
       
       List<PhDayBlock> dayBlockList = new ArrayList<PhDayBlock>();
       if(map.get("phDayBlockList") != null){
   		dayBlockList = (List<PhDayBlock>)map.get("phDayBlockList");
  	 	}
       
     
     
String message = "";
       if(map.get("message") != null){
               message = (String)map.get("message");
               %>
<h4><span><%=message %></span></h4>
       <%}
%>
 <%int i = 1;
  i=Integer.parseInt(request.getParameter("rowval"));
 %>
       <td><input type="radio" value="" name="selectedChrage" class="radioCheck" /></td>
      
 <td>
  
<input  id="dateAtp<%=i%>" name="dateAtp<%=i%>" class="auto" type="text" maxlength="30" readonly="readonly" value="<%=request.getParameter("dateAtp"+i) %>"  size="10"  onblur="if(checkField()){submitProtoAjaxWithDivNameToShowStatus('cashVoucher','pubHealth?method=getDtailThroughDate&rowval=<%=i %>','tr<%=i%>');}"/>
<img width="16" height="16" border="0" onclick="javascript:setdate('cashVoucher',document.cashVoucher.dateAtp<%=i%>,event)"  src="/hms/jsp/images/cal.gif">
</img>		
		</td>

		<td>
<select id="jphnNameCv<%=i%>"  name="jphnNameCv<%=i%>" validate="Jphn Name,string,no" onchange="onGroupChange(this.value)" tabindex=1 >
	
	
	                   <option value="">Select</option>
									<% 
									
						             for ( PhAtpJphnJhiDetails phDetail: atpJphnJhiDetails){
						           if(phDetail.getSupervision()!=null){
						        	 if(phDetail.getSupervision().equalsIgnoreCase("c")){	%>
         <option value="<%=phDetail.getId()%>"><%=phDetail.getAtpHeader().getAshaWorker().getEmployeeName()%></option>  
						        
						        
						           
						             <%
						           }  
						      	 }
						           }%> 
						            

								</select>
								<%-- <script type="text/javascript">	
		              <%
		              PhAtpJphnJhiHeader  route = new PhAtpJphnJhiHeader();
		              int m=0;
					     for (int k = 0; k < atpJphnJhiHeaders.size(); k++) {
					    	 route = (PhAtpJphnJhiHeader) atpJphnJhiHeaders.get(k);
					    	 Set<PhAtpJphnJhiDetails> atpJphnJhiDetails1=route.getPhAtpJphnJhiDetails();
					    	 for(PhAtpJphnJhiDetails details:atpJphnJhiDetails1){
					      if(details.getSupervision()!=null){ 
						 if (details.getSupervision().equalsIgnoreCase("c")){ 
							 System.out.println(details.getSupervision());
		     			 %> 
		     			nameArray[<%=m%>]= new Array();
		     			nameArray[<%=m%>][0] = "<%=route.getId()%>";
		     			nameArray[<%=m%>][1] = "<%=route.getAshaWorker().getEmployeeName()%>";
		     			
	     				<% 
	     				m++;
						  }
					    	 }
					    	 }
					    	 }%> 
            </script> --%>
								
								
	

	</td>
	
<td>
<select id="dayBlockIdCv<%=i%>"  name="dayBlockIdCv<%=i%>" validate="Day Block,string,no" tabindex=1 >
	<option value="0">Select</option>
		<% 
									
						             for ( PhAtpJphnJhiDetails phDetail: atpJphnJhiDetails){
						           if(phDetail.getSupervision()!=null){
						        	 if(phDetail.getSupervision().equalsIgnoreCase("c")){	%>
           <option value="<%=phDetail.getId()%>"><%=phDetail.getDayBlock().getForDay()%></option>  
						        
						        
						           
						             <%
						           }  
						      	 }
						           }%> 
						            
				<%-- 					
	                 <script type="text/javascript">
	                
		              <%
		              PhAtpJphnJhiHeader  headerSr = new PhAtpJphnJhiHeader();
		              int s=0;
					     for (int j = 0; j < atpJphnJhiHeaders.size(); j++) {
					    	 headerSr = (PhAtpJphnJhiHeader) atpJphnJhiHeaders.get(j);
					    	 Set<PhAtpJphnJhiDetails> atpJphnJhiDetails2=headerSr.getPhAtpJphnJhiDetails();
					    	 for(PhAtpJphnJhiDetails details:atpJphnJhiDetails2){
					  if(details.getSupervision()!=null && details.getSupervision().equalsIgnoreCase("c")){
		     			 %> 
		     			dayArray[<%=s%>]= new Array();
		     			dayArray[<%=s%>][0] = "<%=details.getId()%>";
		     			dayArray[<%=s%>][1] = "<%=details.getDayBlock().getForDay()%>";
	     				<% 
					    	s++;	
					    	 }
					    	 }
					    	 }%> 
            </script>
	                     --%>
	
	
</select>
	</td>

		<td>
<select id="jphnNameC<%=i%>"  name="jphnNameC<%=i%>" validate="Day Block,string,no" onchange="onGroupChange(this.value)" tabindex=1 >
	
	
	<option value="">Select</option>
							<% 
									
						             for ( PhAtpJphnJhiDetails phDetail: atpJphnJhiDetails){
						           if(phDetail.getSupervision()!=null){
						        	 if(phDetail.getSupervision().equalsIgnoreCase("cv")){	%>
         <option value="<%=phDetail.getId()%>"><%=phDetail.getAtpHeader().getAshaWorker().getEmployeeName()%></option>  
						        
						        
						           
						             <%
						           }  
						      	 }
						           }%> 
						            
								</select>
				<%-- 								
	                 <script type="text/javascript">
	                
		              <%
		              PhAtpJphnJhiHeader  HeaderScr = new PhAtpJphnJhiHeader();
					     for (int j = 0; j < atpJphnJhiHeaders.size(); j++) {
					    	 headerSr = (PhAtpJphnJhiHeader) atpJphnJhiHeaders.get(j);
					    	 Set<PhAtpJphnJhiDetails> atpJphnJhiDetails3=headerSr.getPhAtpJphnJhiDetails();
					    	 for(PhAtpJphnJhiDetails details:atpJphnJhiDetails){
					  if(details.getSupervision()!=null && !details.getSupervision().equalsIgnoreCase("c")){
		     			 %> 
		     			nameCArray[<%=j%>]= new Array();
		     			nameCArray[<%=j%>][0] = "<%=HeaderScr.getId()%>";
		     			nameCArray[<%=j%>][1] = "<%=HeaderScr.getAshaWorker().getEmployeeName()%>";
	     				<% 
					    		
					    	 }
					    	 }
					    	 }%> 
            </script> --%>
								
								
	

	</td>
		
	
			<td>
<select id="jphnNameCv<%=i%>"  name="dayBlockC<%=i%>" validate="Day Block,string,no" tabindex=1 >
	
	
	<option value="">Select</option>
						<% 
									
						             for ( PhAtpJphnJhiDetails phDetail: atpJphnJhiDetails){
						           if(phDetail.getSupervision()!=null){
						        	 if(phDetail.getSupervision().equalsIgnoreCase("cv")){	%>
           <option value="<%=phDetail.getId()%>"><%=phDetail.getDayBlock().getForDay()%></option>  
						        
						        
						           
						             <%
						           }  
						      	 }
						           }%> 

								</select>
					<%-- 			
								  <script type="text/javascript">
	              
		              <%
		              PhAtpJphnJhiHeader  headerSc = new PhAtpJphnJhiHeader();
					     for (int j = 0; j < atpJphnJhiHeaders.size(); j++) {
					    	 headerSc = (PhAtpJphnJhiHeader) atpJphnJhiHeaders.get(j);
					    	 Set<PhAtpJphnJhiDetails> atpJphnJhiDetails4=headerSc.getPhAtpJphnJhiDetails();
					    	 for(PhAtpJphnJhiDetails details:atpJphnJhiDetails4){
					  if(details.getSupervision()!=null && !details.getSupervision().equalsIgnoreCase("cv")){
		     			 %> 
		     			blockArray[<%=j%>]= new Array();
		     			blockArray[<%=j%>][0] = "<%=details.getId()%>";
		     			blockArray[<%=j%>][0] = "<%=details.getDayBlock().getForDay()%>";


	     				<% 
					    		
					    	 }
					    	 }
					    	 }%> 
            </script>
								 --%>
	

	</td>
		
	
	
	
	
	
		<td>
<select name="routineActivity<%=i%>" name="routineActivity<%=i%>">
<option value="">Select</option>
<option value="m">Meeting 1</option>
</select>
	</td>
	
			<td>
<select name="otherActivity<%=i%>" name="otherActivity<%=i%>">
<option value="" >Select</option>
<option value="t">Training</option>
</select>
	</td>
	
    
	       <td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
