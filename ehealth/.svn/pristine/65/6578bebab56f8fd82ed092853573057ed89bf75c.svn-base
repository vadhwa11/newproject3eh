<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indentBD.jsp  
 * Purpose of the JSP -  This is for indentBD.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
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
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.util.Box"%>


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
	
	function checkForIndentToDepot(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=1;i<=8;i++){
	    if(pvms !="")
	    if(document.getElementById('codeItem'+i).value==pvms){
	    if(document.getElementById('codeItem'+inc).value!=pvms){
	    	alert("Item already selected...!")
	    	document.getElementById('nameItem'+inc).value=""
	    	
	    	return false;
	    	}
	    }}
		ajaxFunctionForAutoCompleteIndentToDepot('indent','stores?method=fillItemsForIndentToDepot&pvmsNo=' +  pvms , inc);
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
function test(){
	var errorMessage="";
	formName="indent"
	obj = eval('document.'+formName)
	if(document.getElementById('supplyDepot').value == 0)
		errorMessage=errorMessage+"Please Select supply Depot  \n"; 
	
	if(document.getElementById('typeOfIndent').value == "")
		errorMessage=errorMessage+"Please Select type Of Indent \n";
	if(document.getElementById('nrs').value == "")
		errorMessage=errorMessage+"Please fill nrs \n";
	if(document.getElementById('Authority').value == "")
		errorMessage=errorMessage+"Please Fill Authority \n";
		if(document.getElementById('address').value == "")
		errorMessage=errorMessage+"Please Fill address \n";
	
	if((document.getElementById('supplyDepot').value != 0)  &&(document.getElementById('typeOfIndent').value != "") &&(document.getElementById('nrs').value != "")&&(document.getElementById('Authority').value != "")&&(document.getElementById('address').value != "")){
		return true;
	}else{
		alert(errorMessage)
		return false
	}

}
</script>
<%
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int pageNo=1;
	Box box=HMSUtil.getBox(request);
	
	List<StoreIndentM> searchIndentList = new ArrayList<StoreIndentM>();
	List<MasStoreAirForceDepot> masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
	String maxIndentNo="";
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
	String indentNo="";
	int indentId=0;
	String indentFrom="";
	String indentDate="";
	int supplyDepot=0;
	int sectionId=0;
	int indentOption=0;
	String  nrs="";
	String authority="";
	String address="";
	//--------End -------- Hearder Variables-------
	try{
	if (request.getAttribute("map") != null) 
		map = (Map) request.getAttribute("map");
	if(map.get("indentNo")!=null)
		indentNo=""+map.get("indentNo");
	if(map.get("indentId")!=null)
	indentId= Integer.parseInt(""+map.get("indentId")) ;
	if(map.get("indentFrom")!=null)
	indentFrom =""+ map.get(" indentFrom");
	if(map.get("indentDate")!=null)
	indentDate =""+ map.get("indentDate");
	if(map.get("supplyDepot")!=null)
	supplyDepot =Integer.parseInt(""+map.get("supplyDepot")) ;
	
	if(map.get("indentOption")!=null)
		indentOption=Integer.parseInt(""+map.get("indentOption")) ;
	if(map.get("nrs")!=null)
	nrs=(""+map.get("nrs")) ;
	if(map.get("authority")!=null)
	authority=""+map.get("authority");
	if(map.get("address")!=null)
	address =""+map.get("address");
	
	
	
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	}
	if(map.get("maxIndentNo")!=null)
		maxIndentNo=(""+map.get("maxIndentNo"));
	

	if(map.get("masStoreAirForceDepotList")!=null)
		masStoreAirForceDepotList=(List) map.get("masStoreAirForceDepotList");
	if(map.get("objectList")!=null)
		objectList=(List) map.get("objectList");
	if(map.get("searchIndentList")!=null)
	searchIndentList = (List<StoreIndentM>) map.get("searchIndentList");
	

	}catch(Exception e){
		e.printStackTrace();
	}
	
%>
<style>
#contentspace label {
	text-align: right;
	width: 91px;
	float: left;
	height: 9px;
}
</style>

<br />
<h2 align="left" class="style1">Indent To Depot</h2>

<div id="contentspace">

<form name="indent" method="post">
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
					type="button" name="Modify" value="Print" class="toolbutton" /></td>
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
			onClick="submitForm('indent','stores?method=searchIndentDepot');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<%-- End of Search Panel--%> <br />
