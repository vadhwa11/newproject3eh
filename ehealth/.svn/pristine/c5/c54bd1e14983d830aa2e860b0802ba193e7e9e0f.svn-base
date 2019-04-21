<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.PhMasElectricalSection"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.PhMasLocality"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@page import="jkt.hms.masters.business.PhMasPanchayat"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>

<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BlPackageHeader"%>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response of package details.
 * @author  Ritu
 * Create Date: 23 July,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	
	if (map.get("hospitalList") != null) {
		hospitalList = (List) map.get("hospitalList");
	}
	int parentIstituteId=0;
	int hodId=0;
	int hosTypeId=0;
	int sanctionBed=0;
	String address="";
	int districtId=0;
	String street="";
	String contactNumber="";
	String emailId="";
	String lsgType="";
	String lsgName="";
	String landLine="";
	String kmsclCategory = "";
	String specialityType="";
	String kmsclInstituteCode = "";
	String masRankList = "";
	String longitude="";
	String latitude="";
	String imei_no="";
	String sim="";
	String utid="";
	String mac="";
	String bbAvilable="";
	String counterWiseTokenDisplay="";
	String multiLab=""; // added by amit das on 17-07-2017
	String parentInstituteName="";
	MasHospital masHospital = hospitalList.get(0);
	if(masHospital.getContactNumber()!=null)
	{
	contactNumber= masHospital.getContactNumber();
	}
	if(masHospital.getImeiNo()!=null)
	{ 
		imei_no= String.valueOf(masHospital.getImeiNo());
	}
	
	if(masHospital.getSimNo() !=null)
	{ 
		sim = String.valueOf(masHospital.getSimNo());
	}
	if(masHospital.getUtid()!=null)
	{ 
		utid = String.valueOf(masHospital.getUtid());
	}
	if(masHospital.getMac()!=null)
	{ 
		mac = String.valueOf(masHospital.getMac());
	}
	if(masHospital.getLsgName()!=null)
	{
	lsgName=masHospital.getLsgName();
	}
	if(masHospital.getLsgType()!=null)
	{
	lsgType=masHospital.getLsgType();
	}
	if(masHospital.getEmailId()!=null)
	{
	emailId=masHospital.getEmailId();
	}
	if(masHospital.getImergencyNumber()!=null)
	{
	landLine=masHospital.getImergencyNumber();
	}
	if(masHospital.getParentInstitute()!=null)
	{
	parentIstituteId=masHospital.getParentInstitute().getId();
	}
	if(masHospital.getParentInstitute()!=null)
	{
		parentInstituteName=masHospital.getParentInstitute().getHospitalName();
	}
	if(masHospital.getHod()!=null)
	{
	hodId=masHospital.getHod().getId();
	}	
	if(masHospital.getHospitalType()!=null)
	{
	hosTypeId=masHospital.getHospitalType().getId();
	}	
	if(masHospital.getSanctionBed()!=null)
	{
		sanctionBed=masHospital.getSanctionBed();
	}
	if(masHospital.getAddress()!=null)
	{
		address=masHospital.getAddress();
	}	
	
	if(masHospital.getDistrict()!=null)
	{
		districtId=masHospital.getDistrict().getId();
		
	}

	if(masHospital.getAdd2Street()!=null)
	{
		street=masHospital.getAdd2Street();
		
	}
	if(masHospital.getKmsclCategory() !=null)
	{
		kmsclCategory = masHospital.getKmsclCategory();
	}
	if(masHospital.getSpecialityType() !=null)
	{
		specialityType = masHospital.getSpecialityType();
	}
	if(masHospital.getKmsclInstituteCode() !=null)
	{
		kmsclInstituteCode = masHospital.getKmsclInstituteCode();
	}
	if(masHospital.getLongitude() !=null)
	{
		longitude = masHospital.getLongitude();
	}
	if(masHospital.getLatitude() !=null)
	{
		latitude = masHospital.getLatitude();
	}
	
	if(masHospital.getBbAvailable() !=null)
	{
		bbAvilable = masHospital.getBbAvailable();
	}
	if(masHospital.getCounterWiseTokenDisplay() !=null)
	{
		counterWiseTokenDisplay = masHospital.getCounterWiseTokenDisplay();
	}
	
	// added by amit das on 17-07-2017
	if(masHospital.getMultiLab() !=null)
	{
		multiLab = masHospital.getMultiLab();
	}
	
	
	List<MasHospital> masHospitalList = (List<MasHospital>)map.get("masHospitalList");

