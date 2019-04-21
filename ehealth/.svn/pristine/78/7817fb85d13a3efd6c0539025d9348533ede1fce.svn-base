
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * title.jsp  
 * Purpose of the JSP -  This is for Title.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 14th April,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <%-- <h4><span><%=message %></span></h4> --%>
		 <%} %> 
<div class="titleBg">
<h2>Oral Medicine Case Record</h2>
</div>
<form name="title" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="clear"></div>
<div class="Block">
<input id="oralFlag" name="oralFlag" tabindex="1" value="oralMedicine" type="hidden"  />
<input type="hidden" name="templateName" value="Oral Medicine"/>

<label>Presenting Complaints</label> 
<input id="presentingComplaints" type="text" name="presentingComplaints" value="" class="textbox_size20" maxlength="128">

<label class="auto"> History of Presenting Complaint </label> 
<input type="text" name="historyOfPresentingComplaint" value="" class="textbox_size20" style="width:157px;" maxlength="128">

<div class="clear"></div>
<label class="auto">Past Medical & Dental History</label> 
<input type="text" name="pastMedicalDentalHistory" value="" class="textbox_size20"  style="width:170px;" maxlength="128">

<label>Family History </label> 
<input type="text" name="familyHistoryOne" value="" class="textbox_size20" maxlength="128">

<div class="clear"></div>
<label>Personal & Social History </label> 
<input type="text" name="personalSocialHistory" value="" class="textbox_size20" maxlength="128">

<div class="clear"></div>
<h4>Habits</h4>
<label>Dietary Habits</label> 
<input type="text" name="dietaryHabits" value="" class="textbox_size20" maxlength="128">

<label>Brushing Habits </label> 
<input type="text" name="brushingHabits" value="" class="textbox_size20" maxlength="128">
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="tableForNumbers">
<table>
<tr>
<th>Habit</th>
<th>Smoking</th>
<th>Smokeless Tobacco </th>
<th>Alcohol</th>
</tr>
<tr>
<td>1. Do You Currently use...?</td>
<td>
<div class="yesNo">Yes <input type="radio" name="SmokingCurrently" value="Yes" /></div>
<div class="yesNo">No <input type="radio" name="SmokingCurrently" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio" name="Smokeless" value="Yes" /></div>
<div class="yesNo">No <input type="radio" name="Smokeless" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio" name="Alcohol" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="Alcohol" value="No" /></div>
</td>
</tr>

<tr>
<td>2. Have you used daily in the past?</td>
<td>
<div class="yesNo">Yes <input type="radio" name="Smokingdaily" value="Yes" /></div>
<div class="yesNo">No <input type="radio" name="Smokingdaily" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio" name="Smokelessdaily" value="Yes" /></div>
<div class="yesNo">No <input type="radio" name="Smokelessdaily" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio" name="Alcoholdaily" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="Alcoholdaily" value="No" /></div>
</td>
</tr>
<tr>
<td>3. In the past have you used .. (frequency)..?</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="Smokingfrequency" value="Yes"/></div>
<div class="yesNo">No <input type="radio"	name="Smokingfrequency" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="Smokelessfrequency" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="Smokelessfrequency" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="Alcoholfrequency" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="Alcoholfrequency" value="No" /></div>
</td>
</tr>
<tr>
<th colspan="4" align="left">[Currently daily users]</th>
</tr>
<tr>
<tr>
<td>4. How old were you when you started using daily?</td>
<td><input type="text" name="SmokingDailyStartAge"  onblur="dataAge(this.value,this.id);"  id="SmokingDailyStartAge" value=""   class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)" ></td>
<td><input type="text" name="SmokelessDailyStartAge" onblur="dataAge(this.value,this.id);" id="SmokelessDailyStartAge" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)" ></td>
<td><input type="text" name="AlcoholDailyStartAge" onblur="dataAge(this.value,this.id);"  id="AlcoholDailyStartAge" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)" ></td>
</tr>
<tr>
<td>5. How many years ago did you first start using daily?</td>
<td><input type="text" name="SmokingDailyStartYear" id="SmokingDailyStartYear" onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="SmokelessDailyStartYear" id="SmokelessDailyStartYear" onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="AlcoholDailyStartYear" id="AlcoholDailyStartYear" onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
</tr>
<tr>
<td>6. On an average how many products do you currently use daily? <br>&nbsp; &nbsp; &nbsp;
Also let me know if you use the product but not daily</td>
<td><input type="text" name="SmokingDailyProduct"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="SmokelessDailyProduct" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="AlcoholDailyProduct" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
</tr>
<tr>
<td>7. How soon after you wake up do you have your first smoke / chewing-tobacco/drink?</td>
<td><input type="text" name="SmokingAfterWakeup" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="SmokelessAfterWakeup" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="AlcoholAfterWakeup" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
</tr>

