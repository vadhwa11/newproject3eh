<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* budgetEstimateEntryJsp.jsp
* Purpose of the JSP -  This is for Voucher Receipt Entry.
* @author  Ujjwal
* Create Date: 14th Aptil,2011
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

<%@page import="jkt.hms.masters.business.BudVoucherReceiptEntry"%>


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
List <BudVoucherReceiptEntry> searchBudVoucherReceiptEntry =new ArrayList();

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
searchBudVoucherReceiptEntry=(List <BudVoucherReceiptEntry>)map.get("searchBudVoucherReceiptEntry");
searchEstimateEntryList = (List <BudEstimateEntry>)map.get("searchEstimateEntryList");
String num=(String) map.get("num");

searchFinancialYearList=(List<HrMasFinancialYear>)map.get("searchFinancialYearList");
searchmajorheadList=(List<BudMajorHead>)map.get("searchmajorheadList");
searchsubmajorheadList=(List<BudSubMajorHead>)map.get("searchsubmajorheadList");
searchminorsubheadList=(List<BudMinorSubHead>)map.get("searchminorsubheadList");
searchobjectheadList=(List<BudObjectHead>)map.get("searchobjectheadList");
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
<h2>Voucher Receipt Entry</h2>
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
<label><span>*</span>Receipt No.</label>
<select name="<%= CODE%>"
validate="Demand NO No,string,yes">
<option value="">Select</option>
<%for (BudVoucherReceiptEntry receipt :searchBudVoucherReceiptEntry ) {
String toDeptName="";
if(receipt.getReceiptNo()!=null){
toDeptName=" [ "+receipt.getReceiptNo()+" ]";
}

%>
<option value=<%=receipt.getId()%>><%=receipt.getReceiptNo()%></option>
<%}%>
</select> <input type="image" name="button" class="button" onClick="submitForm('s','budget?method=searchReceiptNo');" />
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
<div class="clear"></div>
<div class="clear"></div>
<form name="estimateentry" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input type="hidden" name="<%= POJO_NAME %>" value="BudReAppropEntry">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="Reappamount">
<input type="hidden" name="<%=POJO_PROPERTY_CODE %>" value="Type">
<input    type="hidden" name="title" value="Country">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Sector Type</label>
<select name="<%=SECTOR_TYPE%>">
<option>Select</option>
<option>Plan</option>
<option>Non-Planned</option>
</select>
<label>Financial Year</label>
<select name="<%=FINANCIAL_ID %>" id="financialId">
<option value="0">Select</option>
<%
for (HrMasFinancialYear financialyear:searchFinancialYearList ){
%>
<option value="<%=financialyear.getId()%>">
<%=financialyear.getFinancialYear()%></option>
<%}%>
</select>
<label>Object Head Name</label>
<select name="<%=OBJECT_HEAD_ID %>" id="objectHead" validate="Object Head Name,String,yes" onblur="poppulateobject(this.value)">
<option value="0">Select</option>
<%
for(BudObjectHead objectHead:searchobjectheadList){
%>
<option value="<%=objectHead.getId() %>">
<%=objectHead.getObjectHeadName() %></option>
<%}%>
</select>
<div class="clear"></div>
<label>Receipt Date</label>
<input type="text" name="<%=RECEIPT_DATE %>" class="date" id="date" readonly="readonly" value="<%=date %>" onblur="checkDate1(this.value);" />
<img src="/hms/jsp/images/cal.gif" id="startdate" onClick="javascript:setdate('',document.estimateentry.<%=RECEIPT_DATE%>,event)"width="16" height="16" border="0" validate="Pick a date" class="calender" />
<label>Receipt No.</label>
<input type="text" name="<%=CODE %>" readonly="readonly" value="<%=num %>" />
<label>Major Head Name</label>
<input type="text" name="<%=MAJOR_HEAD_ID %>" id="majornameId" readonly="readonly"  />
<div class="clear"></div>
<label>Major Sub Head Name</label>
<input type="text" name="majorsubheadname" id="majorsubheadnameId" />

<label>Minor Sub Head Name</label>
<input type="text" name="minorsubheadname" id="minorsubheadnameId" />
<label>Amount</label>
<input type="text" name="<%=SEARCH_NAME %>" value="" onkeypress="return isNumberKey(event)" />
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="submit" onclick="poppulateobject(this.value)" />
</form>
<form name="estimate" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<!--<input type="button" class="button" value="print" onclick="submitForm('estimate','budget?method=generateReceiptReport');"  />
--></form>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>

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

function poppulateobject(val){

submitForm('estimateentry','budget?method=showReceipt');

}
</SCRIPT> 
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

<script type="text/javascript">
<!--
// Main vBulletin Javascript Initialization
vBulletin_init();
//-->
</script>