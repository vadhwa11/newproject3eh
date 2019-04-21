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
<script type="text/javascript">

function uterusText(){	
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
		}		
</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
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
String reqForm="";
int height=0;
int weight=0;
if(mlcList.size()>0){
	
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
				  height=mlc.getOpdPatientDetail().getHeight();
			  }
			
	if(mlc.getOpdPatientDetail().getWeight()!=null){
		weight=mlc.getOpdPatientDetail().getWeight();
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
<input name="uhinId" id="uhinId" validate="UHID,string,yes" value="<%=hinNo %>" readonly="readonly" > 
  <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
<input type="hidden"  id="hinId"  name="hinId" readonly="readonly" value="<%= hinId%>"/>
  <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
</div>
<div class="titleBg">
<h2>Examination Of Victim Alleged Drugged</h2>
</div>
<div class="Block">
<div class="clear"></div>
	
<label>Ref.ML No./VAD</label>
<input type="text"   id="refMLNo" name="refMLNo" maxlength="16" value="<%=orderNo %>"/>


<label>Ref.ML Date</label>
<input type="text" id="refMLDate" name="refMLDate" validate="Ref. ML Date,date,no" class="date"  onkeyup="mask(this.value,this,'2,5','/');"  onblur="checkMonth(this,this.value);"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />

<div class="clear"></div>
<label>Requisition  From</label>
<textarea  id="requisitionFrom" name="requisitionFrom" class="textareaMediua" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1"><%=reqForm %></textarea> 

<label>Police station</label>
<textarea  id="policeStation" name="policeStation" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"></textarea>

<label>Requisition Date</label>
  <input type="text" id="requisitionDate" name="requisitionDate" validate="Ref. ML Date,date,no" class="date"  onkeyup="mask(this.value,this,'2,5','/');"  onblur="checkMonth(this,this.value);"/>
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.requisitionDate,true);" />
  <div class="clear"></div>
  
<label>HC/PC No</label>
<input type="text"   id="PCNo" name="PCNo" maxlength="16"/>

<div class="clear"></div>

	<label>Name</label>
<input type="text" id="pname" name="pname" value="<%=name %>" readonly="readonly" />
    
    <label>Address</label>
	<input type="text"  readonly="readonly" id="address" name="address" value="<%=address%>"/>
    
    <label>Age</label>
<input type="text" id="age"  name="age" value="<%=age %>" readonly="readonly" />
	
	 <input type="hidden"  id="gender"  name="gender" readonly="readonly"/>
	 <input type="hidden"  id="occupation"  name="occupation" readonly="readonly"/>
	 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly"/>

<div class="clear"></div>

<label>Consent</label>
<textarea  id="consent" name="consent" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"></textarea>
 
<label>Examin Date</label>
<input type="text" id="examinDate" name="examinDate" validate="Ref. ML Date,date,no" class="date"  onkeyup="mask(this.value,this,'2,5','/');"  onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.examinDate,true);" />
 
<label>Examin Time</label> 
 <input type="text"   id="exTime" name="exTime" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
 
  <label>Id Mark 1</label>
 <textarea  id="identificationOne" name="identificationOne" class="textareaMediua"  maxlength="90"  tabindex="1"></textarea>
  <label>Id Mark 2</label>
 <textarea  id="identificationTwo" name="identificationTwo" maxlength="90"   tabindex="1" class="textareaMediua"></textarea>
<div class="clear"></div>
 <h4>History </h4> 
 <div class="clear"></div>
  
<div class="clear"></div>
<label>Incident Date</label>
<input type="text" id="insDate" name="insDate" validate="Menstrual Date,date,no"  class="date"  onkeyup="mask(this.value,this,'2,5','/');"  onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.insDate,true);" />

<label>Incident Time</label>
<input type="text"   id="insTime" name="insTime" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>

<label>Mode of Adminitration</label> 
<input type="text"   id="madminitration" name="madminitration"/>

<label>Loss of consciousness</label>
  <select name="consciousness" id="consciousness" >
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
   <option value="Cant remember">Cant remember</option>
  </select>

 <label>Unconsciousness Period</label>
  <input type="text"  id="uPeriod" name="uPeriod" onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
 <div class="clear"></div>
  <label>Recovery</label>
  <select name="recovery" id="recovery" >
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
   </select>
   
     <label>Remember</label>
  <select name="remember" id="remember" >
  <option value="">Select</option>
  <option value="Yes">Yes</option>
  <option value="No">No</option>
   </select>
   
  <label>Remarks</label> 
 <textarea  id="remarks" name="remarks" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"></textarea>
   
   
<div class="clear"></div>

  <h4>General examination</h4>
  <label>Clothing</label>
    <select name="clothing" id="clothing"  >
  <option value="">Select</option>
  <option value="In proper order">In proper order</option>
  <option value="Disordered.">Disordered.</option>
   </select>
    <label>Consciousness Level</label>
    <select name="conscilevel" id="conscilevel"  >
  <option value="">Select</option>
  <option value="Conscious">Conscious</option>
  <option value="Semiconscious">Semiconscious</option>
   <option value="Unconscious">Unconscious</option>
   </select>
   
       <label>Alertness:</label>
    <select name="alertness" id="alertness"  >
  <option value="">Select</option>
  <option value="Alert">Alert</option>
  <option value="Drowsy">Drowsy</option>
   <option value="Stuperous">Stuperous</option>
   </select>
   
          <label>General disposition</label>
    <select name="disposition" id="disposition"  >
  <option value="">Select</option>
  <option value="Calm">Calm</option>
  <option value="Anxious">Anxious/</option>
   <option value="Depressed">Depressed</option>
   </select>
   
            <label>Speech</label>
    <select name="speech" id="speech"  >
  <option value="">Select</option>
  <option value="Normal">Normal</option>
  <option value="Thick and slurred">Thick and slurred</option>
   <option value="Incoherent.">Incoherent.</option>
   </select>
   
            <label>Memory(Recent/Remote)</label>
    <select name="memory" id="memory"  >
  <option value="">Select</option>
  <option value="Normal">Normal</option>
  <option value="Impaired">Impaired</option>
   </select>
            <label>Orientation of time</label>
    <select name="orientation" id="orientation"  >
  <option value="">Select</option>
  <option value="Normal">Normal</option>
  <option value="Impaired">Impaired</option>
   </select>
   
    <label>Place & Person</label>
    <select name="person" id="person"  >
  <option value="">Select</option>
  <option value="Normal">Normal</option>
  <option value="Impaired">Impaired</option>
   </select>
  
    <label>Reaction time</label>
    <select name="reaction" id="reaction"  >
  <option value="">Select</option>
  <option value="Normal">Normal</option>
  <option value="Delayed">Delayed</option>
   </select>
  <div class="clear"></div>
  
  <div class="clear"></div>

