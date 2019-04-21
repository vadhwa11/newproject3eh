<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasSetupParameterMaintaince"%>
<%@page import="jkt.hms.masters.business.MasLanguage"%>
<%@page import="jkt.hms.masters.business.MasReference"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<%@page import="jkt.hms.masters.business.MasCaste"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
List<MasRelation> relationList = new ArrayList<MasRelation>();
List<MasReligion> religionList = new ArrayList<MasReligion>();
List<MasCountry> countryList = new ArrayList<MasCountry>();
List<MasState> stateList = new ArrayList<MasState>();
List<MasDistrict> districtList = new ArrayList<MasDistrict>();
List<MasBlock> blockList = new ArrayList<MasBlock>();
List<MasReference> referenceList = new ArrayList<MasReference>();
List<MasCaste> casteList = new ArrayList<MasCaste>();
List<MasLanguage> langList= new ArrayList<MasLanguage>();
List<MasChargeCode> regChargeList =new ArrayList<MasChargeCode>();
List<MasChargeCode> visitChargeList =new ArrayList<MasChargeCode>();
List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
List<MasSetupParameterMaintaince> setupParamList = new ArrayList<MasSetupParameterMaintaince>();
String message="";//= new String("  !! You Can Upload New Image");//(String)map.get("message");
String uploadedFileName;
if(map.get("message")!= null){
	message= (String)map.get("message");
}

if(map.get("relationList") != null){
	relationList= (List<MasRelation>)map.get("relationList");
}
if(map.get("religionList") != null){
	religionList= (List<MasReligion>)map.get("religionList");
}
if(map.get("countryList") != null){
	countryList= (List<MasCountry>)map.get("countryList");
}
if(map.get("stateList") != null){
	stateList= (List<MasState>)map.get("stateList");
}
if(map.get("districtList") != null){
	districtList= (List<MasDistrict>)map.get("districtList");
}
if(map.get("blockList") != null){
	blockList= (List<MasBlock>)map.get("blockList");
}
if(map.get("langList") != null){
	langList= (List<MasLanguage>)map.get("langList");
}
if(map.get("referenceList") != null){
	referenceList= (List<MasReference>)map.get("referenceList");
}
if(map.get("casteList") != null){
	casteList= (List<MasCaste>)map.get("casteList");
}
if(map.get("regChargeList") != null){
	regChargeList= (List<MasChargeCode>)map.get("regChargeList");
}
if(map.get("visitChargeList") != null){
	visitChargeList= (List<MasChargeCode>)map.get("visitChargeList");
}
if(map.get("setupParamList") != null){
	setupParamList=(List<MasSetupParameterMaintaince>)map.get("setupParamList");
}
if(map.get("employeeList")!=null){
	employeeList=(List<MasEmployee>)map.get("employeeList");
}

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
if(map.get("setupParamList") != null){
	String imgName=setupParamList.get(0).getLoginImgName();
	byte[] image=(byte[])setupParamList.get(0).getLoginImage();
	session.setAttribute("image",image);
	session.setAttribute("imgName",imgName);
}

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String time = (String)utilMap.get("currentTime");

%>


<form method="post"
	action="/hms/eha/sysParam?method=showSubmitModifiedParamJsp"><!--Main Div starts here-->
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>System Parameter</h2>
</div>
<div class="Block">
<div class="paddLeft25"><label>Version</label> <%
	if(setupParamList.get(0).getVersion().equals("T"))
	{
%> <input name="<%=VERSION%>" type="radio" class="inputRadiobutton"
	checked="checked" value="T" /> <label class="small">Trial</label> <input
	name="<%=VERSION%>" type="radio" class="inputRadiobutton" value="F" /> <label
	class="small">Full</label> <%}
	else
		{%> <input name="<%=VERSION%>" type="radio" class="radioCheck"
	value="T" /> <label class="small">Trial</label> <input
	name="<%=VERSION%>" type="radio" class="radioCheck" checked="checked"
	value="F" /> <label class="small">Full</label> <%} %>
	<label>Server Port No.</label> <input
	name="<%=SERVER_PORT_NUMBER%>" type="text" class="dateTextSmall"
	value="<%=setupParamList.get(0).getServerPortNumber()%>" />
<div class="clear"></div>
<br />
</div>
<div class="division"></div>
<div class="clear"></div>

