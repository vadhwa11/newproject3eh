<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>

<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
//-->
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
function refreshGridonLoadinAdjust()
{
submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=showLoanIn');
}

function fillSrNo(rowVal)
{
		var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%30
   		if(rowVal==0){
   			rowVal=30
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
	return true;
}


function checkForNext()
{
	if(document.getElementById('noOfRows').value<15)
	{
	alert("All rows are not filled.To continue press Submit ")
	return false;
	}else{
	return true;
	}
}

 function checkForSubmit()
 {
	/* if(document.getElementById('noOfRows').value==0)
	 {
	 alert("There must be one detail row");
	 return false;
	 }else{
	 return true;
	 }
	*/
	return true;
}

function get_value(rowNo)
{
 var url="/hms/hms/stores?method=showInfoOfGrnJsp&rowNo="+rowNo;
   popwindow(url);
 }

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=500,width=600,status=1,scrollbars=yes");
 if (window.focus)
 {
 newwindow.focus()
 }
newwindow.createPopup();

}


//===for  new Item addition on screen

function openItemPopup()
{
 var url="/hms/hms/pharmacy?method=showItemJsp";
 popwindow(url);
}

var newwindow;
function popwindow(url)
{
newwindow=window.open(url,'name',"status=1,scrollbars=yes");
if (window.focus)
 {
 newwindow.focus()
 }
newwindow.createPopup();
}

function openBrandPopup()
{
 var url="/hms/hms/personnel?method=showBrandJsp";
 popwindow(url);
}
function openVendorPopup()
{
 var url="/hms/hms/pharmacy?method=showStoreSupplierJsp";
 popwindow(url);
}

function autocompleteBasedOnPvms(val,inc)
{
		ajaxFunctionForAutoCompleteForGrn('grnGrid','stores?method=fillItemsCommon&pvmsNo=' +  val , inc);
}

function ajaxFunctionForAutoCompleteForGrn(formName,action,rowVal)
{
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
    var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

      	for (loop = 0; loop < items.childNodes.length; loop++)
      	{
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];

	        var name  = item.getElementsByTagName("name")[0];
        	document.getElementById('nameItem'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
      }
    }
  }
}


