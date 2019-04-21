<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	int token=0;
	int visitId=0;
	String uhid="";
	int hin_id=0;
	int depaId=0;
	String patientName="";
	String gender="";
	String age="";	
	Date dob = null;
	String yearMonth="";

	Integer pulse=0;
	if(map.get("pulse")!=null){
		pulse=(Integer)map.get("pulse");
	}
	Float temprature=0f;
	if(map.get("temprature")!=null){
		temprature=(Float)map.get("temprature");
	}
	String systolic="";
	if(map.get("systolic")!=null){
		systolic=(String)map.get("systolic");
	}
	String diastolic="";
	if(map.get("diastolic")!=null){
		diastolic=(String)map.get("diastolic");
	}
	Double weight=0.0;
	if(map.get("weight")!=null){
		weight=(Double)map.get("weight");
	}
	Double  height=0.0;
	if(map.get("height")!=null){
		height=(Double)map.get("height");
	}
	Float bmi=0f;
	if(map.get("bmi")!=null){
		bmi=(Float)map.get("bmi");
	}
	
	String bmiStatus="";
	 if(0.0 <bmi && bmi <18.5){
		 bmiStatus="Underweight";
	}else if(bmi>=18.5 && bmi<25){
		 bmiStatus="Healthy Range";
	}else if(bmi>=25 && bmi<=30){
		 bmiStatus="Overweight"; 
	}else if(bmi>=30 && bmi<=35){
		 bmiStatus="Obese"; 
	}else if(bmi>35){
		 bmiStatus="Severely obese"; 
	}else{
		 bmiStatus=""; 
	}
	
	boolean lastpatient=false;
	if(map.get("token")!=null){
		token=(Integer)map.get("token");
	}
	if(map.get("visitId")!=null){
		visitId=(Integer)map.get("visitId");
	}
	if(map.get("uhid")!=null){
		uhid=(String)map.get("uhid");
	}
	if(map.get("hin_id")!=null){
		hin_id=(Integer)map.get("hin_id");
	}
	if(map.get("depaId")!=null){
		depaId=(Integer)map.get("depaId");
	}
	if(map.get("patientName")!=null){
		patientName=(String)map.get("patientName");
		
	}
	if(map.get("gender")!=null){
		gender=(String)map.get("gender");
	}
	if(map.get("age")!=null){
		age=(String)map.get("age");
	}
	if(map.get("lastpatient")!=null){
		lastpatient=(Boolean)map.get("lastpatient");
	}
	/* Added by Arbind on 22-04-2017 */
	if(map.get("dob") != null) {
		dob = (Date)map.get("dob");
	}
	String bloodGroupValue = "";
	String bloodGroupStatus = "";
	if(map.get("bloodGroupValue")!=null){
		bloodGroupValue=(String)map.get("bloodGroupValue");
	}
	if(map.get("bloodGroupStatus")!=null){
		bloodGroupStatus=(String)map.get("bloodGroupStatus");
	}
	List<MasBloodGroup> bloodGroupList=new ArrayList<MasBloodGroup>();
	if(map.get("bloodGroupList")!=null){
		bloodGroupList=(List)map.get("bloodGroupList");
	}
	
	if(dob != null) {
		String ymd=HMSUtil.calculateYearMonthDay(dob);
		String d[]=ymd.split("&");
		int year1=Integer.parseInt(d[0].toString());
		int months1=Integer.parseInt(d[1].toString());
		int days1=Integer.parseInt(d[2].toString());
		yearMonth = year1 != 0 ? d[0] + " Y " : "";
		yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
		yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
	}

	List<OpdPatientHistory>patientHistories=new ArrayList<OpdPatientHistory>();
  	String opdPatientHistoriesStr="";
  	if(map.get("preOpdPatientHistoryList") != null){
  		patientHistories=(List<OpdPatientHistory>)map.get("preOpdPatientHistoryList");
  		for(OpdPatientHistory opd:patientHistories){
  			if(!opd.getPresentComplaintHistory().equals("")){
  				if(opd.getLastChgDate()!=null  &&  !opd.getLastChgDate().equals("")){
  					opdPatientHistoriesStr=opdPatientHistoriesStr+"[ "+opd.getLastChgDate()+" ]:"+opd.getPresentComplaintHistory()+"\n\n";
  				}
  		}
	 }
  	}	
	
	String persentcomplainthistory="";
	String personalhistory="";
	String familyhistory="";
	String medicationhistory="";	
	
	if(map.get("presentComplaintHistory")!=null){
		persentcomplainthistory=(String)map.get("presentComplaintHistory");
	}
	
	if(map.get("personalHistory")!=null){
		personalhistory=(String)map.get("personalHistory");
	}
	if(map.get("familyHistory")!=null){
		familyhistory=(String)map.get("familyHistory");
	}
	if(map.get("medicationHistory")!=null){
		medicationhistory=(String)map.get("medicationHistory");
	}
	
	Boolean assessmentStatus=false;
	String savedPatient=null;
	String nursingStatus="";
	if (map.get("assessmentStatus") != null) {
		assessmentStatus = (Boolean)map.get("assessmentStatus");
		if (map.get("savedName") != null) {
			savedPatient = (String)map.get("savedName");
		}
		if(assessmentStatus)
			nursingStatus="Pre- consultation assessment done for "+savedPatient;
	}	
