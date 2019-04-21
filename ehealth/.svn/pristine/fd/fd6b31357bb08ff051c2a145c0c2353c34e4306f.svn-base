<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
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

function uterusText(){	
if(document.getElementById("uterus").value=='Palpable per abdomen'){
	document.getElementById("uterusDiv").style.display="inline";
}else{
	document.getElementById("uterusDiv").style.display="none";
}
	
}

function injuriesToLabiaText(){	
	if(document.getElementById("injuriesToLabia").value=='Palpable per abdomen'){
		document.getElementById("injuriesToLabiaDiv").style.display="inline";
	}else{
		document.getElementById("injuriesToLabiaDiv").style.display="none";
	}
		
	}
function lochiaDischargeOsText(){	
	if(document.getElementById("lochiaDischargeOs").value=='Present'){
		document.getElementById("lochiaDischargeOsDiv").style.display="inline";
	}else{
		document.getElementById("lochiaDischargeOsDiv").style.display="none";
	}
		
	}

function injuriesText(){	
	if(document.getElementById("injuries").value=='Present'){
		document.getElementById("injuriesDiv").style.display="inline";
	}else{
		document.getElementById("injuriesDiv").style.display="none";
	}
		
	}
	
function injuriesToVaginaText(){	
if(document.getElementById("injuriesToVagina").value=='Present'){
	document.getElementById("injuriesToVaginaDiv").style.display="inline";
}else{
document.getElementById("injuriesToVaginaDiv").style.display="none";
}	
}		
</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

