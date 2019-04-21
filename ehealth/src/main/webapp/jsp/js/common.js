var S_Search_Searching = 'Refreshing...';
var S_Search_Error = '<span class="labelError">An error has occurred while contacting the server.</span>'
var S_Search_Single_Match = "match";
var S_Search_Multi_Matches = "matches";
var S_Search_NoMatches  = '<span class="labelError"><b>No Record Found</b></span>';
var currentPageNo=0;

var commonArray = new Array();
var codeNameArray = new Array();
var userArray = new Array();
var userArray2 = new Array();

function getMetaContentByName(name, content) {
    var content = (content == null) ? 'content' : content;
    return document.querySelector("meta[name='" + name + "']").getAttribute(content);
}

errorMsg = "";
function submitForm(formName,action,extraFunction,extraFunction2,extraFunction3){
// action = action.replace(/[`~!@#$^*|+\;:'"%<>\(\)\{\}\[\]\\]/gi, ''); // added
																		// by
																		// amit
																		// das
																		// on
																		// 13-06-2016
	action = action.replace(/[`~!@#$^*|+\;:'"%\(\)\{\}\[\]\\]/gi, '');	
errorMsg="";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName);
		if(eval("window."+extraFunction))
	    	ob1 =  eval(extraFunction+"()")

			if(eval("window."+extraFunction2))
	        	ob2 = eval(extraFunction2+"()")

			if(eval("window."+extraFunction3))
	        	ob3 = eval(extraFunction3+"()")
	        	
	        
	    	if(validateFields(formName)== true & ob1 & ob2 &ob3){

				if(obj.Submit11 != null){
					obj.Submit11.disabled=true;
				}
				if(obj.Submit12 != null){
					obj.Submit12.disabled=true;
				}

				obj.action = action;
				obj.submit();
	    	}else{

				if(errorMsg != ""){
					alert(errorMsg);
		       		return false;
		       	}

	    	}
	    	 return false;
	}


function postthread(param) {
if(param != null){
        param = document.getElementById(param);
        param.disabled = true;
        param.value="Posting...";
        }
}


function validateFields(formName){

		focusFlag = false;
		errors = "";
		errorMsg += loopThroughElements(formName);
		if(errorMsg == "")
			return true;
		else{
			return errorMsg;
		    }
	}


function submitFormForButton(formName,action,extraFunction,extraFunction2,extraFunction3){


errorMsg="";
  ob1 = true;
  ob2 = true;
  ob3 = true;
  obj = eval('document.'+formName)
  if(eval("window."+extraFunction))
      ob1 =  eval(extraFunction+"()")

   if(eval("window."+extraFunction2))
          ob2 = eval(extraFunction2+"()")

   if(eval("window."+extraFunction3))
          ob3 = eval(extraFunction3+"()")

   if(ob1 & ob2 &ob3){
          obj.action = action;
    obj.submit();

   }else{

    if(errorMsg != ""){
     alert(errorMsg);
           return false;
          }
          return true;
      }
 }
 errorMsgDisableSubmit = "";
function submitFormToDisableSubmit(formName,action,extraFunction,extraFunction2,extraFunction3){
errorMsgDisableSubmit="";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName);

		if(eval("window."+extraFunction))
	    	ob1 =  eval(extraFunction+"()")

			if(eval("window."+extraFunction2))
	        	ob2 = eval(extraFunction2+"()")

			if(eval("window."+extraFunction3))
	        	ob3 = eval(extraFunction3+"()")

			if(validateFieldsForDisableSubmit(formName)== true & ob1 & ob2 &ob3){
				if(document.getElementById('submitForDisable') != null){
					document.getElementById('submitForDisable').disabled=true
				}
	        	obj.action = action;
				obj.submit();
			}else{
				if(errorMsgDisableSubmit != ""){
					alert(errorMsgDisableSubmit);
		       		return false;
		       	}
		       	return true;
	    	}
	}
	function validateFieldsForDisableSubmit(formName){

		focusFlag = false;
		errorsForDisableSubmit = "";
		errorMsgDisableSubmit += loopThroughElements(formName);
		if(errorMsgDisableSubmit == "")
			return true;
		else{
			return errorMsgDisableSubmit;
		}
	}
	
	// Start open Donor Assesst Page
	function showDonorAssessmentJsp(formName){
 
		/*
		 * var breakFastStatus=document.getElementById('breakFastStatus').value
		 * var lunchStatus=document.getElementById('lunchStatus').value var
		 * dinnerStatus=document.getElementById('dinnerStatus').value
		 */

		 obj = eval('document.'+formName)

		 // alert(formName)
		  url = "/hms/hms/bloodBank?method=showDonorAssessmentJsp";
		  	obj.action = url;
   			obj.submit();

	}
	// End
	
	// Start open Donor Physical Examination Page
	function showPhysicalExaminationJsp(formName){
 
		/*
		 * var breakFastStatus=document.getElementById('breakFastStatus').value
		 * var lunchStatus=document.getElementById('lunchStatus').value var
		 * dinnerStatus=document.getElementById('dinnerStatus').value
		 */

		 obj = eval('document.'+formName)

		 // alert(formName)
		  url = "/hms/hms/bloodBank?method=showPhysicalExaminationJsp";
		  	obj.action = url;
   			obj.submit();

	}
	// End
	
function checkFoodData(formName){

		var breakFastStatus=document.getElementById('breakFastStatus').value
		var lunchStatus=document.getElementById('lunchStatus').value
		var dinnerStatus=document.getElementById('dinnerStatus').value


		 obj = eval('document.'+formName)


		if(breakFastStatus == "" && lunchStatus == "" && dinnerStatus == "")
		{
		 alert("Please Enter The Food Details")
		}

		if(breakFastStatus != "" && lunchStatus == "" && dinnerStatus == "" )
		{
		 // alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&status="+breakFastStatus;
		  	obj.action = url;
   			obj.submit();
		}
		if(lunchStatus != "" && breakFastStatus=="" && dinnerStatus == "")
		{
			// alert(formName)
 		  url = "/hms/hms/ipd?method=insertFoodTesting&status="+lunchStatus;
		  	obj.action = url;
   			obj.submit();
		}
		if(dinnerStatus != "" && lunchStatus == "" && breakFastStatus=="")
		{
		// alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&status="+dinnerStatus;
		  	obj.action = url;
   			obj.submit();
		}
		if(breakFastStatus != "" && lunchStatus != "" && dinnerStatus == ""  )
		{
		// alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&breakFastStatus="+breakFastStatus+"&lunchStatus="+lunchStatus;
		  	obj.action = url;
   			obj.submit();
		}
		if(breakFastStatus != "" && lunchStatus == "" && dinnerStatus != ""  )
		{
		// alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&breakFastStatus="+breakFastStatus+"&dinnerStatus="+dinnerStatus;
		  	obj.action = url;
   			obj.submit();
		}
		if(breakFastStatus =="" && lunchStatus != "" && dinnerStatus != ""  )
		{
		// alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&lunchStatus="+lunchStatus+"&dinnerStatus="+dinnerStatus;
		  	obj.action = url;
   			obj.submit();
		}
		if(breakFastStatus !="" && lunchStatus != "" && dinnerStatus != ""  )
		{
		// alert(formName)
		  url = "/hms/hms/ipd?method=insertFoodTesting&lunchStatus="+lunchStatus+"&dinnerStatus="+dinnerStatus+"&breakFastStatus="+breakFastStatus;
		  	obj.action = url;
   			obj.submit();
		}

	}

function validateRadio(){

			 for(var i = 0; i < document.getElementsByName('parent').length; i++){
			// alert("i-- "+i)
			// alert("document.getElementsByName('parent').length"+
			// document.getElementsByName('parent').length)
			  if(document.getElementsByName('parent')[i].checked == true)
              {

				return true;
			  }
  		}
  		alert("Please select the patient")
		return false;

	}
	function validateRadioForGroup(){

			 for(var i = 0; i < document.getElementsByName('groupHospitalId').length; i++){
			// alert("i-- "+i)
			// alert("document.getElementsByName('parent').length"+
			// document.getElementsByName('parent').length)
			  if(document.getElementsByName('groupHospitalId')[i].checked == true)
              {

				return true;
			  }
  		}
  		alert("Please select the Group")
		return false;

	}
	function validateRadioForSecurity(){

			 for(var i = 0; i < document.getElementsByName('userId').length; i++){
			// alert("i-- "+i)
			// alert("document.getElementsByName('parent').length"+
			// document.getElementsByName('parent').length)
			  if(document.getElementsByName('userId')[i].checked == true)
              {

				return true;
			  }
  		}
  		alert("Please Select the User")
		return false;

	}
	// Code By Mukesh 07 Jun 2011 for CSSD Template
	function validateRadioForCssdTemplate(){

		 for(var i = 0; i < document.getElementsByName('cssdTemplateId').length; i++){
		// alert("i-- "+i)
		// alert("document.getElementsByName('parent').length"+
		// document.getElementsByName('parent').length)
		  if(document.getElementsByName('cssdTemplateId')[i].checked == true)
         {

			return true;
		  }
		}
		alert("Please Select the Cssd Template")
	return false;

}
	function validateVisit(){


		 for(var i = 0; i < document.getElementsByName('parent').length; i++){
			// alert("i-- "+i)
			// alert("document.getElementsByName('parent').length"+
			// document.getElementsByName('parent').length)
			  if(document.getElementsByName('parent')[i].checked == true)
              {

				return true;
			  }
  		}
  		alert("Please select the purticular Visit of the patient")
		return false;



	}


function checkHospitalName(){
errorMsg="";
  	  obj1 = document.getElementById('loginName');
      loginName = obj1.value;
      var obj2;
      if(!(loginName == "superadmin"))
		{
			if(document.getElementById('defaultList').style.display == 'none'){
			   	 obj2 = document.getElementById('hospital');
			}else{
			     obj2 = document.getElementById('hospitalName');
			}
		    hospitalName = obj2.value;
	        if(hospitalName == 0)
	         {
		       errorMsg += "Hospital cannot be blank.\n";
		       return errorMsg;
	        }else
	          return true;
       }else
          return true;
   }



function loopThroughElements(frmName){

		inputs = eval('document.'+frmName+'.elements');

		errors = "";

		for(i=0;i<inputs.length;i++){
			if(inputs[i].type == 'text'
				|| inputs[i].type == 'select-one'
				|| inputs[i].type == 'select-multiple'
				|| inputs[i].type == 'textarea'
				|| inputs[i].type == 'password'){

				if(!inputs[i].getAttribute('validate'))
						continue;
				name = inputs[i].getAttribute('validate').substring(0,
					   inputs[i].getAttribute('validate').indexOf(','));
				type = inputs[i].getAttribute('validate').substring(inputs[i].getAttribute('validate').indexOf(',')+1,
					   inputs[i].getAttribute('validate').lastIndexOf(','));
	    		mandatory = inputs[i].getAttribute('validate').substring((inputs[i].
	    				getAttribute('validate').lastIndexOf(',')+1));
		    	textValue = trimAll(inputs[i].value);
		    	textValueForSpaces=(inputs[i].value);
		    	
				if(mandatory == "yes" & trimAll(textValue) == "" & trimAll(textValueForSpaces) == ""){
					errors += name + " cannot be blank.\n";
				}else if(mandatory == "yes" & textValue == '0' & textValueForSpaces == '0'){
					errors += "Select "+name + ".\n";
				}else if(inputs[i].name != "years" && inputs[i].name != "months" && mandatory == "yes" & textValue == '0' & textValueForSpaces == '0'){
					errors += "Select "+name + ".\n";
				}
				
				if(textValue!= "" & type == 'alphanumeric'){
					if(! validateAlphaNumeric(textValue))
						errors +="Field "+ name +" is not valid.\n";
				}else if(textValue!= "" & type == 'alphaspace'){
					if(!validateAlphaSpace(textValue))
						errors += "Field " + name + " is not valid.\n";
				}else if(textValue!= "" & textValue!= 'undefined' & type == 'goodString'){
				 	if(!validateGoodString(textValue))
						errors +="Field "+ name +" is not valid.\n";
				}else if(textValue!= "" & type == 'num'){
					if(!validateNumeric(textValue))
						errors += name + " should be a number.\n";
					else if(textValue!=null && textValue!='' && !chkPulseValue(textValue) && name=="pulse")
						errors += name+" should be less than 300 .\n";
				}else if(textValue!= "" & type == 'phone'){
					if(!validatePhone(textValue))
						errors += name + " should be a valid phone number.\n";
				}else if(textValue!= "" & type == 'email'){
					if(!validateEmail(textValue))
						errors +=name + " should be a valid Email-Id.\n";
				}else if(textValue!= "" & type == 'fullName'){
					if(!validateFullName(textValue))
						errors += "Field " + name + " should enter alpha characters only.\n";
				}
				else if(textValue!= "" & type == 'address'){
					if(!validateAddress(textValue))
						errors += "Field " + name + " should contain only valid characters.\n";
				}
				else if(textValue!= "" & type == 'int'){
				if(!validateInteger(trimAll(textValue)))
					errors += name + " should be a number(without spaces).\n";
				}
				else if(textValue!= "" & type == 'name'){
					if(!chkSpaces(textValue))
						errors += name + " cannot contain spaces.\n";
					else if(!validateName(textValue))
						errors += name + " is not a valid name.\n";
				}
				else if(textValue!= "" & type == 'remarks'){
				if(!validateRemarks(textValue))
					errors += name + " is not valid.\n";
				}
				else if(textValue!= "" & type == 'dateOfAdmission'){
				if(!validateDateOfAdmission(textValue))
					errors += name + " is not valid.\n";
				}
				else if(textValue!= "" & type == 'deliveryDate'){
				if(!validateDeliveryDate(textValue))
					errors += name + " is not valid.\n";
				}
				else if(textValue!= "" & type == 'fullName'){
				if(!validateFullName(textValue))
					errors += name + " is not a valid name.\n";
				}else if(textValue!= "" & type == 'float'){
					if(!validateFloat(textValue))
						{
						errors +=  name + " should contain integer or decimal value.\n";
						}
					else if(textValue!=null && textValue!='' && name=="temperature"&& !chkInputDecimal(textValue))
						{
						errors +=  name + " should contain decimal upto 2 decimal point and less than 999.99 .\n";							
						}
					else if(textValue!=null && textValue!='' && name=="systolic" && !chkInputDecimal(textValue))
					{
					errors +=  name + "should contain decimal upto 2 decimal point and less than 999.99 .\n";							
					}
					else if(textValue!=null && textValue!='' && name=="diastolic" && !chkInputDecimal(textValue))
					{
					errors +=  name + "should contain decimal upto 2 decimal point and less than 999.99 .\n";							
					}
				}else if(textValue!= "" & type == 'date'){
			    	if(!validateDate(textValue))
			    	 errors += name + " is not a valid date (dd/mm/yyyy).\n";
                }else if(textValue!= "" & type == 'numWithSlash'){
			    	if(!validateNumericWithSlash(textValue))
			    	 errors += name + " is not a valid .\n";
                }else if(textValueForSpaces!= "" & type == 'numWithoutSpaces'){
			    	if(!validateInteger(textValueForSpaces))
			    	 errors += name + " should be a number(without spaces).\n";
                }else if(textValueForSpaces!= "" & type == 'floatWithoutSpaces'){
			    	if(!validateFloat(textValueForSpaces))
			    	 errors += name + " should be a number(without spaces).\n";
                } else if(textValue!= "" & type == 'dateOfBirth'){
                	if(!validateFutureDate(textValue))
						errors +="Date of Birth cannot be future date\n";
					else if(!validateDateOfBirth(textValue))
						errors += "Please Enter Valid Date Of Birth\n";
                }
                else if(textValue!= "" & type == 'dateOfInteview')
                {
                	if(!validateFutureDate(textValue))
						errors += name + " cannot be future date\n";
				}else if(textValue!= "" & type == 'mobilephone')
				{
					if(!validateMobilePhone(textValue))
						{

						errors += "Please enter the valid " + name +  " .\n";

						}
				
			    }else if(textValue!= "" & type == 'metachar'){
						if(! validateMetaCharacters(textValue))
							errors +="Field "+ name +" is not valid.\n";
				}else if(textValue!= "" & type == 'metacharDot'){
					if(!validateMetaCharactersWithDot(textValue))
						errors +="Field "+ name +" is not valid.\n";
				}else if(textValue!= "" & type == 'alphanumericSlash'){
					if(! validateAlphaNumericWithoutSlash(textValue))
						errors +="Field "+ name +" is not valid.\n";
				}else if(textValue!= "" & type == 'metacharBrac'){
					if(! validateMetaCharactersWithBrace(textValue))
						errors +="Field "+ name +" is not valid.\n";
			}
				else if(textValue!= "" & type == 'metacharSpac'){
					if(! validateMetaCharactersWithSpace(textValue))
						errors +="Field "+ name +" is not valid.\n";
			}
			else if(textValue!= "" & type == 'metacharSpacBrac'){
				if(! validateMetaCharactersWithSpaceAndBrac(textValue))
					errors +="Field "+ name +" is not valid.\n";
		}
			
			else if(textValue!= "" & type == 'metacharSpacDas'){
				if(! validateMetaCharactersWithSpaceDas(textValue))
					errors +="Field "+ name +" is not valid.\n";
		}	
			else if(textValue!= "" & type == 'metacharSlash'){
				if(! validateMetaCharactersWithSlash(textValue))
					errors +="Field "+ name +" is not valid.\n";
		}
		else if(textValue!= "" & type == 'metacharSpaceSlash'){
			if(! validateMetaCharactersWithSpaceAndSlash(textValue))
				errors +="Field "+ name +" is not valid.\n";
		}else if(textValue!= "" & type == 'metacharSpaceSlashDash'){
			if(!validateMetaCharWithSpaceSlashDash(textValue))
					errors +="Field "+ name +" is not valid.\n";
		}
		else if(textValue!= "" & type == 'timeFormat'){
			if(!validateTime(textValue))
					errors +="Field "+ name +" is not valid.\n";
		}		
				
				
			
			
			}
		}
		return errors;
}


function validateMetaCharacters( strValue ) {
	var objRegExp=/(\s{2,})|([\\\/\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
	
}

function validateAlphaNumericWithoutSlash( strValue ) {
	
	// var objRegExp = /[^a-z*(\d)]/i;
	// Change by tarun
	var objRegExp=/(\s{2,})|([\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\n\r])/i

	// Change by tarun to allow ".","-",","
	// var objRegExp=/(\s{2,})|([\\\/\(\)\_\:\@\$\*\"\&\`\#\�\�\?\n\r])/i
	
	return !objRegExp.test(strValue);
	
}
// amit das on 22/03/2016
function validateMetaCharactersWithDot( strValue ) {
	var objRegExp=/(\s{2,})|([\\\/\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
	
}	
// javed khan on 25/10/2013
function validateMetaCharactersWithSlash( strValue ) {
	var objRegExp=/(\s{2,})|([\\\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);	
}
// javed khan on 07/11/2013
function validateMetaCharactersWithSpace( strValue ) {
	var objRegExp=/([\\\/\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
}

// javed khan on 07/11/2013
function validateMetaCharactersWithBrace( strValue ) {
	var objRegExp=/(\s{2,})|([\\\/\.\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
	
}

// javed khan on 08/11/2013
function validateMetaCharactersWithSpaceAndBrac( strValue ) {
	var objRegExp=/([\\\/\.\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
}

// javed khan on 08/11/2013
function validateMetaCharactersExam( strValue ) {
	var objRegExp=/([\\\_\:\@\$\*\"\&\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
	
}
function validateMetaCharWithSpaceSlashDash( strValue ) {
	var objRegExp=/([\\\.\(\)\_\:\@\$\*\"\&\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
}

// javed khan on 07/11/2013
function validateMetaCharactersWithSpaceDas( strValue ) {
	var objRegExp=/([\\\/\.\(\)\_\:\@\$\*\"\&\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
}
function validateMetaCharactersWithSpaceAndSlash( strValue ) {
	var objRegExp=/([\\\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
}

function validateTime(strValue)
{
	var objRegExp = /^([0-9]|0[0-9]|1[0-9]|2[0-3]):([0-9]|[0-5][0-9])$/
	return objRegExp.test(strValue);
}

function chkInputDecimal(strValue){
	 var objRegExp = /^(\d{1,3}|\d{0,3}\.\d{1,2})$/
		 
		 // [0-9]?[0-9]?(\.[0-9][0-9]?)?;
		 // alert(objRegExp.test(strValue));
	  return objRegExp.test(strValue);
}
function chkPulseValue(strValue){
		if(parseInt(strValue)>299){
			return false;
		}
	return true;
}

function validateDateOfBirth(strValue) {

	var isValid=true;
	var dob=new Date(strValue);
	var nowDate=new Date();
	if(!validateDate( strValue )){
		isValid=false;
	}

	else if( ((dob.getFullYear()+18) > nowDate.getFullYear()) || ((dob.getFullYear() + 140) < nowDate.getFullYear())){
		isValid=false;
	}
	return isValid;
}
	function validateFutureDate(strValue){
	date1 = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
	if(date1 > currentDate)
 	{
		return false;
 	}
	 return true;
}

function  validateName( strValue ) {
  var objRegExp = /[^a-z\d]/i;
  if(!(parseInt(strValue)>0))
  		return !objRegExp.test(strValue);
  return false;
}

function chkSpaces(strValue){
	for(j=0; j<strValue.length; j++){
		if(strValue[j]==" ")
			return false;
	}
	return true;
}

function validateInteger( strValue ) {
  var objRegExp  = /(^\d\d*$)/;
  return objRegExp.test(strValue);
}

function validateRemarks( strValue ){
	var objRegExp  = /[^a-z*(\.\-\&\d\s\:\@\#\$\^\*\(\)\{\}\[\]\;\"\,\<\>\?\/\_\\\+\=)]/i;
	if(strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "&"){
			return false;
	}
	else{
		return !objRegExp.test(strValue);
	}
}

function validateDateOfAdmission(strValue) {
   	dateOfJoining = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
	if(dateOfJoining > currentDate)
 	{
		return false;
 	}
	 return true;
}
function validateDeliveryDate(strValue) {
   	dateOfJoining = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
	if(dateOfJoining < currentDate)
 	{
		return false;
 	}
	 return true;
}
function validateFullName( strValue ) {

	var objRegExp  = /[^a-z*(\.\, )]/i;
	if(parseInt(strValue)>0){
		return false;
	}
	else if(strValue.substring(0,1) == ".")
	{
			return false;
	}
	else{
			return !objRegExp.test(strValue);
	}
}
function  validateNumeric( strValue ) {
  var objRegExp  =  /(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/;
  return objRegExp.test(strValue);
}

function validateMobilePhone( strValue ) {
	if(strValue.length < 10 || strValue.length > 12)
	    return false;
   	else
  		return validateInteger(strValue);
}

function validateGoodString( strValue )
{
	if (validateNumeric(strValue)) return false;

	if (validateAlphaNumeric(strValue))
		return true;
	else
		return false;
}

function validateAlphaNumeric( strValue ) {

	// var objRegExp = /[^a-z*(\d)]/i;
	// Change by tarun
	var objRegExp=/(\s{2,})|([\\\/\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\n\r])/i

	// Change by tarun to allow ".","-",","
	var objRegExp=/(\s{2,})|([\\\/\(\)\_\:\@\$\*\"\&\`\#\�\�\?\n\r])/i

	return !objRegExp.test(strValue);

}
function validateAlphaNumericName( strValue ) {

	// var objRegExp = /[^a-z*(\d)]/i;
	// Change by tarun
	var objRegExp=/(\s{2,})|([\\\/\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\n\r])/i

	// Change by tarun to allow ".","-",","
	var objRegExp=/(\s{2,})|([\\\/\(\)\_\:\@\$\*\"\&\`\#\�\�\?\n\r])/i

	return !objRegExp.test(strValue);

}
function validateAlphaSpace( strValue ) {

	var objRegExp  = /[^a-z*(\d\,\\\/\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\n\r )]/i;
	if(!(parseInt(strValue)>0)){
		if(strValue.substring(0,1)=="," || strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "'" ){
			return false;
		}
		else{
			return !objRegExp.test(strValue);
		}
	}
  	return false;
}

function validatePhone( strValue ) {
		var objRegExp  = /^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$/
  		return objRegExp.test(strValue);
}

function validateInteger( strValue ) {
  var objRegExp  = /(^\d\d*$)/;
  return objRegExp.test(strValue);
}

function validateAddress( strValue ) {

	var objRegExp = /[^a-z*(\d\,\\\/\.\(\)\_\:\"\&\-\'\`\#\�\�\n\r )]/i;
	if(strValue.substring(0,1)=="," || strValue.substring(0,1) == "." || strValue.substring(0,1) == "-" || strValue.substring(0,1) == "'" ){
		return false;
	}
	else{
		return !objRegExp.test(strValue);
	}
	return false;
}

function validateEmail(strValue) {
	// var objRegExp
	// =/^([a-zA-Z_\.\-][\w]*[a-zA-Z0-9\_])+\@(([a-zA-Z0-9\-])+\.)+(([a-zA-Z]{2,4})*([a-zA-Z]{2,4}))+$/;
	var objRegExp  = /^[a-zA-Z][\w\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\w\.-]*[a-zA-Z0-9]\.[a-zA-Z][a-zA-Z\.]*[a-zA-Z]$/;
	return objRegExp.test(strValue);
// if(objRegExp.test(strValue))
   // return checkEmail(strValue);

}

function validateFloat( strValue ) {
 	// var objRegExp =/^((\+|-)\d)?\d*(\.\d{2})?$/;
 	// var objRegExp =/^([+\-])?\d*([\.])?\d*([eE]([+\-])?)?\d*$/;
// var objRegExp = ^(?=.+)(?:[1-9]\d*|0)?(?:\.\d+)?$;
 	
	var objRegExp = /^\d+(\.\d{1,2})?$/;
 	return objRegExp.test(strValue);
}


function checkEmail(strValue)
	{
		var checkEmail=true;
 		var mytool_array=strValue.split("@");
		var afterRateArray= mytool_array[1].split(".");

 		if(afterRateArray.length>3) {
 			checkEmail=false;
 		}
 		else if(afterRateArray.length == 3){
 		   if(afterRateArray[1].length>2 || afterRateArray[2].length>2){
 		    checkEmail=false;
 		   }
 		}
 		else if(afterRateArray.length == 2){
 		   if(afterRateArray[1].length>3 || afterRateArray[1].length == 2){
 		   checkEmail=false;
 		   }
 		}

 		if(!checkEmail)
 		{
 			return false;
 		}

 		return true;
 	}


function submitFormCancel(formName,action){
			obj = eval('document.'+formName)
			obj.action = action;

			obj.submit();
			return true;
}

function checkBlankForAdd(){

	var code = document.getElementById("id").value;
	if(trimAll(code) == ""){
			errorMsg += "Code cannot be blank.\n";
		return false;
	}
		return true;
}
// -------------------------- Room -------------------
function checkBlankForAddRoom(){

  	var depName = document.getElementById("depName").value;
	var roomType = document.getElementById("roomType").value;
	if(trimAll(depName) == ""){
			errorMsg += "Department Name cannot be blank.\n";
	}
	if(trimAll(roomType) == ""){
			errorMsg += "Room Type cannot be blank.\n";

	}
		return true;
}

function checkBlankForAddDistrict(){

  	var state = document.getElementById("state").value;
  	var code = document.getElementById("id").value;
	if(trimAll(code) == ""){
			errorMsg += "Code cannot be blank.\n";
		return false;
	}
	if(trimAll(state) == ""){
			errorMsg += "State cannot be blank.\n";

	}
		return true;

}

function checkBlankCountry(){
var countName=document.getElementById("countName").value;
if (trimAll(countName) == ""){
errorMsg += "Currency Name cannot be blank.\n";
}
return true;
}

function checkBlank(){

	var id = document.getElementById('commonId').value;
	var name = document.getElementById('searchname').value;

	if(id == 0 && trimAll(name) == ""){
		errorMsg += "Please select any Name.\n";
		return false;
	}
	if(id != 0 && trimAll(name) == ""){
		errorMsg += "Name cannot be blank.\n";
		return false;
	}

	return true;
}

function checkBlankForAddBed(){

	var ward = document.getElementById("wardId").value;
	var room = document.getElementById("roomId").value;
	var bedStatus = document.getElementById("bedStatusId").value;

	if(trimAll(ward) == ""){
			errorMsg += "Ward cannot be blank.\n";
	}
	if(trimAll(room) == ""){
			errorMsg += "Room Code cannot be blank.\n";
	}
	if(trimAll(bedStatus) == ""){
			errorMsg += "Bed Status cannot be blank.\n";
	}
		return true;
}

function checkBlankCountry(){
	var countName=document.getElementById("countName").value;
	var id = document.getElementById("id").value;
	if(trimAll(id) == ""){
				errorMsg += "Code cannot be blank.\n";
		}
	if (trimAll(countName) == ""){
	errorMsg += "Currency Name cannot be blank.\n";
	}
	return true;
}

function checkBlankState(){
	var countName=document.getElementById("countName").value;
	var id = document.getElementById("id").value;
	if(trimAll(id) == ""){
				errorMsg += "Code cannot be blank.\n";
		}
	if (trimAll(countName) == ""){
	errorMsg += "Country Name cannot be blank.\n";
	}
	return true;
}

function checkBlankForAddDepartment(){

	var departmentType = document.getElementById("departmentTypeId").value;
	var costCenter = document.getElementById("costCenterId").value;
	var id = document.getElementById("id").value;

	if(trimAll(id) == ""){
			errorMsg += "Code cannot be blank.\n";
	}
	if(trimAll(departmentType) == ""){
			errorMsg += "Department Type cannot be blank.\n";
	}
	if(trimAll(costCenter) == ""){
			errorMsg += "Cost Center cannot be blank.\n";
	}
	return true;
}


// Added by tarun to change the date from yyyymmdd (stored in database) to
// ddmmyyyy
function changeDateToddMMyyyy(strDate)
{
	var strNewDate="",year="",ch="",dt="",month="";

	year=strDate.substring(0,4);
	month=strDate.substring(5,7);
	dt=strDate.substring(8,10);
	strNewDate= (dt + "/" + month + "/" + year);
	return strNewDate;
}




// -----------------Added By Ruchi
// ----------------------------------------------

function fetchValue(obj,formName){

  object =    eval('document.'+formName)
     if(obj.value != ""){
     for(var i = 0;i<commonArray.length;i++ ){
      if(commonArray[i][0] == obj.value){

      	   object.code.value = commonArray[i][1];
           object.search_name.value = commonArray[i][2];
           object.changed_by.value = commonArray[i][4];
           object.changed_date.value = changeDateToddMMyyyy(commonArray[i][5]);
           object.changed_time.value = commonArray[i][6];
           if(commonArray[i][3] == "y")
               object.status[0].checked = true;
           else
               object.status[1].checked = true;
           break;
       }
   }
  }
  else{
           object.code.value = "";
           object.search_name.value = "";
           object.changed_by.value = "";
           object.changed_date.value = "";
           object.changed_time.value = "";
           object.status[0].checked = true;
 }

}

function fetchName(obj,formName){
  var object =    eval('document.'+formName)
  if(obj.value != ""){
    for(var i = 0;i<codeNameArray.length;i++ ){
      if(codeNameArray[i][0] == obj.value){

           object.related_table_id.value = codeNameArray[i][2];

           break;
       }
   }
  }
  else{
             object.related_table_id.value = "";
  }

}

function fetchAllValue(obj,formName){

  object =    eval('document.'+formName)
  if(obj.value != ""){
   for(var i = 0;i<commonArray.length;i++ ){
      if(commonArray[i][0] == obj.value){

           object.code.value = commonArray[i][1];
           object.search_name.value = commonArray[i][2];
           object.changed_by.value = commonArray[i][5];
           object.changed_date.value = changeDateToddMMyyyy(commonArray[i][6]);
           object.changed_time.value = commonArray[i][7];
           if(commonArray[i][4] == "y")
               object.status[0].checked = true;
           else
               object.status[1].checked = true;

           for(var j= 0;j<codeNameArray.length;j++){
                 if(commonArray[i][3] == codeNameArray[j][0]) {
                    object.related_table_id.value = commonArray[i][3];
                    object.related_table_name.value = codeNameArray[j][2];
                    break;
                 }
           }
           break;
       }
   }
  }
  else{
           object.code.value = "";
           object.search_name.value = "";
           object.changed_by.value = "";
           object.changed_date.value = "";
           object.changed_time.value = "";
           object.status[0].checked = true;
           object.related_table_id.value = "";
           object.related_table_name.value = "";
 }

}


function fetchDepartmentValue(obj,formName){

  object = eval('document.'+formName)
  if(obj.value != ""){
   for(var i = 0;i<commonArray.length;i++ ){
      if(commonArray[i][0] == obj.value){

           object.code.value = commonArray[i][1];
           object.search_name.value = commonArray[i][2];
           object.department_type_id.value = commonArray[i][3];
           object.cost_center_id.value = commonArray[i][4];
           object.changed_by.value = commonArray[i][6];
           object.changed_date.value = changeDateToddMMyyyy(commonArray[i][7]);
           object.changed_time.value = commonArray[i][8];
           if(commonArray[i][5] == "y")
               object.status[0].checked = true;
           else
               object.status[1].checked = true;
           break;
       }
   }
  }
  else{
           object.code.value = "";
           object.search_name.value = "";
           object.department_type_id.value = "";
           object.cost_center_id.value = "";
           object.changed_by.value = "";
           object.changed_date.value = "";
           object.changed_time.value = "";
           object.status[0].checked = true;
 }

}

function fetchDistrictValue(obj,formName){

  object = eval('document.'+formName)
  if(obj.value != ""){
   for(var i = 0;i<commonArray.length;i++ ){
      if(commonArray[i][0] == obj.value){

           object.code.value = commonArray[i][1];
           object.search_name.value = commonArray[i][2];
           object.state_id.value = commonArray[i][3];
           object.changed_by.value = commonArray[i][5];
           object.changed_date.value = changeDateToddMMyyyy(commonArray[i][6]);
           object.changed_time.value = commonArray[i][7];
           object.state.value = commonArray[i][8];
           if(commonArray[i][4] == "y")
               object.status[0].checked = true;
           else
               object.status[1].checked = true;
           break;
       }
   }
  }
  else{
           object.code.value = "";
           object.search_name.value = "";
           object.state_id.value = "";
           object.changed_by.value = "";
           object.changed_date.value = "";
           object.changed_time.value = "";
           object.status[0].checked = true;
 }


}


function fetchHospitalDetails(obj,formName){

  object = eval('document.'+formName)
  if(obj.value != ""){
   for(var i = 0;i<commonArray.length;i++ ){
      if(commonArray[i][0] == obj.value){

           object.hospital_code.value = commonArray[i][1];
           object.search_name.value = commonArray[i][2];
           object.address.value = commonArray[i][3];
           object.contact_number.value = commonArray[i][4];
           object.changed_by.value = commonArray[i][6];
           object.changed_date.value = changeDateToddMMyyyy(commonArray[i][7]);
           object.changed_time.value = commonArray[i][8];
           if(commonArray[i][5] == "y")
               object.status[0].checked = true;
           else
               object.status[1].checked = true;
           break;
       }
   }
  }
  else{
           object.hospital_code.value = "";
           object.search_name.value = "";
           object.address.value = "";
           object.contact_number.value = "";
           object.changed_by.value = "";
           object.changed_date.value = "";
           object.changed_time.value = "";
           object.status[0].checked = true;
 }


}


// ////////////////////////////////End
// ////////////////////////////////////////////////////////

function trimAll( strValue ) {
 var objRegExp = /^(\s*)$/;

    // check for all spaces
    if(objRegExp.test(strValue)){
       strValue = strValue.replace(objRegExp, '');
       if( strValue.length == 0)
          return strValue;
    }

   // check for leading & trailing spaces
   objRegExp = /^(\s*)([\W\w]*)(\b\s*$)/;
   if(objRegExp.test(strValue)) {
       // remove leading and trailing whitespace characters
       strValue = strValue.replace(objRegExp, '$2');
    }
  return strValue;
}

currentRowClicked=""
function clearRecords(obj){
		if(document.getElementById('multiplebutton'))
			document.getElementById('multiplebutton').style.display = "none";
	if(currentRowClicked != ""){
		editRecord(document.getElementById(currentRowClicked),formName)

	}

	obj.blur();
}
// //////////////////////////////////////// Charge Code by Mansi
// ///////////////////////

function results(obj){
	if(obj.checked == true){

		document.getElementById('show').style.display = "block";
		}
	else{
		document.getElementById('show').style.display = "none";
		}
}

function multipleResults(obj){
	if(obj.checked == true){

		document.chargeCode.multiple.style.display = "block";
		}
	else{
		document.chargeCode.multiple.style.display = "none";
		}
}


showOnSamePage = true;
addAction = true;
rowsPerPage = 5;
totalPages =""
currentColor = "odd";

function intializeHover(id, nodeName, className){
	navRoot = document.getElementById(id);
	if(!navRoot)
		return;
	for (i=0; i<navRoot.childNodes.length; i++) {
		node = navRoot.childNodes[i];
		if (node.nodeName==nodeName) {
			node.onmouseover=function() {
				this.className+= className;
			}
			node.onmouseout=function() {
				this.className=this.className.replace(className, "");
			}
		}
	}
}

/*--------------Hover on TR's for IE Ends-----------------------------*/
/*----------------------------Set Scrolling Area of every page according to screen resolution--------------*/

function checkSize() {
  var myHeight = 0;
  if( typeof( window.innerWidth ) == 'number' ) {
    // Non-IE
    myHeight = window.innerHeight-138;
  }
  else {
  	  if( document.documentElement &&
	    ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
      // IE 6+ in 'standards compliant mode'
      myHeight = document.documentElement.clientHeight-168;
    }
	else {
      if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
        // IE 4 compatible
        myHeight = document.body.clientHeight-142;
      }
    }
  }
  return myHeight;
}

/*----------------------------Set Scrolling Area Ends--------------------*/


/*-------------------Some General Functions---------------------------*/
function findDiv(obj){
	while(obj.nodeName != 'DIV'){
			obj = obj.nextSibling;
	}
	return obj;
}
window.onresize = function (){
	if(document.getElementById('content')){
		document.getElementById('content').style.height = checkSize()+"px";
	}
}


function editForm(formName,action){
		errorMsg = "";
		if(currentRowClicked == ""){
			alert("Select a record to update");
			return false;
		}
		obj = eval('document.'+formName)
		if(validateFields(formName)== true){
			undoDisabled();
			obj.action = action;
			obj.submit();
		}
		else{
	    	alert(errorMsg);
	       	return false;
		}
}

deleteMessage ="Are you sure to InActivate this record?"
function deleteForm(formName,action){
		obj = eval('document.'+formName)
		if(currentRowClicked == ""){
			alert("Select a record to InActivate");
			return false;
		}

		undoDisabled();
		if(confirm(deleteMessage)){
			obj.action = action;
			obj.submit();
		}
}


subtest_arr = new Array();
currentRowClicked=""
nonEditable="";


function editRecord(obj,formName){
	tmptext = "";
		// added By Ujjwal for Accunt Master on 10/09/2015
		// if(formName=='accountMaster'){
		// document.getElementById('parentDiv').style.display = 'none';
		// document.getElementById('agnId').readonly=true;
		// }
		// end By Ujjwal
      if(formName == "parameterTest"){
			document.getElementById('machineParamId').value= obj.id;
			
			//parameterTest.machineParamId.value=currentRowClicked;
			
		}
	if(currentRowClicked != "" ){
		// if(subtest_arr.length>0){
			// document.chargeCode.multipleresults.checked = false;
			// document.getElementById('multiplebutton').style.display = 'none';
		// }
		/**
		 * Added By Ritu For laundry module------
		 */
		if(formName == "machineActivityEntry"){
			var obj11 = eval('document.'+formName);
			obj11.action = '/hms/hms/laundry?method=showMachineActivityEntry';
			obj11.submit();
		}
		if(formName == "carDiaryEntry"){
			var obj11 = eval('document.'+formName);
			obj11.action = '/hms/hms/laundry?method=showCarDiaryEntry';
			obj11.submit();
		}
          
		
		/*
		 * -------------- End of Code by Ritu----
		 */
		if(nonEditable){
			for(m=0;m<nonEditable.length;m++){
				nonEditableObj = eval("document."+ formName + "."  + nonEditable[m])
				if(nonEditableObj){
					if(nonEditableObj.type == "select-one"){
						nonEditableObj.disabled = false;
					}
					else{
						nonEditableObj.readOnly = false;
					}
				}
			}
		}
		if(document.getElementById(currentRowClicked))

			document.getElementById(currentRowClicked).style.backgroundColor = "";
		document.getElementById('edited').innerHTML = " "
		if(document.getElementById('addbutton'))
			document.getElementById('addbutton').style.display = 'inline'
		if(document.getElementById('editbutton'))
			document.getElementById('editbutton').style.display = 'none';
		if(document.getElementById('deletebutton'))
			document.getElementById('deletebutton').style.display = 'none';

		for(i=0;i<formFields.length;i++){
			temp = eval("document."+ formName + "." +  formFields[i][1]);
			if(formName == 'chargeCode'){
			// document.getElementById('goDiv').style.display='none';
			}
			if(temp){
				if(temp.type == "select-one")
					temp.selectedIndex = 0;
				else if(temp.type == "checkbox"){
						temp.checked = false;
				}
				else
					temp.value = "";
			}
		}
	}

	if(currentRowClicked != obj.id){
		changeButton(obj.id,formName);
		deleteobj = eval("document."+ formName )
		deleteTd = data_arr[findArrayElement(data_arr,obj.id)][statusTd]
		
		if(deleteTd.toLowerCase()=="inactive")
		{
			if(document.getElementById('editbutton'))
				document.getElementById('editbutton').style.display = 'none'
		}
		else if(document.getElementById('editbutton')){
			if(formName != 'chargeType')
				document.getElementById('editbutton').style.display = 'inline'
			}
		if(document.getElementById('deletebutton')){
			if((formName == 'menuItemFormula' || formName == 'extraItemFormula')  && deleteTd.toLowerCase() == "inactive"){
				document.getElementById('deletebutton').style.display = 'none'
		}else if(formName == 'loanHeader'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'loanDetail'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'reimbHeader'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}
    	else if(formName == 'reimbDetail'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'bonusDetail'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'advance'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'advanceDetail'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'arrear'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'arrearSalary'  ){
    			document.getElementById('deletebutton').style.display = 'none'
    	}else if(formName == 'packageServices' ){
    		document.getElementById('deletebutton').style.display = 'none';
    	}else if(formName == 'packageMedicines' ){
    		document.getElementById('deletebutton').style.display = 'none';
    	}// else if(formName == 'departmentType' || formName ==
			// 'chargeType'){
    	else if(formName == 'chargeType'){
    		document.getElementById('deletebutton').style.display = 'none';
    	}
    	else{
				document.getElementById('deletebutton').style.display = 'inline'
				}
		}
		if(document.getElementById('addbutton'))
			document.getElementById('addbutton').style.display = 'none';
		// if(subtest_arr.length>0){
		// chkMultipleTest(obj.id);
		// }
		if(nonEditable){
			for(m=0;m<nonEditable.length;m++){
				nonEditableObj = eval("document."+ formName + "."  + nonEditable[m])
				if(nonEditableObj){
					if(nonEditableObj.type == "select-one"){
						nonEditableObj.disabled = true;
					}
					else
						nonEditableObj.readOnly = true;
				}
			}
		}
		obj.style.backgroundColor = '#9CCEF8'
		currentRowClicked=obj.id;
		for(i=0;i<formFields.length;i++){
			temp = eval("document."+ formName + "."  +  formFields[i][1]);
			if(formFields[i][1] == "addEditBy")
				tmptext += "<label>last Edited By</label><span>"+ obj.cells[formFields[i][0]-1].childNodes[0].innerHTML +"</span>"
			if(formFields[i][1] == "addEditOn")
				tmptext += "<label>On</label><span>"+ obj.cells[formFields[i][0]-1].childNodes[0].innerHTML +"</span>"
			if(temp){
				if(temp.type == "select-one"){
					if(i==11){ // added by govind 17-11-2016
						editBagQuantity();
					}                   
					if(formName == "subTest"){
						temp.selectedIndex = findElementIndex(temp, obj.cells[formFields[i][0]-1].innerHTML);
				}	else{
						if(formName == "chargeCode"){
							var tempValue = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;

							if(tempValue.indexOf('&amp;') != -1){
								tempValue = replaceSubstring(tempValue, '&amp;', '&');
							}
							if(temp.id == 'investigationType'){
								if(tempValue == 't' || tempValue == 'm'){
									document.getElementById('goDiv').style.display='inline';
								}else{
									document.getElementById('goDiv').style.display='none';
								}
							}
							temp.selectedIndex = findElementIndex(temp, tempValue);
						}else{
							temp.selectedIndex = findElementIndex(temp, obj.cells[formFields[i][0]-1].childNodes[0].innerHTML);
						}
						// temp.selectedIndex = findElementIndex(temp,
						// obj.cells[formFields[i][0]-1].childNodes[0].innerHTML);
					}
				}
				else if(temp.type == "radio"){
					if(obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == '1' || obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == 'y')
						temp.checked = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
				}
				else if(temp.type == "checkbox"){
					if(obj.cells[formFields[i][0]-1]!=undefined && obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == '1' || 	obj.cells[formFields[i][0]-1].childNodes[0].innerHTML=='y' || 	obj.cells[formFields[i][0]-1].childNodes[0].innerHTML=='Y'){
						temp.checked = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
					}
				}
				else if(temp.type == "select-multiple")
				{
					if (temp.id == "item_master_brand")
					{
							var brand_ids =  obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
							bar = new Array();
			  				bar  = brand_ids.split(",");
			  				var all_brand = document.getElementById('all_item_master_brand')
			  				temp.options.length=0;
			  				for(var l=0; l<all_brand.length;l++)
							{
								for(var m=0; m<bar.length;m++)
								{
									if (all_brand[l].value == bar[m])
									{
									temp.length++;
									temp.options[temp.length-1].value=all_brand.options[l].value;
									temp.options[temp.length-1].text=all_brand.options[l].text;
									break;
									}
								}
							}
					}else
					{
						if(formName == "dietMenuItem"){
							temp.selectedIndex = findElementIndex(temp, obj.cells[formFields[i][0]-1].childNodes[0].innerHTML);
						}else{
				    		var brand_ids =  obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
							bar = new Array();
							
			  				bar  = brand_ids.split(",");
							for(var k=0; k<temp.length;k++)
			  				{
			  					temp[k].selected = false;
			  				}

		  					for(var l=0; l<temp.length;l++)
							{
								for(var m=0; m<bar.length;m++)
								{
									if (temp[l].value == bar[m])
									{
									temp[l].selected = true;
									break;
									}
								}
							}
						}
					}
				}
				else{
					if(i==0)
						temp.value = obj.id;
					else{
						if(formName == "subTest"){
							temp.value = obj.cells[formFields[i][0]-1].innerHTML;
						}
						else
							temp.value = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
						if(temp.value.indexOf('&amp;') != -1){
							temp.value = replaceSubstring(temp.value, '&amp;', '&')
						}
					}
				}
			}
		}
	}
	else if(currentRowClicked == obj.id){
		// if(subtest_arr.length>0){
			// document.chargeCode.multipleresults.checked= false;
			// document.getElementById('multiplebutton').style.display = 'none';
		// }
		
		if(formName == "parameterTest"){
			
			document.getElementById('machineParamId').value= obj.id;
			//parameterTest.machineParamId.value=currentRowClicked;
			
		}
		currentRowClicked = "";
	}
	if(tmptext != ""){
		document.getElementById('edited').innerHTML = tmptext;
	}
	// -------------------------------------
	if(formName == "advance" || formName == "arrear" ||formName == "arrearSalary" ||formName == "loanDetail"){

  	document.getElementById('empId').disabled=true;
 }
	// javed khan
	if(formName == "employee"){
		empId = obj.id
		submitProtoAjax('employee','personnel?method=getEducationAndExper&empId='+empId);
		// submitProtoAjax('employee','personnel?method=getEducationAndExper1&empId='+empId);
	}
	 if(formName == 'departmentGroup'){
	    	 url = "/hms/hms/generalMaster?method=showDeparmentGroupValue&deptGroupId="+obj.id;
		    submitProtoAjax('departmentGroup',url);
	   	}
		
		



}

function undoDisabled(){
	for(m=0;m<nonEditable.length;m++){
		nonEditableObj = eval("document."+ formName + "."  + nonEditable[m])
			if(nonEditableObj){
				if(nonEditableObj.type == "select-one"){
					nonEditableObj.disabled = false;
				}
			}
	}
}
function findArrayElement(arr, findWhat){
	for(cnt=0;cnt<arr.length;cnt++){
		if(arr[cnt][0]==findWhat){
			return cnt;
		}
	}
}
statusTd = "";
function changeButton(id,formName){
	if(statusTd!=""){
		deleteTd = data_arr[findArrayElement(data_arr,id)][statusTd]
		fobj = eval("document."+formName);
		if(deleteTd.toLowerCase()=="active" && formName !="loanHeader" && formName != "loanDetail" && formName != 'packageServices' && formName != "reimbHeader" && formName != "reimbDetail" && formName != "bonusDetail" && formName != "advance" && formName != "advanceDetail" && formName != "arrear" && formName != "arrearSalary" && formName != 'packageMedicines'){
			fobj.Delete.value="InActivate";
		}
		else{
			if(formName != "menuItemFormula" && formName != 'extraItemFormula' && formName != 'packageServices' && formName !="loanHeader" &&  formName != "loanDetail" && formName != "reimbHeader" && formName != "reimbDetail" && formName != "bonusDetail" && formName != "advance" && formName != "advanceDetail" && formName != "arrear" && formName != "testOPD" && formName != "arrearSalary"   && formName != 'packageMedicines' ){
				fobj.Delete.value="Activate";
				}else{
					if(formName=='testOPD'){
						fobj.Delete.value="Delete";
					}else {
						document.getElementById('deletebutton').style.display = 'none';
					}
			}
		}

	}
}

function findElementIndex(obj, txtVal){
	var txt = txtVal.replace(/ +(?= )/g,'')
	
	for(j=0;j<obj.length;j++){
		if(obj[j].text == txt ||obj[j].value == txt){
			return j;
		}
	}
}


showOnSamePage = true;
addAction = true;
rowsPerPage = 5;
totalPages =""
currentColor = "odd";
function makeTable(starter, end){

	if(document.getElementById('pageNoEdit'))
		document.getElementById('pageNoEdit').value = Math.ceil(parseInt(end)/5);

    totalPages = Math.ceil(data_arr.length/rowsPerPage);
    document.getElementById("total").innerHTML=totalPages
    document.getElementById("totalRecs").innerHTML=data_arr.length
    if(totalPages==0){
	    document.getElementById('searchtable').style.width = "50%"
    	document.getElementById('searchtable').style.textAlign = "left"
        document.getElementById('searchtable').innerHTML = '<h4>No Records Found</h4>'
		document.getElementById('resultnavigation').style.display="none";
        return;
    }
    else if(totalPages == 1){
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"
    }
    document.getElementById('resultnavigation').style.display="inline";
    // document.getElementById('pageno').length=totalPages
    for(pg=1;pg<=totalPages;pg++){
        // document.getElementById('pageno')[pg-1].value = pg
        // document.getElementById('pageno')[pg-1].text = pg
    }
    start = starter;
    if(data_header){
                tempTable = '<table border="0" cellspacing="0"  cellpadding="0" ><thead><tr>'
        for(cols=0;cols<data_header.length;cols++){
            if(data_header[cols][1]=="data"){
                tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            }
            else if(data_header[cols][1]=="hide"){
                    tempTable += '<th class="hide">&nbsp;</th>'
            }else if(data_header[cols][1]=="radio"){
            		 tempTable += '<th  width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            	}
        }
        tempTable += '<tr></thead><tbody id="searchresulttable">'
        for(rows=start;rows<end; rows++){
                tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
				if(rows%rowsPerPage == 0 && rows != 0){
					currentColor = "odd"
				}

                tempTable += currentColor;
				currentColor = (currentColor == "odd")?"even" : "odd";
                tempTable += '">'
                for(columns=1;columns<=data_header.length;columns++){
                    tempTable += '<td '

                    if(data_header[columns-1][1] == "hide")
                        tempTable += 'class="hide"';
                 tempTable +='>';
                    if (formName=='ipdDialysisList' || formName=='patientEnquiry'  || formName=='patientSearch'||formName=='preAnaesthesiaPatientSearch'||formName=='preAnaesthesiaPatientSearch1'||formName=='otProcedureNotesEntry'||formName=='specimenDispatchEntryPatientSearch' || formName=='patientSearchForDisposal' || formName=='UnservicedDispensing'  || formName=='CurrentDispensing' || formName=='empanelled')
                    {
                    	
                    	tempTable += '<a href="javascript:Request((\''+data_arr[rows][2]+'\'),\''+formName+'\')">';
                    }
                    // formname = 'consent1' removed from above by by amit das
					// on 26-09-2016
                    // added by amit das on 26-09-2016
                    else  if(formName=='consent1')
                    {             	
                    	tempTable += '<a href="javascript:Request((\''+data_arr[rows][2]+':'+data_arr[rows][8]+'\'),\''+formName+'\')">';
                    } 
                  // added by Arbind on 27-07-2017
                    else  if(formName=='consentLetter')
                    {             
                    	tempTable += '<a href="javascript:Request((\''+data_arr[rows][2]+':'+data_arr[rows][8]+':'+data_arr[rows][7]+'\'),\''+formName+'\')">';
                    } 
                 // added by Arbind on 31-10-2017
                    else  if(formName=='bloodConsent')
                    {             
                    	tempTable += '<a href="javascript:Request((\''+data_arr[rows][1]+':'+data_arr[rows][4]+'\'),\''+formName+'\')">';
                    } 
                    else  if(formName=='bloodConsentLetter')
                    {             
                    	tempTable += '<a href="javascript:Request((\''+data_arr[rows][1]+':'+data_arr[rows][4]+':'+data_arr[rows][5]+'\'),\''+formName+'\')">';
                    } 
                    // formname = 'surgeryCheckList' added by amit das on
					// 22-09-2016
                    else  if(formName=='consent11'  || formName=='intraOperativeTimeOut'  || formName=='otSignOut' || formName=='surgeryCheckList')
                    {                    	
                    	tempTable += '<a href="javascript:Request((\''+data_arr[rows][8]+'\'),\''+formName+'\')">';
                    }
                    
                    else  if(formName=='postAnaesthesiaPatientSearch')
                    {             	
                    	tempTable += '<a href="javascript:Request((\''+data_arr[rows][6]+'\'),\''+formName+'\')">';
                    }
                     else if(formName == "pendingResultForLab")
                    {
                    	 
                    
                   		tempTable += '<a href="javascript:RequestForChargeLab(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
                     else if(formName == "pendingResultForLabForQC")
                     {
                     
                    		tempTable += '<a href="javascript:RequestForChargeLabQC(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                     }else if(formName == "pendingResultForLabForEmpanelled"){
                    	 
                    	 tempTable += '<a href="javascript:RequestForChargeLabForEmpanelled(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                     }
                    else if(formName=='internalReferal' || formName=='searchExpiryDetails' || formName=='patientVisit' 
                    	|| formName=='updateRegistrationByName' || formName=='patientTransfer' 
                    	|| formName=='patientDischarge' && formName != 'finalDischarge'  || formName == "patientAdvance" 
                    	|| formName == "finalSettlement" 
                    	||formName=="pendingSampleEmpanelled"|| formName == "pendingSampleValidation" 
                    	|| formName == "pendingSampleValidationForEmpanelled" 
                    	|| formName=="pendingSampleForHisto" || formName== "requestResource" 
                    	|| formName=="patientDeliveryDetails"  || formName == "searchBloodTransfusion"
                        || formName == "searchBloodDonor"|| formName == "donorPendingBloodSampleScreening" || formName == "searchTest" 
                        || formName == "searchReactionEntry"|| formName == 'pendingBloodSampleValidation' 
                        || formName == 'pendingBloodSampleScreeningTest' || formName == "pendingBloodIssue" 
                        || formName == "searchReaction"||formName == 'searchPndTransReaction'
                        || formName=='pendingBloodDiscard' || formName == 'patientIssue' || formName == 'itemLocalMed' 
                        || formName=='itemLocalNonMed' || formName=='voucherApproval' || formName=='wasteDisposal' 
                        || formName=='opd_OP_Clinic_Waiting_PatientListLab' )
                    {
                    	
                     	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
                    else if( formName == "bloodRequestEntry" )
                	{
                    	tempTable += '<a href="javascript:RequestForBloodEntry(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+data_arr[rows][4]+'\')">';
                    }
                    else if( formName == "pendingSampleCollection" )
                	{

                    	tempTable += '<a href="javascript:showSampleCollection(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+data_arr[rows][2]+'\',\''+data_arr[rows][19]+'\',\''+data_arr[rows][20]+'\',\''+data_arr[rows][21]+'\')">';
                    }
                
                    else if(formName == 'medicalExamForm')
                    {
                    	
                    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }else if(formName == 'patientAdmission')
                    {
                    	tempTable += '<a href="javascript:RequestForAdmission(document.getElementById(\''+data_arr[rows][0]+'\'),\''+data_arr[rows][9]+'\',\''+formName+'\')">';
                    }
                    else if(formName == 'patientAdmissionVisit')
                    {
                    	tempTable += '<a href="javascript:RequestForAdmissionView(document.getElementById(\''+data_arr[rows][0]+'\'),\''+data_arr[rows][6]+'\',\''+formName+'\')">';
                    }
                   
                    else if(formName == 'ipPatientEnquiry')
                    {
                    	tempTable += '<a href="javascript:RequestForIPPatientEnquiry(document.getElementById(\''+data_arr[rows][0]+'\'),\''+data_arr[rows][2]+'\',\''+formName+'\')">';
                    }
                    else if(formName == "pendingResult")
                    {
                   		tempTable += '<a href="javascript:RequestForCharge(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
                    else if(formName == "pendingResultForOPScreen")  // added by amit das on 31-08-2017
                    {
                   		tempTable += '<a href="javascript:RequestForChargeFromOPScreen(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+data_arr[rows][12]+'\')">';
                    }
                    else if(formName == "pendingResultValidation")
                    {
                    	tempTable += '<a href="javascript:RequestForResultValidation(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
                    else if(formName == "reportCollection" || formName == 'otPacClearedList')
                    {
                    	tempTable += '<a href="javascript:RequestForReportCollection(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
                      else if(formName == "pendingResultValidationLab")
                    {
                    	tempTable += '<a href="javascript:RequestForResultValidationLab(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
                      else if(formName == "pendingResultValidationLabForEmpanelled"){
                    	  tempTable += '<a href="javascript:RequestForResultValidationLabForEmpanelled(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                      }
                      else if(formName == "pendingResultEntryLabForPostQC")
                      {
                      	tempTable += '<a href="javascript:RequestForResultEntryLabPostForQC(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                      } 
                    else if(formName=='orderNoListForOrderStatus'){
                    	if(columns != 1){
		                   /*
							 * tempTable += '<a
							 * href="javascript:RequestForViewTestCodeDetails(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
							 */
                    		tempTable += '<a href="javascript:RequestForViewTestCodeDetails(document.getElementById(\''+data_arr[rows][0]+'\'),\''+data_arr[rows][13]+'\',\''+formName+'\')">';
                    	}
                    }else if(formName == 'hospital')
                    {
                       	tempTable += '<a href="javascript:displayHospitals('+data_arr[rows][0]+','+rows+')">';
                    }
                    else if(formName == 'tabletAssetAdd')
                    {
                       	tempTable += '<a href="javascript:displayTablet('+data_arr[rows][0]+','+rows+')">';
                    }
                    else if(formName == 'opdPatientBillStatus')
                    {
                    	tempTable += '<a href="javascript:RequestForOpBillService(\''+data_arr[rows][6]+'\',\''+formName+'\',\''+data_arr[rows][7]+'\')">';
                    }
                    else if(formName == 'department')
                    {
                       	tempTable += '<a href="javascript:displayPayward(\''+data_arr[rows][3]+'\',\''+data_arr[rows][11]+'\');editRecord(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\');">';
                    }
                    // added by amit das on 08-06-2016
                    else if(formName == 'patientListIp')
                    {
                       	tempTable += '<a href="javascript:listScheme('+data_arr[rows][0]+',\''+data_arr[rows][3]+'\',\''+data_arr[rows][4]+'\',\''+data_arr[rows][1]+'\',\''+data_arr[rows][2]+'\')">';
                    }
                    
                    else if(formName == 'patientListOp')
                    {
                       	tempTable += '<a href="javascript:listScheme(\''+data_arr[rows][0]+'\',\''+data_arr[rows][3]+'\',\''+data_arr[rows][4]+'\',\''+data_arr[rows][1]+'\',\''+data_arr[rows][2]+'\')">';
                    }
                    else if(formName == 'ipDepartmentMappings')   
                    {
                       	tempTable += '<a href="javascript:RequestForIpMappingEdit(\''+data_arr[rows][0]+'\',\''+data_arr[rows][1]+'\',\''+data_arr[rows][2]+'\',\''+data_arr[rows][3]+'\')">';
                    }
                    else if(formName == 'wardName')
                    {
                    	
                       	tempTable += '<a href="javascript:displayLSG(\''+data_arr[rows][10]+'\',\''+data_arr[rows][0]+'\')">';
                    }
                    else if(formName == 'depotUnit')
                    {
                    	
                    	tempTable += '<a href="javascript:displayLSGOne(\''+data_arr[rows][8]+'\',\''+data_arr[rows][9]+'\',\''+data_arr[rows][0]+'\')">';
                   	              }
                    
                    else if(showOnSamePage && formName != "chargeCode" && formName != "finalDischarge"  && formName != 'discountMaster' && formName != 'packageList'  && formName != 'hospital' && formName != 'wardName')
                    {
                    
                    	tempTable += '<a href="javascript:editRecord(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    }
               		else if(addAction && formName != "chargeCode" && formName != 'finalDischarge'  && formName != 'discountMaster' && formName != 'packageList' )
               		{
                    	tempTable += '<a href="'+ goToUrl +'&id='+data_arr[rows][0]+'">';
                   	}
                   
                    else if( formName == 'admissionAcceptance')
                    {
                    	// var textDiv='textDiv';
                    	// tempTable += '<a
						// href="javascript:editRecord(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\');submitProtoAjaxNew(\''+formName+'\',\'''\'/hms/hms/ipd?method=displayUnitWiseBed&unitCode\''+data_arr[rows][26]+'\',\''+textDiv+'\')">';
                    	
                       	tempTable += '<a href="javascript:displayUnitWiseBed('+data_arr[rows][30]+',\''+data_arr[rows][26]+'\')">';
                    }
                    else if(formName != "chargeCode" && formName != 'finalDischarge'  && formName != 'discountMaster' && formName != 'packageList' )
                    {
                    	tempTable += '<a href="'+ goToUrl +'&'+data_arr[rows][0]+'.action">';
                    }
                    else if(formName == 'discountMaster')
                    {
                       	tempTable += '<a href="javascript:displayDiscountRecordForEdit('+data_arr[rows][0]+')">';
                    }
                    else if(formName == 'packageList')
                    {
                       	tempTable += '<a href="javascript:displayPackageDetails('+data_arr[rows][0]+','+rows+')">';
                    }
                    else if(formName == 'chargeCode')
                    {
                       	tempTable += '<a href="javascript:showChargeCodeDetails('+data_arr[rows][0]+','+rows+',\''+formName+'\')">';
                    }else if(formName == 'serviceRequest')
                    {
                       	tempTable += '<a href="javascript:Request('+data_arr[rows][0]+','+rows+',\''+formName+'\')">';
                    }
                    else if(formName == 'pendingIndent')
                    {
                       	tempTable += '<a href="javascript:Request('+data_arr[rows][1]+','+rows+',\''+formName+'\')">';
                    }
                   
                    
                    

                    tempTable +=data_arr[rows][columns]
                    tempTable +='</a></td>'
                }
               tempTable += '</tr>'
        }
        tempTable += '</tbody></table>'
        document.getElementById('searchtable').innerHTML = tempTable;
    }

    if(document.paging.pageno.value == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

    }
     if(formName == 'finalDischarge'){
    	if(document.getElementById('dischargeButton'))
			document.getElementById('dischargeButton').style.display = 'inline';
			document.getElementById('dsPrint').style.display = 'inline';

		}
		if(document.getElementById('addInfoId')){
			document.getElementById('addInfoId').style.display = 'inline';
		}
}
function makeTableForOutSideLab(starter, end){

	if(document.getElementById('pageNoEdit'))
		document.getElementById('pageNoEdit').value = Math.ceil(parseInt(end)/5);

    totalPages = Math.ceil(data_arr.length/rowsPerPage);
    document.getElementById("total").innerHTML=totalPages
    document.getElementById("totalRecs").innerHTML=data_arr.length
    if(totalPages==0){
	    document.getElementById('searchtableOutSideLab').style.width = "50%"
    	document.getElementById('searchtableOutSideLab').style.textAlign = "left"
        document.getElementById('searchtableOutSideLab').innerHTML = '<h4>No Records Found</h4>'
		document.getElementById('resultnavigationOutSideLab').style.display="none";
        return;
    }
    else if(totalPages == 1){
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"
    }
    document.getElementById('resultnavigationOutSideLab').style.display="inline";
    // document.getElementById('pageno').length=totalPages
    for(pg=1;pg<=totalPages;pg++){
        // document.getElementById('pageno')[pg-1].value = pg
        // document.getElementById('pageno')[pg-1].text = pg
    }
    start = starter;
    if(data_header){
                tempTable = '<table border="0" cellspacing="0"  cellpadding="0" ><thead><tr>'
        for(cols=0;cols<data_header.length;cols++){
            if(data_header[cols][1]=="data"){
                tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            }
            else if(data_header[cols][1]=="hide"){
                    tempTable += '<th class="hide">&nbsp;</th>'
            }else if(data_header[cols][1]=="radio"){
            		 tempTable += '<th  width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            	}
        }
        tempTable += '<tr></thead><tbody id="searchresulttableOutSideLab">'
        for(rows=start;rows<end; rows++){
                tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
				if(rows%rowsPerPage == 0 && rows != 0){
					currentColor = "odd"
				}

                tempTable += currentColor;
				currentColor = (currentColor == "odd")?"even" : "odd";
                tempTable += '">'
                for(columns=1;columns<=data_header.length;columns++){
                    tempTable += '<td '

                    if(data_header[columns-1][1] == "hide")
                        tempTable += 'class="hide"';
						
                 tempTable +='>';
                
                 tempTable += '<a href="javascript:RequestForOutsideLab('+data_arr[rows][1]+','+rows+',\''+formName+'\')">';
				 tempTable +=data_arr[rows][columns]
                 tempTable +='</a></td>'
                }
               tempTable += '</tr>'
        }
        tempTable += '</tbody></table>'
        document.getElementById('searchtableOutSideLab').innerHTML = tempTable;
    }

    if(document.paging.pageno.value == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

    }
  
}

function RequestForOutsideLab(obj,formName)
{
	    obj1 = eval('document.'+formName)			
		var dgOrderDtId = obj.id;
		url = "/hms/hrms/?method= &dgOrderDtId="+dgOrderDtId;
	   	obj1 .action = url;
		obj1 .submit();
		
}



function displayLSG(dId,wardId){
	
	populateLsgByDistrictId(dId);
	setTimeout("editRecord(document.getElementById("+wardId+"),'wardName')", 1000);
}


function displayLSGOne(dId,lsgId,localityId){
	
	populateLsgByDistrictId(dId);
	setTimeout("populateWardByLsgId("+lsgId+")",1000);
	setTimeout("editRecord(document.getElementById("+localityId+"),'depotUnit')", 2000);
	
	
}







function showSampleCollection(obj,formName,orderNo,visitId,chargeSlipNo,subGroupId)
{
	
	obj1 = eval('document.'+formName)
	 
		hin = obj.id;
		
	
    var url;

    	if(chargeSlipNo != 'null'){
    		
    	}else{
    		alert("Billing Not Done");
    	}
    	url = "/hms/hms/lab?method=searchPatient&orderId="+hin+'&visitId='+visitId+'&orderNo='+orderNo+'&subGroupId='+subGroupId;
		obj1 .action = url;
		obj1 .submit();
	
}
function RequestForChargeLab(obj,formName)
{ 
	 
	var hinId = document.getElementById('hinId').value;
	var RequisitionFrom = document.getElementById('RequisitionFrom').value;
	
	sampleCollectionDetail = obj.id;
	
    obj1 = eval('document.'+formName)
    
   
    var url;
    
    if(hinId != 0)
    	{
    	    if(formName == 'pendingResultForLab')
    	   		url = "/hms/hms/investigation?method=searchPatientForLab&hinId_OPD="+hinId+"&RequisitionFrom="+RequisitionFrom+"&sampleCollectionDetailId="+sampleCollectionDetail+"&modalityId="+document.getElementById("subChargeCodeId").value;
    		
    	}
    else
    	{
    	 	if(formName == 'pendingResultForLab')
    	   		url = "/hms/hms/investigation?method=searchPatientForLab&sampleCollectionDetailId="+sampleCollectionDetail+"&modalityId="+document.getElementById("subChargeCodeId").value;
    	}
   

   	obj1.action = url;
    obj1.submit();
}
function RequestForChargeLabQC(obj,formName)
{
	var hinId = document.getElementById('hinId').value;
	var RequisitionFrom = document.getElementById('RequisitionFrom').value;
	
	sampleCollectionDetail = obj.id;
	
    obj1 = eval('document.'+formName)
    
   
    var url;
    
    if(hinId != 0)
    	{
    	    if(formName == 'pendingResultForLabForQC')
    	   		url = "/hms/hms/investigation?method=searchPatientForLabForQC&hinId_OPD="+hinId+"&RequisitionFrom="+RequisitionFrom+"&sampleCollectionDetailId="+sampleCollectionDetail;
    		
    	}
    else
    	{
    	 	if(formName == 'pendingResultForLabForQC')
    	   		url = "/hms/hms/investigation?method=searchPatientForLabForQC&sampleCollectionDetailId="+sampleCollectionDetail;
    	}
   

   	obj1.action = url;
    obj1.submit();
}
function RequestForChargeLabForEmpanelled(obj,formName)
{
	var hinId = document.getElementById('hinId').value;
	var RequisitionFrom = document.getElementById('RequisitionFrom').value;
	
	sampleCollectionDetail = obj.id;
	
    obj1 = eval('document.'+formName)
    
   
    var url;
    
    if(hinId != 0)
    	{
    	    if(formName == 'pendingResultForLabForEmpanelled')
    	   		url = "/hms/hms/investigation?method=searchPatientForLabForEmpanelled&hinId_OPD="+hinId+"&RequisitionFrom="+RequisitionFrom+"&sampleCollectionDetailId="+sampleCollectionDetail;
    		
    	}
    else
    	{
    	 	if(formName == 'pendingResultForLabForEmpanelled')
    	   		url = "/hms/hms/investigation?method=searchPatientForLabForEmpanelled&sampleCollectionDetailId="+sampleCollectionDetail;
    	}
   

   	obj1.action = url;
    obj1.submit();
}

function RequestForOpBillService(orderId,formName,billType)
{
    obj1 = eval('document.'+formName)
    var url;
   		url = "/hms/hms/opBilling?method=getPatientDetailsForOpBilling&registered=yes&orderId="+orderId+"&billType="+billType;
   	obj1.action = url;
    obj1.submit();
}

function RequestForIPPatientEnquiry(obj,obj1,formName)
{
	patientHinId = obj.id;
	patientIpd = obj1;
    obj1 = eval('document.'+formName)
    var url;
    if(formName == 'ipPatientEnquiry')
    {
     	url = "/hms/hms/enquiry?method=searchPatientDetail&patientHinId="+patientHinId+"&patientIpd="+patientIpd;
    }
	obj1.action = url;
    obj1.submit();
}

function RequestForAdmission(obj,obj1,formName)
{
	hin = obj.id;
	hinIdMother = obj1;
    obj1 = eval('document.'+formName)
    var url;
    if(formName == 'patientAdmission')
    {
    	 url = "/hms/hms/adt?method=searchPatientDetailsForAdmission&hinId="+hin+"&hinIdMother="+hinIdMother;
    }

	obj1.action = url;
    obj1.submit();
}
function RequestForAdmissionView(obj,obj1,formName)
{
	 hin = obj.id;
	hinIdMother = obj1;
	if(hinIdMother==null)
		hinIdMother="";
    obj1 = eval('document.'+formName)
    var url;
  
    if(formName == 'patientAdmissionVisit')
    {
    
    	 url = "/hms/hms/adt?method=searchIPPatientViewAndUpdate&InpId="+hin+"&hinIdMother="+hinIdMother;
    }
	obj1.action = url;
    obj1.submit();
}



function RequestForCharge(obj,formName)
{
	var hinId = document.getElementById('hinId').value;
	var RequisitionFrom = document.getElementById('RequisitionFrom').value;
	
	
	sampleCollectionDetail = obj.id;
    obj1 = eval('document.'+formName)
    var url;
    
    if(hinId != 0)
	{
	    if(formName == 'pendingResult')
	   		url = "/hms/hms/investigation?method=searchPatientForTemplteOPD&hinId_OPD="+hinId+"&RequisitionFrom="+RequisitionFrom+"&sampleCollectionDetailId="+sampleCollectionDetail;
		
	}
else
	{
	 	if(formName == 'pendingResult')
	 		url = "/hms/hms/investigation?method=searchPatient&sampleCollectionDetailId="+sampleCollectionDetail;
	}   
    
   

   	obj1.action = url;
    obj1.submit();
}
function RequestForResultValidationLab(obj,formName)
{

	result = obj.id;

    obj1 = eval('document.'+formName)
    var url;
    if(formName == 'pendingResultValidationLab')
   		url = "/hms/hms/investigation?method=searchPatientForResultValidationLab&resultId="+result;

   	obj1.action = url;
    obj1.submit();
}
function RequestForResultValidationLabForEmpanelled(obj,formName)
{

	result = obj.id;

    obj1 = eval('document.'+formName)
    var url;
    if(formName == 'pendingResultValidationLabForEmpanelled')
   		url = "/hms/hms/investigation?method=searchPatientForResultValidationLabForEmpanelled&resultId="+result;

   	obj1.action = url;
    obj1.submit();
}
function RequestForResultEntryLabPostForQC(obj,formName)
{

	result = obj.id;

    obj1 = eval('document.'+formName)
    var url;
    if(formName == 'pendingResultEntryLabForPostQC')
   		url = "/hms/hms/investigation?method=searchPatientForResultEntryLabForPostQC&resultId="+result;

   	obj1.action = url;
    obj1.submit();
}

function RequestForResultValidation(obj,formName)
{

	result = obj.id;

    obj1 = eval('document.'+formName)
    var url;
    if(formName == 'pendingResultValidation')
   		url = "/hms/hms/investigation?method=searchPatientForResultValidation&resultId="+result;

   	obj1.action = url;
    obj1.submit();
}


function RequestForReportCollection(obj,formName)
{
	hin = obj.id;
	result = obj.id;
    obj1 = eval('document.'+formName)
    var url;
    if(formName == 'reportCollection'){
   		url = "/hms/hms/investigation?method=searchPatientForReportCollection&resultId="+result;
    }else if(formName == 'otPacClearedList'){
    	url = "/hms/hms/ot?method=showOtStatus&surgeryId="+hin;
    }
   	obj1.action = url;
    obj1.submit();
}
 	function Request(obj,formName)
	{
		obj1 = eval('document.'+formName)
		// hin = obj.id;
			
		 if(formName == 'medicalExamForm'){
			hin = obj.id;
			url = "/hms/hrms/training?method=forUpdateMedicalExamEntry&empCode="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}
		if( formName != 'patientEnquiry')
		{
			hin = obj.id;
   		}
		/*if( formName == 'bloodRequestEntry')
		{
			hin = obj.id;
			
			
   		}*/ 
   		
	    var url;
	    
	    if(formName=='ipdDialysisList'){
   			url = "/hms/hms/ipd?method=showDialysisListDetails&hinId="+hin;
   			obj1 .action = url;
			obj1 .submit();
	    	
	    }
    	if(formName == 'patientVisit')
    	{
   			url = "/hms/hms/registration?method=showVisitDetails&hinId="+hin;
   			obj1 .action = url;
			obj1 .submit();
    	}
    	/*
		 * else if(formName == 'patientAdmission') { alert("hin=="+hin);
		 * alert("hinIdMother=="+hinIdMother); url =
		 * "/hms/hms/adt?method=searchPatientDetailsForAdmission&hinId="+hin+"&hinIdMother="+hinIdMother;
		 * obj1 .action = url; obj1 .submit(); }
		 */
    	else if(formName == 'patientTransfer')
    	{
        	url = "/hms/hms/adt?method=searchPatientDetailsForTransfer&inpatientId="+hin;
        	obj1 .action = url;
			obj1 .submit();
    	}
    	else if(formName=="patientDischarge")
    	{
    		url = "/hms/hms/adt?method=searchPatientDetailsForDischargeWard&inpatientId="+hin;
    		obj1 .action = url;
			obj1 .submit();
    	}
    	else if(formName == 'updateRegistrationByName')
    	{
        	url = "/hms/hms/registration?method=searchPatient&hin="+hin+"&selectedRadio=2";
        	obj1 .action = url;
			obj1 .submit();
    	}
    	else if(formName == 'patientEnquiry')
    	{
        	url = "/hms/hms/enquiry?method=showPatientDetails&hinNo="+obj;
        	obj = eval('document.'+formName)
        	obj.action = url;
			obj.submit();
    	}
    	else if(formName == 'voucherApproval')
    	{
        	url = "/hms/hms/account?method=getDetailsForVoucherApproval&voucherId="+obj.id;
        	obj = eval('document.'+formName)
        	obj.action = url;
			obj.submit();
    	}else if(formName=='wasteDisposal'){
        	url = "/hms/hms/ipd?method=getDetailsForwasteDisposal&headerId="+obj.id;
        	obj = eval('document.'+formName)
        	obj.action = url;
			obj.submit();
    	}else if(formName=='opd_OP_Clinic_Waiting_PatientListLab'){
    		url = "/hms/hms/lab?method=getPatientDetailsNew&visitId="+obj.id;
        	obj = eval('document.'+formName)
        	obj.action = url;
			obj.submit();
    	}
    	
    	else if(formName == 'patientAdvance')
    	{
    		url = "/hms/hms/billing?method=searchPatient&flag=deposit&hinId="+hin;
    		obj1 .action = url;
			obj1 .submit();
    	}
    	else if(formName == 'searchExpiryDetails')
    	{
	    	url = "/hms/hms/adt?method=showExpiryDetails&adNo="+hin;
	    	obj1 .action = url;
			obj1 .submit();
    	}
    	else if(formName=='internalReferal')
    		{
    		url = "/hms/hms/ipd?method=showDetailsReferalRecord&reamrksId="+obj.id;
	    	obj1 .action = url;
			obj1 .submit();
    		
    		
    		}
    	else if(formName == 'finalSettlement')
    	{
	    	url = "/hms/hms/billing?method=searchPatient&flag=finalSettlement&hinId="+hin;
	    	obj1 .action = url;
			obj1 .submit();
   	 	}
   	 	/*
		 * else if(formName == 'pendingSampleCollection') { url =
		 * "/hms/hms/lab?method=searchPatient&orderId="+hin; obj1 .action = url;
		 * obj1 .submit(); }
		 */
   	 	else if(formName == 'pendingSampleEmpanelled')
	 	{
   	 		url = "/hms/hms/lab?method=searchPatientForEmpanelled&orderId="+hin;
   	 		obj1 .action = url;
			obj1 .submit();
	 	}
    	else if(formName == 'pendingSampleValidation')
    	{
    		url = "/hms/hms/lab?method=searchPatientForValidation&orderId="+hin+"&modalityId="+document.getElementById("subChargeCodeId").value;
    		obj1 .action = url;
			obj1 .submit();
    	}
    	else if(formName == 'pendingSampleValidationForEmpanelled')
    	{
    		url = "/hms/hms/lab?method=searchPatientForValidationForEmpanelled&orderId="+hin;
    		obj1 .action = url;
			obj1 .submit();
    	}
    	else if(formName == 'pendingSampleForHisto')
    	{
    		url = "/hms/hms/lab?method=searchPatientForHistoPendingList&orderId="+hin;
    		obj1 .action = url;
			obj1 .submit();
    	}
   		else if(formName == 'patientSearch')
   		{
    		url = "/hms/hms/opd?method=showSurgeryRequisitionJspFromPatientList&hinNo="+obj;
    		obj1 .action = url;
			obj1 .submit();
    	}
     	else if(formName == 'preAnaesthesiaPatientSearch')
     	{
    		url = "/hms/hms/ot?method=showPreAneaesthesiaProcNotesEntryJsp&bookingId="+obj;
    		obj1 .action = url;
			obj1 .submit();
    	} else if(formName == 'consent1'){// alert("hii")
    		var objArray = obj.split(":");
    		var hinNo = objArray[0];
    		url = "/hms/hms/ot?method=showConsentEntryJsp&hinNo="+hinNo; // edited
																			// by
																			// amit
																			// das
																			// on
																			// 26-09-2016
    		url = url + "&inpatientId="+objArray[1]; // added by amit das on
														// 26-09-2016
    		obj1 .action = url;
			obj1 .submit();
    	}else if(formName == 'consent11'){// alert("hii")
    		url = "/hms/hms/ot?method=showPreOperativeCheckListEntryJsp&bookingId="+obj;
    		obj1 .action = url;
			obj1 .submit();
    	}else if(formName == 'surgeryCheckList'){// added by amit das on
													// 22-09-2016
    		url = "/hms/hms/ot?method=showSurgerySafetyCheckListJsp&bookingId="+obj;
    		obj1.action = url;
			obj1.submit();
    	}
    	else if(formName == 'intraOperativeTimeOut'){// alert("hii")
    		url = "/hms/hms/ot?method=showIntraOperativeCheckListEntryJsp&bookingId="+obj;
    		obj1 .action = url;
			obj1 .submit();
    	}
    	else if(formName == 'otSignOut'){// alert("hii")
    		url = "/hms/hms/ot?method=showOtSignoutListEntryJsp&bookingId="+obj;
    		obj1 .action = url;
			obj1 .submit();
    	}
    	
    	
     	else if(formName == 'preAnaesthesiaPatientSearch1')
     	{
    		url = "/hms/hms/ot?method=showPatientIssueByOt&hinNo="+obj;
    		obj1 .action = url;
			obj1 .submit();
    	}
    	
    	else if(formName == 'otProcedureNotesEntry')
    	{
    		url = "/hms/hms/ot?method=showOtProcedureNotesEntryJsp&bookingId="+obj;
    		obj1 .action = url;
			obj1 .submit();
    	}
    	else if(formName == 'postAnaesthesiaPatientSearch')
    	{
	    	url = "/hms/hms/ot?method=showPostAnaesthesiaJspFromPatientList&bookingId="+obj;
	    	obj1 .action = url;
			obj1 .submit();
    	}
   	 	else if(formName == 'specimenDispatchEntryPatientSearch')
   	 	{
	    	url = "/hms/hms/ot?method=showSpecimenDispatchEntryJspFromPatientList&bookingId="+obj;
	    	obj1 .action = url;
			obj1 .submit();
    	}
    	else if(formName == 'patientSearchForDisposal')
    	{
	    	url = "/hms/hms/ot?method=showHumanBodyPartsDisposalJsp&bookingId="+obj;
	    	obj1 .action = url;
			obj1 .submit();
    	}
	    else if(formName == 'patientSearchForEmergencyOTBooking'){
	    	url = "/hms/hms/ot?method=showEmergencyOTBookingJsp&hinNo="+hin;
	    	obj1 .action = url;
			obj1 .submit();
	    }
	    else if(formName == 'requestResource'){
	    	url = "recruitment?method=showResourceDetailForUpdate&requisitionId="+hin;
	    	obj1 .action = url;
			obj1 .submit();
	    }
	    else if(formName == 'patientDeliveryDetails'){
	    	url = "mis?method=getInpatientDetails&inpatientId="+hin;
	    	obj1 .action = url;
			obj1 .submit();
	    }// --for Blood bank----
	    else if(formName == 'searchBloodTransfusion'){
		   	url = "/hms/hms/bloodBank?method=showConsentBloodTransfusion&inpatientId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
			}else if(formName == 'searchBloodDonor'){
		   	url = "/hms/hms/bloodBank?method=showUpdateDonationEntry&bloodDonationId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}else if(formName == 'donorPendingBloodSampleScreening'){
		   	url = "/hms/hms/bloodBank?method=showDonorSampleScreeningJsp&donationId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}
		/*else if(formName == 'bloodRequestEntry'){
    	url = "/hms/hms/bloodBank?method=showBloodRequestEntryJsp&hinId="+hin;
    	obj1 .action = url;
		obj1 .submit();
	   }*/
		else if(formName == 'pendingBloodIssue'){
			url = "/hms/hms/bloodBank?method=showBloodIssueJsp&screeningId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}else if(formName == 'pendingBloodSampleScreeningTest'){
			url = "/hms/hms/bloodBank?method=showBloodSampleScreeningTest&sampleId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}else if(formName == 'pendingBloodSampleValidation'){
		   	url = "/hms/hms/bloodBank?method=showBloodSampleValidationJsp&sampleId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}else if(formName == 'searchReactionEntry'){
		   	url = "/hms/hms/bloodBank?method=showReactionFormEntryJsp&bldIssueDeatialId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}else if(formName == 'searchPndTransReaction'){
			
		   	url = "/hms/hms/bloodBank?method=showTransfussionReaction&bloodIssueDetailId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}else if(formName == 'searchReaction'){
	   	url = "/hms/hms/bloodBank?method=showUpdateReactionEntry&bloodReactionId="+hin;
	   	obj1 .action = url;
		obj1 .submit();
		}else if(formName == 'searchTest'){
		   	url = "/hms/hms/bloodBank?method=showUpdateTestEntry&bloodTestId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}else if(formName == 'pendingBloodDiscard'){
		url = "/hms/hms/bloodBank?method=showBloodDiscardJsp&bloodStockDetailId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}else if(formName == 'patientIssue'){
			url = "/hms/hms/stores?method=showPatientForDrugIssue&hinId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}else if(formName == 'inspectionReport'){
			url = "/hms/hms/maintenance?method=showInspectionReport&equId="+hin;
		   	obj1 .action = url;
			obj1 .submit();
		}
		else if(formName == 'pendingIndent'){
			url = "/hms/hms/stores?method=searchPendingIndentApproval&equId="+obj;
		   	obj1 .action = url;
			obj1 .submit();
		}
    	
		else if(formName == 'UnservicedDispensing'){
			url = "/hms/hms/stores?method=showPendingDispensingJsp&hinId="+obj;
		   	obj1 .action = url;
			obj1 .submit();
		}
    	
		else if(formName == 'CurrentDispensing'){
			url = "/hms/hms/billing?method=showDetailPendingDispensing&presId="+obj;
		   	obj1 .action = url;
			obj1 .submit();
		}
		else if(formName == 'empanelled'){
			var array = new Array();
			array = obj.split("@@@");
			
			url = "/hms/hms/stores?method=empanelledDetails&hinId="+array[0]+"&empanelledId="+array[1];
		   	obj1 .action = url;
			obj1 .submit();
		}
		else if(formName == 'itemLocalMed'){
			document.getElementById('editbutton').style.display = 'inline'
			submitProtoAjax(formName,"/hms/hms/pharmacy?method=showHospitalWiseItemDetails&itemId="+obj.id+"&flag=med");
		}
		else if(formName == 'itemLocalNonMed'){
			document.getElementById('editbutton').style.display = 'inline'
				submitProtoAjax(formName,"/hms/hms/pharmacy?method=showHospitalWiseItemDetails&itemId="+obj.id+"&flag=nonMed");
		}
		else if(formName == 'consentLetter'){ // added by Arbind on 27-07-2017
	    		var objArray = obj.split(":");
	    		var hinNo = objArray[0];
	    		url = "/hms/hms/ot?method=uploadOtConsentLetter&hinNo="+hinNo;
	    		url = url + "&inpatientId="+objArray[1] + "&visitId="+objArray[2];
	    		obj1 .action = url;
				obj1 .submit();
	    }
		else if(formName == 'bloodConsent'){ // added by Arbind on 31-10-2017
    		var objArray = obj.split(":");
    		var hinNo = objArray[0];
    		url = "/hms/hms/bloodBank?method=showConsentEntryJsp&hinNo="+hinNo;
    		url = url + "&inpatientId="+objArray[1];
    		obj1 .action = url;
			obj1 .submit();
		}
		else if(formName == 'bloodConsentLetter'){ // added by Arbind on 31-10-2017
    		var objArray = obj.split(":");
    		var hinNo = objArray[0];
    		url = "/hms/hms/bloodBank?method=uploadBloodConsentLetter&hinNo="+hinNo;
    		url = url + "&inpatientId="+objArray[1] + "&visitId="+objArray[2];
    		obj1 .action = url;
			obj1 .submit();
		}
		
// new Ajax.Updater('statusMessage', url, {asynchronous:true,
// evalScripts:true});
}
 	function RequestForDeparmentGroup(obj,valueType,formName){
 		 if(formName == 'departmentGroup'){
 		    	 url = "/hms/hms/generalMaster?method=showDeparmentGroupValue&deptGroupId="+obj.id+"&valueType="+valueType;
 			    submitProtoAjax('departmentGroup',url);
 		   	}
 		
 		
 	}

function dateCompare(){

var nowDate=new Date();

obj1 = eval('document.'+formName+'.validFromDate')
obj2 = eval('document.'+formName+'.validToDate')

if(obj1.value != "" && obj2.value != "")
	{

	validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));

		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
						errorMsg = "From Date should be smaller than To Date\n";
				}
			}

		else
			{
			errorMsg ="From Date should not be greater than Current date\n";
			}

	}
	return true;
}
function dateCompare1(formName){

var nowDate=new Date();

obj1 = eval('document.'+formName+'.validFromDate')
obj2 = eval('document.'+formName+'.validToDate')

if(obj1.value != "" && obj2.value != "")
	{

	validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
	validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));

		if(validFromDate<=nowDate)
			{
				if(validFromDate > validToDate)
				{
						errorMsg = "From Date should be smaller than To Date\n";
						alert(errorMsg);
						return false;
				}
			}

		else
			{
			errorMsg ="From Date should not be greater than Current date\n";
			alert(errorMsg);
			return false;

			}

	}
	return true;
}


function navigate(obj){
	document.paging.firstpage.style.border = "none"
	document.paging.nextpage.style.border = "none"
	document.paging.lastpage.style.border = "none"
	document.paging.prevpage.style.border = "none"
	// currentPage = document.paging.pageno.value;
	initTabButtons()

	if(obj.value == 'f' && data_arr.length>rowsPerPage){
		makeTable(0,rowsPerPage);
		// document.getElementById('pageno').value=1

		document.getElementById("current").innerHTML=1

		document.getElementById("currStart").innerHTML=1
		document.getElementById("currEnd").innerHTML=5
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"
	}
	else if(obj.value == 'p'){
		if(start-rowsPerPage>=0){
			document.paging.lastpage.disabled= false;
			document.paging.nextpage.disabled= false;
			document.paging.lastpage.className="next"
			document.paging.nextpage.className="singleNext"
			if(start==rowsPerPage){
				document.paging.firstpage.disabled= true;
				document.paging.prevpage.disabled= true;
				document.paging.firstpage.className="previousDisable"
				document.paging.prevpage.className="singlePrevDisable"
			}
			else{
				document.paging.firstpage.disabled= false;
				document.paging.prevpage.disabled= false;
				document.paging.firstpage.className="previous"
				document.paging.prevpage.className="singlePrev"
			}
			makeTable(start-rowsPerPage,start);
			// document.getElementById('pageno').value--;
			document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML-2)*5+1
				document.getElementById("currEnd").innerHTML=(document.getElementById("current").innerHTML-1)*5
				document.getElementById("current").innerHTML--;

		}

	}
	else if(obj.value == 'n'){
		if(start+rowsPerPage*2<data_arr.length){
			makeTable(start+rowsPerPage,start+(rowsPerPage*2));

			// document.getElementById('pageno').value++;
			var tt=document.getElementById("current").innerHTML;

			document.getElementById("currStart").innerHTML=(tt)*5+1
				document.getElementById("currEnd").innerHTML=((tt*1)+1)*5
			document.getElementById("current").innerHTML++;

			document.paging.firstpage.disabled= false;
			document.paging.prevpage.disabled= false;
			document.paging.firstpage.className="previous"
			document.paging.prevpage.className="singlePrev"

		}
		else if(start+rowsPerPage<data_arr.length){
			makeTable(start+rowsPerPage,data_arr.length);
			// document.getElementById('pageno').value++;
			document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML)*5+1
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML++;
			document.paging.lastpage.disabled= true;
			document.paging.nextpage.disabled= true;
			document.paging.lastpage.className="nextDisable"
			document.paging.nextpage.className="singleNextDisable"

			document.paging.firstpage.disabled= false;
			document.paging.prevpage.disabled= false;
			document.paging.firstpage.className="previous"
			document.paging.prevpage.className="singlePrev"
		}
	}
	else if(obj.value == 'l'){

		if(data_arr.length % rowsPerPage == 0) {
			makeTable(data_arr.length - rowsPerPage, data_arr.length);
			// document.getElementById('pageno').value=totalPages;
			document.getElementById("currStart").innerHTML=data_arr.length-4
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML=totalPages
		} else {
			makeTable((data_arr.length - (data_arr.length % rowsPerPage)), data_arr.length);
			// document.getElementById('pageno').value=totalPages;
			document.getElementById("currStart").innerHTML=data_arr.length-4
				document.getElementById("currEnd").innerHTML=data_arr.length
			document.getElementById("current").innerHTML=totalPages
		}
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"

		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"
	}
	if(!obj.disabled){
		obj.style.border = "none"
	}
}

function goToPage(pageno){
	if(pageno == ""){
		alert("Please Enter Page No.")
		return false;
	}

	if( (pageno>totalPages) || (pageno<=0) || (pageno%1!=0) )
	{
		alert("Please Enter Correct Page No.")
		document.paging.pageno.value=""
		return false;
	}
	if(pageno == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"
	}
	else if(pageno == totalPages){
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"

		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"
	}
	else{
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"

		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"
	}
	if(pageno*rowsPerPage<data_arr.length)
		makeTable(pageno*rowsPerPage-rowsPerPage,pageno*rowsPerPage)
	else
		makeTable(pageno*rowsPerPage-rowsPerPage,data_arr.length)

		document.getElementById("currStart").innerHTML=(pageno-1)*5+1
		document.getElementById("currEnd").innerHTML=(pageno)*5

		document.getElementById("current").innerHTML=pageno


	document.paging.pageno.value=""

}

function multipleResults(obj){
	if(obj.checked == true){

		document.chargeCode.multiple.style.display = "inline";
		}
	else{

		document.chargeCode.multiple.style.display = "none";
		}
}
function checkMultiple(){



if (!window.window2) {
        // has not yet been defined
        window2 = window.open('/hms/jsp/sub_test.jsp','windowRef','width=600,height=400,scrollbars = yes');
    }
    else {
        // has been defined
        if (!window2.closed) {
            // still open
            window2.focus();
        }
        else {
            window2 = window.open('/hms/jsp/sub_test.jsp','windowRef','width=600,height=400,scrollbars = yes');
        }
    }


}

function doneSubTest(){
if(parent.document.subTest.length >0)
  {
		document.chargeCode.subTest.value=subTest1;
		}
	window.close()

}

function chkMultipleTest(id){
	count = 0;
	for(b=0;b<subtest_arr.length;b++){
		if(id == subtest_arr[b][3]){
			count++;
		}
	}
	if(count>0){
		document.chargeCode.multipleresults.checked = true;
		multipleResults(document.chargeCode.multipleresults)
		document.chargeCode.multiple.value= "Multiple Results ("+count+")";
	}
}
function submitForm1(chargeDetails,div,action){
	obj = eval('document.'+chargeDetails)
	if(validateFields(document.getElementById(div))){
		obj.action = action;
		obj.submit();
	}
}
var date1,date2;
function compareDates(){
	dateobj1 = new Date(date1)
	dateobj2 = new Date(date2)
	if(dateobj1>dateobj2){
		errorMsg+= 'Field From Date cannot be greater than field To Date';
		return false;
	}
	return true;
}
function compareCurrentDate(date1, date2, fieldName){
	dateobj1 = new Date(date1)
	dateobj2 = new Date(date2)
	alert(dateobj1)
	alert(dateobj2)
	if(dateobj1>dateobj2){
		errorMsg+= 'Field '+fieldName+' should not be greater than todays date';
		return false;
	}
	return true;
}

function replaceSubstring(inputString, fromString, toString) {
   var temp = inputString;
   if (fromString == "") {
      return inputString;
   }
   if (toString.indexOf(fromString) == -1) { // If the string being replaced
												// is not a part of the
												// replacement string (normal
												// situation)
      while (temp.indexOf(fromString) != -1) {
         var toTheLeft = temp.substring(0, temp.indexOf(fromString));
         var toTheRight = temp.substring(temp.indexOf(fromString)+fromString.length, temp.length);
         temp = toTheLeft + toString + toTheRight;
      }
   } else { // String being replaced is part of replacement string (like "+"
			// being replaced with "++") - prevent an infinite loop
      var midStrings = new Array("~", "`", "_", "^", "#");
      var midStringLen = 1;
      var midString = "";
      // Find a string that doesn't exist in the inputString to be used
      // as an "inbetween" string
      while (midString == "") {
         for (var i=0; i < midStrings.length; i++) {
            var tempMidString = "";
            for (var j=0; j < midStringLen; j++) { tempMidString += midStrings[i]; }
            if (fromString.indexOf(tempMidString) == -1) {
               midString = tempMidString;
               i = midStrings.length + 1;
            }
         }
      } // Keep on going until we build an "inbetween" string that doesn't exist
      // Now go through and do two replaces - f, replace the "fromString" with
		// the "inbetween" string
      while (temp.indexOf(fromString) != -1) {
         var toTheLeft = temp.substring(0, temp.indexOf(fromString));
         var toTheRight = temp.substring(temp.indexOf(fromString)+fromString.length, temp.length);
         temp = toTheLeft + midString + toTheRight;
      }
      // n, replace the "inbetween" string with the "toString"
      while (temp.indexOf(midString) != -1) {
         var toTheLeft = temp.substring(0, temp.indexOf(midString));
         var toTheRight = temp.substring(temp.indexOf(midString)+midString.length, temp.length);
         temp = toTheLeft + toString + toTheRight;
      }
   } // Ends the check to see if the string being replaced is part of the
		// replacement string or not
   return temp; // Send the updated string back to the user
} // Ends the "replaceSubstring" function


/*-------------------------------Sorting start-----------------------*/
var sortNo;
function sortTable(no,dir){
	document.paging.firstpage.disabled= true;
	document.paging.prevpage.disabled= true;
	document.paging.firstpage.className="previousDisable"
	document.paging.prevpage.className="singlePrevDisable"
	document.paging.lastpage.disabled= false;
	document.paging.nextpage.disabled= false;
	document.paging.lastpage.className="next"
	document.paging.nextpage.className="singleNext"
    sortNo = no;
    data_arr.sort(mysortfn)
        if(dir == 'dn'){
            data_arr.reverse();
        }

    if(data_arr.length<rowsPerPage)
  	  makeTable(0,data_arr.length)
  	else
	    makeTable(0,rowsPerPage)
    // document.getElementById('pageno').value=1
    document.getElementById("currStart").innerHTML=1
				document.getElementById("currEnd").innerHTML=5
    document.getElementById("current").innerHTML=1
}
function mysortfn(a,b) {
var a1 = a[sortNo+1].toString().toUpperCase();
var b1 = b[sortNo+1].toString().toUpperCase();

  if (a1<b1) return -1;
  if (a1>b1) return 1;
  return 0;
}

/*-------------------------------Sorting ends-----------------------*/

function initFocus(){
	if(!document.getElementById('contentspace'))
		return;
	inps = document.getElementById('contentspace').getElementsByTagName('input')
	for(v=0;v<inps.length;v++){
		if(inps[v].type == 'button' || inps[v].type == 'submit'){
			inps[v].onfocus = showFocus;
			inps[v].onblur = hideFocus;
		}
	}
}
function showFocus(){
	// this.setAttribute('border',1)
}
function hideFocus(){
	// this.style.borderWidth ="0px";
}

function initTabButtons(){
    buttonObj = document.getElementsByTagName('input')
    if(buttonObj){
        for(i=0;i<buttonObj.length;i++){
            if(buttonObj[i].className=="button"){
                buttonObj[i].onfocus = setBorder;
                buttonObj[i].onblur = resetBorder;
           }
       }
    }
}
function setBorder(){
	// this.style.border = "#146faa"
	// this.style.width = "33px"
	// this.style.height= "20px";
}

function resetBorder(){
	this.style.border = "none"
}



function getDaysInMonth(dobMonth, dobDay, curDay){
    dayinMonth = [31,28,31,30,31,30,31,31,30,31,30,31];
    usrMonth = dobMonth - 1;
    usrDay = dobDay;
    day = curDay;
    daysinMonth = dayinMonth[usrMonth];
    outDay = daysinMonth - usrDay;
    outDay = outDay + day
    return outDay;

}

function clearRecords(obj){
		if(document.getElementById('multiplebutton'))
			document.getElementById('multiplebutton').style.display = "none";
	if(currentRowClicked != ""){
		editRecord(document.getElementById(currentRowClicked),formName)

	}

	obj.blur();
}


function fetchUserValue(obj,formName){

  object = eval('document.'+formName)
  if(obj.value != ""){

   		for(var i = 0;i<userArray.length;i++ ){

      if(userArray[i][0] == obj.value){


           object.loginName.value = userArray[i][0];
           object.userName.value = userArray[i][1];
           object.EmployeeCode.value = userArray[i][2];
           object.password.value = userArray[i][3];
           object.changed_by.value = userArray[i][5];
           object.changed_date.value = userArray[i][6];
           object.changed_time.value = userArray[i][7];
           object.userId.value = userArray[i][8];
           if(userArray[i][4] == "1"){
               userArray[i][4]
               object.status[0].checked = true;
               }
           else
               object.status[1].checked = true;
           break;
       }
   }
  }
  else{
           object.code.value = "";
           object.search_name.value = "";
           object.changed_by.value = "";
           object.changed_date.value = "";
           object.changed_time.value = "";
           object.status[0].checked = true;
 }


}


function checkSearch(){

	if(document.getElementById('searchField').value == ''){
		alert("Please enter value in textfield");

		return false;
	}else
		return true;
}

function checkBlankSoc1(){
var id = document.getElementById('radio').value;

	if(id == 0 ){
		errorMsg += "Please select Option.\n";
		return false;
	}

	return true;


}
function checkBlankSoc1(){

	var id = document.getElementById('radio').value;

	if(id == 0 ){
		errorMsg += "Please select Option.\n";
		return false;
	}

	return true;


}
function fetchUserValue2(obj,formName){

  object = eval('document.'+formName)
  if(obj.value != ""){

   		for(var i = 0;i<userArray2.length;i++ ){

      if(userArray2[i][0] == obj.value){


           object.loginName.value = userArray2[i][0];
           object.userName.value = userArray2[i][1];
           object.EmployeeCode.value = userArray2[i][2];
           object.password.value = userArray2[i][3];
           object.changed_by.value = userArray2[i][5];
           object.changed_date.value = userArray2[i][6];
           object.changed_time.value = userArray2[i][7];
           object.userId.value = userArray2[i][8];

           break;
       }
   }
  }
  else{
           object.code.value = "";
           object.search_name.value = "";
           object.changed_by.value = "";
           object.changed_date.value = "";
           object.changed_time.value = "";
           object.status[0].checked = true;
 }

  }

function checkMaxLength(obj){
      if(window.event){
          keyObj = window.event.keyCode
          if(keyObj == 9 || keyObj == 8 ||keyObj == 46 || keyObj == 16 || keyObj == 37 || keyObj == 36 || keyObj == 35 || window.event.ctrlKey )
              return true;
      }
      if(obj.getAttribute("maxlength")){
       if(obj.value.length>obj.getAttribute("maxlength")-1){
  	        return false;
      	}

      }
}
pasteFlag = false
function checkOnPaste(obj){
 pasteFlag = false;
 /*
	 * txt =window.clipboardData.getData("Text", obj.value)
	 * if(obj.getAttribute("maxlength")){
	 * if((txt.length+obj.value.length)>obj.getAttribute("maxlength")-1){
	 * obj.value = obj.value.substring(0,obj.getAttribute("maxlength")); return
	 * false; } }
	 */
}
function checkMaxLengthMoz(obj){
	// alert(obj);
    if(obj.getAttribute("maxlength")){

     if(obj.value.length>obj.getAttribute("maxlength")-1){
         obj.value = obj.value.substring(0,obj.getAttribute("maxlength"))
        alert("you are crossing maximum length limit pls reduce the some text");
	        return false;
    	}
    }
}
function finalCheck(obj){
 if(obj.getAttribute("maxlength")){
       	if(pasteFlag){
    		obj.value = obj.value.substring(0,obj.getAttribute("maxlength"));

    		pasteFlag = false;
    	}
    }
}

function alertBeforeSubmit(){
	if(confirm("Are you Sure, you want to submit the details ?"))
		return true;
	return false;
}


function resetCheck(){
	document.getElementById('addbutton').style.display = 'inline';
	document.getElementById('reset').style.display = 'inline';
	document.getElementById('editbutton').style.display = 'none';
	document.getElementById('deletebutton').style.display = 'none';
	if(document.getElementById('codeId')!= null){
	document.getElementById('codeId').readOnly = false;
	}
}




// Function to toggle Div, with Plus/Minus image :: By Subin Feb 11 08

function togPlus(objDiv,objImg)
{

	if(document.getElementById(objDiv))
	{
		var myElement = document.getElementById(objDiv);
		if (myElement.style.display == "none")
		{
     	 	myElement.style.display = "none";
    	 	objImg.src = "/hms/jsp/images/minus1.gif";
		}
		else{
	      	myElement.style.display = "none";
	      	objImg.src = "/hms/jsp/images/plus1.gif";
		}
	}
}

// End of Function to toggle Div, with Plus/Minus image


// -----------------For submit form on Enter key Press -----------------------

function submitenter(myfield,e,url,extraFunction)
{

	obj1 = true;
	var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e)
		keycode = e.which;
	else return true;
	if (keycode == 13)
	   {
		// alert(keycode)
	   	if(eval("window."+extraFunction))
	    	obj1 =  eval(extraFunction+"()")

	   if(obj1){
	       if(myfield.form.name == "mmfForm" || myfield.form.name == "indentForm"){
	       	jsSubmit();
	       }else{
		  	 myfield.form.action = url;
		  	 myfield.form.submit();
		  	 }
		   return true;
		}else{
		   return false;
		  }
	   }

}

