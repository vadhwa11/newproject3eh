<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.multi-select.js"></script>
    <link rel="stylesheet" type="text/css" href="/hms/jsp/css/multiselect.css">
<script type="text/javascript">
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';
	
	jQuery.noConflict();
</script>
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
	serverdate = '<%=getDate+"/"+month+"/"+year%>';
	</script>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

List<OpdTemplateInvestigation>tempInvestigation=new ArrayList<OpdTemplateInvestigation>();
List<DgSubMasInvestigation> subInvestigationList = new ArrayList<DgSubMasInvestigation>();
if(map.get("template") != null){
	tempInvestigation = (List<OpdTemplateInvestigation>)map.get("template");
}
if(map.get("subInvestigationList") != null){
	subInvestigationList = (List<DgSubMasInvestigation>)map.get("subInvestigationList");
}
Map<Integer,String>availableStatus=new HashMap<Integer, String>();
if(map.get("availableStatus") != null){
	availableStatus = (Map<Integer,String>)map.get("availableStatus");
}

Integer hinId=null;
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}
String templateName="";
if(map.get("templateName") != null){
	templateName = (String)map.get("templateName");
}

boolean medicineDepartment = false;;
if(map.get("departmentCode") != null){
	String departmentCode = (String)map.get("departmentCode");
	if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeGeneralMedicine")) || departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeOrthopadics")))
			medicineDepartment = true;
}

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");

