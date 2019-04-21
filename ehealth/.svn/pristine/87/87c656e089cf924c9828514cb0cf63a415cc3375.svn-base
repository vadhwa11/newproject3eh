<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />


<form name="itemBatchPopup" method="post" action="">


<h4>Item Details</h4>
<div class="division"></div>
<div class="clear"></div>
<%

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> itemDiscMap = new HashMap<String,Object>();
	List<StoreItemBatchStock> batchStockList = new ArrayList<StoreItemBatchStock>();
	int rowVal = 0;
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("batchStockList") != null){
		batchStockList = (List<StoreItemBatchStock>)map.get("batchStockList");
	}
	if(map.get("rowVal") != null){
		rowVal = (Integer)map.get("rowVal");
	}
	if(map.get("itemDiscMap") != null){
		itemDiscMap = (Map)map.get("itemDiscMap");
	}
	int i=0;
    int itemId = 0;

	BigDecimal salesTaxPercnt = new BigDecimal(0);

	int patientTypeId = 0;
	if(map.get("patientTypeId") != null){
		patientTypeId = (Integer)map.get("patientTypeId");
	}

	BigDecimal discAmt = new BigDecimal(0);
	BigDecimal discPercnt = new BigDecimal(0);
	BigDecimal fixedAmount = new BigDecimal(0);

	if(itemDiscMap.get("discAmt") != null){
		discAmt = (BigDecimal)itemDiscMap.get("discAmt");
	}
	if(itemDiscMap.get("discPercnt") != null){
		discPercnt = (BigDecimal)itemDiscMap.get("discPercnt");
	}
	if(itemDiscMap.get("fixedAmount") != null){
		fixedAmount = (BigDecimal)itemDiscMap.get("fixedAmount");
	}
	if(batchStockList.size() > 0){
%>
<table class="small" width="100%" border="0" cellspacing="0"
	cellpadding="0">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Batch No</th>
		<th scope="col">Expiry Date</th>
		<th scope="col">Dispensing Price</th>
		<th scope="col">Stock Quantity</th>
		<th scope="col">Item Issued</th>
	</tr>
	<%
   	    	 i=1; 
   	    	for(StoreItemBatchStock itemBatchStock : batchStockList){
   	    		itemId = itemBatchStock.getItem().getId();
   	    		if(itemBatchStock.getItem().getSalesTax() != null){
   	    			salesTaxPercnt = itemBatchStock.getItem().getSalesTax();
   	    		}
   	    		BigDecimal stockQty = new BigDecimal(0);
   	    		if(itemBatchStock.getClosingStock() != null){
   	    			stockQty = itemBatchStock.getClosingStock();

   	    		}
   	    		if(itemBatchStock.getBlockedQty() != null && itemBatchStock.getBlockedQty().intValue()>=0){
   	    			stockQty = stockQty.subtract(itemBatchStock.getBlockedQty());
   	    			}
   	    		if(stockQty.intValue() > 0){
   	    			if(itemBatchStock.getBatchNo() != null){
   	    %>
	<tr>
		<td><%=i %></td>
		<td><%=itemBatchStock.getBatchNo() %></td>
		<%
   	    		if(itemBatchStock.getExpiryDate() != null){
   	    	%>
		<td><%=HMSUtil.convertDateToStringWithoutTime(itemBatchStock.getExpiryDate()) %></td>
		<%}else{ %>
		<td>&nbsp;</td>
		<%} %>
		<td><%=itemBatchStock.getCostPrice()%></td>
		<td><%=stockQty %></td>
		<td><input type="text" name="<%=ISSUED_ITEM %><%=i %>"
			tabindex="1" id="issueQtyId<%=i %>" value="" maxlength="7"
			onblur="validateIssQty(this,'<%=stockQty %>','<%=itemBatchStock.getCostPrice()%>','<%=i %>')"
			onkeypress="return setValuesOnEnter(this,event,'<%=stockQty %>','<%=itemBatchStock.getCostPrice()%>','<%=i %>');" /></td>
		<input type="hidden" name="amount<%=i %>" id="amt<%=i%>" value=" <%=itemBatchStock.getCostPrice()%>','<%=i %>'" />
		<input type="hidden" name="batchId<%=i %>" id="batchId<%= i%>"
			value="<%=itemBatchStock.getId() %>" />
		<input type="hidden" name="batchItemId<%=i %>" id="batchItemId<%= i%>"
			value="<%=itemBatchStock.getItem().getId() %>" />
		<input type="hidden" name="itemCode<%=i %>" id="itemCode<%= i%>"
			value="<%=itemBatchStock.getItem().getPvmsNo() %>" />
		<td>
		<%
   	       	if(itemBatchStock.getItem().getAccountGroup() != null){
   	       %> <input type="hidden" name="accId<%=i %>" id="accId<%= i%>"
			value="<%=itemBatchStock.getItem().getAccountGroup().getId() %>" />
		<%} %> <%
   	        	if(itemBatchStock.getItem().getSubAccountGroup() != null){
   	        %> <input type="hidden" name="subAccId<%=i %>"
			id="subAccId<%= i%>"
			value="<%=itemBatchStock.getItem().getSubAccountGroup().getId() %>" />
		<%} %>
		</td>
	</tr>
	<%
   	    i++;
   	    		}
   	    		}
   	    	}


   	    	%>
</table>

<%}else{ %>
<div class="clear"></div>
<h4><span>No Record found!</span></h4>

<script type="text/javascript">

 		window.opener.document.getElementById('itemName<%=rowVal%>').value = "";
 		window.opener.document.getElementById('qty<%=rowVal%>').value = "";

 	</script> <%}

	if(i == 1){
   		%>

<h4><span>No Record found!</span></h4>
<%	}
 %> <input type="hidden" name="patientTypeId" id="patientTypeId"
	value="<%=patientTypeId %>" /> <input type="hidden" name="counter"
	id="counter" value="<%=i %>" />
