<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasLoan"%>

<%
			Map map = new HashMap();
			if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			List<HrMasLoan> loanList = new ArrayList<HrMasLoan>(); 
			if(map.get("loanList")!= null){
				loanList = (List)map.get("loanList");
			}
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			String userName = "";
			if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
			}
			if(map.get("message") != null){
			String message = (String)map.get("message");
			out.println(message);
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
<h2>Loan Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Loan
Code</label> <input type="radio" name="<%=SELECTED_RADIO %>" value="1"
	checked="checked" class="radioCheck" /> <label>Loan
Description</label> <input type="radio" name="<%=SELECTED_RADIO %>" value="2"
	class="radioCheck" /> <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value=""
	validate="Bonus Description,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'payrollMasters?method=searchLoan')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','payrollMasters?method=searchLoan','checkSearch')"
	tabindex=1 /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
if(loanList.size()>0)
{
String strForCode = (String)map.get("loanCode");
String strForCodeDescription = (String)map.get("loanDescription");
if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
{
%> <a href="payrollMasters?method=showLoanJsp">Show All Records</a> <%
}
}
if(loanList.size()==0 && map.get("search") != null)
{
%> <a href="payrollMasters?method=showLoanJsp">Show All Records</a> <%
}
%> <script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= MAXIMUM_AMOUNT%>"],[4,"<%= INTEREST_PERCENT%>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"],];
statusTd = 8;
</script></div>
<div class="clear"></div>
<div class="division"></div>

<form name="loan" method="post" action="">
<div class="Block"><label><span>*</span> Loan Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="LoanCode,string,yes" MAXLENGTH="15" tabindex=1 /> <label
	id=biglabel><span>*</span> Loan Description</label> <input type="text"
	name="<%= SEARCH_NAME %>" value=""
	validate="Loan Description,string,yes" MAXLENGTH="25" tabindex=1 /> <script>
document.loan.<%=CODE%>.focus();
</script> <label><span>*</span>Max.Amount</label> <input type="text"
	name="<%= MAXIMUM_AMOUNT%>" value="" validate="Max.Amount,float,yes"
	MAXLENGTH="9" tabindex=1 />
<div class="clear"></div>
<label><span>*</span> Interest Percent</label> <input type="text"
	name="<%= INTEREST_PERCENT%>" value="" validate="Interest%,float,yes"
	MAXLENGTH="5" tabindex=1 />

<div class="clear"></div>
</div>

<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('loan','payrollMasters?method=saveLoan','checkFromDate');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button" style="display: none;"
	onClick="submitForm('loan','payrollMasters?method=editLoan','checkFromDate');"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('loan','payrollMasters?method=deleteLoan&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Loan Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Description"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= SEARCH_NAME %>";


data_header[2] = new Array;
data_header[2][0] = "Max.Amount%"
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%= MAXIMUM_AMOUNT %>"

data_header[3] = new Array;
data_header[3][0] = "Interest%"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%= INTEREST_PERCENT %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";



data_arr = new Array();

<%


Iterator itr=loanList.iterator();
int  counter=0;
while(itr.hasNext())
{


HrMasLoan hrMasLoan= (HrMasLoan)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasLoan.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasLoan.getLoanCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasLoan.getLoanDescription()%>"
data_arr[<%= counter%>][3] = "<%= hrMasLoan.getMaxAmount()%>"
data_arr[<%= counter%>][4] = "<%= hrMasLoan.getInterestPercent()%>"
data_arr[<%= counter%>][5] = "<%= hrMasLoan.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasLoan.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= hrMasLoan.getLastChgTime() %>"


<% 

if(hrMasLoan.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

<%

counter++;
}
%>

formName = "loan"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
