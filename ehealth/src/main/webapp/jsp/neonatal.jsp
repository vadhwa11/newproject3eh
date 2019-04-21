
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.OpdNeonatalSpeciality"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.BabyDetails"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/csrfToken.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/prototypeq.js"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>

<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script>jQuery.noConflict();</script>
<script type="text/javascript">
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
<script type="text/javascript" language="javascript">
	<%	
	
	Map<String, Object> map = new HashMap<String, Object>();
	List<Inpatient> ipList = new ArrayList<Inpatient>();
	List<BabyDetails> babyDetailsList = new ArrayList<BabyDetails>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<Patient> motherPatientList = new ArrayList<Patient>();
	
	List<OpdNeonatalSpeciality> opdNeonatalSpecialityList =  new ArrayList<OpdNeonatalSpeciality>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	List<MasBloodGroup> bloodGroupList=new ArrayList<MasBloodGroup>();
	if(map.get("bloodGroupList")!=null){
		bloodGroupList=(List)map.get("bloodGroupList");
	}
	
	if(map.get("ipList") != null){
		ipList = (List<Inpatient>) map.get("ipList");
		 }
	 if(map.get("opdNeonatalSpecialityList") != null){
		 opdNeonatalSpecialityList = (List<OpdNeonatalSpeciality>) map.get("opdNeonatalSpecialityList");
	 }
		 if(map.get("babyDetailsList") != null){
			 babyDetailsList = (List<BabyDetails>) map.get("babyDetailsList");
		 }

		 if(map.get("patientList") != null){
			 patientList = (List<Patient>) map.get("patientList");
		 }

		 if(map.get("motherPatientList") != null){
			 motherPatientList = (List<Patient>) map.get(motherPatientList);
		 }
		 
		 String currentAge="";

		 if(map.get("currentAge") != null){
		 	currentAge = (String) map.get("currentAge");
		 }

			


	%>

	</script>


<form name="leprosyProforma" action="" method="post">
<div class="Block">

<div class="clear"></div>
<div class="paddingTop5"></div>
<h6>Neonatal Case Record Sheet</h6>
<div class="clear"></div>
<div class="clear"></div>
<%
Date doba=new Date();
String dota="";
String dobas="";

if(ipList!=null && ipList.size()>0)
{
for(Inpatient ip:ipList){
	doba=ip.getDateOfAddmission();
	if(doba==null){
		dobas="";
	}else{
		dobas=HMSUtil.convertDateToStringWithoutTime(ip.getDateOfAddmission());
	}
	dota=ip.getTimeOfAddmission();
}
}
Date dob=null;
String dot="";
String bwt="";
String birthRegNo="";
String dobs="";
if(babyDetailsList!=null && babyDetailsList.size()>0)
{
for(BabyDetails b:babyDetailsList){
	
	
	dot=b.getTimeOfBirth();
	bwt=b.getWeight();
}
}
String ageOfMother="";
if(patientList!=null && patientList.size()>0)
{
for(Patient p:patientList){
	
	
	dob=p.getDateOfBirth();
	if(dob==null){
		dobs="";
	}else{
		dobs=HMSUtil.convertDateToStringWithoutTime(p.getDateOfBirth());
	}
	
}
}
if(motherPatientList!=null && motherPatientList.size()>0)
{
for(Patient p:motherPatientList){
	
	
	ageOfMother=p.getAge()!=null?p.getAge():"";
	
	
}

}

