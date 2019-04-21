<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * investigation.jsp  
 * Purpose of the JSP -  This is for Investigation Master 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasChargeType"%>
<%@page import="jkt.hms.masters.business.MasSubTest"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	ArrayList  <MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
	subChargecodeList = (ArrayList)map.get("subChargecodeList");
	
	ArrayList  <MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
	mainChargecodeList = (ArrayList)map.get("mainChargecodeList");
	
	List<DgMasInvestigation> searchInvestigationList = new ArrayList<DgMasInvestigation>();
	searchInvestigationList=(List)map.get("searchInvestigationList");	
	
	ArrayList<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	departmentList=(ArrayList)map.get("departmentList");
	
	ArrayList<MasChargeType> chargeTypeList = new ArrayList<MasChargeType> ();
	chargeTypeList=(ArrayList)map.get("chargeTypeList");
	
	List<MasSubTest> subTestList = new ArrayList<MasSubTest>();
	subTestList=(ArrayList)map.get("subTestList");
	
	ArrayList<MasSample> sampleList = new ArrayList<MasSample>();
	sampleList=(ArrayList)map.get("sampleList");
	
	ArrayList<DgMasCollection> collectionList=new ArrayList<DgMasCollection>();
	collectionList=(ArrayList)map.get("collectionList");
	
	ArrayList<MasChargeCode>chargeCodeList = new ArrayList<MasChargeCode>();
	chargeCodeList=(ArrayList)map.get("chargeCodeList");
	
	ArrayList<DgUom> uomList = new ArrayList<DgUom>();
	List<MasLionc> masLioncList = new ArrayList<MasLionc>();
	if(map.get("masLioncList")!=null)
	{
		masLioncList=(List<MasLionc>)map.get("masLioncList");
	}
	uomList=(ArrayList)map.get("uomList");
	String deptType = "";
	if (session.getAttribute("deptType") != null) {
		deptType = (String) session.getAttribute("deptType");
	}		
			String invShortCode ="";
	        String investigationName ="";
			String userName = "";
			String message="";
			int mainChargecodeId =0;
			int subChargecodeId =0;
			int chargeCodeId =0;
			int deptId = 0;
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			if(map.get("mainChargecodeId") != null){
				mainChargecodeId =(Integer) map.get("mainChargecodeId");
			}
			if(map.get("subChargecodeId") != null){
				subChargecodeId =(Integer) map.get("subChargecodeId");
			}
			if(map.get("chargeCodeId") != null){
				chargeCodeId =(Integer) map.get("chargeCodeId");
			}
		 	if(map.get("investigationName") != null){
		 		investigationName = (String)map.get("investigationName");
		 	}
		 	/* Added By Om tripathi  */
		 	if(map.get("invShortCode") != null){
		 		invShortCode = (String)map.get("invShortCode");
		 	}
			int pageNoTempFromBackButton =0;
			if(map.get("pageNoTempFromBackButton") != null){
				pageNoTempFromBackButton =(Integer) map.get("pageNoTempFromBackButton");
			
			}
			if(map.get("message") != null){
			 	message = (String)map.get("message"); 	
		%>
<h4>
	<span><%=message %></span>
</h4>
<%} %>
<%
		ArrayList gridSubChargecodeList = (ArrayList) map.get("gridSubChargecodeList");
		ArrayList gridMainChargecodeList = (ArrayList) map.get("gridMainChargecodeList");
		ArrayList gridChargeTypeList = (ArrayList) map.get("gridChargeTypeList");
		ArrayList gridSampleList = (ArrayList) map.get("gridSampleList");
		ArrayList gridUnitOfMeasurementList = (ArrayList) map.get("gridUnitOfMeasurementList");
		ArrayList gridChargeCodeList =(ArrayList)map.get("gridChargeCodeList");
		ArrayList gridCollectionList =(ArrayList)map.get("gridCollectionList");
	%>
<script>
function showHideGoButton(invObj){
	var invType = invObj.value;
	if(invType == 't' || invType == 'm'  ){
		document.getElementById('goDiv').style.display = 'inline';
	}else{
		document.getElementById('goDiv').style.display = 'none';
	}
	
	if(invType == 't')
	{
	document.getElementById('unit').style.display= 'none';
	document.getElementById('normal').style.display= 'none';
	
	}
	if(invType == 's' ||  invType == 'v')
	{
	document.getElementById('unit').style.display= 'inline';
	document.getElementById('normal').style.display= 'inline';
	
	}
	if(invType == 'm')
	{
	document.getElementById('normal').style.display= 'none';
	document.getElementById('unit').style.display= 'inline';	
	}
}

	function disableValuesOfRadio(){
	if(document.getElementById('normalValue').value != ""){
	document.getElementById('minNormalValue').disabled = true;
	document.getElementById('maxNormalValue').disabled = true;
	}else{
	document.getElementById('minNormalValue').disabled = false;
	document.getElementById('maxNormalValue').disabled = false;
	}
	}

	function disableValues(){
	if(document.getElementById('normalValue').value != ""){
	document.getElementById('minNormalValue').value = "";
	document.getElementById('maxNormalValue').value = "";
	document.getElementById('minNormalValue').disabled = true;
	document.getElementById('maxNormalValue').disabled = true;
	}else{
	document.getElementById('minNormalValue').disabled = false;
	document.getElementById('maxNormalValue').disabled = false;
	}
	}

	function disableNormalValues(){
		if(document.getElementById('minNormalValue').value != ""){
		document.getElementById('normalValue').value = "";
		document.getElementById('normalValue').disabled = true;
		}else{
		document.getElementById('normalValue').disabled = false;
		}
	}

	function disableForEdit(){
		if(document.getElementById('investigationType').value == 'v'){
		document.getElementById('normalValue').disabled = "";
		document.getElementById('normalValue').disabled = true;
		document.getElementById('normalValue').disabled = true;
		}else{
		document.getElementById('normalValue').disabled = false;
		}
	}

function singleParValidation(){
var errorMessage= "" ;
if(document.getElementById('investigationType').value =='s'){
	if(document.getElementById('normalValue').disabled == false && document.getElementById('normalValue').value == ""){
	errorMessage=errorMessage+"Please Enter Normal Value \n"; 
	}
	if(errorMessage !=""){
		alert(errorMessage);
		return false;
	}
	else{
		return true;		
	}	
		
	}else{
	return true;
	}
	}