%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<div class="titleBg">
<h2>Pre-Consultation Assessment Screen</h2>
</div>
<%
	if(map.get("assessmentStatus") != null){%>
		<div class="clear"></div>
		<label class="large"><span><%=nursingStatus%></span></label>
		<div class="clear"></div>
	 <% }%>
<div class="Block">
<label style="vertical-align:baseline;" class="auto"><span>Nursing Data Entry will not part of EHR</span></label>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<form name="preConsultationScreen" id="preConsultationScreen" action="" method="post">
<h4>Patient Details</h4>
<div class="paddingTop5"></div>
<div class="clear"></div>
<label>UHID</label>
<input name="uhid" id="uhid" type="text" value="<%=uhid%>" validate="uhid,string,no"  readonly="readonly" />
<input type="hidden" id="hin_id" name="hin_id" value="<%=hin_id %>" />
<input type="hidden" id="depaId" name="depaId" value="<%=depaId %>" />
<input type="hidden" id="lastpatient" name="lastpatient" value="<%=lastpatient %>" />
<label>Patient Name</label>
<input name="patientname" id="patientname" type="text" value="<%=patientName%>"	validate="patientname,string,no" readonly="readonly" />
<label class="auto">Gender</label>
<input name="gender" class="textSmall" id="gender" type="text" value="<%=gender%>"	validate="gender,string,no"  readonly="readonly"/>
<label class="auto">Age</label>
<!-- Commented and Added by Arbind on 22-04-2017 -->
<%-- <input name="age" id="age" class="textSmall"  type="text" value="<%=age%>"	validate="age,string,no" maxlength="3"  readonly="readonly" /> --%>
<input name="age" id="age" type="text" value="<%=yearMonth%>"	validate="age,string,no" maxlength="3"  readonly="readonly" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<label>Triage Category</label>
<select id="triagePatient" name="triagePatient" class="midium" >
	<option value="0">Select</option>
	<option value="1">Immediate</option>
	<option value="2">Urgent</option>
</select>

<label class="auto" id="waitingPosLbl" ><span>*</span>Waiting Position</label>
<input name="waitingLoc" id="waitingLoc" type="text"  maxlength="2" class="allownumericwithoutdecimal textSmall"/>
<div class="clear"></div>
<label>Present Complaint/History</label>
<textarea name="presentComplain" class="medium" id="presentComplain"  validate="presentComplain,string,no"   cols="0" rows="0"  maxlength="300" tabindex="1" ><%=patientHistories!=null?persentcomplainthistory:""%></textarea>
<input type="button" class="buttonAuto-buttn" style="margin: 2px 0px 0px 4px;" id="button1" name="button1" value="+"  onclick="getPresentTemplate(this);"  />
  
<label>History of Past Illness</label>
 <textarea name="pastIllness" class="medium" id="pastIllness" cols="0"  validate="pastIllness,string,no" 	rows="0" maxlength="300" tabindex="1"  ><%=opdPatientHistoriesStr%></textarea>
<input type="button" class="buttonAuto-buttn" style="margin: 2px 0px 0px 4px;" id="button2" name="button2" value="+" onclick="getHistoryOfPastIllnessTemplate(this)"  />

