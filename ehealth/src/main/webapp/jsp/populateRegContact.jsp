<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMAIL_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.PHONE"%>
<%@ page import="static jkt.hms.util.RequestConstants.MOBILE"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATION_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.REMARKS"%>
<%@page import="jkt.hms.masters.business.MasReference"%>
<%@ page import="static jkt.hms.util.RequestConstants.OCCUPATION_ID"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMERGENCY_PHONE"%>
<%@ page import="static jkt.hms.util.RequestConstants.REFERENCE"%>
<%@ page import="static jkt.hms.util.RequestConstants.RELATIVE_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.EMERGENCY_ADDRESS"%>
<%@ page import="static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.NATIONALITY"%>
<%@page import="jkt.hms.masters.business.MasSetupParameterMaintaince"%>
<%@ page import="static jkt.hms.util.RequestConstants.STATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.POST_OFFICE"%>
<%@ page import="static jkt.hms.util.RequestConstants.DISTRICT"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_DISTRICT"%>
<%@ page import="static jkt.hms.util.RequestConstants.PINCODE"%>
<%@ page import="static jkt.hms.util.RequestConstants.BLOCK"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_FULL_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.P_AADHAAR_NUMBER"%>
<%@ page import="static jkt.hms.util.RequestConstants.DATE_OF_BIRTH"%>
<%@ page import="static jkt.hms.util.RequestConstants.CURRENT_DATE"%>
<%@ page import="static jkt.hms.util.RequestConstants.LSG_TYPE"%>
<%@ page import="static jkt.hms.util.RequestConstants.LSG_NAME"%>
<%@ page import="static jkt.hms.util.RequestConstants.WARD"%>
<%@ page import="static jkt.hms.util.RequestConstants.HOUSE_NO"%>
<%@page import="java.util.Properties"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.net.URL"%>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> countryList = new ArrayList<Object[]>();
	List<Object[]> stateList = new ArrayList<Object[]>();
	int stateId = 0;
	String blockStatus = "";
	String postOfficeStatus = "";
	int cityId = 0;
	List<Object[]> districtList = new ArrayList<Object[]>();
	List<MasBlock> blockList = new ArrayList<MasBlock>();
	int blockId = 0;
	List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
	List<MasVillage> villageList = new ArrayList<MasVillage>();
	List<MasState> nativePlaceList=new ArrayList<MasState>();
	List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
	List<Object[]> maritalStatusList = new ArrayList<Object[]>();
	List<MasReference> referenceList = new ArrayList<MasReference>();
	List<Object[]> relationList = new ArrayList<Object[]>();
	
	if(request.getAttribute("map") != null)
	{
		map=(Map<String, Object>)request.getAttribute("map");
	}
	
	if(map.get("countryList") != null)
	{
		countryList =(List<Object[]>)map.get("countryList");
	}
	
	if(map.get("stateList") != null)	
	{
		stateList = (List<Object[]>)map.get("stateList");
	}
	
	if(map.get("stateId") != null)	
	{
		stateId = (Integer) map.get("stateId");
	}
	
	if(map.get("blockStatus") != null)	
	{
		blockStatus = (String) map.get("blockStatus");
	}
	
	if(map.get("postOfficeStatus") != null)	
	{
		postOfficeStatus = (String) map.get("postOfficeStatus");
	}
	
	if(map.get("districtList") != null)
	{
		districtList =(List<Object[]>)map.get("districtList");
	}
	
	if(map.get("cityId") != null)	
	{
		cityId = (Integer) map.get("cityId");
	}
	
	if (map.get("blockList") != null) 
	{
		blockList = (List<MasBlock>) map.get("blockList");
	}
	
	if(map.get("blockId") != null)	
	{
		blockId = (Integer) map.get("blockId");
	}
	
	if(map.get("postCodeList") != null)
	{
		postCodeList= (List<MasPostCode>)map.get("postCodeList");
	}
	
	if(map.get("villageList") != null)
	{
		villageList= (List<MasVillage>)map.get("villageList");
	}
	
	if(map.get("nativePlaceList") != null)	
	{
		nativePlaceList = (List<MasState>)map.get("nativePlaceList");
	}
	
	if (map.get("occupationList") != null) 
	{
		occupationList = (List<MasOccupation>) map.get("occupationList");
	}
	
	if(map.get("maritalStatusList") != null)
	{
		maritalStatusList = (List<Object[]>)map.get("maritalStatusList");
	}
	
	if (map.get("referenceList") != null) 
	{
		referenceList = (List<MasReference>) map.get("referenceList");
	}
	
	if (map.get("relationList") != null) 
	{
		relationList = (List<Object[]>) map.get("relationList");
	}
	
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
	String indiaCode = properties.getProperty("indiaCode");
