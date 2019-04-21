<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
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
	serverdate = '<%=date+"/"+month+"/"+year%>';
</script>
	<% 
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
String orderNo = "";
if(map.get("orderNo") != null){
	orderNo = (String)map.get("orderNo");
}

List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();

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
String hinNo="";
String name="";
String age="";
String gender="";
String address="";
int detailId=0;
int hinId=0;

//-----------
String srNo="";
String examinDate="";
String exaTime="";
String idMark1="";
String idMark2="";
String policeSt="";

String examination_time="";
String  reqForm="";
String  reqTime="";
String  reqDate="";


int addiTion=0;
String  opNion="";
String injDetail="";
String  his="";
String  crimeNo="";
String  cosen="";

String otherHistory="";
String bp="";
String byName="";
String byAddress="" ;
Date actDate=new Date();
int pulse= 0;
String arrest_time="";

String penis="";
String injury_on_body="";
int inpationId=0;
int mediCoId=0;
String AdNo="";
String UnderArrest="";
String RequisitionFrom="";
String ArrestTime="";
String ExaminationTime="";
String  HistoryAlcoholConsumption="";
String HistoryOfIllness="";
String AlcoholSmell="";
String Breath="";
String Clothing="";
String GeneralDisposition="";
String Speech="";
String Conjunctiva="";
String Pupils="";
String SelfControl="";
String Memory="";
String Orientation="";
String ReactionTime="";
String Gait="";
int  Pulse=0;
String Bp="";
String FingerNoseTest="";
String RombergsSign="";
String InjuryDetails="";
String BloodExamination="";
String Urinated="";
String Reflexes="";
String ArrestDate="";
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



