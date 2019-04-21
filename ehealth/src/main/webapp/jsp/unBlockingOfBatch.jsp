<%@page import="jkt.hms.masters.business.ItemGroup"%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>

<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
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
	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasStoreGroup> storeGroupList = new ArrayList<MasStoreGroup>();
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	List<MasItemCategory> categoryList = new ArrayList<MasItemCategory>();
	List<MasItemClass> itemClassList = new ArrayList<MasItemClass>();
	 if(map.get("storeGroupList")!=null){
		 storeGroupList=(List<MasStoreGroup>)map.get("storeGroupList");
   		}


	
%>


<form name="blockingOfBatch1" method="post" enctype="multipart/form-data">
<div class="titleBg" >
<h2>UnBlocking Of Batch</h2>
</div>
<div class="clear"></div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class="clear"></div>
<div class="Block">
<%--<label>Demand No.</label> <input type="text"
	name="<%=DEMAND_NO %>" value="" readonly="readonly"
	MAXLENGTH="8" class="readOnly" /> --%>
<label> Item Group</label> 
<select name="itemGroupId" id="itemGroupId" validate="Item Group,String,no"  onblur="submitProtoAjaxWithDivName(this.form.name,'stores?method=getItemTypeList&group='+this.value+'&'+csrfTokenName+'='+csrfTokenValue,'nameDiv');" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreGroup masStoreGroup:storeGroupList){
		%>
		<option value="<%=masStoreGroup.getId() %>"><%=masStoreGroup.getGroupName() %></option>
	<%}} %>
</select>
<div id="nameDiv">
<label> Item Type</label>
<select name="itemTypeId" validate="Item Group,String,no" id="itemTypeId" >
	<option value="0">Select</option>
	<%if(itemTypeList.size()>0){
		for(MasItemType masItemType:itemTypeList){
		%>
		<option value="<%=masItemType.getId() %>"><%=masItemType.getItemTypeName() %></option>
	<%}} %>
</select>
<label>Item Section</label>
<select name="sectionId" validate="Item Group,String,no" id="sectionId" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreSection masStoreSection:sectionList){
		%>
		<option value="<%=masStoreSection.getId() %>"><%=masStoreSection.getSectionName()%></option>
	<%}} %>
</select>

<label>Item Category</label>
<select name="categoryId" validate="Item Group,String,no" id="categoryId"  >
	<option value="0">Select</option>
	<%if(categoryList.size()>0){
		for(MasItemCategory masItemCategory:categoryList){
		%>
		<option value="<%=masItemCategory.getId() %>"><%=masItemCategory.getItemCategoryName() %></option>
	<%}} %>
</select>
<label>Item Class</label>
<select name="classId" validate="Item Group,String,no" id="classId" >
	<option value="0">Select</option>
	<%if(itemClassList.size()>0){
		for(MasItemClass masItemClass:itemClassList){
		%>
		<option value="<%=masItemClass.getId() %>"><%=masItemClass.getItemClassName() %></option>
	<%}} %>
</select>
</div>

<div class="clear"></div>

	<div class="clear"></div>
</div>
<h4>Unblock Item Details</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRowUnblockItem();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="" />
  <div class="cmntable">
<table  width="100%" border="0" cellpadding="0" cellspacing="0" id="unblockDetails">

					<tr>

						
						<th>S.No.</th>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Batch No.</th>
						<th>DOM</th>
					 	<th>DOE</th>
					  	<th>Manufacture</th>
					  	<th>W.E.From</th>
					  	<th>Status</th>
					  	<th>Order No</th>
					  	<th>Order Date</th>
					  	<th>Reason</th>
<!-- 					  	<th>File</th> -->
					</tr>
					<%
					int i = 1;
					
					%>
					<tr>
					<td><input type="text" size="2" value="<%=i%>" name="slNo" id="slNoId<%=i %>" class="readOnly" readonly="readonly" /></td>
		<td><input type="text" size="11" tabindex="1"  value="" class="readOnly" readonly="readonly"  name="itemCode" id="itemCode<%=i %>" />
		<input type="hidden" value="" name="idItem" id="idItem<%=i %>" /></td>
		
			<script>