</script>
<script type="text/javascript">
function investigation(obj){
	var url;
	var errorMessage= "" ;
	var mainChargecodeId = 0;
	var subChargeCodeId= 0;
	var chargeCodeId= 0;
	var investigationName="";
	var confidential="";
	var investigationType="";
	var dischargeSummary="";
	var sampleId="";
	var quantity ="";
	var collectionCenterId ="";
	obj = eval('document.'+formName)
	 if(document.getElementById('investigationType').value =="m"){
	
	if(document.getElementById('mainChargecodeId').value ==0)
	errorMessage=errorMessage+"Please Select Department \n"; 
	if(document.getElementById('subChargeCodeId').value == 0)
	errorMessage=errorMessage+"Please Select Modality  \n"
	if(document.getElementById('chargeCodeId').value == 0)
	errorMessage=errorMessage+"Please Select Test Name  \n"
		
		mainChargecodeId=document.getElementById('mainChargecodeId').value;
		subChargeCodeId=document.getElementById('subChargeCodeId').value; 
		chargeCodeId=document.getElementById('chargeCodeId').value;
		investigationName=document.getElementById('investigationName').value;
		confidential=document.getElementById('confidential').value;
		investigationType=document.getElementById('investigationType').value;
		dischargeSummary=document.getElementById('dischargeSummary').value;
		sampleId= document.getElementById('sample_id').value;
		quantity = document.getElementById('quantity').value;
		collectionCenterId = document.getElementById('collectionCenterId').value;
		invShortCode=document.getElementById('invShortCode').value;	
		if((mainChargecodeId!=0)&&(subChargeCodeId!=0)&&(chargeCodeId!=0)){
		  document.getElementById('normalValue').disabled = false;
	 document.getElementById('unitName').disabled = false;
	 document.getElementById('minNormalValue').disabled = false;  
	 document.getElementById('maxNormalValue').disabled = false; 
	 document.getElementById('<%=SAMPLE_ID %>').disabled = false;  
	 document.getElementById('collectionCenterId').disabled = false;  
	 document.getElementById('quantity').disabled = false;	
	 
    url="investigation?method=showSubInvestigationJsp&mainChargecodeId="+document.getElementById('mainChargecodeId').value+'&subChargeCodeId='+document.getElementById('subChargeCodeId').value+'&chargeCodeId='+document.getElementById('chargeCodeId').value+'&investigationName='+document.getElementById('investigationName').value+'&confidential='+document.getElementById('confidential').value+'&investigationType='+document.getElementById('investigationType').value+'&dischargeSummary='+document.getElementById('dischargeSummary').value+'&sampleId='+document.getElementById('sample_id').value+'&quantity='+document.getElementById('quantity').value+'&collectionCenterId='+document.getElementById('collectionCenterId').value;
		obj.action=url;
		obj.submit();
			}else{
			alert(errorMessage);
			return false
			}
			if(errorMessage!=""){
			alert(errorMessage);
			return false
			}
}
	 
	else if(document.getElementById('investigationType').value == "t"){
		if(document.getElementById('mainChargecodeId').value ==0)
		errorMessage=errorMessage+"Please Select Department \n"; 
		if(document.getElementById('subChargeCodeId').value == 0)
		errorMessage=errorMessage+"Please Select Modality   \n"
		if(document.getElementById('chargeCodeId').value == 0)
		errorMessage=errorMessage+"Please Select Test Name  \n"
		
		mainChargecodeId=document.getElementById('mainChargecodeId').value;
		subChargeCodeId=document.getElementById('subChargeCodeId').value; 
		chargeCodeId=document.getElementById('chargeCodeId').value;
		investigationName=document.getElementById('investigationName').value;
		confidential=document.getElementById('confidential').value;
		investigationType=document.getElementById('investigationType').value;
		dischargeSummary=document.getElementById('dischargeSummary').value;
		sampleId= document.getElementById('sample_id').value;
		quantity = document.getElementById('quantity').value;
		collectionCenterId = document.getElementById('collectionCenterId').value;
		unitOfMeasurementId = document.getElementById('unitName').value;

		if((mainChargecodeId!=0)&&(subChargeCodeId!=0)&&(chargeCodeId!=0)){
		 document.getElementById('normalValue').disabled = true;
		 document.getElementById('unitName').disabled = true;  
		 document.getElementById('minNormalValue').disabled = true;  
		 document.getElementById('maxNormalValue').disabled = true;  
		 
		url="/hms/hms/investigation?method=showTemplateJsp&mainChargecodeId="+document.getElementById('mainChargecodeId').value+'&subChargeCodeId='+document.getElementById('subChargeCodeId').value+'&chargeCodeId='+document.getElementById('chargeCodeId').value+'&investigationName='+document.getElementById('investigationName').value+'&confidential='+document.getElementById('confidential').value+'&investigationType='+document.getElementById('investigationType').value+'&dischargeSummary='+document.getElementById('dischargeSummary').value+'&sampleId='+document.getElementById('sample_id').value+'&quantity='+document.getElementById('quantity').value+'&collectionCenterId='+document.getElementById('collectionCenterId').value+'&unitOfMeasurementId='+document.getElementById('unitName').value;
		obj.action=url;
		obj.submit();
	
  }else{
		alert(errorMessage);
		return false
		}
		
		if(errorMessage!=""){
		alert(errorMessage);
		return false
		}
  }else if(document.getElementById('investigationType').value == "v"){
		if(document.getElementById('mainChargecodeId').value ==0)
		errorMessage=errorMessage+"Please Select Department \n"; 
		if(document.getElementById('subChargeCodeId').value == 0)
		errorMessage=errorMessage+"Please Select Modality   \n"
		if(document.getElementById('chargeCodeId').value == 0)
		errorMessage=errorMessage+"Please Select Test Name  \n"
		
		mainChargecodeId=document.getElementById('mainChargecodeId').value;
		subChargeCodeId=document.getElementById('subChargeCodeId').value; 
		chargeCodeId=document.getElementById('chargeCodeId').value;
		investigationName=document.getElementById('investigationName').value;
		confidential=document.getElementById('confidential').value;
		investigationType=document.getElementById('investigationType').value;
		dischargeSummary=document.getElementById('dischargeSummary').value;
		sampleId= document.getElementById('sample_id').value;
		quantity = document.getElementById('quantity').value;
		collectionCenterId = document.getElementById('collectionCenterId').value;
		unitOfMeasurementId = document.getElementById('unitName').value;
		if((mainChargecodeId!=0)&&(subChargeCodeId!=0)&&(chargeCodeId!=0)){
		 document.getElementById('normalValue').disabled = true;
		 document.getElementById('unitName').disabled = true;  
		 document.getElementById('minNormalValue').disabled = true;  
		 document.getElementById('maxNormalValue').disabled = true; 
		 document.getElementById('<%=SAMPLE_ID %>').disabled = true;  
		 document.getElementById('collectionCenterId').disabled = true;  
		 document.getElementById('quantity').value="";
		 document.getElementById('quantity').disabled = true;  
			
		var url="/hms/hms/investigation?method=showFixedValue&rowNo="+2;

		popwindow(url);
	//url="/hms/hms/investigation?method=showTemplateJsp&mainChargecodeId="+document.getElementById('mainChargecodeId').value+'&subChargeCodeId='+document.getElementById('subChargeCodeId').value+'&chargeCodeId='+document.getElementById('chargeCodeId').value+'&investigationName='+document.getElementById('investigationName').value+'&confidential='+document.getElementById('confidential').value+'&investigationType='+document.getElementById('investigationType').value+'&dischargeSummary='+document.getElementById('dischargeSummary').value+'&sampleId='+document.getElementById('sample_id').value+'&quantity='+document.getElementById('quantity').value+'&collectionCenterId='+document.getElementById('collectionCenterId').value+'&unitOfMeasurementId='+document.getElementById('unitName').value;
	//obj.action=url;
	//obj.submit();
	
	}else{
		alert(errorMessage);
		return false
		}
		if(errorMessage!=""){
		alert(errorMessage);
		return false
		}
	}
	else
		{
	 document.getElementById('normalValue').disabled = false;
	 document.getElementById('unitName').disabled = false;
	 document.getElementById('minNormalValue').disabled = false;  
	 document.getElementById('maxNormalValue').disabled = false; 
	 document.getElementById('<%=SAMPLE_ID %>').disabled = false;  
	 document.getElementById('collectionCenterId').disabled = false;  
	 document.getElementById('quantity').disabled = false; 
 	}
 	
}

