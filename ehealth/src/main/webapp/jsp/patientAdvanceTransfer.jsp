<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<SCRIPT SRC="/hms/jsp/js/ssm.js" language="JavaScript1.2"></SCRIPT>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	
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
	List<Patient> patients=new ArrayList<Patient>();
 	Map<String, Object> map = new HashMap<String, Object>(); 
 	String message = "";
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}  	
	if(map.get("patientList")!=null){ 
		patients = (List<Patient>)map.get("patientList"); 	
	}   
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}  
%>

<!--Block One Starts-->
<form name="searchPatientTransfer" action="" method="post">
	<%
	if(!message.equals("")){
		%>

	<h4>
		<span><%=message %></span>
	</h4>
	<div class="clear"></div>

	<%	}
%>
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
	<%
	if(map.get("inpatientList") != null){
%>
	<script type="text/javascript">
		alert("Patient is admitted.");
	</script>
	<%		
	}
%>
	<div class="clear"></div>
	<div class="titleBg">
		<h2>Patient Advance Transfer</h2>
	</div>
	<div class="clear"></div>

	<div class="Block">

		<label>UHID</label> <input type="text" name="hinNo" /> <label>Patient
			Name</label> <input type="text" name="patientName" /> <label>Mobile</label>
		<input type="text" name="mobileNo" />
		<div class="clear"></div>


		<input type="button" name="search" value="Search" class="button"
			onclick="submitForm('searchPatientTransfer','/hms/hms/opBilling?method=searchPatientForAdvanceTransfer')" />

		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<%
	if(patients.size() > 0){
%>
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			id="paymentDetails">

			<tr>
				<th scope="col">UHID</th>
				<th scope="col">Patient Name</th>
				<th scope="col">Mobile No</th>
				<th scope="col">Gender</th>
			</tr>
			<%
	
		for(Patient patient : patients){
	%>
			<tr style="cursor: pointer;"
				onclick="submitForm('searchPatientTransfer','/hms/hms/opBilling?method=getPatientTransferDetail&uhid=<%=patient.getId()%>')">
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

		</table>
		<%}else{ %>
		<h4>No Record Found</h4>
		<%} %>


		<div class="clear"></div>
	</div>
	  
	<div class="clear"></div>
	<div id="error"></div>
	<script type="text/javascript">
		/* document.getElementById('hinNo').focus(); */
		function chkDate() {
			var err = "";
			var currentDate = new Date(serverdate.substring(6), (serverdate
					.substring(3, 5) - 1), serverdate.substring(0, 2));
			obj1 = document.discountMaster.effectiveDateFrom.value;
			obj2 = document.discountMaster.effectiveDateTo.value;
			fromDate = new Date(obj1.substring(6), (obj1.substring(3, 5) - 1),
					obj1.substring(0, 2));
			toDate = new Date(obj2.substring(6), (obj2.substring(3, 5) - 1),
					obj2.substring(0, 2));
			/*	if(obj1 != ""){
			 if(fromDate>currentDate)
			 err += "From Date should be less than or equal to current date.\n"
			 }*/
			if (obj2 != "") {
				if (toDate < currentDate)
					err += "To Date should be greater than or equal to current date.\n"

			}
			if (obj1 != "" && obj2 != "") {

				if (fromDate > toDate)
					err += "From date should be less than or equal to To Date.\n"
			}
			if (err != "")
				alert(err)
			else
				return true;
		}
	</script>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	

