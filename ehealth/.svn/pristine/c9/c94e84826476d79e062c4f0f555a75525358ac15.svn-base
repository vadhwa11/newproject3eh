<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@ page trimDirectiveWhitespaces="true" %>
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
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
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
List<MedicoLegalDetails> meDetails = new ArrayList<MedicoLegalDetails>();
if(map.get("details")!=null){
	meDetails=(List<MedicoLegalDetails>)map.get("details");
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
String injDeatil="";
String advise="";
int mediCoId=0;
int inpationId=0;
String srNo="";
String refDate=""; 
String adDate="";
String disDate="";
String remarks1="";
String adForter="";
String conDis="";
String treet="";
String wocer="";
String inresult="";
String conatAdmi="";
int empId=0;
for(MedicoLegalDetails legalDetails:meDetails){
	  mediCoId=legalDetails.getId();
	  srNo= legalDetails.getSerialNo()!=null ? legalDetails.getSerialNo():"";

if(legalDetails.getRefDate()!=null){
  
  refDate=legalDetails.getRefDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getRefDate())  :"";
   }

address= legalDetails.getPatientAddress()!=null ? legalDetails.getPatientAddress():"";
	  
	  if(legalDetails.getAdmissionDate()!=null){
			 
		  adDate=legalDetails.getAdmissionDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getAdmissionDate())  :"";
			    }

	  if(legalDetails.getDischargeDate()!=null){
			 
		  disDate=legalDetails.getDischargeDate()!=null ? HMSUtil.convertDateToStringWithoutTime(legalDetails.getDischargeDate())  :"";
			    }
	  if(legalDetails.getDoctor()!=null){
			 
	  empId=legalDetails.getDoctor().getId();
	  }
	  remarks1=legalDetails.getRemarks()!=null ? legalDetails.getRemarks():"";
	  adForter=legalDetails.getAdviseOnDischarge()!=null ?legalDetails.getAdviseOnDischarge() :"";
	  conDis=legalDetails.getConditionAtDischarge()!=null ?legalDetails.getConditionAtDischarge() :"";
	  treet=legalDetails.getTreatment()!=null ?legalDetails.getTreatment():"";
	  
	  wocer=legalDetails.getInjuryDetails()!=null ?legalDetails.getTreatment():"";
	  
	  inresult=legalDetails.getInvResult()!=null ?legalDetails.getInvResult():"";
	  conatAdmi=legalDetails.getPatientCondition()!=null ?legalDetails.getPatientCondition():"";
	
  
  
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
<form name="treatment" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>

<div class="titleBg">
<h2>TREATMENT / DISCHARGE CERTIFICATE</h2>
</div>

<div class="Block">
<label><span>*</span> UHID</label>
<input name="uhinId" id="uhinId" validate="UHID,string,yes"  readonly="readonly" value="<%= hinNo%>" />
 <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
  <input type="hidden"  name="hinId"   value="<%= hinId%>"/>
  <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
  <input type="hidden" name="mediCoId" id="mediCoId"  value="<%= mediCoId%>">
  <%for(Inpatient inp:inpatientList){ %>
<label>IP No. </label>

<input type="text" name="adNO" value="<%=inp.getAdNo()%>">
<input type="hidden" name="<%=ADMISSION_NUMBER%>" value="<%=inp.getId()%>">
<% }%>

<div class="clear"></div>
	
<label>Ref No.<span>*<span></label>


 <%if(mediCoId!=0){%>
<input type="text"   id="refMLNo" name="refMLNo"  validate="PM No,String,Yes" value ="<%= srNo%>" maxlength="16" readonly="readonly"/>
 <%}else{ %>
 <input type="text"   id="refMLNo" name="refMLNo"  validate="PM No,String,Yes" value ="<%= orderNo%>" maxlength="16" readonly="readonly"/>
 <%}%>


<label>Ref.Date</label>
<input type="text" id="refMLDate" name="refMLDate" validate="Ref Date,date,no" value="<%=refDate%>" class="date"  onkeyup="mask(this.value,this,'2,5','/');" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=refDate %>',document.treatment.refMLDate,true);" />

	
<div class="clear"></div>

