<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@page import="java.util.*"%>
<%@page	import="static jkt.hms.util.RequestConstants.*,java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreInternalReturnM"%>

<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>

<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>--%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
	serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>

<%
	 int pageNo=1;
	int storeFyDocumentNoId = 0;
	Map map = new HashMap();
	String buttonFlag="";
	String flag = "defective";


	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("stores.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	//int departmentIdForReturnFromDispensary = Integer.parseInt(properties.getProperty("departmentIdForReturnFromDispensary"));

	int deptId = 0 ;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}


	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String timeInHHmm="";
	String [] tempArr = null;
	tempArr = time.split(":");
	for (int i = 0 ; i < tempArr.length-1 ; i++) {

		timeInHHmm=timeInHHmm+(String)tempArr[i];
    	 if(i==0)
    	 {
    		 timeInHHmm=timeInHHmm+":";
    	 }
	}

	if(map.get("buttonFlag") != null)
	{
		buttonFlag=(String)map.get("buttonFlag");
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
	}

	if(map.get("deptId") != null)
	{
		deptId=(Integer)map.get("deptId");
	}
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	String fromDateToDate=(String)map.get("fromDateToDate");

	//List listOfItemsInStock=new ArrayList();
	List brandList= new ArrayList();
	List returnNoList= new ArrayList();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<EmpScMapping> employeeList = new ArrayList<EmpScMapping>();
	List<MasEmployee> employeeAllList = new ArrayList<MasEmployee>();
	List<MasStoreGroup> storeGroupList = new ArrayList<MasStoreGroup>();
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	List<MasStoreSection>sectionList = new ArrayList<MasStoreSection>();
	List<MasItemCategory>categoryList = new ArrayList<MasItemCategory>();
	List<MasItemClass> itemClassList = new ArrayList<MasItemClass>();

	try {
		//if(map.get("listOfItemsInStock") != null){
			//listOfItemsInStock=(List)map.get("listOfItemsInStock");
		//}
		if (map.get("deptList") != null) {
			deptList = (List)map.get("deptList");
		}
		if (map.get("brandList") != null) {
			brandList = (List)map.get("brandList");
		}
		if (map.get("returnNoList") != null) {
			returnNoList = (List)map.get("returnNoList");
		}
		if (map.get("employeeList") != null) {
			employeeList = (List<EmpScMapping>)map.get("employeeList");
		}
		if (map.get("employeeAllList") != null) {
			employeeAllList = (List<MasEmployee>)map.get("employeeAllList");
		}

		if(map.get("storeFyDocumentNoId") != null){
			storeFyDocumentNoId = (Integer)map.get("storeFyDocumentNoId");
		}
		if(map.get("storeGroupList") != null){
			storeGroupList = (List<MasStoreGroup>)map.get("storeGroupList");
		}
		if(map.get("itemTypeList") != null){
			itemTypeList = (List<MasItemType>)map.get("itemTypeList");
		}
		if(map.get("categoryList") != null){
			categoryList = (List<MasItemCategory>)map.get("categoryList");
		}
		if(map.get("itemClassList") != null){
			itemClassList =(List<MasItemClass>)map.get("itemClassList");
		}
		if(map.get("sectionList") != null){
			sectionList = (List<MasStoreSection>)map.get("sectionList");
		}

		if(map.get("deptId") != null)
		{
			deptId=(Integer)map.get("deptId");
		}
		
	} catch (Exception exp) {
		exp.printStackTrace();
	}
  %>
<div class="clear"></div>
<h2>Department Return</h2>
<div class="clear"></div>
<%--
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<form name="search" method="post">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <!--  code to make the search panel -->
<input type="button" name="print" type="submit" class="button"	value="Print" onClick="showReport('kSearch');">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="hidden" name="pageNo" value="<%=pageNo%>" />
<label 	class="bodytextB">From Date </label>
<input type="text"	name="<%=FROM_DATE%>" value="<%=date %>" validate="From Date,dateOfAdmission,no" MAXLENGTH="30" />
<img  src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1"
	onClick="setdate('<%=date%>',document.search.<%=FROM_DATE%>,event)" />