<h2>Physical examination</h2>
 <div class="clear"></div>
  <div class="clear"></div>
  <label>Height </label>
  <input type="text" name="height" validate="Height,int,no" maxlength="3" value="<%=height%>" >

  <label>Weight </label>
   <input type="text" name="weight" validate="Weight,int,no" maxlength="3" value="<%=weight%>" >

  <label>Build and Nourishment</label>
    <select name="nourishment" id="nourishment"  >
  <option value="">Select</option>
  <option value="Good">Good</option>
  <option value="Moderate">Moderate</option>
  <option value="Poor">Poor</option>
  </select>
  <div class="clear"></div>
  
  <label>Conjunctiva</label>
  <select name="conjunctivalPallor">
    <option value="">Select</option>
  <option value="Normal">Normal</option>
  <option value="Congested">Congested</option>
  </select>
   <label>Pupils</label>
  <select name="pupils">
    <option value="">Select</option>
  <option value="Pinpoint">Pinpoint</option>
  <option value="Congested">Congested</option>
   <option value="Normal">Normal</option>
    <option value="Dilated">Dilated</option>
    <option value="Sluggishly reacting">Sluggishly reacting</option>
  </select>
  
  <label>Nostrils and nasal mucosa</label>
  <input type="text" name="mucosa"  maxlength="3">
  <label>Lips</label>
  <input type="text" name="lips"  maxlength="3">
  
  <label>Oral Cavity</label>
  <input type="text" name="cavity"  maxlength="3">
   <label>Circum-Oral</label>
  <input type="text" name="circum-oral"  maxlength="3">
   <label>Marks of injection</label>
  <input type="text" name="marksInj"  maxlength="3">
  
    <label>Muscular Co-Ordination</label>
  <select name="muscular">
    <option value="">Select</option>
  <option value="Normal">Normal</option>
  <option value="Impaired">Impaired</option>
  </select>
  
    <label>Reflexes</label>
  <select name="reflexes">
    <option value="">Select</option>
  <option value="Normal">Normal</option>
  <option value="Exaggerated">Exaggerated</option>
  <option value="Sluggish">Sluggish</option>
  </select>
 
     <label> Rombergs Sign</label>
  <select name="rombergs">
    <option value="">Select</option>
  <option value="Positive">Positive</option>
  <option value="Negative">Negative</option>

  </select>
   <label>Finger Nose Test</label>
  <select name="fingerNose">
    <option value="">Select</option>
  <option value="Positive">Positive</option>
  <option value="Negative">Negative</option>

  </select>
    <label>Gait</label>
  <select name="gait">
    <option value="">Select</option>
  <option value="Normal">Normal</option>
  <option value="Unsteady">Unsteady</option>
  </select>
  
   <h4>Systemic Examination Findings</h4> 
      <label>Pulse</label>
      <input type="text" name="pulse" id="pulse"  value="<%=(mlcList!=null && mlcList.size()>0)?mlcList.get(0).getBp():0%>" >

   <label> B.P.</label>
      <input type="text" name="bp" id="bp" value="<%=(mlcList!=null && mlcList.size()>0)?mlcList.get(0).getBp():0%>" >
      
       <label>Injuries</label>
   <textarea  id="injury" name="injury" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"></textarea>
   
        <label>Remarks</label>
   <textarea  id="remark" name="remark" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"></textarea>
 
  <h4>Laboratory examination</h4>
     <label>Nasal swabs</label>
  <select name="nasalswabs">
    <option value="">Select</option>
  <option value="Preserved">Preserved</option>
  <option value="Not Applicable">Not Applicable</option>
  </select>
    <label>Stomach Aspirate</label>
  <select name="stomachaspirate">
    <option value="">Select</option>
  <option value="Preserved">Preserved</option>
  <option value="Not Applicable">Not Applicable</option>
  </select>
     
     <label>Vomitus</label>
  <select name="vomitus">
    <option value="">Select</option>
  <option value="Preserved">Preserved</option>
  <option value="Not Applicable">Not Applicable</option>
  </select>    
       <label>Blood</label>
  <select name="blood">
    <option value="">Select</option>
  <option value="Preserved">Preserved</option>
  <option value="Not Applicable">Not Applicable</option>
  </select>  
  
        <label>Urine</label>
  <select name="urine">
    <option value="">Select</option>
  <option value="Preserved">Preserved</option>
  <option value="Not Applicable">Not Applicable</option>
  </select>  
   
  
  <div class="clear"></div>   
  <div class="clear"></div>  
 
<label>OPINION</label>
<textarea  id="opinion" name="opinion" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1"></textarea>   

<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('mlc','mlc?method=submitVictimAllegedDrugged');"	accesskey="a" tabindex=1 /> 
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


