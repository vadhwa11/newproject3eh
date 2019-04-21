<%@page import="jkt.hms.masters.business.MasDietCombination"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
List<MasDietCombination> dietCombinationList=new ArrayList<MasDietCombination>();
List<Integer> patientId=new ArrayList<Integer>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
	}
if (map.get("inPatientId") != null) {
	inPatientId = (Integer) map.get("inPatientId");
	}

if (map.get("dietCombinationList") != null) {
	dietCombinationList = (List<MasDietCombination>) map.get("dietCombinationList");
	}

if (map.get("patientId") != null) {
	patientId = (List<Integer>) map.get("patientId");
	}

%>
<script type="text/javascript">
var inPatientId='<%=inPatientId%>';
</script>


<%int itemCount=0; %>
<div class="clear"></div>
<%
if(patientId.size()>0) 
{
%>
<h4>Diet is already selected for selected date and selected Time.</h4>
<%} else
	if(dietCombinationList.size()>0) 
{%>
<table id="extradietTable">
		<tr>
		<th>&nbsp;</th>
			<th>Item</th>
			<th>Qty</th>
		</tr>
	
<%
	for(MasDietCombination dietCombination:dietCombinationList)
	{
		itemCount=itemCount+1;
%>
<tr>
		<td><input type="checkbox" name="checkbox<%=itemCount%>" id="checkbox<%=itemCount%>" class="radioCheck" /> </td>
	<td>
	 		<label><%=dietCombination.getDietItems().getDietItemsName() %></label>
	    	<input type="hidden" size="30" value="<%=dietCombination.getDietItems().getDietItemsName() %>" tabindex="1" id="nomenclature<%=itemCount %>" size="70"
	    	  name="nomenclature<%=itemCount %>"  validate="nomenclature,metachar,no"  />
			<input type="hidden"  id="itemId<%=itemCount %>" name="itemId<%=itemCount %>"  value="<%=dietCombination.getDietItems().getId() %>" validate="itemId,int,no" />
			<input type="hidden"  id="combinationId<%=itemCount %>" name="combinationId<%=itemCount %>"  value="<%=dietCombination.getId() %>" validate="combinationId,int,no"/>
			<input type="hidden"  id="dietcombinationunit<%=itemCount %>" name="dietcombinationunit<%=itemCount %>"  value="<%=dietCombination.getDietItems().getAccountingUnit()!=null?dietCombination.getDietItems().getAccountingUnit().getUnitName():"" %>" validate="dietcombinationunit,int,no"/>
	    </td>
	    <td>
	    <label>2</label>
	    	    <input type="hidden"  id="quantity<%=itemCount %>" name="quantity<%=itemCount %>" value="2"  />
	    </td>
	</tr>

<%} %>
</table>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
	<input type="button" class="button" value="OK" align="right" onclick="onSelectDietCombination();" />
	<input type="button" name="Reset" value="Close" class="button" align="right" onclick="javascript:onCloseDiet();">
		<div class="clear"></div>
<%}else{
	%>	
	<h4>No Data Found!</h4>
	<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
	<input type="button" name="Reset" value="Close" class="button" align="right" onclick="javascript:onCloseDiet();">
		<div class="clear"></div>
	<%} %>


<input type="hidden" name="itemCount" id="itemCount" value="<%=itemCount%>" />

<script type="text/javascript">

function onCloseDiet()
{
	var e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.name='dietCount'+inPatientId;
	  e3.id='dietCount'+inPatientId;
	  e3.value=0;
	  window.opener.document.getElementById('extradiet'+inPatientId).appendChild(e3);
	  window.close();
}


function onSelectDietCombination()
{
	var dietCount=0;
	var count=document.getElementById('itemCount').value;
	
	for(var i=1;i<=count;i++)
	{
	   if(document.getElementById("checkbox"+i)!=null && document.getElementById("checkbox"+i).checked && document.getElementById('nomenclature'+i)!=null && document.getElementById('nomenclature'+i).value!='')
		   {
		   dietCount=dietCount+1;
		   var e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietcombinationDietId'+inPatientId+''+dietCount;
			  e3.id='dietcombinationDietId'+inPatientId+''+dietCount;
			  e3.value=document.getElementById('itemId'+i).value;
			  window.opener.document.getElementById('selectedDiet'+inPatientId).appendChild(e3);
			  
			  e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietcombinationId'+inPatientId+''+dietCount;
			  e3.id='dietcombinationId'+inPatientId+''+dietCount;
			  e3.value=document.getElementById('combinationId'+i).value;
			  window.opener.document.getElementById('selectedDiet'+inPatientId).appendChild(e3);
			  
			  
			  e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietcombinationName'+inPatientId+''+dietCount;
			  e3.id='dietcombinationName'+inPatientId+''+dietCount;
			  e3.value=document.getElementById('nomenclature'+i).value;
			  window.opener.document.getElementById('selectedDiet'+inPatientId).appendChild(e3);
			  
			  e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='dietcombinationquantity'+inPatientId+''+dietCount;
			  e3.id='dietcombinationquantity'+inPatientId+''+dietCount;
			  e3.value=document.getElementById('quantity'+i).value;
			  window.opener.document.getElementById('selectedDiet'+inPatientId).appendChild(e3);
			  
			  /* e3 = document.createElement('input');
			  e3.type = 'hidden';
			  e3.name='extraDietRemarks'+inPatientId+''+dietCount;
			  e3.id='extraDietRemarks'+inPatientId+''+dietCount;
			  e3.value=document.getElementById('quantity'+i).value;
			  window.opener.document.getElementById('selectedDiet'+inPatientId).appendChild(e3); */
			  
		   }
	}
	
	e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.name='dietCount'+inPatientId;
	  e3.id='dietCount'+inPatientId;
	  e3.value=dietCount;
	  window.opener.document.getElementById('selectedDiet'+inPatientId).appendChild(e3);
	  updateItemrequiredForDietCombination();
	  window.close();
	}
	

function updateItemrequiredForDietCombination()
{
	if( window.opener.document.getElementById('itemRequired').value>0)
	{
	 var itemRequiredCount=window.opener.document.getElementById('itemRequired').value;
	var patientDietCount=document.getElementById('itemCount').value;
	for(var i=1;i<=patientDietCount;i++)
		{
		if(document.getElementById("checkbox"+i)!=null && document.getElementById("checkbox"+i).checked)
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
				  e3.value=quantity ;
				  window.opener.document.getElementById('dietItemCountView'+j).appendChild(e3);	
				var e3 = document.createElement('label');
				  e3.innerHTML =window.opener.document.getElementById('dietItemCount'+j).value + document.getElementById('dietcombinationunit'+i).value;
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
			  e3.innerHTML =document.getElementById('quantity'+i).value  + document.getElementById('dietcombinationunit'+i).value;
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
				   if(document.getElementById("checkbox"+i)!=null && document.getElementById("checkbox"+i).checked && document.getElementById('nomenclature'+i)!=null && document.getElementById('nomenclature'+i).value!='')
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
						  e3.innerHTML =document.getElementById('quantity'+i).value  + document.getElementById('dietcombinationunit'+i).value;
						  cellRight1.appendChild(e3);
					   }
				}
		}
	}
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
