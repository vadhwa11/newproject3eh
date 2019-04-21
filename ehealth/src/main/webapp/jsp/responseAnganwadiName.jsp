
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
<div id="wADiv">



<div class="clear"></div>

<label>Contact No.</label>
<%if(!phVillageSurvey.getContactNo().equals(" null") && !phVillageSurvey.getContactNo().equals("null") && !phVillageSurvey.getContactNo().equals("") && phVillageSurvey.getContactNo()!=null && !phVillageSurvey.getContactNo().equals(null)){%>
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
   <%if(!phVillageSurvey.getAddress().equals(" null") && !phVillageSurvey.getAddress().equals("null")){ %>
<textarea name="<%=ADDRESS %>" cols="0" rows="0" tabindex="1" onkeyup="return ismaxlength(this)" maxlength="50"><%=phVillageSurvey.getAddress()%></textarea>
   <%}else{ %>
   <textarea name="<%=ADDRESS %>" cols="0" rows="0" tabindex="1" onkeyup="return ismaxlength(this)" maxlength="50"></textarea>
<%} %>




<div class="clear"></div>


<label> Name of Worker / Helper</label>
<input type="text" id="nameOfWorker"	name="nameOfWorker" value="" tabindex="1"	validate="Principal Name,string,no" maxlength="30" />



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
		<option value="Cooking Gas">Cooking Gas</option>
		<option value="Electricity Connection">Electricity Connection</option>
		<option value="Computer">Computer</option>
		<option value="Internet">Internet</option>
		<option value="Latrine">Latrine</option>
		<option value="Baby Friendly Toilet">Baby Friendly Toilet</option>
		<option value="Air-Conditioning">Air-Conditioning</option>
		<option value="Safe Drinking Water">Safe Drinking Water</option>
		<option value="Safe Storage">Safe Storage</option>
		
</select>
<input type="hidden" value="<%=phVillageSurvey.getId()%>"  name="survey" />
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



<div class="paddingTop15"></div>




      
<%
    
      if(phClassDetailsList.size()>0){
    	  %>
    	  
    	  <table width="100%" border="0" cellspacing="0" cellpadding="0"      id="voucherDetails" class="cmntable" >
       <tr>
     <th></th>
		<th scope="col">Class</th>
		<th scope="col">Divison</th>
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
      <select  name="class<%=i%>" id="class<%=i%>">
      <%if(phClassDetails.getSchoolClass().equalsIgnoreCase("LKG")){ %>
      <option value="">Select</option>
      <option value="LKG" selected="selected">LKG</option>
      <option value="UKG">UKG</option>
      <option value="Other">Other</option>
      <%}if(phClassDetails.getSchoolClass().equalsIgnoreCase("UKG")){ %>
      <option value="">Select</option>
      <option value="LKG">LKG</option>
      <option value="UKG" selected="selected">UKG</option>
      <option value="Other">Other</option>
      <%}if(phClassDetails.getSchoolClass().equalsIgnoreCase("Other")){ %>
      <option value="">Select</option>
      <option value="LKG">LKG</option>
      <option value="UKG">UKG</option>
      <option value="Other" selected="selected">Other</option>
      <%}if(phClassDetails.getSchoolClass().equalsIgnoreCase("")){ %>
      <option value="" selected="selected">Select</option>
      <option value="LKG" >LKG</option>
      <option value="UKG">UKG</option>
      <option value="Other">Other</option>
      <%} %>
      
      </select>
		</td>
      
      

      <td>  <input type="text"  name="section<%=i%>"  id="section<%=i%>" value="<%=phClassDetails.getSchoolSection()%>" class="auto" size="10" onblur="populateClassDivison('<%=i%>')";/>
		</td>
		
		

	       <td><input type="button" name="add" value="" class="buttonAdd" onclick="addRowA();" tabindex="1" /></td>
	           </tr>
	           
	          
<%i++;

        		
        		}%>
        		<input type="hidden" value="<%=i-1%>" name="hiddenValueCharge" id="hiddenValueCharge" />
</table>

  <input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
       
     
	
<%      
}else{%>

 <table width="100%" border="0" cellspacing="0" cellpadding="0"      id="voucherDetails" class="cmntable" >
       <tr>
     <th></th>
		<th scope="col">Class</th>
		<th scope="col">Divison</th>
		 <th></th>
		
               
               
       </tr>
  	<%int i = 1;   
%>

      <tr>
       <td><input type="radio" value="" name="selectedChrage" class="radioCheck" />
        <input type="hidden" value="0" name="classId<%=i%>" />
       </td>
      
      
      <td>
      <select  name="class<%=i%>" id="class<%=i%>" >
      <option value="">Select</option>
      <option value="LKG">LKG</option>
      <option value="UKG">UKG</option>
      <option value="Other">Other</option>
      </select>
		</td>

      <td>  <input type="text"  name="section<%=i%>"  id="section<%=i%>"  class="auto" size="10"  onblur="populateClassDivison('<%=i%>')";/>
		</td>
		

	       <td><input type="button" name="add" value="" class="buttonAdd" onclick="addRowA();" tabindex="1" /></td>
       </tr>
         <input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
       </table>
         <input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
       
     
   <%} }%>

<div class="Clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('schoolRegistration','pubHealth?method=submitSchoolAnganwadiRegistration');" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Reset" class="button" onclick="submitFormForButton('schoolRegistration','pubHealth?method=showSchoolAnganwadiRegistrationJsp');" accesskey="a" tabindex=1 />


	<%}else{ %>
	<h4>No Record Found</h4>
	<%} %>
	
	
	
</div>



	