function checkInvestigationSearch()
{
var investigationType=document.getElementById('investigationTypeSearch').value;

if(investigationType=="")
{
alert("Please select Investigation Type");
document.getElementById('investigationTypeSearch').focus();
return false;
}
else
{
return true;
}
}
</script>
<div class="titleBg">
	<h2>Diagnostic Master</h2>
</div>
<div class="Block">
	<div id="searcharea">
		<div id="searchbar">
			<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<label>Investigation Name</label> <input type="text"
					id="searchField" name="<%= SEARCH_FIELD%>" value="" MAXLENGTH="10" validate="Investigation Name,metachar,no"
					tabindex=1 /> <label><span>*</span> Investigation Type</label> <select
					name="investigationTypeSearch" id="investigationTypeSearch" validate="investigationTypeSearch,metachar,yes" >
					<% if(deptType.equalsIgnoreCase("radio")){%>
					<option value="">Select</option>
					<option value="t" selected="selected">Template</option>
					<%}else{ %>
					<option value="">Select</option>
					<option value="s">Single Parameter</option>
					<option value="m">Multiple Parameter</option>
					<option value="t">Template</option>
					<option value="v">Sensitive</option>
					<%} %>
				</select>
				
				<input type="button" name="search" value="Search" class="button"
					tabindex=1
					onclick="if(checkInvestigationSearch()){submitForm('search','investigation?method=searchInvestigation');}" />

				<input type="button" name="Report" value="Generate Report"
					class="buttonBig"
					onclick="submitForm('search','investigation?method=printDiagonstics')"
					accesskey="g" tabindex=1 />
			</form>

		</div>
	</div>
	<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
	<div id="searchtable" tabindex=2></div>
	<%
	if (searchInvestigationList.size() > 0 ) {
		String strForCode = (String) map.get("investigationCode");
		String strForCodeDescription = (String) map.get("investigationName");
		if (strForCode != null && strForCode != "" || strForCodeDescription != null	&& strForCodeDescription != "") {
%>
	<div class="clear"></div>
	<h4>
		<a href="investigation?method=showInvestigationJsp">Show All
			Records</a>
	</h4>
	<%
 	}
 	}
 if(searchInvestigationList.size()==0 && map.get("search") != null)
	  {
	 %><h4>
		<a href="investigation?method=showInvestigationJsp">Show All
			Records</a>
	</h4>
	<%
    }
	%>
	<script type="text/javascript">
	formFields = [
	 		[0, "<%= INVESTIGATION_ID%>", "id"],[1,"<%= INVESTIGATION_NAME %>"],[2,"<%= MAIN_CHARGECODE_ID %>"], [3,"<%= SUB_CHARGECODE_ID%>"], [4,"<%= CHARGE_CODE_ID%>"],[5,"<%=SAMPLE_ID %>"],[6,"<%= NORMAL_VALUE%>"],[7,"<%=UNIT_OF_MEASUREMENT_ID%>"],[8,"<%=CONFIDENTIAL %>"],[9,"<%= DSICHARGE_SUMMARY%>"],[10,"<%=QUANTITY%>"],[11,"<%=INVESTIGATION_TYPE%>"],[12,"<%= CHANGED_DATE %>"],[13,"<%= CHANGED_TIME %>"],[14,"<%=COLLECTION_CENTER_ID%>" ],[15,"<%=LIONC_CODE%>"],[16,"<%=RARE_COMMON%>"],[17,"<%=MIN_NORMAL_VALUE%>"],[18,"<%=MAX_NORMAL_VALUE%>"],[19,"variation"],[20,"<%=BLOOD_BANK_SCREEN%>"],[21,"<%=BLOOD_REACTION_TEST%>"],[22,"subChrg"],[23,"mainChrge"],[24,"<%=STATUS%>"],[25,"<%=REMARKS%>"],[26,"phInvestigation"],[27,"invShortCode"]];
	   statusTd = 24;
	</script>