%>
	

<%
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");

%>
<div class="Block">
<form action="" name="search">
<label><span>*</span>Name</label> <input type="text"
                               id="pNameId" onchange="checkForPatientType();"
                               name="<%=P_FULL_NAME %>" value="" tabindex=""
                               title="Full Name of the Patient"
                               validate="Name,alphaspace,no" MAXLENGTH="15" />
  <label>UID</label>
                       <input type="text" id="pAadhaarNumberId" name="<%=P_AADHAAR_NUMBER%>"
                               value="" tabindex="" validate="Aadhaar No,int,no" MAXLENGTH="12" />    
  <label>DOB</label> <input type="text" id="dobId"
                               name="<%=DATE_OF_BIRTH %>" tabindex="" value="" class="date"
                               readonly="readonly" onchange="calculateAgeInAjax('registration');"
                               MAXLENGTH="30" />

                       <div id="dobcalId">
                               <img id="" src="/hms/jsp/images/cal.gif" width="16" height="16"
                                       border="0"
                                       onclick="setdate('<%=currentDate %>',document.registration.<%=DATE_OF_BIRTH%>,event)"
                                       validate="Pick a date" onblur="calculateAgeInAjax('registration');"
                                       onchange="calculateAgeInAjax('registration');" tabindex="" />
                       </div>

                       <input type="hidden" name="dobIdTemp" id="dobIdTemp" value="" />  
 <div class="clear"></div>  
 <div id="disableBlock" style="display: none">                                                                      
<label><span>*</span>Country</label> 
	<select name="<%= NATIONALITY %>" tabindex="20"	onChange="populateState(this.value,'registration')" id="countryId">
	<option value="0">Select</option>
	
<%
	for(Object[] cntMaster : countryList)
	{
		if(cntMaster[1].equals(indiaCode))
		{
%>
			<option value="<%=cntMaster[0] %>" selected="selected"><%=cntMaster[1]%></option>
<%	
		}
		else
		{ 
%>
			<option value="<%=cntMaster[0] %>"><%=cntMaster[1] %></option>
<%
		}
	}
%>

	</select>
</div>
	
<div id="disableBlock" style="display: none">  
	<label><span>*</span> State</label> 
	<select id="stateId" name="<%=STATE%>" tabindex="21" onChange="fillNokAddrOnState();populateDistrict(this.value,'registration')">
	<option value="0">Select</option>

<%
	String stateName="";
	for(Object[] masState : stateList)
	{
		if(Integer.parseInt(""+masState[0])==stateId)
		{
%>
			<option value="<%=masState[0] %>" selected="selected"><%=masState[1] %></option>
<%
		}
		else
		{ 
%>
			<option value="<%=masState[0] %>"><%=masState[1] %></option>
<%			
		}
	}
%>

	</select> 
</div>	

	<label> District</label> 
