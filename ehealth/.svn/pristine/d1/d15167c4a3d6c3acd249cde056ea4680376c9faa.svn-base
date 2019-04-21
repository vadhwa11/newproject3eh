<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryDetail"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="bloodDonationEntry" method="post" action=""><script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script> <%
String errorMsg = "";
errorMsg = "BloodBagNo. ";
int donationhdId = 0;
	int pageNo=1;
	int hinId=0;
	int bloodDonationId=0;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	
 	List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
 	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
 	List<Patient> patientList = new ArrayList<Patient>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
 	List<MasState> stateList = new ArrayList<MasState>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("occupationList") != null){
	occupationList= (ArrayList) map.get("occupationList");
	}
	if(map.get("patientList") != null){
		patientList= (ArrayList) map.get("patientList");
	}
	if(map.get("donationhdId") != null){
		donationhdId=(Integer)map.get("donationhdId");
	}
	if(map.get("bloodDonationId") != null){
		bloodDonationId=(Integer)map.get("bloodDonationId");
	}
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (ArrayList)map.get("bloodGroupList");
	}
	if(map.get("employeeList") != null){
	    employeeList =(ArrayList) map.get("employeeList");
	}
	if(map.get("sexList") != null){
		sexList= (ArrayList) map.get("sexList");
	}
	if(map.get("stateList") != null){
		stateList= (ArrayList) map.get("stateList");
	}

	if(map.get("donorList") != null){
		donorList =(List)map.get("donorList");
	}
	BloodDonationEntryHeader donationEntryHeader = new BloodDonationEntryHeader();
	if(donorList != null && donorList.size()>0){
		donationEntryHeader = donorList.get(0);	
	}
	
	if(donationEntryHeader.getHin()!=null){
		hinId = donationEntryHeader.getHin().getId();			
	}
	String userName="";
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (session.getAttribute("userName") != null) {
		  userName = (String) session.getAttribute("userName");
		}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
		
%>
<div class="titleBg">
<h2>Update Blood Donor Questionnaire And Consent Form</h2>
</div>
<div class="clear"></div>

<!--Block One Starts-->
<div class="Block">
<%
		String donationSeqNo="";
		if(map.get("donationSeqNo") != null){
			donationSeqNo = (String)map.get("donationSeqNo");
		}
%> <%if(donationEntryHeader.getHin() != null){ %> <input type="hidden"
	name="hinId" value="<%=donationEntryHeader.getHin().getId()%>" /> <%}else{ %>
<input type="hidden" name="hinId" value="" /> <%} %> <label>Blood
Donation No. </label> <input id="donationNoId" type=hidden
	name="<%=DONATION_NO %>"
	value="<%=donationEntryHeader.getDonationNo() %>"
	title="Blood Donation No." /> <label class="value"><%=donationEntryHeader.getDonationNo() %>
</label> <input type="hidden" id="donationhdId" name="donationhdId"
	value="<%= donationEntryHeader.getId()%>" /> <label>HIN </label> <%if(donationEntryHeader.getHin() != null){ %>
<input id="hinNo" name="<%=HIN_NO %>"
	value="<%=donationEntryHeader.getHin().getHinNo() %>" type="text"
	readonly="readonly" /> <%}else{ %> <input id="hinNo" name="<%=HIN_NO %>"
	value="" type="text" /> <%} %> <label> <span>*</span> Donor Name</label>
<input type="text" name="<%= DONER_NAME%>"
	value="<%=donationEntryHeader.getDonerName() %>"
	validate="Donor Name,string,yes" MAXLENGTH="20" tabindex=1
	readonly="readonly" />

<div class="clear"></div>

<label>Father's Name</label> <%if(donationEntryHeader.getFatherName() != null){ %>
<input type="text" name="<%= FATHER_NAME%>"
	value="<%=donationEntryHeader.getFatherName() %>"
	validate="Father's Name,string,no" MAXLENGTH="20" tabindex=1 /> <%}else{ %>
<input type="text" name="<%= FATHER_NAME%>" value=""
	validate="Father's Name,string,no" MAXLENGTH="20" tabindex=1 /> <%} %> <label>Husband's
Name</label> <%if(donationEntryHeader.getHusbandName() != null){ %> <input
	type="text" name="<%= HUSBAND_NAME%>"
	value="<%=donationEntryHeader.getHusbandName() %>"
	validate="Husband's Name,string,no" MAXLENGTH="20" tabindex=1 /> <%}else{ %>
<input type="text" name="<%= HUSBAND_NAME%>" value=""
	validate="Husband's Name,string,no" MAXLENGTH="20" tabindex=1 /> <%}%> <label>Occupation</label>
<%if(donationEntryHeader.getOccupation()!=null){%> <input type="text"
	value="<%=donationEntryHeader.getOccupation().getOccupationName()%>"
	name="<%=OCCUPATION_CODE%>" id="occupNameId" disabled="disabled" /> <input
	type="hidden" value="<%=donationEntryHeader.getOccupation().getId()%>"
	name="<%=OCCUPATION_ID%>" id="occupId" /> <% } else if(occupationList != null){ 	%>
<select id="occupId" name=<%=OCCUPATION_ID %>
	validate="Occupation,string,no">
	<option value="0">Select</option>
	<%
				         			for (Iterator iter = occupationList.iterator(); iter.hasNext();) {
				         				MasOccupation masOccupation = (MasOccupation) iter.next();
				         %>
	<%if(donationEntryHeader.getOccupation()!=null){
	 					if(donationEntryHeader.getOccupation().getId().equals(masOccupation.getId())){ %>
	<option value="<%=donationEntryHeader.getOccupation().getId()%>"
		selected="selected"><%=donationEntryHeader.getOccupation().getOccupationName()%></option>
	<%} } }}%>
</select>

<div class="clear"></div>