<tr>
<th colspan="4" align="left">[Currently less than daily users]</th>
</tr>
<tr>
<td>8. How old were you when you started using daily?</td>
<td><input type="text" name="SmokingLessDailyStartAge"  id="SmokingLessDailyStartAge"  onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="SmokelessLessDailyStartAge" id="SmokelessLessDailyStartAge" onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="AlcoholLessDailyStartAge"  id="AlcoholLessDailyStartAge" onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
</tr>
<tr>
<td>9. How many years ago did you first start using daily?</td>
<td><input type="text" name="SmokingLessDailyStartYear" id="SmokingLessDailyStartYear" onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="SmokelessLessDailyStartYear" id="SmokelessLessDailyStartYear" onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="AlcoholLessDailyStartYear" id="AlcoholLessDailyStartYear" onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
</tr>
<tr>
<td>10. On an average how many of the following products do you use in a usual week?</td>
<td><input type="text" name="SmokingLessDailyProduct" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="SmokelessLessDailyProduct" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="AlcoholLessDailyProduct" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
</tr>
<tr>
<th colspan="4" align="left">[Former users]</th>
</tr>
<tr>
<td>11. How old were you when you started using daily?</td>
<td><input type="text" name="SmokingDailyStartAgeFormer" id="SmokingDailyStartAgeFormer" onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="SmokelessDailyStartAgeFormer" id="SmokelessDailyStartAgeFormer" onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="AlcoholDailyStartAgeFormer" id="AlcoholDailyStartAgeFormer" onblur="dataAge(this.value,this.id);"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
</tr>
<tr>
<td>12. How many years ago did you first start using daily?</td>
<td><input type="text" name="SmokingDailyStartYearFormer" id="SmokingDailyStartYearFormer" onblur="dataAge(this.value,'SmokingDailyStartYearFormer');"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="SmokelessDailyStartYearFormer" id="SmokelessDailyStartYearFormer" onblur="dataAge(this.value,'SmokelessDailyStartYearFormer');"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="AlcoholDailyStartYearFormer" id="AlcoholDailyStartYearFormer" onblur="dataAge(this.value,'AlcoholDailyStartYearFormer');"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
</tr>
<tr>
<td>13. How long has it been since you stopped using?</td>
<td><input type="text" name="SmokingStopYearFormer"  id="SmokingStopYearFormer" onblur="dataAge(this.value,'SmokingStopYearFormer');"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="SmokelessStopYearFormer" id="SmokelessStopYearFormer"onblur="dataAge(this.value,'SmokelessStopYearFormer');"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="AlcoholStopYearFormer"  id="AlcoholStopYearFormer" onblur="dataAge(this.value,'AlcoholStopYearFormer');"  value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
</tr>
<tr>
<td>14. Have you visited a doctor / health care provider (HCP) in the past 12 months,<br>&nbsp; &nbsp; &nbsp;
for any reason of personal health?</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="SmokingVisitedDoctorFromer" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="SmokingVisitedDoctorFromer" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="SmokelessVisitedDoctorFromer" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="SmokelessVisitedDoctorFromer" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="AlcoholVisitedDoctorFromer" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="AlcoholVisitedDoctorFromer" value="No" /></div>
</td>
</tr>
<tr>
<td>15. How many times did you visit a doctor/HCP in the past 12 months?</td>
<td><input type="text" name="SmokingNoVisitedDoctorFromer" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="SmokelessNoVisitedDoctorFromer" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="AlcoholNoVisitedDoctorFromer" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
</tr>
<tr>
<td>16. During any visit to a doctor/HCP in the past 12 months were you asked if you use...?</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="docotr" value="Yes" /></div>
<div class="yesNo">No <input type="radio" name="docotr" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="docotrr" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="docotrr" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="docotrrr" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="docotrrr" value="No" /></div>
</td>
</tr>
<tr>
<td>17. During any visit to a doctor/HCP were you advised to quit tobacco ?</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="visit" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="visit" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="visitt" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="visitt" value="No" /></div>
</td>
<td>
<input type="hidden"	name="visittt" value="Yes" />
 <input type="hidden"	name="visittt" value="No" />
