

<%@page import="java.math.BigDecimal"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.StoreStockTakingM"%>
<%@page import="jkt.hms.masters.business.StoreStockTakingT"%>
<%@page import="java.util.GregorianCalendar"%>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

	<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
	<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
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

<script type="text/javascript">

function add()
{
		var url="/hms/hms/stores?method=showStockTakingAddJsp&departmentId=" + document.physicalStock.<%=DEPARTMENT_ID%>.value + "&physicalStockDate=" + document.physicalStock.<%=PHYSICAL_STOCK_DATE%>.value;
		newwindow=window.open(url,'name','top=50, left=50, height=600,width=800,status=1,scrollbars=yes');
}


function getPhysicalStock(dat)
{
	document.physicalStock.method="post";
	submitForm('physicalStock','stores?method=createGridForPhysicalStockData&pageno=1');
}

function upd()
{
	document.physicalStock.method="post";
	submitForm('physicalStock','stores?method=updateGridItemsInPhysicalStock');
}

//this function will be called by the Bean (not from JSP)
function GoPage() {
	var pgno = parseInt(document.physicalStock.gopage.value);
	var totalPages = parseInt(document.physicalStock.totalPages.value);
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}
	document.physicalStock.pageno.value = pgno;
	document.physicalStock.method="post";
	submitForm('physicalStock','stores?method=getGridDataForPhysicalStock');
}

function goNext()
{
 var pgno = parseInt(document.physicalStock.pageno.value)+1;

 if (pgno > document.physicalStock.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }

 document.physicalStock.pageno.value = pgno;
 document.physicalStock.method="post";
 submitForm('physicalStock','stores?method=getGridDataForPhysicalStock');
}


function goPrevious()
{
 var pgno = parseInt(document.physicalStock.pageno.value)-1;

 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }

 document.physicalStock.pageno.value = pgno;
 document.physicalStock.method="post";
 submitForm('physicalStock','stores?method=getGridDataForPhysicalStock');
}

