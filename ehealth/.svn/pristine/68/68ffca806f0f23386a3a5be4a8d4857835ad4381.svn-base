
<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* registration.jsp
* Purpose of the JSP -  This is for Registration.
* @author  Rajesh
* Create Date: 14th Nov,2008
* Revision Date:
* Revision By:
* @version 1
--%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@page import="jkt.hms.masters.business.MasSetupParameterMaintaince"%>
<%@page import="jkt.hms.masters.business.HospitalParameters"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hrms.masters.business.MasQualification"%>
<%@page import="jkt.hrms.masters.business.HrMasQualification"%>
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hms.masters.business.MasLsgType"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasVisaType"%>
<%@page import="jkt.hms.masters.business.PhMasLocalityType"%>
<%@page import="jkt.hms.masters.business.PhMasLocality"%>
<%@page import="jkt.hms.masters.business.MasIdCard"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.util.List"%>

<%@ page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.PatientCategoryDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.REG_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_TYPE_ID"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.EMPLOYEE_DEPENDENT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.GENDER"%>
<%@ page import="static jkt.hms.util.RequestConstants.MOBILE"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_AADHAAR_NUMBER"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_LAST_NAME"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.PATIENT_DEPARTMENT"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_MIDDLE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_FIRST_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_FULL_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.REG_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.COMPANY"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMPLOYEE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.PROJECT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.TITLE"%>
<%@ page import="static jkt.hms.util.RequestConstants.DATE_OF_BIRTH"%>
<%@ page import="static jkt.hms.util.RequestConstants.AGE"%>
<%@ page import="static jkt.hms.util.RequestConstants.AGE_UNIT"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELIGION"%>
<%@ page import="static jkt.hms.util.RequestConstants.CASTE"%>
<%@ page import="static jkt.hms.util.RequestConstants.ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.NATIONALITY"%>
<%@ page import="static jkt.hms.util.RequestConstants.STATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.DISTRICT"%>
<%@ page import="static jkt.hms.util.RequestConstants.BLOCK"%>
<%@ page import="static jkt.hms.util.RequestConstants.POST_OFFICE"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_DISTRICT"%>
<%@ page import="static jkt.hms.util.RequestConstants.PINCODE"%>
<%@ page import="static jkt.hms.util.RequestConstants.PHONE"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMAIL_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.OCCUPATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.REFERENCE"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATIVE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMERGENCY_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMERGENCY_PHONE"%>
<%@ page import="static jkt.hms.util.RequestConstants.REMARKS"%>
<%@ page import="static jkt.hms.util.RequestConstants.COMPLAINT_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR"%>
<%@ page import="static jkt.hms.util.RequestConstants.CASE_TYPE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.TOKEN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HOSPITAL_STAFF"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.HOUSE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.STREET_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.VILLAGE"%>
<%@ page import="static jkt.hms.util.RequestConstants.SUB_DISTRICT"%>

<%@ page import="static jkt.hms.util.RequestConstants.LOCALITY"%>
<%@ page import="static jkt.hms.util.RequestConstants.LSG_HOUSE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.LSG_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.WARD"%>
<%@ page import="static jkt.hms.util.RequestConstants.HOUSE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HEALTH_HOUSE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.PURPOSE"%>
<%@ page import="static jkt.hms.util.RequestConstants.VISANAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.PASSPORTNUMBER"%>
<%@ page import="static jkt.hms.util.RequestConstants.NATIVE_SUB_CENTRE"%>
<%@ page import="static jkt.hms.util.RequestConstants.EDUCATION"%>
<%@ page import="static jkt.hms.util.RequestConstants.YOB"%>
<%@ page import="static jkt.hms.util.RequestConstants.BPL_STATUS"%>
<%@ page import="static jkt.hms.util.RequestConstants.APL_STATUS"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>

<script lang="javascript" src="/hms/jsp/js/csrfToken.js"
	type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/proto.js"
	type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/ajax.js"
	type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/prototype.js"
	type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/scriptaculous.js"
	type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/unittest.js"
	type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/registration.js"
	type="text/javascript"></script>

<script>
function aa(id){
	alert(id);
	return false;
}

function trimName(i){
	i.value =	i.value.trim();
	console.log("=="+i.value+"==")
}
</script>

<%
        
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String currentTime = (String)utilMap.get("currentTime");
	
       Map<String, Object> map = new HashMap<String, Object>();
       
       if(request.getAttribute("map") != null)
       {
               map=(Map<String, Object>)request.getAttribute("map");
       }

       String userName = "";
       if(session.getAttribute("userName") != null)
       {
               userName = (String)session.getAttribute("userName");
       }

       List<MasDistrict> districtList = new ArrayList<MasDistrict>();
       
       List<Object[]> patientTypeList = new ArrayList<Object[]>();
       List<Object[]> otherCategoryList = new ArrayList<Object[]>();
       
       List<MasRelation> relationList = new ArrayList<MasRelation>();
       List<Object[]> postCodeList = new ArrayList<Object[]>();
		List<Object[]> villageList = new ArrayList<Object[]>();
		List<MasQualification> educationList=new ArrayList<MasQualification>();
		List<MasLsg> lsgNameList=new ArrayList<MasLsg>();
		List<MasLsgType> lsgTypeList=new ArrayList<MasLsgType>();
		List<MasTaluk> talukList=new ArrayList<MasTaluk>();
		List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasVisaType> visaTypeList=new ArrayList<MasVisaType>();
		List<PhMasLocalityType> 	localityTypeList=new ArrayList<PhMasLocalityType>();
		List<Object[]> 	localityList=new ArrayList<Object[]>();
       List<Object[]> titleList = new ArrayList<Object[]>();
       List<Object[]>casteList=new ArrayList<Object[]>();
       List<Object[]> religionList = new ArrayList<Object[]>();
       List<MasIdCard> idCardList=new ArrayList<MasIdCard>();
       List<Object[]> subCenterList=new ArrayList<Object[]>();
       List<Object[]> wardList = new ArrayList<Object[]>();
       List<MasScheme> packageSchemeList = null; // added by amit das on 05-05-2016

       
       List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
       List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
       
       HospitalParameters hospitalParameters=new HospitalParameters();
       MasSetupParameterMaintaince systemParam = new MasSetupParameterMaintaince();
 
       // For visit creation details  along with registration
       
       List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		
		if (map.get("departmentList") != null) 
		{
			departmentList = (List<MasDepartment>) map.get("departmentList");
		}

		if (map.get("complaintList") != null) 
		{
			complaintList = (List<MasComplaint>) map.get("complaintList");
		}
       
       String uhid=null;
       int districtIdByHospital=0;
       
       String mobileNumber="";
       String dateOfBirth="";
       String hinNo="";
       int district=0;
       String fullname="";
       Map<String, Object> getDataMap = null;
       
       if(map.get("puhid") != null)
       {
               uhid = (String)map.get("puhid");
       }

       if(null!=map.get("Searchmap")){
    		 
    		 getDataMap=(Map<String, Object>)map.get("Searchmap");
    		 
    		 if(null!=getDataMap.get("mobileNumber")){
    		 mobileNumber=(String)getDataMap.get("mobileNumber");
    		 }
    		 if(null!=getDataMap.get("hinNo")){
    		 hinNo=(String)getDataMap.get("hinNo");
    		 }
    		 if(null!=getDataMap.get("fullName")){
    		 fullname=(String)getDataMap.get("fullName");
    		 }
    		 if(null!=getDataMap.get("dateOfBirth")){
    		 dateOfBirth=(String)getDataMap.get("dateOfBirth");
    		 }
    		 if(null!=getDataMap.get("district")){
    		 district=(Integer)getDataMap.get("district");}
       }
       
       if(map.get("districtId") != null)
       {
    	   districtIdByHospital=(Integer)map.get("districtId");
       }
       
       if(map.get("subCenterList") != null)
       {
    	   subCenterList=(List<Object[]>)map.get("subCenterList");
       }
       
       if(map.get("patientTypeList") != null)
       {
               patientTypeList= (List<Object[]>)map.get("patientTypeList");
       }
       
       if(map.get("otherCategoryList") != null)
       {
    	   otherCategoryList= (List<Object[]>)map.get("otherCategoryList");
       }
       
       if(map.get("casteList") != null)
       {
               casteList = (List<Object[]>)map.get("casteList");
       }
       
       if (map.get("sexList") != null)
       {
               sexList = (List<MasAdministrativeSex>) map.get("sexList");
       }
       if (map.get("bloodGroupList") != null) {
               bloodGroupList = (List<MasBloodGroup>) map.get("bloodGroupList");
       }
       if(map.get("religionList") != null)
       {
               religionList = (List<Object[]>)map.get("religionList");
       }
       if(map.get("localityList") != null)
       {
    	   localityList = (List<Object[]>)map.get("localityList");
       }
       
       if(map.get("districtList") != null)
       {
    	   districtList = (List<MasDistrict>)map.get("districtList");
       }
       if(map.get("visaTypeList") != null)
       {
    	   visaTypeList = (List<MasVisaType>)map.get("visaTypeList");
       }
      
      if(map.get("relationList") != null)
      {
    	  relationList = (List<MasRelation>)map.get("relationList");
      }
      if(map.get("postCodeList") != null)
      {
    	  postCodeList = (List<Object[]>)map.get("postCodeList");
      }
      if(map.get("villageList") != null)
      {
    	  villageList = (List<Object[]>)map.get("villageList");
      }
      if(map.get("educationList") != null)
      {
    	  educationList = (List<MasQualification>)map.get("educationList");
      }
      if(map.get("lsgNameList") != null)
      {
    	  lsgNameList =(List<MasLsg>)map.get("lsgNameList");
      } 
      if(map.get("lsgTypeList") != null)
      {
    	  lsgTypeList =(List<MasLsgType>)map.get("lsgTypeList");
      } 
      if(map.get("talukList") != null)
      {
    	  talukList =(List<MasTaluk>)map.get("talukList");
      } 
      if(map.get("occupationList") != null)
      {
    	  occupationList =(List<MasOccupation>)map.get("occupationList");
      } 
      if(map.get("stateList") != null)
      {
    	  stateList =(List<MasState>)map.get("stateList");
      } 
      if(map.get("idCardList") != null)
      {
    	  idCardList =(List<MasIdCard>)map.get("idCardList");
      } 
      
      if(map.get("countryList") != null)
      {
    	  countryList =(List<MasCountry>)map.get("countryList");
      } 
      
      if(map.get("wardList") != null)
      {
    	  wardList =(List<Object[]>)map.get("wardList");
      }
      
      if(map.get("packageSchemeList") != null)
      {
    	  packageSchemeList =(List<MasScheme>)map.get("packageSchemeList");
      }
      
      int defaultRelationId=0;
      if(map.get("defaultRelationId") != null)
      {
    	  defaultRelationId =(Integer)map.get("defaultRelationId");
      } 
    
      if (map.get("hospitalParameters") != null)
      {
              hospitalParameters = (HospitalParameters) map.get("hospitalParameters");
      }
      
      if (map.get("systemParam") != null)
      {
              systemParam = (MasSetupParameterMaintaince) map.get("systemParam");
      }
      String ctizenDob="";
      String scitizenName="";
      String ctizenMob="";
      
      if (map.get("ctizenDob") != null)
      {
    	  ctizenDob = (String) map.get("ctizenDob");
      }
      
      if (map.get("citizenName") != null)
      {
    	  scitizenName = (String) map.get("citizenName");
      }
      String citzenAadhaar="";
      if (map.get("citzenAadhaar") != null)
      {
    	  citzenAadhaar = (String) map.get("citzenAadhaar");
      }
      if (map.get("ctizenMob") != null)
      {
    	  ctizenMob = (String) map.get("ctizenMob");
      }
       
       URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
       try
       {
    	   prop.load(resourcePath.openStream());
       }
       catch (Exception e)
       {
               e.printStackTrace();
       }

       String selectedTitleForReg = prop.getProperty("selectedTitleForReg");
       String patientTypeIdCode = prop.getProperty("patientTypeIdCode");

       String administrativeSexMaleCode = prop.getProperty("administrativeSexMaleCode");
       String indiaCode = prop.getProperty("indiaCode");
       String departmentTypeCodeForCR = prop.getProperty("departmentTypeCodeForCR");
       String empCategoryCodeForDoctor = prop.getProperty("empCategoryCodeForDoctor");
       String aadhaarAddressTypeCode = prop.getProperty("aadhaarAddressTypeCode");
       String permanentAddressTypeCode = prop.getProperty("permanentAddressTypeCode");
       String temporaryAddressTypeCode = prop.getProperty("temporaryAddressTypeCode");
       String kerala_state_id=prop.getProperty("kerala_state_id");
       String obsGynecDept  = prop.getProperty("deptCodeAnteNatalClinic");
       
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
<h2>Search</h2>
<form method="post" name="patientRegistersearch">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
	<div class="Block">

		<!--<label>UHID</label>
                       <input type="text" id="" name="<%=HIN_NO%>"
                               value="" tabindex="1" validate="UHID,int,no" MAXLENGTH="16" />    
  -->

		<input type="button" class="button" value="QR Scan" tabindex="1"
			onclick="aadhaarQrScanForCitizen()" />
		<div class="clear"></div>
		<div class="clear"></div>
		<label> Aadhaar No.</label> <input type="text" id="saadhaarNumberId"
			name="citzenAadhaar" value="<%=citzenAadhaar %>" tabindex="1"
			validate="Aadhaar No,int,no" MAXLENGTH="12" /> <label> Name</label>
		<input type="text" id="spNameId" name="<%=P_FULL_NAME %>"
			value="<%=scitizenName %>" tabindex="1"
			title="Full Name of the Patient"
			validate="Patient Name,metacharDot,no" MAXLENGTH="50"
			onkeypress="return searchKeyPress(event);"  /> <input type="hidden"
			name="districtId" value="<%=districtIdByHospital%>" /> <label>DOB</label>

		<input type="text" id="sbirthDayId" name="birthDay" tabindex="1"
			value="<%=ctizenDob %>" class="date" validate="Birth Day,date,no"
			class="date" onblur="validateExpDate(this,'sbirthDayId')"
			onkeyup="mask(this.value,this,'2,5','/');" MAXLENGTH="10"
			onkeypress="return searchKeyPress(event);" />

		<div id="sdobcalId">
			<img id="" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0"
				onclick="setdate('<%=currentDate %>',document.patientRegistersearch.birthDay,event)"
				validate="Birth Day,date,no" onblur="" onchange="" tabindex="1" />
		</div>
		<div class="clear"></div>
		<label>Mobile</label> <input type="text" name="<%=MOBILE_NO %>"
			id="smobileNo" value="<%=ctizenMob %>" validate="Mobile,phone,no"
			MAXLENGTH="12" tabindex="1"
			onkeypress="return searchKeyPress(event);" /> <label>District</label>
		<select name="sdistrict" id="sdistrict" tabindex="1"
			validate="District,int,no" onChange="">
			<option value="0">Select</option>
			<%
			for(MasDistrict masDistrict : districtList){ %>

			<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>

			<% }
