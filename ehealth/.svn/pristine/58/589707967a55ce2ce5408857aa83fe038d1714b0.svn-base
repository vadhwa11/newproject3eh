function getEmployeeName(empId){
	//alert("getEmployeeName");
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
          //  if(xmlHttp.responseXML.getElementsByTagName('items')[0]!=null){
        	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
        	
        	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
  	   	    var item = chargeCodes.childNodes[loop];
  	   	 
  	   	 
  	        var empIdNode  = item.getElementsByTagName("employeeId")[0];
  	        var empNameNode  = item.getElementsByTagName("employeeName")[0]; 
  	        var empName= empNameNode.childNodes[0].nodeValue;	
  	      var empId= empIdNode.childNodes[0].nodeValue;
  	    document.getElementById("employee_name").value=empName;
  	  document.getElementById("userId").value=empId;
        	}
        	   }
           }
        
  // alert("empId "+empId);
    var url='/hms/hms/user?method=getEmployeeNameById&employeeId='+empId;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
}

function getHospitalId(detail){
	var instName=document.getElementById("Institute").value;
	if(instName==""){
		document.getElementById("hospitalId").value=0;
		document.getElementById("hospital").value=0;
	}else{
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
              //  if(xmlHttp.responseXML.getElementsByTagName('items')[0]!=null){
	        	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
	        	
	        	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	  	   	    var item = chargeCodes.childNodes[loop];
	  	   	 
	  	   	 
	  	        var hospitalName  = item.getElementsByTagName("hospitalName")[0];
	  	        var hosid  = item.getElementsByTagName("hospitalId")[0]; 
	  	        var id= hosid.childNodes[0].nodeValue;			  	      
	  	    document.getElementById("hospitalId").value=id;
	  	  document.getElementById("hospital").value=id;

	        	}
	        	   if(detail=='RoleMapping'){
	  	  	    	 getRoleTemplateList();
	  	  	       }
	        	   if(detail=='Charge'){
	        		   populateCharge();
		  	  	       }
            	   }
               }
	        
	 
	    var url='/hms/hms/generalMaster?method=getHospitalId&hospitalName='+instName;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

		
	      }
	
}

function dropDownChange(){
	var dist= document.getElementById("district").value;
	var ins= document.getElementById("instType").value;
	if(dist>0 && ins>0){
	    document.getElementById("hospitalId").value=0;
		document.getElementById("Institute").value="";
		//document.getElementById("Institute").setAttribute('validate','Institution,String,yes');
	}
	 
}


function getRoleTemplateList(){
	var hospitalId=document.getElementById("hospitalId").value;
		submitProtoAjaxWithDivName('task','/hms/hms/user?method=getRoleTemplateList&hospitalId='+hospitalId,'templateDiv');
	
}