<div class="clear"></div>
<label>Personal History</label>
<textarea name="personalHistory" class="medium" id="personalHistory"  validate="personalHistory,string,no"  tabindex="1" cols="0"	rows="0" maxlength="500" ><%=personalhistory%></textarea>
<input type="button" class="buttonAuto-buttn" style="margin: 2px 0px 0px 4px;" id="button3" name="button3" value="+" onclick="getPersonalHistoryTemplate(this)"  />

<label>Family History</label>
<textarea	name="familyHistory"  id="familyHistory" class="medium"  validate="familyHistory,string,no"  cols="0"   tabindex="4" rows="0" maxlength="500" ><%=familyhistory%></textarea>
<input type="button" class="buttonAuto-buttn" style="margin: 2px 0px 0px 4px;" id="button4" name="button4" value="+" onclick="getFamilyHistoryTemplate(this);"  />

<div class="clear"></div>
<label>Medication History</label>
<textarea name="medicationhistory" id="medicationhistory" class="medium"  validate="medicationhistory,string,no"    cols="0"	rows="0" maxlength="500" tabindex="5"><%=medicationhistory%></textarea>
<input type="button" class="buttonAuto-buttn" style="margin: 2px 0px 0px 4px;" id="button5" name="button5" value="+" onclick="getMedicationHistoryTemplate(this)"  />
<div class="clear"></div>
<div class="paddingTop5"></div>
<label class="auto">Pulse</label>
<input name="pulse" id="pulse" type="text" value="<%=pulse>0?pulse:"" %>"	validate="pulse,num,no" maxlength="3" class="allownumericwithoutdecimal textSmall"  tabindex="10"/>
<label	class="smallAuto">min</label>

<label class="auto">Temperature</label>
<input	name="temperature" id="temperature" value="<%=temprature>0?temprature:"" %>" validate="temperature,float,no" type="text" maxlength="6" class="allownumericwithdecimal textSmall"  tabindex="11"/>
<label	class="smallAuto">&deg;F</label>

<label id="bpLabel" class="auto">BP</label>
<input  name="systolic" id="systolic" name="Systolic" placeholder="Systolic" value="<%=systolic %>"  validate="systolic,int,no" type="text" onblur=""	maxlength="3" class="allownumericwithoutdecimal textSmall"  tabindex="12"/>
<label id="bpLabel" class="auto"><span style="color: black">/</span></label>
<input  name="diastolic" id="diastolic" name="diastolic" value="<%=diastolic %>" placeholder="Diastolic" validate="diastolic,int,no" type="text" onblur=""	maxlength="3" class="allownumericwithoutdecimal textSmall"  tabindex="13"/></span>
<label class="smallAuto">mm&nbsp;Hg</label>

<label class="auto">Weight</label>
<input name="weight"  id="weight" type="text" maxlength="5"  class="allownumericwithdecimal textSmall"  value="<%=weight>0?weight:"" %>" validate="weight,double,no" onblur="calculateBMI();" tabindex="14"/>
<label	class="smallAuto">Kg</label>

<label class="auto">Height</label>
<input	name="height" id="height" type="text"  maxlength="3" class="allownumericwithoutdecimal textSmall"  value="<%=height>0?height:"" %>" validate="height,int,no" onblur="calculateBMI();" tabindex="15"/>
<label	class="smallAuto">cm</label>

