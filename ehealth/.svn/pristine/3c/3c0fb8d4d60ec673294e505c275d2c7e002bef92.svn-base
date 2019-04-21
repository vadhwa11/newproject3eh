<%@page import="org.syntax.jedit.InputHandler.redo"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
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

String hinNo="";
String name="";
String age="";
String gender="";
String address="";
int detailId=0;
int hinId=0;
int inpationId=0;

int mediCoId=0;
String crimeNo="";
String refDate="";
String policeSt="";
String ExaminationPlace="";
String MaterialObjectsPreserved="";
String Consent="";
String IdMark1="";
String IdMark2="";
String ArrestTime="";
String ArrestDate="";
String MaterialObjectsNotCollected="";
String RequisitionFrom ="";
String  Collection="";
String AccompByName ="";
String Reason ="";
String reqForm="";
String reqDate="";
String orderNo="";
String srNo="";
if(map.get("orderNo")!=null){
	orderNo=(String)map.get("orderNo");
}
for(MedicoLegalDetails legalDetails:meDetails){
	  mediCoId=legalDetails.getId();
	  srNo=legalDetails.getSerialNo()!=null ?legalDetails.getSerialNo():"";
	  crimeNo=legalDetails.getCrimeNo()!=null ?legalDetails.getCrimeNo():"";
	  
	  if(legalDetails.getRequisitionDate()!=null){
			 
		  reqDate=legalDetails.getRequisitionDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRequisitionDate())  :"";
			    }
	  
	  if(legalDetails.getRefDate()!=null){
			 
		  refDate=legalDetails.getRefDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRefDate())  :"";
			    }
	  
	  RequisitionFrom=legalDetails.getRequisitionFrom()!=null ?legalDetails.getRequisitionFrom():"";
	  Collection=legalDetails.getCollection()!=null ?legalDetails.getCollection():"";
	  ArrestTime=legalDetails.getArrestTime()!=null ?legalDetails.getArrestTime():"";
	  
	  if(legalDetails.getArrestDate()!=null){
			 
		  ArrestDate=legalDetails.getArrestDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getArrestDate())  :"";
			    }
	  AccompByName=legalDetails.getAccompByName()!=null ?legalDetails.getAccompByName():"";
	  Consent=legalDetails.getConsent()!=null ?legalDetails.getConsent():"";
	  IdMark1=legalDetails.getIdMark1()!=null ?legalDetails.getIdMark1():"";
	  IdMark2=legalDetails.getIdMark2()!=null ?legalDetails.getIdMark2():"";
	  policeSt=legalDetails.getPoliceStation()!=null ?legalDetails.getPoliceStation():"";
	  MaterialObjectsPreserved=legalDetails.getMaterialObjectsPreserved()!=null ?legalDetails.getMaterialObjectsPreserved():"";
	  MaterialObjectsNotCollected=legalDetails.getMaterialObjectsNotCollected()!=null ?legalDetails.getMaterialObjectsNotCollected():"";
	  Reason=legalDetails.getReason()!=null ?legalDetails.getReason():"";
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
  <input type="hidden" name="mediCoId" id="mediCoId"  value="<%= mediCoId%>">
  
</div>
<div class="titleBg">
<h2>DNA Profiling Examination At FSL</h2>
</div>
<div class="Block">
<div class="clear"></div>



<label>Ref. ML No. <span>*<span></label>

<%if(mediCoId!=0){%>
<input type="text"   id="refMLNo" name="refMLNo" validate="RF NO,String,Yes" maxlength="16" value="<%= srNo%>" readonly="readonly"/>
 <%}else{ %>
 <input type="text"   id="refMLNo" name="refMLNo" validate="RF NO,String,Yes" maxlength="16" value="<%= orderNo%>" readonly="readonly"/>
 <%}%>
