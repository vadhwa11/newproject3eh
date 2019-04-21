<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * budgetEstimateEntryJsp.jsp
 * Purpose of the JSP -  This is for Budget Estimate Entry.
 * @author  Ujjwal
 * Create Date: 09th Feb,2011
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.BudEstimateEntry" %>
<%@ page import="jkt.hrms.masters.business.HrMasFinancialYear" %>
<%@ page import="jkt.hms.masters.business.BudMajorHead" %>
<%@ page import="jkt.hms.masters.business.BudSubMajorHead" %>
<%@ page import="jkt.hms.masters.business.BudMinorSubHead" %>
<%@ page import="jkt.hms.masters.business.BudObjectHead" %>
<%@ page import="jkt.hrms.masters.business.*" %>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>


<script type="text/javascript" src="../jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
</script>
<%
  Map map = new HashMap();
  if(request.getAttribute("map") != null){
    map = (Map) request.getAttribute("map");
  }
  Map<String, Object>utilmap= new HashMap<String,Object>();
  utilmap=(Map)HMSUtil.getCurrentDateAndTime();
  String date = (String)utilmap.get("currentDate");
  String time = (String)utilmap.get("currentTime");
  List <BudEstimateEntry> searchEstimateEntryList =new ArrayList();
  List <HrMasFinancialYear> searchFinancialYearList= new ArrayList();
  List<BudMajorHead>searchmajorheadList=new ArrayList();
  List<BudSubMajorHead> searchsubmajorheadList=new ArrayList();
  List<BudMinorSubHead> searchminorsubheadList=new ArrayList();
  List <BudObjectHead> searchobjectheadList=new ArrayList();
  List <BudMajorHead> gridmajorheadList = new ArrayList<BudMajorHead>();
  List <BudSubMajorHead> gridsubmajorheadList = new ArrayList<BudSubMajorHead>();
  List <BudMinorSubHead> gridminorsubheadList = new ArrayList<BudMinorSubHead>();
  List <BudObjectHead> gridobjectheadList = new ArrayList<BudObjectHead>();
  searchEstimateEntryList = (List <BudEstimateEntry>)map.get("searchEstimateEntryList");

  searchFinancialYearList=(List<HrMasFinancialYear>)map.get("searchFinancialYearList");
  searchmajorheadList=(List<BudMajorHead>)map.get("searchmajorheadList");
  searchsubmajorheadList=(List<BudSubMajorHead>)map.get("searchsubmajorheadList");
  searchminorsubheadList=(List<BudMinorSubHead>)map.get("searchminorsubheadList");
  searchobjectheadList=(List<BudObjectHead>)map.get("searchobjectheadList");
  gridmajorheadList = (List <BudMajorHead>)map.get("gridmajorheadList");
  gridsubmajorheadList=(List <BudSubMajorHead>)map.get("gridsubmajorheadList");
  gridminorsubheadList=(List<BudMinorSubHead>)map.get("gridminorsubheadList");
	

  String userName = "";
  if(session.getAttribute("userName") != null){
    userName = (String)session.getAttribute("userName");
  }
  if(map.get("message") != null){
       String message = (String)map.get("message");
       %>
 <h4><span><%=message %></span></h4>
<%} %>
<script>
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
<h2>Budget Estimate Entry</h2>
</div>
<div class="clear"></div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>

<!-- <input type="button" name="Add" type="submit"  value="Add" class="button">
	<input type="button" name="Modify" type="submit" value="Modify" class="button"  onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');">
	<input type="button" name="Reset" type="submit" value="Reset" class="button" >

	<input type="button" name="Delete" type="submit"  value="Delete" class="button"  onClick="openDeletePopupForIssueciv();">
	-->


<%--------------- End of Tool Panel ---------------------------%>
<!-- thread search menu -->

<form name="s" method="post">
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<%--------------- Start of Search Panel ---------------------------%>
<label><span>*</span>Demand No:</label>
<select name="<%= CODE%>"
	validate="Demand NO No,string,yes">
	<option value="">Select</option>
	<%for (BudEstimateEntry estimate :searchEstimateEntryList ) {
		String toDeptName="";
		if(estimate.getDemandNo()!=null){
			toDeptName=" [ "+estimate.getDemandNo()+" ]";
		}

	%>
	<option value=<%=estimate.getId()%>><%=estimate.getDemandNo()%></option>
	<%}%>
</select> <input type="image" name="button" class="button" onClick="submitForm('s','budget?method=searchBudgetEstimateEntry');" />
<div class="clear"></div>
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('issueIdPrint','ac2update','budget?method=getIssueNoListForAutoComplete',{parameters:'requiredField=issueIdPrint'});
		</script>

<script type="text/javascript" language="javascript">
function submitprint(formName){
	var issueId=document.getElementById('issueIdPrint').value;
	if(issueId!=""){
		obj = eval('document.'+formName)
		obj.action = "/hms/hms/budget?method=printDepartmentIssue";
		obj.submit();
	}else{
		alert("Please Insert Issue No. for Print");
		return false;
	}
  }
</script>
</div>

 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<%