</td>
</tr>
<tr>
<td>18. During the past 12 months, did you use any of the following to try to stop using...?</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="any" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="any" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="anyy" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="anyy" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="anyyy" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="anyyy" value="No" /></div>
</td>
</tr>
<tr>
<th colspan="4" align="left">Cessation</th>
</tr>
<tr>
<td>1. During the past 12 months have you tried to stop...?</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="cessation" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="cessation" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="cessationn" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="cessationn" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="cessationnn" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="cessationnn" value="No" /></div>
</td>
</tr>
<tr>
<td>2.Thinking about the last time you tried to quit how long did you stop?</td>
<td><input type="text" name="SmokingQuitPeriod" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="SmokelessQuitPeriod" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
<td><input type="text" name="AlcoholQuitPeriod" value="" class="textbox_size20"  maxlength="5" onPaste="return false" type="text" onkeypress="javascript:return isNumber(event)"></td>
</tr>
<tr>
<td>3. During the past 12 months, did you use any of the following to try to stop using...</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="SmokingTryStopUsing" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="SmokingTryStopUsing" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="SmokelessTryStopUsing" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="SmokelessTryStopUsing" value="No" /></div>
</td>
<td>
<div class="yesNo">Yes <input type="radio"	name="AlcoholTryStopUsing" value="Yes" /></div>
<div class="yesNo">No <input type="radio"	name="AlcoholTryStopUsing" value="No" /></div>
</td>
</tr>
<tr>
<td>4. Which of the following best describes your thinking about quitting smoking?</td>
<td><input type="text" name="SmokingTryQuitting" value="" class="textbox_size20" maxlength="56" ></td>
<td><input type="text" name="SmokelessTryQuitting" value="" class="textbox_size20"  maxlength="56"></td>
<td><input type="text" name="AlcoholTryQuitting" value="" class="textbox_size20"  maxlength="56"></td>
</tr>
</table>
</div>

<div class="clear"></div>
<h4>Review of Systems </h4>
<label>Appetite </label>
<input type="text" name="Appetite" value="" class="textbox_size20" maxlength="128" >
<label>Weight loss steady gain</label>
<input type="text" name="WeightLossGain" value="" class="textbox_size20" maxlength="2" validate="WeightLossGain,num,no"  maxlength="128">
<div class="clear"></div>

<label>Indigestion </label>
<label class="wdth60">Regular</label> <input type="radio"	name="Indigestion" value="Regular" class="checkboxMargin" /> 
<label class="wdth60">Irregular</label> <input type="radio"	name="Indigestion" value="Irregular" class="checkboxMargin" />
<label>Bowels </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Bowels" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Bowels" value="No" class="checkboxMargin" />
<div class="clear"></div>

<label>Chest Pain </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="chestPain" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="chestPain" value="No" class="checkboxMargin" />
<label>Angina </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Angina" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Angina" value="No" class="checkboxMargin" />
<div class="clear"></div>

<label>Dyspnoea </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Dyspnoea" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Dyspnoea" value="No" class="checkboxMargin" />
<label>Orthopnoea </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Orthopnoea" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Orthopnoea" value="No" class="checkboxMargin" />
<div class="clear"></div>

<label>Oedema feet </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="OedemaFeet" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="OedemaFeet" value="No" class="checkboxMargin" />
<label>Cough </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Cough" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Cough" value="No" class="checkboxMargin" />
<div class="clear"></div>

<label>Haemoptysis </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Haemoptysis" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Haemoptysis" value="No" class="checkboxMargin" />

<label>Sputum</label>
<label class="wdth60">Yes</label>
<input type="radio"	name="Sputum" id="Sputum" value="Yes" class="checkboxMargin" onclick="dataSputumDiv(this.value);"/>
<label class="wdth60">No</label>   
<input type="radio"	name="Sputum" id="Sputum" value="No" class="checkboxMargin" onclick="dataSputumDiv(this.value);" />
<div class="clear"></div>

<div id="SputumDiv" style="display: none;">
<label>Colour</label>
<input type="text" name="SputumColour" value="" class="textbox_size20" maxlength="256" >
<label>Quantity</label>
<input type="text" name="SputumQuantity" value="" class="textbox_size20" maxlength="256" >
<div class="clear"></div>
<label>Smell</label>
<input type="text" name="SputumSmell" value="" class="textbox_size20"  maxlength="256" >
</div>


<div class="clear"></div>
<label>Vision </label>
<label class="wdth60">Normal</label> 
<input type="radio"	name="Vision" value="Normal" class="checkboxMargin" />
<label class="wdth60">Abnormal</label>  
<input type="radio"	name="Vision" value="Abnormal" class="checkboxMargin" />
<label>Hearing </label>
<label class="wdth60">Normal</label> 
<input type="radio"	name="Hearing" value="Normal" class="checkboxMargin" />
<label class="wdth60">Abnormal</label>  
<input type="radio"	name="Hearing" value="Abnormal" class="checkboxMargin" />
<div class="clear"></div>

<label>Micturition</label>
<label class="wdth60">Increased</label> 
<input type="radio"	name="Micturition"  id="Micturition"  value="Increased" class="checkboxMargin"  onclick="dataMicturitionDiv(this.value);"/>
<label class="wdth60">Normal</label>  
<input type="radio"	name="Micturition" id="Micturition"  value="Normal" class="checkboxMargin" onclick="dataMicturitionDiv(this.value);"/>
<label class="wdth60">Decreased</label>  
<input type="radio"	name="Micturition" id="Micturition"  value="Decreased" class="checkboxMargin" onclick="dataMicturitionDiv(this.value);"/>