function validateDate( strValue ) {
  var objRegExp = /^\d{1,2}(\-|\/|\.)\d{1,2}\1\d{4}$/

  if(!objRegExp.test(strValue))
    return false;
  else{
    var strSeparator = strValue.substring(2,3)

    var arrayDate = strValue.split(strSeparator);
    var arrayLookup = { '01' : 31,'03' : 31, '04' : 30,'05' : 31,'06' : 30,'07' : 31,
                        '08' : 31,'09' : 30,'10' : 31,'11' : 30,'12' : 31}
 var intDay = parseInt(arrayDate[0],10);


    if(arrayLookup[arrayDate[1]] != null) {
      if(intDay <= arrayLookup[arrayDate[1]] && intDay != 0)
        return true;
    }
 var intMonth = parseInt(arrayDate[1], 10);

    if (intMonth == 2) {
       var intYear = parseInt(arrayDate[2]);
       if( ((intYear % 4 == 0 && intDay <= 29) || (intYear % 4 != 0 && intDay <=28)) && intDay !=0)
          return true;
       }
  }
  return false;
}

// ------------------ Start For Dynamic
// Grid---------------------------------------

// This function is used for adding a row dynamically to a table
// At a time generateRow() will one to table
	   function generateRow(idName) {

		var d=document.getElementById(idName).getElementsByTagName("tr");
		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);

		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input");

		tblCtrl[1].value=d.length-1;
		for(var i=4;i<tblCtrl.length;i++)
			tblCtrl[i].value="";

		}
		// created By Shailesh
		 function generateRowWithSrNos(idName) {

		var d=document.getElementById(idName).getElementsByTagName("tr");
		lastTr = d[d.length-1]
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);

		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input");
		var firstRow=d[1].getElementsByTagName("input");

		tblCtrl[1].value=d.length-1;
		var cnt=d.length-2;
		for(var i=4;i<tblCtrl.length;i++){
			tblCtrl[i].value="";

	tblCtrl[i].setAttribute("id",firstRow[i].getAttribute("id")+""+cnt);


			}

		}

