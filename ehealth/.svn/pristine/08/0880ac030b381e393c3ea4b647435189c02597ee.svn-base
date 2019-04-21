<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
<script src="/hms/jsp/js/bloodBank.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
</script>

<%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int BloodhdId=0;
	int hinId=0;
	String ipNumber="";
	String orderSeqNo="";
	
	int inPatientId=0;
	
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
	
	
	if (request.getAttribute("map") != null && map.get("orderSeqNo")!=null) {
		orderSeqNo = (String) map.get("orderSeqNo");
		}
	
	if (request.getAttribute("map") != null && map.get("hinId")!=null) {
		hinId = (Integer) map.get("hinId");
		}
	

	if ( map.get("ipNumber")!=null) {
		ipNumber = (String) map.get("ipNumber");
		}
	
	if (request.getAttribute("map") != null && map.get("inPatientId")!=null) {
		inPatientId = (Integer) map.get("inPatientId");
		}
	
		/* if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		} */
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		if(map.get("pageNo") != null){
			pageNo=(Integer)map.get("pageNo");
		}
		List<Patient> patientList = new ArrayList<Patient>();
		
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
	
		if(map.get("BloodhdId") != null){
			BloodhdId=(Integer)map.get("BloodhdId");
		}
		List<MasBloodGroup> componentList=new ArrayList<MasBloodGroup>();
		
		if(map.get("componentList") != null){
			componentList=(List<MasBloodGroup>)map.get("componentList");
		}
		
		List<MasHospital> bloodBankList=new ArrayList<MasHospital>();
		if(map.get("bloodBankList") != null){
			bloodBankList=(List<MasHospital>)map.get("bloodBankList");
		}
		int totalTransfussionCount=0;
		if(map.get("totalTransfussionCount") != null){
			totalTransfussionCount=(Integer)map.get("totalTransfussionCount");
		}
		String transfussionDate="";
		if(map.get("totalTransfussionCount") != null){
			transfussionDate=(String)map.get("transfussionDate");
		}
		String transfussionTime="";
		if(map.get("transfussionTime") != null){
			transfussionTime=(String)map.get("transfussionTime");
		}
		int visitId=0;
		if((Integer)map.get("visitId") != null){
			visitId=(Integer)map.get("visitId");
		}
		
%>


<form name="bloodEntry" method="post" action="">
<div class="titleBg">
<h2>Blood Request Entry Details</h2>
</div>
<% 
String uhid="";
String name="";
int ipNo=0;
String gender="";
String age="";
String BloodGroup="";

if(null!=patientList && patientList.size()>0){
	for(Patient patient:patientList){
		uhid=patient.getHinNo();
		name=patient.getPFirstName();
		
		if(patient.getSex()!=null)
		gender=patient.getSex().getAdministrativeSexName();
		
		age=patient.getAge();
		
		
		
	}
}
%>
<div class="clear"></div>
<div class="Block" id="testDiv">
<label>UHID</label>
<label class="value"><%=uhid %></label>
<label>Patient Name</label>
<label class="value"><%=name %></label>
<label>IP No.</label><label class="value"><%=ipNumber %></label>
<input type="hidden" name="visitId" id="visitId" value="<%=visitId%>"/>

<div class="clear"></div>
<label>Gender</label>
<label class="value"><%=gender %></label>
<label>Age</label>
<label class="value"><%=age %> </label>


<label>Order No</label>
<input type="text" name="<%=ORDER_NO %>" value="<%=orderSeqNo %>" readonly="readonly"/>

<input type="hidden" name="<%=HIN_NO%>" value="<%=uhid %>" validate="hinNo,metachar,no"/>

<input type="hidden" name="patientHinId" value="<%=hinId %>" validate="patientHinId,int,no"/>

<input type="hidden"
	name="<%=INPATIENT_ID %>" value="<%=inPatientId%>" validate="inpatientId,int,no" />
	
	<input type="hidden"
	name="inpatientAdId" value="<%=inPatientId%>" />
	
	<input type="hidden"
	name="IpNumber" value="<%=ipNumber%>" />
