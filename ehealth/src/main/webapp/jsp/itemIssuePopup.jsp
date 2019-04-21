<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemBrandWindow.jsp
 * Purpose of the JSP -  This is for Item Brand Window.
 * @author  Vivek
 * @author  Deepti
 * Create Date: 21st Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<link rel="stylesheet" href="/hms/jsp/css/style.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%
	Map map = new HashMap();
	int itemId=0;
	String qtyRequested="";
	int rowVal=0;
	int issuedItemId=0;
	int issueId=0;
	int detailId=0;
	String issueNo ="";
	String nomenclature="";
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	if(map.get("masStoreBrandList")!=null){
		masStoreBrandList = (List) map.get("masStoreBrandList");
	}

	if(map.get("itemId")!=null){
		itemId = Integer.parseInt(""+map.get("itemId"));
	}
	if(map.get("nomenclature")!=null){
		nomenclature = (String)(""+map.get("nomenclature"));

	}

	if(map.get("rowVal")!=null){
		rowVal = Integer.parseInt(""+map.get("rowVal"));

	}
	if(map.get("issueNo")!=null){
		issueNo = (""+map.get("issueNo"));

	}
	if(map.get("issueId")!=null){
		issueId = Integer.parseInt(""+map.get("issueId"));

	}
	if(map.get("issuedItemId")!=null){
		issuedItemId = Integer.parseInt(""+map.get("issuedItemId"));

	}
	if(map.get("detailId")!=null){
		detailId = Integer.parseInt(""+map.get("detailId"));

	}
	String flag = "";
	if(map.get("flag") != null){
		flag = (String)map.get("flag") ;
	}
	if(map.get("qtyRequested")!=null){
		qtyRequested = (""+map.get("qtyRequested"));
	}
	String date="";
	String userName = "";
	String time= "";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	date = (String)utilMap.get("currentDate");
	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	%>

<script type="text/javascript">

	function cancelForm(){
  	 close();
   	}


</script>
<title><%=nomenclature %></title>
<div class="titleBg">
<h2>Batch List</h2>
</div>




