<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>

<%@page import="jkt.hms.masters.business.FaMasSubLed"%><script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
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
	List<HrMasFinancialYear> fYearList = new ArrayList<HrMasFinancialYear>();
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<FaMasSubLed> subledgerList = new ArrayList<FaMasSubLed>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("fYearList")!= null){
		fYearList = (List<HrMasFinancialYear>)map.get("fYearList");
	}
	if(map.get("accountList")!= null){
		accountList = (List<FaMasAccount>)map.get("accountList");
	}
	if(map.get("subledgerList")!= null){
		subledgerList = (List<FaMasSubLed>)map.get("subledgerList");
	}
	if (map.get("message") != null) {
		String message = (String) map.get("message");
		out.println(message);
	}
%>


<form name="ledgerBook" method="post" action="">
<div class="clear"></div>

<div class="paddingTop15"></div>
<h4>Ledger Book Report</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">

<label><span>*</span> Account</label>
<select id="mainAccountId"  name="<%=ACCOUNT_ID %>" onchange="populateSubLedger(this.value,'ledgerBook')" >
	<option value="0">Select</option>
	<%if(accountList.size()>0){
		for(FaMasAccount faMasAccount :accountList){
			
		%>
	<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>
		
	<%	}
	}
		%>
</select>
<label> Sub-Ledger </label>
<select id="subledgerId"  name="<%=SUB_LEDGER_ID%>" >
	<option value="0">Select</option>
	<%if(subledgerList.size()>0){
		for(FaMasSubLed faMasSubLed :subledgerList){
			
		%>
	<option value="<%=faMasSubLed.getId() %>"><%=faMasSubLed.getSubLedDesc() %></option>
		
	<%	}
	}
		%>
</select>
<script type="text/javascript">
          subLedgerArray1 = new Array();
		<%
			int count1 = 0;
		for (FaMasAccount faMasAccount :accountList)
			{

				for (FaMasSubLed faMasSubLed :subledgerList)
				{

					if(faMasAccount.getId().equals(faMasSubLed.getAccount().getId())){
								%>
									subLedgerArray1[<%=count1%>] = new Array();
									subLedgerArray1[<%=count1%>][0] = <%=faMasAccount.getId()%>;
									subLedgerArray1[<%=count1%>][1] = <%=faMasSubLed.getId()%>;
									subLedgerArray1[<%=count1%>][2] = "<%=faMasSubLed.getSubLedDesc()%>";

								<%
								count1++;
						}	} } %>
		</script>	
<label><span>*</span> From Date</label>
<input type="text" name="from_date" id="from_date" value="<%=date %>" class="date" readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('',document.ledgerBook.from_date,event)" />
<label><span>*</span> To Date</label>
<input type="text" name="to_date" id="to_date" value="<%=date %>" class="date" readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('',document.ledgerBook.to_date,event)"  />
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Print" class="button" onClick="if(chkDate()){submitForm('ledgerBook','account?method=printLedgerBookReport')};" accesskey="a" tabindex=1 />
</div>
<script>
function chkDate(){
	var fromDate=document.getElementById('from_date').value;
	var toDate=document.getElementById('to_date').value;
	
	if(toDate<fromDate){
		alert("To Date Is Smaller Than From Date");
		return false;
	}
	else 
		return true;
		
}
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>