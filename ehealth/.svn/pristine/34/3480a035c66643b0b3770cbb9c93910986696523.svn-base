<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="java.util.List"%>
	<%@ page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
	<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
	<%@ page import="static jkt.hms.util.RequestConstants.MOBILE_NO"%>
	<%@ page import="static jkt.hms.util.RequestConstants.P_FULL_NAME"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UHID Conversion</title>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

<div class="titleBg"><h2>UHID Conversion</h2></div>
<script >
function getUhidNumber(){
	
	var uhidNo=document.getElementById("rdId").value;
	
	document.getElementById("tuhid").value=uhidNo;	
}
</script>

<div class="clear"></div>
<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
Map<Integer,String> searchAddress = new HashMap<Integer,String>();
List<Visit> visitDetails=new ArrayList<Visit>();
	List<Patient> searchDataList=null;
searchDataList=new ArrayList<Patient>();
Map<String, Object> getDataMap = null;
%>
<form name="Uhidsearch" method="post">
<div class="Block" style="padding-bottom: 0;">
	<label>Temp. UHID</label> 
	<input type="text" name="<%=HIN_NO%>" value="" maxlength="30" tabindex="1" validate="Hin No,metachar,no" onkeypress="return searchKeyPress(event);"/>
	<label>Mobile No</label> 
	<input type="text" name="<%=MOBILE_NO %>" value="" maxlength="10" tabindex="1" onkeypress="return searchKeyPress(event);" />
	<label>Patient Name</label> 
	<input type="text" value="" name="<%=P_FULL_NAME %>" tabindex="1"
		maxlength="50" onkeypress="return searchKeyPress(event);" />

	<div id="searchbar">
		<div id="edited"></div>
		<input type="button" name="Submit11" id="uhidConverSearch"
		onClick="submitForm('Uhidsearch','/hms/hms/registration?method=showSearchPatientRecordsJsp&UIDCOnver=UIDCOnver&'+csrfTokenName+'='+csrfTokenValue)" 
		value="Search" tabindex="1"
			class="buttonl" />
	</div>
	<input type="button" class="button" value="QR Scan" tabindex="1" onclick="aadhaarQr()"/>
	<input type="button" class="button" value="eKyc" tabindex="1" onclick="displayeKYC()"/>
</div>
<div class="Block" style="padding-top:0;">
	<% 
	String department="";
	String doctor="";
	String hospital="";
	String visitDate="";
	
	String patientAge="";
	String mobileNo="";
	String gender="";
	
	if(null!=map.get("Searchmap")){

		 getDataMap=(Map<String, Object>)map.get("Searchmap");
		 if(null!=getDataMap.get("searchDataList")){
			 searchDataList=(List<Patient>)getDataMap.get("searchDataList");
			 searchAddress=(Map<Integer,String>)getDataMap.get("searchAddress");
			 visitDetails=(List<Visit>)getDataMap.get("visitDetails");
			
			  }
		 if(visitDetails!=null && visitDetails.size()>0){
			 for(Visit v:visitDetails){
				 if(null!=v.getDoctor())
				 department=v.getDepartment().getDepartmentName();
				 if(null!=v.getDoctor())
				 doctor=v.getDoctor().getEmployeeName();
				 if(null!=v.getHospital())
				 hospital=v.getHospital().getHospitalName();
				 if(null !=v.getVisitDate())
				 visitDate=HMSUtil.changeDateToddMMyyyy(v.getVisitDate()) ;
				 
			 }
		 }
		 
	if(null !=searchDataList && searchDataList.size()>0){%>
	
	<table align="" >
	<tr>
		<th></th>
		<th>Temp UHID</th>
		<th>Patient Name</th>
		<th>Age</th>
		<th>Gender</th>
		<th>Mobile No.</th>
		<th>Address</th>
	</tr>
	
	<% 
		
		for(Patient patient:searchDataList){
			if(null!=patient.getAge()){
				patientAge=patient.getAge();
			}
			if(null!=patient.getMobileNumber()){
				mobileNo=patient.getMobileNumber();
			}
			if(null!=patient.getSex()){
				gender=patient.getSex().getAdministrativeSexName();
			}
			
			
			%>
<tr>
<td onclick="HighLightTR(this)"><input type="radio" tabindex="1" id="rdId" name="rd" value="<%=patient.getId()%>" 
onclick="ajaxFunctionForuhidConversion('<%=patient.getId()%>');"/></td>
<td><%=patient.getHinNo()%></td>
<td><%=patient.getPFirstName()%></td>
<td><%=patientAge%></td>
<td><%=gender%></td>
<td><%=mobileNo%></td>
<td><%=(String)searchAddress.get(patient.getId())%></td>
</tr>
<tr>
<%
		}
		}
	}
%>
</table>
<div class="clear"></div>

<div class="clear"></div>

<div class="division"></div>
<div id="ekycId" style="display:none">
<label>Aadhaar</label>
<input type="text" name="ekycAAdhar" value="" validate="Adhar,int,no" maxlength="12"/>
<input type="button" name="Search" value="Search">
</div>

<div class="clear"></div>
<h4> OP visit details</h4>
<div class="clear"></div>
<input type="hidden" id="patienthinId" name="patienthinIdName" value="" readonly="readonly" tabindex="1"/>
<label>Visit Date</label>
<input type="text" id="visitdateId" value="" readonly="readonly" tabindex="1" 
validate="Visit Date,date,no"/>

<label>Hospital</label>

<input type="text" id="hospId" value="" readonly="readonly" tabindex="1" validate="Hospital,metachar,no"/>

