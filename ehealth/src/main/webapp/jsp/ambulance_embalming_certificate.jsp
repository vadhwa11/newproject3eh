<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


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
	</script>  
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>	
	
	<% 
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	 	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	  
	%>
 
<div class="titleBg">
<h2>AMBULANCE /CREMATION/BURIAL/EMBALMING CERTIFICATE </h2>
</div>
<div class="clear"></div>
 
<form name="ambembcert" method="post">
<div class="clear"></div>
 
<div class="Block">

<label>Name</label>
<input type="text" name="name" id="name" />
 
<label>Sex</label>
<select class="mediumm"  name="gender">
<option value="0">Select</option>
<option value="1">Male</option>
<option value="2">Female</option>
</select>

<label>Age</label>
<input type="text" name="age" id="age" />

<div class="clear"></div>
 
<label>Crime No.</label>
<input type="text" name="crimeNo." id="crimeNo." />

<label>Police Station</label>
<input type="text" name="policestation" id="policestation" />

<label>Date</label> 
<input type="text" class="date"	name="<%=FROM_DATE%>" id="fromDateId" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.authenticity.<%=FROM_DATE%>,event)" />
 
<div class="clear"></div>

<label>Time</label>
<input type="text" name="time" id="time" />

<label>Embal.Fluid Ingredients</label>
<input type="text" name="fluid" id="fluid" />

<div class="clear"></div>


<label>Place From</label>
<input type="text" name="placefrom" id="placefrom" />

<label>Place To</label>
<input type="text" name="placeto" id="placeto" />
 
<div class="clear"></div>
<div class="clear"></div>
 
</div>

<div class="paddingTop15"></div>
<div class="clear"></div>

<input class="buttonBig" type="button" onclick="submitForm('ambembcert','opd?method=ambulanceEmbalmingCertificateJsp');" value="Generate Report" name="submit">

 <input class="buttonBig" type="reset" accesskey="r" onclick="location.reload();" value="Cancel" name="Reset">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>