<div id="MicturitionDiv" style="display: none;">
<label>Frequency</label>
<input type="text" name="MicturitionFrequency" value="" class="textbox_size20" onkeypress="javascript:return isNumber(event)" maxlength="2" validate="Micturition Frequency,num,no"  >
</div>
<!-- <div class="clear"></div>

<label>Frequency </label>
<input type="text" name="frequency" value="" class="textbox_size20"  > -->

<div class="clear"></div>
<label>Dysuria </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Dysuria" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Dysuria" value="No" class="checkboxMargin" />

<label>Haematuria </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Haematuria" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Haematuria" value="No" class="checkboxMargin" />
<div class="clear"></div>

<label>Nocturia </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Nocturia" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Nocturia" value="No" class="checkboxMargin" />
<div class="clear"></div>

<label>Period </label>
<input type="text" name="Period" value="" class="textbox_size20" onkeypress="javascript:return isNumber(event)" maxlength="2" validate="Period,num,no">
<label>Menarche </label>
<input type="text" name="Menarche" value="" class="textbox_size20" onkeypress="javascript:return isNumber(event)" maxlength="2" validate="Menarche,num,no">
<div class="clear"></div>

<label>Flow days </label>
<input type="text" name="FlowDays" value="" class="textbox_size20" onkeypress="javascript:return isNumber(event)" maxlength="2" validate="FlowDays,num,no">
<label>Menopause </label>
<input type="text" name="Menopause" value="" class="textbox_size20" onkeypress="javascript:return isNumber(event)" maxlength="2" validate="Menopause,num,no">
<div class="clear"></div>

<label>Hoarseness </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Hoarseness" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Hoarseness" value="No" class="checkboxMargin" />

<label>Sore throat </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="SoreThroat" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="SoreThroat" value="No" class="checkboxMargin" />

<div class="clear"></div>
<label>Epistaxis </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Epistaxis" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Epistaxis" value="No" class="checkboxMargin" />

<label>Frequent colds </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="FrequentColds" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="FrequentColds" value="No" class="checkboxMargin" />

<div class="clear"></div>
<label>Headache </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Headache" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Headache" value="No" class="checkboxMargin" />

<label>Vomiting </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Vomiting" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Vomiting" value="No" class="checkboxMargin" />

<div class="clear"></div>
<label>Fits </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="Fits" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="Fits" value="No" class="checkboxMargin" />
<div class="clear"></div>

<h4>General Examination</h4>
<div class="clear"></div>

<label>Developmental</label> 
<input type="text" name="Developmental" value="" class="textbox_size20" maxlength="128">


<label>Nutritional</label> 
<input type="text" name="Nutritional" value="" class="textbox_size20" maxlength="128">

<div class="clear"></div>
<label>Head</label> 
<input type="text" name="Head" value="" class="textbox_size20" maxlength="128">


<label>Skull </label> 
<input type="text" name="Skull" value="" class="textbox_size20" maxlength="128">

<div class="clear"></div>
<label>Eyes</label> 
<input type="text" name="Eyes" value="" class="textbox_size20" maxlength="128">

<label>Ears </label> 
<input type="text" name="Ears" value="" class="textbox_size20" maxlength="128">

<div class="clear"></div>
<label>Nose</label> 
<input type="text" name="Nose" value="" class="textbox_size20" maxlength="128">


<label>Skin </label> 
<input type="text" name="Skin" value="" class="textbox_size20" maxlength="128">

<div class="clear"></div>
<label>Hair</label> 
<input type="text" name="Hair" value="" class="textbox_size20" maxlength="128">


<label>Nails </label> 
<input type="text" name="Nails" value="" class="textbox_size20" maxlength="128">

<div class="clear"></div>
<label>Lymph nodes</label> 
<input type="text" name="LymphNodes" value="" class="textbox_size20" maxlength="128">

<h4>Extra Oral Examination</h4>

<label>Head</label> 
<input type="text" name="OralHead" value="" class="textbox_size20" maxlength="128">

<label>Facial form</label> 
<input type="text" name="OralFacialForm" value="" class="textbox_size20" maxlength="128">

<div class="clear"></div>
<label>Hair</label> 
<input type="text" name="OralHair" value="" class="textbox_size20" maxlength="128">


<label>Skin </label> 
<input type="text" name="OralSkin" value="" class="textbox_size20" maxlength="128">

<div class="clear"></div>
<label>Eyes</label> 
<input type="text" name="OralEyes" value="" class="textbox_size20" maxlength="128">