for(MedicoLegalDetails legalDetails:meDetails){
	 mediCoId=legalDetails.getId();
	  srNo= legalDetails.getSerialNo()!=null ? legalDetails.getSerialNo():"";
	  crimeNo=legalDetails.getCrimeNo()!=null ?legalDetails.getCrimeNo():"";
	  examinDate=legalDetails.getExaminationDate()!=null ? HMSUtil.convertDateTypeToStringWithoutTime(legalDetails.getExaminationDate())  :"";
	  addiTion=legalDetails.getNoOfAdditionalSheets()!=null ? legalDetails.getNoOfAdditionalSheets():0;
	  idMark1=legalDetails.getIdMark1()!=null ?legalDetails.getIdMark1() :"";
	  idMark2=legalDetails.getIdMark2()!=null ?legalDetails.getIdMark2() :"";
	  policeSt=legalDetails.getPoliceStation()!=null ?legalDetails.getPoliceStation():"";
	  examination_time=legalDetails.getExaminationTime()!=null ?legalDetails.getExaminationTime():"";
	  reqForm=legalDetails.getRequisitionFrom()!=null ?legalDetails.getRequisitionFrom():"";
	  cosen=legalDetails.getConsent()!=null ?legalDetails.getConsent():"";
	  opNion=legalDetails.getOpinion()!=null ?legalDetails.getOpinion():"";
	 injDetail=legalDetails.getInjuryDetails()!=null?legalDetails.getInjuryDetails():"";
	  his=legalDetails.getPhysicalExamination()!=null?legalDetails.getPhysicalExamination():"";
	   otherHistory=legalDetails.getOtherHistory()!=null?legalDetails.getOtherHistory():"";
	  bp=legalDetails.getBp()!=null?legalDetails.getBp():"";
		byName=legalDetails.getAccompByName()!=null?legalDetails.getAccompByName():"";
	byAddress=legalDetails.getAccompByAddress()!=null?legalDetails.getAccompByAddress():"";
  reqTime=legalDetails.getRequisitionTime()!=null?legalDetails.getRequisitionTime():"";

  reqDate=legalDetails.getRequisitionDate()!=null ? HMSUtil.convertDateTypeToStringWithoutTime(legalDetails.getRequisitionDate())  :"";
 
  if(legalDetails.getAllegedActDate()!=null){
  	actDate=legalDetails.getAllegedActDate();
 	    }
  if(legalDetails.getPulse()!=null){
   Pulse=legalDetails.getPulse();   
  }
   arrest_time=legalDetails.getArrestTime()!=null?legalDetails.getArrestTime():"";
  penis=legalDetails.getPenis()!=null?legalDetails.getPenis():"";
 injury_on_body=legalDetails.getInjuryOnBody()!=null?legalDetails.getInjuryOnBody():"";
 
 ArrestDate=legalDetails.getArrestDate()!=null ? HMSUtil.convertDateTypeToStringWithoutTime(legalDetails.getArrestDate())  :"";

AdNo=legalDetails.getAdNo()!=null?legalDetails.getAdNo():"";
UnderArrest=legalDetails.getUnderArrest()!=null?legalDetails.getUnderArrest():"";
RequisitionFrom=legalDetails.getRequisitionFrom()!=null?legalDetails.getRequisitionFrom():"";
ArrestTime=legalDetails.getArrestTime()!=null?legalDetails.getArrestTime():"";
ExaminationTime=legalDetails.getExaminationTime()!=null?legalDetails.getExaminationTime():"";
HistoryAlcoholConsumption=legalDetails.getHistoryAlcoholConsumption()!=null?legalDetails.getHistoryAlcoholConsumption():"";
HistoryOfIllness=legalDetails.getHistoryOfIllness()!=null?legalDetails.getHistoryOfIllness():"";
AlcoholSmell=legalDetails.getAlcoholSmell()!=null?legalDetails.getAlcoholSmell():"";
Breath=legalDetails.getBreath()!=null?legalDetails.getBreath():"";
Clothing=legalDetails.getClothing()!=null?legalDetails.getClothing():"";
GeneralDisposition=legalDetails.getGeneralDisposition()!=null?legalDetails.getGeneralDisposition():"";
Speech=legalDetails.getSpeech()!=null?legalDetails.getSpeech():"";
Conjunctiva=legalDetails.getConjunctiva()!=null?legalDetails.getConjunctiva():"";
Pupils=legalDetails.getPupils()!=null?legalDetails.getPupils():"";
SelfControl=legalDetails.getSelfControl()!=null?legalDetails.getSelfControl():"";
Memory=legalDetails.getMemory()!=null?legalDetails.getMemory():"";
Orientation=legalDetails.getOrientation()!=null?legalDetails.getOrientation():"";
ReactionTime=legalDetails.getReactionTime()!=null?legalDetails.getReactionTime():"";
Gait=legalDetails.getGait()!=null?legalDetails.getGait():"";

Bp=legalDetails.getBp()!=null?legalDetails.getBp():"";
FingerNoseTest=legalDetails.getFingerNoseTest()!=null?legalDetails.getFingerNoseTest():"";
RombergsSign=legalDetails.getRombergsSign()!=null?legalDetails.getRombergsSign():"";
Reflexes=legalDetails.getReflexes()!=null?legalDetails.getReflexes():"";
InjuryDetails=legalDetails.getInjuryDetails()!=null?legalDetails.getInjuryDetails():"";
BloodExamination=legalDetails.getBloodExamination()!=null?legalDetails.getBloodExamination():"";
Urinated=legalDetails.getUrinated()!=null?legalDetails.getUrinated():"";


}
String currentDate ="";
String time ="";
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
 currentDate = (String)utilMap.get("currentDate");
 time = (String)utilMap.get("currentTime");
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

String userName="";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
String message="";
if(map.get("message") != null){
	   message = (String)map.get("message");
}

%>
<h2><%= message%></h2>
<form name="drunkcert" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Search</h2>
</div>
<div class="Block">
<label><span>*</span> UHID</label>
<input name="uhinId" id="uhinId" validate="UHID,string,yes" readonly="readonly" value="<%= hinNo%>"> 
 <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
  <input type="hidden"  name="hinId"   value="<%= hinId%>"/>
   <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
   <input type="hidden" name="mediCoId" id="mediCoId"  value="<%= mediCoId%>">
</div>

<div class="titleBg">
<h2>CERTIFICATE OF DRUNKNESS </h2>
</div>

<div class="clear"></div>
 
<div class="Block">

