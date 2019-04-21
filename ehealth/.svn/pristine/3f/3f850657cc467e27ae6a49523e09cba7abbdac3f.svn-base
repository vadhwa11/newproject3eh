<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.MasDistrict" %>
<%@page import="jkt.hms.masters.business.MasVillage" %>
<%@page import="jkt.hms.masters.business.MasPostCode" %>
<%@page import="jkt.hrms.masters.business.MasQualification" %>
<%@page import="jkt.hms.masters.business.MasLsg" %>
<%@page import="jkt.hms.masters.business.MasLsgType" %>
<%@page import="jkt.hms.masters.business.MasOccupation" %>
<%@page import="jkt.hms.masters.business.MasState" %>
<%@page import="jkt.hms.masters.business.MasCountry" %>
<%@page import="jkt.hms.masters.business.MasVisaType" %>
<%@page import="jkt.hms.masters.business.PhMasLocalityType" %>
<%@page import="jkt.hms.masters.business.PhMasLocality" %>
<%@page import="jkt.hms.masters.business.MasHospital" %>
<%@page import="jkt.hms.masters.business.MasLsg" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasWard" %>
<%@page import="jkt.hms.masters.business.MasIdCard" %>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script lang="javascript" src="/hms/jsp/js/updateRegistration.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
$.noConflict();
</script>
	<%
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	List<Object[]> patientTypeList = new ArrayList<Object[]>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	
	
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
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
		List<Object[]> localityList=new ArrayList<Object[]>();
		  List<Object[]> otherCategoryList = new ArrayList<Object[]>();
		  List<Object[]> subCenterList=new ArrayList<Object[]>();
	       List<MasIdCard> idCardList=new ArrayList<MasIdCard>();
	       
		  
	
	Properties properties = new Properties();
    URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
    try
    {
            properties.load(resourcePath.openStream());
    }
    catch (Exception e)
    {
            e.printStackTrace();
    }
    String administrativeSexMaleCode = properties.getProperty("administrativeSexMaleCode");
    String patientTypeIdCode = properties.getProperty("patientTypeIdCode");
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	
		Map<String, Object> map = new HashMap<String, Object>();

		if(request.getAttribute("map") != null)
		{
		        map=(Map<String, Object>)request.getAttribute("map");
		}	
		if(map.get("relationList") != null)
	      {
	    	  relationList = (List<MasRelation>)map.get("relationList");
	      }
		if (map.get("sexList") != null)
	       {
	               sexList = (List<MasAdministrativeSex>) map.get("sexList");
	       }
		
		if (map.get("bloodGroupList") != null) {
               bloodGroupList = (List<MasBloodGroup>) map.get("bloodGroupList");
	       }
		if(map.get("patientTypeList") != null)
	       {
	               patientTypeList= (List<Object[]>)map.get("patientTypeList");
	       }
		if(map.get("districtList") != null)
	      {
			districtList = (List<MasDistrict>)map.get("districtList");
	      }
		if(map.get("educationList") != null)
	      {
			educationList = (List<MasQualification>)map.get("educationList");
	      }
		if(map.get("occupationList") != null)
	      {
			occupationList = (List<MasOccupation>)map.get("occupationList");
	      }
		  if(map.get("otherCategoryList") != null)
	       {
	    	   otherCategoryList= (List<Object[]>)map.get("otherCategoryList");
	       }
	       
		
		if(map.get("lsgNameList") != null)
	      {
			lsgNameList = (List<MasLsg>)map.get("lsgNameList");
	      }
		if(map.get("lsgTypeList") != null)
	      {
			lsgTypeList = (List<MasLsgType>)map.get("lsgTypeList");
	      }
		 
		 if(map.get("subCenterList") != null)
	       {
	    	   subCenterList=(List<Object[]>)map.get("subCenterList");
	       }
		if(map.get("countryList") != null)
	       {
			countryList=(List<MasCountry>)map.get("countryList");
	       }
	       
	       if(map.get("stateList") != null)
	       {
	    	   stateList=(List<MasState>)map.get("stateList");
	       }
	         
	       if(map.get("villageList") != null)
	       {
	    	   villageList=(List<Object[]>)map.get("villageList");
	       }
	       
	       if(map.get("postCodeList") != null)
	       {
	    	   postCodeList=(List<Object[]>)map.get("postCodeList");
	       }
	       
	       if(map.get("localityList") != null)
	       {
	    	   localityList=( List<Object[]>)map.get("localityList");
	       }  
	       
	       if(map.get("visaTypeList") != null)
	       {
	    	   visaTypeList=( List<MasVisaType>)map.get("visaTypeList");
	       }
	      
	       List<Object[]> wardList = new ArrayList<Object[]>();
	       if(map.get("wardList") != null)
	       {
	     	  wardList =(List<Object[]>)map.get("wardList");
	               
	       } 
	         if(map.get("idCardList") != null)
	       {
	     	  idCardList =(List<MasIdCard>)map.get("idCardList");	               
	       }      
			
			String searchUhidNo="";
			String searchFullName="";
			String searchMob="";
			if(map.get("uhinNo") != null)
		       {
				searchUhidNo =(String)map.get("uhinNo");
		               
		       } 
			if(map.get("fullName") != null)
		       {
				searchFullName =(String)map.get("fullName");
		               
		       } 
			if(map.get("mobno") != null)
		       {
				searchMob =(String)map.get("mobno");
		               
		       } 
	        
	%>
	<script type="text/javascript" language="javascript">
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<script>
    function searchKeyPress(e)
    {
    	
        // look for window.event in case event isn't passed in
        e = e || window.event;
        if (e.keyCode == 13)
        {
        	
            document.getElementById('searchValueId').click();
        	
            return false;
        }
        return true;
    }
    </script>
<!-- This form for search the existing patient record -->
<div class="titleBg"><h2>Search</h2></div>
<form name="patientUpdate" method="post"  >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="clear"></div>
<div class="Block">
		<label>UHID</label> <input type="text"  tabindex="1" name="<%=HIN_NO %>" validate="Hin No,metachar,no"
		 maxlength="20" value="<%=searchUhidNo %>" onkeypress="return searchKeyPress(event);" /> 
		<label> Name</label> <input type="text" 
			id="pFirstNameId" onchange="" name="<%=P_FULL_NAME %>" value="<%=searchFullName %>"
			tabindex="1" title=" Name of the Patient"
			validate="Name,metachar,no" MAXLENGTH="50"onkeypress="return searchKeyPress(event);" />
			
		 <label>DOB</label> <input type="text" id="dobId"
                               name="<%=DATE_OF_BIRTH %>" tabindex="1" value="" class="date"
                              onblur="validateExpDate(this,'sbirthDayId')"
					   onkeyup="mask(this.value,this,'2,5','/');" 
					   MAXLENGTH="10"  validate="DOB,date,no" class="date"
                               />

                       <div id="dobcalId">
                               <img id="" src="/hms/jsp/images/cal.gif" width="16" height="16"
                                       border="0"
                                       onclick="setdate('<%=date %>',document.patientUpdate.<%=DATE_OF_BIRTH%>,event)"
                                       validate="Pick a date,date,no" 
                                        tabindex="1" />
                       </div> 

                       <input type="hidden" tabindex="1" name="dobIdTemp" id="dobIdTemp" value="" />
	<div class="clear"></div>
	<label>District</label>
	<select  name="district" id="districtIdd" tabindex="1" validate="district,metachar,no" onchange= "lsgByDistrict('lsgNameId',this.value);" >
	<option value="">select</option>
	<%
	if(null != districtList && !districtList.isEmpty()){
		for(MasDistrict district:districtList){	%>
	
<option value="<%=district.getId()%>"><%=district.getDistrictName() %></option>
<%}
	}%>
	
	</select>
	
	<label>LSG Type</label>
	
	<select name="LsgType" id="locality" tabindex="1" validate="LsgType,metachar,no" disabled="disabled">
	<option value="">Select</option>
			<%
	if(null != lsgTypeList && !lsgTypeList.isEmpty()){
		for(MasLsgType lsgtype:lsgTypeList){
			
	%>
	
<option value="<%=lsgtype.getId()%>"><%=lsgtype.getLsgTypeName() %></option>
<%}
	}%>
		</select>
	
	<label>LSG Name</label>
	
	<select name="lsgName" id="lsgNameId" tabindex="1" validate="lsgName,metachar,no" onchange="populatePPWardByLsg('swardId',this.value);">
	<option value="">Select</option>
				<%
	if(null != lsgNameList && !lsgNameList.isEmpty()){
		for(MasLsg lsg:lsgNameList){
			
	%>
	
<option value="<%=lsg.getId()%>"><%=lsg.getLsgTypeName() %></option>
<%}
	}%>
		</select>
	<div class="clear"></div>				
	<label>Ward</label>
	<!-- <input type="text" tabindex="1" name="" value="" validate="" maxlength="8"  id="" onblur="" />	 -->
	<select name="<%=WARD_NO %>" tabindex="1" id="swardId" validate="wardNo,metachar,no" >
<option value=""> Select</option>
<%
  for(Object[] objectArray:wardList){%>
	<option value="<%=objectArray[0]%>"> <%=objectArray[1] %></option>
<% 
}
%>
</select>
			
	<label>House No.</label><input type="text" tabindex="1" name="rationCardno" readonly="readonly" validate="rationCardno,metachar,no"/>
	
     <label>Mobile No.</label> 
     <input type="text" tabindex="1" validate="Mobile,phone,no" value="<%=searchMob %>" name="mobno" maxlength="10" validate="mobno,metachar,no"/>
     
    <div class="clear"></div>                   		 
	<input type="button" tabindex="1" value="Search" id="searchValueId" name="searchValue"  class="button"
	 onclick="submitForm('patientUpdate','/hms/hms/registration?method=showSearchPatientRecordsForUpdateJsp&'+csrfTokenName+'='+csrfTokenValue)"/>
	 
	<input type="reset" tabindex="1" name="Reset" value="Reset" class="button" onclick="submitProtoAjax('search','registration?method=getPatientName&'+csrfTokenName+'='+csrfTokenValue)"
	accesskey="r" />
	
</div>
<% 	
String age="";
String PrintStatus="N";
String gender="";
String address="";
String paddress="";
Map<String,Object> addressMap=null;
addressMap=(Map<String,Object>)map.get("addressMap");

List<Patient> searchDataList=null;
searchDataList=new ArrayList<Patient>();
/* Map<String, Object> getDataMap = new HashMap<String, Object>(); */
searchDataList=(List<Patient>)map.get("searchDataList");

	if(null !=searchDataList && searchDataList.size()>0){%>

	<table>
	
	<tr>
	<th>UHID</th>
	<th>Name</th>
	<th>Gender</th>
	<th>Age</th>
	<th>Address</th>
	<th>UHID Print Status</th>
	</tr>
		<%for(Patient patient:searchDataList){
			if(null !=patient.getAge())
			age=patient.getAge();
			if(null !=patient.getStatus())
			PrintStatus=patient.getStatus();
			if(null !=patient.getSex())
			gender=patient.getSex().getAdministrativeSexName();
			
			paddress=(String)addressMap.get(String.valueOf(patient.getId()));
			if(paddress !=null){
				address=paddress;
			}
			else{
				address="";
			}
			%>
			
			<tr onclick="searchPatientForUpdate('<%=patient.getHinNo()%>');HighLightTR(this)">	
	<td><%=patient.getHinNo()%></td>
	<td><%=patient.getPFirstName()%></td>
	<td><%=gender%></td>
	<td><%=age%></td>
	<td><%=address %></td>
	<td><%=PrintStatus%></td>
	</tr>
	
<%
}
}
%>	
</table>
 

 </form>

<div class="titleBg">
<!-- <h2>Update Patient Registration</h2> -->
<h2>Update Registration</h2>
</div>
<script type="text/javascript">
function showAddressDivs(it, hide1, hide2,box,flag) { 
	document.getElementById(it).style.display = "block"; 
	document.getElementById(hide1).style.display = "none"; 
	document.getElementById(hide2).style.display = "none"; 

	if(flag=='aadhaar'){
		
		var x=document.getElementById('aadhaarAddr').value='y';
		document.getElementById('permAddr').value='';
		document.getElementById('pTempAddr').value='';
	}
	if(flag=='permanent'){
		document.getElementById('permAddr').value='y';
		document.getElementById('aadhaarAddr').value='';
		document.getElementById('pTempAddr').value='';
	}
	if(flag=='temporary'){
		document.getElementById('pTempAddr').value='y';
		document.getElementById('aadhaarAddr').value='';
		document.getElementById('permAddr').value='';
	}
} 
function showOtherDetailsDivs (it, hide1, hide2,hide3,hide4,hide5,box) { 
	document.getElementById(it).style.display = "block"; 
	document.getElementById(hide1).style.display = "none"; 
	document.getElementById(hide2).style.display = "none"; 
	document.getElementById(hide3).style.display = "none";
	document.getElementById(hide4).style.display = "none";
	document.getElementById(hide5).style.display = "none";
	} 
 
function showNativeNrkNriDivs (it, hide1,hide2,box) { 
	document.getElementById(it).style.display = "block"; 
	document.getElementById(hide1).style.display = "none"; 
	document.getElementById(hide2).style.display = "none";
	 
	} 
</script>
<div class="Block">	
<form name="updateRegistration" id="formupdateId" name="formupdate"method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="clear"></div>

<input type="hidden" tabindex="1" id="patientHinId" name="phinId" value="" validate="phinId,int,no"/>

<div id="imagePatient" align="right" class="patientProfileImg">
<img id="imageID" align="right" src="../jsp/images/default_profile.jpg"  width="100px"
		height="90px"></img>
</div>
<div class="patientProfileLeftdiv">
<div class="clear"></div>
<label>UHID<span>*<span></label>
 <input type="text" id="UHIDId"
					name="UHID" readonly="readonly" value="" tabindex="1"
					validate="UHID,metachar,no" MAXLENGTH="16" />