</script>
<script language="javascript">
function checkForGrn(val,a,inc)
{
	if (val=="")
	{
		document.getElementById('codeItem'+inc).value="";
		document.getElementById('idItem'+inc).value=0;
		document.getElementById('expiry'+inc).value="";
		document.getElementById('idAu'+inc).value="";
		document.getElementById('batchNo'+inc).value="";
		document.getElementById('lotNo'+inc).value="";
		document.getElementById('quanRec'+inc).value="";
		document.getElementById('freeQty'+inc).value="";
		document.getElementById('dispenseType'+inc).length=0;
        document.getElementById('manufacturerId'+inc).length=1;
		document.getElementById('mdq').value=1;
	if(document.getElementById('sourceCombo').value=="a" || document.getElementById('sourceCombo').value=="i" )
	{
		document.getElementById('ratePerMdq'+inc).value=0;
		document.getElementById('unitRateVar'+inc).value=0;
	}
	else{

		document.getElementById('ratePerMdq'+inc).value="";
		document.getElementById('unitRateVar'+inc).value="";
	 }
 		document.getElementById('discountVar'+inc).value="";
		document.getElementById('taxVar'+inc).value="";
		document.getElementById('amtVar'+inc).value="";
		document.getElementById('costPrice'+inc).value="";
		document.getElementById('manufacturingDate'+inc).value="";
		document.getElementById('expiryDate'+inc).value="";
	return;
}
//var expiry=document.getElementById('expiry').value;
//();
	var src = document.getElementById('sourceCombo').value;
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
 	var pvms = val.substring(index1,index2);

	var poId=0;
	if(document.getElementById('indentCombo')!=null){
		poId = document.getElementById('indentCombo').value;
	}
	//alert("src--grn jsp-"+src);
	if (src=='l'){
	 	ajaxFunctionForAutoCompleteInGrn('grnGrid','stores?method=fillItemsForGrn&requiredField=' + encodeURIComponent(pvms) + "&poId=" + poId+"&nom="+val , inc);
	}else{
	  	ajaxFunctionForAutoCompleteInGrnGeneral('grnGrid','stores?method=fillItemsForGrnForGrnWithoutPo&requiredField=' + encodeURIComponent(pvms) + "&poId=" + poId+"&nom="+val , inc);
	}
 }

 function jsGetGrid(){
   if((document.getElementById('item_id').value).length > 0){
       document.getElementById('temp').value = document.getElementById('item_id').value
       document.getElementById('item_id').value = "";

	   var po_id = document.getElementById('indentCombo').value;
	   var sos = document.getElementById('sourceCombo').value;
	   submitProtoAjaxforGrid('grnGrid','/hms/hms/stores?method=responseSOGridList&sos='+sos+'&po_id='+po_id+'&items='+document.getElementById('temp').value);
   }
  }
   function getsoitems(){
  var so = document.getElementById('indentCombo').value;

   	currPage=1;
	numOfRows=10;
   if(so != 0 && so != ""){
  	   var url="/hms/hms/stores?method=getSoItemDetails&currPage="+currPage+"&numOfRows=20&sos="+document.getElementById('sourceCombo').value+"&po_id="+so+"&pageType=add";
		newwindow=window.open(url,'name','top=50, left=50, height=675,width=850,status=1,scrollbars=yes');
	} else {
 	 	alert("Please select SONo ..!!!");
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

	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	if(map.get("supplierList") != null){
		supplierList = (ArrayList) map.get("supplierList");
		session.setAttribute("supplierList",supplierList);
	}else if(session.getAttribute("supplierList") != null){
		supplierList = (ArrayList)session.getAttribute("supplierList");

	}
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
			if(map.get("itemList") != null){
				itemList = (ArrayList) map.get("itemList");
				session.setAttribute("itemList",itemList);
			}else if(session.getAttribute("itemList") != null){
				itemList = (ArrayList)session.getAttribute("itemList");

			}
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			if(map.get("employeeList") != null){
				employeeList = (ArrayList) map.get("employeeList");
				session.setAttribute("employeeList",employeeList);
			}else if(session.getAttribute("employeeList") != null){
				employeeList = (ArrayList)session.getAttribute("employeeList");

			}
			//
			List<StorePoHeader> poList = new ArrayList<StorePoHeader>();
			if(map.get("poList") != null){
				poList = (ArrayList) map.get("poList");
				session.setAttribute("poList",poList);
			}else if(session.getAttribute("poList") != null){
				poList = (ArrayList)session.getAttribute("poList");

			}
			StoreGrnM storeGrnObj = null;
			List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
			if(map.get("indentList") != null){
				indentList = (ArrayList) map.get("indentList");
				session.setAttribute("indentList",indentList);
			}else if(session.getAttribute("indentList") != null){
				indentList = (ArrayList)session.getAttribute("indentList");

			}
			List<MasUnitOfMeasurement> uomList = new ArrayList<MasUnitOfMeasurement>();
			if(map.get("uomList") != null){
				uomList = (ArrayList) map.get("uomList");
				session.setAttribute("uomList",uomList);
			}else if(session.getAttribute("uomList") != null){
				uomList = (ArrayList)session.getAttribute("uomList");

			}

			List<MasStoreAirForceDepot> unitList = new ArrayList<MasStoreAirForceDepot>();
			if(map.get("unitList") != null){
				unitList = (ArrayList) map.get("unitList");
				session.setAttribute("unitList",unitList);
			}else if(session.getAttribute("unitList") != null){
				unitList = (ArrayList)session.getAttribute("unitList");

			}
			List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
			if(map.get("brandList") != null){
				brandList = (ArrayList) map.get("brandList");
				session.setAttribute("brandList",brandList);
			}else if(session.getAttribute("brandList") != null){
				brandList = (ArrayList)session.getAttribute("brandList");

			}

			List<StoreSupplyOrderEntry> supplyOrderList = new ArrayList<StoreSupplyOrderEntry>();
			if(map.get("supplyOrderList") != null){
				supplyOrderList = (ArrayList) map.get("supplyOrderList");
				session.setAttribute("supplyOrderList",supplyOrderList);
			}else if(session.getAttribute("supplyOrderList") != null){
				supplyOrderList = (ArrayList)session.getAttribute("supplyOrderList");

			}
			List<Object[]> searchGrnList= new ArrayList<Object[]>();
			if(map.get("searchGrnList")!=null)
				searchGrnList = (List) map.get("searchGrnList");

			List<StoreGrnM> grnList= new ArrayList<StoreGrnM>();
			if(map.get("grnList")!=null)
				grnList = (List) map.get("grnList");


			String message="";
			if(map.get("message") != null){
				message = (String)map.get("message");
			}
			String max="";
			if(map.get("max") != null){
				max = (String) map.get("max");
			}
			//
			String userName = "";
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			int hospitalId = 0;
			if (session.getAttribute("hospitalId") != null) {
				Integer temp =  (Integer)session.getAttribute("hospitalId");
				hospitalId = temp.intValue();
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
	function checkInvoiceDate(){
		var invoiceDate = document.grnGrid.<%=INVOICE_DATE%>.value;
		var	iDate =new Date(invoiceDate.substring(6),(invoiceDate.substring(3,5) - 1) ,invoiceDate.substring(0,2))
		var cDate = new Date();
		var month = cDate.getMonth() + 1
		var day = cDate.getDate()
		var year = cDate.getFullYear()
		var seperator = "/"
		var currentDate  = new Date(month + seperator + day + seperator + year);
		if(invoiceDate != ""){
		if(iDate > currentDate)
		{
			alert("Invoice Date should be less than equal to Current Date.");
			document.grnGrid.<%=INVOICE_DATE%>.value = "";
			return false;
		}
		}
		return true;
	}


</script>

<div class="titleBg">
<h2>GRN</h2>
</div>
<div class="Block">
<%String messageTOBeVisibleToTheUser="";
		if(map.get("messageTOBeVisibleToTheUser") != null){
			messageTOBeVisibleToTheUser=((String)map.get("messageTOBeVisibleToTheUser"));
		  }
 %>
<h4><span><%=messageTOBeVisibleToTheUser %></span></h4>
<form name="createGrn" method="post" action="">
<%-- 
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>--%>
<div class="clear"></div>
<!--  <input type="button" id="addbutton" name="Add"   value="Add" class="button" onClick="submitForm('createGrn','stores?method=showGrnJsp');" />
<input type="button" name="Modify"  value="Modify" class="button"  onClick="submitForm('createGrn','stores?method=grnModifyJsp');" />-->
<%-- <input type="button" name="Reset"  value="Reset" class="buttonHighlight" />
<input type="button" name="Delete"  value="Delete" class="button" />--%>
<%-- 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="print" class="button" value="Print"	onClick="submitForm('createGrn','stores?method=showGrnReportJsp');" />
<input type="button" name="GenerateBarCode" class="buttonBig"	value="Generate BarCode"	onClick="submitForm('createGrn','stores?method=showCreateBarCodeJsp');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<form name="searchPanel" method="post">
<div class="clear"></div>
<label>From Date </label>
<input type="text" name="<%= FROM_DATE %>"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.createGrn.<%= FROM_DATE%>,event);" />
<label>To Date </label>
<input type="text" name="<%= TO_DATE %>" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.createGrn.<%= TO_DATE%>,true);" />
<div class="clear"></div>
<label>GRN No.</label>
<input type="text" name="<%=GRN_NO%>" value=""	tabindex=1 MAXLENGTH="100" id="<%=GRN_NO%>" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=GRN_NO%>','ac2update','stores?method=getGrnNoListForAutoComplete',{parameters:'requiredField=<%=GRN_NO%>'});
		</script>
<input name="button"  type="image"	class="button"	onclick="submitForm('createGrn','stores?method=searchGrn');" />
</form>
</div>--%>
<%-- <jsp:include page="searchResultBlock.jsp" /> --%>

<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" validate="pageNo,int,no"/>
<input	type="hidden" name="mdq" id="mdq" value="1" />
<input	type="hidden" name="deptId" value="<%=deptId%>" validate="deptId,int,no"/>
<input	type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>" validate="hospitalId,int,no"/>
<input	type="hidden" name="grnScreenType" id="grnScreenType" value="mainGrn" />
<h4>GRN Details</h4>
<label>GRN No. <span>*</span></label>
<% if(storeGrnObj != null){%>
<input	type="text" name="<%= GRN_NO %>" value="<%=storeGrnObj.getGrnNo()%>"	class="readOnly" readonly="readonly" validate="grnNo,string,yes" tabindex=1 />
<%}else{ %>
<input type="text" name="<%= GRN_NO %>"	value="<%=max %>" class="readOnly" readonly="readonly"	validate="grnNo,string,yes" tabindex=1 /> <%} %>

<label>GRN Date <span>*</span></label>
<input type="text" name="<%=GRN_DATE%>"	value="<%=currentDate %>" class="date" readonly="readonly"	MAXLENGTH="30" tabindex=1 validate="grnDate,date,yes"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.<%=GRN_DATE%>,event)" />