function calulateStock(obj,row)
{

	var computedStockCal = parseFloat(document.getElementById('computedStock'+row).value);
	var stockInStockCal = parseFloat(document.getElementById('stockInStore'+row).value);
	//var storeStockDefectiveCal = parseFloat(document.getElementById('stockDefective'+row).value);
	var surplusStockCal = parseFloat(document.getElementById('surplus'+row).value);
	var deficientCal = parseFloat(document.getElementById('deficient'+row).value);
	if (isNaN(computedStockCal) || isNaN(stockInStockCal))
	{
	alert('Please Check the Inputs!....');
	return;
	}
	var difference = parseFloat(stockInStockCal) - parseFloat(computedStockCal);


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



function checkPreviousImportAndSubmit(){
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
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length!=0){

	      	for (loop = 0; loop < items.childNodes.length; loop++) {

		   	 var item = items.childNodes[loop];

		   	 var message = item.getElementsByTagName("message")[0];
		   	 if(message.childNodes[0] == undefined || trimAll(message.childNodes[0].nodeValue) == "")
		       {
		   		submitForm('physicalStock','stores?method=createGridForPhysicalStockData');
		       }else{
		       		alert(message.childNodes[0].nodeValue);
		       }

		   	  }
		   	  }

	      }
	    }

	    var url='stores?method=checkPreviousImport&'+getNameAndData('physicalStock');
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);


}
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

		int monthSearch = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (monthSearch < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(monthSearch);
		} else {
			orderDateOnly.append(monthSearch);
		}

		orderDateOnly.append("/");
		int year1 = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year1);
		String currentDate = new String(orderDateOnly);
	%>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Box box = HMSUtil.getBox(request);
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	int deptId = 0;
	int hospitalId = 0;
	int pageno=1;
	int totalPages=0;
	int totalRecords = 0;

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if (request.getAttribute("map") != null)
	{
		map = (Map)request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
	}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	if(session.getAttribute("hospitalId") != null){
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	if(map.get("departmentList")!=null)
	{
		departmentList = (List)map.get("departmentList");
	}

	if (map.get("pageno")!=null)
	{
		 pageno = Integer.parseInt(map.get("pageno").toString());
	}

	if (map.get("totalPages")!=null)
	{
		 totalPages = Integer.parseInt(map.get("totalPages").toString());
	}

	if (map.get("totalRecords")!=null)
	{
		totalRecords = Integer.parseInt(map.get("totalRecords").toString());
	}


	List<StoreStockTakingM> searchStoreStockTakingMList = new ArrayList<StoreStockTakingM>();
	//List<StoreStockTakingT> searchStoreStockTakingTList = new ArrayList<StoreStockTakingT>();
	//if(map.get("searchStoreStockTakingTList")!=null)
	//	searchStoreStockTakingTList = (List) map.get("searchStoreStockTakingTList");
	List<StoreStockTakingM> stockTakingMOfPhysicalDateList = new ArrayList<StoreStockTakingM>();
	if(map.get("searchStoreStockTakingMList")!=null){
		searchStoreStockTakingMList = (List)map.get("searchStoreStockTakingMList");
	}

	if(map.get("stockTakingMOfPhysicalDateList")!=null){
		stockTakingMOfPhysicalDateList = (List)map.get("stockTakingMOfPhysicalDateList");
		System.out.println("stockTakingMOfPhysicalDateList1111=="+stockTakingMOfPhysicalDateList.size());
	}else{
		stockTakingMOfPhysicalDateList = (List)map.get("stockTakingMList");
		System.out.println("stockTakingMOfPhysicalDateList222=="+stockTakingMOfPhysicalDateList.size());
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
<br> <br> <%
		   out.println(message);
	}
	%>


<form name="physicalStock" action="" method="post">

<div class="titleBg">
<h2>Physical Stock Verification</h2>
</div>
<div class="Block">
<label>Department</label> <select
	name="<%= DEPARTMENT_ID%>" validate="departmentId,,no">
	<option value="0">Select</option>
	<%
						for (MasDepartment masDepartment :departmentList )
						{
							if(masDepartment.getId() == deptId){
					%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(DEPARTMENT_ID)) %>
		selected><%=masDepartment.getDepartmentName()%></option>
	<%
							}else{
					%>
	<option value=<%=masDepartment.getId()%>
		<%=HMSUtil.isSelected(masDepartment.getId().toString(),box.getString(DEPARTMENT_ID)) %>><%=masDepartment.getDepartmentName()%></option>
	<%
							}
						}
					%>
</select> <%
		String flag= "false";
	%> <label class="auto">Physical Stock as on Date</label> <select
	name="<%=PHYSICAL_STOCK_DATE%>" id="stockDate" validate="physicalStockDate,date,no"
	onchange="getPhysicalStock(this.value);">
	<option value="<%=date %>"><%=date %></option>
	<%
	for (StoreStockTakingM storeStockTakingM :searchStoreStockTakingMList )
	{
		if(!HMSUtil.convertDateToStringWithoutTime(storeStockTakingM.getPhysicalDate()).equals(date) && storeStockTakingM.getStatus().equals("o")){
%>
	<option
		value=<%=HMSUtil.convertDateToStringWithoutTime(storeStockTakingM.getPhysicalDate())%>
		<%=HMSUtil.isSelected(HMSUtil.convertDateToStringWithoutTime(storeStockTakingM.getPhysicalDate()),box.getString(PHYSICAL_STOCK_DATE))%>><%=HMSUtil.convertDateToStringWithoutTime(storeStockTakingM.getPhysicalDate())%></option>
	<%
		}
	}