<label>Ref. ML Date</label>
 <%if(mediCoId!=0){%>
<input type="text" id="refMLDate" name="refMLDate" validate="Ref. ML Date,date,no" class="date"   value="<%=refDate %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=refDate %>',document.mlc.refMLDate,true);" />
<%}else{ %>
<input type="text" id="refMLDate" name="refMLDate" validate="Ref. ML Date,date,no" class="date"   value="<%=currentDate %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />

<%} %>

<div class="clear"></div>
<label>Requisition</label>
 <%if(mediCoId!=0){%>
<input type="text"   id="requisitionFrom" name="requisitionFrom" maxlength="16" value="<%=RequisitionFrom %>"/>
<%}else{ %>
<input type="text"   id="requisitionFrom" name="requisitionFrom" maxlength="16" value="<%=reqForm %>"/>
<%} %>
<label>Requisition Date</label>
 <%if(mediCoId!=0){%>
<input type="text" id="reqDate" name="reqDate"  value="<%=refDate %>" validate="Requisition Date,date,no" class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=refDate %>',document.mlc.reqDate,true);" />
 <%}else{ %>
<input type="text" id="reqDate" name="reqDate"  value="<%=currentDate %>" validate="Requisition Date,date,no" class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.reqDate,true);" />
 <%}%>
<label>Collection</label>
<textarea  id="collection" name="collection"  maxlength="120" ><%=Collection %></textarea>
<label>CR NO.</label>
<input type="text"   id="crNo" name="crNo" maxlength="16" value="<%=crimeNo %>"/>
<label>Police Station</label>
<textarea  id="policeStation" name="policeStation" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)" tabindex="1"><%=policeSt %></textarea>
<div class="clear"></div>

<label>Crime Time</label> 
 <input type="text"   id="time" value="<%= ArrestTime%>"   name="time" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
 
<label>Crime Date</label>
<input type="text" id="crimeDate" name="crimeDate" validate="Crime Date,date,no" class="date" value="<%=ArrestDate %>"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.crimeDate,true);" />

<label>Accompanied By</label> 
 <input type="text"  id="accompaind" name="accompaind" value="<%=AccompByName %>"/>

 <div class="clear"></div>
<label>Name</label>
<input type="text" id="pname" name="pname" value="<%=name %>" readonly="readonly" />

     <label>Address</label>
    	<textarea  readonly="readonly" id="address" name="address"></textarea>
    	
     <label>Age</label>
<input type="text" id="age"  name="age" value="<%=age %>" readonly="readonly" />

<div class="clear"></div>
<label>Consent</label>
<textarea  id="consent" name="consent" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=Consent %></textarea>
  <label>Id Mark 1</label>
   <input type="text" name="mark1" validate="Id Mark,string,no" maxlength="90" value="<%=IdMark1%>">
  <label>Id Mark 2</label>
    <input type="text" name="mark2" validate="Id Mark,string,no" maxlength="90" value="<%= IdMark2%>">
<div class="clear"></div>
 <label>Material Objects</label> 
<textarea  id="materilObj" name="materilObj" maxlength="90"  tabindex="1" class="large"><%=MaterialObjectsPreserved %></textarea>
<div class="clear"></div>
 <label>Material Objects Not Collected</label> 
<textarea  id="notcollect" name="notcollect" maxlength="90"  tabindex="1" class="large"><%=MaterialObjectsNotCollected %></textarea>
<div class="clear"></div>
  <label>Reasons</label>
<textarea  id="resion" name="resion" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"><%=Reason %></textarea>

<div class="clear"></div>

 <% if(meDetails.size()==0) {%>
 <input type="button" name="add" id="addbutton" value="Submit" 	class="button"	onClick="submitForm('mlc','mlc?method=submitDNAprofilingexaminationFSL&flag=submit');"	accesskey="a" tabindex=1 />
 <% }else{ %>
 <input type="button" name="add" id="addbutton" value="Authorization" 	class="button"	onClick="submitForm('mlc','mlc?method=submitDNAprofilingexaminationFSL&flag=authorization');"	accesskey="a" tabindex=1 />
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


