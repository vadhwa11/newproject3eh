<%@page import="jkt.hms.masters.business.LrFetalDetails"%>
<%@page import="jkt.hms.masters.business.LrProcedureDone"%>
<%@page import="jkt.hms.masters.business.LrUrineAnalysis"%>
<%@page import="jkt.hms.masters.business.LrTemperature"%>
<%@page import="jkt.hms.masters.business.LrPulseBp"%>
<%@page import="jkt.hms.masters.business.LrDilatationDescent"%>
<%@page import="jkt.hms.masters.business.LrContraction"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URI"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.LaborRoom"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<script type="text/javascript" src="/hms/jsp/js/laborRoom.js"></script>
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

public String getAddress(Patient inpatient){
	String patientAddress="-";
	try
	{	
			patientAddress = inpatient.getPatientAddress();
			if(patientAddress.equals(null)){
				patientAddress="-";
			}
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

public String getPatientAge(Patient inpatient){
	String currentAge = "-";
	try
	{
			try{ 
				
				if(inpatient.getDateOfBirth()!=null){
				Date dob=inpatient.getDateOfBirth();
				String ymd=HMSUtil.calculateYearMonthDay(dob);
				String d[]=ymd.split("&");
				String year1=d[0];
				String months1=d[1];
				currentAge=year1+" Years "+months1+" Months	";
				}
			}catch(Exception ex){
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
<%
Map<String, Object> utilMap = new HashMap<String, Object>();
Map<String, Object> map = new HashMap<String, Object>();
List<Inpatient> inpatientList = new ArrayList<Inpatient>();
List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
List<LrFetalDetails> lrfetalDetailsList = null;
List<LrProcedureDone> lrProcedureDoneList = null;
List<LrContraction> lrContractionList = null;
List<LrDilatationDescent> lrDilatationDescentList = null;
List<LrPulseBp> lrPulseBpList = null;
List<LrTemperature> lrTemperatureList = null;
List<LrUrineAnalysis> lrUrineAnalysisList = null;

if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

if(map.get("inpatientList")!=null){
	inpatientList = (List<Inpatient>) map.get("inpatientList");
}

if(map.get("laborRoomList")!=null){
	laborRoomList = (List<LaborRoom>) map.get("laborRoomList");
}
if(map.get("lrProcedureDoneList")!=null){
	lrProcedureDoneList = (List<LrProcedureDone>) map.get("lrProcedureDoneList");
}

if(map.get("lrfetalDetailsList")!=null){
	lrfetalDetailsList = (List<LrFetalDetails>) map.get("lrfetalDetailsList");
}
if(map.get("lrContractionList")!=null){
	lrContractionList = (List<LrContraction>) map.get("lrContractionList");
}
if(map.get("lrDilatationDescentList")!=null){
	lrDilatationDescentList = (List<LrDilatationDescent>) map.get("lrDilatationDescentList");
}
if(map.get("lrPulseBpList")!=null){
	lrPulseBpList = (List<LrPulseBp>) map.get("lrPulseBpList");
}
if(map.get("lrTemperatureList")!=null){
	lrTemperatureList = (List<LrTemperature>) map.get("lrTemperatureList");
}
if(map.get("lrUrineAnalysisList")!=null){
	lrUrineAnalysisList = (List<LrUrineAnalysis>) map.get("lrUrineAnalysisList");
}
System.out.println("jsp inpatientList "+inpatientList.size()+" laborRoomList "+laborRoomList.size());

utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String dateC = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

Inpatient inpatient = new Inpatient();
Patient patient = new Patient();
Visit visit=new Visit();
String patientName ="";
String servPersonName ="";
String consultantName = "";
String currentAge = "";
String gender="-";
String pCategory="";
String bloodGroup="";
String materialStatus="";
String admittedBy="-";

if(inpatientList.size() > 0){
	inpatient = inpatientList.get(0);
	System.out.println("inpatient jsp ");
	patient = inpatient.getHin();
	patientName=patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"");
	servPersonName =(patient.getSFirstName()!=null?patient.getSFirstName():"")+" "+(patient.getSMiddleName()!=null?patient.getSMiddleName():"")+" "+(patient.getSLastName()!=null?patient.getSLastName():"");
	consultantName=inpatient.getDoctor().getRank()!=null?inpatient.getDoctor().getRank().getRankName():""+" "+ inpatient.getDoctor().getFirstName()+" "+(inpatient.getDoctor().getMiddleName()!=null?inpatient.getDoctor().getMiddleName():"")+" "+(inpatient.getDoctor().getLastName()!=null?inpatient.getDoctor().getLastName():"");	
	
	if(inpatient.getDoctor()!=null)
	{
		admittedBy=inpatient.getDoctor().getFirstName();
		if(inpatient.getDoctor().getMiddleName()!=null)
		{
			admittedBy +=" "+inpatient.getDoctor().getMiddleName();
		}
		if(inpatient.getDoctor().getLastName()!=null)
		{
			admittedBy +=" "+inpatient.getDoctor().getLastName();
		}
	}
	String age = "";
	if(inpatient.getHin().getSex()!=null)
	{
		gender=inpatient.getHin().getSex().getAdministrativeSexName();
	}
	
	
	if(inpatient.getHin().getMaritalStatus()!=null)
	{
		materialStatus=inpatient.getHin().getMaritalStatus().getMaritalStatusName();
	}else
	{
		materialStatus="-";
	}
	
	if(inpatient.getHin().getBloodGroup()!=null){
		bloodGroup = inpatient.getHin().getBloodGroup().getBloodGroupName();
	}
	else
	{
		bloodGroup="-";
	}
	
	if(inpatient.getHin().getPatientType()!=null){
		pCategory = inpatient.getHin().getPatientType().getPatientTypeName();
	}
	else
	{
		pCategory="-";
	}
	
	

    if(patient.getAge()!=null)
		age = patient.getAge();
	try{
		if(!age.equals(""))
		currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
	}catch(Exception ex){
		ex.printStackTrace();
	}
} 

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

%>
<form name="laborRoom2" method="post">
<input id="inputDate" name="inputDate" type="hidden"
			value="<%=dateC%>" />
			<input id="inputTime" name="inputTime" type="hidden"
			value="<%=time%>" />
	<div class="titleBg">
		<h2>Labor Room Stage 2</h2>
	</div>
	<div class="Block">
 <h4>Patient Details</h4>
 <div class="Clear"></div>
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
<label class="valueFixedWidth"><%=getAddress(inpatient.getHin()) %></label>
	
<div class="clear"></div>
</div>
<div>
  <input type="hidden" name="hinNo" value="<%=patient.getHinNo()%>" validate="hinNo,metachar,no"/>
<input type="hidden" name="adNo" value="<%=inpatient.getAdNo()%>" validate="adNo,metachar,no"/>
<input type="hidden" name="serviceNo" value="<%=patient.getServiceNo()!=null?patient.getServiceNo():""%>" validate="serviceNo,metachar,no"/>
<input type="hidden" name=<%=HIN_ID %> value="<%=patient.getId()%>" validate="hinId,int,no"/>
<input type="hidden" name=<%=INPATIENT_ID %> value="<%=inpatient.getId()%>" validate="inpatientId,int,no"/>
<input type="hidden" name="doctor_id" value="<%=inpatient.getDoctor().getId()%>" validate="fromDoctor,int,no"/>

</div>





<div class="clear"></div>	
<div class="Block" >
<h4>Labor Details</h4>
			<div style="float: right;margin-right: 50px;">
				<input type="button" class="button" value="Add" align="right"
					onClick="javascript:addRowLabRoom2Table();" /> <input type="button"
					name="Reset" value="Delete" class="button" align="right"
					onClick="javascript:removeRow('lbRoom2Table');" />
			</div>
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="">
				<div class="tableForTab"
					style="width: 1150px; height: 200px; overflow: scroll;">
					<div id="divTemplet1">

						<table border="0" align="center" cellpadding="0" cellspacing="0"
							id="lbRoom2Table">
							<tr>
							    <th scope="col"></th>
								<th scope="col">Date</th>
								<th scope="col">Time</th>
								<th scope="col">Maternal Pulse Rate</th>
								<th scope="col">Resp Rate</th>
								<th scope="col">BP</th>
								<th scope="col">Lung Bases</th>
								<th scope="col">Knee Jerk</th>
								<th scope="col">Fetal Heart</th>
								<th scope="col">NST</th>
								<th scope="col">Oxytocin infusion rates</th>
								<th scope="col">Contractions</th>
								<th scope="col">I/O</th>
							</tr>
							<%
							String kneejerk="",nst="";int count=0;					
							if(laborRoomList.size()>0){
								for(LaborRoom lab:laborRoomList){
									count=count+1;
									if(lab.getKneeJerk()!=null && !lab.getKneeJerk().equals("")){
								if(lab.getKneeJerk()==1){
									kneejerk="+";
								}
								if(lab.getKneeJerk()==2){
									kneejerk="-";
								}
									}
									
									if(lab.getNst()!=null && !lab.getNst().equals("")){
										if(lab.getNst()==1){
											nst="Base line heart rate";
								}
										if(lab.getNst()==2){
											nst="Beat to beat variability";
										}
										if(lab.getNst()==3){
											nst="Accelerations";
										}
										if(lab.getNst()==4){
											nst="Deceleration";
										}
									}
								%>


						<tr>
							<td scope="col"><%=count %></td>
							<td scope="col" style="width: 100px"><input type="text"
								value="<%=lab.getLaborRoomDate()%>" size="8"
								class="dateTextSmall" readonly="readonly"> <img
								src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
								validate="Pick a date"
								onclick="setdate('<%=dateC%>',,event);" /></td>
							<td scope="col"><input value="<%=lab.getLaborRoomTime()%>" type="text" readonly="readonly"
								size="6" /></td>
							<td scope="col"><input
								value="<%=lab.getMaternalPulseRate()%>" size="6" type="text" readonly="readonly"
								class="allownumericwithoutdecimal" /></td>
							<td scope="col"><input value="<%=lab.getRespRate()%>" readonly="readonly"
								type="text" size="6" /></td>
							<td scope="col"><input value="<%=lab.getLabRoomBp()%>" readonly="readonly"
								type="text" size="6" /></td>
							<td scope="col"><input value="<%=lab.getLungBases()%>" readonly="readonly"
								type="text" size="20" /></td>

							<td scope="col"><select >
									<%
										if(lab.getKneeJerk()!=0){
									%>
									<option value="<%=kneejerk%>" ><%=kneejerk%></option>
									<%
										}else{
									%>
									<option value="0">Select</option>
									<%
										}
									%>
							</select></td>

							<td scope="col"><input value="<%=lab.getFetalHeart() %>hh" readonly="readonly"
								type="text" size="6" /></td>

							<td scope="col"><select>
									<%
										if(lab.getNst()!=0){
									%>
									<option value="<%=nst%>"><%=nst%></option>
									<%
										}else{
									%>
									<option value="0">Select</option>
									<%
										}
									%>
							</select></td>
							<td scope="col"><input value="<%=lab.getOxyinfoRate()%>" readonly="readonly"
								type="text" size="6" /></td>

							<td scope="col"><input value="<%=lab.getContraction()%>" readonly="readonly"
								type="text" size="6" /></td>

							<td scope="col"><input value="<%=lab.getLabRoomIo()%>" readonly="readonly"
								type="text" size="6" /></td>
						</tr>

						<%	}
							}
								int incr = 0,len=1;
								int inxRow = 1;
								int inxCol = 0;
					   		for(;incr< len;incr++,inxRow++){
					      %>
						<tr>
							<td scope="col"><input type="checkbox"
								tabindex="<%=inxRow%><%=inxCol + 1%>" class="radioCheck"
								id="itemRadio<%=incr%>" name="itemRadio<%=incr%>"
								onchange="checkPrescriptionCheck(<%=incr%>)" /></td>
							<td scope="col" style="width: 100px"><input type="text"
								id="lb2date<%=incr%>" value="<%=dateC%>" name="lb2date<%=incr%>"
								size="8" tabindex="<%=inxRow%><%=inxCol + 2%>"
								class="dateTextSmall" readonly="readonly"> <img
								src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
								validate="Pick a date"
								onclick="setdate('<%=dateC%>',document.laborRoom2.lb2date<%=incr%>,event);" /></td>
							<td scope="col"><input tabindex="<%=inxRow%><%=inxCol + 3%>" 
								type="text" value="<%=time%>" name="lb2Time<%=incr%>"
								id="lb2Time<%=incr%>" size="6" /></td>
							<td scope="col"><input name="lb2MaterPulse<%=incr%>" onkeypress="return isNumberKey(event)"
								id="lb2MaterPulse<%=incr%>" size="6"
								tabindex="<%=inxRow%><%=inxCol + 4%>" type="text"
								class="allownumericwithoutdecimal" /></td>
							<td scope="col"><input tabindex="<%=inxRow%><%=inxCol + 5%>" onkeypress="return isNumberKey(event)"
								type="text" size="6" name="lb2RespRate<%=incr%>"
								id="lb2RespRate<%=incr%>" size="10" /></td>
							<td scope="col"><input tabindex="<%=inxRow%><%=inxCol + 6%>"
								type="text" size="6" name="lb2BP<%=incr%>" id="lb2BP<%=incr%>" onkeypress="return isNumberKey(event)"
								size="8" /></td>
							<td scope="col"><input tabindex="<%=inxRow%><%=inxCol + 7%>"
								type="text" name="lb2LungBase<%=incr%>"
								id="lb2LungBase<%=incr%>" size="20" /></td>

							<td scope="col"><select
								tabindex="<%=inxRow%><%=inxCol + 8%>"
								name="lb2KneeJerk<%=incr%>" id="lb2KneeJerk<%=incr%>">
									<option value="0">select</option>
									<option value="1">+</option>
									<option value="2">-</option>
							</select></td>

							<td scope="col"><input tabindex="<%=inxRow%><%=inxCol + 9%>"
								type="text" name="lb2FatalHeart<%=incr%>" onkeypress="return isNumberKey(event)"
								id="lb2FatalHeart<%=incr%>" size="6" /></td>

							<td scope="col"><select name="lb2NST<%=incr%>"
								id="lb2NST<%=incr%>" tabindex="<%=inxRow%><%=inxCol + 10%>">
									<option value="0">select</option>
									<option value="1">Base line heart rate</option>
									<option value="2">Beat to beat variability</option>
									<option value="3">Accelerations</option>
									<option value="4">Deceleration</option>
							</select></td>

							<td scope="col"><input
								tabindex="<%=inxRow%><%=inxCol + 11%>" type="text"
								name="lb2OxyInfRate<%=incr%>" id="lb2OxyInfRate<%=incr%>"
								size="6" /></td>
								
							<td scope="col"><input
								tabindex="<%=inxRow%><%=inxCol + 12%>" type="text"
								name="lb2Contraction<%=incr%>" id="lb2Contraction<%=incr%>"
								size="6" /></td>

							<td scope="col"><input
								tabindex="<%=inxRow%><%=inxCol + 13%>" type="text"
								name="lb2IO<%=incr%>" id="lb2IO<%=incr%>" size="6" /></td>
						</tr>
						<%
							}
						%>
						</table>
							<input type="hidden" name="hdb" value="<%=incr-1 %>" id="hdb" />
							<input type="hidden" name="hdbTabIndex" id="hdbTabIndex"
								value="<%=inxRow-1%>" />
					</div>
				</div>
			</div>
			
			<input id="lbRoomCount" name="lbRoomCount" type="hidden" value="0"/>
			<div class="clear"></div>
	
<div class="clear"></div>			
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('procedureDoneDiv', this)"  value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Procedure Done: PV Examination</h4></div>
<div class="clear"></div>
<div id="procedureDoneDiv" class="collapasHide">			
    <div style="float: right; margin-right: 50px;">
			<input type="button" class="button" value="Add" align="right" onClick="javascript:addRowProcDoneLabRoom1();" />
			<input type="button" name="Reset" value="Delete" class="button" align="right" onClick="javascript:removeRow('lbRoom1PVTable','hdbpv');" />
	</div>
	<%incr = 1;count=1; %>
	<div class="tableForTab" style="width: 1150px; height: 200px; overflow: scroll;">
	<table class="tablestyle" cellspacing="0" cellpadding="5" width="500" border="0" id="lbRoom1PVTable">
	<tbody>
	<tr><th style="width: 31px;"></th><th style="width: 173px;">Date and Time</th><th>Findings</th></tr>
	<%if (lrProcedureDoneList!=null) {
		for (LrProcedureDone lrPD : lrProcedureDoneList) {
			%>
		 <tr><td scope="col"><%=count%></td>
			<td scope="col" style="width: 100px"><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(lrPD.getProcedureDoneDate())%>" size="8" class="dateTextSmall"  readonly="readonly"></td>
			<td><input  type="text"  value="<%=lrPD.getProcedureDoneTime()%>" size="6" readonly="readonly" /></td>					
		    <td scope="col"><textarea name="lb1Findings1" maxlength="256"class="large" readonly="readonly"><%=lrPD.getFindings()%></textarea></td>
		</tr>	
		<%count++;}
		}%>
	
	   <tr>	<td scope="col"><input type="checkbox" class="radioCheck" id="itemRadio1" name="itemRadio1" onchange="checkPrescriptionCheck(1)" /></td>
			<td scope="col" style="width: 100px"><input type="text"id="lb1pvdate1" value="<%=dateC%>" name="lb1pvdate1" size="8" class="dateTextSmall" readonly="readonly">
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.laborRoom2.lb1pvdate1,event);" />
			<input  type="text" value="<%=time%>" name="lb1pvTime1" id="lb1pvTime1" size="6" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" /></td>					
		<td scope="col"><textarea name="lb1Findings1" maxlength="256"	class="large" ></textarea></td>
		</tr>							
	</tbody>
	</table>
	<input type="hidden" name="hdbpv" value="<%=incr%>" id="hdbpv" />
	</div>
</div>
	
<div class="clear"></div>			
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('fetalDiv', this)"  value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Fetal Well Being</h4></div>
<div class="clear"></div>
	<div id="fetalDiv" class="collapasHide">	
    <div style="float: right; margin-right: 50px;">
			<input type="button" class="button" value="Add" align="right" onClick="javascript:addRowFetalLabRoom2();" />
			<input type="button" name="Reset" value="Delete" class="button" align="right" onClick="javascript:removeRow('lbRoom2FetalTable','hdbfetal');" />
	</div>
	<%incr = 1;count=1; %>
	<div class="tableForTab" style="width: 1150px; height: 200px; overflow: scroll;">
	<table class="tablestyle" cellspacing="0" cellpadding="5" width="500" border="0" id="lbRoom2FetalTable">
	<tbody>
	<tr><th style="width: 31px;"></th><th style="width: 173px;">Date</th><th>Time</th><th>Heart beat</th><th>Character of Amniotic Fluid</th><th>Moulding of fetal skull</th></tr>
	<%if (lrfetalDetailsList!=null) {
		for (LrFetalDetails lrFD : lrfetalDetailsList) {
			%>
		 <tr><td scope="col"><%=count%></td>
			<td scope="col" style="width: 100px"><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(lrFD.getFetalDetailsDate())%>" size="8" class="dateTextSmall"  readonly="readonly"></td>
			<td><input  type="text"  value="<%=lrFD.getFetalDetailsTime()%>" size="6" readonly="readonly" /></td>					
		     <td><input  type="text"  value="<%=lrFD.getPulse()%>" size="6" readonly="readonly" /></td>
		     <td><select><option><%=lrFD.getAmnioticFluid()%></option></select></td>
		     <td><select><option><%=lrFD.getFetalSkullMoulding()%></option></select></td>
		</tr>	
		<%count++;}
		}%>
	
	   <tr>	<td scope="col"><input type="checkbox" class="radioCheck" id="itemRadio1" name="itemRadio1" onchange="checkPrescriptionCheck(1)" /></td>
			<td scope="col" style="width: 100px"><input type="text"id="lb2pfdate1" value="<%=dateC%>" name="lb2pfdate1" size="8" class="dateTextSmall" readonly="readonly">
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.laborRoom2.lb2pfdate1,event);" /></td>
			<td><input  type="text" value="<%=time%>" name="lb2fdTime1" id="lb2fdTime1" size="6" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" /></td>					
		<td><input  type="text" maxlength="5" onkeypress="return isNumberKey(event)" name="fetalheartbeat1" id="fetalheartbeat1"/></td>
		<td><select name="fetalAmFluid1"><option value="">Select</option><option>I</option><option>C</option><option>M</option></select></td>
		<td><select name="fetalMouldingSkull1"><option value="">Select</option><option>0</option><option>+</option><option>++</option><option>+++</option></select></td>
	   </tr>							
	</tbody>
	</table>
	<input type="hidden" name="hdbfetal" value="<%=incr%>" id="hdbfetal" />
	</div>	
	</div>
	
		
<div class="clear"></div>			
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('laborProgressDiv', this)"  value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Labour Progress</h4></div>
<div class="clear"></div>
<div id="laborProgressDiv" class="collapasHide">		
	 	 <h4>Dilatation and Descent</h4>
    <div style="float: right; margin-right: 50px;">
			<input type="button" class="button" value="Add" align="right" onClick="javascript:addRowDDLabRoom2();" />
			<input type="button" name="Reset" value="Delete" class="button" align="right" onClick="javascript:removeRow('lbRoom2ddTable','hdbdd');" />
	</div>
	<%incr = 1;count=1; %>
	<div class="tableForTab" style="width: 1150px; height: 200px; overflow: scroll;">
	<table class="tablestyle" cellspacing="0" cellpadding="5" width="500" border="0" id="lbRoom2ddTable">
	<tbody>
	<tr><th style="width: 31px;"></th><th style="width: 173px;">Date</th><th>Time</th><th>Dilatation</th><th>Descent</th></tr>
	<%if (lrDilatationDescentList !=null) {
		for (LrDilatationDescent lrdd : lrDilatationDescentList) {
			%>
		 <tr><td scope="col"><%=count%></td>
			<td scope="col" style="width: 100px"><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(lrdd.getDilatationDescentDate())%>" size="8" class="dateTextSmall"  readonly="readonly"></td>
			<td><input  type="text"  value="<%=lrdd.getDilatationDescentTime()%>" size="6" readonly="readonly" /></td>					
		    <td><select><option><%=lrdd.getDilatation()%></option></select></td>
		    <td><input  type="text"  value="<%=lrdd.getDescent()%>"  readonly="readonly" /></td>
		</tr>	
		<%count++;}
		}%>
	
	   <tr>	<td scope="col"><input type="checkbox" class="radioCheck" id="itemRadio1" name="itemRadio1" onchange="checkPrescriptionCheck(1)" /></td>
			<td scope="col" style="width: 100px"><input type="text"id="lb2dddate1" value="<%=HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission())%>" name="lb2dddate1" size="8" class="dateTextSmall" readonly="readonly">
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission())%>',document.laborRoom2.lb2dddate1,event);" /></td>
			<td><input  type="text" value="<%=inpatient.getTimeOfAddmission()%>" name="lb2ddTime1" id="lb2ddTime1" size="6" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" /></td>					
		<td><select name="dilatation1"><option value="">Select</option>
		   <%for(int i=0;i<=10;i++){%>
		   <option><%=i%></option>
		   <%}%>
		</select></td>
		<td><input  type="text" maxlength="5" onkeypress="return isNumberKey(event)" name="descent1" id="descent1"/></td>
	   </tr>							
	</tbody>
	</table>
	<input type="hidden" name="hdbdd" value="<%=incr%>" id="hdbdd" />
	</div>		
	
	 <h4>Contraction</h4>
	    <div style="float: right; margin-right: 50px;">
			<input type="button" class="button" value="Add" align="right" onClick="javascript:addRowContractionLabRoom2();" />
			<input type="button" name="Reset" value="Delete" class="button" align="right" onClick="javascript:removeRow('lbRoom2ContractionTable','hdbCont');" />
	</div>
	<%incr = 1;count=1; %>
	<div class="tableForTab" style="width: 1150px; height: 200px; overflow: scroll;">
	<table class="tablestyle" cellspacing="0" cellpadding="5" width="500" border="0" id="lbRoom2ContractionTable">
	<tbody>
	<tr><th style="width: 31px;"></th><th style="width: 173px;">Date</th><th>Time</th><th>Type of Contraction</th></tr>
	<%if (lrContractionList!=null) {
		for (LrContraction lrc : lrContractionList){
			%>
		 <tr><td scope="col"><%=count%></td>
			<td scope="col" style="width: 100px"><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(lrc.getContractionDate())%>" size="8" class="dateTextSmall"  readonly="readonly"></td>
			<td><input  type="text"  value="<%=lrc.getContractionTime()%>" size="6" readonly="readonly" /></td>					
		    <td><select><option><%=lrc.getContractionType()%></option></select></td>
		   
		</tr>	
		<%count++;}
		}%>
	
	   <tr>	<td scope="col"><input type="checkbox" class="radioCheck" id="itemRadio1" name="itemRadio1" onchange="checkPrescriptionCheck(1)" /></td>
			<td scope="col" style="width: 100px"><input type="text"id="lb2Cdate1" value="<%=dateC%>" name="lb2Cdate1" size="8" class="dateTextSmall" readonly="readonly">
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.laborRoom2.lb2Cdate1,event);" /></td>
			<td><input  type="text" value="<%=time%>" name="lb2CTime1" id="lb2CTime1" size="6" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" /></td>					
		 <td><select name="contraction_type1"><option value="">Select</option><option>Mild-Less than 20</option><option>Moderate 20-40 Sec</option><option>Strong greater than 40 Sec</option></select></td>
	   </tr>							
	</tbody>
	</table>
	<input type="hidden" name="hdbCont" value="<%=incr%>" id="hdbCont" />
	</div>		
		</div>	
			


	
