<%@page import="jkt.hms.masters.business.ExternalLabReportCommon"%>
<%@page import="jkt.hms.masters.business.CommonLabTestReport"%>
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
<script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
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
Map<String,List<CommonLabTestReport>> commonLabTestReportsMap = new HashMap<String,List<CommonLabTestReport>>();
List<DgSampleCollectionDetails> dgSampleCollectionDetails= new ArrayList<DgSampleCollectionDetails>();
List<String> sortedTestdate = new ArrayList<String>();
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
			
			if(map.get("commonLabTestReportsMap") != null){
				commonLabTestReportsMap=(Map<String,List<CommonLabTestReport>>)map.get("commonLabTestReportsMap");
				}
			
			if(map.get("sortedTestdate") != null){
				sortedTestdate=(List<String>)map.get("sortedTestdate");
				}
			String templateName = "";
			
			if(map.get("templateFlag") != null){
				templateName=(String)map.get("templateFlag");
				}
			Boolean saved=false;
			 if (map.get("saved") != null)
		       {
		               saved = (Boolean) map.get("saved");
		       }
			 
		 %>

<form name="labTestDermo" action="" method="post">
<!-- Added For Investigation -->
<h2>Investigations</h2>
<div class="Block">
<h4>Previous Test Summary</h4>

<%if(sortedTestdate !=null && commonLabTestReportsMap.size()>0){ 
String testName = null;
%>
<label>Lab test report</label>
				<div class="tableForTab" style="width:910px">
					<div id="divTemplet2">
						<table border="0" align="center" cellpadding="0" cellspacing="0" id="OutSidelabResult">
							<tr>
								<th>Test Name</th>
							<%	int labFirstTrimIndex=0;
							for(; labFirstTrimIndex < sortedTestdate.size(); labFirstTrimIndex++ ){ %>
		     				<th> <%=HMSUtil.convertStringDateFormat(sortedTestdate.get(labFirstTrimIndex)) %> </th> 
		     				
		     				<%} %>
		     			</tr>	
							
							<%
								Iterator records = commonLabTestReportsMap.entrySet().iterator();
							    while (records.hasNext()) {
							    Map.Entry entry = (Map.Entry) records.next();
							    String key = (String)entry.getKey();
							%>			
							
		<tr>
		    <td style="width: 175px;"><input type="text" name="testN" value="<%=key%>"   readonly="readonly"  /></td>
		  
		   <%	
							    List <CommonLabTestReport> testDispList = new ArrayList<CommonLabTestReport>();
							    testDispList  = (ArrayList<CommonLabTestReport>)entry.getValue();
							    boolean result = false;
		                      for(int dateIndex=0; dateIndex < sortedTestdate.size(); dateIndex++ ){
		                    	  result = false;
		                    	  List<CommonLabTestReport> localList = new ArrayList<CommonLabTestReport>();
		                    	  for(CommonLabTestReport reportList : testDispList){		
									
									if(sortedTestdate !=null && sortedTestdate.get(dateIndex).equalsIgnoreCase(reportList.getResultDate())){result=true; 
									localList.add(reportList);
								  }
		                    	  }
		                      
									
									if (localList.size() == 1) {%>
										<%if(localList.get(0).getTestStatus()!=null && !localList.get(0).getTestStatus().equals("") && localList.get(0).getTestResult().equals("")) {%>
										<td> <a href="javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'<%=localList.get(0).getInvestigationId()%>','<%=localList.get(0).getResultDate()%>','<%=hinId%>','<%=localList.get(0).getResultTime() %>');">Lab Results</a> </td>
										<%}else if (localList.get(0).getTestStatus()!=null && !localList.get(0).getTestStatus().equals("") && localList.get(0).getTestStatus().equalsIgnoreCase("Abnormal")){ %>
										<td> <%=localList.get(0).getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>" %> </td>
										<%} else {%>							
								 <td> <%=localList.get(0).getTestResult().replaceFirst("^0+(?!$)", "") %> </td>
									<% }	}
									if (localList.size() ==0) {%>
										<td>-</td>	
			                    	
			                    	    
			                      <%}%> 
								<%if (localList.size() > 1) {%>
								<td>
									
								  <% String res="";String  hLink="";
								  for(CommonLabTestReport finalReport : localList){
									  String testResult="";
									  if(finalReport.getTestResult()==null || finalReport.getTestResult().equals("")){
										  if(!finalReport.getResultTime().equals("00:00"))
										    hLink = "<a href=".concat("\"").concat("javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'").concat(""+finalReport.getInvestigationId()).concat("'")
												   .concat(",").concat("'").concat(finalReport.getResultDate()).concat("'").concat(",").concat("'"+hinId).concat("'").concat(",'"+finalReport.getResultTime()+"'").concat(");").concat("\"").concat(">Lab Results - "+finalReport.getResultTime()+"</a>");
										      else
											    hLink = "<a href=".concat("\"").concat("javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'").concat(""+finalReport.getInvestigationId()).concat("'")
											   .concat(",").concat("'").concat(finalReport.getResultDate()).concat("'").concat(",").concat("'"+hinId).concat("'").concat(",'"+finalReport.getResultTime()+"'").concat(");").concat("\"").concat(">Lab Results</a>");  
										    
										res= res.concat("\n").concat(hLink);	 
									  }	
									  if(finalReport.getTestResult()!=null && !finalReport.getTestResult().equals("")){
										  if(!finalReport.getResultTime().equals("00:00")){
											  if(finalReport.getTestStatus().equalsIgnoreCase("Abnormal"))
											  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>"+"-"+finalReport.getResultTime();
											  else
												  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", "")+"-"+finalReport.getResultTime();
										  }else{
											  if(finalReport.getTestStatus().equalsIgnoreCase("Abnormal"))
											  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>";
											  else
												  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", "");  
										  }
										  res = res.concat(testResult).concat(", ");
									  }
									}%>
									 
								<%=res %>	
								</td>		
								<%}}} %>
									</tr>
									
									 
					</table>
					</div>
				</div>
				<%}else{ %>
						<span>No Test Record found</span>
						<%} %> 