String abortion = "";
String  ageOfMarriage="";
String amnioticFluid="";
String amnioticFluidVolume="";
String antenatalSteroids="";
String antenatalSteroidsYes="";
String apgarAtFiveMin="";
String apgarAtOneMin="";
String aph="";
String apnea="";
String attachment="";
String bbsAg="";
String birthSpacing="";
String bulgingAnteriorFontanel="";
String bleeding="";
String bleedingYes="";
String bloodGroup=""; 
String bloodSugar="";
String breastFed="";
String chestInDrawing = "";
String cns = "";
String color = "";
String congenitalMalformation = "";
String congenitalMalformationAnother = "";
String congenitalMalformationAnotherOtherText = "";
String consanguinity = "";
String convulsions = "";
String criedImmedAfterBirth = "";
String crt = "";
String cvs = "";
String days = "";
String deliveryAttendedBy = "";
String deliveryAttendedByOtherText = "";
String drug = "";
String drugText = "";
String edd = "";
String eoFeotalDistress = "";
String finalDiagnosisA = "";
String  finalDiagnosisB = "";
String finalDiagnosisC = "";
String finalDiagnosisD = "";
String finalDiagnosisE = "";
String foulSmellingDischarge = "";
String  gdm = "";
String generalCondition = "";
String gestationalAge = "";
String gestationWeeks = "";
String gravida = "";
String grunting = "";
String hb = "";
String courseOfLabour="";
String headCircumference = "";
String hivTesting = "";
String hoFever = "";
String illness = "";
String illnessOtherText = "";
String indicationA = "";
String indicationB = "";
String indicationC = "";
String indicationD = "";
String indicationE = "";
String indicationForCaesareanApplicable = "";
String indicationForCaesareanApplicableOtherText = "";
String jaundice = "";
String jaundiceYes = "";
String labour = "";
String leasking = "";
String length = "";
String lmp = "";
String liveBirth = "";
String otherSignificantFinding = "";
String otherSignificantInformation = "";
String otherSignificantInformationGeneral = "";
String otherSignificantInformationLabour = "";
String oxygenSaturation = "";
String maturity = "";
String meconiumStainedCord = "";
String modeOfTransport = "";
String motherWt = "";
String  noseOfDoses = "";
String para = "";
String perAbdomen = "";
String pih = "";
String pihLabour ="";
String placeOfDelivery ="";
String plantarUlcer ="";
String pph ="";
String presentation ="";
String  presentingComplaints ="";
String radiation ="";
String respiratory ="";
String resuscitationRequired ="";
String skinPinch ="";
String  skinPustules ="";
String sucking ="";
String umbilious ="";
String uterineTenderness ="";
String  vdrl ="";
String vitaminKGiven ="";
String takingBreastFeeds ="";
String thyroid ="";
String timeBetweenLastDoseDelivery ="";
String tone ="";
String ttDoses ="";
String typeOfAdmission ="";
String typeOfDelivery ="";
String bTime="";
String bWeight="";
String wtOnAdmission="";
String ageOnAdmission="";
if(opdNeonatalSpecialityList!=null && opdNeonatalSpecialityList.size()>0)
{
for(OpdNeonatalSpeciality opdNeonatalSpeciality:opdNeonatalSpecialityList){
	
	abortion = opdNeonatalSpeciality.getAbortion()!=null?opdNeonatalSpeciality.getAbortion():"";
	ageOfMarriage = opdNeonatalSpeciality.getAgeOfMarriage()!=null?opdNeonatalSpeciality.getAgeOfMarriage():"";
	amnioticFluid = opdNeonatalSpeciality.getAmnioticFluid()!=null?opdNeonatalSpeciality.getAmnioticFluid():"";
	amnioticFluidVolume = opdNeonatalSpeciality.getAmnioticFluidVolume()!=null?opdNeonatalSpeciality.getAmnioticFluidVolume():"";
	antenatalSteroids = opdNeonatalSpeciality.getAntenatalSteroids()!=null?opdNeonatalSpeciality.getAntenatalSteroids():"";
	antenatalSteroidsYes = opdNeonatalSpeciality.getAntenatalSteroidsYes()!=null?opdNeonatalSpeciality.getAntenatalSteroidsYes():"";
	apgarAtFiveMin = opdNeonatalSpeciality.getApgarAtFiveMin()!=null?opdNeonatalSpeciality.getApgarAtFiveMin():"";
	apgarAtOneMin = opdNeonatalSpeciality.getApgarAtOneMin()!=null?opdNeonatalSpeciality.getApgarAtOneMin():"";
	aph = opdNeonatalSpeciality.getAph()!=null?opdNeonatalSpeciality.getAph():"";
	apnea = opdNeonatalSpeciality.getApnea()!=null?opdNeonatalSpeciality.getAph():"";
	attachment = opdNeonatalSpeciality.getAttachment()!=null?opdNeonatalSpeciality.getAttachment():"";
	ageOfMother= opdNeonatalSpeciality.getMotherAge()!=null?opdNeonatalSpeciality.getMotherAge():"";
	bbsAg = opdNeonatalSpeciality.getBbsAg()!=null?opdNeonatalSpeciality.getBbsAg():"";
	birthSpacing = opdNeonatalSpeciality.getBirthSpacing()!=null?opdNeonatalSpeciality.getBirthSpacing():"";
	 bleeding = opdNeonatalSpeciality.getBleeding()!=null?opdNeonatalSpeciality.getBleeding():"";
	 bleedingYes = opdNeonatalSpeciality.getBleedingYes()!=null?opdNeonatalSpeciality.getBleedingYes():"";
	 bloodGroup = opdNeonatalSpeciality.getBloodGroup()!=null?opdNeonatalSpeciality.getBloodGroup():"";
	 bloodSugar = opdNeonatalSpeciality.getBloodSugar()!=null?opdNeonatalSpeciality.getBloodSugar():"";
	 breastFed = opdNeonatalSpeciality.getBreastFed()!=null?opdNeonatalSpeciality.getBreastFed():"";
	 courseOfLabour= opdNeonatalSpeciality.getCourseOfLabour()!=null?opdNeonatalSpeciality.getCourseOfLabour():"";
	 bulgingAnteriorFontanel = opdNeonatalSpeciality.getBulgingAnteriorFontanel()!=null?opdNeonatalSpeciality.getBulgingAnteriorFontanel():"";
	 chestInDrawing = opdNeonatalSpeciality.getChestInDrawing()!=null?opdNeonatalSpeciality.getChestInDrawing():"";
	 cns = opdNeonatalSpeciality.getCns()!=null?opdNeonatalSpeciality.getCns():"";
	 color = opdNeonatalSpeciality.getColor()!=null?opdNeonatalSpeciality.getColor():"";
	 congenitalMalformation = opdNeonatalSpeciality.getCongenitalMalformation()!=null?opdNeonatalSpeciality.getCongenitalMalformation():"";
	 congenitalMalformationAnother = opdNeonatalSpeciality.getCongenitalMalformationAnother()!=null?opdNeonatalSpeciality.getCongenitalMalformationAnother():"";
	 congenitalMalformationAnotherOtherText = opdNeonatalSpeciality.getCongenitalMalformationAnotherOtherText()!=null?opdNeonatalSpeciality.getCongenitalMalformationAnotherOtherText():"";
	 consanguinity = opdNeonatalSpeciality.getConsanguinity()!=null?opdNeonatalSpeciality.getConsanguinity():"";
	 convulsions = opdNeonatalSpeciality.getConvulsions()!=null?opdNeonatalSpeciality.getConvulsions():"";
	 criedImmedAfterBirth = opdNeonatalSpeciality.getCriedImmedAfterBirth()!=null?opdNeonatalSpeciality.getCriedImmedAfterBirth():"";
	 crt = opdNeonatalSpeciality.getCrt()!=null?opdNeonatalSpeciality.getCrt():"";
	 cvs = opdNeonatalSpeciality.getCvs()!=null?opdNeonatalSpeciality.getCvs():"";
	 days = opdNeonatalSpeciality.getDays()!=null?opdNeonatalSpeciality.getDays():"";
	 deliveryAttendedBy = opdNeonatalSpeciality.getDeliveryAttendedBy()!=null?opdNeonatalSpeciality.getDeliveryAttendedBy():"";
	 deliveryAttendedByOtherText = opdNeonatalSpeciality.getDeliveryAttendedByOtherText()!=null?opdNeonatalSpeciality.getDeliveryAttendedByOtherText():"";
	 drug = opdNeonatalSpeciality.getDrug()!=null?opdNeonatalSpeciality.getDrug():"";
	 drugText = opdNeonatalSpeciality.getDrugText()!=null?opdNeonatalSpeciality.getDrugText():"";
	 edd = opdNeonatalSpeciality.getEdd()!=null?HMSUtil.convertDateToStringWithoutTime(opdNeonatalSpeciality.getEdd()):"";
	 bwt=opdNeonatalSpeciality.getBWt()!=null?opdNeonatalSpeciality.getBWt():"";
	 birthRegNo=opdNeonatalSpeciality.getBirthRegNo()!=null?opdNeonatalSpeciality.getBirthRegNo():"";
	 eoFeotalDistress = opdNeonatalSpeciality.getEoFeotalDistress()!=null?opdNeonatalSpeciality.getEoFeotalDistress():"";
	 finalDiagnosisA = opdNeonatalSpeciality.getFinalDiagnosisA()!=null?opdNeonatalSpeciality.getFinalDiagnosisA():"";
	 finalDiagnosisB = opdNeonatalSpeciality.getFinalDiagnosisB()!=null?opdNeonatalSpeciality.getFinalDiagnosisB():"";
	 finalDiagnosisC = opdNeonatalSpeciality.getFinalDiagnosisC()!=null?opdNeonatalSpeciality.getFinalDiagnosisC():"";
	 finalDiagnosisD = opdNeonatalSpeciality.getFinalDiagnosisD()!=null?opdNeonatalSpeciality.getFinalDiagnosisD():"";
	 finalDiagnosisE = opdNeonatalSpeciality.getFinalDiagnosisE()!=null?opdNeonatalSpeciality.getFinalDiagnosisE():"";
	 foulSmellingDischarge = opdNeonatalSpeciality.getFoulSmellingDischarge()!=null?opdNeonatalSpeciality.getFoulSmellingDischarge():"";
	 gdm = opdNeonatalSpeciality.getGdm()!=null?opdNeonatalSpeciality.getGdm():"";
	 generalCondition = opdNeonatalSpeciality.getGeneralCondition()!=null?opdNeonatalSpeciality.getGeneralCondition():"";
	 gestationalAge = opdNeonatalSpeciality.getGestationalAge()!=null?opdNeonatalSpeciality.getGestationalAge():"";
	 gestationWeeks = opdNeonatalSpeciality.getGestationWeeks()!=null?opdNeonatalSpeciality.getGestationWeeks():"";
	 gravida = opdNeonatalSpeciality.getGravida()!=null?opdNeonatalSpeciality.getGravida():"";
	 grunting = opdNeonatalSpeciality.getGrunting()!=null?opdNeonatalSpeciality.getGrunting():"";
	 hb = opdNeonatalSpeciality.getHb()!=null?opdNeonatalSpeciality.getHb():"";
	 headCircumference = opdNeonatalSpeciality.getHeadCircumference()!=null?opdNeonatalSpeciality.getHeadCircumference():"";
	 hivTesting = opdNeonatalSpeciality.getHivTesting()!=null?opdNeonatalSpeciality.getHivTesting():"";
	 hoFever = opdNeonatalSpeciality.getHoFever()!=null?opdNeonatalSpeciality.getHoFever():"";
	 illness = opdNeonatalSpeciality.getIllness()!=null?opdNeonatalSpeciality.getIllness():"";
	 illnessOtherText = opdNeonatalSpeciality.getIllnessOtherText()!=null?opdNeonatalSpeciality.getIllnessOtherText():"";
	 indicationA = opdNeonatalSpeciality.getIndicationA()!=null?opdNeonatalSpeciality.getIndicationA():"";
	 indicationB = opdNeonatalSpeciality.getIndicationB()!=null?opdNeonatalSpeciality.getIndicationB():"";
	 indicationC = opdNeonatalSpeciality.getIndicationC()!=null?opdNeonatalSpeciality.getIndicationC():"";
	 indicationD = opdNeonatalSpeciality.getIndicationD()!=null?opdNeonatalSpeciality.getIndicationD():"";
	 indicationE = opdNeonatalSpeciality.getIndicationE()!=null?opdNeonatalSpeciality.getIndicationE():"";
	 indicationForCaesareanApplicable = opdNeonatalSpeciality.getIndicationForCaesareanApplicable()!=null?opdNeonatalSpeciality.getIndicationForCaesareanApplicable():"";
	 indicationForCaesareanApplicableOtherText = opdNeonatalSpeciality.getIndicationForCaesareanApplicableotherText()!=null?opdNeonatalSpeciality.getIndicationForCaesareanApplicableotherText():"";
	 jaundice = opdNeonatalSpeciality.getJaundice()!=null?opdNeonatalSpeciality.getJaundice():"";
	 jaundiceYes = opdNeonatalSpeciality.getJaundiceYes()!=null?opdNeonatalSpeciality.getJaundiceYes():"";
	 labour = opdNeonatalSpeciality.getLabour()!=null?opdNeonatalSpeciality.getLabour():"";
	 leasking = opdNeonatalSpeciality.getLeasking()!=null?opdNeonatalSpeciality.getLeasking():"";
	 length = opdNeonatalSpeciality.getLength()!=null?opdNeonatalSpeciality.getLength():"";
	 lmp =opdNeonatalSpeciality.getLmp()!=null?HMSUtil.convertDateToStringWithoutTime(opdNeonatalSpeciality.getLmp()):"";
	 liveBirth = opdNeonatalSpeciality.getLiveBirth()!=null?opdNeonatalSpeciality.getLiveBirth():"";
	 otherSignificantFinding = opdNeonatalSpeciality.getOtherSignificantFinding()!=null?opdNeonatalSpeciality.getOtherSignificantFinding():"";
	 otherSignificantInformation = opdNeonatalSpeciality.getOtherSignificantInformation()!=null?opdNeonatalSpeciality.getOtherSignificantInformation():"";
	 otherSignificantInformationGeneral = opdNeonatalSpeciality.getOtherSignificantInformationgeneral()!=null?opdNeonatalSpeciality.getOtherSignificantInformationgeneral():"";
	 otherSignificantInformationLabour = opdNeonatalSpeciality.getOtherSignificantInformationLabour()!=null?opdNeonatalSpeciality.getOtherSignificantInformationLabour():"";
	 oxygenSaturation = opdNeonatalSpeciality.getOxygenSaturation()!=null?opdNeonatalSpeciality.getOxygenSaturation():"";
	 maturity = opdNeonatalSpeciality.getMaturity()!=null?opdNeonatalSpeciality.getMaturity():"";
	 meconiumStainedCord = opdNeonatalSpeciality.getMeconiumStainedCord()!=null?opdNeonatalSpeciality.getMeconiumStainedCord():"";
	 modeOfTransport = opdNeonatalSpeciality.getModeOfTransport()!=null?opdNeonatalSpeciality.getModeOfTransport():"";
	 motherWt = opdNeonatalSpeciality.getMotherWt()!=null?opdNeonatalSpeciality.getMotherWt():"";
	 noseOfDoses = opdNeonatalSpeciality.getNoseOfDoses()!=null?opdNeonatalSpeciality.getNoseOfDoses():"";
	 para = opdNeonatalSpeciality.getPara()!=null?opdNeonatalSpeciality.getPara():"";
	 perAbdomen = opdNeonatalSpeciality.getPerAbdomen()!=null?opdNeonatalSpeciality.getPerAbdomen():"";
	 pih = opdNeonatalSpeciality.getPih()!=null?opdNeonatalSpeciality.getPih():"";
	 pihLabour = opdNeonatalSpeciality.getPihLabour()!=null?opdNeonatalSpeciality.getPihLabour():"";
	 placeOfDelivery = opdNeonatalSpeciality.getPlaceOfDelivery()!=null?opdNeonatalSpeciality.getPlaceOfDelivery():"";
	 plantarUlcer = opdNeonatalSpeciality.getPlantarUlcer()!=null?opdNeonatalSpeciality.getPlantarUlcer():"";
	 pph = opdNeonatalSpeciality.getPph()!=null?opdNeonatalSpeciality.getPph():"";
	 presentation = opdNeonatalSpeciality.getPresentation()!=null?opdNeonatalSpeciality.getPresentation():"";
	 presentingComplaints = opdNeonatalSpeciality.getPresentingComplaints()!=null?opdNeonatalSpeciality.getPresentingComplaints():"";
	 radiation = opdNeonatalSpeciality.getRadiation()!=null?opdNeonatalSpeciality.getRadiation():"";
	 respiratory = opdNeonatalSpeciality.getRespiratory()!=null?opdNeonatalSpeciality.getRespiratory():"";
	 resuscitationRequired = opdNeonatalSpeciality.getResuscitationRequired()!=null?opdNeonatalSpeciality.getResuscitationRequired():"";
	 skinPinch = opdNeonatalSpeciality.getSkinPinch()!=null?opdNeonatalSpeciality.getSkinPinch():"";
	 skinPustules = opdNeonatalSpeciality.getSkinPustules()!=null?opdNeonatalSpeciality.getSkinPustules():"";
	 sucking = opdNeonatalSpeciality.getSucking()!=null?opdNeonatalSpeciality.getSucking():"";
	 umbilious = opdNeonatalSpeciality.getUmbilious()!=null?opdNeonatalSpeciality.getUmbilious():"";
	 uterineTenderness = opdNeonatalSpeciality.getUterineTenderness()!=null?opdNeonatalSpeciality.getUterineTenderness():"";
	 vdrl = opdNeonatalSpeciality.getVdrl()!=null?opdNeonatalSpeciality.getVdrl():"";
	 vitaminKGiven = opdNeonatalSpeciality.getVitaminKGiven()!=null?opdNeonatalSpeciality.getVitaminKGiven():"";
	 takingBreastFeeds = opdNeonatalSpeciality.getTakingBreastFeeds()!=null?opdNeonatalSpeciality.getTakingBreastFeeds():"";
	 thyroid = opdNeonatalSpeciality.getThyroid()!=null?opdNeonatalSpeciality.getThyroid():"";
	 timeBetweenLastDoseDelivery = opdNeonatalSpeciality.getTimeBetweenLastDoseDelivery()!=null?opdNeonatalSpeciality.getTimeBetweenLastDoseDelivery():"";
	 tone = opdNeonatalSpeciality.getTone()!=null?opdNeonatalSpeciality.getTone():"";
	 ttDoses = opdNeonatalSpeciality.getTtDoses()!=null?opdNeonatalSpeciality.getTtDoses():"";
	 typeOfAdmission = opdNeonatalSpeciality.getTypeOfAdmission()!=null?opdNeonatalSpeciality.getTypeOfAdmission():"";
	 typeOfDelivery = opdNeonatalSpeciality.getTypeOfDelivery()!=null?opdNeonatalSpeciality.getTypeOfDelivery():"";
	 dot=opdNeonatalSpeciality.getBTime()!=null?opdNeonatalSpeciality.getBTime():"";
	 bWeight=opdNeonatalSpeciality.getBWeight()!=null?opdNeonatalSpeciality.getBWeight():"";
	 wtOnAdmission=opdNeonatalSpeciality.getWtOnAdmission()!=null?opdNeonatalSpeciality.getWtOnAdmission():"";
	ageOnAdmission=	opdNeonatalSpeciality.getAgeOnAdmission()!=null?opdNeonatalSpeciality.getAgeOnAdmission():"";
			 
}
}
%>
<input id="neonatalFlag" name="neonatalFlag" tabindex="1" value="Neonatal" type="hidden"  />
<label>Date of Birth</label>
<input  type="text"  name="bDateId"  id="bDateId" value="<%=dobs%>" readonly="readonly"/>
<input  type="hidden"  name="bDate" value="<%=dobs%>" readonly="readonly"/>

