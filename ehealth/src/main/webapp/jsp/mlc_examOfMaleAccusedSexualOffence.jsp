<%@page import="jkt.hms.masters.business.MlcMaterialObjects"%>
<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
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

function validateBpValue(obj){
	var bpObj = document.getElementById('bp');
	 var bool =validateBpWithSlash(obj)
	if(bool)
	{

	if(obj != ""){
	var index=obj.indexOf('/');
	if(index != 3){
		 alert("BP should be in max/min Format.")
		 bpObj.value="";
		 bpObj.focus();
		 return false;
		 }


		 var pairs2 = obj.substring(0,obj.length).split('/');
		 if (pairs2.length!=2) {
			 alert("Invalid  Format.")
			return false;
			}

		val3=eval(pairs2[0]);
		if (val3>240) {
		  alert("Maximum BP should be less than 240.")
		 return false;}

		val2=eval(pairs2[1]);
		if (val2<60 ) {
		  alert("Minimum BP should be greater than 60")
		  return false;}


	}
	return true;
	}
	bpObj.value="";
	bpObj.focus();
	return false;
	}
	function validateBpWithSlash(strValue){
		if(strValue != ""){
		var objRegExp = /^(\d{1,}[\/]\d*)$/
		obj =  objRegExp.test(strValue);
		if(!obj){
			alert("BP is not having Valid Value.");
			return false;
		}
		return true;
	  }
	}
