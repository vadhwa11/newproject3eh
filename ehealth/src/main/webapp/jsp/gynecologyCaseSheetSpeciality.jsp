<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript">
	<%	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
%>
<form method="post" action="" name="gynecologyCaseSheet" >
<input id="gynecologyCaseSheetFlag" name="gynecologyCaseSheetFlag" tabindex="1" value="Gynecology Case Sheet" type="hidden"  />
<div class="Block">

<div class="clear"></div>
<div class="paddingTop5"></div>
<label>Presenting Complaints</label>
<textarea rows="" cols="" name="presentComplaints" maxlength="250" onkeyup="return checkLength(this)" class="textareaMediua"> </textarea>

<label>History of present Illness</label>
<textarea rows="" cols="" name="historyOfPresentIllness" maxlength="250" onkeyup="return checkLength(this)" class="textareaMediua"> </textarea>

<label>History Menarche</label>
<textarea rows="" cols="" name="historyMenarche" maxlength="250" onkeyup="return checkLength(this)" class="textareaMediua"> </textarea>
<div class="clear"></div>
<label>Menstrual Cycle</label>
<textarea rows="" cols="" name="menstrualCycle" maxlength="250" onkeyup="return checkLength(this)" class="textareaMediua"> </textarea>

<label>Dysmenorrhoea</label>
<textarea rows="" cols="" name="dysmenorrhoea" maxlength="250" onkeyup="return checkLength(this)" class="textareaMediua"> </textarea>

<div class="clear"></div>
<label>LMP1</label>
<input type="text" class="date" id="lmpOne" validate="LMP,date,yes" value="" name="lmpOne"	 readonly="readonly" MAXLENGTH="30"  /> 
<img src="/hms/jsp/images/cal.gif" 	width="16" height="16" border="0" onClick="setdate('',document.getElementById('lmpOne'),event);" /> 

<label>LMP2</label>
<input type="text" class="date" id="lmpTwo" validate="LMP,date,yes" value="" name="lmpTwo"	readonly="readonly" MAXLENGTH="30"  /> 
<img src="/hms/jsp/images/cal.gif" 	width="16" height="16" border="0" onClick="setdate('',document.getElementById('lmpTwo'),event);" /> 

<div class="clear"></div>
<label>Menopause</label>
<input type="text" name="menopause" id="menopause" value=""  maxlength="128" validate="Menopause,string,no"/>

 <label class="heightAuto">Maritral and Obstetrics History</label>
<textarea rows="" cols="" name="maritralAndObstetricsHistory" maxlength="250"  onkeyup="return checkLength(this)" class="textareaMediua"> </textarea>
 
<div class="clear"></div>
<h4>Past Medical History</h4>
<label style="width:40px;">HTN</label>
<input type="checkbox" name="htn" id="htn" value="Yes" class="checkboxMargin"/>
<label class="medium">Diabetes</label>
<input type="checkbox" name="diabetes" id="diabetes" value="Yes" class="checkboxMargin"/>
<label class="medium">Renal Disease</label>
<input type="checkbox" name="renalDisease" id="renalDisease" value="Yes" class="checkboxMargin"/>
<label style="width:40px;">TB</label>
<input type="checkbox" name="tb" id="tb" value="Yes" class="checkboxMargin"/>
<label class="medium">Others</label>
<input type="checkbox" name="others" id="others" value="Yes" class="checkboxMargin" />
<label class="medium">Angina</label>
<input type="checkbox" name="angina" id="angina" value="Yes" class="checkboxMargin"/>
<label style="width:40px;">MI</label>
<input type="checkbox" name="mi" id="mi" value="Yes" class="checkboxMargin"/>
<label class="medium">Allergies</label>
<input type="checkbox" name="allergies" id="allergies" value="Yes" class="checkboxMargin"/>
<label class="medium">Drugs</label>
<input type="checkbox" name="drugs" id="drugs" value="Yes" class="checkboxMargin"/>
<label class="auto">Bronchial Asthma</label>
<input type="checkbox" name="bronchialAsthma" id="bronchialAsthma" value="Yes" class="checkboxMargin"/>
<div class="clear"></div>
<div class="paddingTop5"></div>

<label>Other Specify</label>
<textarea class="textareaMediua" rows="" cols="" name="otherSpecify" maxlength="250" validate="Other Specify,string,no"  onkeyup="return checkLength(this)"></textarea>
<label>Surgical History</label>
<textarea class="textareaMediua" rows="" cols="" name="surgicalHistory" maxlength="250"  onkeyup="return checkLength(this)"></textarea>
<label>Family History</label>
<textarea class="textareaMediua" rows="" cols="" name="familyHistoryAnother"  maxlength="250"  onkeyup="return checkLength(this)"></textarea>
<div class="clear"></div>

<label>General Exam</label>
<textarea class="textareaMediua" rows="" cols="" name="generalExam"  maxlength="250" onkeyup="return checkLength(this)"></textarea>
<label>Local Examination</label>
<textarea class="textareaMediua" rows="" cols="" name="localExaminationAnother"  maxlength="250"   onkeyup="return checkLength(this)"></textarea>
<label>P/A</label>
<textarea class="textareaMediua" rows="" cols="" name="pa"  maxlength="250"   onkeyup="return checkLength(this)"></textarea>
<div class="clear"></div>

<label>P/S</label>
<textarea class="textareaMediua" rows="" cols="" name="ps"  maxlength="250"  onkeyup="return checkLength(this)"></textarea>
<label>P/V</label>
<textarea class="textareaMediua" rows="" cols="" name="pv"  maxlength="250"  onkeyup="return checkLength(this)"></textarea>
<label>P/R</label>
<textarea class="textareaMediua" rows="" cols="" name="pr"  maxlength="250"   onkeyup="return checkLength(this)"></textarea>
<div class="clear"></div>

<label>Services</label>
<textarea class="textareaMediua" rows="" cols="" name="services"  maxlength="250"   onkeyup="return checkLength(this)"></textarea>
<label>Follow up</label>
<textarea class="textareaMediua" rows="" cols="" name="followUp"  maxlength="250"   onkeyup="return checkLength(this)"></textarea>
<div class="clear"></div>

<label>On</label>
<input type="text" name="onValue" id="onValue" value=""  maxlength="128" validate="Menopause,string,no"/>
<label>Signed By </label>
<input type="text" name="signedBy" id="signedBy" value=""  maxlength="128" validate="Menopause,string,no"/>

</div>
</form>

<style>
.widthH4{min-width:170px; float:left;}
.width85{width:85px;}
</style>