<label>Source of Supply <span>*</span></label>
<select name="<%=SOURCE_OF_SUPPLY%>" id="sourceCombo" tabindex=1	onchange="onChangeOfSupply(this.value);">
	<option value="0">Select</option>
	<option value="KMSCL Issue Note">KMSCL Issue Note</option>
	<option value="Purchase From KMSCL">Purchase From KMSCL</option>
	<option value="Indent From Institute">Indent From Institute</option>
	<option value="Local Purchase">Local Purchase</option>
	<option value="Other">Other</option>
		
</select>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div id="grnDiv">
</div>


<%-- <input type="button" class="button" name="<%=BOO_ENTRY %>"  value="BOO Entry"  onclick="submitFormForButton('grnGrid','stores?method=showBooJsp');"/>--%>
<%-- 
<div class="clear"></div>
<div id="suppDiv">
<label>Unit/Ven.Name</label> <select
	name="<%= SUPPLIER_ID%>" id="supplierCombo" tabindex=1>
	<option value="">Select</option>
	<% for (MasStoreSupplier masStoreSupplier1 : supplierList)
	  	   {   %>
	<option value="<%=masStoreSupplier1.getId ()%>"><%=masStoreSupplier1.getSupplierName()%></option>
	<% } %>
</select></div>
<div id="indentDiv">
<label>Indt No/PO No</label>
<select name="<%=INDENT_ID %>" id="indentCombo" tabindex=1></select>
</div>
<div class="clear"></div>--%>
<%-- <label >Po No.</label> <% if(storeGrnObj != null){%> <input
	id="test" type="hidden" name="<%=SUPPLY_ORDER_NO %>"
	value="<%=storeGrnObj.getAtSoNo() %>" MAXLENGTH="75" tabindex=1>
<%}else{ %> <input id="test" type="hidden" name="<%=SUPPLY_ORDER_NO %>"
	value="" MAXLENGTH="75" tabindex=1> <%} %>
