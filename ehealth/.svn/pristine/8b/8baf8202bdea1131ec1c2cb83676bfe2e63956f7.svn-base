Msg = "";
var childMenuStatus =""
var parentMenuStatus =""
var userUsergroupHospitalArray=new Array();

function getHospital(formName){

		obj1 = eval('document.'+formName+'.loginName');
		obj2 = eval('document.'+formName+'.password');
		loginName = obj1.value;
		password = obj2.value;
		obj3 = eval('document.'+formName+'.hospital');

			if(loginName == "superadmin")
			{
			   obj3.disabled = true;

			}else{
			  obj3.disabled = false;
		      obj = eval('document.'+formName)
		      obj.action = "/hms/hms/login?method=getHospitalName&loginName="+loginName+"&password="+password;
     obj.submit();
		   }
}

function getMetaContentByName(name, content) {
    var content = (content == null) ? 'content' : content;
    return document.querySelector("meta[name='" + name + "']").getAttribute(content);
}

function checkForBlockedAccount(formName,csrfTokenName,csrfTokenValue){
	obj1 = eval('document.'+formName+'.loginName');
	obj2 = eval('document.'+formName+'.password');
	loginName = obj1.value;
	obj3 = eval('document.'+formName+'.hospitalName');
	 
	if(loginName == "superadmin"){
		obj3.disabled = true;
	}else{
		obj3.disabled = false;
    	url="/hms/hms/login?method=checkForBlockedAccount&loginName="+loginName+"&"+csrfTokenName+"="+csrfTokenValue;
    	message = "Account has been blocked for multiple invalid logins. Contact System Administrator.";
    	try {
    		     request = new XMLHttpRequest();
    		   } catch (trymicrosoft) {
    		     try {
    		       request = new ActiveXObject("Msxml2.XMLHTTP");
    		     } catch (othermicrosoft) {
    		       try {
    		         request = new ActiveXObject("Microsoft.XMLHTTP");
    		       } catch (failed) {
    		         request = false;
    		       }
    		     }
        }
    		    
    request.open("POST", url, true);
    request.onreadystatechange = function() {
    if (request.readyState == 4){
       if (request.status == 200){
    	  var response = request.responseText;
    	  if(response=='true'){
    		  obj2.disabled = true;
    		  document.getElementById("defaultList").innerHTML =	message;
    	  }
    	}else if (request.status == 404){
    	  alert("Request URL does not exist");
    	}else{
    	   alert("Error: status code is " + request.status);
    	}
       }
     }
    request.send(null);
	}

}


function hospitalList(formName,csrfTokenName,csrfTokenValue){
		obj1 = eval('document.'+formName+'.loginName');
		obj2 = eval('document.'+formName+'.password');
		loginName = obj1.value;
		password = obj2.value;
		obj3 = eval('document.'+formName+'.hospitalName');
		 
	//	csrf = getMetaContentByName('_csrf');
	if(password != "")
	{
		if(loginName == "superadmin")
		{
			   obj3.disabled = true;

		}else{
			obj3.disabled = false;
	    	url="/hms/hms/login?method=getHospitalName&loginName="+loginName+"&password="+password+"&"+csrfTokenName+"="+csrfTokenValue;
			/*url="/hms/hms/login?method=getHospitalName&loginName="+loginName+"&password="+password;*/
			retrieveUrl(url);
		   }
	}

   }

function checkUsername()
{
	if(document.getElementById("loginName")!=null && document.getElementById("loginName").value==""){
	alert("Please enter username first");
	document.getElementById("loginName").focus();
	}
}

var request = false;
function retrieveUrl(url){
   try {
     request = new XMLHttpRequest();
   } catch (trymicrosoft) {
     try {
       request = new ActiveXObject("Msxml2.XMLHTTP");
     } catch (othermicrosoft) {
       try {
         request = new ActiveXObject("Microsoft.XMLHTTP");
       } catch (failed) {
         request = false;
       }
     }
   }
    
	 request.open("POST", url, true);
     request.onreadystatechange = updatePage;
     request.send(null);
    
   if (!request)
     alert("Error initializing XMLHttpRequest!");

}

function updatePage() {
     if ((request.readyState == 4) && (request.status == 200)) {
				if(trimAll(request.responseText)== "Wrong User name or Password"){
		    		document.getElementById('errorMsg').innerHTML = trimAll(request.responseText);
		    		document.getElementById('errorMsg').style.display = 'block';
		    		document.getElementById('loginMsg').style.display = 'none';
		    		document.getElementById('defaultList').style.display = 'block';
		    		document.getElementById('responseList').style.display = 'none';

		    	}else{
		   			document.getElementById('responseList').innerHTML = request.responseText;
		   			document.getElementById('defaultList').style.display = 'none';
			   		document.getElementById('responseList').style.display = 'block';
		   			document.getElementById('errorMsg').style.display = 'none';
		   			document.getElementById('defaultList').innerHTML='';
		   			if(document.getElementById('department'))
		   				document.getElementById('department').focus();
		   			
				}
		}
   }


function validate(formName){

	obj1 = eval('document.'+formName+'.userGroup');
	userGroup = obj1.value;

	if(userGroup == 0){
		errorMsg += "Please select User Group.\n";
	}

	obj2 = eval('document.'+formName+'.access_rights');
	accessRights = obj2.length;

	flag = true;
	for (i = 0; i < accessRights; i++){
		if(obj2[i].checked == true)
		{
			flag = true;
			break;
		}else{
			flag = false;
		}

	}
	if(flag == false){
			errorMsg += "Please select access rights.\n";
	}

	if(errorMsg !=""){
		alert(errorMsg);
		return false;
	}
	else{
		return true;
	}
}

function checkDelete()
{
		if(confirm("Are You sure, You want to delete this country code ?"))
			return true;
		else
			return false;
}
function checkSave()
{
		if(confirm("Are You sure, You want to Save ?"))
			return true;
		else
			return false;
}
function checkReset()
{
		if(confirm("Are You sure, You want to Reset ?"))
			return true;
		else
			return false;
}
function checkReligionDelete()
{
		if(confirm("Are You sure, You want to delete this Religion code ?"))
			return true;
		else
			return false;
}

function RadioCheck(formName,radioButtoName,hidName)
{
	var selection = eval('document.'+formName+'.'+radioButtoName);
	var temp=0;

	for (i=0; i<selection.length; i++)
	if (selection[i].checked == true)
		{
	  	  temp=selection[i].value;
	  	  obj = eval('document.'+formName+'.'+hidName)
	  	  obj.value=temp;

	  	  return true;
		}

		if(temp==0){
		alert('Please Select Country Code ')
		return false;
		}
}





function getCurrency(formName,comboFeildName,textFeildName){
		var selectedIndex=eval('document.'+formName+'.'+comboFeildName+'.selectedIndex');
 		temp=eval('document.'+formName+'.'+comboFeildName+'.options[selectedIndex]');
 		var selectedValue=temp.value;

 		if (selectedValue != "Select") {
 		var temp=eval('document.'+formName+'.'+textFeildName);
 		temp.value=selectedValue;

 		}
}

function checkDate(formName,dateFeildName) {

				var today = new Date();
				var tempX = today.getYear();
				var tempY = tempX % 100;
				tempY += (tempY < 38) ? 2000 : 1900;
				var year=tempY

		objDate = eval('document.'+formName+'.'+dateFeildName);
		var dateString = objDate.value;

		if(dateString==""){
			alert('Changed Date can not be blank')
			return false
		}
		try{
	 	var idx = dateString.indexOf('/');

	  if (idx != -1) {
		  var pairs = dateString.substring(0, dateString.length).split('/');
		  if (pairs.length!=3) {
			 alert("Invalid Date.It should be DD/MM/YYYY")
			return false;
			}
			  if (pairs[0].length != 2 || pairs[1].length != 2 || pairs[2].length != 4) {
				  alert("Invalid Date.It should be DD/MM/YYYY")
				  return false;
				}


		  for (var i=0; i<pairs.length; i++) {
			  vals=eval(pairs[i]);
			  			  if (vals<0 || vals>9999) {
				  alert("Invalid Date.It should be DD/MM/YYYY")
				  return false;
			  								}
		 		 }


			if( eval(pairs[2])>year){
			alert("YEAR Should not be greater than "+year)
			return false}

		 		if( eval(pairs[1])<1 || eval(pairs[1])>12)
		 		{
		 			alert("Month in between (01,12)");
		 			return false
		 		}

		 		 if(eval(pairs[1])==1 || eval(pairs[1])== 3  || eval(pairs[1])== 5 || eval(pairs[1])== 7 || eval(pairs[1])== 8 || eval(pairs[1])== 10 || eval(pairs[1])== 12)
		 		 {
		 		 	if(eval(pairs[0])<1 || eval(pairs[0])>31)
		 		 		{alert("Date Should be in 01-31")
		 		 		return false;}
		 		 }
		 		 if(eval(pairs[1])==4 || eval(pairs[1])== 6  || eval(pairs[1])== 9 || eval(pairs[1])== 11)
		 		 {
		 		 	if(eval(pairs[0])<1 || eval(pairs[0])>30)
		 		 		{alert("Date Should be in 01-30")
		 		 		return false;}
		 		 }
		 		 if(eval(pairs[1])==2)
		 		 {
						year1=(eval(pairs[2]))
						if(  (year1%4 == 0)  )
						      { 	 if (year1%100 != 0)
						            	{		if(eval(pairs[0])<1 || eval(pairs[0])>29)
		 		 							{alert(" Date Should be in 01-28")
		 		 						     return false;}
		 		 				  		  }
						          		 else
						            		 {
						            	      if( (year1%400 == 0) || (year1%4 == 0) )
						            			if(eval(pairs[0])<1 || eval(pairs[0])>29)
		 		 									{
		 		 										alert("Leap Year Date Should be in 01-29")
		 		 						     			return false;
		 		 						     		}

											 }

								} else
										if(eval(pairs[0])<1 || eval(pairs[0])>28)
				 						{
				 		 					alert(" Date Should be in 01-28")
		 		 				 			return false;
		 		 			 			}
					}

		}
		else {
			 alert("Invalid Date.It should be DD/MM//YYYY")
			return false;
		}
	 }
	 catch(eee) {
		alert("Exp Error");
		return false;
	}



return true;
}

function checkTime(formName,timeFieldName){

	objTime = eval('document.'+formName+'.'+timeFieldName);
  	var chtime=objTime.value;
	if(chtime==""){
	alert('Changed Time can not be blank')
		return false
	}

	try{
		 var indx = chtime.indexOf(':');

		 if (indx != -1) {
		 var pairs2 = chtime.substring(0,chtime.length).split(':');
		 }

		 if (pairs2.length!=2) {
			 alert("Invalid Time Format.It should be HH:MM")
			 objTime.value="18:00"
			return false;
			}

		 if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
				  alert("Invalid Time Format.It should be HH:MM")
				  objTime.value="18:00"
				  return false;
				}

		 		 val2=eval(pairs2[0]);

						  if (val2<0 || val2>23) {
							  alert("Hours should 00-23")
							  objTime.value="18:00"
					 		 return false;}

					 		 val3=eval(pairs2[1]);

							  if (val3<0 || val3>59) {
							  alert("Min should 00-59")
							  objTime.value="18:00"
					 		 return false;}


	}catch(e2)
	{	alert("Invalid Time")
	objTime.value="18:00"
		return false;
	}

return true;
}





	//----------------for Hospital--------------------
function showUpdateHospitalDetails(formName){

		obj1 = eval('document.'+formName+'.hospitalId');
		hosId = obj1.value;
		obj = eval('document.'+formName)
		obj.action = "/hms/hms/superAdmin?method=showUpdateHospitalWithDetails&hospitalId="+hosId;
		obj.submit();
}

function showDeleteHospitalDetails(formName){

		obj1 = eval('document.'+formName+'.hospitalId');
		hosId = obj1.value;
		obj = eval('document.'+formName)
		obj.action = "/hms/hms/superAdmin?method=showDeleteHospitalWithDetails&hospitalId="+hosId;
		obj.submit();
}






function nextButtonState(formName,nextState){

	if(nextState=="disable")
	{
		obj1 = eval('document.'+formName+'.next');
		obj1.disabled=true;

		return false
	}
	else return true



}


function previousButtonState(formName,previousState){

		if (previousState=="disable")
			{
				obj1 = eval('document.'+formName+'.previous');
				obj1.disabled=true;
				return false;
			}
			else
			{
				obj1 = eval('document.'+formName+'.previous');
				obj1.disabled=false;
			 return true;
			 }

}


function checkDelete()
{
		if(confirm("Are You sure, You want to delete this Relation ?"))
			return true;
		else
			return false;
}



function showDetails(formName, action){

		obj = eval('document.'+formName)
		obj.action = action;
		obj.submit();
}

function showUpdatePatientDetails(formName){
      //  alert("inside showUpdatePatientDetails function ");
        alert('document.'+formName+'.patient_id');
		obj1 = eval('document.'+formName+'.patient_id');
		alert(obj1);
		patientId = obj1.value;

		obj = eval('document.'+formName)
		obj.action = "/hms/hms/generalMaster?method=showUpdatePatientWithDetails&patientId="+patientId;
		obj.submit();
}


function showDeletePatientDetails(formName){
		obj1 = eval('document.'+formName+'.patient_id');
		alert(obj1);
		patientId = obj1.value;
		obj = eval('document.'+formName)
		obj.action = "/hms/hms/generalMaster?method=showDeletePatientWithDetails&patientId="+patientId;
		obj.submit();



}


/*-----------------------------Menu------------------------------------*/
	openNode = 0;
	mouseOn = 0;
function makeMainMenu(){



	cnt = 0;
	temp = '<ul class="main-nav">';
	for(i=0;i<menu.length;i++){
		if(menu[i][1]!=0 && menu[i][1]==menu[i][4]){
			cnt++;
			var menuurl  = menu[i][3].substring(0,1);
			if(menuurl!='#'){
				temp+='<li  id="'+menu[i][0]+'" class="menu'+cnt+'"><a href="#" onclick="submitFormForButton(\'navigation\',\''+menu[i][3]+'\');showMenu(this.parentNode)">'+menu[i][2]+'</a></li>';
			}else{
				temp+='<li  id="'+menu[i][0]+'" class="menu'+cnt+'"><a href="'+menu[i][3]+'" onClick="showMenu(this.parentNode)" >'+menu[i][2]+'</a></li>';
			}
			
		}
	}
	temp+='</ul>'; 
	
	document.getElementById('menu').innerHTML = temp;
}

/*----------------------------------------------class ="active" for selected menu--------------------------*/

isMenu = false;
function showMenu(obj){
   // if(obj.id == mouseOn){
    //    return;
   // }
   if(document.getElementById('appletId')){
  	 document.getElementById('appletId').style.visibility = 'hidden';
   }

     mouseOn = obj.id;
	isMenu = true;

	findOpenSibling(obj.id);

	//====This is the block of code to to remove menu
	// when you click in same menu again

	if(childMenuStatus !=obj.id){
		childMenuStatus = obj.id
		if(childMenuStatus==parentMenuStatus){
		   	childMenuStatus =""
	        parentMenuStatus =""
		   return true
		   }
	}else{
	childMenuStatus =""
	if(parentMenu(obj.id) ==0)
        parentMenuStatus =""

	return true
	}

	if(parentMenu(obj.id) ==0){
	if(obj.id==parentMenuStatus){
	parentMenuStatus =""
		return true
	}
	  parentMenuStatus =obj.id
	  }


	//======================================






	addEvent( obj, 'mouseover', findRes );
	tmptxt = '<ul >';
	for(j=0;j<menu.length;j++){
		if(menu[j][1]==obj.id ){

			tmptxt += '<li id="'+menu[j][0]+'"><a ';
			var menuurl  = menu[j][3].substring(0,1);
			if(hasChild(menu[j][0])){
				tmptxt +=  ' class="" ';
			}
			var menuurl  = menu[j][3].substring(0,1);
			if(menuurl!='#'){
				tmptxt += ' href="#" onClick="submitFormForButton(\'navigation\',\''+menu[j][3]+'\');showMenu(this.parentNode)" >'+menu[j][2]+'</a></li>';
			}else{
				tmptxt += ' href="#" onClick="showMenu(this.parentNode)" href="'+menu[j][3]+'">'+menu[j][2]+'</a></li>';
			}
			/*if(hasChild(menu[j][0])){
				tmptxt +=  ' class="child" ';
			
			tmptxt += ' href="'+menu[j][3]+'" onClick="showMenu(this.parentNode)" >'+menu[j][2]+'</a></li>';
			}else{
				tmptxt += ' href="'+menu[j][3]+'">'+menu[j][2]+'</a></li>';
			}*/
		}
	}
	tmptxt+='</ul>';
	if(tmptxt!='<ul></ul>'){
		obj.innerHTML+=tmptxt;
		findRes(obj);
		openNode = obj.id;
	}
}
function hasChild(id){
	for(a=0;a<menu.length;a++){
		if(menu[a][1]==id){
			 if(document.getElementById('appletId')){
  	 	document.getElementById('appletId').style.visibility = 'hidden';
   		}
			return true;

			}
	}


	return false;
}

function findRes(ob){
	if(ob && ob.id){
		allowedWidth = ((checkWidth() - 780)/2)+1030	;
		pNode=findElement(ob.id);
		if(ob.childNodes[1]){
			currentPos = findPosX(ob)+172;
			if(currentPos>allowedWidth  && menu[pNode][1]==0){
				if(171-findPosY(ob)>0){
					ob.childNodes[1].style.marginLeft =  '-'+(171-findPosY(ob))+'px';
				}
			}
			else if((currentPos+172)>allowedWidth && menu[pNode][1]!=0){
				ob.childNodes[1].style.marginLeft =  '-182px';
			}
		}

	}
}
function findOpenSibling(id){

	prnt = parentMenu(id);
	for(m=0;m<menu.length;m++){
		if(menu[m][1] == prnt){
			if(document.getElementById(menu[m][0]) && document.getElementById(menu[m][0]).innerHTML.toUpperCase().indexOf('<UL')!= -1)
				removeMenu(menu[m][0]);
		}
	}

}
function setOpenNode(obj){
	if(obj){
		isMenu = false;
		//To Set the value for mouse time out in MENU
		//tmout = setTimeout("checkIfOpen()",1000);
	}
	 if(document.getElementById('appletId')){
  	 document.getElementById('appletId').style.visibility = 'hidden';
   }
}

function checkIfOpen(){
	if(!isMenu){
	    makeMainMenu();
		//openNode = 0;
		//mouseOn = 0;
	}
}
function parentMenu(id){
	for(l=0;l<menu.length;l++){
		if(menu[l][0] == id)
			return menu[l][1];
	}
	 if(document.getElementById('appletId')){
  	 document.getElementById('appletId').style.visibility = 'hidden';
   }
}

function removeMenu(id){
 	if(document.getElementById('appletId')){
  	 document.getElementById('appletId').style.visibility = 'visible';
   }

	for(k=0;k<menu.length;k++){
		if(menu[k][0]==id){
			if(document.getElementById(id)){
				tmTxt = '<a ';
				if(menu[k][1]!=0 && hasChild(id))
					tmTxt += 'class="child"';
				var menuurl  = menu[k][3].substring(0,1);
				if(menuurl!='#'){
					tmTxt += 'onClick="showMenu(this.parentNode);setOpenNode(this.parentNode);submitFormForButton(\'navigation\',\''+menu[k][3]+'\');">'+menu[k][2]+'</a>';
				}else{
					tmTxt += 'onClick="showMenu(this.parentNode);setOpenNode(this.parentNode);" href="'+menu[k][3]+'">'+menu[k][2]+'</a>';
				}
	 			document.getElementById(id).innerHTML = tmTxt;
			}
		}
	}
}
function isNodeOpen(id){
	if(document.getElementById(parentMenu(id)))
		removeMenu(parentMenu(id));
}


function addEvent( obj, type, fn ) {
   if ( obj.attachEvent ) {
     obj['e'+type+fn] = fn;
     obj[type+fn] = function(){obj['e'+type+fn]( window.event );};
     obj.attachEvent( 'on'+type, obj[type+fn] );
   } else
     obj.addEventListener( type, fn, false );
 }


function removeEvent( obj, type, fn ) {
   if ( obj.detachEvent ) {
     obj.detachEvent( 'on'+type, obj[type+fn] );
     obj[type+fn] = null;
   } else
     obj.removeEventListener( type, fn, false );
}
function checkWidth() {
  var myWidth = 0;
  if( typeof( window.innerWidth ) == 'number' ) {
    myHeight = window.innerWidth;
  }
  else {
  	  if( document.documentElement &&
	    ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
      myHeight = document.documentElement.clientWidth;
    }
	else {
      if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
        myHeight = document.body.clientHeight;
      }
    }
  }
  return myHeight;
}

function findPosX(obj)
{
	var curleft = 0;
	if (obj.offsetParent)
	{
		while (obj.offsetParent)
		{
			curleft += obj.offsetLeft;
			obj = obj.offsetParent;
		}
	}
	else if (obj.x)
		curleft += obj.x;
	return curleft;
}
function findPosY(obj)
{
	var curright = 0;
	if (obj.offsetParent)
	{
		curright += obj.offsetWidth;
	}
	else if (obj.width)
		curright += obj.width;
	return curright;
}
function findElement(val){
	for(h=0;h<menu.length;h++){
		if(menu[h][0]==val)
			return h;
	}
}

var districtPostOfficeArray=new Array();
var stateArr = new Array();
districtArray = new Array();
blockArray = new Array();
pincodeArray = new Array();
doctorArr = new Array();
dependentArray = new Array();
genericArray = new Array();
classArray = new Array();
categoryArray = new Array();
districtLocalArray = new Array();
objectArray=new Array();

function populateItem(val,formName){
	populateItemGeneric(val,formName);
	populateItemClass(val,formName);
	populateItemCategory(val,formName);
}

function populateItemGeneric(val,formName){
	obj = eval('document.'+formName+'.item_generic');
	obj.length = 1;

	for(i=0;i<genericArray.length;i++){
		if(genericArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=genericArray[i][1];
			obj.options[obj.length-1].text=genericArray[i][2];
		}
	}
}

function populateItemClass(val,formName){

	obj = eval('document.'+formName+'.itemClassID');
	obj.length = 1;
	for(i=0;i<classArray.length;i++){
		if(classArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=classArray[i][1];
			obj.options[obj.length-1].text=classArray[i][2];
		}
	}
}

function populateItemCategory(val,formName){

	obj = eval('document.'+formName+'.itemCategoryId');
	obj.length = 1;

	for(i=0;i<categoryArray.length;i++){
		if(categoryArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=categoryArray[i][1];
			obj.options[obj.length-1].text=categoryArray[i][2];
		}
	}
}


//----------------------For Registration------------------------------------------------------------



