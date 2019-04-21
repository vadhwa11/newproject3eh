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


<%@page import="java.math.BigDecimal"%><script type="text/javascript" src="/hms/jsp/js/common.js"></script>

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
	String qtyIssued = "";
	int rowVal=0;
	int issuedItemId=0;
	int issueId=0;
	int detailId=0;
	String issueNo ="";
	List<StoreItemBatchStock> masStoreBrandList= new ArrayList<StoreItemBatchStock>();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	if(map.get("masStoreBrandList")!=null){
		masStoreBrandList = (List) map.get("masStoreBrandList");
	}
	if(map.get("qtyRequested")!=null){
		qtyRequested = (""+map.get("qtyRequested"));
	}
	if(map.get("qtyIssued")!=null){
		qtyIssued = (""+map.get("qtyIssued"));
	}
	if(map.get("itemId")!=null){
		itemId = Integer.parseInt(""+map.get("itemId"));
	}

	BigDecimal rol=new BigDecimal(0);
	BigDecimal clos=new BigDecimal(0);
	int a=0;
	//

	if(map.get("rol")!=null){
		rol = new BigDecimal(""+map.get("rol"));
	}
	//
	if(map.get("clos")!=null){
		clos = new BigDecimal(""+map.get("clos"));
	}
	if(map.get("a")!=null){
		a = Integer.parseInt(""+map.get("a"));
	}
	//
	String messageForRol="";

	a=clos.compareTo(rol);
	if(clos.compareTo(rol)<0){
		messageForRol="Stock is below to ROL Level";
	}
	//
	if(map.get("rowVal")!=null){
		rowVal = Integer.parseInt(""+map.get("rowVal"));
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
	if(map.get("detailId")!=null){
		detailId = Integer.parseInt(""+map.get("detailId"));
	}
	if(map.get("issuedItemId")!=null){
		issuedItemId = Integer.parseInt(""+map.get("issuedItemId"));
	}
	String flag = "";
	if(map.get("flag") != null){
		flag = (String)map.get("flag") ;
	}
	int srNo = 0;
	if(map.get("srNo") != null){
		srNo =  Integer.parseInt(""+map.get("srNo")) ;
	}
	int indentId = 0;
	if(map.get("indentId")!=null){
		indentId = Integer.parseInt(""+map.get("indentId"));
	}
	int indentDtId = 0;
	if(map.get("indentDtId")!=null){
		indentDtId = Integer.parseInt(""+map.get("indentDtId"));
	}
	String reqDate = "";
	if(map.get("reqDate")!=null){
		reqDate = (String)map.get("reqDate");
	}
	String nomenclature = "";
	if(map.get("nomenclature")!=null){
		nomenclature = (String)map.get("nomenclature");
	}
	String date="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");
	%>
<script type="text/javascript">
	function cancelForm(){
  	 close();
   	}


</script>
<div class="titleBg">
<h2>Batch List</h2>
</div>




