<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<%@page import="jkt.hms.util.HMSUtil"%>


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

 var brandArray = new Array();
   function fillValuesInGrn(inc)
  {

  	 	var quanRec = "quanRec";
    	var taxVar = "taxVar";
    	var amtVar = "amtVar";
    	var unitRateVar = "unitRateVar";
    	var discountVar = "discountVar";
    	var quanRecTemp = "quanRecTemp";
    	var taxVarTemp = "taxVarTemp";
    	var unitRateVarTemp = "unitRateVarTemp";
    	var discountVarTemp = "discountVarTemp";
    	var amtVarTemp = "amtVarTemp";
    	
    	document.getElementById(quanRec+inc).value=document.getElementById(quanRecTemp+inc).value
    	
    	if(document.getElementById(taxVarTemp+inc).value != ""){
    		document.getElementById(taxVar+inc).value=document.getElementById(taxVarTemp+inc).value
    	}else{
    		document.getElementById(taxVar+inc).value = 0;
    	}
    	
    	document.getElementById(unitRateVar+inc).value=document.getElementById(unitRateVarTemp+inc).value
		
		if(document.getElementById(discountVarTemp+inc).value != ""){
    		document.getElementById(discountVar+inc).value=document.getElementById(discountVarTemp+inc).value
    	}else{
    		document.getElementById(discountVar+inc).value = 0;
    	}
    				if(document.getElementById(amtVarTemp+inc).value != ""){
    		document.getElementById(amtVar+inc).value=document.getElementById(amtVarTemp+inc).value
    	}else{
    		document.getElementById(amtVar+inc).value = 0;
    	} 
    	
    	 }
  

  

    function checkForNext(){
  if(document.getElementById('noOfRows').value<10)
  {
  	alert("All rows are not filled.To continue press Submit ")
  	return false;
  }else{
  return true;
  }
  }
  
  function checkForSubmit(){
  if(document.getElementById('noOfRows').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
 
  }

</script>
<% 
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int grnId=0;	
	if(map.get("grnId")!=null){
		grnId=Integer.parseInt(""+map.get("grnId"));
	}	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			if(map.get("itemList") != null){
				itemList = (ArrayList) map.get("itemList");
				session.setAttribute("itemList",itemList);
			}else if(session.getAttribute("itemList") != null){
				itemList = (ArrayList)session.getAttribute("itemList");
				
			}
			
			List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
			if(map.get("brandList") != null){
				brandList = (ArrayList) map.get("brandList");
				session.setAttribute("brandList",brandList);
			}else if(session.getAttribute("brandList") != null){
				brandList = (ArrayList)session.getAttribute("brandList");
				
			}
			
			String message="";
			if(map.get("message") != null){
				message = (String)map.get("message"); 
			}
			String max="";
			if(map.get("max") != null){
				max = (String) map.get("max");
			}
			String userName = "";
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			
			String time="";
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			 date = (String)utilMap.get("currentDate");	 
			 time = (String)utilMap.get("currentTime");
			int pageNo=1;
			if (map.get("pageNo") != null) {
				pageNo = Integer.parseInt(""+map.get("pageNo"));
			}
			String includedJsp = null;
			if (request.getAttribute("map") != null) {
				map = (Map) request.getAttribute("map");
				

			}
			includedJsp = (String) map.get("includedJsp");
			%>

<script>
 var nameArray=new Array();
 var itemsArray1=new Array();
</script>

<% 
   int k=0;
     if(itemList.size()>0)
   for (MasStoreItem masStoreItem:itemList){
    %>
<script>
           itemsArray1[<%=k%>]= new Array();
           itemsArray1[<%=k%>][0] = "<%=masStoreItem.getId()%>";
    itemsArray1[<%=k%>][1] = "<%=masStoreItem.getPvmsNo()%>";
    <%StringBuffer output_str = new StringBuffer();
    StringTokenizer s = new StringTokenizer(masStoreItem.getNomenclature().toString(),"\""); 
    
    while (s.hasMoreTokens())
    {
     output_str.append(s.nextToken());
     if (s.hasMoreTokens())
     {
     output_str.append("\\");
             output_str.append("\"");
     }
    }
   
    %>
    nameArray[<%=k%>]="<%=output_str.toString()%>"
    itemsArray1[<%=k%>][2]="<%=output_str.toString()%>"
     <%
    	if(masStoreItem.getItemConversion() != null){
    %>
    itemsArray1[<%=k%>][3] = "<%=masStoreItem.getItemConversion().getItemUnitName()%>";
    <%}%>
    
   
        itemsArray1[<%=k%>][4] = "<%=masStoreItem.getExpiry()%>";
     
  
           
           </script>

<% k++;}%>



<div id="gridDiv">
<div
	style="overflow: auto; width: 100%; height: 280px; padding-left: 9px;">
<table width="250px" colspan="7" id="grnDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>


			<td width="5%"><label valign="left" class="gridsmlabel">S.No.</label></td>
			<td width="8%"><label valign="left" class="smalllabel">PVMS/NIV
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Manufacturer
			Name</label></td>
			<td width="9%"><label valign="left" class="smalllabel">A/U</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Qty
			Recd</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Free
			Qty</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Dispen.Type</label></td>
			<td width="9%"><label valign="left" class="smalllabel">MDQ</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Rate
			Per MDQ</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Batch
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Lot
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Unit
			Rate</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Disc(%)</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Tax(%)</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Amt
			Value</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Free
			Item</label></td>
			<td width="20%"><label valign="left" class="smalllabel">Manuf.
			Date</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Expiry
			Date</label></td>
		</tr>
	</thead>
	<tbody>

		<%
    	int detailCounter=10; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idSection="idSection";
    	String nameBrand="nameBrand";
    	String idBrand="idBrand";
    	String idAu="idAu";
    	String batchNo="batchNo";
    	String batchNoTemp="batchNoTemp";
    	String lotNoTemp="lotNoTemp";
    	String quanRec="quanRec";
    	String quanRecTemp="quanRecTemp";
    	String taxVar="taxVar";
    	String unitRateVar="unitRateVar";
    	String discountVar="discountVar";
    	String amtVar="amtVar";
    	String taxVarTemp="taxVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String discountVarTemp="discountVarTemp";
    	String amtVarTemp="amtVarTemp";
    	String stockInVarTemp="stockInVarTemp";
    	String mmfVarTemp="mmfVarTemp";
    	String demandVarTemp="demandVarTemp";
    	String incVar="incVar";
    	String quantityInVar="quantityInVar";
      	String quantityInVarTemp="quantityInVarTemp";
      	String freeQty="freeQty";
    	String freeItem="freeItem";
    	String manufacturingDate="manufacturingDate";
    	String expiryDate="expiryDate";
    	String manufacturerId="manufacturerId";
    	String lotNo="lotNo";
    	String shelfLife="shelfLife";
    	String expiry ="expiry";
    	String brandId ="brandId";
    	String costPrice="costPrice";
    	String costPriceTemp ="costPriceTemp";
    	
    	String dispenseType = "dispenseType";
    	String mdq = "mdq";
    	String ratePerMdq = "ratePerMdq";
    
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idSection2="idSection";
    	String nameBrand2="nameBrand";
    	String idBrand2="idBrand";
    	String idAu2="idAu";
    	String freeItem2="freeItem";
    	String manufacturingDate2="manufacturingDate";
    	String expiryDate2="expiryDate";
    	String batchNo2="batchNo";
    	String batchNoTemp2="batchNoTemp";
    	String lotNoTemp2="lotNoTemp";
    	String quanRec2="quanRec";
    	String quanRecTemp2="quanRecTemp";
    	String taxVar2="taxVar";
    	String unitRateVar2="unitRateVar";
    	String discountVar2="discountVar";
    	String amtVar2="amtVar";
    	String quantityInVar2="quantityInVar";
    	String freeQty2="freeQty";
    	String taxVarTemp2="taxVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String discountVarTemp2="discountVarTemp";
    	String amtVarTemp2="amtVarTemp";
    	String quantityInVarTemp2="quantityInVarTemp";
    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	String manufacturerId2="manufacturerId";
    	String lotNo2="lotNo";
    	String shelfLife2 ="shelfLife";
    	String expiry2="expiry";
    	String brandId2="brandId";
    	String costPrice2="costPrice";
    	String costPriceTemp2 ="costPriceTemp";
    	
    	String dispenseType2 = "dispenseType";
    	String mdq2 = "mdq";
    	String ratePerMdq2 = "ratePerMdq";
	
    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=10;inc++)
     	 {
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idSection=idSection2+(""+inc);
     		nameBrand=nameBrand2+(""+inc);
     		idBrand=idBrand2+(""+inc);
     		idAu=idAu2+(""+inc);
     		taxVar=taxVar2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     		discountVar=discountVar2+(""+inc);
     		amtVar=amtVar2+(""+inc);
     		batchNo=batchNo2+(""+inc);
     		batchNoTemp=batchNoTemp2+(""+inc);
     		lotNo=lotNo2+(""+inc);
     		lotNoTemp=lotNoTemp2+(""+inc);
     		quanRec=quanRec2+(""+inc);
     		quanRecTemp=quanRecTemp2+(""+inc);
     		taxVarTemp=taxVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		discountVarTemp=discountVarTemp2+(""+inc);
     		amtVarTemp=amtVarTemp2+(""+inc);
     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		freeQty=freeQty2+(""+inc);     		
     		freeItem=freeItem2+(""+inc);
     		manufacturingDate=manufacturingDate2+(""+inc);
     		expiryDate=expiryDate2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		shelfLife = shelfLife2+(""+inc);
     		expiry = expiry2+(""+inc);
     		brandId =brandId2+(""+inc);
     		costPrice=costPrice2+(""+inc);
     		costPriceTemp= costPriceTemp2+(""+inc);
     		
     		dispenseType = dispenseType2 +(""+inc);
        	mdq = mdq2 +(""+inc);
        	ratePerMdq = ratePerMdq2 +(""+inc);
     
    	   %>

		<tr>

			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>

			<td width="10%"><input type="text" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <input
				type="hidden" size="2" value="0" class="smcaption"
				name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>

			<td width="10%"><input type="text" value="" id="<%=nameItem%>"
				class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForLoanIn(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" tabindex="2" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
	   new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForLoanInByAutocomplete',{parameters:'requiredField=<%=nameItem%>&poId='+document.getElementById('poId').value});
	   </script></td>

			<td width="10%"><select name="<%=BRAND_ID%>" id="<%=brandId%>">
				<option value="">--select brand--</option>
			</select></td>

			<td width="10%"><select name="<%=MANUFACTURER_ID %>"
				id=<%=manufacturerId%> tabindex="1">
				<option value="">--select manuf--</option>
			</select>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>" tabindex="1" /> <input
				type="hidden" value="0" class="smcaption" name="<%=EXPIRY%>"
				id="<%=expiry%>" /></td>


			<td width="10%"><input type="text" value="" class="medcaption"
				name="" id="<%=quanRecTemp%>" tabindex="2" maxlength="20"
				validate="Quantity,float,no"
				onblur="fillQuantityForLoanIn(<%=inc %>);" /> <input type="hidden"
				value="0" class="medcaption" name="<%=QUANTITY_RECEIVED %>"
				tabindex="2" id="<%=quanRec%>" /></td>

			<td width="10%"><input type="text" class="medcaption" value="0"
				name="<%=FREE_QTY %>" id="<%= freeQty %>" maxlength="6" /></td>


			<td width="10%"><select name="dipenseType" id=<%=dispenseType%>
				tabindex="1" class="medcaption">
				<option value="">select type</option>
				<option value="Bottle of (gm)">Bottle of (gm)</option>
				<option value="Bottle of (ml)">Bottle of (ml)</option>
				<option value="Each">Each</option>
				<option value="Jar of (gm)">Jar of (gm)</option>
				<option value="Kit of (Tests)">Kit of (Tests)</option>
				<option value="No">No</option>
				<option value="Pack of (No)">Pack of (No)</option>
				<option value="Reel of (Mtr)">Reel of (Mtr)</option>
				<option value="Strip of (No)">Strip of (No)</option>
				<option value="Tests">Tests</option>
				<option value="Tube of (gm)">Tube of (gm)</option>
			</select>
			<td width="10%"><input type="text" class="medcaption" name="mdq"
				id="<%=mdq%>" value="0" readonly tabindex="1" maxlength="6" /></td>

			<td width="10%"><input type="text" class="medcaption"
				name="ratePerMdq" value="0" id="<%=ratePerMdq%>" readonly
				tabindex="1" maxlength="18" /></td>


			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=BATCH_NO_TEMP %>" id="<%=batchNoTemp%>" tabindex="2"
				maxlength="10" onblur="fillBatchForGrn(<%=inc%>)" /> <input
				type="hidden" value="emptyString" class="medcaption"
				name="<%=BATCH_NO %>" tabindex="2" id="<%=batchNo%>" /></td>


			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=LOT_NO_TEMP %>" id="<%=lotNoTemp%>" tabindex="2"
				maxlength="50" onblur="fillLotForGrn(<%=inc%>)" /> <input
				type="hidden" value="emptyString1" class="medcaption"
				name="<%=LOT_NO %>" tabindex="2" id="<%=lotNo%>" /></td>

			<td width="3%"><input type="text" class="medcaption" value=""
				name="" tabindex="2" id="<%=unitRateVarTemp%>" maxlength="20"
				readonly="readonly"
				onblur="fillUnitForGrn(<%=inc%>);calculateAmountForLoanIn(<%=inc%>);"
				validate="Unit Rate,float,no" /> <input type="hidden"
				class="medcaption" value="0" name="<%=UNIT_RATE%>" tabindex="2"
				readonly="readonly" id="<%=unitRateVar%>" /></td>


			<td width="3%"><input type="text" class="smcaption" value=""
				name="" tabindex="2" readonly="readonly" id="<%=discountVarTemp%>"
				maxlength="6"
				onblur="fillDiscountForGrn(<%=inc %>);calculateAmountForLoanIn(<%=inc%>);"
				validate="Discount,float,no" /> <input type="hidden"
				class="medcaption" value="0" name="<%=DISCOUNT_PERCENTAGE%>"
				tabindex="2" id="<%=discountVar%>" /></td>

			<td width="10%"><input type="text" value="" class="smcaption"
				name="" tabindex="2" id="<%=taxVarTemp%>" readonly="readonly"
				maxlength="6"
				onblur=" fillTaxForGrn(<%=inc %>); calculateAmountForLoanIn(<%=inc%>);"
				validate="Tax,float,no" /> <input type="hidden" value="0"
				class="medcaption" name="<%=TAX_PERCENT %>" readonly="readonly"
				tabindex="2" id="<%=taxVar%>" /></td>
			</td>


			<td width="10%"><input type="hidden" value="" class="medcaption"
				name="" tabindex="2" id="<%=costPriceTemp%>" readonly="readonly"
				onblur="fillCostPriceForGrn(<%=inc %>)" /> <input type="hidden"
				value="0" class="medcaption" name="<%=COST_PRICE%>" tabindex="2"
				id="<%=costPrice%>" /> <input type="text" value=""
				class="medcaption" name="" tabindex="2" id="<%=amtVarTemp%>"
				readonly="readonly" onblur="fillAmountForGrn(<%=inc %>)" /> <input
				type="hidden" value="0" class="medcaption" name="<%=AMOUNT%>"
				tabindex="2" id="<%=amtVar%>" /></td>

			<td width="10%"><select name="<%=FREE_ITEM %>"
				id="<%=freeItem %>" tabindex="2" class="smcaption"
				onChange="calculateAmountForLoanIn(<%=inc%>);">
				<option value="n">No</option>
				<option value="y">Yes</option>
			</select></td>

			<td width="40%"><input type="text"
				name="<%=MANUFACTURING_DATE%>" id="<%=manufacturingDate%>"
				class="smcaption" MAXLENGTH="30" tabindex="2" readonly="readonly" />
			<a
				href="javascript:setdate('<%=currentDate%>',document.getElementById('<%=manufacturingDate%>'),true)"><img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender" /></a></td>


			<td width="40%"><input type="text" name="<%=EXPIRY_DATE%>"
				id="<%=expiryDate %>" class="smcaption" MAXLENGTH="30" tabindex="2"
				readonly="readonly" /> <a
				href="javascript:setdate('<%=currentDate%>',document.getElementById('<%=expiryDate %>'),true)"><img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender" /></a></td>

			<!-- 
      <td width="3%">
      <input type="button" onclick="get_value(<%=temp+inc%>)" name="Submit2" value="" class="morebutton" />      
      </td>
       -->
		</tr>
		<% } %>
	</tbody>
</table>
<br />
</div>
</div>
<div style="padding-left: 730px;"><label class="bodytextB"></font>CRV
Value</label> <input type="text" name="<%=GRN_VALUE %>" id="<%=GRN_VALUE %>"
	value="" class="textbox_size20" style="width: 85px;" MAXLENGTH="20" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
