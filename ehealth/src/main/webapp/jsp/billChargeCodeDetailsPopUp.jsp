<%@page import="java.util.*"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<form name="chargePopup" method="post" action="">
<h4>Charge Details</h4>
<div class="division"></div>
<div class="clear"></div>
<%
	
	Map<String,Object> map = new HashMap<String,Object>();
	List<Object[]> chargeSlipList = new ArrayList<Object[]>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("chargeSlipList") != null){
		chargeSlipList = (List<Object[]>)map.get("chargeSlipList");
	}
	int rowVal = 0;
	if(map.get("rowVal") !=null && map.get("rowVal") !=""){
		rowVal=Integer.parseInt(map.get("rowVal").toString());
	}
	int inpatientId = 0;
	if(map.get("inpatientId") !=null && map.get("inpatientId") !=""){
		inpatientId=Integer.parseInt(map.get("inpatientId").toString());
	}
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Charge Slip No</th>
		<th scope="col">Charge Code</th>
		<th scope="col">Charge Slip Date</th>
		<th scope="col">Qty</th>
		<th scope="col">Rate</th>
		<th scope="col">Amount</th>
		<th scope="col">Discount</th>
	</tr>
	<%
   	    	int i=1;
   		int advQty =0;
 		BigDecimal advAmt = new BigDecimal(0);
 		BigDecimal discountAmt = new BigDecimal(0);
   	    	for(Object[] chrDetail : chargeSlipList){
   	    		int qty =0;
    			BigDecimal amt =new BigDecimal(0);
    			qty = (Integer)chrDetail[1];
    			amt = (BigDecimal)chrDetail[3];
    			if(chrDetail[5] != null){
					advQty = (Integer)chrDetail[5];
					advAmt = (BigDecimal)chrDetail[6];
    			}
    			if(chrDetail[10] != null){
    				discountAmt = (BigDecimal)chrDetail[10];
    			}
    			int blChargeId=0;
    			blChargeId=(Integer)chrDetail[7];
    			int blChargeDtId=0;
    			blChargeDtId=(Integer)chrDetail[8];
   	    %>
	<tr>
		<td><%=i %></td>
		<td><%=chrDetail[4] %></td>
		<td><%=chrDetail[0] %>
		<input type="hidden" value="<%=blChargeId %>" name="blChargeId" id="blChargeId<%=i %>"/>
	<input type="hidden" value="<%=blChargeDtId %>" name="blChargeDtId" id="blChargeDtId<%=i %>"/></td>
	<td><%=chrDetail[9] %></td>
		<td style="width: 60px;">
		<input style="width: 50px;" type="text" value="<%=qty-advQty %>" readonly="readonly" id="qty<%=i %>"/>
		</td>
		<td style="width: 100px;">
		<input style="width: 90px;" type="text" id="rate<%=i %>" name="rate" readonly="readonly" value="<%=chrDetail[2] %>" />
		</td>
		<td style="width: 100px;">
		<input style="width: 90px;" type="text" name="amount" id="amount<%=i %>" readonly="readonly" value="<%=amt.subtract(advAmt) %>" />
		</td>
		<%if(discountAmt.compareTo(new BigDecimal(0))>0){ %>
		<td style="width: 100px;">
		<input style="width: 90px;" type="text" name="discount" id="discount<%=i%>"  readonly="readonly"
		onchange="calculateAmount(<%=i%>);totalCost();" value=""/>
		<input type="hidden" name="discount1" id="discount1<%=i%>" value="<%=discountAmt %>" readonly="readonly" />
		</td>
		<%}else{ %>
		<td style="width: 100px;">
		<input style="width: 90px;" type="text" name="discount" id="discount<%=i%>"  readonly="readonly"
		onchange="calculateAmount(<%=i%>);totalCost();" />
		</td>
		<%} %>
	
	</tr>
	<%
   	    i++;} %>
