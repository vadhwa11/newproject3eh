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
	List<HrMasItaxSecInvestment> searchItaxSecInvestmentMasterList = new ArrayList<HrMasItaxSecInvestment>();
	List<HrMasInvestmentType> hrMasInvestmentTypeList = new ArrayList<HrMasInvestmentType>();
	List<HrMasItaxExemption> hrMasItaxExemptionList = new ArrayList<HrMasItaxExemption>();
	List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();
	if(map.get("searchItaxSecInvestmentMasterList")!=null)
	{
		searchItaxSecInvestmentMasterList =(List<HrMasItaxSecInvestment>)map.get("searchItaxSecInvestmentMasterList");
	}
	if(map.get("hrMasItaxExemptionList")!=null)
	{
		hrMasItaxExemptionList =(List<HrMasItaxExemption>)map.get("hrMasItaxExemptionList");
	}
	if(map.get("hrMasFinancialYearList")!=null)
	{
		hrMasFinancialYearList =(List<HrMasFinancialYear>)map.get("hrMasFinancialYearList");
	}
	if(map.get("hrMasInvestmentTypeList")!=null)
	{
		hrMasInvestmentTypeList =(List<HrMasInvestmentType>)map.get("hrMasInvestmentTypeList");
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
<%@page import="jkt.hrms.masters.business.HrMasItaxSecInvestment"%>
<%@page import="jkt.hrms.masters.business.HrMasInvestmentType"%>
<div class="titleBg">
<h2>Section Investment</h2>
</div>
<div class="clear"></div>
<div class="Block"></div>
<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<%
 		if (searchItaxSecInvestmentMasterList.size() > 0) {
 			
 			String financialYr = (String) map.get("financialYear");
 			
 			if (financialYr != null && financialYr != "" ) 
 			{
 	%>
<h4><a href="incomeTaxMaster?method=showSectionInvestmentJsp">Show
All Records</a></h4>
<%
			}
		}
		if (searchItaxSecInvestmentMasterList.size() == 0
				&& map.get("search") != null) {
	%>
<h4><a href="incomeTaxMaster?method=showSectionInvestmentJsp">Show
All Records</a></h4>

<%
    	}
    %> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],  [1,"<%= SEARCH_NAME %>"],  [2,"sectionCode"], [3,"investmentType"], [4,"maxAmt"],[5,"benefitPercent"], [6,"basicDep"],[7,"monthlyDep"],[8,"<%= CHANGED_BY%>"],[9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"] ];
	 statusTd = 11;
	</script></div>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<form name="sectionInvestment" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="HrMasItaxSecInvestment" />
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="" /> <input
	type="hidden" name="title" value="Section Investment" /> <input
	type="hidden" name="<%=JSP_NAME %>" value="hr_sectionInvestmentJsp" />
<input type="hidden" name="pojoPropertyCode" value="" /> <label><span>*</span>
Financial Year</label> <select name="<%= SEARCH_NAME %>"
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
</select> <label><span>*</span>Section Code</label> <select name="sectionCode"
	validate="Section Code,string,yes" tabindex=1>
	<option value="">Select</option>
	<%if(hrMasItaxExemptionList != null)
			{
				for(HrMasItaxExemption hrMasItaxExemption : hrMasItaxExemptionList)	
				{%>
	<option value="<%=hrMasItaxExemption.getId()%>"><%=hrMasItaxExemption.getSectionCode() %></option>
	<% }
			}
			%>
</select>

<div class="clear"></div>


<label><span>*</span>Investment Type</label> <select
	name="investmentType" validate="Investment Type,string,yes" tabindex=1>
	<option value="">Select</option>
	<%if(hrMasInvestmentTypeList != null)
			{
				for(HrMasInvestmentType hrMasInvestmentType : hrMasInvestmentTypeList)	
				{%>
	<option value="<%=hrMasInvestmentType.getId()%>"><%=hrMasInvestmentType.getInvestmentDescription()%></option>
	<% }
			}
			%>
</select> <label><span>*</span>Maximum Amount</label> <input type="text"
	name="maxAmt" value="" validate="Max.Amount,string,no"
	class="textbox_size20" MAXLENGTH="6" tabindex=1 />

<div class="clear"></div>
<label><span>*</span>Benefit %</label> <input type="text"
	name="benefitPercent" value="" validate="Benefit % ,string,no"
	class="textbox_size20" MAXLENGTH="6" tabindex=1 /> <label>Basic
Dependent</label> <label class="value"><input type="checkbox"
	name="basicDep" value="y" tabindex=1 class="radioCheck" /></label> <label>
Monthly Dependent</label> <label class="value"><input type="checkbox"
	name="monthlyDep" value="y" tabindex=1 class="radioCheck" /></label> <script>
				document.sectionInvestment.<%=SEARCH_FIELD%>.focus();
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
	onClick="submitForm('sectionInvestment','incomeTaxMaster?method=addISectionInvestmentJsp');"
	accesskey="a" tabindex=1 />

<input type="button" name="edit" id="editbutton" value="Update"
	style="display: none;" class="button"
	onClick="submitForm('sectionInvestment','incomeTaxMaster?method=editISectionInvestmentJsp')"
	accesskey="u" tabindex=1 />

<input type="button" name="Delete" id="deletebutton" value="Activate"
	style="display: none;" class="button"
	onClick="submitForm('sectionInvestment','incomeTaxMaster?method=deleteISectionInvestmentJsp&flag='+this.value)"
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
data_header[1][3] = "sectionCode";

data_header[2] = new Array;
data_header[2][0] = "Investment Type"
data_header[2][1] = "data";
data_header[2][2] = "";
data_header[2][3] = "investmentType";

data_header[3] = new Array;
data_header[3][0] = "Max. Amount"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "maxAmt";

data_header[4] = new Array;
data_header[4][0] = "Benefit %"
data_header[4][1] = "data";
data_header[4][2] = "";
data_header[4][3] = "benefitPercent";

data_header[5] = new Array;
data_header[5][0] = "Basic Dependent"
data_header[5][1] = "hide";
data_header[5][2] = "";
data_header[5][3] = "basicDep";

data_header[6] = new Array;
data_header[6][0] = "Monthly Dependent"
data_header[6][1] = "hide";
data_header[6][2] = "";
data_header[6][3] = "monthlyDep";



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
Iterator itr=searchItaxSecInvestmentMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrMasItaxSecInvestment  hrMasItaxSecInvestment = (HrMasItaxSecInvestment)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasItaxSecInvestment.getId()%>
<%
	for(HrMasFinancialYear hrMasFinancialYear :hrMasFinancialYearList){
		if(hrMasItaxSecInvestment.getFinancialYear().getId().equals(hrMasFinancialYear.getId())){
%>

data_arr[<%= counter%>][1] = "<%=hrMasFinancialYear.getFinancialYear()%>"
<% 
	}
   }		
		
%>

<%
	for(HrMasItaxExemption hrMasItaxExemption :hrMasItaxExemptionList){
		if(hrMasItaxSecInvestment.getHrMasItaxExemption().getId().equals(hrMasItaxExemption.getId())){
%>
data_arr[<%= counter%>][2] = "<%= hrMasItaxExemption.getSectionCode()%>"
<% 
	}
   }		
		
%>

<%
	for(HrMasInvestmentType hrMasInvestmentType :hrMasInvestmentTypeList){
		if(hrMasItaxSecInvestment.getInvestmentType().getId().equals(hrMasInvestmentType.getId())){
%>
data_arr[<%= counter%>][3] = "<%= hrMasInvestmentType.getInvestmentDescription()%>"
<% 
	}
   }		
		
%>


 

data_arr[<%= counter%>][4] = "<%= hrMasItaxSecInvestment.getMaxAmount()%>"
data_arr[<%= counter%>][5] = "<%= hrMasItaxSecInvestment.getBenefitPercent()%>"
data_arr[<%= counter%>][6] = "<%= hrMasItaxSecInvestment.getBasicDependent()%>"

data_arr[<%= counter%>][7] = "<%= hrMasItaxSecInvestment.getMonthlyDependent()%>"



data_arr[<%= counter%>][8] = "<%= hrMasItaxSecInvestment.getLastChgBy() %>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasItaxSecInvestment.getLastChgDate()) %>"
data_arr[<%= counter%>][10] = "<%= hrMasItaxSecInvestment.getLastChgTime() %>"
<% if(hrMasItaxSecInvestment.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>


<%
		     counter++;
}
%>
 
formName = "sectionInvestment"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
