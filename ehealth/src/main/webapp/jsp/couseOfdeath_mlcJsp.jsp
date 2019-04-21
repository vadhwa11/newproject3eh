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
var serverdate = '<%=date+"/"+month+"/"+year%>'
	
</script>
	<% 
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}

String  reqForm="";
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
int inpationId=0;


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

//-----------
String srNo="";
String examinDate="";
String exaTime="";
String idMark1="";
String idMark2="";
String policeSt="";

String examination_time="";

String  reqTime="";
Date  reqDate=new Date();
int addiTion=0;
String  opNion="";
String injDetail="";
String  his="";
String  crimeNo="";
String  cosen="";
String otherHistory="";
String bp="";
int pulse= 0;
String arrest_time="";
String injury_on_body="";

for(MedicoLegalDetails legalDetails:meDetails){
	
	  srNo= legalDetails.getSerialNo()!=null ? legalDetails.getSerialNo():"";
	  crimeNo=legalDetails.getCrimeNo()!=null ?legalDetails.getCrimeNo():"";
	  examinDate=legalDetails.getExaminationDate()!=null ? HMSUtil.convertDateToStringTypeDate(legalDetails.getExaminationDate())  :"";
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

     reqTime=legalDetails.getRequisitionTime()!=null?legalDetails.getRequisitionTime():"";
      if(legalDetails.getRequisitionDate()!=null){
         reqDate=legalDetails.getRequisitionDate();
          }

           if(legalDetails.getPulse()!=null){
	   pulse=legalDetails.getPulse();   
	  }
 
arrest_time=legalDetails.getArrestTime()!=null?legalDetails.getArrestTime():"";

injury_on_body=legalDetails.getInjuryOnBody()!=null?legalDetails.getInjuryOnBody():"";
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
<h2>OPINION OF CAUSE OF DEATH</h2>
</div>

<div class="Block">
<label><span>*</span> UHID</label>
<input name="uhinId" id="uhinId" validate="UHID,string,yes" value="<%=hinNo %>" readonly="readonly" > 
 <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
	 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly" value="<%= hinId%>"/>
 <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>

 

<label>PM.No.</label>
<input type="text" name="pmNo" id="pmNo" value="<%=orderNo %>" readonly="readonly"/>

<label>PM Date</label> 
<input type="text" class="date"	name="postdate" id="postdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.postdate,event)" />



<div class="clear"></div>
<label>Requisition  From</label>
<input type="text" name=receivedFrom id="receivedFrom" value="<%=reqForm%>" maxlength="90"/>
 
 
<label>Police Station</label>
<input type="text" name="policestation" id="policestation" value="<%=policeSt%>" maxlength="127"/>

<label>Requisition Date</label> 
<input type="text" class="date"	name="requisitionDate" id="requisitionDate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.requisitionDate,event)" />
 
<div class="clear"></div>
<label>Name :</label>
<input type="text" id="pname" name="pname" value="<%=name %>" readonly="readonly"/>
  <label>Age :</label>
<input type="text" id="age"  name="age" value="<%=age %>" readonly="readonly"/>

<label>Sex :</label>
<input type="text" d="Gender"  name="Gender" value="<%=gender %>" readonly="readonly"/>
<div class="clear"></div>

<label>Address</label>
<textarea class="textareaMediua" name="address" id="address" rows="4" readonly="readonly" cols="50"><%=address %></textarea>
<label>Crime No:</label>
<input type="text" id="crno"  name="crno" value="<%=crimeNo%>" maxlength="16"/>
 <label>Police Station</label>
<input type="text" name="ofPolice" id="ofPolice" maxlength="110"/>
<div class="clear"></div>
<label>Postmortem   Certificate No:</label>
<input type="text" id="pcno"  name="pcno" maxlength="16"/>
<label>Postmortem Date</label> 
<input type="text" class="podate"	name="podate" id="podate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.podate,event)" />
 
 <label>Chemical Analysis No:</label>
<input type="text" id="cmano"  name="cmano" maxlength="10"/>

<label> Analysis Date</label> 
<input type="text" class="date"	name="andate" id="andate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.andate,event)" />

<label>Received On Date</label> 
<input type="text" class="date"	name="recdate" id="recdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.recdate,event)" />


<div class="clear"></div>

<label>Laboratory Findings:</label>
<textarea class="textareaMediua" name="lebotry" id="lebotry" rows="4" cols="50"  onkeyup="return ismaxlength(this)"  maxlength="350"></textarea> 
<label>Opinion</label>
<textarea class="textareaMediua" name="opinion" id="opinion" rows="4" cols="50"  onkeyup="return ismaxlength(this)"  maxlength="250"><%=opNion%></textarea> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
 <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
 <input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input class="buttonBig" type="button" onclick="submitForm('drunkcert','mlc?method=submitCouseOfDeathFinal');" value="Submit">
</form>