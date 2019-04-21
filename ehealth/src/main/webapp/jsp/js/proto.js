document.write("<script type='text/javascript' src='/hms/jsp/js/prototype.js'></script>");
function submitProtoAjaxforAttendence(formName,action){

		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action+"&"+getNameAndData(formName);
	    	   	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	        	new Ajax.Updater('employeeIdsDiv',url,
				   {asynchronous:true, evalScripts:true });

		       	return true;
	    	}

function submitRadioAjax(formName,action,temp){

		errorMsg = "";

		obj = eval('document.'+formName)
		       obj.action = action;

	    	   	 var url=action+"&radioForPvms="+temp;
	    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	        	new Ajax.Updater('testDiv',url,
				   {asynchronous:true, evalScripts:true });


		       	return true;
	    	}


	function submitProtoAjax(formName,action){
		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName);
		       	obj.action = action;
	    	   	 var url=action+"&"+getNameAndData(formName);
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	        	new Ajax.Updater('testDiv',url,
				   {asynchronous:true, evalScripts:true });
				return true;
	    	}


	function submitProtoAjaxForOpdMainTemplate(formName,action){

		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName);
		       	obj.action = action;
	    	   	 var url=action+"&"+getNameAndData(formName);
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	        	new Ajax.Updater('divTemplet',url,
				   {asynchronous:true, evalScripts:true });
				return true;
	    	}


	function submitProtoAjaxforGrid(formName,action){
	 errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action+"&"+getNameAndData(formName);
	    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	        	new Ajax.Updater('gridDiv',url,
				   {asynchronous:true, evalScripts:true });
		       	return true;
	    	}

	
	function submitProtoAjaxforGRN(formName,action){
		 errorMsg = "";
			ob1 = true;
			ob2 = true;
			ob3 = true;
			obj = eval('document.'+formName)
			       	obj.action = action;
		    	   	 var url=action+"&"+getNameAndData(formName);
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
		        	new Ajax.Updater('grnDiv',url,
					   {asynchronous:true, evalScripts:true });
			       	return true;
		    	}

	   function submitProtoAjaxforAttendence(formName,action){

		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action+"&"+getNameAndData(formName);
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	        	new Ajax.Updater('employeeIdsDiv',url,
				   {asynchronous:true, evalScripts:true });

		       	return true;
	    	}
	    		function submitProtoAjaxWithDivNameToShowStatus(formName,action,divName){

		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)

		       	obj.action = action;
	    	   	var url=action+"&"+getNameAndData(formName);
	    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	            var oOptions = {
	                asynchronous:true, evalScripts:true,
	                onFailure: function () {
	                    alert("An error occurred: " );
	                },
	                onLoaded : function () {
	                   document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	                },
	                onInteractive :function () {
	                   document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	                }
	               // onLoading : function () {
	               //    document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	               // }

	            };

				var oRequest = new Ajax.Updater(divName, url,oOptions);

		       	return true;
	    }
	    		
	    function populateEmpName(serviceNo){

	  var xmlHttp;
	 if(trimAll(serviceNo) != ""){
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

	       var empName  = item.getElementsByTagName("employeeName")[0];
	       var empId = item.getElementsByTagName("employeeId")[0];
	       var deptId = item.getElementsByTagName("departmentId")[0];
	      // document.getElementById("employeeName").value=empName.childNodes[0].nodeValue
	      //var valueOfCombo=empId.childNodes[0].nodeValue
	      //alert("empId.childNodes[0].nodeValue=="+empId.childNodes[0].nodeValue);
	       document.getElementById("employeeId").value=empId.childNodes[0].nodeValue;
	       document.getElementById("DepartmentId").value=deptId.childNodes[0].nodeValue;
	       document.getElementById("employeeName").value=empName.childNodes[0].nodeValue;



	   }
      }
    }

   var url="/hms/hms/user?method=getEmpName&serviceNo="+serviceNo;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    }
}
	    
	    // Populate registration Page on aadhar No Search of Ekyc select
	    
	    function populatePatientOnAadharNo(){
	    	
	    	var aadharNo=document.getElementById("aadhaarNumberId").value;  

	  	  var xmlHttp;
	  	 if(trimAll(aadharNo) != ""){
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

	  	       var name  = item.getElementsByTagName("name")[0];
	  	       var aadhar = item.getElementsByTagName("aadhar")[0];
	  	       var gender = item.getElementsByTagName("gender")[0];
	  	       var dob = item.getElementsByTagName("dob")[0];
	  	       var yob = item.getElementsByTagName("yob")[0];
	  	     var mobNo = item.getElementsByTagName("mob")[0];
	  	   var ocupation = item.getElementsByTagName("occupation")[0];
	  	 var nativity = item.getElementsByTagName("nativity")[0];
	  	     
	  	 
	  	      document.getElementById("pEAadhaarNumberId").value=aadhar.childNodes[0].nodeValue;
	  	      document.getElementById("pNameId").value=name.childNodes[0].nodeValue;
	  	     document.getElementById("gender").value=gender.childNodes[0].nodeValue;
	  	     document.getElementById("dobId").value=dob.childNodes[0].nodeValue;
	  	     document.getElementById("yobId").value=yob.childNodes[0].nodeValue;
	  	     document.getElementById("mobileNoId").value=mobNo.childNodes[0].nodeValue;
	  	   document.getElementById("occupationId").value=ocupation.childNodes[0].nodeValue;
	  	   if(nativity.childNodes[0].nodeValue=='Native'){
	  		 alert("Hi"+nativity.childNodes[0].nodeValue)
	  		 document.getElementById('residentId').checked=true;
	  		 /*document.getElementById('NativeIDD').checked=true;*/
	  	   }
	  	       



	  	   }
	        }
	      }
	     var url="/hms/hms/registration?method=populatePatientOnAadharNo&aadharNo="+aadharNo;
 	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	      xmlHttp.open("GET",url,true);
	      xmlHttp.setRequestHeader("Content-Type", "text/xml");
	      xmlHttp.send(null);
	      }
	  }	    
	    
	    
	    
	function submitProtoAjaxforATSODate(formName,action)
	    {

		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action+"&"+getNameAndData(formName);
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	        	new Ajax.Updater('atsoDateDiv',url,
				   {asynchronous:true, evalScripts:true });
		       	return true;
	    }

	// submitProtoAjaxWithDivName added By Priyanka on 2 April 08
	function submitProtoAjaxWithDivName(formName,action,divName){
		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
		//alert("action"+action);
	    	   	 var url=action+"&"+getNameAndData(formName);
	    	   	 
	    	   	 
	    	   	 if(url.indexOf(csrfTokenName)<0)
	    	   		 	url = url + '&' +csrfTokenName + '=' + csrfTokenValue; // added by amit das on 17-06-2016
	    
	    	   	//alert("url"+url);
	    	   	 new Ajax.Updater(divName,url,
				   {asynchronous:true, evalScripts:true });
		       	return true;
	    }
	function dsubmitProtoAjaxWithDivName(formName,action,divName){
		//alert(action)
		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
		//alert("action"+action);
	    	   	 var url=action+"&"+getNameAndData(formName);
	    	   	 
	    	   	 
	    	   	 if(url.indexOf(csrfTokenName)<0)
	    	   		 	url = url + '&' +csrfTokenName + '=' + csrfTokenValue; // added by amit das on 17-06-2016
	    
	    	   	//alert("url"+url);
	    	   	 new Ajax.Updater(divName,url,
				   {asynchronous:false, evalScripts:true });
		       	return true;
	    }

	  function submitProtoAjaxWithDivNameForBilling(formName,action,divName){
		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action;
	    	   	 url = url + '&' +csrfTokenName + '=' + csrfTokenValue; // added by amit das on 17-06-2016
	        	new Ajax.Updater(divName,url,
				   {asynchronous:true, evalScripts:true });
		       	return true;
	    }

	 function submitProtoAjaxForEDReturns(formName,action,divName){

	 	var fromDateForm=document.getElementById("fromDateId").value;
		var toDateForm=document.getElementById("toDateId").value;
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
		else{

	 	var fromDate=document.getElementById("fromDateId").value;
	 	var toDate=document.getElementById("toDateId").value;
	 	var category=document.getElementById("categoryId").value;


	 	errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action+"&fromDate="+fromDate+"&toDate="+toDate+"&category="+category;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	        	 new Ajax.Updater(divName,url,{asynchronous:true, evalScripts:true });
	     }
		       	return true;
	   }

	function submitPeriodical(formName,action,extraFunction,extraFunction2,extraFunction3){

		errorMsg = "";
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
	        	obj.action = action;
	        	 var url=action+"&"+getNameAndData(formName);
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	        	    	alert(url)
	        	    new Ajax.PeriodicalUpdater('statusMessage',url,
					  {
					    method: 'get',
					    insertion: Insertion.Top,
					    asynchronous:true,
					    evalScripts:true,
					    frequency: 1,
					    decay: 1
					  });


			}else{
				if(errorMsg != ""){
					alert(errorMsg);
		       		return false;
		       	}
		       	return true;
	    	}
	}
function getNameAndData(formName) {
   var str="";
   inputs = eval('document.'+formName+'.elements');
    for(i=0;i<inputs.length;i++){
   	str=str+inputs[i].name+"="+inputs[i].value+"&"
   }
   return str;
}


function calculateAge(){
		dob=document.getElementById('dobId').value;
		if(checkDob()){
		action="/hms/hms/registration?method=calculateAge";
		obj = eval('document.registration')

		       obj.action = action;
	    	   	 var url=action+"&dateOfBirth="+dob;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	        	new Ajax.Updater('ageDiv',url,
				   {asynchronous:true, evalScripts:true });
     			   	return true;
		       	}
}

function checkDob(){
    if(document.getElementById('dobId')!=null){
	var dob = document.getElementById('dobId').value;
    }
    if(document.getElementById('qDobId')!=null){
    	var dob = document.getElementById('qDobId').value;
        }
	dateOfBirth = new Date(dob.substring(6),(dob.substring(3,5) - 1) ,dob.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);

	if(dateOfBirth > currentDate)
 	{
 		alert("Date of Birth is not valid."); 	
 	    if(document.getElementById('dobId')!=null){
 	    	document.getElementById('dobId').value = "";
 	     }
 	    if(document.getElementById('qDobId')!=null){	
 	        document.getElementById('qDobId').value = "";
 	    }
 		document.getElementById('idForAge').value = "";
 		document.getElementById('idForAge').style.display = 'none';
		document.getElementById('tempId1').style.display = 'block';
		document.getElementById('tempId2').style.display = 'block';
		return false;
 	}
	 return true;

}
function checkAdmissionDate(){
	var dob = document.getElementById('admissionDate').value;
	adDate= new Date(dob.substring(6),(dob.substring(3,5) - 1) ,dob.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);

	if(adDate < currentDate)
 	{
 		alert("Admission Date is not valid.");
 		document.getElementById('admissionDate').value = "";
		return false;
 	}
	 return true;

}
function checkReviewDate(){
	var dob = document.getElementById('reviewDate').value;
	adDate= new Date(dob.substring(6),(dob.substring(3,5) - 1) ,dob.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);

	if(adDate < currentDate)
 	{
 		alert("ReviewDate Date is not valid.");
 		document.getElementById('reviewDate').value = "";
		return false;
 	}
	 return true;

}
function checkDonorDob(){

	var dob = document.getElementById('BirthDateId').value;
	dateOfBirth = new Date(dob.substring(6),(dob.substring(3,5) - 1) ,dob.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);

	if(dateOfBirth > currentDate)
 	{
 		alert("Date of Birth is not valid.");
 		document.getElementById('dobId').value = "";
 		document.getElementById('idForAge').value = "";
 		document.getElementById('idForAge').style.display = 'none';
		document.getElementById('tempId1').style.display = 'block';
		document.getElementById('tempId2').style.display = 'block';
		return false;
 	}
	 return true;

}

function getHinNo(formName,action){
	var serviceNoObj = eval('document.'+formName+'.serviceNo')
	var servNo = serviceNoObj.value;
		errorMsg ="";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		if(servNo != ""){
			obj = eval('document.'+formName)
			       	obj.action = action;
		    	   	 var url=action+"&"+getNameAndData(formName);
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

		        	new Ajax.Updater('hinDiv',url,
					   {asynchronous:true, evalScripts:true });
		}
		return true;
}

function checkPatientRegistration(){
	var serviceType = document.getElementById('serviceTypeId').value;
	if(serviceType != "8"){
		var serviceNo = document.getElementById('serviceNoId').value;
		var relation = document.getElementById('relationId').value;
		var serviceStatus = document.getElementById('serviceStatusId').value;
		//var pName = document.getElementById('pFirstNameId').value;
		var pName = document.getElementById('sFNameId').value;

		action="/hms/hms/registration?method=checkPatientRegistration";
		obj = eval('document.registration')

		       obj.action = action;
	    	   	 var url=action+"&serviceNo="+serviceNo+"&serviceTypeId="+serviceType+"&relationId="+relation+"&serviceStatus="+serviceStatus+"&patientName="+pName;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	        	new Ajax.Updater('statusMessage',url,
				   {asynchronous:true, evalScripts:true });
				   return true;
			}
			return true;
}

function getDiagnosisForReport(formName,action){

		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action+"&"+getNameAndData(formName);
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	        	new Ajax.Updater('diagnosisDiv',url,{asynchronous:true, evalScripts:true });
		       	return true;
}


function show111(){

	alert("www")
}

function submitProtoAjaxDynamic(formName,action,divName){
		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		obj.action = action;
	    var url=action+"&"+getNameAndData(formName);
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
       	new Ajax.Updater(divName,url,{asynchronous:true, evalScripts:true });
       	return true;
	    }

//================Ajax multiple ids updating=================


  function ajaxFunctionForAutoCompleteIndentToDepot(formName,action,rowVal) {
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
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];

	        var oldPvms  = item.getElementsByTagName("oldPvms")[0];
	        var stock  = item.getElementsByTagName("stock")[0];
	        var qtyInMMF  = item.getElementsByTagName("qtyInMMF")[0];
	        var section  = item.getElementsByTagName("section")[0];

        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
        	if(oldPvms.childNodes[0].nodeValue != 0)
        	document.getElementById('oldNiv'+rowVal).value = oldPvms.childNodes[0].nodeValue

        	document.getElementById('qtyInHand'+rowVal).value = stock.childNodes[0].nodeValue
        	document.getElementById('qtyInHandTemp'+rowVal).value = stock.childNodes[0].nodeValue
        	document.getElementById('mmfVarTemp'+rowVal).value = qtyInMMF.childNodes[0].nodeValue
        	document.getElementById('mmfVar'+rowVal).value = qtyInMMF.childNodes[0].nodeValue
        	document.getElementById('section'+rowVal).value = section.childNodes[0].nodeValue
      	}
      }
    }
    var url=action+"&"+getNameAndData(formName)

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }

  function ajaxFunctionForAutoCompleteMMF(formName,action,rowVal) {
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
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];

        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
        	document.getElementById('issuedName'+rowVal).value = name.childNodes[0].nodeValue
      	}
      }
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }



  function submitProtoAjaxForBarcodeData(formName,action,rowVal) {
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
      	if(items.childNodes.length!=0){
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];
	       var batchNo=item.getElementsByTagName("batchNo")[0];
	       var barcodeNo=item.getElementsByTagName("barCodeNo")[0];
	       var availableStock=item.getElementsByTagName("availableStock")[0];
	       var expiryDate=item.getElementsByTagName("expiryDate")[0];
        	if(document.getElementById("codeItem"+rowVal).value!=""){

        	if(pvms.childNodes[0].nodeValue==document.getElementById('codeItem'+rowVal).value){
        	document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
        	document.getElementById("availableStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;

        	document.getElementById("qtyIssued"+rowVal).readOnly=false;
        	document.getElementById("qtyIssued"+rowVal).focus();
        	}
        	else{
        	alert("The Barcode you entered is not For this item..");
        	document.getElementById("barCodeNo"+rowVal).value="";
        	}
        	}
        	else{
        	document.getElementById("codeItem"+rowVal).value=pvms.childNodes[0].nodeValue;
        	document.getElementById("batchNo"+rowVal).value=batchNo.childNodes[0].nodeValue;
        	document.getElementById("au"+rowVal).value=au.childNodes[0].nodeValue;
        	document.getElementById("nameItem"+rowVal).value=name.childNodes[0].nodeValue;
        	document.getElementById("availableStock"+rowVal).value=availableStock.childNodes[0].nodeValue;
        	document.getElementById("expiryDate"+rowVal).value=expiryDate.childNodes[0].nodeValue;
        	}

      	}
      	}
      	else{
      	alert("There are No items for this Barcode ");
      document.getElementById("barCodeNo"+rowVal).value="";
      	}
      }
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }
 function submitProtoAjaxForAddBarcodeData(formName,action,rowVal) {
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
      	if(items.childNodes.length!=0){
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var information = items.childNodes[loop];
	        var message  = information.getElementsByTagName("message")[0];
	        alert(message.childNodes[0].nodeValue)
	        }
	        }

 	}
 }

 var url=action+"&"+getNameAndData(formName);
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
 }
  //================Ajax multiple ids updating=================
function ajaxFunctionForAutoCompleteInSOC(formName,action,rowVal) {
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
      	var brandId="brandId"+rowVal;
		obj =document.getElementById(brandId);
		obj.length = 1;
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];
	         var stockIn  = item.getElementsByTagName("stockIn")[0];
	        var brandLength  = item.getElementsByTagName("brands")[0];

        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
        	document.getElementById('qtyInHand'+rowVal).value = stockIn.childNodes[0].nodeValue
        	document.getElementById('qtyInHandTemp'+rowVal).value = stockIn.childNodes[0].nodeValue

        	for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
        		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("brandId")[0];
	        	var brandName  = brand.getElementsByTagName("brandName")[0];
	        	obj.length++;
				obj.options[obj.length-1].value=brandId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=brandName.childNodes[0].nodeValue;

        	}
      	}
      }
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }

  function ajaxFunctionForcheckForSocNe(formName,action,rowVal) {
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
	        var id  = item.getElementsByTagName("id")[0];
	       if(id.childNodes[0].nodeValue ==0)
	       {
	       		alert("Wrong entry in Nomenclature of Item...! ")
	       		document.getElementById("itemName").value="";
	       }else{
	       }
      	}
      }
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }

 //=========================Start ofFunctions for MMF Indent=================
 function importingMmfIndent(formName,action){

 var year=document.getElementById('mmfForTheYear').value;

 new Ajax.Request(action+'&mmfForTheYear='+year+'&'+csrfTokenName+'='+csrfTokenValue,
  {
    method:'get',
    onSuccess: function(transport){
      var response = transport.responseText || "no response text";
      document.getElementById('testDiv').innerHTML =response;
    },
    onFailure: function(){ alert('Something went wrong...') },
    onLoading: function(){ }
    });


 }
 //=========================End ofFunctions for MMF Indent=================

 //-----------------------------------------------------------------------------------------------------------------
 //------------------------------------Start of Functions Written By Vivek------------------------------------------
 //-----------------------------------------------------------------------------------------------------------------
 function getManufacturerNameInAjax(brandId,rowVal){


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
	        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
	        var mId  = item.getElementsByTagName("mId")[0];
        	document.getElementById('manuId'+rowVal).value = manufacturerName.childNodes[0].nodeValue
        	document.getElementById('manuIdTemp'+rowVal).value = mId.childNodes[0].nodeValue

      	}
      }
    }
     url="stores?method=getManufacturerNameInAjax&brandId="+brandId;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

 }
  function ajaxFunctionForVendorReturn(formName,action,rowVal) {
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
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var brandId  = item.getElementsByTagName("brandId")[0];

	        var name  = item.getElementsByTagName("name")[0];
        	document.getElementById('pvmsNo'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('nomenclature'+rowVal).value = name.childNodes[0].nodeValue
        	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue

        	var url="/hms/hms/stores?method=showStockDetailsForVendorReturn&brandId="+brandId.childNodes[0].nodeValue+"&rowVal="+rowVal;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
        	 popwindow(url);
      	}
      }
    }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }


 //-----------------------------------------------------------------------------------------------------------------
 //-------------------------------------End of Functions Written By Vivek-------------------------------------------
 //-----------------------------------------------------------------------------------------------------------------


 //-----------------------------------Start of Function written By Vikas------------------------------------------
  function ajaxFunctionForAutoCompletePatientIssue(formName,action,rowVal) {
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
		        var pvmsNo  = item.getElementsByTagName("pvms")[0];
		        var nomenclature  = item.getElementsByTagName("au")[0];
		        var itemId  = item.getElementsByTagName("id")[0];
	        	document.getElementById('pvmsNo'+rowVal).value = pvmsNo.childNodes[0].nodeValue
	        	document.getElementById('nomenclature'+rowVal).value = nomenclature.childNodes[0].nodeValue
	        	document.getElementById('itemId'+rowVal).value = itemId.childNodes[0].nodeValue
	      	}
	      	openPopupForPatientIssue(rowVal);
	      }
	    }
	    var url=action+"&"+getNameAndData(formName);
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }
	  function openPopupForPatientIssue(rowVal){
		 itemId=document.getElementById('itemId'+rowVal).value

			if(itemId !=""){
			var url="/hms/hms/ipd?method=showPatientIssueStockDetailsJsp&itemId="+itemId+"&rowVal="+rowVal;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	        newwindow=window.open(url,'name',"height=500,width=950,status=1");
	        }
	     }
  function ajaxFunctionForAutoCompleteOPDPatient(formName,action,rowVal) {
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

	        var pvmsNo  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var itemId  = item.getElementsByTagName("id")[0];
        	document.getElementById('pvmsNo'+rowVal).value = pvmsNo.childNodes[0].nodeValue
        	document.getElementById('itemId'+rowVal).value = itemId.childNodes[0].nodeValue
        	document.getElementById('nomenclature'+rowVal).value = au.childNodes[0].nodeValue
      	}
      }
    }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }

   function ajaxFunctionForAutoCompleteLotNO(formName,action,rowVal) {
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

	        var pvmsNo  = item.getElementsByTagName("pvms")[0];
	        var nomenclature  = item.getElementsByTagName("nomenclature")[0];
	        var itemId  = item.getElementsByTagName("itemId")[0];



        	document.getElementById('pvmsNo'+rowVal).value = pvmsNo.childNodes[0].nodeValue
        	document.getElementById('itemId'+rowVal).value = itemId.childNodes[0].nodeValue
        	document.getElementById('nomenclature'+rowVal).value = nomenclature.childNodes[0].nodeValue



      	}
      }
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }

   function ajaxFunctionForAutoCompleteWardConsumption(formName,action,rowVal) {
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
	        var uom  = item.getElementsByTagName("uom")[0];
	        var itemId  = item.getElementsByTagName("itemId")[0];
        	document.getElementById('uom'+rowVal).value = uom.childNodes[0].nodeValue
        	document.getElementById('itemId'+rowVal).value = itemId.childNodes[0].nodeValue
      	}
      	openPopupForWardConsumption(rowVal);
      }
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }
  function openPopupForWardConsumption(rowVal){
	 itemId=document.getElementById('itemId'+rowVal).value

		if(itemId !=""){
		var url="/hms/hms/ipd?method=showWardConsumptionIssueStockDetailsJsp&itemId="+itemId+"&rowVal="+rowVal;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
        newwindow=window.open(url,'name',"height=500,width=800,status=1");
        }
     }
  //-----------------------------------End of Function written By Vikas------------------------------------------


  // function by abha
  function submitProtoAjaxforIndent(formName,action){
			errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action+"&"+getNameAndData(formName);
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	        	new Ajax.Updater('indentDiv',url,
				   {asynchronous:true, evalScripts:true });
		       	return true;
	    	}

	    		function submitProtoAjaxforGrid(formName,action){
			errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action+"&"+getNameAndData(formName);
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	        	new Ajax.Updater('gridDiv',url,
				   {asynchronous:true, evalScripts:true });
		       	return true;
	    	}

	   function submitProtoAjaxforSupplier(formName,action){
		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action+"&"+getNameAndData(formName);
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	        	new Ajax.Updater('suppDiv',url,
				   {asynchronous:true, evalScripts:true });
		       	return true;
	    	}



 function ajaxFunctionForAutoCompleteInGrn(formName,action,rowVal) {

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

      	var items = xmlHttp.responseXML.getElementsByTagName('items')[0];

     /*
      var brandId="brandId"+rowVal;
		obj = document.getElementById(brandId);
		obj.length = 1;
    */
		var manufacturerId ="manufacturerId"+rowVal;
		obj1 = document.getElementById(manufacturerId);
		obj1.length = 1;

		var dispenseType ="dispenseType"+rowVal;
		obj2 = document.getElementById(dispenseType);

      	for (loop = 0; loop < items.childNodes.length; loop++)
      	{
      	 	var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];

	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var formula  = item.getElementsByTagName("formula")[0];
	        var conversionFactor  = item.getElementsByTagName("conversionFactor")[0];
	        var name  = item.getElementsByTagName("name")[0];
	      //  var brandLength  = item.getElementsByTagName("brands")[0];
	       // var brandLength  = item.getElementsByTagName("brands")[0];
	       //added by shailesh

	        //var manufacturerLength = item.getElementsByTagName("manufacturers")[0];
	      	var manufacturers = xmlHttp.responseXML.getElementsByTagName('manufacturers')[0];

	        var poRate  = item.getElementsByTagName("poRate")[0];
	        var poTax = item.getElementsByTagName("poTax")[0];
	        var poDiscount = item.getElementsByTagName("poDiscount")[0];
	        var poDispType = item.getElementsByTagName("poDispType")[0];
	        var poMdqValue = item.getElementsByTagName("poMdqValue")[0];
	        var poRatePerMdq = item.getElementsByTagName("poRatePerMdq")[0];
	       // var poBrandId = item.getElementsByTagName("poBrandId")[0];
	       // var poManufacturerId = item.getElementsByTagName("poManufacturerId")[0];
	        var poFreeQty = item.getElementsByTagName("poFreeQty")[0];
	        var poFreeItem = item.getElementsByTagName("poFreeItem")[0];
	        var expiry = item.getElementsByTagName("expiry")[0];


        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
        	document.getElementById('freeQty'+rowVal).value = poFreeQty.childNodes[0].nodeValue
//        	document.getElementById('expiry'+rowVal).value = expiry.childNodes[0].nodeValue
        	document.getElementById('formula'+rowVal).value = formula.childNodes[0].nodeValue
        	document.getElementById('conversionFactor'+rowVal).value = conversionFactor.childNodes[0].nodeValue


        	obj2.length=1;
			obj2.options[obj2.length-1].value = poDispType.childNodes[0].nodeValue;
			obj2.options[obj2.length-1].text  = poDispType.childNodes[0].nodeValue;



        /*	for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++)
        	{
        		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("brandId")[0];
	        	var brandName  = brand.getElementsByTagName("brandName")[0];
	        	var manufacturerId = brand.getElementsByTagName("manufacturerId")[0];
	        	var manufacturerName  = brand.getElementsByTagName("manufacturerName")[0];

	        	obj.length++;
				obj.options[obj.length-1].value=brandId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=brandName.childNodes[0].nodeValue;


				obj1.length++;
				obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;

        	}*/
        	for(innerLoop = 0;innerLoop < manufacturers.childNodes.length;innerLoop++)
        	{
        		var manufacturer = manufacturers.childNodes[innerLoop];
	        	var manufacturerId  = manufacturer.getElementsByTagName("manufacturerId")[0];
	        	var manufacturerName  = manufacturer.getElementsByTagName("manufacturerName")[0];
 	        	obj1.length++;
				obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
         	}
        	document.getElementById('discountVar'+rowVal).value =poDiscount.childNodes[0].nodeValue
        	document.getElementById('taxVar'+rowVal).value =poTax.childNodes[0].nodeValue
        	document.getElementById('mdq'+rowVal).value =poMdqValue.childNodes[0].nodeValue
        	document.getElementById('ratePerMdq'+rowVal).value =poRatePerMdq.childNodes[0].nodeValue
       /* 	var brandCombo = document.getElementById('brandId'+rowVal);

        	for(var i=0;i<brandCombo.length;i++)
        	{
        		if (brandCombo[i].value == poBrandId.childNodes[0].nodeValue)
        			brandCombo.selectedIndex = i;
        	}


        	var manufacturerCombo = document.getElementById('manufacturerId'+rowVal);

        	for(var i=0;i<manufacturerCombo.length;i++)
        	{
        		if (manufacturerCombo[i].value == poManufacturerId.childNodes[0].nodeValue)
        			manufacturerCombo.selectedIndex = i;
        	}
       	*/
        	var freeItemCombo = document.getElementById('freeItem'+rowVal);

        	for(var i=0;i<freeItemCombo.length;i++)
        	{
        		if (freeItemCombo[i].value == poFreeItem.childNodes[0].nodeValue)
        			freeItemCombo.selectedIndex = i;
        	}

      	}
      }
    }
   	 var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }
//=====================AT BANGALORE===================
function ajaxFunctionForAutoCompleteInGrnGeneral(formName,action,rowVal) {

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

      	var items = xmlHttp.responseXML.getElementsByTagName('items')[0];

      /*	var brandId="brandId"+rowVal;
		obj = document.getElementById(brandId);
		obj.length = 1;
*/
		var manufacturerId ="manufacturerId"+rowVal;
		obj1 = document.getElementById(manufacturerId);
		obj1.length = 1;

		var dispenseType ="dispenseType"+rowVal;
		obj2 = document.getElementById(dispenseType);
		obj2.length=1;
      	for (loop = 0; loop < items.childNodes.length; loop++)
      	{
      	 	var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var dispType = item.getElementsByTagName("dispType")[0];

	        var formula = item.getElementsByTagName("formula")[0];
	        var conversionFactor = item.getElementsByTagName("conversionFactor")[0];
	        var name  = item.getElementsByTagName("name")[0];
	     //   var brandLength  = item.getElementsByTagName("brands")[0];
	        var expiry = item.getElementsByTagName("expiry")[0];
	          //added by shailesh
  	      	var manufacturers = item.getElementsByTagName("manufacturers")[0];
	       var storeDept = item.getElementsByTagName("storeDept")[0];
	       var lotNo = item.getElementsByTagName("lotNo")[0];
	     //Code added By Mukesh 15 Dec 2010
	       var ratePerMdq = item.getElementsByTagName("ratePerMdq")[0];
	       document.getElementById('ratePerMdq'+rowVal).value = ratePerMdq.childNodes[0].nodeValue
        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
        	document.getElementById('expiry'+rowVal).value = expiry.childNodes[0].nodeValue
        	//alert("expiry in proto---->"+document.getElementById('expiry'+rowVal).value);
	       	document.getElementById('formula'+rowVal).value = formula.childNodes[0].nodeValue
        	document.getElementById('conversionFactor'+rowVal).value = conversionFactor.childNodes[0].nodeValue
        	//Code added By Mukesh 15 Dec 2010
			obj2.options[obj2.length-1].value = dispType.childNodes[0].nodeValue;
			obj2.options[obj2.length-1].text  = dispType.childNodes[0].nodeValue;
			
			//added by shailesh
        	for(innerLoop = 0;innerLoop < manufacturers.childNodes.length;innerLoop++)
        	{
        		var manufacturer      = manufacturers.childNodes[innerLoop];
	        	var manufacturerId    = manufacturer.getElementsByTagName("manufacturerId")[0];
	        	var manufacturerName  = manufacturer.getElementsByTagName("manufacturerName")[0];
 	        	obj1.length++;
				obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;

        	}

        	document.getElementById('storeDept'+rowVal).value =  storeDept.childNodes[0].nodeValue;
        	if(storeDept.childNodes[0].nodeValue == "25"){
        		document.getElementById('batchNo'+rowVal).value = lotNo.childNodes[0].nodeValue;
        		document.getElementById('batchNo'+rowVal).readOnly = true;
        	}

        	/*for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++)
        	{
        		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("brandId")[0];
	        	var brandName  = brand.getElementsByTagName("brandName")[0];
	        	var manufacturerId = brand.getElementsByTagName("manufacturerId")[0];
	        	var manufacturerName  = brand.getElementsByTagName("manufacturerName")[0];

	        	obj.length++;
				obj.options[obj.length-1].value=brandId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=brandName.childNodes[0].nodeValue;


				obj1.length++;
				obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;

        	}*/
        	
      	}
      }
    }
   	 var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }


  //---- For Loan In---------------------
  function ajaxFunctionForAutoCompleteInLoanIn(formName,action,rowVal) {

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

      /*	var brandId="brandId"+rowVal;
		obj =document.getElementById(brandId);
		obj.length = 1;

		var manufacturerId ="manufacturerId"+rowVal;
		obj1 =document.getElementById(manufacturerId);
		obj1.length = 1;
		*/
		var dispenseType ="dispenseType"+rowVal;
		alert(dispenseType)
		obj2 = document.getElementById(dispenseType);


      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];
	        var expiry  = item.getElementsByTagName("expiry")[0];
	     //   var brandLength  = item.getElementsByTagName("brands")[0];
	        var poRate  = item.getElementsByTagName("poRate")[0];
	        var poTax = item.getElementsByTagName("poTax")[0];
	        var poDiscount = item.getElementsByTagName("poDiscount")[0];
	        var poDispType = item.getElementsByTagName("poDispType")[0];
	        var poMdqValue = item.getElementsByTagName("poMdqValue")[0];
	        var poRatePerMdq = item.getElementsByTagName("poRatePerMdq")[0];
	       // var poBrandId = item.getElementsByTagName("poBrandId")[0];
	       // var poManufacturerId = item.getElementsByTagName("poManufacturerId")[0];
	        var poFreeQty = item.getElementsByTagName("poFreeQty")[0];
	        var poFreeItem = item.getElementsByTagName("poFreeItem")[0];
	        var formula  = item.getElementsByTagName("formula")[0];
     		var conversionFactor  = item.getElementsByTagName("conversionFactor")[0];



        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
        	document.getElementById('freeQty'+rowVal).value = poFreeQty.childNodes[0].nodeValue
        	document.getElementById('expiry'+rowVal).value = expiry.childNodes[0].nodeValue
        	document.getElementById('formula'+rowVal).value = formula.childNodes[0].nodeValue
			document.getElementById('conversionFactor'+rowVal).value = conversionFactor.childNodes[0].nodeValue

        	obj2.length=1;
			obj2.options[obj2.length-1].value = poDispType.childNodes[0].nodeValue;
			obj2.options[obj2.length-1].text  = poDispType.childNodes[0].nodeValue;

        	/*for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++)
        	{
        		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("brandId")[0];
	        	var brandName  = brand.getElementsByTagName("brandName")[0];
	        	var manufacturerId  = brand.getElementsByTagName("manufacturerId")[0];
	        	var manufacturerName = brand.getElementsByTagName("manufacturerName")[0];

	        	obj.length++;
				obj.options[obj.length-1].value=brandId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=brandName.childNodes[0].nodeValue;

				obj1.length++;
				obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
        	}
        	*/
        	//added by shailesh
        	for(innerLoop = 0;innerLoop < manufacturerLength.childNodes.length;innerLoop++){
        	var manufacturer = manufacturerLength.childNodes[innerLoop];
	        	var manufacturerId  = manufacturer.getElementsByTagName("manufacturerId")[0];
	        	var manufacturerName  = manufacturer.getElementsByTagName("manufacturerName")[0];


	        	obj1.length++;
				obj1.options[obj1.length-1].value=manufacturerId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=manufacturerName.childNodes[0].nodeValue;
				}
        	document.getElementById('discountVar'+rowVal).value =poDiscount.childNodes[0].nodeValue
        	document.getElementById('taxVar'+rowVal).value =poTax.childNodes[0].nodeValue
        	document.getElementById('mdq'+rowVal).value =poMdqValue.childNodes[0].nodeValue
        	document.getElementById('ratePerMdq'+rowVal).value =poRatePerMdq.childNodes[0].nodeValue


        	/*var brandCombo = document.getElementById('brandId'+rowVal);

        	for(var i=0;i<brandCombo.length;i++)
        	{
        		if (brandCombo[i].value == poBrandId.childNodes[0].nodeValue)
        			brandCombo.selectedIndex = i;
        	}


        	var manufacturerCombo = document.getElementById('manufacturerId'+rowVal);

        	for(var i=0;i<manufacturerCombo.length;i++)
        	{
        		if (manufacturerCombo[i].value == poManufacturerId.childNodes[0].nodeValue)
        			manufacturerCombo.selectedIndex = i;
        	}
        	*/
        	var freeItemCombo = document.getElementById('freeItem'+rowVal);

        	for(var i=0;i<freeItemCombo.length;i++)
        	{
        		if (freeItemCombo[i].value == poFreeItem.childNodes[0].nodeValue)
        			freeItemCombo.selectedIndex = i;
        	}


      	}
      }
    }
   	 var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }


 // defect Drugs
 function ajaxFunctionForAutoCompleteInDefectiveDrugs(formName,action,rowVal) {

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

      //	var brandId="brandId"+rowVal;
      	var batchId="batchId"+rowVal;
	//	obj1 =document.getElementById(brandId);
		obj = document.getElementById(batchId);
		obj.length = 1;
		//obj1.length =1;

      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];
	       // var manufacturerName=item.getElementsByTagName("manufacturerName")[0];
	        //var manufacturerId=item.getElementsByTagName("manufacturerId")[0];
	      //  var brandLength  = item.getElementsByTagName("brands")[0];
	         var batchLength  = item.getElementsByTagName("batchs")[0];
	         if(pvms.childNodes[0] != undefined){
        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
	         }
	         if(pvms.childNodes[0] != undefined){
	        	 document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
	         }
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
        	
        	/* if(manufacturerId.childNodes[0] != undefined){
        		 document.getElementById('manufacturerId'+rowVal).options[0].value=manufacturerId.childNodes[0].nodeValue
    	       }
        	if(manufacturerName.childNodes[0] != undefined){
        		document.getElementById('manufacturerId'+rowVal).options[0].text=manufacturerName.childNodes[0].nodeValue
   	       }*/
        	//document.getElementById('quanRec'+rowVal).value=0;
        	//document.getElementById('quanRecTemp'+rowVal).value=0;


        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
        	{
        		var batch = batchLength.childNodes[innerLoop];
	        	var batchId  = batch.getElementsByTagName("batchId")[0];
	        	var batchName  = batch.getElementsByTagName("batchName")[0];
	        	obj.length++;
				obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;

        	}

        	/* for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
        		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("brandId")[0];
	        	var brandName  = brand.getElementsByTagName("brandName")[0];

	        	obj1.length++;
				obj1.options[obj1.length-1].value=brandId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=brandName.childNodes[0].nodeValue;

        	}*/

      	}
      }
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }
  //ajax function for vendor return
  function ajaxFunctionForAutoCompleteInVendorReturn(formName,action,rowVal) {

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

      //	var brandId="brandId"+rowVal;
      	var batchId="batchId"+rowVal;
	//	obj1 =document.getElementById(brandId);
		obj = document.getElementById(batchId);
		obj.length = 1;
		//obj1.length =1;

      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];
	      //var manufacturerName=item.getElementsByTagName("manufacturerName")[0];
	       // var manufacturerId=item.getElementsByTagName("manufacturerId")[0];
	      //  var brandLength  = item.getElementsByTagName("brands")[0];
	         var batchLength  = item.getElementsByTagName("batchs")[0];

        	document.getElementById('pvmsNo'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue
        	//document.getElementById('manufacturerId'+rowVal).options[0].value=manufacturerId.childNodes[0].nodeValue

     		//document.getElementById('manufacturerId'+rowVal).options[0].text=manufacturerName.childNodes[0].nodeValue
        	//document.getElementById('quanRec'+rowVal).value=0;
        	//document.getElementById('quanRecTemp'+rowVal).value=0;
        		obj.options[0].value=0;
				obj.options[0].text="Select Batch No.";

        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
        	{
        		var batch = batchLength.childNodes[innerLoop];
	        	var batchId  = batch.getElementsByTagName("batchId")[0];
	        	var batchName  = batch.getElementsByTagName("batchName")[0];
	        	obj.length++;
				obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;

        	}

        	/* for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
        		var brand = brandLength.childNodes[innerLoop];
	        	var brandId  = brand.getElementsByTagName("brandId")[0];
	        	var brandName  = brand.getElementsByTagName("brandName")[0];

	        	obj1.length++;
				obj1.options[obj1.length-1].value=brandId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=brandName.childNodes[0].nodeValue;

        	}*/

      	}
      }
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }

  ///=========== FOR NON EXPANDABLE
  function ajaxFunctionForAutoCompleteInNeGrn(formName,action,rowVal) {

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
      	//alert("items"+items)
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];

        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue


      	}
      }
    }
       var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }

  // populate Unit List based on Hospital and Department for visit creation 
  
  function populateUnitForDepartment(departmentId,uId,drId,deptId,page) {
	var depatmentId=0;
	var hospitalId=0;
	var selectedUnit=0;
	//  var hospitalId=document.getElementById('hospitalNameId').value;
	  //document.getElementById("unit").options.length = 0;

	  var xmlHttp=null;
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
	  

	 obj = document.getElementById(uId);
	  obj.length=1;
	  
		  obj1 = document.getElementById(drId);
	  obj1.length=1;
	  
	  
		/*obj.options[0].value=0;
		obj.options[0].text="select";*/
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//alert("items"+items)
	      
			
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var unitId  = item.getElementsByTagName("unitId")[0];
		        var unitCode  = item.getElementsByTagName("unitCode")[0];
		        
		        var doctorId  = item.getElementsByTagName("doctorId")[0];
		        var doctorName  = item.getElementsByTagName("doctorName")[0];
		       
		        var deptUnitId = item.getElementsByTagName("deptUnitId")[0];
		        
		        if(unitId !=undefined && unitId.childNodes[0] !=undefined){
		        	obj.length++;
		        	obj.options[obj.length-1].value=unitId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].text=unitCode.childNodes[0].nodeValue;

		        }
		      
		        
		        if(doctorId !=undefined   && doctorId.childNodes[0] !=undefined){
		        
			        obj1.length++;
					obj1.options[obj1.length-1].value=doctorId.childNodes[0].nodeValue;
					obj1.options[obj1.length-1].text=doctorName.childNodes[0].nodeValue;
			    }
			        
		        if(obj.length>0){
					document.getElementById(uId).selectedIndex =1;
					selectedUnit = document.getElementById(uId).value;
					
		        }
		        
		        var lastVisitedDoctorId  = item.getElementsByTagName("lastVisitedDoctorId")[0];
		        var lastVisitedUnitId  = item.getElementsByTagName("lastVisitedUnitId")[0];
		        
		        if(document.getElementById("lastVisitedDrId")){
		        	if(lastVisitedDoctorId !=undefined   && lastVisitedDoctorId.childNodes[0] !=undefined ){
		        		document.getElementById("lastVisitedDrId").value = lastVisitedDoctorId.childNodes[0].nodeValue;
		        	}else 
		        		document.getElementById("lastVisitedDrId").value = "";
		        }
		        if(document.getElementById("lastVisitedUnitId")){
		        	if(lastVisitedUnitId !=undefined   && lastVisitedUnitId.childNodes[0] !=undefined ){
		        		document.getElementById("lastVisitedUnitId").value = lastVisitedUnitId.childNodes[0].nodeValue;
		        		if(unitId !=undefined && unitId.childNodes[0] !=undefined && lastVisitedUnitId.childNodes[0].nodeValue==unitId.childNodes[0].nodeValue){
		        			obj.value= lastVisitedUnitId.childNodes[0].nodeValue;
		        		}

		        	}else{
		        		document.getElementById("lastVisitedUnitId").value ="";
		        		obj.selectedIndex =1;
		        	}
		        }
		        
		       
	      	}
	      	
	      
	      }
	    }
	    var hinId ="";
	    if(page == 'quickVisit')
	    	 hinId = document.getElementById('vhinId').value;
	    else  if(page == 'visit')
	    	hinId = document.getElementById('hinId').value;
	    	
	    
	       var url="/hms/hms/registration?method=populateUnitForDepartment&hospitalId="+hospitalId+"&depatmentId="+departmentId+"&hinId="+hinId;
   	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,false);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	  
	    if(selectedUnit != 0)
	    	populateDoctorForUnit(selectedUnit,page,deptId);
	    else
	    	populateDoctorForDepartment(departmentId);
	  }
  
 

  function populateDoctorForDepartment(depatmentId) {
	 
	  var xmlHttp=null;
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
	  if( document.getElementById("consultingDocId"))
		  document.getElementById("consultingDocId").value="";
	  docobj= document.getElementById("loddrs");
	  docobj.length=1;
	  
		/*obj.options[0].value=0;
		obj.options[0].text="select";*/
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//alert("items"+items)
	      
			
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		       
		        
		        var docotId  = item.getElementsByTagName("docotId")[0];
		        var docotCode  = item.getElementsByTagName("docotCode")[0];
		        
		       
		        if(docotId.childNodes[0] !=undefined){
		        	docobj.length++;
		        	docobj.options[docobj.length-1].value=docotId.childNodes[0].nodeValue;
		        	docobj.options[docobj.length-1].text=docotCode.childNodes[0].nodeValue;
			        }
				//document.getElementById("unit").selectedIndex = unitId.childNodes[0].nodeValue


	      	}
	      }
	    }
	      
	       var url="/hms/hms/registration?method=populateDoctorForDepartment&depatmentId="+depatmentId;
   	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,false);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	  }
  
  
 
 // populate Doctor List based on Unit  Hospital and Department for visit creation  Screen
  
  function populateDoctorForUnit(UnitId,page,deptId) {
	  var departmentId ;
	  departmentId = document.getElementById(deptId).value;
	  /*if(document.getElementById('deptId') && document.getElementById('deptId').value!=0)
		  departmentId = document.getElementById('deptId').value;
	  else if(document.getElementById('othercenterId') && document.getElementById('othercenterId').value!=0)
		  departmentId = document.getElementById('othercenterId').value
		 */ 
		  
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
	 /* headobj = document.getElementById("consultingDocId");
	  headobj.length=1;
	  */
	  if(page=='quickVisit')
		  docobj = document.getElementById("quickloddrs");
	  else
		  docobj = document.getElementById("loddrs");
	  docobj.length=1;
	  
	  document.getElementById("consultingDocId").value="";
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//alert("items"+items)
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		   	    
		        var DoctId  = item.getElementsByTagName("DoctId")[0];
		        var DoctName  = item.getElementsByTagName("DoctName")[0];
		        
		       // var hedDoctId  = item.getElementsByTagName("hedDoctId")[0];
		        var hedDoctName  = item.getElementsByTagName("hedDoctName")[0];
		       
		        docobj.length++;
		        docobj.options[docobj.length-1].value=DoctId.childNodes[0].nodeValue;
		        docobj.options[docobj.length-1].text=DoctName.childNodes[0].nodeValue;
				
				if(hedDoctName!=undefined)
					document.getElementById("consultingDocId").value=hedDoctName.childNodes[0].nodeValue;
				
				if(page=='quickVisit' && hedDoctName!=undefined)
					document.getElementById("quickconsultingDocId").value=hedDoctName.childNodes[0].nodeValue;
				
				if(document.getElementById("lastVisitedDrId") && (page == 'quickVisit' || page == 'visit')){
					console.log(document.getElementById('prevDoctorVisit').checked)
					if(document.getElementById('prevDoctorVisit').checked){
					var doctorIdLastVisit = document.getElementById("lastVisitedDrId").value;
					
					if(doctorIdLastVisit!=undefined && doctorIdLastVisit==DoctId.childNodes[0].nodeValue){
						docobj.value= doctorIdLastVisit;
					}
					}
				}
	      	}
	      }
	    }
	      
	       var url="/hms/hms/registration?method=populateDoctorForUnit&UnitId="+UnitId+"&departmentId="+departmentId;
   	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,false);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	  }
 
  
  function populateUnitForDoctor(doctorId) {
	// alert(doctorId);

	  var xmlHttp=null;
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
	  headobj = document.getElementById("unit");
	  headobj.length=1;
	  
	 
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	//alert("items"+items)
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		   	    
		        var unitId  = item.getElementsByTagName("unitId")[0];
		        var unitCode  = item.getElementsByTagName("unitCode")[0];
		        
		        //alert(unitCode.childNodes[0].nodeValue)
		        headobj.length++;
		        headobj.options[headobj.length-1].value=unitId.childNodes[0].nodeValue;
		        headobj.options[headobj.length-1].text=unitCode.childNodes[0].nodeValue;
		        headobj.options[headobj.length-1].selected=true;
		        
				
	      	}
	      }
	    }
	      
	       var url="/hms/hms/registration?method=populateUnitForDoctor&doctorId="+doctorId;
   	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,false);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	  }
  
  function getSessionForDepartment(deptId){
	  if(deptId!="0"){
		  var xhttp = new XMLHttpRequest();
		   xhttp.onreadystatechange=function() {
			  
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
		    	var data=this.responseText;
		    	var dt=data.toString();
				var result = dt.slice(1, -1);
				var deptData="";
				if(result!=""){
					deptData=result.split(",");
				}
				var select;
				if(document.getElementById('opsession')){
					document.getElementById('opsession').options.length = 0;
					select = document.getElementById('opsession');
				}
				
				for(var index=0;index<deptData.length;index++){
					var departmentData=deptData[index].split(":");
					var opt = document.createElement('option');
					opt.value = departmentData[0].trim();
					opt.innerHTML = departmentData[1].trim();
				    select.appendChild(opt);
					
				}
		    }
		  }; 
		  xhttp.open("GET", "/hms/hms/registration?method=getSessionForDepartment&deptId="+deptId,true);
		  xhttp.send();
	  }
	  
  }
  
  function ajaxFunctionForAutoCompleteInNeLoanIn(formName,action,rowVal) {

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
      	//alert("items"+items)
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];

        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue


      	}
      }
    }
       var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }


   function ajaxFunctionForAutoCompleteInWorkOrder(formName,action,rowVal) {
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
      		var batchId="batchId"+rowVal;

      		obj = document.getElementById(batchId);
		obj.length = 1;

      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var au  = item.getElementsByTagName("au")[0];
	        var name  = item.getElementsByTagName("name")[0];
	         var batchLength  = item.getElementsByTagName("batchs")[0];

        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
        	document.getElementById('idAu'+rowVal).value = au.childNodes[0].nodeValue

        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
        	{
        		var batch = batchLength.childNodes[innerLoop];
	        	var batchId  = batch.getElementsByTagName("batchId")[0];
	        	var batchName  = batch.getElementsByTagName("batchName")[0];
	        	obj.length++;
				obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;

        	}

      	}
      }
    }
       var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }
 function checkDateForIssueCiv(){
		var demandDate=document.getElementById("requestDate").value;
		var issueDate=document.getElementById("issueDate").value;
		var fromDate=new Date(demandDate.substring(6),(demandDate.substring(3,5) - 1) ,demandDate.substring(0,2));


		var toDate=new Date(issueDate.substring(6),(issueDate.substring(3,5) - 1) ,issueDate.substring(0,2));

		var currentDate=new Date();
		if((fromDate>currentDate) )
		{
			alert("Demand Date cant be greater than current date!!");
			return false;
		}
		if(fromDate>toDate){
		alert("Demand Date cant be greater than date of issue!!");
			return false;
		}
		if((toDate>currentDate))
		{
			alert("Issue Date cant be greater than current date !!");
			return false;
		}
		if(toDate<fromDate){
		alert("Issue Date cant be less than demand date !!");
			return false;
		}


		       	return true;
	}
 //================= condemnation entry ==================
  function ajaxFunctionForAutoCompleteInCondemnation(formName,action,rowVal) {
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
      		var batchId="batchId"+rowVal;

      		obj = document.getElementById(batchId);
		obj.length = 1;

      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];

	        var name  = item.getElementsByTagName("name")[0];
	         var batchLength  = item.getElementsByTagName("batchs")[0];

        	document.getElementById('codeItem'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue


        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
        	{
        		var batch = batchLength.childNodes[innerLoop];
	        	var batchId  = batch.getElementsByTagName("batchId")[0];
	        	var batchName  = batch.getElementsByTagName("batchName")[0];
	        	obj.length++;
				obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;

        	}

      	}
      }
    }
       var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }



 //================Balance Ajax multiple ids updating=================



  // ************************Start Of DEEPTI Tevatia*********************************

 function ajaxFunctionForDepartmentReturn(formName,action,rowVal) {
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
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	        var brandId  = item.getElementsByTagName("brandId")[0];

	        var name  = item.getElementsByTagName("name")[0];
        	document.getElementById('pvmsNo'+rowVal).value = pvms.childNodes[0].nodeValue
        	document.getElementById('nomenclature'+rowVal).value = name.childNodes[0].nodeValue
        	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue

        	var url="/hms/hms/stores?method=showStockDetailsForReturnDispensary&brandId="+brandId.childNodes[0].nodeValue+"&rowVal="+rowVal;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
        	 popwindow(url);
      	}
      }
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }

//***************************End Of Deepti Tevatia*******************************


//***************************Functions By Ritu*******************************

  function getServicePersonName(formName,action){
  		var serviceTypeId = document.getElementById('serviceTypeId').value;
  		var serviceNo = document.getElementById('serviceNoId').value;

		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
		       	if(serviceTypeId != 0 && serviceNo != ''){
	    	   	 var url=action+"&serviceNo="+serviceNo+"&serviceTypeId="+serviceTypeId;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	        	new Ajax.Updater('sNameDiv',url,
				   {asynchronous:true, evalScripts:true });
				   }
				return true;
	    	}

function ajaxFunctionForAutoCompleteChargeCode(formName,action,rowVal) {
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
   totalChargeAmt=0;
   totalNetAmt=0;
   xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < items.childNodes.length; loop++) {
      		if( document.getElementById('disamount'+rowVal).value != ""){
            	 document.getElementById('disamount'+rowVal).value ="";
            }
	   	    var item = items.childNodes[loop];
	        var chargeId  = item.getElementsByTagName("chargeId")[0];
	        var amount  = item.getElementsByTagName("amount")[0];
	        document.getElementById('qty'+rowVal).value = '1'
	        document.getElementById('resrate'+rowVal).value = amount.childNodes[0].nodeValue
        	document.getElementById('amount'+rowVal).value = amount.childNodes[0].nodeValue
        	document.getElementById('netamount'+rowVal).value = amount.childNodes[0].nodeValue
        	document.getElementById('chargeCodeId'+rowVal).value = chargeId.childNodes[0].nodeValue
        	var amt = document.getElementById('amount'+rowVal).value;
        	totalChargeAmt = parseInt(totalChargeAmt)+parseInt(amt);
        	totalNetAmt = parseInt(totalNetAmt)+parseInt(document.getElementById('netamount'+rowVal).value);
        	document.getElementById('qty'+rowVal).readOnly = false;
        	document.getElementById('disamount'+rowVal).readOnly = false;

      	}
      }
        var totalAmtVal = document.getElementById('totalAmtId').value;
		if(totalAmtVal == ''){
			document.getElementById('totalAmtId').value=totalChargeAmt
		}else{
			document.getElementById('totalAmtId').value=parseInt(totalChargeAmt)+parseInt(totalAmtVal)
		}

		var totalNetAmtVal = document.getElementById('totalNetId').value;
		if(totalNetAmtVal == ''){
			document.getElementById('totalNetId').value=totalNetAmt
		}else{
			document.getElementById('totalNetId').value=parseInt(totalNetAmt)+parseInt(totalNetAmtVal)
		}
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    }

  function ajaxFunctionForAutoCompleteChargeCodeName(formName,action,rowVal) {
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
	        var chargeId  = item.getElementsByTagName("chargeId")[0];
	        var chargeName  = item.getElementsByTagName("chargeName")[0];
	        var mainChargeId  = item.getElementsByTagName("mainChargeId")[0];
	        var subChargeId  = item.getElementsByTagName("subChargeId")[0];
	        document.getElementById('qty'+rowVal).value = '1'
        	document.getElementById('chargeCodeId'+rowVal).value = chargeId.childNodes[0].nodeValue
        	document.getElementById('chargeName'+rowVal).value = chargeName.childNodes[0].nodeValue
        	document.getElementById('mainChargeId'+rowVal).value = mainChargeId.childNodes[0].nodeValue
        	document.getElementById('subChargeId'+rowVal).value = subChargeId.childNodes[0].nodeValue
      	}
      }
      }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }

function  getEchsNo(){
if(document.getElementById("serviceStatusId").value ==2){
	new Ajax.Updater('exServiceId','/hms/hms/registration?method=getEchsNo&'+csrfTokenName+'='+csrfTokenValue,{asynchronous:true, evalScripts:true });
}else if(document.getElementById("serviceStatusId").value == 1){
	document.getElementById('echs').disabled=true;
}
}

//----------------Added at Bangalore--------------------
 function populatePatientDetails() {

  		var serviceTypeId = document.getElementById('serviceTypeId').value;
  		var serviceNo = document.getElementById('serviceNoId').value;
		if(checkDob()){
		action="/hms/hms/registration?method=populatePatientDetails&serviceTypeId="+serviceTypeId+"&serviceNo="+serviceNo;
		obj = eval('document.registration')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	 }
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

	       var address  = item.getElementsByTagName("address")[0];
	       var blockId  = item.getElementsByTagName("blockId")[0];
	       var stateId  = item.getElementsByTagName("stateId")[0];
	       var cityId  = item.getElementsByTagName("cityId")[0];
	       var countryId  = item.getElementsByTagName("countryId")[0];
	       var pinCode  = item.getElementsByTagName("pinCode")[0];
	       var patientDistrict  = item.getElementsByTagName("patientDistrict")[0];
	       var postOff  = item.getElementsByTagName("postOff")[0];
	       var policeStation  = item.getElementsByTagName("policeStation")[0];
	       var phoneNo  = item.getElementsByTagName("phoneNo")[0];
	       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
	         var religionId  = item.getElementsByTagName("religionId")[0];
	        if(address.childNodes[0].nodeValue != "0")
	       document.getElementById("addr").value = address.childNodes[0].nodeValue
	       if(blockId.childNodes[0].nodeValue != "0")
		   document.getElementById("blockId").selectedIndex = blockId.childNodes[0].nodeValue
		    document.getElementById("countryId").selectedIndex = countryId.childNodes[0].nodeValue
		    populateState(countryId.childNodes[0].nodeValue,'registration')
		   document.getElementById("stateId").selectedIndex = stateId.childNodes[0].nodeValue
		   populateDistrict(stateId.childNodes[0].nodeValue,'registration')
		   if(pinCode.childNodes[0].nodeValue != "0")
		   document.getElementById("pinCodeId").value =pinCode.childNodes[0].nodeValue

		   if(patientDistrict.childNodes[0].nodeValue != "0")
		   document.getElementById("patientDistId").value =patientDistrict.childNodes[0].nodeValue
		   if(postOff.childNodes[0].nodeValue != "0")
		   document.getElementById("postOff").value =postOff.childNodes[0].nodeValue
		   if(policeStation.childNodes[0].nodeValue !="0")
		   document.getElementById("policeStation").value =policeStation.childNodes[0].nodeValue
		   if(phoneNo.childNodes[0].nodeValue !="0")
		   document.getElementById("phoneNo").value =phoneNo.childNodes[0].nodeValue
		   if(mobileNo.childNodes[0].nodeValue !="0")
		   document.getElementById("mobileNo").value =mobileNo.childNodes[0].nodeValue
		   document.getElementById("religionId").selectedIndex = religionId.childNodes[0].nodeValue

		   document.getElementById("cityId").selectedIndex = cityId.childNodes[0].nodeValue


      	}
      }
    }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);


  }
 // On Visit Search Populate Visiti Details

 function pVisitDetailsList(appId,hinNo,deptId,deptName,onlineStatus) {
	/*alert(hinNo);*/
		
		action="/hms/hms/registration?method=populatePatientVisitDetail&patientHinNo="+hinNo;
		obj = eval('document.search')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
 
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
	   	   
	       var uhid  = item.getElementsByTagName("Uhid")[0];
	       var name  = item.getElementsByTagName("name")[0];
	       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
	       var age  = item.getElementsByTagName("page")[0];
	       var NameOf  = item.getElementsByTagName("NameOf")[0];
	       var RelativeName  = item.getElementsByTagName("RelativeName")[0];
	       
	       var Occupation  = item.getElementsByTagName("Occupation")[0];
	       
	       var Category  = item.getElementsByTagName("Category")[0];
	       var Gender  = item.getElementsByTagName("Gender")[0];
	       var LastVisitDate  = item.getElementsByTagName("LastVisitDate")[0];
	       var dutyDoct  = item.getElementsByTagName("dutyDoct")[0];
	       
	       var VisitNo  = item.getElementsByTagName("VisitNo")[0]; 
	      
	       var CategoryId=item.getElementsByTagName("CategoryId")[0];
	       var hinId=item.getElementsByTagName("hinId")[0];
	       
	      
	       
	       if(hinId !=undefined && hinId.childNodes[0] !=undefined)
	       document.getElementById("hinId").value = hinId.childNodes[0].nodeValue
	       
	       if(uhid !=undefined && uhid.childNodes[0] !=undefined)
		   document.getElementById("pUhidId").value = uhid.childNodes[0].nodeValue
		   
		   if(VisitNo !=undefined && VisitNo.childNodes[0] !=undefined)
		document.getElementById("visitNoId").value = VisitNo.childNodes[0].nodeValue
		
		   if(deptId !=undefined && deptId!="" && deptName !=undefined && deptName!=""){
				document.getElementById("deptId").value =deptId;
				document.getElementById("deptId").text =deptName;
				document.getElementById("deptId").selected = true;
				var element= document.getElementById("otherdeptId");
				
				element.setAttribute("validate","no");
				
				//alert()
		   }
	       /*if(deptId !=undefined && deptId!="" && deptName !=undefined && deptName!=""){
				document.getElementById("otherdeptId").value =deptId;
				document.getElementById("otherdeptId").text =deptName;
				document.getElementById("otherdeptId").selected = true;
				var element= document.getElementById("deptId");
				
				element.setAttribute("validate","no");
				
				//alert()
		   }
		*/
		 	if(age !=undefined && age.childNodes[0] !=undefined)
		   document.getElementById("ageId").value = age.childNodes[0].nodeValue
		   
		   if(name !=undefined && name.childNodes[0] !=undefined)
		   document.getElementById("pnameId").value = name.childNodes[0].nodeValue
		   
		   if(NameOf.childNodes[0] !=undefined)
		   document.getElementById("relationId").value =NameOf.childNodes[0].nodeValue
		   
		   if(mobileNo.childNodes[0] !=undefined)
		   document.getElementById("mobileNoId").value = mobileNo.childNodes[0].nodeValue
		   
		   if(RelativeName !=undefined && RelativeName.childNodes[0] !=undefined)
		   document.getElementById("relationNameId").value = RelativeName.childNodes[0].nodeValue
		   
		   if(Occupation !=undefined && Occupation.childNodes[0] !=undefined)
		   document.getElementById("occupationId").value = Occupation.childNodes[0].nodeValue
		   
		   if(Category !=undefined && Category.childNodes[0] !=undefined)
		   document.getElementById("categoryId").value = Category.childNodes[0].nodeValue
		   
		   if(Gender !=undefined && Gender.childNodes[0] !=undefined)
		   document.getElementById("genderId").value = Gender.childNodes[0].nodeValue
		   
		   /*var onlineRegStatus=item.getElementsByTagName("onlineRegStatus")[0];*/
	       document.getElementById("onlineRegStatusID").value = 'y'
		   
		   if(LastVisitDate !=undefined && LastVisitDate.childNodes[0] !=undefined)
		   document.getElementById("lastVisitDateId").value = LastVisitDate.childNodes[0].nodeValue
		  
		   if(dutyDoct !=undefined && dutyDoct.childNodes[0] !=undefined)
		   document.getElementById("lastVisitDoctorsIncharge").value = dutyDoct.childNodes[0].nodeValue
		   
		  
	       
		 
		   
		   if(LastVisitDate!=undefined && LastVisitDate.childNodes[0]!=undefined)
			   document.getElementById("lastVisitDateId").value = LastVisitDate.childNodes[0].nodeValue
		   if(dutyDoct!=undefined && dutyDoct.childNodes[0]!=undefined)
			   document.getElementById("lastVisitDoctorsIncharge").value = dutyDoct.childNodes[0].nodeValue
		   if(VisitNo!=undefined && VisitNo.childNodes[0]!=undefined){
			   document.getElementById("visitNoId").value = VisitNo.childNodes[0].nodeValue
			   
		   }
	       if(CategoryId!=undefined && CategoryId.childNodes[0]!=undefined)
		   document.getElementById("patientTypeNameId").value = CategoryId.childNodes[0].nodeValue   
		  
   	}
   }
 }
 document.getElementById("onlineAppointment").value = onlineStatus;
 document.getElementById("onlineAppId").value = appId;
 
 var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

 xmlHttp.open("GET",url,false);
 xmlHttp.setRequestHeader("Content-Type", "text/xml");
 xmlHttp.send(null);
 

}
 
 
 function populateEmployeeByCategory(val) {
		
		obj1 =document.getElementById("mainGroupId");
		obj1.length =0;
			action="/hms/hms/generalMaster?method=populateEmployeeByCategory&Val="+val+"&seviceCenterrId="+seviceCenterrId;
			obj = eval('document.task')
			       obj.action = action;
		    	   	 var url=action;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	 var seviceCenterrId=document.getElementById("seviceCenterrId").value;
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
		   	   
		       var employeeId  = item.getElementsByTagName("employeeId")[0];
		       var empName  = item.getElementsByTagName("empName")[0];
		      
				obj1.length++;
				obj1.options[obj1.length-1].value=employeeId.childNodes[0].nodeValue;
				obj1.options[obj1.length-1].text=empName.childNodes[0].nodeValue;
		      
	   	}
	   }
	 }
	 var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
if(seviceCenterrId !=0 && seviceCenterrId !=null && seviceCenterrId>0){
	 xmlHttp.open("GET",url,false);
}
else{
	alert("select service centre")
}
	 xmlHttp.setRequestHeader("Content-Type", "text/xml");
	 xmlHttp.send(null);
	 

	}
 
//On Visit page Populate referal patient  Details

 function populateReferalPatientDetail(hinNo,name,visitId) {
		
		action="/hms/hms/registration?method=populatePatientVisitDetail&patientHinNo="+hinNo+"&lastVisitId="+visitId;
		obj = eval('document.search')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
 
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
	   	   
	       var uhid  = item.getElementsByTagName("Uhid")[0];
	       var name  = item.getElementsByTagName("name")[0];
	       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
	       var age  = item.getElementsByTagName("page")[0];
	       var NameOf  = item.getElementsByTagName("NameOf")[0];
	       var RelativeName  = item.getElementsByTagName("RelativeName")[0];
	       
	       var Occupation  = item.getElementsByTagName("Occupation")[0];
	       
	       var Category  = item.getElementsByTagName("Category")[0];
	       var Gender  = item.getElementsByTagName("Gender")[0];
	       var LastVisitDate  = item.getElementsByTagName("LastVisitDate")[0];
	       var dutyDoct  = item.getElementsByTagName("dutyDoct")[0];
	       
	       var VisitNo  = item.getElementsByTagName("VisitNo")[0]; 
	      
	       var CategoryId=item.getElementsByTagName("CategoryId")[0];
	       var hinId=item.getElementsByTagName("hinId")[0];
	       var lastVisitId=item.getElementsByTagName("lastVisitId")[0];
	       
	      
	       
	       if(hinId !=undefined && hinId.childNodes[0] !=undefined)
	       document.getElementById("hinId").value = hinId.childNodes[0].nodeValue
	       
	       if(uhid !=undefined && uhid.childNodes[0] !=undefined)
		   document.getElementById("pUhidId").value = uhid.childNodes[0].nodeValue
		   
		   if(VisitNo !=undefined && VisitNo.childNodes[0] !=undefined)
		document.getElementById("visitNoId").value = VisitNo.childNodes[0].nodeValue
		
		 	if(age !=undefined && age.childNodes[0] !=undefined)
		   document.getElementById("ageId").value = age.childNodes[0].nodeValue
		   
		   if(name !=undefined && name.childNodes[0] !=undefined)
		   document.getElementById("pnameId").value = name.childNodes[0].nodeValue
		   
		   if(NameOf.childNodes[0] !=undefined)
		   document.getElementById("relationId").value =NameOf.childNodes[0].nodeValue
		   
		   if(mobileNo.childNodes[0] !=undefined)
		   document.getElementById("mobileNoId").value = mobileNo.childNodes[0].nodeValue
		   
		   if(RelativeName !=undefined && RelativeName.childNodes[0] !=undefined)
		   document.getElementById("relationNameId").value = RelativeName.childNodes[0].nodeValue
		   
		   if(Occupation !=undefined && Occupation.childNodes[0] !=undefined)
		   document.getElementById("occupationId").value = Occupation.childNodes[0].nodeValue
		   
		   if(Category !=undefined && Category.childNodes[0] !=undefined)
		   document.getElementById("categoryId").value = Category.childNodes[0].nodeValue
		   
		   if(Gender !=undefined && Gender.childNodes[0] !=undefined)
		   document.getElementById("genderId").value = Gender.childNodes[0].nodeValue
		   
		   /*var onlineRegStatus=item.getElementsByTagName("onlineRegStatus")[0];*/
	       /*document.getElementById("onlineRegStatusID").value = 'y'*/
		   
		   if(LastVisitDate !=undefined && LastVisitDate.childNodes[0] !=undefined)
		   document.getElementById("lastVisitDateId").value = LastVisitDate.childNodes[0].nodeValue
		  
		   if(dutyDoct !=undefined && dutyDoct.childNodes[0] !=undefined)
		   document.getElementById("lastVisitDoctorsIncharge").value = dutyDoct.childNodes[0].nodeValue
		   
			   if(lastVisitId !=undefined && lastVisitId.childNodes[0] !=undefined)
				   document.getElementById("lastVisitId").value = lastVisitId.childNodes[0].nodeValue
	       
		 
		   
		   if(LastVisitDate!=undefined && LastVisitDate.childNodes[0]!=undefined)
			   document.getElementById("lastVisitDateId").value = LastVisitDate.childNodes[0].nodeValue
		   if(dutyDoct!=undefined && dutyDoct.childNodes[0]!=undefined)
			   document.getElementById("lastVisitDoctorsIncharge").value = dutyDoct.childNodes[0].nodeValue
		   if(VisitNo!=undefined && VisitNo.childNodes[0]!=undefined){
			   document.getElementById("visitNoId").value = VisitNo.childNodes[0].nodeValue
			   
		   }
	       if(CategoryId!=undefined && CategoryId.childNodes[0]!=undefined)
		   document.getElementById("patientTypeNameId").value = CategoryId.childNodes[0].nodeValue   
		   document.getElementById("referalStatusId").value = "y"   
   	}
   }
 }
 var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