<div class="clear"></div>

						<div class="paddLeft55">
							
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
										onchange="fnGetInvestigationTemplate(this,'<%=box.getString("templateFlag")%>');">
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
							<td valign="top">
								<div class="tableLeftP">
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
								<div class="tableForTab fixHeight" id="labInvDiv">
									<div id="divTemplet1">
										<table border="0" align="center" cellpadding="0"
											cellspacing="0" id="investigationGridDermotology">
											<tr>
												<th scope="col">&nbsp;</th>
												<th scope="col"><div style="width:95px;">Test Date</div></th>
												<th scope="col">Test Time <br/> (HH:MM)</th>
												<th scope="col">Test Name</th>
												<!-- <th>Investigation Date</th> -->
												<th scope="col">Test Result</th>
												<th scope="col">Abnormal</th>
												<!-- <th scope="col">Clinical Notes</th> -->
											</tr>
											<%int inc=1, len=2;
			
			Integer dtHids=0;Integer dtIds=0;Integer pInvHd=0;Integer pInvDt=0;	Integer pDgSHd=0;
			Integer dgSampleHdId=0;
			String avlStatus="";
			
				
			%>
											<tr>											
												<td>
													<%-- <%if(orderStatus.equalsIgnoreCase("p")) {%> <input
													type="checkbox" disabled="disabled" class="radioCheck"
													name="chargeRadioDermotology<%=inc %>" id="chargeRadioDermotology<%=inc %>" /> <%}else{ %> --%>
													<input type="checkbox" class="radioCheck"
													name="chargeRadioDermotology<%=inc %>" id="chargeRadioDermotology<%=inc %>" /> <%-- <%} %> --%>
													<%-- <input type="hidden" name="parkInvestigationIdDermotology<%=inc %>"
													id="parkInvestigationIdDermotology<%=inc %>"
													value="<%=dtIds%>-<%=pInvDt%>-<%=dgSampleId!=null?dgSampleId:"0" %>" /> --%>
													<input type="hidden" name="availableStatusDermotology<%=inc %>"
													id="availableStatus<%=inc %>" value="<%= avlStatus%>" />
												</td>
								        <td scope="col">
								        <input type="text" id="testDate<%=inc%>"  name="testDate<%=inc%>" tabindex="1" value="<%=currentDate %>"
										class="dateTextSmall" onblur="checkTrimDate('testDate<%=inc%>');" /> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"  tabindex="1"
										border="0" validate="Pick a date"
										onclick="setdate('<%=currentDate%>',document.getElementById('testDate<%=inc%>'),event);" /></td>
											
										<td>
								        <input type="text" id="testTime<%=inc%>"  name="testTime<%=inc%>" tabindex="1" value="" class="medium" maxlength="5" onkeypress="javascript:return isNumber(event);" onkeyup="mask(this.value,this,'2',':');" onblur="checkTime(this.id)"/></td>
										
											
												<td>
													 <input type="text"
													class="textYellow largTextBoxOpd popper" data-popbox="pop1"
													value="" id="chargeCodeNameDermotology<%=inc %>"
													size="65" name="chargeCodeNameDermotology<%=inc %>"
													onkeypress="checkTextColor('chargeCodeNameDermotology<%=inc%>');"
													onblur="getUnavailableInvestigationDermotology(<%=inc %>);checkInvestigationItemDermotology(<%=inc %>);getLoincSnomedListDermotology('<%=inc %>');if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxNew('labTestDermo','/hms/hms/opd?method=getSubParameterDetails&hinId=<%=visitId%>&rowVal=<%=inc %>&chargeCodeNameDermotology<%=inc %>='+this.value,'subParameterDiv<%=inc %>');submitProtoAjaxWithDivName('labTestDermo','/hms/hms/opd?method=fillChargeCodeDermatology&hinId=<%=visitId%>&rowVal=<%=inc %>','chargeCodeVal<%=inc %>');
													checkTestTime('<%=hinId %>','<%=templateName %>','<%=inc %>');}" />
													<%-- <%} %> --%>
													<input type="hidden" class="largTextBoxOpd textYellow" type="text" name="subInvestigationId<%=inc %>" id="subInvestigationId<%=inc %>" value="0" />

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
										
										
												<td><input type="input"
													class="largTextBoxOpd textYellow"  type="text"
													name="testResult<%=inc %>" id="testResult<%=inc %>" />
												</td>
												  <td> <input type="checkbox" class="radioCheck" value="y" name="resultStatus<%=inc %>" id="resultStatus<%=inc %>"  /> </td> 
												<!--  <td></td>  -->
											</tr>
											
											<tr id="subParameterDiv<%=inc %>"></tr>
										
										
											
											<%
									//} %>
										</table>
										<%-- <input type="text" name="increament" id="increament" value="<%=inc %>"/> --%>
										
									</div>
									<input type="hidden" name="hiddenValueDermotology" id="hiddenValueDermotology"
										value="<%=inc%>" /> <input type="hidden" name="toDate"
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

