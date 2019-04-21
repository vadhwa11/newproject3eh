<%--
		* Copyright 2008 JK Technosoft Ltd. All rights reserved.
		* Use is subject to license terms.
		* showWardList.jsp
		* Purpose of the JSP -  This is showing Ward List.
		* @author  Ramdular
		* Create Date: 20th Dec,2010
		* Revision Date:
		* Revision By:
		* @version 1.4
		--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.StoreIssueM"%>


<script lang="javascript" type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script lang="javascript" type="text/javascript" src="/hms/jsp/js/proto.js"></script>
<script lang="javascript" type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script lang="javascript" type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script lang="javascript" type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script lang="javascript" type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
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
<%
 		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		String timeInHHmm="";
		String [] temp = null;
		temp = time.split(":");
		for (int i = 0 ; i < temp.length-1 ; i++) {
		timeInHHmm=timeInHHmm+(String)temp[i];
		if(i==0)
		{
		timeInHHmm=timeInHHmm+":";
		}
		}
		List deptList = new ArrayList();
 		deptList=(List)map.get("deptList");
 		String deptName="";
		int issueNoOfWard=0;
		String userName = "";
		int deptId=0;
		

		if(map.get("deptId") != null){
		deptId=(Integer)map.get("deptId");
		}

		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}

		if (map.get("issueNoOfWard") != null) {
		issueNoOfWard = (Integer) map.get("issueNoOfWard");
		}
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		}
		List<StoreIpIssueM>issueMList=new ArrayList<StoreIpIssueM>();
		if(map.get("issueMList")!=null){
			issueMList=(List<StoreIpIssueM>)map.get("issueMList");
		}
 		%>
		<script type="text/javascript" lang="javascript">
		<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
		month="0"+month;
		}
		if(getDate.length()<2){
		getDate="0"+getDate;
		}

		%>
		serverdate = '<%=getDate+"/"+month+"/"+year%>'
		</script>

<div class="titleBg">
<h2><%--<%=deptName --%>Store Consumption</h2>
</div>
<div class="clear"></div>
<%-- 
<form name="searchPanel" method="post">
<div class="clear"></div>
<%--<label>From Date </label>
<input type="text" name="<%= FROM_DATE %>"	value="<%= date %>" class="date" maxlength="30" tabindex=1 />
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=date%>',document.createGrn.<%= FROM_DATE%>,event);" />
<label>To Date </label>
<input type="text" name="<%= TO_DATE %>" value="<%= date %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=date%>',document.createGrn.<%= TO_DATE%>,true);" />

 <div class="clear"></div>
<label>Consumption No.</label>
<select name="IpIssueMId">
<option value="0">Select</option>
<%for(StoreIpIssueM issue:issueMList){ %>
<option value="<%=issue.getId() %>"><%=""+issue.getId()+" "+issue.getIpIssueDate() %></option>
<%} %>
</select>
<input name="button"  type="button" value="search"	class="button"	onclick="submitForm('searchPanel','stores?method=generateConsumptionReport');" />
</form>
--%>
<div class="clear"></div>


<form name="wardConsumption" method="post" action="">
<div class="clear"></div>
<%-- 
<div class="Block">
 <%
		if(map.get("deptId")== null){
		MasDepartment masDepartment= (MasDepartment)deptList.get(0);
		deptId=masDepartment.getId();
		}
		%>
<label>Current Date</label>
<label class="value"><%=date %></label>
<input	type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" />
<input type="hidden" name="date" id="date" value="<%=date %>" />
<input type="hidden" name="time" id="time" value="<%=timeInHHmm %>" />
<label>Time(HH:mm)</label>
<label class="value"><%=timeInHHmm %></label>
<div class="clear"></div>
</div>--%>
<div class="clear"></div>

<div class="Block">
<label>Consupmtion No.</label>
 <input type="text" name="consumptionNo"  value="<%=issueNoOfWard %>" readonly="readonly" MAXLENGTH="8" class="readOnly" />
 