%>
		</select> <label>LSG Name</label><select name="<%=LSG_NAME %>" id="slsgNameId"
			tabindex="1" validate="LSG Name,int,no">
			<option value="0">Select</option>
			<% for(MasLsg masLsg:lsgNameList){ %>
			<option value="<%=masLsg.getId()%>"><%=masLsg.getLsgTypeName() %></option>

			<%	}
			
				%>

		</select>
		<div class="clear"></div>
		<label>LSG Type</label><select name="<%=LSG_TYPE %>" id="slsgTypeId"
			tabindex="1" validate="LSG Name,int,no" >
			<option value="0">Select</option>
			<% for(MasLsgType masLsg:lsgTypeList){ %>
			<option value="<%=masLsg.getId()%>"><%=masLsg.getLsgTypeName() %></option>

			<%	}
			
				%>

		</select> <label>Ward</label> <select name="<%=WARD_NO %>" tabindex="1"
			id="swardId" validate="Ward,int,no">
			<option value="">Select</option>
			<%
for(Object[] ward:wardList){
	%>
			<option value="<%=ward[0]%>">
				<%=ward[1] %></option>
			<% 
}
%>

		</select>

		<%-- <input type="text" name="<%=WARD_NO %>" value=""
				 maxlength="32" tabindex="1" id="swardId"
				onblur="" /> --%>

		<label>Colony House No.</label><input type="text"
			name="<%=T_HOUSE_NO %>" value="" maxlength="32" tabindex="1" validate="Colony House No,string,no"
			id="houseId" onblur="" />


		<div class="clear"></div>

		<div class="clear"></div>
		<input type="button" id="citizensearchId" name="search" value="Search"
			class="button" tabindex="1"
			onClick="if(checkSearchFiled()){submitForm('patientRegistersearch','/hms/hms/registration?method=searchPatientFromCitizen&'+csrfTokenName+'='+csrfTokenValue)}" />

		<input type="reset" tabindex="1" name="Reset" value="Cancel"
			class="button"
			onclick="submitProtoAjax('patientRegistersearch','registration?method=getPatientName&'+csrfTokenName+'='+csrfTokenValue)"
			accesskey="r" />
		<div class="clear"></div>
	</div>

	<%
 Map<String,Object> searchDataMap = new HashMap<String,Object>();
 
 	List<PhMemberSurvey> searchDataList=null;
 searchDataList=new ArrayList<PhMemberSurvey>();

 String address="";
 boolean citizenStatus=false;
 int currentPage=0;
 int noOfPages=0;
 String citizenName="";
 String cdob="";
 String cmobileNumber="";
 
 if(null !=map.get("searchDataMap")){
	 searchDataMap=(Map<String,Object>)map.get("searchDataMap");
 if(null!=searchDataMap.get("currentPage")){
	 
	 currentPage=(Integer)searchDataMap.get("currentPage");
	 noOfPages=(Integer)searchDataMap.get("noOfPages");
 
	 
	 if(null!=searchDataMap.get("searchDataList")){
		 searchDataList=(List<PhMemberSurvey>)searchDataMap.get("searchDataList");
		
		  }
	 if(null!=searchDataMap.get("fullName")){
		 citizenName=(String)searchDataMap.get("fullName");
		
		  }
	 if(null!=searchDataMap.get("mob")){
		 cmobileNumber=(String)searchDataMap.get("mob");
		
		  }
	 if(null!=searchDataMap.get("dob")){
		 cdob=(String)searchDataMap.get("dob");
		
		  }
	
	 if(null!=searchDataMap.get("citizenStatus")){
		 citizenStatus=(Boolean)searchDataMap.get("citizenStatus");
		
		  }
 }
 %>
	<% 
	if(null !=searchDataList && searchDataList.size()>0){
		
		
		%>
	<div class="cmntable">
		<table>

			<tr>
				<th>Name</th>
				<th>Gender</th>
				<th>Age</th>
				<th>Address</th>
			</tr>


			<% 
		String dob="";
		String gender="";
		Date dd=null;
		String pdistrict="";
		String housname="";
		String streetname="";
		String citizenAddress="";
		for(PhMemberSurvey patient:searchDataList){
			if(null !=patient.getDateOfBirth()){
			dd=patient.getDateOfBirth();
			dob=HMSUtil.calculateAge(dd);
			}
			if(null!=patient.getGender()){
				gender=patient.getGender().getAdministrativeSexName();
			}
			if(null!=patient.getAadhaarDistrict()){
				pdistrict=patient.getAadhaarDistrict().getDistrictName();
			}
			if(null!=patient.getHouseName())
			housname=patient.getHouseName();
			if(null!=patient.getStreetName())
			streetname= patient.getStreetName();
			
			citizenAddress=housname+"     "+streetname+"    "+pdistrict;
			%>
			<tr
				onclick="populateDataFromCitizen('<%=patient.getId()%>');HighLightTR(this)"
				style="cursor: pointer;">


				<td><%=patient.getName()%></td>
				<td><%=gender%></td>
				<% if(null!=dob){%>
				<td><%=dob%></td>
				<%}else{
		%>
				<td></td>
				<% 
	}
	%>
				<td><%=citizenAddress%></td>

			</tr>
			<%
		}
		%>
		</table>
	</div>
	<div class="clear"></div>
	<% 
		
if(currentPage !=1){%>
	<a
		href='/hms/hms/registration?method=searchPatientFromCitizen&page=<%=currentPage-1%>&cmob=<%=cmobileNumber%>&uh=<%=hinNo%>&fn=<%=citizenName%>&dob=<%=cdob%>&dist=<%=district%>'>Previous</a>


	<% 
		}
		if(noOfPages>=1){
		//	for(int i=1;i<=noOfPages;i++){
			//	if(currentPage==i){
					%>
	<%-- 
					<%=i%>
					<% 
				}
				else{%> --%>



	<a
		href='/hms/hms/registration?method=searchPatientFromCitizen&page=<%=currentPage%>&cmob=<%=cmobileNumber%>&uh=<%=hinNo%>&fn=<%=citizenName%>&dob=<%=cdob%>&dist=<%=district%>'><%=currentPage%></a>
	<% 	
			/* 	}
			} */
		}

		if(currentPage <noOfPages){
			%>

	<a
		href='/hms/hms/registration?method=searchPatientFromCitizen&page=<%=currentPage+1%>&cmob=<%=cmobileNumber%>&uh=<%=hinNo%>&fn=<%=citizenName%>&dob=<%=cdob%>&dist=<%=district%>'>Next</a>
	</td>



	<% }

	else{
		%>
	<!-- <h4>No Record Found</h4> -->
	<!-- <font size="4" weight="bold" color="red">No Record Found </font> -->
	<!-- commented by arbind on 14-02-2017 -->
	<% 
	} %>

	<div class="Block">
		<!-- added by amit 22-01-2017 -->
		<input type="text" id="inPage" maxlength="4" style="width: 30px;" /><input
			type="button" value="Go" onclick="searchParticularPage();" /> <label>
			No of Pages : <%=noOfPages%></label>
		<!-- added by amit das end-->
	</div>

	<%} else {	%>
	<font size="4" weight="bold" color="red">No Record Found </font>
	<!-- Added by arbind on 01-03-2017 -->
	<% } 
 }%>

	<div id="patientDtDiv"></div>

</form>

<!--Patient Photo Place holder-->
<form name="registration" id="form1" method="post">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
	<div class="clear"></div>
	<div class="titleBg">
		<h2>Patient Registration</h2>
	</div>
	<div class="clear"></div>

	<!-- UHID registration starts  -->
	<div class="Block">

		<div align="right">
			<%-- <jsp:include page="testImageUpload.jsp">
			<jsp:param value="610444" name="hinNo"/> 
			</jsp:include> --%>
		</div>
		<div class="clear"></div>
		<input type="hidden" name="citizenSearch" value=""
			id="citizenSearchId" /> <label>Aadhaar</label> <input type="radio"
			tabindex="1" name="radio1" value="aadhaar" class="inputRadiobutton"
			id="aadhaarRadioId"
			onclick="showRadioDivs('aadharrDiv', 'otherIDDiv', 'noIDDiv','qrScanDiv','eKYCDiv', this)" />

		<label>Other ID</label> <input type="radio" tabindex="1" name="radio1"
			value="otherId" id="otherIdReg" class="inputRadiobutton"
			onclick="showRadioDivs('otherIDDiv', 'noIDDiv', 'aadharrDiv','qrScanDiv','eKYCDiv', this)" />

		<label>No ID</label> <input type="radio" tabindex="1"
			checked="checked" name="radio1" value="noId" id="nnoId"
			class="inputRadiobutton"
			onclick="showRadioDivs('noIDDiv', 'aadharrDiv', 'otherIDDiv','qrScanDiv','eKYCDiv', this),validateDobfalse()" />
		<div class="clear"></div>

		<div id="aadharrDiv" style="display: none;">
			<label>QR Scan</label> <input type="radio" tabindex="1" id="QRScanId"
				name="radio2" value="qrScan" class="inputRadiobutton"
				onclick="showQReKYCDivs('qrScanDiv', 'eKYCDiv', this)" /> <label>eKYC</label>
			<input type="radio" name="radio2" tabindex="1"
				class="inputRadiobutton" id="eKycId" value="eKyc"
				onclick="showQReKYCDivs('eKYCDiv', 'qrScanDiv', this)" />
			<div class="clear"></div>
		</div>



		<div id="otherIDDiv" style="display: none;">
			<label>Other ID Card</label> <select name="otherIdCard" tabindex="1" validate="Other ID Card,int,no">
				<option value="">Select</option>
				<% for(MasIdCard idCard : idCardList){%>
				<option value="<%=idCard.getId()%>"><%=idCard.getIdCardName() %></option>
				<%}%>
			</select> <input type="text" tabindex="1" name="otherIdCardNumber"
				maxlength="16" value="" validate="Other ID Card,metachar,no" id="OtherIdCardId" />
			<!-- <input type="button" tabindex="1" name="Search" value="Search" class="button"
					onClick="" /> -->
			<div class="clear"></div>
		</div>
		<div id="noIDDiv" style="display: none;"></div>


		<!--This div shows QR scan details  start-->


		<div id="qrScanDiv" style="display: none;">
			<div class="clear"></div>
			<input type="button" class="button" value="QR Scan" tabindex="1"
				onclick="aadhaarQr()" />
			<!-- <input type="button" class="button"  tabindex="1" value="QR Scan" onclick="aadhaar()"/> -->
			<div class="clear"></div>
			<div id="QRcAadharId" style="display: none">
				<label>Aadhaar No. <span>*</span></label> <input type="text"
					id="pQAadhaarNumberId" name="<%=Q_P_AADHAAR_NUMBER%>" value=""
					tabindex="1" onkeypress="return isNumberKey(event)"
					validate="Aadhaar,int,no" MAXLENGTH="12" />
			</div>
		</div>


		<div id="eKYCDiv" style="display: none;">
			<label>Aadhaar No.</label> <input type="password"
				name="aadhaarNumber" tabindex="1" MAXLENGTH="12"
				id="aadhaarNumberId" onchange="VerhoeffAlgorithm(this.value)" /> <input
				type="hidden" name="otpTxn" tabindex="1" id="otpTxn" />
			<!-- onkeypress="return isNumberKey(event)" -->
			<input type="button" tabindex="1" id="ekycOtp" name="Generate OTP"
				value="KYC Generate OTP" class="button"
				onClick="if(ekycFiledCheck()){eKycAuthenticationOtp();}" />

			<label>OTP.</label> <input type="text" id="otp" name="otp"
				disabled="disabled" tabindex="1" value="" id="otp" "/> <input
				type="button" id="Authenticate" tabindex="1" name="Authenticate"
				value="Send KYC Request" class="button" disabled="disabled"
				onClick="if(ekycOtpFiledCheck()){eKycAuthentication();}" />
			<div class="clear"></div>
			<div id="EkycAadharId" style="display: none">
				<label>Aadhaar No.</label> <input type="password"
					id="pEAadhaarNumberId" name="<%=E_P_AADHAAR_NUMBER%>" value=""
					tabindex="1" onkeypress="return isNumberKey(event)" validate=""
					MAXLENGTH="12" />

			</div>
			<input type="hidden" id="aadhaarVerifyStatus"
				name="aadhaarVerifyStatus" value="" tabindex="1" validate=""
				MAXLENGTH="12" />
		</div>
		<div id="phAadhaarDiv" style="display: none;">
			<label>Aadhaar No.</label> <input type="text" id="phAadhaarNumberId"
				name="aadhaarNo" value="" tabindex="1"
				onkeypress="return isNumberKey(event)" validate="" MAXLENGTH="12" />
		</div>
		<div>
			<div class="clear"></div>

			<input type="hidden" name="familyID" id="familyID" value="" /> <input
				type="hidden" name="memberID" id="memberID" value="" /> <input
				type="hidden" name="bloodGroupValueId" id="bloodGroupValueId"
				value="" /> <input type="hidden" name="citizenData"
				id="citizenDataId" value="" /> <label>Name<span>*</span></label> 
				<input
				type="text" id="pNameId" onchange ="trimName(this);" autofocus
				name="<%=P_FULL_NAME %>" value="" tabindex="1"
				title="Full Name of the Patient" 
				validate="Patient Name,metacharDot,yes" MAXLENGTH="50" /> 
				
				<label>Name
				of</label> <select name="<%=RELATION_ID%>" id="relId" validate="Aadhaar,int,no"
				tabindex="2" class="">
				<option value="" selected="selected">select</option>
				<%
					for(MasRelation masRelation:relationList ){
					if(defaultRelationId>0 && defaultRelationId==masRelation.getId()){%>
				<option value="<%=masRelation.getId()%>" ><%=masRelation.getRelationName() %></option>
				<% }
					else{
					%>
				<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName() %></option>

				<%}
					}
					%>
			</select>
			<!-- <label>&nbsp;</label> -->
			<input id="relativeNameId" type="text" name="<%=RELATION_NAME %>"
				value="" validate="Relative Name,string,no" maxlength="128"
				tabindex="3" /> <input type="hidden" tabindex="1" class="small"
				name="relativeNameTemp" id="relativeNameTemp" value="" />

			<div class="clear"></div>
			<input type="hidden" name="NationDob" id="nationalDobId" value="" />
			<label>DOB<span>*</span></label> <input type="text" id="dobId"
				name="<%=DATE_OF_BIRTH %>" tabindex="" value=""
				onblur="validateExpDate(this,'sbirthDayId')"
				onkeyup="mask(this.value,this,'2,5','/');"
				onchange="calculateAgeInAjax(),enableAgeAndAgeUnitFiled()"
				MAXLENGTH="10" validate="DOB,date,yes" class="date" />
				<!-- readonly="readonly" /> -->

			<div id="dobcalId">
				<img id="calImageId" src="/hms/jsp/images/cal.gif" width="16"
					height="" border="0"
					onclick="setdate('<%=currentDate %>',document.getElementById('dobId'),event)" />
			</div>

			<input type="hidden" name="dobIdTemp" id="dobIdTemp" value=""
				tabindex="1" /> <label>Year of Birth</label> <input type="text"
				class="inputSmall" id="yobId" tabindex="" name="<%=YOB %>"
				readonly="readonly" maxlength="4" /> <label>Age<span
				id="agId">*</span></label>
			<div id="ageDiv">
				<input type="text" name="<%=AGE %>" id="age" class="inputSmall"
					maxlength="3" tabindex="1" validate="Age,int,yes" 
					onblur="checkForDOB(),calculateApproxDobFromAge(),checkForBaby();" onkeypress="return isNumber(event)" /> <input
					type="hidden" name="ageTemp" id="ageTemp" value="" /> <input
					type="hidden" name="tempageUnitId" value="" id="tempageUnitId" /> <select
					id="ageUnitId" name="<%=AGE_UNIT %>" validate="AgeUnit,string,no"
					tabindex="" class="small" onchange="checkForDOB();checkForBaby();">
					<option selected="selected" value="Years">Years</option>
					<option value="Months">Months</option>
					<option value="Days">Days</option>
				</select>
			</div>
			<div class="clear"></div>
			<label>Gender<span>*</span></label> <select id="gender"
				name="<%=GENDER %>" tabindex="1" validate="gender,int,yes" maxlength="30"
				onChange="changeGender();">
				<option value="">Select</option>
				<%
               for(MasAdministrativeSex masAdministrativeSex : sexList)
               {
                       if(masAdministrativeSex.getAdministrativeSexCode().equals(administrativeSexMaleCode))
                       {
%>
				<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
				<%                        }
                       else
                       {
%>
				<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
				<%
                       }
               }