<label>Doctor</label>
<input type="text" id="docId" value="" readonly="readonly" tabindex="1" validate="Doctor,metachar,no"/>

<div class="clear"></div>
<h4> IP Episodes</h4>

<label>From Date</label>
<input type="text" id="fromdateId" name="fromdate" maxlength="30"tabindex="1" 
validate="From Date,date,no" />


<label>To Date</label>
<input type="text" id="todateId" name="todate" maxlength="30"tabindex="1" 
validate="To Date,date,no" />
<label>Department</label>
<input type="text" id="departmentId" name="departmentName" maxlength="30"tabindex="1"  validate="Department,metachar,no"/>
<div class="division"></div>

	<label>Temp UHID<span>*</span></label> <input type="text" id="tuhid" value=""
	 name="tempUhid" maxlength="30" readonly="readonly" tabindex="1" />
	
	<label>Aadhar No.<span>*</span></label> <input type="text" id="aadharId" value=""
	 name="aadharNumber" tabindex="1" maxlength="12" validate="Adhar Number,int,no" />
	<div class="clear"></div>
	<div id="searchbar">
	<div id="edited"></div>
	<input type="button" name="Submit" value="Convert" tabindex="1" class="buttonl"
	onClick="if(checkTemporaryUhid()){if(checkAadharNo()){if(checkAadharNoLenght()){if(displayAlertMessage()){submitForm('Uhidsearch','/hms/hms/registration?method=uhidConversion&'+csrfTokenName+'='+csrfTokenValue)}}}}" />
	</div>	
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
function checkTemporaryUhid(){
	var tuhid=document.getElementById('tuhid').value
	if(tuhid==""){
		alert("Please select the Temporary UHID")
		return false;
	}
	else{
		return true;
	}
	
}
function checkAadharNo(){
	var aadhaarNo=document.getElementById('aadharId').value
	if(aadhaarNo==""){
		alert("Aadhaar No. field cannot be blank")
		return false;
	}
	else{
		return true;
	}
	
}
function checkAadharNoLenght(){
	var aadhaarNo=document.getElementById('aadharId').value
	if(aadhaarNo.length==11){
		alert("Aadhaar No. should be 12 Digits")
		return false;
	}
	else{
		return true;
	}
	
}

function displayAlertMessage(){
	
	    if (confirm("Do you want to continue ?") == true) {
	    	return true	       
	    } else {
	       return false;
	    }	   	
}

</script>
<script type="text/javascript">
function aadhaarQr(){
	document.getElementById('ekycId').style.display='none';

    var aadhaarData= prompt("Pick Your Aadhar Details:","");
    if(aadhaarData != null && aadhaarData != ""){
    data = aadhaarData.replace('</?xml version="1.0" encoding="UTF-8"?>','');
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
    var relName=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('co').toString();  
    var dob = xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('dob');
    dob1=dob.replace('-','/');
    dob2=dob1.replace('-','/');
    alert(dob2)
    document.getElementById("dobId").value=dob2;
    var relName1=relName.replace('/','');
    var rel=relName1.substring(0,1).trim();
    if(rel=='S'){
    	document.getElementById("relId").value=2;
    }else if(rel=='D'){
    	document.getElementById("relId").value=3;
    }else if(rel=='W'){
    	document.getElementById("relId").value=11;
    }else{
    	document.getElementById("relId").value=0;
    }
    var rel1=relName1.substring(4,100).trim();
    document.getElementById("relativeNameId").value=rel1;
    
    var gender=xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('gender');
    if(gender=="MALE"){
            document.getElementById("gender").value = 3;
            document.getElementById("titleId").value = 1;
    }else{
            document.getElementById("gender").value = 2;
            document.getElementById("titleId").value = 2;
    }
    
    var add = xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('co') +  ", " +
    xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('lm') +  ", " +
    xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('loc') +  ", " +
    xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('vtc') +  ", " +
    xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('po') +  ", " +
    xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('dist') +  ", " +
    xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('state') +  ", " +
    xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('pc');
    document.getElementById("addr").value = add;
    document.getElementById("nokAddr").value = add;
   
    var state = document.getElementById("stateId");
    var stateData = xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('state').toString();
    if(state.length != 0){
           for(var i=0;i<state.length;i++){
                   var st1 = state[i].innerHTML.trim().toLowerCase();
                   var st2 = stateData.toLowerCase();
                   if(st1 == st2){
                           document.getElementById("stateId").selectedIndex = i;
                           break;
                   }else{document.getElementById("stateId").selectedIndex = 0;}
           }
    }
    var dist = document.getElementById("cityId");
    var distData = xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('dist').toString();
    if(dist.length != 0){
           for(var i=0;i<dist.length;i++){
                   var st1 = dist[i].innerHTML.trim().toLowerCase();
                   var st2 = distData.toLowerCase();
//                     alert((st1==st2)+"\n"+(st1+"==="+st2)+"\n"+st1.length+"=="+st2.length+"=="+i);
                   if(st1 == st2){
                           document.getElementById("cityId").selectedIndex = i;
                           break;
                   }else{document.getElementById("cityId").selectedIndex = 0;}
           }
    }
   
    document.getElementById("pinCodeId").value = xmlDoc.getElementsByTagName("PrintLetterBarcodeData")[0].getAttribute('pc');
}
}

function displayeKYC(){
	document.getElementById('ekycId').style.display='block';
}


function searchKeyPress(e)
{
    // look for window.event in case event isn't passed in
    e = e || window.event;
    if (e.keyCode == 13)
    {
        document.getElementById('uhidConverSearch').click();
        return false;
    }
    return true;
}

</script>