function populateState(val,formName){

	obj = eval('document.'+formName+'.state');
	obj.length = 1;
	for(i=0;i<stateArr.length;i++){
		if(stateArr[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=stateArr[i][1];
			obj.options[obj.length-1].text=stateArr[i][2];
		}
	}
}

function populateObject(val,formName){

	obj = eval('document.'+formName+'.Object');
	obj.length = 1;
	for(i=0;i<objectArr.length;i++){
		if(objectArr[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=objectArr[i][1];
			obj.options[obj.length-1].text=objectArr[i][2];
		}
	}
}



function populateDistrict(val,formName){
	obj = eval('document.'+formName+'.district');
	obj.length = 1;
	for(i=0;i<districtArray.length;i++){
		if(districtArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=districtArray[i][1];
			obj.options[obj.length-1].text=districtArray[i][2];
		}
	}
}
function populateDistrictLocal(val,formName){
	obj = eval('document.'+formName+'.localCity');
	obj.length = 1;
	for(i=0;i<districtLocalArray.length;i++){
		if(districtLocalArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=districtLocalArray[i][1];
			obj.options[obj.length-1].text=districtLocalArray[i][2];
		}
	}
}

var masRoomArray=new Array();
function populateRoomCode(val,formName){
	obj = eval('document.'+formName+'.masRoomID');
	obj.length = 1;
	for(i=0;i<masRoomArray.length;i++){
		if(masRoomArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=masRoomArray[i][1];
			obj.options[obj.length-1].text=masRoomArray[i][2];
		}
	}
}



function populateBlock(val,formName){
	var objT = eval('document.'+formName+'.block');
	objT.length = 1;
	for(i=0;i<blockArray.length;i++){
		if(blockArray[i][0]==val){
			objT.length++;
			objT.options[objT.length-1].value=blockArray[i][1];
			objT.options[objT.length-1].text=blockArray[i][2];
		}
	}
}

/*
 * Code for papulate postoffice on the change of District
 * Code By MUkesh Narayan Singh
 * Date 13 July 2010
 */
function populateDistrictPostOffice(val,formName){
	obj = eval('document.'+formName+'.postOff');
	obj.length = 1;
	for(i=0;i<districtPostOfficeArray.length;i++){
		if(districtPostOfficeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=districtPostOfficeArray[i][1];
			obj.options[obj.length-1].text=districtPostOfficeArray[i][2];
		}
	}
}

var doctorArray = new Array();
function populateDoctorName(val,formName){
alert("hii");
	obj = eval('document.'+formName+'.employeeId');
	obj.length = 1;
	for(i=0;i<doctorArray.length;i++){
		if(doctorArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=doctorArray[i][1];
			obj.options[obj.length-1].text=doctorArray[i][2];
		}
	}
}

var supplierArray = new Array();
function populateSupplier(val,formName){

	obj = eval('document.'+formName+'.grnGrid');
	obj.length = 1;
	for(i=0;i<supplierArray.length;i++){
		if(supplierArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=supplierArray[i][1];
			obj.options[obj.length-1].text=supplierArray[i][2];
		}
	}
}

function populatePincode(val,formName){
	obj = eval('document.'+formName+'.pincode');
	obj.length = 1;
	for(i=0;i<pincodeArray.length;i++){
		if(pincodeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=pincodeArray[i][1];
			obj.options[obj.length-1].text=pincodeArray[i][2];
		}
	}
}


function populateDoctorNamePopulate(val,formName){
	obj = eval('document.'+formName+'.employeeId');
	obj.length = 1;
	for(i=0;i<doctorArr.length;i++){
		if(doctorArr[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=doctorArr[i][1];
			obj.options[obj.length-1].text=doctorArr[i][2];
		}
	}
}

function populateDoctor(val,formName){
	obj = eval('document.'+formName+'.consultingDoctor');
	obj.length = 1;
	for(i=0;i<doctorArr.length;i++){
		if(doctorArr[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=doctorArr[i][1];
			obj.options[obj.length-1].text=doctorArr[i][2];
		}
	}
}

function populateReturnBy(val,formName){
	obj = eval('document.'+formName+'.returnBy');
	obj.length = 1;
	for(i=0;i<doctorArr.length;i++){
		if(doctorArr[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=doctorArr[i][1];
			obj.options[obj.length-1].text=doctorArr[i][2];
		}
	}
}

function showInsurance(obj,formName){
	insuranceNo = eval('document.'+formName+'.insuranceNumber');
	validFrom = eval('document.'+formName+'.validFromDate');
	validTo = eval('document.'+formName+'.validToDate');

	if(obj.checked){
		insuranceNo.setAttribute('validate','Insurance Number,string,yes');
		validFrom.setAttribute('validate','Valid From Date,date,yes');
		validTo.setAttribute('validate','Valid To Date,date,yes');
		document.getElementById('insurance').style.display='block';
	}
	else{
		insuranceNo.setAttribute('validate','Insurance Number,string,no');
		validFrom.setAttribute('validate','Valid From Date,string,no');
		validTo.setAttribute('validate','Valid To Date,string,no');
		document.getElementById('insurance').style.display='none';
	}
}

function populateAge(type, obj1){
	temp = obj1.value;
	obj1.length = 1;
	if(type == "month")
		till = 12;
	else if(type == "day")
		till = 30;
	else if(type == "year")
		till = 100;
	for(i=0;i<till;i++){
		obj1.length++
		obj1.options[i+1].value= i+1;
		obj1.options[i+1].text= i+1;
	}
	obj1.value = temp;
}


function checkOnTitle(){
	obj = document.getElementById("titleId");
	obj1 = document.getElementsByName("gender");

	var title=obj.options[obj.selectedIndex].text;
	if(title == "Mrs" || title == "Ms" && obj1.value != "feMale"){
		alert("Sorry! Wrong Selection,Please choose according to Title.")
		obj1[1].checked = true;
	}
	if(title == "Mr" || title == "Master" && obj1.value != "Male"){
		alert("Sorry! Wrong Selection,Please choose according to Title.")

		obj1[0].checked = true;
	}

}

subChargeArray = new Array();

function populateSubCharge(val,formName){
	obj = eval('document.'+formName+'.subChargeCode_id');
	obj.length = 1;
	for(i=0;i<subChargeArray.length;i++){
		if(subChargeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=subChargeArray[i][1];
			obj.options[obj.length-1].text=subChargeArray[i][2];
		}
	}
}

subChargeArray1 = new Array();

function populateSubChargeCode(val,formName){
	obj1 = eval('document.'+formName+'.subChargeCodeId');
	obj1.length = 1;
	for(i=0;i<subChargeArray1.length;i++){
		if(subChargeArray1[i][0]==val){
			obj1.length++;
			obj1.options[obj1.length-1].value=subChargeArray1[i][1];
			obj1.options[obj1.length-1].text=subChargeArray1[i][2];
		}
	}
}

chargeCodeArray = new Array();

function populateCharge(val,formName){
	obj = eval('document.'+formName+'.chargeCodeId');
	obj.length = 1;
	for(i=0;i<chargeCodeArray.length;i++){
		if(chargeCodeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=chargeCodeArray[i][1];
			obj.options[obj.length-1].text=chargeCodeArray[i][2];
		}
	}
}

// Added By Amit Das
pkgArray  = new Array();


// Addded By Amit Das
function loadRelatedPackages(val,formName){
	obj = eval('document.'+formName+'.pkgHeaderId');
	obj.length = 1;
	var i;
	for(i=0;i<pkgArray.length;i++){
		if(pkgArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=pkgArray[i][1];
			obj.options[obj.length-1].text=pkgArray[i][2];
		}
	}
	
	var e = document.getElementById("pkgSchemeId");
	var pkgSchemeId = e.options[e.selectedIndex].value;
	
	hideCardBalanceUtilized(e);
	
	if(document.getElementById("balanceUtilized"+pkgSchemeId)) {
		document.getElementById("balanceUtilized"+pkgSchemeId).style.display = 'block';
	} else{
		var text = '<input type="text" style="display: block;" readonly="readonly" name="balanceUtilized'+pkgSchemeId+'" id="balanceUtilized'+pkgSchemeId+'" value="0.00">'; 
		var child = document.getElementById("balanceLabel");
		child.insertAdjacentHTML('afterend', text);
		// child.appendChild(newInput);
	} 
		
}



// added by amit das 
function hideCardBalanceUtilized(e) {
    var j;
    for (j = 0; j < e.length; j++) {
    	if(e.options[j].value !='0' ){
    		if(document.getElementById("balanceUtilized"+e.options[j].value))
    			document.getElementById("balanceUtilized"+e.options[j].value).style.display = 'none';
    	}
    }
}


//Addded By Amit Das
pkgServicesArray = new Array();

//Addded By Amit Das
function loadRelatedPackageServices(val,formName){
	obj = eval('document.'+formName+'.pkgServiceId');
	obj.length = 1;
	var i;
	for(i=0;i<pkgServicesArray.length;i++){
		if(pkgServicesArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=pkgServicesArray[i][1];
			obj.options[obj.length-1].text=pkgServicesArray[i][2];
			document.getElementById('pkgCharge').value = pkgServicesArray[i][3];
		}
	}
	
}


//Added By Amit Das
rsbyCardArray  = new Array();
schemePkgArray = new Array();


// Addded By Amit Das
function loadBalanceUtlizied(val,formName){	
	obj = eval('document.'+formName+'.schemeLimit');
	var i;
	for(i=0;i<schemePkgArray.length;i++){
		if(schemePkgArray[i][0]==val){
			obj.value = schemePkgArray[i][1];
		}
	}	
}


function showComboAccordingToPatientType(formName){
	var patientTypeObj = eval('document.'+formName+'.patientType');
	var company = eval('document.'+formName+'.Company');
	var project = eval('document.'+formName+'.Project');
	var insurance = eval('document.'+formName+'.Insurance');
	var staff = eval('document.'+formName+'.staff');
	var dependent = eval('document.'+formName+'.staffDependent');
	var referral = eval('document.'+formName+'.referral');
	var retired = eval('document.'+formName+'.retiredStaff');

 	var patientTypeInitial=patientTypeObj.options[patientTypeObj.selectedIndex].text;

	var patientType=patientTypeInitial;
	company.setAttribute('validate','Company,string,no');
	insurance.setAttribute('validate','Insurance,string,no');
	project.setAttribute('validate','Project,string,no');

	if(patientType=='Company'){
		document.getElementById('Company').style.display='block';
		company.setAttribute('validate','Company,string,yes');
	}
	else{
		document.getElementById('Company').style.display='none';
		company.setAttribute('validate','Company,string,no');
	}

	if(patientType=='Insurance'){
		document.getElementById('Insurance').style.display='block';
		insurance.setAttribute('validate','Insurance,string,yes');

	}
	else{
		document.getElementById('Insurance').style.display='none';
		insurance.setAttribute('validate','Insurance,string,no');
	}

	if(patientType=='Project'){
		document.getElementById('Project').style.display='block';
		project.setAttribute('validate','Project,string,yes');

	}
	else{
		document.getElementById('Project').style.display='none';
		project.setAttribute('validate','Project,string,no');
	}

	if(patientType=='Staff'){
		document.getElementById('Staff').style.display='block';
		staff.setAttribute('validate','Staff,string,yes');
	}
	else{
		document.getElementById('Staff').style.display='none';
		staff.setAttribute('validate','Staff,string,no');
	}

	if(patientType=='Staff Dependant'){

		document.getElementById('Dependent').style.display='block';
		dependent.setAttribute('validate','Staff Dependent,string,yes');

		document.getElementById('Staff').style.display='block';
		staff.setAttribute('validate','Staff,string,yes');

	}
	else{
		document.getElementById('Dependent').style.display='none';
		dependent.setAttribute('validate','Staff Dependent,string,no');

	}

	if(patientType=='Referral'){
		document.getElementById('Referral').style.display='block';
		referral.setAttribute('validate','Referral,string,yes');

	}
	else{
		document.getElementById('Referral').style.display='none';
		referral.setAttribute('validate','Referral,string,no');
	}

	if(patientType=='Retired'){
		document.getElementById('Retired').style.display='block';
		retired.setAttribute('validate','Retired,string,yes');

	}
	else{
		document.getElementById('Retired').style.display='none';
		retired.setAttribute('validate','Retired,string,no');
	}

}


function populateStaffDependent(val,formName){
	obj = eval('document.'+formName+'.staffDependent');
	obj.length = 1;
	for(i=0;i<dependentArray.length;i++){
		if(dependentArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=dependentArray[i][1];
			obj.options[obj.length-1].text=dependentArray[i][2];
		}
	}
}

officeAddArr = new Array();
function populateRecordOfficeAddress(val,formName){
	obj = eval('document.'+formName+'.recordOfficeAddressId');
	obj.length = 1;
	for(i=0;i<officeAddArr.length;i++){
		if(officeAddArr[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=officeAddArr[i][1];
			obj.options[obj.length-1].text=officeAddArr[i][2];
		}
	}
}

rankArr = new Array();
function populateRank(formName){
	var servStatusObj = eval(document.getElementById('serviceStatusId'))
	var servStatus = servStatusObj.value;
	var servTypeObj = eval(document.getElementById('serviceTypeId'))
	var servType = servTypeObj.value;

	obj = eval('document.'+formName+'.rankId');
	obj.length = 1;
	for(i=0;i<rankArr.length;i++){
	if(rankArr[i][1] == servType){
		if(rankArr[i][0]==servStatus){
			obj.length++;
			obj.options[obj.length-1].value=rankArr[i][2];
			obj.options[obj.length-1].text=rankArr[i][3];
		}
		}
	}
}

var tradeArr = new Array();
function populateTrade(val,formName){
	obj = eval('document.'+formName+'.tradeId');
	obj.length = 1;
	for(i=0;i<tradeArr.length;i++){
		if(tradeArr[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=tradeArr[i][1];
			obj.options[obj.length-1].text=tradeArr[i][2];
		}
	}
}
//------------------------------------------------------------------


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

function checkBlankForAddHospital(){

	var hospitalCode = document.getElementById('codeId').value;
	var hospitalAdd = document.getElementById('hospitalAdd').value;
	var hospitalContact = document.getElementById('hospitalContact').value;
	var hospitalName = document.getElementById('hospitalName').value;

	if(trimAll(hospitalCode) == ""){
			errorMsg += "Institution Code cannot be blank.\n";
	}
	if(trimAll(hospitalName) == ""){
			errorMsg += "Institution Name cannot be blank.\n";
	}
	if(trimAll(hospitalAdd) == ""){
			errorMsg += "Address cannot be blank.\n";
	}
	if(trimAll(hospitalContact) == ""){
			errorMsg += "Contact Number cannot be blank.\n";
	}
	return true;
}

function checkBlankForAddHospitalType(){

	var hospitalTypeCode = document.getElementById('codeId').value;
	var description = document.getElementById('description').value;
//	var hospitalTypeName = document.getElementById('hospitalTypeName').value;

	if(trimAll(hospitalTypeCode) == ""){
			errorMsg += "Hospital Type Code cannot be blank.\n";
	}
	if(trimAll(hospitalTypeName) == ""){
			errorMsg += "Hospital Type  Name cannot be blank.\n";
	}

	return true;
}
function checkBlankForAddApplication(){

	var appName = document.getElementById("applicationName").value;
	var url = document.getElementById("url").value;
	if(document.getElementById("orderNo").value!= null)
	   var orderNo = document.getElementById("orderNo").value;

	if(trimAll(appName) == ""){
			errorMsg += "Application Name cannot be blank.\n";
	}
	if(trimAll(url) == ""){
			errorMsg += "Url cannot be blank.\n";
	}
	if(trimAll(orderNo) == ""){
			errorMsg += "Order No cannot be blank.\n";
	}
	return true;
}

function fetchUserHospValues(obj,formName){

  object = eval('document.'+formName)
  obj2=eval('document.'+formName+'.hiddenUserId')

  if(obj.selectedIndex != ""){


   		for(var i = 0;i<userUsergroupHospitalArray.length;i++ ){

		      if(userUsergroupHospitalArray[i][2] == obj.value &&
		      	   userUsergroupHospitalArray[i][1]==obj2.value){
		           object.userUserGroupHospId.value=userUsergroupHospitalArray[i][0];
		           object.validDate.value = userUsergroupHospitalArray[i][3];
		           object.changed_by.value=userUsergroupHospitalArray[i][4];
		           object.changed_date.value=userUsergroupHospitalArray[i][5];
		           object.changed_time.value=userUsergroupHospitalArray[i][6];
		       break;
       }
   }
  }
  else{
           alert("In else")
 }
}



function checkBlankForAddUserMaintenence(){

	var hospName = document.getElementById("hospId").value;

			if((hospName == "")||(hospName == 0))
			{

				errorMsg += "Hospital Name can not be blank.\n";

				return false;
  			}

	return true;

}
function checkBlankForAddUser(){
	var user_name = document.getElementById("userId").value;
	var password= document.getElementById("pwd").value;

			if((user_name == "")||(password == ""))
			{
				if(user_name == "")
				errorMsg += "User Name can not be blank.\n";
				if(password == "")
				errorMsg += "Password can not be blank.\n";
				return false;
  			}

	return true;

}

function filterDoctor(val,formName){
	var departmentId = val;
	//alert(departmentId)
	obj = eval('document.'+formName);
	obj.action = "/hms/hms/registration?method=filterDoctorList&departmentId="+departmentId;
	obj.submit();

}

function check(formName){
	if(document.getElementById('searchField').value == ''){
		alert("Please enter in textfield");
		return false;
	}else{
		new Ajax.Updater('statusMessage','/hms/hms/registration?method=showVisitDetails', {asynchronous:true,evalScripts:true,parameters:Form.serialize(formName)});
	}
}

function searchAdmission(formName){
	if(document.getElementById('searchField').value == ''){
		alert("Please enter in textfield");
		return false;
	}else{
		new Ajax.Updater('statusMessage','/hms/hms/adt?method=searchPatientDetailsForAdmission', {asynchronous:true,evalScripts:true,parameters:Form.serialize(formName)});
	}
}

function checkServiceType(obj){
	document.getElementById('hinNoId').innerHtml = '';

	if(obj == "7"){
		document.getElementById('sCardIdY').disabled = true;
		document.getElementById('sCardIdN').disabled = true;
		document.getElementById('cardValidityId').disabled = true;
		document.getElementById('depIssueDateId').disabled = true;
		document.getElementById('rankDivId').style.display = 'none';
		document.getElementById('sNameDiv').style.display = 'none';
		document.getElementById('tradeDivId').style.display = 'none';
		document.getElementById('tempDiv').style.display = 'none';
		document.getElementById('tempDiv2').style.display = 'none';
		generateServiveNo();
		getHin();
		document.getElementById('serRelId').style.display = 'none';
		document.getElementById('serviceStatusId').value = "0";
		document.getElementById('serviceNoId').type = 'hidden';
		document.getElementById('relationId').value = "0";
		document.getElementById('recordOffId').value = "0";
		document.getElementById('cardValidityId').value = "";
		document.getElementById('depIssueDateId').value = "";
		document.getElementById('formation').value = "";
		document.getElementById('totalServYrs').value = "";
		document.getElementById('cdaId').value = "";
		document.getElementById('stationId').value = "";
		document.getElementById('rankId').value = "0";
		document.getElementById('sFNameId').value = "";
		document.getElementById('sMNameId').value = "";
		document.getElementById('sLNameId').value = "";
		document.getElementById('tradeId').value = "0";
		document.getElementById('unitId').value = "0";
		document.getElementById('unitAddressId').value = "";
		document.getElementById('newUnitId').value = "";
		document.getElementById('newUnitAddressId').value = "";
		document.getElementById('suffixId').value = "";
		document.getElementById('sFNameId').setAttribute('validate','First Name of Service Person,string,no');
		document.getElementById('suffixId').setAttribute('validate','Suffix,string,no');
		document.getElementById('rankId').setAttribute('validate','Rank,string,no');
		document.getElementById('serviceNoId').setAttribute('validate','Service No,string,no');
		document.getElementById('relationId').setAttribute('validate','Relation to Service Personnel,string,no');
		document.getElementById('cardValidityId').setAttribute('validate','I-Card Valid,string,no');
		document.getElementById('depIssueDateId').setAttribute('validate','D_O_I Dep Card,string,no');
		document.getElementById('unitId').setAttribute('validate','Unit,string,no');
		document.getElementById('serviceStatusId').setAttribute('validate','Service Status,string,no');
		document.getElementById('formation').setAttribute('validate','Formation,alphaspace,no');
	}else{
	document.getElementById('tempDiv').style.display = 'inline';
	document.getElementById('tempDiv2').style.display = 'inline';
	document.getElementById('serviceNoId').type = 'text';
		document.getElementById('pFirstNameId').value = "";
		document.getElementById('pMiddleNameId').value = "";
		document.getElementById('pLastNameId').value = "";
		if(document.getElementById('relationId').value != '8'){
			document.getElementById('sCardIdY').disabled = false;
			document.getElementById('sCardIdN').disabled = false;
			document.getElementById('cardValidityId').disabled = false;
			document.getElementById('depIssueDateId').disabled = false;
			var sfName = "";
			var smName ="";
			var slName = "";
			if(document.getElementById('sFNameId').value != ""){
				sfName=document.getElementById('sFNameId').value;
			}
			if(document.getElementById('sMNameId').value != ""){
				smName=document.getElementById('sMNameId').value;
			}
			if(document.getElementById('sLNameId').value != ""){
				slName=document.getElementById('sLNameId').value;
			}
			if(sfName != "" || smName != "" || slName != ""){
				document.getElementById('nokNameId').value = sfName+" "+smName+" "+slName;
				}
		}else{
			document.getElementById('sCardIdY').disabled = true;
			document.getElementById('sCardIdN').disabled = true;
			document.getElementById('cardValidityId').disabled = true;
			document.getElementById('depIssueDateId').disabled = true;
			document.getElementById('nokNameId').value = "";
		}
		document.getElementById('rankDivId').style.display = 'block';
		document.getElementById('sNameDiv').style.display = 'block';
		document.getElementById('tradeDivId').style.display = 'block';
		document.getElementById('serRelId').style.display = 'block';
		document.getElementById('suffixId').setAttribute('validate','Suffix,string,yes');
		document.getElementById('rankId').setAttribute('validate','Rank,string,yes');
		document.getElementById('serviceNoId').setAttribute('validate','Service No,String,yes');
		document.getElementById('relationId').setAttribute('validate','Relation to Service Personnel,string,yes');
		document.getElementById('sFNameId').setAttribute('validate','Service Person First Name,name,yes');
		document.getElementById('unitId').setAttribute('validate','Unit,string,yes');
		document.getElementById('serviceStatusId').setAttribute('validate','Service Status,string,yes');

		if(obj == "2" || obj == "4"){
			document.getElementById('formation').setAttribute('validate','Formation,alphaspace,yes');
		}else{
			document.getElementById('formation').setAttribute('validate','Formation,alphaspace,no');
		}

		iCardY = document.getElementById('sCardIdY');
		iCardN = document.getElementById('sCardIdN');
		if(iCardY.checked == false && iCardN.checked == false){
			document.getElementById('cardValidityId').setAttribute('validate','I-Card Valid,string,no');
			document.getElementById('depIssueDateId').setAttribute('validate','D_O_I Dep Card,string,no');
		}else{
			document.getElementById('cardValidityId').setAttribute('validate','I-Card Valid,string,yes');
			document.getElementById('depIssueDateId').setAttribute('validate','D_O_I Dep Card,string,yes');
		}
	}
}

function checkForNewBorn(obj){
	if(document.getElementById('caseId').value == 11){
		document.getElementById('motherAD').style.display = 'block';
	}else{
		document.getElementById('motherAD').style.display = 'none';
	}
}

tokenArr = new Array();
function displayTokenNo(obj){
	if(document.getElementById('deptId').value == '0'){
		document.getElementById('tokenNoId').value = '';
	}else{
		if(tokenArr[0]==obj){
			document.getElementById('tokenNoId').value = tokenArr[1];
		}else{
			document.getElementById('tokenNoId').value = '1';
		}
	}
}

bedArr = new Array();
function populateBed(val,formName){
	obj = eval('document.'+formName+'.toBed');
	obj.length = 1;
	for(i=0;i<bedArr.length;i++){
		if(bedArr[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=bedArr[i][1];
			obj.options[obj.length-1].text=bedArr[i][2];
		}
	}
}


function checkConditionForList(){
	var condition = document.getElementById('conditionId').value;
	if(condition == 'Critical'){
		document.getElementById('listId').disabled = false;
		document.getElementById('listdateId').disabled = false;
		document.getElementById('listtimeId').disabled = false;
	}else{
		document.getElementById('listId').value = "0";
		document.getElementById('listdateId').value = "";
		document.getElementById('listtimeId').value = "";
		document.getElementById('listId').disabled = true;
		document.getElementById('listdateId').disabled = true;
		document.getElementById('listtimeId').disabled = true;
	}

}

function showList(formName){
	obj = eval('document.'+formName);
	obj.action = "/hms/hms/adt?method=showReadyToDischargeList";
	obj.submit();

}

function checkDischargeStatus(obj){
	if(obj == 3){
		document.getElementById('dischargeAddId').disabled = true;
		document.getElementById('expiryDetailsId').style.display = 'inline';

	}else{
		document.getElementById('dischargeAddId').disabled = false;
		document.getElementById('expiryDetailsId').style.display = 'none';

	}
}

function checkServiceCardStatus(obj){
	var serviceStatusId=document.getElementById('serviceStatusId').value

	if(obj == "n" || serviceStatusId ==2){
			document.getElementById('cardValidityId').value = "";
			document.getElementById('depIssueDateId').value = "";
			document.getElementById('cardValidityId').disabled = true;
			document.getElementById('depIssueDateId').disabled = true;
			document.getElementById('doiCardImgId').style.display = 'none';
			document.getElementById('cardValidityId').setAttribute('validate','I-Card Valid,string,no');
			document.getElementById('depIssueDateId').setAttribute('validate','D_O_I Dep Card,string,no');
		}else{
			document.getElementById('cardValidityId').disabled = false;
			document.getElementById('depIssueDateId').disabled = false;
			document.getElementById('doiCardImgId').style.display = 'inline';
			if(document.getElementById('relationId').value !=8)
			document.getElementById('cardValidityId').setAttribute('validate','I-Card Valid,string,yes');
			document.getElementById('depIssueDateId').setAttribute('validate','D_O_I Dep Card,string,no');

	}

}
function changeStatus(inc){
var status="status";
document.getElementById(status+inc).value="y";
}
function fillClinical(inc)
  {
  	 	var incPulse="incPulse";
    	var incResp="incResp";
    	var incBp="incBp";
    	var incFhr="incFhr";
    	var incRemarks="incRemarks";
    	var incPulseTemp="incPulseTemp";
    	var incRespTemp="incRespTemp";
    	var incBpTemp="incBpTemp";
    	var incFhrTemp="incFhrTemp";
    	var incRemarksTemp="incRemarksTemp";
    	var status="status";
    	var incSPO2="incSPO2";
    	var incSPO2Temp="incSPO2Temp";
    	document.getElementById(status+inc).value="y";
    	if(document.getElementById(incPulseTemp+inc).value!=""){
    		document.getElementById(incPulse+inc).value=document.getElementById(incPulseTemp+inc).value
    	}
    	else
    		document.getElementById(incPulse+inc).value=0

    	if(document.getElementById(incRespTemp+inc).value!=""){
    		document.getElementById(incResp+inc).value=document.getElementById(incRespTemp+inc).value
    	}
    	else
    		document.getElementById(incResp+inc).value=0

    	if(document.getElementById(incBpTemp+inc).value!=""){
    		document.getElementById(incBp+inc).value=document.getElementById(incBpTemp+inc).value
    	}
    	else
    		document.getElementById(incBp+inc).value=0

    	if(document.getElementById(incFhrTemp+inc).value!=""){
    		document.getElementById(incFhr+inc).value=document.getElementById(incFhrTemp+inc).value
    	}
    	else
    		document.getElementById(incFhr+inc).value="emptyString";

    	if(document.getElementById(incRemarksTemp+inc).value!=""){
    		document.getElementById(incRemarks+inc).value=document.getElementById(incRemarksTemp+inc).value
    	}
    	else
    		document.getElementById(incRemarks+inc).value="emptyString"

		if(document.getElementById(incSPO2Temp+inc).value!=""){
			document.getElementById(incSPO2+inc).value=document.getElementById(incSPO2Temp+inc).value
		}
		else
			document.getElementById(incSPO2+inc).value=0.0;
  }

  errorMsg = "";


function showIntakeOutput(obj,formName){
	urine = eval('document.'+formName+'.urine');
	stool = eval('document.'+formName+'.stool');
	vom = eval('document.'+formName+'.vom');
	asp = eval('document.'+formName+'.asp');

	if(obj.name == 'urineCheck'){
		if(obj.checked){
			urine.setAttribute('validate','Urine,string,yes');
		}
		else{
			urine.setAttribute('validate','Urine,string,no');

		}
	}
	if(obj.name == 'stoolCheck'){
		if(obj.checked){
			stool.setAttribute('validate','Stool,string,yes');
		}
		else{
			stool.setAttribute('validate','Stool,string,no');

		}
	}
	if(obj.name == 'vomCheck'){
		if(obj.checked){
			vom.setAttribute('validate','Vom,string,yes');
		}
		else{
			vom.setAttribute('validate','Vom,string,no');

		}
	}
	if(obj.name == 'aspCheck'){
		if(obj.checked){
			asp.setAttribute('validate','Asp,string,yes');
		}
		else{
			asp.setAttribute('validate','Asp,string,no');

		}
	}
}
	errorMsg = "";
function checkDob(){
	var dob = document.getElementById('dobId').value;
	dateOfBirth = new Date(dob.substring(6),(dob.substring(3,5) - 1) ,dob.substring(0,2));
 	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
	if(dateOfBirth > currentDate)
 	{
 		errorMsg += "Date of Birth is not valid.\n";
		return false;
 	}
	 return true;

}

function checkFRWIssued(frwIssued){
	if(frwIssued == 'n'){
		document.getElementById('frwSlNoId').disabled = true;
		document.getElementById('placeOfIssueId').disabled = true;
		document.getElementById('frwSlNoId').setAttribute('validate','FRW Sl. No,string,no');
		document.getElementById('placeOfIssueId').setAttribute('validate','Place of Issue,string,no');
	}else if(frwIssued == 'y'){
		document.getElementById('frwSlNoId').disabled = false;
		document.getElementById('placeOfIssueId').disabled = false;
		document.getElementById('frwSlNoId').setAttribute('validate','FRW Sl. No,alphanumeric,yes');
		document.getElementById('placeOfIssueId').setAttribute('validate','Place of Issue,alphanumeric,yes');
	}

}

function checkValidityOfCard(){
	currentDate = new Date();
	var dependentCardIssue = document.getElementById('depIssueDateId').value;
	var relationId = document.getElementById('relationId').value;
	var serviceStatusId = document.getElementById('serviceStatusId').value;
	var dependentCardIssueDate = new Date(dependentCardIssue.substring(6),(dependentCardIssue.substring(3,5) - 1) ,dependentCardIssue.substring(0,2));
	var month = dependentCardIssueDate.getMonth() + 1
	var day = dependentCardIssueDate.getDate()
	var year = dependentCardIssueDate.getFullYear()
	var year1 = year+2
		if(month < 10){
		month = "0"+month;
	}
	if(day < 10){
		day = "0"+day;
	}
	iCardValidity = day+"/"+month+"/"+year1;
	if(relationId != 8)
	document.getElementById('cardValidityId').value = iCardValidity;
	var iCardValidityDate = new Date(iCardValidity.substring(6),(iCardValidity.substring(3,5) - 1) ,iCardValidity.substring(0,2));

	if(currentDate < dependentCardIssueDate){
		alert("Dependent Card Issue Date can not be greater than current date.");
		document.getElementById('depIssueDateId').value = "";
		return false;
	}else{
	if(relationId != 8)
		document.getElementById('cardValidityId').value = iCardValidity;

		var iCardValidityDate = new Date(iCardValidity.substring(6),(iCardValidity.substring(3,5) - 1) ,iCardValidity.substring(0,2));

		if(iCardValidityDate != ""){
			if(iCardValidityDate < currentDate)
		 	{
		 		alert("Dependent Card has been expire.");
		 	}
		 }
	 }
	 return true;
}

function IsValidTime(timeStr,fieldId) {
	// Checks if time is in HH:MM:SS format.
	// The seconds are optional.
	if(timeStr!=''){
	var obj = document.getElementById(fieldId)
	var timePat = /^(\d{2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;

	var matchArray = timeStr.match(timePat);
	if (matchArray == null) {
		alert("Time should be in HH:MM format.");
		obj.value = "";
		obj.focus();
		return false;
	}
	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];
	ampm = matchArray[6];

	if (second=="") { second = null; }
	if (ampm=="") { ampm = null }

	if (hour < 0  || hour > 23) {
		alert("Hour must be between 0 and 23.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (minute<0 || minute > 59) {
		alert ("Minute must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (second != null && (second < 0 || second > 59)) {
		alert ("Second must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	return false;
	}
	return true;
	
}


// Added by Priyanka Garg on 5th Sept 2008
// for the Appointment Setup JSP and Appointment Investigation setup JSP

function IsValidTimeForSetup(timeStr,fieldId) {
	// Checks if time is in HH:MM:SS format.
	// The seconds are optional.

	var obj = document.getElementById(fieldId)
	var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;

	var matchArray = timeStr.match(timePat);
	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];
	ampm = matchArray[6];

	if (second=="") { second = null; }
	if (ampm=="") { ampm = null }

	if (hour < 0  || hour > 23) {
		alert("Hour must be between 0 and 23.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (minute<0 || minute > 59) {
		alert ("Minute must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (second != null && (second < 0 || second > 59)) {
		alert ("Second must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	return false;
}

function checkIncidenceDate(){
	var incidenceDate = document.getElementById('incidenceDateId').value;
	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);

	var one_day=1000*60*60*24;
    var incidence=incidenceDate.split("/");
    var date2=new Date(incidence[2],(incidence[1]-1),incidence[0])

    diff=Math.ceil((currentDate.getTime()-date2.getTime())/(one_day));
	if(diff > 8){
	 		errorMsg += "Incidence Date can not be older than 8 days from Today.\n";
	 	}
}
function checkMlcDate(){

	var approxDob = calculateApproxDob();
	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	if(month < 10){
		month = "0"+month;
	}
	if(day < 10){
		day = "0"+day;
	}
	dateToDisplay = day + seperator + month + seperator + year;

	var mlcDateString = document.getElementById('mlcDateId').value;
	var mlcDate = new Date(mlcDateString.substring(6),(mlcDateString.substring(3,5) - 1) ,mlcDateString.substring(0,2))
	if(approxDob > mlcDate){
		alert("MlC Date is not valid.");
		 document.getElementById('mlcDateId').value=dateToDisplay;
		return false;
	}
	if(mlcDate > currentDate){
		alert("MlC Date is not valid.");
		 document.getElementById('mlcDateId').value =dateToDisplay;
		return false;
	}

	return true;
}
function checkIncidenceDate(){

	var approxDob = calculateApproxDob();
	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	if(month < 10){
		month = "0"+month;
	}
	if(day < 10){
		day = "0"+day;
	}
	dateToDisplay = day + seperator + month + seperator + year;

	var incidenceDateString = document.getElementById('incidenceDateId').value;
	var incidenceDate = new Date(incidenceDateString.substring(6),(incidenceDateString.substring(3,5) - 1) ,incidenceDateString.substring(0,2))
	if(approxDob > incidenceDate){
		alert("Incidence Date is not valid.");
		document.getElementById('incidenceDateId').value = dateToDisplay;
		return false;
	}
	if(incidenceDate > currentDate){
		alert("Incidence Date is not valid.");
		document.getElementById('incidenceDateId').value = dateToDisplay;
		return false;
	}

	return true;
}

function calculateApproxDob(){
var age =  document.getElementById('idForAge').value;
	var obj = age.split(" ");
	currentDateJ = new Date();

	unit=obj[1];
	year = 0; month = 0; day = 0;
	if(unit == 'Years'){
		year = currentDateJ.getFullYear()- obj[0];
	}
	else if(unit == 'Months'){
		month=(currentDateJ.getMonth()+1)-obj[0]
		if(month<=0){
			month = month+12
			year--;
		}
		month = (month<10)? "0"+month : month
	}
	else if(unit == 'Days'){
		day = (currentDateJ.getDate()-obj[0])
		if(day<0){
			day = day+30
			month--;
		}
		day = (day<10)? "0"+day : day

	}

	if(year <= 0)
		year = currentDateJ.getFullYear()+year;
	if(month <= 0)
		month = (((currentDateJ.getMonth()+1)+month)<10)? "0"+((currentDateJ.getMonth()+1)+month) : ((currentDateJ.getMonth()+1)+month);
	if(day == 0)
		day = (currentDateJ.getDate()<10)? "0"+currentDateJ.getDate() : currentDateJ.getDate();

	approxDob = new Date(month + "/" + day + "/" + year);
	return approxDob;

}


function validateServiceNo(serviceNo){
if(trimAll(serviceNo) != ''){
	var serNo = trimAll(serviceNo);
	if(serNo != 0){
			getServicePersonName('registration','registration?method=getServicePersonName');
			getHin();
			populatePatientDetails();

	}else{
			alert("Service No. can not be 0.")
			document.getElementById('serviceNoId').value = "";
	}
}
}

function  validateNumeric( strValue ) {
  var objRegExp  =  /(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/;
  return objRegExp.test(strValue);
}

function trimAll( strValue ) {
 var objRegExp = /^(\s*)$/;

    //check for all spaces
    if(objRegExp.test(strValue)){
       strValue = strValue.replace(objRegExp, '');
       if( strValue.length == 0)
          return strValue;
    }

   //check for leading & trailing spaces
   objRegExp = /^(\s*)([\W\w]*)(\b\s*$)/;
   if(objRegExp.test(strValue)) {
       //remove leading and trailing whitespace characters
       strValue = strValue.replace(objRegExp, '$2');
    }
  return strValue;
}


//*--------------------------------Functions For Billing Module------------------------------*/


function calculateNetAmount(count){

	if(document.getElementById('discountOnBillId'))
	document.getElementById('discountOnBillId').value='0';
	if(document.getElementById('discountAmtBillId'))
	document.getElementById('discountAmtBillId').value='0';
	if(document.getElementById('discountOnBIllRsId'))
		document.getElementById('discountOnBIllRsId').value='0';
var rateObj;
//var patientTypeId=document.getElementById('patientTypeId').value;
//alert("patientTypeId-->"+patientTypeId);
//if(patientTypeId==13 || patientTypeId==21){
	if(document.getElementById('resrate'+count) != null || document.getElementById('rate'+count) != null){
		var qtyObj = eval(document.getElementById('qty'+count));
		if(document.getElementById('resrate'+count))
			rateObj = eval(document.getElementById('resrate'+count));
		else if(document.getElementById('rate'+count))
			rateObj = eval(document.getElementById('rate'+count));

//		var stdDedObj = eval(document.getElementById('standardDeductionId'+count))
	
		// added by amit das on 01-06-2017
		var discTypeDB = 
			document.getElementById('discTypeDB').value ;
		
		
		var amtObj = eval(document.getElementById('amount'+count));
		var disAmtObj = eval(document.getElementById('disamount'+count));
		var proportinaldisAmtObj = eval(document.getElementById('prprtnlDis'+count));

		qty = qtyObj.value;
		rate = rateObj.value;
//		stdDed = stdDedObj.value;
		/*if(stdDed != "")
			amt = qty*(parseFloat(rate)-parseFloat(stdDed));
		else*/
			amt = qty*rate;

		if(qty != "" && rate != "" && amt != ""){
			var disAmt = 0;
			var prptDisAmt = 0;
			var netAmt = 0;
			var salesTax = 0;
			var totalAmt = 0;
			var totalDiscAmt = 0;
			var netAmtObj =  eval(document.getElementById('netamount'+count));

			if(disAmtObj.value != "" && parseFloat(disAmtObj.value) != 0){
				disAmt = parseFloat(disAmtObj.value);
			}
			if(proportinaldisAmtObj.value !="" && parseFloat(proportinaldisAmtObj.value) != 0){
				prptDisAmt = parseFloat(proportinaldisAmtObj.value);
			}

			if(document.getElementById('salesTaxAmt'+count)){
				if(document.getElementById('salesTaxAmt'+count).value != ""){
					salesTax = 	document.getElementById('salesTaxAmt'+count).value;
				}
			}

			//totalDiscAmt = disAmt + prptDisAmt;
			totalDiscAmt = disAmt*qty ;

			if(totalDiscAmt != 0){				
					netAmt = parseFloat(amt)+parseFloat(salesTax)-parseFloat(totalDiscAmt);
				netAmtObj.value = parseFloat(netAmt).toFixed(2);
				amtObj.value = parseFloat(amt).toFixed(2);
				document.getElementById('payableAmtId').value=netAmt.toFixed(0);
				
				
			}else{
				// added by amit das on 01-06-2017
				if(discTypeDB=='f' || discTypeDB=='F'){
					netAmtObj.value = (parseFloat(amtObj.value)+parseFloat(salesTax)).toFixed(0);
					document.getElementById('payableAmtId').value=netAmt.toFixed(0);
				}else{
				amtObj.value = parseFloat(amt).toFixed(0);
				netAmtObj.value = (parseFloat(amt)+parseFloat(salesTax)).toFixed(0);
				document.getElementById('payableAmtId').value=netAmt.toFixed(0);
				}
			}
		}
	}
//}
else {
	document.getElementById('totalAmtId').value="0";
}
	/*if(document.getElementById('discountOnBillId').value=='' || isNaN(document.getElementById('discountOnBillId').value))
		{
		divideDiscAmtToCharges('0.00','op');

		}
	else
		{
		divideDiscAmtToCharges(document.getElementById('discountOnBillId').value,'op');
		//alert(''+document.getElementById('discountOnBillId').value);

		}*/
	
}
	
function calculateTotalAmount()
{
	var len = document.getElementById('hiddenValueCharge').value;
    var totalDiscount=0;
   for(var i=1; i<=len; i++)
	{
		if(document.getElementById('amount'+i) != null && document.getElementById('disamount'+i).value!='')
		{
			totalDiscount= parseFloat(totalDiscount)+parseFloat(parseFloat(document.getElementById('disamount'+i).value)*parseFloat(document.getElementById('qty'+i).value));
		}
	}
	document.getElementById('compDiscountId').value=totalDiscount;
	
	
}

//Added By Amit Das on 05-03-2016
function checkDiscount(){
	var inpatientId = document.getElementById("inpatientIdForCard").value;
	var url ="/hms/hms/ipd?method=showChangeSchemeJsp&parent="+inpatientId;
	if((document.getElementById('compDiscountId').value=="0" || document.getElementById('compDiscountId').value=="0.00" 
		|| document.getElementById('compDiscountId').value=="") && (document.getElementById('totalAmtId').value!="0" || 
		document.getElementById('totalAmtId').value!="0.00" 
			|| document.getElementById('totalAmtId').value!="")){
		/*if(confirm("No Discount Applied ! \nPress 'OK' for continue this billing. \nPress 'Cancel' for change patient scheme. ")){*/
		if(confirm("Press 'OK' for continue this billing. \nPress 'Cancel' for change patient scheme. ")){	
			return true;
		} else {
			window.open(url,"_self");
			return false;
		}
    } else {
		return true;
	}
}

//Added By Amit Das on 04-03-2016
function showSchemeUpgradePopup(){
	var inpatientId = document.getElementById("inpatientIdForCard").value;
	alert("Not enough balance in card. You have to change scheme!");
	var url ="/hms/hms/ipd?method=showChangeSchemeJsp&parent="+inpatientId;
	window.open(url,"_self");
    	
}

function calcProportionalDisc(count)
{
	/*if(document.getElementById('discountOnBillId').value != "" && document.getElementById('discountOnBillId').value != 0)
	{
		var dispr = document.getElementById('discountOnBillId').value;
		var disamt = 0;
		if(document.getElementById('disamount'+count).value != ""){
			disamt = document.getElementById('disamount'+count).value;
		}
		var netamt = parseFloat(document.getElementById('amount'+count).value)-parseFloat(disamt);
		//document.getElementById('prprtnlDis'+count).value = (((netamt)*parseFloat(dispr))/parseFloat(100)).toFixed(2);
		//document.getElementById('netamount'+count).value = 	(parseFloat(netamt)-parseFloat(document.getElementById('prprtnlDis'+count).value)).toFixed(2);
		document.getElementById('netamount'+count).value = (parseFloat(netamt)-parseFloat("0")).toFixed(2);
	}*/
}

function checkCollectedAmt()
{
	var patientType =0;
	if(document.getElementById('patientTypeId'))
		patientType = document.getElementById('patientTypeId').value;
	if(document.getElementById('actualColAmtId')!=null)
	{
		var os = "";
		if(document.getElementById('outstandingId'))
		{
		  if(document.getElementById('outstandingId').value  != "")
		  {
			os = document.getElementById('outstandingId').value ;
		  }
		}

		if(patientType==13 && (patientType == '3' || patientType == 0) && (os == "" || parseFloat(os) == 0))
		{
			if(document.getElementById('actualColAmtId').value == "")
			{
				alert("Please Enter Collected Amount.");
				document.getElementById('actualColAmtId').focus();
				return false;
			}
		}
	}
	return true;
}

function calculateTotalAmt()
{
	var len = document.getElementById('hiddenValueCharge').value;
	var totalAmt = 0;
	var totalNetAmt = 0;
	var totalNetAmt1 = 0;
	var totalDisAmt = 0;
	var totalSaleTaxAmt = 0;
	var totalComDiscAmt = 0;
	var totalCharity = 0;
	var stdDedValue = 0;

	for(var i=1; i<=len; i++)
	{
		if(document.getElementById('amount'+i) != null)
		{
			var qty = eval(document.getElementById('qty'+i));
			var amtObj = eval(document.getElementById('amount'+i));
			var netamtObj = eval(document.getElementById('netamount'+i));
			var netamtObj1 = eval(document.getElementById('netamount'+i));
			var disAmtObj = eval(document.getElementById('disamount'+i));
			//var prprtDisObj = eval(document.getElementById('prprtnlDis'+i));
			var amtObjValue = amtObj.value;
			var netamtObjValue = netamtObj.value;
			var netamtObjValue1 = netamtObj1.value;
			var disAmtObjValue = disAmtObj.value;
			var qtyValue = qty.value;
			//var prprtDisValue = prprtDisObj.value;
			if(netamtObjValue != ""){
				//totalNetAmt = parseFloat(netamtObjValue)+parseFloat(totalNetAmt);
				totalNetAmt1 = parseFloat(amtObjValue)-parseFloat(parseFloat(disAmtObjValue)*parseFloat(qtyValue))+parseFloat(totalNetAmt1);
				totalNetAmt= parseFloat(amtObjValue)-parseFloat(parseFloat(disAmtObjValue)*parseFloat(qtyValue))+parseFloat(totalNetAmt);
			}
			if(disAmtObjValue != "" && disAmtObjValue !=0){
				totalComDiscAmt =  parseFloat(disAmtObjValue)+parseFloat(totalComDiscAmt);
				totalDisAmt = parseFloat(disAmtObjValue)+parseFloat(totalDisAmt);
			}
			//if(prprtDisValue != "" && prprtDisValue !=0){
				//totalCharity = parseFloat(prprtDisValue)+parseFloat(totalCharity);
				//totalDisAmt = parseFloat(prprtDisValue)+parseFloat(totalDisAmt);
			//}
			if(amtObjValue != ""){
				totalAmt = parseFloat(amtObjValue)+parseFloat(totalAmt);
			}
			if(document.getElementById('salesTaxAmt'+i)){
				if(document.getElementById('salesTaxAmt'+i).value != ""){
					totalSaleTaxAmt = parseFloat(totalSaleTaxAmt) + parseFloat(document.getElementById('salesTaxAmt'+i).value);
				}
			}
			/*if(document.getElementById('standardDeductionId'+i)){
				if(document.getElementById('standardDeductionId'+i).value != ""){
					stdDedValue =  parseFloat(stdDedValue)+(parseFloat(document.getElementById('standardDeductionId'+i).value)*parseFloat(qty.value));
				}
			}*/
		}
	}

	if(stdDedValue != ""){
		document.getElementById('totalAmtId').value = (parseFloat(totalAmt) + parseFloat(totalSaleTaxAmt) ).toFixed(0);
	}else{
		document.getElementById('totalAmtId').value = (parseFloat(totalAmt) + parseFloat(totalSaleTaxAmt) ).toFixed(0);
	}
	document.getElementById('totalNetId').value = Math.round(parseFloat(totalNetAmt)).toFixed(0);
	document.getElementById('totalPayId').value = Math.round(parseFloat(totalNetAmt)).toFixed(0);
	document.getElementById('balToBePiadId').value = Math.round(parseFloat(totalNetAmt)).toFixed(0);
	document.getElementById('totalNetId1').value = Math.round(parseFloat(totalNetAmt1)).toFixed(0);
	document.getElementById('amt1').value = Math.round(parseFloat(totalNetAmt1)).toFixed(0);
	document.getElementById('amtHidden1').value = Math.round(parseFloat(totalNetAmt1)).toFixed(0);
	document.getElementById('actualColAmtId').value = Math.round(parseFloat(totalNetAmt1)).toFixed(0);
	document.getElementById('totalDisId').value = totalDisAmt.toFixed(0);
	document.getElementById('compDiscountId').value = totalComDiscAmt.toFixed(0);
	document.getElementById('charityId').value = totalCharity.toFixed(0);
	
	if(document.getElementById('outstandingId')){
		var osamt = 0;
		if(document.getElementById('outstandingId').value != ""){
			osamt = document.getElementById('outstandingId').value;
		}
		if(document.getElementById('payableAmtId')){
			if(document.getElementById('payableAmtId').value !="" && parseFloat(document.getElementById('payableAmtId').value) != 0){
				if(parseFloat(osamt) > parseFloat(totalNetAmt)){
					document.getElementById('outstandingId').value = "";
					document.getElementById('payableAmtId').value = Math.round(parseFloat(totalNetAmt)).toFixed(0);
				}else{
					document.getElementById('payableAmtId').value = Math.round(parseFloat(totalNetAmt) - parseFloat(osamt)).toFixed(0);
				}
			}else{
				if(parseFloat(osamt) != 0 ){
					document.getElementById('outstandingId').value = document.getElementById('totalNetId').value;
				}else{
					document.getElementById('payableAmtId').value = Math.round(parseFloat(totalNetAmt)).toFixed(0);
				}
			}
		}
		if(parseFloat(document.getElementById('totalDisId').value) == 0 && (parseFloat(document.getElementById('outstandingId').value) == 0 || document.getElementById('outstandingId').value == "")){
			document.getElementById('authorizerId').disabled = true;
		}else {
			document.getElementById('authorizerId').disabled = false;
		}
	}else{
			document.getElementById('payableAmtId').value = Math.round(parseFloat(totalNetAmt)).toFixed(0);
			if(parseFloat(document.getElementById('totalDisId').value) == 0 
				/*	&& parseFloat(document.getElementById('discountOnBillId').value) == 0 */){
				//document.getElementById('authorizerId').disabled = true;
			}else {
				//document.getElementById('authorizerId').disabled = false;
			}
	}

	/*var patientTypeId = 0;
	if(document.getElementById('patientTypeId').value != '0'){
		patientTypeId = document.getElementById('patientTypeId').value;
		if(patientTypeId == '1' || patientTypeId == '4'){
			document.getElementById('outstandingId').value = Math.round(parseFloat(document.getElementById('totalNetId').value)).toFixed(2);
			document.getElementById('payableAmtId').value = "0";
		}else{
			document.getElementById('amt1').value = Math.round(parseFloat(document.getElementById('payableAmtId').value)).toFixed(2);
			if(document.getElementById('actualColAmtId'))
				document.getElementById('actualColAmtId').value = Math.round(parseFloat(document.getElementById('payableAmtId').value)).toFixed(2);
				document.getElementById('balToBePiadId').value = Math.round(parseFloat(document.getElementById('payableAmtId').value)).toFixed(2);
				
		}
	}else{*/
		document.getElementById('amt1').value = Math.round(parseFloat(document.getElementById('payableAmtId').value)).toFixed(0);
		if(document.getElementById('actualColAmtId'))
			document.getElementById('actualColAmtId').value = Math.round(parseFloat(document.getElementById('payableAmtId').value)).toFixed(0);
			document.getElementById('balToBePiadId').value = Math.round(parseFloat(document.getElementById('payableAmtId').value)).toFixed(0);
			
//	}

	if(totalNetAmt.toString().indexOf('.') > 0)
	{
		if(parseFloat(document.getElementById('totalNetId').value) > parseFloat(totalNetAmt))
			document.getElementById('roundId').value = (document.getElementById('totalNetId').value-totalNetAmt).toFixed(0);
		else
			document.getElementById('roundId').value = (totalNetAmt-document.getElementById('totalNetId').value).toFixed(0);
	}else{
		document.getElementById('roundId').value = "";
	}

	if(parseFloat(document.getElementById('payableAmtId').value) == 0 || document.getElementById('payableAmtId').value == ""){
		cnt = document.getElementById("hiddenValuePayment").value;
		for(var i=1;i<=cnt;i++){
			if(document.getElementById('paymentModeId'+i)){
					document.getElementById('paymentModeId'+i).value = "";
					document.getElementById('amt'+i).value = "";
					document.getElementById('amt'+i).readOnly = true;
					document.getElementById('cqeId'+i).value = "";
					document.getElementById('cqeId'+i).readOnly = true;
					document.getElementById('chqDate'+i).value = "";
					document.getElementById('chqDate'+i).readOnly = true;
					document.getElementById('bankId'+i).value = "0";
					document.getElementById('bankId'+i).disabled = true;
				}
			else{
				if(document.getElementById('paymentModeId1'))
							document.getElementById('paymentModeId1').value = "C";
			}
				}
	}
	var totalDiscount = document.getElementById('totalDisId').value ;

	
	calculateTotalAmount();

	//populateAuthorizer(totalDiscount);
}

var authorizerArr = new Array();
function populateAuthorizer(val)
{
if(document.getElementById('authorizerId')){
	obj = document.getElementById('authorizerId');
	obj.length = 1;
	for(i=0;i<authorizerArr.length;i++){

		if(parseFloat(val) >= parseFloat(authorizerArr[i][3]) && parseFloat(authorizerArr[i][4]) >= parseFloat(val)){
			obj.length++;
			obj.options[obj.length-1].value=authorizerArr[i][0];
			obj.options[obj.length-1].text=authorizerArr[i][2];
		}
	}
}
}

function disableDiscountPercent(inc){
	var amount;
	amount=document.getElementById('netamount'+inc).value;
	if(document.getElementById('disamount'+inc).value != "" && document.getElementById('dispercent'+inc).value == ""){
		document.getElementById('dispercent'+inc).disabled = true;
	}else{
		document.getElementById('dispercent'+inc).disabled = false;
	}
}


function calculateDiscountAmt(inc){

	var amount;
/*	if(document.getElementById('prprtnlDis'+inc).value != ""){
		amount = parseFloat(document.getElementById('netamount'+inc).value)-parseFloat(document.getElementById('prprtnlDis'+inc).value)

	}else{*/
		amount=document.getElementById('netamount'+inc).value;

	//	}
	if(document.getElementById('dispercent'+inc).value != ""){
		document.getElementById('disamount'+inc).readOnly = true;
		var dispercent = document.getElementById('dispercent'+inc).value;

		var disAmount = dispercent*amount/100;
		document.getElementById('disamount'+inc).value = (parseFloat(disAmount)).toFixed(2);
		//document.getElementById('mandatorySignId').style.display = 'inline';
		document.getElementById('authorizerId').disabled = false;
		return true;
	}else{
		document.getElementById('disamount'+inc).value = "";
		document.getElementById('disamount'+inc).readOnly = false;
		//document.getElementById('mandatorySignId').style.display = 'none';
		document.getElementById('authorizerId').disabled = true;
		return true;
	}
}


function checkDiscountAmt(inc){

		var amtObj = document.getElementById('netamount'+inc).value;
		var disAmtObj = document.getElementById('disamount'+inc).value;
		var percentage = document.getElementById('dispercent'+inc).value;
		if(validateFloat(percentage)){
			if(document.getElementById('dispercent'+inc).readOnly == false){
			 if(parseFloat(percentage) > 0 && parseFloat(percentage) < 100){
				if(document.getElementById('discntPercentId'+inc) != null){
				var discntPercent = document.getElementById('discntPercentId'+inc).value;
				alert(discntPercent != "" && parseFloat(discntPercent) != 0)
				if(discntPercent != "" && parseFloat(discntPercent) != 0){
					if(parseFloat(percentage) > parseFloat(discntPercent)){
						alert("Discount(%) can not be more than "+discntPercent);
						if(document.getElementById('disamount'+inc).value != ""){
			  				document.getElementById('netamount'+inc).value = (parseFloat(document.getElementById('netamount'+inc).value)+parseFloat(document.getElementById('disamount'+inc).value) ).toFixed(2);
			  			}
						document.getElementById('dispercent'+inc).value = "";
						document.getElementById('disamount'+inc).value = "";
						return false;
					}
				}
				}
			  }else if(parseFloat(percentage) >= 100){
			  	alert("Discount(%) should be less than 100");
			  	if(document.getElementById('disamount'+inc).value != ""){
			  		document.getElementById('netamount'+inc).value = (parseFloat(document.getElementById('netamount'+inc).value)+parseFloat(document.getElementById('disamount'+inc).value) ).toFixed(2);
			  	}
			  	document.getElementById('dispercent'+inc).value = "";
			  	document.getElementById('disamount'+inc).value = "";
			  	return false;
			  }else if(parseFloat(percentage) <= 0){
			  	alert("Discount(%) should be greater than 0.");
			  	if(document.getElementById('disamount'+inc).value != ""){
			  		document.getElementById('netamount'+inc).value = (parseFloat(document.getElementById('netamount'+inc).value)+parseFloat(document.getElementById('disamount'+inc).value )).toFixed(2);
			  	}
			  	document.getElementById('dispercent'+inc).value = "";
			  	document.getElementById('disamount'+inc).value = "";
			  	return false;
			  }
			}
			}else{
				alert("Discount should contain integer or decimal value");
				if(document.getElementById('disamount'+inc).value != ""){
			  		document.getElementById('netamount'+inc).value = (parseFloat(document.getElementById('netamount'+inc).value)+parseFloat(document.getElementById('disamount'+inc).value )).toFixed(2);
			  	}
				document.getElementById('dispercent'+inc).value = "";
				document.getElementById('disamount'+inc).value = "";
				return false;
			}
		return true;
}

function validateDiscAmt(disAmtObj,inc){
var amtObj = document.getElementById('netamount'+inc).value;
if(document.getElementById('disamount'+inc).readOnly == false){
if(validateFloat(disAmtObj)){
			if(parseFloat(amtObj) < parseFloat(disAmtObj)){
				 alert("Discount Amount should be less than Net Amount.");

				 if(document.getElementById('totalDisId').value !=""){
				 	document.getElementById('totalDisId').value = parseFloat(document.getElementById('totalDisId').value);

				 }else{
				 	document.getElementById('totalDisId').value = "";
				 }
				 document.getElementById('disamount'+inc).value = "";
				return false;
			}
		}else{
			alert("Charity should contain integer or decimal value");
			document.getElementById('disamount'+inc).value = "";
			return false;
		}

}
}


function divideDiscAmtToItem(val){
	var netAmt = 0;
	var totalAmt = 0;
	var disc = 0;
	var payableAmt = 0;

	var count = document.getElementById('hiddenValueCharge').value;
	var counter = document.getElementById('totalBatchId').value;
	if(val != "" && val != 0){
		if(validateFloat(val)){
		if(parseFloat(val) <= 100){
			for(var i=1;i<=count;i++){
			  var indDiscount = 0 ;
			  var disamt = 0;
			  if(document.getElementById('itemName'+i)){
				if(document.getElementById('itemName'+i).value != ""){
					if(document.getElementById('prprtnlDis'+i).value != ""){
						document.getElementById('netamount'+i).value = parseFloat(document.getElementById('netamount'+i).value)
													+ parseFloat(document.getElementById('prprtnlDis'+i).value);
						document.getElementById('prprtnlDis'+i).value = "";
						document.getElementById('totalDisId').value = "";
					}
					if(document.getElementById('disamount'+i).value != ""){
						disamt = parseFloat(document.getElementById('disamount'+i).value);
					}
					if(document.getElementById('netamount'+i) != null){
						netAmt = document.getElementById('netamount'+i).value;
						indDiscount = (parseFloat(netAmt)*parseFloat(val))/100;
						document.getElementById('prprtnlDis'+i).value = indDiscount.toFixed(2);
						document.getElementById('netamount'+i).value =
								(parseFloat(netAmt)-parseFloat(indDiscount)).toFixed(2);
						totalAmt = parseFloat(totalAmt)+parseFloat(document.getElementById('netamount'+i).value);
						disc = parseFloat(disc)+parseFloat(disamt)+parseFloat(indDiscount);
					}
				}
				}
			}


			for(var j=1;j<=counter;j++){
				var indDiscountBatch = 0 ;
				if(document.getElementById('batchPrptDisAmtId'+j)){
					if(document.getElementById('batchPrptDisAmtId'+j).value != ""){
						document.getElementById('batchNetAmtId'+j).value =
							parseFloat(document.getElementById('batchNetAmtId'+j).value)
								+ parseFloat(document.getElementById('batchPrptDisAmtId'+j).value);
						document.getElementById('batchPrptDisAmtId'+j).value = "";
					}
					if(document.getElementById('batchNetAmtId'+j) != null){
						netAmtForBatch = document.getElementById('batchNetAmtId'+j).value;
						indDiscountBatch = (parseFloat(netAmtForBatch)*parseFloat(val))/100;
						document.getElementById('batchPrptDisAmtId'+j).value = indDiscountBatch.toFixed(2);
						document.getElementById('batchNetAmtId'+j).value =
								(parseFloat(netAmtForBatch)-parseFloat(indDiscountBatch)).toFixed(2);
					}
				}
			}

			document.getElementById('totalNetId').value = Math.round(parseFloat(totalAmt));
			document.getElementById('balToBePiadId').value = Math.round(parseFloat(totalAmt));
			calculateTotalAmt();
			var totalDiscount = document.getElementById('totalDisId').value ;
			populateAuthorizer(totalDiscount);
			document.getElementById('mandatorySignId').style.display = 'inline';
			document.getElementById('authorizerId').disabled = false;
		 }else{
		 	alert("Charity On Bill value should be less than or equal to 100");

		 	document.getElementById('discountOnBillId').value = "";
		 	document.getElementById('discountAmtBillId').value = "";
		 	document.getElementById('mandatorySignId').style.display = 'none';
		 	document.getElementById('authorizerId').disabled = true;
	 		for(var j=1;j<=counter;j++){
	 			if(document.getElementById('batchNetAmtId'+j) != null && document.getElementById('batchPrptDisAmtId'+j).value != ""){
					document.getElementById('batchNetAmtId'+j).value = parseFloat(document.getElementById('batchNetAmtId'+j).value) +
							 parseFloat(document.getElementById('batchPrptDisAmtId'+j).value)
				}
			document.getElementById('batchPrptDisAmtId'+j).value = "";
			}
		 	for(var i=1;i<=count;i++){
		 		if(document.getElementById('prprtnlDis'+i)){
		 			document.getElementById('prprtnlDis'+i).value = "";
		 			calculateNetAmtForDispensing(i);
		 		}
		 	}
	  		calculateTotalAmt();
		 	return false;

		 }
		}else{
			alert("Charity On Bill should contain integer or decimal value");
			document.getElementById('discountOnBillId').value = "";
			document.getElementById('mandatorySignId').style.display = 'none';
			document.getElementById('authorizerId').disabled = true;
			return false;
		}
	}else{
	var totalChargeDis = 0;
		for(var i=1;i<=count;i++){
			var itemDis = 0;
				if(document.getElementById('itemName'+i)){
					if(document.getElementById('netamount'+i) != null && document.getElementById('prprtnlDis'+i).value != ""){
						document.getElementById('netamount'+i).value =
								 parseFloat(document.getElementById('netamount'+i).value) +
								 parseFloat(document.getElementById('prprtnlDis'+i).value);
					}
					document.getElementById('prprtnlDis'+i).value = "";

					if(document.getElementById('disamount'+i).value != ""){
						itemDis = parseFloat(document.getElementById('disamount'+i).value);
					}
					totalChargeDis = totalChargeDis + itemDis;
				}
			}

		var counter = document.getElementById('totalBatchId').value;
		for(var j=1;j<=counter;j++){
			if(document.getElementById('batchNetAmtId'+j) != null
							&& document.getElementById('batchPrptDisAmtId'+j).value != ""){
					document.getElementById('batchNetAmtId'+j).value =
							 parseFloat(document.getElementById('batchNetAmtId'+j).value) +
							 parseFloat(document.getElementById('batchPrptDisAmtId'+j).value)
			}
			document.getElementById('batchPrptDisAmtId'+j).value = "";

		}

	if(document.getElementById('totalDisId').value != ""){
			document.getElementById('totalNetId').value = parseFloat(document.getElementById('totalNetId').value) + parseFloat(document.getElementById('totalDisId').value);
			if(document.getElementById('payableAmtId') != null){
				if(document.getElementById('payableAmtId').value !="" && parseFloat(document.getElementById('payableAmtId').value) != 0){
					document.getElementById('payableAmtId').value = (document.getElementById('totalNetId').value);
					document.getElementById('amt1').value = (document.getElementById('totalNetId').value);
				}else{
				if(document.getElementById('outstandingId'))
					document.getElementById('outstandingId').value = document.getElementById('totalNetId').value;

				}
			}
			document.getElementById('totalDisId').value = totalChargeDis;
		}

		if(document.getElementById('totalDisId').value == "" || parseFloat(document.getElementById('totalDisId').value) == 0) {
			document.getElementById('discountOnBillId').value = "";
			document.getElementById('mandatorySignId').style.display = 'none';
			document.getElementById('authorizerId').disabled = true;
		}
		calculateTotalAmt();


	}
	if(totalAmt.toString().indexOf('.') > 0)
	{
		if(parseFloat(document.getElementById('totalNetId').value) > parseFloat(totalAmt)){
			document.getElementById('roundId').value =
				(document.getElementById('totalNetId').value-totalAmt).toFixed(2);
		}
		else{
			document.getElementById('roundId').value =
				(totalAmt-document.getElementById('totalNetId').value).toFixed(2);
		}
	}

}

function divideDiscAmtToCharges(val,flag)
{	
	var netAmt = 0;
	var totalAmt = 0;
	var disc = 0;
	var payableAmt = 0;

	var count = document.getElementById('hiddenValueCharge').value;

	if(val != "")
	{
		if(validateFloat(val))
		{
		/*if(parseFloat(val) <= 100)
		{*/

			for(var i=1;i<=count;i++)
			{
				var indDiscount = 0 ;
				var disamt = 0;
				if(document.getElementById('chargeCode'+i))
				{
					/*if(document.getElementById('resrate'+i))
						document.getElementById('resrate'+i).readOnly = true;
					if(document.getElementById('prprtnlDis'+i).value != "")
					{
						document.getElementById('netamount'+i).value = 	parseFloat(document.getElementById('netamount'+i).value)
						+ parseFloat(document.getElementById('prprtnlDis'+i).value);
						document.getElementById('prprtnlDis'+i).value = "";
						document.getElementById('totalDisId').value = "";
					}
					if(document.getElementById('disamount'+i).value != "")
					{
						disamt = parseFloat(document.getElementById('disamount'+i).value);
					}*/
					if(document.getElementById('netamount'+i) != null)
					{
						if(document.getElementById('netamount'+i).value != "")
						{
						 	//document.getElementById('netamount'+i).value = document.getElementById('amount'+i).value;
						   	netAmt = parseFloat(document.getElementById('amount'+i).value)-parseFloat(parseFloat(document.getElementById('disamount'+i).value)*parseFloat(document.getElementById('qty'+i).value));
							indDiscount = (parseFloat(netAmt)*parseFloat(val))/100;
							document.getElementById('prprtnlDis'+i).value = indDiscount.toFixed(2);
							document.getElementById('netamount'+i).value = (parseFloat(netAmt)-parseFloat(indDiscount)).toFixed(2);
							/*totalAmt = parseFloat(totalAmt)+parseFloat(document.getElementById('netamount'+i).value);
							disc = parseFloat(disc)+parseFloat(disamt)+parseFloat(indDiscount);
							document.getElementById('discountAmtBillId').value = (document.getElementById('disc').value);*/
							
						}
					}
				}
			}
			/*if(document.getElementById('advAdjId'))
				document.getElementById('advAdjId').value = "";

			document.getElementById('totalNetId').value = Math.round(parseFloat(totalAmt));

			if(flag == "op")
				calculateTotalAmt();
			else if(flag == "ip")
				calculateTotalAmtForIp();

			document.getElementById('totalDisId').value=document.getElementById('discountAmtBillId').value;
			var totalDiscount = document.getElementById('totalDisId').value ;

			populateAuthorizer(totalDiscount);
			document.getElementById('mandatorySignId').style.display = 'inline';
			document.getElementById('authorizerId').disabled = false;*/
			/* }
		 else
		 {
		 	alert("Discount On Bill value should be less than or equal to 100");
		 	document.getElementById('discountOnBillId').value = "";
		 	document.getElementById('mandatorySignId').style.display = 'none';
		 	document.getElementById('authorizerId').disabled = true;
		 	for(var i=1;i<=count;i++){
		 		if(document.getElementById('prprtnlDis'+i)){
		 			document.getElementById('prprtnlDis'+i).value="";
		 			calculateNetAmount(i);
		 		}
		 	}
		 	if(flag == "op")
				calculateTotalAmt();
			else if(flag == "ip")
				calculateTotalAmtForIp();

		 	return false;

		 }*/
		}else{
			/*alert("Discount On Bill should contain integer or decimal value");
			document.getElementById('discountOnBillId').value = "";
			document.getElementById('mandatorySignId').style.display = 'none';*/
			//document.getElementById('authorizerId').disabled = true;
			return false;
		}
	}
	/*else
	{
		var totalChargeDis = 0;
		for(var i=1;i<=count;i++)
		{
			var chargeDis = 0;
			if(document.getElementById('chargeCode'+i))
			{
				if(document.getElementById('resrate'+i))
					document.getElementById('resrate'+i).readOnly = false;

				if(document.getElementById('netamount'+i) != null) //&& document.getElementById('prprtnlDis'+i).value != "")
				{
					document.getElementById('netamount'+i).value =
					parseFloat(document.getElementById('amount'+i).value) - parseFloat(document.getElementById('disamount'+i).value);
				}
				//document.getElementById('prprtnlDis'+i).value = "";

				if(document.getElementById('disamount'+i).value != ""){
					chargeDis = parseFloat(document.getElementById('disamount'+i).value);
				}
				totalChargeDis = totalChargeDis + chargeDis;
			}
  		}
		if(document.getElementById('totalDisId').value != "")
		{
			document.getElementById('totalNetId').value = parseFloat(document.getElementById('totalNetId').value) + parseFloat(document.getElementById('totalDisId').value);
			if(document.getElementById('payableAmtId') != null)
			{
				if(document.getElementById('payableAmtId').value !="" && parseFloat(document.getElementById('payableAmtId').value) != 0)
				{
					document.getElementById('payableAmtId').value = (document.getElementById('totalNetId').value);
					document.getElementById('amt1').value = (document.getElementById('totalNetId').value);
				}
				else
				{
					if(document.getElementById('outstandingId'))
						document.getElementById('outstandingId').value = document.getElementById('totalNetId').value;
				}
			}
			document.getElementById('totalDisId').value = totalChargeDis;
		}
		if(flag == "op")
			calculateTotalAmt();
		else if(flag == "ip")
			calculateTotalAmtForIp();

		if(document.getElementById('totalDisId').value == "" || parseFloat(document.getElementById('totalDisId').value) == 0) {
			document.getElementById('discountOnBillId').value = "";
			document.getElementById('mandatorySignId').style.display = 'none';
			document.getElementById('authorizerId').disabled = true;
		}

	}
	if(totalAmt.toString().indexOf('.') > 0)
	{
		if(parseFloat(document.getElementById('totalNetId').value) > parseFloat(totalAmt))
		{
				document.getElementById('roundId').value =
				(document.getElementById('totalNetId').value-totalAmt).toFixed(2);
		}
		else
		{
			document.getElementById('roundId').value =
			(totalAmt-document.getElementById('totalNetId').value).toFixed(2);
		}
	}*/
}

var subChargeCodeArray = new Array();

function populateSubChargeCodeForBilling(val,formName){

	obj = eval('document.'+formName+'.subChargeCodeId');
	obj.length = 1;
	for(i=0;i<subChargeCodeArray.length;i++){
		if(subChargeCodeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=subChargeCodeArray[i][1];
			obj.options[obj.length-1].text=subChargeCodeArray[i][2];
		}
	}
}

function validateCheque(val, inc){
	if(val != ""){
		if(!validateInteger(val)){
			alert("Please enter valid Cheque/Credit Card No.");
			document.getElementById('cqeId'+inc).value="";
			return false;
		}
	}

	return true;
}

function checkForFilledRow(){
	msg = "";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	}else{
		 var noOfRecords = document.getElementById('noOfRecords').value;
		 for(var i=1;i<=noOfRecords;i++){
		 if(document.getElementById('advAmt'+i)){
		 	if(document.getElementById('advAmt'+i).value == "" && document.getElementById('advAmt'+i).readOnly==false){
		 		msg += "Advance Amount can not be blank in row "+i+".\n";
		 	}
		 	if(document.getElementById('paymentModeId'+i).value == "Q" || document.getElementById('paymentModeId'+i).value == "R"){

		 		if(document.getElementById('cqeId'+i).value == "")
		 		{
		 		msg += "Cheque/Credit card no can not be blank in row "+i+".\n";
		 		}
		 		if(document.getElementById('chqDate'+i).value == ""){
		 		msg += "Cheque/Credit card date can not be blank in row "+i+".\n";
		 		}
		 		if(document.getElementById('bank'+i).value == ""){
		 		msg += "Bank can not be blank in row "+i+".\n";
		 		}
		 	}
			}
		 }
		 if(msg != ""){
			 	alert(msg);
			 	return false;
			 }
	}

	return true;

}

function checkPaymentMode(val, count){
	if(val == "C"){
		document.getElementById("cqeId"+count).value = "";
		document.getElementById("chqDate"+count).value = "";
		document.getElementById("bankId"+count).value = "0";
		document.getElementById("amt"+count).readOnly = false;
		document.getElementById("cqeId"+count).readOnly = true;
		if(document.getElementById("received"+count)!=null){
		document.getElementById("received"+count).readOnly = false;
		}
		document.getElementById("bankId"+count).disabled = true;
		document.getElementById("calId"+count).style.display = 'none';
	}

	else if(val == "Q" || val == "R"){
		document.getElementById("amt"+count).readOnly = false;
		document.getElementById("cqeId"+count).readOnly = false;

		//code commented by shailesh
		//document.getElementById("received"+count).readOnly = false;
		if(document.getElementById("received"+count)!=null){
		document.getElementById("received"+count).readOnly = false;

		}
		document.getElementById("bankId"+count).disabled = false;
		document.getElementById("calId"+count).style.display = 'inline';
	}else{
		document.getElementById("amt"+count).value = "";
		document.getElementById("cqeId"+count).value = "";
		document.getElementById("chqDate"+count).value = "";
		document.getElementById("bankId"+count).value = "0";
		if(document.getElementById("received"+count)!=null){
			document.getElementById("received"+count).value = "";
		}
		document.getElementById("amt"+count).readOnly = true;
		document.getElementById("cqeId"+count).readOnly = true;
		document.getElementById("chqDate"+count).readOnly = true;
		document.getElementById("bankId"+count).disabled = true;
		if(document.getElementById("received"+count)!=null){
			document.getElementById("received"+count).readOnly = true;
		}
		document.getElementById("calId"+count).style.display = 'none';
	}
}

function validateChargeCodeForBillingAutoComplete( strValue,inc, flag )
{
 	if(strValue != "")
	{
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    if(id =="")
		    {
		    		//document.getElementById('printReq'+inc).disabled = true;
		    		document.getElementById('chargeCode'+inc).value="";

		    		if(document.getElementById('chargeId'+inc))
		    			document.getElementById('chargeId'+inc).value="";
					if(document.getElementById('standardDeductionId'+inc))
 						document.getElementById('standardDeductionId'+inc).value = "";

		    		if(document.getElementById('rate'+inc) != null)
		    			document.getElementById('rate'+inc).value="";
		    		if(document.getElementById('resrate'+inc) != null)
		    			document.getElementById('resrate'+inc).value="";
	   				document.getElementById('amount'+inc).value="";

	   				if(document.getElementById('dispercent'+inc) != null)
						document.getElementById('dispercent'+inc).value="";
					if(document.getElementById('disamount'+inc) != null)
	   					document.getElementById('disamount'+inc).value="";
	   				if(document.getElementById('netamount'+inc) != null)
	   					document.getElementById('netamount'+inc).value="";
	   				if(document.getElementById('prprtnlDis'+inc) != null)
	   					document.getElementById('prprtnlDis'+inc).value="";

	   				document.getElementById('qty'+inc).readOnly = true;
	   				document.getElementById('qty'+inc).value="";

	   				calculateNetAmount(inc);
	   				if(flag == "op")
						calculateTotalAmt();
					else if(flag == "ip")
						calculateTotalAmtForIp();
 					return ;
 			}

			document.getElementById('qty'+inc).value="1";
			document.getElementById('qty'+inc).readOnly = false;

			for(i=1;i<inc;i++){
				if(inc != 1){
					if(document.getElementById('chargeCode'+i)!=null){
						var charge =  document.getElementById('chargeCode'+i).value;
						var idx1 = charge.lastIndexOf("[");
			    		var idx2 = charge.lastIndexOf("]");
			   			 idx1++;
			    		var chargeCode = charge.substring(idx1,idx2);

						if(chargeCode == id)
						{
							alert("Charge Code already selected...!")
							document.getElementById('chargeCode'+inc).value=""
							document.getElementById('qty'+inc).value="";
							document.getElementById('qty'+inc).readOnly = true;
							var e=eval(document.getElementById('chargeCode'+inc));
							e.focus();
							return false;
						}
					}
				}
			}
	      	return true;

 		}
 		else
 		{
 			if(document.getElementById('chargeCode'+inc)){
	 			document.getElementById('chargeCode'+inc).value="";
	 			if(document.getElementById('chargeId'+inc))
	 				document.getElementById('chargeId'+inc).value="";
	 			/*if(document.getElementById('standardDeductionId'+inc))
	 				document.getElementById('standardDeductionId'+inc).value = "";*/
	 			if(document.getElementById('resrate'+inc) != null)
					document.getElementById('resrate'+inc).value="";
				if(document.getElementById('rate'+inc) != null)
					document.getElementById('rate'+inc).value = "";
				document.getElementById('amount'+inc).value="";
				if(document.getElementById('dispercent'+inc) != null)
					document.getElementById('dispercent'+inc).value="";

				if(document.getElementById('disamount'+inc) != null)
					document.getElementById('disamount'+inc).value="";
				if(document.getElementById('netamount'+inc) != null)
					document.getElementById('netamount'+inc).value="";
				/*if(document.getElementById('prprtnlDis'+inc) != null)
		   			document.getElementById('prprtnlDis'+inc).value="";*/

		   		document.getElementById('qty'+inc).readOnly = true;
				document.getElementById('qty'+inc).value="";

				calculateNetAmount(inc);

				if(document.getElementById('hiddenValueCharge').value == 1){
						document.getElementById('discountOnBillId').value= "";
				}else{
					var filled = "";
					for(var i=1;i<document.getElementById('hiddenValueCharge').value;i++){
						if(document.getElementById('chargeCode'+i)){
							if(document.getElementById('chargeCode'+i).value != ""){
								filled = "yes";
								break;
							}else{
								filled = "no";
							}
						}
					}
				}
					if(filled == "no"){
						document.getElementById('discountOnBillId').value= "";
					}


				if(flag == "op")
					calculateTotalAmt();
				else if(flag == "ip")
					calculateTotalAmtForIp();

	 			return false;
	 		}
 		}

}

var bankArray=new Array();

function addRowForPayment(formName){
	var tbl = document.getElementById('paymentDetails');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdbPay = document.getElementById('hiddenValuePayment');
	hdbPay.value=iteration

	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.className = 'radioCheck';
	e0.name='selectedPayMode';
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Cash', 'C');
	e1.options[2] = new Option('Cheque', 'Q');
	if(formName == 'finalSettlement'){
		if(document.getElementById('transTypeId').value == "Receipt"){
				e1.options[3] = new Option('Credit Card', 'R');
		}
	}else{
		e1.options[3] = new Option('Credit Card', 'R');
	}

	e1.name = 'paymentMode'+ iteration;
	e1.id = 'paymentModeId' + iteration;
	e1.tabIndex="1";
	if(formName == 'finalSettlement'){
		e1.onblur= function(){checkPaymentMode(this.value,iteration);totalFinalSttmntAmt(); }
	}else{
		e1.onchange = function(){
					checkPaymentMode(this.value,iteration)};
	}
	cell1.appendChild(e1);

	/*var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='advanceAmountType'+ iteration;
	e2.id='advanceAmountTypeId'+iteration;
	e2.maxLength = '100'
	cell2.appendChild(e2);*/


	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='amountReceived'+ iteration;
	e2.id = 'amt'+iteration
	e2.readOnly = true;
	if(formName == 'billServicing' || formName == 'billDispensing' || formName == 'ipBillDispensing'){
		e2.onblur = function(){
					if(validateAmount(this.value,iteration)){calculateOutstandingAmt();}}
	}else if(formName == 'deposit'){
		e2.onblur= function(){ if(validateAmount(this.value,iteration)){totalAdvAmt();}
						}
	}else if(formName == 'ipBilling'){
		e2.onblur= function(){ if(validateAmount(this.value,iteration)){calculateOutstandingAmt();}
						}
	}else if(formName == 'cashRefund'){
		e2.onblur= function(){ if(validateAmount(this.value,iteration)){totalAdvAmt();}}

	}else if(formName == 'finalSettlement'){
		e2.onblur= function(){totalFinalSttmntAmt(); }

	}

	e2.maxLength = '9';
	e2.tabIndex="1";
	cell2.appendChild(e2);

	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='chequeNo'+ iteration;
	e3.id='cqeId'+iteration;
	e3.onblur = function(){
					validateCheque(this.value,iteration);
				};
	e3.readOnly = true;
	e3.maxLength = '20'
	cell3.appendChild(e3);

	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.readOnly = true;
	e4.name='chequeDate'+ iteration;
	e4.id='chqDate'+iteration;

	var eImg = document.createElement('img');
	eImg.src = '/hms/jsp/images/cal.gif';
	/*
	 * Code commented By Mukesh Narayan Singh
	 * Date 29 Nov 2010
	 * Comment- Not Working on IE due to this eImg.class = 'calender';
	 *
	 */
	//eImg.class = 'calender';
	eImg.style.display ='none';
	eImg.id = 'calId'+iteration;
	eImg.onclick = function(event){
					setdate('',document.getElementById('chqDate'+iteration),event) };
	cell4.appendChild(e4);
	cell4.appendChild(eImg);

	var cell5 = row.insertCell(5);
	var e5 = document.createElement('select');
	e5.name='bankName'+ iteration;
	e5.options[0] = new Option('Select', '0');
	for(var i = 0;i<bankArray.length;i++ ){
		e5.options[bankArray[i][0]] = new Option(bankArray[i][1],bankArray[i][0]);
	}
	e5.disabled = true;
	e5.id='bankId'+iteration;
	cell5.appendChild(e5);

	var cell6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.type = 'button';
	e6.name='add';
	e6.className = 'buttonAdd';
	e6.tabIndex="1";
	e6.onclick = function(){
					addRowForPayment(formName);
	}
	cell6.appendChild(e6);

}

function totalFinalSttmntAmt(){
	var totalAmt= 0;
	var count = document.getElementById('hiddenValuePayment').value;

	/*if( document.getElementById('totalAmt').value != "")
		totalAmt = document.getElementById('totalAmt').value;*/

	for(var i=1; i<=count; i++){
		var amt = 0;
		amt = eval(document.getElementById("amt"+i));
		if( amt.value != ""){
			if(validateFloat(amt.value)){
				totalAmt = parseFloat(amt.value)+parseFloat(totalAmt);
			}else{
				alert("Please enter valid amount value.\n"+totalAmt);
				document.getElementById("amt"+i).value = "";
				document.getElementById("amt"+i).focus();
				return false;
			}
		}
	}
	document.getElementById('totalAmount').value = parseFloat(totalAmt);

}

function removeRowForPayment()
{

	var tbl = document.getElementById('paymentDetails');
	var tblRows  = tbl.getElementsByTagName("tr");
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
    }

	for(counter=0;counter<document.getElementsByName('selectedPayMode').length;counter++)
	{

		if (document.getElementsByName('selectedPayMode')[counter].checked == true)
		{
 			document.getElementById('totalPayId').value = (document.getElementById('totalPayId').value - document.getElementById('amt'+(counter+1)).value);
	 		tbl.deleteRow(counter+1);

		}
	}
}

function validateAmount(val, inc){
	if(val != ""){
		if(!validateFloat(val)){
			alert("Please enter valid amount.");
			document.getElementById('amt'+inc).value="";
			return false;
		}else{
			if(val <= 0){
				alert("Please enter valid amount.");
				document.getElementById('amt'+inc).value="";
				return false;
			}
			if(val.substring(0,1) == "+" || val.substring(0,1) == "-"){
				alert("Please enter valid amount.");
				document.getElementById('amt'+inc).value="";
				return false;
			}
		}
	}
	if(document.getElementById('amtHidden'+inc))
		{
		document.getElementById('amtHidden'+inc).value = val;
		}
	return true;
}
function validateAmountIp(val, inc){
	if(val != ""){
		if(!validateFloat(val)){
			alert("Please enter valid amount.");
			document.getElementById('amt'+inc).value="";
			return false;
		}else{
			if(val <= 0){
				alert("Please enter valid amount.");
				document.getElementById('amt'+inc).value="";
				return false;
			}
			if(val.substring(0,1) == "+" || val.substring(0,1) == "-"){
				alert("Please enter valid amount.");
				document.getElementById('amt'+inc).value="";
				return false;
			}
		}
	}
	if(document.getElementById('amtHidden'+inc))
		{
		//document.getElementById('amtHidden'+inc).value = val;
		}
	return true;
}
function calculateOutstandingAmt(val){
	var cnt = document.getElementById('hiddenValuePayment').value;
	var payAmt = 0;
	if(document.getElementById('totalPayId'))
		payAmt = document.getElementById('totalPayId').value;
	else if(document.getElementById('payableAmtId')){
		payAmt = document.getElementById('payableAmtId').value;
	}
	var totalPayAmt = 0;
	for(var i=1;i<=cnt;i++){
		var amt = 0;
		var amtId="";
		if(document.getElementById('amt'+i)){
			if(document.getElementById('amt'+i).value !=  ""){
				amt = document.getElementById('amt'+i).value;
				amtId='amt'+i;
			}
		}
			totalPayAmt = parseFloat(totalPayAmt)+parseFloat(amt);
	}
	if(totalPayAmt<=payAmt)
		{
	if(document.getElementById('actualColAmtId'))
	document.getElementById('actualColAmtId').value = parseFloat(totalPayAmt).toFixed(2);
	if(document.getElementById('receivedAmtId'))
		document.getElementById('receivedAmtId').value = parseFloat(totalPayAmt).toFixed(2);
	if(document.getElementById('outstandingId')){
		if(document.getElementById('outstandingId').value != ""){

			if(document.getElementById('receivedAmtId')){
				document.getElementById('outstandingId').value = (parseFloat(document.getElementById('totalNetId').value)-parseFloat(totalPayAmt)).toFixed(2);
				document.getElementById('receivedAmtId').value = parseFloat(totalPayAmt).toFixed(2);

			}
			if(document.getElementById('payableAmtId')){
				if(document.getElementById('patientTypeId')){
/*					if(document.getElementById('patientTypeId').value == '1' || document.getElementById('patientTypeId').value == '4'){
*/					document.getElementById('outstandingId').value = (parseFloat(document.getElementById('totalNetId').value)-parseFloat(totalPayAmt)).toFixed(2);
					document.getElementById('payableAmtId').value = parseFloat(totalPayAmt).toFixed(2);
					/*}*/
					return false;
				}}		}}}
			else
				{document.getElementById(amtId).value='0';
				  alert("Can Not Add More Amount");
				  return false;
				}
			return true;
}
function calculateOutstandingAmtIp(val){
	var cnt = document.getElementById('hiddenValuePayment').value;
	var payAmt = 0;
	if(document.getElementById('totalPayId'))
		payAmt = document.getElementById('totalPayId').value;
	else if(document.getElementById('payableAmtId')){
		payAmt = document.getElementById('payableAmtId').value;
	}
	var totalPayAmt = 0;
	for(var i=1;i<=cnt;i++){
		var amt = 0;
		var amtId="";
		if(document.getElementById('amt'+i)){
			if(document.getElementById('amt'+i).value !=  ""){
				amt = document.getElementById('amt'+i).value;
				amtId='amt'+i;
			}
		}
			totalPayAmt = parseFloat(totalPayAmt)+parseFloat(amt);
	}
	if(totalPayAmt<=payAmt)
		{
	if(document.getElementById('actualColAmtId'))
	document.getElementById('actualColAmtId').value = parseFloat(totalPayAmt).toFixed(2);
	if(document.getElementById('receivedAmtId'))
		document.getElementById('receivedAmtId').value = parseFloat(totalPayAmt).toFixed(2);
	if(document.getElementById('outstandingId')){
		if(document.getElementById('outstandingId').value != ""){

			if(document.getElementById('receivedAmtId')){
				document.getElementById('outstandingId').value = (parseFloat(document.getElementById('totalNetId').value)-parseFloat(totalPayAmt)).toFixed(2);
				document.getElementById('receivedAmtId').value = parseFloat(totalPayAmt).toFixed(2);

			}
			if(document.getElementById('payableAmtId')){
				if(document.getElementById('patientTypeId')){
/*					if(document.getElementById('patientTypeId').value == '1' || document.getElementById('patientTypeId').value == '4'){
*/					document.getElementById('outstandingId').value = (parseFloat(document.getElementById('totalNetId').value)-parseFloat(totalPayAmt)).toFixed(2);
					document.getElementById('payableAmtId').value = parseFloat(totalPayAmt).toFixed(2);
					/*}*/
					return false;
				}}		}}}
			else
				{/*document.getElementById(amtId).value='0';
				  alert("Can Not Add More Amount");
				  return false;*/
				}
			return true;
}
function checkAdNo(){
	if(document.getElementById('adNoId').value == "" ){
		return false;
	}
	return true;
}

function checkHin(){
	if(document.getElementById('hinNoId').value == "" ){
		return false;
	}
	return true;
}

function validateQty(val, fieldId){
	if(document.getElementById(fieldId).readOnly == false){
		if(val != "" && val != '0'){
			if(!validateInteger(val)){
				alert("Quantity should be an integer value.");
				document.getElementById(fieldId).value = "1";
				alert(document.getElementById(fieldId));
				document.getElementById(fieldId).focus();
				return false;
			}
		}else if(val == "" || val == '0'){
			alert("Quantity should be geater than 0.");
			document.getElementById(fieldId).value = "1";
			document.getElementById(fieldId).focus();
			return false;
		}
		return true;
		}
}

function validateQtyForBilling(val, fieldId, rowVal){

	var counter = document.getElementById('hiddenValueCharge').value
	if(document.getElementById(fieldId).readOnly == false){
		if(val != "" && val != '0'){
			if(!validateInteger(val)){
				alert("Quantity should be an integer value.");
				document.getElementById(fieldId).value = "1";
				return true;
			}else{
			if(document.getElementById('dispercent'+rowVal).value != ""){
				if(document.getElementById('amount'+rowVal).value != ""){
					var discPercnt = document.getElementById('dispercent'+rowVal).value;
					var rate = 0;
					var stdDed = 0;
					if(document.getElementById('standardDeductionId'+rowVal)){
						stdDed = eval(document.getElementById('standardDeductionId'+rowVal)).value;
					}
					rate = parseFloat(document.getElementById('resrate'+rowVal).value) - parseFloat(stdDed);

					var disamt = parseFloat(rate*val)*parseFloat(discPercnt)/100;
					//document.getElementById('disamount'+rowVal).value = disamt.toFixed(2);
					//document.getElementById('prprtnlDis'+rowVal).value = "";
					//document.getElementById('netamount'+rowVal).value =(parseFloat(document.getElementById('amount'+rowVal))-parseFloat(disamt)).toFixed(2)
				}
				}
			}
		}else if(val == "" || val == '0'){
			alert("Quantity should be geater than 0.");
			document.getElementById(fieldId).value = "1";
			return true;
		}
		//document.getElementById('addBtn'+rowVal).focus();
		return true;
	}
}

function validateFieldsOnSubmit(){
	
//	var patientType = 0;
//	if(document.getElementById('patientTypeId'))
//		patientType = document.getElementById('patientTypeId').value;
//if(patientType==13){
//	if(document.getElementById('authorizerId')!=null){
//	if(patientType != '8' && patientType != '2' && patientType != '1' && patientType != '4' ){
//		if(document.getElementById('authorizerId').disabled == false){
//			if(document.getElementById('authorizerId').value == "0"){
//				alert("Select Authorizer.");
//				document.getElementById('authorizerId').focus();
//				return false;
//			}
//
//		}
//		}
//	}
	
	/*if(document.getElementById('advAdjCheckId')){
		if(document.getElementById('advAdjCheckId').checked){
			if(document.getElementById('advAdjId').value == "" && document.getElementById('advAdjId').value == "0" ){
			alert("Please enter Advance Adjustment Amount");
			return false;
			}
		}

	}*/
 
	var payableAmt = 0;
	if(document.getElementById('payableAmtId'))
		payableAmt = document.getElementById('payableAmtId').value;

	var count = document.getElementById('hiddenValuePayment').value;
	var msg = "";
	var prevCNo = "";
	var prevPayMode = "";
	for(var i=1;i<=count;i++){
		var cNo ;
		if(document.getElementById('cqeId'+i))
			cNo = document.getElementById('cqeId'+i).value;

		var payMode = "";
		if(document.getElementById('paymentModeId'+i))
			payMode = document.getElementById('paymentModeId'+i).value;

		if(document.getElementById("amt"+i).value != "" && payMode == "" && parseFloat(payableAmt) > 0){
			alert("Please Select Payment Mode.");
			return false;
		}
		if(payMode != ""){
			var amt = document.getElementById("amt"+i).value;
			if(amt == ""){
				msg += "Please enter amount in payment details.\n";
			}

			if(payMode == "Q" || payMode == "R"){
				if(document.getElementById('cqeId'+i).value == "" ){
					msg += "Cheque/Credit Card No can not be blank for payment mode Cheque/Credit Card.\n";
				}
				if(document.getElementById('chqDate'+i).value == "" ){
					msg += "Cheque/Credit Card Expiry Date can not be blank for payment mode Cheque/Credit Card.\n";
				}
				if(document.getElementById('bankId'+i).value == "0" ){
					msg += "Bank can not be blank for payment mode Cheque/Credit Card.\n";
				}
			}
			if(parseFloat(amt) < 0){
					msg += "Please enter valid amount value.\n";
					document.getElementById('amt'+i).value = "";
			}

			if(prevCNo !="" && cNo != ""){
				if(prevCNo == cNo){
					msg += "Cheque/Credit Card No can not be duplicate.\n";
					document.getElementById('cqeId'+i).value = "";
				}
			}
			if(prevPayMode != "" && payMode != ""){
				if(prevPayMode == payMode){
					msg += "Payment Mode Cash can not be more than one time.\n";
					document.getElementById('paymentModeId'+i).value = "";
					document.getElementById('amt'+i).value = "";
				}
			}

			if(msg != ""){
				break;
			}
			prevCNo = document.getElementById('cqeId'+i).value;

			if(document.getElementById('paymentModeId'+i).value == "C")
				prevPayMode = document.getElementById('paymentModeId'+i).value;
		}
	}
	if(msg != ""){
		alert(msg)
	  	return false;
	}else{
		return true;
	}

/*}*/
return true;
}

 function checkFilledRow(){
	 
	var msg ="";
	var flag = "";
	  	var count = document.getElementById('hiddenValueCharge').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('chargeCode'+i) != null){
	  	 		if(document.getElementById('chargeCode'+i).value != ""){
		  			if(document.getElementById('qty'+i).value == ""){
		  				msg += "Quantity can not be blank.\n";
		  			}
		  			if(document.getElementById('amount'+i).value == ""){
		  				msg += "Amount can not be blank.\n";
		  			}
		  			if(document.getElementById('netamount'+i) != null){
			  			if(document.getElementById('netamount'+i).value == ""){
			  				msg += "Net Amount can not be blank.\n";
			  			}
			  		}
		  			if(msg != ""){
		  				break;
		  			}
	  			}

	  		}
	  	}

  		for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('chargeCode'+i) != null){
	  	 		if(document.getElementById('chargeCode'+i).value != ""){
		  			flag = "filled";
		  			break;
		  		}else{
  					flag = "Not Filled";
  				}
	  		}
	  	}
		  	if(flag == "Not Filled"){
		  			alert("Please fill atleast one charge to submit.");
		  			return false;
		  	}
	  	if(msg != ""){
	  		alert(msg)
	  		return false;
	  	}else{
	  		return true;
	  	}
	}

function checkFilledRowForDispensing(){
	var msg ="";
	  	var count = document.getElementById('hiddenValueCharge').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('itemName'+i) != null){
	  	 		if(document.getElementById('itemName'+i).value != ""){
		  			if(document.getElementById('qty'+i).value == ""){
		  				msg += "Quantity can not be blank.\n";
		  			}else if(parseFloat(document.getElementById('qty'+i).value) == 0){
		  				msg += "Quantity should be greater than 0.\n";
		  			}
		  			if(document.getElementById('amount'+i).value == ""){
		  				msg += "Amount can not be blank.\n";
		  			}
		  			if(document.getElementById('netamount'+i).value == ""){
		  				msg += "Net Amount can not be blank.\n";
		  			}
		  			if(msg != ""){
		  				break;
		  			}
	  			}
	  		}
	  	}

	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('itemName'+i) != null){
	  	 		if(document.getElementById('itemName'+i).value != ""){
		  			flag = "filled";
		  			break;
		  		}else{
  					flag = "Not Filled";
  				}
	  		}
	  	}
		  	if(flag == "Not Filled"){
		  			alert("Please fill atleast one item to submit.");
		  			return false;
		  	}
	  	if(msg != ""){
	  		alert(msg)
	  		return false;
	  	}else{
	  		return true;
	  	}
	}

function resetAjaxValueForBilling(){
 	var count = document.getElementById('hiddenValueCharge').value;

 	for(var i=1;i<=count;i++){
 	if(document.getElementById('resrate'+i) != null){
			document.getElementById('resrate'+i).value="";
		}
	if(document.getElementById('qty'+i) != null){
			document.getElementById('qty'+i).readOnly=true;
		}
	if(document.getElementById('itemName'+i) != null){
			document.getElementById('itemName'+i).value="";
	}

	if(document.getElementById('itemCode'+i) != null){
			document.getElementById('itemCode'+i).value="";
		}
	}
 }

 function calculateBatchWiseDiscount(inc){
 	var disctPer = 0;
 	if(document.getElementById('dispercent'+inc).value != ""){
 		disctPer = document.getElementById('dispercent'+inc).value;
 	}else if(document.getElementById('dispercent'+inc).value == "" && document.getElementById('disamount'+inc).value != "" ){
 		var netamt = document.getElementById('netamount'+inc).value;
 		disctPer = (parseFloat(document.getElementById('disamount'+inc).value)*parseFloat(100))/parseFloat(netamt).toFixed(2);
 	}
 	var count = document.getElementById('totalBatchId').value;
 	var itemId = document.getElementById('itemId'+inc).value;

 	if(count != "" && disctPer != ""){
		for(var i=1;i<=count;i++){
			var batchItemId = document.getElementById('batchItemId'+i).value ;
			if(itemId == batchItemId){
				if(document.getElementById('dispercent'+inc).value != "" )
					document.getElementById('batchDisPerId'+i).value = disctPer;
				var batchAmt = document.getElementById('batchNetAmtId'+i).value;
				document.getElementById('batchDisAmtId'+i).value = parseFloat(parseFloat(batchAmt)*disctPer/100).toFixed(2);
				document.getElementById('batchNetAmtId'+i).value = (parseFloat(batchAmt)-
									parseFloat(document.getElementById('batchDisAmtId'+i).value)).toFixed(2);

			}
		}
 	}
 	if(disctPer == ""){
 		for(var i=1;i<=count;i++){
 		var batchItemId = document.getElementById('batchItemId'+i).value ;
			if(itemId == batchItemId){
				var batchAmt = document.getElementById('batchNetAmtId'+i).value;
				document.getElementById('batchNetAmtId'+i).value = parseFloat(batchAmt)+
									parseFloat(document.getElementById('batchDisAmtId'+i).value);
				document.getElementById('batchDisPerId'+i).value = "";
				document.getElementById('batchDisAmtId'+i).value = "";

			}
 		}
 	}

 }


function enableQtyAmtField(obj,inc,qty){
	if(obj.checked){
		document.getElementById('qty'+inc).readOnly = false;
		var discount = 0;
		if(document.getElementById('disId'+inc) != null){
			discount = parseFloat(document.getElementById('disId'+inc).value).toFixed(2)
		}
		document.getElementById('adviceAmount'+inc).value = parseFloat(document.getElementById('chargeId'+inc).value)+parseFloat(discount);

		if(document.getElementById('adviceCharity'+inc) != null){
			document.getElementById('adviceCharity'+inc).value = discount;
		}
	}else{
		document.getElementById('qty'+inc).readOnly = true;
		document.getElementById('qty'+inc).value = qty;
	}
}

function checkQty(val,inc,orderQty,billType){
	var discountOnQty = 0;
	var vaildated ='no';

	if(document.getElementById('selectedCharge'+inc).checked){
		if(val == ""){
			alert("Advice Quantity cannot be blank.")
			document.getElementById('qty'+inc).value = orderQty;
			return false;
		}else if(val.substring(0,1) == "+" || val.substring(0,1) == "-"){
			alert("Please enter valid Advice quantity.")
			document.getElementById('qty'+inc).value = orderQty;
			return false;
		}else if(parseFloat(val) <= 0){
			alert("Advice Quantity should be greater than 0.")
			document.getElementById('qty'+inc).value = orderQty;
			return false;
		}
		else if(val != "" && parseFloat(val) != 0){
			if(billType == 'serv'){
				if(validateInteger(val)){
					validated = 'yes';
				}else{
					alert("Advice Quantity should be an integer value.")
					document.getElementById('qty'+inc).value = orderQty;
					return false;
				}
			}else if(billType == 'disp'){
					if(validateFloat(val)){
						validated = 'yes';
					}else{
						alert("Advice Quantity should be an integer or decimal value.")
						document.getElementById('qty'+inc).value = orderQty;
						return false;
					}
			}

			if(validated == "yes"){
				if(parseFloat(val) > orderQty){
					alert("Advice Quantity cannot be greater than Ordered Quantity.")
					document.getElementById('qty'+inc).value = orderQty;
					return false;
				}else{
					if(document.getElementById('disId'+inc) != null){
						if(document.getElementById('disId'+inc).value != ""){
							var	disPerCharge = parseFloat(document.getElementById('disId'+inc).value)/parseFloat(orderQty);
							discountOnQty = (parseFloat(disPerCharge)*parseFloat(val)).toFixed(2);
							document.getElementById('adviceCharity'+inc).value = discountOnQty;
						}
					}
					if(document.getElementById('adviceAmount'+inc).value != ""){
						var	amtPerCharge = parseFloat(document.getElementById('chargeId'+inc).value)/parseFloat(orderQty);
						document.getElementById('adviceAmount'+inc).value =
										((parseFloat(amtPerCharge)*parseFloat(val))+parseFloat(discountOnQty)).toFixed(2);
					}
				}
			}
		}
	}
	return true;
}


function calculateTotalAdviceAmt(inc,flag)
{
	var pastDue = 0;
	var billAmt = 0;
	var cashAmt = 0;
	var osAmt = 0;
	var osAmt1=0;
	var count = document.getElementById('counterId').value;

	if(document.getElementById('pastDueId').value != "")
		pastDue = parseFloat(document.getElementById('pastDueId').value).toFixed(2);

	if(document.getElementById('billAmt'))
		billAmt = parseFloat(document.getElementById('billAmt').value).toFixed(2);

	if(document.getElementById('cashAmt'))
		cashAmt = parseFloat(document.getElementById('cashAmt').value).toFixed(2);


	if(document.getElementById('osAmt').value != 0 )
	{
		osAmt = parseFloat(document.getElementById('osAmt').value).toFixed(2);
	}

	if(document.getElementById('advAmt'))
	{
		if(document.getElementById('advAmt').value !=0 )
		osAmt = parseFloat(document.getElementById('advAmt').value).toFixed(2);
	}

	var totalAdvAmt = 0;
	var cashAdv = 0;
	var totalCharity = 0;
	var totalAdviceCharity = 0;
	var totalCashAmt = 0;
	var totalOnAccAmt = 0;

	if(document.getElementById('selectedCharge'+inc).checked){

		for(var i=1;i<count;i++){
			if(document.getElementById('selectedCharge'+i).checked){
			var advAmt = 0;
			var advCharityAmt = 0;
			var chargePercent = 0;
			if(document.getElementById('adviceAmount'+i).value != "")
				advAmt = parseFloat(document.getElementById('adviceAmount'+i).value).toFixed(2);

			if(advAmt != 0){
				chargePercent = ((advAmt*100)/billAmt);
			}
			if(document.getElementById('adviceCharity'+i) != null){
				if(document.getElementById('adviceCharity'+i).value != ""){
					advCharityAmt = parseFloat(document.getElementById('adviceCharity'+i).value).toFixed(2);
				}

			}
			if(advAmt != 0){
				totalAdvAmt = parseFloat(totalAdvAmt) + parseFloat(advAmt);

			}
			if(advCharityAmt != 0){
				totalAdviceCharity = parseFloat(totalAdviceCharity) + parseFloat(advCharityAmt);
			}

			if(cashAmt != 0){
				totalCashAmt = totalCashAmt + Math.round((cashAmt*chargePercent)/100);
			}
			if(osAmt != 0){
				totalOnAccAmt = totalOnAccAmt + Math.round((osAmt*chargePercent)/100);

			}

		}
		}
		document.getElementById('totalAdviceAmtId').value = totalAdvAmt.toFixed(2);
		if(document.getElementById('totalCharityAmtId'))
			document.getElementById('totalCharityAmtId').value = totalAdviceCharity.toFixed(2);

		var patientStatus = document.getElementById('patientStatus').value;
		if(totalCashAmt != 0){
			document.getElementById('cashAdviceAmtId').value = parseFloat(totalAdvAmt);
		}
		if(totalOnAccAmt != 0){
			document.getElementById('pastDueAdjId').value = totalOnAccAmt;

		}

/*if(flag == "due"){
			if(pastDue != 0){
				if((parseFloat(totalAdvAmt) - parseFloat(totalAdviceCharity)) < parseFloat(pastDue)){
					document.getElementById('pastDueAdjId').value = parseFloat(totalAdvAmt).toFixed(2) - parseFloat(totalAdviceCharity).toFixed(2);
					document.getElementById('cashAdviceAmtId').value ="";
					if(document.getElementById('totalCharityAmtId'))
						document.getElementById('totalCharityAmtId').value = parseFloat(totalAdviceCharity).toFixed(2);
				}else{
					document.getElementById('cashAdviceAmtId').value = ((parseFloat(totalAdvAmt) - parseFloat(totalAdviceCharity)) - parseFloat(pastDue)).toFixed(2);
					document.getElementById('pastDueAdjId').value = parseFloat(pastDue).toFixed(2);
					if(document.getElementById('totalCharityAmtId'))
						document.getElementById('totalCharityAmtId').value = parseFloat(totalAdviceCharity).toFixed(2);
				}
			}else{
				document.getElementById('cashAdviceAmtId').value = ((parseFloat(totalAdvAmt) - parseFloat(totalAdviceCharity)) - parseFloat(pastDue)).toFixed(2);
				document.getElementById('pastDueAdjId').value = "";
				if(document.getElementById('totalCharityAmtId'))
					document.getElementById('totalCharityAmtId').value = parseFloat(totalAdviceCharity).toFixed(2);
			}
		}else{
			document.getElementById('cashAdviceAmtId').value = parseFloat(totalAdvAmt).toFixed(2) - parseFloat(totalAdviceCharity).toFixed(2);

		}
*/
	}
	else if(!document.getElementById('selectedCharge'+inc).checked){
			var advAmt = 0;
			var advChrtAmt = 0;
			if(document.getElementById('totalAdviceAmtId').value != ""){
				totalAdvAmt = parseFloat(document.getElementById('totalAdviceAmtId').value).toFixed(2);
			}
			if(document.getElementById('adviceAmount'+inc).value != "")
				advAmt = parseFloat(document.getElementById('adviceAmount'+inc).value).toFixed(2);

			if(document.getElementById('adviceCharity'+inc)){
				if(document.getElementById('adviceCharity'+inc).value != "")
					advChrtAmt = parseFloat(document.getElementById('adviceCharity'+inc).value).toFixed(2);
				}
			if(advAmt != 0){
				chargePercent = ((advAmt*100)/billAmt);
			}

			if(advAmt != 0 && totalAdvAmt != 0){
				totalAdvAmt = parseFloat(totalAdvAmt) - parseFloat(advAmt);
				document.getElementById('totalAdviceAmtId').value = totalAdvAmt.toFixed(2);
				document.getElementById('adviceAmount'+inc).value = "";

				if(document.getElementById('adviceCharity'+inc))
					document.getElementById('adviceCharity'+inc).value = "";

				var adjCashAmt = Math.round((cashAmt*chargePercent)/100)
				var adjOnAcc = Math.round((osAmt*chargePercent)/100);

				if(document.getElementById('cashAdviceAmtId').value != "")
					document.getElementById('cashAdviceAmtId').value=totalAdvAmt.toFixed(2);
//					document.getElementById('cashAdviceAmtId').value = (parseFloat(document.getElementById('cashAdviceAmtId').value) - parseFloat(adjCashAmt)).toFixed(2);


				if(document.getElementById('pastDueAdjId')){
					document.getElementById('pastDueAdjId').value = parseFloat(document.getElementById('pastDueAdjId').value)- parseFloat(adjOnAcc);

				}
				if(document.getElementById('adviceCharity'+inc) != null){
						document.getElementById('totalCharityAmtId').value = parseFloat(document.getElementById('totalCharityAmtId').value)
							- parseFloat(advChrtAmt);
				}
			}
		}
	return true;
}

function displayAdvanceText(obj){
	if(obj.checked){
		document.getElementById('amtLabel').style.display ='block';
		document.getElementById('advAdjId').style.display ='block';
	}else{
		document.getElementById('amtLabel').style.display ='none';
		document.getElementById('advAdjId').style.display ='none';
	}
}


function checkAdvanceAmt(val,advamt){
	var netamt = document.getElementById('totalNetId').value;
	if(val !=""){

		if(validateFloat(val)){
		if(advamt != ''){
			if(parseFloat(val) > parseFloat(netamt)){
				alert("Advance Adjustment amt should be less than or equal to Net Amount.");
				document.getElementById('advAdjId').value = "";
				return false;
			}else if(parseFloat(val) > parseFloat(advamt)){
				alert("Advance Adjustment Amount should be less than or equal to Total Advance Amount.");
				document.getElementById('advAdjId').value = "";
				return false;
			}

			var cnt = document.getElementById('hiddenValuePayment').value;
			if(parseFloat(val) == parseFloat(netamt)){
				for(var i=1;i<=cnt;i++){
					if(document.getElementById('paymentModeId'+i))
						document.getElementById('paymentModeId'+i).value = "";
						document.getElementById('amt'+i).value = "";
						document.getElementById('amt'+i).readOnly = true;
						if(document.getElementById('paymentModeId'+i).value != "C"){
							document.getElementById('cqeId'+i).value = "";
							document.getElementById('cqeId'+i).readOnly = true;
							document.getElementById('chqDate'+i).value = "";
							document.getElementById('chqDate'+i).readOnly = true;
							document.getElementById('bankId'+i).value = "";
							document.getElementById('bankId'+i).disabled = true;
						}
					}
				}
			}else if(parseFloat(val) < parseFloat(netamt)){
				document.getElementById('paymentModeId1').value = "C";
			}
			document.getElementById('amt1').readOnly = false;
		document.getElementById('payableAmtId').value = (document.getElementById('totalNetId').value-val).toFixed(2);
		document.getElementById('amt1').value = parseFloat(document.getElementById('payableAmtId').value).toFixed(2);
		}else{
		alert("Advance Adjustment Amount should be integer or decimal.");
		document.getElementById('advAdjId').value = "";
		document.getElementById('payableAmtId').value = parseFloat(document.getElementById('totalNetId').value).toFixed(2);
		document.getElementById('amt1').value = parseFloat(document.getElementById('payableAmtId').value).toFixed(2);
		return false;
		}
		}
	return true;
	}



function validatePaymentAmt(){
	var msg = "";
	/*var patientTypeId=document.getElementById('patientTypeId').value;
	if(patientTypeId==13){*/
	var payAmt = 0;
	if(document.getElementById('balToBePiadId').value != "")
		payAmt = document.getElementById('balToBePiadId').value;
	var cnt = document.getElementById('hiddenValuePayment').value;
	var total = 0;
//	if(document.getElementById('advAdjCheckId')){
//		if(document.getElementById('advAdjCheckId').checked){
//			if(document.getElementById('advAdjId').value == ""){
//				msg += "Please enter Advance Adjustment Amount.\n";
//				document.getElementById('advAdjId').focus();
//			}
//			if(document.getElementById('advAdjId').value > document.getElementById('totalNetId').value){
//				alert("Advance Adjustment amt should be less than or equal to Net Amount.");
//				document.getElementById('advAdjId').value = "";
//			}
//		}
//	}

	for(var i=1;i<=cnt;i++){
	if(document.getElementById('amt'+i)){
		if(document.getElementById('amt'+i).value !="" && document.getElementById('amt'+i).value != "0"){
			total = parseFloat(total)+parseFloat(document.getElementById('amt'+i).value);
			document.getElementById('amt'+i).readOnly = false;
		}
		}
	}
	if(total != 0){
		if(parseFloat(total) < parseFloat(payAmt)){
			msg += "Payment Amount should be equal to Payable Amount.\n";
		}
	}else if(payAmt != 0 && total <= 0){
			msg += "Please enter Amount in Payment Details.\n";
	}

	if(msg != ""){
		alert(msg)
		return false;
	}
//	}
	return true;

}
function disableFields(obj){

		if(obj.value != ""){
			if(obj.id == "orderNoId"){
				document.getElementById('tempBillNoId').disabled = true;
				document.getElementById('tempBillNoId').value = "";
			}else if(obj.id == "tempBillNoId"){
				if(document.getElementById('orderNoId')){
					document.getElementById('orderNoId').disabled = true;
					document.getElementById('orderNoId').value = "";
				}else if(document.getElementById('prescriptionNo')){
					document.getElementById('prescriptionNo').disabled = true;
					document.getElementById('prescriptionNo').value = "";
				}
			}

		}else{
			document.getElementById('tempBillNoId').disabled = false;
			if(document.getElementById('orderNoId'))
				document.getElementById('orderNoId').disabled = false;
			else if(document.getElementById('prescriptionNo'))
				document.getElementById('prescriptionNo').disabled = false;
		}

	}

function displayName(){
	var w = document.getElementById('cnsltDocId').selectedIndex;
	var selectedText = document.getElementById('cnsltDocId').options[w].text;
	document.getElementById('cnsltDocTextId').value = selectedText;
}


function validateItemCodeForAutoComplete( strValue,inc ) {

 	if(strValue != "" && strValue !="No Items found")
	{
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);

		    if(id =="")
		    {
		    		document.getElementById('itemName'+inc).value="";
	    			document.getElementById('itemCode'+inc).value="";
	    			document.getElementById('itemId'+inc).value="";
		    		document.getElementById('dispercent'+inc).value ="";
	   				document.getElementById('amount'+inc).value="";
   					document.getElementById('disamount'+inc).value="";
   					document.getElementById('netamount'+inc).value="";
					if(document.getElementById('prprtnlDis'+inc) != null)
   						document.getElementById('prprtnlDis'+inc).value="";
	   				document.getElementById('qty'+inc).value="";
	   				calculateTotalAmt();
 					return ;
 			}

			for(i=1;i<inc;i++){
				if(inc != 1){
					if(document.getElementById('itemName'+i)!=null){
						var item =  document.getElementById('itemName'+i).value;
						var idx1 = item.lastIndexOf("[");
			    		var idx2 = item.lastIndexOf("]");
			   			 idx1++;
			    		var itemCode = item.substring(idx1,idx2);

						if(itemCode == id)
						{
							alert("Item already selected...!")
							document.getElementById('itemName'+inc).value=""
							document.getElementById('qty'+inc).value="";
							var e=eval(document.getElementById('itemName'+inc));
							e.focus();
							return false;
						}
					}
				}
			}

			return true;
 		}else{
 				var itemId = document.getElementById('itemId'+inc).value;
 				document.getElementById('itemName'+inc).value="";
    			document.getElementById('itemCode'+inc).value="";
    			document.getElementById('itemId'+inc).value="";
	    		document.getElementById('dispercent'+inc).value ="";
   				document.getElementById('amount'+inc).value="";
  				document.getElementById('disamount'+inc).value="";
  				document.getElementById('netamount'+inc).value="";
   				document.getElementById('qty'+inc).value="";
  				if(document.getElementById('prprtnlDis'+inc) != null)
  					document.getElementById('prprtnlDis'+inc).value="";
   				var tbl = document.getElementById('batchDetails');
				var lastRow = tbl.rows.length;

				if(lastRow > 0){
					var c = 1;
					for(var i=1;i<=lastRow;i++){
						if(document.getElementById('batchItemId'+c)){
							if(document.getElementById('batchItemId'+c).value == itemId){
								tbl.deleteRow(i-1);
								lastRow--;
								i--;
							}
						}
						c++;
					}

				}
				if(document.getElementById('hiddenValueCharge').value == 1){
					document.getElementById('discountOnBillId').value= "";
				}else{
					var flag = "";
					for(var i=1;i<document.getElementById('hiddenValueCharge').value;i++){
						if(document.getElementById('itemName'+i)){
							if(document.getElementById('itemName'+i).value != ""){
								flag = "yes";
								break;
							}else{
								flag = "no";
							}
						}
					}
					if(flag == "no"){
						document.getElementById('discountOnBillId').value= "";
					}
				}

				calculateTotalAmt();

		}

  return true;

}

function validateRows(){
	var count = document.getElementById('counterId').value;
	for(var i=1;i<count;i++){
		if(document.getElementById('selectedCharge'+i).checked){
			return true;
		}

	}
	alert("Please select at least one row.");
	return false;
}

function validateDateOfChqCrdtCard(strValue) {
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

function checkOutstandingAmt(val){
	var netamt = document.getElementById('totalNetId').value;
	if(val != "" && parseFloat(val) != 0){
	if(validateFloat(val)){
		if(val.substring(0,1) == "+" || val.substring(0,1) == "-"){
				alert("Please enter valid Outstanding amount.");
				document.getElementById('outstandingId').value="";
				document.getElementById('payableAmtId').value = document.getElementById('totalNetId').value;
				document.getElementById('amt1').value = document.getElementById('payableAmtId').value;
				document.getElementById('mandatorySignId').style.display = 'none';
				document.getElementById('authorizerId').disabled = true;
				return false;
		}else{
			if(parseFloat(val) > parseFloat(netamt)){
				alert("Oustanding Amount should be less than or equal to Net Amount.");
				document.getElementById('outstandingId').value = "";
				document.getElementById('mandatorySignId').style.display = 'none';
				document.getElementById('authorizerId').disabled = true;
				return false;
			}

			document.getElementById('payableAmtId').value = (document.getElementById('totalNetId').value-val).toFixed(2);
			document.getElementById('amt1').value =  (document.getElementById('totalNetId').value-val).toFixed(2);
			document.getElementById('mandatorySignId').style.display = 'inline';
			document.getElementById('authorizerId').disabled = false;

			var cnt = document.getElementById('hiddenValuePayment').value;
			if(parseFloat(val) == parseFloat(netamt)){
				for(var i=1;i<=cnt;i++){
					document.getElementById('paymentModeId'+i).value = "";
					document.getElementById('amt'+i).value = "";
					document.getElementById('amt'+i).readOnly = true;
					document.getElementById('cqeId'+i).value = "";
					document.getElementById('cqeId'+i).readOnly = true;
					document.getElementById('chqDate'+i).value = "";
					document.getElementById('chqDate'+i).readOnly = true;
					document.getElementById('bankId'+i).value = "0";
					document.getElementById('bankId'+i).disabled = true;
				}
			}else if(parseFloat(val) < parseFloat(netamt)){
			document.getElementById('paymentModeId1').value = "C";
			}
			document.getElementById('amt1').readOnly = false;
			populateAuthorizer(val);
		}
		}else{
			alert("Outstanding Amount should be integer or decimal value");
			return false;
		}
	}else{
		if(document.getElementById('totalDisId').value == "" || parseFloat(document.getElementById('totalDisId').value) == 0){
			document.getElementById('mandatorySignId').style.display = 'none';
			document.getElementById('authorizerId').disabled = true;
		}
		else{
			document.getElementById('mandatorySignId').style.display = 'inline';
			document.getElementById('authorizerId').disabled = false;
		}
		calculateTotalAmt();
	}
	return true;
}

function calculateTotalAmtForIp(){
	var len = document.getElementById('hiddenValueCharge').value;
	var totalAmt = 0;
	var totalNetAmt = 0;
	var totalDisAmt = 0;
	var totalSaleTaxAmt = 0;
	var totalComDiscAmt = 0;
	var totalCharity = 0;
	


	for(var i=1; i<=len; i++){
		if(document.getElementById('amount'+i) != null){
			var amtObj = eval(document.getElementById('amount'+i));
			var netamtObj = eval(document.getElementById('netamount'+i));
			var disAmtObj = eval(document.getElementById('disamount'+i));
			//var prprtDisObj = eval(document.getElementById('prprtnlDis'+i));

			var amtObjValue = amtObj.value;
			var netamtObjValue = netamtObj.value;
			var disAmtObjValue = disAmtObj.value;
			//var prprtDisValue = prprtDisObj.value;

			if(netamtObjValue != ""){
				totalNetAmt = parseFloat(netamtObjValue)+parseFloat(totalNetAmt);
			}
			if(disAmtObjValue != "" && disAmtObjValue !=0){
				totalComDiscAmt =  parseFloat(disAmtObjValue)+parseFloat(totalComDiscAmt);
				totalDisAmt = parseFloat(disAmtObjValue)+parseFloat(totalDisAmt);
			}
			//if(prprtDisValue != "" && prprtDisValue !=0){
				//totalCharity = parseFloat(prprtDisValue)+parseFloat(totalCharity);
				//totalDisAmt = parseFloat(prprtDisValue)+parseFloat(totalDisAmt);
			//}
			if(amtObjValue != ""){
				totalAmt = parseFloat(amtObjValue)+parseFloat(totalAmt);
			}

			if(document.getElementById('salesTaxAmt'+i)){
				if(document.getElementById('salesTaxAmt'+i).value != ""){
					totalSaleTaxAmt = parseFloat(totalSaleTaxAmt) + parseFloat(document.getElementById('salesTaxAmt'+i).value);
				}
			}
		}
	}
	document.getElementById('totalAmtId').value = totalAmt.toFixed(2);
	document.getElementById('totalNetId').value = Math.round(parseFloat(totalNetAmt)).toFixed(2);
	document.getElementById('totalNetId1').value = Math.round(parseFloat(totalNetAmt)).toFixed(2);
	document.getElementById('totalDisId').value = totalDisAmt.toFixed(2);
	document.getElementById('compDiscountId').value = totalComDiscAmt.toFixed(2);
	document.getElementById('charityId').value = totalCharity.toFixed(2);
	document.getElementById('payableAmtId').value = Math.round(parseFloat(totalNetAmt)).toFixed(2);
	document.getElementById('balToBePiadId').value = Math.round(parseFloat(totalNetAmt)).toFixed(2);
	document.getElementById('amt1').value = Math.round(parseFloat(totalNetAmt)).toFixed(2);
	document.getElementById('amtHidden1').value = Math.round(parseFloat(totalNetAmt)).toFixed(2);
	// Code removed By Amit Das on 05-03-2016
	var paymentAmt = 0;
	
	if(document.getElementById('receivedAmtId')){
		// added by Amit Das on 05-03-2016
		document.getElementById('receivedAmtId').value = Math.round(parseFloat(totalNetAmt)).toFixed(2);
		
		if(document.getElementById('receivedAmtId').value != ''){
		paymentAmt = document.getElementById('receivedAmtId').value;
		}

	}
	document.getElementById('outstandingId').value = Math.round(parseFloat(totalNetAmt)-parseFloat(paymentAmt)).toFixed(2);

	if(totalNetAmt.toString().indexOf('.') > 0)
	{
		if(parseFloat(document.getElementById('totalNetId').value) > parseFloat(totalNetAmt))
			document.getElementById('roundId').value = (document.getElementById('totalNetId').value-totalNetAmt).toFixed(2);
		else
			document.getElementById('roundId').value = (totalNetAmt-document.getElementById('totalNetId').value).toFixed(2);
	}else{
		document.getElementById('roundId').value = "";
	}
	var totalDiscount = document.getElementById('totalDisId').value ;
	/*alert(document.getElementById('totalNetId1'));
	alert(document.getElementById('totalNetId1').value);*/
	if(document.getElementById('totalNetId1') && document.getElementById('totalNetId1').value!='' && document.getElementById('totalNetId1').value!='0.00')
		{
	//document.getElementById('discountOnBIllRsId').onblur();
	document.getElementById('adjusetCreditId').onblur();
	document.getElementById('amt1').onblur();
	if(document.getElementById('receivedAmtId'))
		document.getElementById('receivedAmtId').onblur();
	
	}
	
	calculateTotalAmount();
	//populateAuthorizer(totalDiscount);
}


function calculateNetAmtForDispensing(count){
		var amtObj = eval(document.getElementById('amount'+count));
		var disAmtObj = eval(document.getElementById('disamount'+count));
		var proportinaldisAmtObj = eval(document.getElementById('prprtnlDis'+count));

		amt = amtObj.value;
		if(amt != ""){
			var disAmt = 0;
			var netAmt = 0;
			var salesTax = 0;
			var totalAmt = 0;
			var prptDisAmt = 0;
			var totalDiscAmt = 0;

			var netAmtObj =  eval(document.getElementById('netamount'+count));

			if(disAmtObj.value != "" && parseFloat(disAmtObj.value) != 0){
				disAmt = parseFloat(disAmtObj.value);
			}
			if(proportinaldisAmtObj.value !="" && parseFloat(proportinaldisAmtObj.value) != 0){
				prptDisAmt = parseFloat(proportinaldisAmtObj.value);
			}
			totalDiscAmt = disAmt + prptDisAmt;

			if(document.getElementById('salesTaxAmt'+count)){
				if(document.getElementById('salesTaxAmt'+count).value != ""){
					salesTax = 	document.getElementById('salesTaxAmt'+count).value;
				}
			}

			if(totalDiscAmt != 0){
				netAmt = parseFloat(amt) + parseFloat(salesTax) - parseFloat(totalDiscAmt);
				netAmtObj.value = parseFloat(netAmt).toFixed(2);
				amtObj.value = parseFloat(amt).toFixed(2);
			}else{
				amtObj.value = parseFloat(amt).toFixed(2);
				netAmtObj.value = (parseFloat(amt) + parseFloat(salesTax)).toFixed(2);
			}
		}
}

function validateChequeAndCreditCardDate(){

	var currentDate = new Date();

	var year = 0;
	var month = 0;
	var day = 0;

	year = currentDate.getFullYear();

	month=(currentDate.getMonth()+1)-6;
	if(month<=0){
		month = month+12
		year--;
	}
	month = (month<10)? "0"+month : month

	day = (currentDate.getDate())
	if(day<0){
		day = day+30
		month--;
	}
	day = (day<10)? "0"+day : day

	if(year <= 0)
		year = currentDate.getFullYear()+year;
	if(month <= 0)
		month = (((currentDate.getMonth()+1)+month)<10)? "0"+((currentDate.getMonth()+1)+month) : ((currentDate.getMonth()+1)+month);
	if(day == 0)
		day = (currentDate.getDate()<10)? "0"+currentDate.getDate() : currentDate.getDate();

	prevDate = new Date(month + "/" + day + "/" + year);

var msg  = "";

	var cnt = document.getElementById('hiddenValuePayment').value;
	for(var i=1;i<=cnt;i++){
		if(document.getElementById('paymentModeId'+i)){
			if(document.getElementById('paymentModeId'+i).value == "Q"){
				var dateStr = document.getElementById('chqDate'+i).value;
				if(dateStr != ""){
					chqDate = new Date(dateStr.substring(6),(dateStr.substring(3,5) - 1) ,dateStr.substring(0,2));
					if(chqDate < prevDate){
						msg += "Cheque Date is not valid.\n";
						document.getElementById('chqDate'+i).value = "";
					}
				}
			}else if(document.getElementById('paymentModeId'+i).value == "R"){
				var dateStr = document.getElementById('chqDate'+i).value;
				if(dateStr != ""){
					var curmonth = currentDate.getMonth() + 1;
					var curday = currentDate.getDate();
					var curyear = currentDate.getFullYear();
					var seperator = "/";
					currentDate = new Date(curmonth + seperator + curday + seperator + curyear);
					crDate = new Date(dateStr.substring(6),(dateStr.substring(3,5) - 1) ,dateStr.substring(0,2));
					if(currentDate > crDate){
						msg += "Credit card Date is not valid.\n";
						document.getElementById('chqDate'+i).value = "";
					}
				}
			}
		}
	}

		if(msg != ""){
			alert(msg);
			return false;
		}

	return true;


}

function calculateDisForChangedRate(rate,inc){

if(validateFloat(rate)){
	if(document.getElementById('resrate'+inc).disabled == false && document.getElementById('resrate'+inc).readOnly == false){
		var disPer = document.getElementById('dispercent'+inc).value;
		var amt = parseFloat(rate)*parseFloat(document.getElementById('qty'+inc).value);
		var netamt = parseFloat(amt);
		var disamt = (parseFloat(netamt)*parseFloat(disPer))/parseFloat(100);
		document.getElementById('disamount'+inc).value = disamt.toFixed(0);
	}else{
		calculateNetAmount(inc);
	}
}else{
alert("Please enter valid amount.");
document.getElementById('resrate'+inc).value = document.getElementById('actualRateId'+inc).value;
calculateNetAmount(inc);
document.getElementById('resrate'+inc).focus();

}
}

function calculateDiscPercent(billDiscAmt){
if(billDiscAmt != ""){

	var billAmt = document.getElementById('totalAmtId').value;
	var discAmt = document.getElementById('compDiscountId').value;
	var netAmt = parseFloat(billAmt) - parseFloat(discAmt);
	var discPercnt = (parseFloat(billDiscAmt)*parseFloat(100))/parseFloat(netAmt);
	document.getElementById('discountOnBillId').value  = parseFloat(discPercnt).toFixed(2);
	document.getElementById('discountOnBillId').readOnly = true;
	divideDiscAmtToItem(parseFloat(discPercnt).toFixed(2));

}else{
document.getElementById('discountOnBillId').value ="";
document.getElementById('discountOnBillId').readOnly = false;
divideDiscAmtToItem(document.getElementById('discountOnBillId').value);
}
}

function calculateDiscPercent(billDiscAmt){
	if(billDiscAmt != ""){
		var billAmt = document.getElementById('totalAmtId').value;
		var discAmt = document.getElementById('compDiscountId').value;
		var netAmt = parseFloat(billAmt) - parseFloat(discAmt);
		var discPercnt = (parseFloat(billDiscAmt)*parseFloat(100))/parseFloat(netAmt);
		document.getElementById('discountOnBillId').value  = parseFloat(discPercnt).toFixed(2);
		//document.getElementById('discountOnBillId').readOnly = true;
		divideDiscAmtToItem(parseFloat(discPercnt).toFixed(2));

	}else{
	document.getElementById('discountOnBillId').value ="";
	document.getElementById('discountOnBillId').readOnly = false;
	divideDiscAmtToItem(document.getElementById('discountOnBillId').value);
	}
	}

function calculateDiscAmtForBill(billDiscPer,flag){

	if(billDiscPer != ""){

		var billAmt = document.getElementById('totalNetId1').value;
		var discAmt = document.getElementById('compDiscountId').value;

		if(flag=='op')
		{
			var netAmt=document.getElementById('totalNetId1').value

		}
		else
		{
			var netAmt = parseFloat(billAmt) - parseFloat(discAmt);
		}

		var discAmt = (parseFloat(billDiscPer)*parseFloat(netAmt))/parseFloat(100);
		document.getElementById('discountAmtBillId').value=parseFloat(discAmt).toFixed(2);

		var payableAmtI=parseFloat(billAmt)-parseFloat(discAmt);

		document.getElementById('totalNetId').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('totalPayId').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('balToBePiadId').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('amt1').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('actualColAmtId').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('discountAmtBillId').value  = parseFloat(discAmt).toFixed(2);
		divideDiscAmtToCharges(parseFloat(billDiscPer).toFixed(2),flag);
		//document.getElementById('discountAmtBillId').readOnly = true;
	}else{
	document.getElementById('discountAmtBillId').value ="";
	document.getElementById('discountAmtBillId').readOnly = false;
	divideDiscAmtToCharges(parseFloat(discPercnt).toFixed(2),flag);

	}
	}

function showDifference(){

	var actualCollect=document.getElementById('actualColAmtId').value;
 	var netBalance=document.getElementById('balToBePiadId').value;
 	var balToBe = parseFloat(actualCollect)-parseFloat(netBalance);
// 	if(balToBe>0)
// 		{
 	 	document.getElementById('balToBeRId').value=balToBe;
 	 	document.getElementById('remainCId').value='0.00';
 	 	document.getElementById('charityTransferId').value='0.00';

 		/*}
 	else
 		{
 		document.getElementById('balToBeRId').value='0.00';
 	 	document.getElementById('remainCId').value=parseFloat(parseFloat(netBalance)-parseFloat(actualCollect)).toFixed(2);
 		}*/

 }
/*function showDifference(){

	var actualCollect=document.getElementById('actualColAmtId').value;

 	var netBalance=document.getElementById('balToBePiadId').value;
 	var balToBe = parseFloat(actualCollect)-parseFloat(netBalance);
 	if(balToBe>0)
 		{
 	 	document.getElementById('balToBeRId').value=balToBe;
 	 	document.getElementById('remainCId').value='0.00';

 		}
 	else
 		{
 		document.getElementById('balToBeRId').value='0.00';
 	 	document.getElementById('remainCId').value=parseFloat(parseFloat(netBalance)-parseFloat(actualCollect)).toFixed(2);
 		}

 }*/
 function calculateDiscAmtBill(billDiscAmt,flag){
	if(billDiscAmt != ""){
	
		var billAmt = document.getElementById('totalAmtId').value;
		var discAmt = document.getElementById('compDiscountId').value;

		if(flag=='op')
		{
			var netAmt=document.getElementById('totalNetId1').value

		}
		else
		{
			var netAmt = parseFloat(billAmt) - parseFloat(discAmt);
	
		}
		/*var netAmt = parseFloat(billAmt) - parseFloat(discAmt);*/
		
		var discPercnt = (parseFloat(billDiscAmt)*parseFloat(100))/parseFloat(netAmt);

		document.getElementById('discountOnBillId').value  = parseFloat(discPercnt).toFixed(2);
		var totalNet =  document.getElementById('totalNetId').value;

		var abc=parseFloat(discPercnt)-parseFloat(totalNet);
		alert("abc>>>>>>>>>"+abc);
		document.getElementById('actualColAmtId').value  = parseFloat(abc).toFixed(2);
		document.getElementById('payableAmtId').value  = parseFloat(abc).toFixed(2);
		document.getElementById('totalNetId').value  = parseFloat(abc).toFixed(2);
		//document.getElementById('discountOnBillId').readOnly = true;
		divideDiscAmtToCharges(parseFloat(discPercnt).toFixed(2),flag);

	}else{
	document.getElementById('discountOnBillId').value ="";
	document.getElementById('discountOnBillId').readOnly = false;
	divideDiscAmtToCharges(document.getElementById('discountOnBillId').value,flag);
	}
}
function calculateDiscPercentForOpService(billDiscAmt,flag){

	if(billDiscAmt != ""){
		var billAmt = document.getElementById('totalAmtId').value;
		var discAmt = document.getElementById('compDiscountId').value;
		if(flag=='op')
		{
			var netAmt=document.getElementById('totalNetId1').value;
		}
		else
		{
			var netAmt = parseFloat(billAmt) - parseFloat(discAmt);

		}
		/*var netAmt = parseFloat(billAmt) - parseFloat(discAmt);*/
		
		var discPercnt = (parseFloat(billDiscAmt)*parseFloat(100))/parseFloat(netAmt);

		document.getElementById('discountOnBillId').value  = parseFloat(discPercnt).toFixed(2);
		var totalNet =  document.getElementById('totalNetId').value;

		var abc=parseFloat(netAmt)-parseFloat(billDiscAmt);

		document.getElementById('payableAmtId').value  = parseFloat(abc).toFixed(2);
		document.getElementById('totalNetId').value  = parseFloat(abc).toFixed(2);
		
		document.getElementById('balToBePiadId').value  = parseFloat(abc).toFixed(2);
		document.getElementById('amt1').value  = parseFloat(abc).toFixed(2);
		document.getElementById('amtHidden1').value  = parseFloat(abc).toFixed(2);
		
//		document.getElementById('receivedAmtId').value  = parseFloat(abc).toFixed(2);
		//document.getElementById('discountOnBillId').readOnly = true;
		
		document.getElementById('amt1').onblur(); 
		if(document.getElementById('actualColAmtId'))
			document.getElementById('actualColAmtId').onblur();
		else 	if(document.getElementById('receivedAmtId'))
			document.getElementById('receivedAmtId').onblur();
		
		
		if(document.getElementById('balToBeRId'))
			document.getElementById('balToBeRId').onblur();
		else 	if(document.getElementById('balToBeRetrunId'))
			document.getElementById('balToBeRetrunId').onblur();
		
		if(document.getElementById('totalPayId'))
			document.getElementById('totalPayId').value  = parseFloat(abc).toFixed(2); 
		else 	if(document.getElementById('payableAmtId'))
			document.getElementById('payableAmtId').value  = parseFloat(abc).toFixed(2); 
		
		
		divideDiscAmtToCharges(parseFloat(discPercnt).toFixed(2),flag);
		
		

	}else{
	document.getElementById('discountOnBillId').value ="0.00";
	document.getElementById('discountOnBillId').readOnly = false;
	divideDiscAmtToCharges(document.getElementById('discountOnBillId').value,flag);
	}
}

function calculateRsDisOnBill(val,flag){


	if(val != ""){

		var billAmt = document.getElementById('totalNetId1').value;
		var discAmt = document.getElementById('compDiscountId').value;

		if(flag=='op')
		{
			var netAmt=document.getElementById('totalNetId1').value

		}
		else
		{
			var netAmt=document.getElementById('totalNetId1').value
//			var netAmt = parseFloat(billAmt) - parseFloat(discAmt);
		}

		var discAmt = (parseFloat(val)*parseFloat(netAmt))/parseFloat(100);
		document.getElementById('discountOnBIllRsId').value=parseFloat(discAmt).toFixed(2);

		var payableAmtI=parseFloat(billAmt)-parseFloat(discAmt);

		document.getElementById('totalNetId').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('payableAmtId').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('balToBePiadId').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('amt1').value  = parseFloat(payableAmtI).toFixed(2);
		//document.getElementById('actualColAmtId').value  = parseFloat(payableAmtI).toFixed(2);

		//document.getElementById('discountOnBIllRsId').readOnly = true;
		divideDiscAmtToCharges(parseFloat(val).toFixed(2),flag);

	}else{
	var netAmt=document.getElementById('totalNetId1').value
	document.getElementById('discountOnBIllRsId').value ="0.00";
	document.getElementById('discountOnBillId').value='0.00';
	document.getElementById('totalNetId').value  = parseFloat(netAmt).toFixed(2);
	document.getElementById('payableAmtId').value  = parseFloat(netAmt).toFixed(2);
	document.getElementById('balToBePiadId').value  = parseFloat(netAmt).toFixed(2);
	document.getElementById('amt1').value  = parseFloat(netAmt).toFixed(2);
	//document.getElementById('discountAmtBillId').readOnly = false;
	divideDiscAmtToCharges(parseFloat('0.00').toFixed(2),flag);


	}
	
	/*
	
	
	if(val != ""){

		var billAmt = document.getElementById('totalNetId').value;
		var disPer = (parseFloat(billAmt)*parseFloat(val))/parseFloat(100);
		document.getElementById('discountOnBIllRsId').value=disPer.toFixed(2);
		var paybleAmt = parseFloat(billAmt)-parseFloat(disPer);
		document.getElementById('payableAmtId').value=paybleAmt.toFixed(2);
		document.getElementById('balToBePiadId').value=paybleAmt.toFixed(2);
		document.getElementById('totalNetId').value=paybleAmt.toFixed(2);
		document.getElementById('amt1').value=paybleAmt.toFixed(2);
		document.getElementById('receivedAmtId').value=paybleAmt.toFixed(2);
	}*/
	}

function calculatePerDisOnBill(val,flag){
	
	if(val != ""){

		var billAmt = document.getElementById('totalNetId1').value;
		var discAmt = document.getElementById('compDiscountId').value;

		if(flag=='op')
		{
			var netAmt=document.getElementById('totalNetId1').value
		}
		else
		{
			var netAmt=document.getElementById('totalNetId1').value
			//var netAmt = parseFloat(billAmt) - parseFloat(discAmt);
		}

		var billDiscPer = (parseFloat(val)*parseFloat(100))/parseFloat(netAmt);
		document.getElementById('discountOnBillId').value=parseFloat(billDiscPer).toFixed(2);

		var payableAmtI=parseFloat(billAmt)-parseFloat(val);

		document.getElementById('totalNetId').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('payableAmtId').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('balToBePiadId').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('amt1').value  = parseFloat(payableAmtI).toFixed(2);
		document.getElementById('amtHidden1').value  = parseFloat(payableAmtI).toFixed(2);
		
		//document.getElementById('actualColAmtId').value  = parseFloat(payableAmtI).toFixed(2);
		//document.getElementById('discountAmtBillId').value  = parseFloat(discAmt).toFixed(2);

		//document.getElementById('discountOnBillId').readOnly = true;
		divideDiscAmtToCharges(parseFloat(billDiscPer).toFixed(2),flag);


	}else{
		var netAmt=document.getElementById('totalNetId1').value
	document.getElementById('discountOnBillId').value ="0.00";
	document.getElementById('compDiscountId').value='0.00';
	document.getElementById('totalNetId').value  = parseFloat(netAmt).toFixed(2);
	document.getElementById('payableAmtId').value  = parseFloat(netAmt).toFixed(2);
	document.getElementById('balToBePiadId').value  = parseFloat(netAmt).toFixed(2);
	document.getElementById('amt1').value  = parseFloat(netAmt).toFixed(2);
	document.getElementById('amtHidden1').value  = parseFloat(netAmt).toFixed(2);
	//document.getElementById('discountOnBillId').readOnly = false;
	divideDiscAmtToCharges(parseFloat('0.00').toFixed(2),flag);


	}
	
	/*if(val != ""){
		var billAmt = document.getElementById('totalNetId').value;
		var disAmt = parseFloat(billAmt)-parseFloat(val);
		var discPercnt = (parseFloat(val)*parseFloat(100))/parseFloat(billAmt);
		document.getElementById('discountOnBillId').value  = parseFloat(discPercnt).toFixed(2);
		document.getElementById('payableAmtId').value  = parseFloat(disAmt).toFixed(2);
		document.getElementById('balToBePiadId').value  = parseFloat(disAmt).toFixed(2);
		document.getElementById('totalNetId').value  = parseFloat(disAmt).toFixed(2);
		document.getElementById('amt1').value  = parseFloat(disAmt).toFixed(2);
		document.getElementById('receivedAmtId').value  = parseFloat(disAmt).toFixed(2);
		}*/
	}
function displayIpAdvance(obj,flag){
	
	if(obj.checked){
		document.getElementById('outstandingId').style.display =true;
		document.getElementById('adjusetCreditId').style.display =true;
		var advAmt = document.getElementById('avAdvAmtId').value;
		alert(advAmt);
		document.getElementById('adjusetCreditId').value=parseFloat(advAmt).toFixed(2);
	}else{
		document.getElementById('outstandingId').style.display =false;
		document.getElementById('adjusetCreditId').style.display =false;
	}
}
function displayOPAdvance(obj){
	if(obj.checked){
		//document.getElementById('advanceadjistdiv').style.display ="inline";
		document.getElementById('avAdvAmtId').style.display ="inline";
		document.getElementById('adjusetCreditId').style.display ="inline";
		var advAmt = document.getElementById('avAdvAmtId').value;
		document.getElementById('adjusetCreditId').value='0.00';
		document.getElementById('avAdvAmtId').value=parseFloat(advAmt).toFixed(2);
		//calculateDiscPercentForOpService(document.getElementById('discountAmtBillId').value,'op');
	}else{
		// document.getElementById('advanceadjistdiv').style.display ="none";
		document.getElementById('avAdvAmtId').style.display ="none";
		document.getElementById('adjusetCreditId').style.display ="none";
		var advAmt = document.getElementById('avAdvAmtId').value;
		document.getElementById('adjusetCreditId').value='0.00';
		document.getElementById('avAdvAmtId').value=parseFloat(advAmt).toFixed(2);
		//calculateDiscPercentForOpService(document.getElementById('discountAmtBillId').value,'op');
		/*document.getElementById('outstandingId').style.display =false;
		document.getElementById('adjusetCreditId').style.display =false;*/
	}
}

function displayPaywardAdvance(obj){
	if(obj.checked){
		document.getElementById('advanceadjistdiv').style.display ="inline";
		/*document.getElementById('avAdvAmtId').style.display =true;
		document.getElementById('adjusetCreditId').style.display =true;*/
		var advAmt = document.getElementById('avAdvAmtId').value;
		document.getElementById('adjusetCreditId').value='0.00';
		document.getElementById('avAdvAmtId').value=parseFloat(advAmt).toFixed(2);
	}else{
		document.getElementById('advanceadjistdiv').style.display ="none";
		var advAmt = document.getElementById('avAdvAmtId').value;
		document.getElementById('adjusetCreditId').value='0.00';
		document.getElementById('avAdvAmtId').value=parseFloat(advAmt).toFixed(2);
		/*document.getElementById('outstandingId').style.display =false;
		document.getElementById('adjusetCreditId').style.display =false;*/
	}
}

function displayPaywardAllotmentAdvance(obj){
	if(obj.checked){
		document.getElementById('advanceadjistdiv').style.display ="inline";
		/*document.getElementById('avAdvAmtId').style.display =true;
		document.getElementById('adjusetCreditId').style.display =true;*/
		var advAmt = document.getElementById('balanceAmount').value;
		document.getElementById('adjusetCreditId').value='0.00';
		document.getElementById('avAdvAmtId').value=parseFloat(advAmt).toFixed(2);
	}else{
		document.getElementById('advanceadjistdiv').style.display ="none";
		var advAmt = document.getElementById('balanceAmount').value;
		document.getElementById('adjusetCreditId').value='0.00';
		document.getElementById('avAdvAmtId').value=parseFloat(advAmt).toFixed(2);
		/*document.getElementById('outstandingId').style.display =false;
		document.getElementById('adjusetCreditId').style.display =false;*/
	}
}
function transferCharity(obj,flag){
	if(obj.checked){
		var balToBeR='0.00;'
			if(document.getElementById('remainCId'))
				balToBeR=document.getElementById('remainCId').value;
		//document.getElementById('charityTransferId').value=parseFloat(balToBeR).toFixed(2);
		document.getElementById('charityTransferId').value='0.00';
		document.getElementById('charityIdd').disabled =false;
		document.getElementById('charityTransferId').disabled =false;
		
	}else{
		document.getElementById('charityTransferId').value='0.00';
		document.getElementById('charityIdd').disabled=true;
		document.getElementById('charityTransferId').disabled=true;
	}
}
function totalAdvCredit(val) {
	if (val != "") {
		document.getElementById('charityTransferId').value = '0.00';
		var pasDue = document.getElementById('avAdvAmtId').value;
		var totalCredit = parseFloat(pasDue) + parseFloat(val);
		// document.getElementById('remainCId').value=parseFloat(totalCredit).toFixed(2);
		var actualCollect = document.getElementById('actualColAmtId').value;
		var netBalance = document.getElementById('balToBePiadId').value;
		var balToBe = parseFloat(actualCollect) - parseFloat(netBalance);
		if (isNaN(balToBe)) {
			alert('please enter correct value.');
		} else {
			if (balToBe < 0) {
				alert('Balance to be Returned is less than 0.');
			} else {
				var remainingCredit = balToBe - parseFloat(val);
				if (remainingCredit < 0) {
					alert('Remaining credit is less than 0');
				} else {
					document.getElementById('remainCId').value = parseFloat(
							remainingCredit).toFixed(2);
				}

			}
		}
		

	}
}
function totalAdvValue(val) {
	if (val != "") {
		document.getElementById('charityTransferId').value = '0.00';
	//	document.getElementById('amt1').value=document.getElementById('totalPayId').value;
		
		var totalAmt=document.getElementById('actualColAmtId').value;
		var billAmt=document.getElementById('totalPayId').value;
		document.getElementById('balToBeRId').value=totalAmt-billAmt;
	//	var amt = document.getElementById('amt1').value;
		var amt = document.getElementById('amtHidden1').value;
		var remainingAMt=document.getElementById('remainCId').value;
		var balReturn = document.getElementById('balToBeRId').value;
		var totalCredit = parseFloat(remainingAMt) + parseFloat(amt);
		var actualCollect = document.getElementById('actualColAmtId').value;
		var netBalance = document.getElementById('balToBePiadId').value;
		var balToBe = parseFloat(balReturn) - parseFloat(remainingAMt);
		document.getElementById('amt1').value=totalCredit;
		document.getElementById('balToBeRId').value=balToBe;
		
		if (isNaN(remainingAMt)) {
			alert('please enter correct value.');
		} else {
				if (remainingAMt < 0) {
					alert('Remaining credit is less than 0');
				} else {
					document.getElementById('remainCId').value = parseFloat(
							remainingAMt).toFixed(2);
				}

			}
		

	}
}
function totalAdvValueIp(val) {
	if (val != "") {
		document.getElementById('charityTransferId').value = '0.00';
	//	document.getElementById('amt1').value=document.getElementById('totalPayId').value;
		
		var totalAmt=document.getElementById('actualColAmtId').value;
		var billAmt=document.getElementById('payableAmtId').value;
		document.getElementById('balToBeRetrunId').value=totalAmt-billAmt;
	//	var amt = document.getElementById('amt1').value;
		var amt = document.getElementById('amtHidden1').value;
		var remainingAMt=document.getElementById('remCreditId').value;
		var balReturn = document.getElementById('balToBeRetrunId').value;
		var totalCredit = parseFloat(remainingAMt) + parseFloat(amt);
		var actualCollect = document.getElementById('actualColAmtId').value;
		var netBalance = document.getElementById('balToBePiadId').value;
		var balToBe = parseFloat(balReturn) - parseFloat(remainingAMt);
		document.getElementById('amt1').value=totalCredit;
		document.getElementById('balToBeRetrunId').value=balToBe;
		
		if (isNaN(remainingAMt)) {
			alert('please enter correct value.');
		} else {
				if (remainingAMt < 0) {
					alert('Remaining credit is less than 0');
				} else {
					document.getElementById('remCreditId').value = parseFloat(
							remainingAMt).toFixed(2);
				}

			}
		

	}
}


function totalAdvCreditIp(val) {
	if (val != "") {
		document.getElementById('charityTransferId').value = '0.00';
		var pasDue = document.getElementById('avAdvAmtId').value;
		var totalCredit = parseFloat(pasDue) + parseFloat(val);
		// document.getElementById('remainCId').value=parseFloat(totalCredit).toFixed(2);
		var actualCollect = document.getElementById('actualColAmtId').value;
		var netBalance = document.getElementById('balToBePiadId').value;
		var balToBe = parseFloat(actualCollect) - parseFloat(netBalance);
		if (isNaN(balToBe)) {
			alert('please enter correct value.');
		} else {
			if (balToBe < 0) {
				alert('Balance to be paid is less than 0.');
			} else {
				var remainingCredit = balToBe - parseFloat(val);
				if (remainingCredit < 0) {
					alert('Remaining credit is less than 0');
				} else {
					document.getElementById('remCreditId').value = parseFloat(
							remainingCredit).toFixed(2);
				}

			}
		}
		

	}
}

function onUpdateCharityCreditOp(val)
{
	if(val!="")
		{
		if(isNaN(val))
			{
			document.getElementById("remainCId").onblur();
			document.getElementById('charityTransferId').value = '0.00';
			alert('Please enter correct ammount.')
			}
		else
			{
			if(parseFloat(document.getElementById('charityTransferId').value)>parseFloat(document.getElementById('remainCId').value))
			{
				document.getElementById("remainCId").onblur();
				document.getElementById('charityTransferId').value = '0.00';
				alert('Charity Ammount is greater than Remaining Credit.')
			}
			else
				{
				document.getElementById('remainCId').value =parseFloat(document.getElementById('remainCId').value-parseFloat(document.getElementById('charityTransferId').value));
				}
			}		
		}
	else
		{
		document.getElementById("remainCId").onblur();
		document.getElementById('charityTransferId').value = '0.00';
		alert('value is not correct');
		}
}

function onUpdateCharityCreditIp(val)
{
	if(val!="")
		{
		if(isNaN(val))
			{
			document.getElementById("balToBeRetrunId").onblur();
			document.getElementById('charityTransferId').value = '0.00';
			alert('Please enter correct ammount.')
			}
		else
			{
			if(parseFloat(document.getElementById('charityTransferId').value)>parseFloat(document.getElementById('remCreditId').value))
			{
				document.getElementById("balToBeRetrunId").onblur();
				document.getElementById('charityTransferId').value = '0.00';
				alert('Charity Ammount is greater than Remaining Credit.')
			}
			else
				{
				document.getElementById('remCreditId').value =parseFloat(document.getElementById('remCreditId').value-parseFloat(document.getElementById('charityTransferId').value));
				}
			}		
		}
	else
		{
		document.getElementById("balToBeRetrunId").onblur();
		document.getElementById('charityTransferId').value = '0.00';
		alert('value is not correct');
		}
}
function adjustAmt(val){
	//document.getElementById('discountOnBillId').onblur();
	
	
if(val != ""){
		
		if(isNaN(val))
		{
			alert('Please enter correct value.');
			document.getElementById('adjusetCreditId').value='0.00';
			document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value;
			calculatePerDisOnBill(document.getElementById('discountOnBillId').value,'op');
		}
		else
			{
			if(parseFloat(val)==0)
				{
				
				}
			else if(parseFloat(document.getElementById('balanceAmount').value)<parseFloat(val))
				{
				alert('Entered value is greater than available balance');
				document.getElementById('adjusetCreditId').value='0.00';
				document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
				calculatePerDisOnBill(document.getElementById('discountOnBillId').value,'op');
				}
			else
				{
		var paybAmt = document.getElementById('payableAmtId').value;
		var advAmt = document.getElementById('balanceAmount').value;
		
		//alert('aa'+parseFloat(val)+' bb'+parseFloat(paybAmt));
		if(parseFloat(val)<=parseFloat(paybAmt)){
			var advAmt1 = parseFloat(advAmt)-parseFloat(val);
			document.getElementById('avAdvAmtId').value=advAmt1.toFixed(2);
		var balToBePiadAmt=parseFloat(paybAmt)-parseFloat(val);
		document.getElementById('balToBePiadId').value=balToBePiadAmt.toFixed(2);
		//document.getElementById('actualColAmtId').value=balToBePiadAmt.toFixed(2);
		//document.getElementById('totalPayId').value=balToBePiadAmt.toFixed(2);
		//document.getElementById('totalNetId').value=balToBePiadAmt.toFixed(2);
		//document.getElementById('totalNetId1').value=balToBePiadAmt.toFixed(2);	
		//document.getElementById('netamount1').value=balToBePiadAmt.toFixed(2);
		
		document.getElementById('amtHidden1').value=balToBePiadAmt.toFixed(2);
		//document.getElementById('amtHidden1').onblur();
		document.getElementById('amt1').value=balToBePiadAmt.toFixed(2);
		document.getElementById('amt1').onblur();
		}else{
			if(!isNaN(paybAmt))
			alert("Sorry your amount is not adjust!!!");
			document.getElementById('adjusetCreditId').value='0.00';
			document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
			calculatePerDisOnBill(document.getElementById('discountOnBillId').value,'op');
		}
			}
			}
	}
	else
		{
		document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
		document.getElementById('adjusetCreditId').value='0.00';
		calculatePerDisOnBill(document.getElementById('discountOnBillId').value,'op');
		}

//	if(val != ""){
//		var paybAmt = document.getElementById('payableAmtId').value;
//		if(parseFloat(val)<=parseFloat(paybAmt)){
//		alert(val);
//		var avAdvAmtId = document.getElementById('avAdvAmtId').value;
//		var avAdvAmtId1 = parseFloat(avAdvAmtId)-parseFloat(val);
//		document.getElementById('avAdvAmtId').value=avAdvAmtId1.toFixed(2);
//
//		var balToBePiadAmt=parseFloat(paybAmt)-parseFloat(val);
//		
//		alert("balToBePiadAmt"+balToBePiadAmt);
//		document.getElementById('balToBePiadId').value=balToBePiadAmt.toFixed(2);
//		document.getElementById('totalNetId').value=balToBePiadAmt.toFixed(2);
//		document.getElementById('amt1').value=balToBePiadAmt.toFixed(2);
//		document.getElementById('receivedAmtId').value=balToBePiadAmt.toFixed(2);
//		
//		}else{
//			alert("Sorry your amount is not adjust!!!");
//		}
//	}
}

function adjustPaywardBillAmt(val){
	if(val != ""){
		
		if(isNaN(val))
		{
			alert('Please enter correct value.');
			document.getElementById('adjusetCreditId').value='0.00';
			document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value;
			document.getElementById('balToBePiadId').value=document.getElementById('amtt').value;			
		}
		else
			{
			if(parseFloat(val)==0)
				{
				document.getElementById('adjusetCreditId').value='0.00';
				document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
				document.getElementById('balToBePiadId').value=document.getElementById('amtt').value;
				document.getElementById('amt1').onblur();
				document.getElementById('totalAmt').onblur();
				}else if(parseFloat(document.getElementById('balanceAmount').value)<parseFloat(val))
				{
				alert('Entered value is greater than available balance');
				document.getElementById('adjusetCreditId').value='0.00';
				document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
				document.getElementById('balToBePiadId').value=document.getElementById('amtt').value;			
				}
			else
				{
		var paybAmt = document.getElementById('amtt').value;
		var advAmt = document.getElementById('avAdvAmtId').value;
		var advAmt1 = parseFloat(advAmt)-parseFloat(val);
		if(parseFloat(val)<=parseFloat(paybAmt)){
			document.getElementById('avAdvAmtId').value=advAmt1.toFixed(2);
		var balToBePiadAmt=parseFloat(paybAmt)-parseFloat(val);
		document.getElementById('balToBePiadId').value=balToBePiadAmt.toFixed(2);
		document.getElementById('totalAmt').value=balToBePiadAmt.toFixed(2);
		
//		document.getElementById('totalPayId').value=balToBePiadAmt.toFixed(2);
//		document.getElementById('totalNetId').value=balToBePiadAmt.toFixed(2);
//		document.getElementById('totalNetId1').value=balToBePiadAmt.toFixed(2);	
		//document.getElementById('netamount1').value=balToBePiadAmt.toFixed(2);
		document.getElementById('amt1').value=balToBePiadAmt.toFixed(2);
		document.getElementById('amt1').onblur();
		document.getElementById('totalAmt').onblur();
		
		}else{
			alert("Sorry your amount is not adjust!!!");
			document.getElementById('adjusetCreditId').value='0.00';
			document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
			document.getElementById('balToBePiadId').value=document.getElementById('amtt').value;	
		}
			}
			}
	}
	else
		{
		document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
		document.getElementById('adjusetCreditId').value='0.00';
		document.getElementById('balToBePiadId').value=document.getElementById('amtt').value;	
		}
}

function adjustOPBillAmt(val){
	if(val != ""){
		
		if(isNaN(val))
		{
			alert('Please enter correct value.');
			document.getElementById('adjusetCreditId').value='0.00';
			document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value;
			calculateDiscAmtForBill(tdocument.getElementById('discountOnBillId').value,'op');
		}
		else
			{
			if(parseFloat(document.getElementById('balanceAmount').value)<parseFloat(val))
				{
				alert('Entered value is greater than available balance');
				document.getElementById('adjusetCreditId').value='0.00';
				document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
				calculateDiscAmtForBill(document.getElementById('discountOnBillId').value,'op');
				}
			else
				{
		var paybAmt = document.getElementById('payableAmtId').value;
		var advAmt = document.getElementById('avAdvAmtId').value;
		var advAmt1 = parseFloat(advAmt)-parseFloat(val);
		document.getElementById('avAdvAmtId').value=advAmt1.toFixed(2);
		//alert('aa'+parseFloat(val)+' bb'+parseFloat(paybAmt));
		if(parseFloat(val)<=parseFloat(paybAmt)){
		var balToBePiadAmt=parseFloat(paybAmt)-parseFloat(val);
		document.getElementById('balToBePiadId').value=balToBePiadAmt.toFixed(2);
		document.getElementById('actualColAmtId').value=balToBePiadAmt.toFixed(2);
		document.getElementById('totalPayId').value=balToBePiadAmt.toFixed(2);
		document.getElementById('totalNetId').value=balToBePiadAmt.toFixed(2);
		document.getElementById('totalNetId1').value=balToBePiadAmt.toFixed(2);	
		//document.getElementById('netamount1').value=balToBePiadAmt.toFixed(2);
		document.getElementById('amt1').value=balToBePiadAmt.toFixed(2);
		}else{
			if(!isNaN(paybAmt))
			alert("Sorry your amount is not adjust!!!");
			document.getElementById('adjusetCreditId').value='0.00';
			document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
			calculateDiscAmtForBill(document.getElementById('discountOnBillId').value,'op');
		}
			}
			}
	}
	else
		{
		document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
		document.getElementById('adjusetCreditId').value='0.00';
		calculateDiscAmtForBill(document.getElementById('discountOnBillId').value,'op');
		}
}
function amountToBeReturn(){
	
	var actualCollect=document.getElementById('actualColAmtId').value;
 	var netBalance=document.getElementById('balToBePiadId').value;
 	var balToBe = parseFloat(actualCollect)-parseFloat(netBalance);
// 	if(balToBe>0)
// 		{
 	 	document.getElementById('balToBeRetrunId').value=balToBe;
 	 	document.getElementById('remCreditId').value='0.00';
 	 	document.getElementById('charityTransferId').value='0.00';
 	 	
	
		/*var abc = document.getElementById('balToBePiadId').value;
		var xyz = document.getElementById('receivedAmtId').value;
		if(parseFloat(xyz)>=parseFloat(abc)){
		var val = parseFloat(xyz)-parseFloat(abc);
		document.getElementById('balToBeRetrunId').value=val.toFixed(2);
		}
		else
			{
			var val = parseFloat(xyz)-parseFloat(abc);
			document.getElementById('balToBeRetrunId').value=val.toFixed(2);
			}*/
	
}
function calPaywardAmt(val){
	if(val !=""){

	var roomCharge=document.getElementById('roomChargeId').value;
	var amt11=parseFloat(roomCharge)*parseFloat(val);

	document.getElementById('amtt').value=amt11.toFixed(2);
	document.getElementById('amt1').value=amt11.toFixed(2);
	adjustPaywardBillAmt(document.getElementById('adjusetCreditId').value);
	//document.getElementById('totalAmt').value=amt1.toFixed(2);
	}
}

function calPaywardAmtAllotment(){
	var roomCharge=document.getElementById('roomChargeId').value;
	var bookingdays=document.getElementById('numOfDaysId').value;
	var extraDays=document.getElementById('extradays').value;
	if(extraDays && !isNaN(extraDays))
		{
		var amt11=(parseFloat(roomCharge)*parseFloat(bookingdays))+(parseFloat(roomCharge)*parseFloat(extraDays));
		document.getElementById('newAmmount').value=(parseFloat(roomCharge)*parseFloat(extraDays)).toFixed(2);
		if(document.getElementById('bookingPaid').value!='' && !isNaN(document.getElementById('bookingPaid').value))
			{
			var totalAmmount=(amt11-parseFloat(document.getElementById('bookingPaid').value)).toFixed(2);
			if(totalAmmount<=0)
				{
				document.getElementById('amt1').value='';
				document.getElementById('totalAmt').value='0.00';
				document.getElementById('balToBePaid').value='0.00';
				}
			else
				{
				document.getElementById('amt1').value=(amt11-parseFloat(document.getElementById('bookingPaid').value)).toFixed(2);
				}
			}
		else
			{
			document.getElementById('amt1').value=amt11.toFixed(2);
			}
		}
	else
		{
		var amt11=(parseFloat(roomCharge)*parseFloat(bookingdays));
		document.getElementById('newAmmount').value='0.00';
		document.getElementById('amt1').value=amt11.toFixed(2);
		if(document.getElementById('bookingPaid').value!='' && !isNaN(document.getElementById('bookingPaid').value))
		{
		var totalAmmount=(amt11-parseFloat(document.getElementById('bookingPaid').value)).toFixed(2);
		if(totalAmmount<=0)
			{
			document.getElementById('amt1').value='';
			document.getElementById('totalAmt').value='0.00';
			document.getElementById('balToBePaid').value='0.00';
			}
		else
			{
			document.getElementById('amt1').value=(amt11-parseFloat(document.getElementById('bookingPaid').value)).toFixed(2);
			}
		}
	else
		{
		document.getElementById('amt1').value=amt11.toFixed(2);
		}
		}
	
	/*if(document.getElementById('advAdjCheckId').checked)
		{
		var val=document.getElementById('adjusetCreditId').value;
		if(val != ""){
			
			if(isNaN(val))
			{
				alert('Please enter correct value.');
				document.getElementById('adjusetCreditId').value='0.00';
				document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value;
			}
			else
				{
				var amt11=(parseFloat(roomCharge)*parseFloat(bookingdays))+(parseFloat(roomCharge)*parseFloat(extraDays));
				var totalAmmount=(amt11-parseFloat(document.getElementById('bookingPaid').value)).toFixed(2);
				if(parseFloat(document.getElementById('balanceAmount').value)<parseFloat(val))
					{
					alert('Entered value is greater than available balance');
					document.getElementById('adjusetCreditId').value='0.00';
					document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
					}
				else if(parseFloat(totalAmmount)<parseFloat(val))
					{
					alert('Entered value is greater than Payable Amount');
					document.getElementById('adjusetCreditId').value='0.00';
					document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
					}
				else
					{
							document.getElementById('amt1').value=parseFloat(parseFloat(totalAmmount)-parseFloat(val)).toFixed(2);
							document.getElementById('balToBePiadId').value=parseFloat(parseFloat(totalAmmount)-parseFloat(val)).toFixed(2);
							
							document.getElementById('totalAmt').value='0.00';
							document.getElementById('balToBePaid').value='0.00';
							
							document.getElementById('amt1').value=parseFloat(parseFloat(totalAmmount)-parseFloat(val)).toFixed(2);
						}
					else
						{
						document.getElementById('amt1').value=amt11.toFixed(2);
						}
					
					
			var paybAmt = document.getElementById('payableAmtId').value;
			var advAmt = document.getElementById('avAdvAmtId').value;
			var advAmt1 = parseFloat(advAmt)-parseFloat(val);
			document.getElementById('avAdvAmtId').value=advAmt1.toFixed(2);
			//alert('aa'+parseFloat(val)+' bb'+parseFloat(paybAmt));
			if(parseFloat(val)<=parseFloat(paybAmt)){
			var balToBePiadAmt=parseFloat(paybAmt)-parseFloat(val);
			document.getElementById('balToBePiadId').value=balToBePiadAmt.toFixed(2);
			document.getElementById('actualColAmtId').value=balToBePiadAmt.toFixed(2);
			document.getElementById('totalPayId').value=balToBePiadAmt.toFixed(2);
			document.getElementById('totalNetId').value=balToBePiadAmt.toFixed(2);
			document.getElementById('totalNetId1').value=balToBePiadAmt.toFixed(2);	
			//document.getElementById('netamount1').value=balToBePiadAmt.toFixed(2);
			document.getElementById('amt1').value=balToBePiadAmt.toFixed(2);
			}else{
				if(!isNaN(paybAmt))
				alert("Sorry your amount is not adjust!!!");
				document.getElementById('adjusetCreditId').value='0.00';
				document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
				calculateDiscAmtForBill(tdocument.getElementById('discountOnBillId').value,'op');
			}
				}
				}
		}
		else
			{
			document.getElementById('avAdvAmtId').value=document.getElementById('balanceAmount').value
			document.getElementById('adjusetCreditId').value='0.00';
			
			}

		}*/
	
	//document.getElementById('totalAmt').value=amt1.toFixed(2);
}
function calculateAdAmt(val){
	if(isNaN(val))
		{
		alert('Amount is not correct');
		return;
		}
	var advAmt=document.getElementById('amtt').value;
	var balToBePiadId = document.getElementById('balToBePiadId').value;
	if(isNaN(advAmt))
	{
	alert('Total Advance Amount Paid is not correct');
	return;
	}

		
		if(parseFloat(val) >= parseFloat(advAmt)){
			//alert("val=111111=="+val);
			//alert("advAmt==111111="+advAmt);
		var amt=parseFloat(advAmt)-parseFloat(val);
		//alert("amt=111111="+amt);
		document.getElementById('balToBePaid').value=amt.toFixed(2);
		}else{
			//alert("val==22="+val);
			//alert("advAmt=2=="+advAmt);
			//alert("balToBePiadId=="+balToBePiadId);
			var amt=parseFloat(balToBePiadId)-parseFloat(val);
			//alert("amt=22=="+amt);
			document.getElementById('balToBePaid').value=amt.toFixed(2);
			//alert("Sorry!! Amount is less ");
		}
	
}

function calculateAdAmtAllotment(val)
{
	if(isNaN(val))
	{
	alert('Amount is not correct');
	}
	
	
	var roomCharge=document.getElementById('roomChargeId').value;
	var bookingdays=document.getElementById('numOfDaysId').value;
	var extraDays=document.getElementById('extradays').value;
	var amt11=0.00;
	if(extraDays && !isNaN(extraDays))
		{
		amt11=(parseFloat(roomCharge)*parseFloat(bookingdays))+(parseFloat(roomCharge)*parseFloat(extraDays));
		if(document.getElementById('bookingPaid').value!='' && !isNaN(document.getElementById('bookingPaid').value))
			{
			 amt11=(amt11-parseFloat(document.getElementById('bookingPaid').value)).toFixed(2);
			
			}
		}
	else
		{
		 amt11=(parseFloat(roomCharge)*parseFloat(bookingdays));
		if(document.getElementById('bookingPaid').value!='' && !isNaN(document.getElementById('bookingPaid').value))
		{
		amt11=(amt11-parseFloat(document.getElementById('bookingPaid').value)).toFixed(2);
		}
		}
	var amt=parseFloat(amt11)-parseFloat(val);
	document.getElementById('balToBePaid').value=amt.toFixed(2);
	
	}
//-----------------------------------End of Billing------------------------------------

function validateFRW(){
	var frwy = document.getElementById('frwIssuedIdY');
	var frwn = document.getElementById('frwIssuedIdN');
	if(frwy && frwn){
		if(!frwy.checked && !frwn.checked){
			errorMsg += "Please select FRW Issued.\n";
		}else{
			return true;

		}
	}else{
		return true;
	}

}
//=======================================================================================
//------------------------------------------- methods by ABHA--------------------------
//========================================================================================
function checkExpiryDate(){

 var exp = document.getElementById('f3').value;
 var manu = document.getElementById('f2').value;


 expiryDate = new Date(exp.substring(6),(exp.substring(3,5) - 1) ,exp.substring(0,2));
 manufacturingDate = new Date(manu.substring(6),(manu.substring(3,5) - 1) ,manu.substring(0,2));

  currentDate = new Date();
 var month = currentDate.getMonth() + 1
 var day = currentDate.getDate()
 var year = currentDate.getFullYear()
 var seperator = "/"
 currentDate = new Date(month + seperator + day + seperator + year);
 if(expiryDate != ""){
 if(expiryDate < currentDate )
  {
  errorMsg +="Expiry Date Should  be greater than current date.\n"
  alert("Expiry Date Should  be greater than current date")

  return false;
  }
  	}

 if(manufacturingDate != ""){
 if(manufacturingDate < currentDate )
  {
  errorMsg +="Manufacturing Date Should  be greater than current date.\n"
  alert("Manufacturing Date Should  be greater than current date")

  return false;
  }
  	}
  return true;

}

// for non expendable crv
function checkDateForGrid(){
var exp = document.getElementById('f7').value;
var installationDate = document.getElementById('f4').value;
var amcStartDate1 = document.getElementById('f5').value;


warrantyDate = new Date(exp.substring(6),(exp.substring(3,5) - 1) ,exp.substring(0,2));
installationDate = new Date(installationDate.substring(6),(installationDate.substring(3,5) - 1) ,installationDate.substring(0,2));
amcStartDate1 = new Date(amcStartDate1.substring(6),(amcStartDate1.substring(3,5) - 1) ,amcStartDate1.substring(0,2));

 currentDate = new Date();
 var month = currentDate.getMonth() + 1
 var day = currentDate.getDate()
 var year = currentDate.getFullYear()
 var seperator = "/"
 currentDate = new Date(month + seperator + day + seperator + year);
if(warrantyDate!= "")
 {
 if(warrantyDate < currentDate)
  {

errorMsg +="Warranty Date Should  be greater than current date.\n"
alert(errorMsg)
  return false;
 }
	 }

if(installationDate != "")
{
 if(installationDate > currentDate)
   {

errorMsg +="Installation Date Should  be less than current date.\n"
alert(errorMsg)
   return false;
 }
 	}


if(amcStartDate1 != "")
{
 if(amcStartDate1 < currentDate ||  amcStartDate1 == currentDate)
   {

errorMsg +="AMC Start Date Should  be Future Date.\n"
alert(errorMsg)
   return false;
 }
 	}

 return true;

}


function calculateEndDate(){

   var amcStartDate1 = document.getElementById('f5').value;
   var amcStartYear = amcStartDate1.substring(6);
   var amcStartMonth = amcStartDate1.substring(3,5) -1
   var amcStartDate = amcStartDate1.substring(0,2);

   var amcEndYear = eval(amcStartYear)+1;
var amcEndDate1 =amcStartDate +"/"+amcStartMonth+"/"+amcEndYear;

 document.getElementById('f6').value = amcEndDate1 ;
}

//==================================================================================
//=========================METHODS END BY ABHA====================================
//================================================================================

function fillPatientName(obj){

	var objValue = obj.value;
	var relation = document.getElementById('relationId').value;
	if(relation == '8'){
		if(obj.id == 'sFNameId'){
			document.getElementById('pFirstNameId').value = objValue;
			}
		if(obj.id == 'sMNameId')
			document.getElementById('pMiddleNameId').value = objValue;
		if(obj.id == 'sLNameId')
			document.getElementById('pLastNameId').value = objValue;
	}

	if(relation != '8'){
		var sfName = "";
		var smName ="";
		var slName = "";
		if(document.getElementById('sFNameId').value != ""){
			sfName=document.getElementById('sFNameId').value;
		}
		if(document.getElementById('sMNameId').value != ""){
			smName=document.getElementById('sMNameId').value;
		}
		if(document.getElementById('sLNameId').value != ""){
			slName=document.getElementById('sLNameId').value;
		}
		if(sfName != "" || smName != "" || slName != ""){
			document.getElementById('nokNameId').value = sfName+" "+smName+" "+slName;
			}
	}
}


function showBudgetReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/hospital?method=generateReportForHospitalRelatedMasters";
  obj.submit();
}
function checkWardForTransfer(obj){
	var fromWard = document.getElementById('fromWardId').value;
	/*
	if(fromWard == obj){
		alert("From Ward and To Ward can not be same.")
		document.getElementById('wardId').value = "0"
		return false;
	}
	*/
	return true;
}


function showPatientDetails(formName,hinId){
	obj = eval('document.'+formName);
	var url;
	if(formName == "patientVisitSearch"){
		url = "/hms/hms/registration?method=showVisitDetails&hinId="+hinId;
	}else if(formName == "patientAdmissionSearch"){
		url = "/hms/hms/adt?method=searchPatientDetailsForAdmission&hinId="+hinId;
	}else if(formName == "patientTransferSearch"){
		url = "/hms/hms/adt?method=searchPatientDetailsForTransfer&inpatientId="+hinId;
	}else if(formName == "patientDischargeSearch"){
		url = "/hms/hms/adt?method=searchPatientDetailsForDischarge&inpatientId="+hinId;
	}
	obj.action = url;
	obj.submit();
}


function checkRelationType(obj){

	displayPatientName(obj);
	if((obj == '8')  ){

		document.getElementById('sCardIdY').checked = false;
		document.getElementById('sCardIdN').checked = false;
		document.getElementById('cardValidityId').value = "";
		document.getElementById('depIssueDateId').value = "";
		document.getElementById('sCardIdY').disabled = true;
		document.getElementById('sCardIdN').disabled = true;
		document.getElementById('cardValidityId').disabled = true;
		document.getElementById('depIssueDateId').disabled = true;
		document.getElementById('hospitalStaffId').disabled = false;

	}else{
		document.getElementById('sCardIdY').disabled = false;
		document.getElementById('sCardIdN').disabled = false;
		document.getElementById('cardValidityId').disabled = false;
		document.getElementById('depIssueDateId').disabled = false;
		document.getElementById('hospitalStaffId').disabled = true;
		var sfName = "";
		var smName ="";
		var slName = "";
		if(document.getElementById('sFNameId').value != ""){
			sfName=document.getElementById('sFNameId').value;
		}
		if(document.getElementById('sMNameId').value != ""){
			smName=document.getElementById('sMNameId').value;
		}
		if(document.getElementById('sLNameId').value != ""){
			slName=document.getElementById('sLNameId').value;
		}
		if(sfName != "" || smName != "" || slName != ""){
			document.getElementById('nokNameId').value = sfName+" "+smName+" "+slName;
			}
	}

}

function displayPatientName(obj){
	if(obj == '8'){
		if(document.getElementById('sFNameId').value != ''){
			document.getElementById('pFirstNameId').value = document.getElementById('sFNameId').value;
		}
		if(document.getElementById('sMNameId').value != ''){
			document.getElementById('pMiddleNameId').value = document.getElementById('sMNameId').value;
		}
		if(document.getElementById('sLNameId').value != ''){
			document.getElementById('pLastNameId').value = document.getElementById('sLNameId').value;
		}
	}else{
		document.getElementById('pFirstNameId').value = "";
		document.getElementById('pMiddleNameId').value = "";
		document.getElementById('pLastNameId').value = "";
	}
}

function validateICardForMandatory(){
	rel = document.getElementById('relationId').value;
	if(rel != '0' && rel != '8'){
		for(var i = 0; i < document.getElementsByName('iCardVerified').length; i++){
	 		if(document.getElementsByName('iCardVerified')[i].checked == true)
	        {
				return true;
	  		}
	  	}
	  		errorMsg += "Please Select I-Card Verif...\n"
			return false;
	 	}

	return true;
}

function check(obj){
	if(obj.checked){
		document.getElementById('urine').focus();

	}
}

function checkPulseValidation(obj,inc){
	var pulseObj = document.getElementById('incPulseTemp'+inc);

	if(obj != "")
	{
		if(!validateNumeric(obj))
		{
			alert("Pulse should be numeric value.");
			pulseObj.value="";
			pulseObj.focus();
			return false;
		}
		else
		{
			var pulse = parseInt(obj);
			if (pulse < 60 || pulse > 200)
			{}
		}
	}
	return true;
	}
	function checkPulseIntakeValidation(obj){}


	function checkRespirationValidation(obj,inc){
	var respObj = document.getElementById('incRespTemp'+inc);

	if(obj != "")
	{
		if(!validateNumeric(obj))
		{
			alert("Respiration should be numeric value.");
				respObj.value="";
				respObj.focus();
			return false;
		}
		else{
			var resp = parseInt(obj);
			if (resp < 12 || resp > 80)
			{}
		}
	}
	return true;
	}
	function checkRespirationIntakeValidation(obj){
	var respObj = document.getElementById('respiration');

	 var table=document.getElementById("intakeOutputId");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("respiration").value!=""&& document.getElementById("respiration").value==obj)
				        	 {

				        	  var obj1=document.getElementById("respiration");

							         if(!validateNumeric(obj1.value))
									{
									alert("Respiration should be numeric value.");
									obj1.value="";
									obj1.focus();
										return false;
									}
									else
									{}

					         }
					          for(var i=1; i<=tblRows.length;i++){
				         var respObj=document.getElementById("respiration"+i);

							         if(respObj != null&& obj!=""&&respObj.value==obj)
							{
								if(!validateNumeric(obj))
								{
									alert("Respiration should be numeric value.");
									respObj.value="";
									respObj.focus();
									return false;
								}
								else
								{}
							}
							return true;
							}







	}

function checkBpValidation(obj,inc){
	var bpObj = document.getElementById('incBpTemp'+inc);

	if(obj != ""){
	var bp = parseInt(obj);
			if (bp < 60 || bp > 240)
			{}
	}
	return true;
	}
function checkBpIntakeValidation(obj){


	var bpObj = document.getElementById('bp');

	 var table=document.getElementById("intakeOutputId");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("bp").value!=""&& document.getElementById("bp").value==obj)
				        	 {

				        	  var obj1=document.getElementById("bp");

							         if(!validateNumeric(obj1.value))
									{

									}
									else
									{}

					         }
					          for(var i=1; i<=tblRows.length;i++){
				         var bpObj=document.getElementById("bp"+i);

							         if(bpObj != null&& obj!=""&& bpObj.value==obj)
							{
								if(!validateNumeric(obj))
								{

								}
								else
								{}
							}
							return true;
							}




	}
function validateBpWithSlash(strValue){
	if(strValue != ""){
	var objRegExp = /^(\d{1,}[\/]\d*)$/
	obj =  objRegExp.test(strValue);
	if(!obj){
		alert("Slash(/) should be there.");
	}
}
}

function checkFhrValidation(obj,inc){
var fhrObj = document.getElementById('incFhrTemp'+inc);
	if(obj != ""){
		if(!validateNumeric(obj)){
			alert("Fhr should be numeric value.");
			fhrObj.value="";
			fhrObj.focus();
			return false;
		}
		}
		return true;
		}
function checkIntakeValidation(obj){
var intakeObj = document.getElementById('intake');



	var table=document.getElementById("intakeOutput1");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("intake").value!=""&& document.getElementById("intake").value==obj)
				        	 {

				        	  var obj1=document.getElementById("intake");

							         if(!validateNumeric(obj1.value))
									{
									alert("intake should be numeric value.");
									obj1.value="";
									obj1.focus();
										return false;
									}


					         }
				         for(var i=1; i<=tblRows.length;i++){
				         var intakeObj=document.getElementById("intake"+i);

							         if(intakeObj != null&& obj!=""&&intakeObj.value==obj)
							{
								if(!validateNumeric(obj))
								{
									alert("Pulse should be numeric value.");
									intakeObj.value="";
									intakeObj.focus();
									return false;
								}

							}
							return true;
							}


	}

function checkOutputValidation(obj){
var outputObj = document.getElementById('output');

	if(obj != "")
	{
		if(!validateNumeric(obj))
		{
			alert("Output should be numeric value.");
				outputObj.value="";
				outputObj.focus();
			return false;
		}

	}
	return true;
	}

function checkOralValidation(obj){
var oralObj = document.getElementById('oral');

	if(obj != "")
	{
		if(!validateNumeric(obj))
		{
			alert("Oral should be numeric value.");
				oralObj.value="";
				oralObj.focus();
			return false;
		}

	}
	return true;
	}

function checkIvValidation(obj){
var ivObj = document.getElementById('iv');



	var ivObj = document.getElementById('iv');



	var table=document.getElementById("intakeOutput1");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("iv").value!=""&& document.getElementById("iv").value==obj)
				        	 {

				        	  var obj1=document.getElementById("iv");

							         if(!validateNumeric(obj1.value))
									{
									alert("IV should be numeric value.");
									obj1.value="";
									obj1.focus();
										return false;
									}


					         }
				         for(var i=1; i<=tblRows.length;i++){
				         var ivObj=document.getElementById("iv"+i);

							         if(ivObj != null&& obj!=""&&ivObj.value==obj)
							{
								if(!validateNumeric(obj))
								{
									alert("IV should be numeric value.");
									ivObj.value="";
									ivObj.focus();
									return false;
								}

							}
							return true;
							}



	}

function checkUrineValidation(obj){
var urineObj = document.getElementById('urine');




	var table=document.getElementById("intakeOutput2");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("urine").value!=""&& document.getElementById("urine").value==obj)
				        	 {

				        	  var obj1=document.getElementById("urine");

							         if(!validateNumeric(obj1.value))
									{
									alert("urine should be numeric value.");
									obj1.value="";
									obj1.focus();
										return false;
									}


					         }
				         for(var i=1; i<=tblRows.length;i++){
				         var urineObj=document.getElementById("urine"+i);

							         if(urineObj != null&& obj!=""&&urineObj.value==obj)
							{
								if(!validateNumeric(obj))
								{
									alert("urine should be numeric value.");
									urineObj.value="";
									urineObj.focus();
									return false;
								}

							}
							return true;
							}


	}

