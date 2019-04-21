
function calculateApproxDobFromAge(){
	//var tempDob= 
	document.getElementById('dobId').value="";
	var tempDob=  document.getElementById('dobId').value;
	
	if( !tempDob  || 0 === tempDob.length){
		
		
		var age =  document.getElementById('age').value;

       var obj = age.split(" ");
       currentDateJ = new Date();
       
       unit=document.getElementById("ageUnitId").value;
     
       year = 0; month = 0; day = 0;
       if(unit == 'Years'){
               year = currentDateJ.getFullYear()- age;
               
       }
       else if(unit == 'Months'){
    	   if(document.getElementById('age').value<=12){
               month=(currentDateJ.getMonth()+1)-age;
              
               if(month<=0){
                       month = month+12
                       year--;
               }
               if(month != 0)
                       month = (month<10)? "0"+month : month
                    		 
    	   }
    	   else{
    		   document.getElementById('age').value="";
    		  
    		   alert("Months is not valid")
    		  
    		   return ""; 
    	   }
    	  
       }
       else if(unit == 'Days'){
    	  if(document.getElementById('age').value<=30){ 
    	   var someDate = new Date();
    	  
    	   someDate.setDate(someDate.getDate() - parseInt(age)); 
    	   var dd = someDate.getDate();
    	   var mm = someDate.getMonth() + 1;
    	   var yyyy = someDate.getFullYear();
    	  
            if(dd.toString().length==1){
            	dd="0"+dd;
            } 
            if(mm.toString().length==1){
            	mm="0"+mm;
            } 
          //  if(yyyy <= 0)
               // year = currentDateJ.getFullYear()+year;
    	  }else{
   		   document.getElementById('age').value="";
		   alert("Days is not valid")
		   return ""; 
    	  }
            	
            document.getElementById("yobId").value=yyyy;
            approxDob =dd + "/" + mm + "/" + yyyy;
            document.getElementById("dobId").readonly = true;
            
            if( document.getElementById("calImageId"))
            		document.getElementById("calImageId").readonly = true;
            
            document.getElementById("nationalDobId").value ='y';  
            document.getElementById("dobId").value=approxDob;
           
            return approxDob;
       }

 
 if(year <= 0)
     year = currentDateJ.getFullYear()+year;
 document.getElementById("yobId").value=year;
if(month <= 0)
	month = ((currentDateJ.getMonth()+1)<10)? "0"+(currentDateJ.getMonth()+1) : (currentDateJ.getMonth()+1);
//   month = (((currentDateJ.getMonth()+1)+month)<10)? "01":"01";
/*if(day == 0  ){
   day = (currentDateJ.getDate()<10)? "01":"01";
}*/
	if(day == 0  ){
		
		 //day ="0"+currentDateJ.getDate();
		// commented by amit das on 10-06-2017
		// added by amit das on 10-06-2017
		if(currentDateJ.getDate()>9){
			day = currentDateJ.getDate();
		} else{
			day = "0"+currentDateJ.getDate(); 
		}
		//    day = (currentDateJ.getDate()<10)? "01":"01";
	}
	
	
 if(unit.localeCompare('Days')==0){
	month = (currentDateJ.getMonth()+1)
	if(currentDateJ.getDate()<age){
		month--;
	}
	 
 }

       approxDob =day + "/" + month + "/" + year;
       document.getElementById("yobId").value=year;
       document.getElementById("dobId").readonly = true;
       if( document.getElementById("calImageId"))
    	   document.getElementById("calImageId").readonly = true;
       document.getElementById("nationalDobId").value ='y';  
       document.getElementById("dobId").value=approxDob;
      
       return approxDob;

	}
	else{
		document.getElementById("age").readonly = false;
	       document.getElementById("ageUnitId").readonly = true;
	       
			/* document.getElementById("age").disabled=true;
			 document.getElementById("ageUnitId").disabled=true; */
		
		return tempDob;
	}
	
}