<div class="clear"></div>			
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('prbpDiv', this)"  value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Pulse Rate and BP (Captured 4 hourly)</h4></div>
<div class="clear"></div>
<div id="prbpDiv" class="collapasHide">	
    <div style="float: right; margin-right: 50px;">
			<input type="button" class="button" value="Add" align="right" onClick="javascript:addRowPRBPLabRoom2();" />
			<input type="button" name="Reset" value="Delete" class="button" align="right" onClick="javascript:removeRow('lbRoom2PRBPTable','hdbprbp');" />
	</div>
	<%incr = 1;count=1; %>
	<div class="tableForTab" style="width: 1150px; height: 200px; overflow: scroll;">
	<table class="tablestyle" cellspacing="0" cellpadding="5" width="500" border="0" id="lbRoom2PRBPTable">
	<tbody>
	<tr><th style="width: 31px;" rowspan="2"></th><th style="width: 173px;" rowspan="2">Date</th><th rowspan="2">Time</th><th  rowspan="2">Pulse Rate</th><th colspan="2">BP</th></tr>
	<tr><th>Systolic</th><th>Diastolic</th></tr>
	<%if (lrPulseBpList!=null) {
		for (LrPulseBp lrpbp : lrPulseBpList) {
			%>
		 <tr><td scope="col"><%=count%></td>
			<td scope="col" style="width: 100px"><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(lrpbp.getPulseBpDate())%>" size="8" class="dateTextSmall"  readonly="readonly"></td>
			<td><input  type="text"  value="<%=lrpbp.getPulseBpTime()%>" size="6" readonly="readonly" /></td>					
		    <td><input  type="text" size="5" value="<%=lrpbp.getPulseBeat()%>" readonly="readonly"/></td>
		    <td><input  type="text" size="5" value="<%=lrpbp.getBpSystolic()%>" readonly="readonly"/></td>
		    <td><input  type="text" size="5" value="<%=lrpbp.getBpDiastolic()%>" readonly="readonly"/></td>
		    <td></td>
		</tr>	
		<%count++;}
		}%>
	
 	   <tr>	<td scope="col"><input type="checkbox" class="radioCheck" id="itemRadio1" name="itemRadio1" onchange="checkPrescriptionCheck(1)" /></td>
			<td scope="col" style="width: 100px"><input type="text"id="lb2prbpdate1" value="<%=dateC%>" name="lb2prbpdate1" size="8" class="dateTextSmall" readonly="readonly">
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.laborRoom2.lb2prbpdate1,event);" /></td>
			<td><input  type="text" value="<%=time%>" name="lb2prbpTime1" id="lb2prbpTime1" size="6" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" /></td>					
			<td><input  type="text"  name="pulse1" id="pulse1" size="5" onkeypress="return isNumberKey(event)" onkeyup="mask(this.value,this,'3','/');" onblur="if(this.value!=''){validateBpValue(this.value,this)};" maxlength="6"/></td>
			<td><input  type="text"  name="systolic1" id="systolic1" size="5" onkeypress="return isNumberKey(event)" maxlength="5"/></td>
			<td><input  type="text"  name="diastolic1" id="diastolic1" size="5" onkeypress="return isNumberKey(event)" maxlength="5"/></td>
	   </tr> 						
	</tbody>
	</table>
	<input type="hidden" name="hdbprbp" value="<%=incr%>" id="hdbprbp" />
	</div>	
	</div>
		
