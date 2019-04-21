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
<%@page import="jkt.hms.masters.business.IpdVitalSetup"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.IFNULL"%>
<%@page import="jkt.hms.masters.business.MasCareType"%>
<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<script type="text/javascript">
	function validatedCare() {
		/* //alert("haloooo");
		for (var i = 0; i < document.getElementsByName('frequency').length; i++) {
			//alert("i-- "+i)

			var care = document.getElementById('careName' + i).value
			//alert("document.getElementsByName('cares').length"+ document.getElementsByName('cares').length)
			//alert("document.getElementsByName('cares')[i].checked==="+ document.getElementsByName('cares')[i].checked)
			if (document.getElementsByName('frequency')[i].value != 0
					&& document.getElementsByName('cares')[i].checked == false) {

				alert("Please select the " + care + " Care")
				return false;
			}
			if (document.getElementsByName('frequency')[i].value == 0
					&& document.getElementsByName('cares')[i].checked == true) {
				alert("Please select the " + care + " Frequency")
				return false;
			}
		}
		return true; */
		
		validateRequiredFieldNursingCare();
		validateRequiredFieldVitalCare();
		submitForm('clinicalSetup','ipd?method=addNursingCare');
	}
</script>

<%
Inpatient inpatient=null;
	Map map = new HashMap();
	String includedJsp = "";
	String userName = "";
	String deptName = "";
	String admissionNumber = null;
	int hinId = 0;
	int inpatientId = 0;
	String consultantName = "";
	String patientName = "";
	String serviceNo = null;
	String unitName = "";
	String rankName = "";
	String hinNo = "";
	String adNo = "";
	
	String currentAge = "";
	String gender="-";
	String pCategory="";
	String materialStatus="";
	String admittedBy="-";
	
	List<String> vitalList = new ArrayList<String>();
	vitalList.add("Temperature");
	vitalList.add("Pulse");
	vitalList.add("Respiration");
	vitalList.add("BP");
	vitalList.add("Bowl");
	vitalList.add("Pain");
	vitalList.add("Girth");
	vitalList.add("Blood Sugar");
	vitalList.add("Insulin");
	
	List inPatientDetailList = new ArrayList();
	List nursingCareList = new ArrayList();
	List<NursingcareSetup> nursingCareSetupList = new ArrayList<NursingcareSetup>();
	List<IpdVitalSetup> ipdVitalSetupList = new ArrayList<IpdVitalSetup>();
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	try {
		inPatientDetailList = (List) map.get("inPatientDetailList");
		nursingCareList = (List) map.get("nursingCareList");
		nursingCareSetupList = (List<NursingcareSetup>) map.get("nursingCareSetupList");
		frequencyList = (List) map.get("frequencyList");
		ipdVitalSetupList = (List<IpdVitalSetup>) map.get("ipdVitalSetupList");

	} catch (Exception e) {
		e.printStackTrace();
	}

	if (inPatientDetailList != null) {
		
		Inpatient inPatientDetail = (Inpatient) inPatientDetailList.get(0);
		inpatient=inPatientDetail;
		if(inpatient!=null){
			patient = inpatient.getHin();
			hinId=inpatient.getHin().getId();
			inpatientId=inpatient.getId();
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

		}
		
		session.setAttribute("admissionNumber", admissionNumber);
		session.setAttribute("inpatient",inpatient);
	}
%>




<div class="titleBg">
	<h2>Nursing Care Setup</h2>