<div class="clear"></div>
<input type="button" id="okButtotnId" name="Submit11" tabindex="1"
	value="Ok" class="button"
	onclick="if(document.getElementById('issueQtyId1') && checkQty()){checkItem();setTotalQtyInParent();calcProportionalDisc(<%=rowVal%>);setTotalBillAmountInParent();setBatchNoDetailsInParent();calcProportionalDiscForBatch();window.close();}" />
<input type="button" name="cancel" tabindex="1" value="Cancel"
	class="button" onclick="focusonItem();window.close();" /> <script
	type="text/javascript">
function checkQty(){
 var count = document.getElementById('counter').value;
 var msg = "";
 for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('issueQtyId'+i) != null){
	  	 		if(document.getElementById('issueQtyId'+i).value != ""){
	  	 				msg = "";
		  				break;
		  			}else{
		  				msg += "Please enter quantity in Item Issued .";
		  			}
		  	}
		  }
		  			if(msg != ""){
		  				alert(msg)
		  				return false;
		  			}
	  return 	true;

}

function checkItem(){
	var tbl = window.opener.document.getElementById('batchDetails');
	var lastRow = tbl.rows.length;
	var checkedObjArray = new Array();
	var cCount = 0;
	if(lastRow > 0){
		//var c = 1;
		for(var i=0;i<lastRow;i++){
			if(window.opener.document.getElementsByName('parentRowNo')[i]){
				if(window.opener.document.getElementsByName('parentRowNo')[i].value == <%=rowVal%>){
					checkedObjArray[cCount] = tbl.tBodies[0].rows[i];
					cCount++;

				//	if(window.opener.document.getElementById('batchItemId'+c).value == <%=itemId%>){
					//	tbl.deleteRow(i-1);
				//		lastRow--;
				//		i--;
				//	}
				}
			}
			//c++;
		}
		 if (checkedObjArray.length > 0) {
			var rIndex = checkedObjArray[0].sectionRowIndex;
			deleteRows(checkedObjArray);
		}

	}

	return true;
}
function focusonItem(rowObjArray)
{
	window.opener.document.getElementById('itemName<%=rowVal%>').focus()

}
function deleteRows(rowObjArray)
{
		for (var i=0; i<rowObjArray.length; i++) {
			var rIndex = rowObjArray[i].sectionRowIndex;
			rowObjArray[i].parentNode.deleteRow(rIndex);
		}

}
function validateIssQty(obj,qtyInHand,rate,inc)
	{

	var issQty = obj.value
	if(parseFloat(issQty) > parseFloat(qtyInHand)){
		alert("Issue Quantity can not be greater than Stock Quantity.");
		document.getElementById('issueQtyId'+inc).value = "";
		return false;
	}

	if(issQty !=""){
		if(validateInteger(trimAll(issQty))){
			document.getElementById('amt'+inc).value=parseFloat(rate)*parseFloat(issQty);

			return true;
		}else{
			alert("Please enter the integer value")
			return false;
		}
	}
	return true;
}

