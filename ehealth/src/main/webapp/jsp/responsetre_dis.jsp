<!DOCTYPE html>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
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

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);


%>	

<div class="titleBg">
<h2>TREATMENT / DISCHARGE CERTIFICATE</h2>
</div>
<form name="treatment" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="Block">


<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text" id="hinNo." name="<%=HIN_NO%>"
	validate="HIN,string,yes" value="" MAXLENGTH="20"
	onblur="getVisitNo('treatment','opd?method=getVisitIdList')" />



<label>Name</label>
<input type="text"  name="name" id="name">

<label>Sex</label>
<input type="text"  name="name" id="name">

<label>Age</label>
<input type="text"  name="name" id="name">


<div class="clear"></div>

<div class="clear"></div>

<label>Address</label>
<textarea rows="4" cols="50">

</textarea>

<label>IP No</label>
<input type="text"  name="name" id="name">


<label>Date of admission</label>
<input 	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.birth.<%=FROM_DATE%>,event);" />
	
<div class="clear"></div>

<label>Date of discharge</label>
<input 	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.birth.<%=FROM_DATE%>,event);" />
	
	


<label>Doctor Name</label>
 <select name="" id="" class=""  validate="">
    <option value="0">Select</option>
	</select>
	

<label>Condition at admission</label>
<textarea rows="4" cols="50">

</textarea>

<div class="clear"></div>



<label>Investigations Results </label>
<textarea rows="4" cols="50">

</textarea>

<label>Wound Certificate</label>
<textarea rows="4" cols="50">

</textarea>



<label>Treatment Details</label>
<textarea rows="4" cols="50">

</textarea>


<div class="clear"></div>

<label>Condition at discharge</label>
<textarea rows="4" cols="50">

</textarea>

<label>Advise For  further treatment</label>
<textarea rows="4" cols="50">

</textarea>

<label>Remarks</label>
<textarea rows="4" cols="50">

</textarea>




<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>


<input type="button" name="Submit" id="Submit" value="Submit"
	class="buttonBig"
	onClick="submitForm(' ','?method=t');"
	accesskey="a" tabindex=1 />
	
	

	
	
	</form>



