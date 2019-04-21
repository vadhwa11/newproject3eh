<%@page import="jkt.hms.masters.business.OpdRespiratorySpecialityDetail"%>
<%@page import="jkt.hms.masters.business.OpdRespiratorySpecialityHeader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
	Map<String,Object> map=new HashMap<String,Object>();
	
	  if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		        }
	  
	  List<Object[]> reVisitList = new ArrayList<Object[]>();
		if(request.getAttribute("map") != null){
			map = (Map<String,Object>) request.getAttribute("map");
		   }

		if(map.get("reVisitList") != null){
			reVisitList = (List<Object[]>)map.get("reVisitList");
		 }
		Double height = null;
		Double weight = null;
		float respiratoryRate = 0;
		String bp = "";
		if(reVisitList.size()>0){
			for(Object[] obj : reVisitList){
				if(obj[0] != null){
					height = (Double)obj[0];
				}
				if(obj[1] != null){
					weight = (Double)obj[1];
				}
				if(obj[2] != null){
					respiratoryRate = (Float)obj[2];
				}
				if(obj[3] != null){
					bp = (String)obj[3];
				}
			}
		}

		System.out.println("reVisitList=="+reVisitList.size());

	List<OpdRespiratorySpecialityHeader> opdRespiratorySpecialityHeaderList =  new ArrayList<OpdRespiratorySpecialityHeader>();
	
	if(map.get("opdRespiratorySpecialityHeaderList") != null){
		opdRespiratorySpecialityHeaderList = (List<OpdRespiratorySpecialityHeader>) map.get("opdRespiratorySpecialityHeaderList");
	 }
	
	
	
	List<OpdRespiratorySpecialityDetail> opdRespiratorySpecialityDetailListSymptoms =  new ArrayList<OpdRespiratorySpecialityDetail>();
	if(map.get("opdRespiratorySpecialityDetailListSymptoms") != null){
		opdRespiratorySpecialityDetailListSymptoms = (List<OpdRespiratorySpecialityDetail>) map.get("opdRespiratorySpecialityDetailListSymptoms");
		System.out.println("opdRespiratorySpecialityDetailListSymptoms"+opdRespiratorySpecialityDetailListSymptoms.size());
	 }
	
	
	List<OpdRespiratorySpecialityDetail> opdRespiratorySpecialityDetailListTriggers =  new ArrayList<OpdRespiratorySpecialityDetail>();
	if(map.get("opdRespiratorySpecialityDetailListTriggers") != null){
		opdRespiratorySpecialityDetailListTriggers = (List<OpdRespiratorySpecialityDetail>) map.get("opdRespiratorySpecialityDetailListTriggers");
	 }
	List<OpdRespiratorySpecialityDetail> opdRespiratorySpecialityDetailListPastHistory =  new ArrayList<OpdRespiratorySpecialityDetail>();
	if(map.get("opdRespiratorySpecialityDetailListPastHistory") != null){
		opdRespiratorySpecialityDetailListPastHistory = (List<OpdRespiratorySpecialityDetail>) map.get("opdRespiratorySpecialityDetailListPastHistory");
	 }
	List<OpdRespiratorySpecialityDetail> opdRespiratorySpecialityDetailListMedications =  new ArrayList<OpdRespiratorySpecialityDetail>();
	if(map.get("opdRespiratorySpecialityDetailListMedications") != null){
		opdRespiratorySpecialityDetailListMedications = (List<OpdRespiratorySpecialityDetail>) map.get("opdRespiratorySpecialityDetailListMedications");
	 }
	List<OpdRespiratorySpecialityDetail> opdRespiratorySpecialityDetailListCurrentTreatment =  new ArrayList<OpdRespiratorySpecialityDetail>();
	if(map.get("opdRespiratorySpecialityDetailListCurrentTreatment") != null){
		opdRespiratorySpecialityDetailListCurrentTreatment = (List<OpdRespiratorySpecialityDetail>) map.get("opdRespiratorySpecialityDetailListCurrentTreatment");
	 }
	List<OpdRespiratorySpecialityDetail> opdRespiratorySpecialityDetailListRelation =  new ArrayList<OpdRespiratorySpecialityDetail>();
	if(map.get("opdRespiratorySpecialityDetailListRelation") != null){
		opdRespiratorySpecialityDetailListRelation = (List<OpdRespiratorySpecialityDetail>) map.get("opdRespiratorySpecialityDetailListRelation");
	 }
	List<OpdRespiratorySpecialityDetail> opdRespiratorySpecialityDetailListReviewControl =  new ArrayList<OpdRespiratorySpecialityDetail>();
	if(map.get("opdRespiratorySpecialityDetailListReviewControl") != null){
		opdRespiratorySpecialityDetailListReviewControl = (List<OpdRespiratorySpecialityDetail>) map.get("opdRespiratorySpecialityDetailListReviewControl");
	 }
	String fatherName="";
	String motherName="";
	String fatherOccupation="";
	String motherOccupation="";
	String ageOnSetSymptoms="";
	String detailsOfExacerbation="";
	String frequencyOverOneYear="";
	String casualtyVisits="";
	String hospitalAdmissions="";
	String hospitalAdmissionsFollowUp="";
	String icuAdmissions="";
	String gestationalAge="";
	String birthWeight="";
	String neonatalrespiratorySymptoms="";
	String contactWithTuberculosis="";
	String immunizationRoutine="";
	String immunizationOptional="";
	String exposureToCigaretteSmoke="";
	String exposureToBiomassFuel="";
	String exposureToTrafficPollution="";
	String exposureToPets="";
	String skin="";
	String face="";
	String conjunctiva="";
	String ear="";
	String throat="";
	String clubbing="";
	String workOfBreathing="";
	String chest="";
	String wheeze="";
	String shape="";
	String shapeValue="";
	String breathSounds="";
	String breathSoundsValue="";
	String otherAdventitiousSounds="";
	String abdomen="";
	String cvs="";
	String allergySkinTest="";
	String asthmaEducation="";
	String actionPlan="";
	String actionDiary="";
	String severityAtDiagnosis="";
	String intervalSinceLastVisit="";
	String symptoms="";
	String currentSymptoms="";
	String noOfExacerbation="";
	String oralSteroidUse="";
	String physicalActivities="";
	String inhalerTechnique="";
	String adherenceToTreatmentPlan="";
	String asthmaDiaryFollowUp="";
	String heightFollowUp="";
	String weightFollowUp="";
	String heartRate="";
	String systolicFollowUp="";
	String diastolicFollowUp="";
	String cineses ="";
	String nose="";
	String pastHistoryValue="";
	String fatherEducation="";
	String motherEducation="";
	String triggersValue="";
	if(opdRespiratorySpecialityHeaderList!=null && opdRespiratorySpecialityHeaderList.size()>0)
	{
		for(OpdRespiratorySpecialityHeader opdRespiratorySpecialityHeader:opdRespiratorySpecialityHeaderList){
			fatherName=opdRespiratorySpecialityHeader.getFatherName()!=null?opdRespiratorySpecialityHeader.getFatherName():"";
			motherName=opdRespiratorySpecialityHeader.getMotherName()!=null?opdRespiratorySpecialityHeader.getMotherName():"";
			 fatherOccupation=opdRespiratorySpecialityHeader.getFatherOccupation()!=null?opdRespiratorySpecialityHeader.getFatherOccupation():"";
			 motherOccupation=opdRespiratorySpecialityHeader.getMotherOccupation()!=null?opdRespiratorySpecialityHeader.getMotherOccupation():"";
			 fatherEducation=opdRespiratorySpecialityHeader.getFatherEducation()!=null?opdRespiratorySpecialityHeader.getFatherEducation():"";
			 motherEducation=opdRespiratorySpecialityHeader.getMotherEducation()!=null?opdRespiratorySpecialityHeader.getMotherEducation():"";
			 ageOnSetSymptoms=opdRespiratorySpecialityHeader.getAgeOfOnsetOfSymptoms()!=null?opdRespiratorySpecialityHeader.getAgeOfOnsetOfSymptoms():"";
			 detailsOfExacerbation=opdRespiratorySpecialityHeader.getDetailsOfExacerbation()!=null?opdRespiratorySpecialityHeader.getDetailsOfExacerbation():"";
			 frequencyOverOneYear=opdRespiratorySpecialityHeader.getFrequenctOverOneYear()!=null?opdRespiratorySpecialityHeader.getFrequenctOverOneYear():"";
			 casualtyVisits=opdRespiratorySpecialityHeader.getCasualityVisits()!=null?opdRespiratorySpecialityHeader.getCasualityVisits():"";
			 hospitalAdmissions=opdRespiratorySpecialityHeader.getFatherName()!=null?opdRespiratorySpecialityHeader.getHospitalAdmissions():"";
			 icuAdmissions=opdRespiratorySpecialityHeader.getIcuAdmissions()!=null?opdRespiratorySpecialityHeader.getIcuAdmissions():"";
			 pastHistoryValue=opdRespiratorySpecialityHeader.getPastHistoryValue()!=null?opdRespiratorySpecialityHeader.getPastHistoryValue():"";
			 triggersValue=opdRespiratorySpecialityHeader.getTriggersValue()!=null?opdRespiratorySpecialityHeader.getTriggersValue():"";
			 gestationalAge=opdRespiratorySpecialityHeader.getGestationalAge()!=null?opdRespiratorySpecialityHeader.getGestationalAge():"";
			 birthWeight=opdRespiratorySpecialityHeader.getBirthWeight()!=null?opdRespiratorySpecialityHeader.getBirthWeight():"";
			 neonatalrespiratorySymptoms=opdRespiratorySpecialityHeader.getNeonatalRespiratorySymptoms()!=null?opdRespiratorySpecialityHeader.getNeonatalRespiratorySymptoms():"";
			 contactWithTuberculosis=opdRespiratorySpecialityHeader.getContactWithTuberculosis()!=null?opdRespiratorySpecialityHeader.getContactWithTuberculosis():"";
			 immunizationRoutine=opdRespiratorySpecialityHeader.getImmunizationRoutine()!=null?opdRespiratorySpecialityHeader.getImmunizationRoutine():"";
			 immunizationOptional=opdRespiratorySpecialityHeader.getImmunizationOptional()!=null?opdRespiratorySpecialityHeader.getImmunizationOptional():"";
			 exposureToCigaretteSmoke=opdRespiratorySpecialityHeader.getExposureToCigaretteSmoke()!=null?opdRespiratorySpecialityHeader.getExposureToCigaretteSmoke():"";
			 exposureToBiomassFuel=opdRespiratorySpecialityHeader.getExposureToBiomassFuel()!=null?opdRespiratorySpecialityHeader.getExposureToBiomassFuel():"";
			 exposureToTrafficPollution=opdRespiratorySpecialityHeader.getExposureToTrafficPollution()!=null?opdRespiratorySpecialityHeader.getExposureToTrafficPollution():"";
			 exposureToPets=opdRespiratorySpecialityHeader.getExposureToPets()!=null?opdRespiratorySpecialityHeader.getExposureToPets():"";
			 skin=opdRespiratorySpecialityHeader.getSkin()!=null?opdRespiratorySpecialityHeader.getSkin():"";
			 face=opdRespiratorySpecialityHeader.getFace()!=null?opdRespiratorySpecialityHeader.getFace():"";
			 conjunctiva=opdRespiratorySpecialityHeader.getConjunctiva()!=null?opdRespiratorySpecialityHeader.getConjunctiva():"";
			 ear=opdRespiratorySpecialityHeader.getEar()!=null?opdRespiratorySpecialityHeader.getEar():"";
			 hospitalAdmissionsFollowUp=opdRespiratorySpecialityHeader.getHospitalAdmissionsFollowup()!=null?opdRespiratorySpecialityHeader.getHospitalAdmissionsFollowup():"";
			 nose=opdRespiratorySpecialityHeader.getNose()!=null?opdRespiratorySpecialityHeader.getNose():"";
				throat=opdRespiratorySpecialityHeader.getThroat()!=null?opdRespiratorySpecialityHeader.getThroat():"";
				clubbing=opdRespiratorySpecialityHeader.getClubbing()!=null?opdRespiratorySpecialityHeader.getClubbing():"";
				workOfBreathing=opdRespiratorySpecialityHeader.getWorkOfBrathing()!=null?opdRespiratorySpecialityHeader.getWorkOfBrathing():"";
				chest=opdRespiratorySpecialityHeader.getChest()!=null?opdRespiratorySpecialityHeader.getChest():"";
				wheeze=opdRespiratorySpecialityHeader.getWheeze()!=null?opdRespiratorySpecialityHeader.getWheeze():"";
				shape=opdRespiratorySpecialityHeader.getShape()!=null?opdRespiratorySpecialityHeader.getShape():"";
				shapeValue=opdRespiratorySpecialityHeader.getShapeValue()!=null?opdRespiratorySpecialityHeader.getShapeValue():"";
				breathSounds=opdRespiratorySpecialityHeader.getBreathSounds()!=null?opdRespiratorySpecialityHeader.getBreathSounds():"";
				breathSoundsValue=opdRespiratorySpecialityHeader.getBreathSoundsValue()!=null?opdRespiratorySpecialityHeader.getBreathSoundsValue():"";
				otherAdventitiousSounds=opdRespiratorySpecialityHeader.getOtherAdventitiousSounds()!=null?opdRespiratorySpecialityHeader.getOtherAdventitiousSounds():"";
				abdomen=opdRespiratorySpecialityHeader.getAbdomen()!=null?opdRespiratorySpecialityHeader.getAbdomen():"";
				cvs=opdRespiratorySpecialityHeader.getCvs()!=null?opdRespiratorySpecialityHeader.getCvs():"";
				allergySkinTest=opdRespiratorySpecialityHeader.getAllergySkinTest()!=null?opdRespiratorySpecialityHeader.getAllergySkinTest():"";
				asthmaEducation=opdRespiratorySpecialityHeader.getAsthmaEducation()!=null?opdRespiratorySpecialityHeader.getAsthmaEducation():"";
				actionPlan=opdRespiratorySpecialityHeader.getActionPlan()!=null?opdRespiratorySpecialityHeader.getActionPlan():"";
				actionDiary=opdRespiratorySpecialityHeader.getAsthmaDiary()!=null?opdRespiratorySpecialityHeader.getAsthmaDiary():"";
				severityAtDiagnosis=opdRespiratorySpecialityHeader.getSeverityAtDiagnosis()!=null?opdRespiratorySpecialityHeader.getSeverityAtDiagnosis():"";
				intervalSinceLastVisit=opdRespiratorySpecialityHeader.getIntervalSinceLastVisit()!=null?opdRespiratorySpecialityHeader.getIntervalSinceLastVisit():"";
				symptoms=opdRespiratorySpecialityHeader.getSymtoms()!=null?opdRespiratorySpecialityHeader.getSymtoms():"";
				currentSymptoms=opdRespiratorySpecialityHeader.getCurrentSymptoms()!=null?opdRespiratorySpecialityHeader.getCurrentSymptoms():"";
				noOfExacerbation=opdRespiratorySpecialityHeader.getNoOfExacerbations()!=null?opdRespiratorySpecialityHeader.getNoOfExacerbations():"";
				oralSteroidUse=opdRespiratorySpecialityHeader.getOralSteroidUse()!=null?opdRespiratorySpecialityHeader.getOralSteroidUse():"";
				physicalActivities=opdRespiratorySpecialityHeader.getPhysicalActivities()!=null?opdRespiratorySpecialityHeader.getPhysicalActivities():"";
				inhalerTechnique=opdRespiratorySpecialityHeader.getCheckInhalerTechnique()!=null?opdRespiratorySpecialityHeader.getCheckInhalerTechnique():"";
				adherenceToTreatmentPlan=opdRespiratorySpecialityHeader.getAdherenceToTreatmentPlan()!=null?opdRespiratorySpecialityHeader.getAdherenceToTreatmentPlan():"";
				asthmaDiaryFollowUp=opdRespiratorySpecialityHeader.getAsthmaDiaryFollowup()!=null?opdRespiratorySpecialityHeader.getAsthmaDiaryFollowup():"";
				heartRate=opdRespiratorySpecialityHeader.getHeartRate()!=null?opdRespiratorySpecialityHeader.getHeartRate():"";
				cineses =opdRespiratorySpecialityHeader.getCineses()!=null?opdRespiratorySpecialityHeader.getHeartRate():"";
	
	
		}
	}

	
