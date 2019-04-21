<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_instructorMaster.jsp  
 * Purpose of the JSP -  This is for Instructor details 
 * @author  Rajendra
 * Create Date: 23rd Dec,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>

<%@page import="jkt.hrms.masters.business.HrEmployeeOtherEarning"%>
<%@page import="jkt.hrms.masters.business.HrMasItaxCheckCode"%>
<%@page import="jkt.hrms.masters.business.HrMasItaxIncomeCode"%>

<script>
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
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String sdate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	List<HrEmployeeOtherEarning> searchEmployeeOtherEarningList = new ArrayList<HrEmployeeOtherEarning>();
	List<HrMasItaxCheckCode> hrMasItaxCheckCodeList = new ArrayList<HrMasItaxCheckCode>();
	List<HrMasItaxIncomeCode> hrMasItaxIncomeCodeList = new ArrayList<HrMasItaxIncomeCode>();
	List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
	List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("searchEmployeeOtherEarningList")!=null)
	{
		searchEmployeeOtherEarningList =(List<HrEmployeeOtherEarning>)map.get("searchEmployeeOtherEarningList");
	}
	if(map.get("hrMasItaxCheckCodeList")!=null)
	{
		hrMasItaxCheckCodeList =(List<HrMasItaxCheckCode>)map.get("hrMasItaxCheckCodeList");
	}
	if(map.get("hrMasItaxIncomeCodeList")!=null)
	{
		hrMasItaxIncomeCodeList =(List<HrMasItaxIncomeCode>)map.get("hrMasItaxIncomeCodeList");
	}
	if(map.get("hrMasFinancialYearList")!=null)
	{
		hrMasFinancialYearList =(List<HrMasFinancialYear>)map.get("hrMasFinancialYearList");
	}
	if(map.get("masEmployeeList")!=null)
	{
		masEmployeeList =(List<MasEmployee>)map.get("masEmployeeList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("message") != null) {
		String message = (String) map.get("message");
		out.println(message);
	}
%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<div class="titleBg">
<h2>Employee Other Earning/Deduction</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Employee
Code</label> <input type="text" id="searchField" name="<%= SEARCH_FIELD%>"
	value="" validate="Training Code,string,no" MAXLENGTH="8" tabindex=1 />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','incomeTaxMaster?method=searchIncomeTaxExemptMaster','checkSearch')"
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
 		if (searchEmployeeOtherEarningList.size() > 0) {
 			
 			String financialYr = (String) map.get("financialYear");
 			
 			if (financialYr != null && financialYr != "" ) 
 			{
 	%>
<h4><a href="incomeTaxMaster?method=showEmployeeOtherEarningJsp">Show
All Records</a></h4>
<%
			}
		}
		if (searchEmployeeOtherEarningList.size() == 0
				&& map.get("search") != null) {
	%>
<h4><a href="incomeTaxMaster?method=showEmployeeOtherEarningJsp">Show
All Records</a></h4>

<%
    	}
    %> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],  [1,"<%= SEARCH_NAME %>"],  [2,"<%= CODE %>"], [3,"checkCode"], [4,"financialYear"],[5,"incomeAmount"], [6,"incomeDate"],[7,"<%= CHANGED_BY%>"],[8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"],[10,"<%=STATUS%>"] ];
	 statusTd = 10;
	</script></div>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<form name="empotherEarnings" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="" /> <input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="" /> <input type="hidden"
	name="title" value="IT Exemption" /> <input type="hidden"
	name="<%=JSP_NAME %>" value="" /> <input type="hidden"
	name="pojoPropertyCode" value="" /> <label><span>*</span>Employee</label>
<select name="<%= SEARCH_NAME %>" validate="Employee,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%if(masEmployeeList != null)
			{
				for(MasEmployee masEmployee : masEmployeeList)	
				{%>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+" "+masEmployee.getLastName() %></option>
	<% }
			}
			%>
</select> <label><span>*</span>Income Code</label> <select name="<%= CODE %>"
	validate="Employee,string,yes" tabindex=1>
	<option value="">Select</option>
	<%if(hrMasItaxIncomeCodeList != null)
			{
				for(HrMasItaxIncomeCode hrMasItaxIncomeCode : hrMasItaxIncomeCodeList)	
				{%>
	<option value="<%=hrMasItaxIncomeCode.getId()%>"><%=hrMasItaxIncomeCode.getIncomeDesc() %></option>
	<% }
			}
			%>
</select> <label><span>*</span>Check Code</label> <select name="checkCode"
	validate="Employee,string,yes" tabindex=1>
	<option value="">Select</option>
	<%if(hrMasItaxCheckCodeList != null)
			{
				for(HrMasItaxCheckCode hrMasItaxCheckCode : hrMasItaxCheckCodeList)	
				{%>
	<option value="<%=hrMasItaxCheckCode.getId()%>"><%=hrMasItaxCheckCode.getCheckCodeDesc() %></option>
	<% }
			}
			%>
</select>

<div class="clear"></div>


<label><span>*</span>Financial Year</label> <select name="financialYear"
	validate="Financial Year,string,yes" tabindex=1>
	<option value="">Select</option>
	<%if(hrMasFinancialYearList != null)
			{
				for(HrMasFinancialYear hrMasFinancial : hrMasFinancialYearList)	
				{%>
	<option value="<%=hrMasFinancial.getId()%>"><%=hrMasFinancial.getFinancialYear() %></option>
	<% }
			}
			%>
</select> <label><span>*</span>Income Amount</label> <input type="text"
	name="incomeAmount" value="" validate="Income Amount,string,no"
	class="textbox_size20" MAXLENGTH="6" tabindex=1 /> <label><span>*</span>
Income Date</label> <input type="text" name="incomeDate" readonly
	validate='Income Date,date,yes' value="" class="date" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	id="calToDate"
	onclick="javascript:setdate('',document.empotherEarnings.incomeDate,'event')" />


<script>
				document.search.<%=SEARCH_FIELD%>.focus();
			</script>

<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="division"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('empotherEarnings','incomeTaxMaster?method=addEmployeeOtherEarning');"
	accesskey="a" tabindex=1 />

<input type="button" name="edit" id="editbutton" value="Update"
	style="display: none;" class="button"
	onClick="submitForm('empotherEarnings','incomeTaxMaster?method=editEmployeeOtherEarning')"
	accesskey="u" tabindex=1 />

<input type="button" name="Delete" id="deletebutton" value="Activate"
	style="display: none;" class="button"
	onClick="submitForm('empotherEarnings','incomeTaxMaster?method=deleteEmployeeOtherEarning&flag='+this.value)"
	accesskey="d" tabindex=1 />

<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=sdate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=sdate%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Employee"
data_header[0][1] = "data";
data_header[0][2] = "";
data_header[0][3] = "<%= SEARCH_NAME %>"

data_header[1] = new Array;
data_header[1][0] = "Income Code"
data_header[1][1] = "data";
data_header[1][2] = "";
data_header[1][3] = "<%= CODE%>";

data_header[2] = new Array;
data_header[2][0] = "Check Code"
data_header[2][1] = "data";
data_header[2][2] = "";
data_header[2][3] = "checkCode";

data_header[3] = new Array;
data_header[3][0] = "Year"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "financialYear";

data_header[4] = new Array;
data_header[4][0] = "Income Amount"
data_header[4][1] = "data";
data_header[4][2] = "";
data_header[4][3] = "incomeAmount";

data_header[5] = new Array;
data_header[5][0] = "Income Date"
data_header[5][1] = "data";
data_header[5][2] = "";
data_header[5][3] = "incomeDate";

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
data_header[8][2] = "";
data_header[8][3] = "<%=CHANGED_TIME %>";

data_header[9] = new Array;
data_header[9][0] = "Status"
data_header[9][1] = "data";
data_header[9][2] = "";
data_header[9][3] = "<%=STATUS %>";



data_arr = new Array();

<%
Iterator itr=searchEmployeeOtherEarningList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrEmployeeOtherEarning  hrEmployeeOtherEarning = (HrEmployeeOtherEarning)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrEmployeeOtherEarning.getId()%>
<%
	for(MasEmployee masEmployee :masEmployeeList){
		if(hrEmployeeOtherEarning.getEmp().getId().equals(masEmployee.getId())){
%>

data_arr[<%= counter%>][1] = "<%=masEmployee.getFirstName()+" "+masEmployee.getLastName()+" "+masEmployee.getLastName() %>"
<% 
	}
   }		

%>
<%
	for(HrMasItaxIncomeCode hrMasItaxIncomeCode :hrMasItaxIncomeCodeList){
		if(hrEmployeeOtherEarning.getIncomeCode().getId().equals(hrMasItaxIncomeCode.getId())){
%>

data_arr[<%= counter%>][2] = "<%=hrMasItaxIncomeCode.getIncomeDesc()%>"
<% 
	}
   }		

%>

<%
	for(HrMasItaxCheckCode hrMasItaxCheckCode :hrMasItaxCheckCodeList){
		if(hrEmployeeOtherEarning.getCheckCode().getId().equals(hrMasItaxCheckCode.getId())){
%>

data_arr[<%= counter%>][3] = "<%=hrMasItaxCheckCode.getCheckCodeDesc()%>"
<% 
	}
   }		
%>
 
 <%
	for(HrMasFinancialYear hrMasFinancialYear :hrMasFinancialYearList){
		if(hrEmployeeOtherEarning.getFinancialYear().getId().equals(hrMasFinancialYear.getId())){
%>

data_arr[<%= counter%>][4] = "<%=hrMasFinancialYear.getYearDescription()%>"
<% 
	}
   }		
%>
data_arr[<%= counter%>][5] = "<%= hrEmployeeOtherEarning.getIncomeAmount()%>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(hrEmployeeOtherEarning.getIncomeDate())%>"
data_arr[<%= counter%>][7] = "<%= hrEmployeeOtherEarning.getLastChgBy() %>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(hrEmployeeOtherEarning.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= hrEmployeeOtherEarning.getLastChgTime() %>"
<% if(hrEmployeeOtherEarning.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>


<%
		     counter++;
}
%>
 
formName = "empotherEarnings"

nonEditable = [];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
