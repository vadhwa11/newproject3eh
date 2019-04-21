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
<%@page import="jkt.hms.util.Box"%>
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
  Box box = HMSUtil.getBox(request);
  Map<String, Object>utilmap= new HashMap<String,Object>();
  utilmap=(Map)HMSUtil.getCurrentDateAndTime();
  String date = (String)utilmap.get("currentDate");
  String time = (String)utilmap.get("currentTime");
  List <BudEstimateEntry> budgetEstimateFulList =new ArrayList();
  List <HrMasFinancialYear> searchFinancialYearList= new ArrayList();
  List<BudMajorHead>searchmajorheadList=new ArrayList();
  List<BudSubMajorHead> searchsubmajorheadList=new ArrayList();
  List<BudMinorSubHead> searchminorsubheadList=new ArrayList();
  List <BudObjectHead> searchobjectheadList=new ArrayList();
  List <BudMajorHead> gridmajorheadList = new ArrayList<BudMajorHead>();
  List <BudSubMajorHead> gridsubmajorheadList = new ArrayList<BudSubMajorHead>();
  List <BudMinorSubHead> gridminorsubheadList = new ArrayList<BudMinorSubHead>();
  List <BudObjectHead> gridobjectheadList = new ArrayList<BudObjectHead>();
  budgetEstimateFulList = (List <BudEstimateEntry>)map.get("budgetEstimateFulList");

  searchFinancialYearList=(List<HrMasFinancialYear>)map.get("searchFinancialYearList");
  searchmajorheadList=(List<BudMajorHead>)map.get("searchmajorheadList");
  searchsubmajorheadList=(List<BudSubMajorHead>)map.get("searchsubmajorheadList");
  searchminorsubheadList=(List<BudMinorSubHead>)map.get("minorList");
  searchobjectheadList=(List<BudObjectHead>)map.get("objectList");
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
<%
int count = 0;
for (BudMinorSubHead minorSubHead : searchminorsubheadList)
{
for (BudObjectHead objectHead  : searchobjectheadList)
{
if(objectHead.getMinorSubHeadId()!= null){
if(minorSubHead.getId().equals(minorSubHead.getMinorHeadId())){
%>
blockArray[<%=count%>] = new Array();
blockArray[<%=count%>][0] = <%=minorSubHead.getId()%>;
blockArray[<%=count%>][1] = <%=objectHead.getId()%>;
blockArray[<%=count%>][2] = "<%=objectHead.getObjectHeadName()%>";

<%
count++;
}
}
}
}
%>
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
	<%for (BudEstimateEntry estimate :budgetEstimateFulList ) {
		String toDeptName="";
		if(estimate.getDemandNo()!=null){
			toDeptName=" [ "+estimate.getDemandNo()+" ]";
		}

	%>
	<option value=<%=estimate.getId()%>><%=estimate.getDemandNo()%></option>
	<%}%>
</select> <input type="image" name="button" class="button" onClick="submitForm('s','budget?method=searchEstimation');" />
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
<!--<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>

<div class="clear"></div>
<div class="clear"></div></div>
--><script type="text/javascript">
formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%=SEARCH_NAME%>"], [3,"<%=MAJOR_HEAD_ID%>"],[4,"<%=MAJOR_SUB_HEAD_ID%>"],[5,"<%=MINOR_SUB_HEAD_ID%>"],[6,"<%=OBJECT_HEAD_ID%>"],[7,"<%=SECTOR_TYPE%>"], [8,"<%=FINANCIAL_YEAR%>"] , [9,"<%=STATUS%>"]];
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
<%for (BudEstimateEntry estimate :budgetEstimateFulList ) {
%>
<label class="value"><%=estimate.getDemandNo() %></label>
<input type="hidden" name="demandNo" value="<%=estimate.getDemandNo() %>" /> 
<%} %>
<label><span>*</span> Major Head Name</label>
<select	name="<%= MAJOR_HEAD_ID %>" validate="Major Head Name,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')" onchange="populatemajorHead(this.value,'estimateentry');">
<option value="0">Select</option>
<%
for (BudMajorHead majorHead: searchmajorheadList){
%>
<option value="<%=majorHead.getId()%>">
<%=majorHead.getMajorHeadName()%></option>
<%}%>
</select>
<div class="clear"></div>
<label><span>*</span> Major Sub Head Name</label>
<select	name="<%=MAJOR_SUB_HEAD_ID %>" id="subMajorHeadId"  tabindex=1 onchange="populatesubmajorHead(this.value,'estimateentry');" >
<option value="0">Select</option>
<%
			for(BudSubMajorHead subMajorHead : searchsubmajorheadList){
			%>
	<option value="<%=subMajorHead.getId() %>"
		<%=HMSUtil.isSelected(subMajorHead.getId(),Integer.valueOf(box.getInt(SUB_MAJOR_HEAD_ID)))%>><%=subMajorHead.getSubMajorHeadName() %></option>
	<%}%>
	</select>