List<Patient> patientList = new   ArrayList<Patient>();
if(map.get("patientList") != null)
{
	patientList=(List<Patient>)map.get("patientList");
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
List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
if(map.get("mlcList")!=null){
	mlcList=(List<OpdPatientDetails>)map.get("mlcList");
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
String hinNo="";
String name="";
String age="";
String gender="";
String address="";
int detailId=0;
int hinId=0;
String ocupation="";
String InjDetailVagina="";
//-----------
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
String  reqTime="";
String  reqDate="";


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
String refDate="";
String recTime="";
String examCommTime="";
String examCommDate="";
String menstrualHistory="";
String vagina="";
String injuriesInVagina="";
String anyOtherDetail="";
String uterusPalpable="";
String uterus="";
String lastMenstrualDate="";
String AntenatalCheckup="";
String LochiaDischargeDetail="";
String UsgAbdomen="";
String LochiaDischarge="";
String VaginaInjDetail="";
String CervixInjDetail="";
String MenstrualTime="";
String InjCervical="";
String ExternalOs="";
String CervicalMucusPlug="";
String CervicalLips="";
String InjLabial="";
String LabialTenderness="";
String Labia="";
String StriaeGravidarum="";
String Abdomin="";
String Nippal="";
String AreolaNippal="";
String Breasts="";
String AnyOtherInformation="";
String Urinated="";
String SysExaminationFindings="";
String Conjunctiva="";
for(MedicoLegalDetails legalDetails:meDetails){
	  mediCoId=legalDetails.getId();
	  srNo= legalDetails.getSerialNo()!=null ? legalDetails.getSerialNo():"";
	  crimeNo=legalDetails.getCrimeNo()!=null ?legalDetails.getCrimeNo():"";
	  
	  if(legalDetails.getExaminationDate()!=null){
			 
		  examinDate=legalDetails.getExaminationDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getExaminationDate())  :"";
			    }
	  addiTion=legalDetails.getNoOfAdditionalSheets()!=null ? legalDetails.getNoOfAdditionalSheets():0;
	  idMark1=legalDetails.getIdMark1()!=null ?legalDetails.getIdMark1() :"";
	  idMark2=legalDetails.getIdMark2()!=null ?legalDetails.getIdMark2() :"";
	  policeSt=legalDetails.getPoliceStation()!=null ?legalDetails.getPoliceStation():"";
	  witt1= legalDetails.getWitnesses1()!=null ?legalDetails.getWitnesses1():"";
	  witt2= legalDetails.getWitnesses2()!=null ?legalDetails.getWitnesses2():"";
	  dieases=legalDetails.getTestisDiseaseInjury()!=null ?legalDetails.getTestisDiseaseInjury():"";
	  reqForm=legalDetails.getRequisitionFrom()!=null ?legalDetails.getRequisitionFrom():"";
	  cosen=legalDetails.getConsent()!=null ?legalDetails.getConsent():"";
	
	  opNion=legalDetails.getOpinion()!=null ?legalDetails.getOpinion():"";
	 
	  boughtBy=legalDetails.getBroughtBy()!=null?legalDetails.getBroughtBy():"";
	  boughtAddress=legalDetails.getBroughtByAddress()!=null?legalDetails.getBroughtByAddress():"";
	  histInj=legalDetails.getHistoryInjuryCause()!=null?legalDetails.getHistoryInjuryCause():"";
	  injDetail=legalDetails.getInjuryDetails()!=null?legalDetails.getInjuryDetails():"";
	  his=legalDetails.getPhysicalExamination()!=null?legalDetails.getPhysicalExamination():"";
	  sexUalDev=legalDetails.getHistorySexualDev()!=null?legalDetails.getHistorySexualDev():"";
	  if(legalDetails.getHeight()!=null){
	  height=legalDetails.getHeight();
          }
           if(legalDetails.getWeight()!=null){
           weight=legalDetails.getWeight();
          }
	   otherHistory=legalDetails.getOtherHistory()!=null?legalDetails.getOtherHistory():"";
	 
	byName=legalDetails.getAccompByName()!=null?legalDetails.getAccompByName():"";
	byAddress=legalDetails.getAccompByAddress()!=null?legalDetails.getAccompByAddress():"";
reqTime=legalDetails.getRequisitionTime()!=null?legalDetails.getRequisitionTime():"";
if(legalDetails.getRequisitionDate()!=null){
	 
	reqDate=legalDetails.getRequisitionDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRequisitionDate())  :"";
	    }
if(legalDetails.getAllegedActDate()!=null){
	actDate=legalDetails.getAllegedActDate();
	    }
placeAct=legalDetails.getPlaceOfAct()!=null?legalDetails.getPlaceOfAct():"";
pain=legalDetails.getPain()!=null?legalDetails.getPain():"";   

if(legalDetails.getLastSexualActDate()!=null){
sexualactLast=legalDetails.getLastSexualActDate();
}

if(legalDetails.getLastMenstrualDate()!=null){
	last_menstrual_date=legalDetails.getLastMenstrualDate();
	    }
if(legalDetails.getNoOfPregnancies()!=null){
no_of_pregnancies=legalDetails.getNoOfPregnancies();
}

type_of_delivery=legalDetails.getTypeOfDelivery()!=null?legalDetails.getTypeOfDelivery():"";
build=legalDetails.getBuild()!=null?legalDetails.getBuild():"";
sec_sexual_char=legalDetails.getSecSexualChar()!=null?legalDetails.getSecSexualChar():"";
labia=legalDetails.getAppearanceOfLabia()!=null?legalDetails.getAppearanceOfLabia():"";
appearance_of_labia= legalDetails.getAppearanceOfPerineum()!=null?legalDetails.getAppearanceOfPerineum() +" "+ labia:"";
fourchette= legalDetails.getFourchette()!=null?legalDetails.getFourchette():"";
fourDetail= legalDetails.getFourchetteDetails()!=null?legalDetails.getFourchetteDetails():"";
posterior_commissure=legalDetails.getPosteriorCommissure()!=null?legalDetails.getPosteriorCommissure():"";
posteriorDetail=legalDetails.getPosteriorCommissureDetails()!=null?legalDetails.getPosteriorCommissureDetails():"";
penis=legalDetails.getPenis()!=null?legalDetails.getPenis():"";
injury_on_body=legalDetails.getInjuryOnBody()!=null?legalDetails.getInjuryOnBody():"";
sys_examination_findings=legalDetails.getSysExaminationFindings()!=null?legalDetails.getSysExaminationFindings():"";
inner_thigh_regions_pereneum=legalDetails.getInnerThighRegionsPereneum()!=null?legalDetails.getInnerThighRegionsPereneum():"";
rectal_exam_speculum=legalDetails.getRectalExamSpeculum()!=null?legalDetails.getRectalExamSpeculum():"";

if(legalDetails.getRequisitionDate()!=null){
    
    refDate=legalDetails.getRequisitionDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRequisitionDate())  :"";
     }
    if(legalDetails.getReceivedDate()!=null){
 
 refDate=legalDetails.getReceivedDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getReceivedDate())  :"";
    }
    recTime=legalDetails.getReceivedTime()!=null?legalDetails.getReceivedTime():"";
    if(legalDetails.getRefDate()!=null){
    	 
    	 refDate=legalDetails.getRefDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRefDate())  :"";
    	    }
    
    examCommTime=legalDetails.getExamCommTime()!=null?legalDetails.getExamCommTime():"";
    examCommDate=legalDetails.getExamCommDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getExamCommDate())  :"";

    menstrualHistory=legalDetails.getMenstrualHistory()!=null?legalDetails.getMenstrualHistory():"";
    vagina=legalDetails.getVagina()!=null?legalDetails.getVagina():"";
    injuriesInVagina=legalDetails.getInjuriesInVagina()!=null?legalDetails.getInjuriesInVagina():"";
    anyOtherDetail=legalDetails.getAnyOtherDetail()!=null?legalDetails.getAnyOtherDetail():"";
    uterusPalpable=legalDetails.getUterusPalpable()!=null?legalDetails.getUterusPalpable():"";
    uterus=legalDetails.getUterus()!=null?legalDetails.getUterus():"";
    lastMenstrualDate=legalDetails.getLastMenstrualDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getLastMenstrualDate())  :"";
    
    
    
    
    
    
     AntenatalCheckup=legalDetails.getAntenatalCheckup()!=null?legalDetails.getAntenatalCheckup():"";
     LochiaDischargeDetail=legalDetails.getLochiaDischargeDetail()!=null?legalDetails.getLochiaDischargeDetail():"";
     UsgAbdomen=legalDetails.getUsgAbdomen()!=null?legalDetails.getUsgAbdomen():"";
     LochiaDischarge=legalDetails.getLochiaDischarge()!=null?legalDetails.getLochiaDischarge():"";
     VaginaInjDetail=legalDetails.getVaginaInjDetail()!=null?legalDetails.getVaginaInjDetail():"";
   	 CervixInjDetail=legalDetails.getCervixInjDetail()!=null?legalDetails.getCervixInjDetail():"";
     MenstrualTime=legalDetails.getMenstrualTime()!=null?legalDetails.getMenstrualTime():"";
     InjCervical=legalDetails.getInjCervical()!=null?legalDetails.getInjCervical():"";
     ExternalOs=legalDetails.getExternalOs()!=null?legalDetails.getExternalOs():"";
     CervicalMucusPlug=legalDetails.getCervicalMucusPlug()!=null?legalDetails.getCervicalMucusPlug():"";
     CervicalLips=legalDetails.getCervicalLips()!=null?legalDetails.getCervicalLips():"";
     InjLabial=legalDetails.getInjLabial()!=null?legalDetails.getInjLabial():"";
     LabialTenderness=legalDetails.getLabialTenderness()!=null?legalDetails.getLabialTenderness():"";
     Labia=legalDetails.getLabia()!=null?legalDetails.getLabia():"";
     StriaeGravidarum=legalDetails.getStriaeGravidarum()!=null?legalDetails.getStriaeGravidarum():"";
     Abdomin=legalDetails.getAbdomin()!=null?legalDetails.getAbdomin():"";
     Nippal=legalDetails.getNippal()!=null?legalDetails.getNippal():"";
     AreolaNippal=legalDetails.getAreolaNippal()!=null?legalDetails.getAreolaNippal():"";
     Breasts=legalDetails.getBreasts()!=null?legalDetails.getBreasts():"";
     AnyOtherInformation=legalDetails.getAnyOtherInformation()!=null?legalDetails.getAnyOtherInformation():"";
     Urinated=legalDetails.getUrinated()!=null?legalDetails.getUrinated():"";
     SysExaminationFindings=legalDetails.getSysExaminationFindings()!=null?legalDetails.getSysExaminationFindings():"";
     Conjunctiva=legalDetails.getConjunctiva()!=null?legalDetails.getConjunctiva():"";
     InjDetailVagina=legalDetails.getInjDetailVagina()!=null?legalDetails.getInjDetailVagina():"";
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
} 