<label>Requisition By</label>
<input type="text" name="reqname" id="reqname" value="<%= reqForm%>" readonly="readonly"/>
 
<label>Police Station</label>
<input type="text" name="policestation" id="policestation" value="<%= policeSt%>" maxlength="128"/>
 
<label>Requisition Date</label>
<%if(reqDate.equalsIgnoreCase("")){ %> 
<input type="text" class="date"	name="examinDate" id="examinDate" value="<%=currentDate %>" MAXLENGTH="30" validate="Requisition Date,date,no" onblur="checkMonth(this,this.value);"/>
<%}else{ %> 
<input type="text" class="date"	name="examinDate" id="examinDate" value="<%=reqDate %>" MAXLENGTH="30" validate="Requisition Date,date,no" onblur="checkMonth(this,this.value);"/>
<%} %>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.examinDate,event)" /> 
<div class="clear"></div>
<!--  
 <label>Drunkenness Name</label>
<input type="text" id="pname" name="pname"/>
 
<label>Age</label>
<input type="text" id="age"  name="age" readonly="readonly"/>

<div class="clear"></div> -->
<label>Ser/NO.</label>
 <%if(mediCoId!=0){%>
<input type="text"   id="serNo" name="serNo" validate="Ser/NO.,String,yes" maxlength="16" value="<%= srNo%>" readonly="readonly"  />
 <%}else{ %>
 <input type="text"   id="serNo" name="serNo" validate="Ser/NO.,String,yes" maxlength="16" value="<%= orderNo%>" readonly="readonly"  />
 <%}%>

<label>HC / PC NO.</label>
<input type="text" name="hcpcNo" id="hcpcNo" maxlength="16" value="<%=AdNo%>"/>
<%-- <label>Date</label> 
<input type="text" class="date"	name="regDate" id="regDate" value="<%=currentDate %>" MAXLENGTH="30" validate="Date,date,no" onblur="checkMonth(this,this.value);" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.regDate,event)" /> --%>
<div class="clear"></div>

<label>Name </label>
<input type="text" id="pname" name="pname" readonly="readonly"  value="<%=name %>"/>
 
 <label>Age </label>
<input type="text" id="age"  name="age" readonly="readonly" value="<%=age %>"/>

 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly"/>
<label>Sex </label>
<input type="text" d="Gender"  name="Gender" readonly="readonly" value="<%=gender %>"/>


<div class="clear"></div>

<label>Address</label>
<textarea class="textareaMediua" readonly="readonly" name="address" id="address" rows="4" cols="50"><%=address %></textarea>
 
<label>Consent</label>
<textarea class="textareaMediua" name="consent" id="consent"  maxlength="90"  onkeyup="return ismaxlength(this)" rows="4" cols="50"><%= cosen%></textarea> 
 
<label>Whether Arrested Or Not </label>
<select class="mediumm"  name="arrest">

 <%if(UnderArrest.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
  <%}if(UnderArrest.equalsIgnoreCase("Yes")) {%>
   <option value="">Select</option>
  <option value="Yes" selected="selected">Yes</option>
  <option value="No">No</option>  
  <%}if(UnderArrest.equalsIgnoreCase("No")) {%>
  
   <option value="">Select</option>
  <option value="Yes" >Yes</option>
  <option value="No" selected="selected">No</option>  
  <%} %>  

</select>
 <div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label>Arrest Date</label> 
<%if(mediCoId!=0){%>
<input type="text" class="date"	name="arrestdate" id="arrestdate" value="<%=ArrestDate %>" MAXLENGTH="30" validate="Arrest Date,date,no" onblur="checkMonth(this,this.value);"/>
<%}else{ %>
<input type="text" class="date"	name="arrestdate" id="arrestdate" value="<%=currentDate %>" MAXLENGTH="30" validate="Arrest Date,date,no" onblur="checkMonth(this,this.value);"/>
<%} %> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.arrestdate,event)" />

 <label>Arrest Time</label>
