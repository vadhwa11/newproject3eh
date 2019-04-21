<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants,java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>


<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
	vBulletin_init();
	</script>

<%
	int pageNo = 0;
	Map map = new HashMap();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt("" + map.get("pageNo"));

	}
	String deptName = "";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	int deptId = (Integer) map.get("deptId");
	String date = (String) map.get("date");
	String time = (String) map.get("time");
	String fromDate = (String) map.get("fromDate");
	String toDate = (String) map.get("toDate");
	List listOfItemsInStock = new ArrayList();
	List issueNoList = new ArrayList();

	try {
		if (map.get("listOfItemsInStock") != null) {
			listOfItemsInStock = (List) map.get("listOfItemsInStock");
		}

		if (map.get("issueNoList") != null) {
			issueNoList = (List) map.get("issueNoList");
		}
	} catch (Exception exp) {
		exp.printStackTrace();
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>
<form name="wardConsumption" method="post">
<div id="testDiv"><input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" /> <input type="hidden" name="date" id="date"
	value="<%=pageNo%>" /> <!--  code to make the search panel -->
<div class="clear"></div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>
</div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<label>Issue No.</label> <select name="issueNo" id="issueNo">
	<option value="0">Select</option>
	<%
		Iterator iterator = issueNoList.iterator();
		while (iterator.hasNext()) {
			StoreIpIssueM storeIpIssueM = (StoreIpIssueM) iterator.next();
	%>
	<option value=<%=storeIpIssueM.getIpIssueNo()%>><%=storeIpIssueM.getIpIssueNo()%></option>
	<%
		}
	%>
</select> <input type="image" class="button" onClick="openPopupForViewStock();" />
</div>
<!--  code to make the search panel --> <%
 	List ipIssueNo = (List) map.get("ipIssueNo");
 	StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) ipIssueNo
 			.get(0);
 	//String issueNoOfWard=(String)map.get("issueNoOfWard");
 	Integer issueNoOfWard = (Integer) map.get("issueNoOfWard");
 	int storeFyDocumentNoId = storeFyDocumentNo.getId();
 %> <input type="hidden" name="storeFyDocumentId" id="storeFyDocumentId"
	value="<%=storeFyDocumentNoId%>" />
<div class="clear"></div>
<div class="Block"><label>IPD Issue No. </label> <label
	class="value"> <%=issueNoOfWard%> <input type="hidden"
	name="ipissueno" id="ipissueno" value="<%=issueNoOfWard%>" readonly /></label>

<label>Page No.</label> <label class="value"> <%=pageNo%></label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Ward Consumption Details</h4>


<input type="button" name="delete" value="" class="buttonDel" onclick="removeRow();" />
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" />
<div class="division"></div>
<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0" id="chargeDetails">
	<tr>
		<th scope="col"></th>
		<th scope="col">Item Code</th>
		<th scope="col">Item Name</th>
		<th scope="col">Batch No.</th>
		<th scope="col">Exp. Date</th>
		<th scope="col">C. Stock</th>
		<th scope="col">Com.Quantity</th>
	</tr>
	<%
		int inc = 1;
	%>
	<tr>
		<td><input type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>
 		<td><input id="pvmsNo<%=inc%>" name="pvmsNo" type="text"
			size="5" MAXLENGTH="3" readonly="readonly" /></td>
 		<td width="20%">
			<input type="text" id="nomenclature<%=inc%>" name="nomenclature" size="25" MAXLENGTH="25" onblur="populateItem(this.value,'<%=inc %>')" />
			<div id="ac2update" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','ipd?method=getItemListForWardConsume',{parameters:'requiredField=nomenclature<%=inc%>'});
 			</script>
 		</td>
 		<td width="10%" id="testDiv<%=inc%>"><select id="batchNo<%=inc%>" name="batchNo" onchange="populateManufacturer(this.value,'<%=inc %>')">
 		<option value="0">Select Batch No</option>
 		</select></td>
    	<td width="10%"><input type="text" value="" id="expDate<%=inc%>" name="expDate" size="20"/></td>
 		<td><input type="text" value=""	name="closeStock" id="closeStock<%=inc%>" size="20"/></td>
	   <td width="10%"><input type="text" value="" id="compQuantity<%=inc%>" name="compQuantity" size="20"/>
	   		<input id="ItemID<%=inc%>" name="ItemID" type="hidden" size="5" readonly="readonly" />
	    </td>
  	</tr>
</table>
</div>
<input type="hidden" value="<%=inc%>" name="hiddenValueCharge"	id="hiddenValueCharge" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Next"
	onclick="submitForm('wardConsumption','ipd?method=showWardList&buttonFlag=next&deptId=<%=deptId%>&issueNoOfWard=<%=issueNoOfWard%>&fromDate=<%=fromDate%>&toDate=<%=toDate%>');"
	align="right" /> <input type="button" class="button" value="Back"
	align="left" onclick="submitForm('wardConsumption','ipd?method=showPatientListJsp');" />
<input type="button" class="button" value="Delete"
	onclick="openPopupForDelete(<%=issueNoOfWard%>);" align="right" /> <!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <!-- <input type="hidden" name="<%=RequestConstants.STORE_ITEM_BATCH_STOCK_ID%>" value="" id="hdb" /> -->
<input type="hidden" value="<%=deptId%>" name="deptId" id="deptId" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="paddingTop40"></div>