<label>Aadhaar No.</label>
 <input type="text" id="pQAadhaarNumberId"
					name="<%=Q_P_AADHAAR_NUMBER%>" readonly="readonly" value="" tabindex="1"
					validate="qPAadhaarNumber,metachar,no" MAXLENGTH="12" />
					<div class="clear"></div>
					<label>Name</label>
				<input type="text" id="pQNameId" onchange="checkForPatientType();"
					name="<%=Q_P_FULL_NAME %>" value="" tabindex="1"
					title="Full Name of the Patient" validate="Patient Name,metachar,no"
					MAXLENGTH="50" /> 
					
					<input type="hidden" id="paient_old_nameId" onchange=""
					name="paient_old_name" value="" tabindex="1"
					title="Full Name of the Patient" validate="Patient Name,metachar,no"
					MAXLENGTH="128" /> 
					
					<%-- <label>Gender</label> <input type="text" tabindex="1" 
					value="" readonly="readonly" name="<%=Q_GENDER %>" id="qGenderId"/> --%>
					
					<label>Gender<span>*</span></label> <select
					id="qGenderId" name="<%=Q_GENDER %>" tabindex="1" validate="gender,metachar,yes"
					onChange="changeGender();">
				<option value="">Select</option>	
					<%
               for(MasAdministrativeSex masAdministrativeSex : sexList)
               {%>
				<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
					<%}%>
					</select>
					<div class="clear"></div>
					<label>Name of</label><input type="text" name="<%=Q_RELATION_ID%>"
			id="qRelId" validate=" " class="midium" tabindex="1" />
			
		<input id="qNokNameId" type="text" name="<%=Q_RELATIVE_NAME %>" value="" 
			validate="" maxlength="30" class="date" tabindex="1"  id="qRelativeNameId"/>
			
		<input type="hidden" tabindex="1" class="small" name="relativeNameTemp" id="relativeNameTemp"
			value="" validate="relativeNameTemp,metachar,no"/>
				<div class="clear"></div>
				


				
				<label>Document<span>*</span></label>
				
				<select tabindex="1" id="dobDocumentId" name="dobDocumentId" value="" readonly="readonly" name="document" validate="Document,string,yes"> 
				<option value="">Select</option>
				<% for(MasIdCard idCard : idCardList){%>
		<option value="<%=idCard.getId()%>"><%=idCard.getIdCardName() %></option><%}%>
				</select>
			
 <input type="text" tabindex="1" name="dobDocumentIdNumber" class="date" maxlength="16" value="" id="dobDocumentIdNumber" validate="Document Text,string,yes"/>
				<div class="clear"></div>

</div>
<div class="clear"></div>

<label id="ndobId">DOB</label></label> <input type="text" id="qDobId"
					name="<%=Q_DATE_OF_BIRTH %>" tabindex="1" value="" 
					 validate="DOB,date,no" class="date"
						 onblur="validateExpDate(this,'sbirthDayId')"
					   onkeyup="mask(this.value,this,'2,5','/');"
						   onchange="calculateAgeInAjax()" readonly="readonly"
					   MAXLENGTH="10"  validate="qDateOfBirth,date,no" />
					<!-- <input type="text"  Id="ndobId" class="small"/> -->
				<div id="dobcalId">
					<img  id="calImageId" src="/hms/jsp/images/cal.gif" width="16" height=""
						border="0"
						onclick="setdate('',document.getElementById('qDobId'),event)"
						
						 tabindex="1" />
				</div>
				

				<input type="hidden" tabindex="1" name="dobIdTemp" id="dobIdTemp" value="" /> 
			
					<label>Age</label>
				<div id="ageDiv">
					<input type="text" name="<%=Q_AGE %>" id="qAgeId" name="qAge" class="inputSmall"
						maxlength="3" tabindex="1" validate="qAge,int,no"
						onblur="checkForDOB(),calculateApproxDobFromAge()" /> 
						
						<input type="hidden" name="ageTemp"
						id="ageTemp" value="" />
						
						 <select id="qAgeUnitId"
						name="<%=Q_AGE_UNIT %>"  validate="qAgeUnit,metachar,no" tabindex="1"
						class="small" onchange="checkForDOB()">
						<option  value="Years">Years</option>
						<option value="Months">Months</option>
						<option value="Days">Days</option>
					</select>
					<!-- <label>Notional DOB</label> -->
					
				</div>
				<input type="hidden" name="NationDob" id="nationalDobId"/>	

<div class="clear"></div>

<label>Family Income Status</label>
			
			<label>BPL</label> <input type="radio" tabindex="1" disabled="disabled"
			id="bplStatusId" readonly="readonly" class="checkboxMargin" name="<%=BPL_STATUS %>" value="bpl" />
			
			 <label>APL</label><input tabindex="1" class="checkboxMargin"
				type="radio" name="<%=BPL_STATUS %>" id="aplStatusId" disabled="disabled" value="apl"/>
				
				<input type="hidden" tabindex="1" name="ageUnitIdTemp" id="ageUnitIdTemp"
					value="" />
					<input type="hidden" tabindex="1" id="qYobId" name="<%=Q_YOB %>"/> 
					
			<label>Social Category</label> <select id="patientTypeId" disabled="disabled"
				name="<%=PATIENT_TYPE_ID %>" tabindex="1">
				<option value="">select</option>
				
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
			</select> 
			<div class="clear"></div>
			<label>Other Category</label> <select id="otherCategoryId" tabindex="1" class="multiple" disabled="disabled"
				size="5" name="<%=OTHER_CATEGORY%>">
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
			</select>
							
			<label>Other Id Card</label>
			<input type="text" name="updOtherIdCard" id="updOtherIdCard" value="" readonly="readonly"/>
			<input type="hidden" name="updOtherIdCardId" id="updOtherIdCardId"  value="" readonly="readonly"/>
			<input type="text" name="updOtherIdCardNumber" id="updOtherIdCardNumber" size="16" maxlength="16" value="" readonly="readonly"/>
	
	<div class="clear"></div>
		<label>Monthly Income</label>
			<input type="text" name="monIncome" id="monIncome" value="" maxlength="6" tabindex="1" />
			<input type="text" name="incomeUpdateRemark" id="incomeUpdateRemark" value="" placeholder="Remarks"/>


			<label>Blood Group</label>
		 <select id="bloodGroupId" name="bloodGroupId" tabindex="1" validate="Blood Group,metachar,no" onchange="displayBloodGroupName(this.value)" >
				<option value="">Select</option>	
					<%
               for(MasBloodGroup bloodGroup : bloodGroupList){%>
					<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName() %></option>
					
					<% }%>
				</select>
				
				<input type="hidden" name="bloodGroupName" id="bloodGroupName" value=""/>	

	<div class="clear"></div>
	<div class="titleBg">
	<h2>Address</h2>
	</div>
	<div class="clear"></div>
	<div class="paddingTop5"></div>
		<input type="button" tabindex="1" class="buttonNew" value="Aadhaar"  
		onclick="showAddressDivs('aadharrAddDiv', 'permanentAddDiv', 'temporaryAddDiv', this,'aadhaar')" validate="aadharrAddDiv,metachar,no"/>
		<input type="button" tabindex="1" class="buttonNew" value="Permanent" 
		onclick="showAddressDivs('permanentAddDiv', 'temporaryAddDiv', 'aadharrAddDiv', this,'permanent')" validate="permanentAddDiv,metachar,no"/>
		<input type="button" tabindex="1" class="buttonNew" value="Temporary" 
		onclick="showAddressDivs('temporaryAddDiv', 'aadharrAddDiv', 'permanentAddDiv', this,'temporary')" validate="temporaryAddDiv,metachar,no"/>	
	<a href="javascript:popwindowUploadDocuments();" >Upload Document</a>	
	
	<div class="clear"></div>
	<div class="Block">	
	<div id="aadharrAddDiv" class="" style="display: none;">
		<input type="hidden" tabindex="1" name="ad" value="" id="aadhaarAddr"/>
			<label>House Name</label> 
			<input type="text" id="pHouseName"
				name="<%=HOUSE_NAME %>" value="" readonly="readonly" tabindex="1"
				validate="houseName,string,no" MAXLENGTH="15" /> 
				
				<label>Street Name</label>
				<input type="text" id="streetNameId" readonly="readonly" name="<%=STREET_NAME %>"
				value="" tabindex="1" validate="streetName,string,no" MAXLENGTH="15" />
				
				<label>District</label>
			<select name="<%=A_DISTRICT%>" id="districtId"
				tabindex="1" disabled="disabled"
				onChange="updateTalukByDistrictId(this.value)">
				<option value="">select</option>
				<%
		int districtId=0;
		String stateName="";
		
		for(MasDistrict masDistrict : districtList)
		{
			%>
		
				<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
<%
		}
%>
			</select> 
			<div class="clear"></div>
			
			
			<label>Taluk</label> <select name="<%=A_TALUK%>"
				id="updatetalukId" tabindex="1" disabled="disabled"
				onChange="updateVillageOfTaluk(this.value)">
				
				<option value="">select</option>
			<% 	for(MasTaluk masTaluk:talukList){ %>
			
				<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
			<%}
				%>
			
			</select>
			
			<%-- <label>Village/Town/Corporation</label><select 
				id="villageId" name="<%=VILLAGE %>"  tabindex="1"
				validate="" onchange="updatePostOffice(this.value)" > --%>
				<label>Village/Town/Corporation</label><select 
				id="villageId" name="<%=VILLAGE %>"  tabindex="1"disabled="disabled"
				validate=""  >
				<option value=" ">select</option>
		<% 		
				int villageId=0;
				for(Object[] objectArray : villageList)
		{
			%>
		
				<option value="<%=objectArray[0]%>"><%=objectArray[1] %></option>
<%
		}
%>
		</select>	
			
			
			 <label>Post Office</label> <select
				name="<%=A_POST_OFFICE %>" id="postOffId"
				onchange="updatePinCode(this.value)"
				validate="" tabindex="1" disabled="disabled">
				<option value="">select</option>
				
				<% for (Object[] objectArray:postCodeList ){ %>
					<option value="<%=objectArray[0]%>"><%=objectArray[1] %></option>
				<% 
				}
			%>
			</select>
			<div class="clear"></div>
			<label>Pin Code</label><input type="text" id="pincodeNumberId"
				name="<%=A_PINCODE%>" value="" readonly="readonly" tabindex="1"
				validate="aPinCode,int,no" MAXLENGTH="15" /> 
				
				<label>Copy As </label> <input type="button" class="button" value="Permanent" onclick="" />
		</div>
		
	<div  id="permanentAddDiv" class="" style="display: none;">
		<input type="hidden" name="permAddr" value="" id="permAddr"/>
		<input type="hidden" name="pDistrict" value="" id="pDistrict"/>
			<label>District</label><select name="<%=P_DISTRICT%>" id="cityId"
				tabindex="1" onChange="updatePermanentTalukByDistrictId(this.value)" disabled="disabled">
			<option value="">select</option>	
				
		<%
		
		for(MasDistrict masDistrict : districtList)
		{
			%>
		
				<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
<%
		}