%>
<%if(tempInvestigation.size()>0){ %>
		<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGridDermotology">
		
			<tr>
				<%if(medicineDepartment){%>
				<th style="background: #bdd6ee; text-align: center;">&nbsp;</th>
				<th style="background: #bdd6ee; text-align: center;">Test Name</th>
				<%} else{%>
				<th scope="col">&nbsp;</th>
				<th scope="col">Test Date</th>
				<th scope="col">Test Time <br/> (HH:MM)</th>
				<th scope="col">Test Name</th>
				<th scope="col">Test Result</th>
				<th scope="col">Abnormal</th>
				<%} %>
			</tr>
			<%int inc=1; 
				Set<DgMasInvestigation> investiationTypeSet = new HashSet<DgMasInvestigation>();
			
			%>
			<%for(int i=0;i<tempInvestigation.size();i++){
				 OpdTemplateInvestigation temp=(OpdTemplateInvestigation)tempInvestigation.get(i);
				 Integer chargeId=temp.getChargeCode().getId();
				 String chargeCodeName=temp.getChargeCode().getChargeCodeName();
				 String str=chargeCodeName+"["+chargeId+"]";
				 String cNotes=temp.getClinicalNotes();
				 String avlStatus="";
				 if(availableStatus.get(chargeId)!="av"){
				 	avlStatus="av";
				  }else{
					  avlStatus="nav";  
				  }
				 investiationTypeSet= temp.getChargeCode().getDgMasInvestigations();
			%>
			<tr>
				<td>
					<input type="checkbox" class="radioCheck" name="chargeRadioDermotology<%=inc %>" id="chargeRadioDermotology<%=inc %>" />
					<input type="hidden" name="availableStatus<%=inc %>" id="availableStatus<%=inc %>" value="<%= avlStatus%>" />
				</td>
				 <td scope="col"><div style="float: left; width:115px;">
								        <input type="text" id="testDate<%=inc%>" name="testDate<%=inc%>" tabindex="1" value="<%=currentDate %>"
										class="dateTextSmall" onblur="checkTrimDate('testDate<%=inc%>');" /> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"  tabindex="1"
										border="0" validate="Pick a date"
										onclick="setdate('<%=currentDate%>',document.getElementById('testDate<%=inc%>'),event);" /></div></td>
										
									<td>	<input type="text" id="testTime<%=inc%>"  name="testTime<%=inc%>" tabindex="1" value="" class="medium" maxlength="5" onkeypress="javascript:return isNumber(event);" onkeyup="mask(this.value,this,'2',':');" onblur="checkTime(this.id);" /></td>
				<td>
				<input   type="text" class="textYellow largTextBoxOpd" value="<%=str %>" id="chargeCodeNameDermotology<%=inc %>" size="65" name="chargeCodeNameDermotology<%=inc %>"
				onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('labTestDermo','/hms/hms/opd?method=fillChargeCodeDermatology&hinId=<%=hinId%>&rowVal=<%=inc %>','chargeCodeValDermotology<%=inc %>');checkTestTime('<%=hinId %>','<%=templateName %>','<%=inc %>');}"/>
				<div id="ac2update<%=inc %>" style="display: none;" class="autocomplete"></div>
				<script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update<%=inc %>','opd?method=getInvestigationListForAutoComplete',{minChars:3,
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheckDermotology=' + document.getElementById('investigationCategoryDermotology').value;
						        },
							  parameters:'requiredField=chargeCodeNameDermotology&fromOpd=fromOpd'});
				</script>
				</td>	
				<%
			if(investiationTypeSet.size()>0){
				for(DgMasInvestigation masInv : investiationTypeSet){
				
				if(masInv.getInvestigationType().equalsIgnoreCase("m")){%>
				<td><%-- <input type="input"  class="largTextBoxOpd textYellow" type="text" name="testResult<%=inc %>" id="testResult<%=inc %>" /> --%></td>
				<%}else{ %>
				<td><input type="input"  class="largTextBoxOpd textYellow" type="text" name="testResult<%=inc %>" id="testResult<%=inc %>" /></td>
				<td> <input type="checkbox" class="radioCheck" value="y" name="resultStatus<%=inc %>" id="resultStatus<%=inc %>" /> </td>
				<%}}} %>
				<%-- <td> <input type="checkbox" class="radioCheck" value="y" name="resultStatus<%=inc %>" id="resultStatus<%=inc %>" /> </td> --%>
				
			</tr>
			<!-- --------------------------------------------- -->
			<%
			List subInvList = new ArrayList();
			if(investiationTypeSet.size()>0){
				for(DgMasInvestigation masInv : investiationTypeSet){
				
				if(masInv.getInvestigationType().equalsIgnoreCase("m")){
			
			if(subInvestigationList.size()>0){ 
				
				%>
			
			<tr id="subParameterDiv<%=inc %>">
				<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td colspan="2">
			<table>
			<%
					int ii=0;
				for(DgSubMasInvestigation dgMasInvestigation : subInvestigationList){
					if(dgMasInvestigation.getChargeCode().getId().equals(chargeId)){
						inc++;
						subInvList.add(dgMasInvestigation.getId());
					
			%>
			
			<tr>
			
			
			<td style="width:312px;"><%=dgMasInvestigation.getSubInvestigationName() != null?dgMasInvestigation.getSubInvestigationName():"" %>
			<input type="hidden" class="radioCheck" name="chargeRadioDermotology<%=inc %>" id="chargeRadioDermotology<%=inc %>" value="" /> 
			<input type="hidden" class="largTextBoxOpd textYellow" type="text" name="chargeCodeNameDermotology<%=inc %>" id="chargeCodeNameDermotology<%=inc %>" value="<%=dgMasInvestigation.getSubInvestigationName()%>" />
			<input type="hidden" class="largTextBoxOpd textYellow" type="text" name="subInvestigationId<%=inc %>" id="subInvestigationId<%=inc %>" value="<%=dgMasInvestigation.getId()%>"/>
			<input type="hidden" class="largTextBoxOpd textYellow" type="text" name="investigationType<%=inc %>" id="investigationType<%=inc %>" value="<%=dgMasInvestigation.getInvestigation().getInvestigationType()%>" /></td>
			<td><input type="text" class="largTextBoxOpd textYellow" type="text" name="testResult<%=inc %>" id="testResult<%=inc %>" /></td>
			<%-- <td> <input type="checkbox" class="radioCheck" value="y" name="resultStatus<%=inc %>" id="resultStatus<%=inc %>" /> </td> --%>
			
			</tr>
			
			<%ii++;}}%>
			</table>
			<td valign="top">
			<table border="0" align="center" cellpadding="0" cellspacing="0" style="border-top:1px solid #C0C0C0;">
			<%
			int indexStatus1 = 0;
			for(DgSubMasInvestigation dgMasInvestigation : subInvestigationList){
				if(dgMasInvestigation.getChargeCode().getId().equals(chargeId)){
					indexStatus1++;
					
			%>
			<tr>
			<td><input type="checkbox" class="radioCheck" value="y" name="resultStatus<%=indexStatus1 %>" id="resultStatus<%=indexStatus1 %>" style="margin:4px 0px 5px 0px;"></td>
			</tr>
			<%}} %>
			</table>
			</td>
			<input type="hidden" class="largTextBoxOpd textYellow" type="text" name="subInvInc" id="subInvInc" value="<%=subInvList.size()%>" />
			<input type="hidden" class="largTextBoxOpd textYellow" type="text" name="parameterSize" id="parameterSize" value="<%=ii%>" />
			</td>
			<td>&nbsp;</td>
			</tr>
			<%}}}} %>
	<!------------------------------------------------------------------>	
	
			<% inc++;}	%>
		</table>
		</tr>
		<input type="hidden" value="<%=inc%>" name="hiddenValueDermotology" id="hiddenValueDermotology" />
		
