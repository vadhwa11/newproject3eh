<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.OpdObg"%>

<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>
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
		
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		
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

<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>HORMONAL TESTS</h5>
</a>
<div class="Block" id="title1">
<div class="clear"></div>
<div class="paddLeft55"><label>Wife</label><label></label> <label>Husband</label>
</div>
<div class="clear"></div>
<label>T3 </label><label></label> <input name="<%=T_THREE_WIFE %>"
	value="<%=opdObg.getTThreeWife() %>" maxlength="20" type="text">
<label></label> <input name="<%=T_THREE_HUSBAND %>"
	value="<%=opdObg.getTThreeHusband() %>" maxlength="20" type="text">

<div class="clear"></div>

<label>T4 </label><label></label> <input name="<%=T_FOUR_WIFE %>"
	value="<%=opdObg.getTFourWife() %>" maxlength="20" type="text">
<label></label> <input name="<%=T_FOUR_HUSBAND %>"
	value="<%=opdObg.getTFourHusband() %>" maxlength="20" type="text">
<div class="clear"></div>

<label>TSH </label><label></label> <input name="<%=TSH_WIFE %>"
	value="<%=opdObg.getTshWife() %>" maxlength="20" type="text"> <label></label>
<input name="<%=TSH_HUSBAND %>" value="<%=opdObg.getTshHusband() %>"
	maxlength="20" type="text">
<div class="clear"></div>

<label>S Prolactin </label><label></label> <input
	name="<%=S_PROLACTIN_WIFE %>" value="<%=opdObg.getSProlactinWife() %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=S_PROLACTIN_HUSBAND %>"
	value="<%=opdObg.getSProlactinHusband() %>" maxlength="20" type="text">
<div class="clear"></div>

<label>FSH </label><label></label> <input name="<%=FSH_WIFE %>"
	value="<%=opdObg.getFshWife() %>" maxlength="20" type="text"> <label></label>
<input name="<%=FSH_HUSBAND %>" value="<%=opdObg.getFshHusband() %>"
	maxlength="20" type="text">
<div class="clear"></div>

<label>LH </label><label></label> <input name="<%=LH_WIFE %>"
	value="<%=opdObg.getLhWife() %>" maxlength="20" type="text"> <label></label>
<input name="<%=LH_HUSBAND %>" value="<%=opdObg.getLhHusband() %>"
	maxlength="20" type="text">
<div class="clear"></div>

<label>S Testosterone </label><label></label> <input
	name="<%=S_TESTOSTERONE_WIFE %>"
	value="<%=opdObg.getSTestosteroneWife() %>" maxlength="20" type="text">
<label></label> <input name="<%=S_TESTOSTERONE_HUSBAND %>"
	value="<%=opdObg.getSTestosteroneHusband() %>" maxlength="20"
	type="text">
<div class="clear"></div>

<label>DHES </label><label></label> <input name="<%=DHES_WIFE %>"
	value="<%=opdObg.getDhesWife() %>" maxlength="20" type="text">
<label></label> <input name="<%=DHES_HUSBAND %>"
	value="<%=opdObg.getDhesHusband() %>" maxlength="20" type="text">
<div class="clear"></div></div>
<!--Block one Ends--> <!--Block Two Starts-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>ULTRASONOGRAPHY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2">
<div class="clear"></div>
<label class="auto"><U>Test of Tubal Patency</U> </label>
<div class="clear"></div>
<h4>Hysterosalpingography</h4>
<div class="clear"></div>
<label>Uterus </label> <label></label> <input
	name="<%=UTERUS_HYSTEROSALIAGOGRAPHY %>"
	value="<%=opdObg.getUterusHysterosaliagography() %>" maxlength="20"
	type="text">

<div class="clear"></div>
<label>Tubes </label><label>R</label> <input name="<%=TUBES_RIGHT %>"
	value="<%=opdObg.getTubesRight() %>" maxlength="20" type="text">
<label>L</label> <input name="<%=TUBES_LEFT %>"
	value="<%=opdObg.getTubesLeft() %>" maxlength="20" type="text">

<div class="clear"></div>
<h4>Hysteroscopy</h4>
<div class="clear"></div>
<label>Endometrical Cavity </label> <label></label> <input
	name="<%=ENDOMETRICAL %>" value="<%=opdObg.getEndometricalCavity() %>"
	maxlength="20" type="text"> <label>Cornual Openings </label> <input
	name="<%=CORNUAL_OPENING %>" value="<%=opdObg.getCornualOpenings() %>"
	maxlength="20" type="text">