<script type="text/javascript">

<%

	int counter = 0;

	for (BudMajorHead majorhead : searchmajorheadList){
	for (BudSubMajorHead subMajorHead : searchsubmajorheadList) {
	if(subMajorHead.getMajorHeadId() != null){
	if(majorhead.getId().equals(subMajorHead.getMajorHeadId().getId() )){
%>
majorHeadCodeArray1[<%=counter%>] = new Array();
majorHeadCodeArray1[<%=counter%>][0]=<%=majorhead.getId()%>;
majorHeadCodeArray1[<%=counter%>][1] = <%=subMajorHead.getId()%>;
majorHeadCodeArray1[<%=counter%>][2] = "<%=subMajorHead.getSubMajorHeadName()%>";
	<%
	counter++;
	} } } }

%>
</script> 
<label><span>*</span> Minor Head Name</label>
<select	name="<%= MINOR_SUB_HEAD_ID %>" id="minorHead" validate="Minor Head Name,string,yes" tabindex=1 >
<option value="0">Select</option>
<%
			for(BudMinorSubHead minorHead : searchminorsubheadList){
			%>
	<option value="<%=minorHead.getId() %>"
		<%=HMSUtil.isSelected(minorHead.getId(),Integer.valueOf(box.getInt(MINOR_SUB_HEAD_ID)))%>><%=minorHead.getMinorSubHeadName() %></option>
	<%}%>
	</select>
<script type="text/javascript">

<%

	int counter2 = 0;

	for (BudSubMajorHead submajorhead : searchsubmajorheadList){
	for (BudMinorSubHead minorHead : searchminorsubheadList) {
	if(minorHead.getMinorHeadId() != null){
	if(submajorhead.getId().equals(minorHead.getMinorHeadId().getId() )){
%>
majorHeadCodeArray2[<%=counter2%>] = new Array();
majorHeadCodeArray2[<%=counter2%>][0]=<%=submajorhead.getId()%>;
majorHeadCodeArray2[<%=counter2%>][1] = <%=minorHead.getId()%>;
majorHeadCodeArray2[<%=counter2%>][2] = "<%=minorHead.getMinorSubHeadName()%>";
	<%
	counter2++;
	} } } }

%>
</script> </select>
<label><span>*</span> Object Head Name</label>
<select	name="<%= OBJECT_HEAD_ID %>" validate="Minor Head Name,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')">
<option value="0">Select</option>
<%
for (BudObjectHead objectHead: searchobjectheadList){
%>
<option value="<%=objectHead.getId() %>">
<%=objectHead.getObjectHeadName()%></option>
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
<input type="text" name="<%=SEARCH_NAME %>" value="" validate="Amount,String,yes" onkeypress="return isNumberKey(event)" tabindex="1" />
</div>
<div class="clear" > </div>
<div class="division" > </div>
<div class="clear" > </div>
<input type="button" class="button" value="Submit" onclick="submitForm('estimateentry','budget?method=addBudget');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="button" class="button" value="Print" >

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
data_header[3][0] = "Major sub Head Name"
data_header[3][1] = "hide";
data_header[3][2] = "15%";
data_header[3][3] = "<%=MAJOR_SUB_HEAD_ID %>";

data_header[4] = new Array;
data_header[4][0] = "Minor sub Head Name"
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=MINOR_SUB_HEAD_ID %>";

data_header[5] = new Array;
data_header[5][0] = "Sequwncw No"
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=OBJECT_HEAD_ID %>";

data_header[6] = new Array;
data_header[6][0] = "Sector Type"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=SECTOR_TYPE %>";

data_header[7] = new Array;
data_header[7][0] = "FY"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=FINANCIAL_YEAR %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%= STATUS%>";

data_arr = new Array();
<%
Iterator itr=budgetEstimateFulList.iterator();
int counter1=0;
while(itr.hasNext())
{
BudEstimateEntry estimateentry = (BudEstimateEntry)itr.next();
%>
data_arr[<%= counter1%>] = new Array();
data_arr[<%= counter1%>][0] = <%= estimateentry.getId()%>
data_arr[<%= counter1%>][1] = "<%= estimateentry.getDemandNo()%>"
data_arr[<%= counter1%>][2] = "<%= estimateentry.getAmount()%>"
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
			data_arr[<%= counter1%>][3] = "<%=majorheadGrid.getMajorHeadName()%>"
<%
		}
			else if(estimateentry.getId().equals(majorheadGrid.getId()) && majorheadGrid.getStatus().equals("n"))
			{
%>
			data_arr[<%= counter1%>][3] = "<font id='error'>*</font>Parent InActivated--<%=majorheadGrid.getMajorHeadName()%>"

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
			if(estimateentry.getMajorHeadId().equals(majorsubheadGrid.getId()) && majorsubheadGrid.getStatus().equals("y"))
			{
%>
			data_arr[<%= counter1%>][4] = "<%=majorsubheadGrid.getSubMajorHeadName()%>"
<%
		}
			else if(estimateentry.getId().equals(majorsubheadGrid.getId()) && majorsubheadGrid.getStatus().equals("n"))
			{
%>
			data_arr[<%= counter1%>][4] = "<font id='error'>*</font>Parent InActivated--<%=majorsubheadGrid.getSubMajorHeadName()%>"

<%
		}
	}
		catch(Exception e)
		{
		}
	}
