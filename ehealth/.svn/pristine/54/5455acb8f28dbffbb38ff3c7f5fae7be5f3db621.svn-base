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
       String message="";
       if(map.get("message") != null){
    		message = (String)map.get("message");
    	}
     
%>
      
   <div id="testDiv">
   
<div class="paddingTop15"></div>



 
<table width="100%" border="0" cellspacing="0" cellpadding="0"      id="voucherDetails" class="cmntable">
       <tr>
     <th></th>
		<th scope="col">Date</th>
		<th scope="col">Pending Day Block</th>
		<th scope="col">Current Day Block</th>
		<th scope="col">Routine Activities</th>
		<th scope="col">Other Activities</th>
		<th scope="col">After Noon Activities</th>
		<th scope="col">Remarks</th>
		
               
               
       </tr>

       <%int i = 1;%>
       <tr>
       <td><input type="radio" value="" name="selectedChrage" class="radioCheck" /></td>
      
      
      <td><input  id="dateAtp<%=i%>" name="dateAtp<%=i%>" class="auto" type="text" maxlength="30" readonly="readonly" value=""  size="8"/>
		<img width="16" height="16" border="0" onclick="javascript:setdate('',document.cashVoucher.dateAtp<%=i%>,event)"  src="/hms/jsp/images/cal.gif">
		</img>
		</td>

		<td>
<select id="dayBlockIdP<%=i%>"  name="dayBlockIdP<%=i%>" validate="Day Block,string,no" tabindex=1 >
	<option value="0">Select</option>
	<%if(dayBlockList.size()>0){
		for(PhDayBlock phDayBlock:dayBlockList){
		%>
		<option value="<%=phDayBlock.getId() %>"><%=phDayBlock.getForDay() %></option>
	<%}
		}%>
</select>
	</td>
<td>
<select id="dayBlockId<%=i%>"  name="dayBlockId<%=i%>" validate="Day Block,string,no" tabindex=1 >
	<option value="0">Select</option>
	<%if(dayBlockList.size()>0){
		for(PhDayBlock phDayBlock:dayBlockList){
		%>
		<option value="<%=phDayBlock.getId() %>"><%=phDayBlock.getForDay() %></option>
	<%}
		}%>
</select>
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
	
			<td>
<select name="afterNoonActivity<%=i%>" name="afterNoonActivity<%=i%>">
<option value="" >Select</option>
<option value="t">Training</option>
</select>
	</td>
      <td> <textarea rows="" cols="" name="remarks<%=i%>"   id="remarks<%=i%>"></textarea> </td>
	       <td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
       </tr>
       </table>
               <input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
       
<!--  ====================================================End cash voucher table==============================-->

       <input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />


<div class="Clear"></div>
<div id="testDivs">

     

 <input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="if(checkField()){submitProtoAjaxWithDivName('cashVoucher','/hms/hms/pubHealth?method=submitAtpJphnJhi','testDiv');}" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />

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
		<th></th>
		</tr>
		
		
		       
               
       </tr>
        <%if(phAtpJphnJhiDetailsList.size()>0){ 
       for(Object[] pd : phAtpJphnJhiDetailsList){ %>
  
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
	   </td>
	   <!-- <td>
	   </td> -->
	   
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
  	   <%}} %>
  </table>
   </div>
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
function addRow(){
       var tbl = document.getElementById('voucherDetails');
       var lastRow = tbl.rows.length;

       var row = tbl.insertRow(lastRow);
       var hdb = document.getElementById('hiddenValueCharge');
       var iteration = parseInt(hdb.value)+1;
       hdb.value = iteration;


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
       e1.className = 'date';
       var eImg = document.createElement('img');
       eImg.src = '/hms/jsp/images/cal.gif';
       eImg.style.display ='inline';
       eImg.onclick = function(event){
                                       setdate('',document.getElementById('dateAtp'+iteration),event) };
       cell1.appendChild(e1);
       cell1.appendChild(eImg);


   	var cell2 = row.insertCell(2);
   	var e2 = document.createElement('select');
   	e2.name='typeName'+(iteration);
   	e2.id ='typeName'+(iteration);
   	e2.options[0] = new Option('Select','');
   	e2.options[1] = new Option('Day Block Carried Forward','d');
   	e2.options[2] = new Option('Remaining Day Block','r');
   	e2.options[3] = new Option('Meeting Activities Others','m');
   	cell2.appendChild(e2);



   	var cell3 = row.insertCell(3);
	var e3 = document.createElement('select');
	e3.name='dayBlockId'+(iteration);
	e3.id='dayBlockId'+(iteration);
	e3.options[0] = new Option('Select','0');
	e3.tabIndex='1';
	for(var k = 0;k<dayBlockArray.length;k++){
		e3.options[k+1] = new Option(dayBlockArray[k][1],dayBlockArray[k][0]);
	}
	
	
	cell3.appendChild(e3);

	 var cell4= row.insertCell(4);
     var e4 = document.createElement('textarea');
     e4.name='remarks'+(iteration);
     e4.id='remarks'+(iteration);
     e4.type = 'textarea'
     e4.maxLength='250';
     cell4.appendChild(e4);
	
	

     var cell5 = row.insertCell(5);
 	var e5 = document.createElement('input');
 	e5.type = 'button';
 	e5.name='add';
 	e5.className = 'buttonAdd';
 	e5.tabIndex='1';
 	e5.onclick = function(){
 					addRow();
 	}

 	cell5.appendChild(e5);


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

               }
       }
}



</script>




</div>