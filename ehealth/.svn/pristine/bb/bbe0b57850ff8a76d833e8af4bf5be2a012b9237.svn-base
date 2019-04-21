<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOphthalmology"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>


<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>
<!--main content placeholder starts here-->
<script type="text/javascript">
animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('title3', 'fade=0,speed=400,group=pets,hide=1,persist=0,hide=0')
animatedcollapse.addDiv('title4', 'fade=0,speed=400,group=pets,hide=0')
animatedcollapse.addDiv('title5', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title6', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title7', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title8', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title9', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.init()
</script>
<form name="viewOpdOphthalmology" method="post" action="">
<div class="titleBg">
<h2>OPD Ophthalmology</h2>
</div>
<div class="clear"></div>
<!--Block One Starts--> <%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in); 
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdOphthalmology> ophthalmologyList = new ArrayList<OpdOphthalmology>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}		
		if(detailsMap.get("patientDataList") != null){
			patientDataList=(List<Visit>)detailsMap.get("patientDataList");
		}	
		if(map.get("ophthalmologyList") != null){
			ophthalmologyList=(List<OpdOphthalmology>)map.get("ophthalmologyList");
		}	
		int currentVisitId = 0;
		
		if(map.get("currentVisitId") != null){
			currentVisitId = (Integer)map.get("currentVisitId");
		}
%> <%
if(ophthalmologyList.size() > 0){
	OpdOphthalmology opdOphthalmology = new OpdOphthalmology();
	opdOphthalmology = ophthalmologyList.get(0);
	Visit visit = new Visit();
	if(patientDataList.size() > 0){
		visit = patientDataList.get(0);
	}
	String patientName="";
	if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
	}
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	
%> <!--Block One Starts-->
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium">
<%=prop.getProperty("com.jkt.hms.registration_no") %>
</label> 
<%
if(visit.getHin().getHinNo()!= null)
{
	%>
	<label class="valueMedium"><%=visit.getHin().getHinNo() %></label> 
	<%
	}
else
{ 
%>
<label class="valueMedium">-</label> 
<%
}
%>
 <label>Patient Name </label> 
 <%
 if(patientName!= null)
 {
	 %>
<label class="value"><%=patientName %> </label>
 <%
 }
 else
 {
	 %> 
	 <label class="value">- </label> 
	 <%
	 }
 %> 
