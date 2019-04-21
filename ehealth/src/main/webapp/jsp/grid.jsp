<%@ page import=" static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreLoaninT"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript" type="text/javascript" src="/hms/jsp/js/prototype.js"  ></script>
<script language="javascript" type="text/javascript" src="/hms/jsp/js/scriptaculous.js" ></script>

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

function fillSrNo(rowVal){
	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%30
   		if(rowVal==0){
   			rowVal=30
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}


</script>
<%
Map map = new HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
if(map.get("manufacturerList") != null){
	manufacturerList = (List<MasManufacturer>) map.get("manufacturerList");
	}

int numberOfRecordsInLoanIn = 0;
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String currentTime = (String)utilMap.get("currentTime");
String grn_qty="grn_qty";
String barCodeNo="barCodeNo";
String idItem="idItem";
String codeItem="codeItem";
String nameItem="nameItem";
String idAu="idAu";
String idBrand="idBrand";
String dispenseType = "dispenseType";
String mdq = "1";
String ratePerMdq = "ratePerMdq";
String quantityInVar="quantityInVar";
String taxVar="taxVar";
String amountVar="amountVar";
String unitRateVar="unitRateVar";
String discountVar="discountVar";
String idSection="idSection";
String costPrice ="costPrice";
String freeQty="freeQty";
String manufacturerId="manufacturerId";
String freeItem="freeItem";
String manufacturingDate="manufacturingDate";
String expiryDate="expiryDate";
String brandId="brandId";
String nameBrand="nameBrand";
String batchNo="batchNo";
String quanRec="quanRec";
String amtVar="amtVar";
String stockInVarTemp="stockInVarTemp";
String lotNo="lotNo";
String shelfLife="shelfLife";
String expiry ="expiry";
String vatTax="vatTax";
String convertedStock = "convertedStock";
String formula = "formula";
String conversionFactor = "conversionFactor";
String discountAmount = "discountAmount";
String taxAmount = "taxAmount";
String dispencingPrice="dispencingPrice";
String mrp="mrp";

%>

<link href="css/style.css" rel="stylesheet" type="text/css" />



<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div id="gridDiv">
<div class="Block"><label> VAT(%)</label> <input type="text"
	name="vatTaxPercentage" id="vatTaxPercentage" value="" MAXLENGTH="15"
	validate="Total VAT,float,no" onblur="calVatPercentage();" tabindex="2" />

<label> Total VAT Amount </label> <input type="text" name="vatTax"
	id="vatTax" value="" MAXLENGTH="15" validate="Total VAT,float,no"
	onblur="calculationInCRV()" tabindex="2" /> <label> Total
Discount </label> <input type="text" name="totDiscount" id="totDiscount"
	value="" MAXLENGTH="15" validate="Total Discount,float,no"
	onblur="calculationInCRV()" tabindex="2" />

<div class="clear"></div>
<label> GRN Valued </label> <input type="text" name="grnValue"
	id="grnValue" value="0" MAXLENGTH="15" tabindex="2" /> <label>
Round Off Value1 </label> <input type="text" name="roundOfValue"
	id="roundOfValue" value="" MAXLENGTH="15" tabindex="2" /> <input
	type="hidden" name="actualGrnValue" id="actualGrnValue" value="" /> <label>VAT
Added</label> <input type="checkbox" name="vatApplicable" id="vatApplicable"
	value="1" onClick="calculationInCRV()" class="radioCheck" />

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="cmntable">
<table colspan="0" id="grnDetails">
  	<tr>
		<th scope="col">S.No.1</th>
		<th scope="col">Item Code</th>
		<th scope="col">Item Name</th>
 		<th scope="col">Manuf. Name</th>
		<th scope="col">UOM</th>
		<th scope="col">Batch No/Lot No</th>
		<th scope="col">BarCode No</th>
		<th scope="col">Recd Qty</th>
		<th scope="col">Free Qty</th>
		<th scope="col">Dispen.Type</th>
		<!-- <th>MDQ</th> -->
		<th scope="col">Cost Price</th>
 		<th scope="col">Dispensing Price</th>
		<th scope="col">MRP</th>
		<th scope="col">Converted Stock</th>
 		<th scope="col">Disc(%)</th>
		<th scope="col">Tax(%)</th>
		<th scope="col">Amt Value</th>
		<th scope="col">Free Item</th>
		<th scope="col" colspan="2">Manuf. Date</th>
		<th scope="col" colspan="2">Expiry Date(DD/MM/YYYY)</th>
	</tr>
 	<tbody>
 		<%
		List<StoreLoaninT> gridLoanInTList= new ArrayList<StoreLoaninT>();
 		int noOfRows = 0;
	    if (map.get("gridLoanInTList")!=null)
	    {
	    	gridLoanInTList = (List) map.get("gridLoanInTList");
	    	noOfRows = gridLoanInTList.size();
	    }
	    int inc = 0;
	    List<StorePoDetail> poList=new ArrayList<StorePoDetail>();
	    poList=(List<StorePoDetail>)map.get("poList");
	    if(map.get("poList")!=null&&((List<StorePoDetail>)map.get("poList")).size()>0){
	    	String itemCode="";
	    	String itemName="";
	    	String dispenseType1="";
	    	BigDecimal recdQty1=new BigDecimal(0);
	    	String uom1="";
	    	MasManufacturer manufacturer=new MasManufacturer();
	    	BigDecimal   freeQty1=new BigDecimal(0);
	    	BigDecimal   discountAmount1=new BigDecimal(0);
	    	BigDecimal   taxAmount1=new BigDecimal(0);
	    	int conversionFactorValue1=1;
	    	BigDecimal convertedStockValue1 = new BigDecimal(0);
	    	int itemId=0;
	    	int count=0;
	    	int mdq1=1;
	    	String freeItem1="";

	    	BigDecimal ratePerMdq1=new BigDecimal(0);
	    	BigDecimal unitRate1=new BigDecimal(0);
	    	BigDecimal discountPercent1=new BigDecimal(0);
	    	BigDecimal taxPercent1=new BigDecimal(0);
	    	BigDecimal amount1=new BigDecimal(0);
 	    	poList=(List<StorePoDetail>)map.get("poList");

	    for(int t=inc+1;t<=poList.size(); t++)
		{ %>
			<%if(count<poList.size()){

   	 itemCode=poList.get(t-1).getItem().getPvmsNo();
 	BigDecimal ordQtyTemp=new BigDecimal(0);
 	BigDecimal recQtyTemp=new BigDecimal(0);
 	if(poList.get(t-1).getQuantityOrdered()!=null){
 		ordQtyTemp=poList.get(t-1).getQuantityOrdered();
 	}
 	if(poList.get(t-1).getQuantityReceived()!=null){
 		recQtyTemp=poList.get(t-1).getQuantityReceived();
 	}
 	recdQty1=ordQtyTemp.subtract(recQtyTemp);
 	//recdQty1=poList.get(t-1).getQuantityOrdered();

 	dispenseType1=poList.get(t-1).getDispType();
 	itemName=poList.get(t-1).getItem().getNomenclature()+"["+itemCode+"]";
 	 itemId=poList.get(t-1).getItem().getId().intValue();
 	 expiry=poList.get(t-1).getItem().getExpiry();
 	manufacturer=poList.get(t-1).getManufacturer();
 	freeQty1=poList.get(t-1).getFreeQuantity();
 	mdq1=poList.get(t-1).getMdqValue().intValue();
 	ratePerMdq1=poList.get(t-1).getRatePerMdq();
 	unitRate1=poList.get(t-1).getUnitRate();
 	discountPercent1=poList.get(t-1).getDiscountPercent();
 	taxPercent1=poList.get(t-1).getTaxPercent();
 	//amount1=poList.get(t-1).getAmount();
 	freeItem1=poList.get(t-1).getFreeItem();
 	uom1=poList.get(t-1).getItem().getItemConversion().getItemUnitName();
 	discountAmount1=poList.get(t-1).getDiscountAmount();
 	taxAmount1=poList.get(t-1).getTaxAmount();
 	conversionFactorValue1=poList.get(t-1).getItem().getItemConversion().getConversionFactor1();




	if(poList.get(t-1).getItem().getItemConversion().getFormula()!=null){
		if (poList.get(t-1).getItem().getItemConversion().getFormula().equals("1"))
		{
			convertedStockValue1 = recdQty1.multiply(new BigDecimal(mdq1)).divide(new BigDecimal(conversionFactorValue1));
		}
		else if (poList.get(t-1).getItem().getItemConversion().getFormula().equals("2"))
		{
			convertedStockValue1 = recdQty1;
		}
	}else{
		convertedStockValue1 = recdQty1;
	}
		amount1=convertedStockValue1.multiply(ratePerMdq1);
 	}
 	else{
 		itemCode="";
 		itemName="";
 		itemId=0;
 		recdQty1=new BigDecimal(0);
 		manufacturer=new MasManufacturer();
 		dispenseType1="";
 		freeQty1=new BigDecimal(0);
 		mdq1=1;
 		ratePerMdq1=new BigDecimal(0);
 		unitRate1=new BigDecimal(0);
 		discountPercent1=new BigDecimal(0);
 		taxPercent1=new BigDecimal(0);
 		amount1=new BigDecimal(0);
 		discountAmount1=new BigDecimal(0);
 		freeItem1="";
 		uom1="";
 		convertedStockValue1=new BigDecimal(0);
 		taxAmount1=new BigDecimal(0);
 	}
	count++;
    %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=t%>"
				name="<%=SR_NO%>" readonly="readonly" tabindex="1" /></td>
			<td width="10%"><%--<input type="text"  name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem+""+t%>" />	--%>
			<input type="text" name="<%=ITEM_CODE %>" size="5"
				id="<%=codeItem+""+t%>" value="<%=itemCode%>"
				onblur="autocompleteBasedOnPvms(this.value,'<%=t%>');"
				validate="PVMS No,String,no" tabindex="1" /> 

				
				<input type="hidden"
				name="flag" value="Grn" /> <input type="hidden" size="2"
				name="<%=ITEM_ID%>" value="<%=itemId %>" id="<%=idItem+""+t%>" /> <input
				type="hidden" name="<%=DETAIL_ID %>" value="0" id="hdb" /> <input
				type="hidden" value="<%=expiry %>" name="" id="<%=expiry+""+t%>" /> <input
				type="hidden" value="<%=poList.get(t-1).getItem().getItemConversion().getFormula() %>" name="" id="<%=formula+""+t%>" /> <input
				type="hidden" value="<%=poList.get(t-1).getItem().getItemConversion().getConversionFactor1() %>" name="" id="<%=conversionFactor+""+t%>" /></td>

			<td width="10%"><input type="text" size="50" id="<%=nameItem+""+t%>"
				value="<%=itemName%>" class="bigcaption"
				onblur="if(fillSrNo('<%=t%>')){checkForGrn(this.value, '<%=nameItem%>','<%=t%>');}"
				name="<%=nameItem%>" tabindex="1" />
			<div id="ac6update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%=nameItem+""+t%>','ac6update','stores?method=getItemListForGrnByAutocomplete',{minChars:3,parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
			</script></td>

			<%--	<td width="10%">
		 	<select name="<%=BRAND_ID%>"  id="<%=brandId+""+t%>" tabindex="1">
			<option value="">--Select Brand--</option>
			</select>
		   	</td> --%>
	 		<td width="10%"><select name="<%=MANUFACTURER_ID %>"
				id=<%=manufacturerId+""+t%> tabindex="1">
				<!--<%--<option value="<%=manufacturer.getId()%>"><%=manufacturer.getManufacturerName() %></option>
			--%>-->
			<option value="0">--Select Manuf--</option>
			 	<%for(MasManufacturer manufacturer1 :manufacturerList)
			 	{
			 	  %>
                   <option value="<%=manufacturer1.getId()%>"><%=manufacturer1.getManufacturerName()%></option>
			 	<%}%>
			</select>
			</td>
			<td width="10%"><input type="text" tabindex="1"
				value="<%=uom1 %>" size="8" readonly="readonly" tabindex="1"
				name="<%=AV%>" id="<%=idAu+""+t%>" /></td>

			<td width="10%"><input type="text" value="" size="8"
				name="<%=BATCH_NO %>" tabindex="1" id="<%=batchNo+""+t%>"
				maxlength="25" /> <input type="hidden" value="" name="<%=LOT_NO %>"
				tabindex="1" id="<%=lotNo+""+t%>" maxlength="50" />
				<input type="hidden" name="storeDept" id="storeDept<%=t %>"/>

				</td>
			<td width="10%"><input type="text" value="" size="15"
				name="barCodeNo" tabindex="1" id="barCodeNo<%=t%>" maxlength="35" />
  			</td>


			<td width="10%"><input type="text" value="<%=recdQty1 %>"
				size="8" name="<%=QUANTITY_RECEIVED %>" tabindex="1"
				id="<%=quanRec+""+t%>" onblur="calculationInCRV();" /> <input
				type="hidden" value="<%=recdQty1 %>" name="<%=GRN_QTY %>"
				tabindex="1" id="<%=grn_qty+""+t%>" maxlength="50" /></td>


			<td width="10%"><input type="text" value="<%=freeQty1%>"
				size="8" name="<%=FREE_QTY %>" id="<%=freeQty+""+t %>" tabindex="1"
				onblur="calculationInCRV()" /></td>
			<% if(!dispenseType.equals("")){%>
			<td width="10%"><select name="dispenseType"
				id=<%=dispenseType+""+t%>>
				<option value="<%=dispenseType1 %>"><%=dispenseType1 %></option>
			</select> <% }else{%>

			<td width="10%"><select name="dispenseType"
				id=<%=dispenseType+""+t%>>
			</select> <%} %>
</td>
			<td width="10%"><input type="hidden" value="1" size="8"
				name="mdq" readonly="readonly" id="<%=mdq+""+t%>" tabindex="1" /> <input
				type="text" value="<%=ratePerMdq1 %>" size="8" name="ratePerMdq"
				id="<%=ratePerMdq+""+t%>" tabindex="1" onblur="calculationInCRV()" />
			</td>
			<td width="10%"><input type="text" value="0" size="8"
				name="dispencingPrice" id="dispencingPrice<%=t%>" tabindex="1"
				onblur="calculationInCRV()" /></td>
			<td width="10%"><input type="text" value="0" size="8" name="mrp"
				id="mrp<%=t%>" tabindex="1" onblur="calculationInCRV()" /></td>
			<td width="3%"><input type="text" size="8"
				value="<%=convertedStockValue1 %>" name="convertedStock"
				id="<%=convertedStock+""+t%>" readonly="readonly" /></td>
			<input type="hidden" size="8" value="<%=unitRate1 %>"
				name="<%=UNIT_RATE%>" readonly="readonly" tabindex="2"
				id="<%=unitRateVar+""+t%>" />
			<td width="3%"><input type="text" size="8"
				value="<%=discountPercent1 %>" name="<%=DISCOUNT_PERCENTAGE%>"
				tabindex="1" id="<%=discountVar+""+t%>" onblur="calculationInCRV();"
				validate="Discount,float,no" /> <input type="hidden"
				value="<%=discountAmount1 %>" name="discountAmount"
				id="<%=discountAmount+""+t%>" /></td>

			<td width="10%"><input type="text" value="<%=taxPercent1 %>"
				size="8" name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar+""+t%>"
				onblur="calculationInCRV();" validate="Tax,float,no" /> <input
				type="hidden" value="<%=taxAmount1 %>" name="taxAmount"
				id="<%=taxAmount+""+t%>" /></td>

			<td width="10%"><input type="hidden" value="0"
				name="<%= COST_PRICE %>" id="<%=costPrice+""+t%>" /> <input
				type="text" value="<%=amount1 %>" size="8" name="<%=AMOUNT%>"
				id="<%=amtVar+""+t%>" readonly="readonly" /></td>

			<td width="10%"><select name="<%=FREE_ITEM %>"
				id="<%=freeItem+""+t%>" size="8" class="small">
				<option value="n" <%if(freeItem1.equals("n")) {%> selected <% }%>>No</option>
				<option value="y" <%if(freeItem1.equals("y")) {%> selected <% }%>>Yes</option>
			</select></td>

			<td width="50%">
			<input type="text"	name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+t%>"	tabindex="1" size="8"	readonly="readonly" />
			</td>
			<td>
	 		<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+t%>'),event);" />
				</td>

			<td width="40%">
			<input type="text" name="<%=EXPIRY_DATE%>"	id="<%=expiryDate+""+t %>" tabindex="1" size="8"   title="DD/MM/YYYY" onblur="validateExpDate(this,<%=t%>);"/>
			</td>
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+t %>'),event);" />
			</td>
		</tr>
 		<input type="hidden" name="poListSize" id="poListSize"	value="<%=poList.size() %>" />

		<%}%>

		<%}else{
	   	if (gridLoanInTList != null && gridLoanInTList.size()>0)
	    {
    		 for(StoreLoaninT storeLoaninT : gridLoanInTList)
	    	 {
    			 inc = inc + 1;
	    	 %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=inc%>"
				name="<%=SR_NO%>" readonly="readonly" /></td>

			<input type="hidden" name="flag" value="LoanIn" />
			<td width="10%">
			<%if(storeLoaninT.getItem().getPvmsNo()!=null){ %> <input type="text"
				value="<%=storeLoaninT.getItem().getPvmsNo() %>77777777777" size="8"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem+""+inc%>" />
			<%}else{ %> <input type="text" value=" " tabindex="1"
				name="<%=ITEM_CODE %>" size="8" readonly="readonly"
				id="<%=codeItem+""+inc%>" /> <%} %>
			</td>

			<input type="hidden" name="<%=DETAIL_ID %>"
				value="<%=storeLoaninT.getId() %>" id="hdb" />
			<input type="text" value="<%=storeLoaninT.getItem().getId()%>9999999"
				name="<%=ITEM_ID%>" id="<%=idItem+""+inc%>" />
			<input type="hidden" value="<%=storeLoaninT.getItem().getExpiry() %>" name="" id="<%=expiry+""+inc%>" />
			<input type="hidden" value="" name="" id="<%=formula+""+inc%>" />
			<input type="hidden" value="" name=""
				id="<%=conversionFactor+""+inc%>" />


			<td width="10%"><input type="text" size="50"
				value="<%=storeLoaninT.getItem().getNomenclature() %>"
				readonly="readonly" id="<%=nameItem+""+inc%>" class="bigcaption"
				name="<%=nameItem%>" /></td>

			<%-- <td width="10%">
			   <select name="<%=BRAND_ID%>"  id="<%=brandId+""+inc%>">
		   	   <option value="<%=storeLoaninT.getBrand().getId()%>"><%=storeLoaninT.getBrand().getBrandName()%></option>
		   </select>
		   </td> --%>

			<td width="10%"><select name="<%=MANUFACTURER_ID %>"
				id=<%=manufacturerId+""+inc%> tabindex="1">

				<option value="<%=storeLoaninT.getManufacturer().getId()%>"><%=storeLoaninT.getManufacturer().getManufacturerName()%></option>
			</select>
			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getItem().getItemConversion().getItemUnitName() %>"
				readonly="readonly" name="<%=AV%>" id="<%=idAu+""+inc%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getBatchNo() %>" name="<%=BATCH_NO %>"
				readonly="readonly" tabindex="3" id="<%=batchNo+""+inc%>" />
				<input type="hidden" name="storeDept" id="storeDept<%=inc %>"/>
				</td>
			<td width="10%"><input type="text" value="" size="15"
				name="barCodeNo" tabindex="1" id="barCodeNo<%=inc%>" maxlength="35" />
			</td>
			<%--
	       <td width="10%">
		       <input type="hidden" value="<%=storeLoaninT.getLotNo() %>"  name="<%=LOT_NO %>" readonly="readonly" tabindex="2" id="<%=lotNo+""+inc%>"/>
	       </td>
 	      --%>

			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getReceivedQty() %>"
				name="<%=QUANTITY_RECEIVED %>" readonly="readonly" tabindex="2"
				id="<%=quanRec+""+inc%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getFreeQty() %>" name="<%=FREE_QTY %>"
				id="<%=freeQty+""+inc%>" readonly="readonly" /></td>

			<td width="10%"><select name="dispenseType"
				id=<%=dispenseType+""+inc%> tabindex="1">
				<option value="<%=storeLoaninT.getDispType()%>"><%=storeLoaninT.getDispType()%></option>
			</select>
			<td width="10%"><input type="hidden" value="1" name="mdq"
				readonly="readonly" id="<%=mdq+""+inc%>" tabindex="2" /> <input
				type="text" value="<%=storeLoaninT.getRatePerMdq()%>"
				name="ratePerMdq" readonly="readonly" id="<%=ratePerMdq+""+inc%>"
				tabindex="2" /></td>
			<td width="10%"><input type="text" value="0" size="8"
				name="dispencingPrice" id="dispencingPrice<%=inc%>" tabindex="1"
				onblur="calculationInCRV();" /></td>
			<td width="10%"><input type="text" value="0" size="8" name="mrp"
				id="mrp<%=inc%>" tabindex="1" onblur="calculationInCRV();" /></td>
			<%
			BigDecimal tax = new BigDecimal(0);
	       	BigDecimal discount = new BigDecimal(0);
	       	BigDecimal qty = new BigDecimal(0);
	       	BigDecimal rate = new BigDecimal(0);
	       	BigDecimal amount  = new BigDecimal(0);
	       	BigDecimal amountAfterTax = new BigDecimal(0);
	       	int mdqValue = 1;
	       	String formulaValue = "";
	       	int conversionFactorValue = 0;

		    float taxPercent = 0f;
		    float discountPercent = 0f;


		    try
			{
				qty = storeLoaninT.getReceivedQty();
			}
			catch(Exception e)
			{
				qty = new BigDecimal(0);
			}

		    try
			{
				rate = storeLoaninT.getRatePerMdq();
			}
			catch(Exception e)
			{
				rate = new BigDecimal(0);
			}

		    try
			{
				tax = storeLoaninT.getTax();
			}
			catch(Exception e)
			{
				tax = new BigDecimal(0);
			}

			try
			{
				discount = storeLoaninT.getDiscount();
			}
			catch(Exception e)
			{
				discount = new BigDecimal(0);
			}

			try
			{
				formulaValue = storeLoaninT.getItem().getItemConversion().getFormula();
			}
			catch(Exception e)
			{
				formulaValue = "";
			}


			try
			{
				conversionFactorValue = storeLoaninT.getItem().getItemConversion().getConversionFactor1();
			}
			catch(Exception e)
			{
				conversionFactorValue = 1;
			}

			try
			{
				mdqValue = storeLoaninT.getMdqValue();
			}
			catch(Exception e)
			{
				mdqValue = 1;
			}

			amount = qty.multiply(rate);
			amountAfterTax = amount.add(tax);

			taxPercent = tax.divide(amount).multiply(new BigDecimal(100)).floatValue();
			discountPercent = discount.divide(amountAfterTax).multiply(new BigDecimal(100)).floatValue();

			BigDecimal convertedStockValue = new BigDecimal(0);

			if (formulaValue.equals("1"))
			{
				convertedStockValue = qty.multiply(new BigDecimal(mdqValue)).divide(new BigDecimal(conversionFactorValue));
			}
			else if (formulaValue.equals("2"))
			{
				convertedStockValue = qty;
			}

			%>

			<td width="3%"><input type="text"
				value="<%=convertedStockValue%>" name="convertedStock"
				id="<%=convertedStock+""+inc%>" readonly="readonly" /></td>

			<input type="hidden" value="<%=storeLoaninT.getUnitRate() %>"
				name="<%=UNIT_RATE%>" readonly="readonly" tabindex="2"
				id="<%=unitRateVar+""+inc%>" />


			<td width="3%"><input type="text" value="<%=discountPercent%>"
				name="<%=DISCOUNT_PERCENTAGE%>" readonly="readonly" tabindex="2"
				id="<%=discountVar+""+inc%>" /> <input type="hidden"
				value="<%=storeLoaninT.getDiscount()%>" name="discountAmount"
				id="<%=discountAmount+""+inc%>" /></td>

			<td width="10%"><input type="text" value="<%=taxPercent%>"
				name="<%=TAX_PERCENT %>" tabindex="2" readonly="readonly"
				id="<%=taxVar+""+inc%>" /> <input type="hidden"
				value="<%=storeLoaninT.getTax()%>" name="taxAmount"
				id="<%=taxAmount+""+inc%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeLoaninT.getAmountValue() %>" size="8" name="<%=AMOUNT %>"
				tabindex="2" readonly="readonly" id="<%=amtVar+""+inc%>" /> <input
				type="hidden" value="<%=storeLoaninT.getFinalCostPrice()%>"
				name="<%= COST_PRICE %>" id="<%=costPrice+""+inc%>" /></td>

			<td width="10%"><select name="<%=FREE_ITEM %>"
				id="<%=freeItem+""+inc%>" tabindex="2">
				<option value="n"
					<%=HMSUtil.isSelected(storeLoaninT.getFreeItem(),"n")%>>No</option>
				<option value="y"
					<%=HMSUtil.isSelected(storeLoaninT.getFreeItem(),"y")%>>Yes</option>
			</select></td>

			<td width="40%"><input type="text"
				value="<%=storeLoaninT.getManufacturerDate()==null?"":storeLoaninT.getManufacturerDate()%>"
				name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+inc%>"
				MAXLENGTH="30" tabindex="2" readonly="readonly" /></td>

			<td width="40%"><input type="text"
				value="<%=storeLoaninT.getExpiryDate()==null?"":HMSUtil.convertDateToStringWithoutTime(storeLoaninT.getExpiryDate())%>"
				name="<%=EXPIRY_DATE%>" id="<%=expiryDate+""+inc %>" MAXLENGTH="30"
				tabindex="2"    title="DD/MM/YYYY" onblur="validateExpDate(this,<%=inc%>);"/></td>
		</tr>
		<% }
	} //for loop ends here %>

		<% // Code for Adding Empty Rows
	for(int t=inc+1;t<41; t++)
	{
    %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=t%>"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><!--<input type="text"  name="<%=ITEM_CODE %>"  readonly="readonly" id="<%=codeItem+""+t%>" />	-->
			<input type="text" name="<%=ITEM_CODE %>" size="8"
				id="<%=codeItem+""+t%>"
				onblur="autocompleteBasedOnPvms(this.value,'<%=t%>');"
				validate="PVMS No,String,no" tabindex="1" /> <input type="hidden"
				name="flag" value="Grn" /> <input type="hidden" size="2" value="0"
				name="<%=ITEM_ID%>" id="<%=idItem+""+t%>" /> <input type="hidden"
				name="<%=DETAIL_ID %>" value="0" id="hdb" /> <input type="hidden"
				value="" name="" id="<%=expiry+""+t%>" /> <input type="hidden"
				value="" name="" id="<%=formula+""+t%>" /> <input type="hidden"
				value="" name="" id="<%=conversionFactor+""+t%>" /></td>

			<td width="10%"><input type="text" value=""
				id="<%=nameItem+""+t%>" class="bigcaption" tabindex="1"
				onblur="if(fillSrNo('<%=t%>')){checkForGrn(this.value, '<%=nameItem%>','<%=t%>');}"
				name="<%=nameItem%>"  size="50"/>
			<div id="ac7update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%=nameItem+""+t%>','ac7update','stores?method=getItemListForGrnByAutocomplete',{minChars:3,parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
			</script></td>

			<%--	<td width="10%">
		 	<select name="<%=BRAND_ID%>"  id="<%=brandId+""+t%>" tabindex="1">
			<option value="">--Select Brand--</option>
			</select>
		   	</td> --%>

			<td width="10%"><select name="<%=MANUFACTURER_ID %>" id=<%=manufacturerId+""+t%> tabindex="1">
			 	<option value="0">--Select Manuf--</option>
			 	<%for(MasManufacturer manufacturer :manufacturerList)
			 	{
			 	  %>
                   <option value="<%=manufacturer.getId()%>"><%=manufacturer.getManufacturerName()%></option>
			 	<%}%>
			</select></td>

			<td width="10%"><input type="text" value="" size="8"
				readonly="readonly" tabindex="1" name="<%=AV%>" id="<%=idAu+""+t%>" />
			</td>

			<td width="10%"><input type="text" value="" size="8"
				name="<%=BATCH_NO %>" tabindex="1" id="<%=batchNo+""+t%>"
				maxlength="25" />
				<input type="hidden" name="storeDept" id="storeDept<%=t %>"/>
				</td>
			<td width="10%"><input type="text" value="" size="15"
				name="barCodeNo" tabindex="1" id="barCodeNo<%=t%>" maxlength="35" />
			</td>
			<input type="hidden" value="" size="8" name="<%=LOT_NO %>"
				tabindex="1" id="<%=lotNo+""+t%>" maxlength="50" />

			<td width="10%"><input type="text" value="0" size="8"
				name="<%=QUANTITY_RECEIVED %>" tabindex="1" id="<%=quanRec+""+t%>"
				onblur="calculationInCRV();" /></td>


			<td width="10%"><input type="text" value="" size="8"
				name="<%=FREE_QTY %>" id="<%=freeQty+""+t %>" tabindex="1"
				onblur="calculationInCRV();" /></td>

			<td width="10%"><select name="dispenseType"
				id="dispenseType<%=t%>" tabindex="1">
				<option value="">--Select dispense type--</option>
			</select></td>
			<td width="10%"><input type="hidden" size="8"
				readonly="readonly" value="1" name="mdq" id="<%=mdq+""+t%>"
				tabindex="1" /> <input type="text" value="" size="8"
				name="ratePerMdq" id="<%=ratePerMdq+""+t%>" tabindex="1"
				onblur="calculationInCRV();" /></td>
			<td width="10%"><input type="text" value="0" size="8"
				name="dispencingPrice" id="dispencingPrice<%=t%>" tabindex="1"
				onblur="calculationInCRV();" /></td>
			<td width="10%"><input type="text" value="0" size="8" name="mrp"
				id="mrp<%=t%>" tabindex="1" onblur="calculationInCRV();" /></td>
			<td width="3%"><input type="text" value="0" size="8"
				name="convertedStock" id="<%=convertedStock+""+t%>"
				readonly="readonly" /></td>

			<td width="3%"><input type="text" value="0" size="8"
				name="<%=DISCOUNT_PERCENTAGE%>" tabindex="1"
				id="<%=discountVar+""+t%>" onblur="calculationInCRV();"
				validate="Discount,float,no" /> <input type="hidden" value="0"
				name="discountAmount" id="<%=discountAmount+""+t%>" /></td>

			<td width="10%"><input type="text" size="8"
				name="<%=TAX_PERCENT %>" tabindex="1" id="<%=taxVar+""+t%>"
				onblur="calculationInCRV();" validate="Tax,float,no" value="0" /> <input
				type="hidden" value="0" name="taxAmount" id="<%=taxAmount+""+t%>" />
			</td>

			<td width="10%"><input type="hidden" value="0" size="8"
				name="<%= COST_PRICE %>" id="<%=costPrice+""+t%>" /> <input
				type="text" value="0" name="<%=AMOUNT%>" id="<%=amtVar+""+t%>"
				readonly="readonly" /></td>

			<td width="10%"><select name="<%=FREE_ITEM %>"
				id="<%=freeItem+""+t%>" class="small">
				<option value="n">No</option>
				<option value="y">Yes</option>
			</select></td>

			<td width="50%">
			<input type="text"	name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate+""+t%>"	tabindex="1" size="8" readonly="readonly" />
			</td>
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate+""+t%>'),event);" />
			</td>

			<td width="40%">
			<input type="text" name="<%=EXPIRY_DATE%>"	id="<%=expiryDate+""+t %>" tabindex="1" size="8" title="DD/MM/YYYY" onblur="validateExpDate(this,<%=t%>);"/>
			</td>
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.getElementById('<%=expiryDate+""+t %>'),event);" />
			</td>
		</tr>
		<input type="hidden" name="" id="poListSize" value="40" />
		<% }} // Code for Adding Empty Rows Ends Here %>
	</tbody>
</table>
</div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
