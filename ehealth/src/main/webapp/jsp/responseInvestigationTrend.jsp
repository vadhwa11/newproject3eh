<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.IpdInvestigationMonitoring"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%
Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
/* List<DgOrderdt> orderList = new ArrayList<DgOrderdt>();
if(map.get("orderList")!=null){
	orderList = (List<DgOrderdt>)map.get("orderList");
} */

List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
if(map.get("resultList")!=null){
	resultList = (List<DgResultEntryHeader>)map.get("resultList");
}
DgResultEntryHeader reHeader = new DgResultEntryHeader();
DgResultEntryDetail reDt = new DgResultEntryDetail();
if(resultList.size() >0){
	reHeader = resultList.get(0);
}
System.out.println("reHeader--"+reHeader.getInvestigation());
%>
<%-- <table>
<tr>
	<th>Order No.</th>
	<th>Order Date</th>
	<th>Order Time</th>
	<th></th>
	</tr>
	<%
		for(DgOrderdt orderdt : orderList){
	%>
	<tr>
	<td><%=orderdt.getOrderhd().getOrderNo() %></td>
	<td><%=HMSUtil.convertDateToStringWithoutTime(orderdt.getOrderhd().getOrderDate()) %></td>
	<td><%=orderdt.getOrderhd().getOrderTime() %></td>
	<td><input type="button" name="print" id="print" onclick="popwindowresult('/hms/hms/enquiry?method=investigationResult&orderNo=<%=orderdt.getOrderhd().getOrderNo() %>&chargeCodeId=<%=orderdt.getChargeCode().getId() %>');" value="Result" class="button" accesskey="a"></td>
	</tr>
	<%} %>
</table>	 --%>

<table>
<tr>

	<th>Result Date</th>
	<th>Result Time</th>
	<%
		if(reHeader!=null && reHeader.getInvestigation()!=null && reHeader.getInvestigation().getInvestigationType().equalsIgnoreCase("s")){
	%>
	<th scope="col">UOM</th>
	<th scope="col">Normal Range</th>
	<%} %>
	<th>Result</th>
	</tr>
	<%
	for(DgResultEntryHeader resultEntryHd : resultList){
	//	DgResultEntryHeader resultEntryHd = new DgResultEntryHeader();
	//	resultEntryHd = (DgResultEntryHeader)obj[2];
		
	
	%>
	<tr>
	<td><%=HMSUtil.convertDateToStringWithoutTime(resultEntryHd.getResultDate()) %></td>
	<td><%=resultEntryHd.getResultTime() %></td>
	
	<%
		if(resultEntryHd.getInvestigation().getInvestigationType().equalsIgnoreCase("s")){
	%>
	
	<% if(resultEntryHd.getInvestigation().getUom() != null){ %>
		<td><%=resultEntryHd.getInvestigation().getUom().getUomName()%></td>
		<% }else{ %>
		<td>-</td>
		<% } %>
		<% if(resultEntryHd.getInvestigation().getMinNormalValue() != null
    		&& resultEntryHd.getInvestigation().getMaxNormalValue() != null
    		
      &&!resultEntryHd.getInvestigation().getMinNormalValue().equals("")
      &&!resultEntryHd.getInvestigation().getMaxNormalValue().equals("")){
     		Float minValue1 = Float.parseFloat(resultEntryHd.getInvestigation().getMinNormalValue());
    		Float maxValue1 = Float.parseFloat(resultEntryHd.getInvestigation().getMaxNormalValue());
    		String minValue = new DecimalFormat("0.##").format((double)minValue1);
    		String maxValue = new DecimalFormat("0.##").format((double)maxValue1);
    		%>
		<td><%=minValue%> - <%=maxValue %></td>


		<% }else {
			
		if(resultEntryHd.getInvestigation().getNormalValue() != null)
			{%>
		<td><%=resultEntryHd.getInvestigation().getNormalValue() %></td>
		<% }
		else{ %>
		<td>-</td>
		<%} } %>
	<%
	
		for(DgResultEntryDetail resultDt : resultEntryHd.getDgResultEntryDetails()){
	%>
	<td><%=resultDt.getResult() %></td>
	<%} %>
	<%}else {
		String url ="/hms/hms/ipd?method=getInvestigationResultForTrend&resultId="+resultEntryHd.getId()+"&resultType="+resultEntryHd.getInvestigation().getInvestigationType()+""; 
		%>
		<td><input type="button" accesskey="a" class="button" value="Result" 
			 onclick="popwindowresult('<%=url %>');" id="print" name="print"></td>
	<%	
	} %>
	
	<%} %>
</table>	

	