%>
			</select> <input type="hidden" name="genderTemp" id="genderTemp" value="0" />
			<input type="hidden" name="ageUnitIdTemp" id="ageUnitIdTemp" value="" />

		</div>


		<!--This div shows eKYC  details End -->


		<label>Family Income Status<span id="famId"></span></label> <label>BPL</label>
		<input type="radio" tabindex="4" id="bplId" name="<%=BPL_STATUS %>"
			value="bpl" onclick="displayBplTextBox(this.value)"
			class="inputRadiobutton" /> <label>APL</label><input tabindex="5"
			type="radio" name="<%=BPL_STATUS %>" id="aplId" value="apl"
			onclick="displayBplTextBox(this.value)" style="margin: 0px 5px" />
		<div id="bplTextDiv" style="display: none">
			<div class="clear"></div>
			<label>BPL Number</label> <input type="text" name="bplTextbox"
				id="bplTextbox" maxlength="20" tabindex="6" validate="BPL Number,string,no" />
		</div>
		<div class="clear"></div>
		<label>Monthly Income</label> <input type="text" name="monIncome"
			id="monIncome" maxlength="6" tabindex="1" validate="Monthly Income,float,no"
			onchange="monthlySalary(this.value)" />

		<!-- Added by amit das on 05-05-2016 -->
		<label>Rsby Card No.</label> <input type="text" name="rsbyCardNo"
			id="rsbyCardNo" maxlength="7" tabindex="7" validate="Rsby Card No,string,no"/> <label
			class="label auto">Rsby Card Package Scheme</label> <select
			name="rsbyCardPkgScheme" id="rsbyCardPkgScheme" tabindex="8" validate="Rsby Card Package Scheme,int,no">
			<% if(packageSchemeList!=null && packageSchemeList.size()>0) {
					for(MasScheme pkgscheme : packageSchemeList){
					%>
			<option value="<%=pkgscheme.getId()%>"><%=pkgscheme.getSchemeName()%></option>
			<% } } %>
		</select>
		<!-- ended by amit das on 05-05-2016 -->

		<div class="clear"></div>
		<label>Social<span id="socId"></span>
		</label> <select id="patientTypeId" name="<%=PATIENT_TYPE_ID %>" tabindex="9"
			validate="Social,int,no"
			onchange="checkMLC(this.value);calculateValidUptoDateInAjax('registration'); displayCompanyList();checkForPatientType();"
			onblur="">
			<option value="0">Select</option>
			<%
       String registrationValidDate="";
       int validationDays=0;
       int patientTypeIdSelected=0;
       
       if(patientTypeIdCode!="")
       {
               patientTypeIdSelected=Integer.parseInt(patientTypeIdCode);
       }
       for(Object[] masPatientType : patientTypeList)
       {
               if(Integer.parseInt(""+masPatientType[0])==patientTypeIdSelected)
               {
                       validationDays=Integer.parseInt(""+masPatientType[3]);
%>
			<option value="<%=masPatientType[0]%>" selected="selected"><%=masPatientType[2]%></option>
			<%
               }
               else
               {
%>
			<option value="<%=masPatientType[0]%>"><%=masPatientType[2]%></option>
			<%
               }
       }
%>
		</select> <label>Other Category</label> <select id="otherCategoryId"
			tabindex="10" multiple="multiple" class="multiple" validate="Other Category,int,no"
			name="<%=OTHER_CATEGORY%>">
			<option value="0">select</option>
			<%
				if(null != otherCategoryList){
				for(Object[] otherCategory : otherCategoryList)
			       {
				
				%>
			<option value="<%=otherCategory[0]%>"><%=otherCategory[2]%></option>
			<%
			       }
				}
				%>
		</select> <label class="auto">Mobile</label> <input type="text"
			name="mobileNoVerify" value="" id="mobileNoId"
			onchange="getNameAndMobile(this.value),ValidateMobNumber('mobileNoId');"
			validate="Mobile Number,phone,no" tabindex="10" MAXLENGTH="10" /> <input
			type="button" class="button" id="VerifyID" name="Verify"
			Value="eHealth Verify" onclick="openOPT()" />
		<div id="VerifiedID" style="display: none">
			<input type="button" class="button" id="VerifId" name="Verified"
				Value="Verified" />
		</div>
		<div class="clear"></div>
		<label>Blood Group</label> <select id="bloodGroupId"
			name="bloodGroupId" tabindex="10" validate="Blood Group,int,no"
			onchange="displayBloodGroupName(this.value)">
			<option value="">Select</option>
			<%
               for(MasBloodGroup bloodGroup : bloodGroupList){%>
			<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName() %></option>

			<% }%>
		</select> <input type="hidden" name="bloodGroupName" id="bloodGroupName"
			value="" />
	</div>
	<div class="clear"></div>
	<div class="titleBg">
		<h2>Visit Details</h2>
	</div>
	<div class="Block">
		<div class="clear"></div>
		<label>Visit No</label> <input type="text" tabindex="10"
			name="<%=VISIT_NUMBER %>" id="visitNoId" value="0"
			readonly="readonly" /> <label>Visit Date</label> <input type="text"
			validate="Visit Date,date,no" tabindex="10" name="<%=VISIT_DATE%>"
			value="<%=currentDate %>" readonly="readonly" /> <label>Visit
			Time</label> <input type="text" tabindex="10" name="<%=VISIT_TIME%>"
			value="<%=currentTime %>" readonly="readonly" />
		<div class="clear"></div>
		<label>Complaint Type</label> <select id="compltId" tabindex="10"
			name="<%=COMPLAINT_ID%>" validate="Complaint,int,no"
			tabindex="39">
			<option value="0">Select</option>
			<%for(MasComplaint masComplaint : complaintList)
		{%>
			<option value="<%=masComplaint.getId() %>"><%=masComplaint.getComplaintName()%></option>
			<%}%>
		</select>

		<input type="hidden" name="onlineRegStatus" value=""
			id="onlineRegStatusID" />

		<div class="clear"></div>
		<label>Service Center</label> <input type="radio" name="serviceCenter"
			checked="checked" id="opClinicServiceCenter"
			value="OP Clinic Service Center"
			onclick="getServiceCentersList('op clinic');"
			style="margin: 0px 6px 5px 5px" /> <label>Op Clinic Service
			Center</label> <input type="radio" name="serviceCenter"
			id="otherServiceCenter" value="Other Service Center"
			onclick="getServiceCentersList('other');" style="margin-right: 10px" />

		<div id="opDeptDiv">
			<label style="width: 129px">Other Service Centre</label> <select
				id="deptId" name="<%=PATIENT_DEPARTMENT %>" tabindex="1"
				onchange="getSessionForDepartment(this.value); populateUnitForDepartment(this.value,'unit','loddrs','deptId','reg');getEmployeeDepartment(this.value);"
				validate="Service Center,int,no">
				<option value="0">Select</option>
				<%int departmentId = 0;
				for(MasDepartment masDepartment : departmentList)
		{%>
				<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
				<%}%>
			</select>
				<input type="hidden" name="empDeptCode" id="empDeptCodeId" value="" />
		</div>

		<div id="otherDeptDiv" style="display: none">
			<label style="width: 129px">Other Service Centre</label> <select
				id="othercenterId" name="<%=PATIENT_DEPARTMENT %>" tabindex="1"
				onchange="getSessionForDepartment(this.value); populateUnitForDepartment(this.value,'unit','loddrs','othercenterId','reg');getEmployeeDepartment(this.value);"
				validate="Service Center,int,no" style="width:">
				<option value="0">Select</option>
			</select>
		</div>
		<label>OP Session</label> <select id="opsession" name="opsession"
			validate="Session,string,no" tabindex="10">
			<option value="0">Select</option>
		</select> <label>Unit</label> <select id="unit" name="unit" tabindex="10"
			validate="unit,metachar,no"
			onchange="populateDoctorForUnit(this.value,'reg','deptId')">
			<option value="">Select</option>
		</select>

		<label>Doctors Incharge</label> <input type="text"
			name="<%=EMPLOYEE_ID %>" id="consultingDocId" value=""
			readonly="readonly" validate="Doctors Incharge,metachar,no" />
		<%-- <select name="<%=EMPLOYEE_ID %>" id="consultingDocId" tabindex=""
				title="Consulting Doctor & Total Current Visit">
				<option value="">Select</option>
				
			</select> --%>

	 	<label> Doctors</label> <select name="loddrs" id="loddrs"
			tabindex="10" title="" validate="loddrs,int,no" onchange="getAssignedPatientForDoctorSpecific(this.value)"
			>
			<option value="">select</option>
		</select>
		<input name="patientCount" id="patientCount" value="" readonly="readonly" style="text-align: center;font-size:15px;width:25px;margin-left:0;background:#5bc0de;"/>	
		<div class="clear"></div>
		<label>Current Proirity No.</label> <select id="priorityId"
			name="priorityName" tabindex="10" validate="Current Proirity No,int,no" >
			<option value="3">3</option>
			<option value="2">2</option>
			<option value="1">1</option>
		</select> <label>Cash Received</label> <input type="checkbox" tabindex="1"
			checked="checked" name="cashreceived" id="cashreceived" value="y"
			onclick="cashNotReceived()" style="margin: 0px 5px;" />
		<div id="cashNotReceived" style="display: none;">
			<label>Reason</label> <select id="cashReason" name="cashReason"
				style="margin-left: 3px; width: 162px;" tabindex="1" validate="Reason,string,no">
				<option value="">Select</option>
				<option value="Accident">Accident</option>
				<option value="Medico Legal">Medico Legal</option>
				<option value="Staff">Staff</option>
				<option value="Foreigner">Foreigner</option>
				<option value="UnKnown Patient">UnKnown Patient</option>
				<option value="Below 18 Years">Below 18 Years</option>
			</select>
		</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div class="titleBg">
		<h2>Address</h2>
	</div>
	<div class="Block">
		<div class="clear"></div>

		<label>Aadhaar</label> <input type="radio" name="radio3" tabindex="11"
			class="inputRadiobutton" value="Aadhaar" id="aadhaar" disabled="disabled"
			onclick="showAddressDivs('aadharrAddDiv', 'permanentAddDiv', 'temporaryAddDiv', this,'aadhaar')" />

		<label>Permanent</label> <input type="radio" name="radio3"
			tabindex="12" class="inputRadiobutton" checked="checked"
			value="Permanent" id="permanent"
			onclick="showAddressDivs('permanentAddDiv', 'temporaryAddDiv', 'aadharrAddDiv', this,'permanent')" />

		<label>Temporary</label> <input type="radio" name="radio3"
			tabindex="13" class="inputRadiobutton" value="Temporary"
			id="temporary"
			onclick="showAddressDivs('temporaryAddDiv', 'aadharrAddDiv', 'permanentAddDiv', this,'temporary')" />

		<div class="clear"></div>


		<div class="clear"></div>
		<div id="aadharrAddDiv" class="" style="display: none;">
			<input type="hidden" name="ad" tabindex="" value=""
				id="aadhaarAddrID" /> <label>House Name</label> <input type="text"
				id="pHouseName" name="<%=HOUSE_NAME %>" value="" tabindex="14"
				validate="House Name,metacharSpaceSlashDash,no" MAXLENGTH="32" /> <label>Street Name</label><input
				type="text" id="streetName" name="<%=STREET_NAME %>" value=""
				tabindex="15" validate="Street Name,metacharSpaceSlashDash,no" MAXLENGTH="32" /> <label>District</label>
			<select name="<%=A_DISTRICT%>" id="cityId" tabindex="16" validate="District,int,no" maxlength="32"
				onChange="Javascript: populsubDistrictByDistrictId(this.value);
				populateAPincodeByDistrict(this.value);populateSubCenterByHospital(this.value); populateAadhaarVillageTown(this.value);">
				<option value=" ">Select</option>
				<%
		int districtId=0;
		String stateName="";
		
		for(MasDistrict masDistrict : districtList)
		{%>
				<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
				<%
}
%>
			</select>

			<div class="clear"></div>
			<label>Taluk</label> <select name="<%=A_TALUK%>" id="SubcityId"
				tabindex="17" validate="talukId,int,no"
				onchange="populateAadhaarVillageByTaluk(this.value)">

				<!-- onChange="if(fillNokAddr()){populateBlock(this.value,'registration')} -->
				<option value=" ">Select</option>

				<% 	for(MasTaluk masTaluk:talukList){ %>
				<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
				<%}
				%>

			</select> <label>Village</label><select id="villageId" name="<%=VILLAGE %>"
				tabindex="18" validate="village,int,no">
				<option value=" ">Select</option>
				<% 		
				int villageId=0;
				for(Object[] masVillage : villageList)
		{
			%>

				<option value="<%=masVillage[0]%>"><%=masVillage[1] %></option>
				<%
		}