function calculateApproxDobFromAgeYear(){
	
	//var tempDob=  document.getElementById('dobId').value;
	var age =  document.getElementById('age').value;
	
	if( age === null  || age === ''  || 0 === age.length){
		 document.getElementById('dobId').value="";
		 document.getElementById('yobId').value="";
		 
		//alert("Enter age ")
	}else{
		
       var obj = age.split(" ");
		
       currentDateJ = new Date();
       
       unit=document.getElementById("ageUnitId").value;
      
       year = 0; month = 0; day = 0;
       if(unit == 'Years'){
               year = currentDateJ.getFullYear()- age;
               month=currentDateJ.getMonth()+1;
       }
       else if(unit == 'Months'){
    	   if(document.getElementById('age').value>=0){
              
               if(parseInt(currentDateJ.getMonth()+1)>age){
                   month=(currentDateJ.getMonth()+1)-age;
 
               }
               else{
                   month=age-(currentDateJ.getMonth()+1);
   
               }
              
               if(month >= 0 && month >12){
            	   var tempYear=month/12;
            	   var tempmont=month%12;
            	   
            	   year=year-parseInt(tempYear);
            	   month=parseInt(tempmont);
               }
               if(month<=0){
                       month = month+12
                       year--;
               }
               if(month != 0)
                       month = (month<10)? "0"+month : month
                    		   
    	   }
    	   else{
    		   
    		   alert("Months is not valid")
    		    
    		   document.getElementById('age').value="";
    		   document.getElementById('dobId').value="";
    		   return false;
    	   }

       }
       else if(unit == 'Days'){
    	   
    	   var someDate = new Date();
    	   
    	   
    	   someDate.setDate(someDate.getDate() - parseInt(age)); 
    	   var dd = someDate.getDate();
    	  
    	   var mm = someDate.getMonth() + 1;
    	   var yyyy = someDate.getFullYear();
    	  
            if(dd.toString().length==1){
            	dd="0"+dd;
            	
            } 
            if(mm.toString().length==1){
            	mm="0"+mm;
            	
            } 
            if(yyyy <= 0)
               // year = currentDateJ.getFullYear()+year;
            document.getElementById("yobId").value=year;
            approxDob =dd + "/" + mm + "/" + yyyy;
            document.getElementById("dobId").readonly = true;
            document.getElementById("calImageId").readonly = true;
            document.getElementById("nationalDobId").value ='y';  
            document.getElementById("dobId").value = approxDob;
            return approxDob;
       }
       else{
       }
 if(year <= 0)
     year = currentDateJ.getFullYear()+year;
 document.getElementById("yobId").value=year;
if(month <= 0)
	month = month;
   //month = (((currentDateJ.getMonth()+1)+month)<10)? "01":"01";
if(day == 0  ){
	// day = currentDateJ.getDate(); // commented by amit das on 10-06-2017
		// added by amit das on 10-06-2017
		if(currentDateJ.getDate()>9){
			day = currentDateJ.getDate();
		} else{
			day = "0"+currentDateJ.getDate(); 
		}
 //    day = (currentDateJ.getDate()<10)? "01":"01";
}
 if(unit.localeCompare('Days')==0){
	month = (currentDateJ.getMonth()+1)
	if(currentDateJ.getDate()<age){
		month--;
	}
	 
 }
 var dayS=""+day;
 var monthS=""+month;
 if(dayS.length==1){
	 if(day<10){
		 dayS="0"+day;
	 }
 }
 if(monthS.length==1){
	 if(month<10){
		 monthS="0"+month;
	 }
 }
       approxDob =dayS + "/" + monthS + "/" + year;
       document.getElementById("dobId").readonly = true;
       document.getElementById("calImageId").readonly = true;
       document.getElementById("nationalDobId").value ='y';  
       document.getElementById("dobId").value = approxDob;
       return approxDob;

	
       }	
		//document.getElementById("age").readonly = true;
	     //  document.getElementById("ageUnitId").readonly = true;
	       
			/* document.getElementById("age").disabled=true;
			 document.getElementById("ageUnitId").disabled=true; */
		
		//return tempDob;
	
	
}

function checkForDOB()
{
	
       if(document.getElementById("age").value!="" && document.getElementById("age").value>0)
       {
    	   if(document.getElementById("age").value<150){
               var ageAtRegTime=document.getElementById("age").value;
               if(ageAtRegTime.indexOf(".")==1)
               {
                       currentAge=ageAtRegTime.substring(0,ageAtRegTime.indexOf("."));
               }
               else if(ageAtRegTime.indexOf(".")==-1)
               {
                       currentAge=document.getElementById("age").value;
               }
               document.getElementById('age').value=currentAge;
               var apoxAge=calculateApproxDobFromAge();
               document.getElementById("dobId").value="";
               if(undefined !=apoxAge && apoxAge !="")
               document.getElementById("dobId").value=apoxAge;
       }
    	   else{
        	   alert("Enter valid age ")
        	   document.getElementById("age").value="";
        	   return false;
           }

       }
       
       return true;
}

