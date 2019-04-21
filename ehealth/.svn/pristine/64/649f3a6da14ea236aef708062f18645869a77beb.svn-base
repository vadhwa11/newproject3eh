<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * issueToDepartmentWithoutIndent.jsp
	 * Purpose of the JSP -  This is for issue to Department without indent.
	 * @author  Ritu
	 * Create Date: 02 June 2010
	 * Revision Date:
	 * Revision By:
	 * @version 1.8
	--%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>

<%@page import="jkt.hms.util.Box"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
	Map map = new HashMap();
	String userName="";
	String date="";
	String time="";
	String deptName="";
	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	int listSize=0;
	int issueId=0;
	String max="";
	List<MasEmployee> employeeList= new ArrayList<MasEmployee>();
	List<MasDepartment> departmentList= new ArrayList<MasDepartment>();
	List <StoreIssueM> searchListForPopup=new ArrayList<StoreIssueM>();
	List<StoreIssueM> lastIssueMList = new ArrayList<StoreIssueM>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	if(map.get("employeeList")!=null){
		employeeList = (List) map.get("employeeList");
	}
	int requestByEmpId=0;
	 if(map.get("requestByEmpId")!=null){
		 requestByEmpId = (Integer) map.get("requestByEmpId");
		}
	List<MasEmployee> employeeDeptByList = new ArrayList<MasEmployee>();
		if(map.get("employeeDeptByList")!=null){
			employeeDeptByList = (List) map.get("employeeDeptByList");
		}
		
	if(map.get("departmentList")!=null)
		departmentList = (List) map.get("departmentList");
	if(map.get("deptName")!=null){
		deptName=(String)map.get("deptName");
	}
	if(map.get("lastIssueMList")!=null){
		lastIssueMList = (List) map.get("lastIssueMList");
	}
	int totalPages=0;
	 if(map.get("totalPages")!=null){
		 totalPages=(Integer)map.get("totalPages");
		}
	 if(map.get("searchListForPopup")!=null){
		searchListForPopup=(List<StoreIssueM>)map.get("searchListForPopup");
	}
	if(map.get("max")!=null)
		max = (String) map.get("max");
	if(map.get("pageNo")!=null)
		pageNo = Integer.parseInt(""+map.get("pageNo"));
	if(map.get("listSize")!=null)
		listSize = Integer.parseInt(""+map.get("listSize"));

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");
	 time = (String)utilMap.get("currentTime");
	 if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	 if(map.get("issueId")!=null)
		 issueId = Integer.parseInt(""+map.get("issueId")) ;
	 String messageTOBeVisibleToTheUser ="";

		if(map.get("messageTOBeVisibleToTheUser")!=null){
			messageTOBeVisibleToTheUser=(""+map.get("messageTOBeVisibleToTheUser"));
		}
		String messageType ="";
		if(map.get("messageType")!=null){
			messageType=(""+map.get("messageType"));
		}
		Box box=HMSUtil.getBox(request);
%>


<%-- Start of Content Div --%>
<%-- Start of Main Form --%>
<script type="text/javascript">
	<%
		int i = 0;
			for(MasDepartment masDepartment : departmentList){
				for (MasEmployee masEmployee : employeeList)
				{
					if(masEmployee.getDepartment() != null){
						if(masEmployee.getDepartment().getId()==masDepartment.getId()){
							
						%>
						empArr[<%=i%>] = new Array();
						empArr[<%=i%>][0] = <%=masDepartment.getId()%>;
						empArr[<%=i%>][1] = <%=masEmployee.getId()%>;
						empArr[<%=i%>][2] = "<%=masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName())%>";
						<%
					++i;
					}
				}
			}
			}
		%>
	</script>
<%-- Title --%>
<div class="clear"></div>

<div class="clear"></div>
<form name="searchPanel" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4><span id="msgId"></span></h4>
<div class="titleBg">
<h2>Department Issue Without Indent</h2>
</div>
<div class="Block">
<%--------------- Start of Tool Panel ---------------------------%>
<%-- 
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>--%>
<div class="clear"></div>
<%--------------- End of Tool Panel ---------------------------%>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="clear"></div>
<%--------------- Start of Search Panel ---------------------------%>
<label><span>*</span> Issue No</label>
<select name="<%= ISSUE_UNIT_ID%>" validate="Issue No,string,yes">
	<option value="">Select</option>
	<%for (StoreIssueM storeIssueM :searchListForPopup ) {%>
	<option value=<%=storeIssueM.getId()%>><%=storeIssueM.getIssueNo()%></option>
	<%}%>