String userName = "";
if(session.getAttribute("userName") != null){
 userName = (String)session.getAttribute("userName");
}
List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
if(map.get("masHospitalTypeList") != null){
	masHospitalTypeList = (List<MasHospitalType>)map.get("masHospitalTypeList");
	
}
List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
if(map.get("masEmployeeList") != null){
	masEmployeeList = (List<MasEmployee>)map.get("masEmployeeList");
	
}

List<MasDistrict> districtList = new ArrayList<MasDistrict>();
districtList = (ArrayList)map.get("districtList");


List<PhMasElectricalSection> electricalSectionList = new ArrayList<PhMasElectricalSection>();
electricalSectionList = (ArrayList)map.get("electricalSectionList");


List<MasTaluk> talukList= new ArrayList<MasTaluk>();
if(map.get("talukList") != null){
	talukList = (List)map.get("talukList");
	
}

/* List<MasTablet> tabletList= new ArrayList<MasTablet>();
if(map.get("masTablets") != null){
	tabletList = (List)map.get("masTablets");
}
if(tabletList.size()>0 && tabletList.size() < 2 )
{ 
	imei_no = String.valueOf(tabletList.get(0).getImeiNo());
	sim = String.valueOf(tabletList.get(0).getSimNo());
	mac = String.valueOf(tabletList.get(0).getMac());
	utid = String.valueOf(tabletList.get(0).getUtid());
} */


List<MasVillage> villageList= new ArrayList<MasVillage>();
if(map.get("villageList") != null){
	villageList = (List)map.get("villageList");
	
}

List<MasWard> wardList= new ArrayList<MasWard>();
if(map.get("wardList") != null){
	wardList = (List)map.get("wardList");
	
}

List<MasPostCode> postCodeList= new ArrayList<MasPostCode>();
if(map.get("postCodeList") != null){
	postCodeList = (List)map.get("postCodeList");
	
}

List<PhMasLocality> localityList= new ArrayList<PhMasLocality>();
if(map.get("localityList") != null){
	localityList = (List)map.get("localityList");
	
}

List<PhMasParliyamentAssembly> parliyamentList= new ArrayList<PhMasParliyamentAssembly>();
if(map.get("parliyamentList") != null){
	parliyamentList = (List)map.get("parliyamentList");
	
}

List<PhMasParliyamentAssembly> assemblyList= new ArrayList<PhMasParliyamentAssembly>();
if(map.get("assemblyList") != null){
	assemblyList = (List)map.get("assemblyList");
	
}

List<PhMasPanchayat> panchayatList= new ArrayList<PhMasPanchayat>();
if(map.get("panchayatList") != null){
	panchayatList = (List)map.get("panchayatList");
	
}

List<MasRank> masRank= new ArrayList<MasRank>();
if(map.get("masRankList") != null){
	masRank = (List)map.get("masRankList");
	
}


 
%>

<div class="clear"></div>
<div class="clear"></div>
<div id="testDiv">
<div class="Block">

<label><span>*</span> Institution Code</label>
 <input id="codeId"  type="text"	name="<%= CODE%>" value="<%=masHospital.getHospitalCode()%>" validate="Institution Code,metachar,yes"	MAXLENGTH="8" tabindex=1 />
  <label ><span>*</span> Institution Name</label> 
  <input id="hospitalName" type="text" name="<%= SEARCH_NAME %>" value="<%=masHospital.getHospitalName()%>"  validate="Institution Name,metachar,yes"	MAXLENGTH="100" tabindex=1	onkeypress="return submitenter(this,event,'user?method=addHospital')" />
  <input id="nameChange" type="hidden" name="nameChange" value="" 	MAXLENGTH="30" tabindex=1	 />
  
  <script>
document.hospital.<%=CODE%>.focus();
</script> 

<label>Spark ID</label> 
<input type="text"	 name="sparkId" id="sparkId" value="<%=masHospital.getSparkId()!=null?masHospital.getSparkId():""%>"	validate="Spark ID,int,no" MAXLENGTH="12" tabindex=1 /> 