%>
</select>
<div class="clear"></div>
<%-- 
<label>Remarks</label>
<input type="text" name="<%=REMARKS %>"	value="" class="large" tabindex=1 maxlength="90" />--%>
 <script type="text/javascript">

	function test(){
		var itemNameSearch1 =  document.getElementById('nomenclature1').value;
	    var index1 = itemNameSearch1.lastIndexOf("[");
	    var index2 = itemNameSearch1.lastIndexOf("]");
	    index1++;
	    var itemNameSearch = itemNameSearch1.substring(0,index1-1);
	    var itemId = itemNameSearch1.substring(index1,index2);
	    if(itemId !="")
	    document.getElementById("pvmsNo").value=itemId;
	    else
	    	document.getElementById("pvmsNo").value=0;
	   // document.physicalStock.method="post";
	//	submitForm('physicalStock','stores?method=getGridDataForPhysicalStock');
		var counter = document.getElementById('counter').value;
		if(itemNameSearch != ""){
			for(var i =1;i<=counter;i++){
				if(document.getElementById('nomenclature1'+i).value == itemNameSearch){
					document.getElementById('nomenclature1'+i).focus();
					break;
				}
			}
		}
	}
	</script>

<label>Item Name</label>
 <input type="text"	value="" id="nomenclature1" name="nomenclature1" onblur="test();"();/>
 <div class="clear"></div>
<div id="ac2update" style="display: none;"	class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('nomenclature1','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature1'});
	</script>
	<%
if(stockTakingMOfPhysicalDateList != null && stockTakingMOfPhysicalDateList.size() > 0){
StoreStockTakingM mObj = (StoreStockTakingM) stockTakingMOfPhysicalDateList.get(0);
if(mObj.getStatus().equals("o")){
%>

<input type="button" name="Import" type="submit" value="Display" class="button" onclick="checkPreviousImportAndSubmit();"/>
 <%--<input type="button" name="Import" type="submit" value="Import"
	class="button"
	onclick="submitForm('physicalStock','stores?method=createGridForPhysicalStockData');"/>

<input type="button" name="Update" type="submit" value="Update" onClick="upd();" class="button"/> 
<input type="button" name="Add" type="submit" value="Add" onClick="add();" class="button"/>
 <input type="button" name="Print" type="submit" class="button" value="Print" onClick="submitForm('physicalStock','stores?method=showPhysicalStockReport');"/>--%>
</td>

<%}else{
%>
<input type="button" name="Import" type="submit" value="Display" class="button" onclick="checkPreviousImportAndSubmit();"/>
<!-- <input type="button" name="Import" type="submit" value="Display" class="button" disabled onclick="submitForm('physicalStock','stores?method=createGridForPhysicalStockData','checkTargetForNo');"/> -->
<%-- <input type="button" name="Update" type="submit" value="Update" disabled onClick="upd();" class="button"/> 
<input type="button" name="Delete" type="submit" disabled value="Delete" class="button"/>
<input type="button" name="print" type="submit" class="button" value="Print" onClick="submitForm('physicalStock','stores?method=showPhysicalStockReport');"/>--%>
<%}
}else{%>
<input type="button" name="Import" type="submit" value="Display" class="button" onclick="checkPreviousImportAndSubmit();"/>
<!-- <input type="button" name="Import" type="submit" value="Import"
	class="button"
	onclick="submitForm('physicalStock','stores?method=createGridForPhysicalStockData','checkTargetForNo');"/>
-->
 <%--<input type="button" name="Update" type="submit" value="Update" onClick="upd();" class="button"/>
 <input type="button" name="Delete" type="submit" value="Delete" class="button"/>--%>
<%-- <input type="button" name="print" type="submit" class="button" value="Print" onClick="submitForm('physicalStock','stores?method=showPhysicalStockReport');"/>--%>
<%} %>
	
<input type="hidden" id="pvmsNo" class="small" name="pvmsNo"   readonly="readonly"  />
<input type="button" name="Search" value="Search" class="button" onclick="submitForm('physicalStock','stores?method=getGridDataForPhysicalStock&flag=fresh');"tabindex=1 />
<input type="hidden" name="<%=CHANGED_BY %>"	value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" validate="hospitalId,int,no"/>
<input type="hidden" name="pageno" value=<%=pageno%> validate="pageno,int,no"/>
<input type="hidden" name="totalPages" value=<%=totalPages%> validate="totalPages,int,no"/>
<input type="hidden" name="totalRecords" value=<%=totalRecords%> validate="totalRecords,int,no"/>
<input type="hidden" name="numOfRows" value="5" />
<div id="pagination">
<%
	if (totalPages > 0 ) { %> Page <span class="selected"><%=pageno %></span>
of <span class="selected"><%=totalPages %></span> <a
	href="javascript:goPrevious()" class="previous">Prev</a>&nbsp;&nbsp; <a
	href="javascript:goNext()" class="next">Next</a>
	<input type="button" name="Go Page" type="submit" class="button" value=" "onclick="javascript:GoPage();"/>
	<input type="text" name="gopage" value="<%=totalPages %>" size="3" /> <% }%>