<input name="Save" type="button" class="button" value="Save" style="margin-left:10px; margin-top:0;" onclick="submitForm('labTestDermo','opd?method=saveOutSideResultEntryForDermotology');"/>
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
	var tbl = document.getElementById('investigationGridDermotology');
	//var count = parseInt(tbl.rows.length)+1;
	var count = parseInt(document.getElementById('hiddenValueDermotology').value)+parseInt(1);
	if (id == "") {
		document.getElementById('chargeCodeNameDermotology' + inc).value = "";
		// document.getElementById('chargeCode'+inc).value="";
		return;
	}
//alert("count==="+count);
//alert("inc==="+inc);
	for (var i = 1; i <= count; i++) {
		if (document.getElementById('chargeCodeNameDermotology' + i) != null 
				&& document.getElementById('chargeCodeNameDermotology' + i).value == strValue
				&& i != inc) {
			alert('This Investigation is already selected.');
			//document.getElementById('chargeCodeNameDermotology' + inc).value = "";
			// document.getElementById('chargeCode'+inc).value="";
			return true;
		}
	}
	return true;
}

/* function checkTestTime(iteration)
{
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
	return true;
} */

function checkResultValue(iteration){
	if(document.getElementById('testResult' + iteration).value== ''){
		alert("Test result can't be blank!!!");
		document.getElementById('chargeCodeNameDermotology' + iteration).value = "";
		return false;
	}
}