<div class="clear"></div>
<label>Blood Group<span>*</span></label>
<select name="bloodGroup" id="bloodGroupNameId" validate="bloodGroup,metachar,yes">
<option value="">select</option>
<% for(MasBloodGroup component:componentList)
{
	%>
<option value="<%=component.getId()%>"><%=component.getBloodGroupName()%></option>
<%
}
%>
</select> 
<label>Req Type</label>
<select name="<%=REQUEST_TYPE%>"  tabindex=1>
	<option value="n">Not Urgent</option>
	<option value="u">Urgent</option>
	<option value="most">Most Urgent</option>
</select>


<!-- <label>Date And Time</label>
<label class="value">
<input type="text"  style="width: 60px;"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" id="imgId"  onclick="javascript:setdate('24/03/2015',document.admissionByHin.dateOfAdmission,event)" style="margin: 0;padding: 0;" />
<input type="text"  style="width: 50px;"/>
</label> -->

<label>Date </label> 
		<input type="text" class="date"
			id="BirthDateId" name="requesDate"
			value="<%=currentDate %>" MAXLENGTH="10" validate="Pick a date,date,yes" readonly="readonly" tabindex="1" />
			
			<!--  <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			 
			
			onClick="setdate('',document.bloodEntry.requesDate,event)" /> -->


<div class="clear"></div>
<div class="clear"></div>
<label>HB%</label>
<label class="value">
<input type="text"  style="width: 125px;"/>Gm
</label>

<label>Referred  to</label>
<select name="referTo" id="referToId" onchange="submitProtoAjaxWithDivName('bloodEntry','ipd?method=getOutSideAvailableBloodBankList&group='+this.value,'nameDiv');">
<option value="I">Inside</option>
<option value="O">OutSide</option>
</select>
<label>Provisional Diagnosis</label>
<textarea name="remarks" id="remarks" >

</textarea>
<div class="clear"></div>
<h4>Whether the patient had previous transfusion ,if  so </h4>
<label>No. of transfusions</label>
<input type="text" value="<%=totalTransfussionCount!=0?totalTransfussionCount:"" %>" readonly="readonly" name="NoOfTransfusion">
<label>Date & Time</label>
<%if(null !=transfussionDate && !transfussionDate.equalsIgnoreCase("null")) {%>
<input type="text" value="<%=transfussionDate%>,<%=transfussionTime %>" readonly="readonly" name="dateOfTransfusion">
<%}else{ %>
<input type="text" value="" readonly="readonly" name="dateOfTransfusion">

<%} %>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="addDeleteButton">
			<input type="button" class="buttonDel" value=""
				onclick="removeGridRow();" /> <input type="button" class="buttonAdd"  value="" 
				onclick="addBloodReqRow();"/>
		</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<table width="100%" colspan="7" id="componentDetailsForBlood" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">&nbsp;</th>
			<th width="10%">Component Name</th>
			<th width="7%">Unit</th>
			<th width="7%">Qty(ml)</th>
			<th width="10%">Required on Date</th>
		</tr>
	</thead>
	<tbody>
		<%
    	int detailCounter=8; 
    	int temp=0;
    	int inc = 0; 
    	int inxRow=1;
    	int inxCol=0;
    	if(pageNo!=1){
    		temp=detailCounter*(pageNo-1);
    	} 
    	for(inc=1;inc<=1;inc++,inxRow++){
    	    	  
    %>

		<tr>

			<td width="5%"><%-- <input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" tabindex=1 /> --%>
				
				<input
				type="hidden" value="" name="<%=BLOOD_COMPONENT_ID%><%=inc %>"
				id="bloodComponentId<%=inc %>" tabindex=1 /> 
				
				 <input type="checkbox" tabindex="<%=inxRow%><%=inxCol+1%>"
								class="radioCheck" id="itemRadio<%=inc %>"
									name="itemRadio<%=inc %>"/> </td>
				
			<td><input type="text" size="40" id="componentName<%=inc%>"
				name="<%=BLOOD_COMPONENT_NAME%><%=inc %>"
				onblur="checkForComponentCode(this.value,'<%=inc %>')"
				tabindex=1 />
			<div id="ac2update6" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('componentName<%=inc %>','ac2update6','bloodBank?method=getComponentNameForAutoComplete',{parameters:'requiredField=<%=BLOOD_COMPONENT_NAME%><%=inc %>'});
		</script></td>
		
		<td><input type="text" id="bloodUnit<%=inc%>"
				name="bloodUnit<%=inc %>" value="" validate="Qty,int,no"
				MAXLENGTH="3" tabindex=1 /></td>

			<td><input type="text" id="quantity<%=inc%>"
				name="<%=QUANTITY%><%=inc %>"  value="" validate="Qty,int,yes"
				MAXLENGTH="3" tabindex=1 /></td>
			<td><input type="text" class="date" id="reqDateId<%=inc%>"
				name="<%=REQUIRED_DATE %><%=inc %>" value="" readonly="readonly" validate="Required Date,String,yes"
				MAXLENGTH="30" onblur="validateRequiredDate(<%=inc %>);" tabindex=1 />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date"
				onClick="setdate('<%=currentDate%>',document.getElementById('reqDateId<%=inc%>'),event);"
				onblur="validateRequiredDate(<%=inc %>);" tabindex=1 /></td>
		</tr>
		<%} %>
	</tbody>
