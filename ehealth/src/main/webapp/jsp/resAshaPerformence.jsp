<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.HrEmployeeAddress"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.PhAtpJphnJhiHeader"%>
<%@page import="jkt.hms.masters.business.PhVillageSurvey"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
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



<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasEmployee> masEmpDetail= new ArrayList<MasEmployee>();
if(map.get("masEmpDetail") !=null){
	masEmpDetail=(List<MasEmployee>)map.get("masEmpDetail");
}
List<HrEmployeeAddress> empAdd= new ArrayList<HrEmployeeAddress>();
if(map.get("empAdd") !=null){
	empAdd=(List<HrEmployeeAddress>)map.get("empAdd");
}

%>
 
 <div id="testDiv">
 
 <h4><span>ASHA Worker Detail</span></h4>
 
 <%
 if(masEmpDetail.size()>0){
 for(MasEmployee masEmp: masEmpDetail){%>
 <label>Name</label>	
<input type="text" value="<%= masEmp.getEmployeeName()%>" readonly="readonly"/> 

 
 <label>Address</label>
 <% for(HrEmployeeAddress add: empAdd){
    if(masEmp.getId().equals(add.getEmployee().getId())){
  	
	 %>
 <textarea rows="40" cols="3" readonly="readonly"><%= add.getAddress()%></textarea>
 
 <%} }%>
 
 <label>Phone NO.</label>
 <input type="text" value="<%= masEmp.getTelNoResidence()%>"  readonly="readonly"/> 
<%}} %> 

<div class="clear"></div>
 <label><span>*</span> Month</label>
<select  validate="Month,string,no" name="month" onchange="showDiv()">

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
<input type="hidden" value="<%= year%>" name="year"/> 
	
	

<div class="clear"></div>


<div id="divEnchashment" style=" display: none;">
<table width="100%" border="0" cellspacing="0" cellpadding="0"  id="tablediv" class="cmntable">
       <tr>
       	<th scope="col" colspan="">Services</th>
       	<th scope="col" colspan="">Name </th>
        <th scope="col" colspan="">Total</th>
      </tr>      
       <%int i = 1;%>
       <tr id="tr<%=i%>">
     		          <td>
     		          <input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
                    <select id="serviceId"  name="serviceId" validate=",string,no" onchange="getParameters(this.value,1)">
	                            <option value="">Select</option>
								<option value="br">Birth Registration</option>
								<option value="dr">Death Registration</option>
								<option value="anc">ANC Registration</option>
								<option value="ecr">EC Registration</option>
								<option value="fpr">FP Registration</option>
                                <option value="bcr">Baby/Child Registration</option>
                                <option value="cdr">Communicable Disease Registration</option>
                                <option value="ndr">Non-Communicable Disease Registration</option>
								</select>
	
	                   </td>
	             
	               <td>
	               <div id="parameterDiv1">
                     <select id="bName1"  name="bName1" validate=",string,no" multiple="multiple" style="height: 50px;" >
	                            <option value="">Select</option>
					</select>
        </div>

	              </td>
	             
	             <td>
	         <input  type="text" name="countId1" id="countId1"/>
	           </td>
	            
     		     	          
	          
	
    
	       <td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
       </tr>
       </table>
               <input type="button" name="delete" class="buttonDel" onClick="removeRow();" />

     


</div>
</div>
 