if(null==hinNo|| hinNo =="" || hinNo =="null"){
	
	
	var r = confirm("Please Register the Patient ! \n Do you want to register ?");
	if (r == true) {
		submitForm('search','/hms/hms/registration?method=searchPatientFromCitizen&fn='+name)
		
	} else {
	    
	}
}else{
 xmlHttp.open("GET",url,false);
 
 xmlHttp.setRequestHeader("Content-Type", "text/xml");
}
 xmlHttp.send(null);
 

}
 
 function populateNursingPatientAppointment(hinNo,visitId) {
		//alert(visitId);
			
			action="/hms/hms/registration?method=populatePatientVisitDetail&patientHinNo="+hinNo+"&previousVisitId="+visitId;
			obj = eval('document.search')
			       obj.action = action;
		    	   	 var url=action;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	 
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
		   	   
		       var uhid  = item.getElementsByTagName("Uhid")[0];
		       var name  = item.getElementsByTagName("name")[0];
		       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
		       var age  = item.getElementsByTagName("page")[0];
		       var NameOf  = item.getElementsByTagName("NameOf")[0];
		       var RelativeName  = item.getElementsByTagName("RelativeName")[0];
		       
		       var Occupation  = item.getElementsByTagName("Occupation")[0];
		       
		       var Category  = item.getElementsByTagName("Category")[0];
		       var Gender  = item.getElementsByTagName("Gender")[0];
		       var LastVisitDate  = item.getElementsByTagName("LastVisitDate")[0];
		       var dutyDoct  = item.getElementsByTagName("dutyDoct")[0];
		       
		       var VisitNo  = item.getElementsByTagName("VisitNo")[0]; 
		      
		       var CategoryId=item.getElementsByTagName("CategoryId")[0];
		       var hinId=item.getElementsByTagName("hinId")[0];
		       var previousVisitId=item.getElementsByTagName("previousVisitId")[0];
		       
		      
		       
		       if(hinId !=undefined && hinId.childNodes[0] !=undefined)
		       document.getElementById("hinId").value = hinId.childNodes[0].nodeValue
		       
		       if(uhid !=undefined && uhid.childNodes[0] !=undefined)
			   document.getElementById("pUhidId").value = uhid.childNodes[0].nodeValue
			   
			   if(VisitNo !=undefined && VisitNo.childNodes[0] !=undefined)
			document.getElementById("visitNoId").value = VisitNo.childNodes[0].nodeValue
			
			 	if(age !=undefined && age.childNodes[0] !=undefined)
			   document.getElementById("ageId").value = age.childNodes[0].nodeValue
			   
			   if(name !=undefined && name.childNodes[0] !=undefined)
			   document.getElementById("pnameId").value = name.childNodes[0].nodeValue
			   
			   if(NameOf.childNodes[0] !=undefined)
			   document.getElementById("relationId").value =NameOf.childNodes[0].nodeValue
			   
			   if(mobileNo.childNodes[0] !=undefined)
			   document.getElementById("mobileNoId").value = mobileNo.childNodes[0].nodeValue
			   
			   if(RelativeName !=undefined && RelativeName.childNodes[0] !=undefined)
			   document.getElementById("relationNameId").value = RelativeName.childNodes[0].nodeValue
			   
			   if(Occupation !=undefined && Occupation.childNodes[0] !=undefined)
			   document.getElementById("occupationId").value = Occupation.childNodes[0].nodeValue
			   
			   if(Category !=undefined && Category.childNodes[0] !=undefined)
			   document.getElementById("categoryId").value = Category.childNodes[0].nodeValue
			   
			   if(Gender !=undefined && Gender.childNodes[0] !=undefined)
			   document.getElementById("genderId").value = Gender.childNodes[0].nodeValue
			   
			   /*var onlineRegStatus=item.getElementsByTagName("onlineRegStatus")[0];*/
		       /*document.getElementById("onlineRegStatusID").value = 'y'*/
			   
			   if(LastVisitDate !=undefined && LastVisitDate.childNodes[0] !=undefined)
			   document.getElementById("lastVisitDateId").value = LastVisitDate.childNodes[0].nodeValue
			  
			   if(dutyDoct !=undefined && dutyDoct.childNodes[0] !=undefined)
			   document.getElementById("lastVisitDoctorsIncharge").value = dutyDoct.childNodes[0].nodeValue
			   
			  
		       
			 
			   
			   if(LastVisitDate!=undefined && LastVisitDate.childNodes[0]!=undefined)
				   document.getElementById("lastVisitDateId").value = LastVisitDate.childNodes[0].nodeValue
			   if(dutyDoct!=undefined && dutyDoct.childNodes[0]!=undefined)
				   document.getElementById("lastVisitDoctorsIncharge").value = dutyDoct.childNodes[0].nodeValue
			   if(VisitNo!=undefined && VisitNo.childNodes[0]!=undefined){
				   document.getElementById("visitNoId").value = VisitNo.childNodes[0].nodeValue
				   
			   }
		       if(CategoryId!=undefined && CategoryId.childNodes[0]!=undefined)
			   document.getElementById("patientTypeNameId").value = CategoryId.childNodes[0].nodeValue   
			   
			   if(previousVisitId !=undefined && previousVisitId.childNodes[0] !=undefined)
			       document.getElementById("previousVisitId").value = previousVisitId.childNodes[0].nodeValue
			       
			  
	   	}
	   }
	 }
	 var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	if(null==hinNo|| hinNo =="" || hinNo =="null"){
		
		
		var r = confirm("Please Register the Patient ! \n Do you want to register ?");
		if (r == true) {
			submitForm('search','/hms/hms/registration?method=searchPatientFromCitizen&fn='+name)
			
		} else {
		    
		}
	}else{
	 xmlHttp.open("GET",url,false);
	 
	 xmlHttp.setRequestHeader("Content-Type", "text/xml");
	}
	 xmlHttp.send(null);
	 

	}
 
 function populateInvestigationPatientDetail(hinNo,depId) {
		
			action="/hms/hms/registration?method=populatePatientVisitDetail&patientHinNo="+hinNo;
			obj = eval('document.search')
			       obj.action = action;
		    	   	 var url=action;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	 
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
		   	   
		       var uhid  = item.getElementsByTagName("Uhid")[0];
		       var name  = item.getElementsByTagName("name")[0];
		       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
		       var age  = item.getElementsByTagName("page")[0];
		       var NameOf  = item.getElementsByTagName("NameOf")[0];
		       var RelativeName  = item.getElementsByTagName("RelativeName")[0];
		       
		       var Occupation  = item.getElementsByTagName("Occupation")[0];
		       
		       var Category  = item.getElementsByTagName("Category")[0];
		       var Gender  = item.getElementsByTagName("Gender")[0];
		       var LastVisitDate  = item.getElementsByTagName("LastVisitDate")[0];
		       var dutyDoct  = item.getElementsByTagName("dutyDoct")[0];
		       
		       var VisitNo  = item.getElementsByTagName("VisitNo")[0]; 
		      
		       var CategoryId=item.getElementsByTagName("CategoryId")[0];
		       var hinId=item.getElementsByTagName("hinId")[0];
		       
		      
		       
		       if(hinId !=undefined && hinId.childNodes[0] !=undefined)
		       document.getElementById("hinId").value = hinId.childNodes[0].nodeValue
		       
		       if(uhid !=undefined && uhid.childNodes[0] !=undefined)
			   document.getElementById("pUhidId").value = uhid.childNodes[0].nodeValue
			   
			   if(VisitNo !=undefined && VisitNo.childNodes[0] !=undefined)
			document.getElementById("visitNoId").value = VisitNo.childNodes[0].nodeValue
			
			 	if(age !=undefined && age.childNodes[0] !=undefined)
			   document.getElementById("ageId").value = age.childNodes[0].nodeValue
			   
			   if(name !=undefined && name.childNodes[0] !=undefined)
			   document.getElementById("pnameId").value = name.childNodes[0].nodeValue
			   
			   if(NameOf.childNodes[0] !=undefined)
			   document.getElementById("relationId").value =NameOf.childNodes[0].nodeValue
			   
			   if(mobileNo.childNodes[0] !=undefined)
			   document.getElementById("mobileNoId").value = mobileNo.childNodes[0].nodeValue
			   
			   if(RelativeName !=undefined && RelativeName.childNodes[0] !=undefined)
			   document.getElementById("relationNameId").value = RelativeName.childNodes[0].nodeValue
			   
			   if(Occupation !=undefined && Occupation.childNodes[0] !=undefined)
			   document.getElementById("occupationId").value = Occupation.childNodes[0].nodeValue
			   
			   if(Category !=undefined && Category.childNodes[0] !=undefined)
			   document.getElementById("categoryId").value = Category.childNodes[0].nodeValue
			   
			   if(Gender !=undefined && Gender.childNodes[0] !=undefined)
			   document.getElementById("genderId").value = Gender.childNodes[0].nodeValue
			   
			   /*var onlineRegStatus=item.getElementsByTagName("onlineRegStatus")[0];*/
		       /*document.getElementById("onlineRegStatusID").value = 'y'*/
			   
			   if(LastVisitDate !=undefined && LastVisitDate.childNodes[0] !=undefined)
			   document.getElementById("lastVisitDateId").value = LastVisitDate.childNodes[0].nodeValue
			  
			   if(dutyDoct !=undefined && dutyDoct.childNodes[0] !=undefined)
			   document.getElementById("lastVisitDoctorsIncharge").value = dutyDoct.childNodes[0].nodeValue
			   
			  
		       
			 
			   
			   if(LastVisitDate!=undefined && LastVisitDate.childNodes[0]!=undefined)
				   document.getElementById("lastVisitDateId").value = LastVisitDate.childNodes[0].nodeValue
			   if(dutyDoct!=undefined && dutyDoct.childNodes[0]!=undefined)
				   document.getElementById("lastVisitDoctorsIncharge").value = dutyDoct.childNodes[0].nodeValue
			   if(VisitNo!=undefined && VisitNo.childNodes[0]!=undefined){
				   document.getElementById("visitNoId").value = VisitNo.childNodes[0].nodeValue
				   
			   }
		       document.getElementById("appFlag").value = 'y' 
				   
				   document.getElementById("appdepId").value = depId; 
		       if(CategoryId!=undefined && CategoryId.childNodes[0]!=undefined)
			   document.getElementById("patientTypeNameId").value = CategoryId.childNodes[0].nodeValue 
			   
			   
	   	}
	   }
	 }
	 var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	 xmlHttp.open("GET",url,false);
	 xmlHttp.setRequestHeader("Content-Type", "text/xml");
	 xmlHttp.send(null);
	 

	}
	 
	 
 
 
 function testing(hinNo)
 {		
	 var pathh="/hms/hms/registration?method=displayImage&patientHinNo="+hinNo;
	 	pathh = pathh+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	if( document.getElementById("imageIDD") !=undefined)
	 document.getElementById("imageIDD").src = pathh;
 
		 /*new Ajax.Request('registration?method=displayImage&patientHinNo='+hinNo, {});*/
 }
 function pVisitDetails(hinNo) {
	
	 if(hinNo!=null && hinNo!=""){
		 action="/hms/hms/registration?method=populatePatientVisitDetail&patientHinNo="+hinNo;
			obj = eval('document.search')
			       obj.action = action;
		    	   	 var url=action;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	 
	var xmlHttp=null;
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
		   	   
		       var uhid  = item.getElementsByTagName("Uhid")[0];
		       var name  = item.getElementsByTagName("name")[0];
		       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
		       var age  = item.getElementsByTagName("page")[0];
		       var NameOf  = item.getElementsByTagName("NameOf")[0];
		       var RelativeName  = item.getElementsByTagName("RelativeName")[0];
		       
		       var Occupation  = item.getElementsByTagName("Occupation")[0];
		       
		       var Category  = item.getElementsByTagName("Category")[0];
		       var Gender  = item.getElementsByTagName("Gender")[0];
		       var LastVisitDate  = item.getElementsByTagName("LastVisitDate")[0];
		       var dutyDoct  = item.getElementsByTagName("dutyDoct")[0];
		       
		       var VisitNo  = item.getElementsByTagName("VisitNo")[0]; 
		      
		       var CategoryId=item.getElementsByTagName("CategoryId")[0];
		       var hinId=item.getElementsByTagName("hinId")[0];
		       
		       var department=item.getElementsByTagName("departmentName")[0];
		       
		       var priority=item.getElementsByTagName("priority")[0];
		       
		       var pragnent=item.getElementsByTagName("pragnent")[0]; // added by amit das on 08-06-2016 for JSSK scheme default selected for pragnentwoman
		       var schemeDropDown = document.getElementById("VisitschemeId");
		       
		       var unitId=item.getElementsByTagName("unitId")[0];
		       var unitName=item.getElementsByTagName("unitName")[0];
		       var doctorId=item.getElementsByTagName("doctorId")[0];
		       var docName=item.getElementsByTagName("docName")[0];
		       var serviceCemterId=item.getElementsByTagName("serviceCemterId")[0];
		       
		       
		       if(unitId !=undefined && unitId.childNodes[0] !=undefined && unitName.childNodes[0] !=undefined){
		    	   unitIdLastVisit =  unitId.childNodes[0].nodeValue;
		    	   /*unit = document.getElementById('unit');
	     		  unit.length = 1;
	     		  unit.length++;
	     		  unit.options[unit.length-1].value=unitId.childNodes[0].nodeValue
	     		  unit.options[unit.length-1].selected=true;
	     		  unit.options[unit.length-1].text=unitName.childNodes[0].nodeValue */
		       }
		       
	          
	          if(doctorId !=undefined && doctorId.childNodes[0] !=undefined && docName.childNodes[0] !=undefined && null !=doctorId.childNodes[0].nodeValue){
	        	  doctorIdLastVisit =  doctorId.childNodes[0].nodeValue;
	        	  document.getElementById('lastVisitedDrId').value=doctorIdLastVisit;
	        	 /* loddrs = document.getElementById('loddrs');
	        	  loddrs.length = 1;
	        	  loddrs.length++;
	        	  loddrs.options[loddrs.length-1].value=doctorId.childNodes[0].nodeValue
	        	  loddrs.options[loddrs.length-1].selected=true;
	        	  loddrs.options[loddrs.length-1].text=docName.childNodes[0].nodeValue*/
					
		    	   
		       } else{
		    	   document.getElementById('lastVisitedDrId').value = "";
		       }
	          
	         
	          if(serviceCemterId !=undefined && serviceCemterId.childNodes[0] !=undefined){
	        	 
	        	//  document.getElementById("deptId").value = serviceCemterId.childNodes[0].nodeValue 
	        	 // document.getElementById("deptId").selectedIndex  = serviceCemterId.childNodes[0].nodeValue 
	        	 
	        	  var element= document.getElementById("otherdeptId");
	      		
	      		element.setAttribute("validate","no");
		       } 
		       
		       if(pragnent.childNodes[0].nodeValue == 'yes') {
		    	    var schemeDropDownCount;
		    	    for (schemeDropDownCount = 0; schemeDropDownCount < schemeDropDown.length; schemeDropDownCount++) {
		    	    	if(schemeDropDown.options[schemeDropDownCount].text == 'JSSK')
		    	    		schemeDropDown.options[schemeDropDownCount].selected = 'selected';
		    	    }
		       }    
		    
		       document.getElementById("hinId").value = hinId.childNodes[0].nodeValue
		       
		       if(department.childNodes[0] !=undefined)
		       document.getElementById("visitdepartmentId").value = department.childNodes[0].nodeValue
		       document.getElementById("priorityId").value = priority.childNodes[0].nodeValue
		       
			   document.getElementById("pUhidId").value = uhid.childNodes[0].nodeValue
		
			 	if(age !=undefined && age.childNodes[0] !=undefined)
			   document.getElementById("ageId").value = age.childNodes[0].nodeValue
			   document.getElementById("pnameId").value = name.childNodes[0].nodeValue
			   
			   if(NameOf.childNodes[0] !=undefined)
			   document.getElementById("relationId").value =NameOf.childNodes[0].nodeValue
			   
			   if(mobileNo.childNodes[0] !=undefined)
			   document.getElementById("mobileNoId").value = mobileNo.childNodes[0].nodeValue
			   
			   if(RelativeName.childNodes[0] !=undefined)
			   document.getElementById("relationNameId").value = RelativeName.childNodes[0].nodeValue
			   
			   if(Occupation.childNodes[0] !=undefined)
			   document.getElementById("occupationId").value = Occupation.childNodes[0].nodeValue
			   
			   document.getElementById("categoryId").value = Category.childNodes[0].nodeValue
			   document.getElementById("genderId").value = Gender.childNodes[0].nodeValue

			
			   var pastDue=item.getElementsByTagName("pastDue")[0];
			   
			   document.getElementById("availableCreditBalanceId").value = pastDue.childNodes[0].nodeValue
			  
			   
			   if(LastVisitDate!=undefined && LastVisitDate.childNodes[0]!=undefined)
				   document.getElementById("lastVisitDateId").value = LastVisitDate.childNodes[0].nodeValue
			   if(dutyDoct!=undefined && dutyDoct.childNodes[0]!=undefined)
				   document.getElementById("lastVisitDoctorsIncharge").value = dutyDoct.childNodes[0].nodeValue
			   if(VisitNo!=undefined && VisitNo.childNodes[0]!=undefined){
				   document.getElementById("visitNoId").value = VisitNo.childNodes[0].nodeValue
			   }
			   if(CategoryId!=undefined && CategoryId.childNodes[0]!=undefined){
			   document.getElementById("patientTypeNameId").value = CategoryId.childNodes[0].nodeValue
			   }
			   document.getElementById("deptId").focus(); // added by arbind on 08-02-2017
	   	}
	   }
	 }
	 var url=action;
		url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	 xmlHttp.open("GET",url,false);
	 xmlHttp.setRequestHeader("Content-Type", "text/xml");
	 xmlHttp.send(null);
	 testing(hinNo);
	 }
		
		


}

 // End 
// On Visit Search Populate Visiti Details
 
 function cashNotReceived() {

	if(document.getElementById("cashreceived").checked) {
		document.getElementById("cashNotReceived").style.display = "none";
	} else {
		document.getElementById("cashNotReceived").style.display = "block";
	}
}
 
 function populateDataFromCitizen(citizenId) {
		action="/hms/hms/registration?method=populatePatientCitizenData&citizenId="+citizenId;
		if(document.patientRegistersearch)
			obj = eval('document.patientRegistersearch')
			else
				obj = eval('document.quickRegistersearch')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
 
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
	       var name  = item.getElementsByTagName("name")[0];
	       
	       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
	       
	       var age  = item.getElementsByTagName("age")[0];
	      // alert(age.childNodes[0].nodeValue);
	      /* var NameOf  = item.getElementsByTagName("NameOf")[0];*/
	       var RelativeName  = item.getElementsByTagName("RelativeName")[0];
	       var relation    =item.getElementsByTagName("relation")[0];
	       var socialCategory    =item.getElementsByTagName("socialCategory")[0];
	       var Occupation  = item.getElementsByTagName("Occupation")[0];
	       
	       var Category  = item.getElementsByTagName("Category")[0];
	       var Gender  = item.getElementsByTagName("Gender")[0];
	      // alert(Gender);
	       var yearOfBirth  = item.getElementsByTagName("yearOfBirth")[0];
	       var dob  = item.getElementsByTagName("dob")[0];
	       var familyId  = item.getElementsByTagName("familyId")[0];
	       var memberId  = item.getElementsByTagName("memberId")[0];
	      
	       var socialCategory=item.getElementsByTagName("socialCategory")[0];
	       var aadharDistrict  = item.getElementsByTagName("aadharDistrict")[0];
	       
	       var education  = item.getElementsByTagName("education")[0];
	       var memberHospitalId1=item.getElementsByTagName("memberHospitalId")[0];
	       var aadharNo=item.getElementsByTagName("aadharNo")[0];
	       var address=item.getElementsByTagName("address")[0];
	       
	       if(undefined !=aadharNo && undefined !=aadharNo.childNodes[0]){
	    	   if(aadharNo.childNodes[0].nodeValue!=' '){
	    		   if(document.getElementById('aadhaarRadioId'))
	    			   document.getElementById('aadhaarRadioId').checked = true;
	    		   if(document.getElementById('phAadhaarDiv'))
	    			   document.getElementById('phAadhaarDiv').style.display = 'block';
	    		   if(document.getElementById("phAadhaarNumberId"))
	    			   document.getElementById("phAadhaarNumberId").value = aadharNo.childNodes[0].nodeValue ;
	    		   if(document.getElementById("pQAadhaarNumberId"))
	    			   document.getElementById("pQAadhaarNumberId").value = aadharNo.childNodes[0].nodeValue ;
	    	   }else{
	    		   if(document.getElementById('nnoId'))
	    			   document.getElementById('nnoId').checked = true;
	    		   if(document.getElementById('phAadhaarDiv'))
	    			   document.getElementById('phAadhaarDiv').style.display = 'none';
	    		   if( document.getElementById("phAadhaarNumberId"))
	    			   document.getElementById("phAadhaarNumberId").value = '';
	    	   }
	    	   
	       }else{
	    	   if(document.getElementById('nnoId'))
	    		   document.getElementById('nnoId').checked = true;
	    	   if(document.getElementById('phAadhaarDiv'))
	    		   document.getElementById('phAadhaarDiv').style.display = 'none';
	    	   if( document.getElementById("phAadhaarNumberId"))
	    		   document.getElementById("phAadhaarNumberId").value ='' ;
	       }
	       
	       if(document.getElementById("nativeSubCentre") && memberHospitalId1!=undefined && undefined !=memberHospitalId1.childNodes[0]){
	    	   document.getElementById("nativeSubCentre").value = memberHospitalId1.childNodes[0].nodeValue;
	       }
	       
	       if( document.getElementById("educationId") && education!=undefined && undefined !=education.childNodes[0]){
	    	   document.getElementById("educationId").value = education.childNodes[0].nodeValue 
	       }
	       if(aadharDistrict !=undefined && undefined !=aadharDistrict.childNodes[0]){
	    	   
	    	   //Changed by Arbind on 23-02-2016
	    	   //document.getElementById("cityId").selectedIndex  = aadharDistrict.childNodes[0].nodeValue 
	    	   if(document.getElementById("cityId")){
	    		   document.getElementById("cityId").value = aadharDistrict.childNodes[0].nodeValue
	    		   populsubDistrictByDistrictId(aadharDistrict.childNodes[0].nodeValue); 
	    		   populateAPincodeByDistrict(aadharDistrict.childNodes[0].nodeValue);
	    		   populateAadhaarVillageTown(aadharDistrict.childNodes[0].nodeValue);
	    	   }
	       }
	       
	       var houseName  = item.getElementsByTagName("houseName")[0];
	       if(houseName!=undefined && undefined !=houseName.childNodes[0] && document.getElementById("pHouseName")){
	    	   document.getElementById("pHouseName").value = houseName.childNodes[0].nodeValue 
	       }
	       
	       var streetName  = item.getElementsByTagName("streetName")[0];
	       if(streetName!=undefined && undefined !=streetName.childNodes[0] && document.getElementById("streetName")){
	    	   document.getElementById("streetName").value = streetName.childNodes[0].nodeValue 
	       }
	       
	       
	       if(familyId!=undefined && null != familyId.childNodes[0] && undefined !=familyId.childNodes[0] &&  document.getElementById("familyID")){
	       document.getElementById("familyID").value = familyId.childNodes[0].nodeValue
	       document.getElementById("citizenDataId").value ="yes"
	       
	       }
	       
	       if(memberId!=undefined && null != memberId.childNodes[0] && undefined !=memberId.childNodes[0] && document.getElementById("memberID"))
	    	   document.getElementById("memberID").value = memberId.childNodes[0].nodeValue
	       
    	   if(document.getElementById("dobId"))
    		   document.getElementById("dobId").value = dob.childNodes[0].nodeValue
    		   
    		   if(document.getElementById("patientTypeId")){
    			   if(socialCategory.childNodes[0]!=null)
        		   document.getElementById("patientTypeId").value = socialCategory.childNodes[0].nodeValue
        		   selectItemByValueId(document.getElementById("patientTypeId"),socialCategory.childNodes[0].nodeValue);
    		   }   
        		  
    	   if(document.getElementById("yobId"))  
    		   document.getElementById("yobId").value = yearOfBirth.childNodes[0].nodeValue
    		
    	   if(document.getElementById("age"))
    		   document.getElementById("age").value = age.childNodes[0].nodeValue
    		   
		   
		   if(document.getElementById("pNameId"))
			   document.getElementById("pNameId").value = name.childNodes[0].nodeValue
			  
			
		   if(document.getElementById("address")){
    		   document.getElementById("address").value = address.childNodes[0].nodeValue
		   }
	    		 
		   if(document.getElementById("mobileNoId"))
			   document.getElementById("mobileNoId").value = mobileNo.childNodes[0].nodeValue
		   
		   if(RelativeName!=undefined && null != RelativeName.childNodes[0] && undefined !=RelativeName.childNodes[0] && document.getElementById("relativeNameId"))
			   document.getElementById("relativeNameId").value = RelativeName.childNodes[0].nodeValue
		   
		   if(Occupation !=undefined && null !=Occupation.childNodes[0] && undefined !=Occupation.childNodes[0] && document.getElementById("occupationId"))
			   document.getElementById("occupationId").value = Occupation.childNodes[0].nodeValue
		   
		   if(Gender!=undefined && undefined !=Gender.childNodes[0] && null !=Gender.childNodes[0] && document.getElementById("gender"))
			   document.getElementById("gender").value = Gender.childNodes[0].nodeValue
		   
		   if(document.getElementById("otherCategoryId") && Category!=undefined && undefined !=Category.childNodes[0] && null !=Category.childNodes[0].nodeValue)
			   document.getElementById("otherCategoryId").selectedIndex = Category.childNodes[0].nodeValue
		   
		   if(document.getElementById("citizenSearchId"))
			   document.getElementById("citizenSearchId").value ="citizen"
			   
		   var permanentDistrictId  = item.getElementsByTagName("permanentDistrictId")[0];
	       if(document.getElementById("pcityId") && permanentDistrictId!=undefined &&  permanentDistrictId.childNodes[0]!=null)
	    	   document.getElementById("pcityId").selectedIndex = permanentDistrictId.childNodes[0].nodeValue
	    	   document.getElementById("pcityId").value = permanentDistrictId.childNodes[0].nodeValue
	    	   
	       var permanentTalukId  = item.getElementsByTagName("permanentTalukId")[0];
	       if(document.getElementById("talukId") && permanentTalukId!=undefined &&  permanentTalukId.childNodes[0]!=null)
	    	   document.getElementById("talukId").selectedIndex = permanentTalukId.childNodes[0].nodeValue
	    	   document.getElementById("talukId").value = permanentTalukId.childNodes[0].nodeValue
	       var permanentPostOfficeId  = item.getElementsByTagName("permanentPostOfficeId")[0];
	       if(document.getElementById("pppostOff") && permanentPostOfficeId!=undefined &&  permanentPostOfficeId.childNodes[0]!=null)
	    	   document.getElementById("pppostOff").selectedIndex = permanentPostOfficeId.childNodes[0].nodeValue
	    	   document.getElementById("pppostOff").value = permanentPostOfficeId.childNodes[0].nodeValue
	      
	       var permanentPostCode  = item.getElementsByTagName("permanentPostCode")[0];
	       if(document.getElementById("ppincode") && permanentPostCode!=undefined &&  permanentPostCode.childNodes[0]!=null)
	    	   document.getElementById("ppincode").value = permanentPostCode.childNodes[0].nodeValue
	       
	       var healthHouseId  = item.getElementsByTagName("healthHouseId")[0]; 
	       if(document.getElementById("healthHouseId") && healthHouseId!=undefined &&  healthHouseId.childNodes[0]!=null)
		       document.getElementById("healthHouseId").value = healthHouseId.childNodes[0].nodeValue
		       
	       var lsghouseNo  = item.getElementsByTagName("lsghouseNo")[0]; 
	       if(document.getElementById("pLsgHouseNo") && lsghouseNo!=undefined &&  lsghouseNo.childNodes[0]!=null)
		       document.getElementById("pLsgHouseNo").value = lsghouseNo.childNodes[0].nodeValue
		      
		   var lsgId  = item.getElementsByTagName("lsgId")[0]; 
		   if(lsgId!=undefined &&  lsgId.childNodes[0]!=null)
			   if(document.getElementById("lsgId"))
			   document.getElementById("lsgId").value = lsgId.childNodes[0].nodeValue
			       
		       var relationname  = item.getElementsByTagName("relation")[0]; 
		       if(document.getElementById("relId")){
			       document.getElementById("relId").value = relationname.childNodes[0].nodeValue			      
			       selectItemByValue(document.getElementById("relId"),relationname.childNodes[0].nodeValue);
		       }
		       var bloodGroup    =item.getElementsByTagName("bloodGroup")[0];
		       if(document.getElementById("bloodGroupId")){
			       document.getElementById("bloodGroupId").value = bloodGroup.childNodes[0].nodeValue			      
			       selectItemByValue(document.getElementById("bloodGroupId"),bloodGroup.childNodes[0].nodeValue);
		       }
		      
	       var bloodGroupValue  = item.getElementsByTagName("bloodGroupValue")[0]; 
	       if(document.getElementById("bloodGroupValueId") && bloodGroupValue!=undefined &&  bloodGroupValue.childNodes[0]!=null)
		       document.getElementById("bloodGroupValueId").value = bloodGroupValue.childNodes[0].nodeValue
	       
	       var wardId  = item.getElementsByTagName("wardId")[0];
	       if(document.getElementById("wardId") && wardId!=undefined &&  wardId.childNodes[0]!=null)
		       document.getElementById("wardId").value = wardId.childNodes[0].nodeValue
		       
	       if(document.getElementById("locality")){
	    	   if(document.patientRegistersearch){
	    		   obj =document.getElementById("locality");
	    		   obj.length =0;

	    		   var localityId  = item.getElementsByTagName("localityId")[0]; 
	    		   var localityName  = item.getElementsByTagName("localityName")[0]; 
	    		   if(localityId!=undefined && localityId.childNodes[0]!=null){
	    			   obj.length++;
	    			   obj.options[obj.length-1].value=localityId.childNodes[0].nodeValue;
	    			   obj.options[obj.length-1].text=localityName.childNodes[0].nodeValue;
	    		   } 
	    	   }else{ // for quick registration
	    		 var localityNames  = item.getElementsByTagName("localityNames")[0];
	   		    if(localityNames!=undefined &&  localityNames.childNodes[0]!=null)
	   			document.getElementById("locality").value = localityNames.childNodes[0].nodeValue
	   			else{
	   			document.getElementById("locality").value = ''
	   			}
	   			 var localityId  = item.getElementsByTagName("localitysId")[0]; 
	   		    if(localityId!=undefined &&  localityId.childNodes[0]!=null)
	   			document.getElementById("localitysId").value = localityId.childNodes[0].nodeValue
	   			else
	   			document.getElementById("localitysId").value = ''
	    	   }
	       }
	              
   	}
   }
 }
 var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

 xmlHttp.open("GET",url,true);
 xmlHttp.setRequestHeader("Content-Type", "text/xml");
 xmlHttp.send(null);


}
 
 function patientVisitscheme(schemeId){
	
var phinId=document.getElementById("pUhidId").value;

var chargeId=document.getElementById("registrationTypeId").value;

var chargeAmount=document.getElementById("amountId").value;

if(schemeId>0){
		action="/hms/hms/registration?method=Visitscheme&schemeId="+schemeId+"&chargeId="+chargeId+"&hinNO="+phinId;
		obj = eval('document.patientVisitSearch')
		       obj.action = action;
	    	   	 var url=action
}
else{
	document.getElementById("discountPercentText").value="";
	document.getElementById("discountPerAmountTextId").value="";
}

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
	       var discount  = item.getElementsByTagName("discount")[0];
	       var discountPercentage=discount.childNodes[0].nodeValue;
	       
	       var discountAmount  = item.getElementsByTagName("discountAmount")[0];
	       
	       var discountAmountt=discountAmount.childNodes[0].nodeValue;
	       
	     if(chargeAmount>0.0 && discountPercentage>0.0 ){
	    	 document.getElementById("discountPercentText").value=discount.childNodes[0].nodeValue;
	    	
	    	 var disAmount=chargeAmount*discountPercentage/100;
	    	 document.getElementById("discountPerAmountTextId").value=disAmount;
	    	 var balancePaid=chargeAmount-disAmount;
	    	 document.getElementById("balanceToBePaidId").value=balancePaid;
	    	 document.getElementById("amountTenderedId").value=balancePaid;
	    	 
	     }
	     if(chargeAmount>0.0  && discountAmountt>0.0){
	    	 
	    	 document.getElementById("discountPerAmountTextId").value=discountAmountt;
	    	 var disPerc=(discountAmountt * 100)/chargeAmount;
	    	 document.getElementById("discountPercentText").value=disPerc;
		    	
	    	 var disAmount=chargeAmount*discountPercentage/100;
	    	
	    	 var balancePaid=chargeAmount-disAmount;
	    	 document.getElementById("balanceToBePaidId").value=balancePaid;
	    	 document.getElementById("amountTenderedId").value=balancePaid;
	    	 
	     }
	       
	
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

xmlHttp.open("GET",url,false);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
	 
 }

 // End 
 
 function populateBloodBankRegField(bloodBankId) {
		//alert(bloodBankId)
		action="/hms/hms/bloodBank?method=populateBloodBankRegField&bloodBankId="+bloodBankId;
		obj = eval('document.regBloodBank')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

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
	       var name  = item.getElementsByTagName("bloodBankName")[0];
	       var contact  = item.getElementsByTagName("contact")[0];
	       var districtId  = item.getElementsByTagName("districtId")[0];
	      // alert(age.childNodes[0].nodeValue);
	      /* var NameOf  = item.getElementsByTagName("NameOf")[0];*/
	       var districtname  = item.getElementsByTagName("districtname")[0];
	       
	       var talukId  = item.getElementsByTagName("talukId")[0];
	       
	      /* var Category  = item.getElementsByTagName("Category")[0];*/
	       var talukname  = item.getElementsByTagName("talukname")[0];
	       
	       var opentime  = item.getElementsByTagName("opentime")[0];
	       
	       var closetime  = item.getElementsByTagName("closetime")[0];
	       var reg  = item.getElementsByTagName("reg")[0];
	       
	       var validFrom=item.getElementsByTagName("validFrom")[0];
	       var validTo=item.getElementsByTagName("validTo")[0];
	       
	       document.getElementById("datefrom").value = validFrom.childNodes[0].nodeValue 
	       
	       document.getElementById("dateTo").value = validTo.childNodes[0].nodeValue 
	       
	          
	       document.getElementById("registrationNumId").value = reg.childNodes[0].nodeValue 
	       document.getElementById("registrationNumId").readOnly = true;
	       
	     var bbavailable = item.getElementsByTagName("bbavailable")[0];
	       if(bbavailable.childNodes[0].nodeValue =='y' || bbavailable.childNodes[0].nodeValue =='Y'){
	    	   document.getElementById("goverId").checked = true;
	       }
	       else{
	    	   document.getElementById("privId").checked = true;
	       }
	       
	       if(undefined !=closetime.childNodes[0]){
	    	   document.getElementById("endTimeId").value = closetime.childNodes[0].nodeValue 
	       }
	       if(undefined !=opentime.childNodes[0]){
	    	   document.getElementById("statrtTimeId").value = opentime.childNodes[0].nodeValue 
	       }
	       if(undefined !=districtId.childNodes[0]){
	    	  // alert(districtId.childNodes[0].nodeValue)
	    	 //  obj =document.getElementById("cityId");
	        	/*obj.length++;
				obj.options[obj.length-1].value=districtId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=districtname.childNodes[0].nodeValue; */
				document.getElementById("cityId").value=districtId.childNodes[0].nodeValue;
	       }
	       if(undefined !=talukId.childNodes[0]){
	    	  // alert(talukId.childNodes[0].nodeValue);
	    	 //  obj =document.getElementById("SubcityId");
	        	/*obj.length++;
				obj.options[obj.length-1].value=talukId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=talukname.childNodes[0].nodeValue;*/
				document.getElementById("SubcityId").value=talukId.childNodes[0].nodeValue;
	    	  
	       }
	       document.getElementById("bloodBankUniqueId").value = bloodBankId
	       
	       if(undefined !=contact.childNodes[0]){
	    	   document.getElementById("contactId").value = contact.childNodes[0].nodeValue 
	       }
	       
	       if(undefined !=name.childNodes[0]){
	    	   document.getElementById("bloodbankId").value = name.childNodes[0].nodeValue 
	    	   document.getElementById("bloodbankId").readOnly = true;
	       }
	       var status  = item.getElementsByTagName("status")[0];
	      
	       document.getElementById("AddId").style.display = 'none';
	       document.getElementById("resetId").style.display = 'none';
	       document.getElementById("inactiveId").style.display = 'block';
	       document.getElementById("updateId").style.display = 'block';
	       document.getElementById("ActInactId").style.display = 'block';
	       
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);


}
 // Method to populate patient update details field  
 
 function ajaxPopulatePatientForUpdate(hinNo,hinId) {
	 
	
		if(hinNo.length>0)
		{
		action="/hms/hms/registration?method=populatePatientForUpdate&hinNo="+hinNo;
		obj = eval('document.patientUpdate')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
}
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
	   		
	       var uhid  = item.getElementsByTagName("Uhid")[0];
	       var name  = item.getElementsByTagName("name")[0];
	      
	       var aadharNo=item.getElementsByTagName("aadharNo")[0];
	       
	       var dob=item.getElementsByTagName("dob")[0];
	      
	       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
	       var age  = item.getElementsByTagName("age")[0];
	       var NameOf  = item.getElementsByTagName("NameOf")[0];
	       var RelativeName  = item.getElementsByTagName("RelativeName")[0];
	       
	       var Occupation  = item.getElementsByTagName("Occupation")[0];
	       
	       var Category  = item.getElementsByTagName("Category")[0];
	       
	       var Gender  = item.getElementsByTagName("Gender")[0];
	       
	       var birthYear  = item.getElementsByTagName("birthYear")[0];
	       
	       var aDistrict  = item.getElementsByTagName("aDistrict")[0];
	       var ataluk  = item.getElementsByTagName("ataluk")[0];
	       
	       var houseNo  = item.getElementsByTagName("houseNo")[0];
	       var StreetName  = item.getElementsByTagName("StreetName")[0];
	       var postOffice  = item.getElementsByTagName("postOffice")[0];
	       var pin  = item.getElementsByTagName("pin")[0];
	       var village  = item.getElementsByTagName("village")[0];
	       
	       
	       var pDistrict  = item.getElementsByTagName("pDistrict")[0];
	       var ptaluk  = item.getElementsByTagName("ptaluk")[0];
	       
	      /* var CategoryId=item.getElementsByTagName("CategoryId")[0];*/
	       var hinId=item.getElementsByTagName("hinId")[0];
	       //permanenrt
	       var permanentpincode=item.getElementsByTagName("permanentpincode")[0];
	       
	       var pColonyHouseNo=item.getElementsByTagName("pColonyHouseNo")[0];
	       var pLsgHouseName=item.getElementsByTagName("pLsgHouseName")[0];
	       
	       var postOffice=item.getElementsByTagName("postOffice")[0];
	       
	       var plocality=item.getElementsByTagName("plocality")[0];
	       
	       var ward=item.getElementsByTagName("ward")[0];
	       
	       var permanLsgName=item.getElementsByTagName("permanLsgName")[0];
	       
	       var mobileNo=item.getElementsByTagName("mob")[0];
	       
	       var emailId=item.getElementsByTagName("email")[0];
	       
	       
	       document.getElementById("mobileNo").value = mobileNo.childNodes[0].nodeValue
			  document.getElementById("emailId").value = emailId.childNodes[0].nodeValue
			  document.getElementById("phinId").value = hinId.childNodes[0].nodeValue;
	       // temporary address
	      
	       
	       
			  var tdistrictId=item.getElementsByTagName("tdistrictId")[0];
			  var ttalukId=item.getElementsByTagName("ttalukId")[0];
			  var tpincode=item.getElementsByTagName("tpincode")[0];
			  var tpostOff=item.getElementsByTagName("tpostOff")[0];
			  var tlocality=item.getElementsByTagName("tlocality")[0];
			  
			  document.getElementById("tlocality").value = tlocality.childNodes[0].nodeValue
			  document.getElementById("tpostOff").value = tpostOff.childNodes[0].nodeValue
			  document.getElementById("tpincode").value = tpincode.childNodes[0].nodeValue
			  document.getElementById("ttalukId").value = ttalukId.childNodes[0].nodeValue
			  document.getElementById("tdistrictId").value = tdistrictId.childNodes[0].nodeValue
	       
	       //
	      
	       
		  /* document.getElementById("qPFullName").value = uhid.childNodes[0].nodeValue*/
	       document.getElementById("pLsgHouseNo").value = pLsgHouseName.childNodes[0].nodeValue
	       
	      document.getElementById("pdistrictId").value = pDistrict.childNodes[0].nodeValue
	       document.getElementById("ptalukId").value = ptaluk.childNodes[0].nodeValue
	      
	       document.getElementById("plsgNameId").value = permanLsgName.childNodes[0].nodeValue
	       
	       document.getElementById("aadharpostOff").value = postOffice.childNodes[0].nodeValue
	       
	       document.getElementById("villageId").value = village.childNodes[0].nodeValue
	       document.getElementById("pincode").value = pin.childNodes[0].nodeValue
	       
	       document.getElementById("aadhDistId").value = aDistrict.childNodes[0].nodeValue
	       document.getElementById("subcityId").value = ataluk.childNodes[0].nodeValue
	       
	       document.getElementById("streetName").value = StreetName.childNodes[0].nodeValue
	       
	       document.getElementById("pHouseName").value = houseNo.childNodes[0].nodeValue
	       
	       document.getElementById("yobId").value = birthYear.childNodes[0].nodeValue
		   document.getElementById("ageId").value = age.childNodes[0].nodeValue
		   
		   document.getElementById("AadhaarNumberId").value = aadharNo.childNodes[0].nodeValue
		   document.getElementById("pQNameId").value = name.childNodes[0].nodeValue
		   document.getElementById("dobIdd").value = dob.childNodes[0].nodeValue
		   
		   document.getElementById("qGenderId").value = Gender.childNodes[0].nodeValue
		   document.getElementById("relId").value =NameOf.childNodes[0].nodeValue
		   document.getElementById("mobileNoId").value = mobileNo.childNodes[0].nodeValue
		   
		   document.getElementById("qNokNameId").value = RelativeName.childNodes[0].nodeValue
		   
		   document.getElementById("occupationId").value = Occupation.childNodes[0].nodeValue
		   document.getElementById("categoryId").value = Category.childNodes[0].nodeValue
		   
		   document.getElementById("localityId").value = plocality.childNodes[0].nodeValue
		   
		  
		   document.getElementById("patientTypeNameId").value = CategoryId.childNodes[0].nodeValue
		   document.getElementById("hinId").value = hinId.childNodes[0].nodeValue
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);


}

// End 

function getDischargeDetails(serviceNo){
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
   var url="/hms/hms/adt?method=getDischargeDetails&serviceNo="+serviceNo;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);



}

function getDetailsOfDischarge(inpatientId){
var admissionNo ="";
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

	       var sName  = item.getElementsByTagName("sName")[0];
	       var pName  = item.getElementsByTagName("pName")[0];
	       var doa  = item.getElementsByTagName("doa")[0];
	       var relation  = item.getElementsByTagName("relation")[0];
	       var age  = item.getElementsByTagName("age")[0];
	       var sex  = item.getElementsByTagName("sex")[0];
	       var dDate  = item.getElementsByTagName("dDate")[0];
	       var dTime  = item.getElementsByTagName("dTime")[0];
		    var dId  = item.getElementsByTagName("dId")[0];
		    var hinId  = item.getElementsByTagName("hinId")[0];
		     var diagnosis  = item.getElementsByTagName("diagnosis")[0];
		      var deptId  = item.getElementsByTagName("deptId")[0];

		//   document.getElementById("sName").value = sName.childNodes[0].nodeValue
		   document.getElementById("pName").value = pName.childNodes[0].nodeValue
		   document.getElementById("doa").value = doa.childNodes[0].nodeValue
		  document.getElementById("relation").value = relation.childNodes[0].nodeValue
		   document.getElementById("age").value = age.childNodes[0].nodeValue
		   document.getElementById("sex").value = sex.childNodes[0].nodeValue
		    document.getElementById("hinId").value = hinId.childNodes[0].nodeValue
		    document.getElementById("deptId").value = deptId.childNodes[0].nodeValue
		    if(dDate.childNodes[0].nodeValue !="no")
		   document.getElementById("dDate").value = dDate.childNodes[0].nodeValue
		   if(dTime.childNodes[0].nodeValue !="no")
		   document.getElementById("dTime").value = dTime.childNodes[0].nodeValue
		   if(dId.childNodes[0].nodeValue !="no")
		   document.getElementById("dId").value = dId.childNodes[0].nodeValue

		    document.getElementById("diagnosisId").innerHTML = diagnosis.childNodes[0].nodeValue
        	}
      	}
      }

   var url="/hms/hms/adt?method=getDetailsOfDischarge&inpatientId="+inpatientId+"&admissionNo="+admissionNo;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
}

function checkCancelAdmissionState(inpatientId,parentAdNo){
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
	        var cancelState  = item.getElementsByTagName("cancelState")[0];
	        if(cancelState.childNodes[0].nodeValue =="no"){
	        	alert("Can not Cancel the Admission");
	        }else{
	      if(checkForCancel()){
	        submitForm('updateAdmission','/hms/hms/adt?method=cancelAdmissionInformation&parentAdNo='+parentAdNo);
	      }

	        }


      	}
      }
    }
   var url="/hms/hms/adt?method=checkCancelAdmissionState&inpatientId="+inpatientId;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);



}
function checkForCancel()
{
		if(confirm("Are You sure, You want Cancel admission ?"))
			return true;
		else
			return false;
}


