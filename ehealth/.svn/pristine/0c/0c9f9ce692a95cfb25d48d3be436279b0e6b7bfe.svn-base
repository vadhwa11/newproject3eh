<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.InjAppointmentHeader"%>
<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript"> 
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';
</script>

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
		<%-- serverdate = '<%=date+"/"+month+"/"+year%>' --%>
	</script>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTimeWithoutSc");
		String diagnosis = "";
		String firstName="";
		String middleName = "";
		String lastName = "";
 		String userName = "";
 		String yearMonth = "";
 		String Gendre="";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
		
		List<Visit> visitList = new ArrayList<Visit>();
		if(map.get("visitList") != null){
			visitList= (List<Visit>)map.get("visitList");
		}
		
		List<InjAppointmentDetails>aList=new ArrayList<InjAppointmentDetails>();
		if(map.get("aList")!=null){
			aList=(List<InjAppointmentDetails>)map.get("aList");
		}
		List<StoreItemBatchStock>batchList=new ArrayList<StoreItemBatchStock>();
		if(map.get("batchList")!=null){
			batchList=(List<StoreItemBatchStock>)map.get("batchList");
		}
	
	%>
	<h4><%=message %></h4>
	<div class="clear"></div>
	<div class="titleBg"><h2>Injection Register</h2></div>
	<div class="clear"></div>
	
<form name="injectionAdministration" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<% if(visitList.size()>0){ %>
	<input type="hidden" name="appointmentHeaderId" value="@@@"/>
<%} %>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">