<label>Time of Birth</label>
<%if(bTime!=null){ %>
<input  type="text"  name="bTime" value="<%=dot %>" maxlength="5" validate="Time of Birth,timeFormat,no" onkeyup="mask(this.value,this,'2',':');"  onBlur="IsValidTimeForSetup(this.value,this.id);"/>
<%}else{ %>
<input  type="text"  name="bTime" value="" validate="Time of Birth,timeFormat,no" maxlength="5" onkeyup="mask(this.value,this,'2',':');"  onBlur="IsValidTimeForSetup(this.value,this.id);"/>
<%} %>

<div class="clear"></div>
<label>Birth Weight(kg)</label>
<%if(bWeight!=null){ %>
<input  type="text"  name="bWeight" value="<%=bWeight %>" maxlength="5" validate="Weight,float,no"/>
<%}else{ %>
<input  type="text"  name="bWeight" value="" maxlength="5" validate="Weight,float,no"/>
<%} %>

<label>Date of Admission</label>
<input  type="text"  name="aDateId"   id="aDateId" value="<%=dobas%>" readonly="readonly"/>
<input  type="hidden"  name="aDate" value="<%=dobas%>" readonly="readonly"/>

<div class="clear"></div>
<label>Time of Admission</label>
<input  type="text"  name="aTime" value="<%=dota %>" readonly="readonly"/>

<label>Age on Admission</label>
<input  type="text"  name="ageOnAdmission" value="<%=currentAge %>" maxlength="3"  validate="Age on Admission,string,no" readonly="readonly"/>

<div class="clear"></div>
<label>Birth Reg No.</label>
<input  type="text"  name="birthRegNo" value="<%=birthRegNo %>"  maxlength="20"  validate="Birth Reg No.,string,no"/>

<label>Wt on Admission(Kg)</label>
<%if(wtOnAdmission!=null){ %>
<input  type="text"  name="wtOnAdmission" value="<%=wtOnAdmission %>" maxlength="2" validate="Wt on Admission(Kg),int,no"/>
<%}else{ %>
<input  type="text"  name="wtOnAdmission" value="" validate="Wt on Admission(Kg),int,no" maxlength="2"/>
<%} %>

<div class="clear"></div>
<label>Type of Admission </label>
<select  name="typeOfAdmission" id="typeOfAdmission">
<option value="">Select</option>
<option value="Inborn">Inborn</option>
<option value="Out born(Health Facility Referred)">Out born(Health Facility Referred)</option>
<option value="Out born(Community Referred)">Out born(Community Referred)</option>
</select> 
<script>
<%
if(!typeOfAdmission.equals("")){
%>
document.getElementById('typeOfAdmission').value = '<%=typeOfAdmission%>';

<%}%>
</script>

<label>Place of Delivery</label>
<select  name="placeOfDelivery" id="placeOfDelivery">
<option value="">Select</option>
<option value="Home">Home</option>
<option value="Ambulance">Ambulance</option>
<option value="Pvt. Hospital">Pvt. Hospital</option>
<option value="Govt. Provided">Govt. Provided</option>
</select>
<script>
<%
if(!placeOfDelivery.equals("")){
%>
document.getElementById('placeOfDelivery').value = '<%=placeOfDelivery%>';

<%}%>
</script>
<div class="clear"></div>

<label>Mode of Transport</label>
<select  name="modeOfTransport" id="modeOfTransport">
<option value="">Select</option>
<option value="Self Arranged">Self Arranged</option>
<option value="Govt. Provided">Govt. Provided</option>
</select>  
<script>
<%
if(!modeOfTransport.equals("")){
%>
document.getElementById('modeOfTransport').value = '<%=modeOfTransport%>';
<%}%>

</script>
<h4>Indication for Admission</h4>
<label>Indication A</label>
<select  name="indicationA" id="indicationA">
<option value="">Select</option>
<option value="Prernaturity<34 weeks">Prernaturity<34 weeks</option>
<option value="Low Birth Weight <1800 gm">Low Birth Weight <1800 gm</option>
<option value="Perinatal Asphyxia">Perinatal Asphyxia</option>
<option value="Neonatal Jaundice">Neonatal Jaundice</option>
<option value="Resp. Distress(Rate >60 or Grunt / Retractions)">Resp. Distress(Rate >60 or Grunt / Retractions)</option>
<option value="Large Baby(>4 Kg. at 40 weeks)">Large Baby(>4 Kg. at 40 weeks)</option>
<option value="Refusal to Feed">Refusal to Feed</option>
<option value="Central Cyanosis">Central Cyanosis</option>
<option value="Apnea / Gasping">Apnea / Gasping</option>
<option value="Neonatal Convulsions">Neonatal Convulsions</option>
<option value="Baby of Diabetic mother">Baby of Diabetic mother</option>
<option value="Oliguria">Oliguria</option>
<option value="Abdominal Distension">Abdominal Distension</option>
<option value="Hypothermia < 35.4 Ç">Hypothermia < 35.4 Ç</option>
<option value="Hypothermia < 37.5 Ç">Hypothermia < 37.5 Ç</option>
<option value="Hypoglycermia < 45 mg%">Hypoglycermia < 45 mg%</option>
<option value="Shock : Cold Periphery with CFT > 3 sec & Weak Fast Pulse">Shock : Cold Periphery with CFT > 3 sec & Weak Fast Pulse</option>
<option value="Meconium Aspiration">Meconium Aspiration</option>
<option value="Bleeding">Bleeding</option>
<option value="Diarrhoea">Diarrhoea</option>
<option value="Major Congenital Malformation">Major Congenital Malformation</option>
<option value="Unconsciousness">Unconsciousness</option>
<option value="Any Other">Any Other</option>
</select>
<script>
<%
if(!indicationA.equals("")){
%>
document.getElementById('indicationA').value = '<%=indicationA.trim()%>';

<%}%>

</script>
<label>Indication B</label>
<select  name="indicationB" id="indicationB">
<option value="">Select</option>
<option value="Prernaturity<34 weeks">Prernaturity<34 weeks</option>
<option value="Low Birth Weight <1800 gm">Low Birth Weight <1800 gm</option>
<option value="Perinatal Asphyxia">Perinatal Asphyxia</option>
<option value="Neonatal Jaundice">Neonatal Jaundice</option>
<option value="Resp. Distress(Rate >60 or Grunt / Retractions)">Resp. Distress(Rate >60 or Grunt / Retractions)</option>
<option value="Large Baby(>4 Kg. at 40 weeks)">Large Baby(>4 Kg. at 40 weeks)</option>
<option value="Refusal to Feed">Refusal to Feed</option>
<option value="Central Cyanosis">Central Cyanosis</option>
<option value="Apnea / Gasping">Apnea / Gasping</option>
<option value="Neonatal Convulsions">Neonatal Convulsions</option>
<option value="Baby of Diabetic mother">Baby of Diabetic mother</option>
<option value="Oliguria">Oliguria</option>
<option value="Abdominal Distension">Abdominal Distension</option>
<option value="Hypothermia < 35.4 Ç">Hypothermia < 35.4 Ç</option>
<option value="Hypothermia < 37.5 Ç">Hypothermia < 37.5 Ç</option>
<option value="Hypoglycermia < 45 mg%">Hypoglycermia < 45 mg%</option>
<option value="Shock : Cold Periphery with CFT > 3 sec & Weak Fast Pulse">Shock : Cold Periphery with CFT > 3 sec & Weak Fast Pulse</option>
<option value="Meconium Aspiration">Meconium Aspiration</option>
<option value="Bleeding">Bleeding</option>
<option value="Diarrhoea">Diarrhoea</option>
<option value="Major Congenital Malformation">Major Congenital Malformation</option>
<option value="Unconsciousness">Unconsciousness</option>
<option value="Any Other">Any Other</option>
</select>
<script>
<%
if(!indicationB.equals("")){
%>
document.getElementById('indicationB').value = '<%=indicationB.trim()%>';

<%}%>
</script>

<div class="clear"></div>
<label>Indication C</label>
<select  name="indicationC" id="indicationC">
<option value="">Select</option>
<option value="Prernaturity<34 weeks">Prernaturity<34 weeks</option>
<option value="Low Birth Weight <1800 gm">Low Birth Weight <1800 gm</option>
<option value="Perinatal Asphyxia">Perinatal Asphyxia</option>
<option value="Neonatal Jaundice">Neonatal Jaundice</option>
<option value="Resp. Distress(Rate >60 or Grunt / Retractions)">Resp. Distress(Rate >60 or Grunt / Retractions)</option>
<option value="Large Baby(>4 Kg. at 40 weeks)">Large Baby(>4 Kg. at 40 weeks)</option>
<option value="Refusal to Feed">Refusal to Feed</option>
<option value="Central Cyanosis">Central Cyanosis</option>
<option value="Apnea / Gasping">Apnea / Gasping</option>
<option value="Neonatal Convulsions">Neonatal Convulsions</option>
<option value="Baby of Diabetic mother">Baby of Diabetic mother</option>
<option value="Oliguria">Oliguria</option>
<option value="Abdominal Distension">Abdominal Distension</option>
<option value="Hypothermia < 35.4 Ç">Hypothermia < 35.4 Ç</option>
<option value="Hypothermia < 37.5 Ç">Hypothermia < 37.5 Ç</option>
<option value="Hypoglycermia < 45 mg%">Hypoglycermia < 45 mg%</option>
<option value="Shock : Cold Periphery with CFT > 3 sec & Weak Fast Pulse">Shock : Cold Periphery with CFT > 3 sec & Weak Fast Pulse</option>
<option value="Meconium Aspiration">Meconium Aspiration</option>
<option value="Bleeding">Bleeding</option>
<option value="Diarrhoea">Diarrhoea</option>
<option value="Major Congenital Malformation">Major Congenital Malformation</option>
<option value="Unconsciousness">Unconsciousness</option>
<option value="Any Other">Any Other</option>
</select>
<script>
<%
if(!indicationC.equals("")){
%>
document.getElementById('indicationC').value = '<%=indicationC.trim()%>';

<%}%>
</script>