%>
			</select>
			
			 <label>Taluk</label><select name="<%=P_TALUK%>" id="talukId" disabled="disabled"
				tabindex="1" onChange="updatePermanentVillageOfTaluk(this.value)">
				<option value="">select</option>
				<% 	for(MasTaluk masTaluk:talukList){ %>
			
				<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
			<%}
				%>
			</select> 
			
			
			<label>LSG Name</label><select name="<%=P_LSG_NAME %>" id="lsgNameId" disabled="disabled"
				tabindex="1">
				<option value="">select</option>
				<% for(MasLsg masLsg:lsgNameList){ %>
				<option value="<%=masLsg.getId()%>"><%=masLsg.getLsgTypeName() %></option>
					
			<%	}
			
				%>
				
			</select>
			<div class="clear"></div>
			<label>Ward</label><input type="text" name="<%=P_WARD %>" value=""
				validate="pWard,metachar,no" maxlength="8" tabindex="1" id="wardId"
				onblur=""  disabled="disabled"/>
				<input type="hidden" name="pLocality" value="" id="pLocality"/>
				 <label>Locality</label><select name="<%=P_LOCALITY %>" 
				id="localityId" tabindex="1" onchange="updatePermanentPostOffice(this.value)" disabled="disabled">
				<option value="">select</option>
				<% for(Object[] objectArray:localityList ){ %>
				<option value="<%=objectArray[0]%>"><%=objectArray[1] %></option>
					
				<%}
		
				%>
			</select> <label>LSG House No.</label>
			<input type="text"
				name="<%=P_LSG_HOUSE_NO %>" id="lsgHouseNoId"  readonly="readonly" value="" validate="pLsgHouseNo,string,no"
				maxlength="8" tabindex="1"/>
				
			<div class="clear"></div>
			
			<label>Area</label>
			
			<input type="text"
				name="<%=P_HOUSE_NO %>" value="" validate="pHouseNo,string,no" 
				tabindex="1" id="houseId" onblur=""  /> 
				
				<label>Post Office</label>
				<select name="<%=P_POST_OFFICE %>" id="permanentPostOff"
			readonly="readonly"	onchange="updatePermanentPinCode(this.value)" disabled="disabled"
				validate="pPostOffice,metachar,no" tabindex="1">
				<option value="">Select</option>
			</select> 
			
			<label>Pin Code</label><input type="text" id="permanentPincode" readonly="readonly"
				name="<%=P_PINCODE%>" value="" tabindex="1"
				validate="aPinCode,int,no" MAXLENGTH="15" />
			<div class="clear"></div>
			<label>Health House Id</label><input type="text" id="healthHouseId" readonly="readonly"
				name="<%=P_HEALTH_HOUSE_ID%>" value="" tabindex="1"
				validate="pHealthHouseId,string,no" MAXLENGTH="15" />
		</div>	
	<div id="temporaryAddDiv" class="" style="display: none;">
		<input type="hidden" name="pTempAddr" value="" id="pTempAddr"/>
		
			<label>Proof Document<span>*</span></label>
				
				<select tabindex="1" id="tempdocumentId" value="" readonly="readonly" name="tempdocumentId" validate="Proof Document,string,no"> 
				<option value="">Select</option>
				<% for(MasIdCard idCard : idCardList){%>
		<option value="<%=idCard.getId()%>"><%=idCard.getIdCardName() %></option><%}%>
				</select>
			
 <input type="text" tabindex="1" name="tempotherIdCardNumber" maxlength="16" value="" id="tempotherIdCardNumber"/>
 
		<div class="clear"></div>
			<label>District</label>
			<select name="<%=T_DISTRICT%>" id="tcityId"
				tabindex="1"
				onChange="updateTempTalukByDistrictId(this.value); updatePincodeByDistrict(this.value)">
				<option value="">select</option>
				<%
		for(MasDistrict masDistrict : districtList)
		{%>
		<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
<%}%>
	</select> 
			
			<label>Taluk</label><select name="<%=T_TALUK%>" id="ttalukId"
				tabindex="1" onchange="updateTempVillageOfTaluk(this.value)">
				<option value="">select</option>
				<% 	for(MasTaluk masTaluk:talukList){ %>
			
				<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
			<%}
				%>
			</select> <label>LSG Name</label>
			<select name="<%=T_LSG_NAME %>" id="tlsgNameId"
				tabindex="1">
				<option value="">select</option>
				<% for(MasLsg masLsg:lsgNameList){ %>
				<option value="<%=masLsg.getId()%>"><%=masLsg.getLsgTypeName() %></option>
					
			<%	}
			
				%>
			</select>
			<div class="clear"></div>
			<label>Ward</label><input type="text" tabindex="1" name="<%=T_WARD %>" value=""
				validate="tWard,string,no" maxlength="8"  id="twardId"
				onblur="" /> 
				
				<label>Locality</label>
				<select name="<%=T_LOCALITY %>"
				id="templocality" tabindex="1" onchange="updateTempPostOffice(this.value)">
				<option value="">select</option>
				<% for(Object[] objectArray:localityList ){ %>
				<option value="<%=objectArray[0]%>"><%=objectArray[1] %></option>
					
				<%}
		
				%>
			</select> <label>LSG House No.</label><input type="text" tabindex="1"
				name="<%=T_LSG_HOUSE_NO %>" id="tlsghouseId" value="" validate="tLsgHouseNo,string,no"
				maxlength="8" />
			<div class="clear"></div>
			<label>Colony House No.</label><input type="text"
				name="<%=T_HOUSE_NO %>" value="" validate="tHouseNo,string,no"
				maxlength="8" tabindex="" id="houseId" onblur="" /> 
				
				<label>Post Office</label>
				<select name="<%=T_POST_OFFICE %>" id="tempPostOff"
				onchange="updateTempPinCode(this.value);"
				validate="tPostOffice,metachar,no" tabindex="">
				<option value="">Select</option>
				
				
				<% for (Object[] objectArray:postCodeList ){ %>
					<option value="<%=objectArray[0]%>"><%=objectArray[1] %></option>
				<% 
				}
			%>
			</select> 
			<label>Pin Code</label>
			<input type="text" id="tempPincode"
				name="<%=T_PINCODE%>" value="" tabindex="1"
				validate="tPinCode,int,no" MAXLENGTH="6" />
				
			<div class="clear"></div>
			<label>Health House Id</label><input type="text" id="thealthHouseId"
				name="<%=T_HEALTH_HOUSE_ID%>" value="" tabindex="1"
				validate="" MAXLENGTH="15" />
			<!-- <input type="button" tabindex="1" value="ADD More ADDRESSES" class="buttonBig" onclick=""/>	 -->
		</div>	
<!-- </div>
<div class="Block">	 -->
<div class="clear"></div>
	<label>Native</label> <input type="radio" tabindex="1" name="radio3" value="native" class="inputRadiobutton" disabled="disabled"
			onclick="showOtherDetailsDivs('nativeDiv', 'otherIndianStatesDiv', 'foreignerDiv','residentDiv','nrkDiv','nriDiv', this)" />
		<label>From Other Indian States</label> <input type="radio" 
			name="radio3" value="otherState" tabindex="1" class="inputRadiobutton" disabled="disabled"
			onclick="showOtherDetailsDivs('otherIndianStatesDiv', 'foreignerDiv', 'residentDiv','nrkDiv','nriDiv','nativeDiv', this)" />
		<label>Foreigner</label> <input type="radio" name="radio3" value="foreigner" tabindex="1" disabled="disabled"
			onclick="showOtherDetailsDivs('foreignerDiv', 'residentDiv', 'nrkDiv','nriDiv','otherIndianStatesDiv','nativeDiv', this)" />
		<div class="clear"></div>
	
	<div id="nativeDiv" style="display: none;">
			<label>Resident</label> <input type="radio" tabindex="1" name="radio4" value="resident" disabled="disabled"
				onclick="showNativeNrkNriDivs('residentDiv', 'nrkDiv','nriDiv', this)" />
			
			<label>NRK</label> <input type="radio"  tabindex="1" name="radio4" value="nrk" disabled="disabled"
				onclick="showNativeNrkNriDivs('nrkDiv', 'nriDiv','residentDiv', this)" />
			
			<label>NRI</label> <input type="radio" tabindex="1" name="radio4" value="nri" disabled="disabled"
				onclick="showNativeNrkNriDivs('nriDiv', 'residentDiv','nrkDiv', this)" />
	</div>
		<div class="clear"></div>
		<div id="residentDiv" style="display: none;"></div>

		<div id="nrkDiv" style="display: none;">
			<label>State</label> <select id="nrkStateId" name="<%=NRK_STATE%>" disabled="disabled"
				tabindex="1"
				onChange="fillNokAddrOnState();populateDistrict(this.value,'registration')">
				<option value="">select</option>
				<% for(MasState masState:stateList ){ %>
					<option value="<%=masState.getId()%>"><%=masState.getStateName() %></option>
				<%}
				
				%>
			</select>
		</div>
		<div id="nriDiv" style="display: none;">
			<label>Country</label> <select name="<%= NRI_NATIONALITY %>"
				tabindex="1" onChange="(this.value,'registration')" id="nriCountryId" disabled="disabled">
				<option value="">Select</option>
				<% for(MasCountry country:countryList  ){ %>
					<option value="<%=country.getId()%>"><%=country.getCountryName() %></option>
				<%}
				%>
			</select>
		</div>
		<div id="otherIndianStatesDiv" style="display: none;">
		<label>State</label> <select id="migrantStateId" name="<%=MIGRANT_STATE%>"
			 tabindex="1" disabled="disabled"
				onChange="fillNokAddrOnState();populateDistrict(this.value,'registration')">
				<option value="">select</option>
				<% for(MasState masState:stateList ){ %>
					<option value="<%=masState.getId()%>"><%=masState.getStateName() %></option>
				<%}
				
				%>
				
			</select>
		
		<label>District</label><select name="<%=MIGRANT_DISTRICT%>" id="migrantCityId"
				tabindex="1" disabled="disabled"
				onChange="if(fillNokAddr()){populateBlock(this.value,'registration')}">
				<option value="">select</option>
				<%for(MasDistrict masDistrict : districtList){%>
				<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
<%}%>
		     </select>
		
		 <label>Purpose</label><select name="<%=MIGRANT_PURPOSE%>" id="migrantPurposeId"
				tabindex="1" disabled="disabled" onChange="">
				<option value="">Select</option>
				<% for(MasOccupation purpose: occupationList ){ %>
					<option value="<%=purpose.getId() %>"><%=purpose.getOccupationName() %></option>
				<%}
				
				%>
		     </select>    
		</div>
 		<div id="foreignerDiv" style="display: none;">
         <label>Country</label> <select name="<%= FOREIGNER_NATIONALITY %>" disabled="disabled"
				tabindex="1" onChange="(this.value,'registration')" id="foreignerCountryId">
				<option value="">Select</option>
				<% for(MasCountry country:countryList  ){ %>
					<option value="<%=country.getId()%>"><%=country.getCountryName() %></option>
				<%}%>
			</select>
		 
		<label>Pass Port No.</label><input type="text" name="<%=PASSPORTNUMBER %>" validate="passportNumber,metachar,no"
				maxlength="8" id="passPortId"/>
		<label>Purpose</label><select name="<%=FOREIGNER_PURPOSE%>" id="foreignerPurposeId" disabled="disabled"
				tabindex="1"
				onChange="">
				<option value="">Select</option>
				<% for(MasOccupation purpose: occupationList ){ %>
					<option value="<%=purpose.getId() %>"><%=purpose.getOccupationName() %></option>
				<%}
				
				%>
		     </select>	
		<div class="clear"></div>     	
		<label>Visa Type</label><select name="<%=VISA_TYPE %>"
				tabindex="1" onChange="" id="visaTypeId">
				<option value="0">Select</option>
				 <% for(MasVisaType visaType:visaTypeList){ %>
				<option value="<%=visaType.getId()%>"><%=visaType.getVisaTypeName() %></option>
			
				<%}%> 
			</select>
			
<label> Valid From Date<span>*</span></label> 
	<input type="text"	tabindex="1" name="<%=VISA_FROMDATE%>" value="" class="date" id="visaFromDateId"	readonly="readonly" 
		validate="valid From Date,date,no"	MAXLENGTH="30" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	 
		onclick="setdate('',document.updateRegistration.<%=VISA_FROMDATE%>,event)" />
	<label>To Date<span>*</span></label>
		<input type="text"	tabindex="1" name="<%=VISA_TODATE%>" value="" class="date" readonly="readonly" id="visaToDateId"
			validate="To Date,date,no" MAXLENGTH="30" />
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" 
			onclick="setdate('',document.updateRegistration.<%=VISA_TODATE%>,event)" />
 
 </div>			

<div class="clear"></div>
<label>Email Id</label> <input type="text" id="emailId" name="<%=EMAIL_ID %>"
			value="" validate="emailId,string,no" readonly="readonly" MAXLENGTH="40" tabindex="1" id="emailId" />
			
			
<label>Mobile</label> <input type="text" name="<%=MOBILE %>"
			id="mobileNoId" value="" validate="mobile,phone,no"
			MAXLENGTH="10" tabindex="1" onblur="copyMobileNo(this.value);" />
			<input type="button" class="button" id="VerifyID" name="Verify" Value="Verify" onclick="openOPT()"/>
			<div class="clear"></div>
<label>Occupation</label> <select name="<%=OCCUPATION_ID %>"
			validate="Occupation,metachar,no" tabindex="1" id="occupationId" disabled="disabled"> 
			<option value="">Select</option>
			<% for(MasOccupation purpose: occupationList ){ %>
					<option value="<%=purpose.getId() %>"><%=purpose.getOccupationName() %></option>
				<%}
				
				%>
			</select>			

<label>Education</label> <select name="<%=EDUCATION %>"
			validate="education,metachar,no" tabindex="1" id="educationId" disabled="disabled">
			<option value="">select</option>
			<% for(MasQualification education: educationList){ %>
				<option value="<%=education.getId()%>"><%=education.getQualificationName() %></option>
			<%}
			
			%>
			</select>
<label>Native Sub Centre</label> <select name="<%=NATIVE_SUB_CENTRE %>" disabled="disabled"
			 tabindex="1" id="nativeSubCentre">
			
			<option value="">Select</option>
			 
			<%
			for(Object[] objectArray:subCenterList){%>
				<option value="<%=objectArray[0] %> "><%=objectArray[1]%></option>
			<% }
			
			%>
			</select>

</div>		
<input type="hidden" id="updatePatienthinid" name="updatePatienthinid" value=""/>
<div class="clear"></div>
	<div class="division"></div>

	<div id="searchbar">
		<div id="edited"></div>
		<input type="button"  value="UPDATE" tabindex="1"
			class="button"
			onClick="if(checkFillField()){submitForm('updateRegistration','/hms/hms/registration?method=updatePatientInformation&'+csrfTokenName+'='+csrfTokenValue)}"/>
		<input type="reset" name="Reset" value="Reset" class="buttonHighlight"
			tabindex="1" onclick="" accesskey="" />	
							
</div>
<div class="clear"></div>

</form>
</div>
<script type="text/javascript">
function popwindowUploadDocuments()
{
	var patienthinid=document.getElementById('updatePatienthinid').value;
	
if(patienthinid !=""){
	var url="/hms/hms/registration?method=openUploadPopWindow&hinId="+patienthinid+"&"+csrfTokenName+"="+csrfTokenValue;
 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=1024,status=1,scrollbars=1,resizable=0");
}
}

function checkFillField(){
	
	var uhidNo=document.getElementById('UHIDId').value;
	
	if( uhidNo == ''){
		alert(" UHID field can not blank  ");
		return false;	
	}
	else{
		
		
		return true;
	}
	
}
function hello(){
	  document.getElementById("VerifyID").value = "Verified";
	
}
//commented and added by govind 09-082-107
/*function openOPT() {
	var mobNo=document.getElementById('mobileNoId').value;
	if(mobNo !=""){
	var height=200;
	var width=700;
	var left = (screen.width/2)-(width/2);
	var top = (screen.height/2)-(height/2);
	window.open( "/hms/hms/registration?method=showOPTjsp&"+csrfTokenName+"="+csrfTokenValue,"_blank","width=200, height=100");
	}
	else{
		alert("Enter Mobile Number");
	}
}*/
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
//commented and added by govind 09-082-107 end

