<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hospital.jsp  
 * Purpose of the JSP -  This is for All Hospital Master.
 * @author  Mansi
 * Create Date: 04 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.PhMasElectricalSection"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">

/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

</script>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchHospitalList = (ArrayList)map.get("searchHospitalList");
List<MasHospital> masHospitalList = (List<MasHospital>)map.get("masHospitalList");

String userName = "";
if(session.getAttribute("userName") != null){
 userName = (String)session.getAttribute("userName");
}
List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
if(map.get("masHospitalTypeList") != null){
	masHospitalTypeList = (List<MasHospitalType>)map.get("masHospitalTypeList");
	
}
/* List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
if(map.get("masEmployeeList") != null){
	masEmployeeList = (List<MasEmployee>)map.get("masEmployeeList");
	
} */
List<MasRank> masRank = new ArrayList<MasRank>();
if(map.get("masRank") != null){
	masRank = (List<MasRank>)map.get("masRank");
	
}

String institutionCodeNo="";
if(map.get("institutionCodeNo")!=null && !"".equals(map.get("institutionCodeNo"))){
	institutionCodeNo=(String)map.get("institutionCodeNo");
}

List<MasDistrict> districtList = new ArrayList<MasDistrict>();
districtList = (ArrayList)map.get("districtList");

List<PhMasElectricalSection> electricalSectionList = new ArrayList<PhMasElectricalSection>();
electricalSectionList = (ArrayList)map.get("electricalSectionList");


if(map.get("message") != null){
	   String message = (String)map.get("message");
	 %>
<h4><span><%=message %></span></h4>
<%}

%>

<!--main content placeholder starts here-->

<h2>Institution Master</h2>
<div class="clear"></div>
<!--Block One Starts-->
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">

<label>Institution Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1"	checked="checked" class="radiobutMargin" onClick="showInsDis(this)"  /> 

<label>Institution Name</label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" onClick="showInsDis(this)"  />

<label>District</label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" value="3" class="radiobutMargin" onClick="showInsDis(this)"  />

<label>Institute Type</label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" value="4" class="radiobutMargin" onClick="showInsDis(this)"  />

<div id="code" style="display: inline;">
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""	  MAXLENGTH="50" tabindex=1	onkeypress="return submitenter(this,event,'user?method=searchHospital','checkSearch')" />
</div>
<div id="dis" style="display: none;">

<select name="<%= SEARCH_FIELD%>1" id="searchField"   tabindex=1>
<%	if(districtList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = districtList.iterator(); iterator.hasNext();) {
					 MasDistrict d = (MasDistrict) iterator.next();
					 if(d.getDistrictName()!=null){
				  %>
				  <option value="<%=d.getId ()%>"><%=d.getDistrictName().trim()%></option>
				  <%
				  	 	}
				 }
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
</div>
<div id="ins" style="display: none;">

 <select  name="<%= SEARCH_FIELD%>2" id="searchField" >
<option value="0">Select</option>
 <%
				         		if(masHospitalTypeList != null){ 	
				         				for (MasHospitalType masHospitalTyp :masHospitalTypeList) {
				         					if(masHospitalTyp.getStatus().equalsIgnoreCase("y")){
				         					
				         				
				         %>
					  
						 <option value="<%=masHospitalTyp.getId()%>"><%=masHospitalTyp.getHospitalTypeName() %></option> 
				        <%	}	
				        			}
				        		 } 
				        %>
			      </select> 
</div>

<!-- <input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','user?method=searchHospital','checkSearch')"	tabindex=1 /> -->
 <input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','user?method=searchHospital')"	tabindex=1 /> 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