<div class="clear"></div>

<div id="atsoDateDiv"><label>Po Date</label> <input id="dateTest"
	type="text" class="readOnly" name="<%=AT_SO_DATE%>" id="atSoDate"
	readonly="readonly" value="<%=currentDate %>" MAXLENGTH="30" /> <%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('<%=currentDate%>',document.grnGrid.<%=AT_SO_DATE%>,true)" />
</div>




<label>Date Rec/Surp</label> <input type="text"
	name="<%=RECEIVED_DATE%>" value="<%=currentDate %>" class="date"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.grnGrid.<%=RECEIVED_DATE%>,true)" />
--%>

<%--<label >R/R No </label>
	  	<% if(storeGrnObj != null){%>
	  	<input type="text" name="<%=RR_NO %>" value="<%=storeGrnObj.getRrNo() %>"   MAXLENGTH="30" tabindex=1 />
		<%}else{ %>
		<input type="text" name="<%=RR_NO %>" value=""   MAXLENGTH="30" tabindex=1 />
		<%} %>

	  	  	  <div class="clear"></div>


	  	<label >Transportation Mode:</label>
		<select name="<%=MODE_OF_CONVEYANCE%>" validate="Mode Of Conveyance,string,yes" tabindex=1>
		<option value="0">Select</option>
		<option value="1">Air</option>
		<option value="2">Bus</option>
		<option value="3">Train</option>
		<option value="4">By Hand</option>
		</select>
	  	<br/>
	  <label><span>*</span> Unpack/Checked by</label> <select
	name="<%= EMPLOYEE_ID %>" validate="Unpack/Checked by,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%
			  	for (MasEmployee masEmployee : employeeList) {
			%>

	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<% } %>
