<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.PatientAddress"%>
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
if(map.get("mlcList") != null)
{
	mlcList=(List<OpdPatientDetails>)map.get("mlcList");
}
List<Patient> patientList = new   ArrayList<Patient>();
if(map.get("patientList") != null)
{
	patientList=(List<Patient>)map.get("patientList");
}
List<MasEmployee> emplist = new ArrayList<MasEmployee>();
if(map.get("emplist") != null)
{
	emplist=(List<MasEmployee>)map.get("emplist");
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
String srNo="";
int mediCoId=0;
String crimeNo="";
String refDate="";
String policeSt="";
String ExaminationPlace="";
String MaterialObjectsPreserved="";
String PreservativeUsed="";
String SamplePaking="";
String Sealed="";
String HistoryOfIllness="";
String Findings="";
String ExaminationRequired="";
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

for(MedicoLegalDetails legalDetails:meDetails){
	  mediCoId=legalDetails.getId();
	  srNo= legalDetails.getSerialNo()!=null ? legalDetails.getSerialNo():"";
	  crimeNo=legalDetails.getCrimeNo()!=null ?legalDetails.getCrimeNo():"";
	  
	  if(legalDetails.getExaminationDate()!=null){
			 
		  refDate=legalDetails.getRefDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRefDate())  :"";
			    }
	  policeSt=legalDetails.getPoliceStation()!=null ?legalDetails.getPoliceStation():"";
	  ExaminationPlace=legalDetails.getExaminationPlace()!=null ?legalDetails.getExaminationPlace():"";
	  MaterialObjectsPreserved=legalDetails.getMaterialObjectsPreserved()!=null ?legalDetails.getMaterialObjectsPreserved():"";
	  PreservativeUsed=legalDetails.getPreservativeUsed()!=null ?legalDetails.getPreservativeUsed():"";
	  SamplePaking=legalDetails.getSamplePaking()!=null ?legalDetails.getSamplePaking():"";
	  Sealed=legalDetails.getSealed()!=null ?legalDetails.getSealed():"";
	  HistoryOfIllness=legalDetails.getHistoryOfIllness()!=null ?legalDetails.getHistoryOfIllness():"";
	  Findings=legalDetails.getFindings()!=null ?legalDetails.getFindings():"";
	  ExaminationRequired=legalDetails.getExaminationRequired()!=null ?legalDetails.getExaminationRequired():"";
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
<input name="uhinId" id="uhinId" validate="UHID,string,yes" value="<%=hinNo %>" readonly="readonly" > 
  <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
<input type="hidden"  id="hinId"  name="hinId" readonly="readonly" value="<%= hinId%>"/>
   <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
   <input type="hidden" name="mediCoId" id="mediCoId"  value="<%= mediCoId%>">
   

</div>

<div class="titleBg">
<h2>Chemical Analysis</h2>
</div>

<div class="clear"></div>
 
<div class="Block">

<label>Ref.ML.No</label>
<%if(mediCoId!=0){%>
<input type="text"   id="refname" name="refname" validate="RF NO,String,Yes" maxlength="16" value="<%= srNo%>" readonly="readonly"/>
 <%}else{ %>
 <input type="text"   id="refname" name="refname" validate="RF NO,String,Yes" maxlength="16" value="<%= orderNo%>" readonly="readonly"/>
 <%}%>

 <label>Ref. ML Date</label> 
 <%if(mediCoId!=0){%>
 <input type="text" id="refMLDate" name="refMLDate" validate="Ref. ML Date,date,no" class="date"   value="<%=refDate %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=refDate %>',document.drunkcert.refMLDate,true);" />
 <%}else{ %>
<input type="text" class="date"	name="date" id="date" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.date,event)" />
 <%}%>
<div class="clear"></div>
<label>Name </label>
<input type="text" id="pname" name="pname" value="<%=name %>" readonly="readonly" />
  <label>Age </label>
<input type="text" id="age"  name="age" value="<%=age %>" readonly="readonly" />
 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly"/>
<label>Sex </label>
<input type="text" d="Gender"  name="Gender" value="<%=gender %>" readonly="readonly" />
<div class="clear"></div>

<label>Address</label>
<textarea class="textareaMediua"  readonly="readonly" name="address" id="address" rows="4" cols="50"><%=address %></textarea>
<label>Crime No</label>
<input type="text" id="crno"  name="crno" maxlength="16"  value="<%=crimeNo %>"/>
 <label>Police Station</label>
<input type="text" name="ofPolice" id="ofPolice"  maxlength="120"  value="<%=ExaminationPlace %>"/>
<div class="clear"></div>
<label>Examination Conducted</label>
<input type="text" id="conducted"  name="conducted"  maxlength="110" value="<%=ExaminationPlace %>"/>
<label>Material Objects preserved</label>
<textarea class="textareaMediua" name="mpreserved" id="mpreserved" rows="4" cols="50" maxlength="110" onkeyup="return checkLength(this)"><%=MaterialObjectsPreserved %></textarea>
<label>Preservative used</label>
<textarea class="textareaMediua" name="preservative" id="preservative" rows="4" cols="50" maxlength="110" onkeyup="return checkLength(this)"><%=PreservativeUsed %></textarea>
<label>Sample Packing</label> 
<select class="mediumm"  name="packing">
<%if(SamplePaking.equalsIgnoreCase("")){ %>
<option value="">Select</option>
<option value="Collected in glass bottles">Collected in glass bottles</option>
<option value="wrapped with paper">wrapped with paper</option>
<%} else if(SamplePaking.equalsIgnoreCase("Collected in glass bottles")){ %>
<option value="">Select</option>
<option value="Collected in glass bottles" selected="selected">Collected in glass bottles</option>
<option value="wrapped with paper">wrapped with paper</option>
<%} else if(SamplePaking.equalsIgnoreCase("wrapped with paper")){ %>
<option value="">Select</option>
<option value="Collected in glass bottles">Collected in glass bottles</option>
<option value="wrapped with paper" selected="selected">wrapped with paper</option>
<%} %>
</select> 

<label>Tied</label>
<input type="checkbox" name="tied" value="tied"> 
<label>Sealed</label>
<input type="checkbox" name="sealed" value="sealed"> 
<div class="clear"></div>
<label>Case History</label>
<textarea class="textareaMediua" name="history" id="history" rows="4" cols="50"  maxlength="250" onkeyup="return checkLength(this)"><%=HistoryOfIllness %></textarea>
<label>Findings of examination</label>
<textarea class="textareaMediua" name="findings" id="findings" rows="4" cols="50"  maxlength="120" onkeyup="return checkLength(this)"><%=Findings %></textarea>
<label>Examination required</label>
<textarea class="textareaMediua" name="examination" id="examination" rows="4" cols="50"  maxlength="110" onkeyup="return checkLength(this)"><%=ExaminationRequired %></textarea>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
 <input type="hidden" name="<%=CHANGED_DATE %>" value="<%= currentDate%>" /> 
 <input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<div class="clear"></div>

 <% if(meDetails.size()==0) {%>
 <input type="button" name="add" id="addbutton" value="Submit" 	class="button"	onClick="submitForm('drunkcert','mlc?method=submitChemicalAnalysis&flag=submit');"	accesskey="a" tabindex=1 />
 <% }else{ %>
 <input type="button" name="add" id="addbutton" value="Authorization" 	class="button"	onClick="submitForm('drunkcert','mlc?method=submitChemicalAnalysis&flag=authorization');"	accesskey="a" tabindex=1 />
 <%} %> 

</form>