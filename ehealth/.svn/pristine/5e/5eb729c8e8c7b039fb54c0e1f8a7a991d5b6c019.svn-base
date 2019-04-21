<%@page import="jkt.hms.masters.business.MlcMaterialObjects"%>
<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script>
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
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript">

function tearsText(){	
if(document.getElementById("tears").value=='Present'){
	document.getElementById("tearsDiv").style.display="inline";
}else{
	document.getElementById("tearsDiv").style.display="none";
}
	
}
	
	
</script>
<%
Map<String,Object> map = new HashMap<String,Object>();


List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
if(request.getAttribute("map")!=null){
	map=(Map<String ,Object>)request.getAttribute("map");
}
if(map.get("mlcList")!=null){
	mlcList=(List<OpdPatientDetails>)map.get("mlcList");
}
List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
if(map.get("patientHistories")!=null){
	patientHistories=(List<OpdPatientHistory>)map.get("patientHistories");
}
List<MedicoLegalDetails> meDetails = new ArrayList<MedicoLegalDetails>();
if(map.get("details")!=null){
	meDetails=(List<MedicoLegalDetails>)map.get("details");
}
List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
if(map.get("patientWiseMlcs")!=null){
	patientWiseMlcs=(List<PatientWiseMlc>)map.get("patientWiseMlcs");
}

List<PatientAddress> patientAddress = new ArrayList<PatientAddress>();
if(map.get("patientAddress")!=null){
	patientAddress=(List<PatientAddress>)map.get("patientAddress");
}
String orderNo = "";
if(map.get("orderNo") != null){
	orderNo = (String)map.get("orderNo");
}
List<MlcMaterialObjects> materialObjectsList = new ArrayList<MlcMaterialObjects>();
if(map.get("materialObjectsList")!=null){
	materialObjectsList=(List<MlcMaterialObjects>)map.get("materialObjectsList");
}



String hinNo="";
String name="";
String age="";
String gender="";
String address="";
int detailId=0;
int hinId=0;
String couInj="";

//-----------
String srNo="";
String examinDate="";
String exaTime="";
String idMark1="";
String idMark2="";
String policeSt="";
String witt1="";
String witt2="";
String  dieases="";
String  reqForm="";


int addiTion=0;
String  opNion="";

String histInj="";
int mediCoId=0;
String boughtBy="";
String boughtAddress="";
String injDetail="";
String  his="";
String  crimeNo="";
String  cosen="";
String sexUalDev="";
int height=0;
int weight=0;
int heightOpd=0;
int weightOpd=0;
String otherHistory="";
String injBody="";
String byName="";
String byAddress="" ;
Date actDate=new Date();
String  actTime="";
String placeAct="";
String pain="";
Date sexualactLast=new Date();
Date last_menstrual_date=new Date();
int no_of_pregnancies=0;
String type_of_delivery="";
String build="";
String sec_sexual_char="";
String appearance_of_labia="";
String  labia="";
String fourchette="";
String fourDetail="";
String  posterior_commissure="";
String  posteriorDetail="";
String penis="";
String injury_on_body="";
String sys_examination_findings="";
String inner_thigh_regions_pereneum="";
String rectal_exam_speculum="";
int inpationId=0;
String examinationPlace="";
String  reqTime="";
String reqDate="";
String  stamBy="";
String  detInj="";
String agemarry="";
int pulse=0;
String bp ="";
String recDate="";
String refDate="";
String recTime="";
String examCommTime="";
String examCommDate="";
String clinicalHistory="";
String reflexes="";
String developmentOfTestis="";
String maritalHistory="";
String whetherHavingChildren="";
String hair="";
String disease ="";
String diseasePresent="";
String skin  ="";
String smegmaDeposits=""; 
String sensations ="";
String urethralDischarge=""; 
String scrotum ="";
String rightTestis ="";
String leftTestis="";
int plength=0;
String examinTime="";
int circumference=0;

String changedClothing="";
String bathed="";
String washed="";
String vomiting="";
String bleeding="";
String consciousness="";
String mentalCondition="";
String clothes="";
String gait="";
String lips="";
String anusAnalMucosa="";
String tears="";
String tearsPresent="";
String depressionOfAnus="";
String hemorrhoids="";
String bimanualLateral="";
String stains="";
String analSphincter="";
String sphincterTone="";
String evidenceOfSTD="";
String rectal="";
String inner="";
String injuriesOnTheBody="";
String sysExaminationFindings="";
for(MedicoLegalDetails legalDetails:meDetails){
	  mediCoId=legalDetails.getId();
	  srNo= legalDetails.getSerialNo()!=null ? legalDetails.getSerialNo():"";
	  crimeNo=legalDetails.getCrimeNo()!=null ?legalDetails.getCrimeNo():"";
	  examinDate=legalDetails.getExaminationDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getExaminationDate())  :"";
	  examinTime=legalDetails.getExaminationTime()!=null ?legalDetails.getExaminationTime() :"";
	  plength=legalDetails.getPlength()!=null ?legalDetails.getPlength() :0;
	  circumference=legalDetails.getCircumference()!=null ?legalDetails.getCircumference() :0;
	  addiTion=legalDetails.getNoOfAdditionalSheets()!=null ? legalDetails.getNoOfAdditionalSheets():0;
	  idMark1=legalDetails.getIdMark1()!=null ?legalDetails.getIdMark1() :"";
	  idMark2=legalDetails.getIdMark2()!=null ?legalDetails.getIdMark2() :"";
	  policeSt=legalDetails.getPoliceStation()!=null ?legalDetails.getPoliceStation():"";
	  witt1= legalDetails.getWitnesses1()!=null ?legalDetails.getWitnesses1():"";
	  witt2= legalDetails.getWitnesses2()!=null ?legalDetails.getWitnesses2():"";
	  dieases=legalDetails.getTestisDiseaseInjury()!=null ?legalDetails.getTestisDiseaseInjury():"";
	  reqForm=legalDetails.getRequisitionFrom()!=null ?legalDetails.getRequisitionFrom():"";
	  cosen=legalDetails.getConsent()!=null ?legalDetails.getConsent():"";
	   bp=legalDetails.getBp()!=null ?legalDetails.getBp():"";
	  opNion=legalDetails.getOpinion()!=null ?legalDetails.getOpinion():"";