</select>
<div class="clear"></div>

<label> How Received </label> <% if(storeGrnObj != null){%> <input
	type="text" name="<%=HOW_RECEIVED %>"
	value="<%=storeGrnObj.getHowReceived()%>" MAXLENGTH="50" tabindex=1 />
<%}else{ %> <input type="text" name="<%=HOW_RECEIVED %>" value=""
	MAXLENGTH="50" tabindex=1 /> <%} %>
<div class="clear"></div>


<label> Remarks</label> <%if(storeGrnObj != null){ %> <textarea
	value="<%=storeGrnObj.getRemarks()%>" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250" tabindex=1></textarea> <%}else{ %> <textarea value=""
	name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250"></textarea> <%} %> <label><span>*</span> Invoice
No.</label> <%if(storeGrnObj != null){ %> <input type="text"
	name="<%=INVOICE_NO %>" id="<%=INVOICE_NO%>"
	value="<%=storeGrnObj.getInvoiceNo() %>"
	validate="Invoice No, String,yes" class="textbox_size20" MAXLENGTH="20"
	tabindex=1 /> <%}else{ %> <input type="text" name="<%=INVOICE_NO %>"
	id="<%=INVOICE_NO%>" value="" validate="Invoice No,String,yes"
	class="textbox_size20" MAXLENGTH="20" onblur="checkInvoiceNo(this.value)" tabindex=1 /> <%} %>
<div class="clear"></div>

<label>Invoice Date</label> <input type="text" name="<%=INVOICE_DATE%>"
	id="invoiceDate" value="<%=currentDate %>" class="date" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.grnGrid.<%=INVOICE_DATE%>,true)" />

<label>Invoice Amount</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=INVOICE_AMOUNT %>" id="<%=INVOICE_AMOUNT %>"
	value="<%=storeGrnObj.getInvoiceAmount() %>"
	validate="Invoice Amount ,float,no" MAXLENGTH="15" tabindex=1 /> <%}else{ %>
<input type="text" name="<%=INVOICE_AMOUNT %>" id="<%=INVOICE_AMOUNT %>"
	value="" validate="Invoice Amount,float,no" MAXLENGTH="15" tabindex=1 />

<%} %> <label>Freight Duty</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=FREIGHT_DUTY %>"
	value="<%=storeGrnObj.getFreightDuty()%>" id="<%=FREIGHT_DUTY %>"
	validate="Freight Duty,float,no" class="textbox_size20" MAXLENGTH="15"
	onblur="freight();" tabindex=1 /> <%}else{ %> <input type="text"
	name="<%=FREIGHT_DUTY %>" id="<%=FREIGHT_DUTY %>" value=""
	validate="Freight Duty,float,no" class="textbox_size20" MAXLENGTH="15"
	onblur="calculationInCRV();" tabindex=1 /> <%} %>
<div class="clear"></div>
<label>Excise Duty</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=EXCISE_DUTY %>"
	value="<%=storeGrnObj.getExciseDuty()%>" id="<%=EXCISE_DUTY %>"
	validate="Excise Duty,float,no" class="textbox_size20" MAXLENGTH="15"
	onblur="excise();" tabindex=1 /> <%}else{ %> <input type="text"
	name="<%=EXCISE_DUTY %>" id="<%=EXCISE_DUTY %>" value=""
	class="textbox_size20" validate="Excise Duty,float,no" MAXLENGTH="15"
	onblur="calculationInCRV();" tabindex=1 /> <%} %> <label>Octroi</label>
