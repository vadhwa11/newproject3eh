<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifyBalance.jsp
 * Purpose of the JSP -  This is for indentBD.
 * @author  Mansi
 * Create Date: 21st Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>


<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreBalanceM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>

<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.StoreBalanceT"%>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<%
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}

	orderDateOnly.append("/");

	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}

	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage = "no";
	int pageNo = 1;
	String noDetailRecords = "no";
	List<StoreBalanceM> searchStoreBalanceMList = new ArrayList<StoreBalanceM>();
	List<StoreBalanceM> gridIndentMList = new ArrayList<StoreBalanceM>();
	List<StoreBalanceT> gridIndentTList = new ArrayList<StoreBalanceT>();
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
	List<MasEmployee> approvedByEmployeeList = new ArrayList<MasEmployee>();

	String maxBalanceNo = "";
	String date = "";
	String time = "";
	String userName = "";
	List objectList = new ArrayList();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	date = (String) utilMap.get("currentDate");
	time = (String) utilMap.get("currentTime");
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	//--------Hearder Variables-------
	String balanceNo = "";
	int balanceId = 0;
	String balanceDate = "";
	int approvedByEmployeeId = 0;
	//--------End -------- Hearder Variables-------

	if (request.getAttribute("map") != null)
		map = (Map) request.getAttribute("map");

	if (map.get("balanceNo") != null)
		balanceNo = "" + map.get("balanceNo");

	if (map.get("balanceId") != null)
		balanceId = Integer.parseInt("" + map.get("balanceId"));

	if (map.get("balanceDate") != null)
		balanceDate = "" + map.get("balanceDate");

	if (map.get("approvedByEmployeeId") != null)
		approvedByEmployeeId = Integer.parseInt(""
				+ map.get("approvedByEmployeeId"));

	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt("" + map.get("pageNo"));
	}
	if (map.get("max") != null)
		maxBalanceNo = ("" + map.get("max"));

	if (map.get("approvedByEmployeeList") != null)
		approvedByEmployeeList = (List) map
				.get("approvedByEmployeeList");

	if (map.get("objectList") != null)
		objectList = (List) map.get("objectList");

	if (map.get("brandList") != null)
		brandList = (List) map.get("brandList");

	if (map.get("approvedByEmployeeList") != null)
		approvedByEmployeeList = (List) map
				.get("approvedByEmployeeList");

	if (map.get("searchStoreBalanceMList") != null)
		searchStoreBalanceMList = (List) map
				.get("searchStoreBalanceMList");

	if (map.get("gridIndentMList") != null)
		gridIndentMList = (List) map.get("gridIndentMList");

	if (map.get("gridIndentTList") != null)
		gridIndentTList = (List) map.get("gridIndentTList");

	if (map.get("noDetailRecords") != null) {
		noDetailRecords = ("" + map.get("noDetailRecords"));

	}
