<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

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
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>



<%
	String date = "";
	String time = "";
	String userName = "";
	String nomenclature = "";
	String pvms_no = "";
	int hospitalId = 0;
	String hiddenFieldForRecords="";
	String itemIdForNextRecord=null;
	Box box = HMSUtil.getBox(request);

	Vector mmfTItems = new Vector();

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
 	String items = "";
  	Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	List existingTenderNumbersList = null;
	List mmfyears = null;
	int currentPage=1;
	String tender_no;
	int currentYear=0;
	 List<StorePoHeader> storePoHeaderList= new ArrayList<StorePoHeader>();
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");

	}

	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	int mmfMasterId = 0;
	String storeType="";
	if(map.get("storePoHeaderList")!=null){
		storePoHeaderList=(List<StorePoHeader>)map.get("storePoHeaderList");
		}
	if (map.get("pagedArray") != null)
	{
	pagedArray = (PagedArray) map.get("pagedArray");
	}

	if(map.get("hiddenFieldForRecords")!= null)
	{
		hiddenFieldForRecords=(String)map.get("hiddenFieldForRecords");
	}
	if(map.get("itemIdForNextRecord")!= null)
	{
		itemIdForNextRecord=(String)map.get("itemIdForNextRecord");
	}
	
	if(pagedArray!=null){
		if((Integer)pagedArray.getCurrentPage()!=null){
			currentPage=pagedArray.getCurrentPage();
		}
	}
	if (map.get("itemField") != null && map.get("itemField") != "")
	{
		nomenclature = (String) map.get("itemField");
	}
	if (map.get("pvmsNoField") != null && map.get("pvmsNoField") != "")
	{
	    pvms_no = (String) map.get("pvmsNoField");
	}


%>

<title>Result For Pvms Nomenclature Search</title>


<script>

function goPage(pidx) {
	document.soItemForm.currPage.value = pidx;
	soItemForm.method="post";
	var pageType = document.getElementById('pageType').value;
	var nomenclature = document.getElementById('nomenclatureSearch1').value;
	var pvms = document.getElementById("pvms").value;

	var sos = document.getElementById('sos').value;
	var po_id = document.getElementById('po_id').value;


	var itemslist="";
    if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.length)
	    {
			 for(var i = 0; i < soItemForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
			  	  if(itemslist.length == 0){
			  	    itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	  }else{
			  	    itemslist = itemslist+","+soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	  }
			  }
		 }
	}

	else
	{
		if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
	         itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>.value;
		}
		//	return true;
	}
	var addedItems =document.getElementById('addedItems').value;
	 if(addedItems.length > 0){
	  addedItems = addedItems+","+itemslist;
	 }else{
	 addedItems = itemslist;
	 }


	submitForm('soItemForm','stores?method=getSoItemDetails&requiredField='+nomenclature+'&pvmsNo='+pvms+'&sos='+sos+'&po_id='+po_id+'&addedItems='+addedItems+'&pageType='+pageType+'&numOfRows=20&currPage='+pidx+'');
}

function passNomenclatureHiddenField(pvms,itemId){
document.getElementById("pvms1").value=pvms;
document.getElementById("itemId").value=itemId;
}


function validateAddButton()
{
	if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.length)
	{
			 for(var i = 0; i < soItemForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.checked == true)
			return true;
	}
	return false;
}