%>
			</select> <label>Post Office</label> <select name="<%=A_POST_OFFICE %>"
				id="postOff" onchange="populatePinCode(this.value);"
				validate="Post Office,int,no" tabindex="19">
				<option value=" ">Select</option>
				<% for (Object[] masPostOff:postCodeList ){ %>
				<option value="<%=masPostOff[0]%>"><%=masPostOff[1] %></option>
				<% 
				}
			%>
			</select>
			<div class="clear"></div>
			<label>Pin Code</label><input type="text" id="pincode"
				name="<%=A_PINCODE%>" value="" tabindex="20" validate="Pin Code,metachar,no"
				MAXLENGTH="15" />

			<!--  <label>Copy As </label> -->
			<input type="button" tabindex="1" class="buttonBig3"
				value="Copy As Permanent" onclick="aadhaarAddressToPermanent()" />
		</div>

		<div id="permanentAddDiv" class="">
			<input type="hidden" name="permAddr" value="y" id="permAddr"
				tabindex="21" /> <label>District</label><select
				name="permanentDistrict" id="pcityId" tabindex="21" validate="District,int,no"
				onChange="permanentsubDistrictByDistrictId(this.value);populatePPincodeByDistrict(this.value);lsgByDistrict('plsgNameId',this.value);">
				<option value="">Select</option>
				<%
		
		
		for(MasDistrict masDistrict : districtList)
		{%>
				<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
				--%>
				<%		
}
%>
			</select>

			<label>Taluk</label><select name="<%=P_TALUK%>" id="talukId"
				tabindex="22" validate="Taluk,int,no">
				<option value="">Select</option>
				<% 	for(MasTaluk masTaluk:talukList){ %>

				<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
				<%}
				%>
			</select> <label>LSG Name</label><select name="<%=P_LSG_NAME %>"
				id="plsgNameId" tabindex="23" validate="LSG Name,int,no"
				onchange="populatePPWardByLsg('pWardId',this.value);">
				<option value=" ">Select</option>
				<% for(MasLsg masLsg:lsgNameList){ %>
				<option value="<%=masLsg.getId()%>"><%=masLsg.getLsgTypeName() %></option>

				<%	}
			
				%>

			</select>
			<div class="clear"></div>
			<label>Ward</label> <select name="<%=P_WARD %>" id="pWardId"
				tabindex="24" validate="Ward,int,no" id="wardId"
				onchange="populatePPLocalityByWardLsg('pWardId','plsgNameId','locality');">
				<option value="">select</option>
				<% for(Object[] ward:wardList){ %>
				<option value="<%=ward[0]%>"><%=ward[1] %></option>

				<%	}
			
				%>
			</select>

			<label>Locality</label><select name="<%=P_LOCALITY %>" id="locality"
				tabindex="25" validate="Locality,int,no">
				<option value="">Select</option>

				<% for(Object[] locality:localityList ){ %>
				<option value="<%=locality[0]%>"><%=locality[1] %></option>

				<%}
				%>
			</select> <label>LSG House No.</label><input type="text"
				name="<%=P_LSG_HOUSE_NO %>" id="<%=P_LSG_HOUSE_NO %>" value=""
				validate="LSG House No,string,no" maxlength="32" tabindex="26" />
			<div class="clear"></div>
			<label>Area</label><input type="text" name="<%=P_HOUSE_NO %>"
				value="" validate="Area,metachar,no" maxlength="32" tabindex="1" id="PhouseId"
				onblur="" /> <label>Post Office</label> <select
				name="<%=P_POST_OFFICE %>" id="pppostOff"
				onchange="populatePinCodeForPost(this.value);" validate="Post Office,int,no"
				tabindex="28">
				<option value="0">Select</option>

				<% for (Object[] masPostOff:postCodeList ){ %>
				<option value="<%=masPostOff[0]%>"><%=masPostOff[1] %></option>
				<% 
				}
			%>

			</select> <label>Pin Code</label><input type="text" id="ppincode"
				name="<%=P_PINCODE%>" value="" tabindex="29" validate="Pin Code,int,no"
				MAXLENGTH="6" readonly="readonly" />
			<div class="clear"></div>
			<label>Health House Id</label><input type="text" id="<%=P_HEALTH_HOUSE_ID%>"
				name="<%=P_HEALTH_HOUSE_ID%>" value="" tabindex="30" validate="Health House Id,metachar,no"
				MAXLENGTH="32" />
		</div>
		<div id="temporaryAddDiv" class="" style="display: none;">
			<input type="hidden" name="pTempAddr" value="" id="pTempAddr" /> <label>District</label>
			<select name="<%=T_DISTRICT%>" id="tcityId" tabindex="31" validate="District,int,no"
				onChange="tempsubDistrictByDistrictId(this.value);lsgByDistrict('tlsgNameId',this.value);
				populateTPincodeByDistrict(this.value);">
				<option value=" ">Select</option>
				<%
		
		for(MasDistrict masDistrict : districtList)
		{
			%>

				<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
				<%
		}