function generateRowWithoutSrNo(idName) {

		var d=document.getElementById(idName).getElementsByTagName("tr");
		lastTr = d[d.length-1]
		var noOfRows=d.length
		clone = lastTr.cloneNode(true);
		clone.id = parseInt(lastTr.id);
		lastTr.parentNode.insertBefore(clone,lastTr.nextSibling)
		var tblCtrl = d[d.length-1].getElementsByTagName("input");
		for(var i=0;i<tblCtrl.length;i++)
			tblCtrl[i].value="";
			document.getElementById('amcTDetailsListSize').value=noOfRows


		}

// This function is used for deleting multiple rows at time
		function removeRow(argIndex,idName){

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
	         if(tblRows.length-1==check){
	         	alert("Can not delete all rows")
	         	return false;
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



 // ------------------ End For Dynamic
	// Grid---------------------------------------


// ------------------ This is For SOC
// Indent---------------------------------------
function submitFormSOC(formName,action,extraFunction,extraFunction2,extraFunction3){
errorMsg="";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		if(eval("window."+extraFunction))
	    	ob1 =  eval(extraFunction+"()")

			if(eval("window."+extraFunction2))
	        	ob2 = eval(extraFunction2+"()")

			if(eval("window."+extraFunction3))
	        	ob3 = eval(extraFunction3+"()")

			if(validateFields(formName)== true & ob1 & ob2 &ob3){
	        	return true;

			}else{

				if(errorMsg != ""){
					alert(errorMsg);
		       		return false;
		       	}
		       	return true;
	    	}
	}

	// ------------ function for adding no. of days to a date--------
	// Added by Priyanka Garg
	function submitEDReturns(formName,extraFunction1,extraFunction2,extraFunction3,extraFunction4)
	{
		visitId = document.getElementById('visitId').value;
		edDate=document.getElementById('edDate').value;
		edDays=document.getElementById('edDays').value;
		edDispose=document.getElementById('edDispose').value;
		edDate1=document.getElementById('edDate1').value;
		edDate2=document.getElementById('edDate2').value;
		edDate3=document.getElementById('edDate3').value;
		// ldDate=document.getElementById('ldDate').value;
		// ldDays=document.getElementById('ldDays').value;


		ob1=true;
		ob2=true;
		ob3=true;
		ob4=true;
		obj = eval('document.'+formName)
		if(eval("window."+extraFunction1))
	    	ob1 =  eval(extraFunction1+"()")

	    if(eval("window."+extraFunction2))
	    	ob2 =  eval(extraFunction2+"()")

	    if(eval("window."+extraFunction3))
	    	ob3 =  eval(extraFunction3+"()")

	     if(eval("window."+extraFunction4))
	    	ob4 =  eval(extraFunction4+"()")


    	var url;
   		if(formName == 'EDDetails')
    	url = "/hms/hms/mis?method=editEDReturns&visitId="+visitId
    	      +"&edDays="+edDays+"&edDate="+edDate+"&edDispose="+edDispose
    	      +"&edDate1="+edDate1+"&edDate2="+edDate2+"&edDate3="+edDate3;


     	if(ob1 & ob2 & ob3 & ob4)
    	{
	    	obj.action = url;
			obj.submit();

		}else{
		return false;
	}

// new Ajax.Updater('statusMessage', url, {asynchronous:true,
// evalScripts:true});
}
function checkEdReturnField()
{

  var noOfEdDays=document.getElementById("edDays").value;
// var noOfLdDays=document.getElementById("ldDays").value;
  var edStartDate=document.getElementById("edDate").value;
 // var ldStartDate=document.getElementById("ldDate").value;
  var dispose=document.getElementById("edDispose").value;

  if(((noOfEdDays!="" && edStartDate!="")||(noOfLdDays!="" && ldStartDate!="")) && dispose!="")
 	{

  		return true;
  	}
  else
  {
  		alert("Enter Data for mandatory fields");
  		return false;
  }
}
function submitEdReturnForm()
{
  var noOfEdDays=document.getElementById("edDays").value;
 // var noOfLdDays=document.getElementById("ldDays").value;
  var edStartDate=document.getElementById("edDate").value;
  // var ldStartDate=document.getElementById("ldDate").value;
  var edDispose=document.getElementById("edDispose").value;
  var formatEdDate=new Date(edStartDate.substring(6),(edStartDate.substring(3,5) - 1) ,edStartDate.substring(0,2));
  // var formatLdDate=new
	// Date(ldStartDate.substring(6),(ldStartDate.substring(3,5) - 1)
	// ,ldStartDate.substring(0,2));
  var currentDate=new Date();


    	if(noOfEdDays!="" && edStartDate=="")
  		{
  			alert("Provide Start Date !!");
  			document.getElementById("edDate").focus;
  			return false;

 		 }
 		 if(noOfEdDays=="" && edStartDate!="")
 		 {
  			alert("Provide No. of days !!");
  			document.getElementById("edDays").focus;
  			return false;
  		}
  /*
	 * if (noOfLdDays!="" && ldStartDate=="") { alert("Provide LD Start Date
	 * !!"); document.getElementById("ldDate").focus; return false; }
	 * if(noOfLdDays=="" && ldStartDate!="") { alert("Provide no. of days of LD
	 * !!"); document.getElementById("ldDays").focus; return false; }
	 */
  	if(formatEdDate>currentDate)
  	{
  		alert("Start Date should be less than Today's Date!");
  		return false;
  	}
 /*
	 * if(formatLdDate>currentDate) { alert("LD Start Date should be less than
	 * Today's Date!"); return false; }
	 */

  	if(edDispose=="ED")
 	{
 		if(noOfEdDays>2)
 		{
 			alert("Not more than 2 ED allowed!!");
 			document.getElementById("edDays").value="";
 			document.getElementById("edDays").focus;
 			return false;
 		}
 		else
 		{
 			addDays();

 		}
 	}
 	else if(edDispose=="LD" || edDispose=="MD")
 	{
 		if(noOfEdDays<=0)
 		{
 			alert("Invalid Data in No. of days!!");
 			document.getElementById("edDays").value="";
 			document.getElementById("edDays").focus;
 			return false;
 		}
 		else
 		{
 			document.getElementById("edDate1").value="";
			document.getElementById("edDate2").value="";
			document.getElementById("edDate3").value="";
 		}
 	}
  		return true;
}
	function addDays()
	{
		if(document.getElementById("edDispose").value=="ED")
		{
			document.getElementById("edDate1").value="";
			document.getElementById("edDate2").value="";
			document.getElementById("edDate3").value="";
			edDays=document.EDReturns.edDays.value;
			var currentDate=new Date();
			var edStartDate=document.getElementById("edDate").value;
			var edDate = new Date(edStartDate.substring(6),(edStartDate.substring(3,5) - 1) ,edStartDate.substring(0,2))
			var calculatedDate=new Array();
			var counter=0;
			while(counter<edDays)
			{
				calculatedDate[counter]=new Date(edDate.getTime()+counter*24*60*60*1000);
				counter++;

			}
			if(calculatedDate[0]!=null)
				document.getElementById("edDate1").value=calculatedDate[0].getDate()+"/"+eval(calculatedDate[0].getMonth()+1)+"/"+calculatedDate[0].getFullYear();
			if(calculatedDate[1]!=null)
				document.getElementById("edDate2").value=calculatedDate[1].getDate()+"/"+eval(calculatedDate[1].getMonth()+1)+"/"+calculatedDate[1].getFullYear();
			if(calculatedDate[2]!=null)
				document.getElementById("edDate3").value=calculatedDate[2].getDate()+"/"+eval(calculatedDate[2].getMonth()+1)+"/"+calculatedDate[2].getFullYear();
		}
	}


function validateSearchForAdt(){

	var searchValue;
	var serviceNo;
	var hinNo;
	var patientName;
	var adNo;

	if(document.getElementById('searchField'))
	 	searchValue = document.getElementById('searchField').value;
	if(document.getElementById('serviceNo'))
		serviceNo = document.getElementById('serviceNo');
	if(document.getElementById('hinNo'))
		hinNo = document.getElementById('hinNo');
	if(document.getElementById('patientName'))
		patientName = document.getElementById('patientName');
	if(document.getElementById('adNoId'))
		adNo = document.getElementById('adNoId');


	if(trimAll(searchValue) == ''){
		alert("Please enter value in textfield.");
		return false;
	}else{
		if(serviceNo.checked){
			if(!validateAlphaNumeric(trimAll(searchValue))){
				alert("Service No is not valid.");
				document.getElementById('searchField').value = "";
				return false;
			}
		}else if(hinNo.checked){
			if(!validateNumeric(trimAll(searchValue))){
				alert("Hin No is not valid.");
				document.getElementById('searchField').value = "";
				return false;
			}
		}else if(patientName.checked){
			if(!validateAlphaSpace(trimAll(searchValue))){
				alert("Patient Name is not valid.");
				document.getElementById('searchField').value = "";
				return false;
			}
		}else if(adNo.checked){
			if(!validateNumericWithSlash(trimAll(searchValue))){
				alert("Ad No is not valid.");
				document.getElementById('searchField').value = "";
				return false;
			}
		}
	}
	return true;
}

function validateNumericWithSlash(strValue){
	var objRegExp = /^(\d{1,}[\/]\d*[\/]\d*[\/]\d*)$/
	return objRegExp.test(strValue);

}
function checkBlankForPatientSearch(){

			var hinNo=document.getElementById("hinNo").value
			var admissionNo=document.getElementById("admissionNo").value
			if( hinNo != "" || admissionNo != 0 )
			{
				if(hinNo != "")
				{
					if(!chkSpaces(hinNo))
					  {
					  	alert("Please Enter The HIN Number without Spaces.")
					  	return false;
					  }
				  if(trimAll(hinNo) =="" )
					{
						alert("Please Enter the correct value of HIN No without spaces.")
						return false;
					}

				}
				 return true;
			}
			if(hinNo == "" && admissionNo == 0 )
			{
			 alert("Please select the value for searching the patient")
			 return false;
			}
		   return true;
		}

	function checkFromNTodata(){

	var fromDateForm=document.getElementById("fromDateId").value;
	var toDateForm=document.getElementById("ToDateId").value;
	var fromDate=new Date(fromDateForm.substring(6),(fromDateForm.substring(3,5) - 1) ,fromDateForm.substring(0,2));
	var toDate=new Date(toDateForm.substring(6),(toDateForm.substring(3,5) - 1) ,toDateForm.substring(0,2));
	var currentDate=new Date();
	if((fromDate>currentDate)|| (fromDate>toDate))
	{
		alert("Invalid Date in From Date!!");
		return false;
	}
	if((toDate>currentDate)||(toDate<fromDate))
	{
		alert("Invalid To Date!!");
		return false;
	}
	return true;
}

function checkDateNotGreaterThanCurrentDate()
{
	var inputDate=document.getElementById("inputDate").value;
	var currentDate=new Date();
	var formatInputDate=new Date(inputDate.substring(6),(inputDate.substring(3,5) - 1) ,inputDate.substring(0,2));
	if(formatInputDate>currentDate)
	{
		alert("Wrong Date entered !");
		return false;
	}
	else
		return true;
}


// =======
function freight(){
var freight = document.getElementById('freightDuty').value
if(!validateFloat(freight)){
alert(" Freight Duty should be an integer or float");
}
}

function excise(){
var exciseDuty = document.getElementById('exciseDuty').value
if(!validateFloat(excise)){
alert(" Excise Duty should be an integer or float");
}
}

function custom(){
var customDuty = document.getElementById('customDuty').value
if(!validateFloat(custom)){
alert(" Custom Duty should be an integer or float");
}
}

function octroi(){
var octroi = document.getElementById('octroi').value
if(!validateFloat(octroi)){
alert(" Octroi should be an integer or float");
}
}


function insurance(){
var insuranceCharges = document.getElementById('insuranceCharges').value
if(!validateFloat(insurance)){
alert(" Insurance Charges should be an integer or float");
}
}


function otherCharges(){
var otherCharges = document.getElementById('otherCharges').value
if(!validateFloat(otherCharges)){
alert(" Other Charges should be an integer or float");
}
}


function custom(){
var customDuty = document.getElementById('customDuty').value
if(!validateFloat(custom)){
alert(" Custom Duty should be an integer or float");
}
}
// ---------Added By Othi-----------------
function validateRadioForGroup()
	{
			 for(var i = 0; i < document.getElementsByName('groupHospitalId').length; i++){
			  if(document.getElementsByName('groupHospitalId')[i].checked == true)
              {
				return true;
			  }
  		}
  		alert("Please select the Group")
		return false;
	}




// ------- For Setting target of form --- By Ritu-----------------------

function checkTargetForYes(){
	var aTags = document.getElementsByTagName('form');
	for (i=0; i < aTags.length; i++) {
			aTags[i].setAttribute("target", "_blank");
		}
	return true;
}

function checkTargetForNo(){
	var aTags = document.getElementsByTagName('form');
	for (i=0; i < aTags.length; i++) {
			aTags[i].setAttribute("target", "_self");
		}
	return true;
}

// ---------------------------------------------------
function multiplResults(obj){
if(obj.checked == true){
var url;
url="/hms/hms/investigation?method=showNormalValue";
// alert(url);
obj.action=url;
obj.submit();
}else{
}
}
// -------------------- Added by Priyanka Fro Appointment Module --------------


function validateCriteria(){

			 for(var i = 0; i < document.getElementsByName('selectedRadio').length; i++){
			// alert("i-- "+i)
			// alert("document.getElementsByName('parent').length"+
			// document.getElementsByName('parent').length)
			  if(document.getElementsByName('selectedRadio')[i].value != "0" )
              {
				if(document.getElementsByName('selectedRadio')[i].value=="serviceNo")
				{
					document.getElementsByName('serviceNo')[i].value!=""
					return true;
				}
				else if(document.getElementsByName('hinNo')[i].value=="hinNo")
				{
					document.getElementsByName('hinNo')[i].value!=""
					return true;
				}

			  }
  		}
		return false;

}
// -----------------Function By Dipali--------------
 function selectAccepted()
{
	if(document.getElementById('validated').checked==true)
	{
		document.getElementById('accepted').checked=true;
	}
	else
	{
		document.getElementById('accepted').checked=false;
	}
}

function compareTime(formName)
{
	if(document.formName.fromTime.value >= document.formName.toTime)
	{
		alert("From Time should be less than To Time");
		return false;
	}
	return true;

}

		function isApptGrCurrentDate()
		{
			var appointmentDate=document.getElementById('appointmentdate').value;
			apmtDate = new Date(appointmentDate.substring(6),(appointmentDate.substring(3,5) - 1) ,appointmentDate.substring(0,2));
		 	currentDate = new Date();
			var month = currentDate.getMonth() + 1
			var day = currentDate.getDate()
			var year = currentDate.getFullYear()
			var seperator = "/"
			currentDate = new Date(month + seperator + day + seperator + year);
			if(apmtDate < currentDate)
			{
				alert("Appointment Date should be greater than Today's date!!");
				document.getElementById('appointmentdate').value="";
				return false;
			}
			return true;
		}

		function checkForHoliday()
		{
			if(holidayArray.length>0)
			{
				for(i=0;i<holidayArray.length;i++)
				{
					if(holidayArray[i][1]==document.getElementById('appointmentdate').value)
					{
						alert(holidayArray[i][1]+" is Holiday on the Ocasion of "+holidayArray[i][0]);
						document.getElementById('appointmentdate').value="";
						return false;
					}
				}
			}
			return true;
		}

		/*
		 * method for opd module in surgery requisition form for opd patient and
		 * In patient
		 */

	function validateSurgeryForAutoComplete( strValue,inc ) {

 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    // alert("id----"+id)

		    if(id =="")
		    {
		    		document.getElementById('chargeCodeName'+inc).value="";
	   				document.getElementById('chargeCode'+inc).value="";
 					return ;
 			}
 			return true;
		}




function goToPageOnThisValue(pageno){

	if(pageno!="")
	{
	if( (pageno>totalPages) || (pageno<=0) || (pageno%1!=0) )
	{
		alert("Please Enter Correct Page No.")
		document.paging.pageno.value=""
		return false;
	}
	if(pageno == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"
	}
	else if(pageno == totalPages){
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"

		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"
	}
	else{
		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"

		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"
	}
	}
	if(pageno*rowsPerPage<data_arr.length)
		makeTable(pageno*rowsPerPage-rowsPerPage,pageno*rowsPerPage)
	else
		makeTable(pageno*rowsPerPage-rowsPerPage,data_arr.length)

		document.getElementById("currStart").innerHTML=(pageno-1)*5+1
		document.getElementById("currEnd").innerHTML=(pageno)*5

		document.getElementById("current").innerHTML=pageno


	document.paging.pageno.value=""

}



/** ******************************* */
<!-- function for pagination -->


	function Pager(tableName, itemsPerPage) {

     this.tableName = tableName;
    this.itemsPerPage = itemsPerPage;
    this.currentPage = 1;
    this.pages = 0;
    this.inited = false;

    this.showRecords = function(from, to) {
        var rows = document.getElementById(tableName).rows;
        // i starts from 1 to skip table header row
        for (var i = 0; i < rows.length; i++) {
            if (i < from || i > to)
                rows[i].style.display = 'none';
            else
                rows[i].style.display = '';
        }
    }

    this.showPage = function(pageNumber) {
    	if (! this.inited) {
    		alert("not inited");
    		return;
    	}
    	if(document.getElementById('pageEditNo'))
    		document.getElementById('pageEditNo').value = pageNumber;
        var oldPageAnchor = document.getElementById('pg'+this.currentPage);
        oldPageAnchor.className = 'pg-normal';

        this.currentPage = pageNumber;
        var newPageAnchor = document.getElementById('pg'+this.currentPage);
        newPageAnchor.className = 'pg-selected';
        
        currentPageNo=pageNumber;

        var from = (pageNumber - 1) * itemsPerPage;
        
       

        var to = from + itemsPerPage - 1;

        this.showRecords(from, to);
    }

    this.prev = function() {
        if (this.currentPage > 1)
            this.showPage(this.currentPage - 1);
    }

    this.next = function() {
        if (this.currentPage < this.pages) {
            this.showPage(this.currentPage + 1);
        }
    }

    this.init = function() {
        var rows = document.getElementById(tableName).rows;
        var records = (rows.length);
        this.pages = Math.ceil(records / itemsPerPage);
        this.inited = true;
    }

    this.showPageNav = function(pagerName, positionId) {
    	if (! this.inited) {
    		alert("not inited");
    		return;
    	}
    	var element = document.getElementById(positionId);
    	var pagerHtml=""
    	pagerHtml = '<span onclick="' + pagerName + '.prev();" class="previous">Prev</span> | ';

        for (var page = 1; page <= this.pages; page++)
            pagerHtml += '<span id="pg' + page + '" class="pg-normal" onclick="' + pagerName + '.showPage(' + page + ');">' + page + '</span> | ';
        pagerHtml += '<span onclick="'+pagerName+'.next();" class="next">Next</span>';

        element.innerHTML = pagerHtml;
    }
}

<!-- Methods to restrict char length in textarea-->
	var str="";

	<!-- call  onkeyup-->
	function refreshLength(id,maxLen)
	{
  		var len = document.getElementById(id).value.length;
	  	if(len>maxLen)
  		{
  			document.getElementById(id).value = str;
	  	}
  		else if(len>=maxLen)
	  	{
			document.getElementById(id+'len2').style.display='block';
	  	}
  		else
	  	{
			document.getElementById(id+'len2').style.display='none';
	  	}
  		len = document.getElementById(id).value.length;
		document.getElementById(id+'len1').innerHTML='('+(maxLen-len)+' characters left)';

	}

	<!-- call  onkeydown-->
	function refreshLength1(id,maxLen)
	{
  		var len = document.getElementById(id).value.length;
	  	if(len<=maxLen)
  		{
			str=document.getElementById(id).value;
		}
	  	refreshLength(id,maxLen);

	}

	function disablefields(tag)
	{

	var inputFields = document.getElementsByTagName(tag);

	for(i=0;i < inputFields.length ; i++ )
	{

		if(tag == 'select')
		{
		inputFields[i].disabled = 'true';
		}
		else
		{
			inputFields[i].setAttribute('readonly','readonly') ;

			if(inputFields[i].type != 'button')
			{
			inputFields[i].setAttribute('class','readOnly') ;
			}
		}
	}
	}

function hideObjects(obj)
{
	var ob = document.getElementsByTagName(obj);
	for( i =0 ; i< ob.length ;i++){
	ob[i].style.visibility = "hidden";
	}
}

function displayDiscountRecordForEdit(idVal){
	submitProtoAjax('discountMaster','billingMaster?method=getDiscountDetailsForEdit&discountId='+idVal);

}
function displayUnitWiseBed(idVal,unitCode){
		submitProtoAjax('admissionAcceptance','/hms/hms/ipd?method=displayUnitWiseBed&inpatientId='+idVal+'&unitCode='+unitCode);

}
function showChargeCodeDetails(idVal,rows,formName){
   // mainChrg = data_arr[rows][23];
    // populateSubChargeCode(mainChrg,'chargeCode');
	editRecord(document.getElementById(data_arr[rows][0]),formName);
}

function displayPackageDetails(idVal,rows){
	code  = data_arr[rows][2];
	pkgDesc = data_arr[rows][3];
	status = data_arr[rows][8];

		document.getElementById('pkgCodeId').value = code;
		document.getElementById('pkgDescId').value = pkgDesc;
		document.getElementById('frozenId').value = status;
		// submitProtoAjax('packageList','packageBilling?method=getPackageDetailsForDisplay&packageId='+idVal);
}

function displayHospitals(idVal,rows){
	
		submitProtoAjax('hospital','user?method=getHospitalForDisplay&hospitalId='+idVal);
}

function displayTablet(idVal,rows){
	
	submitProtoAjax('tabletAssetAdd','pubHealth?method=tabletAssetsMasterSearch&hospitalIds='+idVal);
}

currentRowForOrderStatus ="";
function RequestForViewTestCodeDetails(obj,obj1,formName){

	if(currentRowForOrderStatus != "")
	{
		if(document.getElementById(currentRowForOrderStatus)){
			document.getElementById(currentRowForOrderStatus).style.backgroundColor = "";
		}
		obj.style.backgroundColor = '#9CCEE4';
		currentRowForOrderStatus = obj.id;
	}else if(currentRowForOrderStatus == ""){
		obj.style.backgroundColor = '#9CCEE4';
		currentRowForOrderStatus = obj.id;
	}
	result = obj.id;
    obj1 = eval('document.'+formName);
    var url;

    if(formName == 'orderNoListForOrderStatus'){
	  // url =
		// "/hms/hms/lab?method=viewAllTestForOrderNo&dgOrderHdId="+result;
    	 url = "/hms/hms/lab?method=viewIpdTestForOrderNo&dgOrderHdId="+result+"&dischargeSummaryFlag="+obj1;
	    submitProtoAjax('orderNoListForOrderStatus',url);
   	}
}



function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
   }
   return this
}