<label>Organization</label> <%if(donationEntryHeader.getOrganization() != ""){ %>
<textarea name="<%=ORGANIZATION%>" id="organization"
	onkeyup="return ismaxlength(this)" maxlength="30"
	validate="Organization,string,no"
	value="<%=donationEntryHeader.getOrganization() %>"></textarea> <%}else{ %>
<textarea value="" name="<%=ORGANIZATION%>" id="organization"
	onkeyup="return ismaxlength(this)" maxlength="30"
	validate="Organization,string,no"></textarea> <%} %> <label>Sex</label> <%if(donationEntryHeader.getHin()!=null){ 
if(donationEntryHeader.getHin().getSex()!=null){%> <input
	value="<%=donationEntryHeader.getHin().getSex().getAdministrativeSexName()%>"
	name="<%=SEX%>" id="sexNameId" disabled="disabled" /> <input
	type="hidden"
	value="<%=donationEntryHeader.getHin().getSex().getId()%>"
	name="<%=SEX_ID%>" id="sexId" /> <% } 	}else	if(sexList != null){ 	%> <select
	id="sexId" name=<%=SEX_ID %> validate="Sex,string,yes">
	<option value="0">Select</option>
	<%
				         			for (Iterator iter = sexList.iterator(); iter.hasNext();) {
				         				MasAdministrativeSex administrativeSex = (MasAdministrativeSex) iter.next();
				         %>
	<%if(donationEntryHeader.getSex().getId().equals(administrativeSex.getId())){ %>
	<option value="<%=donationEntryHeader.getSex().getId()%>"
		selected="selected"><%=donationEntryHeader.getSex().getAdministrativeSexName()%></option>
	<%}else{ %>
	<option value="<%=administrativeSex.getId() %>"><%=administrativeSex.getAdministrativeSexName()%></option>
	<%		}} } %>
</select> <label> <span>*</span> Age</label> <%if(donationEntryHeader.getAge() != null){ %>
<input id="age" name="<%=AGE %>" type="text"
	value="<%=donationEntryHeader.getAge() %>" readonly="readonly"
	validate="Age,int,yes" maxlength="3" /> <%}else{ %> <input id="age"
	name="<%=AGE %>" type="text" class="small" validate="Age,int,yes"
	maxlength="3" /> <%} %>

<div class="clear"></div>

<label> <span>*</span> Tel No.</label> <%if(donationEntryHeader.getTelNo() != null){ %>
<input name="<%=TELE_NO %>" type="text"
	value="<%=donationEntryHeader.getTelNo() %>"
	validate="Tel No.,phone,yes" maxlength="15" value=""
	readonly="readonly" /> <%}else {%> <input name="<%=TELE_NO %>"
	type="text" validate="Tel No.,phone,yes" maxlength="15" value="" /> <%} %>

<label>Mobile No.</label> <%if(donationEntryHeader.getMobNo() != null){ %>
<input name="<%=MOBILE_NO %>" type="text"
	value="<%=donationEntryHeader.getMobNo() %>"
	validate="Mob No.,phone,yes" maxlength="15" value="" /> <%}else {%> <input
	name="<%=MOBILE_NO %>" type="text" validate="Mobile No.,phone,no"
	maxlength="15" value="" /> <%} %> <label> <span>*</span> Home
State</label> <select id="stateId" name=<%=STATE_ID %>
	validate="Home State,string,no">

	<option value="0">Select</option>
	<%
				         		if(stateList != null){ 	
				         			for (Iterator iter = stateList.iterator(); iter.hasNext();) {
				         				MasState masStates = (MasState) iter.next();
				         %>
	<%if(donationEntryHeader.getState()!=null){
	 if(donationEntryHeader.getState().getId() .equals(masStates.getId())){ %>
	<option value="<%=donationEntryHeader.getState().getId()%>"
		selected="selected"><%=donationEntryHeader.getState().getStateName()%></option>
	<%}else{ %>
	<option value="<%=masStates.getId() %>"><%=masStates.getStateName()%></option>
	<%		}} }} %>
</select>

<div class="clear"></div>

<label> <span>*</span> Blood Group</label> <select id="bloodGroupId"
	name=<%=BLOOD_GROUP_ID %> validate="Blood Group,string,yes">
	<option value="0">Select</option>
	<%
				         		if(bloodGroupList != null){ 	
				         			for (Iterator iter = bloodGroupList.iterator(); iter.hasNext();) {
				         				MasBloodGroup bloodGroup = (MasBloodGroup) iter.next();
				         %>
	<%if(donationEntryHeader.getBloodGroup()!=null){
	 if(donationEntryHeader.getBloodGroup().getId() .equals(bloodGroup.getId())){ %>
	<option value="<%=donationEntryHeader.getBloodGroup().getId()%>"
		selected="selected"><%=donationEntryHeader.getBloodGroup().getBloodGroupName()%></option>
	<%}else{ %>
	<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName()%></option>
	<%		}} }} %>
</select> <label>Previously Donated</label> <select
	name="<%=PREVIOUSLY_DONATED%>" class="smallest">
	<%if(donationEntryHeader.getPreviouslyDonated().equalsIgnoreCase("n")){%>
	<option value="" selected="selected">No</option>
	<option value="y">yes</option>
	<%}else{ %>
	<option value="" selected="selected">yes</option>
	<option value="n">No</option>
	<%} %>
</select> <label class="smallAuto">If yes, No. of times</label> <%if(donationEntryHeader.getNoTimes() != null){ %>
<input name="" class="smallest"
	value="<%=donationEntryHeader.getNoTimes() %>" maxlength="2"> <%}else{ %>
<input name="" type="text" class="smallest"
	validate="No. of times,int,no" maxlength="2" /> <%} %> <label>When
Last Donated</label> <%if(donationEntryHeader.getLastDonated() != null){%> <input
	name="<%=LAST_DONATED_DATE %>" class="date"
	value="<%=HMSUtil.convertDateToStringWithoutTime(donationEntryHeader.getLastDonated()) %>">
<%}else{ %> <input type="text" class="date" id="lastDateId"
	name="<%=LAST_DONATED_DATE %>" value=""
	validate="Last Donated Date,date,no" MAXLENGTH="10" /> <%} %> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=LAST_DONATED_DATE%>,event)" />

<div class="clear"></div>

<label>Time of Last Meal</label> <%if(donationEntryHeader.getTimeLastMeal() != null){ %>
<input name="<%=LAST_MEAL_TIME %>"
	value="<%=donationEntryHeader.getTimeLastMeal()%> type="
	text" onKeyUp="mask(this.value,this,'2',':');"
	onblur="IsValidTime(this.value,'lastMealTime')" maxlength="5" /> <%}else{ %>
<input id="lastMealTime" name="<%=LAST_MEAL_TIME %>" type="text"
	onKeyUp="mask(this.value,this,'2',':');"
	onblur="IsValidTime(this.value,'lastMealTime')" maxlength="5" /> <%} %>