<%}else{  int inc = 0;%>
		<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGridDermotology">
			<tr>
				<%if(medicineDepartment){%>
				<th style="background: #bdd6ee; text-align: center;">&nbsp;</th>
				<th style="background: #bdd6ee; text-align: center;">Test Name</th>
				<%} else{%>
				<th scope="col">&nbsp;</th>
				<th scope="col">Test Date</th>
				<th scope="col">Test Time <br/> (HH:MM)</th>
				<th scope="col">Test Name</th>
				<th scope="col">Test Result</th>
				<th scope="col">Abnormal</th>
				<%} %>
			</tr> 
		</table>
		<%-- <input type="hidden" name="increament" id="increament" value="<%=inc %>"/>  --%>
		<input type="hidden" value="<%=inc%>" name="hiddenValueDermotology" id="hiddenValueDermotology" />
		
<%} %>



<script>

function validateInvestigationAutoComplete(strValue, inc) {

	var index1 = strValue.lastIndexOf("[");
	var index2 = strValue.lastIndexOf("]");
	index1++;
	var id = strValue.substring(index1, index2);
	var count = document.getElementById('hiddenValueDermotology').value;

	// alert("inc----"+inc)
	if (id == "") {
		document.getElementById('chargeCodeNameDermotology' + inc).value = "";
		// document.getElementById('chargeCode'+inc).value="";
		return;
	}

	for (var i = 0; i <= count; i++) {
		if (document.getElementById('chargeCodeNameDermotology' + i) != null
				&& document.getElementById('chargeCodeNameDermotology' + i).value == strValue
				&& i != inc) {
			alert('This Investigation is already selected.');
			document.getElementById('chargeCodeNameDermotology' + inc).value = "";
			// document.getElementById('chargeCode'+inc).value="";
			return false;
		}
	}
	return true;
}



function displayCollapsibleTabForLabResultDermoLeprosy()
{
	var div = document.getElementById("labResult");
	if (div.style.display !== "block") {
	   div.style.display = "block";
	}else {
	   div.style.display = "none";
	}
}