</div>
<div class="clear"></div>
<script type="text/javascript">
function deleteChargeCode(){
var subChargeId1=document.chargeCode.<%= SUB_CHARGECODE_ID%>.options[document.chargeCode.<%= SUB_CHARGECODE_ID%>.selectedIndex].text;
var mainChargeId1=document.chargeCode.<%= MAIN_CHARGECODE_ID%>.options[document.chargeCode.<%= MAIN_CHARGECODE_ID%>.selectedIndex].text;

 if(mainChargeId1=="Select"){
	alert('Parent is InActivated!');
}
else{
deleteForm('chargeCode','/hms/hms/investigation?method=deleteInvestigation');
}
}	
function chkWetherRadio(){
if(document.getElementById('<%=MAIN_CHARGECODE_ID %>').value==4)
{
	document.getElementById('collectionCenterId').value="";
	document.getElementById('collectionCenterId').disabled=true;
	document.getElementById('quantity').value = "";
	document.getElementById('quantity').disabled = true;
	document.getElementById('sample_id').value = "";
	document.getElementById('sample_id').disabled = true;
	document.getElementById('unitName').value= "";
	document.getElementById('unitName').disabled= true;
	document.getElementById('normalValue').value= "";
	document.getElementById('normalValue').disabled= true;
	document.getElementById('minNormalValue').value= "";
	document.getElementById('minNormalValue').disabled= true;
	document.getElementById('maxNormalValue').value= "";
	document.getElementById('maxNormalValue').disabled= true;
	//document.getElementById('<%=MAIN_CHARGECODE_ID %>').value
	//document.getElementById('<%=MAIN_CHARGECODE_ID %>').value
	
}
else
{
	document.getElementById('collectionCenterId').disabled = false;
	document.getElementById('quantity').disabled = false;
	document.getElementById('sample_id').disabled = false;
	document.getElementById('unitName').disabled = false;
	document.getElementById('minNormalValue').disabled= false;
	document.getElementById('maxNormalValue').disabled= false;
}
}
function getLionClass(subChargeCode)
{
var mainChargeCode=document.getElementById('<%=MAIN_CHARGECODE_ID%>').value;

submitProtoAjaxForLionClass('chargeCode','/hms/hms/investigation?method=getLionClass&mainChargeCode='+mainChargeCode+'&subChargeCode='+subChargeCode); 
}

function submitProtoAjaxForLionClass(formName,action){
	
		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action+"&"+getNameAndData(formName)
	        	
	        	new Ajax.Updater('testDivItem',url,
				   {asynchronous:true, evalScripts:true }); 
				return true;
	    	}
	    	
function getNameAndData(formName) {
   var str="";
   inputs = eval('document.'+formName+'.elements');
   for(i=0;i<inputs.length;i++){
   	str=str+inputs[i].name+"="+inputs[i].value+"&"
   }
   return str;
}
 