<div class="clear"></div>			
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('tempDiv', this)"  value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Temperature</h4></div>
<div class="clear"></div>
<div id="tempDiv" class="collapasHide">	
	 
    <div style="float: right; margin-right: 50px;">
			<input type="button" class="button" value="Add" align="right" onClick="javascript:addRowTempLabRoom2();" />
			<input type="button" name="Reset" value="Delete" class="button" align="right" onClick="javascript:removeRow('lbRoom2TempTable','hdbtemp');" />
	</div>
	<%incr = 1;count=1; %>
	<div class="tableForTab" style="width: 1150px; height: 200px; overflow: scroll;">
	<table class="tablestyle" cellspacing="0" cellpadding="5" width="500" border="0" id="lbRoom2TempTable">
	<tbody>
	<tr><th style="width: 31px;"></th><th style="width: 173px;">Date</th><th>Time</th><th>Pulse (Temperature °F)</th></tr>
	<%if (lrTemperatureList!=null) {
		for (LrTemperature lrTemp : lrTemperatureList) {
			%>
		 <tr><td scope="col"><%=count%></td>
			<td scope="col" style="width: 100px"><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(lrTemp.getTemperatureDate())%>" size="8" class="dateTextSmall"  readonly="readonly"></td>
			<td><input  type="text"  value="<%=lrTemp.getTemperatureTime()%>" size="6" readonly="readonly" /></td>					
		     <td><input  type="text" value="<%=lrTemp.getTemperature()%>"  size="5" readonly="readonly"/></td>
		</tr>	
		<%count++;}
		}%>
	
	   <tr>	<td scope="col"><input type="checkbox" class="radioCheck" id="itemRadio1" name="itemRadio1" onchange="checkPrescriptionCheck(1)" /></td>
			<td scope="col" style="width: 100px"><input type="text"id="lb2tempdate1" value="<%=dateC%>" name="lb2tempdate1" size="8" class="dateTextSmall" readonly="readonly">
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.laborRoom2.lb2pvdate1,event);" /></td>
			<td><input  type="text" value="<%=time%>" name="lb2tempTime1" id="lb2tempTime1" size="6" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" /></td>					
		    <td><input  type="text"  name="temperature1" id="temperature1" size="5" onkeypress="return isNumberKey(event)"/></td>
	   </tr>							
	</tbody>
	</table>
	<input type="hidden" name="hdbtemp" value="<%=incr%>" id="hdbtemp" />
	</div>
  </div>			
	
	
