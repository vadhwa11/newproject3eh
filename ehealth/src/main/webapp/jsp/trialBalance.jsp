<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>

<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>



<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<FaMasAccountGroup> accountGroupList = new ArrayList<FaMasAccountGroup>();
	List<FaMasAccountSubGroup> accountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("accountGroupList")!= null){
		accountGroupList = (List<FaMasAccountGroup>)map.get("accountGroupList");
	}
	if(map.get("accountSubGroupList")!= null){
		accountSubGroupList = (List<FaMasAccountSubGroup>)map.get("accountSubGroupList");
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

<form name="trialBalance" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<h2>Trial Balance</h2>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Group</label>
<%-- <select id="accountTypeId"  name="accountType"  onchange="displayTrialBalanceAccountTypeWise(this.value);">--%>
<select id="accountTypeId"  name="accountType"  >
	<option value="0">Select</option>
	<option value="group">Group Wise</option>
	<option value="subgroup">SubGroup Wise</option>
	<option value="account">Ledger Wise</option>	
</select>
<div class="clear"></div>
<input type="hidden" name="accountName" id="accountNameId" value=""/>
<label><span>*</span>From Date:</label>
<input type="text" name="<%=FROM_DATE %>" id="fromDate" value="01/04/2016" class="calDate" tabindex=1 readonly="readonly" validate="From Date ,date,yes" MAXLENGTH="30" />
<img width="16" height="16" border="0" onclick="javascript:setdate('01/04/2016',document.trialBalance.<%=FROM_DATE %>,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">

<label><span>*</span>To Date:</label>
<input type="text" name="<%=TO_DATE %>" id="toDate" value="31/03/2017" class="calDate" tabindex=1 readonly="readonly" validate="To Date ,date,yes" MAXLENGTH="30" />
<img width="16" height="16" border="0" onclick="javascript:setdate('31/03/2017',document.trialBalance.<%=TO_DATE %>,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">

<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="OK" id="addbutton" value="OK" class="button" onClick="submitForm('trialBalance','account?method=getTrialBalance');" accesskey="a" tabindex=1 />
<input type="button" name="OK" id="addbutton" value="Print" class="button" onClick="submitForm('trialBalance','account?method=printTrialReport');" accesskey="a" tabindex=1 />
</div>
<%-- 
<div id="testDiv">


</div>
--%>
<script type="text/javascript">
 	function displayTrialBalanceAccountTypeWise(val){
 	 	
 		submitForm('trialBalance','account?method=getTrialBalance&val='+val);
 		
 	}

</script>
</form>