<div class="clear"></div>
<label class="bodytextB">To Date </label>
<input type="text"	name="<%=TO_DATE%>" value="<%=date %>"	validate="To Date,dateOfAdmission,no" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.search.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label class="bodytextB">Return Number </label>
<select	name="<%=ISSUE_RETURN_ID%>">
	<option value="0">Select</option>
	<%
						Iterator iterator = returnNoList.iterator();
			   			 while(iterator.hasNext()){
			    			StoreInternalReturnM mObj = (StoreInternalReturnM) iterator.next();
						%>
	<option value=<%=mObj.getId()%>><%=mObj.getReturnNo()%></option>
	<%
			  		  }
					%>
</select>
<input type="image" class="button"	value="Go!" onClick="submitForm('search','stores?method=searchReturnToDispensary&pageNo=<%=pageNo-1%>&deptId=<%=deptId%>&buttonFlag=<%=buttonFlag%>');" />
</div></form> --%>
<form name="returnSearch" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><!--  code to make the search panel -->
<%
	String returnNo = "";
	if(map.get("finalReturnNo") != null){
		returnNo = (String)map.get("finalReturnNo");
	}else if(map.get("returnNo") != null){
		returnNo = (String)map.get("returnNo");
	}
	%>
<input type="hidden" name="<%=RETURN_NO %>" id="returnNo" value="<%= returnNo%>" readonly="readonly"   tabindex=1 />
<input type="hidden"	name="pageNo" value="<%=pageNo%>" id="pageNo" validate="pageNo,int,no"/>
<%-- 
<div class="clear"></div>
<h4>Department Return</h4>
<div class="clear"></div>--%>
<div class="Block">
<div class="clear"></div>
<div style="display: none">
<label>Return No </label>
<label class="value"><%=returnNo %></label></div> <label> Date </label>
<input type="text" class="date" name="<%=RETURN_DATE%>"	id="returnDate" value="<%=date %>"	validate="returnDate,date,no" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=date%>',document.returnSearch.<%=RETURN_DATE%>,event)" />
<%-- 
<label><span>*</span> Reference No</label>
<input type="text"	id="referenceNo" name="<%=REFERENCE_NO %>" value=""	validate="Reference No ,String,yes" tabindex=1 />--%>
<%-- 
<label>From Department</label>--%>
<%
		Iterator itrDept=deptList.iterator();
	    while(itrDept.hasNext()){
	    	MasDepartment masDepartment= (MasDepartment) itrDept.next();
	    	String deptName=masDepartment.getDepartmentName();
	    	int idFromList=masDepartment.getId();
	    	if(idFromList == deptId){
 	%>
<input type ="hidden" name=""  value="<%=masDepartment.getDepartmentName() %>" validate="deptName,metachar,no"/>
<input type="hidden" name="<%=FROM_WARD %>" id="fromWard"	value="<%=masDepartment.getId() %>"  /> <%
	    	}
	  }
	%>

<label><span>*</span>Department</label>
<select	name="<%=TO_WARD %>" id="toWard"  onchange="checkToDepartment(this.value);">
	<option value="0">Select</option>
	<%
		Iterator itrDeptTo=deptList.iterator();
	    while(itrDeptTo.hasNext()){
	    	MasDepartment masDepartment= (MasDepartment) itrDeptTo.next();
	 //   	String deptName=masDepartment.getDepartmentName();
	//    	int idFromList=masDepartment.getId();
	//		if (deptId==idFromList) {
			%><%--
				<option value=<%=masDepartment.getId()%> selected><%=masDepartment.getDepartmentName()%></option>
					--%>
	<%// } else {  %>
	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%></option>
	<% //} %>
	<%
	  }
	%>
</select>

<%-- 
<label><span>*</span>Received By</label>
<select	name="<%=RETURN_BY_ID %>" id="returnBy" validate="Return By,String,yes">
	<option value="0">Select</option>
	<%
	System.out.println("employeeAllList=="+employeeAllList.size());
	for (MasEmployee masEmployee : employeeAllList) {
	%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></option>
	<%
	}
	%>
</select>--%>

<label><span>*</span>  Return By</label>
<select	name="<%=RECEIVED_BY_ID %>" id="receiveBy"  >
	<option value="0">Select</option>
	<%
	for (EmpScMapping empScMapping : employeeList) {
	
	%>
	<option value="<%=empScMapping.getEmployee().getId() %>"><%=empScMapping.getEmployee().getEmployeeName()%></option>
	<%
	}
	%>