%>
<form name="mlc" method="post" action="">
<div class="titleBg">
<h2>Search</h2>
</div>
<div class="Block">
<label><span>*</span> UHID</label>
<!-- <input name="uhinId" id="uhinId" validate="UHID,string,yes"  onblur="patientList(this.value,'mlc','Evidence Recent');"> -->
<input name="uhinId" id="uhinId" validate="UHID,string,yes"  readonly="readonly" value="<%= hinNo%>">  
 <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
  <input type="hidden"  name="hinId"   value="<%= hinId%>"/>
 <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
 <input type="hidden" name="mediCoId" id="mediCoId"  value="<%= mediCoId%>">
 
</div>
<div class="titleBg">
<h2>EXAMINATION FOR EVIDENCE OF RECENT DELIVERY</h2>
</div>
<div class="Block">
<div class="clear"></div>
	
<label>Ref. ML No.</label>

 <%if(mediCoId!=0){%>
<input type="text"   id="refMLNo" name="refMLNo"  validate="Ref No,String,Yes" value ="<%= srNo%>" maxlength="16" readonly="readonly"/>
 <%}else{ %>
 <input type="text"   id="refMLNo" name="refMLNo"  validate="Ref No,String,Yes" value ="<%= orderNo%>" maxlength="16" readonly="readonly"/>
 <%}%>


<label>Ref. ML Date</label>
<input type="text" id="refMLDate" name="refMLDate" validate="Ref. ML Date,date,no" class="date"  value="<%=refDate%>" onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />

<div class="clear"></div>
<label>Requisition  From</label>
<textarea  id="requisitionFrom" name="requisitionFrom" class="textareaMediua" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1"><%= reqForm%></textarea> 
  
<label>Crime No.</label>
<input type="text"   id="crimeNo" name="crimeNo" maxlength="16" value="<%= crimeNo%>" />
<label>Police station</label>
<textarea  id="policeStation" name="policeStation" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"><%= policeSt%></textarea>
  
<div class="clear"></div>
    