<label>Name</label>
<input type="text"   readonly="readonly" id="pname" name="pname" value="<%= name%>">
<label>Sex</label>
<input type="text"  id="gender"  name="gender" readonly="readonly" value="<%= gender%>">
<label>Age</label>
<input type="text" id="age"  name="age" readonly="readonly" value="<%= age%>">
<input type="hidden"  id="gender"  name="gender" readonly="readonly"/>
	 <input type="hidden"  id="occupation"  name="occupation" readonly="readonly"/>
	 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly"/>
<div class="clear"></div>
<label>Address</label>
<textarea rows="4" cols="50" id="address" name="address" readonly="readonly" class="textareaMediua"><%=address %></textarea>
<label>Date of admission</label>

 <%if(mediCoId!=0){%>
<input 	type="text" name="adDate" value="<%=adDate%>"	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"	readonly="readonly" />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=adDate%>',document.treatment.disDate,event);" />
<%}else{ %>
<input 	type="text" name="adDate" value="<%=currentDate%>"	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"	readonly="readonly" />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.treatment.adDate,event);" />
<%} %>


<label>Date of discharge</label>
<%if(mediCoId!=0){%>

<input 	type="text" name="disDate" value="<%=disDate%>"	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"	readonly="readonly" />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=disDate%>',document.treatment.disDate,event);" />
<%}else{ %>
<input 	type="text" name="disDate" value="<%=currentDate%>"	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"	readonly="readonly" />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.treatment.disDate,event);" />
<%} %>
	

<div class="clear"></div>
<label>Doctor Name</label>
<select name="docName" id="docName" class=""  validate="">
       <%	if(emplist.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasEmployee masEmp : emplist) {
					if(empId!=0 && masEmp.getId()==empId){
				  %>
				  <option value="<%=masEmp.getId()%>" selected="selected"><%=masEmp.getEmployeeName()%></option>
				  <%}else{ %>
	  <option value="<%=masEmp.getId()%>"><%=masEmp.getEmployeeName()%></option>
				  <%
		}}}
				   %>
</select>
<label>Condition at admission</label>
<textarea rows="4" cols="50" name="conatAdmi" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)"><%=conatAdmi %></textarea>
<label>Investigations Results </label>
<textarea rows="4" cols="50" name="inresult" class="textareaMediua" maxlength="1000"  onkeyup="return ismaxlength(this)"><%=inresult %></textarea>
<div class="clear"></div>
<label>Wound Certificate</label>
<textarea rows="4" cols="50"  name="wocer" class="textareaMediua" maxlength="1000"  onkeyup="return ismaxlength(this)"><%=wocer %></textarea>
<label>Treatment Details</label>
<textarea rows="4" cols="50"  name="treet" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)"><%=treet%></textarea>

<label>Condition at discharge</label>
<textarea rows="4" cols="50" name="conDis" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)"><%=conDis %></textarea>
<div class="clear"></div>
<label class="heightAuto">Advise For  further treatment</label>
<textarea rows="4" cols="50" name="adForter" class="textareaMediua" maxlength="250"  onkeyup="return ismaxlength(this)"><%=adForter%></textarea>
<label>Remarks</label>
<textarea rows="4" cols="50" name="remarks1" class="textareaMediua" maxlength="120"  onkeyup="return ismaxlength(this)"><%=remarks1 %></textarea>
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

	 <% if(meDetails.size()==0) {%>
	 <input type="button" name="add" id="addbutton" value="Submit" 	class="button"	onClick="submitForm('treatment','mlc?method=submmitTreetmentDischarge&flag=submit');"	accesskey="a" tabindex=1 />
	 <% }else{ %>
	 <input type="button" name="add" id="addbutton" value="Authorization" 	class="button"	onClick="submitForm('treatment','mlc?method=submmitTreetmentDischarge&flag=authorization');"	accesskey="a" tabindex=1 />
	 <%} %>
	
	</div>
	
	</form>