<label class="auto" id="bpLabel">BMI</label>
<input	name="bmi" id="bmi"  type="text" value="<%=bmi %>"  readonly="readonly" class="textSmall" />
<label class="auto" id="bmiCat"><%=bmiStatus %></label>
<div class="clear"></div>
<label class="auto">Blood Group</label>
						 <%
						if(bloodGroupValue != null  && !bloodGroupValue.equals("")){ %>
						<label><%=bloodGroupValue %></label>
							<%if(bloodGroupStatus != null && !bloodGroupStatus.equals("") && bloodGroupStatus.equalsIgnoreCase("y")){ %>
							<%}else{ %>
						<select name="bloodGroupValue"	id="bloodGroupValue" tabindex=1 class="midium">
							<option value="0">Select</option>
						<%for(MasBloodGroup masBloodGroup : bloodGroupList){ %>
							<option value="<%=masBloodGroup.getBloodGroupName()%>"><%=masBloodGroup.getBloodGroupName()%></option>
						<%} %>
						</select>
						
						<%} %>
						<label class="auto">Confirm</label>
						<%if(bloodGroupStatus != null && !bloodGroupStatus.equals("") && bloodGroupStatus.equalsIgnoreCase("y")){ %>
						<input type="checkbox" name="bloodGroupStatus" id="bloodGroupStatus" value="y" checked="checked" />
						<%}else{ %>
						<input type="checkbox" name="bloodGroupStatus" id="bloodGroupStatus" value="y"  />
						<%} %>
						<%}else{ %>
						<select name="bloodGroupValue"	id="bloodGroupValue" tabindex=1 class="midium">
							<option value="0">Select</option>
						<%for(MasBloodGroup masBloodGroup : bloodGroupList){ %>
							<option value="<%=masBloodGroup.getBloodGroupName()%>"><%=masBloodGroup.getBloodGroupName()%></option>
						<%} %>
						</select>
							<label class="auto">Confirm</label>
						<input type="checkbox" name="bloodGroupStatus" id="bloodGroupStatus" value="y"  />
						<%} %> 
						<div class="clear"></div>
<div style="margin-left:5px">
<input type="button" class="button" name="next" id="next" value="Next" onclick="fnNextWaitingPatient();"/>
<input type="button" class="buttonAuto" name="waitinglist" id="waitinglist" value="Waiting List" onclick='showWaitingList(false,true);' />
<input type="button" class="button" value="submit" id="submit111"/>
<input type="button" class="button" name="reset" id="reset" value="Reset" onclick='fnReset();'/>
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/jquery.min.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/jquery-ui.css">
<script>jQuery.noConflict();</script>
<div id="dialog-confirm"></div>

<script type="text/javascript">
jQuery(function ($) {
$("#submit111").click(function(){
    var text="";var flag=0;
	$('input,textarea').each(function(index){  
		        var input = $(this);
		        if(input.attr('type')!="hidden" && input.attr('type')!="button" && input.attr('id')!="gender" && input.attr('id')!="age" &&  
		        		input.attr('id')!="uhid" && input.attr('id')!="patientname"  && input.attr('id')!="bmi"){
		        	text=input.val();
		        }
		        if(text!=""){
		        	flag=1;
		        }
		        //alert('Type: ' + input.attr('type') + '\nName: ' + input.attr('name') + '\nValue: ' + input.val());
		    }
	);	
	if(flag==0){
		alert('Enter something!');
	}else{
		ValidateForm();
	}
	});
});

function ValidateForm(){
	var flag=0;
	$.each($('#preConsultationScreen').serializeArray(), function(i, field) {
	   if(field.name!='hin_id' 
			   && field.name!='depaId' 
			   && field.name!='lastpatient' 
			   && field.name!='uhid' 
			   && field.name!='patientname' 
			   && field.name!='gender' 
			   && field.name!='age'){
		   //alert(field.name+" "+field.value);
		   if(field.value!=""){
			   flag=1;
		   }
	   }
	});
	 var systolic=document.getElementById("systolic").value;
	 var diastolic=document.getElementById("diastolic").value;
	 if(diastolic!=null && diastolic!=''&& (systolic==null || systolic==''))
		 {
		 alert('please fill systolic');
		 return false;
		 }
	 else if(systolic!=null && systolic!=''&& (diastolic==null || diastolic==''))
		 {
		 alert('please fill diastolic');
		 return false;
		 }
	if(flag==0){
		var result=confirm("Enter some details.");
		if(!result){
			var url='/hms/hms/opd?method=showWaitingPatientListJsp&'+csrfTokenName+'='+csrfTokenValue;
			window.location.href=url;	
		}
	}else{
		fnSubmitPreAssessment();
	}
}
function calculateBMI()
{
	
	$("#bmi").val("");
	if($("#height").val() != "" && $("#weight").val() !="" && !isNaN($("#height").val()) && !isNaN($("#weight").val()) && parseInt($("#height").val())!=0 && parseInt($("#weight").val())!=0 )
	{
	 var height = 	parseFloat($("#height").val())/100;
	 var weight = 	$("#weight").val();
	 $("#bmi").val((weight/(height*height)).toFixed(2));
	}
	bmiCat();
}