<form name="itemBrandForm" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(masStoreBrandList.size()!=0){
%> 
<h4><%=messageForRol %></h4>
<div class="clear"></div>
<label
	style="text-align: center; float: right; width: 800px; font-size: 18px; font-family: fantasy;">Item Name : <%=nomenclature%> and
Requested Qty: <%=qtyRequested %></label>
<div class="clear"></div>
<input type="hidden" id="reqQty"
	name="<%=RequestConstants.QTY_IN_REQUEST %>"  value="<%=qtyRequested %>"/>
<input type="hidden" id="issueQty" name="issueQty"  value="<%=qtyIssued %>"/>
	<input
	type="hidden" name="<%=RequestConstants.REQUEST_TYPE %>" value="" /> <input
	type="hidden" name="<%=RequestConstants.ISSUE_TYPE %>" value="" /> <input
	type="hidden" name="<%=RequestConstants.DOC_TYPE %>" value="" /> <input
	type="hidden" name="<%=RequestConstants.ISSUE_NO %>" id="issueNo"
	value="<%=issueNo %>" /> <input type="hidden"
	name="<%=RequestConstants.ISSUE_DATE %>" value="" id="issueDate"/> <input
	type="hidden" name="<%=RequestConstants.DEPARTMENT_ID %>" value="" />
	<input type="hidden" name="<%=RequestConstants.DEPARTMENT_ID_TEMP %>" id="departmentIdTemp" value="" />
	<input type="hidden" name="<%=RequestConstants.DEPARTMENT_INDENT_ID %>" value="" />

	<input type="hidden" name="<%=RequestConstants.REQUEST_NO %>" id="requestNo" value="<%=indentId %>"/>

	<input type="hidden" name="<%=RequestConstants.REQUEST_DATE %>" value="<%=reqDate %>" id="requestDate"/>
	<input type="hidden" name="<%=RequestConstants.REQUEST_BY %>" value="" id="requestBy"/>
	<input type="hidden" name="<%=RequestConstants.APPROVED_BY %>" value="" id="approvedBy"/>
	<input type="hidden" name="<%=RequestConstants.ISSUED_BY %>" value="" id="issuedBy"/>
	<input type="hidden" name="<%=RequestConstants.DOC_NO %>" value="12121" />
	<input type="hidden" name="rowVal" id="rowVal" value="<%=rowVal%>" />
	<input type="hidden" name="srNo" value="<%=srNo%>" />

<script type="text/javascript">

document.getElementById('issueNo').value = window.opener.document.getElementById('issueNo').value;
document.getElementById('issueDate').value = window.opener.document.getElementById('issueDate').value;
document.getElementById('departmentIdTemp').value = window.opener.document.getElementById('departmentIdTemp').value;
document.getElementById('requestBy').value = window.opener.document.getElementById('requestBy').value;
//document.getElementById('requestDate').value = window.opener.document.getElementById('requestDate').value;
document.getElementById('approvedBy').value = window.opener.document.getElementById('approvedBy').value;
document.getElementById('issuedBy').value = window.opener.document.getElementById('issuedBy').value;

</script>

<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>

		<tr>

			<th>Batch No</th>
			<th>Unit</th>
			<th>DOM</th>
			<th>DOE</th>
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
	  int counter=0;
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
		<input type="hidden" readonly="readonly" id="bbatch<%=inc%>"
				value="<%=storeItem.getBatchNo() %>" />
			<td width="10%"><input type="text" readonly="readonly"
				value="<%=storeItem.getBatchNo() %>" /> <input type="hidden"
				name="<%=RequestConstants.BATCH_NO+""+counter %>"
				value="<%=storeItem.getBatchNo() %>" />
				<input type="hidden"
				name="<%=RequestConstants.BATCH_ID+""+counter %>" id="batchId<%=inc%>"
				value="<%=storeItem.getId() %>" />
				</td>
			<td width="13%"><input type="text"
				name="<%=RequestConstants.AU %>" size="5" readonly="readonly"
				value="<%=storeItem.getItem().getItemConversion().getPurchaseUnit().getUnitName()%>" />
			</td>
			
			<%
  	 	//SimpleDateFormat dom = new SimpleDateFormat("yyyy-MM-dd");
	 	//SimpleDateFormat manufactDate = new  SimpleDateFormat("dd/MM/yyyy");
	 	//String manufatureDate=dom.format(manufactDate.parse(""+storeItem.getManufactureDate())); %>
			<td width="13%"><input type="text" readonly="readonly"
				name="<%=RequestConstants.MANUFACTURING_DATE%>" id="manufactureDate<%=inc%>" value="<%=storeItem.getManufactureDate()!= null?HMSUtil.convertDateToStringWithoutTime(storeItem.getManufactureDate()):"" %>" />
			</td>
			
			<td width="13%"><input type="text" readonly="readonly"
				name="<%=RequestConstants.EXPIRY_DATE%>" id="expiryDate<%=inc%>" value="<%=storeItem.getExpiryDate() != null?HMSUtil.convertDateToStringWithoutTime(storeItem.getExpiryDate()):"" %>" />
			</td>
			<td width="13%"><input
				value="<%=""+storeItem.getClosingStock().intValue()%>" id="<%=stockIn%>"
				readonly="readonly" /> <input type="hidden"
				value="<%=""+storeItem.getCostPrice()%>" name="costPrice<%=counter %>"
				id="costPrice" /></td>

			<td width="13%"><input type="text" tabindex="1"
				name="<%=RequestConstants.QTY_ISSUED_TEMP+""+counter%>"
				validate='Issued Quantity ,floatWithoutSpaces,no' class="medcaption"
				id="<%=issuedQtyTemp %>"
				onblur="fillQtyIssuedForIssueCiv('<%=inc %>');putFocus('<%=inc %>');valueChecked('<%=inc%>')" />
			<input type="hidden" name="<%=RequestConstants.QTY_ISSUED+""+counter%>"
				value="0" id="<%=issuedQty %>" /></td>
			<td width="13%"><input type="text"
				name="<%=RequestConstants.REMARKS_TEMP%>" id="<%=remarksTemp %>"
				validate='Remarks,String,no'
				onchange="fillRemarksForIssueCiv('<%=inc %>')" /> <input
				type="hidden" name="<%=RequestConstants.REMARKS+""+counter%>"
				value="" id="<%=remarks %>" /></td>
				<input type="hidden" name="indentDtId" id="indentDtId<%=counter%>" value="<%=indentDtId%>" />

			</tr>
			<% inc++;
			counter++;}
  	 }catch(Exception w){w.printStackTrace();}%>

	</tbody>
	<input type="hidden" name="counter" value="<%=counter%>" id="counter" />
</table>