function jsAdd()
{
	soItemForm.method="post";
	var po_id=document.getElementById('po_id').value;
	var sos=document.getElementById('sos').value;
	var pageType = document.getElementById('pageType').value;

 	if (validateAddButton())
		{
       	var itemslist="";
    	if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.length)
	    {
			 for(var i = 0; i < soItemForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true)
			  {
			  	  if(itemslist.length == 0)
			  	  {
			  	    itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	      soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].disabled= true;
			  	  }
			  	  else
			  	  {
			  	    itemslist = itemslist+","+soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	      soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].disabled= true;
			  	  }
			  }
		 	}
		}
		else
		{
				if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.checked == true)
				{
			         itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>.value;
			           soItemForm.<%=ITEMS_TO_BE_ADDED%>.disabled= true;
				}
			//	return true;
		}

		 var addedItems =document.getElementById('addedItems').value;
		 if(addedItems.length > 0)
		 {
		  addedItems = addedItems+","+itemslist;
		 }
		 else
		 {
		 addedItems = itemslist;
		 }

		 jsClose();
	}
	else
	{
		alert('No Item(s) Selected to Add!....');
	}
}
function addAll(){

       	var itemslist="";
    	if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.length)
	    {
			 for(var i = 0; i < soItemForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {

			  	  if(itemslist.length == 0)
			  	  {
			  	    itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	     // soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].disabled= true;
			  	       soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked= true;
			  	  }
			  	  else
			  	  {
			  	    itemslist = itemslist+","+soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	     // soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].disabled= true;
			  	       soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked= true;
			  	  }
		 	}
		}
		else
		{
				if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.checked == true)
				{
			         itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>.value;
			          // soItemForm.<%=ITEMS_TO_BE_ADDED%>.disabled= true;
			            soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked= true;
				}
			//	return true;
		}

		 var addedItems =document.getElementById('addedItems').value;
		 if(addedItems.length > 0)
		 {
		  addedItems = addedItems+","+itemslist;
		 }
		 else
		 {
		 addedItems = itemslist;
		 }


}
function jsClose(){
	var po_id=document.getElementById('po_id').value;
	var sos=document.getElementById('sos').value;
    var pageType = document.getElementById('pageType').value;

    var itemslist="";
    if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.length)
	  {
			 for(var i = 0; i < soItemForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
			  	  if(itemslist.length == 0){
			  	    itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;

			  	  }else{
			  	    itemslist = itemslist+","+soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;

			  	  }
			  }
		 }
	  }
	else
	{
		if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
	         itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>.value;

		}
			//return true;
	}
	var addedItems =document.getElementById('addedItems').value;
	 if(addedItems.length > 0){

	  addedItems = addedItems+","+itemslist;
	 }else{
	 addedItems = itemslist;
	 }

    if(addedItems.length > 0){
    if(pageType == "mod"){
      var  parent = window.opener.document.getElementById('parent').value
         window.opener.location.href ="stores?method=modifyGrn&sos="+sos+"&searchPoId="+po_id+'&items='+addedItems+'&parent='+parent;
		    if (window.opener.progressWindow)
			{
			  	window.opener.progressWindow.close()
			}
			 window.close();
	    }else{
	    window.opener.document.getElementById('item_id').value = addedItems;
	    window.opener.document.getElementById('details').focus();
	  //  window.opener.document.getElementByid('details').style = none;
	    window.opener.jsGetGrid();
	    alert("PO Items Added Successfully!....");
	    calculationInCRV();
	    self.close();
     }
    }else{
     self.close();
    }


}

function jsSubmit()
{
         var po_id=document.getElementById('po_id').value;
		if (soItemForm.pvms.value == "" &&  soItemForm.search_text.value=="")
		{
		alert("Either Nomenclature or PVMS No should be entered!...");
		return;
		}

	var pageType = document.getElementById('pageType').value;
	var itemslist="";
    if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.length)
	    {
			 for(var i = 0; i < soItemForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 {
			  if (soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
			  	  if(itemslist.length == 0){
			  	    itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	  }else{
			  	    itemslist = itemslist+","+soItemForm.<%=ITEMS_TO_BE_ADDED%>[i].value;
			  	  }
			  }
		 }
	}
	else
	{
		if (soItemForm.<%=ITEMS_TO_BE_ADDED%> && soItemForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
	         itemslist = soItemForm.<%=ITEMS_TO_BE_ADDED%>.value;
		}

	//		return true;
	}
	var addedItems =document.getElementById('addedItems').value;
	 if(addedItems.length > 0){
	  addedItems = addedItems+","+itemslist;
	 }else{
	 addedItems = itemslist;
	 }
		soItemForm.method="post";
		submitForm('soItemForm','stores?method=getSoItemDetails&currPage=1&sos='+document.getElementById('sos').value+"&po_id="+po_id+"&pageType="+pageType+"&addedItems="+addedItems);
}