<label>Ears </label> 
<input type="text" name="OralEar" value="" class="textbox_size20" maxlength="128">

<div class="clear"></div>
<label>Nose</label> 
<input type="text" name="OralNose" value="" class="textbox_size20" maxlength="128">


<label>Throat </label> 
<input type="text" name="OralThroat" value="" class="textbox_size20" maxlength="128">


<div class="clear"></div>

<h4>Salivary Glands </h4>
<label>Palpable</label>
<input type="radio"	name="salivaryGlands" id="salivaryGlands" value="Palpable" class="checkboxMargin" onclick="dataSalivaryGlands(this.value);"/>
<label>Non-Palpable</label>   
<input type="radio"	name="salivaryGlands" id="salivaryGlands" value="NonPalpable" class="checkboxMargin" maxlength="128" onclick="dataSalivaryGlands(this.value);" />
<div id="salivaryGlandsDiv" style="display: none;">
<label style="width:133px;">Palpable</label>
<input type="text" name="PalpableTxt" value="" class="textbox_size20" maxlength="128">
</div>
<div class="clear"></div>
<label class="auto">Cranial Nerves Examination </label> 
<input type="text" name="OralCranialNervesExamination" value="" class="textbox_size20" maxlength="128" >

<label>Neck</label> 
<input type="text" name="OralNeck" value="" class="textbox_size20" maxlength="128">
<div class="clear"></div>
<label>TMJ</label> 
<input type="text" name="OralTmj" value="" class="textbox_size20" maxlength="128">


<h4>Description of Lymphadenopathy</h4>
<label class="auto">Submental and Submandibular</label>
<label style="width:39px;">Yes</label> 
<input type="radio"	name="SubmentalSubmandibular" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="SubmentalSubmandibular" value="No" class="checkboxMargin" />

<label>High Jugular </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="HighJugular" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="HighJugular" value="No" class="checkboxMargin" />

<div class="clear"></div>
<label>Mid Jugular </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="MidJugular" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="MidJugular" value="No" class="checkboxMargin" />

<label>Low Jugular </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="LowJugular" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="LowJugular" value="No" class="checkboxMargin" />

<div class="clear"></div>
<label>Posterior Jugular </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="PosteriorJugular" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="PosteriorJugular" value="No" class="checkboxMargin" />

<label>Tracheo Oesophageal </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="TracheoOesophageal" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="TracheoOesophageal" value="No" class="checkboxMargin" />
<div class="clear"></div>

<label>Superior Mediastinal </label>
<label class="wdth60">Yes</label> 
<input type="radio"	name="SuperiorMediastinal" value="Yes" class="checkboxMargin" />
<label class="wdth60">No</label>  
<input type="radio"	name="SuperiorMediastinal" value="No" class="checkboxMargin" />

<h4>Intra Oral Examination</h4>

<label>Mouth Opening</label>
<input type="text" name="MouthOpening" value="" class="textbox_size20" maxlength="128">
<div class="clear"></div>

<label>Oral hygiene status</label>

<label class="wdth60">Poor</label> 
<input type="radio"	name="OralHygieneStatus" value="Poor" class="checkboxMargin" />
<label class="wdth60">Fair</label>  
<input type="radio"	name="OralHygieneStatus" value="Fair" class="checkboxMargin" />
<label class="wdth60">Good</label>  
<input type="radio"	name="OralHygieneStatus" value="Good" style="margin-right:30px;" />

<label>Dentition Status</label>
<input type="text" name="DentitionStatus" value="" class="textbox_size20" maxlength="128">
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
  <tbody>
    <tr>
      <td><input name="data18" id="data18" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 18</td>
      <td><input name="data17" id="data17" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 17</td>
      <td><input name="data16" id="data16" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 16</td>
      <td><input name="data15" id="data15" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 15</td>
      <td><input name="data14" id="data14" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 14</td>
      <td><input name="data13" id="data13" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 13</td>
      <td><input name="data12" id="data12" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 12</td>
      <td><input name="data11" id="data11" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox"onclick="data();" > 11</td>
      <td><input name="data21" id="data21" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 21</td>
      <td><input name="data22" id="data22" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 22</td>
      <td><input name="data23" id="data23" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 23</td>
      <td><input name="data24" id="data24" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 24</td>
      <td><input name="data25" id="data25" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 25</td>
      <td><input name="data26" id="data26" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 26</td>
      <td><input name="data27" id="data27" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 27</td>
      <td><input name="data28" id="data28" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 28</td>
    </tr>
    <tr>
      <td><input name="data48" id="data48" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 48</td>
      <td><input name="data47" id="data47" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 47</td>
      <td><input name="data46" id="data46" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 46</td>
      <td><input name="data45" id="data45" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 45</td>
      <td><input name="data44" id="data44" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 44</td>
      <td><input name="data43" id="data43" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 43</td>
      <td><input name="data42" id="data42" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 42</td>
      <td><input name="data41" id="data41" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 41</td>
      <td><input name="data31" id="data31" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 31</td>
      <td><input name="data32" id="data32" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 32</td>
      <td><input name="data33" id="data33" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 33</td>
      <td><input name="data34" id="data34" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 34</td>
      <td><input name="data35" id="data35" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 35</td>
      <td><input name="data36" id="data36" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 36</td>
      <td><input name="data37" id="data37" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 37</td>
      <td><input name="data38" id="data38" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 38</td>
    </tr>
  </tbody>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="mltpSlect" style="display:none" id="dataDiv18">