<label>Indication D</label>
<select  name="indicationD" id="indicationD">
<option value="">Select</option>
<option value="Prernaturity<34 weeks">Prernaturity<34 weeks</option>
<option value="Low Birth Weight <1800 gm">Low Birth Weight <1800 gm</option>
<option value="Perinatal Asphyxia">Perinatal Asphyxia</option>
<option value="Neonatal Jaundice">Neonatal Jaundice</option>
<option value="Resp. Distress(Rate >60 or Grunt / Retractions)">Resp. Distress(Rate >60 or Grunt / Retractions)</option>
<option value="Large Baby(>4 Kg. at 40 weeks)">Large Baby(>4 Kg. at 40 weeks)</option>
<option value="Refusal to Feed">Refusal to Feed</option>
<option value="Central Cyanosis">Central Cyanosis</option>
<option value="Apnea / Gasping">Apnea / Gasping</option>
<option value="Neonatal Convulsions">Neonatal Convulsions</option>
<option value="Baby of Diabetic mother">Baby of Diabetic mother</option>
<option value="Oliguria">Oliguria</option>
<option value="Abdominal Distension">Abdominal Distension</option>
<option value="Hypothermia < 35.4 Ç">Hypothermia < 35.4 Ç</option>
<option value="Hypothermia < 37.5 Ç">Hypothermia < 37.5 Ç</option>
<option value="Hypoglycermia < 45 mg%">Hypoglycermia < 45 mg%</option>
<option value="Shock : Cold Periphery with CFT > 3 sec & Weak Fast Pulse">Shock : Cold Periphery with CFT > 3 sec & Weak Fast Pulse</option>
<option value="Meconium Aspiration">Meconium Aspiration</option>
<option value="Bleeding">Bleeding</option>
<option value="Diarrhoea">Diarrhoea</option>
<option value="Major Congenital Malformation">Major Congenital Malformation</option>
<option value="Unconsciousness">Unconsciousness</option>
<option value="Any Other">Any Other</option>
</select>
<script>
<%
if(!indicationD.equals("")){
%>
document.getElementById('indicationD').value = '<%=indicationD.trim()%>';

<%}%>
</script>

<div class="clear"></div>
<label>Indication E</label>
<select  name="indicationE" id="indicationE">
<option value="">Select</option>
<option value="Prernaturity<34 weeks">Prernaturity<34 weeks</option>
<option value="Low Birth Weight <1800 gm">Low Birth Weight <1800 gm</option>
<option value="Perinatal Asphyxia">Perinatal Asphyxia</option>
<option value="Neonatal Jaundice">Neonatal Jaundice</option>
<option value="Resp. Distress(Rate >60 or Grunt / Retractions)">Resp. Distress(Rate >60 or Grunt / Retractions)</option>
<option value="Large Baby(>4 Kg. at 40 weeks)">Large Baby(>4 Kg. at 40 weeks)</option>
<option value="Refusal to Feed">Refusal to Feed</option>
<option value="Central Cyanosis">Central Cyanosis</option>
<option value="Apnea / Gasping">Apnea / Gasping</option>
<option value="Neonatal Convulsions">Neonatal Convulsions</option>
<option value="Baby of Diabetic mother">Baby of Diabetic mother</option>
<option value="Oliguria">Oliguria</option>
<option value="Abdominal Distension">Abdominal Distension</option>
<option value="Hypothermia < 35.4 Ç">Hypothermia < 35.4 Ç</option>
<option value="Hypothermia < 37.5 Ç">Hypothermia < 37.5 Ç</option>
<option value="Hypoglycermia < 45 mg%">Hypoglycermia < 45 mg%</option>
<option value="Shock : Cold Periphery with CFT > 3 sec & Weak Fast Pulse">Shock : Cold Periphery with CFT > 3 sec & Weak Fast Pulse</option>
<option value="Meconium Aspiration">Meconium Aspiration</option>
<option value="Bleeding">Bleeding</option>
<option value="Diarrhoea">Diarrhoea</option>
<option value="Major Congenital Malformation">Major Congenital Malformation</option>
<option value="Unconsciousness">Unconsciousness</option>
<option value="Any Other">Any Other</option>
</select>
<script>
<%
if(!indicationE.equals("")){
%>
document.getElementById('indicationE').value = '<%=indicationE.trim()%>';

<%}%>
</script>
<div class="clear"></div>

<h4>Final Diagnosis</h4>
<label>Final Diagnosis A</label>
<select  name="finalDiagnosisA" id="finalDiagnosisA" >
<option value="">Select</option>
<option value="ELBW (999 gm or less) : P.07.0">ELBW (999 gm or less) : P.07.0</option>
<option value="Other LBW (1000 gm -2499 gm : P.07.1)">Other LBW (1000 gm -2499 gm : P.07.1)</option>
<option value="Extreme Immaturity(<28 Weeks) : P.07.2">Extreme Immaturity(<28 Weeks) : P.07.2</option>
<option value="Prematunty(28<37 Weeks) : P.07.3">Prematunty(28<37 Weeks) : P.07.3</option>
<option value="Small for Gastational Age(IUGR) : P.05.1">Small for Gastational Age(IUGR) : P.05.1</option>
<option value="Neonatal Aspiration of Meconium : P.24.0">Neonatal Aspiration of Meconium : P.24.0</option>
<option value="RDS of Newborn(HMD): P.22.0">RDS of Newborn(HMD): P.22.0</option>
<option value="Transient Tachypnoea of Newborn: P.22.1">Transient Tachypnoea of Newborn: P.22.1</option>
<option value="Pneumothorax : P.21.0">Pneumothorax : P.21.0</option>
<option value="Congenital Pneumonia : P.25.1">Congenital Pneumonia : P.25.1</option>
<option value="Acquired Pneumonia : J.15">Acquired Pneumonia : J.15</option>
<option value="Primary Sleep Apnoea of Newborn : P28.3">Primary Sleep Apnoea of Newborn : P28.3</option>
<option value="Birth Asphyxia : P.21.0">Birth Asphyxia : P.21.0</option>
<option value="HIE of Newborn : P:91.6">HIE of Newborn : P:91.6</option>
<option value="Neonatal Sepsis : P.36.9">Neonatal Sepsis : P.36.9</option>
<option value="Meningitis : G:00">Meningitis : G:00</option>
<option value="Convulsions of Newborn :P.90">Convulsions of Newborn :P.90</option>
<option value="Hemolytic Disease of Newtork : P55">Hemolytic Disease of Newtork : P55</option>
<option value="Neonatal Jaur : P.59">Neonatal Jaur : P.59</option>
<option value="Actute Rental Failure : N.17">Actute Rental Failure : N.17</option>
<option value="Neonatal Carddiac Failure : P.29.0">Neonatal Carddiac Failure : P.29.0</option>
<option value="Shock : R.57">Shock : R.57</option>
<option value="DIC : P.60">DIC : P.60</option>
<option value="Intraventricular Hemorrhage : P.53.3">DIC : P.60</option>
<option value="Neonatal Diarrhoea : A.09">Neonatal Diarrhoea : A.09</option>
<option value="Tetanus Neonatorum : A.33">Tetanus Neonatorum : A.33</option>
<option value="Hypothermia of Nwborn : P.80">Hypothermia of Nwborn : P.80</option>
<option value="Environmental Hypertherrnia of Newborn : P.81.0">Environmental Hypertherrnia of Newborn : P.81.0</option>
<option value="Neonatal Hypoglycaernia : P.70.4">Neonatal Hypoglycaernia : P.70.4</option>
<option value="Congenital Malformation">Congenital Malformation</option>
<option value="Any Other">Any Other</option>
</select>
<script>
<%
if(!finalDiagnosisA.equals("")){
%>
document.getElementById('finalDiagnosisA').value = '<%=finalDiagnosisA%>';
<%}%>

</script>
<label>Final Diagnosis B</label>
<select  name="finalDiagnosisB" id="finalDiagnosisB">
<option value="">Select</option>
<option value="ELBW (999 gm or less) : P.07.0">ELBW (999 gm or less) : P.07.0</option>
<option value="Other LBW (1000 gm -2499 gm : P.07.1)">Other LBW (1000 gm -2499 gm : P.07.1)</option>
<option value="Extreme Immaturity(<28 Weeks) : P.07.2">Extreme Immaturity(<28 Weeks) : P.07.2</option>
<option value="Prematunty(28<37 Weeks) : P.07.3">Prematunty(28<37 Weeks) : P.07.3</option>
<option value="Small for Gastational Age(IUGR) : P.05.1">Small for Gastational Age(IUGR) : P.05.1</option>
<option value="Neonatal Aspiration of Meconium : P.24.0">Neonatal Aspiration of Meconium : P.24.0</option>
<option value="RDS of Newborn(HMD): P.22.0">RDS of Newborn(HMD): P.22.0</option>
<option value="Transient Tachypnoea of Newborn: P.22.1">Transient Tachypnoea of Newborn: P.22.1</option>
<option value="Pneumothorax : P.21.0">Pneumothorax : P.21.0</option>
<option value="Congenital Pneumonia : P.25.1">Congenital Pneumonia : P.25.1</option>
<option value="Acquired Pneumonia : J.15">Acquired Pneumonia : J.15</option>
<option value="Primary Sleep Apnoea of Newborn : P28.3">Primary Sleep Apnoea of Newborn : P28.3</option>
<option value="Birth Asphyxia : P.21.0">Birth Asphyxia : P.21.0</option>
<option value="HIE of Newborn : P:91.6">HIE of Newborn : P:91.6</option>
<option value="Neonatal Sepsis : P.36.9">Neonatal Sepsis : P.36.9</option>
<option value="Meningitis : G:00">Meningitis : G:00</option>
<option value="Convulsions of Newborn :P.90">Convulsions of Newborn :P.90</option>
<option value="Hemolytic Disease of Newtork : P55">Hemolytic Disease of Newtork : P55</option>
<option value="Neonatal Jaur : P.59">Neonatal Jaur : P.59</option>
<option value="Actute Rental Failure : N.17">Actute Rental Failure : N.17</option>
<option value="Neonatal Carddiac Failure : P.29.0">Neonatal Carddiac Failure : P.29.0</option>
<option value="Shock : R.57">Shock : R.57</option>
<option value="DIC : P.60">DIC : P.60</option>
<option value="Intraventricular Hemorrhage : P.53.3">DIC : P.60</option>
<option value="Neonatal Diarrhoea : A.09">Neonatal Diarrhoea : A.09</option>
<option value="Tetanus Neonatorum : A.33">Tetanus Neonatorum : A.33</option>
<option value="Hypothermia of Nwborn : P.80">Hypothermia of Nwborn : P.80</option>
<option value="Environmental Hypertherrnia of Newborn : P.81.0">Environmental Hypertherrnia of Newborn : P.81.0</option>
<option value="Neonatal Hypoglycaernia : P.70.4">Neonatal Hypoglycaernia : P.70.4</option>
<option value="Congenital Malformation">Congenital Malformation</option>
<option value="Any Other">Any Other</option>
</select>
<script>
<%
if(!finalDiagnosisB.equals("")){
%>
document.getElementById('finalDiagnosisB').value = '<%=finalDiagnosisB%>';

<%}%>

