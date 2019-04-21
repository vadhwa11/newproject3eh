<%@page import="java.util.Calendar"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasLsgType"%>
<%@page import="jkt.hms.masters.business.HospitalParameters"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_FULL_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.MOBILE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.LSG_HOUSE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.LSG_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.LSG_TYPE"%>
<%@ page import="static jkt.hms.util.RequestConstants.T_HOUSE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.WARD_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.GENDER"%>
<%@ page import="static jkt.hms.util.RequestConstants.AGE"%>
<%@ page import="static jkt.hms.util.RequestConstants.AGE_UNIT"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_LOCALITY"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_DEPARTMENT"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_TYPE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.OTHER_CATEGORY"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMPLOYEE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.DATE_OF_BIRTH"%>
<%@ page import="static jkt.hms.util.RequestConstants.BPL_STATUS"%>
<%@ page import="static jkt.hms.util.RequestConstants.YOB"%>
<%@ page import="static jkt.hms.util.RequestConstants.VISIT_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.VISIT_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.VISIT_NUMBER"%>
<%@ page
	import="static jkt.hms.util.RequestConstants.E_P_AADHAAR_NUMBER"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_BY"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHANGED_TIME"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_WARD_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_TALUK"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_POST_OFFICE"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_PINCODE"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_WARD"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_LSG_HOUSE_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_HEALTH_HOUSE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_LSG_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_HOUSE_NO"%>


<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />
 <script type="text/javascript">
	var unitIdLastVisit;
	var doctorIdLastVisit;
 </script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/registration.js"
	type="text/javascript"></script>
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
<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
List<MasDistrict> districtList = new ArrayList<MasDistrict>();
List<Object[]> patientTypeList = new ArrayList<Object[]>();
List<Object[]> otherCategoryList = new ArrayList<Object[]>();
List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
HospitalParameters hospitalParameters = new HospitalParameters();
List<MasLsgType> lsgTypeList = new ArrayList<MasLsgType>();
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
List<MasScheme> schemeList = null;
int districtIdByHospital=0;
if(map.get("districtId") != null)
{
	   districtIdByHospital=(Integer)map.get("districtId");
}

if(map.get("districtList") != null)
{
	   districtList = (List<MasDistrict>)map.get("districtList");
}

if(map.get("patientTypeList") != null)
{
        patientTypeList= (List<Object[]>)map.get("patientTypeList");
}

if(map.get("otherCategoryList") != null)
{
	   otherCategoryList= (List<Object[]>)map.get("otherCategoryList");
}


if (map.get("sexList") != null)
{
        sexList = (List<MasAdministrativeSex>) map.get("sexList");
}
if (map.get("departmentList") != null) 
{
	departmentList = (List<MasDepartment>) map.get("departmentList");
}
if(map.get("lsgTypeList") != null)
{
	  lsgTypeList =(List<MasLsgType>)map.get("lsgTypeList");
} 
if(map.get("schemeList") != null)
{
	schemeList =(List<MasScheme>)map.get("schemeList");
}
String userName = "";
if(session.getAttribute("userName") != null)
{
        userName = (String)session.getAttribute("userName");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");

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

String uhid=null;

String mobileNumber="";
String dateOfBirth="";
String hinNo="";
int district=0;
String fullname="";
if(map.get("puhid") != null)
{
        uhid = (String)map.get("puhid");
}
Map<String, Object> getDataMap = null;
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

Properties prop = new Properties();

URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
try
{
	   prop.load(resourcePath.openStream());
}
catch (Exception e)
{
        e.printStackTrace();
}
String administrativeSexMaleCode = prop.getProperty("administrativeSexMaleCode");

%>

<div class="clear"></div>
<div class="Block">

	<div style="width: 500px; float: left;">
		<label class="auto">New Registration <input
			style="margin-top: 3px;" name="visitType" id="regType"
			value="Registration" tabindex="62"
			onclick="displayScreen('registration')" maxlength="25"
			checked="checked" class="radioCheckCol2" type="radio">
		</label> <label class="auto">Revisit <input style="margin-top: 3px;"
			name="visitType" id="visitType" tabindex="62" value="Revisit"
			onclick="displayScreen('visit')" maxlength="25"
			class="radioCheckCol2" type="radio">
		</label>
	</div>
	<div class="floatRight" style="margin-right: 15px;">
		<label style="vertical-align: baseline;"><img
			src="/hms/jsp/images/yellow.jpg" width="14" height="14" /><span>Mandatory
				Fields</span></label>
	</div>

	<div class="clear"></div>
	<div class="paddingTop5"></div>

	<!-- New Registration part -->
	<div id="registration">
		<div class="titleBg">
			<h2>NEW REGISTRATION</h2>
		</div>
		<div class="clear"></div>
		<div class="paddingTop5"></div>
		<form method="post" name="quickRegistersearch">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}"> <label class="width100">Aadhar
				No</label> <input type="text" id="saadhaarNumberId" name="citzenAadhaar"
				value="<%=citzenAadhaar %>" tabindex="1"
				validate="Aadhaar No,int,no" MAXLENGTH="12" onchange="if(checkSearchFiled()){submitForm('quickRegistersearch','/hms/hms/registration?method=searchPatientFromCitizen&amp;quickReg=yes&amp;'+csrfTokenName+'='+csrfTokenValue)}" /> <label
				class="width100">Name</label> <input type="text" id="spNameId"
				name="<%=P_FULL_NAME %>" value="<%=scitizenName %>" tabindex="1"
				title="Full Name of the Patient"
				validate="Patient Name,metacharDot,no" MAXLENGTH="50"
				onkeypress="return searchKeyPress(event);" onchange="if(checkSearchFiled()){submitForm('quickRegistersearch','/hms/hms/registration?method=searchPatientFromCitizen&amp;quickReg=yes&amp;'+csrfTokenName+'='+csrfTokenValue)}" /> <label
				class="width100">Date of Birth</label> <input type="text"
				id="sbirthDayId" name="birthDay" tabindex="1"
				value="<%=ctizenDob %>" class="date" validate="Birth Day,date,no"
				class="date" onblur="validateExpDate(this,'sbirthDayId')"
				onkeyup="mask(this.value,this,'2,5','/');" MAXLENGTH="10"
				onkeypress="return searchKeyPress(event);" />

			<div id="sdobcalId">
				<img id="" src="/hms/jsp/images/cal.gif" width="16" height="16"
					border="0"
					onclick="setdate('<%=currentDate %>',document.quickRegistersearch.birthDay,event)"
					validate="Birth Day,date,no" onblur="" onchange="" tabindex="1" />
			</div>


			<div class="clear"></div>


			<label class="width100">Mobile No</label> <input type="text"
				name="<%=MOBILE_NO %>" id="smobileNo" value="<%=ctizenMob %>"
				validate="Mobile,phone,no" MAXLENGTH="12" tabindex="1"
				onkeypress="return searchKeyPress(event);" onchange="if(checkSearchFiled()){submitForm('quickRegistersearch','/hms/hms/registration?method=searchPatientFromCitizen&amp;quickReg=yes&amp;'+csrfTokenName+'='+csrfTokenValue)}"/> <label
				class="width100">District</label> <select name="sdistrict"
				id="sdistrict" tabindex="1" validate="District,int,no"
				onChange="lsgByDistrict('slsgNameId',this.value);">
				<option value="0">Select</option>
				<%
			for(MasDistrict masDistrict : districtList){ %>

				<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>

				<% }