%>
			</select> <label>Taluk</label><select name="<%=T_TALUK%>" id="ttalukId" validate="Taluk,int,no"
				tabindex="32" onChange="">
				<option value="">Select</option>
				<% 	for(MasTaluk masTaluk:talukList){ %>

				<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
				<%}
				%>
			</select> <label>LSG Name</label><select name="<%=T_LSG_NAME %>"
				id="tlsgNameId" tabindex="33" validate="LSG Name,int,no"
				onchange="populatePPWardByLsg('wardId',this.value);">
				<option value="">Select</option>
				<% for(MasLsg masLsg:lsgNameList){ %>
				<option value="<%=masLsg.getId()%>"><%=masLsg.getLsgTypeName() %></option>

				<%	}
			
				%>
			</select>
			<div class="clear"></div>
			<label>Ward</label>
			<%-- <input type="text" name="<%=T_WARD %>" value=""
				validate="" maxlength="32" tabindex="1" id="wardId"
				onblur="" />  --%>
			<select name="<%=T_WARD %>" tabindex="34" id="wardId" validate="Ward,int,no"
				onchange="populatePPLocalityByWardLsg('wardId','tlsgNameId','Tlocality');">
				<option value="">Select</option>
				<%
	for(Object[] ward:wardList){
	%>
				<option value="<%=ward[0]%>">
					<%=ward[1] %></option>
				<% 
}
%>
			</select> <label>Locality</label><select name="<%=T_LOCALITY %>"
				id="Tlocality" tabindex="35" validate="Locality,int,no">
				<option value=" ">Select</option>
				<%-- 				<% for(PhMasLocalityType locality:localityList ){ %> --%>
				<%-- 				<option value="<%=locality.getId()%>"><%=locality.getLocalityDescription() %></option> --%>

				<%-- 				<%} --%>
				<% for(Object[] locality:localityList ){ %>
				<option value="<%=locality[0]%>"><%=locality[1] %></option>

				<%}
				%>
			</select> <label>LSG House No.</label><input type="text"
				name="<%=T_LSG_HOUSE_NO %>" value=""  tabindex="36" validate="LSG House No,metacharDot,no"
				maxlength="32" />
			<div class="clear"></div>
			<label>Colony House No.</label><input type="text"
				name="<%=T_HOUSE_NO %>" value="" validate="Colony House No,metacharDot,no" maxlength="32"
				tabindex="37" id="<%=T_HOUSE_NO %>" onblur="" /> <label>Post Office</label>

			<select name="<%=T_POST_OFFICE %>" id="tpostOff"
				onchange="popuVillage(this.value)" validate="Post Office,metachar,no" tabindex="38">
				<option value="">Select</option>

				<% for (Object[] masPostOff:postCodeList ){ %>

				<option value="<%=masPostOff[0]%>"><%=masPostOff[1] %></option>
				<% 
				}
			%>

			</select> <label>Pin Code</label><input type="text" id="pincodeID"
				name="<%=T_PINCODE%>" value="" tabindex="39" validate="Pin Code,int,no"
				MAXLENGTH="6" />
			<div class="clear"></div>
			<label>Health House Id</label><input type="text" id="<%=T_HEALTH_HOUSE_ID%>"
				name="<%=T_HEALTH_HOUSE_ID%>" value="" tabindex="40" validate="Health House Id,metachar,no"
				MAXLENGTH="32" />

			<!-- <input type="button" value="ADD More ADDRESSES" class="buttonBig" onclick="" tabindex="1"/>	 -->
		</div>


		<label>Native</label> <input type="radio" name="typeOfNativity"
			value=""  tabindex="41" class="inputRadiobutton"
			onclick="showOtherDetailsDivs('nativeDiv', 'otherIndianStatesDiv', 'foreignerDiv','residentDiv','nrkDiv','nriDiv', this,'native')" />

		<input type="hidden" name="nativeddd" id="nativeId" value=""
			tabindex="" /> <label>From Other Indian States</label> <input
			type="radio" style="margin-right: 5px;" name="typeOfNativity"
			value=""  tabindex="42"
			onclick="showOtherDetailsDivs('otherIndianStatesDiv', 'foreignerDiv', 'residentDiv','nrkDiv','nriDiv','nativeDiv', this,'otherState')" />
		<input type="hidden" name="otherState" id="otherStateId" value=""
			tabindex="" /> <label>Foreigner</label> <input type="radio"
			name="typeOfNativity" value=""  tabindex="43"
			style="margin-right: 5px;"
			onclick="showOtherDetailsDivs('foreignerDiv', 'residentDiv', 'nrkDiv','nriDiv','otherIndianStatesDiv','nativeDiv', this,'foreigner')" />
		<input type="hidden" name="foreigner" id="foreignerId" value=""
			tabindex="" />

		<div class="clear"></div>

		<div id="nativeDiv" style="display: none;">
			<label>Resident</label> <input type="radio" name="nativity"
				id="residentId" value="resident" class="inputRadiobutton"
				onclick="showNativeNrkNriDivs('residentDiv', 'nrkDiv','nriDiv', this)"
				tabindex="44" /> <label>NRK</label> <input type="radio"
				name="nativity" id="nrkId" value="nrk" class="inputRadiobutton"
				onclick="showNativeNrkNriDivs('nrkDiv', 'nriDiv','residentDiv', this)"
				tabindex="45" /> <label>NRI</label> <input type="radio"
				name="nativity" id="nriId" value="nri" class="inputRadiobutton"
				onclick="showNativeNrkNriDivs('nriDiv', 'residentDiv','nrkDiv', this)"
				tabindex="46" />


		</div>
		<div class="clear"></div>
		<div id="residentDiv" style="display: none;"></div>

		<div id="nrkDiv" style="display: none;">
			<label>State</label> <select id="nrkStateId" name="<%=NRK_STATE%>"
				tabindex="47" validate="State,int,no"
				onChange="fillNokAddrOnState();populateDistrict(this.value,'registration')">
				<option value="">Select</option>

				<% for(MasState masState:stateList ){ 
						%>
				<option value="<%=masState.getId()%>"><%=masState.getStateName() %></option>


				<%
					}
				%>

			</select>
		</div>
		<div id="nriDiv" style="display: none;">
			<label>Country</label> <select name="<%= NRI_NATIONALITY %>"
				tabindex="48" validate="Country,int,no" onChange="populateDistByState(this.value)"
				id="nriCountryId">
				<option value="">Select</option>
				<% for(MasCountry country:countryList  ){ %>
				<option value="<%=country.getId()%>"><%=country.getCountryName() %></option>
				<%}
				%>
			</select>
		</div>
		<div id="otherIndianStatesDiv" style="display: none;">
			<label>State</label> <select id="migrantStateId"
				name="<%=MIGRANT_STATE%>" tabindex="49" validate="State,int,no"
				onChange="populateDistByState(this.value)">
				<option value="">Select</option>
				<% 
			 	int stateCode=0;
			       if(kerala_state_id!="")
			       {
			       stateCode=Integer.parseInt(kerala_state_id);
			     	for(MasState masState:stateList ){ 
					if(masState.getId()!=stateCode){%>
				<option value="<%=masState.getId()%>"><%=masState.getStateName() %></option>

				<% }
			 	} }
				%>

			</select> <label>District</label><select name="<%=MIGRANT_DISTRICT%>"
				id="migrantCityId" tabindex="50" validate="District,int,no"
				onChange="if(fillNokAddr()){populateBlock(this.value,'registration')}">
				<option value="">Select</option>
			</select> <label>Purpose</label><select name="<%=MIGRANT_PURPOSE%>"
				id="migrantPurposeId" tabindex="51" validate="Purpose,int,no" onChange="">
				<option value="">Select</option>
				<% for(MasOccupation purpose: occupationList ){ %>
				<option value="<%=purpose.getId() %>"><%=purpose.getOccupationName() %></option>
				<%}
				
				%>
			</select>
		</div>
		<div id="foreignerDiv" style="display: none;">
			<label>Country</label> <select name="<%= FOREIGNER_NATIONALITY %>"
				tabindex="52"validate="Country,int,no" onChange="(this.value,'registration')"
				id="foreignerCountryId">
				<option value=" ">Select</option>
				<% for(MasCountry country:countryList  ){ %>
				<option value="<%=country.getId()%>"><%=country.getCountryName() %></option>
				<%}
				%>
			</select> <label>Passport Number</label> <input type="text" tabindex="53"
				name="<%=PASSPORTNUMBER %>" validate="Passport Number,metachar,no" maxlength="12"
				id="passPortId" /> <label>Purpose</label><select
				name="<%=FOREIGNER_PURPOSE%>" id="foreignerPurposeId" tabindex="54" validate="Purpose,int,no"
				onChange="">
				<option value=" ">Select</option>
				<% for(MasOccupation purpose: occupationList ){ %>
				<option value="<%=purpose.getId() %>"><%=purpose.getOccupationName() %></option>
				<%}
				
				%>
			</select>
			<div class="clear"></div>
			<label>Visa Type</label><select name="<%=VISA_TYPE %>" tabindex="55" validate="Visa Type,int,no"
				onChange="" id="visaTypeId">
				<option value=" ">Select</option>
				<% for(MasVisaType visaType:visaTypeList){ %>
				<option value="<%=visaType.getId()%>"><%=visaType.getVisaTypeName() %></option>

				<%}%>
			</select> <label> Valid From Date<span>*</span></label> <input type="text"
				tabindex="" name="<%=VISA_FROMDATE %>" value="" class="date"
				readonly="readonly" validate="Valid From Date,date,no" MAXLENGTH="30" /> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date,date,no" tabindex="56"
				onclick="setdate('<%=currentDate %>',document.registration.<%=VISA_FROMDATE%>,event)" />

			<label>To Date<span>*</span></label> <input type="text" tabindex=""
				name="<%=VISA_TODATE%>" value="" class="date" readonly="readonly"
				validate="To Date,date,no" MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif"
				width="16" height="16" border="0" validate="Pick a date,date,no"
				tabindex="57"
				onclick="setdate('<%=currentDate %>',document.registration.<%=VISA_TODATE%>,event)" />
		</div>

		<div class="clear"></div>
		<label>Email Id</label> <input type="text" name="<%=EMAIL_ID %>"
			value="" validate="Enter Email Id,email,no" MAXLENGTH="40"
			tabindex="58" id="emailId" onblur="alert('hiiii');checkNativity();" />
		<label>Occupation</label> <select name="<%=OCCUPATION_ID %>"
			validate="Occupation,int,no" tabindex="59" id="occupationId" onblur="checkNativity();">
			<option value=" ">Select</option>
			<% for(MasOccupation purpose: occupationList ){ %>
			<option value="<%=purpose.getId() %>"><%=purpose.getOccupationName() %></option>
			<%}
				
				%>
		</select> <label>Education</label> <select name="<%=EDUCATION %>" validate="Education,int,no"
			tabindex="60" id="educationId" onblur="checkNativity();">
			<option value=" ">Select</option>
			<% for(MasQualification education: educationList){ %>
			<option value="<%=education.getId()%>"><%=education.getQualificationName() %></option>
			<%}
			
			%>
		</select>
		<div class="clear"></div>
		<label>Native Sub Centre</label> <select
			name="<%=NATIVE_SUB_CENTRE %>" tabindex="61" validate="Native Sub Centre,int,no" id="nativeSubCentre">
			<option value="">Select</option>

			<%
			for(Object[] subCenter:subCenterList){%>
			<option value="<%=subCenter[0]%>"><%=subCenter[1]%></option>
			<% }
			
			%>
		</select>
		<label>New Born Baby <input style="margin-top: 3px;"
			type="checkbox" name="newBornBaby" id="newBornBabyId" tabindex="62"
			onclick="getMotherUHID()" maxlength="25" disabled="disabled" class="radioCheckCol2" /></label>

		<div id="motherUHID" style="display: none;">
			<label>Mother UHID</label> <input type="text" id="motherUHIDId"
				name="motherUHID" tabindex="63" validate="Mother UHID,string,no"
				class="textbox_size20" maxlength="50" />

		</div>

		<div class="clear"></div>

		<div id="searchbar">
			<div id="edited"></div>
			<input type="button" name="Submit11" value="Save" tabindex="1"
				class="button"
				onClick="if(checkIdRadioButton())if(checkOpSession())if(checkAadharField())if(checkForPediatricDepartment())if(checkForAntenatalDepartment()){if(aadharVerifyStatus()){submitForm('registration','/hms/hms/registration?method=submitPatientInformation')}}" />

			<input type="reset" name="Reset" value="Reset"
				class="buttonHighlight" tabindex="" onclick="setFocus()" />
			<h4 id="statusMessage"></h4>
			<div class="clear"></div>
			<div class="bottom">
				<label>Changed By</label> <label class="value"><%=userName%></label>
				<label>Changed Date</label> <label class="value"><%=currentDate%></label>
				<label>Changed Time</label> <label class="value"><%=time%></label> <input
					type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
					type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
				<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
			</div>

		</div>
	</div>

	<script type="text/javascript">
function checkOpSession(){
	var serviceCentre=document.getElementsByName('patientDepartment')[0].value;
	var otherServiceCentre=document.getElementsByName('patientDepartment')[1].value; // added by amit das on 16-08-2017
	var opSessionSize=document.getElementById('opsession').options.length;
	 if(serviceCentre!="0" || otherServiceCentre!="0"){
		if(opSessionSize==0){
			alert("Session Not Available !");
			return false;
		}else{
			return true;
		}
	} 
	 return true;
}
function checkForPediatricDepartment(){
	var age = document.getElementById('age').value;
	var obj = age.split(" ");
	var ageValue = obj[0];
	var ageunit = document.getElementById('ageUnitId').value;
	 var selectedArray = new Array();
	 var selectedDept;
	    var deptObj = document.getElementById('deptId'); 
	    var i;
	    var count = 0;
	    for (i=0; i<deptObj.options.length; i++) { 
	        if (deptObj.options[i].selected) {
	            selectedArray[count] = deptObj.options[i].value;
	        	<%for(MasDepartment masDepartment :departmentList){%>
	        		if('<%=masDepartment.getId()%>' == selectedArray[count]){
	        			if(('<%=masDepartment.getDepartmentName()%>'=='PAEDIATRICS')){
	        				if(parseInt(age)>18 && ageunit=='Years'){
	        				alert("More than 18 Years Patient is not allowed in Paediatric Department.");
	        				deptObj.options[i].selected = false;
	        				return false;
	        				}else{
	        					return true;
	        				}
	        			}
	        		
	        		}
	        		<%}%>
	            count++; 
	            
	        } 
	    }
	   return true;
}


function checkForAntenatalDepartment(){
	var empDeptCodeId=document.getElementById("empDeptCodeId").value;
	var genderId=document.getElementById("gender").value;
	if(genderId==3 && (empDeptCodeId=='<%=obsGynecDept%>')){
 	   alert("Male patient could not create visit for this service center");
 	   return false;
    }
	  return true;
}


function ekycFiledCheck(){
	var aadhaarNumberId=document.getElementById('aadhaarNumberId').value;
	if(aadhaarNumberId == ""){
		alert('Enter aadhaar no.')
		return false;
	}
	else{
		return true;
	}
}

function ekycOtpFiledCheck(){
	var aadhaarNumberId=document.getElementById('aadhaarNumberId').value;

	var otp=document.getElementById('otp').value;
	if(otp == ""){
		alert('Enter otp .')
		return false;
	}
	else if(otp == "" && aadhaarNumberId == "" ){
		alert('Enter aadhaar no. and otp .')
		return false;
	}
	else if(aadhaarNumberId == ""){
		alert('Enter aadhaar no.')
		return false;
	}
	else{
		return true;
	}
}

function getMotherUHID(){
	if(document.getElementById('newBornBabyId').checked = true){
		document.getElementById('motherUHID').style.display = 'block';
	}else{
		document.getElementById('motherUHID').style.display = 'none';
	}
}




function checkAadharField(){
	var aadharRadio=document.getElementById('aadhaarRadioId').checked;
	if(aadharRadio){
		var qrsRadio=document.getElementById('QRScanId').checked;
		
		var ekycRadio=document.getElementById('eKycId').checked;
		
		if(qrsRadio){
			var aadharValue=document.getElementById('pQAadhaarNumberId').value;
			
			if(aadharValue =="" ){
				
				alert("Aadhaar Number Field can not blank. ")
				return false;
			}
			else{
				
				return true;
			}
		}
		else if(ekycRadio){
			var aadharValue=document.getElementById('pEAadhaarNumberId').value;
			
			if(aadharValue =="" ){
				
				alert("Aadhaar Number Field can not blank. ")
				return false;
			}
			else{
				
				return true;
			}
		}
		else{
			if(document.getElementById('phAadhaarNumberId').value==""){
			
			alert("Aadhaar Number Field can not blank. ")
			return false;
		}else{
			return true;
		
		}
	}
	}
	else{
		return true;
	}
}
function aadharVerifyStatus(){
	var aadharRadio=document.getElementById('aadhaarRadioId').checked;
	if(aadharRadio){
		var ekycRadio=document.getElementById('eKycId').checked;
		if(ekycRadio){
			var aadhaarVerifyStatus=document.getElementById('aadhaarVerifyStatus').value;
			
			if(aadhaarVerifyStatus =="" ){
				
				alert("Verify  Aadhaar Number for eKyc registration ")
				return false;
			}
			else{
				
				return true;
			}
		}
		else{
			return true;
		}
	}
	else{
		return true;
	}
}

function checkotherCategoryRadioButton(){
	var bpl=document.getElementById('bplId').checked;
	var apl=document.getElementById('aplId').checked;
	var aadharRadio=document.getElementById('aadhaarRadioId').checked;
	var otherIdReg=document.getElementById('otherIdReg').checked;
	if(aadharRadio || otherIdReg){
	if(bpl ||apl ){
				return true;
		}
	else{
		alert("Please Select Family Income Status  . ")
		return false;
	}	
	}
	else{
	return true;
	}
}



