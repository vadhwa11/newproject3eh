<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitM"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<OtBooking>otBookingList=new ArrayList<OtBooking>();
if(map.get("bookingList")!=null){
	otBookingList=(List<OtBooking>)map.get("bookingList");
}
System.out.println("List size----->>"+otBookingList.size());
Map<String,Object> utilMap2 = new HashMap<String,Object>();
utilMap2 = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate2 = (String)utilMap2.get("currentDate");
String time2 = (String)utilMap2.get("currentTime");
int hinId=0;
if(map.get("hinId")!=null){
	hinId=(Integer)map.get("hinId");
}
System.out.println("hinId ------ >>>"+hinId);

List<MasDepartment>deptList=new ArrayList<MasDepartment>();
if(map.get("deptList")!=null){
	deptList=(List<MasDepartment>)map.get("deptList");
}
%>
<form name="opSurgeryPlanning" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>

<%-- <label>Days</label>
<select name="dayName" id="dayNameId" onchange="if(validateDays()){submitProtoAjaxWithDivName('opSurgeryPlanning','ot?method=getBookingDetails','BooingDetailsDiv');}">
<option value="0">Select</option>
<%for(OtBooking hospitalDoctorUnitM:otBookingList){ %>
<option value="<%=hospitalDoctorUnitM%>"><%=hospitalDoctorUnitM%></option>
<%} %>
</select>
 --%>
 <table>
 <tr>
 <th>UHID</th>
 <th>Patient Nme</th>
 <th>Age/Sex</th>
 <th>Procedure</th>
 <th>Doctor Name</th>
 <th>PAC Status</th>
 <th>PAC Date</th>
 <th>Admission Required</th>
 <th>Admission Date</th>
 <th>Surgery date</th>
 
 <th>Cancel</th>
<!--  <th>Update</th> -->
 </tr>
 <%
 //int hinId=0;
 int k=1;
 for(OtBooking otbooking:otBookingList){
	// hinId=otbooking.getHin().getId();
	 
	 %>
 <tr>
 <td><%=otbooking.getHin().getHinNo() %></td>
 <td><%=otbooking.getHin().getPFirstName() %></td>
 <%String ageOfbokedPatient="-";
   String genderOfbokedPatient="-";
   if(otbooking.getHin().getAge()!=null){
	   ageOfbokedPatient=otbooking.getHin().getAge();
   }
   if(otbooking.getHin().getSex()!=null){
	   genderOfbokedPatient=otbooking.getHin().getSex().getAdministrativeSexName();
   }
   String admRequired="";
   Date AdmDate=new Date();
   if(otbooking.getVisit()!=null){
   AdmDate=HMSUtil.getAdmissionDate("OP",otbooking.getVisit().getId());
   admRequired=HMSUtil.getAdmissionRequiredInfo("OP",otbooking.getVisit().getId());
   }else if(otbooking.getInpatient()!=null){
	   AdmDate=HMSUtil.getAdmissionDate("IP",otbooking.getInpatient().getId());
	   admRequired=HMSUtil.getAdmissionRequiredInfo("IP",otbooking.getInpatient().getId());
   }
 %>
 <td><%=ageOfbokedPatient.concat("/").concat(genderOfbokedPatient) %></td>
 <td><%=otbooking.getChargeCode().getChargeCodeName() %></td>
 
 <%if(otbooking.getInpatient()!=null){ %>
 <td><%=otbooking.getInpatient().getDoctor().getFirstName() %></td>
 <%}else{ %>
 <td>-</td>
 <%} %>
 <td><%=otbooking.getOpdSurseryHeader().getPacStatus()!=null?otbooking.getOpdSurseryHeader().getPacStatus():"-" %></td>
 <td>-</td>
 <td><%=admRequired %></td>
 <td>-</td>
 
 <td>
 <input type="text" 
 value="<%=HMSUtil.convertDateToStringWithoutTime(otbooking.getSurgeryDate()) %>" 
 name="surgerydate" id="surgerydate<%=k %>" />
 <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate2%>',document.opSurgeryPlanning.surgerydate<%=k %>,event);" />
 </td>
 
 <td>
 <input type="checkbox" value="cancel" id="PresstatusId<%=k %>" name="status" onclick="setStatusPresc('<%=k %>');" />
<input type="hidden" value="n" name="canPrescStatus" id="canPrescStatId<%=k %>"  />
<input type="hidden" value="<%=otbooking.getId() %>" name="detailPrescId" id="detailId<%=k %>"  />
 
 </td>
 <!-- <td><input type="checkbox" name="checkForUpdate" id="checkForUpdateId"  /></td> -->
 </tr>
 <%k++;} %>
 </table>
 <div class="clear"></div>
  <div class="clear"></div>
 <input type="button" value="update" onclick="submitForm('opSurgeryPlanning','ot?method=updateForOtBooking&hinId=<%=hinId %>');" />