<label>License Control Code</label> <input name="<%=LICENSE_CODE%>"
	type="text" class=""
	value="<%=setupParamList.get(0).getLicenseCode()%>" /> <label
	class="auto">Refresh Time</label> <input name="<%=REFRESH_TIME%>"
	type="text" class="dateTextSmall"
	value="<%=setupParamList.get(0).getRefreshTime() %>" /> <label
	class="auto">Language Id</label> <select name="<%=LANGUAGE%>">
	<option value="">Select</option>

	<%
			 	for (MasLanguage masLang : langList) 
				{
			if((masLang.getId()).equals(setupParamList.get(0).getLanguage().getId()))
			 		{
			 			
			%>

	<option value="<%=masLang.getId()%>" selected="selected"><%=masLang.getLanguageDescription()%></option>

	<%}
			else{
				%>
	<option value="<%=masLang.getId()%>"><%=masLang.getLanguageDescription()%></option>
	<%}}%>
</select>
<div class="clear"></div>

<label>Login Image</label> <input name="<%=LOGIN_IMAGE%>" type="file"
	class="browse" id="fileId" onchange="displayImage()" /> <input
	type="hidden" id="photoUrlId" name="photoUrl" value="" /> <script
	type="text/javascript" language="javascript">
function displayImage()
{
	
	var url = document.getElementById('fileId').value;
	
	document.getElementById('lblUrl').value=url;
	document.getElementById('photoUrlId').value =url;
}
</script> <%if(setupParamList.get(0).getLoginImage()!=null) {%> <input name=""
	id="lblUrl" type="text" class="large"
	value="<%="Current Image is:  "+setupParamList.get(0).getLoginImgName()%>" />
<%}else %> <input name="" id="lblUrl" type="text" class="large" value="" />
<div class="clear"></div>
<label>Menu Image</label> <input name="DA" type="file" class="browse" />
<input name="" type="text" class="large" />
<div class="clear"></div>
</div>

<div class="Block"><label>Registration Charge</label> <select
	name="<%=REG_CHARGE_CODE %>">
	<option value="0">Select</option>
	<%
			 	for (MasChargeCode masCharge : regChargeList) 
				{
			if(setupParamList.get(0).getRegChargeCode()!=null)
			 		{
			 			if(masCharge.getId().equals(setupParamList.get(0).getRegChargeCode().getId())){
			%>
	<option value="<%=masCharge.getId()%>" selected="selected"><%=masCharge.getChargeCodeName()%></option>
	<%}
			else{
			
			%>
	<option value="<%=masCharge.getId()%>"><%=masCharge.getChargeCodeName()%></option>
	<%}
			}	else{
				
				%>
	<option value="<%=masCharge.getId()%>"><%=masCharge.getChargeCodeName()%></option>
	<% }}%>
</select> <label>Visit Charge</label> <select name="<%=VISIT_CHARGE_CODE%>">
	<option value="0">Select</option>
	<%
			 	for (MasChargeCode masCharge : visitChargeList) 
				{
			 		if(setupParamList.get(0).getVisitChargeCode()!=null){
			if((masCharge.getId()).equals(setupParamList.get(0).getVisitChargeCode().getId()))
			 		{
			 			
			%>
	<option value="<%=masCharge.getId()%>" selected="selected"><%=masCharge.getChargeCodeName()%></option>
	<%}
			else{
			%>
	<option value="<%=masCharge.getId()%>"><%=masCharge.getChargeCodeName()%></option>
	<%}}
			else{
				%>
	<option value="<%=masCharge.getId()%>"><%=masCharge.getChargeCodeName()%></option>
	<%}
			}%>
</select> <label>Reference</label> <select name="<%=REFERENCE %>">
	<option value="0">Select</option>
	<%
			 	for (MasReference masReference : referenceList) 
				{
			 	if(setupParamList.get(0).getReference() != null){
			if((masReference.getId()).equals(setupParamList.get(0).getReference().getId()))
				
		 		{
					
		 		%>
	<option value="<%=masReference.getId()%>" selected="selected"><%=masReference.getReferenceName()%></option>
	<%}else{%>
	<option value="<%=masReference.getId()%>"><%=masReference.getReferenceName()%></option>

	<%}
			}
			else{
				
			%>
	<option value="<%=masReference.getId()%>"><%=masReference.getReferenceName()%></option>
	<%}}%>
