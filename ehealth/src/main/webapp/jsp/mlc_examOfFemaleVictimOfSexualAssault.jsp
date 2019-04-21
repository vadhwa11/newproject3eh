<%@page import="jkt.hms.masters.business.MlcMaterialObjects"%>
<%@page import="sun.security.x509.FreshestCRLExtension"%>
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

function resistanceOfferedText(){	
if(document.getElementById("resistanceOffered").value=='No'){
	document.getElementById("resistanceOfferedDiv").style.display="inline";
}else{
	document.getElementById("resistanceOfferedDiv").style.display="none";
}
	
}
	
function hairText(){	
	if(document.getElementById("hair").value=='Other'){
		document.getElementById("hairDiv").style.display="inline";
	}else{
		document.getElementById("hairDiv").style.display="none";
	}
		
	}
	function hymenText(){	
		if(document.getElementById("hymen").value=='Other'){
			document.getElementById("hymenDiv").style.display="inline";
		}else{
			document.getElementById("hymenDiv").style.display="none";
		}
		if(document.getElementById("hymen").value=='Torn'){
			document.getElementById("hymenTornDiv").style.display="inline";
		}else{
			document.getElementById("hymenTornDiv").style.display="none";
		}
		
		}
	function dischargeText(){	
		if(document.getElementById("discharge").value=='Present'){
			document.getElementById("dischargeDiv").style.display="inline";
		}else{
			document.getElementById("dischargeDiv").style.display="none";
		}
			
	}
</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
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
List<MlcMaterialObjects> materialObjectsList = new ArrayList<MlcMaterialObjects>();
if(map.get("materialObjectsList")!=null){
	materialObjectsList=(List<MlcMaterialObjects>)map.get("materialObjectsList");
}
String orderNo = "";
if(map.get("orderNo") != null){
	orderNo = (String)map.get("orderNo");
}
String hinNo="";
String name="";
String age="";
String gender="";
String address="";
int detailId=0;
int hinId=0;
String couInj="";
String occuPation="";
//------------------
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
	  String reqFormOpd="";
	  String  reqTime="";
	  String reqDate="";
	  String  stamBy="";
	  String  detInj="";
	  int addiTion=0;
	  String  opNion="";
	  String agemarry="";
	  String histInj="";
	  int mediCoId=0;
	  String boughtBy="";
	  String boughtAddress="";
	  String injDetail="";
	 
	  String  crimeNo="";
	  String  cosen="";
	
	  int height=0;
	  int weight=0;
	  int pulse=0;
	  String bp ="";
	  String otherHistory="";
	  String injBody="";
	  String byName="";
	String byAddress="" ;
	String recTime="";
	 String actDate="";
	String  actTime="";
	String placeAct="";
    String pain="";
    String urinated="";
    String reason="";
    String frequency="";
    
    
    
    String build="";
    String appearance_of_labia="";
    String  labia="";
    String fourchette="";
    int inpationId=0;
    
    
 	  String  his="";
	  String sexUalDev="";
	String recDate="";
	String refDate="";
	String examCommTime="";
	String examCommDate="";
	String clinicalHistory="";
	String reflexes="";
	String developmentOfTestis="";
String maritalHistory="";
String educationalStatus=""; 
String whetherHavingChildren="";
String hair="";
String penis ="";
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
String examinationPlace="";


String stateOfConsciousness="";
String numberOfPerson="";
String nameOfPerson="";
String detailsOfPosition="";
String degreeOfViolence="";
String otherInformation="";
String resistanceOffered="";
String resistanceOfferedNo="";
String reasonsForDelay="";
String reasonForConclusion="";
String previousExperience="";
String    lastSexualActDate="";
	
	
String ageOfMenarche="";
String periods="";
String menstrualHistory="";
String whetherMmenstruatingNow	="";
String dateOfLastMenstrualPeriod="";
String otherRelevantHistory="";
String  whetherPregnantNow	="";
String typeOfDeliveryOtherDetails="";
int noOfPreviousPregnancies=0;

