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
		 serverdate = '<%=date+"/"+month+"/"+year%>';
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
<h2>VICTIM ALLEGED TO HAVE BEEN DRUGGED</h2>
</div>
<div class="clear"></div>
 
<form name="druggedcert" method="post">

<div class="clear"></div>
<div class="Block">

<label>Requisition Received From</label>
<input type="text" name="reqname" id="reqname" />
 
<label>Police Station</label>
<input type="text" name="policestation" id="policestation" />

<label>Date</label> 
<input type="text" class="date"	name="<%=FROM_DATE%>" id="fromDateId" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.authenticity.<%=FROM_DATE%>,event)" />
 
<div class="clear"></div>
 
 <label>Examination & Certif. Of</label>
<input type="text" name="certi" id="certi" />
 
<label>Age</label>
<input type="text" name="age" id="age" />

<div class="clear"></div>
<div class="clear"></div>

<label>Name :</label>
<input type="text" name="name" id="name" />
 
 <label>Age :</label>
<input type="text" name="age2" id="age2" />

<label>Sex :</label>
<select class="mediumm"  name="sex">
<option value="0">Select</option>
<option value="1">Male</option>
<option value="2">Female</option>
</select>

<div class="clear"></div>

<label>Address:</label>
<textarea name="address" id="address"></textarea>
 
<label>Consent:</label>
<textarea name="consent" id="consent"></textarea> 

<label>Examination Date</label> 
<input type="text" class="date"	name="exdate" id="exdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.authenticity.exdate,event)" />
 
 <div class="clear"></div>
 <div class="clear"></div>
 <div class="clear"></div>
 
<label>Examination Time</label>
<input type="text" name="extime" id="extime" />

<label>Identification Marks :</label>
 <input type="text" name="marks1" id="marks1" />
 <input type="text" name="marks2" id="marks2" />
 
 <div class="clear"></div>

<h4>History :</h4>
<label>Alleged Incident Date</label> 
<input type="text" class="date"	name="aidate" id="exdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.druggedcert.aidate,event)" />
  
<label>Alleged Incident Time</label>
<input type="text" name="aitime" id="aitime" />

<label>Regarding Mode Of Admin.</label>
<input type="text" name="mode" id="mode" />

 <div class="clear"></div>
   
<label>Loss Of Consciousness :</label>
<select class="mediumm"  name="loss">
<option value="0">Yes</option>
<option value="1">No</option>
<option value="1">Can't Remember</option>
</select> 

<label>PeriodOfUnconsciousness:</label>
<input type="text" name="perioduncons" id="perioduncons" />

<label>PointOfAdminToRecovery :</label>
<select class="mediumm"  name="recovery">
<option value="0">Select</option>
<option value="1">Yes</option>
<option value="2">No</option>
</select>

<div class="clear"></div>

<label>HappeningDuringThatPeriod</label>
<select class="mediumm"  name="happening">
<option value="0">Select</option>
<option value="1">Yes</option>
<option value="2">No</option>
</select>

<label>Any Sequel To Make Out:</label>
<input type="text" name="sequel" id="sequel" />

 
<h4>General Examination:</h4>
<label>Clothing</label>
<select class="mediumm"  name="cloth">
<option value="0">In Proper Order</option>
<option value="1">Disordered</option>
</select>

<label>Level Of Unconsciousness :</label>
<select class="mediumm"  name="levelofuncons">
<option value="0">Conscious</option>
<option value="1">Semiconscious</option>
<option value="2">Unconscious</option>
</select>
 
<label>Alertness :</label>
<select class="mediumm"  name="alertness">
<option value="0">Alert</option>
<option value="1">Drowsy</option>
<option value="2">Stuperous</option>
</select>

<label>General Disposition</label>
<select class="mediumm"  name="disposition">
<option value="0">Calm</option>
<option value="1">Anxious</option>
<option value="2">Depressed</option>
</select>

<label>Speech</label>
<select class="mediumm"  name="speech">
<option value="0">Normal</option>
<option value="1">Thick and Slurred</option>
<option value="2">Incoherrent</option>
</select>
 