%>
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


 function checkForIndentToDepot(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=start;i<=end;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""

	    	return false;
	    	}
	    }}
		ajaxFunctionForAutoAA('indent','stores?method=fillItemsForIndentToSOC&pvmsNo=' +  pvms , inc);
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
	return true;
}


  function fillValuesBalance(inc)
  {

    	var batchNoVar="batchNoVar";
    	var batchNoVarTemp="batchNoVarTemp";


    	var expDateVar="expDateVar";
    	var expDateVarTemp="expDateVarTemp";


    	var qtyVar="qtyVar";
    	var qtyVarTemp="qtyVarTemp";

    	var unitRateVar="unitRateVar";
    	var unitRateVarTemp="unitRateVarTemp";


    if(document.getElementById(batchNoVarTemp+inc).value!=""){
      		document.getElementById(batchNoVar+inc).value=document.getElementById(batchNoVarTemp+inc).value
     }
     else
      		document.getElementById(batchNoVar+inc).value="emptyString";


         if(document.getElementById(expDateVarTemp+inc).value!=""){
      		document.getElementById(expDateVar+inc).value=document.getElementById(expDateVarTemp+inc).value
     }
     else
      		document.getElementById(expDateVar+inc).value="emptyString";

       if(document.getElementById(qtyVarTemp+inc).value!=""){
      		document.getElementById(qtyVar+inc).value=document.getElementById(qtyVarTemp+inc).value
     }
     else
      		document.getElementById(qtyVar+inc).value="0";


      if(document.getElementById(unitRateVarTemp+inc).value!=""){
      		document.getElementById(unitRateVar+inc).value=document.getElementById(unitRateVarTemp+inc).value
     }
     else
      		document.getElementById(unitRateVar+inc).value="0";



  }

 function validateDateSOC( strValue ) {
  var objRegExp = /^\d{1,2}(\/)\d{1,2}\1\d{4}$/

  if(!objRegExp.test(strValue))
    return false;
  else{
    var strSeparator = strValue.substring(2,3)

    var arrayDate = strValue.split(strSeparator);
    var arrayLookup = { '01' : 31,'03' : 31, '04' : 30,'05' : 31,'06' : 30,'07' : 31,
                        '08' : 31,'09' : 30,'10' : 31,'11' : 30,'12' : 31}
var intDay = parseInt(arrayDate[0],10);


    if(arrayLookup[arrayDate[1]] != null) {
      if(intDay <= arrayLookup[arrayDate[1]] && intDay != 0)
        return true;
    }
var intMonth = parseInt(arrayDate[1], 10);

    if (intMonth == 2) {
       var intYear = parseInt(arrayDate[2]);
       if( ((intYear % 4 == 0 && intDay <= 29) || (intYear % 4 != 0 && intDay <=28)) && intDay !=0)
          return true;
       }
  }
  return false;
}
 function fillDate(inc)
  {
  if(validateDateSOC(document.getElementById('expDateVarTemp'+inc).value)){
  }else{
  document.getElementById('expDateVarTemp'+inc).value=""
  	alert("Invalid Date..!")
  	return false
  }
   	if(document.getElementById('expDateVarTemp'+inc).value!=""){
    	document.getElementById('expDateVar'+inc).value=document.getElementById('expDateVarTemp'+inc).value
    	}
  }

function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printOpeningBalanceJsp";
  obj.submit();
}

 </script>

<form name="indent" method="post">
<div class="titleBg">
<h2>Opening Balance-Modify</h2>
</div>
<div class="clear"></div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
<!-- <input type="button" name="Reset" type="submit" value="Reset" class="button" >
<input type="button" name="Delete" type="submit"  value="Delete" class="button" >
<input type="button" name="print" type="submit" class="button" value="Print" onClick="showReport('indentGrid');"> </td>
 -->
<div class="clear"></div>
<div class="paddingTop15"></div>

<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form name="searchPanel" method="post">
<div class="paddingTop40"></div>
<div class="clear"></div>
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" /> <input type="hidden"
	name="searchthread" value="1" /> <input type="hidden" name="showposts"
	value="1" /> <input type="hidden" name="searchthreadid" value="85875" />
<label>From Date :</label> <input type="text" name="<%=FROM_DATE%>"
	class="date" MAXLENGTH="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.indent.<%=FROM_DATE%>,true);" />
<label>To Date :</label> <input type="text" name="<%=TO_DATE%>"
	class="date" MAXLENGTH="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.indent.<%=TO_DATE%>,true);" />
<div class="clear"></div>
<label>Opening Balance No. :</label> <select
	name="<%=SEARCH_BALANCE_NO%>">
	<option value="0">Select</option>
	<%
		for (StoreBalanceM storeBalanceM : searchStoreBalanceMList) {
	%>

	<option value=<%=storeBalanceM.getBalanceNo()%>><%=storeBalanceM.getBalanceNo()%></option>

	<%
		}
	%>
</select> <input type="image" src="/hms/jsp/images/go.gif" class="button"
	onClick="submitForm('indent','stores?method=searchBalance');" />	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
</div>


<div class="clear"></div>

 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
