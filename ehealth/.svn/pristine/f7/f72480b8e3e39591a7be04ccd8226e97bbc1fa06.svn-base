s<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
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
<div class="titleBg">
<h2>Search</h2>
</div>
<div class="Block">
<label><span>*</span> UHID</label>
<input name="uhinId" id="uhinId" validate="UHID,string,yes" value="<%=hinNo %>" readonly="readonly" > 
  <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
	 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly" value="<%= hinId%>"/>
	    <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
</div>

<div class="titleBg">
<h2>POSTMORTEM CERTIFICATE</h2>
</div>

<div class="clear"></div>
 
<div class="Block">

<label>P.M. No:</label>
<input type="text" id="pmno" name="pmno"/>
<label>Date</label> 
<input type="text" class="date"	name="postdate" id="postdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.postdate,event)" />
 <div class="clear"></div>
<label>Name :</label>
<input type="text" id="pname" name="pname" value="<%=name %>" readonly="readonly"/>
  <label>Age :</label>
<input type="text" id="age"  name="age" value="<%=age %>" readonly="readonly"/>

<label>Sex :</label>
<input type="text" d="Gender"  name="Gender" value="<%=gender %>" readonly="readonly"/>
<div class="clear"></div>

<label>Address:</label>
<textarea class="textareaMediua" name="address" id="address" rows="4" cols="50"></textarea>
<label>Crime No:</label>
<input type="text" id="crimeNo"  name="crimeNo" />
 <label>Police Station</label>
<input type="text" name="ofPolice" id="ofPolice" />
<div class="clear"></div>
<label>Received From</label>
<input type="text" name="receivedFrom" id="receivedFrom" />
<label>Time</label>
<input type="text"   id="receivedTime" value="<%= time%>"   name="receivedTime" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
<label>Date</label> 
<input type="text" class="date"	name="resdate" id="resdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.postdate,event)" />
 <div class="clear"></div>
<label>Postmortem  Certificate No:</label>
<input type="text" id="pmcertificateNo"  name="pmcertificateNo" />
<label>At</label>
<input type="text"   id="atTime" value="<%= time%>"   name="atTime" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
<label>On Date</label> 
<input type="text" class="date"	name="ondate" id="ondate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.ondate,event)" />
  <div class="clear"></div>
  
<label>Latter Crime No:</label>
<input type="text" id="latterCrimeNo"  name="latterCrimeNo" />

<label>Date</label> 
<input type="text" class="date"	name="crdate" id="crdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.ondate,event)" />
  <div class="clear"></div>
    
  
  
 <label>Concluded At</label>
<input type="text" id="coAt"  name="coAt" />

 <label>Cause Of Death</label>
<textarea class="textareaMediua" name="resionDeath" id="resionDeath" rows="4" cols="50"></textarea>

  <div class="clear"></div>

 <label>Post-Mortem Findings</label>
<textarea class="textareaMediua" name="postMortem" id="postMortem" rows="4" cols="50"></textarea>

 <label>Opinion</label>
<textarea class="textareaMediua" name="opinion" id="opinion" rows="4" cols="50"></textarea>
  
  


 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
 <input type="hidden" name="<%=CHANGED_DATE %>" value="<%= currentDate%>" /> 
 <input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input class="buttonBig" type="button" onclick="submitForm('drunkcert','mlc?method=submitPostMartemCertificate');" value="Submit">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>