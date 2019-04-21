<%@page import="jkt.hms.masters.business.MasAnesthesia"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdOphthalmology"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" lang="javascript" 	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" lang="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" lang="javascript"	src="/hms/jsp/js/proto.js"></script>
<script lang="javascript"  src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js" lang="javascript"></script>



<!--main content placeholder starts here-->

<div class="OpdOphthamology-maindiv">
<form name="opdOphthalmology" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block" style="width:1170px;">
<h6>OPD Ophthalmology</h6>

	<!--Block One Starts-->
	<%
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdOphthalmology> opdOphthalmologyList = null ;
		OpdOphthalmology opdOphthalmology =null ; 
		if(map.get("patientDataList") != null){
			patientDataList=(List<Visit>)map.get("patientDataList");
		}
		if(map.get("opdOphthalmologyList")!=null){
			opdOphthalmologyList = (List<OpdOphthalmology>)map.get("opdOphthalmologyList");
			if(opdOphthalmologyList.size()>0)
				opdOphthalmology = (OpdOphthalmology)opdOphthalmologyList.get(0);	
		}
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
		
		Visit visit = new Visit();
		if(patientDataList.size() > 0){
			visit = patientDataList.get(0);
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}	
		
		if(detailsMap.get("frequencyList") != null){
			frequencyList=(List<MasFrequency>)detailsMap.get("frequencyList");
		}	
		if(detailsMap.get("anesthesiaList") != null){
			anesthesiaList=(List<MasAnesthesia>)detailsMap.get("anesthesiaList");
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
%>


	
<div class="Clear"></div>
<div class="paddingTop15"></div>
<div class="Clear"></div>
		<label>Name</label>
		<%if(patientName!= null){ %>
		<label class="value"><%=patientName %> </label>
		<%}else{ %>
		<label class="value">- </label>
		<%} %>
<!-- 		<label>Service No.</label> -->
<%-- 		<%if(visit.getHin().getServiceNo() != null){ %> --%>
<%-- 		<label class="value"><%=visit.getHin().getServiceNo() %> </label> --%>
<%-- 		<%}else{ %> --%>
<!-- 		<label class="value">- </label> -->
<%-- 		<%} %> --%>
		<label>UHID</label>
		<%if(visit.getHin().getHinNo()!= null){ %>
		<label class="value"><%=visit.getHin().getHinNo() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<div class="Clear"></div>
<!-- 		<label>Rank</label> -->
<%-- 		<%if(visit.getHin().getRank()!= null){ %> --%>
<%-- 		<label class="value"><%=visit.getHin().getRank().getRankName() %></label> --%>
<%-- 		<%}else{ %> --%>
<!-- 		<label class="value">-</label> -->
<%-- 		<%} %> --%>
		<label>Age</label>
		<%if(visit.getAge()!= null){ %>
		<label class="value"><%=visit.getAge() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
<!-- 		<label>Unit</label> -->
<%-- 		<%if(visit.getHin().getUnit()!= null){ %> --%>
<%-- 		<label class="value"><%=visit.getHin().getUnit().getUnitName() %></label> --%>
<%-- 		<%}else{ %> --%>
<!-- 		<label class="value">-</label> -->
<%-- 		<%} %> --%>
<!-- 		<div class="Clear"></div> -->
<!-- 		<label>Trade</label> -->
<%-- 		<%if(visit.getHin().getTrade()!= null){ %> --%>
<%-- 		<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label> --%>
<%-- 		<%}else{ %> --%>
<!-- 		<label class="value">-</label> -->
<%-- 		<%} %> --%>
		<label>Visit No.</label>
		<%if(visit.getVisitNo()!= null){ %>
		<label class="value"><%=visit.getVisitNo() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label>Visit Date</label>
		<%if(visitDateInString!= null){ %>
		<label class="value"><%=visitDateInString%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
	</div>
	<!--Block one Ends-->
	<div class="division"></div>


	<!--Block Three Starts-->


	<ul id="countrytabsIn" class="shadetabsInForOPDMain" style="margin: 0px;">
		<label><a href="#" rel="country1" class="selected"	onclick="checkTab(1);">Ophthalmology</a></label>
		<label><a href="#" rel="country2" onclick="checkTab(2);">FollowUp</a></label>
		<label><a href="#" rel="country3" onclick="checkTab(3);">Retinal</a></label>
		<label><a href="#" rel="country4" onclick="checkTab(4);">Diagnosis</label>
	</ul>




	<input type="hidden" name="tab" id="tab" value="" />
	<div class="tabcontainerIn" style="float: left; width: 1170px;">
		<div id="country1" class="tabcontentIn">
			<div class="Block" style="width:1170px;">
				<h4>Symptoms Duration</h4>
				<div class="blockTitleCurve"></div>
				<div class="Clear"></div>
				<%if(opdOphthalmology!=null){ %>
				<input type="hidden" name="opdOphthalmologyId"
					value="<%=opdOphthalmology.getId()%>">
				<%}else{ %>
				<input type="hidden" name="opdOphthalmologyId" value="0">
				<%} %>
				<label>Decreased Vision</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getDecreasedVision()!=null ){ %>
				<input name="<%=DECREASED_VISION %>" type="text"
					value="<%=opdOphthalmology.getDecreasedVision() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=DECREASED_VISION %>" type="text" value=""
					maxlength="20">
				<%} %>
				<label>Redness</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getRedness()!=null ){ %>
				<input name="<%=REDNESS %>" type="text"
					value="<%=opdOphthalmology.getRedness() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=REDNESS %>" type="text" value="" maxlength="20">
				<%} %>
				<div class="Clear"></div>
				<label>Pain</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getPain()!=null ){ %>
				<input name="<%=PAIN %>" type="text"
					value="<%=opdOphthalmology.getPain() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=PAIN %>" type="text" value="" maxlength="20">
				<%} %>
				<label>Discharge</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getDischarge()!=null ){ %>
				<input name="<%=DISCHARGE %>" type="text"
					value="<%=opdOphthalmology.getDischarge() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=DISCHARGE %>" type="text" value="" maxlength="20">
				<%} %>
				<div class="division"></div>
				<label class="auto">Floater/ Trauma/ Epiphora etc</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getFloaterTraumaEpiphora()!=null ){ %>
				<input name="<%=FLOATER_TRAUMA_EPIPHORA %>" type="text"
					value="<%=opdOphthalmology.getFloaterTraumaEpiphora() %>"
					maxlength="30">
				<%}else{ %>
				<input name="<%=FLOATER_TRAUMA_EPIPHORA %>" type="text" value=""
					maxlength="30">
				<%} %>
				<div class="division"></div>
				<h4>Functional Assessment</h4>
				<div class="blockTitleCurve"></div>
				<div class="Clear"></div>
				<label>Reading</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getReading()!=null && opdOphthalmology.getReading().equals("R")){ %>
				<input name="<%=READING %>" type="checkbox" value="R"
					class="checkbox" checked="checked">
				<%}else{ %>
				<input name="<%=READING %>" type="checkbox" value="R"
					class="checkbox">
				<%} %>
				<label>Driving</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getDriving()!=null && opdOphthalmology.getDriving().equals("D") ){ %>
				<input name="<%=DRIVING %>" type="checkbox" value="D"
					class="checkbox" checked="checked">
				<%}else{ %>
				<input name="<%=DRIVING %>" type="checkbox" value="D"
					class="checkbox">
				<%} %>
				<label>Cooking</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getCooking()!=null && opdOphthalmology.getCooking().equals("C")  ){ %>
				<input name="<%=COOKING %>" type="checkbox" value="C"
					class="checkbox" checked="checked">
				<%}else{ %>
				<input name="<%=COOKING %>" type="checkbox" value="C"
					class="checkbox">
				<%} %>
				<label>Ambulatory</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getAmbulatry()!=null && opdOphthalmology.getAmbulatry().equals("A") ){ %>
				<input name="<%=AMBULATORY%>" type="checkbox" value="A"
					class="checkbox" checked="checked">
				<%}else{ %>
				<input name="<%=AMBULATORY%>" type="checkbox" value="A"
					class="checkbox">
				<%} %>
				<div class="Clear"></div>
				<label>Personal Hygiene</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getPersonalHygiene()!=null && opdOphthalmology.getPersonalHygiene().equals("P")){ %>
				<input name="<%=PERSONAL_HYGIENE %>" type="checkbox" value="P"
					class="checkbox" checked="checked">
				<%}else{ %>
				<input name="<%=PERSONAL_HYGIENE %>" type="checkbox" value="P"
					class="checkbox">
				<%} %>

				<div class="division"></div>

				<h4>Treatment History</h4>
				<div class="blockTitleCurve"></div>
				<div class="Clear"></div>
				<label>DM</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getDm()!=null && opdOphthalmology.getDm().equals("D")){ %>
				<input name="<%=DM%>" type="checkbox" value="D" class="checkbox"
					checked="checked">
				<%}else{ %>
				<input name="<%=DM%>" type="checkbox" value="D" class="checkbox">
				<%} %>
				<label>HTN</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getHtn()!=null && opdOphthalmology.getHtn().equals("H")){ %>
				<input name="<%=HTN%>" type="checkbox" value="H" class="checkbox"
					checked="checked">
				<%}else{ %>
				<input name="<%=HTN%>" type="checkbox" value="H" class="checkbox">
				<%} %>
				<label>Bronchial Asthma</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getBa()!=null && opdOphthalmology.getBa().equals("B")){ %>
				<input name="<%=BA %>" type="checkbox" value="B" class="checkbox"
					checked="checked">
				<%}else{ %>
				<input name="<%=BA %>" type="checkbox" value="B" class="checkbox">
				<%} %>
				<label>CAD</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getCad()!=null && opdOphthalmology.getCad().equals("C")){ %>
				<input name="<%=CAD%>" type="checkbox" value="C" class="checkbox"
					checked="checked">
				<%}else{ %>
				<input name="<%=CAD%>" type="checkbox" value="C" class="checkbox">
				<%} %>
				<div class="Clear"></div>
				<label>Autoimmune</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getAutoimmune()!=null && opdOphthalmology.getAutoimmune().equals("A")){ %>
				<input name="<%=AUTOIMMUNE %>" type="checkbox" value="A"
					class="checkbox" checked="checked">
				<%}else{ %>
				<input name="<%=AUTOIMMUNE %>" type="checkbox" value="A"
					class="checkbox">
				<%} %>
				<label>Others</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getOthers()!=null && opdOphthalmology.getOthers().equals("O")){ %>
				<input name="<%=OTHERS %>" type="checkbox" value="O"
					class="checkbox" checked="checked">
				<%}else{ %>
				<input name="<%=OTHERS %>" type="checkbox" value="O"
					class="checkbox">
				<%} %>

				<div class="Clear"></div>

				<div class="division"></div>
				<h4>OCULAR EXAMINATION</h4>

				<div class="Clear"></div>

				<label><u>Vision</u></label> <label>&nbsp;</label> <label>RE</label>
				<label>LE</label> <label>PH</label>

				<div class="Clear"></div>
				<label>Distance</label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getDistanceRe()!=null ){ %>
				<input name="<%=DISTANCE_RE %>" type="text"
					value="<%=opdOphthalmology.getDistanceRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=DISTANCE_RE %>" type="text" value="" maxlength="20">
				<%} if(opdOphthalmology!=null && opdOphthalmology.getDistanceLe()!=null ){ %>
				<input name="<%=DISTANCE_LE %>" type="text"
					value="<%=opdOphthalmology.getDistanceLe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=DISTANCE_LE %>" type="text" value="" maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getDistancePh()!=null ){  %>
				<input name="<%=DISTANCE_PH %>" type="text"
					value="<%=opdOphthalmology.getDistancePh() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=DISTANCE_PH %>" type="text" value="" maxlength="20">
				<%}%>
				<div class="Clear"></div>
				<label>Near</label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getNearRe()!=null ){ %>
				<input name="<%=NEAR_RE %>" type="text"
					value="<%=opdOphthalmology.getNearRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=NEAR_RE %>" type="text" value="" maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getNearLe()!=null ){ %>
				<input name="<%=NEAR_LE %>" type="text"
					value="<%=opdOphthalmology.getNearLe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=NEAR_LE %>" type="text" value="" maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getNearPh()!=null ){ %>
				<input name="<%=NEAR_PH %>" type="text"
					value="<%=opdOphthalmology.getNearPh() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=NEAR_PH %>" type="text" value="" maxlength="20">
				<%} %>
				<div class="Clear"></div>
				<label>Refraction</label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getRefractionRe()!=null ){ %>
				<input name="<%=REFRACTION_RE %>" type="text"
					value="<%=opdOphthalmology.getRefractionRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=REFRACTION_RE %>" type="text" value=""
					maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getRefractionLe()!=null ){ %>
				<input name="<%=REFRACTION_LE %>" type="text"
					value="<%=opdOphthalmology.getRefractionLe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=REFRACTION_LE %>" type="text" value=""
					maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getRefractionPh()!=null ){ %>
				<input name="<%=REFRACTION_PH %>" type="text"
					value="<%=opdOphthalmology.getRefractionPh() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=REFRACTION_PH %>" type="text" value=""
					maxlength="20">
				<%} %>
				<div class="Clear"></div>
				<label>Acceptance</label> <label>Distance</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceDistanceRe()!=null ){ %>
				<input name="<%=ACCEPTANCE_DISTANCE_RE %>" type="text"
					value="<%=opdOphthalmology.getAcceptanceDistanceRe() %>"
					maxlength="20">
				<%}else{ %>
				<input name="<%=ACCEPTANCE_DISTANCE_RE %>" type="text" value=""
					maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceDistanceLe()!=null ){ %>
				<input name="<%=ACCEPTANCE_DISTANCE_LE %>" type="text" value=""
					maxlength="20">
				<%}else{ %>
				<input name="<%=ACCEPTANCE_DISTANCE_LE %>" type="text" value=""
					maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceDistancePh()!=null ){ %>
				<input name="<%=ACCEPTANCE_DISTANCE_PH %>" type="text"
					value="<%=opdOphthalmology.getAcceptanceDistancePh() %>"
					maxlength="20">
				<%}else{ %>
				<input name="<%=ACCEPTANCE_DISTANCE_PH %>" type="text" value=""
					maxlength="20">
				<%} %>
				<div class="Clear"></div>
				<label>&nbsp;</label> <label>Near</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceNearRe()!=null ){ %>
				<input name="<%=ACCEPTANCE_NEAR_RE %>" type="text"
					value="<%=opdOphthalmology.getAcceptanceNearRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=ACCEPTANCE_NEAR_RE %>" type="text" value=""
					maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceNearLe()!=null ){ %>
				<input name="<%=ACCEPTANCE_NEAR_LE %>" type="text"
					value="<%=opdOphthalmology.getAcceptanceNearLe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=ACCEPTANCE_NEAR_LE %>" type="text" value=""
					maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getAcceptanceNearPh()!=null ){ %>
				<input name="<%=ACCEPTANCE_NEAR_PH %>" type="text"
					value="<%=opdOphthalmology.getAcceptanceNearPh() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=ACCEPTANCE_NEAR_PH %>" type="text" value=""
					maxlength="20">
				<%} %>

				<div class="division"></div>
				<label>Convergence</label> <label>&nbsp;</label> 
				
				<select		name="selConvergence" onchange="checkOption(this);">
					<option value="">Select</option>
					<%if(opdOphthalmology!=null && opdOphthalmology.getConvergence()!=null && opdOphthalmology.getConvergence().equalsIgnoreCase("normal") ){ %>
					<option value="normal" selected="selected">Normal</option>
					<%}else{ %>
					<option value="normal">Normal</option>
					
					
					<%}if(opdOphthalmology!=null && opdOphthalmology.getConvergence()!=null && opdOphthalmology.getConvergence().equalsIgnoreCase("abnormal") ){ %>
					<option value="abnormal" selected="selected">Abnormal</option>
					<%}else{ %>
					<option value="abnormal">Abnormal</option>
					<%} %>
				</select> <input name="<%=CONVERGENCE %>" type="text" value="" maxlength="10">
				<div class="Clear"></div>
				<label>Color Vision </label> <label>&nbsp;</label> <select
					name="selColorVision" onchange="checkOption(this);">
					<option value="">Select</option>
					<%if(opdOphthalmology!=null && opdOphthalmology.getColorVision()!=null && opdOphthalmology.getColorVision().equalsIgnoreCase("normal") ){ %>
					<option value="normal">Normal</option>
					<%}else{ %>
					<option value="normal">Normal</option>
					<%}if(opdOphthalmology!=null && opdOphthalmology.getColorVision()!=null && opdOphthalmology.getColorVision().equalsIgnoreCase("abnormal") ){ %>
					<option value="abnormal">Abnormal</option>
					<%}else{ %>
					<option value="abnormal">Abnormal</option>
					<%} %>
				</select> <input name="<%=COLOR_VISION %>" type="text" value=""
					maxlength="10">
				<div class="Clear"></div>
				<label>Ocular Movements </label> <label>&nbsp;</label> <select
					name="selOcularMovements" onchange="checkOption(this);">
					<option value="">Select</option>
					<%if(opdOphthalmology!=null && opdOphthalmology.getOcularMovement()!=null && opdOphthalmology.getOcularMovement().equalsIgnoreCase("normal") ){ %>
					<option value="normal" selected="selected">Normal</option>
					<%}else{ %>
					<option value="normal">Normal</option>
					<%}if(opdOphthalmology!=null && opdOphthalmology.getOcularMovement()!=null && opdOphthalmology.getOcularMovement().equalsIgnoreCase("normal") ){ %>
					<option value="abnormal" selected="selected">Abnormal</option>
					<%}else{ %>
					<option value="abnormal">Abnormal</option>
					<%} %>
				</select> <input name="<%=OCULAR_MOVEMENTS %>" type="text" value=""
					maxlength="10">
				<div class="Clear"></div>
				<label>Lids</label> <label>&nbsp;</label> <select name="selLids"
					onchange="checkOption(this);">
					<option value="">Select</option>
					<%if(opdOphthalmology!=null && opdOphthalmology.getLids()!=null && opdOphthalmology.getLids().equalsIgnoreCase("normal") ){ %>
					<option value="normal" selected="selected">Normal</option>
					<%}else{ %>
					<option value="normal">Normal</option>
					<%}if(opdOphthalmology!=null && opdOphthalmology.getLids()!=null && opdOphthalmology.getLids().equalsIgnoreCase("normal") ){ %>
					<option value="abnormal" selected="selected">Abnormal</option>
					<%}else{ %>
					<option value="abnormal">Abnormal</option>
					<%} %>
				</select> <input name="<%=LIDS %>" type="text" value="" maxlength="10">
				<div class="Clear"></div>
				<label>Conjunctiva</label> <label>&nbsp;</label> <select
					name="selConjunctiva" onchange="checkOption(this);">
					<option value="">Select</option>
					<%if(opdOphthalmology!=null && opdOphthalmology.getConjunctiva()!=null && opdOphthalmology.getConjunctiva().equalsIgnoreCase("normal") ){ %>
					<option value="normal" selected="selected">Normal</option>
					<%}else{ %>
					<option value="normal">Normal</option>
					<%}if(opdOphthalmology!=null && opdOphthalmology.getConjunctiva()!=null && opdOphthalmology.getConjunctiva().equalsIgnoreCase("normal") ){ %>
					<option value="abnormal" selected="selected">Abnormal</option>
					<%}else{ %>
					<option value="abnormal">Abnormal</option>
					<%} %>
				</select> <input name="<%=CONJUNCTIVA %>" type="text" value="" maxlength="10">
				<div class="Clear"></div>
				<label>Cornea &amp; AC </label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getCorneaAcRe()!=null ){%>
				<input name="<%=CORNEA_AC_RE %>" type="text"
					value="<%=opdOphthalmology.getCorneaAcRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=CORNEA_AC_RE %>" type="text" value="" maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getCorneaAcLe()!=null ){%>
				<input name="<%=CORNEA_AC_LE %>" type="text"
					value="<%=opdOphthalmology.getCorneaAcLe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=CORNEA_AC_LE %>" type="text" value="" maxlength="20">
				<%} %>
				<div class="division"></div>



				<label>Ant chamber depth</label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getAntChamberDepthRe()!=null ){%>
				<input name="<%=ANT_CHAMBER_RE %>" type="text"
					value="<%=opdOphthalmology.getAntChamberDepthRe() %>"
					maxlength="20">
				<%}else{ %>
				<input name="<%=ANT_CHAMBER_RE %>" type="text" value=""
					maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getAntChamberDepthLe()!=null ){ %>
				<input name="<%=ANT_CHAMBER_LE %>" type="text"
					value="<%=opdOphthalmology.getAntChamberDepthLe() %>"
					maxlength="20">
				<%}else{ %>
				<input name="<%=ANT_CHAMBER_LE %>" type="text" value=""
					maxlength="20">
				<%} %>

				<div class="Clear"></div>
				<label>Cells/flare</label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getCellsFlareRe()!=null ){%>
				<input name="<%=CELLS_FLARE_RE %>" type="text"
					value="<%=opdOphthalmology.getCellsFlareRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=CELLS_FLARE_RE %>" type="text" value=""
					maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getCellsFlareLe()!=null ){ %>
				<input name="<%=CELLS_FLARE_LE %>" type="text"
					value="<%=opdOphthalmology.getCellsFlareLe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=CELLS_FLARE_LE %>" type="text" value=""
					maxlength="20">
				<%} %>
				<div class="Clear"></div>
				<label>PXF/NVI</label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getPxfNviRe()!=null ){%>
				<input name="<%=PXF_NVI_RE %>" type="text"
					value="<%=opdOphthalmology.getPxfNviRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=PXF_NVI_RE %>" type="text" value="" maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getPxfNviLe()!=null ){ %>
				<input name="<%=PXF_NVI_LE %>" type="text"
					value="<%=opdOphthalmology.getPxfNviLe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=PXF_NVI_LE %>" type="text" value="" maxlength="20">
				<%} %>
				<div class="Clear"></div>

				<label>Pupil Reaction </label> <label>Direct</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getPupilReactionDirect()!=null && opdOphthalmology.getPupilReactionDirect().equalsIgnoreCase("D") ){%>
				<input name="<%=DIRECT %>" type="checkbox" value="D"
					class="checkbox" checked="checked">
				<%}else{ %>
				<input name="<%=DIRECT %>" type="checkbox" value="D"
					class="checkbox">
				<%} %>
				<label>Consensnal</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getPupilReactionConsensnal()!=null && opdOphthalmology.getPupilReactionConsensnal().equalsIgnoreCase("C") ){%>
				<input name="<%=CONSENSNAL %>" type="checkbox" value="C"
					class="checkbox" checked="checked">
				<%}else{ %>
				<input name="<%=CONSENSNAL %>" type="checkbox" value="C"
					class="checkbox">
				<%} %>
				<label>RAPD</label> <input name="<%=RAPD %>" type="checkbox"
					value="P" class="checkbox">


				<div class="Clear"></div>
				<label>Gonioscopy </label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getGonioscopyRe()!=null){%>
				<input name="<%=GONIOSCOPY_RE %>" type="text"
					value="<%=opdOphthalmology.getGonioscopyRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=GONIOSCOPY_RE %>" type="text" value=""
					maxlength="20">
				<%} if(opdOphthalmology!=null && opdOphthalmology.getGonioscopyLe()!=null){%>
				<input name="<%=GONIOSCOPY_LE %>" type="text"
					value="<%=opdOphthalmology.getGonioscopyLe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=GONIOSCOPY_LE %>" type="text" value=""
					maxlength="20">
				<%} %>
				<div class="Clear"></div>
				<label>IOP(months)</label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getIopRe()!=null){%>
				<input name="<%=IOP_RE %>" type="text"
					value="<%=opdOphthalmology.getIopRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=IOP_RE %>" type="text" value="" maxlength="20">
				<%} if(opdOphthalmology!=null && opdOphthalmology.getIopLe()!=null){%>
				<input name="<%=IOP_LE %>" type="text"
					value="<%=opdOphthalmology.getIopLe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=IOP_LE %>" type="text" value="" maxlength="20">
				<%} %>
				<div class="division"></div>
				<h4>Sac</h4>
				<div class="Clear"></div>
				<label>Papillary Dilatation </label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getDilationRe()!=null){%>
				<input name="<%=DILATION_RE %>" type="text"
					value="<%=opdOphthalmology.getDilationRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=DILATION_RE %>" type="text" value="" maxlength="20">
				<%} if(opdOphthalmology!=null && opdOphthalmology.getDilationLe()!=null){%>
				<input name="<%=DILATION_LE %>" type="text"
					value="<%=opdOphthalmology.getDilationLe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=DILATION_LE %>" type="text" value="" maxlength="20">
				<%} %>
				<div class="Clear"></div>
				<label>Lens </label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getLensRe()!=null){%>
				<input name="<%=LENS_RE %>" type="text"
					value="<%=opdOphthalmology.getLensRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=LENS_RE %>" type="text" value="" maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getLensLe()!=null){%>
				<input name="<%=LENS_LE %>" type="text"
					value="<%=opdOphthalmology.getLensLe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=LENS_LE %>" type="text" value="" maxlength="20">
				<%} %>
				<div class="Clear"></div>
				<label>Fundus</label> <label>&nbsp;</label>
				<%if(opdOphthalmology!=null && opdOphthalmology.getFundusRe()!=null){%>
				<input name="<%=FUNDUS_RE %>" type="text"
					value="<%=opdOphthalmology.getFundusRe() %>" maxlength="20">
				<%}else{ %>
				<input name="<%=FUNDUS_RE %>" type="text" value="" maxlength="20">
				<%}if(opdOphthalmology!=null && opdOphthalmology.getFundusLe()!=null){%>
				<input name="<%=FUNDUS_LE %>" type="text"
					value="<%= opdOphthalmology.getFundusLe()%>" maxlength="20">
				<%}else{ %>
				<input name="<%=FUNDUS_LE %>" type="text" value="" maxlength="20">
				<%} %>
			</div>


		</div>

		<div id="country2" class="tabcontentIn">
			<div class="Block" style="width:1170px;">
				<h2>System Functional Assesment</h2>
				<div class="clear"></div>
				<div class="clear"></div>
				<h4>Vision</h4>
				<div class="clear"></div>
				<label>Ant Segment</label> <label class="valueNoWidth">RE</label> <input
					name="<%=ANT_SEGMENT_RE %>" type="text" value="" maxlength="20">
				<label class="valueNoWidth">LE</label> <input
					name="<%=ANT_SEGMENT_LE%>" type="text" value="" size="10"
					maxlength="20">

				<div class="clear"></div>

				<label>IOP</label> <label class="valueNoWidth">&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input name="<%=IOP%>" type="text" value="" size="10" maxlength="20">

				<div class="clear"></div>

				<h4>Fundus</h4>
				<div class="clear"></div>
				<label>RE</label> <input name="<%=FUNDUS_RE %>" type="text" value=""
					size="10" maxlength="20"> <label>LE</label> <input
					name="<%=FUNDUS_LE%>" type="text" value="" size="10" maxlength="20">
				<label>Adv</label><input name="<%=ADV%>" type="text" value=""
					size="10" maxlength="20">
				<div class="clear"></div>

			</div>
		</div>


		<div class="clear"></div>

		<div id="country3" class="tabcontentIn">
			<div class="Block" style="width:1170px;">

				<label>Right Eye</label> <input name="<%=RIGHT_EYE %>" type="text"
					value="" maxlength="25"> <label>Left Eye</label> <input
					name="<%=LEFT_EYE%>" type="text" value="" maxlength="25">
				<div class="clear"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" >
					<tr>
						<th>Eye</th>
						<th>Power</th>
						<th>Duration</th>
						<th>No. of Spots</th>
						<th>Laser Type</th>
						<th>Dr. Name</th>
						<th>Sign</th>
					</tr>
					<%
  	for(int i=1;i<=2;i++){
  
  %>
					<tr>
						<td width="10%"><select name="<%=EYE %>">
								<option value="">Select</option>
								<option value="LE">Left Eye</option>
								<option value="RE">Right Eye</option>
						</select></td>
						<td><input type="text" name="<%=POWER %>" value="" size="10"
							validate="Power,string,no" tabindex="1" maxlength="10" /></td>
						<td><input type="text" name="<%=DURATION %>" value=""
							size="10" validate="Duration,string,no" tabindex="1"
							maxlength="10" /></td>
						<td><input type="text" name="<%=NO_OF_SPOTS %>" value=""
							size="10" validate="No.Of Spots,string,no" tabindex="1"
							maxlength="10" /></td>
						<td><input type="text" name="<%=LASER_TYPE %>" value=""
							size="20" validate="Laser Type,string,no" tabindex="1"
							maxlength="20" /></td>
						<td><input type="text" name="<%=DOCTOR_NAME %>" value=""
							size="20" validate="Doctor Name,string,no" tabindex="1"
							maxlength="45" /></td>
						<td><input type="text" name="<%=SIGN %>" value="" size="15"
							validate="Sign,string,no" tabindex="1" maxlength="25" /></td>
					</tr>
					<%} %>
				</table>

			</div>
		</div>

		<div id="country4" class="tabcontentIn">

			<div class="Block" style="width:1170px;">

				<a href="javascript:changeClass('title2','t2')">
					<h5 id='t2'>Diagnosis</h5>
				</a>
				<div class="clear"></div>


				<div class="clear"></div>
				<label>Ocular</label> <input name="<%=OCULAR %>" type="text"
					value="" maxlength="20"><label>Systemic</label> <input
					name="<%=SYSTEMIC %>" type="text" value="" maxlength="20">
				<div class="clear"></div>
				<label>Plan</label> <input name="<%=PLAN %>" type="text" value=""
					maxlength="20">
				<div class="clear"></div>

				<div class="division"></div>
				<a href="javascript:changeClass('title3','t3')">
					<h5 id='t3'>Counselling</h5>
				</a>
				<div class="clear"></div>
				<div class="clear"></div>
				<h4>Advice</h4>
				<div class="clear"></div>
				<label>Sr.No.</label> <label class="center">Medicine</label> <label
					class="center">UOM</label> <label class="center">Frequency</label>
				<label class="center">Eye</label>
				<div class="clear"></div>
				<%
	for(int i=1;i<=8;i++){
%>
				<label><%=i %>.</label> <input name="<%=MEDICINE %>" type="text"
					value="" maxlength="20"><select name="<%=UOM %>">
					<option value="">Select</option>
					<option value="eyeDrop">Eye Drop</option>
					<option value="mg">Mg</option>
				</select> <select name="<%=FREQUENCY %>">
					<option value="0">Select</option>
					<%
	if(frequencyList.size() > 0){
		for(MasFrequency frequency : frequencyList){	
%>
					<option value="<%=frequency.getId() %>"><%=frequency.getFrequencyName() %></option>
					<%} 
}%>
				</select> <select name="<%=EYE %>">
					<option value="">Select</option>
					<option value="RE">Right Eye</option>
					<option value="LE">Left Eye</option>
					<option value="BE">Both Eyes</option>

				</select>
				<div class="clear"></div>
				<%} %>

				<div class="clear"></div>
				<div class="division"></div>


				<a href="javascript:changeClass('title4','t4')">
					<h5 id='t4'>Surgery</h5>
				</a>
				<div class="clear"></div>


				<div class="clear"></div>
				<label>Right Eye</label> <input name="<%=RIGHT_EYE %>" type="text"
					value="" maxlength="20"><label>Left Eye</label> <input
					name="<%=LEFT_EYE%>" type="text" value="" maxlength="20">
				<div class="clear"></div>
				<label>Anesthesia Type</label> <select name="<%=ANESTHESIA_ID %>">
					<option value="0">Select</option>
					<%
	if(anesthesiaList.size() > 0){
		for(MasAnesthesia anesthesia : anesthesiaList){	
%>
					<option value="<%=anesthesia.getId() %>"><%=anesthesia.getAnesthesiaName() %></option>
					<%}
		}%>
				</select> <label>Next Review Date</label> <input
					name="<%=NEXT_REVIEW_DATE %>" type="text" value="" maxlength="20">
				<div class="clear"></div>

			</div>
		</div>
	</div>
			<script type="text/javascript">
			var countries = new ddtabcontent("countrytabsIn")
		countries.setpersist(true)
		countries.setselectedClassTarget("link") //"link" or "linkparent"
		countries.init()
		countries.expandit(0);