var dtCh= "/";
var minYear=1900;
var maxYear=2100;
function isDate(dtStr,fieldId){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strDay=dtStr.substring(0,pos1)
	var strMonth=dtStr.substring(pos1+1,pos2)
	
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
	if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)
	if (pos1==-1 || pos2==-1){
	alert("The date format should be : DD/MM/YYYY" );
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (strMonth.length<1 || month<1 || month>12){
	alert("Please enter a valid month");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
	alert("Please enter a valid day");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
	alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear+"");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
	alert("Please enter a valid date ");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	return true
	}

function validateExpDate(dt,fieldId){
	
	if(dt.value!=""){
	if (isDate(dt.value,fieldId)==false){
	return false
	}}
	return true
	}
function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}
function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

// javed khan
function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31
     && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

/*
 * function RequestForViewTestCodeDetails(obj,formName){
 * 
 * if(currentRowForOrderStatus != "") {
 * if(document.getElementById(currentRowForOrderStatus)){
 * document.getElementById(currentRowForOrderStatus).style.backgroundColor = ""; }
 * obj.style.backgroundColor = '#9CCEE4'; currentRowForOrderStatus = obj.id;
 * }else if(currentRowForOrderStatus == ""){ obj.style.backgroundColor =
 * '#9CCEE4'; currentRowForOrderStatus = obj.id; } result = obj.id; obj1 =
 * eval('document.'+formName); var url;
 * 
 * if(formName == 'orderNoListForOrderStatus'){ url =
 * "/hms/hms/lab?method=viewAllTestForOrderNo&dgOrderHdId="+result;
 * submitProtoAjax('orderNoListForOrderStatus',url); } }
 */