</script>
<div class="clear"></div>

<label>Final Diagnosis C</label>
<select  id="finalDiagnosisC" name="finalDiagnosisC">
<option value="">Select</option>
<option value="ELBW (999 gm or less) : P.07.0">ELBW (999 gm or less) : P.07.0</option>
<option value="Other LBW (1000 gm -2499 gm : P.07.1)">Other LBW (1000 gm -2499 gm : P.07.1)</option>
<option value="Extreme Immaturity(<28 Weeks) : P.07.2">Extreme Immaturity(<28 Weeks) : P.07.2</option>
<option value="Prematunty(28<37 Weeks) : P.07.3">Prematunty(28<37 Weeks) : P.07.3</option>
<option value="Small for Gastational Age(IUGR) : P.05.1">Small for Gastational Age(IUGR) : P.05.1</option>
<option value="Neonatal Aspiration of Meconium : P.24.0">Neonatal Aspiration of Meconium : P.24.0</option>
<option value="RDS of Newborn(HMD): P.22.0">RDS of Newborn(HMD): P.22.0</option>
<option value="Transient Tachypnoea of Newborn: P.22.1">Transient Tachypnoea of Newborn: P.22.1</option>
<option value="Pneumothorax : P.21.0">Pneumothorax : P.21.0</option>
<option value="Congenital Pneumonia : P.25.1">Congenital Pneumonia : P.25.1</option>
<option value="Acquired Pneumonia : J.15">Acquired Pneumonia : J.15</option>
<option value="Primary Sleep Apnoea of Newborn : P28.3">Primary Sleep Apnoea of Newborn : P28.3</option>
<option value="Birth Asphyxia : P.21.0">Birth Asphyxia : P.21.0</option>
<option value="HIE of Newborn : P:91.6">HIE of Newborn : P:91.6</option>
<option value="Neonatal Sepsis : P.36.9">Neonatal Sepsis : P.36.9</option>
<option value="Meningitis : G:00">Meningitis : G:00</option>
<option value="Convulsions of Newborn :P.90">Convulsions of Newborn :P.90</option>
<option value="Hemolytic Disease of Newtork : P55">Hemolytic Disease of Newtork : P55</option>
<option value="Neonatal Jaur : P.59">Neonatal Jaur : P.59</option>
<option value="Actute Rental Failure : N.17">Actute Rental Failure : N.17</option>
<option value="Neonatal Carddiac Failure : P.29.0">Neonatal Carddiac Failure : P.29.0</option>
<option value="Shock : R.57">Shock : R.57</option>
<option value="DIC : P.60">DIC : P.60</option>
<option value="Intraventricular Hemorrhage : P.53.3">DIC : P.60</option>
<option value="Neonatal Diarrhoea : A.09">Neonatal Diarrhoea : A.09</option>
<option value="Tetanus Neonatorum : A.33">Tetanus Neonatorum : A.33</option>
<option value="Hypothermia of Nwborn : P.80">Hypothermia of Nwborn : P.80</option>
<option value="Environmental Hypertherrnia of Newborn : P.81.0">Environmental Hypertherrnia of Newborn : P.81.0</option>
<option value="Neonatal Hypoglycaernia : P.70.4">Neonatal Hypoglycaernia : P.70.4</option>
<option value="Congenital Malformation">Congenital Malformation</option>
<option value="Any Other">Any Other</option>
</select>
<script>
<%
if(!finalDiagnosisC.equals("")){
%>
document.getElementById('finalDiagnosisC').value = '<%=finalDiagnosisC%>';

<%}%>
</script>

<label>Final Diagnosis D</label>
<select id="finalDiagnosisD"  name="finalDiagnosisD">
<option value="">Select</option>
<option value="ELBW (999 gm or less) : P.07.0">ELBW (999 gm or less) : P.07.0</option>
<option value="Other LBW (1000 gm -2499 gm : P.07.1)">Other LBW (1000 gm -2499 gm : P.07.1)</option>
<option value="Extreme Immaturity(<28 Weeks) : P.07.2">Extreme Immaturity(<28 Weeks) : P.07.2</option>
<option value="Prematunty(28<37 Weeks) : P.07.3">Prematunty(28<37 Weeks) : P.07.3</option>
<option value="Small for Gastational Age(IUGR) : P.05.1">Small for Gastational Age(IUGR) : P.05.1</option>
<option value="Neonatal Aspiration of Meconium : P.24.0">Neonatal Aspiration of Meconium : P.24.0</option>
<option value="RDS of Newborn(HMD): P.22.0">RDS of Newborn(HMD): P.22.0</option>
<option value="Transient Tachypnoea of Newborn: P.22.1">Transient Tachypnoea of Newborn: P.22.1</option>
<option value="Pneumothorax : P.21.0">Pneumothorax : P.21.0</option>
<option value="Congenital Pneumonia : P.25.1">Congenital Pneumonia : P.25.1</option>
<option value="Acquired Pneumonia : J.15">Acquired Pneumonia : J.15</option>
<option value="Primary Sleep Apnoea of Newborn : P28.3">Primary Sleep Apnoea of Newborn : P28.3</option>
<option value="Birth Asphyxia : P.21.0">Birth Asphyxia : P.21.0</option>
<option value="HIE of Newborn : P:91.6">HIE of Newborn : P:91.6</option>
<option value="Neonatal Sepsis : P.36.9">Neonatal Sepsis : P.36.9</option>
<option value="Meningitis : G:00">Meningitis : G:00</option>
<option value="Convulsions of Newborn :P.90">Convulsions of Newborn :P.90</option>
<option value="Hemolytic Disease of Newtork : P55">Hemolytic Disease of Newtork : P55</option>
<option value="Neonatal Jaur : P.59">Neonatal Jaur : P.59</option>
<option value="Actute Rental Failure : N.17">Actute Rental Failure : N.17</option>
<option value="Neonatal Carddiac Failure : P.29.0">Neonatal Carddiac Failure : P.29.0</option>
<option value="Shock : R.57">Shock : R.57</option>
<option value="DIC : P.60">DIC : P.60</option>
<option value="Intraventricular Hemorrhage : P.53.3">DIC : P.60</option>
<option value="Neonatal Diarrhoea : A.09">Neonatal Diarrhoea : A.09</option>
<option value="Tetanus Neonatorum : A.33">Tetanus Neonatorum : A.33</option>
<option value="Hypothermia of Nwborn : P.80">Hypothermia of Nwborn : P.80</option>
<option value="Environmental Hypertherrnia of Newborn : P.81.0">Environmental Hypertherrnia of Newborn : P.81.0</option>
<option value="Neonatal Hypoglycaernia : P.70.4">Neonatal Hypoglycaernia : P.70.4</option>
<option value="Congenital Malformation">Congenital Malformation</option>
<option value="Any Other">Any Other</option>
</select>
<script>
<%
if(!finalDiagnosisD.equals("")){
%>
document.getElementById('finalDiagnosisD').value = '<%=finalDiagnosisD%>';

<%}%>

</script>
<div class="clear"></div>

<label>Final Diagnosis E</label>
<select  name="finalDiagnosisE" id="finalDiagnosisE">
<option value="">Select</option>
<option value="ELBW (999 gm or less) : P.07.0">ELBW (999 gm or less) : P.07.0</option>
<option value="Other LBW (1000 gm -2499 gm : P.07.1)">Other LBW (1000 gm -2499 gm : P.07.1)</option>
<option value="Extreme Immaturity(<28 Weeks) : P.07.2">Extreme Immaturity(<28 Weeks) : P.07.2</option>
<option value="Prematunty(28<37 Weeks) : P.07.3">Prematunty(28<37 Weeks) : P.07.3</option>
<option value="Small for Gastational Age(IUGR) : P.05.1">Small for Gastational Age(IUGR) : P.05.1</option>
<option value="Neonatal Aspiration of Meconium : P.24.0">Neonatal Aspiration of Meconium : P.24.0</option>
<option value="RDS of Newborn(HMD): P.22.0">RDS of Newborn(HMD): P.22.0</option>
<option value="Transient Tachypnoea of Newborn: P.22.1">Transient Tachypnoea of Newborn: P.22.1</option>
<option value="Pneumothorax : P.21.0">Pneumothorax : P.21.0</option>
<option value="Congenital Pneumonia : P.25.1">Congenital Pneumonia : P.25.1</option>
<option value="Acquired Pneumonia : J.15">Acquired Pneumonia : J.15</option>
<option value="Primary Sleep Apnoea of Newborn : P28.3">Primary Sleep Apnoea of Newborn : P28.3</option>
<option value="Birth Asphyxia : P.21.0">Birth Asphyxia : P.21.0</option>
<option value="HIE of Newborn : P:91.6">HIE of Newborn : P:91.6</option>
<option value="Neonatal Sepsis : P.36.9">Neonatal Sepsis : P.36.9</option>
<option value="Meningitis : G:00">Meningitis : G:00</option>
<option value="Convulsions of Newborn :P.90">Convulsions of Newborn :P.90</option>
<option value="Hemolytic Disease of Newtork : P55">Hemolytic Disease of Newtork : P55</option>
<option value="Neonatal Jaur : P.59">Neonatal Jaur : P.59</option>
<option value="Actute Rental Failure : N.17">Actute Rental Failure : N.17</option>
<option value="Neonatal Carddiac Failure : P.29.0">Neonatal Carddiac Failure : P.29.0</option>
<option value="Shock : R.57">Shock : R.57</option>
<option value="DIC : P.60">DIC : P.60</option>
<option value="Intraventricular Hemorrhage : P.53.3">DIC : P.60</option>
<option value="Neonatal Diarrhoea : A.09">Neonatal Diarrhoea : A.09</option>
<option value="Tetanus Neonatorum : A.33">Tetanus Neonatorum : A.33</option>
<option value="Hypothermia of Nwborn : P.80">Hypothermia of Nwborn : P.80</option>
<option value="Environmental Hypertherrnia of Newborn : P.81.0">Environmental Hypertherrnia of Newborn : P.81.0</option>
<option value="Neonatal Hypoglycaernia : P.70.4">Neonatal Hypoglycaernia : P.70.4</option>
<option value="Congenital Malformation">Congenital Malformation</option>
<option value="Any Other">Any Other</option>
</select>
<script>
<%
if(!finalDiagnosisE.equals("")){
%>
document.getElementById('finalDiagnosisE').value = '<%=finalDiagnosisE%>';

<%}%>
</script>
<div class="clear"></div>