String clothes="";
String mentalCondition="";
String secondarySexual="";
String hairOther="";
String hymen="";
String hymenOther="";
String fourchetteDetails="";
String posteriorCommissure="";
String posteriorCommissureDetails	="";
String vagina="";
String rugae="";
String discharge="";
String dischargePresent="";
String injuriesVagina="";
String perineum="";
String otherAny="";
String systemicexamination="";
String injuriesOnTheBody="";
String hymenTorn="";
String fresh="";
int heightOpd=0;
int weightOpd=0;
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
    	  
    	  if(mlc.getHin()!=null){
    		  age=mlc.getHin().getAge();
    	}else if(mlc.getInpatient()!=null){
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
    		System.out.println("mlc.getOpdPatientDetail()"+detailId);
  		  detailId=mlc.getOpdPatientDetail().getId();
  		  if(mlc.getOpdPatientDetail().getHeight()!=null){
  			  heightOpd=mlc.getOpdPatientDetail().getHeight();
  		  }
  if(mlc.getOpdPatientDetail().getWeight()!=null){
  	weightOpd=mlc.getOpdPatientDetail().getWeight();
  		  }
  	}
    	  
    	 if(mlc.getOpdPatientDetail()!=null && mlc.getOpdPatientDetail().getEmployee()!=null){
    		 reqFormOpd=mlc.getOpdPatientDetail().getEmployee().getFirstName();
  		  if(mlc.getOpdPatientDetail().getEmployee().getMiddleName()!=null)
  		  {
  			reqFormOpd=reqFormOpd+" "+mlc.getOpdPatientDetail().getEmployee().getMiddleName();
  		  }
  		  if(mlc.getOpdPatientDetail().getEmployee().getLastName()!=null)
  		  {
  			reqFormOpd=reqFormOpd+" "+mlc.getOpdPatientDetail().getEmployee().getLastName();
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
 
    if(meDetails.size()>0){
	for(MedicoLegalDetails legalDetails:meDetails){
		  mediCoId=legalDetails.getId();
		  srNo= legalDetails.getSerialNo()!=null ? legalDetails.getSerialNo():"";
		  crimeNo=legalDetails.getCrimeNo()!=null ?legalDetails.getCrimeNo():"";
		  examinDate=legalDetails.getExaminationDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getExaminationDate())  :"";
		  examinTime=legalDetails.getExaminationTime()!=null ?legalDetails.getExaminationTime() :"";
		  examinationPlace=legalDetails.getExaminationPlace()!=null ? legalDetails.getExaminationPlace():"";
		  plength=legalDetails.getPlength()!=null ?legalDetails.getPlength() :0;
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
//		  pulse=legalDetails.getPulse()!=0 ?legalDetails.getPulse():0;
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
	    
	    actTime=legalDetails.getAllegedActTime()!=null?legalDetails.getAllegedActTime():"";
	    placeAct=legalDetails.getPlaceOfAct()!=null?legalDetails.getPlaceOfAct():"";
	    if(legalDetails.getAllegedActDate()!=null){
	    	 
	    	actDate=legalDetails.getAllegedActDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getAllegedActDate())  :"";
	    	    }
	    
	    
	    examCommTime=legalDetails.getExamCommTime()!=null?legalDetails.getExamCommTime():"";
	    examCommDate=legalDetails.getExamCommDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getExamCommDate())  :"";
	    clinicalHistory=legalDetails.getHistoryOfIllness()!=null ? legalDetails.getHistoryOfIllness():"";
	    reflexes=legalDetails.getReflexes()!=null ? legalDetails.getReflexes():"";
	    developmentOfTestis=legalDetails.getDevelopmentTestis()!=null ? legalDetails.getDevelopmentTestis():"";
	    maritalHistory=legalDetails.getMaritalHistory()!=null ? legalDetails.getMaritalHistory():"";
	    educationalStatus=legalDetails.getEducationalStatus()!=null ? legalDetails.getEducationalStatus():"";
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
	    		 scrotum =legalDetails.getScrotum()!=null ? legalDetails.getScrotum():"";
	    		 rightTestis =legalDetails.getRightTestis()!=null ? legalDetails.getRightTestis():"";
	    		 leftTestis=legalDetails.getLeftTestis()!=null ? legalDetails.getLeftTestis():"";
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 stateOfConsciousness=legalDetails.getConsciousnessState()!=null ? legalDetails.getConsciousnessState():"";
	    		 numberOfPerson=legalDetails.getInvolvedPersonNumber()!=null ? legalDetails.getInvolvedPersonNumber():"";;
	    		 nameOfPerson=legalDetails.getInvolvedPersonName()!=null ? legalDetails.getInvolvedPersonName():"";;
	    		 detailsOfPosition=legalDetails.getDetailsOfPosition()!=null ? legalDetails.getDetailsOfPosition():"";;
	    		 degreeOfViolence=legalDetails.getDegreeOfViolence()!=null ? legalDetails.getDegreeOfViolence():"";
	    		 pain=legalDetails.getPain()!=null ? legalDetails.getPain():"";
	    		 urinated=legalDetails.getUrinated()!=null ? legalDetails.getUrinated():"";
	    		 otherInformation=legalDetails.getAnyOtherInformation()!=null ? legalDetails.getAnyOtherInformation():"";
	    		 resistanceOffered	=legalDetails.getResistenceOffred()!=null ? legalDetails.getResistenceOffred():"";
	    		 resistanceOfferedNo=legalDetails.getReason()!=null ? legalDetails.getReason():"";
	    		 reasonsForDelay=legalDetails.getReasonDelayComplain()!=null ? legalDetails.getReasonDelayComplain():"";
	    		 reasonForConclusion=legalDetails.getReasonForConclusion()!=null ? legalDetails.getReasonForConclusion():"";
	    		 previousExperience	=legalDetails.getPreviousExp()!=null ? legalDetails.getPreviousExp():"";
	    		 frequency=legalDetails.getFrequency()!=null ? legalDetails.getFrequency():"";
					
						address=legalDetails.getPatientAddress()!=null ? legalDetails.getPatientAddress():"";
				    
					
					   if(legalDetails.getLastSexualActDate()!=null){
					    	 
						   lastSexualActDate=legalDetails.getLastSexualActDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getLastSexualActDate())  :"";
					    	    }
					
						ageOfMenarche=legalDetails.getAgeOfMenarche()!=null ? legalDetails.getAgeOfMenarche():"";
						periods=legalDetails.getPeriods()!=null ? legalDetails.getPeriods():"";
						menstrualHistory=legalDetails.getMenstrualHistory()!=null ? legalDetails.getMenstrualHistory():"";
						whetherMmenstruatingNow	=legalDetails.getMenstruatingNow()!=null ? legalDetails.getMenstruatingNow():"";
					
					
						

						   if(legalDetails.getLastMenstrualDate()!=null){
						    	 
							   dateOfLastMenstrualPeriod=legalDetails.getLastMenstrualDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getLastMenstrualDate())  :"";
						    	    }
						
						otherRelevantHistory=legalDetails.getOtherHistory()!=null ? legalDetails.getOtherHistory():"";
						whetherPregnantNow=legalDetails.getPregnant()!=null ? legalDetails.getPregnant():"";
					
						noOfPreviousPregnancies	=legalDetails.getNoOfPregnancies()!=null ? legalDetails.getNoOfPregnancies():0;
						typeOfDeliveryOtherDetails=legalDetails.getTypeOfDelivery()!=null ? legalDetails.getTypeOfDelivery():"";

						clothes=legalDetails.getClothes()!=null ? legalDetails.getClothes():"";
						mentalCondition=legalDetails.getMentalCondition()!=null ? legalDetails.getMentalCondition():"";
						secondarySexual=legalDetails.getSecSexualChar()!=null ? legalDetails.getSecSexualChar():"";
						hairOther=legalDetails.getHairOther()!=null ? legalDetails.getHairOther():"";
						appearance_of_labia=legalDetails.getAppearanceOfLabia()!=null ? legalDetails.getAppearanceOfLabia():"";
						hymen	=legalDetails.getHymen()!=null ? legalDetails.getHymen():"";
						hymenOther=legalDetails.getTornCondition()!=null ? legalDetails.getTornCondition():"";
						hymenTorn=legalDetails.getHymenTorn()!=null ? legalDetails.getHymenTorn():"";
								fresh=legalDetails.getFresh()!=null ? legalDetails.getFresh():"";
						
						fourchette=legalDetails.getFourchette()!=null ? legalDetails.getFourchette():"";
						fourchetteDetails=legalDetails.getFourchetteDetails()!=null ? legalDetails.getFourchetteDetails():"";
						posteriorCommissure=legalDetails.getPosteriorCommissure()!=null ? legalDetails.getPosteriorCommissure():"";
						posteriorCommissureDetails	=legalDetails.getPosteriorCommissureDetails()!=null ? legalDetails.getPosteriorCommissureDetails():"";
						vagina	=legalDetails.getVagina()!=null ? legalDetails.getVagina():"";
					rugae=legalDetails.getRugae()!=null ? legalDetails.getRugae():"";
					discharge=legalDetails.getDischarge()!=null ? legalDetails.getDischarge():"";
					dischargePresent=legalDetails.getDischargeDetails()!=null ? legalDetails.getDischargeDetails():"";
					injuriesVagina=	legalDetails.getInjuriesInVagina()!=null ? legalDetails.getInjuriesInVagina():"";
					perineum=legalDetails.getAppearanceOfPerineum()!=null ? legalDetails.getAppearanceOfPerineum():"";
					otherAny=legalDetails.getPhyExamOther()!=null ? legalDetails.getPhyExamOther():"";
					injuriesOnTheBody=legalDetails.getInjuryOnBody()!=null ? legalDetails.getInjuryOnBody():"";
					systemicexamination=legalDetails.getSysExaminationFindings()!=null ? legalDetails.getSysExaminationFindings():"";
} 
	
    }
	
  


Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchTitleList = (ArrayList)map.get("searchTitleList");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
%>

