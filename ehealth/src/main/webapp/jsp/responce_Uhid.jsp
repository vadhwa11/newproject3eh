
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
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
		String userName = "";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String currentTime = (String)utilMap.get("currentTime");
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		Map<String, Object> map=new HashMap<String, Object>();
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
		
		List<PatientWiseMlc> patWise = new ArrayList<PatientWiseMlc>();
		if(map.get("patWise")!=null){
			patWise=(List<PatientWiseMlc>)map.get("patWise");
		}
		String CurrentDate=date+"/"+month+"/"+year;
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		

</script>

<div id="divTest">
<form name="mlcSearch" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">

<label><span>*</span> UHID</label>
	<%   Set<Integer> sett=new HashSet<Integer>();  
	if(patWise.size()>0){
 		for(PatientWiseMlc mlcDetai1l:patWise){ 
  if(mlcDetai1l.getHin()!=null &&  sett.add(mlcDetai1l.getOpdPatientDetail().getId())){
	%> 
<input name="uhin" id="uhin" validate="UHID,string,yes" value="<%=mlcDetai1l.getHin().getHinNo()%>"/>
<%}}}else{%>
<input name="uhin" id="uhin" validate="UHID,string,yes" /> 
	<%	}%>


 <input type="button" value="Search" onclick="submitProtoAjaxWithDivName('mlcSearch','/hms/hms/mlc?method=getUhid','divTest');"/>
<input type="reset" name="Reset"	id="reset"  onclick="submitForm('mlcSearch','/hms/hms/mlc?method=showPatientMlcWaitingList');" />
 </div>
<div class="clear"></div>
</form>
<form name="mlc" method="post">

<div class="Block">


<div id="pageNavPosition"></div>
<table id="tableId">
	<tr><th>S.No</th><th>Patient</th><th>UHIN ID</th><th>OP/IP</th><th>Status</th><th>MLC</th><th></th></tr>
	
<%
Set<Integer> set=new HashSet<Integer>();
   int i=1;
