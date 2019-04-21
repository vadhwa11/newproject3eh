<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * update_Local_Purchase.jsp  
 * Purpose of the JSP -  This is for Update Local Purchase.
 * @author  Deepti Tevatia
 * Create Date: 21th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.7
--%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="java.math.BigDecimal"%>


<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<script type="text/javascript" language="javascript">
	var itemsArray1=new Array();
 	var numLinesAdded = 1;
 	var tt;
  function fillItems(idVal,rowVal){
 	var idItem="idItem";
   	var codeItem="codeItem";
   	var nameItem="nameItem";
   	var idAu="idAu";
   	idItem=idItem+rowVal;
   	codeItem=codeItem+rowVal;
   	nameItem=nameItem+rowVal;
   	idAu=idAu+rowVal;
   	
   	var pageNo=parseInt(document.getElementById('noOfRows').value);
   	rowVal=rowVal%10
   	if(rowVal==0){
   		rowVal=10
   	 	}
   	if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
   	
   	document.getElementById('noOfRows').value=rowVal
	}
	for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==idVal){
			document.getElementById(idItem).value=itemsArray1[i][0]
			document.getElementById(nameItem).value=itemsArray1[i][2]
			document.getElementById(idAu).value=itemsArray1[i][3]
		}
	}
	
  }
function goPrevious(){
var pageNo=document.getElementById("pageNo").value;
if(pageNo==1){
alert("You are On First Page")
return false;
}
var prePage=(parseInt(pageNo)-1);
submitForm('purchaseGrid','purchaseOrder?method=updatePurchaseOrder&goPage='+prePage+'');
}
function goNext(){
var pageNo=document.getElementById("pageNo").value;
var totalPages=document.getElementById("totalPages").value;

if(parseInt(totalPages+1)<pageNo){

alert("the Page no u want to navigate is greater than total pages ");
return false;
}else{
pageNo=(parseInt(pageNo)+1);
if(checkForNext() )
submitForm('purchaseGrid','purchaseOrder?method=updatePurchaseOrder&goPage='+pageNo+'');
}

}
function goPage(){
var pageNo=document.getElementById("gopage").value;
var totalPages=document.getElementById("totalPages").value;
if(totalPages<pageNo){
alert("the Page no u want to navigate is greater than total pages ");
return false;
}
else{
submitForm('purchaseGrid','purchaseOrder?method=updatePurchaseOrder&goPage='+pageNo+'');
}
}
function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalPoFormatJsp";
  obj.submit();
}
  function checkForNext(){
  if(document.getElementById('noOfRows').value < 10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
  return true;
  }
  }
  function showReportWithStock(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalPoFormatJsp&withStock=true";
  obj.submit();
}
  
  
  function checkForSubmit(){
  if(document.getElementById('noOfRows').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
  }
   function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalPoFormatJsp";
  obj.submit();
}
// For new AutoComplete

function checkForPurchase(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=start;i<=end;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	return false;
	    	}
	    }}
	    
		ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsforPurchase&pvmsNo=' +  encodeURIComponent(pvms) , inc);
} 

function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%10
   		if(rowVal==0){
   			rowVal=10
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}
function get_value_for_purchase(rowNo,detailId)
{
 var url="/hms/hms/purchaseOrder?method=showMoreInfoPurchaseJsp&detailId="+detailId+"&rowNo="+rowNo;
   popwindow(url);
 }  

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=500,width=600,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}
</script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> purchaseMap = new HashMap<String, Object>();
	String noDetailRecords = "no";
	String previousPage = "no";
	int pageNo = 1;
	int poId = 0;
	BigDecimal netAmount = null;
	BigDecimal netCalculatedAmount = null;
	
	int totalPages = 0;
	//List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();
	List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
	List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
	List<MasManufacturer> masManufacturerList = new ArrayList<MasManufacturer>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}

	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");

	if (map.get("poId") != null) {
		poId = Integer.parseInt("" + map.get("poId"));
	//
	}
	//if(map.get("previousPage")!=null){
	//previousPage=(""+map.get("previousPage"));
	//}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt("" + map.get("pageNo"));
	}
	if (map.get("totalPages") != null) {
		totalPages = Integer.parseInt("" + map.get("totalPages"));
	}
	if (map.get("poNumberList") != null) {
		poNumberList = (List<StorePoHeader>) map.get("poNumberList");
	}

	if (map.get("poHeaderList") != null) {
		poHeaderList = (List<StorePoHeader>) map.get("poHeaderList");
	}

	if (map.get("masManufacturerList") != null) {
		masManufacturerList = (List<MasManufacturer>) map
				.get("masManufacturerList");
	}

		//	+ poNumberList.size());
	if (map.get("poDetailList") != null) {
		poDetailList = (List<StorePoDetail>) map.get("poDetailList");
	}
	//if (map.get("poHeaderList") != null) {
	//poHeaderList = (List<StorePoHeader>)map.get("poHeaderList");
	//}
	if (map.get("purchaseMap") != null) {
		purchaseMap = (Map<String, Object>) map.get("purchaseMap");
	}
	if (purchaseMap.get("supplierList") != null) {
		supplierList = (List<MasStoreSupplier>) purchaseMap
				.get("supplierList");
	}
			//+ supplierList.size());
	//if(purchaseMap.get("itemList")!=null){
	//	itemList = (List<MasStoreItem>) purchaseMap.get("itemList");
	//}
	if (map.get("noDetailRecords") != null) {
		noDetailRecords = ("" + map.get("noDetailRecords"));
	}
