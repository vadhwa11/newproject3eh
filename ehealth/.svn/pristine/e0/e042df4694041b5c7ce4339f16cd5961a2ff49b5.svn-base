<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * dischargeByHinNo.jsp  
 * Purpose of the JSP -  This is for Discharge process By Hin No.
 * @author  Ritu
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By:
 * @version 1.9  
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDisposedTo"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.MasCareType"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasDischargeStatus"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.DeliveryDetails"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>
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


<%
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();
	
	List<DeliveryDetails> deliveryDetailsList = new ArrayList<DeliveryDetails>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	if(patientMap.get("deliveryDetailsList") != null){
		deliveryDetailsList = (List<DeliveryDetails>)patientMap.get("deliveryDetailsList");
	}
	
%>

<h2>Patient Discharge</h2>

<%
	if(deliveryDetailsList != null && deliveryDetailsList.size() > 0){
		DeliveryDetails deliveryDetails = deliveryDetailsList.get(0);
		Patient patient = deliveryDetails.getHin();
		Inpatient inpatient = deliveryDetails.getInpatient();
		
		String age = "";
		String currentAge = "";
		age = patient.getAge();
		currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());

		String adNo = "";
		String admissionDate = "";
		String admissionTime = "";
		adNo = inpatient.getAdNo();
		admissionDate = HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
		admissionTime = inpatient.getTimeOfAddmission();
	 %>

<form name="motherBabyDetails" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>Mother Baby Details</h4>
<div class="clear"></div>
<div class="Block"><label>HIN</label> <input type="text"
	id="hiNumber" name="hiNumber" tabindex="1"
	value="<%=patient.getHinNo()%>" class="date" validate="HIN,int,yes"
	MAXLENGTH="30"
	onblur="if(validateHinNo(this.value)){submitProtoAjaxWithDivName('motherBabyDetails','/hms/hms/mis?method=fillPatinetDetailsAjax&hinNo=<%=patient.getHinNo()%>','patientDetails');}" />

<div id="patientDetails"><label>IP No.</label> <input type="text"
	id="AdNumber" name="AdNumber" tabindex="1"
	value="<%=inpatient.getAdNo()%>" class="date" validate="IP No,int,yes"
	MAXLENGTH="30" /> <label>Ward</label> <input type="text"
	id="Department" name="Department" tabindex="1"
	value="<%=inpatient.getDepartment()%>" class="date"
	validate="Department,int,yes" MAXLENGTH="30" /> <label>Age</label> <input
	type="text" id="Age" name="Age" tabindex="1"
	value="<%=inpatient.getAge()%>" class="date" validate="Age,int,yes"
	MAXLENGTH="30" /> <label>Bed No.</label> <input type="text" id="BedNo"
	name="BedNo" tabindex="1" value="<%=inpatient.getBed()%>" class="date"
	validate="Bed No,int,yes" MAXLENGTH="30" /></div>


<%} %>

</form>

