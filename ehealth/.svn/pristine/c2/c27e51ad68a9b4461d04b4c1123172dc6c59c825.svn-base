<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * fullyVoucherContingentBill.jsp
 * Purpose of the JSP -  This is for Voucher Bill Entry.
 * @author  Ujjwal
 * Create Date: 16th Feb,2011
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.BudVoucherHeader" %>
<%@ page import="jkt.hms.masters.business.BudVoucherDetail" %>
<%@ page import="jkt.hms.masters.business.BudEstimateEntry" %>
<%@ page import="jkt.hrms.masters.business.HrMasFinancialYear" %>
<%@ page import="jkt.hms.masters.business.BudMajorHead" %>
<%@ page import="jkt.hms.masters.business.BudSubMajorHead" %>
<%@ page import="jkt.hms.masters.business.BudMinorHead" %>
<%@ page import="jkt.hms.masters.business.BudMinorSubHead" %>
<%@ page import="jkt.hms.masters.business.BudObjectHead" %>
<%@ page import="jkt.hrms.masters.business.*" %>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
		var nameArray=new Array();
 		var brandArray=new Array();
</script>
<script type="text/javascript">
vBulletin_init();
</script>
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
  List <BudVoucherDetail>searchBudVoucherDetailList=new ArrayList();
  List <BudVoucherHeader>searVoucherHeaderList=new ArrayList();
  List <BudEstimateEntry> searchEstimateEntryList =new ArrayList();
  List <HrMasFinancialYear> searchFinancialYearList= new ArrayList();
  List<BudMajorHead>searchmajorheadList=new ArrayList();
  List<BudSubMajorHead> searchsubmajorheadList=new ArrayList();
  List<BudMinorHead>searchminorheadList=new ArrayList();
  List<BudMinorSubHead> searchminorsubheadList=new ArrayList();
  List <BudObjectHead> searchobjectheadList=new ArrayList();
  List <BudMajorHead> gridmajorheadList = new ArrayList<BudMajorHead>();
  List <BudSubMajorHead> gridsubmajorheadList = new ArrayList<BudSubMajorHead>();
  List <BudMinorSubHead> gridminorsubheadList = new ArrayList<BudMinorSubHead>();
  List <BudObjectHead> gridobjectheadList = new ArrayList<BudObjectHead>();
  String num=(String)map.get("num");
  String maxTrainingServiceNum=(String) map.get("maxTrainingServiceNum");
  searchBudVoucherDetailList= (List <BudVoucherDetail>)map.get("searchBudVoucherDetailList");
  searVoucherHeaderList=(List <BudVoucherHeader>)map.get("searVoucherHeaderList");
  searchEstimateEntryList = (List <BudEstimateEntry>)map.get("searchEstimateEntryList");
  searchFinancialYearList=(List<HrMasFinancialYear>)map.get("searchFinancialYearList");
  searchmajorheadList=(List<BudMajorHead>)map.get("searchmajorheadList");
  searchsubmajorheadList=(List<BudSubMajorHead>)map.get("searchsubmajorheadList");
  searchminorsubheadList=(List<BudMinorSubHead>)map.get("searchminorsubheadList");
  searchobjectheadList=(List<BudObjectHead>)map.get("searchobjectheadList");
  gridmajorheadList = (List <BudMajorHead>)map.get("gridmajorheadList");
  gridsubmajorheadList=(List <BudSubMajorHead>)map.get("gridsubmajorheadList");
  gridminorsubheadList=(List<BudMinorSubHead>)map.get("gridminorsubheadList");
  searchminorheadList=(List<BudMinorHead>)map.get("searchminorheadList");
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
int billNo=1;
if(map.get("billNo") != null){
	billNo = (Integer)map.get("billNo");
}

%>
<div class="titleBg">
<h2>Fully Vouched Contingent Bill Entry</h2>
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
<label><span>*</span>Sr. No:</label>
<select name="<%=CODE %>" validate="Bill NO No,string,yes">
	<option value="">Select</option>
	<%for (BudVoucherHeader header :searVoucherHeaderList ) {
		String toDeptName="";
		if(header.getBillNo()!=null){
			toDeptName=" [ "+header.getBillNo()+" ]";
		}

	%>
	<option value=<%=header.getId()%>><%=header.getBillNo()%></option>
	<%}%>