<%if(storeGrnObj != null){ %> <input type="text" name="<%=OCTROI %>"
	value="<%=storeGrnObj.getOctroi()%>" id="<%=OCTROI %>"
	validate="Octroi,float,no" class="textbox_size20" MAXLENGTH="15"
	onblur="octroi();" tabindex=1 /> <%}else{ %> <input type="text"
	name="<%=OCTROI %>" id="<%=OCTROI %>" value="" class="textbox_size20"
	validate="Octroi,float,no" MAXLENGTH="15" onblur="calculationInCRV();"
	tabindex=1 /> <%} %> <label>Insurance Charge</label> <%if(storeGrnObj != null){ %>
<input type="text" name="<%=INSURANCE_CHARGES %>"
	value="<%=storeGrnObj.getInsuranceCharge()%>"
	id="<%=INSURANCE_CHARGES %>" validate="Insurance Charges,float,no"
	class="textbox_size20" MAXLENGTH="15" onblur="insurance();" tabindex=1 />
<%}else{ %> <input type="text" name="<%=INSURANCE_CHARGES %>"
	id="<%=INSURANCE_CHARGES %>" value="" class="textbox_size20"
	validate="Insurance Charges,float,no" MAXLENGTH="15"
	onblur="calculationInCRV();" tabindex=1 /> <%} %>
<div class="clear"></div>
<label>Other Charges</label> <%if(storeGrnObj != null){ %> <input
	type="text" name="<%=OTHER_CHARGES %>"
	value="<%=storeGrnObj.getOtherCharges()%>" id="<%=OTHER_CHARGES %>"
	validate="Other Charges,float,no" class="textbox_size20" MAXLENGTH="15"
	onblur="otherCharges();" tabindex=1 /> <%}else{ %> <input type="text"
	name="<%=OTHER_CHARGES %>" id="<%=OTHER_CHARGES %>" value=""
	class="textbox_size20" validate="Other Charges,float,no" MAXLENGTH="15"
	onblur="calculationInCRV();" tabindex=1 /> <%} %> <label>Custom
Duty</label> <%if(storeGrnObj != null){ %> <input type="text"
	name="<%=CUSTOM_DUTY %>" value="<%=storeGrnObj.getCustomDuty()%>"
	id="<%=CUSTOM_DUTY %>" validate="Custom Duty,float,no"
	class="textbox_size20" MAXLENGTH="15" onblur="custom();" tabindex=1 />
<%}else{ %> <input type="text" name="<%=CUSTOM_DUTY %>"
	id="<%=CUSTOM_DUTY %>" value="" class="textbox_size20"
	validate="Custom Duty,float,no" MAXLENGTH="15"
	onblur="calculationInCRV();" tabindex=1 /> <%} %>
<div class="clear"></div></div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>--%>


<%-- <input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="if(checkForCRVGrid() && cheakForRecdQty() && testForGrn()&& checkloanin()&& checkSave()&& checkForSubmit()){submitForm('grnGrid','stores?method=submitGrn');}" />--%>
	<input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="submitForm('createGrn','stores?method=submitGrn')" />
<%-- <input type="button" name="sss" align="right" class="button"
	value="Item" onclick="openItemPopup();" /> <input type="button"
	name="sss" align="right" class="button" value="Vendor"
	onclick="openVendorPopup();" />
	<input type="button"
	name="sss" align="right" class="button" value="Brand"
	onclick="openBrandPopup();" />--%> <input type="hidden" size="2"
	value="0" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" validate="noOfRows,int,no"/> <input
	type="hidden" name="<%=GRN_ID %>" value="<%=grnId%>" id="hdb" validate="grnId,int,no"/>

<div id="gridDiv"></div>
<div class="clear"></div>
<input type="hidden" name="<%=TOTAL_AMOUNT %>" id="<%=TOTAL_AMOUNT%>"
	value="" validate="totalAmount,float,no"><input type="hidden" name="<%=CLOSING_STOCK %>"
	id="<%=CLOSING_STOCK%>" value="" validate="closingStock,float,no">
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
</form>
<div class="clear"></div>
</div>
<%-- 
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />--%>