<%
Set<Integer> icdTemp = new HashSet<Integer>();
for(Visit visitObj : visitList){

	Date toDates = visitObj.getVisitDate();
	Calendar vDate = Calendar.getInstance();
	vDate.setTime(new Date());
    Format format = new SimpleDateFormat("dd/MM/yyyy");
    String visitDate = format.format(vDate.getTime());
 
if(visitObj.getHin()!=null){ %>
<input type="hidden" name="hinId" value="<%=visitObj.getHin().getId() %>" id="hinId"/>

<%}if(visitObj !=null){ %>
<input type="hidden" name="visitId" value="<%=visitObj.getId() %>" id="visitId"/>
<input type="hidden" name="visitDate" value="<%=visitDate %>" id="visitDate"/>
<%}

if(visitObj.getHin()!=null){
	if(visitObj.getHin().getPFirstName() != null){
		firstName= visitObj.getHin().getPFirstName();
	}	

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

	if(visitObj.getHin().getSex() != null){
		Gendre= visitObj.getHin().getSex().getAdministrativeSexName();
	}	

	Set<OpdPatientDetails> patientDetails = new HashSet<OpdPatientDetails>();
	Set<DischargeIcdCode> icdSet = new HashSet<DischargeIcdCode>();

	if(visitObj!=null){
		if(visitObj.getDischargeIcdCodes()!= null){
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
		}
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
</div>

<div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div><div class="Clear"></div>
<div class="Block">
<%int j=1; %>
<% if(aList.size() > 0){ %>
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
		<th scope="col">Batch No</th>
		<th scope="col">Available Stock</th>
		<th scope="col">Issue Stock</th>
		<th scope="col">Appointment Date</th>
		<th scope="col">Nursing Remarks</th>
		<th scope="col">Action</th>
	</tr>
	
	<%
	List<Integer> nrInjList = new ArrayList<Integer>();
	for(InjAppointmentDetails appointmentDetails : aList){
		String status=appointmentDetails.getStatus();
				
		if(!nrInjList.contains(appointmentDetails.getPrescriptionDetails().getId())) {
			nrInjList.add(appointmentDetails.getPrescriptionDetails().getId());	
		} else {
			continue;
		}
		%>
		<tr>
			<td>
			<input type="hidden" name="appointmentHeaderId<%=j %>" id="appointmentHeaderId<%=j %>" value="<%=appointmentDetails.getInjAppointmentHeader().getId() %>"/>
			<input type="hidden" name="appointmentDetailsId<%=j %>" id="appointmentDetailsId<%=j %>" value="<%=appointmentDetails.getId() %>"/>
			<input type="hidden" name="immunizationInj<%=j %>" id="immunizationInj<%=j %>" value="<%=appointmentDetails.getImmunizationInj()!=null ? appointmentDetails.getImmunizationInj() : ""%>">
			<input type="hidden" name="vaccinId<%=j %>" id="vaccinId<%=j %>" value="<%=appointmentDetails.getVaccinId()!=null ? appointmentDetails.getVaccinId() : ""%>">
			<input type="hidden" name="Id<%=j %>" value="<%=appointmentDetails.getId()%>" >
			<%-- <input type="hidden" name="hinId" id="hinId" value="<%=appointmentDetails.getInjAppointmentHeader().getHin().getId()%>" /> --%>
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
			<input type="hidden" name="itemId<%=j%>" id="itemId<%=j %>" value="<%=appointmentDetails.getPrescriptionDetails().getItem().getId() %>" /></td>
			<td>
			<input type="text" class="grdTextSmall" name="dose<%=j %>" readonly="readonly"  value="<%= appointmentDetails.getPrescriptionDetails().getDosage()!=null ? appointmentDetails.getPrescriptionDetails().getDosage(): "1"%>" size="2" maxlength="4" validate="" /></td>
			<td><input type="text" class="small" name="route<%=j %>" readonly="readonly"  value="<%=(appointmentDetails.getPrescriptionDetails().getRoute()!=null && appointmentDetails.getPrescriptionDetails().getRoute().getRouteName()!=null)?appointmentDetails.getPrescriptionDetails().getRoute().getRouteName():""%>" size="5"/></td>
		 	
			<td>
			<%if(appointmentDetails.getBatchNo()!=null && appointmentDetails.getAdministrator()!=null && appointmentDetails.getAdministrator().equalsIgnoreCase("n") && appointmentDetails.getStatus().equalsIgnoreCase("y")) {%>
				<input type="text" class="small" readonly="readonly" value="<%=appointmentDetails.getBatchNo()%>"/> 
			<%} else if(appointmentDetails.getFinalStatus() !=null && appointmentDetails.getFinalStatus().equalsIgnoreCase("y")){ %>
				<input type="text" class="small" readonly="readonly" value=""/> 
			<%}else{%>
				<select id="itemBatchStock<%=j %>" onchange="showClosingStock(this.value,<%=j%>)">
					<option value="0">Select</option>
					<%for(StoreItemBatchStock str:batchList){
						if(appointmentDetails.getItem().getId().equals(str.getItem().getId())) {%>
							<option value="<%=str.getBatchNo() %>:<%=str.getId()%>:<%=str.getClosingStock()%>"><%=str.getBatchNo() %></option>
					<%} } %>
				</select>
			<%} %>
			</td>
		 	
		 	<td><input type="text" class="small" readonly="readonly" id ="availableStock<%=j %>"  name="availableStock<%= j%>" /></td>
			<td><input type="text" class="grdTextSmall" id ="issueStock<%=j %>" name="issueStock<%=j %>" value="<%=appointmentDetails.getPrescriptionDetails().getDosage() %>" readonly="readonly" /></td>
		 	<td><input type="text" class="small" id="appointmentDate<%=j %>" name="appointmentDate<%=j %>"	size="18" readonly="readonly" value="<%=(appointmentDetails.getInjAppointmentDate()!=null? HMSUtil.convertDateToStringWithoutTime(appointmentDetails.getInjAppointmentDate()): "") %>" /></td>
		 	<td><input type="text" class="small" name="remarks<%=j %>" id="remarks<%=j %>" value="<%=appointmentDetails.getNursingRemark()!=null?appointmentDetails.getNursingRemark():"" %>" tabindex="1" size="30"	 /></td>

		 	<td>
		 	<%if(appointmentDetails.getFinalStatus()==null || appointmentDetails.getFinalStatus().equalsIgnoreCase("n")) {%>
		 		<input type="button"  id="issue" name="issue" value="Submit" class="button" onclick="openPopupForIssue(<%=j%>)" />
		 	<%}else{ %>
		 		<input type="text" class="small" name="finalStatus<%=j %>" readonly="readonly" value="Completed"  size="8"/>
		 	<%} %>
			</td>	
		<%j++;%> 
	</tr>
		<%}%>
			
</table>
</div>
	<input type="hidden" name="injCount" value="<%=j -1%>" id="injCount" />

<div class="clear"></div>
<div class="Clear"></div>
<%}%>


<div class="Clear"></div>
<div class="division"></div>
<div class="bottom">
<div class="Clear"></div>
</div>
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

function showClosingStock(val,count){
	if(val!=0){
		var str=val.split(":");
		var stockId=str[1];
		var closingStock=str[2];
		document.getElementById("availableStock"+count).value=closingStock;
	}else{
		document.getElementById("availableStock"+count).value="";
	}
}

function openPopupForIssue(rowVal)
{
	var appointmentDetailsId = document.getElementById("appointmentDetailsId"+rowVal).value;
	var remarks=document.getElementById("remarks"+rowVal).value;
	var itemBatchStock=document.getElementById("itemBatchStock"+rowVal).value;
	if(itemBatchStock != 0)
		var adm = 0;
	else
		var adm = 1;
	var issueStock=document.getElementById("issueStock"+rowVal).value;
	var immunizationInj=document.getElementById("immunizationInj"+rowVal).value;
	var vaccinId=document.getElementById("vaccinId"+rowVal).value;
	var hinId=document.getElementById("hinId").value;
	var visitId=document.getElementById("visitId").value;
	var visitDate=document.getElementById("visitDate").value;
	var formName = "injectionAdministration";
	var url= "/hms/hms/pubHealth?method=submitNursingCare&"+csrfTokenName+'='+csrfTokenValue;
	var data = "&Id="+appointmentDetailsId+"&remarks="+remarks+"&batchNo="+itemBatchStock+"&adm="+adm+"&issueStock="+issueStock+"&immunizationInj="+immunizationInj+"&vaccinId="+vaccinId+"&hinId="+hinId;

	jQuery(function ($) {

		$.ajax({
			type:"POST",
			url: url,	
			data: data,	
			cache: false,
			async: false,
			success: function(msg)
			{
				alert("Records Saved Sucessfully");
			}
			
		});
    });   

	submitForm("injectionAdministration","/hms/hms/pubHealth?method=getImmunNursingCareScreenJSP&injAppId=0&opdDate="+visitDate+"&visitId="+visitId);
}
 
</script>