%>
			</select> <label class="width100">LSG Name</label> <select
				name="<%=LSG_NAME %>" id="slsgNameId" validate="LSGName,int,no"
				onchange="populatePPWardByLsg('swardId',this.value);" tabindex="1">
				<option value="0">Select</option>


			</select>


			<div class="clear"></div>


			<label class="width100">LSG Type</label> <select
				name="<%=LSG_TYPE %>" id="slsgTypeId" tabindex="1" validate="LSGType,metachar,no">
				<option value="0">Select</option>
				<% for(MasLsgType masLsg:lsgTypeList){ %>
				<option value="<%=masLsg.getId()%>"><%=masLsg.getLsgTypeName() %></option>

				<%	}
			
				%>

			</select> <label class="width100">Ward</label> <select name="<%=WARD_NO %>"
				tabindex="1" id="swardId" validate="Ward,int,no">
				<option value="0">Select</option>
			</select> <label class="width100">House No</label> <input type="text"
				name="<%=T_HOUSE_NO %>" value="" maxlength="32" tabindex="1"
				id="houseId" validate="HouseNo,metacharDot,no" onblur="" />
			<div class="clear"></div>
			<input type="button" id="citizensearchId" name="search"
				value="Search" class="button" tabindex="1"
				onClick="if(checkSearchFiled()){submitForm('quickRegistersearch','/hms/hms/registration?method=searchPatientFromCitizen&quickReg=yes&'+csrfTokenName+'='+csrfTokenValue)}" />

			<input type="reset" name="Reset" value="Cancel"
				class="button"
				onclick="submitProtoAjax('quickRegistersearch','registration?method=getPatientName&quickReg=yes&'+csrfTokenName+'='+csrfTokenValue)"
				accesskey="r" />

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
				href='/hms/hms/registration?method=searchPatientFromCitizen&page=<%=currentPage-1%>&cmob=<%=cmobileNumber%>&uh=<%=hinNo%>&fn=<%=citizenName%>&dob=<%=cdob%>&dist=<%=district%>&quickReg=yes'>Previous</a>


			<% 
		}
		if(noOfPages>=1){
		
					%>


			<a
				href='/hms/hms/registration?method=searchPatientFromCitizen&page=<%=currentPage%>&cmob=<%=cmobileNumber%>&uh=<%=hinNo%>&fn=<%=citizenName%>&dob=<%=cdob%>&dist=<%=district%>&quickReg=yes'><%=currentPage%></a>
			<% 	
			
		}

		if(currentPage <noOfPages){
			%>

			<a
				href='/hms/hms/registration?method=searchPatientFromCitizen&page=<%=currentPage+1%>&cmob=<%=cmobileNumber%>&uh=<%=hinNo%>&fn=<%=citizenName%>&dob=<%=cdob%>&dist=<%=district%>&quickReg=yes'>Next</a>


			<% }

	else{
		%>
			<% 
	} %>

			<div class="Block">
				<!-- added by amit 22-01-2017 -->
				<input type="text" id="inPage" maxlength="4" style="width: 30px;" /><input
					type="button" value="Go" onclick="searchParticularPage();" /> <label>
					No of Pages : <%=noOfPages%></label>
			</div>

			<%} else {	%>
			<font size="4" weight="bold" color="red">No Record Found </font>
			<% } 
 }%>

			<div id="patientDtDiv"></div>

		</form>

		<div class="clear"></div>
		<div class="paddingTop5"></div>

		<form name="quickRegistration" id="form1" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
			<!-- <div class="cashDivRight">
				<label class="auto">Cash Recieved <input type="checkbox"
					tabindex="1" name="cashreceived"
					id="cashreceived" value="y" onclick="cashNotReceived()"
					style="margin: 0px 5px;" />
				</label>
			</div> -->

			<div class="clear"></div>
			<div class="paddingTop5"></div>
			<input type="hidden" name="citizenSearch" value=""
				id="citizenSearchId" />
			<!-- For  PH Data  -->
			<input type="hidden" name="familyID" id="familyID" value="" /> <input
				type="hidden" name="memberID" id="memberID" value="" /> <input
				type="hidden" name="bloodGroupValueId" id="bloodGroupValueId"
				value="" /> <input type="hidden" name="citizenData"
				id="citizenDataId" value="" /> <input type="hidden"
				id="phAadhaarNumberId" name="aadhaarNo" value="" tabindex="1"
				onkeypress="return isNumberKey(event)" validate="" MAXLENGTH="12" />
			<!-- End PH-->
			<label class="width100">Aadhar No</label> <input type="password"
				name="<%=E_P_AADHAAR_NUMBER%>" tabindex="1" MAXLENGTH="12" validate="Aadhar No,int,no"
				id="aadhaarNumberId" onchange="VerhoeffAlgorithm(this.value)"
				onblur="setIdType(this.value)" /> <input type="hidden"
				id="aadhaarVerifyStatus" name="aadhaarVerifyStatus" value=""
				tabindex="1" MAXLENGTH="12" /> <input type="hidden"
				tabindex="1" name="radio1" value="noId" id="radioId" /> 
				<input type="hidden"
				tabindex="1" name="radio2" value="" id="radioId2" /> 
				<input
				type="hidden" name="otpTxn" tabindex="1" id="otpTxn" /> <input
				type="button" class="button" value="QR Scan" tabindex="1"
				onclick="aadhaarQr()"
				style="background: #c00000; text-transform: none;; color: #fff;" />
			<input name="Generate OTP" id="ekycOtp" class="buttonAuto"  tabindex="1"
				value="eKYC"
				style="background: #c00000; text-transform: none; color: #fff;"
				type="button"
				onClick="if(ekycFiledCheck()){eKycAuthenticationOtp();}"> <label
				style="width: 74px;">OTP</label> <input id="otp" name="otp"
				tabindex="1" placeholder="OTP" value="" type="text"
				style="width: 70px;" /> <input id="Authenticate" tabindex="1"
				name="Authenticate" value="Verify eKYC" class="button"
				disabled="disabled" type="button" style="text-transform: none;"
				onClick="if(ekycOtpFiledCheck()){eKycAuthentication();}">

			<div class="clear"></div>

			<label class="width100">Patient Name</label> <input type="text"
				id="pNameId" onchange="" autofocus name="<%=P_FULL_NAME %>" value=""
				tabindex="1" title="Full Name of the Patient"
				validate="Patient Name,metacharDot,yes" MAXLENGTH="50" onblur="trimName(this);"
				style="width: 300px; margin-right: 0;" /> <label class="medium">Gender</label>
			<select id="gender" name="<%=GENDER %>" tabindex="1"
				validate="gender,int,yes" onChange="changeGender();"
				style="width: 94px;">
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
			</select> <label class="width100">Age</label> <input type="text"
				onblur="checkForDOB();calculateApproxDobFromAge();checkForScheme();" name="<%=AGE %>" onkeypress="return isNumber(event)" 
				id="age" maxlength="3" tabindex="1" validate="Age,int,yes"
				class="inputSmall" /> <select id="ageUnitId" name="<%=AGE_UNIT %>"
				validate="AgeUnit,string,no" tabindex="" onchange="checkForDOB();checkForScheme();"  tabindex="1"
				style="width: 94px;">
				<option selected="selected" value="Years">Years</option>
				<option value="Months">Months</option>
				<option value="Days">Days</option>
			</select> <input type="hidden" class="inputSmall" id="yobId" 
				name="<%=YOB %>" readonly="readonly" maxlength="4" /> <input
				type="hidden" name="NationDob" id="nationalDobId" value="" /> <input
				type="hidden" id="dobId" name="<%=DATE_OF_BIRTH %>" tabindex=""
				value="" onblur="validateExpDate(this,'sbirthDayId')"
				onkeyup="mask(this.value,this,'2,5','/');"
				onchange="calculateAgeInAjax(),enableAgeAndAgeUnitFiled()"
				MAXLENGTH="10" validate="DOB,date,yes" class="date" />
			<div class="clear"></div>
			

			<label class="width100">Monthly Income</label> <input type="text"
				name="monIncome" id="monIncome" maxlength="8" tabindex="1" validate="Monthly Income,float,no"
				onchange="monthlySalary(this.value)" style="width: 97-px;" onkeypress="return isNumber(event)" /> 
				<label class="width100">Area</label>
				<input type="text" name="<%=P_HOUSE_NO %>" value="" validate="Area,metacharDot,no" maxlength="32" tabindex="1" id="PhouseId" onblur="" />
			<div id="ac2updates" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		 new Ajax.Autocompleter('locality','ac2updates','registration?method=getLocalityAutocomplete',{minChars:3,parameters:'requiredField=<%=P_LOCALITY %>'
					});
		</script>
			<input type="hidden" name="<%=P_LOCALITY %>" id="localitysId"	tabindex="25"/>
			<input type="hidden" name="permanentDistrict" id="pcityId" tabindex="25"/>
			<input type="hidden" name="<%=P_WARD_ID %>" id="wardId" tabindex="25"/>
			<!-- <input type="hidden" name="localityIds" id="localitysId">	 -->
			<input type="hidden" name="<%=P_TALUK %>" id="talukId"/>	
			<input type="hidden" name="<%=P_POST_OFFICE %>" id="pppostOff"/>	
			<input type="hidden" name="<%=P_PINCODE %>" id="ppincode"/>
			
			<input type="hidden"  name="<%=P_LSG_HOUSE_NO %>" id="pLsgHouseNo" />
			<input type="hidden"  name="<%=P_HEALTH_HOUSE_ID %>" id="healthHouseId" />
			<input type="hidden"  name="<%=P_WARD %>" id="wardName" />
			<input type="hidden"  name="<%=P_LSG_NAME %>" id="lsgId" />
			
			<input type="hidden" id="pHouseName" name="houseName" value="" tabindex="14" validate="" MAXLENGTH="32" />
			<input type="hidden" id="pincode" name="aPinCode" value="" tabindex="20" validate="" MAXLENGTH="15" />
			<input type="hidden" id="streetName" name="streetName" value="" tabindex="15" validate="" MAXLENGTH="32" />
			<input type="hidden" name="ad" tabindex="" value="" id="aadhaarAddrID" />
			
			<select name="pDistrict" id="cityId" tabindex="16" style="display: none">
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
			
			
				 <label class="width100">Mobile Number</label>
			<input type="text" name="mobileNoVerify" value="" id="mobileNoId" 
				onchange="ValidateMobNumber('mobileNoId');"
				validate="Mobile Number,phone,no" tabindex="2" MAXLENGTH="10"
				class="inputSmall" /> <input tabindex="2" id="VerifyID"
				name="Verify" value="eHealth Verify" class="button" 
				style="text-transform: none; padding: 0px 8px; margin-left: 0px;"
				type="button" onclick="openOPT()">
			<div class="clear"></div>

			<input type="hidden" name="<%=VISIT_NUMBER %>"
				id="visitNoId" value="0" readonly="readonly" /> <input
				type="hidden" validate="Visit Date,date,no" 
				name="<%=VISIT_DATE%>" value="<%=currentDate %>" readonly="readonly" />
			<label class="width100">Department</label> <select id="deptId"
				name="<%=PATIENT_DEPARTMENT %>" tabindex="1"
				onchange="getSessionForDepartment(this.value,'opsession'); populateUnitForDepartment(this.value,'unit','loddrs','deptId','quickReg');"
				validate="Department,string,no">
				<option value="0">Select</option>
				<%
				for(MasDepartment masDepartment : departmentList)
		{%>
				<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
				<%}%>
			</select>

			<label class="width100">Session</label> <select id="opsession"
				name="opsession" validate="Session,string,no" tabindex="2">
				<option value="0">Select</option>

			</select> <input type="hidden" id="priorityId" name="priorityName" value="3">

			<label class="width100">Ration Card</label> <select id="bplId"
				name="<%=BPL_STATUS %>" tabindex="2" validate="Ration Card,string,no">
				<option value="">Select</option>
				<option value="pink">Pink</option>
				<option value="blue">Blue</option>
				<option value="white">White</option>
				<option value="Yellow">Yellow</option>
				<%-- <% 
       for(Object[] masPatientType : patientTypeList)
       {
             
%>
			<option value="<%=masPatientType[0]%>"><%=masPatientType[2]%></option>
			<%
              
       }
