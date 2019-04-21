<%@page import="org.joda.time.YearMonth"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.InjAppointmentHeader"%>
<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>

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

<%
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String dateOfAdmission = (String)utilMap.get("currentDate");
		//Date dateOfAdmission=(Date)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTimeWithoutSc");
		String diagnosis = "";
		String firstName="";
		String middleName = "";
		String lastName = "";
 		String userName = "";
 		String age="-";
 		String Gendre="";
 		String yearMonth = "";
		int visitId=0;
		int hinId=0;
		int referralDept=0;
		int referralHospital=0;
		int referralDistrict=0;
		String referralType="NA";
		String deptNameforExternal="NA";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		
		if(map.get("deptId") != null){
			referralDept = (Integer)map.get("deptId");
		}
		
		if(map.get("hospitalId") != null){
			referralHospital = (Integer)map.get("hospitalId");
		}
		if(map.get("hospitalName") != null){
			deptNameforExternal = (String)map.get("hospitalName");
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
		List<ProcedureDetails>procedurelist =new ArrayList<ProcedureDetails>();
		List<Object[]>procedurelistObject =new ArrayList<Object[]>();
		if(map.get("pendingProcList") != null){
			procedurelist =(List<ProcedureDetails>)map.get("pendingProcList");
		}
		
		if(map.get("procedurelist") != null){
			procedurelistObject =(List<Object[]>)map.get("procedurelist");
		} 
		
		
		//out.print("procedurelist="+procedurelist.size());
		//out.print("procedurelistObject="+procedurelistObject.size());
		
		
		List<PatientPrescriptionHeader> injectionList = new ArrayList<PatientPrescriptionHeader>();
		if(map.get("injectionList") != null){
			injectionList= (List<PatientPrescriptionHeader>)map.get("injectionList");
		}
		
		PatientPrescriptionHeader prescriptionHeader = new PatientPrescriptionHeader();
		
		List<InjAppointmentDetails> injectionAppList = new ArrayList<InjAppointmentDetails>();
		if(map.get("injectionAppList") != null){
			injectionAppList= (List<InjAppointmentDetails>)map.get("injectionAppList");
		}
		
		List<Visit> visitList = new ArrayList<Visit>();
		if(map.get("visitList") != null){
			visitList= (List<Visit>)map.get("visitList");
		}
		
		List<PatientPrescriptionDetails> ppdList = new ArrayList<PatientPrescriptionDetails>();
		if(map.get("ppdList") != null){
			ppdList= (List<PatientPrescriptionDetails>)map.get("ppdList");
		}		
		
		/* InjAppointmentHeader injAppointmentHeader = new InjAppointmentHeader();
		if(injectionList.size() > 0){
			prescriptionHeader = injectionList.get(0);
		}else if(injectionAppList.size() > 0){
			for(InjAppointmentDetails injAppointmentDetails :injectionAppList){
				prescriptionHeader = injAppointmentDetails.getPrescriptionDetails().getPrescription();
			}
		} */
		Set<PatientPrescriptionHeader> prescriptionHeaderSet = new HashSet<PatientPrescriptionHeader>();
		for(Visit visit: visitList)
		{
			prescriptionHeaderSet = visit.getPatientPrescriptionHeaders();
		}
		
		int prescriptionHeaderId =0;
		 for(PatientPrescriptionHeader listC: prescriptionHeaderSet)
		{
			 prescriptionHeaderId = listC.getId();
		} 
		
		List<MasFrequency> freqList = new ArrayList<MasFrequency>();
		if(map.get("freqList") != null){
			freqList = (List<MasFrequency>)map.get("freqList");
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		int item_category_id=0;
		try {
			properties.load(resourcePath.openStream());
			String item_category_code = properties.getProperty("item_class_id");
			item_category_id=Integer.parseInt(item_category_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<InjAppointmentDetails>aList=new ArrayList<InjAppointmentDetails>();
		if(map.get("aList")!=null){
			aList=(List<InjAppointmentDetails>)map.get("aList");
		}
		
	
	%>
	<h4><%=message %></h4>
	<div class="clear"></div>
	<div class="titleBg"><h2>Injection Register</h2></div>
	<div class="clear"></div>
	
<form name="injectionAdministration" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="hospitalName" id="hospitalName" value="<%=deptNameforExternal%>">
<input type="hidden" name="userName" id="userName" value="<%=userName %>">
<input type="hidden" name="hospitalId" id="hospitalId" value="<%=referralHospital %>">
<input type="hidden" name="departmentId" id="departmentId" value="<%=referralDept %>">
<input type="hidden" name="admissionDate" id="admissionDate" value="<%=dateOfAdmission %>">
<input type="hidden" name="refereddoctor" id="refereddoctor" value="">


<%//}
if(visitList.size()>0){ %>
<input type="hidden" name="appointmentHeaderId" value="@@@"/>
<%} %>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%-- <label>Service No.</label>
<label class="value"><%=prescriptionHeader.getHin().getServiceNo()!=null?prescriptionHeader.getHin().getServiceNo() :"" %></label> --%>

<%
Set<Integer> icdTemp = new HashSet<Integer>();
for(Visit visitObj : visitList){
if(visitObj.getHin()!=null){
	hinId =visitObj.getHin().getId();%>
<input type="hidden" name="hinId" value="<%=visitObj.getHin().getId() %>" id="hinId"/>

<%}if(visitObj !=null){ 
	visitId=visitObj.getId();%>
<input type="hidden" name="visitId" value="<%=visitObj.getId() %>" id="visitId"/>
<%} %>
<input type="hidden" name="prescriptionHeaderId" id="prescriptionHeaderId" value="<%=prescriptionHeaderId %>"/>
<%

if(visitObj.getHin()!=null){
	if(visitObj.getHin().getPFirstName() != null){
		firstName= visitObj.getHin().getPFirstName();
	}	
	
if(visitObj.getHin().getPMiddleName() != null){
	middleName = visitObj.getHin().getPMiddleName();
}
if(visitObj.getHin().getPLastName() != null){
	lastName = visitObj.getHin().getPLastName();
}

if(visitObj.getHin().getAge() != null){
	age= visitObj.getHin().getAge();
}	

if(visitObj.getHin().getSex() != null){
	Gendre= visitObj.getHin().getSex().getAdministrativeSexName();
}	
//Visit visit = new Visit();

Set<OpdPatientDetails> patientDetails = new HashSet<OpdPatientDetails>();
Set<DischargeIcdCode> icdSet = new HashSet<DischargeIcdCode>();

	if(visitObj!=null){
		
		/* if(visitObj.getDischargeIcdCodes()!= null){
			icdSet = visitObj.getDischargeIcdCodes();
		}
		if(visitObj.getOpdPatientDetails()!= null){
			patientDetails = visitObj.getOpdPatientDetails();
			for(OpdPatientDetails opdPatientDetails : patientDetails){
				if(opdPatientDetails.getInitialDiagnosis()!= null){
					diagnosis = opdPatientDetails.getInitialDiagnosis();
				}else{
					if(icdSet.size() > 0){
						for(DischargeIcdCode icdCode : icdSet){
							if(icdTemp.add(icdCode.getIcd().getId())){
								if(!diagnosis.equals("")){
									diagnosis += ",";
								}
								diagnosis += icdCode.getIcd().getIcdName();
							}
							
						}
					}
					
				}
			}
		} */
		
		if(visitObj.getOpdPatientDetails()!= null){
			patientDetails = visitObj.getOpdPatientDetails();
			for(OpdPatientDetails opdPatientDetails : patientDetails){
				if(opdPatientDetails.getFinalDiagnosis()!=null){
					diagnosis = opdPatientDetails.getFinalDiagnosis();
				}else if(opdPatientDetails.getProvisionalDiagnosis()!=null){
					diagnosis = opdPatientDetails.getProvisionalDiagnosis();
				}
					
			}
		}
	}
	/* Added by Arbind on 03-05-2017 */
	if(visitObj.getHin().getDateOfBirth()!=null){
		Date dob=visitObj.getHin().getDateOfBirth();
		String ymd=HMSUtil.calculateYearMonthDay(dob);
		String d[]=ymd.split("&");
		int year1=Integer.parseInt(d[0].toString());
		int months1=Integer.parseInt(d[1].toString());
		int days1=Integer.parseInt(d[2].toString());
		yearMonth = year1 != 0 ? d[0] + " Y " : "";
		yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
		yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
	}
%>

<%} %>
<%} %>
<label>Patient Name</label> 
<label class="value"><%=firstName+" "+middleName+" "+lastName %></label>

<label> Age</label> 
<label class="value"><%=yearMonth%></label>


<label> Gender</label> 
<label class="value"><%=Gendre%></label>

<div class="Clear"></div>

<label> Diagnosis</label> 
<label class="valueAuto"><%=diagnosis %></label>
<div class="clear"></div>
<input name="Submit11" id="Submit11" class="buttonAuto" type="button" align="right"	value="Refer Back"
				 onclick="submitForm('injectionAdministration','/hms/hms/opd?method=referBackNursingPatientToOpd')" />
</div>

<div class="Block">
<h4>Procedure Details</h4>
<%  //out.print("procedurelist="+procedurelist.size()); %>
<%int i=1; 
if(procedurelist.size() > 0){%>
<div class="Clear"></div>
<div class="cmntable" style="height: 200px; overflow-x: hidden;">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="procedure">
	<tr>
		<!-- <th scope="col"></th> -->
		<th scope="col">Procedure Name</th>
		<th scope="col">Procedure Start Date</th>		
		<th scope="col">Frequency</th>
		<th scope="col">No Of Days</th>
		<th scope="col">OP Remarks</th>
		<th scope="col">Final Status</th>
		<th scope="col">Action</th>
	</tr>
		<%	
		
		List<Integer> nrList = new ArrayList<Integer>();
		for(ProcedureDetails procedureDetails : procedurelist){
			
			if(!nrList.contains(procedureDetails.getProcedure().getId()))
			{
				nrList.add(procedureDetails.getProcedure().getId());	
			}
			else
			{
				continue;
			}
			
			
			
			
		%>
		<tr>
		    
			<td><input type="text" class="nomeclatureOpdgridText" disabled="disabled" readonly="readonly" name="procedureName<%=i %>" id="procedureName<%=i %>" value="<%=procedureDetails.getProcedure().getNursingName()%>" /></td>	
			<td><input type="text" class="small" readonly="readonly" value="<%= HMSUtil.convertDateToStringWithoutTime(procedureDetails.getProcedureHeader().getRequisitionDate()) %>" size="5"/></td>
			<td><input type="text" class="small" readonly="readonly" value="<%= procedureDetails.getFrequency()!=null?procedureDetails.getFrequency().getFrequencyName():"" %>" size="5"/></td>
			<td><input type="text" class="small" readonly="readonly"  id="noOfDays<%=i %>" value="<%= procedureDetails.getNoOfDays()!=null?procedureDetails.getNoOfDays():"" %>" size="5"/></td>
			<td><input type="text"  readonly="readonly" value="<%=procedureDetails.getRemarks()!=null?procedureDetails.getRemarks():""%>" size="20"/></td>
			<td><input type="text" class="small" name="status<%=procedureDetails.getId()%>" id="status<%=procedureDetails.getId()%>" readonly="readonly" value="<%=procedureDetails.getFinalProcedureStatus().trim().equalsIgnoreCase("y")?"Completed":"Not Completed"%>" class="small" size="13"/></td>
			<td><input type="button" class="button" readonly="readonly" name="save<%=procedureDetails.getId()%>" id="save<%=procedureDetails.getId()%>" value="View"  onclick="openPopupForProcedure('<% out.print(i); %>@@@<%=procedureDetails.getId()%>@@@<%=procedureDetails.getFrequency().getFrequencyCount()%>@@@<%=procedureDetails.getFrequency().getFrequencyName()%>@@@<%=procedureDetails.getProcedureHeader().getId()%>@@@<%=procedureDetails.getFrequency().getId()%>@@@<%=procedureDetails.getProcedure().getId()%>@@@<%=hinId %>@@@<%=visitId %>@@@<%=dateOfAdmission %>@@@<%=referralDept %>@@@<%=referralHospital %>@@@<%=userName %>@@@<%=deptNameforExternal%>')" size="20"/></td>
		</tr>
		<%
			
		i++;
		
			}%>
		
</table>
</div>
<%}else{%>
<h2><span>Record Not Found!</span></h2>
<%} %>

<div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div>

<h4>Prescription Details</h4>
<%if(ppdList.size() > 0){
i=0;
%>
<div class="Clear"></div>
<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="procedure">
	<tr>
		<!-- <th scope="col"></th> -->
		<th scope="col">Tablet Name</th>
		<th scope="col">Route</th>
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">Issue Status</th>
		<th scope="col">Nursing Status</th>
	</tr>
		<%	for(PatientPrescriptionDetails ppd : ppdList){%>
		<tr>

			<td><input type="text" class="nomeclatureOpdgridText" disabled="disabled" readonly="readonly" name="procedureName<%=i %>" id="procedureName<%=i %>" value="<%=ppd.getItem().getNomenclature()%>" /></td>	
			<td><input type="text" class="small" readonly="readonly"  value="<%=ppd.getRoute()!=null?ppd.getRoute().getRouteName():""%>"size="5"/></td>
			<td><input type="text" class="small" readonly="readonly"  value="<%=ppd.getDosage()%>"size="8"/></td>
			<td><input type="text" class="small" readonly="readonly"  value="<%=ppd.getFrequency() !=null?ppd.getFrequency().getFrequencyName():""%>" class="small" size="13"/></td>
			<td><%if(ppd.getIssuedStatus()!= null && ppd.getIssuedStatus().equalsIgnoreCase("y")) {%>
				<input type="text" class="small" readonly="readonly"  value="Issued" class="small" size="13"/>
				<%} else{%>
				<input type="text" class="small" readonly="readonly"  value="Not Issued" class="small" size="13"/>
				<%} %>
			</td>
			<td>
				<%if(ppd.getNursingStatus()!=null && ppd.getNursingStatus().equalsIgnoreCase("c")){ %>
					<input type="text" class="small" value="Done" readonly="readonly"/>
				<%} else {%>
						<input type="text" class="small" value="Not Done" readonly="readonly"/>
				<%} %>
			</td>
			
		</tr>
		<%i++;}%>
		<input type="hidden" value="<%=ppdList.size() %>" name="noofPrescriptions" id="noofPrescriptions"/>
</table>
</div>
<%}else{%>
<h2><span>Record Not Found!</span></h2>
<%} %>
</div>
<div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div>

<%int j=1; %>
		<%
	
		if(aList.size() > 0){%>
<div class="clear"></div>
<h4>Injection Details</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="injection">

	<tr>
		<th scope="col"></th>
		<th scope="col">Injection Name</th>
		<th scope="col">Dosage (ml)</th>
		<th scope="col">Route</th>
		<th scope="col">Frequency</th>
		<th scope="col">Days</th>
		<th scope="col">Final Status</th>
		<th scope="col"></th>
	</tr>
	
		<%
		List<Integer> nrInjList = new ArrayList<Integer>();
		for(InjAppointmentDetails appointmentDetails : aList){
				String status=appointmentDetails.getStatus();
				
				if(!nrInjList.contains(appointmentDetails.getPrescriptionDetails().getId()))
				{
					nrInjList.add(appointmentDetails.getPrescriptionDetails().getId());	
				}
				else
				{
					continue;
				}
		%>
			<tr>
			<input type="hidden" name="appointmentHeaderId<%=j %>" id="appointmentHeaderId<%=j %>" value="<%=appointmentDetails.getInjAppointmentHeader().getId() %>"/>
		<td>
			<%
			String insulinInjection="";
			if(appointmentDetails.getPrescriptionDetails().getItem()!=null){
				insulinInjection=""+appointmentDetails.getPrescriptionDetails().getItem().getInsulinInjection();
			}
			if(insulinInjection.equalsIgnoreCase("y")){ %>
				<input type="checkbox" disabled="disabled" name="appDtId<%=j %>" id="appDtId<%=j %>" value="<%=  appointmentDetails.getId()%>"/>
			<%}else{ %>
				<input type="checkbox" name="appDtId<%=j %>" id="appDtId<%=j %>" value="<%= appointmentDetails.getId()%>"/>
			<%} %>
		</td>
		<td>
			<input type="text" class="nomeclatureOpdgridText" name="injectionName<%=j%>" readonly="readonly" id="injectionName<%=j %>" value="<%=appointmentDetails.getPrescriptionDetails().getItem().getNomenclature() %>"/>
			<input type="hidden" name="itemId<%=j%>" id="itemId<%=j %>" value="<%=appointmentDetails.getPrescriptionDetails().getItem().getId() %>" />
		</td>
		<td>
		<input type="text" class="small" name="dose<%=j %>" readonly="readonly"  value="<%= appointmentDetails.getPrescriptionDetails().getDosage()!=null ? appointmentDetails.getPrescriptionDetails().getDosage(): "1"%>" size="2" maxlength="4" validate="" /></td>
		<td><input type="text" class="small" name="route<%=j %>" readonly="readonly"  value="<%=(appointmentDetails.getPrescriptionDetails().getRoute()!=null && appointmentDetails.getPrescriptionDetails().getRoute().getRouteName()!=null)?appointmentDetails.getPrescriptionDetails().getRoute().getRouteName():""%>" size="5"/></td>
		<td><input type="text" class="small" name="freq<%=j %>" id="freq<%=j %>" readonly="readonly"   value="<%=appointmentDetails.getPrescriptionDetails().getFrequency()!=null?appointmentDetails.getPrescriptionDetails().getFrequency().getFrequencyName() : ""%>" size="7"/>
		<input type="hidden"  class="small" name="frequencyCount<%=j %>" id="frequencyCount<%=j %>" value="<%=appointmentDetails.getFrequency()!=null?appointmentDetails.getFrequency().getFrequencyCount():""%>" size="5"/>
		</td>
		<td><input type="text" class="small" name="noOfDaysInj<%=j %>" id="noOfDaysInj<%=j %>" readonly="readonly"  value="<%= appointmentDetails.getPrescriptionDetails().getNoOfDays()!=null ? appointmentDetails.getPrescriptionDetails().getNoOfDays() : "" %>" /></td>
		 <td>
		 	<%if(appointmentDetails.getFinalStatus()==null || appointmentDetails.getFinalStatus().equalsIgnoreCase("n")) {%>
		 		<input type="text" class="small" name="finalStatus<%=j %>" readonly="readonly" value="Not Completed"  size="8"/>
		 	<%}else{ %>
		 		<input type="text" class="small" name="finalStatus<%=j %>" readonly="readonly" value="Completed"  size="8"/>
		 	<%} %>
		 </td>	
		<td><input type="button"  id="issue" name="issue" value="View" class="button" onclick="openPopupForIssue(<%=j%>)" /></td>
		<%j++;%> 
	</tr>
		<%}%>
			
</table>
</div>
	<input type="hidden" name="injCount" value="<%=j -1%>" id="injCount" />

<div class="clear"></div>
<div class="Clear"></div>

<input type="hidden" name="checkboxArray" value="" id="checkboxArray" />
<input type="hidden" name="IssuedQtyArray" value="" id="IssuedQtyArray" />
<input type="hidden" name="batchIdArray" value="" id="batchIdArray" />
<input type="hidden" name="batchNoArray" value="" id="batchNoArray" />
<input type="hidden" name="expDateArray" value="" id="expDateArray" />
<div class="clear"></div>
<%}%>


<div class="Clear"></div>
<div class="division"></div>
<div class="bottom">
<div class="Clear"></div>

</div>

</form>
<script>
function validateCheckBox(){
	var injCount = document.getElementById('injCount').value;
	for(var i=1;i<=injCount;i++){
		if(document.getElementById('appDtId'+i).checked){
			return true;
		}
	}
	alert("Please select one record.")
	return false;
}

function openPopupForIssue(rowVal)
{
	var appointmentHeaderId=document.getElementById("appointmentHeaderId"+rowVal).value;
	var appDtId=document.getElementById("appDtId"+rowVal).value;
	var injectionName=document.getElementById("injectionName"+rowVal).value;
	var itemId=document.getElementById("itemId"+rowVal).value;
	var frequency=document.getElementById("freq"+rowVal).value;
	var frequencyCount=document.getElementById("frequencyCount"+rowVal).value;
	var noofDays=document.getElementById("noOfDaysInj"+rowVal).value;
	var nTotalProcedure = parseInt(frequencyCount) * parseInt(noofDays);
	
	var url="/hms/hms/opd?method=openPopupForInjectionIssue&appDtId="+appDtId+"&frequency="+frequency+"&frequencyCount="+frequencyCount+"&noofDays="+noofDays+"&injectionName="+injectionName+"&nTotalProcedure="+nTotalProcedure+"&itemId="+itemId+"&appointmentHeaderId="+appointmentHeaderId+'&'+csrfTokenName+'='+csrfTokenValue;
	newwindow=window.open(url,'name',"height=500,width=1210,status=1,left=0, top=0, scrollbars=1,resizable=0, channelmode=no");
	
}
 
 function openPopupForProcedure(val)
 {
	//alert(val);
	  var arr = new Array();
	  arr= val.split("@@@");
	 var procedureDetailsId= arr[1];
	
	 var frequencyName= arr[3];
	 var frequencyCode = arr[2]; 
	 var frequencyCount = arr[2]; 
	 var procedureHeaderId= arr[4];
	 var frequencyId= arr[5];
	 var nursingId= arr[6];
	 var hinId=arr[7];
	 var visitId=arr[8];
	 var dateOfAdmission=arr[9];
	 var referralDept=arr[10];
	 var referralHospital=arr[11];
	 var userName=arr[12];
	 var deptNameforExternal=arr[13];
	 var procedureName = document.getElementById('procedureName'+arr[0]).value;
	 var noOfDays = document.getElementById('noOfDays'+arr[0]).value;
	 var nTotalProcedure = parseInt(frequencyCode) * parseInt(noOfDays);
	                                                                                                                                          
 	var url="/hms/hms/opd?method=openPopupForProcedureIssue&procedureDetailsId="+procedureDetailsId+"&hinId="+hinId+"&visitId="+visitId+"&dateOfAdmission="+dateOfAdmission+"&referralDept="+referralDept+"&referralHospital="+referralHospital+"&userName="+userName+"&deptNameforExternal="+deptNameforExternal+"&frequencyName="+frequencyName+"&noOfDays="+noOfDays+"&nTotalProcedure="+nTotalProcedure+"&procedureName="+procedureName+"&procedureHeaderId="+procedureHeaderId+"&frequencyId="+frequencyId+"&nursingId="+nursingId+"&frequencyCount="+frequencyCount+'&'+csrfTokenName+'='+csrfTokenValue;
 	newwindow=window.open(url,'name',"height=500,width=1110,status=1,left=0, top=0, scrollbars=1,resizable=0, channelmode=no");
 	
  }
 
 
</script>