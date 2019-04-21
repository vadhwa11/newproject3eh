<%@page import="jkt.hms.masters.business.IpdKitIssueMasterTemplateM"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%-- <%@page import="jkt.hms.masters.business.KitIssueMasterTemplateM"%> --%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>

<%@page import="jkt.hms.util.Box"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script>

<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>

	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<form name="showKitIssue" action="" method="post">
<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
 String userName = "";
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String currentTime = (String)utilMap.get("currentTime");

 if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
 }
 String message = "";
 if(map.get("message")!=null){
	 message = (String)map.get("message");
 }
 List<IpdKitIssueMasterTemplateM> kitIssueList = new ArrayList<IpdKitIssueMasterTemplateM>();
if(map.get("kitIssueList")!=null){
	kitIssueList = (List<IpdKitIssueMasterTemplateM>)map.get("kitIssueList");
} 


Box box = HMSUtil.getBox(request);	

%>

<h4><%=message %></h4>
<div class="Clear"></div>
<div class="titleBg">
<h2>Kit Issue Master</h2></div>
<div class="Clear"></div>

<div id="testDiv">

<div class="clear"></div>
<div class="Block">
<label >Template Name <span>*</span></label>
<input type="text" name="templateName" value="" id="templateName" validate="Template,metachar,yes" maxlength="30" />
<div class="clear"></div>

<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
<div style="float: right;">
	<input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRow();" tabindex="1" />
	<input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('grid','hdb',this);" tabindex="1" />
		</div>
		<div class="clear"></div>
		<div class="paddingTop15"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
	
	    <th>Sl No.</th>
		<th>Item Name</th>
		<th>Authorized Qty.</th>
		<th>Select</th>
	</tr>
	<tr>
	
	    <td>1</td>
		<td><input type="text" value="" tabindex="1" id="nomenclature1"  name="nomenclature1" size="100"
			onblur="if(this.value!=''){checkForNomenclature(this.value,1);}" />
		<div id="ac2update1" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		//new Ajax.Autocompleter('nomenclature1','ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature1'});
	    new Ajax.Autocompleter('nomenclature1','ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature1'});
</script>
			</td>
			<td id="batchDiv1" style="display: none;">
		<input type="hidden" id="itemId1" name="<%=ITEM_ID %>1" value="" validate="itemId,int,no">
		</td>	
		<td> <input type="text" value="" tabindex="1" id="authQuantity1" checked="false"	name="authQuantity1" size="60"></td>
		<td><input type="checkbox" name="radio1" id="radio1"></td>
		
	</tr>
	
</table>
<div style="float: right;display:none;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1">
<option value="0">Select</option>
</select>
</div>
<div class="clear"></div>

<div class="clear"></div>
	<div class="paddingTop25"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	
	
<input type="hidden" name="hdb" value="1" id="hdb" />

<div class="clear"></div>
<input type="button" name="Submit1" value="Submit" class="button"
	tabindex="1" onclick="submitForm('showKitIssue','/hms/hms/inPatientMaster?method=submitKitIssueMasterDetails','validateGridRows','validateGridRowsQuantity')" />
<input type="reset" name="Reset" value="Reset" class="button"
	tabindex="1" onClick="submitFormForButton('showKitIssue','/hms/hms/inPatientMaster?method=showKitIssueJsp')" accesskey="r" />


<div class="clear"></div>
	<div class="paddingTop25"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	
	

<div class="clear"></div>
<%
if(kitIssueList.size() > 0){
%> 
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl.No.</th>
		<th scope="col">Template Name</th>
	</tr>
	 <%	int i=1;
		for(IpdKitIssueMasterTemplateM kitIssueMasterTemplateM : kitIssueList){
	%>
    <tr  onclick="submitProtoAjax('showKitIssue','/hms/hms/inPatientMaster?method=showKitIssueTemplateDetails&kitIssueMasterId=<%=kitIssueMasterTemplateM.getId() %>');">
	<td><%=i %></td>
	<td><%= kitIssueMasterTemplateM.getTemplateName()%></td>
   </tr>
<%i++;} %>

<%} %> 


<!-- <tr>
	<td>1</td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td>2</td>
	<td>&nbsp;</td>
	</tr>
	<tr>
	<td>3</td>
	<td>&nbsp;</td>
	</tr> -->


</table>
<div style="float: right;display:none;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1" validate="templateId,int,no">
<option value="0">Select</option>
</select>
</div>
</div>

<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	
	
</div>