</table>
<input type="hidden" name="hdb" value="<%=inc %>" id="hdb" />
<input type="hidden" name="rowCount" value="<%=inxRow-1 %>" id="rowCountId"> <!--Bottom labels starts-->
<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div id="nameDiv">
<%
if(null !=bloodBankList){
	String bloodtime="";
%>
<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">&nbsp;</th>
			<th width="10%">Blood Bank</th>
			<th width="7%">Timing</th>
			<th width="10%">Status</th>
			<th width="10%">Qty Available (unit) </th>
		</tr>
	</thead>
	<tbody>
		<%
    	 temp=0;
         inc = 0;    	
    	if(pageNo!=1){
    		temp=detailCounter*(pageNo-1);
    	} 
    	for(MasHospital bloodBank:bloodBankList){
    		if(null !=bloodBank.getOpeningTime() && null !=bloodBank.getClosingTime() )
    		bloodtime=bloodBank.getOpeningTime()+"-- "+ bloodBank.getClosingTime();	  
    %>

		<tr>

			<td width="5%"><%-- <input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" tabindex=1 /> <input
				type="hidden" value="" name="<%=BLOOD_COMPONENT_ID%><%=inc %>"
				id="bloodComponentId<%=inc %>" tabindex=1 /> --%>
				
				<input type="radio" value="<%=bloodBank.getId() %>" 
				id="radioId<%=bloodBank.getId() %>" name="bloodBanknameId" 
				onclick="populatebloodBankQuantity(this.value);" /> </td>
			<td><%=bloodBank.getHospitalName() %></td>

			<td><%=bloodtime %></td>
			<%if(bloodBank.getStatus().equalsIgnoreCase("y")) {%>
			<td>Active</td>
			<%}
			else{
				%>
				<td>InActive</td>
			<% }
			%>
			<td><input type="text" name="b<%=bloodBank.getId()%>" id="b<%=bloodBank.getId()%>" readonly="readonly"/></td>
		</tr>
		<%}} %>
	</tbody>
