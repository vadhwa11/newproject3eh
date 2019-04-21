<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.MmSafetyProcedureMaterials"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.PrqQuotationItemDetails"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.PrqQuotationVendorDetails"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.PrqQuotationItemDetails"%>
<%@page import="jkt.hms.masters.business.PrqQuotationVendorDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>


<head>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"    id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calendar.js"></script> 
<%--For AutoComplete Through Ajax--%>
</head>
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

	function validate(){
    var flag=false;
    var count=parseInt(document.getElementById("itemCount").value);
        for(var i=1;i<=count;i++){
        	if(document.getElementById("itemCheckBox"+i)!=null){
            if(document.getElementById("itemCheckBox"+i).checked==true){
                flag=true;
            }
        	}
        }
    if(flag){
        return true;
    }else{
        alert("Select Atleast one item for PO");
        return false;
    }
    
}

function checkData(){
var start= new Date(document.getElementById("podateId").value.split("/")[2], document.getElementById("podateId").value.split("/")[1], document.getElementById("podateId").value.split("/")[0]);
 var end= new Date(document.getElementById("deliverydateId").value.split("/")[2], document.getElementById("deliverydateId").value.split("/")[1], document.getElementById("deliverydateId").value.split("/")[0]);
 if(start<=end){
     return true;
 }else{alert("Delivery Date is Not Less Than PoCreation.");return false;}
}


</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MasStoreSupplier> storeSuppliers=new ArrayList<MasStoreSupplier>();
	List<MasHospital> hospital=new ArrayList<MasHospital>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	System.out.println(""+map.size());
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	if(map.get("masStoreSuppliers")!=null){
		storeSuppliers=(List<MasStoreSupplier>)map.get("masStoreSuppliers");
	}
	
	if(map.get("hospitals")!=null){
		hospital=(List<MasHospital>)map.get("hospitals");
	}
	%>

<div class="titleBg">
<h2>Direct PO Creation</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->
<form name="directpoCreate" method="post">
<div class="Block">

<div class="clear"></div>
<label>PO/WO Creation Date</label>
<input type="text" name="poCreationDate" id="podateId"	value="<%= currentDate %>"  maxlength="30" tabindex=1 />
<label>Vendor Name </label>
<select name="vendorName" validate="Vendor,String,yes" id="vendorName">
<option value="">Select</option>
<%for(MasStoreSupplier storeSupplier:storeSuppliers){ %>
	 <option value="<%=storeSupplier.getId()%>"><%=storeSupplier.getSupplierName()%></option>
	 <%}
	  %>
</select>
 
<label>Delivery Date </label>
<input type="text" name="deliveryDate" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 id="deliverydateId"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.directpoCreate.deliveryDate,true);" />

<div class="clear"></div>

<label>Delivery To</label>
<select name="deliveryTo" validate="deliveryTo,String,yes" id="deliveryTo">
<option value="">Select</option>
<%for(MasHospital emp:hospital){ %>
	 <option value="<%=emp.getId()%>"><%=emp.getHospitalName()%></option>
	 <%}
	  %>
</select>
<label>Delivery Instruction</label>
<input type="text" name="deliveryInstruction"  id= "deliveryInstruction" value=""  maxlength="30" tabindex=1 />
<label>Delivery Address</label>
<input type="text" name="deliveryAddress"  id= "deliveryAddress" value=""  maxlength="30" tabindex=1 validate="Delivery Address,String,yes" />

