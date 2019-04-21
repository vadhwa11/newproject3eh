<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * local_purchase.jsp
 * Purpose of the JSP -  This is for Local Purchase.
 * @author  Deepti Tevatia
 * Create Date: 21st Feb,2008

 * Revision Date:
 * Revision By:
 * @version 1.15
--%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStorePoDeliveryTerms"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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
  function submitprint(formName){
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=poPrintJsp";
  obj.submit();

  }
  function fillItems(idVal,rowVal){

  		var idItem="idItem";
    	var codeItem="codeItem";
    	var nameItem="nameItem";
    	var idAu="idAu";
    	idItem=idItem+rowVal;
    	codeItem=codeItem+rowVal;
    	nameItem=nameItem+rowVal;
    	idAu=idAu+rowVal;
    	document.getElementById('noOfRows').value=rowVal
		for(i=0;i<itemsArray1.length;i++){
		if(itemsArray1[i][0]==idVal){
		document.getElementById(idItem).value=itemsArray1[i][0]
		document.getElementById(nameItem).value=itemsArray1[i][2]
		document.getElementById(idAu).value=itemsArray1[i][3]
		}
		}
  }
  function checkForNext10(){
  if(document.getElementById('noOfRows').value<10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
  return true;
  }
  }
  function checkForSubmit()
  {
	  if(document.getElementById('noOfRows').value==0)
	  {
	  alert("There must be one detail row");
	  return false;
	  }
	  return true;
  }
function get_value_for_purchase(rowNo)
{
 var url="/hms/hms/purchaseOrder?method=showMoreInfoPurchaseJsp&rowNo="+rowNo;
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
function autocompleteBasedOnPvms(val,inc)
{
		ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
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

function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalPoFormatJsp";
  obj.submit();
}

</script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	String previousPage = "no";
	int pageNo = 1;
	int poId = 0;
	String max = "";
	BigDecimal netAmount = null;

	//List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();
	List<MasStorePoDeliveryTerms> poDeliveryDescList = new ArrayList<MasStorePoDeliveryTerms>();
	List<MasManufacturer> masManufacturerList = new ArrayList<MasManufacturer>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}

	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");

	boolean accessFlag=false;
	if(map.get("accessFlag")!=null){
		accessFlag = (Boolean)map.get("accessFlag");
	}
	if(map.get("poId")!=null){
		poId = Integer.parseInt(""+map.get("poId"));
	}
	if(map.get("previousPage")!=null){
		previousPage=(""+map.get("previousPage"));
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if (map.get("poNumberList") != null) {
		poNumberList = (List<StorePoHeader>)map.get("poNumberList");
	}
	if(map.get("supplierList")!=null)
		supplierList = (List<MasStoreSupplier>) map.get("supplierList");

	if (map.get("manufacturerList")!=null)
		masManufacturerList = (List<MasManufacturer>)map.get("manufacturerList");

	//if(map.get("itemList")!=null)
		//itemList = (List<MasStoreItem>) map.get("itemList");
	String signingAuthority="";
	if(map.get("max") != null){
		max = (String) map.get("max");
	}
	if(map.get("signingAuthority")!=null){

		signingAuthority=(String)map.get("signingAuthority");
	}
	if(accessFlag){


%>
<form name="poMain" method="post">
<h2>Purchase Order Entry</h2>
<div class="clear"></div>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<!--<form action="" method="post">
<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>-->
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" />
<input type="hidden" name="searchthread" value="1" />
<input type="hidden" name="showposts" value="1" />
<input type="hidden" name="searchthreadid" value="85875" />
<div class="paddingTop15"></div>
<div class="clear"></div>
<label>From Date </label>
<input type="text" name="<%= FROM_DATE %>"	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.poMain.<%= FROM_DATE%>,event);" />
<label>To Date </label>
<input type="text" name="<%= TO_DATE %>"	value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 />
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.poMain.<%= TO_DATE%>,event);" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<label>P.O.No </label>

<select name="<%=PO_ID%>">
	<option value="0">Select</option>
	<%
				for(StorePoHeader obj: poNumberList){
			%>
	<option value="<%=obj.getId() %>"><%=obj.getPoNumber() %></option>
	<%} %>
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
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="image"  class="button"	onClick="submitForm('poMain','purchaseOrder?method=searchPO');" />
<!-- onkeypress="return submitenter(this,event,'purchaseOrder?method=searchPO')" -->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