</script>
	
	

	<input type="hidden" name="<%=HIN_ID %>"
		value="<%=visit.getHin().getId() %>"> <input type="hidden"
		name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
		type="hidden" name="<%=VISIT_NUMBER %>"
		value="<%=visit.getVisitNo() %>"> <input type="hidden"
		name="currentVisitId" value="<%=visit.getId() %>">
	<!--Bottom labels starts-->

	<input name="Save" type="button" class="button" value="Submit" 	onclick="submitForm('opdOphthalmology','opd?method=submitOphthalmologyDetails');" >
	<input name="view" type="button" class="button" value="View" onclick="submitForm('opdOphthalmology','opd?method=viewPatientOphthalmologyDetails&flag=prev&viewScreen=no');">
	<input name="reset" type="reset" class="button" value="Reset"	onclick="submitForm('opdOphthalmology','opd?method=showOpdOphthamologyJsp');">
	<input name="reset" type="reset" class="button" value="Cancel"	onclick="setValuesInParents()">
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>	
	</form>
	</div>
	
	<!--Bottom labels ends-->
		<script type="text/javascript">
	function setValuesInParents(){
		
		window.close();
	}

		function checkOption(obj) {
alert(obj)
			var field = eval('document.opdOphthalmology.' + obj.name);
			if (field.value == "normal") {
				if (obj.name == "selConvergence") {
					document.opdOphthalmology.<%=CONVERGENCE%>.value = "Normal";
				}
				if (obj.name == "selColorVision") {
					document.opdOphthalmology.
	<%=COLOR_VISION%>
		.value = "Normal";
				}
				if (obj.name == "selOcularMovements") {
					document.opdOphthalmology.
	<%=OCULAR_MOVEMENTS%>
		.value = "Normal";
				}
				if (obj.name == "selLids") {
					document.opdOphthalmology.
	<%=LIDS%>
		.value = "Normal";
				}
				if (obj.name == "selConjunctiva") {
					document.opdOphthalmology.
	<%=CONJUNCTIVA%>
		.value = "Normal";
				}

			} else if (field.value == "abnormal") {
				if (obj.name == "selConvergence") {
					document.opdOphthalmology.
	<%=CONVERGENCE%>
		.value = "";
				}
				if (obj.name == "selColorVision") {
					document.opdOphthalmology.
	<%=COLOR_VISION%>
		.value = "";
				}
				if (obj.name == "selOcularMovements") {
					document.opdOphthalmology.
	<%=OCULAR_MOVEMENTS%>
		.value = "";
				}
				if (obj.name == "selLids") {
					document.opdOphthalmology.
	<%=LIDS%>
		.value = "";
				}
				if (obj.name == "selConjunctiva") {
					document.opdOphthalmology.
	<%=CONJUNCTIVA%>
		.value = "";
				}
			}
		}

		function checkTab(tab) {
			document.getElementById("tab").value = tab;
		}

	</script>

<!--main content placeholder ends here-->
