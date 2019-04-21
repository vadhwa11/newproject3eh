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
<%@page import="java.util.*,java.math.BigDecimal,jkt.hms.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>


<script type="text/javascript" src="/hms/jsp/js/common.js"></script>


<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%
	Map map = new HashMap();
	int itemId=0;
	int rowVal=0;
	int deptId=0;
	int qtyRequested=0; 
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	List listOfItemsInStock= new ArrayList();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	
	if(map.get("listOfItemsInStock")!=null){
		listOfItemsInStock = (List)map.get("listOfItemsInStock");
	
	}
	if(map.get("deptId")!=null){
		deptId = (Integer)map.get("deptId");
	
	}
	if(map.get("rowVal")!=null){
		rowVal = (Integer)map.get("rowVal");
	
	}
	
	%>
<script type="text/javascript">
	function cancelForm(){
  	 close();
   	}


</script>
<div id="contentspace">

<form name="stockDetailsForm" method="post"><br />
<br />
<br />
<input type="hidden" name="itemId" id="itemId" value="" /> <input
	type="hidden" name="date" id="date" value="" /> <input type="hidden"
	name="time" id="time" value="" /> <input type="hidden"
	name="<%=RETURN_NO %>" id="returnNo" value="" /> <input type="hidden"
	name="<%=RETURN_DATE %>" id="returnDate" value="" /> <input
	type="hidden" name="<%=REFERENCE_NO %>" id="referenceNo" value="" /> <input
	type="hidden" name="<%=FROM_WARD %>" id="fromWard" value=" " /> <input
	type="hidden" name="<%=TO_WARD %>" id="toWard" value=" " /> <input
	type="hidden" name="<%=RECEIVED_BY_ID %>" id="receiveBy" value="" /> <input
	type="hidden" name="<%=RETURN_BY_ID %>" id="returnBy" value="" /> <input
	type="hidden" name="<%=REASON %>" id="reason" value="" /> <input
	type="hidden" name="<%=REMARKS %>" id="remarks" value="" /> <input
	type="hidden" name="storeFyDocumentNoId" id="storeFyDocumentNoId"
	value="" /> <input type="hidden" name="deptId" id="deptId" value="" />
</td>
<br />
<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>

		<tr>
			<%
      int i=0;
		Iterator itr= listOfItemsInStock.iterator();
		if(listOfItemsInStock.size() > 0){
      
      %>
			<td width="5%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="10%"><label valign="left" class="smalllabel">Batch
			No</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Exp
			Date</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Cost
			Price</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Stock
			Quantity</label></td>
			<td width="13%"><label valign="left" class="smalllabel">Item
			Returned</label></td>



		</tr>

	</thead>
	<tbody>
		<% 
			
 		 
  					
  					while(itr.hasNext())
  					{
  						 String dateOfExpiryInString= null;
  						 Object[] pair = (Object[]) itr.next();
  			         	 StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) pair[0];
  			         	 BigDecimal qtyInHand = (BigDecimal) pair[1];
  			         	 String pvmsNo=storeItemBatchStock.getItem().getPvmsNo();
  			         	 int pvmsId=storeItemBatchStock.getItem().getId();
  			         	 int storeItemBatchStockId=storeItemBatchStock.getId();
  			        	 String nomenclature=storeItemBatchStock.getItem().getNomenclature();
  			        	 String batchNumber=storeItemBatchStock.getBatchNo();
  			        	 Date expiryDate=storeItemBatchStock.getExpiryDate();
  			        	 if(expiryDate != null)
  			        	 {
  			        	  dateOfExpiryInString =HMSUtil.changeDateToddMMyyyy(expiryDate);
  			        	 }
  			        	 else
  			        	 {
  			        		dateOfExpiryInString="";
  			        	 }
  			        	 BigDecimal costprice=storeItemBatchStock.getCostPrice();
  			        	 int brandId=storeItemBatchStock.getBrand().getId();
  			        	 String brandName=storeItemBatchStock.getBrand().getBrandName();
  			        	 
 			%>

		<tr>
			<td width="5%"><input type="text" name="brandName<%=i %>"
				class="medcaption" readonly="readonly" value="<%=brandName %>" /></td>
			<input type="hidden" name="brandId<%=i %>" value="<%=brandId %>" />
			</td>
			<input type="hidden" name="storeItemBatchStockId<%=i %>"
				value="<%=storeItemBatchStockId %>" />
			</td>

			<td width="13%"><input type="text" name="au<%=i %>"
				class="medcaption" readonly="readonly"
				value="<%=storeItemBatchStock.getItem().getItemConversion().getItemUnitName() %>" /></td>

			<td width="10%"><input type="text" name="batchNo<%= i%>"
				class="medcaption" readonly="readonly" value="<%=batchNumber %>" /></td>

			<td width="13%"><input type="text" name="expiryDate<%=i %>"
				class="medcaption" readonly="readonly"
				value="<%=dateOfExpiryInString %>" /></td>

			<td width="13%"><input type="text" name="costprice<%=i %>"
				class="medcaption" readonly="readonly" value="<%=costprice %>" /></td>

			<td width="13%"><input type="text" name="stockQty<%=i %>"
				class="medcaption" readonly="readonly" value="<%=qtyInHand %>" /></td>

			<td width="13%"><input type="text" name="issueQty<%=i%>"
				id="issueQty<%=i%>" tabindex=1 class="medcaption"
				onblur="validateIssQty('stockDetailsForm',this,amount<%= i%>,<%=costprice%>,<%=qtyInHand%>,<%=i %>);" /></td>
			<script>
  		document.getElementById('issueQty<%=i-i%>').focus();
  	</script>
			<input type="hidden" name="amount<%=i %>" id="amount<%= i%>"
				value=" " />
			</td>

			<tr />
			<%
  	 	i++;
  	   }}else{
  	 %>

			No Records Found !
			<%} %>
		
	</tbody>