%> --%>
			</select>
			<div class="clear"></div>
			
			<div id="unitDetails" >
				<label class="width100">Unit</label> <select id="unit" name="unit" tabindex="1"
					validate="unit,metachar,no"
					onchange="populateDoctorForUnit(this.value,'quickReg','deptId')">
					<option value="">Select</option>
				</select> <label class="width100">Doctors Incharge</label> <input type="text"
					name="<%=EMPLOYEE_ID %>" id="consultingDocId" value=""
					readonly="readonly" validate="Doctors Incharge,metachar,no" /> 
			<label class="width100">
					Doctors</label> <select name="loddrs" id="loddrs" tabindex="1" title=""
					validate="loddrs,metachar,no" onchange="getAssignedPatientForDoctorSpecific(this.value)">
					<option value="">select</option>
				</select>
				<input name="patientCount" id="patientCount" value="" readonly="readonly" style="text-align: center;font-size:15px;width:25px;margin-left:0;background:#5bc0de;"/>	
			</div>
		
			<div class="clear"></div>
			
			<div style="width:309px; float:left;">
			<label class="width100">Special Category</label> <select
				id="otherCategoryId" name="<%=OTHER_CATEGORY%>" tabindex="1" validate="Special Category,metacharDot,no" multiple="multiple" class="multiple" >
				<option value="0">Select</option>
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
			</div>			
			
			<div style="width:625px; float:left;">
			<label class="width100">Scheme</label> <select name="patientScheme" validate="Scheme,metacharDot,no"
				id="patientSchemeId" tabindex="1">
				<option value="0">Select</option>
				<% if(schemeList!=null && schemeList.size()>0) {
					for(MasScheme scheme : schemeList){
					%>
				<option value="<%=scheme.getId()%>"><%=scheme.getSchemeName()%></option>
				<% } } %>
			</select>
			
			<label class="width100">Locality</label> 
			<input type="text" name="locality"  onblur="getLocalityId(this.value)" id="locality" tabindex="2" MAXLENGTH="128" validate="Locality,String,no"/>
			<!-- <div class="clear"></div> -->
			<label class="width100">Patient Address</label> <input type="text"
				id="address" onchange="" autofocus name="<%=address %>" value="" 
				tabindex="1" title="Address of the Patient"
				validate="Patient Address,String,no" MAXLENGTH="250"
				style="width: 304px; margin-right: 0;" />
				</div>
			 
			 <div class="clear"></div>
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
			 
			 <input type="hidden" name="permAddr" value="y" id="permAddr"
				tabindex="21" /> <input type="hidden" name="<%=CHANGED_BY%>"
				value="<%=userName%>" /> <input type="hidden"
				name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
				type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="paddingTop5"></div>

			<input name="Submit11" id="Submit11" class="buttonAuto"
				value="Submit"  tabindex="1"
				onclick="if(checkOpSession())if(checkForPediatricDepartment('reg')){submitForm('quickRegistration','/hms/hms/registration?method=submitPatientInformation&quickRegistration=yes')}"
				type="button" align="right"
				style="background: #c55a11; color: #fff;" /> <input type="reset" name="Reset" value="Reset"
				tabindex="" onclick="setFocus()"
				align="right" style="background: #c55a11; color: #fff;" />

			<div class="clear"></div>
			<div class="paddingTop5"></div>
		</form>
	</div>

	<!-- New Registration part end -->


	<!-- Revisit part start -->
	<div id="visit" style="display: none;">
		<form name="quickVisitSearch" method="post" action="">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
			<div class="titleBg">
				<h2>REVISIT</h2>
			</div>
			<div class="clear"></div>
			<div class="paddingTop5"></div>

			<label class="width100">Aadhar No</label> <input type="text"
				id="sAadhar" name="sAadhar" value="" tabindex="1" onchange="if(checkVisitSearchField()){submitForm('quickVisitSearch','/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&quickVisit=yes&visitSearch=serch')}"/> <label
				class="width100">UHID</label> <input type="text" name="<%=HIN_NO %>"
				maxlength="25" value="<%//=searchUhid %>"
				onkeypress="return searchKeyPress(event);" id="hinNo1" value="" onchange="if(checkVisitSearchField()){submitForm('quickVisitSearch','/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&quickVisit=yes&visitSearch=serch')}"
				tabindex="1" /> <label class="width100">Mobile Number</label> <input
				type="text" name="mobno" id="mobno" maxlength="10" onchange="if(checkVisitSearchField()){submitForm('quickVisitSearch','/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&quickVisit=yes&visitSearch=serch')}"
				value="<%//=searchmobno %>"
				onkeypress="return searchKeyPress(event);" tabindex="1"
				style="width: 104px;" /> <input tabindex="1" id="" name="search"
				value="Search" class="button"
				onclick="if(checkVisitSearchField()){submitForm('quickVisitSearch','/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&quickVisit=yes&visitSearch=serch')}"
				type="button">


			<div class="clear"></div>
			<div class="paddingTop5"></div>
			<div class="paddingTop5"></div>
			<%