<input type="text" name="time" id="time" value = "<%= ArrestTime%>" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
<label>Examination Date</label> 
<%if(mediCoId!=0){%>
<input type="text" class="date"	name="exdate" id="exdate" value="<%=examinDate %>" MAXLENGTH="30" validate="Examination Date,date,no" onblur="checkMonth(this,this.value);"/> 
<%}else{ %>
<input type="text" class="date"	name="exdate" id="exdate" value="<%=currentDate %>" MAXLENGTH="30" validate="Examination Date,date,no" onblur="checkMonth(this,this.value);"/>
<%} %> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.exdate,event)" />
 <div class="clear"></div>
 <label>Examination Time</label>
<input type="text" name="extime" id="extime" value="<%=ExaminationTime%>" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
<label>Identification Marks 1 </label>
 <input type="text" name="marks1" id="marks1" value="<%=idMark1%>"  maxlength="90"  onkeyup="return ismaxlength(this)"/>
 <label>Identification Marks 2 </label>
 <input type="text" name="marks2" id="marks2" value="<%=idMark2%>"  maxlength="90"  onkeyup="return ismaxlength(this)"/>
  <div class="clear"></div>
<h4>History</h4>
 <label>RelevantToConsum.OfAlco.</label><input type="text" name="alco1" id="alco1"  maxlength="250"  value="<%=HistoryAlcoholConsumption %>">
 <label>Relevant to Illness if Any</label><input type="text" name="alco2" id="alco2"  maxlength="250"  value="<%=HistoryOfIllness %>"/>
<label>Smell of Alcohol in Breath </label>
<select class="mediumm"  name="smell">

   <%if(AlcoholSmell.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent">Absent</option>
    <%}if(AlcoholSmell.equalsIgnoreCase("Present")){ %>
 <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
    <option value="Absent">Absent</option>
    <%}if(AlcoholSmell.equalsIgnoreCase("Absent")){ %>
 <option value="">Select</option>
  <option value="Present">Present</option>
    <option value="Absent" selected="selected">Absent</option>
 <%} %>
</select>

<h4>General Appearance & Behavior </h4>
<label>Clothing</label>
<select class="mediumm"  name="cloth">


   <%if(Clothing.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Decently dressed">Decently dressed</option>
<option value="Disordered">Disordered</option>
<option value="Soiled">Soiled</option>
<option value="Torn">Torn</option>
    <%}if(Clothing.equalsIgnoreCase("Decently dressed")){ %>
<option value="">Select</option>
<option value="Decently dressed" selected="selected">Decently dressed</option>
<option value="Disordered">Disordered</option>
<option value="Soiled">Soiled</option>
<option value="Torn">Torn</option>
    <%}if(Clothing.equalsIgnoreCase("Disordered")){ %>
<option value="">Select</option>
<option value="Decently dressed">Decently dressed</option>
<option value="Disordered" selected="selected">Disordered</option>
<option value="Soiled">Soiled</option>
<option value="Torn">Torn</option>

    <%}if(Clothing.equalsIgnoreCase("Soiled")){ %>
<option value="">Select</option>
<option value="Decently dressed">Decently dressed</option>
<option value="Disordered">Disordered</option>
<option value="Soiled" selected="selected">Soiled</option>
<option value="Torn">Torn</option>

    <%}if(Clothing.equalsIgnoreCase("Torn")){ %>
<option value="">Select</option>
<option value="Decently dressed">Decently dressed</option>
<option value="Disordered">Disordered</option>
<option value="Soiled" selected="selected">Soiled</option>
<option value="Torn" selected="selected">Torn</option>
 <%} %>