//----Function for age through ajax----------
function calculateAgeInAjax() {
dob=document.getElementById('qDobId').value;

	if(dob != ""){
		if(checkDob()){
		action="/hms/hms/registration?method=calculateAgeInAjax&dateOfBirth="+dob;
		obj = eval('document.updateRegistration')
		       obj.action = action;
	    	   	 var url=action
	 }
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
    	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
    	for (loop = 0; loop < items.childNodes.length; loop++) {
    		
	   	    var item = items.childNodes[loop];
	        var age  = item.getElementsByTagName("age")[0];
	        
	        var period  = item.getElementsByTagName("period")[0];
	        var year= item.getElementsByTagName("birthYear")[0];
	        document.getElementById("qAgeUnitId").value=year.childNodes[0].nodeValue;
	       obj=eval(document.getElementById('qAgeId'));
	       
	       
	       
	       if(age.childNodes[0].nodeValue == "0"){
	      document.getElementById("qAgeId").value=age.childNodes[0].nodeValue;
	       }else{

		   document.getElementById("qAgeId").value=age.childNodes[0].nodeValue;
		  
		   		  }
		   	document.getElementById('qAgeUnitId').style.display = 'inline';
		    temp =document.getElementById('qAgeUnitId');
		   temp.value=period.childNodes[0].nodeValue
		   /* document.getElementById('religionId').focus(); */
    	}
    }
  }
  var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

  xmlHttp.open("GET",url,true);
  xmlHttp.setRequestHeader("Content-Type", "text/xml");
  xmlHttp.send(null);

  }
}



/*function checkForDOB()
{
	
       if(document.getElementById("qAgeId").value!="" && document.getElementById("qAgeId").value>0)
       {
               var ageAtRegTime=document.getElementById("qAgeId").value;
               if(ageAtRegTime.indexOf(".")==1)
               {
                       currentAge=ageAtRegTime.substring(0,ageAtRegTime.indexOf("."));
               }
               else if(ageAtRegTime.indexOf(".")==-1)
               {
                       currentAge=document.getElementById("qAgeId").value;
               }
               document.getElementById('qAgeId').value=currentAge;
               var apoxAge=calculateApproxDobFromAge();
               document.getElementById("qDobId").value="";
               document.getElementById("qDobId").value=apoxAge;
       } else{
    	   alert("Enter valid age ")
    	   document.getElementById("age").value="";
    	   return false;
       }


       return true;
}

function calculateApproxDobFromAge(){
	
var age =  document.getElementById('qAgeId').value;

       var obj = age.split(" ");
       currentDateJ = new Date();
       
       unit=document.getElementById("qAgeUnitId").value;
      /*  unit=obj[1]; */
/*       year = 0; month = 0; day = 0;
       if(unit == 'Years'){
               year = currentDateJ.getFullYear()- age;
               
       }
       else if(unit == 'Months'){
               month=(currentDateJ.getMonth()+1)-age;
               if(month<=0){
                       month = month+12
                       year--;
               }
               if(month != 0)
                       month = (month<10)? "0"+month : month


       }
       else if(unit == 'Days'){
               day = (currentDateJ.getDate()-age)
               if(day<0){
                       day = day+30
                       month--;
               }
               day = (day<10)? "0"+day : day

       }

      /*  if(year <= 0)
               year = currentDateJ.getFullYear()+year;
       if(month <= 0)
               month = (((currentDateJ.getMonth()+1)+month)<10)? "0"+((currentDateJ.getMonth()+1)+month) : ((currentDateJ.getMonth()+1)+month);
       if(day == 0)
               day = (currentDateJ.getDate()<10)? "0"+currentDateJ.getDate() : currentDateJ.getDate();
 */
 
/* if(year <= 0)
     year = currentDateJ.getFullYear()+year;
 document.getElementById("qYobId").value=year;
if(month <= 0)
	month = ((currentDateJ.getMonth()+1)<10)? "0"+(currentDateJ.getMonth()+1) : (currentDateJ.getMonth()+1);
   //  month = (((currentDateJ.getMonth()+1)+month)<10)? "01":"01";
if(day == 0)
	day = (currentDateJ.getDate());
    // day = (currentDateJ.getDate()<10)? "01":"01";

       approxDob =day + "/" + month + "/" + year;
       return approxDob;

}
*/

</script>
<script>

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

var formObj = document.getElementById('formupdateId');
var inputArr = formObj.getElementsByTagName("input");
for (i=0; i<inputArr.length; i++){

if(/text/.test(inputArr[i].type)){

inputArr[i].onfocus = function(){
//this.style.backgroundColor = "yellow";
};

inputArr[i].onblur = function(){
this.style.backgroundColor = "";
};

}

}

var formObj = document.getElementById('formupdateId');
var inputArr = formObj.getElementsByTagName("textarea");
for (i=0; i<inputArr.length; i++){

if(/text/.test(inputArr[i].type)){

inputArr[i].onfocus = function(){
t//his.style.backgroundColor = "yellow";
};

inputArr[i].onblur = function(){
this.style.backgroundColor = "";
};

}

}

