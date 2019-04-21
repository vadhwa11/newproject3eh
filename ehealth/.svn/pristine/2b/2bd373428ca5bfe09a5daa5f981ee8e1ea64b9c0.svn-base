<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<%
int inPatientId=0;
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
	}
if (map.get("inPatientId") != null) {
	inPatientId = (Integer) map.get("inPatientId");
	}
%>
<script type="text/javascript">
var inPatientId='<%=inPatientId%>';
</script>

<%int itemCount=1; %>

<div class="clear"></div>
<div style="float: right;">
	<input type="button" class="button" value="Add" align="right" onclick="javascript:addRowExtraDiet();">
	<input type="button" name="Reset" value="Delete" class="button" align="right" onclick="javascript:removeRowExtraDiet();">
		</div>
		<div class="clear"></div>
		
<table id="extradietTable">
		<tr>
		<th>&nbsp;</th>
			<th>Item</th>
			<th>Qty</th>
			<th>Remarks</th> 
		</tr>
	<tr>
		<td><input type="checkbox" name="checkbox<%=itemCount%>" id="checkbox<%=itemCount%>" class="radioCheck" /> </td>
	
	<td>
	
	    <input type="text" size="30" value="" tabindex="1" id="nomenclature<%=itemCount %>" size="70"  name="nomenclature<%=itemCount %>" onblur="validateDiet('<%=itemCount %>');"  />
	   	<div id="ac2update<%=itemCount %>" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature<%=itemCount %>','ac2update<%=itemCount %>','ipd?method=autoCompleteForDietItem&parent='+inPatientId,{parameters:'requiredField=nomenclature<%=itemCount %>'});
			</script>
			<input type="hidden"  id="itemId<%=itemCount %>" name="itemId<%=itemCount %>"  />
	    </td>
	    <td>
	    	    <input type="text"  id="quantity<%=itemCount %>" name="quantity<%=itemCount %>"  />
	    </td>
	    
	     <td>
	    	    <input type="text"  id="remarks<%=itemCount %>" name="remarks<%=itemCount %>"  />
	    </td>
	</tr>
</table>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
	<input type="button" class="button" value="OK" align="right" onclick="onSelectDiet();" />
	<input type="button" name="Reset" value="Close" class="button" align="right" onclick="javascript:onCloseDiet();">
		<div class="clear"></div>
<input type="hidden" name="itemCount" id="itemCount" value="<%=itemCount%>" />

<script type="text/javascript">
function addRowExtraDiet(){
    
	  var tbl = document.getElementById('extradietTable');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('itemCount');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;
	  
	  var cellRight1 = row.insertCell(0);
		var e1 = document.createElement('input');
		e1.type = 'checkbox';
		e1.name='checkbox'+iteration;
		e1.id='checkbox'+iteration;
		e1.className='radioCheck';
		cellRight1.appendChild(e1);
 
	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	   e0.onblur=function(){
		   validateDiet(iteration);
	  					  }; 
	  					  
	  					 e0.name = 'nomenclature' + iteration;
	  					 e0.id = 'nomenclature' + iteration;
	  					 e0.setAttribute('tabindex','1');
	  					 e0.size = '30';
	  					 
	  					var newdiv1 = document.createElement('div');
	  				  newdiv1.id='ac2update'+iteration;
	  				  newdiv1.className = 'autocomplete';
	  				  newdiv1.style.display = 'none';
 
	  
	  cellRight0.appendChild(e0);
	  cellRight0.appendChild(newdiv1);
		  new Ajax.Autocompleter('nomenclature'+iteration,'ac2update'+iteration,'ipd?method=autoCompleteForDietItem&parent='+inPatientId,{parameters:'requiredField=nomenclature'+iteration});	 


	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='itemId'+iteration;
	  sel.id='itemId'+iteration
	  sel.size = '10';
	  sel.setAttribute('tabindex','1');
	  cellRight0.appendChild(sel);

	  
	  var cellRight1 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='quantity'+iteration;
	  e2.id='quantity'+iteration
	 // e2.size='10';
	  e2.setAttribute('tabindex','1');
	  cellRight1.appendChild(e2);
	  
	  var cellRight1 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='remarks'+iteration;
	  e3.id='remarks'+iteration
	  e3.setAttribute('tabindex','1');
	  cellRight1.appendChild(e3);
	
	}
	
