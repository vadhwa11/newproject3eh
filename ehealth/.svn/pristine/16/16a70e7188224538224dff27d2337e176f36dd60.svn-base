<%@page import="jkt.hms.masters.business.OpdNursingPatientDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.*"%>


<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	int token=0;
	int inpatientId=0;
	String uhid="";
	int hin_id=0;
	int depaId=0;
	String patientName="";
	String gender="";
	String age="";
	
	
	
	
	boolean lastpatient=false;
	if(map.get("token")!=null){
		token=(Integer)map.get("token");
	}
	if(map.get("inpatientId")!=null){
		inpatientId=(Integer)map.get("inpatientId");
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
	List<OpdNursingPatientDetails>  opdNursingPatientDetailsList= new ArrayList<OpdNursingPatientDetails>();
	
	if(map.get("opdNursingPatientDetailsList") != null){
		opdNursingPatientDetailsList=(List)map.get("opdNursingPatientDetailsList");
	}
	

	

%>
<form name="preConsultationScreen" id="preConsultationScreen" action="" method="post">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<h4>Pre Dialysis checkup Screen</h4>
<%if(opdNursingPatientDetailsList.size()>0){%>
<label style="vertical-align:baseline;" class="autoSize"><span>Pre Dialysis checkup already exits. </span></label>
<div class="clear"></div>
<input name="Back" type="button" alt="Back" value="Back" class="cmnButton" onclick="submitForm('preConsultationScreen','/hms/hms/ipd?method=showPatientListNurseJsp');" align="right" />
<%}else{%>
<div class="Block">
<!-- <label style="vertical-align:baseline;" class="autoSize"><span>Nursing Data Entry will not part of EHR</span></label> -->
<div class="clear"></div>

<label>Patient Details</label>
<div class="paddingTop25"></div>
<div class="clear"></div>
<label class="auto" >UHID</label>

<input name="uhid" id="uhid" type="text" value="<%=uhid%>" validate="uhid,string,no"  readonly="readonly" />
<input type="hidden" id="hin_id" name="hin_id" value="<%=hin_id %>" />
<input type="hidden" id="depaId" name="depaId" value="<%=depaId %>" />
<input type="hidden" id="inpatientId" name="inpatientId" value="<%=inpatientId %>" />
<label class="auto">Patient Name</label>
<input name="patientname" id="patientname" type="text" value="<%=patientName%>"	validate="patientname,string,no" readonly="readonly" />
<label class="auto">Gender</label>
<input name="gender" class="textSmall" id="gender" type="text" value="<%=gender%>"	validate="gender,string,no"  readonly="readonly"/>
<label class="auto">Age</label>
<input name="age" id="age" class="textSmall"  type="text" value="<%=age%>"	validate="age,string,no" maxlength="3"  readonly="readonly" />

<div class="clear"></div>
<div class="paddingTop25"></div>
<!-- -<label>Triage Category</label>
<select id="triagePatient" name="triagePatient" class="midium" >
	<option value="0">Select</option>
	<option value="1">Immediate</option>
	<option value="2">Urgent</option>
</select> -->
<label class="auto" id="waitingPosLbl" ><span>*</span>Waiting Position</label>
<input name="waitingLoc" id="waitingLoc" type="text"  maxlength="2" class="allownumericwithoutdecimal textSmall"/>

<div class="clear"></div>
<label>Present Complaint / History</label>
<textarea name="presentComplain" class="medium" id="presentComplain"  validate="presentComplain,string,no"   cols="0" rows="0"  maxlength="300" tabindex="1" ></textarea>
<input type="button" class="buttonAuto-buttn" style="margin: 2px 0px 0px 4px;" id="button1" name="button1" value="+"  onclick="getPresentTemplate();"  />
  
<label>History of Past Illness</label>
 <textarea name="pastIllness" class="medium" id="pastIllness" cols="0"  validate="pastIllness,string,no" 	rows="0" maxlength="300" tabindex="1"  ></textarea>
<input type="button" class="buttonAuto-buttn" style="margin: 2px 0px 0px 4px;" id="button2" name="button2" value="+" onclick="getHistoryOfPastIllnessTemplate()"  />

<div class="clear"></div>
<label>Personal History</label>
<textarea name="personalHistory" class="medium" id="personalHistory"  validate="personalHistory,string,no"  tabindex="1" cols="0"	rows="0" maxlength="500" ></textarea>
<input type="button" class="buttonAuto-buttn" style="margin: 2px 0px 0px 4px;" id="button3" name="button3" value="+" onclick="getPersonalHistoryTemplate()"  />

<label>Family History</label>
<textarea	name="familyHistory"  id="familyHistory" class="medium"  validate="familyHistory,string,no"  cols="0"   tabindex="4" rows="0" maxlength="500" ></textarea>
<input type="button" class="buttonAuto-buttn" style="margin: 2px 0px 0px 4px;" id="button4" name="button4" value="+" onclick="getFamilyHistoryTemplate();"  />

<div class="clear"></div>

<label>Medication History</label>
<textarea name="medicationhistory" id="medicationhistory" class="medium"  validate="medicationhistory,string,no"    cols="0"	rows="0" maxlength="500" tabindex="5"></textarea>
<input type="button" class="buttonAuto-buttn" style="margin: 2px 0px 0px 4px;" id="button5" name="button5" value="+" onclick="getMedicationHistoryTemplate()"  />
<div class="clear"></div>
<div class="paddingTop25"></div>
<label class="auto">Pulse</label>
<input name="pulse" id="pulse" type="text" value=""	validate="pulse,num,no" maxlength="3" class="allownumericwithoutdecimal textSmall"  tabindex="10"/>
<label	class="smallAuto">min</label>

<label class="auto">Temperature</label>
<input	name="temperature" id="temperature" value="" validate="temperature,float,no" type="text" maxlength="6" class="allownumericwithdecimal textSmall"  tabindex="11"/>
<label	class="smallAuto">&deg;F</label>

<label id="bpLabel" class="auto">BP</label>
<input  name="systolic" id="systolic" name="Systolic" placeholder="Systolic" value=""  validate="systolic,int,no" type="text" onblur=""	maxlength="3" class="allownumericwithoutdecimal textSmall"  tabindex="12"/>
<label id="bpLabel" class="auto"><span style="color: black">/</span></label>
<input  name="diastolic" id="diastolic" name="diastolic" value="" placeholder="Diastolic" validate="diastolic,int,no" type="text" onblur=""	maxlength="3" class="allownumericwithoutdecimal textSmall"  tabindex="13"/></span>
<label class="smallAuto">mm&nbsp;Hg</label>

<label class="auto">Weight</label>
<input name="weight"  id="weight" type="text" maxlength="3"  class="allownumericwithoutdecimal textSmall"  value="" validate="weight,int,no" onblur="calculateBMI();" tabindex="14"/>
<label	class="smallAuto">Kg</label>

<label class="auto">Height</label>
<input	name="height" id="height" type="text"  maxlength="3" class="allownumericwithoutdecimal textSmall"  value="" validate="height,int,no" onblur="calculateBMI();" tabindex="15"/>
<label	class="smallAuto">cm</label>

<label class="auto" id="bpLabel">BMI</label>
<input	name="bmi" id="bmi"  type="text" value=""  readonly="readonly" class="textSmall" />
<label class="auto" id="bmiCat"></label>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div style="margin-left:80px">
<input type="button" class="button" value="submit" id="submit111" onclick="submitForm('preConsultationScreen','/hms/hms/ipd?method=submitPreConsultationAssessmentDetails&inpatientId=<%=inpatientId%>');"/>
<input type="button" class="button" name="reset" id="reset" value="Reset" onclick='fnReset();'/>
<input name="Back" type="button" alt="Back" value="Back" class="cmnButton" onclick="submitForm('preConsultationScreen','/hms/hms/ipd?method=showPatientListNurseJsp');" align="right" />
</div>

</div>
<%} %>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/jquery.min.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/jquery-ui.css">
<script>jQuery.noConflict();</script>
<div id="dialog-confirm"></div>

<script type="text/javascript">

function calculateBMI()
{
	
	$("#bmi").val("");
	if($("#height").val() != "" && $("#weight").val() !="" && !isNaN($("#height").val()) && !isNaN($("#weight").val()) && parseInt($("#height").val())!=0 && parseInt($("#height").val())!=0 )
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
		if($("#height").val() != "" && $("#weight").val() !="" && !isNaN($("#height").val()) && !isNaN($("#weight").val()) && parseInt($("#height").val())!=0 && parseInt($("#height").val())!=0 )
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

	 
	
	 
	


</script>
 
