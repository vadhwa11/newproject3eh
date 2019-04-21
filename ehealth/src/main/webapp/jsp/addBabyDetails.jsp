<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * addMotherBabyDetails.jsp  
 * Purpose of the JSP -  This is for adding mother details.
 * @author  Tej Singh
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By:
 * @version 1.9  
--%>

<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasCsIndication"%>
<%@page import="jkt.hms.masters.business.MasGestation"%>
<%@page import="jkt.hms.masters.business.MasNeonatalProblem"%>
<%@page import="jkt.hms.masters.business.MasBabyStatus"%>
<%@page import="jkt.hms.masters.business.MasDeliveryType"%>
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>

<div class="clear"></div>

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
	Map<String,Object>  utilMap = new HashMap<String,Object>();
	

	List<MasCsIndication> masCsIndicationList = new ArrayList<MasCsIndication>();
	List<MasGestation> masGestationList = new ArrayList<MasGestation>();
	List<MasNeonatalProblem> masNeonatalProblemList = new ArrayList<MasNeonatalProblem>();
	List<MasBabyStatus> masBabyStatusList = new ArrayList<MasBabyStatus>();
	List<MasDeliveryType> masDeliveryTypeList = new ArrayList<MasDeliveryType>();
	List<MasAdministrativeSex> masAdministrativeSexList = new ArrayList<MasAdministrativeSex>();
	
	
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
	String motherHinNo="";
	String motherName="";
	if(map.get("motherName") != null){
		motherName = (String)map.get("motherName");
	}
	if(map.get("masCsIndicationList") != null){
		masCsIndicationList = (List<MasCsIndication>)map.get("masCsIndicationList");
	}
	if(map.get("masGestationList") != null){
		masGestationList = (List<MasGestation>)map.get("masGestationList");
	}
	if(map.get("masNeonatalProblemList") != null){
		masNeonatalProblemList = (List<MasNeonatalProblem>)map.get("masNeonatalProblemList");
	}
	if(map.get("masBabyStatusList") != null){
		masBabyStatusList = (List<MasBabyStatus>)map.get("masBabyStatusList");
	}
	if(map.get("masDeliveryTypeList") != null){
		masDeliveryTypeList = (List<MasDeliveryType>)map.get("masDeliveryTypeList");
	}
	if(map.get("masAdministrativeSexList") != null){
		masAdministrativeSexList = (List<MasAdministrativeSex>)map.get("masAdministrativeSexList");
	}
	if(map.get("hinNo")!=null){
		motherHinNo=(String)map.get("hinNo");
	}
	int babyno=0;
	int birthcertificateno=0;

	String message="";
	if(map.get("msg") != null){
		message = (String)map.get("msg");
	}
	int inpatientId=0;
	if(map.get("inpatientId") != null){
		inpatientId = (Integer)map.get("inpatientId");
	}
	int hinIdMother=0;
	if(map.get("hinIdMother") != null){
		hinIdMother = (Integer)map.get("hinIdMother");
	}
	
	String bplStatus="";
	if(map.get("bplStatus") != null){
		bplStatus = (String)map.get("bplStatus");
	}
	
	String hiNumber="";
	if(map.get("hiNumber") != null){
		hiNumber = (String)map.get("hiNumber");
	}
	
	String nationalDobStatus="";
	if(map.get("nationalDobStatus") != null){
		nationalDobStatus = (String)map.get("nationalDobStatus");
	}
	
	int patientTypeId=0;
	if(map.get("patientTypeId") != null){
		patientTypeId = (Integer)map.get("patientTypeId");
	}
	
	
	if(map.get("babyno") != null){
		babyno = (Integer)map.get("babyno");
	}
	if(map.get("birthcertificateno") != null){
		birthcertificateno =  (Integer)map.get("birthcertificateno");
	}
	System.out.println("birthcertificateno : "+birthcertificateno);
	System.out.println("bvaby no : "+babyno);
%>



<form name="BabyDetails" method="post">
<% if(!message.equalsIgnoreCase("")){
	%>
	<h4><%=message %></h4>
	<%} %>

<h2>Baby Details</h2>
<div class="Block">
<div class="clear"></div>
<label>Delivery Type</label> 
<select id="deliveryType" name="<%=DELIVERY_TYPE%>">
<option value="0">Select</option>
<%for(MasDeliveryType deliveryTypeList : masDeliveryTypeList){ %>
<option value="<%=deliveryTypeList.getId()%>"><%=deliveryTypeList.getDeliveryType()%>
</option>
<%} %>
</select> 
<input type="hidden" id="inpatientId"	value="<%=inpatientId %>" name="inpatientId" tabindex="1"  />
<input type="hidden" id="patientTypeId" value="<%=patientTypeId %>"	name="patientTypeId" tabindex="1"  />
<input type="hidden" id="nationalDobStatus" value="<%=nationalDobStatus %>"	name="nationalDobStatus" tabindex="1"  /> 
<input type="hidden" id="motherName" value="<%=motherName %>"	name="babyOfMotherName" tabindex="1"  />
<input type="hidden" id="hiNumber" value="<%=hiNumber %>"	name="hiNumber" tabindex="1"  />
<input type="hidden" id="hinIdMother" name="hinIdMother" class="readOnly" tabindex="1" value="<%=hinIdMother%>" MAXLENGTH="30" />
<input type="hidden" id="motherHinNoId" name="motherHinNo" class="readOnly" tabindex="1" value="<%=motherHinNo%>" MAXLENGTH="30" />
<input type="hidden" id="bplStatus" value="<%=bplStatus %>"	name="bplStatus" tabindex="1"  />    
<label>Baby No</label> 

