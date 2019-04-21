<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientAdmissionSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="jkt.hms.masters.business.IpdGatepassDetails"%>
<%@page import="jkt.hms.masters.business.MasPassPrintReason"%>
<%@page import="jkt.hms.masters.business.MasPassType"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<%--<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script> --%>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

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
</script>

<%
		Map<String, Object> map = new HashMap<String, Object>();
List<MasPassType> masPassTypeList=new ArrayList<MasPassType>();
List<MasPassPrintReason> masPassPrintReasonList=new ArrayList<MasPassPrintReason>();
      Inpatient inpatient=null;
      List<IpdGatepassDetails> ipdGateplList=new ArrayList<IpdGatepassDetails>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		if(map.get("inpatient") != null){
			inpatient = (Inpatient)map.get("inpatient");
		}
		
		if(map.get("masPassTypeList") != null){
			masPassTypeList = (List<MasPassType>)map.get("masPassTypeList");
		}
		
		if(map.get("masPassPrintReasonList") != null){
			masPassPrintReasonList = (List<MasPassPrintReason>)map.get("masPassPrintReasonList");
		}
		if(map.get("ipdGateplList") != null){
			ipdGateplList = (List<IpdGatepassDetails>)map.get("ipdGateplList");
		}
		
	
	%>
	
	<%!

public String getPatientName(Patient patient){
	String patientName = "-";
	try
	{
		patientName=patient.getPFirstName();
		if(patient.getPMiddleName()!=null){
			patientName += " "+patient.getPMiddleName();
		}
		if(patient.getPLastName()!=null){
			patientName += " "+patient.getPLastName();
	}
	}
	catch (Exception e)
	{
	patientName = "-";
	}
	return patientName;
}

public String getHinNo(Patient patient){
	
	String hinNo = "-";
	try
	{
		hinNo=patient.getHinNo();
	}
	catch (Exception e)
	{
		hinNo = "-";
	}
	return hinNo;
}

public String getAddress(Inpatient inpatient){
	String patientAddress="-";
	try
	{
			patientAddress = inpatient.getHin().getPatientAddress();	
	}
	catch(Exception exception)
	{
		patientAddress="-";
	}
	return patientAddress;
}

public String getGender(Patient patient){
	String gender="-";
	try
	{
		gender = patient.getSex().getAdministrativeSexName();
	}
	catch(Exception exception)
	{
		gender="-";
	}
	return gender;
	
}

public String getMaritalStatus(Patient patient){
	String maritalStatus="-";
	try
	{
		maritalStatus=patient.getMaritalStatus().getMaritalStatusName();
	}
	catch(Exception exception)
	{
		maritalStatus="-";
	}
	return maritalStatus;
}

public String getPatientAge(Patient patient){
	String currentAge = "";
	try
	{try{ 
		/*if(patient.getAge()!= null && !patient.getAge().equals("")){
		String age = patient.getAge();
		currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
	}else if(patient.getDateOfBirth()!=null){
		currentAge = HMSUtil.calculateAge(patient.getDateOfBirth());
	}*/
	if(patient.getDateOfBirth()!=null){
	Date dob=patient.getDateOfBirth();
	String ymd=HMSUtil.calculateYearMonthDay(dob);
	System.out.println("yearsmontday "+ymd);
	String d[]=ymd.split("&");
	String year1=d[0];
	String months1=d[1];
	currentAge=year1+" Years "+months1+" Months	";
	
	}
}   catch(Exception ex){
	ex.printStackTrace();
        }
	}
	catch(Exception exception)
	{
		currentAge="-";
	}
	
	return currentAge;
}

public String getPatientCategory(Patient patient){
	String pCategory="-";

	try
	{
		pCategory =patient.getPatientType().getPatientTypeName();
	}
	catch(Exception exception)
	{
		 pCategory="-";
	}
	return  pCategory;
}

public String getPatientDepartment(Inpatient inpatient){
	String departmentName="-";
	try
	{
		departmentName=inpatient.getDepartment().getDepartmentName();
	}
	catch(Exception exception)
	{
		 departmentName="-";
	}
	return  departmentName;
}

