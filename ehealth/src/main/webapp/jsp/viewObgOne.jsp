<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.OpdObg"%>

<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>

<%--For AutoComplete Through Ajax--%>
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
<!--main content placeholder starts here-->
<form name="viewObg" method="post" action="">


<div class="titleBg">
<h2>OPD OBG</h2>
</div>
<div class="clear"></div>


<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdObg> obgList = new ArrayList<OpdObg>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}		
		
		if(detailsMap.get("patientDataList") != null){
			patientDataList=(List<Visit>)detailsMap.get("patientDataList");
		}	
		if(map.get("obgList") != null){
			obgList=(List<OpdObg>)map.get("obgList");
		}	
		int currentVisitId = 0;
		if(map.get("currentVisitId") != null){
			currentVisitId = (Integer)map.get("currentVisitId");
		}
		
		
%> <%
if(obgList.size() > 0){
	
	OpdObg opdObg = new OpdObg();
	opdObg = obgList.get(0);
	
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
	
%>


<div class="clear"></div>

<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><label class="medium">HIN</label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label> <%}else{ %>
<label class="valueMedium">-</label> <%} %> <label>Patient Name </label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label class="medium">Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getAge() %></label> <%}else{ %>
<label class="valueMedium">-</label> <%} %> <label class="medium">Visit
Date </label> <%if(visitDateInString != null){ %> <label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>

<div class="clear"></div>

<label class="medium">Visit No. </label> <%if(visit.getVisitNo()!= null){ %>
<label class="valueMedium"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="valueMedium">-</label> <%} %> <label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> <%}else{ %> <label>-</label>
<%} %> <label class="medium">Prev. Diag </label> <%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>





<div class="clear"></div>
</div>
<!--Block one Ends-->
<div class="clear"></div>

<!--Block two Start--> <!--Block Two Starts-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>SOCIOECONOMIC HISTORY</h5>
</a>
<div class="Block" id="title1">
<div class="clear"></div>
<div class="paddLeft55"><label>Wife</label> <label>Husband</label>
</div>

<div class="clear"></div>
<label>Education</label><label></label> <input
	name="<%=EDUCATION_WIFE%>" value="<%=opdObg.getEducationWife() %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=EDUCATION_HUSBAND %>"
	value="<%=opdObg.getEducationHusband() %>" maxlength="20" type="text">

<div class="clear"></div>

<label>Religion<span></span></label><label></label> <%if(opdObg.getReligionWife()==null){ %>
<label class="value"></label> <%}else{ %> <label class="value"><%=opdObg.getReligionWife().getReligionName() %></label>
<%} %> <label></label> <%if(opdObg.getReligionWife()==null){ %> <label
	class="value"></label> <%}else{ %> <label class="value"><%=opdObg.getReligionHusband().getReligionName() %></label>
<%} %>
<div class="clear"></div>

<label>Occupation<span></span></label><label></label> <%if(opdObg.getOccupationHusband()==null){ %>
<label class="value"></label> <%}else{ %> <label class="value"><%=opdObg.getOccupationWife().getOccupationName() %></label>
<%} %> <label></label> <%if(opdObg.getOccupationHusband()==null){ %> <label
	class="value"></label> <%}else{ %> <label class="value"><%=opdObg.getOccupationHusband().getOccupationName() %></label>
<%} %>
<div class="clear"></div>


<label>Accommodation Type</label><label></label> <input
	name="<%=ACCOMMODATION_TYPE %>"
	value="<%=opdObg.getTypeOfAccommodation() %>" maxlength="15"
	type="text"> <label>Privacy</label> <label class="valueNoWidth">Yes</label>
<input name="<%=PRIVACY %>" value="<%=opdObg.getPrivacy()%>"
	type="radio" class="radio" /> <label class="valueNoWidth">NO</label> <input
	name="<%=PRIVACY %>" value="<%=opdObg.getPrivacy()%>" type="radio"
	class="radio" />
<div class="clear"></div></div>
<!--Block Two Ends--> <!--Block Three Starts-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>COMPLAINTS</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2">
<div class="clear"></div>
<label>Infertility</label> <label></label> <label>Primary: Yrs:</label>
<input name="<%=INFERTILITY_PRIMARY_YRS %>"
	value="<%=opdObg.getInfertilityPrimaryYrs()%>" maxlength="5"
	type="text"> <label>Secondary: Yrs:</label> <input
	name="<%=INFERTILITY_SECONDARY_YRS %>"
	value="<%=opdObg.getInfertilitySecondaryYrs()%>" maxlength="5"
	type="text">

<div class="clear"></div>
<label>Hypomenorrohea</label> <input name="<%=HYPOMENRROHEA %>"
	value="<%=opdObg.getHypomenorrohea()%>" maxlength="5" type="text" /> <label>Yrs:</label>
<input name="<%=HYPOMENRROHEA_YRS %>"
	value="<%=opdObg.getHypomenorroheaYrs()%>" maxlength="5" type="text">