<form name="itemIssuePopUp" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(masStoreBrandList.size()!=0){
%>
<label style="text-align: center; float: right; width: 600px; font-size: 16px; font-family: fantasy;" >Item :- <%=nomenclature %> </label>
<label
	style="text-align: center; float: right; width: 600px; font-size: 16px; font-family: fantasy;">

	 Qty. Requested: <%=qtyRequested %></label>
<div class="clear"></div>
<input type="hidden" id="reqQty"
	name="<%=RequestConstants.QTY_IN_REQUEST %>" value="<%=qtyRequested %>" /><input
	type="hidden" name="<%=RequestConstants.REQUEST_NO %>" id="requestNo" value="" /> <input
		type="hidden" name="<%=RequestConstants.ISSUE_NO %>" id="issueNo" value="" />
	<input type="hidden" id="issueDate" name="<%=ISSUE_DATE %>" value="" /> <input
	type="hidden" name="<%=RequestConstants.DEPARTMENT_ID %>" value="" />
<input type="hidden" name="<%=RequestConstants.DEPARTMENT_ID_TEMP %>" id="departmentIdTemp"
	value="" />  <input
	type="hidden" name="<%=RequestConstants.APPROVED_BY %>" id="approvedBy" value="" /> <input
	type="hidden" name="<%=RequestConstants.ISSUED_BY %>" value="" id="issuedBy" /> <input
	type="hidden" name="<%=RequestConstants.REQUEST_BY %>" value="" id="requestBy"/> <input
	type="hidden" name="<%=RequestConstants.SR_NO %>" value="<%=rowVal%>" />
<input type="hidden" id="requestDate"
	name="<%=RequestConstants.REQUEST_DATE %>" value="" />

<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
 		<tr>
 			<th>Lot No</th>
			<th>UOM</th>
			<th>Exp Date</th>
			<th>Stock In</th>
			<th>Qty Issued</th>
			<th>Remarks</th>
 		</tr>
 	</thead>
 	<tbody>
		<input type="hidden" name="<%=RequestConstants.DETAIL_ID %>"
			value="<%=detailId%>" />
		<input type="hidden" name="<%=RequestConstants.ITEM_ID %>"
			value="<%=itemId%>" />
		<input type="hidden" name="<%=RequestConstants.ISSUED_ITEM %>"
			value="<%=issuedItemId%>" />
		<input type="hidden" name="<%=RequestConstants.ISSUE_ID %>"
			value="<%=issueId%>" />
		<%
  String issuedQty="issuedQty";
  String issuedQty2="issuedQty";

  String issuedQtyTemp="issuedQtyTemp";
  String issuedQtyTemp2="issuedQtyTemp";

  String remarks="remarks";
  String remarks2="remarks";

  String remarksTemp="remarksTemp";
  String remarksTemp2="remarksTemp";

  String stockIn="stockIn";
  String stockIn2="stockIn";

  String costPrice="costPrice";
  String costPrice2="costPrice";
	int inc=1;
  try{
	  for (Iterator iterator = masStoreBrandList.iterator(); iterator.hasNext();) {
	  issuedQty=issuedQty2+(""+inc);
	  issuedQtyTemp=issuedQtyTemp2+(""+inc);
	  remarks=remarks2+(""+inc);
	  remarksTemp=remarksTemp2+(""+inc);
	  stockIn=stockIn2+(""+inc);
	  costPrice=costPrice2+(""+inc);
	  StoreItemBatchStock storeItem = (StoreItemBatchStock) iterator.next();

  %>
		<tr>
			<td width="10%"><input type="text" readonly="readonly" id="bbatch<%=inc%>"
				value="<%=storeItem.getBatchNo() %>" />
				<input type="hidden"
				name="<%=RequestConstants.BATCH_NO %>"
				value="<%=storeItem.getBatchNo() %>" /></td>
			<td width="13%"><input type="text"
				name="<%=RequestConstants.AU %>" size="5" readonly="readonly"
				value="<%=storeItem.getItem().getItemConversion().getPurchaseUnit().getUnitName()%>" />
			</td>
			<%String date4MySQL= "";
			if(storeItem.getExpiryDate() != null){
		  	 	SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
			 	SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
			 	 date4MySQL=formatterOut.format(formatterIn.parse(""+storeItem.getExpiryDate())); }%>

			<td width="13%"><input type="text" readonly="readonly"
				name="<%=RequestConstants.EXPIRY_DATE %>" value="<%=date4MySQL %>" />
			</td>
			<%
			BigDecimal balanceQty=new BigDecimal(0.0);
			if(storeItem.getBlockedQty()!=null && storeItem.getBlockedQty().intValue()>0)
				balanceQty=storeItem.getClosingStock().subtract(storeItem.getBlockedQty());
			else
				balanceQty=storeItem.getClosingStock();
			%>
			<td width="13%"><input
				value="<%=""+balanceQty%>" id="<%=stockIn%>"
				readonly="readonly" /> <input type="hidden"
				value="<%=""+storeItem.getCostPrice()%>" name="costPrice"
				id="costPrice" /></td>

			<td width="13%"><input type="text" tabindex="1"
				name="<%=RequestConstants.QTY_ISSUED_TEMP%>"
				validate='Issued Quantity ,floatWithoutSpaces,no' class="medcaption"
				id="<%=issuedQtyTemp %>"

				onblur="fillQtyIssuedForIssueCiv('<%=inc %>')" />
			<input type="hidden" name="<%=RequestConstants.QTY_ISSUED%>"
				value="0" id="<%=issuedQty %>" /></td>
			<td width="13%"><input type="text"
				name="<%=RequestConstants.REMARKS_TEMP%>" id="<%=remarksTemp %>"
				validate='Remarks,String,no'
				onchange="fillRemarksForIssueCiv('<%=inc %>')" /> <input
				type="hidden" name="<%=RequestConstants.REMARKS%>"
				value="" id="<%=remarks %>" /></td>
			</tr>
			<% inc++;}
  	 }catch(Exception w){w.printStackTrace();}%>

	</tbody>
</table>

</div>
<div id="testDiv">

</div>
 <input type="hidden" name="counter" id="counter" value="<%=inc %>"/>
<input type="hidden" id="totalQty" /> <input id="save" property="save"
	type="button" name="save" value="Save1" class="button"
	onclick="if(chkQty(<%=inc%>,<%=rowVal%>) && setTotalQty(<%=inc%>,<%=rowVal%>)){submitProtoAjax('itemIssuePopUp','/hms/hms/stores?method=addIssueWithoutIndentDetails');}" />
	<input type="button" name="close" value="Ok" class="button" onclick="setTotalQtyInParent();"/>

<%}else{ %>
<h4>Records not Found</h4>
<div class="clear"></div>
<%} %> <input type="button" name="cancel" id="addbutton" value="Cancel"
	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />
	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

	<script type="text/javascript">
	document.getElementById('issueNo').value = window.opener.document.getElementById('issueNo').value;
	document.getElementById('issueDate').value = window.opener.document.getElementById('issueDate').value;
	document.getElementById('departmentIdTemp').value = window.opener.document.getElementById('departmentIdTemp').value;
	document.getElementById('requestBy').value = window.opener.document.getElementById('requestBy').value;
	document.getElementById('requestDate').value = window.opener.document.getElementById('requestDate').value;
	document.getElementById('approvedBy').value = window.opener.document.getElementById('approvedBy').value;
	document.getElementById('issuedBy').value = window.opener.document.getElementById('issuedBy').value;
	document.getElementById('requestNo').value = window.opener.document.getElementById('requestNo').value;