if(searchEstimateEntryList!=null){
		if(searchEstimateEntryList.size()>0 )

		 {
			String strForCode = (String)map.get("financialCode");
			String strForCodeDescription = (String)map.get("financialName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
%><h4> <a href="budget?method=showFinancialyearMaster">Show All Records</a></h4> <%
			}
		 }
	 if(searchEstimateEntryList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="budget?method=showFinancialyearMaster">Show All Records</a></h4>

<%
     }
	}%><script type="text/javascript">
formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%=SEARCH_NAME%>"], [3,"<%=MAJOR_HEAD_ID%>"],[4,"<%=MAJOR_SUB_HEAD_ID%>"],[5,"<%=MINOR_SUB_HEAD_ID%>"],[6,"<%=OBJECT_HEAD_ID%>"],[7,"<%=FINANCIAL_YEAR%>"], [8,"<%=SECTOR_TYPE%>"] , [9,"<%=STATUS%>"]];
	 statusTd = 8;
	</script>
<div class="clear"></div>
<form name="estimateentry" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input type="hidden" name="<%= POJO_NAME %>" value="BudEstimateEntry">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="Amount">
<input	type="hidden" name="title" value="Country">
<input type="hidden" name="pojoPropertyCode" value="DemandNo">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> FinancialYear</label>
<select	name="<%= FINANCIAL_YEAR %>" validate="Financial Year,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')">
<option value="0">Select</option>
<%
for (HrMasFinancialYear financialyear:searchFinancialYearList ){
%>
<option value="<%=financialyear.getId()%>">
<%=financialyear.getFinancialYear()%></option>
<%}%>
</select>
<label><span>*</span> Demand No.</label>
<input type="text" name="<%=CODE %>" validate="Demand No,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')"  />
<label><span>*</span> Major Head Name</label>
<select	name="<%= MAJOR_HEAD_ID %>" validate="Major Head Name,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')">
<option value="0">Select</option>
<%
for (BudMajorHead majorhead:searchmajorheadList ){
	%>
<option value="<%=majorhead.getId()%>">
<%=majorhead.getMajorHeadName()%></option>
<%}%>
</select>
<div class="clear"></div>
<label><span>*</span> Major Sub Head Name</label>
<select	name="<%= MAJOR_SUB_HEAD_ID %>" validate="Major Sub Head Name,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')">
<option value="0">Select</option>
<%
for (BudSubMajorHead submajorhead:searchsubmajorheadList){
	%>
	<option value="<%=submajorhead.getId() %>">
	<%=submajorhead.getSubMajorHeadName() %>
	</option>
<%}%></select>
<label><span>*</span> Minor Head Name</label>
<select	name="<%= MINOR_SUB_HEAD_ID %>" validate="Minor Head Name,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')">
<option value="0">Select</option>
<%
for		(BudMinorSubHead minorsubhead:searchminorsubheadList){
%>
<option value="<%= minorsubhead.getId()%>">
<%=minorsubhead.getMinorSubHeadName() %>
</option>
<%} %></select>
<label><span>*</span> Object Head Name</label>
<select	name="<%= OBJECT_HEAD_ID %>" validate="Minor Head Name,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')">
<option value="0">Select</option>
<%
for		(BudObjectHead objecthead:searchobjectheadList){
	%>
	<option value="<%= objecthead.getId()%>">
	<%=objecthead.getObjectHeadName() %>
	 </option>
		<%}%>
		</select>
<div class="clear"></div>
<label><span>*</span> Sector Type</label>
<select name="<%=SECTOR_TYPE%>">
<option value="0">Select</option>
<option value="1">Plan</option>
<option value="2">Unplanned</option>
</select>
<label>Amount</label>
<input type="text" name="<%=SEARCH_NAME %>" value="" validate="Amount,String,yes" tabindex="1" />
</div>
<div id="edited" > </div>
<div class="clear" > </div>
<div class="division" > </div>
<div class="clear" > </div>
<input type="button" class="button" value="Submit" onclick="submitForm('estimateentry','budget?method=addBudget');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="button" class="button" value="Print" >
<input type="button" class="button" value="modify" onclick="submitForm('estimateentry','budget?method=updateEstimateEntry');" >
<div class="clear" > </div>
<div class="division" > </div>
<div class="clear" > </div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label> <label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Demand No"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Amount"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=SEARCH_NAME%>";

data_header[2] = new Array;
data_header[2][0] = " Major Head Name"
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%=MAJOR_HEAD_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Sub Head Name"
data_header[3][1] = "hide";
data_header[3][2] = "15%";
data_header[3][3] = "<%=MAJOR_SUB_HEAD_ID %>";

data_header[4] = new Array;
data_header[4][0] = "Minor sub Head Name"
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=MINOR_SUB_HEAD_ID %>";

data_header[5] = new Array;
data_header[5][0] = "Object Head"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=OBJECT_HEAD_ID %>";

data_header[6] = new Array;
data_header[6][0] = "Financial Year"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=FINANCIAL_YEAR %>";