</div>
<input type="button" name="delete" value="" class="buttonDel" onclick=" removeRow();" />
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" />
<div class="division"></div>
<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0" id="chargeDetails">
	<tr>
		<th scope="col"></th>
 		<th scope="col">Item Name</th>
		<th scope="col">Batch No.</th>
		<th scope="col">Exp. Date         |         C. Stock</th>
		<th scope="col">Com.Quantity</th>
		<th scope="col">Reason</th>
		<th scope="col">Remarks</th>
	</tr>
	<%
		int inc = 1;
	%>
	<tr>
		<td><input type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioCheck" /></td>
  		<td width="20%"><input type="text" id="nomenclature<%=inc%>"  name="nomenclature<%=inc%>" size="40"  onblur="populateItem(this.value,'<%=inc %>')" />
			<div id="ac2update" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" lang="javascript" charset="utf-8">
			new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','ipd?method=getItemListForWardConsume',{minChars:1,parameters:'requiredField=nomenclature<%=inc%>&counter=<%=inc%>'});
 			</script>
 		</td>
 		<td width="10%" id="testDiv<%=inc%>"><select id="batchNo<%=inc%>" name="batchNo<%=inc%>" onchange="populateClosingStock(this.value,'<%=inc %>')">
 		<option value="0">Select Batch No</option>
 		</select></td>
    	<td width="10%" id="stockDiv<%=inc%>"><input type="text" value="" id="expDate<%=inc%>" name="expDate<%=inc%>" size="20"/>
    	<input type="text" value=""	name="closeStock<%=inc%>" id="closeStock<%=inc%>" size="20"/></td>
	   <td width="10%"><input type="text" value="" id="compQuantity<%=inc%>" name="compQuantity<%=inc%>" size="20"/>
	   <input type="hidden" value="" id="ItemId<%=inc%>" name="ItemId<%=inc%>" size="20" validate="ItemId,int,no"/>
	    <td width="10%"><input type="text" value="" id="reason<%=inc%>" name="reason<%=inc%>" size="20" validate="reason,metachar,no"/>
	     <td width="10%"><input type="text" value="" id="remark<%=inc%>" name="remark<%=inc%>" size="20" validate="remarks,remarks,no"/>
	    </td>
  	</tr>
</table>
</div>
<input type="hidden" value="<%=inc%>" name="hiddenValueCharge"	id="hiddenValueCharge" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <!-- showWardConsumptionJsp  old showWardList-->
<input type="button" class="button" value="Submit"
	onclick="if(validate(<%=inc%>)){submitForm('wardConsumption','ipd?method=submitWardConsumptionDetails');}"
	align="right" /> <input type="button" class="button" value="Back"
	align="left" onclick="submitForm('wardConsumption','ipd?method=showPatientListJsp');" />