function changeGender()
{
var obj = document.getElementById("gender");
var txt = obj.options[obj.selectedIndex].text;
var obj1 = document.getElementById("titleId");
 if(obj1 != null && obj1 != '') {
	if (txt=="Male") {
       //var obj1 = document.getElementById("titleId");
       for(i=0;i<obj1.length;i++)
       {
                var txt1 = obj1.options[i].text;
                if (txt1=="Mr.")
                  obj1.selectedIndex = i;
       }
	} else if (txt=="Female") {
       //var obj1 = document.getElementById("titleId");
       for(i=0;i<obj1.length;i++)
       {
                var txt1 = obj1.options[i].text;
                if (txt=="Mrs" || txt=="Miss" || txt=="Ms."  )
                  obj1.selectedIndex = i;
       }
	} else {
       //var obj1 = document.getElementById("titleId");
       obj1.selectedIndex = 0;
	}
 }
}

function enableAgeAndAgeUnitFiled(){
	var tempDob=  document.getElementById('dobId').value;
		
		
	if( !tempDob  || 0 === tempDob.length){
		document.getElementById("age").disabled=false;
		document.getElementById("ageUnitId").disabled=false;
	}
		
		
}


//----Function for age through ajax----------
function calculateAgeInAjax() {
	
dob=document.getElementById('dobId').value; 
	if(dob != ""){
		if(checkDob()){
		action="/hms/hms/registration?method=calculateAgeInAjax&dateOfBirth="+dob;
		obj = eval('document.registration')
		       obj.action = action;
	    	   	 var url=action
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
	        var age  = item.getElementsByTagName("age")[0];
	        
	        var period  = item.getElementsByTagName("period")[0];
	        var year= item.getElementsByTagName("birthYear")[0];
	        document.getElementById("yobId").value=year.childNodes[0].nodeValue;
	       
	       obj=eval(document.getElementById('ageId'));
	       
	       if(age.childNodes[0].nodeValue == "0"){
	      document.getElementById("age").value=age.childNodes[0].nodeValue;
	       }else{

		   document.getElementById("age").value=age.childNodes[0].nodeValue;
		  
		   		  }
	     
		   	document.getElementById('ageUnitId').style.display = 'inline';
		   
		    temp =document.getElementById('ageUnitId');
			
		   temp.value=period.childNodes[0].nodeValue
		  
		  // document.getElementById("age").disabled = true;
		  // document.getElementById("ageUnitId").disabled = true;
		   var age=document.getElementById("age").value;
		   var date=document.getElementById("ageUnitId").value;
            if(date=="Days"){
            	if(age<29){
            		document.getElementById("newBornBabyId").disabled = false;
            	}
                }else{
            	document.getElementById("newBornBabyId").disabled = true;
              }
		   document.getElementById("age").readOnly = true;
		  
		   document.getElementById("ageUnitId").readOnly = true;
		   var age=document.getElementById("age").value;
		   var date=document.getElementById("ageUnitId").value;
            if(date=="Days"){
            	if(age<29){
            		document.getElementById("newBornBabyId").disabled = false;
            	}
            }else{
            	document.getElementById("newBornBabyId").disabled = true;
            }

		   if( undefined !=period  && undefined !=period.childNodes[0] && null!=period.childNodes[0].nodeValue){
		   document.getElementById('tempageUnitId').value=period.childNodes[0].nodeValue;
		   }
		
		   document.getElementById("gender").focus();
		   
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
function checkForBaby(){
var age=document.getElementById("age").value;
var date=document.getElementById("ageUnitId").value;
 if(date=="Days"){
	
 	if(age<29){
 		document.getElementById("newBornBabyId").disabled = false;
 	}
     }else{
 	document.getElementById("newBornBabyId").disabled = true;
     } 
}
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    	alert("Please Enter Numeric Value");
        return false;
    }
    return true;
}