</select>
<div class="clear"></div>
<%--
<label>Reason</label>
<textarea value="" name="<%=REASON %>"
	id="reason" validate="Reason ,String,no" tabindex=1
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	maxlength="250">
	</textarea> --%>
<label>Remarks</label>
<input type="text" name="<%=REMARKS %>"	value="" id="remarks" class="large" tabindex=1 maxlength="190" validate="remarks,remarks,no" style="width:548px;" />

<div class="clear"></div>
<label> Item Group</label> 
<select name="itemGroupId" id="itemGroupId"   onblur="submitProtoAjaxWithDivName(this.form.name,'stores?method=getItemTypeList&group='+this.value,'nameDiv');" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreGroup masStoreGroup:storeGroupList){
		%>
		<option value="<%=masStoreGroup.getId() %>"><%=masStoreGroup.getGroupName() %></option>
	<%}} %>
</select>
<div id="nameDiv">
<label> Item Type</label>
<select name="itemTypeId"  id="itemTypeId" >
	<option value="0">Select</option>
	<%if(itemTypeList.size()>0){
		for(MasItemType masItemType:itemTypeList){
		%>
		<option value="<%=masItemType.getId() %>"><%=masItemType.getItemTypeName() %></option>
	<%}} %>
</select>
<label>Item Section</label>
<select name="sectionId"   id="sectionId" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreSection masStoreSection:sectionList){
		%>
		<option value="<%=masStoreSection.getId() %>"><%=masStoreSection.getSectionName()%></option>
	<%}} %>
</select>

<label>Item Category</label>
<select name="categoryId"  id="categoryId"  >
	<option value="0">Select</option>
	<%if(categoryList.size()>0){
		for(MasItemCategory masItemCategory:categoryList){
		%>
		<option value="<%=masItemCategory.getId() %>"><%=masItemCategory.getItemCategoryName() %></option>
	<%}} %>
</select>
<label>Item Class</label>
<select name="classId"  id="classId" >
	<option value="0">Select</option>
	<%if(itemClassList.size()>0){
		for(MasItemClass masItemClass:itemClassList){
		%>
		<option value="<%=masItemClass.getId() %>"><%=masItemClass.getItemClassName() %></option>
	<%}} %>
</select>
</div>
</div>
<input type="hidden" id="returnNo" value="<%= returnNo%>" readonly  />
<input	type="hidden" id="storeFyDocumentNoId" name="storeFyDocumentNoId"	value="<%=storeFyDocumentNoId %>"  />

