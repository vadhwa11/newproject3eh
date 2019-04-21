<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.IpdHandTakeOver"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map<String,Object>)request.getAttribute("map");
}
	List<IpdHandTakeOver> ipdHandTakeList = new ArrayList<IpdHandTakeOver>();
	ipdHandTakeList = (List<IpdHandTakeOver>)map.get("ipdHandTakeList");
if(ipdHandTakeList.size()>0){
%>
<div id="testDiv">
<div class="tableForTabNew">
<table border="0" width="80%" cellpadding="2" align="center" cellspacing="2" >
	<tr>
		<th>Entry Date</th>
		<th>Entry No</th>
		<th>From Hand Over</th>
		<th>To Hand Over</th>
		<th>Shift Time</th>
		<th>Pending Works Remark</th>
	</tr>
<%
	for(IpdHandTakeOver over : ipdHandTakeList)
	{ 
		String fromHandOver="";
		String toHandOver="";
		if(over.getHandBy().getFirstName()!=null && over.getHandBy().getFirstName()!=""){
			fromHandOver= over.getHandBy().getFirstName();
		}
		if(over.getHandBy().getLastName()!=null && over.getHandBy().getLastName()!=""){
			fromHandOver=fromHandOver+" "+over.getHandBy().getLastName();
		}
	
		if(over.getTakeBy().getFirstName()!=null && over.getTakeBy().getFirstName()!=""){
			toHandOver= over.getTakeBy().getFirstName();
		}
		if(over.getTakeBy().getLastName()!=null && over.getTakeBy().getLastName()!=""){
			toHandOver=toHandOver+" "+over.getTakeBy().getLastName();
		}
	%>
	<tr>
		<td><%=HMSUtil.convertDateToStringWithoutTime(over.getEntryDate())%></td>
		<td><%=over.getEntryNo()%></td>
<td><%=fromHandOver%></td>
<td><%=toHandOver%></td>
		<td><%=	over.getShiftTime()%></td>
		<td><%=over.getRemarksPendingWork()%></td>
	</tr>
	<%} %>
</table>
</div>
</div>
<%}else{%>
<div class="clear"></div>
<h4> No Records Found!!</h4>
<div id="statusMessage"></div>
<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</html>
