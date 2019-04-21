<%@page import="jkt.hms.masters.business.MasScheme"%>
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
	List<MasScheme>schemeList=new ArrayList<MasScheme>();
	if(map.get("schemeList")!= null){
		schemeList = (List<MasScheme>)map.get("schemeList");
	}
	System.out.println("schemeList.size() ------ ----- -->>>"+schemeList.size());
%>


<form name="cashRegister" method="post" action="">
<div class="clear"></div>
<h2>SOE Report</h2>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label>Scheme Wise</label>
<input type="radio" name="SoeSLScheeme" id="soeReportId" onclick="getShemenWiseReport()" />
<label>Sub-Ledger Wise</label>
<input type="radio" name="SoeSLScheeme" id="soeReportId2" onclick="getShemenWiseReport()" />
<div class="clear"> </div>
<div id="slId2" style="display: none;">
<label><span>*</span>Account</label> 
<%--<select name="year" id="yearId">
<option value="0">Select</option>
<%for(MasStoreFinancial msf:financialList){ %>
<option value="<%=msf.getId()%>"><%=msf.getFinancialYear() %></option>
<%} %>
</select>
 --%>
 <input id="accountNameId" type="text" size="42"  name="accountName" value=""  tabindex=1 onblur="validateAccountName(this.value)"  />

				<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('accountNameId','ac2update','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'});
			</script>
 <div id="SLDiv">
  </div>
  </div>
  <div id="schemeId2" style="display: none;">
  <label>Scheme</label>
  <select name="schemeName" id="schemeId">
  <option value="0">Select</option>
  <%for(MasScheme scheme:schemeList){ %>
  <option value="<%=scheme.getId()%>"><%=scheme.getSchemeName()%></option>
  <%} %>
  </select>
<%--   <label><span>*</span>Account</label> 
<select name="year" id="yearId">
<option value="0">Select</option>
<%for(MasStoreFinancial msf:financialList){ %>
<option value="<%=msf.getId()%>"><%=msf.getFinancialYear() %></option>
<%} %>
</select>

 <input id="accountNameId" type="text" size="42"  name="accountName" value=""  tabindex=1 onblur="validateAccountName(this.value)"  />

				<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  	new Ajax.Autocompleter('accountNameId','ac2update','account?method=getAccountCodeForAutoComplete',{parameters:'requiredField=accountName'});
			</script> --%>
 <div id="SLDiv">
  </div>
  </div>
<label><span>*</span> From Date </label> 
<input	type="text" name="<%= FROM_DATE %>" value="<%=currentDate%>"	class="date" maxlength="30" tabindex=1 /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.cashRegister.<%= FROM_DATE%>,event);" />

<label><span>*</span> To Date </label> 
<input type="text"	name="<%= TO_DATE %>" value="<%=currentDate%>" class="date"	maxlength="30" tabindex=1 /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.cashRegister.<%= TO_DATE%>,true);" />

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
<div class="paddingTop5"></div>
<%-- <input type="button" name="add" id="addbutton" value="Print" class="button" onClick="if(chkDate()){submitForm('cashRegister','account?method=printCashRegisterReport')};" accesskey="a" tabindex=1 />
<input type="button" name="OK" id="addbutton" value="OK" class="button" onClick="submitForm('cashRegister','account?method=displayCashBook');" accesskey="a" tabindex=1 />--%>
<input type="button" name="OK" id="addbutton" value="Print" class="button" onClick="submitForm('cashRegister','account?method=printSOEReport');" accesskey="a" tabindex=1 />
<%--<input type="button" name="OK" id="addbutton" value="Print New" class="button" onClick="submitForm('cashRegister','account?method=printIncomeExpenditureReportNew');" accesskey="a" tabindex=1 />
 --%></div>

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
 
function validateAccountName( strValue) {

 	if(strValue != "")
	{
 			var idx1 = strValue.lastIndexOf("[");
			var idx2 = strValue.lastIndexOf("]");
		   	var accountName = strValue.substring(0,idx1);

			idx1++;
			var id = strValue.substring(idx1,idx2);
			//alert("id=="+id);
		    if(id!="")
		    {
		    	//var flagForSL = document.getElementById('flagForSL').value;
		    	submitProtoAjaxWithDivName('cashRegister','account?method=getSubLedgerForAccount1&accName='+id,'SLDiv');
		    	//submitProtoAjaxWithDivName('paymentVoucher','account?method=getSubLedgerForAccount&accName='+encodeURIComponent(strValue)+'&rowVal='+inc+'&flagForSL11='+flagForSL,tdid+inc);
		    }
	}
}

 function getShemenWiseReport(){
	 if(document.getElementById('soeReportId').checked==true){
		 document.getElementById('schemeId2').style.display="inline";
		 document.getElementById('slId2').style.display="none";
		 document.getElementById('accountNameId').value="";
		 document.getElementById('resrate').value="0";
		 	 
	 }else if(document.getElementById('soeReportId2').checked==true){
		 document.getElementById('slId2').style.display="inline";
		 document.getElementById('schemeId2').style.display="none";
		 document.getElementById('schemeId').value="0";
	 }
		 
 }
 
</script>