</form>

<form name="indentGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="testDiv" size="height:500px;">



<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Indent Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 130px; background-color: #f4f9fe; padding-top: 10px; padding-bottom: 5px;">

<input type="hidden" name="pageNo" value="<%=pageNo%>" id="pageNo" /> <input
	type="hidden" size="2" value="0"
	name="<%=RequestConstants.NO_OF_ROWS%>"
	id="<%=RequestConstants.NO_OF_ROWS%>" /> <input type="hidden"
	name="<%=RequestConstants.INDENT_ID %>" value="<%=indentId%>"
	id="indentId" /> <%if(indentId==0){%> <label class="bodytextB"><font
	id="error"></font> Indent No: </label> <input type="text"
	name="<%=RequestConstants.INDENT_NO %>" value="<%=maxIndentNo%>"
	readonly="readonly" class="readOnly" MAXLENGTH="8"/  ><label
	class="bodytextB"><font id="error"></font>Indentor :</label> <input
	type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB"
	class="readOnly" MAXLENGTH="20" /> <label class="bodytextB"><font
	id="error"></font>Indent Date:</label> <input type="text"
	name="<%=RequestConstants.INDENT_DATE%>" readonly="readonly"
	value="<%=date %>" class="readOnly" MAXLENGTH="30" /> <br />
<label class="bodytextB"><font id="error"></font>Supp Depot :</label> <select
	name="<%= RequestConstants.SUPPLY_DEPOT%>" id="supplyDepot"
	tabindex="1">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ %>
	<option value="<%=airForceDepot.getId() %>"
		<%=HMSUtil.isSelected(airForceDepot.getId().toString(),box.get("supplyDepot")) %>><%=airForceDepot.getAirForceDepotName()%></option>
	<%} %>
</select> <label class="bodytextB"><font id="error"></font>Typ of Indent:</label>
<select name="<%= RequestConstants.TYPE_OF_INDENT%>" id="typeOfIndent"
	tabindex="1">
	<option value="">Select</option>
	<option value="1">Emergent</option>
	<option value="2">Monthly</option>
	<option value="3">Bi-Monthly</option>
	<option value="4">Four Monthly</option>
</select> <label class="bodytextB"><font id="error"></font>NRS:</label> <input
	type="text" name="<%= RequestConstants.NRS %>" MAXLENGTH="50"
	tabindex="1" value="Bangalore" class="textbox_size20" MAXLENGTH="30"
	id="nrs" /> <br />
<label class="bodytextB"><font id="error"></font>Authority:</label> <textarea
	name="<%=RequestConstants.AUTHORITY%>" MAXLENGTH="256" tabindex="1"
	cols="27" rows="2" id="Authority" class="txtarea">37/36A && 37/37 </textarea>

<label class="bodytextB"><font id="error"></font>Postal Address:</label>
<textarea name="<%=RequestConstants.ADDRESS%>" tabindex="1"
	MAXLENGTH="200" rows="2" cols="30" id="address" class="txtarea"></textarea>