function checkResultValue(iteration){
	if(document.getElementById('testResult' + iteration).value== ''){
		alert("Test result can't be blank!!!");
		document.getElementById('chargeCodeNameDermotology' + iteration).value = "";
		return false;
	}
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
	var hinId=document.getElementById('hinId').value;
	var templateName=document.getElementById('templateFlag').value;
	//var iteration = lastRow;
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
	e0.onkeypress = function (event) {
		  javascript: return isNumber(event)
	};
	e0.onkeyup=function() { 
		mask(this.value,this,'2',':');
	}
	e0.onblur = function () {
		checkTime(this.id);
	};
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
		getUnavailableInvestigationDermotology(iteration);
		checkInvestigationItemDermotology(iteration);
		getLoincSnomedListDermotology(iteration);
		
		if (validateInvestigationAutoComplete(this.value, iteration)) {
			submitProtoAjaxNew('labTestDermo',
					"/hms/hms/opd?method=fillChargeCodeDermatology&hinId="
							+ document.getElementById("hinId").value
							+ "&rowVal=" + iteration+"&chargeCodeNameDermotology"+iteration+"="+this.value, 'chargeCodeVal'
							+ iteration);
			submitProtoAjaxNew('labTestDermo',
					"/hms/hms/opd?method=getSubParameterDetails&hinId="
							+ document.getElementById("visitId").value
							+ "&rowVal=" + iteration+"&chargeCodeNameDermotology"+iteration+"="+this.value, 'subParameterDiv'
							+ iteration);
			checkTestTime(hinId,templateName,iteration);
		}
	};
	e0.size = '65';
	e0.className = "textYellow largTextBoxOpd";
	cellRight0.appendChild(e0);
	
	var e11 = document.createElement('input');
	e11.type = 'hidden';
	e11.name = 'subInvestigationId' + iteration;
	e11.id = 'subInvestigationId' + iteration;
	e11.value= 0;
	e11.size = '15';
	cellRight0.appendChild(e11);

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

	var cellRight3 = row.insertCell(4);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name = 'testResult' + iteration;
	e0.id = 'testResult' + iteration;
	e0.size = '20';
	e0.className = "largTextBoxOpd textYellow";
	/* e0.onblur = function() {
		checkResultValue(iteration);
	}; */
	cellRight3.appendChild(e0);

	var sel = document.createElement('input');
	sel.type = 'hidden';
	sel.name = 'chargeCodeDermotology' + iteration;
	sel.id = 'chargeCodeDermotology' + iteration;
	sel.size = '15';
	cellRight3.appendChild(sel);
	
	
	var cellRight4 = row.insertCell(5);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'resultStatus' + iteration;
	e0.id = 'resultStatus' + iteration;
	e0.className = 'radioCheck';
	cellRight4.appendChild(e0);
	
	/* for sub parameters */
	 var lastRow = tbl.rows.length;
	//var iteration = lastRow;
	var iteration= document.getElementById('hiddenValueDermotology').value;
	var row = tbl.insertRow(lastRow);
	row.id='subParameterDiv'+iteration; 
	
	
}

function removeRowForInvestigationDermotology() {
	var subInvInc;
	var cnt;
	var tbl = document.getElementById('investigationGridDermotology');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hiddenValueDermotology');
	var iteration = parseInt(hdb.value);
	if(document.getElementById('subInvInc') != null){
	 subInvInc = document.getElementById('subInvInc').value;
	}
	if(document.getElementById('parameterSize') != null){
		 cnt = document.getElementById('parameterSize').value;
	}
	
	var totalSelected = 0;
	if (confirm("Do you want to delete !")) {
		//alert(iteration);
		for (var i = 0; i <= iteration; i++) {
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
			if(subInvInc > 0 && subInvInc != 'undefined'){
				 for (var i = 1; i <= iteration; i++) {
					if (document.getElementById("chargeRadioDermotology" + i) != null
							&& (typeof document.getElementById("chargeRadioDermotology" + i).checked) != 'undefined'
							&& document.getElementById("chargeRadioDermotology" + i).checked) {
						
						if(document.getElementById("subParameterDiv" + i))
							document.getElementById("subParameterDiv" + i).style.display='none';
						
					var totalSize=parseInt(i)+parseInt(cnt);		
				 for (var index = i; index <= totalSize; index++) {
					//if (document.getElementById("chargeRadioDermotology" + index) != null) {
								var deleteRow = document.getElementById("chargeRadioDermotology" + index).parentNode.parentNode;
								document.getElementById("chargeRadioDermotology" + index).parentNode.parentNode.parentNode
										.removeChild(deleteRow);
					//}
					}
				  
					
				  } 
				}
		
			}else{
				for (var i = 0; i <= iteration; i++) {
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



function fnGetInvestigationTemplate(tempId,templateName) {
	var result = "";
	var hinId=document.getElementById("hinId").value;
	for (var i = 0; i < tempId.options.length; i++) {
		opt = tempId.options[i];
		if (opt.selected) {
			result += opt.value + ",";
		}
	}

	
	if (tempId.value != 0) {
		submitProtoAjaxNew('labTestDermo',"/hms/hms/opd?method=getLabInvestigationTemplateDemotology&templateid="+result+"&hinId="+hinId+"&templateName="+templateName+"&"+csrfTokenName+"="+csrfTokenValue, "labInvDiv");
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

function checkTime(id){
	var value= document.getElementById(id).value;
	if(value != null && value != ''){
		var testTime = value.split(':');
		if(testTime[0] > 24){
			document.getElementById(id).value = "";
			alert("Invalid hours entered!!");
			return ;			
		}
		if(testTime[1] > 60){
			document.getElementById(id).value = "";
			alert("Invalid minutes entered!!");
			return ;			
		}
	}
	return;
}

</script>

<style>
.fixHeight{width:830px; min-height:290px; max-height:435px;}
.tableLeftP{float:left; padding-top:5px;}
.tableLeftP input[type='radio']{margin-top:-2px;}
.tableLeftP img{margin-top:-3px!important;}
</style>
	

