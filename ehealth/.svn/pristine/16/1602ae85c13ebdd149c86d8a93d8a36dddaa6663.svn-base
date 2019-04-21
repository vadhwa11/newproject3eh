<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryHeader"%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Pending Indent List</title>
<div class="titleBg">
<h2>Pending Indent List</h2>
</div>
</head>

<script type="text/javascript">
function populateResultEntry(RequestHeaderId){
	
	window.location.href = 'bloodBank?method=showIssueOfIndentJsp&RequestHeaderId='+RequestHeaderId; 
} 
</script>
<body>
<%
Map<String,Object> map = new HashMap<String,Object>();
List<BloodRequestEntryHeader> identRequestHeaderList=new ArrayList<BloodRequestEntryHeader>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

if(map.get("identRequestHeaderList") != null){
	identRequestHeaderList=(List<BloodRequestEntryHeader>)map.get("identRequestHeaderList");
}

%>
<form name="pendingIndent">
<div class="Block">
<label>From Date </label> 
<input type="text" class="date"
	id="lastDateId" name="" value=""
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.bloodDonationEntry.expiryDate,event)" />
	
	<label>To Date </label> 
<input type="text" class="date"
	id="lastDateId" name="" value=""
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.bloodDonationEntry.expiryDate,event)" />
	
	<label>Indent From</label>
<select name="" tabindex="1">
	<option value="0">Select</option>
	
</select>
<div class="clear"></div>
<label>Indent Number</label>
<input type="text"  value="" /> 
	
<label>Ward</label>
<input type="text"  value="" /> 
<div class="clear"></div>
<div class="clear"></div>
<input type="button" class="button" value="Search"
	onclick="addRow('dataTable')"
	align="right" /> 

	
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>	

<%if(null !=identRequestHeaderList){%>
	<table id="" width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			
			<th>Indent Date</th>
			<th>Indent From</th>
			<th>Indent Number</th>
			<th>Ward</th>
		</tr>
		</thead>
		<% for(BloodRequestEntryHeader bReh:identRequestHeaderList){
			%>
		
		<tr onclick="populateResultEntry(<%=bReh.getId() %>)">
		<td><%=HMSUtil.convertDateToStringTypeDateOnly(bReh.getOrderDate())  %></td>
 			<td><%=bReh.getHospital().getHospitalName()%></td>
 			
			<td></td>
				
			<td></td>
		</tr>
		<%} %>
	
	</table>
<% }
%>

</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</body>

</html>
