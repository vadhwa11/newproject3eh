<%@page import="jkt.hms.util.DiseasesContsants"%>
<%@page import="com.ibm.wsdl.Constants"%>
<%@page import="jkt.hms.masters.business.HmisParameterMapping"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.HmisDistrictReport"%>
<%@page import="jkt.hms.masters.business.MasHmisParameters"%>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script>
<%Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

	
	function getDiseasesIcdMappingList(){
		submitProtoAjaxWithDivName('diseasesIcdMapping','pubHealth?method=getItemListForDiseasesIcdMapping','icdList');
	}
	
	function getIcdInvestigationMappingList(){
		submitProtoAjaxWithDivName('diseasesIcdMapping','pubHealth?method=getItemListForIcdInvestigationMapping','icdList1');
	}
	
</script>

<%
Map map = new HashMap();
Map<String,Object> utilMap = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

utilMap = (Map)HMSUtil.getCurrentDateAndTime(); 

String time = (String)utilMap.get("currentTime");
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");

String diseasesName = null;

if(map.get("diseasesName") != null){
	diseasesName = (String)map.get("diseasesName");
}

if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
}
%>
<div class="titleBg">
<h2>Diseases Icd Mapping</h2>
</div>
<div class="clear"></div>
<form name="diseasesIcdMapping" method="post">
<div class="Block">
<label>Diseases ICD Mapping</label><input type="radio" value="radio1" id="radio1" checked="checked" name="radio" onclick="showdivonclickRadiobutton();">
<label>Investigation ICD Mapping</label><input type="radio" value="radio2"  id="radio2" name="radio" onclick="showdivonclickRadiobutton();">
<h4>Diseases ICD</h4>
<div class="clear"></div>	
<div id="divVal" style="display: none">	
		<div id="pageNavPosition"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<label><span>*</span> Diseases/Syndromes</label> <select
			validate="diseases,string,no" name="diseasesName"
			id="diseasesName" onchange="getDiseasesIcdMappingList();">
			<option value="0">Select</option>
			<% for(String disease : DiseasesContsants.DISEASES_LIST_FOR_ICD_MAPPING) {%>
			<% if((disease!=null && !disease.trim().equals("")) && (disease.equalsIgnoreCase(diseasesName))) {%>
				<option value="<%=disease%>" selected="selected"><%=disease%></option>	
			<% } else {%>
			<option value="<%=disease%>"><%=disease%></option>
			<% } 
			} %>
		</select>
		<div class="clear"></div>
				<label>Icd Name</label> <input type="text" value=""
			tabindex="1" id="icdName" size="40" name="icdName" />

		<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter(
					'icdName',
					'ac2update',
					'pubHealth?method=getItemListForAutoCompleteForDiseasesIcdMapping&'+csrfTokenName+'='+csrfTokenValue,
					{
						minChars : 3,
						callback : function(element, entry) {
							return entry;
						},
						parameters : 'requiredField=icdName'
					});
		</script>

<div style="float: right;">
	<input type="button" class="buttonAdd" name="add" value="" align="right" onclick="javascript:addRowForItem();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeRowForItem();">
</div>
		
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="icdGrid">
	<tr>
	<th scope="col">&nbsp; </th>
		<th scope="col">Icd Name</th>
	</tr>
	<tbody id="icdList">
	
	</tbody>
</table>
		
	</div>



<div id="divVal2" style="display: none">	
		<div id="pageNavPosition"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		

		<label class="auto">Icd Name</label> <input type="text" value=""
			tabindex="1" id="icdName1" size="40" name="icdName1" />

		<div id="ac2update1" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter(
					'icdName1',
					'ac2update1',
					'pubHealth?method=getItemListForAutoCompleteForDiseasesIcdMapping&'+csrfTokenName+'='+csrfTokenValue,
					{
						minChars : 3,
						callback : function(element, entry) {
							return entry;
						},
						parameters : 'requiredField=icdName1'
					});
		</script>
		
		
		
		
		
		<label class="auto">Investigation</label> <input type="text" value=""
			tabindex="1" id="invName" size="40" name="invName" />

		<div id="av2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			new Ajax.Autocompleter(
					'invName',
					'av2update',
					'pubHealth?method=getItemListForAutoCompleteForICDandInvastigation&'+csrfTokenName+'='+csrfTokenValue,
					{
						minChars : 3,
						callback : function(element, entry) {
							return entry;
						},
						parameters : 'requiredFieldInv=invName'
					});
		</script>
		
		

<div style="float: right;">
	<input type="button" class="buttonAdd" name="add1" value="" align="right" onclick="javascript:addRowForItem();">
	<input type="button" name="Reset1" value="" class="buttonDel" align="right" onclick="javascript:removeRowForIcdInvestigationMapping();">
</div>
		
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="icdGrid">
	<tr>
	<th scope="col">&nbsp; </th>
		<th scope="col">Icd Name</th>
		<th scope="col">Investigation Name</th>
	</tr>
	<tbody id="icdList1">
	
	</tbody>
</table>		
</div>	
	
</div>	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div id="responseDiv" style="display: none;"></div>