function setTotalQtyInParent(){
  		var sum = 0;
  		var totalAmt = 0;
		for(var index = 1; index < parseInt(document.getElementById('counter').value); index++ ){
			var qtyIssuedObj = eval(document.getElementById('issueQtyId'+index));
			if(qtyIssuedObj.value != "")
			{
				var amtObj = eval(document.getElementById('amt'+index));
				sum = sum + parseInt(qtyIssuedObj.value);
				totalAmt = totalAmt+parseFloat(amtObj.value);

			}else
			{
				sum=sum;
				totalAmt = totalAmt;
			}
			var salesTax = '<%=salesTaxPercnt%>';
			var salesTaxAmt = ((salesTax*totalAmt)/100).toFixed(2);

			window.opener.document.getElementById('itemCode<%=rowVal%>').value =
				document.getElementById('itemCode'+index).value;
			window.opener.document.getElementById('itemId<%=rowVal%>').value =
				document.getElementById('batchItemId'+index).value;

			if(document.getElementById('accId'+index) != null){
				window.opener.document.getElementById('accountId<%=rowVal%>').value =
					document.getElementById('accId'+index).value;
			}
			if(document.getElementById('subAccId'+index) != null){
				window.opener.document.getElementById('subAccountId<%=rowVal%>').value =
					document.getElementById('subAccId'+index).value;
			}

			window.opener.document.getElementById('salesTaxAmt<%=rowVal%>').value =salesTaxAmt;
		}
		var totalQtyIssued = eval(window.opener.document.getElementById('qty<%=rowVal%>'));
		totalQtyIssued.value = sum;
		var totalRate = eval(window.opener.document.getElementById('amount<%=rowVal%>'));
		var totalNetAmt = eval(window.opener.document.getElementById('netamount<%=rowVal%>'));
		totalRate.value = parseFloat(totalAmt).toFixed(2);
		totalNetAmt.value =  (parseFloat(totalAmt) + parseFloat(salesTaxAmt)).toFixed(2);

		var discpercent = '<%=discPercnt%>';
		var discamt = '<%=discAmt%>';
		var disPrcnt = eval(window.opener.document.getElementById('dispercent<%=rowVal%>'));
		var discountAmt = eval(window.opener.document.getElementById('disamount<%=rowVal%>'));
		disPrcnt.value = discpercent;
		if(discamt != 0)
			discountAmt.value = discamt;
		else{
			discountAmt.value = ((parseFloat(totalNetAmt.value)*parseFloat(discpercent))/100).toFixed(2);
		}

		if(document.getElementById('patientTypeId').value == '2' || document.getElementById('patientTypeId').value == '8'){
			disPrcnt.readOnly = true;
			discountAmt.readOnly = true;
		}else{
			disPrcnt.readOnly = false;
			discountAmt.readOnly = false;
		}

		totalNetAmt.value = (parseFloat(totalNetAmt.value)-parseFloat(discountAmt.value)).toFixed(2);

		if(window.opener.document.getElementById('issued<%=rowVal%>')){
			if(parseFloat(sum) != 0)
				window.opener.document.getElementById('issued<%=rowVal%>').value = 'y';
		}

		setTotalBillAmountInParent();
		if(window.opener.document.getElementById('add<%=rowVal%>'))
			window.opener.document.getElementById('add<%=rowVal%>').focus();
		return true;
  	}