</div>
<div class="clear"></div>
<form name="clinicalSetup" method="post" action="">
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
		<h4>Care Setup</h4>
		<div class="clear"></div>
		<div class="paddingTop25"></div>

		<div class="clear"></div>
		<div style="float: right;">
			<input type="button" class="buttonAdd" value="" align="right"
				onclick="javascript:addRowForNursingcare();"> <input
				type="button" name="Reset" value="" class="buttonDel" align="right"
				onclick="javascript:removeRowForNursingcare();">
		</div>
		<div class="clear"></div>
		<div class="paddingTop25"></div>
		<div class="clear"></div>
		<table border="0" cellpadding="0" cellspacing="0"
			id="nursingcaretable">
			<tr>
				<th>&nbsp;</th>
				<th>Nursing Care / Procedure</th>
				<th>Frequency</th>
				<th>Stop</th>
				<th>Remarks</th>
			</tr>
			<%
								int countNursingCare=0;
								if(nursingCareSetupList.size()>0)
								{
									for(NursingcareSetup nursingcareSetup:nursingCareSetupList)
									{
										countNursingCare++;
										%>
			<tr>
				<td><input type="checkbox" class="radioCheck"
					id="radionursingcare<%=countNursingCare%>"
					name="radionursingcare<%=countNursingCare%>" /></td>
				<td width="27%"><select
					name="<%=CARE_TYPE_ID%><%=countNursingCare%>"
					id="<%=CARE_TYPE_ID%><%=countNursingCare%>"
					onblur="validateDuplicateNursingCare('<%=countNursingCare%>')">
						<option value="0">Select</option>
						<%
												for (Object masCareTypeObject : nursingCareList) {
													MasNursingCare masNursingCare=(MasNursingCare)masCareTypeObject;
													if(masNursingCare.getId()==nursingcareSetup.getNursing().getId())
													{%>
						<option value="<%=masNursingCare.getId()%>" selected="selected">
							<%=masNursingCare.getNursingName()%>
						</option>
						<%
													}
													else{
												%>
						<option value="<%=masNursingCare.getId()%>">
							<%=masNursingCare.getNursingName()%>
						</option>
						<%
												}
												}
											%>
				</select></td>
				<td width="27%"><select
					name="<%=FREQUENCY%><%=countNursingCare%>"
					id="<%=FREQUENCY%><%=countNursingCare%>"
					validate="Complaint,string,no">
						<option value="0">Select</option>
						<%
												for (MasFrequency masFrequency : frequencyList) {
													if(masFrequency.getId()==nursingcareSetup.getFrequency().getId())
													{%>
						<option value="<%=masFrequency.getId()%>" selected="selected">
							<%=masFrequency.getFrequencyName()%>
						</option>
						<%
													}
													else{
											%>
						<option value="<%=masFrequency.getId()%>">
							<%=masFrequency.getFrequencyName()%>
						</option>
						<%
												}
												}
											%>
				</select></td>
				<td><input type="checkbox" name="carestop<%=countNursingCare%>"
					id="carestop<%=countNursingCare%>" value="1" /></td>
				<td><input type="text"
					name="<%=CARE_REMARKS%><%=countNursingCare%>"
					id="<%=CARE_REMARKS%><%=countNursingCare%>"
					value="<%=nursingcareSetup.getRemarks()!=null?nursingcareSetup.getRemarks():""%>" />
				</td>
			</tr>
			<%
									}
								}
								else
								{
									countNursingCare++;
								%>

			<tr>
				<td><input type="checkbox" class="radioCheck"
					id="radionursingcare1" name="radionursingcare1" /></td>
				<td width="27%"><select name="<%=CARE_TYPE_ID%>1"
					id="<%=CARE_TYPE_ID%>1" onblur="validateDuplicateNursingCare('1')">
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
				<td width="27%"><select name="<%=FREQUENCY%>1"
					id="<%=FREQUENCY%>1" validate="Complaint,string,no">
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
				<td><input type="checkbox" name="carestop1" id="carestop1"
					value="1" /></td>
				<td><input type="text" name="<%=CARE_REMARKS%>1"
					id="<%=CARE_REMARKS%>1" /></td>
			</tr>
			<%} %>

			</tbody>

	
		</table>
		<input type="hidden" name="nursingcarecount" id="nursingcarecount"
			value="<%=countNursingCare%>" />

		<div class="clear"></div>
		<div class="paddingTop25"></div>
		<div class="clear"></div>
		<h4>Vital Setup</h4>
		<div class="clear"></div>
		<div class="paddingTop25"></div>

		<div class="clear"></div>


		<div class="clear"></div>
		<div style="float: right;">
			<input type="button" class="buttonAdd" value="" align="right"
				onclick="javascript:addRowForVitalcare();"> <input
				type="button" name="Reset" value="" class="buttonDel" align="right"
				onclick="javascript:removeRowForVitalcare();">
		</div>
		<div class="clear"></div>
		<div class="paddingTop25"></div>
		<div class="clear"></div>
		<table border="0" cellpadding="0" cellspacing="0" id="vitalcaretable">
			<tr>
				<th>&nbsp;</th>
				<th>Vitals</th>
				<th>Frequency</th>
				<th>Stop</th>
				<th>Remarks</th>
			</tr>
			<%
								int vitalCount=0;
								if(ipdVitalSetupList.size()>0)
								{
									for(IpdVitalSetup ipdVitalSetup:ipdVitalSetupList)
									{
										vitalCount++;
										%>
			<tr>
				<td><input type="checkbox" class="radioCheck"
					id="radiovitalCare<%=vitalCount%>"
					name="radiovitalCare<%=vitalCount%>" /></td>
				<td width="27%"><select name="vitalName<%=vitalCount%>"
					id="vitalName<%=vitalCount%>"
					onblur="validateDuplicateVitalCare('<%=vitalCount%>')">
						<option value="0">Select</option>
						<%
												for (String vital : vitalList) {
													if(vital.equalsIgnoreCase(ipdVitalSetup.getVitalName()))
													{%>
						<option value="<%=vital%>" selected="selected">
							<%=vital%>
						</option>
						<%
													}
													else{
												%>
						<option value="<%=vital%>">
							<%=vital%>
						</option>
						<%
												}
												}
											%>
				</select></td>
				<td width="27%"><select name="vitalFrequency<%=vitalCount%>"
					id="vitalFrequency<%=vitalCount%>" validate="Complaint,string,no">
						<option value="0">Select</option>
						<%
												for (MasFrequency masFrequency : frequencyList) {
													if(masFrequency.getId()==ipdVitalSetup.getFrequency().getId())
													{%>
						<option value="<%=masFrequency.getId()%>" selected="selected">
							<%=masFrequency.getFrequencyName()%>
						</option>
						<%
													}
													else{
											%>
						<option value="<%=masFrequency.getId()%>">
							<%=masFrequency.getFrequencyName()%>
						</option>
						<%
												}
												}
											%>
				</select></td>
				<td><input type="checkbox" name="vitalstop<%=vitalCount%>"
					id="vitalstop<%=vitalCount%>" value="1" /></td>
				<td><input type="text" name="vitalRemarks<%=vitalCount%>"
					id="vitalRemarks<%=vitalCount%>"
					value="<%=ipdVitalSetup.getRemarks()!=null?ipdVitalSetup.getRemarks():""%>" />
				</td>
			</tr>
			<%
									}
								}
								else
								{
									vitalCount++;
								%>
			<tr>
				<td><input type="checkbox" class="radioCheck"
					id="radiovitalCare<%=vitalCount%>"
					name="radiovitalCare<%=vitalCount%>" /></td>
				<td width="27%"><select name="vitalName<%=vitalCount%>"
					id="vitalName<%=vitalCount%>"
					onblur="validateDuplicateVitalCare('<%=vitalCount%>')">
						<option value="0">Select</option>
						<%
												for (String vital : vitalList) {
													%>


						<option value="<%=vital%>">
							<%=vital%>
						</option>
						<%
												}
											%>
				</select></td>
				<td width="27%"><select name="vitalFrequency<%=vitalCount%>"
					id="vitalFrequency<%=vitalCount%>" validate="Complaint,string,no">
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
				<td><input type="checkbox" name="vitalstop<%=vitalCount%>"
					id="vitalstop<%=vitalCount%>" value="1" /></td>
				<td><input type="text" name="vitalRemarks<%=vitalCount%>"
					id="vitalRemarks<%=vitalCount%>" value="" /></td>
			</tr>
			<%} %>

			</tbody>
		</table>
		<input type="hidden" name="vitalcarecount" id="vitalcarecount"
			value="<%=vitalCount%>" />

		<div class="clear"></div>
		<div class="paddingTop25"></div>
		<div class="clear"></div>

		<input type="button" class="button" value="Submit" align="left"
			onclick="validatedCare();" /> <input type="reset" class="button"
			name="reset" value="reset"
			onclick="submitFormForButton('clinicalSetup','ipd?method=showNursingCareJsp');" />
		<input type="reset" class="button" name="reset" value="Back"
			onclick="submitFormForButton('clinicalSetup','ipd?method=showPatientListNurseJsp');" />

		<!-- <input type="button" class="button" value="Back" align="left"
		onclick="submitForm('clinicalSetup','ipd?method=showPatientListJsp');" /> -->

		<div class="clear"></div>
		<div class="clear"></div>
		<div class="paddingTop40"></div>
		<div class="clear"></div>
		<input type="hidden" name="hinId" value="<%=hinId%>" /> <input
			type="hidden" name="inpatientId" value="<%=inpatientId%>" /> <input
			type="hidden" name="deptName" value="<%=deptName%>" />
		<%
		// this hidden field is for testing hl7 message
	%>
		<input type="hidden" name="consultantName" value="<%=consultantName%>" />
		<input type="hidden" name="eventType" value="ADT01" /> <input
			type="hidden" name="userName" value="<%=userName%>" />

	</div>
