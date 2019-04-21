<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hrms.masters.business.MasQualification"%>
<%@page import="jkt.hms.masters.business.AshaWorker"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<link href="/hms/jsp/css/jquery-ui.min.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-3.1.1.min.js"></script>
<script src="/hms/jsp/js/jquery-ui.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asha Worker</title>

<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
map = (Map) request.getAttribute("map");
}
List<MasHospitalType>hospitalTypes=new ArrayList<MasHospitalType>();
List<MasHospital>hospitals=new ArrayList<MasHospital>();
List<AshaWorker>ashWorkers=new ArrayList<AshaWorker>();
List<MasQualification>masQualifications=new ArrayList<MasQualification>();
List<MasDistrict>masDistricts=new ArrayList<MasDistrict>();

if(map.get("hospitalTypes") != null){
	hospitalTypes=(List<MasHospitalType>)map.get("hospitalTypes");
}
if(map.get("masQualifications") != null){
	masQualifications=(List<MasQualification>)map.get("masQualifications");
}
if(map.get("masDistricts") != null){
	masDistricts=(List<MasDistrict>)map.get("masDistricts");
}

if(map.get("ashaDetails") != null){
	ashWorkers=(List<AshaWorker>)map.get("ashaDetails");
}

%>
<div class="titleBg">
<h2>Asha Worker</h2>
</div>

<div class="Block">
<%if(ashWorkers.size()>0){ %>
<div style="height:250px; overflow: scroll;">
<table id="ashaTable">
<thead>
<tr>
	    <th scope="col">Name</th>
	    <th scope="col">Code</th>
	    <th scope="col">Contact NO.</th>
	    <th scope="col">Qualification</th>
		<th scope="col">Bank Account</th>		
		<th scope="col">Bank Name</th>
		<th scope="col">IFSC Code</th>
		<th scope="col">LSG Name</th>
		<th scope="col">Hospital Name</th>
		<th scope="col">Sub Centers</th>
		
</tr>
</thead>
<tbody>
	<%
	int count=0;
	for(AshaWorker ash:ashWorkers) {
	count++;
	%>
		<tr>
			    <td scope="col"><%=ash.getAshaName() %></td>
			    <td scope="col"><%=ash.getAshaCode() %></td>
			    <td scope="col"><%=ash.getContactNo() %></td>
			    <td scope="col"><%=ash.getQualification()!=null?ash.getQualification().getQualificationName():""%></td>
				<td scope="col"><%=ash.getBankAccount() %></td>		
				<td scope="col"><%=ash.getBankName() %></td>
				<td scope="col"><%=ash.getIfsc() %></td>
				<td scope="col"><%=ash.getLsg()!=null?ash.getLsg().getLsgTypeName():""%></td>
				<td scope="col"><%=ash.getHospital()!=null?ash.getHospital().getHospitalName():""%></td>
				<td scope="col">
					<input type="button" id="<%=ash.getId()%>"  value="Hospiatal List"  class="button hospitalList"/>
				</td>
				
		</tr>
	<%} %>	
</tbody>
</table>
</div>
<%} %>
<div class="paddingTop25">
<form name="ashaworker" id="ashaworker" method="post">

<label>Asha Name<span>*</span></label> 
<input type="text" tabindex="1" name="ashaName" id="ashaName"  maxlength="20" validate="Asha Name,metachar,yes" />

<label>Asha Code<span>*</span></label> 
<input type="text" tabindex="1" name="ashaCode" id="ashaCode"  maxlength="20" validate="Asha Code,metachar,yes" />


<label>Contact No.</label> 
<input type="text" tabindex="3" name="contactNo" id="contactNo"  maxlength="13"  validate="Contact NO.,phone,no"/>


<label>Educational qualification<span>*</span></label>
<select id="qualification" name="qualification" validate="Educational qualification,string,yes">
<option value="0">Select</option>
<%for(MasQualification msq:masQualifications) {%>
<option value="<%=msq.getId()%>"><%=msq.getQualificationName() %></option>
<%} %>
</select>
<label>Bank Account</label>
<input type="text" tabindex="6" name="backAc" id="backAc" maxlength="20"  />

<label>Bank name</label>
<input type="text" tabindex="7" name="bankName" id="bankName" maxlength="20" />

<label>Branch & IFSC Code</label>
<input type="text" tabindex="8" name="ifsc" id="ifsc"  maxlength="20" />

<label>District Name<span>*</span></label>
<select id="districtName" name="districtName" validate="District Name,string,yes">
<option value="0">Select</option>
<%for(MasDistrict dis:masDistricts) {%>
<option value="<%=dis.getId()%>"><%=dis.getDistrictName() %></option>
<%} %>
</select>

<label>LSG Name<span>*</span></label>
<select id="lsgName" name="lsgName" validate="LSG Name,string,yes">
<option value="0">Select</option>
</select>

<label>Type of Hospital</label>
<select id="hospitalType" name="hospitalType">
<option value="0">Select</option>
<%for(MasHospitalType hos:hospitalTypes) {%>
<option value="<%=hos.getId()%>"><%=hos.getHospitalTypeName() %></option>
<%} %>
</select>

<label>Hospital</label>
<select name="hospitals" id="hospitals" >
<option value="0">Select</option>
</select>


<label>Sub Centers</label>
<select multiple="multiple" name="subCenters" id="subCenters"  class="multiple1">
<option value="0">Select</option>
</select>

<div class="clear"></div>
<div class="paddingTop25"></div>
<input type="button" name="back" id="back" value="back" tabindex="" class="button" tabindex="1"/>
<input type="button" name="Submit11" id="Submit11" value="Submit" tabindex="" class="button" tabindex="1"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>

<div id="hospitalDiv" title="Hospital List">
</div>


<script  type="text/javascript">
jQuery(function($) {
	  $("#back").click(function(){
		  window.history.back();
	   });
	  
	  $("#districtName").change(function(){
	        $.ajax({url: "/hms/hms/pubHealth?method=getAshaEntity",
	       		data: { districtId: $("#districtName").val()} ,
	       		success: function(result){
	           	$("#lsgName").html(result);
	       }}); 
	   });
	  
    $("#hospitalType").change(function(){
         $.ajax({url: "/hms/hms/pubHealth?method=getHospitals",
        		data: { hospitalTypeId: $("#hospitalType").val()} ,
        		success: function(result){
            	$("#hospitals").html(result);
        }}); 
    });
    
    $("#hospitals").change(function(){
        $.ajax({url: "/hms/hms/pubHealth?method=getAshaEntity",
       		data: { hospitalId: $("#hospitals").val()} ,
       		success: function(result){
           	$("#subCenters").html(result);
       }}); 
   });
    
    $(".hospitalList").click(function(){
    	  $.ajax({url: "/hms/hms/pubHealth?method=getHospitals",
     		data: { ashaId:this.id},
     		success: function(response){
     			$("#hospitalDiv").html(response); 
            	$("#hospitalDiv").dialog({width:842,height:332,modal: false});
            }});  
	});
   
    
    $("#Submit11").click(function(){
    	if($("#ashaName").val().length==0){
    		alert("Please enter Asha worker name");
    	}else{
    		if(confirm("Do you want to submit")){
        		$.ajax({
         	        url: '/hms/hms/pubHealth?method=submitAshaWorker',
         	        type: 'POST',
         	        data: $("form").serialize(),
         	        success: function(data) {
         	        	alert("Asha workder details submitted");
         	        	$('#ashaworker')[0].reset();
         	        	 location.href = '/hms/hms/pubHealth?method=getAshapage';
         	        }
         	    });	 
        	}
    	}
    });
});
</script>