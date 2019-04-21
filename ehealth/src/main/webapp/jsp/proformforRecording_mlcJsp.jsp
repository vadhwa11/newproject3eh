<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
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
<script>
		    function validateHhMm(inputField) {
		        var isValid = /^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$/.test(inputField.value);

		        if (isValid) {
		            inputField.style.backgroundColor = '#bfa';
		        } else {
		            inputField.style.backgroundColor = '#fba';
		        }

		        return isValid;
		    }			
		
	</script>
<%

Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();


if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
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
List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
if(map.get("mlcList")!=null){
	mlcList=(List<OpdPatientDetails>)map.get("mlcList");
}

List<Inpatient> inpatientList = new ArrayList<Inpatient>();
if(map.get("inpatientList")!=null){
	inpatientList=(List<Inpatient>)map.get("inpatientList");
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
String injDeatil="";
String advise="";
int inpationId=0;
String docName="";
String docParent="";
String rankName="";
String place="";
 int docId=0;

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
	  if(mlc.getOpdPatientDetail()!=null){
		  docName=mlc.getOpdPatientDetail().getEmployee().getEmployeeName();
	}
	  if(mlc.getOpdPatientDetail()!=null){
		  docParent=mlc.getOpdPatientDetail().getEmployee().getFatherHusbandName();
	}  
	  
	  if(mlc.getOpdPatientDetail()!=null){
		  docParent=mlc.getOpdPatientDetail().getEmployee().getFatherHusbandName();
		  docId=mlc.getOpdPatientDetail().getEmployee().getId();
	}  
	  if(mlc.getOpdPatientDetail()!=null){
		  rankName=mlc.getOpdPatientDetail().getEmployee().getRank().getRankName();
	}  

	  if(mlc.getOpdPatientDetail()!=null){
		  place=mlc.getOpdPatientDetail().getEmployee().getPermanentAddress();
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
String message="";

if(map.get("message") != null){
	   message = (String)map.get("message");
}
String userName="";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}


%>	
<h4>
	<span><%=message %></span>
</h4>
<form name="dying" method="post" action="">
<div class="clear"></div>

<div class="titleBg">
<h2>Search</h2>
</div>
<div class="Block">
<label><span>*</span> UHID</label>
<input name="uhinId" id="uhinId" validate="UHID,string,yes"  readonly="readonly" value="<%= hinNo%>" />
 <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
  <input type="hidden"  name="hinId"   value="<%= hinId%>"/>
  <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
  
</div>

<div class="Block">
<div class="titleBg">
<h2>PROFORMA FOR RECORDING DYING DECLARATION BY A MEDICAL PRACTITIONER</h2>
</div>
<div class="clear" style="margin:5px 0px"></div>
<div id="detail">

<label>PRACTITIONER</label>
<input type="text"   id="pname" name="pname" value="<%= docName%>">
<input type="hidden"   id="docid" name="docid" value="<%= docId%>">

<label>Son/Daughter</label>
<input type="text"   id="pname" name="pname" value="<%= docParent%>">
 

<label>Working As</label>
<input type="text"   id="pname" name="pname" value="<%= rankName%>">
 
 
 <label>Address</label>

 <textarea rows="4" cols="50" id="address" name="address" class="textareaMediua"><%= place%></textarea>

<div class="clear"></div>

<label>Witnesses First</label>
<input type="text"   id="witfirst" name="witfirst" value="">

<label>Parent Name</label>
<input type="text"   id="fistParnt" name="fistParnt" value="">

<label>Address</label>
<textarea rows="4" cols="50" id="firstAddres" name="firstAddres" class="textareaMediua"></textarea>
<div class="clear"></div>

<label>Witnesses Second</label>
<input type="text"   id="witSecond" name="witSecond" value="">

<label>Parent Name</label>
<input type="text"   id="secParent" name="secParent" value="">

<label>Address</label>
<textarea rows="4" cols="50" id="secondAddres" name="secondAddres" class="textareaMediua"></textarea>

<div class="clear"></div>

<h4>Dying Declaration Of</h4>

<label>Name</label>
<input type="text"   id="pname" name="pname" value="<%= name%>">

<label>Sex</label>
<input type="text"  id="gender"  name="gender" readonly="readonly" value="<%= gender%>">

<label>Age</label>
<input type="text" id="age"  name="age" readonly="readonly" value="<%= age%>">
<input type="hidden"  id="gender"  name="gender" readonly="readonly"/>

<div class="clear"></div>
<label>Address</label>
<textarea rows="4" cols="50" id="address" name="address" class="textareaMediua"></textarea>

<div class="clear"></div>

<label>Time</label> 
 <input type="text"   id="time" name="time" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
<label>Date</label>
<input type="text" id="pDate" name="pDate" validate="Date,date,no" class="date"  onkeyup="mask(this.value,this,'2,5','/');"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.dying.pDate,true);" />

<label>At Place</label>
<textarea rows="4" cols="50"name="place" class="textareaMediua"></textarea>

<label>Examined</label>
<textarea rows="4" cols="50" nname="examind" class="textareaMediua"></textarea>


<label>Following Questions Asked</label>
<textarea rows="4" cols="50" nname="qustion" class="textareaMediua"></textarea>

<label>Answer</label>
<textarea rows="4" cols="50" nname="answer" class="textareaMediua"></textarea>

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
<input type="button" name="Submit"  value="Submit"
	class="buttonBig"
	onClick="submitForm('dying','mlc?method=addProformforRecording');"
	accesskey="a" tabindex=1 />
	</div>
	</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