function checkStoolValidation(obj){
var stoolObj = document.getElementById('stool');



	var table=document.getElementById("intakeOutput2");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("stool").value!=""&& document.getElementById("stool").value==obj)
				        	 {

				        	  var obj1=document.getElementById("stool");

							         if(!validateNumeric(obj1.value))
									{
									alert("stool should be numeric value.");
									obj1.value="";
									obj1.focus();
										return false;
									}


					         }
				         for(var i=1; i<=tblRows.length;i++){
				         var stoolObj=document.getElementById("stool"+i);

							         if(stoolObj != null&& obj!=""&&stoolObj.value==obj)
							{
								if(!validateNumeric(obj))
								{
									alert("stool should be numeric value.");
									stoolObj.value="";
									stoolObj.focus();
									return false;
								}

							}
							return true;
							}



	}
	function checkVomValidation(obj){
var vomObj = document.getElementById('vom');




	var table=document.getElementById("intakeOutput2");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("vom").value!=""&& document.getElementById("vom").value==obj)
				        	 {

				        	  var obj1=document.getElementById("vom");

							         if(!validateNumeric(obj1.value))
									{
									alert("vom should be numeric value.");
									obj1.value="";
									obj1.focus();
										return false;
									}


					         }
				         for(var i=1; i<=tblRows.length;i++){
				         var vomObj=document.getElementById("vom"+i);

							         if(vomObj != null&& obj!=""&&vomObj.value==obj)
							{
								if(!validateNumeric(obj))
								{
									alert("vom should be numeric value.");
									vomObj.value="";
									vomObj.focus();
									return false;
								}

							}
							return true;
							}

	}
