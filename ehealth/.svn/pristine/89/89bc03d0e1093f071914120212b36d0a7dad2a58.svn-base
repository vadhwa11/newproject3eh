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
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>

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
	List<MasStoreSection>sectionList = new ArrayList<MasStoreSection>();
	List<MasItemCategory>categoryList = new ArrayList<MasItemCategory>();
	List<MasItemClass> itemClassList = new ArrayList<MasItemClass>();
	List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("storeGroupList") != null){
		storeGroupList = (List)map.get("storeGroupList");
	}
	if(map.get("itemTypeList") != null){
		itemTypeList = (List)map.get("itemTypeList");
	}
	if(map.get("sectionList") != null){
		sectionList = (List)map.get("sectionList");
	}
	if(map.get("categoryList") != null){
		categoryList = (List)map.get("categoryList");
	}
	if(map.get("itemClassList") != null){
		itemClassList = (List)map.get("itemClassList");
	}
	if(map.get("requestByEmployeeList") != null){
		requestByEmployeeList = (List)map.get("requestByEmployeeList");
	}
	String broadCastNo= "";
	if(map.get("broadCastNo") != null){
		broadCastNo = (String)map.get("broadCastNo");
	}


	
%>
<form name="enquiryBroadcast" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Enquiry BroadCast</h2>
</div>
<div class="Block">
<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>

<h4>Details</h4>
<div class="clear"></div>

<label>Broadcast No.<span>*</span></label>
 <input type="text" name="broadCastNo" value="<%=broadCastNo %>" validate="Broad Cast No.,string,yes"  MAXLENGTH="8"  /> 
	
	<label>BroadCast Date<span>*</span></label>
	 <input type="text" name="broadcastDate" value="<%=date %>" readonly="readonly" class="date"   validate="Broad Cast Date,date,yes" />
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.enquiryBroadcast.broadcastDate,event)" />

<label>Type Of Broadcast <span>*</span></label>
<select name="typeOfBroadCast" validate="Broad Cast Type,metachar,yes">
<option value="">Select</option>
<option value="Excess">Excess</option>
<option value="Enquiry">Enquiry</option>
</select>

<label>Valid Up To<span>*</span></label>
<input type="text" name="validUpToDate" value="" readonly="readonly" class="date"   validate="Valid Up To,date,no" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.enquiryBroadcast.validUpToDate,event)" />

<div class="clear"></div>

<%-- <label><span>*</span> Approved By</label> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Approved By,String,no">
	<option value="0">Select</option>
	
</select>--%>
<%-- <label><span>*</span> Request By</label>
 <select name="<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>" validate="Request By,String,no">
	<option value="0">Select</option>
	<%if(requestByEmployeeList.size()>0){
		for(MasEmployee masEmployee:requestByEmployeeList){
		%>
		<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}} %>
	
</select>--%>

<label> Item Group</label> 
<select name="itemGroupId" id="itemGroupId"   onblur="submitProtoAjaxWithDivName('enquiryBroadcast','stores?method=getItemTypeList&group='+this.value,'nameDiv');" >
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
<select name="sectionId"   id="sectionId" >
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
<select name="classId"   id="classId" >
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
<h4>Indent Details</h4>
<div class="clear"></div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
<input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow();" />
<div class="clear"></div>
<div class="cmntable">
<table border="0" cellpadding="0" cellspacing="0" id="indentGrid">
					<tr>
						<th>SL No.</th>
						
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						 <th>Available Stock</th>
						<th>Demanded/Excess Qty</th>
						<th>Remarks</th>
					</tr>
					<%
						int i = 1;
						String nomenclature="nomenclature";
					  String au="au";
					  String pvms="pvms";
					  String stock="stock";
					  String qtyRequest="qtyRequest";
					  String itemId="itemId";
					%>
					
					<tr>
						<td width="%5"><input type="checkbox" size="5" value="<%=i %>" name="srno" id="srNoId<%=i %>"  readonly="readonly"  /></td>
							
						<td><input type="text" size="6" tabindex="1"  value="" name="pvms" id="<%=pvms+i %>" validate="pvms,string,no"/></td>
							
							
						<td><input type="text" value="" tabindex="1" name="nomenclature" size="50" id="<%=nomenclature+i %>" validate="Item Name,string,yes" onblur="getOtherItemsForDepartmentIndent(<%=i %>);"  />
							<div id="ac2update" class="autocomplete" style="display: none;"></div>
							<script type="text/javascript" language="javascript" charset="utf-10">
							new Ajax.Autocompleter('<%="nomenclature"+""+i %>','ac2update','stores?method=getItemListForIndent',{minChars:1,parameters:'requiredField=<%=nomenclature%>&groupId='+document.getElementById('itemGroupId').value+'&itemTypeId='+document.getElementById('itemTypeId').value+'&sectionId='+document.getElementById('sectionId').value+'&categoryId='+document.getElementById('categoryId').value+'&classId='+document.getElementById('classId').value+''});
							//} 
								<%--new Ajax.Autocompleter('<%="nomenclature"+""+i %>','ac2update','stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=<%=nomenclature%>&itemGroupId='+document.getElementById('itemGroupId').value+'&itemTypeId='+document.getElementById('itemTypeId').value+''});--%>
								</script></td>
					<td><input type="text" size="6" tabindex="1" disabled value="" name="au" id="<%="au"+""+i %>" class="readOnly"  readonly="readonly" /></td>
						<td><input type="text" size="6" readonly="readonly" tabindex="1" value="" id="<%=stock+i %>" name="stock" validate="Stock,float,no" /></td>
						<td><input type="text" size="8" value="" name="qtyRequest" id="<%=qtyRequest+i %>" validate="Demanded Qty,float,no" maxlength="12" /></td>
						<td><input type="text" size="8" value="" name="remarks" id="remarks<%=i %>" maxlength="50" validate="Remarks,remarks,no" /></td>
						<input type="hidden" value="" name="itemId" id="<%=itemId+i %>" validate="itemId,int,no"/></td>
						
					</tr>
		