</select> <input type="image" name="button" class="button" onClick="submitForm('s','budget?method=searchBillNo');" />
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
<script type="text/javascript">
formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%=SEARCH_NAME%>"], [3,"<%=MAJOR_HEAD_ID%>"],[4,"<%=MAJOR_SUB_HEAD_ID%>"],[5,"<%=MINOR_SUB_HEAD_ID%>"],[6,"<%=OBJECT_HEAD_ID%>"],[7,"<%=BILL_DATE%>"],[8,"<%=ENCASH_DATE%>"], [9,"<%=STATUS%>"],[10,"<%=AMOUNT%>"],[11,"<%=CHARGE_CODE%>"], ];
	 statusTd = 11;
	</script>
<form name="voucher" method="post">
<input type="hidden" name="<%= POJO_NAME %>" value="BudVoucherHeader">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DescriptionOfCharge">
<input	type="hidden" name="title" value="Country">
<input type="hidden" name="pojoPropertyCode" value="BillNo">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Sr No</label>
<input id="billNoId" type="text"   name="<%=CODE%>" value="<%=num %>"   tabindex=1 />

<label><span>*</span>  Date</label>
<label class="value"><%=date %></label>
<input type="hidden" name="<%=BILL_DATE %>" id="date" value="<%=date %>" />
<label><span>*</span> Sector Type</label>
<select name="<%=SECTOR_TYPE%>" tabindex="1" validate="Sector Type,string,yes">
<option>Select</option>
<option>Plan</option>
<option>Non-Planned</option>
</select>
<div class="clear"></div>
<label>Major Head Name</label>
<select	name="<%= MAJOR_HEAD_ID %>" class="Large" tabindex=1 onchange="populatemajorHead(this.value,'voucher');" validate="Major Head Name,string,yes" >
<option value="0">Select</option>
<%
for (BudMajorHead majorHead: searchmajorheadList){
%>
<option value="<%=majorHead.getId()%>">
<%=majorHead.getMajorHeadName()%></option>
<%}%>
</select>

<label>Major Sub Head Name</label>
<select	name="<%=MAJOR_SUB_HEAD_ID %>" validate="Major Sub Head Name,string,yes" id="subMajorHeadId" class="Large" tabindex=1  onchange="populatesubmajorHead(this.value,'voucher');">
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
<label>Minor Head Name</label>
<select	name="minorHeadId1"  validate="Minor Head Name,string,yes" id="minorHead1"  tabindex=1 class="Large" onchange="populateminorHead(this.value,'voucher');"  >
<option value="0">Select</option>
<%
			for(BudMinorHead minorHead : searchminorheadList){
			%>
	<option value="<%=minorHead.getId() %>">
	<%=HMSUtil.isSelected(minorHead.getId(),Integer.valueOf(box.getInt("minorHead1")))%>><%=minorHead.getMinorHeadName() %></option>
	<%}%>
	
	</select>
<script type="text/javascript">

<%

	int counter2 = 0;

	for (BudSubMajorHead submajorhead : searchsubmajorheadList){
	for (BudMinorHead minorHead : searchminorheadList) {
		if(minorHead.getSubMajorHeadId() != null){
	if(submajorhead.getId().equals(minorHead.getSubMajorHeadId().getId() )){
		
%>
majorHeadCodeArray2[<%=counter2%>] = new Array();
majorHeadCodeArray2[<%=counter2%>][0]=<%=submajorhead.getId()%>;
majorHeadCodeArray2[<%=counter2%>][1] = <%=minorHead.getId()%>;

majorHeadCodeArray2[<%=counter2%>][2] = "<%=minorHead.getMinorHeadName().trim()%>";
	<%
	counter2++;
	} } } }

%>
</script> 
<div class="clear"></div>
<label>Minor Sub Head</label>
<select	name="<%= MINOR_SUB_HEAD_ID %>"  validate="Minor Sub Head Name,string,yes" id="minorHeadId"  tabindex=1 class="Large" onchange="populateminorsubHead(this.value,'voucher');" >
<option value="0">Select</option>
<%
for (BudMinorSubHead majorHead: searchminorsubheadList){
%>
<option value="<%=majorHead.getId()%>">

<%=HMSUtil.isSelected(majorHead.getId(),Integer.valueOf(box.getInt(MINOR_SUB_HEAD_ID)))%>><%=majorHead.getMinorSubHeadName() %></option>
<%}%>
	</select>
	<script type="text/javascript">