function submitProtoAjaxForIssueBatchToDept(formName,action,issueObj){
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }

    xmlHttp.onreadystatechange=function()
    {
    var issueId = 0;
  //		var issueObj = window.opener.document.getElementById('issueId');
      if(xmlHttp.readyState==4){

      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	if(items.childNodes.length!=0){

      	for (loop = 0; loop < items.childNodes.length; loop++) {

	   	 var item = items.childNodes[loop];

	   	 var issueId = item.getElementsByTagName("issueId")[0];
	   	 issueObj.value = issueId.childNodes[0].nodeValue;
	   	  }
	   	  }

      }
    }
    var url=action+"&"+getNameAndData('itemIssuePopUp');
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }
function chkQty(noOfRows,rowVal){

   	var totalQty=0;

    if(noOfRows > 2){
	    for(j=1; j < parseInt(noOfRows) ; j++){
	   	   if(document.getElementById('issuedQty'+j) != null){
	   	     if(document.getElementById('issuedQty'+j).value == 0){
	               var flag = 1;
	   	           break;
	   	      }

     	    }
	  	}
	  	if(flag==1){
	         if(confirm("Stock is availabel on Other batches. Do you want to continue....")){
	             return true;
	          }
	          else{
	            return false;
	          }
	    }

	 }
	 return true;

}