</div>
<div class="clear"></div>
<!--  <td width="20%" nowrap="nowrap" class="vbmenu_control" id="threadsearch">
 <a href="">Search</a>
  <script type="text/javascript"> vbmenu_register("threadsearch"); </script>		</td>-->
<!--  <input type="button" name="Add" type="submit"  value="Add"/>--> <!-- <input type="button" name="Reset" type="submit" value="Reset" >-->
<!-- <input type="button" name="Delete" type="submit"  value="Delete" />-->

<!--  <input type="button" name="Modify" type="submit" value="Modify" class="button"  onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');" />  -->
<div class="clear"></div>
<form name="purchaseGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="testDiv">
<input type="hidden" name="pageNo"	value="<%=pageNo%>" id="pageNo" />
<%
	List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();
	StorePoHeader poHeaderObj = null;

	if(map.get("poHeaderList") != null){
		poHeaderList = (List)map.get("poHeaderList");
	}
	if(poHeaderList.size() > 0){
		poHeaderObj = (StorePoHeader)poHeaderList.get(0);
		netAmount = poHeaderObj.getNetAmount();
	}

	%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="print" type="button" class="button"	value="Print" onClick="submitprint('purchaseGrid');"> <!--
<input type="button" class="buttonBig" value="Budget Status" onclick="window.open('/hms/hms/purchaseOrder?method=showBudgetStatus','new','left=200,top=100,width=425,height=400')" />
<input type="button" class="buttonBig" value="Approval Authority" onclick="window.open('/hms/hms/purchaseOrder?method=showApprovalAuthority&poId='+purchaseGrid.<%=PO_ID %>.value,'new','left=200,top=100,width=525,height=450')" /> -->
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">
<label>P.O. Number</label> <% if(poHeaderObj != null)
		{
		%>
<input type="text" name="<%= PO_NO %>"	value="<%=poHeaderObj.getPoNumber()%>" readonly="readonly"	validate="S.O. Number ,String,yes" tabindex=1 class="readOnly" />
<%
}else{
		%>
<input type="text" name="<%= PO_NO %>" value="<%=max %>" readonly="readonly" validate="S.O. Number ,String,yes" tabindex=1	class="readOnly" />
<%
		}
		%>
<label>P.O.Date</label>
<input type="text" name="<%=PO_DATE%>"	value="<%=currentDate %>" class="date" readonly="readonly"	validate="S.O. Date,dateOfAdmission,yes" MAXLENGTH="30" />
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('<%=currentDate%>',document.purchaseGrid.<%=PO_DATE%>,event)" />
<label><span>*</span> Vendor Name</label>
<select	name="<%= SUPPLIER_ID %>" validate="Vendor Name,String,yes" tabindex=1>
	<option value="">Select</option>
	<%
	for (MasStoreSupplier masStoreSupplier :supplierList ) {
		if(poHeaderObj != null){
		 	if(poHeaderObj.getSupplier().getId().equals(masStoreSupplier.getId())){
%>

	<option value=<%=masStoreSupplier.getId()%> selected="selected"
		readonly><%=masStoreSupplier.getSupplierName()%></option>
	<%      	}}else{ %>

	%>
	<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
	<%
	}}
%>
</select> <script>
				document.purchaseGrid.<%=SUPPLIER_ID%>.focus();
			</script>
<div class="clear"></div>

<label>Delivery Date</label>
 <input type="text"	name="<%=DELIVERY_DATE%>" value="<%=currentDate %>" class="date" readonly="readonly" validate="Delivery Date,deliveryDate,yes" MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=currentDate%>',document.purchaseGrid.<%=DELIVERY_DATE%>,event)" />