</select>
<div class="clear"></div>
<label>Block</label> <select name="<%=BLOCK%>">
	<option value="0">Select</option>
	<%
			 	for (MasBlock masBlock : blockList) 
				{
			 		if(setupParamList.get(0).getBlock() != null){
			 		if((masBlock.getId()).equals(setupParamList.get(0).getBlock().getId()))
			 		{
			%>
	<option value="<%=masBlock.getId()%>" selected="selected"><%=masBlock.getBlockName()%></option>
	<%}
			else{
			%>
	<option value="<%=masBlock.getId()%>"><%=masBlock.getBlockName()%></option>
	<%}
			 		}
					else{
						%>
	<option value="<%=masBlock.getId()%>"><%=masBlock.getBlockName()%></option>
	<%}
			 		
			 		}%>

</select> <label>State</label> <select name="<%=STATE %>">
	<option value="0">Select</option>
	<%
			 	for (MasState masState : stateList) 
				{
			 		if(setupParamList.get(0).getState() != null){
			 	if((masState.getId()).equals(setupParamList.get(0).getState().getId()))
				
		 		{%>
	<option value="<%=masState.getId()%>" selected="selected"><%=masState.getStateName()%></option>
	<%}
			else{
			%>
	<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
	<%}
			 		}
					else{
					%>
	<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
	<%}
			 		}%>

</select> <label>Country</label> <select name="<%=COUNTRY%>">
	<option value="0">Select</option>
	<%
			 	for (MasCountry masCountry : countryList) 
				{
			 		if(setupParamList.get(0).getCountry() != null){
				if((masCountry.getId()).equals(setupParamList.get(0).getCountry().getId()))
				
		 		{%>
	<option value="<%=masCountry.getId()%>" selected="selected"><%=masCountry.getCountryName()%></option>
	<%}
			else{
			%>

	<option value="<%=masCountry.getId()%>"><%=masCountry.getCountryName()%></option>
	<%}
			 		}
					else{
					%>

	<option value="<%=masCountry.getId()%>"><%=masCountry.getCountryName()%></option>
	<%}
			 		}%>
</select>


<div class="clear"></div>

<label>Caste</label> <select name="<%=CASTE %>">
	<option value="0">Select</option>
	<%
			 	for (MasCaste masCaste : casteList) 
				{
			 	if(setupParamList.get(0).getCaste() != null){
				if((masCaste.getId()).equals(setupParamList.get(0).getCaste().getId()))
				
		 		{
					
		 		%>
	<option value="<%=masCaste.getId()%>" selected="selected"><%=masCaste.getCasteName()%></option>
	<%}
			else{
				
			%>
	<option value="<%=masCaste.getId()%>"><%=masCaste.getCasteName()%></option>
	<%}
			 	}
				else{
					
				%>
	<option value="<%=masCaste.getId()%>"><%=masCaste.getCasteName()%></option>
	<%}
			 	}%>

</select> <label>Religion</label> <select name="<%=RELIGION %>">
	<option value="0">Select</option>
	<%
			 	for (MasReligion masReligion : religionList) 
				{
			 if(setupParamList.get(0).getReligion() != null){
			if((masReligion.getId()).equals(setupParamList.get(0).getReligion().getId()))
				
		 		{
					
		 		%>
	<option value="<%=masReligion.getId()%>" selected="selected"><%=masReligion.getReligionName()%></option>
	<%}
			else{
				
			%>
	<option value="<%=masReligion.getId()%>"><%=masReligion.getReligionName()%></option>
	<%}
			 }
				else{
					
				%>
	<option value="<%=masReligion.getId()%>"><%=masReligion.getReligionName()%></option>
	<%}}%>

</select> <label>Relation</label> <select name="<%=RELATION %>">
	<option value="0">Select</option>
	<%
			 	for (MasRelation masRelation : relationList) 
				{
			 		if(setupParamList.get(0).getRelation() != null){
			if((masRelation.getId()).equals(setupParamList.get(0).getRelation().getId()))
				
		 		{
					
		 		%>
	<option value="<%=masRelation.getId()%>" selected="selected"><%=masRelation.getRelationName()%></option>
	<%}
			else{
				
			%>
	<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
	<%}
			 		}
					else{
						
					%>
	<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
	<%}}%>
</select>

<div class="clear"></div>



<div class="clear"></div>
</div>
<div class="Block"><label>Min Age <span>*</span></label> <% int minAge = 0;
	if(setupParamList.get(0).getMinAge() != null){
		minAge = setupParamList.get(0).getMinAge();
	}

%> <input name="<%=MIN_AGE %>" type="text" class="dateTextSmall"
	value="<%=minAge%>" /> <label>Max Age</label> <% int maxAge = 0;
	if(setupParamList.get(0).getMaxAge() != null){
		maxAge = setupParamList.get(0).getMaxAge();
	}