function checkIdRadioButton(){
	var aadharRadio=document.getElementById('aadhaarRadioId').checked;
	var otherIdReg=document.getElementById('otherIdReg').checked;
	var nnoId=document.getElementById('nnoId').checked;
	
	 
	if(aadharRadio ||otherIdReg ||nnoId){
				return true;
		}
	else{
		alert("Please Select Id Option . ")
		return false;
	}	
}
            

               function setFocus()
               {
            	     document.getElementById("form1").reset();
                    
               }

               function checkForDiscount()
               {
                       var authorizer=eval(document.registration.refDoctor.value);
                       var amount=parseFloat(document.registration.amt.value);
                       var discountVar=document.registration.discount.value;
                       if(isNaN(discountVar))
                       {
               
                               if(validateFloat(discountVar))
                               {
                                       if(parseFloat(discountVar)>parseFloat(amount))
                                       {
                                               alert("Discount should be less than or equal to amount!!");
                                               document.registration.discount.value="";
                                               return false;
                                       }
                                       else if(parseFloat(discountVar)== parseFloat(amount))
                                       {
                                               document.getElementById('actualColAmtId').value = "";
                                       }
                                       if(discountVar!="" && authorizer==0)
                                       {
                                               alert("Select Authorizer!!");
                                               return false;
                                       }
                                       document.getElementById('actualColAmtId').value = "";
                               }
                               else
                               {
                                       alert("Discount should be integer or decimal value.");
                                       document.registration.discount.value = "";
                                       return false;
                               }
                       }
                       else
                       {
                               if(parseFloat(discountVar)>parseFloat(amount))
                               {
                                       alert("Discount should be less than or equal to amount!!");
                                       document.registration.discount.value="";
                                       return false;
                               }
                       }
                       return true;
               }

               function selectPatientDistrict(val)
               {
                       temp = eval("document.registration.patientDistId");
                       for(i=0;i<districtArray.length;i++)
                       {
                               if(districtArray[i][1]==val)
                               {
                                       id=        districtArray[i][2]
                               }
                       }
                       temp.value=id
               }
               function clearHin()
               {
                       document.getElementById('hinNoDivId').innerHTML = "";
               }
       </script>

	<script type="text/javascript">

function abcc(){
	alert();
}
function aadhaarQr(){
    var aadhaarData= prompt("Pick Your Aadhar Details:","");
    
    if( aadhaarData != null &&  aadhaarData != ""){
    	var dat= aadhaarData;
    data = dat.replace('</?xml version="1.0" encoding="UTF-8"?>','');
    if (window.DOMParser)
     {
     parser=new DOMParser();
     xmlDoc=parser.parseFromString(data,"text/xml");
     }
   else // Internet Explorer
     {
     xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
     xmlDoc.async=false;
     xmlDoc.loadXML(data);
     }
   
    document.getElementById("pQAadhaarNumberId").value=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('uid');
    
    document.getElementById("pNameId").value=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('name').toString();
    document.getElementById("yobId").value=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('yob');  
    
    var today=new Date();
    var age=today.getFullYear()-(xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('yob'));
    document.getElementById("age").value=age;
    var dob;
    var relName="";
    if(xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('co')!=null){
    	relName=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('co').toString(); 
    }
    if(null !=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('dob')){
     dob = xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('dob');
    }
   // alert(dob)
    if(xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('dob') !=null ){
    document.getElementById("dobId").value=dob;
    if(dob !=null && !dob && dob !=""){
    dob1=dob.replace('-','/');
    dob2=dob1.replace('-','/');
   
    document.getElementById("dobId").value=dob2;
    }
    }else{
    	 document.getElementById("dobId").value="01/01/"+xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('yob');
    }
    var relName1=relName.replace('/','');
    var rel=relName1.substring(0,1).trim();
    if(rel=='S'){
    	document.getElementById("relId").value=2;
    }else if(rel=='D'){
    	document.getElementById("relId").value=2;
    }else if(rel=='W'){
    	document.getElementById("relId").value=11;
    }else{
    	document.getElementById("relId").value=0;
    }
   
    var rel1=relName1.substring(3,100).trim();
    document.getElementById("relativeNameId").value=rel1;
   
    var gender=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('gender');
    if(gender=="MALE" || gender=="M" || gender=='m'){
            document.getElementById("gender").value = 3;
          //  document.getElementById("titleId").value = 1;
    }else{
            document.getElementById("gender").value = 2;
           // document.getElementById("titleId").value = 2;
    }
   var addharDistrict=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('dist').toString()
   var cityId = document.getElementById('cityId');
for (var i = 0; i < cityId.options.length; i++) {
    if (cityId.options[i].text === addharDistrict.toUpperCase()) {
    	cityId.selectedIndex = i;
        break;
    }
}
var postOff = document.getElementById('postOff');
var addharPostOffice;
	if(null != xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('po')){
		addharPostOffice=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('po').toString();
		for (var i = 0; i < postOff.options.length; i++) {
			 if (postOff.options[i].text === addharPostOffice.toUpperCase()) {
				 postOff.selectedIndex = i;
			     break;
			 }
			}
	}
		

document.getElementById("pincode").value=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('pc').toString();
     
   document.getElementById("pHouseName").value= xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('house');
  document.getElementById("streetName").value=  xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('street');
    document.getElementById("QRcAadharId").style.display = "block";
	document.getElementById('aadhaar').checked=true;
document.getElementById('aadharrAddDiv').style.display = "block"; 
document.getElementById('aadhaarAddrID').value = "y"; 

  
}
    return null;
}

function aadhaarQrScanForCitizen(){
    var aadhaarData= prompt("Pick Your Aadhar Details:","");
    
    if( aadhaarData != null &&  aadhaarData != ""){
    	var dat= aadhaarData;
    data = dat.replace('</?xml version="1.0" encoding="UTF-8"?>','');
    if (window.DOMParser)
     {
     parser=new DOMParser();
     xmlDoc=parser.parseFromString(data,"text/xml");
     }
   else // Internet Explorer
     {
     xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
     xmlDoc.async=false;
     xmlDoc.loadXML(data);
     }
   
    document.getElementById("saadhaarNumberId").value=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('uid');
   
    populateDataFromCitizenForAadhaar(xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('uid'))
   
}
    return null;
}
</script>


	<script language="Javascript">
	
	function validateDobfalse(){
		
		var element= document.getElementById("dobId");
		
		element.setAttribute("validate","no");
		
var element1= document.getElementById("patientTypeId");
		
		element1.setAttribute("validate","no");
		
		document.getElementById("socId").style.display = 'none';
		   document.getElementById("famId").style.display = 'none';
		   document.getElementById("agId").style.display = 'none';
	}


function fillNokAddrOnState()
{
       var state = "";
       var city = "";
       var obj = document.getElementById("stateId");
       var val = obj.value;

       for(i=0;i<obj.length;i++)
       {
               if(obj.options[i].value == val)
               {
                       state = obj.options[i].text
                       break;
               }
       }
       document.getElementById('nokAddr').value=document.getElementById('addr').value+'\n '+state+','+document.getElementById('pinCodeId').value
       return true;
}

function fillNokAddr()
{
       var state = "";
       var city = "";
       var obj = document.getElementById("stateId");
       var val = obj.value;
       
       for(i=0;i<obj.length;i++)
       {
               if(obj.options[i].value == val)
               {
                       state = obj.options[i].text
                       break;
               }
       }
       var obj = document.getElementById("cityId");
       var val = obj.value;
       if(val !="0")
               for(i=0;i<obj.length;i++)
               {
                       if(obj.options[i].value == val)
                       {
                               city = obj.options[i].text
                               break;
                       }
               }
       document.getElementById('nokAddr').value=document.getElementById('addr').value+'\n'+city+','+state+','+document.getElementById('pinCodeId').value
       return true;
}
function validateIntegerAge( strValue )
{
       var objRegExp  = /(^\d\d*$)/;
       return objRegExp.test(strValue);
}
function checkNameSpaces()
{
       var patientTypeId="";
       patientTypeId=        document.getElementById('patientTypeId').value;
       var newBorn="";
       if(document.getElementById('nbbId').checked==true)
       {
               document.getElementById('nbbId').value="y";
       }
       else
       {
               document.getElementById('nbbId').value="n";
       }
       var errorMsg ="";
       var tempFlag=""
       
       if(document.getElementById('pFirstNameId').value =="" || trimAll(document.getElementById('pFirstNameId').value) =="")
       {
               errorMsg =errorMsg+"First name can not be blank or spaces \n"
               document.getElementById("pFirstNameId").focus();
               tempFlag="true";
       }

       if(document.getElementById('gender').value =="0" )
       {
               errorMsg =errorMsg+"Please Select Gender \n"
               if(tempFlag !="true")
               {
                       document.getElementById("gender").focus();
                       tempFlag="true";
               }
       }
       if(document.getElementById('age').value =="" )
       {
               errorMsg =errorMsg+"Please Select Age \n"
               if(tempFlag !="true")
               {
                       document.getElementById("age").focus();
                       tempFlag="true";
               }
       }
       if(document.getElementById('age').value != "")
       {
                if(!validateIntegerAge(document.getElementById('age').value))
                {
                       errorMsg =errorMsg+"Age should be integer value\n"
                       if(tempFlag !="true")
                       {
                               document.getElementById("age").focus();
                               tempFlag="true";
                       }
               }

                if(parseInt(document.getElementById('age').value)>=21 && document.getElementById('employeeDependentDiv').style.display=="inline" && document.getElementById('depndtRelation').value != 'Wife' &&  document.getElementById('depndtRelation').value != 'Husband' )
                {
                       alert("Dependent's age is greater than 21 years.So patient can not be registered. Please contact to HR ro change patient type to General.\n");
                       return false;
               }
       }

       if(document.getElementById('religionId').value =="0" )
       {
               errorMsg =errorMsg+"Please Select Religion \n"
               if(tempFlag !="true")
               {
                       document.getElementById("religionId").focus();
                       tempFlag="true";
               }
       }

       if(document.getElementById('countryId').value =="0" )
       {
               errorMsg =errorMsg+"Please Select Country \n"
               if(tempFlag !="true")
               {
                       document.getElementById("countryId").focus();
                       tempFlag="true";
               }
       }

       if(document.getElementById('stateId').value =="0" )
       {
               errorMsg =errorMsg+"Please Select State \n"
               if(tempFlag !="true")
               {
                       document.getElementById("stateId").focus();
                       tempFlag="true";
               }
       }

       var blockStatus1="Y";
       var postOfficeStatus1="Y";
       
       if(document.getElementById('nokNameId').value =="" )
       {
               errorMsg =errorMsg+"Please fill Relative Name \n"
               if(tempFlag !="true")
               {
                       document.getElementById("nokNameId").focus();
                       tempFlag="true";
               }
       }

       if(patientTypeId!=14 && document.getElementById('nbbId').checked==false &&    document.getElementById('deptId').value =="0" )
       {
               errorMsg =errorMsg+"Please select Department \n"
               if(tempFlag !="true")
               {
                       document.getElementById("deptId").focus();
                       tempFlag="true";
               }
       }

       if(patientTypeId!=14 &&  document.getElementById('nbbId').checked==false &&  document.getElementById('consultingDocId').value =="0" )
       {
               errorMsg =errorMsg+"Please select consulting Doctor \n"
               if(tempFlag !="true")
               {
                       document.getElementById("consultingDocId").focus();
                       tempFlag="true";
               }
       }
       
       if(document.getElementById('relId').value =="0" )
       {
               errorMsg =errorMsg+"Please select Relation  \n"
               if(tempFlag !="true")
               {        
                       document.getElementById("relId").focus();
                       tempFlag="true";
               }
       }
       
       if(document.getElementById('registrationType').value =="" )
       {
               errorMsg =errorMsg+"Please select Registration Type \n"
               if(tempFlag !="true")
               {
                       document.getElementById("registrationType").focus();
                       tempFlag="true";
               }
       }

       var authorizer=eval(document.registration.refDoctor.value);
       var discountVar=document.registration.discount.value;
       if(discountVar!="" && authorizer==0)
       {
               errorMsg =errorMsg+"Select Authorizer..!\n"
       }
       else if(discountVar!="" && authorizer!=0)
       {
               checkForDiscount();
       }
       
       if(errorMsg =="")
       {
               return true;
       }
       else
       {
               alert(errorMsg);        
               return false;
       }
}

