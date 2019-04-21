<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * attach_admission.jsp  
 * Purpose of the JSP -  Back data diagnosis entry in DISCHARGE.
 * @author  Vivek
 * Create Date: 31st July,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.13  
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDisposedTo"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.MasCareType"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasDischargeStatus"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>
function getDischargeDetails2(hinNo){
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
		obj =document.getElementById("adNoId"); 
		obj.length = 1;
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var brandLength  = item.getElementsByTagName("adLists")[0];
	      
        	for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
        		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("adId")[0];
	        	var brandName  = brand.getElementsByTagName("adNo")[0];
	        	obj.length++;
				obj.options[obj.length-1].value=brandId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=brandName.childNodes[0].nodeValue;
	        	
        	}
      	} 
      }
    }
   var url="/hms/hms/adt?method=getDischargeDetails&hinNo="+hinNo;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    
    

}

<%
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
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<script type="text/javascript">
function openPopupWindow()
{
 var url="/hms/hms/adt?method=showICDSearchJsp";
 newwindow=window.open(url,'name',"left=100,top=100,height=400,width=1024,status=1,scrollbars=1,resizable=0");
}
function openSearchPopup()
{
 var url="/hms/hms/adt?method=showSearchPopup";
 newwindow=window.open(url,'name',"left=100,top=100,height=500,width=950,status=1,scrollbars=1,resizable=0");
}

function jsSetIcdData(icd_no)
{
document.getElementById("icdCode").value=icd_no;
document.getElementById("icdCode").focus();
}
function setServiceNo(serviceNo)
{
document.getElementById("hinNo").value=serviceNo;
document.getElementById("hinNo").focus();
}
</script>


<form name="updateDischarge" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 26 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="titleBg">
<h2>Update Discharge</h2>
</div>
<div class="clear"></div>
<div clas="paddingTop15"></div>
<h4>Details</h4>
<div class="clear"></div>
<div class="Block"><%--
	<label class="bodytextB">Service No :</label>
	<input type="text" class="textbox_size20" name="" value="" onblur="getDischargeDetails(this.value);" id="serviceNoId" />
	<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;" onClick="javascript:openSearchPopup();" >
	--%> <label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text"
	onblur="getDischargeDetails2(this.value);" id="hinNo" class="date" />
<img src="/hms/jsp/images/search.gif" width="24" height="20"
	onClick="javascript:openSearchPopup();" id="hinNo" />

<div class="clear"></div>

<label class="medium"><span>*</span> <%=prop.getProperty("com.jkt.hms.ipd_no") %> </label> <select
	name="<%=INPATIENT_ID %>" id="adNoId"
	onchange="if(getAdNo()){getDetailsOfDischarge(this.value)}" id="adNoId">
	<option value="0">Select</option>
</select> <%--
	<label class="bodytextB">Service Name</label>
--%> <input id="sName" readonly="readonly" type="hidden" /> <label
	class="medium">Pt. Name</label> <input id="pName" readonly="readonly"
	class="readOnly" value="-" /> <label class="medium">DOA </label> <input
	id="doa" readonly="readonly" class="readOnly" value="-" /> <label
	class="medium">Relation </label> <input id="relation"
	readonly="readonly" class="readOnly" />

<div class="clear"></div>

<label class="medium">Age</label> <input id="age" readonly="readonly"
	class="readOnly" value="-" /> <label class="medium">Sex</label> <input
	id="sex" readonly="readonly" class="readOnly" value="-" /> <input
	id="hinId" name="hinId" type="hidden"><input type="hidden"
	name="admissionNo" value="1" id="admissionNo" /> <label class="medium">Date
of Discharge</label> <input type="text" name="<%=DISCHARGE_DATE%>" value=""
	id="dDate" readonly="readonly" validate="Date of Discharge,date,yes"
	class="date" /> <img id="doiCardImgId" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date" tabindex="1"
	onclick="javascript:setdate('',document.updateDischarge.<%=DISCHARGE_DATE%>,event)" />

<label class="medium">Time of Discharge</label> <input type="text"
	name="<%=DISCHARGE_TIME%>" value="" id="dTime"
	onKeyUp="mask(this.value,this,'2,5',':');"
	onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" />

<div class="clear"></div>

<label class="medium">Diagnosis</label> <label id="diagnosisId"
	class="valueAuto"></label>

<div class="clear"></div></div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Diagnosis</h4>
<div class="clear"></div>
<div class="Block"><label class="medium">Z03</label> <input
	type="checkbox" name="<%=Z03 %>" class="radioCheck" value="z03"><label
	class="medium">Z09</label> <input type="checkbox" name="<%=Z09%>"
	class="radioCheck" value="z09" id="Z09"><label class="medium">Icd
Code</label> <input name="" value="" type="text" id="icdCode" onblur="getIcd();" />
<input name="" value="" id="temp" type="hidden" /> <IMG
	SRC="/hms/jsp/images/search.gif" WIDTH="24" HEIGHT="20"
	onClick="javascript:openPopupWindow();"
	title="Click here to Search ICD Codes" />
<div class="clear"></div></div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" class="buttonDel" value=" "
	onclick="removeRowForUpdateDischarge(this,'tblSample');" align="right" />
<input type="button" class="buttonAdd" value=" " onclick="addRow();"
	align="right" />
	<input type="hidden" value="" name="icdCounter" id="icdCounter"/>


