
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitT"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.OtMasUnitDay"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>

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
public String getHinNo(Inpatient inpatient){
	
	String hinNo = "-";
	try
	{
		hinNo=inpatient.getHin().getHinNo();
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

public String getGender(Patient inpatient){
	String gender="-";
	try
	{
		gender = inpatient.getSex().getAdministrativeSexName();
	}
	catch(Exception exception)
	{
		gender="-";
	}
	return gender;
	
}

public String getMaritalStatus(Inpatient inpatient){
	String maritalStatus="-";
	try
	{
		maritalStatus=inpatient.getHin().getMaritalStatus().getMaritalStatusName();
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
				/*if(patient.getAge()!= null && !patient.getAge().equals("")){
					String age = patient.getAge();
					currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
				}else if(patient.getDateOfBirth()!=null){
					currentAge = HMSUtil.calculateAge(patient.getDateOfBirth());
				}*/
				if(inpatient.getDateOfBirth()!=null){
				Date dob=inpatient.getDateOfBirth();
				String ymd=HMSUtil.calculateYearMonthDay(dob);
				System.out.println("yearsmontday "+ymd);
				String d[]=ymd.split("&");
				String year1=d[0];
				String months1=d[1];
				System.out.println("years "+year1+" month "+months1);
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

public String getPatientCategory(Patient inpatient){
	String pCategory="-";

	try
	{
		pCategory =inpatient.getPatientType()!= null?patient.getPatientType().getPatientTypeName():"";
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
		unit = inpatient.getUnitM().getUnitCode(); 
	}
	catch(Exception exception)
	{
		unit="-";
	}
	return unit;
}


public String getUnitHead(Inpatient inpatient){
	String unitHead="-";
	try
	{
		for(HospitalDoctorUnitT doctorUnitT : inpatient.getUnitM().getHospitalDoctorUnitTs()){
			if(doctorUnitT.getHeadFleg().equalsIgnoreCase("y")){
				unitHead = doctorUnitT.getEmployee().getEmployeeName(); 
				break;
			}
			
		}
	}
	catch(Exception exception)
	{
		unitHead="-";
	}
	return unitHead;
}

public String getPatientReferringDoctor(Inpatient inpatient){
	String refferingDoctor="-";
	try
	{/* 
		refferingDoctor=inpatient.getOpdPatientDetails().getReferredDoctor().getFirstName();
		if(inpatient.getOpdPatientDetails().getReferredDoctor().getMiddleName()!=null)
		{
			refferingDoctor +=" "+inpatient.getOpdPatientDetails().getReferredDoctor().getMiddleName();
		}
		
		if(inpatient.getOpdPatientDetails().getReferredDoctor().getLastName()!=null)
		{
			refferingDoctor+=" "+inpatient.getOpdPatientDetails().getReferredDoctor().getLastName();
		}
		 */

		refferingDoctor=inpatient.getOpdPatientDetails().getEmployee().getFirstName();
		if(inpatient.getOpdPatientDetails().getEmployee().getMiddleName()!=null)
		{
			refferingDoctor +=" "+inpatient.getOpdPatientDetails().getEmployee().getMiddleName();
		}
		
		if(inpatient.getOpdPatientDetails().getEmployee().getLastName()!=null)
		{
			refferingDoctor+=" "+inpatient.getOpdPatientDetails().getEmployee().getLastName();
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
		ipNo=/* inpatient.getHospital().getId()+"/"+inpatient.getDateOfAddmission()+"/"+ */inpatient.getAdNo();
	}
	catch(Exception exception)
	{
		ipNo="-";
	}
	return ipNo;
}
Inpatient inpatient = new Inpatient();
Visit visit = new Visit();  // added by amit das on 20-09-2016
Patient patient = new Patient(); // added by amit das on 20-09-2016

%>
<%if(session.getAttribute("inpatient")!=null){
	inpatient=(Inpatient)session.getAttribute("inpatient");
	patient=inpatient.getHin();
	System.out.println("HIn "+patient.getId());
}
System.out.println("HIn E");
System.out.println("HIn "+patient.getId());
/* Map map = new HashMap();
//String includedJsp = null;
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

}*/
String otTypes = "";
if(request.getParameter("otType")!=null && !request.getParameter("otType").equals("")){
	otTypes = (String) request.getParameter("otType");
} 
String opRefferDocName="";
if(session.getAttribute("opRefferDoctor")!=null && !session.getAttribute("opRefferDoctor").equals("")){
	opRefferDocName = (String) session.getAttribute("opRefferDoctor");
	session.setAttribute("opRefferDoctor", "");
}
%>

 
<div class="Block">
<label>UHID</label> 
<%-- <label class="value"><%=getHinNo(inpatient.getHin())%></label> --%>  <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getHinNo(patient)%></label> <!-- added by amit das on 20-09-2016 -->
<label>Patient Name</label> 
<%-- <label class="value"><%=getPatientName(inpatient.getHin())%></label> --%> <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getPatientName(patient)%></label> <!-- added by amit das on 20-09-2016 -->
<label>Gender</label> 
<%-- <label class="value"><%=getGender(inpatient.getHin()) %></label> --%> <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getGender(patient)%></label> <!-- added by amit das on 20-09-2016 -->
<!-- <label>Marital Status</label> --> 
<%-- <label class="value"><%=getMaritalStatus(inpatient.getHin()) %></label> --%> <!-- commented by amit das on 20-09-2016 -->
<%-- <label class="value"><%=getMaritalStatus(patient)%></label> <!-- added by amit das on 20-09-2016 --> --%>

<div class="clear"></div>

<label>Age</label> 
<%-- <label class="value"><%=getPatientAge(inpatient.getHin()) %></label> --%> <!-- commented by amit das on 20-09-2016 -->
<label class="value"> <%=getPatientAge(patient)%> </label> <!-- added by amit das on 20-09-2016 -->
<label>Patient Category</label> 
<%-- <label class="value"><%=getPatientCategory(inpatient.getHin()) %></label> --%> <!-- commented by amit das on 20-09-2016 -->
<label class="value"><%=getPatientCategory(patient)%></label> <!-- added by amit das on 20-09-2016 -->
<label>Department</label> 
<label class="value"><%=(inpatient!=null)?getPatientDepartment(inpatient):visit.getDepartment().getDepartmentName() %></label>

<div class="clear"></div>
 
<label>Unit</label> 
<label class="value"><%=(inpatient!=null)?getPatientUnit(inpatient):"" %></label>

<label>Unit Head</label> 
<label class="value"><%=getUnitHead(inpatient) %></label>
<label>Referring Doctor</label> 
<label class="value"><%=(inpatient!=null)?getPatientReferringDoctor(inpatient):opRefferDocName %></label>

<div class="clear"></div>

<label>Admitting Doctor</label> 
<label class="value"><%=getPatientAdmittingDoctor(inpatient) %></label>
<label>IP No.</label> 
<label class="value"><%=getPatientAdmitionNo(inpatient) %></label>
<label>Address</label> 
<%-- <label class="value"><%=getAddress(inpatient.getHin()) %></label> --%> <!-- commented by amit das on 20-09-2016 -->
<label class="valueFixedWidth"><%=getAddress(patient)%></label> <!-- added by amit das on 20-09-2016 -->
 <div class="clear"></div>
<%if(otTypes.equals("Minor")) { %>
	<input type="button" class="buttonBig" id="patientHistory"
			name="patientHistory" value="Patient History"
			onclick="showPatientHistory('<%=getHinNo(patient)%>',csrfTokenName+'='+csrfTokenValue);" />
<%} %>



</div>

<script type="text/javascript">
function showPatientHistory(hinNo, csrf) {
	var url = '/hms/hms/enquiry?method=showPatientDetails&hinNo=' + hinNo
			+ '&' + csrf + '&' + csrfTokenName + '=' + csrfTokenValue;
	newwindow = window.open(url, 'opd_window', "left=100,top=10,height=630,width=1024,status=1,scrollbars=yes,resizable=0");

}
</script>