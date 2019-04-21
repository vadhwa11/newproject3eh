
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		    function validateHhMm(inputField) {
		        var isValid = /^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$/.test(inputField.value);

		        if (isValid) {
		            inputField.style.backgroundColor = '#bfa';
		        } else {
		            inputField.style.backgroundColor = '#fba';
		        }

		        return isValid;
		    }

			
		
	</script>
<%
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();


if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
%>	

<div class="titleBg">
<h2>EVIDENCE OF RECENT DELIVERY</h2>
</div>
<form name="evidence" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="Block">

<label>Name</label>
<input type="text"  name="name" id="name">
<label>Age</label>
<input type="text"  name="name" id="name">
<label>Year</label>
<input type="text"  name="name" id="name">
<div class="clear"></div>
<label>Crime No.</label>
<input type="text"  name="name" id="name">
<label>Police station</label>
<input type="text"  name="name" id="name">
<label>Date</label>
<input 	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.birth.<%=FROM_DATE%>,event);" />
<div class="clear"></div>
<label>WHC/WPC No</label>
<input type="text"  name="name" id="name">
<label>Name & Address</label>
<textarea rows="4" cols="50"></textarea>
<label>Age</label>
<input type="text"  name="name" id="name">

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label>Year</label>
<input type="text"  name="name" id="name">
<label>Marital status</label>
<input type="text"  name="name" id="name">
<label>Occupation</label>
<input type="text"  name="name" id="name">

 <div class="clear"></div>
<label>Consent</label>
<textarea rows="4" cols="50"></textarea>

<label>Date</label>
<input 	type="text" name="<%=FROM_DATE%>" id="fromDateId" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
    validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.survey.<%=FROM_DATE%>,event);" />
	<label>Time</label>
<input type="text"  name="name" id="name">
<div class="clear"></div>
	<label>Place of examination</label>
<input type="text"  name="name" id="name">
	<label>Identification marks:1 </label>
<input type="text"  name="name" id="name">
	<label>Identification marks:2 </label>
<input type="text"  name="name" id="name">
<div class="clear"></div>
<h4>History related to gestation (as stated by the subject) </h4>
	<label>Menarche </label>
<input type="text"  name="name" id="name">
<label>Menstrual period</label>
<input 	type="text" name="<%=FROM_DATE%>" id="fromDateId" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
onclick="setdate('<%=currentDate%>',document.survey.<%=FROM_DATE%>,event);" />
<label>Antenatal checkup</label>
   <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
     <option value="0">Taken </option>
      <option value="0">Not taken</option>
	</select>
<div class="clear"></div>
<h4>Physical examination</h4>
 <h4> A)Genral</h4>
	<label>Height</label>
<input type="text"  name="name" id="name">
	<label> Weight</label>
<input type="text"  name="name" id="name">
<label>Build</label>
   <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
    <option value="0">Good</option>
    <option value="0">Moderate</option>
    <option value="0">Poor</option> 
    <option></option>
	</select>
	
	<div class="clear"></div>
	
		
<label>Conjunctival pallor </label>
   <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
    <option value="0">Present</option>
    <option value="0">Not present</option> 
	</select>
	
	
			
<label> Breasts</label>
   <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
	<option value="0">Engorged</option>
	<option value="0">Tender</option>
	<option value="0">Visibly full</option>
	<option value="0">Patulous</option>
	</select>
			
<label>Areola of nipple</label>
   <select name="" id="" class=""  validate=""> 
    <option value="0">Select</option>
      <option value="0">Dark and prominent with Montgomery tubercles</option>
        <option value="0">pale and non-prominent</option>
      
	</select>


<div class="clear"></div>
			
<label>Nipple </label> 
   <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
    <option value="0">Colostrum or milk could be expressed</option>
    <option value="0">Could not be expressed</option>
	</select>
	
	
	<label> Abdomen</label> 
   <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
     <option value="0">Pendulous with wrinkled skin</option>
      <option value="0">Non-pendulous with smooth skin</option>
	</select>
			
