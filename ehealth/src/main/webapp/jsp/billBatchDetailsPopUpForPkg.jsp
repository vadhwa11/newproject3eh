<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />


<form name="itemBatchPopup" method="post" action="">
<h4>Item Details</h4>
<div class="division"></div>
<div class="clear"></div>
<%
	
	Map<String,Object> map = new HashMap<String,Object>();
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
	BigDecimal dispPrice = new BigDecimal(0);
	if(map.get("dispPrice") != null){
		dispPrice = (BigDecimal)map.get("dispPrice");
	}
	
	if(batchStockList.size() > 0){
%>
<table class="small" width="100%" border="0" cellspacing="0"
	cellpadding="0">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Batch No</th>
		<th scope="col">Expiry Date</th>
		<th scope="col">Rate</th>
		<th scope="col">Stock Quantity</th>
		<th scope="col">Item Issed</th>
	</tr>
	<%
   	    	int i=1;
   	    	for(StoreItemBatchStock itemBatchStock : batchStockList){
   	    	BigDecimal stockQty = new BigDecimal(0);
   	    		if(itemBatchStock.getOpeningBalanceQty() != null){
   	    			stockQty = itemBatchStock.getOpeningBalanceQty();
   	    		}
   	    		if(itemBatchStock.getReceivedQty() != null){
   	    			stockQty = stockQty.add(itemBatchStock.getReceivedQty());
   	    		}
   	    		if(itemBatchStock.getIssueQty() != null){
   	    			stockQty = stockQty.subtract(itemBatchStock.getIssueQty());
   	    		}
   	    		if(itemBatchStock.getBlockedQty() != null){
   	    			stockQty = stockQty.subtract(itemBatchStock.getBlockedQty());
   	    		}
   	    		if(stockQty.intValue() > 0){
   	    %>
	<tr>
		<td><%=i %></td>
		<td><%=itemBatchStock.getBatchNo() %></td>
		<td><%=itemBatchStock.getExpiryDate() %></td>
		<td><%=itemBatchStock.getMrp()%></td>
		<td><%=stockQty %></td>
		<td><input type="text" name="<%=ISSUED_ITEM %><%=i %>"
			tabindex="1" id="issueQtyId<%=i %>" value="" maxlength="7"
			onblur="validateIssQty(this,'<%=stockQty %>','<%=itemBatchStock.getMrp()%>','<%=i %>')" /></td>
		<input type="hidden" name="amount<%=i %>" id="amt<%=i%>" value=" " />
		<input type="hidden" name="batchId<%=i %>" id="batchId<%= i%>"
			value="<%=itemBatchStock.getId() %>" />
		<input type="hidden" name="batchItemId<%=i %>" id="batchItemId<%= i%>"
			value="<%=itemBatchStock.getItem().getId() %>" />
		<input type="hidden" name="itemCode<%=i %>" id="itemCode<%= i%>"
			value="<%=itemBatchStock.getItem().getPvmsNo() %>" />
		<input type="hidden" id="mrp<%=i %>"
			value="<%=itemBatchStock.getMrp()%>" />
		<%
   	       	if(itemBatchStock.getItem().getAccountGroup() != null){
   	       %>
		<input type="hidden" name="accId<%=i %>" id="accId<%= i%>"
			value="<%=itemBatchStock.getItem().getAccountGroup().getId() %>" />
		<%} %>
		<%
   	        	if(itemBatchStock.getItem().getSubAccountGroup() != null){
   	        %>
		<input type="hidden" name="subAccId<%=i %>" id="subAccId<%= i%>"
			value="<%=itemBatchStock.getItem().getSubAccountGroup().getId() %>" />
		<%} %>
		</td>
	</tr>
	<%
   	    i++;
   	    		}
 	
   	    		    		} %>
</table>
<input type="hidden" name="counter" id="counter" value="<%=i %>" /> <%}else{ %>
<div class="clear"></div>
<h4><span>No Record found!</span></h4>

<script type="text/javascript">
 
 		window.opener.document.getElementById('itemName<%=rowVal%>').value = "";
 		window.opener.document.getElementById('qty<%=rowVal%>').value = "";
 		
 	</script> <%} %>
<div class="clear"></div>
<input type="button" name="Submit11" tabindex="1" value="Ok"
	class="button"
	onclick="setTotalBillAmountInParent();setBatchNoDetailsInParent();window.close();" />
<script type="text/javascript">

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
			setTotalQtyInParent()
			return;
		}else{
			alert("Please enter the integer value")
			return;
		}
	}
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
		}
		var totalQtyIssued = eval(window.opener.document.getElementById('qty<%=rowVal%>'));
		totalQtyIssued.value = sum;
		var totalRate = eval(window.opener.document.getElementById('amount<%=rowVal%>'));
		var totalNetAmt = eval(window.opener.document.getElementById('netamount<%=rowVal%>'));
		totalRate.value = parseFloat(totalAmt).toFixed(2);
		totalNetAmt.value =  parseFloat(totalAmt).toFixed(2);
		
		setTotalBillAmountInParent();
		return true;
  	}
  	