</div>
<div class="clear"></div>
<h4>Item Details</h4>
<input type="button" name="delete" value="" class="buttonDel" onclick=" removeRow();" />
<input name="Button" type="button" class="buttonAdd" value="" onclick="addRow();" />
<div class="cmntable">
<table width="auto"  id="itemDetails" border="0"  	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th scope="col"></th>
			<th width="10%">Item Name</th>
			<th width="13%">Item Code</th>
			<th width="10%">Unit</th>
			<th width="20%">Qty</th>
			<th width="20%">Rate</th>
			<th width="10%">Amount</th>
			<th width="10%">Discount%</th>
			<th width="10%">Net Amount</th>
			<th width="10%">Tax%</th>
			<th width="10%">Total Amount</th>
		</tr>
		<% int i=1;
		String itemName="itemName";
		%>
	</thead>
	<tbody>
	     
		<tr>
		<td><input type="checkbox" value="<%=i%>" name="selectedChrage" class="radioCheck" /></td>
			<td width="5%"> <input type="text" name="itemName<%=i%>" id="itemName<%=i%>" value="" size="50" validate="ItemName,String,yes"
			 onblur="checkForIndentToDepot(this.value, '<%="nameItem"+i%>','<%=i%>');"/>
			<div id="ac2update" class="autocomplete" style="display: none;"></div>
							<script type="text/javascript" language="javascript" charset="utf-10">
							function eventCallback(element, entry){
								
											return entry + "&vendorId=" + document.getElementById('vendorName').value; 
									}
								new Ajax.Autocompleter('itemName<%=i%>','ac2update','procurement?method=getItemList',{minChars:1,parameters:'requiredField=itemName<%=i%>', callback: eventCallback});
								</script></td> 
			 <td width="5%"><input type="text" name="itemCode<%=i%>"  id="codeItem<%=i%>" value=""  readonly="readonly" size="20"/></td>
			<td width="5%"><input type="text" name="unitName<%=i%>" id="idAu<%=i%>" value=""  readonly="readonly"/></td>
			<td width="5%"><input type="text" name="qty<%=i%>" id="qty<%=i%>"value=""  /></td>
			<td width="5%"><input type="text" name="rate<%=i%>" id="rate<%=i%>" value="" onblur="totAm(<%=i%>);" /></td>
			<td width="5%"><input type="text" name="amount<%=i%>" id="amount<%=i%>" value=""  /></td>
			<td width="5%"><input type="text" name="discount<%=i%>" id="discount<%=i%>" value="" onblur="totAm(<%=i%>);" /></td>
			<td width="5%"><input type="text" name="netAmt<%=i%>" id="netAmt<%=i%>" value=""  readonly="readonly" /></td>
			<td width="5%"><input type="text" name="tax<%=i%>" id="tax<%=i%>" value="" onblur="totAm(<%=i%>);"/></td>
			<td width="5%"><input type="text" name="totAmt<%=i%>" value=""  id="totAmt<%=i%>" readonly="readonly"/></td>
			<input type="hidden" id="idItem1" name="itemId<%=i%>" class="smcaption" >
			
		</tr>

			 
			<%
		i++;
				%>
		
	</tbody>
</table>
</div>
<input type="hidden" name="itemCount" id="itemCount" value="<%=i-1%>"/>

<div class="clear"></div><div class="clear"></div>
<div class="clear"></div><div class="clear"></div>

<input name="button"  type="button"	value="Submit" class="button"	onclick="if(checkData()){submitForm('directpoCreate','procurement?method=submitPoCreationDirect')}"/>
<input name="button"  type="reset"	value="Reset" class="button" />

<div class="clear"></div>
<div id="pagination">
Page <span class="selected">1</span>
</div>
<script>

function addRow()
{
	var tbl = document.getElementById('itemDetails');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('itemCount');
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
	var e = document.createElement('input');
	e.type = 'text';
	e.onblur= function()
				{
				checkForIndentToDepot(this.value, 'itemName'+iteration,iteration);
			  	}; 
	e.name = 'itemName'+iteration; 
	e.id = 'itemName'+iteration;
	e.tabIndex='1';
	e.size='50';

	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id','ac2update');
 	newdiv.style.display = 'none';
   	newdiv.className = 'autocomplete';
   	cell1.appendChild(e);
   	cell1.appendChild(newdiv);
   	
   	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.id = 'idItem'+iteration;
	e1.name = 'itemId'+iteration;
	e1.readOnly = true;
	e1.size='5';
	cell1.appendChild(e1);
    new Ajax.Autocompleter('itemName'+iteration,'ac2update','procurement?method=getItemList',{minChars:1,parameters:'requiredField=itemName'+iteration+'&counter='+iteration, callback: eventCallback});

    var cellRight2 = row.insertCell(2);
	// cellRight2.id='testDiv'+iteration;
	 var e2 = document.createElement('input');
	 e2.name='itemCode'+iteration;
	 e2.id='codeItem'+iteration;
	 e2.size='20'
	
	 cellRight2.appendChild(e2);

	var cell3 = row.insertCell(3);
	//cell3.id='stockDiv'+iteration;
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.id='idAu'+iteration;
	e3.name='unitName'+iteration;
	e3.readOnly = true;
	e3.size='20';
	cell3.appendChild(e3);
	
	
	var cell4 = row.insertCell(4);
 	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.id='qty'+iteration;
	e4.name='qty'+iteration;
	e4.size='20';
	e4.onblur = function()
	{
		totAm(iteration);
  	};
 	cell4.appendChild(e4);

 	
  	

	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.id='rate'+iteration;
	e5.name='rate'+iteration;
 	e5.size='20';
 	e5.onblur = function()
	{
		totAm(iteration);
  	};
 	cell5.appendChild(e5);

	
		
	var cell6 = row.insertCell(6);
	var e7 = document.createElement('input');
	e7.type = 'text';
	e7.id='amount'+iteration;
	e7.name='amount'+iteration;
	e7.readOnly = true;
 	e7.size='20';
 	cell6.appendChild(e7);
 	
 	var cell7 = row.insertCell(7);
	var e8= document.createElement('input');
	e8.type = 'text';
	e8.id='discount'+iteration;
	e8.name='discount'+iteration;
 	e8.size='20';
 	e8.onblur = function()
	{
		totAm(iteration);
  	};
 	cell7.appendChild(e8);
 	
 	var cell8 = row.insertCell(8);
	var e9= document.createElement('input');
	e9.type = 'text';
	e9.id='netAmt'+iteration;
	e9.name='netAmt'+iteration;
	e9.readOnly = true;
 	e9.size='20';
 	cell8.appendChild(e9);
 	
 	var cell9 = row.insertCell(9);
	var e10= document.createElement('input');
	e10.type = 'text';
	e10.id='tax'+iteration;
	e10.name='tax'+iteration;
 	e10.size='20';
 	e10.onblur = function()
	{
		totAm(iteration);
  	};
 	cell9.appendChild(e10);
 	
	var cell10 = row.insertCell(10);
	var e10= document.createElement('input');
	e10.type = 'text';
	e10.id='totAmt'+iteration;
	e10.name='totAmt'+iteration;
	e10.readOnly = true;
 	e10.size='20';
 	cell10.appendChild(e10);


}