if(patWise.size()>0 ){ %>
<tbody id="tableData">
	<%     
 		for(PatientWiseMlc mlcDetail:patWise){ 
  if(mlcDetail.getHin()!=null &&  set.add(mlcDetail.getOpdPatientDetail().getId())){
	%> 
				<tr >
				
		<%-- 	<tr onclick="submitForm('mlc<%=counter+1%>', 'mlc?method=showExamOfMaleAccusedSexualOffenceJsp')"> --%>
			<td>
				<input type="hidden" name="requestId" value="<%=mlcDetail.getId()%>" />
	
			<%=i%></td>
		
		    <td><%=mlcDetail.getHin()!=null &&  mlcDetail.getHin().getFullName()!=null ? mlcDetail.getHin().getFullName():""%></td>
		<td> <%=mlcDetail.getHin()!=null &&  mlcDetail.getHin().getHinNo()!=null ? mlcDetail.getHin().getHinNo():""%></td>
		
		<td>
		<%if(mlcDetail.getInpatient()!=null){%>
		IP
		<%}else{ %>
		OP
		<%} %>
		</td>
		<%if(mlcDetail.getStatus().equals("y")) {%>
		<td>Pending</td>
		<% }%>
		<td >
	<%-- 	<select id="valueIn<%=i%>">
		<option value="ACCIDENT REGISTER-CUM-WOUND CERTIFICATE">ACCIDENT REGISTER-CUM-WOUND CERTIFICATE</option>
		<option value="EXAMINATION FOR EVIDENCE OF RECENT DELIVERY">EXAMINATION FOR EVIDENCE OF RECENT DELIVERY</option>
		<option value="POST MORTEM DETAILED NOTES">POST MORTEM DETAILED NOTES</option>
		</select> --%>
		<input type="hidden"  name="detailId<%=i%>" id="detailId<%=i%>" value="<%= mlcDetail.getOpdPatientDetail().getId()%>">
		<%if(mlcDetail.getHin()!=null){ %>
		<input type="hidden"  name="uhinId<%=i%>" id="uhinId<%=i%>" value="<%=mlcDetail.getHin().getHinNo()%>">
		<%}else{ %>
			<input type="hidden"  name="uhinId<%=i%>" id="uhinId<%=i%>" value="">
	
		<%} %>
		<select id="valueIn<%=i%>">	
			<option value="">Select</option>
	<%
	
	
	for(PatientWiseMlc mlc:patWise) {
		if(mlc.getOpdPatientDetail().getId().equals(mlcDetail.getOpdPatientDetail().getId())  && (mlc.getStatus().equals("y") || mlc.getStatus().equalsIgnoreCase("AT"))){
	%>

	<option value="<%= mlc.getMlcType().trim()%>"><%= mlc.getMlcType().trim()%></option>
	<%}}%> 
	</select>

		</td>
		<td >
	<input type="button" value="ok" onclick="tdValue(<%=i%>)" />
		</td>
		    </tr>
		  
<%		++i;
 	}  if(mlcDetail.getInpatient()!=null &&  set.add(mlcDetail.getOpdPatientDetail().getId())){
 		%> 
		<tr >
		
<%-- 	<tr onclick="submitForm('mlc<%=counter+1%>', 'mlc?method=showExamOfMaleAccusedSexualOffenceJsp')"> --%>
	<td>
		<input type="hidden" name="requestId" value="<%=mlcDetail.getId()%>" />

	<%=i%></td>

    <td><%=mlcDetail.getInpatient()!=null &&  mlcDetail.getInpatient().getHin().getFullName()!=null ? mlcDetail.getInpatient().getHin().getFullName():""%></td>
<td> <%=mlcDetail.getInpatient()!=null &&  mlcDetail.getInpatient().getHin().getHinNo()!=null ? mlcDetail.getInpatient().getHin().getHinNo():""%></td>
<td>
		IP

		</td>
<%if(mlcDetail.getStatus().equals("y")) {%>
<td>Pending</td>
<% }%>
<td >
<%-- 	<select id="valueIn<%=i%>">
<option value="ACCIDENT REGISTER-CUM-WOUND CERTIFICATE">ACCIDENT REGISTER-CUM-WOUND CERTIFICATE</option>
<option value="EXAMINATION FOR EVIDENCE OF RECENT DELIVERY">EXAMINATION FOR EVIDENCE OF RECENT DELIVERY</option>
<option value="POST MORTEM DETAILED NOTES">POST MORTEM DETAILED NOTES</option>
</select> --%>
<input type="hidden"  name="detailId<%=i%>" id="detailId<%=i%>" value="<%= mlcDetail.getOpdPatientDetail().getId()%>">
<%if(mlcDetail.getInpatient()!=null){ %>
<input type="hidden"  name="uhinId<%=i%>" id="uhinId<%=i%>" value="<%=mlcDetail.getInpatient().getHin().getHinNo()%>">
<%}else{ %>
	<input type="hidden"  name="uhinId<%=i%>" id="uhinId<%=i%>" value="">

<%} %>
<select id="valueIn<%=i%>">	
	<option value="">Select</option>
<%


for(PatientWiseMlc mlc:patWise) {
if(mlc.getOpdPatientDetail().getId().equals(mlcDetail.getOpdPatientDetail().getId())  && (mlc.getStatus().equals("y") || mlc.getStatus().equalsIgnoreCase("AT"))){
%>

<option value="<%= mlc.getMlcType().trim()%>"><%= mlc.getMlcType().trim()%></option>
<%}}%> 
</select>

</td>
<td >
<input type="button" value="ok" onclick="tdValue(<%=i%>)" />
</td>
    </tr>
  
<%		++i;
} 
 		}
 	%> 

 	
 	</tbody>
	</table>
	<%}else{ %>
	No Records Available.
	<%} %>
	</div>