function removeRowExtraDiet()
{
  var tbl = document.getElementById('extradietTable');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('itemCount');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=1;i<=iteration;i++)
	  {
	  if(document.getElementById("checkbox"+i)!=null && (typeof  document.getElementById("checkbox"+i).checked)!='undefined' && document.getElementById("checkbox"+i).checked )
		  {
		  totalSelected=totalSelected+1;
		  }
	  }
      if(totalSelected==0)
	  {
	  alert('Please select atleast 1 row to delete');
	  }
      else  if(lastRow==2 || lastRow==(totalSelected+1))
	  {
    	  alert('You can not delete all Row.');
      }
      else if (lastRow > 2){
    	  for(var i=1;i<=iteration;i++)
    	  {
    		  if(document.getElementById("checkbox"+i)!=null && (typeof  document.getElementById("checkbox"+i).checked)!='undefined' && document.getElementById("checkbox"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("checkbox"+i).parentNode.parentNode;
    		  document.getElementById("checkbox"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
  }
}


function validateDiet(index)
{
	var val=document.getElementById("nomenclature"+index).value;
	if(val != "")
	{
	    var index1 = val.lastIndexOf("(");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf(")");
	    index1++;
	    var itemId = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var itemName=val.substring(0,indexForBrandName);

	  if(itemId == "")
	  {
	   	document.getElementById('nomenclature'+index).value="";
	    document.getElementById('itemId'+index).value="";
	    
	    
	   return;
	   }
	   else
		   {
		   document.getElementById('nomenclature'+index).value=itemName;
		    document.getElementById('itemId'+index).value=itemId;
	 }
	}
	else
		{
		document.getElementById('nomenclature'+index).value=itemName;
	    document.getElementById('itemId'+index).value=itemId;
	      }
	
	var count=document.getElementById('itemCount').value;
		
		for(var i=1;i<=count;i++)
		{
		   if(document.getElementById("checkbox"+i)!=null)
			   {
			  if(index!=i && document.getElementById('nomenclature'+index).value==document.getElementById('nomenclature'+i).value)
				  {
				  alert('Diet Can not be same');
				  document.getElementById('nomenclature'+index).value="";
				    document.getElementById('itemId'+index).value="";
				    return;
				  }
			   }
		}
}

function onSelectDiet()
{
	var dietCount=0;
	var count=document.getElementById('itemCount').value;
	for(var i=1;i<=count;i++)
	{
		if(document.getElementById("checkbox"+i)!=null  && document.getElementById('nomenclature'+i)!=null && document.getElementById('nomenclature'+i).value!='')
		   {
			 if(document.getElementById('quantity'+i).value=='')
				 {
				 alert('Quantity is blank for diet item '+document.getElementById('nomenclature'+i).value);
				 return;
				 }
			 if(isNaN(document.getElementById('quantity'+i).value))
				 {
				 alert('Quantity is not numeric '+document.getElementById('nomenclature'+i).value);
				 return;
				 }
		   }
	}
	
	for(var i=1;i<=count;i++)
	{
	   if(document.getElementById("checkbox"+i)!=null  && document.getElementById('nomenclature'+i)!=null && document.getElementById('nomenclature'+i).value!='')
		   {
		   dietCount=dietCount+1;
		   var e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='extraDietId'+inPatientId+''+dietCount;
			  e3.id='extraDietId'+inPatientId+''+dietCount;
			  e3.value=document.getElementById('itemId'+i).value;
			  window.opener.document.getElementById('extradiet'+inPatientId).appendChild(e3);
			  
			  e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='extraDietName'+inPatientId+''+dietCount;
			  e3.id='extraDietName'+inPatientId+''+dietCount;
			  e3.value=document.getElementById('nomenclature'+i).value;
			  window.opener.document.getElementById('extradiet'+inPatientId).appendChild(e3);
			  
			  e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='extraDietquantity'+inPatientId+''+dietCount;
			  e3.id='extraDietquantity'+inPatientId+''+dietCount;
			  e3.value=document.getElementById('quantity'+i).value;
			  window.opener.document.getElementById('extradiet'+inPatientId).appendChild(e3);
			  
			  e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='extraDietRemarks'+inPatientId+''+dietCount;
			  e3.id='extraDietRemarks'+inPatientId+''+dietCount;
			  e3.value=document.getElementById('quantity'+i).value;
			  window.opener.document.getElementById('extradiet'+inPatientId).appendChild(e3);
			  
		   }
	}
	
	e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.name='extracount'+inPatientId;
	  e3.id='extracount'+inPatientId;
	  e3.value=dietCount;
	  window.opener.document.getElementById('extradiet'+inPatientId).appendChild(e3);
	  updateItemrequired();
	  window.close();
	}
	
function onCloseDiet()
{
	var e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.name='extracount'+inPatientId;
	  e3.id='extracount'+inPatientId;
	  e3.value=0;
	  window.opener.document.getElementById('extradiet'+inPatientId).appendChild(e3);
	  window.close();
}

function updateItemrequired()
{
	if( window.opener.document.getElementById('itemRequired').value>0)
	{
	 var itemRequiredCount=window.opener.document.getElementById('itemRequired').value;
	var patientDietCount=document.getElementById('itemCount').value;
	for(var i=1;i<=patientDietCount;i++)
		{
		if(document.getElementById("nomenclature"+i)!=null && document.getElementById("nomenclature"+i).value!='')
		{
		var itemmatched=false; 
		for(var j=1;j<=itemRequiredCount;j++)
			{
			if( window.opener.document.getElementById('dietId'+j)!=null && document.getElementById('itemId'+i).value==window.opener.document.getElementById('dietId'+j).value)
			{
				var quantity=parseInt(window.opener.document.getElementById('dietItemCount'+j).value)+parseInt(document.getElementById('quantity'+i).value);
				 window.opener.document.getElementById('dietItemCountView'+j).innerHTML='';
				var e3 = document.createElement('input');
				  e3.type = 'hidden';
				  e3.name='dietItemCount'+j;
				  e3.id='dietItemCount'+j
				  e3.value=quantity;
				  window.opener.document.getElementById('dietItemCountView'+j).appendChild(e3);	
				var e3 = document.createElement('label');
				  e3.innerHTML =window.opener.document.getElementById('dietItemCount'+j).value;
				  window.opener.document.getElementById('dietItemCountView'+j).appendChild(e3);	
				itemmatched=true;
				break;
			}
			}
		if(!itemmatched)
			{
			var tbl = window.opener.document.getElementById('itemrequiredTable');
			  var lastRow = tbl.rows.length;
			  var hdb = window.opener.document.getElementById('itemRequired');
			  var iteration = parseInt(hdb.value);
		  	 var row = tbl.insertRow(lastRow);
			  var iteration = parseInt(hdb.value)+1;
			  hdb.value = iteration;
		   
		   	  var cellRight1 = row.insertCell(0);
			  var e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietId'+iteration;
			  e3.id='dietId'+iteration
			  e3.value=document.getElementById('itemId'+i).value;
			  cellRight1.appendChild(e3);
			  var e3 = document.createElement('label');
			  e3.innerHTML =document.getElementById('nomenclature'+i).value;
			  cellRight1.appendChild(e3);
			  
			  var cellRight1 = row.insertCell(1);
			  cellRight1.id="dietItemCountView"+iteration;
			  
			  var e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietItemCount'+iteration;
			  e3.id='dietItemCount'+iteration
			  e3.value=document.getElementById('quantity'+i).value;
			  cellRight1.appendChild(e3);
			  var e3 = document.createElement('label');
			  e3.innerHTML =document.getElementById('quantity'+i).value;
			  cellRight1.appendChild(e3);
			}
		}
		}
	}
	else
		{
				var count=document.getElementById('itemCount').value;
				for(var i=1;i<=count;i++)
				{
				   if(document.getElementById('nomenclature'+i)!=null && document.getElementById('nomenclature'+i).value!='')
					   {
					   	var tbl = window.opener.document.getElementById('itemrequiredTable');
						  var lastRow = tbl.rows.length;
						  var hdb = window.opener.document.getElementById('itemRequired');
						  var iteration = parseInt(hdb.value);
					  	 var row = tbl.insertRow(lastRow);
						  var iteration = parseInt(hdb.value)+1;
						  hdb.value = iteration;
					   
					   	  var cellRight1 = row.insertCell(0);
						  var e3 = document.createElement('input');
						  e3.type = 'hidden';
						  e3.name='dietId'+iteration;
						  e3.id='dietId'+iteration
						  e3.value=document.getElementById('itemId'+i).value;
						  cellRight1.appendChild(e3);
						  var e3 = document.createElement('label');
						  e3.innerHTML =document.getElementById('nomenclature'+i).value;
						  cellRight1.appendChild(e3);
						  
						  var cellRight1 = row.insertCell(1);
						  cellRight1.id="dietItemCountView"+iteration;
						  
						  var e3 = document.createElement('input');
						  e3.type = 'hidden';
						  e3.name='dietItemCount'+iteration;
						  e3.id='dietItemCount'+iteration
						  e3.value=document.getElementById('quantity'+i).value;
						  cellRight1.appendChild(e3);
						  var e3 = document.createElement('label');
						  e3.innerHTML =document.getElementById('quantity'+i).value;
						  cellRight1.appendChild(e3);
					   }
				}
		}
	}
</script>