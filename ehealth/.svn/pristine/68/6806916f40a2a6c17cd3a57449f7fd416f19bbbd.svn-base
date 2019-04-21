<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasBranch"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.math.BigDecimal"%>

<%@page import="jkt.hms.masters.business.AccountSubLedTransac"%>


<link href="/erp/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	List<AccountSubLedTransac> subLedList = new ArrayList<AccountSubLedTransac>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("subLedList") != null){
		subLedList = (List<AccountSubLedTransac>)map.get("subLedList");
	}
	
		%>

<form name="suLedDetails" method="post" action="">

<table width="100%" border="0"  cellspacing="0" cellpadding="0" class="small" >
	<tr>
		<th scope="col">SubLedger</th>
		<th scope="col">Dr Amount</th>
		<th scope="col">Cr Amount</th>
	</tr>
	<tbody>
	<%
		if(subLedList.size()>0){
			for(AccountSubLedTransac masSubLed : subLedList){
	%>

		<tr>
		<td><%=masSubLed.getSubLed().getSubLedDesc() %></td>
		<%
		if(masSubLed.getClBalanceDr() != null){
		%>
		<td><%=masSubLed.getClBalanceDr() %> </td>
		<%}else{%>
		<td>0</td>
		<%} %>
		<%if(masSubLed.getClBalanceCr() != null){ %>
		<td><%=masSubLed.getClBalanceCr() %></td>
		<%}else{ %>
		<td>0</td>
		<%} %>
		</tr>

	</tbody>
	<%}} %>
</table>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