<input type="hidden" size="2" value="" name="noOfRecords" validate="noOfRecords,int,no"
	id="noOfRecords" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script type="text/javascript">
		function fillSrNo(rowVal){
 		var pageNo=parseInt(document.getElementById('noOfRecords').value);
		rowVal=rowVal%8
		if(rowVal==0){
		rowVal=8
		}
		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
		document.getElementById('noOfRecords').value=rowVal
		}
		return true;
		}
		function checkForBrandWardConsumption(val,inc,deptId,deptName){

		if(val != "")
		{
		var pageNo =parseInt(document.getElementById('pageNo').value)
		var start=((pageNo-1)*8)+1;
		var end=((pageNo-1)*8)+8;

		var index1 = val.lastIndexOf("[");
		var indexForBrandName=index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var itemId = val.substring(index1,index2);
		var indexForBrandName=indexForBrandName--;
		var brandName=val.substring(0,indexForBrandName);
		if(brandName =="")
		{

		return;
		}
		for(i=1;i<inc;i++){

		if(inc != 1){
		if(document.getElementById('brandName'+i).value==val)
		{
		alert("Item already selected...!")
		document.getElementById('brandName'+inc).value=""
		var e=eval(document.getElementById('brandName'+inc));
		e.focus();
		return false;
		}
		}
		}
		ajaxFunctionForAutoCompleteWardConsumption('wardConsumption','ipd?method=fillItemsInGrid&brandName=' +  brandName , inc);
		}
		}
 		function openPopup(brandId,deptId,rowVal,deptName){
		var url="/hms/hms/ipd?method=showStockDetailsJsp&brandId="+brandId+"&deptId="+deptId+"&rowVal="+rowVal+"&deptName="+deptName;
		popwindow(url);
		}
		function popwindow(url)
		{
		newwindow=window.open(url,'name',"height=400,width=700,status=1");
		}

		function openPopupForDelete(ipIssueNo){
		var url="/hms/hms/ipd?method=modifyWardConsumptionJsp&ipIssueNo="+ipIssueNo;
		popwindowForDelete(url);
		}
		function openPopupForViewStock(){
		var issueNo=document.getElementById("issueNo").value;
 		var url="/hms/hms/ipd?method=viewStockDetailsJsp&issueNo="+issueNo;
		popwindowForDelete(url);
		}
		function popwindowForDelete(url)
		{
		// newwindow=window.open(url,'name',"height=500,width=700,status=1, scrollbars=yes ");
		newwindow=window.open(url,'name','status=yes,resizable,scrollbars=1,height=400,width=980,');
		}

	function addRow()
	{
		var tbl = document.getElementById('chargeDetails');
		var lastRow = tbl.rows.length;

		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hiddenValueCharge');
		var iteration = parseInt(hdb.value)+1;
		hdb.value = iteration;

		var cell0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'checkbox';
		e0.name='selectedChrage';
		e0.className = 'radioCheck';
		e0.value=(iteration);
		cell0.appendChild(e0);

  		var cell1 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.onblur = function()
					{
						populateItem(this.value,iteration);
				  	};
		e1.name = 'nomenclature'+iteration;
		e1.id = 'nomenclature'+iteration;
		e1.tabIndex="1";
		e1.size='40';

		var newdiv = document.createElement('div');
	   	newdiv.setAttribute('id','ac2update');
	 	newdiv.style.display = 'none';
	   	newdiv.className = 'autocomplete';
	   	cell1.appendChild(e1);
	   	cell1.appendChild(newdiv);
	    new Ajax.Autocompleter('nomenclature'+iteration,'ac2update','ipd?method=getItemListForWardConsume',{minChars:1,parameters:'requiredField=nomenclature'+iteration+'&counter='+iteration});

 		 var cellRight2 = row.insertCell(2);
		 cellRight2.id='testDiv'+iteration;
		 var e2 = document.createElement('Select');
		 e2.name='batchNo'+iteration;
		 e2.id='batchNo'+iteration;
		 e2.onchange =function(){
			      populateClosingStock(this.value,iteration);
				};
 		 e2.options[0] = new Option('Select Batch No', '0');
		 for(var i = 0;i<brandArray.length;i++ ){
		    e2.options[brandArray[i][0]] = new Option(brandArray[i][1],brandArray[i][0]);
		    }
		 cellRight2.appendChild(e2);

		var cell3 = row.insertCell(3);
		cell3.id='stockDiv'+iteration;
 		var e3 = document.createElement('input');
		e3.type = 'text';
		e3.id='expDate'+iteration;
		e3.name='expDate'+iteration;
		e3.readOnly = true;
		e3.size='20';
		cell3.appendChild(e3);
		
		
		//var cell4 = row.insertCell(4);
	 	var e4 = document.createElement('input');
		e4.type = 'text';
		e4.id='closeStock'+iteration;
		e4.name='closeStock'+iteration;
		e4.readOnly = true;
		e4.size='20';
	 	cell3.appendChild(e4);


		var cell4 = row.insertCell(4);
		var e5 = document.createElement('input');
		e5.type = 'text';
		e5.id='compQuantity'+iteration;
		e5.name='compQuantity'+iteration;
	 	e5.size='20';
	 	cell4.appendChild(e5);

		var e6 = document.createElement('input');
		e6.type = 'hidden';
		e6.id = 'ItemId'+iteration;
		e6.name = 'ItemId'+iteration;
		e6.readOnly = true;
		e6.size='5';
 		cell4.appendChild(e6);
 		
 		var cell5 = row.insertCell(5);
		var e7 = document.createElement('input');
		e7.type = 'text';
		e7.id='reason'+iteration;
		e7.name='reason'+iteration;
	 	e7.size='20';
	 	cell5.appendChild(e7);
	 	
	 	var cell6 = row.insertCell(6);
		var e8= document.createElement('input');
		e8.type = 'text';
		e8.id='remark'+iteration;
		e8.name='remark'+iteration;
	 	e8.size='20';
	 	cell6.appendChild(e8);

	}

	function removeRow()
	{
		
		var tbl = document.getElementById('chargeDetails');
		 var tblRows  = tbl.getElementsByTagName("tr");
		
	  	if(tblRows.length-2==0){
	         	alert("Can not delete all rows")
	         	return false;
	     }
		         
	  	for(abc=0;abc<document.getElementsByName('selectedChrage').length;abc++)
		{
			if (document.getElementsByName('selectedChrage')[abc].checked == true)
			{
			  	tbl.deleteRow(abc+1);
			}
		}
	}