List<Patient> searchVisitDataList=new ArrayList<Patient>();
String pname="";
String pgender="";
String patientage="";
String pstatus="";

int currentPageVisit=0;
int noOfPagesVisit=0;

String shinNo = "";
String sfullName ="";
String smobNo="";
String sdateOfBirth="";

String locality="";

String aadhar = "";


if(null !=map.get("currentPage")){
currentPageVisit=(Integer)map.get("currentPage");
shinNo=(String)map.get("shinNo");
sfullName=(String)map.get("sfullName");

smobNo=(String)map.get("smobNo");
noOfPagesVisit=(Integer)map.get("noOfPages");
sdateOfBirth=""+(Date)map.get("sdateOfBirth");
}
String visitSearch="";
if(null !=map.get("visitSearch")){
	visitSearch=(String)map.get("visitSearch");
}
	if(null !=map.get("searchDataList")){
		searchVisitDataList=(List<Patient>)map.get("searchDataList");
	
	if(null !=searchVisitDataList && searchVisitDataList.size()>0){ %>
			<table style="width: 922px; float: left;">
				<tr>
					<th>UHID</th>
					<th>Patient Name</th>
					<th>Age</th>
					<th>Gender</th>
					<th>Mobile</th>
					<th>Locality</th>
				</tr>
				<%

			
			
			for(Patient patient:searchVisitDataList){
			
			address=patient.getPatientAddress()!=null?patient.getPatientAddress():"";
			if(patient.getPFirstName()!=null)
			pname=patient.getPFirstName();
			if(null !=patient.getSex()){
			pgender=patient.getSex().getAdministrativeSexName();
			}
			if(null!=patient.getAge())
			patientage=String.valueOf(patient.getAge());
			pstatus=patient.getStatus()!=null?patient.getStatus():"N";
			String mobile  = patient.getMobileNumber()!=null?patient.getMobileNumber():"";

				aadhar = patient.getAadhaarNo()!=null?patient.getAadhaarNo().toString():"";
				
				if(map.get("locality")!=null){
					locality = (String)map.get("locality");
					 
				}
				
			%>
				<tr
					onclick="pVisitDetailsForShortScreen('<%=patient.getId()%>');HighLightTR(this)"
					style="cursor: pointer;">
					<td><%=patient.getHinNo()%></td>
					<td><%=pname%></td>
					<td><%=patientage%></td>
					<td><%=pgender%></td>
					<td><%=mobile %></td>
					<td><%=locality%></td>
				</tr>
				<%}
		}%>
			</table>
			<div class="clear"></div>
			<%
	if(currentPageVisit !=1){%>
			<a
				href='/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&page=<%=currentPageVisit-1%>&hinNo=<%=shinNo%>&moNo=<%=smobNo%>&aadhar=<%=aadhar%>&quickVisit=yes&visitSearch=serch'>Previous</a>

			<%}

if(noOfPagesVisit>=1){
%>


			<a
				href='/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&page=<%=currentPageVisit%>&hinNo=<%=shinNo%>&moNo=<%=smobNo%>&aadhar=<%=aadhar%>&quickVisit=yes&visitSearch=serch'><%=currentPageVisit%></a>
			<%

}
if(currentPageVisit <noOfPagesVisit){%>

			<a
				href='/hms/hms/registration?method=showSearchPatientRecordsForVisitJsp&page=<%=currentPageVisit+1%>&hinNo=<%=shinNo%>&moNo=<%=smobNo%>&aadhar=<%=aadhar%>&quickVisit=yes&visitSearch=serch'>Next</a>

			<%}%>
			<div class="Block">
				<!-- added by govind 10-11-2016 -->
				<input type="text" id="inPage" tabindex="2" maxlength="4"
					style="width: 30px;" /><input type="button" value="Go" tabindex="2"
					onclick="searchParticularPage(1);" /> <label> No of Pages :
					<%=noOfPagesVisit%></label>
				<!-- added by govind end-->
			</div>
			<%}
	
