<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"> </script>
<script language=javascript src="/hms/jsp/js/common.js" type=text/javascript></script>
<script language=javascript src="/hms/jsp/js/hms.js"	type=text/javascript></script> 
<script language=javascript	src="/hms/jsp/js/calendar.js" type=text/javascript></script>
 
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<script type="text/javascript">
function check(){
var SDate = document.bankBook.<%= FROM_DATE%>.value;
var EDate = document.bankBook.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))
if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
	<%
		Map<String,Object> map = new HashMap<String,Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		
		if(map.get("accountList")!= null){
			accountList = (List<FaMasAccount>)map.get("accountList");
		}
		String message = "";
		
		if (map.get("message") != null) {
			 message = (String) map.get("message");
			out.println(message);
		}
	%> 


<form name="bankBook" method="post" action="">
<div class="titleBg">
<h2>Bank Book</h2>
</div>
<div class="Block"> 
<label><span>*</span>Bank Account</label>
<select id="mainAccountId"  name="<%=ACCOUNT_ID %>" validate="Bank Account,string,yes" onchange="getAccountName();">
	<option value="">Select</option>
	<%if(accountList.size()>0){
		for(FaMasAccount faMasAccount :accountList){
			
		%>
	<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>
		
	<%	}
	}
		%>
</select>

<input type="hidden" name="accountName" id="accountNameId" value=""/>
<input type="hidden" name="accId" id="accId" value=""/>
<div class="clear"></div>
<label><span>*</span> From Date</label> 
<input type="text" name="<%= FROM_DATE%>" id="from_date" value="" validate="From Date,date,yes" class="date" MAXLENGTH="30" readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.bankBook.<%=FROM_DATE%>,event)" />

<label><span>*</span> To Date</label> 
<input type="text" name="<%= TO_DATE%>" id="to_date"  value="" validate="To Date,date,yes"	class="date" MAXLENGTH="30" readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.bankBook.<%=TO_DATE%>,event)" />
<div class="clear"></div>

<div class="division"></div>
<%--- Report Button   --%>
<%-- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="if(chkDate()){submitForm('report','account?method=printBankVoucherReport','displayFinancialYearMsg')};" accesskey="g" tabindex=1 />--%>
<%--<input type="button" name="OK" id="addbutton" value="OK" class="button" onClick="submitForm('bankBook','account?method=displayBankBook');" accesskey="a" tabindex=1 /> --%>
<input type="button" name="OK" id="addbutton" value="Print" class="button" onClick="submitForm('bankBook','account?method=printBankBookReport','check();');" accesskey="a" tabindex=1 />
<input type="reset" name="clear"  id="clearbutton" value="Clear" class="buttonHighlight"  accesskey="a"  tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
</div>

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