</script>
<form name="chargeCode" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<input type="hidden" name="<%= POJO_NAME %>" value="DgMasInvestigation" validate="pojoName,metachar,no"><input
		type="hidden" name="<%=POJO_PROPERTY_NAME %>"
		value="InvestigationName" validate="pojoPropertyName,metachar,no"><input type="hidden" name="title"
			value="Investigation" validate="title,metachar,no"><input type="hidden"
				name="<%=JSP_NAME %>" value="investigation" validate="jspName,metachar,no"><input
					type="hidden" name="pojoPropertyCode" value="InvestigationCode" validate="pojoPropertyCode,metachar,no"><input
						type="hidden" name="deptId" value="<%=deptId%>" validate="deptId,int,no"/>
						<div class="clear"></div>
						<div class="paddingTop5"></div>
						<div class="Block">
							<label><span>*</span> Main Charge Code</label> <select
								id="<%=MAIN_CHARGECODE_ID %>" name="<%=MAIN_CHARGECODE_ID %>"
								validate=" Main Charge Code,metachar,yes"
								onChange="chkWetherRadio();populateSubChargeCode(this.value,'chargeCode')"
								tabindex=1>
								<option value="">Select</option>
								<% if(mainChargecodeList.size()>0){
				for (MasMainChargecode mainChargecode : mainChargecodeList){
					if (mainChargecodeId ==(mainChargecode.getId())) {
				%>
								<option value="<%=mainChargecode.getId ()%>" selected="selected"><%=mainChargecode.getMainChargecodeName()%></option>
								<%}else{ %>
								<option value="<%=mainChargecode.getId ()%>"><%=mainChargecode.getMainChargecodeName()%></option>
								<%}}}%>
							</select>

							<script type="text/javascript">
         		 subChargeArray1 = new Array();
				<%
				int count = 0;
				for (Iterator iter = mainChargecodeList.iterator(); iter.hasNext();) 
				{
				MasMainChargecode mainChargecode = (MasMainChargecode) iter.next();
				for (Iterator iterSubChargecode = subChargecodeList.iterator(); iterSubChargecode.hasNext();) 
				{
					MasSubChargecode subChargecode = (MasSubChargecode) iterSubChargecode.next();
					if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId())){
								%>
									subChargeArray1[<%=count%>] = new Array();
									subChargeArray1[<%=count%>][0] = <%=mainChargecode.getId()%>;
									subChargeArray1[<%=count%>][1] = <%=subChargecode.getId()%>;									
									subChargeArray1[<%=count%>][2] = "<%=subChargecode.getSubChargecodeName()%>";

								<%
								count++;
						}
					}
				}
			%>
		</script>
							<label><span>*</span> Sub Charge Code</label> <select
								id="<%=SUB_CHARGECODE_ID %>" name="subChargeCodeId"
								validate="Sub Charge Code ,metachar,yes" tabindex=1
								onChange="populateCharge(this.value,'chargeCode');getLionClass(this.value)">
								<option value="">Select</option>
								<% 
				if(subChargecodeList.size() >0){
				for (MasSubChargecode subChargecode : subChargecodeList){
					if (subChargecodeId ==(subChargecode.getId())) {
				%>
								<option value="<%=subChargecode.getId ()%>" selected="selected"><%=subChargecode.getSubChargecodeName()%></option>
								<% }else{%>
								<option value="<%=subChargecode.getId ()%>"><%=subChargecode.getSubChargecodeName()%></option>

								<%}}}%>

							</select>
							<script type="text/javascript">
          chargeCodeArray = new Array();
		<%
			int count1 = 0;
			for (Iterator iter = subChargecodeList.iterator(); iter.hasNext();) 
			{
				MasSubChargecode subChargecode = (MasSubChargecode) iter.next();
				for (Iterator iterChargecode = chargeCodeList.iterator(); iterChargecode.hasNext();) 
				{
					MasChargeCode chargeCode = (MasChargeCode) iterChargecode.next();
					if(subChargecode.getId().equals(chargeCode.getSubChargecode().getId())){
						StringBuffer output_str = new StringBuffer();
						 StringTokenizer s = new StringTokenizer(chargeCode.getChargeCodeName().toString(),"\""); 

						 while (s.hasMoreTokens())
						 {
						 output_str.append(s.nextToken());
						 if (s.hasMoreTokens())
						 {
						 output_str.append("\\");
						 output_str.append("\"");
						 }
						 }	
%>							
								
									chargeCodeArray[<%=count1%>] = new Array();
									chargeCodeArray[<%=count1%>][0] = <%=subChargecode.getId()%>;
									chargeCodeArray[<%=count1%>][1] = <%=chargeCode.getId()%>;									
									chargeCodeArray[<%=count1%>][2] = "<%=output_str%>";
								<%
								count1++;
						}
					}
				}
		%>
		</script>
							<label><span>*</span> Test Name</label> <select
								id="<%=CHARGE_CODE_ID%>" name="<%=CHARGE_CODE_ID %>"
								validate="Test Name,metachar,yes" tabindex=1
								onchange="fillInvestigation(this.value)">
								<option value="">Select</option>
								<% 
				for (MasChargeCode masChargeCode : chargeCodeList){
					if (chargeCodeId ==(masChargeCode.getId())) {
				%>
								<option value="<%=masChargeCode.getId ()%>" selected="selected"><%=masChargeCode.getChargeCodeName()%></option>
								<%}else{ %>
								<option value="<%=masChargeCode.getId ()%>"><%=masChargeCode.getChargeCodeName()%></option>

								<%}}%>
							</select>

							<div class="clear"></div>

							<label>Investigation Name</label>
							<%if(investigationName != null){ %>
							<input type="text" name="<%= INVESTIGATION_NAME %>"
								value="<%=investigationName %>" id=<%=INVESTIGATION_NAME %>
								validate="Investigation Name,metachar,no" maxlength="30"
								tabindex=1 />
							<%}else{ %>
							<input type="text" name="<%= INVESTIGATION_NAME %>" value=""
								id=<%=INVESTIGATION_NAME %>
								validate="Investigation Name,metachar,no" maxlength="30"
								tabindex=1 />
							<%} %>
							<input type="hidden" id="investigationId1"
								name="investigationId1" value="<%=chargeCodeId %>" validate="investigationId1,int,no"><input
								type="hidden" id="investigationCode" name="investigationCode"
								value="" validate="investigationCode,metachar,no"><script type="text/javascript">
				function fillInvestigation(obj){
				
		<%		
		for (MasChargeCode masChargeCode : chargeCodeList) 
								{
										%>
										var invObj =<%= masChargeCode.getId()%>
										if(invObj == obj){
 								<%
										StringBuffer output_str = new StringBuffer();
										StringTokenizer s = new StringTokenizer(masChargeCode.getChargeCodeName().toString(),"\""); 

										while (s.hasMoreTokens())
										{
										output_str.append(s.nextToken());
										if (s.hasMoreTokens())
										{
										output_str.append("\\");
										output_str.append("\"");
										}
										}
										%>
 								
 								
 							document.getElementById('investigationName').value="<%=output_str%>"
 							document.getElementById('investigationId1').value="<%=masChargeCode.getId()%>"
 							document.getElementById('investigationCode').value="<%=masChargeCode.getChargeCodeCode()%>"
 							}
 					<%
 						} %>	
 						}
 			</script> <label>Test Status</label> <select name="<%=RARE_COMMON %>"
									tabindex=1>
										<option value="c">Common</option>
										<option value="r">rare</option>
								</select> <label><span>*</span> Investigation Type</label> <select
									name="<%=INVESTIGATION_TYPE %>" id="<%=INVESTIGATION_TYPE %>"
									validate="Investigation Type,metachar,yes"
									onchange="showHideGoButton(this);">
										<% if(deptType.equalsIgnoreCase("radio")){%>
										<option value="">Select</option>
										<option value="t" selected="selected">Template</option>
										<%}else{ %>
										<option value="">Select</option>
										<option value="s">Single Parameter</option>
										<option value="m">Multiple Parameter</option>
										<option value="t">Template</option>
										<option value="v">Sensitive</option>


										<%} %>
								</select> <% if(!deptType.equalsIgnoreCase("radio")){
            	%>
									<div id="goDiv" style="display: none;">
										<% }else{ %>
										<div id="goDiv" style="display: inline;">
											<% } %>
											<input type="button" name="search"
												id="submitWithInvestigationType" value="Go" class="buttonSm"
												onclick="investigation(this);" tabindex=1 />
										</div>
										<div class="clear"></div>
										<label><span>*</span>Collection</label> <select
											id=<%=COLLECTION_CENTER_ID %>
											name="<%=COLLECTION_CENTER_ID %>"
											validate="Collection,metachar,yes" tabindex=1>
											<option value="0">Select</option>
											<% 
				for (DgMasCollection dgCollection : collectionList){
				%>
											<option value="<%=dgCollection.getId ()%>"><%=dgCollection.getCollectionName()%></option>
											<%}%>

										</select>
										<div id="unit" style="display: inline;">
											<label>Unit Name</label> <select id="unitName"
												name="<%=UNIT_OF_MEASUREMENT_ID %>"
												validate="Unit Name,metachar,no" tabindex=1>
												<option value="0">Select</option>
												<% 
				for (DgUom dgUom : uomList){
				%>
												<option value="<%=dgUom.getId ()%>"><%=dgUom.getUomName()%></option>
												<%}%>
											</select>
										</div>
										<label> Sample</label> <select id=<%=SAMPLE_ID %>
											name="<%=SAMPLE_ID %>" validate="Sample,metachar,no" tabindex=1>
											<option value="0">Select</option>
											<% 
				for (MasSample sample : sampleList){
				%>
											<option value="<%=sample.getId ()%>"><%=sample.getSampleDescription()%></option>
											<%}%>
										</select>
										<div class="clear"></div>
										<label>Sample Quantity</label> <input type="text"
											name="<%= QUANTITY%>" value="1" id="quantity" class="text"
											maxlength="10" validate="Sample Quantity,metachar,no"
											tabindex=1 />
										<div id="normal" style="display: inline;">
											<label>Normal Value</label> <input type="text"
												name="<%= NORMAL_VALUE%>" value="" id="<%= NORMAL_VALUE%>"
												validate="Normal Value,string,no" maxlength="20" tabindex=1
												onblur="disableValues();" /> <label>Min Value</label> <input
												type="text" name="<%= MIN_NORMAL_VALUE%>" value=""
												id="<%= MIN_NORMAL_VALUE%>" validate="Min Value,string,no"
												maxlength="20" tabindex=1 onblur="disableNormalValues();" />


											<div class="clear"></div>
											<label>Max Value</label> <input type="text"
												name="<%= MAX_NORMAL_VALUE%>" value=""
												id="<%= MAX_NORMAL_VALUE%>" validate="Max Value,string,no"
												maxlength="20" tabindex=1 />
										</div>
										<div id="testDivItem">

											<label>Loinc Code</label> <select id="lioncCode"
												name="<%=LIONC_CODE%>" validate="Lionc Code,metachar,no" tabindex=1>
												<option value="">Select</option>
											</select>
										</div>
										
										<label>Remark</label> <input type="text" name="<%=REMARKS%>"
											value="" id="<%=REMARKS%>" validate="Remarks,metachar,no"
											maxlength="100" tabindex=1 />
											
											<div class="clear"></div>											
											<label><span>*</span>Investigation Short Code</label>
 											<input type="text" id="invShortCode" name="invShortCode" tabindex=1 value="" MAXLENGTH="8" validate="Investigation short name,string,yes">
										
										<label>Confidential</label> <input type="checkbox"
											name="<%= CONFIDENTIAL%>" id="<%= CONFIDENTIAL%>" value="y"
											class="inputRadiobutton" tabindex="1" validate="confidential,metachar,no" /> <label class="auto">
											Appear in Discharge Summary</label> <input type="checkbox" style="margin-right:155px !important;"
											name="<%=DSICHARGE_SUMMARY%>" id="<%= DSICHARGE_SUMMARY%>"
											value="y" class="inputRadiobutton" tabindex="1" validate="dischargeSummary,metachar,no"/>
											 
											 <div class="clear"></div>
											 <label>Variation Required </label> <input
											type="checkbox" name="variation" id="variation" value="y"
											class="inputRadiobutton" tabindex="1" validate="variation,metachar,no"/>
										
										<label>SMS Required </label> <input type="checkbox" name="sms"
											id="sms" value="y" class="inputRadiobutton" tabindex="1" validate="sms,metachar,no"/> 
											
											<label>Blood Screen test</label>
											
											 <input type="checkbox" name="bloodBankScreen"
											id="screenTest" value="y" class="inputRadiobutton" tabindex="1" validate="bloodBankScreen,metachar,no"/>
										<div class="clear"></div>
										<label>Blood Reaction Test</label> <input type="checkbox"
											name="bloodReactionTest" id="reactionTest" value="y"
											class="inputRadiobutton" tabindex="1" validate="bloodReactionTest,metachar,no" />
										
										<label>Sumitted By OPD</label> <input type="checkbox" name="submittedByOPD"
											id="submittedByOPD" value="y" class="inputRadiobutton" tabindex="1" validate="sms,metachar,no"/>
											
											<label>PH Investigation</label> <input type="checkbox" name="phInvestigation"
											id="phInvestigation" value="y" class="inputRadiobutton" tabindex="1" validate="sms,metachar,no"/> 
										 
												<div class="clear"></div>
									</div>
									<div class="clear"></div>
									<div class="division"></div>

									<div id="edited"></div> <input type="button" name="add"
									id="addbutton" value="Add" class="button"
									onClick="if(singleParValidation()){submitForm('chargeCode','investigation?method=addInvestigation');}"
									accesskey="a" tabindex=1 style="display: inline;" /> <input
									type="button" name="edit" id="editbutton" value="Update"
									class="button"
									onClick="submitForm('chargeCode','investigation?method=editInvestigation')"
									accesskey="u" tabindex=1 style="display: none;" /> <input
									type="button" name="Delete" id="deletebutton" value="Activate"
									style="display: none;" class="button"
									onClick="submitForm('chargeCode','investigation?method=deleteInvestigation&flag='+this.value)"
									accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
									id="reset" value="Reset" class="buttonHighlight" accesskey="r"
									onclick="resetCheck();" tabindex=1 /> <input type="hidden"
									name="<%=STATUS%>" value="" validate="Status,metachar,no"/> <input type="hidden"
									name="<%= INVESTIGATION_ID%>" value="" validate="investigationId,int,no"/>
									<div class="clear"></div>
									<div class="division"></div>
									<div class="bottom">
										<label>Changed By</label> <label class="value"><%=userName%></label>

										<label>Changed Date</label> <label class="value"><%=date%></label>
										<label>Changed Time</label> <label class="value"><%=time%></label>
										<div class="clear"></div>
									</div>
									<div class="clear"></div>
	</div>								
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Investigation Name"
data_header[0][1] = "data";
data_header[0][2] = "14%";
data_header[0][3] = "<%=INVESTIGATION_NAME%>";

