
<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<script type="text/javascript" language="javascript">
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
		serverdate = '<%=date+"/"+month+"/"+year%>';
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



String hinNo="";
String name="";
String age="";
String gender="";
String address="";
int detailId=0;
int hinId=0;
int inpationId=0;

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

<div class="titleBg">
<h2>Authenticity Certificate </h2>
</div>
<form name="authenticityCertificate" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="Block">
<label><span>*</span> UHID</label>
<input name="uhinId" id="uhinId" validate="UHID,string,yes" value="<%=hinNo %>" readonly="readonly" > 
  <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
<input type="hidden"  id="hinId"  name="hinId" readonly="readonly" value="<%= hinId%>"/>
  <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>

<label>Insurence Company Name</label>
<input type="text"  name="insurenceCompanyName" id="insurenceCompanyName">

<label>Reference Policy/Claim No</label>
<input type="text"  name="claimNo" id="claimNo">

<div class="clear"></div>

<label>Postmortem No</label>
<input type="text"  name="postmortemNo" id="postmortemNo">

<label>Postmortem Date</label>
<input 	type="text" name="poDate" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfPostmortem,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.birth.<%=FROM_DATE%>,event);" />


<div class="clear"></div>

<label>Name</label>
<input type="text"  name="name" id="name" value="<%=name %>">

<label>Age</label>
<input type="text"  name="age" id="age" value="<%=age%>" > 

<label>Gender</label>
<input type="text"  name="gender" id="gender" value="<%=gender%>">

<label>Address </label>
<textarea rows="4" cols="50"><%=address%>
</textarea>

<div class="clear"></div>
<div class="clear"></div>

<label>Crime No</label>
<input type="text"  name="crNO" id="crNO">
<label>Police station </label>
 <input type="text"  name="policeStation" id="policeStation">

<label>Name Of Doctor</label>
 <input type="text"  name="doctorName" >
<label>Designation Of Doctor</label>
 <input type="text"  name="desination" id="desination">

<label>Institution Name</label>
 <input type="text"  name="institute" id="institute">
<div class="clear"></div>

<h4>Certified BY</h4>

<label>Doctor</label>
 <input type="text"  name="doctor" id="doctor">

<label>Working as</label>
 <input type="text"  name="workingAs" id="workingAs">

 <label>Attached To</label>
 <input type="text"  name="attached" id="attached">

 <label>Postmortem Certificate No</label>
 <input type="text"  name="crtificateNO" id=" ">

<div class="clear"></div>

<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<input type="button" name="Submit" id="Submit" value="Submit"
	class="buttonBig"
	onClick="submitForm('authenticityCertificate','mlc?method=addAuthenticityCertificate');"
	accesskey="a" tabindex=1 />
</form>







