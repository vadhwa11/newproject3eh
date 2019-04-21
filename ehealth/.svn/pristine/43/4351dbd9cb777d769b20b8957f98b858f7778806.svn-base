<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.PatientAddress"%>
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

/* function uterusText(){	
if(document.getElementById("uterus").value=='Palpable per abdomen'){
	document.getElementById("uterusDiv").style.display="inline";
}else{
	document.getElementById("uterusDiv").style.display="none";
}
	
}

function dischargeText(){	
		if(document.getElementById("discharge").value=='Present'){
			document.getElementById("dischargeDiv").style.display="inline";
		}else{
			document.getElementById("dischargeDiv").style.display="none";
		}		 */
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

List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
if(map.get("mlcList") != null)
{
	mlcList=(List<OpdPatientDetails>)map.get("mlcList");
}
// added by Amit Das on 19-04-2016
List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
if(map.get("patientHistories")!=null) {
	patientHistories	= (List<OpdPatientHistory>)map.get("patientHistories");
}

List<PatientAddress> patientAddress = new ArrayList<PatientAddress>();
if(map.get("patientAddress")!=null){
	patientAddress=(List<PatientAddress>)map.get("patientAddress");
}
String orderNo="";
if(map.get("orderNo")!=null){
	orderNo=(String)map.get("orderNo");
}
List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
if(map.get("patientWiseMlcs")!=null){
	patientWiseMlcs=(List<PatientWiseMlc>)map.get("patientWiseMlcs");
}

String srNo="";
String examinDate="";
String exaTime="";
String idMark1="";
String idMark2="";
String policeSt="";
String witt1="";
String witt2="";
String  witt1Add="";
String  witt2Add="";
String  donDo="";
String  wAdd1="";
String  wAdd2="";
String  reqForm="";
String  stamBy="";
String  detInj="";
 int addiTion=1;
String  opNion="";
String sonOf1="";
String sonOf2="";
String histInj="";

