<%--
		* Copyright 2008 JK Technosoft Ltd. All rights reserved.
		* Use is subject to license terms.
		* showWardList.jsp
		* Purpose of the JSP -  This is showing Ward List.
		* Revision Date:
		* Revision By:
		* @version 1.4
		--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
		var nameArray=new Array();
 		var brandArray=new Array();
 </script>
<script type="text/javascript">
		vBulletin_init();
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
int storeFyDocumentNoId=0;
		if(map.get("deptId") != null){
		deptId=(Integer)map.get("deptId");
		}

		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}

		if (map.get("issueNoOfWard") != null) {
		issueNoOfWard = (Integer) map.get("issueNoOfWard");
		}
		if (map.get("storeFyDocumentNoId") != null) {
			storeFyDocumentNoId = (Integer) map.get("storeFyDocumentNoId");
			}
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		}

 		%>
		<script type="text/javascript" language="javascript">
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
<h2><%=deptName %> Consumption</h2>
</div>
<div class="clear"></div>
<form name="wardConsumption" method="post" action="">
<div class="clear"></div>
<div class="Block">
 <%
		if(map.get("deptId")== null){
		MasDepartment masDepartment= (MasDepartment)deptList.get(0);
		deptId=masDepartment.getId();
		}
		%>
<label>Current Date</label>
<input type="text" name="date" value="<%=date %>" readonly="readonly" class="date" validate="Current Date,date,no"/>
<!--<label class="value"><%=date %></label>-->
<input type="hidden" name="deptName" id="deptName" value="<%=deptName %>" validate="deptName,metachar,no" />
<input type="hidden" name="wardIssueNo" id="wardIssueNo" value="<%=issueNoOfWard %>" />
<input type="hidden" name="storeFyDocumentNoId" id="storeFyDocumentNoId" value="<%=storeFyDocumentNoId %>" />

<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" validate="deptId,int,no"/>
<input type="hidden" name="date" id="date" value="<%=date %>" validate="Current Date,date,no"/>
<input type="hidden" name="time" id="time" value="<%=timeInHHmm %>" validate="time,metachar,no"/>
<label>Time</label>
<input type="text" name="time" value="<%=time %>" readonly="readonly"/>
<%-- <!--<label class="value"><%=timeInHHmm %></label>--> --%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<h4><%=deptName %> Consumption Details</h4>
<div style="float: right;">
<input type="button" name="delete" value="" class="buttonAdd" onclick="addRow();" />
<input name="Button" type="button" class="buttonDel" value="" onclick="removeRow();" />
</div>
<div class="division"></div>
<div class="tableHolderAuto">
<table border="0" cellspacing="0" cellpadding="0" id="chargeDetails" class="cmntable">
	<tr>
		<th></th>
 		<th>Item Name</th>
		<th>Batch No.</th>
		<th>Expiry Date &nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp; Closing Stock</th>
		<th>Consumed Quantity</th>
	</tr>