var formObj = document.getElementById('formupdateId');
var inputArr = formObj.getElementsByTagName("Select");
for (i=0; i<inputArr.length; i++){



inputArr[i].onfocus = function(){
//this.style.backgroundColor = "yellow";
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
if(inputArr[i].name=='qAgeUnit'){

inputArr[i].onblur=function(){
checkForDOB();
this.style.backgroundColor = "";
}

}
if(inputArr[i].name=='registrationType'){

inputArr[i].onblur=function(){
//checkForPatientType();
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
//this.style.backgroundColor = "yellow";
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
if(inputArr1[i].name=='qAge'){
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
<div class="paddingTop40"></div>
<!-- <div class="paddingTop40"></div>	 -->						

 
<%-- <form name="search" method="post" action="">
	
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 19 July 2010
 -->	
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="Block"><!--<label class="medium">Service No.</label><input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" MAXLENGTH="30" onblur="getHinNo('search','registration?method=getHinNoForUpdateAdt&flag=registration')"/>-->
<div id="hinDiv"><label class="medium"> <%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input
	type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30" id="hinNo12"
	onchange="submitProtoAjax('search','registration?method=getPatientName')" onblur="checkHin"
	validate="<%=prop.getProperty("com.jkt.hms.registration_no") %>,String,yes" /></div>
<div id="testDiv"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','/hms/hms/registration?method=showUpdateRegistrationJsp');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="submitProtoAjax('search','registration?method=getPatientName')"
	accesskey="r" />
<input type="hidden" id="hinNo" name="hinNo" value=""/>
<!--<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('search','registration?method=generateBarCode');"/>
--></form>

<script>
function checkHin(){
	document.getElementById('hinNo').value = document.getElementById('hinNo12').value;
	return true;
}
</script>
<div class="clear"></div>
<div class="division"></div>

<!--Code added by Kishore to club search and update registration on 25th mar 2015 start -->
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.masters.business.MasCompany"%>
<%@page import="jkt.hms.masters.business.MasSetupParameterMaintaince"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.HospitalParameters"%>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasCaseType"%>

<%@ page import="jkt.hms.masters.business.MasTitle"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="jkt.hms.masters.business.MasOccupation"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hms.masters.business.MasBlock"%>
<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@ page import="jkt.hms.masters.business.MasReference"%>
<%@ page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.MasPatientType"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasCaste"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>


<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%><script
	src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="../jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="../jsp/js/switchicon.js"></script>

<script>
<% calendar = Calendar.getInstance();
			 month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			 date = String.valueOf(calendar.get(Calendar.DATE));
			 year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
serverdate = '<%=date + "/" + month + "/" + year%>'
</script>

<form name="updateRegistration" method="post" action="" id="form1">
	<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 19 July 2010
 -->
	<%
		 myURL = application
				.getResource("/WEB-INF/commonFile.properties");
		 in = myURL.openStream();
		 prop = new Properties();
		prop.load(in);
		//out.println("name-jsp-" +p.getProperty("age") );
		String serverPath=application.getResource("/WEB-INF/").getPath();
	%>

	<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	Map<String, Object> map = new HashMap<String, Object>();

	Map<String, Object> patientDetailsMap = new HashMap<String, Object>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<Visit> visitList = new ArrayList<Visit>();
	List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
	List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
	List<MasState> nativePlaceList = new ArrayList<MasState>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	List<MasCompany> companyList = new ArrayList<MasCompany>();
	if (map.get("companyList") != null) {
		companyList = (List<MasCompany>) map.get("companyList");
	}
	if (map.get("patientDetailsMap") != null) {
		patientDetailsMap = (Map<String, Object>) map
				.get("patientDetailsMap");
	}
	List<UploadDocuments> uploadDocumentsList = new ArrayList<UploadDocuments>();
	if (patientDetailsMap.get("uploadDocumentsList") != null) {
		uploadDocumentsList = (List<UploadDocuments>) patientDetailsMap
				.get("uploadDocumentsList");
	}

	if (patientDetailsMap.get("patientList") != null) {
		patientList = (List<Patient>) patientDetailsMap
				.get("patientList");
	}
	if (map.get("nativePlaceList") != null) {
		nativePlaceList = (List<MasState>) map
				.get("nativePlaceList");
	}
	//
	
	if (patientDetailsMap.get("visitList") != null) {
		/*
			not required visit detail on update registration
			code by Mukesh Narayan SIngh
			Confirmed By Mr. Bambam Gautam
			Date 16 July 2010
		 */
		//visitList = (List<Visit>)patientDetailsMap.get("visitList");
	}
	if (map.get("chargeCodeList") != null) {
		chargeCodeList = (List<MasChargeCode>) map
				.get("chargeCodeList");
	}
	if (map.get("authorizerList") != null) {
		authorizerList = (List<MasAuthorizer>) map
				.get("authorizerList");
	}
	BigDecimal amount = new BigDecimal(0.00);
	BigDecimal rate = new BigDecimal(0.00);
	BigDecimal stdDeduction = new BigDecimal(0.00);
	BigDecimal discAmt = new BigDecimal(0.00);

	if (map.get("amount") != null) {
		amount = (BigDecimal) map.get("amount");
	}
	if (map.get("rate") != null) {
		rate = (BigDecimal) map.get("rate");
	}
	if (map.get("discAmt") != null) {
		discAmt = (BigDecimal) map.get("discAmt");
	}
	if (map.get("stdDeduction") != null) {
		stdDeduction = (BigDecimal) map.get("stdDeduction");
	}
	String billNo = "";
	if (map.get("billNo") != null) {
		billNo = (String) map.get("billNo");
	}
	MasSetupParameterMaintaince systemParam = new MasSetupParameterMaintaince();
	if (map.get("systemParam") != null) {
		systemParam = (MasSetupParameterMaintaince) map
				.get("systemParam");
	}
	int regChargeId = 0;
	if (systemParam.getUpdateRegChargeCode() != null) {
		regChargeId = systemParam.getUpdateRegChargeCode().getId();
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	if (map.get("unitList") != null) {
		unitList = (List<MasUnit>) map.get("unitList");
	}
	List<MasReligion> religionList = new ArrayList<MasReligion>();
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
	List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	List<MasReference> referenceList = new ArrayList<MasReference>();
	List<MasCountry> countryList = new ArrayList<MasCountry>();
	List<MasState> stateList = new ArrayList<MasState>();
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<MasBlock> blockList = new ArrayList<MasBlock>();
	//List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
	List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
	List<MasCaste> casteList = new ArrayList<MasCaste>();
	List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
	List<MasVillage> villageList = new ArrayList<MasVillage>();

	/*
	 * Code For validation in hospital parameter
	 Code By Mukesh Narayan Singh
	 Date 15 July 2010
	 */
	HospitalParameters hospitalParameters = new HospitalParameters();
	if (patientDetailsMap.get("hospitalParameters") != null) {
		hospitalParameters = (HospitalParameters) patientDetailsMap
				.get("hospitalParameters");
	}
	String blockStatus = "";
	if (hospitalParameters.getBlock() != null) {
		blockStatus = hospitalParameters.getBlock().trim();
	}
	String postOfficeStatus = "";
	if (hospitalParameters.getPostOffice() != null) {
		postOfficeStatus = hospitalParameters.getPostOffice().trim();
	}
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if (map.get("titleList") != null) {
		titleList = (List<MasTitle>) map.get("titleList");
	}
	if (map.get("maritalStatusList") != null) {
		maritalStatusList = (List<MasMaritalStatus>) map
				.get("maritalStatusList");
	}
	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map
				.get("departmentList");
	}
	if (map.get("religionList") != null) {
		religionList = (List<MasReligion>) map.get("religionList");
	}
	if (map.get("countryList") != null) {
		countryList = (List<MasCountry>) map.get("countryList");
	}
	if (map.get("stateList") != null) {
		stateList = (List<MasState>) map.get("stateList");
	}
	if (map.get("districtList") != null) {
		districtList = (List<MasDistrict>) map.get("districtList");
	}
	if (map.get("blockList") != null) {
		blockList = (List<MasBlock>) map.get("blockList");
	}
	if (map.get("relationList") != null) {
		relationList = (List<MasRelation>) map.get("relationList");
	}
	if (map.get("referenceList") != null) {
		referenceList = (List<MasReference>) map.get("referenceList");
	}

	if (map.get("occupationList") != null) {
		occupationList = (List<MasOccupation>) map
				.get("occupationList");
	}
	//if(map.get("recordOfficeAddressList") != null){
	//recordOfficeAddressList = (List<MasRecordOfficeAddress>)map.get("recordOfficeAddressList");
	//}
	if (map.get("diagnosisList") != null) {
		diagnosisList = (List<MasDiagnosisConclusion>) map
				.get("diagnosisList");
	}
	if (map.get("sexList") != null) {
		sexList = (List<MasAdministrativeSex>) map.get("sexList");
	}
	if (map.get("patientTypeList") != null) {
		patientTypeList = (List<MasPatientType>) map
				.get("patientTypeList");
	}
	if (map.get("employeeList") != null) {
		doctorList = (List<MasEmployee>) map.get("employeeList");
		employeeList = (List<MasEmployee>) map.get("employeeList");
	}
	if (map.get("caseTypeList") != null) {
		caseTypeList = (List<MasCaseType>) map.get("caseTypeList");
	}
	if (map.get("casteList") != null) {
		casteList = (List<MasCaste>) map.get("casteList");
	}
	if (map.get("postCodeList") != null) {
		postCodeList = (List<MasPostCode>) map.get("postCodeList");
	}
	if (map.get("villageList") != null) {
		villageList = (List<MasVillage>) map.get("villageList");
	}
	List<MasEmployeeDependent> employeeDependentList = new ArrayList<MasEmployeeDependent>();
	if (map.get("employeeDependentList") != null) {
		employeeDependentList = (List<MasEmployeeDependent>) map
				.get("employeeDependentList");
	}
	boolean cardValidFlag = false;
	String cardValidityDatePre = "";
	if (patientList.size() > 0) {
		Patient patient = new Patient();
		patient = (Patient) patientList.get(0);
		if (patient.getCardValidDate() != null) {
			cardValidFlag = HMSUtil.checkCardValidityDate(HMSUtil
					.convertDateToStringTypeDate(patient
							.getCardValidDate()));
			cardValidityDatePre = HMSUtil
					.convertDateToStringTypeDateOnly(patient
							.getCardValidDate());
		}
	}

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	//String selectedTitleForReg = properties.getProperty("selectedTitleForReg");
	//String administrativeSexMaleCode = properties.getProperty("administrativeSexMaleCode");
	//String bangaloreDistrictCode = properties.getProperty("bangaloreDistrictCode");
	//String karnatakaStateCode = properties.getProperty("karnatakaStateCode");
	//String indiaCode = properties.getProperty("indiaCode");
	//String departmentTypeCodeForCR = properties.getProperty("departmentTypeCodeForCR");
	String empCategoryCodeForDoctor = properties
			.getProperty("empCategoryCodeForDoctor");
%>
	<script type="text/javascript">
function displayAddress(){
var unit = document.getElementById('unitId').value;
document.getElementById('unitAddId').style.display = 'inline';
if(unit != 0){
if(unit != 'Other'){
document.getElementById('addUnitDiv').style.display = 'none';
<%for (MasUnit masUnit : unitList) {%>
var unit1 = '<%=masUnit.getId()%>';
if(unit == unit1){

document.updateRegistration.unitAdd.value = '<%=masUnit.getUnitAddress()%>'
}
<%}%>}else if(unit == 'Other'){
document.getElementById('addUnitDiv').style.display = 'inline';
document.getElementById('unitAddId').style.display = 'none';
}
}else if(unit == 0){
document.updateRegistration.<%=UNIT_ADDRESS%>.value = '';
}
}
</script>
	<script type="text/javascript">
<%int counter1 = 0;
			for (MasState masState : stateList) {
				for (MasDistrict masDistrict : districtList) {
					if (masDistrict.getState() != null) {
						if (masState.getId().equals(
								masDistrict.getState().getId())) {%>
districtArray[<%=counter1%>] = new Array();
districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;
districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

<%counter1++;
						}
					}
				}
			}%>
<%int count = 0;
			for (MasDistrict masDistrict : districtList) {
				for (MasBlock masBlock : blockList) {
					if (masBlock.getDistrict() != null) {
						if (masDistrict.getId().equals(
								masBlock.getDistrict().getId())) {%>
blockArray[<%=count%>] = new Array();
blockArray[<%=count%>][0] = <%=masDistrict.getId()%>;
blockArray[<%=count%>][1] = <%=masBlock.getId()%>;
blockArray[<%=count%>][2] = "<%=masBlock.getBlockName()%>";

<%count++;
						}
					}
				}
			}%>
</script>

	<div class="clear"></div>

	<%
	String hin_no = "";
	if (patientList.size() > 0) {
		for (Patient patient : patientList) {
			hin_no = patient.getHinNo();
%>
	<!-- Patient details  section Starts-->
	<h4>Personal Information</h4>
	<div class="clear"></div>
	<div class="Block">
		<!--<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>

-->

		<script>
   function checklenth(){
	   
	   var num="";
       num=document.getElementById("phone").value;
       alert("num>>"+num+"num length---->"+num.length);
       if(num.length>11)
       {
           alert("Enter Only 11 Digits!!");
       }
       }
   
   </script>
		<input type="hidden" id="hinNoId2" name="hinNoId2"
			value="<%=patient.getId()%>" /> <label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
		<label id="hinNoDivId" class="value"> <%=patient.getHinNo()%></label>
		<input id="hinNoId" type="hidden" name="<%=HIN_NO%>"
			value="<%=patient.getHinNo()%>" /> <label class="medium">Reg
			Date</label> <input type="text" name="<%=REG_DATE%>" id="registrationDateId"
			value="<%=HMSUtil.convertDateToStringWithoutTime( 
							.getRegDate())%>"
			validate="Registration Date,String,no" class="readOnly"
			readonly="readonly" /> <label class="medium">Reg Time</label> <input
			type="text" name="<%=REG_TIME%>" value="<%=patient.getRegTime()%>"
			validate="Registration Time,string,no" maxlength="20"
			class="readOnly" readonly="readonly" />
		<div class="clear"></div>
		<label><span>*</span> Patient Type</label>
		<%
//checkForPatientType();displayCompanyList();
	if (cardValidFlag) {
%>
		<input type="hidden" name="cardValidFlag" id="cardValidFlag" value="0" />
		<select name="<%=PATIENT_TYPE_ID%>" id="patientTypeId"
			validate="Patient Type,string,yes"
			onchange="calculateValidUptoDateInAjax('updateRegistration');displayCompanyList();"
			tabindex="1" onchange="checkForPatientType();">
			<%
	} else {
%>
			<input type="hidden" name="cardValidFlag" id="cardValidFlag"
			value="1" />
			<select name="<%=PATIENT_TYPE_ID%>" id="patientTypeId"
			validate="Patient Type,string,yes" tabindex="1"
			onchange="calculateValidUptoDateInAjax('updateRegistration');displayCompanyList();"
			onchange="checkForPatientType();">
				<%
		}
	%>

				<option value="0" selected="selected">select</option>
				<%
		String registrationValidDate = "";
				int validationDays = 0;
				for (MasPatientType masPatientType : patientTypeList) {
					if (patient.getPatientType() != null) {
						if (masPatientType.getId().equals(
								patient.getPatientType().getId())) {
							validationDays = masPatientType.getValidity();
	%>
				<option value="<%=masPatientType.getId()%>" selected="selected"><%=masPatientType.getPatientTypeName()%></option>
				<%
						} else {
					%>
				<option value="<%=masPatientType.getId()%>"><%=masPatientType.getPatientTypeName()%></option>
				<%
					}
								} else {
				%>
				<option value="<%=masPatientType.getId()%>"><%=masPatientType.getPatientTypeName()%></option>
				<%
		}
				}
	%>
		</select>
			<script type="text/javascript">
document.updateRegistration.<%=PATIENT_TYPE%>.focus();
</script>
			<%
	if (cardValidFlag) {
		if (validationDays > 0) {
			registrationValidDate = HMSUtil
					.getNextDate(validationDays);
		}
	} else {
				if (validationDays > 0) {
					registrationValidDate = HMSUtil
							.getNextDate(validationDays);
				}
			}
%>
			<!-- Code For Company List -->
			<%
	//String fileSeparator = System.getProperty("file.separator");

String uploadURL ="";
if(map.get("uploadURL")!=null){
	uploadURL=(String)map.get("uploadURL");
}

if (patient.getPatientImage()!=null) {
				String path="";
				path=uploadURL+hin_no;
				File f = new File(path);
				try {
					if (f.exists()) {
						f.delete();
						f.mkdir();
						File someFile = new File(path+"\\"+hin_no + ".jpg");
						FileOutputStream fos = new FileOutputStream(
								someFile);
						fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					} else {
						f.mkdir();
						File someFile = new File(path+"\\"+hin_no + ".jpg");
						FileOutputStream fos = new FileOutputStream(
								someFile);
						fos.write(patient.getPatientImage());
						fos.flush();
						fos.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				String imgfile =path+"\\"+hin_no+".jpg";

				%>


			<div class="clear"></div>


			<label class="">Patient Photo</label>
			<img id="img1" style="border: 5px solid"
			src="/hms/uploadedImage/<%=hin_no %>/<%=hin_no %>.jpg" width="210px"
			height="155px" />


			<%
 	}
 %>

			<!--
 Code for Image Upload
 Code By Mukesh Narayan Singh
 Date 14 Oct 2010
  -->
			<label class="auto">Update Image</label>
			<jsp:include page="testImageUpload.jsp" />
			<div class="division"></div>
			<!--
 End Of Code for Image Upload
 Code By Mukesh Narayan Singh
 Date 14 Oct 2010
  -->


			<%
 if(patient.getCompany()!=null)
 {
	 %>
			<label id="companyLable"><span>*</span> Company</label>
			<select name="<%=COMPANY%>" id="comId" validate="Company,string,no"
			tabindex="2" onchange="checkForPatientType();">
				<option value="0">Select</option>
				<%
		for (MasCompany masCompany : companyList) {
					if (masCompany.getId() == patient.getCompany().getId()) {
	%>
				<option value="<%=masCompany.getId()%>" selected="selected"><%=masCompany.getCompanyName()%></option>
				<%
		}
	}
	%>
		</select>
			<%}%>
			<label id="companyLable" style="display: none;"><span>*</span>
				Company</label>
			<label id="insuranceLable" style="display: none;"><span>*</span>
				Company</label>
			<div id="company" style="display: none;">
				<select name="<%=COMPANY%>" id="comId" validate="Company,string,no"
					tabindex="2" onchange="checkForPatientType();">
					<option value="0">Select</option>
					<%
		for (MasCompany masCompany : companyList) {
					if (masCompany.getPatientType().getId().intValue() == 1) {
	%>
					<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
					<%
		}
				}
	%>
				</select>
			</div>
			<div id="insurance" style="display: none;">
				<select name="<%=COMPANY%>" id="insId" validate="Company,string,no"
					tabindex="3">
					<option value="0">Select</option>
					<%
		for (MasCompany masCompany : companyList) {
					if (masCompany.getPatientType().getId().intValue() == 7) {
	%>
					<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
					<%
		}
				}
	%>
				</select>
			</div>

			<label id="insAmtlbl" style="display: none;"><span>*</span>
				Amount</label>
			<div id="insAmt" style="display: none;">
				<input type="text" id="" name="" value="" tabindex="4" title=""
					MAXLENGTH="15" />
			</div>
			<label id="employeelbl" style="display: none;"><span>*</span>Employee</label>
			<div id="employeeDiv" style="display: none;">
				<select name="<%=EMPLOYEE_ID%>" id="employeeId"
					validate="Employee,string,no" tabindex="5">
					<option value="0">Select</option>
					<%
		for (MasEmployee masEmployee : employeeList) {
					String employeeName = "";
					employeeName = masEmployee.getFirstName();
					if (masEmployee.getMiddleName() != null) {
						employeeName += " " + masEmployee.getMiddleName();
					}
					if (masEmployee.getLastName() != null) {
						employeeName += " " + masEmployee.getLastName();
					}
	%>
					<option value="<%=masEmployee.getId()%>"><%=employeeName%></option>
					<%
		}
	%>
				</select>
			</div>
			<!-- End Of Code for Company Date 19 July 2010 Code By Mukesh Narayan Singh-->
			<label id="employeeDependentlbl" style="display: none;"><span>*</span>Employee
				Dependent</label>
			<div id="employeeDependentDiv" style="display: none;">
				<select name="<%=EMPLOYEE_DEPENDENT_ID%>" id="employeeDependentId"
					validate="Employee Dependent,string,no" tabindex="6"
					onblur="getDepandentDetails();">
					<option value="0">Select</option>
					<%
		for (MasEmployeeDependent masEmployeeDependent : employeeDependentList) {
	%>
					<option value="<%=masEmployeeDependent.getId()%>"><%=masEmployeeDependent
								.getEmployeeDependentName()%></option>
					<%
		}
	%>
				</select>
			</div>
			<input type="hidden" name="depndtRelation" id="depndtRelation"
			value="" />
			<label id="prjlbl" style="display: none;"><span>*</span>Project</label>
			<div id="prjDiv" style="display: none;">
				<select name="<%=PROJECT_ID%>" id="prjId"
					validate="Project,string,no" tabindex="7">
					<option value="0">Select</option>
					<%
		for (MasCompany masCompany : companyList) {
					if (masCompany.getPatientType().getId().intValue() == 4) {
	%>
					<option value="<%=masCompany.getId()%>"><%=masCompany.getCompanyName()%></option>
					<%
		}
				}
	%>
				</select>
			</div>


			<div class="clear"></div>
			<label>Title</label>
			<select id="titleId" name="<%=TITLE%>" validate="Title,string,no">
				<option value="0">Select</option>
				<%
		for (MasTitle masTitle : titleList) {
	%>
				<option value="<%=masTitle.getId()%>"><%=masTitle.getTitleName()%></option>
				<%
		}
	%>

		</select>
			<script type="text/javascript">
<%if (patient.getTitle() != null) {
						int titleId = patient.getTitle().getId();%>
document.updateRegistration.<%=TITLE%>.value = '<%=titleId%>';
<%}%>
</script>
			<label>Valid Up To</label>
			<input type="text" name="validUpTo" id="validUpToId"
			value="<%=registrationValidDate%>" maxlength="6" readonly="readonly"
			class="readOnly" />

			<label>Aadhaar No.</label>
			<input type="text" id="pAadhaarNumberId" name="<%=P_AADHAAR_NUMBER%>"
			value="<%=patient.getAadhaarNo()!=null?patient.getAadhaarNo():"" %>"
			tabindex="1" validate="Aadhaar No,int,no" MAXLENGTH="12" />

			<div class="clear"></div>
			<label><span>*</span> First Name</label>
			<input type="text" id="pFirstNameId" name="<%=P_FIRST_NAME%>"
			value="<%=patient.getPFirstName()%>"
			validate="First Name,alphaspace,yes" MAXLENGTH="15" tabindex="1" />
			<input type="hidden" name="pFirstNameIdTemp" id="pFirstNameIdTemp"
			value="" />
			<label>Middle Name</label>
			<%
 	if (patient.getPMiddleName() != null
 					&& !(patient.getPMiddleName().equals(""))) {
 %>
			<input type="text" name="<%=P_MIDDLE_NAME%>" id="pMiddleNameId"
			value="<%=patient.getPMiddleName()%>" validate="Middle Name,name,no"
			MAXLENGTH="15" tabindex="1" />
			<%
 	} else {
 %>
			<input type="text" name="<%=P_MIDDLE_NAME%>" id="pMiddleNameId"
			value="" validate="Middle Name,name,no" MAXLENGTH="15" tabindex="1" />
			<%
 	}
 %><input type="hidden" name="pMiddleNameIdTemp" id="pMiddleNameIdTemp"
			value="" />
			<label>Last Name</label>
			<%
 	if (patient.getPLastName() != null
 					&& !(patient.getPLastName().equals(""))) {
 %>
			<input type="text" name="<%=P_LAST_NAME%>" id="pLastNameId"
			value="<%=patient.getPLastName()%>" validate="Last Name,name,no"
			MAXLENGTH="15" tabindex="1" />
			<%
 	} else {
 %>
			<input type="text" id="pLastNameId" name="<%=P_LAST_NAME%>" value=""
			validate="Last Name,name,no" MAXLENGTH="15" tabindex="1" />
			<%
 	}
 %>
			<input type="hidden" name="pLastNameIdTemp" id="pLastNameIdTemp"
			value="" />
			<div class="clear"></div>

			<label><span>*</span> Gender</label>
			<select name="<%=GENDER%>" id="gender" validate="Gender,string,yes"
			tabindex="1">
				<%
		for (MasAdministrativeSex masAdministrativeSex : sexList) {
	%>
				<option value="<%=masAdministrativeSex.getId()%>"><%=masAdministrativeSex
								.getAdministrativeSexName()%></option>
				<%
		}
	%>
		</select>
		<input type="hidden" name="genderTemp" id="genderTemp" value="0" />
			<script type="text/javascript">
<%if (patient.getSex() != null) {
						int sexId = patient.getSex().getId();%>
document.updateRegistration.<%=GENDER%>.value = '<%=sexId%>';
<%}%>
</script>
			<label>DOB</label>
			<%
 	if (patient.getDateOfBirth() != null) {
 %>
			<input type="text" id="dobId" name="<%=DATE_OF_BIRTH%>"
			value="<%=HMSUtil
								.convertDateToStringWithoutTime(patient
										.getDateOfBirth())%>"
			readonly="readonly" validate="Date of Birth,date,no" MAXLENGTH="30"
			onchange="calculateAgeInAjax('updateRegistration');" class="date"
			tabindex="1" />
			<div id="dobcalId">
				<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
					validate="Pick a date" tabindex="1"
					onclick="javascript:setdate('',document.updateRegistration.<%=DATE_OF_BIRTH%>,event);"
					onblur="calculateAgeInAjax('updateRegistration');"
					onchange="calculateAgeInAjax('updateRegistration');" />
			</div>

			<%
	} else {
%>
			<!--
Code commented By Mukesh
If DOB is null then DOb Enter

<label class="value">-</label>
-->
			<input type="text" id="dobId" name="<%=DATE_OF_BIRTH%>" value=""
			readonly="readonly" validate="Date of Birth,date,no" MAXLENGTH="30"
			onchange="calculateAgeInAjax('updateRegistration');" class="date"
			tabindex="1" />
			<div id="dobcalId">
				<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
					validate="Pick a date" tabindex="1"
					onclick="javascript:setdate('',document.updateRegistration.<%=DATE_OF_BIRTH%>,event);"
					onblur="calculateAgeInAjax('updateRegistration');"
					onchange="calculateAgeInAjax('updateRegistration');" />
			</div>
			<%
 	}
 %>
			<label>Age</label>
			<%
 	if (patient.getAge() != null) {
 				int age = 0;
				if(patient.getDateOfBirth()!=null){
 				 age = HMSUtil.getCurrentAgeByDoB(patient
 						.getDateOfBirth());
				}
 				String ageTempPatient = patient.getAge();
 				String ageArr[] = ageTempPatient.split(" ");
 				String ageUnitTemp = "";
 				try{
 				if (ageArr[1] != null) {

 					if (ageArr[1] != null) {
 						ageUnitTemp = ageArr[1];
 					} else {
 						ageUnitTemp = "";
 					}

 				}
 				}catch (Exception e) {
 		    	     System.err.println("Error: " + e.getMessage());
 		  	      e.printStackTrace();
 		  	    }
 %>
			<!--<label class="value"><%=patient.getAge()%></label> -->
			<input type="text" name="<%=AGE%>" id="age" value="<%=age%>"
			readonly="readonly" class="small" maxlength="2" tabindex="15"
			validate="Age,string,no" onblur="checkForDOB();" />
			<input type="text" id="ageUnitId" name="<%=AGE_UNIT%>"
			value="<%=ageUnitTemp%>" validate="AgeUnit,string,no" tabindex="16"
			class="small" readonly="readonly" onblur="checkForDOB();" />

			<%
	}
%>
			<input type="hidden" name="ageTemp" id="ageTemp" value="" />
			<input type="hidden" name="dobIdTemp" id="dobIdTemp" value="" />
			<input type="hidden" name="ageUnitIdTemp" id="ageUnitIdTemp" value="" />
			<div class="clear"></div>

			<label><span>*</span> Religion</label>
			<select name="<%=RELIGION%>" id="religionId"
			validate="Religion,string,yes" tabindex="17">
				<option value="0">Select</option>
				<%
		for (MasReligion masReligion : religionList) {
	%>
				<option value="<%=masReligion.getId()%>"><%=masReligion.getReligionName()%></option>
				<%
		}
	%>
		</select>
			<script type="text/javascript">
<%if (patient.getReligion() != null) {
						int religionId = patient.getReligion().getId();%>
document.updateRegistration.<%=RELIGION%>.value = '<%=religionId%>';
<%}%>
</script>
			<input type="hidden" name="religionIdTemp" id="religionIdTemp"
			value="0" />
			<input type="hidden" name="casteIdTemp" id="casteIdTemp" value="0" />
			<input type="hidden" name="addrTemp" id="addrTemp" value="" />

			<label>Caste</label>
			<select id="casteId" name="<%=CASTE%>" validate="caste,string,no"
			tabindex="18">
				<option value="0">Select</option>
				<%
	for (MasCaste masCaste : casteList) {
%>
				<option value="<%=masCaste.getId()%>"><%=masCaste.getCasteName()%></option>
				<%
	}
%>
		</select>
			<script type="text/javascript">
<%if (patient.getCaste() != null) {
						int casteId = patient.getCaste().getId();%>
document.updateRegistration.<%=CASTE%>.value = '<%=casteId%>';
<%}%>
</script>
			<label>Address</label>
			<%
 	if (patient.getAddress() != null) {
 %>
			<textarea name="<%=ADDRESS%>" id="addr" cols="20" rows="2"
				validate="Address,string,no" onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				tabindex="1"><%=patient.getAddress()%></textarea>
			<%
 	} else {
 %>
			<textarea name="<%=ADDRESS%>" cols="20" rows="2"
				validate="Address,string,no" id="addr"
				onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				tabindex="1"></textarea>
			<%
 	}
 %>
			<input type="hidden" name="addrTemp" id="addrTemp" value="" />
			<script type="text/javascript">

<%int counter = 0;
					for (MasCountry masCountry : countryList) {
						for (MasState masState : stateList) {
							if (masState.getCountry() != null) {
								if (masCountry.getId().equals(
										masState.getCountry().getId())) {%>
stateArr[<%=counter%>] = new Array();
stateArr[<%=counter%>][0] = <%=masCountry.getId()%>;
stateArr[<%=counter%>][1] = <%=masState.getId()%>;
stateArr[<%=counter%>][2] = "<%=masState.getStateName()%>";
<%counter++;
								}
							}
						}
					} %>
</script>

			<div class="clear"></div>
	</div>
	<!-- Closed Div for block -->
	<div class="clear"></div>
	<div class="clear"></div>
	<h4>Contact Information</h4>
	<div class="Block">
		<label><span>*</span> Country</label> <select name="nationality"
			validate="Nationality,string,yes"
			onChange="populateState(this.value,'updateRegistration')"
			onblur="populateState(this.value,'updateRegistration')" tabindex="1"
			id="countryId">
			<option value="0">Select</option>
			<%
		for (MasCountry cntMaster : countryList) {
			
	%>
			<option value="<%=cntMaster.getId()%>"><%=cntMaster.getCountryName()%></option>
			<%
		}
	%>
		</select>
		<script type="text/javascript">
<%if (patient.getCountry() != null) {
						int countryId = patient.getCountry().getId();%>
						//alert("alert"+document.updateRegistration.<%=NATIONALITY%>.value);

document.getElementById('countryId').value='<%=countryId%>';
<%}%>
</script>
		<div class="clear"></div>
		<label><span>*</span> State</label> <select name="state"
			validate="State,string,yes" id="stateId"
			onChange="populateDistrict(this.value,'updateRegistration')"
			onblur="populateDistrict(this.value,'updateRegistration')"
			tabindex="1">
			<option value="0">Select</option>
			<%
		for (MasState masState : stateList) {
			if(patient.getState() !=null){
				if(patient.getState().getId().equals(masState.getId())){
	%>
			<option value="<%=masState.getId()%>" selected="selected"><%=masState.getStateName()%></option>
			<%}else{ %>
			<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
			<%} }else{ %>
			<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
			<%
		}}
	%>
		</select> <label><span>* </span>Native Place</label> <select name="nativePlace"
			id="nativePlace" validate="Native Place,string,yes">
			<option value="0">Select</option>
			<%for(MasState nativePlace:nativePlaceList){
	if(patient.getNativePlace()!=null && patient.getNativePlace().getId()==nativePlace.getId()){
	%>
			<option selected="selected" value="<%=nativePlace.getId() %>"><%=nativePlace.getStateName() %></option>
			<%}else{ %>
			<option value="<%=nativePlace.getId() %>"><%=nativePlace.getStateName() %></option>
			<%} }%>
		</select> -
		<script type="text/javascript">
<%int stateId = 0;
					if (patient.getState() != null) {
						stateId = patient.getState().getId();%>
document.updateRegistration.<%=STATE%>.value = '<%=stateId%>';
<%}%>
</script>
		<label>District</label>
		<%
				if (blockStatus.equalsIgnoreCase("n")
						& postOfficeStatus.equalsIgnoreCase("n")) {
	%>
		<select name="<%=DISTRICT%>" id="cityId" tabindex="22"
			validate="District,string,no"
			onChange="populateVillageFromDist(this.value);">
			<%
		} else if (!blockStatus.equalsIgnoreCase("n")
						& postOfficeStatus.equalsIgnoreCase("n")) {
	%>
			<select name="<%=DISTRICT%>" id="cityId" tabindex="22"
			validate="District,string,no"
			onChange="populateBlock(this.value,'updateRegistration');">
				<%
			} else if (blockStatus.equalsIgnoreCase("n")
							& !postOfficeStatus.equalsIgnoreCase("n")) {
		%>
				<select name="<%=DISTRICT%>" id="cityId" tabindex="22"
				validate="District,string,no"
				onChange="populateDistrictPostOffice(this.value,'updateRegistration')">
					<%
				} else {
			%>
					<select name="<%=DISTRICT%>" id="cityId" tabindex="22"
					validate="District,string,no"
					onChange="populateBlock(this.value,'updateRegistration');">
						<%
					}
				%>
						<option value="0">Select</option>
						<%
				 int stateId=0;
			if(patient.getState()!=null){
				stateId=patient.getState().getId();
			}
		for (MasDistrict masDistrict : districtList) {
					if (masDistrict.getState().getId() == stateId) {
	%>
						<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
						<%
		}
				}
	%>
				</select>
					<script type="text/javascript">
<%if (patient.getDistrict() != null) {
						int districtId = patient.getDistrict().getId();%>
document.updateRegistration.<%=DISTRICT%>.value = '<%=districtId%>';
<%}%>
</script>
					<div id="disableBlock" style="display: none">
						<label><span>*</span> Block</label>
						<%
	if (postOfficeStatus.equalsIgnoreCase("n")) {
%>
						<select name="<%=BLOCK%>" validate="Block,string,no" tabindex="23"
							validate="Block,string,yes" id="blockId"
							onchange="populateVillageOfBlock(this.value);"
							onblur="populatePostOff(this.value);">
							<%
					} else {
				%>
							<select name="<%=BLOCK%>" validate="Block,string,no"
							tabindex="23" validate="Block,string,yes" id="blockId"
							onchange="populatePostOff(this.value);"
							onblur="populatePostOff(this.value);">
								<option value="0">Select</option>
								<%
						}
					%>
								<option value="0">Select</option>
								<%
		for (MasBlock masBlock : blockList) {
					if (masBlock.getDistrict() != null) {
						if(patient.getDistrict()!=null){
							if (masBlock.getDistrict().getId().equals(
									patient.getDistrict().getId())) {
								if (patient.getBlock() != null
										&& patient.getBlock().getId().equals(
												masBlock.getId())) {
		%>
								<option value="<%=masBlock.getId()%>" selected="selected"><%=masBlock.getBlockName()%></option>
								<%
			} else {
		%>
								<option value="<%=masBlock.getId()%>"><%=masBlock.getBlockName()%></option>
								<%
			}
							}
						}else{
					%>
								<option value="<%=masBlock.getId()%>"><%=masBlock.getBlockName()%></option>
								<%
						}
						}

					//}
				}
	%>
						</select>


							<div class="clear"></div>
					</div>

					<div id="disablePostOffice" style="display: none">
						<label><span>*</span> Post Office</label> <select
							name="<%=POST_OFFICE%>" id="postOff"
							onchange="populateVillage(this.value);"
							onblur="populateVillage(this.value);" tabindex="1">
							<option value="0">Select</option>
							<%
				for (MasPostCode postCode : postCodeList) {
					if (postCode.getBlock() != null
							&& patient.getBlock() != null && patient.getPostCode()!=null) {
						if (postCode.getBlock().getId() == patient
								.getBlock().getId()) {
							if (patient.getPostCode() != null
									&& patient.getPostCode().getId()
											.equals(postCode.getId())) {
	%>
							<option value="<%=patient.getPostCode().getId()%>"
								selected="selected"><%=patient.getPostCode()
											.getPostCodeName()%></option>
							<%
		} else {
	%>
							<option value="<%=postCode.getId()%>"><%=postCode.getPostCodeName()%></option>

							<%
		}
						}
					}else {
						%>
							<option value="<%=postCode.getId()%>"><%=postCode.getPostCodeName()%></option>

							<%
							}
				}
	%>
						</select>
					</div>
					<%
	if (!blockStatus.equalsIgnoreCase("Y")) {
%>
					<div class="clear"></div>
					<%
				}
			%>
					<script type="text/javascript">
<%int countDistrctPO = 0;
					for (MasDistrict masDistrict : districtList) {
						for (MasPostCode masPostCode : postCodeList) {
							if (masPostCode.getBlock() != null) {
								if (masDistrict.getId().equals(
										masPostCode.getBlock().getDistrict()
												.getId())) {%>
			districtPostOfficeArray[<%=countDistrctPO%>] = new Array();
			districtPostOfficeArray[<%=countDistrctPO%>][0] = <%=masDistrict.getId()%>;
			districtPostOfficeArray[<%=countDistrctPO%>][1] = <%=masPostCode.getId()%>;
			districtPostOfficeArray[<%=countDistrctPO%>][2] = "<%=masPostCode.getPostCodeName()%>";

			<%countDistrctPO++;
								}
							}
						}
					}%>
</script>
			</select>


				<label> Village</label>
				<select name="<%=PATIENT_DISTRICT%>" id="patientDistId"
				validate="Village,string,no" tabindex="1">

					<option value="0">Select</option>
					<%
		for (MasVillage village : villageList) {
					if (village.getPostCode() != null && patient.getVillage()!=null && patient.getPostCode()!=null) {
						if (village.getPostCode().getId().equals(
								patient.getPostCode().getId())) {
							if (patient.getVillage() != null
									&& patient.getVillage().getId().equals(
											village.getId())) {
	%>
					<option value="<%=village.getId()%>" selected="selected"><%=patient.getVillage()
											.getVillageName()%></option>
					<%
		} else {
	%>
					<option value="<%=village.getId()%>"><%=village.getVillageName()%></option>

					<%
		}
						}
					}else {
						%>
					<option value="<%=village.getId()%>"><%=village.getVillageName()%></option>

					<%
							}
				}
	%>
			</select>
				<label>Pincode</label>
				<%
 	if (patient.getPinCode() != null) {
 %>
				<input type="text" name="<%=PINCODE%>"
				value="<%=patient.getPinCode()%>" id="pinCodeId"
				validate="Pincode,int,no" maxlength="8" tabindex="1"
				onkeypress="return isNumberKey(event);" />
				<%
 	} else {
 %>
				<input type="text" name="<%=PINCODE%>" value=""
				validate="Pincode,int,no" id="pinCodeId" maxlength="8" tabindex="1"
				onkeypress="return isNumberKey(event);" />
				<%
 	}
 %>

				<div class="clear"></div>



				<label>Police Station</label>
				<%
if(patient.getPoliceStation() != null){
%>
				<input type="text" name="<%=POLICE_STATION %>"
				value="<%=patient.getPoliceStation() %>"
				validate="Police Station,alphaspace,no" MAXLENGTH="30" tabindex="1" />
				<%}else{ %>
				<input type="text" name="<%=POLICE_STATION %>" value=""
				validate="Police Station,alphaspace,no" MAXLENGTH="30" />
				<%} %>

				<label>Phone</label>
				<%
	if (patient.getPhoneNumber() != null) {
%>
				<input type="text" name="<%=PHONE%>" id="phone"
				value="<%=patient.getPhoneNumber()%>" validate="Phone,phone,no"
				MAXLENGTH="16" tabindex="1" onkeypress="return isNumberKey(event)" />
				<%
 	} else {
 %>
				<input type="text" name="<%=PHONE%>" value="" class="textbox_size20"
				id="phone" validate="Phone,phone,no" MAXLENGTH="16" tabindex="1"
				onkeypress="return isNumberKey(event)" onb />
				<%
 	}
 %>
				<label>Mobile</label>
				<%
	if (patient.getMobileNumber() != null) {
%>
				<input type="text" name="<%=MOBILE%>" id="mobile"
				value="<%=patient.getMobileNumber()%>"
				validate="Mobile Number,phone,no" MAXLENGTH="12" tabindex="1"
				onkeypress="return isNumberKey(event)" />
				<%
 	} else {
 %>

				<input type="text" name="<%=MOBILE%>" value=""
				class="textbox_size20" id="mobile"
				style="border: 1px solid #7f9db7;" validate="Mobile Number,phone,no"
				MAXLENGTH="12" tabindex="1" onkeypress="return isNumberKey(event)" />
				<%
 	}
 %>


				<div class="clear"></div>


				<label>Email Id</label>
				<%
 	if (patient.getEmailId() != null) {
 %>
				<input type="text" name="<%=EMAIL_ID%>" id="email"
				value="<%=patient.getEmailId()%>" validate="Email Id,email,no"
				MAXLENGTH="40" tabindex="1" onblur="validateForm();" />
				<%
 	} else {
 %>
				<input type="text" name="<%=EMAIL_ID%>" id="email"
				name="<%=EMAIL_ID%>" value="" validate="Email Id,email,no"
				MAXLENGTH="40" tabindex="1" onblur="validateForm();" />
				<%
 	}
 %>
				<label>Occupation</label>
				<select name="<%=OCCUPATION_ID%>" validate="Occupation,string,no"
				class="select_adt" tabindex="1">
					<option value="0">Select</option>
					<%
		for (MasOccupation masOccupation : occupationList) {
	%>
					<option value="<%=masOccupation.getId()%>"><%=masOccupation.getOccupationName()%></option>
					<%
		}
	%>
			</select>
				<script type="text/javascript">
<%if (patient.getOccupation() != null) {
						int occupationId = patient.getOccupation().getId();%>
document.updateRegistration.<%=OCCUPATION_ID%>.value = '<%=occupationId%>';
<%}%>
</script>
				<label>Marital Status</label>
				<select name="<%=MARITAL_STATUS_ID%>"
				validate="Marital Status,string,no">
					<option value="0">Select</option>
					<%
		for (MasMaritalStatus masMaritalStatus : maritalStatusList) {
	%>
					<option value="<%=masMaritalStatus.getId()%>"><%=masMaritalStatus.getMaritalStatusName()%></option>
					<%
		}
	%>
			</select>
				<script type="text/javascript">
<%if (patient.getMaritalStatus() != null) {
						int maritalStatusId = patient.getMaritalStatus()
								.getId();%>
document.updateRegistration.<%=MARITAL_STATUS_ID%>.value = '<%=maritalStatusId%>';
<%}%>
</script>

				<div class="clear"></div>

				<label>Reference</label>
				<select name="<%=REFERENCE%>" validate="Reference,string,no"
				tabindex="1">
					<option value="0">Select</option>
					<%
		for (MasReference masReference : referenceList) {
	%>
					<option value="<%=masReference.getId()%>"><%=masReference.getReferenceName()%></option>
					<%
		}
	%>
			</select>
				<script type="text/javascript">
<%if (patient.getReference() != null) {
						int referenceId = patient.getReference().getId();%>
document.updateRegistration.<%=REFERENCE%>.value = '<%=referenceId%>';
<%}%>
</script>
				<label><span>*</span> Relative Name</label>
				<%
 	if (patient.getNextOfKinName() != null) {
 %>
				<input type="text" name="<%=RELATIVE_NAME%>" id="nokNameId"
				value="<%=patient.getNextOfKinName()%>"
				validate="Relative Name,fullName,yes" maxlength="30" tabindex="1" />
				<%
 	} else {
 %>
				<input type="text" name="<%=RELATIVE_NAME%>" value="" id="nokNameId"
				validate="Relative Name,fullName,yes" maxlength="30" tabindex="1" />
				<%
 	}
 %>
				<input type="hidden" name="relativeNameTemp" id="relativeNameTemp"
				value="" />
				<div class="clear"></div>


				<label><span>*</span> Relation</label>
				<select name="<%=RELATION_ID%>" id="realtionId"
				validate="Relation,string,yes" tabindex="1">
					<option value="0">Select</option>
					<%
		for (MasRelation masRelation : relationList) {
			if(patient.getRelation()!=null ){
			if(patient.getRelation().getId().equals(masRelation.getId())){
	%>
					<option value="<%=masRelation.getId()%>" selected="selected"><%=masRelation.getRelationName()%></option>
					<%}else{%>
					<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
					<% }}%>
					<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
					<%
		}
	%>
			</select>
				<script type="text/javascript">
<%if (patient.getNextOfKinRelation() != null) {
						int nokRelationId = patient.getNextOfKinRelation()
								.getId();%>
document.getElementById("realtionId").value = '<%=nokRelationId%>';
<%}%>
</script>
				<label>Relative Phone</label>
				<%
 	if (patient.getNextOfKinPhoneNumber() != null) {
 %>
				<input type="text" name="<%=EMERGENCY_PHONE%>" id="emphine"
				value="<%=patient.getNextOfKinPhoneNumber()%>"
				onkeypress="return isNumberKey(event);"
				validate="Kin Phone,phone,no" maxlength="16" tabindex="1" />
				<%
 	} else {
 %>
				<input type="text" name="<%=EMERGENCY_PHONE%>" value="" id="emphine"
				validate="Kin Phone,phone,no" maxlength="16" tabindex="1"
				onkeypress="return isNumberKey(event);" />
				<%
 	}
 %>
				<label>Relative Address</label>
				<%
 	if (patient.getNextOfKinAddress() != null) {
 %>
				<textarea name="<%=EMERGENCY_ADDRESS%>"
					validate="Kin Address,string,no"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMozJsp(this)" maxlength="250"
					tabindex="1"><%=patient.getNextOfKinAddress()%></textarea>
				<%
	} else {
%>
				<textarea name="<%=EMERGENCY_ADDRESS%>"
					validate="Kin Address,string,no"
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMozJsp(this)" maxlength="250"
					tabindex="1"></textarea>
				<%
 	}
 %>

				<div class="clear"></div>

				<label>Remarks</label>
				<%
 	if (patient.getRemarks() != null) {
 %>
				<textarea name="<%=REMARKS%>" cols="99" rows="2"
					validate="Remarks,string,no" onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
					tabindex="1" maxlength="50"><%=patient.getRemarks()%></textarea>
				<%
 	} else {
 %>
				<textarea name="<%=REMARKS%>" cols="99" rows="2"
					validate="Remarks,string,no" onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMozJsp(this)" tabindex="1"
					maxlength="50"></textarea>
				<%
 	}
 %>
				<div class="clear"></div>
	</div>

	<!-- Patient details  section Ends-->
	<%
 	if (visitList.size() > 0) {}
%>

	<!-- Visit details  section Ends-->
	<!-- OTHER DETAILS  section  starts-->


	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<!--  Code for billing if registraion updated
Code By Mukesh Narayan SIngh
Date 16 July 2010
if cardValidFlag=false then billing is required
-->
	<%
			//if(!cardValidFlag){
%>

	<div class="clear"></div>
	<div class="division"></div>

	<div class="titleBg">
		<h2><%=prop.getProperty("com.jkt.hms.bill_heading")%></h2>
	</div>
	<div class="clear"></div>

	<div class="Block">
		<div class="clear"></div>
		<label>Billing Required (No)</label> <input type="radio"
			name="<%=SELECTED_RADIO%>" id="rad" value="1" checked="checked"
			class="radioCheck" /> <label>Billing Required (Yes)</label> <input
			type="radio" name="<%=SELECTED_RADIO%>" id="rad1" value="2"
			class="radioCheck" />

		<div class="clear"></div>


		<div id="testDiv">
			<label><%=prop.getProperty("com.jkt.hms.bill_no")%></label> <input
				type="text" id="billNo" class="readOnly" name="billNo"
				value="<%=billNo%>" readonly="readonly"
				title="Bill No of the Patient" validate="Bill No,int,no"
				MAXLENGTH="15" />
			<div id="amount">
				<label>Amount</label> <input type="text" id="amt" name="amt"
					value="<%=amount.setScale(2, BigDecimal.ROUND_HALF_UP)%>"
					MAXLENGTH="4" readonly="readonly" class="readOnly" /> <input
					type="hidden" name="billamt" id="billamt" value="<%=rate%>"
					MAXLENGTH="4" class="readOnly" readonly="readonly" /> <input
					type="hidden" name="stdDeduction" id="stdDeduction"
					value="<%=stdDeduction%>" MAXLENGTH="4" class="readOnly"
					readonly="readonly" /> <input type="hidden" name="discAmt"
					id="discAmt" value="<%=discAmt%>" MAXLENGTH="4" class="readOnly"
					readonly="readonly" />
			</div>
		</div>


		<label>Registration Type</label> <select name="regisType"
			id="regisType" tabindex="45"
			onchange="submitProtoAjaxWithDivName('updateRegistration','/hms/hms/registration?method=getAmount','amount')">
			<option value="G">General</option>
			<option value="S">Special</option>
		</select> <input type="hidden" name="<%=CONSULTING_DOCTOR%>"
			id="consultingDocId" value="0" /> <input type="hidden"
			name="<%=CASE_TYPE_ID%>" value="0" />
		<div class="clear"></div>

		<label><span>*</span> Charge</label> <select name="registrationType"
			id="registrationType" tabindex="46" onblur="checkForPatientType();"
			onfocus="checkForPatientType();">
			<%
	
		for (MasChargeCode masChargeCode : chargeCodeList) {
					if (masChargeCode.getId() != regChargeId) {
						if(masChargeCode.getId()==1253){
	%>
			<option value="<%=masChargeCode.getId()%>" selected="selected"><%=masChargeCode.getChargeCodeName()%></option>

			<%
						}else{%>
			<option value="<%=masChargeCode.getId()%>"><%=masChargeCode.getChargeCodeName()%></option>
			<%}}
				}
	%>
		</select> <label><%=prop.getProperty("com.jkt.hms.discount")%></label> <input
			type="text" id="discount" tabindex="47" name="discount" value=""
			validate="<%=prop.getProperty("com.jkt.hms.discount")%>, int, no"
			MAXLENGTH="3" onblur="checkForDiscount();"
			onkeypress="return isNumberKey(event);" /> <label>Authorizer</label>
		<select name="refDoctor" id="refDoctor"
			validate="Ref Doctor,string,no" tabindex="48">
			<option value="0">Select</option>
			<%
		for (MasAuthorizer masAuthorizer : authorizerList) {
	%>
			<option value="<%=masAuthorizer.getId()%>"><%=masAuthorizer.getAuthorizerName()%></option>
			<%
		}
	%>
		</select>

		<div class="clear"></div>

		<label><span>*</span>Actual Collected Amount</label> <input
			type="text" id="actualColAmtId" name="actualCollectedAmt"
			tabindex="49" onkeypress="return isNumberKey(event);"
			value="<%=amount.setScale(2, BigDecimal.ROUND_HALF_UP)%>"
			validate="Actual Collected Amount,float,no" maxlength="8" /> <input
			type="hidden" id="idForAge" name="idForAge" />
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div class="division"></div>

	<!-- End of code for billing
	Code by Mukesh Narayan Singh
	Date 16 July 2010
 -->
	<%
	//	}
%>
	<!-- OTHER DETAILS  section  ends-->

	<div class="clear"></div>
	<div class="division"></div>
	<div id="searchbar">

		<div id="edited"></div>

		<input type="button" name="Submit" value="Update" class="button"
			onClick="calform();" />
		<!-- <input name="Send" type="button"  class="buttonBig" value="Attach Photo" onClick="javascript:openPopupWindow();" /> -->
		<input type="reset" name="Reset" value="Reset" class="buttonHighlight"
			onClick="document.location.reload(true)" accesskey="r" />

		<%
 	}
 	} else {
 %>
		<h4>
			<span>No record found!!</span>
		</h4>
		<%
	}
%>
	</div>
	<h4 id="statusMessage"></h4>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=currentDate%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label> <input type="hidden"
			name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE%>" value="<%=currentDate%>" /> <input
			type="hidden" name="<%=CHANGED_TIME%>" value="<%=time%>" />
	</div>
	<div class="paddingTop40"></div>
	<div class="paddingTop40"></div>
</form>

<script type="text/javascript">
function openPopupWindow()
{
	var hinNo = document.getElementById('hinNoId').value;
	var url="/hms/hms/registration?method=displayRegisPhoto&hinNo=<%=hin_no%>";
 	newwindow=window.open(url,'name',"left=100,top=100,height=400,width=350,status=1,scrollbars=1,resizable=0");
}

</script>
<script type="text/javascript">
// Code for disable and enabled block and post office
// code by mukesh Narayan Singh
// Date 12 July 2010
//disablePostOffice
var blockStatus="Y";
var postOfficeStatus="Y";

if(blockStatus=='<%=blockStatus%>' && postOfficeStatus=='<%=postOfficeStatus%>'){
	document.getElementById('disableBlock').style.display ='inline';
	document.getElementById('disablePostOffice').style.display ='inline';
}else if(blockStatus=='<%=blockStatus%>' && postOfficeStatus!='<%=postOfficeStatus%>'){
	document.getElementById('disableBlock').style.display ='inline';
	document.getElementById('disablePostOffice').style.display ='none';
}else if(blockStatus!='<%=blockStatus%>' && postOfficeStatus=='<%=postOfficeStatus%>'){
	document.getElementById('disableBlock').style.display ='none';
	document.getElementById('disablePostOffice').style.display ='inline';
}else{
	document.getElementById('disableBlock').style.display ='none';
	document.getElementById('disablePostOffice').style.display ='none';
}
</script>

<script type="text/javascript">
function checkForDiscount()
{
	var authorizer=eval(document.updateRegistration.refDoctor.value);
	var amount=parseFloat(document.updateRegistration.amt.value);
	var discountVar=document.updateRegistration.discount.value;
	if(isNaN(discountVar)){

	if(validateFloat(discountVar)){
		if(parseFloat(discountVar)>parseFloat(amount))
		{
			alert("Discount should be less than or equal to amount!!");
			document.updateRegistration.discount.value="";
			return false;
		}else if(parseFloat(discountVar)== parseFloat(amount)){
			document.getElementById('actualColAmtId').value = "";
		}
		if(discountVar!="" && authorizer==0)
		{
			alert("Select Authorizer!!");
			return false;
		}
		document.getElementById('actualColAmtId').value = "";
	}else{
		alert("Discount should be integer or decimal value.");
		document.updateRegistration.discount.value = "";
		return false;

	}
	}else{
		if(parseFloat(discountVar)>parseFloat(amount))
		{
			alert("Discount should be less than or equal to amount!!");
			document.updateRegistration.discount.value="";
			return false;
		}
		}
	return true;
}
function displayCompanyList()
{

		var company = document.updateRegistration.<%=PATIENT_TYPE%>.value;
	//	if(company != "2"){
	//		getActivateReadOnlyFieldOnReg();
	//	}
		if(company == "1"){
			document.getElementById('company').style.display = "inline";
			document.getElementById('companyLable').style.display = "inline";
			document.getElementById('comId').focus();
			document.getElementById('comId').style.backgroundColor = "yellow";
			document.getElementById('employeeDependentDiv').style.display = "none";
			document.getElementById('employeeDependentlbl').style.display = "none";

		}else if (company != "1"){
			document.getElementById('company').style.display = "none";
			document.getElementById('companyLable').style.display = "none";
			document.getElementById('employeeDependentDiv').style.display = "none";
			document.getElementById('employeeDependentlbl').style.display = "none";
			document.getElementById('comId').style.backgroundColor = "";
		}

		if(company == "7"){
			document.getElementById('insurance').style.display = "inline";
			document.getElementById('insuranceLable').style.display = "inline";
			document.getElementById('insAmtlbl').style.display = "inline";
			document.getElementById('insAmt').style.display = "inline";
			document.getElementById('insId').focus();
			document.getElementById('insId').style.backgroundColor = "yellow";
			document.getElementById('employeeDependentDiv').style.display = "none";
			document.getElementById('employeeDependentlbl').style.display = "none";

		}else if (company != "7"){
			document.getElementById('insurance').style.display = "none";
			document.getElementById('insuranceLable').style.display = "none";
			document.getElementById('insAmtlbl').style.display = "none";
			document.getElementById('insAmt').style.display = "none";
			document.getElementById('employeeDependentDiv').style.display = "none";
			document.getElementById('employeeDependentlbl').style.display = "none";
			document.getElementById('insId').style.backgroundColor = "";
		}

		if(company == "4"){
			document.getElementById('prjDiv').style.display = "inline";
			document.getElementById('prjlbl').style.display = "inline";
			document.getElementById('prjId').focus();
			document.getElementById('prjId').style.backgroundColor = "yellow";
		}else if (company != "4"){
			document.getElementById('prjDiv').style.display = "none";
			document.getElementById('prjlbl').style.display = "none";
			document.getElementById('prjId').style.backgroundColor = "";
		}

		if(company == "8" || company == "2"){
			document.getElementById('employeeDiv').style.display = "inline";
			document.getElementById('employeelbl').style.display = "inline";
			document.getElementById('employeeId').focus();
			document.getElementById('employeeId').style.backgroundColor = "yellow";
		}else if (company != "8"){
			document.getElementById('employeeDiv').style.display = "none";
			document.getElementById('employeelbl').style.display = "none";
			document.getElementById('employeeId').style.backgroundColor = "";
		}

	//	if(document.getElementById("pFirstNameId").value!="")
		//	document.getElementById("pFirstNameId").value="";

		document.getElementById('employeeDependentId').value = "0";
		document.getElementById('employeeId').value = "0";
		document.getElementById('prjId').value = "0";
		document.getElementById('insId').value = "0";
		document.getElementById('comId').value = "0";
}
function checkForPatientType()
{
	var registrationType=document.getElementById('registrationType').value;
	var rad=document.getElementById('rad').value;
	var rad1=document.getElementById('rad1').value;
	if(rad!=""){
		//alert("if");
	submitProtoAjaxWithDivName('updateRegistration','/hms/hms/registration?method=getAmount&registrationType='+registrationType+'&<%=SELECTED_RADIO%>='+rad,'amount');
	}else{
		//("else");
		submitProtoAjaxWithDivName('updateRegistration','/hms/hms/registration?method=getAmount&registrationType='+registrationType+'&<%=SELECTED_RADIO%>='+rad1,'amount');
			}
}
function hideCalendar(patientType){

	if(patientType == 2 || patientType == 8){ // For Staff & staff dependent case
		document.getElementById('dobcalId').style.visibility = 'hidden';
		}else{
		document.getElementById('dobcalId').style.visibility = 'visible';
		}

	}
//---------------------- Code By MUkesh Narayan Singh Date 18 Aug 2010

var formObj = document.getElementById('form1');
var inputArr = formObj.getElementsByTagName("Select");
for (i=0; i<inputArr.length; i++){



inputArr[i].onfocus = function(){
this.style.backgroundColor = "yellow";
};

inputArr[i].onblur = function(){
this.style.backgroundColor = "";
};
if(inputArr[i].name=='<%=PATIENT_TYPE_ID%>'){
inputArr[i].onblur=function(){

//displayCompanyList();
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
checkForPatientType();
this.style.backgroundColor = "";
}

}
if(inputArr[i].name=='regisType'){

inputArr[i].onchange=function(){
submitProtoAjaxWithDivName('updateRegistration','/hms/hms/registration?method=getAmount','amount');
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

function employeeDepntList()
{
	var company = document.updateRegistration.<%=PATIENT_TYPE_ID%>.value;

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
				//document.getElementById("pFirstNameId").readonly=true;
	}
	document.updateRegistration.<%=EMPLOYEE_DEPENDENT_ID%>.focus();
}
function checkForDOB()
{

	if(document.getElementById("age").value!="" && document.getElementById("age").value>0)
	{
		var ageAtRegTime=document.getElementById("age").value;
		if(ageAtRegTime.indexOf(".")==1)
		{
			currentAge=ageAtRegTime.substring(0,ageAtRegTime.indexOf("."))+" "+document.getElementById("ageUnitId").value;
		}
		else if(ageAtRegTime.indexOf(".")==-1)
		{
			currentAge=document.getElementById("age").value+" "+document.getElementById("ageUnitId").value;
		}
		document.getElementById('idForAge').value=currentAge;
		var apoxAge=calculateApproxDobFromAge();
		document.getElementById("dobId").value="";
		document.getElementById("dobId").value=apoxAge;
	}

	return true;
}

/*
 * This function is used for remove readonly after select staf dependent
 Code By Mukesh Narayan SIngh
 Date 16 Aug 2010
 */
function getActivateReadOnlyFieldOnReg(){
	var objTitle=	document.getElementById("titleId");
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

     var obj1=	document.getElementById("gender");
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
</script>
<SCRIPT language=Javascript>
      <!--
      function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 46 || charCode > 57)){
             alert("Please Enter Numbers Only!!");
            return false;
         }else{
         return true;
         }
        
      }
      //-->
   </SCRIPT>
<script>
function validateForm()
{
var x="";
x=document.getElementById("email").value;

var atpos=x.indexOf("@");
var dotpos=x.lastIndexOf(".");
if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
  {
  alert("Not a valid e-mail address");
  return false;
  }
}
</script>
<script>function checkMaxLengthMozJsp(obj){
	//alert(obj);
     if(obj.value.length>50){
        alert("you are crossing maximum length limit pls reduce the some text");
	        return true;
    	}
    }
}</script>
<script language="JavaScript">
 function resetForm(){
   document.getElementById("updateRegistration").reset();
 } 
 function calform(){
	 var relation=document.getElementById("realtionId").value;
	 var relative=document.getElementById("nokNameId").value;
	 var nationality=document.getElementById("countryId").value;
	 var state=document.getElementById("stateId").value;
	 var phone=document.getElementById("phone").value;
	 var mobile=document.getElementById("mobile").value;
	 var emphine=document.getElementById("emphine").value;
	 var patientTypeId=document.getElementById("patientTypeId").value;
	 var nativePlaceId=document.getElementById("nativePlace").value;
	 //alert("---->>>"+nativePlaceId);
	 //alert(document.getElementById("nativePlace"));
	 if(document.getElementById("nativePlace").value=="0"){
		 alert("Please Select Native Place");
		 return false;
		 }else{
	 submitForm('updateRegistration','/hms/hms/registration?method=updatePatientInformation&nativePlace='+nativePlaceId+'&<%=RELATION_ID%>='+relation+'&relative='+relative+'&nationality='+nationality+'&state='+state+'&<%=PHONE%>='+phone+'&<%=MOBILE%>='+mobile+'&<%=EMERGENCY_PHONE%>='+emphine+'&<%=PATIENT_TYPE_ID%>='+patientTypeId);
	 }
	 }
</script>
<%
	authorizerList = null;
	blockList = null;
	caseTypeList = null;
	casteList = null;
	chargeCodeList = null;
	companyList = null;
	countryList = null;
	departmentList = null;
	diagnosisList = null;
	employeeDependentList = null;
	employeeList = null;
	maritalStatusList = null;
	nativePlaceList = null;
	sexList = null;
	stateList = null;
	titleList = null;
	unitList = null;
	uploadDocumentsList = null;
	villageList = null;
	visitList = null;
	authorizerList = null;
	blockList = null;
%>
 --%><!--Code added by Kishore to club search and update registration on 25th mar 2015 End -->