<%

	int counts = 0;

	for (BudMinorHead minorHead : searchminorheadList){
	for (BudMinorSubHead majorHead: searchminorsubheadList) {
		if(majorHead.getMinorHeadId() != null){
	if(minorHead.getId().equals(majorHead.getMinorHeadId().getId() )){
		
%>
codeArray[<%=counts%>] = new Array();
codeArray[<%=counts%>][0]=<%=minorHead.getId()%>;
codeArray[<%=counts%>][1] = <%=majorHead.getId()%>;

codeArray[<%=counts%>][2] = "<%=majorHead.getMinorSubHeadName().trim()%>";
	<%
	counts++;
	} } } }

%>
</script>
<label><span>*</span> Object Head Name</label>
<select	name="<%= OBJECT_HEAD_ID %>" validate="Object Head Name,string,yes"  id="objectId"  tabindex=1  onchange="getObjectHeadId(this.value);" >
<option value="0">Select</option>
<%
			for(BudObjectHead objectHead : searchobjectheadList){
			%>
	<option value="<%=objectHead.getId() %>"
		<%=HMSUtil.isSelected(objectHead.getId(),Integer.valueOf(box.getInt(OBJECT_HEAD_ID)))%>><%=objectHead.getObjectHeadName() %></option>
	<%}%>
	</select>
<script type="text/javascript">
<%
int counts1 = 0;
for (BudMinorSubHead minorHead : searchminorsubheadList){
	for (BudObjectHead objectHead : searchobjectheadList) {
	if(objectHead.getMinorSubHeadId() != null){
	if(minorHead.getId().equals(objectHead.getMinorSubHeadId().getId() )){
		%>
objectHeadCodeArray[<%=counts1%>] = new Array();
objectHeadCodeArray[<%=counts1%>][0] = <%=minorHead.getId()%>;
objectHeadCodeArray[<%=counts1%>][1] = <%=objectHead.getId()%>;
objectHeadCodeArray[<%=counts1%>][2] = "<%=objectHead.getObjectHeadName()%>";
<%
counts1++;
}
}
}
}
%>
</script>  

<label><span>*</span> Encash Date</label>
<input type="text"  validate="Encash Date,string,yes" name="<%=ENCASH_DATE %>" class="date"  id="date" value="<%=date %>" />
<img src="/hms/jsp/images/cal.gif" id="startdate" onClick="javascript:setdate('',document.voucher.<%=ENCASH_DATE%>,event)"width="16" height="16" border="0" validate="Pick a date" class="calender" />
<div class="clear"></div>
<label><span>*</span> Description Of Charge</label>
<textarea class="large" name="<%=SEARCH_NAME %>" tabindex="1"   rows="2" cols="160" name="remarks" style=""></textarea>
</div>
<div class="clear" > </div>
<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" />
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" />
<div class="clear" > </div>

<table border="0" cellspacing="0" cellpadding="0" id="grid">
	<tr>
		<th scope="col"></th>
		<th scope="col">No Of Sub Voucher</th>
 		<th scope="col">Description Of Charge No and Date Of Authority For All Charges</th>
		<th scope="col">Amount</th>
		<th scope="col">Remarks</th>
	</tr>
	<%
	int inc=1;
	%>
<tr>
		<td><input type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioCheck" id="selectedChrage<%=inc%>"/></td>
		<td><input type="text" id="subvoucher<%=inc%>"  readonly="readonly" value="<%=inc%>"  name="subvoucher<%=inc%>" size="15"  /></td>
		<td width="5%"><input type="text" id="description<%=inc%>" name="description<%=inc%>" size="50"  /></td>
		<td><input type="text" id="amount<%=inc%>" name="amount<%=inc%>" onkeypress="return isNumberKey(event)" size="25" /></td>
		<td width="5%"><input type="text" id="remark<%=inc%>" name="remark<%=inc%>" size="25"  /></td>
		<input type="hidden" name="totalamount" id="totalamount" >
  	</tr>