<label>Accompanied by (Name)</label>
<input type="text"   id="accompaniedByName" name="accompaniedByName" maxlength="90" value= "<%= byName%>"/>

<label>Accompanied by(Address)</label>
<textarea  id="accompaniedByAddress" name="accompaniedByAddress" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1"><%= byAddress%></textarea>

<div class="clear"></div>
	<label>Name</label>
	<input type="text"  readonly="readonly"  value="<%=name %>" id="pname" name="pname"/>    
    
    <label>Address</label>
	<input type="text"  readonly="readonly" id="address" name="address" value="<%=address%>"/>
    
    <label>Age</label>
    <input type="text"  id="age"  name="name" readonly="readonly" value="<%=age %>"/>
	
	 <input type="hidden"  id="gender"  name="gender" readonly="readonly"/>
	 <input type="hidden"  id="occupation"  name="occupation" readonly="readonly"/>
	 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly"/>

<div class="clear"></div>
 <label>Marital status</label>
  <select name="maritalStatus" id="maritalStatus" >
  <option value="">Select</option>
  <option value="Married">Married</option>
  <option value="Unmarried">Unmarried</option>
  </select>  
<label>Consent</label>
<textarea  id="consent" name="consent" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%= cosen%></textarea>
<label>Occupation</label>
  <input type="text"  id="occupation"  name="occupation" readonly="readonly" value="<%= ocupation%>" />
  
 <div class="clear"></div>
<label>Comm. of exam Date</label>
<input type="text" id="commencementOfExaminationDate" name="commencementOfExaminationDate" validate="Commencement of examination DateDate,date,no"  value="<%=examCommDate %>" class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.commencementOfExaminationDate,true);" />

<label>Comm. of exam Time</label>
<input type="text"   id="commencementOfExaminationTime" value="<%=examCommTime %>" name="commencementOfExaminationTime" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
<div class="clear"></div>
  <label>Id Mark 1</label>
 <textarea  id="identificationOne" name="identificationOne" class="textareaMediua"  maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1"><%= idMark1%></textarea>
  <label>Id Mark 2</label>
 <textarea  id="identificationTwo" name="identificationTwo" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%= idMark2%></textarea>
<div class="clear"></div>
 <h4>History related to gestation</h4> 
  <label>Menarche</label>
   <textarea  id="menarche" name="menarche" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=menstrualHistory %></textarea>
 
<div class="clear"></div>
<label>Date of last Menstrual</label>
<input type="text" id="menstrualDate" name="menstrualDate" validate="Menstrual Date,date,no"  value="<%=lastMenstrualDate %>" class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.menstrualDate,true);" />

<label>Time</label>
<input type="text" value="<%=MenstrualTime %>"  id="menstrualTime" name="menstrualTime" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>

<label>Antenatal checkup</label>
  <select name="checkup" id="checkup" >
  <%if(AntenatalCheckup.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Taken">Taken</option>
  <option value="Not Taken">Not Taken</option>
  <%}if(AntenatalCheckup.equalsIgnoreCase("Taken")){ %>
  <option value="">Select</option>
  <option value="Taken" selected="selected">Taken</option>
  <option value="Not Taken">Not Taken</option>
  <%}if(AntenatalCheckup.equalsIgnoreCase("Not Taken")){ %>
  
  <option value="">Select</option>
  <option value="Taken">Taken</option>
  <option value="Not Taken" selected="selected">Not Taken</option>
  <%} %>
  </select>
<div class="clear"></div>
 
   <label>Any other details</label>