</form>

<script type="text/javascript">	var	frequencyArray= new Array();
                 <%
	    		MasFrequency  frequency = new MasFrequency();

			     for (int k = 0; k < frequencyList.size(); k++) {
			    	 frequency = (MasFrequency) frequencyList.get(k);
     			 %>

     			frequencyArray[<%=k%>]= new Array();
     			frequencyArray[<%=k%>][0] = "<%=frequency.getId()%>";
     			frequencyArray[<%=k%>][1] = "<%=frequency.getFrequencyName()%>";
     			<% }%> 
            </script>

<script type="text/javascript">	var	nursingCareSetupList= new Array();
                 <%

			     for (int k = 0; k < nursingCareList.size(); k++) {
			    	 MasNursingCare nursingCare = (MasNursingCare) nursingCareList.get(k);
     			 %>

     			nursingCareSetupList[<%=k%>]= new Array();
     			nursingCareSetupList[<%=k%>][0] = "<%=nursingCare.getId()%>";
     			nursingCareSetupList[<%=k%>][1] = "<%=nursingCare.getNursingName()%>";
     			<% }%> 
            </script>



<script type="text/javascript">
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
        		var j=1;
        		  for(var i = 0;i<nursingCareSetupList.length;i++ ){
        		e1.options[j] = new Option(nursingCareSetupList[i][1],nursingCareSetupList[i][0]);
        		
        		  j++;
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
        		var k=1;
        		  for(var i = 0;i<frequencyArray.length;i++ ){
        		e1.options[k] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
        		k++;
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
            
            
            
            function addRowForVitalcare(){
        		var tbl = document.getElementById('vitalcaretable');
        		var lastRow = tbl.rows.length;
        		// if there's no header row in the table, then iteration = lastRow + 1
        		var iteration = lastRow;
        		var row = tbl.insertRow(lastRow);
        		var hdb = document.getElementById('vitalcarecount');
        		iteration = parseInt(hdb.value)+1;
        		hdb.value=iteration;

        		var cellRight1 = row.insertCell(0);
        		var e1 = document.createElement('input');
        		e1.type = 'checkbox';
        		e1.name='radiovitalCare'+iteration;
        		e1.id='radiovitalCare'+iteration;
        		e1.className='radioCheck';
        		cellRight1.appendChild(e1);
        		
        		var cellRight1 = row.insertCell(1);
        		var e1 = document.createElement('Select');
        		e1.name='vitalName'+iteration;
        		e1.id='vitalName'+iteration;
        		e1.options[0] = new Option('Select', '0');
        		var vitalCount=0;
        		<%
        		
				for (String vital : vitalList) {
					%>
					vitalCount++;
					e1.options[vitalCount] = new Option('<%=vital%>','<%=vital%>');
			<%
				}
			%>
	e1.onblur = function() {
			validateDuplicateVitalCare(iteration);
		};
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(2);
		var e1 = document.createElement('Select');
		e1.name = 'vitalFrequency' + iteration;
		e1.id = 'vitalFrequency' + iteration;
		e1.options[0] = new Option('Select', '0');
		var l=1;
		for (var i = 0; i < frequencyArray.length; i++) {
			e1.options[l] = new Option(frequencyArray[i][1],
					frequencyArray[i][0]);
			l++;
		}
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(3);
		var e1 = document.createElement('input');
		e1.type = 'checkbox';
		e1.name = 'vitalstop' + iteration;
		e1.id = 'vitalstop' + iteration;
		e1.value = '1';
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(4);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'vitalRemarks' + iteration;
		e1.id = 'vitalRemarks' + iteration;
		/* e1.onblur=function(){
		populatebrand(this.value, iteration);
		checkItem(iteration);
		}; */
		cellRight1.appendChild(e1);

	}

	function removeRowForVitalcare() {
		var tbl = document.getElementById('vitalcaretable');
		var lastRow = tbl.rows.length;
		var hdb = document.getElementById('vitalcarecount');
		var iteration = parseInt(hdb.value);
		var totalSelected = 0;
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("radiovitalCare" + i) != null
					&& (typeof document.getElementById("radiovitalCare" + i).checked) != 'undefined'
					&& document.getElementById("radiovitalCare" + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}
		if (totalSelected == 0) {
			alert('Please select atleast 1 row to delete');
		} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
			alert('You can not delete all Row.');
		} else if (lastRow > 2) {
			for (var i = 1; i <= iteration; i++) {
				if (document.getElementById("radiovitalCare" + i) != null
						&& (typeof document
								.getElementById("radiovitalCare" + i).checked) != 'undefined'
						&& document.getElementById("radiovitalCare" + i).checked) {
					var deleteRow = document.getElementById("radiovitalCare"
							+ i).parentNode.parentNode;
					document.getElementById("radiovitalCare" + i).parentNode.parentNode.parentNode
							.removeChild(deleteRow);
				}
			}
		}
	}

	function validateDuplicateVitalCare(index) {
		var count = document.getElementById('vitalcarecount').value;
		var vitalName = document.getElementById("vitalName" + index).value;
		for (var i = 1; i <= count; i++) {
			if (i != index && document.getElementById("vitalName" + i) != null
					&& document.getElementById("vitalName" + i).value != ''
					&& document.getElementById("vitalName" + i).value != '0') {
				if (document.getElementById("vitalName" + i).value == vitalName) {

					alert(document.getElementById("vitalName" + i).options[document
							.getElementById("vitalName" + i).selectedIndex].text
							+ " is duplicate");
					document.getElementById("vitalName" + index).value = 0;
					return false;
				}

			}
		}
		return true;
	}

	function validateRequiredFieldVitalCare() {
		var count = document.getElementById('vitalcarecount').value;
		for (var i = 1; i <= count; i++) {
			if (document.getElementById("vitalName" + i) != null
					&& document.getElementById("vitalName" + i).value != ''
					&& document.getElementById("vitalName" + i).value != '0') {
				document.getElementById("vitalName" + i).setAttribute(
						"validate", "Vital,string,yes");
				document.getElementById("vitalFrequency" + i).setAttribute(
						"validate", "Frequency,int,yes");
				document.getElementById("vitalRemarks" + i).setAttribute(
						"validate", "Remarks,string,no");
			}
		}
	}
</script>