<label>Quotation No. </label>
<%
if(poHeaderObj != null){
%>
<input	type="text" maxlength="100" name="<%= QUOTATION_NO %>"	value="<%=poHeaderObj.getQuotationNumber()%>" readonly="readonly"	validate="Quotation No,string,yes" tabindex=1 class="readOnly" />
<%}else{ %>
<input type="text" maxlength="100" name="<%= QUOTATION_NO %>" value=""	validate="Quotation No,string,no" tabindex=1 /> <%} %>
<label>Quotation Date </label>
<input type="text" name="<%=QUOTATION_DATE%>" value="<%=currentDate %>" readonly="readonly" class="date" validate="Quotation Date,dateOfAdmission,yes" MAXLENGTH="30" />
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onclick="javascript:setdate('<%=currentDate%>',document.purchaseGrid.<%=QUOTATION_DATE%>,event)" />
<div class="clear"></div>
<label>Payment Terms <br />
<a href="#"	onclick="window.open('/hms/hms/purchaseOrder?method=showPaymentTerms','new','left=200,top=100,width=625,height=550')">Select</a></label>
<%if(poHeaderObj != null){ %>
 <textarea	value="<%=poHeaderObj.getPayTerms()%>" name="<%=PAY_TERMS %>" readOnly	id="<%=PAY_TERMS %>" validate="Payment Terms ,String,no" tabindex=1	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="80" /></textarea> <%}else{ %> <textarea value="" name="<%=PAY_TERMS %>"
	id="<%=PAY_TERMS %>" validate="Payment Terms ,String,no" tabindex=1	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="80" /></textarea>
	<%} %>
<label>Delivery Terms <br />
<a href="#"	onclick="window.open('/hms/hms/purchaseOrder?method=showDeliveryTerms','new','left=200,top=100,width=625,height=550')">Select</a>
</label>
<%if(poHeaderObj != null){ %>
<textarea value="<%= poHeaderObj.getDeliveryTerms()%>" id="<%=DELIVERY_TERMS %>" readOnly name="<%=DELIVERY_TERMS %>" validate="Delivery Terms ,String,no" tabindex=1 onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="80" />
</textarea>
<%}else{ %>
<textarea value=""	name="<%=DELIVERY_TERMS %>" id="<%=DELIVERY_TERMS %>"	validate="Delivery Terms ,String,no" tabindex=1	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="80" /></textarea> <%} %> <label>Remarks</label> <%if(poHeaderObj != null){ %>
<textarea value="<%=poHeaderObj.getRemarks()%>" readOnly name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1 onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)" maxlength="200" /></textarea>
 <%}else{ %>
 <textarea value="" name="<%=REMARKS %>"	validate="Remarks ,String,no" tabindex=1	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="200" /></textarea>
 <%} %>
