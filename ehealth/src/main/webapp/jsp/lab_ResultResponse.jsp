
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.PatientMainLabInfo"%>
<%@page import="jkt.hms.masters.business.PatientLabInfo"%>
<%@page import="jkt.hms.masters.business.LabMachineXt2000iDetails"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> result_map = new HashMap<String, Object>();
String fromdate="";
String machineName="";
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
if(map.get("ShowvalidateDetails") != null)
{
	result_map =  (Map<String,Object>) map.get("ShowvalidateDetails");
}
if(map.get("fromdate") != null)
{
	fromdate =  (String) map.get("fromdate");
}
if(map.get("machineName") != null)
{
	machineName =  (String) map.get("machineName");
}


Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();

String date = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}

//int divId=(Integer)map.get("divId");
List<PatientMainLabInfo> patientMainlabInfo = new ArrayList<PatientMainLabInfo>();
List<PatientLabInfo> patientlabInfo = new ArrayList<PatientLabInfo>();
List<LabMachineXt2000iDetails> labMachinextList = new ArrayList<LabMachineXt2000iDetails>();
List<DgMasInvestigation> dgMasInvestigation = new ArrayList<DgMasInvestigation>();
List<DgSubMasInvestigation> dgMasSubInvestigation = new ArrayList<DgSubMasInvestigation>();
List<DgSampleCollectionDetails> dgMasSamplecollection = new ArrayList<DgSampleCollectionDetails>();

if(result_map.get("patientMainlabInfo") != null)
{
	patientMainlabInfo = (List<PatientMainLabInfo>)result_map.get("patientMainlabInfo");
}
if(result_map.get("patientlabInfo") != null)
{
	patientlabInfo = (List<PatientLabInfo>)result_map.get("patientlabInfo");

}
if(result_map.get("labMachinextList") != null)
{
	labMachinextList = (List<LabMachineXt2000iDetails>)result_map.get("labMachinextList");
}
if(result_map.get("dgMasInvestigation") != null)
{
	dgMasInvestigation = (List<DgMasInvestigation>)result_map.get("dgMasInvestigation");
}
if(result_map.get("dgMasSubInvestigation") != null)
{
	dgMasSubInvestigation = (List<DgSubMasInvestigation>)result_map.get("dgMasSubInvestigation");
}
if(result_map.get("dgMasSamplecollection") != null)
{
	dgMasSamplecollection = (List<DgSampleCollectionDetails>)result_map.get("dgMasSamplecollection");
}


boolean Nodata=false;
String message="No Data Found";
/*
if(map.get("message") != null)
{
	message=(String)map.get("message");

}
 Map<String, Object> utilMap = new HashMap<String, Object>();
 utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 String currentDate = (String) utilMap.get("currentDate");
 String time = (String) utilMap.get("currentTime");
*/

%>

<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>

<div id="contentHolder">
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>

<h6>Validate Analyzer Records Details</h6>
<form name="sampleForm" method="post" action="">
<div class="Clear"></div>
<div class="tableHolderAuto">

<table width="100%" id="chargeDetails" cellpadding="0"	cellspacing="0">

<div class="tableHolderAuto">

