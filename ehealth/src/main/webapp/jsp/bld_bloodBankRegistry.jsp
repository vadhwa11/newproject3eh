<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page import="java.util.ArrayList"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blood Bank Registry</title>
<div class="titleBg">
<h2>Blood Bank Registration</h2>
</div>
</head>
<body>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasDistrict> districtList=new ArrayList<MasDistrict>();
List<MasHospital> hospitalList=new ArrayList<MasHospital>();
List<MasTaluk> talukList=new ArrayList<MasTaluk>();
String bloodBankType="";
String bloodBankStatus="";

if(request.getAttribute("map") != null)
{
	
        map=(Map<String, Object>)request.getAttribute("map");
}
if(map.get("districtList") != null)
{
	districtList=(List<MasDistrict>)map.get("districtList");
	
} 
if(map.get("hospitalList") != null)
{
	hospitalList=(List<MasHospital>)map.get("hospitalList");
	
}
if(map.get("talukList") != null)
{
	talukList=(List<MasTaluk>)map.get("talukList");
	
}
String message="";
if(map.get("talukList") != null)
{
	message=(String)map.get("message");
	
}

%>
<script>
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
<form method="post" name="regBloodBank">
<div class="Block">
<div class="Block">
<label>Registration Number</label> 
	<input type="text"  name="sregNum" value="" validate="Licence No.,string,no" maxlength="3"
	tabindex="1" /> 
	
<!-- <label>Year Of Registration</label> 
	<input type="text"  name="" value="" validate="BP,string,no" maxlength="3"
	tabindex="1" />  -->
<label>Blood Bank Name</label> 
	<input type="text"  name="sbbName" value="" validate="Blood Bank Name,string,no" maxlength="50"
	tabindex="1" />	
	<label> Contact Number</label> 
<input type="text"  name="scontactNum" value="" validate="Contact No.,string,no" maxlength="10"
	tabindex="1" />	
	
<label> District</label> 
<select id="scityId" name="sdistrictname" tabindex="1" validate="District.,string,no" onChange="searchbloodBankDistrictByDistrictId(this.value)">

	<option value="">Select</option>
<% if(null !=districtList && districtList.size()>0){
	for(MasDistrict district:districtList){
%>
	
	<option value="<%=district.getId()%>"><%=district.getDistrictName() %></option>

	<%}} %>
</select>

<label>Sub District/Taluk</label>
<select  id="stalukId" name="staluk"  tabindex="1" />
<option value="">Select</option>
</select>	 
	

<div class="clear"></div>

<input type="button" class="button" value="Search"
	onclick="submitForm('regBloodBank','/hms/hms/bloodBank?method=showBloodBankRegistryJsp')"
	align="right" /> 
	
	</div>
	
<div class="clear"></div>

<%-- <jsp:include page="searchResultBlock.jsp" /> --%>
<div class="clear"></div>

<% if(null !=hospitalList){
%>

	 <table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			
			<th>License Number</th>
			<th>Blood Bank Registration No.</th>
			<th>Blood Bank Name</th>
			<th>Contact Number</th>
			<th>Blood Bank Type</th>
			<th>District</th>
			<th>Sub District/Taluk</th>
			<th>Status</th>
		</tr>
		</thead>
<% for(MasHospital bloodbank:hospitalList){
if(bloodbank.getBbAvailable().equalsIgnoreCase("y")){
	bloodBankType="Government";
}
else{
	bloodBankType="Private";
}
if(bloodbank.getStatus().equalsIgnoreCase("y")){
	bloodBankStatus="Active";
}
else{
	bloodBankStatus="InActive";
}
String bbregistratonNo="";
if(null !=bloodbank.getBloodBankNo() && !bloodbank.getBloodBankNo().equals("") ){
	bbregistratonNo=bloodbank.getBloodBankNo();
}
String licenceNo="";
if(null !=bloodbank.getBbRegistrationNumber() && !bloodbank.getBbRegistrationNumber().equals("") ){
	licenceNo=bloodbank.getBbRegistrationNumber();
}
%>
		<tr onclick="populateBloodBankRegField('<%=bloodbank.getId()%>');">
		<td><%=licenceNo%></td>
		<td><%= bbregistratonNo%></td>
		<td><%= bloodbank.getHospitalName()%></td>
		<td><%= bloodbank.getContactNumber()%></td>
		<td><%=bloodBankType %></td>
		<%if(bloodbank.getDistrict()!=null){ %>
		<td><%= bloodbank.getDistrict().getDistrictName()%></td>
		<%}else{ %>
		<td> </td>
		<%}if(bloodbank.getTaluk()!=null){ %>
		<td><%= bloodbank.getTaluk().getTalukName()%></td>
		<%}else{ %>
		<td> </td>
		<%} %>
		<td><%=bloodBankStatus %></td>
		
		</tr>
		<%}}else{
			%>
			<h4>No Record Found</h4>
			<%} %>
		
	
	</table>
	<div class="clear"></div>
	<div class="clear"></div>
	
</div>
<div class="Block">

	<%if(message !=null && message !="") {%>
	<h4><%=message %></h4>
	<%} %>
<label>License Number<span>*</span> </label>
	<input type="text"  name="registrationNum" id="registrationNumId" value="" validate="Licence No.,string,yes" maxlength="10"
	tabindex="1" /> 
	
<input type="hidden"  name="bloodBankUniqueId" id="bloodBankUniqueId" value=""  maxlength="10"
	tabindex="1" /> 


<label>Blood Bank Name<span>*</span></label> 
	<input type="text" id="bloodbankId"  name="bankName" value="" validate="Blood Bank Name,string,yes" maxlength="50"
	tabindex="1" />	
	