<h4>Mother's information : Past History and ANC Period</h4>
<label>Mother's age</label>
<input  type="text" name="motherAge" id="motherAge" value="<%=ageOfMother %>"  maxlength="3" validate="Mother's age,int,no"  onblur="validationVal();"/>

<label>Mother's Wt.(Kgs)</label>
<input  type="text" name="motherWt" value="<%=motherWt %>"   maxlength="3" validate="Mother's Wt.(Kgs),int,no"/>
<div class="clear"></div>

<label>Age at Marriage(Yrs.)</label>
<input  type="text" name="ageOfMarriage" id="ageOfMarriage" value="<%=ageOfMarriage %>"  onblur="validationVal();" maxlength="3" validate="Age at Marriage(Yrs.),int,no"/>
<label>Consanguinity</label>
<select  name="consanguinity"  id = "consanguinity" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!consanguinity.equals("")){
%>
document.getElementById('consanguinity').value = '<%=consanguinity%>';

<%}%>

</script>
<div class="clear"></div>

<label>Birth Spacing</label>
<select  name="birthSpacing"  id = "birthSpacing" >
<option value="">Select</option>
<option value="<1 Yr"><1 Yr</option>
<option value="1-2 Yr">1-2 Yr</option>
<option value="2-3 Yr">2-3 Yr</option>
<option value=">3 Yr">>3 Yr</option>
<option value="No Applicate">No Applicate</option>
</select>
<script>
<%
if(!birthSpacing.equals("")){
%>
document.getElementById('birthSpacing').value = '<%=birthSpacing%>';

<%}%>

</script>
<label>Gravida</label>
<input  type="text" name="gravida" value="<%=gravida %>"  maxlength="20" />

<div class="clear"></div>
<label>Para</label>
<input  type="text" name="para" value="<%=para %>"  validate="Para,int,no" maxlength="8"/>

<label>Live Birth</label>
<input  type="text" name="liveBirth" value="<%=liveBirth %>"  maxlength="10" />
<div class="clear"></div>

<label>Abortion</label>
<input  type="text" name="abortion" value="<%=abortion %>"   validate="Abortion,int,no" maxlength="8" />




<label>LMP</label>
<input	type="text" id="lmpp" name="lmpp" value=""	class="date" readonly="readonly" validate="LMP,date,no"	MAXLENGTH="30" style="width:158px;"/> 
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 	onclick="javascript:setdate('',lmpp,event)" />
<div class="clear"></div>

<label>EDD</label>
<input	type="text" id="eddd" name="eddd" value=""	class="date" readonly="readonly" validate="EDD,date,no"	MAXLENGTH="30" style="width:158px;"/> 
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date,date,no"	onclick="javascript:setdate('',eddd,event)" />

<label>Gestation Weeks</label>
<input  type="text" name="gestationWeeks" value="<%=gestationWeeks %>"    maxlength="2" validate="Gestation Weeks,num,no"/>
<div class="clear"></div>

<label>Antenatal Visit's Ulcer</label>
<select  name="plantarUlcer" id="plantarUlcer" >
<option value="">Select</option>
<option value="None">None</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select>
<script>
<%
if(!plantarUlcer.equals("")){
%>
document.getElementById('plantarUlcer').value = '<%=plantarUlcer%>';

<%}%>

</script>

<label>T.T.Doses </label>
<select  name="ttDoses"  id="ttDoses" >
<option value="">Select</option>
<option value="None">None</option>
<option value="1">1</option>
<option value="2">2</option>
</select>

<script>
<%
if(!ttDoses.equals("")){
%>
document.getElementById('ttDoses').value = '<%=ttDoses%>';

<%}%>
</script>
<div class="clear"></div>

<label>Hb</label>
<input  type="text" name="hb" value="<%=hb %>"  maxlength="8"  />

<label>Blood Group</label>
<select  name="bloodGroup"  id="bloodGroup">
		<option value="">Select</option>
						<%for(MasBloodGroup masBloodGroup : bloodGroupList){
							if(bloodGroup.equals(masBloodGroup.getBloodGroupName())){
							%>
							<option value="<%=masBloodGroup.getBloodGroupName()%>" selected="selected"><%=masBloodGroup.getBloodGroupName()%></option>
						<%} else{%>
						<option value="<%=masBloodGroup.getBloodGroupName()%>"><%=masBloodGroup.getBloodGroupName()%></option>
						<%}} %>
						</select>
						
<script>
<%
if(!bloodGroup.equals("")){
%>
document.getElementById('bloodGroup').value = '<%=bloodGroup%>';

<%}%>
</script>
<div class="clear"></div>

<label>PIH</label>
<select  name="pih"  id="pih">
<option value="">Select</option>
<option value="Hypertension">Hypertension</option>
<option value="Pre Eclarnpsia">Pre Eclarnpsia</option>
<option value="Eclampsia">Eclampsia</option>
</select>
<script>
<%
if(!pih.equals("")){
%>
document.getElementById('pih').value = '<%=pih%>';

<%}%>
</script> 
 
<label>Drug</label>
<select  name="drug" id="drug" onchange="displayDrug(this.value);" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<div style="display: none" id="drugDiv">
<input  type="text"  id="drugText" name="drugText" value="<%=drugText %>"maxlength="80" style="width:175px;" />
</div>
<script>
<%
if(!drug.equals("")){
%>
document.getElementById('drug').value = '<%=drug%>';
<%
if(drug.equals("Yes")){
	%>
	document.getElementById('drugDiv').style.display='block';
<%	
}
}%>
</script>

<div class="clear"></div>
<label>Radiation</label>
<select  name="radiation"  id="radiation" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!radiation.equals("")){
%>
document.getElementById('radiation').value = '<%=radiation%>';

<%}%>

</script>

<label>Illness</label>
<select  name="illness" id="illness"  onchange="displayIllness(this.value);" >
<option value="">Select</option>
<option value="Malaria">Malaria</option>
<option value="T.B.">T.B.</option>
<option value="Jaundice">Jaundice</option>
<option value="Rash with Fever">Rash with Fever</option>
<option value="U.T.I.">U.T.I.</option>
<option value="Syphills">Syphills</option>
<option value="Other">Other</option>
</select>
<div style="display: none" id="illnessDiv">
<input  type="text" name="illnessOtherText" id="illnessOtherText" value="<%=illnessOtherText %>"   maxlength="80"  />
</div>


<script>
<%
if(!illness.equals("")){
%>
document.getElementById('illness').value = '<%=illness%>';
<%
if(illness.equals("Other"))
	{%>
	document.getElementById('illnessDiv').style.display='block';
<%	
}
}%>

</script>
<div class="clear"></div>
<label>APH</label>
<select  name="aph"  id="aph">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!aph.equals("")){
%>
document.getElementById('aph').value = '<%=aph%>';

<%}%>
</script>

<label>GDM</label>
<select  name="gdm"  id="gdm">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!gdm.equals("")){
%>
document.getElementById('gdm').value = '<%=gdm%>';

<%}%>
</script>
<div class="clear"></div>

<label>Thyroid</label>
<select  name="thyroid"  id="thyroid">
<option value="">Select</option>
<option value="Euthyroid(N)">Euthyroid(N)</option>
<option value="Hypothyroid">Hypothyroid</option>
<option value="Hyperthyroid">Hyperthyroid</option>
<option value="Not Known">Not Known</option>
</select>
<script>
<%
if(!thyroid.equals("")){
%>
document.getElementById('thyroid').value = '<%=thyroid%>';

<%}%>

</script>

<label>VDRL</label>
<select  name="vdrl"  id="vdrl">
<option value="">Select</option>
<option value="Not Done">Not Done</option>
<option value="+Ve">+Ve</option>
<option value="-Ve">-Ve</option>
</select>
<script>
<%
if(!vdrl.equals("")){
%>
document.getElementById('vdrl').value = '<%=vdrl%>';

<%}%>

</script>
<div class="clear"></div>
  <label>HbsAg</label>
  <select  name="bbsAg"  id="bbsAg" >
  <option value="">Select</option>
<option value="Not Done">Not Done</option>
<option value="+Ve">+Ve</option>
<option value="-Ve">-Ve</option>
</select>
<script>
<%
if(!bbsAg.equals("")){
%>
document.getElementById('bbsAg').value = '<%=bbsAg%>';

<%}%>

</script>
  <label>HIV Testing</label>
  <select  name="hivTesting"  id="hivTesting">
<option value="">Select</option>
<option value="Done">Done</option>
<option value="Not Done">Not Done</option></select>

<script>
<%
if(!hivTesting.equals("")){
%>
document.getElementById('hivTesting').value = '<%=hivTesting%>';

<%}%>

</script>
<div class="clear"></div>
  <label>Amniotic Fluid Volume</label>
  <select  name="amnioticFluidVolume"  id="amnioticFluidVolume">
  <option value="">Select</option>
<option value="Adequate">Adequate</option>
<option value="Polyhdraminos">Polyhdraminos</option>
<option value="Oligonyd">Oligonyd</option>
</select>

<script>
<%
if(!amnioticFluidVolume.equals("")){
%>
document.getElementById('amnioticFluidVolume').value = '<%=amnioticFluidVolume%>';

<%}%>

</script>
<div class="clear"></div>
<label class="heightAuto">Other Significant information</label>
<textarea rows="" cols="" name ="otherSignificantInformation" class="large" style="width:549px;" maxlength="256" onkeyup="return checkLength(this)"><%=otherSignificantInformation %></textarea>

<div class="clear"></div>

<h4>Mother's information : During Labour</h4>
<label>Antenatal Steroids</label>
 <select  name="antenatalSteroids" id="antenatalSteroids"  onchange="displayAntenatalSteroids(this.value);" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<div style="display: none" id="antenatalSteroidsDiv">
 <select  name="antenatalSteroidsYes"  id="antenatalSteroidsYes" style="width:165px;">
<option value="">Select</option>
<option value="Belamethasone">Belamethasone</option>
<option value="Dexamethasone">Dexamethasone</option>
</select>
</div>
<script>
<%
if(!antenatalSteroidsYes.equals("")){
%>
document.getElementById('antenatalSteroidsYes').value = '<%=antenatalSteroidsYes%>';

<%}%>

</script>
<script>
<%
if(!antenatalSteroids.equals("")){
%>
document.getElementById('antenatalSteroids').value = '<%=antenatalSteroids%>';
<%
if(antenatalSteroids.equals("Yes"))
	{%>
	document.getElementById('antenatalSteroidsDiv').style.display='block';
<%	
}
}%>
</script>

  <label>No. of doses</label>
  <select  name="noseOfDoses"  id="noseOfDoses" >
  <option value="">Select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select>
<script>
<%
if(!noseOfDoses.equals("")){
%>
document.getElementById('noseOfDoses').value = '<%=noseOfDoses%>';

<%}%>

