<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * prescriptionEntryDetailsView.jsp
 * Purpose of the JSP -  This is for Nursing Care Entry Setup.
 * @author  Dipali
 * @author  Vishal
  * @author  Kiran
 * Create Date: 20th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>

<%@page import="jkt.hms.masters.business.IpWardConsumptionHeader"%>
<%@page import="jkt.hms.masters.business.IpWardConsumptionDetails"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionHeader"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.Ipdcaredetail"%>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />

<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" id="vbulletin_css" />

<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.IpWardConsumption"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>


<script type="text/javascript" language="javascript"  src="/hms/jsp/js/IPDGrid.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script> -->
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script> -->
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ipd.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date2=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date2.length()<2){
			date2="0"+date2;
		}
			
	%>
		serverdate = '<%=date2+"/"+month+"/"+year%>'
</script>

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	String deptName="";
	boolean showSubmit = false; // added by amit das on 17-10-2016

/*

	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	
*/
	int hinId=0;
	int maxFrequncy=0;		
	if(map.get("patId") != null){
		hinId=(Integer)map.get("patId");
	}
	int deptId=0;
	if(map.get("deptId") != null){
		deptId=(Integer)map.get("deptId");
	}
	System.out.println("hinId----->"+hinId);
	String caretime=(String)map.get("caretime");
	Set patientSet = new HashSet();
	//session.setAttribute("careId",careId);
	List<InpatientPrescriptionHeader> showHeaderList = new ArrayList<InpatientPrescriptionHeader>();
	List<InpatientPrescriptionDetails> showDetailsList = new ArrayList<InpatientPrescriptionDetails>();
	List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
	List<StoreItemBatchStock> sotckBatchList = new ArrayList<StoreItemBatchStock>();
		List<IpWardConsumptionDetails> consumptionDetails=new ArrayList<IpWardConsumptionDetails>();
	List admissionNumberList= new ArrayList();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	if (map.get("employeeList") != null) {
		employeeList = (List<MasEmployee>) map.get("employeeList");
	}
	Properties properties = new Properties();
	URL resourcePath =

Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor =properties.getProperty("empCategoryCodeForDoctor");
	//added by govind 23-09-2016
	List<InjAppointmentDetails> aList=new ArrayList<InjAppointmentDetails>();
	if(map.get("aList")!=null){
		aList=(List<InjAppointmentDetails>)map.get("aList");
	}
	System.out.println("aList jsp "+aList.size());
	//added by govind 23-09-2016 end
	try {

				if(map.get("admissionNumberList") != null)
				{
						admissionNumberList=(List)map.get("admissionNumberList");
						session.setAttribute("admissionNumberList",admissionNumberList);
				}
				else{
							admissionNumberList=(List)session.getAttribute("admissionNumberList");
				}
if(map.get("showHeaderList") !=null){
	showHeaderList=(List)map.get("showHeaderList");
}

if(map.get("showDetailsList") !=null){
	showDetailsList=(List)map.get("showDetailsList");
}

if(map.get("sotckBatchList") !=null){
	sotckBatchList=(List<StoreItemBatchStock>)map.get("sotckBatchList");
}

if(map.get("consumptionDetails") !=null){
	consumptionDetails=(List<IpWardConsumptionDetails>)map.get("consumptionDetails");
}

if(map.get("maxFrequncy") !=null){
	maxFrequncy=(Integer)map.get("maxFrequncy");
}



	} catch (Exception exp) {
		exp.printStackTrace();
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>
<%	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %>
    
    <%
    
    
   // String currentDate ="";
   	String time = "";
    Map<String,Object> utilMap = new HashMap<String,Object>();
   	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
  // 	currentDate = (String)utilMap.get("currentDate");	
	time = (String)utilMap.get("currentTime");
    
    
    
    
    if(map.get("inPatientDetailList")!=null)
	{
		inPatientDetailList=(List<Inpatient>)map.get("inPatientDetailList");
	}
    Inpatient inpatient=inPatientDetailList.get(0);

    
    %>
  
  
<div class="clear"></div>

<%-- <input type="hidden" name="inpatientId" id="inpatientId" value="<%=inpatientId1 %>" />
<input type="hidden" name="patientStatus" id="patientStatus" value="<%=patientStatus %>" />

<input type="hidden" id="hinId" name="hinId" value="<%=hinId1 %>" />
<input type="hidden" id="parent" name="parent" value="<%=inpatientId1 %>" />
<input type="hidden" id="hiNumber" name="hiNumber" value="<%=hinNo %>" />
<input type="hidden" id="adNo" name="adNo" value="<%=adNo1 %>" />
<input type="hidden" id="deptName" name="deptName" value="<%=deptName %>" /> --%>


<div class="clear"></div>


<div class="clear paddingTop25"></div>
  
  <div class="titleBg">
  <h2>Medicine Issue</h2>

  </div>
<form name="medicineissue" method="post">
	<div class="Block">
		<h4>Patient Details</h4>
		<div class="clear"></div><%if(inpatient!=null){ 
		session.setAttribute("inpatient", inpatient);
		%>
		<%@include file="PatientDetails.jsp"%>
		<%} %>
		<div class="clear"></div>

		
		<div class="clear paddingTop25"></div>

		<div class="clear paddingTop15"></div>

		<%if(showDetailsList.size()>0){ %>
		<label>Date</label> <input class="date" name="caredate" id="caredate"
			readonly="readonly" value="<%=date2+"/"+month+"/"+year%>" /><img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date,date,yes" id="imgId"
			onclick="javascript:setdate('28/03/2015',document.medicineissue.caredate,event)">


		<div class="clear paddingTop25"></div>

		<div class="clear paddingTop15"></div>

		<div class="clear paddingTop15"></div>

		<%
int  j=1;
int  i=1;
%>
		<input type="hidden" name="<%=RequestConstants.INPATIENT_ID%>"
			id="<%=RequestConstants.INPATIENT_ID%>"
			value="<%=inpatient.getId()%>" validate="inpatientId,int,no" /> <input
			type="hidden" name="<%=RequestConstants.HIN_ID%>"
			id="<%=RequestConstants.HIN_ID%>"
			value="<%=inpatient.getHin().getId()%>" validate="hinId,int,no" /> <input
			type="hidden" name="<%=RequestConstants.HIN_NO%>"
			id="<%=RequestConstants.HIN_NO%>"
			value="<%=inpatient.getHin().getHinNo()%>"
			validate="hinNo,metachar,no" /> <input type="hidden"
			name="<%=RequestConstants.AD_NO%>" id="<%=RequestConstants.AD_NO%>"
			value="<%=inpatient.getAdNo()%>" validate="hinNo,metachar,no" />
<div class="clear"></div>
<h4>Medicine Details</h4>
<div class="clear"></div>
		<div class="cmntable">
			<table>
				<tr>
					<th>Item Name</th>
					<th>Dosage</th>
					<th>Unit</th>
					<th>Frequency</th>
					<th>No Of days</th>
					<th>Instruction</th>
					<th>Spl.Instruction</th>
					<th>Route of administration</th>
					<th colspan="2">Batch No./Outside Prescription</th>

					<%
						while(j<=maxFrequncy)
					{
					%>
					<th><%=j%></th>
					<%
						j++;
					}
					%>
<!-- 					<th>Med Stop</th> -->
                  <th>Status</th>
				</tr>

				<%
					String st="";
					Iterator iterator=showDetailsList.iterator();
						          while(iterator.hasNext())
						           {
						        	  InpatientPrescriptionDetails inpatientPrescriptionDetails= (InpatientPrescriptionDetails) iterator.next();
						        	  
						        	  if(null !=inpatientPrescriptionDetails && null != inpatientPrescriptionDetails.getInjectionStatus() && !inpatientPrescriptionDetails.getInjectionStatus().equalsIgnoreCase("y")){
						        	  
						        	  j=1;
						        	  List<IpWardConsumptionDetails> localConsumptionDetails=new ArrayList<IpWardConsumptionDetails>();
						        	  localConsumptionDetails=HMSUtil.getIpWardConsumptionDetails(consumptionDetails, inpatientPrescriptionDetails.getId());
						        	  int frequency=0;
						        			  if(inpatientPrescriptionDetails.getFrequency()!=null){
						        			  frequency=inpatientPrescriptionDetails.getFrequency().getId();
						        			  }
				%>
				<%
				//	if(!inpatientPrescriptionDetails.getIssuedStatus().equalsIgnoreCase("J")){  // commented by amit das on 17-10-2016
				%>
				<tr>

					<%
						if(inpatientPrescriptionDetails.getItem().getHighValueDrug()!=null && !inpatientPrescriptionDetails.getItem().getHighValueDrug().equals("y")){
					%>
					<td style="color: green;width:340px;"><input type="hidden"
						name="<%=RequestConstants.PRESCRIPTION_DETAILS_ID%><%=i%>"
						id="<%=RequestConstants.PRESCRIPTION_DETAILS_ID%><%=i%>"
						value="<%=inpatientPrescriptionDetails.getId()%>"
						validate="prescriptionDetailsId,int,no" /> <%=inpatientPrescriptionDetails.getItem().getNomenclature()%>
						<input type="hidden" size="2"
						value="n" name="billStatus<%=i %>" 
						id="billStatus<%=i %>"  tabindex="1" />
					</td>
					<%
						}else{ String billStatus="n"; 
							if(inpatient.getHin().getBplStatus()!=null && inpatient.getHin().getBplStatus().equalsIgnoreCase("n")){billStatus="y"; }
					%>
					<td style="color: red;width:340px;"><input type="hidden"
						name="<%=RequestConstants.PRESCRIPTION_DETAILS_ID%><%=i%>"
						id="<%=RequestConstants.PRESCRIPTION_DETAILS_ID%><%=i%>"
						value="<%=inpatientPrescriptionDetails.getId()%>"
						validate="prescriptionDetailsId,int,no" /> <%=inpatientPrescriptionDetails.getItem().getNomenclature()%>
						
						<!-- added by amit das on 19-11-2016 -->
					<input type="hidden" size="10"
						value="<%=inpatientPrescriptionDetails.getActualTotal()%>" name="actualQtyNeeded" 
						id="actualQtyNeeded<%=i %>"  tabindex="1" />
						
						<input type="hidden" size="10"
						value="<%=inpatientPrescriptionDetails.getItem().getMixable()%>" name="dilutable" 
						id="dilutable<%=i %>"  tabindex="1" />
						
						<input type="hidden" size="2"
						value="<%=billStatus%>" name="billStatus<%=i %>" 
						id="billStatus<%=i %>"  tabindex="1" />
					</td>
					<%
						}
					%>
					<td><%=inpatientPrescriptionDetails.getDosage()!=null?inpatientPrescriptionDetails.getDosage():""%></td>
					<td><%=inpatientPrescriptionDetails.getItem().getItemConversion()!=null?inpatientPrescriptionDetails.getItem().getItemConversion().getIssueUnit().getUnitName():""%>
					</td>
					<td><%=inpatientPrescriptionDetails.getFrequency()!=null?inpatientPrescriptionDetails.getFrequency().getFrequencyName():""%>
					</td>
					<td><%=inpatientPrescriptionDetails.getNoOfDays()!=null?inpatientPrescriptionDetails.getNoOfDays():""%></td>
					<td><%=inpatientPrescriptionDetails.getInsrtuction()!=null?inpatientPrescriptionDetails.getInsrtuction().getOpdInstructionTreatmentName():""%>
					</td>
					<td><%=inpatientPrescriptionDetails.getSplInstruction()!=null?inpatientPrescriptionDetails.getSplInstruction():""%>
					</td>
					<td><%=inpatientPrescriptionDetails.getRoute()!=null ? inpatientPrescriptionDetails.getRoute().getRouteName():""%>
					</td>
					<td colspan="2">
						<%
							if(sotckBatchList.size()>0){
						%> <select name="stockId<%=i%>"
						 <%if(inpatientPrescriptionDetails.getStopMedicine().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>						
						id="stockId<%=i%>">
							<option value="">select</option>
							<%
								for(StoreItemBatchStock batchStock:sotckBatchList){
							%>
							<%
								if(batchStock.getItem().getId()==inpatientPrescriptionDetails.getItem().getId()){
							%>
							<option value="<%=batchStock.getId()%>"><%=batchStock.getBatchNo()%></option>
							<%
								}
							%>
							<%
								}
							%>
					</select> <%
 	}else{
 %> <%
 	if(inpatientPrescriptionDetails.getItem().getItemClass().getItemClassName().equalsIgnoreCase("INJECTION")){
 %>
						<input type="checkbox" name="stockId<%=i%>" name="stockId<%=i%>" />Outside
						Prescription <script type="text/javascript">document.getElementById("stockId<%=i%>").style.display='block'</script>
						<%
							}
						%> <%
 	}
 %>

					</td>
					<%
						if (localConsumptionDetails.size() > 0) {
										IpWardConsumptionHeader consumptionHeader = null;
					%>


					<%
						for (IpWardConsumptionDetails ipWardConsumptionDetails : localConsumptionDetails) {
											consumptionHeader = ipWardConsumptionDetails
													.getConsumption();
					%>
					<td><input type="checkbox" class="radiogrid" name="care<%=i%>"
						value="<%=j%>" checked="true" DISABLED id="care<%=i%>" /> <br />
						<input type="text" name="caretime<%=i%>" id="caretime<%=i%>"
						class="small" disabled="disabled"
						value="<%=ipWardConsumptionDetails
										.getConsumptionTime()%>"
						MAXLENGTH="5" /></td>
					<%
						j++;
										}
					%>
					<%
						boolean isFirstLoop = true;
										while (inpatientPrescriptionDetails
												.getFrequency()!=null && j <= inpatientPrescriptionDetails
												.getFrequency().getFrequencyCount()) {
											
											if(inpatientPrescriptionDetails.getIssuedStatus().equalsIgnoreCase("J")){ // added by amit das on 17-10-2016
										%>	
											<td>Cancelled</td>
										<%	
											} 
											else if (isFirstLoop
													&& j <= inpatientPrescriptionDetails
															.getFrequency()
															.getFrequencyCount()) {
												isFirstLoop = false;
												showSubmit = true; // added by amit das on 17-10-2016
					%>
					<td><input type="hidden" name="ipwardconsumptionId<%=i%>"
						value="<%=consumptionHeader.getId()%>"
						id="ipwardconsumptionId<%=i%>" /> 
						
						
			       <input type="checkbox"
						class="radiogrid" name="care<%=i%>"
						<%if (!inpatientPrescriptionDetails.getItem()
											.getItemClass().getItemClassCode()
											.equalsIgnoreCase("INJ")) {%>
						onchange="applyValidation(this,<%=i%>);"
						onclick="applyValidation(this,<%=i%>);" <%}%> value="<%=j%>"						
						<%if(inpatientPrescriptionDetails.getStopMedicine().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>
						id="care<%=i%>" /> <br /> <input type="text"
						name="caretime<%=i%>" id="caretime<%=i%>" class="small"
						value="<%=time%>" MAXLENGTH="5" /> <%
 	} else {
 %>
					<td><input type="checkbox" class="radiogrid" name="care<%=i%>"
						value="<%=j%>" DISABLED id="care<%=i%>" /> <br /> <input
						type="text" name="caretime<%=i%>" id="caretime<%=i%>"
						class="small" disabled="disabled" value="<%=time%>" MAXLENGTH="5" />

					</td>
					<%
						}
											j++;
										}
					%>

					<%
						while (j <= maxFrequncy) {
					%>
					<td></td>
					<%
						j++;
										}
					%>


					<%
						}  
						else if(inpatientPrescriptionDetails.getIssuedStatus().equalsIgnoreCase("J")){ // added by amit das on 17-10-2016 	
					%>	
						<td>Cancelled</td>
					<%		
						} else {
					%>
					<%
						while (inpatientPrescriptionDetails
								.getFrequency()!=null && j <= inpatientPrescriptionDetails
												.getFrequency().getFrequencyCount()) {
											if (j == 1) {
					%>
					<td><input type="checkbox" class="radiogrid" name="care<%=i%>"
						value="<%=j%>" id="care<%=i%>"
						<%if (!inpatientPrescriptionDetails.getItem()
											.getItemClass().getItemClassCode()
											.equalsIgnoreCase("INJ")) {
							showSubmit = true; // added by amit das on 17-10-2016
											%>
						
						 <%if(inpatientPrescriptionDetails.getStopMedicine().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					    onchange="applyValidation(this,<%=i%>);"
						onclick="applyValidation(this,<%=i%>);" 
					      <%}%>
					      
						<%}%> /> <br />
						<input type="text" name="caretime<%=i%>" id="caretime<%=i%>"
						class="small" value="<%=time%>" MAXLENGTH="5" /></td>
					<%
						} else {
					%>
					<td><input type="checkbox" class="radiogrid" name="care<%=i%>"
						disabled="disabled" value="<%=j%>" id="care<%=i%>" /> <br /> <input
						type="text" name="caretime<%=i%>" id="caretime<%=i%>"
						class="small" disabled="disabled" value="<%=time%>" MAXLENGTH="5" /></td>
					<%
						}
											j++;
										}
					%>

					<%
						while (j <= maxFrequncy) {
					%>
					<td></td>
					<%
						j++;
										}
					%>


					<%
						}
					%>
					
					<% if(!inpatientPrescriptionDetails.getIssuedStatus().equalsIgnoreCase("J")){ // added by amit das on 17-10-2016 %>
<!-- 					<td> -->
<%-- 					 <%if(inpatientPrescriptionDetails.getStopMedicine().equalsIgnoreCase("y")){ %> --%>
<!-- 						<input type="checkbox" class="radiogrid" -->
<%-- 						name="medstop<%=i%>" id="medstop<%=i%>" --%>
<%-- 						value="<%=inpatientPrescriptionDetails.getId()%>" disabled="disabled"/> --%>
<%-- 					 <%}else{%> --%>
<!-- 					 	<input type="checkbox" class="radiogrid" -->
<%-- 						name="medstop<%=i%>" id="medstop<%=i%>" --%>
<%-- 						value="<%=inpatientPrescriptionDetails.getId()%>" /> --%>
<%-- 					 <%}%> --%>
<!-- 					</td>added by govind 3-12-2016 -->
					<td>
					 <%if(inpatientPrescriptionDetails.getStopMedicine().equalsIgnoreCase("y")){ %>
						Stopped Medicine
					 <%}else{%>
					 <%}%>
					</td> <!-- added by govind 3-12-2016 end -->
					<% } %>	
				</tr>

				<%
					i++;
							//}
						
						           }           
						           
						}
				%>

			</table>
		</div>
	</div>

<!-- added by govind 20-9-2016 -->

<div class="clear"></div><div class="clear"></div>

<%j=1; %>
		<%
		String hospitalId="";
		if(map.get("hospitalId") !=null){
			hospitalId=""+map.get("hospitalId");
		}
		if(aList.size() > 0){
			
		%>
	
		
<div class="clear"></div>
<h4>Injection Details</h4>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>

<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="injection">

	<tr>
		<th></th>
		<th>Injection Name</th>
		<th>Dosage</th>
		<th>Unit</th>
		<th>Frequency</th>
		<th>No Of days</th>		
		<th>Instruction</th>
		<th>Route of administration</th>
		<th>Final Status</th>
		<th></th>
	</tr>
	
		<%
		List<Integer> nrInjList = new ArrayList<Integer>();
		for(InjAppointmentDetails appointmentDetails : aList){
				String status=appointmentDetails.getStatus();
				
				if(!nrInjList.contains(appointmentDetails.getInpatientPrescriptionDetails().getId()))
				{
					nrInjList.add(appointmentDetails.getInpatientPrescriptionDetails().getId());	
				}
				else
				{
					continue;
				}
		%>
			<tr>
			<input type="hidden" name="appointmentHeaderId<%=j %>" id="appointmentHeaderId<%=j %>" value="<%=appointmentDetails.getInjAppointmentHeader().getId() %>"/>
		<td>
			<%
			String insulinInjection="";
			if(appointmentDetails.getInpatientPrescriptionDetails().getItem()!=null){
				insulinInjection=""+appointmentDetails.getInpatientPrescriptionDetails().getItem().getInsulinInjection();
			}
			if(insulinInjection.equalsIgnoreCase("y")){ %>
				<input type="checkbox" disabled="disabled" name="appDtId<%=j %>" id="appDtId<%=j %>" value="<%=  appointmentDetails.getId()%>"/>
			<%}else{ %>
				<input type="checkbox" name="appDtId<%=j %>" id="appDtId<%=j %>" value="<%= appointmentDetails.getId()%>"/>
			<%} %>
		</td>
		<td style="width:300px;">
			<%
			if(appointmentDetails.getInpatientPrescriptionDetails().getItem().getHighValueDrug()!=null && !appointmentDetails.getInpatientPrescriptionDetails().getItem().getHighValueDrug().equals("y")){
			%>
		<font color="green"><%=appointmentDetails.getInpatientPrescriptionDetails().getItem().getNomenclature() %></font>
			<%
			}else{
			%>
		<font color="red"><%=appointmentDetails.getInpatientPrescriptionDetails().getItem().getNomenclature() %></font>
			<%
			}
			%>
				<input type="hidden" class="nomeclatureOpdgridText" name="injectionName<%=j%>" readonly="readonly" id="injectionName<%=j %>" value="<%=appointmentDetails.getInpatientPrescriptionDetails().getItem().getNomenclature() %>"/>
			<input type="hidden" name="itemId<%=j%>" id="itemId<%=j %>" value="<%=appointmentDetails.getInpatientPrescriptionDetails().getItem().getId() %>" />
		</td>
		<td>
            <%= appointmentDetails.getInpatientPrescriptionDetails().getDosage()!=null ? appointmentDetails.getInpatientPrescriptionDetails().getDosage(): "1"%>
		<input type="hidden" class="small" name="dose<%=j %>" readonly="readonly"  value="<%= appointmentDetails.getInpatientPrescriptionDetails().getDosage()!=null ? appointmentDetails.getInpatientPrescriptionDetails().getDosage(): "1"%>" size="2" maxlength="4" validate="" /></td>
		<td>
		<%= appointmentDetails.getInpatientPrescriptionDetails().getItem().getItemConversion()!=null?appointmentDetails.getInpatientPrescriptionDetails().getItem().getItemConversion().getIssueUnit().getUnitName():"" %></td>
			<td>
		<%=appointmentDetails.getInpatientPrescriptionDetails().getFrequency()!=null?appointmentDetails.getInpatientPrescriptionDetails().getFrequency().getFrequencyName() : ""%>
		<input type="hidden" class="small" name="freq<%=j %>" id="freq<%=j %>" readonly="readonly"   value="<%=appointmentDetails.getInpatientPrescriptionDetails().getFrequency()!=null?appointmentDetails.getInpatientPrescriptionDetails().getFrequency().getFrequencyName() : ""%>" size="7"/>
		<input type="hidden"  class="small" name="frequencyCount<%=j %>" id="frequencyCount<%=j %>" value="<%=appointmentDetails.getFrequency()!=null?appointmentDetails.getFrequency().getFrequencyCount():""%>" size="5"/>
		</td>
		<td>
		<%= appointmentDetails.getInpatientPrescriptionDetails().getNoOfDays()!=null ? appointmentDetails.getInpatientPrescriptionDetails().getNoOfDays() : "" %>
		<input type="hidden" class="small" name="noOfDaysInj<%=j %>" id="noOfDaysInj<%=j %>" readonly="readonly"  value="<%= appointmentDetails.getInpatientPrescriptionDetails().getNoOfDays()!=null ? appointmentDetails.getInpatientPrescriptionDetails().getNoOfDays() : "" %>" /></td>
		<td>
	    <%=appointmentDetails.getInpatientPrescriptionDetails().getInsrtuction()!=null?appointmentDetails.getInpatientPrescriptionDetails().getInsrtuction().getOpdInstructionTreatmentName():""%>
		</td>
		<td>
		<%=(appointmentDetails.getInpatientPrescriptionDetails().getRoute()!=null && appointmentDetails.getInpatientPrescriptionDetails().getRoute().getRouteName()!=null)?appointmentDetails.getInpatientPrescriptionDetails().getRoute().getRouteName():""%>
		<input type="hidden" class="small" name="route<%=j %>" readonly="readonly"  value="<%=(appointmentDetails.getInpatientPrescriptionDetails().getRoute()!=null && appointmentDetails.getInpatientPrescriptionDetails().getRoute().getRouteName()!=null)?appointmentDetails.getInpatientPrescriptionDetails().getRoute().getRouteName():""%>" size="5"/></td>
		 <td>
		 	<%if(appointmentDetails.getInpatientPrescriptionDetails().getIssuedStatus().equalsIgnoreCase("J")) {%><!--  added by amit das on 17-10-2016 -->
		 		<input type="text" class="small" name="finalStatus<%=j %>" readonly="readonly" value="Cancelled"  size="8"/>
		 	<%} else if(appointmentDetails.getFinalStatus()==null || appointmentDetails.getFinalStatus().equalsIgnoreCase("n")) {%>
		 		<input type="text" class="small" name="finalStatus<%=j %>" readonly="readonly" value="Not Completed"  size="8"/>
		 	<%}else{ %>
		 		<input type="text" class="small" name="finalStatus<%=j %>" readonly="readonly" value="Completed"  size="8"/>
		 	<%} %>
		 </td>	
		<%if(!appointmentDetails.getInpatientPrescriptionDetails().getIssuedStatus().equalsIgnoreCase("J")) {%><!--  added by amit das on 17-10-2016 --> 
		<td><input type="button"  id="issue" name="issue" value="View and Submit" class="button" onclick="openPopupForIssue(<%=j%>)" /></td>
		<%} %>
		<%j++;%> 
	</tr>
		<%}%>
			
</table>
</div>
	<input type="hidden" name="injCount" value="<%=j -1%>" id="injCount" />

<div class="clear"></div>
<div class="Clear"></div>

<input type="hidden" name="checkboxArray" value="" id="checkboxArray" />
<input type="hidden" name="IssuedQtyArray" value="" id="IssuedQtyArray" />
<input type="hidden" name="batchIdArray" value="" id="batchIdArray" />
<input type="hidden" name="batchNoArray" value="" id="batchNoArray" />
<input type="hidden" name="expDateArray" value="" id="expDateArray" />
<div class="clear"></div>
<%}%>

<!-- added by govind 20-9-2016 end -->

	<input type="hidden" name="counter" id="counter" value="<%=--i%>" />
	<label class="auto"><img width="14" height="14" src="/hms/jsp/images/red_rectangle.jpg"><span>High Value Drug</span></label>	
		


<%-- <%SSSSS

			String st="";
			Iterator iterator=showDetailsList.iterator();
		    /* int  i=1; */
		          while(iterator.hasNext())
		           {
		        	  InpatientPrescriptionDetails inpatientPrescriptionDetails= (InpatientPrescriptionDetails) iterator.next();
		        	  Set ipWardConsumption=inpatientPrescriptionDetails.getIpWardConsumptions();
		        	  int frequency=inpatientPrescriptionDetails.getFrequency().getId();
		%>
<tr>
<td>
<input type="hidden" name="<%=RequestConstants.PRESCRIPTION_DETAILS_ID%><%=i%>" id="<%=RequestConstants.PRESCRIPTION_DETAILS_ID%><%=i%>" value="<%=inpatientPrescriptionDetails.getId()%>" />
<%=inpatientPrescriptionDetails.getItem().getNomenclature()%>
</td>

<td>
<input type="hidden" name="<%=RequestConstants.PRESCRIPTION_DETAILS_ID%><%=i%>" id="<%=RequestConstants.PRESCRIPTION_DETAILS_ID%><%=i%>" value="<%=inpatientPrescriptionDetails.getId()%>" />
<%=inpatientPrescriptionDetails.getFrequency().getFrequencyName()%>
</td>

<td>
<input type="hidden" name="<%=RequestConstants.PRESCRIPTION_DETAILS_ID%><%=i%>" id="<%=RequestConstants.PRESCRIPTION_DETAILS_ID%><%=i%>" value="<%=inpatientPrescriptionDetails.getId()%>" />
<%=inpatientPrescriptionDetails.getNoOfDays()%>
</td>
			<%
			     Iterator itr1=ipWardConsumption.iterator();
			     if(ipWardConsumption.size() > 0){
	        	  while(itr1.hasNext())
	        	  {
	        		  String bool="false";
	        		  int check=0;
	        		  String flag="off";
	        		  IpWardConsumption ipdObj=(IpWardConsumption)itr1.next();
	        		  //out.println('care id is == '+ipdObj.getId());
	        		  Date date1=null; 
	        		  if(ipdObj!=null)
	        		  {
	        		 // int ipdcaredetailId=ipdObj.getId();
	        		  date1 =ipdObj.getDateofconsumption();
	        		  }
	        		  String dateInString=HMSUtil.convertDateToStringWithoutTime(date1);
	        			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	        			String currentDate = (String)utilMap.get("currentDate");
	        		  if(ipdObj!=null && dateInString.equals(currentDate))
	        		  {
	        			  bool="true";
	        			 /*  String care1=ipdObj.getCare1();
	        			  String care2=ipdObj.getCare2();
	        			  String remarks=ipdObj.getRemarks(); */
	        			  String remarks=null;
	        			  if(ipdObj.getConsumption1()!= null)
	        			  {
	        				  check=1;
	        	   %>
	        	   <td>
	        	   
	        	   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="one" checked="true" DISABLED  id="care<%=i%>" />
	        	   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption1time()%>" MAXLENGTH="5"  />
	        	   
	        	   </td>
	        		<%
	        		   }else{
	        			   if(check<frequency && flag.equals("off"))
	        			   {
	        				   check=1;
	        				   flag="on";
	        		%>
	        		<td>
	        		 <input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		
	        		<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  />
	        		</td>
	        		<%
	        			   }else
	        			   {
	        		%>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  />
	        		</td>
	        		<%
	        			   }
	        		    }
	        		    if( ipdObj.getConsumption2() != null)
	        		    {
	        		    	check=2;
	        	  %>
	        	  <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="two" checked="true" DISABLED  value="" id="care<%=i%>" />
	        	   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption2time()%>" MAXLENGTH="5"  />
	        	  </td>
	        	  <%
	        		    }else
	        		    {
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=2;
	        		    		flag="on";
	        		%>
	        		<td>
	        			        	<input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		
	        		<input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<%
	        		    	}else
	        		    	{
	        		    		
	        		 %>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  />
	        		 </td>
	        		 <%
	        		    	}
	        		    }
	        		   
	        		    
	        		      if(ipdObj.getConsumption3()!= null)
	        		    {
	        		    	check=3; 
	        		 %>
	        		  <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="three" checked="true" DISABLED   value="" id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption3time()%>" MAXLENGTH="5"  /></td>
	        		 <%
	        		    }
	        		    else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=3;
	        		    		flag="on";
	        		 %>
	        		 <td>
	        		 <input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		 <input type="checkbox" class="radiogrid" name="care<%=i%>"   value="three" id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <%
	        		    	}else{
	        		  %>
	        		  <td><input type="checkbox" class="radiogrid" name="care<%=i%>"  value="three" DISABLED id="care<%=i%>" />
	        		  <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		  <%
	        		    	}
	        		    }
	        		    if(ipdObj.getConsumption4() != null)
	        		    {
	        		    	check=4;
	        		  %>
	        		  <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" checked="true" DISABLED value="" id="care<%=i%>" />
	        		  <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption4time()%>" MAXLENGTH="5"  /></td>
	        		  <%
	        		    }else{
	        		    	if(check<frequency  && flag.equals("off"))
	        		    	{
	        		    		check=4;
	        		    		flag="on";
	        		 %>
	        		 <td>
	        		 <input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		 <input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <%
	        		    	}else{
	        		 %>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <%
	        		    	}
	        		    }
	        		    if(ipdObj.getConsumption5() != null)
	        		    {
	        		    	check=5;
	        		 %>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" checked="true" DISABLED value="" id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption5time()%>" MAXLENGTH="5"  /></td>	        		 <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=5;
	        		    		flag="on";
	        		  %>
	        		  <td>
	        		  	<input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		  <input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" id="care<%=i%>" />
	        		  <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		  <%
	        		    	}else{
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" DISABLED id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}
	        		    }
	        		    if(ipdObj.getConsumption6() != null)
	        		    {
	        		    	check=6;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption6time()%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=6;
	        		    		flag="on";
	        		   %>
	        		   <td>
	        		  <input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}else{
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" DISABLED  id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}
	        		    }
	        		    if(ipdObj.getConsumption7() != null)
	        		    {
	        		    	check=7;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption7time()%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=7;
	        		    		flag="on";
	        		   %>
	        		   <td>
	        		   	 <input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}else{
	        		    %>
	        		    <td>
	        		    <input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}
	        		    }
	        		    if(ipdObj.getConsumption8() != null)
	        		    {
	        		    	check=8;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption8time()%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off") )
	        		    	{
	        		    		check=8;
	        		    		flag="on";
	        		   %>
	        		   <td>
	        		   <input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}else{
	        		    %>
	        		    <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}
	        		    }
	        		    if(ipdObj.getConsumption9() != null)
	        		    {
	        		    	check=9;
	        		   %>
	        		   <td>
	        		   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption9time()%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=9;
	        		    		flag="on";
	        		   %>
	        		   <td>	 <input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}else{
	        		    %>
	        		    <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}
	        		    }
	        		    if(ipdObj.getConsumption10() != null)
	        		    {
	        		    	check=10;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption10time()%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=10;
	        		    		flag="on";
	        		    %>
	        		    <td>
	        		    <input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		    <input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}else{
	        		    %>
	        		    <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}
	        		    }
	        		    if(ipdObj.getConsumption11() != null)
	        		    {
	        		    	check=11;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption11time()%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=11;
	        		    		flag="on";
	        		    %>
	        		    <td>
	        		    <input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		    <input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}else{
	        		    %>
	        		    <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}
	        		    }
	        		    if(ipdObj.getConsumption12() != null)
	        		    {
	        		    	check=12;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdObj.getConsumption12time()%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=12;
	        		    		flag="on";
	        		    %>
	        		    <td>
	        		    <input type="hidden"  name="ipwardconsumptionId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipwardconsumptionId<%=i%>" />
	        		    <input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}else{
	        		    %>
	        		    <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td> 
	        		    <%
	        		    	}
	        		    }
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid"  name="medstop<%=i%>" id="medstop<%=i%>" value="1"  /></td>
	        		  
	        		    data_arr[<%= i%>][18] = '<input type="hidden"  name="nursingId<%=i%>" value="<%=nursingcareSetup.getId()%>"  />'
	        		    data_arr[<%= i%>][19] = '<input type="hidden"  name="adNo<%=i%>" value="<%=nursingcareSetup.getAdNo()%>"  />'
	        		    data_arr[<%= i%>][20] = '<input type="hidden"  name="hinId<%=i%>" value="<%=patient.getId()%>"  />'
	        		    data_arr[<%= i%>][21] = '<input type="hidden"  name="ipdcaredetailId<%=i%>" value="<%=ipdObj.getId()%>"  />'

	        		    <%
	        		    break;
	        		  }
	        		  if(bool.equals("false"))
	        		  {
	        	%>
	        		<td>  <input type="checkbox" class="radiogrid" name="care<%=i%>" i   value="one" id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" value="<%=time%>" MAXLENGTH="5"  />
	        		</td>
	        		<td> <input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" DISABLED id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  />
	        		</td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>"   value="three" DISABLED id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" DISABLED  id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" DISABLED id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		  <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" DISABLED id="care<%=i%>" />
	        		  <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid"  name="medstop<%=i%>" id="medstop<%=i%>" value="1"  /></td>
	        	<%
	        		  }
	        	    }
			     }else{
			    %>
			         <td>  <input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" id="care<%=i%>" />
			         <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td> <input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>"   value="three" DISABLED id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" DISABLED  id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" DISABLED id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		  <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" DISABLED id="care<%=i%>" />
	        		  <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 
	        		 <td><input type="checkbox" class="radiogrid"  name="medstop<%=i%>" id="medstop<%=i%>" value="1"  /></td>
				<%
			     }
				%>

		<%

			i++;
		%>
		</tr>
		<%
		  }
		%>