data_header[7] = new Array;
data_header[7][0] = "Sector Type"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=SECTOR_TYPE %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchEstimateEntryList.iterator();
int counter=0;
while(itr.hasNext())
{
BudEstimateEntry estimateentry = (BudEstimateEntry)itr.next();
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= estimateentry.getId()%>
data_arr[<%= counter%>][1] = "<%= estimateentry.getDemandNo()%>"
data_arr[<%= counter%>][2] = "<%= estimateentry.getAmount()%>"
<%
Iterator itrGridMajorHeadList=gridmajorheadList.iterator();
	while(itrGridMajorHeadList.hasNext())
{
		try
		{
			BudMajorHead  majorheadGrid = (BudMajorHead)itrGridMajorHeadList.next();
			if(estimateentry.getMajorHeadId().equals(majorheadGrid.getId()) && majorheadGrid.getStatus().equals("y"))
			{
%>
			data_arr[<%= counter%>][3] = "<%=majorheadGrid.getMajorHeadName()%>"
<%
		}
			else if(estimateentry.getId().equals(majorheadGrid.getId()) && majorheadGrid.getStatus().equals("n"))
			{
%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=majorheadGrid.getMajorHeadName()%>"

<%
		}
	}
		catch(Exception e)
		{
			
		}
	}
%>
<%
Iterator itrGridMajorSubHeadList=gridsubmajorheadList.iterator();
	while(itrGridMajorSubHeadList.hasNext())
{
		try
		{
			BudSubMajorHead  majorsubheadGrid = (BudSubMajorHead)itrGridMajorSubHeadList.next();
			if(estimateentry.getMajorSubHeadId().getId().equals(majorsubheadGrid.getId()) && majorsubheadGrid.getStatus().equals("y"))
			{
%>
			data_arr[<%= counter%>][4] = "<%=majorsubheadGrid.getSubMajorHeadName()%>"
<%
		}
			else if(estimateentry.getId().equals(majorsubheadGrid.getId()) && majorsubheadGrid.getStatus().equals("n"))
			{
%>
			data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=majorsubheadGrid.getSubMajorHeadName()%>"

<%
		}
	}
		catch(Exception e)
		{
			
		}
	}
%>
<%
Iterator itr1=gridminorsubheadList.iterator();
	while(itr1.hasNext())
{
		try
		{

			BudMinorSubHead  minorsubhead = (BudMinorSubHead)itr1.next();

			if(estimateentry.getMinorSubHeadId().getId().equals(minorsubhead.getId()) && minorsubhead.getStatus().equals("y"))
			{
%>
			data_arr[<%= counter%>][5] = "<%=minorsubhead.getMinorSubHeadName()%>"
<%
		}
			else if(estimateentry.getId().equals(minorsubhead.getId()) && minorsubhead.getStatus().equals("n"))
			{
%>
			data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=minorsubhead.getMinorSubHeadName()%>"

<%
		}
	}
		catch(Exception e)
		{
			
		}
	}
%>
<%
Iterator itr2=searchobjectheadList.iterator();
	while(itr2.hasNext())
{
		try
		{
			BudObjectHead  objecthead = (BudObjectHead)itr2.next();
			if(estimateentry.getObjectHeadId().getId().equals(objecthead.getId()) && objecthead.getStatus().equals("y"))
			{
%>
			data_arr[<%= counter%>][6] = "<%=objecthead.getObjectHeadName()%>"
<%				
%>
<%
		}
			else if(estimateentry.getId().equals(objecthead.getId()) && objecthead.getStatus().equals("n"))
			{
%>
			data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=objecthead.getObjectHeadName()%>"

<%
		}
	}
		catch(Exception e)
		{
			
		}
	}
%>
<%
Iterator itr3=searchFinancialYearList.iterator();
	while(itr3.hasNext())
{
		try
		{
			HrMasFinancialYear  financialGrid = (HrMasFinancialYear)itr3.next();
			if(estimateentry.getFYear().getId().equals(financialGrid.getId()) && financialGrid.getStatus().equals("y"))
			{
%>
			data_arr[<%= counter%>][7] = "<%=financialGrid.getFinancialYear()%>"
%>
<%
		}
			else if(estimateentry.getId().equals(financialGrid.getId()) && financialGrid.getStatus().equals("n"))
			{
%>
data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=financialGrid.getFinancialYear()%>"

<%
		}
	}
		catch(Exception e)
		{
		}
	}
%>

<%
if(estimateentry.getSectorType()!=null){
	if(estimateentry.getSectorType().equals("1"))
	{
	%>
	data_arr[<%= counter%>][8] = "Plan"
		<%				}else
		{
		%>
			data_arr[<%= counter%>][8] = "Unplanned"
		<%}
}%>
<%
if(estimateentry.getStatus()!=null){
	if(estimateentry.getStatus().equals("y"))
	{
	%>
		data_arr[<%= counter%>][9] = "Active"
	<%				}else{
	%>
		data_arr[<%= counter%>][9] = "InActive"
	<%				}

}
	counter++;
}
%>
formName = "estimateentry"
nonEditable = ['<%=CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');

</script>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