<label>Oligomenorrhoea: Yrs:</label> <input
	name="<%=OLIGOMEORRHOEA_YRS %>"
	value="<%=opdObg.getOligomenorrhoeaYrs()%>" maxlength="5" type="text">
<div class="clear"></div>
<label> Galactorrhoea</label> <input name="<%=GALACTORRHOEA %>"
	value="<%=opdObg.getGalactorrhoea()%>" maxlength="15" type="text" /> <label>Yrs:</label>
<input name="<%=GALACTORRHOEA_YRS %>"
	value="<%=opdObg.getGalactorrhoeaYrs()%>" maxlength="5" type="text">
<label>Hirsutism : Yrs:</label> <input name="<%=HIRSUTISM_YRS %>"
	value="<%=opdObg.getHirsutismYrs()%>" maxlength="5" type="text">
<div class="clear"></div>
<label>Leucorrhoea</label> <input name="<%=LEUCORRHOEA %>"
	value="<%=opdObg.getLeucorrhoea()%>" maxlength="15" type="text" /> <label></label>
<label></label> <label>Pruritis Valve</label> <input
	name="<%=PRURITIS_VALUE %>" value="<%=opdObg.getPruritisValue()%>"
	maxlength="15" type="text">
<div class="clear"></div>

<label>Backaches</label> <input name="<%=BACKACHES %>"
	value="<%=opdObg.getBackaches()%>" maxlength="15" type="text" /> <label></label>
<label></label> <label>Dysmenorrhoea</label> <input
	name="<%=DYSMENORRHOEA %>" value="<%=opdObg.getDysmenorrhoea()%>"
	maxlength="15" type="text">
<div class="clear"></div></div>

<!--Block Three Ends--> <!--Block Four Ends-->

<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>MENSTRUALl</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">
<div class="clear"></div>
<label>Menarche YRS:</label> <input name="<%=MENARCHE_YRS %>"
	value="<%=opdObg.getMenarcheYrs()%>" maxlength="5" type="text">
<label>Past MC</label> <input name="<%=PAST_MC %>"
	value="<%=opdObg.getPastMc()%>" maxlength="15" type="text"> <label>Present
MC</label> <input name="<%=PRESENT_MC %>" value="<%=opdObg.getPresentMc()%>"
	maxlength="15" type="text">
<div class="clear"></div>

<label>LMP</label> <input name="<%=LMP %>" value="<%=opdObg.getLmp()%>"
	maxlength="15" type="text"> <label>PMP1</label> <input
	name="<%=PMP_ONE %>" value="<%=opdObg.getPmpOne()%>" maxlength="15"
	type="text"> <label>PMP2</label> <input name="<%=PMP_TWO %>"
	value="<%=opdObg.getPmpTwo()%>" maxlength="15" type="text">
<div class="clear"></div></div>

<!--Block Four Ends--> <!--Block Five Ends-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title4','t4')">
<h5 id='t4'>PAST SURGICAL HISTORY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title4">
<div class="clear"></div>
<label>Diagnostic Scopy</label> <input name="<%=DIAGNOSTIC_SCOPY %>"
	value="<%=opdObg.getDiagnosticScopy()%>" maxlength="20" type="text">
<label></label> <label>Tubal Surgery</label> <input
	name="<%=TUBAL_SURFERY %>" value="<%=opdObg.getTubalSurgery()%>"
	maxlength="20" type="text">
<div class="clear"></div>
<label>Exploratory Lap</label> <input name="<%=EXPLORATORY_LAP %>"
	value="<%=opdObg.getExploratoryLaparotomy()%>" maxlength="20"
	type="text"> <label></label> <label>Operative Scopy</label> <input
	name="<%=OPERATIVE_SCOPY %>" value="<%=opdObg.getOperativeScopy()%>"
	maxlength="20" type="text">
<div class="clear"></div>

</div>
<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">



<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<!--Bottom labels starts-->
<div class="clear"></div>
<input name="prev" type="button" class="button" value="Prev"
	onclick="submitForm('viewObg','opd?method=viewOBGONE&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewObg','opd?method=viewOBGONE&flag=next');">
<input name="button" type="button" class="buttonActive" id="btn2"
	value="Page 1" /> <input name="Button" type="button" class="button"
	value="Page 2"
	onclick="submitForm('viewObg','opd?method=viewOBGTWO&visitId=<%=currentVisitId%>');" />
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('viewObg','<%=url%>');" align="right" /> <%}%> <!--Bottom labels ends-->
<%}else{%> No Record Found!! <!--Bottom labels starts--> <input
	name="Back" type="button" src="images/phaseII/delete.gif" alt="Back"
	value="Back" class="button" onclick="history.go(-1);return false;"
	align="right" /> <!--Bottom labels ends--> <%} %>
<div class="clear"></div>
<div class="division"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
<!--main content placeholder ends here-->

<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>