function displayCompanyList()
{

               var company = document.registration.<%=PATIENT_TYPE_ID %>.value;
               if(company == "1")
               {
                       document.getElementById('company').style.display = "inline";
                       document.getElementById('companyLable').style.display = "inline";
                       document.getElementById('comId').focus();
                       document.getElementById('employeeDependentDiv').style.display = "none";
                       document.getElementById('employeeDependentlbl').style.display = "none";
               }
               else if (company != "1")
               {
                       document.getElementById('company').style.display = "none";
                       document.getElementById('companyLable').style.display = "none";
                       document.getElementById('employeeDependentDiv').style.display = "none";
                       document.getElementById('employeeDependentlbl').style.display = "none";
                       document.getElementById('comId').style.backgroundColor = "";
               }

               if(company == "7")
               {
                       document.getElementById('insurance').style.display = "inline";
                       document.getElementById('insuranceLable').style.display = "inline";
                       document.getElementById('insAmtlbl').style.display = "inline";
                       document.getElementById('insAmt').style.display = "inline";
                       document.getElementById('insId').focus();
                       //document.getElementById('insId').style.backgroundColor = "yellow";
                       document.getElementById('employeeDependentDiv').style.display = "none";
                       document.getElementById('employeeDependentlbl').style.display = "none";
               }
               else if (company != "7")
               {
                       document.getElementById('insurance').style.display = "none";
                       document.getElementById('insuranceLable').style.display = "none";
                       document.getElementById('insAmtlbl').style.display = "none";
                       document.getElementById('insAmt').style.display = "none";
                       document.getElementById('employeeDependentDiv').style.display = "none";
                       document.getElementById('employeeDependentlbl').style.display = "none";
                       document.getElementById('insId').style.backgroundColor = "";
               }

               if(company == "4")
               {
                       document.getElementById('prjDiv').style.display = "inline";
                       document.getElementById('prjlbl').style.display = "inline";
                       document.getElementById('prjId').focus();
               }
               else if (company != "4")
               {
                       document.getElementById('prjDiv').style.display = "none";
                       document.getElementById('prjlbl').style.display = "none";
                       document.getElementById('prjId').style.backgroundColor = "";
               }

               if(company == "8" || company == "2")
               {
                       document.getElementById('employeeDiv').style.display = "inline";
                       document.getElementById('employeelbl').style.display = "inline";
                       document.getElementById('employeeId').focus();
               }
               else if (company != "8")
               {
                       document.getElementById('employeeDiv').style.display = "none";
                       document.getElementById('employeelbl').style.display = "none";
                       document.getElementById('employeeId').style.backgroundColor = "";
               }

               document.getElementById('employeeDependentId').value = "0";
               document.getElementById('employeeId').value = "0";
               document.getElementById('prjId').value = "0";
               document.getElementById('insId').value = "0";
               document.getElementById('comId').value = "0";
}
/*
* This function is used for remove readonly after select staf dependent
Code By Mukesh Narayan SIngh
Date 16 Aug 2010
*/
function getActivateReadOnlyFieldOnReg(){
       var objTitle=  document.getElementById("titleId");
   document.getElementById("titleId").value= "select";
   objTitle.disabled=false;


       document.getElementById("pFirstNameId").value=  "";
   document.getElementById("pFirstNameId").disabled=false;
   document.getElementById("pFirstNameIdTemp").value=  "";

   document.getElementById("pMiddleNameId").value= "";
   document.getElementById("pMiddleNameId").disabled=false;
   document.getElementById("pMiddleNameIdTemp").value=  "";

   document.getElementById("pLastNameId").value="";
          document.getElementById("pLastNameId").disabled=false;
         document.getElementById("pLastNameIdTemp").value="";

    var obj1=document.getElementById("gender");
    document.getElementById("gender").value= "select";
    document.getElementById("genderTemp").value= "0";
    obj1.disabled=false;


    try{
                 document.getElementById("dobId").value="";
                 document.getElementById("dobId").disabled=false;
                 document.getElementById("dobIdTemp").value= "";
                  }
                  catch(e){
                 document.getElementById("dobId").value="";
                 document.getElementById("dobIdTemp").value="";
                 }


    try{
                 document.getElementById("age").value="";
                 document.getElementById("age").disabled=false;
                 document.getElementById("ageTemp").value= "";
                  document.getElementById("ageUnitIdTemp").value ="";
                document.getElementById("ageUnitId").disabled = false;
         }
         catch(e){
                 document.getElementById("age").value="";
                 document.getElementById("age").disabled=false;
                 document.getElementById("ageTemp").value="";
                 document.getElementById("ageUnitIdTemp").value = "";
               document.getElementById("ageUnitId").disabled=false;
         }
               document.getElementById("religionId").disabled=false;
               document.getElementById("religionId").value= "";
                 document.getElementById("religionIdTemp").value= "";

                 document.getElementById("casteId").disabled=false;
                 document.getElementById("casteId").value="";
               document.getElementById("casteIdTemp").value= "";


               document.getElementById("nokNameId").value="";
           document.getElementById("relativeNameTemp").value="";
           document.getElementById("nokNameId").disabled=false;


}
function employeeDepntList()
{
       var company = document.registration.<%=PATIENT_TYPE_ID %>.value;
       
       if(company == "2"){
       document.getElementById('employeeDependentDiv').style.display = "inline";
       document.getElementById('employeeDependentlbl').style.display = "inline";
       populateDepandentList();


       }else if (company != "2"){
       document.getElementById('employeeDependentDiv').style.display = "none";
       document.getElementById('employeeDependentlbl').style.display = "none";
       }
       if(company=="8")
       {
                               obj=document.getElementById("employeeId");
                               document.getElementById("pFirstNameId").value=obj.options[obj.selectedIndex].text;
       }
       document.registration.<%=EMPLOYEE_DEPENDENT_ID%>.focus();
}

function setEmployeeName()
{
       var company = document.registration.<%=PATIENT_TYPE_ID %>.value;

       if(company=="2")
       {
                               obj=document.getElementById("employeeDependentId");
                               document.getElementById("pFirstNameId").value=obj.options[obj.selectedIndex].text;
       }

}

function changeSex()
{
var obj = document.getElementById('titleId');
var txt = obj.options[obj.selectedIndex].text;

if (txt=="Mr." || txt=="Master" || txt=="Male Child")
{
       var obj1 = document.getElementById("gender");
       for(i=0;i<obj1.length;i++)
       {
                var txt1 = obj1.options[i].text;
                if (txt1=="Male")
                  obj1.selectedIndex = i;
       }
}
else if (txt=="Mrs" || txt=="Miss" || txt=="Ms." || txt=="Female Child")
{
       var obj1 = document.getElementById("gender");
       for(i=0;i<obj1.length;i++)
       {
                var txt1 = obj1.options[i].text;
                if (txt1=="Female")
                  obj1.selectedIndex = i;
       }
}
else
{
       var obj1 = document.getElementById("gender");
       for(i=0;i<obj1.length;i++)
       {
                var txt1 = obj1.options[i].text;
                if (txt1=="Not applicable")
                  obj1.selectedIndex = i;
       }
}
}

function checkForPatientType()
{
       submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getAmount','amount');
}

function leapYear(year)
{
  return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
}


</script>
</form>
<form name="tempReg">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
</form>
<script type="text/javascript">


var formObj = document.getElementById('form1');
var inputArr = formObj.getElementsByTagName("input");
for (i=0; i<inputArr.length; i++){

if(/text/.test(inputArr[i].type)){

inputArr[i].onfocus = function(){
};

inputArr[i].onblur = function(){
this.style.backgroundColor = "";
};

}

}

var formObj = document.getElementById('form1');
var inputArr = formObj.getElementsByTagName("textarea");
for (i=0; i<inputArr.length; i++){

if(/text/.test(inputArr[i].type)){

inputArr[i].onfocus = function(){
};

inputArr[i].onblur = function(){
this.style.backgroundColor = "";
};

}

}

var formObj = document.getElementById('form1');
var inputArr = formObj.getElementsByTagName("Select");
for (i=0; i<inputArr.length; i++){



inputArr[i].onfocus = function(){
};

inputArr[i].onblur = function(){
this.style.backgroundColor = "";
};
if(inputArr[i].name=='<%=PATIENT_TYPE_ID%>'){
inputArr[i].onblur=function(){

displayCompanyList();
this.style.backgroundColor = "";
}

}
if(inputArr[i].name=='<%=EMPLOYEE_DEPENDENT_ID%>'){
inputArr[i].onblur=function(){

getDepandentDetails();
this.style.backgroundColor = "";
}

}

if(inputArr[i].name=='<%=GENDER%>'){
inputArr[i].onblur=function(){

changeGender() ;
this.style.backgroundColor = "";
}

}
if(inputArr[i].name=='ageUnit'){

inputArr[i].onblur=function(){
checkForDOB();
this.style.backgroundColor = "";
}

}
if(inputArr[i].name=='registrationType'){

inputArr[i].onblur=function(){
this.style.backgroundColor = "";
}

}
if(inputArr[i].name=='regisType'){

inputArr[i].onchange=function(){
submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getAmount','amount');
}

}
if(inputArr[i].name=='<%=EMPLOYEE_ID%>'){
inputArr[i].onblur=function(){

employeeDepntList();
ajaxForEmployeeDetails();
this.style.backgroundColor = "";
}

}

}
var inputArr1 = formObj.getElementsByTagName("input");
for(i=0; i<inputArr1.length; i++){
inputArr1[i].onfocus = function(){
};

inputArr1[i].onblur = function(){
this.style.backgroundColor = "";
};
if(inputArr1[i].name=='<%=MOBILE %>'){
inputArr1[i].onblur=function(){

copyMobileNo(document.getElementById("mobileNo").value);
this.style.backgroundColor = "";
}

}
if(inputArr1[i].name=='discount'){
inputArr1[i].onblur=function(){

checkForDiscount();
this.style.backgroundColor = "";
}

}
if(inputArr1[i].name=='age'){
inputArr1[i].onblur=function(){
checkForDOB();
this.style.backgroundColor = "";
}

}

if(inputArr1[i].name=='<%=P_LAST_NAME%>'){
inputArr1[i].onblur=function(){
openPopupForPatientDetail(this.value);
this.style.backgroundColor = "";
}

}

}
function hideCalendar(patientType){

if(patientType == 2 || patientType == 8){ // For Staff & staff dependent case
       document.getElementById('dobcalId').style.visibility = 'hidden';
       }else{
       document.getElementById('dobcalId').style.visibility = 'visible';
       }

}

</script>
<script>
 function checkSearchFiled(){
	 var aadharNumber=document.getElementById('saadhaarNumberId').value;
var name=document.getElementById('spNameId').value;
var mobile=document.getElementById('smobileNo').value;
var dob=document.getElementById('sbirthDayId').value;
var ward=document.getElementById('swardId').value;
var lsgName=document.getElementById('slsgNameId').value;
var lsgType=document.getElementById('slsgTypeId').value;

if(aadharNumber !='' || name !='' || mobile != '' || dob != '' || ward != '' || lsgName>0 || lsgType>0){

return true;
}
else{
	alert("Please Enter At Least One More Parameter ");
return false;
}
 }
</script>
<script>
function checkDepartment(){
var gender;
var department;
gender = document.registration.<%=GENDER%>.value;
department = document.registration.<%=PATIENT_DEPARTMENT%>.value;
if (gender == "3" && department == "49")
{
alert('This is a male patient.OBG Department cannot register him');
document.registration.<%=PATIENT_DEPARTMENT%>.value = "0";
return false;
}else
return true;

}


function checkCollectedAmount(){

var actualColAmt = document.getElementById('actualColAmtId').value;
var amt = document.getElementById('amt').value;
var discount = document.getElementById('discount').value;

var w = document.getElementById('patientTypeId').selectedIndex;
var patientType = document.getElementById('patientTypeId').options[w].text;


var remainingAmt = 0;
if(discount != ""){
remainingAmt = parseFloat(amt)-parseFloat(discount);
}else{
remainingAmt = parseFloat(amt);
}
if(parseFloat(remainingAmt) > 0 && patientType !="Company" && patientType != "Project" && patientType != "Staff" && patientType != "Staff Dependent" ){
       if(actualColAmt == "" || parseFloat(actualColAmt) == 0){
               alert("Please enter actual collected amt.");
               return false;

       }
}
return true;
}


</script>

<script type="text/javascript">

function aadhaarAddressToPermanent(){
	
	var Adistict=document.getElementById("cityId").selectedIndex;
	var SubcityId=document.getElementById("SubcityId").value;
	
	var pin=document.getElementById("pincode").value;
	var poffice=document.getElementById("postOff").value;
	
	
	var houseName=document.getElementById("pHouseName").value;
	if(Adistict>0 ){
		
		obj=document.getElementById('pppostOff');
		var selectedText = document.getElementById("postOff").options[postOff.selectedIndex].text;
		obj.length=0;
		obj.length++;
		obj.options[obj.length-1].value=poffice;
		obj.options[obj.length-1].text=selectedText;
		
		
	 document.getElementById("pcityId").selectedIndex = Adistict;
	 document.getElementById("talukId").value = SubcityId;
	 document.getElementById("ppincode").value = pin;
	
	
	 document.getElementById("PhouseId").value = houseName;
	 
	 alert("Copied Successful ");
	
	}
	else{
		alert("Enter Aadhaar Address First");
		
		}
}


function openPopupForPatientDetail(lastName){
if(lastName.length>2){
       var pFirstNameId=document.getElementById("pFirstNameId").value;
       var pMiddleNameId=document.getElementById("pMiddleNameId").value;
       //document.getElementById('<%=P_FIRST_NAME%>').value=pFirstNameId;
       //document.getElementById('<%=P_MIDDLE_NAME%>').value=pMiddleNameId;
       //document.getElementById(<%=P_LAST_NAME%>).value=lastName;
       document.getElementById('flagPop').value="1";

       // P_MIDDLE_NAME P_LAST_NAME
       var url="/hms/hms/registration?method=getPatientDetailForAutoComplete&flagPop=1&pFirstNameId="+pFirstNameId+"&pMiddleNameId="+pMiddleNameId+"&pLastNameId="+lastName;
       newwindow=window.open(url,'name','height=300,width=1000,status=1,scrollbars=yes');
}
}
function checkNameLength(value){

       if(value!=""){
               var len=value.length;
               //alert("len--"+len);
               if(parseInt(len)<3){
                       alert("Please Enter min three charecter last name");
                       return false;
               }else{
                       openPopupForPatientDetail(value);
               }
       }else{
               return false;
               }
}

function checkStudent(){
var patientTypeId=document.registration.<%=PATIENT_TYPE_ID %>.value;
if(patientTypeId==9){
       document.getElementById('studentCheckId').style.display = "none";
}else{
       document.getElementById('studentCheckId').style.display = "inline";
}
       submitProtoAjaxWithDivName('registration','opd?method=getstudentDetail','studentDiv');
                                       }

function checkNewBorn(){
       if(document.getElementById('nbbId').checked==true){
               document.getElementById('visitBlockId').style.display = "none";
               }else if(document.getElementById('nbbId').checked==false){
                       document.getElementById('visitBlockId').style.display = "block";
                               }
       
}
function checkMLC(val){
       if(val==14){
               document.getElementById('visitBlockId').style.display = "none";
               document.getElementById('deptId').value="20";
               }else if(val!=14 ){
                       document.getElementById('visitBlockId').style.display = "block";
                       document.getElementById('deptId').value="0";
                               }
       

}

