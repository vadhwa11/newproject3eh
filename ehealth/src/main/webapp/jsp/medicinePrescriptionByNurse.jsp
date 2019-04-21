<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * clinicalSetup.jsp
	 * Purpose of the JSP -  This is for Clinical Setup
	 * @author  Deepali
	 * Create Date: 21st Feb,2008
	 * Revision Date:
	 * Revision By: Purpose
	 * @version 1.8
	--%>
<%@page import="jkt.hms.masters.business.BlPackageServicesDetails"%>
<%@page import="jkt.hms.masters.business.RsbyCardDetails"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/snomedLink.js" type="text/javascript"></script>
<script src="/hms/jsp/js/opd.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/tabcontentIn.js" type="text/javascript"></script>



<%

	Map map = new HashMap();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	 List<OpdTemplate> templateList = new   ArrayList<OpdTemplate>();
	  List<RouteOfAdministration> routeOfAdministrationList = new   ArrayList<RouteOfAdministration>();
	  List<OpdInstructionTreatment> masInstructionMasterList = new   ArrayList<OpdInstructionTreatment>();
	  List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	  List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
	  List<NursingcareSetup> nursingCareSetupList = new ArrayList<NursingcareSetup>();
	  List<RsbyCardDetails> rsbyCardDetailsList = new ArrayList<RsbyCardDetails>();
	  List<BlPackageServicesDetails> packageServicesList = new ArrayList<BlPackageServicesDetails>();
	  if(map.get("templateList") != null){
		  templateList = (List)map.get("templateList");
	  }
	  if(map.get("routeOfAdministrationList") != null){
		  routeOfAdministrationList = (List)map.get("routeOfAdministrationList");
	  }
	  if(map.get("masInstructionMasterList") != null){
		  masInstructionMasterList = (List)map.get("masInstructionMasterList");
	  }
	  if(map.get("frequencyList") != null){
		  frequencyList = (List)map.get("frequencyList");
	  }
	  if(map.get("nursingCareList") != null){
			nursingCareList = (List) map.get("nursingCareList");
	  }
	 if(map.get("nursingCareSetupList") != null){
		nursingCareSetupList = (List<NursingcareSetup>) map.get("nursingCareSetupList");
	 }
	 if(map.get("rsbyCardDetailsList") != null){
		 rsbyCardDetailsList = (List<RsbyCardDetails>) map.get("rsbyCardDetailsList");
	 }
	 if(map.get("packageServicesList") != null){
		 packageServicesList = (List<BlPackageServicesDetails>) map.get("packageServicesList");
	 }
	 
	 Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String) utilMap.get("currentTime");
		Inpatient inpatient = null;
		if(map.get("inpatient") != null){
		 inpatient=(Inpatient)map.get("inpatient");
		}
		
		Patient patient = new Patient();
		String patientName ="-";
		String consultantName = "-";
		String currentAge = "";
		String gender="-";
		String pCategory="";
		String materialStatus="";
		String admittedBy="-";
		String refferedBy="-";
		String address="";
		
		if(inpatient!=null){
			patient = inpatient.getHin();
			
			patientName=patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"");
			consultantName=inpatient.getDoctor().getRank()!=null?inpatient.getDoctor().getRank().getRankName():""+" "+ inpatient.getDoctor().getFirstName()+" "+(inpatient.getDoctor().getMiddleName()!=null?inpatient.getDoctor().getMiddleName():"")+" "+(inpatient.getDoctor().getLastName()!=null?inpatient.getDoctor().getLastName():"");	
			
			if(inpatient.getDoctor()!=null)
			{
				consultantName=inpatient.getDoctor().getFirstName();
				if(inpatient.getDoctor().getMiddleName()!=null)
				{
					consultantName +=" "+inpatient.getDoctor().getMiddleName();
				}
				if(inpatient.getDoctor().getLastName()!=null)
				{
					consultantName +=" "+inpatient.getDoctor().getLastName();
				}
			}
			
			if(inpatient.getOpdPatientDetails()!=null && inpatient.getOpdPatientDetails().getReferredDoctor()!=null)
			{
				admittedBy=inpatient.getOpdPatientDetails().getReferredDoctor().getFirstName();
				if(inpatient.getOpdPatientDetails().getReferredDoctor().getMiddleName()!=null)
				{
					admittedBy +=" "+inpatient.getOpdPatientDetails().getReferredDoctor().getMiddleName();
				}
				if(inpatient.getOpdPatientDetails().getReferredDoctor().getLastName()!=null)
				{
					admittedBy +=" "+inpatient.getOpdPatientDetails().getReferredDoctor().getLastName();
				}
			}
			if(inpatient.getOpdPatientDetails()!=null && inpatient.getOpdPatientDetails().getEmployee()!=null)
			{
				admittedBy=inpatient.getOpdPatientDetails().getEmployee().getFirstName();
				if(inpatient.getOpdPatientDetails().getEmployee().getMiddleName()!=null)
				{
					admittedBy +=" "+inpatient.getOpdPatientDetails().getEmployee().getMiddleName();
				}
				if(inpatient.getOpdPatientDetails().getEmployee().getLastName()!=null)
				{
					admittedBy +=" "+inpatient.getOpdPatientDetails().getEmployee().getLastName();
				}
			}
			String age = "";
			
			if(inpatient.getHin().getSex()!=null)
			{
				gender=inpatient.getHin().getSex().getAdministrativeSexName();
			}		
			
			if(inpatient.getHin().getMaritalStatus()!=null)
			{
				materialStatus=inpatient.getHin().getMaritalStatus().getMaritalStatusName();
			}else
			{
				materialStatus="-";
			}
			
			
			
			if(inpatient.getHin().getPatientType()!=null){
				pCategory = inpatient.getHin().getPatientType().getPatientTypeName();
			}
			else
			{
				pCategory="-";
			}
			
			

		    if(patient.getAge()!=null)
				age = patient.getAge();
			try{
				if(!age.equals(""))
				currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
			}catch(Exception ex){
				ex.printStackTrace();
			}
			session.setAttribute("inpatient",inpatient);
		}
%>

<script type="text/javascript" language="javascript">
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

<div class="titleBg">
	<h2>IP Prescription</h2>
</div>
<div class="clear"></div>
<form name="medicinePrescription" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div class="Block">
		<div class="paddingTop15"></div>
		<div class="clear"></div>
		<h4>patient Details</h4>
		<div class="clear"></div>

		<%@include file="PatientDetails.jsp"%>


		<div class="clear"></div>
		<div class="paddingTop25"></div>
		<div class="clear"></div>
		<input id="hinId" name="hinId" type="hidden"	value="<%=patient.getId()%>" />
			<input id="inpatientId" name="inpatientId" type="hidden"	value="<%=inpatient.getId()%>" />
			<input id="opdPatientDetailId" name="opdPatientDetailId" type="hidden"	value="<%=inpatient.getOpdPatientDetails() != null && inpatient.getOpdPatientDetails().getId() != null?inpatient.getOpdPatientDetails().getId():""%>" />
		<div class="clear"></div>
<%-- <input type="button" class="button"  value="Template" tabindex="27" style="margin-left:5px;">
<select class="medium" name="tempLatePrescription" id="tempLatePrescription" onchange="fnGetPrescriptionTemplate(this.value);" style="margin-top:8px;">
	<option value="0">Select</option>
	<%for(OpdTemplate opd:templateList){ %>
			<%if(opd.getTemplateType().equalsIgnoreCase("p")){ %>
				<option value="<%=opd.getId()%>"><%=opd.getTemplateName() %></option>
			<%} %>
	<%} %>
	
</select> --%>
<!-- <input  type="button" class="buttonBig" name="prev" value="Save As Template" onclick="openPopupForSavePrescriptiontamplate();" /> -->
<%-- <input name="Prevoius2" type="button" tabindex="28" class="buttonBig" value="Last Prescription"	onclick="openPopupForPatientPrescription('<%=visit.getVisitNo()%>','<%=visit.getHin().getId()%>')" />
 --%>

<!-- <div style="float: left;">
	<input type="button" class="button" value="Template" align="right" onclick="javascript:void(0);" >
	<input type="button" name="Reset" value="Save As Template" class="button" align="right" onclick="javascript:void(0);" style="font:bold 8px Arial, Helvetica, sans-serif;" >
		</div> -->	
<div class="clear"></div>
		<h4>Treatments</h4>
		<div class="clear"></div>		

<div class="clear"></div>
<!-- <div class="small" id="gridtreatmentDiv"> -->
<div class="clear"></div>
<div style="float: right;" >
	<input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addRowTreatment();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeRowTreatment();">
		</div>