<form name="mlc" method="post" action="">
<div class="titleBg">
<h2>Search</h2>
</div>
<div class="Block">
<label><span>*</span> UHID</label>
<!-- <input name="uhinId" id="uhinId" validate="UHID,string,yes"  onblur="patientList(this.value,'mlc','Female Victim');"> --> 
<input name="uhinId" id="uhinId" validate="UHID,string,yes" readonly="readonly" value="<%= hinNo%>">
   <input type="hidden" name="mediCoId" id="mediCoId"  value="<%= mediCoId%>">
</div>
<div class="titleBg">
<h2>EXAMINATION OF A FEMALE VICTIM OF SEXUAL ASSAULT</h2>
</div>
<div class="Block">
<div class="clear"></div>
	
<label>Ref. ML No. <span>*<span></label>

<%if(mediCoId!=0){%>
<input type="text"   id="refMLNo" name="refMLNo" validate="RF NO,String,Yes" maxlength="16" value="<%= srNo%>" readonly="readonly"/>
 <%}else{ %>
 <input type="text"   id="refMLNo" name="refMLNo" validate="RF NO,String,Yes" maxlength="16" value="<%= orderNo%>" readonly="readonly"/>
 <%}%>
<label>Ref. ML Date</label>
<%if(mediCoId!=0){%>
<input type="text" id="refMLDate" name="refMLDate" validate="Ref. ML Date,date,no" class="date"   value="<%=refDate %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=refDate %>',document.mlc.refMLDate,true);" />
<%}else{ %>
<input type="text" id="refMLDate" name="refMLDate" validate="Ref. ML Date,date,no" class="date"   value="<%=currentDate %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />

<%} %>


	
<div class="clear"></div>
	<label>Name</label>
	<input type="text"  readonly="readonly" id="pname" name="pname" value="<%= name%>"/>
    
    
    <label>Address</label>
	<input type="text"  readonly="readonly" id="address" name="address" value="<%=address%>"/>
    
    <label>Age</label>
    <input type="text"  id="age"  name="name" readonly="readonly" value="<%= age%>"/>
	
	 <input type="hidden"  id="gender"  name="gender" readonly="readonly"/>
      <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
	 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly" value="<%= hinId%>"/>
	  <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
    
    <div class="clear"></div>

<label>Requisition  From</label>
<%if(mediCoId!=0){%>
<textarea  id="requisitionFrom" name="requisitionFrom" class="textareaMediua" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1"><%=reqForm%></textarea>
<%}else{ %>
<textarea  id="requisitionFrom" name="requisitionFrom" class="textareaMediua" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1"><%=reqFormOpd%></textarea>
<%} %>  
<label>Crime No.</label>
<input type="text"   id="crimeNo" name="crimeNo"  maxlength="16" value="<%= crimeNo%>"/>

<label>Police station</label>
<textarea  id="policeStation" name="policeStation" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"><%= policeSt%></textarea>
<div class="clear"></div>
    
<label>Accompanied by (Name)</label>
<input type="text"   id="accompaniedByName" name="accompaniedByName" maxlength="96" value ="<%= byName%>"/>

<label>Accompanied by(Address)</label>
<textarea  id="accompaniedByAddress" name="accompaniedByAddress" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1"><%= byAddress%></textarea>

<label>Consent</label>
<textarea  id="consent" name="consent"  maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%= cosen%></textarea>

<div class="clear"></div>
<label>Comm. of exam Date</label>
<input type="text" id="commencementOfExaminationDate" value="<%=examCommDate %>" name="commencementOfExaminationDate" validate="Commencement of examination DateDate,date,no"  class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.commencementOfExaminationDate,true);" />



<label>Comm. of exam Time</label>
<input type="text"   id="commencementOfExaminationTime"  value="<%=examCommTime %>" name="commencementOfExaminationTime" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>

 <label>Place of examination</label>
 <textarea  id="placeExamination" name="placeExamination" class="textareaMediua"  maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"><%=examinationPlace %></textarea>

  
  <div class="clear"></div>
 <label>Id Mark 1</label>
 <textarea  id="identificationOne" name="identificationOne" class="textareaMediua"  maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1"><%= idMark1%></textarea>

 <label>Id Mark 2</label>
 <textarea  id="identificationTwo" name="identificationTwo" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%= idMark2%></textarea>
   
    
    <label>Marital History</label>
  <select name="maritalHistory" id="maritalHistory" >
    <%if(maritalHistory.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Married">Married</option>
  <option value="Unmarried">Unmarried</option>
   <%}else if(maritalHistory.equalsIgnoreCase("Married")){ %>
  <option value="">Select</option>
  <option value="Married" selected="selected">Married</option>
  <option value="Unmarried">Unmarried</option>
  <%}else if(maritalHistory.equalsIgnoreCase("Unmarried")){ %>
  <option value="">Select</option>
  <option value="Married">Married</option>
  <option value="Unmarried" selected="selected">Unmarried</option>
  <%} %>
  </select>
   
