<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>



<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	if(map.get("accountList")!= null){
		accountList = (List<FaMasAccount>)map.get("accountList");
	}
%>

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

<form name="ledgerBook" method="post" action="">
<div class="clear"></div>
<h2>Ledger Book</h2>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">

<label><span>*</span> Account</label>
<select id="mainAccountId"  name="<%=ACCOUNT_ID %>"  onchange="getAccountName();" >
	<option value="0">Select</option>
	<%
	String accountName = "";
	if(accountList.size()>0){
		for(FaMasAccount faMasAccount :accountList){
			accountName = faMasAccount.getAccDesc();
		%>
	<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>
		
	<%	}
	}
		%>
</select>

<input type="hidden" name="accountName" id="accountNameId" value=""/>
<input type="hidden" name="accId" id="accId" value=""/>
<div class="clear"></div>
<label><span>*</span>From Date:</label>
<input type="text" name="<%=FROM_DATE %>" id="fromDate" value="01/04/2016" class="date" tabindex=1 readonly="readonly" validate="From Date ,date,yes" MAXLENGTH="12" />
<img width="16" height="16" border="0" onclick="javascript:setdate('01/04/2016',document.ledgerBook.<%=FROM_DATE %>,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">

<label><span>*</span>To Date:</label>
<input type="text" name="<%=TO_DATE %>" id="toDate" value="31/03/2017" class="calDate" tabindex=1 readonly="readonly" validate="To Date ,date,yes" MAXLENGTH="12" />
<img width="16" height="16" border="0" onclick="javascript:setdate('31/03/2017',document.ledgerBook.<%=TO_DATE %>,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">

<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="OK" id="addbutton" value="OK" class="button" onClick="submitForm('ledgerBook','account?method=displayLedgerBook');" accesskey="a" tabindex=1 />
<input type="button" name="OK" id="addbutton" value="Print" class="button" onClick="submitForm('ledgerBook','account?method=printLedgerReport');" accesskey="a" tabindex=1 />
<input type="button" name="OK" id="addbutton" value="Print New" class="button" onClick="submitForm('ledgerBook','account?method=printLedgerReportNew');" accesskey="a" tabindex=1 />
</div>
<script type="text/javascript">
 function getAccountName(){
	var accountId = document.getElementById('mainAccountId').value;
   <%if(accountList.size()>0){
   		for(FaMasAccount faMasAccount :accountList){%>
   			if(accountId == '<%=faMasAccount.getId()%>'){
   	   			var accountDesc = '<%=faMasAccount.getAccDesc()%>'
   			document.getElementById('accountNameId').value =accountDesc;
   	   		document.getElementById('accId').value =accountId;
   			}
   		
  <%}} %>


 }

</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
