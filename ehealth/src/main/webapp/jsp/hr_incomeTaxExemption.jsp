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
<%@page import="jkt.hrms.masters.business.HrMasItaxSlab"%>


<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	List<HrMasItaxExemption> searchItaxExemptMasterList = new ArrayList<HrMasItaxExemption>();
	List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
	if(map.get("searchItaxExemptMasterList")!=null)
	{
		searchItaxExemptMasterList =(List<HrMasItaxExemption>)map.get("searchItaxExemptMasterList");
	}
	if(map.get("hrMasFinancialYearList")!=null)
	{
		hrMasFinancialYearList =(List<HrMasFinancialYear>)map.get("hrMasFinancialYearList");
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
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<%@page import="jkt.hrms.masters.business.HrMasItaxExemption"%>
<div class="titleBg">
<h2>Income Tax Exemption</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Finacial
Year</label> <input type="text" id="searchField" name="<%= SEARCH_FIELD%>"
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
 		if (searchItaxExemptMasterList.size() > 0) {
 			
 			String financialYr = (String) map.get("financialYear");
 			
 			if (financialYr != null && financialYr != "" ) 
 			{
 	%>
<h4><a href="incomeTaxMaster?method=showIncomeTaxExemptJsp">Show
All Records</a></h4>
<%
			}
		}
		if (searchItaxExemptMasterList.size() == 0
				&& map.get("search") != null) {
	%>
<h4><a href="incomeTaxMaster?method=showIncomeTaxExemptJsp">Show
All Records</a></h4>

<%
    	}
    %> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],  [1,"<%= SEARCH_NAME %>"],  [2,"<%= CODE %>"], [3,"maxAmt"], [4,"exemptionPercent"],[5,"exemptionBase"], [6,"minAmt"],[7,"maxExemption"],[8,"<%= CHANGED_BY%>"],[9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"] ];
	 statusTd = 11;
	</script></div>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<form name="incomeTaxExempt" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="HrMasItaxExemption" /> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SectionCode" /> <input
	type="hidden" name="title" value="IT Exemption" /> <input
	type="hidden" name="<%=JSP_NAME %>" value="hr_incomeTaxExemption" /> <input
	type="hidden" name="pojoPropertyCode" value="ExemptionPercentage" /> <label><span>*</span>Section
Code</label> <input type="text" name="<%= CODE %>" value=""
	validate="Section Code,string,no" class="textbox_size20" MAXLENGTH="12"
	tabindex=1 /> <label><span>*</span> Financial Year</label> <select
	name="<%= SEARCH_NAME %>" validate="Financial Year,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%if(hrMasFinancialYearList != null)
			{
				for(HrMasFinancialYear hrMasFinancial : hrMasFinancialYearList)	
				{%>
	<option value="<%=hrMasFinancial.getId()%>"><%=hrMasFinancial.getFinancialYear() %></option>
	<% }
			}
			%>
</select>

<div class="clear"></div>

<label><span>*</span>Maximum Amount</label> <input type="text"
	name="maxAmt" value="" validate="Max.Amount,string,no"
	class="textbox_size20" MAXLENGTH="6" tabindex=1 /> <label><span>*</span>Minimum
Amount </label> <input type="text" name="minAmt" value=""
	validate="Min. Amount,string,no" class="textbox_size20" MAXLENGTH="6"
	/ tabindex=1 />
<div class="clear"></div>
<label><span>*</span>Exemption Base</label> <select name="exemptionBase"
	validate="Exemption Base,string,yes" tabindex=1>
	<option value="">Select</option>
	<option value="s">Salary</option>
	<option value="t">Tax Amount</option>
</select> <label><span>*</span>Exemption Percent</label> <input type="text"
	name="exemptionPercent" value=""
	validate="Exemption Percent,string,yes" class="textbox_size20"
	MAXLENGTH="30" / tabindex=1 /> <label><span>*</span>Max.
Exemption</label> <input type="text" name="maxExemption" value=""
	validate="Max. Exemption,string,yes" class="textbox_size20"
	MAXLENGTH="30" / tabindex=1 /> <script>
				document.incomeTaxExempt.<%=SEARCH_FIELD%>.focus();
			</script>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<div class="division"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('incomeTaxExempt','incomeTaxMaster?method=addIncomeTaxExemptJsp');"
	accesskey="a" tabindex=1 />

<input type="button" name="edit" id="editbutton" value="Update"
	style="display: none;" class="button"
	onClick="submitForm('incomeTaxExempt','incomeTaxMaster?method=editIncomeTaxExemptJsp')"
	accesskey="u" tabindex=1 />

<input type="button" name="Delete" id="deletebutton" value="Activate"
	style="display: none;" class="button"
	onClick="submitForm('incomeTaxExempt','incomeTaxMaster?method=deleteIncomeTaxExemptMaster&flag='+this.value)"
	accesskey="d" tabindex=1 />

<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />


<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Financial Year"
data_header[0][1] = "data";
data_header[0][2] = "";
data_header[0][3] = "<%= SEARCH_NAME %>"

data_header[1] = new Array;
data_header[1][0] = "Section Code"
data_header[1][1] = "data";
data_header[1][2] = "";
data_header[1][3] = "<%= CODE%>";

data_header[2] = new Array;
data_header[2][0] = "Maximum Amount"
data_header[2][1] = "data";
data_header[2][2] = "";
data_header[2][3] = "maxAmt";

data_header[3] = new Array;
data_header[3][0] = "Exemption Percent"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "exemptionPercent";

data_header[4] = new Array;
data_header[4][0] = "Minimum Amount"
data_header[4][1] = "data";
data_header[4][2] = "";
data_header[4][3] = "minAmt";

data_header[5] = new Array;
data_header[5][0] = "Exemption Base"
data_header[5][1] = "data";
data_header[5][2] = "";
data_header[5][3] = "exemptionBase";

data_header[6] = new Array;
data_header[6][0] = "Max. Exemption"
data_header[6][1] = "data";
data_header[6][2] = "";
data_header[6][3] = "maxExemption";



data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_BY %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_DATE %>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "";
data_header[9][3] = "<%=CHANGED_TIME %>";

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = "";
data_header[10][3] = "<%=STATUS %>";



data_arr = new Array();

<%
Iterator itr=searchItaxExemptMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrMasItaxExemption  hrMasItaxExemption = (HrMasItaxExemption)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasItaxExemption.getId()%>
<%
	for(HrMasFinancialYear hrMasFinancialYear :hrMasFinancialYearList){
		if(hrMasItaxExemption.getFinancialYear().getId().equals(hrMasFinancialYear.getId())){
%>

data_arr[<%= counter%>][1] = "<%=hrMasFinancialYear.getFinancialYear()%>"
<% 
	}
   }		

%>
 
data_arr[<%= counter%>][2] = "<%= hrMasItaxExemption.getSectionCode()%>"
data_arr[<%= counter%>][3] = "<%= hrMasItaxExemption.getMaximumAmt()%>"
data_arr[<%= counter%>][4] = "<%= hrMasItaxExemption.getExemptionPercentage()%>"


<% if(hrMasItaxExemption.getExemptionBase().equals("s")){ %>
data_arr[<%= counter%>][5] = "Salary"
<%}else{%>
data_arr[<%= counter%>][5] = "Tax Amount"
<%}%>
data_arr[<%= counter%>][6] = "<%= hrMasItaxExemption.getMinimumAmt()%>"

data_arr[<%= counter%>][7] = "<%= hrMasItaxExemption.getMaxExemption()%>"


data_arr[<%= counter%>][8] = "<%= hrMasItaxExemption.getLastChgBy() %>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasItaxExemption.getLastChgDate()) %>"
data_arr[<%= counter%>][10] = "<%= hrMasItaxExemption.getLastChgTime() %>"
<% if(hrMasItaxExemption.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>


<%
		     counter++;
}
%>
 
formName = "incomeTaxExempt"

//nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