</table>
 <input type="hidden" name="hdb" value="1" id="hdb" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit" onclick="total();submitForm('voucher','budget?method=addVoucher');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<form name="voucherReport" method="post">
<!--<input type="button" tabindex="1" accesskey="g" onclick="submitForm('voucherReport','generalMaster?method=generateReportForGeneralMasters');" class="button" value="PRINT" name="Report" />
--><input type="hidden" name="<%=JASPER_FILE_NAME%>" value="fully_vouched_bill" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
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
<div class="clear"></div>
<div class="paddingTop40"></div>


<script type="text/javascript"><!--
		function fillSrNo(rowVal){
 		var pageNo=parseInt(document.getElementById('noOfRecords').value);
		rowVal=rowVal%8
		if(rowVal==0){
		rowVal=8
		}
		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
		document.getElementById('noOfRecords').value=rowVal
		}
		return true;
		}
		function checkForBrandWardConsumption(val,inc,deptId,deptName){

		if(val != "")
		{
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*8)+1;
		var end=((pageNo-1)*8)+8;

		var index1 = val.lastIndexOf("[");
		var indexForBrandName=index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var itemId = val.substring(index1,index2);
		var indexForBrandName=indexForBrandName--;
		var brandName=val.substring(0,indexForBrandName);
		if(brandName =="")
		{

		return;
		}
		for(i=1;i<inc;i++){

		if(inc != 1){
		if(document.getElementById('brandName'+i).value==val)
		{
		alert("Item already selected...!")
		document.getElementById('brandName'+inc).value=""
		var e=eval(document.getElementById('brandName'+inc));
		e.focus();
		return false;
		}
		}
		}
		ajaxFunctionForAutoCompleteWardConsumption('wardConsumption','ipd?method=fillItemsInGrid&brandName=' +  brandName , inc);
		}
		}
 		function openPopup(brandId,deptId,rowVal,deptName){
		var url="/hms/hms/ipd?method=showStockDetailsJsp&brandId="+brandId+"&deptId="+deptId+"&rowVal="+rowVal+"&deptName="+deptName;
		popwindow(url);
		}
		function popwindow(url)
		{
		newwindow=window.open(url,'name',"height=400,width=700,status=1");
		}

		function openPopupForDelete(ipIssueNo){
		var url="/hms/hms/ipd?method=modifyWardConsumptionJsp&ipIssueNo="+ipIssueNo;
		popwindowForDelete(url);
		}
		function openPopupForViewStock(){
		var issueNo=document.getElementById("issueNo").value;
 		var url="/hms/hms/ipd?method=viewStockDetailsJsp&issueNo="+issueNo;
		popwindowForDelete(url);
		}
		function popwindowForDelete(url)
		{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=980,');
		}

		function addRow(){

			  var tbl = document.getElementById('grid');
			  var lastRow = tbl.rows.length;
 
			  var iteration = lastRow;
			  var row = tbl.insertRow(lastRow);
			  var hdb = document.getElementById('hdb');
			  iteration = parseInt(hdb.value)+1;
			  hdb.value=iteration;

		    var cellRight0 = row.insertCell(0);
			var e0 = document.createElement('input');
			e0.type = 'checkbox';
			e0.name='selectedChrage';
			e0.id ='selectedChrage'+iteration;
			e0.className = 'radioCheck';
			e0.value=(iteration);
			cellRight0.appendChild(e0);

			  var cellRight1 = row.insertCell(1);
			  var e1 = document.createElement('input');
			  e1.name='subvoucher'+iteration;
			  e1.id='subvoucher'+iteration;
			  e1.size='15'
			  e1.value=iteration;
			  cellRight1.appendChild(e1);

			  var cellRight2 = row.insertCell(2);
			  var e2 = document.createElement('input');
			  e2.name='description'+iteration;
			  e2.id='description'+iteration;
			  e2.size='50'
			  cellRight2.appendChild(e2);

			  var cellRight3 = row.insertCell(3);
			  var e3 = document.createElement('input');
			  e3.name='amount'+iteration;
			  e3.id='amount'+iteration;
			  e3.size='25'
			  e3.onkeypress=function()
			  {
				  isNumberKey(this.value,hdb.value);
			  };
			  cellRight3.appendChild(e3);

			  var cellRight4 = row.insertCell(4);
			  var e4 = document.createElement('input');
			  e4.name='remark'+iteration;
			  e4.id='remark'+iteration;
			  e4.size='25'
			  cellRight4.appendChild(e4);
	}

		
	function removeRow()
	{
		var dcr=document.getElementById('hdb').value;
		dcr=(parseInt(dcr))-1;
		document.getElementById('hdb').value=dcr;
		var tbl = document.getElementById('grid');
		 var tblRows  = tbl.getElementsByTagName("tr");

	  	if(tblRows.length-2==0){
	         	alert("Can not delete all rows")
	         	return false;
	     }

		for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
		{
			if (document.getElementsByName('selectedChrage')[counter].checked == true)
			{
			  	tbl.deleteRow(counter+1);
			}
		}
	}