<div class="clear"></div>          
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
<script>
function setIdForDelete(kitId){
if(document.getElementById('deleteKitId').value!=''){	
	document.getElementById('deleteKitId').value=document.getElementById('deleteKitId').value+","+kitId;
}else{
	document.getElementById('deleteKitId').value=kitId
}
}
 function validateGridRows(){
	var count = document.getElementById('hdb').value;
	var flag = "";
	if(count > 0){
		for(var i=1;i<=count;i++){
			if(document.getElementById('nomenclature'+i) && document.getElementById('nomenclature'+i).value != ''){
				flag = "filled";
				break;
			}
		}
		if(flag==''){
			alert("Please fill a row.");
			return false;
		}
	}
	return true;
 }
 
 function validateGridRowsQuantity()
 {
	 var count = document.getElementById('hdb').value;
		var flag = "";
		if(count > 0){
			for(var i=1;i<=count;i++){
				if(document.getElementById('nomenclature'+i) && document.getElementById('nomenclature'+i).value != ''){
					if(document.getElementById('authQuantity'+i).value!='' && parseInt(document.getElementById('authQuantity'+i).value)>=0)
						{
						flag = "filled";
						}
					else{
						flag = "";
						break;
					}
					
				}
			}
			if(flag==''){
				alert("Please fill a valid quantity.");
				return false;
			}
		}
		return true;
 }

function addRow(){
	
	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cell1 = row.insertCell(0);
	  var e1 = document.createElement('label');
	   e1.innerHTML  =lastRow;
	  cell1.appendChild(e1); 
	  lastRow=lastRow+1;
	 
	  var cell2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '100';
	  e2.tabIndex="1";
	  e2.name='nomenclature'+iteration;
	  e2.id='nomenclature'+iteration
	  e2.onblur=function(){if(this.value!=''){checkForNomenclature(this.value,iteration)}};
	 /*  e2.onblur=function(){if(this.value!=''){checkForNomenclature(this.value,iteration)}}; */
	  cell2.appendChild(e2);
	  var div = document.createElement('div');
	  div.id='ac2update'+iteration;
	  div.style.display=' none';
	  div.className='autocomplete';
	  cell2.appendChild(div);
	  var script = document.createElement( "script" );
	  script.type = "text/javascript";
	  script.charset = "utf-8";
	  script.innerHTML = "new Ajax.Autocompleter('nomenclature"+iteration+"','ac2update"+iteration+"','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature"+iteration+"'})";
	  cell2.appendChild(script);
	  
	  var cell3 = row.insertCell(2);
	  cell3.id='batchDiv'+iteration;
	  cell3.style.display='none';
	  var e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.size = '60';
	  e3.tabIndex="1";
	  e3.name='itemId'+iteration;
	  e3.id='itemId'+iteration
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);

	  var cell3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.size = '60';
	  e3.tabIndex="1";
	  e3.name='authQuantity'+iteration;
	  e3.id='authQuantity'+iteration
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);
	  
	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	  e4.type = 'checkbox';
	  e4.checked = false;
	  e4.tabIndex="1";
	  e4.name='radio'+iteration;
	  e4.id='radio'+iteration
	  cellRight4.appendChild(e4); 

	 
}

function removeRow(idName,countId,obj)
{
  var tbl = document.getElementById('grid');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('hdb');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=1;i<=iteration;i++)
	  {
	  if(document.getElementById("radio"+i)!=null && (typeof  document.getElementById("radio"+i).checked)!='undefined' && document.getElementById("radio"+i).checked )
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
    	  if(document.getElementById("radio"+i)!=null && (typeof  document.getElementById("radio"+i).checked)!='undefined' && document.getElementById("radio"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("radio"+i).parentNode.parentNode;
    		  document.getElementById("radio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
    	  for(var i=1;i<document.getElementById('grid').rows.length;i++)
    		  {
    		  document.getElementById('grid').rows[i].cells[0].innerHTML=i;
    		  }
  }
}

function getRadioId(val,inc){
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var radioId = val.substring(index1,index2);
	document.getElementById('radioId'+inc).value = radioId;
	
}

function checkForNomenclature(val,inc)
{
   // alert('avl'+val+'inc'+inc);
	if(val != ""){
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvms = val.substring(index1,index2);

		if(pvms == "" ) {
	      	document.getElementById('nomenclature'+inc).value="";
	       	return;
		}

		for(i=1;i<inc;i++){
            
			if(inc != 1){
 				if(document.getElementById('nomenclature'+i).value==val) {
					alert("Nomenclature already selected...!")
					document.getElementById('nomenclature'+inc).value=""
					var e=eval(document.getElementById('nomenclature'+inc));
					e.focus();
					return false;
				}
			}
		}
		
	if(pvms!=""){
		submitProtoAjaxWithDivName('showKitIssue','/hms/hms/ipd?method=getItemId&counter='+inc+'&pvmsNo='+pvms,'batchDiv'+inc);
	}
}
}

</script>



