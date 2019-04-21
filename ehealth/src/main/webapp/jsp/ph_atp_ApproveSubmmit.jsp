<%@page import="jkt.hms.masters.business.PhDayBlockDetail"%>
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

<%
       Map<String, Object> map = new HashMap<String, Object>();
       if (request.getAttribute("map") != null) {
               map = (Map<String, Object>) request.getAttribute("map");
       }
       Map<String,Object> utilMap = new HashMap<String,Object>();
       utilMap = (Map)HMSUtil.getCurrentDateAndTime();
       String date = (String)utilMap.get("currentDate");
       String time = (String)utilMap.get("currentTime");
       String currentDate = (String)utilMap.get("currentDate");
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
       List<PhAtpJphnJhiDetails> atpJphnJhiDetailsTable = new ArrayList<PhAtpJphnJhiDetails>();
       if(map.get("atpJphnJhiDetailsTable") != null){
    	   atpJphnJhiDetailsTable= (List<PhAtpJphnJhiDetails>)map.get("atpJphnJhiDetailsTable");
    	   System.out.println(atpJphnJhiDetailsTable.size());
       }
       
            
       
      String bockDate=null;
      if(map.get("date")!=null){
      bockDate= (String)map.get("date"); 
   	   System.out.println(date);
      }
       
       
       List<PhDayBlock> dayBlockList = new ArrayList<PhDayBlock>();
       if(map.get("phDayBlockList") != null){
   		dayBlockList = (List<PhDayBlock>)map.get("phDayBlockList");
  	 	}
       
       List<Object[]> phAtpJphnJhiDetailsList = new ArrayList<Object[]>();
       if(map.get("phAtpJphnJhiDetailsList") != null){
    	   phAtpJphnJhiDetailsList = (List<Object[]>)map.get("phAtpJphnJhiDetailsList");
  	 	}
     
String message = "";
       if(map.get("message") != null){
               message = (String)map.get("message");
               %>
<h4><span><%=message %></span></h4>
       <%}
%>
<div class="titleBg">
<h2>ATP PHN HI PHNS HS Plan</h2>
</div>
<div class="Block">
<form name="cashVouchers" method="post" action="">
<label><span>*</span> Month</label>
<select  validate="Month,string,no" name="atpJphniJhiMonths" class="medium2" >
<%
if(month.equalsIgnoreCase("08")){ %>
<option value="">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8" selected="selected"> August</option>
<option value="9">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
<%}else if(month.equalsIgnoreCase("09")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  selected="selected">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
<%}else if(month.equalsIgnoreCase("10")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" selected="selected">October</option>
<option value="11">November</option>
<option value="12">December</option>
<%}else if(month.equalsIgnoreCase("11")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" selected="selected">November</option>
<option value="12">December</option>
<%}else if(month.equalsIgnoreCase("12")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" selected="selected">December</option>
<%}else if(month.equalsIgnoreCase("01")){%>
<option value="">Select</option>
<option value="1"  selected="selected">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12">December</option>
<%}else if(month.equalsIgnoreCase("02")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" selected="selected">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" selected="selected">December</option>
<%}else if(month.equalsIgnoreCase("03")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" >February</option>
<option value="3" selected="selected">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" >December</option>

<%}else if(month.equalsIgnoreCase("04")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" >February</option>
<option value="3" >March</option>
<option value="4" selected="selected">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" >December</option>

<%}else if(month.equalsIgnoreCase("05")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" >February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5" selected="selected">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" >December</option>

<%}else if(month.equalsIgnoreCase("06")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" >February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5" >May</option>
<option value="6" selected="selected">June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" >December</option>

<%}else if(month.equalsIgnoreCase("07")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" >February</option>
<option value="3" >March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7" selected="selected">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" >December</option>
<%} %>
</select>