<script
	type="text/javascript">

</script> <input type="hidden" name="rows" id="rr" value="1" validate="rows,int,no"/></div>
<div class="clear"></div>
<div class="paddingTop40"></div></form>

<script language = "Javascript">
/**
 * DHTML date validation script. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 */
// Declaring valid date character, minimum year and maximum year
var dtCh= "/";
var minYear=1900;
var maxYear=2100;

function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
   }
   return this
}

function calulateStock(row)
{

	var issuedQty = parseFloat(document.getElementById('issuedQty'+row).value);
	var receivedQty = parseFloat(document.getElementById('quantityReceived'+row).value);
	//var storeStockDefectiveCal = parseFloat(document.getElementById('stockDefective'+row).value);
	var surplus = parseFloat(document.getElementById('surplus'+row).value);
	var deficient = parseFloat(document.getElementById('deficient'+row).value);
	if (isNaN(issuedQty) || isNaN(receivedQty))
	{
	alert('Please Check the Inputs!....');
	return;
	}
	var difference =  parseFloat(receivedQty)-parseFloat(issuedQty);


	if (difference > 0)
	{
		document.getElementById('surplus'+row).value=parseFloat(difference);
		document.getElementById('deficient'+row).value="0";
	}

	if (difference < 0)
	{
		document.getElementById('deficient'+row).value=parseFloat(difference) * -1;
		document.getElementById('surplus'+row).value="0";
	}

	if (difference == 0)
	{
		document.getElementById('deficient'+row).value="0";
		document.getElementById('surplus'+row).value="0";
	}

}





function isDate(dtStr,cnt){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	//var strMonth=dtStr.substring(0,pos1)
	//var strDay=dtStr.substring(pos1+1,pos2)
	var strDay=dtStr.substring(0,pos1)
	var strMonth=dtStr.substring(pos1+1,pos2)
	//alert("strMonth--"+strMonth);
	//alert("strDay--"+strDay);
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)
	if (pos1==-1 || pos2==-1){
		alert("The date format should be : DD/MM/YYYY on Row No:"+cnt);
		document.getElementById('expiryDate'+cnt).value="";
		document.getElementById('expiryDate'+cnt).focus();
		return false
	}
	if (strMonth.length<1 || month<1 || month>12){
		alert("Please enter a valid month on Row No:"+cnt);
		document.getElementById('expiryDate'+cnt).value="";
		document.getElementById('expiryDate'+cnt).focus();
		return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("Please enter a valid day  on Row No:"+cnt);
		document.getElementById('expiryDate'+cnt).value="";
		document.getElementById('expiryDate'+cnt).focus();
		return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear+" on Row No:"+cnt);
		document.getElementById('expiryDate'+cnt).value="";
		document.getElementById('expiryDate'+cnt).focus();
		return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		alert("Please enter a valid date on Row No:"+cnt);
		document.getElementById('expiryDate'+cnt).value="";
		document.getElementById('expiryDate'+cnt).focus();
		return false
	}
return true
}

function validateExpDate(dt,cnt){
//	var dt=document.frmSample.txtDate
	if(dt.value!=""){
		if (isDate(dt.value,cnt)==false){
			//dt.focus()
			return false
		}
	}
    return true
 }
function checkInvoiceNo(obj){
	var supplierId=document.getElementById('supplierCombo').value;
	//alert("supp>>>"+supplierId);
	if(obj!=null && obj!=""){
		<%if(searchGrnList!=null && searchGrnList.size()>0){
	for(Object[] inv : searchGrnList){ %>
	//var newInvObj=invObj.replace(/[`~!@#$%^&*()_|+\-=?;:'",.<>\{\}\[\]\\\/]/gi, '');
	if('<%=inv[0]%>'== obj ){
		if('<%=inv[1]%>'== supplierId ){	
	alert("Invoice No. Already Exists");
		document.getElementById('<%=INVOICE_NO%>').value="";
		document.getElementById('<%=INVOICE_NO%>').focus();
		return false;
		}}
	<%} }%>
}
}


</script>