public String getPatientUnit(Inpatient inpatient){
	String unit="-";
	try
	{
		
	}
	catch(Exception exception)
	{
		unit="-";
	}
	return unit;
}


public String getPatientReferringDoctor(Inpatient inpatient){
	String refferingDoctor="-";
	try
	{
		refferingDoctor=inpatient.getOpdPatientDetails().getReferredDoctor().getFirstName();
		if(inpatient.getOpdPatientDetails().getReferredDoctor().getMiddleName()!=null)
		{
			refferingDoctor +=" "+inpatient.getOpdPatientDetails().getReferredDoctor().getMiddleName();
		}
		
		if(inpatient.getOpdPatientDetails().getReferredDoctor().getLastName()!=null)
		{
			refferingDoctor+=" "+inpatient.getOpdPatientDetails().getReferredDoctor().getLastName();
		}
		
	}
	catch(Exception exception)
	{
		refferingDoctor="-";
	}
	
	return refferingDoctor;
	
}


public String getPatientAdmittingDoctor(Inpatient inpatient){
	String admittingDoctor="-";
	try
	{
		admittingDoctor=inpatient.getDoctor().getEmployeeName();
	/* 	if(inpatient.getOpdPatientDetails().getEmployee().getMiddleName()!=null)
		{
			admittingDoctor +=" "+inpatient.getOpdPatientDetails().getEmployee().getMiddleName();
		}
		
		if(inpatient.getOpdPatientDetails().getEmployee().getLastName()!=null)
		{
			admittingDoctor+=" "+inpatient.getOpdPatientDetails().getEmployee().getLastName();
		} */
	}
	catch(Exception exception)
	{
		admittingDoctor="-";
	}
	
	return admittingDoctor;
}

public String getPatientConsultingDoctor(Inpatient inpatient){
	String consultingDoctor="-";
	try
	{
		consultingDoctor=inpatient.getDoctor().getFirstName();
		if(inpatient.getDoctor().getMiddleName()!=null)
		{
			consultingDoctor +=" "+inpatient.getDoctor().getMiddleName();
		}
		
		if(inpatient.getDoctor().getLastName()!=null)
		{
			consultingDoctor+=" "+inpatient.getDoctor().getLastName();
		}
	}
	catch(Exception exception)
	{
		consultingDoctor="-";
	}
	
	return consultingDoctor;
}