%>


<form name="poMain" method="post">
<h2>Update Purchase Order Entry</h2>
<div class="clear"></div>
<div class="search" id="threadsearch">
<a href=""></a> 
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<!-- <input type="button" name="Modify" value="Modify" class="button"  onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');" /> -->
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>

<input type="hidden" name="s"	value="cccfbaab0a70ed43fad9de8e3733112d" /> 
<input type="hidden"	name="do" value="process" /> 
<input type="hidden" name="searchthread"	value="1" /> 
<input type="hidden" name="showposts" value="1" /> 
<input	type="hidden" name="searchthreadid" value="85875" />
<div class="paddingTop15"></div>
<div class="clear"></div>
<label>From Date </label> 
<input type="text" name="<%= FROM_DATE %>"	class="date" maxlength="30" tabindex=1 /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.poMain.<%= FROM_DATE%>,event);" />
<label>To Date </label> 
<input type="text" name="<%= TO_DATE %>" class="date" maxlength="30" tabindex=1 /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.poMain.<%= TO_DATE%>,event);" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<label>P.O.No </label> 
<select name="<%=PO_ID%>">
	<option value="0">Select</option>
	<%
		for (StorePoHeader obj : poNumberList) {
	%>
	<option value="<%=obj.getId() %>"><%=obj.getPoNumber()%></option>
	<%
		}
	%>
</select> <%-- 			
<label>Supplier Name :</label> 
<select	name="<%= SUPPLIER_ID %>" id="supplierId" validate="Vendor Name,String,no">
<option value="0">--Select--</option>
<%
			for (MasStoreSupplier masStoreSupplier :supplierList ) {
%>
<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
<%
			}
%>
</select> 
--%> 
<input type="image" class="button" 	onClick="submitForm('poMain','purchaseOrder?method=searchPO');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<div class="clear"></div>
</div>
<div class="clear"></div>
<form name="purchaseGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input type="hidden"
	name="totalPages" value="<%=totalPages%>" id="totalPages" /> <%
 	poHeaderList = new ArrayList<StorePoHeader>();
 	StorePoHeader poHeaderObj = null;
 	if (map.get("poHeaderList") != null) {
 		poHeaderList = (List<StorePoHeader>) map.get("poHeaderList");

 		if (poHeaderList.size() > 0) {
 			poHeaderObj = (StorePoHeader) poHeaderList.get(0);
 			poId = poHeaderObj.getId();
 			netAmount = poHeaderObj.getNetAmount();
 			netCalculatedAmount=netAmount;
 				//	+ poHeaderObj.getPoNumber());
 				//	+ poHeaderObj.getSigningAuthority());
 		}
 	}
 %> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <input type="hidden" name="totalRecords"	value="<%=poDetailList.size() %>" /> 
 <!--
