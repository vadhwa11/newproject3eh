<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* nursingDetails.jsp  
* Purpose of the JSP -  This is for Nursing Details.
* @author  Vikas
* @author  Deepali
* Create Date: 31st Jan,2008 
* Revision Date:      
* Revision By: 
* @version 1.3
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<%	


Map map = new HashMap();
String includedJsp="";
if(request.getAttribute("map") != null){
map = (Map) request.getAttribute("map");

}

List inPatientDetailList = new ArrayList();
List clinicalDetailList= new ArrayList();


try{

if(map.get("takeSetFromSessionInJsp")!=null)
{
String takeSetFromSessionInJsp=(String)map.get("takeSetFromSessionInJsp");
if(takeSetFromSessionInJsp.equals("false"))
{
clinicalDetailList=(List)map.get("clinicalDetailList");
session.setAttribute("clinicalDetailList",clinicalDetailList);
}else{
clinicalDetailList=(List) session.getAttribute("clinicalDetailList");
}
}


inPatientDetailList=(List)session.getAttribute("inPatientDetailList");
//clinicalDetailsList=(List)map.get("clinicalDetailList");




}catch(Exception e){
}

int ipdClinicalId=(Integer)map.get("ipdClinicalId");		
String userName = "";
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
String admissionNumber=null;
if(inPatientDetailList != null)
{
Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
int hinId=inPatientDetail.getHin().getId();
String patientName=inPatientDetail.getHin().getPFirstName()+inPatientDetail.getHin().getPMiddleName()+inPatientDetail.getHin().getPLastName();
String consultantName=inPatientDetail.getDoctor().getFirstName()+inPatientDetail.getDoctor().getMiddleName()+inPatientDetail.getDoctor().getLastName();
admissionNumber=inPatientDetail.getAdNo();
session.setAttribute("admissionNumber",admissionNumber);
MasDiagnosisConclusion masDiagnosisConclusion=(MasDiagnosisConclusion)inPatientDetail.getDiagnosis();
%>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<br />
<%
if(map.get("message") != null){
String message = (String)map.get("message");
out.println(message);
}
%>
<form name="nursingDetails" method="post" action="">
<div class="Block"><label>Pateint Name</label> <label
	class="value"> <%= patientName %></label> <label class="medium">Service
No.</label> <label class="valueMedium"> <%=inPatientDetail.getHin().getServiceNo() %></label>

<label class="medium">IP No.</label> <label class="valueMedium">
<%=inPatientDetail.getAdNo() %></label> <label class="medium">Ward Name</label>
<label class="valueMedium"> <%=inPatientDetail.getDepartment().getDepartmentName() %></label>

<div class="clear"></div>

<label>Age</label> <label class="value"> <%=inPatientDetail.getAge() %></label>

<label class="medium">Sex</label> <label class="valueMedium"> <%=inPatientDetail.getHin().getSex().getAdministrativeSexName() %></label>

<label class="medium">Rank</label> <label class="valueMedium">
1212</label> <label class="medium">Unit</label> <label class="valueMedium">
12345</label>

<div class="clear"></div>

<label>Consultant</label> <label class="value"><%=consultantName %></label>

<label class="medium">Diagnosis</label> <%
if(masDiagnosisConclusion != null )
{
%> <label class="valueAuto"><%=inPatientDetail.getDiagnosis().getDiagnosisConclusionName() %></label>
<%
}else{
%> <label class="valueAuto"></label> <%	
}
%> <%
}
%>

<div class="clear"></div>
</div>
<div class="clear"></div>

<div id="searchbar">
<h4>Nursing Care Details</h4>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>


<table>
	<tr>
		<th>Patient Care</th>
		<th>Status</th>
		<th>Remarks</th>
	</tr>
	<% 
int i=0;
if(clinicalDetailList!=null)
{
Iterator listIterator=clinicalDetailList.iterator();
while (listIterator.hasNext()){
NursingcareSetup nursingCareSetupList=(NursingcareSetup) listIterator.next();
int id= nursingCareSetupList.getNursing().getId();
String careName= nursingCareSetupList.getNursing().getNursingName();


%>
	<tr>
		<td><%= careName%></td>

		<td><input type="checkbox" name="id<%=i%>" id="id<%=i %>"
			value="<%=careName %>" class="radioCheck" /></td>
		<td><input type="text" name="remarks<%=i%>" id="remarks<%=i%>"
			value=""></td>
	</tr>
	<%
i++;
}
}

%>
	<tr>
		<td>Needle Pricked By</td>

		<td><input type="checkbox" name="needlePricked"
			value="Needle Pricked" class="radioCheck" /></td>
		<td><input type="text" name="remarks"></td>
	</tr>

	<tr>
		<td>SIL</td>

		<td><input type="radio" name="radioValue" value="SIL"
			class="radioCheck" /></td>
		<td><input type="text" name="sil"></td>
	</tr>
	<tr>
		<td>DIL</td>

		<td><input type="radio" name="radioValue" value="DIL"
			class="radioCheck" /></td>
		<td><input type="text" name="dil"></td>
	</tr>
</table>
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" class="button" value="Submit" align="left"
	onClick="submitForm('nursingDetails','ipd?method=submitNursingDetails','validateCare');" />
<input type="button" class="button" value="Clinical Details"
	align="left"
	onClick="submitForm('nursingDetails','ipd?method=showClinicalDetailsJsp');" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="ipdClinicalId" value="<%=ipdClinicalId %>" />
<input type="hidden" name="counter" id="counter" value="<%=i %>" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<script>

function validateCare(){
var counter=document.getElementById('counter').value
//alert(counter)

for(var i = 0; i < counter; i++){
//alert("i-- "+i)
remVal = eval('document.nursingDetails.remarks' + i + '.value')
//alert(remVal);
//var cares=document.getElementById('id'+<%=i%>).value
//alert(cares)
if(remVal != ""){
careVal=eval('document.nursingDetails.id' + i + '.checked ')
//alert(careVal)
if(careVal == false){

alert("Please select the care.");
return false;      
}
}
}
return true;

}

</script>