%>

		</form>
		<div class="clear"></div>
		<div class="paddingTop5"></div>
		<div class="clear"></div>
		<form name="quickVisit" method="post" action="">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}"> <input type="hidden" tabindex="2"
				id="vhinId" name="patientHinId" value="" /> <input type="hidden"
				tabindex="2" name="hinNO"  id="pUhidId" maxlength="20" value=""
				readonly="readonly" /> <label class="width100">Patient Name</label>
			<label class="value" id="vpnameId" style="width: -105px"></label> <label
				class="width100">Gender</label> <label class="value" id="vgenderId"
				style="width: 105px"></label> <label class="width100">Age</label> <label
				class="value" style="width: 105px" id="vageId"></label> <input
				type="hidden" tabindex="2" name="age" id="ageId" maxlength="3"
				value="" readonly="readonly" />
				<% 
				if(session.getAttribute("prevDoctorVisit")!=null){
					%>
					<input type="checkbox" class="checkboxMargin" name="prevDoctorVisit" value="y" id="prevDoctorVisit" checked="checked" onclick="changeDrValue(this,'quickVisit');">
				<%}else{
			%>
			<input type="checkbox" class="checkboxMargin" name="prevDoctorVisit" value="y" id="prevDoctorVisit" onclick="changeDrValue(this,'quickVisit');">
			<%} %>
			<label style="width:149px;">Visit for Last Doctor</label>
			<div class="clear"></div>

			<label class="width100">Monthly Income</label> <label class="value"
				id="income" style="width: 50px;"></label> <label class="width100">Locality</label>
			<label class="value" style="width: 215px" id="vlocality"></label> <label
				class="width100">Mobile Number</label> <label class="value"
				id="vmobileNoId" style="width: 105px"></label>

			<div class="clear"></div>

			<label class="width100">Department</label> <select id="vdeptId"
				name="<%=PATIENT_DEPARTMENT %>" tabindex="1"
				onchange="getSessionForDepartment(this.value,'vopsession'); populateUnitForDepartment(this.value,'quickunit','quickloddrs','vdeptId','quickVisit');"
				validate="Department,string,no">
				<option value="0">Select</option>
				<%
				for(MasDepartment masDepartment : departmentList)
		{%>
				<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
				<%}%>
			</select> <input type="hidden" tabindex="2" name="<%=VISIT_NUMBER %>"
				id="vVisitNoId" value="" readonly="readonly" /> <input
				type="hidden" validate="Visit Date,date,no" tabindex="2"
				name="<%=VISIT_DATE%>" value="<%=currentDate %>" readonly="readonly" />
			<input type="hidden" tabindex="2" name="<%=VISIT_TIME%>"
				value="<%=time %>" readonly="readonly" /> <label class="width100"
				style="margin-left: 0;">Session</label> <select id="vopsession"
				name="opsession" validate="Session,string,no" tabindex="1"
				style="width: 113px;">
				<option value="0">Select</option>

			</select> <input type="hidden" name="onlineRegStatus" value=""
				id="vonlineRegStatusID" /> <input type="hidden" id="vpriorityId"
				name="priorityName" value="3"> <input type="hidden"
				validate="Visit Date,date,no" tabindex="10" name="<%=VISIT_DATE%>"
				value="<%=currentDate %>" readonly="readonly" /> <label style="margin-left:0; width:79px;">Category</label> <label
				class="value" style="width: 105px" id="vcategoryId"></label>
			<div class="clear"></div>
		<div id="unitDetails" >
				<label class="width100">Unit</label> <select id="quickunit" name="unit" tabindex="10"
					validate="unit,metachar,no"
					onchange="populateDoctorForUnit(this.value,'quickVisit','vdeptId')">
					<option value="">Select</option>
				</select> <label class="width100">Doctors Incharge</label> <input type="text"
					name="<%=EMPLOYEE_ID %>" id="quickconsultingDocId" value=""
					readonly="readonly" validate="Doctors Incharge,metachar,no" /> 
			<label class="width100">
					Doctors</label> <select name="loddrs" id="quickloddrs" tabindex="10" title=""
					validate="loddrs,metachar,no" onchange="getAssignedPatientForDoctorSpecific(this.value)"
					>
					<option value="">select</option>
				</select>
				<input name="patientCount1" id="patientCount1" value="" readonly="readonly" style="text-align: center;font-size:15px;width:25px;margin-left:0;background:#5bc0de;"/>	
			</div>
				
			<input type="hidden" tabindex="2"
					id="lastVisitedDeptId" name="lastVisitedDeptId" value=""
					readonly="readonly" class="readOnly" /> 
					
					<input type="hidden" tabindex="2"
					id="lastVisitedDrId" name="lastVisitedDrId" value=""
					readonly="readonly" class="readOnly" />
					
					<input type="hidden" tabindex="2"
					id="lastVisitedUnitId" name="lastVisitedUnitId" value=""
					readonly="readonly" class="readOnly" />
					 
			<div class="clear"></div>
			<label class="width100">Special Category</label> <label class="value"
				id="vsplCategory" style="width: 105px"></label> <label
				class="width100">Scheme</label> <label class="value"
				style="width: 105px" id="vscheme"></label>