function clinicalHistoryPresentText(){	
if(document.getElementById("clinicalHistory").value=='Present'){
	document.getElementById("clinicalHistoryDiv").style.display="inline";
}else{
	document.getElementById("clinicalHistoryDiv").style.display="none";
}
	
}
function diseasePresentText(){	
	if(document.getElementById("disease").value=='Present'){
		document.getElementById("diseaseDiv").style.display="inline";
	}else{
		document.getElementById("diseaseDiv").style.display="none";
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
String address="";

int pinCode=0;
if(map.get("pinCode")!=null){
	pinCode=(Integer)map.get("pinCode");
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
//String address="";
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
	  String reqFormMed="";
	  String  reqTime="";
	  String reqDate="";
	  String  stamBy="";
	  String  detInj="";
	  int addiTion=0;
	  String  opNion="";
	  String reasonForConclusion="";
	  String agemarry="";
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
	  int pulse=0;
	  String bp ="";
	  int pulseOpd=0;
	  String bpOpd ="";
	  String otherHistory="";
	  String injBody="";
	  String byName="";
	String byAddress="" ;
	String recDate="";
	String refDate="";
	String recTime="";
	String examCommTime="";
	String examCommDate="";
	int inpationId=0;
	String clinicalHistory="";
	String clinicalHistoryPresent="";
	String reflexes="";
	String developmentOfTestis="";
String maritalHistory="";
String whetherHavingChildren="";
String build="";
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
 int circumference=0;
if(mlcList.size()>0){
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
			 
			 if(mlc.getOpdPatientDetail().getPulse()!=null){
					pulseOpd=mlc.getOpdPatientDetail().getPulse();
						  }
			 if(mlc.getOpdPatientDetail().getBp()!=null){
					bpOpd=mlc.getOpdPatientDetail().getBp();
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
	for(PatientAddress pa:patientAddress){
		
		  if(pa.getDistrict()!=null){
			  address= pa.getDistrict().getDistrictName();  
		  }
		  if(pa.getWardName()!=null){
			  address=address+" \n "+ pa.getWardName();  
		  }
		  if(pa.getHouseNo()!=null){
			  address=address+" \n  "+pa.getHouseNo();  
		  }
		  if(pa.getLsgHouseNo()!=null){
			  address=address+" \n  "+pa.getLsgHouseNo();  
		  }
		  if(pa.getLsgName()!=null){
			  address=address+" \n  "+pa.getLsgName().getLsgTypeName();  
		  }
		  if(pa.getPostOffice()!=null){
			  address=address+" \n  "+pa.getPostOffice().getPostCodeName();  
		  }
		  if(pa.getPinCode()!=null){
			  address=address+" \n  "+pa.getPostOffice().getPinCode();  
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
	  plength=legalDetails.getPlength()!=null ?legalDetails.getPlength() :0;
	  circumference=legalDetails.getCircumference()!=null ?legalDetails.getCircumference() :0;
	  addiTion=legalDetails.getNoOfAdditionalSheets()!=null ? legalDetails.getNoOfAdditionalSheets():0;
	  idMark1=legalDetails.getIdMark1()!=null ?legalDetails.getIdMark1() :"";
	  idMark2=legalDetails.getIdMark2()!=null ?legalDetails.getIdMark2() :"";
	  policeSt=legalDetails.getPoliceStation()!=null ?legalDetails.getPoliceStation():"";
	  witt1= legalDetails.getWitnesses1()!=null ?legalDetails.getWitnesses1():"";
	  witt2= legalDetails.getWitnesses2()!=null ?legalDetails.getWitnesses2():"";
	  dieases=legalDetails.getTestisDiseaseInjury()!=null ?legalDetails.getTestisDiseaseInjury():"";
	  reqFormMed=legalDetails.getReceivedFrom()!=null ?legalDetails.getReceivedFrom():"";
	  cosen=legalDetails.getConsent()!=null ?legalDetails.getConsent():"";
	   bp=legalDetails.getBp()!=null ?legalDetails.getBp():"";
	  opNion=legalDetails.getOpinion()!=null ?legalDetails.getOpinion():"";
	  reasonForConclusion=legalDetails.getReasonForConclusion()!=null ?legalDetails.getReasonForConclusion():"";
	  pulse=legalDetails.getPulse()!=0 ?legalDetails.getPulse():0;
	  boughtBy=legalDetails.getBroughtBy()!=null?legalDetails.getBroughtBy():"";
	  boughtAddress=legalDetails.getBroughtByAddress()!=null?legalDetails.getBroughtByAddress():"";
	  histInj=legalDetails.getHistoryInjuryCause()!=null?legalDetails.getHistoryInjuryCause():"";
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
	   otherHistory=legalDetails.getFindings()!=null?legalDetails.getFindings():"";
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
    clinicalHistory=legalDetails.getClinicalHistory()!=null ? legalDetails.getClinicalHistory():"";
    clinicalHistoryPresent=legalDetails.getHistoryOfIllness()!=null ? legalDetails.getHistoryOfIllness():"";
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
    		 scrotum =legalDetails.getScrotum()!=null ? legalDetails.getScrotum():"";
    		 rightTestis =legalDetails.getRightTestis()!=null ? legalDetails.getRightTestis():"";
    		 leftTestis=legalDetails.getLeftTestis()!=null ? legalDetails.getLeftTestis():"";
} 
}
}
for(OpdPatientHistory history:patientHistories){
	  couInj= history.getPresentComplaintHistory(); 
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
<!-- <input name="uhinId" id="uhinId" validate="UHID,string,yes"  onblur="patientList(this.value,'mlc','Male Accused');"> --> 
<input name="uhinId" id="uhinId" validate="UHID,string,yes"  value="<%= hinNo%>" readonly="readonly">
 <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
  <input type="hidden"  name="hinId"   value="<%= hinId%>"/>
   <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
   <input type="hidden" name="mediCoId" id="mediCoId"  value="<%= mediCoId%>">
</div>
<div class="titleBg">
<h2>Examintion of a male accused in sexual offence(including Potency)</h2>
</div>
<div class="Block">
<div class="clear"></div>
	
<label>Ref No.<span>*<span></label>

 <%if(mediCoId!=0){%>
<input type="text"   id="refMLNo" name="refMLNo"  validate="Ref No,String,Yes" value ="<%= srNo%>" maxlength="16" readonly="readonly"/>
 <%}else{ %>
 <input type="text"   id="refMLNo" name="refMLNo"  validate="Ref No,String,Yes" value ="<%= orderNo%>" maxlength="16" readonly="readonly"/>
 <%}%>

<label>Ref.Date</label>
<input type="text" id="refMLDate" name="refMLDate" validate="Ref Date,date,no" class="date" value="<%=refDate %>"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />

	
<label>Requisition Date</label>
<input type="text" id="requisitionDate" name="requisitionDate" validate="Requisition Date,date,no" value="<%=reqDate %>" class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.requisitionDate,true);" />

<div class="clear"></div>

<label>Received Date</label>
<input type="text" id="receivedDate" name="receivedDate" validate="Received Date,date,no"  class="date" value="<%=recDate %>"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.receivedDate,true);" />


<label>Received Time</label>
<input type="text"   id="receivedTime" value="<%= recTime%>"   name="receivedTime" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>


<label>Received From</label>
<%if(mediCoId!=0) {%>
<textarea  id="receivedFrom" name="receivedFrom" class="textareaMediua" maxlength="90"  onkeyup="return ismaxlength(this)"><%= reqFormMed%></textarea>
<%}else{ %>
<textarea  id="receivedFrom" name="receivedFrom" class="textareaMediua" maxlength="90"  onkeyup="return ismaxlength(this)"><%= reqForm%></textarea>
<%} %>



<div class="clear"></div>
	<label>Name</label>
	<input type="text"  readonly="readonly" id="pname" name="pname" value="<%= name%>"/>
    
    
    <label>Address</label>
    <%if(pinCode==0){ %>
	<input type="text"  readonly="readonly" id="address" name="address" value="<%=address%>"/>
    <%}else{ %>
    <input type="text"  readonly="readonly" id="address" name="address" value="<%=address%><%=pinCode%>"/>
    <%} %>
    <label>Age</label>
    <input type="text"  id="age"  name="name" readonly="readonly" value="<%= age%>"/>
	
	 <input type="hidden"  id="gender"  name="gender" readonly="readonly"/>
	 <input type="hidden"  id="occupation"  name="occupation" readonly="readonly"/>
	 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly"/>
    <div class="clear"></div>
  
    
    <label>Crime No.</label>
<input type="text"   id="crimeNo" name="crimeNo" maxlength="16" value ="<%=crimeNo %>";/>


 <label>Police station</label>
<textarea  id="policeStation" name="policeStation" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)"><%= policeSt%></textarea>

   <div class="clear"></div>
    
<label>Accompanied by (Name)</label>
<input type="text"   id="accompaniedByName" name="accompaniedByName" maxlength="96" value ="<%= byName%>"/>

<label>Accompanied by(Address)</label>
<textarea  id="accompaniedByAddress" name="accompaniedByAddress" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)"><%= byAddress%></textarea>

<label>Consent</label>
<textarea  id="consent" name="consent" class="textareaMediua" maxlength="90"  onkeyup="return ismaxlength(this)"><%= cosen%></textarea>


<div class="clear"></div>
<label>Comm. of exam Date</label>
<input type="text" id="commencementOfExaminationDate" name="commencementOfExaminationDate" value="<%=examCommDate %>" validate="Commencement of examination DateDate,date,no"  class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.commencementOfExaminationDate,true);" />



