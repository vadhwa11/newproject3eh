<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * budget.jsp  
 * Purpose of the JSP -  This is for Budget Details
 * @author  Deepali
 * @author  Mansi
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@ page import="jkt.hms.masters.business.MasStoreBudget"%>


<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<style>
#contentspace label {
	text-align: right;
	padding-right: 10px;
	width: 130px;
	float: left;
	height: 9px;
}
</style>
<div id="contentspace">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasStoreFinancial> financialList = new ArrayList<MasStoreFinancial>();
	financialList = (ArrayList)map.get("financialList");
	
	ArrayList searchBudgetList = (ArrayList)map.get("searchBudgetList");
	ArrayList gridFinancialList = (ArrayList)map.get("gridFinancialList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }

%>
<h2 align="left" class="style1">Budget Master</h2>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="bodytextB_blue">Budget Code:</font> <input type="text"
	id="searchField" name="<%= CODE%>" value=""
	validate="Budget Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'pharmacy?method=searchBudget')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','pharmacy?method=searchBudget','checkSearch')"
	tabindex=1 /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>

</div>

<br />

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchBudgetList.size() > 0)
		 {
			String strForCode = (String)map.get("budgetCode");
			if(strForCode!= null && strForCode!= "" )
			{
	%> <br />

<a href="pharmacy?method=showBudgetJsp">Show All Records</a> <%
			}
		 }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= FINANCIAL_ID %>"], [3,"<%= TOTAL_ALLOCATED_AMOUNT %>"], [4,"<%= CRV_COMMITTED_AMOUNT%>"], [5,"<%= UTILIZED_AMOUNT %>"],[6,"<%= PO_COMMITTED_AMOUNT %>"],[7,"<%=CHANGED_BY%>"],[8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"],[10,"<%= STATUS %>"]];
	 statusTd = 10;
	</script></div>
<br />
<form name="budget" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden"
	name="<%= POJO_NAME %>" value="MasStoreBudget"><input
	type="hidden" name="title" value="Budget"><input type="hidden"
	name="<%=JSP_NAME %>" value="budgetEntry"><input type="hidden"
	name="pojoPropertyCode" value="BudgetCode"><br>
<div id=contentoperation><label class="bodytextB_blue"><font
	id="error">*</font>Budget Code</label> <input id="codeId" type="text"
	name="<%= CODE%>" value="" validate="Budget Code,string,yes"
	class="textbox_size20" MAXLENGTH="8" / tabindex=1><script>
				document.budget.<%=CODE%>.focus();
			</script> <label class="bodytextB_blue"><font id="error">*</font>Financial
Year:</label> <select name="<%= FINANCIAL_ID %>"
	validate="Financial Year,string,yes" tabindex=1>
	<option value="0">Select</option>
	<% 
			for (MasStoreFinancial  masStoreFinancial : financialList){
			%>
	<option value="<%=masStoreFinancial.getId ()%>"><%=HMSUtil.changeDateToddMMyyyy(masStoreFinancial.getStartDate()) %></option>
	<%}%>
</select> <label class="bodytextB_blue"><font id="error">*</font>Total
Allocated Amt</label> <input type="text" name="<%= TOTAL_ALLOCATED_AMOUNT%>"
	value="" validate="Total Allocated Amt,float,yes"
	class="textbox_size20" MAXLENGTH="8" / tabindex=1><br> <label
	class="bodytextB_blue"><font id="error">*</font>CRV Comitted
Amt</label> <input type="text" name="<%= CRV_COMMITTED_AMOUNT%>" value=""
	validate="CRV Comitted Amt,float,yes" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1><label class="bodytextB_blue">Utilized
Amt</label> <input type="text" name="<%= UTILIZED_AMOUNT%>" value=""
	validate="Utilized Amt,float,no" class="textbox_size20" MAXLENGTH="8"
	/ tabindex=1><label class="bodytextB_blue">PO Commited
Amt</label> <input type="text" name="<%= PO_COMMITTED_AMOUNT%>" value=""
	validate="PO Commited Amt,float,no" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1
	onkeypress="return submitenter(this,event,'pharmacy?method=addBudget')"><br />
<br />
<label class="bodytextB_blue">Changed By:</label> <input type="text"
	name="<%= CHANGED_BY%>" value="<%=userName%>" class="readOnly"
	readonly="readonly" MAXLENGTH="8" / tabindex=3 /> <label id=biglabel
	class="bodytextB_blue">Changed Date:</label> <input type="text"
	name="<%= CHANGED_DATE %>" value="<%=date%>" class="readOnly"
	readonly="readonly" tabindex=3 /> <label class="bodytextB_blue">Changed
Time:</label> <input type="text" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="readOnly" readonly="readonly" tabindex=3 /></div>

<br />

<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('budget','pharmacy?method=addBudget');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('budget','pharmacy?method=editBudget')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('budget','pharmacy?method=deleteBudget&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" /> <br /></form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Budget Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "FinancialYear"
data_header[1][1] = "hide";
data_header[1][2] = 0;
data_header[1][3] = "<%= FINANCIAL_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Total Allocated Amount"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%=TOTAL_ALLOCATED_AMOUNT %>";

data_header[3] = new Array;
data_header[3][0] = "CRV Comitted Amount"
data_header[3][1] = "data";
data_header[3][2] = "25%";
data_header[3][3] = "<%=CRV_COMMITTED_AMOUNT %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=PO_COMMITTED_AMOUNT %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=CHANGED_BY %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_DATE %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_TIME %>"

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "data";
data_header[9][2] = 0;
data_header[9][3] = "<%=STATUS %>"

data_arr = new Array();

<%
Iterator itr=searchBudgetList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasStoreBudget  masStoreBudget = (MasStoreBudget)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStoreBudget.getId()%>

<% if(masStoreBudget.getBudgetCode() != null){%>
data_arr[<%= counter%>][1] = "<%=masStoreBudget.getBudgetCode()%>"
<%}%>

<% if(masStoreBudget.getFinancial() != null){%>
<%
		Iterator itrGridFinancialList=gridFinancialList.iterator();
		 while(itrGridFinancialList.hasNext())
            {try{
             MasStoreFinancial  financialGrid = (MasStoreFinancial)itrGridFinancialList.next(); 
			 if(masStoreBudget.getFinancial().getId().equals(financialGrid.getId()) && financialGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%=financialGrid.getStartDate()%>"
			<%}else if(masStoreBudget.getId().equals(financialGrid.getId()) && financialGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=financialGrid.getStartDate()%>";
				
			<%}
            }catch(Exception e){}}%>
            <%}%>
<% if(masStoreBudget.getTotalAllocatedAmount() != null){%>           
data_arr[<%= counter%>][3] = <%= masStoreBudget.getTotalAllocatedAmount()%>
 <%}%>
<% if(masStoreBudget.getCrvComittedAmount() != null){%>
data_arr[<%= counter%>][4] = <%= masStoreBudget.getCrvComittedAmount()%>
 <%}%>
<% if(masStoreBudget.getUtilizedAmount() != null){%>
data_arr[<%= counter%>][5] = <%= masStoreBudget.getUtilizedAmount()%>
 <%}%>
<% if(masStoreBudget.getPoComittedAmount() != null){%>
data_arr[<%= counter%>][6] = <%= masStoreBudget.getPoComittedAmount()%>
 <%}%>
data_arr[<%= counter%>][7] = "<%= masStoreBudget.getLastChgBy() %>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(masStoreBudget.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= masStoreBudget.getLastChgTime() %>"
<% if(masStoreBudget.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "budget"

nonEditable = ['<%=CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>