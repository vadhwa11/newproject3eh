<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * update_Local_Purchase.jsp  
 * Purpose of the JSP -  This is for Update Local Purchase.
 * @author  Abha Agarwal
 * Create Date: 07/04/2008
 * Revision Date:      
 * Revision By:  
 * @version 1.7
--%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugT"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.StoreCopyAddressList"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock;"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
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
 var nameArray=new Array();
 var itemsArray1=new Array();
 var itemsArray2 = new Array();
 var manufacturerArray = new Array();
  var brandArray = new Array();
  
 function fillValuesInDefectiveDrug(inc)
  {

  	 	var quanRec = "quanRec";
  	 	authyDec = "authyDec";
  	 	var disposal ="disposal";
  	 	var remarks = "remarks";
    
    	var quanRecTemp = "quanRecTemp";
    	var authyDecTemp = "authyDecTemp";
  	 	var disposalTemp ="disposalTemp";
  	 	remarksTemp = "remarksTemp";
    	
    	
    	
    	document.getElementById(quanRec+inc).value=document.getElementById(quanRecTemp+inc).value
    	document.getElementById(authyDec+inc).value=document.getElementById(authyDecTemp+inc).value
    	if(document.getElementById(disposal+inc).value  != "" ){
    	document.getElementById(disposal+inc).value=document.getElementById(disposalTemp+inc).value
    	}else{
    	document.getElementById(disposal+inc).value=0;
    	}
    	if(document.getElementById(remarks+inc).value  != "" ){
    	document.getElementById(remarks+inc).value=document.getElementById(remarksTemp+inc).value
    	}else{
    	document.getElementById(remarks+inc).value=0;
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
 function getManufacturerNameByAjax(brandId,rowVal){
 
 
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
      if(xmlHttp.readyState==4){
      
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
	        var mId  = item.getElementsByTagName("mId")[0];
        	document.getElementById('manufacturerId'+rowVal).value = manufacturerName.childNodes[0].nodeValue
        	document.getElementById('manufacturerIdTemp'+rowVal).value = mId.childNodes[0].nodeValue
        	
      	} 
      }
    }
     url="stores?method=getManufacturerNameInAjax&brandId="+brandId;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    
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
	        var mId  = item.getElementsByTagName("mId")[0];
	       
        	document.getElementById('expiryDate'+rowVal).value = expiryDate.childNodes[0].nodeValue
        	document.getElementById('expiryDateTemp'+rowVal).value = expiryDate.childNodes[0].nodeValue
        	
      	} 
      }
    }
     url="stores?method=getExpiryDateInAjax&batchId="+batchId;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    
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

<script language="javascript">