<%
	if(blockStatus.equalsIgnoreCase("n") & postOfficeStatus.equalsIgnoreCase("n"))
	{
%> 
		<select name="<%=DISTRICT%>" id="cityId" tabindex="22" onChange="if(fillNokAddr()){populateVillageFromDist(this.value)}">
<%
	}
	else if(!blockStatus.equalsIgnoreCase("n") & postOfficeStatus.equalsIgnoreCase("n"))
	{
%>
		<select name="<%=DISTRICT%>" id="cityId" tabindex="22" onChange="if(fillNokAddr()){populateBlock(this.value,'registration')}">
<%
	}
	else if(blockStatus.equalsIgnoreCase("n") & !postOfficeStatus.equalsIgnoreCase("n"))
	{
%>
		<select name="<%=DISTRICT%>" id="cityId" tabindex="22" onChange="if(fillNokAddr()){populateDistrictPostOffice(this.value,'registration')}">
<%
	}
	else
	{
%>
		<select name="<%=DISTRICT%>" id="cityId" tabindex="22" onChange="if(fillNokAddr()){populateBlock(this.value,'registration')}">
<%
	}
%>
		<option value="0">Select</option>
<%
		int districtId=0;
		String relativeAddress="";
		for(Object[] masDistrict : districtList)
		{
			if(masDistrict[0].equals(cityId))
			{
				districtId=Integer.parseInt(""+masDistrict[0]);
				relativeAddress=masDistrict[2]+" , "+stateName;
%>
				<option value="<%=masDistrict[0]%>" selected="selected"><%=masDistrict[2]%></option>
<%				
			}
			else
			{ 
%>
				<option value="<%=masDistrict[0]%>"><%=masDistrict[2] %></option>
<%
			}
		}
%>
	</select>
			
	<div id="disableBlock" style="display: none">
		<label><span>*</span>Block</label> 
<%
		if(postOfficeStatus.equalsIgnoreCase("n"))
		{
%> 
			<select name="<%=BLOCK%>" validate="Block,string,no" tabindex="23" id="blockId" onchange="populateVillageOfBlock(this.value);">
<%
		}
		else
		{
%>
			<select name="<%=BLOCK%>" validate="Block,string,no" tabindex="23" id="blockId" onchange="populatePostOff(this.value);">
			<option value="0">Select</option>
<%
		}

		for(MasBlock masBlock : blockList)
		{
			if(masBlock.getDistrict().getId().equals(cityId))
			{
				if(masBlock.getId() == blockId)
				{	
%>
					<option value="<%=masBlock.getId() %>" selected="selected"><%=masBlock.getBlockName() %></option>
<%
				}
				else
				{ 
%>
					<option value="<%=masBlock.getId() %>"><%=masBlock.getBlockName() %></option>
<%				}
			}
		}
%>
		</select>
		
	</div>
	
	<div id="disablePostOffice" style="display: none">
	<label><span>*</span>Post Office</label>
<%
	if(postOfficeStatus.equalsIgnoreCase("n"))
	{
%>
		<select name="<%=POST_OFFICE %>" id="postOff" onchange="populateVillage(this.value);" validate="Post Office,string,no" tabindex="24">
<%
	}
	else
	{ 
%>
		<select name="<%=POST_OFFICE %>" id="postOff" onchange="populateVillage(this.value);" validate="Post Office,string,no" tabindex="24">
<%
	} 
%>
		<option value="0">Select</option>

<%
		for(MasPostCode postCode: postCodeList)
		{
			if(postCode.getBlock().getId() == blockId)
			{
%>
				<option value="<%=postCode.getId()%>"><%=postCode.getPostCodeName()%></option>
<%
			}
		}
%>
		</select>
	</div>

<%
	if(!blockStatus.equalsIgnoreCase("Y"))
	{
%>
		
<%
	}
