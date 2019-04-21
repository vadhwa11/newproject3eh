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

if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

if(map.get("inpatientList")!=null){
	inpatientList = (List<Inpatient>) map.get("inpatientList");
}

if(map.get("laborRoomList")!=null){
	laborRoomList = (List<LaborRoom>) map.get("laborRoomList");
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
<form name="laborRoom3" method="post">
<input id="inputDate" name="inputDate" type="hidden"
			value="<%=dateC%>" />
			<input id="inputTime" name="inputTime" type="hidden"
			value="<%=time%>" />
	<div class="titleBg">
		<h2>Labor Room Stage 3</h2>
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
<label class="value"><%getMaritalStatus(inpatient.getHin()); %></label> --%>
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
					onClick="javascript:addRowLabRoom3Table();" /> <input type="button"
					name="Reset" value="Delete" class="button" align="right"
					onClick="javascript:removeRow('lbRoom3Table');" />
			</div>
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="">
				<div class="tableForTab"
					style="width: 1150px; height: 200px; overflow: scroll;">
					<div id="divTemplet1">

						<table border="0" align="center" cellpadding="0" cellspacing="0"
							id="lbRoom3Table">
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
											nst="ccelerations";
										}
										if(lab.getNst()==4){
											nst="eceler";
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

							<td scope="col"><input value="<%=lab.getFetalHeart()%>" readonly="readonly"
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
								id="lb3date<%=incr%>" value="<%=dateC%>" name="lb3date<%=incr%>"
								size="8" tabindex="<%=inxRow%><%=inxCol + 2%>"
								class="dateTextSmall" readonly="readonly"> <img
								src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
								validate="Pick a date"
								onclick="setdate('<%=dateC%>',document.laborRoom3.lb3date<%=incr%>,event);" /></td>
							<td scope="col"><input tabindex="<%=inxRow%><%=inxCol + 3%>" 
								type="text" value="<%=time%>" name="lb3Time<%=incr%>"
								id="lb3Time<%=incr%>" size="6" /></td>
							<td scope="col"><input name="lb3MaterPulse<%=incr%>"
								id="lb3MaterPulse<%=incr%>" size="6" onkeypress="return isNumberKey(event)"
								tabindex="<%=inxRow%><%=inxCol + 4%>" type="text"
								class="allownumericwithoutdecimal" /></td>
							<td scope="col"><input tabindex="<%=inxRow%><%=inxCol + 5%>"
								type="text" size="6" name="lb3RespRate<%=incr%>" onkeypress="return isNumberKey(event)"
								id="lb3RespRate<%=incr%>" size="10" /></td>
							<td scope="col"><input tabindex="<%=inxRow%><%=inxCol + 6%>"
								type="text" size="6" name="lb3BP<%=incr%>" id="lb3BP<%=incr%>" onkeypress="return isNumberKey(event)"
								size="8" /></td>
							<td scope="col"><input tabindex="<%=inxRow%><%=inxCol + 7%>"
								type="text" name="lb3LungBase<%=incr%>"
								id="lb3LungBase<%=incr%>" size="20" /></td>

							<td scope="col"><select
								tabindex="<%=inxRow%><%=inxCol + 8%>"
								name="lb3KneeJerk<%=incr%>" id="lb3KneeJerk<%=incr%>">
									<option value="0">select</option>
									<option value="1">+</option>
									<option value="2">-</option>
							</select></td>

							<td scope="col"><input tabindex="<%=inxRow%><%=inxCol + 9%>"
								type="text" name="lb3FatalHeart<%=incr%>" onkeypress="return isNumberKey(event)"
								id="lb3FatalHeart<%=incr%>" size="6" /></td>

							<td scope="col"><select name="lb3NST<%=incr%>"
								id="lb3NST<%=incr%>" tabindex="<%=inxRow%><%=inxCol + 10%>">
									<option value="0">select</option>
									<option value="1">Base line heart rate</option>
									<option value="2">Beat to beat variability</option>
									<option value="3">ccelerations</option>
									<option value="4">eceler</option>
							</select></td>

							<td scope="col"><input
								tabindex="<%=inxRow%><%=inxCol + 11%>" type="text"
								name="lb3OxyInfRate<%=incr%>" id="lb3OxyInfRate<%=incr%>"
								size="6" /></td>
								
							<td scope="col"><input
								tabindex="<%=inxRow%><%=inxCol + 12%>" type="text"
								name="lb3Contraction<%=incr%>" id="lb3Contraction<%=incr%>"
								size="6" /></td>

							<td scope="col"><input
								tabindex="<%=inxRow%><%=inxCol + 13%>" type="text"
								name="lb3IO<%=incr%>" id="lb3IO<%=incr%>" size="6" /></td>
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
			<input id="lbRoomType" name="lbRoomType" type="hidden" value="3"/>
			<input id="lbRoomCount" name="lbRoomCount" type="hidden" value="0"/>
			
	<input type="button" class="button" value="Submit" align="left"
		onClick="if(labRoom3Valid()){submitFormForButton('laborRoom3','ipd?method=addLaborRoom3')}" />
		
	<!-- <input type="button"  value="Check" class="button" onclick="labRoom2Valid()"/>    --> 

	<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	
