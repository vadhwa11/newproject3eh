<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifyWorkOrder.jsp
 * Purpose of the JSP -  This is for work order view .
 * @author  Abha
  
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderT"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>


<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />

<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script> 
<script language="javascript">
	

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

  function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/neStores?method=generateWorkOrderReport";
  obj.submit();
}

</script>

<script language="javascript">

function checkForWorkOrder(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*10)+1;
    	var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    
	  
		ajaxFunctionForAutoCompleteInWorkOrder('grnGrid','neStores?method=fillItemsForWorkOrder&pvmsNo=' + pvms , inc);
		
}
  
 </script>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int pageNo=1;
	String noDetailRecords="no";
	List<StoreWorkOrderM> workOrderList = new ArrayList<StoreWorkOrderM>();
	List<StoreWorkOrderM> gridWorkOrderMList= new ArrayList<StoreWorkOrderM>();
	List<StoreWorkOrderT> gridWorkOrderTList= new ArrayList<StoreWorkOrderT>();
	List<MasStoreItem> itemList= new ArrayList<MasStoreItem>();
	String maxNo="";
	String date="";
	String time="";
	String userName = "";
	List objectList=new ArrayList();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	//--------Hearder Variables-------
	String workOrderNo="";
	int workOrderId=0;
	String max="";
	String option="";
	
	//--------End -------- Hearder Variables-------
	
	if (request.getAttribute("map") != null) 
		map = (Map) request.getAttribute("map");
	if(map.get("workOrderNo")!=null)
		workOrderNo=""+map.get("workOrderNo");
	if(map.get("workOrderId")!=null)
		workOrderId= Integer.parseInt(""+map.get("workOrderId")) ;
	if(map.get("option")!=null)
		option=(""+map.get("option")) ;
	
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if(map.get("max")!=null)
		max=(""+map.get("max"));
	
	Box box=HMSUtil.getBox(request);
	if(map.get("box")!=null){
		box=(Box)map.get("box");
	}
	
	if(map.get("objectList")!=null)
		objectList=(List) map.get("objectList");
	if(map.get("workOrderList")!=null)
		workOrderList = (List) map.get("workOrderList");
	if(map.get("itemList")!=null)
		itemList=(List) map.get("itemList");
	if(map.get("gridWorkOrderMList")!=null)
		gridWorkOrderMList=(List) map.get("gridWorkOrderMList");
	if(map.get("gridWorkOrderTList")!=null)
		gridWorkOrderTList=(List) map.get("gridWorkOrderTList");
	if(map.get("noDetailRecords")!=null){
		noDetailRecords=(""+map.get("noDetailRecords"));
	}
	
	
	
%>

<br />

<style>
#contentspace label {
	text-align: right;
	width: 91px;
	float: left;
	height: 9px;
}
</style>

<h2 align="left" class="style1">Work Order -View</h2>

<div id="contentspace">