<div class="clear"></div>
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="gridtreatment">
	<tr>
	    <th scope="col">&nbsp;</th>
		 <th scope="col">Item Name</th>
		<th scope="col">Dosage</th>
		<th scope="col">Unit</th>
		<th scope="col">Frequency</th>
		<!-- <th scope="col">No Of Days</th> -->
		<th scope="col">Duration</th>
		<th scope="col">Instruction</th>
		<th scope="col" >Special Instruction</th>
		<th scope="col">Route</th>
		<th scope="col">Total</th>
	</tr>
	
	<%
	int l =0;
		
	%>

	
	<%
			 l++;%>
	<tr>
	<td>
	    <input type="checkbox"  tabindex="1" id="itemRadiotreatment<%=l %>"  name="itemRadiotreatment<%=l %>" class="radioCheck"  />
	    </td>
		<td>
	    <input type="text" size="30" value="" tabindex="1" id="nomenclaturetreatment<%=l %>" size="70"  
	    name="nomenclaturetreatment<%=l %>" onblur="validatePrescriptionAutocompleteDM('opmainTM',this.value,<%=l %> );populatePVMS(this.value,'<%=l %>'); 
	     displayAu(this.value,'<%=l %>');checkForAllergy(this.value,<%=l %>);checkIPItem('<%=l%>');" onkeypress="checkTextColor('nomenclaturetreatment<%=l%>');" />
	   	<div id="ac2updatetreatment<%=l %>" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclaturetreatment<%=l %>','ac2updatetreatment<%=l %>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclaturetreatment<%=l %>'});
			</script>
	    </td>
		<td><input type="hidden" name="pvmsNotreatment<%=l %>" tabindex="1" id="pvmsNotreatment<%=l %>" value=""	size="10" readonly="readonly" />
				<input type="hidden" name="actualDispensingQty<%=l%>" tabindex="1" id="actualDispensingQty<%=l%>" value=""  size="6"  validate="AU,string,no" />
		
		<input type="text" name="dosagetreatment<%=l %>" tabindex="1" value="" id="dosagetreatment<%=l %>"	size="2" maxlength="5" onblur="fillTotalForTreatment('<%=l %>');checkFrequencyForTaperedDrugs(<%=l%>)" /></td>
		<td><input type="text" size="2" name="unittreatment<%=l %>" readonly="readonly" id="unittreatment<%=l %>" value="" class="smallest" />
		<!-- added by amit das on 19-11-2016 -->
		<input type="hidden" name="mixable<%=l%>" id="mixable<%=l%>" validate="mixable,string,no" />
																				
		<!-- added by amit das on 19-11-2016 -->
		<input type="hidden" name="mixtureQuantity<%=l%>" id="mixtureQuantity<%=l%>"  validate="mixtureQuantity,int,no" />
		<!-- added by amit das on 19-11-2016 -->
		<input type="hidden" name="actualTotalAfterMix<%=l%>" id="actualTotalAfterMix<%=l%>" validate="actualTotalAfterMix,float,no" />
		<input type="hidden" name="tapered<%=l%>" id="tapered<%=l%>"  validate="tapered,string,no" />
		<input type="hidden" name="mixtureUnit<%=l%>" id="mixtureUnit<%=l%>" validate="mixtureUnit,string,no" />
		</td>
		<td>
		<input type="hidden" name="frequencyValue<%=l%>" tabindex="1" id="frequencyValue<%=l%>" value=""  size="6"   />
		<input type="text" name="sosQty<%=l%>" tabindex="1" id="sosQty<%=l%>" style="display: none;"   size="3" onblur="fillValue(this.value,<%=l%>)"	maxlength="3" validate="Sos Qty,num,no" />
		<select name="frequencytreatment<%=l %>" id="frequencytreatment<%=l %>"  tabindex="1" 
<%--		 onblur="getFrequencyValue(this.value,<%=l%>);fillValueFromFrequency(this.value,<%=l%>);displaySOSQty(this.value,<%=l%>)" > //commented by govind 24-12-2016--%>
		 onchange="getFrequencyValue(this.value,<%=l%>);fillValueFromFrequency(this.value,<%=l%>);displaySOSQty(this.value,<%=l%>);displaFrequencyType(this,<%=l%>);checkFrequencyForTaperedDrugs(<%=l%>)" >
			<option value="0">Select</option>
			<%
		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
		       String type = masFrequency.getFrequencyType() != null?masFrequency.getFrequencyType():"";
          %>
			<option id="<%=type %>" value="<%=id %>"><%=name%></option>
			<%}%>
		</select> 
		
		</td>
		
<%--		<td><input type="text" class="smallest" name="noOfDaystreatment<%=l %>" tabindex="1" id="noOfDaystreatment<%=l %>" value="" onblur="fillTotalForTreatment('<%=l %>');"  size="2"	maxlength="3" validate="No. of Days,num,no" /> //commented by govind 24-12-2016--%>
		<td>
		<div style="width:100px; float: left;">
		<input type="text" class="smallest" name="noOfDaystreatment<%=l %>" tabindex="1" id="noOfDaystreatment<%=l %>" value="" onblur="fillValueFromFrequency(this.value,<%=l%>);"  oninput="fillValueFromFrequency(this.value,<%=l%>);" size="2"	maxlength="3" validate="No. of Days,num,no" />
		<p style="line-height:0px;" id="frequencyType<%=l %>" ></p>
		</div>			
		</td>
		
		<td><select name="instructiontreatment<%=l %>" id="instructiontreatment<%=l %>" class="smallest" tabindex="1"  >
			<option value="0">Select</option>
			<%
			for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
			{

		       int id = instructionTreatment.getId();
		       String name = instructionTreatment.getOpdInstructionTreatmentName();

          %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}
			%>
			
		</select> 
		
		</td>
		
		<td><input type="text" name="spslinstructiontreatment<%=l %>" tabindex="1" id="spslinstructiontreatment<%=l %>" value=""  size="15"	maxlength="50"  />
			
		</td>
		
		<td><select name="routetreatment<%=l %>" id="routetreatment<%=l %>" class="smallest" tabindex="1"  >
			<option value="0">Select</option>
			<%
				for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
		    	  
		       int id = routeOfAdministration.getId();
		       String name = routeOfAdministration.getRouteName();
		      
          %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}%>
		</select> 
		
		</td>
		
		<td><input type="text" class="smallest" name="totaltreatment<%=l %>" tabindex="1" id="totaltreatment<%=l %>" value=""   size="2"	maxlength="3" validate="Total,num,no" readonly="readonly" />
			
		</td>
		
		
	</tr>
<%-- <%} %> --%>
	<%
	//int l =0;
		/* if(ipdPrescriptionList.size() > 0){
			PatientPrescriptionHeader prescriptionHeader = ipdPrescriptionList.get(0);
			for(PatientPrescriptionDetails prescriptionDetails : prescriptionHeader.getPatientPrescriptionDetails()){ */
				//l++;
	%>	
	
	
</table>
	<input type="hidden" name="hdb" value="<%=l %>" id="hdbtreatment" />

<!-- </div> -->

<div class="clear"></div>
		<h4>Inestigations</h4>
		<div class="clear"></div>

 <% if(rsbyCardDetailsList!=null && rsbyCardDetailsList.size()!=0) {
	 %>
 	<label>Package Service</label>
 	<select id="pkgServiceId" name="pkgServiceId">
 		<option value="0">Select</option>
 		<% for(BlPackageServicesDetails blPackageServicesDetails : packageServicesList){ %>
 		<option value="<%=blPackageServicesDetails.getChargeCode().getCharge()%>"><%=blPackageServicesDetails.getChargeCode().getChargeCodeName()+"["+blPackageServicesDetails.getChargeCode().getId()+"]"%></option>
 		<% } %>
 	</select>
 	 <script type="text/javascript">
      <% 
			int count2 = 0;
			for (BlPackageServicesDetails blPackageServicesDetails  : packageServicesList) 
			{
				%>
				pkgServicesArray[<%=count2%>] = new Array();
				pkgServicesArray[<%=count2%>][0] = <%=blPackageServicesDetails.getPackageHeader().getId()%>;
				pkgServicesArray[<%=count2%>][1] = <%=blPackageServicesDetails.getChargeCode().getId()%>;
				pkgServicesArray[<%=count2%>][2] = "<%=blPackageServicesDetails.getChargeCode().getChargeCodeName()%>[<%=blPackageServicesDetails.getChargeCode().getId()%>]";
				pkgServicesArray[<%=count2%>][3] = <%=blPackageServicesDetails.getPackageHeader().getTotalValueOfPackage()%>;
				<%
				count2++;
				
			} %>
		</script>
 	
 <input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addPackageServiceIntoInvestigation();">
 <!-- Ended by Amit Das -->
 <% } %>
 
<%
int inc = 0;
%>
<div class="clear"></div>

		<div class="clear"></div>
<div style="">
		<label>LAB<input type="radio" value="Lab" class="" style="margin: 0px;padding: 0px;" name="labradiologyCheck" checked="checked" onchange="onChangeInvestigationDepartment();" onclick="onChangeInvestigationDepartment();"  /></label> 
		<label>Radiology<input type="radio" value="Radio" class="radioCheckCol2" name="labradiologyCheck" onchange="onChangeInvestigationDepartment();" onclick="onChangeInvestigationDepartment();" style="margin: 0px;padding: 0px;" /></label>
		<input type="hidden" value=""  name="investigationCategory" id="investigationCategory" />
	</div>

		<div class="clear"></div>