function checkAspValidation(obj){
var aspObj = document.getElementById('asp');



	var table=document.getElementById("intakeOutput2");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("asp").value!=""&& document.getElementById("asp").value==obj)
				        	 {

				        	  var obj1=document.getElementById("asp");

							         if(!validateNumeric(obj1.value))
									{
									alert("asp should be numeric value.");
									obj1.value="";
									obj1.focus();
										return false;
									}


					         }
				         for(var i=1; i<=tblRows.length;i++){
				         var aspObj=document.getElementById("asp"+i);

							         if(aspObj != null&& obj!=""&&aspObj.value==obj)
							{
								if(!validateNumeric(obj))
								{
									alert("asp should be numeric value.");
									aspObj.value="";
									aspObj.focus();
									return false;
								}

							}
							return true;
							}
	}
function checkDrainValidation(obj){
var drainObj = document.getElementById('drain');


	var table=document.getElementById("intakeOutput3");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("drain").value!=""&& document.getElementById("drain").value==obj)
				        	 {

				        	  var obj1=document.getElementById("drain");

							         if(!validateNumeric(obj1.value))
									{
									alert("drain should be numeric value.");
									obj1.value="";
									obj1.focus();
										return false;
									}


					         }

				         for(var i=1; i<=tblRows.length;i++){

				         var drainObj=document.getElementById("drain"+i);

							         if(drainObj != null&& obj!=""&& drainObj.value==obj)
							{
								if(!validateNumeric(obj))
								{
									alert("drain should be numeric value.");
									drainObj.value="";
									drainObj.focus();
									return false;
								}

							}
							return true;
							}


	}

