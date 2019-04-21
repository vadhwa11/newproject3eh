<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>

<%@page import="jkt.hms.masters.business.MasHospital"%>

<%@page import="jkt.hms.masters.business.MasBloodGroup"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Indent Blood Bank</title>

<script type="text/javascript">

<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
 %>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>


</head>
<body>
<%
Map<String,Object> map = new HashMap<String,Object>();
List<MasHospital> bloodBankList=new ArrayList<MasHospital>();
List<MasBloodGroup> bloodGroupList=new ArrayList<MasBloodGroup>();

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");


if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

if(map.get("bloodBankList") != null){
	bloodBankList=(List<MasHospital>)map.get("bloodBankList");
}

if(map.get("bloodGroupList") != null){
	bloodGroupList=(List<MasBloodGroup>)map.get("bloodGroupList");
}

%>
<div class="titleBg">
<h2>Indent To Blood Bank</h2>
</div>
<form name="IndentBloodBank" method="post">
<div class="Block">
<label>Indent Date </label> 
<input type="text" class="date"
	id="indentDateId" name="bloodBankIndentDate" value="<%=currentDate %>"
	validate="Date of Collection,date,no"  readonly="readonly" MAXLENGTH="10" tabindex="1" />

<label>Indent To</label>
<select name="indentToBloodBankName" id="indentToBloodBankNameId" tabindex="1">
	<option value="">Select</option>
	<% if(null !=bloodBankList && bloodBankList.size()>0){
		 for(MasHospital bloodBank:bloodBankList){%>
		 
			 <option value="<%=bloodBank.getId()%>"><%= bloodBank.getHospitalName()%></option>
		<%}
	}
	%>
	
	
</select>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>	
<div class="clear"></div>
<input type="button" class="button" value="Add"
	onclick="addRowForInvestigation()"
	align="right" /> 
	
	<input type="button" class="buttonHighlight"
	name="Reset" id="reset" value="Delete"
	onclick="deleteRow('dataTable')" accesskey="r" />
	
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>	
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<table id="" width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			<th>Select     </th>
			<th>Blood Group</th>
			<th>Component Name</th>
			<th>Available Stock</th>
			<th>Request Quantity</th>
			<th>Request On Date</th>
			
		</tr>
	</thead>
	</table>

<table id="dataTable" width="100%" border="0" cellspacing="0" cellpadding="0">

	<tbody>
		
		<tr>
		<td>
		<%int inc=1; %>
			<input name="chk" type="checkbox" id="checkRadioId<%=inc%> size="5" id="chk"/>
 		</td>
 			<td>
 			
			<select name="bloodGroup<%=inc %>" id="bloodGroupId<%=inc %>" onchange="checkForBloodBank()">
			<option value="">Select</option>
			<%if(null !=bloodGroupList && bloodGroupList.size()>0){
				for(MasBloodGroup bloodGroup:bloodGroupList){%>
				
				<option value="<%=bloodGroup.getId()%>"><%= bloodGroup.getBloodGroupName()%></option>
					
				<%}
			}
			%>
				
			</select>
			<script type="text/javascript">
 					var	bloodGroupArray= new Array();
		              <%
		              MasBloodGroup cmp = new MasBloodGroup();
					     for (int k = 0; k < bloodGroupList.size(); k++) {
					    	 cmp = (MasBloodGroup) bloodGroupList.get(k);
		     			%> 
		     			bloodGroupArray[<%=k%>]= new Array();
		     			bloodGroupArray[<%=k%>][0] = "<%=cmp.getId()%>";
		     			bloodGroupArray[<%=k%>][1] = "<%=cmp.getBloodGroupName()%>";
	     				<% }%> 
            	</script> 
			
 			</td>
			<td><input  type="text"
				name="<%=BLOOD_COMPONENT_NAME%><%=inc %>" id="bloodComponentName<%=inc %>" size="20" MAXLENGTH="45"
				tabindex=1 onblur="checkForComponentCode(this.value,'<%=inc %>')" />
				
				<div id="ac2update6" style="display: none;" class="autocomplete"></div>
				<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('bloodComponentName<%=inc %>','ac2update6','bloodBank?method=getComponentNameForAutoComplete',{parameters:'requiredField=<%=BLOOD_COMPONENT_NAME%><%=inc %>'});
		</script>
				</td>
				
			<td><input id="availableStockId<%=inc %>" type="text"
				name="availableStock<%=inc %>" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" /></td>
			
			<td><input id="quantity<%=inc %>" type="text"
				name="quantity<%=inc %>" value="" size="20" MAXLENGTH="45"
				tabindex=1 onblur="checkQuantity(this.value)"  /></td>
				
			<td>
			<input type="text" class="date"
			id="requestOnDateID<%=inc %>" name="requestOnDate<%=inc %>" value=""
				validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" 
				onblur="validateExpDate(this,'sbirthDayId')"
				 onkeyup="mask(this.value,this,'2,5','/');"  /> 
	
	<img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.IndentBloodBank.requestOnDate<%=inc %>,event)" />
			
			 </td>
			
		</tr>
	</tbody>
