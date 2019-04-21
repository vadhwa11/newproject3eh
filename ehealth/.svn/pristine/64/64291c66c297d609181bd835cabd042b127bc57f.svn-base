<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.PrqAssetDetails"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript" type="text/javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script language="javascript" type="text/javascript"
	src="/hms/jsp/js/prototype.js"></script>
<script language="javascript" type="text/javascript"
	src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript" type="text/javascript"
	src="/hms/jsp/js/unittest.js"></script>
<script language="javascript" type="text/javascript"
	src="/hms/jsp/js/calender.js"></script>
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
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

<%
	Map map = new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<PrqAssetDetails> assetDetails = new ArrayList<PrqAssetDetails>();
	List<MasDepartment> masDepartments = new ArrayList<MasDepartment>();
	List<MasItemCategory> itemCategories = new ArrayList<MasItemCategory>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String message = "";
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	if (map.get("assetDetails") != null) {
		assetDetails = (List<PrqAssetDetails>) map.get("assetDetails");
	}
	if (map.get("assetDetails") != null) {
		assetDetails = (List<PrqAssetDetails>) map.get("assetDetails");
	}

	if (map.get("itemCategories") != null) {
		itemCategories = (List<MasItemCategory>) map
				.get("itemCategories");
	}
	if (map.get("masDepartments") != null) {
		masDepartments = (List<MasDepartment>) map
				.get("masDepartments");
	}

	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp = (Integer) session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	System.out.println("assetDetails" + assetDetails.size());
%>

<div class="titleBg">
	<h2>Physical Inventory Details</h2>
</div>
<div class="Block">
	<form name="searchPanel" method="post">
		<div class="clear"></div>

		<label>Physical Inventory Date </label> <input type="text"
			name="physicalInventoryDate" value="<%=currentDate%>" class="date"
			maxlength="30" tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate%>',document.searchPanel.physicalInventoryDate,true);" />


		<label>Item Category </label> <select name="itemCategory">
			<option value="">Select</option>
			<%
				for (MasItemCategory itemCategory : itemCategories) {
			%>
			<option value="<%=itemCategory.getId()%>"><%=itemCategory.getItemCategoryName()%></option>
			<%
				}
			%>
		</select>
		<%--  <label>Department</label> <select name="departmentName" id="departmentId">
			<option value="0">Select</option>
			<%
				for (MasDepartment masDepartment : masDepartments) {
			%>
			<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
			<%
				}
			%>
		</select> --%>
		<div class="clear"></div>

		<label>Item Name</label> <input type="text" value="" tabindex="1"
			name="nomenclature" size="40" id="nomenclature" />
<script>
function eventCallback(element, entry){
//alert("group-=="+document.getElementById('itemGroupId').value);
	return entry+"&toWard="+document.getElementById('departmentId').value                                                                       
}
</script>
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-10"> 
								new Ajax.Autocompleter('nomenclature','ac2update','procurement?method=getMasStoreItemList',{minChars:1,parameters:'requiredField=nomenclature',callback: eventCallback});
								</script>
		<div class="clear"></div>
		<input name="button" type="button" value="Search" class="button"
			onclick="submitForm('searchPanel','procurement?method=showPhysicalInventoryDetailsJsp');" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<div class="clear"></div>
<form name="itemGrid" method="post">
<h4>Item Detail</h4>
	<input name="" value="" id="temp" type="hidden" />
	<div class="clear"></div>
	<input type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
	<div class="cmntable">
		<%
		int i = 1;
			if (assetDetails.size() != 0) {
		%>
		<table width="100%" colspan="7" id="itemDetails" border="0"
			cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<th width="13%">Sl No.</th>
					<th width="13%">Item Category</th>
					<th width="10%">Asset Name</th>
					<th width="10%">Asset Code</th>
					<th width="10%">Item Available</th>
					<th width="10%">Item Not Available</th>
					<th width="10%">Condition of Item</th>
					<th width="10%">Reason For Non Avaiability</th>
					<th width="10%">Remarks</th>
				</tr>
			</thead>
			<tbody>			
			<%					
							for (PrqAssetDetails passetD : assetDetails) {
					%>
	<tr>		
		<td><label><%=i%></label>		
		<%if (passetD.getAssetCategory() != null) {%>
		<td><%=passetD.getAssetCategory().getItemCategoryName()%></td>
		 <%}%>
			
		<%if (passetD.getAssetName() != null) {%> 
		<td><%=passetD.getAssetName()%><input type="hidden" name="assetId<%=i %>" value="<%=passetD.getId()%>" id="assetId"/>
		<input type="hidden" name="itemId<%=i %>" value="<%=passetD.getItem() != null  && passetD.getItem().getId() != null?passetD.getItem().getId():""%>" id="assetId"/></td>
		 <%	} %>	
						
	<%if (passetD.getAssetCode() != null) {%>
	<td> <%=passetD.getAssetCode()%></td>
	  <%} %>
	<td><input type="checkbox" name="itemAvailable<%=i %>" value="y" tabindex=1 id="itemAvailable" size="10" /></td>
	<td><input type="checkbox" name="itemNotAvailable<%=i %>" value="n" tabindex=1 id="itemNotAvailable" size="10" /></td>
	<td><select name="conditionOfItem">
			<option value="0">Select</option>
			<option value="New">New</option>
			<option value="Good">Good</option>
			<option value="Poor">Poor</option>
			<option value="Broken">Broken</option>
	</select></td>
	<td><select name="reasonForNonAvaiability">
			<option value="0">Select</option>
			<option value="Missing">Missing</option>
			<option value="Lost">Lost</option>
			<option value="Stolen">Stolen</option>
			<option value="Under Disposal">Under Disposal</option>
	
	</select></td>
	<td><input type="text" name="remarks<%=i %>" value="" tabindex=1 id="remarks" size="10" /></td>
				</tr>
		<%
			i++;}}
		%>
	</tbody>

		</table>
<input	type="hidden" name="count" id="count"	value="<%=i %>" />
</div>

<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('itemGrid','procurement?method=submitPhysicalInventoryDetails');" accesskey="a" tabindex=1 /> 
<input type="button" name="add" id="addbutton" value="Reset" class="button"	onClick="" accesskey="a" tabindex=1 />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