%>

	<label>LSG Type </label>
	<select name="<%=LSG_TYPE %>" id="lsgTypeId" tabindex="" validate="LSG Type,string,no">
	<option value="0">Select</option>
	</select>
	<label>LSG Name </label>
	<select name="<%=LSG_NAME %>" id="lsgNameId" tabindex="" validate="LSG Name,string,no">
	<option value="0">Select</option>
	</select>
	<div class="clear"></div>
	<label>Ward</label>
	<input type="text" name="<%=WARD %>" value="" validate="ward,int,no" maxlength="8" tabindex="" id="wardId" onblur="" />
	<label>House No.</label>
	<input type="text" name="<%=HOUSE_NO %>" value="" validate="House No.,int,no" maxlength="8" tabindex="" id="houseId" onblur="" />
	<label>Mobile</label>
	<input type="text" name="<%=MOBILE %>" id="mobileNo" value="" validate="Mobile Number,phone,no" MAXLENGTH="20" tabindex="29" onblur="copyMobileNo(this.value);" />
	<div class="clear"></div>
	<input type="button" name="Search" value="Search" class="button"
	onClick="submitForm('search','/hms/hms/registration?method=showSearchPatientRecordsJsp')" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="submitProtoAjax('search','registration?method=getPatientName')"
	accesskey="r" />
	<div class="clear"></div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
	<table>
	<thead>
	<tr>
	<td>UHID</td>
	<td>Name</td>
	<td>Gender</td>
	<td>Age</td>
	<td>Address</td>
	<td>UHID Print Status</td>
	</tr>
	</thead>
	<tr>
<% 	List<Patient> searchDataList=new ArrayList<Patient>();
/* Map<String, Object> getDataMap = new HashMap<String, Object>(); */
searchDataList=(List<Patient>)map.get(searchDataList);

	if(null !=searchDataList && searchDataList.size()>0){
		for(Patient patient:searchDataList){
			%>	
	<td><%=patient.getAadhaarNo()%></td>
	<td><%=patient.getFullName()%></td>
	<td><%=patient.getSex().getAdministrativeSexName()%></td>
	<td><%=patient.getAge()%></td>
	<td><%=patient.getNativePlace()%></td>
	<td><%=patient.getStatus()%></td>
	
<%
}
}
%>	
</tr>
	</table>
	

	
	
	<%-- <div id="disableBlock" style="display: none"> 		
	<label> Village</label>
	<select name="<%=PATIENT_DISTRICT %>" id="patientDistId" tabindex="25" validate="Village,string,no">
	<option value="0">Select</option>
<%
	if(villageList.size()>0)
	{
		for(MasVillage masVillage:villageList)
		{
			if(masVillage.getPostCode().getBlock().getDistrict()!=null)
			{
				if(masVillage.getPostCode().getBlock().getDistrict().getId().equals(districtId))
				{
%>
					<option value="<%=masVillage.getId()%>"><%=masVillage.getVillageName()%></option>
<%
				}
			}
		}
	}
%>
	</select>
</div>
<div id="disableBlock" style="display: none">  	
	<label>Pincode</label>
	<input type="text" name="<%=PINCODE %>" value="" validate="Pincode,int,no" maxlength="8" tabindex="26" id="pinCodeId" onblur="fillNokAddr();" />

	<div class="clear"></div>
	<div class="clear"></div>

	<label><span>* </span>Native Place</label>
	<select name="nativePlace" id="nativePlaceId" validate="Native Place,string,yes" tabindex="27">
	<option value="0">Select</option>
<%
	for(MasState nativePlace: nativePlaceList)
	{ 
%>
		<option value="<%=nativePlace.getId() %>"><%=nativePlace.getStateName() %></option>
<%
	} 
%>
	</select> 
</div>	
<div id="disableBlock" style="display: none">  
	<label>Phone</label>
	<input type="text" name="<%=PHONE %>" value="" validate="Phone,phone,no" MAXLENGTH="20" tabindex="28" id="phoneNo" />
</div>
	

	<div class="clear"></div>
	<div id="disableBlock" style="display: none">
	<label>Email Id</label>
	<input type="text" name="<%=EMAIL_ID %>" value="" validate="Email Id,email,no" MAXLENGTH="40" tabindex="30" />
    </div>
    
    <div id="disableBlock" style="display: none">
	<label>Occupation</label>

	<select name="<%=OCCUPATION_ID %>" validate="Occupation,string,no" tabindex="31">
	<option value="0">Select</option>
<%
	for(MasOccupation masOccupation : occupationList)
	{
%>
		<option value="<%=masOccupation.getId()%>"><%=masOccupation.getOccupationName()%></option>
<%
	}