</table>
</div>
<div class="paddingTop40"></div>
<!-- <input type="button" class="button"
	value="sUBMIT"
	onclick="if(checkFilledRow()){submitForm('bloodEntry','bloodBank?method=submitBloodRequestEntry');}"
	align="right" tabindex=1 /> 
	 -->
	 <input type="hidden" name="selectedBloodBankId" id="selectedBloodBankId" value=""/>
	
	<input type="button" class="button"
	value="save"
	onclick="if(checkEnptyField()){submitForm('bloodEntry','/hms/hms/bloodBank?method=submitBloodRequestEntry')}"
	align="right" tabindex=1 /> 
	<input type="button" name="Submit" value="Reset" class="button" onClick="submitFormForButton('bloodEntry','ipd?method=showBloodRequestEntryJsp');" />
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('bloodEntry','ipd?method=showPatientListJsp');"/>
	<div class="paddingTop40"></div>
	</div>

<!--Bottom labels ends-->
<div class="clear"></div>
<div class="paddingTop40"></div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
function addBloodReqRow() {
	var tbl = document.getElementById('componentDetailsForBlood');
	var rowCountId = parseInt(document.getElementById('rowCountId').value) + 1;
	document.getElementById('rowCountId').value = rowCountId;

	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb');
	iteration = parseInt(hdb.value);
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.value="";
	e1.name = 'bloodComponentId'+iteration;
	e1.id = 'bloodComponentId' + iteration;
	e1.tabIndex='1';
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex = rowCountId + "1";
	cellRight1.appendChild(e1);
	

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'bloodComponentName' + iteration;
	e1.id = 'componentName' + iteration;
	e1.value="";
	e1.onblur = function() {
		 checkForComponentCode(this.value,iteration);
	}
	e1.size = '40';
	e1.tabIndex = rowCountId + "2";
	cellRight1.appendChild(e1);
	e1.focus();
	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2update6' + iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('componentName' + iteration,
			'ac2update6' + iteration,
			'bloodBank?method=getComponentNameForAutoComplete', {
				minChars : 1,
				parameters : 'requiredField='+'bloodComponentName' + iteration
			});
	
	<%-- new Ajax.Autocompleter('componentName' + iteration+','+
			'ac2update6' + iteration+','+
			'bloodBank?method=getComponentNameForAutoComplete'+',{'+ 
				parameters :+'requiredField='+<%=BLOOD_COMPONENT_NAME%> + iteration+
			'});'; --%>
	cellRight1.appendChild(e1);
    var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'bloodUnit' + iteration;
	e1.id = 'bloodUnit' + iteration;
	e1.value="";
	e1.validate='Qty,int,no';
	e1.MAXLENGTH = '3';
	e1.tabIndex = rowCountId + "3";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "textYellow";
	e1.name = 'quantity' + iteration;
	e1.id = 'quantity' + iteration;
	e1.validate='Qty,int,yes';
	e1.value="";
	e1.MAXLENGTH = '3';
	e1.tabIndex = rowCountId + "4";
	cellRight1.appendChild(e1);

    var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.class='date';
	e1.type = 'text';
	e1.className = "textYellow";
	e1.name = 'reqDate' + iteration;
	e1.id = 'reqDateId' + iteration;
	e1.readonly='readonly';
	e1.value="";
	e1.validate='Required Date,String,yes';
	e1.MAXLENGTH='30';
	e1.onblur=function() {
		validateRequiredDate(iteration);
	};
	cellRight1.appendChild(e1);
	var e1 = document.createElement('img');
	e1.src = '/hms/jsp/images/cal.gif';
	e1.width = '16';
	e1.height = '16';
	e1.border='0';
	e1.validate='Pick a date';
	e1.onclick=function() {
		setdate(<%=currentDate%>,document.getElementById('reqDateId'+iteration),event);
	};
		
	e1.onblur=function() {
		validateRequiredDate(iteration);
	};
	e1.tabindex='1';
	e1.tabIndex = rowCountId + "5";
	cellRight1.appendChild(e1);
}
</script>
<script type="text/javascript">
function checkEnptyField(){
	
	var id=document.getElementById('selectedBloodBankId').value;
	
	//var id1=document.getElementsByName('bloodGroupNameId').value; 
	//alert(id)
	if(id==null ||  id==""){
		alert("Select Blood Bank .\n")
		return false;
		 
	  }
	else{
		return true;
	}
}