function checkForDefectiveDrugs(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   document.getElementById("batchId"+inc).length=0;
	    
	   
		ajaxFunctionForAutoCompleteInDefectiveDrugsNew('poMain','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
		
}
 function deleteDefectiveDrug(){
 if (document.purchaseGrid.itemsToBeDeleted.length)
	{
			 for(var i = 0; i < document.purchaseGrid.itemsToBeDeleted.length; i++)
			 {
			 var cnt=parseInt(i)+1;
			  if (document.getElementById("itemsToBeDeleted"+cnt).checked == true)
			  {
			 document.getElementById("itemIds"+cnt).value=  document.getElementById("idItem"+cnt).value;
		 	document.getElementById("batchNos"+cnt).value	= document.getElementById("batchId"+cnt).value;
		 	 document.getElementById("manufacturerIds"+cnt).value=	 document.getElementById("manufacturerId"+cnt).value;
		 	  document.getElementById("expiryIds"+cnt).value= document.getElementById("expiryDate"+cnt).value;
		 	
             	}
			 }
	
		submitForm('purchaseGrid','stores?method=deleteDefectiveDrug');
			
		
	}
	
 else{
 
 alert("No Items To Delete....");
 }

}
</script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> purchaseMap = new HashMap<String, Object>();
	String noDetailRecords="no";
	String previousPage = "no";
	int pageNo = 1;
	int entryId = 0;
	
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	
	List<StoreDefectiveDrugT> gridDefectiveDrugTList = new ArrayList<StoreDefectiveDrugT>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

	
	if(map.get("entryId")!=null){
		entryId = Integer.parseInt(""+map.get("entryId"));
	}
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}

	if (map.get("gridDefectiveDrugTList") != null) {
		gridDefectiveDrugTList = (List<StoreDefectiveDrugT>)map.get("gridDefectiveDrugTList");
	}
	List<StoreDefectiveDrugM> defectiveList= new ArrayList<StoreDefectiveDrugM>();
	List<StoreItemBatchStock> gridStoreItemBatchStockList= new ArrayList<StoreItemBatchStock>();
	
	if (map.get("gridStoreItemBatchStockList") != null) {
		gridStoreItemBatchStockList = (List<StoreItemBatchStock>)map.get("gridStoreItemBatchStockList");
	}
	if (map.get("defectiveList") != null) {
		defectiveList = (List<StoreDefectiveDrugM>)map.get("defectiveList");
	}
	List<StoreCopyAddressList> copyList = new ArrayList<StoreCopyAddressList>();
	if(map.get("copyList")!=null)
		copyList = (List) map.get("copyList");
	if (map.get("purchaseMap") != null) {
		purchaseMap = (Map<String, Object>)map.get("purchaseMap");
	}
	List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
	if(map.get("manufacturerList")!=null)
		manufacturerList = (List) map.get("manufacturerList");
	
	
	if(purchaseMap.get("itemList")!=null){
		itemList = (List<MasStoreItem>) purchaseMap.get("itemList");
	}
	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
	}
	List<StoreDefectiveDrugM> searchDrugList= new ArrayList<StoreDefectiveDrugM>();
	if(purchaseMap.get("searchDrugList")!=null)
		searchDrugList = (List) purchaseMap.get("searchDrugList");
	
	
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	String time="";
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
%>


<form name="poMain" method="post">

<div class="titleBg">
<h2>View Defective Drug</h2>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Modify" type="submit" value="Update"	class="button"	onClick="submitForm('poMain','stores?method=updateDefectiveDrug');">
<input	type="button" class="button" name="<%=CREATE_ADJUSTMENT %>"	value="Adjust"	onclick="submitFormForButton('purchaseGrid','stores?method=createAdjustment');" />
<input type="button" name="print" type="submit" class="button"	value="Print"	onClick="submitForm('purchaseGrid','stores?method=showDefectiveDrugReportJsp');">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</td>

<div class="clear"></div>

<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<form name="searchPanel" action="" method="post">
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" /> <input type="hidden"
	name="searchthread" value="1" /> <input type="hidden" name="showposts"
	value="1" /> <input type="hidden" name="searchthreadid" value="85875" />
<label>From Date </label> 
<input type="text" name="<%=FROM_DATE%>"	value="" validate="From Date,dateOfAdmission,no" MAXLENGTH="30" /> 
<img	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.poMain.<%=FROM_DATE%>,event)" />
<div class="clear"></div>
<label>To Date </label> 
<input type="text" name="<%=TO_DATE%>" value=""	class="textbox_date" validate="To Date,dateOfAdmission,no"	MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	tabindex="1"	onClick="setdate('<%=currentDate%>',document.poMain.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label class="bodytextB_blue">Defective Drug No</label> 
<select
	name="<%=ENTRY_NO%>">
	<%
					for (StoreDefectiveDrugM storeDefectiveDrugM :searchDrugList ) {
				%>

	<option value=<%=storeDefectiveDrugM.getEntryNo()%>><%=storeDefectiveDrugM.getEntryNo()%></option>

	<%
					}
				%>

</select> 
 <div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="image" class="button"	onClick="submitForm('poMain','stores?method=searchDefectiveDrug');" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
</div>




<form name="purchaseGrid" method="post">


