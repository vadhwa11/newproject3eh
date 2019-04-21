
<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.Patient"%>
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
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>

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

Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();


if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");

List<Patient> patientList = new   ArrayList<Patient>();
if(map.get("patientList") != null){
	patientList=(List<Patient>)map.get("patientList");
}

List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
if(map.get("mlcList") != null){
	mlcList=(List<OpdPatientDetails>)map.get("mlcList");
}

// added by Amit Das on 19-04-2016
List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
if(map.get("patientHistories")!=null) {
	patientHistories	= (List<OpdPatientHistory>)map.get("patientHistories");
}
List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
if(map.get("patientWiseMlcs")!=null){
	patientWiseMlcs=(List<PatientWiseMlc>)map.get("patientWiseMlcs");
}

List<PatientAddress> patientAddress = new ArrayList<PatientAddress>();
if(map.get("patientAddress")!=null){
	patientAddress=(List<PatientAddress>)map.get("patientAddress");
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


String time = (String)utilMap.get("currentTime");
ArrayList searchTitleList = (ArrayList)map.get("searchTitleList");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}


%>	

<div class="titleBg">
<h2>No Objection Certificate </h2>
</div>
<form name="noCertificate" method="post" action="">
<div class="clear"></div>
<div class="Block">

<label><span>*</span> UHID</label>
<input type="text" name="uhinId" id="uhinId" validate="UHID,string,yes" MAXLENGTH="50" value="<%=hinNo%>"> 

</div>
<div class="clear"></div>
<div class="Block">
<label>Name of the Applicant</label>
<input type="text"  name="name" id="name" value="<%=name %>">
 <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
  <input type="hidden"  name="hinId"   value="<%= hinId%>"/>
  <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
  <input type="hidden" name="uhinId" id="uhinId" validate="UHID,string,yes" MAXLENGTH="50" value="<%=hinNo%>"> 

<label>Date of PM examination</label>
<input 	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.birth.<%=FROM_DATE%>,event);" />




<label>Address </label>
<textarea rows="4" cols="50" name="address" readonly="readonly" class="textareaMediua" >
<%=address %>
</textarea>

<div class="clear"></div>


<label>Relation to the deceased</label>
 <input type="text"  name="relation" id="relation" maxlength="120"/>



<label>Crime No</label>
<input type="text"  name="crNO" id="crNO" maxlength="16">


<label>Name of police station </label>
 <input type="text"  name="policeStation" id="policeStation" maxlength="120">
 
 <div class="clear"></div>

<label class="auto">Reason for applying for copy of the certificate</label>
<textarea rows="5" cols="50" name="resion"  maxlength="250" class="textareaMediua"  onkeyup="return ismaxlength(this)" ></textarea>

<div class="clear"></div>

</div>
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<input type="button" name="Submit" id="Submit" value="Submit"	class="buttonBig"	onClick="submitForm('noCertificate','mlc?method=submmitNOObjectionCerificate');"	accesskey="a" tabindex=1 />
	
	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>