</select>
<input type="image" name="button" class="button"	onClick="submitForm('searchPanel','stores?method=searchIssueCiv');" />
</div>
</form>
<%-------------------- End of Search Panel ---------------------------%>
<div class="division"></div>
<%--------------------Start of Status message  ---------------------------%>
<%if(!(messageTOBeVisibleToTheUser.equals("") ) || (messageTOBeVisibleToTheUser !=null) ){
					if(messageType.equals("success")){%>
<h4><%=messageTOBeVisibleToTheUser %></h4>
<%}%>
<%if(messageType.equals("failure")){%>
<span> <%=messageTOBeVisibleToTheUser %> </span>
<%}}%>
<%--------------------End of Status message  ---------------------------%>
<form name="issueToDeptWithoutIndent" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="rows" id="rr" value="1" validate="rows,int,no"/> <input type="hidden"
	name="listSize" value="<%=listSize%>" validate="listSize,int,no"/> <input type="hidden"
	name="pageNo" value="<%=pageNo%>" validate="pageNo,int,no"/> <input type="hidden"
	name="<%=ISSUE_ID%>" id="issueId" value="" validate="issueId,int,no"/>
<div class="clear"></div>
<h4>Issue Details</h4>
<div class="clear"></div>
<label>Issue No.</label>
<input type="text" name="issueNo" id="issueNo" readonly="readonly"
	value="<%=max%>" tabindex="1" MAXLENGTH="8" validate="issueNo,string,no"/><label>Issue
Date</label> <input type="text" name="<%=ISSUE_DATE%>" tabindex="1" id="issueDate"
	class="readOnly" readonly="readonly" value="<%=date %>" MAXLENGTH="30" validate="issueDate,date,no"/>

<label><span>*</span>To Department </label> <select
	name="<%=DEPARTMENT_ID_TEMP%>" tabindex="1" id="departmentIdTemp" onchange="populateEmp(this.value,'issueToDeptWithoutIndent');"
	validate="To Department,metachar,yes" >
	<!-- onchange="populateEmp(this.value,'issueToDeptWithoutIndent');" -->
	<option value="">Select</option>
	<%for (MasDepartment department :departmentList ) {	%>
	<option value=<%=department.getId()%>><%=department.getDepartmentName()%></option>
	<%}	%>
</select>

<div class="clear"></div>


<label>Indent No.</label> <input type="text" tabindex="1"
	name="<%=REQUEST_NO %>" tabindex="1" id="requestNo"
	value="" MAXLENGTH="30" validate="Indent No,string,no"/>
	<%-- <label>Request By</label>
	<select name="<%= REQUEST_BY%>" id="requestBy" tabindex="1" 
	validate="Request By,metachar,no">
	<option value="">Select</option>
	<%
	
	for (MasEmployee masEmployee :employeeList ) {%>
	<option value="<%=masEmployee.getId()%>"><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> --%>


<label>Request Date</label> <input type="text" name="<%=REQUEST_DATE%>" tabindex="1" id="requestDate"
	class="date" validate="Request Date,date,no" readonly="readonly" value="<%=date %>" MAXLENGTH="30" />
	 <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="javascript:setdate('',document.issueToDeptWithoutIndent.<%=REQUEST_DATE%>,true);" />
<div class="clear"></div>
<%-- <!-- 
<label>Approved By</label> <select name="<%= APPROVED_BY%>" tabindex="1"
	id="approvedBy" validate="Approved By,String,Yes">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeList ) {%>
	<option value=<%=masEmployee.getId()%> ><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> <label>Issued By</label> <select name="<%= ISSUED_BY%>" tabindex="1"
	id="issuedBy" validate="Issued By,String,Yes">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeList ) {%>
	<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select>
 --> --%>
<%-- <label><span>*</span>Approved By</label> <select name="<%= APPROVED_BY%>" tabindex="1"
	id="approvedBy" validate="Approved By,metachar,Yes">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeDeptByList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("approvedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> --%> 

<%-- <label><span>*</span>Issued By</label> <select name="<%= ISSUED_BY%>" tabindex="1"
	id="issuedBy" validate="Issued By,metachar,Yes">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeDeptByList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),box.get("issuedBy")) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> --%>
<script type="text/javascript">
<%
if(requestByEmpId != 0){

%>
document.issueDispensaryForm.<%=REQUEST_BY%>.value = '<%=requestByEmpId%>';
<%
}
%>
</script>
<div class="clear"></div></div>