<%}else{ %> <label class="bodytextB"><font id="error"></font>
Indent No: </label> <input type="text" name="<%=RequestConstants.INDENT_NO %>"
	value="<%=indentNo%>" readonly="readonly" class="readOnly"
	MAXLENGTH="8"/  ><label class="bodytextB"><font
	id="error"></font>Indentor :</label> <input type="text" readonly="readonly"
	name="<%=RequestConstants.INDENT_FROM %>" value="Commandant,CHAFB"
	class="readOnly" MAXLENGTH="20" /> <label class="bodytextB"><font
	id="error"></font>Indent Date:</label> <input type="text" name=""
	readonly="readonly" value="<%=date%>" class="readOnly" MAXLENGTH="30" />
<input type="hidden" name="<%=RequestConstants.INDENT_DATE%>"
	value="<%=date %>" class="readOnly" MAXLENGTH="30" /> <br />

<label class="bodytextB"><font id="error"></font>Supp Depot :</label> <select
	name="<%= RequestConstants.SUPPLY_DEPOT%>" id="supplyDepot">
	<option value="0">Select</option>
	<%for(MasStoreAirForceDepot airForceDepot: masStoreAirForceDepotList){ 
					if(airForceDepot.getId()==supplyDepot){
					%>
	<option value="<%=airForceDepot.getId() %>" selected="selected"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}else{ %>
	<option value="<%=airForceDepot.getId() %>"><%=airForceDepot.getAirForceDepotName()%></option>
	<%}} %>
</select> <label class="bodytextB"><font id="error"></font>Typ of Indent:</label>
<select name="<%= RequestConstants.TYPE_OF_INDENT%>" id="typeOfIndent">
	<option value="">Select</option>
	<%if(indentOption==1){ %>
	<option value="1" selected="selected">Emergent</option>
	<%}else{ %>
	<option value="1">Emergent</option>
	<%}%>
	<%if(indentOption==2){ %>
	<option value="2" selected="selected">Monthly</option>
	<%}else{ %>
	<option value="2">Monthly</option>
	<%}%>
	<%if(indentOption==3){ %>
	<option value="3" selected="selected">Bi-Monthly</option>
	<%}else{ %>
	<option value="3">Bi-Monthly</option>
	<%}%>
	<%if(indentOption==4){ %>
	<option value="4" selected="selected">Four Monthly</option>
	<%}else{ %>
	<option value="4">Four Monthly</option>
	<%}%>
</select> <label class="bodytextB"><font id="error"></font>NRS:</label> <input
	type="text" readonly="readonly" name="nrs1" value="<%=nrs%>"
	class="readOnly" MAXLENGTH="30" id="nrs" /> <input type="hidden"
	name="<%= RequestConstants.NRS %>" value="<%=nrs%>"
	class="textbox_size20" MAXLENGTH="30" /> <br />

<label class="bodytextB"><font id="error"></font>Authority:</label> <textarea
	name="Authority1" cols="27" rows="2" readonly="readonly" id="Authority"
	class="txtarea">
				<%=authority %>
				</textarea> <input type="hidden" name="<%=RequestConstants.AUTHORITY %>"
	value="<%=authority %>" /> <label class="bodytextB"><font
	id="error"></font>Postal Address:</label> <textarea name="address2" rows="2"
	cols="30" readonly="readonly" id="address" class="txtarea"><%=address %></textarea>
<input type="hidden" name="<%=RequestConstants.ADDRESS %>"
	value="<%=address %>" /> <%} %>
</div>
<br />

<div style="float: left; padding-left: 15px;"><input type="button"
	class="button" value="Next"
	onclick="if( test()&&checkForNext()&&checkSave()){submitForm('indentGrid','stores?method=addNextOrSubmitIndentToDepot&buttonName=next');}"
	align="right" /> <input type="button" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(test()&&checkForSubmit()&& checkSave()){submitForm('indentGrid','stores?method=addNextOrSubmitIndentToDepot&buttonName=submit');}" />
</div>


<div style="float: left; padding-left: 15px; padding-bottom: 10px;">
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 65px;"><%=pageNo%></div>
</div>


