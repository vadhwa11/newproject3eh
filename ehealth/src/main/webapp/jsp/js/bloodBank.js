function populatebloodBankQuantity(bloodBankId){
	
	document.getElementById('selectedBloodBankId').value=bloodBankId;
	var bloodBankId=document.getElementById('selectedBloodBankId').value;
	var componentName=document.getElementById('componentName1').value;
	var bloodGroupId=document.getElementById('bloodGroupNameId').value;
	//alert(document.getElementById('selectedBloodBankId').value)
	//alert(document.getElementById('componentName1').value)
	//alert(document.getElementById('bloodGroupNameId').value)
	//document.getElementById('bloodGroupNameId').value=bloodBankId;
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
	var b="false";
  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
  	for (loop = 0; loop < items.childNodes.length; loop++) {
   	    var item = items.childNodes[loop];
        var icdString  = item.getElementsByTagName('unitId')[0];
         document.getElementById('b'+bloodBankId).value =icdString.childNodes[0].nodeValue	   	    
  }
  }
  }

var url="/hms/hms/bloodBank?method=populatebloodBankQuantity&bloodBankId="+bloodBankId+"&componentName="+componentName+"&bloodGroupId="+bloodGroupId;
xmlHttp.open("GET",url,true);
xmlHttp.setRequestHeader("Content-Type", "text/xml");
xmlHttp.send(null);

	
} 