function setTotalBillAmountInParent(){
	var totalBillAmt = 0;
	var amt = 0;
	var totalNetAmt = 0;
	var netAmt = 0;
	var prprtDisAmt = 0;
	var totalDis =0;
	var itemdis = 0;
	var totalItemDisc = 0
	var count = window.opener.document.getElementById('hiddenValueCharge').value;

	for(var i=1;i<=count;i++){
		if(window.opener.document.getElementById('amount'+i) != null){
			if(window.opener.document.getElementById('amount'+i).value != ""){
				amt = window.opener.document.getElementById('amount'+i).value;
				totalBillAmt = parseFloat(totalBillAmt)+parseFloat(amt);
			}
			if(window.opener.document.getElementById('netamount'+i).value != ""){
				netAmt = window.opener.document.getElementById('netamount'+i).value;
				totalNetAmt = parseFloat(totalNetAmt)+parseFloat(netAmt);
			}
			if(window.opener.document.getElementById('prprtnlDis'+i).value != ""){
				prprtDisAmt = window.opener.document.getElementById('prprtnlDis'+i).value;
				totalDis = parseFloat(totalDis)+parseFloat(prprtDisAmt);
			}
			if(window.opener.document.getElementById('disamount'+i).value != ""){
				itemdis = window.opener.document.getElementById('disamount'+i).value;
				totalItemDisc = parseFloat(totalItemDisc)+parseFloat(itemdis);
			}
		}
	}
	window.opener.document.getElementById('totalAmtId').value = parseFloat(totalBillAmt).toFixed(2);
	window.opener.document.getElementById('totalNetId').value = Math.round(parseFloat(totalNetAmt)).toFixed(2);
	window.opener.document.getElementById('totalDisId').value = Math.round(parseFloat(totalDis) + parseFloat(totalItemDisc)).toFixed(2);

	window.opener.document.getElementById('compDiscountId').value = parseFloat(totalItemDisc).toFixed(2);
	window.opener.document.getElementById('charityId').value = parseFloat(totalDis).toFixed(2);

	if(window.opener.document.getElementById('outstandingId')){
		var osamt = 0;
		if(window.opener.document.getElementById('outstandingId').value != ""){
			osamt = window.opener.document.getElementById('outstandingId').value;
		}
	 	if(window.opener.document.getElementById('payableAmtId').value !="" && parseFloat(window.opener.document.getElementById('payableAmtId').value) != 0){
			window.opener.document.getElementById('payableAmtId').value = Math.round(parseFloat(totalNetAmt)-parseFloat(osamt)).toFixed(2);
		}else{
			if(window.opener.document.getElementById('outstandingId').value != "" && parseFloat(window.opener.document.getElementById('outstandingId').value) != 0 ){
				window.opener.document.getElementById('outstandingId').value = parseFloat(window.opener.document.getElementById('totalNetId').value)- parseFloat(window.opener.document.getElementById('totalDisId').value);
			}else{
				window.opener.document.getElementById('payableAmtId').value = Math.round(parseFloat(totalNetAmt) - parseFloat(window.opener.document.getElementById('totalDisId').value)).toFixed(2);
			}
		}
	}else if (window.opener.document.getElementById('advAdjId'))
	{

		var osamt = 0;
		if(window.opener.document.getElementById('advAdjId').value != ""){
			osamt = window.opener.document.getElementById('advAdjId').value;
		}
	 	if(window.opener.document.getElementById('payableAmtId').value !="" && parseFloat(window.opener.document.getElementById('advAdjId').value) != 0){
			window.opener.document.getElementById('payableAmtId').value = Math.round(parseFloat(totalNetAmt)-parseFloat(osamt)).toFixed(2);
		}else{
			if(window.opener.document.getElementById('advAdjId').value != "" && parseFloat(window.opener.document.getElementById('advAdjId').value) != 0 ){
				window.opener.document.getElementById('advAdjId').value = parseFloat(window.opener.document.getElementById('totalNetId').value)- parseFloat(window.opener.document.getElementById('totalDisId').value);
			}else{
				window.opener.document.getElementById('payableAmtId').value = Math.round(parseFloat(totalNetAmt) - parseFloat(window.opener.document.getElementById('totalDisId').value)).toFixed(2);
			}
		}

		}
	else{
		//if(window.opener.document.getElementById('payableAmtId').value != "" && parseFloat(window.opener.document.getElementById('payableAmtId').value) != 0){
			window.opener.document.getElementById('payableAmtId').value = Math.round(parseFloat(totalNetAmt)).toFixed(2);
		//}
	}
	if(document.getElementById('patientTypeId').value == '1' || document.getElementById('patientTypeId').value == '4'){
		window.opener.document.getElementById('outstandingId').value = Math.round(parseFloat(window.opener.document.getElementById('totalNetId').value)).toFixed(2);
	}else{
		if(window.opener.document.getElementById('amt1'))
			window.opener.document.getElementById('amt1').value = Math.round(parseFloat(window.opener.document.getElementById('payableAmtId').value)).toFixed(2);
	}

	if(totalNetAmt.toString().indexOf('.') > 0)
	{
		if(parseFloat(window.opener.document.getElementById('totalNetId').value) > parseFloat(totalNetAmt))
			window.opener.document.getElementById('roundId').value = (window.opener.document.getElementById('totalNetId').value-totalNetAmt).toFixed(2);
		else
			window.opener.document.getElementById('roundId').value = (totalNetAmt-window.opener.document.getElementById('totalNetId').value).toFixed(2);
	}else{
		window.opener.document.getElementById('roundId').value = "";
	}

	return true;
}