<!--<input type="button" tabindex="1" name="sss" align="right"
	class="button" value="Submit"
	onclick="if(checkIssueQty()){submitForm('issueToDeptWithoutIndent','stores?method=addNextOrSubmitIssue&buttonName=submit');}" />-->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" value="Add Row" class="button" onclick="addRow();"/>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" size="2" value="0" name="noOfRecords"	id="noOfRecords" validate="noOfRecords,int,no"/>
<input type="hidden"	name="<%=INDENT_ID %>" value="<%=indentId%>" id="hdb" validate="indentId,int,no"/>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Item Details</h4>
<div class="clear"></div>
<table colspan="7" id="issueDetails">
	<thead>
		<tr>

			<th width="5%">S.No.</th>
			<th width="13%">Item No</th>
			<th width="10%">Item Name</th>
			<th width="13%">Unit</th>
			<th width="13%">BarCode No</th>
			<th width="13%">Availbale Stock</th>
			<th width="13%">Requested Qty</th>
			<th width="13%">Issue</th>
			<th width="13%">Qty Issued</th>

		</tr>
	</thead>
	<tbody>
		<%
	    	int inc= 1;

    	  %>

		<tr>
			<td>
			<input type="hidden" name="tt8<%=inc %>" id='issueQtyAndBatch<%=inc %>' value="blank" readonly="readonly"/>
		    <input type="hidden" name="tt6<%=inc %>" id="quantityToIssueOverAll<%=inc%>" value="" readonly="readonly"/>
		    <input type="hidden" name="batchId<%=inc %>" id="batchId<%=inc%>" value="" readonly="readonly"/>
			<input type="text" size="2" tabindex="1"
				value="<%=inc%>" id="srNo<%=inc %>"
				name="<%=SR_NO%><%=inc %>" readonly="readonly" /></td>
			<td><input type="text" size="10" tabindex="1"
				name="<%=ITEM_CODE%><%=inc %>"
				value="" id="itemCode<%=inc %>" /> <input
				type="hidden" value=""
				name="<%=ITEM_ID%><%=inc %>" id="itemId<%=inc %>" /> </td>
			<td><input id="itemName<%=inc %>" type="text" tabindex="1" size="45"
				value="" name="<%=ITEM_NAME%><%=inc %>" onblur="displayItemDetails(<%=inc %>);"/>
			<div id="ac2update" class="autocomplete" style="display: none;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
				new Ajax.Autocompleter('itemName<%=inc %>','ac2update','stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=<%=ITEM_NAME+inc%>&storeDepartmentId=<%=deptId%>'});
			</script>
				</td>

			<td >

			<input type="text" size="8" value="" tabindex="1"
				readonly="readonly" name="<%=AV%><%=inc %>" id="au<%=inc %>" />
			</td>
			<td width="10%"><input type="text" size="8" value=""
				maxlength="30" tabindex="1" name="barCodeNo" id="barCodeNo<%=inc %>"
				onblur="getDataForBarcode(this.value,<%=inc %>)" /></td>

			<td>
			 <input type="text"
				tabindex="1" size="15" value="" id="stock<%=inc %>" name="stock<%=inc %>"
				class="medcaption" readonly />
			</td>
			<td width="10%"><input type="text" tabindex="1" size="8"
				value="" name="<%=RequestConstants.QTY_IN_REQUEST%><%=inc %>" id="qtyRequest<%=inc %>" />
			</td>
			<td><input type="text" size="10" readonly="readonly"
				value="" name="<%=QTY_ISSUED%><%=inc %>" tabindex="2"
				id="qtyIssued<%=inc %>" align="right" /></td>
			<td><input type="button" tabindex="1"
				class="buttonIssue" tabindex="1"
				onclick="if(checkFields()){openPopupForItemIssue(this.value,document.getElementById('qtyRequest<%=inc %>').value,<%=inc%>,'','');}"
				name="Submit" value=" " /></td>

		</tr>

	</tbody>

</table>
<input type="button" class="button" tabindex="1" onclick="if(checkFields()){submitForm('issueToDeptWithoutIndent','stores?method=submitDepartmentIssueWithoutIndent');}" name="Submit2" value="Save"  />
<input type="hidden" id="counter" name="counter" value="<%=inc %>" />
<script	type="text/javascript">
		<!--
			// Main vBulletin Javascript Initialization
			vBulletin_init();
		//-->
		</script>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<%-- End of Main form --%>


