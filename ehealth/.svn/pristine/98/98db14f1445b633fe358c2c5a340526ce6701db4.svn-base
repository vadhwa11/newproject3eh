

<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasUnitOfMeasurement"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
<%@page import="jkt.hms.masters.business.StoreCopyAddressList"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>


<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<style>
#contentspace label {
	text-align: right;
	padding-right: 0px;
	width: 95px;
	float: left;
	height: 9px;
}
</style>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script> <script>

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
<style type="text/css" media="screen">
.selected {
	background-color: #888;
}
</style>

<% 
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int workOrderId=0;	
	if(map.get("workOrderId")!=null){
		workOrderId=Integer.parseInt(""+map.get("workOrderId"));
	}	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	

			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			if(map.get("departmentList") != null){
				departmentList = (ArrayList) map.get("departmentList");
				session.setAttribute("departmentList",departmentList);
			}else if(session.getAttribute("departmentList") != null){
				departmentList = (ArrayList)session.getAttribute("departmentList");
				
			}
			
		
			
			//List<StoreWorkOrderM> searchWorkOrderList= new ArrayList<StoreWorkOrderM>();
			//if(map.get("searchWorkOrderList")!=null)
				//searchWorkOrderList = (List) map.get("searchWorkOrderList");
			
			
			List<StoreWorkOrderM> workOrderList= new ArrayList<StoreWorkOrderM>();
			if(map.get("workOrderList")!=null)
				workOrderList = (List) map.get("workOrderList");
			
			
			String message="";
			if(map.get("message") != null){
				message = (String)map.get("message"); 
			}
		
			String userName = "";
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			String departmentName = "";
			if (session.getAttribute("departmentName") != null) {
				departmentName = (String) session.getAttribute("departmentName");
			}
			
			List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
			if(map.get("supplierList")!=null)
				supplierList = (List) map.get("supplierList");
			
			
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
				
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
			String max="";
			if(map.get("max") != null){
				max = (String) map.get("max");
			}
			StoreWorkOrderM  storeWorkOrderObj = null;
			
			Set<StoreItemBatchStock> set1 = new HashSet<StoreItemBatchStock>();
			if (request.getAttribute("set1") != null) {
				set1 = (Set) request.getAttribute("set1");
				

			}
			String messageTOBeVisibleToTheUser="";
			if(map.get("messageTOBeVisibleToTheUser") !=null){
				messageTOBeVisibleToTheUser=""+map.get("messageTOBeVisibleToTheUser");
			}
			%> <script>
 var nameArray=new Array();
 var itemsArray1=new Array();
 var itemsArray2 = new Array();
 var manufacturerArray = new Array();
  var brandArray = new Array();
  
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
 
 
  
  function checkForSubmit(){
  if(document.getElementById('noOfRows').value==0)
  {alert("There must be one detail row");
  return false;
  }else{
  return true;
  }
 
  }
  
  function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/neStores?method=generateWorkOrderReport";
  obj.submit();
}
</script> <script language="javascript">

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
  
 </script> <br />
<h2 align="left" class="style1">Work Order</h2>

<div id="contentspace">
<form name="createGrn" method="post" action="">

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
					onClick="submitForm('createGrn','neStores?method=showWorkOrderJsp');"></td>
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
					type="button" name="print" type="submit" class="toolbutton"
					value="Print" onClick="showReport('createGrn');"></td>
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
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">From
		Date :</label> <input type="text" name="<%= FROM_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.createGrn.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.create.<%= TO_DATE%>,true);"
			class="calender" /> <br />

		<label class="bodytextB">Work Order No:</label> <select
			name="<%=WORK_ORDER_NO%>">
			<option value="0">Select</option>
			<%
					for (StoreWorkOrderM storeWorkOrderM :workOrderList ) {
				%>

			<option value=<%=storeWorkOrderM.getId()%>><%=storeWorkOrderM.getWorkOrderNo()%></option>

			<%
					}
				%>

		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('createGrn','neStores?method=searchWorkOrder');" />
		<br />
		</td>
	</tr>

</table>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>



</div>

<form name="grnGrid" method="post">
<div>
<div>
<h2 align="left" class="style1"><%=messageTOBeVisibleToTheUser %></h2>
</div>
<br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle"> WORK ORDER </font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: auto; background-color: #f4f9fe;">

<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input
	type="hidden" name="deptId" value="<%=deptId%>" /> <label
	class="bodytextB"><font id="error">*</font>Repairing Cell</label> <select
	name="<%=REPAIRING_CELL%>" id="sourceCombo"
	validate="Repairing Cell,string,yes" tabindex=1>
	<option value="0">Select</option>
	<option value="e">EME WorkShop</option>
	<option value="c">CRC</option>
	<option value="f">By Civil Firm</option>
</select> <label class="bodytextB"><font id="error">*</font>Hospital Name</label>
<input type="text" readonly="readonly" name="" value="CHAF,Bangalore"
	class="readOnly" MAXLENGTH="20" /> <label class="bodytextB"><font
	id="error">*</font>Work Order No.</label> <% if(storeWorkOrderObj != null){%> <input
	type="text" class="readOnly" name="<%= WORK_ORDER_NO %>"
	value="<%=storeWorkOrderObj.getWorkOrderNo()%>" readonly="readonly"
	validate="GRN Number ,String,yes" tabindex=1 /> <%}else{ %> <input
	type="text" class="readOnly" name="<%= WORK_ORDER_NO %>"
	value="<%=max %>" readonly="readonly" validate="GRN Number ,String,yes"
	tabindex=1 /> <%} %> <br />
