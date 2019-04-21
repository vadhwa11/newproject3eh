<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>

<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="java.math.BigDecimal"%><script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>

<script type="text/javascript">

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
<form name="accountSubLedgerBalance" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> subLedgerBalanceList = new ArrayList<Object[]>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("subLedgerBalanceList") != null){
		subLedgerBalanceList = (List<Object[]>)map.get("subLedgerBalanceList");
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

<div class="titleBg">
<h2>Account Sub Ledger Balance</h2>
</div>
<div class="clear"></div>


<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table width="100%" border="0" id="accId" cellspacing="0" cellpadding="0" class="sortable">
	<tr>
		
		<th scope="col">Code</th>
		<th scope="col">Name</th>
		<th scope="col">Op-Dr</th>
        <th scope="col">Op-Cr</th>
        <th scope="col">YTD - Cr.</th>
        <th scope="col">YTD - Dr.</th>
        <th scope="col">Balance-Dr</th>
        <th scope="col">Balance-Cr</th>
	</tr>
	<tbody id="tableData">
		<%
		String trColor = "";
				for(Object[] subLed : subLedgerBalanceList){
					//if(subLed.getAccount()!= null){
					//if(subLed.getAccount().getAccountSubGroup()!= null){
						 // if(subLed.getAccount().getAccountSubGroup().getAccountGroup()!= null){
				   	 			//if(subLed.getAccount().getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Assets")){
				   	 			//	trColor="#D6FCA9";
				   	 			//}else if(subLed.getAccount().getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Liability")){
				   	 				//trColor="#FDBFA1";
				   	 			//} else if(subLed.getAccount().getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Income")){
				   	 				//trColor="#C2F7FA";
				   	 			//}else if(subLed.getAccount().getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Expenditure")){
				   	 			//	trColor="#FDF1B1";
				   	 			//}
				   	 			//}
						  //}
					//}


		%>
		<tr bgcolor="<%=trColor %>">
<td class="rightTxt"><%=subLed[1] %></td>
			<td><%=subLed[2] %></td>
			<%
                   if(subLed[6] != null && ((BigDecimal)subLed[6]).compareTo(new BigDecimal(0)) > 0){
           %>
            <td class="rightTxt"><%=subLed[6]%></td>
            <%}else{ %>
            <td class="rightTxt">0.00</td>
            <%} %>
            <%
                   if(subLed[5] != null && ((BigDecimal)subLed[5]).compareTo(new BigDecimal(0)) > 0){
           %>
            <td class="rightTxt"><%=subLed[5] %></td>
           <%}else{ %>
            <td class="rightTxt">0.00</td>
            <%} %>
            
<%
                 if(subLed[4] != null && ((BigDecimal)subLed[4]).compareTo(new BigDecimal(0)) > 0){
         %>
          <td class="rightTxt"><%=subLed[4]%></td>
          <%}else{ %>
          <td class="rightTxt">0.00</td>
          <%} %>
          
          <%
                 if(subLed[3] != null && ((BigDecimal)subLed[3]).compareTo(new BigDecimal(0)) > 0){
         %>
          <td class="rightTxt"><%=subLed[3]%></td>
          <%}else{ %>
          <td class="rightTxt">0.00</td>
          <%} %>
			
 		<% if(subLed[9] != null && ((BigDecimal)subLed[9]).compareTo(new BigDecimal(0)) > 0){
                      %>
             <td class="rightTxt"><%=subLed[9]%></td>
             <%}else{ %>
             <td class="rightTxt">0.00</td>
             <%} %>
             
             <%
                    if(subLed[10] != null && ((BigDecimal)subLed[10]).compareTo(new BigDecimal(0)) > 0){
            %>
             <td class="rightTxt"><%=subLed[10]%></td>
             <%}else{ %>
             <td class="rightTxt">0.00</td>
             <%} %>

		</tr>
<%}
%>
	</tbody>
</table>

<input type="button" name="Back" value="Back" class="button" onclick="submitForm('accountSubLedgerBalance','account?method=showAccountSubLedgerJsp')" tabindex=1 />





<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>