</div>
</div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<%
	int firstRow=1;
		if (pagedArray == null) { %>
<h4>Physical Stock Details</h4>
<div class="clear"></div>
<div class="cmntable">
<table width="100%" colspan="7" id="mmfDepartmentDetails" border="0"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="10%">S.No.</th>
			<th width="13%">Item Code</th>
			<th width="10%">Item Name</th>
			<th width="10%">Unit</th>
			<th width="13%">Batch No.</th>
			<th width="13%">Expiry Date</th>
			<th width="13%">Closing Stock</th>
			<th width="20%">Physical Stock</th>
			<!--
					<td width="20%">
					<font style="word-wrap:break-word; font-size: 10px; width:100px; height:1px;left:0" rowspan="2" valign="top">
					<b>Stock in <br />Store Defective</b> </font>
					</td>
 -->		<th width="13%">Surplus</th>
			<th width="13%">Deficient</th>
			<th width="13%">Remarks</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6>No Data Found</td>
		</tr>
	</tbody>
</table>
</div>
<% } else { %>

<h4>Physical Stock Details</h4>
<div class="clear"></div>

<table width="98%" colspan="7" id="tblSample" border="0" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th>S.No.</th>
			<th width="13%">Item Code</th>
			<th width="10%">Item Name</th>
			<th width="10%">Unit</th>
			<th width="13%">Batch No.</th>
			<th width="13%">Expiry Date</th>
			<!-- <th width="13%">Computed Stock</th>
			<th width="13%">Stock Service</th> -->
			<th width="13%">Closing Stock</th>
			<th width="20%">Physical Stock</th>
			<!--<th width="13%">Stock Defective</label></td>  -->
			<th width="13%">Surplus</th>
			<th width="13%">Deficient</th>
			<th width="13%">Remarks</th>
		</tr>
	</thead>
	<tbody>

		<%
		 gridData = (HashMap[])pagedArray.getPagedArray();
		int iFirstRow = pagedArray.getFirstRowIdx();
				firstRow=firstRow +((pageno-1)*5);
			    for(int i=0;i<gridData.length;i++){
				System.out.println("date size===="+gridData[i].get("pvms"));
			     %>
		<tr>
			<td width="5%"><input type="text" value="<%=firstRow%>" size="1"
				name="srno" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("pvms")!= null?gridData[i].get("pvms"):""%>" size="8" name="pvms"
				readonly="readonly" /></td>
			<td width="40%"><input type="text"
				value="<%=gridData[i].get("nomenclature")!= null?gridData[i].get("nomenclature"):""%>" size="40"
				id="nomenclature<%=firstRow %>" name="nomenclature"
				readonly="readonly" title="<%=gridData[i].get("nomenclature")%>"/></td>
			<td width="12%"><input type="text"
				value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
				name="au" readonly="readonly" /></td>
			<%--<td width="40%"> <input type="text" value="<%=gridData[i].get("brand")%>"  name="brand" readonly="readonly" /></td> --%>
			<td width="40%"><input type="text"
				value="<%=gridData[i].get("batchNo")%>" size="8" name="batchNo"
				readonly="readonly" /></td>
			<td width="40%"><input type="text"
				value="<%=gridData[i].get("expiryDate")==null?"":HMSUtil.convertDateToStringWithoutTime((Date)gridData[i].get("expiryDate"))%>"
				size="8" name="expiryDate" readonly="readonly" /></td>
			<td width="40%">
			    <input type="text"	value="<%=((BigDecimal)gridData[i].get("computedStock")).intValue()%>" size="8"
				name="computedStock" id="computedStock<%= firstRow%>"	readonly="readonly" />
			</td>

			<td width="40%">
			<input type="text"	value="<%=((BigDecimal)gridData[i].get("stockInStore")).intValue()%>" size="8" name="stockInStore"
				 id="stockInStore<%= firstRow%>" onblur="calulateStock(this.value,<%= firstRow%>);"
				validate="Stock In Store Service,float,no" /></td>
			<!-- <td width="40%"> <input type="text" value="<%=gridData[i].get("stockDefective")%>"  name="stockDefective" id="stockDefective<%= firstRow%>" onblur="calulateStock(this.value,<%= firstRow%>);" validate="Stock In Store Defective,float,no"/></td>  -->

			<td width="40%"><input type="text"
				value="<%=((BigDecimal)gridData[i].get("surplus")).intValue()%>" size="8" name="surplus"
				id="surplus<%= firstRow%>" readonly="readonly" /></td>
			<td width="40%"><input type="text"
				value="<%=((BigDecimal)gridData[i].get("deficient")).intValue()%>" size="8" name="deficient"
				id="deficient<%= firstRow%>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get("remark")%>" name="remark"
				validate="Remarks,remarks,no" /></td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get("id")%>" name="id" /></td>
		</tr>
		<%
		 firstRow++;
			    } %>
	</tbody>
</table>

<% } %> <input type="hidden" id="counter" value="<%=firstRow %>" validate="counter,int,no"/>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
	 <input type="hidden" name="rows" id="rr" value="1" validate="rows,int,no"/>
