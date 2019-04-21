<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indentS.jsp  
 * Purpose of the JSP -  This is for indentS.
 * @author  Mansis
 * @author  Deepali
 * Create Date: 21th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.StringTokenizer"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>


<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

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

<%
	String patientDetails=""; 
	int itemReqDept=0;
	String pacEqpt="";
	String pacJustification="";
	int dose=0;
	int days=0;
	int course=0;
	int duration=0;
	int durationType=0;
	String PvmsAlreadyPrescribed="";
	String justificationNiv="";
	String clinicalTrailReq="";
	
	
	
	Map map = new HashMap();
	String includedJsp = null;
	String userName="";
	int pageNo=1;
	int indentId=0;
	String date="";
	String time="";
		List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
		List<MasStoreSection> sectionList= new ArrayList<MasStoreSection>();
		List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
		List<MasStoreSupplier>	supplierList=new ArrayList<MasStoreSupplier>();
		String  maxIndentNo="";
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("indentId")!=null){
		indentId=Integer.parseInt(""+map.get("indentId"));
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}

	//Header Information
	if(map.get("patientDetails")!=null)
		patientDetails=(""+map.get("patientDetails"));
	
	if(map.get("itemReqDept")!=null)
		itemReqDept=Integer.parseInt((""+map.get("itemReqDept"))) ;

	if(map.get("pacEqpt")!=null)
		pacEqpt=(""+map.get("pacEqpt"));

	if(map.get("pacJustification")!=null)
		pacJustification=(""+map.get("pacJustification"));

	if(map.get("dose")!=null)
		dose=Integer.parseInt((""+map.get("dose"))) ;

	if(map.get("days")!=null)
		days=Integer.parseInt((""+map.get("days"))) ;

	if(map.get("course")!=null)
		course=Integer.parseInt((""+map.get("course"))) ;

	if(map.get("duration")!=null)
		duration=Integer.parseInt((""+map.get("duration"))) ;

	if(map.get("durationType")!=null)
		days=Integer.parseInt((""+map.get("durationType"))) ;

	if(map.get("PvmsAlreadyPrescribed")!=null)
		PvmsAlreadyPrescribed=((""+map.get("PvmsAlreadyPrescribed"))) ;
	
	if(map.get("justificationNiv")!=null)
		justificationNiv=((""+map.get("justificationNiv"))) ;
	
	if(map.get("clinicalTrailReq")!=null)
		clinicalTrailReq=((""+map.get("clinicalTrailReq"))) ;

	
	//End of Header Information 
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=(""+map.get("maxIndentNo"));
	
	if(map.get("sectionList")!=null)
	sectionList=(List) map.get("sectionList");
	if(map.get("departmentList")!=null)
		departmentList=(List) map.get("departmentList");
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List) map.get("searchIndentList");
	
	if(map.get("supplierList")!=null)
		supplierList = (List) map.get("supplierList");
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	 if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	 Set set=new HashSet();
	 String indentNo="";
	 
	 if(map.get("indentNo")!=null)
			indentNo=""+map.get("indentNo");
	 
	 
%>
<script language="javascript">
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
function checkForSOC(val,a,inc){
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
		ajaxFunctionForAutoCompleteInSOC('indentToSoc','stores?method=fillItemsForIndentToSOC&pvmsNo=' + pvms ,inc);
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
  function fillUnitRate(inc)
  {
   	if(document.getElementById('unitRateTemp'+inc).value!=""){
    	document.getElementById('unitRate'+inc).value=document.getElementById('unitRateTemp'+inc).value
    	}else{
    		document.getElementById('unitRate'+inc).value=0
    	}
  }
  function fillDate(inc)
  {
  if(validateDateSOC(document.getElementById('lastRecpDateTemp'+inc).value)){
  }else{
  document.getElementById('lastRecpDateTemp'+inc).value=""
  	alert("Invalid Date..!")
  	return false
  }
   	if(document.getElementById('lastRecpDateTemp'+inc).value!=""){
    	document.getElementById('lastRecpDate'+inc).value=document.getElementById('lastRecpDateTemp'+inc).value
    	}
  }
  
function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printIndentSJsp";
  obj.submit();
}
 </script>
<style>
.bodytextBtab {
	FONT-SIZE: 11px;
	COLOR: #0438A5;
	font-weight: bold;
	LINE-HEIGHT: 16px;
	font-family: "Trebuchet MS", Tahoma, "Arial Narrow", Arial;
	width: auto;
	padding-left: 6px;
	padding-top: 4px;
}

.smalllabel1 {
	text-align: left !important;
	width: auto;
	height: 25px !important;
	font-size: 11px;
	font-weight: bold;
	padding-top: 4px;
	padding-left: 3px;
	color: #000000 !important;
	font-family: "Trebuchet MS", Tahoma, "Arial Narrow", Arial;
}
</style>