<input type="button" class="buttonBig" value="Budget Status" onclick="window.open('/hms/hms/purchaseOrder?method=showBudgetStatus','new','left=200,top=100,width=425,height=350')" /> 
<input type="button" class="buttonBig" value="Approval Authority" onclick="window.open('/hms/hms/purchaseOrder?method=showApprovalAuthority&poId='+purchaseGrid.<%=PO_ID %>.value,'new','left=200,top=100,width=525,height=350')" /> 	-->
<input type="button" name="print" type="submit" class="button"	value="Print" onClick="showReport('purchaseGrid');">
<input	type="button" name="print" type="submit" class="buttonBig2"	value="Print With Stock Details" onClick="showReportWithStock('purchaseGrid');"> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%
	if (poHeaderObj != null) {
		int tender_id = 0;
		int group_id = 0;

		try {
			tender_id = poHeaderObj.getTenderM().getId();
		} catch (Exception e) {
			tender_id = 0;
		}

		try {
			group_id = poHeaderObj.getGroup().getId();
		} catch (Exception e) {
			group_id = 0;
		}
%> <input type="hidden" name="tender_id" value="<%=tender_id%>" /> <input
	type="hidden" name="group_id" value="<%=group_id%>" /> <%
 	}
 %> <%
 	String dt = "";
 	String poDate = "";
 	String deliveryDate = "";
 	String quotationDate = "";
 	String converted_date = "";
 	if (poHeaderObj != null) {
 		dt = poHeaderObj.getPoDate().toString();
 		converted_date = HMSUtil
 				.convertDateToStringWithoutTime(poHeaderObj.getPoDate());
 		poDate = converted_date;

 		dt = HMSUtil.convertDateToStringWithoutTime(poHeaderObj
 				.getDeliveryDate());

 		deliveryDate = dt;

 		dt = poHeaderObj.getQuotationDate().toString();
 		converted_date = HMSUtil
 				.convertDateToStringWithoutTime(poHeaderObj
 						.getQuotationDate());
 		quotationDate = converted_date;

 	}
 %>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label class="medium">P.O. Number</label> <%
 	if (poHeaderObj != null) {
 %> <input type="text" class="date" name="<%= PO_NO %>"
	value="<%=poHeaderObj.getPoNumber()%>" class="readOnly"
	readonly="readonly" validate="P.O. Number ,String,yes" tabindex=1 /> <label
	class="medium">P.O.Date </label> <input type="text" class="date"
	name="<%= PO_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(poHeaderObj.getPoDate())%>"
	class="readOnly" readonly="readonly" tabindex=1 /> <%
 	} else {
 %> <input type="text" class="date" name="<%= PO_NO %>" value=""
	validate="P.O. Number ,String,yes" tabindex=1 /> <label class="medium">P.O.Date
</label> <input type="text" class="readOnly" name="<%= PO_DATE %>"
	value="<%=currentDate %>" readonly="readonly" tabindex=1
	validate="P.O. Date ,dateOfAdmission,no" /> <%
 	}
 %> <label class="medium">Vendor Name</label> <select
	name="<%= SUPPLIER_ID %>" validate="Vendor Name,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
		for (MasStoreSupplier masStoreSupplier : supplierList) {
			if (poHeaderObj != null) {
				if (poHeaderObj.getSupplier().getId().equals(
						masStoreSupplier.getId())) {
	%>

	<option value=<%=masStoreSupplier.getId()%> selected="selected"><%=masStoreSupplier.getSupplierName()%></option>
	<%
		} else {
	%>

	%>
	<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
	<%
		}
			}
		}
	%>
</select> <%
 	if (poHeaderObj != null) {
 %> <label class="medium">Delivery Date</label> <input type="text"
	class="readOnly" name="<%= DELIVERY_DATE %>" value="<%=deliveryDate %>"
	readonly="readonly" tabindex=1 /> <%
 	} else {
 %> <label class="medium">Delivery Date</label> <input type="text"
	class="readOnly" name="<%= DELIVERY_DATE %>" value="<%=currentDate %>"
	readonly="readonly" tabindex=1
	validate="Delivery Date ,deliveryDate,no" /> <%
 	}
 %>

<div class="clear"></div>

<label class="medium">Quotation No.</label> <%
	String quotationNumber="";
 	if (poHeaderObj != null) {
 		if(poHeaderObj.getQuotationNumber()!=null){
 			quotationNumber=poHeaderObj.getQuotationNumber();	
 		}
 %> <input type="text" class="date" maxlength="100"
	name="<%= QUOTATION_NO %>"
	value="<%=quotationNumber%>" class="readOnly"
	readonly="readonly" validate="Quotation No,String,no" tabindex=1 /> <%
 	} else {
 %> <input type="text" class="date" maxlength="100"
	name="<%= QUOTATION_NO %>" value="" validate="Quotation No,String,yes"
	tabindex=1 /> <%
 	}
 %> <label class="medium">Quotation Date</label> <%
 	if (poHeaderObj != null) {
 %> <input type="text" class="date" name="<%= QUOTATION_DATE %>"
	value="<%=quotationDate%>" class="readOnly" readonly="readonly"
	tabindex=1 /> <%
 	} else {
 %> <input type="text" class="date" name="<%= QUOTATION_DATE %>"
	value="<%=currentDate %>" class="readOnly" readonly="readonly"
	tabindex=1 validate="Quotation Date,dateOfAdmission,yes" /> <%
 	}
 %> <label class="medium">Payment Terms</label> <%
 String payTerms="";
	if (poHeaderObj != null) {
		if(poHeaderObj.getPayTerms()!=null){
			payTerms=poHeaderObj.getPayTerms();
		}
 %> <textarea name="<%=PAY_TERMS %>" validate="Payment Terms ,String,no"
	tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"> </textarea> <script>document.purchaseGrid.<%=PAY_TERMS%>.innerHTML = "<%=payTerms%>"</script>
<%
	} else {
%> <textarea name="<%=PAY_TERMS %>" validate="Payment Terms ,String,no"
	tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /> </textarea> <script>document.purchaseGrid.<%=PAY_TERMS%>.innerHTML = "<%=poHeaderObj.getPayTerms() %>"</script>
<%
	}