<form name="indentGrid" method="post">
<div id="testDiv"></div>
<div class="Block"><input type="hidden" name="pageNo"
	value="<%=pageNo%>" id="pageNo" /> <input
	name="<%=NO_DETAIL_RECORDS%>" type="hidden"
	value="<%=noDetailRecords%>" /> <%
 	for (StoreBalanceM storeBalanceM : gridIndentMList) {
 %> <label>Opening Balance No. </label> <input type="text"
	name="<%=BALANCE_NO%>" tabindex=1
	value="<%=storeBalanceM.getBalanceNo()%>" readonly="readonly"
	class="readOnly" MAXLENGTH="8"/  ><label>Opening
Balance Date</label> <input type="text" name="<%=BALANCE_DATE%>" tabindex=1
	readonly="readonly"
	value="<%=HMSUtil.changeDateToddMMyyyy(storeBalanceM
						.getBalanceDate())%>"
	class="readOnly" MAXLENGTH="30" /> <label>Approved By</label> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_BALANCE%>" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasEmployee approvedBy : approvedByEmployeeList) {
				if (storeBalanceM.getApprovedBy().getId() == approvedBy
						.getId()) {
	%>

	<option value=<%=approvedBy.getId()%> selected="selected"><%=approvedBy.getFirstName()%>
	<%=approvedBy.getLastName()%></option>

	<%
		} else {
	%>
	<option value="<%=approvedBy.getId()%>"><%=approvedBy.getFirstName()%>
	<%=approvedBy.getLastName()%></option>
	<%
		}
			}
	%>
</select>

<div class="clear"></div>

<label>Remarks</label> <input type="text" name="<%=REMARKS%>"
	tabindex=1 value="<%=storeBalanceM.getRemarks()%>"
	class="textbox_size20" tabindex=3 /> <%
 	}
 %>
<div class="clear"></div></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<%--<input type="button" class="button" value="Next"  onclick="if(checkSave()&& checkForNext()){submitForm('indentGrid','stores?method=updateNextOrSubmitBalance&buttonName=next');}" align="right" /> --%>
<input type="button" name="sss" align="right" class="button"
	value="Update"
	onclick="if(checkSave()&& checkForSubmit()){submitForm('indentGrid','stores?method=updateNextOrSubmitBalance&buttonName=submit');}" />
<input type="hidden" id="modifyBalance" name="modifyBalance"
	value="modifyBalance">
<div id="pagination"><a
	onclick="if(checkSave()&& checkForNext()){submitForm('indentGrid','stores?method=updateNextOrSubmitBalance&buttonName=next');}"
	class="next">Next</a> <input type="button" name="Go Page" type="submit"
	class="button" value=" "
	onclick="if(checkSave()&& checkForNext()){submitForm('indentGrid','stores?method=updateNextOrSubmitBalance&buttonName=next');}"><input
	type="text" name="gopage" value="" size="3" /></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="hidden" name="" value="222" id="currentRow" /> <input
	type="hidden" size="2" value="0"
	name="<%=RequestConstants.NO_OF_ROWS%>"
	id="<%=RequestConstants.NO_OF_ROWS%>" /> <input type="hidden"
	name="<%=BALANCE_ID%>" value="<%=balanceId%>" id="balanceId" />


<h4>Balance Details</h4>

<div class="floatRight"><label class="auto">Page No. :</label><label
	class="auto"><span><%=pageNo%></span>&nbsp;&nbsp;&nbsp;</label></div>