function addRowForInvestigationDermotology() {

	var tbl = document.getElementById('investigationGridDermotology');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueDermotology');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'chargeRadioDermotology' + iteration;
	e0.id = 'chargeRadioDermotology' + iteration;
	e0.className = 'radioCheck';
	cellRight1.appendChild(e0);

	var e0 = document.createElement('input');
	e0.type = 'hidden';
	e0.name = 'availableStatusDermotology' + iteration;
	e0.id = 'availableStatusDermotology' + iteration;
	e0.size = '20';
	cellRight1.appendChild(e0);

	var e0 = document.createElement('input');
	e0.type = 'hidden';
	e0.name = 'parkInvestigationIdDermotology' + iteration;
	e0.id = 'parkInvestigationIdDermotology' + iteration;
	cellRight1.appendChild(e0);
	
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'testDate' + iteration;
	e1.id = 'testDate' + iteration;
	e1.size = '8';
	e1.className="dateTextSmall";
	e1.value = "<%=currentDate%>";
	e1.onblur = function(event) {
		checkTrimDate('testDate' + iteration);
	};
	e1.tabIndex ="1";
	cellRight1.appendChild(e1);
	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('testDate' + iteration);
		setdate("<%=currentDate%>", obj, event);
	};
	cellRight1.appendChild(img1);
	
	
	var cellRight3 = row.insertCell(2);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name = 'testTime' + iteration;
	e0.id = 'testTime' + iteration;
	e0.maxLength = '5';
	e0.className = "medium";
	cellRight3.appendChild(e0);

	var cellRight0 = row.insertCell(3);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name = 'chargeCodeNameDermotology' + iteration;
	e0.id = 'chargeCodeNameDermotology' + iteration;
	e0.onkeypress = function() {
		checkTextColor('chargeCodeNameDermotology' + iteration);
	};
	e0.onblur = function() {
		getUnavailableInvestigation(iteration);
		checkInvestigationItem(iteration);
		getLoincSnomedList(iteration);
		if (validateInvestigationAutoComplete(this.value, iteration)) {
			submitProtoAjaxNew('labTestDermo',
					"/hms/hms/opd?method=fillChargeCodeDermatology&hinId="
							+ document.getElementById("hinId").value
							+ "&rowVal=" + iteration, 'chargeCodeVal'
							+ iteration);
			checkTestTime(document.getElementById("hinId").value,templateName,iteration);
		}
	};
	e0.size = '65';
	e0.className = "textYellow largTextBoxOpd";
	cellRight0.appendChild(e0);

	var updatediv = document.createElement('div');
	updatediv.setAttribute('id', 'ac2update' + iteration);
	updatediv.style.display = 'none';
	updatediv.className = "autocomplete";
	cellRight0.appendChild(updatediv);

	new Ajax.Autocompleter('chargeCodeNameDermotology' + iteration, 'ac2update'
			+ iteration, 'opd?method=getInvestigationListForAutoComplete', {
		minChars : 3,
		callback : function(element, entry) {
			return entry + '&labradiologyCheckDermotology='
					+ document.getElementById('investigationCategoryDermotology').value;
		},
		parameters : 'requiredField=chargeCodeNameDermotology' + iteration
				+ '&fromOpd=fromOpd'
	});

	var cellRight3 = row.insertCell(4);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name = 'testResult' + iteration;
	e0.id = 'testResult' + iteration;
	e0.size = '20';
	e0.className = "largTextBoxOpd textYellow";
	cellRight3.appendChild(e0);

	var sel = document.createElement('input');
	sel.type = 'hidden';
	sel.name = 'chargeCodeDermotology' + iteration;
	sel.id = 'chargeCodeDermotology' + iteration;
	sel.size = '15';
	cellRight3.appendChild(sel);
	
}
/*
 function removeRowForInvestigationDermotology() {
	var tbl = document.getElementById('investigationGridDermotology');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hiddenValueDermotology');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	if (confirm("Do you want to delete !")) {
		for (var i = 0; i < iteration; i++) {
			if (document.getElementById("chargeRadioDermotology" + i) != null
					&& (typeof document.getElementById("chargeRadioDermotology" + i).checked) != 'undefined'
					&& document.getElementById("chargeRadioDermotology" + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}
		if (totalSelected == 0) {
			alert('Please select atleast 1 row to delete');
		} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
			alert('You can not delete all Row.');
		} else if (lastRow > 2) {
			for (var i = 0; i < iteration; i++) {
				if (document.getElementById("chargeRadioDermotology" + i) != null
						&& (typeof document.getElementById("chargeRadioDermotology" + i).checked) != 'undefined'
						&& document.getElementById("chargeRadioDermotology" + i).checked) {
					jQuery(function($) {
						var ids = "";
						if (document.getElementById("parkInvestigationIdDermotology" + i) != null) {
							ids = document.getElementById("parkInvestigationIdDermotology"
									+ i).value;
						}

						if (ids != "") {
							$.post("opd?method=deleteOPDdetails&ids=" + ids
									+ "&for=" + "Inv" + "&" + csrfTokenName
									+ "=" + csrfTokenValue, function(data) {
								try {
									flag = 1;
									msgFlag = data;
								} catch (e) {
									alert(e);
								}
							});
						}
					});
					var deleteRow = document.getElementById("chargeRadioDermotology" + i).parentNode.parentNode;
					document.getElementById("chargeRadioDermotology" + i).parentNode.parentNode.parentNode
							.removeChild(deleteRow);
				}
			}
		}
	}

} */



