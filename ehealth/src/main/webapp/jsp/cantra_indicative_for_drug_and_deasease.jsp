<%@page import="jkt.hms.masters.business.CantraIndicativeDrugsToDeasease"%>
<%@page import="jkt.hms.masters.business.CantraIndicativeDrugsToDrugs"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script>jQuery.noConflict();</script>


<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

}

List<CantraIndicativeDrugsToDrugs>ddgList=new ArrayList<CantraIndicativeDrugsToDrugs>();
List<CantraIndicativeDrugsToDeasease>ddsList=new ArrayList<CantraIndicativeDrugsToDeasease>();
if(map.get("ddgList")!=null){
	ddgList=(List<CantraIndicativeDrugsToDrugs>)map.get("ddgList");
}
if(map.get("ddsList")!=null){
	ddsList=(List<CantraIndicativeDrugsToDeasease>)map.get("ddsList");
}

Map<Integer,String>itemName=new HashMap<Integer, String>();
Map<Integer,String>icdName=new HashMap<Integer, String>();
if(map.get("itemName")!=null){
	itemName=(Map<Integer,String>)map.get("itemName");
}
if(map.get("icdName")!=null){
	icdName=(Map<Integer,String>)map.get("icdName");
}
%>
<div class="Block">
<div class="clear"></div>
<form name="cantra" id="cantra" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<%if(ddsList!=null && ddsList.size()>0) {%>
<label>Drug To Drug Mapping</label>
<%}%>
<div class="floatRight">
<input	type="button" class="buttonAdd" alt="Add" tabindex="4" onclick="showHIde(1);" align="right" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" onclick="removeCantraDrugs();"/>
</div>
<div class="clear"></div>
<div id="divTemplet">
<%if(ddgList!=null && ddgList.size()>0) {%>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridDrug">
		<tr>
			<th scope="col">&nbsp;</th>
			<th scope="col">Drug</th>
			<th scope="col">To</th>
			<th scope="col">Drug</th>
		</tr>
		<%
		int incr=0;
			for(CantraIndicativeDrugsToDrugs dd:ddgList){
		%>
		
			<tr>
				<td><input type="checkbox" class="radioCheck" id="itemRadioDrug<%=incr%>" name="itemRadioDrug<%=incr%>" value="<%=dd.getId() %>"/></td>	
				<td>
					<input  type="text" readonly="readonly" class="extraLageText" value="<%=itemName.get(dd.getCantraIndicativeDrugsA().getId()) %>"/>
				</td>
				<td></td>
				<td>
					<input  type="text" readonly="readonly" class="extraLageText" value="<%=itemName.get(dd.getCantraIndicativeDrugsB().getId())%>"/>
				</td>
			</tr>
			<%incr++;
			} %>
	</table>
<%}else{ %>
	<label class="autoSize">Drug to Drug Mapping Record Not found</label>
<%} %>	
<input type="hidden" id="ddgcount" value="<%=ddgList.size() %>"/>
</div>


<div class="paddingTop25" >
<div class="clear"></div>
<%if(ddsList!=null && ddsList.size()>0) {%>
<label>Drug To disease Mapping</label>
<%}%>
<div class="floatRight">
<input	type="button" class="buttonAdd" alt="Add" tabindex="4" onclick="showHIde(2);" align="right" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete"  align="right" onclick="removeCantraDisease();"/>
</div>
<div class="clear"></div>
<div id="divTemplet">
<%if(ddsList!=null && ddsList.size()>0) {%>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridDiesease">
		<tr>
			<th scope="col">&nbsp;</th>
			<th scope="col">Drug</th>
			<th scope="col">To</th>
			<th scope="col">disease</th>
		</tr>
			<%
				int incr=0;
				for(CantraIndicativeDrugsToDeasease dd:ddsList){
			%>
				<tr>
				<td><input type="checkbox" class="radioCheck"  id="itemRadioDiesease<%=incr%>" name="itemRadioDiesease<%=incr%>" value="<%=dd.getId()%>"  /></td>	
				<td>
					<input  type="text" readonly="readonly" class="extraLageText" value="<%=itemName.get(dd.getCantraIndicativeDrugs().getId())%>" />
				</td>
				<td></td>
				<td>
					<%
						System.out.println(icdName.get(dd.getIcd().getId()));
						System.out.println(dd.getIcd().getId());
					%>
					<input type="text" readonly="readonly" class="extraLageText" value="<%=icdName.get(dd.getIcd().getId())%>"  />
				</td>
			</tr>
			<%incr++;} %>
	</table>
<%}else{ %>
	<label class="autoSize">Drug to Disease Mapping Record Not found</label>
<%} %>
<input type="hidden" id="ddscount" value="<%=ddsList.size() %>"/>	
</div>
</div>
</form>


