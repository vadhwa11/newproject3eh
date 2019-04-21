<%@page import="jkt.hms.masters.business.ExternalLabReportCommon"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/dentalSpeciality.js"></script>
<script type="text/javascript" src="/hms/jsp/js/prescription.js"></script>
<!-- by anamika -->
<script type="text/javascript" src="/hms/jsp/js/antenatal2.js"></script>


<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
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


<% 
Box box = HMSUtil.getBox(request);
Map<String, Object> map = new HashMap<String, Object>();
List <OpdTemplate> templateListForInvestigation = new ArrayList<OpdTemplate>();
List <ExternalLabReportCommon> externalLabListCommon = new ArrayList<ExternalLabReportCommon>();
List<DgSampleCollectionDetails> dgSampleCollectionDetails= new ArrayList<DgSampleCollectionDetails>();
List<DgOrderdt> dgOrderdts= new ArrayList<DgOrderdt>();
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
}
		
		    int hinId=0;
			int visitId=0;
			if(map.get("hinId")!=null)
			{
			hinId=(Integer)map.get("hinId"); 
			}
			if(map.get("visitId")!=null)
			{
				visitId=(Integer)map.get("visitId"); 
			}
		 		
			if(map.get("dgSampleCollectionDetails") != null)
			{
				dgSampleCollectionDetails=(List<DgSampleCollectionDetails>)map.get("dgSampleCollectionDetails");
			}
			if(map.get("dgOrderdts") != null)
			{
				dgOrderdts=(List<DgOrderdt>)map.get("dgOrderdts");
			}
			List<PatientInvestigationDetails> patientInvestigationDetails= new ArrayList<PatientInvestigationDetails>();
			if(map.get("patientInvestigationDetails") != null)
			{
				patientInvestigationDetails=(List<PatientInvestigationDetails>)map.get("patientInvestigationDetails");
			}
			if(map.get("templateListForInvestigation") != null){
				templateListForInvestigation=(List)map.get("templateListForInvestigation");
				}
			
			if(map.get("templateListForInvestigation") != null){
				templateListForInvestigation=(List)map.get("templateListForInvestigation");
				}
			if(map.get("externalLabListCommon") != null){
				externalLabListCommon=(List)map.get("externalLabListCommon");
				}
			Boolean saved=false;
			 if (map.get("saved") != null)
		       {
		               saved = (Boolean) map.get("saved");
		       }
		 %>

<form name="labTestDermo" action="" method="post">
<!-- Added For Investigation -->
<label>Investigations</label>
<div>
<h4>Previous Test Summary</h4>
<%if(externalLabListCommon.size()>0) {%>
<table id="dataDisplayTable" width="350px" border="1">
	<tr>			
			<th width="5%">Test Date</th>
			<th width="5%">Test Name</th>
			<!-- <th>Investigation Date</th> -->
			<th width="13%">Test Result</th>						
	</tr>
	<%for(ExternalLabReportCommon externalList:externalLabListCommon) {%>
		<tr>
			<td><input type="text" name="testDate" value="<%=externalList.getTestDate()!=null?externalList.getTestDate().toString():"" %>"   readonly="readonly" /></td>
			<td><input type="text" name="testN" value="<%=externalList.getTestName()!=null?externalList.getTestName():"" %>"   readonly="readonly" /></td>
		<%-- 	<td><input type="text" id="tentativeDate" class="small"
										 name="tentativeDate"
										validate="t1ntativeDate,string,no"
										readonly="readonly" /> <img src="/hms/jsp/images/cal.gif"
										width="16" height="16" border="0" validate="Pick a date"
										onclick="setdate('<%=currentDate%>',tentativeDate,event);" /></td> --%>
			<td> <input type="text" name="testR" value="<%=externalList.getTestResult()!=null?externalList.getTestResult():"" %>" readonly="readonly" /> </td>
		</tr>
		<%} %>
	</table>
<%} %>

