<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
 
<link type="text/css" rel="stylesheet" href="/hms/jsp/js/jquery-ui.css" />
<script type="text/javascript" src="/hms/jsp/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-ui.js"></script>
<title>Physical Examination</title>

<!-- <script type="text/javascript">
$(function() {
$('#btnclick').click(function() {
$("#popupdiv").dialog({
title: "Temporarily Deferred Due To",
width: 430,
height: 250,
modal: true,
buttons: {
Close: function() {
$(this).dialog('close');
}
}
});
});
})
</script> -->

<%-- <%@ include file="navigation.jsp"%> --%>
<%
List<MasStoreItem> bloodBagsList = new ArrayList<MasStoreItem>();
//List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
//List<StoreItemBatchStock> bagTypeList = new ArrayList<StoreItemBatchStock>();
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
 if(null !=map.get("bloodBagsList")){
	 
	bloodBagsList=(List<MasStoreItem>)map.get("bloodBagsList");
	
} 
/* if(null !=map.get("storeItemBatchStockList")){
	storeItemBatchStockList=(List<StoreItemBatchStock>)map.get("storeItemBatchStockList");
} */

%>

<div class="clear"></div>
<div class="titleBg">
<h2>Physical Examination</h2>
</div>
<body>
<form name="physicalExamination" method="post" >

<div class="clear"></div>

<div class="Block">

<div class="clear"></div>

<input type="hidden" 
	name="donorAssesstMid" value="${requestScope.map.donorAssesstMid}"  
	tabindex="1" validate="donorAssesstMid,metachar,no" />
<!-- <label> Height<span>*</span></label> 
<input type="text" 
	name="height" value="" validate="Height,int,yes" maxlength="5"
	tabindex="1" onkeypress="javascript:return isNumber (event)" />
	 <label >cm</label> 	
	  --> 
<label class="medium">Weight<span>*</span></label>
<input type="text"  name="weight" value="" id="weightId"
	validate="Weight,int,yes" maxlength="3" tabindex="1" onblur="checkWeight(this.value)" onkeypress="javascript:return isNumber (event)" /> 
	<label class="medium" >kg</label> 
	
	
	 <label class="medium">Temperature<span>*</span></label> <input
	type="text"  name="Temperature" value=""
	validate="Temp,float,yes" maxlength="5" tabindex="1" onkeypress="javascript:return isNumber (event)" /> 
	<label >°F</label> 
	
	<div class="clear"></div>
	
	<label >Pulse<span>*</span></label> <input
	type="text"  name="Pulse" value=""
	validate="Pulse,flat,yes" maxlength="6" tabindex="1" onkeypress="javascript:return isNumber (event)" /> 
	
	<label >Per Minute</label>
	<label  class="medium">Phlebotomy site</label>
 <select>
 	<option value="">Select</option>
 	<option value="">clear</option>
 	<option value="">tatoo</option>
 	
 </select> 
 
	
	<!-- <label>HB</label> 
	<input type="text"
	class="small" name="" value="" validate="HB/DL,float,no"
	maxlength="5" tabindex="1" /> <label class="small">gms %</label> 
	 -->
	<div class="clear"></div>
	<label class="medium">BP<span>*</span></label> 
	<input type="text"  name="Systolic" onkeypress="javascript:return isNumber (event)" placeholder="Systolic" value="" validate="BP,int,yes" maxlength="3"
	tabindex="1" />  
	<input type="text"  name="Diastolic" onkeypress="javascript:return isNumber (event)" value="" placeholder="Diastolic"  validate="BP,int,yes" maxlength="3"
	tabindex="1" /> 
	 <label >mm Hg</label> 




 <label  class="medium">Type Of Bag<span>*</span></label>
 <select id="bagTypeId" name="bagTypename" onchange="populateVolume(this.value)">
 	<option value="0">Select</option>
 	<%
 	if(null !=bloodBagsList && bloodBagsList.size()>0){
 		
 		for(MasStoreItem stock:bloodBagsList){%>
 		
 			<option value="<%=stock.getId()%>"><%=stock.getNomenclature()%></option>
 		<%}}%>
 </select> 
<%
 	if(null !=bloodBagsList && bloodBagsList.size()>0){
 		for(MasStoreItem stock:bloodBagsList){%>
 		
 			<input type="hidden" id="<%=stock.getId()%>" name="<%=stock.getId()%>" value="<%=stock.getBagQuantity()%>"/>
 		<%}}%>
 
