
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
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
	List<MasInstituteDepartment>deptList=new ArrayList<MasInstituteDepartment>();
	
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
	if(map.get("masDeptList")!=null){
		deptList = (List<MasInstituteDepartment>)map.get("masDeptList");
		}
	System.out.println("inPatientList "+inPatientList.size());
	%>

<div class="titleBg">
<h2>IP Bill Dispensing(Waiting)</h2>
</div>
<div class="clear"></div>

<div class="Block" style="//width:830px;">
<form name="ipBillDispensingSearch" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<label class="auto">UHID</label>
<input type="text" name="uhid" id="uhid" validate="uhid,alphanumeric,no"/>
<label class="auto" >IP No</label>
<input type="text" name="ipNo" id="ipNo" validate="ipno,number,no"/>
<label class="auto">Patient Name</label>
<input type="text" name="patientName" id="patientName" validate="Patient Name,alphanumeric,no"/>
<label class="auto">Ward</label>
<!-- <input type="text" name="wardNo" id="wardNo" validate="Ward No,alphanumeric,no"/> -->
<select name="wardNo" id="wardNo" validate="Ward No,alphanumeric,no">
<option value="0">Select</option>
<%for(MasInstituteDepartment dept:deptList){ %>
<option value="<%=dept.getDepartment().getId()%>"><%=dept.getDepartment().getDepartmentName() %></option>
<%} %>
</select >

<div class="clear"></div>
<div class="clear"></div>
<input type="button" class="button" id="search" name="search" value="Search" onClick="submitForm('ipBillDispensingSearch','/hms/hms/billing?method=showIPBillDispensingJsp');" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<%
	if(inPatientList.size() > 0){
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	id="paymentDetails">

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
	<tr onclick="submitForm('ipBillDispensingSearch','/hms/hms/billing?method=searchPatientForIPBillDispensing&uhid=<%=obj.getHinNo() %>&ipNo=<%=obj.getAdNo()%>');">
	
	
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
<div class="clear"></div>
 

 </form>