</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block" >
						<div class="paddLeft55">
							<div>
								<div class="labelMargeDiv">
									<label class="small-medium" style="margin-right: 5px"><input
										type="radio" class="radioCheckCol2" name="invTempType"
										id="invTempType_local" onchange="getTemplate('local','i','');" />Local</label>
									<div class="clear"></div>
									<div class="clear"></div>
									<label class="small-medium" style="margin-right: 5px"><input
										type="radio" class="radioCheckCol2" name="invTempType"
										id="invTempType_global"
										onchange="getTemplate('global','i','');" />Global</label>
									<div class="clear"></div>
									<div class="clear"></div>
									<label class="small-medium" style="margin-right: 5px"><input
										type="radio" class="radioCheckCol2" name="invTempType"
										id="invTempType_global" onchange="getTemplate('all','i','');" />ALL</label>
								</div>
								<div class="paddLeft30">
									<select class="medium" multiple="5" style="height:77px;"
										name="tempLateInvestigation" id="tempLateInvestigation"
										onchange="fnGetInvestigationTemplate(this);">
										<option value="-1">Select</option>
										<%for(OpdTemplate opd:templateListForInvestigation){ %>
										<%if(opd.getTemplateType().equalsIgnoreCase("i")&& opd.getOpdTemplateInvestigations().size()>0){ %>
										<option value="<%=opd.getId()%>"><%=opd.getTemplateName() %></option>
										<%}%>
										<% } %>
									</select>
									<script type="text/javascript">
				var tempArrayTemp=new Array();
				<%int kIndex=0;
				 for(OpdTemplate opd:templateListForInvestigation){ %>
					<%if(opd.getTemplateType().equalsIgnoreCase("i")&&  opd.getOpdTemplateInvestigations().size()>0){ %>
					tempArrayTemp[<%=kIndex%>]= new Array();
					tempArrayTemp[<%=kIndex%>][0] = "<%=opd.getId()%>";
					tempArrayTemp[<%=kIndex%>][1] = "<%=opd.getTemplateName() %>";
					<%kIndex++;%>
					<%}%>
				<%}%>
				</script>
</div>
<%-- <input name="Prevoius" type="button" value="Last Investigation"
		class="buttonBig" onclick="openPopupForPatientInvestigation('<%=visitId%>','<%=hinId%>',csrfTokenName+'='+csrfTokenValue)" /> --%>