</script>
<div class="clear"></div>
<label class="heightAuto">Time Between Last Dose & Delivery (hrs.)</label>
<input  type="text" name="timeBetweenLastDoseDelivery" value="<%=timeBetweenLastDoseDelivery %>" onBlur="IsValidTimeForSetup(this.value,this.id);"  onkeyup="mask(this.value,this,'2',':');" maxlength="5" validate="Time Between Last Dose & Delivery (hrs.),timeFormat,no"/>

<label>Days</label>
<input  type="text" name="days" value="<%=days %>" maxlength="2" validate="Days,num,no"/>

<div class="clear"></div>
  <label>H/O Fever</label>
  <select  name="hoFever"  id="hoFever">
  <option value="">Select</option>
<option value="In 1 st Trimester">In 1 st Trimester</option>
<option value="In 2 st Trimester">In 2 st Trimester</option>
<option value="In 3 st Trimester">In 3 st Trimester</option>
<option value="During Labour only if>100.4F">During Labour only if>100.4F</option>
</select>
<script>
<%
if(!hoFever.equals("")){
%>
document.getElementById('hoFever').value = '<%=hoFever%>';

<%}%>
</script>

<label>Foul Smelling Discharge</label>
<select  name="foulSmellingDischarge"  id="foulSmellingDischarge" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!foulSmellingDischarge.equals("")){
%>
document.getElementById('foulSmellingDischarge').value = '<%=foulSmellingDischarge%>';

<%}%>

</script>
<div class="clear"></div>
 <label>Uterine Tenderness</label>
  <select  name="uterineTenderness"  id="uterineTenderness" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!uterineTenderness.equals("")){
%>
document.getElementById('uterineTenderness').value = '<%=uterineTenderness%>';

<%}%>

</script>

 <label>Leaking P.V.>24 Hours</label>
  <select  name="leasking"  id="leasking" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!leasking.equals("")){
%>
document.getElementById('leasking').value = '<%=leasking%>';

<%}%>

</script>

<div class="clear"></div>
 <label>PIH</label>
  <select  name="pihLabour"  id="pihLabour">
<option value="">Select</option>
<option value="Hypertension">Hypertension</option>
<option value="Pre Eclampsia">Pre Eclampsia</option>
<option value="Eclampsia">Eclampsia</option>
</select>
<script>
<%
if(!pihLabour.equals("")){
%>
document.getElementById('pihLabour').value = '<%=pihLabour%>';

<%}%>
</script>

 <label>PPH</label>
  <select  name="pph"  id="pph">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!pph.equals("")){
%>
document.getElementById('pph').value = '<%=pph%>';

<%}%>
</script>
<div class="clear"></div>

 <label>Amniotic Fluid</label>
  <select  name="amnioticFluid"  id="amnioticFluid">
<option value="">Select</option>
<option value="Clear">Clear</option>
<option value="Blood Stained">Blood Stained</option>
<option value="Meconium Stained">Meconium Stained</option>
<option value="Foul Smelling">Foul Smelling</option>
</select>
<script>
<%
if(!amnioticFluid.equals("")){
%>
document.getElementById('amnioticFluid').value = '<%=amnioticFluid%>';

<%}%>

</script>

 <label>Presentation</label>
  <select  name="presentation"  id="presentation">
<option value="">Select</option>
<option value="Vertex">vertex</option>
<option value="Breech">breech</option>
<option value="Transverse">Transverse</option>
</select>
<script>
<%
if(!presentation.equals("")){
%>
document.getElementById('presentation').value = '<%=presentation%>';

<%}%>

</script>
<div class="clear"></div>
 <label>Labour</label>
  <select  name="labour"  id="labour">
<option value="">Select</option>
<option value="Spontaneous">Spontaneous</option>
<option value="Induced">Induced</option>
</select>
<script>
<%
if(!labour.equals("")){
%>
document.getElementById('labour').value = '<%=labour%>';

<%}%>

</script>

 <label>Course of Labour</label>
  <select  name="courseOfLabour"  id="courseOfLabour">
<option value="">Select</option>
<option value="Uneventful">Uneventful</option>
<option value="Prolonged 1st stage">Prolonged 1st stage</option>
<option value="Prolonged 2nd stage">Prolonged 2nd stage</option>
<option value="Obstructed">Obstructed</option>
</select>
<script>
<%
if(courseOfLabour != null && !courseOfLabour.equals("")){
%>
document.getElementById('courseOfLabour').value = '<%=courseOfLabour%>';

<%}%>

</script>
<div class="clear"></div>
 <label>E/O Feotal Distress</label>
  <select  name="eoFeotalDistress" id="eoFeotalDistress" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>

</select>
<script>
<%
if(!eoFeotalDistress.equals("")){
%>
document.getElementById('eoFeotalDistress').value = '<%=eoFeotalDistress%>';

<%}%>

</script>

 <label>Type of Delivery</label>
  <select  name="typeOfDelivery"  id="typeOfDelivery">
<option value="">Select</option>
<option value="LSCS">LSCS</option>
<option value="AVD">AVD</option>
<option value="NVD">NVD</option>
</select>
<script>
<%
if(!typeOfDelivery.equals("")){
%>
document.getElementById('typeOfDelivery').value = '<%=typeOfDelivery%>';

<%}%>
</script>
<div class="clear"></div>
 <label class="heightAuto">Indication for Caesarean, Applicable</label>
  <select  name="indicationForCaesareanApplicable" id="indicationForCaesareanApplicable"  onchange="displayIndicationForCaesareanApplicable(this.value);" >
<option value="">Select</option>
<option value="Cephalo Pelvic Disproportion">Uneventful</option>
<option value="Malpresentation">Malpresentation</option>
<option value="Placental Previa">Placental Previa</option>
<option value="Obstructed Labour">Obstructed Labour</option>
<option value="Foetal Distress">Foetal Distress</option>
<option value="Prolonged Labour">Prolonged Labour</option>
<option value="Cord Prolapse">Cord Prolapse</option>
<option value="Failed Induction(Dystocia)">Failed Induction(Dystocia)</option>
<option value="Previous LSCS">Previous LSCS</option>
<option value="Other">Other</option>
</select>
<script>
<%
if(!indicationForCaesareanApplicable.equals("")){
%>
document.getElementById('indicationForCaesareanApplicable').value = '<%=indicationForCaesareanApplicable%>';
<%
if(indicationForCaesareanApplicable.equals("Other"))
	{%>
	document.getElementById('indicationForCaesareanApplicableDiv').style.display='block';
<%	
}
}%>

</script>
<div style="display: none" id="indicationForCaesareanApplicableDiv">
<input  type="text" id="indicationForCaesareanApplicableOtherText" name="indicationForCaesareanApplicableOtherText" value="<%=indicationForCaesareanApplicableOtherText %>"    />
</div>

 <label>Delivery Attended by</label>
 <select  name="deliveryAttendedBy"  id="deliveryAttendedBy" onchange="displayDeliveryAttendedBy(this.value);">
<option value="">Select</option>
<option value="Doctor">Doctor</option>
<option value="Nurse">Nurse</option>
<option value="ANM">ANM</option>
<option value="Dai">Dai</option>
<option value="Other">Other</option>

</select>
<div style="display: none" id="deliveryAttendedByDiv">
<input  type="text" id="deliveryAttendedByOtherText" name="deliveryAttendedByOtherText" value="<%=deliveryAttendedByOtherText %>"    maxlength="80" />
</div>
<script>
<%
if(!deliveryAttendedBy.equals("")){
%>
document.getElementById('deliveryAttendedBy').value = '<%=deliveryAttendedBy%>';
<%
if(deliveryAttendedBy.equals("Other"))
	{%>
	document.getElementById('deliveryAttendedByDiv').style.display='block';
<%	
}
}%>

</script>

<div class="clear"></div>
<label class="heightAuto">Other Significant information</label>
<textarea rows="" cols="" name ="otherSignificantInformationLabour" class="large" style="width:549px;"  maxlength="256" onkeyup="return checkLength(this)"><%=otherSignificantInformationLabour %></textarea>

<div class="clear"></div>
<h4>Baby's information : At Birth</h4>
<label>Cried Immed after Birth</label>
<select name="criedImmedAfterBirth" id="criedImmedAfterBirth">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!criedImmedAfterBirth.equals("")){
%>
document.getElementById('criedImmedAfterBirth').value = '<%=criedImmedAfterBirth%>';

<%}%>

</script>
<label>Wt. of Birth</label>
<input type="text" value="<%=bwt%>"  name="bwt"  validate="Wt. of Birth,float,no"  maxlength="5">

<div class="clear"></div>
<label class="heightAuto">Gestational age (in completed weeks)</label>
<input type="text" name="gestationalAge" value="<%=gestationalAge%>"  validate="Gestational age(in completed weeks),num,no" maxlength="2">

<label>Maturity</label>
<select name="maturity" id="maturity">
<option value="">Select</option>
<option value="Proform(<37Wk)">Proform(<37Wk)</option>
<option value="Full term">Full term</option>
<option value="Post term(>42Wk)">Post term(>42Wk)</option>
</select>
<script>
<%
if(!maturity.equals("")){
%>
document.getElementById('maturity').value = '<%=maturity%>';

<%}%>

</script>
<div class="clear"></div>
<label>APGAR at 1 min</label>
<input type="text" name="apgarAtOneMin" value="<%=apgarAtOneMin%>" maxlength="5">

<label>APGAR at 5 min</label>
<input type="text" name="apgarAtFiveMin"  value="<%=apgarAtFiveMin%>" maxlength="5">
<div class="clear"></div>

<label>Resuscitation Required</label>
<select name="resuscitationRequired" id="resuscitationRequired">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!resuscitationRequired.equals("")){
%>
document.getElementById('resuscitationRequired').value = '<%=resuscitationRequired%>';

<%}%>

</script>
<label>Vitamin K Given</label>
<select name="vitaminKGiven" id="vitaminKGiven">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!vitaminKGiven.equals("")){
%>
document.getElementById('vitaminKGiven').value = '<%=vitaminKGiven%>';

<%}%>

</script>
<div class="clear"></div>

<label>Breast Fed Within 1 Hour</label>
<select name="breastFed" id="breastFed">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!breastFed.equals("")){
%>
document.getElementById('breastFed').value = '<%=breastFed%>';

<%}%>

</script>
<div class="clear"></div>

<h4> Baby's information : On Admission</h4>
<label>Presenting Complaints</label>
<textarea rows="" cols="" name="presentingComplaints" class="large" style="width:545px"  maxlength="256" onkeyup="return checkLength(this)"><%=presentingComplaints %></textarea>

<div class="clear"></div>
<h4>General Examination</h4>
<label>General Condition</label>
<select name="generalCondition" id="generalCondition">
<option value="">Select</option>
<option value="Alert">Alert</option>
<option value="Lethargic">Lethargic</option>
<option value="Comatose">Comatose</option>
</select>
<script>
<%
if(!generalCondition.equals("")){
%>
document.getElementById('generalCondition').value = '<%=generalCondition%>';

<%}%>