<br />
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

			<td width="3%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="5%"><label valign="left" class="smalllabel">New
			PVMS No</label>
			<td width="5%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>
			<td width="3%"><label valign="left" class="smalllabel">A/U</label>
			</td>
			<td width="15%"><label valign="left" class="smalllabel">Section</label>
			</td>
			<td width="15%"><label valign="left" class="smalllabel">Qty
			In Stock </label></td>
			<td width="15%"><label valign="left" class="smalllabel">Qty
			in MMF</label></td>
			<td width="24%"><label valign="left" class="smalllabel">Qty
			Demand</label></td>
		</tr>

	</thead>
	<tbody>



		<td width="3%">
		<%
    	int detailCounter=8; 
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String qtyInHandTemp="qtyInHandTemp";
    	String qtyInHand="qtyInHand";
    	String idAu="idAu";
    	String oldNiv="oldNiv";
    	String departmentId="departmentId";
    	
    	String stockInVar="stockInVar";
    	String mmfVar="mmfVar";
    	String demandVar="demandVar";
    	
    	String stockInVarTemp="stockInVarTemp";
    	String mmfVarTemp="mmfVarTemp";
    	String demandVarTemp="demandVarTemp";
    	String incVar="incVar";
    	String section="section";
    	
    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String qtyInHandTemp2="qtyInHandTemp";
    	String qtyInHand2="qtyInHand";
    	String idAu2="idAu";
    	String oldNiv2="oldNiv";
    	
    	String stockInVar2="stockInVar";
    	String mmfVar2="mmfVar";
    	String demandVar2="demandVar";

    	String stockInVarTemp2="stockInVarTemp";
    	String mmfVarTemp2="mmfVarTemp";
    	String demandVarTemp2="demandVarTemp";
    	String incVar2="incVar2";
    	String departmentId2="departmentId";
    	String section2="section";
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=detailCounter;inc++){
     		 
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		qtyInHandTemp=qtyInHandTemp2+(""+inc);
     		qtyInHand=qtyInHand2+(""+inc);
     		idAu=idAu2+(""+inc);
     		oldNiv=oldNiv2+(""+inc);
     		stockInVar=stockInVar2+(""+inc);
     		mmfVar=mmfVar2+(""+inc);
     		demandVar=demandVar2+(""+inc);
     		departmentId=departmentId2+(""+inc);

     		stockInVarTemp=stockInVarTemp2+(""+inc);
     		mmfVarTemp=mmfVarTemp2+(""+inc);
     		demandVarTemp=demandVarTemp2+(""+inc);
     		incVar=incVar2+(""+inc);
     		section=section2+(""+inc);
    	  %>

		<tr>
			<td width="3%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>
			<td width="5%"><input name="<%=RequestConstants.NEW_NIV %>"
				type="text" class="medcaption" id="<%=codeItem%>" size="8"
				readonly="readonly" /></td>
			<td width="5%"><input name="<%=RequestConstants.ITEM_CODE %>"
				type="text" class="medcaption" id="<%=oldNiv%>" size="8"
				readonly="readonly" /> <input type="hidden" value="0"
				name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" /> <input
				type="hidden" value="0"
				name="<%=RequestConstants.DEPARTMENT_ID_TEMP%>"
				id="<%=departmentId%>" /></td>
			<td width="15%"><input type="text" value="" tabindex="1"
				id="<%=nameItem%>" class="bigcaption"
				onblur="if(fillSrNo('<%=inc %>')){checkForIndentToDepot(this.value, '<%=nameItem%>','<%=inc %>');}"
				name="<%=nameItem%>" />
			<div id="ac2update"
				style="display: none; padding-right: 550px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForIndentToDepot',{parameters:'requiredField=<%=nameItem%>&indentId='+document.getElementById('indentId').value });
			</script></td>
			<td width="3%"><input name="<%=RequestConstants.AV%>"
				type="text" class="smcaption" id="<%=idAu%>" value="" size="4"
				readonly="readonly" /></td>
			<td width="15%"><input type="text" value="" id="<%=section%>"
				class="medcaption" readonly="readonly" /></td>
			<td width="15%"><input type="text" readonly="readonly" value=""
				class="medcaption" name="" MAXLENGTH="7" id="<%=qtyInHandTemp%>"
				validate="Qty In Stock,num,no" /> <input type="hidden" value="0"
				class="medcaption" name="<%=RequestConstants.QTY_IN_HAND%>"
				id="<%=qtyInHand%>" /></td>

			<td width="15%"><input type="text" value="" class="medcaption"
				tabindex=1 name="<%=RequestConstants.QTY_IN_MMF_TEMP%>"
				MAXLENGTH="7" id="<%=mmfVarTemp%>"
				validate="Qty In MMF,floatWithoutSpaces,no"
				onblur="fillValuesForMmf(<%=inc%>);" /> <input type="hidden"
				value="0" class="medcaption" name="<%=RequestConstants.QTY_IN_MMF%>"
				tabindex="2" id="<%=mmfVar%>" /></td>
			<td width="24%"><input type="text" size="7" class="medcaption"
				value="" name="<%=RequestConstants.QTY_DEMAND%>" MAXLENGTH="7"
				tabindex="1" id="<%=demandVar%>"
				onblur="fillValuesForDemand(<%=inc%>);"
				validate="Qty In Demand,floatWithoutSpaces,no" /> <input
				type="hidden" class="medcaption" value="0"
				name="<%=RequestConstants.QTY_DEMAND_TEMP%>" tabindex="2"
				id="<%=demandVarTemp%>" /></td>
		</tr>
		<% }   %>
		
	</tbody>
</table>
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
<script type="text/javascript">vBulletin_init();</script> <input
	type="hidden" name="rows" id="rr" value="1" /></div>
</form>

</div>