<label class="medium">Age</label> 
<%
if(visit.getHin().getAge()!= null)
{
	%>
<label class="valueMedium"><%=visit.getHin().getAge() %></label> 
<%
}
else
{
	%>
<label class="valueMedium">-</label> 
<%
}
%>
 <label class="medium">Visit Date </label> 
 <%
 if(visitDateInString != null)
 {
	 %>
<label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>
<div class="clear"></div>
<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no")%></label> 
<%if(visit.getVisitNo()!= null){ %>
<label class="valueMedium"><%=visit.getVisitNo() %></label> 
<%}else{ %> 
<label class="valueMedium">-</label> 
<%
}
%> 
<label>Token No. </label> 
<%
if(visit.getTokenNo()!= null)
{
	%>
<label class="value"><%=visit.getTokenNo() %></label> 
<%
}
else
{
	%> 
	<label>-</label>
<%} %> 
<label class="medium">Prev. Diag </label> 
<%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> 
<label class="value">-</label> <%} %>
<div class="clear"></div>
</div>
<!--Block one Ends-->
<div class="division"></div>
<!--Block Three Starts--> 
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Symptoms Duration</h5>
</a>
<div class="Block" id="title1">
<div class="clear"></div>
<label>Decreased Vision</label> 
<%
	if(opdOphthalmology.getDecreasedVision() != null){
%> 
<input name="<%=DECREASED_VISION %>" type="text" value="<%=opdOphthalmology.getDecreasedVision() %>" maxlength="20" class="readOnly" readonly="readonly"> 
<%
  }
	else
	{ 
%> 
<input name="<%=DECREASED_VISION %>" type="text" value="" maxlength="20" readonly="readonly"> <%} %> 
<label>Redness</label> 
<%
	if(opdOphthalmology.getRedness() != null){
%>
<input name="<%=REDNESS %>" type="text"	value="<%=opdOphthalmology.getRedness() %>" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
	else
	{ 
%> 
<input	name="<%=REDNESS %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
%>
<div class="clear"></div>
<label>Pain</label> 
<%
	if(opdOphthalmology.getPain() != null){
%> 
<input name="<%=PAIN %>" type="text" value="<%=opdOphthalmology.getPain()  %>" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
	else
	{
		%> 
<input name="<%=PAIN %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> <%} %> 
<label> Discharge </label> 
<%
if(opdOphthalmology.getDischarge() != null){
%>
<input name="<%=DISCHARGE %>" type="text" class="readOnly" value="<%=opdOphthalmology.getDischarge() %>" maxlength="20"	readonly="readonly"> 
<%
}
else
{
	%> 
<input name="<%=DISCHARGE %>" type="text" class="readOnly" value="" maxlength="20" readonly="readonly"> 
<%
}
%>
<div class="division"></div>
<label class="auto">Floater/ Trauma/ Epiphora etc</label> 
<%
	if(opdOphthalmology.getFloaterTraumaEpiphora() != null){
%>
 <input name="<%=FLOATER_TRAUMA_EPIPHORA %>" type="text" value="<%=opdOphthalmology.getFloaterTraumaEpiphora() %>"maxlength="30"> 
 <%
 }else{ %> <input
	name="<%=FLOATER_TRAUMA_EPIPHORA %>" type="text" class="readOnly"
	value="" maxlength="20" readonly="readonly"> <%} %>

<div class="clear"></div></div>
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>Functional Assessment</h5>
</a>
<div class="Block" id="title2">
<div class="clear"></div>
<label>Reading</label> 
<%
	if(opdOphthalmology.getReading() != null && !opdOphthalmology.getReading().equals("")){
%> 
<input name="<%=READING %>" type="checkbox" value="R" radioCheck checked="checked"> 
<%
	}
	else
	{
		%> 
<input name="<%=READING %>"	type="checkbox" value="R" radioCheck> <%} %> 
<label>Driving</label>
<%
	if(opdOphthalmology.getDriving() != null && !opdOphthalmology.getDriving().equals("")){
%> 
<input name="<%=DRIVING %>" type="checkbox" value="D" radioCheck checked="checked"> <%}else{ %> 
<input name="<%=DRIVING %>"	type="checkbox" value="R" radioCheck> <%} %> 
<label>Cooking</label>
<%
	if(opdOphthalmology.getCooking() != null && !opdOphthalmology.getCooking().equals("")){
%> 
<input name="<%=COOKING %>" type="checkbox" value="C" radioCheck checked="checked"> 
<%
	}
	else
	{ 
	%> 
<input name="<%=COOKING %>"	type="checkbox" value="R" radioCheck> 
<%
}
%> 
<label>Ambulatory</label>
<%
	if(opdOphthalmology.getAmbulatry() != null && !opdOphthalmology.getAmbulatry().equals("")){
%> 
<input name="<%=AMBULATORY %>" type="checkbox" value="A" radioCheck checked="checked"> 
<%
}
	else
	{
		%> 
<input name="<%=AMBULATORY %>" type="checkbox" value="R" radioCheck> 
<% 
}  
%>
<div class="clear"></div>
<label>Personal Hygiene</label> 
<%
	if(opdOphthalmology.getPersonalHygiene() != null && !opdOphthalmology.getPersonalHygiene().equals("")){
%> 
<input name="<%=PERSONAL_HYGIENE %>" type="checkbox" value="P" radioCheck checked="checked"> 
<%
}
	else
	{
		%> 
<input name="<%=PERSONAL_HYGIENE %>" type="checkbox" value="R" radioCheck>
<%
}
%>
<div class="clear"></div></div>
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>Treatment History</h5>
</a>
<div class="Block" id="title3">
<div class="clear"></div>
<label>DM</label> <%
	if(opdOphthalmology.getDm() != null && !opdOphthalmology.getDm().equals("")){
%> 
<input name="<%=DM %>" type="checkbox" value="D" radioCheck checked="checked"> 
<%
}
	else
	{
	%>
 <input name="<%=DM %>" type="checkbox" value="D" radioCheck> <%} %> 
 <label>HTN</label> 
 <%
	if(opdOphthalmology.getHtn() != null && !opdOphthalmology.getHtn().equals("")){
%> 
<input name="<%=HTN %>" type="checkbox" value="H" radioCheck checked="checked"> 
<%
}
	else
	{
%> 
<input name="<%=HTN %>"	type="checkbox" value="R" radioCheck> <%} %> 
<label>Bronchial Asthma</label> 
<%
	if(opdOphthalmology.getBa() != null && !opdOphthalmology.getBa().equals("")){
%> 
<input name="<%=BA %>" type="checkbox" value="B" radioCheck	checked="checked"> 
<%
}
	else
	{ 
	%> 
<input name="<%=BA %>" type="checkbox" value="R" radioCheck> <%} %> 
<label>CAD</label> 
<%
	if(opdOphthalmology.getCad() != null && !opdOphthalmology.getCad().equals("")){
%> 
<input name="<%=CAD%>" type="checkbox" value="C" radioCheck	checked="checked"> 
<%
}
	else
	{
		%> 
<input name="<%=CAD%>" type="checkbox" value="R" radioCheck> 
<%
}
%>
<div class="clear"></div>
<label>Autoimmune</label> 
<%
	if(opdOphthalmology.getAutoimmune() != null && !opdOphthalmology.getAutoimmune().equals("")){
%> 
<input name="<%=AUTOIMMUNE %>" type="checkbox" value="A" radioCheck	checked="checked"> 
<%
}
	else
	{
		%>
<input name="<%=AUTOIMMUNE %>"	type="checkbox" value="R" radioCheck> 
<%
}
%> 
<label>Others</label>
<%
	if(opdOphthalmology.getOthers() != null && !opdOphthalmology.getOthers().equals("")){
%> 
<input name="<%=OTHERS %>" type="checkbox" value="O" radioCheck	checked="checked"> 
<%
}
	else
	{ 
	%> 
<input name="<%=OTHERS %>" type="checkbox" value="R" radioCheck> 
<%
}
%>
<div class="clear"></div></div>
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title4','t4')">
<h5 id='t4'>OCULAR EXAMINATION</h5>
</a>
<div class="Block" id="title4">
<div class="clear"></div>
<label><u>Vision</u></label> 
<label>&nbsp;</label> 
<label class="center">RE</label>
<label class="center">LE</label> 
<label class="center">PH</label>
<div class="clear"></div>
<label>Distance</label> 
<label>&nbsp;</label> 
<%
if(opdOphthalmology.getDistanceRe() != null){
%> 
<input name="<%=DISTANCE_RE %>" type="text" class="readOnly" value="<%=opdOphthalmology.getDistanceRe() %>" maxlength="20"
	readonly="readonly"> 
<%
}
	else
{ 
%> 
<input name="<%=DISTANCE_RE %>"	type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
%> 
<%
if(opdOphthalmology.getDistanceLe() != null){
%> 
<input name="<%=DISTANCE_LE %>" type="text"	value="<%=opdOphthalmology.getDistanceLe() %>" maxlength="20"
	class="readOnly" readonly="readonly"> 
<%
	}
		else
	{ 
%> 
<input	name="<%=DISTANCE_LE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
%>
 <%
if(opdOphthalmology.getDistancePh() != null){
%> 
<input name="<%=DISTANCE_PH %>" type="text" class="readOnly" value="<%=opdOphthalmology.getDistancePh() %>" maxlength="20"	readonly="readonly"> 
<%
}
else
{ 
%> 
<input name="<%=DISTANCE_PH %>"	type="text" value="" class="readOnly" maxlength="20" readonly="readonly"> 
<%
} 
%>
<div class="clear"></div>
<label>Near</label> 
<label>&nbsp;</label> 
<%
if(opdOphthalmology.getNearRe() != null){
%> 
<input name="<%=NEAR_RE %>" type="text" class="readOnly" value="<%=opdOphthalmology.getNearRe() %>" maxlength="20" readonly="readonly"> 
<%
}
else
{ 
%> 
<input name="<%=NEAR_RE %>"	type="text" class="readOnly" value="" maxlength="20" readonly="readonly"> 
<%
}
%>
 <%
if(opdOphthalmology.getNearLe() != null){
%> 
<input name="<%=NEAR_LE %>" type="text" class="readOnly" value="<%=opdOphthalmology.getNearLe() %>" maxlength="20"	readonly="readonly"> 
<%
}
else
{ 
%> 
<input name="<%=NEAR_LE %>"	type="text" class="readOnly" value="" maxlength="20" readonly="readonly"> 
<%
}
 %>
  <%
if(opdOphthalmology.getNearPh() != null){
%> 
<input name="<%=NEAR_PH %>" type="text" class="readOnly" value="<%=opdOphthalmology.getNearPh() %>" maxlength="20"	readonly="readonly"> 
<%
}
else
{ 
%> 
<input name="<%=NEAR_PH %>"	type="text" vclass="readOnly" alue="" maxlength="20"readonly="readonly"> 
<%
} 
%>
<div class="clear"></div>
<label>Refraction</label> 
<label>&nbsp;</label> 
<%
if(opdOphthalmology.getRefractionRe() != null){
%> 
<input name="<%=REFRACTION_RE %>" type="text" class="readOnly" value="<%=opdOphthalmology.getRefractionRe() %>" maxlength="20" readonly="readonly"> 
<%
}
else
{ 
%> 
<input name="<%=REFRACTION_RE %>" type="text" class="readOnly" value=""	maxlength="20" readonly="readonly"> 
<%
}
%> 
<%
if(opdOphthalmology.getRefractionLe() != null){
%> 
<input name="<%=REFRACTION_LE %>" type="text" class="readOnly" value="<%=opdOphthalmology.getRefractionLe() %>" maxlength="20" readonly="readonly"> 
<%
}
else
{ 
%> 
<input name="<%=REFRACTION_LE %>" type="text" class="readOnly" value="" maxlength="20" readonly="readonly"> 
<%
}
%> 
<%
if(opdOphthalmology.getRefractionPh() != null){
%> 
<input name="<%=REFRACTION_PH %>" type="text" class="readOnly" value="<%=opdOphthalmology.getRefractionPh() %>" maxlength="20" readonly="readonly"> 
<%
}
else
{ 
%>
<input name="<%=REFRACTION_PH %>" type="text" class="readOnly" value="" maxlength="20" readonly="readonly"> 
<%
}
%>
<div class="clear"></div>
<label>Acceptance</label> 
<label>Distance</label> <%
if(opdOphthalmology.getAcceptanceDistanceRe() != null){
%> 
<input name="<%=ACCEPTANCE_DISTANCE_RE %>" type="text" class="readOnly" value="<%=opdOphthalmology.getAcceptanceDistanceRe() %>" maxlength="20"	readonly="readonly"> 
<%
}
else
{ 
%> 
<input name="<%=ACCEPTANCE_DISTANCE_RE %>" type="text" class="readOnly" value="" maxlength="20" readonly="readonly"> 
<%
}
%>
 <%
if(opdOphthalmology.getAcceptanceDistanceLe() != null){
%> 
<input name="<%=ACCEPTANCE_DISTANCE_LE %>" type="text"	class="readOnly" value="<%=opdOphthalmology.getAcceptanceDistanceLe() %>" maxlength="20" readonly="readonly"> 
<%
}
else
{ 
%> 
<input name="<%=ACCEPTANCE_DISTANCE_LE %>" type="text" class="readOnly" value="" maxlength="20" readonly="readonly"> 
<%
}
 %>
  <%
  if(opdOphthalmology.getAcceptanceDistancePh() != null){
%>
 <input name="<%=ACCEPTANCE_DISTANCE_PH %>" type="text"	class="readOnly" value="<%=opdOphthalmology.getAcceptanceDistancePh() %>" maxlength="20" readonly="readonly"> 
 <%
 }
  else
  { 
  %> 
  <input name="<%=ACCEPTANCE_DISTANCE_PH %>" type="text" class="readOnly" value="" maxlength="20" readonly="readonly"> 
  <%
  }
  %>
<div class="clear"></div>
<label>&nbsp;</label> 
<label>Near</label> <%
if(opdOphthalmology.getAcceptanceNearRe() != null){
%> 
<input name="<%=ACCEPTANCE_NEAR_RE %>" type="text" class="readOnly"	value="<%=opdOphthalmology.getAcceptanceNearRe() %>" maxlength="20"	readonly="readonly"> 
<%
}
else
{ 
%>
 <input name="<%=ACCEPTANCE_NEAR_RE %>" type="text" class="readOnly" value="" maxlength="20" readonly="readonly"> 
 <%
 }
%>
 <%
if(opdOphthalmology.getAcceptanceNearLe() != null){
%> 
<input name="<%=ACCEPTANCE_NEAR_LE %>" type="text" class="readOnly" value="<%=opdOphthalmology.getAcceptanceNearLe() %>" maxlength="20"	readonly="readonly"> 
<%
}
else
{ 
%>
<input name="<%=ACCEPTANCE_NEAR_LE %>" type="text" class="readOnly" value="" maxlength="20" readonly="readonly"> 
<%
} 
%>
 <%
if(opdOphthalmology.getAcceptanceNearPh() != null){
%> 
<input name="<%=ACCEPTANCE_NEAR_PH %>" type="text" class="readOnly" value="<%=opdOphthalmology.getAcceptanceNearPh() %>" maxlength="20"	readonly="readonly"> 
<%
}
else
{ 
%>
<input name="<%=ACCEPTANCE_NEAR_PH %>" type="text" value="" class="readOnly" maxlength="20" readonly="readonly"> 
<%
}
 %>
<div class="division"></div>
<label>Convergence</label> 
<label>&nbsp;</label>
 <selectname="selConvergence" onchange="checkOption(this);">
<option value="">Select</option>
<option value="normal">Normal</option>
<option value="abnormal">Abnormal</option>
</select> 
<input name="<%=CONVERGENCE %>" type="text" value="" class="readOnly" maxlength="10" readonly="readonly">
<div class="clear"></div>
<label>Color Vision </label> 
<label>&nbsp;</label> 
<select name="selColorVision" onchange="checkOption(this);">
<option value="">Select</option>
<option value="normal">Normal</option>
<option value="abnormal">Abnormal</option>
</select> 
<input name="<%=COLOR_VISION %>" type="text" value="" class="readOnly" maxlength="10" readonly="readonly">
<div class="clear"></div>
<label>Ocular Movements </label> 
<label>&nbsp;</label> 
<select name="selOcularMovements" onchange="checkOption(this);">
<option value="">Select</option>
<option value="normal">Normal</option>
<option value="abnormal">Abnormal</option>
</select> 
<input name="<%=OCULAR_MOVEMENTS %>" type="text" value="" class="readOnly" maxlength="10" readonly="readonly">
<div class="clear"></div>
<label>Lids</label> 
<label>&nbsp;</label> 
<select name="selLids" onchange="checkOption(this);">
<option value="">Select</option>
<option value="normal">Normal</option>
<option value="abnormal">Abnormal</option>
</select> 
<input name="<%=LIDS %>" type="text" value="" maxlength="10" class="readOnly" readonly="readonly">
<div class="clear"></div>
<label>Conjunctiva</label> 
<label>&nbsp;</label> 
<select	name="selConjunctiva" onchange="checkOption(this);">
<option value="">Select</option>
<option value="normal">Normal</option>
<option value="abnormal">Abnormal</option>
</select> 
<input name="<%=CONJUNCTIVA %>" type="text" value="" maxlength="10"	class="readOnly" readonly="readonly">
<div class="clear"></div>
<label>Cornea &amp; AC </label> <label>&nbsp;</label>
 <%
if(opdOphthalmology.getCorneaAcRe() != null){
%> 
<input name="<%=CORNEA_AC_RE %>" type="text" value="<%=opdOphthalmology.getCorneaAcRe() %>" maxlength="20" readonly="readonly"> <%}else{ %> <input name="<%=CORNEA_AC_RE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
} 
%>
 <%
if(opdOphthalmology.getCorneaAcLe() != null){
%> 
<input name="<%=CORNEA_AC_LE %>" type="text" value="<%=opdOphthalmology.getCorneaAcLe() %>" class="readOnly" maxlength="20" readonly="readonly"> 
<%}
else
{ 
%> 
<input name="<%=CORNEA_AC_LE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
} 
%>
<div class="division"></div>
<label>Ant chamber depth</label> 
<label>&nbsp;</label> 
<%
if(opdOphthalmology.getAntChamberDepthRe() != null){
%> 
<input name="<%=ANT_CHAMBER_RE %>" type="text" value="<%=opdOphthalmology.getAntChamberDepthRe() %>" maxlength="20"	readonly="readonly"> 
<%
}
else
{ 
%>
 <input	name="<%=ANT_CHAMBER_RE %>" type="text" value="-" maxlength="20" class="readOnly" readonly="readonly"> 
 <%
 }
%>
 <%
if(opdOphthalmology.getAntChamberDepthLe() != null){
%> 
<input name="<%=ANT_CHAMBER_LE %>" type="text" value="<%=opdOphthalmology.getAntChamberDepthLe() %>" maxlength="20"	readonly="readonly"> 
<%
}
else
{
	%>
<input name="<%=ANT_CHAMBER_LE %>" type="text" value="-" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
 %>
<div class="clear"></div>
<label>Cells/flare</label> <label>&nbsp;</label> <%
if(opdOphthalmology.getCellsFlareRe() != null){
%> 
<input name="<%=CELLS_FLARE_RE %>" type="text" value="<%=opdOphthalmology.getCellsFlareRe() %>" maxlength="20" readonly="readonly"> <%}else{ %> 
<input name="<%=CELLS_FLARE_RE %>" type="text" value="-" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
%>
 <%
if(opdOphthalmology.getCellsFlareLe() != null){
%> 
<input name="<%=CELLS_FLARE_LE %>" type="text" value="<%=opdOphthalmology.getCellsFlareLe() %>" maxlength="20" readonly="readonly"> <%}else{ %> 
<input name="<%=CELLS_FLARE_LE %>" type="text" value="-" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
 %>
<div class="clear"></div>
<label>PXF/NVI</label> 
<label>&nbsp;</label> 
<%
if(opdOphthalmology.getPxfNviRe() != null){
%> 
<input name="<%=PXF_NVI_RE %>" type="text" value="<%=opdOphthalmology.getPxfNviRe() %>" maxlength="20" readonly="readonly"> <%}else{ %> <input name="<%=PXF_NVI_RE %>" type="text" value="-" maxlength="20" class="readOnly" readonly="readonly"> 
<%
} 
%>
 <%
if(opdOphthalmology.getPxfNviLe() != null){
%>
<input name="<%=PXF_NVI_LE %>" type="text" value="<%=opdOphthalmology.getPxfNviLe() %>" maxlength="20" readonly="readonly"> <%}else{ %> 
<input name="<%=PXF_NVI_LE %>" type="text" value="-" maxlength="20" class="readOnly" readonly="readonly"> 
<%
} 
%>
<div class="clear"></div>
<label>Pupil Reaction </label> 
<label>Direct</label> <%
	if(opdOphthalmology.getPupilReactionDirect() != null && !opdOphthalmology.getPupilReactionDirect().equals("")){
%> 
<input name="<%=DIRECT %>" type="checkbox" value="D" radioCheck checked="checked"> 
<%
}
	else
	{ 
	%> 
<input name="<%=DIRECT %>" type="checkbox" value="R" radioCheck> <%} %> 
<label>Consensnal</label>
<%
	if(opdOphthalmology.getPupilReactionConsensnal() != null && !opdOphthalmology.getPupilReactionConsensnal().equals("")){
%>
 <input name="<%=CONSENSNAL %>" type="checkbox" value="C" radioCheck checked="checked"> 
 <%
 }
	else
	{ 
	%> 
<input name="<%=CONSENSNAL %>" type="checkbox" value="R" radioCheck> <%} %>
<label>RAPD</label><%
	if(opdOphthalmology.getPupilReactionRapd() != null && !opdOphthalmology.getPupilReactionRapd().equals("")){
%> 
<input name="<%=RAPD %>" type="checkbox" value="P" radioCheck checked="checked"> <%}else{ %> 
<input name="<%=RAPD %>" type="checkbox" value="R" radioCheck> 
<%
}
%>
<div class="clear"></div>
<label>Gonioscopy </label> 
<label>&nbsp;</label> 
<%
if(opdOphthalmology.getGonioscopyRe() != null){
%> 
<input name="<%=GONIOSCOPY_RE %>" type="text" value="<%=opdOphthalmology.getGonioscopyRe() %>" class="readOnly"  maxlength="20" readonly="readonly"> <%}else{ %> 
<input name="<%=GONIOSCOPY_RE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
} 
%> 
<%
if(opdOphthalmology.getGonioscopyLe() != null){
%> 
<input name="<%=GONIOSCOPY_LE %>" type="text" value="<%=opdOphthalmology.getGonioscopyLe() %>" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
else
{ 
%> 
<input name="<%=GONIOSCOPY_LE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
%>
<div class="clear"></div>
<label>IOP(months)</label> 
<label>&nbsp;</label> 
<%
if(opdOphthalmology.getIopRe() != null){
%> 
<input name="<%=IOP_RE %>" type="text" value="<%=opdOphthalmology.getIopRe() %>" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
else
{ 
%>
<input name="<%=IOP_RE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
%>
 <%
 if(opdOphthalmology.getIopLe() != null){
%> 
<input name="<%=IOP_LE %>" type="text" value="<%=opdOphthalmology.getIopLe() %>" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
 else
 {
	 %>
<input name="<%=IOP_LE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
} 
%>
<div class="division"></div>
<h4>Sac</h4>
<div class="clear"></div>
<label>Papillary Dilatation </label> 
<label>&nbsp;</label> <%
if(opdOphthalmology.getDilationRe() != null){
%>
 <input name="<%=DILATION_RE %>" type="text" value="<%=opdOphthalmology.getDilationRe() %>" maxlength="20" class="readOnly" readonly="readonly"> 
 <%
 }
else
{ 
%>
<input name="<%=DILATION_RE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
} 
%>
<%if(opdOphthalmology.getDilationLe() != null){
%> 
<input name="<%=DILATION_LE %>" type="text"  value="<%=opdOphthalmology.getDilationLe() %>" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
else
{ 
%>
 <input name="<%=DILATION_LE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
 <%
 }
%>
<div class="clear"></div>
<label>Lens </label> 
<label>&nbsp;</label>
 <%
if(opdOphthalmology.getLensRe() != null){
%> 
<input name="<%=LENS_RE %>" type="text" value="<%=opdOphthalmology.getLensRe() %>" class="readOnly" maxlength="20" readonly="readonly"> 
<%
}
else
{ 
%> 
<input name="<%=LENS_RE %>" type="text" value="" maxlength="20"  class="readOnly" readonly="readonly"> 
<%
} 
%>
 <%
if(opdOphthalmology.getLensLe() != null){
%> 
<input name="<%=LENS_LE %>" type="text"	value="<%=opdOphthalmology.getLensLe() %>" class="readOnly"	maxlength="20" readonly="readonly"> 
<%
}
else
{ 
%>
<input	name="<%=LENS_LE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
 %>
 <div class="clear"></div>
<label>Fundus</label> 
<label>&nbsp;</label> 
<%
if(opdOphthalmology.getFundusRe() != null){
%> 
<input name="<%=FUNDUS_RE %>" type="text" value="<%=opdOphthalmology.getFundusRe() %>" class="readOnly"	maxlength="20" readonly="readonly"> 
<%
}
else
{
	%> 
<input	name="<%=FUNDUS_RE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
} 
%> 
<%
if(opdOphthalmology.getFundusLe() != null){
%> 
<input name="<%=FUNDUS_LE %>" type="text" value="<%=opdOphthalmology.getFundusLe() %>" class="readOnly" maxlength="20" readonly="readonly"> 
<%
}
else
{
	%> 
<input name="<%=FUNDUS_LE %>" type="text" value="" maxlength="20" class="readOnly" readonly="readonly"> 
<%
}
%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<!--Bottom labels starts--> 
<input name="prev" type="button" class="button" value="Prev" onclick="submitForm('viewOpdOphthalmology','opd?method=viewPatientOphthalmologyDetails&flag=prev');">
<input name="next" type="button" class="button" value="Next" onclick="submitForm('viewOpdOphthalmology','opd?method=viewPatientOphthalmologyDetails&flag=next');">
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> 
<input name="back" type="button" class="button" value="Back" onclick="submitForm('viewOpdOphthalmology','<%=url %>');"> 
<%
	}
%>
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>"> 
<input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> 
<input	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<!--Bottom labels ends--> 
<%
	}
	else
	{
%> 
No Record Found!! <!--Bottom labels starts-->
<input name="back" type="button" class="button" value="Back" onclick="submitForm('viewOpdOphthalmology','opd?method=showOpdOphthamologyJsp&visitId=<%=currentVisitId %>');">
<!--Bottom labels ends--> <%} %>
<div class="division"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
<!--main content placeholder ends here-->
<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