function checkGirthValidation(obj){
var girthObj = document.getElementById('girth');




		var table=document.getElementById("intakeOutput3");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("girth").value!=""&& document.getElementById("girth").value==obj)
				        	 {

				        	  var obj1=document.getElementById("girth");

							         if(!validateNumeric(obj1.value))
									{
									alert("girth should be numeric value.");
									obj1.value="";
									obj1.focus();
										return false;
									}


					         }
				         for(var i=1; i<=tblRows.length;i++){
				         var girthObj=document.getElementById("girth"+i);

							         if(girthObj != null&& obj!=""&&girthObj.value==obj)
							{
								if(!validateNumeric(obj))
								{
									alert("girth should be numeric value.");
									girthObj.value="";
									girthObj.focus();
									return false;
								}

							}
							return true;
							}

	}

function checkInsulinValidation(obj){
var insulinObj = document.getElementById('insulin');


	var table=document.getElementById("intakeOutput3");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("insulin").value!=""&& document.getElementById("insulin").value==obj)
				        	 {

				        	  var obj1=document.getElementById("insulin");

							         if(!validateNumeric(obj1.value))
									{
									alert("insulin should be numeric value.");
									obj1.value="";
									obj1.focus();
										return false;
									}


					         }
				         for(var i=1; i<=tblRows.length;i++){
				         var insulinObj=document.getElementById("insulin"+i);

							         if(insulinObj != null&& obj!=""&&insulinObj.value==obj)
							{
								if(!validateNumeric(obj))
								{
									alert("insulin should be numeric value.");
									insulinObj.value="";
									insulinObj.focus();
									return false;
								}

							}
							return true;
							}

	}
function checkBloodValidation(obj){
var bloodObj = document.getElementById('bloodsugar');




	var table=document.getElementById("intakeOutput3");
	         var tblRows  = table.getElementsByTagName("tr");

	          if(document.getElementById("bloodsugar").value!=""&& document.getElementById("bloodsugar").value==obj)
				        	 {

				        	  var obj1=document.getElementById("bloodsugar");

							         if(!validateNumeric(obj1.value))
									{
									alert("bloodsugar should be numeric value.");
									obj1.value="";
									obj1.focus();
										return false;
									}


					         }
				         for(var i=1; i<=tblRows.length;i++){
				         var bloodsugarObj=document.getElementById("bloodsugar"+i);

							         if(bloodsugarObj != null&& obj!=""&&bloodsugarObj.value==obj)
							{
								if(!validateNumeric(obj))
								{
									alert("bloodsugar should be numeric value.");
									bloodsugarObj.value="";
									bloodsugarObj.focus();
									return false;
								}

							}
							return true;
							}

	}

var varDuration;
var examArray = new Array();
function addAnnualExamDuration()
{
				duration=varDuration;
				ameDate=document.getElementById('inputDate').value;
				var newAmeDate = new Date(ameDate.substring(6),(ameDate.substring(3,5) - 1) ,ameDate.substring(0,2))
				var nextReviewDate=new Date(newAmeDate.getTime()+varDuration*24*60*60*1000);
				document.getElementById("NextReviewDateId").value=nextReviewDate.getDate()+"/"+eval(nextReviewDate.getMonth()+1)+"/"+nextReviewDate.getFullYear();
			}

				function getDuration()
				{
					for(i=0;i<examArray.length;i++)
					{
						if(examArray[i][0]==document.getElementById("outputToId").value)
						{
							varDuration=examArray[i][2];
						}
					}
				}