<div class="clear"></div>
<label>Institution Short Name</label> 
<input type="text"	 name="institutionShortName" id="institutionShortName" value="<%=masHospital.getShortName()!=null?masHospital.getShortName():""%>"	validate="Institution Short Name,metachar,no" MAXLENGTH="100" tabindex=1 /> 



<label><span>*</span> Institution Type</label> 
<select name="hospitalTypeId" id="hospitalTypeId" validate="Institution Type,metachar,yes" onchange="dropDownChange();" onblur="dropDownChange();">
<option value="0">Select</option>
 <%
				         		if(masHospitalTypeList != null){ 	
				         				for (MasHospitalType hospitalType :masHospitalTypeList) 
				         				{
				         					if(hosTypeId==hospitalType.getId()){%>
				         					
						         			 <option value="<%=hospitalType.getId()%>" selected="selected"><%=hospitalType.getHospitalTypeName() %></option> 		
						      	<%}else{ 
						         						%>
				         		
					  					 <option value="<%=hospitalType.getId()%>"><%=hospitalType.getHospitalTypeName() %></option> 
				        				<%		
				        					      						}
				        		 } }
				        %>
			      </select>


<input id="typeChange" type="hidden" name="typeChange" value="" 	MAXLENGTH="30" tabindex=1	 />

<%--<label>Parent Institutions</label> 
<select name="parentInstitute" id="parentInstitute">
<option value="0">Select</option>
 <% 
				         		if(masHospitalList != null){ 	
				         				for (MasHospital hospital :masHospitalList) {
				         					if(hospital.getStatus().equalsIgnoreCase("y")){
				         						
				         						if(parentIstituteId==hospital.getId()){
				         						%>
				         					<option value="<%=hospital.getId()%>" selected="selected"><%=hospital.getHospitalName() %></option> 		
				      	<%}else{ 				         						%>
					  
						 <option value="<%=hospital.getId()%>"><%=hospital.getHospitalName().trim()%></option> 
				        <%	}	
				        			}
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
if(document.getElementById("hospitalTypeId")!=null){
ins= document.getElementById("hospitalTypeId").value;
}
	return entry+"&districtId=" + dist+"&instType="+ins;                                                                       
}
</script>
	<label>Parent Institutions</label>
<input type="text" name="instName" id="Institute" onblur="getHospitalId();" tabindex="1" value="<%=parentInstituteName %>">
				<div id="instDiv" style="display: none;"
												class="autocomplete"></div> 
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('Institute','instDiv','generalMaster?method=getHospitalListForAutoCompleteItem',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>
					<input type="hidden" name="parentInstitute" id="parentInstitute" value="<%=parentIstituteId %>">
<%--added by govind 18-05-2017 end --%>

			     <div class="clear"></div>
			     <label>Head of Institution</label> 
			     
			<select name="headInst" id="headInst">
    <option value="0">Select</option>
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

			         							if (masEmployee.getFirstName()!= null) {
				         							eName = masEmployee.getFirstName();
				         						}
				         						if (masEmployee.getMiddleName()!= null) {
				         							eName += masEmployee.getMiddleName();
				         						}
				         						if (masEmployee.getLastName()!= null) {
				         							eName += masEmployee.getLastName();
				         						}
				         						if(hodId==masEmployee.getId()){
				         							
				         						%>
					         					
							         			 <option value="<%=masEmployee.getId()%>" selected="selected"><%=eName %></option> 		
							      	<%}else{ 
							         						%>
					  
						 <option value="<%=masEmployee.getId()%>"><%=eName%></option> 
				        <%	}	
				         					}	}
				        		 } 
				        %>
			      </select>
 --%>

<label> <span>*</span>Address</label>
<%	if(address!=null){%>
<input type="text" name="<%= ADDRESS %>" id="hospitalAdd"	value="<%=address%>" validate="Address Name,metachar,yes" MAXLENGTH="70" tabindex=1 />
<%}else{ %>
<input type="text" name="<%= ADDRESS %>" id="hospitalAdd"	value="" validate="Address Name,metachar,yes" MAXLENGTH="70" tabindex=1 />
<%} %>

<label>Street</label>
<%	if(street!=null){%>
<input type="text" name="street"  id="street"	value="<%=street %>" validate="Address Street,metachar,no" MAXLENGTH="70" tabindex=1 />
<%}else{ %>
<input type="text" name="street"  id="street"	value="" validate="Address Street,metachar,no" MAXLENGTH="70" tabindex=1 />
<%} %>
<div class="clear"></div>

