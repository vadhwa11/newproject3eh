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
</div>
<div class="titleBg">
<h2>REFERRING A POSTMORTEM EXAMINATION</h2>
</div>
<div class="Block">
<div class="clear"></div>
<label>P.M. No</label>
<input type="text"   id="pmNo" name="pmNo" maxlength="16"/>
<label>Date</label>
<input type="text" id="pmDate" name="pmDate" validate="Ref. ML Date,date,no" class="date"  onkeyup="mask(this.value,this,'2,5','/');"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />

<label>Crime No:</label>
<input type="text" id="crno"  name="crno" />
 <label>Police Station</label>
<input type="text" name="ofPolice" id="ofPolice" />
<label>Received From</label>
<input type="text"   id="recFrom" name="recFrom" maxlength="16"/>
<label>Time</label>
<input type="text"   id="time" name="menstrualTime" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
<label>On Date</label>
<input type="text" id="recDate" name="recDate" validate="Menstrual Date,date,no"  class="date"  onkeyup="mask(this.value,this,'2,5','/');"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.menstrualDate,true);" />
<div class="clear"></div>
	<label>Name</label>
<input type="text" id="pname" name="pname" value="<%=name %>" readonly="readonly" />
   
    <label>Address</label>
	<input type="text"  readonly="readonly" id="address" name="address"/>
    
    <label>Age</label>
<input type="text" id="pname" name="pname" value="<%=age %>" readonly="readonly" />
<div class="clear"></div>
<label>Letter Cr. No</label>
<textarea  id="crNOLatter" name="crNOLatter" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"></textarea>
 <label>Date</label>
<input type="text" id="crDate" name="crDate" validate="Ref. ML Date,date,no" class="date"  onkeyup="mask(this.value,this,'2,5','/');"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />
 
<label>P.C.No</label> 
 <input type="text"   id="pcNO" name="pcNO"/>
 <h4>Postmortem Examination Commenced</h4>

<label>Time</label>
<input type="text"   id="posTime" name="posTime" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
 
 
 <label>Date</label>
<input type="text" id="postDate" name="postDate" validate="Ref. ML Date,date,no" class="date"  onkeyup="mask(this.value,this,'2,5','/');"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.mlc.refMLDate,true);" />
  <label>Cause Of Death</label> 
 <textarea  id="dethResion" name="dethResion" maxlength="90"  onkeyup="return ismaxlength(this)" tabindex="1" class="textareaMediua"></textarea>
<div class="clear"></div>
<label>On the body</label>
<textarea  id="onBody" name="onBody" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)" tabindex="1"></textarea>   

<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('mlc','mlc?method=addReffringPostmortamExam');"	accesskey="a" tabindex=1 /> 
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