<label><span>*</span> From Date </label>
<input 	type="text" name="<%=FROM_DATE%>" id="fromDateId" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.cashVouchers.<%=FROM_DATE%>,event);" />
<label><span>*</span> To Date </label> <input type="text"
	class="date" name="<%=TO_DATE%>" id="toDateId"  value="<%=currentDate%>"
	validate="To Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.cashVouchers.<%=TO_DATE%>,event);" />

<input type="button" name="add" id="addbutton" value="View List" class="buttonBig"
	onClick="submitForm('cashVouchers','/hms/hms/pubHealth?method=showAtPhnJhiPrepairAndSubmmitJsp');"
	accesskey="a" tabindex=1 />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
<div class="Clear"></div>

<form name="cashVoucher" method="post" action="">
<div id="testDiv">

<table width="100%" border="0" cellspacing="0" cellpadding="0" id="voucherDetails" class="cmntable">
       <tr>
       	<th scope="col"></th>       		
       	<th scope="col"></th>
       	<th scope="col" colspan="2">Consecutive visit </th>
        <th scope="col" colspan="4">Concurrent visit </th>
        <th scope="col"></th>
       </tr> 
       <tr>
       <th></th>
		<th>Date</th>
		<th>JPHN Name</th>
		<th>Day Block</th>
		
		<th>JPHN Name</th>
		<th>Day Block</th>
		
		<th>Routine Activities</th>
		<th>Other Activities</th>
        <th></th>
       </tr>
       <%int i = 1;%>
       <tr id="tr<%=i%>">
       <td><input type="radio" value="" name="selectedChrage" class="radioCheck" /></td>      
 <td>  
<input  id="dateAtp<%=i%>" name="dateAtp<%=i%>" class="auto" type="text" maxlength="30" readonly="readonly" validate="Date,yes"  size="10" onblur="if(this.value!=''){if(checkField()){submitProtoAjaxWithDivNameToShowStatus('cashVoucher','pubHealth?method=getDtailThroughDate&rowval=<%=i %>','tr<%=i%>');}}"/>
<img width="16" height="16" border="0" onclick="javascript:setdate('cashVoucher',document.cashVoucher.dateAtp<%=i%>,event)"  src="/hms/jsp/images/cal.gif">
</img>		
		</td>
		<td>
<select id="jphnNameCv<%=i%>"  name="jphnNameCv<%=i%>" validate="Jphn Name,string,no" onchange="onGroupChange(this.value)" tabindex=1 >
<option value="">Select</option>
									<% 
									
						             for ( PhAtpJphnJhiHeader header: atpJphnJhiHeaders){
						            Set<PhAtpJphnJhiDetails> atpJphnJhiDetails1=header.getPhAtpJphnJhiDetails();
						               int id = header.getId ();
								       String name = header.getAshaWorker().getEmployeeName();
						            
						            for(PhAtpJphnJhiDetails detail:atpJphnJhiDetails1){%>
						          <%   if(detail.getSupervision()!=null){
						          	if(detail.getSupervision().equalsIgnoreCase("c")){%>
						           	<option value="<%=id%>"><%=name%></option> 
						            	<%  }
						            	 }
						            }
						            %>
											<%}%>

								</select>
								<script type="text/javascript">	
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
            </script>

	</td>
	
