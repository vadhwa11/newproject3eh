<%@page import="java.util.*"%>
<%@page
	import="static jkt.hms.util.RequestConstants.*,java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreGrnReturnM"%>
<%@page import="jkt.hms.masters.business.StoreGrnReturnT"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.RequestConstants"%>


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

function checkQtyForVendorReturn(){

for(var i=1;i<=30;i++){
var qty="";
if(document.getElementById("nameItem"+i)!=null&&document.getElementById("nameItem"+i).value!=""){

if(document.getElementById("qtyIssued"+i)!=null){

 qty=document.getElementById("qtyIssued"+i).value
if(qty!=""){

}
else{
var row=parseInt(i)+1;
alert("Pls fill Qnty.. in Row"+row);
document.getElementById("qtyIssued"+i).focus();
return false;
}
}
}
}


return true;


}
function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printVendorReturnJsp";
  obj.submit();
}
</script>
<%
	int returnId = 0;
	 int pageNo=0;
	int storeFyDocumentNoId = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	String buttonFlag="";


	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("stores.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int departmentIdForReturnFromDispensary = Integer.parseInt(properties.getProperty("departmentIdForReturnFromDispensary"));

	int deptId=departmentIdForReturnFromDispensary;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<StoreGrnReturnM> searchList = new ArrayList<StoreGrnReturnM>();
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
	if(map.get("returnId") != null)
	{
		returnId=(Integer)map.get("returnId");
	}
	List<StoreItemBatchStock> storeItemBatchStockList = new ArrayList<StoreItemBatchStock>();
	if(map.get("storeItemBatchStockList")!=null){
		storeItemBatchStockList=(List<StoreItemBatchStock>)map.get("storeItemBatchStockList");
	}
	if (map.get("searchList") != null) {
		searchList = (List<StoreGrnReturnM>)map.get("searchList");
	}
	Box box = HMSUtil.getBox(request);

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	String fromDateToDate=(String)map.get("fromDateToDate");

	List listOfItemsInStock=new ArrayList();
	List brandList= new ArrayList();
	List returnNoList= new ArrayList();

	List<StoreGrnReturnM> searchReturnMList = new ArrayList<StoreGrnReturnM>();
	List<StoreGrnReturnT> searchReturnTList = new ArrayList<StoreGrnReturnT>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	try {
		if(map.get("infoMap") != null){
			infoMap = (Map<String, Object>)	map.get("infoMap") ;
		}
		if(infoMap.get("listOfItemsInStock") != null){
			listOfItemsInStock=(List)infoMap.get("listOfItemsInStock");
		}
		if (infoMap.get("deptList") != null) {
			deptList = (List)infoMap.get("deptList");
		}
		if (infoMap.get("brandList") != null) {
			brandList = (List)infoMap.get("brandList");
		}
		if (map.get("returnNoList") != null) {
			returnNoList = (List)map.get("returnNoList");
		}
		if (infoMap.get("employeeList") != null) {
			employeeList = (List<MasEmployee>)infoMap.get("employeeList");
		}
		if (infoMap.get("searchList") != null) {
			searchList = (List<StoreGrnReturnM>)infoMap.get("searchList");
		}
		if(map.get("storeFyDocumentNoId") != null){
			storeFyDocumentNoId = (Integer)map.get("storeFyDocumentNoId");
		}
		if(map.get("searchReturnMList") != null){
			searchReturnMList = (List<StoreGrnReturnM>)map.get("searchReturnMList");
		}
		if(map.get("searchReturnTList") != null){
			searchReturnTList = (List<StoreGrnReturnT>)map.get("searchReturnTList");
		}
		if(map.get("supplierList") != null){
			supplierList=(List)map.get("supplierList");
		}
	} catch (Exception exp) {
		exp.printStackTrace();
	}

  %>

<%--  <%

			int k=0;
  					Iterator itr = listOfItemsInStock.iterator();
  					int brandId=0;
  					while(itr.hasNext())
  					{
  						try{
  						 Object[] pair = (Object[]) itr.next();
  			         	 StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) pair[0];
  			         	 BigDecimal qtyInHand = (BigDecimal) pair[1];
  			         	 String pvmsNo=storeItemBatchStock.getItem().getPvmsNo();
  			         	 int itemId=storeItemBatchStock.getItem().getId();
  			        	 String nomenclature=storeItemBatchStock.getItem().getNomenclature();
  			        	 String batchNumber=storeItemBatchStock.getBatchNo();
  			        	// Date expiryDate=storeItemBatchStock.getExpiryDate();
  			        	// String dateOfExpiryInString =HMSUtil.changeDateToddMMyyyy(expiryDate);
  			        	 BigDecimal costprice=storeItemBatchStock.getCostPrice();
  			        	 if(storeItemBatchStock.getBrand()!= null)
  			        	 {
  			        	  brandId=storeItemBatchStock.getBrand().getId();
  			        	 }else{
  			        		 brandId=0;
  			        	 }
  			        	String brandName = "";
  			        	if(storeItemBatchStock.getBrand()!= null){
  			        	 brandName=storeItemBatchStock.getBrand().getBrandName();
  			        	}

 			%>
         		 <script>

         		nameArray[<%=k%>]= new Array();
         		nameArray[<%=k%>][0] = "<%=storeItemBatchStock.getId()%>";
				nameArray[<%=k%>][1] = "<%=pvmsNo%>";
				nameArray[<%=k%>][2] = "<%=itemId%>";
				nameArray[<%=k%>][3] = "<%=brandName%>";
         		nameArray[<%=k%>][4] = "<%=date%>";
         		nameArray[<%=k%>][5] = "<%=brandId%>";
         		nameArray[<%=k%>][6] = "<%=nomenclature%>";

         		codeArray[<%=k%>]="<%=storeItemBatchStock.getItem().getNomenclature()%>"
         		</script>
          <%}catch(Exception e){
        	  %>
        	  	There are some errors !!!
        	  <%

        	  e.printStackTrace();
        	  }
         	 k++;
			}
  		  %>--%>