function populateSupplier1(val)
{

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    obj = document.getElementById("suppliers");

		obj.length = 1;
		var itemId=document.getElementById("itemId").value;
		alert("itemId"+itemId);
	    if (itemId!="")

ajaxFunctionForAutoCompleteInLPO('soItemForm','/hms/hms/tender?method=populateSupplierInTenderLPO&pvms=' + pvms + '&tenderId=' + document.getElementById("tenderId").value + '&deptId=' + document.getElementById("deptId").value);
}



</script>

<div class="titleBg">
<h2>Purchase Order Items</h2>
</div>
<div class="clear"></div>

<form name="soItemForm"><input type="hidden" name="numOfRows"
	size="5" value="20"> <input type="hidden" name="pageCount"
	size="5" value="10"> <input type="hidden" name="search"
	size="5" value="true"> <input type="hidden" name="deptId"
	value="<%=box.get("deptId")%>" /> <input type="hidden" name="currPage"
	value="<%=box.getInt("currPage")%>" /> <input type="hidden"
	name="numOfRows1" value="<%=box.getInt("numOfRows")%>" /> <input
	type="hidden" name="sos" id="sos" value="<%=box.get("sos")%>" /> <input
	type="hidden" name="po_id" id="po_id" value="<%=box.get("po_id")%>" />
<input type="hidden" name="pageType" id="pageType"
	value="<%=box.get("pageType")%>" /> <input type="hidden"
	id="addedItems" name="addedItems" value="<%=box.get("addedItems")%>" />
<input type="hidden" id="pvmsSearch" name="pvmsSearch"
	value="<%=pvms_no%>" /> <input type="hidden" id="nomenclatureSearch1"
	name="nomenclatureSearch1" value="<%=nomenclature%>" /> <input
	type="hidden" id="nomenclature1" name="nomenclature" value="" />
<div id="suppDiv" style="visibility: hidden"></div>
<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <%if(hiddenFieldForRecords.equals("true")){ %>
<input type="hidden" name="hiddenFieldForRecords" value="true" /> <%} else{%>
<input type="hidden" name="hiddenFieldForRecords" value="" /> <%} %> <%
		String supplierName = "";
		String soNo = "";
		Date soDate = null;
		 if(storePoHeaderList != null && storePoHeaderList.size()>0){
		 StorePoHeader storePoHeader = (StorePoHeader) storePoHeaderList.get(0);
		 supplierName = storePoHeader.getSupplier().getSupplierName();
		 soNo = storePoHeader.getPoNumber();
		 soDate = storePoHeader.getPoDate();
		 }
		%>
<div class="Block"><label>Supplier Name</label> <label
	class="value"><%=supplierName%></label> <label>PO No.</label> <label
	class="value"><%=soNo%></label>
<div class="clear"></div>

<label>PO Date</label> <label class="value"><%=HMSUtil.convertDateToStringWithoutTime(soDate)%></label>
<div class="clear"></div>
<h4>Search</h4>
<label>Item Name</label> <input type="text" name="search_text"
	id="search_text" value="" MAXLENGTH="30" /> <label>Item Code</label> <input
	type="text" name="pvms" id="pvms" value="" MAXLENGTH="15" />
<div class="clear"></div>
<input type="button" name="Submit" id="addbutton" onClick="jsSubmit()"
	value="Search" class="button" />
<div class="clear"></div>
</div>