%> <label class="medium">Delivery Terms</label> <%
String deliveryTerms="";
if (poHeaderObj != null) {
	if(poHeaderObj.getDeliveryTerms()!=null){
		deliveryTerms=poHeaderObj.getDeliveryTerms();
	}
 %> <textarea value="<%= poHeaderObj.getDeliveryTerms()%>"
	name="<%=DELIVERY_TERMS %>" validate="Delivery Terms ,String,no"
	tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /> </textarea> <script>document.purchaseGrid.<%=DELIVERY_TERMS%>.innerHTML = "<%=deliveryTerms%>"</script>
<%
	} else {
%> <textarea value="" name="<%=DELIVERY_TERMS %>"
	validate="Delivery Terms ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /> </textarea> <script>document.purchaseGrid.<%=DELIVERY_TERMS%>.innerHTML = "<%=poHeaderObj.getDeliveryTerms() %>"</script>
<%
	}
%>

<div class="clear"></div>

<label class="medium">Remarks</label> <%
String remark="";
if (poHeaderObj != null) {
	if(poHeaderObj.getRemarks()!=null){
		remark=poHeaderObj.getRemarks();
	}
 %> <textarea value="<%=poHeaderObj.getRemarks()%>" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /> </textarea> <script>document.purchaseGrid.<%=REMARKS%>.innerHTML = "<%=remark %>"</script>
<%
	} else {
%> <textarea value="" name="<%=REMARKS %>" validate="Remarks ,String,no"
	tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /> </textarea> <script>document.purchaseGrid.<%=REMARKS%>.innerHTML = "<%=poHeaderObj.getRemarks() %>"</script>

<%
	}
%> <label class="medium">Signing Authority</label> <%
 	if (poHeaderObj != null) {
 %> <textarea name="<%=LPO_SIGNING_AUTHORITY %>"
	validate="Signing Authority ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /><%=poHeaderObj.getSigningAuthority().equals("0")?"":poHeaderObj.getSigningAuthority() %></textarea>
<%
 	} else {
 %> <textarea value="" name="<%=LPO_SIGNING_AUTHORITY %>"
	validate="Signing Authority ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /></textarea> <%
 	}
 %>

<div class="clear"></div>
</div>
<div class="clear"></div>
<%
	if (poHeaderList.get(0).getStatus().equalsIgnoreCase("o")) {
%> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="update" align="right" class="button"	value="Update"	onclick="if(checkForSubmit() && checkForLocalPurchaseGrid()){submitForm('purchaseGrid','purchaseOrder?method=updatePurchaseOrder');}" />
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div id="pagination">
<input type="hidden" class="previous"	value="Previous" readonly="readonly" onclick="goPrevious()"	align="left" /> 
Page <span class="selected"><%=pageNo %></span> of <span	class="selected"><%=totalPages %></span> 
<a	onclick="javascript:goPrevious()" class="next">Previous</a> <a
	onclick="javascript:goNext()" class="next">Next</a> <input type="text"
	id="gopage" name="gopage" size="3" /> <input type="button"
	name="Go Page" type="submit" class="button" value=" "
	onclick="goPage();"> <input type="hidden" size="2" value="0"
	name="noOfRecords" id="noOfRecords" /></div>
<%
	}
%>

<div class="clear"></div>

<input type="hidden" name="<%=NO_DETAIL_RECORDS%>"
	value="<%=noDetailRecords%>" /> <input type="hidden" size="2"
	value="0" name="<%=NO_OF_ROWS %>" id="noOfRows" /> <input
	type="hidden" name="<%=PO_ID %>" value="<%=poId %>" id="poId" />

<div class="clear"></div>
<div class="clear"></div>
<h4>Purchase Order Details</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="cmntable">
<table width="100%" colspan="7" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<th>S.No.</th>

		<th>Item Name</th>
		<th>UOM</th>
		<!-- <th>>Brand</th>  -->
		<th>Manufacturer</th>
		<th>QOH.</th>
		<th>Ordered Qty</th>
		<th>Free Qty</th>
		<th>Dispen.Type</th>
		<!-- <th>MDQ</th>