<td>
<select id="dayBlockIdCv<%=i%>"  name="dayBlockIdCv<%=i%>" validate="Day Block,string,no" tabindex=1 >
	<option value="0">Select</option>
		<% 
							
				             for ( PhAtpJphnJhiHeader header: atpJphnJhiHeaders){
				            Set<PhAtpJphnJhiDetails> atpJphnJhiDetails2=header.getPhAtpJphnJhiDetails();
				            
				            for(PhAtpJphnJhiDetails detail:atpJphnJhiDetails2){%>
				          <%   if(detail.getSupervision()!=null){
				          	if(detail.getSupervision().equalsIgnoreCase("c") && detail.getAtpHeader().getId().equals(header.getId())){%>
				    
				           	<option value="<%=detail.getId()%>"><%=detail.getDayBlock().getForDay()%></option> 
				           	      
				            	<% 
				            	
				          	}
				            	 }
				            }
				            %>
									<%}%>
									
	                 <script type="text/javascript">
	                
		              <%
		              PhAtpJphnJhiHeader  headerSr = new PhAtpJphnJhiHeader();
		              int s=0;
					     for (int j = 0; j < atpJphnJhiHeaders.size(); j++) {
					    	 route = (PhAtpJphnJhiHeader) atpJphnJhiHeaders.get(j);
					    	 Set<PhAtpJphnJhiDetails> atpJphnJhiDetails2=route.getPhAtpJphnJhiDetails();
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
	                    
	
	
</select>
	</td>

		<td>
<select id="jphnNameC<%=i%>"  name="jphnNameC<%=i%>" validate="Day Block,string,no" tabindex=1 >
	
	
	<option value="">Select</option>
						<% 
							
				             for ( PhAtpJphnJhiHeader header: atpJphnJhiHeaders){
				            Set<PhAtpJphnJhiDetails> atpJphnJhiDetails3=header.getPhAtpJphnJhiDetails();
				            
				            for(PhAtpJphnJhiDetails detail:atpJphnJhiDetails){%>
				          <%   if(detail.getSupervision()!=null){
				          	if(!detail.getSupervision().equals("c")){%>
				           	<option value="<%=header.getId ()%>"><%=header.getAshaWorker().getEmployeeName()%></option> 
				            	<%  }
				            	 }
				            }
				            %>
									<%}%>				

								</select>
												
	                 <script type="text/javascript">
	                
		              <%
		              PhAtpJphnJhiHeader  HeaderScr = new PhAtpJphnJhiHeader();
					     for (int j = 0; j < atpJphnJhiHeaders.size(); j++) {
					    	 int d=0;
					    	 route = (PhAtpJphnJhiHeader) atpJphnJhiHeaders.get(j);
					    	 Set<PhAtpJphnJhiDetails> atpJphnJhiDetails3=route.getPhAtpJphnJhiDetails();
					    	 for(PhAtpJphnJhiDetails details:atpJphnJhiDetails){
					  if(details.getSupervision()!=null && !details.getSupervision().equalsIgnoreCase("c")){
		     			 %> 
		     			nameCArray[<%=j%>]= new Array();
		     			nameCArray[<%=j%>][0] = "<%=HeaderScr.getId()%>";
		     			nameCArray[<%=j%>][1] = "<%=HeaderScr.getAshaWorker().getEmployeeName()%>";
	     				<% 
					    	d++;	
					    	 }
					    	 }
					    	 }%> 
            </script>
								
								
	

	</td>
		
	
			<td>
<select id="dayBlockC<%=i%>"  name="dayBlockC<%=i%>" validate="Day Block,string,no" tabindex=1 >
	
	
	<option value="">Select</option>
						<% 
							
				             for ( PhAtpJphnJhiHeader header: atpJphnJhiHeaders){
				            Set<PhAtpJphnJhiDetails> atpJphnJhiDetails4=header.getPhAtpJphnJhiDetails();
				            
				            for(PhAtpJphnJhiDetails detail:atpJphnJhiDetails4){%>
				          <%   if(detail.getSupervision()!=null){
				          	if(!detail.getSupervision().equalsIgnoreCase("c")){%>
				           	<option value="<%=detail.getId()%>"><%=detail.getDayBlock().getForDay()%></option> 
				            	<%  }
				            	 }
				            }
				            %>
									<%}%>	

								</select>
								
								  <script type="text/javascript">
	              
		              <%
		              PhAtpJphnJhiHeader  headerSc = new PhAtpJphnJhiHeader();
					     for (int j = 0; j < atpJphnJhiHeaders.size(); j++) {
					    	 route = (PhAtpJphnJhiHeader) atpJphnJhiHeaders.get(j);
					    	 Set<PhAtpJphnJhiDetails> atpJphnJhiDetails4=route.getPhAtpJphnJhiDetails();
					    	 for(PhAtpJphnJhiDetails details:atpJphnJhiDetails4){
					  if(details.getSupervision()!=null && !details.getSupervision().equalsIgnoreCase("c")){
		     			 %> 
		     			blockArray[<%=j%>]= new Array();
		     			blockArray[<%=j%>][0] = "<%=details.getId()%>";
		     			blockArray[<%=j%>][0] = "<%=details.getDayBlock().getForDay()%>";


	     				<% 
					    		
					    	 }
					    	 }
					    	 }%> 
            </script>

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
</tr>
</table>
<div class="Clear"></div>
<div class="floatRight" style="margin-right:15px;"><input type="button" name="delete" class="buttonDel" onClick="removeRow();" /></div>
       
<!--  ====================================================End cash voucher table==============================-->
<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />

<div class="Clear"></div>
<div id="testDivs">
<div id="pageNavPosition"></div>
        <%-- <%if(phAtpJphnJhiDetailsList.size()==0){%>  --%>

 <input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('cashVoucher','/hms/hms/pubHealth?method=addApproveSubmit');" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<%-- <%} %> --%>
<div class="Clear"></div>
<div class="paddingTop5"></div> 

<table width="100%" border="0" cellspacing="0" cellpadding="0"  id="voucherDetails" class="cmntable">
       <tr>
   		<th scope="col" colspan="1" align="right">Date</th>
		<th scope="col" colspan="5"  align="right">Consecutive visit</th>
		<th scope="col" colspan="5" align="right">Concurrent visit</th>
		<th scope="col">Routine Activities</th>
		<th scope="col">Other Activities</th>
	
		
	
			<!-- <th scope="col">Flag Consecutive Visit</th> -->
        
		</tr>
		<tr>
		<th></th>
		<th>JPHN</th>
		<th>Day Block</th>
		<th>Locality</th>
		<th>Ward</th>
		<th>Visit</th>
		<th>JPHN</th>
		<th>Day Block</th>
		<th>Locality</th>
		<th>Ward</th>
		<th>Visit</th>
		<th></th>
		<th></th>
		</tr>
	   
       </tr>
   <tbody id="tableData">
        <%if(atpJphnJhiDetailsTable.size()>0){ 
       for(PhAtpJphnJhiDetails pd : atpJphnJhiDetailsTable){ %>
  
     <tr>
  <td>
      <%if(pd.getDateAtp()!=null){ %>
      <%=pd.getDateAtp()%>
      	
      <%}else{%>
      	-
      <%} %>
	 </td>
	      
 <td>
 
	      <% PhAtpJphnJhiHeader hd=(PhAtpJphnJhiHeader)pd.getAtpHeader();
	     
	        if(hd.getAshaWorker()!=null){ %>
      <%=hd.getAshaWorker().getEmployeeName()%>
      <%} else{%>
		<td>-</td>
      <%} %>
	      

	   </td>
	   
	
	 
      <%if(pd.getDayBlock()!=null){ %>
     <td>   <%=pd.getDayBlock().getForDay()%></td>
      <%}else{%>
	<td>-</td>
      <%} %>
	 	
	 	
      <td>
	  <%
	  if(pd.getDayBlock()!=null){
	 PhDayBlock ds=(PhDayBlock)pd.getDayBlock();
	  Set<PhDayBlockDetail> dtail=(Set<PhDayBlockDetail>)ds.getPhDayBlockDetails(); 
	 Set<String> locName=new HashSet<String>();
	 for(PhDayBlockDetail vf:ds.getPhDayBlockDetails()) { 
	 if(vf.getLocality()!=null){ 
		 if(vf.getLocality().getLocalityName().equals(vf.getLocality().getLocalityName())){ 
			 if(locName.add(vf.getLocality().getLocalityName())){
	 %>
      <%=vf.getLocality().getLocalityName()%>
      <%}}}else{%>
		<td>-</td>
	      <%} }}%> 
	 	</td>
	 	
	 	  <td>
	 <%
	 if(pd.getDayBlock()!=null){
	 PhDayBlock ds4=(PhDayBlock)pd.getDayBlock();
	 Set<String> wardNmae=new HashSet<String>();
	 Set<PhDayBlockDetail> dtail4=(Set<PhDayBlockDetail>)ds4.getPhDayBlockDetails();
	 for(PhDayBlockDetail vf4:dtail4) { 
	 if(vf4.getWard()!=null){ 
		 if(vf4.getWard().getWardName().equals(vf4.getWard().getWardName())){ 
			 if(wardNmae.add(vf4.getWard().getWardName())){
	 %>
      <%=vf4.getWard().getWardName()%>
      <%}}}else{%>
		<td>-</td>
	      <%} }}%>
	 	</td>
	 	
	 	<td>
	 	 <%if(pd.getSupervision()!=null){
    	 if(pd.getSupervision().equalsIgnoreCase("cv")){ %>
    		Consecutive 
    	 
       <% } }%>
	   </td>
	   
	 	
     
	      <td>
	      <% PhAtpJphnJhiHeader heder1=(PhAtpJphnJhiHeader)pd.getAtpHeader();
	     
	        if(heder1.getAshaWorker()!=null){ %>
      <%=heder1.getAshaWorker().getEmployeeName()%>
      <%} else{%>
		<td>-</td>
      <%} %>
     
	   </td>
	   
	   <td>
	 	  <%if(pd.getDayBlock()!=null){ %>
      <%=pd.getDayBlock().getForDay()%>
      <%}else{%>
		-
      <%} %>
      
	 	</td>
	 	
	   
	   <td>
	 <%
	 if(pd.getDayBlock()!=null){
	 PhDayBlock ds2=(PhDayBlock)pd.getDayBlock();
	 Set<PhDayBlockDetail> dtail2=(Set<PhDayBlockDetail>)ds2.getPhDayBlockDetails();
	 Set<String> locName2=new HashSet<String>();
	 for(PhDayBlockDetail vf1:dtail2) { 
	 if(vf1.getLocality()!=null){ 
		 if(vf1.getLocality().getLocalityName().equals(vf1.getLocality().getLocalityName())){ 
			 if(locName2.add(vf1.getLocality().getLocalityName())){
	 %>
      <%=vf1.getLocality().getLocalityName()%>
      <%}}}else{%>
		<td>-</td>
	      <%} }}%>
	 	</td>
	   
	    	
	 	  <td>
	 <%
	 if(pd.getDayBlock()!=null){
	 PhDayBlock dsi=(PhDayBlock)pd.getDayBlock();
	 Set<String> wardName=new HashSet<String>();
	 Set<PhDayBlockDetail> dtaili=(Set<PhDayBlockDetail>)dsi.getPhDayBlockDetails();
	 for(PhDayBlockDetail vfi:dtaili) { 
	 if(vfi.getWard()!=null){ 
		 if(vfi.getWard().getWardName().equals(vfi.getWard().getWardName())){ 
			 if(wardName.add(vfi.getWard().getWardName())){
	 %>
      <%=vfi.getWard().getWardName()%>
      <%}}}else{%>
		<td>-</td>
	      <%} }}%>
	 	</td>
	   <td>
	 	 <%if(pd.getSupervision()!=null){
    	 if(pd.getSupervision().equalsIgnoreCase("c")){ %>
    		Concurrent
    	 
       <% } }%>
	   </td>
	   
	   
	      <td>
     <%if(pd.getRoutineActivity()!=null){ 
      if(pd.getRoutineActivity().equalsIgnoreCase("m")){ %>
      Meeting 1
      <%}}else{%>
		-
      <%} %>
      
	      
	   </td>
	      <td>
     <%if(pd.getOtherActivity()!=null){
    	 
    	 if(pd.getOtherActivity().equalsIgnoreCase("t")){ %>
       Training
      <%}}else{%>
		-
      <%} %>


	   </td>
	   
	<!--  <td></td>-->
	
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
  	   <%}
	      
       } else{%>
  	   <tr><td colspan="12"><h4> No Record Found </h4></td>
  	      </tr>
  	   <%} %>
  	
  </table>
 
 <script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		</script>
</div>
</div>

</form>
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


<script type="text/javascript">
var dayBlockArray =new Array();
</script>
<%  int j=0;
for(PhDayBlock phDayBlock:dayBlockList){
%>
<script>
			dayBlockArray[<%=j%>]= new Array();
			dayBlockArray[<%=j%>][0] = "<%=phDayBlock.getId()%>";
			dayBlockArray[<%=j%>][1] = "<%=phDayBlock.getForDay()%>";

		</script>
<%j++;} %>
<script type="text/javascript">
var dayBlockArrayP =new Array();
</script>
<%  int k=0;
for(PhDayBlock phDayBlockP:dayBlockList){
%>
<script>
dayBlockArrayP[<%=k%>]= new Array();
dayBlockArrayP[<%=k%>][0] = "<%=phDayBlockP.getId()%>";
dayBlockArrayP[<%=k%>][1] = "<%=phDayBlockP.getForDay()%>";

		</script>
<%k++;} %>

<script type="text/javascript">
function addRow(){
       var tbl = document.getElementById('voucherDetails');
       var lastRow = tbl.rows.length;

       var row = tbl.insertRow(lastRow);
       
       var hdb = document.getElementById('hiddenValueCharge');
       var iteration = parseInt(hdb.value)+1;
       hdb.value = iteration;
       row.id="tr"+iteration;

       var cell0 = row.insertCell(0);
       var e0 = document.createElement('input');
       e0.type = 'radio';
       e0.name='selectedChrage';
       e0.className='radioCheck';
       e0.value=(iteration);
       cell0.appendChild(e0);

       var cell1 = row.insertCell(1);
       var e1 = document.createElement('input');
       e1.type = 'text';
       e1.name='dateAtp'+(iteration);
       e1.size='10';
       e1.id='dateAtp'+(iteration);
       e1.className = 'auto';
       e1.size = '8';
       e1.value=''
       e1.onblur = function(event){if(checkField()){
    	   submitProtoAjaxWithDivNameToShowStatus('cashVoucher','pubHealth?method=getDtailThroughDate&rowval='+iteration,'tr'+iteration);}
    	   };
       var eImg = document.createElement('img');
       eImg.src = '/hms/jsp/images/cal.gif';
       eImg.style.display ='inline';
       eImg.onclick = function(event){
       setdate('',document.getElementById('dateAtp'+iteration),event) };
       cell1.appendChild(e1);
       cell1.appendChild(eImg);
         
       

      var cell2 = row.insertCell(2);
	  var e1 = document.createElement('Select');
	  e1.name='jphnNameCv'+iteration;
	  e1.style.width = "";
	  e1.options[0] = new Option('Select', '0');
	
	  if(document.getElementById("jphnNameCv")+iteration.value !== null){
	  for(var i = 0;i<nameArray.length;i++ ){
		  alert(nameArray.length);
		e1.options[i+1] = new Option(nameArray[i][1],nameArray[i][0]);
	  }
	  }
	  cell2.appendChild(e1);
	  
	  var cell3 = row.insertCell(3);
	  var e1 = document.createElement('Select');
	  e1.name='dayBlockIdCv'+iteration;
	  e1.style.width = "";
	  e1.options[0] = new Option('Select', '0');
	  for(var i = 0;i<dayArray.length;i++ ){
		 
		e1.options[i+1] = new Option(dayArray[i][1],dayArray[i][0]);
	  }
	  cell3.appendChild(e1);
	  
    
	  
      var cell4 = row.insertCell(4);
	  var e1 = document.createElement('Select');
	  e1.name='jphnNameC'+iteration;
	  e1.style.width = "";
	  e1.options[0] = new Option('Select', '0');
	  for(var i = 0;i<nameCArray.length;i++){
		e1.options[i+1] = new Option(nameCArray[i][0],nameCArray[i][1]);
	  }
	  cell4.appendChild(e1);
	  
	  
	  
      var cell5 = row.insertCell(5);
	  var e1 = document.createElement('Select');
	  e1.name='dayBlockC'+iteration;
	  e1.style.width = "";
	  e1.options[0] = new Option('Select', '0');
	  for(var i = 0;i<blockArray.length;i++ ){
		  alert(blockArray[i][1],blockArray[i][0]);
		e1.options[i+1] = new Option(blockArray[i][1],blockArray[i][0]);
	  }
	  cell5.appendChild(e1);


	   	var cell222 = row.insertCell(6);
	   	var e222 = document.createElement('select');
	   	e222.name='routineActivity'+(iteration);
	   	e222.id ='routineActivity'+(iteration);
	   	e222.options[0] = new Option('Select','');
	   	e222.options[1] = new Option('Training','t');
	   	cell222.appendChild(e222);



	   	var cell2222 = row.insertCell(7);
	   	var e2222 = document.createElement('select');
	   	e2222.name='otherActivity'+(iteration);
	   	e2222.id ='otherActivity'+(iteration);
	   	e2222.options[0] = new Option('Select','');
	   	e2222.options[1] = new Option('Meeting','t');
	   	cell2222.appendChild(e2222);


	
	

     var cell8 = row.insertCell(8);
 	var e5 = document.createElement('input');
 	e5.type = 'button';
 	e5.name='add';
 	e5.className = 'buttonAdd';
 	e5.tabIndex='1';
 	e5.onclick = function(){
 					addRow();
 	}

 	cell8.appendChild(e5);


}


function removeRow()
{
       var tbl = document.getElementById('voucherDetails');
        var tblRows  = tbl.getElementsByTagName("tr");

         if(tblRows.length-2==0){
                alert("Can not delete all rows")
                return false;
    }

       for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
       {
               if (document.getElementsByName('selectedChrage')[counter].checked == true)
               {
                         tbl.deleteRow(counter+1);
                         //document.getElementById('hiddenValueCharge').value=(counter);
               }
               
             
       }
       
 
}


function checkField()
{
 
 var counter = document.getElementById('hiddenValueCharge').value;
 var dateAtp = document.getElementById('dateAtp'+counter).value;
 
//	var start= new Date(document.getElementById("dateAtp"+counter).value.split("/")[2], document.getElementById("dateAtp"+counter).value.split("/")[1], document.getElementById("dateAtp"+counter).value.split("/")[0]);
//	var second= new Date(document.getElementById("dateAtp"+counter).value.split("/")[2], document.getElementById("dateAtp"+counter).value.split("/")[1], document.getElementById("dateAtp"+counter).value.split("/")[0]);

  if(dateAtp==""){
		
		alert("Date Can't be Blank.")
		return false;
	}
	else{
		
		return true;
	}
 
}
</script>


<script>
   var atpJphnJhiHeaders=new Array();
     <% 
       int x=0;
      for (PhAtpJphnJhiDetails detailArray : atpJphnJhiDetails){
         %>
         atpJphnJhiDetails[<%=x%>]=new Array();
         atpJphnJhiDetails[<%=x%>][0]='<%= detailArray.getAtpHeader().getId()%>';
         atpJphnJhiDetails[<%=x%>][1]='<%= detailArray.getAtpHeader().getAshaWorker().getEmployeeName()%>';
         atpJphnJhiDetails[<%=x%>][2]='<%= detailArray.getDayBlock()%>';
     

           <%
              x++;	
           }%>

             function onGroupChange(val){
            	
              var obj=document.getElementById('dayBlockIdCv')+1;
            
               obj.options.length=0;
               
                   var j=0;
             
                for(var i=0;i<atpJphnJhiDetails.length;i++)
               
                 {

              if(val==atpJphnJhiDetails[i][0])
                {
              obj.options[j] = new Option(dayArray[i][0], dayArray[i][2]);
             
           j++;
        }
       }
                  }	
             
             
          

	

</script> 



	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