</select>
<label>General Disposition</label>
<select class="mediumm"  name="disposition">



   <%if(GeneralDisposition.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Calm">Calm</option>
<option value="Talkative">Talkative</option>
<option value="Abusive">Abusive</option>
<option value="Aggressive">Aggressive</option>
    <%}if(GeneralDisposition.equalsIgnoreCase("Calm")){ %>
<option value="">Select</option>
<option value="Calm" selected="selected">Calm</option>
<option value="Talkative">Talkative</option>
<option value="Abusive">Abusive</option>
<option value="Aggressive">Aggressive</option>
    <%}if(GeneralDisposition.equalsIgnoreCase("Talkative")){ %>
<option value="">Select</option>
<option value="Calm">Calm</option>
<option value="Talkative" selected="selected">Talkative</option>
<option value="Abusive" >Abusive</option>
<option value="Aggressive">Aggressive</option>

    <%}if(GeneralDisposition.equalsIgnoreCase("Abusive")){ %>
<option value="">Select</option>
<option value="Calm">Calm</option>
<option value="Talkative">Talkative</option>
<option value="Abusive" selected="selected">Abusive</option>
<option value="Aggressive">Aggressive</option>

    <%}if(GeneralDisposition.equalsIgnoreCase("Aggressive")){ %>
<option value="">Select</option>
<option value="Calm">Calm</option>
<option value="Talkative">Talkative</option>
<option value="Abusive">Abusive</option>
<option value="Aggressive" selected="selected">Aggressive</option>
 <%} %>

</select>
 <label>Speech</label>
<select class="mediumm"  name="speech">
 <%if(Speech.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Thick and Slurred">Thick and Slurred</option>
<option value="Incoherrent">Incoherrent</option>
 <%}if(Speech.equalsIgnoreCase("Normal")){ %>
<option value="">Select</option>
<option value="Normal" selected="selected">Normal</option>
<option value="Thick and Slurred">Thick and Slurred</option>
<option value="Incoherrent">Incoherrent</option>
 <%}if(Speech.equalsIgnoreCase("Thick and Slurred")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Thick and Slurred" selected="selected">Thick and Slurred</option>
<option value="Incoherrent">Incoherrent</option>
 <%}if(Speech.equalsIgnoreCase("Incoherrent")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Thick and Slurred">Thick and Slurred</option>
<option value="Incoherrent" selected="selected">Incoherrent</option>
<%} %>
</select>
<h4>Eyes:</h4>
<label>Conjuntiva</label>
<select class="mediumm"  name="conjuntiva">
 <%if(Conjunctiva.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Congested">Congested</option>
 <%}if(Conjunctiva.equalsIgnoreCase("Normal")){ %>
<option value="">Select</option>
<option value="Normal" selected="selected">Normal</option>
<option value="Congested">Congested</option>
 <%}if(Conjunctiva.equalsIgnoreCase("Congested")){ %>

<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Congested" selected="selected">Congested</option>

<%} %>
</select>
<label>Pupils </label>
<select class="mediumm"  name="pupils">
 <%if(Pupils.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Dilated">Dilated</option>
<option value="Sluggishly reacting">Sluggishly reacting</option>
 <%}if(Pupils.equalsIgnoreCase("Normal")){ %>
<option value="">Select</option>
<option value="Normal" selected="selected">Normal</option>
<option value="Dilated">Dilated</option>
<option value="Sluggishly reacting">Sluggishly reacting</option>
 <%}if(Pupils.equalsIgnoreCase("Dilated")){ %>

<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Dilated" selected="selected">Dilated</option>
<option value="Sluggishly reacting">Sluggishly reacting</option>

 <%}if(Pupils.equalsIgnoreCase("Sluggishly reacting")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Dilated">Dilated</option>
<option value="Sluggishly reacting" selected="selected">Sluggishly reacting</option>
<%} %>
</select>