jQuery(function($) {
	$("#referral").change(function() {
		if ($("#referral").val() == 1) {
			$("#admDiv").hide();
			$("#admissionAdvised").prop("checked", false);
			$("#admissionAdvised").prop('disabled', true);
		} else {
			$("#admissionAdvised").prop('disabled', false);
		}
	});
	$("#removesnomedList").click(function() {
		$("#snomedList option:selected").remove();
	});

	$(".primary-items a").click(function() {
		$(this).siblings('#subMenu').slideToggle();
	});

	$('input[name="labradiologyCheckDermotology"]').change(
			function() {
				// alert($('input[name="labradiologyCheck"]:checked').val());
				$('#investigationCategoryDermotology').val(
						$('input[name="labradiologyCheckDermotology"]:checked').val());
			});
	$('#investigationCategoryDermotology').val(
			$('input[name="labradiologyCheckDermotology"]:checked').val());
	
	
	$('input[name="pharmacyCheck"]').change(
			function() {
				// alert($('input[name="labradiologyCheck"]:checked').val());
				$('#pharmacyCategory').val(
						$('input[name="pharmacyCheck"]:checked').val());
			});
	$('#investigationCategoryDermotology').val(
			$('input[name="labradiologyCheckDermotology"]:checked').val());
	/*
	 * $("#vitalTrends").click(function(){ var
	 * hinId=document.getElementById("hinId").value;; new
	 * Ajax.Request('opd?method=getPatientVitalTrends&hinId='+hinId, {
	 * onSuccess: function(response) { if(response.responseText.trim()!='No
	 * vital Details') {
	 * $("#vitalUHID").val(document.getElementById("hinNo").value);
	 * $("#vitalPname").val(document.getElementById("patientName").value);
	 * $("#vitalTable").html(response.responseText.trim());
	 * $("#vitalDialog").dialog({width:842,height:332,modal: true}); }else{
	 * alert("No vital details"); } } }); });
	 * $("#calculateBmi").click(function(){ $("#dialog").css("color:black");
	 * $("#dialog").dialog({width: 350,modal: true}); });
	 */

	$("#resetBmi").click(function() {
		$("#height").val("");
		$("#weight").val("");
	});


	$("#temperature").blur(function() {
		if ($("#temperature").val() > 999) {
			alert("Invalide Temperature");
			$("#temperature").focus();
			$("#temperature").val("");
		}
	});

	$(".allownumericwithdecimal")
			.on(
					"keypress keyup blur",
					function(event) {
						// this.value = this.value.replace(/[^0-9\.]/g,'');
						$(this).val($(this).val().replace(/[^0-9\.]/g, ''));
						if ((event.keyCode != 46)
								&& ((event.keyCode != 37))
								&& ((event.keyCode != 39))
								&& (event.keyCode != 9)
								&& (event.keyCode != 8)
								&& (event.which != 46 || $(this).val().indexOf(
										'.') != -1)
								&& (event.which < 48 || event.which > 57)) {
							event.preventDefault();
						}
					});

	$(".allownumericwithoutdecimal").on(
			"keypress keyup blur",
			function(event) {
				$(this).val($(this).val().replace(/[^\d].+/, ""));
				if ((event.keyCode != 46) && ((event.keyCode != 37))
						&& ((event.keyCode != 39)) && (event.keyCode != 9)
						&& (event.keyCode != 8)
						&& (event.which < 48 || event.which > 57)) {
					event.preventDefault();
				}
			});

	$("#generalExamination1").dblclick(
			function() {
				$("#generalExaminationOPC").val(
						$.trim($("#generalExaminationOPC").val()
								+ "\n"
								+ $("#generalExamination1 option:selected")
										.text()));
				$("#generalExaminationEXM").val(
						$.trim($("#generalExaminationEXM").val()
								+ "\n"
								+ $("#generalExamination2 option:selected")
										.text()));
			});
	$("#generalExamination2").dblclick(
			function() {
				$("#generalExaminationOPC").val(
						$.trim($("#generalExaminationOPC").val()
								+ "\n"
								+ $("#generalExamination1 option:selected")
										.text()));
				$("#generalExaminationEXM").val(
						$.trim($("#generalExaminationEXM").val()
								+ "\n"
								+ $("#generalExamination2 option:selected")
										.text()));
			});
	$("#diastolic").blur(function() {
		if (parseInt($("#systolic").val()) < parseInt($("#diastolic").val())) {
			alert("Diastolic should be less than Systolic");
			$("#diastolic").val("");
			$("#diastolic").focus();
		}
	});
	$("#removeOPDisgnosis").click(
			function() {
				if ($("#diagnosisId option:selected").length > 1) {
					alert("You can delete only one option at a time !");
				} else {
					$("#diagnosisId option:selected").remove();
					deleteRowFromOPConsultationTab($(
							"#diagnosisId1 option:selected").index());
				}
			});
	$("#removeOPDisgnosis").click(
			function() {
				if ($("#diagnosisId option:selected").length > 1) {
					alert("You can delete only one option at a time !");
				} else {
					$("#diagnosisId option:selected").remove();
					deleteRowFromOPConsultationTab($(
							"#diagnosisId1 option:selected").index());
				}
			});
	$("#removeSnomed").click(function() {
		document.getElementById("snomed").value = '';
	});
	$("#icd").blur(function() {
		var code1 = {};

		$("select[name='diagnosisId'] > option").each(function() {
			if (code1[this.text]) {
				$(this).remove();
			} else {
				code1[this.text] = this.value;
			}
		});

	});
	$('#admissionAdvised').click(function() {
		$("#admDiv").toggle(this.checked);
	});

	$('#patient_expire').click(function() {
		var checked = $(this).is(':checked');
		$("#referral").val('0');
		if (checked) {
			if ($("#referral").val() == 0) {
				$("#referalDiv").hide();
				$("#referDiv").hide();
				$("#siftedToMortuaryDiv").show();
			}
		} else {
			$("#referalDiv").show();
			$("#referDiv").hide();
			$("#siftedToMortuaryDiv").hide();
		}
	});
	$('#referral').click(function() {
		var selVal = $("#referral").val();
		if (selVal == 0) {
			$("#referDiv").hide();
		} else if (selVal == 1) {
			$("#referDiv").show();
		}
	});
});

