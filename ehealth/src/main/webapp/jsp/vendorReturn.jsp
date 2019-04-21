<%@page import="java.util.*"%>
<%@page	import="static jkt.hms.util.RequestConstants.*,java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalReturnM"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreGrnReturnM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>


<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>
<script type="text/javascript">
 var nameArray=new Array();
 var codeArray=new Array();

</script>
<%
	 int pageNo=1;
	int storeFyDocumentNoId = 0;
	Map map = new HashMap();
	String buttonFlag="";
	String max="";
    Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
	.getResource("stores.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int departmentIdForReturnFromDispensary = Integer.parseInt(properties.getProperty("departmentIdForReturnFromDispensary"));

	int deptId = 0 ;
	int vendorReturnId = 0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String timeInHHmm="";
	String [] tempArr = null;
	tempArr = time.split(":");
	for (int i = 0 ; i < tempArr.length-1 ; i++) {

		timeInHHmm=timeInHHmm+(String)tempArr[i];
    	 if(i==0)
    	 {
    		 timeInHHmm=timeInHHmm+":";
    	 }
	}
	if(map.get("buttonFlag") != null)
	{
		buttonFlag=(String)map.get("buttonFlag");
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
	}
	if(map.get("deptId") != null)
	{
	deptId=(Integer)map.get("deptId");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	String fromDateToDate=(String)map.get("fromDateToDate");
	List listOfItemsInStock=new ArrayList();
	//List brandList= new ArrayList();
	List returnNoList= new ArrayList();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StoreGrnReturnM> searchList = new ArrayList<StoreGrnReturnM>();
	try {
		if(map.get("listOfItemsInStock") != null){
			listOfItemsInStock=(List)map.get("listOfItemsInStock");
		}
		if(map.get("supplierList") != null){
			supplierList=(List)map.get("supplierList");
		}
		if (map.get("deptList") != null) {
			deptList = (List)map.get("deptList");
		}
		//if (map.get("brandList") != null) {
		//	brandList = (List)map.get("brandList");
		//}
		if (map.get("returnNoList") != null) {
			returnNoList = (List)map.get("returnNoList");
		}
		if (map.get("employeeList") != null) {
			employeeList = (List<MasEmployee>)map.get("employeeList");
		}
		if (map.get("searchList") != null) {
			searchList = (List<StoreGrnReturnM>)map.get("searchList");
		}
		if(map.get("storeFyDocumentNoId") != null){
			storeFyDocumentNoId = (Integer)map.get("storeFyDocumentNoId");
		}
		if(map.get("max") != null){
			max = ""+map.get("max");
		}
	} catch (Exception exp) {
		exp.printStackTrace();
	}
	Box box = HMSUtil.getBox(request);
  %>
<script language="javascript">

function calculateAmt(inc){
	var qtyObj = document.getElementById('qtyIssued'+inc).value;
	var rateObj =document.getElementById('costprice'+inc).value;
	var amountTotal = 0;
	amountTotal = parseFloat(qtyObj)*parseFloat(rateObj);
	document.getElementById('amountTotal'+inc).value=amountTotal;
}
	function checkForVendorReturn(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
	    for(i=1;i<=8;i++){
	    if(val !="")
	    if(document.getElementById('brandName'+i).value==val){
	    if(document.getElementById('brandName'+inc).value!=val){
	    	alert("Item already selected...!")
	    	document.getElementById('brandName'+inc).value=""

	    	return false;
	    	}
	    }}
		ajaxFunctionForVendorReturn('vendorReturnForm','stores?method=fillItemsForIndentToVendorReturn&brandName=' +  val , inc);
}

function checkQtyForVendorReturn(){
for(var i=0;i<=30;i++){
var qty="";
if(document.getElementById("nameItem"+i)!=null&&document.getElementById("nameItem"+i).value!=""){
if(document.getElementById("qtyIssued"+i)!=null){
 qty=document.getElementById("qtyIssued"+i).value
if(qty!=""){

}
else{
alert("Pls fill Qnty.. in Row "+i);
document.getElementById("qtyIssued"+i).focus();
return false;
}
}
}
}


return true;


}
function fillSrNo(rowVal){

	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		if(rowVal==0){
   			rowVal=8
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	var errorMessage="";
	if(document.getElementById('referenceNo').value == "")
		errorMessage=errorMessage+"Please fill referenceNo  \n";

	if(document.getElementById('vendorId').value == 0)
		errorMessage=errorMessage+"Please Select Vendor name \n";

	if(document.getElementById('returnBy').value == 0)
		errorMessage=errorMessage+"Please select return By \n";
		if(document.getElementById('approvedBy').value == 0)
		errorMessage=errorMessage+"Please selct Approved By \n";
	if((document.getElementById('referenceNo').value != "")  &&(document.getElementById('vendorId').value != "") &&(document.getElementById('returnBy').value != 0)&&(document.getElementById('approvedBy').value != 0)){
		return true;
	}else{
		alert(errorMessage)
		return false
	}
}
</script>
<%-- Title --%>
<div class="titleBg">
<h2>Vendor Return</h2>
</div>
<div class="clear"></div>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<!-- </form> -->
<form name="search" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="hidden" name="pageNo" value="<%=pageNo%>" /> <!--  code to make the search panel -->
<%--------------- Start of Search Panel ---------------------------%>
<form name="searchPanel" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<label class="bodytextB">Vendor No</label>
<select name="<%= RequestConstants.VENDOR_RETURN_ID%>"	validate="MMF Year,num,Yes" id="mmfYear">
	<option value="0">Select</option>
	<%
				try{
					for(StoreGrnReturnM storeGrnReturnM :searchList){ %>
	}
	<option value="<%=storeGrnReturnM.getId() %>"><%=storeGrnReturnM.getReturnNo() %></option>
	<%} }catch(Exception e){
					e.printStackTrace();
				}%>
</select>
<input type="image" class="button"	value="Go!"	onClick="submitForm('search','stores?method=searchVendorReturn&pageNo=<%=pageNo-1%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>');" />
		</form>
<%-------------------- End of Search Panel ---------------------------%>
</div>
</form>
<form name="vendorReturnForm" method="post"><!--  code to make the search panel -->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<%
	String returnNo = "";
	if(map.get("finalReturnNo") != null){
		returnNo = (String)map.get("finalReturnNo");
	}else if(map.get("returnNo") != null){
		returnNo = (String)map.get("returnNo");
	}
	%>
<div class="clear"></div>
<div class="clear"></div>
<h4>Vendor return details</h4>
<div class="clear"></div>
<div class="Block">
<input type="hidden" name="storeGrnReturnMId" id="storeGrnReturnMId" value="0" tabindex=1 />
<label>Return No</label>
<input type="text" name="<%=RETURN_NO %>" id="returnNo"	value="<%= max%>" class="readOnly" readonly="readonly" />
<input	type="hidden" id="storeFyDocumentNoId"	value="<%=storeFyDocumentNoId %>" />
<label style="margin-left:31px;">Return Date  </label>
<input	type="text" class="date" name="<%=RETURN_DATE%>" id="returnDate" value="<%=date %>" validate="Return Date,dateOfAdmission,yes"	MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.vendorReturnForm.<%=RETURN_DATE%>,event)" />
<label style="margin-left:18px;">Reference No </label>
<input type="text" id="referenceNo" name="<%=REFERENCE_NO %>" value="<%=box.get("referenceNo") %>" validate="Reference No ,String,yes" tabindex=1 />
<div class="clear"></div>
<label>Vendor Name </label>
<select name="<%=VENDOR_NAME %>" id="vendorId" validate="Return By,String,yes">
	<option value="0">Select</option>
	<%
	for (MasStoreSupplier  storeSupplier : supplierList) {
	%>
	<option value="<%=storeSupplier.getId() %>"
		<%=HMSUtil.isSelected(storeSupplier.getId().toString(),box.get("vendorName")) %>><%=storeSupplier.getSupplierName()%></option>
	<%
	}
	%>
</select>
<label>PO No</label>
<input type="text" id="SONo" name="SONo" value="<%=box.get("supplier3") %>" validate="Reference No ,String,no"	tabindex=1 />
<label style="margin-left:-19px;">Return By</label>
<select	name="<%=RETURN_BY_ID%>" id="returnBy" validate="Return By,String,yes">
	<option value="0">Select</option>
	<%
	for (MasEmployee masEmployee : employeeList) {
	%>
	<option value="<%=masEmployee.getId() %>"
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("returnBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%
	}
	%>
</select>
<div class="clear"></div>
<label>Approved By</label>
<select name="<%=APPROVED_BY %>" id="approvedBy" validate="Received By ,String,yes">
<option value="0">Select</option>
	<%
	for (MasEmployee masEmployee : employeeList) {
	%>
	<option value="<%=masEmployee.getId() %>"
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("approvedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%
	}
	%>
</select>
<label>Reason</label>
<textarea name="<%=REASON %>" id="reason"
	validate="Reason ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="100" /><%=box.get("reason").trim()%>
	</textarea>
<label>Remarks </label>
<textarea name="<%=REMARKS %>" id="remarks"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /><%=box.get("remarks")%></textarea>
<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
<input type="hidden" id="storeFyDocumentNoId"	value="<%=storeFyDocumentNoId %>" /> <%-- <input type="button" class="button" value="Next"  onclick="if(checkForNext()){submitForm('vendorReturnForm','stores?method=showVendorReturnJsp&buttonFlag=next&pageNo=<%=pageNo%>&returnNo=<%=max%>&deptId=<%=deptId%>&storeFyDocumentNoId=<%=storeFyDocumentNoId %>');}" align="right" />--%>
<input type="button" tabindex=1 class="button" value="Add"	onclick="if(checkQtyForVendorReturn()){submitForm('vendorReturnForm','stores?method=submitVendorReturnDetails');}" />
<input type="button" tabindex=1   class="button" value="Delete"  onclick="openPopupForDelete(1,'<%=max%>');" align="right" />
<%--
<input type="button" tabindex=1   class="button" value="Update"  onclick="UpdateGridItemForVendorReturn" align="right" />
	--%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<label class="auto">Page No.</label> <label class="value"><%=pageNo%></label>
<div class="clear"></div>
<input type="hidden" size="2" value="0"	name="<%=RequestConstants.NO_OF_ROWS%>"	id="<%=RequestConstants.NO_OF_ROWS%>" />
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" />
<input type="hidden" size="2" value="9" name="noOfRecords" id="noOfRecords" /> <!-- <input type="hidden" name="<%=STORE_ITEM_BATCH_STOCK_ID %>" value="" id="hdb" /> -->
<input type="hidden" value="<%= deptId%>" name="deptId" id="deptId" />
<input type="hidden" name="hiddenValueCharge" id="hiddenValueCharge" value="30"/>
<div class="clear"></div>
<h4>Item Details</h4>
<div class="clear"></div>
<table colspan="7" id="indentDetails">
	<thead>
		<tr>
			<th>S.No.</th>
			<th>Item Name</th>
			<th>Item Code</th>
			<%-- <td width="13%"><label valign="left" class="smalllabel">Brand Name</label>      </td>--%>
			<th>Batch No</th>
			<th>Expiry Date</th>
			<th>Stock Available</th>
			<th>Total Quantity Returned</th>
			<th>Returned Amount</th>

		</tr>
	</thead>
	<tbody class="scrollContent bodyFormat">
		<%
    	int detailCounter=30;
    	int temp=0;
    	    	String nameItem="nameItem";
    	    	String batchNo="batchNo";
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=30;inc++){

     %>
				</td>
		<tr>

			<td width="5%"><input type="text" size="2" value="<%=inc%>"
				name="<%=RequestConstants.SR_NO%>" readonly="readonly" />
			<td width="10%"><input type="text" value="" size="50" tabindex=1
				id="<%=nameItem+""+inc%>" tabindex="1" name="<%=nameItem%>"
				onblur="if(fillSrNo('<%=inc %>')){checkForVendorReturnOriginal(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('<%=nameItem+""+inc%>','ac2update','stores?method=getItemListForVendorByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
			</script></td>
			<td width="7%"><input type="text" tabindex=1 name="pvmsNo"
				id="pvmsNo<%=inc%>" /> <input type="hidden" name="itemId"
				id="itemId<%=inc %>" value="" /> <input type="hidden" name="date"
				id="date" value="<%=date %>" /> <input type="hidden"
				name="storeItemBatchStockId" id="stockId<%=inc %>" value="" /> <input
				type="hidden" name="costprice" id="costprice<%=inc %>" value="" />
			<input type="hidden" name="amount" id="amount<%=inc %>" value="" />
			<input type="hidden" name="time" id="time" value="<%=time %>" /></td>
			<td width="10%"><select name="batchNo" tabindex=1
				id=<%="batchId"+inc%> tabindex="1"
				onchange="getExpiryDateByAjax(this.value,<%=inc%>);"onblur="totalCost();">
				<option value="">--select BatchNo--</option>
			</select></td>
			<%--     <td width="10%">
      	<input type="text" value=""	tabindex="1" id="brandName<%=inc%>" class="bigcaption" onblur="if(fillSrNo('<%=inc %>')){checkForVendorReturn(this.value, 'brandName<%=inc%>','<%=inc %>');}"  name="brandName<%=inc%>" />
			<div id="ac2update" style="display:none; border:1px solid black; padding-right: 450px; background-color:white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('brandName<%=inc%>','ac2update','stores?method=getItemListForVendorReturn',{parameters:'requiredField=brandName<%=inc%>&indentId='+document.getElementById('vendorReturnId').value });
			</script>
      </td> --%>
			<td width="10%"><input type="text" tabindex=1 value=""
				name="expiryDate" id="expiryDate<%=inc%>" value="" readonly /></td>
			<td width="10%"><input type="text" tabindex=1 value=""
				name="stockAvailable" id="stockAvailable<%=inc%>" value="" readonly
				onblur="checkforStock(<%=inc %>)" /></td>
			<td width="16%"><input type="text" value=""	name="issueQty" id="qtyIssued<%=inc%>"
					onblur="checkForIssueQty(<%=inc %>),calculateAmt(<%=inc %>);" tabindex=1/></td>
				<td>
				<input type="text" id="amountTotal<%=inc%>" name="amountTotal" value="" onblur="totalCost();"/>
</td>
		</tr>

		<%
     	}
     %>
	</tbody>
</table>
<label>Total Amount</label>
<input type="text" name="totalReturnAmt" id="totalReturnAmtId" value="0"/>
<div class="clear"></div><div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label> <label class="value"><%=userName%></label>
<label>Changed Date:</label>
<label class="value"><%=date%></label>
<label>Changed Time:</label>
<label class="value"><%=time%></label></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
	function fillItemsInGrid(brandId,rowVal,deptId){
	var err = "";
	var referenceNo = document.getElementById('referenceNo').value
	var toWard = document.getElementById('toWard').value
	var returnBy = document.getElementById('returnBy').value
	var receiveBy = document.getElementById('receiveBy').value
		for(var i=0;i<nameArray.length;i++){
		if(nameArray[i][5]==brandId){
			document.getElementById('pvmsNo'+rowVal).value=nameArray[i][1]
			document.getElementById('itemId'+rowVal).value=nameArray[i][2]
			document.getElementById('nomenclature'+rowVal).value=nameArray[i][6]
			document.getElementById('noOfRecords').value=rowVal+1;

			}
		}
		if(referenceNo == ""){
			err += "Please Enter Reference Number. \n";
		}
		if(toWard == 0){
			err += "Please Enter To Department. \n";
		}
		if(returnBy == 0){
			err += "Please select Return By. \n";
		}
		if(receiveBy == 0){
			err += "Please select Received By.";
		}

		if(referenceNo != "" && toWard != 0 && returnBy != 0 && receiveBy != 0){
			if(err == ""){
				openPopup(brandId,deptId,rowVal);
			}
		}else{
			alert(err);
		}
}
	function checkForVendorReturnOriginal(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*30)+1;
    	var end=((pageNo-1)*30)+30;

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);



		ajaxFunctionForAutoCompleteInVendorReturn('vendorReturnForm','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);

}

	function openPopup(brandId,deptId,rowVal){
		var url="/hms/hms/stores?method=showStockDetailsForReturnDispensary&brandId="+brandId+"&deptId="+deptId+"&rowVal="+rowVal;
        popwindow(url);
     }
	function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=470,width=700,status=1");
    }
	function checkForNext(){
	  if(document.getElementById('noOfRecords').value<=8)
	  {
	  	alert("All rows are not filled.Please Select the Brand Names to Enter ")
	  	return false;
	  }else{
	  return true;
	  }
  }

	function openPopupForDelete(brandId,max){
		var url="/hms/hms/stores?method=showDeleteVendorReturn&brandId="+brandId+"&returnNo="+max;
        popwindowForDelete(url);
     }
	function popwindowForDelete(url)
	{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=1000,');
    }

    function getExpiryDateByAjax(batchId,rowVal){


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
      if(xmlHttp.readyState==4){

      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];

	        var expiryDate  = item.getElementsByTagName("expiryDate")[0];
	        var stockId= item.getElementsByTagName("stockId")[0];
	         var costPrice= item.getElementsByTagName("costPrice")[0];
	         var stockAvailable=item.getElementsByTagName("stockAvailable")[0];

	        var mId  = item.getElementsByTagName("mId")[0];
        	document.getElementById('expiryDate'+rowVal).value = expiryDate.childNodes[0].nodeValue
        	document.getElementById('stockId'+rowVal).value = stockId.childNodes[0].nodeValue
       		document.getElementById('costprice'+rowVal).value = costPrice.childNodes[0].nodeValue
       		document.getElementById('stockAvailable'+rowVal).value = stockAvailable.childNodes[0].nodeValue

        	//document.getElementById('expiryDateTemp'+rowVal).value = expiryDate.childNodes[0].nodeValue

      	}
      }
    }
     url="stores?method=getExpiryDateInAjax&batchId="+batchId;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

 }
 function checkforStock(rowVal){
 var stockAvailable=	document.getElementById('stockAvailable'+rowVal).value;
 if(parseFloat(stockAvailable)>0){
 return true;

 }
 else{
 alert("stock is not available for this item");
 document.getElementById('stockAvailable'+rowVal).focus();
 return false;
 }
 }
 function checkForIssueQty(rowVal){
 var qtyIssued=document.getElementById('qtyIssued'+rowVal).value;
var stockAvailable=	document.getElementById('stockAvailable'+rowVal).value;
if(parseFloat(stockAvailable)<parseFloat(qtyIssued)){
alert("return qty. can't be greater than stock Qnt.");
 document.getElementById('qtyIssued'+rowVal).focus();
 return false;

 }
 }
</script>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
-->
</script>

<script type="text/javascript">

function totalCost(){
	var amt = 0;
	var count = document.getElementById('hiddenValueCharge').value;
	for(var i=1; i<=count; i++){
		var totalAmt = eval(document.getElementById("amountTotal"+i));
		if(totalAmt.value != '' && parseFloat(totalAmt.value) != 0){
		if(validateFloat(totalAmt.value)){
			if(amt != 0 && totalAmt.value != ""){
				amt = parseFloat(amt)+parseFloat(totalAmt.value);
			}else if(amt == 0 && totalAmt.value != ""){
				amt = parseFloat(totalAmt.value);
			}
		}
		}
	}
	document.getElementById('totalReturnAmtId').value = amt;
}

</script>