<div class="clear"></div>
<h4>Higher Functions </h4>
<label>Self Control </label>
<select class="mediumm"  name="high">
 <%if(SelfControl.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Impaired">Impaired</option>
 <%}if(SelfControl.equalsIgnoreCase("Normal")){ %>
<option value="">Select</option>
<option value="Normal" selected="selected">Normal</option>
<option value="Impaired">Impaired</option>
 <%}if(SelfControl.equalsIgnoreCase("Impaired")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Impaired" selected="selected">Impaired</option>
<%} %>
</select>
<label>Memory </label>
<select class="mediumm"  name="memory">
<%if(Memory.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Impaired">Impaired</option>
 <%}if(Memory.equalsIgnoreCase("Normal")){ %>
<option value="">Select</option>
<option value="Normal" selected="selected">Normal</option>
<option value="Impaired">Impaired</option>
 <%}if(Memory.equalsIgnoreCase("Impaired")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Impaired" selected="selected">Impaired</option>
<%} %>
</select>
<label class="auto" style="padding:0px 12px 0px 5px;">Orientation of Time & Space</label>
<select class="mediumm"  name="space">
<%if(Orientation.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Impaired">Impaired</option>
 <%}if(Orientation.equalsIgnoreCase("Normal")){ %>
<option value="">Select</option>
<option value="Normal" selected="selected">Normal</option>
<option value="Impaired">Impaired</option>
 <%}if(Orientation.equalsIgnoreCase("Impaired")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Impaired" selected="selected">Impaired</option>
<%} %>
</select>
<div class="clear"></div>
<label>Reaction Time </label>
<select class="mediumm"  name="retime">
 <%if(ReactionTime.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Delayed">Delayed</option>
 <%}if(ReactionTime.equalsIgnoreCase("Normal")){ %>
<option value="">Select</option>
<option value="Normal" selected="selected">Normal</option>
<option value="Delayed">Delayed</option>
 <%}if(ReactionTime.equalsIgnoreCase("Delayed")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Delayed" selected="selected">Delayed</option>
<%} %>
</select>
<h4>Muscular Co-ordination </h4>
<label>Gait</label>
<select class="mediumm"  name="gait">
 <%if(Gait.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Unsteady">Unsteady</option>
<option value="Unable to stand upright">Unable to stand upright</option>
 <%}if(Gait.equalsIgnoreCase("Normal")){ %>
<option value="Normal" selected="selected">Normal</option>
<option value="Unsteady">Unsteady</option>
<option value="Unable to stand upright">Unable to stand upright</option>
 <%}if(Gait.equalsIgnoreCase("Unsteady")){ %>
<option value="Normal">Normal</option>
<option value="Unsteady" selected="selected">Unsteady</option>
<option value="Unable to stand upright">Unable to stand upright</option>
 <%}if(Gait.equalsIgnoreCase("Unable to stand upright")){ %>
<option value="Normal">Normal</option>
<option value="Unsteady">Unsteady</option>
<option value="Unable to stand upright" selected="selected">Unable to stand upright</option>
<%} %>
</select>
<label>Finger Nose Test</label>
<select class="mediumm"  name="finger">
<%if(FingerNoseTest.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Positive">Positive</option>
  <option value="Negative">Negative</option>
  <%}if(FingerNoseTest.equalsIgnoreCase("Positive")) {%>
   <option value="">Select</option>
  <option value="Positive" selected="selected">Positive</option>
  <option value="Negative">Negative</option>  
  <%}if(FingerNoseTest.equalsIgnoreCase("Negative")) {%>
     <option value="">Select</option>
  <option value="Positive">Positive</option>
  <option value="Negative"  selected="selected">Negative</option>  
  
  <%} %>  
</select>
<label>Pulse </label>
<%if(mediCoId!=0) {%>
<input type="text" name="pulse" id="pulse" value="<%=Pulse%>" validate="pulse,num,no" maxlength="3"/>
<%}else{ %>
<input type="text" name="pulse" id="pulse"  value="<%=(mlcList!=null && mlcList.size()>0)?mlcList.get(0).getPulse():0%>" validate="pulse,num,no" maxlength="3" />
<%} %>
<label>B.P. </label>
<%if(mediCoId!=0) {%>
<input type="text" name="bp" id="bp" value="<%=Bp%>"  maxlength="8"/>
<%}else{ %>
 <input type="text" name="bp" id="bp" value="<%=(mlcList!=null && mlcList.size()>0)?mlcList.get(0).getBp():""%>" >
<%} %>

<label>Romberg's sign</label>
<select class="mediumm"  name="romberg">
 <%if(RombergsSign.equalsIgnoreCase("")){ %>
    <option value="">Select</option>
  <option value="Positive">Positive</option>
  <option value="Negative">Negative</option>
  <%}if(RombergsSign.equalsIgnoreCase("Positive")) {%>
   <option value="">Select</option>
  <option value="Positive" selected="selected">Positive</option>
  <option value="Negative">Negative</option>  
  <%}if(RombergsSign.equalsIgnoreCase("Negative")) {%>
  
   <option value="">Select</option>
  <option value="Positive" >Positive</option>
  <option value="Negative" selected="selected">Negative</option>  
  <%} %>  
