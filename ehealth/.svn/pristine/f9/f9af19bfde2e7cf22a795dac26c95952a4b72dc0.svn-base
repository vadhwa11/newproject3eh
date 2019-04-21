<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MlcCase"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.InpatientDocument"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="java.text.SimpleDateFormat"%>

<%

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

Map<String,Object> map = new HashMap<String,Object>();
	String detailId ="";
	String parentId ="";
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
	List<Visit> visitList = new ArrayList<Visit>();
	List<Inpatient> inPatientList = new ArrayList<Inpatient>();

	if(map.get("visitList") != null)	{
		visitList = (List<Visit>)map.get("visitList");
	}
	if(map.get("inPatientList") != null)	{
		inPatientList = (List<Inpatient>)map.get("inPatientList");
	}
 	if(inPatientList.size() >0 ){
		Inpatient inpatient=inPatientList.get(0);
%>

<div class="clear"></div>
<h4>Admission Details</h4>
<div class="clear"></div>
<div class="Block"><label><%=prop.getProperty("com.jkt.hms.ipd_no") %>:</label> <label class="value"><%=inpatient.getAdNo()%></label>

<label>Patient Name</label> <label class="value">
<%
String patientName ="";
if(inpatient.getHin().getPFirstName()!=null)
{
	patientName = inpatient.getHin().getPFirstName();

}
if(inpatient.getHin().getPMiddleName()!=null)
{
	patientName = patientName+" "+inpatient.getHin().getPMiddleName();

}
if(inpatient.getHin().getPLastName()!=null)
{
	patientName = patientName+" "+inpatient.getHin().getPLastName();

}
%>
<%=patientName%></label>

<label>Ward </label> <label class="value"><%=inpatient.getDepartment().getDepartmentName()%></label>

<div class="clear"></div>

<label>Admission Date</label> <%if(inpatient.getDateOfAddmission() !=null){ %>
<%String disDate ="";
			SimpleDateFormat formatterIn2 = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat formatterOut2 = new  SimpleDateFormat("dd/MM/yyyy");
			 disDate=formatterOut2.format(formatterIn2.parse(""+inpatient.getDateOfAddmission()));
			 %> <label class="value"><%=disDate%></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Admission Time</label> <%if(inpatient.getTimeOfAddmission() !=null){ %>
<label class="value"><%=inpatient.getTimeOfAddmission()%></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Admission Type</label> <%if(inpatient.getAdmissionType() !=null){ %>
<label class="value"><%=inpatient.getAdmissionType().getAdmissionTypeName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>

<label>Condition</label> <%if(inpatient.getAdmissionType() !=null){ %> <label
	class="value"><%=inpatient.getPatientCondition()%></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Age</label> <%if(inpatient.getAge() !=null){ %>
<label class="value"><%=inpatient.getAge()%></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Transfer from </label> <%if(inpatient.getTransFrom() !=null   ){
					if(!inpatient.getTransFrom().equals("")){%> <label class="value"><%=inpatient.getTransFrom()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <%}else{ %> <label
	class="value">-</label> <%} %>

<div class="clear"></div>

<label>Last <%=prop.getProperty("com.jkt.hms.ipd_no") %>:</label> <%if(inpatient.getPreviousAdNo() !=null){
				if(!inpatient.getPreviousAdNo().equals("")){
				%> <label class="value"><%=inpatient.getPreviousAdNo()%></label> <%}else{ %>
<label class="value">-</label> <%} %> <%}else{ %> <label class="value">-</label>
<%} %> <label>Admission Advised </label>
<label class="value">
<%String doctName="";
if(inpatient.getDoctor().getFirstName()!=null && !inpatient.getDoctor().getFirstName().equals(""))
{
	doctName =inpatient.getDoctor().getFirstName();
}
if(inpatient.getDoctor().getMiddleName()!=null && !inpatient.getDoctor().getMiddleName().equals(""))
{
	doctName =doctName+" "+inpatient.getDoctor().getMiddleName();
}
if(inpatient.getDoctor().getLastName()!=null && !inpatient.getDoctor().getLastName().equals(""))
{
	doctName =doctName+" "+inpatient.getDoctor().getLastName();
}

%>
<%=doctName%>
</label>
<label>Diet</label> <label class="value">
<%if(inpatient.getDiet()!=null && !inpatient.getDiet().equals("")){ %>
<%=inpatient.getDiet().getDietName()%>
<%}else{ %>
-<%} %>
</label>

<!-- //--Anand (11-02-2010)---//
 <label>VIP</label>
			<%
			if(inpatient.getVip() !=null){
			if(inpatient.getVip().equalsIgnoreCase("y")){ %>
<label class="value">Yes</label>
			<%}else{ %>
<label class="value">No</label>
			<%}}
			else{%>
<label class="value">No</label>
			<%} %>

<div class="clear"></div>

<label>H Staff</label>
			<%if(inpatient.getStaffSlNo() !=null){ %>
<label class="value">Yes</label>
			<%}else{ %>
<label class="value">No</label>
			<%} %>

<label>HSR Receipt No.</label>
			<%if(inpatient.getHsrReceiptNo() !=null ){
				if(!inpatient.getHsrReceiptNo().equals("")){
				%>
<label class="value"><%=inpatient.getHsrReceiptNo()%></label>
				<%}else{ %>
<label class="value">-</label>
				<%} %>
			<%}else{ %>
<label class="value">-</label>
			<%} %>

<label>HSR Amount</label>
			<%if(inpatient.getHsrAmount() !=null ){ %>
<label class="value"><%=inpatient.getHsrAmount()%></label>
			<%}else{ %>
<label class="value">-</label>
			<%} %>

<div class="clear"></div>

<label>Return FRW </label>
<label class="value">-</label>-->
<div class="clear"></div>
<label>Remarks</label> <%if(inpatient.getRemarks() !=null && !inpatient.getRemarks().equals("")){ %>
<label class="value"><%=inpatient.getRemarks()%></label> <%}else{ %> <label
	class="value">-</label> <%} %> <!--  Anand Gupta(11-02-2010)
<label>Doc attached </label>
			<% String docInit ="";
			Set<InpatientDocument> set=new HashSet<InpatientDocument>();
			set= (Set<InpatientDocument>)inpatient.getInpatientDocuments();
			for(InpatientDocument inpatientDocument :set){
				if(inpatientDocument.getInpatient().getId()==inpatient.getId()){
					docInit =docInit+inpatientDocument.getDocument().getDocumentName()+", ";
				}
			}
			if(docInit.equals("")){
				docInit ="-";
			}
			%>

<label class="value"><%=docInit%></label> -->
<div class="clear"></div>
<label>Diagnosis </label> <% String diagnosis ="";
			if(inpatient.getInitDiagnosis() !=null)
			diagnosis =inpatient.getInitDiagnosis();
			%> <label class="valueAuto"> <%=diagnosis%></label> <%}%>
<div class="clear"></div>
</div>