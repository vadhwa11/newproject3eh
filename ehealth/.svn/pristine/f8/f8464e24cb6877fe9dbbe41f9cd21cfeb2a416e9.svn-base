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
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

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
	<% 
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}

List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
if(map.get("mlcList") != null)
{
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
int inpationId=0;
int height=0;
int weight=0;
String reqForm="";
String srNo="";
String examinDate="";
String exaTime="";
String idMark1="";
String idMark2="";
String policeSt="";
String examination_time="";
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
String refDate="";
int mediCoId=0;
String build="";
String voice="";
String adamApple="";
String moustache="";
String pubicHair="";
String axillary="";
String chest="";
String elbow="";
String genitalia="";
String ejaculation="";
int teeth=0;
int temporaryteeth=0;
int permanentteeth=0;
String detailsteath="";
String shoulder="";
String wrist="";
String pelvis="";
String skull="";
String lastMenstrualDate="";
String breasts="";
int heightOpd=0;
int weightOpd=0;
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
	   
} 
	
	List<PatientAddress> patientAddress = new ArrayList<PatientAddress>();
	if(map.get("patientAddress")!=null){
		patientAddress=(List<PatientAddress>)map.get("patientAddress");
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

//-----------

if(meDetails.size()!=0){
for(MedicoLegalDetails legalDetails:meDetails){
	  mediCoId=legalDetails.getId();
	  srNo= legalDetails.getSerialNo()!=null ? legalDetails.getSerialNo():"";
	  crimeNo=legalDetails.getCrimeNo()!=null ?legalDetails.getCrimeNo():"";
	  exaTime=legalDetails.getExamCommTime()!=null ?legalDetails.getExamCommTime():"";
	  examinDate=legalDetails.getExamCommDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getExamCommDate())  :"";
	  refDate=legalDetails.getRefDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRefDate())  :"";
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
  reqDate=legalDetails.getRequisitionDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRequisitionDate())  :"";
  height=legalDetails.getHeight()!=0 ?legalDetails.getHeight():0;
  weight=legalDetails.getHeight()!=0 ?legalDetails.getHeight():0;
  build=legalDetails.getBuild()!=null?legalDetails.getBuild():"";
  

  voice=legalDetails.getVoice()!=null?legalDetails.getVoice():"";
  adamApple=legalDetails.getAdamApple()!=null?legalDetails.getAdamApple():"";
  moustache=legalDetails.getMoustache()!=null?legalDetails.getMoustache():"";
  pubicHair=legalDetails.getPubicHair()!=null?legalDetails.getPubicHair():"";
  axillary=legalDetails.getAxillary()!=null?legalDetails.getAxillary():"";
  chest=legalDetails.getChestHair()!=null?legalDetails.getChestHair():"";
  elbow=legalDetails.getElbow()!=null?legalDetails.getElbow():"";
  genitalia=legalDetails.getExternalGenitalia()!=null?legalDetails.getExternalGenitalia():"";
  ejaculation=legalDetails.getMenarchyEjaculation()!=null?legalDetails.getMenarchyEjaculation():"";
  breasts=legalDetails.getBreasts()!=null?legalDetails.getBreasts():"";
  teeth=legalDetails.getTeeth()!=0?legalDetails.getTeeth():0;
  temporaryteeth=legalDetails.getTemporary()!=0?legalDetails.getTemporary():0;
  permanentteeth=legalDetails.getPermanentTeeth()!=0?legalDetails.getPermanentTeeth():0;
  detailsteath=legalDetails.getDetailsTeeth()!=null?legalDetails.getDetailsTeeth():"";
  shoulder=legalDetails.getShoulder()!=null?legalDetails.getShoulder():"";
  wrist=legalDetails.getWrist()!=null?legalDetails.getWrist():"";
  pelvis=legalDetails.getPelvis()!=null?legalDetails.getPelvis():"";
  skull=legalDetails.getSkullJaw()!=null?legalDetails.getSkullJaw():"";
  lastMenstrualDate=legalDetails.getLastMenstrualDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getLastMenstrualDate())  :"";
} 

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
<h2>EXAMINATION FOR ESTIMATION OF AGE</h2>
</div>