function populateItem(val,incr){
       var pvmsNo;
		if(val !=""){
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		ItemId = val.substring(index1,index2);
     	document.getElementById('ItemId'+incr).value=ItemId;

 if(ItemId != ""){
		for(i=1;i<incr;i++)
		{
 			if(incr != 1)
			{
			if(val!=""){
			if(document.getElementById('nomenclature'+i).value == val)
					{
					alert("Item Name already selected...!");
					document.getElementById('nomenclature'+incr).value="";
					document.getElementById('ItemId'+incr).value="";
					document.getElementById('batchNo'+incr).value="";
					var e=eval(document.getElementById('nomenclature'+incr));
					e.focus();
				}
				}else{
				return false;
				}

			}
	  	}

submitProtoAjaxForLionClass('wardConsumption','/hms/hms/ipd?method=getItemStock&ItemId='+ItemId+"&counter="+incr,incr);
    }
  }
}
function submitProtoAjaxForLionClass(formName,action,incr){

	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)

        	new Ajax.Updater('testDiv'+incr,url,
		  {asynchronous:true, evalScripts:true });
    	   	document.getElementById('brandId'+incr).style.display='none';
			return true;
    	}
function populateClosingStock(val,count){

	var ItemId = document.getElementById('ItemId'+count).value;
  		submitProtoAjaxForClosingStock('wardConsumption','/hms/hms/ipd?method=getItemClosingStock&batchNo='+val+'&counter='+count+'&ItemId='+ItemId,count);
		submitProtoAjaxForNomenClature('opdMain','/hms/hms/opd?method=getNomenclature&brandId='+val+'&counter='+count,count);

}
function submitProtoAjaxForClosingStock(formName,action,counter){

	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;

    	   	 var url=action+"&"+getNameAndData(formName)
			new Ajax.Updater('stockDiv'+counter,url,
			  {asynchronous:true, evalScripts:true });
    	 	document.getElementById('manufacturer'+counter1).style.display='none';
    	   	return true;
    	}
function validate(inc)
{
 	closeStock  = parseFloat(document.getElementById('closeStock'+inc).value);
    compQuantity = parseFloat(document.getElementById('compQuantity'+inc).value);
    if(closeStock<=compQuantity)
    {
      alert('Comp. Quantity should not be greater than closing Stock !!!');
      document.getElementById('compQuantity'+inc).focus();
      return false;
    }
	return true;
}
</script>
<SCRIPT language=Javascript>//script for entering only integer
      
      function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode

                 var amount = document.getElementById('amount'+count).value;
        		 
         if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

         return true;
      }
      //
</SCRIPT>   
<script>
function number(count){
	 var totalAmount = parseInt(amount);
	 alert(totalAmount);
	 document.getElementById('totalAmount').value = totalAmount;
}
</script>

 <script language="javascript" type="text/javascript">
function randomString() {
	var chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";
	var string_length = 8;
	var randomstring = '';
	for (var i=0; i<string_length; i++) {
		var rnum = Math.floor(Math.random() * chars.length);
		randomstring += chars.substring(rnum,rnum+1);
	}
	document.randform.randomfield.value = randomstring;
}
</script>
<script>
function total(){
	 var hdb = document.getElementById('hdb');

	 var totalamount=0;
	 for(i=1;i<=hdb.value;i++){
	var amountvalue=document.getElementById('amount'+i).value	

	totalamount=parseInt(totalamount)+parseInt(amountvalue);
	 }
	 document.getElementById('totalamount').value = totalamount;

}
</script>