%>
	</select>
</div>
<div id="disableBlock" style="display: none">
	<label>Marital Status</label>
	<select name="<%=MARITAL_STATUS_ID %>"	validate="Marital Status,string,no" tabindex="32">
	<option value="0">Select</option>
<%
	for(Object[] masMaritalStatus : maritalStatusList)
	{
%>
		<option value="<%=masMaritalStatus[0]%>"><%=masMaritalStatus[1]%></option>
<%
	}
%>
	</select>
	
	<div class="clear"></div>
</div>
<div id="disableBlock" style="display: none">
	<label>Reference</label>
	<select name="<%=REFERENCE %>" validate="Reference,string,no" tabindex="33">
	<option value="0">Select</option>
<%
	for(MasReference masReference : referenceList)
	{
%>
		<option value="<%=masReference.getId()%>"><%=masReference.getReferenceName()%></option>
<%
	} 
%>
	</select>
</div>
<div id="disableBlock" style="display: none">
	<label><span>*</span> Relative Name</label>

	<input id="nokNameId" type="text" name="<%=RELATIVE_NAME %>" value="" validate="Relative Name,string,yes" maxlength="30" tabindex="34" />
	<input type="hidden" name="relativeNameTemp" id="relativeNameTemp" value="" />

	<div class="clear"></div>
</div>
	<div id="disableBlock" style="display: none">
	<label><span>*</span> Relation</label>
	<select name="<%=RELATION_ID%>" id="relId" validate=" Relation,string,yes" tabindex="35">
	<option value="0">Select</option>
<%
	for(Object[] masRelation : relationList)
	{
%>
		<option value="<%=masRelation[0]%>"><%=masRelation[1]%></option>
<%
	} 
%>
	</select>
</div>
<div id="disableBlock" style="display: none">
	<label>Relative Address</label>
	<textarea name="<%=EMERGENCY_ADDRESS %>" id="nokAddr" class="txtarea" oninput="return checkMaxLengthMoz(this)" 
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" tabindex="36"><%=relativeAddress%></textarea>
</div>
<div id="disableBlock" style="display: none">
	<label>Relative Phone</label>
	<input type="text" name="<%=EMERGENCY_PHONE %>" value="" id="nokMobileNo" maxlength="16" tabindex="37" />

	<div class="clear"></div>
</div>
<div id="disableBlock" style="display: none">
	<label>Remarks</label>
	<textarea name="<%=REMARKS %>" cols="160" rows="2" validate="Remarks,string,no" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" tabindex="38" class="large"></textarea>
	
	<!-- Patient details  section Ends-->
	<div class="clear"></div>
	
</div>	 --%>
<Script>
	document.getElementById("loadcIndicator").style.display="none";
	document.getElementById("loadCBlock").style.display="";
	document.getElementById("loadC").setAttribute("onfocus","");
	document.getElementById("loadC").removeAttribute("tabindex");
	document.getElementById("loadC").style.cursor="default";

	var blockStatus="Y";
	var postOfficeStatus="Y";
	
	if(blockStatus=='<%=blockStatus%>' && postOfficeStatus=='<%=postOfficeStatus%>')
	{
		document.getElementById('disableBlock').style.display ='inline';
		document.getElementById('disablePostOffice').style.display ='inline';
	}
	else if(blockStatus=='<%=blockStatus%>' && postOfficeStatus!='<%=postOfficeStatus%>')
	{
		document.getElementById('disableBlock').style.display ='inline';
		document.getElementById('disablePostOffice').style.display ='none';
	}
	else if(blockStatus!='<%=blockStatus%>' && postOfficeStatus=='<%=postOfficeStatus%>')
	{
		document.getElementById('disableBlock').style.display ='none';
		document.getElementById('disablePostOffice').style.display ='inline';
	}
	else
	{
		document.getElementById('disableBlock').style.display ='none';
		document.getElementById('disablePostOffice').style.display ='none';
	}
	document.getElementById("countryId").focus();
</Script>