<form name="indent" method="post">
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
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton"
					onClick="submitForm('indent','neStores?method=showWorkOrderJsp');"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Reset" type="submit" value="Reset"
					class="buttonHighlight"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Print" value="Print" class="toolbutton"
					onClick="submitForm('indent','neStores?method=generateWorkOrderReport&workOrderId=<%=workOrderId %>');"></td>
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
<table width="303" border="0" cellpadding="2" cellspacing="1">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">Work Order No:</label> <select
			name="<%= WORK_ORDER_NO%>">
			<option value="0">Select</option>
			<%
					for (StoreWorkOrderM storeWorkOrderM :workOrderList ) {
				%>

			<option value=<%=storeWorkOrderM.getId()%>><%=storeWorkOrderM.getWorkOrderNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="morebutton" value=" "
			onClick="submitForm('indent','stores?method=searchIndentDepot');" />
		</td>
	</tr>

</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
</div>
<br />
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>

<form name="indentGrid" method="post"><input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input type="hidden"
	size="2" value="0" name="<%=NO_OF_ROWS%>" id="<%=NO_OF_ROWS%>" /> <input
	type="hidden" name="<%=WORK_ORDER_ID %>" value="<%=workOrderId%>"
	id="workOrderId" /> <input type="hidden" name="<%=NO_DETAIL_RECORDS%>"
	value="<%=noDetailRecords%>" /> <%if(pageNo==1){
				for(StoreWorkOrderM storeWorkOrderM:gridWorkOrderMList){
			%>




<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Work Order Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 65px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">


<label class="bodytextB"><font id="error">*</font>Repairing Cell</label>
<select name="<%=REPAIRING_CELL%>" readonly id="sourceCombo" tabindex=1>
	<% if(storeWorkOrderM != null){
					if(storeWorkOrderM.getRepairingCell().equals("e")){%>
	<option value=<%=storeWorkOrderM.getRepairingCell()%>><%="EME WorkShop"%></option>
	<%}else if(storeWorkOrderM.getRepairingCell().equals("c")){ %>
	<option value=<%=storeWorkOrderM.getRepairingCell() %>><%="CRC" %></option>
	<%}else if(storeWorkOrderM.getRepairingCell().equals("f")){ %>
	<option value=<%=storeWorkOrderM.getRepairingCell() %>><%="By Civil Firm" %></option>
	<%} else if(storeWorkOrderM.getRepairingCell().equals("0")){%>
	<option value=<%=storeWorkOrderM.getRepairingCell() %>><%="No Value" %></option>
	<%}}%>

</select> <label class="bodytextB"><font id="error">*</font>Hospital Name</label>
<input type="text" readonly="readonly" name="" value="CHAF,Bangalore"
	class="readOnly" MAXLENGTH="20" /> <label class="bodytextB"><font
	id="error">*</font> Work Order No:</label> <input type="text"
	name="<%=WORK_ORDER_NO %>"
	value="<%=storeWorkOrderM.getWorkOrderNo()%>" readonly="readonly"
	class="readOnly" MAXLENGTH="8"/  ><br />
<label class="bodytextB"><font id="error">*</font>Work
OrderDate:</label> <input type="text" name="<%=WORK_ORDER_DATE%>"
	readonly="readonly"
	value="<%=HMSUtil.changeDateToddMMyyyy(storeWorkOrderM.getWorkOrderDate())%>"
	class="readOnly" MAXLENGTH="30" /> <label class="bodytextB"><font
	id="error">*</font>Ward/ Dept:</label> <input type="text" name=""
	value="<%=storeWorkOrderM.getDepartment().getDepartmentName()%>"
	readonly="readonly" class="readOnly" MAXLENGTH="20" /> <label
	class="bodytextB"><font id="error">*</font>Auth </label> <input
	type="text" readonly="readonly" name=""
	value="<%=storeWorkOrderM.getAuthorityNo()%>" class="readOnly"
	MAXLENGTH="20" /> <%}}else{ %> <label class="bodytextB"><font
	id="error">*</font>Repairing Cell</label> <select name="<%=REPAIRING_CELL%>"
	id="sourceCombo" tabindex=1>
	<option value="0">Select</option>
	<option value="e">EME WorkShop</option>
	<option value="c">CRC</option>
	<option value="f">By Civil Firm</option>
</select> <label class="bodytextB"><font id="error">*</font>Hospital Name</label>
<input type="text" readonly="readonly" name="" value="CHAF,Bangalore"
	class="readOnly" MAXLENGTH="20" /> <label class="bodytextB"><font
	id="error">*</font> Work Order No: </label> <input type="text"
	name="<%=WORK_ORDER_NO %>" value="<%=workOrderNo%>" readonly="readonly"
	class="readOnly" MAXLENGTH="8"/  ><br />
<label class="bodytextB"><font id="error">*</font>Work
OrderDate:</label> <input type="text" name="" readonly="readonly"
	value="<%=date%>" class="readOnly" MAXLENGTH="30" /> <input
	type="hidden" name="<%=WORK_ORDER_DATE%>" value="<%=date %>"
	class="textbox_size20" MAXLENGTH="30" /> <label class="bodytextB"><font
	id="error">*</font>Ward/ Dept:</label> <input type="text" readonly="readonly"
	name="" value="" class="readOnly" MAXLENGTH="20" /> <label
	class="bodytextB"><font id="error">*</font>Auth </label> <input
	type="text" readonly="readonly" name="" value="" class="readOnly"
	MAXLENGTH="20" /> <br />

<%} %>
</div>
<br />
<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
</div>

<br />
<div
	style="overflow: auto; width: 100%; height: 220px; padding-left: 9px;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="gridsmlabel">S.No.</label></td>
			<td width="8%"><label valign="left" class="smalllabel">PVMS/NIV
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="9%"><label valign="left" class="smalllabel">A/U</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Serial
			No</label></td>
			<td width="9%"><label valign="left" class="smalllabel">Quantity</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Nature
			Of Work </label></td>
			<td width="9%"><label valign="left" class="smalllabel">Remarks</label></td>

		</tr>

	</thead>
	<tbody>
		<%
    	int inc=1;
    	int detailCounter=10; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String quanRec="quanRec";
    	String quanRecTemp="quanRecTemp";
    	String incVar="incVar";
    	String remarks ="remarks";
    	String remarksTemp="remarksTemp";
    	String natOfWrk ="natOfWrk";
    	String natOfWrkTemp ="natOfWrkTemp";
    	String batchNo="batchNo";
    	
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
    	String quanRec2="quanRec";
    	String quanRecTemp2="quanRecTemp";
    	String incVar2="incVar2";
    	String natOfWrk2="natOfWrk";
    	String natOfWrkTemp2="natOfWrkTemp";
    	String remarks2="remarks";
    	String remarksTemp2="remarksTemp";
    	String batchNo2="batchNo";
    	
    	if(pageNo!=1){
    	inc=((pageNo-1)*10)+1;
    	}
 	   
 	   int incTemp2=inc+10;
 	   for(StoreWorkOrderT storeWorkOrderT:gridWorkOrderTList){
 		 
 		  if(inc<=incTemp2){
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		quanRec=quanRec2+(""+inc);
     		quanRecTemp=quanRecTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		remarks = remarks2+(""+inc);
     		remarksTemp =remarksTemp2+(""+inc);
     		natOfWrk = natOfWrk2+(""+inc);
     		natOfWrkTemp = natOfWrkTemp2+(""+inc);
     		batchNo =batchNo2+(""+inc);
     		incVar=incVar2+(""+inc);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2"
				value="<%=storeWorkOrderT.getSrNo()%>" class="smcaption"
				name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%">
			<%if(storeWorkOrderT.getItem().getPvmsNo()!=null){ %> <input
				type="text" value="<%=storeWorkOrderT.getItem().getPvmsNo() %>"
				class="medcaption" name="<%=NEW_NIV %>" readonly="readonly"
				id="<%=codeItem%>" /> <%}else{ %> <input type="text" value=" "
				class="medcaption" name="<%=ITEM_CODE %>" readonly="readonly"
				id="<%=codeItem%>" /> <%} %> <input type="hidden"
				name="<%=DETAIL_ID %>" value="<%=storeWorkOrderT.getId() %>"
				id="hdb" /></td>

			<td width="10%"><input type="text"
				value="<%=storeWorkOrderT.getItem().getNomenclature() %>"
				id="<%=nameItem%>" class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForWorkOrder(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','neStores?method=getItemListForWorkOrderByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
		</script></td>

			<td width="10%"><input type="text"
				value="<%=storeWorkOrderT.getItem().getItemConversion().getItemUnitName() %>"
				readonly="readonly" class="smcaption" readonly="readonly"
				name="<%=AV%>" id="<%=idAu%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeWorkOrderT.getSerialNo() %>" class="medcaption"
				readonly="readonly" name="<%=BATCH_NO%>" tabindex="2"
				id="<%=batchNo%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeWorkOrderT.getQuantity() %>" class="medcaption"
				readonly="readonly" name="<%=QUANTITY_RECEIVED%>" tabindex="2"
				id="<%=quanRec%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeWorkOrderT.getNatureOfWork() %>" class="medcaption"
				readonly="readonly" name="<%=NATURE_OF_WORK %>" tabindex="2"
				id="<%=natOfWrk%>" /></td>

			<td width="10%"><input type="text"
				value="<%=storeWorkOrderT.getRemarks() %>" class="medcaption"
				readonly="readonly" name="<%=REMARKS %>" tabindex="2"
				id="<%=remarks%>" /></td>


		</tr>
		<% inc++;}}%>
		<script>
	    	 document.indentGrid.noOfRows.value=<%=inc-((pageNo-1)*10)-1%>
	    	 </script>

		<%if(inc<incTemp2){
			  for(;inc<incTemp2;inc++){
				  idItem=idItem2+(""+inc);
		     		codeItem=codeItem2+(""+inc);
		     		nameItem=nameItem2+(""+inc);
		     		idAu=idAu2+(""+inc);
		     		quanRec=quanRec2+(""+inc);
		     		quanRecTemp=quanRecTemp2+(""+inc);
		     		incVar=incVar2+(""+inc);
		     		remarks = remarks2+(""+inc);
		     		remarksTemp =remarksTemp2+(""+inc);
		     		natOfWrk = natOfWrk2+(""+inc);
		     		natOfWrkTemp = natOfWrkTemp2+(""+inc);
		     		incVar=incVar2+(""+inc);
		     		
			  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /></td>

			<td width="10%"><input type="text" value="" id="<%=nameItem%>"
				class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForWorkOrder(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','neStores?method=getItemListForWorkOrderByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
		</script></td>

			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" readonly="readonly"
				id="<%=idAu%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=BATCH_NO%>" readonly="readonly" tabindex="2"
				id="<%=batchNo%>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=QUANTITY_RECEIVED%>" readonly="readonly" tabindex="2"
				id="<%=quanRec%>" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=NATURE_OF_WORK %>" readonly="readonly" tabindex="2"
				id="<%=natOfWrk%>" /></td>

			<td width="10%"><input type="text" value="" class="medcaption"
				name="<%=REMARKS %>" readonly="readonly" tabindex="2"
				id="<%=remarks%>" /></td>


			<td></td>
			<td></td>
			<td></td>
		</tr>

		<% }}%>

	</tbody>
</table>
</div>
<br />

<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>

</div>