<div class="clear"></div>
<%
if(stockTakingMOfPhysicalDateList != null && stockTakingMOfPhysicalDateList.size() > 0){
StoreStockTakingM mObj = (StoreStockTakingM) stockTakingMOfPhysicalDateList.get(0);
if(mObj.getStatus().equals("o")){
%>
 <!--<input type="button" name="Import" type="submit" value="Import"
	class="button"
	onclick="submitForm('physicalStock','stores?method=createGridForPhysicalStockData');"/>
-->
<input type="button" name="Add" type="submit" value="Add" onClick="add();" class="button"/>
<input type="button" name="Update" type="submit" value="Update" onClick="upd();" class="button"/> 
<%-- <input type="button" name="Print" type="submit" class="button" value="Print" onClick="submitForm('physicalStock','stores?method=showPhysicalStockReport');"/>--%>
</td>

<%}else{
%>
<input type="button" name="Update" type="submit" value="Update"  onClick="upd();" class="button"/> 
<%-- <input type="button" name="Delete" type="submit" disabled value="Delete" class="button"/>
<input type="button" name="print" type="submit" class="button" value="Print" onClick="submitForm('physicalStock','stores?method=showPhysicalStockReport');"/>--%>
<%}
}else{%>
<!-- <input type="button" name="Import" type="submit" value="Import"
	class="button"
	onclick="submitForm('physicalStock','stores?method=createGridForPhysicalStockData','checkTargetForNo');"/>
-->
<input type="button" name="Update" type="submit" value="Update" onClick="upd();" class="button"/>
 <%-- <input type="button" name="Delete" type="submit" value="Delete" class="button"/>--%>
<%-- <input type="button" name="print" type="submit" class="button" value="Print" onClick="submitForm('physicalStock','stores?method=showPhysicalStockReport');"/>--%>
<%} %>

<%
		if(stockTakingMOfPhysicalDateList != null && stockTakingMOfPhysicalDateList.size() > 0)
		{
			StoreStockTakingM mObj = (StoreStockTakingM) stockTakingMOfPhysicalDateList.get(0);
			if(mObj.getStatus().equals("o")){
	%>


<input type="button" name="adjustment" value="Adjustment" class="buttonBig"
	onclick="submitForm('physicalStock','stores?method=showAdjustmentJsp')"
	tabindex=1 />
	  <%}
	}%>
</br>
</br>