function removeRow()
{
	
	var tbl = document.getElementById('itemDetails');
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
function totAm(count){
	 var rate=0;
	 var tax=0;
	 var vat=0;
	 var totalAmmount=0;
	 var qty=0;
	 var ammount=0;
	 var dicount=0;
	 var netAmount=0;
	  if(isNaN(document.getElementById("qty"+count).value))
	  {
	  alert('This is not valid Quantity');
	  return;
	  }
	  quotationQty=document.getElementById('qty'+count).value;
	  if(isNaN(document.getElementById("rate"+count).value))
		  {
		  alert('Please Enter valid Rate');
		  return;
		  }
	  
		rate=document.getElementById('rate'+count).value;
		ammount = eval(Number(eval(Number(quotationQty))* (eval(Number(rate)))));
		ammount = parseFloat(ammount).toFixed(2);
		document.getElementById('amount'+count).value = ammount;
	
	
	if(isNaN(document.getElementById("discount"+count).value))
	  {
	  alert('Please Enter valid Discount');
	  return;
	  }
	
   
    if(document.getElementById("discount"+count).value!=null && document.getElementById("discount"+count).value!=""){
   	 dicount=parseInt(document.getElementById("discount"+count).value);
	}
   
    document.getElementById("netAmt"+count).value=ammount-((ammount*dicount)/100);
    netAmount=ammount-((ammount*dicount)/100);
    netAmount = parseFloat(netAmount).toFixed(2);
    //alert(netAmount);
   
    

 tax = document.getElementById('tax'+count).value;
 
 if(tax != null)
 {
 	var taxnetAmount = (netAmount*tax)/100;
 	// alert(taxnetAmount);
 	totalAmmount =parseFloat(netAmount)+parseFloat(taxnetAmount);
 	totalAmmount = parseFloat(totalAmmount).toFixed(2);
 }
 totalAmmount = parseFloat(totalAmmount).toFixed(2);
 	document.getElementById('totAmt'+count).value = totalAmmount;
 	
 	}
function fillSrNo(rowVal){

	/* var pageNo=parseInt(document.getElementById('noOfRows').value);
   		rowVal=rowVal%8
   		if(rowVal==0){
   			rowVal=8
   	 		}
   		if(!(parseInt(document.getElementById('noOfRows').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRows').value=rowVal
			} */
	return true;
}
function checkForIndentToDepot(val,a,inc){
	var pageNo =parseInt(1)
	var start=((pageNo-1)*8)+1;
	var end=((pageNo-1)*8)+8;

    var index1 = val.lastIndexOf("[");
    var index2 = val.lastIndexOf("]");
    index1++;
    var pvms = val.substring(index1,index2);
  //  alert(pvms);
   // for(i=1;i<=8;i++){
    //if(pvms !="")
    //if(document.getElementById('codeItem'+i).value==pvms){
    //if(document.getElementById('codeItem'+inc).value!=pvms){
    	//alert("Item already selected...!")
    	//document.getElementById('nameItem'+inc).value=""

    	//return false;
    	//}
    //}}
    if(pvms !=""){
    	//alert();
		ajaxFunctionForAutoAA('departmentIndent','stores?method=fillItemsForIndentToSOC&pvmsNo=' +  encodeURIComponent(pvms) , inc);
		}else{
			//document.getElementById("nameItem"+inc).value = "";
			//document.getElementById("mrp"+inc).value = "";
			//document.getElementById("dispensingPrice"+inc).value = "";
			//document.getElementById("batchNoVarTemp"+inc).value = "";
			//document.getElementById("expDateVarTemp"+inc).value = "";
			//document.getElementById("qtyVarTemp"+inc).value = "";
			//document.getElementById("unitRateVarTemp"+inc).value = "";
			document.getElementById("codeItem"+inc).value = "";
			//document.getElementById("manuId"+inc).value = "";
			document.getElementById("idAu"+inc).value = "";
			//document.getElementById("noOfRows").value = parseInt(document.getElementById("noOfRows").value)-1;

		}
}
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>