<!-- Entry field for drug and desease mapping -->
<div class="paddingTop25" id="drugTodrugDiv" style="display: none">
<label class="autoSize">New Drug To Drug Mapping</label>
<div class="clear"></div>
<form name="cantraDrugToDrug" id="cantraDrugToDrug" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<table>
			<tr>
				<th scope="col">Drug</th>
				<th scope="col">To</th>
				<th scope="col">Drug</th>
			</tr>
			<tr>
				<td>
					<input  type="text" class="extraLageText" 	id="nomenclatureLeft" size="35" name="nomenclatureLeft" />
					<div id="ac2updatesLeft" style="display: none;" class="autocomplete"></div> 
					<script type="text/javascript" language="javascript" charset="utf-8">
							  new Ajax.Autocompleter('nomenclatureLeft','ac2updatesLeft','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclatureLeft'});
					</script> 
				</td>
				<td></td>
				<td>
					<input  type="text" class="extraLageText" id="nomenclatureRight" size="35" name="nomenclatureRight"/>
					<div id="ac2updatesRight" style="display: none;" class="autocomplete"></div> 
					<script type="text/javascript" language="javascript" charset="utf-8">
							  new Ajax.Autocompleter('nomenclatureRight','ac2updatesRight','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclatureRight'});
					</script> 
				</td>
			</tr>
	</table>
	<input type="button" class="button" value="Add" onClick="fnSubmitCantraDrugToDrug(1);"/>
	<input type="button" class="button" value="Cancel" onClick="displayHide(1);"/>
</form>	
</div>

<div class="paddingTop25" id="drugToDeseaseDiv" style="display: none">
<label class="autoSize">New Drug To Desease Mapping</label>
<div class="clear"></div>
<form name="cantraDrugToDesease" id="cantraDrugToDesease" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<table>
		<tr>
			<th scope="col">Drug</th>
			<th scope="col">To</th>
			<th scope="col">Disease</th>
		</tr>
			<tr>
				<td>
					<input  type="text" class="extraLageText" 	id="nomenclature" size="35" name="nomenclature" />
					<div id="ac2updatesDrug" style="display: none;" class="autocomplete"></div> 
					<script type="text/javascript" language="javascript" charset="utf-8">
							  new Ajax.Autocompleter('nomenclature','ac2updatesDrug','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclature'});
					</script>
				</td>
				<td></td>
				<td>
					<input type="text" class="extraLageText" id="icd" name="icd" />
					<div id="ac2updatesIcd" style="display: none;" class="autocomplete"></div>
					<script type="text/javascript" language="javascript" charset="utf-8">
							  new Ajax.Autocompleter('icd','ac2updatesIcd','opd?method=getICDList',{parameters:'requiredField=icd'});
					</script>
				</td>
			</tr>
	</table>
	<input type="button" class="button" value="Add" onClick="fnSubmitCantraDrugToDesease(2);"/>
	<input type="button" class="button" value="Cancel" onClick="displayHide(2);"/>
</form>	
</div> 
</div>

<script type="text/javascript">
function back(){
	window.history.back();
}
function displayHide(flag){
	jQuery(function ($) {
		if(flag==1){
			$("#drugTodrugDiv").hide();
		}
		if(flag==2){
			$("#drugToDeseaseDiv").hide();
		}
	});
}

