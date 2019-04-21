
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
List<PhVillageSurvey> phVillageSurveyDataList= new ArrayList<PhVillageSurvey>();
if(map.get("phVillageSurveyDataList") != null){
	phVillageSurveyDataList = (List)map.get("phVillageSurveyDataList");
	
}


List<PhClassDetails> phClassDetailsList= new ArrayList<PhClassDetails>();
if(map.get("phClassDetailsList") != null){
	phClassDetailsList = (List)map.get("phClassDetailsList");
	
}
if(phVillageSurveyDataList.size()>0){
	for(PhVillageSurvey phVillageSurvey :phVillageSurveyDataList){


%>
<div id="wSDiv">
<div class="clear"></div>

 

<label>Contact No.</label>
<%if(phVillageSurvey.getContactNo()!=null && !phVillageSurvey.getContactNo().equals("") && !phVillageSurvey.getContactNo().equals(" null") && !phVillageSurvey.getContactNo().equals("null") && !phVillageSurvey.getContactNo().equals(null)){%>
<input value="<%=phVillageSurvey.getContactNo()%>" type="text" maxlength="15"/>
<%}else{%>
<input value="" type="text" maxlength="15"/>
<%} %>
<div class="clear"></div>




<label><span>*</span>Post Office</label>
 <input type="text" name="pincode"  id="pincode"	value="<%=phVillageSurvey.getPinCode()!=null ? phVillageSurvey.getPinCode().getPostCodeName():""%>"  validate="PIN,string,yes" MAXLENGTH="20" tabindex=1 />
   
	

  <label><span>*</span>PIN</label>
   <input type="text" name="pincode"  id="pincode"	value="<%=phVillageSurvey.getPinCode()!=null ? phVillageSurvey.getPinCode().getPinCode():""%>"   validate="PIN,string,yes" MAXLENGTH="20" tabindex=1 />
   
   <label>Address</label>
   <%if(phVillageSurvey.getAddress()!="" && !phVillageSurvey.getAddress().equals(" null")){ %>
<textarea name="<%=ADDRESS %>" cols="0" rows="0" tabindex="1" onkeyup="return ismaxlength(this)" maxlength="50"><%=phVillageSurvey.getAddress() %></textarea>
   <%}else{ %>
   <textarea name="<%=ADDRESS %>" cols="0" rows="0" tabindex="1" onkeyup="return ismaxlength(this)" maxlength="50"></textarea>
<%} %>

<div class="clear"></div>

<h4>Principal / Headmaster </h4>

<label> Name</label>
<input type="text" id="principalName"	name="principalName" value="<%=!phVillageSurvey.getPerson1Name().equals("null")?phVillageSurvey.getPerson1Name():""%>" tabindex="1"	validate="Principal Name,string,no" maxlength="30" />

<label>Contact No.</label>
<input type="text" name="p_pcontact_no" value="<%=!phVillageSurvey.getPerson1ContactNo().equals("null")?phVillageSurvey.getPerson1ContactNo():""%>"   maxlength="30" tabindex=1  id="p_pcontact_no" />


<div class="clear"></div>


<h4>PTA / Chairperson </h4>

<label> Name</label>
<input type="text" id="chairpersonName"	name="chairPersonName" value="<%=!phVillageSurvey.getPerson2Name().equals("null")?phVillageSurvey.getPerson2Name():""%>" tabindex="1"	validate="Chairperson Name,string,no" maxlength="30" />



<label>Contact No.</label>
<input type="text" name="c_pcontact_no"  value="<%=!phVillageSurvey.getPerson2ContactNo().equals("null")?phVillageSurvey.getPerson2ContactNo():""%>"   maxlength="30" tabindex=1  id="p_pcontact_no" />


<div class="clear"></div>

<label>Facilities Available</label>
<select multiple="4"  size="10" class="listBig" name="facilitiesAvailable" id="facilitiesAvailable">
	<%
	List<String> fidList = new ArrayList<String>();
			String fIds = phVillageSurvey.getFacilityAvaliable();
			System.out.println(fIds+"---hIds");
			String[] faId = fIds.split(",");
			
			System.out.println(faId.length);
		
			for (int i = 0; i < faId.length; i++) {
				
				fidList.add((faId[i].trim()));
			}
			
		%>
	
		<option value="Kitchen">Kitchen</option>
		<option value="Canteen">Canteen</option>
		<option value="Toilet for Girls">Toilet for Girls</option>
		<option value="Napkin Vending Machine">Napkin Vending Machine</option>
		<option value="Toilet for Boys">Toilet for Boys</option>
		<option value="Water Tank">Water Tank</option>
		<option value="Biogas Plant">Biogas Plant</option>
		<option value="Rainwater Harvesting">Rainwater Harvesting</option>
		<option value="Library">Library</option>
		<option value="NCC Unit">NCC Unit</option>
		<option value="NSS Unit">NSS Unit</option>
		<option value="Scouts&Guides">Scouts&Guides</option>
		<option value="Student Police Cadets">Student Police Cadets</option>
		<option value="Health Club">Health Club</option>
		<option value="Swimming Pool">Swimming Pool</option>
		<option value="Internet Connection">Internet Connection</option>
		<option value="Auditorium">Auditorium</option>
		<option value="Playground">Playground</option>
		<option value="Vegetable Garden">Vegetable Garden</option>
		<option value="Fish Hatchery">Fish Hatchery</option>
		<option value="School Health Nurse">School Health Nurse</option>
		<option value="Clinic with Doctor on Call">Clinic with Doctor on Call</option>
		<option value="School Bus">School Bus</option>
		<option value="Boarding Facility">Boarding Facility</option>
				
</select>
<script>
var temp =  document.getElementById('facilitiesAvailable');

<%
if(fidList.size() > 0){
	%>
	for(var l=0; l<temp.length;l++)
	{
	<%
	
	for(int j=0;j<fidList.size();j++){

%>
		if (temp[l].value == '<%=fidList.get(j)%>')
		{
		temp[l].selected = true;
		
		}


<%} %>
	}
<%}
%>


</script>
<input value="<%=phVillageSurvey.getId()%>"  name="survey" type="hidden"/>

<div class="paddingTop15"></div>

<%
    
      if(phClassDetailsList.size()>0){
    	  %>

<table width="100%" border="0" cellspacing="0" cellpadding="0"      id="voucherDetails" class="cmntable">
       <tr>
     <th></th>
		<th scope="col">Class</th>
		<th scope="col">Section</th>
		 <th></th>
		
               
               
          </tr>
    	  <%	int i = 1;   
        		for(PhClassDetails phClassDetails :phClassDetailsList){
     %>
       
       <tr>
       <td><input type="radio" value="" name="selectedChrage" class="radioCheck" />
            <input type="hidden" value="<%=phClassDetails.getId()%>" name="classId<%=i%>" />
       </td>
         
      <td>
      <select  name="class<%=i%>" id="classs<%=i%>">
             <option value="">Select</option>
           <%for(int x=1;x<=12;x++){ %>
         
          <option value="<%=x%>" selected="selected"><%=x%></option>
         <%} %>
         
         </select>  <script>
var temps =  document.getElementById('classs<%=i%>');
temps.value = '<%=phClassDetails.getSchoolClass()%>';



</script>
      		</td>

      <td>  <input type="text"  name="section<%=i%>"  id="section<%=i%>" value="<%=phClassDetails.getSchoolSection()%>" class="auto" size="10" onblur="populateClassSection('<%=i%>')";/>
		</td>
		
		

	       <td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
       </tr>
     



<%i++;

        		
        		}%>
        		<input type="hidden" value="<%=i-1%>" name="hiddenValueCharge" id="hiddenValueCharge" />
</table>

  <input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
       
     
	
<%      
}else{%>

<table width="100%" border="0" cellspacing="0" cellpadding="0"   id="voucherDetails" class="cmntable">
       <tr>
     <th></th>
		<th scope="col">Class</th>
		<th scope="col">Section</th>
		 <th></th>
		
               
               
       </tr>

       <%int i = 1;%>
       <tr>
       <td><input type="radio" value="" name="selectedChrage" class="radioCheck" />
       <input type="hidden" value="0" name="classId<%=i%>" />
       </td>
      
      
      <td><select  name="class<%=i%>" id="class<%=i%>">
      <option value="">Select</option>
      <%for(int x=1;x<=12;x++){ %>
      <option value="<%=x%>"><%=x%></option>
      <%} %>
      </select>
      
      
    
		</td>

      <td>  <input type="text"  name="section<%=i%>"  id="section<%=i%>" onblur="populateClassSection('<%=i%>')"; class="auto"  size="10"/>
		</td>
		

	       <td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
       </tr>
       </table>
               <input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
       
<!--  ====================================================End cash voucher table==============================-->

       <input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />


<div class="Clear"></div>
<%} %>
	<%}%>
	<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('schoolRegistration','pubHealth?method=submitSchoolAnganwadiRegistration');" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Reset" class="button" onclick="submitFormForButton('schoolRegistration','pubHealth?method=showSchoolAnganwadiRegistrationJsp');" accesskey="a" tabindex=1 />
	
	<% }else{ %>
	<div class="clear"></div>
	<h4>No Record Found</h4>
	<%} %>



		
</div>



	