//--------------------------------------------- Mansi-----------------------------------
  function getVisitNo(formName,action){
	var hinNoObj = eval('document.'+formName+'.hinNo')
	var hinNo = hinNoObj.value;
		errorMsg ="";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		if(hinNo != ""){
			obj = eval('document.'+formName)
			       	obj.action = action;
		    	   	 var url=action+"&"+getNameAndData(formName);
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

		        	new Ajax.Updater('visitDiv',url,
					   {asynchronous:true, evalScripts:true });
		}
		return true;
}
function ajaxFunctionForAutoCompleteNomenclature(formName,action,rowVal)
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

	        var pvmsNo  = item.getElementsByTagName("pvms")[0];
	        var itemId  = item.getElementsByTagName("id")[0];
        	document.getElementById('pvmsNo'+rowVal).value = pvmsNo.childNodes[0].nodeValue
        	document.getElementById('itemId'+rowVal).value = itemId.childNodes[0].nodeValue

      	}
      }
    }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
 }
function ajaxFunctionForAutoCompletePVMS(formName,action) {
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

	        var pvmsNo  = item.getElementsByTagName("pvms")[0];
	        var itemId  = item.getElementsByTagName("id")[0];
        	document.getElementById('pvmsNo').value = pvmsNo.childNodes[0].nodeValue
        	document.getElementById('itemId').value = itemId.childNodes[0].nodeValue

      	}
      }
    }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }

  function ajaxFunctionForAutoCompleteChargeCodeCode(formName,action) {
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

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('chargeCodes')[0];

      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var chargeCode = chargeCodes.childNodes[loop];

	        var chargeCodeCode  = chargeCode.getElementsByTagName("chargeCodeCode")[0];
	        var chargeCodeId  = chargeCode.getElementsByTagName("id")[0];
        	document.getElementById('chargeCodeCode').value = chargeCodeCode.childNodes[0].nodeValue
        	document.getElementById('chargeCodeId').value = chargeCodeId.childNodes[0].nodeValue

      	}
      }
    }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }
// Get Chargeable Amount Based on charge selection
  
  function populateChargeAmout() {
	  var chargeId=document.getElementById("registrationTypeId").value;
	
	 
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

	       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
	    

	       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	 	   	    var item = chargeCodes.childNodes[loop];
	 	   	 var ChargeableAmount  = item.getElementsByTagName("Charge")[0];
	 	  //  alert(ChargeableAmount.childNodes[0].nodeValue);
	 	       	document.getElementById("amountId").value=ChargeableAmount.childNodes[0].nodeValue
	 	   	document.getElementById("balanceToBePaidId").value=ChargeableAmount.childNodes[0].nodeValue
	 	   document.getElementById("amountTenderedId").value=ChargeableAmount.childNodes[0].nodeValue
	 	   
	 	   var schemeId=document.getElementById('VisitschemeId').value;
	 	       	if(scheme>0){
	 	       //	Visitscheme(schemeId,chargeId)
	 	       		
	 	       	}

	 	       
	       	}
	       }
	     }
	     if(chargeId>0){
	     xmlHttp.open("GET","/hms/hms/registration?method=populateChargeAmout&chargeId="+chargeId+'&'+csrfTokenName+'='+csrfTokenValue,true);
	  	
	     }
	     else{
	    	 document.getElementById("amountId").value="0.0";
	 	  	document.getElementById("balanceToBePaidId").value="0.0";
	 		document.getElementById("amountTenderedId").value="0.0";
	 		document.getElementById("discountPercentText").value="";
	 		document.getElementById("discountPerAmountTextId").value="";
	 		document.getElementById("revisedCreditBalanceId").value="";
	 		
	     }
	     xmlHttp.setRequestHeader("Content-Type", "text/xml");
	     xmlHttp.send(null);

	   }

  //------------------ Added by VIvek on 01-06-2009 -------------------

    function populatePostOff(blockId) {
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

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
   obj =document.getElementById("postOff");
   obj.length = 1;

      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	   	 var VillageName  = item.getElementsByTagName("VillageName")[0];
	        var VillageId  = item.getElementsByTagName("VillageId")[0];
	        var pincode  = item.getElementsByTagName("pincode")[0];
	        obj.length++;
				obj.options[obj.length-1].value=VillageId.childNodes[0].nodeValue
				obj.options[obj.length-1].text=VillageName.childNodes[0].nodeValue
				document.getElementById("pinCodeId").value=pincode.childNodes[0].nodeValue

	       
      	}
      }
    }
    xmlHttp.open("GET","/hms/hms/registration?method=populatePostOff&blockId="+blockId+'&'+csrfTokenName+'='+csrfTokenValue,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }
    
  // Pupulate taluk list on select of district
    
    function populsubDistrictByDistrictId(districtId) {
    	
    	//alert("check "+districtId);
    	if(document.getElementById("pincode"))
    	document.getElementById("pincode").value="";
        var xmlHttp=null;
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
       var objSubCityId =document.getElementById("SubcityId");
       if(objSubCityId!=null){
    	   objSubCityId.length = 1; 
       }
       
      
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){
        	
          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	   	 var TalukName  = item.getElementsByTagName("TalukName")[0];
 	        var TalukId  = item.getElementsByTagName("TalukId")[0];
 	      if(objSubCityId!=null){
 	    	 objSubCityId.length++;
 	 	    
 	 	      objSubCityId.options[objSubCityId.length-1].value=TalukId.childNodes[0].nodeValue
 	 	     objSubCityId.options[objSubCityId.length-1].text= TalukName.childNodes[0].nodeValue 
 	      }
 				
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populsubDistrictByDistrictId&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
       // populateAPincodeByDistrict(districtId);
      }
    
    function donorDistrictByDistrictId(districtId) {
    	/*alert("check "+districtId);*/
    	//document.getElementById("pincode").value="";
        var xmlHttp=null;
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
       obj =document.getElementById("subdistrictId");
       obj.length = 1;
      
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){
        	
          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	   	 var TalukName  = item.getElementsByTagName("TalukName")[0];
 	        var TalukId  = item.getElementsByTagName("TalukId")[0];
 	      
 	        obj.length++;
 	    
 				obj.options[obj.length-1].value=TalukId.childNodes[0].nodeValue
 				obj.options[obj.length-1].text= TalukName.childNodes[0].nodeValue
 				
          	}
          
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populsubDistrictByDistrictId&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
       // populateAPincodeByDistrict(districtId);
      }
    
    
    
function searchbloodBankDistrictByDistrictId(districtId) {
    	
    	//document.getElementById("pincode").value="";
        var xmlHttp=null;
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
       obj =document.getElementById("stalukId");
       obj.length = 1;
      
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){
        	
          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	   	 var TalukName  = item.getElementsByTagName("TalukName")[0];
 	        var TalukId  = item.getElementsByTagName("TalukId")[0];
 	      
 	        obj.length++;
 	    
 				obj.options[obj.length-1].value=TalukId.childNodes[0].nodeValue
 				obj.options[obj.length-1].text= TalukName.childNodes[0].nodeValue
 				
          	}
          
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populsubDistrictByDistrictId&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
       // populateAPincodeByDistrict(districtId);
      }
    
    function bloodBankDistrictByDistrictId(districtId) {
    	
    	//document.getElementById("pincode").value="";
        var xmlHttp=null;
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
       obj =document.getElementById("SubcityId");
       obj.length = 1;
      
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){
        	
          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	   	 var TalukName  = item.getElementsByTagName("TalukName")[0];
 	        var TalukId  = item.getElementsByTagName("TalukId")[0];
 	      
 	        obj.length++;
 	    
 				obj.options[obj.length-1].value=TalukId.childNodes[0].nodeValue
 				obj.options[obj.length-1].text= TalukName.childNodes[0].nodeValue
 				
          	}
          
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populsubDistrictByDistrictId&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
       // populateAPincodeByDistrict(districtId);
      }
    // populate Pincode By District
    function populateAPincodeByDistrict(districtId) {
    	//alert("hii "+districtId);
    var xmlHttp=null;
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
   var objPostOff =document.getElementById("postOff");
   if(objPostOff!=null){
	   objPostOff.length = 1;
   }
   
  
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];

	   	 var pPostName  = item.getElementsByTagName("PostName")[0];
	        var pPostId  = item.getElementsByTagName("PostId")[0];
	      if(objPostOff!=null){
	    	  objPostOff.length++;
	 	     
      		if(pPostId.childNodes[0] !=undefined){
      			objPostOff.options[objPostOff.length-1].value=pPostId.childNodes[0].nodeValue
      			objPostOff.options[objPostOff.length-1].text= pPostName.childNodes[0].nodeValue  
	      }
	        
      	}
      	}
      }
    }
    xmlHttp.open("GET","/hms/hms/registration?method=populatePincodeByDistrict&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }
    
    function donorPincodeByDistrict(districtId) {
    	//alert("hii "+districtId);
    var xmlHttp=null;
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
   obj =document.getElementById("postOfficeId");
   obj.length = 1;
  
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];

	   	 var pPostName  = item.getElementsByTagName("PostName")[0];
	        var pPostId  = item.getElementsByTagName("PostId")[0];
	      
	        obj.length++;
	     
	        		if(pPostId.childNodes[0] !=undefined){
				obj.options[obj.length-1].value=pPostId.childNodes[0].nodeValue
				obj.options[obj.length-1].text= pPostName.childNodes[0].nodeValue
      	}
      	}
      }
    }
    xmlHttp.open("GET","/hms/hms/registration?method=populatePincodeByDistrict&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }


    function populatePPincodeByDistrict(districtId) {
    	
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
       obj =document.getElementById("pppostOff");
       obj.length = 1;
      
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	   	 var PostName  = item.getElementsByTagName("PostName")[0];
    	        var PostId  = item.getElementsByTagName("PostId")[0];
    	      
    	        obj.length++;
    	       
    				obj.options[obj.length-1].value=PostId.childNodes[0].nodeValue
    				obj.options[obj.length-1].text= PostName.childNodes[0].nodeValue
    				
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populatePincodeByDistrict&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }

    
 function updatePincodeByDistrict(districtId) {
    	
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
       obj =document.getElementById("tempPostOff");
       obj.length = 1;
      
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	   	 var PostName  = item.getElementsByTagName("PostName")[0];
    	        var PostId  = item.getElementsByTagName("PostId")[0];
    	      
    	        obj.length++;
    	       
    				obj.options[obj.length-1].value=PostId.childNodes[0].nodeValue
    				obj.options[obj.length-1].text= PostName.childNodes[0].nodeValue
    				
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=updatePincodeByDistrict&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }

    
    
function populateTPincodeByDistrict(districtId) {
    	
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
       obj =document.getElementById("tpostOff");
       obj.length = 1;
      
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	   	 var PostName  = item.getElementsByTagName("PostName")[0];
    	        var PostId  = item.getElementsByTagName("PostId")[0];
    	      
    	        obj.length++;
    	      
    				obj.options[obj.length-1].value=PostId.childNodes[0].nodeValue
    				obj.options[obj.length-1].text= PostName.childNodes[0].nodeValue
    				
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populatePincodeByDistrict&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }

function lsgByDistrict(lsgId,districtId) {
	
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
   obj =document.getElementById(lsgId);
   obj.length = 1;
  
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];

	   	 var lsgName  = item.getElementsByTagName("lsgName")[0];
	        var lsgId  = item.getElementsByTagName("lsgId")[0];
	      
	        obj.length++;
	      
				obj.options[obj.length-1].value=lsgId.childNodes[0].nodeValue
				obj.options[obj.length-1].text= lsgName.childNodes[0].nodeValue
				
      	}
      }
    }
    xmlHttp.open("GET","/hms/hms/registration?method=lsgByDistrict&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }

    function permanentsubDistrictByDistrictId(districtId) {
    	document.getElementById("ppincode").value="";
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
     
       objtaluk =document.getElementById("talukId");
       objtaluk.length = 1;
      
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	   	 var TalukName  = item.getElementsByTagName("TalukName")[0];
 	        var TalukId  = item.getElementsByTagName("TalukId")[0];
 	      
 	      
 	       objtaluk.length++;
 	     
 				objtaluk.options[objtaluk.length-1].value=TalukId.childNodes[0].nodeValue
 				objtaluk.options[objtaluk.length-1].text= TalukName.childNodes[0].nodeValue
 				
 				
          	}
          }
        }
        document.getElementById('pWardId').length=1;
        document.getElementById('locality').length=1;
        
        xmlHttp.open("GET","/hms/hms/registration?method=populsubDistrictByDistrictId&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }
    
 function tempsubDistrictByDistrictId(districtId) {
	 document.getElementById("pincodeID").value="";
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
      
       objttaluk=document.getElementById("ttalukId");
       objttaluk.length = 1;
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	   	 var TalukName  = item.getElementsByTagName("TalukName")[0];
 	        var TalukId  = item.getElementsByTagName("TalukId")[0];
 	      
 	      objttaluk.length++;
 				
 				 objttaluk.options[objttaluk.length-1].value=TalukId.childNodes[0].nodeValue
 				 objttaluk.options[objttaluk.length-1].text= TalukName.childNodes[0].nodeValue
          	}
          }
        }
        document.getElementById('wardId').length=1;
        document.getElementById('Tlocality').length=1;
        
        xmlHttp.open("GET","/hms/hms/registration?method=populsubDistrictByDistrictId&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }
    

    //
    
 function updateTalukByDistrictId(districtId) {
    	
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
       obj =document.getElementById("updatetalukId");
       obj.length = 1;
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	   	 var TalukName  = item.getElementsByTagName("TalukName")[0];
 	        var TalukId  = item.getElementsByTagName("TalukId")[0];
 	      
 	        obj.length++;
 				obj.options[obj.length-1].value=TalukId.childNodes[0].nodeValue
 				obj.options[obj.length-1].text= TalukName.childNodes[0].nodeValue
 				
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populsubDistrictByDistrictId&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }
    
 function updatePermanentTalukByDistrictId(districtId) {
 	
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
   
    objTaluk =document.getElementById("talukId");
    objTaluk.length = 1;
    
    
    
     xmlHttp.onreadystatechange=function()
     {
       if(xmlHttp.readyState==4){

       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];

 	   	 var TalukName  = item.getElementsByTagName("TalukName")[0];
	        var TalukId  = item.getElementsByTagName("TalukId")[0];
	      
	      
	       objTaluk.length++;
				objTaluk.options[objTaluk.length-1].value=TalukId.childNodes[0].nodeValue
				objTaluk.options[objTaluk.length-1].text= TalukName.childNodes[0].nodeValue
       	}
       }
     }
     xmlHttp.open("GET","/hms/hms/registration?method=populsubDistrictByDistrictId&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
   }
 
 function updateVillageOfTaluk(talukId) {
 	
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
    obj =document.getElementById("villageId");
    obj.length = 1;
    
     xmlHttp.onreadystatechange=function()
     {
       if(xmlHttp.readyState==4){

       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];

 	        var VillageName  = item.getElementsByTagName("VillageName")[0];
 	        var VillageId  = item.getElementsByTagName("VillageId")[0];
 	       /* var pincode  = item.getElementsByTagName("pincode")[0];*/
 	        obj.length++;
 				obj.options[obj.length-1].value=VillageId.childNodes[0].nodeValue
 				obj.options[obj.length-1].text=VillageName.childNodes[0].nodeValue
 				
       	}
       }
     }
     xmlHttp.open("GET","/hms/hms/registration?method=populateVillageBytaluk&talukId="+talukId+'&'+csrfTokenName+'='+csrfTokenValue,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
   }
    
 function updatePermanentVillageOfTaluk(talukId) {
	 	
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
   
    objLocality =document.getElementById("localityId");
    objLocality.length = 1;
    
     xmlHttp.onreadystatechange=function()
     {
       if(xmlHttp.readyState==4){

       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];

 	        var VillageName  = item.getElementsByTagName("VillageName")[0];
 	        var VillageId  = item.getElementsByTagName("VillageId")[0];
 	       /* var pincode  = item.getElementsByTagName("pincode")[0];*/
 	       
 				objLocality.length++;
 				objLocality.options[objLocality.length-1].value=VillageId.childNodes[0].nodeValue
 				objLocality.options[objLocality.length-1].text=VillageName.childNodes[0].nodeValue
 				/*document.getElementById("pinCodeId").value=pincode.childNodes[0].nodeValue*/
       	}
       }
     }
     xmlHttp.open("GET","/hms/hms/registration?method=populateVillageBytaluk&talukId="+talukId+'&'+csrfTokenName+'='+csrfTokenValue,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
   }
    
 function updatePostOffice(villageId) {
 	
 	
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
    obj =document.getElementById("postOffId");
    obj.length = 1;
   
     xmlHttp.onreadystatechange=function()
     {
     	
       if(xmlHttp.readyState==4){
       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];
 	        var postOffice  = item.getElementsByTagName("postOffice")[0];
 	        var postId  = item.getElementsByTagName("postId")[0];
 	        obj.length++;
 	        obj.options[obj.length-1].text= postOffice.childNodes[0].nodeValue
			obj.options[obj.length-1].value= postId.childNodes[0].nodeValue	
       	}
       }
     }
     if(villageId>0)
     xmlHttp.open("GET","/hms/hms/registration?method=populatePostOffice&villageId="+villageId+'&'+csrfTokenName+'='+csrfTokenValue,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
   }
 
 
 function updatePermanentPostOffice(villageId) {
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
   
    objPermanentPost =document.getElementById("permanentPostOff");
    objPermanentPost.length = 1;
    
     xmlHttp.onreadystatechange=function()
     {
     	
       if(xmlHttp.readyState==4){

       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
       	
       	
       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];
 	   	 
 	   	 
 	        var postOffice  = item.getElementsByTagName("postOffice")[0];
 	        var postId  = item.getElementsByTagName("postId")[0];
 	       
 	        
 	       
				objPermanentPost.length++;
 	       objPermanentPost.options[objPermanentPost.length-1].text= postOffice.childNodes[0].nodeValue
 	      objPermanentPost.options[objPermanentPost.length-1].value= postId.childNodes[0].nodeValue
 	       
 	       
       	}
       }
     }
     if(villageId>0)
     xmlHttp.open("GET","/hms/hms/registration?method=populatePostOffice&villageId="+villageId+'&'+csrfTokenName+'='+csrfTokenValue,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
   }
 
 
 function updatePinCode(postOffId) {
 	
 	
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
    /*obj =document.getElementById("patientDistId");
    obj.length = 1;*/
     xmlHttp.onreadystatechange=function()
     {
     	
       if(xmlHttp.readyState==4){

       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
      
       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];
 	        var pincode1  = item.getElementsByTagName("pincode")[0];
 	    document.getElementById("pincodeNumberId").value=pincode1.childNodes[0].nodeValue
 				
       	}
       }
     }
     xmlHttp.open("GET","/hms/hms/registration?method=populateVillage&postOffId="+postOffId+'&'+csrfTokenName+'='+csrfTokenValue,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
   }
 function updatePermanentPinCode(postOffId) {
	 	
	 	
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

       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];
 	        var pincode1  = item.getElementsByTagName("pincode")[0];
 				document.getElementById("permanentPincode").value=pincode1.childNodes[0].nodeValue
       	}
       }
     }
     xmlHttp.open("GET","/hms/hms/registration?method=populateVillage&postOffId="+postOffId+'&'+csrfTokenName+'='+csrfTokenValue,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
   }
 // 
 function updateTempTalukByDistrictId(districtId) {
 	
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
    obj =document.getElementById("ttalukId");
    obj.length = 1;
     xmlHttp.onreadystatechange=function()
     {
       if(xmlHttp.readyState==4){

       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];

 	   	 var TalukName  = item.getElementsByTagName("TalukName")[0];
	        var TalukId  = item.getElementsByTagName("TalukId")[0];
	      
	        obj.length++;
				obj.options[obj.length-1].value=TalukId.childNodes[0].nodeValue
				obj.options[obj.length-1].text= TalukName.childNodes[0].nodeValue
				
       	}
       }
     }
     xmlHttp.open("GET","/hms/hms/registration?method=populsubDistrictByDistrictId&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
   }
 //
 //
 function updateTempVillageOfTaluk(talukId) {
	 	
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
   
    objLocality =document.getElementById("templocality");
    objLocality.length = 1;
    
     xmlHttp.onreadystatechange=function()
     {
       if(xmlHttp.readyState==4){

       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];

 	        var VillageName  = item.getElementsByTagName("VillageName")[0];
 	        var VillageId  = item.getElementsByTagName("VillageId")[0];
 	       /* var pincode  = item.getElementsByTagName("pincode")[0];*/
 	       
 				objLocality.length++;
 				objLocality.options[objLocality.length-1].value=VillageId.childNodes[0].nodeValue
 				objLocality.options[objLocality.length-1].text=VillageName.childNodes[0].nodeValue
 				/*document.getElementById("pinCodeId").value=pincode.childNodes[0].nodeValue*/
       	}
       }
     }
     xmlHttp.open("GET","/hms/hms/registration?method=populateVillageBytaluk&talukId="+talukId+'&'+csrfTokenName+'='+csrfTokenValue,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
   }
 //
 //
 
 function updateTempPostOffice(villageId) {
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
   
    objPermanentPost =document.getElementById("tempPostOff");
    objPermanentPost.length = 1;
    
     xmlHttp.onreadystatechange=function()
     {
     	
       if(xmlHttp.readyState==4){

       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
       	
       	
       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];
 	   	 
 	   	 
 	        var postOffice  = item.getElementsByTagName("postOffice")[0];
 	        var postId  = item.getElementsByTagName("postId")[0];
 	       
 	        
 	       
				objPermanentPost.length++;
 	       objPermanentPost.options[objPermanentPost.length-1].text= postOffice.childNodes[0].nodeValue
 	      objPermanentPost.options[objPermanentPost.length-1].value= postId.childNodes[0].nodeValue
 	       
 	       
       	}
       }
     }
     if(villageId>0)
     xmlHttp.open("GET","/hms/hms/registration?method=populatePostOffice&villageId="+villageId+'&'+csrfTokenName+'='+csrfTokenValue,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
   }
 
 
 // 
 function updateTempPinCode(postOffId) {
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

       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];
 	        var pincode1  = item.getElementsByTagName("pincode")[0];
 				document.getElementById("tempPincode").value=pincode1.childNodes[0].nodeValue
       	}
       }
     }
     xmlHttp.open("GET","/hms/hms/registration?method=populateVillage&postOffId="+postOffId+'&'+csrfTokenName+'='+csrfTokenValue,true);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
   }
 
// Pupulate ward based on taluk 
    
    function populateWardOnTaluk(talukId) {
    	
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
       obj =document.getElementById("SubcityId");
       obj.length = 1;
       
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	   	 var TalukName  = item.getElementsByTagName("TalukName")[0];
 	        var TalukId  = item.getElementsByTagName("TalukId")[0];
 	      
 	        obj.length++;
 	      
 				obj.options[obj.length-1].value=TalukId.childNodes[0].nodeValue
 				obj.options[obj.length-1].text= TalukName.childNodes[0].nodeValue
 				
 				
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populateWardOnTaluk&talukId="+talukId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }
    
    
    
function populatePostOffice(villageId) {
    	
    	
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
       obj =document.getElementById("postOff");
      
       obj.length = 1;
        xmlHttp.onreadystatechange=function()
        {
        	
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
          	
          	
          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];
    	   	 
    	   	 
    	        var postOffice  = item.getElementsByTagName("postOffice")[0];
    	        var postId  = item.getElementsByTagName("postId")[0];
    	       
    	        
    	        obj.length++;
    	        
    	       
    	        obj.options[obj.length-1].text= postOffice.childNodes[0].nodeValue
 				obj.options[obj.length-1].value= postId.childNodes[0].nodeValue
    	       
    	       
          	}
          }
        }
        if(villageId>0)
        xmlHttp.open("GET","/hms/hms/registration?method=populatePostOffice&villageId="+villageId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }
    
 // populate vilage town on district id   
function populateAadhaarVillageTown(districtId) {
	
	
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
   obj =document.getElementById("villageId");
  if(obj!=null){
	  obj.length = 1;
  }
   
    xmlHttp.onreadystatechange=function()
    {
    	
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	
      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	   	 
	   	 
	        var villageName  = item.getElementsByTagName("VillageName")[0];
	        var villageId  = item.getElementsByTagName("VillageId")[0];
	       
	        if(obj!=null){
	        	 obj.length++;
	 	        
	 	        obj.options[obj.length-1].text= villageName.childNodes[0].nodeValue
	 				obj.options[obj.length-1].value= villageId.childNodes[0].nodeValue
	        }
	       
      	}
      }
    }
    
    xmlHttp.open("GET","/hms/hms/registration?method=populateVillageTown&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }


// populate vilage town on district id   
function populateSubCenterByHospital(districtId) {
	//alert(districtId);
	
	
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
   obj =document.getElementById("nativeSubCentre");
  
   obj.length = 1;
    xmlHttp.onreadystatechange=function()
    {
    	
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	
      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	   	 
	   	 
	        var hospitalName  = item.getElementsByTagName("hospitalName")[0];
	        var hosid  = item.getElementsByTagName("hosid")[0];
	       
	        
	        obj.length++;
	        
	       
	        obj.options[obj.length-1].text= hospitalName.childNodes[0].nodeValue
				obj.options[obj.length-1].value= hosid.childNodes[0].nodeValue
	       
	       
      	}
      }
    }
    
    xmlHttp.open("GET","/hms/hms/registration?method=populateSubCenterByHospital&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }



    
//populate pincode on select of post office
    function populatePinCode(postOffId) {
    	
    	
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
       /*obj =document.getElementById("patientDistId");
       obj.length = 1;*/
        xmlHttp.onreadystatechange=function()
        {
        	
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
          	
          	
          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];
    	   	 
    	   	 
    	       /* var VillageName  = item.getElementsByTagName("VillageName")[0];
    	        var VillageId  = item.getElementsByTagName("VillageId")[0];*/
    	        var pincode1  = item.getElementsByTagName("pincode")[0];
    	       
    	       /* obj.length++;*/
    				/*obj.options[obj.length-1].value=VillageId.childNodes[0].nodeValue
    				obj.options[obj.length-1].text=VillageName.childNodes[0].nodeValue*/
    	        if(pincode1.childNodes[0].nodeValue > 0) {
    				document.getElementById("pincode").value=pincode1.childNodes[0].nodeValue
    	        } else {
    	        	document.getElementById("pincode").value=""
    	        }
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populateVillage&postOffId="+postOffId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }
    
function donorpopulatePinCode(postOffId) {
    	
    	
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
       /*obj =document.getElementById("patientDistId");
       obj.length = 1;*/
        xmlHttp.onreadystatechange=function()
        {
        	
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
          	
          	
          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];
    	   	 
    	   	 
    	       /* var VillageName  = item.getElementsByTagName("VillageName")[0];
    	        var VillageId  = item.getElementsByTagName("VillageId")[0];*/
    	        var pincode1  = item.getElementsByTagName("pincode")[0];
    	       
    	       /* obj.length++;*/
    				/*obj.options[obj.length-1].value=VillageId.childNodes[0].nodeValue
    				obj.options[obj.length-1].text=VillageName.childNodes[0].nodeValue*/
    				document.getElementById("pincodeId").value=pincode1.childNodes[0].nodeValue
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populateVillage&postOffId="+postOffId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }
function componentQuantity(componentId) {
	
	alert(componentId);
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
   /*obj =document.getElementById("patientDistId");
   obj.length = 1;*/
    xmlHttp.onreadystatechange=function()
    {
    	
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	
      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	   	
	        var pincode1  = item.getElementsByTagName("quantity")[0];
	       
	     
				document.getElementById("compquantityID").value=pincode1.childNodes[0].nodeValue
      	}
      }
    }
    xmlHttp.open("GET","/hms/hms/bloodBank?method=componentQuantity&componentId="+componentId+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }

    //
 function populatePinCodeForPost(postOffId) {
    	
    	
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
       /*obj =document.getElementById("patientDistId");
       obj.length = 1;*/
        xmlHttp.onreadystatechange=function()
        {
        	
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
          	
          	
          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];
    	   	 
    	   	 
    	       /* var VillageName  = item.getElementsByTagName("VillageName")[0];
    	        var VillageId  = item.getElementsByTagName("VillageId")[0];*/
    	        var pincode1  = item.getElementsByTagName("pincode")[0];
    	       
    	       /* obj.length++;*/
    				/*obj.options[obj.length-1].value=VillageId.childNodes[0].nodeValue
    				obj.options[obj.length-1].text=VillageName.childNodes[0].nodeValue*/
    	        if(pincode1.childNodes[0].nodeValue > 0) {
    				document.getElementById("ppincode").value=pincode1.childNodes[0].nodeValue
    	        } else {
    	        	document.getElementById("ppincode").value=""
    	        }
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populateVillage&postOffId="+postOffId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }
    function popuVillage(postOffId) {
    	
    	
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
   /*obj =document.getElementById("patientDistId");
   obj.length = 1;*/
    xmlHttp.onreadystatechange=function()
    {
    	
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	
      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	   	 
	   	 
	       /* var VillageName  = item.getElementsByTagName("VillageName")[0];
	        var VillageId  = item.getElementsByTagName("VillageId")[0];*/
	        var pincode1  = item.getElementsByTagName("pincode")[0];
	       
	       /* obj.length++;*/
				/*obj.options[obj.length-1].value=VillageId.childNodes[0].nodeValue
				obj.options[obj.length-1].text=VillageName.childNodes[0].nodeValue*/
	        if(pincode1.childNodes[0].nodeValue > 0 ) {
				document.getElementById("pincodeID").value=pincode1.childNodes[0].nodeValue
	        } else {
	        	document.getElementById("pincodeID").value=""
	        }
      	}
      }
    }
    xmlHttp.open("GET","/hms/hms/registration?method=populateVillage&postOffId="+postOffId+'&'+csrfTokenName+'='+csrfTokenValue,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }


    /*
     * Code for papulate village from district
     * code by mukesh narayan singh
     * date 12 july 2010
     */
    function populateVillageFromDist(districtId) {
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
       obj =document.getElementById("patientDistId");
       obj.length = 1;
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	        var TalukName  = item.getElementsByTagName("TalukName")[0];
    	        var TalukId  = item.getElementsByTagName("TalukId")[0];
    	       
    	        obj.length++;
    				obj.options[obj.length-1].value=TalukId.childNodes[0].nodeValue
    				obj.options[obj.length-1].text=TalukName.childNodes[0].nodeValue
    				document.getElementById("pinCodeId").value=pincode.childNodes[0].nodeValue
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populateVillageFromDist&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }
    /*
     * Code for papulate district based on State
     * 
     * 
     */
    function populateDistByState(stateId) {
    	/*alert("hiiiii");*/
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
       obj =document.getElementById("migrantCityId");
       obj.length = 1;
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	        var DistrictName  = item.getElementsByTagName("DistrictName")[0];
    	        var DistrictId  = item.getElementsByTagName("DistrictId")[0];
    	       
    	        obj.length++;
    				obj.options[obj.length-1].value=DistrictId.childNodes[0].nodeValue
    				obj.options[obj.length-1].text=DistrictName.childNodes[0].nodeValue
    				/*document.getElementById("pinCodeId").value=pincode.childNodes[0].nodeValue*/
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populateDistByState&stateId="+stateId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }
    /*
     * Code for papulate village from taluk
     * 
     * 
     */
    function populateVillageOfTaluk(talukId) {
    	
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
       obj =document.getElementById("villageId");
       obj.length = 1;
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	        var VillageName  = item.getElementsByTagName("VillageName")[0];
    	        var VillageId  = item.getElementsByTagName("VillageId")[0];
    	       /* var pincode  = item.getElementsByTagName("pincode")[0];*/
    	        obj.length++;
    				obj.options[obj.length-1].value=VillageId.childNodes[0].nodeValue
    				obj.options[obj.length-1].text=VillageName.childNodes[0].nodeValue
    				/*document.getElementById("pinCodeId").value=pincode.childNodes[0].nodeValue*/
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populateVillageBytaluk&talukId="+talukId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }
    /*
     * Code for papulate village from district
     * code by mukesh narayan singh
     * date 12 july 2010
     */

    function populateVillageOfBlock(blockId) {
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
       obj =document.getElementById("patientDistId");
       obj.length = 1;
        xmlHttp.onreadystatechange=function()
        {
          if(xmlHttp.readyState==4){

          	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

          	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
    	   	    var item = chargeCodes.childNodes[loop];

    	        var VillageName  = item.getElementsByTagName("VillageName")[0];
    	        var VillageId  = item.getElementsByTagName("VillageId")[0];
    	        var pincode  = item.getElementsByTagName("pincode")[0];
    	        obj.length++;
    				obj.options[obj.length-1].value=VillageId.childNodes[0].nodeValue
    				obj.options[obj.length-1].text=VillageName.childNodes[0].nodeValue
    				document.getElementById("pinCodeId").value=pincode.childNodes[0].nodeValue
          	}
          }
        }
        xmlHttp.open("GET","/hms/hms/registration?method=populateVillageOfBlock&blockId="+blockId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);
      }

function submitProtoAjaxForCheckBatchAvailability(formName,action){
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
      	if(items.childNodes.length!=0){

      	for (loop = 0; loop < items.childNodes.length; loop++) {

	   	 var item = items.childNodes[loop];
	   	      var message = item.getElementsByTagName("message")[0];
	   		 if(message.childNodes[0] == undefined)
	       {
	     	  submitForm('billDispensing','opBilling?method=submitBillDispensingDetails','validatePaymentAmt','validateChequeAndCreditCardDate');
	       }else{
	       		alert(message.childNodes[0].nodeValue);
	       }

	   	  }
	   	  }

      }
    }

    var counter = document.getElementById('totalBatchId').value;
    var url=action+"&counter="+counter;
    for(var i=1;i<=counter;i++){
    		if(document.getElementById('batchId'+i))
    			url += "&batchId"+i+"="+document.getElementById('batchId'+i).value+"&qty"+i+"="+document.getElementById('issueQtyId'+i).value;

    }
    xmlHttp.open("GET",url+'&'+csrfTokenName+'='+csrfTokenValue,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }




  //-------Function for blood donor By dipali
 function ajaxFunctionForDonor(formName,uhid) {
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
	   	    var donorName =  item.getElementsByTagName("donorName")[0];
	        var age = item.getElementsByTagName("age")[0];
	        var teleNo = item.getElementsByTagName("teleNo")[0];
	        var mobNo = item.getElementsByTagName("mobNo")[0];
	    //    var stateId = item.getElementsByTagName("stateId")[0];
	   	    var occupId = item.getElementsByTagName("occupId")[0];
	   	 var uId = item.getElementsByTagName("uidNo")[0];
	   	var idNo=item.getElementsByTagName("idNo")[0];
	   	    var sexId = item.getElementsByTagName("sexId")[0];
	        var bloodGroupId = item.getElementsByTagName("bloodGroupId")[0];
        	var ableForDonation = item.getElementsByTagName("ableForDonation")[0];
        	 var fatherName = item.getElementsByTagName("fatherName")[0];
        	 var organization = item.getElementsByTagName("organization")[0];
        	 var emailId = item.getElementsByTagName("emailId")[0];
        	 var pincodeId = item.getElementsByTagName("pincodeId")[0];
        	 var landmark=item.getElementsByTagName("landmark")[0];
        	 var streetNo=item.getElementsByTagName("streetNo")[0];
         	/*if(ableForDonation.childNodes[0].nodeValue == "no"){
         		alert("Person is not able to donate blood.");
         		document.getElementById('hinNo').value = "";
         		document.getElementById('donorName').value = "";
         		document.getElementById('occupId').value = "0";
         		document.getElementById('sexId').value = "0";
         		document.getElementById('age').value = "";
         		document.getElementById('stateId').value = "0";
         		return false;
         	}
*/
        	document.getElementById('uidNo').value = uId.childNodes[0].nodeValue
        	document.getElementById('donorName').value = donorName.childNodes[0].nodeValue
        	document.getElementById('age').value = age.childNodes[0].nodeValue.substring(0,(age.childNodes[0].nodeValue.indexOf(" ") ));
        	document.getElementById('sexId').value = sexId.childNodes[0].nodeValue
        	document.getElementById("mobNo").value=mobNo.childNodes[0].nodeValue;
        	document.getElementById("idNo").value=idNo.childNodes[0].nodeValue;
        	
        	document.getElementById("fatherName").value=fatherName.childNodes[0].nodeValue;
        	document.getElementById("organization").value=organization.childNodes[0].nodeValue;
        	document.getElementById("bloodGroupId").value=bloodGroupId.childNodes[0].nodeValue;
        	
        	document.getElementById('emailId').value = emailId.childNodes[0].nodeValue
        	document.getElementById('pincodeId').value = pincodeId.childNodes[0].nodeValue
        	document.getElementById('landmark').value = landmark.childNodes[0].nodeValue
        	document.getElementById('streetNo').value = streetNo.childNodes[0].nodeValue
        	//document.getElementById("stateId").value=stateId.childNodes[0].nodeValue;

		  	  
		     
        	if(teleNo.childNodes[0] != undefined){
	        	document.getElementById('teleNo').value = teleNo.childNodes[0].nodeValue;
	        }

        	document.getElementById('occupId').value = occupId.childNodes[0].nodeValue
        	/*var obj1=	document.getElementById("sexId");
	  	    for(var i=0;i<obj1.length;i++){
	   		try
	   		{
		      if(obj1.options[i].value==sexId.childNodes[0].nodeValue)
		      {
		    	      obj1.options[i].selected = true;

		      }
	      	}
	      	catch(e){

	      	}
	      }*/

        	document.getElementById('bloodGroupId').value = bloodGroupId.childNodes[0].nodeValue
        	document.getElementById('mobNo').value = mobNo.childNodes[0].nodeValue

      	}
      }
      }
    	if(document.getElementById("uidNo")){
    		
    		var uidNo=document.getElementById("uidNo").value;
    		xmlHttp.open("GET",'bloodBank?method=fillDonorDetail&uId='+document.getElementById("uidNo").value+'&'+csrfTokenName+'='+csrfTokenValue,true);	
    	}
    	if(uhid !=null){
    	
    		xmlHttp.open("GET",'bloodBank?method=fillDonorDetail&donoruId='+uhid+'&'+csrfTokenName+'='+csrfTokenValue,true);	
    	}
    	
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }

    function ajaxFunctionForAutoCompleteComponentNameForSeparition(formName,action,rowVal) {
    	//alert(formName)
    //	alert(action)
    	//alert(rowVal)
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
	        var componentId  = item.getElementsByTagName("componentId")[0];
	      var componentCode  = item.getElementsByTagName("componentCode")[0];
	        var quantity =  item.getElementsByTagName("quantity")[0];
	      document.getElementById('componentCode'+rowVal).value =  componentCode.childNodes[0].nodeValue
	        document.getElementById('quantity'+rowVal).value =  quantity.childNodes[0].nodeValue
	        document.getElementById('bloodComponentId'+rowVal).value = componentId.childNodes[0].nodeValue
      	}
      }
      }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }

  function ajaxFunctionForAutoCompleteComponentName(formName,action,rowVal) {
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
	        var componentId  = item.getElementsByTagName("componentId")[0];
	        var quantity =  item.getElementsByTagName("quantity")[0];
	       
	        
	        document.getElementById('bloodUnit'+rowVal).value =1;
	        document.getElementById('quantity'+rowVal).value =  quantity.childNodes[0].nodeValue
	        document.getElementById('bloodComponentId'+rowVal).value = componentId.childNodes[0].nodeValue
      	}
      }
      }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }

  function ajaxFunctionForAutoCompleteComponentNameForIndent(formName,action,rowVal) {
	 
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
		        var componentId  = item.getElementsByTagName("componentId")[0];
		        var availableStock =  item.getElementsByTagName("availableStock")[0];
		        //document.getElementById('quantity'+rowVal).value =  quantity.childNodes[0].nodeValue
		       // document.getElementById('bloodComponentName'+rowVal).value = componentId.childNodes[0].nodeValue
		       // alert(availableStock.childNodes[0].nodeValue)
		        document.getElementById('availableStockId'+rowVal).value = availableStock.childNodes[0].nodeValue
	      	}
	      }
	      }
	    var url=action+"&"+getNameAndData(formName);
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }
  
   function ajaxFunctionForTestPatient(formName) {
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
	   	    var name =  item.getElementsByTagName("name")[0];
	   	    var hinId = item.getElementsByTagName("hinId")[0];
	   	    var sexId = item.getElementsByTagName("sexId")[0];
	        var age = item.getElementsByTagName("age")[0];
	        var teleNo =  item.getElementsByTagName("teleNo")[0];
	        try{
        		document.getElementById('name').value = name.childNodes[0].nodeValue
        	}catch (e){
        		document.getElementById('name').value = "";
        	}
        	try{
        		document.getElementById('hinId').value = hinId.childNodes[0].nodeValue
        	}catch (e){
        		document.getElementById('hinId').value = "";
        	}
        	try{
        		document.getElementById('sexId').value = sexId.childNodes[0].nodeValue
        	}catch (e){
        		document.getElementById('sexId').value = 0;
        	}
        	try{
        		document.getElementById('age').value = age.childNodes[0].nodeValue
        	}catch (e){
        		document.getElementById('age').value = "";
        	}
        	try{
        		document.getElementById('teleNo').value = teleNo.childNodes[0].nodeValue
        	}catch (e){
        		document.getElementById('teleNo').value = "";
        	}
      	}
      }
      }

    xmlHttp.open("GET",'bloodBank?method=fillTestPatientDetail&hinNo='+document.getElementById("hinNo").value+'&'+csrfTokenName+'='+csrfTokenValue,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }
  function ajaxFunctionForPatient(formName) {
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
	        var donerName =  item.getElementsByTagName("donerName")[0];
	        var hinId =  item.getElementsByTagName("hinId")[0];
	        var bloodGroupId =  item.getElementsByTagName("bloodGroupId")[0];
	         document.getElementById('hinId').value = hinId.childNodes[0].nodeValue
        	document.getElementById('donerName').value = donerName.childNodes[0].nodeValue
        	document.getElementById('bloodGroupId').value = bloodGroupId.childNodes[0].nodeValue
      	}
      }
      }

    xmlHttp.open("GET",'bloodBank?method=fillPatientDetail&hinNo='+document.getElementById("hinNo").value+'&'+csrfTokenName+'='+csrfTokenValue,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }

 function ajaxFunctionForAutoCompleteInvestigationName(formName,action,rowVal) {
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
	        var investigationCodeId  = item.getElementsByTagName("investigationCodeId")[0];
	        document.getElementById('investigationId'+rowVal).value = investigationCodeId.childNodes[0].nodeValue
      	}
      }
      }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }

function ajaxResponseForInpatientId(formName,action,adNo) {

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
	        var inpatientId  = item.getElementsByTagName("inpatientId")[0];
	        alert("inpatientId.childNodes[0].nodeValue-- "+inpatientId.childNodes[0].nodeValue)
	        document.getElementById('inpatientId').value = inpatientId.childNodes[0].nodeValue
      	}
      }
      }
    var url=action+"&adNo="+adNo;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }

/*
 * Code By Mukesh Narayanm Singh
 * Date 7 July 2010
 */

function calculateValidUptoDateInAjax(formName){
	var registrationDate=document.getElementById('registrationDateId').value;
	//alert("date "+document.getElementById('registrationDateId').value)
	var patientTypeId=document.getElementById('patientTypeId').value;
	if(registrationDate != ""){
		action="/hms/hms/registration?method=calculateRegistrationDaysInAjax&registrationDate="+registrationDate+"&patientTypeId="+patientTypeId;
		obj = eval('document.'+formName)
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

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
	        var age  = item.getElementsByTagName("age")[0];
	       obj=eval(document.getElementById('validUpToId'))

		//   var d1 = new Date('2010/06/09');
		// var d2 = (d1.getDate()+30);
		//   document.getElementById('validUpToId').value=d2;
		 calculateDate(age.childNodes[0].nodeValue,registrationDate);

     	}
     }
   }
   var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

   xmlHttp.open("GET",url,true);
   xmlHttp.setRequestHeader("Content-Type", "text/xml");
   xmlHttp.send(null);

   }
}

function calculateDate(dayVal,registrationDate){
       var now=new Date();
		var newdate=new Date();
		var newtimems=newdate.getTime()+(dayVal*24*60*60*1000);
		newdate.setTime(newtimems);
		var month = newdate.getMonth() + 1
	var day = newdate.getDate()
	var year = newdate.getFullYear()
	var validUpToDate;
	day = (day<10)? "0"+day : day
	month = (month<10)? "0"+month : month
	validUpToDate = day+"/"+month+"/"+year;
	document.getElementById('validUpToId').value = validUpToDate;
}


function checkAlergicItemOnSubmit(){

	var tbl = document.getElementById('grid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow-1;

	//var pvmsNo=document.getElementById("pvmsNo"+iteration).value
	var visitId=document.getElementById("visitId").value

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
		        var message  = item.getElementsByTagName("message")[0];

	    	    if(message.childNodes[0] != undefined){
	    	    	  alert(message.childNodes[0].nodeValue)
	    	    	  return false;
		       }else{
		    	   if(validateFieldValues()){
		    		   submitForm('opdMain','opd?method=submitOPDPatientDetails&flag=opd');
		    	   }
		       }

	      	}
	      }
	    }
	      var action = "/hms/hms/opd?method=checkAlergicItemOnSubmit&visitId="+visitId+"&counter="+iteration;
	      for(var i=1;i<=iteration;i++){
	    	  var nomenclature = document.getElementById("nomenclature"+i).value
			  var index1 = nomenclature.lastIndexOf("[");
			  var indexForBrandName=index1;
			  var index2 = nomenclature.lastIndexOf("]");
			  index1++;
    		  var pvmsNo = nomenclature.substring(index1,index2);
    		  action += "&pvmsNo"+i+"="+pvmsNo;
	      }
	    var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	}

//Lab Integration Code With Machine Start 08 Feb 2011 by Ramdular Prajapati +++++


function ajaxFunctionForInvestigationName(formName, rowVal) {
	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
			for (loop = 0; loop < items.childNodes.length; loop++) {
				var item = items.childNodes[loop];
				var investigationId = item
						.getElementsByTagName('investigationId')[0];
				var investigationType = item
						.getElementsByTagName('investigationType')[0];
				var subInvestigationId = investigationId.childNodes[0].nodeValue;
				document.getElementById('investigationId' + rowVal).value = investigationId.childNodes[0].nodeValue
				document.getElementById('investigationType' + rowVal).value = investigationType.childNodes[0].nodeValue
				var invesType = investigationType.childNodes[0].nodeValue;
				if (document.getElementById('investigationType' + rowVal).value == 's') {
					//document.getElementById('subInvestigationName' + rowVal).value="";
					//document.getElementById('subInvestigationName' + rowVal).disabled = true;
					ajaxFunctionForRecordCheck('machineParameter', document
							.getElementById('investigationId' + rowVal).value,rowVal);
				} else
					submitProtoAjaxWithDivName('machineParameter',
							'/hms/hms/lab?method=getSubinvestigationName&rowVal='
									+ rowVal + '&investigationId='
									+ subInvestigationId
									+ '&investigationType=' + invesType,
							'subInv' + rowVal);
			}
		}
	}
	var investigationIdId = "investigationIdId" + rowVal;
	xmlHttp.open("GET", 'lab?method=fillInvestigationType&investigationIdId='
			+ document.getElementById('investigationIdId' + rowVal).value
			+ '&rowVal=' + rowVal+'&'+csrfTokenName+'='+csrfTokenValue, true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}

function ajaxFunctionForRecordCheck(formName, investigationId,inc) {
	var xmlHttp;
	var machineName=document.getElementById("machineName").value;
	var e = document.getElementById("parameterName"+inc);
	var parameterName = e.options[e.selectedIndex].value;
	var e2 = document.getElementById("subInvestigationName"+inc);
	var subInvestigationName = e2.options[e2.selectedIndex].value;
	//alert("subInvestigationName "+subInvestigationName);
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var items1 = xmlHttp.responseXML.getElementsByTagName('items')[0];

			for (loop = 0; loop < items1.childNodes.length; loop++) {
				var item = items1.childNodes[loop];
				var status = item.getElementsByTagName('status')[0];
				var status1 = status.childNodes[0].nodeValue;
				if (status1 == "true"){
					alert("Investigation Name Allready Exists.Please Select Another Name .");
					document.getElementById("investigationIdId"+inc).selectedIndex=0;
				}
			}
		}
	}
	// var investigationIdId ="investigationIdId"+rowVal;
	/*xmlHttp.open("GET",
			'lab?method=fillRecordCheck&investigationId=' + investigationId+'&'+csrfTokenName+'='+csrfTokenValue,
			true);*/
	xmlHttp.open("GET",
			'lab?method=fillRecordCheck&investigationId=' + investigationId+'&subInvestigationId=' + subInvestigationName
			+'&machineName=' + machineName+'&parameterName=' + parameterName+'&'+csrfTokenName+'='+csrfTokenValue,
			true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}

function ajaxFunctionForSubInvestigationName(formName, rowVal) {
	var xmlHttp;
	var machineName=document.getElementById("machineName0").value;
	var e = document.getElementById("parameterName0");
	var parameterName = e.options[e.selectedIndex].value;
	var e1 = document.getElementById("investigationIdId0");
	var investigationIdId = e1.options[e1.selectedIndex].value
	alert("machineName "+machineName+" parameterName "+parameterName+" investigationIdId "+investigationIdId);
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var items1 = xmlHttp.responseXML.getElementsByTagName('items')[0];

			for (loop = 0; loop < items1.childNodes.length; loop++) {
				var item = items1.childNodes[loop];

				var status = item.getElementsByTagName('status')[0];
				var status1 = status.childNodes[0].nodeValue;
				if (status1 == "true")
					alert("Sub Investigation Name Allready Exists.Please Select Another Name");

			}
		}
	}
	var subInvestigationName = "subInvestigationName" + rowVal;
	xmlHttp
			.open(
					"GET",
					'lab?method=fillSubInvestigationType&subInvestigationName='
							+ document
									.getElementById('subInvestigationName' + rowVal).value
									+'&investigationId=' + investigationIdId
									+'&machineName=' + machineName+'&parameterName=' + parameterName+ '&rowVal=' + rowVal+'&'+csrfTokenName+'='+csrfTokenValue, true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}

function ajaxFunctionForDiagnosisNo(formName, rowVal) {
	//alert("row val " + rowVal);
	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var items1 = xmlHttp.responseXML.getElementsByTagName('items')[0];
			for (loop = 0; loop < items1.childNodes.length; loop++) {
				var item = items1.childNodes[loop];
				var status = item.getElementsByTagName('status')[0];
				var status1 = status.childNodes[0].nodeValue;
				if (status1 == "true") {
					// document.getElementById('sampleNo'+rowVal).value ="";
					document.getElementById('diagnosisNo'+rowVal).value ="";
					document.getElementById('serviceNo'+rowVal).value ="";
					document.getElementById('rank'+rowVal).value ="";
					document.getElementById('name'+rowVal).value ="";

					alert("Diagnostic No. AllReady Exists.....   ");


				}else {
					//alert("Diagnostic No. Can't Exists.....   ");
					ajaxFunctionForPatientInfo(formName,rowVal);
				}
			}
		}
	}
	var diagnosisNo = "diagnosisNo" + rowVal;
	xmlHttp.open("GET", 'lab?method=checkDiagnosisNo&diagnosisNo='
			+ document.getElementById('diagnosisNo' + rowVal).value
			+ '&rowVal=' + rowVal+'&'+csrfTokenName+'='+csrfTokenValue, true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}

function ajaxFunctionForPatientInfo(formName,rowVal)
{
    //alert("inside other "+rowVal);
	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {

			var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
			for (loop = 0; loop < items.childNodes.length; loop++) {
				var item = items.childNodes[loop];
				var serviceNo = item.getElementsByTagName("serviceNo")[0];
				var rank = item.getElementsByTagName("rank")[0];
				var name = item.getElementsByTagName("name")[0];
				//document.getElementById('hinId').value = hinId.childNodes[0].nodeValue
				document.getElementById('serviceNo'+rowVal).value = serviceNo.childNodes[0].nodeValue
				document.getElementById('rank'+rowVal).value = rank.childNodes[0].nodeValue
				document.getElementById('name'+rowVal).value = name.childNodes[0].nodeValue
			}
		}
	}

	//alert(" diagnosis "+document.getElementById('diagnosisNo' + rowVal).value);

	xmlHttp.open("GET",
			'lab?method=fillPatientLabDetail&diagnosisNo=' + document
					.getElementById('diagnosisNo'+rowVal).value+'&'+csrfTokenName+'='+csrfTokenValue, true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}


//----------To populate values to registration form added by kishore........//
function ajaxFunctionForPopulatePatientInfo(formName,rowVal)
{
    alert("inside other"+rowVal);
	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {

			var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
			
			for (loop = 0; loop < items.childNodes.length; loop++) {
				var item = items.childNodes[loop];
				alert(items.childNodes[loop]);
				var pAadhaarNumber = item.getElementsByTagName("pAadhaarNumber")[0];
				/*var rank = item.getElementsByTagName("rank")[0];
				var name = item.getElementsByTagName("name")[0];*/
				//document.getElementById('hinId').value = hinId.childNodes[0].nodeValue
				/*document.getElementById('serviceNo'+rowVal).value = serviceNo.childNodes[0].nodeValue
				document.getElementById('rank'+rowVal).value = rank.childNodes[0].nodeValue*/
				document.getElementById('pAadhaarNumberId').value = pAadhaarNumber.childNodes[0].nodeValue
			}
		}
	}

	//alert(" diagnosis "+document.getElementById('diagnosisNo' + rowVal).value);

	xmlHttp.open("GET",
			'registration?method=populatePatientDetailsToRegistration&uhid='+rowVal+'&'+csrfTokenName+'='+csrfTokenValue, true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}

// populate patient Update form  searchPatientForUpdate

		function searchPatientForUpdate(uhidNo)
		{
		    
			var xmlHttp;
			try {
				// Firefox, Opera 8.0+, Safari
				xmlHttp = new XMLHttpRequest();
			} catch (e) {
				// Internet Explorer
				try {
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					alert(e)
					try {
						xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {
						alert("Your browser does not support AJAX!");
						return false;
					}
				}
			}
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4) {

					var items = xmlHttp.responseXML.getElementsByTagName('items111')[0];
					
					for (loop = 0; loop < items.childNodes.length; loop++) {
						var item = items.childNodes[loop];
					
						
						var name = item.getElementsByTagName("name")[0];
						
						var Uhid = item.getElementsByTagName("Uhid")[0];
						
						var uhidNo=item.getElementsByTagName("uhidNo")[0];
						
						var birthYear = item.getElementsByTagName("birthYear")[0];
						
						var memail = item.getElementsByTagName("uemail")[0];
					
						
						var mobNo = item.getElementsByTagName("mobNumber")[0];
						var age=item.getElementsByTagName("age")[0];
						var ageUnit=item.getElementsByTagName("ageUnit")[0];
						var aadhaarNo = item.getElementsByTagName("aadhaarNo")[0];
						var gender=item.getElementsByTagName("mgender")[0];
						var genderId=item.getElementsByTagName("mgenderId")[0];
						var relation=item.getElementsByTagName("relation")[0];
						var relationName=item.getElementsByTagName("relativeName")[0];
						
						var HouseN=item.getElementsByTagName("AHouseNameID")[0];
						
						var StreetName=item.getElementsByTagName("StreetName")[0];
						
						var cvillage=item.getElementsByTagName("avillage")[0];
						var villageName=item.getElementsByTagName("villageName")[0]; 
						var familyStatus=item.getElementsByTagName("familyStatus")[0];
						var aadharDoc=item.getElementsByTagName("aadharDoc")[0];
						var otherDoc=item.getElementsByTagName("otherDoc")[0];
						
						var ocupationId=item.getElementsByTagName("ocupationId")[0];
						
						var ocupationName=item.getElementsByTagName("ocupationName")[0];
						
						var monthlyIncome=item.getElementsByTagName("monthlyIncome")[0];
						
						
						document.getElementById('updatePatienthinid').value =Uhid.childNodes[0].nodeValue
						
						
						if( ocupationId.childNodes[0] !=undefined && null !=ocupationId.childNodes[0].nodeValue ){
							objocupation = document.getElementById('occupationId');
							objocupation.length = 1;
							objocupation.length++;
							objocupation.options[objocupation.length-1].value=ocupationId.childNodes[0].nodeValue
							objocupation.options[objocupation.length-1].selected=true;
							objocupation.options[objocupation.length-1].text=ocupationName.childNodes[0].nodeValue
						}
						
						var EduId=item.getElementsByTagName("EduId")[0];
						
						var EduName=item.getElementsByTagName("EduName")[0];
						
						if( EduId.childNodes[0] !=undefined  && null !=EduId.childNodes[0].nodeValue){
							objoEdu = document.getElementById('educationId');
							objoEdu.length = 1;
							objoEdu.length++;
							objoEdu.options[objoEdu.length-1].value=EduId.childNodes[0].nodeValue
							objoEdu.options[objoEdu.length-1].selected=true;
							objoEdu.options[objoEdu.length-1].text=EduName.childNodes[0].nodeValue
						}
						
						var socialId=item.getElementsByTagName("socialId")[0];
						var socialName=item.getElementsByTagName("socialName")[0];
						if( socialId.childNodes[0] !=undefined){
							objSocial = document.getElementById('patientTypeId');
							objSocial.length = 1;
							objSocial.length++;
							objSocial.options[objSocial.length-1].value=socialId.childNodes[0].nodeValue
							objSocial.options[objSocial.length-1].selected=true;
							objSocial.options[objSocial.length-1].text=socialName.childNodes[0].nodeValue
						}
						
						var Ndob=item.getElementsByTagName("Ndob")[0];
						
						if(familyStatus.childNodes[0] !=undefined){
							if(familyStatus.childNodes[0].nodeValue=='y'){
								radiobtn = document.getElementById("bplStatusId");
								radiobtn.checked = true;
								
							}
							else if(familyStatus.childNodes[0].nodeValue=='n'){
								radiobtn = document.getElementById("aplStatusId");
								radiobtn.checked = true;
							}
						}
					var	otherDocNum=item.getElementsByTagName("otherDocNum")[0];
					var otherDocId=item.getElementsByTagName("otherDocId")[0];
					
						if(otherDoc!=undefined){
							document.getElementById('updOtherIdCard').value =otherDoc.childNodes[0].nodeValue
							//alert(document.getElementById('updOtherIdCard').value)
							if(document.getElementById('updOtherIdCard').value.toUpperCase() === "ration card".toUpperCase()){
								 document.getElementById('updOtherIdCardNumber').readOnly = false;	
							}
							document.getElementById('updOtherIdCardNumber').value =otherDocNum.childNodes[0].nodeValue
							if(otherDocId !=undefined  && otherDocId.childNodes[0]!=undefined )
							document.getElementById('updOtherIdCardId').value =otherDocId.childNodes[0].nodeValue

						}
						/*if(aadharDoc !=undefined && aadharDoc.childNodes[0].nodeValue!=""){
							document.getElementById('updOtherIdCard').value =aadharDoc.childNodes[0].nodeValue	
						}*/
						
						
						
						if(cvillage != undefined && cvillage.childNodes[0] !=undefined){
							objVillage = document.getElementById('villageId');
							objVillage.length = 1;
							objVillage.length++;
							objVillage.options[objVillage.length-1].value=cvillage.childNodes[0].nodeValue
							objVillage.options[objVillage.length-1].selected=true;
							objVillage.options[objVillage.length-1].text=villageName.childNodes[0].nodeValue
						}
						var district=item.getElementsByTagName("district")[0];
						var districtName=item.getElementsByTagName("districtName")[0];
						if(district != undefined && district.childNodes[0] !=undefined){
							objdistrictId=document.getElementById('districtId');
							objdistrictId.length=1;	
						objdistrictId.length++;
						objdistrictId.options[objdistrictId.length-1].value=district.childNodes[0].nodeValue
						objdistrictId.options[objdistrictId.length-1].selected=true;
						objdistrictId.options[objdistrictId.length-1].text=districtName.childNodes[0].nodeValue
					}
						var taluk=item.getElementsByTagName("taluk")[0];
						var talukName=item.getElementsByTagName("talukName")[0];
						
						if(taluk != undefined && taluk.childNodes[0] !=undefined){
							objTaluk=document.getElementById('updatetalukId');
							objTaluk.length = 1;
						objTaluk.length++;
						objTaluk.options[objTaluk.length-1].value=taluk.childNodes[0].nodeValue
						objTaluk.options[objTaluk.length-1].selected=true;
						objTaluk.options[objTaluk.length-1].text=talukName.childNodes[0].nodeValue
					}
						var postoffice=item.getElementsByTagName("postoffice")[0];
						var postofficeName=item.getElementsByTagName("postofficeName")[0];
						if(postoffice.childNodes[0]!=undefined){
							obj = document.getElementById('postOffId');
							obj.length = 1;
							obj.length++;
							obj.options[obj.length-1].value=postoffice.childNodes[0].nodeValue
							obj.options[obj.length-1].selected=true;
							obj.options[obj.length-1].text=postofficeName.childNodes[0].nodeValue
						}
						var pincode=item.getElementsByTagName("pincode")[0];
						
						
						var patientHinId=item.getElementsByTagName("hinid")[0];
						
						var aadhar=item.getElementsByTagName("aadhar")[0];
						
						if(gender.childNodes[0] != undefined)
						document.getElementById('qGenderId').value =gender.childNodes[0].nodeValue
						if(genderId.childNodes[0] != undefined)
							document.getElementById('qGenderId').value =genderId.childNodes[0].nodeValue
						
						document.getElementById('UHIDId').value =uhidNo.childNodes[0].nodeValue
						
						if(aadhar.childNodes[0] != undefined)
						document.getElementById('pQAadhaarNumberId').value = aadhar.childNodes[0].nodeValue
						
						if(patientHinId.childNodes[0] != undefined)
						document.getElementById('patientHinId').value = patientHinId.childNodes[0].nodeValue
						
						if(age.childNodes[0] != undefined)
						document.getElementById('qAgeId').value = age.childNodes[0].nodeValue
						
						if(ageUnit.childNodes[0] != undefined)
							document.getElementById('qAgeUnitId').value = ageUnit.childNodes[0].nodeValue
						
						
						if(HouseN.childNodes[0] !=undefined && HouseN.childNodes[0]!=null ){
							
						document.getElementById('pHouseName').value = HouseN.childNodes[0].nodeValue
						}
						if(StreetName.childNodes[0] != undefined)
						document.getElementById('streetNameId').value = StreetName.childNodes[0].nodeValue
						
						/*document.getElementById('villageId').value = village.childNodes[0].nodeValue*/
						/*document.getElementById('districtId').value = district.childNodes[0].nodeValue*/
						if(taluk.childNodes[0] != undefined)
						document.getElementById('talukId').value = taluk.childNodes[0].nodeValue
						
						/*document.getElementById('postOffId').value = postoffice.childNodes[0].nodeValue*/
						
				    	 
				    	 if(pincode!=undefined && pincode.childNodes[0]!=undefined)
						document.getElementById('pincodeNumberId').value = pincode.childNodes[0].nodeValue

						if(name!=undefined && name.childNodes[0]!=undefined){
						document.getElementById('pQNameId').value = name.childNodes[0].nodeValue
						document.getElementById('paient_old_nameId').value = name.childNodes[0].nodeValue
						
						}
						/*document.getElementById('pUhidId').value = Uhid.childNodes[0].nodeValue*/
						
						 if(birthYear !=undefined && birthYear.childNodes[0]!= undefined)
						document.getElementById('qDobId').value = birthYear.childNodes[0].nodeValue
						
						if(memail != undefined && memail.childNodes[0] != undefined)
						document.getElementById('emailId').value = memail.childNodes[0].nodeValue
						
						if(mobNo != undefined && mobNo.childNodes[0]!= undefined)
						document.getElementById('mobileNoId').value = mobNo.childNodes[0].nodeValue
						
						if(aadhaarNo != undefined && aadhaarNo.childNodes[0] != undefined)
						document.getElementById('pQAadhaarNumberId').value = aadhaarNo.childNodes[0].nodeValue
						
						if(relation != undefined && relation.childNodes[0] != undefined)
						document.getElementById('qRelId').value = relation.childNodes[0].nodeValue
						
						if(relationName != undefined && relationName.childNodes[0] != undefined && relationName.childNodes[0].nodeValue!='null'){
							
						document.getElementById('qNokNameId').value = relationName.childNodes[0].nodeValue
						}
						// permanent Address
						var pdistrict=item.getElementsByTagName("pdistrict")[0];
						var pdistrictName=item.getElementsByTagName("pdistrictName")[0];
						
						
						
						if(pdistrict.childNodes[0] !=undefined){
							
							pobj=document.getElementById('cityId');
							pobj.length = 1;
						pobj.length++;
						pobj.options[pobj.length-1].value=pdistrict.childNodes[0].nodeValue
						pobj.options[pobj.length-1].selected=true;
						pobj.options[pobj.length-1].text=pdistrictName.childNodes[0].nodeValue
						document.getElementById('pDistrict').value = pdistrict.childNodes[0].nodeValue;
						}
						var pptaluk=item.getElementsByTagName("ptaluk")[0];
						var pptalukName=item.getElementsByTagName("ptalukName")[0];
						
					
						
						if(pptaluk.childNodes[0] !=undefined){
						ptaluk=document.getElementById('talukId');
						ptaluk.length = 1;
						ptaluk.length++;
						ptaluk.options[ptaluk.length-1].value=pptaluk.childNodes[0].nodeValue
						ptaluk.options[ptaluk.length-1].selected=true;
						ptaluk.options[ptaluk.length-1].text=pptalukName.childNodes[0].nodeValue
						}
						
						var ppostoffice=item.getElementsByTagName("ppostoffice")[0];
						var ppostofficeName=item.getElementsByTagName("ppostofficeName")[0];
						
						if(ppostoffice.childNodes[0] !=undefined){
						var ppostcode=item.getElementsByTagName("ppostcode")[0];
						document.getElementById('permanentPincode').value = ppostcode.childNodes[0].nodeValue
						postobj=document.getElementById('permanentPostOff');
						postobj.length = 1;
						postobj.length++;
						postobj.options[postobj.length-1].value=ppostoffice.childNodes[0].nodeValue
						postobj.options[postobj.length-1].selected=true;
						postobj.options[postobj.length-1].text=ppostofficeName.childNodes[0].nodeValue
						}
						
						var plocality=item.getElementsByTagName("plocality")[0];
						var plocalityName=item.getElementsByTagName("plocalityName")[0];
						
						if(plocality.childNodes[0] !=undefined){
							localityobj=document.getElementById('localityId');
							localityobj.length = 1;
							localityobj.length++;
							localityobj.options[localityobj.length-1].value=plocality.childNodes[0].nodeValue
							localityobj.options[localityobj.length-1].selected=true;
							localityobj.options[localityobj.length-1].text=plocalityName.childNodes[0].nodeValue
							document.getElementById('pLocality').value = plocality.childNodes[0].nodeValue;
						}
						
						var plsg=item.getElementsByTagName("plsg")[0];
						var plsgName=item.getElementsByTagName("plsgname")[0];
						
						if(plsg.childNodes[0] !=undefined){
						lsgobj=document.getElementById('lsgNameId');
						lsgobj.length = 1;
						lsgobj.length++;
						lsgobj.options[lsgobj.length-1].value=plsg.childNodes[0].nodeValue
						lsgobj.options[lsgobj.length-1].selected=true;
						lsgobj.options[lsgobj.length-1].text=plsgName.childNodes[0].nodeValue
						}
						
						
						var plsgHpuseNo=item.getElementsByTagName("plsgHpuseNo")[0];
						
						if(plsgHpuseNo.childNodes[0] !=undefined){
						document.getElementById('lsgHouseNoId').value = plsgHpuseNo.childNodes[0].nodeValue
						}
						
						var pHouseNo=item.getElementsByTagName("pHouseNo")[0];
						if(pHouseNo.childNodes[0] != undefined){
							document.getElementById("houseId").value = pHouseNo.childNodes[0].nodeValue
						}
						
						var phealtHouseId=item.getElementsByTagName("phealtHouseId")[0];
						if(phealtHouseId.childNodes[0] !=undefined){
						document.getElementById('healthHouseId').value = phealtHouseId.childNodes[0].nodeValue
						}
						// Temporary Address
						
						var tdistrict=item.getElementsByTagName("tdistrict")[0];
						var tdistrictName=item.getElementsByTagName("tdistrictName")[0];
						
						if(tdistrict.childNodes[0] !=undefined){
							
							document.getElementById('tcityId').value=tdistrict.childNodes[0].nodeValue
							/*tobj=document.getElementById('tcityId');
							tobj.length = 1;
							tobj.length++;
							tobj.options[tobj.length-1].value=tdistrict.childNodes[0].nodeValue
							tobj.options[tobj.length-1].selected=true;
							tobj.options[tobj.length-1].text=tdistrictName.childNodes[0].nodeValue*/
						}
						var ttaluk=item.getElementsByTagName("ttaluk")[0];
						var ttalukName=item.getElementsByTagName("ttalukName")[0];
						
						if(ttaluk.childNodes[0] !=undefined){
						ttalukobj=document.getElementById('ttalukId');
						ttalukobj.length = 1;
						ttalukobj.length++;
						ttalukobj.options[ttalukobj.length-1].value=ttaluk.childNodes[0].nodeValue
						ttalukobj.options[ttalukobj.length-1].selected=true;
						ttalukobj.options[ttalukobj.length-1].text=ttalukName.childNodes[0].nodeValue
						}
						
						var tpostoffice=item.getElementsByTagName("tpostoffice")[0];
						var tpostofficeName=item.getElementsByTagName("tpostofficeName")[0];
						
						if(tpostoffice.childNodes[0] !=undefined){
						var tpostcode=item.getElementsByTagName("tpostcode")[0];
						document.getElementById('tempPincode').value = tpostcode.childNodes[0].nodeValue
						tpostobj=document.getElementById('tempPostOff');
						tpostobj.length = 1;
						tpostobj.length++;
						tpostobj.options[tpostobj.length-1].value=tpostoffice.childNodes[0].nodeValue
						tpostobj.options[tpostobj.length-1].selected=true;
						tpostobj.options[tpostobj.length-1].text=tpostofficeName.childNodes[0].nodeValue
						}
						
						var tlocality=item.getElementsByTagName("tlocality")[0];
						var tlocalityName=item.getElementsByTagName("tlocalityName")[0];
						
						if(tlocality.childNodes[0] !=undefined){
							tlocalityobj=document.getElementById('templocality');
							tlocalityobj.length = 1;
							tlocalityobj.length++;
							tlocalityobj.options[tlocalityobj.length-1].value=tlocality.childNodes[0].nodeValue
							tlocalityobj.options[tlocalityobj.length-1].selected=true;
							tlocalityobj.options[tlocalityobj.length-1].text=tlocalityName.childNodes[0].nodeValue
						}
						
						var tlsg=item.getElementsByTagName("tlsg")[0];
						var tlsgname=item.getElementsByTagName("tlsgname")[0];
						
						if(tlsg.childNodes[0] !=undefined){
						tlsgobj=document.getElementById('tlsgNameId');
						tlsgobj.length = 1;
						tlsgobj.length++;
						tlsgobj.options[tlsgobj.length-1].value=tlsg.childNodes[0].nodeValue
						tlsgobj.options[tlsgobj.length-1].selected=true;
						tlsgobj.options[tlsgobj.length-1].text=tlsgname.childNodes[0].nodeValue
					}
						var tlsgHpuseNo=item.getElementsByTagName("tlsgHpuseNo")[0];
						if(tlsgHpuseNo.childNodes[0] !=undefined)
						document.getElementById('tlsghouseId').value = tlsgHpuseNo.childNodes[0].nodeValue
						
						var thealtHouseId=item.getElementsByTagName("thealtHouseId")[0];
						if(thealtHouseId.childNodes[0] !=undefined)
						document.getElementById('thealthHouseId').value = thealtHouseId.childNodes[0].nodeValue
						if(Ndob.childNodes[0] !=undefined && Ndob.childNodes[0] !=null ){
							//Ndob.childNodes[0].nodeValue
						document.getElementById('ndobId').innerHTML ='Notional DOB' 
						}
						
						var visaTypeId=item.getElementsByTagName("visaTypeId")[0];
						var visaTypeIdName=item.getElementsByTagName("visaTypeIdName")[0];
						var fromValid=item.getElementsByTagName("fromValid")[0];
						var toValid=item.getElementsByTagName("toValid")[0];
						
						var passortNo=item.getElementsByTagName("passortNo")[0];
						
						if(visaTypeId.childNodes[0] !=undefined)
						document.getElementById('visaTypeId').value =visaTypeId.childNodes[0].nodeValue; 
						
						if(fromValid.childNodes[0] !=undefined)
						document.getElementById('visaFromDateId').value =fromValid.childNodes[0].nodeValue; 
						
						if(toValid.childNodes[0] !=undefined)
						document.getElementById('visaToDateId').value =toValid.childNodes[0].nodeValue; 
						
						if(passortNo.childNodes[0] !=undefined)
						document.getElementById('passPortId').value =passortNo.childNodes[0].nodeValue; 
						
						var dobDocumentId=item.getElementsByTagName("dobOtherCardId")[0];
						var dobDocumentIdNumber=item.getElementsByTagName("dobOtherCardIdNum")[0];
						
						if(dobDocumentId.childNodes[0] !=undefined)
						document.getElementById('dobDocumentId').value =dobDocumentId.childNodes[0].nodeValue; 
						
						if(dobDocumentIdNumber.childNodes[0] !=undefined)
						document.getElementById('dobDocumentIdNumber').value =dobDocumentIdNumber.childNodes[0].nodeValue; 
						
						var tempdocumentId=item.getElementsByTagName("tempdocumentId")[0];
						var tempotherIdCardNumber=item.getElementsByTagName("tempotherIdCardNumber")[0];
						
						if(tempdocumentId.childNodes[0] !=undefined)
						
						document.getElementById('tempdocumentId').value =tempdocumentId.childNodes[0].nodeValue; 
						
						if(tempotherIdCardNumber.childNodes[0] !=undefined)
						document.getElementById('tempotherIdCardNumber').value =tempotherIdCardNumber.childNodes[0].nodeValue; 
						
						if(monthlyIncome.childNodes[0] !=undefined && null !=monthlyIncome.childNodes[0])
							document.getElementById('monIncome').value =monthlyIncome.childNodes[0].nodeValue; 
						
						var bloodGroup=item.getElementsByTagName("bloodGroup")[0];
						var bloodName=item.getElementsByTagName("bloodName")[0];
						
						/*if( bloodGroup.childNodes[0] !=undefined && null !=bloodGroup.childNodes[0].nodeValue ){
							objbloodGroup = document.getElementById('bloodGroupId');
							objbloodGroup.length = 1;
							objbloodGroup.length++;
							objbloodGroup.options[objbloodGroup.length-1].value=bloodGroup.childNodes[0].nodeValue
							objbloodGroup.options[objbloodGroup.length-1].selected=true;
							objbloodGroup.options[objbloodGroup.length-1].text=bloodName.childNodes[0].nodeValue
						}*/
						
						if(bloodGroup.childNodes[0] != undefined)
							document.getElementById('bloodGroupId').value =bloodGroup.childNodes[0].nodeValue
						
						if(bloodName.childNodes[0] !=undefined){
						document.getElementById('bloodGroupName').value =bloodName.childNodes[0].nodeValue;
						}
						//
					}//loop
				}//if
			
			}//respose

			xmlHttp.open("GET",
					'registration?method=searchPatientForUpdateRegistration&uhidNo='+uhidNo+'&'+csrfTokenName+'='+csrfTokenValue, true);
			xmlHttp.setRequestHeader("Content-Type", "text/xml");
			xmlHttp.send(null);
			displayImageforUpdate(uhidNo);

		}		
		
		function displayImageforUpdate(hinNo)
		 {		
			 var pathh="/hms/hms/registration?method=displayImage&patientHinNo="+hinNo+'&'+csrfTokenName+'='+csrfTokenValue;
			
			 document.getElementById("imageID").src = pathh;
		 
				 /*new Ajax.Request('registration?method=displayImage&patientHinNo='+hinNo, {});*/
		 }

//