</table>

<br />
<br />
<br />
<br />


<div id="edited"></div>
<input id="save" property="save" type="button" name="save" value="Save"
	class="button"
	onclick="if(setHeaderValuesForReturnDispensary(<%=rowVal %>),validatePage(stockDetailsForm)){submitForm('stockDetailsForm','/hms/hms/stores?method=submitReturnDispensaryDetails');}" />
<input type="button" name="cancel" id="addbutton" value="Cancel"
	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 /> <input
	type="hidden" name="counter" id="counter" value="<%=i %>" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
</div>
<script type="text/javascript">

	function validateIssQty(formName,obj,amount,rate,qtyInHand,rowVal){

	element = obj.value
	var amountElement=amount.name
	obj1 = eval('document.'+formName+'.'+amountElement);
	
	nextElement=obj.name;
  	var issQty=element;
 	if(issQty==""){
		alert('Quantity returned is blank')
		return true
	}
	if(issQty<=0){
		alert('Quantity returned is Not Correct')
		return false
	}
	if(issQty>qtyInHand){
		alert('Quantity returned Cannot be more than Quantity in Hand')
		return false
	}
	
	if(issQty !=""){
		
		if(validateInteger(trimAll(issQty))){
		
		    var issuesQuantity=obj.value
			obj1.value=rate*issuesQuantity
			setTotalQtyInParent()
			return true;
		
		}else{
			alert("Please enter the integer value")
			
			return false
		}
	}
	
}
	function validateInteger( strValue ) {
	  var objRegExp  =/^((\+|-)\d)?\d*(\d{2})?$/;
	 	return objRegExp.test(strValue);
	}
	
	function validatePage(formName) {
			var counter=document.getElementById('counter').value;
			formname=formName.name
			 for(var i = 0; i < counter; i++)
			 {
			   amountVal = eval('document.'+formname+'.amount' + i + '.value')
			   issQtyVal=eval('document.'+formname+'.issueQty' + i + '.value')
			   
				if(amountVal == " " && issQtyVal != "")
				{
					alert("Please Enter the correct value in Quantity returned.")
					return false
				}
				if( issQtyVal == " " && amountVal != " ")
				{
				  obj1 = eval('document.'+formname+'.amount'+i);
				  obj1.value="";
				  alert("Please Enter the correct value of  Quantity")
				  return false
					
				}
		    }
		return true
		}
		
	function setTotalQtyInParent(){
		var sum = 0;
		for(var index = 0; index < parseInt(document.stockDetailsForm.counter.value); index++ ){
			var toEval = "document.stockDetailsForm.issueQty" + index;
			var qtyIssuedObj = eval(toEval);
			if(qtyIssuedObj.value != "")
			{
			sum = sum + parseInt(qtyIssuedObj.value);
			}else
			{
				sum=sum;
			}
		}
		toEval = "window.opener.document.getElementById(\'qtyIssued" + <%=rowVal%> + "\')";
		var totalQtyIssued = eval(toEval);
		totalQtyIssued.value = sum;
		
		return true
  	}
		
</script>