<%
	if (pagedArray == null) {
		%>

<div class="clear"></div>
<div class="paddingTop15"></div>

<h4>PO Item Details</h4>
<div class="clear"></div>
<table width="75%" colspan="7" id="indentDetails" class="small">
	<thead>
		<tr>
			<th width="10%">S.No.</th>
			<th width="10%">Item Code</th>
			<th width="35%">Item Name</th>
			<th width="20%">UOM</th>
			<th width="10%">ADD</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>No Items Found</td>
		</tr>
	</tbody>
</table>


<%  } else { %>



<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>PO Item Details</h4>
<input type="button" name="Add" onClick="jsAdd();" value="Add"
	class="button" /> <input type="button" name="Add" onClick="addAll();"
	value="Check All" class="button" />
<div class="clear"></div>

<table width="98%" colspan="7" id="grnDetails" class="small">
	<thead class="fixedHeader headerFormat">
		<thead>
			<tr>
				<th>S.No.</th>
				<th>Item Code</th>
				<th>Item Name</th>
				<th>UOM</th>
				<th>ADD</th>
			</tr>
		</thead>
		<tbody>
			<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    { %>
			<tr>
				<td width="10%"><input type="text" size="2"
					value="<%=iFirstRow++%>" name="<%=SR_NO%>" readonly="readonly" /></td>
				<td width="10%"><input type="text" size="8"
					value="<%=gridData[i].get(PVMS_NO)%>" name="<%=PVMS_NO%>"
					readonly="readonly" /></td>
				<td width="55%"><input type="text"
					value='<%=gridData[i].get(NOMENCLATURE)%>' name="<%=NOMENCLATURE%>"
					readonly="readonly" /></td>
				<td width="25%"><input type="text" size="8"
					value="<%=gridData[i].get(AU)%>" name="<%=AU%>" readonly="readonly" />
				</td>
				<td width="10%"><input type="checkbox"
					name="<%=ITEMS_TO_BE_ADDED%>"
					value="<%=gridData[i].get("itemId")%>" class="radioCheck" /> <input
					type="hidden" name="<%=ITEM_ID%>"
					value="<%=gridData[i].get("itemId") %>" /></td>
			</tr>
			<% } %>
		</tbody>
</table>

<div class="clear"></div>
<div class="paddingTop15"></div>
<span><%= pagedArray.showIndex()%></span> <span><%= pagedArray.getPageIndexHiddenTag()%><span>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<!-- 		  <input type="button" name="Add" onClick="jsClose();" value="Close" class="button"   />  -->

<div class="clear"></div>

<div class="clear"></div>
<% } %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->