//--------Added by kishore for populating patient details for new visit-------//
function ajaxFunctionForPopulatePatientInfoForVisit(formName,rowVal)
{
    
	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {

			var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
			
			for (loop = 0; loop < items.childNodes.length; loop++) {
				var item = items.childNodes[loop];
				
				var pUhidId = item.getElementsByTagName("pUhidId")[0];
				var visitNoId = item.getElementsByTagName("visitNoId")[0];
				var pnameId = item.getElementsByTagName("pnameId")[0];
				
				var genderId = item.getElementsByTagName("genderId")[0];
				var ageId = item.getElementsByTagName("ageId")[0];
				var relationId = item.getElementsByTagName("relationId")[0];
				var relationNameId = item.getElementsByTagName("relationNameId")[0];
				var occupationId = item.getElementsByTagName("occupationId")[0];
				var mobileNoId = item.getElementsByTagName("mobileNoId")[0];
				var categoryId = item.getElementsByTagName("categoryId")[0];
				var registrationTypeId = item.getElementsByTagName("registrationTypeId")[0];
				var amountId = item.getElementsByTagName("amountId")[0];
				var availableCreditBalanceId = item.getElementsByTagName("availableCreditBalanceId")[0];	
				var billNoId = item.getElementsByTagName("billNoId")[0];
				var hinId = item.getElementsByTagName("hinId")[0];
				/*var rank = item.getElementsByTagName("rank")[0];
				var name = item.getElementsByTagName("name")[0];*/
				//document.getElementById('hinId').value = hinId.childNodes[0].nodeValue
				/*document.getElementById('serviceNo'+rowVal).value = serviceNo.childNodes[0].nodeValue
				document.getElementById('rank'+rowVal).value = rank.childNodes[0].nodeValue*/
				
				document.getElementById('pUhidId').value = pUhidId.childNodes[0].nodeValue
				document.getElementById('pnameId').value = pnameId.childNodes[0].nodeValue
				document.getElementById('genderId').value = genderId.childNodes[0].nodeValue
				document.getElementById('ageId').value = ageId.childNodes[0].nodeValue
				document.getElementById('relationId').value = relationId.childNodes[0].nodeValue
				document.getElementById('relationNameId').value = relationNameId.childNodes[0].nodeValue
				document.getElementById('occupationId').value = occupationId.childNodes[0].nodeValue
				document.getElementById('mobileNoId').value = mobileNoId.childNodes[0].nodeValue
				document.getElementById('categoryId').value = categoryId.childNodes[0].nodeValue
				document.getElementById('visitNoId').value = visitNoId.childNodes[0].nodeValue
				document.getElementById('availableCreditBalanceId').value = availableCreditBalanceId.childNodes[0].nodeValue
				document.getElementById('amountId').value = amountId.childNodes[0].nodeValue
				document.getElementById('registrationTypeId').value = registrationTypeId.childNodes[0].nodeValue
				document.getElementById('billNoId').value = billNoId.childNodes[0].nodeValue
				document.getElementById('hinId').value = hinId.childNodes[0].nodeValue
			}
		}
	}

	//alert(" diagnosis "+document.getElementById('diagnosisNo' + rowVal).value);

	xmlHttp.open("GET",
			'registration?method=populatePatientDetailsToVisit&uhid='+rowVal+'&'+csrfTokenName+'='+csrfTokenValue, true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}
//--------Added by kishore for getting last visit details-------//

function showLastVisitDetailsInAjax(formName,deptId,hinNo){
 	
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
  xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {

			var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
			
			for (loop = 0; loop < items.childNodes.length; loop++) {
				var item = items.childNodes[loop];
				
				var lastVisitDateId = item.getElementsByTagName("lastVisitDateId")[0];
				var lastVisitUnitId = item.getElementsByTagName("lastVisitUnitId")[0];
				var lastVisitDoctorsIncharge = item.getElementsByTagName("lastVisitDoctorsIncharge")[0];
				var lastVisitDutyDoctorId = item.getElementsByTagName("lastVisitDutyDoctorId")[0];
				if(lastVisitDateId=="0"){
					document.getElementById("lastVisitDetailsId").style.display="none";
				}
				
				document.getElementById('lastVisitDateId').value = lastVisitDateId.childNodes[0].nodeValue
				
				document.getElementById('lastVisitUnitId').value = lastVisitUnitId.childNodes[0].nodeValue
				
				document.getElementById('lastVisitDoctorsIncharge').value = lastVisitDoctorsIncharge.childNodes[0].nodeValue
				document.getElementById('lastVisitDutyDoctorId').value = lastVisitDutyDoctorId.childNodes[0].nodeValue
				
			}
		}
	}
  xmlHttp.open("GET",
			'registration?method=getLastVisitDetails&deptId='+deptId+'&hinNo='+hinNo+'&'+csrfTokenName+'='+csrfTokenValue, true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

    }
 

//Lab Integration Code With Machine End 08 Feb 2011 by Ramdular Prajapati ------


//==========================================================================



//==================By:Ujjwal================================================
function ajaxFunctionForTestObject(formName) {
	
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
		   	    var majorname =  item.getElementsByTagName("majorname")[0];
    		   	var majorsubname =  item.getElementsByTagName("majorsubname")[0];
    		   	var minorsubname =  item.getElementsByTagName("minorsubname")[0];
		   	    try{
	        		document.getElementById('majornameId').value = majorname.childNodes[0].nodeValue
	        	
	        	}catch (e){
	        		document.getElementById('majornameId').value = "";
	        	}
	        	try{
	        		document.getElementById('majorsubheadnameId').value = majorsubname.childNodes[0].nodeValue
	        	
	        	}catch (e){
	        		document.getElementById('majorsubheadnameId').value = "";
	        	}
	        	try{
	        		document.getElementById('minorsubheadnameId').value = minorsubname.childNodes[0].nodeValue
	        	
	        	}catch (e){
	        		document.getElementById('minorsubheadnameId').value = "";
	        	}

	      	}
	      }
	      }

	    xmlHttp.open("GET",'budget?method=fillHeadNames&objectHead='+document.getElementById("objectHead").value+'&'+csrfTokenName+'='+csrfTokenValue,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }
	  
	  //================================Accounts Method ========================================

/*function showCrBalanceInAjax(formName){
 	var accountId=document.getElementById('mainAccountId').value;
 	var voucherDate=document.getElementById('voucherDate').value;
 	 	//alert("showCrBalanceInAjax method==="+accountId);
	if(accountId != 0){
		action="/hms/hms/account?method=showAccountCrBalance&accountId="+accountId+"&voucherDate="+voucherDate;
		obj = eval('document.'+formName)
		       obj.action = action;
	    	   	 var url=action

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
	        var balance  = item.getElementsByTagName("balance")[0];
	         obj=eval(document.getElementById('balanceId'))
	      if(balance.childNodes[0].nodeValue != undefined){
	      document.getElementById('balanceId').value=balance.childNodes[0].nodeValue;
	       }
	       var groupId  = item.getElementsByTagName("groupId")[0];
	        obj=eval(document.getElementById('groupId'))
	         if(groupId.childNodes[0].nodeValue != undefined){
	     	 document.getElementById('groupId').value=groupId.childNodes[0].nodeValue;
	       }
	       var subGroupId  = item.getElementsByTagName("subGroupId")[0];
	        obj=eval(document.getElementById('subGroupId'))
	         if(subGroupId.childNodes[0].nodeValue != undefined){
	     	 document.getElementById('subGroupId').value=subGroupId.childNodes[0].nodeValue;
	       }
      	}
      }
    }
    var url=action

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

    }
 }*/

function showAllBalanceInAjaxSub(formName,inc){
	if(document.getElementById('accountNameBankId'+inc)!= null )
	{
		if( document.getElementById('accountNameBankId'+inc).value != "")
		{
			var accountNameId1=document.getElementById('accountNameBankId'+inc).value;
		}	
	}
	 //if(document.getElementById('accountNameId'+inc)!= null )
	 if(document.getElementById('accountNameId'+inc) != null )
	 {	
		 if( document.getElementById('accountNameId'+inc).value!= "")
		 {
		var accountNameId1=document.getElementById('accountNameId'+inc).value;
		 }
	}
 	var resrate =document.getElementById('resrate'+inc).value;
 	var voucherDate=document.getElementById('voucherDate').value;
 		 	//alert("showCrBalanceInAjax method==="+accountId);
	if(accountNameId1 != null && accountNameId1!=""){		
			action="/hms/hms/account?method=showAccountBal&accountNameId="+accountNameId1+"&resrate="+resrate+"&voucherDate="+voucherDate;
		}
		obj = eval('document.'+formName)
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016


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
      	/*alert(items);*/
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var balance  = items.getElementsByTagName("balance")[0];
	         obj=eval(document.getElementById('balanceId'))
	      if(balance.childNodes[0].nodeValue != undefined){
	      document.getElementById('balanceId').value=balance.childNodes[0].nodeValue;
	       }
	       var groupId  = item.getElementsByTagName("groupId")[0];
	        obj=eval(document.getElementById('groupId'))
	         if(groupId.childNodes[0].nodeValue != undefined){
	     	 document.getElementById('groupId').value=groupId.childNodes[0].nodeValue;
	       }
	       var subGroupId  = item.getElementsByTagName("subGroupId")[0];
	        obj=eval(document.getElementById('subGroupId'))
	         if(subGroupId.childNodes[0].nodeValue != undefined){
	     	 document.getElementById('subGroupId').value=subGroupId.childNodes[0].nodeValue;
	       }
      	}
      }
    }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016


    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

    }
 

function showAllBalanceInAjax(formName,inc){
	
if(document.getElementById('accountNameBankId'+inc)!= null )
{
	if( document.getElementById('accountNameBankId'+inc).value != "")
	{
	var accountNameId1=document.getElementById('accountNameBankId'+inc).value;
	}
}
 //if(document.getElementById('accountNameId'+inc)!= null )
 if(document.getElementById('accountNameId'+inc) != null )
 {	
	 if( document.getElementById('accountNameId'+inc).value!= "")
	 {
	var accountNameId1=document.getElementById('accountNameId'+inc).value;
	 }
 }
 	var voucherDate=document.getElementById('voucherDate').value;
 		 	//alert("showCrBalanceInAjax method==="+accountId);
 		if(accountNameId1 != null && accountNameId1!=""){		
		action="/hms/hms/account?method=showAccountBal&accountNameId="+accountNameId1+"&voucherDate="+voucherDate;
		obj = eval('document.'+formName)
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

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
      	/*alert(items);*/
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var balance  = items.getElementsByTagName("balance")[0];
	         obj=eval(document.getElementById('balanceId'))
	      if(balance.childNodes[0].nodeValue != undefined){
	      document.getElementById('balanceId').value=balance.childNodes[0].nodeValue;
	       }
	       var groupId  = item.getElementsByTagName("groupId")[0];
	        obj=eval(document.getElementById('groupId'))
	         if(groupId.childNodes[0].nodeValue != undefined){
	     	 document.getElementById('groupId').value=groupId.childNodes[0].nodeValue;
	       }
	       var subGroupId  = item.getElementsByTagName("subGroupId")[0];
	        obj=eval(document.getElementById('subGroupId'))
	         if(subGroupId.childNodes[0].nodeValue != undefined){
	     	 document.getElementById('subGroupId').value=subGroupId.childNodes[0].nodeValue;
	       }
      	}
      }
    }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016


    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

    }
 }



/*function showBalanceInAjax(formName){
 	var accountId=document.getElementById('mainAccountId').value;
 	//alert("showBalanceInAjax method==="+accountId);
	if(accountId != 0){
		action="/hms/hms/account?method=showAccountBalance&accountId="+accountId;
		obj = eval('document.'+formName)
		       obj.action = action;
	    	   	 var url=action

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
	        var balance  = item.getElementsByTagName("balance")[0];
	         obj=eval(document.getElementById('balanceId'))
	      if(balance.childNodes[0].nodeValue != undefined){
	      document.getElementById('balanceId').value=balance.childNodes[0].nodeValue;
	       }
	        var groupId  = item.getElementsByTagName("groupId")[0];
	        obj=eval(document.getElementById('groupId'))
	         if(groupId.childNodes[0].nodeValue != undefined){
	     	 document.getElementById('groupId').value=groupId.childNodes[0].nodeValue;
	       }
	       var subGroupId  = item.getElementsByTagName("subGroupId")[0];
	        obj=eval(document.getElementById('subGroupId'))
	         if(subGroupId.childNodes[0].nodeValue != undefined){
	     	 document.getElementById('subGroupId').value=subGroupId.childNodes[0].nodeValue;
	       }
      	}
      }
    }
    var url=action

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

    }
 }*/

function showBalanceInAjax(formName){
 	var accountId=document.getElementById('mainAccountId2').value;
 	//alert("showBalanceInAjax method==="+accountId);
	if(accountId != 0){
		action="/hms/hms/account?method=showAccountBalance&accountId="+accountId;
		obj = eval('document.'+formName)
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016


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
	        var balance  = item.getElementsByTagName("balance")[0];
	         obj=eval(document.getElementById('balanceId'))
	      if(balance.childNodes[0].nodeValue != undefined){
	      document.getElementById('balanceId').value=balance.childNodes[0].nodeValue;
	      document.getElementById('balanceAmountId').value=balance.childNodes[0].nodeValue;
	       }
	        var groupId  = item.getElementsByTagName("groupId")[0];
	        obj=eval(document.getElementById('groupId'))
	         if(groupId.childNodes[0].nodeValue != undefined){
	     	 document.getElementById('groupId').value=groupId.childNodes[0].nodeValue;
	       }
	       var subGroupId  = item.getElementsByTagName("subGroupId")[0];
	        obj=eval(document.getElementById('subGroupId'))
	         if(subGroupId.childNodes[0].nodeValue != undefined){
	     	 document.getElementById('subGroupId').value=subGroupId.childNodes[0].nodeValue;
	       }
      	}
      }
    }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016


    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

    }
 }


//by:Ujjwal on behalf of Nilay Shankar
function ajaxFunctionForPatientNameTitle(formName) {
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
          if(xmlHttp.readyState==4){titleName
                
                  var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
                  for (loop = 0; loop < items.childNodes.length; loop++) {
                           var item = items.childNodes[loop];
                           var name =  item.getElementsByTagName("name")[0];
                           var titleId = item.getElementsByTagName("titleId")[0];
                        var titleName = item.getElementsByTagName("titleName")[0];
                      
                        document.getElementById('name').value = name.childNodes[0].nodeValue
                       document.getElementById('titleId').value = titleId.childNodes[0].nodeValue
                       document.getElementById('titleName').value = titleName.childNodes[0].nodeValue
              
                  }
          }
          }

        xmlHttp.open("GET",'/hms/hrms/training?method=getNameTitle&hinNo='+document.getElementById("hinNo").value+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);

      }


//get Patient Visit Details for Uhid Conversion

function ajaxFunctionForuhidConversion(hinId) {
	
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
                         
                           var uhid=item.getElementsByTagName("uhid")[0];
               
                           var date =  item.getElementsByTagName("date")[0];
                           var hosName = item.getElementsByTagName("hosName")[0];
                        var docName = item.getElementsByTagName("docName")[0];
                      
                        if(date!=undefined && date.childNodes[0]!=undefined)
             			   document.getElementById("visitdateId").value = date.childNodes[0].nodeValue
             			   
             			  if(hosName!=undefined && hosName.childNodes[0]!=undefined)
                			   document.getElementById("hospId").value = hosName.childNodes[0].nodeValue
                			   
                 if(docName!=undefined && docName.childNodes[0]!=undefined)
                  document.getElementById("docId").value = docName.childNodes[0].nodeValue
                     			   
                     if(uhid!=undefined && uhid.childNodes[0]!=undefined)
                       document.getElementById("tuhid").value = uhid.childNodes[0].nodeValue
                       
                       document.getElementById('patienthinId').value = uhid.childNodes[0].nodeValue
                       
                        			   	   
                      /*  document.getElementById('visitdateId').value = date.childNodes[0].nodeValue
                       document.getElementById('hospId').value = hosName.childNodes[0].nodeValue*/
                     /*  document.getElementById('docId').value = docName.childNodes[0].nodeValue
                       document.getElementById('tuhid').value = uhid.childNodes[0].nodeValue*/
              
                  }
          }
          }

        xmlHttp.open("GET",'/hms/hms/registration?method=populateUhidConversionPage&hinId='+hinId+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);

      }


function ajaxFunctionForEmployeeNameDepartment(formName) {
    //alert("in proto .js");
    //alert("formName >"+formName);
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
          if(xmlHttp.readyState==4){departmentName
                // alert("hi--"+xmlHttp.responseXML.getElementsByTagName('items')[0]);
                  var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
                  for (loop = 0; loop < items.childNodes.length; loop++) {
                           var item = items.childNodes[loop];
                           var name =  item.getElementsByTagName("name")[0];
                           var departmentId = item.getElementsByTagName("departmentId")[0];
                        var departmentName = item.getElementsByTagName("departmentName")[0];
                      
                        document.getElementById('name').value = name.childNodes[0].nodeValue
                       document.getElementById('departmentId').value = departmentId.childNodes[0].nodeValue
                       document.getElementById('departmentName').value = departmentName.childNodes[0].nodeValue
              
                  }
          }
          }

        xmlHttp.open("GET",'/hms/hrms/training?method=getNameDepartment&empCode='+document.getElementById("empCode").value+'&'+csrfTokenName+'='+csrfTokenValue,true);
        xmlHttp.setRequestHeader("Content-Type", "text/xml");
        xmlHttp.send(null);

      }
//---------------By Ujjwal
function submitProtoAjaxWithDivNameForAppointment(formName,action,divName){

	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)

	       	obj.action = action;
	       // var url=action+"&"+getNameAndData(formName)
	        var url=action;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
        	new Ajax.Updater(divName,url,
			   {asynchronous:true, evalScripts:true });

	       	return true;
    }


function getHospitalWiseEmpList(hospitalId){
	document.getElementById('employeeId').style.display='block';
	document.getElementById('employeeName').style.display='none';
	
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
		obj = document.getElementById('employeeId');
		obj.length = 1;
		

       xmlHttp.onreadystatechange=function()
       {
         if(xmlHttp.readyState==4){
                 var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
                 for (loop = 0; loop < items.childNodes.length; loop++) {
                	 var item = items.childNodes[loop];
                	 var emp = item.getElementsByTagName("emp")[0];
                	 for(innerLoop = 0;innerLoop < emp.childNodes.length;innerLoop++){
                 		 var empDt = emp.childNodes[innerLoop];
	                	 var empId = empDt.getElementsByTagName("employeeId")[0];
	                	 var empName = empDt.getElementsByTagName("employeeName")[0];
	
	                	 obj.length++;
	                	 obj.options[obj.length-1].value=empId.childNodes[0].nodeValue
	                	 obj.options[obj.length-1].text=empName.childNodes[0].nodeValue
                	 }
                 }
             
              }
         }

       xmlHttp.open("GET",'/hms/hms/user?method=getHospitalWiseEmpList&hospitalId='+hospitalId+'&'+csrfTokenName+'='+csrfTokenValue);
       xmlHttp.setRequestHeader("Content-Type", "text/xml");
       xmlHttp.send(null);

}

function addNarrationInAjax(formName){
 	var voucherNarration=document.getElementById('voucherNarrationId').value;

	if(voucherNarration != ""){
		action="/hms/hms/account?method=addVoucherNarration&voucherNarration="+voucherNarration;
		obj = eval('document.'+formName)
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

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
	        var message  = item.getElementsByTagName("message")[0];
	      if(message.childNodes[0] != undefined)
		 	alert(message.childNodes[0].nodeValue);

      	}
      }
    }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

    }else {
    	alert("Please enter Narration to add to template.")
    	return false;
    }
 }

 function addAccountsNarrationInAjax(formName,inc){
 	var accountNarration=document.getElementById('accountNarrationId'+inc).value;

	if(accountNarration!= ""){
		action="/hms/hms/account?method=showAccountNarration&accountNarration="+accountNarration;
		obj = eval('document.'+formName)
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

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
	        var message  = item.getElementsByTagName("message")[0];
	      if(message.childNodes[0] != undefined)
		 	alert(message.childNodes[0].nodeValue);

      	}
      }
    }
    var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

    }else {
    	alert("Please enter Narration.")
    	return false;
    }
 }
 
 function showCrBalanceInAjax(formName){
	 //alert("in method!!");
	 	var accountId=document.getElementById('mainAccountId2').value;
	 	var voucherDate=document.getElementById('voucherDate2').value;
	 	 	//alert("showCrBalanceInAjax method==="+accountId);
	 	 	//alert("voucherDate method==="+voucherDate);
		if(accountId != 0){
			action="/hms/hms/account?method=showAccountCrBalance&accountId="+accountId+"&voucherDate="+voucherDate;
			obj = eval('document.'+formName)
			       obj.action = action;
		    	   	 var url=action;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

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
	      	var items =xmlHttp.responseXML.getElementsByTagName('items1')[0];
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var balance  = item.getElementsByTagName("balance")[0];
		         obj=eval(document.getElementById('balanceId'))
		      if(balance.childNodes[0].nodeValue != undefined){
		      document.getElementById('balanceId').value=balance.childNodes[0].nodeValue;
		      document.getElementById('balanceAmountId').value=balance.childNodes[0].nodeValue;
		       }
		       var groupId  = item.getElementsByTagName("groupId")[0];
		        obj=eval(document.getElementById('groupId'))
		         if(groupId.childNodes[0].nodeValue != undefined){
		     	 document.getElementById('groupId').value=groupId.childNodes[0].nodeValue;
		       }
		       var subGroupId  = item.getElementsByTagName("subGroupId")[0];
		        obj=eval(document.getElementById('subGroupId'))
		         if(subGroupId.childNodes[0].nodeValue != undefined){
		     	 document.getElementById('subGroupId').value=subGroupId.childNodes[0].nodeValue;
		       }
	      	}
	      }
	    }
	    var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	    }
	 }

 function submitProtoAjaxNew(formName,action,divName){

		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		action = action+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    	         	
		obj.action = action;
				
	        	new Ajax.Updater(divName,action,
				   {asynchronous:true, evalScripts:true });

		       	return true;
	    	}
 
 function submitProtoAjaxWithDivNameForVillageSurvey(formName,action,divName){

		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)

		       	obj.action = action;
	    	   	var url=action+"&"+getNameAndData(formName);
	    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    	    for(i=0;i<inputs.length;i++){
	    	    	if(inputs[i].name=='HOCL'&& inputs[i].checked)
	    	    		{
	   	    	   	 url +='&clinical='+inputs[i].value+"&";
	    	    		}
	    	    }

	            var oOptions = {
	                asynchronous:true, evalScripts:true,
	                onFailure: function () {
	                    alert("An error occurred: " );
	                },
	                onLoaded : function () {
	                   document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	                },
	                onInteractive :function () {
	                   document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	                }
	               // onLoading : function () {
	               //    document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	               // }

	            };

				var oRequest = new Ajax.Updater(divName, url,oOptions);

		       	return true;
	    }
 
 // Function to Populate Blood Bags From Stock Based on Blood Group
 
 function populateBloodBags(bloodGroupId) {
	 
		
		if(bloodGroupId>0)
		{
		action="/hms/hms/bloodBank?method=populateBloodBags&bloodGroupId="+bloodGroupId;
		obj = eval('document.crossMatching')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
}
var xmlHttp;
try {
//Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}catch (e){
//Internet Explorer
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
obj =document.getElementById("stockBags");
xmlHttp.onreadystatechange=function()
{
if(xmlHttp.readyState==4){
	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	for (loop = 0; loop < items.childNodes.length; loop++) {
	
	   	    var item = items.childNodes[loop];
	       var bagNo  = item.getElementsByTagName("bagNo")[0];
	       var bagNoID  = item.getElementsByTagName("bagNo")[0];
	      // alert(bagNoID.childNodes[0].nodeValue);
	      
	       if(undefined !=bagNoID && undefined != bagNoID.childNodes[0] &&  undefined != bagNo.childNodes[0]  && undefined !=bagNo){
	    	   obj.length++;
			obj.options[obj.length-1].value=bagNoID.childNodes[0].nodeValue;
			obj.options[obj.length-1].text=bagNo.childNodes[0].nodeValue;
	       }
	       else{
	    	   obj.options[obj.length-1].value="";
				obj.options[obj.length-1].text="";
	       }
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
}

//End 
 
 function populateBagDetails(bloodBag) {
		
		action="/hms/hms/bloodBank?method=populateBagDetails&bloodBag="+bloodBag;
		obj = eval('document.crossMatching')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

var xmlHttp;
try {
//Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}catch (e){
//Internet Explorer
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
obj =document.getElementById("stockBags");
xmlHttp.onreadystatechange=function()
{
if(xmlHttp.readyState==4){
	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	for (loop = 0; loop < items.childNodes.length; loop++) {
	
	   	    var item = items.childNodes[loop];
	       var bloodgroup  = item.getElementsByTagName("bloodgroup")[0];
	      var componentName  = item.getElementsByTagName("componentName")[0];
	     
	       var quantity  = item.getElementsByTagName("quantity")[0];
	       var expiryDate  = item.getElementsByTagName("expiryDate")[0];
	       var bag  = item.getElementsByTagName("bag")[0];
	       
	       document.getElementById("bagnumberI").value=bag.childNodes[0].nodeValue;
	       document.getElementById("bldgrpI").value=bloodgroup.childNodes[0].nodeValue;
	       document.getElementById("compI").value=componentName.childNodes[0].nodeValue;
	       document.getElementById("quantI").value=quantity.childNodes[0].nodeValue;
	       document.getElementById("expiryI").value=expiryDate.childNodes[0].nodeValue;
	            
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
}
 
 function populateComponentBagDetails(bloodBag) {
		//alert(bloodBag);
	
		action="/hms/hms/bloodBank?method=populateComponentBagDetails&bloodBag="+bloodBag;
		obj = eval('document.bloodSeperation')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

var xmlHttp;
try {
//Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}catch (e){
//Internet Explorer
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
obj =document.getElementById("stockBags");
xmlHttp.onreadystatechange=function()
{
if(xmlHttp.readyState==4){
	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	for (loop = 0; loop < items.childNodes.length; loop++) {
	
	   	    var item = items.childNodes[loop];
	       var bloodgroup  = item.getElementsByTagName("bloodgroup")[0];
	       var componentName  = item.getElementsByTagName("componentName")[0];
	       var quantity  = item.getElementsByTagName("quantity")[0];
	       var expiryDate  = item.getElementsByTagName("expiryDate")[0];
	      // var bag  = item.getElementsByTagName("bag")[0];
	       var stockMainId=item.getElementsByTagName("stockMainId")[0];
	      var stockDetailId=item.getElementsByTagName("stockDetailId")[0];
	      var bagNo=item.getElementsByTagName("bag")[0];
	     // var tubeNo=item.getElementsByTagName("tubeNo")[0];
	      // document.getElementById("bagnumberId").value=bag.childNodes[0].nodeValue;
	       document.getElementById("mydropdownId").value=bloodgroup.childNodes[0].nodeValue;
	       
	      /* obj.length++;
			obj.options[obj.length-1].value=bagNoID.childNodes[0].nodeValue;
			obj.options[obj.length-1].text=bagNo.childNodes[0].nodeValue;*/
	       
	     // document.getElementById("compId").value=componentName.childNodes[0].nodeValue;
	       document.getElementById("qty1").value=quantity.childNodes[0].nodeValue;
	     //  document.getElementById("expiryId").value=expiryDate.childNodes[0].nodeValue;
	       
	       document.getElementById("stockMainId").value=stockMainId.childNodes[0].nodeValue;
	      // alert(stockDetailId.childNodes[0].nodeValue)
	       document.getElementById("stockDetailId").value=stockDetailId.childNodes[0].nodeValue;
	       document.getElementById("bloodBagNo1").value=bagNo.childNodes[0].nodeValue;
	       
	}
}
}
if(bloodBag !=""){
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
xmlHttp.open("GET",url,true);
}
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
}

 function populateComponentExpiry(componentId,inc) {
		//alert(inc);
		action="/hms/hms/bloodBank?method=populateComponentExpirydetails&componentId="+componentId+"&inc="+inc;
		obj = eval('document.bloodSeperation')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    	   //	action="/hms/hms/account?method=showAccountCrBalance&accountId="+accountId+"&voucherDate="+voucherDate;
var xmlHttp;
try {
//Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}catch (e){
//Internet Explorer
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
obj =document.getElementById("stockBags");
xmlHttp.onreadystatechange=function()
{
if(xmlHttp.readyState==4){
	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	for (loop = 0; loop < items.childNodes.length; loop++) {
	
	   	    var item = items.childNodes[loop];
	       var expiryDate  = item.getElementsByTagName("expiryDate")[0];
	   	 var colName  = item.getElementsByTagName("colName")[0];
	      
	       document.getElementById(colName.childNodes[0].nodeValue).value=expiryDate.childNodes[0].nodeValue;
	       
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
}

 
 function populateBagDetalForIndent(bloodGroupId,componentId) {
	// alert()
		//alert(inc);
		action="/hms/hms/bloodBank?method=populateBagDetalForIndent&componentId="+componentId+"&bloodGroupId="+bloodGroupId;
		obj = eval('document.issueOfIndent')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    	   //	action="/hms/hms/account?method=showAccountCrBalance&accountId="+accountId+"&voucherDate="+voucherDate;
var xmlHttp;
try {
//Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}catch (e){
//Internet Explorer
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
obj =document.getElementById("stockBags");
xmlHttp.onreadystatechange=function()
{
if(xmlHttp.readyState==4){
	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	for (loop = 0; loop < items.childNodes.length; loop++) {
	
	   	    var item = items.childNodes[loop];
	       var expiryDate  = item.getElementsByTagName("expiryDate")[0];
	   	 var bagNo  = item.getElementsByTagName("bagNo")[0];
	   	 var quantity  = item.getElementsByTagName("quantity")[0];
	      
	       document.getElementById('ExpiryDateId').value=expiryDate.childNodes[0].nodeValue;
	       
	       document.getElementById('quantityId').value=quantity.childNodes[0].nodeValue;
	       
	       document.getElementById('bagNumId').value=bagNo.childNodes[0].nodeValue;
	    
	       
	       document.getElementById('hiddenComponentNameId').value=componentId;
	   //    alert( document.getElementById('hiddenComponentNameId').value);   
	       
	       document.getElementById('hiddenBloodGroupId').value=bloodGroupId;
	       
	       
	       
	       
	       
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
xmlHttp.open("GET",url,false);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
}
// Populate Asset Category  based on Assest Group
 
 function populateImmovableStoreItemCategory(storeSectionId){
	
	 action="/hms/hms/procurement?method=populateImmovableStoreItemCategory&storeSectionId="+storeSectionId;
		obj = eval('document.immuableAssestDetails')
		       obj.action = action;
	    	   	 var url=action;
	    	   
var xmlHttp=null;
try {
//Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}catch (e){
//Internet Explorer
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
itemobj=document.getElementById('itemId');
itemobj.length=1;

obj=document.getElementById('immovableassetCategory');
obj.length=1;

xmlHttp.onreadystatechange=function()
{
if(xmlHttp.readyState==4){
	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	for (loop = 0; loop < items.childNodes.length; loop++) {
	
	   	    var item = items.childNodes[loop];
	   	 
	       var itemName  = item.getElementsByTagName("itemName")[0];
	   	 var itemId  = item.getElementsByTagName("itemId")[0];
	   	
	   /*  alert(itemId);*/
	   	obj.length++;
			obj.options[obj.length-1].value=itemId.childNodes[0].nodeValue;
			obj.options[obj.length-1].text=itemName.childNodes[0].nodeValue;
	   	 
	     //  document.getElementById('assetCategory').value=itemName.childNodes[0].nodeValue;
	        
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
xmlHttp.open("GET",url,false);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
	 
 }
 
 
 function populateCodeByItemName(itemNameId){
		// alert(itemNameId)
		 action="/hms/hms/procurement?method=populateCodeByItemName&itemNameId="+itemNameId;
			obj = eval('document.assestDetails')
			       obj.action = action;
		    	   	 var url=action
		    	   
	var xmlHttp=null;
	try {
	//Firefox, Opera 8.0+, Safari
	xmlHttp=new XMLHttpRequest();
	}catch (e){
	//Internet Explorer
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
	obj=document.getElementById('itemId');
	 obj.length=1;
	
	xmlHttp.onreadystatechange=function()
	{
	if(xmlHttp.readyState==4){
		var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		for (loop = 0; loop < items.childNodes.length; loop++) {
		
		   	    var item = items.childNodes[loop];
		   	 var itemName = item.getElementsByTagName("itemName")[0]; /*added by amit das on 02-09-2016*/
		     var pvsm_no  = item.getElementsByTagName("pvsm_no")[0];
		   	 var itemId  = item.getElementsByTagName("itemId")[0];
		   	
		   /*  alert(itemId);*/
		   	obj.length++;
				obj.options[obj.length-1].value=itemId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=itemName.childNodes[0].nodeValue+"["+pvsm_no.childNodes[0].nodeValue+"]"; /*changed by amit das on 02-09-2016*/
		   	 
		     //  document.getElementById('assetCategory').value=itemName.childNodes[0].nodeValue;
		        
		}
	}
	}
	var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	xmlHttp.open("GET",url,false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);
		 
	 }
 
// Populate Item Name based on code for Store
 
 function populateStoreItemNameByCode(itemCode){
	 action="/hms/hms/procurement?method=populateStoreItemNameByCode&itemCode="+itemCode;
		obj = eval('document.assestDetails')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    	   
var xmlHttp;
try {
//Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}catch (e){
//Internet Explorer
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
	   	    
	       var itemName  = item.getElementsByTagName("itemName")[0];
	   	
	       document.getElementById('assetName').value=itemName.childNodes[0].nodeValue;
	        
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
xmlHttp.open("GET",url,false);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
	 
 }
 
 function populateImmovableCodeByItemName(itemNameId){
		// alert(itemNameId)
		 action="/hms/hms/procurement?method=populateImmovableCodeByItemName&itemNameId="+itemNameId;
			obj = eval('document.immuableAssestDetails')
			       obj.action = action;
		    	   	 var url=action;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
		    	   
	var xmlHttp=null;
	try {
	//Firefox, Opera 8.0+, Safari
	xmlHttp=new XMLHttpRequest();
	}catch (e){
	//Internet Explorer
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
	obj=document.getElementById('itemId');
	 obj.length=1;
	
	xmlHttp.onreadystatechange=function()
	{
	if(xmlHttp.readyState==4){
		var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		for (loop = 0; loop < items.childNodes.length; loop++) {
		
		   	    var item = items.childNodes[loop];

			   	 var itemName = item.getElementsByTagName("itemName")[0]; /*added by amit das on 02-09-2016*/
		       var pvsm_no  = item.getElementsByTagName("pvsm_no")[0];
		   	 var itemId  = item.getElementsByTagName("itemId")[0];
		   	
		   /*  alert(itemId);*/
		   	obj.length++;
				obj.options[obj.length-1].value=itemId.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=itemName.childNodes[0].nodeValue+"["+pvsm_no.childNodes[0].nodeValue+"]"; /*changed by amit das on 02-09-2016*/
		   	 
		     //  document.getElementById('assetCategory').value=itemName.childNodes[0].nodeValue;
		        
		}
	}
	}
	var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	xmlHttp.open("GET",url,false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);
		 
	 }




 function populateImmovableStoreItemNameByCode(itemCode){
		// alert(itemCode);
		 action="/hms/hms/procurement?method=populateStoreItemNameByCode&itemCode="+itemCode;
			obj = eval('document.immuableAssestDetails')
			       obj.action = action;
		    	   	 var url=action;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
		    	   
	var xmlHttp;
	try {
	//Firefox, Opera 8.0+, Safari
	xmlHttp=new XMLHttpRequest();
	}catch (e){
	//Internet Explorer
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
		   	    
		       var itemName  = item.getElementsByTagName("itemName")[0];
		   	
		       document.getElementById('assetsNameId').value=itemName.childNodes[0].nodeValue;
		        
		}
	}
	}
	var url=action;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	xmlHttp.open("GET",url,false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);
		 
	 }
 function populateIssueQuantityDetails(bldIndentIssueMId) {
		
		//alert(inc);
		action="/hms/hms/bloodBank?method=populateIssueQuantityDetails&bldIndentIssueMId="+bldIndentIssueMId;
		obj = eval('document.bloodAcknowledgmentForm')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    	   //	action="/hms/hms/account?method=showAccountCrBalance&accountId="+accountId+"&voucherDate="+voucherDate;
var xmlHttp;
try {
//Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}catch (e){
//Internet Explorer
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
obj =document.getElementById("stockBags");
xmlHttp.onreadystatechange=function()
{
if(xmlHttp.readyState==4){
	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	for (loop = 0; loop < items.childNodes.length; loop++) {
	
	   	    var item = items.childNodes[loop];
	   	    
	       var requestQuantity  = item.getElementsByTagName("requestQuantity")[0];
	   	 var issuedQuantity  = item.getElementsByTagName("issuedQuantity")[0];
	   	 
	   	 var bldIndentIssueMNameId=item.getElementsByTagName("bldIndentIssueMNameId")[0];
	   	// var quantity  = item.getElementsByTagName("quantity")[0];
	   	
	       document.getElementById('quantityRequiredId').value=requestQuantity.childNodes[0].nodeValue;
	       
	       document.getElementById('quantityIssuedId').value=issuedQuantity.childNodes[0].nodeValue;
	       
	       document.getElementById('quantityRecivedId').value=issuedQuantity.childNodes[0].nodeValue;
	       
	       document.getElementById('bldIndentIssueMNameId').value=bldIndentIssueMNameId.childNodes[0].nodeValue;
	           
	       
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
xmlHttp.open("GET",url,false);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
}

	 
// Populate Asset Category  based on Assest Group
 
 function populateStoreItemCategory(storeSectionId){
	/* alert(storeSectionId)*/
	 action="/hms/hms/procurement?method=populateStoreItemCategory&storeSectionId="+storeSectionId;
		obj = eval('document.assestDetails')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    	   
var xmlHttp=null;
try {
//Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}catch (e){
//Internet Explorer
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
itemobj=document.getElementById('itemId');
itemobj.length=1;

obj=document.getElementById('assetCategory');
obj.length=1;

xmlHttp.onreadystatechange=function()
{
if(xmlHttp.readyState==4){
	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	for (loop = 0; loop < items.childNodes.length; loop++) {
	
	   	    var item = items.childNodes[loop];
	   	 
	       var itemName  = item.getElementsByTagName("itemName")[0];
	   	 var itemId  = item.getElementsByTagName("itemId")[0];
	   	
	   /*  alert(itemId);*/
	   	obj.length++;
			obj.options[obj.length-1].value=itemId.childNodes[0].nodeValue;
			obj.options[obj.length-1].text=itemName.childNodes[0].nodeValue;
	   	 
	     //  document.getElementById('assetCategory').value=itemName.childNodes[0].nodeValue;
	        
	}
}
}

var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
xmlHttp.open("GET",url,false);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
	 
 }
 
 
//Populate masInstitution in Display
//Populate masInstitution in Display
 function populatMasInstitute(hospitalIdd) {
 	//alert("check "+hospitalIdd);
 	//document.getElementById("hospitalIdd").value="";
     var xmlHttp=null;
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
    obj =document.getElementById("deptNameId");
    obj.length = 1;
   
     xmlHttp.onreadystatechange=function()
     {
       if(xmlHttp.readyState==4){
     	
       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
 	   	    var item = chargeCodes.childNodes[loop];

 	   	 var DepatName  = item.getElementsByTagName("deptName")[0];
 	   
 	        var DeptId  = item.getElementsByTagName("deptNameId")[0];
 	  
 	        obj.length++;
 	    
 				obj.options[obj.length-1].value=DeptId.childNodes[0].nodeValue
 				obj.options[obj.length-1].text= DepatName.childNodes[0].nodeValue
 				
       	}
       
       }
     }
     xmlHttp.open("GET","/hms/hms/opd?method=populatMasInstitute&hospitalIdd="+hospitalIdd+'&'+csrfTokenName+'='+csrfTokenValue,false);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
    
   }
 	 
 function populateSecondOpinionForm(secondOpinionId,secondPatientOpinionId,visitId) {
			 	//alert("check "+secondPatientOpinionId);
			 	//document.getElementById("hospitalIdd").value="";
			     var xmlHttp=null;
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
			   /* obj =document.getElementById("deptNameId");
			    obj.length = 1;
			   */
			     xmlHttp.onreadystatechange=function()
			     {
			       if(xmlHttp.readyState==4){
			     	
			       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

			       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
			 	   	    var item = chargeCodes.childNodes[loop];
			 	   	   
			 	   	 var patientDetailsStatus  = item.getElementsByTagName("patientDetailsStatus")[0];   
			 	   	 var ehr  = item.getElementsByTagName("ehr")[0];
			 	     var comments  = item.getElementsByTagName("comments")[0];
			 	     var uhidNo  = item.getElementsByTagName("uhidNo")[0];
			 	     var visitNo=item.getElementsByTagName("visitNo")[0];
			 	     var provisionalDiagnosis = item.getElementsByTagName("provisionalDiagnosis")[0];
			 	     var finalDiagnosis = item.getElementsByTagName("finalDiagnosis")[0];
			 	    //alert(visitNo.childNodes[0].nodeValue)
			 	    document.getElementById("patientDetailsStatus").value = patientDetailsStatus.childNodes[0].nodeValue; 
			 	    document.getElementById("visitNoId").value = visitNo.childNodes[0].nodeValue;
			 	   document.getElementById("secondOpinionId").value = secondOpinionId;
			 	  document.getElementById("secondOpinionVisitId").value = visitId;
			 	  
			 	 document.getElementById("provisionalDiagnosis").style.display = "block";
		 	     document.getElementById("provisionalDiagnosis").value = provisionalDiagnosis.childNodes[0].nodeValue;
		 	     
		 	     document.getElementById("finalDiagnosis").style.display = "block";
		 	     document.getElementById("finalDiagnosis").value = finalDiagnosis.childNodes[0].nodeValue;
		 	     
			 	      document.getElementById("docnote").style.display = "block";
			 	     document.getElementById("docnote").value = comments.childNodes[0].nodeValue;
			 	       
			 	    document.getElementById("docRemark").style.display = "block";
			 	     
			 	     
			 	      document.getElementById("opinionId").value = "block";
			 	       document.getElementById("opinionId").style.display = "block";
			 	  
			 	       document.getElementById("patientEharId").style.display = "block";
			 	      document.getElementById("patientEharIdUhid").value = uhidNo.childNodes[0].nodeValue
			 	      
			 	     document.getElementById("InvestigationId").style.display = "block";
			 	      
			 	     var hin_id  = item.getElementsByTagName("hin_id")[0];
			 	    document.getElementById("hin_id").value = hin_id.childNodes[0].nodeValue
			 	      
			       	}
			       
			       }
			     }
			     xmlHttp.open("GET","/hms/hms/opd?method=populateSecondOpinionForm&secondOpinionId="+secondOpinionId+'&'+csrfTokenName+'='+csrfTokenValue,false);
			     xmlHttp.setRequestHeader("Content-Type", "text/xml");
			     xmlHttp.send(null);
			    
			   }
 
 function populateInvestigationOrder(uhidNo){
	// alert(departmentId)
	 
		//var uhidNo=document.getElementById('uhid').value;
	     var xmlHttp=null;
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
	    /*obj =document.getElementById("investigationId");
	    obj.length = 1;*/
	   
	   obj =document.getElementById("OrderNoId");
	    obj.length = 1;
	   
	     xmlHttp.onreadystatechange=function()
	     {
	       if(xmlHttp.readyState==4){
	     	
	       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

	       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	 	   	    var item = chargeCodes.childNodes[loop];
	 	   	    
	 	   	    var patientName =item.getElementsByTagName("patientName")[0];
	 	   	    /*var dgSampleDetailsId  = item.getElementsByTagName("dgSampleDetailsId")[0];
	 	   	    var investigationName  = item.getElementsByTagName("investigationName")[0];*/
	 	   	    
	 	   	var dgOrderHdId  = item.getElementsByTagName("dgOrderHdId")[0];
 	   	    var dgOrderNo  = item.getElementsByTagName("dgOrderNo")[0];
	 	   
	 	    document.getElementById('patientNameId').value=patientName.childNodes[0].nodeValue;
	 	   obj.length++;
	 	    
			obj.options[obj.length-1].value=dgOrderHdId.childNodes[0].nodeValue
			obj.options[obj.length-1].text= dgOrderNo.childNodes[0].nodeValue
	       
	 	    
	 	   /* obj.length++;
	 	    
				obj.options[obj.length-1].value=dgSampleDetailsId.childNodes[0].nodeValue
				obj.options[obj.length-1].text= investigationName.childNodes[0].nodeValue
	 	       */
	       	}
	       
	       }
	     }
			
	     xmlHttp.open("GET","/hms/hms/appointment?method=populateInvestigationOrder&uhidNo="+uhidNo+'&'+csrfTokenName+'='+csrfTokenValue,false);
	     xmlHttp.setRequestHeader("Content-Type", "text/xml");
	     xmlHttp.send(null);
	    
 }
 function populatePatientinvestigation(orderId){
	
	 
		var uhidNo=document.getElementById('uhid').value;
	     var xmlHttp=null;
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
	    obj =document.getElementById("investigationId");
	    obj.length = 1;
	   
	  
	   
	     xmlHttp.onreadystatechange=function()
	     {
	       if(xmlHttp.readyState==4){
	     	
	       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

	       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	 	   	    var item = chargeCodes.childNodes[loop];
	 	   	    
	 	   	  //  var patientName =item.getElementsByTagName("patientName")[0];
	 	   	    /*var dgSampleDetailsId  = item.getElementsByTagName("dgSampleDetailsId")[0];
	 	   	    var investigationName  = item.getElementsByTagName("investigationName")[0];*/
	 	   	    
	 	   	var dgOrderdtId  = item.getElementsByTagName("dgOrderdtId")[0];
 	   	    var dgOrderName  = item.getElementsByTagName("dgOrderName")[0];
	 	  /*  document.getElementById('patientNameId').value=patientName.childNodes[0].nodeValue;*/
	 	  /* obj.length++;*/
	 	    
			obj.options[obj.length-1].value=dgOrderdtId.childNodes[0].nodeValue
			obj.options[obj.length-1].text= dgOrderName.childNodes[0].nodeValue
	       
	 	    
	 	    obj.length++;
			/*
				obj.options[obj.length-1].value=dgSampleDetailsId.childNodes[0].nodeValue
				obj.options[obj.length-1].text= investigationName.childNodes[0].nodeValue
	 	       */
	       	}
	       
	       }
	     }
			
	     xmlHttp.open("GET","/hms/hms/appointment?method=populatePatientinvestigation&orderId="+orderId+'&'+csrfTokenName+'='+csrfTokenValue,false);
	     xmlHttp.setRequestHeader("Content-Type", "text/xml");
	     xmlHttp.send(null);
	    
 }
 
 
 function submitProtoAjaxForSurvey(formName,action,divName){

	 	var fromDateForm=document.getElementById("fromDateId").value;
		var toDateForm=document.getElementById("toDateId").value;
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
		else{

	 	var fromDate=document.getElementById("fromDateId").value;
	 	var toDate=document.getElementById("toDateId").value;
	 	


	 	errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		       	obj.action = action;
	    	   	 var url=action+"&fromDate="+fromDate+"&toDate="+toDate;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	        	 new Ajax.Updater(divName,url,{asynchronous:true, evalScripts:true });
	     }
		       	return true;
	   }

// function patientList(uhinId,formName,mlcType) {
	// 	action="/hms/hms/mlc?method=getPaitentDetail&uhinId="+uhinId+"&mlcType="+mlcType;

 function patientList(uhinId,formName) {
	 	action="/hms/hms/mlc?method=getPaitentDetail&uhinId="+uhinId;
		obj = eval('document.'+formName)
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
 
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
	   	   
	   	/*  var msg  = item.getElementsByTagName("msg")[0];
	   	  if(msg!=undefined){
	   		  alert(msg.childNodes[0].nodeValue);
	   		  return false;
	   	  }else{*/
	   		  var name  = item.getElementsByTagName("name")[0];
	   		  var age  = item.getElementsByTagName("age")[0];
	   		  var Occupation  = item.getElementsByTagName("Occupation")[0];
	   		  var Gender  = item.getElementsByTagName("Gender")[0];
	   		  var hinId  = item.getElementsByTagName("hinId")[0];

	   		  if(hinId !=undefined && hinId.childNodes[0] !=undefined && document.getElementById("hinId"))
	   			  document.getElementById("hinId").value = hinId.childNodes[0].nodeValue

   			  if(age !=undefined && age.childNodes[0] !=undefined && document.getElementById("age"))
   				  document.getElementById("age").value = age.childNodes[0].nodeValue

			  if(name !=undefined && name.childNodes[0] !=undefined && document.getElementById("pname"))
				  document.getElementById("pname").value = name.childNodes[0].nodeValue

			  if(Occupation !=undefined && Occupation.childNodes[0] !=undefined && document.getElementById("occupation"))
				  document.getElementById("occupation").value = Occupation.childNodes[0].nodeValue

			  if(Gender !=undefined && Gender.childNodes[0] !=undefined && document.getElementById("gender"))
				  document.getElementById("gender").value = Gender.childNodes[0].nodeValue
   
	   	  //}
	      
   	}
   }
 }
 var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

 xmlHttp.open("GET",url,false);
 xmlHttp.setRequestHeader("Content-Type", "text/xml");
 xmlHttp.send(null);
 

}
 
 function ajaxFunctionForMortuaryRegisterDetails(formName,action) {

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
		   	    var hinId  = item.getElementsByTagName("hinId")[0];
		   	    var mlcId  = item.getElementsByTagName("mlcId")[0];
		       var name  = item.getElementsByTagName("name")[0];
		       var age  = item.getElementsByTagName("age")[0];
		       var Gender  = item.getElementsByTagName("Gender")[0];
		       
		       if(hinId !=undefined && hinId.childNodes[0] !=undefined)
				   document.getElementById("hinId").value = hinId.childNodes[0].nodeValue
		       
		       if(mlcId !=undefined && mlcId.childNodes[0] !=undefined)
				   document.getElementById("mlcId").value = mlcId.childNodes[0].nodeValue
		       
			   	if(age !=undefined && age.childNodes[0] !=undefined)
			   document.getElementById("age").value = age.childNodes[0].nodeValue
			   document.getElementById("receivedDeadBodyAged").value = age.childNodes[0].nodeValue
			   
			   if(name !=undefined && name.childNodes[0] !=undefined)
			   document.getElementById("deceasedName").value = name.childNodes[0].nodeValue
			   document.getElementById("receivedDeadBodyOf").value = name.childNodes[0].nodeValue
			   
			   
			   if(Gender !=undefined && Gender.childNodes[0] !=undefined)
			   document.getElementById("gender").value = Gender.childNodes[0].nodeValue
			   
			
		      
		}
	}
	}
	var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	
	xmlHttp.open("GET",url,false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);


}
 
 function ajaxFunctionForPostmortemDetails(formName,action) {
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
		   	    var hinId  = item.getElementsByTagName("hinId")[0];
		   	    var mlcId  = item.getElementsByTagName("mlcId")[0];
		   	    var mortuaryId  = item.getElementsByTagName("mortuaryId")[0];
		       var name  = item.getElementsByTagName("name")[0];
		       var age  = item.getElementsByTagName("age")[0];
		       var Gender  = item.getElementsByTagName("Gender")[0];
		       var crimeNo  = item.getElementsByTagName("crimeNo")[0];
		       var crimeDate  = item.getElementsByTagName("crimeDate")[0];
		       var height  = item.getElementsByTagName("height")[0];
		       var weight  = item.getElementsByTagName("weight")[0];
		       var keptDate  = item.getElementsByTagName("keptDate")[0];
		       var keptTime  = item.getElementsByTagName("keptTime")[0];
		       var policeStation  = item.getElementsByTagName("policeStation")[0];
		       
		       if(hinId !=undefined && hinId.childNodes[0] !=undefined){
				   document.getElementById("hinId").value = hinId.childNodes[0].nodeValue
		       }
		       
		       if(mlcId !=undefined && mlcId.childNodes[0] !=undefined){
				   document.getElementById("mlcId").value = mlcId.childNodes[0].nodeValue
		       }
				   
				   if(mortuaryId !=undefined && mortuaryId.childNodes[0] !=undefined){
					   document.getElementById("mortuaryId").value = mortuaryId.childNodes[0].nodeValue
				   }
		       
			   	if(age !=undefined && age.childNodes[0] !=undefined){
			   document.getElementById("age").value = age.childNodes[0].nodeValue
			  // alert(age.childNodes[0].nodeValue);
			   	}
			   
			   	if(name !=undefined && name.childNodes[0] !=undefined){
			 	document.getElementById("deceasedName").value = name.childNodes[0].nodeValue
			   }
			   
			   
			   
			   if(Gender !=undefined && Gender.childNodes[0] !=undefined){
			   document.getElementById("gender").value = Gender.childNodes[0].nodeValue
			   }
			   
			   if(crimeNo !=undefined && crimeNo.childNodes[0] !=undefined){
				   document.getElementById("crimeNoId").value = crimeNo.childNodes[0].nodeValue
			   }
				  
				   if(crimeDate !=undefined && crimeDate.childNodes[0] !=undefined){
					   document.getElementById("crimeDate").value = crimeDate.childNodes[0].nodeValue
				   }
				   
					   if(height !=undefined && height.childNodes[0] !=undefined){
						   document.getElementById("height").value = height.childNodes[0].nodeValue
					   }
				   
						   if(weight !=undefined && weight.childNodes[0] !=undefined){
							   document.getElementById("weight").value = weight.childNodes[0].nodeValue
						   }
							   
							   if(keptDate !=undefined && keptDate.childNodes[0] !=undefined){
								   document.getElementById("bodyKeptDate").value = keptDate.childNodes[0].nodeValue
							   }
								  
								   
								   if(keptTime !=undefined && keptTime.childNodes[0] !=undefined){
									   document.getElementById("bodyKeptTime").value = keptTime.childNodes[0].nodeValue
								   }
								   
								   if(policeStation !=undefined && policeStation.childNodes[0] !=undefined){
									   document.getElementById("policeStation").value = policeStation.childNodes[0].nodeValue
								   }
									  
							  
					   
			
		      
		}
	}
	}
	var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	
	xmlHttp.open("GET",url,false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);


}
 
 function displayUnitHeadeName(unitId) {
		//var depatmentId=0;
		  //var hospitalId=document.getElementById('hospitalNameId').value;
		  //document.getElementById("unit").options.length = 0;

		  var xmlHttp=null;
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
		 // obj = document.getElementById("unit");
		 // obj.length=1;
		  
		  
			/*obj.options[0].value=0;
			obj.options[0].text="select";*/
		    xmlHttp.onreadystatechange=function()
		    {
		      if(xmlHttp.readyState==4){

		      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		      	//alert("items"+items)
		      
				
		      	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	    var item = items.childNodes[loop];
			   	 var empName  = item.getElementsByTagName("empName")[0];
			        
			   	 if(empName !=undefined && empName.childNodes[0] !=undefined){
					   document.getElementById("headName").value = empName.childNodes[0].nodeValue
				   }

		      	}
		      }
		    }
		 
		       var url="/hms/hms/adt?method=displayUnitHeadName&hospitalUnitId="+unitId;
	    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
		    xmlHttp.open("GET",url,false);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		    populateDoctorForDepartment(sdValues);
		  }
 

 function checkDataOrderNo(obj,rowVal){	

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
		   	    var msg  = item.getElementsByTagName("msg")[0];
		       
		       if(msg !=undefined && msg.childNodes[0] !=undefined){
				   alert(msg.childNodes[0].nodeValue);
		       document.getElementById('appOrderNo'+rowVal).value=""
		}
		}
	}
	}
	var url='/hms/hms/user?method=checkAppOrderNo&appOrderNo='+obj;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	
	xmlHttp.open("GET",url,false);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);


}

 function getDetails(val,deptId) {
		action="/hms/hms/appointment?method=getAppDetails&deptId="+deptId+"&sessionId="+val;
		obj = eval('document.appSetup')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

var xmlHttp=null;
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
var inc=0;
var status=false; 
xmlHttp.onreadystatechange=function()
{
if(xmlHttp.readyState==4){
	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	   	   
	       var appId  = item.getElementsByTagName("appId")[0];
	       var tokenStartNo  = item.getElementsByTagName("tokenStartNo")[0];
	       var tokenInterval  = item.getElementsByTagName("tokenInterval")[0];
	       var totalToken  = item.getElementsByTagName("totalToken")[0];
	       var maxDaysNo  = item.getElementsByTagName("maxDaysNo")[0];
	       var minDaysNo  = item.getElementsByTagName("minDaysNo")[0];
	      var numberOfPatients=item.getElementsByTagName("numberOfPatients")[0];
	     
	  
	if(undefined !=tokenStartNo.childNodes[0]){
	 document.getElementById("TokenStart"+inc).value = tokenStartNo.childNodes[0].nodeValue
	 status=true;
	}
	 else{
		 document.getElementById("TokenStart"+inc).value =""
	 }
	 if(undefined !=tokenInterval.childNodes[0]){
	 document.getElementById("TokenInterval"+inc).value = tokenInterval.childNodes[0].nodeValue
	 status=true;
	 }
	 else{
		 document.getElementById("TokenInterval"+inc).value = "";
	 }
	 if(undefined !=totalToken.childNodes[0]){
	 document.getElementById("TotalToken"+inc).value = totalToken.childNodes[0].nodeValue
	 status=true;
	 }
	 else{
		 document.getElementById("TotalToken"+inc).value ="";
	 }
	 if(undefined !=maxDaysNo.childNodes[0]){
	 document.getElementById("maxDays"+inc).value = maxDaysNo.childNodes[0].nodeValue
	 }
	 else{
		 document.getElementById("maxDays"+inc).value = ""; 
	 }
	 if(undefined !=minDaysNo.childNodes[0]){
	 document.getElementById("minDays"+inc).value = minDaysNo.childNodes[0].nodeValue
	 }else{
		 document.getElementById("minDays"+inc).value =""; 
	 }
	 if(numberOfPatients!=undefined && undefined !=numberOfPatients.childNodes[0]){
		 document.getElementById("numberofPatient"+inc).value = numberOfPatients.childNodes[0].nodeValue
		 }else{
			 document.getElementById("numberofPatient"+inc).value =""; 
		 }
	 if(undefined !=appId.childNodes[0]){
	 document.getElementById("appointmentId"+inc).value = appId.childNodes[0].nodeValue
	 status=true;// added by govind on 10-01-2017
	 }
	 else{
		 document.getElementById("appointmentId"+inc).value ="";
	 }
			   inc++;
	 if(status){
	document.getElementById("updateId").style.display = 'block';
		document.getElementById("addId").style.display = 'none';
	 }
	 else{
		 document.getElementById("updateId").style.display = 'none';
			document.getElementById("addId").style.display = 'block';
	 }
	
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

xmlHttp.open("GET",url,false);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);


}


 function hospitalList(formName){
 		obj1 = eval('document.'+formName+'.loginName');
 		obj2 = eval('document.'+formName+'.password');
 		loginName = obj1.value;
 		password = obj2.value;
 	if(password != "")
 	{
 		
 			url="/hms/hms/login?method=getHospitalName&loginName="+loginName+"&password="+password;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
 			obj = eval('document.'+formName)
		       obj.action = url;

 			new Ajax.Updater('responseList',url,
			   {asynchronous:true, evalScripts:true });

 		   }
 	

    }
 function getServiceCentre(hospitalId,empId,userType){
	 
		if(hospitalId!=0){
	     var xmlHttp=null;
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
	    obj =document.getElementById("department");
	    obj.length = 1;
	   
	     xmlHttp.onreadystatechange=function()
	     {
	       if(xmlHttp.readyState==4){
	     	
	       	var item =xmlHttp.responseXML.getElementsByTagName('items')[0];
	       	
	       	if(item.getElementsByTagName("deptList")[0]!=undefined){
	       	 var deptList  = item.getElementsByTagName("deptList")[0];

		        for(innerLoop = 0;innerLoop < deptList.childNodes.length;innerLoop++){
		        	var dept = deptList.childNodes[innerLoop];
		        	if(dept.getElementsByTagName("deptId")[0]!=undefined){
		        		var deptId  = dept.getElementsByTagName("deptId")[0];
		        		var deptName  = dept.getElementsByTagName("deptName")[0];
		        		obj.length++;
		        		obj.options[obj.length-1].value=deptId.childNodes[0].nodeValue;
		        		obj.options[obj.length-1].text=deptName.childNodes[0].nodeValue;
		        	}
	        	
		        }
	       		
	       	}else if(item.getElementsByTagName("msg")[0]!=undefined){
        		
        		alert(item.getElementsByTagName("msg")[0].childNodes[0].nodeValue);
        		return false
        	}
	       
	       }
	     }
	     xmlHttp.open("GET","/hms/hms/login?method=getServiceCentreList&hospitalId="+hospitalId+'&empId='+empId+'&userType='+userType+'&'+csrfTokenName+'='+csrfTokenValue,false);
	     xmlHttp.setRequestHeader("Content-Type", "text/xml");
	     xmlHttp.send(null);
		}
 }

 
 function populateChargeAmoutForAmbulance() {
	  var chargeId=document.getElementById("ambulanceChargeId").value;
	
	 
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

	       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
	    

	       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	 	   	    var item = chargeCodes.childNodes[loop];
	 	   	 var ChargeableAmount  = item.getElementsByTagName("Charge")[0];
	 	  
	 	   	 if(ChargeableAmount.childNodes[0] != undefined){
	 	       	document.getElementById("chargeId").value=ChargeableAmount.childNodes[0].nodeValue
	 	   	 }
	 	   	//document.getElementById("balanceToBePaidId").value=ChargeableAmount.childNodes[0].nodeValue
	 	   //document.getElementById("amountTenderedId").value=ChargeableAmount.childNodes[0].nodeValue
	 	   
	 	 /*  var schemeId=document.getElementById('VisitschemeId').value;
	 	       	if(scheme>0){
	 	       //	Visitscheme(schemeId,chargeId)
	 	       		
	 	       	}*/

	 	       
	       	}
	       }
	     }
	     if(chargeId>0){
	     xmlHttp.open("GET","/hms/hms/ipd?method=populateChargeAmoutForAmbulance&chargeId="+chargeId+'&'+csrfTokenName+'='+csrfTokenValue,true);
	  	
	     }
	    /* else{
	    	 document.getElementById("amountId").value="0.0";
	 	  	document.getElementById("balanceToBePaidId").value="0.0";
	 		document.getElementById("amountTenderedId").value="0.0";
	 		document.getElementById("discountPercentText").value="";
	 		document.getElementById("discountPerAmountTextId").value="";
	 		document.getElementById("revisedCreditBalanceId").value="";
	 		
	     }*/
	     xmlHttp.setRequestHeader("Content-Type", "text/xml");
	     xmlHttp.send(null);

	   }
 function getServiceCentre(hospitalId,empId,userType){
	 
		if(hospitalId!=0){
	     var xmlHttp=null;
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
	    obj =document.getElementById("department");
	    obj.length = 1;
	   
	     xmlHttp.onreadystatechange=function()
	     {
	       if(xmlHttp.readyState==4){
	     	
	       	var item =xmlHttp.responseXML.getElementsByTagName('items')[0];
	       	
	       	if(item.getElementsByTagName("deptList")[0]!=undefined){
	       	 var deptList  = item.getElementsByTagName("deptList")[0];

		        for(innerLoop = 0;innerLoop < deptList.childNodes.length;innerLoop++){
		        	var dept = deptList.childNodes[innerLoop];
		        	if(dept.getElementsByTagName("deptId")[0]!=undefined){
		        		var deptId  = dept.getElementsByTagName("deptId")[0];
		        		var deptName  = dept.getElementsByTagName("deptName")[0];
		        		obj.length++;
		        		obj.options[obj.length-1].value=deptId.childNodes[0].nodeValue;
		        		obj.options[obj.length-1].text=deptName.childNodes[0].nodeValue;
		        	}
	        	
		        }
	       		
	       	}else if(item.getElementsByTagName("msg")[0]!=undefined){
     		
     		alert(item.getElementsByTagName("msg")[0].childNodes[0].nodeValue);
     		return false
     	}
	       
	       }
	     }
	     xmlHttp.open("GET","/hms/hms/login?method=getServiceCentreList&hospitalId="+hospitalId+'&empId='+empId+'&userType='+userType+'&'+csrfTokenName+'='+csrfTokenValue,false);
	     xmlHttp.setRequestHeader("Content-Type", "text/xml");
	     xmlHttp.send(null);
		}
}

 
function populateDistrictByStateId(stateId) {
	
	  obj=document.getElementById("districtId");
	  obj.length = 1;

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

	       	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
	    

	       	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	       		
	 	   	    var item = chargeCodes.childNodes[loop];
	 	   	    var id  = item.getElementsByTagName("id")[0];
	 	   	    var name = item.getElementsByTagName("name")[0];
	
	 	   	obj.length++;
			obj.options[obj.length-1].value=id.childNodes[0].nodeValue;
			obj.options[obj.length-1].text=name.childNodes[0].nodeValue;

			
	 	       
	       	}
	       }
	     }
	     
	     xmlHttp.open("GET","/hms/hms/bloodBank?method=populateDistrictByStateId&stateId="+stateId+'&'+csrfTokenName+'='+csrfTokenValue,true);
	 
	     xmlHttp.setRequestHeader("Content-Type", "text/xml");
	     xmlHttp.send(null);

	   }


function populateDonorRegistrationFrom(hinNo) {
	
	
	action="/hms/hms/bloodBank?method=populateDonorRegistrationFrom&patientHinNo="+hinNo;
	obj = eval('document.bloodsearch')
	       obj.action = action;
    	   	 var url=action;
	    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

var xmlHttp=null;
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
   	   
       var uhid  = item.getElementsByTagName("Uhid")[0];
       var name  = item.getElementsByTagName("name")[0];
       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
       var age  = item.getElementsByTagName("page")[0];
       var NameOf  = item.getElementsByTagName("NameOf")[0];
       var RelativeName  = item.getElementsByTagName("RelativeName")[0];
       
       var Occupation  = item.getElementsByTagName("Occupation")[0];
       
      
       var Gender  = item.getElementsByTagName("Gender")[0];
    
       var hinId=item.getElementsByTagName("hinId")[0];
       
     var email=item.getElementsByTagName("email")[0];
       var GenderId=item.getElementsByTagName("GenderId")[0];
       
       var stateId=item.getElementsByTagName("stateId")[0];
       var districtId=item.getElementsByTagName("districtId")[0];
       var postOfficeId=item.getElementsByTagName("postOfficeId")[0];
       var postCode=item.getElementsByTagName("postCode")[0];
       var talukId=item.getElementsByTagName("talukId")[0];
       var dob=item.getElementsByTagName("dob")[0];
       //alert(dob.childNodes[0].nodeValue)
       if(dob !=undefined && dob.childNodes[0] !=undefined)
    	   document.getElementById("BirthDateId").value = dob.childNodes[0].nodeValue 
    	
       
       if(postCode !=undefined && postCode.childNodes[0] !=undefined)
    	   document.getElementById("pincodeId").value = postCode.childNodes[0].nodeValue 
    	
       if(postOfficeId !=undefined && postOfficeId.childNodes[0] !=undefined)   
    	    document.getElementById("postOfficeId").value = postOfficeId.childNodes[0].nodeValue 
    
    	    if(districtId !=undefined && districtId.childNodes[0] !=undefined)   
    	  document.getElementById("districtId").value = districtId.childNodes[0].nodeValue 
    	 
    	  if(stateId !=undefined && stateId.childNodes[0] !=undefined)   
    	 document.getElementById("stateId").value = stateId.childNodes[0].nodeValue 
    	 
    	 if(talukId !=undefined && talukId.childNodes[0] !=undefined)
      	   document.getElementById("subdistrictId").value = talukId.childNodes[0].nodeValue 
      	
    	 
    	 
       document.getElementById("donorName").value = name.childNodes[0].nodeValue 
       document.getElementById("donorName").readOnly = true;
       document.getElementById("hinId").value = hinId.childNodes[0].nodeValue 
	   document.getElementById("dUhidId").value = uhid.childNodes[0].nodeValue

	 	if(age !=undefined && age.childNodes[0] !=undefined)
	   document.getElementById("ageId").value = age.childNodes[0].nodeValue
	  
	   document.getElementById("mobileNoId").value = "";
      // document.getElementById("mobileNoId").readOnly = true;
       
	   if(mobileNo.childNodes[0] !=undefined)
	   document.getElementById("mobileNoId").value = mobileNo.childNodes[0].nodeValue
	   
	   
	   if(Occupation.childNodes[0] !=undefined)
	   document.getElementById("occupationId").value = Occupation.childNodes[0].nodeValue
	   
	  
	   document.getElementById("genderId").value = GenderId.childNodes[0].nodeValue
	   document.getElementById("relationNameId").value = RelativeName.childNodes[0].nodeValue 
	   if(email.childNodes[0] !=undefined   )
	   document.getElementById("emailId").value = email.childNodes[0].nodeValue 
	   
	   var assesstSatatus=item.getElementsByTagName("assesstSatatus")[0];
      // alert(assesstSatatus.childNodes[0].nodeValue)
       if(assesstSatatus !=undefined && assesstSatatus.childNodes[0] !=undefined){
    	   var status= assesstSatatus.childNodes[0].nodeValue
    	   if( status == "true" ){
    		  // alert("hi")
    		   document.getElementById("addDonor").style.display="none";
    		   document.getElementById("DonorAssestment").style.display="block";
    		   
    	   }
       }
	}
}
}
var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

xmlHttp.open("GET",url,false);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
testing(hinNo);

}

/*function populateItemDetailFromStock(itemId) {
	
	
	action="/hms/hms/bloodBank?method=populateItemDetailFromStock&itemId="+itemId;
	obj = eval('document.bloodCollection')
	       obj.action = action;
    	   	 var url=action
    	   	tlsgobj=document.getElementById('batchNumberId');
var xmlHttp=null;
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
   	   
       var batchNo  = item.getElementsByTagName("batchNo")[0];
       var ExpiryDate  = item.getElementsByTagName("ExpiryDate")[0];
       
       //alert(dob.childNodes[0].nodeValue)
       if(batchNo !=undefined && batchNo.childNodes[0] !=undefined){
    	   //document.getElementById("batchNumberId").value = batchNo.childNodes[0].nodeValue 
			tlsgobj.length = 1;
			tlsgobj.length++;
			tlsgobj.options[tlsgobj.length-1].value=batchNo.childNodes[0].nodeValue
			
			tlsgobj.options[tlsgobj.length-1].text=batchNo.childNodes[0].nodeValue
		}
      
    	 
}
}
xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
}

}*/

function getBloodBagType(itemId){
	 
	
     var xmlHttp=null;
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
   tlsgobj =document.getElementById("batchNumberId");
   tlsgobj.length = 1;
   
     xmlHttp.onreadystatechange=function()
     {
       if(xmlHttp.readyState==4){
     	
       	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
       	for (loop = 0; loop < items.childNodes.length; loop++) {
       	    var item = items.childNodes[loop];
       	   
       
       	// var deptList  = item.getElementsByTagName("deptList")[0];

       	var batchNo  = item.getElementsByTagName("batchNo")[0];
    	var itemId  = item.getElementsByTagName("itemId")[0];
        var ExpiryDate  = item.getElementsByTagName("ExpiryDate")[0];
        
       // alert(batchNo.childNodes[0].nodeValue)
        if(batchNo !=undefined && batchNo.childNodes[0] !=undefined){
     	   //document.getElementById("batchNumberId").value = batchNo.childNodes[0].nodeValue 
 			//alert(batchNo.childNodes[0].nodeValue)
 			tlsgobj.length++;
 			tlsgobj.options[tlsgobj.length-1].value=itemId.childNodes[0].nodeValue
 			
 			tlsgobj.options[tlsgobj.length-1].text=batchNo.childNodes[0].nodeValue
 		}
       		
       	}
       
       }
     }
     xmlHttp.open("GET","/hms/hms/bloodBank?method=populateItemDetailFromStock&itemId="+itemId+'&'+csrfTokenName+'='+csrfTokenValue,false);
     xmlHttp.setRequestHeader("Content-Type", "text/xml");
     xmlHttp.send(null);
	
}


function populateBagVolume(itemId){
	 
	
    var xmlHttp=null;
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
      	   
      
      	// var deptList  = item.getElementsByTagName("deptList")[0];

      	var volume  = item.getElementsByTagName("volume")[0];
   	//var itemId  = item.getElementsByTagName("itemId")[0];
       var ExpiryDate  = item.getElementsByTagName("ExpiryDate")[0];
       
      // alert(batchNo.childNodes[0].nodeValue)
       if(volume !=undefined && volume.childNodes[0] !=undefined){
    	   document.getElementById("collectedId").value = volume.childNodes[0].nodeValue 
		}/*else{
			document.getElementById("collectedId").value ="";
		}*/
      /* if(ExpiryDate !=undefined && ExpiryDate.childNodes[0] !=undefined){
    	   
    	   document.getElementById("bagExpiryDateIdd").value = ExpiryDate.childNodes[0].nodeValue 
		}*/
      
      		
      	}
      
      }
    }
    xmlHttp.open("GET","/hms/hms/bloodBank?method=populateBagVolume&itemId="+itemId+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
	
}