<div id="contentspace">

<form name="indentToSoc" method="post"><br />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h2 align="left" class="style1">Indent To DGAFMS in the form of SOC</h2>
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
					class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');"></td>
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
					value="Print" onClick="showReport('indentGrid');"></td>

				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>



			</tr>
		</table>
		</td>
	</tr>
</table>
<%-- Start of Search Panel--%>
<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">
<form name="searchPanel" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<table width="330" border="0" cellpadding="2" cellspacing="1"
	style="border: 1px solid #245E83;">
	<tr>
		<td width="324" class="thead">Search Panel<a
			name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><label
			class="bodytextB">Indent No:</label> <select
			name="<%= RequestConstants.INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%
					for (StoreIndentM storeIndentM :searchIndentList ) {
				%>

			<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>

			<%
					}
				%>
		</select> <input type="button" class="morebutton" value=" "
			onClick="submitForm('indentToSoc','stores?method=searchIndentSOC');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<%-- End of Search Panel--%></form>

<form name="indentGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


<div id="testDiv" size="height:500px;"><input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" /> <br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 110px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">



<label class="bodytextB"><font id="error"></font> Indent No: </label> <input
	type="text" name="<%=RequestConstants.INDENT_NO %>"
	value="<%=maxIndentNo%>" readonly="readonly" class="readOnly"
	MAXLENGTH="8"/  ><label class="bodytextB"><font
	id="error"></font>Date of SOC :</label> <input type="text"
	name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"
	value="<%=date%>" class="readOnly" MAXLENGTH="30" /> <label
	class="bodytextB"><font id="error"></font>Command:</label> <input
	type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="CHAF,Bangalore"
	class="readOnly" MAXLENGTH="20" /> <br />
<label class="bodytextB"><font id="error"></font>Hosp/Unit Addr:</label>
<input type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="CHAF,Bangalore"
	class="readOnly" MAXLENGTH="20" /> <label class="bodytextB"><font
	id="error"></font>Item Dept:</label> <select
	name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" tabindex="1">
	<option value="0">Select</option>
	<%for(MasDepartment department:departmentList){ %>
	<option value="<%=department.getId() %>"><%=department.getDepartmentName() %></option>
	<%} %>
</select> <br />
<label class="bodytextB"><font id="error"></font>Details of
Patient:</label> <textarea name="<%=RequestConstants.DETAIL_OF_PATIENT%>"
	tabindex="1" cols="25" rows="2" class="txtarea"></textarea> <label
	class="bodytextB"><font id="error"></font>Indent To:</label> <input
	type="text" readonly="readonly"
	name="<%=RequestConstants.DEPARTMENT_ID %>" value="DGAFMS "
	class="readOnly" MAXLENGTH="30" /></div>
<br />


<div style="float: left; padding-left: 15px;"><input type="hidden"
	class="button" value="Next" onclick="" align="right" /> <input
	type="button" name="sss" align="right" class="button" value="Submit"
	onclick="if(checkForSubmit()){submitForm('indentGrid','stores?method=addNextOrSubmitIndentToSOC&buttonName=submit');}" />

</div>


<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 65px;"><%=pageNo%></div>
</div>

<input type="hidden" name="" value="222" id="currentRow" /> <input
	type="hidden" size="2" value="1"
	name="<%=RequestConstants.NO_OF_ROWS %>"
	id="<%=RequestConstants.NO_OF_ROWS %>" /> <input type="hidden"
	name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>"
	id="indentId" /> <br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Item Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />



<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<td width="5%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="13%"><label valign="left" class="smalllabel">Stock
			in</label></td>
			<td width="10%"><label valign="left" class="smalllabel1">Unit
			rate</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Brand
			Name</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Manufac.
			By</
			</div>
			<td width="5%"><label valign="left" class="smalllabel">Marketed
			By</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Qty</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Cost</label></td>
			<td width="5%"><label valign="left" class="smalllabel">Last
			Rcp Date</label></td>
		</tr>

	</thead>
	<tbody>




		<%
    	
    	int temp=0;
    	int detailCounter=8; 
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idSection="idSection";
    	String nameSection="nameSection";
    	String idAu="idAu";
    	
    	String stockInVar="stockInVar";
    	String mmfVar="mmfVar";
    	String demandVar="demandVar";
    	
    	String stockInVarTemp="stockInVarTemp";
    	String mmfVarTemp="mmfVarTemp";
    	String demandVarTemp="demandVarTemp";
    	String incVar="incVar";
    	String qtyInHandTemp="qtyInHandTemp";
    	String qtyInHand="qtyInHand";
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idSection2="idSection";
    	String nameSection2="nameSection";
    	String idAu2="idAu";
    	
    	String stockInVar2="stockInVar";
    	String mmfVar2="mmfVar";
    	String demandVar2="demandVar";

    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	
    	
    	String unitRate="unitRate";
    	String unitRateTemp="unitRateTemp";
    	String brandId="brandId";
    	String lastRecpDate="lastRecpDate";
    	String lastRecpDateTemp="lastRecpDateTemp";
    	String lastRecpQty="lastRecpQty";
    	String qtyTemp="qtyTemp";
    	String totalCost="totalCost";
    	String totalCostTemp="totalCostTemp";
    	String markBy="markBy";
    	
    	String unitRate2="unitRate";
    	String brandId2="brandId";
    	String lastRecpDate2="lastRecpDate";
    	String lastRecpQty2="lastRecpQty";
    	String totalCost2="totalCost";
    	String markBy2="markBy";
    	String qtyInHandTemp2="qtyInHandTemp";
    	String qtyInHand2="qtyInHand";
    	String manuId="manuId";
    	String manuId2="manuId";
    	
    	String manuIdTemp="manuIdTemp";
    	String manuIdTemp2="manuIdTemp";
    	String unitRateTemp2="unitRateTemp";
    	String qtyTemp2="qtyTemp";
    	String totalCostTemp2="totalCostTemp";
    	String lastRecpDateTemp2="lastRecpDateTemp";
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=detailCounter;inc++){
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idSection=idSection2+(""+inc);
     		nameSection=nameSection2+(""+inc);
     		idAu=idAu2+(""+inc);
     		
     		stockInVar=stockInVar2+(""+inc);
     		mmfVar=mmfVar2+(""+inc);
     		demandVar=demandVar2+(""+inc);
     		
     		manuId=manuId2+(""+inc);
     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		
     		
     		 unitRate=unitRate2+(""+inc);
        	 brandId=brandId2+(""+inc);
        	 lastRecpDate=lastRecpDate2+(""+inc);
        	 lastRecpQty=lastRecpQty2+(""+inc);
        	 totalCost=totalCost2+(""+inc);
        	 markBy=markBy2+(""+inc);
        	 
        	 qtyInHandTemp=qtyInHandTemp2+(""+inc);
     		qtyInHand=qtyInHand2+(""+inc);
     		
     		unitRateTemp=unitRateTemp2+(""+inc);
     		qtyTemp=qtyTemp2+(""+inc);
     		totalCostTemp=totalCostTemp2+(""+inc);
     		lastRecpDateTemp=lastRecpDateTemp2+(""+inc);
     		manuIdTemp=manuIdTemp2+(""+inc);
    	  %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text" class="medcaption"
				name="<%=RequestConstants.ITEM_CODE %>" readonly="readonly"
				id="<%=codeItem%>" /> <input type="hidden" size="2" value="0"
				class="smcaption" name="<%=RequestConstants.ITEM_ID%>"
				id="<%=idItem%>" /></td>
			<td width="10%"><input type="text" value="" tabindex="1"
				id="<%=nameItem%>" class="bigcaption"
				onblur="if(fillSrNo){checkForSOC(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; padding-right: 550px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForLoanoutByAutocomplete',{parameters:'requiredField=<%=nameItem%>'});
		</script></td>
			<td width="10%"><input type="text" value="" class="smcaption"
				readonly="readonly" name="<%=RequestConstants.AV%>" id="<%=idAu%>" /></td>
			<td width="10%"><input type="text" readonly="readonly" value=""
				class="medcaption" name="" id="<%=qtyInHandTemp%>"
				validate="Qty In Stock,num,no" /> <input type="hidden" value="0"
				class="medcaption" name="<%=RequestConstants.QTY_IN_HAND%>"
				id="<%=qtyInHand%>" /></td>
			<td width="5%"><input type="text" value="" class="medcaption"
				tabindex="1" validate="Unit Rate ,floatWithoutSpaces,no"
				id="<%=unitRateTemp %>" onblur="fillUnitRate(<%=inc%>);" /> <input
				type="hidden" value="0" class="smcaption"
				name="<%=RequestConstants.UNIT_RATE %>" id="<%=unitRate %>" /></td>
			<td width="10%"><select name="<%=RequestConstants.BRAND_ID%>"
				tabindex="1" id="<%=brandId%>"
				onchange="getManufacturerNameInAjax(this.value,<%=inc%>);">
				<option value="0">Select</option>
			</select></td>
			<td width="10%"><input id="<%=manuId %>" class="medcaption" />
			<input type="hidden" name="<%=RequestConstants.MANUFACTURER_ID %>"
				value="0" id="<%=manuIdTemp %>" /></td>
			<td width="10%"><select
				name="<%=RequestConstants.MARKETED_BY %>" tabindex="1"
				id="<%=markBy %>">
				<option value="0">Select</option>
				<%for(MasStoreSupplier masStoreSupplier : supplierList) {%>
				<option value="<%=masStoreSupplier.getSupplierName() %>"><%=masStoreSupplier.getSupplierName() %></option>
				<%} %>
			</select></td>
			<td width="5%"><input type="text" value="" class="smcaption"
				tabindex="1" validate="Last recp qty ,floatWithoutSpaces,no"
				id="<%=qtyTemp%>" onblur="calculateTotalForSoc(<%=inc %>);" /> <input
				type="hidden" value="0" class="smcaption"
				name="<%=RequestConstants.LAST_RECP_QTY %>" id="<%=lastRecpQty %>" />
			</td>
			<td width="5%"><input type="text" value="" readonly="readonly"
				class="smcaption" id="<%=totalCostTemp %>" /> <input type="hidden"
				value="0" class="smcaption" name="<%=RequestConstants.TOTAL_COST %>"
				id="<%=totalCost %>" /></td>
			<td width="10%"><input type="text" value="" class="medcaption"
				tabindex="1" id="<%=lastRecpDateTemp%>"
				onblur="fillDate('<%=inc%>');" /> <input type="hidden"
				value="<%=date%>" class="medcaption"
				name="<%=RequestConstants.LAST_RECP_DATE %>" id="<%=lastRecpDate %>" />
			</td>

		</tr>
		<%   } %>
	</tbody>