function bmiCat(){
	 var bmicat;
	 $("#bmi").val("");
		if($("#height").val() != "" && $("#weight").val() !="" && !isNaN($("#height").val()) && !isNaN($("#weight").val()) && parseInt($("#height").val())!=0 && parseInt($("#weight").val())!=0 )
		{
		 var height = 	parseFloat($("#height").val())/100;
		 var weight = 	$("#weight").val();
		 $("#bmi").val((weight/(height*height)).toFixed(2));
		 bmicat=(weight/(height*height)).toFixed(2);
		
		 $("#bmiCat").val(" ");
		 if(bmicat<18.5){
			 $("#bmiCat").text("Underweight");
			 $("#bmiCat").prev().css('color', '#F65C5C');
			 $("#bmiCat").css('color', '#F65C5C');
		}else if(bmicat>=18.5 && bmicat<25){
			$("#bmiCat").text("Healthy Range");	
			$("#bmiCat").prev().css('color', 'green');
			$("#bmiCat").css('color', 'green');
		}else if(bmicat>=25 && bmicat<=30){
			$("#bmiCat").text("Overweight");
			$("#bmiCat").prev().css('color', '#574F4F');
			$("#bmiCat").css('color', '#574F4F');
		}else if(bmicat>=30 && bmicat<=35){
			$("#bmiCat").text("Obese");
			$("#bmiCat").prev().css('color', '#C40707');
			$("#bmiCat").css('color', '#C40707');
		}else if(bmicat>35){
			$("#bmiCat").text("Severely obese ");
			$("#bmiCat").prev().css('color', '#AD0C0C');
			$("#bmiCat").css('color', '#AD0C0C');
		}else{
			$("#bmiCat").text("");
		}
		}
		else{
			
			$("#bmiCat").text("");
		}		
}
jQuery(function ($) {
	$("#waitingPosLbl").hide();
	$("#waitingLoc").hide();
	$("#diastolic").blur(function(){
	    if(parseInt($("#systolic").val())<parseInt($("#diastolic").val())){
	    	alert("Diastolic should be less than Systolic");
	    	$("#diastolic").focus();
	    	$("#diastolic").val("");
	    }
	});
	
	/* $("#pulse").blur(function (){
		if($("#pulse").val()!="" && !($("#pulse").val()>60 && $("#pulse").val()<100)){
			alert("pulse rate should be between 60 to 100");
			$("#pulse").focus();
			$("#pulse").val("");
		}
	}); */
	
	 $("#temperature").blur(function (){
		if($("#temperature").val()>999 ){
			alert("Invalide Temperature");
			$("#temperature").focus();
			$("#temperature").val("");
		}
	}); 
	
	 $(".allownumericwithdecimal").on("keypress keyup blur",function (event) {
         //this.value = this.value.replace(/[^0-9\.]/g,'');
	  	  $(this).val($(this).val().replace(/[^0-9\.]/g,''));
	         if ((event.keyCode !=  46) && ((event.keyCode !=  37)) &&((event.keyCode !=  39)) && (event.keyCode != 8) && (event.keyCode != 9) &&(event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
	             event.preventDefault();
	         }
	   });

	$(".allownumericwithoutdecimal").on("keypress keyup blur",function (event) {    
        $(this).val($(this).val().replace(/[^\d].+/, ""));
         if ((event.keyCode !=  46) && ((event.keyCode !=  37)) &&((event.keyCode !=  39)) && (event.keyCode != 8)&& (event.keyCode != 9) && (event.which < 48 || event.which > 57)) {
             event.preventDefault();
         }
     });
	$("#triagePatient").change(function (){
		if($("#triagePatient").val()==2)
		{
			$("#waitingPosLbl").show();
			$("#waitingLoc").show();
		}else{
			$("#waitingPosLbl").hide();
			$("#waitingLoc").hide();			
		}
	});	
});

function checkWaitingPosition(){
	var triagePatient=document.getElementById("triagePatient").value;
	var waitingLoc=document.getElementById("waitingLoc").value;
	if(triagePatient==2){
		if(waitingLoc==""){
			alert("Waiting position can not be blank for Urgent Patient!!");
			document.getElementById("waitingLoc").focus();
			return false;
		}else{ 
			return true;
		}
	}else{
		return true;
	}
}

function fnSubmitPreAssessment(){
	if(checkWaitingPosition()){
		if(confirm("Do you want to submit?")){
			submitForm('preConsultationScreen','/hms/hms/opd?method=submitPreConsultationAssessmentDetails&visitId=<%=visitId%>&token=<%=token%>&'+csrfTokenName+'='+csrfTokenValue);	
		}
	}
}
function fnNextWaitingPatient(){
	if(document.getElementById("lastpatient").value!='true'){
		if(confirm("Do you want to see next patient ?")){
			submitForm('preConsultationScreen','/hms/hms/opd?method=savePreConsultationAssessmentDetails&visitId=<%=visitId%>&token=<%=token%>&'+csrfTokenName+'='+csrfTokenValue);
		}	
	}else{
		alert("No patient available!");
		var url='/hms/hms/opd?method=showWaitingPatientListJsp&'+csrfTokenName+'='+csrfTokenValue;
		window.location.href=url;	
	}
}

 function fnReset(){
		if(confirm('Do you want to reset screen ?')) {
			document.getElementById("presentComplain").value="";
			document.getElementById("pastIllness").value="";
			document.getElementById("personalHistory").value="";
			document.getElementById("familyHistory").value="";
			document.getElementById("medicationhistory").value="";
			document.getElementById("pulse").value="";
			document.getElementById("temperature").value="";
			document.getElementById("systolic").value="";
			document.getElementById("diastolic").value="";
			document.getElementById("weight").value="";
			document.getElementById("height").value="";
			document.getElementById("bmi").value="";
		}	
	}
	 function showWaitingList (flag,waitStatus) {
		 if(flag){
				var url='/hms/hms/opd?method=showWaitingPatientListJsp&'+csrfTokenName+'='+csrfTokenValue;
				window.location.href=url;			 	
		 }else{
			 if(waitStatus){
				 if(confirm('Do you want to see nurse waiting list ?')){
						var url='/hms/hms/opd?method=showWaitingPatientListJsp&'+csrfTokenName+'='+csrfTokenValue;
						window.location.href=url;	
				 }
			 }
		 }
	}	 
	 //code for history templet	 
	 function getPresentTemplate(element)
	{
		 var historyEnteredValues = getHistoryEnteredValues(element);
		 var url='/hms/hms/opd?method=showPopUpPresentComplaint&'+csrfTokenName+'='+csrfTokenValue+'&historyEnteredValues='+historyEnteredValues;
	 	 popwindow(url);
	} 
	 
	 function getFamilyHistoryTemplate(element)
	 {
		 var historyEnteredValues = getHistoryEnteredValues(element);
	 var url='/hms/hms/opd?method=showPopUpFamilyHistory&'+csrfTokenName+'='+csrfTokenValue+'&historyEnteredValues='+historyEnteredValues ;
	  popwindow(url);
	 }
	 
	 function getHistoryOfPastIllnessTemplate(element)
	 {
		 var historyEnteredValues = getHistoryEnteredValues(element);
	 var url='/hms/hms/opd?method=showPopUpHistoryOfPastIllness&'+csrfTokenName+'='+csrfTokenValue+'&historyEnteredValues='+historyEnteredValues ;
	  popwindow(url);
	 }
	 
	 function getPersonalHistoryTemplate(element)
	 {
		 var historyEnteredValues = getHistoryEnteredValues(element);
	 var url='/hms/hms/opd?method=showPopUpPersonalHistory&'+csrfTokenName+'='+csrfTokenValue+'&historyEnteredValues='+historyEnteredValues ;
	  popwindow(url);
	 }
	 
	 function getMedicationHistoryTemplate(element)
	 {
		 var historyEnteredValues = getHistoryEnteredValues(element);
	 var url='/hms/hms/opd?method=showPopUpMedicationHistory&'+csrfTokenName+'='+csrfTokenValue+'&historyEnteredValues='+historyEnteredValues ;
	  popwindow(url);
	 }
	 
	 function getHistoryEnteredValues(element){
		 var historyEnteredValues =  element.previousElementSibling.value;
		 var re = new RegExp('\n', 'g');
		 historyEnteredValues	= historyEnteredValues.replace(re, ',');
		 return historyEnteredValues;
	 }
	 
var newwindow;
function popwindow(url)
{
 newwindow=window.open(url,'name','height=500,width=800,status=1');
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
 }

</script>
 