<th>Rate Per MDQ</th>-->
		<th>Unit Rate</th>
		<th>Discount(%)</th>
		<th>MRP</th>
		<th>Tax(%)</th>
		<th>Other Taxes(in Rs.)</th>
		<th>Amount</th>
		<th>Free Item</th>
	</tr>

	<%
		BigDecimal pageTotal = new BigDecimal(0);
		int detailCounter = 10;
		int temp = 0;
		String idItem = "idItem";
		String codeItem = "codeItem";
		String nameItem = "nameItem";
		String idAu = "idAu";
		String quantityInVar = "quantityInVar";
		String taxVar = "taxVar";
		String unitRateVar = "unitRateVar";
		String amountVar = "amountVar";
		String discountVar = "discountVar";

		String quantityInVarTemp = "quantityInVarTemp";
		String taxVarTemp = "taxVarTemp";
		String unitRateVarTemp = "unitRateVarTemp";
		String amountVarTemp = "amountVarTemp";
		String discountVarTemp = "discountVarTemp";
		String incVar = "incVar";

		String freeQty = "freeQty";
		String amount = "amount";
		String manufacturerId = "manufacturerId";
		String brandId = "brandId";
		String freeItem = "freeItem";

		String dispenseType = "dispenseType";
		String mdq = "mdq";
		String ratePerMdq = "ratePerMdq";
		String mrp = "mrp";
		String otherTaxes = "otherTaxes";
		String totalCarryForward = "totalCarryForward";
		String quantityInHand = "quantityInHand";

		String idItem2 = "idItem";
		String codeItem2 = "codeItem";
		String nameItem2 = "nameItem";
		String idAu2 = "idAu";
		String quantityInVar2 = "quantityInVar";
		String taxVar2 = "taxVar";
		String unitRateVar2 = "unitRateVar";
		String amountVar2 = "amountVar";
		String discountVar2 = "discountVar";

		String freeQty2 = "freeQty";
		String amount2 = "amount";
		String manufacturerId2 = "manufacturerId";
		String brandId2 = "brandId";
		String freeItem2 = "freeItem";

		String quantityInVarTemp2 = "quantityInVarTemp";
		String taxVarTemp2 = "taxVarTemp";
		String unitRateVarTemp2 = "unitRateVarTemp";
		String amountVarTemp2 = "amountVarTemp";
		String discountVarTemp2 = "discountVarTemp";
		String incVar2 = "incVar2";

		String dispenseType2 = "dispenseType";
		String mdq2 = "mdq";
		String ratePerMdq2 = "ratePerMdq";
		String mrp2 = "mrp";
		String otherTaxes2 = "otherTaxes";
		String totalCarryForward2 = "totalCarryForward";
		String quantityInHand2 = "quantityInHand";

		
		int inc = ((pageNo - 1) * 10) + 1;
	
		int incTemp2 = inc + 10;
		for (StorePoDetail storePoDetail : poDetailList) {
			pageTotal = pageTotal.add(storePoDetail.getAmount());

			if (inc < incTemp2) {
	%>

	<%
		idItem = idItem2 + ("" + inc);
				codeItem = codeItem2 + ("" + inc);
				nameItem = nameItem2 + ("" + inc);
				idAu = idAu2 + ("" + inc);

				quantityInVar = quantityInVar2 + ("" + inc);
				taxVar = taxVar2 + ("" + inc);
				unitRateVar = unitRateVar2 + ("" + inc);
				amountVar = amountVar2 + ("" + inc);
				discountVar = discountVar2 + ("" + inc);

				freeQty = freeQty2 + ("" + inc);
				freeItem = freeItem2 + ("" + inc);
				amount = amount2 + ("" + inc);
				manufacturerId = manufacturerId2 + ("" + inc);
				brandId = brandId2 + ("" + inc);

				quantityInVarTemp = quantityInVarTemp2 + ("" + inc);
				taxVarTemp = taxVarTemp2 + ("" + inc);
				unitRateVarTemp = unitRateVarTemp2 + ("" + inc);
				amountVarTemp = amountVarTemp2 + ("" + inc);
				discountVarTemp = discountVarTemp2 + ("" + inc);
				incVar = incVar2 + ("" + inc);

				dispenseType = dispenseType2 + ("" + inc);
				mdq = mdq2 + ("" + inc);
				ratePerMdq = ratePerMdq2 + ("" + inc);
				mrp = mrp2 + ("" + inc);
				otherTaxes = otherTaxes2 + ("" + inc);
				totalCarryForward = totalCarryForward2 + ("" + inc);
				quantityInHand = quantityInHand2 + ("" + inc);
	%>
	<tr>
		<td width="5%"><input type="text" size="2"
			value="<%=storePoDetail.getSerialNo()%>" name="<%=SR_NO%>"
			readonly="readonly" /> <input type="hidden" name="<%= DETAIL_ID%>"
			value="<%=storePoDetail.getId()%>" /> <input type="hidden" size="5"
			name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>"
			value="<%=storePoDetail.getItem().getPvmsNo() %>" /> <input
			type="hidden" size="2" value="<%=storePoDetail.getItem().getId() %>"
			name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>

		<td><input type="text"
			value="<%=storePoDetail.getItem().getNomenclature() %>"
			id="<%=nameItem%>" onblur="if(fillSrNo('<%=inc %>')){checkForPurchase(this.value, '<%=nameItem%>','<%=inc %>');}" name="<%=nameItem%>" tabindex="1"
			/>  
		 	<div id="ac2update" style="display:none; border:1px solid black; padding-right: 450px; background-color:white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value });
			</script>
		</td>

		<%
			String unitname = "";
					try {
						unitname = storePoDetail.getItem().getItemConversion()
								.getPurchaseUnit().getUnitName();
					} catch (Exception e) {
						unitname = "-";
					}
		%>

		<td><input type="text" size="5" value="<%=unitname%>"
			class="readOnlyForTextBoxes" readonly="readonly" name="<%=AV%>"
			id="<%=idAu%>" tabindex="1" /></td>
		<%-- 
      <td>
      <select name="<%=BRAND_ID%>" id=<%=brandId%> tabindex="1">
      <option value="">--select brand--</option>
      </select>
       --%>


		<td><select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId%>
			tabindex="1">
			<option value="">--select manuf--</option>
			<%
				for (MasManufacturer masManufacturer : masManufacturerList) {
					
			%>
			<option value=<%=masManufacturer.getId()%>
				<%=HMSUtil.isSelected(masManufacturer.getId(), storePoDetail.getManufacturer().getId())%>>
			<%=masManufacturer.getManufacturerName()%></option>
			<%
				}
			%>
		</select>
		<td><input size="7" type="text" value="0" name=""
			class="readOnlyForTextBoxes" readonly="readonly"
			id="<%=quantityInHand %>" /></td>

		<td><input type="text" size="5"
			value="<%=storePoDetail.getQuantityOrdered() %>" name=""
			id="<%=quantityInVarTemp %>" tabindex="1"
			onBlur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			validate="Quantity,float,no" maxlength="9" /> <input type="hidden"
			value="<%=storePoDetail.getQuantityOrdered() %>"
			name="<%=QUANTITY %>" id="<%=quantityInVar%>" /></td>

		<td><input type="text" size="5"
			value="<%=storePoDetail.getFreeQuantity()==null?"0":storePoDetail.getFreeQuantity()%>"
			name="<%=FREE_QTY %>" id="<%=freeQty %>" tabindex="1"
			validate="Free Qty,num,no" maxlength="9" /></td>


		<td width="10%"><select name="dipenseType" id=<%=dispenseType%>
			tabindex="1">
			<option value="<%=storePoDetail.getDispType()%>"><%=storePoDetail.getDispType()%></option>
		</select></td>
		<td><input type="hidden" size="2" value="1" name="mdq"
			id="<%=mdq%>" onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			tabindex="1" validate="Minimum Dispensable Qty (MDQ),num,no"
			maxlength="9" /> <input type="hidden" size="5"
			value="<%=storePoDetail.getRatePerMdq() %>" name="ratePerMdq"
			id="<%=ratePerMdq%>"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);" tabindex="1"
			validate="Rate per MDQ,float,no" maxlength="18" /> <input
			type="text" size="5" value="<%=storePoDetail.getUnitRate() %>"
			name="" id="<%=unitRateVarTemp%>"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			validate="Unit Rate,float,no" /> <input type="hidden"
			value="<%=storePoDetail.getUnitRate() %>" name="<%=UNIT_RATE%>"
			tabindex="1" id="<%=unitRateVar%>" /></td>

		<td><input type="text" size="5"
			value="<%=storePoDetail.getDiscountPercent()==null?"0":storePoDetail.getDiscountPercent()%>"
			name="" id="<%=discountVarTemp%>"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);" tabindex="1"
			validate="Discount,float,no" maxlength="6" /> <input type="hidden"
			value="<%=storePoDetail.getDiscountPercent()==null?"0":storePoDetail.getDiscountPercent()%>"
			name="<%=DISCOUNT_PERCENTAGE%>" tabindex="2" id="<%=discountVar%>" />
		</td>

		<td><input type="text" size="5" name="mrp" id="<%=mrp%>"
			value="<%=storePoDetail.getMrp()==null?"0":storePoDetail.getMrp()%>"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			validate="MRP,float,no" maxlength="16" tabindex="1" /></td>

		<td><input type="text" size="5"
			value="<%=storePoDetail.getTaxPercent()==null?"0":storePoDetail.getTaxPercent()%>"
			name="" id="<%=taxVarTemp%>"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			validate="Tax,float,no" tabindex="1" maxlength="6" /> <input
			type="hidden" value="<%=storePoDetail.getTaxPercent() %>"
			name="<%=TAX_PERCENT %>" tabindex="2" id="<%=taxVar%>" /></td>


		<td><input type="text" size="5" name="otherTaxes"
			id="<%=otherTaxes%>"
			value="<%=storePoDetail.getOtherTaxes()==null?"0":storePoDetail.getOtherTaxes()%>"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			validate="Other Taxes,float,no" maxlength="6" tabindex="1" /></td>

		<td><input type="text" size="5"
			value="<%=storePoDetail.getAmount() %>" name=""
			id="<%=amountVarTemp%>" class="readOnlyForTextBoxes"
			validate="Amount,float,no" tabindex="1" /> <input type="hidden"
			value="<%=storePoDetail.getAmount() %>" name="<%=AMOUNT%>"
			tabindex="2" id="<%=amountVar%>" class="readOnlyForTextBoxes" /> <%netCalculatedAmount=netCalculatedAmount.subtract(storePoDetail.getAmount()); %>
		<td><select name="<%=FREE_ITEM %>" class="small"
			id="<%=freeItem %>" tabindex="1"
			onChange="gridCalculationLocalSupplyOrderEdit(<%=inc%>);">
			<option value="n"
				<%=HMSUtil.isSelected(storePoDetail.getFreeItem(),"n")%>>No</option>
			<option value="y"
				<%=HMSUtil.isSelected(storePoDetail.getFreeItem(),"y")%>>Yes</option>
		</select></td>
		<!--       
      <td>
      <input type="button"  onclick="get_value_for_purchase(<%=temp+inc%>,<%=storePoDetail.getId() %>);" name="Submit2" value="" class="morebutton" />      
      </td>