</table>


<br />
<table class="grid_header" cellpadding="2" cellspacing="0" width="100%">
	<tbody>
		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>PAC / Eqpt specific (for expendables)</font>
			<td colspan="9"><select name="<%= RequestConstants.PAC%>"
				validate="PAC ,String,yes">
				<option value="">Select</option>
				<option value="NA">NA</option>
				<option value="Yes">Yes</option>
			</select></td>
		</tr>


		<tr>
			<td valign="top" width="201"><font class="bodytextBtab"><font
				id="error"></font>If PAC, General Detail justification:</font></td>
			<td colspan="9"><textarea
				name="<%=RequestConstants.PAC_JUSTIFICATION%>" rows="2" cols="30"
				validate="If PAC, General Detail justification ,num,yes"></textarea>
			</td>
		</tr>

		<tr>
			<td><font class="bodytextBtab"><font id="error"></font>Dose
			(for drugs) Day/ Course:</font></td>
			<td width="36"><input name="<%=RequestConstants.DOSE %>"
				type="text" class="smcaption" size="6" validate="Dose ,num,yes" /></td>
			<td width="23"><font class="bodytextBtab">For</font></td>
			<td width="39"><input name="<%=RequestConstants.DAYS %>"
				class="smcaption" size="6" validate="Days ,num,yes" /></td>
			<td width="33"><font class="bodytextBtab">Days</font></td>
			<td width="39"><input name="<%=RequestConstants.COURSE %>"
				class="smcaption" size="6" validate="Corse ,num,yes" /></td>
			<td width="47"><font class="bodytextBtab">Course</font></td>
			<td width="39"><input name="<%=RequestConstants.DURATION%>"
				class="smcaption" size="6" validate="Duration ,num,yes" /></td>
			<td colspan="2"><select
				name="<%= RequestConstants.DURATION_TYPE%>"
				validate="Duration Type,String,yes">
				<option value="0">Select</option>
				<option value="Yearly">Yearly</option>
				<option value="Monthly">Monthly</option>
				<option value="Weekly">Weekly</option>
				<option value="Others">Others</option>

			</select></td>
		</tr>



		<tr>
			<td width="201" valign="top"><font class="bodytextBtab"><font
				id="error"></font>PVMS / NIV drugs substitute already prescribed:</font></td>
			<td colspan="7" rowspan="2" valign="top"><textarea
				name="<%=RequestConstants.PVMS_ALREADY_PRESCRIBED%>" rows="2"
				cols="25"
				validate="PVMS / NIV drugs substitute already prescribed,String,yes"></textarea></td>
			<td width="211" valign="top"><font class="bodytextBtab"><font
				id="error"></font>Justification of using NIV item:</font></td>
			<td width="280" rowspan="2" valign="top"><textarea
				name="<%=RequestConstants.JUSTIFICATION_NIV  %>" rows="2" cols="25"
				validate="Justification of using NIV item,String,yes"></textarea></td>
		</tr>
		<tr>
			<td width="201" valign="top">&nbsp;</td>
			<td valign="top">&nbsp;</td>
		</tr>


		<tr>
			<td><font class="bodytextBtab"><font id="error"></font>Clinical
			trial required :</font></td>
			<td colspan="9"><select
				name="<%= RequestConstants.CLINICAL_TRAIL_REQ%>"
				validate="Clinical,String,yes">
				<option value="">Select</option>
				<option value="Y">Yes</option>
				<option value="N">No</option>
			</select></td>
		</tr>
	</tbody>
</table>



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
</form>

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script></div>
</form>

</div>
