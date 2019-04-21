<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is ajax response jsp for Service person name.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Patient> list = new ArrayList<Patient>();
	List<MasTrade> tradeList = new ArrayList<MasTrade>();
	List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	int serviceTypeId = 0;
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("list") != null){
		list = (List<Patient>)map.get("list");
	}
	if(map.get("rankList") != null){
		rankList= (List<MasRank>)map.get("rankList");
	}
	if(map.get("unitList") != null){
		unitList= (List<MasUnit>)map.get("unitList");
	}
	if(map.get("tradeList") != null){
		tradeList = (List<MasTrade>)map.get("tradeList");
	}
	if(map.get("recordOfficeAddressList") != null){
		recordOfficeAddressList = (List<MasRecordOfficeAddress>)map.get("recordOfficeAddressList");
	}
	
	if(map.get("serviceTypeId") != null){
		serviceTypeId = (Integer)map.get("serviceTypeId");
		
	}
	
	String servPersonFName = "";
	String servPersonMName = "";
	String servPersonLName = "";
	
	if(list.size() > 0){
		Patient patient = new Patient();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			patient = (Patient) iterator.next();
			
	}
			
	servPersonFName = patient.getSFirstName();
	if(patient.getSMiddleName() != null)
		servPersonMName = patient.getSMiddleName();
	if(patient.getSLastName() != null)
		servPersonLName = patient.getSLastName();
			
%> <label class="bodytextReg"><font id="error">*</font>F Name:</label> <input
	id="sFNameId" type="text" name="<%=S_FIRST_NAME %>"
	value="<%=servPersonFName %>" title="First Name of Service Person"
	class="readOnly" style="border: 1px solid #7f9db7; width: 130px;"
	MAXLENGTH="15" readonly="readonly" /> <label class="bodytextReg">Middle
Name:</label> <input id="sMNameId" type="text" name="<%=S_MIDDLE_NAME%>"
	value="<%=servPersonMName %>" class="readOnly"
	style="border: 1px solid #7f9db7; width: 130px;"
	validate="Middle Name of Service Person,name,no" MAXLENGTH="15"
	readonly="readonly" /> <label class="bodytextReg">Last Name:</label> <input
	id="sLNameId" type="text" name="<%=S_LAST_NAME %>"
	value="<%=servPersonLName %>" class="readOnly"
	style="border: 1px solid #7f9db7; width: 130px;"
	validate="Last Name of Service Person,name,no" MAXLENGTH="15"
	readonly="readonly" /> <br />

<div id="rankDivId"><label class="bodytextReg"><font
	id="error">*</font>Rank:</label> <span class="wardspan"><%= patient.getRank().getRankName()%></span>
<input type="hidden" name="<%=RANK_ID %>"
	value="<%=patient.getRank().getId() %>"> <label
	class="bodytextReg"> Trade:</label> <%
			if(patient.getTrade() != null){
		%> <span class="wardspan"><%= patient.getTrade().getTradeName()%></span>
<input type="hidden" name="<%=TRADE_ID %>"
	value="<%=patient.getTrade().getId() %>"> <%
			}else{
		%> <select id="tradeId" name="<%=TRADE_ID%>"
	validate="Trade,string,no" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<%
			 	for (MasTrade masTrade : tradeList) 
				{
			 	
			%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%
			}%>
</select> <%} %> <label class="bodytextReg"> RcrdOff Add:</label> <%
			if(patient.getRecordOfficeAddress() != null){
		%> <span class="wardspan"><%= patient.getRecordOfficeAddress().getAddress()%></span>
<input type="hidden" name="<%=RECORD_OFFICE_ADDRESS_ID %>"
	value="<%=patient.getRecordOfficeAddress().getId() %>"> <%
			}else{
		%> <select id="recordOffId" name="<%=RECORD_OFFICE_ADDRESS_ID %>"
	validate="RecordOff Addrs,string,no" class="select_adt" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRecordOfficeAddress recordOfficeAddress : recordOfficeAddressList) 
				{
			 		if(patient.getServiceType().getId().equals(recordOfficeAddress.getServiceType().getId())){
			%>
	<option value="<%=recordOfficeAddress.getId()%>"><%=recordOfficeAddress.getAddress()%></option>
	<%}
			}%>