<div class="clear"></div>
<!-- <div class="small" id="investigationGridDiv"> -->
<div style="float: right;">
	<input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addRowForInvestigation();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeRowInvestigation();">
		</div>


<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
	<tr>
	<th scope="col">&nbsp; </th>
		<th scope="col">Test Name </th>
		<th scope="col">Clinical Note</th>
	</tr>
<%
inc++; %>

<tr>
		<td>
		<input type="checkbox"  class="radioCheck"  tabindex="1" id="investigationtradio<%=inc %>" size="70"  name="investigationtradio<%=inc %>" /></td>
		<td>
		<input type="text" value="" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="40" name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){disablePkgFlag('isPackageFlag<%=inc %>'); checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2<%=inc %>" style="display: none;" class="autocomplete">
		</div>
		
		<script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update2<%=inc%>','opd?method=getInvestigationListForAutoComplete&'+csrfTokenName+'='+csrfTokenValue,{minChars:3,
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>&fromOpd=fromOpd'});
				</script>
		<%-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update2<%=inc%>','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> --%> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty<%=inc %>"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode<%=inc %>" name="chargeCode<%=inc %>"
			size="10" readonly /> 

		</td>
		<td>
		<input type="text" name="chargecodeclinicalnote<%=inc %>"  id="chargecodeclinicalnote<%=inc%>" value="" />
		<input type="hidden" name="isPackageFlag<%=inc %>"  id="isPackageFlag<%=inc%>" value="n" />
		<input type="hidden" name="serviceSchemeId<%=inc %>"  id="serviceSchemeId<%=inc %>" value="" />
		<input type="hidden" name="pkgServiceCharge<%=inc %>"  id="pkgServiceCharge<%=inc %>" value="" />
		</td>
	</tr>

</table>
	<input type="hidden" value="<%=inc %>" name="hiddenValue" id="hiddenValue" />

<!-- </div> -->

<div class="clear"></div>
		<h4>Procedures</h4>
		<div class="clear"></div>
		
	<div class="clear"></div>
<div style="float: right;">
	<input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addRowForNursingcare();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeRowForNursingcare();">
		</div>
		<div class="clear"></div>

<table border="0" cellpadding="0" cellspacing="0" id="nursingcaretable">
								<tr>
								     <th>&nbsp;</th>
									<th>Nursing Care / Procedure</th>
									<th>Frequency</th>
									<th>Stop</th>
									<th>Remarks</th>
								</tr>
						<%	int countNursingCare=0; 
						
						countNursingCare++; %>

						
							<tr>
							<td>
							<input type="checkbox" class="radioCheck" id="radionursingcare<%=countNursingCare%>"  name="radionursingcare<%=countNursingCare%>"  />
							</td>
							<td width="27%"><select name="<%=CARE_TYPE_ID%><%=countNursingCare%>" id="<%=CARE_TYPE_ID%><%=countNursingCare%>" onblur="validateDuplicateNursingCare('1')">
											<option value="0">Select</option>
											<%
												for (Object masCareTypeObject : nursingCareList) {
													MasNursingCare masNursingCare=(MasNursingCare)masCareTypeObject;
											%>
											<option value="<%=masNursingCare.getId()%>">
											<%=masNursingCare.getNursingName()%>
											</option>
											<%
												}
											%>
									</select></td>
									<td width="27%"><select name="<%=FREQUENCY%><%=countNursingCare%>" id="<%=FREQUENCY%><%=countNursingCare%>"
										validate="Complaint,string,no">
											<option value="0">Select</option>
											<%
												for (MasFrequency masFrequency : frequencyList) {
											%>
											<option value="<%=masFrequency.getId()%>">
											<%=masFrequency.getFrequencyName()%>
											</option>
											<%
												}
											%>
									</select></td>
									<td><input type="checkbox" name="carestop<%=countNursingCare%>" id="carestop<%=countNursingCare%>" value="1" /> </td>
									<td><input type="text" name="<%=CARE_REMARKS%><%=countNursingCare%>" id="<%=CARE_REMARKS%><%=countNursingCare%>" /> </td>
							</tr>
							
							</tbody>
						</table>
	<input type="hidden" name="nursingcarecount" id="nursingcarecount" value="<%=countNursingCare%>"/>	
		

	</div>
	<input type="button" class="button" value="Submit" onClick="submitForm('medicinePrescription','ipd?method=submitMedicinePrescriptionByNurse');"	/>
	<script type="text/javascript">
	var	frequencyArray= new Array();
    <%
	MasFrequency  frequency = new MasFrequency();

    for (int k = 0; k < frequencyList.size(); k++) {
   	 frequency = (MasFrequency) frequencyList.get(k);
	 %>

	frequencyArray[<%=k%>]= new Array();
	frequencyArray[<%=k%>][0] = "<%=frequency.getId()%>";
	frequencyArray[<%=k%>][1] = "<%=frequency.getFrequencyName()%>";
	frequencyArray[<%=k%>][2] = "<%=frequency.getFrequencyType() != null?frequency.getFrequencyType():""%>";
	<% }%> 
	
	
	
	var	roteArray= new Array();
    <%
		RouteOfAdministration  route = new RouteOfAdministration();

	     for (int k = 0; k < routeOfAdministrationList.size(); k++) {
	    	 route = (RouteOfAdministration) routeOfAdministrationList.get(k);
		 %> 

		roteArray[<%=k%>]= new Array();
		roteArray[<%=k%>][0] = "<%=route.getId()%>";
		roteArray[<%=k%>][1] = "<%=route.getRouteName()%>";
		<% }%> 
		
		
		var	instructionArray= new Array();
        <%
        OpdInstructionTreatment  instructionMaster = new OpdInstructionTreatment();
		     for (int k = 0; k < masInstructionMasterList.size(); k++) {
		    	 instructionMaster = (OpdInstructionTreatment) masInstructionMasterList.get(k);
			 %> 
			instructionArray[<%=k%>]= new Array();
			instructionArray[<%=k%>][0] = "<%=instructionMaster.getId()%>";
			instructionArray[<%=k%>][1] = "<%=instructionMaster.getOpdInstructionTreatmentName()%>";
			<% }%> 
			var	nursingCareSetupList= new Array();
			<%

		     for (int k = 0; k < nursingCareList.size(); k++) {
		    	 MasNursingCare nursingCare = (MasNursingCare) nursingCareList.get(k);
			 %>

			nursingCareSetupList[<%=k%>]= new Array();
			nursingCareSetupList[<%=k%>][0] = "<%=nursingCare.getId()%>";
			nursingCareSetupList[<%=k%>][1] = "<%=nursingCare.getNursingName()%>";
			<% }%> 	
	
	function addRowTreatment(){
		var tbl = document.getElementById('gridtreatment');
		var lastRow = tbl.rows.length;
		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hdbtreatment');
		iteration = parseInt(hdb.value)+1;
		hdb.value=iteration;

		var cellRight1 = row.insertCell(0);
		var e1 = document.createElement('input');
		e1.type = 'checkbox';
		e1.name='itemRadiotreatment'+iteration;
		e1.id='itemRadiotreatment'+iteration;
		e1.className='radioCheck';
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='nomenclaturetreatment'+iteration;
		e1.id='nomenclaturetreatment'+iteration;
		e1.onblur=function(){populatePVMS(this.value,iteration); displayAu(this.value,iteration);checkForAllergy(this.value,iteration);/* checkItem(iteration),*/};
		e1.size='30'
		 e1.onblur=function(){
			populatePVMS(this.value,iteration); 
		     displayAu(this.value,iteration);
		     checkForAllergy(this.value,iteration);
		     checkIPItem(iteration);
		     validatePrescriptionAutocompleteDM('opmainTM',this.value,iteration );
		}; 

		cellRight1.appendChild(e1);
		var newdiv = document.createElement('div');
		newdiv.setAttribute('id', 'ac2updatestreatment'+iteration);
		newdiv.style.display = 'none';
		newdiv.className = "autocomplete";
		cellRight1.appendChild(newdiv);
		new Ajax.Autocompleter('nomenclaturetreatment'+iteration,'ac2updatestreatment'+iteration,'opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclaturetreatment'+iteration+'&countertreatment='+iteration});

		var cellRight1 = row.insertCell(2);
		
		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name='pvmsNotreatment'+iteration;
		e1.id='pvmsNotreatment'+iteration;
		cellRight1.appendChild(e1);
		
		
		 var e1 = document.createElement('input');
		 e1.type = 'hidden';
		 e1.name='actualDispensingQty'+iteration;
		 e1.id='actualDispensingQty'+iteration;
		 cellRight1.appendChild(e1);
		 
		 var e1 = document.createElement('input');
		 e1.type = 'hidden';
		 e1.name='mixable'+iteration;
		 e1.id='mixable'+iteration;
		 cellRight1.appendChild(e1);
		 
		 var e1 = document.createElement('input');
		 e1.type = 'hidden';
		 e1.name='mixtureQuantity'+iteration;
		 e1.id='mixtureQuantity'+iteration;
		 cellRight1.appendChild(e1);
		 
		 var e1 = document.createElement('input');
		 e1.type = 'hidden';
		 e1.name='actualTotalAfterMix'+iteration;
		 e1.id='actualTotalAfterMix'+iteration;
		 cellRight1.appendChild(e1);
		 
		 var e1 = document.createElement('input');
		 e1.type = 'hidden';
		 e1.name='mixtureUnit'+iteration;
		 e1.id='mixtureUnit'+iteration;
		 cellRight1.appendChild(e1);
		 
		 var e1 = document.createElement('input');
		 e1.type = 'hidden';
		 e1.name='tapered'+iteration;
		 e1.id='tapered'+iteration;
		 cellRight1.appendChild(e1);
		  
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='dosagetreatment'+iteration;
		e1.id='dosagetreatment'+iteration;
		e1.size='2';
		e1.onblur=function()
		{
			fillTotalForTreatment(iteration);checkFrequencyForTaperedDrugs(iteration);
		};
		/* e1.className='small'; */
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(3);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='unittreatment'+iteration;
		e1.id='unittreatment'+iteration;
		e1.size='2';
		/* e1.className='small'; */
		e1.readOnly='readOnly';
		cellRight1.appendChild(e1);
		

		var cellRight1 = row.insertCell(4);
		var e1 = document.createElement('Select');
		e1.name='frequencytreatment'+iteration;
		e1.id='frequencytreatment'+iteration;
		//e1.className='smallest';//changed by govind 24-12-2016
		e1.options[0] = new Option('Select', '0');
		 for(var i = 0;i<frequencyArray.length;i++ ){
			 var opt = document.createElement('option'); 
			 	opt.id = frequencyArray[i][2];
			 	opt.value = frequencyArray[i][0];
			    opt.innerHTML = frequencyArray[i][1];
			    e1.appendChild(opt);
		 
		//e1.options[frequencyArray[i][0]] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
		}
		e1.onblur=function()//changed by govind 24-12-2016
		// e1.onchange=function()
			{
			 getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);checkFrequencyForTaperedDrugs(iteration);
			}; 
			e1.onchange = function() {
				displaFrequencyType(this, iteration);	
			};
		cellRight1.appendChild(e1);
		var e21 = document.createElement('input');
		  e21.type = 'hidden';
		  e21.name='sosQty'+iteration;
		  e21.id='sosQty'+iteration;
		  e21.size='5';
		  e21.setAttribute('tabindex','1');
		  cellRight1.appendChild(e21);
		  
		  var e21 = document.createElement('input');
		  e21.type = 'hidden';
		  e21.name='frequencyValue'+iteration;
		  e21.id='frequencyValue'+iteration;
		  e21.size='5';
		  e21.setAttribute('tabindex','1');
		  cellRight1.appendChild(e21);

		var cellRight1 = row.insertCell(5);
		
		var e21Div = document.createElement('div');
		e21Div.style = 'width:100px; float: left;';
		
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='noOfDaystreatment'+iteration;
		e1.id='noOfDaystreatment'+iteration;
		e1.size='3';
		e1.onchange=function()
		{
			fillValueFromFrequency(this.value,iteration);
			fillTotalForTreatment(iteration);
		};
		e1.oninput=function()
		{
			fillValueFromFrequency(this.value,iteration);
			fillTotalForTreatment(iteration);
		};//changed by govind 24-12-2016 end
		e21Div.appendChild(e1);
		
		var ef21 = document.createElement('p');
		ef21.style = 'line-height:0px;';
		ef21.id = 'frequencyType' + iteration;
		e21Div.appendChild(ef21);
		cellRight1.appendChild(e21Div);
		//cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(6);
		var e1 = document.createElement('Select');
		e1.name='instructiontreatment'+iteration;
		e1.id='instructiontreatment'+iteration;
		e1.className='smallest';
		e1.options[0] = new Option('Select', '0');
		 for(var i = 0;i<instructionArray.length;i++ ){
				e1.options[instructionArray[i][0]] = new Option(instructionArray[i][1],instructionArray[i][0]);
				}
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(7);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.size = '15';
		e1.name='spslinstructiontreatment'+iteration;
		e1.id='spslinstructiontreatment'+iteration;
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(8);
		var e1 = document.createElement('Select');
		e1.name='routetreatment'+iteration;
		e1.id='routetreatment'+iteration;
		e1.className='smallest';
		e1.options[0] = new Option('Select', '0');
		 for(var i = 0;i<roteArray.length;i++ ){
				e1.options[roteArray[i][0]] = new Option(roteArray[i][1],roteArray[i][0]);
				}
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(9);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='totaltreatment'+iteration;
		e1.id='totaltreatment'+iteration;
		e1.size='2';
		/* e1.onblur=function()
		{
			fillTotalForTreatment(iteration);
		}; */
		cellRight1.appendChild(e1);


		}
		/* function removeRowTreatment()
		{
		var tbl = document.getElementById('gridtreatment');
		var lastRow = tbl.rows.length;
		if (lastRow > 2){
		tbl.deleteRow(lastRow - 1);
		var hdb = document.getElementById('hdbtreatment');
		hdb.value=hdb.value-1
		}
		} */
		
		function removeRowTreatment()
		{
		  var tbl = document.getElementById('gridtreatment');
		  var lastRow = tbl.rows.length;
		  var hdb = document.getElementById('hdbtreatment');
		  var iteration = parseInt(hdb.value);
		  var totalSelected=0;
		  for(var i=1;i<=iteration;i++)
			  {
			  if(document.getElementById("itemRadiotreatment"+i)!=null && (typeof  document.getElementById("itemRadiotreatment"+i).checked)!='undefined' && document.getElementById("itemRadiotreatment"+i).checked )
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
				  if(document.getElementById("itemRadiotreatment"+i)!=null && (typeof  document.getElementById("itemRadiotreatment"+i).checked)!='undefined' && document.getElementById("itemRadiotreatment"+i).checked )
		    		  {
		    		  var deleteRow= document.getElementById("itemRadiotreatment"+i).parentNode.parentNode;
		    		  document.getElementById("itemRadiotreatment"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
		    		  }
		    	  }
		    	 /*  for(var i=1;i<document.getElementById('grid').rows.length;i++)
		    		  {
		    		  document.getElementById('grid').rows[i].cells[0].innerHTML=i;
		    		  } */
		  }
		}
		
	
	
		function populatePVMS(val,inc){
			if(val != "")
			{
			    var index1 = val.lastIndexOf("[");
			    var indexForBrandName=index1;
			    var index2 = val.lastIndexOf("]");
			    index1++;
			    var pvmsNo = val.substring(index1,index2);
			    var indexForBrandName=indexForBrandName--;
			    var brandName=val.substring(0,indexForBrandName);

			  if(pvmsNo == "")
			  {
			   	document.getElementById('nomenclaturetreatment'+inc).value="";
			    document.getElementById('pvmsNotreatment'+inc).value="";
			    document.getElementById('dosagetreatment'+inc).value="";
			      document.getElementById('noOfDaystreatment'+inc).value="";
			      document.getElementById('unittreatment'+inc).value="";
			   return;
			   }
			   else
				   {
			      document.getElementById('pvmsNotreatment'+inc).value=pvmsNo;
			      document.getElementById('dosagetreatment'+inc).value=1;
			      document.getElementById('noOfDaystreatment'+inc).value=1;
			      
			      new Ajax.Request('ipd?method=updateItemUnit&pvmsNo='+pvmsNo+'&'+csrfTokenName+'='+csrfTokenValue, {
			    	  onSuccess: function(response) {
			    	      if(response.responseText.trim()!='')
			    	    	  {
			    	    	  var str=response.responseText.trim().split("###");
			    	    	  document.getElementById('unittreatment'+inc).value=str[0];
			    	    	  document.getElementById('routetreatment' + inc).value = str[2]!=undefined?str[2]:"0";
			    	    	  
			    				 //added by govind on 27-10-2017 for Tapered Medicine
			    	    	  document.getElementById('tapered' + inc).value = str[3]!=undefined?str[3]:"n";
								if(document.getElementById('tapered' + inc)!=null && document.getElementById('tapered' + inc).value=='y' ){
									var nomenclature=document.getElementById('nomenclaturetreatment' + inc).value;
									var index1 = nomenclature.lastIndexOf("[");
									var index2 = nomenclature.lastIndexOf("]");
									index1++;
									var id = nomenclature.substring(index1, index2);
									var count = document.getElementById('hdbtreatment').value;
									var alrady=0;
									for (var i = 0; i < count; i++) {
										if (document.getElementById('nomenclaturetreatment' + i) != null
												&& document.getElementById('nomenclaturetreatment' + i).value == nomenclature
												&& i != inc) {
												alert('This Prescription is already selected.');
												alrady++;
												document.getElementById('nomenclaturetreatment' + inc).value = "";
										}
										
									}
									/*var alPres= document.getElementById('alreadyPres' + inc).value;
									if(alPres=="Y"){
										alrady++;
									}*/
									if(alrady==0){
										var first = nomenclature.lastIndexOf("(");
										var second = nomenclature.lastIndexOf(")");
										first++;
										var itemId = val.substring(first, second);
										//alert("itemId "+itemId);
										var url = '/hms/hms/opd?method=showTaperdMedicine&nomenclature='+itemId+'&row='+inc+'&type=IP'+'&' + csrfTokenName + '='
										+ csrfTokenValue;
										openTaperedMedicine(url);
									}
								}
								 //added by govind on 27-10-2017 for Tapered Medicine end
			    	    	  }
			    	  }
			    	});
			 }
			}
			else
				{
				document.getElementById('nomenclaturetreatment'+inc).value="";
			    document.getElementById('pvmsNotreatment'+inc).value="";
			    document.getElementById('dosagetreatment'+inc).value="";
			      document.getElementById('noOfDaystreatment'+inc).value="";
			      document.getElementById('unittreatment'+inc).value="";
			      }
		}
	
	
	
		 function displayAu(val,inc){
	         if(val != "")
	         {
	             var index1 = val.lastIndexOf("[");
	             var indexForBrandName=index1;
	             var index2 = val.lastIndexOf("]");
	             index1++;
	             var pvmsNo = val.substring(index1,index2);
	             var indexForBrandName=indexForBrandName--;
	             var brandName=val.substring(0,indexForBrandName);
			      if(pvmsNo == "")
			      {
			        document.getElementById('nomenclaturetreatment'+inc).value="";
			        document.getElementById('pvmsNotreatment'+inc).value="";
			       return;
			       }
			       else
			            var xmlHttp;
			              try {
			                // Firefox, Opera 8.0+, Safari
			                xmlHttp=new XMLHttpRequest();
			              }catch (e){
			                // Internet Explorer
			                try{
			                  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			                }catch (e){
			                        alert(e)
			                  try{
			                    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			                  }catch (e){
			                    alert("Your browser does not support AJAX!");
			                    return false;
			                  }
			                 }
			               }
			            
			                xmlHttp.onreadystatechange=function()
			                {
			                  if(xmlHttp.readyState==4){
			                          var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
			                          for (loop = 0; loop < items.childNodes.length; loop++) {
			                                   var item = items.childNodes[loop];
			                                
			                            var au  = item.getElementsByTagName("au")[0];
			                            var actualDispensingQty = item.getElementsByTagName("actualDispensingQty")[0];
			                            var stock = item.getElementsByTagName("stock")[0];
			                            
			                         // added by amit das on 19-11-2016
			        					var mixable = item.getElementsByTagName("mixable")[0];
			        					var mixtureQuantity = item.getElementsByTagName("mixtureQuantity")[0];
			        					var mixtureUnit = item.getElementsByTagName("mixtureUnit")[0];
			        					var tapered = item.getElementsByTagName("tapered")[0];
			        					
			                            
			                            if(document.getElementById('au'+inc) && au.childNodes[0] != undefined ){
			                                    document.getElementById('au'+inc).value = au.childNodes[0].nodeValue;
			                            }
			                         /*    if(document.getElementById('closingStock'+inc) && stock.childNodes[0] != undefined){
			                                    document.getElementById('closingStock'+inc).value = stock.childNodes[0].nodeValue;
			                                    if(stock.childNodes[0].nodeValue == 0){
			                                       alert("Stock is not available...");
			                                    }
			                            }else{
			                            } */
			                            if(document.getElementById('actualDispensingQty'+inc)){
			                            if(actualDispensingQty.childNodes[0]!=undefined){
			                                    document.getElementById('actualDispensingQty'+inc).value = actualDispensingQty.childNodes[0].nodeValue;
			                            }else{
			                                    document.getElementById('actualDispensingQty'+inc).value = 0;
			
			                            }
			                            }
			                            var dangerousDrug = item.getElementsByTagName("dangerousDrug")[0];
			                            if(dangerousDrug.childNodes[0]!=undefined && dangerousDrug.childNodes[0].nodeValue == 'y'){
			                                    alert("This drug is dangerous.");
			                            }
			                            
			                        	// added by amit das on 19-11-2016
			        					if (document.getElementById('mixable' + inc)
			        							&& mixable.childNodes[0] != undefined) {
			        						document.getElementById('mixable' + inc).value = mixable.childNodes[0].nodeValue;
			        					}
			        					// added by amit das on 19-11-2016
			        					if (document.getElementById('mixtureQuantity' + inc)
			        							&& mixtureQuantity.childNodes[0] != undefined) {
			        						document.getElementById('mixtureQuantity' + inc).value = mixtureQuantity.childNodes[0].nodeValue;
			        					}
			        					
			        					// added by amit das on 19-11-2016
			        					if (document.getElementById('mixtureUnit' + inc)
			        							&& mixtureUnit.childNodes[0] != undefined) {
			        						document.getElementById('mixtureUnit' + inc).value = mixtureUnit.childNodes[0].nodeValue;
			        					}
			        					if (document.getElementById('tapered' + inc)
			        							&& tapered.childNodes[0] != undefined) {
			        						document.getElementById('tapered' + inc).value = tapered.childNodes[0].nodeValue;
			        					}
			                          }
			                  }
			                 }
			                var url="/hms/hms/opd?method=displayAU&pvmsNo="+pvmsNo;
				    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
			                xmlHttp.open("GET",url,true);
			                xmlHttp.setRequestHeader("Content-Type", "text/xml");
			                xmlHttp.send(null);
			            }
	  }
		 
		 function  fillValue(value,inc){
			  var dosage = document.getElementById('dosagetreatment'+inc).value;;
			  var freq=document.getElementById('frequencyValue'+inc).value;
			  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
			  var noOfDays = document.getElementById('noOfDaystreatment'+inc).value;;
			  var sosQty = document.getElementById('sosQty'+inc).value;
			  var total = freq*noOfDays*dosage;
			  var finalQty;
			  if(document.getElementById('frequencytreatment'+inc).value != 13 ){
			  if(document.getElementById('actualDispensingQty'+inc).value != 0){
				  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
				  if(totalQty != '0.00'){
					  finalQty = Math.ceil(totalQty);
				  }
				  document.getElementById('totaltreatment'+inc).value=Math.round(finalQty);
				 }else{
					  document.getElementById('totaltreatment'+inc).value=Math.round(freq*value*dosage);
				  }
			  }else{
				  if(document.getElementById('actualDispensingQty'+inc).value != 0){
					  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
					  if(totalQty != '0.00'){
						  finalQty = Math.ceil(totalQty);
					  }
					  document.getElementById('totaltreatment'+inc).value=Math.round(finalQty);
					 }else{
						  document.getElementById('totaltreatment'+inc).value=Math.round(freq*sosQty*dosage);
					  }
			  }
			 }
		
			/*
			 var freq=document.getElementById('frequency'+inc2).value;
		     var noOfDays=document.getElementById('noOfDays'+inc2).value;
		     var dosage=document.getElementById('dosage'+inc2).value;
		     document.getElementById('total'+inc2).value=freq*dosage*noOfDays;
		     
		     document.getElementById('noOfDayspTab'+inc2).value=noOfDays;
		     document.getElementById('frequencypTab'+inc2).value=freq;
		     document.getElementById('frequencypTab'+inc2).text=document.getElementById('frequency'+inc2).text;
		     document.getElementById('totalpTab'+inc2).value=freq*dosage*noOfDays;
			*/
		
			function displaySOSQty(val,inc){
			if(val == '13'){
				document.getElementById('sosQty'+inc).style.display = 'block';
				document.getElementById('noOfDaystreatment'+inc).disabled = true;
			 }else{
			  document.getElementById('sosQty'+inc).style.display  = 'none';
			  document.getElementById('noOfDaystreatment'+inc).disabled = false;
			 }
			}
		
			function getFrequencyValue(feqValue,inc){
					var feqQty;
					<%
					if(frequencyList.size()>0){	
						for(MasFrequency masFrequency :frequencyList){
					%>
					 if(feqValue == '<%=masFrequency.getId()%>'){
						 feqQty = '<%=masFrequency.getFrequencyCount()%>'
					  }
			
					<%}
					}%>
					 document.getElementById('frequencyValue'+inc).value = feqQty;
				}
			
			 function  fillValueFromFrequency(value,inc){
			   	  var dosage = document.getElementById('dosagetreatment'+inc).value;
				  var noOfDays=document.getElementById('noOfDaystreatment'+inc).value
				  var freq=document.getElementById('frequencyValue'+inc).value
				  document.getElementById('totaltreatment'+inc).value=Math.round(noOfDays*freq*dosage)
				  var dispenseQty = document.getElementById('actualDispensingQty'+inc).value;
			   	  var sosQty = document.getElementById('sosQty'+inc).value;
				  var total = freq*noOfDays*dosage;
				  var finalQty;
				  if(document.getElementById('frequencytreatment'+inc).value != 13 ){
				  if(document.getElementById('actualDispensingQty'+inc).value != 0){
					  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
					  if(totalQty != '0.00'){
						  finalQty = Math.ceil(totalQty);
					  }
					  document.getElementById('totaltreatment'+inc).value=Math.round(finalQty);
					  document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
					 }else{
						  document.getElementById('totaltreatment'+inc).value=Math.round(noOfDays*freq*dosage);
					  }
				  }else{
					  if(document.getElementById('actualDispensingQty'+inc).value != 0){
						  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
						  if(totalQty != '0.00'){
							  finalQty = Math.ceil(totalQty);
						  }
						  document.getElementById('totaltreatment'+inc).value=Math.round(finalQty);
					
						 }else{
							  document.getElementById('totaltreatment'+inc).value=Math.round(sosQty*freq*dosage);
						  }
				  }
				 } 
			 
			 
			 function checkFrequencyForTaperedDrugs(inc){
					var count = document.getElementById('hdbtreatment').value;
					
				
					for (var i = 0; i < count; i++) {
						
						if (document.getElementById('nomenclaturetreatment' + i) != null
								&& document.getElementById('nomenclaturetreatment' + i).value == document.getElementById('nomenclaturetreatment' + inc).value
								&& i != inc) {
							
								if(document.getElementById('frequencytreatment' + i).value!='0' &&  document.getElementById('dosagetreatment' + i).value!=''){
									
									if(document.getElementById('frequencytreatment' + i).value==document.getElementById('frequencytreatment' + inc).value && document.getElementById('dosagetreatment' + i).value==document.getElementById('dosagetreatment' + inc).value){
										alert('This Prescription is already selected with same dosage and frequency.');
										document.getElementById('frequencytreatment' + inc).value = "0";
										return false;
								}
								
							}
						}
					}
					return true;
				}
			 
			 function  fillTotalForTreatment(inc){
				
				    if(!isNaN(document.getElementById('noOfDaystreatment'+inc).value) 
				    		&& !isNaN(document.getElementById('dosagetreatment'+inc).value)
				    		&& !isNaN(document.getElementById('frequencytreatment'+inc).value) 
				    		&& document.getElementById('frequencytreatment'+inc).value>0)
				    	{
				    	// added by amit das on 19-11-2016
				    	if(document.getElementById('mixable' + inc)!=null){
						var mixable = document.getElementById('mixable' + inc).value;
				    	}
						if(document.getElementById('mixable' + inc)!=null){
						var mixtureUnit = document.getElementById('mixtureUnit' + inc).value;
						}
						if(document.getElementById('mixable' + inc)!=null){
						var mixtureQuantity = document.getElementById('mixtureQuantity' + inc).value;
						}
						if(document.getElementById('mixable' + inc)!=null){
						var dispenseQty = document.getElementById('actualDispensingQty' + inc).value;
						}
				    	var selectedFrequency=0;
				    		 for(var i = 0;i<frequencyArray.length;i++ ){
				    			 if(frequencyArray[i][0]==document.getElementById('frequencytreatment'+inc).value)
				    				 {
				    				 selectedFrequency=frequencyArray[i][2];
				    				 break;
				    				 }
				    			}
				    		 if(selectedFrequency!=0)
				    			 {
				    			// condition added by amit das on 19-11-2016 
				 				if(mixable=='Y'){
				 				//	var solutionMixAmount =  parseFloat(diluteLiquidQuantity) + parseFloat(dispenseQty);
				 					actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity)) * parseFloat(document.getElementById('noOfDaystreatment'+inc).value*document.getElementById('dosagetreatment'+inc).value*selectedFrequency);
				 					if(actualFinalQty != '0.00'){
				 						finalQty = parseFloat(actualFinalQty) / parseFloat(dispenseQty);
				 					}
				 					document.getElementById('totaltreatment' + inc).value = document.getElementById('noOfDaystreatment'+inc).value*document.getElementById('dosagetreatment'+inc).value*selectedFrequency;
				 					document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
				 					
				 				} else {
				    			 document.getElementById('totaltreatment'+inc).value=Math.round(document.getElementById('noOfDaystreatment'+inc).value*document.getElementById('dosagetreatment'+inc).value*selectedFrequency); 
				 				} 
				 				}
				    	}
				 }
			 
			 
			 function validatePrescriptionAutocompleteDM(flag, strValue, inc) {
					if (flag == 'opmain') {
						var index1 = strValue.lastIndexOf("[");
						var index2 = strValue.lastIndexOf("]");
						index1++;
						var id = strValue.substring(index1, index2);
						var count = document.getElementById('DMhdbtreatment').value;
						if (id == "") {
							document.getElementById('DMnomenclaturetreatment' + inc).value = "";
							return;
						}
						for (var i = 0; i < count; i++) {
							if (document.getElementById('DMnomenclaturetreatment' + i) != null
									&& document.getElementById('DMnomenclaturetreatment' + i).value == strValue
									&& i != inc) {
								if(document.getElementById('tapered' + i)!=null && document.getElementById('tapered' + i).value!='y' ){
									alert('This Prescription is already selected.');
									document.getElementById('DMnomenclaturetreatment' + inc).value = "";
									return false;
								}
							}
						}
						return true;
					} 
					if (flag == 'opmainTM') {
						var index1 = strValue.lastIndexOf("[");
						var index2 = strValue.lastIndexOf("]");
						index1++;
						var id = strValue.substring(index1, index2);
						var count = document.getElementById('hdbtreatment').value;
						if (id == "") {
							document.getElementById('nomenclaturetreatment' + inc).value = "";
							return;
						}
						for (var i = 0; i < count; i++) {
							if (document.getElementById('nomenclaturetreatment' + i) != null
									&& document.getElementById('nomenclaturetreatment' + i).value == strValue
									&& i != inc) {
								if(document.getElementById('tapered' + i)!=null && document.getElementById('tapered' + i).value!='y' ){
								alert('This Prescription is already selected.');
								document.getElementById('nomenclaturetreatment' + inc).value = "";
								return false;
								}
							}
						}
						return true;
					} 

				}
			 
			 function checkForAllergy(val,inc){
					//alert(val+"<<<-------val======inc------>>"+inc);
					var visitId=<%=inpatient.getHin().getId()%>;
					//alert("visitId---->>>>"+visitId);
					var id;
					if(val!=""){

						  var xmlHttp;
						  try {
						    // Firefox, Opera 8.0+, Safari
						    xmlHttp=new XMLHttpRequest();
						  }catch (e){
						    // Internet Explorer
						    try{
						      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
						    }catch (e){
						    	alert(e)
						      try{
						        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
						      }catch (e){
						        alert("Your browser does not support AJAX!");
						        return false;
						      }
						     }
						   }

						xmlHttp.onreadystatechange=function()
						{
						  if(xmlHttp.readyState==4){
							var b="false";
						  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
						  	for (loop = 0; loop < items.childNodes.length; loop++) {
						   	    var item = items.childNodes[loop];
						         icdString  = item.getElementsByTagName('allergyString')[0];
						      //  alert("icdString"+icdString);
						         b =icdString.childNodes[0].nodeValue
						      // alert("b-->>"+b);
						       
						        // var val=document.getElementById('icd').value;
						         var index1 = val.lastIndexOf("[");
								    var index2 = val.lastIndexOf("]");
								    index1++;
								    id = val.substring(index1,index2);
								  //  alert("id------>>>"+id);
								    if(id ==""){
									  return;
									}
								  
								    if(b=='true'){
										   alert("Patient is allergic to this message!!");
										   document.getElementById('nomenclaturetreatment'+inc).value="";
									   }
								    }
									
						  }
						  }
						//var url="/hms/hms/opd?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
						  	
						 
								var url="/hms/hms/ipd?method=getItemForAllergy&val="+val+"&visitId="+visitId;
					    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
						xmlHttp.open("GET",url,true);
						xmlHttp.setRequestHeader("Content-Type", "text/xml");
						xmlHttp.send(null);

							
					}
				}
	
			 function checkIPItem(cnt) {
					//alert("govind checkIPItem");
					var tbl = document.getElementById('gridtreatment');
					var lastRow = tbl.rows.length;
					var iteration = lastRow - 1;

					// var pvmsNo=document.getElementById("pvmsNo"+iteration).value
					//var visitId = document.getElementById("visitId").value
					var nomenclature = document.getElementById("nomenclaturetreatment" + cnt).value;
					var index1 = nomenclature.lastIndexOf("[");
					var indexForBrandName = index1;
					var index2 = nomenclature.lastIndexOf("]");
					index1++;

					var pvmsNo = nomenclature.substring(index1, index2);
					var prescriptionName = nomenclature.substring(0, (index1 - 1));
					if (pvmsNo != "") {

						var xmlHttp;
						try {
							// Firefox, Opera 8.0+, Safari
							xmlHttp = new XMLHttpRequest();
						} catch (e) {
							// Internet Explorer
							try {
								xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
							} catch (e) {
								alert(e)
								try {
									xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
								} catch (e) {
									alert("Your browser does not support AJAX!");
									return false;
								}
							}
						}

						xmlHttp.onreadystatechange = function() {
							if (xmlHttp.readyState == 4) {
								jQuery(function($) {
									var items = xmlHttp.responseXML
											.getElementsByTagName('items')[0];
									var items = xmlHttp.responseXML
											.getElementsByTagName('items')[0];
									for (loop = 0; loop < items.childNodes.length; loop++) {
										var item = items.childNodes[loop];
										var stockStstus = item.getElementsByTagName("stock")[0];
										if (stockStstus.childNodes[0].nodeValue == '0') {
											$("#nomenclaturetreatment" + cnt).css({
												'color' : 'red',
												'font-size' : '125%'
											});
										}else{
											$("#nomenclaturetreatment" + cnt).css({
												'color' : 'black',
												'font-size' : '125%'
											});
										}
									}
								});
							}
						}
						var url = "/hms/hms/ipd?method=checkItem&pvmsNo=" + pvmsNo + "&" + csrfTokenName + "="
								+ csrfTokenValue;

						xmlHttp.open("GET", url, true);
						xmlHttp.setRequestHeader("Content-Type", "text/xml");
						xmlHttp.send(null);
					}
				}
			 
			 function displaFrequencyType(i,incr){
					var frequencyType = i.options[i.selectedIndex].id;
					document.getElementById('frequencyType'+incr).innerHTML = frequencyType;
				}
			 
			 function addPackageServiceIntoInvestigation(){
					var hdb = document.getElementById('hiddenValue');
					var iteration = parseInt(hdb.value);
					var e = document.getElementById("pkgSchemeId");
					var pkgSchemeId = e.options[e.selectedIndex].value;
					e = document.getElementById("pkgServiceId");
					var pkgServiceName = e.options[e.selectedIndex].text;
					var serviceFlag = true;
					
					for(var i=1;i<iteration;i++){
				 	if(document.getElementById('chargeCodeName'+i)!=null && document.getElementById('chargeCodeName'+i).value==pkgServiceName){
				 		alert('This Investigation is already selected.');
				 		serviceFlag = false;
				 		}
				 	}

					
					if(serviceFlag && (document.getElementById('pkgHeaderId').disabled)){
						document.getElementById("chargeCodeName"+iteration).value = pkgServiceName;
						document.getElementById("isPackageFlag"+iteration).value = 'y';
						document.getElementById("serviceSchemeId"+iteration).value = pkgSchemeId;		
						addRowForInvestigation();
					} else if(!(document.getElementById('pkgHeaderId').disabled)) {
						alert("Please select package first !");
					}
					
				}

				function disablePkgFlag(val){
					document.getElementById(val).value = 'n';
				}

				function togglePackage(){
					var e = document.getElementById("pkgHeaderId");
					var pkgHeaderId = e.options[e.selectedIndex].value;
					e = document.getElementById("pkgSchemeId");
					var pkgSchemeId = e.options[e.selectedIndex].value;
					var pkgCharge = document.getElementById('pkgCharge').value;
					var schemeLimit = document.getElementById("schemeLimit").value;
					var balanceUtilized = document.getElementById("balanceUtilized"+pkgSchemeId).value;
					
					
					if(document.getElementById('pkgHeaderId').disabled){
						document.getElementById('pkgHeaderId').disabled = false;
						document.getElementById('pkgSchemeId').disabled = false;
						document.getElementById('packageSelector').value = 'Select Package';
						document.getElementById('pkgCharge').value = '0';
						document.getElementById("balanceUtilized"+pkgSchemeId).value = parseFloat(balanceUtilized)-parseFloat(pkgCharge);
						document.getElementById('pkgId').value = '';
						document.getElementById('pkgScheme').value = '';
						removeRowOfPackage();
					} else if(!(document.getElementById('pkgHeaderId').disabled) && pkgHeaderId!='0') {
						
						if((parseFloat(pkgCharge)+parseFloat(balanceUtilized))>parseFloat(schemeLimit)){
							alert("Not enough balance in card to add this Package !");
						} else {
						document.getElementById('pkgHeaderId').disabled = true;
						document.getElementById('pkgSchemeId').disabled = true;
						document.getElementById('packageSelector').value = 'Deselect Package';
						document.getElementById('pkgId').value = pkgHeaderId;
						document.getElementById('pkgScheme').value = pkgSchemeId;
						document.getElementById("balanceUtilized"+pkgSchemeId).value = parseFloat(pkgCharge)+parseFloat(balanceUtilized);
						}
						
					}
				}


				function removeRowOfPackage()
				{
				  var tbl = document.getElementById('investigationGrid');
				  var lastRow = tbl.rows.length;
				  var hdb = document.getElementById('hiddenValue');
				  var pkgCharge = document.getElementById("pkgCharge").value;
				  var iteration = parseInt(hdb.value);
				  var e = document.getElementById("pkgSchemeId");
				  var schemeId = e.options[e.selectedIndex].value;
				  var totalSelected=0;
				  if (lastRow > 2){
				    	  for(var i=1;i<=iteration;i++)
				    	  {
				    		  if(document.getElementById("isPackageFlag"+i)!=null && document.getElementById("isPackageFlag"+i).value == 'y' )
				    		  {
				    		  		var deleteRow= document.getElementById("investigationtradio"+i).parentNode.parentNode;
				    		  		document.getElementById("investigationtradio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
				    		  }
				    	  }
				    	 	 var oldBalanceUtilized = document.getElementById("balanceUtilized"+schemeId).value;
							 document.getElementById("balanceUtilized"+schemeId).value = parseFloat(oldBalanceUtilized) - parseFloat(pkgCharge);  
				  }
				        
				  addRowForInvestigation();
				  
				}
			 
			 
			 function fnGetPrescriptionTemplate(tempId){
				 submitProtoAjaxWithDivName('medicinePrescription',"/hms/hms/ipd?method=getPrescriptionTemplateOP&templateId="+tempId,'gridtreatmentDiv');
			}
			 function addRowForInvestigation(){
				    
				  var tbl = document.getElementById('investigationGrid');
				  var lastRow = tbl.rows.length;

				  // if there's no header row in the table, then iteration = lastRow + 1
				  var iteration = lastRow;
				  var row = tbl.insertRow(lastRow);
				  var hdb = document.getElementById('hiddenValue');
				  var iteration = parseInt(hdb.value)+1;
				  hdb.value = iteration;
				  
				  var cellRight1 = row.insertCell(0);
					var e1 = document.createElement('input');
					e1.type = 'checkbox';
					e1.name='investigationtradio'+iteration;
					e1.id='investigationtradio'+iteration;
					e1.className='radioCheck';
					cellRight1.appendChild(e1);
			   
				  var cellRight0 = row.insertCell(1);
				  var e0 = document.createElement('input');
				  e0.type = 'text';
				  e0.onblur=function(){
				  						if(validateInvestigationAutoComplete(this.value,iteration)){disablePkgFlag('isPackageFlag'+iteration);checkForChargeCode(this.value,iteration,'chargeCodeVal'+iteration);}
				  					  };
				   var newdiv1 = document.createElement('div');
				  newdiv1.id='ac2update2'+iteration;
				  newdiv1.className = 'autocomplete';
				  newdiv1.style.display = 'none';
				  					
				  e0.name = 'chargeCodeName' + iteration;
				  e0.id = 'chargeCodeName' + iteration;
				  e0.setAttribute('tabindex','1');
				  e0.size = '40'
				  
				  cellRight0.appendChild(e0);
				  cellRight0.appendChild(newdiv1);
				
				  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update2'+iteration,'opd?method=getInvestigationListForAutoComplete',
						  {minChars:3, 
					  callback: function(element, entry) {
			            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
			        },parameters:'requiredField=chargeCodeName'+iteration+'&fromOpd=fromOpd'});
				  
				  var sel = document.createElement('input');
				  sel.type = 'hidden';
				  sel.name='chargeCode'+iteration;
				  sel.id='chargeCode'+iteration
				  sel.size = '10';
				  sel.setAttribute('tabindex','1');
				  cellRight0.appendChild(sel);

				  var e2 = document.createElement('input');
				  e2.type = 'hidden';
				  e2.name='qty'+iteration;
				  e2.id='qty'+iteration
				  e2.size='10';
				  e2.setAttribute('tabindex','1');
				  cellRight0.appendChild(e2);
				  
				  var cellRight1 = row.insertCell(2);
				  var e3 = document.createElement('input');
				  e3.type = 'text';
				  e3.name='chargecodeclinicalnote'+iteration;
				  e3.id='chargecodeclinicalnote'+iteration
				//  e3.size='10';
				  e3.setAttribute('tabindex','1');
				  cellRight1.appendChild(e3);
				  
				  
				  // Added by Amit Das on 08-03-2016
				  var e4 = document.createElement('input');
				  e4.type = 'hidden';
				  e4.name='isPackageFlag'+iteration;
				  e4.id='isPackageFlag'+iteration
				  e4.size='10';
				  e4.setAttribute('tabindex','1');
				  cellRight1.appendChild(e4);
				  
				// Added by Amit Das on 09-03-2016
				  var e5 = document.createElement('input');
				  e5.type = 'hidden';
				  e5.name='pkgServiceCharge'+iteration;
				  e5.id='pkgServiceCharge'+iteration
				  e5.size='10';
				  e5.setAttribute('tabindex','1');
				  cellRight1.appendChild(e5);
				  
				// Added by Amit Das on 09-03-2016
				  var e6 = document.createElement('input');
				  e6.type = 'hidden';
				  e6.name='serviceSchemeId'+iteration;
				  e6.id='serviceSchemeId'+iteration
				  e6.size='10';
				  e6.setAttribute('tabindex','1');
				  cellRight1.appendChild(e6);
				
				}
			 
			 
			 
			 function removeRowInvestigation()
				{
				  var tbl = document.getElementById('investigationGrid');
				  var lastRow = tbl.rows.length;
				  var hdb = document.getElementById('hiddenValue');
				  var iteration = parseInt(hdb.value);
				  var totalSelected=0;
				  for(var i=1;i<=iteration;i++)
					  {
					  if(document.getElementById("investigationtradio"+i)!=null && (typeof  document.getElementById("investigationtradio"+i).checked)!='undefined' && document.getElementById("investigationtradio"+i).checked )
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
				    		  if(document.getElementById("investigationtradio"+i)!=null && (typeof  document.getElementById("investigationtradio"+i).checked)!='undefined' && document.getElementById("investigationtradio"+i).checked )
				    		  {
				    		  
				    		  var deleteRow= document.getElementById("investigationtradio"+i).parentNode.parentNode;
				    		  document.getElementById("investigationtradio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
				    		  }
				    	  }
				    	 /*  for(var i=1;i<document.getElementById('grid').rows.length;i++)
				    		  {
				    		  document.getElementById('grid').rows[i].cells[0].innerHTML=i;
				    		  } */
				  }
				      
				      
				}
			 
			 
			 
			 function addRowForNursingcare(){
					var tbl = document.getElementById('nursingcaretable');
					var lastRow = tbl.rows.length;
					// if there's no header row in the table, then iteration = lastRow + 1
					var iteration = lastRow;
					var row = tbl.insertRow(lastRow);
					var hdb = document.getElementById('nursingcarecount');
					iteration = parseInt(hdb.value)+1;
					hdb.value=iteration;

					var cellRight1 = row.insertCell(0);
					var e1 = document.createElement('input');
					e1.type = 'checkbox';
					e1.name='radionursingcare'+iteration;
					e1.id='radionursingcare'+iteration;
					e1.className='radioCheck';
					cellRight1.appendChild(e1);
					
					var cellRight1 = row.insertCell(1);
					var e1 = document.createElement('Select');
					e1.name='careTypeId'+iteration;
					e1.id='careTypeId'+iteration;
					e1.options[0] = new Option('Select', '0');
					  for(var i = 0;i<nursingCareSetupList.length;i++ ){
					e1.options[nursingCareSetupList[i][0]] = new Option(nursingCareSetupList[i][1],nursingCareSetupList[i][0]);
					} 
					  e1.onblur=function(){
						  validateDuplicateNursingCare(iteration);
							};
					cellRight1.appendChild(e1);

					
					
					var cellRight1 = row.insertCell(2);
					var e1 = document.createElement('Select');
					e1.name='frequency'+iteration;
					e1.id='frequency'+iteration;
					e1.options[0] = new Option('Select', '0');
					  for(var i = 0;i<frequencyArray.length;i++ ){
					e1.options[frequencyArray[i][0]] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
					} 
					cellRight1.appendChild(e1);
					
					var cellRight1 = row.insertCell(3);
					var e1 = document.createElement('input');
					e1.type = 'checkbox';
					e1.name='carestop'+iteration;
					e1.id='carestop'+iteration;
					e1.value='1';
					cellRight1.appendChild(e1);
					
					
					var cellRight1 = row.insertCell(4);
					var e1 = document.createElement('input');
					e1.type = 'text';
					e1.name='careremarks'+iteration;
					e1.id='careremarks'+iteration;
					/* e1.onblur=function(){
					populatebrand(this.value, iteration);
					checkItem(iteration);
					}; */
					cellRight1.appendChild(e1);
					
			    }
			    
			    function removeRowForNursingcare()
				{
				  var tbl = document.getElementById('nursingcaretable');
				  var lastRow = tbl.rows.length;
				  var hdb = document.getElementById('nursingcarecount');
				  var iteration = parseInt(hdb.value);
				  var totalSelected=0;
				  for(var i=1;i<=iteration;i++)
					  {
					  if(document.getElementById("radionursingcare"+i)!=null && (typeof  document.getElementById("radionursingcare"+i).checked)!='undefined' && document.getElementById("radionursingcare"+i).checked )
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
			        		  if(document.getElementById("radionursingcare"+i)!=null && (typeof  document.getElementById("radionursingcare"+i).checked)!='undefined' && document.getElementById("radionursingcare"+i).checked )
				    		  {
				    		  var deleteRow= document.getElementById("radionursingcare"+i).parentNode.parentNode;
				    		  document.getElementById("radionursingcare"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
				    		  }
				    	  }
				  }
				}
				 
				 function validateDuplicateNursingCare(index)
			     {
			     	var count = document.getElementById('nursingcarecount').value;
			     	var nursingCareId=document.getElementById("careTypeId"+index).value;
			 		for(var i=1;i<=count;i++)
			 			{
			 			   if(i!=index && document.getElementById("careTypeId"+i)!=null && document.getElementById("careTypeId"+i).value!=''&& document.getElementById("careTypeId"+i).value!=0)
			 				   {
			 				   if(document.getElementById("careTypeId"+i).value==nursingCareId)
			 				    	{
			 					   
			 				    	alert(document.getElementById("careTypeId"+i).options[document.getElementById("careTypeId"+i).selectedIndex].text +" is duplicate");        				    	
			 				    	document.getElementById("careTypeId"+index).value=0;
			 				    	return false;
			 				    	}
			 				   
			 				   }
			 			}
			 		return true;
			     }
				 
				 function validateRequiredFieldNursingCare()
			     {
			     	var count = document.getElementById('nursingcarecount').value;
			 		for(var i=1;i<=count;i++)
			 			{
			 			   if(document.getElementById("careTypeId"+i)!=null && document.getElementById("careTypeId"+i).value!=''&& document.getElementById("careTypeId"+i).value!=0)
			 				   {
			 					   document.getElementById("careTypeId"+i).setAttribute("validate", "Nursing Care / Procedure,int,yes");
			 					   document.getElementById("frequency"+i).setAttribute("validate", "Frequency,int,yes");
			 					   document.getElementById("careremarks"+i).setAttribute("validate", "Remarks,string,no");
			 				   }
			 			}
			     }
			 
				//added by govind 27-10-2017
					function openTaperedMedicine(url) {
						/*submitForm('opdMain','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo);*/
						window.open(url,
										"opd_window",
										"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
					}		
					
				function editTaperedMedicine(row,itemId){
					//alert("editTaperedMedicine");
					var url = '/hms/hms/opd?method=showTaperdMedicine&nomenclature='+itemId+'&'+getFormData('taperedForm')+'&taperedEdit=Y'+'&type=IP'+'&row='+row+'&' + csrfTokenName + '='
					+ csrfTokenValue;
					openTaperedMedicine(url);
				}

				function getFormData(formName) {
					   var str="";
					   inputs = eval('document.'+formName+'.elements');
					   // alert(inputs.length);
					   for(i=0;i<inputs.length;i++){
					   	str=str+inputs[i].name+"="+inputs[i].value+"&"
					   }
					   return str;
				}
				//added by govind 27-10-2017
	</script>
	 <div style="display: none;">
						<table id="taperedMedicne1">
						<th scope="col">Item Id</th>
						<th scope="col">Frequency</th>
				        <th scope="col">Dosage</th>
				        <th scope="col">Dosage Total</th>
				        <th scope="col">Duration</th>
				        <th scope="col">Total</th>
						</table>
	<input type="hidden" id="taperedMedicineHdb1" name="taperedMedicineHdb" value="0"/>
</div>
</form>

<form action="" name="taperedForm" style="display: none;" >
							<!-- added by govind for tapered Medicine -->
						<div>
						<table id="taperedMedicne">
						<th scope="col">Item Id</th>
						<th scope="col">Frequency</th>
				        <th scope="col">Dosage</th>
				        <th scope="col">Dosage Total</th>
				        <th scope="col">Duration</th>
				        <th scope="col">Total</th>
						</table>
						</div>
						<input type="hidden" id="taperedMedicineHdb" name="taperedMedicineHdb" value="0"/>
						<!-- added by govind for tapered Medicine -->
	</form>