data_header[1]=new Array;
data_header[1][0]="Main Charge Code"
data_header[1][1]="data";
data_header[1][2]="14%";
data_header[1][3]="<%=MAIN_CHARGECODE_ID%>";

data_header[2]=new Array;
data_header[2][0]="Sub Charge Code"
data_header[2][1]="data";
data_header[2][2]="14%";
data_header[2][3]="<%=SUB_CHARGECODE_ID%>";

data_header[3]=new Array;
data_header[3][0]="Test Name"
data_header[3][1]="data";
data_header[3][2]="14%";
data_header[3][3]="<%=CHARGE_CODE_ID%>";

data_header[4]=new Array;
data_header[4][0]="Sample"
data_header[4][1]="data";
data_header[4][2]="14%";
data_header[4][3]="<%=SAMPLE_ID%>";

data_header[5]=new Array;
data_header[5][0]="Normal Value"
data_header[5][1]="hide";
data_header[5][2]=0;
data_header[5][3]="<%=NORMAL_VALUE %>";

data_header[6]=new Array;
data_header[6][0]="Unit"
data_header[6][1]="hide";
data_header[6][2]=0;
data_header[6][3]="<%=UNIT_OF_MEASUREMENT_ID%>";

data_header[7]=new Array;
data_header[7][0]="Confidential"
data_header[7][1]="hide";
data_header[7][2]=0;
data_header[7][3]="<%=CONFIDENTIAL%>";

data_header[8]=new Array;
data_header[8][0]="Discharge Summary"
data_header[8][1]="hide";
data_header[8][2]=0;
data_header[8][3]="<%=DSICHARGE_SUMMARY%>";

data_header[9] = new Array;
data_header[9][0] = "Quantity"
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=QUANTITY %>";

data_header[10] = new Array;
data_header[10][0] = "Investigation Type"
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=INVESTIGATION_TYPE %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=CHANGED_DATE%>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=CHANGED_TIME%>";

data_header[13] = new Array;
data_header[13][0] = "Collection"
data_header[13][1] = "data";
data_header[13][2] = "14%";
data_header[13][3] = "<%=COLLECTION_CENTER_ID %>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "14%";
data_header[14][3] = "<%=LIONC_CODE %>";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = "14%";
data_header[15][3] = "<%=RARE_COMMON %>";

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = "14%";
data_header[16][3] = "<%=MIN_NORMAL_VALUE %>";

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = "14%";
data_header[17][3] = "<%=MAX_NORMAL_VALUE %>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = "14%";
data_header[18][3] = "variation";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = "14%";
data_header[19][3] = "<%=BLOOD_BANK_SCREEN %>";


data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = "14%";
data_header[20][3] = "<%=BLOOD_REACTION_TEST %>";

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = "";
data_header[21][3] = "subChrg";

data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = "";
data_header[22][3] = "mainChrge";

