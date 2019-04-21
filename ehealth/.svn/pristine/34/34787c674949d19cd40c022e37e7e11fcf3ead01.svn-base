<!DOCTYPE html>
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
<h2> CAUSE OF DEATH</h2>
</div>
<form name="caudetah" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="Block">


<label>Name</label>
<input type="text"  name="name" id="name">

<label>Police Station</label>
<input type="text"  name="name" id="name">

<label>Date</label>
<input 	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"	readonly="readonly" />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.birth.<%=FROM_DATE%>,event);" />

<div class="clear"></div>

<label>Name</label>
<input type="text"  name="name" id="name">

<label>Sex</label>
<input type="text"  name="name" id="name">

<label>Age</label>
<input type="text"  name="name" id="name">


<div class="clear"></div>

<label>Crime No</label>
<input type="text"  name="name" id="name">
<label>Police Station</label>
<input type="text"  name="name" id="name">

<label>P.C. No</label>
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



<label>Ca NO.</label>
<input type="text"  name="name" id="name">

<label>Date</label>
<input 	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.birth.<%=FROM_DATE%>,event);" />
	
	

<label>ON Date</label>
<input 	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.birth.<%=FROM_DATE%>,event);" />
	
<div class="clear"></div>

<label>Laboratory Findings</label>
<textarea rows="4" cols="50">

</textarea>




<label>Opinion</label>
<textarea rows="4" cols="50">

</textarea>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>


<input type="button" name="Submit" id="Submit" value="Submit"class="buttonBig"
	onClick="submitForm(' ','?method=t');"
	accesskey="a" tabindex=1 />
	
	</form>