function setBatchNoDetailsInParent(){
	var i=0;
	var discpercent = '<%=discPercnt%>';
	var tbl = window.opener.document.getElementById('batchDetails');
	var btchCnt= 0;
	if(document.getElementById('counter') != null){
	for(var index = 1; index < parseInt(document.getElementById('counter').value); index++ ){
			var qtyIssuedObj = eval(document.getElementById('issueQtyId'+index));
			btchCnt=window.opener.document.getElementById('totalBatchId').value;

			if(qtyIssuedObj.value != "")
			{
				var batchId = document.getElementById('batchId'+index).value;
				var batchItemId = document.getElementById('batchItemId'+index).value;
				var amt = document.getElementById('amt'+index).value;

				var lastRow = tbl.rows.length;
				var row = tbl.insertRow(lastRow);

				var iteration = parseInt(btchCnt);
				var cell1 = row.insertCell(0);
				var e1 = window.opener.document.createElement('input');
				e1.type = 'text';
				e1.name = '<%=BATCH_ID%>' + (iteration+1);
				e1.id = 'batchId' + (iteration+1);
				e1.value = batchId;
				var e11 = window.opener.document.createElement('input');
				e11.type = 'text';
				e11.name = 'parentRowNo';
				e11.id = 'parentRowNo' + (iteration+1);
				e11.value = <%=rowVal%>;
				cell1.appendChild(e11);
				cell1.appendChild(e1);


				var cell2 = row.insertCell(1);
				var e2 = window.opener.document.createElement('input');
				e2.type = 'text';
				e2.name = '<%=ISSUE_QUANTITY%>' + (iteration+1);
				e2.id = 'issueQtyId' + (iteration+1);
				e2.value = qtyIssuedObj.value;
				cell2.appendChild(e2);

				var cell3 = row.insertCell(2);
				var e3 = window.opener.document.createElement('input');
				e3.type = 'text';
				e3.name = '<%=BATCH_ITEM_ID%>' + (iteration+1);
				e3.id = 'batchItemId' + (iteration+1);
				e3.value = batchItemId;
				cell3.appendChild(e3);

				var cell4 = row.insertCell(3);
				var e4 = window.opener.document.createElement('input');
				e4.type = 'text';
				e4.name = 'batchAmt' + (iteration+1);
				e4.id = 'batchAmtId' + (iteration+1);
				e4.value =amt;
				cell4.appendChild(e4);

				var cell5 = row.insertCell(4);
				var e5 = window.opener.document.createElement('input');
				e5.type = 'text';
				e5.name = 'batchDisPer' + (iteration+1);
				e5.id = 'batchDisPerId' + (iteration+1);
				e5.value = discpercent;
				cell5.appendChild(e5);

				var cell6 = row.insertCell(5);
				var e6 = window.opener.document.createElement('input');
				e6.type = 'text';
				e6.name = 'batchDisAmt' + (iteration+1);
				e6.id = 'batchDisAmtId' + (iteration+1);
				var discAmtBatch = ((parseFloat(amt)* parseFloat(discpercent))/100).toFixed(2);
				e6.value = discAmtBatch;
				cell6.appendChild(e6);

				var cell7 = row.insertCell(6);
				var e7 = window.opener.document.createElement('input');
				e7.type = 'text';
				e7.name = 'batchPrptDisAmt' + (iteration+1);
				e7.id = 'batchPrptDisAmtId' + (iteration+1);
				cell7.appendChild(e7);


				var salesTaxPrcnt = '<%=salesTaxPercnt%>';
				var sTAmt =  0;
				if(parseFloat(salesTaxPrcnt) >0)
					sTAmt = ((amt*salesTaxPrcnt)/100).toFixed(2);

				var cell8 = row.insertCell(7);
				var e8 = window.opener.document.createElement('input');
				e8.type = 'text';
				e8.name = 'batchSalesTaxAmt' + (iteration+1);
				e8.value = sTAmt;
				e8.id = 'batchSalesTaxAmt' + (iteration+1);
				cell8.appendChild(e8);

				var netAmtBt = 0;
				if(discAmtBatch != ""){
					netAmtBt = parseFloat(amt)+parseFloat(sTAmt)-parseFloat(discAmtBatch);
				}else{
					netAmtBt = parseFloat(amt)+parseFloat(sTAmt);
				}

				var cell9 = row.insertCell(8);
				var e9 = window.opener.document.createElement('input');
				e9.type = 'text';
				e9.name = 'batchNetAmt' + (iteration+1);
				e9.value = netAmtBt;
				e9.id = 'batchNetAmtId' + (iteration+1);
				cell9.appendChild(e9);

				i++;
			}
			window.opener.document.getElementById('itemBatchCount<%=rowVal%>').value = i;
			window.opener.document.getElementById('totalBatchId').value = parseInt(btchCnt)+1;
		}
	}
	return true;
}