<div class="clear"></div>
<!--<input type="button" class="button" value="Next"  onclick="if(checkForNext()){submitForm('returnSearch','stores?method=showReturnFromDispensaryJsp&buttonFlag=next&pageNo=<%=pageNo%>&returnNo=<%=returnNo%>&deptId=<%=deptId%>&storeFyDocumentNoId=<%=storeFyDocumentNoId %>');}"  />
-->
<%-- <input type="button" class="button" value="Delete"  onclick="openPopupForDelete(1,'<%=returnNo%>');"  />
--%>
<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
<div class="clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords" id="noOfRows" validate="noOfRecords,int,no"/>
<%-- <!-- <input type="hidden" name="<%=STORE_ITEM_BATCH_STOCK_ID %>" value="" id="hdb" /> --> --%>
<input type="hidden" value="<%= deptId%>" name="deptId" id="deptId" validate="deptId,int,no"/>
<div class="clear"></div>
<h4>Details</h4>
<div class="clear"></div>
<div class="cmntableWithHeight">
<table width="98%" colspan="7" id="grnDetails" class="scrollTable">
	<thead class="fixedHeader headerFormat">
		<tr>
			<th>S.No.</th>
			<th>Item Code</th>
			<th>Item Name</th>
			<th>Unit</th>
			<th>Batch No</th>
			<th>DOM</th>
			<th>DOE</th>
			<th>Manufacture</th>
			<th>Available Stock</th>
			<th>Qty Returned</th>
			<th>Reason</th>

		</tr>
	</thead>
	<tbody>
		<%
    	int detailCounter=30;
    	int temp=0;

    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=30;inc++){

     %>
		<tr>
			<td><input type="text" size="2" value="<%=temp+inc%>" name="<%=SR_NO%>" readonly="readonly"  /></td>
			<td><input type="text" name="pvmsNo" readonly="readonly" id="pvmsNo<%=inc%>"  />
			 <input type="hidden" name="itemId" id="itemId<%=inc %>" value="" validate="itemId,int,no"/>
			  <input type="hidden" name="date" id="date" value="<%=date %>" validate="date,date,no"/> 
			  <input type="hidden" name="time" id="time" value="<%=time %>"  />
			   <input type="hidden" value="" name="storeItemBatchStockId" id="stockId<%=inc %>"  />
			    <input type="hidden" value="" name="costprice" id="costprice<%=inc %>" validate="costprice,float,no"/>

			<input type="hidden" value="" name="amount" id="amount<%=inc %>" validate="amount,float,no"/> </td>
			 <script>
			function eventCallback(element, entry){
			//alert("group-=="+document.getElementById('itemGroupId').value);
				return entry + "&itemGroupId=" + document.getElementById('itemGroupId').value+"&itemTypeId="+document.getElementById('itemTypeId').value+"&sectionId="+document.getElementById('sectionId').value+"&categoryId="+document.getElementById('categoryId').value+"&classId="+document.getElementById('classId').value                                                                       
			}
			</script> 
			<td><input type="text" value="" size="20" tabindex=1 id="nameItem<%=inc%>" tabindex="1" name="nameItem" onblur="checkForVendorReturnOriginal(this.value, 'nameItem','<%=inc %>')"   />
			<div id="ac23update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter('nameItem<%=inc%>','ac23update','stores?method=getItemListForDefectiveDrugsByAutocomplete',{parameters:'requiredField=nameItem',callback: eventCallback});
			</script></td>
			<td><input type="text" tabindex=1 value="" name="au" id="idAu<%=inc%>" readonly  /></td>
			<td><select name="batchNo" tabindex=1 id=<%="batchId"+inc%> tabindex="1"   onchange="getExpiryDateByAjax(this.value,<%=inc%>);">
				<option value="">Select Batch No..</option>
			</select></td>
			<td><input type="text" tabindex=1 value="" name="manufactureDate" id="manufactureDate<%=inc%>" readonly validate="manufactureDate,date,no"/></td>
			<td><input type="text" tabindex=1 value="" name="expiryDate" id="expiryDate<%=inc%>" readonly validate="expiryDate,date,no"/></td>
			<td><input type="text" tabindex=1 value="" name="manufactureName" id="manufactureName<%=inc%>" readonly  />
			<input type="hidden" tabindex=1 value="" name="manufactureId" id="manufactureId<%=inc%>" readonly validate="manufactureId,int,no"/></td>
			<td><input type="text" tabindex=1 value="" name="stockAvailable" id="stockAvailable<%=inc%>" value="" readonly onblur="checkforStock(<%=inc %>)" validate="stockAvailable,float,no"/></td>
			<td><input type="text" value="" name="issueQty" id="qtyIssued<%=inc%>" validate="issueQty,float,no"/></td>
				
			<td>
			<select name="reason" id="reason<%=inc%>">
				<option value="">Select</option>
				<option value="Expiry">Expiry</option>
				<option value="Defective">Defective</option>
				<option value="Brekage">Brekage</option>
				<option value="Excess">Excess</option>
			</select>
			</td>
		</tr>

		<%
     	}
     %>


	</tbody>
</table>

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit"	onclick="if(checkQty() && validateFieldsOnSubmit()){submitForm('returnSearch','stores?method=submitReturnDispensaryDetails','checkSave');}" />
<%--<input type="button" class="buttonBig2" value="Forward to Defective Drugs"	onclick="if(checkQty() && validateFieldsOnSubmit()){submitForm('returnSearch','stores?method=submitReturnDispensaryDetails&flag=defective','checkSave');}" /> --%>

<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<div class="paddingTop40"></div>

</form>

<script type="text/javascript">