//	  pulse=legalDetails.getPulse()!=0 ?legalDetails.getPulse():0;
	  boughtBy=legalDetails.getBroughtBy()!=null?legalDetails.getBroughtBy():"";
	  boughtAddress=legalDetails.getBroughtByAddress()!=null?legalDetails.getBroughtByAddress():"";
	  histInj=legalDetails.getHistoryByInjured()!=null?legalDetails.getHistoryByInjured():"";
	  injDetail=legalDetails.getInjuryDetails()!=null?legalDetails.getInjuryDetails():"";
	  his=legalDetails.getPhysicalExamination()!=null?legalDetails.getPhysicalExamination():"";
	  sexUalDev=legalDetails.getHistorySexualDev()!=null?legalDetails.getHistorySexualDev():"";
	  agemarry=legalDetails.getAgeOfMarriage()!=null?legalDetails.getAgeOfMarriage():"";
	  if(legalDetails.getHeight()!=null){
	  height=legalDetails.getHeight();
	  }
	  if(legalDetails.getWeight()!=null){
	   weight=legalDetails.getWeight();
	  }
	   otherHistory=legalDetails.getOtherHistory()!=null?legalDetails.getOtherHistory():"";
	   injBody=legalDetails.getInjuryOnBody()!=null?legalDetails.getInjuryOnBody():"";
	byName=legalDetails.getAccompByName()!=null?legalDetails.getAccompByName():"";
	byAddress=legalDetails.getAccompByAddress()!=null?legalDetails.getAccompByAddress():"";
  reqTime=legalDetails.getRequisitionTime()!=null?legalDetails.getRequisitionTime():"";
  if(legalDetails.getRequisitionDate()!=null){
    reqDate=legalDetails.getRequisitionDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRequisitionDate())  :"";
   }
  if(legalDetails.getReceivedDate()!=null){

	  recDate=legalDetails.getReceivedDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getReceivedDate())  :"";
  }
  recTime=legalDetails.getReceivedTime()!=null?legalDetails.getReceivedTime():"";
  if(legalDetails.getRefDate()!=null){
  	 
  	 refDate=legalDetails.getRefDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRefDate())  :"";
  	    }
  
  examCommTime=legalDetails.getExamCommTime()!=null?legalDetails.getExamCommTime():"";
  examCommDate=legalDetails.getExamCommDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getExamCommDate())  :"";
  clinicalHistory=legalDetails.getHistoryOfIllness()!=null ? legalDetails.getHistoryOfIllness():"";
  reflexes=legalDetails.getReflexes()!=null ? legalDetails.getReflexes():"";
  developmentOfTestis=legalDetails.getDevelopmentTestis()!=null ? legalDetails.getDevelopmentTestis():"";
  maritalHistory=legalDetails.getMaritalHistory()!=null ? legalDetails.getMaritalHistory():"";
  whetherHavingChildren=legalDetails.getChildren()!=null ? legalDetails.getChildren():"";
  build=legalDetails.getBuild()!=null ? legalDetails.getBuild():"";
  		hair=legalDetails.getHair()!=null ? legalDetails.getHair():"";
  		penis =legalDetails.getPenis()!=null ? legalDetails.getPenis():"";
  		 disease =legalDetails.getDiseaseInjury()!=null ? legalDetails.getDiseaseInjury():"";
  		 diseasePresent =legalDetails.getInjuryDetails()!=null ? legalDetails.getInjuryDetails():"";
  		 skin  =legalDetails.getSkin()!=null ? legalDetails.getSkin():"";
  		 
  		 smegmaDeposits=legalDetails.getSmegmaDeposits()!=null ? legalDetails.getSmegmaDeposits():""; 
  		 sensations =legalDetails.getSensation()!=null ? legalDetails.getSensation():"";
  		 urethralDischarge=legalDetails.getDischargeTenderness()!=null ? legalDetails.getDischargeTenderness():""; 
  		 	 rightTestis =legalDetails.getRightTestis()!=null ? legalDetails.getRightTestis():"";
  		 leftTestis=legalDetails.getLeftTestis()!=null ? legalDetails.getLeftTestis():"";
  		examinationPlace=legalDetails.getExaminationPlace()!=null ? legalDetails.getExaminationPlace():"";
  		changedClothing=legalDetails.getChangedClothing()!=null ? legalDetails.getChangedClothing():"";
  		bathed=legalDetails.getBathed()!=null ? legalDetails.getBathed():"";
  		washed=legalDetails.getMouthWashed()!=null ? legalDetails.getMouthWashed():"";
  		vomiting=legalDetails.getVomiting()!=null ? legalDetails.getVomiting():"";
  		pain=legalDetails.getPain()!=null ? legalDetails.getPain():"";
  		bleeding=legalDetails.getBleedingFromAnus()!=null ? legalDetails.getBleedingFromAnus():"";
  		consciousness=legalDetails.getLossOfConsciousness()!=null ? legalDetails.getLossOfConsciousness():"";
  		build=legalDetails.getBuild()!=null ? legalDetails.getBuild():"";
  		mentalCondition=legalDetails.getMentalCondition()!=null ? legalDetails.getMentalCondition():"";
  		clothes=legalDetails.getClothes()!=null ? legalDetails.getClothes():"";
  		gait=legalDetails.getGait()!=null ? legalDetails.getGait():"";
  		lips=legalDetails.getLipsOralCavity()!=null ? legalDetails.getLipsOralCavity():"";
  				anusAnalMucosa=legalDetails.getAnalMucosa()!=null ? legalDetails.getAnalMucosa():"";
  				tears=legalDetails.getTears()!=null ? legalDetails.getTears():"";
  				tearsPresent=legalDetails.getTearsDetails()!=null ? legalDetails.getTearsDetails():"";
  				depressionOfAnus=legalDetails.getDepressionAnus()!=null ? legalDetails.getDepressionAnus():"";
  						hemorrhoids=legalDetails.getHemorrhoids()!=null ? legalDetails.getHemorrhoids():"";
  						bimanualLateral=legalDetails.getBimanualLateral()!=null ? legalDetails.getBimanualLateral():"";
  						stains=legalDetails.getStainsBloodSemenLub()!=null ? legalDetails.getStainsBloodSemenLub():"";
  						analSphincter=legalDetails.getAnalSphincter()!=null ? legalDetails.getAnalSphincter():"";
  						sphincterTone=legalDetails.getSphincterTone()!=null ? legalDetails.getSphincterTone():"";
  						evidenceOfSTD=legalDetails.getEvidenceStd()!=null ? legalDetails.getEvidenceStd():"";
  						rectal=legalDetails.getRectalExamSpeculum()!=null ? legalDetails.getRectalExamSpeculum():"";
  								inner=legalDetails.getInnerThighRegionsPereneum()!=null ? legalDetails.getInnerThighRegionsPereneum():"";
  								penis=legalDetails.getPenis()!=null ? legalDetails.getPenis():"";
  								scrotum=legalDetails.getScrotum()!=null ? legalDetails.getScrotum():"";
  										injuriesOnTheBody=legalDetails.getInjuryOnBody()!=null ? legalDetails.getInjuryOnBody():"";
  										sysExaminationFindings=legalDetails.getSysExaminationFindings()!=null ? legalDetails.getSysExaminationFindings():"";
} 