<label>Striae gravidarum </label>
   <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
     <option value="0">Present and reddish in color</option>
      <option value="0">Present as healed scars</option>
      <option value="0">Absent</option>
	</select>
	
	
	<div class="clear"></div>

<h4></h4>

<label>B)Uterus</label> 
   <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
     <option value="0">Palpable per abdomen</option>
      <option value="0">Not palpable per abdomen</option>
	</select>

<label>Uterus Remarks </label>
<textarea rows="4" cols="50">

</textarea>
	
	<h4>C)Vagina</h4>


<label>Labia</label>

   <select name="" id="" class=""  validate="">
    <option value="0">Select</option> 
     <option value="0">Swollen</option>
      <option value="0">Not swollen</option>
      
	</select>


	<label>Labial tenderness</label>

   <select name="" id="" class=""  validate=""> 
    <option value="0">Select</option>
     <option value="0">Present</option>
      <option value="0">Absent</option>
	</select>

<div class="clear"></div>

<label>Injuries to labia</label>

   <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
	 <option value="0">Present</option>
	  <option value="0">Absent</option>
	</select>

<label>Remarks of labia</label>
<textarea rows="4" cols="50">

</textarea>

<div class="clear"></div>
<div class="clear"></div>
	
	<label>Vagina</label>

   <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
     <option value="0">Capacious and relaxed </option>
      <option value="0">Non-capacious with normal tone</option>
	</select>


<div class="clear"></div>
	

<label>Vagina Injuries</label>

   <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
    <option value="0">Present</option>
    <option value="0">Absent</option>
    
	</select>

<label>Remarks Injuries </label>
<textarea rows="4" cols="50">

</textarea>



<div class="clear"></div>


<h4>Cervix </h4>

<label>Cervical lips </label>

   <select name="" id="" class=""  validate=""> 
    <option value="0">Select</option>
    <option value="0">Soft and swollen</option>
    <option value="0">Firm</option>
    
    
	</select>
	
	 
<label>Cervical mucus plug</label>

   <select name="" id="" class=""  validate=""> 
    <option value="0">Select</option>
     <option value="0">Present</option>
      <option value="0">Absent</option>
	</select>
 
 <label>External Os</label>

   <select name="" id="" class=""  validate=""> 
    <option value="0">Select</option>
     <option value="0">Closed</option>
      <option value="0">Open</option>
       <option value="0">Admits one finger</option>
        <option value="0">Admits two fingers</option>
	</select>		

<div class="clear"></div>

 <label>Cervix Injuries</label>

   <select name="" id="" class=""  validate=""> 
    <option value="0">Select</option>
    <option value="0">Present</option>
    <option value="0">Absent</option>
	</select>	

<label>Remarks Cervix</label>
<textarea rows="4" cols="50">

</textarea>
 <div class="clear"></div>
 <div class="clear"></div>
	
 <label>Lochia discharge at Os</label>

   <select name="" id="" class=""  validate="">  
    <option value="0">Select</option>
    <option value="0">Lochia rubra</option>
    <option value="0">Lochia serosa</option>
    <option value="0">Lochis alba</option>
	</select>	

<div class="clear"></div>

<label>Systemic examination findings</label>
<textarea rows="4" cols="50">

</textarea>
	
	<div class="clear"></div>
	<div class="clear"></div>
   <div class="clear"></div>
	<h4>Laboratory examinations</h4>
	<label>Urine for pregnancy test</label>
 <select name="" id="" class=""  validate="">  
    <option value="0">Select</option>
    <option value="0">Positive  </option>
    <option value="0">Negative</option>
  
	</select>	

<div class="clear"></div>
   <div class="clear"></div>
 

	<label>USG Abdomen</label>
<input type="text"  name="name" id="name">


	<label>Any other</label>
<input type="text"  name="name" id="name">
	
	
	
<div class="clear"></div>



<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>


<input type="button" name="Submit" id="Submit" value="Submit"
	class="buttonBig"
	onClick="submitForm(' ','?method=t');"
	accesskey="a" tabindex=1 />
	
	

	
	
	</form>