function calculationInCRV()
 {
    	for(rowVal=1;rowVal<=window.opener.document.getElementById('poListSize').value;rowVal++)
		{
		if(document.getElementById('idItem'+rowVal)){
			if(document.getElementById('idItem'+rowVal).value.trim()!=0)
			{
    			var discount = parseFloat(0);
				var tax = parseFloat(0);

				//Calculation of Amount for the Current Row (rowVal)
				//var added by shailesh
				//var grn_qty=isNaN(parseFloat(document.getElementById('grn_qty'+rowVal).value))==true?"0":parseFloat(document.getElementById('grn_qty'+rowVal).value);
				var quantity = isNaN(parseFloat(document.getElementById('quanRec'+rowVal).value))==true?"0":parseFloat(document.getElementById('quanRec'+rowVal).value);

				/*if(grn_qty<quantity){
				alert("Received  Quantity can't be greater then Actual Po Quantity in Row"+rowVal);
				document.getElementById('quanRec'+rowVal).focus();
				return false;
				}*/
				//var id_item=document.getElementById('idItem'+rowVal).value;

				//arrayOfItems1[rowVal]=rowVal+","+id_item+","+quantity+","+grn_qty;
				//alert(arrayOfItems1[rowVal])
				//end of code by shailesh

				var freeQty = isNaN(parseFloat(document.getElementById('freeQty'+rowVal).value))==true?"0":parseFloat(document.getElementById('freeQty'+rowVal).value);
				var ratePerMdq = isNaN(parseFloat(document.getElementById('ratePerMdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('ratePerMdq'+rowVal).value);
			//	var dispencingPrice = isNaN(parseFloat(document.getElementById('dispencingPrice'+rowVal).value))==true?"0":parseFloat(document.getElementById('dispencingPrice'+rowVal).value);
				//var mrp = isNaN(parseFloat(document.getElementById('mrp'+rowVal).value))==true?"0":parseFloat(document.getElementById('mrp'+rowVal).value);

				var discount = isNaN(parseFloat(document.getElementById('discountVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('discountVar'+rowVal).value);
				var tax = isNaN(parseFloat(document.getElementById('taxVar'+rowVal).value))==true?"0":parseFloat(document.getElementById('taxVar'+rowVal).value);

				var total = parseFloat(0);
				var disc= parseFloat(0);
				var amountAfterdiscount= parseFloat(0);
				var taxAmount = parseFloat(0);
				var netAmount= parseFloat(0);

				total = parseFloat(quantity)*parseFloat(ratePerMdq);
				disc = total*(discount/100);
				amountAfterdiscount = total-disc;
				taxAmount = (amountAfterdiscount)*(tax/100);
				var vatApplicable=document.getElementById("vatApplicable");

				if (vatApplicable.checked)
					{
				netAmount = amountAfterdiscount;

		 			}
		 		else{
					 netAmount = amountAfterdiscount + taxAmount;
				 	}
				document.getElementById('amtVar'+rowVal).value=roundVal(netAmount,2);
				document.getElementById('taxAmount'+rowVal).value=roundVal(taxAmount,2);
				document.getElementById('discountAmount'+rowVal).value=roundVal(disc,2);

				// Calculating converted Stock as Per Formula  & Conversion Login
				var formula = isNaN(parseFloat(document.getElementById('formula'+rowVal).value))==true?"0":parseFloat(document.getElementById('formula'+rowVal).value);
				var conversionFactor = isNaN(parseFloat(document.getElementById('conversionFactor'+rowVal).value))==true?"0":parseFloat(document.getElementById('conversionFactor'+rowVal).value);
				var mdq = isNaN(parseFloat(document.getElementById('mdq'+rowVal).value))==true?"0":parseFloat(document.getElementById('mdq'+rowVal).value);
				var convertedStock = parseFloat(0);
				quantity = parseFloat(quantity) + parseFloat(freeQty);
				if (formula !=0 && conversionFactor != 0 && mdq != 0)
				{
					if (formula==1)
					{
						convertedStock = (parseFloat(quantity) * parseFloat(mdq)) / parseFloat(conversionFactor);
					}
					else if (formula==2)
					{
						convertedStock = parseFloat(quantity);
					}
					document.getElementById('convertedStock'+rowVal).value = parseFloat(convertedStock);
				}
}
			}
		}
	/*	for(var x=0;x<arrayOfItems1.length;x++)
	{
		var content=arrayOfItems1[x].split(",");

		for(var z=0;z<arrayOfItems1.length;z++)
	  {
		if(x!=z)
		{
			var secondContent=arrayOfItems1[z].split(",");
			if(parseInt(content[1])==parseInt(secondContent[1]))
			{
			arrayOfItems1[x]=content[0]+","+content[1]+","+(parseFloat(content[2])+parseFloat(secondContent[2]))+","+content[3];
			}
		}
	 }
	}
	for(var y=0;arrayOfItems1.length;y++){
	var u=arrayOfItems1[y].split(",");
	if(parseFloat(u[2])>parseFloat(u[3])){
	  alert("items for type at Row"+u[0]+" cant be greater than Po Qnty.");
	  return false;


	  }
	}
		*///
		cheakForRecdQty();
		calculateGRNValue();
 }

 function cheakForRecdQty()
 {
 var currentRow=currentRow;
 var quantityRecdSum=parseFloat(0);
 var totalQuantity = new Array(10000);
 var sos="";

 for(rowVal=1;rowVal<=window.opener.document.getElementById('poListSize').value;rowVal++)
 {
 if(document.getElementById('idItem'+rowVal)){
		if(document.getElementById('idItem'+rowVal).value.trim()!=0)
		{
			var itemId=parseFloat(document.getElementById('idItem'+rowVal).value);
			var enteredQuantity = isNaN(parseFloat(document.getElementById('quanRec'+rowVal).value))==true?"0":parseFloat(document.getElementById('quanRec'+rowVal).value);
		var orderedQuantity=0;
			try{
			 orderedQuantity = isNaN(parseFloat(document.getElementById('grn_qty'+rowVal).value))==true?"0":parseFloat(document.getElementById('grn_qty'+rowVal).value);
			}
			catch(e){
			orderedQuantity=0;
			sos="grnForWithoutPo";
			}
			if (totalQuantity[itemId]!=undefined)
			{
				totalQuantity[itemId][1] = parseFloat(totalQuantity[itemId][1]) + parseFloat(orderedQuantity);
				totalQuantity[itemId][2] = parseFloat(totalQuantity[itemId][2]) + parseFloat(enteredQuantity);
				//alert('total ' + totalQuantity[itemId][1]);
				//alert('received ' + totalQuantity[itemId][2]);
			}
			else
			{
				totalQuantity[itemId] = new Array(2);
				totalQuantity[itemId][1] = parseFloat(orderedQuantity);
				totalQuantity[itemId][2] = parseFloat(enteredQuantity);
				//alert('total ' + totalQuantity[itemId][1]);
				//alert('received ' + totalQuantity[itemId][2]);
			}
	 	}
	 	}
}



var errorMsg = "";
for(rowVal=1;rowVal<=window.opener.document.getElementById('poListSize').value;rowVal++)
{
 if(document.getElementById('idItem'+rowVal)){
		if(document.getElementById('idItem'+rowVal).value.trim()!=0)
		{
				var itemId=parseFloat(document.getElementById('idItem'+rowVal).value);
				var nomenclature = document.getElementById('nameItem'+rowVal).value;
				if(sos!="grnForWithoutPo"){
				if (totalQuantity[itemId][1] < totalQuantity[itemId][2])
				{
				if (errorMsg=="") errorMsg = 'Received Qty > Ordered Quantity!... Kindly check the following Rows!....\n';
				errorMsg = errorMsg + '\nRow No: ' + rowVal + ' Item: ' + nomenclature ;
				}
				}
	 	}
	 	}
}

if (errorMsg=="")
	return true;
else
{
	alert(errorMsg);
	return false;
}

}


function calculateGRNValue()
 {
	//Calculation of Total GRN Value
 	var exciseDuty=isNaN(parseFloat((window.opener.document.getElementById('exciseDuty').value).trim()))==true?"0":parseFloat((document.getElementById('exciseDuty').value).trim());
	var freightDuty=isNaN(parseFloat(window.opener.document.getElementById('freightDuty').value.trim()))==true?"0":parseFloat(document.getElementById('freightDuty').value.trim());
	var octroi=isNaN(parseFloat(window.opener.document.getElementById('octroi').value.trim()))==true?"0":parseFloat(document.getElementById('octroi').value.trim());
	var insuranceCharges=isNaN(parseFloat(window.opener.document.getElementById('insuranceCharges').value.trim()))==true?"0":parseFloat(document.getElementById('insuranceCharges').value.trim());
	var otherCharges=isNaN(parseFloat(window.opener.document.getElementById('otherCharges').value.trim()))==true?"0":parseFloat(document.getElementById('otherCharges').value.trim());
	var customDuty= isNaN(parseFloat(window.opener.document.getElementById('customDuty').value.trim()))==true?"0":parseFloat(document.getElementById('customDuty').value.trim());

	var tempNetValue = parseFloat(0);
	var charge = parseFloat(0);
	var vat = parseFloat(0);
	var temp = 0;
	for(i=1;i<=window.opener.document.getElementById('poListSize').value;i++)
	{
	if(window.opener.document.getElementById('idItem'+i)){
		if(window.opener.document.getElementById('idItem'+i).value.trim()!=0)
		{
		 	var freeItem = window.opener.document.getElementById('freeItem'+i).value;
			if (freeItem=='n')
				tempNetValue=parseFloat(tempNetValue)+parseFloat(window.opener.document.getElementById('amtVar'+i).value);
		}
	}
	}
	// Update Cost Price of All Items in the Grid
	// (Duty + VAT) / Total Amt in Grid * Row Amount = Additional Tax
	// Row Amount = Row Amount + Additional Tax
	// Item Cost Price = Row Amount / Converted Stock

	charge = parseFloat(freightDuty) + parseFloat(exciseDuty) + parseFloat(octroi) + parseFloat(insuranceCharges) + parseFloat(otherCharges) + parseFloat(customDuty);
	var vat = isNaN(parseFloat(window.opener.document.getElementById('vatTax').value))==true?"0":parseFloat(document.getElementById('vatTax').value);
	var vatPer = isNaN(parseFloat(window.opener.document.getElementById('vatTaxPercentage').value))==true?"0":parseFloat(document.getElementById('vatTaxPercentage').value);
	var totDiscount = isNaN(parseFloat(window.opener.document.getElementById('totDiscount').value))==true?"0":parseFloat(document.getElementById('totDiscount').value);
	var vatApplicable = window.opener.document.getElementById('vatApplicable');
	if (vatApplicable.checked == false)
		charge = parseFloat(charge) + parseFloat(vat);

	charge = parseFloat(charge) - parseFloat(totDiscount);
	var rowAmt = parseFloat(0);
	var additionalTax = parseFloat(0);
	var convertedStock = parseFloat(0);
	var costPrice = parseFloat(0);
	//new var for storing previously Updated amount in rows
	var tempRowAmountValues = parseFloat(0);
	for(i=1;i<=window.opener.document.getElementById('poListSize').value;i++)
	{
		if(window.opener.document.getElementById('idItem'+i)){
		if(window.opener.document.getElementById('idItem'+i).value.trim()!=0)
		{
		    rowAmt = isNaN(parseFloat(window.opener.document.getElementById('amtVar'+i).value))==true?0:parseFloat(window.opener.document.getElementById('amtVar'+i).value);

		    if (parseFloat(tempNetValue) > 0 && parseFloat(rowAmt) > 0)
		 		additionalTax = (parseFloat(charge) / parseFloat(tempNetValue)) * parseFloat(rowAmt);

		 	rowAmt = rowAmt + additionalTax;
		 	tempRowAmountValues=tempRowAmountValues+rowAmt;
		 	//updated by shailesh
		// document.getElementById('amtVar'+i).value = roundVal(rowAmt,2);
		//updation finish
		 	convertedStock = isNaN(parseFloat(window.opener.document.getElementById('convertedStock'+i).value))==true?"0":parseFloat(window.opener.document.getElementById('convertedStock'+i).value);
		 	if (convertedStock > 0)
		 		costPrice = parseFloat(rowAmt) / parseFloat(convertedStock);
		 	else
		 		costPrice = parseFloat(0);
		 	window.opener.document.getElementById('costPrice'+i).value = roundVal(costPrice,3);
		}
		}
	}

	//Calculate Total Amount
	tempNetValue = parseFloat(0);

	for(i=1;i<=window.opener.document.getElementById('poListSize').value;i++)
	{
		if(window.opener.document.getElementById('idItem'+i)){
		if(window.opener.document.getElementById('idItem'+i).value.trim()!=0)
		{
		 	var freeItem = window.opener.document.getElementById('freeItem'+i).value;
	         if (freeItem=='n')
		     tempNetValue=parseFloat(tempNetValue)+parseFloat(window.opener.document.getElementById('amtVar'+i).value);

		}
		}
	}


	//document.getElementById('grnValue').value=roundVal(tempNetValue,2);
	//updatedby shailesh
	/*var actualValue=roundVal(tempNetValue,2);
	var valueAfterRounding=roundNumber(tempNetValue,0);
	*/
	var actualValue=roundVal(tempRowAmountValues,2);
	var valueAfterRounding=roundNumber(tempRowAmountValues,0);

	var roundOffAmount  = valueAfterRounding-actualValue;

	if (vatApplicable.checked){
	var vat = parseFloat(0);
	 vat = window.opener.document.getElementById('vatTax').value;
	var vatgrn = parseFloat(0);
	if(vat == ""){
	vat = parseFloat(0);
	}
	 var vatgrn1 = parseFloat(valueAfterRounding)+parseFloat(vat);

	vatgrn=roundVal(vatgrn1,0);
	roundOffAmount=vatgrn1-vatgrn;

    window.opener.document.getElementById('grnValue').value =vatgrn;

	}else{
  	window.opener.document.getElementById('grnValue').value=valueAfterRounding;
	}

	//document.getElementById('grnValue').value=valueAfterRounding
	roundOffAmount=roundVal(roundOffAmount,3);
	window.opener.document.getElementById('roundOfValue').value=roundOffAmount;



	window.opener.document.getElementById('actualGrnValue').value=actualValue;
}


</script>