<div class="clear"></div>
<label>Signing Authority</label>
<%if(poHeaderObj != null){ %>
<textarea	value="<%=poHeaderObj.getSigningAuthority().equals("0")?"":poHeaderObj.getSigningAuthority()%>"
readOnly name="<%=LPO_SIGNING_AUTHORITY %>"	validate="Remarks ,String,no" tabindex=1
onpaste="return checkOnPaste(this)"
oninput="return checkMaxLengthMoz(this)"
onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
maxlength="200" />
</textarea>
<%}else{ %>
<textarea value=""	name="<%=LPO_SIGNING_AUTHORITY %>"	validate="Signing Authority ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="200" /><%=signingAuthority.equals("0")?"":signingAuthority %></textarea>
<%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Next"	onclick="if(checkForNext10() && checkForLocalPurchaseGrid()){submitForm('purchaseGrid','purchaseOrder?method=submitPurchaseOrder&buttonFlag=next');}" align="right" />
<input type="button" name="sss" align="right" class="button" value="Submit"	onclick="if(checkForSubmit() && checkForLocalPurchaseGrid()){submitForm('purchaseGrid','purchaseOrder?method=submitPurchaseOrder');}" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input	type="hidden" size="2" value="0" name="noOfRows" id="noOfRows" />
<input	type="hidden" name="<%=PO_ID %>" value="<%=poId %>" id="poId" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Purchase Order details</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="cmntable">
<table align="center" colspan="7" border="0" cellpadding="0"
	cellspacing="0">
	<tr>

		<th>S.No.</th>
 		<th>Item Name</th>
		<th>UOM</th>
 		<!--  <th>Brand</th> -->
		<th>Manufacturer</th>
		<th>QOH</th>
		<th>Ordered Qnt</th>
 		<th>Free Qty</th>
 		<th>Dispen.Type</th>
		<!--   <th>MDQ</th>
		<th>Cost Price</th> -->
		<th>Unit Rate</th>
		<th>Discount(%)</th>
		<th>MRP</th>
		<th>Tax(%)</th>
		<th>Other Taxes(in Rs.)</th>
		<th>Amount</th>
		<th>Free Item</th>
 	</tr>
 	<%
  		int detailCounter=10;
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String quantityInVar="quantityInVar";
    	String taxVar="taxVar";
    	String unitRateVar="unitRateVar";
    	String amountVar = "amountVar";
    	String discountVar="discountVar";

    	String quantityInVarTemp="quantityInVarTemp";
    	String taxVarTemp="taxVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String amountVarTemp = "amountVarTemp";
    	String discountVarTemp="discountVarTemp";
    	String incVar="incVar";

    	String freeQty="freeQty";
    	String amount="amount";
    	String manufacturerId="manufacturerId";
    	String brandId="brandId";
    	String freeItem="freeItem";

    	String dispenseType = "dispenseType";
    	String mdq = "mdq";
    	String ratePerMdq = "ratePerMdq";
    	String mrp = "mrp";
    	String otherTaxes = "otherTaxes";
    	String quantityInHand = "quantityInHand";

    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
	   	String quantityInVar2="quantityInVar";
    	String taxVar2="taxVar";
    	String unitRateVar2="unitRateVar";
    	String amountVar2 = "amountVar";
    	String discountVar2="discountVar";

    	String freeQty2="freeQty";
    	String amount2="amount";
    	String manufacturerId2="manufacturerId";
    	String brandId2="brandId";
    	String freeItem2="freeItem";


    	String quantityInVarTemp2="quantityInVarTemp";
    	String taxVarTemp2="taxVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String amountVarTemp2 = "amountVarTemp";
    	String discountVarTemp2="discountVarTemp";
    	String incVar2="incVar2";

    	String dispenseType2 = "dispenseType";
    	String mdq2 = "mdq";
    	String ratePerMdq2 = "ratePerMdq";
    	String mrp2 = "mrp";
    	String otherTaxes2 = "otherTaxes";
    	String quantityInHand2 = "quantityInHand";


    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
    	int counter=temp;
     	 for(int inc=temp+1;inc<=temp+10;inc++){
     		counter++;
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);

     		quantityInVar=quantityInVar2+(""+inc);
     		taxVar=taxVar2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     		amountVar = amountVar2+(""+inc);
     		discountVar=discountVar2+(""+inc);

     		freeQty=freeQty2+(""+inc);
     		freeItem=freeItem2+(""+inc);
     		amount=amount2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		brandId=brandId2+(""+inc);

     		quantityInVarTemp=quantityInVarTemp2+(""+inc);
     		taxVarTemp=taxVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		amountVarTemp = amountVarTemp2+(""+inc);
     		discountVarTemp=discountVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);

    		dispenseType = dispenseType2 +(""+inc);
        	mdq = mdq2 +(""+inc);
        	ratePerMdq = ratePerMdq2 +(""+inc);
        	mrp = mrp2 +(""+inc);
        	otherTaxes = otherTaxes2 +(""+inc);
        	quantityInHand = quantityInHand2 +(""+inc);


    %>
	<tr>
  <td><input type="text" size="2" value="<%=inc%>"
   name="<%=SR_NO%>" tabindex="1" /> <input type="hidden"
   size="2" value="0" name="<%=ITEM_ID%>" id="<%=idItem%>" /> <input
   type="hidden" name="<%=ITEM_CODE %>"
   id="<%=codeItem%>"
   onblur="autocompleteBasedOnPvms(this.value,'<%=inc %>');"
   validate="Item Code,String,no" size="10" /></td>


		<td><input type="text" value="" size="50" id="<%=nameItem%>"
			class="bigcaption"
			onblur="if(fillSrNo('<%=inc %>')){checkForPurchase(this.value, '<%=nameItem%>','<%=inc %>');}"
			name="<%=nameItem%>" tabindex="1" />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','purchaseOrder?method=getItemListForPurchaseOrder',{minChars:3,parameters:'requiredField=<%=nameItem%>' });
			</script></td>

		<td><input type="text" value="" ForTextBoxes" name="<%=AV%>"
			id="<%=idAu%>" validate="A/U ,String,no" size="5" /></td>

		<!--
      <td width="10%">
      <select name="<%=BRAND_ID%>" id=<%=brandId%> tabindex="1" validate="Brand,int,no">
      <option value="">--select brand--</option>
      </select>
      -->

		<td width="10%"><select name="<%=MANUFACTURER_ID %>"
			id=<%=manufacturerId%> tabindex="1" validate="Manufacturer,int,no">
			<option value="">--select manuf--</option>
			<%
			for (MasManufacturer masManufacturer : masManufacturerList ) {
				String manufacturName="";
				manufacturName=masManufacturer.getManufacturerName()+"["+ masManufacturer.getManufacturerCode()+"]";
	  %>
			<option value=<%=masManufacturer.getId()%>><%=manufacturName%></option>
			<%
			}
	   %>

		</select>
		<td width="10%"><input type="text" value="0" name=""
			id="<%=quantityInHand %>" readonly="readonly" size="7" ForTextBoxes"/>
		</td>

		<td width="10%"><input type="text" value="0" name=""
			id="<%=quantityInVarTemp %>" size="7" validate="Quantity,float,no"
			onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);" tabindex="1"
			maxlength="9" /> <input type="hidden" value="0"
			name="<%=QUANTITY %>" id="<%=quantityInVar%>" /></td>

		<td width="10%"><input type="text" value="0"
			name="<%=FREE_QTY %>" size="7" id="<%=freeQty %>" tabindex="1"
			validate="Free Qty,num,no" maxlength="9" /></td>

		<td width="10%"><select name="dipenseType" id=<%=dispenseType%>
			tabindex="1" validate="Dispense Type,String,no">
		</select> <input type="hidden" name="mdq" id="<%=mdq%>" ForTextBoxes" size="7"
			onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);"
			validate="Minimum Dispensable Qty (MDQ),num,no" value="1"
			tabindex="1" maxlength="9" /></td>




		<td width="3%"><input type="hidden" name="" value="0" size="7"
			id="<%=unitRateVarTemp%>" validate="Unit Rate,float,no" /> <input
			type="hidden" value="0" name="<%=UNIT_RATE%>" id="<%=unitRateVar%>" />
		<input type="text" name="ratePerMdq" value="0" size="7"
			id="<%=ratePerMdq%>"
			onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);"
			validate="Rate per MDQ,float,no"
			onblur="calculateUnitRateinLocalSupplyOrder(<%=inc%>);" tabindex="1"
			maxlength="18" /></td>

		<td width="3%"><input type="text" value="0" name="" size="7"
			id="<%=discountVarTemp%>"
			onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);"
			validate="Discount,float,no" maxlength="6" tabindex="1" /> <input
			type="hidden" value="0" name="<%=DISCOUNT_PERCENTAGE%>"
			id="<%=discountVar%>" /></td>


		<td width="10%"><input type="text" value="0" name="mrp" size="7"
			id="<%=mrp%>" onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);"
			validate="Tax,float,no" maxlength="6" tabindex="1" /></td>


		<td width="10%"><input type="text" value="0" name="" size="7"
			id="<%=taxVarTemp%>"
			onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);"
			validate="Tax,float,no" maxlength="6" tabindex="1" /> <input
			type="hidden" value="0" name="<%=TAX_PERCENT %>" id="<%=taxVar%>" />
		</td>


		<td width="10%"><input type="text" value="0" size="7"
			name="otherTaxes" id="<%=otherTaxes%>"
			onblur="gridCalculationLocalSupplyOrderAdd(<%=inc%>);"
			validate="Tax,float,no" maxlength="6" tabindex="1" /></td>


		<td width="3%"><input type="text" value="0" name="" size="7"
			id="<%=amountVarTemp%>" ForTextBoxes" validate="Amount,float,no"
			tabindex="1" /> <input type="hidden" value="0" name="<%=AMOUNT%>"
			id="<%=amountVar%>" /></td>

		<td width="10%"><select name="<%=FREE_ITEM %>"
			id="<%=freeItem %>" tabindex="1"
			onChange="gridCalculationLocalSupplyOrderAdd(<%=inc%>);">
			<option value="n">No</option>
			<option value="y">Yes</option>
		</select></td>
	</tr>
	<%
     	 }   %>

</table>
</div>
<div class="clear"></div>
<label class="auto">Total Amount</label> <%if(netAmount != null){ %> <input
	type="text" name="<%=TOTAL_AMOUNT %>" value="<%=netAmount %>"
	id="total_amount" validate="Total Amount,float,no" class="readOnly"><input
	type="hidden" value="<%=netAmount %>" id="totalCarryForward"> <%}else{ %>
<input type="text" name="<%=TOTAL_AMOUNT %>" value="0" id="total_amount"
	validate="Total Amount,float,no" class="readOnly"><input
	type="hidden" value="0" id="totalCarryForward"> <%} %>
</div>

</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />
<div class="clear"></div>
<div class="paddingTop40"></div>
<%
	}else{
%>
<h2>Purchase Order Entry</h2>
<div class="clear"></div>
<h3>Access Denied</h3>
<%
	}
%>