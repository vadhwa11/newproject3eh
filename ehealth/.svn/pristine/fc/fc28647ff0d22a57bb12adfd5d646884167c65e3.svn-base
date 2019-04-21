<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
</script>

<%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	int BloodhdId=0;
	int hinId=0;
	String ipNumber="";
	String orderSeqNo="";
	
	int inPatientId=0;
	
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
	
		List<MasHospital> bloodBankList=new ArrayList<MasHospital>();
		if(map.get("bloodBankList") != null){
			bloodBankList=(List<MasHospital>)map.get("bloodBankList");
		}
%>


<div id="nameDiv">
<%
if(null !=bloodBankList){
	String bloodtime="";
%>
<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">&nbsp;</th>
			<th width="10%">Blood Bank</th>
			<th width="7%">Timing</th>
			<th width="10%">Status</th>
			<th width="10%">Qty Available (unit) </th>
		</tr>
	</thead>
	<tbody>
		<%
    	 
    	for(MasHospital bloodBank:bloodBankList){
    		if(null !=bloodBank.getOpeningTime() && null !=bloodBank.getClosingTime() )
    		bloodtime=bloodBank.getOpeningTime()+"-- "+ bloodBank.getClosingTime();	  
    %>

		<tr>

			<td width="5%"><%-- <input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" tabindex=1 /> <input
				type="hidden" value="" name="<%=BLOOD_COMPONENT_ID%><%=inc %>"
				id="bloodComponentId<%=inc %>" tabindex=1 /> --%>
				
				<input type="radio" value="<%=bloodBank.getId() %>" 
				id="radioId<%=bloodBank.getId() %>" name="bloodBanknameId" 
				onclick="populatebloodBankQuantity(this.value);" /> </td>
			<td><%=bloodBank.getHospitalName() %></td>

			<td><%=bloodtime %></td>
			<%if(bloodBank.getStatus().equalsIgnoreCase("y")) {%>
			<td>Active</td>
			<%}
			else{
				%>
				<td>InActive</td>
			<% }
			%>
			<td><input type="text" name="b<%=bloodBank.getId()%>" id="b<%=bloodBank.getId()%>"/></td>
		</tr>
		<%}} %>
	</tbody>
</table>
</div>
</body>
</html>