data_header[23] = new Array;
data_header[23][0] = "Status"
data_header[23][1] = "data";
data_header[23][2] = "14%";
data_header[23][3] = "<%=STATUS%>";

data_header[24] = new Array;
data_header[24][0] = "Remark"
data_header[24][1] = "data";
data_header[24][2] = "14%";
data_header[24][3] = "<%=REMARKS%>";


data_header[25] = new Array;
data_header[25][0] = "phInvestigation"
data_header[25][1] = "hide";
data_header[25][2] = "14%";
data_header[25][3] = "phInvestigation";

data_header[26] = new Array;
data_header[26][0] = "Short Name"
data_header[26][1] = "data";
data_header[26][2] = "14%";
data_header[26][3] = "invShortCode";


data_arr = new Array();
<% 
	Iterator itrCC=searchInvestigationList.iterator();
        int  counter=0;
          while(itrCC.hasNext())
           {
             DgMasInvestigation  dgmasInvestigation = (DgMasInvestigation)itrCC.next(); 
%>

		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] = <%= dgmasInvestigation.getId()%>
		<%
		
		 StringBuffer output_str1 = new StringBuffer();
		 StringTokenizer s1 = new StringTokenizer(dgmasInvestigation.getInvestigationName().toString(),"\""); 

		 while (s1.hasMoreTokens())
		 {
		 output_str1.append(s1.nextToken());
		 if (s1.hasMoreTokens())
		 {
		 output_str1.append("\\");
		 output_str1.append("\"");
		 }
		 }
		%>
		data_arr[<%= counter%>][1] = "<%= dgmasInvestigation.getInvestigationName()%>";

		<%
		Iterator itrGridMainChargeCodeList=gridMainChargecodeList.iterator();
		while(itrGridMainChargeCodeList.hasNext())
            {
			 try
			 {
             MasMainChargecode  mainChargecodeGrid = (MasMainChargecode)itrGridMainChargeCodeList.next(); 
			 if(dgmasInvestigation.getMainChargecode().getId().equals(mainChargecodeGrid.getId()) && mainChargecodeGrid.getStatus().equalsIgnoreCase("y"))
			 {
			 %>
				data_arr[<%= counter%>][2] = "<%=mainChargecodeGrid.getMainChargecodeName()%>"
			<%
			}
			 else if(dgmasInvestigation.getMainChargecode().getId().equals(mainChargecodeGrid.getId()) && mainChargecodeGrid.getStatus().equalsIgnoreCase("n"))
			{
			%>
			data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=mainChargecodeGrid.getMainChargecodeName()%>";
			<%
			}
           }
			catch(Exception e)
			{
				e.printStackTrace();
			} 
			} %>		

		<%
		Iterator itrGridSubChargeCodeList=gridSubChargecodeList.iterator();
		 while(itrGridSubChargeCodeList.hasNext())
            {
			 try
			 {
             MasSubChargecode  subChargecodeGrid = (MasSubChargecode)itrGridSubChargeCodeList.next(); 
			 if(dgmasInvestigation.getSubChargecode().getId().equals(subChargecodeGrid.getId()) && subChargecodeGrid.getStatus().equalsIgnoreCase("y"))
			 {
			 %>
				data_arr[<%= counter%>][3] = "<%=subChargecodeGrid.getSubChargecodeName()%>"
			<%
			}
			 else if(dgmasInvestigation.getSubChargecode().getId().equals(subChargecodeGrid.getId()) && subChargecodeGrid.getStatus().equalsIgnoreCase("n"))
			{
			%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=subChargecodeGrid.getSubChargecodeName()%>";
			<%
			}
           		}
			catch(Exception e)
			{
				e.printStackTrace();
			} 
			}%>
		<%
		Iterator itrGridChargeCodeList=gridChargeCodeList.iterator();
		 while(itrGridChargeCodeList.hasNext())
            {
			 try
			 {
			 MasChargeCode  chargeCodeGrid = (MasChargeCode)itrGridChargeCodeList.next(); 
			
			 StringBuffer output_str = new StringBuffer();
			 StringTokenizer s = new StringTokenizer(chargeCodeGrid.getChargeCodeName().toString(),"\""); 

			 while (s.hasMoreTokens())
			 {
			 output_str.append(s.nextToken());
			 if (s.hasMoreTokens())
			 {
			 output_str.append("\\");
			 output_str.append("\"");
			 }
			 }
			
			 if(dgmasInvestigation.getChargeCode().getId().equals(chargeCodeGrid.getId()) && chargeCodeGrid.getStatus().equalsIgnoreCase("y"))
			 {
			 %>
				data_arr[<%= counter%>][4] = "<%=output_str.toString()%>"
			<%
			}
			 else if(dgmasInvestigation.getId().equals(chargeCodeGrid.getId()) && chargeCodeGrid.getStatus().equalsIgnoreCase("n"))
			{
			%>
			data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=output_str.toString()%>";
			<%
			}
           }
			catch(Exception e)
			{
				e.printStackTrace();
			} }
			%>
			
			<%
			Iterator itrGridSampleList=gridSampleList.iterator();
			try
			 {
			 while(itrGridSampleList.hasNext())
            {
			 MasSample  sampleGrid = (MasSample)itrGridSampleList.next(); 
             if(dgmasInvestigation.getSample() != null && !dgmasInvestigation.getSample().equals("")){
            	if(dgmasInvestigation.getSample().getId().equals(sampleGrid.getId()) && sampleGrid.getStatus().equalsIgnoreCase("y"))
			 {
			 %>
				data_arr[<%= counter%>][5] = "<%=sampleGrid.getSampleDescription()%>"
			<%
			}
			 else if(dgmasInvestigation.getSample().getId().equals(sampleGrid.getId()) && sampleGrid.getStatus().equalsIgnoreCase("n"))
			{
			%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=sampleGrid.getSampleDescription()%>";
			<%	}
            		}
           else{
           %>
           data_arr[<%= counter%>][5] = "-"
           <%}}}
			catch(Exception e)
			{
				e.printStackTrace();
			} %>
	
			<%if (dgmasInvestigation.getNormalValue() != null){%>
			data_arr[<%= counter%>][6] ="<%= dgmasInvestigation.getNormalValue()%>"
			<%}else{%>
			data_arr[<%= counter%>][6] =""
			<%}%>
			
			<%
			Iterator itrGridUomList=gridUnitOfMeasurementList.iterator();
			try
			 {
			 while(itrGridUomList.hasNext())
            {
			 DgUom  uomGrid = (DgUom)itrGridUomList.next(); 
             if(dgmasInvestigation.getUom() != null && !dgmasInvestigation.getUom().equals("")){
            	if(dgmasInvestigation.getUom().getId().equals(uomGrid.getId()) && uomGrid.getStatus().equalsIgnoreCase("y"))
			 {
			 %>
				data_arr[<%= counter%>][7] = "<%=uomGrid.getUomName()%>"
			<%
			}
			 else if(dgmasInvestigation.getUom().getId().equals(uomGrid.getId()) && uomGrid.getStatus().equalsIgnoreCase("n"))
			{
			%>
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=uomGrid.getUomName()%>";
			<%	}
            		}
           else{
           %>
           data_arr[<%= counter%>][7] = "-"
           <%}}}
			catch(Exception e)
			{
				e.printStackTrace();
			} %>
		
			data_arr[<%=counter%>][8] ="<%=dgmasInvestigation.getConfidential()%>"
						
			<%
				if(dgmasInvestigation.getAppearInDischargeSummary() != null)
				{
			%>
					data_arr[<%=counter%>][9] ="<%=dgmasInvestigation.getAppearInDischargeSummary()%>"
			<%	}
				else
				{
			%>
					data_arr[<%= counter%>][9] = ""
			<%
				}
			%>
			
			
			<%if(dgmasInvestigation.getQuantity() != null){
			%>
			data_arr[<%= counter%>][10] = "<%=dgmasInvestigation.getQuantity()%>"
			<%}else{%>
			data_arr[<%= counter%>][10] = ""
			<%}%>
			
			<%if(dgmasInvestigation.getInvestigationType() != null){%>
			data_arr[<%= counter%>][11] = "<%=dgmasInvestigation.getInvestigationType()%>"
			<%}else{%>
			data_arr[<%= counter%>][11] = ""
			<%}%>
			
			data_arr[<%= counter%>][12] = "<%= HMSUtil.convertDateToStringWithoutTime(dgmasInvestigation.getLastChgDate()) %>"
			data_arr[<%= counter%>][13] = "<%=dgmasInvestigation.getLastChgTime()%>"
			
			<%
			Iterator itrGridCollectionList=gridCollectionList.iterator();
			try
			 {
			 while(itrGridCollectionList.hasNext())
            {
				 DgMasCollection  collectionGrid = (DgMasCollection)itrGridCollectionList.next(); 
             if(dgmasInvestigation.getCollection() != null && !dgmasInvestigation.getCollection().equals("")){
            	if(dgmasInvestigation.getCollection().getId().equals(collectionGrid.getId()) && collectionGrid.getStatus().equalsIgnoreCase("y"))
			 {
			 %>
				data_arr[<%= counter%>][14] = "<%=collectionGrid.getCollectionName()%>"
			<%
			}
			 else if(dgmasInvestigation.getCollection().getId().equals(collectionGrid.getId()) && collectionGrid.getStatus().equalsIgnoreCase("n"))
			{
			%>
				data_arr[<%= counter%>][14] = "<font id='error'>*</font>Parent InActivated--<%=collectionGrid.getCollectionName()%>";
			<%	}
            		}
           else{
           %>
           data_arr[<%= counter%>][14] = "-"
           <%}}}
			catch(Exception e)
			{
				e.printStackTrace();
			} %>
			
		
			
			<%if(dgmasInvestigation.getLoincNum()!=null){%>
				data_arr[<%= counter%>][15] = "<%=dgmasInvestigation.getLoincNum().getComponent()%>"
			<%}else{%>
			data_arr[<%= counter%>][15]="aaa"
			
			<%}%>
		
			data_arr[<%= counter%>][16] = "<%=dgmasInvestigation.getRareCommon()%>"
			
			<%if(dgmasInvestigation.getMinNormalValue() != null){%>
			data_arr[<%= counter%>][17] = "<%=dgmasInvestigation.getMinNormalValue()%>"
			<%}else{%>
			data_arr[<%= counter%>][17] = ""
			<%}%>
			
			<%if(dgmasInvestigation.getMaxNormalValue() != null){%>
			data_arr[<%= counter%>][18] = "<%=dgmasInvestigation.getMaxNormalValue()%>"
			<%}else{%>
			data_arr[<%= counter%>][18] = ""
			<%}%>
			
			<%if(dgmasInvestigation.getVariationRequired() != null){%>
			data_arr[<%= counter%>][19] = "<%=dgmasInvestigation.getVariationRequired()%>"
			<%}else{%>
			data_arr[<%= counter%>][19] = ""
			<%}%>
			<% 
			if(dgmasInvestigation.getBloodBankScreenTest() !=null && dgmasInvestigation.getBloodBankScreenTest().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][20] = "<%=dgmasInvestigation.getBloodBankScreenTest()%>"
			<%}else{%>
			data_arr[<%= counter%>][20] = ""
			<%}%>
			<%if(dgmasInvestigation.getBloodReactionTest() !=null && dgmasInvestigation.getBloodReactionTest().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][21] = "<%=dgmasInvestigation.getBloodReactionTest()%>"
			<%}else{%>
			data_arr[<%= counter%>][21] = ""
			<%}%>
			data_arr[<%=counter%>][22] = "<%=dgmasInvestigation.getSubChargecode().getId() %>";
			data_arr[<%=counter%>][23] = "<%=dgmasInvestigation.getMainChargecode().getId() %>";
		

			<%if(dgmasInvestigation.getStatus() !=null && dgmasInvestigation.getStatus().equalsIgnoreCase("y")){ %>
					data_arr[<%= counter%>][24] = "Active"
					<%}else{%>
					data_arr[<%= counter%>][24] = "InActive"
			<%}%>
			<%if(dgmasInvestigation.getRemark() !=null){ %>
			data_arr[<%= counter%>][25] = "<%=dgmasInvestigation.getRemark()%>"
			<%}else{%>
			data_arr[<%= counter%>][25] = ""
	<%}%>
	

	<%if(dgmasInvestigation.getPhLab() != null){%>
	data_arr[<%= counter%>][26] = "<%=dgmasInvestigation.getPhLab()%>"
	<%}else{%>
	data_arr[<%= counter%>][26] = ""
	<%}%>
	<%if(dgmasInvestigation.getInvestigationShortCode() != null){%>
	data_arr[<%= counter%>][27] = "<%=dgmasInvestigation.getInvestigationShortCode()%>"
	<%}else{%>
	data_arr[<%= counter%>][27] = ""
	<%}%>
	
			<%
		     counter++;
			}
			%>

formName = "chargeCode"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');			
</script>
<script type="text/javascript">
   <% 
   		if(pageNoTempFromBackButton > 1){ %>
   				goToPageLocal('<%=pageNoTempFromBackButton%>');
	
<%	}
   %>
	
</script>