<textarea rows="" cols="" name="anyOtherDetail" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=anyOtherDetail %></textarea>
   
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
  <%}if(build.equalsIgnoreCase("Good")){ %>
  <option value="">Select</option>
  <option value="Good" selected="selected">Good</option>
  <option value="Moderate">Moderate</option>
  <option value="Poor">Poor</option>
  <%}if(build.equalsIgnoreCase("Moderate")){ %>
  <option value="">Select</option>
  <option value="Good">Good</option>
  <option value="Moderate" selected="selected">Moderate</option>
  <option value="Poor">Poor</option>
  <%}if(build.equalsIgnoreCase("Poor")){ %>
  <option value="">Select</option>
  <option value="Good">Good</option>
  <option value="Moderate">Moderate</option>
  <option value="Poor" selected="selected">Poor</option>
  <%} %>
  </select>
  <div class="clear"></div>
  
  <label>Conjunctival pallor</label>
  <select name="conjunctivalPallor">
    <%if(Conjunctiva.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present">Not present</option>
    <%}if(Conjunctiva.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Not present">Not present</option>
    <%}if(Conjunctiva.equalsIgnoreCase("Not present")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present" selected="selected">Not present</option>
  <%} %>
  </select>
  <label>Breasts</label>
  <select name="breasts">
   <%if(Breasts.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
    <option value="">Select</option>
  <option value="Engorged">Engorged</option>
  <option value="Tender">Tender</option>
  <option value="Visibly full">Visibly full</option>
  <option value="Patulous">Patulous</option>
  
   <%}if(Breasts.equalsIgnoreCase("Engorged")){ %>
      <option value="">Select</option>
  <option value="Engorged" selected="selected">Engorged</option>
  <option value="Tender">Tender</option>
  <option value="Visibly full">Visibly full</option>
  <option value="Patulous">Patulous</option>
   <%}if(Breasts.equalsIgnoreCase("Tender")){ %>
      <option value="">Select</option>
  <option value="Engorged">Engorged</option>
  <option value="Tender" selected="selected">Tender</option>
  <option value="Visibly full">Visibly full</option>
  <option value="Patulous">Patulous</option>
   <%}if(Breasts.equalsIgnoreCase("Visibly full")){ %>
      <option value="">Select</option>
  <option value="Engorged">Engorged</option>
  <option value="Tender">Tender</option>
  <option value="Visibly full" selected="selected">Visibly full</option>
  <option value="Patulous">Patulous</option>
   <%}if(Breasts.equalsIgnoreCase("Patulous")){ %>
      <option value="">Select</option>
  <option value="Engorged">Engorged</option>
  <option value="Tender">Tender</option>
  <option value="Visibly full">Visibly full</option>
  <option value="Patulous" selected="selected">Patulous</option>
    <%} %>
  </select>
  <label>Areola of nipple</label>
  
  <select name="areolanipple">
   <%if(AreolaNippal.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Dark and prominent with Montgomerys tubercles">Dark and prominent with Montgomerys tubercles</option>
  <option value="pale and non-prominent and non-prominentnder">pale and non-prominent</option>
   <%}if(AreolaNippal.equalsIgnoreCase("Dark and prominent with Montgomerys tubercles")){ %>
    <option value="">Select</option>
  <option value="Dark and prominent with Montgomerys tubercles" selected="selected">Dark and prominent with Montgomerys tubercles</option>
  <option value="pale and non-prominent and non-prominentnder">pale and non-prominent</option>
   <%}if(AreolaNippal.equalsIgnoreCase("pale and non-prominent and non-prominentnder")){ %>
    <option value="">Select</option>
  <option value="Dark and prominent with Montgomerys tubercles">Dark and prominent with Montgomerys tubercles</option>
  <option value="pale and non-prominent and non-prominentnder" selected="selected">pale and non-prominent</option>
  <%} %>
    </select>
  <div class="clear"></div>
  
  <label>Nipple</label>
  <select name="nipple">
  <%if(Nippal.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Colostrum or milk could be expressed">Colostrum or milk could be expressed</option>
  <option value="Could not be expressed">Could not be expressed</option>
  <%}if(Nippal.equalsIgnoreCase("Colostrum or milk could be expressed")){ %>
  <option value="">Select</option>
  <option value="Colostrum or milk could be expressed"  selected="selected">Colostrum or milk could be expressed</option>
  <option value="Could not be expressed">Could not be expressed</option>
  <%}if(Nippal.equalsIgnoreCase("Could not be expressed")){ %>
  <option value="">Select</option>
  <option value="Colostrum or milk could be expressed">Colostrum or milk could be expressed</option>
  <option value="Could not be expressed" selected="selected">Could not be expressed</option>
  <%} %>  
  </select>    
      <label>Abdomen</label>
  <select name="abdomen">
   <%if(Abdomin.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Pendulous with wrinkled skin">Pendulous with wrinkled skin</option>
  <option value="Non pendulous with smooth skin">Non pendulous with smooth skin</option>  
  <%}if(Abdomin.equalsIgnoreCase("Pendulous with wrinkled skin")){ %>
 <option value="">Select</option>
  <option value="Pendulous with wrinkled skin" selected="selected">Pendulous with wrinkled skin</option>
  <option value="Non pendulous with smooth skin">Non pendulous with smooth skin</option>  
  <%}if(Abdomin.equalsIgnoreCase("Non pendulous with smooth skin")){ %>
 <option value="">Select</option>
  <option value="Pendulous with wrinkled skin">Pendulous with wrinkled skin</option>
  <option value="Non pendulous with smooth skin" selected="selected">Non pendulous with smooth skin</option>  
  <%} %>  
   
  </select>
   
    <label>Striae gravidarum</label>
  <select name="gravidarum">
 
  
    <% if(StriaeGravidarum.equalsIgnoreCase("")) {%>
   <option value="">Select</option>
  <option value="Present and reddish in color">Present and reddish in color</option>
  <option value="Present as healed scars">Present as healed scars</option>
  <option value="Absent">Absent</option>>
  <%} if(StriaeGravidarum.equalsIgnoreCase("Present and reddish in color")) {%>
  <option value="">Select</option>
  <option value="Present and reddish in color" selected="selected">Present and reddish in color</option>
  <option value="Present as healed scars">Present as healed scars</option>
  <option value="Absent">Absent</option>
    <%}if(StriaeGravidarum.equalsIgnoreCase("Present as healed scars")) {%>
   <option value="">Select</option>
  <option value="Present and reddish in color">Present and reddish in color</option>
  <option value="Present as healed scars" selected="selected">Present as healed scars</option>
  <option value="Absent">Absent</option>
   <%}if(StriaeGravidarum.equalsIgnoreCase("Absent")) {%>
   <option value="">Select</option>
  <option value="Present and reddish in color">Present and reddish in color</option>
  <option value="Present as healed scars">Present as healed scars</option>
  <option value="Absent" selected="selected">Absent</option>
  <%} %>  
  </select>
  <div class="clear"></div>   
  <div class="clear"></div>  
  <label>Uterus</label>
    <select name="uterus" id="uterus"  onchange="uterusText();" >
    <% if(uterus.equalsIgnoreCase("")) {%>
  <option value="">Select</option>
  <option value="Palpable per abdomen">Palpable per abdomen</option>
  <option value="Not palpable per abdomen">Not palpable per abdomen</option>
  <%} if(uterus.equalsIgnoreCase("Palpable per abdomen")) {%>
  <option value="">Select</option>
  <option value="Palpable per abdomen" selected="selected">Palpable per abdomen</option>
  <option value="Not palpable per abdomen">Not palpable per abdomen</option>  
  
  <%}if(uterus.equalsIgnoreCase("Not palpable per abdomen")) {%>
  <option value="">Select</option>
  <option value="Palpable per abdomen">Palpable per abdomen</option>
  <option value="Not palpable per abdomen" selected="selected">Not palpable per abdomen</option>  
  <%} %>  
  </select>
  
  