<div class="Block">
<%if(previousPage.equals("no")){ %> <input type="hidden" name="pageNo"
	value="<%=pageNo%>" /> <%
	List<StoreDefectiveDrugM> gridDefectiveDrugMList = new ArrayList<StoreDefectiveDrugM>();
	StoreDefectiveDrugM defectiveDrugMObj = null;
	if(map.get("gridDefectiveDrugMList") != null){
		gridDefectiveDrugMList = (List<StoreDefectiveDrugM>)map.get("gridDefectiveDrugMList");
	}
	if(gridDefectiveDrugMList.size() > 0){
		defectiveDrugMObj = (StoreDefectiveDrugM)gridDefectiveDrugMList.get(0);
		entryId = defectiveDrugMObj.getId();
	}
		
	%> <input type="hidden" name="totalRecords"
	value="<%=gridDefectiveDrugTList.size() %>" />
<div class="clear"></div>

<label>Entry Number</label> <% if(defectiveDrugMObj != null){ %> <input
	type="text" name="<%= ENTRY_NO %>"
	value="<%=defectiveDrugMObj.getEntryNo()%>" class="readOnly"
	readonly="readonly" validate="P.O. Number ,String,yes" tabindex=1 /> <%}else{ %>
<input type="text" name="<%= ENTRY_NO %>" value=""
	validate="Entry Number ,String,yes" tabindex=1 /> <%} %> 
	<label>Entry Date </label> 
	<% if(defectiveDrugMObj != null){ %> <input type="text"
	name="<%= ENTRY_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(defectiveDrugMObj.getEntryDate() )%>"
	class="readOnly" readonly="readonly" tabindex=1
	validate="Entry Date ,dateOfAdmission,no" /> <%}else{ %> <input
	type="text" name="<%= ENTRY_DATE %>" value="" tabindex=1 /> <%} %>
<div class="clear"></div>

<label>To Place</label> <%if(defectiveDrugMObj != null){ %> <textarea
	value="<%=defectiveDrugMObj.getToPlace()%>" name="<%=TO_PLACE %>"
	validate="To Place,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 500px;" maxlength="250" /> </textarea> <%}else{ %> <textarea value=""
	name="<%=TO_PLACE %>" validate="To Place,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 500px;" maxlength="250" /> </textarea> <%} %> <label>From
Store</label> <%if(gridDefectiveDrugTList!=null&&gridDefectiveDrugTList.size()>0){ %>
<input type="text" name="<%=FROM_STORE %>"
	value="<%=gridDefectiveDrugTList.get(0).getDefectM().getToPlace()==null?"":gridDefectiveDrugTList.get(0).getDefectM().getToPlace()%>"
	id="<%=FROM_STORE %>" readonly="readonly" class="readOnly"
	MAXLENGTH="18"/  > <%}else{ %> <input type="text"
	name="<%=FROM_STORE %>" value="" id="<%=FROM_STORE %>"
	readonly="readonly" class="readOnly" MAXLENGTH="18"/  > <%} %>

<div class="clear"></div>
<%
	} %> <input type="hidden" name="<%=NO_DETAIL_RECORDS%>"
	value="<%=noDetailRecords%>" /> <input type="hidden" size="2"
	value="0" name="<%=NO_OF_ROWS %>" id="noOfRows" /> <input
	type="hidden" name="<%=ENTRY_ID %>" value="<%=entryId %>" id="hdb" />
<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input
	type="hidden" name="storeDefectiveDrugMId" id="storeDefectiveDrugMId"
	value="<%=defectiveList.get(0).getId() %>"></div>