<label class="auto">18</label>
<select id="teeth_18_value" name="teeth_18_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>				 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv17">
<label class="auto">17</label>
<select id="teeth_17_value" name="teeth_17_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv16">
<label class="auto">16</label>
<select id="teeth_16_value" name="teeth_16_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv15">
<label class="auto">15</label>
<select id="teeth_15_value" name="teeth_15_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv14">
<label class="auto">14</label>
<select id="teeth_14_value" name="teeth_14_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv13">
<label class="auto">13</label>
<select id="teeth_13_value" name="teeth_13_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv12">
<label class="auto">12</label>
<select id="teeth_12_value" name="teeth_12_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv11">
<label class="auto">11</label>
<select id="teeth_11_value" name="teeth_11_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv21">
<label class="auto">21</label>
<select id="teeth_21_value" name="teeth_21_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv22">
<label class="auto">22</label>
<select id="teeth_22_value" name="teeth_22_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv23">
<label class="auto">23</label>
<select id="teeth_23_value" name="teeth_23_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv24">
<label class="auto">24</label>
<select id="teeth_24_value" name="teeth_24_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv25">
<label class="auto">25</label>
<select id="teeth_25_value" name="teeth_25_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv26">
<label class="auto">26</label>
<select id="teeth_26_value" name="teeth_26_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv27">
<label class="auto">27</label>
<select id="teeth_27_value" name="teeth_27_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv28">
<label class="auto">28</label>
<select id="teeth_28_value" name="teeth_28_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv48">
<label class="auto">48</label>
<select id="teeth_48_value" name="teeth_48_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv47">
<label class="auto">47</label>
<select id="teeth_47_value" name="teeth_47_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv46">
<label class="auto">46</label>
<select id="teeth_46_value" name="teeth_46_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv45">
<label class="auto">45</label>
<select id="teeth_45_value" name="teeth_45_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv44">
<label class="auto">44</label>
<select id="teeth_44_value" name="teeth_44_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv43">
<label class="auto">43</label>
<select id="teeth_43_value" name="teeth_43_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv42">
<label class="auto">42</label>
<select id="teeth_42_value" name="teeth_42_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv41">
<label class="auto">41</label>
<select id="teeth_41_value" name="teeth_41_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv31">
<label class="auto">31</label>
<select id="teeth_31_value" name="teeth_31_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv32">
<label class="auto">32</label>
<select id="teeth_32_value" name="teeth_32_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv33">
<label class="auto">33</label>
<select id="teeth_33_value" name="teeth_33_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv34">
<label class="auto">34</label>
<select id="teeth_34_value" name="teeth_34_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv35">
<label class="auto">35</label>
<select id="teeth_35_value" name="teeth_35_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv36">
<label class="auto">36</label>
<select id="teeth_36_value" name="teeth_36_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv37">
<label class="auto">37</label>
<select id="teeth_37_value" name="teeth_37_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv38">
<label class="auto">38</label>
<select id="teeth_38_value" name="teeth_38_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="clear"></div>
<h4>Primary Dentition</h4>
<div class="clear"></div>

<div class="tableForNumbers">
<table border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #c0c0c0; !important; font-size:14px;">
  <tbody>
    <tr>
      <td><input name="data51" id="data51" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 51</td>
      <td><input name="data52" id="data52" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 52</td>
      <td><input name="data53" id="data53" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 53</td>
      <td><input name="data54" id="data54" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 54</td>
      <td><input name="data55" id="data55" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 55</td>
      <td><input name="data61" id="data61" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 61</td>
      <td><input name="data62" id="data62" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 62</td>
      <td><input name="data63" id="data63" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 63</td>
      <td><input name="data64" id="data64" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 64</td>
      <td><input name="data65" id="data65" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 65</td>
    </tr>
    <tr>
      <td><input name="data81" id="data81" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 81</td>
      <td><input name="data82" id="data82" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 82</td>
      <td><input name="data83" id="data83" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 83</td>
      <td><input name="data84" id="data84" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 84</td>
      <td><input name="data85" id="data85" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 85</td>
      <td><input name="data71" id="data71" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 71</td>
      <td><input name="data72" id="data72" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 72</td>
      <td><input name="data73" id="data73" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 73</td>
      <td><input name="data74" id="data74" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 74</td>
      <td><input name="data75" id="data75" tabindex="62" maxlength="25" class="radioCheckCol2 mt4" type="checkbox" onclick="data();"> 75</td>
    </tr>
  </tbody>