String opdDate="";
String hinNo="";
String name="";
String age="";
String gender="";
String address="";
int detailId=0;
int hinId=0;
int inpationId=0;
String  his="";
double height=0;
double weight=0;
String fatherName="";
int mediCoId=0;
List<MedicoLegalDetails> meDetails = new ArrayList<MedicoLegalDetails>();
if(map.get("details")!=null){
	meDetails=(List<MedicoLegalDetails>)map.get("details");
}
String phy="";	
String rffDoc="";
String couInj="";
String boughtBy="";
String boughtAddress="";
String injDetail="";
String admitted="";
String serNo="";
int hOp=0;
int pIp=0;
String injuriesApp=""; 
String crimeNo="";
String examinationTime="";
String examinationPlace="";
String consent="";
String invResult="";
int pulse=0;
String bp="";
String deformity="";
String pallor="";
String gis="";
String rs="";
String cvs="";
String ns="";
String remarks="";
String build="";
String refDate="";
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
		  fatherName=mlc.getHin().getFatherMotherName();
	}else if(mlc.getInpatient()!=null){
		
		fatherName=mlc.getInpatient().getHin().getFatherMotherName();
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
	  if(mlc.getOpdPatientDetail()!=null && mlc.getOpdPatientDetail().getGeneralExamination()!=null){
		  his=mlc.getOpdPatientDetail().getGeneralExamination();
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
	  
	  if(mlc.getOpdPatientDetail()!=null){
		  detailId=mlc.getOpdPatientDetail().getId();
		  if(mlc.getOpdPatientDetail().getHeight()!=null){
			  height=mlc.getOpdPatientDetail().getHeight();
		  }
		  if(mlc.getOpdPatientDetail().getOpdDate()!=null){
		  opdDate=HMSUtil.convertDateToStringWithoutTime(mlc.getOpdPatientDetail().getOpdDate());
		  }
if(mlc.getOpdPatientDetail().getWeight()!=null){
	weight=mlc.getOpdPatientDetail().getWeight();
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
 

for(MedicoLegalDetails legalDetails:meDetails){
	
	  mediCoId=legalDetails.getId();
	  srNo= legalDetails.getSerialNo()!=null ? legalDetails.getSerialNo():"";
	  examinDate=legalDetails.getExaminationDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getExaminationDate())  :"";
	  refDate=legalDetails.getRefDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRefDate())  :"";
	  idMark1=legalDetails.getIdMark1()!=null ?legalDetails.getIdMark1() :"";
	  idMark2=legalDetails.getIdMark2()!=null ?legalDetails.getIdMark2() :"";
	  policeSt=legalDetails.getPoliceStation()!=null ?legalDetails.getPoliceStation():"";
	  examinationTime=legalDetails.getExaminationTime()!=null ?legalDetails.getExaminationTime():"";
	  examinationPlace=legalDetails.getExaminationPlace()!=null ?legalDetails.getExaminationPlace():"";
	  witt1= legalDetails.getWitnesses1()!=null ?legalDetails.getWitnesses1():"";
	  witt2= legalDetails.getWitnesses2()!=null ?legalDetails.getWitnesses2():"";
	  witt1Add=legalDetails.getWitnesses1Address()!=null ?legalDetails.getWitnesses1Address():"";
	  witt2Add=legalDetails.getWitnesses2Address()!=null ?legalDetails.getWitnesses2Address():"";
	  reqForm=legalDetails.getRequisitionFrom()!=null ?legalDetails.getRequisitionFrom():"";
	 if(legalDetails.getNoOfAdditionalSheets()!=null){ 
	  addiTion=legalDetails.getNoOfAdditionalSheets()!=0 ?legalDetails.getNoOfAdditionalSheets():0;
	 }
	  opNion=legalDetails.getOpinion()!=null ?legalDetails.getOpinion():"";
	  sonOf1=legalDetails.getWitnesses1Father()!=null ?legalDetails.getWitnesses1Father():"";
	  sonOf2=legalDetails.getWitnesses2Father()!=null ?legalDetails.getWitnesses2Father():"";
	  boughtBy=legalDetails.getBroughtBy()!=null?legalDetails.getBroughtBy():"";
	  boughtAddress=legalDetails.getBroughtByAddress()!=null?legalDetails.getBroughtByAddress():"";
	  histInj=legalDetails.getHistoryByInjured()!=null?legalDetails.getHistoryByInjured():"";
	  injDetail=legalDetails.getInjuryDetails()!=null?legalDetails.getInjuryDetails():"";
	  invResult=legalDetails.getInvResult()!=null?legalDetails.getInvResult():"";
	  his=legalDetails.getHistoryOfIllness()!=null?legalDetails.getHistoryOfIllness():"";
	  admitted=legalDetails.getPatientStatus()!=null ?legalDetails.getPatientStatus():"";
	  injuriesApp=legalDetails.getInjuryType()!=null ?legalDetails.getInjuryType():"";
	  couInj=legalDetails.getHistoryInjuryCause()!=null?legalDetails.getHistoryInjuryCause():"";
	  serNo=legalDetails.getSerialNo()!=null?legalDetails.getSerialNo():"";
	  crimeNo=	  legalDetails.getCrimeNo()!=null?legalDetails.getCrimeNo():"";
	  consent=	  legalDetails.getConsent()!=null?legalDetails.getConsent():"";
	  if(legalDetails.getPulse()!=null){ 
		  pulse=legalDetails.getPulse()!=0 ?legalDetails.getPulse():0;
		 }
	  bp=legalDetails.getBp()!=null?legalDetails.getBp():"";
	  deformity=legalDetails.getDeformity()!=null?legalDetails.getDeformity():"";
	  pallor=legalDetails.getPallor()!=null?legalDetails.getPallor():"";
	  gis=legalDetails.getGis()!=null?legalDetails.getGis():"";
	  rs=legalDetails.getRs()!=null?legalDetails.getRs():"";
	  cvs=legalDetails.getCvs()!=null?legalDetails.getCvs():"";
	  ns=legalDetails.getNs()!=null?legalDetails.getNs():"";
	  remarks=legalDetails.getRemarks()!=null?legalDetails.getRemarks():"";
	  build=legalDetails.getBuild()!=null?legalDetails.getBuild():"";
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

<div class="Block">
<label><span>*</span> UHID</label>
<input name="uhinId" id="uhinId" validate="UHID,string,yes" value="<%=hinNo %>" readonly="readonly" > 
  <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
<input type="hidden"  id="hinId"  name="hinId" readonly="readonly" value="<%= hinId%>"/>
<input type="hidden" name="mediCoId" id="mediCoId"  value="<%= mediCoId%>">
</div>
<div class="titleBg">
<h2>Examination by a Medical Officer</h2>
</div>
<div class="Block">
<div class="clear"></div>

<label>Ref. ML No. <span>*<span></label>
<%if(srNo.equalsIgnoreCase("")){%>
<input type="text"   id="refMLNo" name="refMLNo" validate="RF NO,String,Yes" maxlength="16" value="<%= orderNo%>" readonly="readonly"/>
<%}else{ %>
<input type="text"   id="refMLNo" name="refMLNo" readonly="readonly" maxlength="16" value="<%=srNo %>"/>
<%} %>	
	
<label>Ref. ML Date</label>
<%if(refDate.equalsIgnoreCase("")){ %>
<input type="text" id="refMLDate" name="refMLDate" validate="Ref. ML Date,date,no" class="date"  value="<%=currentDate %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />
	<%}else{ %>
	<input type="text" id="refMLDate" name="refMLDate" validate="Ref. ML Date,date,no" class="date"  value="<%=refDate %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />
	
	<%} %>

<label>Requisition From</label>
<input type="text"   id="requisitionFrom" name="requisitionFrom" maxlength="16" value="<%=reqForm%>" readonly="readonly"/>
<div class="clear"></div>	

<label>Requisition Date</label>
<input type="text" id="requisitionDate" name="requisitionDate" validate="Ref. ML Date,date,no"  value="<%=opdDate %>" class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.requisitionDate,true);" />



<label>Name</label>
<input type="text" id="pname" name="pname" value="<%=name %>" readonly="readonly" />
    

<label>S/o Name</label>
<input type="text" id="fatherName" name="fatherName" value="<%=(fatherName!=null)?fatherName:"" %>" readonly="readonly" />
    
<div class="clear"></div>

<label>Address</label>
<textarea  readonly="readonly" id="address" name="address" class="textareaMediua"><%=address %></textarea>
    
	 <input type="hidden"  id="gender"  name="gender" readonly="readonly"/>
	 <input type="hidden"  id="occupation"  name="occupation" readonly="readonly"/>
	 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly"/>



<label>CR NO.</label>
<input type="text"   id="crNO" value="<%=crimeNo %>" name="crNO" maxlength="16"/>


<label>Police Station</label>
<textarea  id="policeStation" name="policeStation" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"><%=policeSt %></textarea>

<div class="clear"></div>
<label>Crime Time</label>
<input type="text"  value="<%=examinationTime %>"  id="examConcludedTime" name="examConcludedTime" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>


<label>Crime Date</label>
<input type="text" id="examinationConcludedDate" name="examinationConcludedDate" validate="Crime Date,date,no"  value="<%=examinDate %>" class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.examinationConcludedDate,true);" />



 <label>Place of examination</label>
 <textarea  id="placeExamination" name="placeExamination" class="textareaMediua"  maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"><%=examinationPlace %></textarea>

  
  <div class="clear"></div>



<label>Consent</label>
<textarea  id="consent" name="consent" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=consent %></textarea>
  
  <label>Id Mark 1</label>
   <input type="text" name="idmark1" validate="Id mark 1,string,no" maxlength="90" value="<%=idMark1%>">
  
  <label>Id Mark 2</label>
    <input type="text" name="idmark2" validate="Id mark 2,string,no" maxlength="90" value="<%=idMark2%>">
  
<div class="clear"></div>
 <h4>History </h4> 
 <div class="clear"></div>
 <label>Illness /Injury</label>
 <%if(mediCoId!=0){ %>
 <textarea  id="illness" name="illness" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=his%></textarea>
 <%}else{ %>
<textarea  id="illness" name="illness" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=patientHistories.get(0).getPastIllnessHistory()%></textarea>
 <%} %>
 
<!-- <textarea  id="injury" name="injury" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"></textarea> -->
  
   
<div class="clear"></div>

 <!-- Edited By Amit Das -->
<h2>Physical examination</h2>
<h4>General</h4>

  <label>Height </label>
  <input type="text" name="height" value="<%=height%>" validate="Height,double,no" maxlength="3">

  <label>Weight </label>
   <input type="text" name="weight" value="<%=weight%>" validate="Weight,double,no" maxlength="3">

  <label>Build and Nourishment</label>
    <select name="buildnourishment" id="buildnourishment"  >
        <%if(build.equalsIgnoreCase("")) {%>
         <option value="">Select</option>
  <option value="Obese">Obese</option>
  <option value="Moderate">Moderate</option>
  <option value="Poor">Poor</option>
        
        
  <%}if(build.equalsIgnoreCase("Obese")){ %>
  <option value="">Select</option>
  <option value="Obese" selected="selected">Obese</option>
  <option value="Moderate">Moderate</option>
  <option value="Poor">Poor</option>
  
 <%}if(build.equalsIgnoreCase("Moderate")){ %>
  <option value="">Select</option>
  <option value="Obese">Obese</option>
  <option value="Moderate" selected="selected">Moderate</option>
  <option value="Poor">Poor</option>
  <%}if(build.equalsIgnoreCase("Poor")){ %>
  <option value="">Select</option>
  <option value="Obese">Obese</option>
  <option value="Moderate">Moderate</option>
  <option value="Poor" selected="selected">Poor</option>
    
  <%}%>
 
  
  </select>
  
  <label>Pallor</label>
    <select name="pallor" id="pallor"  >
    <%if(pallor.equalsIgnoreCase("")) {%>
    
      <option value="">Select</option>
  <option value="Present" >Present</option>
  <option value="Absent" >Absent</option>
  <%}if(pallor.equalsIgnoreCase("Present")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Absent">Absent</option>
  <%} %>
  <%if(pallor.equalsIgnoreCase("Absent")){ %>
  <option value="">Select</option>
  <option value="Present" selected="selected">Present</option>
  <option value="Absent" selected="selected">Absent</option>
  <%}%>
   </select>
  
   <label>Deformity</label>
<textarea  id="deformity" name="deformity" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=deformity %></textarea>
  <label>Remarks</label>
<textarea  id="remarks" name="remarks" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=remarks %></textarea>
 
 <h4>Systemic Examination</h4> 
 
    <label>Pulse:</label>
  <input type="text" name="pulse" value="<%=pulse %>" validate="pulse,string,no" maxlength="3">
  <label>B. P.</label>
  <input type="text" name="bp" value="<%=bp %>"  validate="bp,string,no" maxlength="3">
   <label>CVS</label>
  <input type="text" name="cvs" value="<%=cvs %>" validate="CVS,string,no" maxlength="3">
    <label>NS</label>
  <input type="text" name="ns" value="<%=ns %>" validate="NS,string,no" maxlength="3">
     <label>RS</label>
  <input type="text" name="rs" value="<%=rs %>" validate="RS,string,no" maxlength="3">
       <label>GIS</label>
  <input type="text" name="gis" value="<%=gis %>" validate="GIS,string,no" maxlength="3">
  <div class="clear"></div>

<label>Injuries</label>
<textarea  id="injuries" name="injuries" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=injDetail %></textarea>
  
<label>Investigations</label>
<textarea  id="investigations" name="investigations" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=invResult %></textarea>

  <div class="clear"></div>   
  <div class="clear"></div>  
 
<label>OPINION/Suggestions</label>
<textarea  id="opinion" name="opinion" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1"><%=opNion%></textarea>   

<div class="clear"></div>
<div id="edited"></div>
 <% if(meDetails.size()==0) {%>
 <input type="button" name="add" id="addbutton" value="Submit" 	class="button"	onClick="submitForm('mlc','mlc?method=submitMedicalOfficerCertificate&flag=submit');"	accesskey="a" tabindex=1 />
 <% }else{ %>
 <input type="button" name="add" id="addbutton" value="Authorization" 	class="button"	onClick="submitForm('mlc','mlc?method=submitMedicalOfficerCertificate&flag=authorization');"	accesskey="a" tabindex=1 />
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