</div>
<div class="clear"></div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchHospitalList.size()>0)
		 {
			String strForCode = (String)map.get("hospitalCode");
			String strForCodeDescription = (String)map.get("hospitalName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <a href="user?method=showHospitalJsp">Show All Records</a> <%
			}
		 }
	 if(searchHospitalList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="user?method=showHospitalJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"sparkid"], [4,"institutionShortName"],
			[5,"hospitalTypeId"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"],[9,"<%= ADDRESS %>"],
			[10,"<%= CONTACT_NUMBER %>"],[11,"<%= CHANGED_BY%>"],[12,"nameChange"],[13,"typeChange"],[14,"districtId"],
			[15,"Institute"],[16,"talukId"],[17,"electricalSectionId"],[18,"sanctionBed"],[19,"kmsclInstituteCode"],
			[20,"kmsclCategory"],[21,"longitude"],[22,"latitude"],[23,"serverIp"],[24,"serverPort"],[25,"clientIp"],[26,"clientPort"],[27,"bbAvailabilityId2"],[28,"counterWiseTokenDisplay"],[29,"parentInstitute"],[30,"specialityType"]];
	 statusTd = 8;
	</script>
<div class="clear"></div>
</div>
<form name="hospital" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasHospital"  ><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="HospitalName"  ><input
	type="hidden" name="title" value="Hospital"  ><input
	type="hidden" name="<%=JSP_NAME %>" value="hospital"  ><input
	type="hidden" name="pojoPropertyCode" value="HospitalCode"  >
<div class="Clear"></div>
<div class="paddingTop5"></div>
<div id="testDiv">
<div class="Block">
<label><span>*</span> Institution Code </label>
 <input id="codeId"  type="text"	name="<%= CODE%>" value="<%=institutionCodeNo%>" readonly="readonly" validate="Institution Code,metachar,yes"	MAXLENGTH="5" tabindex=1 onblur="checkForAlreadyAvailableInstituteCode(this.value)"/>
  <label ><span>*</span> Institution Name</label> 
  <input id="hospitalName" type="text" name="<%= SEARCH_NAME %>" value="" validate="Institution Name,metachar,yes"	MAXLENGTH="100" tabindex=1	onkeypress="return submitenter(this,event,'user?method=addHospital')" />
  <input id="nameChange" type="hidden" name="nameChange" value="" 	MAXLENGTH="30" tabindex=1	 />
  
  <script>
document.hospital.<%=CODE%>.focus();
</script> 

<label>Spark ID</label> 
<input type="text"	 name="sparkId" id="sparkId" value=""	validate="Spark ID,int,no" MAXLENGTH="12" tabindex=1 /> 

<div class="clear"></div>
<label>Institution Short Name</label> 
<input type="text"	 name="institutionShortName" id="institutionShortName" value=""	validate="Institution Short Name,metachar,no" MAXLENGTH="50" tabindex=1 /> 

<label><span>*</span> Institution Type</label> 
<select name="hospitalTypeId" id="hospitalTypeId" validate="Institution Type,metachar,yes">
<option value="0">Select</option>
 <%
				         		if(masHospitalTypeList != null){ 	
				         				for (MasHospitalType masHospitalType :masHospitalTypeList) {
				         				
				         %>
					  
						 <option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName() %></option> 
				        <%		
				        			}
				        		 } 
				        %>
			      </select>


<input id="typeChange" type="hidden" name="typeChange" value="" 	MAXLENGTH="30" tabindex=1	 />

<%-- <label>Parent Institutions</label> 
<select name="parentInstitute" id="parentInstitute">
<option value="0">Select</option>
 <%
				         		if(masHospitalList != null){ 	
				         				for (MasHospital masHospital :masHospitalList) {
				         					if(masHospital.getStatus().equalsIgnoreCase("y")){
				         					
				         				
				         %>
					  
						 <option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName() %></option> 
				        <%	}	
				        			}
				        		 } 
				        %>
			      </select>--%>
			      
<%--added by govind 18-05-2017 --%>
	<script type="text/javascript">
function eventCallback(element, entry){
//alert("group-=="+document.getElementById('itemGroupId').value);
var dist=0,ins=0;
/*if(document.getElementById("districtId")!=null){
dist= document.getElementById("districtId").value;
}*/
/*if(document.getElementById("hospitalTypeId")!=null){
ins= document.getElementById("hospitalTypeId").value;
}*/
	return entry+"&districtId=" + dist+"&instType="+ins;                                                                       
}
</script>
	<label>Parent Institutions</label>
<input type="text" name="instName" id="Institute" onblur="getHospitalId();" tabindex="1">
				<div id="instDiv" style="display: none;"
												class="autocomplete"></div> 
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('Institute','instDiv','generalMaster?method=getHospitalListForAutoCompleteItem',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>
					<input type="hidden" name="parentInstitute" id="parentInstitute" value="0">
<%--added by govind 18-05-2017 end --%>


			     <div class="clear"></div>
			     <label>Head of Institution</label> 
<select name="headInst" id="headInst">
<option value="">Select</option>
 <%
				         		if( masRank!= null){ 	
				         				for (MasRank masR :masRank) {
				         					if(masR.getStatus().equalsIgnoreCase("y")){
				         					
				         				
				         %>
					  
						 <option value="<%=masR.getId()%>"><%=masR.getRankName() %></option> 
				        <%	}	
				        			}
				        		 } 
				        %>
			      </select> 

<%-- <select name="hoi" id="hoi">
<option value="0">Select</option>
 <%
				         		if(masEmployeeList != null){ 
				         			String eName="";
				         				for (MasEmployee masEmployee :masEmployeeList) {
				         					if(masEmployee.getStatus().equalsIgnoreCase("y")){
				         						if (masEmployee.getFirstName() != null) {
				         							eName = masEmployee.getFirstName();
				         						}
				         						if (masEmployee.getMiddleName()!= null) {
				         							eName += masEmployee.getMiddleName();
				         						}
				         						if (masEmployee.getLastName()!= null) {
				         							eName += masEmployee.getLastName();
				         						}	
				         				
				         %>
					  
						 <option value="<%=masEmployee.getId()%>"><%=eName%></option> 
				        <%	}	
				        			}
				        		 } 
				        %>
			      </select>
 --%>

<label> <span>*</span>Address</label> <!--<textarea maxlength="5	0" rows="0" name="<%=ADDRESS %>" onkeyup="return ismaxlength(this)"  tabindex="1"></textarea>-->

<input type="text" name="<%= ADDRESS %>" id="hospitalAdd"	value="" validate="Address,address,yes" MAXLENGTH="70" tabindex=1 />


<label>Street</label>

<input type="text" name="street"  id="street"	value="" validate="Street,string,no" MAXLENGTH="70" tabindex=1 />

<div class="clear"></div>

<label> District</label>
<select name="districtId" id="districtId"  validate="District,metachar,no" tabindex=1 onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getTalukList&district='+this.value,'testDivs');" tabindex=1>
<%	if(districtList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = districtList.iterator(); iterator.hasNext();) {
					 MasDistrict d = (MasDistrict) iterator.next();
					 if(d.getDistrictName()!=null){
				  %>
				  <option value="<%=d.getId ()%>"><%=d.getDistrictName().trim()%></option>
				  <%
				  	 	}
				 }
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>


<div id="testDivs">


<label>  Taluk</label>
<select name="talukId" validate="Taluk,metachar,no" tabindex=1  >
<option value="0">No Data</option>

</select>

<label>Ward</label>
<select name="talukId" validate="Taluk,string,no"   tabindex=1  >
<option value="0">No Data</option>
</select>

<label> Village</label>
 <select name="village"  id="village" validate="Village,metachar,no" tabindex=1  >
<option value="0">No Data</option>

</select>


<label> Ward</label>
    <select name="wardId" id="wardId"  validate="Ward,metachar,no" >
    <option value="0">Select</option>
        </select>
      
<label>Locality</label>
   <select name="locality" id="locality"  validate="Locality,metachar,no" >
    <option value="0">Select</option>
        </select>


<div class="clear"></div>

<label> Post Office</label>
    <select name="postOfficeId" id="postOfficeId"  validate="Post Office,string,no" >
    <option value="0">Select</option>
        </select>
  
  <label> PIN</label>
   <input type="text" name="pincode"  id="pincode"	value="" validate="PIN,int,no" MAXLENGTH="20" tabindex=1 />


<label> Parliament</label>
  
<select name="parliament"  id="parliament" validate="Parliament,string,no" tabindex=1  >
<option value="0">No Data</option>
</select>
<div class="clear"></div>
 <label> Assembly</label>
<select name="assembly"  id="assembly" validate="Assembly,string,no" tabindex=1  >
<option value="0">No Data</option>

</select>
 

<!-- 
 <label>Panchayat</label>
   
   
 <select name="panchayat"  id="panchayat" validate="Panchayat,string,no" tabindex=1  >
<option value="0">No Data</option>

</select>
 -->
</div>	
 
<label> <span>*</span>Contact Number</label> 
<input type="text" 	name="<%= CONTACT_NUMBER %>" id="hospitalContact" value=""	validate="Contact Number,contact,no" MAXLENGTH="12" tabindex=1 onkeypress="return isNumberKey(event)" /> 

<label>LSG</label> 
<select name="lsg" id="lsg" onchange="lsgData();">
 <option value="">Select</option>
 <option value="Panc">Panchayath</option>
 <option value="Munic">Municipality</option>
 <option value="Corpo">Corporation</option>
</select>

   <div id="panchayathId" style="display: none;">
   <label>LSG Panchayath Name</label>
    <input type="text" name="lsgName"  id="lsgName"	value="" validate="LSG Panchayath Name,metachar,no" MAXLENGTH="20" tabindex=1 />
   </div>
   
   <div id="municipalityId" style="display: none;">
   <label>LSG Municipality Name</label>
    <input type="text" name="lsgName"  id="lsgName"	value="" validate="LSG Municipality Name,metachar,no" MAXLENGTH="20" tabindex=1 />
   </div>
   
   <div id="corporationId" style="display: none;">
   <label>LSG Corporation Name</label>
    <input type="text" name="lsgName"  id="lsgName"	value="" validate="LSG Corporation Name,metachar,no" MAXLENGTH="20" tabindex=1 />
   </div>


<div class="clear"></div>
   <label>Email Id</label>
   <input type="text" name="email"  id="email"	value="" validate="Email Id,email,no" MAXLENGTH="40" tabindex=1 />

<label>Land Line</label>
   <input type="text" name="landLine"  id="landLine"	value="" validate="Land Line,phone,no" MAXLENGTH="20" tabindex=1 />
   
   
   <label>  Electrical Section</label>
<select name="electricalSectionId" id="electricalSectionId"  validate="Electrical Section,string,no" tabindex=1  tabindex=1>
<%	if(electricalSectionList.size() !=0){
%>
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = electricalSectionList.iterator(); iterator.hasNext();) {
					 PhMasElectricalSection e = (PhMasElectricalSection) iterator.next();
					 if(e.getElectricalSectionName()!=null){
				  %>
				  <option value="<%=e.getId ()%>"><%=e.getElectricalSectionName().trim()%></option>
				  <%
				  	 	}
				 }
				   %>
			
			
	
		
	<%}else{%>
	<option value="">Not Data Found</option>
	
	<%} %>
	</select>
   
  <!-- 

<label>Revenue Block</label>
  
    <select name="rev_block"  id="rev_block" validate="Revenue Block,string,no" tabindex=1  >
<option value="0">No Data</option>

</select>
  -->
   <div class="clear"></div>
   
   
    <label>Sanction Bed</label>
   <input type="text" name="sanctionBed"  id="sanctionBed"	value=""  MAXLENGTH="20" tabindex=1 />
  
    <label>KMSCL Institute Code</label>
   <input type="text" name="kmsclInstituteCode"  id="kmsclInstituteCode"	value="" validate="KMSCL Institute Code,metachar,no" MAXLENGTH="20" tabindex=1 />
   
   
    <label>KMSCL Category</label>
    <select name="kmsclCategory" id="kmsclCategory" validate="KMSCL Category,metachar,no">
	    <option value="">Select</option>
	    <option value="Primary">Primary</option>
	    <option value="Secondary">Secondary</option>
    </select>
  <div class="clear"></div>   
 <label>Server IP</label>
   <input type="text" name="serverIp"  id="serverIp" MAXLENGTH="20" tabindex=1 />
<label>Server Port</label>
   <input type="text" name="serverPort"  id="serverPort" MAXLENGTH="20" tabindex=1 />
<label>Client IP</label>
   <input type="text" name="clientIp"  id="clientIp" MAXLENGTH="20" tabindex=1 />
    <div class="clear"></div> 
<label>Client Port</label>
   <input type="text" name="clientPort"  id="clientPort" MAXLENGTH="20" tabindex=1 />
 <label>Longitude</label>
   <input type="text" name="longitude"  id="longitude"	value="" validate="Longitude,string,no" MAXLENGTH="20" tabindex=1 />
 <label>Latitude </label>
   <input type="text" name="latitude"  id="latitude"	value="" validate="Latitude,string,no" MAXLENGTH="20" tabindex=1 />

 <div class="clear"></div> 
<%-- <% if(tabletList.size()>1){%> for Multiple sim and mac
<label>SIM No</label>
<select name="sim" validate="sim,metachar,no"  tabindex=1 onchange="populateOtherCode(this.value);" >  <!-- onchange="populatePinCode(this.value);"  -->
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = tabletList.iterator(); iterator.hasNext();) {
					 MasTablet mt = (MasTablet) iterator.next();
					 if(mt.getSimNo()!=null){
						 if(mt.getSimNo()!=null){%>
         			 <option value="<%=mt.getId()%>" selected="selected"><%=mt.getSimNo().trim()%></option> 		
      	<%}}}%>
</select>

<label>IMEI No</label>
<input type="text" name="imeiNo" value="<%=imei_no %>" id="imeiNo" maxlength="16" /> 
<label>MAC</label>
<input type="text" name="mac" value="<%=mac %>" id="imeiNo" maxlength="16" /> 
<label>UTID</label>
<input type="text" name="utid" value="<%=utid %>" id="imeiNo" maxlength="16" /> 

<% }else{%> --%>
<label>SIM No</label>
<input type="text" name="sim" value="" id="imeiNo" maxlength="32" /> 
	
<label>IMEI No</label>
<input type="text" name="imeiNo" value="" id="imeiNo" maxlength="40" /> 

<label>MAC</label>
<input type="text" name="mac" value="" id="imeiNo" maxlength="40" /> 
<label>UTID</label>
<input type="text" name="utid" value="" id="imeiNo" maxlength="40" /> 
<label class="auto">Blood Bank Availability</label> 
<input type="checkbox" name="bbAvailability"  id="bbAvailabilityId"	value="" onclick="setBloodBankStatus();"  tabindex=1  style="margin:0px 8px 0px 0px" />
<!-- <div class="clear"></div>  -->
<input type="hidden" name="bbAvailability2"  id="bbAvailabilityId2"	value=""  class="date"/>



<label class="heightAuto">Counter Wise Token Display</label> 
<input type="checkbox" name="counterWiseTokenDisplay"  id="counterWiseTokenDisplay"	value=""  tabindex=1  style="margin:0px 8px 0px 0px" />


 <label>Speciality Type</label>
    <select name="specialityType" id="specialityType" validate="Speciality Type,metachar,no">
	    <option value="">Select</option>
	    <option value="Simple">Simple</option>
	    <option value="Medium">Medium</option>
	    <option value="Complex">Complex</option>
    </select>
 <div class="clear"></div> 
 
 <label>Multi Lab</label> 
<input type="checkbox" name="multiLab"  id="multiLab" onclick="selectMultiLab()"	value=""  tabindex=1  style="margin:0px 8px 0px 0px" />
 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('hospital','user?method=addHospital','checkBlankForAddHospital');"	accesskey="a" tabindex=1 />

<input type="hidden" name="edit"	id="editbutton" value="Update" style="display: none;" class="button"	onClick="submitForm('hospital','user?method=editHospital')"	accesskey="u" tabindex=1 /> 

<input type="hidden" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('hospital','user?method=deleteHospital&flag='+this.value)"	accesskey="d" tabindex=1 />

<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="submitFormForButton('hospital','user?method=showHospitalJsp')" accesskey="r" /> 

<input type="button"	name="Back" value="Back" class="button" accesskey="b"	onclick="submitFormForButton('hospital','superAdmin?method=showModuleManagementJsp')"	tabindex=1 />
 </div> 
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date%></label> 

<label>Changed Time</label> <label class="value"><%=time%></label>
 <input type="hidden"	name="<%=CHANGED_BY%>" value="admin" /> 
 <input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
 <input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
 </div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<input type="hidden" name="<%=STATUS %>" value="" validate="status,metachar,no"/> <input
	type="hidden" name="<%= COMMON_ID%>" value="" validate="commonId,int,no"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Institution Code"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Institution Name"
data_header[1][1] = "data";
data_header[1][2] = "35%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Saprk ID"
data_header[2][1] = "hide";
data_header[2][2] = "25%";
data_header[2][3] = "sparkid"

data_header[3] = new Array;
data_header[3][0] = "Institute Short Name"
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "institutionShortName";



data_header[4] = new Array;
data_header[4][0] = "Institute Type"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "hospitalTypeId";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE%>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>";


data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_header[8] = new Array;
data_header[8][0] = "Address"
data_header[8][1] = "data";
data_header[8][2] = "25%";
data_header[8][3] = "<%= ADDRESS%>"

data_header[9] = new Array;
data_header[9][0] = "Contact Number"
data_header[9][1] = "hide";
data_header[9][2] = "40%";
data_header[9][3] = "<%= CONTACT_NUMBER %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%= CHANGED_BY%>";

data_header[11] = new Array;
data_header[11][0] = "Institute Name Change Count"
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "nameChange";

data_header[12] = new Array;
data_header[12][0] = "Institute type Change Count"
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "typeChange";

data_header[13] = new Array;
data_header[13][0] = "District"
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "districtId";

data_header[14] = new Array;
data_header[14][0] = "Parent Institution"
data_header[14][1] = "data";
data_header[14][2] = "15%";
data_header[14][3] = "Institute";

data_header[15] = new Array;
data_header[15][0] = "Taluk"
data_header[15][1] = "hide";
data_header[15][2] = "15%";
data_header[15][3] = "talukId";


data_header[16] = new Array;
data_header[16][0] = "Electrical Section"
data_header[16][1] = "hide";
data_header[16][2] = "15%";
data_header[16][3] = "electricalSectionId";


data_header[17] = new Array;
data_header[17][0] = "Sanction Bed"
data_header[17][1] = "hide";
data_header[17][2] = "15%";
data_header[17][3] = "sanctionBed";

data_header[18] = new Array;
data_header[18][0] = "KMSCL Institute Code"
data_header[18][1] = "hide";
data_header[18][2] = "15%";
data_header[18][3] = "kmsclInstituteCode";


data_header[19] = new Array;
data_header[19][0] = "KMSCL Category"
data_header[19][1] = "hide";
data_header[19][2] = "15%";
data_header[19][3] = "kmsclCategory";

data_header[20] = new Array;
data_header[20][0] = "Longitude"
data_header[20][1] = "data";
data_header[20][2] = "15%";
data_header[20][3] = "longitude";


data_header[21] = new Array;
data_header[21][0] = "Latitude"
data_header[21][1] = "data";
data_header[21][2] = "15%";
data_header[21][3] = "latitude";

data_header[22] = new Array;
data_header[22][0] = "Server IP";
data_header[22][1] = "hide";
data_header[22][2] = "15%";
data_header[22][3] = "serverIp";

data_header[23] = new Array;
data_header[23][0] = "Server Port";
data_header[23][1] = "hide";
data_header[23][2] = "15%";
data_header[23][3] = "serverPort";

data_header[24] = new Array;
data_header[24][0] = "Client IP";
data_header[24][1] = "hide";
data_header[24][2] = "15%";
data_header[24][3] = "clientIp";

data_header[25] = new Array;
data_header[25][0] = "Client Port";
data_header[25][1] = "hide";
data_header[25][2] = "15%";
data_header[25][3] = "clientPort";

data_header[26] = new Array;
data_header[26][0] = "bbAvailabilityId2";
data_header[26][1] = "hide";
data_header[26][2] = "15%";
data_header[26][3] = "bbAvailabilityId2";


data_header[27] = new Array;
data_header[27][0] = "counterWiseTokenDisplay";
data_header[27][1] = "hide";
data_header[27][2] = "15%";
data_header[27][3] = "counterWiseTokenDisplay";

data_header[28] = new Array;
data_header[28][0] = "Parent Institution";
data_header[28][1] = "hide";
data_header[28][2] = "5%";	
data_header[28][3] = "parentInstitute";



data_header[29] = new Array;
data_header[29][0] = "Speciality Type";
data_header[29][1] = "hide";
data_header[29][2] = "5%";	
data_header[29][3] = "specialityType";

data_arr = new Array();

<%
Iterator itr=searchHospitalList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasHospital  masHospital = (MasHospital)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masHospital.getId()%>
data_arr[<%= counter%>][1] = "<%=masHospital.getHospitalCode()%>"
data_arr[<%= counter%>][2] = "<%= masHospital.getHospitalName()%>"

data_arr[<%= counter%>][3] = "<%=masHospital.getSparkId()%>"
data_arr[<%= counter%>][4] = "<%= masHospital.getShortName()%>"
	
data_arr[<%= counter%>][5] = "<%= masHospital.getHospitalType()!=null? masHospital.getHospitalType().getHospitalTypeName():""%>"
<%if(masHospital.getLastChgDate()!=null){%>
data_arr[<%= counter%>][6] = "<%=HMSUtil.convertDateToStringWithoutTime(masHospital.getLastChgDate()) %>"
<%}else{%>
data_arr[<%= counter%>][6] = ""
<%}%>
data_arr[<%= counter%>][7] = "<%= masHospital.getLastChgTime() %>"
<% if(masHospital.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

    data_arr[<%= counter%>][9] = "<%=masHospital.getAddress()%>"
	data_arr[<%= counter%>][10] = "<%= masHospital.getContactNumber()%>"
	data_arr[<%= counter%>][11] = "<%= masHospital.getLastChgBy()!=null?(masHospital.getLastChgBy().getId()!=null?masHospital.getLastChgBy().getId():"0" ):"0"%>"
	data_arr[<%= counter%>][12] =  "<%= masHospital.getHospitalNameChangeCount()!=null? masHospital.getHospitalNameChangeCount():"0"%>"
	data_arr[<%= counter%>][13] =  "<%= masHospital.getHospitalTypeChangeCount()!=null? masHospital.getHospitalTypeChangeCount():"0"%>"
	data_arr[<%= counter%>][14] =  "<%= (masHospital.getDistrict()!=null && masHospital.getDistrict().getDistrictName()!=null) ? masHospital.getDistrict().getDistrictName():""%>"
			
		
		data_arr[<%= counter%>][15] = "<%= masHospital.getParentInstitute()!=null ? masHospital.getParentInstitute().getHospitalName():""%>"
	    data_arr[<%= counter%>][29] = "<%= masHospital.getParentInstitute()!=null ? masHospital.getParentInstitute().getId():""%>"
			data_arr[<%= counter%>][16] =  "<%= masHospital.getTaluk()!=null ? masHospital.getTaluk().getTalukName():""%>"
				data_arr[<%= counter%>][17] =  "<%= masHospital.getElectricalSection()!=null ? masHospital.getElectricalSection().getElectricalSectionName():""%>"
					data_arr[<%= counter%>][18] =  "<%= masHospital.getSanctionBed()!=null ? masHospital.getSanctionBed():"0"%>"
							
					data_arr[<%= counter%>][19] =  "<%= masHospital.getKmsclInstituteCode() !=null ? masHospital.getKmsclInstituteCode():""%>"

							
					data_arr[<%= counter%>][20] =  "<%= masHospital.getKmsclCategory() !=null ? masHospital.getKmsclCategory():""%>"
					
					data_arr[<%= counter%>][21] =  "<%= masHospital.getLongitude() !=null ? masHospital.getLongitude():""%>"
					data_arr[<%= counter%>][22] =  "<%= masHospital.getLatitude() !=null ? masHospital.getLatitude():""%>"
					data_arr[<%= counter%>][23] =  "<%= masHospital.getServerIp() !=null ? masHospital.getServerIp():""%>"
					data_arr[<%= counter%>][24] =  "<%= masHospital.getServerPort() !=null ? masHospital.getServerPort():""%>"
					data_arr[<%= counter%>][25] =  "<%= masHospital.getClientIp() !=null ? masHospital.getClientIp():""%>"
					data_arr[<%= counter%>][26] =  "<%= masHospital.getClientPort() !=null ? masHospital.getClientPort():""%>"
					data_arr[<%= counter%>][27] =  "<%= masHospital.getBbAvailable() !=null ? masHospital.getBbAvailable():""%>"
					data_arr[<%= counter%>][28] =  "<%= masHospital.getCounterWiseTokenDisplay() !=null ? masHospital.getCounterWiseTokenDisplay():""%>"
						data_arr[<%= counter%>][30] =  "<%= masHospital.getSpecialityType() !=null ? masHospital.getSpecialityType():""%>"

					

<%
counter++;
}
%>
 
formName = "hospital"


start = 0
if(data_arr.length < rowsPerPage)
	
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<script>

function lsgData(){

var lsgId=document.getElementById('lsg').value;
if(lsgId=="Panc"){
       document.getElementById('panchayathId').style.display = "inline";
       document.getElementById('municipalityId').style.display = "none";
       document.getElementById('corporationId').style.display = "none";
}
if(lsgId=="Munic"){
    document.getElementById('panchayathId').style.display = "none";
    document.getElementById('municipalityId').style.display = "inline";
    document.getElementById('corporationId').style.display = "none";
}
if(lsgId=="Corpo"){
    document.getElementById('panchayathId').style.display = "none";
    document.getElementById('municipalityId').style.display = "none";
    document.getElementById('corporationId').style.display = "inline";
}
if(lsgId==""){
	document.getElementById('panchayathId').style.display = "none";
    document.getElementById('municipalityId').style.display = "none";
    document.getElementById('corporationId').style.display = "none";
    document.getElementById('lsg').value="";
}
}

function showInsDis(val){
	
	<%-- var val=document.getElementById('<%=SELECTED_RADIO  %>'); --%>
	
	if(val.value=="1"){
	       document.getElementById('code').style.display = "inline";
	       document.getElementById('ins').style.display = "none";
	       document.getElementById('dis').style.display = "none";
	}
	if(val.value=="2"){
		document.getElementById('code').style.display = "inline";
	       document.getElementById('ins').style.display = "none";
	       document.getElementById('dis').style.display = "none";
	}
	if(val.value=="3"){
		document.getElementById('code').style.display = "none";
	       document.getElementById('ins').style.display = "none";
	       document.getElementById('dis').style.display = "inline";
	}
	if(val.value=="4"){
		document.getElementById('code').style.display = "none";
	       document.getElementById('ins').style.display = "inline";
	       document.getElementById('dis').style.display = "none";
		
	}
	
	
}
pincodeArray = new Array();
function populatePincode(val,formName){
	obj = eval('document.'+formName+'.pincode');
	obj.length = 1;
	for(i=0;i<pincodeArray.length;i++){
		if(pincodeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=pincodeArray[i][1];
			obj.options[obj.length-1].text=pincodeArray[i][2];
		}
	}
}
</script>
<script type="text/javascript">
function setBloodBankStatus(){
	if(document.getElementById('bbAvailabilityId').checked==true){
		document.getElementById('bbAvailabilityId2').value="y";
	}else if(document.getElementById('bbAvailabilityId').checked==false){
		document.getElementById('bbAvailabilityId2').value="n";
	}
}

function selectMultiLab(){
	if(document.getElementById('multiLab').checked==true){
		document.getElementById('multiLab').value="y";
	}else if(document.getElementById('multiLab').checked==false){
		document.getElementById('multiLab').value="n";
	}
}

function getHospitalId(){
	var instName=document.getElementById("Institute").value;
	if(instName==""){
		document.getElementById("parentInstitute").value=0;
	}else{
	    var xmlHttp;
	    try {
	      // Firefox, Opera 8.0+, Safari
	      xmlHttp=new XMLHttpRequest();
	    }catch (e){
	      // Internet Explorer
	      try{
	        xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	      }catch (e){
	      	alert(e)
	        try{
	          xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	        }catch (e){
	          alert("Your browser does not support AJAX!");
	          return false;
	        }
	       }
	     }
	      xmlHttp.onreadystatechange=function()
	      {
	      	
	        if(xmlHttp.readyState==4){
              //  if(xmlHttp.responseXML.getElementsByTagName('items')[0]!=null){
	        	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
	        	
	        	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	  	   	    var item = chargeCodes.childNodes[loop];
	  	   	 
	  	   	 
	  	        var hospitalName  = item.getElementsByTagName("hospitalName")[0];
	  	        var hosid  = item.getElementsByTagName("hospitalId")[0]; 
	  	        var id= hosid.childNodes[0].nodeValue;			  	      
	  	    document.getElementById("parentInstitute").value=id;
	  	       
	        	}
            	   }
               }
	        
	 
		var url='/hms/hms/generalMaster?method=getHospitalId&hospitalName='+instName+"&variable=Y";
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

		
	      }
	
}
	
function checkForAlreadyAvailableInstituteCode(val) {
	
	if (val != "0") {
		var xmlHttp;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				alert(e)
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}
		
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				var d = "false";
				var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
				for (loop = 0; loop < items.childNodes.length; loop++) {
					var item = items.childNodes[loop];
					var duplicate = item.getElementsByTagName('val')[0];
					
					d = duplicate.childNodes[0].nodeValue;
					
					if (d == 'true') {
						alert(" Institute code Alredy exist !!");
						document.getElementById('codeId').value = "";
					}
				}
			}
		}
		var url = "/hms/hms/user?method=checkForAlreadyAvailableInstituteCode&val="	+ val + "&" + csrfTokenName + "="+ csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}
</script>