<div class="clear"></div>
<h4>Defective Drugs Detail</h4>
<div class="clear"></div>
<div class="cmntable">
<table width="98%" colspan="7" id="grnDetails" class="scrollTable">
	<thead class="fixedHeader headerFormat">
		<tr>

			<th width="5%">S.No.</th>
			<th width="8%">Item Name</th>
			<th width="9%">Item Code</th>

			<th width="9%">Batch</th>
			<!-- <th width="9%">Brand Name</th> -->
			<th width="9%">Manufacturer</th>
			<th width="9%">UOM</th>
			<th width="9%">Expiry Date</th>
			<th width="9%">Quantity</th>
			<th width="9%">Remarks</th>
			<th width="6%">Delete</th>


		</tr>

	</thead>
	<tbody class="scrollContent bodyFormat">

		<%
  		int detailCounter=30; 
   	int rowVal=0;
    	int temp=0;
    	String expiryIds="expiryIds";
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String quantityInVar="quantityInVar";
    	String taxVar="taxVar";
    	String unitRateVar="unitRateVar";
    	String amountVar = "amountVar";
    	String discountVar="discountVar";
    	String authyDec = "authyDec";
    	String disposal="disposal";
    	String disposalTemp ="disposalTemp";
    	String remarks="remarks";
    	String remarksTemp="remarksTemp";
    	String quanRec="quanRec";
    	String quanRecTemp="quanRecTemp";
    	String expiryDateTemp ="expiryDateTemp";
    	String expiry ="expiry";
    	String manufacturerIdTemp ="manufacturerIdTemp";
    	String manufacturerIds="manufacturerIds";
    	String quantityInVarTemp="quantityInVarTemp";
    	String taxVarTemp="taxVarTemp";
    	String unitRateVarTemp="unitRateVarTemp";
    	String amountVarTemp = "amountVarTemp";
    	String discountVarTemp="discountVarTemp";
    	String authyDecTemp = "authyDecTemp";
    	String incVar="incVar";
    	String batchNos="batchNos";
    	String itemIds="itemIds";
    	String freeQty="freeQty";
    	String amount="amount";
    	String manufacturerId="manufacturerId";
    	String brandId="brandId";
    	String freeItem="freeItem";
    	String expiryDate="expiryDate";
    	String batchId ="batchId";
    	String itemsToBeDeleted="itemsToBeDeleted";
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
	   	String quantityInVar2="quantityInVar";
    	String taxVar2="taxVar";
    	String unitRateVar2="unitRateVar";
    	String amountVar2 = "amountVar";
    	String discountVar2="discountVar";
    	String authyDecTemp2 = "authyDecTemp";
    	String expiryDateTemp2="expiryDateTemp";
    	String manufacturerIdTemp2="manufacturerIdTemp";
    	String expiryDate2="expiryDate";
    	String freeQty2="freeQty";
    	String amount2="amount";
    	String manufacturerId2="manufacturerId";
    	String brandId2="brandId";
    	String freeItem2="freeItem";
    	
    	String authyDec2= "authyDec";
    	
    	
    	String quantityInVarTemp2="quantityInVarTemp";
    	String taxVarTemp2="taxVarTemp";
    	String unitRateVarTemp2="unitRateVarTemp";
    	String amountVarTemp2 = "amountVarTemp";
    	String discountVarTemp2="discountVarTemp";
    	String incVar2="incVar2";
    	
    	String disposal2="disposal";
    	String disposalTemp2 ="disposalTemp";
    	String remarks2="remarks";
    	String remarksTemp2="remarksTemp";
    	String quanRec2 ="quanRec";
    	String quanRecTemp2 ="quanRecTemp";
    	String batchId2 ="batchId";
    	String date3="";
		String date1[]=null;
		String day="";
		String month="";
		String year="";
		String storedExpiryDate="";
    	
    	if(previousPage.equals("no")){ 
			int inc=((pageNo-1)*30)+1;
	    	   int incTemp2=inc+30;
	    	   int row =0;
	    	   
	    	   for(StoreDefectiveDrugT storeDefectiveDrugT : gridDefectiveDrugTList){
	    		if(inc<incTemp2){
	    			row++;
   %>

		<%
    	
   date3=HMSUtil.convertDateToStringWithoutTime(storeDefectiveDrugT.getExpiryDate());
	
	
	
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		
     		taxVar=taxVar2+(""+inc);
     		unitRateVar=unitRateVar2+(""+inc);
     		amountVar=amountVar2+(""+inc);
     		discountVar=discountVar2+(""+inc);

     		freeQty=freeQty2+(""+inc);     		
     		freeItem=freeItem2+(""+inc);
     		amount=amount2+(""+inc);
     		manufacturerId=manufacturerId2+(""+inc);
     		brandId=brandId2+(""+inc);
     		expiryDate = expiryDate2+(""+inc);
     		authyDec = authyDec2+(""+inc);
     		
     		taxVarTemp=taxVarTemp2+(""+inc);
     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
     		amountVarTemp=amountVarTemp2+(""+inc);
     		discountVarTemp=discountVarTemp2+(""+inc);
     		authyDecTemp = authyDecTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		
     	 	disposal=disposal2+(""+inc);
        	disposalTemp =disposalTemp2+(""+inc);
       		remarks=remarks2+(""+inc);
        	remarksTemp=remarksTemp2+(""+inc);
        	quanRec=quanRec2+(""+inc);
        	quanRecTemp=quanRecTemp2+(""+inc);
        	expiryDateTemp= expiryDateTemp2+(""+inc);
        	manufacturerIdTemp =manufacturerIdTemp2+(""+inc);
        	batchId=batchId2+(""+inc);
    %>
		<tr>

			<td width="5%"><input type="text" size="2" value="<%=row%>"
				name="<%=SR_NO%>" readonly="readonly" /></td>


			<td width="10%"><input type="text"
				value="<%=storeDefectiveDrugT.getItem().getNomenclature() %>"
				id="<%=nameItem%>"
				onblur="if(('<%=inc %>')){checkForDefectiveDrugs(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
		</script></td>
			<td width="10%">
			<%if(storeDefectiveDrugT.getItem().getPvmsNo()!=null){ %> <input
				type="text" value="<%=storeDefectiveDrugT.getItem().getPvmsNo() %>"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <input
				type="hidden" size="2"
				value="<%=storeDefectiveDrugT.getItem().getId() %>"
				class="smcaption" name="<%=ITEM_ID%>" id="<%=idItem%>" /> <%}else{ %>
			<input type="text" value=" " name="<%=ITEM_CODE %>"
				readonly="readonly" id="<%=codeItem%>" /> <input type="hidden"
				size="2" value="0" class="smcaption" name="<%=ITEM_ID%>"
				id="<%=idItem%>" /> <%} %> <input type="hidden"
				name="<%=DETAIL_ID %>" value="<%=storeDefectiveDrugT.getId() %>"
				id="hdb" /></td>


			<td width="10%">
			<%if(storeDefectiveDrugT.getBatchNo()!=null){ %> <select
				name="<%=BATCH_ID%>" id="<%=batchId%>"
				onchange="getExpiryDateByAjax(this.value,<%=inc%>);" tabindex="1">
				<option value="<%=gridStoreItemBatchStockList.get(row-1).getId() %>"><%=storeDefectiveDrugT.getBatchNo() %></option>
			</select> <%}else{ %> <select name="<%=BATCH_ID%>" id="<%=batchId%>"
				onchange="getExpiryDateByAjax(this.value,<%=inc%>);" tabindex="1">
				<option value="0">Select Batch No</option>
			</select> <%} %>
			</td>
			<%--   <td width="10%">
          <%if(storeDefectiveDrugT.getBrand() != null){%>
      <input type="text" value="<%=storeDefectiveDrugT.getBrand().getBrandName() %>" name="<%=BRAND_ID %>" id="<%=brandId %>"/>
      <%}else{ %>
      <input type="hidden" value="0" name="<%=BRAND_ID %>" id="<%=brandId %>"/>
      <%} %>
      </td> --%>
			<td width="10%">
			<%if(storeDefectiveDrugT.getManufacturedBy() != null){%> <select
				name="<%=MANUFACTURER_ID%>" id="<%=manufacturerId%>" tabindex="1">
				<option
					value="<%=storeDefectiveDrugT.getManufacturedBy().getId() %>"><%=storeDefectiveDrugT.getManufacturedBy().getManufacturerName() %></option>
			</select> <%}else{ %> <select name="<%=MANUFACTURER_ID%>"
				id="<%=manufacturerId%>" tabindex="1">
				<option value="0">Select Manufacturer--</option>
			</select> <input type="hidden" value="0" name="<%=MANUFACTURER_ID %>"
				id="<%=manufacturerId%>" /> <%} %>
			</td>
			<td width="10%"><input type="text"
				value="<%=storeDefectiveDrugT.getItem()!= null && storeDefectiveDrugT.getItem().getItemConversion()!= null?storeDefectiveDrugT.getItem().getItemConversion().getItemUnitName():"" %>"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>
			<td width="10%">
			 <%if(storeDefectiveDrugT.getExpiryDate() != null){%>
			<input type="text" value="<%=date3 %>" name="<%=EXPIRY_DATE %>"
				id="<%=expiryDate %>" /> <%}else{ %> <input type="hidden" value="0"
				name="<%=EXPIRY_DATE %>" id="<%=expiryDate%>" /> <%} %>
			</td>

			<td width="10%"><input type="text"
				value="<%= storeDefectiveDrugT.getDefectQty()%>" name="qty"
				id="<%=quanRecTemp%>" /> <input type="hidden"
				value="<%=storeDefectiveDrugT.getDefectQty()%>"
				name="<%=QUANTITY_RECEIVED%>" id="<%=quanRec%>" /></td>
			<!--
      
       
      
      <td width="3%">
      <input type="text" value="<%=storeDefectiveDrugT.getAuthyUnderDeclared() %>" name="" tabindex="2" id="<%=authyDecTemp%>" />
      <input type="hidden"  value="<%=storeDefectiveDrugT.getAuthyUnderDeclared() %>" name="<%=AUTHORITY%>" tabindex="2" id="<%=authyDec%>"/>
      </td>
      
      <td width="3%">
      <input type="text"  value="<%=storeDefectiveDrugT.getDisposal() %>" name="" tabindex="2" id="<%=disposalTemp%>" />
        <%// if(!storeDefectiveDrugT.getDisposal().equals("")){%>
      <input type="hidden"  value="<%=storeDefectiveDrugT.getDisposal() %>" name="<%=DISPOSAL%>" tabindex="2" id="<%=disposal%>"/>
      <%//}else{ %>
      <input type="hidden" value="emptyString1" " name="<%=DISPOSAL %>" tabindex="1" id="<%=disposal%>"/>
      <%//} %>
      </td>
     
      -->
			<td width="3%"><input type="text"
				value="<%=storeDefectiveDrugT.getRemarks() %>" name="" tabindex="2"
				id="<%=remarksTemp%>" /> <% if(!storeDefectiveDrugT.getRemarks().equals("")){%>
			<input type="hidden" value="<%=storeDefectiveDrugT.getRemarks() %>"
				name="<%=REMARKS%>" tabindex="2" id="<%=remarks%>" /> <%}else{ %> <input
				type="hidden" value="emptyString2" name="<%=REMARKS%>" tabindex="2"
				id="<%=remarks%>" /> <%} %>
			</td>
			<td width="6%"><input type="checkbox" name="itemsToBeDeleted"
				id="<%=itemsToBeDeleted+inc%>" /> <input type="hidden"
				name="batchNos" id="<%=batchNos+inc %>"><input type="hidden"
				name="itemIds" id="<%=itemIds+inc %>"><input type="hidden"
				name="manufacturerIds" id="<%=manufacturerIds+inc %>"><input
				type="hidden" name="expiryIds" id="<%=expiryIds+inc %>"></td>




		</tr>
		<% inc++;
	rowVal=inc;
     	 }
     	 }
	    	   %>
		<script>
	    	   
	    	 document.purchaseGrid.noOfRows.value=<%=inc-((pageNo-1)*30)-1%>
	    	 </script>

		<%
	    	detailCounter=30; 
	       	temp=0;
	    	idItem="idItem";
	    	authyDecTemp="authyDecTemp";
	    	codeItem="codeItem";
	    	nameItem="nameItem";
	    	idAu="idAu";
	    	quantityInVar="quantityInVar";
	    	taxVar="taxVar";
	    	unitRateVar="unitRateVar";
	    	amountVar="amountVar";
	    	discountVar="discountVar";
	    	expiryDateTemp="expiryDateTemp";
	    	 quanRecTemp="quanRecTemp";
	    	quantityInVarTemp="quantityInVarTemp";
	    	taxVarTemp="taxVarTemp";
	    	unitRateVarTemp="unitRateVarTemp";
	    	amountVarTemp = "amountVarTemp";
	    	discountVarTemp="discountVarTemp";
	    	incVar="incVar";
	    	remarksTemp="remarksTemp";
	    	remarksTemp2="remarksTemp";
	    	freeQty="freeQty";
	    	amount="amount";
	    	manufacturerId="manufacturerId";
	    	brandId="brandId";
	    	freeItem="freeItem";
	    	batchId="batchId";
	    	disposalTemp="disposalTemp";
	    	idItem2="idItem";
	    	codeItem2="codeItem";
	    	nameItem2="nameItem";
	    	idAu2="idAu";
		   	quantityInVar2="quantityInVar";
	    	taxVar2="taxVar";
	    	unitRateVar2="unitRateVar";
	    	amountVar2 = "amountVar";
	    	discountVar2="discountVar";
	    	expiryDate2="expiryDate";
	    	freeQty2="freeQty";
	    	remarks="remarks";
	    	remarks2="remarks";
	    	amount2="amount";
	    	manufacturerId2="manufacturerId";
	    	brandId2="brandId";
	    	authyDec="authyDec";
	    	authyDec2="authyDec";
	    	authyDecTemp2="authyDecTemp";
	    	freeItem2="freeItem";
	    	disposal="disposal";
	    	disposal2="disposal";
	    	disposalTemp2="disposalTemp";
	    	quantityInVarTemp2="quantityInVarTemp";
	    	taxVarTemp2="taxVarTemp";
	    	unitRateVarTemp2="unitRateVarTemp";
	    	amountVarTemp2 = "amountVarTemp";
	    	discountVarTemp2="discountVarTemp";
	    	incVar2="incVar2";
	    	quanRec="quanRec";
	    	quanRec2="quanRec";
	    	 quanRecTemp2="quanRecTemp";
	    	expiryDateTemp2="expiryDateTemp" ;
	    	batchId2="batchId";
	    		  if(inc<incTemp2){
	    			  for(;inc<incTemp2;inc++){
	    				  row++;
	    				  idItem=idItem2+(""+inc);
	    		     		codeItem=codeItem2+(""+inc);
	    		     		nameItem=nameItem2+(""+inc);
	    		     		idAu=idAu2+(""+inc);
	    		     		authyDecTemp=authyDecTemp2+(""+inc);
	    		     		quantityInVar=quantityInVar2+(""+inc);
	    		     		taxVar=taxVar2+(""+inc);
	    		     		unitRateVar=unitRateVar2+(""+inc);
	    		     		amountVar=amountVar2+(""+inc);
	    		     		discountVar=discountVar2+(""+inc);
	    		     		quanRec=quanRec2+(""+inc);
	    		     		authyDec=authyDec2+(""+inc);
	    		     		freeQty=freeQty2+(""+inc);     		
	    		     		freeItem=freeItem2+(""+inc);
	    		     		amount=amount2+(""+inc);
	    		     		disposal=disposal2+(""+inc);
	    		     		remarks=remarks2+(""+inc);
	    		     		remarksTemp=remarksTemp2+(""+inc);
	    		     		manufacturerId=manufacturerId2+(""+inc);
	    		     		brandId=brandId2+(""+inc);
	    		     		disposalTemp=disposalTemp2+(""+inc);
	    		     		quantityInVarTemp=quantityInVarTemp2+(""+inc);
	    		     		taxVarTemp=taxVarTemp2+(""+inc);
	    		     		unitRateVarTemp=unitRateVarTemp2+(""+inc);
	    		     		amountVarTemp=amountVarTemp2+(""+inc);
	    		     		discountVarTemp=discountVarTemp2+(""+inc);
	    		     		incVar=incVar2+(""+inc);
	    		     		expiryDateTemp =expiryDateTemp2+(""+inc);
	    		     		expiryDate=expiryDate2+(""+inc);
	    		     		quanRecTemp=quanRecTemp2+(""+inc);
	    		     		batchId=batchId2+(""+inc);
	    			  %>
		<tr>

			<td width="5%"><input type="text" size="2" value="<%=row%>"
				name="<%=SR_NO%>" readonly="readonly" /></td>

			<td width="10%"><input type="text" value="" id="<%=nameItem%>"
				onblur="if(('<%=inc %>')){checkForDefectiveDrugs(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
		</script></td>
			<td width="10%"><input type="text" name="<%=ITEM_CODE %>"
				readonly="readonly" id="<%=codeItem%>" /> <input type="hidden"
				size="2" value="0" name="<%=ITEM_ID%>" id="<%=idItem%>" /></td>

			<td width="10%"><select name="<%=BATCH_ID%>" id="<%=batchId%>"
				onchange="getExpiryDateByAjax(this.value,<%=inc%>);" tabindex="1">
				<option value="0">Select</option>
			</select></td>
			<%-- 
      <td width="10%">
       <select name="<%=BRAND_ID%>"  id="<%=brandId%>" onchange="getManufacturerNameByAjax(this.value,<%=inc%>);" tabindex="1">
	  <option value="0">Select</option>
      </select>
	</td>--%>

			<td width="10%"><select name="<%=MANUFACTURER_ID%>"
				id="<%=manufacturerId%>" tabindex="1">
				<option value="0">Select</option>
			</select> <input type="hidden" name="<%=MANUFACTURER_ID %>" value="0"
				id="<%=manufacturerIdTemp %>" tabindex="1" /></td>
			<td width="10%"><input type="text" value="" readonly="readonly"
				name="<%=AV%>" id="<%=idAu%>" /> <input type="hidden" value="0"
				name="<%=EXPIRY%>" id="<%=expiry%>" /></td>
			<td width="10%"><input type="text" id="<%=expiryDate %>"
				name="<%=expiryDate %>" value=""
				onblur="fillExpForDefectiveDrug(<%=inc%>)" /> <input type="hidden"
				value="abc" id="<%=expiryDateTemp %>" name="<%=EXPIRY_DATE%>"
				tabindex="1" /></td>

			<td width="10%"><input type="text" value="" name="qty"
				id="<%=quanRecTemp%>" onblur="fillQuanForDefectiveDrug(<%=inc%>)"
				tabindex="1" /> <input type="hidden" value="0"
				name="<%=QUANTITY_RECEIVED%>" id="<%=quanRec%>" tabindex="1" /></td>
			<!--
      
      
      
      
       <td width="10%">
      <input type="text" value=""  name="" id="<%=authyDecTemp%>" tabindex="1" maxlength="15" onblur="fillAuthyForDefectiveDrug(<%=inc%>)"/>
      <input type="hidden" value="0"  name="<%=AUTHY_UNDER_DECLARED %>" tabindex="1" id="<%=authyDec%>"/>
      </td>
      
      
       <td width="10%">
      <input type="text" value=""  name="" id="<%=disposalTemp%>" tabindex="1" maxlength="15" onblur="fillDisposalForDefectiveDrug(<%=inc%>)"/>
      <input type="hidden" value="emptyString1" " name="<%=DISPOSAL %>" tabindex="1" id="<%=disposal%>"/>
      </td>
       -->
			<td width="10%"><input type="text" value="" name=""
				id="<%=remarksTemp%>" tabindex="1" maxlength="15"
				onblur="fillValuesInDefectiveDrug(<%=inc%>);" /> <input
				type="hidden" value="emptyString2" name="<%=REMARKS %>" tabindex="1"
				id="<%=remarks%>" /></td>
			<td width="6%"><input type="checkbox" name="itemsToBeDeleted"
				id="<%=itemsToBeDeleted+inc%>" /> <input type="hidden"
				name="batchNos" id="<%=batchNos+inc %>"><input type="hidden"
				name="itemIds" id="<%=itemIds+inc %>"><input type="hidden"
				name="manufacturerIds" id="<%=manufacturerIds+inc %>"><input
				type="hidden" name="expiryIds" id="<%=expiryIds+inc %>"></td>
		</tr>


		<% }
	    		  }
     	    %>


		<%}//this is if(previousPage.equals("no")) end
       else{}%>
	</tbody>
</table>
</div>


<div class="clear"></div>

<%
	List<StoreDefectiveDrugM> gridDefectiveDrugMList = new ArrayList<StoreDefectiveDrugM>();
	if (map.get("gridDefectiveDrugMList") != null) {
		gridDefectiveDrugMList = (List<StoreDefectiveDrugM>)map.get("gridDefectiveDrugMList");
	}
	StoreDefectiveDrugM defectiveDrugMObj = null;
	if(gridDefectiveDrugMList.size() > 0){
		defectiveDrugMObj = (StoreDefectiveDrugM)gridDefectiveDrugMList.get(0);
		entryId = defectiveDrugMObj.getId();
	}
		
	%>




<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" />
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>