<label>Comm. of exam Time</label>
<input type="text" id="commencementOfExaminationTime" name="commencementOfExaminationTime"  value="<%=examCommTime %>"  onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>

 <label>Id Mark 1</label>
 <textarea  id="identificationOne" name="identificationOne" class="textareaMediua" maxlength="90"  onkeyup="return ismaxlength(this)"><%= idMark1%></textarea>
 
  <div class="clear"></div>
 <label>Id Mark 2</label>
 <textarea  id="identificationTwo" name="identificationTwo" class="textareaMediua" maxlength="90"  onkeyup="return ismaxlength(this)"><%=  idMark2%></textarea>
 
  <label>Clinical History</label>
  <select name="clinicalHistory" id="clinicalHistory"  onchange="clinicalHistoryPresentText();">
  <%if(clinicalHistory.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present" >Present</option>
  <option value="Not present">Not present</option>
  <%}else if(clinicalHistory.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Not present">Not present</option>
     <%}else if(clinicalHistory.equalsIgnoreCase("Not present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Not present" selected="selected">Not present</option>
  <%} %>
  </select>
  
  <div id="clinicalHistoryDiv" style="display: none">
  <%if(!clinicalHistory.equalsIgnoreCase("") || clinicalHistory.equalsIgnoreCase("Present")){ %>
  <textarea  id="clinicalHistoryPresent" name="clinicalHistoryPresent" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)"><%=clinicalHistoryPresent %></textarea>
  <%}else{ %>
  <textarea  id="clinicalHistoryPresent" name="clinicalHistoryPresent" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)"><%=couInj %></textarea>
 <%} %>
  </div>
  
  <script>
  	<%if(clinicalHistory.equalsIgnoreCase("Present")){%>
		document.getElementById("clinicalHistoryDiv").style.display="inline";
	<%}else{%>
		document.getElementById('clinicalHistoryPresent').value=""; 
		document.getElementById("clinicalHistoryDiv").style.display="none";
	<%}%>
  </script>
 <div class="clear" style="margin:5px 0px"></div>
 
 <label>History Sesexual Devlop.</label>
 <textarea  id="historyOfSexualDevelopment" name="historyOfSexualDevelopment" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)"><%= sexUalDev%></textarea>
 
    <label>Marital History</label>
  <select name="maritalHistory" id="maritalHistory" >
    <%if(maritalHistory.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Married">Married</option>
  <option value="Unmarried">Unmarried</option>
    <%}else if(maritalHistory.equalsIgnoreCase("Married")){ %>
  <option value="">Select</option>
  <option value="Married" selected="selected">Married</option>
  <option value="Unmarried.">Unmarried</option>
  <%}else if(maritalHistory.equalsIgnoreCase("Unmarried")){ %>
  <option value="">Select</option>
  <option value="Married">Married</option>
  <option value="Unmarried" selected="selected">Unmarried</option>
  <%} %>
  </select>
  
  <label>Age of marriage (yrs)</label>
  <input type="text"   id="ageOfMarriage" name="ageOfMarriage" maxlength="8" value= "<%= agemarry%>"/>
  
   <div class="clear"></div>
  
   <label>Children</label>
  <select name="whetherHavingChildren" id="whetherHavingChildren"  >

  <%if(whetherHavingChildren.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  
  <%}else if(whetherHavingChildren.equalsIgnoreCase("Yes")){ %>
   <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>
  
  <%}else if(whetherHavingChildren.equalsIgnoreCase("No")){ %>
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No" selected="selected">No</option>
  <%} %>
  </select>
 
  
  <label>History/alleged injury</label>
  <input type="text" name="historyAndAllegedCauseOfInjury" value= "<%= histInj%>">
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
  
  <label>Hair</label>
    <select name="hair" id="hair">
  
  <%if(hair.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Normal Adolescent male">Normal Adolescent male</option>
  <option value="Adult male type of hair growth on face & body Present">Adult male type of hair growth on face & body Present</option>
  <option value="Absent">Absent</option>
  
  <%}else if(hair.equalsIgnoreCase("Normal Adolescent male")){ %>
    <option value="">Select</option>
  <option value="Normal Adolescent male" selected="selected">Normal Adolescent male</option>
  <option value="Adult male type of hair growth on face & body Present">Adult male type of hair growth on face & body Present</option>
  <option value="Absent">Absent</option>
  
  <%}else if(hair.equalsIgnoreCase("Adult male type of hair growth on face & body Present")){ %>
   <option value="">Select</option>
  <option value="Normal Adolescent male">Normal Adolescent male</option>
  <option value="Adult male type of hair growth on face & body Present" selected="selected">Adult male type of hair growth on face & body Present</option>
  <option value="Absent">Absent</option>
    
  <%}else if(hair.equalsIgnoreCase("Absent")){ %>
   <option value="">Select</option>
  <option value="Normal Adolescent male">Normal Adolescent male</option>
  <option value="Adult male type of hair growth on face & body Present">Adult male type of hair growth on face & body Present</option>
  <option value="Absent" selected="selected">Absent</option>
  
  <%} %>
  </select>
  <div class="clear"></div>
    <h4>Local</h4>
   <label>Penis</label>
    <select name="penis" id="penis"  >
 <%if(penis.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(penis.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(penis.equalsIgnoreCase("Absent")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent" selected="selected">Absent</option>
  <%} %>
  </select>
  
    <label>Length </label>
  <input type="text" name="length" validate="Length,int,no" maxlength="3" value="<%=plength%>">

  <label>Circumference </label>
   <input type="text" name="circumference" validate="Circumference,int,no" maxlength="3" value="<%=circumference%>">
  
    <div class="clear"></div>
    
    <label>Disease /Deformity / Injury</label>
    
   <select name="disease" id="disease"   onchange="diseasePresentText();">
  <%if(disease.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(disease.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(disease.equalsIgnoreCase("Absent")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent" selected="selected">Absent</option>
  <%} %>
  </select>
  
    <div id="diseaseDiv" style="display: none">
      
 <textarea   id="diseasePresent" name="diseasePresent" maxlength="1000"  onkeyup="return ismaxlength(this)"><%=diseasePresent %></textarea>
 

   
  </div>  
    <script>
  	<%if(disease.equalsIgnoreCase("Present")){%>
		document.getElementById("diseaseDiv").style.display="inline";
	<%}else{%>
	document.getElementById("diseasePresent").value="";
		document.getElementById("diseaseDiv").style.display="none";
	<%}%>
  </script>
    <div class="clear"></div>
  <label>Fore skin</label>

     <select name="skin" id="skin"   >
  <%if(skin.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Retractable">Retractable</option>
  <option value="Non retractable">Non retractable</option>
  <option value="Circumcised">Circumcised</option>

  <%}else if(skin.equalsIgnoreCase("Retractable")){ %>
  <option value="">Select</option>
   <option value="Retractable" selected="selected">Retractable</option>
  <option value="Non retractable">Non retractable</option>
  <option value="Circumcised">Circumcised</option>

  <%}else if(skin.equalsIgnoreCase("Non retractable")){ %>
  <option value="">Select</option>
  <option value="Retractable">Retractable</option>
  <option value="Non retractable" selected="selected">Non retractable</option>
  <option value="Circumcised">Circumcised</option>


    <%}else if(skin.equalsIgnoreCase("Circumcised")){ %>
  <option value="">Select</option>
  <option value="Retractable">Retractable</option>
  <option value="Non retractable">Non retractable</option>
  <option value="Circumcised" selected="selected" >Circumcised</option>

  <%} %>
  </select>
  
  
  <label class="auto" style="padding:0px 12px 0px 5px;">Smegma deposits on corona</label>
   
     <select name="smegmaDeposits" id="smegmaDeposits"  >
 <%if(smegmaDeposits.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(smegmaDeposits.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(smegmaDeposits.equalsIgnoreCase("Absent")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent" selected="selected">Absent</option>
  <%} %>
  </select>
  
   <label>Sensations</label>

     <select name="sensations" id="sensations"  >
 <%if(sensations.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(sensations.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(sensations.equalsIgnoreCase("Absent")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent" selected="selected">Absent</option>
  <%} %>
  </select>
  
   <label>Discharge and Tenderness</label>

     <select name="urethralDischarge" id="urethralDischarge"  >
 <%if(urethralDischarge.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(urethralDischarge.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(urethralDischarge.equalsIgnoreCase("Absent")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent" selected="selected">Absent</option>
  <%} %>
  </select>
  
  <div class="clear"></div>
  
     <label>Scrotum</label>
  
     <select name="scrotum" id="scrotum"  >
    
    <%if(scrotum.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Pendulous">Pendulous</option>
  <option value="Non pendulous">Non pendulous</option>
  <%}else if(scrotum.equalsIgnoreCase("Pendulous")){ %>
  <option value="">Select</option>
  <option value="Pendulous" selected="selected">Pendulous</option>
  <option value="Non pendulous">Non pendulous</option>
  <%}else if(scrotum.equalsIgnoreCase("Non pendulous")){ %>
  <option value="">Select</option>
  <option value="Pendulous">Pendulous</option>
  <option value="Non pendulous" selected="selected">Non pendulous</option>
  <%} %>
  </select>
  
  
  <label>Right testis</label>
   
     <select name="rightTestis" id="rightTestis"  >
    <%if(rightTestis.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(rightTestis.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(rightTestis.equalsIgnoreCase("Absent")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent" selected="selected">Absent</option>
  <%} %>
  </select>
  
    <label>Left testis</label>
  
     <select name="leftTestis" id="leftTestis"  >
        <%if(leftTestis.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(leftTestis.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Absent">Absent</option>
  <%}else if(leftTestis.equalsIgnoreCase("Absent")){ %>
  <option value="">Select</option>
  <option value="Present">Present</option>
  <option value="Absent" selected="selected">Absent</option>
  <%} %>
  </select>
    <div class="clear"></div>
   <label>Development of testis</label>
  
     <select name="developmentOfTestis" id="developmentOfTestis"  >
     <%if(developmentOfTestis.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Small">Small</option>
  <option value="Medium">Medium</option>
  <option value="Adult size">Adult size</option>
  <%}else if(developmentOfTestis.equalsIgnoreCase("Small")){ %>
  <option value="">Select</option>
  <option value="Small" selected="selected">Small</option>
  <option value="Medium">Medium</option>
  <option value="Adult size">Adult size</option>
  
  <%}else if(developmentOfTestis.equalsIgnoreCase("Medium")){ %>
  <option value="">Select</option>
  <option value="Small">Small</option>
  <option value="Medium" selected="selected">Medium</option>
  <option value="Adult size">Adult size</option>
  
  <%}else if(developmentOfTestis.equalsIgnoreCase("Adult size")){ %>
  <option value="">Select</option>
  <option value="Small">Small</option>
  <option value="Medium">Medium</option>
  <option value="Adult size" selected="selected">Adult size</option>
  
  <%} %>
  </select>
  
    <label>Sensations & Reflexes</label>
  
     <select name="sensationsReflexes" id="sensationsReflexes"  >
     <%if(reflexes.equalsIgnoreCase("")){ %>
  <option value="">Select</option>
  <option value="Normal">Normal</option>
  <option value="Impaired">Impaired</option>
  <%}else if(reflexes.equalsIgnoreCase("Normal")){ %>
  <option value="">Select</option>
  <option value="Normal" selected="selected">Normal</option>
  <option value="Impaired">Impaired</option>
  <%}else if(reflexes.equalsIgnoreCase("Impaired")){ %>
  <option value="">Select</option>
  <option value="Normal">Normal</option>
  <option value="Impaired" selected="selected">Impaired</option>
  <%} %>
  </select>
  
   <label>Disease /Deformity / Injury</label>
    <textarea   id="diseaseDeformity" name="diseaseDeformity" class="textareaMediua"  maxlength="120"  onkeyup="return ismaxlength(this)"><%=dieases %></textarea>    
      
  <div class="clear"></div>
    <h4>Systemic examination</h4>
    
      <label>Pulse </label>
      <%if(mediCoId!=0){ %>
  <input type="text" name="pulse" validate="Pulse,flat,no" maxlength="6" value= "<%=pulse%>">
  <%}else{ %>
  <input type="text" name="pulse" validate="Pulse,flat,no" maxlength="6" value= "<%=pulseOpd%>">
  <%} %>

  <label>BP</label>
  <%if(mediCoId!=0){ %>
  <input name="bp" type="text" onblur="validateBpValue(this.value);" id="bp" maxlength="10" value= "<%= bp%>"/>
  <%}else{ %>
  <input name="bp" type="text" onblur="validateBpValue(this.value);" id="bp" maxlength="10" value= "<%= bpOpd%>"/>
  <%} %>
  <label>Other findings</label>
    <textarea   id="otherFindings" name="otherFindings" class="textareaMediua"  maxlength="120"  onkeyup="return ismaxlength(this)"><%= otherHistory%></textarea>    
  
    <div class="clear"></div>
    <h4>Injuries</h4>
    
    <label>Injuries On the body if any</label>
    <textarea id="injuries" name="injuries" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)"><%= injBody%></textarea>
    
    <label>Exam concluded Date</label>
    <input type="text" id="examinationConcludedDate" name="examinationConcludedDate" value="<%=examinDate %>" validate="Examination concluded Date,date,no"  class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.examinationConcludedDate,true);" />
   
<label>Time</label>
<input type="text" name="examConcludedTime"  value="<%=examinTime %>" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>    
</div>
<div class="Block">
<table width="600" cellspacing="0" cellpadding="0" border="0" style="width:500px; float:left; margin-left:5px; border:1px solid #c0c0c0;">


<tr>
<th>Select</th>
    <th>Material objects preserved</th>
    
  <%int inc = 1; %>
  </tr>
  <td><input type="checkbox" name="slNo1" id="slNo1" value="y"></td>
  <td> <input type="hidden" name="materialObjects1" id="aa" class="radioCheckCol2" value="Nail clippings"> Nail clippings </td>
  </tr>
  <tr>
 <td><input type="checkbox" name="slNo2" id="slNo2" value="y"></td>
   <td><input type="hidden" name="materialObjects2" id="aa" class="radioCheckCol2" value="Penile Swabs taken with cotton just wetted in water & shade dried (to look for vaginal epithelial cells & for DNA profiling)">
    Penile Swabs taken with cotton just wetted in water & shade dried (to look for vaginal epithelial cells & for DNA profiling)
    </td>
    
  </tr>
  <tr>
  <td><input type="checkbox" name="slNo3" id="slNo3" value="y"></td>
     <td><input type="hidden" name="materialObjects3" id="aa" class="radioCheckCol2" value="Pubic hairs (cut)">Pubic hairs (cut)</td>
   </tr>
 <tr>
 <td><input type="checkbox" name="slNo4" id="slNo4" value="y"></td>
 <td><input type="hidden" name="materialObjects4" id="aa" class="radioCheckCol2" value="Scalp Hair (cut) sample">Scalp Hair (cut) sample</td>
 
  </tr>
  <tr>
 <td><input type="checkbox" name="slNo5" id="slNo5" value="y"></td>
   <td><input type="hidden" name="materialObjects5" id="aa" class="radioCheckCol2" value="Penile washings in normal saline">Penile washings in normal saline</td>
   
  </tr>
  <tr>
 <td><input type="checkbox" name="slNo6" id="slNo6" value="y"></td>
    <td><input type="hidden" name="materialObjects6" id="aa" class="radioCheckCol2" value="Others if any">Others if any</td>
  </tr>
  <tr>
 <td><input type="checkbox" name="slNo7" id="slNo7" value="y"></td>
   <td><input type="hidden" name="materialObjects7" id="aa" class="radioCheckCol2" value="Pubic hair combings">Pubic hair combings</td>
  </tr>
  <tr>
 <td><input type="checkbox" name="slNo8" id="slNo8" value="y"></td>
    
    <td><input type="hidden" name="materialObjects8" id="aa" class="radioCheckCol2" value="Blood for DNA profiling">Blood for DNA profiling </td>
  </tr>
  
  

 </table>
 <input    type="hidden" name="hdb" id="hdb"    value="<%=8%>" /> 
<div class="clear" style="margin:10px 0px"></div> 

<div class="clear"></div>

<label>Opinion</label>
<textarea  id="opinion" name="opinion" class="textareaMediua"  maxlength="250"  onkeyup="return ismaxlength(this)"><%= opNion%></textarea>

<label>Resons for conclusions</label>
<textarea  id="reasonForConclusion" name="reasonForConclusion" class="textareaMediua" maxlength="510"  onkeyup="return ismaxlength(this)"><%=reasonForConclusion %></textarea>
<div class="clear"></div>
<div id="edited"></div>
 <% if(meDetails.size()==0) {%>
 <input type="button" name="add" id="addbutton" value="Submit" class="button"	onClick="submitForm('mlc','mlc?method=addExamOfMaleAccusedSexualOffence&flag=submit');" accesskey="a" tabindex=1 /> 
 <% }else{ %>
 <input type="button" name="authorization" id="authorization" value="Authorization" class="button"	onClick="submitForm('mlc','mlc?method=addExamOfMaleAccusedSexualOffence&flag=authorization');" accesskey="a" tabindex=1 /> 
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

<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Nail clippings")){ %>

document.getElementById('slNo1').checked = true;

<%} %>

<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Penile Swabs taken with cotton just wetted in water & shade dried (to look for vaginal epithelial cells & for DNA profiling)")){ %>
document.getElementById('slNo2').checked = true;

<%} %>

<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Pubic hairs (cut)")){ %>
document.getElementById('slNo3').checked = true;
<%} %>

<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Scalp Hair (cut) sample")){ %>
document.getElementById('slNo4').checked = true;
<%} %>
<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Penile washings in normal saline")){ %>
document.getElementById('slNo5').checked = true;
<%} %>
<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Others if any")){ %>
document.getElementById('slNo6').checked = true;
<%} %>


<%if(materialObjects.getMaterialObjects().equalsIgnoreCase("Pubic hair combings")){ %>
document.getElementById('slNo7').checked = true;
<%} %>


<% if(materialObjects.getMaterialObjects().equalsIgnoreCase("Blood for DNA profiling")) {%>
document.getElementById('slNo8').checked = true;
<%} %>


 	
 	<%}}%>

 	
 	
</script>