</form>
	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		</script>
 	</div>	
   <div class="clear"></div>

	
	
	<script type="text/javascript">
function tdValue(id) {
//	alert(id);
//	var counter=document.getElementById('counter').value;
	var detailId=document.getElementById('detailId'+id).value;
	var uhinId=document.getElementById('uhinId'+id).value;
	
//	alert(document.getElementById('valueIn'+id).value);
	
//	alert(detailId)
//	if(document.getElementById('valueIn'+id).value.equal())    
	
if(document.getElementById('valueIn'+id).value=='ACCIDENT REGISTER-CUM-WOUND CERTIFICATE'){
	 submitForm('mlc','mlc?method=showAccidentalRegistrationJsp&requestId='+detailId);

}else if(document.getElementById('valueIn'+id).value=='Examintion of a male accused'){

	 submitForm('mlc','mlc?method=showExamOfMaleAccusedSexualOffenceJsp&requestId='+detailId);	
	 
}else if(document.getElementById('valueIn'+id).value=='POSTMORTEM EXAMINATION'){
	 submitForm('mlc','mlc?method=showPostmortemExaminationJsp&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='POST MORTEM DETAILED NOTES'){
	 submitForm('mlc','mlc?method=showPostmortemDetailNotesJsp&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='EXAMINATION OF A FEMALE VICTIM OF SEXUAL ASSAULT'){
	 submitForm('mlc','mlc?method=showExamOfFemaleVictimOfSexualAssaultJsp&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='EXAMINATION OF A VICTIM OF UNNATURAL SEXUAL OFFENCE'){
	 submitForm('mlc','mlc?method=showExamOfVictimOfUnnaturalSexualOffenceJsp&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='EXAMINATION FOR EVIDENCE OF RECENT DELIVERY'){
	 submitForm('mlc','mlc?method=showExamOfEvidenceOfRecentDeliveryJsp&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='TREATMENT / DISCHARGE CERTIFICATE'){
	 submitForm('mlc','mlc?method=showTreatment_Dischargr_JSP&requestId='+detailId+'&uhinId='+uhinId);
}
else if(document.getElementById('valueIn'+id).value=='CERTIFICATE OF DRUNKNESS'){
	 submitForm('mlc','mlc?method=showDunknnessJSP&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='OPINION OF CAUSE OF DEATH'){
	 submitForm('mlc','mlc?method=showCouseOfDeathFinal&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='POSTMORTEM CERTIFICATE'){
	 submitForm('mlc','mlc?method=showPostMartemCertificate&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='EXAMINATION FOR ESTIMATION OF AGE'){
	 submitForm('mlc','mlc?method=showEstimationofAge&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='Chemical Analysis'){
	 submitForm('mlc','mlc?method=showChemicalAnalysis&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='Examination Of Victim Alleged Drugged'){
	 submitForm('mlc','mlc?method=showVictimAllegedDrugged&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='Examination by a Medical Officer'){
	 submitForm('mlc','mlc?method=showMedicalOfficerCertificate&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='Examination by a Specialist Medical Officer/Team'){
	 submitForm('mlc','mlc?method=showExaminationbySMOTTmember&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='DNA Profiling Examination At FSL'){
	 submitForm('mlc','mlc?method=showDNAprofilingexaminationFSL&requestId=='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='Preserved During Postmortem Examination'){
	 submitForm('mlc','mlc?method=showPreserveDuringPostmortem&requestId='+detailId);
}
else if(document.getElementById('valueIn'+id).value=='REFERRING A POSTMORTEM EXAMINATION'){
	 submitForm('mlc','mlc?method=showFormatForReferring');
}
else if(document.getElementById('valueIn'+id).value=='Mortuary Register'){
	 submitForm('mlc','mlc?method=showMortuaryRegisterJsp');
}

	};

</script>
	
	