<div class="clear"></div>
  <label>Educational status</label>
<input type="text"   id="educationalStatus" name="educationalStatus" value="<%=educationalStatus%>"/>  
  <label>Occupation</label>
  <input type="text"  id="occupation"  name="occupation" readonly="readonly" value="<%=occuPation%>"/>

  <label>Female Witness</label>
  <textarea  id="femaleWitness" name="femaleWitness" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=witt1%></textarea>
 

 <div class="clear"></div>
 <h4>History related to the incident</h4>
 
  <label>History of incident</label>
 <textarea  id="statedBySubject" name="statedBySubject" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=histInj %></textarea>
 <label>Alleged Act Date</label>
<input type="text" id="allegedActDate" name="allegedActDate" validate="Alleged Act Date,date,no" value="<%=actDate %>" class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate%>',document.mlc.allegedActDate,true);" />

<label>Time</label>
<input type="text"   id="allegedActTime" name="allegedActTime" onKeyUp="mask(this.value,this,'2,5',':');" value="<%=actTime %>"	onBlur="IsValidTime(this.value,this.id);" maxlength="8" value="<%= actTime%>"/>
<div class="clear"></div>
<label>Place</label>
<textarea  id="allegedActPlace" name="allegedActPlace" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=placeAct%></textarea>

<label>State of consciousness</label>
<textarea  id="stateOfConsciousness" name="stateOfConsciousness" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=stateOfConsciousness%></textarea>
 <label>Number Of person(s)</label>
  <input type="text" name="numberOfPerson" maxlength="16" value="<%=numberOfPerson%>">
  <div class="clear"></div> 
   <label>Name Of Person(s)</label>
  <input type="text" name="nameOfPerson" maxlength="90" value="<%=nameOfPerson%>">
  
 <label>Details of position</label>
 <textarea   name="detailsOfPosition"  maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=detailsOfPosition %></textarea>
   <label>Degree of violence</label>
   <textarea  name="degreeOfViolence"  maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=degreeOfViolence %></textarea>    
<div class="clear"></div>
 <label>Pain</label>
 <textarea   name="Pain"  maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=pain%></textarea>
  
   <label>Urinated</label>
   <textarea   name="urinated"  maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=urinated%></textarea>
  
  <label>Other information</label>
  <textarea type="text"  name="otherInformation"  maxlength="510"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=otherInformation %></textarea>
 <div class="clear"></div>
<label>Resistance offered</label>
  <select name="resistanceOffered" id="resistanceOffered"  onchange="resistanceOfferedText();">
  
     <%if(resistanceOffered.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <%}if(resistanceOffered.equalsIgnoreCase("Yes")){ %>
  <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>
  <%}if(resistanceOffered.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No" selected="selected">No</option>
  
  <%} %>
  </select>  
 
   <div id="resistanceOfferedDiv" style="display: none">
   <label>Reason</label>
 <textarea type="text"   id="resistanceOfferedNo" name="resistanceOfferedNo"  maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=reason%></textarea>
 </div>
     <script>
  	<%if(resistanceOffered.equalsIgnoreCase("No")){%>
		document.getElementById("resistanceOfferedDiv").style.display="inline";
	<%}else{%>
		document.getElementById('resistanceOfferedNo').value=""; 
		document.getElementById("resistanceOfferedDiv").style.display="none";
	<%}%>
  </script>
<label>Reasons for delay</label>
<textarea   id="reasonsForDelay" name="reasonsForDelay"  maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=reasonsForDelay %></textarea>
   
<div class="clear"></div>
<h4>Sexual history</h4>
<label>Previous experience</label>
<textarea rows="" cols="" name="previousExperience" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=previousExperience %></textarea>

<label>Frequency</label>
<textarea rows="" cols="" name="frequency"  maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=frequency%></textarea>

<label>Date of last Sexual act</label>
<input type="text" id="lastSexualActDate" name="lastSexualActDate" value="<%=lastSexualActDate %>" validate="Date of last sexual act,date,no"  class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.lastSexualActDate,true);" />

<h4>Menstrual History</h4>

<label>Menstrual History</label>
<textarea rows="" cols="" name="menstrualHistory"  maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=menstrualHistory%></textarea>


<label>Age of menarche</label>
  <input type="text" name="ageOfMenarche" validate="Age of menarche,int,no" maxlength="3" value="<%=ageOfMenarche%>">
   
   
   <label>Periods</label>
   <select name="periods">  
  
    <%if(periods.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Regular">Regular</option>
  <option value="Irregular">Irregular</option>
  <option value="NA">NA</option>
  <%}if(periods.equalsIgnoreCase("Regular")){ %>
  <option value="">Select</option>
  <option value="Regular" selected="selected">Regular</option>
  <option value="Irregular">Irregular</option>
  <option value="NA">NA</option>
  <%}if(periods.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Regular">Regular</option>
  <option value="Irregular" selected="selected">Irregular</option>
  <option value="NA">NA</option>
  <%}if(periods.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Regular">Regular</option>
  <option value="Irregular">Irregular</option>
  <option value="NA" selected="selected">NA</option>
  <%} %>
  </select>