function eventCallback(element, entry){
//alert("group-=="+document.getElementById('itemGroupId').value);
	return entry+"&itemGroupId=" + document.getElementById('itemGroupId').value+"&itemTypeId="+document.getElementById('itemTypeId').value+"&sectionId="+document.getElementById('sectionId').value+"&categoryId="+document.getElementById('categoryId').value+"&classId="+document.getElementById('classId').value                                                                       
}
</script> 					
	<td><input type="text" value="" validate="Item Name,string,yes" tabindex="1" name="itemName<%=i %>" size="30" id="itemName<%=i %>" onblur="checkForUnBlockItem(this.value, 'itemName','<%=i %>');;"  />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-10">
			new Ajax.Autocompleter('itemName<%=i %>','ac2update','stores?method=getItemListForIndent1',{minChars:1,parameters:'requiredField=itemName<%=i %>',callback: eventCallback});
			</script></td>
		<td><input type="text" size="6" tabindex="1" disabled value="" name="unit" id="unit<%=i %>" class="readOnly" readonly="readonly" /></td>
		<td><select name="batchName<%=i%>" id="batchName<%=i%>" validate="Batch No,string,yes" onchange="getExpiryDateByAjaxInUnBlockItems(this.value,<%=i%>);" tabindex="1">
					<option value="">Select</option></select>
					<%-- <input type="hidden" name="batchName<%=i%>" id="batchName<%=i%>" value ="" /> --%></td>
		<td><input type="text" size="8" value="" class="readOnly" readonly="readonly" name="manufactureDate<%=i%>" id="manufactureDate<%=i %>"/></td>
		<td><input type="text" size="8" value=""  class="readOnly" readonly="readonly" name="expiryDate<%=i%>"  id="expiryDate<%=i %>"/></td>
		<td><input type="text" size="10" tabindex=1 value="" class="readOnly" readonly="readonly" name="manufacture<%=i%>" id="manufacture<%=i%>" readonly />
		<input type="hidden" tabindex=1 value="" name="manufactId<%=i%>" class="readOnly" readonly="readonly" id="manufactId<%=i%>" readonly /></td>
		<td><input type="text" size="8" value=""  name="unBlockDate<%=i%>" id="unBlockDate<%=i %>"  readonly="readonly" />
				<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date+i%>',document.blockingOfBatch1.unBlockDate<%=i %>,event)" />
		</td>
		
			<td><Select name="unBlockStatus<%=i%>" id="unBlockStatus<%=i%>" >
			<option value="Select">Select</option>
				<option value="Temporary Unblock">Temporary</option>
				<option value="Parmanent Unblock">Parmanent</option>
			</Select></td>
			<td><input	type="text" name="orderNo<%=i%>" size="20" maxlength="10" id="orderNo<%=i %>"	value="" /></td>
		<td><input type="text" size="11" value=""  name="orderDate<%=i %>" id="orderDate<%=i %>"  readonly="readonly" />
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date+i%>',document.blockingOfBatch1.orderDate<%=i %>,event)" />
			</td>
			<td><Select name="unBlockReason<%=i%>" id="unBlockReason<%=i%>" >
				<option value="Select">Select</option>
				<option value="Quality Test Passed">Quality Test Passed</option>
			</Select></td>
<%-- 		<td><input type="file" name="fileName" id="fileName<%=i%>" /></td> --%>
					</tr>
			</table>
			</div>
 

<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>"  />
<div class="clear"></div>
<input	type="button" name="UnBlock" type="submit" value="UnBlock" class="button" onclick="submitForm('blockingOfBatch1','stores?method=updateBatch&flag=unBlock&'+csrfTokenName+'='+csrfTokenValue);" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