%> <input name="<%=MAX_AGE %>" type="text" class="dateTextSmall"
	value="<%=maxAge%>" /> <label class="auto" style="padding:0px 12px 0px 5px;">Min no. of days
between donation by donor</label> <% int bldDonGap = 0;
	if(setupParamList.get(0).getBloodDonGap() != null){
		bldDonGap = setupParamList.get(0).getBloodDonGap();
	}

%> <input name="<%=BLOOD_DON_GAP %>" type="text" class="dateTextSmall"
	value="<%=bldDonGap%>" size="2" />
<div class="clear"></div>
</div>
<div class="Block"><label>Month of ROL &amp; ROQ</label> <% int rol =0;
	if(setupParamList.get(0).getMonthOfRol() != null){
		rol = setupParamList.get(0).getMonthOfRol();
	}

%> <input name="<%=MONTH_OF_ROL %>" type="text" value="<%=rol%>" /> <label>ROQ
division Factor</label> <% int roqDivFact = 0;
	if(setupParamList.get(0).getRoqDivisionFactor() != null){
		roqDivFact = setupParamList.get(0).getRoqDivisionFactor();
	}

%> <input name="<%=ROQ_DIVISION_FACTOR %>" type="text"
	value="<%=roqDivFact%>" /> <label>ROL division Factor</label> <% int rolDivFact = 0;
	if(setupParamList.get(0).getRolDivisionFactor() != null){
		rolDivFact = setupParamList.get(0).getRolDivisionFactor();
	}

%> <input name="<%=ROL_DIVISION_FACTOR %>" type="text" class="dateTextSmall"
	value="<%=rolDivFact%>" />
<div class="clear"></div>
<label class="auto" style="padding:0px 12px 0px 5px;">Singnatory Authority For PO</label> <select
	name="poAuthoritySignatory">
	<option value="0">Select</option>
	<%String firstName="";
String middleName="";
String lastName="";
String name="";
String empCategoryName="";
for(MasEmployee masEmployee1: employeeList){
	if(masEmployee1.getFirstName()!=null){
		firstName=masEmployee1.getFirstName();
		
	}
	if(masEmployee1.getMiddleName()!=null){
		middleName=masEmployee1.getMiddleName();
	}
	if(masEmployee1.getLastName()!=null){
		lastName=masEmployee1.getLastName();
	}
	if(masEmployee1.getEmpCategory()!=null){
		empCategoryName	=masEmployee1.getEmpCategory().getEmpCategoryName();
	}
	name=firstName+" "+middleName+" "+lastName;
	
	if(setupParamList.get(0).getPoSignatoryOfficer()!=null){
		if((setupParamList.get(0).getPoSignatoryOfficer().trim()).equals((name+"["+empCategoryName+"]"))){%>
	<option value="<%=setupParamList.get(0).getPoSignatoryOfficer()%> "
		selected="selected"><%= setupParamList.get(0).getPoSignatoryOfficer()%></option>
	<%}} %>
	<option value="<%=name +"["+empCategoryName+"]"%> "><%=name%>[<%=empCategoryName%>]</option>
	<% }%>
</select> <label>Fast Moving Percentage</label> <%if(setupParamList.get(0).getFastMovingPercent()!=null){ %>
<input type="text" name="fast"
	value="<%=setupParamList.get(0).getFastMovingPercent() %>"
	validate="fast moving,num,yes"> <%}else{ %> <input type="text"
	name="fast" value="" validate="fast moving,num,yes"> <%} %>
<div class="clear"></div>
<label>Slow Moving Percentage</label> <%if(setupParamList.get(0).getSlowMovingPercent()!=null){ %>
<input type="text" name="slow"
	value="<%=setupParamList.get(0).getSlowMovingPercent() %>"
	validate="slow moving,num,yes"> <%}else{ %> <input type="text"
	name="slow" value="" validate="slow moving,num,yes"> <%} %> <label>Non
Moving Percentage</label> <%if(setupParamList.get(0).getNonMovingPercent()!=null){ %>
<input type="text" name="non"
	value="<%=setupParamList.get(0).getNonMovingPercent() %>"
	validate="non moving,num,yes"> <%}else{ %> <input type="text"
	name="non" value="" validate="non moving,num,yes"> <%} %>
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="save" type="submit" class="button" value="Submit" /> <!--<input name="save" type="button" class="button" value="Cancel" />
<input name="save" type="button" class="button" value="help" />

-->
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<div class="clear"></div>
<div class="paddingTop40"></div>




<!--Main Div ends here-->


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>