<label>Memory(Recent/Remote) :</label>
<select class="mediumm"  name="memory">
<option value="0">Normal</option>
<option value="1">Impaired</option>
</select>

<label>OrientOfTimePlacePerson</label>
<select class="mediumm"  name="space">
<option value="0">Normal</option>
<option value="1">Impaired</option>
</select>

<label>Reaction Time :</label>
<select class="mediumm"  name="retime">
<option value="0">Normal</option>
<option value="1">Delayed</option>
</select>

<h4>Physical Examination :</h4>

<label>Height :</label>
<input type="text" name="height" id="height" />

<label>Weight :</label>
<input type="text" name="weight" id="weight" />


<label>Build & Nourishment :</label>
<select class="mediumm"  name="build">
<option value="0">Good</option>
<option value="1">Moderate</option>
<option value="1">Poor</option>
</select>

<label>Conjuntiva :</label>
<select class="mediumm"  name="conjuntiva">
<option value="0">Normal</option>
<option value="1">Congested</option>
</select>

<label>Pupils :</label>
<select class="mediumm"  name="pupils">
<option value="0">Pinpoint</option>
<option value="1">Constricted</option>
<option value="2">Normal</option>
<option value="2">Dialated</option>
<option value="2">Sluggishly Reacting</option>
</select>

<label>Nostrils :</label>
<input type="text" name="nostrils" id="nostrils" />

<label>Mucosa :</label>
<input type="text" name="mucosa" id="mucosa" />

<label>Lips :</label>
<input type="text" name="lips" id="lips" />

<label>Oral Cavity :</label>
<input type="text" name="cavity" id="cavity" />

<label>Circum-Oral Regions :</label>
<input type="text" name="circum" id="circum" />

<label>MarksOfInjectionOnBody :</label>
<input type="text" name="inject" id="inject" />
 
<label>Muscular Co-ordination :</label>
<select class="mediumm"  name="muscular">
<option value="0">Normal</option>
<option value="1">Impaired</option>
</select>

<label>Reflaxes :</label>
<select class="mediumm"  name="reflaxes">
<option value="0">Normal</option>
<option value="1">Exaggerated</option>
<option value="1">Sluggish</option>
</select>
 
<label>Romberg's sign :</label>
<select class="mediumm"  name="romberg">
<option value="0">Positive</option>
<option value="1">Negative</option>
</select>

<label>Finger Nose Test :</label>
<select class="mediumm"  name="finger">
<option value="0">Positive</option>
<option value="1">Negative</option>
</select>

<label>Gait :</label>
<select class="mediumm"  name="gait">
<option value="0">Normal</option>
<option value="1">Unsteady</option>
</select>
 
<h4>System Examination Findings :</h4>
<div class="clear"></div>
<div class="clear"></div>

<label>Pulse :</label>
<input type="text" name="pulse" id="pulse" />

<label>B.P. :</label>
<input type="text" name="bp" id="bp" />
 
<label>Injuries on Body :</label>
<input type="text" name="injury" id="injury" />


<label>Any Other Findings :</label>
<input type="text" name="other" id="other" />

<label>Laboratory Examination :</label>
<input type="text" name="labex" id="labex" />
 
<label>Nasal Swabs :</label>
<select class="mediumm"  name="nasal">
<option value="0">Preserved</option>
<option value="1">Not Applicable</option>
</select>

<label>Stomach Aspirate :</label>
<select class="mediumm"  name="stomach">
<option value="0">Preserved</option>
<option value="1">Not Preserved</option>
</select>

<label>Urine :</label>
<select class="mediumm"  name="urine">
<option value="0">Preserved</option>
<option value="1">Not Preserved</option>
</select>
 
<div class="clear"></div>
<div class="clear"></div>

</div>

<div class="paddingTop15"></div>
<div class="clear"></div>

<input class="buttonBig" type="button" onclick="submitForm('druggedcert','opd?method=druggedMlcJsp');" value="Generate Report" name="submit">

 <input class="buttonBig" type="reset" accesskey="r" onclick="location.reload();" value="Cancel" name="Reset">


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>