</table>
</div>


<input type="hidden" name="counter" id="counter" value="<%=--i %>" /> --%>

<div class="clear"></div>
<div class="paddingTop25"></div>

<div class="clear"></div>
<% if(showSubmit){ // added by amit das on 17-10-2016 %>
<input type="button" class="button" value="Submit " align="left" onclick="if(validateMedicineissue()){submitForm('medicineissue','ipd?method=submitWardConsumption')}" />
<input type="button" class="buttonBig2" value="Print Out Of Stock Medicine " align="left" onclick="submitForm('medicineissue','ipd?method=printOutOfStockMedicine')" />
<input type="reset" class="button" value="Reset " align="left" 	onClick="" />
<% } %>
	<%}else{ %>
	<h4>No record Found!</h4>
	<%} %>
	
	<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('medicineissue','ipd?method=showPatientListNurseJsp');"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="clear"></div>


    
  <%--    
    
    <input type="hidden" value="<%=hinId %>" name="hinId" id="hinId"/>
    <input type="hidden" value="<%=deptId %>" name="deptId" id="deptId"/>


<input type="button" class="button" value="Submit " align="left" onclick="submitForm('nursingCareEntryDetail','ipd?method=submitWardConsumption&inpatientId=<%=inpatientId1 %>');" />
<input type="button" class="button" value="Print " align="left" onclick="submitForm('nursingCareEntryDetail','ipd?method=showPatientMedicineDetailNew&hinNo=<%=hinNo %>&adNo=<%=adNo %>');" />
<input type="button" class="button" value="Back" align="left" onclick="submitForm('nursingCareEntryDetail','ipd?method=showPatientListJspNew');" />
<input type="button" class="buttonBig2" value="View Previous Details" onclick="getPrevIssueDrug();" />
  
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 --%>
 
 
<script type="text/javascript" language="javascript"><!--
function switcheAgree(row)

	{
	
	if(document.getElementById("consumptionStop"+row) == true)
	{
	
		document.getElementById("once"+row).disabled = true }
	}