function fillSrNo(rowVal){

	if(document.getElementById('componentName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('componentName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}

function clearAllFields(inc){
	var componentCode = document.getElementById('componentCode'+inc).value
	var quantity = document.getElementById('quantity'+inc).value;
	var reqDate = document.getElementById('reqDateId'+inc).value;
	
}

function checkForComponentCode(val,inc){
	
		if(val != "")
		{
			/* var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8; */
			//alert(val);
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
		
		if(componentId =="")
		{
	  	 document.getElementById('quantity'+inc).value="";
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('componentName'+i).value==val)
		{
			alert("Component Name already selected...!")
			document.getElementById('componentName'+inc).value=""
			var e=eval(document.getElementById('componentName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteComponentName('bloodEntry','bloodBank?method=fillItemsForComponentname&componentName=' +  componentName , inc);
		
		}else{
			document.getElementById('quantity'+inc).value = "";
		}
}



function checkFilledRow(){
	

	/* var msg =""; */
	/* if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one Component to submit.");
	  	return false;
	  }else{ */
	  var msg ="";
	  var bloodBank=document.getElementById('bloodBanknameId').value;
	 // alert(bloodBank);
	  if(bloodBank==null ||  bloodBank==""){
		  msg += "Select Blood Bank  .\n";
	  }
	  	/* var count = document.getElementById('noOfRecords').value; */
	  	for(var i=1;i<=1;i++){
	  	
	  	 	if(document.getElementById('componentName'+i).value != ""){
	  			if(document.getElementById('quantity'+i).value == ""){
	  				msg += "Quantity can not be blank.\n";
	  			}
	  			if(document.getElementById('reqDateId'+i).value == ""){
	  				msg += "Required Date can not be blank.\n";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else{
	  			return true;
	  			}
	  		}
	  			
	 
	  }
	 
	function validateRequiredDate(inc){
		//var currentDate = new Date();
		 var today = new Date();
		    var dd = today.getDate();
		    var mm = today.getMonth(); //January is 0!

		    var yyyy = today.getFullYear();
		    if(dd<10){
		        dd='0'+dd
		    } 
		    if(mm<10){
		        mm='0'+mm
		    } 
		   // var today1 = dd+'/'+mm+'/'+yyyy;
		    var validFromDate1=new Date(yyyy,mm ,dd);
		
		obj1 = eval(document.getElementById("reqDateId"+inc))
		
		
		 var validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 
		 if(obj1.value != ""){
			
			
			if(validFromDate < validFromDate1)
				{
				alert("Required Date should not be Past date\n");
				document.getElementById("reqDateId"+inc).value="";
				return false;
				}
		}
	
		return true;
	}
	
	
	function removeGridRow() {
		var tbl = document.getElementById('componentDetailsForBlood');
		var lastRow = tbl.rows.length;
		var hdb = document.getElementById('hdb');
		var iteration = parseInt(hdb.value);
		var totalSelected = 0;
		if (confirm("Do you want to delete !")) {
			for (var i = 0; i <= iteration; i++) {

				if (document.getElementById("itemRadio" + i) != null
						&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
						&& document.getElementById("itemRadio" + i).checked) {
					totalSelected = totalSelected + 1;
				}
			}

			if (totalSelected == 0) {
				alert('Please select atleast 1 row to delete');
			}
			
			for (var i = 0; i <= iteration; i++) {
				if (document.getElementById("itemRadio" + i) != null
						&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
						&& document.getElementById("itemRadio" + i).checked) {
					
					var deleteRow = document.getElementById("itemRadio" + i).parentNode.parentNode;
					document.getElementById("itemRadio" + i).parentNode.parentNode.parentNode
							.removeChild(deleteRow);
				}
			}	
		}
	}

</script>