<script type="text/javascript">


	function checkIssueQty(){
		var issued = "no";
		for(var i=1;i<document.getElementById('counter').value;i++){
			if(document.getElementById('qtyIssued'+i)){
				if(parseInt(document.getElementById('qtyIssued'+i).value) > 0){
					issued = "yes";
					break;
				}else{
					issued = "no";
				}
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



	function checkForSubmit()
  {
	  if(document.getElementById('noOfRecords').value==0)
	  {
	  alert("There must be one detail row");
	  return false;
	  }
	  return true;
  }
	function fillSrNo(rowVal){
	var pageNo=parseInt(document.getElementById('noOfRecords').value);
   		rowVal=rowVal%10
   		if(rowVal==0){
   			rowVal=10
   	 		}
   		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	return true;

}



function confirm()
{
	formName="issueToDeptWithoutIndent";
	obj = eval('document.'+formName);
	if((document.getElementById('issuedBy').value != "") &&(document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != "")&&(document.getElementById('approvedBy').value != ""))
	{
    	obj.action = "/hms/hms/stores?method=searchInternalIndentDetails";
    	obj.submit();
    }
	else
	{
		alert("Pl. check the Input Values!.........")
		return false
	}
}


function goPage(){

if(<%=totalPages%>==0){
alert("There are no pages to navigate");
return false;
}
else{

submitForm('issueToDeptWithoutIndent','stores?method=addNextOrSubmitIssue&buttonName=goToPage');
}
}
function goNext(){
var toatlPages=<%=totalPages%>;
if(toatlPages==0){
alert("There are no pages to navigate");
return false;
}
else{

submitForm('issueToDeptWithoutIndent','stores?method=addNextOrSubmitIssue&buttonName=next');
}
}

function displayItemDetails(rowVal){

	var counter = document.getElementById('counter').value;
	var itemName=document.getElementById("itemName"+rowVal).value;
	for(var i=1;i<=(parseInt(counter));i++){
		if(document.getElementById("itemName"+i)!=null){
			if(document.getElementById("itemName"+i).value==itemName&&i!=rowVal){
				alert("Item is already Selected");
				document.getElementById("itemName"+rowVal).value="";
				return false;
			}
		}
	}
var code = "";
	if(itemName != ""){
		var index1 = itemName.lastIndexOf("[");
		    var index2 = itemName.lastIndexOf("]");
		    index1++;
		    var code = itemName.substring(index1,index2);

	}
  if(code!=""){
	ajaxFunctionForGetDetails('issueToDeptWithoutIndent','stores?method=getItemDetailsForIssue&requiredField='+encodeURIComponent(code)+'&<%=FROM_WARD%>='+<%=deptId%>+'', rowVal);

}
}

function ajaxFunctionForGetDetails(formName,action,rowVal)
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
        	document.getElementById('itemName'+rowVal).value = name.childNodes[0].nodeValue + "[" + pvms.childNodes[0].nodeValue + "]"
        	document.getElementById('itemCode'+rowVal).value =  pvms.childNodes[0].nodeValue ;
        	document.getElementById('itemId'+rowVal).value = id.childNodes[0].nodeValue ;
        	document.getElementById('stock'+rowVal).value = stock.childNodes[0].nodeValue ;
        	document.getElementById('au'+rowVal).value =  au.childNodes[0].nodeValue ;

      }
    }
  }
}


