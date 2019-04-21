<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * departmentIndentjsp
 * Purpose of the JSP -  This is for Department Indent.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 08th Feb, 2008
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>
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
	Calendar tillDate= Calendar.getInstance();
	String tillDateView="";
	tillDate.add(Calendar.DATE, 30);
	String tmonth=String.valueOf((tillDate.get(Calendar.MONTH))+1);
    String tdate=String.valueOf(tillDate.get(Calendar.DATE));
	if(tmonth.length()<2){
		tmonth="0"+tmonth;
		}
		if(tdate.length()<2){
			tdate="0"+tdate;
		}
	tillDateView=tdate+"/"+tmonth+"/"+tillDate.get(calendar.YEAR);
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
	
	String max="";
	if(map.get("max") != null){
		max = (String) map.get("max");
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

	
%>
<form name="stockReservation" method="post">
<div class="titleBg">
<h2>Stock Reservation</h2>
</div>
<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class="Block">
<label>Reservation No.</label>
 <input type="text" name="reservationNo" validate="Reservation No,string,yes" value="<%=max %>" readonly="readonly" MAXLENGTH="8" class="readOnly" />
 

 <div class="clear"></div>
<label> Item Group</label> 
<select name="itemGroupId" id="itemGroupId"    onblur="submitProtoAjaxWithDivName(this.form.name,'stores?method=getItemTypeList&group='+this.value,'nameDiv');" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreGroup masStoreGroup:storeGroupList){
		%>
		<option value="<%=masStoreGroup.getId() %>"><%=masStoreGroup.getGroupName() %></option>
	<%}} %>
</select>
<div id="nameDiv">
<label> Item Type</label>
<select name="itemTypeId"   id="itemTypeId" >
	<option value="0">Select</option>
	<%if(itemTypeList.size()>0){
		for(MasItemType masItemType:itemTypeList){
		%>
		<option value="<%=masItemType.getId() %>"><%=masItemType.getItemTypeName() %></option>
	<%}} %>
</select>
<label>Item Section</label>
<select name="sectionId"  id="sectionId" >
	<option value="0">Select</option>
	<%if(storeGroupList.size()>0){
		for(MasStoreSection masStoreSection:sectionList){
		%>
		<option value="<%=masStoreSection.getId() %>"><%=masStoreSection.getSectionName()%></option>
	<%}} %>
</select>

<label>Item Category</label>
<select name="categoryId"   id="categoryId"  >
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
<div class="clear"></div>
</div>
<div class="clear"></div>
<!-- <h4>Block Item Details</h4> -->
<div class="clear"></div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow()" />
	<div class="cmntable">
			<table width="100%"  id="blockDetails" >
				
					<tr>

						<th>S.No.</th>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Batch No.</th>
					 	<th>DOE</th>
					  	<th>Stock</th>
					  	<th>Reserved Stock</th>
					  	<th>Till date</th>
					  	<th>Extension</th>
					  	<th>Extension Date</th>
						
						
					</tr>
					<%
					int i =1;
					
					%>
					<tr>
		<td><input type="text" size="2" value="<%=i%>" name="<%=SR_NO%>" id="srNoId<%=i %>" class="readOnly" readonly="readonly" /></td>
		<td><input type="text" size="6" tabindex="1"    value="" readonly="readonly" name="pvms" id="pvms<%=i %>" />
		<input type="hidden" value="" name="itemId" id="itemId<%=i %>" /></td>
		
							
	<td><input type="text" value="" tabindex="1" validate="Item Name,string,yes" name="nomenclature" size="20" id="nomenclature<%=i %>" onblur="checkForDefectiveDrugs(this.value, 'nomenclature','<%=i %>');;"  />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-10">
			new Ajax.Autocompleter('nomenclature<%=i %>','ac2update','stores?method=getItemListForIndent1',{minChars:1,parameters:'requiredField=nomenclature'});
			</script></td>
		<td><input type="text" size="6" tabindex="1" disabled value="" name="au" id="au<%=i %>"  class="readOnly" readonly="readonly"  /></td>
		<td><select name="batchName"  id="batchName<%=i%>" onchange="getExpiryDateByAjax(this.value,<%=i%>);" tabindex="1">
					<option value="">Select</option></select></td>
		<td><input type="text" size="8" value="" validate="DOE,date,no" name="doe"  id="doe<%=i %>"/></td>
		<td><input type="text" size="7" tabindex=1 value="" validate="Stock,float,no" name="stock" id="stock<%=i%>" readonly />
		</td>
		<td><input type="text" size="7" tabindex=1 value="" validate="Reserved Stock,float,yes" maxlength="10" name="reservedStock" onblur="checkStock(this.value,<%=i%>);" id="reservedStock<%=i%>"  />
		</td>
		<td><input type="text" size="8" value="<%=tillDateView %>" readonly="readonly" validate="Till Date,date,no"  name="tillDate" id="tillDate<%=i %>"  />
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date+i%>',document.stockReservation.tillDate,event)" />
	 </td>
		
			<td><Select name="extension"  id="extension<%=i%>">
			<option value="">Select</option>
				<option value="yes">yes</option>
				<option value="No">No</option>
			</Select></td>
			<td><input type="text" size="8" value="" readonly="readonly" validate="Extention Date,date,no" name="extensionDate" id="extensionDate<%=i %>"  />
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date+i%>',document.stockReservation.extensionDate<%=i %>,event)" />
	 </td>
					</tr>
			</table>
	</div>		
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>"  />