</table>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="mltpSlect" style="display:none" id="dataDiv51">
<label class="auto">51</label>
<select id="teeth_51_value" name="teeth_51_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv52">
<label class="auto">52</label>
<select id="teeth_52_value" name="teeth_52_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv53">
<label class="auto">53</label>
<select id="teeth_53_value" name="teeth_53_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv54">
<label class="auto">54</label>
<select id="teeth_54_value" name="teeth_54_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>	 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv55">
<label class="auto">55</label>
<select id="teeth_55_value" name="teeth_55_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv61">
<label class="auto">61</label>
<select id="teeth_61_value" name="teeth_61_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv62">
<label class="auto">62</label>
<select id="teeth_62_value" name="teeth_62_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv63">
<label class="auto">63</label>
<select id="teeth_63_value" name="teeth_63_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv64">
<label class="auto">64</label>
<select id="teeth_64_value" name="teeth_64_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv65">
<label class="auto">65</label>
<select id="teeth_65_value" name="teeth_65_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>	 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv81">
<label class="auto">81</label>
<select id="teeth_81_value" name="teeth_81_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv82">
<label class="auto">82</label>
<select id="teeth_82_value" name="teeth_82_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>	 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv83">
<label class="auto">83</label>
<select id="teeth_83_value" name="teeth_83_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv84">
<label class="auto">84</label>
<select id="teeth_84_value" name="teeth_84_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>	 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv85">
<label class="auto">85</label>
<select id="teeth_85_value" name="teeth_85_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv71">
<label class="auto">71</label>
<select id="teeth_71_value" name="teeth_71_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv72">
<label class="auto">72</label>
<select id="teeth_72_value" name="teeth_72_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv73">
<label class="auto">73</label>
<select id="teeth_73_value" name="teeth_73_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>	 
</select>
</div>
<div class="clear"></div>

<div class="mltpSlect" style="display:none" id="dataDiv74">
<label class="auto">74</label>
<select id="teeth_74_value" name="teeth_74_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>		 
</select>
</div>

<div class="mltpSlect" style="display:none" id="dataDiv75">
<label class="auto">75</label>
<select id="teeth_75_value" name="teeth_75_value" tabindex="1" multiple="multiple" size="3" class="multiple" validate="Service Center,string,no">
<option value="">Select</option>
<option value="Decayed - D">Decayed - D</option>
<option value="Attrition - AT">Attrition - AT</option>
<option value="Abrasion - AB">Abrasion - AB</option>
<option value="Erosion - ER">Erosion - ER</option>
<option value="Mobility - MO">Mobility - MO</option>
<option value="Furcation Involvement - FI">Furcation Involvement - FI</option>
<option value="Fracture - #">Fracture - #</option>
<option value="Discoloration - DI">Discoloration - DI</option>
<option value="Missing - M">Missing - M</option>
<option value="Filled - F">Filled - F</option>
<option value="Root Stums - RS">Root Stums - RS</option>
<option value="Crown - C">Crown - C</option>
<option value="Bridge - C">Bridge - C</option>
<option value="RPD - RPD">RPD - RPD</option>
<option value="Pulp Exposure - PE">Pulp Exposure - PE</option>
<option value="Pain on Percussion - PB">Pain on Percussion - PB</option>			 
</select>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