if (!''.trim) {
	String.prototype.trim = function() {
		return this.replace(/^\s+|\s+$/g, '');
	};
}



function fnGetInvestigationTemplate(tempId) {
	var result = "";
	var hinId=document.getElementById("hinId").value;
	for (var i = 0; i < tempId.options.length; i++) {
		opt = tempId.options[i];
		if (opt.selected) {
			result += opt.value + ",";
		}
	}
	/* alert("tempId==="+result);
	
	alert("hinid==="+ document.getElementById("hinId").value);
	
	alert("tempId.value==="+tempId.value); */
	
	if (tempId.value != 0) {
		submitProtoAjaxNew('labTestDermo',"/hms/hms/opd?method=getLabInvestigationTemplateDemotology&templateid="+result+"&hinId="+hinId+"&"+csrfTokenName+"="+csrfTokenValue, "labInvDiv");
	}
}

function checkTestTime(hinId,templateName,iteration)
{

	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; 

	var yyyy = today.getFullYear();
	if(dd<10){
	    dd='0'+dd;
	} 
	if(mm<10){
	    mm='0'+mm;
	} 
	var today = yyyy+'-'+mm+'-'+dd;	
	
  var xmlhttp;
  var testDate=document.getElementById('testDate' + iteration ).value;
  var tempDate=testDate.split('/');
    testDate = tempDate[2]+"-"+tempDate[1]+"-"+tempDate[0];
    
  var testTime=document.getElementById('testTime' + iteration ).value;
  var chargeCodeNameDermotology=document.getElementById('chargeCodeNameDermotology' + iteration ).value;
 
  var tempString = chargeCodeNameDermotology.split('[');
	var testName = tempString[0];
	if(testDate == today ){
   var url="/hms/hms/opd?method=checkForDuplicateExternalTest&templateName="+templateName+"&hinId="+hinId+"&testdate="+testDate+"&testName="+testName;
  if (window.XMLHttpRequest)
  {
      xmlhttp=new XMLHttpRequest();
  }
  else
  {
      xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  xmlhttp.onreadystatechange=function()
  {
      if (xmlhttp.readyState==4 && xmlhttp.status==200)
      {
    	  var res=xmlhttp.responseText;
    	  if(res.trim() == 'Yes')
    		  alert("Test Time is mandatory!!!");
        // alert(res);
      }
  }

  xmlhttp.open("GET", url, true);
  xmlhttp.send(); 
}
	// check for previous dates
	else { 
		if(iteration > 1 ){
		var i=iteration;
	    var testName = document.getElementById('chargeCodeNameDermotology' + iteration).value;
	    if(iteration > 1){
		while(iteration > 1){
			if(document.getElementById('chargeCodeNameDermotology' + iteration).value == testName){
				if(document.getElementById('testTime'+i).value==''){
				alert("Test time is mandatory!!!");
				return true;
				}
			}
			iteration--;
			} 
	    }
	}
}
	return;
}

</script>