<div class="clear"></div>
<div class="cmntable">
<table colspan="7" id="indentDetails" border="0" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>

			<th width="5%">S.No.</th>
			<th width="10%">Item Code</th>
			<th width="10%">Item Name</th>
			<th width="10%">UOM</th>
			<!-- <th width="10%">Brand Name      </th> -->
			<th width="10%">Manufacturer</th>
			<th width="5%">Batch No.</th>
			<th width="5%">Expriy Date(dd/mm/yyyy)</th>
			<th width="10%">Quantity</th>
			<th width="10%">Unit Rate</th>
			<th>Dispensing Price</th>
			<th>Mrp</th>
		</tr>

	</thead>
	<tbody>
		<%
			int inc = 1;
			int detailCounter = 8;
			int temp = 0;
			String idItem = "idItem";
			String codeItem = "codeItem";
			String nameItem = "nameItem";
			String idBrand = "idBrand";
			String nameManufacturer = "nameManufacturer";
			String idAu = "idAu";
			String brandId = "brandId";

			String batchNoVar = "batchNoVar";
			String expDateVar = "expDateVar";
			String qtyVar = "qtyVar";
			String unitRateVar = "unitRateVar";

			String batchNoVarTemp = "batchNoVarTemp";
			String expDateVarTemp = "expDateVarTemp";
			String qtyVarTemp = "qtyVarTemp";
			String unitRateVarTemp = "unitRateVarTemp";
			String incVar = "incVar";

			String brandId2 = "brandId";
			String idItem2 = "idItem";
			String codeItem2 = "codeItem";
			String nameItem2 = "nameItem";
			String idBrand2 = "idBrand";
			String nameManufacturer2 = "nameManufacturer";
			String idAu2 = "idAu";

			String batchNoVar2 = "batchNoVar";
			String expDateVar2 = "expDateVar";
			String qtyVar2 = "qtyVar";
			String unitRateVar2 = "unitRateVar";
			String manuId = "manuId";
			String manuId2 = "manuId";
			String balanceTId = "balanceTId";
			String balanceTId2 = "balanceTId";
			String manuIdTemp = "manuIdTemp";
			String manuIdTemp2 = "manuIdTemp";
			String batchNoVarTemp2 = "batchNoVarTemp";
			String expDateVarTemp2 = "expDateVarTemp";
			String qtyVarTemp2 = "qtyVarTemp";
			String unitRateVarTemp2 = "unitRateVarTemp";
			String incVar2 = "incVar2";
			String dispensingPrice = "dispensingPrice";
			String dispensingPrice2 = "dispensingPrice";
			String mrp = "mrp";
			String mrp2 = "mrp";

			if (pageNo != 1) {
				inc = ((pageNo - 1) * 8) + 1;
			}

			int incTemp2 = inc + 8;
			for (StoreBalanceT storeBalanceT : gridIndentTList) {

				if (inc <= incTemp2) {
					idItem = idItem2 + ("" + inc);
					codeItem = codeItem2 + ("" + inc);
					nameItem = nameItem2 + ("" + inc);
					idBrand = idBrand2 + ("" + inc);
					nameManufacturer = nameManufacturer2 + ("" + inc);
					idAu = idAu2 + ("" + inc);
					batchNoVar = batchNoVar2 + ("" + inc);
					expDateVar = expDateVar2 + ("" + inc);
					qtyVar = qtyVar2 + ("" + inc);
					unitRateVar = unitRateVar2 + ("" + inc);
					brandId = brandId2 + ("" + inc);
					manuId = manuId2 + ("" + inc);
					batchNoVarTemp = batchNoVarTemp2 + ("" + inc);
					expDateVarTemp = expDateVarTemp2 + ("" + inc);
					qtyVarTemp = qtyVarTemp2 + ("" + inc);
					unitRateVarTemp = unitRateVarTemp2 + ("" + inc);
					incVar = incVar2 + ("" + inc);
					balanceTId = balanceTId2 + ("" + inc);
					manuIdTemp = manuIdTemp2 + ("" + inc);
					dispensingPrice = dispensingPrice2 + ("" + inc);
					mrp = mrp2 + ("" + inc);
		%>
		<tr>
			<input type="hidden" name="<%=BALANCE_T_ID%>"				value="<%=storeBalanceT.getId()%>" id="<%=balanceTId%>" />
			<td width="5%">
			<input type="text" size="1" value="<%=storeBalanceT.getSrNo()%>" name="<%=SR_NO%>" readonly="readonly" />
			</td>
			<td width="10%">
			<input type="text" size="8"	name="<%=ITEM_CODE%>" readonly="readonly" id="<%=codeItem%>" value="<%=storeBalanceT.getItem().getPvmsNo()%>" />
			<input type="hidden" value="<%=storeBalanceT.getItem().getId()%>" name="<%=ITEM_ID%>" id="<%=idItem%>" />
			</td>
			<td width="10%">
			<input type="text" readonly="readonly" value="<%=storeBalanceT.getItem().getNomenclature()%>" tabindex=1 id="<%=nameItem%>" onblur="if(fillSrNo(<%=inc%>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc%>');}" name="<%=nameItem%>" />
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForLoanoutByAutocompleteBalance',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value});
		</script></td>

			<td width="10%"><input type="text"
				value="<%=storeBalanceT.getItem().getItemConversion()
							.getItemUnitName()%>"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>" /></td>
			<%--
 		<td width="10%">
      <select name="<%=BRAND_ID%>"  id="<%=brandId%>" onchange="getManufacturerNameInAjax(this.value,<%=inc%>);" tabindex="1">
	  <option value="0">Select</option>
	  <%if(storeBalanceT.getBrand() !=null)
	  	for(MasStoreBrand masStoreBrand : brandList){

	  if((storeBalanceT.getBrand() !=null)&&(storeBalanceT.getBrand().getId()==masStoreBrand.getId())){
	  %>
	  	<option value="<%=masStoreBrand.getId() %>" selected="selected"><%=masStoreBrand.getBrandName()%></option>
	  <%}else{ %>
	  <option value="<%=masStoreBrand.getId() %>" ><%=masStoreBrand.getBrandName()%></option>
	  <%}} %>
      </select>

      </td>
--%>
			<td width="10%">
			<%

						if (storeBalanceT.getItem()!= null) {
							int manufactureId=0;
							String manufactureName="";
							if (brandList.size()>0) {
								for (MasStoreBrand masStoreBrand : brandList) {
									if (masStoreBrand.getItem().getId().equals(storeBalanceT.getItem().getId())) {
										manufactureId=masStoreBrand.getManufacturer().getId();
										manufactureName=masStoreBrand.getManufacturer().getManufacturerName();
									}
								}
								%> <select
								name="<%=RequestConstants.MANUFACTURER_ID%>" tabindex=1
								id=<%=manuId%> tabindex="1" readonly="readonly">
								<option
									value="<%=manufactureId%>"><%=manufactureName%>
								</option>
							</select> <input type="hidden"
								value="<%=manufactureId%>"
								id="<%=manuIdTemp%>">

								 <%
							}

 	} else {
 %> <select
				name="<%=RequestConstants.MANUFACTURER_ID%>" tabindex=1
				id=<%=manuId%> tabindex="1" readonly="readonly">
				<option value="">--</option>
			</select> <input type="hidden" name="<%=RequestConstants.MANUFACTURER_ID%>"
				value="0" id="<%=manuIdTemp%>" re> <%
 	}
 %>
			</td>


			<%
				if (storeBalanceT.getBatchNo() != null) {
			%>
			<td width="5%"><input type="text" readonly="readonly" size="8"
				value="<%=storeBalanceT.getBatchNo()%>" name="<%=BATCH%>"
				id="<%=batchNoVarTemp%>" onblur="fillValuesBalance(<%=inc%>); %>);"
				MAXLENGTH="10" tabindex=1 /> <input type="hidden" size="2"
				value="<%=storeBalanceT.getBatchNo()%>" name="<%=BATCH_NO%>"
				id="<%=batchNoVar%>" /></td>
			<%
				} else {
			%>
			<td width="5%"><input type="text" value="" readonly="readonly"
				size="8" tabindex=1 name="<%=BATCH%>" id="<%=batchNoVarTemp%>"
				onblur="fillValuesBalance(<%=inc%>);" validate="Batch No.,string,no"
				maxlength="10" tabindex=1 /> <input type="hidden" size="2"
				value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar%>" /></td>

			<%
				}
			%>


			<%
				if(storeBalanceT.getExpiryDate() != null){
			%>

			<td width="5%">
			<input type="text" size="8"	value="<%=HMSUtil.changeDateToddMMyyyy(storeBalanceT.getExpiryDate())%>"
				id="<%=expDateVarTemp%>" onblur="fillDate('<%=inc%>');" tabindex="1" />

				<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.indentGrid.<%= expDateVarTemp%>,true);" />
			<input type="hidden"
				value="<%=HMSUtil.changeDateToddMMyyyy(storeBalanceT
							.getExpiryDate())%>"
				name="<%=RequestConstants.EXPIRY_DATE%>" id="<%=expDateVar%>" /></td>


			<%
				}else{
			%>

			<td width="5%"><input type="text" value="" size="8"
				id="<%=expDateVarTemp%>" onblur="fillDate('<%=inc%>');" tabindex="1" />

				<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.indentGrid.<%= expDateVarTemp%>,true);" />
			<input type="hidden" value="<%=date%>"
				name="<%=RequestConstants.EXPIRY_DATE%>" id="<%=expDateVar%>" /></td>

			<%
				}
			%>




			<td width="10%"><input type="text" size="8"
				value="<%=storeBalanceT.getQty()%>" maxlength="9"
				name="<%=QTY_BALANCE_TEMP%>" tabindex="1" id="<%=qtyVarTemp%>"
				validate="Qty,num,no" onblur="fillValuesBalance(<%=inc%>);" /> <input
				type="hidden" value="<%=storeBalanceT.getQty()%>"
				name="<%=QTY_BALANCE%>" tabindex="1" id="<%=qtyVar%>" /></td>
			<td width="10%"><input type="text" size="8"
				value="<%=storeBalanceT.getUnitRate()%>" maxlength="9"
				name="<%=UNIT_RATE_BALANCE_TEMP%>" tabindex="1"
				id="<%=unitRateVarTemp%>" validate="Unit Rate,num,no"
				onblur="fillValuesBalance(<%=inc%>);" /> <input type="hidden"
				value="<%=storeBalanceT.getUnitRate()%>"
				name="<%=UNIT_RATE_BALANCE%>" tabindex="1" id="<%=unitRateVar%>" />
			</td>
			<%
				if (storeBalanceT.getDispencingPrice() != null) {
			%>
			<td width="10%"><input type="text" size="8"
				value="<%=storeBalanceT.getDispencingPrice()%>"
				name="dispensingPrice" value="" maxlength="9" tabindex="1"
				id="<%=dispensingPrice%>" validate="dispensing price,num,no" /></td>
			<%
				} else {
			%>
			<td width="10%"><input type="text" size="8" value=""
				name="dispensingPrice" value="" maxlength="9" tabindex="1"
				id="<%=dispensingPrice%>" validate="dispensing price,num,no" /></td>
			<%
				}
			%>
			<%
				if (storeBalanceT.getMrp() != null) {
			%>
			<td width="10%"><input type="text" size="8"
				value="<%=storeBalanceT.getMrp()%>" name="mrp" maxlength="9"
				tabindex="1" id="<%=mrp%>" validate="mrp,num,no" /></td>
			<%
				} else {
			%>
			<td width="10%"><input type="text" size="8" value="" name="mrp"
				maxlength="9" tabindex="1" id="<%=mrp%>" validate="mrp,num,no" /></td>
			<%
				}
			%>
		</tr>
		<%
			inc++;
				}
			}
		%>
		<script>
	    	 document.indentGrid.noOfRows.value=<%=inc - ((pageNo - 1) * 8) - 1%>
	    	 </script>

		<%
			if (inc < incTemp2) {
				for (; inc < incTemp2; inc++) {

					idItem = idItem2 + ("" + inc);
					codeItem = codeItem2 + ("" + inc);
					nameItem = nameItem2 + ("" + inc);
					idBrand = idBrand2 + ("" + inc);
					nameManufacturer = nameManufacturer2 + ("" + inc);
					idAu = idAu2 + ("" + inc);
					batchNoVar = batchNoVar2 + ("" + inc);
					expDateVar = expDateVar2 + ("" + inc);
					qtyVar = qtyVar2 + ("" + inc);
					unitRateVar = unitRateVar2 + ("" + inc);
					brandId = brandId2 + ("" + inc);
					manuId = manuId2 + ("" + inc);
					batchNoVarTemp = batchNoVarTemp2 + ("" + inc);
					expDateVarTemp = expDateVarTemp2 + ("" + inc);
					qtyVarTemp = qtyVarTemp2 + ("" + inc);
					unitRateVarTemp = unitRateVarTemp2 + ("" + inc);
					incVar = incVar2 + ("" + inc);
					balanceTId = balanceTId2 + ("" + inc);
					manuIdTemp = manuIdTemp2 + ("" + inc);
		%>
		<td width="5%"><input type="text" size="1" value="<%=temp + inc%>"
			name="<%=SR_NO%>" readonly="readonly" /></td>
		<td width="10%"><input type="text" size="8"
			name="<%=ITEM_CODE%>" readonly="readonly" id="<%=codeItem%>" /> <input
			type="hidden" size="2" value="0" name="<%=ITEM_ID%>" id="<%=idItem%>" />

		</td>
		<td width="10%"><input type="text" value="" id="<%=nameItem%>"
			onblur="if(fillSrNo(<%=inc%>)){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc%>');}"
			name="<%=nameItem%>" tabindex=1 />
		<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForLoanoutByAutocompleteBalance',{parameters:'requiredField=<%=nameItem%>&balanceId='+document.getElementById('balanceId').value});
		</script></td>




		<td width="10%"><input type="text" value="" readonly="readonly"
			name="<%=AV%>" id="<%=idAu%>" validate="A/U ,String,no" /></td>
		<%--
      <td width="10%">
      <select name="<%=RequestConstants.BRAND_ID%>"  id="<%=brandId%>" onchange="getManufacturerNameInAjax(this.value,<%=inc%>);" tabindex=1>
	  <option value="0">Select</option>
      </select>

      </td>
      --%>
		<td width="10%"><select
			name="<%=RequestConstants.MANUFACTURER_ID%>" tabindex=1
			id=<%=manuId%> tabindex="1">
			<option value="">Select Manufacturer</option>
		</select> <input type="hidden" name="<%=RequestConstants.MANUFACTURER_ID%>"
			value="0" id="<%=manuIdTemp%>" /></td>


		<td width="5%"><input type="text" value="" size="8" tabindex=1
			name="<%=BATCH%>" id="<%=batchNoVarTemp%>"
			onblur="fillValuesBalance(<%=inc%>);" validate="Batch No.,string,no"
			maxlength="10" tabindex=1 /> <input type="hidden" size="2"
			value="emptyString" name="<%=BATCH_NO%>" id="<%=batchNoVar%>" /></td>
		</td>
		<td width="5%"><input type="text" value="" size="8"
			id="<%=expDateVarTemp%>" onblur="fillDate('<%=inc%>');" tabindex="1" />
			<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.indentGrid.<%=expDateVarTemp%>,true);" />
		<input type="hidden" value="<%=date%>"
			name="<%=RequestConstants.EXPIRY_DATE%>" id="<%=expDateVar%>" /></td>

		<td width="10%"><input type="text" size="8" value=""
			name="<%=QTY_BALANCE_TEMP%>" maxlength="9" tabindex="1"
			id="<%=qtyVarTemp%>" validate="Qty,num,no"
			onblur="fillValuesBalance(<%=inc%>);" tabindex=1 /> <input
			type="hidden" value="0" name="<%=QTY_BALANCE%>" tabindex="2"
			id="<%=qtyVar%>" /></td>
		<td width="10%"><input type="text" size="8" value=""
			name="<%=UNIT_RATE_BALANCE_TEMP%>" maxlength="9" tabindex="1"
			id="<%=unitRateVarTemp%>" validate="unit Rate,num,no"
			onblur="fillValuesBalance(<%=inc%>);" /> <input type="hidden"
			value="0" name="<%=UNIT_RATE_BALANCE%>" tabindex="2"
			id="<%=unitRateVar%>" /></td>
		<td width="10%"><input type="text" size="8" value=""
			name="dispensingPrice" value="" maxlength="9" tabindex="1"
			id="<%=dispensingPrice%>" validate="dispensing price,num,no" /></td>
		<td width="10%"><input type="text" size="8" value="" name="mrp"
			maxlength="9" tabindex="1" id="<%=mrp%>" validate="mrp,num,no" /></td>
		</tr>


		<%
			}
			}
		%>

	</tbody>

</table>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE%>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME%>" value="<%=time%>" />
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />


