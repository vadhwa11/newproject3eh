
<%@page import="jkt.hms.masters.business.MasCountry"%>
<label><span>*</span> Country</label>
<select NAME="<%=COUNTRY%>" id="countryId"
	onchange="getStateList('addresume','updatePage')"
	validate="Country,string,yes">
	<option value=0 selected="selected">Select</option>
	<%for(MasCountry country:countryList ){ %>
	<option value='<%=country.getId()%>'><%=country.getCountryName() %></option>
	<%} %>
</select>

<div id="defaultStateList" style="display: block"><label><span>*</span>
State</label>
<div id="messageForWait" class="msg" style="display: none">
Getting State List...</div>
<select id="stateList" validate="State,string,no">
	<option value="">Select</option>
</select></div>

<div id="responseStateList" style="display: none;"></div>

<div id="defaultCityList" style="display: block"><label><span>*</span>
City</label>
<div id="messageForWaitCity" class="msg" style="display: none">
Getting City List...</div>
<select NAME="city" id="city" validate="City,string,no">
	<option value='0'>Select</option>
</select></div>

<div id="responseCityList" style="display: none;"></div>



<script type="text/javascript">

function getCityListAjax(formName,method){

			obj = document.getElementById('state'); 
		    stateId = obj.value ; 
		    url="/hms/hrms/resume?method=getCityList&stateId="+stateId;
	 		retrieveUrl1(url);
}
function getStateList(formName,method){
		
			obj = document.getElementById('countryId'); 
			 cityList = document.getElementById('city');
			 for(i=1;i<=cityList.length;i++)
			 {
			 	cityList.remove(i);
			 }
			 
			
			countryId = obj.value ; 
		 	url="/hms/hrms/resume?method=getStateList&countryId="+countryId;
	    	retrieveUrl(url);	
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
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	 request.open("GET", url, true);
     request.onreadystatechange = updatePage;
     request.send(null);
     
   if (!request)
     alert("Error initializing XMLHttpRequest!");

}

function retrieveUrl1(url){
	
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
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	 request.open("GET", url, true);
     request.onreadystatechange = updatePage1;
     request.send(null);
     
   if (!request)
     alert("Error initializing XMLHttpRequest!");

}

function updatePage() {

    if(request.readyState == 1){
    document.getElementById('messageForWait').style.display = 'block';
    document.getElementById('messageForWait1').style.display = 'block';
    }
    
     if ((request.readyState == 4) && (request.status == 200)) { 
     	
				if(trimAll(request.responseText)== "State List Not available")
				{
		    		document.getElementById('errorMsg').innerHTML = trimAll(request.responseText);
		    		document.getElementById('errorMsg').style.display = 'block';
		    		document.getElementById('defaultStateList').style.display = 'block';
		    		document.getElementById('responseStateList').style.display = 'none';
		    		
		    		
		    	}else{
		   			document.getElementById('responseStateList').innerHTML = trimAll(request.responseText);
		   			document.getElementById('defaultStateList').style.display = 'none';
			   		document.getElementById('responseStateList').style.display = 'block';
		   			document.getElementById('errorMsg').style.display = 'none';
		   			document.getElementById('messageForWait').style.display = 'none';
		   			document.getElementById('messageForWait1').style.display = 'none';
		   			document.getElementById('defaultStateList').validate='State,string,no';
				}
		}
   }
	function updatePage1() {

    if(request.readyState == 1){
    document.getElementById('messageForWaitCity').style.display = 'block';
     document.getElementById('messageForWaitCity1').style.display = 'block';
    }
    
     if ((request.readyState == 4) && (request.status == 200)) { 
     	
				if(trimAll(request.responseText)== "City List Not available")
				{
		    		document.getElementById('errorMsg').innerHTML = trimAll(request.responseText);
		    		document.getElementById('errorMsg').style.display = 'block';
		    		document.getElementById('defaultCityList').style.display = 'block';
		    		document.getElementById('responseCityList').style.display = 'none';
		    		
		    		
		    	}else{
		   			document.getElementById('responseCityList').innerHTML = request.responseText;
		   			document.getElementById('defaultCityList').style.display = 'none';
			   		document.getElementById('responseCityList').style.display = 'block';
		   			document.getElementById('errorMsg').style.display = 'none';
		   			document.getElementById('messageForWaitCity').style.display = 'none';
		   			document.getElementById('messageForWaitCity1').style.display = 'none';
		   			document.getElementById('city').setAttribute('validate','City,string,no');
				}
		}
   }
	
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