%>
<%
Iterator itrGridMinorSubHeadList=gridminorsubheadList.iterator();
	while(itrGridMinorSubHeadList.hasNext())
{
		try
		{

			BudMinorSubHead  minorsubheadGrid = (BudMinorSubHead)itrGridMinorSubHeadList.next();

			if(estimateentry.getMajorHeadId().equals(minorsubheadGrid.getId()) && minorsubheadGrid.getStatus().equals("y"))
			{
%>
			data_arr[<%= counter1%>][5] = "<%=minorsubheadGrid.getMinorSubHeadName()%>"
<%
		}
			else if(estimateentry.getId().equals(minorsubheadGrid.getId()) && minorsubheadGrid.getStatus().equals("n"))
			{
%>
			data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=minorsubheadGrid.getMinorSubHeadName()%>"

<%
		}
	}
		catch(Exception e)
		{
		}
	}
%>
<%
Iterator itrGridObjectHeadList=gridminorsubheadList.iterator();
	while(itrGridObjectHeadList.hasNext())
{
		try
		{
			BudObjectHead  objectheadGrid = (BudObjectHead)itrGridObjectHeadList.next();
			if(estimateentry.getMajorHeadId().equals(objectheadGrid.getId()) && objectheadGrid.getStatus().equals("y"))
			{
%>
			data_arr[<%= counter1%>][6] = "<%=objectheadGrid.getObjectHeadName()%>"
<%
		}
			else if(estimateentry.getId().equals(objectheadGrid.getId()) && objectheadGrid.getStatus().equals("n"))
			{
%>
			data_arr[<%= counter1%>][6] = "<font id='error'>*</font>Parent InActivated--<%=objectheadGrid.getObjectHeadName()%>"

<%
		}
	}
		catch(Exception e)
		{
		}
	}
%>
data_arr[<%= counter1%>][7] = "<%= estimateentry.getSectorType()%>"
	<%
	Iterator itrGridFinancialList=gridminorsubheadList.iterator();
		while(itrGridFinancialList.hasNext())
	{
			try
			{
				HrMasFinancialYear  financialGrid = (HrMasFinancialYear)itrGridFinancialList.next();
				if(estimateentry.getObjectHeadId().equals(financialGrid.getId()) && financialGrid.getStatus().equals("y"))
				{
	%>
				data_arr[<%= counter1%>][8] = "<%=financialGrid.getFinancialYear()%>"
	<%
			}
				else if(estimateentry.getId().equals(financialGrid.getId()) && financialGrid.getStatus().equals("n"))
				{
	%>
				data_arr[<%= counter1%>][8] = "<font id='error'>*</font>Parent InActivated--<%=financialGrid.getFinancialYear()%>"

	<%
			}
		}
			catch(Exception e)
			{
			}
		}
	%>
<%
if(estimateentry.getStatus()!=null){
	if(estimateentry.getStatus().equals("y"))
	{
	%>
		data_arr[<%= counter1%>][9] = "Active"
	<%				}
	else
	{
	%>
		data_arr[<%= counter1%>][9] = "InActive"
	<%				}

}

	counter++;
}
%>
formName = "estimateentry"
nonEditable = ['<%= CODE%>'];
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
<SCRIPT language=Javascript>//script for entering only integer
      <!--
      function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

         return true;
      }
      //-->
</SCRIPT>  