-->
	</tr>
	<%
		inc++;
			}
		}
	%>
	<script>
	    	   
	    	 document.purchaseGrid.noOfRows.value=<%=inc-((pageNo-1)*10)-1%>
	    	 </script>

	<%
		detailCounter = 10;
		temp = 0;
		idItem = "idItem";
		codeItem = "codeItem";
		nameItem = "nameItem";
		idAu = "idAu";
		quantityInVar = "quantityInVar";
		taxVar = "taxVar";
		unitRateVar = "unitRateVar";
		amountVar = "amountVar";
		discountVar = "discountVar";

		quantityInVarTemp = "quantityInVarTemp";
		taxVarTemp = "taxVarTemp";
		unitRateVarTemp = "unitRateVarTemp";
		amountVarTemp = "amountVarTemp";
		discountVarTemp = "discountVarTemp";
		incVar = "incVar";

		freeQty = "freeQty";
		amount = "amount";
		manufacturerId = "manufacturerId";
		brandId = "brandId";
		freeItem = "freeItem";

		dispenseType = "dispenseType";
		mdq = "mdq";
		ratePerMdq = "ratePerMdq";
		mrp = "mrp";
		otherTaxes = "otherTaxes";
		totalCarryForward = "totalCarryForward";
		quantityInHand = "quantityInHand";

		idItem2 = "idItem";
		codeItem2 = "codeItem";
		nameItem2 = "nameItem";
		idAu2 = "idAu";
		quantityInVar2 = "quantityInVar";
		taxVar2 = "taxVar";
		unitRateVar2 = "unitRateVar";
		amountVar2 = "amountVar";
		discountVar2 = "discountVar";

		freeQty2 = "freeQty";
		amount2 = "amount";
		manufacturerId2 = "manufacturerId";
		brandId2 = "brandId";
		freeItem2 = "freeItem";

		quantityInVarTemp2 = "quantityInVarTemp";
		taxVarTemp2 = "taxVarTemp";
		unitRateVarTemp2 = "unitRateVarTemp";
		amountVarTemp2 = "amountVarTemp";
		discountVarTemp2 = "discountVarTemp";
		incVar2 = "incVar2";

		dispenseType2 = "dispenseType";
		mdq2 = "mdq";
		ratePerMdq2 = "ratePerMdq";
		mrp2 = "mrp";
		otherTaxes2 = "otherTaxes";
		totalCarryForward2 = "totalCarryForward";
		quantityInHand2 = "quantityInHand";

		if (inc < incTemp2) {
			for (; inc < incTemp2; inc++) {
				idItem = idItem2 + ("" + inc);
				codeItem = codeItem2 + ("" + inc);
				nameItem = nameItem2 + ("" + inc);
				idAu = idAu2 + ("" + inc);

				quantityInVar = quantityInVar2 + ("" + inc);
				taxVar = taxVar2 + ("" + inc);
				unitRateVar = unitRateVar2 + ("" + inc);
				amountVar = amountVar2 + ("" + inc);
				discountVar = discountVar2 + ("" + inc);

				freeQty = freeQty2 + ("" + inc);
				freeItem = freeItem2 + ("" + inc);
				amount = amount2 + ("" + inc);
				manufacturerId = manufacturerId2 + ("" + inc);
				brandId = brandId2 + ("" + inc);

				quantityInVarTemp = quantityInVarTemp2 + ("" + inc);
				taxVarTemp = taxVarTemp2 + ("" + inc);
				unitRateVarTemp = unitRateVarTemp2 + ("" + inc);
				amountVarTemp = amountVarTemp2 + ("" + inc);
				discountVarTemp = discountVarTemp2 + ("" + inc);
				incVar = incVar2 + ("" + inc);

				dispenseType = dispenseType2 + ("" + inc);
				mdq = mdq2 + ("" + inc);
				ratePerMdq = ratePerMdq2 + ("" + inc);
				mrp = mrp2 + ("" + inc);
				otherTaxes = otherTaxes2 + ("" + inc);
				totalCarryForward = totalCarryForward2 + ("" + inc);
				quantityInHand = quantityInHand2 + ("" + inc);
	%>
	<tr>
		<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
			name="<%=SR_NO%>" readonly="readonly" /> <input type="hidden"
			size="5" name="<%=ITEM_CODE %>" readonly="readonly"
			id="<%=codeItem%>" value="" /> <input type="hidden" size="2"
			value="0" name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>

		<td><input type="text" value="" tabindex="1" id="<%=nameItem%>"
			onblur="if(fillSrNo('<%=inc %>')){checkForPurchase(this.value, '<%=nameItem%>','<%=inc %>');}"
			name="<%=nameItem%>" />
		<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value });
			</script></td>

		<td><input type="text" size="5" value="" readonly="readonly"
			name="<%=AV%>" id="<%=idAu%>" class="readOnlyForTextBoxes" /></td>

		<!-- 
      <td>
      <select name="<%=BRAND_ID%>" id=<%=brandId%> tabindex="1" validate="Brand,int,no">
      <option value="">--select brand--</option>
      </select>
      -->

		<td><select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId%>
			tabindex="1" validate="Manufacturer,int,no">
			<option value="">--select manuf--</option>


			<%
				for (MasManufacturer masManufacturer : masManufacturerList) {
			%>
			<option value=<%=masManufacturer.getId()%>><%=masManufacturer.getManufacturerCode()%>
			</option>
			<%
				}
			%>
		</select></td>


		<td width="10%"><input type="text" value="0" name="" size="7"
			id="<%=quantityInHand %>" readonly="readonly"
			class="readOnlyForTextBoxes" /></td>

		<td><input type="text" size="5" value="0" name=""
			id="<%=quantityInVarTemp %>" tabindex="1"
			validate="Quantity,float,no"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);" maxlength="9" />
		<input type="hidden" value="0" name="<%=QUANTITY %>" tabindex="12"
			id="<%=quantityInVar%>" /></td>

		<td><input type="text" size="5" value="0" name="<%=FREE_QTY %>"
			id="<%=freeQty %>" tabindex="1" validate="Free Qty,num,no"
			maxlength="9" /></td>


		<td width="10%"><select name="dipenseType" id=<%=dispenseType%>
			tabindex="1" validate="Dispense Type,String,no">
			<option value="">Select Type</option>
		</select>
		<td><input type="hidden" size="2" name="mdq" value="1"
			id="<%=mdq%>" tabindex="1"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			validate="Minimum Dispensable Qty (MDQ),num,no" maxlength="9" /> <input
			type="hidden" size="5" name="ratePerMdq" tabindex="1"
			id="<%=ratePerMdq%>" value="0"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			maxlength="18" validate="Rate per MDQ,float,no" /> <input type=text
			size="5" value="" name="" id="<%=unitRateVarTemp%>"
			validate="Unit Rate,float,no"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);" /> <input
			type="hidden" value="0" name="<%=UNIT_RATE%>" tabindex="1"
			id="<%=unitRateVar%>" /></td>

		<td><input type="text" size="5" value="0" name="" tabindex="1"
			id="<%=discountVarTemp%>"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			validate="Discount,float,no" maxlength="6" /> <input type="hidden"
			value="0" name="<%=DISCOUNT_PERCENTAGE%>" tabindex="1"
			id="<%=discountVar%>" /></td>


		<td><input type="text" size="5" value="0" name="mrp"
			id="<%=mrp%>" onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			validate="MRP,float,no" maxlength="16" tabindex="1" /></td>


		<td><input type="text" size="5" value="0" name="" tabindex="1"
			id="<%=taxVarTemp%>"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			validate="Tax,float,no" maxlength="6" /> <input type="hidden"
			value="0" name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar%>" /></td>


		<td><input type="text" size="5" value="0" name="otherTaxes"
			id="<%=otherTaxes%>"
			onblur="gridCalculationLocalSupplyOrderEdit(<%=inc%>);"
			validate="Other Taxes,float,no" maxlength="6" tabindex="1" /></td>


		<td><input type="text" size="5" value="0" name=""
			class="readOnlyForTextBoxes" tabindex="1" id="<%=amountVarTemp%>"
			readonly="readonly" validate="Amount,float,no" /> <input
			type="hidden" value="0" name="<%=AMOUNT%>" tabindex="1"
			id="<%=amountVar%>" /></td>

		<td><select name="<%=FREE_ITEM %>" class="small"
			id="<%=freeItem %>" tabindex="1"
			onChange="gridCalculationLocalSupplyOrderEdit(<%=inc%>);">
			<option value="n">No</option>
			<option value="y">Yes</option>
		</select></td>

		<!-- <td>
      <input type="button"  onclick="get_value_for_purchase(<%=temp+inc%>,0);" name="Submit2" value=" " class="morebutton" />      
      </td>
       -->
	</tr>


	<%
		}
		}
	%>


</table>
</div>
<div class="paddingTop15"></div>
<label class="auto">Total Amount</label> 
<input type="text"	name="<%=TOTAL_AMOUNT %>" value="<%=netAmount==null?"0":netAmount %>"	id="total_amount" class="readOnly" readonly="readonly"> 
<input	type="hidden" name="netCalculatedAmount" id="netCalculatedAmount"	value="<%=netCalculatedAmount %>"> 
<input type="hidden" value="<%=netAmount==null?"0":netAmount%>" id="totalCarryForward">
<input	type="hidden" value="<%=pageTotal==null?"0":pageTotal%>" id="pageTotal">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
</script> 
<input type="hidden" name="rows" id="rr" value="1" />


<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>