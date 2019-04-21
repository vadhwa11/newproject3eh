
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreLoaninM"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script> <script>
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
	</script> <script language="javascript">

function checkForLoanIn(val,a,inc)
{
	
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    
	    for(i=1;i<=10;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	return false;
	    	}
	    }}
	    
	    var poId = document.getElementById('poId').value;
		ajaxFunctionForAutoCompleteInLoanIn('grnGrid','stores?method=fillItemsForLoanIn&requiredField=' + pvms + "&poId=" + poId , inc);
		
}
  
 </script> <script type="text/javascript" language="javascript">
var itemsArray1=new Array();
 var numLinesAdded = 1;
  var brandArray = new Array();
  var tt;
   function fillValuesInGrn(inc)
  {
  		
  	 	var quanRec = "quanRec";
    	var taxVar = "taxVar";
    	var amtVar = "amtVar";
    	var unitRateVar = "unitRateVar";
    	var discountVar = "discountVar";
    	
    	var quanRecTemp = "quanRecTemp";
    	var taxVarTemp = "taxVarTemp";
    	var unitRateVarTemp = "unitRateVarTemp";
    	var discountVarTemp = "discountVarTemp";
    	var amtVarTemp = "amtVarTemp";
  
    	document.getElementById(quanRec+inc).value=document.getElementById(quanRecTemp+inc).value
    	 	if(document.getElementById(taxVarTemp+inc).value != ""){
    		document.getElementById(taxVar+inc).value=document.getElementById(taxVarTemp+inc).value
    	}else{
    		document.getElementById(taxVar+inc).value = 0;
    	}
    	
    	document.getElementById(unitRateVar+inc).value=document.getElementById(unitRateVarTemp+inc).value
		
		if(document.getElementById(discountVarTemp+inc).value != ""){
    		document.getElementById(discountVar+inc).value=document.getElementById(discountVarTemp+inc).value
    	}else{
    		document.getElementById(discountVar+inc).value = 0;
    	}
    				if(document.getElementById(amtVarTemp+inc).value != ""){
    		document.getElementById(amtVar+inc).value=document.getElementById(amtVarTemp+inc).value
    	}else{
    		document.getElementById(amtVar+inc).value = 0;
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
   
function get_value(rowNo)
{
 var url="/hms/hms/stores?method=showMoreInfoLoanIn&rowNo="+rowNo + "&detailId=" + document.getElementById('poId').value;
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


//===for  new brand addition on screen

function get_valueForBrand()
{
 var url="/hms/hms/personnel?method=showBrandJsp";
   popwindow(url);
 }  

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=700,width=700,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}
</script> <%
		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		int loanInId = 0;
		if (map.get("loanInId") != null) {
			loanInId = Integer.parseInt("" + map.get("loanInId"));
		}
		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		if (map.get("supplierList") != null) {
			supplierList = (ArrayList) map.get("supplierList");
			session.setAttribute("supplierList", supplierList);
		} else if (session.getAttribute("supplierList") != null) {
			supplierList = (ArrayList) session.getAttribute("supplierList");

		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		if (map.get("itemList") != null) {
			itemList = (ArrayList) map.get("itemList");
			session.setAttribute("itemList", itemList);
		} else if (session.getAttribute("itemList") != null) {
			itemList = (ArrayList) session.getAttribute("itemList");

		}
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if (map.get("employeeList") != null) {
			employeeList = (ArrayList) map.get("employeeList");
			session.setAttribute("employeeList", employeeList);
		} else if (session.getAttribute("employeeList") != null) {
			employeeList = (ArrayList) session.getAttribute("employeeList");

		}
		List<StorePoHeader> poList = new ArrayList<StorePoHeader>();
		if (map.get("poList") != null) {
			poList = (ArrayList) map.get("poList");
			session.setAttribute("poList", poList);
		} else if (session.getAttribute("poList") != null) {
			poList = (ArrayList) session.getAttribute("poList");

		}
		StoreLoaninM storeloanObj = null;
		List<StoreIndentM> indentList = new ArrayList<StoreIndentM>();
		if (map.get("indentList") != null) {
			indentList = (ArrayList) map.get("indentList");
			session.setAttribute("indentList", indentList);
		} else if (session.getAttribute("indentList") != null) {
			indentList = (ArrayList) session.getAttribute("indentList");

		}
		
		List<MasManufacturer> manufacturerList = new ArrayList<MasManufacturer>();
		if (map.get("manufacturerList") != null) {
			manufacturerList = (ArrayList) map.get("manufacturerList");
			session.setAttribute("manufacturerList", manufacturerList);
		} else if (session.getAttribute("manufacturerList") != null) {
			manufacturerList = (ArrayList) session.getAttribute("manufacturerList");

		}
	
		List<StoreSupplyOrderEntry> supplyOrderList = new ArrayList<StoreSupplyOrderEntry>();
		if (map.get("supplyOrderList") != null) {
			supplyOrderList = (ArrayList) map.get("supplyOrderList");
			session.setAttribute("supplyOrderList", supplyOrderList);
		} else if (session.getAttribute("supplyOrderList") != null) {
			supplyOrderList = (ArrayList) session.getAttribute("supplyOrderList");

		}
		List<StoreLoaninM> searchLoanInList = new ArrayList<StoreLoaninM>();
		if (map.get("searchLoanInList") != null)
			searchLoanInList = (List) map.get("searchLoanInList");
		String message = "";
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		if(map.get("brandList") != null){
			brandList = (ArrayList) map.get("brandList");
			session.setAttribute("brandList",brandList);
		}else if(session.getAttribute("brandList") != null){
			brandList = (ArrayList)session.getAttribute("brandList");
			
		}
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		List<StoreLoaninM> loaninList= new ArrayList<StoreLoaninM>();
		if (map.get("loaninList") != null)
			loaninList = (List) map.get("loaninList");
		
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int pageNo = 1;
		if (map.get("pageNo") != null) {
			pageNo = Integer.parseInt("" + map.get("pageNo"));
			
		}
		String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");

		}
		Box box=HMSUtil.getBox(request);
		if(map.get("box")!=null){
			box=(Box)map.get("box");
		}
		String date="";
		String time="";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");	 
		 time = (String)utilMap.get("currentTime");
		String max="";
		if(map.get("max") != null){
			max = (String) map.get("max");
		}
		includedJsp = (String) map.get("includedJsp");
	%> <script>
var nameArray=new Array();
var codeArray=new Array();
</script>



<h2 align="left" class="style1">Loan In</h2>

<div id="contentspace">

<form name="createGrn" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" id="addbutton" name="Add" type="submit" value="Add"
					class="toolbutton"
					onClick="submitForm('createGrn','stores?method=showLoanInJsp');"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('createGrn','stores?method=modifyLoanin');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="buttonHighlight"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value=" " onClick=""></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>



<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form name="searchPanel" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">From Date :</label> <input type="text"
			name="<%= FROM_DATE %>" class="textbox_date" MAXLENGTH="30"
			style="border: 1px solid #7f9db7;" tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB">To Date :</label> <input
			type="text" name="<%= TO_DATE %>" class="textbox_date" MAXLENGTH="30"
			style="border: 1px solid #7f9db7;" tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.create.<%= TO_DATE%>,true);"
			class="calender" /> <label class="bodytextB">Loan In No:</label> <select
			name="<%=LOANIN_NO%>">
			<%
			 	for (StoreLoaninM storeLoaninM : searchLoanInList) {
			 %>

			<option value=<%=storeLoaninM.getLoaninNo()%>><%=storeLoaninM.getLoaninNo()%></option>

			<%
						}
					%>

		</select> <input type="button" class="morebutton" value=" "
			onClick="submitForm('createGrn','stores?method=searchLoanin');" /> <br />
		</td>
	</tr>

</table>
       </form>

</div>
</div>

<jsp:include page="searchResultBlock.jsp" /></div>
<form name="grnGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input type="hidden"
	name="deptId" value="<%=deptId%>" />

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Loan In Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 185px; background-color: #f4f9fe;">
<br />
<label class="bodytextB">Source Of Supply:</label> <input type="text"
	class="readOnly" name="<%= SOURCE_OF_SUPPLY %>" value="Local Purchase"
	readonly="readonly" tabindex=1 /> <label class="bodytextB"><font
	id="error">*</font>Loan In No.</label> <% if(storeloanObj != null){%> <input
	type="text" class="readOnly" name="<%= LOANIN_NO %>"
	value="<%=storeloanObj.getLoaninNo()%>" readonly="readonly"
	validate="LoanIn Number ,String,yes" tabindex=1 maxlength="12" /> <%}else{ %>
<input type="text" class="readOnly" name="<%= LOANIN_NO %>"
	value="<%=max %>" readonly="readonly"
	validate="LoanIn Number ,String,yes" tabindex=1 maxlength="12" /> <%} %>


<label class="bodytextB"><font id="error">*</font> Loan In Date:</label>
<input type="text" name="<%=LOANIN_DATE%>" value="<%=currentDate %>"
	class="readOnly" readonly="readonly" MAXLENGTH="30" /> <!-- <a href="javascript:setdate('<%=currentDate%>',document.grnGrid.<%=LOANIN_DATE%>,true)">
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" /> 
		</a>	 --> <br />


<label class="bodytextB"><font id="error">*</font>Vendor Name</label> <select
	name="<%= SUPPLIER_ID%>" validate="Supplier,string,yes" tabindex=1
	onchange="submitProtoAjaxforIndent('grnGrid','/hms/hms/stores?method=responsePoList');">
	<option value="">Select</option>
	<%
			for (MasStoreSupplier masStoreSupplier : supplierList) {
				if (storeloanObj != null) {
					if (storeloanObj.getSupplier().getId().equals(
							masStoreSupplier.getId())) {
		%>

	<option value=<%=masStoreSupplier.getId()%> selected="selected"
		readonly><%=masStoreSupplier.getSupplierName()%></option>
	<%
	}
		} else {
%>

	%>
	<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%></option>
	<%
	}
	}
%>
</select>


<div id=indentDiv><label class="bodytextB">SO No:</label> <select
	name="<%=PO_ID%>" id="poId" value="<%=box.get("poId") %>"
	validate="Po,string,yes">
</select></div>




<label class="bodytextB"><font id="error">*</font>Challan Number
</label> <%if(storeloanObj != null){ %> <input type="text" name="<%=CHALLAN_NO %>"
	value="<%=storeloanObj.getChallanNo() %>"
	validate="Challan No, String ,yes" class="textbox_size20"
	MAXLENGTH="20"/  > <%}else{ %> <input type="text"
	class="textbox_size20" name="<%= CHALLAN_NO %>" value=""
	validate="Challan No, String ,yes" tabindex=1 MAXLENGTH="20" /> <%} %> <br />


<label class="bodytextB">Challan Date:</label> <input type="text"
	name="<%=CHALLAN_DATE%>" value="<%=currentDate %>" class="textbox_date"
	MAXLENGTH="30" /> <!--  	<a href="javascript:setdate('<%=currentDate%>',document.grnGrid.<%=CHALLAN_DATE%>,true)">
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" /> 
		</a>
		--> <label class="bodytextB"> <font id="error">*</font>Unpack-Check
By:</label> <select name="<%=EMPLOYEE_ID %>" validate="Employee,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%
			for (MasEmployee masEmployee : employeeList) {
		%>

	<option value="<%=masEmployee.getId ()%>"><%=masEmployee.getFirstName()+"  "+masEmployee.getLastName()%></option>
	<%
		  	}
		  %>
</select> <label class="bodytextB">Remarks</label> <%if(storeloanObj != null){ %> <textarea
	value="<%=storeloanObj.getRemarks()%>" name="<%=REMARKS %>"
	validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 310px;" maxlength="45" /> </textarea> <%}else{ %> <textarea value=""
	name="<%=REMARKS %>" validate="Remarks ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	style="width: 310px;" maxlength="45" /> </textarea> <%} %> <br />



<br /></div>
<br />

<div style="float: left; padding-left: 15px;"><input type="button"
	name="sss" align="right" class="button" value="Submit"
	onclick="if(checkForLoanInGrid() && testForLoanIn()&& checkSave()&&checkForSubmit()){submitForm('grnGrid','stores?method=submitLoanIn');}" />
<input type="button" name="sss" align="right" class="button"
	value="Brand" onclick="get_valueForBrand();" /></div>
<input type="hidden" size="2" value="0" name="noOfRows" id="noOfRows" />
<input type="hidden" name="<%=LOANIN_ID %>" value="<%=loanInId%>"
	id="hdb" /> <br />

<div id="gridDiv"></div>


<br />
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="totalAmount" id="totalAmount" value=""><input
	type="hidden" value="" id="totalAmountTemp"><script
	type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /> <br />
<br />
</div>
</div>

</form>

</div>