function fillSrNoData(rowVal){
	var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%10
   		if(rowVal==0){
   			rowVal=10
   	 	}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			}
		var errorMessage="";
		/*if(document.getElementById('referenceNo').value == "")
		errorMessage=errorMessage+"Please fill referenceNo  \n";*/
		if(document.getElementById('toWard').value == 0)
		errorMessage=errorMessage+"Please Select To Deparment \n";
		//if(document.getElementById('returnBy').value == 0)
		//errorMessage=errorMessage+"Please select return By \n";
		if(document.getElementById('receiveBy').value == 0)
		errorMessage=errorMessage+"Please select Returned By \n";
		//if(document.getElementById('remarks').innerHTML =="")
		//errorMessage=errorMessage+"Please fill remarks \n";
		/*if(document.getElementById('reason').innerHTML == "")
		errorMessage=errorMessage+"Please fill reason \n";*/
	if((document.getElementById('toWard').value != "") && (document.getElementById('receiveBy').value != 0)){
		return true;
	}else{
		alert(errorMessage)
		return false
	}
}




function checkQty(){
for(var i=1;i<=30;i++){
	var qty="";
	if(document.getElementById("nameItem"+i)!=null && document.getElementById("nameItem"+i).value!=""){
	if(document.getElementById("qtyIssued"+i)!=null){
	 qty=document.getElementById("qtyIssued"+i).value
	if(qty!=""){
		return true;
	}
	else{
		alert("Pls fill Qnty.. in Row"+i);
		document.getElementById("qtyIssued"+i).focus();
		return false;
	}
}
}
}
return true;
}
function checkForVendorReturn(val,a,inc){
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
	    for(i=1;i<=8;i++){
	    if(val !="")
	    if(document.getElementById('brandName'+i).value==val){
	    if(document.getElementById('brandName'+inc).value!=val){
	    	alert("Item already selected...!")
	    	document.getElementById('brandName'+inc).value=""

	    	return false;
	    	}
	    }}
		ajaxFunctionForDepartmentReturn('returnSearch','stores?method=fillItemsForIndentToVendorReturn&brandName=' +  val , inc);
}

function checkForVendorReturnOriginal(val,a,inc)
{
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*30)+1;
    	var end=((pageNo-1)*30)+30;

	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);

	    document.getElementById("batchId"+inc).length=0;


		ajaxFunctionForAutoCompleteInVendorReturn('returnSearch','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);

}
 function checkforStock(rowVal){
 var stockAvailable=document.getElementById('stockAvailable'+rowVal).value;
 if(parseFloat(stockAvailable)>0){
 return true;

 }
 else{
 alert("stock is not available for this item");
 document.getElementById('stockAvailable'+rowVal).focus();
 return false;
 }
 }
 function checkForIssueQty(rowVal){
 var qtyIssued=document.getElementById('qtyIssued'+rowVal).value;
var stockAvailable=	document.getElementById('stockAvailable'+rowVal).value;
if(parseFloat(stockAvailable)<parseFloat(qtyIssued)){
alert("return qty. can't be greater than stock Qnt.");
 document.getElementById('qtyIssued'+rowVal).focus();
 return false;

 }
 }
 function getExpiryDateByAjax(batchId,rowVal){


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

      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];

	        var expiryDate  = item.getElementsByTagName("expiryDate")[0];
	        var manufactureDate  = item.getElementsByTagName("manufactureDate")[0];
	        var manufacturerId  = item.getElementsByTagName("manufacturerId")[0];
	        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
	        var stockId= item.getElementsByTagName("stockId")[0];
	         var costPrice= item.getElementsByTagName("costPrice")[0];
	         var stockAvailable=item.getElementsByTagName("stockAvailable")[0];

	        var mId  = item.getElementsByTagName("mId")[0];
        	document.getElementById('expiryDate'+rowVal).value = expiryDate.childNodes[0].nodeValue
        	document.getElementById('manufactureDate'+rowVal).value = manufactureDate.childNodes[0].nodeValue
        	document.getElementById('manufactureName'+rowVal).value = manufacturerName.childNodes[0].nodeValue
        	document.getElementById('manufactureId'+rowVal).value = manufacturerId.childNodes[0].nodeValue
        	document.getElementById('stockId'+rowVal).value = stockId.childNodes[0].nodeValue
       		document.getElementById('costprice'+rowVal).value = costPrice.childNodes[0].nodeValue
       		document.getElementById('stockAvailable'+rowVal).value = stockAvailable.childNodes[0].nodeValue

        	//document.getElementById('expiryDateTemp'+rowVal).value = expiryDate.childNodes[0].nodeValue

      	}
      }
    }
     url="stores?method=getExpiryDateInAjax&batchId="+batchId;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

 }