<input type="hidden" name="visitId" id="visitId" value="<%=box.getString("visitId")%>"/>
<input type="hidden" name="hinId" id="hinId" value="<%=box.getString("hinId")%>"/>
<input type="hidden" name="templateFlag" id="templateFlag" value="<%=box.getString("templateFlag")%>"/>
</div>
<div class="clear"></div>
</div>
					<div class="clear"></div>
					<div class="floatRight" style="margin-right: 10px;">
						<input type="button" class="buttonDel" alt="Delete" value="&nbsp;"
							onclick="removeRowForInvestigationDermotology();" /> <input type="button"
							class="buttonAdd" alt="Add" value="&nbsp;"
							onclick="addRowForInvestigationDermotology();" />
					</div>
					<table border="0" cellspacing="0" cellpadding="0" style="border-top:solid 1px #c0c0c0;">
						<tr>
							<td>
								<div>
									<input type="radio" value="Lab" class="radioCheckCol2"
										name="labradiologyCheckDermotology" checked="checked" onchange="" />LAB
									<div class="clear"></div>
									<input type="radio" value="Radio" class="radioCheckCol2"
										name="labradiologyCheckDermotology" onchange="" />Radiology <input
										type="hidden" name="investigationCategoryDermotology"
										id="investigationCategoryDermotology" />
									<div class="clear"></div>
									<img src="/hms/jsp/images/red_rectangle.jpg" width="14"
										height="14" />&nbsp;Service Not Available
								</div>
							</td>
							<td>
								<div class="tableForTab" style="width:828px; height:120px;"	id="labInvDiv">
									<div id="divTemplet1">
										<table border="0" align="center" cellpadding="0"
											cellspacing="0" id="investigationGridDermotology">
											<tr>
												<th scope="col">&nbsp;</th>
												<th scope="col">Test Date</th>
												<th scope="col">Test Name</th>
												<!-- <th>Investigation Date</th> -->
												<th scope="col">Test Result</th>
												<!-- <th scope="col">Clinical Notes</th> -->
											</tr>
											<%int inc=0, len=2;
			if(dgOrderdts.size()>0){
				len=dgOrderdts.size();
			}
			String chargeCodeName=""; 
			String chargeCodeNotes="";
			Integer dtHids=0;Integer dtIds=0;Integer pInvHd=0;Integer pInvDt=0;	Integer pDgSHd=0;
			Integer pDgSDt=0;String orderStatus="";	Integer dgSampleId=0;String clinicalNotes="";
			Integer dgSampleHdId=0;
			String avlStatus="";
			Map<Integer,Integer> dgSampleCollectionMap=new HashMap<Integer,Integer>();
			for(;inc<dgSampleCollectionDetails.size();inc++){
				DgSampleCollectionDetails sampleCollectionDetails=(DgSampleCollectionDetails) dgSampleCollectionDetails.get(inc);
				Integer chargeCodeId=sampleCollectionDetails.getChargeCode().getId();
				dgSampleId=sampleCollectionDetails.getId();
				dgSampleHdId=sampleCollectionDetails.getSampleCollectionHeader().getId();
				dgSampleCollectionMap.put(chargeCodeId, dgSampleId);
			}
				inc=0;
			for(;inc<len;inc++){
				if((dgOrderdts.size()>0 && patientInvestigationDetails.size()>0) && ((dgOrderdts.size() == patientInvestigationDetails.size()))){
					DgOrderdt dgOrderdt=dgOrderdts.get(inc);
					PatientInvestigationDetails  patientInvestigationDetail=patientInvestigationDetails.get(inc);
					chargeCodeName=dgOrderdt.getChargeCode().getChargeCodeName()+"["+dgOrderdt.getChargeCode().getId()+"]";
					orderStatus=dgOrderdt.getOrderStatus();
					
					dtHids=dgOrderdt.getOrderhd().getId();
					dtIds=dgOrderdt.getId();
					
					clinicalNotes=patientInvestigationDetail.getClinicalNotes();
					avlStatus=patientInvestigationDetail.getAvailableStatus();
					pInvHd=patientInvestigationDetail.getInvestigationHeader().getId();
					pInvDt=patientInvestigationDetail.getId();
					
					Integer chargeCodeId=dgOrderdt.getChargeCode().getId();
					dgSampleId=(Integer)dgSampleCollectionMap.get(chargeCodeId);
				}
			%>
											<tr>											
												<td>
													<%if(orderStatus.equalsIgnoreCase("p")) {%> <input
													type="checkbox" disabled="disabled" class="radioCheck"
													name="chargeRadioDermotology<%=inc %>" id="chargeRadioDermotology<%=inc %>" /> <%}else{ %>
													<input type="checkbox" class="radioCheck"
													name="chargeRadioDermotology<%=inc %>" id="chargeRadioDermotology<%=inc %>" /> <%} %>
													<input type="hidden" name="parkInvestigationIdDermotology<%=inc %>"
													id="parkInvestigationIdDermotology<%=inc %>"
													value="<%=dtIds%>-<%=pInvDt%>-<%=dgSampleId!=null?dgSampleId:"0" %>" />
													<input type="hidden" name="availableStatusDermotology<%=inc %>"
													id="availableStatus<%=inc %>" value="<%= avlStatus%>" />
												</td>
								        <td scope="col"><div style="float: left; width:115px;">
								        <input type="text" id="testDate<%=inc%>" name="testDate<%=inc%>" tabindex="1" value="<%=currentDate %>"
										class="dateTextSmall" onblur="checkTrimDate('testDate<%=inc%>');" /> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"  tabindex="1"
										border="0" validate="Pick a date"
										onclick="setdate('<%=currentDate%>',document.getElementById('testDate<%=inc%>'),event);" /></div></td>
											
											</td>
												<td>
													<%if(orderStatus.equalsIgnoreCase("p")) { %> <input
													readonly="readonly" type="text"
													class="textYellow largTextBoxOpd popper" data-popbox="pop1"
													value="<%=chargeCodeName %>" id="chargeCodeNameDermotology<%=inc %>"
													size="65" name="chargeCodeNameDermotology<%=inc %>"
													onkeypress="checkTextColor('chargeCodeNameDermotology<%=inc%>');"
													onblur="checkInvestigationItemDermotology(<%=inc %>);getLoincSnomedListDermotology('<%=inc %>');if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('labTestDermo','/hms/hms/opd?method=fillChargeCode&hinId=<%=visitId%>&rowVal=<%=inc %>','chargeCodeVal<%=inc %>');}" />
													<%}  else{ %> <input type="text"
													class="textYellow largTextBoxOpd popper" data-popbox="pop1"
													value="<%=chargeCodeName %>" id="chargeCodeNameDermotology<%=inc %>"
													size="65" name="chargeCodeNameDermotology<%=inc %>"
													onkeypress="checkTextColor('chargeCodeNameDermotology<%=inc%>');"
													onblur="getUnavailableInvestigationDermotology(<%=inc %>);checkInvestigationItemDermotology(<%=inc %>);getLoincSnomedList('<%=inc %>');if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('labTestDermo','/hms/hms/opd?method=fillChargeCode&hinId=<%=visitId%>&rowVal=<%=inc %>','chargeCodeVal<%=inc %>');}" />
													<%} %>

													<div id="ac2update<%=inc %>" style="display: none;"
														class="autocomplete"></div> <script type="text/javascript"
														language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeNameDermotology<%=inc %>','ac2update<%=inc %>','opd?method=getInvestigationListForAutoComplete',{minChars:3,
							  callback: function(element, entry) {
								  
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategoryDermotology').value;
						        },
							  parameters:'requiredField=chargeCodeNameDermotology<%=inc %>&fromOpd=fromOpd'});
				</script>
												</td>
										<%-- 		<td><input type="text" id="tentativeDate<%=inc%>" class="small"
										 name="tentativeDate<%=inc%>"
										validate="t1ntativeDate,string,no"
										readonly="readonly" /> <img src="/hms/jsp/images/cal.gif"
										width="16" height="16" border="0" validate="Pick a date"
										onclick="setdate('<%=currentDate%>',tentativeDate<%=inc%>,event);" /></td> --%>
												<td><input type="input"
													class="largTextBoxOpd textYellow" type="text"
													name="testResult<%=inc %>" id="testResult<%=inc %>" />
												</td>
												<%-- <td>
													<%if(orderStatus.equalsIgnoreCase("p")) {%> <input
													readonly="readonly" type="text"
													name="clinicalNotes<%=inc %>" value="<%=clinicalNotes %>"
													class="opdTextBoxSmall textYellow"
													id="clinicalNotes<%=inc %>" size="20" maxlength="45" /> <%}else{ %>
													<input type="text" name="clinicalNotes<%=inc %>"
													value="<%=clinicalNotes %>"
													class="opdTextBoxSmall textYellow"
													id="clinicalNotes<%=inc %>" size="20" maxlength="45" /> <%} %>
												</td> --%>
											</tr>
											<%
			} %>
										</table>
										<%-- <input type="text" name="increament" id="increament" value="<%=inc %>"/> --%>
										
									</div>
									<input type="hidden" name="hiddenValueDermotology" id="hiddenValueDermotology"
										value="<%=inc-1%>" /> <input type="hidden" name="toDate"
										id="todate" value="<%=currentDate%>" /> <input type="hidden"
										name="dhHeaderIds" id="dhHeaderIds"
										value="<%=dtHids%>-<%=pInvHd%>-<%=dgSampleHdId%>" />
								</div>
							</td>
						</tr>
					</table>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>

