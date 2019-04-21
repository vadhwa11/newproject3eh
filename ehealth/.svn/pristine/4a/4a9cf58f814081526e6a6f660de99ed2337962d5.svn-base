<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * issueToDispensary.jsp
 * Purpose of the JSP -  This is for issue to Dispensary.
 * @author  Vivek
 * Create Date: 21th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.8
--%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

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

 function checkIssueQty(){
		var issued = "no";
		for(var i=1;i<=document.getElementById('counter').value;i++){

				if(parseInt(document.getElementById('qtyIssued'+i).value) > 0){
					issued = "yes";
					break;
				}else{
					issued = "no";
				}

		}
		if(issued == "yes"){

			return true;
		}else{
			alert("Issue Quantity can not be blank. ");
			return false;
		}
		return false;
	}

	function getDataForBarcode(val,rowVal){

 if(val!=""){

 submitProtoAjaxForBarcodeData('issueDispensaryForm','stores?method=getDataForBarcode&barcodeNo='+val+'',rowVal);


 }

 }
	function checkForIssueToDispensary(val,a,inc)
	{
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*20)+1;
    	var end=((pageNo-1)*20)+20;

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	    for(i=start;i<=end;i++){
	    if(pvms ==""){
	    	document.getElementById('nameItem'+inc).value=""

	    	return ;
	    	}
	   }

		ajaxFunctionForAutoCompleteIssueToDispensary('issueDispensaryForm','stores?method=fillItemsForIssueToDispensary&pvmsNo=' +  pvms , inc);
}
	function test(){
		if(document.getElementById('mmfForTheYear').value ==0){
			alert("Please Select MMF Year..!");
			return false;
		}else{
			return true;
		}
}

    function fillValuesForPvms(pvmsNo,rowVal){
    //alert("In fillValuesForPvms----- "+document.getElementById('nameItem'+rowVal).value)
   document.getElementById('nameItem'+rowVal).value="";
   document.getElementById('idAu'+rowVal).value="";
    	ajaxFunctionForAutoCompleteIssueToDispensaryByPvmsNo('issueDispensaryForm','stores?method=fillItemsForIssueToDispensaryByPvmsNo&pvmsNo=' +  pvmsNo , rowVal);


    }

   function pvmsNomenclatureSearch()
   {
		var pvmsNo1=document.getElementById("pvmsNo1").value;
		//var ValueOfPage=document.getElementById("page").value;
		var ValueOfPage=1;
		var pageNo =parseInt(document.getElementById('pageNo').value)
		submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=goToPage&ValueOfPage='+ValueOfPage+'&pvmsSearch='+pvmsNo1+'');
   }
   function printIssueSearch()
   {
		var issueNo=document.getElementById("issueNo").value;
		//var ValueOfPage=document.getElementById("page").value;
		//var ValueOfPage=1;
		//var pageNo =parseInt(document.getElementById('pageNo').value)
	//	alert("issueNo-------------->>>>>>>>>>>>>>>>>>>"+issueNo);
		submitForm('issueGrid','stores?method=printDepartmentIssue1&issueIdPrint='+issueNo);
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

function goPage()
{
var page = parseInt(document.getElementById('page').value);
var totalPages = parseInt(document.getElementById('totalPages').value);
if (page > totalPages)
{
alert('Kindly provide valid Page No!...');
document.getElementById('page').value="";
return;
}

submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=goToPage');
}

function goNext()
{

	var pvmsNo1=document.getElementById("pvmsNo1").value;
	var ValueOfPage=document.getElementById("page").value;
	submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=next&pvmsSearch='+pvmsNo1+'');

}


function goRefresh()
{
var issueUnit = document.getElementById('issueId').value;
submitForm('issueDispensaryForm','stores?method=searchIssueCiv&issueUnit='+issueUnit);
}



 </script>
<%
Map map = new HashMap();
String userName="";
String date="";
String time="";

String includedJsp = null;
String previousPage="no";
int nrs=0;
String indentOption="";
int pageNo=1;
int indentId=0;
int internalIndentId=0;
int listSize=0;
int issueId=0;
String max="";
String pvmsNo1="";
List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
List<StoreInternalIndentM> storeInternalIndentMList = new ArrayList<StoreInternalIndentM>();
List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
List<MasStoreAirForceDepot> masStoreAirForceDepotList= new ArrayList<MasStoreAirForceDepot>();
List issueTList=new ArrayList();
List <StoreIssueM> searchListForPopup=new ArrayList<StoreIssueM>();
	int maxIndentNo=0;
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

}
Box box=HMSUtil.getBox(request);
	if(map.get("employeeList")!=null){
		employeeList = (List) map.get("employeeList");
	}
	if(map.get("storeInternalIndentMList")!=null)
		storeInternalIndentMList = (List) map.get("storeInternalIndentMList");
	if(map.get("storeInternalIndentTList")!=null)
		storeInternalIndentTList = (List) map.get("storeInternalIndentTList");
	if(map.get("departmentList")!=null)
		departmentList = (List) map.get("departmentList");

	// not used in jsp and not known from where it is coming
	if(map.get("masStoreAirForceDepotList")!=null)
		masStoreAirForceDepotList = (List) map.get("masStoreAirForceDepotList");

	if(map.get("internalIndentId")!=null){
		internalIndentId=Integer.parseInt(""+map.get("internalIndentId"));
	}
	// not used in jsp and not known from where it is coming

	if(map.get("issueTList")!=null){
		issueTList=(List)map.get("issueTList");
	}
	if(map.get("searchListForPopup")!=null){
		searchListForPopup=(List<StoreIssueM>)map.get("searchListForPopup");
	}
	List stockList= new ArrayList();
	if(map.get("stockList")!=null){
		stockList=(List)map.get("stockList");
	}
	List loanOutQtyList= new ArrayList();
	if(map.get("loanOutQtyList")!=null){
		loanOutQtyList=(List)map.get("loanOutQtyList");
	}
	if(map.get("max")!=null)
		max = (String) map.get("max");
	if(map.get("pageNo")!=null)
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	if(map.get("listSize")!=null)
		listSize = Integer.parseInt(""+map.get("listSize"));
	String deptName="";
	if(map.get("deptName")!=null){
		deptName=(String)map.get("deptName");
	}

	if(map.get("pvmsNo1")!=null){
		pvmsNo1=(String)map.get("pvmsNo1");
		box.put("pvmsNo1",pvmsNo1);
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");
	 time = (String)utilMap.get("currentTime");
	 if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	 if(map.get("issueId")!=null)
		 issueId = Integer.parseInt(""+map.get("issueId")) ;

	 if(map.get("box")!=null)
		 box =(Box) map.get("box") ;
	 if(box.get("requestDate")!=null){
			box.put(RequestConstants.REQUEST_DATE,box.get("requestDate"));
		}
	 if(map.get("requestNo")!=null){
		 box.put("requestNo",(Integer)map.get("requestNo"));
	 }

	 if(box.get("issueDate")!=null){
			box.put(RequestConstants.ISSUE_DATE,box.get("issueDate"));
		}
	 if(map.get("requestDate")!=null){
			box.put(RequestConstants.REQUEST_DATE,(String)map.get("requestDate"));
		}
	 if(map.get("issueDate")!=null){
		 box.put(RequestConstants.ISSUE_DATE,(String)map.get("issueDate"));
		}

	 int totalPages=0;
	 if(map.get("totalPages")!=null){
		 totalPages=(Integer)map.get("totalPages");
		}
%>

<form name="issueDispensaryForm" method="post"><%-- Start of Main Form --%>
<div class="clear"></div>

<div class="titleBg">
<h2>Department Issue-Modify</h2>
</div>
<div class="clear"></div>
<%-- 
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>--%>

<!-- <input type="button" name="Add" type="submit"  value="Add" class="button">
	<input type="button" name="Modify" type="submit" value="Modify" class="button"  onClick="submitForm('poMain','purchaseOrder?method=poModifyJsp');">
	<input type="button" name="Reset" type="submit" value="Reset" class="button" >

	<input type="button" name="Delete" type="submit"  value="Delete" class="button"  onClick="openDeletePopupForIssueciv();">
	--> <%--------------- End of Tool Panel ---------------------------%> <!-- thread search menu -->
	<%-- 
<form name="searchPanel" method="post">
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<%--------------- Start of Search Panel ---------------------------%> <%--<label>Issue
No:</label> <select name="<%= RequestConstants.ISSUE_UNIT_ID%>"">
	<option value="">Select</option>
	<%for (StoreIssueM storeIssueM :searchListForPopup ) {%>
	<option value=<%=storeIssueM.getId()%>><%=storeIssueM.getIssueNo()%></option>
	<%}%>
</select> <input type="image" name="button" src="/hms/jsp/images/go.gif"
	class="button"
	onClick="submitForm('searchPanel','stores?method=searchIssueCiv');" />

</div>
</form>
--%>

<%-------------------- End of Search Panel ---------------------------%>

 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<form name="issueGrid" method="post"><input type="hidden"
	name="listSize" value="<%=listSize%>" /> <input type="hidden"
	name="pageNo" value="<%=pageNo%>" id="pageNo" />

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Issue Details</h4>
<div class="clear"></div>
<div class="Block"><label> Issue No: </label> <input type="text"
	name="<%=RequestConstants.ISSUE_NO %>"
	value="<%=max+box.get("issueNo")%>" id="issueNo" readonly="readonly" class="textbox_size20"
	MAXLENGTH="8"/  ><label>Issue Date:</label> <input type="text"
	name="<%=RequestConstants.ISSUE_DATE%>" readonly="readonly"
	value="<%=box.get("issueDate") %>" class="readOnly" MAXLENGTH="30" />

<label></font><span>*</span>To Department:</label> <select
	name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>" disabled="disabled" readonly="readonly"   id="departmentIdTemp"
	validate='To Department,num,Yes'>
	<option value="">Select</option>
	<%for (MasDepartment department :departmentList ) {	%>
	<option value=<%=department.getId()%>
		<%=HMSUtil.isSelected(department.getId().toString(),box.get("departmentIdTemp")) %>><%=department.getDepartmentName()%></option>
	<%}	%>
</select>
<div class="clear"></div>
<label></font>Reference No:</label> <input type="text"
	name="<%= RequestConstants.REFERENCE %>" readonly="readonly"  id="reference"
	value="<%=box.get("reference") %>" class="textbox_size20"
	MAXLENGTH="30" /> <label></font>Demand Date:</label> <input type="text"
	name="<%= RequestConstants.REQUEST_DATE %>"
	value="<%=box.get("requestDate") %>" readonly="readonly"  class="textbox_size20"
	MAXLENGTH="30" /> <label></font><span>*</span>Request By:</label> <select
	name="<%= RequestConstants.REQUEST_BY%>" id="requestBy"
	validate="Request By,String,Yes" disabled="disabled" readonly="readonly"  >
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("requestBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select>
<div class="clear"></div>
<label><span>*</span>Approved By:</label> <select
	name="<%= RequestConstants.APPROVED_BY%>" disabled="disabled" readonly="readonly"   id="approvedBy"
	validate="Approved By,String,Yes">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("approvedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> <label>Issued By:</label> <select
	name="<%= RequestConstants.ISSUED_BY%>" disabled="disabled" readonly="readonly"   id="issuedBy"
	validate="Issued By,String,Yes">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("issuedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> <label>Demand No:</label> <%if(box.get("requestNo")!="") {%> <select
	name="<%= RequestConstants.REQUEST_NO%>"
	onchange="submitForm('issueDispensaryForm','stores?method=searchInternalIndentDetails');"
	disabled="disabled" readonly="readonly" >
	<option value="0" disabled="disabled">Select</option>
	<%try{
					for (StoreInternalIndentM storeInternalIndentM :storeInternalIndentMList ) {%>
	<option value=<%=storeInternalIndentM.getId()%>
		<%=HMSUtil.isSelected(storeInternalIndentM.getId().toString(),box.get("requestNo")) %>><%=storeInternalIndentM.getDemandNo()%></option>
	<%}}catch(Exception e){	e.printStackTrace();
					}%>
</select> <%}else{ %> <select name="<%= RequestConstants.REQUEST_NO%>" disabled="disabled">
	<option value="0">Select</option>
	<%try{for (StoreInternalIndentM storeInternalIndentM :storeInternalIndentMList ) {%>
	<option value=<%=storeInternalIndentM.getId()%>
		<%=HMSUtil.isSelected(storeInternalIndentM.getId().toString(),box.get("requestNo")) %>><%=storeInternalIndentM.getDemandNo()%></option>
	<%	}
					}catch(Exception e){
					e.printStackTrace();
					}%>
</select> <%} %> <input type="hidden" name="<%=RequestConstants.ISSUE_ID%>"
	id="issueId" value="<%=issueId %>" />

<div class="clear"></div></div>
<input type="hidden" name="issueIdForBarcode" id="issueIdForBarcode"
	value="<%=issueId %>" /> <!--  Commented By Ritu --> <!--<input type="button"tabindex="1" class="button" value="Next"  onclick="if(checkIssueQty()){submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=next');}" align="right" />
		 <input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="if(checkIssueQty()){if(checkForSubmit()){submitForm('issueGrid','stores?method=updateNextOrSubmitIssueToCiv&buttonName=submit');}}" />
 -->
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<!--  Commented By Ritu --> <!--<div id="pagination">
		Page <span class="selected"><%=pageNo %></span> of <span class="selected"><%=totalPages %></span>

		<a onclick="javascript:goNext()" class="next">Next</a>
		<input type="button" name="Go Page" type="submit" class="button" value=" " onclick="javascript:goPage();">
		<input type="text" name="ValueOfPage" size="3"<%//if(box.getString("pvmsNo1").equals("")){ %> value="<%=pageNo+1%>"<%//}else{%>value="" <%//}%> id="page"  MAXLENGTH="3" />


			<input type="text" name="ValueOfPage" size="3" value="" id="page"  MAXLENGTH="3" />
	</div>
		 		--><!-- 	<input type="button" name="Refresh" value="Refresh" onClick="goRefresh();" class="button"> -->



<input type="hidden" value="0" name="noOfRows" id="noOfRows" /> <input
	type="hidden" name="<%=RequestConstants.INDENT_ID %>"
	value="<%=indentId%>" id="hdb" /> <input type="hidden"
	name="totalPages" id="totalPages" value="<%=totalPages%>" /> <input
	type="hidden" name="pvmsNo1" id="pvmsNo1" value="" tabindex=1 /> <input
	type="hidden" name="searchFirstTime" id="searchFirstTime" value="" />
<div class="clear"></div>

<h4>Item Details</h4>
<div class="clear"></div>

<table colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th>S.No.</th>
			<th>Item Code</th>
			<th>Item Name</th>
			<th>UOM</th>
			<th width="13%">BarCode No</th>
			<th width="13%">Batch No</th>
			<th width="13%">Expiry Date</th>
			<th>Qty Requested</th>
			<th>Available Stock</th>
			<th>Qty Issued</th>
			<th>Issue</th>

		</tr>

	</thead>
	<tbody>


		<%
    	int inc = 0;
    	try{
    	int detailCounter=10;
    	int temp=0;
    	String idItem="idItem";
    	String codeItem="codeItem";
    	String nameItem="nameItem";
    	String idAu="idAu";
    	String qtyRequested="qtyRequested";
    	String incVar="incVar";
    	String issuedItemId="issuedItemId";
    	String loanOutQty="loanOutQty";
    	String issued="";

    	String idItem2="idItem";
    	String codeItem2="codeItem";
    	String nameItem2="nameItem";
    	String idAu2="idAu";
    	String qtyRequested2="qtyRequested";
    	String incVar2="incVar2";
    	String issuedItemId2="issuedItemId";
    	String loanOutQty2="loanOutQty";
    	String qtyIssued="qtyIssued";
    	String qtyIssued2="qtyIssued";
    	String detailId="detailId";
    	String detailId2="detailId";
    	String batchNo="batchNo";
    	String barCodeNo="barCodeNo";
    	String batchNo2="batchNo";
    	String barCodeNo2="barCodeNo";
    	String expiryDate="expiryDate";
    	String expiryDate2="expiryDate";
    	String issuedName="issuedName";
    	String issuedName2="issuedName";
    //	String lotNo="lotNo";
    //  String lotNo2="lotNo";
 	   int tempInc=0;
 	  int tempInc2=0;
    //	int inc=((pageNo-1)*20)+1;
  //  	int tempVar=((pageNo-1)*20)+1;
 	//   int incTemp2=inc+20;

 	inc=((pageNo-1)*issueTList.size())+1;
   	int tempVar=((pageNo-1)*issueTList.size())+1;

 	 int incTemp2=inc+issueTList.size();

 		for (Iterator iterator = issueTList.iterator(); iterator.hasNext();)
		{
		 Object[] object = (Object[]) iterator.next();

 		  tempVar--;

 		  if(inc<incTemp2){
 			 tempInc=tempInc2++;
     		idItem=idItem2+(""+inc);
     		codeItem=codeItem2+(""+inc);
     		nameItem=nameItem2+(""+inc);
     		idAu=idAu2+(""+inc);
     		qtyRequested=qtyRequested2+(""+inc);
     		incVar=incVar2+(""+inc);
     		issuedItemId=issuedItemId2+(""+inc);
     		qtyIssued=qtyIssued2+(""+inc);
     		detailId=detailId2+(""+inc);
     		issuedName=issuedName2+(""+inc);
     		loanOutQty=loanOutQty2+(""+inc);
     		batchNo=batchNo2+(""+inc);
     		barCodeNo=barCodeNo2+(""+inc);
     		expiryDate=expiryDate2+(""+inc);
     		//lotNo=lotNo2+(""+inc);
    	  %>
		<tr>

			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				id="srNo<%=inc %>" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>
			<td width="10%"><input type="text" size="8"
				name="<%=RequestConstants.ITEM_CODE%>"
				value="<%=object[1].toString() %>" id="<%=codeItem%>" readonly="readonly" /> <input
				type="hidden" value="<%=object[0].toString() %>"
				name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" /> <input
				type="hidden" value="<%=object[6].toString() %>"
				name="<%=RequestConstants.DETAIL_ID%>" id="<%=detailId%>" /></td>

			<td width="10%"><input type="text" size="15"
				value="<%=object[2].toString() %>" readonly="readonly"
				name="<%=RequestConstants.NOMENCLATURE%>" /></td>

			<td width="10%">
			<%try{ %> <input type="text" value="<%=object[3].toString() %>"
				size="8" readonly="readonly" name="<%=RequestConstants.AV%>"
				id="<%=idAu%>" /> <%}catch(Exception e){ %> <input type="text"
				value="" size="8" readonly="readonly"
				name="<%=RequestConstants.AV%>" id="<%=idAu%>" /> <%} %>
			</td>
			<td width="10%"><input type="text" size="8" value=""
				maxlength="30" tabindex="1" name="barCodeNo" readonly="readonly"  id="barCodeNo<%=inc %>"
				onblur="getDataForBarcode(this.value,<%=inc %>)" /></td>
			<td width="10%"><input type="text" size="8" value="<%=object[9].toString() != null?object[9].toString():"" %>"
				maxlength="20" tabindex="1" name="batchNo" id="batchNo<%=inc %>" readonly="readonly" />

			</td>
			<td width="10%"><input type="text" size="8" value="<%=object[10].toString() != null?object[10].toString():"" %>"
				maxlength="20" tabindex="1" name="expiryDate"
				id="expiryDate<%=inc %>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=object[7].toString()==null?"0":object[7].toString()%>"
				size="8" readonly="readonly"
				name="<%=RequestConstants.QTY_IN_REQUEST%>" id="<%=qtyRequested%>" />
			</td>
			<input type="hidden" value="<%=object[2].toString() %>"
				id="<%=nameItem%>" name="<%=RequestConstants.NOMENCLATURE%>" />
			<input type="hidden" name="" value="0" id="<%=issuedItemId%>" />

			<!-- Available stock -->
			<td width="10%">
			<%if(stockList.size()>0){
    	   %> <input type="text" readonly="readonly"  value="<%=stockList.get(tempInc) %>"
				id="availableStock<%=inc %>" size="8" readonly /> <%}else{ %> <input
				type="text" value="0" id="availableStock<%=inc %>"
				class="medcaption" readonly /> <%} %>
			</td>
			<!-- Available stock -->


			<td width="10%"><input type="text" readonly="readonly"
				value="<%=object[8].toString() %>" size="8"
				name="<%=RequestConstants.QTY_ISSUED%>" tabindex="2"
				id=<%=qtyIssued %> /></td>
			<td width="3%">
			<!-- <input type="button" class="buttonIssue"
				onclick="{openPopupForBrand(this.value,'<%=object[7].toString()%>',<%=inc%>,<%=issueId %>,<%=object[6].toString() %>);}"
				name="Submit2" value=" " /> -->
			<td />
		</tr>
		<% inc++;}  }
       					if(inc<=(pageNo-1)*20+20){
	    			  for(;inc<=(pageNo-1)*20+20;inc++){
	    				  	idItem=idItem2+(""+inc);
	    		     		codeItem=codeItem2+(""+inc);
	    		     		nameItem=nameItem2+(""+inc);
	    		     		idAu=idAu2+(""+inc);
	    		     		qtyRequested=qtyRequested2+(""+inc);
	    		     		incVar=incVar2+(""+inc);
	    		     		issuedItemId=issuedItemId2+(""+inc);
	    		     		qtyIssued=qtyIssued2+(""+inc);
	    		     		detailId=detailId2+(""+inc);
	    		     		issuedName=issuedName2+(""+inc);
	    		     		loanOutQty=loanOutQty2+(""+inc);
	    			  %><!--
	    			   <tr>
      <td width="5%"><input type="text" size="2"	value="<%=temp+inc%>" id="srNo<%=inc %>"  name="<%=RequestConstants.SR_NO%>" readonly="readonly" /></td>
      <td width="10%">

     <input type="text" size="8" name="<%=RequestConstants.ITEM_CODE%>" value="" id="<%=codeItem%>" onblur="fillValuesForPvms(this.value,'<%=inc %>')"/>
      <input type="hidden" size="2"	value="0"  name="<%=RequestConstants.ITEM_ID%>" id="<%=idItem%>" />

      </td>
      <td width="17%">
      	<input type="text" value=""size="15"	tabindex="1" id="<%=nameItem%>"  onblur="if(fillSrNo('<%=inc %>')){checkForIssueToDispensary(this.value, '<%=nameItem%>','<%=inc %>');}"  name="<%=nameItem%>" />
				<div id="ac2update" class="autocomplete" style="display:none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('<%=nameItem%>','ac2update','stores?method=getItemListForIssueToDispensary',{parameters:'requiredField=<%=nameItem%>&issueId='+document.getElementById('issueId').value });
			</script>
		</td>
      <td width="10%">
      <input type="text" name="<%=RequestConstants.AV%>" value=""	size="8"   readonly="readonly"   id="<%=idAu%>"/>
      </td>
       <td width="10%">
		   <input type="text"size="8" value=""  maxlength="30" tabindex="1" name="barCodeNo"  id="barCodeNo<%=inc %>"  onblur="getDataForBarcode(this.value,<%=inc %>)"/>
		  </td>
		  <td width="10%">
		   <input type="text" size="8" value="" maxlength="20" tabindex="1" name="batchNo"  id="batchNo<%=inc %>"/>

		  </td>
		   <td width="10%">
		   <input type="text"size="8" value="" maxlength="20" tabindex="1" name="expiryDate"  id="expiryDate<%=inc %>"/>

		  </td>
      <td width="10%">
      <input type="text" size="8"  name="<%=RequestConstants.QTY_IN_REQUEST%>" value=""  readonly="readonly"   />
      <input type="hidden" name="" id="<%=qtyRequested%>" value="New"  />
      </td>

   	  <input type="hidden" value=""	id="<%=issuedName%>"    name="<%=RequestConstants.ISSUED_ITEM%>" />
      <input type="hidden" name="" value="0" validate="Qty Requested Year,floatWithoutSpaces,no" MAXLENGTH="7"  id="<%=issuedItemId%>" />

       <td width="10%"><input type="text" value=""	id="" class="medcaption" onblur="fillGridIssueToOTAFU('issueDispensaryForm','stores?method=fillIssueToOTAFUBasedOnLotNo&lotNo='+this.value , <%=inc %>);" /></td>
      <td width="10%">
      <input type="text" readonly	value="" size="8"  name="availableStock" tabindex="2"  id="availableStock<%=inc %>" />
      </td>
     <%-- <td width="10%">
      <input type="text" readonly	value="" size="8"  name="<%=loanOutQty %>" tabindex="2"  id="<%=loanOutQty %>" />
      </td> --%>
      <td width="10%">
      <input type="text" readonly	value="" size="8" name="<%=RequestConstants.QTY_ISSUED%>" tabindex="2" id="<%=qtyIssued %>" />
      </td>

      <td width="3%">
        <input type="button" tabindex="1" class="buttonIssue" onclick="{openPopupForBrand(this.value,'0',<%=inc%>,<%=issueId %>,'1');}" name="Submit2"  />
      <td/>
          </tr>
	    			  -->
		<%}} }catch(Exception e ){e.printStackTrace();}
	    			  %>
	</tbody>
</table>

<input type="button" name="print" class="button" value="Print" onClick="printIssueSearch();" />

<script type="text/javascript" language="javascript">
function submitprint(formName){
	var issueId=document.getElementById('issueIdPrint').value;
	if(issueId!=""){
		obj = eval('document.'+formName)
		obj.action = "/hms/hms/stores?method=printDepartmentIssue";
		obj.submit();
	}else{
		alert("Please Insert Issue No. for Print");
		return false;
	}
  }
</script>

<script type="text/javascript">
		<!--
			// Main vBulletin Javascript Initialization
			vBulletin_init();
		//-->
		</script>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	
<div class="clear"></div>
<div class="paddingTop40"></div>