function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/stores?method=printReturnFromDispensaryJsp";
  obj.submit();
}
</script>

<script type="text/javascript">

	function checkToDepartment(toDept){
		var fromDept = '<%=deptId%>';
		if(toDept == fromDept){
			alert("From department and To department should not be same.");
			document.getElementById('toWard').value = "0";
			return false;
		}
	return true;
	}

function fillItemsInGrid(brandId,rowVal,deptId){
	var err = "";
	//var referenceNo = document.getElementById('referenceNo').value
	var toWard = document.getElementById('toWard').value
	//var returnBy = document.getElementById('returnBy').value
	var receiveBy = document.getElementById('receiveBy').value

		for(var i=0;i<nameArray.length;i++){
		if(nameArray[i][5]==brandId){
			document.getElementById('pvmsNo'+rowVal).value=nameArray[i][1]
			document.getElementById('itemId'+rowVal).value=nameArray[i][2]
			document.getElementById('nomenclature'+rowVal).value=nameArray[i][6]
			document.getElementById('noOfRows').value=rowVal+1;

			}
		}
		/*if(referenceNo == ""){
			err += "Please Enter Reference Number. \n";
		}*/
		if(toWard == 0){
			err += "Please Enter To Department. \n";
		}
		/* if(returnBy == 0){
			err += "Please select Return By. \n";
		} */
		if(receiveBy == 0){
			err += "Please select Received By.";
		}

		if( toWard != 0  && receiveBy != 0){
			if(err == ""){
				openPopup(brandId,deptId,rowVal);
			}
		}else{
			alert(err);
		}
}


	function openPopup(brandId,deptId,rowVal){
		var url="/hms/hms/stores?method=showStockDetailsForReturnDispensary&brandId="+brandId+"&deptId="+deptId+"&rowVal="+rowVal;
        popwindow(url);
     }
	function popwindow(url)
	{
		 newwindow=window.open(url,'name',"height=400,width=700,status=1");
    }
	function checkForNext(){
	  if(document.getElementById('noOfRows').value<=8)
	  {
	  	alert("All rows are not filled.Please Select the Items to Enter ")
	  	return false;
	  }else{
	  return true;
	  }
  }

	function openPopupForDelete(brandId,returnNo){
		var url="/hms/hms/stores?method=showDeleteReturnFromDispensary&brandId="+brandId+"&returnNo="+returnNo;
        popwindowForDelete(url);
     }
	function popwindowForDelete(url)
	{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		 newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=1000,');
    }

    function validateFieldsOnSubmit(){

    	var errorMessage="";

		/*if(document.getElementById('referenceNo').value == "")
		errorMessage=errorMessage+"Please fill referenceNo  \n";*/

		if(document.getElementById('toWard').value == 0)
		errorMessage=errorMessage+"Please Select To Deparment \n";

		/* if(document.getElementById('returnBy').value == 0)
		errorMessage=errorMessage+"Please select return By \n"; */

		if(document.getElementById('receiveBy').value == 0)
		errorMessage=errorMessage+"Please selct Received By \n";

		//if(document.getElementById('remarks').innerHTML =="")
		//errorMessage=errorMessage+"Please fill remarks \n";

		/*if(document.getElementById('reason').innerHTML == "")
		errorMessage=errorMessage+"Please fill reason \n";*/

	if(errorMessage == ""){
		return true;
	}else{
		alert(errorMessage)
		return false
	}



    }

	<%
		int i = 0;
			for(MasDepartment masDepartment : deptList){
				for (MasEmployee masEmployee : employeeAllList)
				{
					if(masEmployee.getDepartment() != null){
								// Code for Display Doctor Total Visit Day's wise
								if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){

									%>
									doctorArr[<%=i%>] = new Array();
									doctorArr[<%=i%>][0] = <%=masDepartment.getId()%>;
									doctorArr[<%=i%>][1] = <%=masEmployee.getId()%>;
									doctorArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%>";

								<%

								i++;
								}
									}
				}
			}

		%>



</script>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>

<input type="hidden" name="rows" id="rr" value="1" />

