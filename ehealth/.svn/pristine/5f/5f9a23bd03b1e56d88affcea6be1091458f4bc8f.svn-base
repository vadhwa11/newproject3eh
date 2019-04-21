<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifyMmfDepartment.jsp
 * Purpose of the JSP -  This is for modify MMF Department.
 * @author  Dipali
 * Create Date: 7th April,2008
 * Revision Date:
 * Revision By:
 * @version 1.2
--%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.IpdIntake"%>
<%@page import="jkt.hms.masters.business.IpdOutput"%>
<%@page import="jkt.hms.masters.business.IpdTemperature"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.IpdIntakeOutputChart"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->

<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	Map map = new HashMap();
	String includedJsp = null;
	String previousPage="no";
	int nrs=0;
	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	String max="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
	List<IpdIntakeOutputChart> ipdIntakeOutputList = new ArrayList<IpdIntakeOutputChart>();
	List<IpdTemperature> ipdTemperatures = new ArrayList<IpdTemperature>();
	
try{
	ipdTemperatures=(List)map.get("ipdTemperatures");
}catch(Exception e){
e.printStackTrace();
}

	try{
			inPatientDetailList=(List)map.get("inPatientDetailList");

	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		ipdIntakeOutputList=(List)map.get("ipdIntakeOutputList");

	}catch(Exception e){
		e.printStackTrace();
	}

	//Set<IpdTemperature> ipdTempratureSet = new HashSet<IpdTemperature>();
	Set<IpdIntake> ipdInatkeSet = new HashSet<IpdIntake>();
	Set<IpdOutput> ipdOutputSet = new HashSet<IpdOutput>();
	Set<IpdOutput> ipdOutputSet1 = new HashSet<IpdOutput>();

	for(IpdIntakeOutputChart ipdIntakeOutputChart : ipdIntakeOutputList){
		//ipdTempratureSet = ipdIntakeOutputChart.getIpdTemperatures();

		ipdInatkeSet = ipdIntakeOutputChart.getIpdIntakes();	
		ipdOutputSet = ipdIntakeOutputChart.getIpdOutputs();
		ipdOutputSet1 = ipdIntakeOutputChart.getIpdOutputs();
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int hospitalId = 0;
	int inpatientId = 0;
	String admissionNumber = "";
	String patientName = "";
	String serviceno = "";
	String rank = "";
	String unit = "";
	String adNo = "";
	String ward = "";
	String relation = "";
	String diagnosis = "";
	String age = "";
	String sex = "";
	String doa = "";
	String serviceType = "";
	int departmentId =0;
	int hinId = 0;
	Inpatient inpatient = null;
	Patient patient = null;
	MasRank masRank = null;
	MasUnit masUnit = null;
	MasDepartment masDepartment=null;
	MasDiagnosisConclusion masDiagnosisConclusion=null;
	MasRelation masRelation = null;
	String category_name = "";
	String consultantName = "";
	String hinNo="";
   if(inPatientDetailList != null)
   {
	   Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
	    hinId=inPatientDetail.getHin().getId();
		try
		{
			inpatient = (Inpatient) inPatientDetailList.get(0);
			inpatientId=inpatient.getId();
			patient = (Patient) inpatient.getHin();
			masDepartment=(MasDepartment)inpatient.getDepartment();
			admissionNumber=inPatientDetail.getAdNo();
			hinNo=patient.getHinNo();
		    session.setAttribute("admissionNumber",admissionNumber);
			consultantName=inPatientDetail.getDoctor().getFirstName()+inPatientDetail.getDoctor().getMiddleName()+inPatientDetail.getDoctor().getLastName();

			try
			{
				String mName="";
				String lName="";
				if(inpatient.getHin().getPMiddleName()!=null){
				mName=inpatient.getHin().getPMiddleName();
				}
				if(inpatient.getHin().getPLastName()!=null){
					lName=inpatient.getHin().getPLastName();
			}
			patientName = inpatient.getHin().getPFirstName() + " " + mName + " "+lName;
			}
			catch (Exception e)
			{
			patientName = "";
			}

					try
					{
						admissionNumber = inpatient.getAdNo();
					}
					catch (Exception e)
					{
						admissionNumber = "";
					}


					try
					{
						ward = masDepartment.getDepartmentName();
					}
					catch (Exception e)
					{
						ward = "";
					}

					try
					{
						diagnosis = masDiagnosisConclusion.getDiagnosisConclusionName();
					}
					catch (Exception e)
					{
						diagnosis = "";
					}

					try
					{
						doa =HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
					}
					catch (Exception e)
					{
						doa = "";
					}


					try
					{
						age = inpatient.getAge();
					}
					catch (Exception e)
					{
						age = "";
					}

					try
					{
						sex = inpatient.getHin().getSex().getAdministrativeSexName();
					}
					catch (Exception e)
					{
						sex = "";
					}

					try
					{
						adNo = inpatient.getAdNo().toString();
					}
					catch (Exception e)
					{
						adNo = "";
					}
					try
					{
						consultantName = inPatientDetail.getDoctor().getFirstName()+inPatientDetail.getDoctor().getMiddleName()+inPatientDetail.getDoctor().getLastName();
					}
					catch (Exception e)
					{
						consultantName = "";
					}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

%>

<div class="titleBg">
<h2>Intake/Output Chart</h2>
</div>
<div class="clear"></div>
<h4><%=deptName%>Ward</h4>
<div class="clear"></div>
<form name="intakeOutput" method="post" action="">
<div class="Block">
<h4>Details</h4>
<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" />
<div class="clear"></div>
<div class="clear"></div>
<label>Patient Name</label> <label class="value"><%=patientName.length()>2?patientName:"-"%></label>
<label>IPD No.</label> <label class="value"> <%=adNo.length()>0?adNo:"-"%></label>
<label>Reg No.</label> <label class="value"><%=hinNo%></label>
<div class="clear"></div>
<label>Ward </label> <label class="value"><%=ward.length()>0?ward:"-"%></label>
<label>DOA</label> <label class="value"><%=doa.length()>0?doa:"-"%></label>
<div class="clear"></div>
<label>consultantName</label> <label class="value"><%=consultantName.length()>0?consultantName:"-"%></label>
<div class="clear"></div>
<label>Age</label> 
<%if(age!=null){ %>
<label class="value"><%=age.length()>0?age:"-"%></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<label>Sex</label> <label class="value"><%=sex.length()>0?sex:"-"%></label>
<label>Diagnosis</label> <label class="value"><%=diagnosis.length()>0?diagnosis:"-"%></label>
<%}	%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>

<table width="100%" colspan="7" id="intakeOutput" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Date</th>
			<th>Time</th>
			<th>Temperature</th>
			<th>Pulse</th>
			<th>Respiration</th>
			<th>BP</th>
			<th>Remarks</th>
		</tr>
	</thead>

	<tbody>
		<%
		if(ipdTemperatures!=null && ipdTemperatures.size()>0){
					for(IpdTemperature ipdTemperature :ipdTemperatures){
				%>
		<tr>
			<td width="3%">
			<%if(ipdTemperature.getDate()!=null){ %> <input type="text"
				value="<%=HMSUtil.changeDateToddMMyyyy(ipdTemperature.getDate()) %>"
				readonly /> <%}else { %> <input type="text" value="" readonly /> <%} %>
			</td>
			<td width="3%">
			<%if(ipdTemperature.getTime()!=null){ %> <input type="text"
				value="<%=ipdTemperature.getTime() %>" readonly="readonly" /> <%}else{ %>
			<input type="text" value="" readonly="readonly" /> <%} %>
			</td>
			<%if(ipdTemperature.getTemperature()!=0){ %>
			<td width="8%"><input type="text"
				value="<%=ipdTemperature.getTemperature() %>" readonly /></td>
			<%}else{ %>
			<td width="8%"><input type="text" value="" readonly /></td>
			<%} %>
			<%if(ipdTemperature.getPulse()!=0){ %>
			<td width="15%"><input type="text"
				value="<%=ipdTemperature.getPulse() %>" readonly /></td>
			<%}else{ %>
			<td width="8%"><input type="text" value="" readonly /></td>
			<%} %>

			<%if(ipdTemperature.getRespiration()!=0){ %>
			<td width="15%"><input type="text"
				value="<%=ipdTemperature.getRespiration() %>" readonly /></td>
			<%}else{ %>
			<td width="8%"><input type="text" value="" readonly /></td>
			<%} %>

			<td width="15%">
			<%if(ipdTemperature.getBp()!=null && !(ipdTemperature.getBp().equals("0"))){ %>
			<input type="text" value="<%=ipdTemperature.getBp() %>" readonly />
			<%}else{ %> <input type="text" value="" readonly /> <%} %>
			</td>
			<td width="15%">
			<%if(ipdTemperature.getRemarks()!=null){ %><input type="text"
				value="<%=ipdTemperature.getRemarks() %>" readonly /> <%}else{ %><input
				type="text" value="" readonly /> <%} %>
			</td>
		</tr>
		<%} }%>
	</tbody>
</table>
<div class="clear"></div>

<h4>Intake Details</h4>


<table width="100%" colspan="7" id="intakeOutput1" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Date</th>
			<th>Time</th>
			<!-- <th>Intake</th> -->
			<th>Oral</th>
			<th>IV</th>
			<th>Ryle's Tube</th>
			<th>Total</th>
			<th>Remarks</th>
		</tr>
	</thead>

	<tbody>
		<%	if(ipdInatkeSet!=null && ipdInatkeSet.size()>0){
						for(IpdIntake ipdIntake :ipdInatkeSet){
				%>
		<tr>
			<td width="4%">
			<%if(ipdIntake.getDate()!=null){ %> <input type="text"
				value="<%=HMSUtil.changeDateToddMMyyyy(ipdIntake.getDate()) %>"
				readonly /> <%}else  { %> <input type="text" value="" readonly /> <%} %>
			</td>
			<td width="5%">
			<%if(ipdIntake.getDate()!=null){ %> <input type="text"
				value="<%=ipdIntake.getTime() %>" readonly /> <%}else{ %><input
				type="text" value="" readonly /> <%} %>
			</td>
			<%-- <td width="21%">
			<%if(ipdIntake.getIntake()!=null){ %> <input type="text"
				value="<%=ipdIntake.getIntake() %>" readonly /> <%}else{ %> <input
				type="text" value="" readonly /> <%} %>
			</td> --%>
			<td width="21%">
			<%if(ipdIntake.getOral()!=null){ %> <input type="text"
				value="<%=ipdIntake.getOral() %>" readonly /> <%}else{ %> <input
				type="text" value="" readonly /> <%} %>
			</td>
			<td width="25%">
			<%if(ipdIntake.getIv()!=null && ipdIntake.getIv()!=null){ %> <input
				type="text"
				value="<%=ipdIntake.getIv() %>"
				readonly /> <%}else{ %> <input type="text" value="" readonly /> <%} %>
			</td>
			<td width="19%">
			<%if(ipdIntake.getRyleTube()!=null){ %> <input type="text"
				value="<%=ipdIntake.getRyleTube() %>" readonly /> <%}else{ %> <input
				type="text" value="" readonly /> <%} %>
			</td>
			<td width="19%">
			<%if(ipdIntake.getTotalIntake()!=null){ %> <input type="text"
				value="<%=ipdIntake.getTotalIntake() %>" readonly /> <%}else{ %> <input
				type="text" value="" readonly /> <%} %>
			</td>
			
			<td width="19%">
			<%if(ipdIntake.getRemarks()!=null){ %> <input type="text"
				value="<%=ipdIntake.getRemarks() %>" readonly /> <%}else{ %> <input
				type="text" value="" readonly /> <%} %>
			</td>
		</tr>
		<%}} %>
	</tbody>
</table>

<div class="clear"></div>
<h4>Output Details</h4>



<table width="100%" colspan="7" id="intakeOutput2" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Date</th>
			<th>Time</th>
			<th>Bleeding PVO</th>
			<th>Drain</th>
			<th>Urine</th>
			<!-- <th>Stool</th> -->
			<th>Vom</th>
			<th>ASP</th>
			<th>Total</th>
			<th>Remarks</th>

		</tr>
	</thead>
	<tbody>
		<%
		if(ipdOutputSet!=null && ipdOutputSet.size()>0){
						for(IpdOutput ipdOutput :ipdOutputSet){
				%>
		<tr>
			<td width="3%">
			<%if(ipdOutput.getDate()!=null){ %> <input type="text"
				value="<%=HMSUtil.changeDateToddMMyyyy(ipdOutput.getDate()) %>"
				readonly /> <%}else{ %> <input type="text" value="" readonly /> <%} %>
			</td>
			<td width="3%">
			<%if(ipdOutput.getTime()!=null){
				%> <input type="text" value="<%=ipdOutput.getTime() %>" readonly />
			<%}else{ %> <input type="text" value="" readonly /> <%} %>
			</td>
			<td width="14%">
			<%if(ipdOutput.getBleedingPvo()!=null){ %> <input type="text"
				value="<%=ipdOutput.getBleedingPvo() %>" readonly /> <%}else{ %> <input
				type="text" value="" readonly /> <%} %>
			</td>
			<td width="16%">
			<%if(ipdOutput.getDrain()!=null){ %> <input type="text"
				value="<%=ipdOutput.getDrain() %>" readonly /> <%}else{ %> <input
				type="text" value="" readonly /> <%} %>
			</td>
			<td width="16%">
			<%if(ipdOutput.getUrine()!=null){ %> <input type="text"
				value="<%=ipdOutput.getUrine() %>" readonly /> <%}else{ %> <input
				type="text" value="" readonly /> <%} %>
			</td>
			<%-- <td width="14%">
			<%if(ipdOutput.getStool()!=null){ %>
			<input type="text"
				value="<%=ipdOutput.getStool() %>" readonly />
				<%}else{ %>
			<input type="text"
				value="" readonly />
				<%} %>
				</td> --%>
			<td width="16%">
			<%if(ipdOutput.getVom()!=null){ %>
			<input type="text"
				value="<%=ipdOutput.getVom() %>" readonly />
				<%}else{ %>
				<input type="text"
				value="" readonly />
				<%} %>
				</td>
			<td width="16%">
			<%if(ipdOutput.getAsp()!=null){ %>
			<input type="text"
				value="<%=ipdOutput.getAsp() %>" readonly />
				<%}else{ %>
				<input type="text"
				value="" readonly />
				<%} %>
				
				</td>
				<td width="12%">
			<%if(ipdOutput.getTotalOutput()!=null){ %>
			<input type="text"
				value="<%=ipdOutput.getTotalOutput() %>" readonly />
				<%}else{ %>
			<input type="text"
				value="" readonly />
				
				<%} %>
				</td>
			<td width="12%">
			<%if(ipdOutput.getRemarks()!=null){ %>
			<input type="text"
				value="<%=ipdOutput.getRemarks() %>" readonly />
				<%}else{ %>
			<input type="text"
				value="<%=ipdOutput.getRemarks() %>" readonly />
				
				<%} %>
				</td>
		</tr>
		<%}} %>
	</tbody>
</table>
<%-- <div class="clear"></div>
<div class="paddingTop15"></div>


<table width="100%" colspan="7" id="intakeOutput3" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Time</th>
			<th>Drain</th>
			<th>Time</th>
			<th>Girth</th>
			<th>Time</th>
			<th>Insulin</th>
			<th>Time</th>
			<th>Blood Sugar</th>
			<th>Remarks</th>

		</tr>
	</thead>

	<tbody>
		<% if(ipdOutputSet1!=null && ipdOutputSet1.size()>0){
						for(IpdOutput ipdOutput :ipdOutputSet1){
				%>
		<tr>
			<td width="3%">
			<input type="text"
				value="<%=ipdOutput.getDrainTime()!=null?ipdOutput.getDrainTime():"" %>" readonly />
				
				</td>
			<td width="8%"><input type="text"
				value="<%=ipdOutput.getDrain()!=null?ipdOutput.getDrain():"" %>" readonly /></td>
			<td width="15%"><input type="text"
				value="<%=ipdOutput.getGirthTime()!=null? ipdOutput.getGirthTime():""%>" readonly /></td>
			<td width="15%"><input type="text"
				value="<%=ipdOutput.getGirth()!=null?ipdOutput.getGirth():"" %>" readonly /></td>
			<td width="15%"><input type="text"
				value="<%=ipdOutput.getInsulinTime()!=null?ipdOutput.getInsulinTime():"" %>" readonly /></td>
			<td width="15%"><input type="text"
				value="<%=ipdOutput.getInsulin()!=null ?ipdOutput.getInsulin():"" %>" readonly /></td>
			<td width="15%"><input type="text"
				value="<%=ipdOutput.getBloodSugarTime()!=null ? ipdOutput.getBloodSugarTime():"" %>" readonly /></td>
			<td width="15%"><input type="text"
				value="<%=ipdOutput.getBloodSugar()!=null ? ipdOutput.getBloodSugar():"" %>" readonly /></td>
			<td width="15%"><input type="text"
				value="<%=ipdOutput.getRemarks()!=null ?ipdOutput.getRemarks():"" %>" readonly /></td>
		</tr>
		<%} }%>
	</tbody>
</table> --%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block"><label>Treatment</label> <%
if(ipdIntakeOutputList!=null && ipdIntakeOutputList.size()>0){
for(IpdIntakeOutputChart ipdIntakeOutputChart :ipdIntakeOutputList){
				%> 
				<%if(ipdIntakeOutputChart.getTreatment()!=null && !ipdIntakeOutputChart.getTreatment().equals("null") && !ipdIntakeOutputChart.getTreatment().equals("")){ %>
				<input type="text" class="large"
	value="<%=ipdIntakeOutputChart.getTreatment() %>" readonly />
	<%}else{ %>
	<input type="text" class="large"
	value="" readonly />
	<%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Back" align="left"
	onClick="submitForm('intakeOutput','ipd?method=showIntakeOutputJsp&parent='+<%=inpatientId %>);" />
<div class="clear"></div>
<div class="division"></div>
<%}} %>
<div class="paddingTop40"></div>