</table>

<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" value="<%=inc%>"/>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<input type="button" class="button" value="Submit"
	onclick="submitForm('IndentBloodBank','/hms/hms/bloodBank?method=submitBloodIndentRequest');"
	align="right" /> 
	
	<input type="reset" class="buttonHighlight"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodReaction',);" accesskey="r" />

</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
<script type="text/javascript">
function checkForBloodBank(){
	
	var inc=document.getElementById('hiddenValue').value;
	
	var bloodBank=document.getElementById('indentToBloodBankNameId');
	
	if(bloodBank.options[bloodBank.selectedIndex].value != ""){
		
		return true;
	}
	else{
		document.getElementById("bloodGroupId"+inc).selectedIndex ="";
		alert('Select Indent To Blood Bank ')
		return false;
	}
	
}

function addRowForInvestigation(){

	  var tbl = document.getElementById('dataTable');
		
			  var lastRow = tbl.rows.length;
			  var iteration = lastRow;
			  var row = tbl.insertRow(lastRow);
			 
			  var hdb = document.getElementById('hiddenValue');
			  iteration = parseInt(hdb.value)+1;
			  hdb.value=iteration;
			  row.id=iteration;

			  var cellRight1 = row.insertCell(0);
			  var e0 = document.createElement('input');
			  e0.type = 'checkbox';
			  e0.name='chargeRadio'+iteration;
			  e0.id='chargeRadio'+iteration;
			 // e0.className='radioCheck';
			  cellRight1.appendChild(e0);
			  
			  var cellRight1 = row.insertCell(1);
			  var e1 = document.createElement('Select');
			  e1.name='bloodGroup'+iteration;
			  e1.id='bloodGroupId'+iteration;
			  e1.style.width = "120px";
			  e1.options[0] = new Option('Select', '0');
			  e1.onchange=function(event)
	          {	
				  checkForBloodBank();
		      };
			  for(var i = 0;i<bloodGroupArray.length;i++ ){
				e1.options[bloodGroupArray[i][0]] = new Option(bloodGroupArray[i][1],bloodGroupArray[i][0]);
			  } 
			  cellRight1.appendChild(e1);
			  
			  var cellRight3 = row.insertCell(2);
			  var e0 = document.createElement('input');
			  e0.type = 'text';
			  e0.name='bloodComponentName'+iteration;
			  e0.id='bloodComponentName'+iteration;
			  e0.size='20';
			  e0.className = "opdgridText";
			  
			  e0.onblur=function(event)
	          {	
				  checkForComponentCode(this.value,iteration);
	          }
			  cellRight3.appendChild(e0); 
			  var updatediv = document.createElement('div');
			  updatediv.setAttribute('id', 'ac2update6'+iteration);
			  updatediv.style.display = 'none';
			  updatediv.className = "autocomplete";
			  cellRight3.appendChild(updatediv);
			  
new Ajax.Autocompleter('bloodComponentName'+iteration,'ac2update6'+iteration,'bloodBank?method=getComponentNameForAutoComplete',{parameters:'requiredField=bloodComponentName'+iteration});

			  
			  var cellRight3 = row.insertCell(3);
			  var e0 = document.createElement('input');
			  e0.type = 'text';
			  e0.name='availableStockId'+iteration;
			  e0.id='availableStockId'+iteration;
			  e0.size='16';
			  e0.className = "opdgridText";
			  cellRight3.appendChild(e0); 
			  
			  var cellRight3 = row.insertCell(4);
			  var e0 = document.createElement('input');
			  e0.type = 'text';
			  e0.name='quantity'+iteration;
			  e0.id='quantity'+iteration;
			  e0.size='16';
			  e0.className = "opdgridText";
			  cellRight3.appendChild(e0); 
			  
			  var cellRight1 = row.insertCell(5);
			  var e1 = document.createElement('input');
			  e1.type = 'text';
			  e1.name='requestOnDate'+iteration;
			  e1.id='requestOnDate'+iteration;
			  e1.size='16';
			  e1.value="";
			//   e1.className='small';
			  e1.readOnly=true;
			  cellRight1.appendChild(e1);
			 
			  var img1 = document.createElement('img');
			  img1.src = '/hms/jsp/images/cal.gif';
			  img1.onclick=function(event)
	          {	
				  var obj=document.getElementById('requestOnDate'+iteration);
				  setdate('',obj,event);
		      };
			  cellRight1.appendChild(img1);
			  
			  
			  

			
			}