<label class="bodytextB"><font id="error">*</font> Date:</label> <input
	type="text" name="<%=WORK_ORDER_DATE%>" value="<%=currentDate %>"
	class="textbox_date" MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currentDate%>',document.grnGrid.<%=WORK_ORDER_DATE%>,true)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label class="bodytextB"><font
	id="error">*</font>Ward/ Dept:</label> <%
		
			for (MasDepartment masDepartment :departmentList ) {
				if(masDepartment.getId() == deptId){
			%> <label><%=masDepartment.getDepartmentName()%></label> <input
	type="hidden" name="<%=DEPARTMENT_ID%>"
	value="<%=masDepartment.getId() %>"> <%	break;	
				}
				}
			%> <label class="bodytextB"><font id="error">*</font>Authority
No. </label> <% if(storeWorkOrderObj != null){%> <input type="text"
	name="<%=AUTHORITY %>" value="<%=storeWorkOrderObj.getAuthorityNo()%>"
	validate="Authority Number,string,yes" class="textbox_size20"
	MAXLENGTH="30" style="width: 180px;" /> <%}else{ %> <input type="text"
	name="<%=AUTHORITY %>" value="" validate="Authority Number,string,yes"
	class="textbox_size20" MAXLENGTH="30" style="width: 130px;" /> <%} %> <br />
<br />
<div style="float: left; padding-left: 15px;"><input type="button"
	name="sss" align="right" class="button" value="Submit"
	onclick="if(checkSave()){submitForm('grnGrid','neStores?method=submitWorkOrder');}" />
</div></div>
<br />

<input type="hidden" Page No: <%=pageNo%> /> <input type="hidden"
	size="2" value="0" name="<%=NO_OF_ROWS %>" id="<%=NO_OF_ROWS %>" /> <input
	type="hidden" name="<%=WORK_ORDER_ID %>" value="<%=workOrderId%>"
	id="hdb" /> <br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Work Order Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />


<div
	style="overflow: auto; width: 100%; height: 260px; padding-left: 9px;">
<table width="200px" colspan="7" id="grnDetails" class="grid_header"
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
			<td width="23%"><label valign="left" class="smalllabel">Nature
			Of Work </label></td>
			<td width="23%"><label valign="left" class="smalllabel">Remarks</label></td>
		</tr>

	</thead>
	<tbody>


		<%
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
    	String batchNoTemp ="batchNoTemp";
    	String batchId="batchId";
    	
    	
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
    	String batchNoTemp2 ="batchNoTemp";
    	String batchId2="batchId";
    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=10;inc++){
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
     		batchNoTemp =batchNoTemp2+(""+inc);
     		batchId = batchId2+(""+inc);
     	
    	  %>
		<tr>

			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=SR_NO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text" class="medcaption"
				name="<%=ITEM_CODE %>" readonly="readonly" id="<%=codeItem%>" /> <input
				type="hidden" size="2" value="0" class="smcaption"
				name="<%=ITEM_ID%>" id="<%=idItem%>" />

			<td width="10%"><input type="text" value="" id="<%=nameItem%>"
				class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForWorkOrder(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" tabindex="2" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','neStores?method=getItemListForWorkOrderByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
		</script></td>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=AV%>" id="<%=idAu%>" tabindex="2" /></td>
			<td width="10%"><select name="<%=BATCH_ID%>" id="<%=batchId%>"
				tabindex="2">
				<option value="0">Select</option>
			</select></td>



			<td width="10%"><input type="text" value="1" class="medcaption"
				name="" id="<%=quanRecTemp%>" tabindex="2" readonly="readonly" /> <input
				type="hidden" value="1" class="medcaption"
				name="<%=QUANTITY_RECEIVED%>" tabindex="2" readonly="readonly"
				id="<%=quanRec%>" /></td>


			<td width="23%"><input type="text" value="" class="medcaption"
				name="" id="<%=natOfWrkTemp%>" tabindex="2" maxlength="150"
				onblur="fillNatureOfWorkInWorkOrder(<%=inc%>);" /> <input
				type="hidden" value="0" class="medcaption"
				name="<%=NATURE_OF_WORK %>" tabindex="2" id="<%=natOfWrk%>" /></td>


			<td width="23%"><input type="text" value="" class="medcaption"
				name="" id="<%=remarksTemp%>" tabindex="2" maxlength="100"
				onblur="fillRemarksInWorkOrder(<%=inc%>);" /> <input type="hidden"
				value="0" class="medcaption" name="<%=REMARKS %>" tabindex="2"
				id="<%=remarks%>" /></td>
		</tr>
		<%
     	 }   %>


	</tbody>
</table>


</div>

<br />

<br />
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script> <input type="hidden" name="rows" id="rr" value="1" /> <br />
<br />

</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>