<div class="clear"></div>


<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>

<!-- </form> -->

<form name="search" method="post">
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="hidden" name="pageNo" value="<%=pageNo%>" /> <label
	class="bodytextB">Vendor No:</label> <select
	name="<%= RequestConstants.VENDOR_RETURN_ID%>"
	validate="MMF Year,num,Yes" id="mmfYear">
	<option value="0">Select</option>
	<%
				try{

					for(StoreGrnReturnM storeGrnReturnM :searchList){ %>
	}
	<option value="<%=storeGrnReturnM.getId() %>"><%=storeGrnReturnM.getReturnNo() %></option>
	<%} }catch(Exception e){
					e.printStackTrace();
				}%>
</select> <input type="image" src="/hms/jsp/images/go.gif" class="button"
	value="Go!"
	onClick="submitForm('search','stores?method=searchVendorReturn&pageNo=<%=pageNo-1%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>');" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>


<%--<input type="button" name="Add" type="submit"  value="Add" class="button">

					<input type="button" name="Modify" type="submit" value="Modify" class="button"  onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');">
						<input type="button" name="Reset" type="submit" value="Reset" class="button" >
						<input type="button" name="Delete" type="submit"  value="Delete" class="button" >
					    <input type="button" name="print" type="submit" class="button" value="Print" onClick="showReport('returnSearch');">
	 --%>




<%--------------- Start of Search Panel ---------------------------%>

<%-------------------- End of Search Panel ---------------------------%>



<div class="clear"></div>
<form name="returnSearch" method="post"><!--  code to make the search panel -->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input name="<%=ISSUE_RETURN_ID %>" value="<%=returnId %>" type="hidden" />
<%

	String returnNo = "";

	if(map.get("finalReturnNo") != null){
		returnNo = (String)map.get("finalReturnNo");
	}else if(map.get("returnNo") != null){
		returnNo = (String)map.get("returnNo");
	}

	%>