<table width="100%" id="tblSample" cellpadding="0" cellspacing="0">
	<tr>
		<td><input type="checkbox" name="checkbox" id="checkbox" value=""
			class="radioCheck" /></td>
		<td>Icd Name 1</td>
		<td width="10%"><input type="text" align="right" name="icd"
			id="icd" class="largeFltLeft" />
		<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('icd','ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'});
</script></td>
	</tr>

</table>

<input type="hidden" name="deptId" value="0" id="deptId" /> <input
	type="hidden" name="hdb" value="1" id="hdb" /> <input type="hidden"
	name="dId" value="0" id="dId" />
<div class="clear"></div>
<div class="division"></div>
<input id="dischargeAddId" type="button" name="Update" value="Update"
	class="button"
	onClick="if(validateUpdateDischarge()){submitForm('updateDischarge','/hms/hms/adt?method=updateDischarge');}" />
<input id="dischargeAddId" type="button" name="Submit" value="Reset"
	class="buttonHighlight"
	onClick="submitForm('updateDischarge','/hms/hms/adt?method=oldDischargeEntry');" />
</form>
<div class="clear"></div>
<div class="division"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">


function getIcd(){

 //=========To get Icd String with icd code==========================
var icdCode =document.getElementById("icdCode").value
 if(icdCode !="")
  {
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
	         icdString  = item.getElementsByTagName("icdString")[0];
	         	
	        if(icdString.childNodes[0].nodeValue){
	        	document.getElementById("temp").value =icdString.childNodes[0].nodeValue
	        }
	       }
      }
      }
    var url="/hms/hms/adt?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  
  }
  //==================End of Icd String block======================
}
function addRow(){
var icdString =document.getElementById("temp").value;


if(document.getElementById("Z09").checked == true && icdString !="NO" && icdString !=""){
	icdString =icdString +"{OLD}"
}

if(icdString !="NO"){
if(document.getElementById("icd").value==""){
	document.getElementById("icd").value =icdString
	document.getElementById("temp").value =""
	document.getElementById("icdCode").value =""
	return false;
	}
}else{
alert("ICD Code does not exists...!")
  		document.getElementById("icdCode").value =""
  		document.getElementById("temp").value =""
  		return true
}

	if(icdString != "NO"){
		var icdCounter=0;
		//alert(document.getElementById("icdCounter").value);
		icdCounter=	document.getElementById("icdCounter").value;
		if(icdCounter==""){
			icdCounter=2;
		}else{
			icdCounter=parseInt(icdCounter)+1;
		}
		document.getElementById("icdCounter").value=icdCounter;
  var tbl = document.getElementById('tblSample');
  var lastRow = tbl.rows.length;
  // if there's no header row in the table, then iteration = lastRow + 1
  var iteration = lastRow;
  var row = tbl.insertRow(lastRow);
  var hdb = document.getElementById('hdb');
  hdb.value=iteration
  iteration=lastRow+1;
  var cellRight2 = row.insertCell(0);
  var e2 = document.createElement('input');
  e2.type = 'checkbox';
  e2.className= 'radioCheck'
  cellRight2.appendChild(e2);
  
  var cellRight0 = row.insertCell(1);
  var e0 = document.createElement('label');
  e0.type = '';
  e0.innerHTML = 'Icd Name '+icdCounter+'';
  e0.className = ''
  cellRight0.appendChild(e0);
  
   var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.name = 'icd' + iteration;
	  sel.id = 'icd' + iteration;
	  sel.type = 'text';
	  sel.value =icdString;
	  sel.className = 'largeFltLeft'
	  cellRightSel.appendChild(sel);
	  new Ajax.Autocompleter('icd'+iteration,'ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'+iteration});
  cellRightSel.appendChild(sel);
  document.getElementById("icdCode").value =""
  document.getElementById("temp").value =""
  
  
  
  }else{
  		alert("ICD Code does not exists...!")
  		document.getElementById("icdCode").value =""
  		document.getElementById("temp").value =""
  		return true
  }
    
}
function check(){
alert("@#@!#@")
}
function removeRowForUpdateDischarge(argIndex,idName){
	
	         var table=document.getElementById(idName);
	         var tblRows  = table.getElementsByTagName("tr");
	         var check=0;
	         
	         for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	         
	         
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked)
	                              check=check+1;
	                   }
	               }
	        }
			
	        for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	         
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked)
	                              document.getElementById(idName).deleteRow(i);
	                   }
	               }
	        }
     }
function getOtherHospitalTextBox(disposalId){

if(disposalId == 12){
	document.getElementById('otherHospitalId').style.display = 'inline';
}else{
	document.getElementById('otherHospitalId').style.display = 'none';
return true;
}
}
function getAdNo(){
var obj = document.getElementById("adNoId");
var val = obj.value;
for(i=0;i<obj.length;i++)
{
	if(obj.options[i].value == val)
	{
		admissionNo = obj.options[i].text
		break;
	}
}
document.getElementById("admissionNo").value =admissionNo
return true
}

function validateUpdateDischarge(){
var errMsg ="";
if(document.getElementById("hinNo").value ==""){
	errMsg ="Please fill <%=prop.getProperty("com.jkt.hms.registration_no") %> ...!\n"
}
if(document.getElementById("adNoId").value =="0"){
	errMsg =errMsg+"Please select <%=prop.getProperty("com.jkt.hms.ipd_no") %> ...!\n"
}
if(errMsg ==""){
	return true
}else{

alert(errMsg)
return false
}
}
</script>
