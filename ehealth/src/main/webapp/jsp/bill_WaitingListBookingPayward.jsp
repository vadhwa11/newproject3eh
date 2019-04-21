<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="waitingListBookingPayward" method="post" action="">
<%
	  Map<String,Object> map = new HashMap<String,Object>();
	  

	  if (request.getAttribute("map") != null) {
	  	map = (Map<String,Object>) request.getAttribute("map");
	  }
	  
	List<Transfer> transferList = new ArrayList<Transfer>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<OpdPatientDetails> opdPatientDetailList = new ArrayList<OpdPatientDetails>();
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List newList = new ArrayList();
	
	if(map.get("patientList")!=null){
		patientList = (List<Patient>)map.get("patientList");
		}
	if(map.get("transferList")!=null){
		transferList = (List<Transfer>)map.get("transferList");
		}
	if(map.get("opdPatientDetailList")!=null){
		opdPatientDetailList = (List<OpdPatientDetails>)map.get("opdPatientDetailList");
		}
	if(map.get("inpatientList")!=null){
		inpatientList = (List<Inpatient>)map.get("inpatientList");
		}
	  String message = "";
	  if(map.get("message") != null){
	  	message = (String)map.get("message");
  	  }
	 
%>

<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
%>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Waiting List of Booking Payward</h2>
</div>
<!-- <div class="clear"></div>
<div class="Block">
<h4>Payward Type</h4>
<select>
 <option value="both" selected="selected">Both</option>
<option value="1">Out Patient</option>
<option value="2">In Patient</option>
</select>
</div> -->
<div class="clear"></div>
<div class="Block">
<label>UHID</label>
<input type="text" name="uhid" id="uhid" />
<label >Patient Name</label>
<input type="text" name="patientName" id="patientName" />
<label >Mobile No</label>
<input type="text"  name="mobileNo" id="mobileNo" />
<label >IP No</label>
<input type="text"  name="ipNo" id="ipNo"/>
<div class="clear"></div>
<input type="button" class="button" id="search" name="search" value="Search" onClick="submitForm('waitingListBookingPayward','/hms/hms/billing?method=showBillWaitingListBookingPawardJsp');" />
<div class="clear"></div>
</div>
<%
 if(transferList.size()>0 ||  opdPatientDetailList.size()>0 || inpatientList.size()>0){
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	id="paymentDetails">

	<tr >
		<th scope="col">UHID</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Age</th>
		<th scope="col">Gender</th>
		<th scope="col">IP No</th>
		<th scope="col">Mobile No</th>
		<th scope="col">Ward</th>
		<th scope="col">Requested By</th>
	</tr>
	<% 
	for(OpdPatientDetails opdPatientDetails:opdPatientDetailList){
	%>
	<tr style="cursor: pointer;" onclick="submitForm('waitingListBookingPayward','/hms/hms/billing?method=bookingPayward&opdDetailsid=<%=opdPatientDetails.getId()%>');">

	<td><%=opdPatientDetails.getVisit().getHin().getHinNo() %></td>
	<td><%=opdPatientDetails.getVisit().getHin().getPFirstName() %></td>
	<td><%=opdPatientDetails.getVisit().getHin().getAge() %></td>
	<td><%=opdPatientDetails.getVisit().getHin().getSex()!=null?opdPatientDetails.getVisit().getHin().getSex().getAdministrativeSexName():"" %></td>
	<td>-</td>
	<td><%=opdPatientDetails.getVisit().getHin().getMobileNumber()!=null?opdPatientDetails.getVisit().getHin().getMobileNumber():"" %></td>
	<td><%=opdPatientDetails.getReferedDepartment()!=null?opdPatientDetails.getReferedDepartment().getDepartmentName():""%></td>
	<td><%=opdPatientDetails.getEmployee()!=null?opdPatientDetails.getEmployee().getEmployeeName():""%></td>
	</tr> 
	<%} %>
	<% 
	for(Transfer pat: transferList){
	%>
	<tr style="cursor: pointer;" onclick="submitForm('waitingListBookingPayward','/hms/hms/billing?method=bookingPayward&transferId=<%=pat.getId()%>');">
	<td><%=pat.getHin().getHinNo() %></td>
	<td><%=pat.getHin().getPFirstName() %></td>
	<td><%=pat.getHin().getAge() %></td>
	<td><%=pat.getHin().getSex().getAdministrativeSexCode() %></td>
	<td><%=pat.getAdNo() %></td>
	<td><%=pat.getHin().getMobileNumber() != null?pat.getHin().getMobileNumber():"" %></td>
	<td><%=pat.getFromWard().getDepartmentType().getDepartmentTypeName() %></td>
	<td><%=pat.getInpatient().getDoctor()!=null?pat.getInpatient().getDoctor().getEmployeeName():""%></td>
	</tr> 
	<%} %>
	
	<% 
	for(Inpatient inpatient: inpatientList){
	%>
	<tr style="cursor: pointer;" onclick="submitForm('waitingListBookingPayward','/hms/hms/billing?method=bookingPayward&inpatientId=<%=inpatient.getId()%>');">
	<td><%=inpatient.getHin().getHinNo() %></td>
	<td><%=inpatient.getHin().getPFirstName() %></td>
	<td><%=inpatient.getHin().getAge() %></td>
	<td><%=inpatient.getHin().getSex().getAdministrativeSexCode() %></td>
	<td><%=inpatient.getAdNo() %></td>
	<td><%=inpatient.getHin().getMobileNumber() != null?inpatient.getHin().getMobileNumber():"" %></td>
	<td><%=inpatient.getDepartment().getDepartmentType().getDepartmentTypeName() %></td>
	<td><%=inpatient.getDoctor()!=null?inpatient.getDoctor().getEmployeeName():""%></td>
	</tr> 
	<%} %>
</table>
<%}else {%>
<h4>No Record Found</h4>
<%} %>
<div class="clear"></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>