<div class="clear"></div>
<%
int count =0;
	if(searchReturnMList.size() > 0){
	for (StoreGrnReturnM mObj : searchReturnMList) {

%>

<h4>Vendor return details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Return No:</label> <input type="text" name="<%=RETURN_NO %>"
	id="vendorReturnId" value="<%= mObj.getReturnNo()%>" class="readOnly"
	readonly="readonly" validate="Return No ,String,yes" tabindex=1 /> <label>Return
Date :</label> <input type="text" name="<%=RETURN_DATE%>" id="returnDate"
	value="<%=HMSUtil.convertDateToStringWithoutTime(mObj.getReturnDate()) %>"
	validate="Return Date,dateOfAdmission,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=date%>',document.returnSearch.<%=RETURN_DATE%>,event)" />
<label><span>*</span>Reference No:</label> <input type="text"
	id="referenceNo" name="<%=REFERENCE_NO %>"
	value="<%=mObj.getRefDocNo() %>" validate="Reference No ,String,yes"
	tabindex=1 />

<div class="clear"></div>

<label></font>Vendor name :</label> <select name="<%=VENDOR_NAME %>"
	id="returnBy" validate="Vendor ,String,yes">
	<option value="0">Select</option>
	<%
	for (MasStoreSupplier  storeSupplier : supplierList) {
	%>
	<option value="<%=storeSupplier.getId() %>"
		<%=HMSUtil.isSelected(storeSupplier.getId().toString(),mObj.getSupplier().getId().toString()) %>><%=storeSupplier.getSupplierName()%></option>
	<%
	}
	%>
</select> <label></font>PO No :</label> <input type="text" name="PO No" id="returnNo"
	value="<%= mObj.getSupplyOrderNo()==null?"":mObj.getSupplyOrderNo()%>"
	class="readOnly" readonly="readonly" validate="Return No ,String,no"
	tabindex=1 />

<div class="clear"></div>

<label><span>*</span>Return By:</label> <select
	name="<%=RETURN_BY_ID %>" id="returnBy" validate="Return By,String,yes">
	<option value="0">Select</option>
	<%
	for (MasEmployee masEmployee : employeeList) {
		if(masEmployee.getId() == mObj.getReturnBy().getId()){
	%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%
	}else{
	%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%}
		}%>
</select> <label><span>*</span>Approved By:</label> <select
	name="<%=APPROVED_BY %>" id="receiveBy"
	validate="Approved By ,String,yes">
	<option value="0">Select</option>
	<%
	for (MasEmployee masEmployee : employeeList) {
		if(masEmployee.getId() == mObj.getApprovedBy().getId()){
	%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%
	}else{
	%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%}
		}%>
</select>
<div class="clear"></div>
<label>Reason:</label> <%
	if(mObj.getReason() != null){
	%> <textarea value="" name="<%=REASON %>" id="reason"
	validate="Reason ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /><%=mObj.getReason() %></textarea> <%}else{ %> <textarea value=""
	name="<%=REASON %>" id="reason" validate="Reason ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /></textarea> <%} %> <label>Remarks:</label> <%
	if(mObj.getRemarks() != null){
	%> <textarea value="<%=mObj.getRemarks() %>" name="<%=REMARKS %>"
	id="remarks" validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /><%=mObj.getRemarks() %></textarea> <%}else{ %> <textarea value=""
	name="<%=REMARKS %>" id="remarks" validate="Remarks ,String,no"
	tabindex=1 onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" /></textarea> <%} %> <%} }%>
<div class="clear"></div>

<input type="hidden" id="returnNo" value="<%= returnNo%>" readonly /> <input
	type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input
	type="hidden" id="storeFyDocumentNoId"
	value="<%=storeFyDocumentNoId %>" /></div>


<%--<input type="button" class="button" value="Next"  onclick="submitForm('returnSearch','stores?method=searchVendorReturn&pageNo=<%=pageNo%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>&storeFyDocumentNoId=<%=storeFyDocumentNoId %>');" align="right" /> --%>
<%--		<input type="button" class="button" value="Delete"  onclick="openPopupForDelete(<%=brandId%>,'<%=returnNo%>');" align="right" /> --%>
<input type="button" class="button" value="Modify"
	onclick="if(checkQtyForVendorReturn()){submitForm('returnSearch','stores?method=updateGridItemsInVendorReturn');}"
	align="right" /> <!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
Page No:<%=pageNo%> <input type="hidden" size="2" value=""
	name="noOfRecords" id="noOfRecords" /> <!-- <input type="hidden" name="<%=STORE_ITEM_BATCH_STOCK_ID %>" value="" id="hdb" /> -->
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
    	int inc=0;
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
    	if(searchReturnTList.size() > 0 && searchReturnTList.size() >= 30){
    	for(StoreGrnReturnT tObj : searchReturnTList){
    		inc++;
     %>
		<tr>
			<td width="5%">
			 <input type="text" size="2" value="<%=temp+inc%>"	name="<%=SR_NO%>" readonly="readonly" /></td>

			<td width="10%">
			<input type="text"	value="<%=tObj.getItem().getNomenclature() %>" tabindex=1
				id="nameItem<%=inc%>" tabindex="1" name="nameItem"	readonly="readonly" name="nameItem" />
			<div id="ac23update" class="autocomplete" style="display: none;"></div>
			</td>
			<td width="13%">
			  <input type="text" value="<%=tObj.getItem().getPvmsNo() %>" name="pvmsNo<%=inc%>"
				readonly="readonly" id="pvmsNo<%=inc%>" />
			  <input type="hidden" value="<%=tObj.getItem().getId() %>" name="itemId<%=inc%>"
				id="itemId<%=inc %>" />
			 <input type="hidden" name="date" id="date"	value="<%=date %>" />
			 <input type="hidden" name="time" id="time"	value="<%=time %>" />
			 <input type="hidden" value="<%=storeItemBatchStockList.get(0).getId() %>"
				name="storeItemBatchStockId" id="stockId<%=inc %>" />
			 <input	type="hidden" value="<%=storeItemBatchStockList.get(0).getCostPrice() %>"
				name="costprice" id="costprice<%=inc %>" />
			 <input type="hidden" value="<%=tObj.getReturnAmount() %>" name="amount"
				id="amount<%=inc %>" />
			</td>
			<td width="10%">
				<select name="batchNo" tabindex="1" id=<%="batchId"+inc%> tabindex="1"
				onchange="getExpiryDateByAjax(this.value,<%=inc%>);">
				<option value="">Select Batch No..</option>
				<option value="<%=storeItemBatchStockList.get(0).getId() %>"><%=tObj.getBatchNo() %></option>
			</select></td>

			<input type="text" tabindex=1 value="<%=HMSUtil.changeDateToddMMyyyy(tObj.getExpiryDate()) %>"
				name="expiryDate" id="expiryDate<%=inc%>" readonly />
			</td>
			<td width="10%">
			<input type="text" tabindex="1" name="stockAvailable" id="stockAvailable<%=inc%>"
				value="<%=storeItemBatchStockList.get(0).getClosingStock().toString() %>" value="" readonly
				onblur="checkforStock(<%=inc %>)" />
			</td>
			<td width="16%">
			  <input type="text" value="<%=tObj.getReturnQty() %>" name="<%=QTY_ISSUED%>"	id="qtyIssued<%=inc%>"
			  onblur="checkforStock(<%=inc %>),calculateAmt(<%=inc %>);" readonly /></td>
			<td width="10%">
			<input type="text" id="amountTotal<%=inc%>" name="amountTotal" value="<%=tObj.getReturnAmount() %>"
				onblur="totalCost();" readonly="readonly"/>
			</td>
		</tr>
		<%inc++;
     }
     	 }
    	for(int cnt=0;cnt<30;cnt++){

     		 int transactionSize=searchReturnTList.size();
     		if(searchReturnTList.size() > 0 && cnt<transactionSize){
     		StoreGrnReturnT	tObj=searchReturnTList.get(cnt);
     %>
		<tr>
			<td width="5%"><input type="text" size="2"
				value="<%=temp+inc+1%>" name="<%=SR_NO%>" readonly="readonly" /></td>

			<td width="10%">
			
			<input type="text" value="<%=tObj.getItem().getNomenclature() %>"
				tabindex=1 id="nameItem<%=inc%>" tabindex="1" name="nameItem"
				readonly="readonly" />
			<div id="ac2update" class="autocomplete" style="display: none;"></div>

			</td>



			<td width="13%"><input type="text"
				value="<%=tObj.getItem().getPvmsNo() %>" name="pvmsNo"
				readonly="readonly" id="pvmsNo<%=inc%>" /> <input type="hidden"
				value="<%=tObj.getItem().getId() %>" name="itemId"
				id="itemId<%=inc %>" /> <input type="hidden" name="date" id="date"
				value="<%=date %>" /> <input type="hidden" name="time" id="time"
				value="<%=time %>" /> <input type="hidden"
				value="<%=storeItemBatchStockList.get(cnt).getId() %>"
				name="storeItemBatchStockId" id="stockId<%=inc %>" /> <input
				type="hidden"
				value="<%=storeItemBatchStockList.get(cnt).getCostPrice() %>"
				name="costprice" id="costprice<%=inc %>" /> <input type="hidden"
				value="<%=tObj.getReturnAmount() %>" name="amount"
				id="amount<%=inc %>" /></td>

			<td width="10%"><select name="batchNo" tabindex=1
				id=<%="batchId"+inc%> tabindex="1"
				onchange="getExpiryDateByAjax(this.value,<%=inc%>);">
				<option value="<%=storeItemBatchStockList.get(cnt).getId() %>"><%=tObj.getBatchNo() %></option>
			</select></td>
			<td width="10%"><input type="text" tabindex=1
				value="<%=HMSUtil.convertDateToStringTypeDate(tObj.getExpiryDate()) %>"
				name="expiryDate" id="expiryDate<%=inc%>" readonly /></td>
			<td width="10%"><input type="text" tabindex=1
				value="<%=storeItemBatchStockList.get(cnt).getClosingStock().toString() %>"
				name="stockAvailable" id="stockAvailable<%=inc%>" value="" readonly
				onblur="checkforStock(<%=inc %>)" /></td>
			<td width="16%"><input type="text"
				value="<%=tObj.getReturnQty() %>" name="issueQty"
				id="qtyIssued<%=inc%>" onblur="checkforStock(<%=inc %>),calculateAmt(<%=inc %>);"/></td>
				<td>
			<input type="text" id="amountTotal<%=inc%>" name="amountTotal" value="<%=tObj.getReturnAmount() %>"
				 onblur="totalCost();" readonly="readonly"/>
			</td>
		</tr>
		<%

     	}
           else{
     %>
		<tr>
			<td width="5%"><input type="text" size="2"
				value="<%=temp+inc+1%>" name="<%=SR_NO%>" readonly="readonly" /></td>

			<td width="10%"><input type="text" value="" tabindex=1
				id="nameItem<%=inc%>" tabindex="1" name="nameItem"
				onblur="if(fillSrNo('<%=inc %>')){checkForVendorReturnOriginal(this.value, 'nameItem','<%=inc %>');}"
				name="nameItem" />
			<div id="ac2update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('nameItem<%=inc%>','ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=nameItem'});
			</script></td>

			<td width="13%"><input type="text" value="" name="pvmsNo"
				readonly="readonly" id="pvmsNo<%=inc%>" /> <input type="hidden"
				value="" name="itemId" id="itemId<%=inc %>" /> <input type="hidden"
				name="date" id="date" value="<%=date %>" /> <input type="hidden"
				name="time" id="time" value="<%=time %>" /> <input type="hidden"
				value="" name="storeItemBatchStockId" id="stockId<%=inc %>" /> <input
				type="hidden" value="" name="costprice" id="costprice<%=inc %>" />

			<input type="hidden" value="" name="amount" id="amount<%=inc %>" />
			</td>

			<td width="10%"><select name="batchNo" tabindex=1
				id=<%="batchId"+inc%> tabindex="1"
				onchange="getExpiryDateByAjax(this.value,<%=inc%>);"onblur="totalCost();" >
				<option value="">Select Batch No..</option>
			</select></td>
			<td width="10%"><input type="text" tabindex=1 value=""
				name="expiryDate" id="expiryDate<%=inc%>" readonly /></td>
			<td width="10%"><input type="text" tabindex=1 value=""
				name="stockAvailable" id="stockAvailable<%=inc%>" value="" readonly
				onblur="checkforStock(<%=inc %>);"/></td>
			<td width="16%"><input type="text" value="" name="issueQty"
				id="qtyIssued<%=inc%>" onblur="calculateAmt(<%=inc %>); "/></td>
			<td>
			<input type="text" id="amountTotal<%=inc%>" name="amountTotal" value="" onblur="totalCost();"
							 readonly="readonly"/>
			</td>
		</tr>
		<%
  		}inc++;}
     %>

	</tbody>
</table>
<!-- -
<label>Total Amount</label>
<input type="text" name="totalReturnAmt" id="totalReturnAmtId" value="0"/>
-->
</form>

<script type="text/javascript">



	/*	function validatePage(formName) {

			var counter=document.getElementById('counter').value;
			//alert(counter)
			formname=formName.name
			//alert(formname)
			 for(var i = 0; i < counter; i++)
			 {
			   amountVal = eval('document.'+formname+'.amount' + i + '.value')
			   issQtyVal=eval('document.'+formname+'.issueQty' + i + '.value')
			  // alert("amount value=="+amountVal+"  issued quantity value=="+issQtyVal)
				if(amountVal =="" && issQtyVal != "")
				{
					alert("Please Enter the correct value in Issued Quantity")
					return false
				}
				if(amountVal !="" && issQtyVal == "")
				{
					alert("Please Enter the Issued Quantity")
					return false
				}
		    }
		return true
		}
	*/

	function fillItemsInGrid(brandId,rowVal,deptId){

		for(var i=0;i<nameArray.length;i++){
		if(nameArray[i][5]==brandId){
			document.getElementById('pvmsNo'+rowVal).value=nameArray[i][1]
			document.getElementById('itemId'+rowVal).value=nameArray[i][2]
			document.getElementById('nomenclature'+rowVal).value=nameArray[i][6]
			document.getElementById('noOfRecords').value=rowVal+1;

			}
		}
		openPopup(brandId,deptId,rowVal);
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

	    document.getElementById("batchId"+inc).length=0;


		ajaxFunctionForAutoCompleteInVendorReturn('returnSearch','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);

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

	function openPopup(brandId,deptId,rowVal){
		var url="/hms/hms/stores?method=showStockDetailsForReturnDispensary&brandId="+brandId+"&deptId="+deptId+"&rowVal="+rowVal;
        popwindow(url);
     }
	function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=400,width=700,status=1");
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

	function openPopupForDelete(brandId,returnNo){
		var url="/hms/hms/stores?method=showDeleteReturnFromDispensary&brandId="+brandId+"&returnNo="+returnNo;
        popwindowForDelete(url);
     }
	function popwindowForDelete(url)
	{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=1000,');
    }
</script>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>

<input type="hidden" name="rows" id="rr" value="1" />



<script type="text/javascript">

function totalCost(){
	var amt = 0;
	var count = document.getElementById('hiddenValueCharge').value;
	for(var i=1; i<=count; i++){
		var totalAmt = eval(document.getElementById("amountTotal"+i));
		if(totalAmt.value != '' && parseFloat(totalAmt.value) != 0 && totalAmt.value !=null){
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



function calculateAmt(inc){
	var qtyObj = document.getElementById('qtyIssued'+inc).value;
	var rateObj =document.getElementById('costprice'+inc).value;
	var amountTotal = 0;
	amountTotal = parseFloat(qtyObj)*parseFloat(rateObj);
	document.getElementById('amountTotal'+inc).value=amountTotal;
}

</script>