function setTotalBillAmountInParent(){
	var totalBillAmt = 0;
	var amt = 0;
	var totalNetAmt = 0;
	var netAmt = 0;
	var count = window.opener.document.getElementById('hiddenValueCharge').value;
	
	for(var i=1;i<=count;i++){
		if(window.opener.document.getElementById('amount'+i) != null){
			if(window.opener.document.getElementById('amount'+i).value != ""){
				amt = window.opener.document.getElementById('amount'+i).value
				totalBillAmt = parseFloat(totalBillAmt)+parseFloat(amt);
			}
			if(window.opener.document.getElementById('netamount'+i).value != ""){
				netAmt = window.opener.document.getElementById('netamount'+i).value
				totalNetAmt = parseFloat(totalNetAmt)+parseFloat(netAmt);
			}
		}
	}
//	window.opener.document.getElementById('totalAmtId').value = parseFloat(totalBillAmt).toFixed(2);
	window.opener.document.getElementById('totalNetId').value = Math.round(parseFloat(totalNetAmt));
	
	if(window.opener.document.getElementById('payableAmtId') != null)
		window.opener.document.getElementById('payableAmtId').value = Math.round(parseFloat(totalNetAmt));

<%--	
	if(totalNetAmt.toString().indexOf('.') > 0)
	{
		if(parseFloat(window.opener.document.getElementById('totalNetId').value) > parseFloat(totalNetAmt))
			window.opener.document.getElementById('roundId').value = (window.opener.document.getElementById('totalNetId').value-totalNetAmt).toFixed(2);
		else
			window.opener.document.getElementById('roundId').value = (totalNetAmt-window.opener.document.getElementById('totalNetId').value).toFixed(2);
	}else{
		window.opener.document.getElementById('roundId').value = "";
	} --%>
	
	return true;
}

 	
function setBatchNoDetailsInParent(){
	var i=0;
	var totalDis = 0;
	var tbl = window.opener.document.getElementById('batchDetails');
	var dispPrice =  window.opener.document.getElementById('dispPriceId<%=rowVal%>').value;
	var pkgqty =  window.opener.document.getElementById('quantity<%=rowVal%>').value;
	
	var avgPrice = parseFloat(dispPrice)/parseFloat(pkgqty);
	if(document.getElementById('counter') != null){
	for(var index = 1; index < parseInt(document.getElementById('counter').value); index++ ){
	
			var qtyIssuedObj = eval(document.getElementById('issueQtyId'+index));
			
			if(qtyIssuedObj.value != "")
			{
				var batchId = document.getElementById('batchId'+index).value;
				var batchItemId = document.getElementById('batchItemId'+index).value;
				var amt = document.getElementById('amt'+index).value;
				
				var lastRow = tbl.rows.length;
				var row = tbl.insertRow(lastRow);
			
				var iteration = lastRow;
				
				var cell1 = row.insertCell(0);
				var e1 = window.opener.document.createElement('input');
				e1.type = 'text';
				e1.name = '<%=BATCH_ID%>' + (iteration);
				e1.id = 'batchId' + (iteration);
				e1.value = batchId;
				cell1.appendChild(e1); 
				
				
				var cell2 = row.insertCell(1);
				var e2 = window.opener.document.createElement('input');
				e2.type = 'text';
				e2.name = '<%=ISSUE_QUANTITY%>' + (iteration);
				e2.id = 'issueQtyId' + (iteration);
				e2.value = qtyIssuedObj.value;
				cell2.appendChild(e2); 
				
				var cell3 = row.insertCell(2);
				var e3 = window.opener.document.createElement('input');
				e3.type = 'text';
				e3.name = '<%=BATCH_ITEM_ID%>' + (iteration);
				e3.id = 'batchItemId' + (iteration);
				e3.value = batchItemId;
				cell3.appendChild(e3);
				
				var cell4 = row.insertCell(3);
				var e4 = window.opener.document.createElement('input');
				e4.type = 'text';
				e4.name = 'batchAmt' + (iteration);
				e4.id = 'batchAmtId' + (iteration);
				e4.value =amt;
				cell4.appendChild(e4);  
				
				var cell5 = row.insertCell(4);
				var e5 = window.opener.document.createElement('input');
				e5.type = 'text';
				e5.name = 'batchDisPer' + (iteration);
				e5.id = 'batchDisPerId' + (iteration);
				cell5.appendChild(e5);
				
				var diffRate = 0;
				diffRate = (parseFloat(document.getElementById('mrp'+index).value) - parseFloat(avgPrice) )*qtyIssuedObj.value;
				
				totalDis = parseFloat(totalDis)+parseFloat(diffRate);
				
				var cell6 = row.insertCell(5);
				var e6 = window.opener.document.createElement('input');
				e6.type = 'text';
				e6.name = 'batchDisAmt' + (iteration);
				e6.id = 'batchDisAmtId' + (iteration);
				e6.value = diffRate.toFixed(2);
				cell6.appendChild(e6);  
				
				
				var cell7 = row.insertCell(6);
				var e7 = window.opener.document.createElement('input');
				e7.type = 'text';
				e7.name = 'batchPrptDisAmt' + (iteration);
				e7.id = 'batchPrptDisAmtId' + (iteration);
				cell7.appendChild(e7);    
				
				var cell8 = row.insertCell(7);
				var e8 = window.opener.document.createElement('input');
				e8.type = 'text';
				e8.name = 'batchNetAmt' + (iteration);
				e8.value = parseFloat(amt)-parseFloat(diffRate);
				e8.id = 'batchNetAmtId' + (iteration);
				cell8.appendChild(e8); 
				
				i++;
			}
			window.opener.document.getElementById('itemBatchCount<%=rowVal%>').value = i;
			window.opener.document.getElementById('totalBatchId').value = tbl.rows.length;
			window.opener.document.getElementById('totalDiscountAmtId').value = parseFloat(totalDis).toFixed(2);
		}
	}
	return true;
}

document.getElementById('issueQtyId1').focus();

</script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>