<div class="clear"></div>
  
     <label>Menstruating Now</label>
   <select name="whetherMmenstruatingNow">  
   <%if(whetherMmenstruatingNow.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(whetherMmenstruatingNow.equalsIgnoreCase("Yes")){ %>
  <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(whetherMmenstruatingNow.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No" selected="selected">No</option>
  <option value="NA">NA</option>
  <%}if(whetherMmenstruatingNow.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA" selected="selected">NA</option>
  <%} %>
  </select>

<label>Last Menstrual Date</label>
<input type="text" id="dateOfLastMenstrualPeriod" value="<%=dateOfLastMenstrualPeriod %>" name="dateOfLastMenstrualPeriod" validate="Date of Last Menstrual Period,date,no"  class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.dateOfLastMenstrualPeriod,true);" />

<label>Other relevant history </label>
<textarea rows="" cols="" name="otherRelevantHistory"  maxlength="510"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=otherRelevantHistory%> </textarea>

<div class="clear"></div>

<h4>Obstetric history</h4>
<label>Pregnant now</label>
     <select name="whetherPregnantNow">  
      <%if(whetherMmenstruatingNow.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(whetherMmenstruatingNow.equalsIgnoreCase("Yes")){ %>
  <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>
  <option value="NA">NA</option>
  <%}if(whetherMmenstruatingNow.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No" selected="selected">No</option>
  <option value="NA">NA</option>
  <%}if(whetherMmenstruatingNow.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <option value="NA" selected="selected">NA</option>
  <%} %>
  </select>
  
  <label>No. of pregnancies</label>
   <input type="text" name="noOfPreviousPregnancies" validate="No. of previous pregnancies,int,no"  value="<%=noOfPreviousPregnancies%>">
   
   
  <label>Type of delivery</label>
  <textarea rows="" cols="" name="typeOfDeliveryOtherDetails"  maxlength="100"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=typeOfDeliveryOtherDetails%></textarea>
  
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
    <select name="build" id="build">
  
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
  
  <%} %></select>
  <div class="clear"></div>
  
  <label>Clothes</label>
  <select name="clothes">
    
   <%if(clothes.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Disordered">Disordered</option>
  <option value="Torn">Torn</option>
  <option value="NA">NA</option>
    <%}else if(clothes.equalsIgnoreCase("Intact")){ %>
  <option value="">Select</option>
  <option value="Intact" selected="selected">Intact</option>
  <option value="Disordered">Disordered</option>
  <option value="Torn">Torn</option>
  <option value="NA">NA</option>
  
  <%}else if(clothes.equalsIgnoreCase("Disordered")){ %>
  <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Disordered" selected="selected">Disordered</option>
  <option value="Torn">Torn</option>
  <option value="NA">NA</option>

  <%}else if(clothes.equalsIgnoreCase("Torn")){ %>
    <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Disordered">Disordered</option>
  <option value="Torn" selected="selected">Torn</option>
  <option value="NA">NA</option>
  
  <%}else if(clothes.equalsIgnoreCase("NA")){ %>
  <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Disordered">Disordered</option>
  <option value="Torn">Torn</option>
  <option value="NA" selected="selected">NA</option>
  
  
  <%} %>
  </select>
  <label>General Mental condition</label>
  <select name="mentalCondition">
   
   <%if(mentalCondition.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Excited">Excited</option>
  <option value="Calm">Calm</option>
  <option value="Depressed">Depressed</option>
    <%}else if(mentalCondition.equalsIgnoreCase("Excited")){ %>
  <option value="">Select</option>
  <option value="Excited" selected="selected">Excited</option>
  <option value="Calm">Calm</option>
  <option value="Depressed">Depressed</option>
  
  <%}else if(mentalCondition.equalsIgnoreCase("Calm")){ %>
  <option value="">Select</option>
  <option value="Excited">Excited</option>
  <option value="Calm" selected="selected">Calm</option>
  <option value="Depressed">Depressed</option>

  <%}else if(mentalCondition.equalsIgnoreCase("Depressed")){ %>
    <option value="">Select</option>
  <option value="Excited">Excited</option>
  <option value="Calm">Calm</option>
  <option value="Depressed" selected="selected">Depressed</option>
  
  
  <%} %>

  </select>
    
  <label>Sec. sexual characters</label>
  <textarea rows="" cols="" name="secondarySexual" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%= secondarySexual%></textarea>
     
  <div class="clear"></div>
  <h4>Local</h4>
  <div class="clear"></div>  
  <label>Hair</label>
    <select name="hair" id="hair"  onchange="hairText();" >

  
   <%if(hair.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Matted">Matted</option>
  <option value="Not matted">Not matted</option>
  <option value="Other">Other</option>
  
    <%}else if(hair.equalsIgnoreCase("Matted")){ %>
  <option value="">Select</option>
  <option value="Matted" selected="selected">Matted</option>
  <option value="Not matted">Not matted</option>
  <option value="Other">Other</option>
  
  <%}else if(hair.equalsIgnoreCase("Not matted")){ %>
  <option value="">Select</option>
  <option value="Matted">Matted</option>
  <option value="Not matted" selected="selected">Not matted</option>
  <option value="Other">Other</option>

  <%}else if(hair.equalsIgnoreCase("Other")){ %>
    <option value="">Select</option>
  <option value="Matted">Matted</option>
  <option value="Not matted">Not matted</option>
  <option value="Other" selected="selected">Other</option>
  
  
  <%} %>
  </select>
   <div id="hairDiv" style="display: none">
    <textarea rows="" cols="" name="hairOther"  id="hairOther" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=hairOther %></textarea>  
  </div> 
  
      <script>
  	<%if(hair.equalsIgnoreCase("Other")){%>
		document.getElementById("hairDiv").style.display="inline";
	<%}else{%>
		document.getElementById('hairOther').value=""; 
		document.getElementById("hairDiv").style.display="none";
	<%}%>
  </script>
  <label>Appearance of labia/clitoris</label>
    <textarea rows="" cols="" name="appearance" id="appearance" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=appearance_of_labia%></textarea>
  
    <label>Hymen</label>
    <select name="hymen" id="hymen"  onchange="hymenText();" >
    <%if(hymen.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Torn">Torn</option>
  <option value="Carunculae hymenalis">Carunculae hymenalis</option>
  <option value="Absent">Absent</option>
  <option value="Fleshy and elastic">Fleshy and elastic</option>
  <option value="Other">Other</option>
    <%}else if(hymen.equalsIgnoreCase("Intact")){ %>
  
  <option value="">Select</option>
  <option value="Intact" selected="selected">Intact</option>
  <option value="Torn">Torn</option>
  <option value="Carunculae hymenalis">Carunculae hymenalis</option>
  <option value="Absent">Absent</option>
  <option value="Fleshy and elastic">Fleshy and elastic</option>
  <option value="Other">Other</option>
    <%}else if(hymen.equalsIgnoreCase("Torn")){ %>
  
  <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Torn" selected="selected">Torn</option>
  <option value="Carunculae hymenalis">Carunculae hymenalis</option>
  <option value="Absent">Absent</option>
  <option value="Fleshy and elastic">Fleshy and elastic</option>
  <option value="Other">Other</option>
    <%}else if(hymen.equalsIgnoreCase("Carunculae hymenalis")){ %>
  
  <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Torn">Torn</option>
  <option value="Carunculae hymenalis" selected="selected">Carunculae hymenalis</option>
  <option value="Absent">Absent</option>
  <option value="Fleshy and elastic">Fleshy and elastic</option>
  <option value="Other">Other</option>
  
    <%}else if(hymen.equalsIgnoreCase("Absent")){ %>
  <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Torn">Torn</option>
  <option value="Carunculae hymenalis">Carunculae hymenalis</option>
  <option value="Absent" selected="selected">Absent</option>
  <option value="Fleshy and elastic">Fleshy and elastic</option>
  <option value="Other">Other</option>
    <%}else if(hymen.equalsIgnoreCase("Fleshy and elastic")){ %>
    <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Torn">Torn</option>
  <option value="Carunculae hymenalis">Fleshy and elastic</option>
  <option value="Absent">Absent</option>
  <option value="Fleshy and elastic" selected="selected">Fleshy and elastic</option>
  <option value="Other">Other</option>
  
    <%}else if(hymen.equalsIgnoreCase("Other")){ %>
    <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Torn">Torn</option>
  <option value="Carunculae hymenalis">Carunculae hymenalis</option>
  <option value="Absent">Absent</option>
  <option value="Fleshy and elastic">Fleshy and elastic</option>
  <option value="Other" selected="selected">Other</option>
  <%} %>
  
  </select>
   
  
  <div id="hymenDiv" style="display: none">
  <input type="text"   id="hymenOther" name="hymenOther" maxlength="16" value="<%=hymenOther%>"/>
  
  
  </div>
      <script>
  	<%if(hymen.equalsIgnoreCase("Other")){%>
		document.getElementById("hymenDiv").style.display="inline";
	<%}else{%>
		document.getElementById('hymenOther').value=""; 
		document.getElementById("hymenDiv").style.display="none";
	<%}%>
  </script>
    <div class="clear"></div>
    <div id="hymenTornDiv" style="display: none">
    <label>Time</label>
  <input type="text"  value="<%=hymenTorn %>"  id="hymenTorn" name="hymenTorn" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
  
    <label>fresh/infected/healing/old</label>
<textarea rows="" cols=""   id="fresh" name="fresh" maxlength="100"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=fresh %></textarea>
  
  </div>
    
  <label>Fourchette</label>
    <select name="fourchette" id="fourchette"  >
 <%if(fourchette.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Torn">Torn</option>
  
  <%}else if(fourchette.equalsIgnoreCase("Intact")){ %>
  <option value="">Select</option>
  <option value="Intact" selected="selected">Intact</option>
  <option value="Torn">Torn</option>
  
  <%}else if(fourchette.equalsIgnoreCase("Torn")){ %>
  <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Torn" selected="selected">Torn</option>
  
  <%} %>
  </select>
  <label>Details</label>
  <textarea rows="" cols="" id="fourchetteDetails" name="fourchetteDetails" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=fourchetteDetails%></textarea>
  
    <label>Posterior commissure</label>
    <select name="posteriorCommissure" id="posteriorCommissure"  >

   <%if(posteriorCommissure.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Torn">Torn</option>
  
  <%}else if(posteriorCommissure.equalsIgnoreCase("Intact")){ %>
  <option value="">Select</option>
  <option value="Intact" selected="selected">Intact</option>
  <option value="Torn">Torn</option>
  
  <%}else if(posteriorCommissure.equalsIgnoreCase("Torn")){ %>
  <option value="">Select</option>
  <option value="Intact">Intact</option>
  <option value="Torn" selected="selected">Torn</option>
  
  <%} %>
  </select>
  <div class="clear"></div>
  <label>Details</label>
  <textarea rows="" cols="" id="posteriorCommissureDetails" name="posteriorCommissureDetails" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=posteriorCommissureDetails%></textarea>
    
  
      <label>Vagina</label>
    <select name="vagina" id="vagina"  >
      
    <%if(vagina.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Admits one">Admits one</option>
  <option value="two">two</option>
  <option value="more fingers">more fingers</option>
  
    <%}else if(vagina.equalsIgnoreCase("Admits one")){ %>
  <option value="">Select</option>
  <option value="Admits one" selected="selected">Admits one</option>
  <option value="two">two</option>
  <option value="more fingers">more fingers</option>
  
  <%}else if(vagina.equalsIgnoreCase("two")){ %>
    <option value="">Select</option>
  <option value="Admits one">Admits one</option>
  <option value="two" selected="selected">two</option>
  <option value="more fingers">more fingers</option>
  
  <%}else if(vagina.equalsIgnoreCase("more fingers")){ %>
    <option value="">Select</option>
  <option value="Admits one">Admits one</option>
  <option value="two">two</option>
  <option value="more fingers" selected="selected">more fingers</option>
  

  <%} %>
  
  
  </select>
  
      <label>Rugae</label>
    <select name="rugae" id="rugae"  >
   <%if(rugae.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Distinct">Distinct</option>
  <option value="Not distinct">Not distinct</option>
  
  <%}else if(rugae.equalsIgnoreCase("Distinct")){ %>
  <option value="">Select</option>
  <option value="Distinct" selected="selected">Distinct</option>
  <option value="Absent">Absent</option>
  <%}else if(rugae.equalsIgnoreCase("Not distinct")){ %>
  <option value="">Select</option>
  <option value="Distinct">Distinct</option>
  <option value="Not distinct" selected="selected">Not distinct</option>
  <%} %>
  </select>  
<div class="clear"></div>
  <label>Discharge</label>
    <select name="discharge" id="discharge"  onchange="dischargeText();" >
  
  
   <%if(discharge.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(discharge.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(discharge.equalsIgnoreCase("Absent")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent" selected="selected">Absent</option>
  <%} %>
  </select>  
  
  <div id="dischargeDiv" style="display: none">
     <label>Normal / blood / yellowish / whitish </label>  
  
  <textarea rows="" cols=""   id="dischargePresent" name="dischargePresent" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=dischargePresent %></textarea>
  
  </div>
  
  <script>
  <%if(discharge.equalsIgnoreCase("Present")){%>
	document.getElementById("dischargeDiv").style.display="inline";
<%}else{%>
	document.getElementById('dischargePresent').value=""; 
	document.getElementById("dischargeDiv").style.display="none";
<%}%>
  </script>
  <label>Injuries in the vagina</label>
  
  <textarea rows="" cols="" name="injuriesVagina" maxlength="510"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%= injuriesVagina%></textarea>  
  
  <label>Perineum and thighs </label>
   
   <textarea rows="" cols=""   id="perineum" name="perineum" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=perineum %></textarea>
  
    <div class="clear"></div>
    
     <label>Others if any </label>
   
   <textarea rows="" cols="" id="otherAny" name="otherAny" maxlength="510"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=otherAny %></textarea>
    
     
     <label>Injuries on the body </label>
  <textarea rows="" cols="" name="injuriesOnTheBody" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%= injuriesOnTheBody%></textarea>
    
     <label>Systemic examination</label>
  <textarea rows="" cols="" name="systemicexamination" maxlength="50"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"> <%= systemicexamination%></textarea>
      <div class="clear"></div>
      
    <label>Exam concluded Date</label>
    <input type="text" id="examinationConcludedDate" value="<%=examinDate %>" name="examinationConcludedDate" validate="Examination concluded Date,date,no"  class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.examinationConcludedDate,true);" />
 
    <label>Time</label>
     <input type="text" name="examConcludedTime" value="<%=examinTime %>" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>    
</div>
<div class="Block">
<table width="600" cellspacing="0" cellpadding="0" border="0" style="width:500px; float:left; margin-left:5px; border:1px solid #c0c0c0;">
<tr>
    
    <th>Select</th>
    <th>Material objects preserved</th>
  </tr>
   <%int inc = 1;%>
<%--  if(materialObjectsList.size()>0) {
	 for(MlcMaterialObjects materialObjects :materialObjectsList){

%>
 <tr>
    <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Vaginal smears")){ %>
      <td><input type="checkbox" name="slNo1" id="slNo1" value="y" checked="checked"></td>
 <%}else{ %>
      <td><input type="checkbox" name="slNo1" id="slNo1" value="y"></td>
 <%} %>
    <td><input type="hidden" name="materialObjects1" id="aa" class="radioCheckCol2" value="Vaginal smears">Vaginal smears</td>
  </tr>
  <tr>
    <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Vaginal swabs")){ %>
 <td><input type="checkbox" name="slNo2" id="slNo2" value="y" checked="checked"></td>
 <%}else{ %>
 <td><input type="checkbox" name="slNo2" id="slNo2" value="y"></td>
 <%} %>
    <td><input type="hidden" name="materialObjects2" id="aa" class="radioCheckCol2" value="Vaginal swabs">Vaginal swabs</td>
  </tr>
  <tr>
     <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Nail clippings")){ %>
 <td><input type="checkbox" name="slNo3" id="slNo3" value="y" checked="checked"></td>
 <%}else{ %>
 <td><input type="checkbox" name="slNo3" id="slNo3" value="y"></td>
 <%} %>
    <td><input type="hidden" name="materialObjects3" id="aa" class="radioCheckCol2" value="Nail clippings">Nail clippings</td>
  </tr>
 <tr>
     <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Loose hair from combings of pubic region")){ %>
 <td><input type="checkbox" name="slNo4" id="slNo4" value="y" checked="checked"></td>
 <%}else{ %>
 <td><input type="checkbox" name="slNo4" id="slNo4" value="y"></td>
 <%} %>
    <td><input type="hidden" name="materialObjects4" id="aa" class="radioCheckCol2" value="Loose hair from combings of pubic region">Loose hair from combings of pubic region</td>
  </tr>
  <tr> 
  <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Pubic hair samples")){ %>
 <td><input type="checkbox" name="slNo5" id="slNo5" value="y" checked="checked"></td>
 <%}else{ %>
 <td><input type="checkbox" name="slNo5" id="slNo5" value="y"></td>
 <%} %> 
    <td><input type="hidden" name="materialObjects5"  id="aa" class="radioCheckCol2" value="Pubic hair samples">Pubic hair samples</td>
  </tr>
  <tr>
      <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Scalp hair samples (cut)")){ %>
 <td><input type="checkbox" name="slNo6" id="slNo6" value="y" checked="checked"></td>
 <%}else{ %>
 <td><input type="checkbox" name="slNo6" id="slNo6" value="y"></td>
 <%} %>

    <td><input type="hidden" name="materialObjects6" id="aa" class="radioCheckCol2" value="Scalp hair samples (cut)">Scalp hair samples (cut)</td>
  </tr>
  <tr>
       <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Urine for pregnancy test")){ %>
 <td><input type="checkbox" name="slNo7" id="slNo7" value="y" checked="checked"></td>
 <%}else{ %>
<td><input type="checkbox" name="slNo7" id="slNo7" value="y"></td>
 <%} %>
    <td><input type="hidden" name="materialObjects7" id="aa" class="radioCheckCol2" value="Urine for pregnancy test">Urine for pregnancy test</td>
  </tr>
  <tr>
   <% if(materialObjects.getMaterialObjects().equalsIgnoreCase("Blood to look for sedatives / hypnotics")) {%>
 <td><input type="checkbox" name="slNo8" id="slNo8" value="y" checked="checked"></td>
 <%}else{ %>
 <td><input type="checkbox" name="slNo8" id="slNo8" value="y"></td>
 <%} %>
    <td><input type="hidden" name="materialObjects8"  id="aa" class="radioCheckCol2" value="Blood to look for sedatives / hypnotics">Blood to look for sedatives / hypnotics</td>
  </tr>
    <tr>
     <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Urine to look for sedatives / hypnotics")){ %>
 <td><input type="checkbox" name="slNo9" id="slNo9" value="y" checked="checked"></td>
 <%}else{ %>
 <td><input type="checkbox" name="slNo9" id="slNo9" value="y"></td>
 <%} %>
    <td><input type="hidden" name="materialObjects9"  id="aa" class="radioCheckCol2" value="Urine to look for sedatives / hypnotics">Urine to look for sedatives / hypnotics</td>
  </tr>
  <tr>
      <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Clothes. Any other")){ %>
  
       <td><input type="checkbox" name="slNo10" id="slNo10" value="y" checked="checked"></td>
 <%}else{ %>
 <td><input type="checkbox" name="slNo10" id="slNo10" value="y"></td>
   <%} %>
    <td><input type="hidden" name="materialObjects10" class="radioCheckCol2" value="Clothes. Any other">Clothes. Any other</td>
  </tr>
  <tr>
     <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("If not preserved, reasons")){ %>
  
       <td><input type="checkbox" name="slNo11" id="slNo11" value="y" checked="checked"></td>
 <%}else{ %>
 <td><input type="checkbox" name="slNo11" id="slNo11" value="y"></td>
   <%} %>
    <td><input type="hidden" name="materialObjects11" id="aa" class="radioCheckCol2" value="If not preserved, reasons">If not preserved, reasons</td>
  </tr>
  <%}}else{ %> --%>
   <tr>
     <td><input type="checkbox" name="slNo1" id="slNo1" value="y"></td>
    <td><input type="hidden" name="materialObjects1" id="aa" class="radioCheckCol2" value="Vaginal smears">Vaginal smears</td>
  </tr>
  <tr>
     <td><input type="checkbox" name="slNo2" id="slNo2" value="y"></td>
    <td><input type="hidden" name="materialObjects2" id="aa" class="radioCheckCol2" value="Vaginal swabs">Vaginal swabs</td>
  </tr>
  <tr>
     <td><input type="checkbox" name="slNo3" id="slNo3" value="y"></td>
    <td><input type="hidden" name="materialObjects3" id="aa" class="radioCheckCol2" value="Nail clippings">Nail clippings</td>
  </tr>
 <tr>
     <td><input type="checkbox" name="slNo4" id="slNo4" value="y"></td>
    <td><input type="hidden" name="materialObjects4" id="aa" class="radioCheckCol2" value="Loose hair from combings of pubic region">Loose hair from combings of pubic region</td>
  </tr>
  <tr>
     <td><input type="checkbox" name="slNo5" id="slNo5" value="y"></td>
    <td><input type="hidden" name="materialObjects5"  id="aa" class="radioCheckCol2" value="Pubic hair samples">Pubic hair samples</td>
  </tr>
  <tr>
     <td><input type="checkbox" name="slNo6" id="slNo6" value="y"></td>
    <td><input type="hidden" name="materialObjects6" id="aa" class="radioCheckCol2" value="Scalp hair samples (cut)">Scalp hair samples (cut)</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="slNo7" id="slNo7" value="y"></td>
    <td><input type="hidden" name="materialObjects7" id="aa" class="radioCheckCol2" value="Urine for pregnancy test">Urine for pregnancy test</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="slNo8" id="slNo8" value="y"></td>
    <td><input type="hidden" name="materialObjects8"  id="aa" class="radioCheckCol2" value="Blood to look for sedatives / hypnotics">Blood to look for sedatives / hypnotics</td>
  </tr>
    <tr>
     <td><input type="checkbox" name="slNo9" id="slNo9" value="y"></td>
    <td><input type="hidden" name="materialObjects9"  id="aa" class="radioCheckCol2" value="Urine to look for sedatives / hypnotics">Urine to look for sedatives / hypnotics</td>
  </tr>
  <tr>
     <td><input type="checkbox" name="slNo10" id="slNo10" value="y"></td>
    <td><input type="hidden" name="materialObjects10" class="radioCheckCol2" value="Clothes. Any other">Clothes. Any other</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="slNo11" id="slNo11" value="y"></td>
    <td><input type="hidden" name="materialObjects11" id="aa" class="radioCheckCol2" value="If not preserved, reasons">If not preserved, reasons</td>
  </tr>
  <%//} %>
</table>
<input    type="hidden" name="hdb" id="hdb"    value="<%=11 %>" />
<div class="clear"></div>
<div class="clear" style="margin:10px 0px"></div>
<label>Opinion</label>
<textarea  id="opinion" name="opinion" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=opNion%></textarea>

<label>Resons for conclusions</label>
<textarea  id="reasonForConclusion" name="reasonForConclusion" class="textareaMediua" maxlength="510"  onkeyup="return ismaxlength(this)" tabindex="1"><%=reasonForConclusion %></textarea>
<div class="clear"></div>
<div id="edited"></div>
 <% if(meDetails.size()==0) {%>
 <input type="button" name="add" id="addbutton" value="Submit" 	class="button"	onClick="submitForm('mlc','mlc?method=addExamOfFemaleVictimOfSexualAssault&flag=submit');"	accesskey="a" tabindex=1 />
 <% }else{ %>
 <input type="button" name="add" id="addbutton" value="Authorization" 	class="button"	onClick="submitForm('mlc','mlc?method=addExamOfFemaleVictimOfSexualAssault&flag=authorization');"	accesskey="a" tabindex=1 />
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

   <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Vaginal smears")){ %>

 		  document.getElementById('slNo1').checked = true;
    
	<%} %>


   <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Vaginal swabs")){ %>
   document.getElementById('slNo2').checked = true;
   
	<%} %>
   
    <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Nail clippings")){ %>
    document.getElementById('slNo3').checked = true;
	<%} %>
   
    <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Loose hair from combings of pubic region")){ %>
    document.getElementById('slNo4').checked = true;
	<%} %>
    <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Pubic hair samples")){ %>
    document.getElementById('slNo5').checked = true;
	<%} %>
        <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Scalp hair samples (cut)")){ %>
        document.getElementById('slNo6').checked = true;
    	<%} %>

     
      <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Urine for pregnancy test")){ %>
      document.getElementById('slNo7').checked = true;
  	<%} %>

    
	  <% if(materialObjects.getMaterialObjects().equalsIgnoreCase("Blood to look for sedatives / hypnotics")) {%>
  	document.getElementById('slNo8').checked = true;
	<%} %>
	  <% if(materialObjects.getMaterialObjects().equalsIgnoreCase("Urine to look for sedatives / hypnotics")) {%>
	  	document.getElementById('slNo9').checked = true;
		<%} %>

	  
     <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Clothes. Any other")){ %>
     document.getElementById('slNo10').checked = true;
 	<%} %>

 
    
    <%if(materialObjects.getMaterialObjects().equalsIgnoreCase("If not preserved, reasons")){ %>
    document.getElementById('slNo11').checked = true;
	<%} %>
	 <%}}%>

</script>