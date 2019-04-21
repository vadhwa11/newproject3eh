<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed;"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"> </script>
<script language=javascript src="/hms/jsp/js/common.js" type=text/javascript></script>
<script language=javascript src="/hms/jsp/js/hms.js"	type=text/javascript></script> 
<script language=javascript	src="/hms/jsp/js/calendar.js" type=text/javascript></script> 

<SCRIPT>
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
		</SCRIPT>

	<%
		Map<String,Object> map = new HashMap<String,Object>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed> subledgerList = new ArrayList<FaMasSubLed>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		
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


<form name="ledAnalysisreport" method="post" action="">
<div class="titleBg"> <h2>Ledger Analysis</h2></div>
<div class="Block"> 

<label><span>*</span>Account</label>
<select id="mainAccountId"  name="<%=ACCOUNT_ID%>" onchange="populateSubLedger(this.value,'ledAnalysisreport')"  >
	<option value="0">Select</option>
	<%if(accountList.size()>0){
		for(FaMasAccount faMasAccount :accountList){
			
		%>
	<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>
		
	<%	}
	}
		%>
		
	<script type="text/javascript">
          subLedgerArray = new Array();
		<%
			int count1 = 0;
		for (FaMasAccount faMasAccount :accountList)
			{

				for (FaMasSubLed faMasSubLed :subledgerList)
				{

					if(faMasAccount.getId().equals(faMasSubLed.getAccount().getId())){
								%>
									subLedgerArray[<%=count1%>] = new Array();
									subLedgerArray[<%=count1%>][0] = <%=faMasAccount.getId()%>;
									subLedgerArray[<%=count1%>][1] = <%=faMasSubLed.getId()%>;
									subLedgerArray[<%=count1%>][2] = "<%=faMasSubLed.getSubLedDesc()%>";

								<%
								count1++;
						}	} } %>
		</script>	
		
</select>

<label><span>*</span> Sub-Ledger </label>
<select id="subLedgerId"  name="<%=SUB_LEDGER_ID %>" >
	<option value="0">Select</option>
	<%if(subledgerList.size()>0){
		for(FaMasSubLed faMasSubLed :subledgerList){
			
		%>
	<option value="<%=faMasSubLed.getId() %>"><%=faMasSubLed.getSubLedDesc() %></option>
		
	<%	}
	}
		%>
</select>

<dr>
<div class="clear"></div>
<label><span>*</span> From Date</label> 
<input type="text" name="<%= FROM_DATE%>" value="<%=date %>" validate="From Date,yes" class="date" MAXLENGTH="30" readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=FROM_DATE%>',document.ledAnalysisreport.<%=FROM_DATE%>,true);" />

<label><span>*</span> To Date</label> 
<input type="text" name="<%= TO_DATE%>" value="<%=date %>" validate="To Date,yes"	class="date" MAXLENGTH="30" readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=TO_DATE%>',document.ledAnalysisreport.<%=TO_DATE%>,true);" />


<div class="clear"></div>

</div>
<div class="division"></div>
<%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('ledAnalysisreport','account?method=printBankVoucherReport');" accesskey="g" tabindex=1 />
<input type="reset" name="clear"  id="clearbutton" value="Clear" class="buttonHighlight"  accesskey="a"  tabindex=1 />
<div class="clear"></div>
<div class="division"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