</select> <label>Cash Received</label> <input type="checkbox" tabindex="1"
			checked="checked" name="cashreceived" id="cashreceivedRV" value="y"
			onclick="cashNotReceivedRV()" style="margin: 0px 5px;" />
		<div id="cashNotReceivedRV" style="display: none;">
			<label>Reason</label> <select id="cashReasonRV" name="cashReason"
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
			<input name="Submit12" id="Submit12" class="buttonAuto"
				value="Submit" tabindex="1"
				onClick="if(checkField())if(checkForPediatricDepartment('visit')){submitForm('quickVisit','/hms/hms/registration?method=saveVisitInformation&quickRegistration=yes')}"
				type="button" align="right"
				style="background: #c55a11; color: #fff;" /> <input type="reset" name="Reset" value="Reset"
				align="right" style="background: #c55a11; color: #fff;" />
			
		</form>
	</div>
	<!-- Revisit part end -->


	<div class="clear"></div>
	<div class="paddingTop5"></div>


</div>

</body>
<style>
.cashDivRight {
	margin-right: 15px;
	width: 352px;
	float: right;
}

.width100 {
	width: 100px;
}
</style>

<script>
function displayScreen(type){
	if(type == 'registration'){
		document.getElementById('registration').style.display='block';
		document.getElementById('visit').style.display='none';
		document.getElementById('pNameId').focus();
		document.quickVisit.reset();
	}else if(type == 'visit'){
		document.getElementById('visit').style.display='block';
		document.getElementById('registration').style.display='none';
		document.getElementById('sAadhar').focus();
	}
	
	
}

   
   function setValue(id){
		document.getElementById('localityId').value=id
	}
   
   function setValueLoc(loc){
	   var index1 = loc.lastIndexOf("[");
		var index2 = loc.lastIndexOf("]");
		index1++;
		var id = loc.substring(index1, index2);
		document.getElementById('localityId').value=id
	}
   
   function checkSearchFiled(){
		var aadharNumber = document.getElementById('saadhaarNumberId').value;
		var name = document.getElementById('spNameId').value;
		var mobile = document.getElementById('smobileNo').value;
		var dob = document.getElementById('sbirthDayId').value;
		var ward = document.getElementById('swardId').value;
		var lsgName = document.getElementById('slsgNameId').value;
		var lsgType = document.getElementById('slsgTypeId').value;

		if (aadharNumber != '' || name != '' || mobile != '' || dob != ''
				|| ward != '' || lsgName > 0 || lsgType > 0) {

			return true;
		} else {
			alert("Please Enter At Least One More Parameter ");
			return false;
		}
	}
   

   function ekycFiledCheck(){
   	var aadhaarNumberId=document.getElementById('aadhaarNumberId').value;
   	if(aadhaarNumberId == ""){
   		alert('Enter aadhaar no.')
   		return false;
   	}
   	else{
   		document.getElementById('radioId2').value = "eKyc";
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
   
   function checkOpSession(){
		var serviceCentre=document.getElementsByName('patientDepartment')[0].value;
	
		var opSessionSize=document.getElementById('opsession').options.length;
		 if(serviceCentre!="0"){
			if(opSessionSize==0){
				alert("Session Not Available !");
				return false;
			}else{
				return true;
			}
		} 
		 return true;
	}
	function checkForPediatricDepartment(type){
		var age;
		var deptObj ; 
		if(type == 'reg' && document.getElementById('age')){
			age = document.getElementById('age').value;
		deptObj  = document.getElementById('deptId'); 
		}else if(document.getElementById('ageId')){
			var ageWithUnit = document.getElementById('ageId').value;
			age = ageWithUnit.substring(0,ageWithUnit.indexOf(" "));
			ageunit = ageWithUnit.substring(ageWithUnit.indexOf(" "));
			 deptObj  = document.getElementById('vdeptId'); 
		}
		
		var ageunit;
		if(type == 'reg' && document.getElementById('ageUnitId'))
			ageunit = document.getElementById('ageUnitId').value;
		/* else if(document.getElementById('vageUnitId'))
			ageunit = document.getElementById('vageUnitId').value; */
		
		 var selectedArray = new Array();
	    
	     
		    var i;
		    var count = 0;
		    for (i=0; i<deptObj.options.length; i++) { 
		        if (deptObj.options[i].selected) {
		            selectedArray[count] = deptObj.options[i].value;
		        	<%for(MasDepartment masDepartment :departmentList){%>
		        		if('<%=masDepartment.getId()%>' == selectedArray[count]){
		        			if(('<%=masDepartment.getDepartmentName().trim()%>' == 'PAEDIATRICS')) {
						if (parseInt(age) > 18 && ageunit.trim() == 'Years') {
							alert("More than 18 Years Patient is not allowed in Paediatric Department.");
							//deptObj.options[i].selected = false;
							return false;
						} else {
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

	function checkVisitSearchField() {
		var uhid = document.getElementById('hinNo1').value;
		var mobile = document.getElementById('mobno').value;
		var aadhar = document.getElementById('sAadhar').value;

		if (uhid != '' || aadhar != '' || mobile != '') {

			return true;
		} else {
			alert("Please Enter At Least One Parameter ");
			return false;
		}
	}

	function setIdType(aadhaar) {
		if (aadhaar != "") {
			document.getElementById('radioId').value = "aadhaar";
		} else {
			document.getElementById('radioId').value = "noId";

		}
	}

	function checkField() {
		var deptId = document.getElementById('vdeptId').value;
        var pUhidId=document.getElementById('pUhidId').value;
        if (pUhidId == "") {
			alert("No Patient Selected");
			return false;
		}
		if (deptId == "0") {
			alert("Select Department ");
			return false;
		}

		return true;

	}

	function ValidateMobNumber(mobileNoId) {

		var fld = document.getElementById(mobileNoId);

		if (fld.value == "") {
			alert("You didn't enter a phone number.");
			fld.value = "";
			fld.focus();
			return false;
		} else if (isNaN(fld.value)) {
			alert("The phone number contains illegal characters.");
			fld.value = "";
			fld.focus();
			return false;
		} else if (!(fld.value.length == 10)) {
			alert("The phone number is the wrong length. \nPlease enter 10 digit mobile no.");
			fld.value = "";
			fld.focus();
			return false;
		}

	}

	function monthlySalary(value) {

		var decimalOnly = /^\s*-?[1-9]\d*(\.\d{1,2})?\s*$/;

		if (value !== '') {
			if (decimalOnly.test(value)) {
				return true;
			} else {
				alert('Data input is invalid!');
				document.getElementById('monIncome').value = "";
				return false;
			}
		}

	}

	function getSessionForDepartment(deptId, sessionId) {
		if (deptId != "0") {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {

				if (xhttp.readyState == 4 && xhttp.status == 200) {
					var data = this.responseText;
					var dt = data.toString();
					var result = dt.slice(1, -1);
					var deptData = "";
					if (result != "") {
						deptData = result.split(",");
					}
					var select;
					if (document.getElementById(sessionId)) {
						document.getElementById(sessionId).options.length = 0;
						select = document.getElementById(sessionId);
					}

					for (var index = 0; index < deptData.length; index++) {
						var departmentData = deptData[index].split(":");
						var opt = document.createElement('option');
						opt.value = departmentData[0].trim();
						opt.innerHTML = departmentData[1].trim();
						select.appendChild(opt);

					}
				}
			};
			xhttp.open("GET",
					"/hms/hms/registration?method=getSessionForDepartment&deptId="
							+ deptId, true);
			xhttp.send();
		}

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
	   
	    document.getElementById("aadhaarNumberId").value=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('uid');
	    
	    if(document.getElementById("aadhaarNumberId").value!=null && document.getElementById("aadhaarNumberId").value!=""){
	    	document.getElementById("aadhaarAddrID").value="y";
	    }
	    
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
	     
	 
	   
	    var gender=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('gender');
	    if(gender=="MALE" || gender=="M" || gender=='m'){
	            document.getElementById("gender").value = 3;
	          //  document.getElementById("titleId").value = 1;
	    }else{
	            document.getElementById("gender").value = 2;
	           // document.getElementById("titleId").value = 2;
	    }
	 
	    document.getElementById("pHouseName").value=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('house');
	    document.getElementById("streetName").value=  xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('street');
	    document.getElementById("pincode").value=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('pc').toString();
	    
	    var addharDistrict=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('dist').toString()
	    var cityId = document.getElementById('cityId');
	 for (var i = 0; i < cityId.options.length; i++) {
	     if (cityId.options[i].text === addharDistrict.toUpperCase()) {
	     	cityId.selectedIndex = i;
	         break;
	     }
	 }
	    
			
	    document.getElementById('radioId').value = "aadhaar";
	    document.getElementById('radioId2').value = "qrScan";
	}
	    return null;
	}
	
	function trimName(i){
		i.value =	i.value.trim();
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
	
	function openOtpWindos(){
		 document.getElementById("VerifyID").value="Verified";
		  document.getElementById("VerifyID").disabled = true;
		 }

	
</script>
<script type="text/javascript">
			function checkForScheme(){
				var age = document.getElementById('age').value;
				var schemeId = document.getElementById('patientSchemeId').value;
				var obj = age.split(" ");
				var ageValue = obj[0];
				var ageunit = document.getElementById('ageUnitId').value;
				if(parseInt(age)<=18 && ageunit=='Years'){
					<%for(MasScheme masScheme :schemeList){%>
					if(('<%=masScheme.getSchemeName().trim()%>'=='Arogya Kiranam')){
					
						document.getElementById('patientSchemeId').value= '<%=masScheme.getId()%>';
					 }
					
    				
    				<%}%>
				
				}else{
					
					document.getElementById('patientSchemeId').value="0";
				}
				
			}
			
			
			
			</script>


<%
	if(request.getParameter("quickVisit")!=null){
%>
<script>
	document.getElementById('visitType').checked = true;
	document.getElementById('regType').checked = false;
	document.getElementById('visit').style.display = 'block';
	document.getElementById('registration').style.display = 'none';
	<%
	if(request.getParameter("hinId")!=null){
	%>
	pVisitDetailsForShortScreen('<%=request.getParameter("hinId")%>');
	<%}%>
</script>
<%}else{ %>
<script>
document.getElementById('visitType').checked=false;
document.getElementById('regType').checked=true;
document.getElementById('visit').style.display='none';
document.getElementById('registration').style.display='block';
</script>

<%} %>
