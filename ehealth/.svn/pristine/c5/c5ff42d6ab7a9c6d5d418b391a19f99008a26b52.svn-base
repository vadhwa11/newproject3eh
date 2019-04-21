<%@page import="jkt.hms.masters.business.BlPaywardBooking"%>
<%@page import="jkt.hms.masters.business.BlReceiptHeader"%>
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

<form name="renewalSearch" method="post" action="">
<%
	  Map<String,Object> map = new HashMap<String,Object>();
List<BlPaywardBooking> blPaywardBookingList=new ArrayList<BlPaywardBooking>();


	  if (request.getAttribute("map") != null) {
	  	map = (Map<String,Object>) request.getAttribute("map");
	  }
	  
	List<Transfer> transferList = new ArrayList<Transfer>();
	List<Patient> patientList = new ArrayList<Patient>();
	List newList = new ArrayList();
	List<BlReceiptHeader> blhdrList = new ArrayList<BlReceiptHeader>();
	if(map.get("patientList")!=null){
		patientList = (List<Patient>)map.get("patientList");
		}
	if(map.get("blhdrList")!=null){
		blhdrList = (List<BlReceiptHeader>)map.get("blhdrList");
		}
	if(map.get("transferList")!=null){
		transferList = (List<Transfer>)map.get("transferList");
		}
	if(map.get("blPaywardBookingList")!=null){
		blPaywardBookingList = (List<BlPaywardBooking>)map.get("blPaywardBookingList");
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
<h2>Waiting List of Allotment for Pay Ward</h2>
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
<label class="auto">UHID</label>
<input type="text" class="" name="uhid" id="uhid" />
<label class="auto">Patient Name</label>
<input type="text" class="" name="patientName" id="patientName" />
<label class="auto">Mobile No</label>
<input type="text" class="" name="mobileNo" id="mobileNo" />
<label class="auto" >IP No</label>
<input type="text" class="" name="ipNo" id="ipNo"/>
<div class="clear"></div>
<input type="button" class="button" id="search" name="search" value="Search" onClick="submitForm('renewalSearch','/hms/hms/billing?method=showBillWaitingListRenewalPaywardJsp');" />
<div class="clear"></div>
</div>
<%
 if(blPaywardBookingList.size()>0){
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
	for(BlPaywardBooking blPaywardBooking:blPaywardBookingList){
	%>
	<tr style="cursor: pointer;" onclick="submitForm('renewalSearch','/hms/hms/billing?method=renewalPayward&bookingId=<%=blPaywardBooking.getId()%>');">

	<td><%=blPaywardBooking.getHin().getHinNo() %></td>
	<td><%=blPaywardBooking.getHin().getPFirstName() %></td>
	<td><%=blPaywardBooking.getHin().getAge() %></td>
	<td><%=blPaywardBooking.getHin().getSex().getAdministrativeSexName() %></td>
	<td><%=blPaywardBooking.getTransfer()!=null?blPaywardBooking.getTransfer().getAdNo():"" %></td>
	<td><%=blPaywardBooking.getHin().getMobileNumber() %></td>
	<td><%=blPaywardBooking.getTransfer()!=null?blPaywardBooking.getTransfer().getFromWard().getDepartmentName():"" %></td>
	<td>
	<%if(blPaywardBooking.getTransfer()!=null && blPaywardBooking.getTransfer().getInpatient().getDoctor()!=null) {%>
	<%=blPaywardBooking.getTransfer().getInpatient().getDoctor().getEmployeeName() %>
	<%}else if(blPaywardBooking.getOpdPatientDetails()!=null && blPaywardBooking.getOpdPatientDetails().getEmployee()!=null) { %>
		<%=blPaywardBooking.getOpdPatientDetails().getEmployee().getEmployeeName() %>
	<%}%>
	</td>
	</tr> 
	<%} %>
</table>
<%}else {%>
<h4>No Record Found</h4>
<%} %>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	