function checkCondition(){
	var condition = document.getElementById('conditionId').value;
	if(condition == "Dead"){
		var agree = confirm("Patient condition is dead.You want to admit ?");
		if (agree)
			return true ;
		else
			return false
		}
	return true;
}

//====================Function made by Vivek=========================
function checkForFirstRow(){
errorMsg="";
if(document.getElementById("serviceNoId").value ==""){
errorMsg += "Please fill Service No.\n"
}
if(document.getElementById("serviceTypeId").value==0){
errorMsg += "Please Select Service Type No.\n"
}
if(document.getElementById("serviceStatusId").value==0){
errorMsg += "Please Select Service Status .\n"
}

if(errorMsg !=""){
alert(errorMsg)
obj=eval(document.getElementById('relationId'))
		obj.selectedIndex=0
return false;
}else{
	return true;
}

}

//---------------Added by Vivek ----------------------
function checkForCancel()
{
		if(confirm("Are You sure, You want Cancel admission ?"))
			return true;
		else
			return false;
}
//-------------------------- Added by Priyanka ---------------
//This function adds mask to any field.
function mask(str,textbox,loc,delim){
	/*alert(textbox);
	alert(textbox.event);*/
	if(textbox.onkeyup.arguments[0].keyCode!=8){
		var locs = loc.split(',');
		for (var i = 0; i <= locs.length; i++){
			for (var k = 0; k <= str.length; k++){
				if (k == locs[i]){
					if (str.indexOf(":") == -1 && str.substring(k, k+1) != delim){
						str = str.substring(0,k) + delim + str.substring(k,str.length)
					}

				}

		}

		}
		textbox.value = str
	}
		
}