<div class="Block">
<label><span>*</span> UHID</label>
<input name="uhinId" id="uhinId" validate="UHID,string,yes" value="<%=hinNo %>" readonly="readonly" > 
  <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
	 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly" value="<%= hinId%>"/>
	   <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
	   <input type="hidden" name="mediCoId" id="mediCoId"  value="<%= mediCoId%>">
</div>


<label>Ref.ML No.</label>
<%if(mediCoId!=0){%>
<input type="text"   id="refMLNo" name="refMLNo" readonly="readonly" maxlength="16" value="<%=srNo %>"/>
<%}else{ %>

<input type="text"   id="refMLNo" name="refMLNo" readonly="readonly" maxlength="16" value="<%=orderNo %>"/>
<%} %>


<label>Ref. ML Date</label>
<%if(mediCoId!=0){%>
<input type="text" id="refMLDate" name="refMLDate"  validate="Ref. ML Date,date,no" class="date"  value="<%=refDate %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=refDate %>',document.drunkcert.refMLDate,true);" />

	<%}else{ %>
<input type="text" id="refMLDate" name="refMLDate"  validate="Ref. ML Date,date,no" class="date"  value="<%=currentDate %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.drunkcert.refMLDate,true);" />
	
	<%} %>

<div class="clear"></div>

<label>Requisition Received From</label>
<input type="text" name="reqname" id="reqname" value="<%= reqForm%>" readonly="readonly" maxlength="90"/>
<label>Requisition Time</label>
<%if(mediCoId!=0){ %>
<input type="text" name="time" id="time" value="<%=examination_time%>"      onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8" />
 <%}else{ %>
 <input type="text" name="time" id="time" value="<%=time%>"      onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8" />
 <%} %>
<label>Requisition Date</label> 
<%if(mediCoId!=0){ %>
<input type="text" class="date"	name="requisitionDate" id="requisitionDate" value="<%=reqDate %>" MAXLENGTH="30" validate="Requisition Date,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=reqDate%>',document.drunkcert.requisitionDate,event)" />
 	<%}else{ %>
<input type="text" class="date"	name="requisitionDate" id="requisitionDate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.requisitionDate,event)" />
 	
	<%} %>
<div class="clear"></div>

<label>Name</label>
<input type="text" id="pname" name="pname" value="<%=name %>" readonly="readonly" />
 
 <label>Age</label>
<input type="text" id="age"  name="age" value="<%=age %>" readonly="readonly" />

<label>Sex</label>
<input type="text" d="Gender"  name="Gender" value="<%=gender %>" readonly="readonly" />


<div class="clear"></div>

<label>Address</label>
<textarea class="textareaMediua" name="address" id="address" rows="4" cols="50" readonly="readonly"><%=address%></textarea>
 

<label>Crime No.</label>
<input type="text" name=crimeNo id="crimeNo"  maxlength="16" value="<%=crimeNo%>"/>
 
<label>Police Station</label>
<input type="text" name="policestation" id="policestation"  value="<%= policeSt%>"  maxlength="120"/>
<div class="clear"></div>

<label>Consent</label>
<textarea class="textareaMediua"  maxlength="90"  onkeyup="return ismaxlength(this)" name="consent" id="consent" rows="4" cols="50"><%= cosen%></textarea>


<label>Examin Date</label>
<input type="text" id="examinDate" name="examinDate" validate="Examin Date,date,no" class="date" value="<%=examinDate %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=examinDate %>',document.drunkcert.examinDate,true);" />
 <div class="clear"></div>