function setTotalQtyInParent(){
  	var sum = 0;
  	var totalQtyInHand = 0;
  	var totalAmt = 0;
  	var saleTax = 0;
	var saleTaxAmt = 0;
	var netSaleTax = 0;
	var uom ='';
	var qq="";
	var inSum=0;
	var totalRows = parseInt(document.getElementById('counter').value);

		for(var index = 1; index < totalRows; index++ ){
			var qtyIssuedObj = eval(document.getElementById('issuedQtyTemp'+index));
			var stockQtyInHandObj = eval(document.getElementById('stockQtyInHand'+index));
			//if(qtyIssuedObj.value != "") {
			//alert("index=="+index)
				//var amtObj = eval(document.getElementById('amt'+index));
		//	if(amtObj.value != ""){
				//alert("amtObjamtObj=="+amtObj);
				sum = parseFloat(sum) + parseFloat(qtyIssuedObj.value);
				//totalAmt = parseFloat(totalAmt)+parseFloat(amtObj.value);
				//alert("totalAmt=="+totalAmt);
				//saleTax = document.getElementById('salesTax'+index).value;
				//saleTaxAmt = ((parseFloat(amtObj.value)*parseFloat(saleTax))/parseFloat(100))
				//netSaleTax =parseFloat(netSaleTax)+parseFloat(saleTaxAmt);

				//window.opener.document.getElementById('itemCode<%=rowVal%>').value = document.getElementById('itemCode'+index).value;
				//This string contains issue Qty, batch no., amt,tax,total amt saparated though commas
				qq=qq+','+document.getElementById('issuedQtyTemp'+index).value
								+'@'+
								document.getElementById('bbatch'+index).value;
								//+'@'+
								//parseFloat(amtObj.value).toFixed(2) + '@' + saleTaxAmt.toFixed(2)
								//+ '@' +
								//(parseFloat(amtObj.value) + parseFloat(saleTaxAmt)).toFixed(2);

		//	}
		//}

			//totalQtyInHand = totalQtyInHand + parseInt(stockQtyInHandObj.value);
			//else {
			//	sum=sum;
			//	totalAmt = totalAmt;
			//}

		}
		if(qq == ""){
			window.opener.document.getElementById('issueQtyAndBatch<%=rowVal%>').value = "blank";
		} else{
			window.opener.document.getElementById('issueQtyAndBatch<%=rowVal%>').value = qq.substring(1,qq.length);
		}

		var totalQtyIssued = eval(window.opener.document.getElementById('quantityToIssueOverAll<%=rowVal%>'));
		if(sum == 0){
			totalQtyIssued.value = '---';
		}else{
			totalQtyIssued.value = sum;
		}


		return true;
  	}

function setTotalBillAmountInParent(){
	var totalBillAmt = 0;
	var amt = 0;
	var totalNetAmt = 0;
	var netAmt = 0;
	var saleTax = 0;
	var saleTaxAmt = 0;
	var netSaleTax = 0;

	var uom='';
	var count = window.opener.document.getElementById('hiddenValueCharge').value;
	//alert("sfsdfs"+count);
	for(var i=1;i<=count;i++){
		if(window.opener.document.getElementById('amount'+i) !=null){
			if(window.opener.document.getElementById('amount'+i).value != ""){
				amt = window.opener.document.getElementById('amount'+i).value;
				//alert("amount"+amt);
				totalBillAmt = parseFloat(totalBillAmt)+parseFloat(amt);
			}

			if(window.opener.document.getElementById('salesTaxAmount'+i) != null
				&& window.opener.document.getElementById('salesTaxAmount'+i).value != ""){
				saleTaxAmt = window.opener.document.getElementById('salesTaxAmount'+i).value
				netSaleTax =parseFloat(netSaleTax)+parseFloat(saleTaxAmt);
			}
			if(window.opener.document.getElementById('netamount'+i).value != ""){
				netAmt = window.opener.document.getElementById('netamount'+i).value
				totalNetAmt = parseFloat(totalNetAmt)+parseFloat(netAmt);
			}
		}
	}
	///alert(totalBillAmt)
	window.opener.document.getElementById('totalAmtAllItemsWithoutTax').value = parseFloat(totalBillAmt).toFixed(2);
	//alert(parseFloat(totalBillAmt).toFixed(2));
	window.opener.document.getElementById('totalSalesTaxAllItems').value = parseFloat(netSaleTax).toFixed(2);
	window.opener.document.getElementById('totalAmtAllItemsIncludingTax').value = parseFloat(totalNetAmt).toFixed(2);
	window.opener.document.getElementById('totalPayableAmtAllItemsIncludingTax').value = Math.round(parseFloat(totalNetAmt));

   	var dotIndex=0
   	var k=0;

   	dotIndex=(totalNetAmt.toString()).indexOf(".");
   	k=(totalNetAmt.toString()).length;
   	if(dotIndex != '-1'){
   		window.opener.document.getElementById('roundAmtPs').value=totalNetAmt.toString().substring(dotIndex,k);
   		window.opener.document.getElementById('amtInRs').value=totalNetAmt.toString().substring(0,(dotIndex));
   	} else {
   		window.opener.document.getElementById('roundAmtPs').value='0';
   		window.opener.document.getElementById('amtInRs').value=totalNetAmt.toString().substring(0,k);
   	}

	return true;
}


	</script>

	</form>