function addRow(){
	var tbl = document.getElementById('issueDetails');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('counter');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;

	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.className = 'small';
	e0.name='SRNo'+(iteration);
	e0.size ='2';
	e0.id='srNo'+iteration;
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=ITEM_CODE%>'+(iteration);
	e2.readOnly = true;
	e2.id = 'itemCode'+(iteration)
	e2.tabIndex="1";
	e2.size = '10';

	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name='<%=ITEM_ID%>'+(iteration);
	e21.id = 'itemId'+(iteration)
	cell1.appendChild(e2);
	cell1.appendChild(e21);

	var cell2 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = '<%=ITEM_NAME%>'+(iteration);
	e1.id = 'itemName' + (iteration);
	e1.size='45';
	e1.focus();
	e1.onblur = function(){displayItemDetails(iteration);}
	cell2.appendChild(e1);
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
	cell2.appendChild(newdiv);

	new Ajax.Autocompleter('itemName'+iteration,'ac2update'+iteration,'opBilling?method=getItemCodeForAutoComplete',{minChars:3,parameters:'requiredField=itemName'+ (iteration)+'&storeDepartmentId=<%=deptId%>'});

	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=AV%>'+(iteration);
	e3.id = 'au'+(iteration)
	e3.maxLength ='3';
	e3.readOnly = true;
	e3.size='8';
	cell3.appendChild(e3);

	
	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='barCodeNo'+(iteration);
	e4.id = 'barCodeNo'+(iteration)
	e4.maxLength ='30';
	e4.onblur=function(){getDataForBarcode(this.value,<%=inc %>);};
	//e4.readOnly = true;
	e4.size='8';
	cell4.appendChild(e4);
	//onblur="getDataForBarcode(this.value,<%=inc %>)"

	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='stockAvailable'+(iteration);
	e5.readOnly = true;
	e5.id='stock'+(iteration);
	e5.size = '15';
	cell5.appendChild(e5);

	var cell6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.type = 'text';
	e6.name='<%=QTY_IN_REQUEST%>'+(iteration);
	e6.id='qtyRequest'+(iteration);
	e6.size = '8';
	cell6.appendChild(e6);

	var cell7 = row.insertCell(7);
	var e7 = document.createElement('input');
	e7.type = 'text';
	e7.name='<%=QTY_ISSUED%>'+(iteration);
	e7.id='qtyIssued'+(iteration);
	e7.readOnly = true;
	e7.size = '10';
	cell7.appendChild(e7);

	var cell8 = row.insertCell(8);
	var e8 = document.createElement('input');
	e8.type = 'button';
	e8.name='Issue'+(iteration);
	e8.className = 'buttonIssue';
	e8.tabIndex="1";
	e8.onclick=function(){openPopupForItemIssue(this.value,document.getElementById('qtyRequest'+iteration).value,iteration,'','');};
	cell8.appendChild(e8);

	var cell9 = row.insertCell(9);
	var e9 = document.createElement('input');
	e9.type = 'hidden';
	e9.name='tt8'+(iteration);
	e9.id='issueQtyAndBatch'+(iteration);
	e9.size = '10';
	cell9.appendChild(e9);
	
	var cell10 = row.insertCell(10);
	var e10 = document.createElement('input');
	e10.type = 'hidden';
	e10.name='tt6'+(iteration);
	e10.id='quantityToIssueOverAll'+(iteration);
	e10.size = '10';
	cell10.appendChild(e10);

	var cell11 = row.insertCell(11);
	var e11 = document.createElement('input');
	e11.type = 'hidden';
	e11.name='batchId'+(iteration);
	e11.id='batchId'+(iteration);
	e11.size = '10';
	cell11.appendChild(e11);
	
}
function getDataForBarcode(val,rowVal){

	 if(val!=""){

	 submitProtoAjaxForBarcodeData('issueToDeptWithoutIndent','stores?method=getDataForBarcode&barcodeNo='+val+'',rowVal);


	 }

	 }
function removeRow()
{
	var tbl = document.getElementById('itemDetails');
	var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	var parentRowNo = 0;
	for(counter=0;counter<(tblRows.length-1);counter++)
	{
			if (document.getElementsByName('selectedItem')[counter].checked == true) {
				parentRowNo = document.getElementsByName('selectedItem')[counter].value;
				tbl.deleteRow(counter+1);
		  		calculateTotalAmt();
		  	}
	}
	var tblBat1 = document.getElementById('batchDetails');
	var rowcount = tblBat1.getElementsByTagName("tr").length;
	var checkedObjArray = new Array();
	var cCount = 0;
	for(var i=0;i<rowcount;i++){
			if(document.getElementsByName('parentRowNo')[i].value == parentRowNo){
				checkedObjArray[cCount] = tblBat1.tBodies[0].rows[i];
				cCount++;
			//	tblBat1.deleteRow(i);

		}
	}

	 if (checkedObjArray.length > 0) {
			var rIndex = checkedObjArray[0].sectionRowIndex;
			deleteRows(checkedObjArray);
		}

}
function deleteRows(rowObjArray)
{
		for (var i=0; i<rowObjArray.length; i++) {
			var rIndex = rowObjArray[i].sectionRowIndex;
			rowObjArray[i].parentNode.deleteRow(rIndex);
		}

}

function checkFields(){
	var err = "";
	if(document.getElementById('departmentIdTemp').value == ""){
		err += "Plese select To Department.\n";
	}
	/* if(document.getElementById('requestBy').value == ""){
		err += "Plese select Request By.\n";
	} */
	if(document.getElementById('requestDate').value == ""){
		err += "Plese enter Request Date.\n";
	}
	/* if(document.getElementById('approvedBy').value == ""){
		err += "Plese select Approved By.\n";
	}
	if(document.getElementById('issuedBy').value == ""){
		err += "Plese select Issued By.\n";
	} */

	if(err != ""){
		alert(err);
		return false;
	}else{
		return true;
	}

}
 
	</script>