<div id="uterusDiv" style="display: none">
<textarea  id="uterusPalpable" name="uterusPalpable"  maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=uterusPalpable %></textarea>
</div>

        <script>
  	<%if(uterus.equalsIgnoreCase("Present")){%>
		document.getElementById("uterusDiv").style.display="inline";
	<%}else{%>
		document.getElementById('uterusPalpable').value=""; 
		document.getElementById("uterusDiv").style.display="none";
	<%}%>
  </script>
<div class="clear"></div>
<h4>Vagina</h4>
<label>Labia</label>
    <select name="labia" id="labia"   >
<%if(Labia.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Swollen">Swollen</option>
  <option value="Not swollen">Not swollen</option>
    <%}if(Labia.equalsIgnoreCase("Swollen")){ %>
  <option value="">Select</option>
  <option value="Swollen" selected="selected">Swollen</option>
  <option value="Not swollen">Not swollen</option>
    <%}if(Labia.equalsIgnoreCase("Not swollen")){ %>
  <option value="">Select</option>
  <option value="Swollen">Swollen</option>
  <option value="Not swollen" selected="selected">Not swollen</option>
 <%} %>
  </select>
     <label>Labial tenderness</label>
    <select name="tenderness" id="tenderness"   >
 <%if(LabialTenderness.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent">Absent</option>
    <%}if(LabialTenderness.equalsIgnoreCase("Present")){ %>
 <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
    <option value="Absent">Absent</option>
    <%}if(LabialTenderness.equalsIgnoreCase("Absent")){ %>
 <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent" selected="selected">Absent</option>
 <%} %>
  </select>
 <label>Injuries to labia</label>
    <select name="injuriesToLabia" id="injuriesToLabia"  onchange="injuriesToLabiaText();" >
 <%if(InjLabial.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent">Absent</option>
    <%}if(InjLabial.equalsIgnoreCase("Present")){ %>
 <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
    <option value="Absent">Absent</option>
    <%}if(InjLabial.equalsIgnoreCase("Absent")){ %>
 <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent" selected="selected">Absent</option>
 <%} %>
  </select>
    <div class="clear"></div>
    
  <div id="injuriesToLabiaDiv" style="display: none">
