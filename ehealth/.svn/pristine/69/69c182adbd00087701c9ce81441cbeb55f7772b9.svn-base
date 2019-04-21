
<%@page import="jkt.hms.masters.business.AmbulanceRegister"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">

	</script>
<%

	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}




	List<Inpatient> inPatientList = new ArrayList<Inpatient>();
	List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
	List<AmbulanceRegister>AmbulanceRegisterList=new ArrayList<AmbulanceRegister>();
	/*  if(map.get("dgOrderhdList") != null)
	{
		dgOrderhdList=(List)map.get("dgOrderhdList");
	} */
	 if(map.get("dgOrderhdList")!=null){
		 dgOrderhdList = (List<DgOrderhd>)map.get("dgOrderhdList");
		}
	
	if(map.get("inPatientList")!=null){
		inPatientList = (List<Inpatient>)map.get("inPatientList");
		}
	if(map.get("AmbulanceRegisterList")!=null){
		AmbulanceRegisterList = (List<AmbulanceRegister>)map.get("AmbulanceRegisterList");
		}
	%>

<div class="titleBg">
<h2>Bill Services(IP)</h2>
</div>
<form name="ipBillSearch" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label>UHID</label>
<input type="text" class="" name="uhid" id="uhid" />
<label>IP No</label>
<input type="text" class="" name="ipNo" id="ipNo"/>
<label>Order Id</label>
<input type="text" class=""  name="order_no" id="order_no"/>
<div class="clear"></div>
<label>Lab / Radio / ECG</label>
<input type="radio" class="inputRadiobutton"  name="amb" id="labId" onclick="submitData();"/>
<label>Ambulance </label>
<input type="radio" class="inputRadiobutton"  name="amb" id="ambId" onclick="submitData();"/>

<label>Procedure</label>
<input type="radio" class="inputRadiobutton"  name="amb" id="procId" onclick="submitData();"/>


<div class="clear"></div>

<input type="button" class="button" id="search" name="search" value="Search" onClick="submitForm('ipBillSearch','/hms/hms/billing?method=showIPBillingSearchJsp&flag=chargeSlip');" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<%
	if(inPatientList.size() > 0){
%>
<%--<div id="chargeSlipMainDiv" style="display: none;"> //added by govind 27-07-2017--%>
<div id="chargeSlipMainDiv" >
<table width="100%" border="0" cellpadding="0" cellspacing="0" id="paymentDetails">
	<tr >
		<th scope="col">UHID</th>
		<th scope="col">Patient Name</th>
		<th scope="col">IP No</th>
		<th scope="col">Referred By</th>
		<th scope="col">Hospital Name</th>
	</tr>
	<%
		for(Inpatient obj : inPatientList){			
	%>
	<tr onclick="submitForm('ipBillSearch','/hms/hms/billing?method=getPatientDetails&uhid=<%=obj.getHinNo() %>&ipNo=<%=obj.getId()%>');">
		
	<td><%=obj.getHinNo() %></td>
	<td><%=obj.getHin().getPFirstName()%></td>
	<td><%=obj.getAdNo() %></td>
	<td><%=obj.getDoctor().getEmployeeName()%></td>
	<td><%=obj.getHospital().getHospitalName() %></td>
	</tr>
	
	<%} %>

</table>
<%}else{ %>
<h4>No Record Found</h4>
<%} %>
</div>
<div id="ambulaceId" style="display:none; ">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	id="paymentDetails">

	<tr >
		<th scope="col">UHID22</th>
		<th scope="col">Patient Name</th>
		<th scope="col">IP No</th>
		<th scope="col">Referred By</th>
		<th scope="col">Hospital Name</th>
	</tr>
	<%
	if(AmbulanceRegisterList.size()>0){
		for(AmbulanceRegister obj : AmbulanceRegisterList){			
	%>
	<tr onclick="submitForm('ipBillSearch','/hms/hms/billing?method=getPatientDetails&flag1=amb&uhid=<%=obj.getInpatient().getHinNo() %>&ipNo=<%=obj.getInpatient().getId()%>');">
		
	<td><%=obj.getInpatient().getHinNo() %></td>
	<td><%=obj.getInpatient().getHin().getPFirstName()%></td>
	<td><%=obj.getInpatient().getAdNo() %></td>
	<td><%=obj.getInpatient().getDoctor().getEmployeeName()%></td>
	<td><%=obj.getInpatient().getHospital().getHospitalName() %></td>
	</tr>
	
	<%} }else{%>
	<h4>No Record Found</h4>
	<%} %>

</table>

</div>

<div class="clear"></div>
</div>
<script>
function submitData(){
	if(document.getElementById('ambId').checked==true){
		document.getElementById('chargeSlipMainDiv').style.display="none";
		document.getElementById('ambulaceId').style.display="inline";
	}else if(document.getElementById('labId').checked==true){
		document.getElementById('ambulaceId').style.display="none";
		document.getElementById('chargeSlipMainDiv').style.display="inline";
	}
	else if(document.getElementById('procId').checked==true){
		document.getElementById('ambulaceId').style.display="none";
		document.getElementById('chargeSlipMainDiv').style.display="none";
	}
//	submitProtoAjaxWithDivName('','','')
}

</script>
</form>

