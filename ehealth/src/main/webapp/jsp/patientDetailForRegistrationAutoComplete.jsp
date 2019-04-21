<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");

		}
		List<Patient> patientList=new ArrayList<Patient>();
		if(map.get("patientList") != null){
			patientList = (List)map.get("patientList");
		}
		String flagPop="";
		if(request.getParameter("flagPop")!=null){
			flagPop=(String)request.getParameter("flagPop");
		}
		if(flagPop.equalsIgnoreCase("1")){
		%>
		 <input
	id="hinNo" type="hidden" name="<%=HIN_NO %>" value="" />
			<div class="titleBg">
			<h2>Patient Details</h2>
			</div>
			<label><input type="button" value="Close" name="Close" class="button" onclick="window.close();" /></label>
			<div class="Block">

		<%

		int counter=0;
		if(patientList.size() !=0){
			%>
			<table width="100%" colspan="7" border="0" cellpadding="0" cellspacing="0">
			<tr>
			<th width="10%">S.No.</th>
			<th width="30%">Name</th>
			<th width="10%">Reg No.</th>
			<th width="10%">DOB</th>
			<th width="10%">Age</th>
			<th width="10%">Mobile No.</th>
			<th width="20%">Address</th>
		</tr>
			<%
			for(Patient patient:patientList){
			++counter;

			String patientName="";
			String cellNo="";
			String address="";
			String dob="";
			String age="";
			String hinNo="";
			hinNo=patient.getHinNo();
			if(patient.getPFirstName()!=null){
				patientName=patient.getPFirstName();
			}
			if(patient.getPMiddleName()!=null){
				patientName+=" "+patient.getPMiddleName();
			}
			if(patient.getPLastName()!=null){
				patientName+=" "+patient.getPLastName();
			}
			if(patient.getMobileNumber()!=null){
				cellNo=patient.getMobileNumber();
			}
			if(patient.getDateOfBirth()!=null){
				dob=HMSUtil.convertDateToStringTypeDateOnly(patient.getDateOfBirth());
			}
			if(patient.getDateOfBirth()!=null){
				age=patient.getAge();
			}

			if(patient.getAddress()!=null){
				address=patient.getAddress().trim();
			}

		%>
		<tr>
			<td width="10%"><%=counter%></td>
			<td onclick="redirectToVisit(<%=patient.getHinNo()%>)"  width="30%"><%=patientName%></td>
			<td width="10%"><%=hinNo%></td>
			<td width="10%"><%=dob%></td>
			<td width="10%"><%=age%></td>
			<%
			if(cellNo!=""){
%>
				<td width="10%"><%=cellNo%></td>
	<%
			}else{
				%>
				<td width="10%">&nbsp;</td>
	<%
			}
			%>
			<td width="20%"><%=address%></td>
		</tr>

		<%
			}
			%>
		</table>
			<%
		}else{
		%>
		<script>
		window.close();
		</script>
		<label> No Record</label>
		<%} %>



	<script type="text/javascript">
	function redirectToVisit(hinNo)
	{
	var status1="YES"
	 window.opener.location.href = "registration?method=showVisitDetails&hinNo="+hinNo;
	 if (window.opener.progressWindow)
	 {
		window.opener.progressWindow.close()
	 }
	  window.close();
	}
	</script>
	</div>
		<%
		}else{
		%>
<ul>
	<%
	if(patientList.size() !=0){

		for(Patient patient:patientList){

		String patientName="";
		if(patient.getPFirstName()!=null){
			patientName=patient.getPFirstName();
		}
		if(patient.getPMiddleName()!=null){
			patientName+=" "+patient.getPMiddleName();
		}
		if(patient.getPLastName()!=null){
			patientName+=" "+patient.getPLastName();
		}
		if(patient.getMobileNumber()!=null){
			patientName+=" Mobile No. "+patient.getMobileNumber();
		}
		if(patient.getDateOfBirth()!=null){
			patientName+=" DOB: "+HMSUtil.convertDateToStringTypeDateOnly(patient.getDateOfBirth())+" Age: "+patient.getAge();
		}
		if(patient.getAddress()!=null){
			patientName+="\n Add: "+patient.getAddress().trim();
		}
%>
	<li onclick="-" title="<%=patientName%>"><%=patientName%></li>

	<%}}else{%>
	<li>----------No Record found-------------</li>
	<%} %>
</ul>

		<%
		}
%>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