%>



<form  method="post" name="respiratoryClinic">

<h6>Respiratory Clinic</h6>




<div class="clear"></div>
<div class="paddingTop5"></div>

<input id="respiratoryFlag" name="respiratoryFlag" tabindex="1" value="Respiratory Clinic" type="hidden"  />
<input type="hidden" name="templateName" value="Respiratory Clinic"/>
<%	if(opdRespiratorySpecialityHeaderList!=null && opdRespiratorySpecialityHeaderList.size()>0)
{ %>




<label>Father's Name</label>
<input type="text"  id="fatherName" name="fatherName" tabindex="1" value="<%=fatherName %>" maxlength="30" validate="Father's Name,string,no"/>
<label>Mother's Name</label>
<input type="text"  id="motherName" name="motherName" tabindex="1" value="<%=motherName %>"  maxlength="30" validate="Mother's Name,string,no"/>
<div class="clear"></div>
<label>Father's Occupation</label>
<input type="text"  id="fatherOccupation" name="fatherOccupation" tabindex="1" value="<%=fatherOccupation %>"   maxlength="100" validate="Father's Occupation,string,no"/>
<label>Mother's Occupation</label>
<input type="text"  id="motherOccupation" name="motherOccupation" tabindex="1" value="<%=motherOccupation %>"   maxlength="100" validate="Mother's Occupation,string,no"/>
<div class="clear"></div>
<label>Father's Education</label>
<input type="text"  id="fatherEducation" name="fatherEducation" tabindex="1" value="<%=fatherEducation %>"   maxlength="30" validate="Father's Education,string,no"/>
<label>Mother's Education</label>
<input type="text"  id="motherEducation" name="motherEducation" tabindex="1" value="<%=motherEducation %>"  maxlength="30" validate="Mother's Education,string,no"/>
<div class="clear"></div>
<label>Age of Onset of Symptoms</label>
<input type="text"  id="ageOnSetSymptoms" maxlength="3" name="ageOnSetSymptoms" tabindex="1" value="<%=ageOnSetSymptoms %>"  validate="Age of Onset of Symptoms,num,no"/>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<h4>Chief Complaints</h4>
<div class="clear"></div>
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForSymptoms();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForSymptoms();" />
  <div class="clear"></div>
<table border="0" cellpadding="5" cellspacing="0" style="width:718px; margin-left: 5px; float:left;" class="tablestyle" id="symptomsGrid"> 
    <tr>
     <th align="center"></th>
      <th align="center">Symptoms</th>
      <th align="center">Duration</th>
      <th align="center">Frequency</th>
      <th align="center">Remarks</th>
    </tr>
   <tr>
   
   
    
      <%
      int j=1;
      if(opdRespiratorySpecialityDetailListSymptoms!=null && opdRespiratorySpecialityDetailListSymptoms.size()>0)
	{
    	 
		for(OpdRespiratorySpecialityDetail opdRespiratorySpecialityDetail:opdRespiratorySpecialityDetailListSymptoms){
			 
	 %>
    <tr>
     <td><input  type="checkbox" class="radioCheck" name="symptomsRadio<%=j %>" id="symptomsRadio<%=j %>" /></td> 
<td>
<select name="symptoms<%=j%>" id="symptoms<%=j%>" onchange="symptomsOtherVal(this.value,<%=j%>);">
<option value="">Select</option>
<option value="Cough">Cough</option>
<option value="Wheezing">Wheezing</option>
<option value="Breathlessness">Breathlessness</option>
<option value="Chest tightness">Chest tightness</option>
<option value="Chest Pain">Chest Pain</option>
<option value="Exercise Limitation">Exercise Limitation</option>
<option value="Others">Others</option>
</select>
<div class="clear"></div> 
		<div style="display: none" id="showsymptomsOthersDiv<%=j%>">
				<input type="text" maxlength="16" tabindex="1" value="" name="showsymptomsOthers<%=j %>" id="showsymptomsOthers<%=j %>" class="medium" />
		</div>

<script>
<%

if(opdRespiratorySpecialityDetail.getParameterName()!=null){
%>

document.getElementById('symptoms<%=j%>').value = '<%=opdRespiratorySpecialityDetail.getParameterName()%>';
<%}%>
</script>	

</td>
 <td><input type="text" name="durationSymptoms<%=j%>" id="durationSymptoms<%=j%>" value="<%=opdRespiratorySpecialityDetail.getDuration()!=null?opdRespiratorySpecialityDetail.getDuration():"" %>" maxlength="3" validate="Duration,num,no"/></td>
<td><input type="text" name="frequencySymptoms<%=j%>" id=frequencySymptoms<%=j%> value="<%=opdRespiratorySpecialityDetail.getFrequency()!=null?opdRespiratorySpecialityDetail.getFrequency():""  %>" maxlength="3" validate="Frequency,num,no"/></td>
<td><input type="text" name="remarksSymptoms<%=j%>" id="remarksSymptoms<%=j%>"  value="<%=opdRespiratorySpecialityDetail.getRemark()!=null?opdRespiratorySpecialityDetail.getRemark():""  %>" maxlength="50"/></td>
    </tr>
<%
++j;
		}
		
	
	}else{  %>
   <tr>
  
<td><input  type="checkbox" class="radioCheck" name="symptomsRadio<%=j%>" id="symptomsRadio<%=j%>" /></td> 
<td>
<select name="symptoms<%=j%>" id="symptoms<%=j%>" onchange="symptomsOtherVal(this.value,<%=j%>);">
<option value="">Select</option>
<option value="Cough">Cough</option>
<option value="Wheezing">Wheezing</option>
<option value="Breathlessness">Breathlessness</option>
<option value="Chest tightness">Chest tightness</option>
<option value="Chest Pain">Chest Pain</option>
<option value="Exercise Limitation">Exercise Limitation</option>
<option value="Others">Others</option>
</select>

<div class="clear"></div> 
		<div style="display: none" id="showsymptomsOthersDiv<%=j%>">
			<input type="text" maxlength="16" tabindex="1" value="" name="showsymptomsOthers<%=j %>" id="showsymptomsOthers<%=j %>" class="medium" />
		</div>
</td>
<td><input type="text" name="durationSymptoms<%=j%>" id="durationSymptoms<%=j%>" value="" maxlength="3" validate="Duration,num,no"/></td>
<td><input type="text" name="frequencySymptoms<%=j%>" id=frequencySymptoms<%=j%> value="" maxlength="3" validate="Frequency,num,no"//></td>
<td><input type="text" name="remarksSymptoms<%=j%>" id="remarksSymptoms<%=j%>"  value="" maxlength="50"/></td>
</tr>
<%
++j;
	}%>   
</table>  
<input type="hidden" name="symptomsCount" id="symptomsCount" value="<%=j-1%>" />

<div class="clear"></div>
<div class="paddingTop5"></div>




<label>Details of Exacerbation</label>
<input type="text"  id="detailsOfExacerbation" name="detailsOfExacerbation" tabindex="1" value="<%=detailsOfExacerbation %>"  maxlength="50"/>
  <div class="clear"></div>
<label>Frequency Over 1 Year</label>
<input type="text"  id="frequencyOverOneYear" name="frequencyOverOneYear" tabindex="1" value="<%=frequencyOverOneYear %>" maxlength="3" validate="Frequency Over 1 Year,int,no"/>
<label>Casualty Visits</label>
<input type="text"  id="casualtyVisits" name="casualtyVisits" tabindex="1" value="<%=casualtyVisits %>"  maxlength="3" validate="Casualty Visits,int,no"/>
  <div class="clear"></div>
<label>Hospital Admission</label>
<input type="text"  id="hospitalAdmissions" name="hospitalAdmissions" tabindex="1" value="<%=hospitalAdmissions %>"  maxlength="3" validate="Hospital Admissions,int,no" />
<label>ICU Admissions</label> <input type="text" id="icuAdmissions" name="icuAdmissions" tabindex="1"			value="<%=icuAdmissions %>" maxlength="3" validate="ICU Admissions,int,no"/>
		<div class="clear"></div>
<label>Triggers</label>
     
	 


<select  multiple="multiple" class="multiple" name="triggers"  id="triggers">
<option value="Viral Infections">Viral Infections</option>
<option value="Cold air">Cold air</option>
<option value="Change of season">Change of season</option>
<option value="Dust">Dust</option>
<option value="Smoke">Smoke</option>
<option value="Exposure to animals">Exposure to animals</option>
<option value="Bronchiolitis">Bronchiolitis</option>
<option value="Exercise">Exercise</option>
<option value="Others">Others</option>  
</select>
 <%
  
      if(opdRespiratorySpecialityDetailListTriggers!=null && opdRespiratorySpecialityDetailListTriggers.size()>0)
	{
   
		for(OpdRespiratorySpecialityDetail opdRespiratorySpecialityDetail:opdRespiratorySpecialityDetailListTriggers){
			
				
	 %>
<script>
<%
if(opdRespiratorySpecialityDetail.getParameterName()!=null){
%>
document.getElementById('triggers').value = '<%=opdRespiratorySpecialityDetail.getParameterName()%>';

<%}%>
</script>


<%}}%>
<input type="text"  id="triggersValue" name="triggersValue" tabindex="1" value="<%=triggersValue %>" maxlength="256" />
<div class="clear"></div>
<label>Past History</label>

<select  multiple="multiple" class="multiple" name="pastHistory" id="pastHistory">
<option value="Recurrent URTI">Recurrent URTI</option>
<option value="Documented Pneumoniar">Documented Pneumonia</option>
<option value="FB Aspiration">FB Aspiration</option>
<option value="GER Symptoms">GER Symptoms</option>
<option value="Obstructive sleep symptoms">Obstructive sleep symptoms</option>
<option value="Bronchiolitis">Bronchiolitis</option>
<option value="Allergic rhinitis">Allergic rhinitis</option>
<option value="Allergic conjunctivitis">Allergic conjunctivitis</option>
<option value="Eczema/Atopy">Eczema/Atopy</option>
<option value="Whooping cough">Whooping cough</option>
<option value="Eczema/Atopy">Eczema/Atopy</option>
<option value="Measles">Measles</option>
</select>
      <%if(opdRespiratorySpecialityDetailListPastHistory!=null && opdRespiratorySpecialityDetailListPastHistory.size()>0)
	{
		for(OpdRespiratorySpecialityDetail opdRespiratorySpecialityDetail:opdRespiratorySpecialityDetailListPastHistory){
			
	 %>

<script>
<%
if(opdRespiratorySpecialityDetail.getParameterName()!=null){
%>
document.getElementById('pastHistory').value = '<%=opdRespiratorySpecialityDetail.getParameterName()%>';

<%}%>
</script>

<%}} %>
<input type="text"  id="pastHistoryValue" name="pastHistoryValue" tabindex="1" value="<%=pastHistoryValue%>"  maxlength="256"/>
   <div class="clear"></div>
   <h4>Birth History</h4>
    <div class="clear"></div>
<label>Gestational Age</label>
<input type="text"  id="gestationalAge" name="gestationalAge" tabindex="1" value="<%=gestationalAge %>"  validate="Gestational Age,num,no" maxlength="3"/>
<select id="gestationalAgeParameter" name="gestationalAgeParameter" tabindex="1" class="medium2" >
<option value="">Select</option>	
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
</select>

<label>Birth Weight</label>
<input type="text"  id="birthWeight" name="birthWeight" tabindex="1" value="<%=birthWeight %>"   validate="Birth Weight,float,no" maxlength="5"/>
 <div class="clear"></div>
<label class="heightAuto">Neonatal respiratory symptoms/diagnosis</label>
<input type="text"  id="neonatalrespiratorySymptoms" name="neonatalrespiratorySymptoms" tabindex="1" value="<%=neonatalrespiratorySymptoms %>"  /> 
  <div class="clear"></div>
  <div class="clear"></div>
<h4>Treatment History</h4>
<div class="clear"></div>
  <div class="clear"></div>
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForTreatmentHistory();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForTreatmentHistory();" />
  <div class="clear"></div>
  <table border="0" cellpadding="5" cellspacing="0" style="width:718px; margin-left: 5px; float:left;" class="tablestyle" id="treatmentHistoryGrid"> 
    <tr>
    <th align="center"></th>
      <th align="center">Medications</th>
      <th align="center">Ever Used</th>
      <th align="center">Duration</th>
      <th align="center">Name</th>
      <th align="center">Response</th>
    </tr>
    
  
      <%
      
      int z=1;
      if(opdRespiratorySpecialityDetailListMedications!=null && opdRespiratorySpecialityDetailListMedications.size()>0)
	{
    	  
		for(OpdRespiratorySpecialityDetail oprsd:opdRespiratorySpecialityDetailListMedications){
			
	 %>
    <tr>
      <td><input  type="checkbox" class="radioCheck" name="treatmentHistoryRadio<%=z %>" id="treatmentHistoryRadio<%=z %>" /></td> 
      
      		<td>
		<select name="medications<%=z%>" id="medications<%=z%>">
		<option value="">Select</option>
		<option value="Bronchodilators">Bronchodilators</option>
		<option value="Inhaled steroids">Inhaled steroids</option>
		<option value="Oral steroids">Oral steroids</option>
		<option value="Antibiotics">Antibiotics</option>
		<option value="Anti TB treatment">Anti TB treatmen</option>
		<option value="Others">Others</option>
		</select>
		
		<script>
<%
if(oprsd.getParameterName()!=null){
%>
document.getElementById('medications<%=z%>').value = '<%=oprsd.getParameterName()%>';

<%}%>
</script>
		</td>
      
		
	    <td align="left"><input type="text" maxlength="120" validate="Ever Used,metachar,no" tabindex="1" value="<%=oprsd.getEverUsed()!=null?oprsd.getEverUsed():"" %>" name="everUsedTreatment<%=z%>" id="everUsedTreatment<%=z%>" ></td>
      <td align="left"><input type="text" maxlength="3" validate="Duration,num,no" tabindex="1" value="<%=oprsd.getDuration()!=null?oprsd.getDuration():"" %>" name="durationTreatment<%=z%>" id="durationTreatment<%=z%>" validate="Duration,num,no"></td>
      <td align="left"><input type="text" maxlength="120" validate="Name,metachar,no" tabindex="1" value="<%=oprsd.getName()!=null?oprsd.getName():"" %>" name="nameTreatment<%=z%>" id="nameTreatment<%=z%>" ></td>
      <td align="left"><input type="text" maxlength="50" validate="Response,metachar,no" tabindex="1" value="<%=oprsd.getResponse()!=null?oprsd.getResponse():"" %>" name="responseTreatment<%=z%>" id="responseTreatment<%=z%>" ></td>
   </tr>   
    <%z++;}}else{
    %>
    <tr>   
     <td><input  type="checkbox" class="radioCheck" name="treatmentHistoryRadio<%=z%>" id="treatmentHistoryRadio<%=z%>" /></td> 
		<td>
		<select name="medications<%=z%>" id="medications<%=z%>">
		<option value="">Select</option>
		<option value="Bronchodilators">Bronchodilators</option>
		<option value="Inhaled steroids">Inhaled steroids</option>
		<option value="Oral steroids">Oral steroids</option>
		<option value="Antibiotics">Antibiotics</option>
		<option value="Anti TB treatment">Anti TB treatmen</option>
		<option value="Others">Others</option>
		</select>
		</td>
		
		   <td align="left"><input type="text" maxlength="120" validate="Ever Used,metachar,no" tabindex="1" value="" name="everUsedTreatment<%=z%>" id="everUsedTreatment<%=z%>"  ></td>
      <td align="left"><input type="text" maxlength="3" validate="Duration,num,no" tabindex="1" value=""  id="durationTreatment<%=z%>" name="durationTreatment<%=z%>" validate="Duration,num,no"></td>
      <td align="left"><input type="text" maxlength="120" validate="Name,metachar,no" tabindex="1" value="" name="nameTreatment<%=z%>" id="nameTreatment<%=z%>"></td>
      <td align="left"><input type="text" maxlength="50" validate="Response,metachar,no" tabindex="1" value="" name="responseTreatment<%=z%>" id="responseTreatment<%=z%>"  ></td>
      </tr>   
<%
z++;
    } %>
     
   
  </table>
  <input type="hidden" name="treatmentHistoryCount" id="treatmentHistoryCount" value="<%=z-1%>" />
   <div class="clear"></div>
  <div class="paddingTop5"></div>
  <div class="clear"></div>
<h4>Current Treatment</h4>
<div class="clear"></div>
   <div class="clear"></div>
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForCurrentTreatment();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForCurrentTreatment();" />
  <div class="clear"></div>
  <table border="0" cellpadding="5" cellspacing="0" style="width:724px; margin-left: 5px; float:left;" class="tablestyle" id="currentTreatmentGrid"> 
    <tr>
    <th align="center"></th>
      <th align="center">Current Treatment</th>
      <th align="center">Duration</th>
      <th align="center">Response</th>
    </tr>
    
    
          <%
        int y=1;  
          if(opdRespiratorySpecialityDetailListCurrentTreatment!=null && opdRespiratorySpecialityDetailListCurrentTreatment.size()>0)
		{
		for(OpdRespiratorySpecialityDetail opdRespiratorySpecialityDetail:opdRespiratorySpecialityDetailListCurrentTreatment){
		
	 %> 	 
	   <tr>
	      <td><input  type="checkbox" class="radioCheck" name="currentTreatmentRadio<%=y%>" id="currentTreatmentRadio<%=y%>" /></td> 
      <td align="left"><input  type="text" maxlength="50" validate="Current Treatment,metachar,no" tabindex="1" value="<%=opdRespiratorySpecialityDetail.getCurrentTreatment()!=null?opdRespiratorySpecialityDetail.getCurrentTreatment():"" %>"  name="currentTreatment<%=y%>" id="currentTreatment<%=y%>" ></td>
      <td align="left"><input  type="text" maxlength="3" validate="Duration,num,no" tabindex="1" value="<%=opdRespiratorySpecialityDetail.getDuration()!=null?opdRespiratorySpecialityDetail.getDuration():"" %>"  name="durationCurrentTreatment<%=y%>" id="durationCurrentTreatment<%=y%>" validate="Duration,num,no"></td>
      <td align="left"><input  type="text" maxlength="50" validate="Response,metachar,no" tabindex="1" value="<%=opdRespiratorySpecialityDetail.getResponse()!=null?opdRespiratorySpecialityDetail.getResponse():"" %>"  name="responseCurrentTreatment<%=y%>"  id="responseCurrentTreatment<%=y%>" ></td>
		</tr>
	
       
       <%y++;}}else{%>
         <tr>
       
       
       
         <td><input  type="checkbox" class="radioCheck" name="currentTreatmentRadio<%=y%>" id="currentTreatmentRadio<%=y%>" /></td> 
      <td align="left"><input  type="text" maxlength="50" validate="Current Treatment,num,no" tabindex="1" value="" name="currentTreatment<%=y%>"  id="currentTreatment<%=y%>" ></td>
      <td align="left"><input  type="text" maxlength="3" validate="Duration,num,no" tabindex="1" value="" name="durationCurrentTreatment<%=y%>" id="durationCurrentTreatment<%=y%>"></td>
      <td align="left"><input  type="text" maxlength="50" validate="Response,metachar,no" tabindex="1" value="" name="responseCurrentTreatment<%=y%>"  id="responseCurrentTreatment<%=y%>" ></td>
      </tr>   
      <%
      y++;
       } %>
        
  </table>
  <!-- 2<sup>o</sup>  -->
  <input type="hidden" name="currentTreatmentCount" id="currentTreatmentCount" value="<%=y-1%>" />
   <div class="clear"></div>
  <div class="paddingTop5"></div>
<h4>Family History</h4>
<div class="clear"></div>
  <input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowFamilyHistoryForRelation();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowFamilyHistoryForRelation();" />
  <div class="clear"></div>
   <table border="0" cellpadding="5" cellspacing="0" style="width:718px; margin-left: 5px; float:left;" class="tablestyle" id="familyHistoryGrid"> 
    <tr>
     <th align="center"></th>
      <th align="center">Relation</th>
      <th align="center">Asthma</th>
      <th align="center">Nasal allergy</th>
      <th align="center">Eczema</th>
      <th align="center">Food allergy</th>
    </tr>
  
    
    
    
    
    
    
    
              <%
              int x=1;
              if(opdRespiratorySpecialityDetailListRelation!=null && opdRespiratorySpecialityDetailListRelation.size()>0)
	{
            	  
		for(OpdRespiratorySpecialityDetail opdRespiratorySpecialityDetail:opdRespiratorySpecialityDetailListRelation){
		
	 %> 	  
       <tr>
<td><input  type="checkbox" class="radioCheck" name="familyHistoryRadio<%=x%>" id="familyHistoryRadio<%=x%>" /></td>
      <td>
		<select name="relation<%=x%>" id="relation<%=x%>">
		<option value="">Select</option>
		<option value="Mother">Mother</option>
		<option value="Father">Father</option>
		<option value="Sibiling">Sibiling</option>
		<option value="2 relatives">2°  Relatives</option>
		</select>
		
		
		<script>
<%
if(opdRespiratorySpecialityDetail.getParameterName()!=null){
%>
document.getElementById('relation<%=x%>').value = '<%=opdRespiratorySpecialityDetail.getParameterName()%>';

<%}%>
</script>
		</td> 


 <td align="left"><select name="asthma<%=x%>" id="asthma<%=x%>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select>

  
		  		<script>
<%
if(opdRespiratorySpecialityDetail.getAsthma()!=null){
%>
document.getElementById('asthma<%=x%>').value = '<%=opdRespiratorySpecialityDetail.getAsthma()%>';

<%}%>
</script>
		  
		  </td>
	    <td align="left"><select name="nasalAllergy<%=x%>" id="nasalAllergy<%=x%>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select>
	  		<script>
<%
if(opdRespiratorySpecialityDetail.getNasalAllergy()!=null){
%>
document.getElementById('nasalAllergy<%=x%>').value = '<%=opdRespiratorySpecialityDetail.getNasalAllergy()%>';

<%}%>
</script>
	  </td>
	  	    <td align="left"><select name="eczema<%=x%>" id="eczema<%=x%>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select>
	  	  
	  	  		<script>
<%
if(opdRespiratorySpecialityDetail.getEczema()!=null){
%>
document.getElementById('eczema<%=x%>').value = '<%=opdRespiratorySpecialityDetail.getEczema()%>';

<%}%>
</script>
	  	  </td>
		 <td align="left"><select name="foodAllergy<%=x%>" id="foodAllergy<%=x%>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select>
		  
		  		<script>
<%
if(opdRespiratorySpecialityDetail.getFoodAllergy()!=null){
%>
document.getElementById('foodAllergy<%=x%>').value = '<%=opdRespiratorySpecialityDetail.getFoodAllergy()%>';

<%}%>
</script>
		  </td>
	
		</tr>	
     
    
        <%
        x++;
		}}else{%>
          <tr>
    <td><input  type="checkbox" class="radioCheck" name="familyHistoryRadio<%=x%>" id="familyHistoryRadio<%=x%>" /></td> 
      <td>
		<select name="relation<%=x%>" id="relation<%=x%>">
		<option value="">Select</option>
		<option value="Mother">Mother</option>
		<option value="Father">Father</option>
		<option value="Sibiling">Sibiling</option>
		<option value="2 relatives">2°  Relatives</option>
		</select>
		</td>
      <td align="left"><select name="asthma<%=x%>" id="asthma<%=x%>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select></td>
     <td align="left"><select name="nasalAllergy<%=x%>" id="nasalAllergy<%=x%>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select></td>
     <td align="left"><select name="eczema<%=x%>" id="eczema<%=x%>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select></td>
     <td align="left"><select name="foodAllergy<%=x%>" id="foodAllergy<%=x%>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select></td>
		  <tr>
		      <%
		      x++;      
		} %>
    
    
  </table>
  <input type="hidden" name="familyHistoryCount" id="familyHistoryCount" value="<%=x-1%>" />
</div>
 <div class="clear"></div>
<div class="paddingTop5"></div>
 <div class="clear"></div>
 <label style="height:auto; line-height: 17px;">Contact with Tuberculosis</label>
<input type="text"  id="contactWithTuberculosis" name="contactWithTuberculosis" tabindex="1" value="<%=contactWithTuberculosis %>"  maxlength="250"/> 
 <div class="clear"></div>
<h4>Immunization</h4>
 <div class="clear"></div>
 <label>Routine</label>
 <select name="immunizationRoutine" id="immunizationRoutine">
 <% if (immunizationRoutine.equals("Complete")){ %>
		
		<option value="">Select</option>
		<option value="Complete" selected="selected">Complete</option>
		<option value="Partial">Partial</option>
		
		<%}else if (immunizationRoutine.equals("Partial")){ %>
		<option value="">Select</option>
		<option value="Complete">Complete</option>
		<option value="Partial"  selected="selected">Partial</option>
		
		<%}else{ %>
		<option value="">Select</option>
		<option value="Complete">Complete</option>
		<option value="Partial">Partial</option>
		
		<%} %>
		</select>
<label>Optional</label>
		<select name="immunizationOptional" id="immunizationOptional">
		 <% if (immunizationOptional.equals("Hib")){ %>
		<option value="">Select</option>
		<option value="Hib" selected="selected">Hib</option>
		<option value="MMR">MMR</option>
		<option value="Pneumo">Pneumo</option>	
		<%}else if (immunizationRoutine.equals("MMR")){ %>
	<option value="">Select</option>
		<option value="Hib">Hib</option>
		<option value="MMR" selected="selected">MMR</option>
		<option value="Pneumo">Pneumo</option>
		<%}else if (immunizationRoutine.equals("Pneumo")){ %>
		<option value="">Select</option>
		<option value="Hib">Hib</option>
		<option value="MMR">MMR</option>
		<option value="Pneumo" selected="selected">Pneumo</option>
		
		<%}else{ %>
		<option value="">Select</option>
		<option value="Hib">Hib</option>
		<option value="MMR">MMR</option>
		<option value="Pneumo">Pneumo</option>
		
		<%} %>
	
		
		</select>
		 <div class="clear"></div>
<h4>Environmental Exposure</h4>
 <div class="clear"></div>
  <label class="heightAuto">Exposure to cigarette smoke</label>
<input type="text"  id="exposureToCigaretteSmoke" name="exposureToCigaretteSmoke" tabindex="1" value="<%=exposureToCigaretteSmoke %>" maxlength="250"  /> 
 <label class="heightAuto">Exposure to biomass fuel/mosquito coils</label>
<input type="text"  id="exposureToBiomassFuel" name="exposureToBiomassFuel" tabindex="1" value="<%= exposureToBiomassFuel%>"  maxlength="250" /> 
 <div class="clear"></div>
 <label class="heightAuto">Exposure to traffic pollution</label>
<input type="text"  id="exposureToTrafficPollution" name="exposureToTrafficPollution" tabindex="1" value="<%=exposureToTrafficPollution %>"   maxlength="250"/> 
<label style="height:auto; line-height: 17px;">Exposure to pets</label>
<input type="text"  id="exposureToPets" name="exposureToPets" tabindex="1" value="<%=exposureToPets %>"  maxlength="250" /> 

<h4>Sign of Atopy</h4>
 <div class="clear"></div>
  <label>Skin</label>
  
  <textarea onkeyup="return checkLength(this)" name="skin" id="skin"   cols="0" rows="0" maxlength="512" style="display: block"><%=skin %></textarea>
 
 <label>Face</label>
   <textarea onkeyup="return checkLength(this)" name="face" id="face"   cols="0" rows="0" maxlength="512" style="display: block"><%=face %></textarea>
 <div class="clear"></div>
 <label>Conjunctivitis</label>
   <textarea onkeyup="return checkLength(this)" name="conjunctiva" id="conjunctiva"   cols="0" rows="0" maxlength="512" style="display: block"><%=conjunctiva %></textarea>
 
<label>Ear</label>
  <textarea onkeyup="return checkLength(this)" name="ear" id="ear"   cols="0" rows="0" maxlength="512" style="display: block"><%=ear %></textarea>
 
 <div class="clear"></div>
<label>Nose</label>
  <textarea onkeyup="return checkLength(this)" name="nose" id="nose"   cols="0" rows="0" maxlength="512" style="display: block"><%=nose %></textarea>
 
<label>Throat</label>
  <textarea onkeyup="return checkLength(this)" name="throat" id="throat"   cols="0" rows="0" maxlength="512" style="display: block"><%=throat %></textarea>

 <div class="clear"></div>
<label>Clubbing</label>
  <textarea onkeyup="return checkLength(this)" name="clubbing" id="clubbing"   cols="0" rows="0" maxlength="512" style="display: block"><%=clubbing %></textarea>


<label>Work of breathing</label>
  <textarea onkeyup="return checkLength(this)" name="workOfBreathing" id="workOfBreathing"   cols="0" rows="0" maxlength="512" style="display: block"><%=workOfBreathing %></textarea>

 <div class="clear"></div>
<label>Chest</label>
  <textarea onkeyup="return checkLength(this)" name="chest" id="chest"   cols="0" rows="0" maxlength="512" style="display: block"><%=chest %></textarea>

<label>Wheeze</label>
  <textarea onkeyup="return checkLength(this)" name="wheeze" id="wheeze"   cols="0" rows="0" maxlength="512" style="display: block"><%=wheeze %></textarea>
 
 <div class="clear"></div>
<label>Shape</label>
<select name="shape" id="shape" onchange="shapeValueDisplay(this.value);">

		 <% if (shape.equals("Normal")){ %>
		<option value="">Select</option>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Hyper Inflated">Hyper Inflated</option>
		<option value="Abnormal">Abnormal(Specify)</option>
		<option value="Deformed">Deformed(Specify)</option>
		<%}else if (shape.equals("Hyper Inflated")){ %>
	<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Hyper Inflated" selected="selected">Hyper Inflated</option>
		<option value="Abnormal">Abnormal(Specify)</option>
		<option value="Deformed">Deformed(Specify)</option>
		<%}else if (shape.equals("Deformed")){ %>
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Hyper Inflated">Hyper Inflated</option>
		<option value="Abnormal">Abnormal(Specify)</option>
		<option value="Deformed" selected="selected">Deformed(Specify)</option>
		
			<%}else if (shape.equals("Abnormal")){ %>
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Hyper Inflated">Hyper Inflated</option>
		<option value="Abnormal"  selected="selected">Abnormal(Specify)</option>
		<option value="Deformed" selected="selected">Deformed(Specify)</option>
		
		<%}else{ %>
	<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Hyper Inflated">Hyper Inflated</option>
		<option value="Abnormal">Abnormal(Specify)</option>
		<option value="Deformed">Deformed(Specify)</option>
		
		<%} %>
	


	
		</select>
		<div style="display: none" id="shapeValueDiv">
		  <textarea onkeyup="return checkLength(this)" name="shapeValue" id="shapeValue"   cols="0" rows="0" maxlength="512" style="display: block"><%=shapeValue %></textarea>
		
		</div> 
		 <div class="clear"></div>
<label>Breath Sounds</label>
<select name="breathSounds" id="breathSounds" onchange="breathSoundsDisaply(this.value);">
	 <% if (breathSounds.equals("Normal")){ %>
		<option value="Normal" selected="selected">Normal</option>
		<option value="Abnormal">Abnormal(Specify)</option>
<%}if (breathSounds.equals("Abnormal")){  %>
		<option value="Normal">Normal</option>
		<option value="Abnormal"  selected="selected">Abnormal(Specify)</option>
<%}else{ %>
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal(Specify)</option>
		<%} %>
		</select>
		<div style="display: none" id="breathSoundsValDiv">
				  <textarea onkeyup="return checkLength(this)" name="breathSoundsValue" id="breathSoundsValue"   cols="0" rows="0" maxlength="512" style="display: block"><%=breathSoundsValue %></textarea>
		</div>
	 <div class="clear"></div>	
<label>Other Adventitious sounds</label>
  <textarea onkeyup="return checkLength(this)" name="otherAdventitiousSounds" id="otherAdventitiousSounds"   cols="0" rows="0" maxlength="512" style="display: block"><%=otherAdventitiousSounds %></textarea>

<label>Abdomen</label>
  <textarea onkeyup="return checkLength(this)" name="abdomen" id="abdomen"   cols="0" rows="0" maxlength="512" style="display: block"><%=abdomen %></textarea>

 <div class="clear"></div>
<label>CVS</label>
  <textarea onkeyup="return checkLength(this)" name="cvs" id="cvs"   cols="0" rows="0" maxlength="512" style="display: block"><%=cvs %></textarea>

<label>Allergy Skin Test</label>
  <textarea onkeyup="return checkLength(this)" name="allergySkinTest" id="allergySkinTest"   cols="0" rows="0" maxlength="512" style="display: block"><%=allergySkinTest %></textarea>
  
 <div class="clear"></div>
<label>Asthma Education</label>
<select name="asthmaEducation" id="asthmaEducation">

				 <% if (asthmaEducation.equals("Given")){ %>
		<option value="">Select</option>
		<option value="Given" selected="selected">Given</option>
		<option value="Not Given">Not Given</option>
		<%}else if (asthmaEducation.equals("Not Given")){ %>
		<option value="">Select</option>
		<option value="Given">Given</option>
		<option value="Not Given" selected="selected">Not Given</option>
		
		<%}else{ %>
		<option value="">Select</option>
		<option value="Given">Given</option>
		<option value="Not Given">Not Given</option>
		
		<%} %>
		</select>
		<label>Action Plan</label>
<select name="actionPlan" id="actionPlan">

			 <% if (actionPlan.equals("Given")){ %>
		<option value="">Select</option>
		<option value="Given" selected="selected">Given</option>
		<option value="Not Given">Not Given</option>
		<%}else if (actionPlan.equals("Not Given")){ %>
		<option value="">Select</option>
		<option value="Given">Given</option>
		<option value="Not Given" selected="selected">Not Given</option>
		
		<%}else{ %>
		<option value="">Select</option>
		<option value="Given">Given</option>
		<option value="Not Given">Not Given</option>
		
		<%} %>
		</select>
		 <div class="clear"></div>
		
		<label>Asthma Diary</label>
<select name="actionDiary" id="actionDiary">


		 <% if (actionDiary.equals("Given")){ %>
		<option value="">Select</option>
		<option value="Given" selected="selected">Given</option>
		<option value="Not Given">Not Given</option>
		<%}else if (actionDiary.equals("Not Given")){ %>
		<option value="">Select</option>
		<option value="Given">Given</option>
		<option value="Not Given" selected="selected">Not Given</option>
		
		<%}else{ %>
		<option value="">Select</option>
		<option value="Given">Given</option>
		<option value="Not Given">Not Given</option>
		
		<%} %>
	
		</select>
		
	<div class="clear"></div>
<%-- <%if(reVisitList.size()>0){ %> --%>
<h4>Pediatric Asthma Clinic Follow Up</h4>

 <div class="clear"></div>
 <label>Severity at Diagnosis</label>
<input type="text"  id="severityAtDiagnosis" name="severityAtDiagnosis" tabindex="1" value="<%=severityAtDiagnosis%>" maxlength="250" />  
<label>Interval Since Last Visit</label>
<input type="text"  id="intervalSinceLastVisit" name="intervalSinceLastVisit" tabindex="1" value="<%=intervalSinceLastVisit%>"   maxlength="250"/>  
 <div class="clear"></div>
 <label>Symptoms</label>
<input type="text"  id="symptoms" name="symptoms" tabindex="1" value="<%=symptoms %>"   maxlength="250"/> 
<label>Current Symptoms</label>
<input type="text"  id="currentSymptoms" name="currentSymptoms" tabindex="1" value="<%=currentSymptoms%>"   maxlength="250"/>  
	 <div class="clear"></div>
	 <label>No. of exacerbations since last visit</label>
<input type="text"  id="noOfExacerbation" name="noOfExacerbation" tabindex="1" value="<%=noOfExacerbation%>"   maxlength="250"/> 
<label>Hospital Admissions</label>
<input type="text"  id="hospitalAdmissionsFollowUp" name="hospitalAdmissionsFollowUp" tabindex="1" value="<%=hospitalAdmissionsFollowUp %>"   maxlength="3" validate="Hospital Admissions,num,no" />  
 		 <div class="clear"></div>
 <label>Oral Steroid Use</label>
<input type="text"  id="oralSteroidUse" name="oralSteroidUse" tabindex="1" value="<%=oralSteroidUse %>"   maxlength="250"/>  	
 <label class="heightAuto">Participation in Physical Activities</label>
<input type="text"  id="physicalActivities" name="physicalActivities" tabindex="1" value="<%=physicalActivities %>"   maxlength="250"/> 
 <div class="clear"></div>
<h4>Review Control</h4>	
<div class="clear"></div>
<div class="clear"></div>


    <%if(opdRespiratorySpecialityDetailListReviewControl!=null && opdRespiratorySpecialityDetailListReviewControl.size()>0)
	{
      int a= 1;
	%>
	<table border="0" cellpadding="5" cellspacing="0" style="width:718px; margin-left: 5px; float:left;" class="tablestyle" id="symptomsGrid"> 
    <tr>
     <th align="center"></th>
      <th align="center">Controlled(All Features)</th>
      <th align="center">Partly Controlled(Any in any wk)</th>
      <th align="center">UnControlled(>= 3 in any wk)</th>
    </tr>
   
   	<%
      	
    String q="";
    String b="";
    String ab="";
    String aa="";
    String qq="";
	for(OpdRespiratorySpecialityDetail opdRespiratorySpecialityDetail:opdRespiratorySpecialityDetailListReviewControl){
		q=opdRespiratorySpecialityDetail.getControlled();	
		b=opdRespiratorySpecialityDetail.getPartlyControlled();
		aa=opdRespiratorySpecialityDetail.getUncontrolled();
		qq=opdRespiratorySpecialityDetail.getReviewControlFlag();
		
		
		
		System.out.println("q----"+q);
		System.out.println("b----"+b);
		System.out.println("aa----"+aa);
		System.out.println("qq-----"+qq);
	}
		%>
	 <% String c1="= 2 days/week"; 
   String c2="2 days/week";
   
   
   %>
   
   <tr>
   	<td>Day Symptoms<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=a%>" id="reviewControlFlag<%=a%>" value="Day Symptoms"/></td>
  <td><input  type="checkbox" class="radioCheck" name="controlled<%=a %>" id="controlled<%=a %>" value="<%=c1%>"/><%=c1%>
   
   <script>
   <%
   if(q!=null  &&  qq.equals("Day Symptoms")){
   %>
     
   document.getElementById('controlled<%=a%>').checked = true;
   <%}%>
   </script>
   
   </td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=a%>" id="partlyControlled<%=a%>" value="<%=c2 %>" /><%=c2%>
     <script>
   <%
   if(b!=null && qq.equals("Day Symptoms")){
   %>
   
   document.getElementById('partlyControlled<%=a%>').checked = true;
   <%}%>
   </script> 
   
   </td>
   <td><input  type="checkbox" class="radioCheck" name="unControlled<%=a%>" id="unControlled<%=a%>" value="<%=c1 %>" /><%=c1%>
 
        <script>
   <%
   if( aa!=null && qq.equals("Day Symptoms")){
   %>
   
   document.getElementById('unControlled<%=a%>').checked = true;
   <%}%>
   </script> 
   </td>
   </tr>
   <%a++; %>
    <tr>
 
    
   <td>Night Awakening<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=a%>" id="reviewControlFlag<%=a%>" value="Night Awakening"/></td>
  
     <td><input  type="checkbox" class="radioCheck" name="controlled<%=a%>" id="controlled<%=a%>" value="None"  />None
   
    
      
   <script>
   <%
   if(q!=null &&  qq.equals("Night Awakening")){
   %>
   
   document.getElementById('controlled<%=a%>').checked = true;
   <%}%>
   </script>
   
   </td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=a%>" id="partlyControlled<%=a%>" value="Any" />Any
     <script>
   <%
   if(b!=null && qq.equals("Night Awakening")){
   %>
   
   document.getElementById('partlyControlled<%=a%>').checked = true;
   <%}%>
   </script> 
   
   </td>
   
    <td><input  type="checkbox" class="radioCheck" name="unControlled<%=a%>" id="unControlled<%=a%>" value="<%=c1 %>" /><%=c1 %>
   
         <script>
   <%
   if(aa!=null && qq.equals("Night Awakening")){
   %>
   
   document.getElementById('unControlled<%=a%>').checked = true;
   <%}%>
   </script>
   </td>
   </tr>
   <%a++; %>
   
    <tr>
   <td>Activity Limitation<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=a%>" id="reviewControlFlag<%=a%>" value="Activity Limitation"/></td>
   
   
  <td><input  type="checkbox" class="radioCheck" name="controlled<%=a%>" id="controlled<%=a%>" value="None"  />None
   
   
     
   <script>
   <%
   
   if(q!=null &&  qq.equals("Activity Limitation")){
   %>
   
   document.getElementById('controlled<%=a%>').checked = true;
   <%}%>
   </script> 
   
   </td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=a%>" id="partlyControlled<%=a%>" value="Any" />Any
    <script>
   <%
   if( b!=null &&  qq.equals("Activity Limitation")){
   %>
   
   document.getElementById('partlyControlled<%=a%>').checked = true;
   <%}%>
   </script>
   </td>
   
    <td><input  type="checkbox" class="radioCheck" name="unControlled<%=a%>" id="unControlled<%=a%>" value="<%=c1 %>" /><%=c1 %>
   
       <script>
   <%
   if(aa!=null && qq.equals("Activity Limitation")){
   %>
   
   document.getElementById('unControlled<%=a%>').checked = true;
   <%}%>
   </script>
   </td>
   </tr>
   <%a++; %>
    <tr>
   <td>Need for SABA<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=a%>" id="reviewControlFlag<%=a%>" value="Need for SABA"/></td>
   <td><input  type="checkbox" class="radioCheck" name="controlled<%=a%>" id="controlled" value="<%=c1%>"/><%=c1%>

   <script>
   <%
   if(q!=null && qq.equals("Need for SABA")){
   %>
   
   document.getElementById('controlled<%=a%>').checked = true;
   <%}%>
   </script>
   
   </td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=a%>" id="partlyControlled<%=a%>" value="<%=c2 %>" /><%=c2%>
      
<script>
   <%
   if(b!=null && qq.equals("Need for SABA")){
   %>
   
   document.getElementById('partlyControlled<%=a%>').checked = true;
   <%}%>
   </script> 
   
   </td>
   
   <td><input  type="checkbox" class="radioCheck" name="unControlled<%=a%>" id="unControlled<%=a%>" value="<%=c2 %>" /><%=c2%>
 
        <script>
   <%
   if(aa!=null && qq.equals("Need for SABA") && q.equals("2 days/week")){
   %>
   document.getElementById('unControlled<%=a%>').checked = true;
   
   <%}%>
   </script> 
   </td>
   
   
   
   </tr>
	 <%a++; %>
	   </table>
	   <input type="hidden" name="reviewControl" id="reviewControl" value="<%=a%>" />
   <%}else{
   int ii=1;
   %>
   
   
   
   
   	<table border="0" cellpadding="5" cellspacing="0" style="width:718px; margin-left: 5px; float:left;" class="tablestyle" id="symptomsGrid"> 
    <tr>
     <th align="center"></th>
      <th align="center">Controlled(All Features)</th>
      <th align="center">Partly Controlled(Any in any wk)</th>
      <th align="center">UnControlled(>= 3 in any wk)</th>
    </tr>
  
  <tr>
   <% String c1="<= 2 days/week"; 
   String c2="> 2 days/week";
   
   
   %>
   <td>Day Symptoms<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=ii%>" id="reviewControlFlag<%=ii %>" value="Day Symptoms"/></td>
   <td><input  type="checkbox" class="radioCheck" name="controlled<%=ii %>" id="controlled" value="<%=c1%>"/> <%=c1%></td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=ii %>" id="partlyControlled" value="<%=c2 %>" /> <%=c2%></td>
   <td><input  type="checkbox" class="radioCheck" name="unControlled<%=ii%>" id="unControlled" value="<%=c1 %>" /> <%=c1%></td>
   </tr>
   <%ii++; %>
    <tr>
 
    
   <td>Night Awakening<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=ii %>" id="reviewControlFlag<%=ii %>" value="Night Awakening"/></td>
   <td><input  type="checkbox" class="radioCheck" name="controlled<%=ii %>" id="symptomsControlled" value="None" />None</td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=ii %>" id="partlyControlled" value="Any" />Any</td>
   <td><input  type="checkbox" class="radioCheck" name="unControlled<%=ii %>" id="unControlled" value="<%=c1 %>" /><%=c1 %></td>
   </tr>
   <%ii++; %>
   
    <tr>
   <td>Activity Limitation<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=ii %>" id="reviewControlFlag<%=ii %>" value="Activity Limitation"/></td>
   <td><input  type="checkbox" class="radioCheck" name="controlled<%=ii %>" id="controlled" value="None"  />None</td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=ii %>" id="partlyControlled" value="Any" />Any</td>
   <td><input  type="checkbox" class="radioCheck" name="unControlled<%=ii %>" id="unControlled" value="<%=c1 %>" /><%=c1 %></td>
   </tr>
   <%ii++; %>
    <tr>
   <td>Need for SABA<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=ii %>" id="reviewControlFlag<%=ii %>" value="Need for SABA"/></td>
   <td><input  type="checkbox" class="radioCheck" name="controlled<%=ii %>" id="controlled" value="<%=c1%>"/> <%=c1%></td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=ii %>" id="partlyControlled" value="<%=c2 %>" /> <%=c2%></td>
   <td><input  type="checkbox" class="radioCheck" name="unControlled<%=ii %>" id="unControlled" value="<%=c2 %>" /> <%=c2%></td>
   </tr>
   <%ii++; %>
 
    </table>
    <input type="hidden" name="reviewControl" id="reviewControl" value="<%=ii %>" />
  
   <%} %>
    
<div class="clear"></div>

<div class="paddingTop5"></div>
<div class="clear"></div>
<label>Check Inhaler Technique</label>
<input type="text"  id="inhalerTechnique" name="inhalerTechnique" tabindex="1" value="<%=inhalerTechnique %>"  maxlength="250"/> 

 <label class="heightAuto">Adherence to treatment Plan</label>
<input type="text"  id="adherenceToTreatmentPlan" name="adherenceToTreatmentPlan" tabindex="1" value="<%=adherenceToTreatmentPlan %>"   maxlength="250"/> 
   <div class="clear"></div>
<label>Asthma Diary</label>
<input type="text"  id="asthmaDiaryFollowUp" name="asthmaDiaryFollowUp" tabindex="1" value="<%=asthmaDiaryFollowUp %>"  maxlength="250" /> 

<div class="clear"></div>
<h4>Physical Examination</h4>	
<div class="clear"></div>

<label>Height</label>
<input type="text"  id="heightFollowUp" name="heightFollowUp" tabindex="1" value="<%=height != 0?height:"" %>"   validate="Height,num,no" maxlength="3" /> 
<label	class="smallAuto">Cm</label>
 <label>Weight</label>
<input type="text"  id="weightFollowUp" name="weightFollowUp" tabindex="1" value="<%=weight != 0?weight:"" %>"   validate="Weight,float,no" maxlength="5" /> 
<label	class="smallAuto">kg</label>
<div class="clear"></div>
<label>Heart Rate</label>
<input type="text"  id="heartRate" name="heartRate" tabindex="1" value="<%=heartRate %>"  validate="Heart Rate,num,no" maxlength="3"/> 
<label	class="smallAuto">min</label>
<label>Respiratory Rate</label>
<input type="text"  id="respiratoryRateFollowUp" name="respiratoryRateFollowUp" tabindex="1" value="<%=respiratoryRate != 0?respiratoryRate:"" %>"  validate="Respiratory Rate,num,no" maxlength="3"/> 
<label	class="smallAuto">min</label>

<div class="clear"></div>
<label>BP</label>
<%
String[] parts={"",""};

if(bp != null){
	if(!bp.equals("") && bp.indexOf("/")!=-1){
		parts = bp.split("/");
	}
}
%>
 <input name="systolicFollowUp" id="systolicFollowUp" tabindex="14" placeholder="Systolic" value="<%=parts.length>0 && parts[0] != null?parts[0]:""%>" validate="BP-Systolic,int,no" type="text" maxlength="3" class="textYellow allownumericwithoutdecimal textSmall" />
  <label id="bpLabel" class="auto"><span style="color: black">/</span></label>
<input name="diastolicFollowUp" id="diastolicFollowUp" tabindex="15" placeholder="Diastolic" value="<%=parts.length>0 && parts[1] != null ?parts[1]:""%>" validate="BP-Diastolic,int,no" type="text" maxlength="3" class="textYellow allownumericwithoutdecimal textSmall" /></span>
 <label class="smallAuto autoSpace">mm&nbsp;Hg</label>
 <label style="margin-left:36px;">Sinuses</label>
<input type="text"  id="cineses" name="cineses" tabindex="1" value="<%=cineses %>"   maxlength="250"/> 
<%-- 
<%}%> --%>



<%}else{ %>


<label>Father's Name</label>
<input type="text"  id="fatherName" name="fatherName" tabindex="1" value="" maxlength="30" validate="Father's Name,string,no"/>
<label>Mother's Name</label>
<input type="text"  id="motherName" name="motherName" tabindex="1" value=""  maxlength="30" validate="Mother's Name,string,no"/>
<div class="clear"></div>
<label>Father's Occupation</label>
<input type="text"  id="fatherOccupation" name="fatherOccupation" tabindex="1" value=""   maxlength="100" validate="Father's Occupation,string,no"/>
<label>Mother's Occupation</label>
<input type="text"  id="motherOccupation" name="motherOccupation" tabindex="1" value=""   maxlength="100" validate="Mother's Occupation,string,no"/>
<div class="clear"></div>
<label>Father's Education</label>
<input type="text"  id="fatherEducation" name="fatherEducation" tabindex="1" value=""   maxlength="30" validate="Father's Education,string,no"/>
<label>Mother's Education</label>
<input type="text"  id="motherEducation" name="motherEducation" tabindex="1" value=""  maxlength="30" validate="Mother's Education,string,no"/>
<div class="clear"></div>
<label>Age of Onset of Symptoms</label>
<input type="text"  id="ageOnSetSymptoms" maxlength="3" name="ageOnSetSymptoms" tabindex="1" value=""  onkeypress="javascript:return isNumber(event)" validate="Age of Onset of Symptoms,num,no"/>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<h4>Chief Complaints</h4>
<div class="clear"></div>
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForSymptoms();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForSymptoms();" />
  <div class="clear"></div>
<table border="0" cellpadding="5" cellspacing="0" style="width:718px; margin-left: 5px; float:left;" class="tablestyle" id="symptomsGrid"> 
    <tr>
     <th align="center"></th>
      <th align="center">Symptoms</th>
      <th align="center">Duration</th>
      <th align="center">Frequency</th>
      <th align="center">Remarks</th>
    </tr>
   <tr>
   <tr>
   <%
   int incr=1;
   for(incr=1;incr<2;incr++){ %>
<td><input  type="checkbox" class="radioCheck" name="symptomsRadio<%=incr%>" id="symptomsRadio<%=incr%>"  ></td>
<td>
<select name="symptoms<%=incr%>" id="symptoms<%=incr%>" onchange="symptomsOtherVal(this.value,<%=incr%>);">
<option value="">Select</option>
<option value="Cough">Cough</option>
<option value="Wheezing">Wheezing</option>
<option value="Breathlessness">Breathlessness</option>
<option value="Chest tightness">Chest tightness</option>
<option value="Chest Pain">Chest Pain</option>
<option value="Exercise Limitation">Exercise Limitation</option>
<option value="Others">Others</option>
</select>

<div class="clear"></div> 
		<div style="display: none" id="showsymptomsOthersDiv<%=incr%>">
				<input type="text" maxlength="16" tabindex="1" value="" name="showsymptomsOthers<%=incr%>" id="showsymptomsOthers<%=incr %>" class="medium" />
		</div>
</td>
<td><input type="text" name="durationSymptoms<%=incr%>" id="durationSymptoms<%=incr%>" onkeypress="javascript:return isNumberDecimal(event)" value="" maxlength="5" validate="Duration,float,no"/></td>
<td><input type="text" name="frequencySymptoms<%=incr%>" id="frequencySymptoms<%=incr%>" onkeypress="javascript:return isNumber(event)" value="" maxlength="3" validate="Frequency,num,no"/></td>
<td><input type="text" name="remarksSymptoms<%=incr%>" id="remarksSymptoms<%=incr%>"  value="" maxlength="50"/></td>
<%
   } %>
</tr>   
</table>  

<input type="hidden" name="symptomsCount" id="symptomsCount" value="<%=incr-1 %>" />

<div class="clear"></div>
<div class="paddingTop5"></div>

<label>Details of Exacerbation</label>
<input type="text"  id="detailsOfExacerbation" name="detailsOfExacerbation" tabindex="1" value=""  maxlength="50"/>
  <div class="clear"></div>
<label>Frequency Over 1 Year</label>
<input type="text"  id="frequencyOverOneYear" name="frequencyOverOneYear" tabindex="1" value="" maxlength="5"  onkeypress="javascript:return isNumberDecimal(event)" validate="Frequency Over 1 Year,float,no"/>
<label>Casualty Visits</label>
<input type="text"  id="casualtyVisits" name="casualtyVisits" tabindex="1" value=""  maxlength="5" onkeypress="javascript:return isNumberDecimal(event)" validate="Casualty Visits,float,no"/>
  <div class="clear"></div>
<label>Hospital Admissions</label>
<input type="text"  id="hospitalAdmissions" name="hospitalAdmissions" tabindex="1" value=""  maxlength="5" onkeypress="javascript:return isNumberDecimal(event)" validate="Hospital Admission,float,no" />
<label>ICU Admissions</label>
<input type="text"  id="icuAdmissions" name="icuAdmissions" tabindex="1" value=""  maxlength="5" onkeypress="javascript:return isNumberDecimal(event)" validate="ICU Admissions,float,no"/>
<div class="clear"></div>
<label>Triggers</label>
<select  multiple="multiple" class="multiple" name="triggers">
<option value="Viral Infections">Viral Infections</option>
<option value="Cold air">Cold air</option>
<option value="Change of season">Change of season</option>
<option value="Dust">Dust</option>
<option value="Smoke">Smoke</option>
<option value="Exposure to animals">Exposure to animals</option>
<option value="Bronchiolitis">Bronchiolitis</option>
<option value="Exercise">Exercise</option>
<option value="Others">Others</option>
</select>
<input type="text"  id="triggersValue" name="triggersValue" tabindex="1" value=""  maxlength="256"/>
<div class="clear"></div>
<label>Past History</label>
<select  multiple="multiple" class="multiple" name="pastHistory">
<option value="Recurrent URTI">Recurrent URTI</option>
<option value="Documented Pneumoniar">Documented Pneumonia</option>
<option value="FB Aspiration">FB Aspiration</option>
<option value="GER Symptoms">GER Symptoms</option>
<option value="Obstructive sleep symptoms">Obstructive sleep symptoms</option>
<option value="Bronchiolitis">Bronchiolitis</option>
<option value="Allergic rhinitis">Allergic rhinitis</option>
<option value="Allergic conjunctivitis">Allergic conjunctivitis</option>
<option value="Eczema/Atopy">Eczema/Atopy</option>
<option value="Whooping cough">Whooping cough</option>
<option value="Eczema/Atopy">Eczema/Atopy</option>
<option value="Measles">Measles</option>
</select>
<input type="text"  id="pastHistoryValue" name="pastHistoryValue" tabindex="1" value=""   maxlength="256"/>
   <div class="clear"></div>
   <h4>Birth History</h4>
    <div class="clear"></div>
<label>Gestational Age</label>
<input type="text"  id="gestationalAge" name="gestationalAge" tabindex="1" value=""  onkeypress="javascript:return isNumber(event)"  validate="Gestational Age,num,no" maxlength="3"/>
<select id="gestationalAgeParameter" name="gestationalAgeParameter" tabindex="1" class="medium2" >
<option value="">Select</option>	
<option value="Days">Days</option>
<option value="Weeks">Weeks</option>
</select>
<label>Birth Weight</label>
<input type="text"  id="birthWeight" name="birthWeight" tabindex="1" value=""    onkeypress="javascript:return isNumberDecimal(event)" validate="Birth Weight,float,no" maxlength="5"/>
 <div class="clear"></div>
<label class="heightAuto">Neonatal respiratory symptoms/diagnosis</label>
<input type="text"  id="neonatalrespiratorySymptoms" name="neonatalrespiratorySymptoms" tabindex="1" value=""  maxlength="256"/> 
  <div class="clear"></div>
  <div class="clear"></div>
<h4>Treatment History</h4>
<div class="clear"></div>
  <div class="clear"></div>
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForTreatmentHistory();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForTreatmentHistory();" />
  <div class="clear"></div>
  <table border="0" cellpadding="5" cellspacing="0" style="width:718px; margin-left: 5px; float:left;" class="tablestyle" id="treatmentHistoryGrid"> 
    <tr>
    <th align="center"></th>
      <th align="center">Medications</th>
      <th align="center">Ever Used</th>
      <th align="center">Duration</th>
      <th align="center">Name</th>
      <th align="center">Response</th>
    </tr>
    <tr>
    <%
   int incr1=1;
   for(incr1=1;incr1<2;incr1++){ %>
      <td><input  type="checkbox" class="radioCheck" name="treatmentHistoryRadio<%=incr1 %>" id="treatmentHistoryRadio<%=incr1 %>" /></td> 
		<td>
		<select name="medications<%=incr1 %>" id="medications<%=incr1 %>">
		<option value="">Select</option>
		<option value="Bronchodilators">Bronchodilators</option>
		<option value="Inhaled steroids">Inhaled steroids</option>
		<option value="Oral steroids">Oral steroids</option>
		<option value="Antibiotics">Antibiotics</option>
		<option value="Anti TB treatment">Anti TB treatmen</option>
		<option value="Others">Others</option>
		</select>
		</td>
      <td align="left"><input type="text" maxlength="120" validate="Ever Used,metachar,no" tabindex="1" value="" name="everUsedTreatment<%=incr1 %>" id="everUsedTreatment<%=incr1 %>" ></td>
      <td align="left"><input type="text" maxlength="5" validate="Duration,float,no"  onkeypress="javascript:return isNumberDecimal(event)" tabindex="1" value="" name="durationTreatment<%=incr1 %>" id="durationTreatment<%=incr1 %>"  ></td>
      <td align="left"><input type="text" maxlength="120" validate="Name,metachar,no" tabindex="1" value="" name="nameTreatment<%=incr1 %>" id="nameTreatment<%=incr1 %>" ></td>
      <td align="left"><input type="text" maxlength="50" validate="Response,metachar,no" tabindex="1" value="" name="responseTreatment<%=incr1 %>" id="responseTreatment<%=incr1 %>"></td>
      <%} %>
    </tr>
   
    
  </table>
  <input type="hidden" name="treatmentHistoryCount" id="treatmentHistoryCount" value="<%=incr1-1 %>" />
   <div class="clear"></div>
  <div class="paddingTop5"></div>
  <div class="clear"></div>
<h4>Current Treatment</h4>
<div class="clear"></div>
   <div class="clear"></div>
<input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowForCurrentTreatment();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowForCurrentTreatment();" />
  <div class="clear"></div>
  <table border="0" cellpadding="5" cellspacing="0" style="width:724px; margin-left: 5px; float:left;" class="tablestyle" id="currentTreatmentGrid"> 
    <tr>
    <th align="center"></th>
      <th align="center">Current Treatment</th>
      <th align="center">Duration</th>
      <th align="center">Response</th>
    </tr>
    <tr>
    <%
   int incr2=1;
   for(incr2=1;incr2<2;incr2++){ %>
         <td><input  type="checkbox" class="radioCheck" name="currentTreatmentRadio<%=incr2 %>" id="currentTreatmentRadio<%=incr2 %>" /></td> 
      <td align="left"><input  type="text" maxlength="50" tabindex="1" value="" name="currentTreatment<%=incr2 %>" id="currentTreatment<%=incr2 %>"></td>
      <td align="left"><input  type="text" maxlength="5" tabindex="1" value="" name="durationCurrentTreatment<%=incr2 %>" id="durationCurrentTreatment<%=incr2 %>"  validate="Duration,float,no"  onkeypress="javascript:return isNumberDecimal(event)"></td>
      <td align="left"><input  type="text" maxlength="50" tabindex="1" value="" name="responseCurrentTreatment<%=incr2 %>"  id="responseCurrentTreatment<%=incr2 %>" ></td>
      <%} %>
    </tr>   
    
  </table>
  <!-- 2<sup>o</sup>  -->
  <input type="hidden" name="currentTreatmentCount" id="currentTreatmentCount" value="<%=incr2-1%>" />
   <div class="clear"></div>
  <div class="paddingTop5"></div>
<h4>Family History</h4>
<div class="clear"></div>
  <input type="button" class="buttonAdd" alt="Add" tabindex="4"	value="&nbsp;" onclick="addRowFamilyHistoryForRelation();" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;" onclick="removeRowFamilyHistoryForRelation();" />
  <div class="clear"></div>
   <table border="0" cellpadding="5" cellspacing="0" style="width:718px; margin-left: 5px; float:left;" class="tablestyle" id="familyHistoryGrid"> 
    <tr>
     <th align="center"></th>
      <th align="center">Relation</th>
      <th align="center">Asthma</th>
      <th align="center">Nasal allergy</th>
      <th align="center">Eczema</th>
      <th align="center">Food allergy</th>
    </tr>
    <tr>
     <%
   int incr3=1;
   for(incr3=1;incr3<2;incr3++){ %>
    <td><input  type="checkbox" class="radioCheck" name="familyHistoryRadio<%=incr3 %>" id="familyHistoryRadio<%=incr3 %>" /></td> 
      <td>
		<select name="relation<%=incr3 %>" id="relation<%=incr3 %>">
		<option value="">Select</option>
		<option value="Mother">Mother</option>
		<option value="Father">Father</option>
		<option value="Sibiling">Sibiling</option>
		<option value="2 relatives">2°  Relatives</option>
		</select>
		</td>
      <td align="left"><select name="asthma<%=incr3 %>" id="asthma<%=incr3 %>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select></td>
     <td align="left"><select name="nasalAllergy<%=incr3 %>" id="nasalAllergy<%=incr3 %>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select></td>
     <td align="left"><select name="eczema<%=incr3 %>" id="eczema<%=incr3 %>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select></td>
     <td align="left"><select name="foodAllergy<%=incr3 %>" id="foodAllergy<%=incr3 %>">
		<option value="">Select</option>
		<option value="Yes">Yes</option>
		<option value="No">No</option>
		</select></td>
		<%} %>
    </tr>
    
  </table>
  <input type="hidden" name="familyHistoryCount" id="familyHistoryCount" value="<%=incr3-1 %>" />
</div>
 <div class="clear"></div>
<div class="paddingTop5"></div>
 <div class="clear"></div>
 <label style="height:auto; line-height: 17px;">Contact with Tuberculosis</label>
<input type="text"  id="contactWithTuberculosis" name="contactWithTuberculosis" tabindex="1" value=""  maxlength="250"/> 
 <div class="clear"></div>
<h4>Immunization</h4>
 <div class="clear"></div>
 <label>Routine</label>
<select name="immunizationRoutine" id="immunizationRoutine" onchange="immunizationRoutineValue(this.value);">
		<option value="">Select</option>
		<option value="Complete">Complete</option>
		<option value="Partial">Partial</option>
		</select>
		
		<div style="display: none" id="partialValueDiv">
				<input type="text" maxlength="128" tabindex="1" value="" name="partialValue" id="partialValue" />
		</div>

		
		
		 <label>Optional</label>
<select name="immunizationOptional" id="immunizationOptional">
		<option value="">Select</option>
		<option value="Hib">Hib</option>
		<option value="MMR">MMR</option>
		<option value="Pneumo">Pneumo</option>
		</select>
		 <div class="clear"></div>
<h4>Environmental Exposure</h4>
 <div class="clear"></div>
  <label class="heightAuto">Exposure to cigarette smoke</label>
<input type="text"  id="exposureToCigaretteSmoke" name="exposureToCigaretteSmoke" tabindex="1" value="" maxlength="250"  /> 
 <label class="heightAuto">Exposure to biomass fuel/mosquito coils</label>
<input type="text"  id="exposureToBiomassFuel" name="exposureToBiomassFuel" tabindex="1" value=""  maxlength="250" /> 
 <div class="clear"></div>
 <label class="heightAuto">Exposure to traffic pollution</label>
<input type="text"  id="exposureToTrafficPollution" name="exposureToTrafficPollution" tabindex="1" value=""   maxlength="250"/> 
<label style="height:auto; line-height: 17px;">Exposure to pets</label>
<input type="text"  id="exposureToPets" name="exposureToPets" tabindex="1" value=""  maxlength="250" /> 

<h4>Sign of Atopy</h4>
 <div class="clear"></div>
  <label>Skin</label>
  
  <textarea onkeyup="return checkLength(this)" name="skin" id="skin"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>
 
 <label>Face</label>
   <textarea onkeyup="return checkLength(this)" name="face" id="face"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>

 <div class="clear"></div>
 <label>Conjunctivitis</label>
   <textarea onkeyup="return checkLength(this)" name="conjunctiva" id="conjunctiva"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>
 
<label>Ear</label>
  <textarea onkeyup="return checkLength(this)" name="ear" id="ear"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>
 
 <div class="clear"></div>
<label>Nose</label>
  <textarea onkeyup="return checkLength(this)" name="nose" id="nose"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>
   
<label>Throat</label>
  <textarea onkeyup="return checkLength(this)" name="throat" id="throat"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>

 <div class="clear"></div>
<label>Clubbing</label>
  <textarea onkeyup="return checkLength(this)" name="clubbing" id="clubbing"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>


<label>Work of breathing</label>
  <textarea onkeyup="return checkLength(this)" name="workOfBreathing" id="workOfBreathing"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>

 <div class="clear"></div>
<label>Chest</label>
  <textarea onkeyup="return checkLength(this)" name="chest" id="chest"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>

<label>Wheeze</label>
  <textarea onkeyup="return checkLength(this)" name="wheeze" id="wheeze"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>
 
 <div class="clear"></div>
<label>Shape</label>
<select name="shape" id="shape" onchange="shapeValueDisplay(this.value);"> 
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Hyper Inflated">Hyper Inflated</option>
		<option value="Abnormal">Abnormal(Specify)</option>
		<option value="Deformed">Deformed(Specify)</option>
		</select>
		<div style="display: none" id="shapeValueDiv">
		<textarea onkeyup="return checkLength(this)" name="shapeValue" id="shapeValue"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>
		</div> 
		 <div class="clear"></div>
<label>Breath Sounds</label>
<select name="breathSounds" id="breathSounds" onchange="breathSoundsDisaply(this.value);">
		<option value="">Select</option>
		<option value="Normal">Normal</option>
		<option value="Abnormal">Abnormal(Specify)</option>
		</select>
		<div style="display: none" id="breathSoundsValDiv">
		<textarea onkeyup="return checkLength(this)" name="breathSoundsValue" id="breathSoundsValue"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>
		</div>
	 <div class="clear"></div>	
<label>Other Adventitious sounds</label>
  <textarea onkeyup="return checkLength(this)" name="otherAdventitiousSounds" id="otherAdventitiousSounds"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>

<label>Abdomen</label>
  <textarea onkeyup="return checkLength(this)" name="abdomen" id="abdomen"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>

 <div class="clear"></div>
<label>CVS</label>
  <textarea onkeyup="return checkLength(this)" name="cvs" id="cvs"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>

<label>Allergy Skin Test</label>
  <textarea onkeyup="return checkLength(this)" name="allergySkinTest" id="allergySkinTest"   cols="0" rows="0" maxlength="512" style="display: block"></textarea>

 <div class="clear"></div>
<label>Asthma Education</label>
<select name="asthmaEducation" id="asthmaEducation">
		<option value="">Select</option>
		<option value="Given">Given</option>
		<option value="not Given">Not Given</option>
		</select>
		<label>Action Plan</label>
<select name="actionPlan" id="actionPlan">
		<option value="">Select</option>
		<option value="Given">Given</option>
		<option value="not Given">Not Given</option>
		</select>
		 <div class="clear"></div>
		<label>Asthma Diary</label>
<select name="actionDiary" id="actionDiary">
		<option value="">Select</option>
		<option value="Given">Given</option>
		<option value="not Given">Not Given</option>
		</select>
		
	<div class="clear"></div>
<%if(reVisitList.size()>0){ %>
<h4>Pediatric Asthma Clinic Follow Up</h4>

 <div class="clear"></div>
 <label>Severity at Diagnosis</label>
<input type="text"  id="severityAtDiagnosis" name="severityAtDiagnosis" tabindex="1" value="" maxlength="250" />  
<label>Interval Since Last Visit</label>
<input type="text"  id="intervalSinceLastVisit" name="intervalSinceLastVisit" tabindex="1" value=""   maxlength="250"/>  
 <div class="clear"></div>
 <label>Symptoms</label>
<input type="text"  id="symptoms" name="symptoms" tabindex="1" value=""   maxlength="250"/> 
<label>Current Symptoms</label>
<input type="text"  id="currentSymptoms" name="currentSymptoms" tabindex="1" value=""   maxlength="250"/>  
	 <div class="clear"></div>
	 <label>No. of exacerbations since last visit</label>
<input type="text"  id="noOfExacerbation" name="noOfExacerbation" tabindex="1" value=""   maxlength="250"/> 
<label>Hospital Admissions</label>
<input type="text"  id="hospitalAdmissions" name="hospitalAdmissions" tabindex="1" value=""   onkeypress="javascript:return isNumber(event)" maxlength="3" validate="Hospital Admissions,int,no"/>  
 		 <div class="clear"></div>
 <label>Oral Steroid Use</label>
<input type="text"  id="oralSteroidUse" name="oralSteroidUse" tabindex="1" value=""   maxlength="250"/>  	
 <label class="heightAuto">Participation in Physical Activities</label>
<input type="text"  id="physicalActivities" name="physicalActivities" tabindex="1" value=""   maxlength="250"/> 
 <div class="clear"></div>
<h4>Review Control</h4>	
<div class="clear"></div>
<div class="clear"></div>
<table border="0" cellpadding="5" cellspacing="0" style="width:718px; margin-left: 5px; float:left;" class="tablestyle" id="symptomsGrid"> 
    <tr>
     <th align="center"></th>
      <th align="center">Controlled(All Features)</th>
      <th align="center">Partly Controlled(Any in any wk)</th>
      <th align="center">UnControlled(>= 3 in any wk)</th>
    </tr>
  <%int i= 1; %>
   <tr>
   <td>Day Symptoms<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=i %>" id="reviewControlFlag" value="Day Symptoms"/></td>
   <td><input  type="checkbox" class="radioCheck" name="controlled<%=i %>" id="controlled" value="<= 2 days/week"/><= 2 days/week</td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=i %>" id="partlyControlled" value="> 2 days/week" />> 2 days/week</td>
   <td><input  type="checkbox" class="radioCheck" name="unControlled<%=i %>" id="unControlled" value="<= 2 days/week" /><= 2 days/week</td>
   </tr>
   <%i++; %>
    <tr>
   <td>Night Awakening<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=i %>" id="reviewControlFlag" value="Night Awakening"/></td>
   <td><input  type="checkbox" class="radioCheck" name="controlled<%=i %>" id="symptomsControlled" value="None" />None</td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=i %>" id="partlyControlled" value="Any" />Any</td>
   <td><input  type="checkbox" class="radioCheck" name="unControlled<%=i %>" id="unControlled" value="<= 2 days/week" /><= 2 days/week</td>
   </tr>
   <%i++; %>
   
    <tr>
   <td>Activity Limitation<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=i %>" id="reviewControlFlag" value="Activity Limitation"/></td>
   <td><input  type="checkbox" class="radioCheck" name="controlled<%=i %>" id="controlled" value="None"  />None</td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=i %>" id="partlyControlled" value="Any" />Any</td>
   <td><input  type="checkbox" class="radioCheck" name="unControlled<%=i %>" id="unControlled" value="<= 2 days/week" /><= 2 days/week</td>
   </tr>
   <%i++; %>
    <tr>
   <td>Need for SABA<input  type="hidden" class="radioCheck" name="reviewControlFlag<%=i %>" id="reviewControlFlag" value="Need for SABA"/></td>
   <td><input  type="checkbox" class="radioCheck" name="controlled<%=i %>" id="controlled" value="<= 2 days/week" /><= 2 days/week</td>
   <td><input  type="checkbox" class="radioCheck" name="partlyControlled<%=i %>" id="partlyControlled" value="> 2 days/week" />> 2 days/week</td>
   <td><input  type="checkbox" class="radioCheck" name="unControlled<%=i %>" id="unControlled" value=">2 days/week" />>2 days/week</td>
   </tr>
   <%i++; %>
   </table>
   <input type="hidden" name="reviewControl" id="reviewControl" value="<%=i %>" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<label>Check Inhaler Technique</label>
<input type="text"  id="inhalerTechnique" name="inhalerTechnique" tabindex="1" value=""  maxlength="250"/> 

 <label class="heightAuto">Adherence to treatment Plan</label>
<input type="text"  id="adherenceToTreatmentPlan" name="adherenceToTreatmentPlan" tabindex="1" value=""   maxlength="250"/> 
   <div class="clear"></div>
<label>Asthma Diary</label>
<input type="text"  id="asthmaDiaryFollowUp" name="asthmaDiaryFollowUp" tabindex="1" value=""  maxlength="250" /> 

<div class="clear"></div>
<h4>Physical Examination</h4>	
<div class="clear"></div>

<label>Height</label>
<input type="text"  id="heightFollowUp" name="heightFollowUp" tabindex="1" value="<%=height != 0?height:"" %>"   validate="Height,num,no" maxlength="3" /> 
<label	class="smallAuto">Cm</label>
 <label>Weight</label>
<input type="text"  id="weightFollowUp" name="weightFollowUp" tabindex="1" value="<%=weight != 0?weight:"" %>"   validate="Weight,float,no" maxlength="5" /> 
<label	class="smallAuto">kg</label>
<div class="clear"></div>
<label>Heart Rate</label>
<input type="text"  id="heartRate" name="heartRate" tabindex="1" value=""  validate="Heart Rate,num,no" maxlength="3"/> 
<label	class="smallAuto">min</label>
<label>Respiratory Rate</label>
<input type="text"  id="respiratoryRateFollowUp" name="respiratoryRateFollowUp" tabindex="1" value="<%=respiratoryRate != 0?respiratoryRate:"" %>"  validate="Respiratory Rate,num,no" maxlength="3"/> 
<label	class="smallAuto">min</label>

<div class="clear"></div>
<label>BP</label>
<%
String[] parts={"",""};

if(bp != null){
	if(!bp.equals("") && bp.indexOf("/")!=-1){
		parts = bp.split("/");
	}
}
%>
 <input name="systolicFollowUp" id="systolicFollowUp" tabindex="14" placeholder="Systolic" value="<%=parts.length>0 && parts[0] != null?parts[0]:""%>" validate="BP-Systolic,int,no" type="text" maxlength="3" class="textYellow allownumericwithoutdecimal textSmall" />
  <label id="bpLabel" class="auto"><span style="color: black">/</span></label>
<input name="diastolicFollowUp" id="diastolicFollowUp" tabindex="15" placeholder="Diastolic" value="<%=parts.length>0 && parts[1] != null ?parts[1]:""%>" validate="BP-Diastolic,int,no" type="text" maxlength="3" class="textYellow allownumericwithoutdecimal textSmall" /></span>

 <label class="smallAuto autoSpace">mm&nbsp;Hg</label>
 <label style="margin-left:36px;">Sinuses</label>
<input type="text"  id="cineses" name="cineses" tabindex="1" value=""   maxlength="250"/> 
<%} }%>

</form>