function validateMetaCharacters( strValue ) {
	var objRegExp=/(\s{2,})|([\\\/\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
	
}
function validateMetaCharactersWithSlash( strValue ) {
	var objRegExp=/(\s{2,})|([\\\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);	
}
function validateMetaCharactersWithSpace( strValue ) {
	var objRegExp=/([\\\/\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
}

function validateMetaCharactersWithBrace( strValue ) {
	var objRegExp=/(\s{2,})|([\\\/\.\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
	
}

function validateMetaCharactersWithSpaceAndBrac( strValue ) {
	var objRegExp=/([\\\/\.\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
}

function validateMetaCharactersExam( strValue ) {
	var objRegExp=/([\\\_\:\@\$\*\"\&\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
	
}
function validateMetaCharWithSpaceSlashDash( strValue ) {
	var objRegExp=/([\\\.\(\)\_\:\@\$\*\"\&\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
}

function validateMetaCharactersWithSpaceDas( strValue ) {
	var objRegExp=/([\\\/\.\(\)\_\:\@\$\*\"\&\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
}
function validateMetaCharactersWithSpaceAndSlash( strValue ) {
	var objRegExp=/([\\\.\(\)\_\:\@\$\*\"\&\-\'\`\#\�\�\?\%\&\<\>\=\n\r])/i
	return !objRegExp.test(strValue);
}

function totalPost()
{
	// alert('vk');
	var totalStrength=document.getElementById('sanctionPostNo').value;
	var d=document.getElementById('tempPost').value;
	var p=document.getElementById('permaPost').value;
	var c=document.getElementById('supernumPost').value;

	var d1=(parseInt(""+d))+(parseInt(""+c))+(parseInt(""+p));
	
	if((parseInt(""+totalStrength))==d1){
		return true;
	} else{
		alert("Sanction Post No. should equal to Permanent Post, Temporary Post & Supernumerary Post!!")
		return false;
	}
	alert("Please Enter Correct values2!!")
// return false;
}


function displayPayward(wardId,payward){
	if(wardId=='Ward Nursing Station'){
		document.getElementById('payWardDiv').style.display='block';
		if(payward=='y')
			document.getElementById('payWard').checked=true;
		else
			document.getElementById('payWard').checked=false;
	}else{
		document.getElementById('payWardDiv').style.display='none';
		document.getElementById('payWard').checked=false;
	}
}

/* added by amit das on 29-06-2016 */
function submitFormForDirectPrint(formName,action){
	action = action+"&"+getNameAndData(formName)
	newwindow=window.open(action,'name',"left=100,top=100,height=300,width=580,status=1,scrollbars=1,resizable=1");   
	
}

// added by amit das on 30-06-2016
function generatePrintLab(orderId,dgSampleDetailId,orderNo,subChargeCode,hospitalId,sampleNumber,modality,DiagNo,investIdList){
	var action = "lab?method=generateReportForLabMachineBarcode&orderId="+orderId+"&dgSampleDetailId="+dgSampleDetailId+"&orderNo="+orderNo+"&subChargeCode="+subChargeCode+"&hospitalId="+hospitalId+"&sampleNumber="+sampleNumber+"&modality="+modality+"&DiagNo="+DiagNo+"&investIdList="+investIdList;
	newwindow=window.open(action,'name',"left=100,top=100,height=300,width=580,status=1,scrollbars=1,resizable=1");
	
}

// added by amit das on 02-11-2016
function RequestForIpMappingEdit(id,displayName,departments,departmentType){
	var departmentNamesArray;
	var departmentsSelect;
	var departmentOptionLegth;
	var departmentTypeId;
	var departmentTypeOptionLegth;
	document.getElementById('displayName').value = displayName;
	document.getElementById('tokenDisplayIpId').value = id;
	if(departments.lastIndexOf(',')>0 && departments!=''){
		departmentNamesArray = departments.split(',');
	} else if(departments!=''){
		departmentNamesArray = [departments];
	}
	
	departmentsSelect = document.getElementById('departmentIds');
	departmentOptionLegth = departmentsSelect.options.length;
	departmentTypeId = document.getElementById('departmentTypeId');
	departmentTypeOptionLegth = departmentTypeId.options.length;
	
	for(var j=0; j<departmentTypeOptionLegth;j++){
		if(departmentTypeId.options[j].value == departmentType){
			departmentTypeId.options[j].selected = 'selected';
			getServiceCenters();
			
			setTimeout(function(){
				if(departmentNamesArray){
					for(var i=0; i<departmentNamesArray.length;i++){
						for(var j=0; j<departmentOptionLegth;j++){
							if(departmentsSelect.options[j].text == departmentNamesArray[i]){
								departmentsSelect.options[j].selected = 'selected';
							}
						}
					}
				}
			},1130);
			
		}
	}
	
	
	
	
	
}    

// added by govind 16-11-2016
function editBagQuantity(){
	var classText;
	var calssSelect = document.getElementById("itemCategoryId");
	if(calssSelect!="" && null !=calssSelect  && undefined !=calssSelect){
	 classText = calssSelect.options[calssSelect.selectedIndex].text;
	}
	if(classText!="" && null !=classText && undefined !=calssSelect){
	if(classText=='Blood Bag'){
		document.getElementById("bagDiv").style.display = "block";
	}else{
		document.getElementById("bagDiv").style.display = "none";
	}
	}
}   // added by govind 16-11-2016 end


function checkMonth(dobj,dateString)      
 {
	if(dateString!=""){
		var date1="";
		currentDate = new Date();
		var month = currentDate.getMonth() + 1
		var day = currentDate.getDate()
		var year = currentDate.getFullYear()
		var seperator = "/"
		currentDate = new Date(month + seperator + day + seperator + year);
		
		date1 = new Date(dateString.substring(6),(dateString.substring(3,5) - 1) ,dateString.substring(0,2));
		
		if(date1 > currentDate)
	 	{
			alert("Date is not valid. It can be current or previous date.")
			dobj.value="";
			
			return false;
	 	}
		 return true;
	}
	 return true;
 }

// added by amit das on 31-08-2017
function RequestForChargeFromOPScreen(obj,formName,flag)
{
	var hinId = document.getElementById('hinId').value;
	var RequisitionFrom = document.getElementById('RequisitionFrom').value;
	var orderId;
	var departmentId;
	
	if(document.getElementById('orderId')){
		orderId = document.getElementById('orderId').value;
	}
	
	
	if(document.getElementById('departmentId')){
		departmentId = document.getElementById('departmentId').value;
	}
	
	
	sampleCollectionDetail = obj.id;
    obj1 = eval('document.'+formName)
    var url;
    
    if(flag=='y'){  // added by amit das on 31-08-2017
    	url = "/hms/hms/lab?method=submitSampleCollectionForOutSideLab&hinId="+hinId+"&departmentId="+departmentId+"&orderId="+orderId+"&orderDtId="+sampleCollectionDetail;
    
    } else {
    	if(hinId != 0){
    		if(formName == 'pendingResultForOPScreen')
    			url = "/hms/hms/investigation?method=searchPatientForTemplteOPD&hinId_OPD="+hinId+"&RequisitionFrom="+RequisitionFrom+"&sampleCollectionDetailId="+sampleCollectionDetail;
    		
		}
    	else{
    		if(formName == 'pendingResultForOPScreen')
    			url = "/hms/hms/investigation?method=searchPatient&sampleCollectionDetailId="+sampleCollectionDetail;
    		
    	}   
    }

   	obj1.action = url;
    obj1.submit();
}

//added by amit das on 17-07-2017
function bookLabForDoctor(page){
	var e = document.getElementById("subChargeCodeId");
	var userId = document.getElementById("userId").value;
	var subChargeCodeId = e.options[e.selectedIndex].value;
	var action = "/hms/hms/lab?method=bookLabForDoctor&subChargeCodeId="+subChargeCodeId+"&userId="+userId;
	if(subChargeCodeId!='0'){
		submitProtoAjax('patientSearch', action);
		
		if(page=='sampleValidation')
			getSamplePendingList();
		else if (page=='resultEntry')
			getResultEntryPendingList();
		else if (page=='resultValidation')
			getResultValidationPendingList();
		else if (page=='resultPrinting')
			getResultPrintingList();
		
	
	}	
}

function RequestForBloodEntry(obj1,formName,obj2){
	obj = eval('document.'+formName);
	url = "/hms/hms/bloodBank?method=showBloodRequestEntryJsp&hinId="+obj1.id+"&visitId="+obj2;
	obj .action = url;
	obj .submit();
}



function validateTwoDates(fromDate, toDate){
if(fromDate.value!= "" && toDate.value!= "")
	{

	validFromDate=new Date(fromDate.value.substring(6),(fromDate.value.substring(3,5) - 1) ,fromDate.value.substring(0,2));
	validToDate=new Date(toDate.value.substring(6),(toDate.value.substring(3,5) - 1) ,toDate.value.substring(0,2));

		
				if(validFromDate > validToDate)
				{
						errorMsg = "From Date should be smaller than To Date\n";
						alert(errorMsg);
						return false;
				}
	}
else if(fromDate.value!= "" || toDate.value!= ""){
	alert("Please Enter both From Time and To Time");
	return false;
}

	return true;
}


function validateFromToTime(fromTime, toTime){
	fromTime = fromTime.value
	toTime =    toTime.value
	if(fromTime!="" || toTime!=""){
	var fromHours = fromTime.split(':');
	var toHours = toTime.split(':');
	var fHours = fromHours[0];
	var tHours = toHours[0];
	
	if( (parseInt(fHours)) <= (parseInt(tHours)) ){
		return true;			
	}else{
		if(fromTime=="")
			alert("Please enter From Time");
		else if(toTime=="")
			alert("Please enter To Time");
		else
		alert('From Time must be less than To Time');
		return false;
	}
	}
	return true;
}