<div class="clear"></div>
<div class="paddingTop5"></div>

<label>Remarks</label>
<textarea name="remarks"   validate="Remarks,remarks,no" cols="0" rows="0" class="large" maxlength="198" tabindex="1" ></textarea>
<div class="clear"></div>
<input	type="button" name="Reserved" type="submit" value="Reserved" class="button" onclick="submitForm('stockReservation','stores?method=submitResrvedStock');" />

</form>
<script type="text/javascript">
function checkStock(val,inc){
	var stock =  document.getElementById('stock'+inc).value;	
	if(parseFloat(val) > parseFloat(stock)){
		alert("Reserved Stock  cannot be greater than Stock Quantity.")
		document.getElementById('reservedStock'+inc).value = "";
		return false;	
	}	
	return true;	
}
function removeRow()
{
	var tbl = document.getElementById('blockDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	     
  	for(i=1;i<=document.getElementsByName('SRNo').length;i++)
	{
		
  		//if (document.getElementsByName('srno')[i].checked == true)
		//{
		  	tbl.deleteRow(i+1);
		//}
	}
}

function addRow(){
	  var tbl = document.getElementById('blockDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.setAttribute("readonly", "readonly");
	  e0.name='<%=SR_NO%>'+iteration;
	  e0.value =iteration
	  e0.id='srNoId'+iteration;
	  e0.size='3'
	  e0.className = 'readOnly';
	 cellRight1.appendChild(e0);

	 var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvms';
	  e1.id='pvms'+iteration;
	  e1.setAttribute("readonly", "readonly");
	  e1.class = 'readonly'
	  e1.size='5'
	 cellRight2.appendChild(e1);
		 
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.size='8';
	  e11.name='itemId';
	  e11.id='itemId'+iteration
	  cellRight2.appendChild(e11);

	  var cellRight3 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.onblur=function(){checkForDefectiveDrugs(this.value, 'nomenclature',iteration);};
	  e2.name = 'nomenclature';
	  e2.value='';
	  e2.setAttribute('validate', 'Item Name,string,yes');
	  e2.id = 'nomenclature' + iteration;
	  e2.size = '20';
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight3.appendChild(newdiv);
	  cellRight3.appendChild(e2);
		new Ajax.Autocompleter('nomenclature'+iteration,'ac2update','stores?method=getItemListForIndent1',{minChars:1,parameters:'requiredField=nomenclature'});

	 // new Ajax.Autocompleter('nomenclature'+iteration,'ac2updates'+iteration,'stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=nomenclature'+iteration+'&counter='+iteration});
	  var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='au';
	  e3.size = '8';
	  e3.className = 'readOnly';
	  e3.id='au'+iteration;
	  cellRight4.appendChild(e3);
			  
	 
	 var cellRight5 = row.insertCell(4);
	  var e4 = document.createElement('select');
	  e4.name='batchName';
	  e4.id='batchName'+iteration
	  e4.setAttribute('validate', 'Batch No,string,yes');
	  e4.value='';
	  e4.options[0] = new Option('Select', '');
	  e4.onchange=function(){getExpiryDateByAjax(this.value,iteration);};
	  cellRight5.appendChild(e4);
	  
	  var cellRight6 = row.insertCell(5);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.size='8';
	  e8.name='doe';
	  e8.id='doe'+iteration
	  cellRight6.appendChild(e8);

	  var cellRight7 = row.insertCell(6);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.size='7';
	  e9.name='stock';
	  e9.id='stock'+iteration
	  cellRight7.appendChild(e9);

	  var cellRight8 = row.insertCell(7);
	  var e10 = document.createElement('input');
	  e10.type = 'text';
	  e10.size='7';
	  e10.name='reservedStock';
	  e10.value='';
	  e10.onblur=function(){checkStock(this.value,iteration);};
	  e10.setAttribute('validate', 'Reserved Stock,float,yes');
	  e10.setAttribute('maxlength', '10');
	  e10.id='reservedStock'+iteration;
	  cellRight8.appendChild(e10);

	  var cellRight9 = row.insertCell(8);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.size='8';
	  e12.name='tillDate';
	  e12.value='<%=tillDateView %>';
	  e12.setAttribute("readonly", "readonly");
	  e12.id='tillDate'+iteration;
	  cellRight9.appendChild(e12);
	  var eImg = document.createElement('img');
		eImg.src = '/hms/jsp/images/cal.gif';
		eImg.class = 'calender';
		eImg.style.display ='inline';
		eImg.onclick = function(event){
						setdate('',document.getElementById('tillDate'+iteration),event) };
		cellRight9.appendChild(eImg);
	 

	  var cellRight10 = row.insertCell(9);
	  var e13 = document.createElement('select');
	  e13.class = 'medium'
	  e13.name='extension';
	  e13.setAttribute('validate', 'Extension,string,no');
	  e13.id='extension'+iteration
	  e13.options[0] = new Option('Select', '');
	  e13.options[1] = new Option('yes', 'Yes');
	  e13.options[2] = new Option('No', 'No');
	  cellRight10.appendChild(e13);
	  
	  var cellRight11 = row.insertCell(10);
	  var e15 = document.createElement('input');
	  e15.type = 'text';
	  e15.size='8';
	  e15.name='extensionDate';
	  e15.setAttribute("readonly", "readonly");
	  e15.id='extensionDate'+iteration
	  cellRight11.appendChild(e15);
	  var eImg = document.createElement('img');
		eImg.src = '/hms/jsp/images/cal.gif';
		eImg.class = 'calender';
		eImg.style.display ='inline';
		eImg.onclick = function(event){
						setdate('',document.getElementById('extensionDate'+iteration),event) };
		cellRight11.appendChild(eImg);
	  
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
		ajaxFunctionForAutoCompleteInUnBlockItems('stockReservation','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
		
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
		        	//var batchId  = batch.getElementsByTagName("batchId")[0];
		        	var batchName  = batch.getElementsByTagName("batchName")[0];
		        	obj.length++;
					obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
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
function checkForDefectiveDrugs(val,a,inc)
{
		//var pageNo =parseInt(document.getElementById('pageNo').value) 
		//var start=((pageNo-1)*10)+1;
    	//var end=((pageNo-1)*10)+10;
    	
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
		ajaxFunctionForAutoCompleteInDefectiveDrugs('stockReservation','stores?method=fillItemsForDefectiveDrugs&pvmsNo=' + pvms , inc);
		
}  
function ajaxFunctionForAutoCompleteInDefectiveDrugs(formName,action,rowVal) {

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
		         var msg  = item.getElementsByTagName("msg")[0];
		         if(pvms.childNodes[0] != undefined){
	        	document.getElementById('pvms'+rowVal).value = pvms.childNodes[0].nodeValue
		         }
		         if(pvms.childNodes[0] != undefined){
		        	 document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue
		         }
	        	document.getElementById('au'+rowVal).value = au.childNodes[0].nodeValue
	        	
	        	/* if(manufacturerId.childNodes[0] != undefined){
	        		 document.getElementById('manufacturerId'+rowVal).options[0].value=manufacturerId.childNodes[0].nodeValue
	    	       }
	        	if(manufacturerName.childNodes[0] != undefined){
	        		document.getElementById('manufacturerId'+rowVal).options[0].text=manufacturerName.childNodes[0].nodeValue
	   	       }*/
	        	//document.getElementById('quanRec'+rowVal).value=0;
	        	//document.getElementById('quanRecTemp'+rowVal).value=0;

			if(batchLength !=undefined ){
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
		        	//var batchId  = batch.getElementsByTagName("batchId")[0];
		        	var batchName  = batch.getElementsByTagName("batchName")[0];
		        	obj.length++;
		        	obj.options[obj.length-1].value=batchName.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;

	        	}
			}
	        	 if(msg !=undefined && msg.childNodes[0] !=undefined){
					   alert(msg.childNodes[0].nodeValue);
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
		        var stock  = item.getElementsByTagName("stockAvailable")[0];
		        /*var manufactureDate  = item.getElementsByTagName("manufactureDate")[0];
		        var manufacturerId  = item.getElementsByTagName("manufacturerId")[0];
		        var manufacturerName  = item.getElementsByTagName("manufacturerName")[0];
		       	var mId  = item.getElementsByTagName("mId")[0];
		          if(manufactureDate.childNodes[0] != undefined){
		        	document.getElementById('dom'+rowVal).value = manufactureDate.childNodes[0].nodeValue
		          }
		          if(manufacturerName.childNodes[0] != undefined){
	        		document.getElementById('manufactureName'+rowVal).value = manufacturerName.childNodes[0].nodeValue
		          }
		          if(manufacturerId.childNodes[0] != undefined){
	        		document.getElementById('manufactureId'+rowVal).value = manufacturerId.childNodes[0].nodeValue
		          }
		         
		          */
		        if(expiryDate.childNodes[0] != undefined){
	        		document.getElementById('doe'+rowVal).value = expiryDate.childNodes[0].nodeValue
		          }
		        if(stock.childNodes[0] != undefined){
	        		document.getElementById('stock'+rowVal).value = stock.childNodes[0].nodeValue
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


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		