<div class="clear"></div>			
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('uaDiv', this)"  value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Urine Analysis</h4></div>
<div class="clear"></div>
<div id="uaDiv" class="collapasHide">		
    <div style="float: right; margin-right: 50px;">
			<input type="button" class="button" value="Add" align="right" onClick="javascript:addRowUALabRoom2();" />
			<input type="button" name="Reset" value="Delete" class="button" align="right" onClick="javascript:removeRow('lbRoom2UATable','hdbua');" />
	</div>
	<%incr = 1;count=1; %>
	<div class="tableForTab" style="width: 1150px; height: 200px; overflow: scroll;">
	<table class="tablestyle" cellspacing="0" cellpadding="5" width="500" border="0" id="lbRoom2UATable">
	<tbody>
	<tr><th style="width: 31px;"></th><th style="width: 173px;">Date</th><th>Time</th><th>Volume</th><th>Albumin</th><th>Acetone</th><th>Glucose</th></tr>
	<%if (lrUrineAnalysisList!=null) {
		for (LrUrineAnalysis lrua: lrUrineAnalysisList) {
			%>
		 <tr><td scope="col"><%=count%></td>
			<td scope="col" style="width: 100px"><input type="text" value="<%=HMSUtil.convertDateToStringWithoutTime(lrua.getUrineAnalysisDate())%>" size="8" class="dateTextSmall"  readonly="readonly"></td>
			<td><input  type="text"  value="<%=lrua.getUrineAnalysisTime()%>" size="6" readonly="readonly" /></td>		
			  <td><input  type="text" value="<%=lrua.getVolume()%>" size="5" readonly="readonly"/></td>		
		     <td><select><option><%=lrua.getAlbumin()%></option></select></td>
		     <td><select><option><%=lrua.getAcetone()%></option></select></td>
		     <td><select><option><%=lrua.getGlucose()%></option></select></td>
		     
		</tr>	
		<%count++;}
		}%>
	
	   <tr>	<td scope="col"><input type="checkbox" class="radioCheck" id="itemRadio1" name="itemRadio1" onchange="checkPrescriptionCheck(1)" /></td>
			<td scope="col" style="width: 100px"><input type="text"id="lb2uadate1" value="<%=dateC%>" name="lb2uadate1" size="8" class="dateTextSmall" readonly="readonly">
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.laborRoom2.lb2uadate1,event);" /></td>
			<td><input  type="text" value="<%=time%>" name="lb2uaTime1" id="lb2uaTime1" size="6" onblur="IsValidTime(this.value,this.id)" onkeyup="mask(this.value,this,'2',':');" /></td>
			<td><input  type="text"  name="volume1" id="volume1" size="5" maxlength="5"/></td>					
		    <td><select name="albumin1" id="albumin1"><option value="">Select</option><option>+</option><option>-</option></select>
		    <td><select name="acetone1" id="acetone1"><option value="">Select</option><option>+</option><option>-</option></select>
		   	<td><select name="glucose1" id="glucose1"><option value="">Select</option><option>+</option><option>-</option></select>
	   </tr>							
	</tbody>
	</table>
	<input type="hidden" name="hdbua" value="<%=incr%>" id="hdbua" />
	</div>	
  </div>			
 	<input type="button" class="button" value="Submit" align="left"
		onClick="if(labRoom2Valid()){submitFormForButton('laborRoom2','ipd?method=addLaborRoom2')}" />
<!-- <input class="button" value="Submit" onclick="submitFormForButton('laborRoom2','ipd?method=addLaborRoom2')" type="button" align="left">
 -->		
	<!-- <input type="button"  value="Check" class="button" onclick="labRoom2Valid()"/>    --> 

	<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	