function populateItem(val,incr){
       var pvmsNo;
		if(val !=""){
			var index1 = val.lastIndexOf("[");
			var index2 = val.lastIndexOf("]");
			index1++;
			
			ItemId = val.substring(index1,index2);
     		document.getElementById('ItemId'+incr).value=ItemId;
     		if(ItemId != ""){
		for(i=1;i<incr;i++)
		{
 			if(incr != 1)
			{
				if(val!=""){
				if(document.getElementById('nomenclature'+i).value == val)
				{
					alert("Item Name already selected...!");
					document.getElementById('nomenclature'+incr).value="";
					document.getElementById('ItemId'+incr).value="";
					document.getElementById('batchNo'+incr).value="";
					var e=eval(document.getElementById('nomenclature'+incr));
					e.focus();
				}
				}else{
					return false;
				}

			}
	  	}
		submitProtoAjaxForLionClass('wardConsumption','/hms/hms/ipd?method=getItemStock&ItemId='+ItemId+"&counter="+incr,incr);
    }
  }
}
function submitProtoAjaxForLionClass(formName,action,incr){

	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)

        	new Ajax.Updater('testDiv'+incr,url,
			   {asynchronous:true, evalScripts:true });

    	   //	document.getElementById('brandId'+incr).style.display='none';
			return true;
    	}
function populateClosingStock(val,count){

		var ItemId = document.getElementById('ItemId'+count).value;
  		submitProtoAjaxForClosingStock('wardConsumption','/hms/hms/ipd?method=getItemClosingStock&batchNo='+val+'&counter='+count+'&ItemId='+ItemId,count);
//		submitProtoAjaxForNomenClature('opdMain','/hms/hms/opd?method=getNomenclature&brandId='+val+'&counter='+count,count);
//}
}
function submitProtoAjaxForClosingStock(formName,action,counter){

	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;

    	   	 var url=action+"&"+getNameAndData(formName)
			new Ajax.Updater('stockDiv'+counter,url,
			   {asynchronous:true, evalScripts:true });
    	 	//document.getElementById('manufacturer'+counter1).style.display='none';
    	   	return true;
    	}

function validate(inc)
{
 	closeStock  = parseFloat(document.getElementById('closeStock'+inc).value);
    compQuantity = parseFloat(document.getElementById('compQuantity'+inc).value);
    if(closeStock<compQuantity)
    {
      alert('Comp. Quantity should not be greater than closing Stock !!!');
      document.getElementById('compQuantity'+inc).focus();
      return false;
    }
	return true;

}
</script>