<script type="text/javascript">
getDiseasesIcdMappingList();
getIcdInvestigationMappingList();
showdivonclickRadiobutton();	


	function addRowForItem(){
		var chkYes = document.getElementById("radio2");	

		if(chkYes.checked){
		var icdNameAndId = document.getElementById("icdName1").value;
		var icdId = icdNameAndId.substring(icdNameAndId.indexOf('{')+1, icdNameAndId.indexOf('}'));
		var icdName =	icdNameAndId.substring(0, icdNameAndId.indexOf('{'));

		var inv = document.getElementById("invName").value;
		var invId =	inv.substring(inv.indexOf('{')+1, inv.indexOf('}'));


		if(inv!='' && icdId!='' && icdName!=''){
		submitProtoAjaxWithDivName('diseasesIcdMapping','pubHealth?method=addInvastigationIcdMapping&icdId='+icdId+'&invId='+invId,'responseDiv');

		var url = window.location.href;
		if (url.indexOf("invName=") >= 0){
		url =	url.substring(0, url.indexOf("invName="));
		}

		window.location.href = url + "&invName="+invName;
		} else if(icdId=='' || icdName==''){ 
		alert("Choose Valid Icd !");
		} else {
		alert("Please choose Investigation !");
		}

		} else {
		
		var icdNameAndId = document.getElementById("icdName").value;
		var icdId =	icdNameAndId.substring(icdNameAndId.indexOf('{')+1, icdNameAndId.indexOf('}'));
		var icdName =	icdNameAndId.substring(0, icdNameAndId.indexOf('{'));
		var diseasesName = document.getElementById("diseasesName").value;
		if(diseasesName!="0" && icdId!='' && icdName!=''){
			submitProtoAjaxWithDivName('diseasesIcdMapping','pubHealth?method=addDiseasesIcdMapping&icdId='+icdId+'&diseasesName='+diseasesName,'responseDiv');
			/* var result = document.getElementById("responseDiv").innerHTML;
			if(result=='success')
				location.reload();
			else
				alert("Please try again !") */
			//location.reload();
			var url = window.location.href;
		    if (url.indexOf("diseasesName=") >= 0){
		    	url =	url.substring(0, url.indexOf("diseasesName="));
		    }
		    
			window.location.href = url + "&diseasesName="+diseasesName;
		} else if(icdId=='' || icdName==''){ 
			alert("Choose Valid Icd !");
		} else {
			alert("Please choose Diseases !");
		}
	  }
	}
	
	function removeRowForItem(){
		var itemCount = document.getElementById("itemCount").value;
		var checkFlag = false;
		var toBeDeletedIds = '';
		var diseasesName = document.getElementById("diseasesName").value;
		for(var i=1; i <=itemCount; i++){
			if(document.getElementById("itemCheck"+i).checked){
				checkFlag = true;
				toBeDeletedIds = toBeDeletedIds+ document.getElementById("itemCheck"+i).value+',';
			}
		}
		
		if(!checkFlag){
			alert("Select at least one item to delete !");
		} else {
			submitProtoAjaxWithDivName('diseasesIcdMapping','pubHealth?method=deleteDiseasesIcdMapping&diseasesIcdMappingIds='+toBeDeletedIds,'responseDiv');
			/* var result = document.getElementById("responseDiv").innerHTML;
				if(result=='success')
					location.reload();
				else
					alert("Please try again !") */
			//location.reload();
			var url = window.location.href;
		    if (url.indexOf("diseasesName=") >= 0){
		    	url =	url.substring(0, url.indexOf("diseasesName="));
		    }
		    
			window.location.href = url + "&diseasesName="+diseasesName;
		}
	}
	
	
	function removeRowForIcdInvestigationMapping(){
		var itemCount = document.getElementById("itemCount1").value;
		var checkFlag = false;
		var toBeDeletedIds = '';
		for(var i=1; i <=itemCount; i++){
			if(document.getElementById("inv_itemCheck"+i).checked){
				checkFlag = true;
				toBeDeletedIds = toBeDeletedIds+ document.getElementById("inv_itemCheck"+i).value+',';
			}
		}
		
		if(!checkFlag){
			alert("Select at least one item to delete !");
		} else {
			submitProtoAjaxWithDivName('diseasesIcdMapping','pubHealth?method=deleteIcdInvestigationMapping&icdInvestigationMappingIds='+toBeDeletedIds,'responseDiv');
			/* var result = document.getElementById("responseDiv").innerHTML;
				if(result=='success')
					location.reload();
				else
					alert("Please try again !") */
			//location.reload();
			var url = window.location.href;
		   /*  if (url.indexOf("diseasesName=") >= 0){
		    	url =	url.substring(0, url.indexOf("diseasesName="));
		    } */
		    
			window.location.href = url;
		}
	}
	
	
   function showdivonclickRadiobutton(){
	   var chkYes = document.getElementById("radio2");
	   var chkNo = document.getElementById("radio1");
     //  alert(chkYes);
	   
    if(chkYes.checked) {
     var dv2= document.getElementById("divVal2");
     var dv1= document.getElementById("divVal");
	  dv2.style.display = chkYes.checked ? "block" : "none";
	  dv1.style.display = "none";
    }
    else if (chkNo.checked) {
    	  var dv2= document.getElementById("divVal2");
    	   var dv1= document.getElementById("divVal");
    		dv1.style.display = chkNo.checked ? "block" : "none";
    	dv2.style.display = "none";
	}
    
  
	   
	   
   }  
   
	
</script>