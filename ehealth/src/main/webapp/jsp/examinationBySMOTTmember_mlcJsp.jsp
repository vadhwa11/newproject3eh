<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
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

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
String address="";
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
String orderNo="";
if(map.get("orderNo")!=null){
	orderNo=(String)map.get("orderNo");
}


String hinNo="";
String name="";
String age="";
String gender="";
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
	  String remarks="";
	  String  his="";
	  String  crimeNo="";
	  String  cosen="";
	  String sexUalDev="";
	  int height=0;
	  int weight=0;
	  int pulse=0;
	  String bp ="";
	  String otherHistory="";
	  String injBody="";
	  String byName="";
	String byAddress="" ;
	String recDate="";
	String refDate="";
	String revDate="";
	String recTime="";
	String examCommTime="";
	String examCommDate="";
	int inpationId=0;
	String clinicalHistory="";
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
 String invResult="";
 int circumference=0;
	for(PatientWiseMlc  mlc:patientWiseMlcs){
		  
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






for(MedicoLegalDetails legalDetails:meDetails){
	
	  mediCoId=legalDetails.getId();
	  srNo= legalDetails.getSerialNo()!=null ? legalDetails.getSerialNo():"";
	  crimeNo=legalDetails.getCrimeNo()!=null ?legalDetails.getCrimeNo():"";
	  examinDate=legalDetails.getArrestDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getArrestDate())  :"";
	  examinTime=legalDetails.getArrestTime()!=null ?legalDetails.getArrestTime() :"";
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
	  his=legalDetails.getPhysicalExamination()!=null?legalDetails.getPhysicalExamination():"";
	  sexUalDev=legalDetails.getHistorySexualDev()!=null?legalDetails.getHistorySexualDev():"";
	  agemarry=legalDetails.getAgeOfMarriage()!=null?legalDetails.getAgeOfMarriage():"";
	  histInj=legalDetails.getHistoryByInjured()!=null?legalDetails.getHistoryByInjured():"";
	  remarks=legalDetails.getRemarks()!=null?legalDetails.getRemarks():"";
	  invResult=legalDetails.getInvResult()!=null?legalDetails.getInvResult():"";
	  
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
 
 revDate=legalDetails.getReceivedDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getReceivedDate())  :"";
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
    		 scrotum =legalDetails.getScrotum()!=null ? legalDetails.getScrotum():"";
    		 rightTestis =legalDetails.getRightTestis()!=null ? legalDetails.getRightTestis():"";
    		 leftTestis=legalDetails.getLeftTestis()!=null ? legalDetails.getLeftTestis():"";
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
<h2>Examination by a Specialist Medical Officer/Team</h2>
</div>
<div class="Block">

<label>Ref.ML. No.</label>
<%if(srNo.equalsIgnoreCase("")){ %>
<input type="text"   id="refMLNo" name="refMLNo" maxlength="16"  value="<%=orderNo %>"/>
<%}else{ %>
<input type="text"   id="refMLNo" name="refMLNo" maxlength="16"  value="<%=srNo %>"/>
<%} %>
<label>ML.Date</label>
<%if(refDate.equalsIgnoreCase("")){ %>
<input type="text" id="refMLDate" name="refMLDate" validate="Ref. ML Date,date,no" class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />
<%}else{ %>
<input type="text" class="date"	name="requisitionDate" id="requisitionDate" value="<%=refDate %>" MAXLENGTH="30" validate="fromDate,date,no" onblur="checkMonth(this,this.value);"/>
<%} %> 
<div class="clear"></div>


<label>Requisition From</label>
<input type="text" name="requisitionFrom" id="requisitionFrom" value="<%= reqForm%>" maxlength="90" readonly="readonly" />


<label>Requisition Date</label> 
<%if(reqDate.equalsIgnoreCase("")){ %>
<input type="text" class="date"	name="requisitionDate" id="requisitionDate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no" onblur="checkMonth(this,this.value);"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.requisitionDate,event)" />

<%}else{ %>
<input type="text" class="date"	name="requisitionDate" id="requisitionDate" value="<%=reqDate %>" MAXLENGTH="30" validate="fromDate,date,no" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.requisitionDate,event)" />

<%} %> 


<label>Crime NO.</label>
<input type="text"   id="crNo" name="crNo" maxlength="16"  value="<%= crimeNo%>"/>

 <div class="clear"></div>
<label>Police Station</label>
<textarea  id="policeStation" name="policeStation" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"><%=policeSt %></textarea>

<label>Crime Time</label> 
 <input type="text"   id="time" name="time" onKeyUp="mask(this.value,this,'2,5',':');" value="<%=examinTime %>"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>



<label>Crime Date</label>
<input type="text" id="pDate" name="pDate" validate="Ref. ML Date,date,no" class="date" value="<%=examinDate %>"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.pDate,true);" />

 <div class="clear"></div>
<label>Name</label>
<input type="text" id="pname" name="pname" value="<%=name %>" readonly="readonly" />
     <label>Address</label>
<textarea  readonly="readonly" id="address" name="address"><%=address %></textarea>  
   <label>Age</label>
<input type="text" id="age"  name="age" value="<%=age %>" readonly="readonly" />
		 <input type="hidden"  id="gender"  name="gender" readonly="readonly"/>
	
<div class="clear"></div>
<label>Consent</label>
<textarea  id="consent" name="consent" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=cosen %></textarea>
  <label>Id Mark 1</label>
   <input type="text" name="mark1" value="<%=idMark1 %>" validate=Mark,string,no" maxlength="50">
  <label>Id Mark 2</label>
    <input type="text" name="mark2" validate="Mark,string,no" maxlength="50" value="<%=idMark2 %>">
<div class="clear"></div>
 <label>History </label> 
<textarea  id="history" name="history" maxlength="90"  tabindex="1" class="large"><%=histInj %></textarea>
<div class="clear"></div>
<div class="clear"></div>
<!-- <h4>Physical examination</h4>
  <label>Height </label>
  <input type="text" name="height" validate="Height,int,no" maxlength="3">
 <label>Weight </label>
   <input type="text" name="weight" validate="Weight,int,no" maxlength="3"> -->
  <label>Physical examination</label>
<textarea  id="remark" name="remark" class="large" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=remarks %></textarea>
<div class="clear"></div> 
<label>Investigations</label>
<textarea  id="invest" name="invest" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="large"><%=invResult %></textarea>
<div class="clear"></div>
 <label>OPINION</label>
<textarea  id="opinion" name="opinion" class="large" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1"><%=opNion %></textarea>   
<div class="clear"></div>
<div id="edited"></div>
 <% if(meDetails.size()==0) {%>
 <input type="button" name="add" id="addbutton" value="Submit" class="button"	onClick="submitForm('mlc','mlc?method=submitExaminationbySMOTTmember&flag=submit');" accesskey="a" tabindex=1 /> 
 <% }else{ %>
 <input type="button" name="authorization" id="authorization" value="Authorization" class="button"	onClick="submitForm('mlc','mlc?method=submitExaminationbySMOTTmember&flag=authorization');" accesskey="a" tabindex=1 /> 
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

</form>