for(PatientWiseMlc mlc:patientWiseMlcs){
	
	  
	  if(mlc.getHin()!=null){
	hinNo=mlc.getHin().getHinNo();
	  }else if(mlc.getInpatient()!=null){
		  hinNo=mlc.getInpatient().getHinNo();
	   }
	  
	  if(mlc.getHin()!=null){
		  name=mlc.getHin().getFullName();
	}else if(mlc.getInpatient()!=null){
		name=mlc.getInpatient().getHin().getFullName();
	 }
	  
	  if(mlc.getHin()!=null && mlc.getHin().getAge()!=null){
		  age=mlc.getHin().getAge();
	}else if(mlc.getInpatient()!=null && mlc.getInpatient().getHin().getAge()!=null){
		age=mlc.getInpatient().getHin().getAge();
	 }
	  
	  if(mlc.getHin()!=null){
		  gender=mlc.getHin().getSex().getAdministrativeSexName();
	}else if(mlc.getInpatient()!=null){
		gender=mlc.getInpatient().getHin().getSex().getAdministrativeSexName();
	 }
	
	
	  if(mlc.getHin()!=null){
		  hinId=mlc.getHin().getId();
	}else if(mlc.getInpatient()!=null){
		hinId=mlc.getInpatient().getHin().getId();
	 }
		
	  if(mlc.getInpatient()!=null){
		  inpationId=mlc.getInpatient().getId();
	}
	  if(mlc.getOpdPatientDetail()!=null){
			  detailId=mlc.getOpdPatientDetail().getId();
			  if(mlc.getOpdPatientDetail().getHeight()!=null){
				  heightOpd=mlc.getOpdPatientDetail().getHeight();
			  }
			 if(mlc.getOpdPatientDetail().getWeight()!=null){
		weightOpd=mlc.getOpdPatientDetail().getWeight();
			  }
		}
	  
	 	 if(mlc.getOpdPatientDetail()!=null && mlc.getOpdPatientDetail().getEmployee()!=null){
			  reqForm=mlc.getOpdPatientDetail().getEmployee().getFirstName();
			  if(mlc.getOpdPatientDetail().getEmployee().getMiddleName()!=null)
			  {
				  reqForm=reqForm+" "+mlc.getOpdPatientDetail().getEmployee().getMiddleName();
			  }
			  if(mlc.getOpdPatientDetail().getEmployee().getLastName()!=null)
			  {
				  reqForm=reqForm+" "+mlc.getOpdPatientDetail().getEmployee().getLastName();
			  }
	  	 }
} 
for(OpdPatientHistory history:patientHistories){
	  couInj= history.getPresentComplaintHistory(); 
}