function checkPatientForDischarge()
{

	if(document.getElementById('parent').value==''){
		if(!displayAlert("Please select the patient."))
			alert("Please select the patient.");
		return false;
	}
	if(document.getElementById('parent').value!=''){
		if(document.getElementById('patientStatus').value=='R'){
				return true;
		}else{
			if(!displayAlert("Patient is not ready to discharge."))
				alert("Patient is not ready to discharge.");
			return false;
		}
	}
}

function checkTimeFormat(){

	var chtime=document.getElementById("caretime").value
 	if(chtime==""){
 		if(!displayAlert('Changed Time  can not be blank'))
 	 		alert('Changed Time  can not be blank');
 		getShadow("caretime");
		return false
	}
	 if(chtime!= ""){
	 			var index=chtime.indexOf(':');
	 			//alert(index)
				if(!validateInteger(trimAll(chtime)))
				{
					if(!displayAlert(" Time should be a number(without spaces) without special Characters in HH:MM Format."))
						alert(" Time should be a number(without spaces) without special Characters in HH:MM Format.");
					getShadow("caretime");
					return false
				}
				if(index == -1)
					if(!displayAlert("Please Enter The Time in Correct Format."))
						alert("Please Enter The Time in Correct Format.")
				  getShadow("caretime");
		 //var indx = chtime.indexOf(':');

		 if (index != -1) {
		 var pairs2 = chtime.substring(0,chtime.length).split(':');
		 }

		 if (pairs2.length!=2) {
			 if(!displayAlert("Invalid Time Format.It should be HH:MM"))
				 alert("Invalid Time Format.It should be HH:MM");
			 getShadow("caretime");
			return false;
			}

		 if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
			 if(!displayAlert("Invalid Time Format.It should be HH:MM"))
				 alert("Invalid Time Format.It should be HH:MM");
				  getShadow("caretime");
				  return false;
				}

		 		 val2=eval(pairs2[0]);

						  if (val2<0 || val2>23) {
							  if(!displayAlert("Hours should 00-23"))
								  alert("Hours should 00-23");
							  getShadow("caretime");
					 		 return false;}

					 		 val3=eval(pairs2[1]);

							  if (val3<0 || val3>59) {
								  if(!displayAlert("Min should 00-59"))
									  alert("Min should 00-59");
							  getShadow("caretime");
					 		 return false;}

		return true;
	}
	}

function getPrevIssueDrug()
{
	var url='/hms/hms/ipd?method=showPrescriptionViewDetail&hinId='+document.getElementById('hinId').value+'&deptId='+document.getElementById('deptId').value ;
	 popwindow(url);
 }  

var newwindow;
function popwindow(url)
{
 newwindow=window.open(url,'name','height=500,width=800,status=1');
 if (window.focus) 
 {
 newwindow.focus();
 }
//newwindow.createPopup();

}

function applyValidation(obj,i)
{
	if(obj.checked)
		{
		 document.getElementById("stockId"+i).setAttribute("validate", "Batch No,int,yes");
		}
	else
		{
		document.getElementById("stockId"+i).setAttribute("validate", "Batch No,int,no");
		}
}
function validateMedicineissue()
{
	var count=document.getElementById('counter').value;
	var selected=0;

	for(var i=1;i<=count;i++)
		{
		if(document.getElementById('medstop'+i)!=null && document.getElementById('medstop'+i).checked){
			selected++;
		}else{
		if(document.getElementById('care'+i)!=null && document.getElementById('care'+i).checked)
			{
			selected++;
			}
		}
		}
	if(selected==0)
		{
		alert('Please select atleast one Medicine');
		return false;
		}
	return true;
}
</script>