function loadContact()
{
       document.getElementById("loadcIndicator").style.display="";
       var a=submitProtoAjaxWithDivName("tempReg","registration?method=populateRegistrationContact","loadCBlock");
}
function loadVisit()
{
       document.getElementById("loadvIndicator").style.display="";
       submitProtoAjaxWithDivName("tempReg","registration?method=populateRegistrationVisit","loadVBlock");
}
function loadBill()
{
       document.getElementById("loadbIndicator").style.display="";
       submitProtoAjaxWithDivName("tempReg","registration?method=populateRegistrationBill","loadBBlock");
}

function loadRegCount()
{
       try
       {
           xmlHttp=new XMLHttpRequest();
       }
       catch (e)
       {
               try
               {
                   xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
           }
               catch (e)
               {
                   alert(e)
                     try
                   {
                       xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                     }
                   catch (e)
                   {
                       alert("Your browser does not support AJAX!");
                       return false;
                     }
               }
       }
   xmlHttp.onreadystatechange=function()
   {
            if(xmlHttp.readyState==4)
            {
              document.getElementById("regCount").innerHTML=xmlHttp.responseText;
             }
   }

         var url="/hms/hms/registration?method=populateRegistrationCount";
 	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
         document.getElementById("regCount").innerHTML = 'Loading...';
       xmlHttp.open("GET",url,true);
       xmlHttp.send(null);
}

</script>

<script>
function openOtpWindos(){
	 document.getElementById("VerifyID").value="Verified";
	  document.getElementById("VerifyID").disabled = true;
	 }

function openOPT() {
	var mobNo=document.getElementById('mobileNoId').value;
	
	if(mobNo !=""){
	var height=400;
	var width=900;
	var left = (screen.width/2)-(width/2);
	var top = (screen.height/2)-(height/2);
	window.open( "/hms/hms/registration?method=submitMobileNumberForOTP&mobNo="+mobNo+"&"+csrfTokenName+"="+csrfTokenValue,"_blank","width=200, height=100");
	}
	else{
		alert("Enter Mobile Number");
	}
}


function searchKeyPress(e)
{
    // look for window.event in case event isn't passed in
    e = e || window.event;
    if (e.keyCode == 13)
    {
        document.getElementById('citizensearchId').click();
        return false;
    }
    return true;
}
function monthlySalary(value){
	
	var decimalOnly = /^\s*-?[1-9]\d*(\.\d{1,2})?\s*$/;
	
	  if(value!==''){
	   if(decimalOnly.test(value)){
	   return true;
	   }else{
	    alert('Data input is invalid!');
	    document.getElementById('monIncome').value="";
	    return false;
	   }
	  }
	 
}
function validate(evt) {
	  var theEvent = evt || window.event;
	  var key = theEvent.keyCode || theEvent.which;
	  key = String.fromCharCode( key );
	  var regex = /[0-9]|\./;
	  if( !regex.test(key) ) {
	    theEvent.returnValue = false;
	    if(theEvent.preventDefault) theEvent.preventDefault();
	  }
	}
function getNameAndMobile(mobNo){
	var name=document.getElementById('pNameId').value; 
 submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getNameAndMobile&mobNo='+mobNo+'&name='+name,'patientDtDiv');
}

function paginationForRegistedPatient(page,name,mobNo){
	//submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getNameAndMobile&mobNo='+mobNo+'&name='+name,'patientDtDiv');
	submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getNameAndMobile&page='+page+'&nameForMobNoSearch='+name+'&mobNoForSearch='+mobNo,'patientDtDiv');
}

function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}
function displayBplTextBox(value){
	
	if(value.localeCompare('bpl')==0){
		document.getElementById('bplTextDiv').style.display="block";
	}
	else if(value.localeCompare('apl')==0){
		document.getElementById('bplTextDiv').style.display="none";
		document.getElementById('bplTextbox').value="";
		
	}
}
	
	function searchParticularPage(){
		
		
		var curPage=document.getElementById("inPage").value;
		var nameS=document.getElementById("spNameId").value;
		var mobNoS=document.getElementById("smobileNo").value;
		//paginationForRegistedPatient(curPage,nameS,mobNoS);	
		if(! curPage || isNaN(curPage)){
			curPage=1;
		}
		
		submitForm('patientRegistersearch','/hms/hms/registration?method=searchPatientFromCitizen&page='+curPage+'&fn='+nameS+'&mobilNo='+mobNoS);
		
	}

</script>
<script type="text/javascript"> 

function showRadioDivs (it, hide1, hide2,hide3,hide4,box) { 
	
	var permanentAddressRadio = document.getElementById('permanent');
	
	if(it=='otherIDDiv'){
		document.getElementById('eKycId').checked = false;
		document.getElementById('QRScanId').checked = false;
		document.getElementById('aadhaar').checked = false;
		document.getElementById('aadhaar').disabled = 'disabled';
		permanentAddressRadio.checked = true;
		showAddressDivs('permanentAddDiv', 'temporaryAddDiv', 'aadharrAddDiv', permanentAddressRadio,'permanent');
	}else if(it=='noIDDiv'){
		document.getElementById('eKycId').checked = false;
		document.getElementById('QRScanId').checked = false;
		document.getElementById('aadhaar').checked = false;
		document.getElementById('aadhaar').disabled = 'disabled';
		permanentAddressRadio.checked = true;
		showAddressDivs('permanentAddDiv', 'temporaryAddDiv', 'aadharrAddDiv', permanentAddressRadio,'permanent');
	}else{
		  var aadharAddressRadio =	document.getElementById('aadhaar');
    	  aadharAddressRadio.checked = true;
    	  aadharAddressRadio.removeAttribute('disabled');
  		  showAddressDivs('aadharrAddDiv', 'permanentAddDiv', 'temporaryAddDiv', aadharAddressRadio,'aadhaar');
	}
document.getElementById(it).style.display = "block"; 
document.getElementById(hide1).style.display = "none"; 
document.getElementById(hide2).style.display = "none"; 
document.getElementById(hide3).style.display = "none";
document.getElementById(hide4).style.display = "none";
} 

function showAddressDivs(it, hide1, hide2,box,flag) { 
	
	var as=document.getElementById('aadhaarRadioId').checked;
	
	if(it=='aadharrAddDiv' && as){
		
	document.getElementById('aadharrAddDiv').style.display = "block"; 
	document.getElementById(hide1).style.display = "none"; 
	document.getElementById(hide2).style.display = "none"; 
	}
	
	if(it=='permanentAddDiv' ){
		document.getElementById('permanentAddDiv').style.display = "block"; 
		document.getElementById('permanentAddDiv').style.display = "block"; 
		document.getElementById(hide1).style.display = "none"; 
		document.getElementById(hide2).style.display = "none";
	}
	if(it=='temporaryAddDiv'){
		document.getElementById('temporaryAddDiv').style.display = "block"; 
		document.getElementById(hide1).style.display = "none"; 
		document.getElementById(hide2).style.display = "none";
	}

	if(flag=='aadhaar'){
		document.getElementById('aadhaarAddrID').value='y';
		document.getElementById('permAddr').value='n';
		document.getElementById('pTempAddr').value='n';
	}
	if(flag=='permanent'){
		document.getElementById('permAddr').value='y';
		document.getElementById('aadhaarAddrID').value='n';
		document.getElementById('pTempAddr').value='n';
	}
	if(flag=='temporary'){
		document.getElementById('pTempAddr').value='y';
		document.getElementById('aadhaarAddrID').value='n';
		document.getElementById('permAddr').value='n';
	}
} 
function showQReKYCDivs (it, hide1,box) { 
	document.getElementById(it).style.display = "block"; 
	document.getElementById(hide1).style.display = "none"; 
}
function showOtherDetailsDivs (it, hide1, hide2,hide3,hide4,hide5,box,flag) { 
	
	document.getElementById(it).style.display = "block"; 
	document.getElementById(hide1).style.display = "none"; 
	document.getElementById(hide2).style.display = "none"; 
	document.getElementById(hide3).style.display = "none";
	document.getElementById(hide4).style.display = "none";
	document.getElementById(hide5).style.display = "none";
	
	if(flag=="native"){
		
		document.getElementById('nativeId').value=flag;
		
		document.getElementById('otherStateId').value="";
		document.getElementById('foreignerId').value="";
	}else if(flag=='otherState'){
		document.getElementById('otherStateId').value=flag;
		document.getElementById('nativeId').value="";
		document.getElementById('foreignerId').value="";
		
		document.getElementById('residentId').checked=false;
		document.getElementById('nrkId').checked = false;
		document.getElementById('nriId').checked = false;
	}else if(flag=='foreigner'){
		document.getElementById('foreignerId').value=flag;
		document.getElementById('otherStateId').value="";
		document.getElementById('nativeId').value="";
		document.getElementById('otherStateId').value="";
		document.getElementById('nativeId').value="";
		
		document.getElementById('residentId').checked=false;
		document.getElementById('nrkId').checked = false;
		document.getElementById('nriId').checked = false;
	}else{
		alert("!select any of the details")
	}
} 
function checkNativity(){
	var x=document.getElementById('nativeId').value;
	var y=document.getElementById('otherStateId').value;
	var z=document.getElementById('foreignerId').value;
	if(x==''&& y==''&& z==''){
		alert("! Select Type of Nativity")
		document.getElementById('emailId').value="";
		document.getElementById('mobileNoId').value="";
		document.getElementById('nativeSubCentre').value=0;
		document.getElementById('educationId').value=0;
		document.getElementById('occupationId').value=0;
	}
}

function showNativeNrkNriDivs (it, hide1,hide2,box) { 
	document.getElementById(it).style.display = "block"; 
	document.getElementById(hide1).style.display = "none"; 
	document.getElementById(hide2).style.display = "none";
	 
	} 
	

</script>
<script type="text/javascript">
function checkForNok()
{
       var errorMessage="";
       formName="registration";
       obj = eval('document.'+formName);
       if(document.getElementById('nokNameId').value == "")
               errorMessage=errorMessage+"Please Fill NOK name \n";
       if(document.getElementById('relId').value == "0")
               errorMessage=errorMessage+"Please Select Relation \n";
       if(document.getElementById('addr').value == "")
               errorMessage=errorMessage+"Please Fill Address \n";

       if(errorMessage !="")
       {
               alert(errorMessage)
               return false;
       }
       else
       {
               return true
       }
}
function displayImage()
{
       var url = document.getElementById('fileId').value;
       document.getElementById('img1').style.display = 'inline';
       document.getElementById('img1').src=url;
       document.getElementById('photoUrlId').value =url;
}

function setAgeForPatient()
{
       alert("setAgeForPatient");
}
function copyMobileNo(mobileNo)
{
       document.getElementById('nokMobileNo').value=mobileNo
}

function ValidateMobNumber(mobileNoId) {
	 
	 var fld = document.getElementById(mobileNoId);

	  if (fld.value == "") {
	  alert("You didn't enter a phone number.");
	  fld.value = "";
	  fld.focus();
	  return false;
	 }
	  else if (isNaN(fld.value)) {
	  alert("The phone number contains illegal characters.");
	  fld.value = "";
	  fld.focus();
	  return false;
	 }
	 else if (!(fld.value.length == 10)) {
	  alert("The phone number is the wrong length. \nPlease enter 10 digit mobile no.");
	  fld.value = "";
	  fld.focus();
	  return false;
	 }

	}




</script>

<script>
/*        Ranjesh Prasad   */
function aad(){
        loadContact();
        setTimeout(function(){aadhaar();},500);
}

function mandatoryOtherServiceCenter() {
	
	var element= document.getElementById("otherdeptId");
	
	element.setAttribute("validate","no");
	
	document.getElementById("otherClinicService").style.display = 'none';
	
	var element= document.getElementById("deptId");
	
	element.setAttribute("validate","yes");
	
	document.getElementById("opClinicService").style.display = 'block';	
	
}
 
 
function displayBloodGroupName(val) {
	 if(val !=''){
	<%if(bloodGroupList.size()>0){
	 for(MasBloodGroup masBloodGroup : bloodGroupList){
	%>	 
	if(val=='<%=masBloodGroup.getId()%>'){
		<%String bloodGroupName= masBloodGroup.getBloodGroupName();%>
		 document.getElementById("bloodGroupName").value = '<%=bloodGroupName%>'
	}
	<%}}%>	 
	 }
	
}

function searchParticularCitizen(){
	
	var curPage=document.getElementById("inPage").value;
	
	var fn=document.getElementById("spNameId").value;
	
	var uh=document.getElementById("saadhaarNumberId").value;
	
	var dob=document.getElementById("sbirthDayId").value;
	
	var dist=document.getElementById("sdistrict").value;
	
	 
	var cmob=document.getElementById("smobileNo").value;
	
	if(isNaN(curPage)){
		curPage=1;
	}
	if(fn==''){
		fn='';
	}
	if(uh==''){
		uh='';
	}
	if(dob==''){
		dob='';
	}
	
	if(cmob==''){
		cmob='';
	}
	if(dist==''){
		dist='';
	}
	submitForm('patientRegistersearch','/hms/hms/registration?method=searchPatientFromCitizen&page='+curPage+'&cmob='+cmob+'&uh='+uh+'&fn='+fn+'&dob='+dob+'&dist='+dist);
		
}
function myFunction() {
	
    var x = document.getElementById("aadhaarNumberId");
    x.value = x.value.toUpperCase();
}


</script>


<%
	sexList.clear();
	sexList = null;
	titleList.clear();
	titleList = null;
	districtList.clear();districtList=null;
	religionList.clear();
	religionList = null;
	casteList.clear();
	casteList = null;
	System.gc();
	Runtime.getRuntime().gc();
%>