<% 
int inc = 0;
inc= inc+1;
%>
<input type="hidden" name="counter" id="counter" value=<%=inc%> validate="counter,int,no" />
	<tr>
		<td><input id="demo_box_<%=inc%>"  class="css-checkbox" type="checkbox" value="<%=inc%>" name="selectedChrage" class="radioCheck"/>
		<label for="demo_box_<%=inc %>" name="demo_lbl_<%=inc %>" class="css-label"></label></td>
  		<td>
  		
		<input type="text" id="nomenclature<%=inc%>"  name="nomenclature<%=inc%>" size="50"  onblur="populateItem(this.value,'<%=inc %>')" />
		
		<div id="ac2update" style="display: none;" class="autocomplete"></div>
		
		<script type="text/javascript" language="javascript" charset="utf-8">

			new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','ipd?method=getItemListForWardConsume',{minChars:1,parameters:'requiredField=nomenclature<%=inc%>'});
 		</script>
 	
 		</td>
 		<td id="testDiv<%=inc%>">
 		
 		<select id="batchNo<%=inc%>" name="batchNo<%=inc%>" onchange="populateClosingStock(this.value,'<%=inc %>')">
 		<option value="0">Select Batch No</option>
 		</select></td>
 		
 		
    	<td id="stockDiv<%=inc%>">
    	<input type="text" value="" id="expDate<%=inc%>" name="expDate<%=inc%>" size="20"/>
    	<input type="text" value=""	name="closeStock<%=inc%>" id="closeStock<%=inc%>" size="20"/></td>
    	

    	
    	
	   <td width="10%">
	   <input type="text" value="" id="compQuantity<%=inc%>" name="compQuantity<%=inc%>" size="20" validate="Com Quantity,int,no"/>
	   
	   <input type="hidden" value="" id="ItemId<%=inc%>" name="ItemId<%=inc%>" size="20"/>
	   
	   
	    </td>
  	</tr>
</table>
</div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <!-- showWardConsumptionJsp  old showWardList-->
 
<input type="button" class="button" value="Submit" onclick="if(validate(<%=inc%>) && checkTestRow()){submitForm('wardConsumption','ipd?method=submitWardConsDetails');}"align="right" />
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('wardConsumption','ipd?method=showPatientListNurseJsp');"/>


<input type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords"  />
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
		var hdb = document.getElementById('counter');
		var iteration = parseInt(hdb.value)+1;
		hdb.value = iteration;

		var cell0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'checkbox';
		e0.name='selectedChrage';
		e0.className = 'radioCheck css-checkbox';
		e0.value=(iteration);
		e0.id="demo_box_"+iteration;
		cell0.appendChild(e0);
		
		var e01 = document.createElement('label');
		e01.name='demo_lbl_'+iteration;
		e01.className = 'css-label';
		e01.setAttribute('for','demo_box_'+iteration);
		cell0.appendChild(e01);

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
		e1.size='50';

		var newdiv = document.createElement('div');
	   	newdiv.setAttribute('id','ac2update');
	 	newdiv.style.display = 'none';
	   	newdiv.className = 'autocomplete';
	   	cell1.appendChild(e1);
	   	cell1.appendChild(newdiv);
	    new Ajax.Autocompleter('nomenclature'+iteration,'ac2update','ipd?method=getItemListForWardConsume',{minChars:3,parameters:'requiredField=nomenclature'+iteration+'&counter='+iteration});

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

	}

	function removeRow()
	{
		var tbl = document.getElementById('chargeDetails');
		 var tblRows  = tbl.getElementsByTagName("tr");

	  	if(tblRows.length-2==0){
		  		alert("Can not delete all rows");
	         	return false;
	     }

		for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
		{
			if (document.getElementsByName('selectedChrage')[counter].checked == true)
			{
			  	tbl.deleteRow(counter+1);
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
					//var e=eval(document.getElementById('nomenclature'+incr));
					//e.focus();
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
    {        	 alert('Comp. Quantity should not be greater than closing Stock !!!');
      //document.getElementById('compQuantity'+inc).focus();
      return false;
    }
	return true;

}
function checkTestRow(){
	var msg ="";
	var count = document.getElementById('counter').value;
	  	for(var i=1;i<=count;i++){

	  	 	if(document.getElementById('nomenclature'+i) != null){
	  	 		if(document.getElementById('nomenclature'+i).value != ""){
		  			if(document.getElementById('batchNo'+i).value == 0){
		  				msg += "Batch No can not be blank.\n";
		  			}
		  			if(msg != ""){
		  				break;
		  			}
	  			}
	  			else{
		  				alert("Please fill atleast one charge to submit.");
	  				return false;
	  			}
	  		}
	  	}
	  	if(msg != ""){
		  		alert(msg);
	  		return false;
	  	}else{
	  		return true;
	  	}
	}

</script>