<script>
function addRowUnblockItem(){
	  var tbl = document.getElementById('unblockDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='slNo'+iteration;
	  e0.value =iteration
	  e0.id='slNoId'+iteration;
	  e0.size='3'
	  e0.className = 'readOnly'
	 cellRight1.appendChild(e0);

	 var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='itemCode'+ iteration;
	  e1.id='itemCode'+iteration;
	  e1.className = 'readOnly'
	  e1.size='5'
	 cellRight2.appendChild(e1);
		 
	  var e18 = document.createElement('input');
	  e18.type = 'hidden';
	  e18.size='8';
	  e18.name='idItem'+ iteration;
	  e18.id='idItem'+iteration
	  cellRight2.appendChild(e18);

	  var cellRight3 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.onblur=function(){checkForUnBlockItem(this.value, 'itemName',iteration);};
	  e2.name = 'itemName'+ iteration;
	  e2.id = 'itemName' + iteration;
	  e2.size = '30';
	  e2.value='';
	  e2.setAttribute('validate','Item Name,string,yes');
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight3.appendChild(newdiv);
	  cellRight3.appendChild(e2);
	  new Ajax.Autocompleter('itemName'+iteration,'ac2update','stores?method=getItemListForIndent1',{minChars:1,parameters:'requiredField=itemName'+iteration});

	  var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='unit';
	  e3.size = '8';
	  e3.className='readOnly';
	  e3.readonly='readonly';
	  e3.id='unit'+iteration;
	  cellRight4.appendChild(e3);
			  
	 
	 var cellRight5 = row.insertCell(4);
	  var e4 = document.createElement('select');
	  e4.name='batchName'+ iteration;
	  e4.id='batchName'+iteration
	  e4.setAttribute('validate', 'Batch No,string,yes')
	  e4.options[0] = new Option('Select', '');
	  e4.onchange=function(){getExpiryDateByAjaxInUnBlockItems(this.value,iteration);};
	  cellRight5.appendChild(e4);
	  
	 /*  var e41 = document.createElement('input');
	  e41.type = 'hidden';
	  e41.size='10';
	  e41.setAttribute('readonly', 'readonly');
	  e41.name='batchName'+iteration;
	  e41.className='readOnly';
	  e41.id='batchName'+iteration
	  cellRight5.appendChild(e41); */
	  
	  var cellRight6 = row.insertCell(5);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.size='8';
	  e8.className='readOnly';
	  e8.readonly='readonly';
	  e8.name='manufactureDate'+ iteration;
	  e8.id='manufactureDate'+iteration
	  cellRight6.appendChild(e8);

	  var cellRight7 = row.insertCell(6);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.size='8';
	  e9.className='readOnly';
	  e9.readonly='readonly';
	  e9.name='expiryDate'+ iteration;
	  e9.id='expiryDate'+iteration
	  cellRight7.appendChild(e9);

	  var cellRight8 = row.insertCell(7);
	  var e10 = document.createElement('input');
	  e10.type = 'text';
	  e10.size='10';
	  e10.className='readOnly';
	  e10.readonly='readonly';
	  e10.name='manufacture'+ iteration;
	  e10.id='manufacture'+iteration
	  cellRight8.appendChild(e10);
	  

	  var e11 = document.createElement('hidden');
	  e11.type = 'text';
	  e11.size='10';
	  e11.name='manufactId'+ iteration;
	  e11.className='readOnly';
	  e11.readonly='readonly';
	  e11.id='manufactId'+iteration
	  cellRight8.appendChild(e11);

	  var cellRight9 = row.insertCell(8);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.size='8';
	  e12.name='unBlockDate'+ iteration;
	  e12.className='readOnly';
	  e12.readonly='readonly';
	  e12.id='unBlockDate'+iteration
	  cellRight9.appendChild(e12);
	  var eImg = document.createElement('img');
		eImg.src = '/hms/jsp/images/cal.gif';
		eImg.class = 'calender';
		eImg.style.display ='inline';
		eImg.onclick = function(event){
						setdate('',document.getElementById('unBlockDate'+iteration),event) };
		cellRight9.appendChild(eImg);


	  var cellRight10 = row.insertCell(9);
	  var e13 = document.createElement('select');
	  e13.name='unBlockStatus'+ iteration;
	  e13.id='unBlockStatus'+iteration
	  e13.options[0] = new Option('Select', '');
	  e13.options[1] = new Option('Temporary', 'Temporary Unblock');
	  e13.options[2] = new Option('Parmanent', 'Parmanent Unblock');
	  cellRight10.appendChild(e13);
	  
	  var cellRight10 = row.insertCell(10);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'orderNo'+ iteration;
	  e2.id = 'orderNo' + iteration;
	  e2.size = '20';
	  e2.maxlength='30';
	  cellRight10.appendChild(e2);
	  
	  var cellRight9 = row.insertCell(11);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.size='8';
	  e12.name='orderDate'+ iteration;
	  e12.className='readOnly';
	  e12.id='orderDate'+iteration
	  cellRight9.appendChild(e12);
	  var eImg = document.createElement('img');
		eImg.src = '/hms/jsp/images/cal.gif';
		eImg.className = 'calender';
		eImg.style.display ='inline';
		eImg.onclick = function(event){
						setdate('',document.getElementById('orderDate'+iteration),event) };
		cellRight9.appendChild(eImg);

	  var cellRight11 = row.insertCell(12);
	  var e14 = document.createElement('select');
	  e14.name='unBlockReason'+ iteration;
	  e14.id='unBlockReason'+iteration
	  e14.options[0] = new Option('Select', '');
	  e14.options[1] = new Option('Quality Test Passed', 'Quality Test Passed');
	 // e14.options[2] = new Option('Unquality Drug', 'Unquality Drug');
	  cellRight11.appendChild(e14);
	  
//	  var cellRight11 = row.insertCell(13);
//	  var e14 = document.createElement('input');
//	  e14.type='file';
//	  e14.name='fileName';
//	  e14.id='fileName'+iteration
//	  cellRight11.appendChild(e14);
	}
function removeRow()
{
	var tbl = document.getElementById('blockDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
	if(tblRows.length-2==0){
       	alert("Can not delete all rows")
       	return false;
   }
	         
	for(abc=0;abc<document.getElementsByName('selectedEquipment').length;abc++)
	{
		if (document.getElementsByName('selectedEquipment')[abc].checked == true)
		{
		  	tbl.deleteRow(abc+1);
		}
	}
}

function checkForUnBlockItem(val,a,inc)
{
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		//var start=((pageNo-1)*10)+1;
  	//var end=((pageNo-1)*10)+10;
  	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
		ajaxFunctionForAutoCompleteInUnBlockItems('blockingOfBatch1','stores?method=fillItemsForDefectiveDrugs&blockFlag=unblock&pvmsNo=' + pvms+'&'+csrfTokenName+'='+csrfTokenValue , inc);
		
} 

function ajaxFunctionForAutoCompleteInUnBlockItems(formName,action,rowVal) {

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

	      //	var brandId="brandId"+rowVal;
	      	var batchId="batchName"+rowVal;
		//	obj1 =document.getElementById(brandId);
			obj = document.getElementById(batchId);
			obj.length = 1;
			//obj1.length =1;

	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var id  = item.getElementsByTagName("id")[0];
		        var pvms  = item.getElementsByTagName("pvms")[0];
		        var au  = item.getElementsByTagName("au")[0];
		        var name  = item.getElementsByTagName("name")[0];
		       // var manufacturerName=item.getElementsByTagName("manufacturerName")[0];
		        //var manufacturerId=item.getElementsByTagName("manufacturerId")[0];
		      //  var brandLength  = item.getElementsByTagName("brands")[0];
		         var batchLength  = item.getElementsByTagName("batchs")[0];
		         if(pvms.childNodes[0] != undefined){
	        	document.getElementById('itemCode'+rowVal).value = pvms.childNodes[0].nodeValue
		         }
		         if(pvms.childNodes[0] != undefined){
		        	 document.getElementById('idItem'+rowVal).value = id.childNodes[0].nodeValue
		         }
	        	document.getElementById('unit'+rowVal).value = au.childNodes[0].nodeValue
	        	
	        	/* if(manufacturerId.childNodes[0] != undefined){
	        		 document.getElementById('manufacturerId'+rowVal).options[0].value=manufacturerId.childNodes[0].nodeValue
	    	       }
	        	if(manufacturerName.childNodes[0] != undefined){
	        		document.getElementById('manufacturerId'+rowVal).options[0].text=manufacturerName.childNodes[0].nodeValue
	   	       }*/
	        	//document.getElementById('quanRec'+rowVal).value=0;
	        	//document.getElementById('quanRecTemp'+rowVal).value=0;


	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        /* 	var batchId  = batch.getElementsByTagName("batchId")[0]; */
		        	var batchName  = batch.getElementsByTagName("batchName")[0];
		        	obj.length++;
					obj.options[obj.length-1].value=batchName.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;

	        	}

	        	/* for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
	        		var brand = brandLength.childNodes[innerLoop];
		        	var brandId  = brand.getElementsByTagName("brandId")[0];
		        	var brandName  = brand.getElementsByTagName("brandName")[0];

		        	obj1.length++;
					obj1.options[obj1.length-1].value=brandId.childNodes[0].nodeValue;
					obj1.options[obj1.length-1].text=brandName.childNodes[0].nodeValue;

	        	}*/

	      	}
	      }
	    }
	    var url=action+"&"+getNameAndData(formName);
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);


	  }



function getExpiryDateByAjaxInUnBlockItems(batchId,rowVal){
	 

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
		        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
		       	var mId  = item.getElementsByTagName("mId")[0];
		        var batchNo  = item.getElementsByTagName("batchNo")[0];
		          if(manufactureDate.childNodes[0] != undefined){
		        	document.getElementById('manufactureDate'+rowVal).value = manufactureDate.childNodes[0].nodeValue
		          }
		          if(manufacturerName.childNodes[0] != undefined){
	        		document.getElementById('manufacture'+rowVal).value = manufacturerName.childNodes[0].nodeValue
		          }
		          if(manufacturerId.childNodes[0] != undefined){
	        		document.getElementById('manufactId'+rowVal).value = manufacturerId.childNodes[0].nodeValue
		          }
		          if(expiryDate.childNodes[0] != undefined){
	        		document.getElementById('expiryDate'+rowVal).value = expiryDate.childNodes[0].nodeValue
		          }
		          if(batchNo.childNodes[0] != undefined){
		        		document.getElementById('batchName'+rowVal).value = batchNo.childNodes[0].nodeValue
			          }
	        	
	      	} 
	      }
	    }
	     url="stores?method=getExpiryDateInAjax&batchName="+batchId;
 	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	 }

</script>