<h4>Soft Tissue</h4>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeDentalRow();" />
<input name="Button" type="button" class="buttonAdd" value="" onclick="addDentalRow();" />
<div class="division"></div>
<div class="tableForTabNumber">
<table border="0" cellspacing="0" cellpadding="0" id="soft" >
	<tr>
		<th scope="col"></th>
		<th scope="col">Symptoms</th>
		<th scope="col">Burning sensation</th>
		<th scope="col">Hyper - pigmentation</th>
		<th scope="col">Red patches scrapable</th>
		<th scope="col">Red patches non - scrapable</th>
		<th scope="col">White patches - scrapable</th>
			<th scope="col">White patches non - scrapable</th>
				<th scope="col">White striae</th>
					<th scope="col">Swelling</th>
						<th scope="col">Ulcers</th>
						<th scope="col">Roughness</th>
	</tr>
	<%
		int inc = 1;
	%>
	<tr>
		<td><input type="radio" value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>
			<td>
			<select id="symptoms<%=inc%>" name="symptoms<%=inc%>" >
 		<option value="">Select</option>
 		<option value="Lip">Lip (Vermilion border)</option>
 		<option value="LabialMucosa">Labial mucosa</option>
 		<option value="LabialSulcus">Labial sulcus</option>
 		<option value="LabialCommissure">Labial commissure</option>
 		<option value="BuccelMucosa">Buccel Mucosa</option>
 		<option value="BuccelSulcus">Buccel Sulcus</option>
 		<option value="Anterior">Anterior 2/3 tongue</option>
 		<option value="Posterior">Posterior 1/3 tongue</option>
 			<option value="Tip">Tip of tongue</option>
 		<option value="Lateral">Lateral borders of tongue</option>
 			<option value="Ventral">Ventral surface of tongue</option>
 				<option value="HardPalate">Hard palate</option>
 				<option value="SoftPalate">Soft Palate</option>
 					<option value="FloorOfMouth">Floor Of Mouth </option>
 						<option value="Gingiva">Gingiva</option>
 						<option value="AlveolarRidge">Alveolar Ridge</option>
 						
 		</select></td>
 		<td>
 			<select id="burning<%=inc%>" name="burning<%=inc%>" >
 		<option value="">Select </option>
 		<option value="Yes">Yes</option>
 		<option value="No">No</option></select>
 		</td><td>
 			<select id="hyper<%=inc%>" name="hyper<%=inc%>" >
 		<option value="">Select </option>
 		<option value="Yes">Yes</option>
 		<option value="No">No</option></select>
 		</td><td>
 			<select id="patches<%=inc%>" name="patches<%=inc%>" >
 		<option value="">Select </option>
 		<option value="Yes">Yes</option>
 		<option value="No">No</option></select>
 		</td><td>
 			<select id="patchesNon<%=inc%>" name="patchesNon<%=inc%>" >
 		<option value="">Select </option>
 		<option value="Yes">Yes</option>
 		<option value="No">No</option></select>
 		</td><td>
 			<select id="patchesWhite<%=inc%>" name="patchesWhite<%=inc%>" >
 		<option value="">Select </option>
 		<option value="Yes">Yes</option>
 		<option value="No">No</option></select>
 		</td><td>
 			<select id="patchesNonWhite<%=inc%>" name="patchesNonWhite<%=inc%>" >
 		<option value="">Select </option>
 		<option value="Yes">Yes</option>
 		<option value="No">No</option></select>
 		</td><td>
 		<select id="patchesStriae<%=inc%>" name="patchesStriae<%=inc%>" >
 		<option value="">Select </option>
 		<option value="Yes">Yes</option>
 		<option value="No">No</option></select>
 		
 		</td>
 		<td>
 			<select id="swelling<%=inc%>" name="swelling<%=inc%>" >
 		<option value="">Select </option>
 		<option value="Yes">Yes</option>
 		<option value="No">No</option></select>
 		</td><td>
 			<select id="ulcers<%=inc%>" name="ulcers<%=inc%>" >
 		<option value="">Select </option>
 		<option value="Yes">Yes</option>
 		<option value="No">No</option></select>
 		</td>
 		<td>
 			<select id="roughness<%=inc%>" name="roughness<%=inc%>" >
 		<option value="">Select </option>
 		<option value="Yes">Yes</option>	
 		<option value="No">No</option></select>
 		</td>
</table>
</div>
<input type="hidden" value="<%=inc%>" name="hiddenValueCharge"	id="hiddenValueCharge" />


<h4>Tongue</h4>
<label>Inspection</label>
<input type="text" name="Inspection" value="" class="textbox_size20"  maxlength="128">


<h4>Palpation</h4>
<label>Dorsum</label>
<input type="text" name="Dorsum" value="" class="textbox_size20" maxlength="128" >



<label>Ventral Surface</label>
<input type="text" name="Ventral" value="" class="textbox_size20" maxlength="128">

<label class="autoSpace">Lateral Border <input type="checkbox"	name="lactation" id="lactation" class="radioCheckCol2" onclick="data();"></label>

<div id="lactationDiv" style="display: none;">
<select>
</select>
</div>

<div class="clear"></div>

<label>Local Examination Findings</label>
<input type="text" name="Local" value="" class="textbox_size20" maxlength="128">


<label>Case Summary</label>
<input type="text" name="Case" value="" class="textbox_size20" maxlength="128">


</div>
<div class="bottom">
<label>Changed By:</label>
<%--  <labelclass="value"><%=userName%></label>  --%>
<label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label>
<%-- <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />  --%>
<input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</form>

<style>
.mt4 {margin-top:4px !important;}
.mltpSlect {width:228px; float:left;}
.yesNo {width:52px; float:left;}
.wdth60 {width:60px;}
</style>

