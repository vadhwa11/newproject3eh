
<%@page import="jkt.hms.masters.business.PhStudentHealthDetails"%>
<%@page import="jkt.hms.masters.business.PhStudentRegistration"%>
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
<%@page import="jkt.hms.masters.business.PhClassDetails"%>
<%@page import="jkt.hms.masters.business.PhVillageSurvey"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="java.net.URL"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>


<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<PhStudentRegistration> phStudentRegistrationList= new ArrayList<PhStudentRegistration>();
if(map.get("phStudentRegistrationList") != null){
	phStudentRegistrationList =  (List<PhStudentRegistration>)map.get("phStudentRegistrationList");
	
}
String classD="";
if(map.get("classD") != null){
	classD =  (String)map.get("classD");
	
}
int cstdId=0;
if(map.get("cstdId") != null){
	cstdId =  (Integer)map.get("cstdId");
	
}
%>

 <div id="studentRegistration">




<h4>List of Student</h4>

<div id="pageNavPosition"></div>	

<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0" class="sortable">
	<thead>
		<tr>
			<th>UHID</th>
			<th>Student Name</th>
			<th>Gender</th>
			<th>Class</th>
			
		</tr>
	</thead>
	<tbody id="tableData">
	
	<%
if (phStudentRegistrationList.size() > 0) {
				for (PhStudentRegistration st : phStudentRegistrationList) {
		%>
		<tr onclick="if(validatePhStHel(<%=cstdId %>,<%=st.getId()%>,'<%=classD %>','<%=st.getClassdetails() != null ? st.getClassdetails().getSchoolClass():""%>')){submitForm('student','/hms/hms/pubHealth?method=getValueStudentRegistration&studentRegistrationId=<%=st.getId()%>');}">
			
			<td width="5%">
			<%if(st.getMembersurvey().getAadhaarNo()!=null){ %>
			<%=st.getMembersurvey().getAadhaarNo()%>
			<%}else{ %>
			-
			<%} %>
			</td>
			<%if(st.getMembersurvey().getName()!=null){ %>
			<td width="5%"><%=st.getMembersurvey().getName()%>
			
			<%}else{ %>
			-
			<%} %>
			</td>
			<td width="5%">
			<%if(st.getMembersurvey().getGender().getAdministrativeSexName()!=null){ %>
			<%=st.getMembersurvey().getGender().getAdministrativeSexName()%>
			<%}else{ %>
			-
			<%} %>
			</td>
			
			<td width="5%">
			<%if(st.getClassdetails()!=null){ %>
			<%=st.getClassdetails().getSchoolClass() != null ? st.getClassdetails().getSchoolClass() : ""%>
			<%}else{ %>
			-
			<%} %>
			</td>
			
			
		</tr>
			
		
		<%}%>
				
			

<%}else{ %>
<tr>
<td colspan="3"> <h6> No Record Found </h6></td>
</tr>
<%} %>
				
			
</tbody>
</table>





<div class="paddingTop40"></div>
	  <script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
	<script language="javascript">

function validatePhStHel(cstId,stId,classD,schoolClass)
{
       if (cstId==stId && classD==schoolClass) 
	   {
		alert("Health record already entered for this Student.");
		return false;
	   }
      return true;
}

</script>


</div>
	