<div class="clear"></div>
<label>Volume to be collected<span>*</span></label> 
<input type="text" name="volume" value="" id="collectedId" readonly="readonly"
	maxlength="50" tabindex="1" onkeypress="javascript:return isNumber (event)" validate="Volume,float,yes"/>
<label >ml</label>
 <input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" validate="noOfRecords,int no"/> <input type="hidden" name="pageNo" id="pageNo"
	value="" validate="pageNo,int,no"/>

<label class="medium">General</label> <input type="text" name="general" value=""
	maxlength="50" tabindex="1" validate="general,metachar,no" />

<div class="clear"></div>
<label>Hemoglobin</label>
<label><input type="radio" id="hemoYes"  class="radioCheckCol2" name="Hemoglobinv" onclick="ShowHideDiv()" value="Y" >Normal </label>
 <label><input type="radio" id="hemoNo" class="radioCheckCol2"  name="Hemoglobinv" onclick="ShowHideDiv()"value="N" >Low </label>
 <div id="lowHemoId" style="display: none">
 <input type="text" name="lowHemo" value=""/>
 </div>
 
 <div class="clear"></div>

<!-- <label>Expiry Date </label> 
<input type="text" class="date"
	id="lastDateId" name="" value=""
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.bloodDonationEntry.expiryDate,event)" />
 -->
<!-- <label><span>*</span> Collected By</label> <select id="collectedBy"
	name="" validate="Collected By,string,yes"
	tabindex="1">
	<option value="0">Select</option> -->
	<%-- <%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         				String empName= "" ;
				         				empName = masEmployee.getFirstName();
	if(masEmployee.getMiddleName() != null)
				         					empName = empName.concat(" ").concat(masEmployee.getMiddleName());
				         				if(masEmployee.getLastName() != null)
				         					empName = empName.concat(" ").concat(masEmployee.getLastName());
				         %> --%>
	<!-- <option value="">Select</option> -->
	<%-- <%		} }%> --%>
</select>


<%-- <div class="clear"></div>
<div id="popupdiv" title="Basic modal dialog" style="display: none">
<ul>
  <li type="square">Weight<45kg </li>
  <li type="square">Alcohol in Last 72 hours</li>
  <li type="square">Poor Vein</li>
</ul>

<label >Deffered Till Date</label> 

	<input type="text" class="date" id="BirthDateId" 
	name="<%=DATE_OF_BIRTH%>" readonly="readonly" value=""
	 MAXLENGTH="14" tabindex="1" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" onClick="setdate('',document.bloodDonationEntry.,event)" />
 
</div> --%>

<div class="clear"></div>



<div class="clear"></div>
<label><input type="radio" class="radioCheckCol2" name="status" value="Y" validate="status,metachar,no">Fit </label>

 <label><input type="radio" class="radioCheckCol2"  name="status" value="N" validate="status,metachar,no">Unfit </label>

<label>Remarks </label>  <textarea rows="10" cols="100" name="remark" validate="remark,metachar,no">

</textarea>
<div class="clear"></div>
<div class="division"></div>
<!-- <input type="button" id="btnclick" value="Show Modal Popup" /> -->	
	 <input type="button"
	class="buttonBig"  value="Submit"
	onclick="submitForm('physicalExamination','bloodBank?method=submitDonorDeferredStatus')"
	 accesskey="r"
	tabindex=1 />
	
	<input type="reset"
	class="buttonHighlight" name="Reset" id="reset" value="Reset"
	onclick="" accesskey="r"
	tabindex=1 />
<div class="clear"></div>
<div class="clear"></div>
<script>


function checkWeight(weight){
	//alert(itemId);
	if(weight<35){
		alert('Weight not valid')
	document.getElementById('weightId').value="";
	
	}
	
}

function populateVolume(itemId){
	//alert(itemId);
	if(itemId>0){
	var volume=document.getElementById(itemId).value;
	//alert(volume)
	if(volume !="null" && volume !=""){
	document.getElementById('collectedId').value=volume;
	}
	else{
		document.getElementById('collectedId').value="";
	}
	}
	else{
		document.getElementById('collectedId').value="";
	}
}
function ShowHideDiv() {
    var chkYes = document.getElementById("hemoYes");
    var hemoNo = document.getElementById("hemoNo");
    if(chkYes.checked){
    	document.getElementById("lowHemoId").style.display="none";
    }
    if(hemoNo.checked){
    	document.getElementById("lowHemoId").style.display="Block";
    }
   
}
 function isNumber(evt) {
        var iKeyCode = (evt.which) ? evt.which : evt.keyCode
        if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57)){
        	alert("Eneter only numeric value");
            return false;
        }

        return true;
    } 
</script>   
</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>