<label> District</label>
<select name="districtId" id="districtId"  validate="District,metachar,no" tabindex=1 onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getTalukList&district='+this.value,'testDivs');" tabindex=1>
<%	if(districtList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = districtList.iterator(); iterator.hasNext();) {
					 MasDistrict d = (MasDistrict) iterator.next();
							if(d.getDistrictName()!=null){
						if(districtId==d.getId()){
						%>
     					
	         			 <option value="<%=d.getId()%>" selected="selected"><%=d.getDistrictName() %></option> 		
	      	<%
						}else{ 
	         						%>
				  <option value="<%=d.getId()%>"><%=d.getDistrictName().trim()%></option>
				  <%}
	      	}	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>


<div id="testDivs">


<label>Taluk</label>
<select name="talukId" validate="Taluk,metachar,no"   tabindex=1   onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getVillageList&taluk='+this.value,'tDiv');">
<%	if(talukList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = talukList.iterator(); iterator.hasNext();) {
					 MasTaluk t = (MasTaluk) iterator.next();
						if(t.getTalukName()!=null){
				  if(null !=masHospital.getTaluk() && masHospital.getTaluk().getId()==t.getId()){%>
					         					
							         			 <option value="<%=t.getId()%>" selected="selected"><%=t.getTalukName() %></option> 		
							      	<%}else{ 
							         						%>
				  <option value="<%=t.getId()%>"><%=t.getTalukName().trim()%></option>
				  <%
							      	}}}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	
</select>



<label>Village</label>
<select name="village" validate="Village,metachar,no"   tabindex=1   onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getWardList&villageId='+this.value,'vDiv');">
<%	if(villageList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = villageList.iterator(); iterator.hasNext();) {
					 MasVillage v = (MasVillage) iterator.next();
						if(v.getVillageName()!=null){
					  if(masHospital.getVillage()!=null && masHospital.getVillage().getId()==v.getId()){%>
   					
	         			 <option value="<%=v.getId()%>" selected="selected"><%=v.getVillageName() %></option> 		
	      	<%}else{ 
	         						%>
				  <option value="<%=v.getId()%>"><%=v.getVillageName().trim()%></option>
				  <%
	      	}}}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
<div class="clear"></div>



<label>Ward</label>
<select name="wardId" validate="Ward,metachar,no"   tabindex=1   onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getLocalityList&wards='+this.value,'wDiv');" >
<%	if(wardList.size()>0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = wardList.iterator(); iterator.hasNext();) {
					 MasWard w = (MasWard) iterator.next();
					 if(w.getWardName()!=null){
					 if(masHospital.getWard()!=null && masHospital.getWard().getId()==w.getId()){%>
	   					
         			 <option value="<%=w.getId()%>" selected="selected"><%=w.getWardName() %></option> 		
      	<%}else{ 
         						%>
				  <option value="<%=w.getId()%>"><%=w.getWardName().trim()%></option>
				  <%
      	}}}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
<label>Locality</label>
<select name="locality" validate="Locality,metachar,no"   tabindex=1   >
<%	if(localityList.size()>0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = localityList.iterator(); iterator.hasNext();) {
					 PhMasLocality l = (PhMasLocality) iterator.next();
					 if(l.getLocalityName()!=null){
					 if(masHospital.getAdd3Locality()!=null && masHospital.getAdd3Locality().getId()==l.getId()){%>
	   					
         			 <option value="<%=l.getId()%>" selected="selected"><%=l.getLocalityName() %></option> 		
      	<%}else{ 
         						%>
				  <option value="<%=l.getId()%>"><%=l.getLocalityName().trim()%></option>
				  <%
				  	 	}}}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	



<label>Post Office</label>

<select name="postOfficeId" validate="Post Office,metachar,no"  onchange="populatePinCode(this.value);"  tabindex=1  >
<%	if(postCodeList.size()>0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = postCodeList.iterator(); iterator.hasNext();) {
					 MasPostCode po = (MasPostCode) iterator.next();
					 if(po.getPostCodeName()!=null){
						 if(masHospital.getPostOffice()!=null && masHospital.getPostOffice().getId()==po.getId()){%>
	   					
         			 <option value="<%=po.getId()%>" selected="selected"><%=po.getPostCodeName().trim()%></option> 		
      	<%}else{ 
         						%>
				  <option value="<%=po.getId ()%>"><%=po.getPostCodeName().trim()%></option>
				  <%
      	} 	}}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	
   
   
 <div class="clear"></div>
  <label>PIN</label>
  <%if(masHospital.getPostOffice()!=null){ %>
   <input type="text" name="pincode"  id="pincode"	value="<%=masHospital.getPostOffice().getPinCode() %>" validate="PIN,int,yes" MAXLENGTH="20" tabindex=1 />
<%}else{ %>
<input type="text" name="pincode"  id="pincode"	value="" validate="PIN,int,no" MAXLENGTH="20" tabindex=1 />
<%} %>
 




<label>Parliament</label>
  <select name="parliament" validate="Parliament,metachar,no"   tabindex=1   onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getAssemblyList&parliamentId='+this.value,'pDiv');">
<%	if(parliyamentList.size()>0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = parliyamentList.iterator(); iterator.hasNext();) {
					 PhMasParliyamentAssembly pp = (PhMasParliyamentAssembly) iterator.next();
					 if(pp.getName()!=null){
						 if(masHospital.getParliament()!=null && masHospital.getParliament().getId()==pp.getId()){%>
	   					
         			 <option value="<%=pp.getId()%>" selected="selected"><%=pp.getName() %></option> 		
      	<%}else{ 
         						%>
				  <option value="<%=pp.getId ()%>"><%=pp.getName().trim()%></option>
				  <%
      	}	}}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>

<label>Assembly</label>
<!-- <select name="assembly" validate="Assembly,string,yes"   tabindex=1   onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getPanchayatList&assemblyId='+this.value,'aDiv');"> -->
<select name="assembly" validate="Assembly,metachar,no"   tabindex=1   >
<%	if(assemblyList.size()>0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = assemblyList.iterator(); iterator.hasNext();) {
					 PhMasParliyamentAssembly a= (PhMasParliyamentAssembly) iterator.next();
					 if(a.getName()!=null){
						 if(masHospital.getAssembly()!=null && masHospital.getAssembly().getId()==a.getId()){%>
	   					
         			 <option value="<%=a.getId()%>" selected="selected"><%=a.getName() %></option> 		
      	<%}else{ 
         						%>
				  <option value="<%=a.getId ()%>"><%=a.getName().trim()%></option>
				  <%
				  	 	}}}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>

   <!-- 
  <label>Panchayat</label>
<select name="panchayat" validate="Panchayat,string,no"   tabindex=1   >
<%	if(panchayatList.size()>0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = panchayatList.iterator(); iterator.hasNext();) {
					 PhMasPanchayat pp= (PhMasPanchayat) iterator.next();
				  %>
				  <option value="<%=pp.getId ()%>"><%=pp.getPanchayatName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	 -->
</div>	
 <div class="clear"></div>
<label> <span>*</span>Contact Number</label> 
<%if(contactNumber!=null){ %>
<input type="text" 	name="<%= CONTACT_NUMBER %>" id="hospitalContact" value="<%=contactNumber %>"	validate="Contact Number,metachar,no" MAXLENGTH="12" tabindex=1 />
<%}else{ %>
<input type="text" 	name="<%= CONTACT_NUMBER %>" id="hospitalContact" value=""	validate="Contact Number,metachar,no" MAXLENGTH="12" tabindex=1 />
<%} %> 

<label>LSG</label> 
<select name="lsg" id="lsg" onchange="lsgData();">
 <option value="">Select</option>
 <%if(masHospital.getLsgType()!=null){ %>
 <%if(masHospital.getLsgType().equalsIgnoreCase("Panc")){ %>
  <option value="Panc" selected="selected">Panchayath</option>
  <option value="Munic">Municipality</option>
  <option value="Corpo">Corporation</option>
  <%}if(masHospital.getLsgType().equalsIgnoreCase("Munic")){ %>
  <option value="Panc">Panchayath</option>
 <option value="Munic"  selected="selected">Municipality</option>
 <option value="Corpo">Corporation</option>
 <%}if(masHospital.getLsgType().equalsIgnoreCase("Corpo")){ %>
 <option value="Panc">Panchayath</option>
 <option value="Munic">Municipality</option>
 <option value="Corpo" selected="selected">Corporation</option>
 <%}}else{ %>
 
 <option value="Panc">Panchayath</option>
 <option value="Munic">Municipality</option>
 <option value="Corpo">Corporation</option>
 <%} %>
</select>
	<%if(masHospital.getLsgType()!=null){ %>
	<%if(masHospital.getLsgType().equalsIgnoreCase("Panc")){ %>
   <div id="panchayathId" style="display:inline;">
   <label>LSG Panchayath Name</label>
    <input type="text" name="lsgName"  id="lsgName"	value="<%=lsgName %>"  validate="LSG Panchayath Name,metachar,no" MAXLENGTH="20" tabindex=1 />
   </div>
   <%}%>
   <%if(!masHospital.getLsgType().equalsIgnoreCase("Panc")){ %>
   <div id="panchayathId" style="display:none;">
   <label>LSG Panchayath Name</label>
    <input type="text" name="lsgName"  id="lsgName"	value=""  validate="LSG Panchayath Name,metachar,no" MAXLENGTH="20" tabindex=1 />
   </div>
   <%} %>
   <%if(masHospital.getLsgType().equalsIgnoreCase("Munic")){ %>
   <div id="municipalityId" style="display:inline;">
   <label>LSG Municipality Name</label>
    <input type="text" name="lsgName"  id="lsgName"	value="<%=lsgName%>" validate="LSG Municipality Name,metachar,no" MAXLENGTH="20" tabindex=1 />
   </div>
 	<%}%>  
   <%if(!masHospital.getLsgType().equalsIgnoreCase("Munic")){ %>
   <div id="municipalityId" style="display:none;">
   <label>LSG Municipality Name</label>
    <input type="text" name="lsgName"  id="lsgName"	value="" validate="LSG Municipality Name,metachar,no" MAXLENGTH="20" tabindex=1 />
   </div>
 	<%}%>
   <%if(masHospital.getLsgType().equalsIgnoreCase("Corpo")){ %>
   <div id="corporationId" style="display: inline;">
   <label>LSG Corporation Name</label>
    <input type="text" name="lsgName"  id="lsgName"	 value="<%=lsgName%>" validate="LSG Corporation Name,metachar,no" MAXLENGTH="20" tabindex=1 />
    <%}%>
    <%if(!masHospital.getLsgType().equalsIgnoreCase("Corpo")){ %>
   <div id="corporationId" style="display: none;">
   <label>LSG Corporation Name</label>
    <input type="text" name="lsgName"  id="lsgName"	 value="" validate="LSG Corporation Name,metachar,no" MAXLENGTH="20" tabindex=1 />
    
    <%}}else{ %>
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
    
    <%} %>
   </div>
   </div>

<div class="clear"></div>


  <label>Email Id</label>
  <%if(landLine!=null){ %>
   <input type="text" name="email"  id="email"	value="<%=emailId %>" validate="" MAXLENGTH="20" tabindex=1 />
<%}else{ %>
<input type="text" name="email"  id="email"	value="" validate="" MAXLENGTH="20" tabindex=1 />
<%} %>
<label>Land Line</label>
<%if(landLine!=null){ %>
   <input type="text" name="landLine"  id="landLine" value="<%=landLine %>" validate="Land Line,metachar,no" MAXLENGTH="20" tabindex=1 />
   <%}else{ %>
   <input type="text" name="landLine"  id="landLine" value="" validate="Land Line,metachar,no" MAXLENGTH="20" tabindex=1 />
   <%} %>
   
   
   
     
   <label>  Electrical Section</label>
<select name="electricalSectionId" id="electricalSectionId"  validate="Electrical Section,metachar,no" tabindex=1  tabindex=1>
<%	if(electricalSectionList.size() !=0){
%>
				<option value="">Select</option>
				 <%
				 for (Iterator iterator = electricalSectionList.iterator(); iterator.hasNext();) {
					 PhMasElectricalSection e = (PhMasElectricalSection) iterator.next();
					 if(masHospital.getElectricalSection()!=null && masHospital.getElectricalSection().getId()==e.getId()){%>
				  <option value="<%=e.getId()%>" selected="selected"><%=e.getElectricalSectionName().trim()%></option> 		
				  <%}else{ %>
				  <option value="<%=e.getId()%>"><%=e.getElectricalSectionName().trim()%></option>
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
   <%if(sanctionBed!=0){ %>
   <input type="text" name="sanctionBed"  id="sanctionBed"	value="<%=sanctionBed %>" validate="Sanction Bed,int,no" MAXLENGTH="4" tabindex=1 />
  <%}else{ %>
  <input type="text" name="sanctionBed"  id="sanctionBed"	value="" validate="Sanction Bed,int,no" MAXLENGTH="4" tabindex=1 />
  <%} %>
  
  
   <label>KMSCL Institute Code</label>
     <%if(kmsclInstituteCode!=null){ %>
   <input type="text" name="kmsclInstituteCode"  id="kmsclInstituteCode"	value="<%=kmsclInstituteCode %>" validate="KMSCL Institute Code,metachar,no" MAXLENGTH="20" tabindex=1 />
    <%}else{ %>
   <input type="text" name="kmsclInstituteCode"  id="kmsclInstituteCode"	value="" validate="KMSCL Institute Code,metachar,no" MAXLENGTH="20" tabindex=1 />
  <%} %>
   
    <label>KMSCL Category</label>
  
    <select name="kmsclCategory" id="kmsclCategory" validate="KMSCL Category,metachar,no">
	    <option value="">Select</option>
	      <%	if(kmsclCategory!= null && !kmsclCategory.equals("")){
	    	  if(kmsclCategory.equalsIgnoreCase("Primary")){
	     
%>
	    <option value="Primary" selected="selected">Primary</option>
	    <option value="Secondary">Secondary</option>
	    <%}else if(kmsclCategory.equalsIgnoreCase("Secondary")){ %>
	     <option value="Primary">Primary</option>
	    <option value="Secondary" selected="selected">Secondary</option>
	    <%}}else{ %>
	    <option value="Primary">Primary</option>
	    <option value="Secondary">Secondary</option>
	    <%} %>
    </select>
   <div class="clear"></div>   
 <label>Server IP</label>
   <input type="text" name="serverIp"  id="serverIp" value="<%=masHospital.getServerIp() !=null ? masHospital.getServerIp():""%>" MAXLENGTH="20" tabindex=1 />
<label>Server Port</label>
   <input type="text" name="serverPort"  id="serverPort" value="<%= masHospital.getServerPort() !=null ? masHospital.getServerPort():""%>" MAXLENGTH="20" tabindex=1 />
<label>Client IP</label>
   <input type="text" name="clientIp"  id="clientIp" value="<%= masHospital.getClientIp() !=null ? masHospital.getClientIp():""%>" MAXLENGTH="20" tabindex=1 />
    <div class="clear"></div> 
<label>Client Port</label>
   <input type="text" name="clientPort"  id="clientPort" value="<%= masHospital.getClientPort() !=null ? masHospital.getClientPort():""%>" MAXLENGTH="20" tabindex=1 />
    
  <label>Longitude</label>
  <%if(longitude!=null){ %>
   <input type="text" name="longitude"  id="longitude"	value="<%=longitude %>" validate="Longitude,metachar,no" MAXLENGTH="20" tabindex=1 />
   <%}else{ %>
   <input type="text" name="longitude"  id="longitude"	value="" validate="Longitude,metachar,no" MAXLENGTH="20" tabindex=1 />
   <%} %>
 <label>Latitude </label>
 <%if(latitude!=null){ %>
   <input type="text" name="latitude"  id="latitude"	value="<%=latitude %>" validate="Latitude,metachar,no" MAXLENGTH="20" tabindex=1 />
  <%}else{ %>
   <input type="text" name="latitude"  id="latitude"	value="" validate="Latitude,metachar,no" MAXLENGTH="20" tabindex=1 />
  <%} %>
  <div class="clear"></div>

<label>SIM No</label>
<input type="text" name="sim" value="<%=sim %>" id="imeiNo" maxlength="32" /> 
	
<label>IMEI No</label>
<input type="text" name="imeiNo" value="<%=imei_no %>" id="imeiNo" maxlength="40" /> 

<label>MAC</label>
<input type="text" name="mac" value="<%=mac %>" id="imeiNo" maxlength="40" /> 
<label>UTID</label>
<input type="text" name="utid" value="<%=utid %>" id="imeiNo" maxlength="40" /> 
<%-- <%} %> --%>
<label>Blood Bank Availability</label>

<%if(bbAvilable.equals("y")) {%>
<input type="checkbox" name="bbAvailability"  id="bbAvailabilityId"	value="" onclick="setBloodBankStatus();"  tabindex=1 checked="checked"/>
<input type="hidden" name="bbAvailability2"  id="bbAvailabilityId2"	value="y" />
 <%}else{ %>
<input type="checkbox" name="bbAvailability"  id="bbAvailabilityId"	value="" onclick="setBloodBankStatus();"  tabindex=1 />
<input type="hidden" name="bbAvailability2"  id="bbAvailabilityId2"	value="n" />
<%}%>

<label>Counter Wise Token Display</label> 
<%if(counterWiseTokenDisplay.equals("y")) {%>
<input type="checkbox" name="counterWiseTokenDisplay"  id="counterWiseTokenDisplay"	value="y"  tabindex=1 checked="checked"/>

 <%}else{ %>
<input type="checkbox" name="counterWiseTokenDisplay"  id="counterWiseTokenDisplay"	value="n"   tabindex=1 />

<%}%>




<div class="clear"></div>


<!-- added by amit das on 17-07-2017 -->
<label>Multi Lab</label> 
<%if(multiLab.equals("y")) {%>
<input type="checkbox" name="multiLab"  id="multiLab" onclick="selectMultiLab()"	value="y"  tabindex=1 checked="checked"/>

 <%}else{ %>
<input type="checkbox" name="multiLab"  id="multiLab" onclick="selectMultiLab()"	value="n"   tabindex=1 />

<%}%>

<label>Speciality Type</label>
<select name="specialityType" id="specialityType" validate="Speciality Type,metachar,no">
	    <option value="">Select</option>
	      <%	if(specialityType!= null && !specialityType.equals("")){
	    	  if(specialityType.equalsIgnoreCase("Simple")){
	     %>
	    <option value="Simple" selected="selected">Simple</option>
	 	    <option value="Medium">Medium</option>
	 	     <option value="Complex">Complex</option>
	    <%}else if(specialityType.equalsIgnoreCase("Medium")){ %>
	     <option value="Simple">Simple</option>
	      <option value="Medium" selected="selected">Medium</option>
	     <option value="Complex">Complex</option>
	     <%}else if(specialityType.equalsIgnoreCase("Complex")){ %>
	     <option value="Simple">Simple</option>
	        <option value="Medium">Medium</option>
	      <option value="Complex" selected="selected">Complex</option>
	       
	    <%}}else{ %>
	       <option value="Simple">Simple</option>
	    <option value="Medium">Medium</option>
	    <option value="Complex">Complex</option>
	    <%} %>
    </select>


    
</div>


<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>

 <input type="hidden" name="<%= COMMON_ID%>" id="<%= COMMON_ID%>"	 value="<%=masHospital.getId()%>" />
 
<input type="hidden" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('hospital','user?method=addHospital','checkBlankForAddHospital');"	accesskey="a" tabindex=1 />

<input type="button" name="edit"	id="editbutton" value="Update"  class="button"	onClick="submitForm('hospital','user?method=editHospital')"	accesskey="u" tabindex=1 /> 
<%if(masHospital.getStatus().equals("y") || masHospital.getStatus().equals("Y")){ %>
<input type="button" name="Delete"	id="deletebutton" value="InActivate"  class="button"	onClick="submitForm('hospital','user?method=deleteHospital&flag='+this.value)"	accesskey="d" tabindex=1 />
<%}if(masHospital.getStatus().equals("n") || masHospital.getStatus().equals("N")){ %>
<input type="button" name="Delete"	id="deletebutton" value="Activate" 	 class="button"	onClick="submitForm('hospital','user?method=deleteHospital&flag='+this.value)"	accesskey="d" tabindex=1 />
<%} %>
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onClick="submitFormForButton('hospital','user?method=showHospitalJsp');" accesskey="r" /> 

<input type="button"	name="Back" value="Back" class="button" accesskey="b"	onclick="submitFormForButton('hospital','superAdmin?method=showModuleManagementJsp')"	tabindex=1 />
</div>
<script type="text/javascript">
function selectMultiLab(){
	if(document.getElementById('multiLab').checked==true){
		document.getElementById('multiLab').value="y";
	}else if(document.getElementById('multiLab').checked==false){
		document.getElementById('multiLab').value="n";
	}
}
</script>