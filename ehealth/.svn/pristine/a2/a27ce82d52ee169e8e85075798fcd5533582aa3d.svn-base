
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
<%@page import="jkt.hms.masters.business.PhClassDetails"%>
<%@page import="jkt.hms.masters.business.PhVillageSurvey"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script>
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
List<PhMemberSurvey> phMemberSurveyList= new ArrayList<PhMemberSurvey>();
if(map.get("phMemberSurveyList") != null){
	phMemberSurveyList =  (List<PhMemberSurvey>)map.get("phMemberSurveyList");
	
}


%>

 <div id="memberSurvey">




<h4>List of Member</h4>

<div id="pageNavPosition"></div>	

<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0" class="sortable">
	<thead>
		<tr>
			<th>UHID</th>
			<th>Student Name</th>
			<th>Gender</th>
			<th>Age</th>
		</tr>
	</thead>
	<tbody id="tableData">
<%
			if (phMemberSurveyList.size() > 0) {
				for (PhMemberSurvey st : phMemberSurveyList) {
		%>
		<tr onclick="submitProtoAjaxWithDivNameToShowStatus('student','/hms/hms/pubHealth?method=getValueMemberSurvey&memberSurveyId=<%=st.getId()%>','memberSurveyValue');">
			<td width="5%"><%=st.getAadhaarNo()!=null?st.getAadhaarNo():""%></td>
			<td width="5%"><%=st.getName()%></td>
			<td width="5%"><%=st.getGender().getAdministrativeSexName()%></td>
			<td width="5%"><%=st.getDateOfBirth()!=null?HMSUtil.calculateAge(st.getDateOfBirth()):""%></td>
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
	  
 <div id="memberSurveyValue">


</div>

</div>
	