</script>
<label>Apnea</label>
<select name="apnea" id="apnea">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!apnea.equals("")){
%>
document.getElementById('apnea').value = '<%=apnea%>';

<%}%>
</script>
<div class="clear"></div>

<label>Grunting</label>
<select name="grunting" id="grunting">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!grunting.equals("")){
%>
document.getElementById('grunting').value = '<%=grunting%>';

<%}%>
</script>
<label>Chest Indrawing</label>
<select name="chestInDrawing" id="chestInDrawing">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<script>
<%
if(!chestInDrawing.equals("")){
%>
document.getElementById('chestInDrawing').value = '<%=chestInDrawing%>';

<%}%>
</script>
<div class="clear"></div>

<label>Head Circumference(c.m.)</label>
<input type="text" name="headCircumference" value="<%=headCircumference%>" validate="Head Circumference(c.m.),int,no" maxlength="3">

<label>Length(c.m.)</label>
<input type="text" name="length" value="<%=length%>" validate="length,int,no" maxlength="3">
<div class="clear"></div>

<label>Color</label>
<select name="color" id="color">
<option value="">Select</option>
<option value="Pink">Pink</option>
<option value="Pale">Pale</option>
<option value="Central Cyanosis">Central Cyanosis</option>
<option value="Peripheral Cyanosis">Central Cyanosis</option>
</select>
<script>
<%
if(!color.equals("")){
%>
document.getElementById('color').value = '<%=color%>';

<%}%>
</script>

<label>CRT > 3 Sec</label>
<select name="crt" id="crt">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!crt.equals("")){
%>
document.getElementById('crt').value = '<%=crt%>';

<%}%>

</script>
<div class="clear"></div>

<label>Skin pinch >2 secs</label>
<select name="skinPinch" id="skinPinch">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!skinPinch.equals("")){
%>
document.getElementById('skinPinch').value = '<%=skinPinch%>';

<%}%>
</script>

<label>Meconium Stained Cord</label>
<select name="meconiumStainedCord" id="meconiumStainedCord">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!meconiumStainedCord.equals("")){
%>
document.getElementById('meconiumStainedCord').value = '<%=meconiumStainedCord%>';

<%}%>

</script>
<div class="clear"></div>

<label>Tone</label>
<select name="tone" id="tone">
<option value="">Select</option>
<option value="Limp">Limp</option>
<option value="Active">Active</option>
<option value="Increase Tone">Increase Tone</option>
</select>
<script>
<%
if(!tone.equals("")){
%>
document.getElementById('tone').value = '<%=tone%>';

<%}%>

</script>

<label>Convulsions</label>
<select name="convulsions" id="convulsions">
<option value="">Select</option>
<option value="Present on Admission">Present on Admission</option>
<option value="Past History">Past History</option>
<option value="No">No</option>
</select>
<script>
<%
if(!convulsions.equals("")){
%>
document.getElementById('convulsions').value = '<%=convulsions%>';

<%}%>

</script>
<div class="clear"></div>
<label>Jaundice</label>
<select name="jaundice" id="jaundice" onchange="displayJaundice(this.value);" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!jaundice.equals("")){
%>
document.getElementById('jaundice').value = '<%=jaundice%>';

<%
if(jaundice.equals("Yes"))
	{%>
	document.getElementById('jaundiceDiv').style.display='block';
<%	
}
}%>

</script>

<div style="display: none" id="jaundiceDiv">
<label>Extent</label>
 <select  name="jaundiceYes" id="jaundiceYes" >
<option value="">Select</option>
<option value="Face">Face</option>
<option value="Chest">Chest</option>
<option value="Abdomen">Abdomen</option>
<option value="Legs">Legs</option>
<option value="Palms">Palms</option>
<option value="Soles">Soles</option>
</select>
</div>
<script>
<%
if(!jaundiceYes.equals("")){
%>
document.getElementById('jaundiceYes').value = '<%=jaundiceYes%>';

<%}%>

</script>
<div class="clear"></div>
<label>Bleeding</label>
<select name="bleeding"  id="bleeding" onchange="displayBleeding(this.value);" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>


<script>
<%
if(!bleeding.equals("")){
%>
document.getElementById('bleeding').value = '<%=bleeding%>';
<%
if(bleeding.equals("Yes"))
	{%>
		document.getElementById('bleedingDiv').style.display='block';
<%	}
}%>

</script>
<div style="display: none" id="bleedingDiv">
<label>Specify Site</label>
 <select  name="bleedingYes" id="bleedingYes" >
<option value="">Select</option>
<option value="Skin">Skin</option>
<option value="Mouth">Mouth</option>
<option value="Rectal">Rectal</option>
<option value="Umbilicus">Umbilicus</option>
</select>
</div>
<script>
<%
if(!bleedingYes.equals("")){
%>
document.getElementById('bleedingYes').value = '<%=bleedingYes%>';

<%}%>

</script>
<div class="clear"></div>

<label>Bulging Anterior Fontanel</label>
<select name="bulgingAnteriorFontanel" id="bulgingAnteriorFontanel">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!bulgingAnteriorFontanel.equals("")){
%>
document.getElementById('bulgingAnteriorFontanel').value = '<%=bulgingAnteriorFontanel%>';

<%}%>

</script>

<label>Taking Breast Feeds</label>
<select name="takingBreastFeeds" id="takingBreastFeeds" >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!takingBreastFeeds.equals("")){
%>
document.getElementById('takingBreastFeeds').value = '<%=takingBreastFeeds%>';

<%}%>

</script>
<div class="clear"></div>

<label>Sucking </label>
<select name="sucking" id="sucking">
<option value="">Select</option>
<option value="Good">Good</option>
<option value="Poor">Poor</option>
<option value="No Suckiing">No Suckiing</option>

</select>
<script>
<%
if(!sucking.equals("")){
%>
document.getElementById('sucking').value = '<%=sucking%>';

<%}%>

</script>

<label>Attachment</label>
<select name="attachment" id="attachment">
<option value="">Select</option>
<option value="Well attached">Well attached</option>
<option value="Poorly attached">Poorly attached</option>
<option value="No attached">No attached</option>
</select>
<script>
<%
if(!attachment.equals("")){
%>
document.getElementById('attachment').value = '<%=attachment%>';

<%}%>

</script>
<div class="clear"></div>

<label>Umbilious</label>
<select name="umbilious" id="umbilious">
<option value="">Select</option>
<option value="Red">Red</option>
<option value="Discharge">Discharge</option>
<option value="Normal">Normal</option>
</select>
<script>
<%
if(!umbilious.equals("")){
%>
document.getElementById('umbilious').value = '<%=umbilious%>';

<%}%>

</script>

<label>Skin Pustules</label>
<select name="skinPustules" id="skinPustules">
<option value="">Select</option>
<option value="No">No</option>
<option value="Yesless10">Yes<10</option>
<option value="Yes>=10">Yes>=10</option>
<option value="Abscess">Abscess</option>
</select>
<script>
<%
if(!skinPustules.equals("")){
%>
document.getElementById('skinPustules').value = '<%=skinPustules%>';

<%}%>
</script>
<div class="clear"></div>

<label>Congenital Malformation</label>
<select name="congenitalMalformation" id="congenitalMalformation"  >
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<script>
<%
if(!congenitalMalformation.equals("")){
%>
document.getElementById('congenitalMalformation').value = '<%=congenitalMalformation%>';
<%	
}%>
</script>
<select id="congenitalMalformationAnother" name="congenitalMalformationAnother"   onchange="displayCongenitalMalformation(this.value);" >
<option value="">Select</option>
<option value="Diaphragmatic Hemia">Diaphragmatic Hemia</option>
<option value="Hydrocephalus">Hydrocephalus</option>
<option value="M.M.C.">M.M.C.</option>
<option value="Imperforate Anus">Imperforate Anus</option>
<option value="T.O. Fistula">T.O. Fistula</option>
<option value="Cong. Heart Diease">Cong. Heart Diease</option>
<option value="Cleft Palate">Cleft Palate</option>
<option value="Cleft Lip">Cleft Lip</option>
<option value="Cleft Palate with Cleft Lip">Cleft Palate with Cleft Lip</option>
<option value="Cong. Deformity of Hip">Cong. Deformity of Hip</option>
<option value="Cong. Deformity of Feet">Cong. Deformity of Feet</option>
<option value="Other">Other</option>

</select>

<script>
<%
if(!congenitalMalformationAnother.equals("")){
%>
document.getElementById('congenitalMalformationAnother').value = '<%=congenitalMalformationAnother%>';

<%
if(congenitalMalformationAnother.equals("Other"))
	{%>
	document.getElementById('congenitalMalformationAnotherDiv').style.display='block';
<%	}
}%>
</script>

<div style="display: none" id="congenitalMalformationAnotherDiv">
<input  type="text" name="congenitalMalformationAnotherOtherText" value="<%=congenitalMalformationAnotherOtherText %>"    />
</div>

<div class="clear"></div>
<label>Blood Sugar</label>
<input type="text" name="bloodSugar" value="<%=bloodSugar%>"  maxlength="40">

<label>Oxygen Saturation</label>
<input type="text" name="oxygenSaturation" value="<%=oxygenSaturation%>" maxlength="40">

<div class="clear"></div>
<label class="heightAuto">Other Significant information</label>
<textarea rows="" cols="" name ="otherSignificantInformationGeneral" class="large" style="width:549px;" maxlength="256" onkeyup="return checkLength(this)"><%=otherSignificantInformationGeneral %></textarea>

<div class="clear"></div>
<h4>Systemic Examination</h4>

<label>CVS</label>
<textarea rows="" cols="" name ="cvs" class="large" style="width:549px"  maxlength="256" onkeyup="return checkLength(this)"><%=cvs %></textarea>

<div class="clear"></div>
<label>Respiratory</label>
<textarea rows="" cols="" name ="respiratory" class="large" style="width:549px"  maxlength="256" onkeyup="return checkLength(this)"><%=respiratory %></textarea>
<div class="clear"></div>

<label>Per Abdomen</label>
<textarea rows="" cols="" name ="perAbdomen" class="large" style="width:549px"  maxlength="256" onkeyup="return checkLength(this)"><%=perAbdomen %></textarea>

<div class="clear"></div>
<label>CNS</label>
<textarea rows="" cols="" name ="cns" class="large" style="width:549px"  maxlength="256" onkeyup="return checkLength(this)"><%=cns %></textarea>

<div class="clear"></div>
<label>Other Significant Finding</label>
<textarea rows="" cols="" name ="otherSignificantFinding"  class="large" style="width:549px"  maxlength="256" onkeyup="return checkLength(this)"><%=otherSignificantFinding %></textarea>
<div class="clear"></div>
</div>
<script>
function validationVal()
{
	
	alert("hi")
var motherAge = document.getElementById("motherAge").value;
var ageOfMarriage = document.getElementById("ageOfMarriage").value;
if(ageOfMarriage>=motherAge)
	{
		alert("Please Age at Marriage is not greater and equal to Mother's age");
		return false;
	
	}
	
return true;
}

</script>

</form>


