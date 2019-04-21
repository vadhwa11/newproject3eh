<!DOCTYPE html>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'		
	</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
//	List<OpdPatientDetails> opdPatientDetailList = new ArrayList<OpdPatientDetails>();
	List<Object[]> opdPatientDetailList = new ArrayList<Object[]>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("opdPatientDetailList") != null){
		opdPatientDetailList =(List)map.get("opdPatientDetailList");
	}
	String msg = "";
	if(map.get("msg") != null){
		msg = (String)map.get("msg");
	}
	int empId  = 0;
	String empName = "";
	if(map.get("empId") != null){
		empId = (Integer)map.get("empId");
	}
	if(map.get("empName") != null){
		empName = (String)map.get("empName");
	}
%>	
<form name="policeIntimationWaitingList" method="post" action="">
<div class="titleBg">
<h2> Police Intimation</h2>
</div>

<div class="Block">
<div id="pageNavPosition"></div>
<table>
<tr>
<th>Patient Name</th>
<th>Age</th>
<th>Sex</th>

</tr>
<tbody id="tableData">
<%
if(opdPatientDetailList.size()>0){
for(Object[] opdPatientDetails : opdPatientDetailList){

%>

<tr onclick="submitForm('policeIntimationWaitingList','opd?method=displayPoliceIntimationDetail&opdPatientDetailId=<%=opdPatientDetails[0]%>');">

<td><%=(opdPatientDetails[1]!=null?opdPatientDetails[1]:"") %></td>



<td><%=(opdPatientDetails[2]!=null?opdPatientDetails[2]:"")%></td>


<td><%=(opdPatientDetails[3]!=null?opdPatientDetails[3]:"")%></td>

<%}}%>
</tr>

<%-- <tr onclick="submitForm('policeIntimationWaitingList','opd?method=displayPoliceIntimationDetail&opdPatientDetailId=<%=opdPatientDetails.getId()%>');">
<%if(opdPatientDetails.getVisit() != null){ %>

<td><%=opdPatientDetails.getVisit().getHin() != null?opdPatientDetails.getVisit().getHin().getFullName():"" %></td>
<%}else{ %>
<td><%=opdPatientDetails.getInpatient()!= null && opdPatientDetails.getInpatient().getHin()!= null ?opdPatientDetails.getInpatient().getHin().getFullName():"" %></td>
<%} %>

<%if(opdPatientDetails.getVisit() != null){ %>
<td><%=opdPatientDetails.getVisit().getHin().getAge() != null?opdPatientDetails.getVisit().getHin().getAge():"" %></td>
<%}else{ %>
<td><%=opdPatientDetails.getInpatient() != null && opdPatientDetails.getInpatient().getHin().getAge() != null?opdPatientDetails.getInpatient().getHin().getAge():"" %></td>
<%} %>

<%if(opdPatientDetails.getVisit() != null){ %>
<td><%=opdPatientDetails.getVisit().getHin() != null && opdPatientDetails.getVisit().getHin().getSex() != null?opdPatientDetails.getVisit().getHin().getSex().getAdministrativeSexName():"" %></td>
<%}else{ %>
<td><%=opdPatientDetails.getInpatient().getHin() != null && opdPatientDetails.getInpatient().getHin().getSex() != null?opdPatientDetails.getInpatient().getHin().getSex().getAdministrativeSexName():"" %></td>
<%} %>
<%}}%>
</tr> --%>

</tbody>
</table>

</div>

<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		</script>	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>







