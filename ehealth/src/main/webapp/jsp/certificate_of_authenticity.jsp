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
<h2>Certificate Of Authenticity </h2>
</div>
<div class="clear"></div>
 
<form name="authenticity" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
 
<div class="Block">

<label>Insurance Company</label>
<input type="text" name="insucomName" id="insucomName" />

<label>Reference Policy/Claim No.</label>
<input type="text" name="policyclaimNo." id="policyclaimNo." />

<label>Postmortem Number</label>
<input type="text" name="postNo." id="postNo." />

<div class="clear"></div>

<label>Date</label> 
<input type="text" class="date"	name="<%=FROM_DATE%>" id="fromDateId" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.authenticity.<%=FROM_DATE%>,event)" />
 
<label>Name of the deceased:</label>
<input type="text" name="decease" id="decease" />
 
<label>Age</label>
<input type="text" name="age" id="age" />

<div class="clear"></div>

<label>Sex</label>
<select class="mediumm"  name="gender">
<option value="0">Select</option>
<option value="1">Male</option>
<option value="2">Female</option>
</select>
 
<label>Address(as recorded in Postmortem Certificate):</label>
<textarea name="address" id="address"></textarea>
 
<label>Ref.Crime No</label>
<input type="text" name="refcrimeNo." id="refcrimeNo." /> 

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<label>Police Station</label>
<input type="text" name="policestation" id="policestation" />
 
<label>Name of Doctor</label>
<input type="text" name="doctor" id="doctor" /> 
 
<label>Designation of Doctor</label>
<input type="text" name="designation" id="designation" />

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
</div>

<div class="paddingTop15"></div>
<div class="clear"></div>

<input class="buttonBig" type="button" onclick="submitForm('authenticity','opd?method=certificateOfAuthenticityJsp');" value="Generate Report" name="submit">

 <input class="buttonBig" type="reset" accesskey="r" onclick="location.reload();" value="Cancel" name="Reset">

</form>