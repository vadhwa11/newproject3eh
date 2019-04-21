<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>


<form name="schedule" method="post" action="">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccount> currentScheduleAccountList = new ArrayList<FaMasAccount>();
	List<FaMasAccount> lastScheduleAccountList = new ArrayList<FaMasAccount>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	String lastYearDesc = "";
	String currentYearDesc = "";
	String particular = "";
	Date fromDate = null;
	Date toDate = null;
	int schedule = 0;
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	if(map.get("currentScheduleAccountList") != null){
		currentScheduleAccountList = (List<FaMasAccount>)map.get("currentScheduleAccountList");
	}
	if(map.get("lastScheduleAccountList") != null){
		lastScheduleAccountList = (List<FaMasAccount>)map.get("lastScheduleAccountList");
	}
	if(map.get("lastYearDesc") != null){
		lastYearDesc = (String)map.get("lastYearDesc");
	}
	if(map.get("currentYearDesc") != null){
		currentYearDesc = (String)map.get("currentYearDesc");
	}
	if(map.get("currentYearDesc") != null){
		currentYearDesc = (String)map.get("currentYearDesc");
	}
	if(map.get("particular") != null){
		particular = (String)map.get("particular");
	}
	if(map.get("schedule") != null){
		schedule = (Integer)map.get("schedule");
	}
	if(map.get("fromDate") != null){
		fromDate = (Date)map.get("fromDate");
	}
	if(map.get("toDate") != null){
		toDate = (Date)map.get("toDate");
	}
	
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>


<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div class="titleBg">
<h4><%=schedule+")  "+ particular %></h4>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<table>
<tr>
		<th scope="col">Particulars</th>
		<th scope="col">For the Year ended 31st March <%=currentYearDesc %>(in Rs.)</th>
		<th scope="col">For the Year ended 31st March <%=lastYearDesc %>(in Rs.)</th>
	</tr>
	<%
	BigDecimal currentCrBalance = new BigDecimal(0.0);
	BigDecimal currentDrBalance = new BigDecimal(0.0);
	BigDecimal currentScheduleAmt = new BigDecimal(0.0);
	BigDecimal lastCrBalance = new BigDecimal(0.0);
	BigDecimal lastDrBalance = new BigDecimal(0.0);
	BigDecimal lastScheduleAmt = new BigDecimal(0.0);
	
	if(currentScheduleAccountList.size()>0){
		for(FaMasAccount masAccount : currentScheduleAccountList){
	%>
	<tr onclick ="submitForm('schedule','account?method=displayLedgerBook&accountId=<%=masAccount.getId()%>&fromDate=<%=HMSUtil.convertDateToStringWithoutTime(fromDate) %>&toDate=<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>&accountName=<%=masAccount.getAccDesc() %>')">
	
	<td><%=masAccount.getAccDesc() %></td>
	<%
		if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
			currentCrBalance = masAccount.getClBalanceCr();
		}
		if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
			currentDrBalance = masAccount.getClBalanceDr();
		}
		if(currentCrBalance.compareTo(currentDrBalance)>0){
			currentScheduleAmt = currentCrBalance.subtract(currentDrBalance);
		}else if(currentDrBalance.compareTo(currentCrBalance)>0){
			currentScheduleAmt = currentDrBalance.subtract(currentCrBalance);
		}else if(currentDrBalance.compareTo(currentCrBalance)==0){
			currentScheduleAmt =new BigDecimal(0.00);
		}
	
	%>
	<td><%=currentScheduleAmt %></td>
	
	<%
	if(lastScheduleAccountList.size()>0){
		for(FaMasAccount account : lastScheduleAccountList){
		if(account.getClBalanceCr() != null && account.getClBalanceCr() != new BigDecimal(0.00)){
			lastCrBalance = account.getClBalanceCr();
		}
		if(account.getClBalanceDr() != null && account.getClBalanceDr() != new BigDecimal(0.00)){
			lastDrBalance = account.getClBalanceDr();
		}
		if(lastCrBalance.compareTo(lastDrBalance)>0){
			lastScheduleAmt = lastCrBalance.subtract(lastDrBalance);
		}else if(lastDrBalance.compareTo(lastCrBalance)>0){
			lastScheduleAmt = lastDrBalance.subtract(lastCrBalance);
		}else if(lastDrBalance.compareTo(lastCrBalance)==0){
			lastScheduleAmt =new BigDecimal(0.00);
		}
	
	%>
	<td><%=lastScheduleAmt %></td>
	<%}}else{ %>
	<td>0</td>
	<%} %>
	</tr>
	<%}} %>
	
</table>
<div class="clear"></div>



<div class="clear"></div>
<div class="clear"></div>




 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>