</table>
<div class="clear"></div>
<input type="hidden" id="inpatientId" name="inpatientId" value="<%=inpatientId %>"  />
<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
<input type="hidden" id="totalCostId" name="totalAmount" value="0" readonly="readonly" />
<input type="hidden" id="totalQtyId" name="totalQuantity" value="0" readonly="readonly" />
<input type="hidden" id="totalDiscountId" name="totalDiscount" value="0" readonly="readonly" />
<!-- <input type="button" name="Submit" value="Update" class="button" onclick="submitForm('chargePopup','/hms/hms/billing?method=updateFinalBill');window.close();" />
 --><input type="button" name="close" value="Close" class="button"onclick="window.close();" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>
	function calculateAmount(inc){
		var rateObj = document.getElementById('rate'+inc).value;
		var qtyObj = document.getElementById('qty'+inc).value;
		var discountObj =document.getElementById('discount'+inc).value;
		var amount = 0;
		
		if(discountObj !=null && discountObj !=""  ){
			var discountObj1 =document.getElementById('discount1'+inc);
			if(discountObj1!=null && discountObj1!=""){
				amount = (parseFloat(qtyObj)*parseFloat(rateObj))-(parseFloat(discountObj)+parseFloat(discountObj1.value));
			}
			else if(discountObj1==null){
				amount = (parseFloat(qtyObj)*parseFloat(rateObj))-parseFloat(discountObj);
				}		
		}
		else if(discountObj ==null || discountObj ==""){
			var discountObj2 =document.getElementById('discount1'+inc);
			if(discountObj2!=null && discountObj2!=""){
				amount = (parseFloat(qtyObj)*parseFloat(rateObj))-(parseFloat(discountObj2.value));
			}
			else{
		amount= parseFloat(qtyObj)*parseFloat(rateObj);
			}
		}
		document.getElementById('amount'+inc).value=amount;
	}
	function totalCost(){
		var amt = 0;
		var qty = 0;
		var discount = 0;
		var count = document.getElementById('hiddenValueCharge').value;
		for(var i=1; i<=count; i++){
			var totalAmt = eval(document.getElementById("amount"+i));
			var totalQty = eval(document.getElementById("qty"+i));
			var totalDiscount = eval(document.getElementById("discount"+i));

			if(totalQty !=null ){
				if(validateInteger(totalQty.value)){
					if(totalQty.value != ""){
						qty = parseInt(qty)+parseInt(totalQty.value);
					}
				}else{
					alert("Please enter valid Quantity value.\n");
					document.getElementById("qty"+i).value = "";
					return false;
				}
			}
			if(totalAmt !=null ){
			if(validateFloat(totalAmt.value)){
				if(amt != 0 && totalAmt.value != ""){
					amt = parseInt(amt)+parseInt(totalAmt.value);
				}else if(amt == 0 && totalAmt.value != ""){
					amt = parseInt(totalAmt.value);
				}
			}else{
				alert("Please enter valid Amount value.\n");
				document.getElementById("amount"+i).value = "";
				return false;
			}
		}
			if(totalDiscount !=null ){
				if(validateFloat(totalDiscount.value)){
					if(discount != 0 && totalDiscount.value != ""){
						discount = parseInt(discount)+parseInt(totalDiscount.value);
					}else if(discount == 0 && totalDiscount.value != ""){
						discount = parseInt(totalDiscount.value);
					}
				}else{
					alert("Please enter valid Amount value.\n");
					document.getElementById("amount"+i).value = "";
					return false;
				}
			}
		}
		document.getElementById('totalQtyId').value = qty;
		document.getElementById('totalCostId').value = amt;
		document.getElementById('totalDiscountId').value = discount;
	}
	function setQtyCostInParent(){
		
		if(document.getElementById('totalQtyId') != null){
			window.opener.document.getElementById('totalQtyId<%=rowVal%>').value = 
				document.getElementById('totalQtyId').value;
			
			window.opener.document.getElementById('totalQtyId<%=rowVal%>').focus();
			}
		if(document.getElementById('totalCostId') != null){
			window.opener.document.getElementById('totalCostId<%=rowVal%>').value = 
			document.getElementById('totalCostId').value;
		}
		if(document.getElementById('totalDiscountId') != null){
			var prevDiscount = window.opener.document.getElementById('disAmtId').value;
			if(prevDiscount!=null && prevDiscount !="") {
				prevDiscount=parseInt(prevDiscount)+parseInt(document.getElementById('totalDiscountId').value);
			}
			else if(prevDiscount =="" || prevDiscount==0){
				prevDiscount = parseInt(document.getElementById('totalDiscountId').value);
				}
			window.opener.document.getElementById('disAmtId').value= prevDiscount;
			}
		window.opener.document.getElementById('totalAmtId').focus();
	return true;
	}
	</script>