<input name="Save" type="button" class="button" value="Save" onclick="submitForm('labTestDermo','opd?method=saveOutSideResultEntryForAntenatal');"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<script>

if(<%=saved %>){
       window.close();	   
       }


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
	//e1.size = '8';
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
	
	var cellRight0 = row.insertCell(2);
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
					"/hms/hms/opd?method=fillChargeCode&hinId="
							+ document.getElementById("hinId").value
							+ "&rowVal=" + iteration, 'chargeCodeVal'
							+ iteration);
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
			return entry + '&labradiologyCheck='
					+ document.getElementById('investigationCategoryDermotology').value;
		},
		parameters : 'requiredField=chargeCodeNameDermotology' + iteration
				+ '&fromOpd=fromOpd'
	});

	var cellRight3 = row.insertCell(3);
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

}



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
				$('#investigationCategoryDermotology').val(
						$('input[name="labradiologyCheckDermotology"]:checked').val());
			});
	$('#investigationCategoryDermotology').val(
			$('input[name="labradiologyCheckDermotology"]:checked').val());
	
	
	$('input[name="pharmacyCheck"]').change(
			function() {
				$('#pharmacyCategory').val(
						$('input[name="pharmacyCheck"]:checked').val());
			});
	$('#investigationCategoryDermotology').val(
			$('input[name="labradiologyCheckDermotology"]:checked').val());
	

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

	/* $(".allownumericwithdecimal")
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
					}); */

	/* $(".allownumericwithoutdecimal").on(
			"keypress keyup blur",
			function(event) {
				$(this).val($(this).val().replace(/[^\d].+/, ""));
				if ((event.keyCode != 46) && ((event.keyCode != 37))
						&& ((event.keyCode != 39)) && (event.keyCode != 9)
						&& (event.keyCode != 8)
						&& (event.which < 48 || event.which > 57)) {
					event.preventDefault();
				}
			}); */

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

	
	if (tempId.value != 0) {
		submitProtoAjaxNew('labTestDermo',"/hms/hms/opd?method=getLabInvestigationTemplateDemotology&templateid="+result+"&hinId="+hinId+"&"+csrfTokenName+"="+csrfTokenValue, "labInvDiv");
	}
}


</script>