<label>Contact Number<span>*</span></label> 
	<input type="text" id="contactId"  name="contactNum" value="" validate="Contact No.,string,yes" maxlength="10"
	tabindex="1" /> 
	
	<div class="clear"></div>
	

<label> District<span>*</span></label> 
<select id="cityId" name="districtname" tabindex="1" validate="District.,string,yes" onChange="bloodBankDistrictByDistrictId(this.value)">

	<option value="">Select</option>
<% if(null !=districtList && districtList.size()>0){
	for(MasDistrict district:districtList){
%>
	
	<option value="<%=district.getId()%>"><%=district.getDistrictName() %></option>

	<%}} %>
</select>

<label>Taluk</label> 
	<select
	id="SubcityId" name="taluk" 
	tabindex="1">
	<option value="">Select</option>
	<%if(null !=talukList && talukList.size()>0){
		for(MasTaluk taluk:talukList){
		%>
	
	<option value="<%=taluk.getId()%>"><%=taluk.getTalukName()%></option>
	<%}} %>
</select>


	<label>Street / Road / Lane </label> 
	<input id="streetNo" name="street" type="text"
	 value="" maxlength="150" value=""
	tabindex="1" />
	
	<label>Land Mark </label> 
	<input id="landmark" name="landMark" type="text"
	 value="" maxlength="150" value=""
	tabindex="1" />
	
	<label>Status<span>*</span></label> 
	<!-- <select id="ActInactId" name="taluk" 
	tabindex="1" style="display: none"> -->
	<select id="ActInactId" name="status" 
	tabindex="1">
	<option value="">Select</option>
	<option value="Activate">Activate</option>
	<option value="InActivate">InActivate</option>
	
</select>
<div class="clear"></div>
<label>Valid From<span>*</span></label>
 <input type="text" id="datefrom"
					name="datefrom" tabindex="1" value=""
					   onblur="validateExpDate(this,'sbirthDayId')"
					   onkeyup="mask(this.value,this,'2,5','/');" 
					  
					   MAXLENGTH="10"  validate="Valid From Date,string,yes" class="date"
						 />

				<div id="dobcalId">
					<img id="calImageId" src="/hms/jsp/images/cal.gif" width="16" height=""
						border="0"
						onclick="setdate('',document.getElementById('datefrom'),event)"
						
						 tabindex="1" />
				</div>

<label> To<span>*</span></label>

 <input type="text" id="dateTo"
					name="dateTo" tabindex="1" value=""
					   onblur="validateExpDate(this,'sbirthDayId')"
					   onkeyup="mask(this.value,this,'2,5','/');" 
					   
					   MAXLENGTH="10"  validate="Valid To Date,String,yes" class="date"
						 />

				<div id="dobcalId">
					<img id="calImageId" src="/hms/jsp/images/cal.gif" width="16" height=""
						border="0"
						onclick="setdate('',document.getElementById('dateTo'),event)"
						
						 tabindex="1" />
				</div>
	
<div class="clear"></div>
<h4>Blood Bank Type</h4>
<div class="clear"></div>
<label>Government </label>
	<input type="radio" id="goverId"value="gover" class="inputRadiobutton" name="banktype">
	<label>Private</label>
	<input type="radio" id="privId" value="priv" class="radioCheck" name="banktype">

<div class="clear"></div>
<h4>Working Hours</h4>
<div class="clear"></div>
<label>From<span>*</span></label>
	<input type="text" id="statrtTimeId" name="statrtTime" value=""  validate="From time,string,yes" MAXLENGTH="8"/>


	<label> To<span>*</span></label>
	<input type="text" id="endTimeId" name="endTime" value=""  validate="TO time,string,yes" MAXLENGTH="8"/>
	
	<div class="clear"></div>
	<div class="clear"></div>
	
	<h4>Weekly Off</h4>
	<div class="clear"></div>
	<div class="clear"></div>	
	<label style="width:35px">Sun</label>
	<input type="checkbox" id="sun" value="sun" name="Sun" class="inputCheckboxbutton">
	<label style="width:35px">Mon</label>
	<input type="checkbox" value="Mon" name="Mon" class="inputCheckboxbutton">
	<label style="width:35px">Tue</label>
	<input type="checkbox" value="Tue" name="Tue" class="inputCheckboxbutton">
	<label style="width:35px">Wed</label>
	<input type="checkbox" value="Wed" name="Wed" class="inputCheckboxbutton">
	<label style="width:35px">Thu</label>
	<input type="checkbox" value="Thu" name="Thu" class="inputCheckboxbutton">
	<label style="width:35px">Fri</label>	
	<input type="checkbox" value="Fri" name="Fri" class="inputCheckboxbutton">
	<label style="width:35px">Sat</label>
	<input type="checkbox" value="Sat" name="Sat" class="inputCheckboxbutton">
	<div class="clear" style="margin:5px 0px"></div>
	
<input type="button" class="button" id="AddId" value="Add" onclick="submitForm('regBloodBank','/hms/hms/bloodBank?method=registerBloodBank')"  /> 
<input type="button" class="buttonHighlight" name="Reset" id="resetId" value="Reset" onclick="deleteRow('dataTable')" accesskey="r" />	
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	
	<input type="button" id="updateId" style="display: none" class="button" value="Update" onclick="submitForm('regBloodBank','/hms/hms/bloodBank?method=editBloodBank')"
	align="right" /> 
	
	<input type="button" id="inactiveId" style="display: none" class="button" value="Inactive"
	onclick="addRow('dataTable')"
	align="right" /> 
	<div class="clear"></div>
		
</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>

</html>