<label>Examin Time</label> 
 <input type="text"   id="exTime" name="exTime"  onKeyUp="mask(this.value,this,'2,5',':');"	value="<%=exaTime %>" onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
 <div class="clear"></div>
 <label>Identification Marks 1 </label>
 <input type="text" name="marks1" id="marks1" value="<%=idMark1%>" maxlength="120"  onkeyup="return ismaxlength(this)"/>
 <label>Identification Marks 2 :</label>
 <input type="text" name="marks2" id="marks2" value="<%=idMark2%>" maxlength="120"  onkeyup="return ismaxlength(this)"/>
 <div class="clear"></div>
 <h4>Physical examination</h4>
  <label>Height</label>
  <%if(mediCoId!=0){%>
 <input type="text" name="height" id="height" value="<%=height%>" validate="Height,int,no" maxlength="3"/>
 <%}else{ %>
 <input type="text" name="height" id="height" value="<%=heightOpd%>" validate="Height,int,no" maxlength="3"/>
 <%} %>
  <label>Weight</label>
<%if(mediCoId!=0){%>
 <input type="text" name="weight" id="weight" value="<%=weight%>"  validate="Weight,int,no" maxlength="3"/>
 <%}else{ %>
  <input type="text" name="weight" id="weight" value="<%=weightOpd%>"  validate="Weight,int,no" maxlength="3"/>
  <%} %>
<label>General build</label>
<select class="mediumm"  name="build">

    <%if(build.equalsIgnoreCase("")) {%>
    <option value="">Select</option>
<option value="Poor">Poor</option>
<option value="Moderate">Moderate</option>
<option value="Good">Good</option>
  <%}if(build.equalsIgnoreCase("Poor")){ %>
  <option value="">Select</option>
  <option value="Poor" selected="selected">Poor</option>
  <option value="Moderate">Moderate</option>
  <option value="Good">Good</option>
  
 <%}if(build.equalsIgnoreCase("Moderate")){ %>
  <option value="">Select</option>
  <option value="Poor">Poor</option>
  <option value="Moderate" selected="selected">Moderate</option>
  <option value="Good">Good</option>
  <%}if(build.equalsIgnoreCase("Good")){ %>
  <option value="">Select</option>
  <option value="Poor">Poor</option>
  <option value="Moderate">Moderate</option>
  <option value="Good" selected="selected">Good</option>
    
  <%}%>

</select> 
<div class="clear"></div>
<label>Voice</label> 
<select class="mediumm"  name="voice">
   <%if(voice.equalsIgnoreCase("")) {%>
<option value="">Select</option>
<option value="Masculine">Masculine</option>
<option value="Feminine">Feminine</option>
 <%}if(voice.equalsIgnoreCase("Masculine")){ %>
<option value="">Select</option>
<option value="Masculine" selected="selected">Masculine</option>
<option value="Feminine">Feminine</option>
 <%}if(voice.equalsIgnoreCase("Feminine")){ %>
<option value="">Select</option>
<option value="Masculine">Masculine</option>
<option value="Feminine" selected="selected">Feminine</option>
<%}%>

</select> 


<label>Adam apple</label> 
<select class="mediumm"  name="adamApple">
   <%if(adamApple.equalsIgnoreCase("")) {%>
<option value="">Select</option>
<option value="Prominent">Prominent</option>
<option value="Not prominent">Not prominent</option>
 <%}if(adamApple.equalsIgnoreCase("Prominent")){ %>
<option value="">Select</option>
<option value="Prominent" selected="selected">Prominent</option>
<option value="Not prominent">Not prominent</option>
 <%}if(adamApple.equalsIgnoreCase("Not prominent")){ %>
<option value="">Select</option>
<option value="Prominent">Prominent</option>
<option value="Not prominent" selected="selected">Not prominent</option>
<%}%>

</select> 