</table>
</div>
 <input	type="hidden" name="hdb" id="hdb"	value="<%=i %>"  />
<div class="clear"></div>


<div class="paddingTop40"></div>
<div class="clear"></div>




<div class="clear"></div>
<input type="button" name="Next/Update" type="submit" value="Submit"	onClick="submitForm('enquiryBroadcast','stores?method=submitEnquiryBroadCast');" class="button" />
<input	type="button" name="Submit" type="submit" value="Reset" class="button" />

<script type="text/javascript">





function addRow(){
	  var tbl = document.getElementById('indentGrid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'checkbox';
	  e0.name='srno';
	  e0.id='srNoId'+iteration;
	  e0.size='3'
	  e0.value = iteration;
	 cellRight0.appendChild(e0);

	 var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='pvms';
	  e1.id='pvms'+iteration;
	  e1.size='5'
	 cellRight1.appendChild(e1);

	  var cellRight2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.onblur=function(){getOtherItemsForDepartmentIndent(iteration);
	                      };
	  e2.name = 'nomenclature';
	  e2.id = 'nomenclature' + iteration;
	  e2.size = '50';
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight2.appendChild(newdiv);
	  cellRight2.appendChild(e2);
		new Ajax.Autocompleter('nomenclature'+iteration,'ac2update','stores?method=getItemListForIndent',{minChars:1,parameters:'requiredField=<%=nomenclature%>'});

	 // new Ajax.Autocompleter('nomenclature'+iteration,'ac2updates'+iteration,'stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=nomenclature'+iteration+'&counter='+iteration});
	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='au';
	  e3.size = '8';
	  e3.id='au'+iteration;
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(4);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.size='8';
	  e7.name='stock';
	  e7.id='stock'+iteration
	  cellRight4.appendChild(e7);
	 
	  var cellRight5 = row.insertCell(5);
	  var e11 = document.createElement('input');
	  e11.type = 'text';
	  e11.size='10';
	  e11.name='qtyRequest';
	  e11.id='qtyRequest'+iteration
	  cellRight5.appendChild(e11);

	  var cellRight6 = row.insertCell(6);
	  var e12 = document.createElement('input');
	  e12.type = 'text';
	  e12.size='8';
	  e12.name='remarks';
	  e12.id='remarks'+iteration
	  cellRight6.appendChild(e12);

	  var e12 = document.createElement('input');
	  e12.type = 'hidden';
	  e12.size='8';
	  e12.name='itemId';
	  e12.id='itemId'+iteration
	  cellRight6.appendChild(e12);
	}

function removeRow()
{
	var tbl = document.getElementById('indentGrid');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	     
  	for(abc=0;abc<document.getElementsByName('srno').length;abc++)
	{
		
  		if (document.getElementsByName('srno')[abc].checked == true)
		{
		  	tbl.deleteRow(abc+1);
		}
	}
}


function getOtherItemsForDepartmentIndent(val){

	enquiryBroadcast.method="post";
	 var counterValue=document.getElementById("hdb").value

	 var nomenclature=document.getElementById("nomenclature"+val).value;
	 for(var i=1;i<(parseInt(counterValue));i++){

	 if(document.getElementById("nomenclature"+i)!=null){
	 if(document.getElementById("nomenclature"+i).value==nomenclature && i!=val){

	 alert("Item is already Selected");
	 document.getElementById("nomenclature"+val).value="";
	 return false;
	 }
	 }
	 }

	   var index1 = nomenclature.lastIndexOf("[");
	        index1++;

	      var index2 = nomenclature.lastIndexOf("]");
	       var pvmsNo = nomenclature.substring(index1,index2);
	  <%--var fromWard=document.indentForm.<%= FROM_WARD%>.value;--%>
	  <%--var toWard=document.enquiryBroadcast.<%= TO_WARD%>.value;--%>
	    if(pvmsNo!=""){
	ajaxFunctionForGetOtherItemsForDepartmentIndent('enquiryBroadcast','stores?method=getOtherItemsForIndent&requiredField=' + encodeURIComponent(pvmsNo)+''   , val);

	}}

function ajaxFunctionForGetOtherItemsForDepartmentIndent(formName,action,rowVal)
{
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
   var url=action;
	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
   xmlHttp.open("GET",url,true);
   xmlHttp.setRequestHeader("Content-Type", "text/xml");
   xmlHttp.send(null);
   xmlHttp.onreadystatechange=function()
   {
     if(xmlHttp.readyState==4){
     	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

     	for (loop = 0; loop < items.childNodes.length; loop++)
     	{
	   	    var item = items.childNodes[loop];
	        var id  = item.getElementsByTagName("id")[0];
	        var pvms  = item.getElementsByTagName("pvms")[0];
	      var au=item.getElementsByTagName("au")[0];
	      var stock=item.getElementsByTagName("stock")[0];
	        var name  = item.getElementsByTagName("name")[0];
       	document.getElementById('nomenclature'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
       	document.getElementById('pvms'+rowVal).value =  pvms.childNodes[0].nodeValue ;
       	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue ;
       	document.getElementById('stock'+rowVal).value = stock.childNodes[0].nodeValue ;
       	document.getElementById('qtyRequest'+rowVal).value = 0 ;
       	document.getElementById('au'+rowVal).value =  au.childNodes[0].nodeValue ;

     }
   }
 }
}


function openPopupWindow()
{
 var url="/hms/hms/stores?method=showInstituteDataJsp";
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>


