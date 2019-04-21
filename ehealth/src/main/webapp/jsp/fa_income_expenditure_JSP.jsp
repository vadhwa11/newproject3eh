<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script> 
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<HrMasFinancialYear> fYearList = new ArrayList<HrMasFinancialYear>();
	List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("financialList")!= null){
		financialList = (List<MasStoreFinancial>)map.get("financialList");
	}
	if(map.get("accountList")!= null){
		accountList = (List<FaMasAccount>)map.get("accountList");
	}
%>


<form name="cashRegister" method="post" action="">
<div class="clear"></div>
<h2>Income Expenditure Report</h2>
<div class="clear"></div>
<div class="Block">
<label>Financial Year Wise</label>
<input type="radio" name="fiDDetails" id="financialYearId" checked="checked" onclick="hideUnhideIDiv();"  />
<label>Date Wise</label>
<input type="radio" name="fiDDetails"  id="dateId" onclick="hideUnhideIDiv();" />
<div class="clear"></div>
<div id="financialYearDivId" style="display: inline;">
<label><span>*</span> Year </label> 
<select name="year" id="yearId">
<option value="0">Select</option>
<%for(MasStoreFinancial msf:financialList){ %>
<option value="<%=msf.getId()%>"><%=msf.getFinancialYear() %></option>
<%} %>
</select>
</div>
<div class="clear"></div>
<div id="dateDivId" style="display: none;">
<label>From Date</label>
<input type="text"	tabindex="1" name="<%=FROM_DATE %>" value="<%=currentDate %>" class="date" id="fromDateId"	readonly="readonly" 
		validate=""	MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"	
		onclick="setdate('<%=currentDate %>',document.cashRegister.<%=FROM_DATE%>,event)" />
<label>To Date</label>
<input type="text"	tabindex="1" name="<%=TO_DATE %>" value="<%=currentDate %>" class="date" id="toDateId"	readonly="readonly" 
		validate=""	MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"	
		onclick="setdate('<%=currentDate %>',document.cashRegister.<%=TO_DATE%>,event)" />
</div>
<%--
<label><span>*</span> Month </label>
<select name="month" id="monthId"> 
<option value="0">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6">June</option>
<option value="7">July</option>
<option value="8">August</option>
<option value="9">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
</select> --%>


<div class="clear"></div>
<div class="paddingTop15"></div>
<%-- <input type="button" name="add" id="addbutton" value="Print" class="button" onClick="if(chkDate()){submitForm('cashRegister','account?method=printCashRegisterReport')};" accesskey="a" tabindex=1 />
<input type="button" name="OK" id="addbutton" value="OK" class="button" onClick="submitForm('cashRegister','account?method=displayCashBook');" accesskey="a" tabindex=1 />--%>
<input type="button" name="OK" id="addbutton" value="Print" class="button" onClick="submitForm('cashRegister','account?method=printIncomeExpenditureReport');" accesskey="a" tabindex=1 />
<!-- <input type="button" name="OK" id="addbutton" value="Print New" class="button" onClick="submitForm('cashRegister','account?method=printIncomeExpenditureReportNew');" accesskey="a" tabindex=1 />
 --></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
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
<script>
function hideUnhideIDiv(){
	if(document.getElementById("financialYearId").checked==true){
		document.getElementById("financialYearDivId").style.display="inline";
		document.getElementById("dateDivId").style.display="none";
		document.getElementById("fromDateId").value="<%=currentDate.toString()%>";
		document.getElementById("dateDivId").value="<%=currentDate.toString()%>";
	}else if(document.getElementById("dateId").checked==true){
		document.getElementById("financialYearDivId").style.display="none";
		document.getElementById("dateDivId").style.display="inline";
		document.getElementById("yearId").value="0";
	}
}
</script>