<h4>Hair</h4>
 <label>Moustache</label>
 <input type="text" name="moustache" id="moustache" maxlength="120" value="<%=moustache %>" />
 <div class="clear"></div>
  <label>Pubic</label> 
 <input type="text" name="pubicHair" id="pubic" maxlength="120" value="<%=pubicHair %>"/>
  <label>Axillary</label>
 <input type="text" name="axillary" id="axillary" maxlength="120" value="<%=axillary %>"/>
  <label>Chest</label>
 <input type="text" name="chest" id="chest"  maxlength="120" value="<%=chest %>"/>
 <div class="clear"></div>
 <label>Breasts</label>
 <input type="text" name="breasts" id="breasts" maxlength="120" value="<%=breasts %>"/>
  <label>External genitalia:</label>
 <input type="text" name="genitalia" id="genitalia" maxlength="120" value="<%=genitalia %>"/>
  <label>Menarchy / Ejaculation:</label>
 <input type="text" name="ejaculation" id="ejaculation" maxlength="120" value="<%=ejaculation %>" />
 <div class="clear"></div>
  <label>Date of last menstrual period</label>
  <%if(lastMenstrualDate.equalsIgnoreCase("")){ %>
 <input type="text" class="date"	name="menstrualDate" id="menstrualDate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.periodDate,event)" />
 <%}else{ %>
 <input type="text" class="date"	name="menstrualDate" id="menstrualDate" value="<%=lastMenstrualDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.periodDate,event)" />
 
 <%} %>
 <div class="clear"></div>
  <h4>Dental examination</h4>
   <label>Number Of Teeth</label>
 <input type="text" name="teeth" id="teeth" validate="Number Of Teeth,int,no" maxlength="10" value="<%=teeth %>" />
   <label>Temporary</label>
 <input type="text" name="temporaryteeth" id="temporaryteeth" validate="Temporary,int,no" maxlength="10" value="<%=temporaryteeth %>" />
   <label>Permanent</label>
 <input type="text" name="permanentteeth" id="permanentteeth" validate="Permanent,int,no" maxlength="10" value="<%=permanentteeth %>" />
 <div class="clear"></div>
   <label>Details</label>
 <input type="text" name="detailsteath" id="detailsteath" maxlength="360" value="<%=detailsteath %>"  />
 <div class="clear"></div>
 <h4>Radiological examination</h4>
    <label>Shoulder</label>
 <input type="text" name="shoulder" id="shoulder"  maxlength="120" value="<%=shoulder %>" />
     <label>Elbow</label>
 <input type="text" name="elbow" id="elbow" maxlength="120" value="<%=elbow %>" />
     <label>Wrist</label>
 <input type="text" name="wrist" id="wrist" maxlength="120" value="<%=wrist %>" />
 <div class="clear"></div>
     <label>Pelvis</label>
 <input type="text" name="pelvis" id="pelvis" maxlength="120" value="<%=pelvis %>" />
      <label>Skull & jaw</label>
 <input type="text" name="skull" id="skull" maxlength="120" value="<%=skull %>" />
 <label>Opinion</label>
<textarea class="textareaMediua" name="opinion" id="opinion" rows="4" cols="50" maxlength="250"  onkeyup="return ismaxlength(this)"><%=opNion%></textarea> 
 <div class="paddingTop15"></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
 <input type="hidden" name="<%=CHANGED_DATE %>" value="<%= currentDate%>" /> 
 <input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="clear"></div>


 <% if(meDetails.size()==0) {%>
 <input type="button" name="add" id="addbutton" value="Submit" 	class="button"	onClick="submitForm('drunkcert','mlc?method=submitEstimationofAge&flag=submit');"	accesskey="a" tabindex=1 />
 <% }else{ %>
 <input type="button" name="add" id="addbutton" value="Authorization" 	class="button"	onClick="submitForm('drunkcert','mlc?method=submitEstimationofAge&flag=authorization');"	accesskey="a" tabindex=1 />
 <%} %>
</form>