</select>
<label>Reflexes</label>
<select class="mediumm"  name="reflexes">



 <%if(Reflexes.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Normal" selected="selected">Normal</option>
<option value="Exaggerated">Exaggerated</option>
<option value="Sluggish">Sluggish</option>
  <%}if(Reflexes.equalsIgnoreCase("Normal")) {%>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Exaggerated">Exaggerated</option>
<option value="Sluggish">Sluggish</option>
  <%}if(Reflexes.equalsIgnoreCase("Exaggerated")) {%>
  <option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Exaggerated" selected="selected">Exaggerated</option>
<option value="Sluggish">Sluggish</option>
<%}if(Reflexes.equalsIgnoreCase("Sluggish")) {%>
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Exaggerated">Exaggerated</option>
<option value="Sluggish" selected="selected">Sluggish</option>
  <%} %> 
</select>
<div class="clear"></div>
<label>Any Injuries on Body </label>
<textarea class="textareaMediua" name="injury" id="injury" rows="4"  maxlength="100"  onkeyup="return ismaxlength(this)" cols="50"><%=injury_on_body%></textarea>
<label>Smell of Alcohol in Breath </label>
<select class="mediumm"  name="breath">
<%if(Breath.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Persisting">Persisting</option>
<option value="Not Persisting">Not Persisting</option>
<%}if(Breath.equalsIgnoreCase("Persisting")) {%>
<option value="">Select</option>
<option value="Persisting" selected="selected">Persisting</option>
<option value="Not Persisting">Not Persisting</option>
<%}if(Breath.equalsIgnoreCase("Not Persisting")) {%>
<option value="">Select</option>
<option value="Persisting">Persisting</option>
<option value="Not Persisting" selected="selected">Not Persisting</option>
<%} %>
</select>

<h4>Special Examination</h4>
<label>Blood</label>
<select class="mediumm"  name="blood">
<%if(BloodExamination.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="BPreserved">Preserved</option>
<option value="BNot Preserved">Not Preserved</option>
<%}if(BloodExamination.equalsIgnoreCase("BPreserved")) {%>

<option value="">Select</option>
<option value="BPreserved" selected="selected">Preserved</option>
<option value="BNot Preserved">Not Preserved</option>

<%}if(BloodExamination.equalsIgnoreCase("BNot Preserved")) {%>
<option value="">Select</option>
<option value="BPreserved">Preserved</option>
<option value="BNot Preserved" selected="selected">Not Preserved</option>
<%} %>

</select>
<label>Urine</label>
<select class="mediumm"  name="urine">
<%if(Urinated.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="UPreserved">Preserved</option>
<option value="UNot Preserved">Not Preserved</option>
<%}if(Urinated.equalsIgnoreCase("UPreserved")) {%>
<option value="">Select</option>
<option value="UPreserved" selected="selected">Preserved</option>
<option value="UNot Preserved">Not Preserved</option>

<%}if(Urinated.equalsIgnoreCase("UNot Preserved")) {%>
<option value="">Select</option>
<option value="UPreserved">Preserved</option>
<option value="UNot Preserved"  selected="selected">Not Preserved</option>
<%} %>
</select>

<div class="clear"></div>

<label>Opinion</label>
<textarea  id="opinion" name="opinion" class="textareaMediua"  maxlength="250"  onkeyup="return ismaxlength(this)"><%= opNion%></textarea>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
 <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
 <input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

 <% if(meDetails.size()==0) {%>
 <input type="button" name="add" id="addbutton" value="Submit" 	class="button"	onClick="submitForm('drunkcert','mlc?method=submmitDrunknessCertifikate&flag=submit');"	accesskey="a" tabindex=1 />
 <% }else{ %>
 <input type="button" name="add" id="addbutton" value="Authorization" 	class="button"	onClick="submitForm('drunkcert','mlc?method=submmitDrunknessCertifikate&flag=authorization');"	accesskey="a" tabindex=1 />
 <%} %>
 
</div>
</form>