function maskForSession(str,textbox,loc,delim){
	var locs = loc.split(',');
	for (var i = 0; i <= locs.length; i++){
		for (var k = 0; k <= str.length; k++){
			if (k == locs[i]){
				if (str.substring(k, k+1) != delim){
					str = str.substring(0,k) + delim + str.substring(k,str.length)
				}

			}

	}

	}
	textbox.value = str
}
function IsValidTimeForSession(timeStr,fieldId) {
	// Checks if time is in HH:MM format.
	// The seconds are optional.

	var obj = document.getElementById(fieldId)
	var timePat = /^(\d{1,2}):(\d{2})?(\s?(AM|am|PM|pm))?$/;

	var matchArray = timeStr.match(timePat);
	if (matchArray == null) {
		alert("Time should be in HH:MM format.");
		obj.value = "";
		obj.focus();
		return false;
	}
	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];
	ampm = matchArray[6];

	if (second=="") { second = null; }
	if (ampm=="") { ampm = null }

	if (hour < 0  || hour > 12) {
		alert("Hour must be between 0 and 12.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (minute<0 || minute > 59) {
		alert ("Minute must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	} 
	return false;
}


function resetClicked(formName,inc){
	var a = eval('document.'+formName+'.sampleNo')
	a.style.display = "none";

	alert(eval('document.'+formName+'.sNo'))
	var b = eval('document.'+formName+'.sNo')
	b.style.display = "block";
	//for(var i=1;i<inc;i++){
	//alert(document.getElementById('sampleNoId'+inc))
	//	document.getElementById('sampleNoId'+inc).value= "";
	//}

}
//--------------------------- Function for Opd Ophthalmology------------------------

function checkBlankForOphthalmology(formName){
	inputs = eval('document.'+formName+'.elements');
	errors = "";
	flag = "blank"

	for(i=0;i<inputs.length;i++){
		textValue = trimAll(inputs[i].value);

		if(inputs[i].type == 'text'
					|| inputs[i].type == 'select-one'
					|| inputs[i].type == 'select-multiple'
					|| inputs[i].type == 'textarea'
					|| inputs[i].type == 'password'){

			if(textValue != "" && textValue != '0'){
				flag = "filled";
				return true;

			}
		}
	}
	if(flag == "blank"){
		alert("Please Fill at least on field.");
		return false;
	}

}

//*********************************** Function by Vishal for Accounting==========================

var faMasSubLedArray = new Array();
function populateMasSubLedForAccount(val,formName,count){
	obj = document.getElementById('faMasSubLed'+count);
	obj.length = 1;
	for(i=0;i<faMasSubLedArray.length;i++){

		if(faMasSubLedArray[i][0]==val){

			obj.length++;
			obj.options[obj.length-1].value=faMasSubLedArray[i][1];
			obj.options[obj.length-1].text=faMasSubLedArray[i][2];
		}
	}
}

function calcNetAmount(formName){
    var count = 0;
    var netAmt = 0;
    var amt = 0;
    var count = eval(document.getElementById('noOfRec')).value;
   	while(count != 0){
   	   	var amt = Number(document.getElementById('amount'+count).value);
		netAmt =parseFloat(netAmt,10)+parseFloat(amt,10);
		count = count - 1;
	   }
	    var netAmtObj = eval(document.getElementById('totalNetId'));
	 	netAmtObj.value = String(netAmt);
}

function calculateAmt(inc)
{
	var qtyObj = document.getElementById('qty'+inc).value;
	if(null !=document.getElementById('resrate'+inc))
	var rateObj =document.getElementById('resrate'+inc).value;
	var amount = 0;
	amount = parseFloat(qtyObj)*parseFloat(rateObj);
	document.getElementById('amount'+inc).value=amount;
	//document.getElementById('netamount'+inc).value=amount;
}
var empArr = new Array();

function populateEmployee(val,formName){
	obj = document.getElementById('employeeId');
	obj.length = 1;
	for(i=0;i<empArr.length;i++){
		if(empArr[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=empArr[i][1];
			obj.options[obj.length-1].text=empArr[i][2];
		}
	}
}

function validateRadioForPackage(){

	 for(var i = 0; i < document.getElementsByName('parent').length; i++){
	  if(document.getElementsByName('parent')[i].checked == true){
			return true;
	  	}
  	}
 	alert("Please select the Package");
	return false;

	}

function validateChargeCodeForAutoComplete( strValue,inc ) {
 	if(strValue != "" && strValue !="No Items found")
	{
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);

		    if(id =="")
		    {
		    		document.getElementById('chargeCode'+inc).value="";
		    		if(document.getElementById('rate'+inc) != null)
		    			document.getElementById('rate'+inc).value="";
		    		if(document.getElementById('resrate'+inc) != null)
		    			document.getElementById('resrate'+inc).value="";
	   				document.getElementById('amount'+inc).value="";
	   				if(document.getElementById('disamount'+inc) != null)
	   					document.getElementById('disamount'+inc).value="";
	   				if(document.getElementById('netamount'+inc) != null)
	   					document.getElementById('netamount'+inc).value="";
	   				document.getElementById('qty'+inc).value="";
 					return ;
 			}

			document.getElementById('qty'+inc).value="1";
			document.getElementById('qty'+inc).readOnly = false;

			for(i=1;i<inc;i++){
				if(inc != 1){
					if(document.getElementById('chargeCode'+i)!=null){
						var charge =  document.getElementById('chargeCode'+i).value;
						var idx1 = charge.lastIndexOf("[");
			    		var idx2 = charge.lastIndexOf("]");
			   			 idx1++;
			    		var chargeCode = charge.substring(idx1,idx2);

						if(chargeCode == id)
						{
							alert("Charge Code already selected...!")
							document.getElementById('chargeCode'+inc).value=""
							document.getElementById('qty'+inc).value="";
							var e=eval(document.getElementById('chargeCode'+inc));
							e.focus();
							return false;
						}
					}
				}
			}
	      	return true;

 		}else{
 			document.getElementById('chargeCode'+inc).value="";
 			if(document.getElementById('resrate'+inc) != null)
				document.getElementById('resrate'+inc).value="";
			if(document.getElementById('rate'+inc) != null)
				document.getElementById('rate'+inc).value = "";
			document.getElementById('amount'+inc).value="";
			if(document.getElementById('disamount'+inc) != null)
				document.getElementById('disamount'+inc).value="";
			if(document.getElementById('netamount'+inc) != null)
				document.getElementById('netamount'+inc).value="";
			document.getElementById('qty'+inc).value="";
 			return false;
 			}

}
function ajaxForEmployeeDetails()

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

   var employeeId=document.getElementById("employeeId").value;

    var url="registration?method=ajaxForEmployeeDetails&employeeId="+employeeId+"";
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < items.childNodes.length; loop++)
      	{
	        var item = items.childNodes[loop];
	        var firstName  = item.getElementsByTagName("firstName")[0];
	        document.getElementById("pFirstNameId").value=  firstName.childNodes[0].nodeValue;
	        document.getElementById("pFirstNameId").disabled = true;
	        document.getElementById("pFirstNameIdTemp").value=  firstName.childNodes[0].nodeValue;
	        var middleName ="";

	       middleName  = item.getElementsByTagName("middleName")[0];
	       try{
	         	document.getElementById("pMiddleNameId").value=  middleName.childNodes[0].nodeValue;
	          	//document.getElementById("pMiddleNameId").readOnly=true;
	        	document.getElementById("pMiddleNameId").disabled = true;
	            document.getElementById("pMiddleNameIdTemp").value=  middleName.childNodes[0].nodeValue;
	         }
	         catch(e){
	         	document.getElementById("pMiddleNameId").value= "";
	         	//document.getElementById("pMiddleNameId").readOnly=true;
	            document.getElementById("pMiddleNameId").disabled = true;
	            document.getElementById("pMiddleNameIdTemp").value= "";
	         }

	       	var lastName  = item.getElementsByTagName("lastName")[0];
	       	try{
	       		document.getElementById("pLastNameId").value= lastName.childNodes[0].nodeValue;;
	        	//document.getElementById("pLastNameId").readOnly=true;
	            document.getElementById("pLastNameId").disabled = true;
	            document.getElementById("pLastNameIdTemp").value= lastName.childNodes[0].nodeValue;;
	       	}
	       	catch(e){
	       		document.getElementById("pLastNameId").value="";
	       		//document.getElementById("pLastNameId").readOnly=true;
	       		document.getElementById("pLastNameId").disabled = true;
	       		document.getElementById("pLastNameIdTemp").value= "";;

	       	}

	      	var titleId  = item.getElementsByTagName("titleId")[0];
	      	var obj=	document.getElementById("titleId");

	     	for(var i=0;i<obj.length;i++){
		   		try
		   		{
			      if(obj.options[i].value==titleId.childNodes[0].nodeValue)
			      {
		    	      obj.options[i].selected = true;
	    	     	  document.getElementById("titleIdTemp").value= titleId.childNodes[0].nodeValue;
			      }
		      }catch(e){

		      }
	      	 obj.disabled=true;
	      }

	      var obj1=	document.getElementById("gender");
	  	  var genderId  = item.getElementsByTagName("genderId")[0];
	      for(var i=0;i<obj1.length;i++){
	   		try
	   		{
		      if(obj1.options[i].value==genderId.childNodes[0].nodeValue)
		      {
		    	   obj1.options[i].selected = true;
		    	   document.getElementById("genderTemp").value= genderId.childNodes[0].nodeValue;
		      }

		     }
		      catch(e){
		      }
	       obj1.disabled=true;
	      }

	      var dob  = item.getElementsByTagName("dob")[0];
	      try{
	   			document.getElementById("dobId").value=dob.childNodes[0].nodeValue
	   			//document.getElementById("dobId").readOnly=true;
	   			document.getElementById("dobId").disabled = true;
	   		 	document.getElementById("dobIdTemp").value= dob.childNodes[0].nodeValue;
	   		}
	   		catch(e){
		   		document.getElementById("dobId").value="";
		   		//document.getElementById("dobId").readOnly=true;
		   		document.getElementById("dobId").disabled = false;
		   	 	document.getElementById("dobIdTemp").value=="";
	   		}

	   	 var age  = item.getElementsByTagName("age")[0];
	     try{
			   	document.getElementById("age").value=age.childNodes[0].nodeValue
			   	//document.getElementById("age").readOnly=true;
			   	document.getElementById("age").disabled = true;
			    document.getElementById("ageTemp").value= age.childNodes[0].nodeValue;
			    document.getElementById("ageUnitIdTemp").value = document.getElementById("ageUnitId").value;
			    document.getElementById("ageUnitId").disabled = true;
	   	}
	   	catch(e){
	   			document.getElementById("age").value="";
	     		//document.getElementById("age").readOnly=true;
	     		document.getElementById("age").disabled = false;
	     		document.getElementById("ageTemp").value="";
	     		 document.getElementById("ageUnitIdTemp").value = "";
			    document.getElementById("ageUnitId").disabled = false;
	   	}

	   	var address=  item.getElementsByTagName("address")[0];
	    try{
			   	document.getElementById("addr").value=address.childNodes[0].nodeValue
			   	//document.getElementById("addr").readOnly=true;
			   	document.getElementById("addr").disabled=true;
		   	 	document.getElementById("addrTemp").value=address.childNodes[0].nodeValue
	   	}
	   	catch(e){
			   document.getElementById("addr").value="";
			   //document.getElementById("addr").readOnly=true;
			   document.getElementById("addr").disabled=false;
	     	   document.getElementById("addrTemp").value="";
	   	}

	    var religionId=  item.getElementsByTagName("religionId")[0];
	    var obj1=	document.getElementById("religionId");

      if(religionId.childNodes[0].nodeValue != 0 ){
	    for(var i=0;i<obj1.length;i++){
	   		try
	   		{
		      if(obj1.options[i].value==religionId.childNodes[0].nodeValue)
		      {
		    	  obj1.options[i].selected = true;
		    	  document.getElementById("religionIdTemp").value= religionId.childNodes[0].nodeValue;
		      }
	      }
	      catch(e){
	      }
	    }
	        obj1.disabled=true;
	   }else{
	        obj1.disabled=false;
	   }

	   var casteId=  item.getElementsByTagName("casteId")[0];
	   var obj2=	document.getElementById("casteId");
	   if(casteId.childNodes[0].nodeValue != 0 ){
       for(var i=0;i<obj2.length;i++){
   		 try
   		 {
	      if(obj2.options[i].value==casteId.childNodes[0].nodeValue)
	      {
	    	 obj2.options[i].selected = true;
	    	 document.getElementById("casteIdTemp").value= casteId.childNodes[0].nodeValue;
	      }
      	}
	      catch(e){

	      }
	     }
		     obj2.disabled=true;
		 }else{
		 obj2.disabled=false;
		 }

	      var relativeName=  item.getElementsByTagName("relativeName")[0];
	      try{
	   		document.getElementById("nokNameId").value=relativeName.childNodes[0].nodeValue
	   		//document.getElementById("nokNameId").readOnly=true;
	   		document.getElementById("nokNameId").disabled=true;
	   		 document.getElementById("relativeNameTemp").value=relativeName.childNodes[0].nodeValue
	   	}
	   	catch(e){
	  		 document.getElementById("nokNameId").value="";
	     	 document.getElementById("relativeNameTemp").value="";
	     	 document.getElementById("nokNameId").disabled=false;
	   	}

      }

    }
  }
  }

 function populateDepandentList(){

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

   var employeeId=document.getElementById("employeeId").value;

    var url="registration?method=populateDepandentList&employeeId="+employeeId+"";
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      var employeeDependentId=document.getElementById("employeeDependentId");
      employeeDependentId.length=0;
       employeeDependentId.length++;
      employeeDependentId.options[0].value="0";
      employeeDependentId.options[0].text="select";

      	for (loop = 0; loop < items.childNodes.length; loop++)
      	{  employeeDependentId.length++;

	   	    var item = items.childNodes[loop];
	   	        var id  = item.getElementsByTagName("id")[0];

	         var name  = item.getElementsByTagName("name")[0];
	     employeeDependentId.options[loop+1].value=id.childNodes[0].nodeValue;
	      employeeDependentId.options[loop+1].text=name.childNodes[0].nodeValue;

	      var relation = item.getElementsByTagName("relation")[0];
	      document.getElementById('depndtRelation').value = relation.childNodes[0].nodeValue;

	}

}
}
}
function getDepandentDetails(){

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

   var employeeDependentId=document.getElementById("employeeDependentId").value;

    var url="registration?method=getDepandentDetails&employeeDependentId="+employeeDependentId+"";
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];


      	for (loop = 0; loop < items.childNodes.length; loop++)
      	{

   	     var item = items.childNodes[loop];
         var name  = item.getElementsByTagName("name")[0];
         var address  = item.getElementsByTagName("address")[0];
         document.getElementById("addr").value=  address.childNodes[0].nodeValue;

		 var relation  = item.getElementsByTagName("relation")[0];
         document.getElementById("depndtRelation").value=  relation.childNodes[0].nodeValue;

         var lastname = "";
         var firstname = "";

    	 if(name.childNodes[0].nodeValue.indexOf(" ") > 0){
    	 	 firstname  = name.childNodes[0].nodeValue.substring(0,name.childNodes[0].nodeValue.indexOf(" "));

    	 	lastname = name.childNodes[0].nodeValue.substring(name.childNodes[0].nodeValue.indexOf(" ")+1);
    	 }else{
    	 	firstname  = name.childNodes[0].nodeValue;
    	 }
         document.getElementById("pFirstNameId").value=  firstname;
         document.getElementById("pFirstNameId").readOnly=false;
         document.getElementById("pFirstNameIdTemp").value=  firstname;

         document.getElementById("pMiddleNameId").value= "";
         document.getElementById("pMiddleNameId").readOnly=false;
         document.getElementById("pMiddleNameIdTemp").value=  "";

         document.getElementById("pLastNameId").value=lastname;
       	 document.getElementById("pLastNameId").readOnly=false;
      	 document.getElementById("pLastNameIdTemp").value=  lastname;

         var obj1=	document.getElementById("gender");
	  	 var genderId  = item.getElementsByTagName("genderId")[0];
	     for(var i=0;i<obj1.length;i++){
	   		try
	   		{
		      if(obj1.options[i].value==genderId.childNodes[0].nodeValue)
		      {


		    	      obj1.options[i].selected = true;
		    	       document.getElementById("genderTemp").value= genderId.childNodes[0].nodeValue;

		      }
		      changeGender();
	      }
	      catch(e){

	      }
	      obj1.disabled=true;
	      }
	      var dob  = item.getElementsByTagName("dob")[0];
	      try{
	   		document.getElementById("dobId").value=dob.childNodes[0].nodeValue
	   		document.getElementById("dobId").readOnly=true;
	   		document.getElementById("dobIdTemp").value= dob.childNodes[0].nodeValue;
		   	}
		   	catch(e){
	   		document.getElementById("dobId").value="";
	   		document.getElementById("dobIdTemp").value="";
	   		}

	   	 var age  = item.getElementsByTagName("age")[0];
	      try{
	   		document.getElementById("age").value=age.childNodes[0].nodeValue
	   		document.getElementById("age").readOnly=true;
	   		 document.getElementById("ageTemp").value= age.childNodes[0].nodeValue;
	   		 document.getElementById("ageUnitIdTemp").value = document.getElementById("ageUnitId").value;
			 document.getElementById("ageUnitId").disabled = true;
	   	}
	   	catch(e){
	   		document.getElementById("age").value="";
	   		document.getElementById("age").readOnly=true;
	   		document.getElementById("ageTemp").value="";
	   		document.getElementById("ageUnitIdTemp").value = "";
			document.getElementById("ageUnitId").disabled = true;
	   	}

	   	var w = document.getElementById('employeeId').selectedIndex;
		var selectedText = document.getElementById('employeeId').options[w].text;
		document.getElementById('nokNameId').value = selectedText;
	   	document.getElementById('relativeNameTemp').value = selectedText;
	}

}
}
}
 function validateAge(){
	var user_date =Date.parse(document.getElementById('dob').value.trim()) ;
	var today_date = new Date();
	var diff_date =  today_date-user_date;
	var num_years = diff_date/31536000000;
	var num_months = (diff_date % 31536000000)/2628000000;
	var num_days = ((diff_date % 31536000000) % 2628000000)/86400000;
	if(num_years < 18){
	alert("Person is below 18 years");
	document.getElementById('dob').value= "";
	user_date.value="";
  }
}



function checkDependentAge(){
if(document.getElementById('depDobId')){
	var depDob = Date.parse(document.getElementById('depDobId').value) ;
		var relaion = "";
		if(document.getElementById('depndtRelation')){
		relaion = document.getElementById('depndtRelation').value;
		}
	if(relaion != "Husband" && relaion !="wife" )
	{

		var today_date = new Date();
		var diff_date =  today_date-depDob;
		var num_years = diff_date/31536000000;
		var num_months = (diff_date % 31536000000)/2628000000;
		var num_days = ((diff_date % 31536000000) % 2628000000)/86400000;
		if(num_years > 21){
			alert("Dependent should not be grater than 21 years.");
			return false;
		}
	}
	}
	return true;

}
var secondsPerMinute = 60;

var minutesPerHour = 60;

function convertSecondsToHHMMSS(intSecondsToConvert) {

	var hours = convertHours(intSecondsToConvert);

	var minutes = getRemainingMinutes(intSecondsToConvert);
	minutes = (minutes == 60) ? "00" : minutes;

	var seconds = getRemainingSeconds(intSecondsToConvert);

 	var time = hours+":"+minutes;
	return time;

}



function convertHours(intSeconds) {

var minutes = convertMinutes(intSeconds);

var hours = Math.floor(minutes/minutesPerHour);

return hours;

}

function convertMinutes(intSeconds) {

return Math.floor(intSeconds/secondsPerMinute);

}

function getRemainingSeconds(intTotalSeconds) {

return (intTotalSeconds%secondsPerMinute);

}

function getRemainingMinutes(intSeconds) {

var intTotalMinutes = convertMinutes(intSeconds);

return (intTotalMinutes%minutesPerHour);

}



function HMStoSec1(T) { // h:m:s

  var A = T.split(/\D+/) ; return (A[0]*60 + +A[1])*60 + +A[2]
}
function calculateTime(){

	var time1 = HMStoSec1(document.getElementById('timeOn').value);
	var time2 = HMStoSec1(document.getElementById('timeOff').value);
	 var totalTime ;
	var diff = time2 - time1;
	if(document.getElementById('timeOn').value == "00:00:00" && document.getElementById('timeOff').value == "00:00:00"){
	alert("Time cannot be 00:00:00");
	document.getElementById('totalHours').value = "00:00:00";
	return false;
	}
	else if(document.getElementById('timeOff').value >= document.getElementById('timeOn').value){
	totalTime = (convertSecondsToHHMMSS(diff));
	document.getElementById('totalHours').value = totalTime;
	return true;
	}else{
	alert("Time On should be less than Time Off");
	return false;
	}

}

function compareTimes()
{
	if(document.getElementById('timeOn').value >= document.getElementById('timeOff').value)
	{
		alert("Time On should be less than Time Off");
		return false;
	}
	return true;

}
function checkTime1(formName,timeFieldName){

	objTime = eval('document.'+formName+'.'+timeFieldName);
  	var chtime=objTime.value;
	if(chtime==""){
	alert('Changed Time can not be blank')
		return false
	}

	try{
		 var indx = chtime.indexOf(':');

		 if (indx != -1) {
		 var pairs2 = chtime.substring(0,chtime.length).split(':');
		 }

		 if (pairs2.length!=2) {
			 alert("Invalid Time Format.It should be HH:MM")
			return false;
			}

		 if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
				  alert("Invalid Time Format.It should be HH:MM")
				  return false;
				}

		 		 val2=eval(pairs2[0]);

						  if (val2<0 || val2>23) {
							  alert("Hours should 00-23")
					 		 return false;}

					 		 val3=eval(pairs2[1]);

							  if (val3<0 || val3>59) {
							  alert("Min should 00-59")
					 		 return false;}


	}catch(e2)
	{	alert("Invalid Time... It should be HH:MM ")
		objTime.value="";
		return false;
	}

return true;
}


function validateChargeCodeForOrderRequestAutoComplete( strValue,inc, flag ) {

 	if(strValue != "")
	{
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);

		    if(id =="")
		    {
		    		document.getElementById('chargeCode'+inc).value="";
		    		if(document.getElementById('chargeId'+inc))
		    			document.getElementById('chargeId'+inc).value="";
					if(document.getElementById('standardDeductionId'+inc))
 						document.getElementById('standardDeductionId'+inc).value = "";

		    		if(document.getElementById('rate'+inc) != null)
		    			document.getElementById('rate'+inc).value="";
		    		if(document.getElementById('resrate'+inc) != null)
		    			document.getElementById('resrate'+inc).value="";
	   				document.getElementById('amount'+inc).value="";

	   				if(document.getElementById('dispercent'+inc) != null)
						document.getElementById('dispercent'+inc).value="";
					if(document.getElementById('disamount'+inc) != null)
	   					document.getElementById('disamount'+inc).value="";
	   				if(document.getElementById('netamount'+inc) != null)
	   					document.getElementById('netamount'+inc).value="";
	   				if(document.getElementById('prprtnlDis'+inc) != null)
	   					document.getElementById('prprtnlDis'+inc).value="";
	   				document.getElementById('qty'+inc).readOnly = true;
	   				document.getElementById('qty'+inc).value="";

	   				calculateNetAmount2(inc);
	   				if(flag == "op")
						calculateTotalAmt();
					else if(flag == "ip")
						calculateTotalAmtForIp();
 					return ;
 			}

			document.getElementById('qty'+inc).value="1";
			document.getElementById('qty'+inc).readOnly = false;

			for(i=1;i<inc;i++){
				if(inc != 1){
					if(document.getElementById('chargeCode'+i)!=null){
						var charge =  document.getElementById('chargeCode'+i).value;
						var idx1 = charge.lastIndexOf("[");
			    		var idx2 = charge.lastIndexOf("]");
			   			 idx1++;
			    		var chargeCode = charge.substring(idx1,idx2);

						if(chargeCode == id)
						{
							alert("Charge Code already selected...!")
							document.getElementById('chargeCode'+inc).value=""
							document.getElementById('qty'+inc).value="";
							document.getElementById('qty'+inc).readOnly = true;
							var e=eval(document.getElementById('chargeCode'+inc));
							e.focus();
							return false;
						}
					}
				}
			}
	      	return true;

 		}else{
 			if(document.getElementById('chargeCode'+inc)){
	 			document.getElementById('chargeCode'+inc).value="";
	 			if(document.getElementById('chargeId'+inc))
	 				document.getElementById('chargeId'+inc).value="";
	 			if(document.getElementById('standardDeductionId'+inc))
	 				document.getElementById('standardDeductionId'+inc).value = "";
	 			if(document.getElementById('resrate'+inc) != null)
					document.getElementById('resrate'+inc).value="";
				if(document.getElementById('rate'+inc) != null)
					document.getElementById('rate'+inc).value = "";
				document.getElementById('amount'+inc).value="";
				if(document.getElementById('dispercent'+inc) != null)
					document.getElementById('dispercent'+inc).value="";

				if(document.getElementById('disamount'+inc) != null)
					document.getElementById('disamount'+inc).value="";
				if(document.getElementById('netamount'+inc) != null)
					document.getElementById('netamount'+inc).value="";
				if(document.getElementById('prprtnlDis'+inc) != null)
		   			document.getElementById('prprtnlDis'+inc).value="";

		   		document.getElementById('qty'+inc).readOnly = true;
				document.getElementById('qty'+inc).value="";

				calculateNetAmount2(inc);

				if(document.getElementById('hiddenValueCharge').value == 1){
						document.getElementById('discountOnBillId').value= "";
				}else{
					var filled = "";
					for(var i=1;i<document.getElementById('hiddenValueCharge').value;i++){
						if(document.getElementById('chargeCode'+i)){
							if(document.getElementById('chargeCode'+i).value != ""){
								filled = "yes";
								break;
							}else{
								filled = "no";
							}
						}
					}
				}
					if(filled == "no"){
						document.getElementById('discountOnBillId').value= "";
					}


				if(flag == "op")
					calculateTotalAmt();
				else if(flag == "ip")
					calculateTotalAmtForIp();

	 			return false;
	 		}
 		}

}
function calculateNetAmount2(count){
	var rateObj;
		if(document.getElementById('resrate'+count) != null || document.getElementById('rate'+count) != null){
			var qtyObj = eval(document.getElementById('qty'+count));
			if(document.getElementById('resrate'+count))
				rateObj = eval(document.getElementById('resrate'+count));
			else if(document.getElementById('rate'+count))
				rateObj = eval(document.getElementById('rate'+count));

			var stdDedObj = eval(document.getElementById('standardDeductionId'+count))
			var amtObj = eval(document.getElementById('amount'+count));
			var disAmtObj = eval(document.getElementById('disamount'+count));
			var proportinaldisAmtObj = eval(document.getElementById('prprtnlDis'+count));

			qty = qtyObj.value;
			rate = rateObj.value;
			stdDed = stdDedObj.value;
			if(stdDed != "")
				amt = qty*(parseFloat(rate)-parseFloat(stdDed));
			else
				amt = qty*rate;

			if(qty != "" && rate != "" && amt != ""){
				var disAmt = 0;
				var prptDisAmt = 0;
				var netAmt = 0;
				var salesTax = 0;
				var totalAmt = 0;
				var totalDiscAmt = 0;
				var netAmtObj =  eval(document.getElementById('netamount'+count));

				if(disAmtObj.value != "" && parseFloat(disAmtObj.value) != 0){
					disAmt = parseFloat(disAmtObj.value);
				}
				if(proportinaldisAmtObj.value !="" && parseFloat(proportinaldisAmtObj.value) != 0){
					prptDisAmt = parseFloat(proportinaldisAmtObj.value);
				}

				if(document.getElementById('salesTaxAmt'+count)){
					if(document.getElementById('salesTaxAmt'+count).value != ""){
						salesTax = 	document.getElementById('salesTaxAmt'+count).value;
					}
				}

				totalDiscAmt = disAmt + prptDisAmt;


				if(totalDiscAmt != 0){
					netAmt = parseFloat(amt)+parseFloat(salesTax)-parseFloat(totalDiscAmt);
					netAmtObj.value = parseFloat(netAmt).toFixed(2);
					amtObj.value = parseFloat(amt).toFixed(2);
				}else{
					amtObj.value = parseFloat(amt).toFixed(2);
					netAmtObj.value = (parseFloat(amt)+parseFloat(salesTax)).toFixed(2);
				}
			}
		}
	}

//-bY UJJWAL
majorHeadCodeArray1 = new Array();

function populatemajorHead(val,formName){
	
	obj = eval('document.'+formName+'.subMajorHeadId');
	
	obj.length = 1;
	for(i=0;i<majorHeadCodeArray1.length;i++){
		if(majorHeadCodeArray1[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=majorHeadCodeArray1[i][1];
			obj.options[obj.length-1].text=majorHeadCodeArray1[i][2];
		}
	}
}

codeArray=new Array();
function populateminorHead(val,fromName){
obj = eval('document.'+formName+'.minorHeadId');
obj.length = 1;
for(i=0;i<codeArray.length;i++){
	
	if(codeArray[i][0]==val){
		
obj.length++;
obj.options[obj.length-1].value=codeArray[i][1];
obj.options[obj.length-1].text=codeArray[i][2];
}
}
}



majorHeadCodeArray2 = new Array();
function populatesubmajorHead(val,formName){

obj = eval('document.'+formName+'.minorHead1');

obj.length = 1;

for(i=0;i<majorHeadCodeArray2.length;i++){
	
	if(majorHeadCodeArray2[i][0]==val){
		
obj.length++;
obj.options[obj.length-1].value=majorHeadCodeArray2[i][1];
obj.options[obj.length-1].text=majorHeadCodeArray2[i][2];
}
}
}
codeArray = new Array();
function populateminorHead(val,formName){

var obj = eval('document.'+formName+'.minorHeadId');
//alert("obj"+obj);
 obj.length = 1;

for(i=0;i<codeArray.length;i++){
	
	if(codeArray[i][0]==val){
		
obj.length++;
obj.options[obj.length-1].value=codeArray[i][1];
obj.options[obj.length-1].text=codeArray[i][2];
}
}
}
objectHeadCodeArray = new Array();
function populateminorsubHead(val,formName){
obj = eval('document.'+formName+'.objectId');
obj.length = 1;
for(i=0;i<objectHeadCodeArray.length;i++){
if(objectHeadCodeArray[i][0]==val){
obj.length++;
obj.options[obj.length-1].value=objectHeadCodeArray[i][1];
obj.options[obj.length-1].text=objectHeadCodeArray[i][2];
}
}
}


	
departmentArray=new Array();
function populateDepartment(val,formName){
	
	obj = eval('document.'+formName+'.equipmentId');	
	obj.length = 1;
	
	for(i=0;i<departmentArray.length;i++){
		if(departmentArray[i][0]==val){
	obj.length++;
	obj.options[obj.length-1].value=departmentArray[i][1];
	obj.options[obj.length-1].text=departmentArray[i][2];
	}
	}
	}

/*departmentArray1=new Array();
function populateDepartment(val,formName){
	
	obj = eval('document.'+formName+'.empId');	
	obj.length = 1;
	for(i=0;i<departmentArray1.length;i++){
		if(departmentArray1[i][0]==val){
	obj.length++;
	obj.options[obj.length-1].value=departmentArray1[i][1];
	obj.options[obj.length-1].text=departmentArray1[i][2];
	}
	}
	}*/

function populateSubGroup(val,formName){
	obj1 = eval('document.'+formName+'.subGroupId');
	obj1.length = 1;
	for(i=0;i<subGroupArray.length;i++){
		if(subGroupArray[i][0]==val){
			obj1.length++;
			obj1.options[obj1.length-1].value=subGroupArray[i][1];
			obj1.options[obj1.length-1].text=subGroupArray[i][2];
		}
	}
}

mainAccountArray = new Array();

function populateMainAccount(val,formName){
	obj1 = eval('document.'+formName+'.mainAccountId');
	obj1.length = 1;
	for(i=0;i<mainAccountArray.length;i++){
		if(mainAccountArray[i][0]==val){
			obj1.length++;
			obj1.options[obj1.length-1].value=mainAccountArray[i][1];
			obj1.options[obj1.length-1].text=mainAccountArray[i][2];
		}
	}
}

subLedgerArray1 = new Array();

function populateSubLedger(val,formName){
	obj1 =eval('document.'+formName+'.subledgerId');
	obj1.length = 1;
	for(i=0;i<subLedgerArray1.length;i++){
		if(subLedgerArray1[i][0]==val){
			obj1.length++;
			obj1.options[obj1.length-1].value=subLedgerArray1[i][1];
			obj1.options[obj1.length-1].text=subLedgerArray1[i][2];
		}
	}
}

subLedArray = new Array();

function populateSubLed(val,formName,inc){
	obj1 = eval('document.'+formName+'.subLedId'+inc);
	obj1.length = 1;
	for(i=0;i<subLedArray.length;i++){
		if(subLedArray[i][0]==val){
			obj1.length++;
			obj1.options[obj1.length-1].value=subLedArray[i][1];
			obj1.options[obj1.length-1].text=subLedArray[i][2];
		}
	}
}

subLedgerArr = new Array();

function populateSubLedgerForCash(val,formName,inc){
	obj11 = eval('document.'+formName+'.subLedgId'+inc);
	obj11.length = 1;
	for(i=0;i<subLedgerArr.length;i++){
		if(subLedgerArr[i][0]==val){
			obj11.length++;
			obj11.options[obj11.length-1].value=subLedgerArr[i][1];
			obj11.options[obj11.length-1].text=subLedgerArr[i][2];
		}
	}
}

subChargeArr = new Array();

function populateSubChargeForAccounts(val,formName,inc){
	obj1 = eval('document.'+formName+'.subChargeCodeId'+inc);
	obj1.length = 1;
	for(i=0;i<subChargeArr.length;i++){
		if(subChargeArr[i][0]==val){

			obj1.length++;
			obj1.options[obj1.length-1].value=subChargeArr[i][1];
			obj1.options[obj1.length-1].text=subChargeArr[i][2];
		}
	}
}

function validateRowsTemplate(){
	var count = document.getElementById('countVal').value;
	for(var i=0;i<count;i++){
		if(document.getElementsByName('templateId')[i].checked){
			return true;
		}

	}
	alert("Please select at least one row.");
	return false;
}
itemTypeArray = new Array();
function populateItemType(val,formName){
	obj = eval('document.'+formName+'.itemTypeId');
	obj.length = 1;
	for(i=0;i<itemTypeArray.length;i++){
		if(itemTypeArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=itemTypeArray[i][1];
			obj.options[obj.length-1].text=itemTypeArray[i][2];
		}
	}
}

rankArr = new Array();
function populateReportingManager(val,formName){
	obj = eval('document.'+formName+'.reportingPersonId');
	obj.length = 1;
	for(i=0;i<rankArr.length;i++){
		if(rankArr[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=rankArr[i][1];
			obj.options[obj.length-1].text=rankArr[i][2];
		}
	}
}

var preEl ;
var orgBColor;
var orgTColor;
var backColor='#87CEEB';
var textColor='cc3333';
function HighLightTR(el){
  if(typeof(preEl)!='undefined') {
     preEl.bgColor=orgBColor;
     try{ChangeTextColor(preEl,orgTColor);}catch(e){;}
  }
  orgBColor = el.bgColor;
  orgTColor = el.style.color;
  el.bgColor=backColor;

  try{ChangeTextColor(el,textColor);}catch(e){;}
  preEl = el;
}


function ChangeTextColor(a_obj,a_color){  ;
   for (i=0;i<a_obj.cells.length;i++)
    a_obj.cells(i).style.color=a_color;
}


function checkSearchField() {
	var uhid = document.getElementById('hinNo1').value;
	var name = document.getElementById('pFirstNameId').value;
	var mobile = document.getElementById('mobno').value;
	var dob = document.getElementById('dobId').value;
	var ward = document.getElementById('wardId').value;
	var lsgName = document.getElementById('lsgNameId').value;
	var locality = document.getElementById('locality').value;
	var houseId = document.getElementById('houseId').value;
	var fromAge = document.getElementById('fromAge').value;
	var toAge = document.getElementById('toAge').value;
	var llno1 = document.getElementById('llno1').value;
	var rationCardno = document.getElementById('rationCardno').value;

	if (uhid != '' || name != '' || mobile != '' || dob != '' || ward != ''
			|| lsgName > 0 || locality > 0 || houseId != ''
			|| fromAge != '' || toAge != '' || llno1 != ''
			|| rationCardno != '') {

		if(name != '' && !chkInputLength(name))
			{
				alert("Please enter atlease 3 charachers in Name");
				return false;
			}
		
		return true;
	} else {
		alert("Please Enter At Least One Parameter ");
		return false;
	}
}

function chkInputLength(strValue){
	if(strValue!="" && strValue.length<3){
		return false;
	}
	return true;
}

function changeDrValue(obj,page){
	if(obj.checked){
		
		if(page=='visit'){
		if(document.getElementById('unit').value!=''){
			populateDoctorForUnit(document.getElementById('unit').value,'visit','deptId')
			
			
		}
		}else if(page=='quickVisit'){
			if(document.getElementById('quickunit').value!=''){
				populateDoctorForUnit(document.getElementById('quickunit').value,'quickVisit','vdeptId')
				
				
			}
		}
		
		
	}else{
		if(document.getElementById('quickloddrs')!=null){
		document.getElementById('quickloddrs').value='';
		}else{
		document.getElementById('loddrs').value='';
		}
	}
	
}


function doPatientRelease(visitId,pageName)
{
		bReleaseClick ='Y';
		var responseUrl = 'opd?method=getOPClinicalWaitingList&selectedAppId=A1641';
			
	 	var data = "visitId="+visitId;
	    var url = "opd?method=doPatientRelease";
	    
	    if(pageName){
	    if(pageName=='opLite'){
	    	responseUrl = 'opd?method=showNewOPWaitingList&selectedAppId=A2168';
	    }else if(pageName=='opDetail'){
	    	responseUrl = 'opd?method=showNewOPDetailWaitingList&selectedAppId=A2174';
	    }
	    }
	    
	 	    
	  jQuery(function ($) {
	  
	    	$.ajax({
				type:"POST",
				url: url+'&'+csrfTokenName+'='+csrfTokenValue,
				data: data,	 							
				cache: false,
				success: function(msg)
				{									 
					//alert(msg);
					
					
					if(msg.indexOf("success~~~true") != -1)
						{
								alert("Release successfully");
								bReleaseClick ='N';
								window.location = responseUrl;
								
						}
					else
						{
							bReleaseClick ='N';
							alert("An error has occurred while contacting the server");
						}
					
					
									
					
				},
				error: function(msg)
				{					
					bReleaseClick ='N';
					alert("An error has occurred while contacting the server");
					
				}
				
				});
	    });   
}