function calcProportionalDisc(count){
	if(window.opener.document.getElementById('discountOnBillId').value != "" && window.opener.document.getElementById('discountOnBillId').value != 0){
		var dispr = window.opener.document.getElementById('discountOnBillId').value;
		var disamt = 0;
		if(window.opener.document.getElementById('disamount'+count).value != ""){
			disamt = window.opener.document.getElementById('disamount'+count).value;
		}
		var netamt = parseFloat(window.opener.document.getElementById('amount'+count).value)-parseFloat(disamt);
		window.opener.document.getElementById('prprtnlDis'+count).value = ((parseFloat(netamt)*parseFloat(dispr))/parseFloat(100)).toFixed(2);
		window.opener.document.getElementById('netamount'+count).value = 	(parseFloat(netamt)-parseFloat(window.opener.document.getElementById('prprtnlDis'+count).value)).toFixed(2);
	}

}

function calcProportionalDiscForBatch(){
	var count = <%=rowVal%>;

	if(window.opener.document.getElementById('discountOnBillId').value != "" && parseFloat(window.opener.document.getElementById('discountOnBillId').value) != 0){
		var dispr = window.opener.document.getElementById('discountOnBillId').value;
		var disamt = 0;
		if(window.opener.document.getElementById('disamount'+count).value != ""){
			disamt = window.opener.document.getElementById('disamount'+count).value;
		}
		var netamt = parseFloat(window.opener.document.getElementById('batchAmtId'+count).value)-parseFloat(disamt);
		for(var i=1;i<=window.opener.document.getElementById('itemBatchCount'+count).value;i++){
			window.opener.document.getElementById('batchPrptDisAmtId'+i).value = ((parseFloat(netamt)*parseFloat(dispr))/parseFloat(100)).toFixed(2);
			window.opener.document.getElementById('batchNetAmtId'+i).value = 	(parseFloat(netamt)-parseFloat(window.opener.document.getElementById('batchPrptDisAmtId'+i).value)).toFixed(2);

		}

	}

}

if(document.getElementById('issueQtyId1'))
	document.getElementById('issueQtyId1').focus();
else
	document.getElementById('okButtotnId').focus();

window.opener.document.getElementById('disamount<%=rowVal%>').value = "";
window.opener.document.getElementById('dispercent<%=rowVal%>').value = "";



function setValuesOnEnter(myfield,e,qty,price,inc)
{

	obj1 = true;
	var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e)
		keycode = e.which;
	else return true;
	if (keycode == 13)
	   {
	   if(checkQty()){
	   	validateIssQty(myfield,qty,price,inc);
	      if(document.getElementById('issueQtyId1')){
	      checkItem();setTotalQtyInParent();calcProportionalDisc(<%=rowVal%>);setTotalBillAmountInParent();setBatchNoDetailsInParent();calcProportionalDiscForBatch();
	      };
	      window.close();
	      }
		}
}


</script>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>