<textarea id="injuriesToLabiaPresent" name="injuriesToLabiaPresent" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=VaginaInjDetail %></textarea>
  
  </div>
  
        <script>
  	<%if(InjLabial.equalsIgnoreCase("Present")){%>
		document.getElementById("injuriesToLabiaDiv").style.display="inline";
	<%}else{%>
		document.getElementById('injuriesToLabiaPresent').value=""; 
		document.getElementById("injuriesToLabiaDiv").style.display="none";
	<%}%>
  </script>
  <label>Vagina</label>
    <select name="vagina" id="vagina"   >
      <%if(vagina.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Capacious and relaxed">Capacious and relaxed</option>
  <option value="Non-capacious with normal tone">Non-capacious with normal tone.</option>
    <%}if(vagina.equalsIgnoreCase("Capacious and relaxed")){ %>
  <option value="">Select</option>
  <option value="Capacious and relaxed" selected="selected">Capacious and relaxed</option>
  <option value="Non-capacious with normal tone">Non-capacious with normal tone.</option>
  
    <%}if(vagina.equalsIgnoreCase("Non-capacious with normal tone")){ %>
  <option value="">Select</option>
  <option value="Capacious and relaxed">Capacious and relaxed</option>
  <option value="Non-capacious with normal tone" selected="selected">Non-capacious with normal tone.</option>
  <%} %>
  </select>
 
 <label>Injuries to Vagina</label>
    <select name="injuriesToVagina" id="injuriesToVagina"  onchange="injuriesToVaginaText();" >
    <%if(injuriesInVagina.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent">Absent</option>
    <%}if(injuriesInVagina.equalsIgnoreCase("Present")){ %>
 <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
    <option value="Absent">Absent</option>
    <%}if(injuriesInVagina.equalsIgnoreCase("Absent")){ %>
 <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent" selected="selected">Absent</option>
 <%} %>
 
 
  </select>
   
  <div id="injuriesToVaginaDiv" style="display: none">
  <label>Injuries Deatil to Vagina</label>
<textarea id="injuriesToVaginaPresent" name="injuriesToVaginaPresent" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=InjDetailVagina %></textarea>
  
  </div>
  
      <script>
  	<%if(injuriesInVagina.equalsIgnoreCase("Present")){%>
		document.getElementById("injuriesToVaginaDiv").style.display="inline";
	<%}else{%>
		document.getElementById('injuriesToVaginaPresent').value=""; 
		document.getElementById("injuriesToVaginaDiv").style.display="none";
	<%}%>
  </script>
    <div class="clear"></div>
    <h4>Cervix</h4>
    
      <label>Cervical lips</label>
  <select name="cervical">
    
  <%if(CervicalLips.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Soft and swollen">Soft and swollen</option>
  <option value="Firm">Firm</option>
  <%}if(CervicalLips.equalsIgnoreCase("Soft and swollen")){ %>
 <option value="">Select</option>
  <option value="Soft and swollen">Soft and swollen</option>
  <option value="Firm" selected="selected">Firm</option>
     <%}if(CervicalLips.equalsIgnoreCase("Firm")){ %>
<option value="">Select</option>
  <option value="Soft and swollen">Soft and swollen</option>
  <option value="Firm" selected="selected">Firm</option>
   <%} %>
  </select>
  
  
  <label>Cervical mucus plug</label>
  <select name="cervicalMucusPlug">
    <%if(CervicalMucusPlug.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent">Absent</option>
    <%}if(CervicalMucusPlug.equalsIgnoreCase("Present")){ %>
 <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
    <option value="Absent">Absent</option>
    <%}if(CervicalMucusPlug.equalsIgnoreCase("Absent")){ %>
 <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent" selected="selected">Absent</option>
 <%} %>
  
  </select>
  <label>External Os</label>
  <select name="externalOs">
 <%if(ExternalOs.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Closed">Closed</option>
  <option value="Open">Open</option>
  <option value="Admits one finger">Admits one finger</option>
  <option value="Admits two fingers">Admits two fingers</option>
    <%}if(ExternalOs.equalsIgnoreCase("Closed")){ %>
    <option value="">Select</option>
  <option value="Closed" selected="selected">Closed</option>
  <option value="Open">Open</option>
  <option value="Admits one finger">Admits one finger</option>
  <option value="Admits two fingers">Admits two fingers</option>
    <%}if(ExternalOs.equalsIgnoreCase("Open")){ %>
    <option value="">Select</option>
  <option value="Closed">Closed</option>
  <option value="Open" selected="selected">Open</option>
  <option value="Admits one finger">Admits one finger</option>
  <option value="Admits two fingers">Admits two fingers</option>
   <%}if(ExternalOs.equalsIgnoreCase("Admits one finger")){ %>
    <option value="">Select</option>
  <option value="Closed">Closed</option>
  <option value="Open">Open</option>
  <option value="Admits one finger" selected="selected">Admits one finger</option>
  <option value="Admits two fingers">Admits two fingers</option>
    <%}if(ExternalOs.equalsIgnoreCase("Admits two fingers")){ %>
    <option value="">Select</option>
  <option value="Closed">Closed</option>
  <option value="Open">Open</option>
  <option value="Admits one finger">Admits one finger</option>
  <option value="Admits two fingers" selected="selected">Admits two fingers</option>
 <%} %>
  
 
  </select>
 
  <div class="clear"></div>
   
  <label>Injuries</label>
 <select name="injuries" id="injuries"  onchange="injuriesText();" >
 
  
   <%if(InjCervical.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent">Absent</option>
    <%}if(InjCervical.equalsIgnoreCase("Present")){ %>
 <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
    <option value="Absent">Absent</option>
    <%}if(InjCervical.equalsIgnoreCase("Absent")){ %>
 <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent" selected="selected">Absent</option>
 <%} %>
  </select>
    <div class="clear"></div>
    
  <div id="injuriesDiv" style="display: none">