<input type="text" id="babyNo"	name="<%=BABY_NO %>"  value="<%=babyno %>" tabindex="1" MAXLENGTH="30" readonly="readonly"/>
<label>Date Of Birth</label> 
<input type="text" id="dateOfBirth" class="readOnly" readonly="readonly" name="<%=DATE_OF_BIRTH %>" value="<%=currentDate %>" tabindex="1" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date,date,no"	onclick="setdate('<%=currentDate %>',document.BabyDetails.<%=DATE_OF_BIRTH%>,event)" />
<div class="clear"></div>
<label>Time Of Birth</label> 
<input type="text" id="timeOfBirth"	name="<%=TIME_OF_BIRTH %>" tabindex="1" MAXLENGTH="30" /> 
<label>Birth Certificate No</label> 
<input type="text" id="birthCertificateNo"	name="<%=BIRTH_CERTIFICATE_NO %>" value="<%=birthcertificateno %>" tabindex="1" MAXLENGTH="30" readonly="readonly"/> 
<label>Birth Certificate Date</label>
<input type="text" id="birthCertificateDate" value="<%=currentDate %>"	class="readOnly" readonly="readonly"	name="<%=BIRTH_CERTIFICATE_DATE %>" tabindex="1" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date,date,no"	onclick="setdate('<%=currentDate %>',document.BabyDetails.<%=BIRTH_CERTIFICATE_DATE%>,event)" />
<div class="clear"></div>
<label class="medium">Sex <span>*</span></label> 
<select name="<%=SEX %>" validate="Sex,string,yes">
<option value="0">Select</option>
<%for(MasAdministrativeSex a : masAdministrativeSexList){ %>
<option value="<%=a.getId()%>"><%=a.getAdministrativeSexName()%>
</option>
<%} %>
</select>
<div class="clear"></div>
</div>
<div class="Block">
<div class="clear"></div>
<label>CS Indication</label>
<select id="CsIndication"	name="<%=CS_INDICATION%>">
	<option value="0">Select</option>
	<%for(MasCsIndication csIndicationList : masCsIndicationList){ %>
	<option value="<%=csIndicationList.getId()%>"><%=csIndicationList.getIndicationName()%>
	</option>
	<%} %>
</select> 
<label>Gestation</label> 
<select id="gestation" name="<%=GESTATION%>">
	<option value="0">Select</option>
	<%for(MasGestation gestationList : masGestationList){ %>
	<option value="<%=gestationList.getId()%>"><%=gestationList.getGestationName()%>
	</option>
	<%} %>
</select> 
<label>Head Circumferance(cm)</label> 
<input type="text"	id="headCircumferance" name="<%=HEAD_CIRCUMFERANCE %>" tabindex="1"	MAXLENGTH="30" />
<div class="clear"></div>
<label>CS No</label> 
<input type="text" id="csNo" name="<%=CS_No %>"	tabindex="1" MAXLENGTH="30" /> 
<label>Gestation Age</label> 
<input	type="text" id="gestationAge" name="<%=GESTATION_AGE %>" tabindex="1"	MAXLENGTH="30" /> 
<label>Length</label> 
<input type="text" id="length"	name="<%=LENGTH %>" tabindex="1" MAXLENGTH="30" />
<div class="clear"></div>
<label><span>*</span>APGAR Score</label> 
<input type="text" id="apgarScore"	validate="Apgar score,int,yes" name="<%=APGAR_SCORE %>" tabindex="1" MAXLENGTH="2" onkeypress="return isNumber(event)" /> 
<label>Est. Gest Age </label> 
<input type="text" id="estGestAge" name="<%=EST_GEST_AGE %>"	tabindex="1" MAXLENGTH="30" /> 
<label>Weight(gms) </label> 
<input	type="text" id="weight" name="<%=WEIGHT %>" tabindex="1" MAXLENGTH="30" />
<div class="clear"></div>
<label>Neonatal Problems</label> 
<select id="neonatalProblems"	name="<%=NEONATAL_PROBLEMS%>">
	<option value="0">Select</option>
	<%for(MasNeonatalProblem neonatalProblemList : masNeonatalProblemList){ %>
	<option value="<%=neonatalProblemList.getId()%>"><%=neonatalProblemList.getNeonatalProblemName()%>
	</option>
	<%} %>
</select> 
<label>Baby Status</label> 
<select id="babyStatus"	name="<%=BABY_STATUS%>">
	<option value="0">Select</option>
	<%for(MasBabyStatus babyStatusList : masBabyStatusList){ %>
	<option value="<%=babyStatusList.getId()%>"><%=babyStatusList.getBabyStatusName()%>
	</option>
	<%} %>
</select> 
<label>Outcome </label> 
<input type="text" id="outCome"	name="<%=OUT_COME %>" tabindex="1" MAXLENGTH="30" />
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('BabyDetails','/hms/hms/ipd?method=addBabyDetails');"	accesskey="a" tabindex=1 /> 
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="bottom">
<label>Changed By:</label> 
<label	class="value"><%=userName%></label> 
<label>Changed Date:</label> 
<label	class="value"><%=currentDate%></label> 
<label>Changed Time:</label> 
<label class="value"><%=currentTime%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currentTime%>" />
</div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<%masBabyStatusList.clear();
masCsIndicationList.clear();
masDeliveryTypeList.clear();
masGestationList.clear();
masNeonatalProblemList.clear();
%>

<script>
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}

</script>