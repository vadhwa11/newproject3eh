<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>

<script>
<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<%
	List<Patient> patientList=new ArrayList<Patient>();
 	Map<String, Object> map = new HashMap<String, Object>(); 
 	String message = "";
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}  	
	if(map.get("patientList")!=null){ 
		patientList = (List<Patient>)map.get("patientList"); 	
	}   
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}  
%>

<!--Block One Starts-->
<form name="searchPatientAdvance" action="" method="post">

	<div class="clear"></div>
	<div class="titleBg">
		<h2>Patient Advance</h2>
	</div>
	<div class="clear"></div>

	<div class="Block">

	<label>UHID</label>
	 <input type="text" name="hinNo" /> 
	 <label>Patient Name</label>
	  <input type="text" name="patientName" /> <label>Mobile</label>
		<input type="text" name="mobileNo" />
		<div class="clear"></div>


		<input type="button" name="search" value="Search" class="button"
			onclick="submitForm('searchPatientAdvance','/hms/hms/opBilling?method=showPatientAdvanceJsp')" />

		<div class="clear"></div>
		</div>
		<div id="pageNavPosition"></div>
		<%
	if(patientList.size() > 0){
%>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">

			<tr>
				<th scope="col">UHID</th>
				<th scope="col">Patient Name</th>
				<th scope="col">Mobile No</th>
				<th scope="col">Gender</th>
			</tr>
		<tbody id="tableData">
			<%
	
		for(Patient patient : patientList){
	%>
			<tr style="cursor: pointer;"
				onclick="submitForm('searchPatientAdvance','/hms/hms/opBilling?method=getPatientDetailsForPatientAdvance&uhid=<%=patient.getHinNo()%>')">
				<%
				String pFirstName="";
				String pLastName="";
				String pMiddileName="";
				String mobileNo="";
				String gender="";
				if(patient.getPFirstName() !=null){
					pFirstName=patient.getPFirstName();
				}
				if(patient.getPLastName()!=null){
					pLastName=patient.getPLastName();
				}
				if(patient.getPMiddleName()!=null){
					pMiddileName=patient.getPMiddleName();
				}
				if(patient.getMobileNumber()!=null){
					mobileNo=patient.getMobileNumber();
				}
				if(patient.getSex()!=null){
					gender=patient.getSex().getAdministrativeSexName();
				} 
				%>
				<td><%=patient.getHinNo()%></td>
				<td><%=pFirstName+" "+pMiddileName+" "+pLastName%></td>
				<td><%=mobileNo%></td>
				<td><%=gender%></td>
			</tr>

			<%} %>
			</tbody>

		</table>
		<%}else{ %>
		<h4>No Record Found</h4>
		<%} %>


		<div class="clear"></div>
	
	
<script>
	var pager = new Pager('tableData',10);
	pager.init();
	pager.showPageNav('pager', 'pageNavPosition');
	pager.showPage(1);


</script>
 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>

