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
<%@ page import="jkt.hms.masters.business.BudReAppropEntry" %>
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
  List<BudReAppropEntry> budReAppropEntryList=new ArrayList<BudReAppropEntry>();
  List<BudReAppropEntry> budReAppropEntryListFull=new ArrayList<BudReAppropEntry>();
  List <BudEstimateEntry> budEstimateEntryList =new ArrayList();
  List <BudEstimateEntry> budEstimateEntryListFul =new ArrayList();
  List <HrMasFinancialYear> hrMasFinancialYearList= new ArrayList();
  List<BudMajorHead>budMajorHeadList=new ArrayList();
  List<BudSubMajorHead> budSubMajorHeadList=new ArrayList();
  List<BudMinorSubHead> budMinorSubHeadList=new ArrayList();
  List <BudObjectHead> budObjectHeadList=new ArrayList();
  budReAppropEntryList=(List<BudReAppropEntry>)map.get("budReAppropEntryList");
  budReAppropEntryListFull=(List<BudReAppropEntry>)map.get("budReAppropEntryListFull");
  budEstimateEntryList = (List <BudEstimateEntry>)map.get("budEstimateEntryList");
  budEstimateEntryListFul=(List <BudEstimateEntry>)map.get("budEstimateEntryListFul");
  hrMasFinancialYearList=(List<HrMasFinancialYear>)map.get("hrMasFinancialYearList");
  budMajorHeadList=(List<BudMajorHead>)map.get("budMajorHeadList");
  budSubMajorHeadList=(List<BudSubMajorHead>)map.get("budSubMajorHeadList");
  budMinorSubHeadList=(List<BudMinorSubHead>)map.get("budMinorSubHeadList");
  budObjectHeadList=(List<BudObjectHead>)map.get("budObjectHeadList");
  

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
for (BudMinorSubHead minorSubHead : budMinorSubHeadList)
{
for (BudObjectHead objectHead  : budObjectHeadList)
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
<h2>Budget Re-Appropriation Estimates Entry</h2>
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
<label><span>*</span>Reapprop No:</label>
<select name="<%= CODE%>"
	validate="Demand NO No,string,yes">
	<option value="">Select</option>
	<%for (BudReAppropEntry estimate :budReAppropEntryListFull ) {
		String toDeptName="";
		if(estimate.getReAppropNo()!=null){
			toDeptName=" [ "+estimate.getReAppropNo()+" ]";
		}

	%>
	<option value=<%=estimate.getId()%>><%=estimate.getReAppropNo()%></option>
	<%}%>
</select> <input type="image" name="button" class="button" onClick="submitForm('s','budget?method=searchBudgetReAppropEntry');" />
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
-->
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
<label><span>*</span> Demand No.</label>
<%for (BudReAppropEntry estimate :budReAppropEntryList ) {
%>
<input type="hidden" name="<%=COMMON_ID %>" value="<%=estimate.getId() %>" />
<label class="value"><%=estimate.getReAppropNo() %></label>
<input type="hidden" name="code" value="<%=estimate.getReAppropNo() %>" />
<label><span>*</span> FinancialYear</label>
<select	name="<%= FINANCIAL_ID %>" validate="Financial Year,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')">
<option value="0">Select</option>
<%for(HrMasFinancialYear financial : hrMasFinancialYearList){
if(estimate.getFinancial().getId().equals(financial.getId()))
{
%>
<option value="<%=financial.getId()%>" selected="selected"><%=financial.getFinancialYear()%></option>
<%}
if(!estimate.getFinancial().getId().equals(financial.getId()))
{
%>
<option value="<%=financial.getId()%>" ><%=financial.getFinancialYear()%></option>
<%}} %>
</select>

<label><span>*</span> Major Head Name</label>
<select	name="<%= MAJOR_HEAD_ID %>" validate="Major Head Name,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')" onchange="populatemajorHead(this.value,'estimateentry');">
<option value="0">Select</option>
<%
			for(BudMajorHead major : budMajorHeadList){
			if(estimate.getMajorHead().getId().equals(major.getId()))
{
%>
<option value="<%=major.getId()%>" selected="selected"><%=major.getMajorHeadName()%></option>
<%}
if(!estimate.getMajorHead().getId().equals(major.getId()))
{
%>
<option value="<%=major.getId()%>" ><%=major.getMajorHeadName()%></option>
<%}} %>
</select>
<div class="clear"></div>
<label><span>*</span> Major Sub Head Name</label>
<select	name="<%=MAJOR_SUB_HEAD_ID %>" id="subMajorHeadId"  tabindex=1 onchange="populatesubmajorHead(this.value,'estimateentry');" >
<option value="0">Select</option>
<%
			for(BudSubMajorHead subMajorHead : budSubMajorHeadList){
			if(estimate.getMajorSubHead().getId().equals(subMajorHead.getId()))
{
%>
<option value="<%=subMajorHead.getId()%>" selected="selected"><%=subMajorHead.getSubMajorHeadName()%></option>
<%}
if(!estimate.getMajorSubHead().getId().equals(subMajorHead.getId()))
{
%>
<option value="<%=subMajorHead.getId()%>" ><%=subMajorHead.getSubMajorHeadName()%></option>
<%}} %>
</select>
<label><span>*</span> Minor Head Name</label>
<select	name="<%= MINOR_SUB_HEAD_ID %>" id="minorHead" validate="Minor Head Name,string,yes" tabindex=1 onchange="populateminorsubHead(this.value,'estimateentry');" >
<option value="0">Select</option>
<%
			for(BudMinorSubHead minorHead : budMinorSubHeadList){
			if(estimate.getMinorSubHead().getId().equals(minorHead.getId()))
{
%>
<option value="<%=minorHead.getId()%>" selected="selected"><%=minorHead.getMinorSubHeadName()%></option>
<%}
if(!estimate.getMinorSubHead().getId().equals(minorHead.getId()))
{
%>
<option value="<%=minorHead.getId()%>" ><%=minorHead.getMinorSubHeadName()%></option>
<%}} %>
</select>
<label><span>*</span> Object Head Name</label>
<select	name="<%= OBJECT_HEAD_ID %>" id="objecthead"  tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addCountry')">
<option value="0">Select</option>
<%
			for(BudObjectHead objectHead : budObjectHeadList){
			if(estimate.getObjectHead().getId().equals(objectHead.getId()))
{
%>
<option value="<%=objectHead.getId()%>" selected="selected"><%=objectHead.getObjectHeadName()%></option>
<%}
if(!estimate.getObjectHead().getId().equals(objectHead.getId()))
{
%>
<option value="<%=objectHead.getId()%>" ><%=objectHead.getObjectHeadName()%></option>
<%}} %>
</select>
<div class="clear"></div>
<label><span>*</span> Sector Type</label>
<label class="value"><%=estimate.getType() %></label>
<label>Amount</label>
<input type="text" name="<%=SEARCH_NAME %>" value="<%= estimate.getReappamount() %>" validate="Amount,String,yes" onkeypress="return isNumberKey(event)" tabindex="1" />
</div>
<div class="clear" > </div>
<div class="division" > </div>
<div class="clear" > </div>
<input type="button" class="button" value="Update" onclick="submitForm('estimateentry','budget?method=editReApprop');" />
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
<%} %>
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
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
         if (charCode > 31 && (charCode < 46 || charCode > 57))
            return false;

         return true;
      }
      //-->
</SCRIPT>  