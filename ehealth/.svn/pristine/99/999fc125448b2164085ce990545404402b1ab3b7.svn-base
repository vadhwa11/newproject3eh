<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <br />

 <% 
 Map<String,Object> map = new HashMap<String,Object>();
 Map<String,Object> utilMap = new HashMap<String,Object>();
 utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 String currentDate = (String)utilMap.get("currentDate");
 String currentTime = (String)utilMap.get("currentTime");

	
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	if(request.getAttribute("map")!=null){
		map=(Map<String ,Object>)request.getAttribute("map");
	}
	String orderNo = "";
	if(map.get("orderNo") != null){
		orderNo = (String)map.get("orderNo");
	}
	if(map.get("mlcList")!=null){
		mlcList=(List<OpdPatientDetails>)map.get("mlcList");
    }
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	if(map.get("patientHistories")!=null){
		patientHistories=(List<OpdPatientHistory>)map.get("patientHistories");
    }
	
	List<PatientAddress> patientAddress = new ArrayList<PatientAddress>();
	if(map.get("patientAddress")!=null){
		patientAddress=(List<PatientAddress>)map.get("patientAddress");
    }
	
	List<MedicoLegalDetails> meDetails = new ArrayList<MedicoLegalDetails>();
	if(map.get("details")!=null){
		meDetails=(List<MedicoLegalDetails>)map.get("details");
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
	//============
		String phy="";	
  String hinNo="";
 String name="";
 String age="";
 String gender="";
 String address="";
 int detailId=0;
 int hinId=0;
 String rffDoc="";
 String couInj="";
 String  his="";
 int mediCoId=0;
 String boughtBy="";
 String boughtAddress="";
 String injDetail="";
 int inpationId=0;
 String admitted="";
 String serNo="";
 int hOp=0;
 int pIp=0;
 String injuriesApp=""; 
  if(mlcList.size()>0){
 for(PatientWiseMlc mlc:patientWiseMlcs){
	
	 
	  if(mlc.getHin()!=null){
		  hOp=mlc.getHin().getId();
	hinNo=mlc.getHin().getHinNo();
	  }else if(mlc.getInpatient()!=null){
		  hinNo=mlc.getInpatient().getHinNo();
	   }
	  
	  if(mlc.getHin()!=null){
		  name=mlc.getHin().getFullName();
	}else if(mlc.getInpatient()!=null){
		pIp= mlc.getInpatient().getId();
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
  
  for(OpdPatientHistory history:patientHistories){
	  couInj= history.getPresentComplaintHistory(); 
  }
  

  
  for(MedicoLegalDetails legalDetails:meDetails){
	
	  mediCoId=legalDetails.getId();
	  srNo= legalDetails.getSerialNo()!=null ? legalDetails.getSerialNo():"";
	  examinDate=legalDetails.getExaminationDate()!=null ? HMSUtil.convertDateToStringTypeDate(legalDetails.getExaminationDate())  :"";
	  idMark1=legalDetails.getIdMark1()!=null ?legalDetails.getIdMark1() :"";
	  idMark2=legalDetails.getIdMark2()!=null ?legalDetails.getIdMark2() :"";
	  policeSt=legalDetails.getPoliceStation()!=null ?legalDetails.getPoliceStation():"";
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
	  his=legalDetails.getPhysicalExamination()!=null?legalDetails.getPhysicalExamination():"";
	  admitted=legalDetails.getPatientStatus()!=null ?legalDetails.getPatientStatus():"";
	  injuriesApp=legalDetails.getInjuryType()!=null ?legalDetails.getInjuryType():"";
	  couInj=legalDetails.getHistoryInjuryCause()!=null?legalDetails.getHistoryInjuryCause():"";
	  serNo=legalDetails.getSerialNo()!=null?legalDetails.getSerialNo():"";
	  
  }
  
  
  
 
	   String message = (String)map.get("message");
	   %>
	<% if(message!=null) {%>
	   <h4><span><%=message %></span></h4>
         <%}}%>
 <div class="titleBg">
<h2>ACCIDENT REGISTER-CUM-WOUND CERTIFICATE</h2>
</div>
 <form name="register" method="post" action="">

<div class="Block">

<label><span>*</span> UHID</label>
<input type="text" name="uhinId" id="uhinId" validate="UHID,string,yes" MAXLENGTH="50" value="<%=hinNo%>"> 
<input type="hidden" name="mediCoId" id="mediCoId"  value="<%= mediCoId%>"> 
</div>
<div class="Block">

<div class="clear"></div>
 
 <label>Serial No.<span>*<span></label>
 <%if(mediCoId!=0){%>
 <input type="text" name="serialNo" id="serialNo" MAXLENGTH="16" validate="Serial No,string,yes" value="<%=serNo%>" readonly="readonly"/>
 <%}else{ %>
 <input type="text" name="serialNo" id="serialNo" MAXLENGTH="16" validate="Serial No,string,yes" value="<%=orderNo%>" />
 <%}%>
<label>Examination Date</label> 
<input type="text" class="date"	name="exdate" id="exdate" value="<%=currentDate %>" MAXLENGTH="30" validate="Examination Date,date,no" onblur="checkMonth(this,this.value);"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.register.exdate,event)" />  

 <label>Examination Time</label>
 <input type="text" name="extime" id="extime" MAXLENGTH="8" value="<%= currentTime%>"/>

  <div class="clear"></div>
 
 <label>Name</label>
 <input type="text" readonly="readonly" id="pname" name="pname" MAXLENGTH="50" value="<%= name%>"/>
 <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
  <input type="hidden"  name="hinId"   value="<%= hinId%>"/>
   <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
  
<label>Age</label>
<input type="text" id="age"  name="age" readonly="readonly" MAXLENGTH="3" value="<%= age%>"/>

<label>Gender</label>
<input type="text"   name="gender" id="gender" readonly="readonly" MAXLENGTH="8" value="<%= gender%>"/>
<div class="clear"></div>

<label>Address</label>
<textarea   id="address" name="address" readonly="readonly" class="textareaMediua"><%=address%></textarea>

<label>Id Marks (1)</label>
<input type="text"  class="comorBiditylarge"  name="idmark1" id="idmark1"  maxlength="90"  onkeyup="return ismaxlength(this)"  value="<%=idMark1%>" /> 

<label>Id Marks (2)</label>
<input type="text"   class="comorBiditylarge"  name="idmark2" id="idmark2"  maxlength="90"  onkeyup="return ismaxlength(this)" value="<%=idMark2%>"/> 

<div class="clear"></div>

 <label>Brought By Name</label>
 <input type="text" name="bbname"  id="bbname" maxlength="96" value="<%=boughtBy%>"/>
  
 <label>Brought By Address</label>
 <textarea name="bbaddress" id="bbaddress" maxlength="240" class="textareaMediua"><%=boughtAddress%></textarea>
 
 <label>Police Station</label>
 <input type="text" name="police"  id="police" maxlength="128" value="<%=policeSt%>"/>
 
 <div class="clear"></div>
  <div class="clear"></div>
 
  <label>Witness (1)</label>
 <input type="text" name="witness1"  id="witness1" maxlength="96" value="<%=witt1%>"/>
 
 <label>SO/DO</label>
 <input type="text" name="sodo1"  id="sodo1" maxlength="96" value="<%=sonOf1%>"/>
 
 <label>Address</label>
<textarea    name="witaddress1" id="witaddress1" maxlength="512" class="textareaMediua"><%=witt1Add%></textarea>
 
 <div class="clear"></div>
 
  <label>Witness (2)</label>
 <input type="text" name="witness2"  id="witness2" maxlength="96" value="<%=witt2%>"/>
 
 <label>SO/DO</label>
 <input type="text" name="sodo2"  id="sodo2" maxlength="96" value="<%=sonOf2%>"/>
 
 <label>Address</label>
<textarea   name="witaddress2" id="witaddress2"   maxlength="512" class="textareaMediua" ><%=witt2Add%></textarea>
 
<div class="clear"></div>

 <label>Requisition From</label>
 <input type="text" name="requifrom"  id="requifrom" value="<%=reqForm%>"  maxlength="90" />
  
 <label>Cause of Injury</label>
<textarea  name="injury" id="injury"   maxlength="90"  onkeyup="return ismaxlength(this)" class="textareaMediua"><%=couInj%></textarea>
 
 <label>Statement By Injured</label>
<textarea name="stmt"   id="stmt"  maxlength="90"  onkeyup="return ismaxlength(this)"  class="textareaMediua"><%=histInj%></textarea>

<div class="clear"></div>
<div class="clear"></div>

<label>Details of Injuries</label>
<textarea  id="detail" name="detail"   maxlength="1000"  onkeyup="return ismaxlength(this)" class="textareaMediua"><%=injDetail%></textarea>
 
 <label>Physical Examination</label>
<textarea name="physical"  id="physical"  maxlength="1000"  onkeyup="return ismaxlength(this)" class="textareaMediua"><%=his%></textarea>

<label>Additional Sheets</label>
 <input type="text" name="sheets" id="sheets" maxlength="2" validate="sheets,int,no" value="<%=addiTion%>" readonly="readonly"/>
 
 <div class="clear"></div>
 <div class="clear"></div>
   <label>Admitted Or Not</label> 
 	  <select tabindex="30" name="admitted" id="admitted" >

	 <%if(hOp!=0){%>

	  <% 
		  if(admitted.equalsIgnoreCase("")){ %>
	 	  <option value="">Select</option>	
		 <option value="Out Patient" selected="selected">Out Patient</option>
		  <%}else if(admitted.equalsIgnoreCase("Out Patient")){ %>
 	<option value="">Select</option>	
	<option value="Out Patient" selected="selected">Out Patient</option>

	<%}}%>
	
	  
 <%if(pIp!=0){%>

	 	<%if(admitted.equalsIgnoreCase("")){ %>
		<option value="">Select</option>	
		<option value="Admitted">Admitted</option>
		<option value="Observation">Observation</option>
		<option value="Expired in Casualty">Expired in Casualty</option>
		<option value="Referred">Referred</option>
	<%} else if(admitted.equalsIgnoreCase("Admitted")){ %>
 
	<option value="">Select</option>	
	<option value="Admitted" selected="selected">Admitted</option>
	<option value="Observation">Observation</option>
	<option value="Expired in Casualty">Expired in Casualty</option>
	<option value="Referred">Referred</option>
	<%}else if(admitted.equalsIgnoreCase("Observation")){ %>
	 
	<option value="">Select</option>	
	<option value="Admitted">Admitted</option>
	<option value="Observation" selected="selected">Observation</option>
	<option value="Expired in Casualty">Expired in Casualty</option>
	<option value="Referred">Referred</option>
	<%}else if(admitted.equalsIgnoreCase("Expired in Casualty")) {%>
	 
	<option value="">Select</option>	
	<option value="Admitted">Admitted</option>
	<option value="Observation">Observation</option>
	<option value="Expired in Casualty" selected="selected">Expired in Casualty</option>
	<option value="Referred">Referred</option>
	<%}else if(admitted.equalsIgnoreCase("Referred")) {%>
	 
	<option value="">Select</option>	
	<option value="Admitted">Admitted</option>
	<option value="Observation">Observation</option>
	<option value="Expired in Casualty">Expired in Casualty</option>
	<option value="Referred" selected="selected">Referred</option>
	 
	<%}}%>	
	   </select>
	 

	
 <label>Opinion</label>
 <select tabindex="30" name="opinion" id="opinion" >
 <%if(opNion.equalsIgnoreCase("Could be")){ %>
 
	<option value="">Select</option>	
	<option value="Could be" selected="selected">Could be</option>
	<option value="Could not be">Could not be</option>
	<%}else if(opNion.equalsIgnoreCase("Could not be")){ %>
	<option value="">Select</option>	
	<option value="Could be">Could be</option>
	<option value="Could not be"  selected="selected">Could not be</option>
	<%}else{ %>
	<option value="">Select</option>	
	<option value="Could be">Could be</option>
	<option value="Could not be">Could not be</option>
	<%} %>
</select>

 <label>Injuries appeared</label>
 <select name="injuriesAppeared">
 <%if(injuriesApp.equalsIgnoreCase("")){ %>
 <option value="">Select</option>
 	<option value="Fresh">Fresh</option>
	<option value="Old">Old</option>
	<%}else if(injuriesApp.equalsIgnoreCase("Fresh")){ %>
	 <option value="">Select</option>
 	
	<option value="Fresh" selected="selected">Fresh</option>
	<option value="Old">Old</option>
	<%}else{ %>
	 <option value="">Select</option>
 	
	<option value="Fresh">Fresh</option>
	<option value="Old" selected="selected">Old</option>
	<%} %>
 </select>
 
 <div class="clear"></div>
 <input type="hidden" value="" id="hinId" name="hinId">
 <% if(meDetails.size()==0) {%>
 <input type="button" name="add" id="addbutton" value="Submit" class="button"	onClick="submitForm('register','mlc?method=addAccidentalRegistration&flag=submit');" accesskey="a" tabindex=1 /> 
 <% }else{ %>
 <input type="button" name="authorization" id="authorization" value="Authorization" class="button"	onClick="submitForm('register','mlc?method=addAccidentalRegistration&flag=authorization');" accesskey="a" tabindex=1 /> 
<%} %>
<!--  <label>YOU WANT REPORT</label>
<input type="checkbox" id="check"  onclick="ShowHideDiv(this.value,'pname')">
 <div class="clear"></div>
 <div id="report" style="display: none">
  <input type="button" name="add" id="addbutton" value="Accdient" class="button"	onClick="submitForm('register','mlc?method=generateReportofAccident');"	accesskey="r" tabindex=1 /> 
   <input type="button" name="add" id="addbutton" value="Wound Certficate" class="button"	onClick="submitForm('register','mlc?method=generateReportofAccidentWound');"	accesskey="r" tabindex=1 /> 
 
 </div> -->
   </div>
 
 <script type="text/javascript">
    function ShowHideDiv(check,pname) {
    	var check=document.getElementById("check");
    	var pname=document.getElementById("pname");
   	
       if(pname == null||pname ==""){
    	
    	 document.getElementById("check").checked = false;
           }
     
       else{
    	   var dvPassport = document.getElementById("report");
           dvPassport.style.display = check.checked ? "block" : "none";
          document.getElementById("check").checked = true; 
       }
       
       
    }
    
    function checkWoundCertificateGeneration(uhid){
    	
    	ajaxFunctionForWoundCertificateGeneration('register','mlc?method=checkWoundCertificate&uhid='+uhid);	
    	
    }
    function ajaxFunctionForWoundCertificateGeneration(formName,action,rowVal) {

  	  var xmlHttp;
  	  try {
  	    // Firefox, Opera 8.0+, Safari
  	    xmlHttp=new XMLHttpRequest();
  	  }catch (e){
  	    // Internet Explorer
  	    try{
  	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
  	    }catch (e){
  	    	alert(e)
  	      try{
  	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
  	      }catch (e){
  	        alert("Your browser does not support AJAX!");
  	        return false;
  	      }
  	     }
  	   }
  	    xmlHttp.onreadystatechange=function()
  	    {
  	      if(xmlHttp.readyState==4){

  	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

  	      //	var brandId="brandId"+rowVal;
  	      	//var batchId="batchId"+rowVal;
  	      //	var batchName ="batchName"+rowVal;
  	      //	alert(batchName);
  		//	obj1 =document.getElementById(brandId);
  			//obj = document.getElementById(batchId);
  			//obj1 = document.getElementById(batchName);
  			obj.length = 1;
  			//obj1.length =1;

  	      	for (loop = 0; loop < items.childNodes.length; loop++) {
  		   	    var item = items.childNodes[loop];
  		         var msg  = item.getElementsByTagName("msg")[0];
  		        
  	        	 if(msg !=undefined && msg.childNodes[0] !=undefined){
  					  //alert(msg.childNodes[0].nodeValue);
  				
  	        	if(confirm(msg)){}
  	  			return true;
  	        	 }
  	  		else{
  	  			return false;
  	  		}
  	        	
  	      	}
  	      }
  	    }
  	    var url=action+"&"+getNameAndData(formName);
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

  	    xmlHttp.open("GET",url,true);
  	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
  	    xmlHttp.send(null);


  	  }
    
</script>
  
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  
 </form>
 