for(PatientAddress pa:patientAddress){
	
		  if(pa.getDistrict()!=null){
			  address= pa.getDistrict().getDistrictName();  
		  }
		  if(pa.getWardName()!=null){
			  address=address+" , "+ pa.getWardName();  
		  }
		  if(pa.getHouseNo()!=null){
			  address=address+"  , "+pa.getHouseNo();  
		  }
		  if(pa.getLsgHouseNo()!=null){
			  address=address+"  , "+pa.getLsgHouseNo();  
		  }
		  if(pa.getLsgName()!=null){
			  address=address+"  , "+pa.getLsgName().getLsgTypeName();  
		  }
		  if(pa.getPostOffice()!=null){
			  address=address+"  , "+pa.getPostOffice().getPostCodeName();  
		  }
		  if(pa.getPinCode()!=null){
			  address=address+" ,  "+pa.getPostOffice().getPinCode();  
		  }
}

if(address==null){
	address="";
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
%>
<form name="mlc" method="post" action="">
<div class="titleBg">

</div>
<div class="Block">
<label><span>*</span> UHID</label>
<!-- <input name="uhinId" id="uhinId" validate="UHID,string,yes"  onblur="patientList(this.value,'mlc','Victim Unnatural');"> -->
<input name="uhinId" id="uhinId" validate="UHID,string,yes"  readonly="readonly" value="<%= hinNo%>">  
   <input type="hidden" name="mediCoId" id="mediCoId"  value="<%= mediCoId%>">
</div>
<div class="titleBg">
<h2>EXAMINATION OF A VICTIM OF UNNATURAL SEXUAL OFFENCE</h2>
</div>
<div class="Block">
<div class="clear"></div>
	
<label>Ref. ML No.<span>*<span></label>

 <%if(mediCoId!=0){%>
<input type="text"   id="refMLNo" name="refMLNo" validate="Ref No,String,yes" maxlength="16" value="<%= srNo%>" readonly="readonly"  />
 <%}else{ %>
 <input type="text"   id="refMLNo" name="refMLNo" validate="Ref No,String,yes" maxlength="16" value="<%= orderNo%>" readonly="readonly"  />
 <%}%>


<label>Ref. ML Date</label>

<input type="text" id="refMLDate" name="refMLDate" validate="Ref. ML Date,date,no" value="<%=refDate %>" class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />



<div class="clear"></div>
	<label>Name</label>
	<input type="text"  readonly="readonly" value="<%= name%>" />
    
    
    <label>Address</label>
	<input type="text"  readonly="readonly" value="<%=address %>"  name="address"/>
    
    <label>Age</label>
    <input type="text"  id="age"  name="name" readonly="readonly" value="<%= age%>"/>
	
	 <input type="hidden"  id="gender"  name="gender" readonly="readonly"/>
	 <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
      <input type="hidden"  name="hinId"   value="<%= hinId%>"/>
     <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
    
<div class="clear"></div>
<label>Requisition  From <span>*</span></label>
<textarea  id="requisitionFrom" name="requisitionFrom" class="textareaMediua" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1"><%= reqForm%></textarea>
  
<label>Crime No.</label>
<input type="text"   id="crimeNo" name="crimeNo" maxlength="16" value="<%= crimeNo%>"/>

<label>Police station</label>
<textarea  id="policeStation" name="policeStation" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"><%= policeSt%></textarea>
<div class="clear"></div>
    
<label>Accompanied by (Name)</label>
<input type="text"   id="accompaniedByName" name="accompaniedByName" maxlength="96" value ="<%= byName%>"/>

<label>Accompanied by(Address)</label>
<textarea  id="accompaniedByAddress" name="accompaniedByAddress" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1"><%= byAddress%></textarea>

<label>Consent</label>
<textarea id="consent" name="consent" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%= cosen%></textarea>

<div class="clear"></div>
<label>Comm. of exam Date</label>
<input type="text" id="commencementOfExaminationDate" name="commencementOfExaminationDate" value="<%=examCommDate %>" validate="Commencement of examination DateDate,date,no"  class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.commencementOfExaminationDate,true);" />

<label>Comm. of exam Time</label>
<input type="text"   id="commencementOfExaminationTime" name="commencementOfExaminationTime" value="<%=examCommTime %>" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>


 <label>Place of examination</label>
 <textarea  id="placeExamination" name="placeExamination" class="textareaMediua"  maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"><%=examinationPlace %></textarea>