public String getPatientAdmitionNo(Inpatient inpatient){
	String ipNo="-";
	try
	{
		ipNo=inpatient.getAdNo();
	}
	catch(Exception exception)
	{
		ipNo="-";
	}
	return ipNo;
}
%>
	
	
	
	
	
	<% Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap= (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");%>
	
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<% for(IpdGatepassDetails gate:ipdGateplList) {

	%>
<lable> Your Pass From <%=gate.getValidFrom()%> <lable> <lable> TO <%=gate.getValidTo()%> <lable> 

<%}%>
<div class="titleBg">
<h2>Generate pass</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">

<div class="paddingTop25"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>

<div class="Block">


<label>UHID</label> 
<label class="value"><%=getHinNo(inpatient.getHin())%></label>
<label>Patient Name</label> 
<label class="value"><%=getPatientName(inpatient.getHin())%></label>

<label>Gender</label> 
<label class="value"><%=getGender(inpatient.getHin()) %></label>


<%-- <label>Marital Status</label> 
<label class="value"><%getMaritalStatus(inpatient.getHin()); %></label>
 --%>
 <div class="clear"></div>
<label>Age</label> 
<label class="value"><%=getPatientAge(inpatient.getHin()) %></label>
<label>Patient Category</label> 
<label class="value"><%=getPatientCategory(inpatient.getHin()) %></label>
<label>Department</label> 
<label class="value"><%=getPatientDepartment(inpatient) %></label>

<div class="clear"></div>
<label>Unit</label> 
<label class="value"><%=getPatientUnit(inpatient) %></label>
<label>Referring Doctor</label> 
<label class="value"><%=getPatientReferringDoctor(inpatient) %></label>
<label>Admitting Doctor</label> 
<label class="value"><%=getPatientAdmittingDoctor(inpatient) %></label>
<div class="clear"></div>

<label>IP No.</label> 
<label class="value"><%=getPatientAdmitionNo(inpatient) %></label>

<label>Address</label> 
<label class="valueFixedWidth"><%=getAddress(inpatient) %></label>

<div class="clear"></div>
</div>



<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>

<form method="post" name="gatePass">

<input type="hidden" name="<%=INPATIENT_ID%>"  id="<%=INPATIENT_ID%>" value="<%=inpatient.getId()%>" validate="inpatientId,int,no"/>
<input type="hidden" name="<%=HIN_ID%>"  id="<%=HIN_ID%>" value="<%=inpatient.getHin().getId()%>" validate="hinId,int,no"/>




<label>Date<span>*</span></label>
<input type="text" name="printDate" id="printDate" class="date" readonly="readonly" validate="Pick a date,date,yes" value="<%=date+"/"+month+"/"+year%>" />
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.gatePass.printDate,event)"  src="/hms/jsp/images/cal.gif">
<label>Time<span>*</span></label>
<input type="text"  name="printTime" id="printTime"  validate="Pick a Time,time,no" value="<%=currentTime%>" onblur="checkTime('gatePass','printTime');"   /> 
<label>Pass Type<span>*</span></label>
<select name="passtype" id="passtype" validate="passtype,metachar,yes">
<%for(MasPassType masPassType:masPassTypeList) 
{
%>
<option value="<%=masPassType.getId() %>"><%=masPassType.getPassTypeName() %></option>

<%} %>
</select> 
<label>Print Reason<span>*</span></label>
<select name="printReason" id="printReason" validate="printReason,metachar,yes" onchange="showRemark();">
<%for(MasPassPrintReason masPassPrintReason:masPassPrintReasonList) 
{
%>
<option value="<%=masPassPrintReason.getId() %>"><%=masPassPrintReason.getPrintReasonName() %></option>
<%} %>
</select> 
<label>Valid From<span>*</span></label>
<input type="text" name="validfrom" id="validfrom" class="date" readonly="readonly" onblur="calculateNextSuffixFromDate(this.value)" validate="Pick a date,date,yes" value="<%=date+"/"+month+"/"+year%>" />
<%-- <img  width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.gatePass.validfrom,event)"  src="/hms/jsp/images/cal.gif">
  --%>
 <label>Valid Till<span>*</span></label>
<input type="text" name="validtill" id="validtill" class="date" readonly="readonly" validate="Pick a date,date,yes" value="<%=""+(Integer.parseInt(date)+1)+"/"+month+"/"+year%>" />
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=date+"/"+month+"/"+year%>',document.gatePass.validtill,event)"  src="/hms/jsp/images/cal.gif">


<div class="clear"></div>

<div id="remark"  style="display: none;">
<label>Reason</label>
<textarea rows="4" cols="50" id="resion" name="resion" class="textareaMediua" maxlength="120">
</textarea>

<label>Paid</label>
<input type="text" name="amt" id="amt" class="small">
</div>
<div class="clear"></div>

<div class="paddingTop25"></div>
<div class="clear"></div>
<input type="button" class="button" value="Save" onClick="if(dateValidationForPassPrinting()){submitForm('gatePass','ipd?method=submitGeneratepassJsp');};" />

<input type="button" class="button" value="Reset" id="reset" onclick="submitFormForButton('gatePass','ipd?method=showGeneratepassJsp')" />
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('gatePass','ipd?method=showPatientListNurseJsp');"/>



 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<div class="clear"></div>

<div class="paddingTop25"></div>
</div>
<div class="clear"></div>