</select> <%} %> <label class="bodytextReg">Formation:</label> <%
		if(patient.getFormation() != null && !(patient.getFormation().equals(""))){
		%> <span class="wardspan"><%= patient.getFormation()%></span> <input
	type="hidden" name="<%=FORMATION_ID %>"
	value="<%=patient.getFormation() %>"> <%}else{ %> <input
	id="formation" type="text" name="<%=FORMATION_ID %>"
	class="textbox_size20" style="border: 1px solid #7f9db7; width: 130px;"
	value="" validate="Formation,alphaspace,no" maxlength="30" tabindex="1">
<%} %> <br />
<label class="bodytextReg">Total Service:</label> <%
		if(patient.getServiceYears() != null  && !(patient.getServiceYears().equals(""))){
		%> <input id="totalServYrs" type="hidden" name="" value=""
	class="textbox_size20" style="border: 1px solid #7f9db7; width: 130px;"
	validate="Total Service,float,no" maxlength="6" tabindex="1" /> <input
	type="hidden" name="<%=SERVICE_YEARS %>"
	value="<%=patient.getServiceYears() %>">

<div style="float: left;"><select id="" name="<%=TOTAL_SERVICE%>"
	validate="Age,string,yes" tabindex="1" style="width: 56px;">
	<option value="">Select</option>
	<%
						for(int age1=1;age1<=100;age1++){
							
							if(patient.getServiceYears()==age1){
						%>
	<option value="<%=age1%>" selected="selected"><%= age1%></option>
	<%}else{%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}}%>
</select></div>
<div style="float: left;"><select id="ageUnitId"
	name="<%=TOTAL_SERVICE_PERIOD %>" validate="AgeUnit,string,no"
	tabindex="1" style="width: 60px;">
	<option value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select></div>
<%}else{ %>
<div style="float: left;"><select id="" name="<%=TOTAL_SERVICE%>"
	validate="Age,string,yes" tabindex="1" style="width: 56px;">
	<option value="">Select</option>
	<%
						for(int age1=1;age1<=100;age1++){
						%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select></div>
<div style="float: left;"><select id="ageUnitId"
	name="<%=TOTAL_SERVICE_PERIOD %>" validate="AgeUnit,string,no"
	tabindex="1" style="width: 60px;">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select></div>
<%} %> <label class="bodytextReg">CDA AcntNo:</label> <%
		if(patient.getCdaAccountNo() != null  && !(patient.getCdaAccountNo().equals(""))){
		%> <span class="wardspan"><%= patient.getCdaAccountNo()%></span> <input
	type="hidden" name="<%=CDA_ACCOUNT_NO %>"
	value="<%=patient.getCdaAccountNo() %>"> <%}else{ %> <input
	id="cdaId" type="text" name="<%=CDA_ACCOUNT_NO %>" value=""
	class="textbox_size20" style="border: 1px solid #7f9db7; width: 130px;"
	maxlength="15" tabindex="1" /> <%} %> <label class="bodytextReg">Station:</label>
<%
		if(patient.getStation() != null  && !(patient.getStation().equals(""))){
		%> <span class="wardspan"><%= patient.getStation()%></span> <input
	type="hidden" name="<%=STATION %>" value="<%=patient.getStation() %>">
<%}else{ %> <input id="stationId" type="text" name="<%=STATION %>"
	class="textbox_size20" style="border: 1px solid #7f9db7; width: 130px;"
	value="" validate="Station,alphaspace,no" maxlength="15" tabindex="1" />
<%} %> <br />
<div id="tradeDivId"><label class="bodytextReg"><font
	id="error">*</font>Unit:</label> <%
		if(patient.getUnit() != null){
		%> <span class="wardspan"><%= patient.getUnit().getUnitName()%></span>
<input type="hidden" name="<%=UNIT_ID %>"
	value="<%=patient.getUnit().getId() %>"> <label
	class="bodytextReg"> Unit Address:</label> <span class="wardspan"><%= patient.getUnit().getUnitAddress()%></span>
<%} %>
</div>

<br /></div>
<%
	
	}else{
%> <label class="bodytextReg"><font id="error">*</font>First
Name:</label> <input id="sFNameId" type="text" name="<%=S_FIRST_NAME %>"
	value="" title="First Name of Service Person" class="textbox_size20"
	style="border: 1px solid #7f9db7; width: 130px;"
	validate="First Name of Service Person,name,Yes" tabindex="1"
	MAXLENGTH="15" onblur="fillPatientName(this);" /> <label
	class="bodytextReg">Middle Name:</label> <input id="sMNameId"
	type="text" name="<%=S_MIDDLE_NAME%>" value="" class="textbox_size20"
	style="border: 1px solid #7f9db7; width: 130px;"
	validate="Middle Name of Service Person,name,no" MAXLENGTH="15"
	tabindex="1" onchange="fillPatientName(this);" /> <label
	class="bodytextReg">Last Name:</label> <input id="sLNameId" type="text"
	name="<%=S_LAST_NAME %>" value="" class="textbox_size20"
	style="border: 1px solid #7f9db7; width: 130px;"
	validate="Last Name of Service Person,name,no" MAXLENGTH="15"
	tabindex="1" onchange="fillPatientName(this);" /> <br />

<div id="rankDivId"><label class="bodytextReg"><font
	id="error">*</font>Rank:</label> <select id="rankId" name="<%=RANK_ID%>"
	validate="Rank,string,yes" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<%
				for (MasRank masRank : rankList) 
				{
					if(serviceTypeId == masRank.getServiceType().getId()){
				%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}
					}%>
</select> <script type="text/javascript">
		
		<%
			int k=0;
			for (MasRank masRank : rankList) 
				{
					if(masRank.getServiceStatus() != null){
						if(serviceTypeId == masRank.getServiceStatus().getId()){
								%>
									rankArr[<%=k%>] = new Array();
									rankArr[<%=k%>][0] = <%=serviceTypeId%>;
									rankArr[<%=k%>][1] = <%=masRank.getServiceType().getId()%>;
									rankArr[<%=k%>][2] = <%=masRank.getId()%>;									
									rankArr[<%=k%>][3] = "<%=masRank.getRankName()%>";
								<%
								k++;
						}
					}
				}
			
		%>
		</script> <label class="bodytextReg"> Trade:</label> <select id="tradeId"
	name="<%=TRADE_ID%>" validate="Trade,string,no" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
				for (MasTrade masTrade : tradeList) 
				{
					
				%>
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>
	<%
					}%>
</select> <script type="text/javascript">
		
		<%
			int tradeCount=0;
			for (MasTrade masTrade : tradeList) 
				{
					if(masTrade.getServiceType() != null){
						if(serviceTypeId == masTrade.getServiceType().getId()){
							
								%>
									tradeArr[<%=tradeCount%>] = new Array();
									tradeArr[<%=tradeCount%>][0] = <%=serviceTypeId%>;
									tradeArr[<%=tradeCount%>][1] = <%=masTrade.getId()%>;									
									tradeArr[<%=tradeCount%>][2] = "<%=masTrade.getTradeName()%>";
								<%
								tradeCount++;
						}
					}
				}
			
		%>
		</script> <label class="bodytextReg"> RcrdOff Add:</label> <select
	id="recordOffId" name="<%=RECORD_OFFICE_ADDRESS_ID %>"
	validate="RecordOff Addrs,string,no" class="select_adt" tabindex="1">
	<option value="0">Select</option>
	<%
			 	for (MasRecordOfficeAddress recordOfficeAddress : recordOfficeAddressList) 
				{
			 		if(serviceTypeId == recordOfficeAddress.getServiceType().getId()){
			%>
	<option value="<%=recordOfficeAddress.getId()%>"><%=recordOfficeAddress.getAddress()%></option>
	<%}
			}%>
</select> <script type="text/javascript">
					
				<%
				int count2=0;
					for (MasRecordOfficeAddress masRecordOfficeAddress : recordOfficeAddressList) 
						{
							if(masRecordOfficeAddress.getServiceType() != null){
								if(serviceTypeId == masRecordOfficeAddress.getServiceType().getId()){
										%>
											officeAddArr[<%=count2%>] = new Array();
											officeAddArr[<%=count2%>][0] = <%=serviceTypeId%>;
											officeAddArr[<%=count2%>][1] = <%=masRecordOfficeAddress.getId()%>;									
											officeAddArr[<%=count2%>][2] = "<%=masRecordOfficeAddress.getAddress()%>";
										<%
										count2++;
								}
							}
						}
					
				%>
					</script> <label class="bodytextReg">Formation:</label> <%if(serviceTypeId ==2){ %>
<select name="<%=FORMATION_ID %>" tabindex="1" id="formation"
	style="width: 100px;">
	<option value="">Select</option>
	<option value="1">Training Command, IAF</option>
	<option value="2">C A C</option>
	<option value="3">Western Air Command, IAF</option>
	<option value="4">South Western Air Command, IAF</option>
	<option value="5">Eastern Air Command, IAF</option>
	<option value="6">Southern Air Command, IAF</option>
	<option value="7">Maintenance Command, IAF</option>
	<option value="8">Others</option>

</select> <%}else{ %> <input id="formation" type="text" name="<%=FORMATION_ID %>"
	class="textbox_size20" style="border: 1px solid #7f9db7; width: 130px;"
	value="" validate="Formation,alphaspace,no" maxlength="30" tabindex="1">
<%} %> <br />
<label class="bodytextReg">Total Service:</label>
<div style="float: left;"><input id="totalServYrs" type="hidden"
	name="" value="" class="textbox_size20"
	style="border: 1px solid #7f9db7; width: 130px;"
	validate="Total Service,float,no" maxlength="6" tabindex="1" /> <select
	id="" name="<%=TOTAL_SERVICE%>" tabindex="1" style="width: 56px;">
	<option value="">Select</option>
	<%
						for(int age1=1;age1<=100;age1++){
						%>
	<option value="<%=age1%>"><%= age1%></option>
	<%}%>
</select></div>
<div style="float: left;"><select id="ageUnitId"
	name="<%=TOTAL_SERVICE_PERIOD %>" validate="AgeUnit,string,no"
	tabindex="1" style="width: 60px;">
	<option selected="selected" value="Years">Years</option>
	<option value="Months">Months</option>
	<option value="Days">Days</option>
</select></div>

<label class="bodytextReg">CDA AcntNo:</label> <input id="cdaId"
	type="text" name="<%=CDA_ACCOUNT_NO %>" value="" class="textbox_size20"
	style="border: 1px solid #7f9db7; width: 130px;" maxlength="15"
	tabindex="1" /> <label class="bodytextReg">Station:</label> <input
	id="stationId" type="text" name="<%=STATION %>" class="textbox_size20"
	style="border: 1px solid #7f9db7; width: 130px;" value=""
	validate="Station,alphaspace,no" maxlength="15" tabindex="1" /> <label
	class="bodytextReg">Local Unit:</label> <input type="checkbox"
	name="checkLocalUnit" value="y" style="width: 25px;" tabindex="1"
	checked="checked" onclick="displayUnit();"> <script
	type="text/javascript">
			function displayUnit(){
				var lUnit = document.getElementById('localUnit');
				var unit1 = document.registration.<%=UNIT_ID %>;
				
				if(lUnit.checked == false){
					unit1.length = 1;
					<%
					 for(MasUnit unit : unitList){
					%>
					unit1.length++;
					unit1.options[unit1.length-1].value=<%=unit.getId()%>;
					unit1.options[unit1.length-1].text='<%=unit.getUnitName()%>';		
				
				<%}%>
				}else{
					unit1.length = 1;
					<%
					 for(MasUnit unit : unitList){
						 if(unit.getLocalUnit() != null){
						 if(unit.getLocalUnit().equals("y")){
					%>
					unit1.length++;
					unit1.options[unit1.length-1].value=<%=unit.getId()%>;
					unit1.options[unit1.length-1].text='<%=unit.getUnitName()%>';		
					<%}
						 }
					}%>
				}
				unit1.length++;
				unit1.options[unit1.length-1].value='Other';
				unit1.options[unit1.length-1].text='Other';		
			}
		
		</script> <br />
<div id="tradeDivId"><label class="bodytextReg"><font
	id="error">*</font>Unit:</label> <select id="unitId" name="<%=UNIT_ID %>"
	onchange="displayAddress()" tabindex="1" validate="Unit,string,yes"
	class="select_adt">
	<option value="0">Select</option>
	<%
					 for(MasUnit masUnit : unitList){
						 if(masUnit.getLocalUnit() != null){
						 if(masUnit.getLocalUnit().equals("y")){
					 %>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>

	<%}
						 }
					}%>
	<option value="Other">Other</option>
</select>
<div id="unitAddId"><label class="bodytextReg"> Unit
Address:</label> <input id="unitAddressId" type="text" name="unitAdd" value=""
	class="readOnly" style="border: 1px solid #7f9db7; width: 130px;"
	validate="Unit Address,string,no" maxlength="50" readonly="readonly" />
</div>
<div id="addUnitDiv" style="display: none;"><label
	class="bodytextReg"> Unit Name:</label> <input id="newUnitId"
	type="text" name="<%=UNIT_NAME%>" value="" class="textbox_size20"
	style="border: 1px solid #7f9db7; width: 130px;"
	validate="Unit Address,string,no" maxlength="30" tabindex="1" /> <label
	class="bodytextReg"> Unit Address:</label> <input id="newUnitAddressId"
	type="text" name="<%=UNIT_ADDRESS %>" value="" class="textbox_size20"
	style="border: 1px solid #7f9db7; width: 130px;"
	validate="Unit Address,string,no" maxlength="50" tabindex="1" /> <label
	class="bodytextReg">Is Local Unit:</label> <input type="checkbox"
	id="localUnit" name="<%=LOCAL_UNIT %>" value="y" style="width: 25px;"
	tabindex="1" /></div>
</div>
<script type="text/javascript">
			function displayAddress(){
				var unit = document.getElementById('unitId').value;
				document.getElementById('unitAddId').style.display = 'inline';
				if(unit != 0){
				if(unit != 'Other'){
				document.getElementById('addUnitDiv').style.display = 'none';
				<%
					 for(MasUnit masUnit : unitList){
				%>
						var unit1 = '<%=masUnit.getId()%>';
						if(unit == unit1){
							document.registration.unitAdd.value = '<%=masUnit.getUnitAddress()%>'
						 }
			<%}%>}else if(unit == 'Other'){
						document.getElementById('addUnitDiv').style.display = 'inline';
						document.getElementById('unitAddId').style.display = 'none';
					}
				}else if(unit == 0){
					document.registration.<%=UNIT_ADDRESS%>.value = '';
				}
			}
		</script> <br /></div>

<%}%>