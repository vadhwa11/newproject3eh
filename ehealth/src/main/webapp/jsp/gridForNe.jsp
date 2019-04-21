
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<style>
#contentspace label {
	text-align: right;
	padding-right: 0px;
	width: 95px;
	float: left;
	height: 9px;
}
</style>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script> <script>
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
</script> <script type="text/javascript" language="javascript">
var itemsArray1=new Array();

 var brandArray = new Array();
function fillValuesInGrn(inc)
  {
  		//var batchNo="batchNo";
  	 	var quanRec = "quanRec";
    	var taxVar = "taxVar";
    	var amtVar = "amtVar";
    	var unitRateVar = "unitRateVar";
    	var discountVar = "discountVar";
    	//var batchNoTemp="batchNoTemp";
    	var quanRecTemp = "quanRecTemp";
    	var taxVarTemp = "taxVarTemp";
    	var unitRateVarTemp = "unitRateVarTemp";
    	var discountVarTemp = "discountVarTemp";
    	var amtVarTemp = "amtVarTemp";
    	//var lotNo ="lotNo";
    	//var lotNoTemp="lotNoTemp";
    	
    	//document.getElementById(batchNo+inc).value=document.getElementById(batchNoTemp+inc).value
    	//document.getElementById(lotNo+inc).value=document.getElementById(lotNoTemp+inc).value
    	document.getElementById(quanRec+inc).value=document.getElementById(quanRecTemp+inc).value
    	document.getElementById(taxVar+inc).value=document.getElementById(taxVarTemp+inc).value
    	document.getElementById(unitRateVar+inc).value=document.getElementById(unitRateVarTemp+inc).value
    	document.getElementById(discountVar+inc).value=document.getElementById(discountVarTemp+inc).value
    	document.getElementById(amtVar+inc).value=document.getElementById(amtVarTemp+inc).value
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

function get_value(rowNo)
{
 var url="/hms/hms/neStores?method=showInfoOfGrnJsp&rowNo="+rowNo;
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
</script> <% 
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
			%> <script>
 var nameArray=new Array();
 var itemsArray1=new Array();
</script>



<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="98%" colspan="7" id="grnDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="gridsmlabel">S.No.</label></td>
			<td width="8%"><label valign="left" class="smalllabel">PVMS/NIV
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="9%"><label valign="left" class="smalllabel">A/U</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Serial
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Accepted
			Model</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Lot
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Quan
			Rec</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Unit
			Rate</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Disc(%)</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Tax(%)</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Amt
			Value</label></td>

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
    	String acceptedModel="acceptedModel";
    	String acceptedModelTemp="acceptedModelTemp";
    	String shelfLife="shelfLife";
    	String installationDate="installationDate";
    	String amcStartDate ="amcStartDate";
    	String amcEndDate = "amcEndDate";
    	String warrantyDate = "warrantyDate";
    	String costPrice ="costPrice";
    	String costPriceTemp = "costPriceTemp";
    	
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
    	String acceptedModel2="acceptedModel";
    	String acceptedModelTemp2="acceptedModelTemp";
    	String shelfLife2 ="shelfLife";
    	String installationDate2 = "installationDate";
    	String amcStartDate2="amcStartDate";
    	String amcEndDate2 = "amcEndDate";
    	String warrantyDate2 = "warrantyDate";
    	String costPrice2="costPrice";
    	String costPriceTemp2="costPriceTemp";
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=10;inc++){
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
     		acceptedModel=acceptedModel2+(""+inc);
     		acceptedModelTemp=acceptedModelTemp2+(""+inc);
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
     		installationDate=installationDate2+(""+inc);
     		amcStartDate=amcStartDate2+(""+inc);
     		amcEndDate = amcEndDate2+(""+inc);
     		warrantyDate= warrantyDate2+(""+inc);
     		costPrice =costPrice2+(""+inc);
     		costPriceTemp =costPriceTemp2+(""+inc);
     		
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
				onblur="if(fillSrNo('<%=inc %>')){checkForGrn(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" tabindex="2" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','neStores?method=getItemListForGrnByAutocomplete',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentCombo').value+'&sourceOfSupply= '+document.getElementById('sourceCombo').value});
		</script></td>


			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>"
				validate="A/U ,String,no" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=BATCH_NO_TEMP %>" id="<%=batchNoTemp%>" tabindex="2"
				maxlength="10"
				onblur="if(checkForSerialNo(this.value,<%=inc%>)){enterQuantityForSerial(<%=inc %>);fillBatchForGrn(<%=inc%>)}" />
			<input type="hidden" value="0" class="medcaption"
				name="<%=BATCH_NO %>" tabindex="2" id="<%=batchNo%>" maxlength="10" />
			</td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=ACCEPTED_MODEL_TEMP%>" id="<%=acceptedModelTemp%>"
				tabindex="2" onblur="fillModelForGrn(<%=inc%>)" maxlength="40" /> <input
				type="hidden" value="0" class="medcaption"
				name="<%=ACCEPTED_MODEL %>" tabindex="2" id="<%=acceptedModel%>"
				maxlength="40" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=LOT_NO_TEMP %>" id="<%=lotNoTemp%>" tabindex="2"
				onblur="fillLotForGrn(<%=inc%>)" maxlength="50" /> <input
				type="hidden" value="0" class="medcaption" name="<%=LOT_NO %>"
				tabindex="2" id="<%=lotNo%>" maxlength="50" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="" id="<%=quanRecTemp%>" tabindex="2"
				validate="Quantity,float,no" onblur="fillQuantityForGrn(<%=inc %>)"
				maxlength="15" /> <input type="hidden" value="0" class="medcaption"
				name="<%=QUANTITY_RECEIVED %>" tabindex="2" id="<%=quanRec%>"
				maxlength="15" /></td>

			<td width="3%"><input type="text" class="medcaption" value=""
				name="" tabindex="2" id="<%=unitRateVarTemp%>"
				onblur="fillUnitForGrn(<%=inc%>);calculateAmountInGrn(<%=inc%>);"
				validate="Unit Rate,float,no" maxlength="12" /> <input
				type="hidden" class="medcaption" value="0" name="<%=UNIT_RATE%>"
				tabindex="2" id="<%=unitRateVar%>" maxlength="12" /></td>

			<td width="3%"><input type="text" class="medcaption" value=""
				name="" tabindex="2" id="<%=discountVarTemp%>"
				validate="Discount,float,no"
				onblur="fillDiscountForGrn(<%=inc %>);calculateAmountInGrn(<%=inc%>);"
				maxlength="15" /> <input type="hidden" class="medcaption" value="0"
				name="<%=DISCOUNT_PERCENTAGE%>" tabindex="2" id="<%=discountVar%>"
				maxlength="15" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="" tabindex="2" id="<%=taxVarTemp%>" validate="Tax,float,no"
				onblur="fillTaxForGrn(<%=inc %>);calculateAmountInGrn(<%=inc%>);"
				maxlength="15" /> <input type="hidden" value="0" class="medcaption"
				name="<%=TAX_PERCENT %>" tabindex="2" id="<%=taxVar%>"
				maxlength="15" /></td>

			<td width="10%"><input type="hidden" value="" class="medcaption"
				name="" tabindex="2" id="<%=costPriceTemp%>" readonly="readonly"
				onblur="fillCostPriceForGrn(<%=inc %>)" /> <input type="hidden"
				value="0" class="medcaption" name="<%=COST_PRICE%>" tabindex="2"
				id="<%=costPrice%>" /> <input type="text" value=""
				class="medcaption" name="" tabindex="2" id="<%=amtVarTemp%>"
				readonly="readonly" onblur="fillAmountForGrn(<%=inc %>)"
				maxlength="15" /> <input type="hidden" value="0" class="medcaption"
				name="<%=AMOUNT%>" tabindex="2" id="<%=amtVar%>" maxlength="15" />
			<input type="hidden" value="0" name="<%=FREE_QTY %>"
				id="<%= freeQty %>" /> <input type="hidden" value="0"
				name="<%=MANUFACTURER_ID %>" id="<%=manufacturerId %>" /> <input
				type="hidden" value="0" name="<%=FREE_ITEM %>" id="<%=freeItem %>" />
			<input type="hidden" value="0" name="<%=INSTALLATION_DATE %>"
				id="<%=installationDate %>" /> <input type="hidden" value="0"
				name="<%=AMC_START_DATE %>" id="<%=amcStartDate %>" /> <input
				type="hidden" value="0" name="<%=AMC_END_DATE %>"
				id="<%=amcEndDate %>" /> <input type="hidden" value="0"
				name="<%=WARRANTY_DATE %>" id="<%=warrantyDate %>" /></td>

			<td width="3%"><input type="button"
				onclick="get_value(<%=temp+inc%>);" name="Submit2" value=""
				class="morebutton" /></td>
		</tr>
		<%
     	 }   %>


	</tbody>
</table>
</br>

</fieldset>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