<table width="100%"  id="chargeDetails" cellpadding="0"	cellspacing="0">

	<tr>
		<th>Diagnostic No :</th>
		<th>Parameter Name :</th>
		<th>Measurement Value:</th>
		<th>Unit :</th>
		<th>Investigation Name :</th>
		<th>Sub Investigation Name :</th>

	</tr>
	<%
	if(patientMainlabInfo!=null&&patientMainlabInfo.size()>0)
	{
		for (PatientMainLabInfo patientMainlabInfolist : patientMainlabInfo)
		{

			if(patientlabInfo!=null&&patientlabInfo.size()>0)
			{
			     for (PatientLabInfo patientlabInfolist : patientlabInfo)
			     {

	        			if(patientMainlabInfolist.getSampleNo().equals(patientlabInfolist.getSampleNo()))
		    		{
	        				if(labMachinextList!=null&&labMachinextList.size()>0)
							{

							     for (LabMachineXt2000iDetails LabMachinextlist : labMachinextList)
							     {
					        			if(patientlabInfolist.getParameterName().equalsIgnoreCase(LabMachinextlist.getParameterName()))
						    		{
					        				boolean  data=false;
					        				if(dgMasInvestigation!=null&&dgMasInvestigation.size()>0)
											{
											     for (DgMasInvestigation dgMasInvestigationList : dgMasInvestigation)
											     {


											    	 if(LabMachinextlist.getInvestigationId() !=null)
											    	 {
									        			if(LabMachinextlist.getInvestigationId().equals(dgMasInvestigationList.getId()))
										    		{
									        			for(DgSampleCollectionDetails collection:dgMasSamplecollection)
									        				{
									        				if(LabMachinextlist.getInvestigationId().equals(collection.getInvestigation().getId()))
									        				{%>
										    		<tr><%
					        				if(patientMainlabInfolist.getDiagNo()!= null)
					        				{
					        					Nodata=true;
											%>
											<td>
												<input type="text" name="<%=DIAGNOSIS_NO%>" value="<%=patientMainlabInfolist.getDiagNo() %>" readonly="readonly"/>

											</td>
											<%}else
												{%>
												<td>
												<input type="text" name="<%=DIAGNOSIS_NO%>" value="" readonly="readonly"/>
											   </td>
												<%} %>
					        				<td>
					        				<input type="hidden" name="<%=TIME %>" value="<%=patientMainlabInfolist.getTime()%>" />
											<input type="text" name="parameterName" value="<%=LabMachinextlist.getParameterName()%>" readonly="readonly"/>
					        				</td>
					        				<td>
					        				<input type="text" name="<%=MEASUREMENT_VALUE %>" value="<%=patientlabInfolist.getMeasurementValue()%>" readonly="readonly"/>
					        				</td>
					        				<td>
					        				<input type="text" name="unit" value="<%=patientlabInfolist.getUnit()%>" readonly="readonly"/>
					        				</td>
					        				<td>
										    		<input type="text" name="invesId" value="<%=dgMasInvestigationList.getInvestigationName()%>" readonly="readonly"/>
                                                    <input type="hidden" name="<%=INVESTIGATION_ID %>" value="<%=dgMasInvestigationList.getId()%>" />

					        				</td>
									        		<%  if(LabMachinextlist.getSubInvestigationId() !=null)
															{
															     for (DgSubMasInvestigation dgMasSubInvestigationList : dgMasSubInvestigation)
															     {
													        			if(LabMachinextlist.getSubInvestigationId().equals(dgMasSubInvestigationList.getId()))
														    		{
													        				data=true;
													        			%>
													        			<td>
													        			<input type="text" name="subiigationId" value="<%=dgMasSubInvestigationList.getSubInvestigationName()%>" readonly="readonly"/>
					        				                             <input type="hidden" name="<%=SUB_INVESTIGATION_ID %>" value="<%=dgMasSubInvestigationList.getId()%>" />
					        				</td>
													        			<%
																    }
															 }
															}
									        		if(data==false)
									        		{  %>
									        			<td>
									        			<input type="text" name="subinvestigationId" value="" readonly="readonly"/>
                            	        				 <input type="hidden" name="<%=SUB_INVESTIGATION_ID %>" value="" />
                            	        				</td>
									        		<%
									        		}
												    }
									        				}
										    		}
											 }
											     }
											}

								   %>
								   </tr>
						    	<% 	}
							 }

							}
				    }
			 }
			}

		}
	}

	%>


<input type="hidden" name="<%=FROM_DATE%>" value="<%=fromdate%>" />
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />


</table>
<%

	if(Nodata==false)
	{%>
		<tr><h1><font id="error"><%=message %></font></h2></tr>
	<% }%>
	<div class="Clear"></div>

    </div>
    </table>
    <%

	if(Nodata==true)
	{%>
		<input type="button" name="validate"
	id="addbutton" value="Validate" class="button"
	onClick="submitForm('sampleForm','lab?method=addAnalyserResult')"
	accesskey="u" tabindex=1 />
	<input type="button" name="invalidate" id="addbutton" value="InValidate" class="button" accesskey="r"
	 onClick="submitForm('sampleForm','lab?method=invalidateAnalyserResult')" tabindex=1 />
   <input type="button" name="back" id="backid" value="Back" class="button" accesskey="r" onClick="submitForm('sampleForm','lab?method=showLabTestResultJsp')"  tabindex=2 />

	<% }%>

 <%

	if(Nodata==false)
	{%>
		<input type="button" name="validate"
	id="addbutton" value="Validate" class="button"	accesskey="u" tabindex=1 />
	<input type="button" name="invalidate" id="addbutton" value="InValidate" class="button" accesskey="r"   tabindex=1 />
    <input type="button" name="back" id="backid" value="Back" class="button" accesskey="r" onClick="submitForm('sampleForm','lab?method=showLabTestResultJsp')"  tabindex=2 />

	<% }%>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


    </div>
