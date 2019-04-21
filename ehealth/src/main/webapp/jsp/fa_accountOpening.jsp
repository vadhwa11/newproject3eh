<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%
			Map<String,Object> map = new HashMap<String,Object>();
			Map<String,Object> utilMap = new HashMap<String,Object>();
			if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			}
			
			List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
			List<FaMasSubLed> subLedList = new ArrayList<FaMasSubLed>();
			List<FaAccountOpening> faAccountOpeningList = new ArrayList<FaAccountOpening>();
			if(map.get("accountList")!= null){
				accountList = (List)map.get("accountList");
			}
			if(map.get("subLedList")!= null){
				subLedList = (List)map.get("subLedList");
			}
			if(map.get("faAccountOpeningList")!= null){
				faAccountOpeningList = (List)map.get("faAccountOpeningList");
			}
			String openingNo = "";
			if(map.get("openingNo")!= null){
				openingNo = (String)map.get("openingNo");
			}
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			String userName = "";
			if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
			}
			%>
<% 
			if(map.get("message") != null){
			String message = (String)map.get("message");
			%>

<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="jkt.hms.masters.business.FaAccountOpening"%>
<%@page import="java.math.BigDecimal"%><h4><span><%=message %></span></h4>
<%
			}
%>
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


<div class="titleBg">
<h2>Account Opening</h2>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript">
formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%= OPENING_NO%>"], [2,"<%= OPENING_DATE %>"],[3,"<%= ACCOUNT_ID%>"],[4,"<%= SUBLEDGER_ID%>"],[5,"<%= OPENING_BALANCE%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"accountType"],[10,"<%=STATUS%>"]];
statusTd =10;
</script></div>
 
<div class="clear"></div>
<div class="division"></div>
<form name="accountOpening" method="post" action="">
<div class="Block"><label><span>*</span> Opening No</label> 
<input type="text" name="<%=OPENING_NO %>" readonly="readonly" value="<%=openingNo %>"	validate="opening No,string,yes" MAXLENGTH="15" tabindex=1 />
<label> Opening Date </label> 
<input type="text"	name="<%=OPENING_DATE %>" value="<%=date %>" class="date" readonly="readonly"	validate="Opening Date  ,date,no" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.accountOpening.<%=OPENING_DATE%>,event)" /> 
<label><span>*</span> Account</label> 
<select	name="<%=ACCOUNT_ID %>" validate="Account,string,yes" onChange="populateSubLedger(this.value,'accountOpening')">
<option value="">Select</option>
<%if(accountList.size()>0){
	for(FaMasAccount faMasAccount :accountList){
	%>
	<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc().trim() %></option>
<%}
	}%>
</select> 
<script type="text/javascript">
         var subLedgerArray1 = new Array();
		<%
			int count = 0;
		for (FaMasAccount faMasAccount:accountList)
			{

				for (FaMasSubLed faMasSubLed:subLedList)
				{

					if(faMasAccount.getId().equals(faMasSubLed.getAccount().getId())){
								%>
									subLedgerArray1[<%=count%>] = new Array();
									subLedgerArray1[<%=count%>][0] = <%=faMasAccount.getId()%>;
									subLedgerArray1[<%=count%>][1] = <%=faMasSubLed.getId()%>;
									subLedgerArray1[<%=count%>][2] = "<%=faMasSubLed.getSubLedDesc()%>";

								<%
								count++;
						}	} } %>
		</script>

<div class="clear"></div>
<label>Sub Ledger</label> 
<select	name="<%=SUBLEDGER_ID %>" validate="Sub ledger,string,no">
<option value="">Select</option>
<%if(subLedList.size()>0){
	for(FaMasSubLed faMasSubLed :subLedList){
	%>
	<option value="<%=faMasSubLed.getId() %>"><%=faMasSubLed.getSubLedDesc().trim() %></option>
<%}
	}%>
</select> 

<label><span>*</span>Opening Balance</label>
<input type="text" id="openingBalanceId" name="<%=OPENING_BALANCE %>" validate="Opening Balance,float,yes" class="auto" size="14" value="" MAXLENGTH="11"  />
<select name="accountType" class="smallest" >
			<option value="0">Select</option>
			<option value="Dr" selected="selected">Dr</option>
			<option value="Cr">Cr</option>
			</select>
<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('accountOpening','account?method=saveAccountOpening');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('accountOpening','account?method=updateAccountOpening')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('accountOpening','account?method=deleteAccountOpening&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> 

<label>Changed Date</label> 
<label class="value"><%=date%></label> 
<label>Changed Time</label> 
<label class="value"><%=time%></label> 

<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Openining No"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= openingNo%>"

data_header[1] = new Array;
data_header[1][0] = "Opening Date"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= OPENING_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "Account"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%= ACCOUNT_ID %>"

data_header[3] = new Array;
data_header[3][0] = "Sub Ledger"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= SUBLEDGER_ID %>"

data_header[4] = new Array;
data_header[4][0] = "Opening Balance"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= OPENING_BALANCE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Account Type"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "accountType";

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS %>";




data_arr = new Array();

<%


Iterator itr=faAccountOpeningList.iterator();
int  counter=0;
while(itr.hasNext())
{


FaAccountOpening accountOpening= (FaAccountOpening)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= accountOpening.getId()%>
data_arr[<%= counter%>][1] = "<%=accountOpening.getOpeningNo()%>"
data_arr[<%= counter%>][2] = "<%=  HMSUtil.convertDateToStringWithoutTime(accountOpening.getOpeningDate())%>"
<%if(accountList.size()>0){
	for(FaMasAccount masAccount :accountList){
	if(masAccount.getId().equals(accountOpening.getAccount().getId())){	
		

		 StringBuffer output_str1 = new StringBuffer();
		 StringTokenizer s1 = new StringTokenizer((masAccount.getAccDesc().trim()).toString(),"\"");

		 while (s1.hasMoreTokens())
		 {
		 output_str1.append(s1.nextToken());
		 if (s1.hasMoreTokens())
		 {
		 output_str1.append("\\");
		 output_str1.append("\"");
		 }
		 }
		%>


data_arr[<%= counter%>][3] = "<%=output_str1%>"
<%}}}%>
<%if(subLedList.size()>0){
	for(FaMasSubLed masSubLed:subLedList){
		if(accountOpening.getSubLedger() != null)
		{
	if(masSubLed.getId().equals(accountOpening.getSubLedger().getId())){	
	
%>
data_arr[<%= counter%>][4] = "<%=masSubLed.getSubLedDesc().trim()%>"
	<%}}else{%>
	data_arr[<%= counter%>][4] = ""
	<%}}}%>
<%
if(accountOpening.getOpeningAmtDr()!= null && (accountOpening.getOpeningAmtDr().compareTo(new BigDecimal(0.00))>0)){
	%>
data_arr[<%= counter%>][5] = "<%= accountOpening.getOpeningAmtDr()%>"
<%}else {
%>
data_arr[<%= counter%>][5] = "<%= accountOpening.getOpeningAmtCr()%>"
<%}%>
data_arr[<%= counter%>][6] = "<%= accountOpening.getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(accountOpening.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= accountOpening.getLastChgTime() %>"
<%if(accountOpening.getOpeningAmtDr() != null && (accountOpening.getOpeningAmtDr().compareTo(new BigDecimal(0.00))>0)){%>
data_arr[<%= counter%>][9] = "Dr"
<%}else{%>
data_arr[<%= counter%>][9] = "Cr"
<%}%>

<% 

if(accountOpening.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>

<%
counter++;
}
%>

formName = "accountOpening"


start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