<div class="clear"></div>
<h4>Endoscopy</h4>
<div class="clear"></div>
<label>Uterus </label> <label></label> <input name="<%=UTERUS %>"
	value="<%=opdObg.getUterus() %>" maxlength="20" type="text"> <label>Pelvis
</label> <input name="<%=PELVIS_ENDOSCOPY_UTERUS %>"
	value="<%=opdObg.getPelvisEndosocopyUterus() %>" maxlength="20"
	type="text">
<div class="clear"></div>
<label>Tubes </label> <label>R</label> <input
	name="<%=TUBES_RIGHT_ENDOSCOPY %>" value="<%=opdObg.getTubesR() %>"
	maxlength="20" type="text"> <label>L</label> <input
	name="<%=TUBES_LEFT_ENDOSCOPY %>" value="<%=opdObg.getTubesL() %>"
	maxlength="20" type="text">

<div class="clear"></div>
<label>Ovaries </label> <label>R</label> <input
	name="<%=OVERIES_RIGHT_ENDOSCOPY %>" value="<%=opdObg.getOvariesR() %>"
	maxlength="20" type="text"> <label>L</label> <input
	name="<%=OVERIES_LEFT_ENDOSCOPY %>" value="<%=opdObg.getOvariesL() %>"
	maxlength="20" type="text">
<div class="clear"></div>
<label>Pelvis </label> <label></label> <input
	name="<%=PELVIS_ENDOSCOPY %>"
	value="<%=opdObg.getPelvisEndosocopy() %>" maxlength="20" type="text">
<div class="clear"></div>
<h4>Endometrical Biposy</h4>
<div class="clear"></div>

<label>Date</label> <label></label> <%if(opdObg.getObgDate()==null)
{%> <input type="text" id="startDateId" name="<%=DATE_OBG%>" value=""
	class="calDate" readonly="readonly" validate="DOB,date,no" tabindex="1" />
<a href="javascript:setdate('',document.OBG.<%=DATE_OBG%>)"><img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" tabindex="1" class="calender" /></a> <%}else{%> <input
	type="text" id="startDateId" name="<%=DATE_OBG%>"
	value="<%=HMSUtil.changeDateToddMMyyyy(opdObg.getObgDate()) %>"
	class="calDate" readonly="readonly" validate="DOB,date,no" tabindex="1" />
<a href="javascript:setdate('',document.OBG.<%=DATE_OBG%>)"><img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" tabindex="1" class="calender" /></a> <%} %> <label>Days
of Cycle</label> <input name="<%=DAYS_OF_CYCLE %>"
	value="<%=opdObg.getDaysOfCycle() %>" maxlength="9" type="text">


<div class="clear"></div>

<label>Proliferative</label> <label></label> <input
	name="<%=PROLIFERATIVE %>" value="<%=opdObg.getProliferative() %>"
	maxlength="20" type="text"> <label>Secretory</label> <input
	name="<%=SECRETORY %>" value="<%=opdObg.getSecretory() %>"
	maxlength="20" type="text" />

<div class="clear"></div>

<label>Dating</label> <label></label> <input name="<%=DATING %>"
	value="<%=opdObg.getDating() %>" maxlength="20" type="text" />

<div class="clear"></div></div>
<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">
<!--Block Three Ends-->
<div class="division"></div>
<div class="clear"></div>
<input name="prev" type="button" class="button" value="Prev"
	onclick="submitForm('viewObg','opd?method=viewOBGFOUR&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewObg','opd?method=viewOBGFOUR&flag=next');">
<input name="button" type="button" class="buttonActive" id="btn2"
	value="Page 4" /> <input name="Button" type="button" class="button"
	value="Back"
	onclick="submitForm('viewObg','opd?method=viewOBGTHREE&visitId=<%=currentVisitId %>');" />

<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <%}%>
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="paddingTop40"></div>

<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<%}else{%> <span>No Record Found!!</span> <input name="Back" type="button"
	src="images/phaseII/delete.gif" alt="Back" value="Back" class="button"
	onclick="history.go(-1);return false;" align="right" /> <%} %>
<div class="division"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

<!--main content placeholder ends here-->
<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>