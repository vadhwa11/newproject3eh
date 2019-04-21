<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.MasAccount"%>
<%@page import="java.math.BigDecimal"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
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
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> accountListForBalance = new ArrayList<Object[]>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("accountListForBalance") != null){
		accountListForBalance = (List<Object[]>)map.get("accountListForBalance");
	}

	
	Integer accCode = 0;
	if(map.get("accCode")!= null){
		accCode = (Integer)map.get("accCode");
	}
	String fYear = "";
	if(map.get("fYear")!= null){
		fYear = (String)map.get("fYear");
	}

	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>


<form name="accountMasterBalance" method="post" action="">
<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="titleBg">
<h2>Account Master Balance</h2>
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
			  for(Object[] masAccount :accountListForBalance){
		   	 			//if(masAccount.getAccountSubGroup()!= null){
				 // if(masAccount.getAccountSubGroup().getAccountGroup()!= null){
		   	 			//if(masAccount.getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Assets")){
		   	 				//trColor="#D6FCA9";
		   	 			//}else if(masAccount.getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Liability")){
		   	 				//trColor="#FDBFA1";
		   	 			//} else if(masAccount.getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Income")){
		   	 				//trColor="#C2F7FA";
		   	 			//}else if(masAccount.getAccountSubGroup().getAccountGroup().getAccountGroupDesc().equalsIgnoreCase("Expenditure")){
		   	 			//	trColor="#FDF1B1";
		   	 			//}
		   	 			//}
				 // }

		%>
		<tr bgcolor="<%=trColor %>">
			<td class="rightTxt"><%=masAccount[1] %></td>
			<td><%=masAccount[2] %></td>
			<%
                   if(masAccount[6] != null && ((BigDecimal)masAccount[6]).compareTo(new BigDecimal(0)) > 0){
           %>
            <td class="rightTxt"><%=masAccount[6]%></td>
            <%}else{ %>
            <td class="rightTxt">0.00</td>
            <%} %>
            <%
                   if(masAccount[5] != null && ((BigDecimal)masAccount[5]).compareTo(new BigDecimal(0)) > 0){
           %>
            <td class="rightTxt"><%=masAccount[5] %></td>
           <%}else{ %>
            <td class="rightTxt">0.00</td>
            <%} %>
            
<%
                 if(masAccount[4] != null && ((BigDecimal)masAccount[4]).compareTo(new BigDecimal(0)) > 0){
         %>
          <td class="rightTxt"><%=masAccount[4]%></td>
          <%}else{ %>
          <td class="rightTxt">0.00</td>
          <%} %>
          
          <%
                 if(masAccount[3] != null && ((BigDecimal)masAccount[3]).compareTo(new BigDecimal(0)) > 0){
         %>
          <td class="rightTxt"><%=masAccount[3]%></td>
          <%}else{ %>
          <td class="rightTxt">0.00</td>
          <%} %>
			
 		<% if(masAccount[9] != null && ((BigDecimal)masAccount[9]).compareTo(new BigDecimal(0)) > 0){
                      %>
             <td class="rightTxt"><%=masAccount[9]%></td>
             <%}else{ %>
             <td class="rightTxt">0.00</td>
             <%} %>
             
             <%
                    if(masAccount[10] != null && ((BigDecimal)masAccount[10]).compareTo(new BigDecimal(0)) > 0){
            %>
             <td class="rightTxt"><%=masAccount[10]%></td>
             <%}else{ %>
             <td class="rightTxt">0.00</td>
             <%} %>


		</tr>
	<%} %>
	</tbody>
</table>

<div class="clear"></div>
<input type="button" name="Back" value="Back" class="button" onclick="submitForm('accountMasterBalance','account?method=showAccountMasterJsp')" tabindex=1 />


<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);



		
	  </script>






<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>