function showHIde(flag){
	jQuery(function ($) {
		if(flag==1){
			$("#drugTodrugDiv").show();
			$("#nomenclatureLeft").focus();
			
		}else{
			$("#drugTodrugDiv").hide();
			$("#nomenclature").focus();
			
		}
		
		if(flag==2){
			$("#drugToDeseaseDiv").show();
		}else{
			$("#drugToDeseaseDiv").hide();
		}	
	});
}

//drug mapping
 function fnSubmitCantraDrugToDrug(flag){
	if(!validateCantra()){
		if(confirm("Do you want to submit !")){
			var flag=submitForm('cantraDrugToDrug','/hms/hms/opd?method=submitCantraDrugAndDiesease&flag='+flag);	
		}
	}
	jQuery(function ($) {
		$("#drugTodrugDiv").hide();
	});
} 
 function validateCantra(){
			var nomenclature1 = document.getElementById("nomenclatureLeft").value;
			var nomenclature2 = document.getElementById("nomenclatureRight").value;
			if(nomenclature1==""){
				alert("Fill left side drugs");
				return true;
			}
			if(nomenclature2==""){
				alert("Fill Right side drugs");
				return true;
			}
			if(nomenclature1==nomenclature2){
				alert("Choose different drugs");
				return true;
			}
} 
//desease mapping
 function fnSubmitCantraDrugToDesease(flag){
		if(!validateCantraDeases()){
			if(confirm("Do you want to submit !")){
				 var flag=submitForm('cantraDrugToDesease','/hms/hms/opd?method=submitCantraDrugAndDiesease&flag='+flag); 	
			}
		}
		jQuery(function ($) {
			$("#drugToDeseaseDiv").hide();
		});
	}
	 function validateCantraDeases(){
		 	var nomenclature1 = document.getElementById("nomenclature").value;
			var icd = document.getElementById("icd").value;
			if(nomenclature1==""){
				alert("Fill left side drugs.");
				return true;
			}
			if(icd==""){
				alert("Fill Desease.");
				return true;
			}
	} 
	 function removeCantraDrugs(){
		 if(confirm("Do you want to delete record.")){
			 var ids="";
			 var ddgcount = document.getElementById("ddgcount").value;
			 for(var count=0;count<ddgcount;count++){
				 	var remember = document.getElementById('itemRadioDrug'+count);
				    if (remember.checked){
				    	if(ids==""){
					 		ids =document.getElementById('itemRadioDrug'+count).value;	
					 	}else{
					    	ids =ids+","+ document.getElementById('itemRadioDrug'+count).value;
					    }
				    }
			 }
			 jQuery(function ($) {
  				   $.post("opd?method=removeCantraDrugs&ids="+ids+"&"+csrfTokenName+"="+csrfTokenValue, function( data ) {
					 	try {	
						} catch (e) {
						  alert(e);
						}
					});  
				 });
			/* new Ajax.Request("opd?method=removeCantraDrugs&ids="+ids, {
		    	  onSuccess: function(response) {
		    	  }
		    	});*/
		 }
		
	 }
	 function removeCantraDisease(){
		 if(confirm("Do you want to delete record.")){
			 var ids="";
			 var ddscount = document.getElementById("ddscount").value;
			 for(var count=0;count<ddscount;count++){
				 var remember = document.getElementById('itemRadioDiesease'+count);
				 if (remember.checked){
				    	if(ids==""){
					 		ids =document.getElementById('itemRadioDiesease'+count).value;	
					 	}else{
					    	ids =ids+","+ document.getElementById('itemRadioDiesease'+count).value;
					    }
				    }
			 }
				 jQuery(function ($) {
   				  		$.post("opd?method=removeCantraDisease&ids="+ids+"&"+csrfTokenName+"="+csrfTokenValue, function( data ) {
						 	try {	
							} catch (e) {
							  alert(e);
							}
						});  
					 });
			 	/* new Ajax.Request("opd?method=removeCantraDisease&ids="+ids, {
		    	  onSuccess: function(response) {
		    	  }
		    	});*/  
		 }
		
	 }
</script>