<textarea id="injuriesPresent" name="injuriesPresent" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=CervixInjDetail %></textarea>  
  </div>
    <script>
  	<%if(InjCervical.equalsIgnoreCase("Present")){%>
		document.getElementById("injuriesDiv").style.display="inline";
	<%}else{%>
		document.getElementById('injuriesPresent').value=""; 
		document.getElementById("injuriesDiv").style.display="none";
	<%}%>
  </script>
  <label>Lochia discharge at Os</label>
   <select name="lochiaDischargeOs"  id="lochiaDischargeOs" onchange="lochiaDischargeOsText();" >
      <%if(LochiaDischarge.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present">Not present</option>
    <%}if(LochiaDischarge.equalsIgnoreCase("Present")){ %>
 <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Not present">Not present</option>
    <%}if(LochiaDischarge.equalsIgnoreCase("Not present")){ %>
 <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Not present" selected="selected">Not present</option>
 <%} %>
  </select>
       
  <div id="lochiaDischargeOsDiv" style="display: none">
  <select name="lochiaDischargeOsPresent"  id="lochiaDischargeOsPresent"  >
    <option value="">Select</option>
      <%if(LochiaDischargeDetail.equalsIgnoreCase("")){ %>
  <option value="Lochia rubra">Lochia rubra</option>
  <option value="Lochia serosa">Lochia serosa</option>
  <option value="Lochis alba">Lochis alba</option>
  <%} if(LochiaDischargeDetail.equalsIgnoreCase("Lochia rubra")){ %>
  
    <option value="">Select</option>
  <option value="Lochia rubra" selected="selected">Lochia rubra</option>
  <option value="Lochia serosa">Lochia serosa</option>
  <option value="Lochis alba">Lochis alba</option>
    <%} if(LochiaDischargeDetail.equalsIgnoreCase("Lochia serosa")){ %>
  
    <option value="">Select</option>
  <option value="Lochia rubra">Lochia rubra</option>
  <option value="Lochia serosa" selected="selected">Lochia serosa</option>
  <option value="Lochis alba">Lochis alba</option>
  
    <%} if(LochiaDischargeDetail.equalsIgnoreCase("Lochis alba")){ %>
    <option value="">Select</option>
  <option value="Lochia rubra">Lochia rubra</option>
  <option value="Lochia serosa">Lochia serosa</option>
  <option value="Lochis alba" selected="selected">Lochis alba</option>
  
  <%} %>
  
  </select>
  </div>
      <script>
  	<%if(LochiaDischargeDetail.equalsIgnoreCase("Present")){%>
		document.getElementById("lochiaDischargeOsDiv").style.display="inline";
	<%}else{%>
		document.getElementById('lochiaDischargeOsPresent').value=""; 
		document.getElementById("lochiaDischargeOsDiv").style.display="none";
	<%}%>
  </script>
  <div class="clear"></div>
  
     <label>Systemic examination findings</label>
  <textarea rows="" cols="" name="systemicexamination" maxlength="50"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=sys_examination_findings%></textarea>
      <div class="clear"></div>
      
  <h4>Laboratory examinations</h4>    
    <label>Urine for pregnancy test</label>
  <select name="pregnancy"  id="pregnancy"  >
  <%if(Urinated.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Positive">Positive</option>
  <option value="Negative">Negative</option>
  <%}if(Urinated.equalsIgnoreCase("Positive")) {%>
   <option value="">Select</option>
  <option value="Positive" selected="selected">Positive</option>
  <option value="Negative">Negative</option>  
  <%}if(Urinated.equalsIgnoreCase("Negative")) {%>
  
   <option value="">Select</option>
  <option value="Positive" >Positive</option>
  <option value="Negative" selected="selected">Negative</option>  
  <%} %>  
  </select>
<label>USG Abdomen (Optional)</label>
<textarea rows="" cols="" name="usgAbdomen" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=UsgAbdomen %></textarea>
<label>Any other</label>
<textarea rows="" cols="" name="anyOther" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=anyOtherDetail %></textarea>
<div class="clear"></div>

<label>OPINION</label>
<textarea  id="opinion" name="opinion" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1"><%=opNion%></textarea>   

<div class="clear"></div>
<div id="edited"></div>

 <% if(meDetails.size()==0) {%>
 <input type="button" name="add" id="addbutton" value="Submit" 	class="button"	onClick="submitForm('mlc','mlc?method=addExamOfEvidenceOfRecentDelivery&flag=submit');"	accesskey="a" tabindex=1 />
 <% }else{ %>
 <input type="button" name="add" id="addbutton" value="Authorization" 	class="button"	onClick="submitForm('mlc','mlc?method=addExamOfEvidenceOfRecentDelivery&flag=authorization');"	accesskey="a" tabindex=1 />
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