<div class="clear"></div>

 <label>Id Mark 1</label>
 <textarea  id="identificationOne" name="identificationOne" class="textareaMediua"  maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1"><%= idMark1%></textarea>
 
  
 <label>Id Mark 2</label>
 <textarea  id="identificationTwo" name="identificationTwo" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%= idMark2%></textarea>
 
 <h4>History related to the incident</h4>
 
  <label>History of incident</label>
  <textarea  id="statedBySubject" name="statedBySubject" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=histInj %></textarea>

<label>Changed clothing </label>
  <select name="changedClothing" id="changedClothing" >
  <%if(changedClothing.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(changedClothing.equalsIgnoreCase("Yes")){ %>
  <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(changedClothing.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No" selected="selected">No</option>
  <option value="NA">NA</option>
  <%}if(changedClothing.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA" selected="selected">NA</option>
  <%} %>
  </select>
  

<label>Bathed the incident</label>
  <select name="bathed" id="bathed" >
  <%if(bathed.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(bathed.equalsIgnoreCase("Yes")){ %>
  <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(bathed.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No" selected="selected">No</option>
  <option value="NA">NA</option>
  <%}if(bathed.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA" selected="selected">NA</option>
  <%} %>
  </select>
<div class="clear"></div>

<label>Pain</label>
  <select name="pain" id="pain" >
  <%if(pain.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(pain.equalsIgnoreCase("Yes")){ %>
  <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(pain.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No" selected="selected">No</option>
  <option value="NA">NA</option>
  <%}if(pain.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA" selected="selected">NA</option>
  <%} %>
  </select>
  
    <label>Any history of vomiting </label>
  <select name="vomiting" id="vomiting" >
  <%if(vomiting.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(vomiting.equalsIgnoreCase("Yes")){ %>
  <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(vomiting.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No" selected="selected">No</option>
  <option value="NA">NA</option>
  <%}if(vomiting.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA" selected="selected">NA</option>
  <%} %>
  </select>
  
     <label>History bleeding from anus</label>
  <select name="bleeding" id="bleeding" >
   <%if(bleeding.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(bleeding.equalsIgnoreCase("Yes")){ %>
  <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(bleeding.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No" selected="selected">No</option>
  <option value="NA">NA</option>
  <%}if(bleeding.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA" selected="selected">NA</option>
  <%} %>
  </select>
  
<div class="clear"></div>
<label class="auto">Whether washed mouth / had any food or drinks / urinated / defecated since the incident</label>
  <select name="washed" id="washed" >
  <%if(washed.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(washed.equalsIgnoreCase("Yes")){ %>
  <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(washed.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No" selected="selected">No</option>
  <option value="NA">NA</option>
  <%}if(washed.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA" selected="selected">NA</option>
  <%} %>
  </select>

<div class="clear"></div>

  <label class="auto">Loss of consciousness during / after the incident</label>
  <select name="consciousness" id="consciousness" >
  <%if(consciousness.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(consciousness.equalsIgnoreCase("Yes")){ %>
  <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(consciousness.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No" selected="selected">No</option>
  <option value="NA">NA</option>
  <%}if(consciousness.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA" selected="selected">NA</option>
  <%} %>
  </select>
<div class="clear"></div>
  
<div class="clear"></div>

<h2>Physical examination</h2>
  <h4>General</h4>
  <label>Height </label>
  <%if(mediCoId!=0){ %>
  <input type="text" name="height" validate="Height,int,no" maxlength="3" value="<%=height%>">
  <%}else{ %>
<input type="text" name="height" validate="Height,int,no" maxlength="3" value="<%=heightOpd%>">
<%} %>
  <label>Weight </label>
  <%if(mediCoId!=0){ %>
   <input type="text" name="weight" validate="Weight,int,no" maxlength="3" value="<%= weight%>">
<%}else{ %>
<input type="text" name="weight" validate="Weight,int,no" maxlength="3" value="<%= weightOpd%>">
<%} %>
  <label>Build</label>
    <select name="build" id="build"  >
  
  <%if(build.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Good">Good</option>
  <option value="Moderate">Moderate</option>
  <option value="Poor">Poor</option>
  
  <%}else if(build.equalsIgnoreCase("Good")){ %>
  <option value="">Select</option>
  <option value="Good" selected="selected">Good</option>
  <option value="Moderate">Moderate</option>
  <option value="Poor">Poor</option>
  
  <%}else if(build.equalsIgnoreCase("Moderate")){ %>
    <option value="">Select</option>
  <option value="Good">Good</option>
  <option value="Moderate" selected="selected">Moderate</option>
  <option value="Poor">Poor</option>
    
  <%}else if(build.equalsIgnoreCase("Poor")){ %>
  <option value="">Select</option>
  <option value="Good">Good</option>
  <option value="Moderate">Moderate</option>
  <option value="Poor" selected="selected">Poor</option>
  
  <%} %>
  </select>
  <div class="clear"></div>
  
  <label>Gait</label>
  <select name="gait">
    	
  <%if(gait.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Painful">Painful</option>
  <option value="Not">Not</option>
  <option value="Torn">Torn</option>
  <option value="NA">NA</option>
    <%}else if(gait.equalsIgnoreCase("Painful")){ %>
  <option value="">Select</option>
  <option value="Painful" selected="selected">Painful</option>
  <option value="Not">Not</option>
  <option value="Torn">Torn</option>
  <option value="NA">NA</option>
  
  <%}else if(gait.equalsIgnoreCase("Not")){ %>
  <option value="">Select</option>
  <option value="Painful">Painful</option>
  <option value="Not" selected="selected">Not</option>
  <option value="Torn">Torn</option>
  <option value="NA">NA</option>

  <%}else if(gait.equalsIgnoreCase("Torn")){ %>
    <option value="">Select</option>
  <option value="Painful">Painful</option>
  <option value="Not">Not</option>
  <option value="Torn" selected="selected">Torn</option>
  <option value="NA">NA</option>
  
  <%}else if(gait.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Painful">Painful</option>
  <option value="Not">Not</option>
  <option value="Torn">Torn</option>
  <option value="NA" selected="selected">NA</option>
  
  
  <%} %>
  
  
  </select>
  <label>Mental disposition</label>
  <select name="mentalCondition">
   <%if(mentalCondition.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Excited">Excited</option>
  <option value="Calm">Calm</option>
  <option value="Depressed">Depressed</option>
<%}if(mentalCondition.equalsIgnoreCase("Excited")){ %>
    <option value="">Select</option>
  <option value="Excited" selected="selected">Excited</option>
  <option value="Calm">Calm</option>
  <option value="Depressed">Depressed</option>
  <%}if(mentalCondition.equalsIgnoreCase("Calm")){ %>
      <option value="">Select</option>
  <option value="Excited">Excited</option>
  <option value="Calm" selected="selected">Calm</option>
  <option value="Depressed">Depressed</option>
  <%}if(mentalCondition.equalsIgnoreCase("Depressed")){ %>
      <option value="">Select</option>
  <option value="Excited">Excited</option>
  <option value="Calm">Calm</option>
  <option value="Depressed" selected="selected">Depressed</option>
  <%} %>
  </select>
  
    <label>Clothes</label>
  <select name="clothes">
   <%if(clothes.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Disordered">Disordered</option>
  <option value="Torn">Torn</option>
   <option value="NA">NA</option>
    <%}if(clothes.equalsIgnoreCase("Intact")){ %>
   <option value="">Select</option>
  <option value="Intact" selected="selected">Intact</option>
  <option value="Disordered">Disordered</option>
  <option value="Torn">Torn</option>
   <option value="NA">NA</option>
   
    <%}if(clothes.equalsIgnoreCase("Disordered")){ %>
   <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Disordered" selected="selected">Disordered</option>
  <option value="Torn">Torn</option>
   <option value="NA">NA</option>
   
    <%}if(clothes.equalsIgnoreCase("Torn")){ %>
   <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Disordered">Disordered</option>
  <option value="Torn" selected="selected">Torn</option>
   <option value="NA">NA</option>
    <%}if(clothes.equalsIgnoreCase("NA")){ %>
   <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Disordered">Disordered</option>
  <option value="Torn">Torn</option>
   <option value="NA" selected="selected">NA</option>
   <%} %>
  </select>
   
  <div class="clear"></div>
  <h4>Local</h4>
  
  <div class="clear"></div>  
  <label>Lips and oral cavity</label>
  
   <input type="text" name="lips" maxlength="30"  value="<%=lips%>">
  
  <label>Anus Anal mucosa</label>
    <select name="anusAnalMucosa" id="anusAnalMucosa"  >
 
   <%if(anusAnalMucosa.equalsIgnoreCase("")){ %>
   <option value="">Select</option>
  <option value="Smooth">Smooth</option>
  <option value="Thickened">Thickened</option>
  <option value="Other">Other</option>
    <%}if(anusAnalMucosa.equalsIgnoreCase("Smooth")){ %>
  <option value="">Select</option>
  <option value="Smooth" selected="selected">Smooth</option>
  <option value="Thickened">Thickened</option>
  <option value="Other">Other</option>
  
    <%}if(anusAnalMucosa.equalsIgnoreCase("Thickened")){ %>
  
  <option value="">Select</option>
  <option value="Smooth">Smooth</option>
  <option value="Thickened" selected="selected">Thickened</option>
  <option value="Other">Other</option>
    
    <%}if(anusAnalMucosa.equalsIgnoreCase("Other")){ %>
  
  <option value="">Select</option>
  <option value="Smooth">Smooth</option>
  <option value="Thickened">Thickened</option>
  <option value="Other" selected="selected">Other</option>
  <%} %>
  </select>
     <div class="clear"></div>
       <label>Tears</label>
    <select name="tears" id="tears"  onchange="tearsText();" >
  
   <%if(tears.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present">Not present</option>
    <%}if(tears.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Not present">Not present</option>
  
    <%}if(tears.equalsIgnoreCase("Not present")){ %>
  
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present" selected="selected">Not present</option>
  <%} %>
  </select>
   
   <div id="tearsDiv" style="display: none">
 <select  id="tearsPresent" name="tearsPresent">
 <%if(tearsPresent.equalsIgnoreCase("")){ %>
 <option value="Recent">Recent</option>
  <option value="old">old</option>
 <%}if(tearsPresent.equalsIgnoreCase("Recent")){ %>
  <option value="Recent" selected="selected">Recent</option>
  <option value="old">old</option>
  <%}if(tearsPresent.equalsIgnoreCase("old")){ %>
  <option value="Recent">Recent</option>
  <option value="old" selected="selected">old</option>
  <%} %>
  </select>
    </div>
    
    
    <script>
  	<%if(tears.equalsIgnoreCase("Present")){%>
		document.getElementById("tearsDiv").style.display="inline";
	<%}else{%>
		document.getElementById('tearsPresent').value=""; 
		document.getElementById("tearsDiv").style.display="none";
	<%}%>
  </script>
    
      <div class="clear"></div>
       <label>Depression of anus</label>
    <select name="depressionOfAnus" id="depressionOfAnus">
    <%if(depressionOfAnus.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present">Not present</option>
    <%}if(depressionOfAnus.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Not present">Not present</option>
      <%}if(depressionOfAnus.equalsIgnoreCase("Not present")){ %>
    <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present" selected="selected">Not present</option>
  <%} %>
  </select>
  
<label>Hemorrhoids</label>
    <select name="hemorrhoids" id="hemorrhoids">
   <%if(hemorrhoids.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present">Not present</option>
    <%}if(hemorrhoids.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Not present">Not present</option>
      <%}if(hemorrhoids.equalsIgnoreCase("Not present")){ %>
    <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present" selected="selected">Not present</option>
  <%} %>
  
  </select>
        <label>Anal sphincter</label>
    <select name="analSphincter" id="analSphincter">
  <%if(analSphincter.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Patulous">Patulous</option>
  <option value="Non patulous">Non patulous</option>
   <%}if(analSphincter.equalsIgnoreCase("Patulous")){ %>
  <option value="">Select</option>
  <option value="Patulous" selected="selected">Patulous</option>
  <option value="Non patulous">Non patulous</option>
   <%}if(analSphincter.equalsIgnoreCase("Non patulous")){ %>
  <option value="">Select</option>
  <option value="Patulous">Patulous</option>
  <option value="Non patulous" selected="selected">Non patulous</option>
  
  <%} %>
  </select>
 <div class="clear"></div>
 <label>Sphincter tone</label>
    <select name="sphincterTone" id="sphincterTone">
     <%if(sphincterTone.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Retained">Retained</option>
  <option value="Lost">Lost</option>
   <%}if(sphincterTone.equalsIgnoreCase("Retained")){ %>
  <option value="">Select</option>
  <option value="Retained" selected="selected">Retained</option>
  <option value="Lost">Lost</option>
   <%}if(sphincterTone.equalsIgnoreCase("Lost")){ %>
  <option value="">Select</option>
  <option value="Retained">Retained</option>
  <option value="Lost" selected="selected">Lost</option>
  <%} %>
  </select>
  
  
<label>Evidence of STD</label>
    <select name="evidenceOfSTD" id="evidenceOfSTD">
     <%if(evidenceOfSTD.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present">Not present</option>
    <%}if(evidenceOfSTD.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Not present">Not present</option>
      <%}if(evidenceOfSTD.equalsIgnoreCase("Not present")){ %>
  
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present" selected="selected">Not present</option>
  <%} %>
  </select>
<label>On bimanual lateral traction, anal</label>
    <select name="bimanualLateral" id="bimanualLateral">
       <%if(bimanualLateral.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Closes">Closes</option>
  <option value="Opens">Opens</option>
     <%}if(bimanualLateral.equalsIgnoreCase("Closes")){ %>
     
     <option value="">Select</option>
  <option value="Closes" selected="selected">Closes</option>
  <option value="Opens">Opens</option>
 
     
        <%}if(bimanualLateral.equalsIgnoreCase("Opens")){ %>
        <option value="">Select</option>
  <option value="Closes">Closes</option>
  <option value="Opens" selected="selected">Opens</option>
 
        <%} %>
  </select>
  <div class="clear"></div> 
<label>Rectal exam with speculum</label>
<textarea id="rectal" name="rectal" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=rectal%></textarea>
  
  <label>Penis</label>
  <input type="text" name="penis" value="<%= penis%>" >
  <label> Scrotum</label>
  <input type="text" name="scrotum" value="<%= scrotum%>">
  <div class="clear"></div>
  
  <label>Injuries on the body </label>
  <textarea rows="" cols="" name="injuriesOnTheBody" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=injuriesOnTheBody%></textarea>
  

 <label>Systemic examination</label>
<textarea rows="" cols="" name="systemicExaminationFindings" maxlength="50"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=sysExaminationFindings%></textarea>
 <label>Stains of blood/Semen/Lubricants</label>
 <select name="stains" id="stains" >
    <%if(stains.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present">Not present</option>
    <%}if(stains.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Not present">Not present</option>
  
    <%}if(stains.equalsIgnoreCase("Not present")){ %>
  
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present" selected="selected">Not present</option>
  <%} %>
  </select>
  
 <div class="clear"></div>
  <label>Inner thigh regions & pereneum</label>
    <textarea rows="" cols="" name="inner" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=inner%></textarea>   
</div>
<div class="Block">
<table width="600" cellspacing="0" cellpadding="0" border="0" style="width:500px; float:left; margin-left:5px; border:1px solid #c0c0c0;">
<tr>
<th>Select</th>
    <th>Material objects preserved</th>
  </tr>
    <%int inc = 1;%>
 
  
 <tr>  <td><input type="checkbox" name="slNo1" id="slNo1" value="y"></td>
    <td><input type="hidden" name="materialObjects1" id="aa" class="radioCheckCol2" value="Buccal smears and swabs">
    Buccal smears and swabs
    </td>
  </tr>
  <tr>
         <td><input type="checkbox" name="slNo2" id="slNo2" value="y"></td>
    <td><input type="hidden" name="materialObjects2" id="aa" class="radioCheckCol2" value="Anal swabs and smears">
    Anal swabs and smears
    </td>
  </tr>
  <tr>
         <td><input type="checkbox" name="slNo3" id="slNo3" value="y"></td>
    <td><input type="hidden" name="materialObjects3" id="aa" class="radioCheckCol2" value="Swab from skin of thighs">
    Swab from skin of thighs</td>
  </tr>
 <tr>
         <td><input type="checkbox" name="slNo4" id="slNo4" value="y"></td>
    <td><input type="hidden" name="materialObjects4" id="aa" class="radioCheckCol2" value="Nail clippings">Nail clippings</td>
  </tr>
  <tr>
         <td><input type="checkbox" name="slNo5" id="slNo5" value="y"></td>
    <td><input type="hidden" name="materialObjects5" id="aa" class="radioCheckCol2" value="Loose hair from anal region & buttocks">Loose hair from anal region & buttocks</td>
  </tr>
  <tr>
        <td><input type="checkbox" name="slNo6" id="slNo6" value="y"></td> 
    <td><input type="hidden" name="materialObjects6" id="aa" class="radioCheckCol2" value="Pubic hairs (cut) sample">Pubic hairs (cut) sample</td>
  </tr>
  <tr>
         <td><input type="checkbox" name="slNo7" id="slNo7" value="y" class="auto"></td>
    <td><input type="hidden" name="materialObjects7" id="aa" class="radioCheckCol2" value="Blood & Urine to look for sedatives/hypnotics">
    Blood & Urine to look for sedatives/hypnotics
    </td>
  </tr>
  <tr>
         <td><input type="checkbox" name="slNo8" id="slNo8" value="y"></td>
    <td><input type="hidden" name="materialObjects8" id="aa" class="radioCheckCol2" value="Clothes">Clothes</td>
  </tr>
  <tr>
         <td><input type="checkbox" name="slNo9" id="slNo9" value="y"></td>
    <td><input type="hidden" name="materialObjects9" id="aa" class="radioCheckCol2" value="Swabs from suspected stains on the body parts.Others if any">Swabs from suspected stains on the body parts.Others if any</td>
  </tr>
  <tr>
         <td><input type="checkbox" name="slNo10" id="slNo10" value="y"></td>
    <td><input type="hidden" name="materialObjects10" id="aa" class="radioCheckCol2" value="If not preserved, reasons">If not preserved, reasons</td>
  </tr>
  
</table>
<input type="hidden" name="hdb" id="hdb"    value="<%=10 %>" />
<div class="clear" style="margin:10px 0px"></div>
<label>OPINION</label>
<textarea  id="opinion" name="opinion" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1"><%=opNion%></textarea>

<div class="clear"></div>
<div id="edited"></div>

 <% if(meDetails.size()==0) {%>
 <input type="button" name="add" id="addbutton" value="Submit" 	class="button"	onClick="submitForm('mlc','mlc?method=addExamOfVictimOfUnnaturalSexualOffence&flag=submit');"	accesskey="a" tabindex=1 />
 <% }else{ %>
 <input type="button" name="add" id="addbutton" value="Authorization" 	class="button"	onClick="submitForm('mlc','mlc?method=addExamOfVictimOfUnnaturalSexualOffence&flag=authorization');"	accesskey="a" tabindex=1 />
 <%} %> 
</div>

<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>
<label>Changed Date:</label> 
<label	class="value"><%=currentDate%></label>
 <label>Changed Time:</label>
 <label	class="value"><%=time%></label>

<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<script>
<%
if(materialObjectsList.size()>0) {
	 for(MlcMaterialObjects materialObjects :materialObjectsList){

%>

<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Buccal smears and swabs")){ %>

document.getElementById('slNo1').checked = true;

<%} %>

<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Anal swabs and smears")){ %>
document.getElementById('slNo2').checked = true;

<%} %>

<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Swab from skin of thighs")){ %>
document.getElementById('slNo3').checked = true;
<%} %>

<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Nail clippings")){ %>
document.getElementById('slNo4').checked = true;
<%} %>
<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Loose hair from anal region & buttocks")){ %>
document.getElementById('slNo5').checked = true;
<%} %>
<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Pubic hairs (cut) sample")){ %>
document.getElementById('slNo6').checked = true;
<%} %>


<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Blood & Urine to look for sedatives/hypnotics")){ %>
document.getElementById('slNo7').checked = true;
<%} %>


<% if(materialObjects.getMaterialObjects().equalsIgnoreCase("Clothes")) {%>
document.getElementById('slNo8').checked = true;
<%} %>

<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Swabs from suspected stains on the body parts.Others if any")){ %>
document.getElementById('slNo9').checked = true;
<%} %>


<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("If not preserved, reasons")){ %>
document.getElementById('slNo10').checked = true;
<%} %>
 	
 	<%}}%>

</script>