function removeRowPrescriptionTab ()
{
	var tbl = document.getElementById('dataTable');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('hiddenValue');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("chargeRadio"+i)!=null && (typeof  document.getElementById("chargeRadio"+i).checked)!='undefined' && document.getElementById("chargeRadio"+i).checked )
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
	    		  if(document.getElementById("chargeRadio"+i)!=null && (typeof  document.getElementById("chargeRadio"+i).checked)!='undefined' && document.getElementById("chargeRadio"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("chargeRadio"+i).parentNode.parentNode;
	    		  document.getElementById("chargeRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	  }	      
}	


function checkForComponentCode(val,inc){
	
	
	if(val != "")
	{
		/* var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
		var end=((pageNo-1)*8)+8; */
		//alert(val);
		var index1 = val.lastIndexOf("[");
		var indexForComponentName= index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var componentId = val.substring(index1,index2);
		var indexForComponentName = indexForComponentName--;
		var componentName = val.substring(0,indexForComponentName);
		var bloodBankName=document.getElementById('indentToBloodBankNameId').value;
		/* alert("Hi"+bloodBankName)
		alert("Hi"+inc) */
		var bloodGroupId=document.getElementById('bloodGroupId'+inc).value;
		//alert(bloodGroupId)
	if(componentId =="")
	{
  	 document.getElementById('quantity'+inc).value="";
     return;
	}
	for(i=1;i<inc;i++){
	
	if(inc != 1){
	if(document.getElementById('bloodComponentName'+i).value==val)
	{
		alert("Component Name already selected...!")
		document.getElementById('bloodComponentName'+inc).value=""
		var e=eval(document.getElementById('bloodComponentName'+inc)); 
		e.focus();
		return false;
	} }  }
	
	ajaxFunctionForAutoCompleteComponentNameForIndent('IndentBloodBank','bloodBank?method=fillItemsForComponentname&componentName='+componentName+'&bloodBankName='+bloodBankName+'&bloodGroupId='+bloodGroupId , inc);
	
	}else{
		document.getElementById('quantity'+inc).value = "";
	}
}

function checkQuantity(requestQuantity){
	var incValue=document.getElementById('hiddenValue').value;
	var availableStaock=document.getElementById('availableStockId'+incValue).value;
	
	if(availableStaock ==""){
		alert("Available Stock Field Can not blank ")
		document.getElementById('quantity'+incValue).value='';
		return false;
	}
	else{
		if(availableStaock>=requestQuantity){
			return true;
		}
		else{
			alert("Request Quantity should not greater then available stock ")
			document.getElementById('quantity'+incValue).value='';
		}
	}
}



</script>
</html>