<label class="auto">Any discomfort during/ after donation</label> <select
	name="<%=DISCOMFORT %>" class="smallest">
	<%if(donationEntryHeader.getDiscomfort().equalsIgnoreCase("n")){%>
	<option value="<%=donationEntryHeader.getDiscomfort()%>"
		selected="selected">No</option>
	<option value="y">yes</option>
	<%}else{ %>
	<option value="<%=donationEntryHeader.getDiscomfort()%>"
		selected="selected">yes</option>
	<option value="n">No</option>
	<%} %>
</select>
<div class="clear"></div></div>
<!--Block one Ends--> <!--Block Two Starts-->
<div class="clear"></div>
<h4>Questionnaire 1</h4>
<div class="clear"></div>
<!--Block Two Starts-->
<div class="Block">

<div class="clear"></div>
<label>Do you Feel Well Today ?</label> <select name="<%=WELL_TODAY %>"
	class="smallest">
	<%if(donationEntryHeader.getWellToday().equalsIgnoreCase("n")){%>
	<option value="n" selected="selected">No</option>
	<option value="y">yes</option>
	<%}else{ %>
	<option value="y" selected="selected">yes</option>
	<option value="n">No</option>
	<%} %>
</select> <label class="large">Did you have something to eat in the last
4 hours ?</label> <select name="<%=SOMTHING_EAT %>" class="smallest">
	<%if(donationEntryHeader.getSmthingEat().equalsIgnoreCase("n")){%>
	<option value="n" selected="selected">No</option>
	<option value="y">yes</option>
	<%}else{ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%} %>