<script type="text/javascript">
function dateValidationForPassPrinting()
{
	var  diffDaysForDate=isFuturedate('printDate');
	if(isNaN(diffDaysForDate))
	{
	alert('Please select valid date');
	return false;
	}
	
if(document.getElementById("printReason").value== 2){
	
   if(diffDaysForDate>0)
	{
	alert('Date can not be future date');
	return false;
	}
	
	}
var  diffDaysForDate=isFuturedate('validfrom');
if(isNaN(diffDaysForDate))
{
alert('Please select valid date for Valid Till date');
return false;
}
if(diffDaysForDate>0)
{
alert('Valid From Date can not be future date');
return false;
}

	var dateFromArray = document.getElementById('validfrom').value.split("/");
	var dateTillArray = document.getElementById('validtill').value.split("/");
	var fromDate = new Date(dateFromArray[1]+'/'+dateFromArray[0]+'/'+dateFromArray[2]);
	var toDate = new Date(dateTillArray[1]+'/'+dateTillArray[0]+'/'+dateTillArray[2]);
	var timeDiff = toDate.getTime() - fromDate.getTime();
	var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
	if(isNaN(diffDays))
		{
		alert('Please select valid date');
		return false;
		}
	if(diffDays<0)
		{
		alert('Valid From date is greater than valid till date');
		return false;
		}
	if(diffDays>3)
		{
		alert('Pass can\'t be valid more than 3 days. Please select another date');
		return false;
		}
	 
     if(document.getElementById("printReason").value== 2 ){
    	
    	var res=document.getElementById("resion").value;
 
    	  if(res.length==0 && res==''){
    		  alert('Please Fill Reason');
    	  return ; 
    	  }
    	 
     } 
   
 	return true;
}	

function isFuturedate(id)
{
	var date=document.getElementById(id).value.split("/");
	var timeDiffForDate=(new Date(date[1]+'/'+date[0]+'/'+date[2])).getTime()-(new Date('<%=month%>'+'/'+'<%=date%>'+'/'+'<%=year%>')).getTime();
	var diffDaysForDate = Math.ceil(timeDiffForDate / (1000 * 3600 * 24)); 
	return diffDaysForDate;
	
}

function showRemark(){

	
	if(document.getElementById("printReason").value== 2 ||document.getElementById("printReason").value== 3){
		
		document.getElementById("remark").style.display ='block';
	
	}
	else {
		document.getElementById("remark").style.display ='none';
		
	}

}


function  calculateNextSuffixFromDate(sdate){
	//alert(sdate);
	//if(fromDate !=''){
			if(sdate!=''){
				//alert(parseInt(sdate.substring(0,2))+1);
				var a=parseInt(sdate.substring(0,2))+1;
				var b=sdate.substring(3,5);
				var c=sdate.substring(6,10);
				sdate=""+a+"/"+b+"/"+c;
				
				
<%-- 				
			sdate=new Date(sdate.substring(6),(sdate.substring(3,5) - 1) ,sdate.substring(0,2));
			
				dayOfToDate=sdate.getDate();
				monthOfToDate=sdate.getMonth();
				yearOfToDate=sdate.getFullYear();
				dayOfToDate++;
				sdate.setDate(dayOfToDate);
				sdate.setMonth(monthOfToDate);
				sdate.setYear(yearOfToDate);
			
				dayOfToDate=sdate.getDate();
				monthOfToDate=sdate.getMonth();
				yearOfToDate=sdate.getFullYear();
			
				if(dayOfToDate==1)
				monthOfToDate++;
				if(dayOfToDate==1 && monthOfToDate==12)
				yearOfToDate++;
			
				sdate.setDate(dayOfToDate);
				sdate.setMonth(monthOfToDate);
				sdate.setYear(yearOfToDate);
				//alert(sdate.getDay());
				if(sdate.getDay()==0 ||sdate.getDay()==6 )
					flag=true;
				else 
					flag=false;
				
					
			
			dayOfToDate=sdate.getDate();
			monthOfToDate=sdate.getMonth();
			yearOfToDate=sdate.getFullYear();
			monthOfToDate++;
			if(dayOfToDate < 10)
				dayOfToDate = "0"+dayOfToDate;
			if(monthOfToDate < 10)
				monthOfToDate = "0"+monthOfToDate;
			//alert(dayOfToDate+"/"+monthOfToDate+"/"+yearOfToDate)
			//alert(fromDate)
			document.<%=APPLY_LEAVE%>.<%=JOINING_DATE%>.value =dayOfToDate+"/"+monthOfToDate+"/"+yearOfToDate;
			var suffixNextFromDate=dayOfToDate+"/"+monthOfToDate+"/"+yearOfToDate;
 --%>			
	document.getElementById('validtill').value=sdate;

	    		
			
		}
		
	//}
}


</script>
 