function populateBagVolumeForBloodCollection(itemId){
	 
	
    var xmlHttp=null;
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
      	   
      
      	// var deptList  = item.getElementsByTagName("deptList")[0];

      //	var volume  = item.getElementsByTagName("volume")[0];
   	//var itemId  = item.getElementsByTagName("itemId")[0];
       var ExpiryDate  = item.getElementsByTagName("ExipryDate")[0];
       
    //  alert(ExpiryDate.childNodes[0].nodeValue)
      
       if(ExpiryDate !=undefined && ExpiryDate.childNodes[0] !=undefined){
    	   //alert(ExpiryDate.childNodes[0].nodeValue)
    	   document.getElementById("bagExpiryDateIdd").value = ExpiryDate.childNodes[0].nodeValue 
		}
       else{
    	   document.getElementById("bagExpiryDateIdd").value ="";  
       }
      
      		
      	}
      
      }
    }
    xmlHttp.open("GET","/hms/hms/bloodBank?method=populateBagVolume1&itemId="+itemId+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
	
}
function populatePPWardByDistrict(districtId) {
	
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
   obj =document.getElementById("pWardId");
   obj.length = 1;
  
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	       
	   	var WardName = item.getElementsByTagName("WardName")[0];
	   	var WardId = item.getElementsByTagName("WardId")[0];

	   	obj.length++;

	   	obj.options[obj.length-1].value=WardId.childNodes[0].nodeValue
	   	obj.options[obj.length-1].text= WardName.childNodes[0].nodeValue
	  
				
				
      	}
      }
    }
    xmlHttp.open("GET","/hms/hms/registration?method=populatePPWardByDistrict&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }

function populateExpiryDateByBatchNo(inc,batchNo,itemId,depId) {
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
   /*obj =document.getElementById("patientDistId");
   obj.length = 1;*/
    xmlHttp.onreadystatechange=function()
    {
    	
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	
      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	   	 
	   	 
	       /* var VillageName  = item.getElementsByTagName("VillageName")[0];
	        var VillageId  = item.getElementsByTagName("VillageId")[0];*/
	        var expiryDate  = item.getElementsByTagName("expiryDate")[0];
	        var stock=item.getElementsByTagName("stock")[0];
	       
	       /* obj.length++;*/
				/*obj.options[obj.length-1].value=VillageId.childNodes[0].nodeValue
				obj.options[obj.length-1].text=VillageName.childNodes[0].nodeValue*/
	        document.getElementById("batchWisestock"+inc).value=stock.childNodes[0].nodeValue
				document.getElementById("expiry"+inc).value=expiryDate.childNodes[0].nodeValue
				
				if(document.getElementById("batchWisestock"+inc).value!=""){
					var batchWiseStok=parseFloat(document.getElementById("batchWisestock"+inc).value);
		            var batchWiseStock=Math.floor(batchWiseStok);
		            var prescribedQty=parseInt(document.getElementById("qtyRequest"+inc).value);
		            
		        if(batchWiseStock>=prescribedQty){
		        	
		        	document.getElementById("qtyIssued"+inc).value=prescribedQty;
		        	var issueQty=prescribedQty;
		        	document.getElementById("qtyPending"+inc).value=prescribedQty-issueQty;
		        	document.getElementById("actualQtyPending"+inc).value=prescribedQty-issueQty;
		        	
		        }else if(batchWiseStock<prescribedQty){
		        	document.getElementById("qtyIssued"+inc).value=batchWiseStock;
		        	var issueQty=batchWiseStock;
		        	document.getElementById("qtyPending"+inc).value=prescribedQty-issueQty;
		        	document.getElementById("actualQtyPending"+inc).value=prescribedQty-issueQty;
		        }
				}
				
      	}
      }
    }
    action="/hms/hms/billing?method=populateExpiryDateByBatchNo&itemId="+itemId+'&inc='+inc+'&batchNo='+batchNo+'&depId='+depId;
    obj = eval('document.patientDrugIssue')
           obj.action = action;
    	   	 var url=action;
        	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue;
   

    xmlHttp.open("GET",url,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.open("GET",url,false);
   // xmlHttp.open("GET","/hms/hms/billing?method=populateExpiryDateByBatchNo&itemId="+itemId+'&inc='+inc+'&batchNo='+batchNo+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }

function eKycAuthentication(name) {
	
	
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
  var aadharNo =document.getElementById("aadhaarNumberId").value;
  var otpTxn=document.getElementById("otpTxn").value;
  var otp=document.getElementById("otp").value;
  // obj.length = 1;
    xmlHttp.onreadystatechange=function()
    {
    	
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	
      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	   	
	   	 
	  var 	authenticateStatus = item.getElementsByTagName("authenticateStatus")[0];
	  var 	ekycstreet = item.getElementsByTagName("ekycstreet")[0];
	  var 	postoffice = item.getElementsByTagName("postoffice")[0];
	  var 	Pincode = item.getElementsByTagName("Pincode")[0];
	  
	  var 	ekycstate = item.getElementsByTagName("ekycstate")[0];
	  
	  var 	ekycdistrict = item.getElementsByTagName("ekycdistrict")[0];
	  
	  
	  var 	sub_district = item.getElementsByTagName("sub_district")[0];
	  var 	Vtc = item.getElementsByTagName("Vtc")[0];
	  
	  var 	Locality = item.getElementsByTagName("Locality")[0];
	  
	  var 	Landmark = item.getElementsByTagName("Landmark")[0];
	  
	  var 	house_no = item.getElementsByTagName("house_no")[0];
	  
	  var 	care_of = item.getElementsByTagName("care_of")[0];
	  
	  var 	ekycemail = item.getElementsByTagName("ekycemail")[0];
	  var 	phone_no = item.getElementsByTagName("phone_no")[0];
	  var 	ekycdob = item.getElementsByTagName("ekycdob")[0];
	  var 	resident_Name = item.getElementsByTagName("resident_Name")[0];
	  var 	aadharNo = item.getElementsByTagName("aadharNo")[0];
	  
	  var gender= item.getElementsByTagName("gender")[0];
	  var yearofBirth= item.getElementsByTagName("yearofBirth")[0];
	  var age= item.getElementsByTagName("age")[0];
	  var unit= item.getElementsByTagName("unit")[0];
	  
	     
	       if(authenticateStatus.childNodes[0].nodeValue=="true"){
	    	   
	    	    if(document.getElementById("pEAadhaarNumberId"))
	    	    	document.getElementById("pEAadhaarNumberId").value=aadharNo.childNodes[0].nodeValue
	    	    
	    	    if(document.getElementById("relativeNameId") && undefined !=care_of && undefined !=care_of.childNodes[0]){
		    	    document.getElementById("relativeNameId").value=care_of.childNodes[0].nodeValue
		    	    }
	    	    
	    	    if(document.getElementById("pNameId") && undefined !=resident_Name && undefined !=resident_Name.childNodes[0]){
	    	    	document.getElementById("pNameId").value=resident_Name.childNodes[0].nodeValue
	    	    }
	    	    if(document.getElementById("dobId") && undefined !=ekycdob && undefined !=ekycdob.childNodes[0]){
	    	    	document.getElementById("dobId").value=ekycdob.childNodes[0].nodeValue
	    	    }
	    	    
	    	    if(document.getElementById("yobId") && undefined !=yearofBirth && undefined !=yearofBirth.childNodes[0]){
	    	    	document.getElementById("yobId").value=yearofBirth.childNodes[0].nodeValue
	    	    }
	    	    
	    	    if(document.getElementById("age") && undefined !=age && undefined !=age.childNodes[0]){
	    	    	document.getElementById("age").value=age.childNodes[0].nodeValue
	    	    }
	    	   // document.getElementById(id).value=care_of.childNodes[0].nodeValue
	    	    if(document.getElementById("pHouseName") && undefined !=house_no && undefined !=house_no.childNodes[0] && undefined !=house_no.childNodes[0].nodeValue){
	    	    	document.getElementById("pHouseName").value=house_no.childNodes[0].nodeValue
	    	    }
	    	   // document.getElementById(id).value=Landmark.childNodes[0].nodeValue
	    	    
	    	  //  document.getElementById(id).value=Locality.childNodes[0].nodeValue
	    	    if(document.getElementById("ageUnitId") && undefined !=unit && undefined !=unit.childNodes[0]){
	    	    var el = document.getElementById("ageUnitId");
	    		  for(var i=0; i<el.options.length; i++) {
	    		    if ( (el.options[i].text).toUpperCase() == (unit.childNodes[0].nodeValue).toUpperCase() ) {
	    		      el.selectedIndex = i;
	    		      break;
	    		    }
	    		  }
	    	    }
	    		  if(document.getElementById("gender") && undefined !=gender && undefined !=gender.childNodes[0]){
	    	    var el = document.getElementById("gender");
	    		  for(var i=0; i<el.options.length; i++) {
	    		    if ( (el.options[i].text).toUpperCase() == (gender.childNodes[0].nodeValue).toUpperCase() ) {
	    		      el.selectedIndex = i;
	    		      break;
	    		    }
	    		  }
	    		  }
	    		  if(document.getElementById("villageId") && undefined !=Vtc && undefined !=Vtc.childNodes[0]){
	    	    var el = document.getElementById("villageId");
	    		  for(var i=0; i<el.options.length; i++) {
	    		    if ( (el.options[i].text).toUpperCase() == (Vtc.childNodes[0].nodeValue).toUpperCase() ) {
	    		      el.selectedIndex = i;
	    		      break;
	    		    }
	    		  }
	    		  }
	    	    if(document.getElementById("SubcityId") && undefined !=sub_district && undefined !=sub_district.childNodes[0]){
	    	    var el = document.getElementById("SubcityId");
	    		  for(var i=0; i<el.options.length; i++) {
	    		    if ( (el.options[i].text).toUpperCase() == (sub_district.childNodes[0].nodeValue).toUpperCase() ) {
	    		      el.selectedIndex = i;
	    		      break;
	    		    }
	    		  }
	    	    }
	    	    if(document.getElementById("cityId") && undefined !=ekycdistrict && undefined !=ekycdistrict.childNodes[0]){
	    	    var el = document.getElementById("cityId");
	    		  for(var i=0; i<el.options.length; i++) {
	    		    if ( (el.options[i].text).toUpperCase() == (ekycdistrict.childNodes[0].nodeValue).toUpperCase() ) {
	    		      el.selectedIndex = i;
	    		      break;
	    		    }
	    		  }
	    		  
	    	    }
	    	   // document.getElementById(id).value=ekycstate.childNodes[0].nodeValue
	    		if(document.getElementById("pincode") && undefined !=Pincode && undefined !=Pincode.childNodes[0])
	    			document.getElementById("pincode").value=Pincode.childNodes[0].nodeValue
	    	   
	    	    if(document.getElementById("postOff") && undefined !=postoffice && undefined !=postoffice.childNodes[0]){
	    	    var el = document.getElementById("postOff");
	    		  for(var i=0; i<el.options.length; i++) {
	    		    if ( (el.options[i].text).toUpperCase() == (postoffice.childNodes[0].nodeValue).toUpperCase() ) {
	    		      el.selectedIndex = i;
	    		      break;
	    		    }
	    		  }
	    	    }
	    		if(document.getElementById("streetName") && undefined !=ekycstreet && undefined !=ekycstreet.childNodes[0] && undefined !=ekycstreet.childNodes[0].nodeValue){
	    			document.getElementById("streetName").value=ekycstreet.childNodes[0].nodeValue
	    		  }
	    	    if(document.getElementById("mobileNoId") && undefined !=phone_no && undefined !=phone_no.childNodes[0] && undefined !=phone_no.childNodes[0].nodeValue){
		    	    document.getElementById("mobileNoId").value=phone_no.childNodes[0].nodeValue
		    	   
		    	    } 
	    	  if(document.getElementById("emailId") && undefined !=ekycemail && undefined !=ekycemail.childNodes[0] && undefined !=ekycemail.childNodes[0].nodeValue)
		    	    document.getElementById("emailId").value=ekycemail.childNodes[0].nodeValue
		    
		      if(document.getElementById("aadhaarVerifyStatus"))
		    	    document.getElementById("aadhaarVerifyStatus").value='verified'
		    	    
		      if(document.getElementById("EkycAadharId")){
	    	    	document.getElementById("EkycAadharId").style.display = "block";
			    	document.getElementById("EkycAadharId").readOnly = true;
		      }
	    	  
	    	 
	    	  
	       }else{
	    	   var message= item.getElementsByTagName("message")[0];
	    	   alert(message.childNodes[0].nodeValue);
	       }
	        
	        
	       
      	}
      }
    }
    
    xmlHttp.open("GET","/hms/hms/registration?method=eKycAuthentication&aadhaarName="+name+'&otp='+otp+'&aadharNo='+aadharNo+'&otpTxn='+otpTxn+'&'+csrfTokenName+'='+csrfTokenValue,false);//changed by govind on 10-10-2017
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }

function eKycAuthenticationOtp() {
	
	
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
  var aadharNo =document.getElementById("aadhaarNumberId").value;
  
  
  // obj.length = 1;
    xmlHttp.onreadystatechange=function()
    {
    	
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	
      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	   	
	   	 
	  var 	authenticateStatus = item.getElementsByTagName("authenticateStatus")[0];
	  var 	otpTxnNode = item.getElementsByTagName("otpTxn")[0];
	  var 	message = item.getElementsByTagName("message")[0];
	  var 	otpTxn="";
		  if(otpTxnNode.childNodes[0].nodeValue!=null){
			  otpTxn = otpTxnNode.childNodes[0].nodeValue;
	      	}
	     // alert(authenticateStatus.childNodes[0].nodeValue)
	       if(authenticateStatus.childNodes[0].nodeValue=="true"){
	    	  document.getElementById("ekycOtp").value="OTP Generated";
	    	  document.getElementById("ekycOtp").disabled = true;
	    	  document.getElementById("Authenticate").disabled = false;
	    	  /*document.getElementById("EkycAadharId").style.display = "block";*/
	    	  document.getElementById("otp").disabled = false;otpTxn
	    	  document.getElementById("otpTxn").value=otpTxn
	       }else{
	    	   alert(message.childNodes[0].nodeValue);
	       }
	       
      	}
      }
    }
    
    xmlHttp.open("GET","/hms/hms/registration?method=eKycAuthenticationOtp&aadhaarName="+name+'&aadharNo='+aadharNo+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }



function verifyOnRegistrationOtp(){
	var mobileNumber =document.getElementById("mobileNumberId").value;
	var otp =document.getElementById("otpId").value;
	 action="/hms/hms/registration?method=verifyMobileNum&mobileNumber="+mobileNumber+'&otp='+otp;
		obj = eval('document.mobileVerification')
		       obj.action = action;
	    	   	 var url=action;
		    	 	//url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    	   
var xmlHttp;
try {
//Firefox, Opera 8.0+, Safari
xmlHttp=new XMLHttpRequest();
}catch (e){
//Internet Explorer
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
	   	    
	       var Verified  = item.getElementsByTagName("Verified")[0];
	       var status=Verified.childNodes[0].nodeValue;
	       if(status=="true"){
	    	   opener.openOtpWindos();
	   		window.close();
	       }
	       else{
	    	   alert("OTP not matched")
	    	   window.close();
	       }
	        
	}
}
}
//var url=action;
	//url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
xmlHttp.open("GET",url,false);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);
	 
}

function populateDataFromCitizenForAadhaar(aadhaarno) {
	//alert(citizenId)
	if(aadhaarno!=''){
		action="/hms/hms/registration?method=populatePatientCitizenDataAadhaar&aadhaarno="+aadhaarno;
		obj = eval('document.patientRegistersearch')
		       obj.action = action;
	    	   	 var url=action;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
 
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
	       var name  = item.getElementsByTagName("name")[0];
	       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
	       var age  = item.getElementsByTagName("age")[0];
	      // alert(age.childNodes[0].nodeValue);
	      /* var NameOf  = item.getElementsByTagName("NameOf")[0];*/
	       var RelativeName  = item.getElementsByTagName("RelativeName")[0];
	       
	       var Occupation  = item.getElementsByTagName("Occupation")[0];
	       var pDistrict  = item.getElementsByTagName("pDistrict")[0];
	       
	       var Category  = item.getElementsByTagName("Category")[0];
	       var Gender  = item.getElementsByTagName("Gender")[0];
	      // alert(Gender);
	       var yearOfBirth  = item.getElementsByTagName("yearOfBirth")[0];
	       var dob  = item.getElementsByTagName("dob")[0];
	       var familyId  = item.getElementsByTagName("familyId")[0];
	       var memberId  = item.getElementsByTagName("memberId")[0];
	       
	       var aadharDistrict  = item.getElementsByTagName("aadharDistrict")[0];
	       
	       var education  = item.getElementsByTagName("education")[0];
	       var memberHospitalId1=item.getElementsByTagName("memberHospitalId")[0];
	       var aadharNo=item.getElementsByTagName("aadharNo")[0];
	       var searchStatus=item.getElementsByTagName("searchStatus")[0];
	      
	       if(searchStatus.childNodes[0].nodeValue == true || searchStatus.childNodes[0].nodeValue == 'true'){
	       if(undefined !=aadharNo && undefined !=aadharNo.childNodes[0]){
	    	   document.getElementById("pQAadhaarNumberId").value = aadharNo.childNodes[0].nodeValue 
	       }
	       
	       if(undefined !=memberHospitalId1.childNodes[0]){
	    	   document.getElementById("nativeSubCentre").value = memberHospitalId1.childNodes[0].nodeValue 
	       }
	       
	       if(undefined !=education.childNodes[0]){
	    	   document.getElementById("educationId").value = education.childNodes[0].nodeValue 
	       }
	       if(undefined !=aadharDistrict.childNodes[0]){
	    	   
	    	   document.getElementById("cityId").selectedIndex  = aadharDistrict.childNodes[0].nodeValue 
	    	   populsubDistrictByDistrictId(aadharDistrict.childNodes[0].nodeValue); 
	    	   populateAPincodeByDistrict(aadharDistrict.childNodes[0].nodeValue);
	    	  populateAadhaarVillageTown(aadharDistrict.childNodes[0].nodeValue);
	       }
	       
	       var houseName  = item.getElementsByTagName("houseName")[0];
	       if(undefined !=houseName.childNodes[0]){
	    	   document.getElementById("pHouseName").value = houseName.childNodes[0].nodeValue 
	       }
	       
	       var streetName  = item.getElementsByTagName("streetName")[0];
	       if(undefined !=streetName.childNodes[0]){
	    	   document.getElementById("streetName").value = streetName.childNodes[0].nodeValue 
	       }
	       
	       
	       if(null != familyId.childNodes[0] && undefined !=familyId.childNodes[0]){
	       document.getElementById("familyID").value = familyId.childNodes[0].nodeValue
	       document.getElementById("citizenDataId").value ="yes"
	       
	       }
	       
	       if(null != memberId.childNodes[0] && undefined !=memberId.childNodes[0])
	       document.getElementById("memberID").value = memberId.childNodes[0].nodeValue
	       
	       document.getElementById("dobId").value = dob.childNodes[0].nodeValue
	       document.getElementById("yobId").value = yearOfBirth.childNodes[0].nodeValue
		   document.getElementById("age").value = age.childNodes[0].nodeValue
		   
		   document.getElementById("pNameId").value = name.childNodes[0].nodeValue
		   
		  /* document.getElementById("relationId").value =NameOf.childNodes[0].nodeValue*/
		   document.getElementById("mobileNoId").value = mobileNo.childNodes[0].nodeValue
		   
		   if(null != RelativeName.childNodes[0] && undefined !=RelativeName.childNodes[0])
		   document.getElementById("relativeNameId").value = RelativeName.childNodes[0].nodeValue
		   
		   if(null !=Occupation.childNodes[0] && undefined !=Occupation.childNodes[0])
		   document.getElementById("occupationId").value = Occupation.childNodes[0].nodeValue
		   
		   if(undefined !=Gender.childNodes[0] && null !=Gender.childNodes[0])
		   document.getElementById("gender").value = Gender.childNodes[0].nodeValue
		   
		   if(undefined !=Category.childNodes[0] && null !=Category.childNodes[0].nodeValue)
		   document.getElementById("otherCategoryId").selectedIndex = Category.childNodes[0].nodeValue
		   document.getElementById("citizenSearchId").value ="citizen"
			   
			   var permanentDistrictId  = item.getElementsByTagName("pDistrict")[0];
	       if(permanentDistrictId!=undefined &&  permanentDistrictId.childNodes[0]!=null)
	    	   document.getElementById("pcityId").selectedIndex = permanentDistrictId.childNodes[0].nodeValue
	       
	       var permanentTalukId  = item.getElementsByTagName("ptaluk")[0];
	       if(permanentTalukId!=undefined &&  permanentTalukId.childNodes[0]!=null)
	    	   document.getElementById("talukId").selectedIndex = permanentTalukId.childNodes[0].nodeValue
	       
	       var permanentPostOfficeId  = item.getElementsByTagName("permanentPostOfficeId")[0];
	       if(permanentPostOfficeId!=undefined &&  permanentPostOfficeId.childNodes[0]!=null)
	    	   document.getElementById("pppostOff").selectedIndex = permanentPostOfficeId.childNodes[0].nodeValue
	           
	      
	       var permanentPostCode  = item.getElementsByTagName("permanentPostCode")[0];
	       if(permanentPostCode!=undefined &&  permanentPostCode.childNodes[0]!=null)
	    	   document.getElementById("ppincode").value = permanentPostCode.childNodes[0].nodeValue
	       
	       var healthHouseId  = item.getElementsByTagName("healthHouseId")[0]; 
	       if(healthHouseId!=undefined &&  healthHouseId.childNodes[0]!=null)
		       document.getElementById("healthHouseId").value = healthHouseId.childNodes[0].nodeValue
		       
		       var lsghouseNo  = item.getElementsByTagName("lsghouseNo")[0]; 
	       if(lsghouseNo!=undefined &&  lsghouseNo.childNodes[0]!=null)
		       document.getElementById("pLsgHouseNo").value = lsghouseNo.childNodes[0].nodeValue
		       
		       var wardId  = item.getElementsByTagName("wardId")[0];
	       if(wardId!=undefined &&  wardId.childNodes[0]!=null)
		       document.getElementById("wardId").value = wardId.childNodes[0].nodeValue
	       
		       var wardName  = item.getElementsByTagName("wardName")[0];
		       if(wardName!=undefined &&  wardName.childNodes[0]!=null)
			       document.getElementById("wardName").value = wardName.childNodes[0].nodeValue 
		       
		       obj =document.getElementById("locality");
				obj.length =0;
				
				var localityId  = item.getElementsByTagName("localityId")[0]; 
				var localityName  = item.getElementsByTagName("localityName")[0]; 
				if(localityId!=undefined && localityId.childNodes[0]!=null){
					obj.length++;
					obj.options[obj.length-1].value=localityId.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=localityName.childNodes[0].nodeValue;
				}  
				
				document.getElementById("QRScanId").checked = true;
				document.getElementById("aadhaarRadioId").checked = true;
				 document.getElementById("QRcAadharId").style.display = "block";
				 
				 document.getElementById("aadharrDiv").style.display = "block";
				 
				 document.getElementById("qrScanDiv").style.display = "block";
				 
				 if(undefined !=aadharNo && undefined !=aadharNo.childNodes[0]){
					 document.getElementById("QRcAadharId").value = aadharNo.childNodes[0].nodeValue 
			       }
				
	       }
	       else{
	    	   alert("Member Not Found")
	       }
   	}       
   	}
   }
 }
 var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
if(aadhaarno !=''){
 xmlHttp.open("GET",url,false);
}
 xmlHttp.setRequestHeader("Content-Type", "text/xml");
 xmlHttp.send(null);


}

//added by govind 23-01-2017
function populatePPLocalityByWardLsg(ward,lsg,locality) {
	
	var wardid =document.getElementById(ward).value;
	var lsgid =document.getElementById(lsg).value;
	
	//alert("wardid "+wardid+" lsgid "+lsgid);
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
   obj =document.getElementById(locality);
   obj.length = 1;
  
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	       
	   	var WardName = item.getElementsByTagName("localName")[0];
	   	var WardId = item.getElementsByTagName("localId")[0];

	   	obj.length++;

	   	obj.options[obj.length-1].value=WardId.childNodes[0].nodeValue
	   	obj.options[obj.length-1].text= WardName.childNodes[0].nodeValue
	  
				
				
      	}
      }
    }
    xmlHttp.open("GET","/hms/hms/registration?method=populatePPLocalityByWardLsg&wardId="+wardid+"&lsgId="+lsgid+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }
//added by govind 23-01-2017 end

//added by arbind on 16-02-2017
function populatePPWardByLsg(wardId,lsgId) {
	
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
   obj =document.getElementById(wardId);
   obj.length = 1;
  
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	       
	   	var WardName = item.getElementsByTagName("WardName")[0];
	   	var WardId = item.getElementsByTagName("WardId")[0];

	   	obj.length++;

	   	obj.options[obj.length-1].value=WardId.childNodes[0].nodeValue
	   	obj.options[obj.length-1].text= WardName.childNodes[0].nodeValue
	  
				
      	}
      }
    }
    if(wardId=='wardId')
        document.getElementById('Tlocality').length=1;
    else if (wardId=='pWardId')
    	 document.getElementById('locality').length=1;
    
    xmlHttp.open("GET","/hms/hms/registration?method=populatePPWardByLsg&lsgId="+lsgId+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }


//implemented VerhoeffAlgorithm  by dhananjay on 17-02-2017
function VerhoeffAlgorithm(aadharno) {
	
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

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	       
	   	var status = item.getElementsByTagName("status")[0];
	   	
		if(status.childNodes[0].nodeValue== 'true'){
			
		}
		else{
			alert("Aadhaar No. is not valid ");
			document.getElementById('aadhaarNumberId').value="";
		}
				
      	}
      }
    }
    xmlHttp.open("GET","/hms/hms/registration?method=VerhoeffAlgorithm&aadharno="+aadharno+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }

// populate vilage town on Taluk id  added by arbind on 18-02-2017
function populateAadhaarVillageByTaluk(talukId) {
	
	
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
   obj =document.getElementById("villageId");
  
   obj.length = 1;
    xmlHttp.onreadystatechange=function()
    {
    	
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	
      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	   	 
	   	 
	        var villageName  = item.getElementsByTagName("VillageName")[0];
	        var villageId  = item.getElementsByTagName("VillageId")[0];
	       
	        obj.length++;
	        
	       
	        obj.options[obj.length-1].text= villageName.childNodes[0].nodeValue
				obj.options[obj.length-1].value= villageId.childNodes[0].nodeValue
	       
	       
      	}
      }
    }
    
    xmlHttp.open("GET","/hms/hms/registration?method=populateVillageBytaluk&talukId="+talukId+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }

function populateTTWardByDistrict(districtId) {
	
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
   obj =document.getElementById("wardId");
   obj.length = 1;
  
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	       
	   	var WardName = item.getElementsByTagName("WardName")[0];
	   	var WardId = item.getElementsByTagName("WardId")[0];

	   	obj.length++;

	   	obj.options[obj.length-1].value=WardId.childNodes[0].nodeValue
	   	obj.options[obj.length-1].text= WardName.childNodes[0].nodeValue
	  
				
				
      	}
      }
    }
    xmlHttp.open("GET","/hms/hms/registration?method=populatePPWardByDistrict&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  }

// Populate hospital name by hospital type and district 
// Added by dhananjay 04-May-17
function populMasHospitalNameByType(hospitalTypeId) {
	
	//alert("check "+districtId);
	var districtId=document.getElementById("districtId").value;
    var xmlHttp=null;
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
   obj =document.getElementById("hospitalNameId");
   obj.length = 1;
  
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
    	
      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];

	   	 var HospitalName  = item.getElementsByTagName("HospitalName")[0];
	        var HospitalId  = item.getElementsByTagName("HospitalId")[0];
	      
	        obj.length++;
	    
				obj.options[obj.length-1].value=HospitalId.childNodes[0].nodeValue
				obj.options[obj.length-1].text= HospitalName.childNodes[0].nodeValue
				
      	}
      
      }
    }
    xmlHttp.open("GET","/hms/hms/registration?method=populMasHospitalNameByType&hospitalTypeId="+hospitalTypeId+"&districtId="+districtId+'&'+csrfTokenName+'='+csrfTokenValue,false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
   // populateAPincodeByDistrict(districtId);
  }


function patientDetails(hinNo) {
var xmlHttp=null;
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
   	   
       var uhid  = item.getElementsByTagName("Uhid")[0];
       var name  = item.getElementsByTagName("name")[0];
       var mobileNo  = item.getElementsByTagName("mobileNo")[0];
       var age  = item.getElementsByTagName("page")[0];
       var Gender  = item.getElementsByTagName("Gender")[0];
     
	 	if(age !=undefined && age.childNodes[0] !=undefined)
	   document.getElementById("ageId").value = age.childNodes[0].nodeValue
	   document.getElementById("pnameId").value = name.childNodes[0].nodeValue
	   if(mobileNo.childNodes[0] !=undefined)
	   document.getElementById("mobileNoId").value = mobileNo.childNodes[0].nodeValue
	   document.getElementById("genderId").value = Gender.childNodes[0].nodeValue
	 
	}
}
}
var url="/hms/hms/registration?method=populatePatientVisitDetail&patientHinNo="+hinNo;
url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

xmlHttp.open("GET",url,false);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);

}


function ajaxFunctionForLabParameterName(formName, inc) {
	var parameterName=document.getElementById("parameterName"+inc).value;
	var machineName=document.getElementById("machineName").value;
	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var items1 = xmlHttp.responseXML.getElementsByTagName('items')[0];

			for (loop = 0; loop < items1.childNodes.length; loop++) {
				var item = items1.childNodes[loop];
				var status = item.getElementsByTagName('status')[0];
				var status1 = status.childNodes[0].nodeValue;
				/*if (status1 == "true"){
					alert("Parameter Name Allready Exists.Please Select Another Name .");
				document.getElementById("parameterName"+inc).selectedIndex=0;
				}*/
			}
		}
	}
	// var investigationIdId ="investigationIdId"+rowVal;
	xmlHttp.open("GET",
			'lab?method=LabParameterNameCheck&parameterName=' + parameterName+'&machineName='+machineName+'&'+csrfTokenName+'='+csrfTokenValue,
			true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}

//added by govind 22-06-2017
function validateAmountDot(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
if (charCode != 46 && charCode > 31 
        && (charCode < 48 || charCode > 57))
         return false;

      return true;
}



function isSingleDot(txt, evt) {

    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode == 46) {
        //Check if the text already contains the . character
        if (txt.value.indexOf('.') === -1) {
            return true;
        } else {
            return false;
        }
    } else {
        if (charCode > 31
             && (charCode < 48 || charCode > 57))
            return false;
    }
    return true;
}


//added by govind 22-06-2017 end

//added by govind 31-07-2017 
function ajaxFunctionForSubInvestigationName(formName,inc) {
	var xmlHttp;
	var sel = document.getElementById("subInvestigationName"+inc);
	var subInvestigationId = sel.options[sel.selectedIndex].value;
	var machineName=document.getElementById("machineName").value;
	var e = document.getElementById("parameterName"+inc);
	var parameterName = e.options[e.selectedIndex].value;
	var e1 = document.getElementById("investigationIdId"+inc);
	var investigationIdId = e1.options[e1.selectedIndex].value;
	//alert("subInvestigationId "+subInvestigationId);
	//alert("machineName "+machineName+" parameterName "+parameterName+" investigationIdId "+investigationIdId);
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var items1 = xmlHttp.responseXML.getElementsByTagName('items')[0];

			for (loop = 0; loop < items1.childNodes.length; loop++) {
				var item = items1.childNodes[loop];
				var status = item.getElementsByTagName('status')[0];
				var status1 = status.childNodes[0].nodeValue;
				if (status1 == "true"){
					alert("Sub Investigation Name Allready Exists.Please Select Another Name .");
					document.getElementById("subInvestigationName"+inc).selectedIndex=0;
				}
			}
		}
	}
	// var investigationIdId ="investigationIdId"+rowVal;
	xmlHttp.open("GET",
			'lab?method=fillRecordCheck&subInvestigationId=' + subInvestigationId
			+'&investigationId=' + investigationIdId
			+'&machineName=' + machineName+'&parameterName=' + parameterName+'&'+csrfTokenName+'='+csrfTokenValue,
			true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);


}//added by govind 31-07-2017 end

function getServiceCentersList(serviceCenterType){
	var xhttp = new XMLHttpRequest();
	document.getElementById('opsession').options.length = 0;
	document.getElementById('deptId').options.length = 1;
	document.getElementById('othercenterId').options.length = 1;
	if(serviceCenterType=="op clinic"){
		document.getElementById('otherDeptDiv').style.display="none";
		document.getElementById('opDeptDiv').style.display="block";
	}else if(serviceCenterType=="other"){
		document.getElementById('opDeptDiv').style.display="none";
		document.getElementById('otherDeptDiv').style.display="block";
	}
	
	   xhttp.onreadystatechange=function() {
		  
	    if (xhttp.readyState == 4 && xhttp.status == 200) {
	    	var data=this.responseText;
	    	var dt=data.toString();
			var result = dt.slice(1, -1);
			var deptData="";
			if(result!=""){
				deptData=result.split(",");
			}
			
			if(serviceCenterType=="other"){
				//document.getElementById('otherdeptId').options.length = 1;
				var select = document.getElementById('othercenterId');
				for(var index=0;index<deptData.length;index++){
					var departmentData=deptData[index].split(":");
					var opt = document.createElement('option');
					opt.value = departmentData[0].trim();
					opt.innerHTML = departmentData[1].trim();
				    select.appendChild(opt);
					
				}
			}else if(serviceCenterType=="op clinic"){
				//document.getElementById('deptId').options.length = 1;
				var select = document.getElementById('deptId');
				for(var index=0;index<deptData.length;index++){
					var departmentData=deptData[index].split(":");
					var opt = document.createElement('option');
					opt.value = departmentData[0].trim();
					opt.innerHTML = departmentData[1].trim();
				    select.appendChild(opt);
					
				}
			}
			
			
	    }
	  }; 
	  xhttp.open("GET", "/hms/hms/registration?method=getServiceCentersList&serviceCenterType="+serviceCenterType,true);
	  xhttp.send();
}

function pVisitDetailsForShortScreen(phinId) {

	if(phinId!=null && phinId!=""){
		action="/hms/hms/registration?method=populatePatientVisitDetailShortScreen&hinId="+phinId;
		obj = eval('document.quickVisitSearch')

		obj.action = action;
		var url=action;
		url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

		var xmlHttp=null;
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

					var uhid  = item.getElementsByTagName("Uhid")[0];
					var name  = item.getElementsByTagName("name")[0];
					var mobileNo  = item.getElementsByTagName("mobileNo")[0];
					var age  = item.getElementsByTagName("age")[0];

					var Category  = item.getElementsByTagName("Category")[0];
					var Gender  = item.getElementsByTagName("Gender")[0];
					var hinId=item.getElementsByTagName("hinId")[0];
					var scheme  = item.getElementsByTagName("scheme")[0];
					var priority=item.getElementsByTagName("priority")[0];
					var locality=item.getElementsByTagName("locality")[0];
					var income=item.getElementsByTagName("income")[0];
					var splCategory  = item.getElementsByTagName("splCategory")[0];
					var scheme  = item.getElementsByTagName("scheme")[0];
					var VisitNo  = item.getElementsByTagName("VisitNo")[0]; 
					var VisitNo  = item.getElementsByTagName("VisitNo")[0]; 
					   
					  var unitId=item.getElementsByTagName("unitId")[0];
				       var unitName=item.getElementsByTagName("unitName")[0];
				       var doctorId=item.getElementsByTagName("doctorId")[0];
				       var docName=item.getElementsByTagName("docName")[0];
				       var serviceCemterId=item.getElementsByTagName("serviceCemterId")[0];
				       
				       
				      

						if(document.getElementById("VisitschemeId")){
							var schemeDropDown = document.getElementById("VisitschemeId");
							if(pragnent.childNodes[0].nodeValue == 'yes') {
								var schemeDropDownCount;
								for (schemeDropDownCount = 0; schemeDropDownCount < schemeDropDown.length; schemeDropDownCount++) {
									if(schemeDropDown.options[schemeDropDownCount].text == 'JSSK')
										schemeDropDown.options[schemeDropDownCount].selected = 'selected';
								}
							}    
						}
					if(document.getElementById("pUhidId"))
						document.getElementById("pUhidId").value = uhid.childNodes[0].nodeValue

					if(document.getElementById("vhinId"))
						document.getElementById("vhinId").value = hinId.childNodes[0].nodeValue

					if(document.getElementById("vpriorityId"))
						document.getElementById("vpriorityId").value = priority.childNodes[0].nodeValue

					if(document.getElementById("vageId") && age !=undefined && age.childNodes[0] !=undefined){
						document.getElementById("vageId").innerHTML = age.childNodes[0].nodeValue;
						document.getElementById("ageId").value = age.childNodes[0].nodeValue;
					}

					if(document.getElementById("vpnameId"))
						document.getElementById("vpnameId").innerHTML = name.childNodes[0].nodeValue

					if(document.getElementById("vmobileNoId") && mobileNo.childNodes[0] !=undefined)
						document.getElementById("vmobileNoId").innerHTML = mobileNo.childNodes[0].nodeValue

					if(document.getElementById("vcategoryId"))
						document.getElementById("vcategoryId").innerHTML = Category.childNodes[0].nodeValue

				    if(document.getElementById("vgenderId"))
					    document.getElementById("vgenderId").innerHTML = Gender.childNodes[0].nodeValue

					if(document.getElementById("vVisitNoId") && VisitNo!=undefined && VisitNo.childNodes[0]!=undefined){
						document.getElementById("vVisitNoId").value = VisitNo.childNodes[0].nodeValue

					}
					if(document.getElementById("patientTypeNameId") && CategoryId!=undefined && CategoryId.childNodes[0]!=undefined){
						document.getElementById("patientTypeNameId").value = CategoryId.childNodes[0].nodeValue
					}
					if(document.getElementById("deptId"))
						document.getElementById("deptId").focus(); // added by arbind on 08-02-2017

					if(unitId !=undefined && unitId.childNodes[0] !=undefined && unitName.childNodes[0] !=undefined){
				    	   unitIdLastVisit =  unitId.childNodes[0].nodeValue;
				    	
				       }
					   
					   
						if(doctorId !=undefined && doctorId.childNodes[0] !=undefined && docName.childNodes[0] !=undefined && null !=doctorId.childNodes[0].nodeValue){
			        	  doctorIdLastVisit =  doctorId.childNodes[0].nodeValue;
			        	  document.getElementById('lastVisitedDrId').value=doctorIdLastVisit;
							
				    	   
				       } 			   
				       
					   
					
					if(document.getElementById("vlocality") && locality!=undefined && locality.childNodes[0]!=undefined){
						document.getElementById("vlocality").innerHTML = locality.childNodes[0].nodeValue
					}
					if(document.getElementById("income") && income!=undefined && income.childNodes[0]!=undefined){
						document.getElementById("income").innerHTML = income.childNodes[0].nodeValue
					}
					if(document.getElementById("vsplCategory") && splCategory!=undefined && splCategory.childNodes[0]!=undefined){
						document.getElementById("vsplCategory").innerHTML = splCategory.childNodes[0].nodeValue
					}
					if(document.getElementById("vscheme") && scheme!=undefined && scheme.childNodes[0]!=undefined){
						document.getElementById("vscheme").innerHTML = scheme.childNodes[0].nodeValue
					}
				}
			}
		}
		var url=action;
		url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

		xmlHttp.open("GET",url,false);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}




}


function getLocalityId(locality) {
	if(locality!=""){
	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var items1 = xmlHttp.responseXML.getElementsByTagName('items')[0];

			for (loop = 0; loop < items1.childNodes.length; loop++) {
				var item = items1.childNodes[loop];
				var localityId = item.getElementsByTagName('localityId')[0];
				var wardId = item.getElementsByTagName('wardId')[0];
				var districtId = item.getElementsByTagName('districtId')[0];
				
				if (localityId!=undefined && localityId.childNodes[0].nodeValue!=undefined){
					document.getElementById("localityId").value=localityId.childNodes[0].nodeValue;
					document.getElementById("pWardId").value=wardId.childNodes[0].nodeValue;
					document.getElementById("pcityId").value=districtId.childNodes[0].nodeValue;
				}
			}
		}
	}
	xmlHttp.open("GET",
			'registration?method=getLocalityId&localityName=' + locality+'&'+csrfTokenName+'='+csrfTokenValue,
			true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);
	}else{
		document.getElementById("localityId").value ="";
	}

}
function selectItemByValue(elmnt, value){

	  for(var i=0; i < elmnt.options.length; i++)
	  {   
	    if(elmnt.options[i].text === value) {
	      elmnt.selectedIndex = i;
	      break;
	    }
	  }
	}
function selectItemByValueId(elmnt, value){
	  for(var i=0; i < elmnt.options.length; i++)
	  {
		  if(elmnt.options[i].text === value) {
		      elmnt.selectedIndex = i;
		      break;
		    }
		  }
		}




function bookCounterForDoctor() {
	var xmlHttp;
	var e = document.getElementById("counterId");
	var userId = document.getElementById("userId").value;
	var counterId = e.options[e.selectedIndex].value;
	var action = "/hms/hms/opd?method=bookCounterForDoctor&counterId="+counterId+"&userId="+userId;
	if(counterId!='0'){
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				alert(e)
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				var items1 = xmlHttp.responseXML.getElementsByTagName('items')[0];

				for (loop = 0; loop < items1.childNodes.length; loop++) {
					var item = items1.childNodes[loop];
					var msg = item.getElementsByTagName('msg')[0];
					
					if(msg!=undefined && msg.childNodes[0]!=undefined){
						var msgStr = msg.childNodes[0].nodeValue;
						if (msgStr != ""){
							alert(msgStr);
							document.getElementById("counterId").selectedIndex=0;
						}
					}
				}
			}
		}
		// var investigationIdId ="investigationIdId"+rowVal;
		xmlHttp.open("GET",action+'&'+csrfTokenName+'='+csrfTokenValue,
				true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}

}

function getEmployeeDepartment(deptId) {
 if(deptId!="0"){
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

      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	   	    var item = chargeCodes.childNodes[loop];
	        var empDeptCode  = item.getElementsByTagName("empDeptCode")[0];
	       if(empDeptCode.childNodes[0] != undefined){
				document.getElementById("empDeptCodeId").value=empDeptCode.childNodes[0].nodeValue
	       }
      	}
      }
    }
    xmlHttp.open("GET","/hms/hms/registration?method=getEmployeeDepartment&deptId="+deptId+'&'+csrfTokenName+'='+csrfTokenValue,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
 }else{
	 document.getElementById("empDeptCodeId").value='';
	 
 }
  }


function getAssignedPatientForDoctorSpecific(docId) {
	 if(docId!=""){
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
	      	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
		   	    var item = chargeCodes.childNodes[loop];
		        var patientsCount  = item.getElementsByTagName("patientsCount")[0];
		        var patientsCount1  = item.getElementsByTagName("patientsCount")[0];
		       if(patientsCount.childNodes[0] != undefined){
		    	 if(!(patientsCount.childNodes[0].nodeValue=="")) {
					document.getElementById("patientCount").value=patientsCount.childNodes[0].nodeValue;
					document.getElementById("patientCount1").value=patientsCount1.childNodes[0].nodeValue;
		    	 }
					else{
						document.getElementById("patientCount").value="";
						document.getElementById("patientCount1").value="";
					}
		       }
	      	}
	      }
	    }
	    xmlHttp.open("GET","/hms/hms/registration?method=getAssignedPatientForDoctorSpecific&docId="+docId+'&'+csrfTokenName+'='+csrfTokenValue,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	 }else{
		 document.getElementById("patientCount").value='';
		 document.getElementById("patientCount1").value='';
	 }
}

//for quick registration 
function cashNotReceivedRV() {
	if(document.getElementById("cashreceivedRV").checked) {
		document.getElementById("cashNotReceivedRV").style.display = "none";
	} else {
		document.getElementById("cashNotReceivedRV").style.display = "block";
	}
}
