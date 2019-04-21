<%@page import="javassist.bytecode.Mnemonic"%>
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
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
	List<PhMemberSurvey> memberSurveyDetailList = new ArrayList<PhMemberSurvey>();
 	Map<String, Object> map = new HashMap<String, Object>(); 
 	String message = "";
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}  	
	
	if(map.get("memberSurveyDetailList")!=null){ 
		memberSurveyDetailList = (List<PhMemberSurvey>)map.get("memberSurveyDetailList"); 	
	} 
	if (map.get("message") != null) {
		message = (String) map.get("message");
	} 
	String name = "";
	String contactNo = "";
	String relation ="";
	String district = "";
	String city = "";
	String state = "";
	String postalCode = "";
	
	if(memberSurveyDetailList.size()>0){
		PhMemberSurvey memberSurvey = (PhMemberSurvey)memberSurveyDetailList.get(0);
		if(memberSurvey.getName() != null){
			name = (String)memberSurvey.getName();
		}
		if(memberSurvey.getContactNo() != null){
			contactNo = (String)memberSurvey.getContactNo();
		}
		if(memberSurvey.getRelationshipName() != null){
			relation = (String)memberSurvey.getRelationshipName();
		}
		if(memberSurvey.get != null){
			gender = (String)patient.getSex().getAdministrativeSexName();
		}
		if(patient.getFamily() != null){
			familyId = (String)patient.getFamily().getFamilyId();
		}
		
		
	}
%>

<!--Block One Starts-->
<form name="patientAdvanceMemberDetail" action="" method="post">

	<div class="clear"></div>
	<div class="titleBg">
		<h2>Patient Advance</h2>
	</div>
	<div class="clear"></div>

	<div class="Block">

	<label>Nominee Name</label>
	 <input type="text" name="hinNo" value="<%=uhid != null?uhid:"" %>" /> 
	 <label>Contact No</label>
	  <input type="text" name="patientName" value="<%=patientName != null?patientName:"" %>"" />
	   <label>Relation</label>
		<input type="text" name="age" value="<%=age != null?age:"" %>"" />
		<div class="clear"></div>

	<label>District</label>
		<input type="text" name="gender" value="<%=gender != null?gender:"" %>"" />
		
		<label>State</label>
		<input type="text" name="familyId" value="<%=familyId != null?familyId:"" %>"" />
		<label>Postal Code</label>
		<input type="text" name="age" value="" />
		

		<div class="clear"></div>
		</div>
		<div id="pageNavPosition"></div>
	
		<table width="100%" border="0" cellpadding="0" cellspacing="0">

			<tr>
				<th scope="col">Name</th>
				<th scope="col">Relation</th>
				<th scope="col">Date Of Birth</th>
				<th scope="col">Mobile No</th>
			</tr>
		<tbody id="tableData">
		
		<%
		if(memberSurveyDetailList.size()>0){
			for(PhMemberSurvey memberSurvey : memberSurveyDetailList){
			
			
			
		
		
		%>
		
			<tr style="cursor: pointer;"
				onclick="submitForm('patientAdvanceMemberDetail','/hms/hms/opBilling?method=getMemberDetailsForPatientAdvance&surveyId=<%=memberSurvey.getId()%>')">
				
				<td><%=memberSurvey.getName() != null?memberSurvey.getName():"" %></td>
				<td><%=memberSurvey.getRelationshipName()!= null?memberSurvey.getRelationshipName():"" %></td>
				<td><%=memberSurvey.getDateOfBirth() != null?memberSurvey.getDateOfBirth():""%></td>
				<td><%=memberSurvey.getContactNo() != null?memberSurvey.getContactNo():"" %></td>
				
				</tr>
			</tbody>
<%} %>
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
	