</select> <label class="auto">Did you sleep well last night ?</label> <select
	name="<%=SLEEP_LAST%>" class="smallest">
	<%if(donationEntryHeader.getSleepLastNight().equalsIgnoreCase("n")){%>
	<option value="n" selected="selected">No</option>
	<option value="n">yes</option>
	<%}else{ %>
	<option value="y" selected="selected">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>

<div class="clear"></div>
<label class="auto">Have you any reason to believe that you may
be infected by either Hepatitis, (HBsAg &amp; HCV), Malaria, HIV/ AIDS
and/ or venereal<br />
disease ?</label> <select name="<%=INFECTED_DISEASE%>" class="smallest">
	<%if(donationEntryHeader.getHepatitis().equalsIgnoreCase("n")){%>
	<option value="<%=donationEntryHeader.getHepatitis()%>"
		selected="selected">No</option>
	<option value="y">Yes</option>
	<%}else{ %>
	<option value="<%=donationEntryHeader.getHepatitis()%>"
		selected="selected">Yes</option>
	<option value="n">No</option>
	<%} %>
</select>
<div class="clear"></div>

</div>

<!--Block Two Ends--> <!--Block Three Starts-->
<h4>Questionnaire 2</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label class="auto"><u>In the last 6 months have you had any
history of the following :</u></label>
<div class="clear"></div>

<label>Unexpected Weight Loss</label> <%if(donationEntryHeader.getWeightLoss().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=WEIGHT_LOSS %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=WEIGHT_LOSS %>" value="" /> <%} %> <label>Repeated
Diarrhoeas</label> <%if(donationEntryHeader.getDiasrrhoes().equals("y") ){ %> <input
	type="checkbox" class="radioCheck" name="<%=DIARROCES %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=DIARROCES %>" value="" /> <%} %> <label>Swollen
Glands</label> <%if(donationEntryHeader.getSwollwn().equals("y") ){ %> <input
	type="checkbox" class="radioCheck" name="<%=SWOLLEN %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=SWOLLEN %>" value="" /> <%} %> <label>Continuous
Low Grade Fever</label> <%if(donationEntryHeader.getLowGradeFever().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=LOW_GRADE_FEVER %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=LOW_GRADE_FEVER %>" value="" /> <%} %> <label>N/A</label>
<%if(donationEntryHeader.getNA1().equals("y") ){ %> <input type="checkbox"
	class="radioCheck" name="<%=N_A1 %>" value="" checked="checked" /> <%}else{ %>
<input type="checkbox" class="radioCheck" name="<%=N_A1 %>" value="" />
<%} %>

<div class="clear"></div>

<label class="auto"><u>In the last 6 months have you had any
:</u></label>
<div class="clear"></div>
<label>Tattooing</label> <%if(donationEntryHeader.getTattoing().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=TATTOOING %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=TATTOOING %>" value="" /> <%} %> <label>Ear
Piercing</label> <%if(donationEntryHeader.getEarPiercing().equals("y") ){ %> <input
	type="checkbox" class="radioCheck" name="<%=EAR_PIERCING %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=EAR_PIERCING %>" value="" /> <%} %> <label>Dental
Extraction</label> <%if(donationEntryHeader.getDentalExtraction().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=DENTAL_EXTRACTION %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=DENTAL_EXTRACTION %>" value="" /> <%} %> <label>N/A</label>
<%if(donationEntryHeader.getNA2().equals("y") ){ %> <input type="checkbox"
	class="radioCheck" name="<%=N_A2 %>" value="" checked="checked" /> <%}else{ %>
<input type="checkbox" class="radioCheck" name="<%=N_A2%>" value="" />
<%} %>

<div class="clear"></div>
<label class="auto"><u>Do you suffer from or have suffered
from any of the following ?</u></label>
<div class="clear"></div>
<label>Heart Disease</label> <%if(donationEntryHeader.getHeartDisease().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=HEART_DISEASE %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=HEART_DISEASE %>" value="" /> <%} %> <label>Lung
Disease</label> <%if(donationEntryHeader.getLungDisease().equals("y") ){ %> <input
	type="checkbox" class="radioCheck" name="<%=LUNG_DISEASE %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=LUNG_DISEASE %>" value="" /> <%} %> <label>Kidney
Disease</label> <%if(donationEntryHeader.getKidneyDisease().equals("y") ){ %> <input
	type="checkbox" class="radioCheck" name="<%=KIDNEY_DISEASE %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=KIDNEY_DISEASE %>" value="" /> <%} %> <label>Cancer/
Malignant Disease</label> <%if(donationEntryHeader.getCancerDisease().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=CANCER_DISEASE %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=CANCER_DISEASE %>" value="" /> <%} %> <label>Epilepsy</label>
<%if(donationEntryHeader.getEpilepsy().equals("y") ){ %> <input
	type="checkbox" class="radioCheck" name="<%=EPILEPSY %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=EPILEPSY %>" value="" /> <%} %>

<div class="clear"></div>

<label>CDiabetes</label> <%if(donationEntryHeader.getCdiabetes().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=CDIABETES %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=CDIABETES %>" value="" /> <%} %> <label>Tuberculosis</label>
<%if(donationEntryHeader.getTuberculosis().equals("y") ){ %> <input
	type="checkbox" class="radioCheck" name="<%=TUBERCULOSIS %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=TUBERCULOSIS %>" value="" /> <%} %> <label>Abnormal
Bleeding</label> <%if(donationEntryHeader.getAbnormalBleeding().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=ABNORMAL_BLEEDING %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=ABNORMAL_BLEEDING %>" value="" /> <%} %> <label>Hepatitis
B/C</label> <%if(donationEntryHeader.getHepatitis().equals("y") ){ %> <input
	type="checkbox" class="radioCheck" name="<%=HEPATITIS_BC %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=HEPATITIS_BC %>" value="" /> <%} %> <label>Allergic
Disease</label> <%if(donationEntryHeader.getAllergicDisease().equals("y") ){ %> <input
	type="checkbox" class="radioCheck" name="<%=ALLERGIC_DISEASE %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=ALLERGIC_DISEASE %>" value="" /> <%} %>

<div class="clear"></div>

<label>Dental Extraction</label> <%if(donationEntryHeader.getDentalExtraction1().equals("y") ){ %>
<input type="checkbox" class="radioCheck"
	name="<%=DENTAL_EXTRACTION1 %>" value="" checked="checked" /> <%}else{ %>
<input type="checkbox" class="radioCheck"
	name="<%=DENTAL_EXTRACTION1 %>" value="" /> <%} %> <label>Sexually
Transmitted Disease</label> <%if(donationEntryHeader.getSexuallyDisease().equals("y") ){ %>
<input type="checkbox" class="radioCheck"
	name="<%=SEXUALLY_TRANSMITTED_DISEASE %>" value="" checked="checked" />
<%}else{ %> <input type="checkbox" class="radioCheck"
	name="<%=SEXUALLY_TRANSMITTED_DISEASE %>" value="" /> <%} %> <label>Jaundice
(Last 1 Yr)</label> <%if(donationEntryHeader.getJaundiceLastYear().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=JAUNDICE_LAST %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=JAUNDICE_LAST %>" value="" /> <%} %> <label>Typhoid
(Last 1 Yr)</label> <%if(donationEntryHeader.getTyphoidLastOne().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=TYPHOID_LAST %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=TYPHOID_LAST %>" value="" /> <%} %> <label>Malaria
(6 Months)</label> <%if(donationEntryHeader.getMalariaSixMonth().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=MALARIA_LAST %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=MALARIA_LAST %>" value="" /> <%} %>
<div class="clear"></div>

<label>Fainting Spells</label> <%if(donationEntryHeader.getFaintingSpells().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=FAINTING_SPELL %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=FAINTING_SPELL %>" value="" /> <%} %> <label>Leprosy</label>
<%if(donationEntryHeader.getLeprosy().equals("y") ){ %> <input
	type="checkbox" class="radioCheck" name="<%=LEPROSY %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=LEPROSY %>" value="" /> <%} %> <label>Schizophernia</label>
<%if(donationEntryHeader.getSchizophernia().equals("y") ){ %> <input
	type="checkbox" class="radioCheck" name="<%=SCHIZOPHERNIA %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=SCHIZOPHERNIA %>" value="" /> <%} %> <label>Endocrine
Disorders</label> <%if(donationEntryHeader.getEndocrineDisorders().equals("y") ){ %>
<input type="checkbox" class="radioCheck"
	name="<%=ENDOCRING_DISORDERS %>" value="" checked="checked" /> <%}else{ %>
<input type="checkbox" class="radioCheck"
	name="<%=ENDOCRING_DISORDERS %>" value="" /> <%} %> <label>N/A</label> <%if(donationEntryHeader.getNA3().equals("y") ){ %>
<input type="checkbox" class="radioCheck" name="<%=N_A3 %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheck" name="<%=N_A3 %>" value="" /> <%} %>
<div class="clear"></div>
</div>

<!--Block Four Ends-->

<div class="clear"></div>
<h4>Questionnaire 3</h4>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>
<label class="auto"><u>Condition for deferment of blood
donation :</u></label>
<div class="clear"></div>
<label class="col1">Condition</label> <label class="col2">Period
of Deferment</label> <label class="col1">Condition</label> <label class="col2">Period
of Deferment</label>

<div class="clear"></div>

<div class="clear"></div>
<%if(donationEntryHeader.getAbortion().equals("y") ){ %> <input
	type="checkbox" class="radioCheckCol1" name="<%=ABORTION %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=ABORTION %>" value="" /> <%} %> <label
	class="col1Value">Abortions</label> <label class="col2Value">:06
months</label> <%if(donationEntryHeader.getAcuteNephritis().equals("y") ){ %> <input
	type="checkbox" class="radioCheckCol1" name="<%=ACUTE_NERPHRITIS %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=ACUTE_NERPHRITIS %>" value="" /> <%} %>
<label class="col1Value">Acute nephritis</label> <label
	class="col2Value">:06 months after recovery</label>

<div class="clear"></div>
<%if(donationEntryHeader.getHoBloodTransfusion().equals("y") ){ %> <input
	type="checkbox" class="radioCheckCol1"
	name="<%=BLOOD_TRANSFUSION_HO %>" value="" checked="checked" /> <%}else{ %>
<input type="checkbox" class="radioCheckCol1"
	name="<%=BLOOD_TRANSFUSION_HO %>" value="" /> <%} %> <label
	class="col1Value">H/O Blood Transfusion</label> <label
	class="col2Value">:06 months</label> <%if(donationEntryHeader.getImmunoglobulinNephritis().equals("y") ){ %>
<input type="checkbox" class="radioCheckCol1"
	name="<%=IMMUNOGLOBULIN_NEPHRITIS%>" value="" checked="checked" /> <%}else{ %>
<input type="checkbox" class="radioCheckCol1"
	name="<%=IMMUNOGLOBULIN_NEPHRITIS %>" value="" /> <%} %> <label
	class="col1Value">Immunozalic (cholera, Typhoid, Aiptheria,
Teteinus, Plague, Gammaglobulin)</label> <label class="col2Value">:15
days</label>

<div class="clear"></div>
<%if(donationEntryHeader.getAlcholism().equals("y") ){ %> <input
	type="checkbox" class="radioCheckCol1" name="<%=ALCHOLISM %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=ALCHOLISM %>" value="" /> <%} %> <label
	class="col1Value">Alcholism</label> <label class="col2Value">:Till
intoxicated</label> <%if(donationEntryHeader.getRabieVaccination().equals("y") ){ %>
<input type="checkbox" class="radioCheckCol1"
	name="<%=RABIES_VACCINATION %>" value="" checked="checked" /> <%}else{ %>
<input type="checkbox" class="radioCheckCol1"
	name="<%=RABIES_VACCINATION %>" value="" /> <%} %> <label
	class="col1Value">Rabies vaccination after bite or rabid animal
</label> <label class="col2Value">:1yr after bite</label>
<div class="clear"></div>
<%if(donationEntryHeader.getMinorSurgery().equals("y") ){ %> <input
	type="checkbox" class="radioCheckCol1" name="<%=MINOR_SURGERY %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=MINOR_SURGERY %>" value="" /> <%} %> <label
	class="col1Value">Minor Surgery</label> <label class="col2Value">:03
Months</label> <%if(donationEntryHeader.getHoHapatitis().equals("y") ){ %> <input
	type="checkbox" class="radioCheckCol1" name="<%=HO_HEPATITIS %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=HO_HEPATITIS %>" value="" /> <%} %> <label
	class="col1Value">H/O Hepatitis in family or close contact</label> <label
	class="col2Value">:12 months </label>

<div class="clear"></div>
<%if(donationEntryHeader.getMajorSurgery().equals("y") ){ %> <input
	type="checkbox" class="radioCheckCol1" name="<%=MAJOR_SURGERY %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=MAJOR_SURGERY %>" value="" /> <%} %> <label
	class="col1Value">Major Surgery</label> <label class="col2Value">:05
Months</label> <%if(donationEntryHeader.getIImmunozalic().equals("y") ){ %> <input
	type="checkbox" class="radioCheckCol1" name="<%=IMMUNOZALIC %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=IMMUNOZALIC %>" value="" /> <%} %> <label
	class="col1Value">Immunoglobulin nephritis</label> <label
	class="col2Value">:12 months</label>

<div class="clear"></div>
<%if(donationEntryHeader.getTyphoid().equals("y") ){ %> <input
	type="checkbox" class="radioCheckCol1" name="<%=TYPHOID %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=TYPHOID %>" value="" /> <%} %> <label
	class="col1Value">Typhoid</label> <label class="col2Value">:12
months after recovery</label> <%if(donationEntryHeader.getHoMalaria().equals("y") ){ %>
<input type="checkbox" class="radioCheckCol1" name="<%=HO_MALARIA %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=HO_MALARIA %>" value="" /> <%} %> <label
	class="col1Value">H/O malaria &amp; duly treated </label> <label
	class="col2Value">:03 months (endemic) & 03yrs (non endemic
area)</label>
<div class="clear"></div>
<%if(donationEntryHeader.getTattoing1().equals("y") ){ %> <input
	type="checkbox" class="radioCheckCol1" name="<%=TATTOOING1 %>" value=""
	checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=TATTOOING1 %>" value="" /> <%} %> <label
	class="col1Value">Tattooing</label> <label class="col2Value">:06
months</label> <%if(donationEntryHeader.getBreastFeeding().equals("y") ){ %> <input
	type="checkbox" class="radioCheckCol1" name="<%=BREAST_FEEDING %>"
	value="" checked="checked" /> <%}else{ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=BREAST_FEEDING %>" value="" /> <%} %> <label
	class="col1Value">Breast feeding</label> <label class="col2Value">:12
months after delivery</label>

<div class="clear"></div>
<%if(donationEntryHeader.getNA4().equals("y") ){ %> <input type="checkbox"
	class="radioCheckCol1" name="<%=N_A4 %>" value="" checked="checked" />
<%}else{ %> <input type="checkbox" class="radioCheckCol1"
	name="<%=N_A4 %>" value="" /> <%} %> <label class="col1Value">N/A</label>

<div class="clear"></div>
</div>
<div class="clear"></div>



<!--Block Four Ends-->
<div class="clear"></div>
<h4>Questionnaire 4</h4>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>
<label class="auto"><u>Is there any history of surgery or
blood transfusion in the past 6 months ?</u></label>
<div class="clear"></div>


<%if(donationEntryHeader.getMajorSurgery().equals("y") ){ %> <input
	type="radio" class="radioCheck" name="<%=SELECTED_RADIO %>" value=""
	checked="checked" /> <%}else{ %> <input type="radio" class="radioCheck"
	name="<%=SELECTED_RADIO %>" value="" /> <%} %> <label class="value">Major</label>

<%if(donationEntryHeader.getMinorSurgery().equals("y") ){ %> <input
	type="radio" class="radioCheck" name="<%=SELECTED_RADIO %>" value=""
	checked="checked" /> <%}else{ %> <input type="radio" class="radioCheck"
	name="<%=SELECTED_RADIO%>" value="" /> <%} %> <label class="value">Minor</label>


<%if(donationEntryHeader.getBloodTransfusionSix().equals("y") ){ %> <input
	type="radio" class="radioCheck" name="<%=SELECTED_RADIO %>" value=""
	checked="checked" /> <%}else{ %> <input type="radio" class="radioCheck"
	name="<%=SELECTED_RADIO %>" value="" /> <%} %> <label class="value">Blood
Transfusion</label> <%if(donationEntryHeader.getNA5().equalsIgnoreCase("y") ){ %>
<input type="radio" class="radioCheck" name="<%=SELECTED_RADIO %>"
	value="" checked="checked" /> <%}else{ %> <input type="radio"
	class="radioCheck" name="<%=SELECTED_RADIO%>" value="" /> <%} %> <label
	class="value">N/A</label>

<div class="clear"></div>

<label class="auto">For women donors :</label>
<div class="clear"></div>


<label class="large">Are you pregnant ?</label> <label class="small">Yes</label>
<%if(donationEntryHeader.getPregnent().equalsIgnoreCase("y")){ %> <input
	type="radio" class="radioCheck" name="<%=PREGNENT %>"
	value="<%=donationEntryHeader.getPregnent() %>" checked="checked" /> <%}else{ %>
<input type="radio" class="radioCheck" name="<%=PREGNENT %>" value="" />
<%} %> <label class="small">No</label> <%if(donationEntryHeader.getPregnent().equalsIgnoreCase("n")){ %>
<input type="radio" class="radioCheck" name="<%=PREGNENT %>"
	value="<%=donationEntryHeader.getPregnent() %>" checked="checked" /> <%}else{ %>
<input type="radio" class="radioCheck" name="<%=PREGNENT %>" value="" />
<%} %>
<div class="clear"></div>

<label class="large">Have you had an abortion in the last 3
months ?</label> <label class="small">Yes</label> <%if(donationEntryHeader.getAbortionLastThree().equalsIgnoreCase("y")){ %>
<input type="radio" class="radioCheck" name="<%=ABORTION1 %>"
	value="<%=donationEntryHeader.getAbortionLastThree() %>"
	checked="checked" /> <%}else{ %> <input type="radio" class="radioCheck"
	name="<%=ABORTION1 %>" value="" /> <%} %> <label class="small">No</label>
<%if(donationEntryHeader.getAbortionLastThree().equalsIgnoreCase("n")){ %>
<input type="radio" class="radioCheck" name="<%=ABORTION1 %>"
	value="<%=donationEntryHeader.getAbortionLastThree() %>"
	checked="checked" /> <%}else{ %> <input type="radio" class="radioCheck"
	name="<%=ABORTION1 %>" value="" /> <%} %>
<div class="clear"></div>

<label class="large">Do you have a child less than one year old
?</label> <label class="small">Yes</label> <%if(donationEntryHeader.getChildLess().equalsIgnoreCase("y")){ %>
<input type="radio" class="radioCheck" name="<%=CHILD_LESS %>"
	value="<%=donationEntryHeader.getChildLess() %>" checked="checked" />
<%}else{ %> <input type="radio" class="radioCheck" name="<%=CHILD_LESS %>"
	value="" /> <%} %> <label class="small">No</label> <%if(donationEntryHeader.getChildLess().equalsIgnoreCase("n")){ %>
<input type="radio" class="radioCheck" name="<%=CHILD_LESS %>"
	value="<%=donationEntryHeader.getChildLess()%>" checked="checked" /> <%}else{ %>
<input type="radio" class="radioCheck" name="<%=CHILD_LESS %>" value="" />
<%} %>

<div class="clear"></div>

<label class="large">Are you under menses today ?</label> <label
	class="small">Yes</label> <%if(donationEntryHeader.getMenses().equalsIgnoreCase("y")){ %>
<input type="radio" class="radioCheck" name="<%=MENSES %>"
	value="<%=donationEntryHeader.getMenses() %>" checked="checked" /> <%}else{ %>
<input type="radio" class="radioCheck" name="<%=MENSES %>" value="" />
<%} %> <label class="small">No</label> <%if(donationEntryHeader.getMenses().equalsIgnoreCase("n")){ %>
<input type="radio" class="radioCheck" name="<%=MENSES %>"
	value="<%=donationEntryHeader.getMenses() %>" checked="checked" /> <%}else{ %>
<input type="radio" class="radioCheck" name="<%=MENSES %>" value="" />
<%} %>
<div class="clear"></div>

<label class="large">N/A</label> <label class="small">Yes</label> <%if(donationEntryHeader.getNA5().equalsIgnoreCase("y")){ %>
<input type="radio" class="radioCheck" name="<%=N_A5 %>"
	value="<%=donationEntryHeader.getNA5()%>" checked="checked" /> <%}else{ %>
<input type="radio" class="radioCheck" name="<%=N_A5 %>" value="" /> <%} %>
<label class="small">No</label> <%if(donationEntryHeader.getNA5().equalsIgnoreCase("n")){ %>
<input type="radio" class="radioCheck" name="<%=N_A5%>"
	value="<%=donationEntryHeader.getNA5() %>" checked="checked" /> <%}else{ %>
<input type="radio" class="radioCheck" name="<%=N_A5 %>" value="" /> <%} %>

<div class="clear"></div>

<label class="large">Would you like to be informed about any
abnormal test result at the address furnished by you ?</label> <label
	class="small">Yes</label> <%if(donationEntryHeader.getAbnormalTestResult().equalsIgnoreCase("y")) {%>
<input type="radio" class="radioCheck" name="<%=ABNORMAL_TEST_RESULT %>"
	value="<%=donationEntryHeader.getAbnormalTestResult() %>"
	checked="checked" /> <%}else{ %> <input type="radio" class="radioCheck"
	name="<%=ABNORMAL_TEST_RESULT %>" value="" /> <%} %> <label
	class="small">No</label> <%if(donationEntryHeader.getAbnormalTestResult().equalsIgnoreCase("n")){ %>
<input type="radio" class="radioCheck" name="<%=ABNORMAL_TEST_RESULT %>"
	value="<%= donationEntryHeader.getAbnormalTestResult()%>"
	checked="checked" /> <%}else{ %> <input type="radio" class="radioCheck"
	name="<%=ABNORMAL_TEST_RESULT %>" value="" /> <%} %>

<div class="clear"></div>
<label class="large">Date of Collection</label> <%if(donationEntryHeader.getCollectionDate() != null){ %>
<input type="text" class="date" id="collDateId"
	name="<%=COLLECTION_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(donationEntryHeader.getCollectionDate()) %>"
	validate="Date of Collection,date,no" /> <%}else{ %> <input type="text"
	class="date" id="collDateId" name="<%=COLLECTION_DATE %>"
	value="<%=currentDate %>" validate="Date of Collection,date,no"
	MAXLENGTH="10" /> <%} %> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=COLLECTION_DATE%>,event)" />

<label>Collection Time</label> <%if(donationEntryHeader.getCollectionTime() != null){ %>
<input type="text" class="small" id="sampleCollectionTime"
	name="<%=COLLECTION_TIME %>"
	value="<%=donationEntryHeader.getCollectionTime() %>"
	onchange="checkTime('bloodDonationEntry','sampleCollectionTime')"
	MAXLENGTH="5" tabindex=1 /> <%}else{ %> <input class="small"
	id="sampleCollectionTime" type="text" name="<%= COLLECTION_TIME%>"
	value="<%=time %>"
	onchange="checkTime('bloodDonationEntry','sampleCollectionTime')"
	MAXLENGTH="5" tabindex=1 /> <%} %>
<div class="clear"></div>


<div class="clear"></div>
</div>
<!--Block Four Ends--> <!--Block Four Ends-->
<div class="clear"></div>
<h4>Physical Examination</h4>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>


<label class="medium">General</label> <%if(donationEntryHeader.getGeneral() != null){ %>
<input type="text" name="<%=GENERAL %>"
	value="<%=donationEntryHeader.getGeneral() %>" maxlength="50" /> <%}else{ %>
<input type="text" name="<%=GENERAL %>" value="" maxlength="50" /> <%} %>

<div class="clear"></div>

<label class="medium"><span>*</span> Height</label> <%if(donationEntryHeader.getHeight() != null){ %>
<input type="text" class="small" name="<%=HEIGHT %>"
	value="<%=donationEntryHeader.getHeight() %>" validate="Height,int,yes"
	maxlength="5" /> <%}else{ %> <input type="text" class="small"
	name="<%=HEIGHT %>" value="" validate="Height,int,yes" maxlength="5" />
<%} %> <label class="small">cm</label> <label class="medium"> <span>*</span>
Weight</label> <%if(donationEntryHeader.getWeight() != null){ %> <input
	type="text" class="small" name="<%=WEIGHT %>"
	value="<%=donationEntryHeader.getWeight() %>" validate="Height,int,yes"
	maxlength="5" /> <%}else{ %> <input type="text" class="small"
	name="<%=WEIGHT %>" value="" validate="Weight,int,yes" maxlength="5" />
<%} %> <label class="small">kg</label> <label class="medium">Pulse</label>
<%if(donationEntryHeader.getPulse() != null){ %> <input type="text"
	class="small" name="<%=PULSE %>"
	value="<%=donationEntryHeader.getPulse() %>" validate="Pulse,flat,no"
	maxlength="6" /> <%}else if(donationEntryHeader.getPulse().equals("0") || donationEntryHeader.getPulse() == null){  %>
<input type="text" class="small" name="<%=PULSE %>" value=""
	validate="Pulse,flat,no" maxlength="6" /> <%} %> <label class="medium">Temp</label>
<%if(donationEntryHeader.getTemp() != null){ %> <input type="text"
	class="small" name="<%=TEMPERATURE %>"
	value="<%=donationEntryHeader.getTemp() %>" validate="Temp,float,no"
	maxlength="5" /> <%}else{ %> <input type="text" class="small"
	name="<%=TEMPERATURE %>" value="" validate="Temp,float,no"
	maxlength="5" /> <%} %> <label class="medium">HB/ DL</label> <%if(donationEntryHeader.getHbDl() != null){ %>
<input type="text" class="small" name="<%=HB_DL %>"
	value="<%=donationEntryHeader.getHbDl() %>" validate="HB/DL,float,no"
	maxlength="5" /> <%}else{ %> <input type="text" class="small"
	name="<%=HB_DL %>" value="" validate="HB/DL,float,no" maxlength="5" />
<%} %> <label class="small">gms %</label> <label class="medium">BP</label>
<%if(donationEntryHeader.getBp() != null){ %> <input type="text"
	class="small" name="<%=BP %>" value="<%=donationEntryHeader.getBp() %>"
	validate="BP,string,no" maxlength="5" /> <%}else{ %> <input type="text"
	class="small" name="<%=BP%>" value="" validate="BP,string,no"
	maxlength="5" /> <%} %> <label class="small">mm hg</label>

<div class="clear"></div>

<label>Phlebotomy site</label> <select name="<%=PHLEBOTOMY_SITE%>">
	<option value="healthy">Healthy</option>
</select> <input type="hidden" class="date"
	name="<%=BLOOD_DONATION_ENTRY_HEADER_ID %>"
	value="<%=donationEntryHeader.getId() %>" /> <label>Expiry
Date</label> <%if(donationEntryHeader.getExpiryDate()!= null){ %> <input
	type="text" class="date" name="<%=EXPIRY_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(donationEntryHeader.getExpiryDate()) %>" />
<%}else{ %> <input type="text" class="date" id="lastDateId"
	name="<%=EXPIRY_DATE %>" value="<%=currentDate %>"
	validate="Date of Collection,date,no" MAXLENGTH="10" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=EXPIRY_DATE%>,event)" />
<%} %> <label> <span>*</span> Collected By</label> <select
	id="collectedById" name=<%=EMPLOYEE_ID %>
	validate="Blood Group,string,yes">
	<option value="0">Select</option>
	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<%if(donationEntryHeader.getCollectedBy().getId() .equals(masEmployee.getId())){ %>
	<option value="<%=donationEntryHeader.getCollectedBy().getId()%>"
		selected="selected"><%=donationEntryHeader.getCollectedBy().getFirstName()%></option>
	<%}else{ %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()%></option>
	<%		}} } %>
</select>

<div class="clear"></div>
<label>VOL/REP</label> <select name="<%=VOL_REP %>">
	<option value="0">Select</option>
	<option value="v">Volume</option>
	<option value="r">Repalcement</option>
</select> <input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" />

<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<thead>
		<tr>
			<th scope="col">Sr. No.</th>
			<th scope="col">` No.</th>
			<th scope="col">Component Name</th>
			<th scope="col">Quantity (ml)</th>
		</tr>
	</thead>
	<tbody>
		<%	
 String bloodBagNo="";
 String componentCode="";
 String quantity="";
 String componentNamewithId="";
 int bloodDonationDetailId=0;
    	int detailCounter=8; 
    	int temp=0;
    	int inc = 1;  
    	BloodDonationEntryDetail bloodDonationEntryDetail=new BloodDonationEntryDetail();
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	} 
    	List<BloodDonationEntryDetail>donationEntryDetailList=new ArrayList<BloodDonationEntryDetail>(donationEntryHeader.getBloodDonationEntryDetails());
    	//for(inc=1;inc<=8;inc++){
    		//if(inc<=donationEntryDetailList.size()){
    		if(donationEntryDetailList.size() > 0){
    			bloodDonationEntryDetail=donationEntryDetailList.get(inc-1);
    			bloodBagNo=bloodDonationEntryDetail.getBloodBagNo();
    			componentNamewithId=bloodDonationEntryDetail.getComponent().getComponentName()+"["+bloodDonationEntryDetail.getComponent().getId()+"]";
    			componentCode=bloodDonationEntryDetail.getComponent().getComponentCode();
    			quantity=bloodDonationEntryDetail.getQty().toString();
    			bloodDonationDetailId=bloodDonationEntryDetail.getId();
    		}		
    		else{
    			bloodBagNo="";
    			componentCode="";
    		    quantity="";
    			componentNamewithId="";
    			bloodDonationDetailId= 0;
    		}
    		%>



		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<td><input id="bloodDoantionId<%=inc%>" type="hidden"
				name="<%=BLOOD_DONATION_ENTRY_DETAIL_ID%>"
				value="<%=bloodDonationDetailId%>" /> <input
				id="bloodBagId<%=inc%>" type="text" name="<%=BLOOD_BAG_NO%>"
				value="<%= bloodBagNo%>"
				onblur="checkForBloodBagNo1(this.value, '<%=inc %>');checkBloodBagNo(bloodDonationEntry,'<%=inc %>');"
				size="20" MAXLENGTH="45" tabindex=1 /> <input type="hidden"
				value="<%=bloodDonationEntryDetail.getComponent().getId() %>"
				name="<%=BLOOD_COMPONENT_ID%>" id="bloodComponentId<%=inc %>" /></td>

			<td><input type="text" id="componentName<%=inc%>"
				name="bloodComponentName" value="<%=componentNamewithId %>"
				onblur="if(fillSrNo('<%=inc %>')){checkForComponentCode(this.value, '<%=inc %>');}" />

			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
  new Ajax.Autocompleter(document.getElementById('componentName<%=inc%>'),'ac2update','bloodBank?method=getComponentNameForAutoComplete',{parameters:'requiredField=bloodComponentName'});
			</script></td>
			<td><input type="text" id="quantity<%=inc%>"
				name="<%=QUANTITY %>" value="<%=quantity %>" validate="Qty,int,no"
				MAXLENGTH="3" /> <input type="hidden"
				name="bloodBagNoValueCheckOnSubmit"
				id="bloodBagNoValueCheckOnSubmit<%=inc%>" value="correctBloodBagNo" />
			</td>
		</tr>
		<%//} %>
		<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
	</tbody>

</table>

<div class="clear"></div>


<div class="division"></div>
<!--Bottom labels starts-->
<div class="clear"></div>
<input type="button" class="button" value="Update"
	onclick="submitForm('bloodDonationEntry','bloodBank?method=updateBloodDonation');"
	align="right" /> <input type="reset" class="buttonHighlight"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodDonationEntry',<%=inc %>);" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<input type="hidden" name="changed_by" value="<%=userName%>"><label>Changed
Date</label> <label class="value"><%=currentDate%></label> <input type="hidden"
	name="changed_date" value="<%=currentDate%>"><label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="changed_time" value="<%=time%>">
<div class="clear"></div></div>

<div class="clear"></div>
<div class="paddingTop40"></div>
<!--Bottom labels starts--> <!--main content placeholder ends here-->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
function fillSrNo(rowVal){

	if(document.getElementById('componentName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('componentName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}
function checkForComponentCode(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
		
		if(componentId =="")
		{
	     document.getElementById('componentCode'+inc).value="";
	  	 document.getElementById('qty'+inc).value="";
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('componentName'+i).value==val)
		{
			alert("Component Name already selected...!")
			document.getElementById('componentName'+inc).value=""
			var e=eval(document.getElementById('componentName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteComponentName('bloodDonationEntry','bloodBank?method=fillItemsForComponentname&componentName=' +  componentName , inc);
		
		}else{
			document.getElementById('componentCode'+inc).value = "";
			document.getElementById('qty'+inc).value = "";
		}
}



	function checkBloodBagNoForExisting(bagNoObj, rowCount) 
	{
  	 	var xmlHttp;
     		try {
    			// Firefox, Opera 8.0+, Safari
   	 			xmlHttp=new XMLHttpRequest();
	  		}catch (e){
    		// Internet Explorer
    			try{
     	 			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    			}catch (e){
    				alert(e)
     	 			try{
        				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
     	 			}catch (e){
        				alert("Your browser does not support AJAX!");
        				return false;
      				}
     			}
   			}
    	xmlHttp.onreadystatechange=function()
    	{
     	 	if(xmlHttp.readyState==4){
      		var items =xmlHttp.responseXML.getElementsByTagName('bloodBagNoFlags')[0];
       			for (loop = 0; loop < items.childNodes.length; loop++) 
      			{
	   		    	var item = items.childNodes[loop];
	    	    	var flagValue  = item.getElementsByTagName("flagValue")[0];
	    	    	var checkResult = flagValue.childNodes[0].nodeValue;
	    	    	if(checkResult == 'Duplicate'){
	    	    		alert('Blood Bag No. '+ bagNoObj.value + ' already exist.');
	    	    		document.getElementById('bloodBagNoValueCheckOnSubmit'+rowCount).value='duplicateBloodBagNo';
	    	    		return false;
	    	    	}else{
	    	    		document.getElementById('bloodBagNoValueCheckOnSubmit'+rowCount).value='correctBloodBagNo';
						return true;	    	    	
	    	    	}
      			}
    		}
  		}
  		bloodBagNo = bagNoObj.value;
  		// alert(radioNoObj.value);
  		// alert(rowCount);
  		 //return false;
  		var bloodDonationIdToCheck = document.getElementById('bloodComponentId'+rowCount).value;
  		var url="/hms/hms/bloodBank?method=checkForExistingBloodBagNo&bloodbagNoToCheck="+bloodBagNo+"";
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    	xmlHttp.open("GET",url,true);
    	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(null);
  		
	}
	

function checkFilledRow(){
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('componentName'+i).value != ""){
	  			if(document.getElementById('bloodBagId'+i).value == ""){
	  				msg += "BloodBag No. can not be blank.\n";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	}
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }
	 }
function checkForBloodBagNo1(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentNa`me = val.substring(0,indexForComponentName);
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('bloodBagId'+i).value==val)
		{
			alert("Blood bag already selected...!")
			document.getElementById('bloodBagId'+inc).value=""
			var e=eval(document.getElementById('bloodBagId'+inc)); 
			e.focus();
			return false;
		} }  }
		
		}
}

</script>