<div class="clear"></div>
 <div class="clear"></div>
<div id="BooingDetailsDiv"></div>
<h4>Procedure Details</h4>
<div class="clear"></div>
<table>
 <tr>
 <th>Procedure</th>
 <th>PAC Status</th>
 <!-- <th>Select</th> -->
 <%int i=1; %>
<!--  <th>Surgery date</th>
 <th>Procedure</th>
 <th>Cancel</th>
 --><!--  <th>Update</th> -->
 </tr>
<tr>
<td><label><input type="text"  name="proscedureName<%=i%>" id="proscedureName<%=i%>" onblur="getProcedureId(this.value,<%=i %>)" /> </label>
		
		
		 <div id="ac2update3<%=i %>" style=" display:none; " class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('proscedureName<%=i %>','ac2update3<%=i %>','ot?method=getInvestigationListForRequestionForIP',{parameters:'requiredField=proscedureName<%=i %>'});
			</script>
		<input type="hidden" name="procedureId<%=i %>" id="procedureId<%=i %>"	value="" /> 
		
		</td>
		<td><label>
		<select name="pacstatus<%=i%>" id="pacstatus<%=i%>">
		<option value="0">select</option>
		<option value="Pending">Pending</option>
		<option value="Cleared">Clear</option>
		<option value="Not Fit">Not Fit</option>
		</select>
		
		
		<td><label><input type="hidden" checked="checked" class="smalll" value="1" name="surgeryradio<%=i%>" id="surgeryradio<%=i%>" /></label>
		<%-- <input type="hidden" name="<%=INPATIENT_ID %><%=i %>" value="<%=inpatient.getId() %>" validate="inpatientId,int,no" /> --%>
		<input type="hidden" name="<%=HIN_ID %><%=i %>" value="<%=hinId%>" validate="hinId,int,no"/></td>
</tr>

 </table>
 <input type="hidden" name="procCount" value="<%=i %>" id="procCount" />
 <div class="clear"></div>
 <label>Admission Required</label>
<input type="hidden" id="arnameId" name="arname" value="n"   />
<%-- <%if(Ward!=null && !Ward.equals("-")){ %> --%>
<input type="checkbox" id="areqId" name="aReq" onclick="checkForAdmission()"   />
<%-- <%}else{ %>
<input type="checkbox" id="areqId" name="aReq" onclick="checkForAdmission()"  />
<%} %> --%>
<div id="AdmDiv" style="display: none;">
<label>Admission Date</label>
<input
	type="text" name="AdmDate" class="date" id="AdmDateId"
	value="<%=currentDate2 %>" maxlength="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onclick="setdate('<%=currentDate2%>',document.opSurgeryPlanning.AdmDate,event);" />
	<label>Ward</label>
	<select name="ward" id="wardId">
	<option value="0">Select</option>
	<%for(MasDepartment dept:deptList){ %>
	<option value="<%=dept.getId()%>"><%=dept.getDepartmentName() %></option>
	<%} %>
	</select>
	
</div>
		
 <div class="clear"></div>
 
 
<div class="paddingTop40"></div>
<input name="Submit" type="button" align="right" class="button" value="Save"
	onclick="submitSurgryRequisition();" />
<input type="reset" class="button" name="reset" value="reset" onclick="submitFormForButton('inpatientSurgeryRequisition','opd?method=showSurgeryRequisitionJspFromPatientList1');"/>
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('inpatientSurgeryRequisition','ipd?method=showPatientListJsp');"/>
 

</form>