<script type="text/javascript">


  function putFocus(counter)
  {df

  	document.getElementById("<%= issuedQtyTemp%>").focus();
  }
  function valueChecked(counter)
  {

  	  var dValidate=document.getElementById("issuedQtyTemp"+counter).value;
	  if(dValidate!="")
	  {
		if(isDigits(dValidate)==false)
	  	{
		  document.getElementById("issuedQtyTemp"+counter).value="";
	  //  document.getElementById("issuedQtyTemp"+counter).focus();
	      return false;
	  	}
	  }
  }
  function isDigits(argvalue) {
	    argvalue = argvalue.toString();
	    var b=false;
	    var validChars = "0123456789";
	    var startFrom = 0;
	    if (argvalue.substring(0, 2) == "0x") {
	       validChars = "0123456789abcdefABCDEF";
	       startFrom = 2;
	    } else if (argvalue.charAt(0) == "0") {
	       validChars = "01234567";
	       startFrom = 1;
	    }
	    for (var n = 0; n < argvalue.length; n++) {
	        if (validChars.indexOf(argvalue.substring(n, n+1)) == -1)
		        b =false;
	    }
	    if(b ==false)
	    {
	    	alert('Entered Value Should be Only Numeric !!!');
	    	   return false;
		}
	    b = true;
	  return true;
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
 </script>
<div id="testDiv">

</div>
<input type="hidden" id="totalQty" /><%-- <input id="save" property="save"
	type="button" name="save" value="Save" class="button"
	onclick="if(chkQty(<%=inc%>,<%=rowVal%>) && setTotalQty(<%=inc%>,<%=rowVal%>)){submitForm('itemBrandForm','/hms/hms/stores?method=addBrandDetails');cancelForm();}" />
<input id="save" property="save"
	type="button" name="save" value="Save" class="button"
	onclick="if(chkQty(<%=inc%>,<%=rowVal%>) && setTotalQty(<%=inc%>,<%=rowVal%>)){submitForm('itemBrandForm','/hms/hms/stores?method=addBrandItemIssueDetails');}" />
	--%><%--addBatchWiseItemForIssue() ;
	addBrandItemIssueDetails
	addBrandIssueDetails

	 --%>

	 <input type="button" name="close" value="Ok" class="button" onclick="setTotalQtyInParent();"/>
<%}else{ %>
<h4>Records not Found</h4>
<div class="clear"></div>
<%} %> <input type="button" name="cancel" id="addbutton" value="Cancel"
	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 /></form>

	<script type="text/javascript">
function addBatchWiseItemForIssue(){
	alert("<---addBatchWiseItemForIssue-->");

	var addBatchItemCounter=0;
	addBatchItemCounter=window.opener.document.getElementById('addBatchItemCounter').value;
	if(addBatchItemCounter==""){
		addBatchItemCounter=1;
	}else{
		addBatchItemCounter=parseInt(addBatchItemCounter)+1;
	}
	window.opener.document.getElementById('addBatchItemCounter').value=addBatchItemCounter;

	var tbl = window.opener.document.getElementById('batchWiseItem');
	var batchRow=tbl.rows.length;
	var lastRow=tbl.rows.length;
	var row = tbl.insertRow(lastRow);

	batchRow=addBatchItemCounter;
	var cell0 = row.insertCell(0);
	var kycType1="";
	if(kycType1!=""){
		var kycTypeTemp='<input type=text name=kycType1'+batchRow+' id=kycType1'+batchRow+' value="'+kycType1+'" style="width:70px;" align="middle" readonly="readonly"/>';
		cell0.innerHTML=kycTypeTemp;
	}else{
		var kycTypeTemp='<input type=text name=kycType1'+batchRow+' id=kycType1'+batchRow+' style="width:70px;" align="middle" readonly="readonly"/>';
		cell0.innerHTML=kycTypeTemp;
	}

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
	var ss="";
	var inSum=0;
	var totalRows = parseInt(document.getElementById('counter').value);
	var rowVal = parseInt(document.getElementById('rowVal').value);
	//var issueQty = parseInt(document.getElementById('issueQty').value);
 		for(var index = 1; index <= totalRows; index++ ){
 			var qtyIssuedObj = eval(document.getElementById('issuedQty'+index));
				sum = parseFloat(sum) + parseInt(qtyIssuedObj.value);
 				if(parseInt(document.getElementById('issuedQty'+index).value)!="0" ){
				qq=qq+','+parseInt(document.getElementById('issuedQty'+index).value)
								+'@'+
								document.getElementById('bbatch'+index).value
								+'@'+
								document.getElementById('manufactureDate'+index).value
								+'@'+
								document.getElementById('expiryDate'+index).value
								+'@'+
								document.getElementById('batchId'+index).value;
 				}
		}
 		//alert(qq);
		if(qq == ""){
			window.opener.document.getElementById('issueQtyAndBatch<%=rowVal%>').value = "blank";
		} else{
			window.opener.document.getElementById('issueQtyAndBatch<%=rowVal%>').value = qq.substring(1,qq.length);
		}

		var totalQtyIssued = eval(window.opener.document.getElementById('quantityToIssueOverAll<%=rowVal%>'));
		if(sum == 0){
			totalQtyIssued.value = '0';
		}else{
			totalQtyIssued.value = sum;
		}
		if(parseInt(totalQtyIssued.value)>parseInt(document.getElementById("reqQty").value)){
			alert('Qty Issued Value Should be less than or Equal to Requested Qty');
		 return false;
		}
 		window.opener.document.getElementById('qtyIssued<%=rowVal%>').value=totalQtyIssued.value;
		close();
 		return true;
  	}
</script>