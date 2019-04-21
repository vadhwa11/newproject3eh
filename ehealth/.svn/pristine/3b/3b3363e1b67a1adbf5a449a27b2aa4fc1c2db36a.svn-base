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
	
%> <!--Block One Starts-->

<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Past Medical History</h5>
</a>
<div class="Block" id="title1">
<div class="clear"></div>
<div class="paddLeft55"><label>Personal</label><label></label> <label>Family</label>
</div>

<div class="clear"></div>

<label>Diabetes Personal</label><label></label> <input
	name="<%=DIABETES_PERSONAL %>"
	value="<%=opdObg.getDiabetesPersonal() %>" maxlength="20" type="text">
<label></label> <input name="<%=DIABETES_FAMILY %>"
	value="<%=opdObg.getDiabetesFamily() %>" maxlength="20" type="text">

<div class="clear"></div>

<label>Hypertension</label><label></label> <input
	name="<%=HYPERTENSION_PERSONAL %>"
	value="<%=opdObg.getHypertensionPersonal() %>" maxlength="20"
	type="text"> <label></label> <input
	name="<%=HYPERTENSION_FAMILY %>"
	value="<%=opdObg.getHypertensionFamily() %>" maxlength="20" type="text">
<div class="clear"></div>

<label>Tuberculosis</label><label></label> <input
	name="<%=TUBERCULOSIS_PERSONAL %>"
	value="<%=opdObg.getTuberculosisPersonal() %>" maxlength="20"
	type="text"> <label></label> <input
	name="<%=TUBERCULOSIS_FAMILY %>"
	value="<%=opdObg.getTuberculosisFamily() %>" maxlength="20" type="text">
<div class="clear"></div>

<label> </label><label>Pulmonary</label> <input
	name="<%=PULMONARY_PERSONAL %>"
	value="<%=opdObg.getPulmonaryPersonal() %>" maxlength="20" type="text">
<label></label> <input name="<%=PULMONARY_FAMILY %>"
	value="<%=opdObg.getPulmonaryFamily() %>" maxlength="20" type="text">
<div class="clear"></div>

<label></label><label>Abdominal</label> <input
	name="<%=ABDOMINAL_PERSONAL %>"
	value="<%=opdObg.getAbdominalPersonal() %>" maxlength="20" type="text">
<label></label> <input name="<%=ABDOMINAL_FAMILY%>"
	value="<%=opdObg.getAbdominalFamily() %>" maxlength="20" type="text">
<div class="clear"></div>

<label>Thyroid <span></span></label><label></label> <input
	name="<%=THYROID_PERSONAL %>" value="<%=opdObg.getThyroidPersonal() %>"
	maxlength="20" type="text"> <label></label> <input
	name="<%=THYROID_FAMILY %>" value="<%=opdObg.getThyroidFamily() %>"
	maxlength="20" type="text">
<div class="clear"></div>

<label>Others <span></span></label><label></label> <input
	name="<%=OTHERS_PERSONAL %>" value="<%=opdObg.getOthersPersonal() %>"
	maxlength="25" type="text"> <label></label> <input
	name="<%=OTHERS_FAMILY %>" value="<%=opdObg.getOthersPersonal() %>"
	maxlength="25" type="text">
<div class="clear"></div></div>

<!--Block One Ends--> <!--Block Two Starts-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>OBSTETRIC HISTORY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2">
<div class="clear"></div>
<label>Normal Delivery</label> <input name="<%=NORMAL_DELIVERY %>"
	value="<%=opdObg.getNormalDelivery() %>" maxlength="20" type="text">
<label></label> <label>Ectopic</label> <input name="<%=ECTOPIC %>"
	value="<%=opdObg.getEctopic() %>" maxlength="20" type="text">

<div class="clear"></div>
<label class="auto">Premature Delivery Baby Alive/Dead Still
Births Fresh/Macerated</label> <input name="<%=PREMATURE_DELIVERY %>"
	value="<%=opdObg.getPrematureDeliveryBabyAliveDead() %>" maxlength="5"
	type="text" /> <label>Abortion</label> <input name="<%=ABORTION%>"
	value="<%=opdObg.getAAbortion() %>" maxlength="9" type="text">
<div class="clear"></div></div>

<!--Block Two Ends--> <!--Block Three Ends-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>SEXUAL HISTORY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">
<div class="clear"></div>
<label>Dyspareunia</label> <input name="<%= DYSPAREUNIA%>"
	value="<%=opdObg.getDyspareunia() %>" maxlength="20" type="text">
<div class="clear"></div>

<label>Awareness of Fertile Period</label> <input name="<%=AWARENESS %>"
	value="<%=opdObg.getAwarenessOfFertilePeriod() %>" maxlength="5"
	type="text">
<div class="clear"></div>
<label>Trying to conceive for</label> <input
	name="<%=TRYING_TO_CONCERIVE_FOR %>"
	value="<%=opdObg.getTryingToConceiveFor() %>" maxlength="5" type="text">
<div class="clear"></div>
<label>Frequency of IC</label> <input name="<%=FREQUENCY_OF_IC %>"
	value="<%=opdObg.getFrequencyOfIc() %>" maxlength="10" type="text"><label
	class="smallAuto">/week for last 6 months</label>

<div class="clear"></div></div>
<!--Block Three Ends--> <!--Block Four Ends-->

<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title4','t4')">
<h5 id='t4'>CLINICAL EXAMINATION</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title4">
<div class="clear"></div>
<h4>GENERAL EXAMINATION</h4>
<div class="clear"></div>
<label>General Apperance:</label> <label>Height:</label> <input
	name="<%=GENERNAL_APPERANCE_HEIGHT %>"
	value="<%=opdObg.getGeneralAppearanceHeight() %>" maxlength="9"
	type="text">
<div class="clear"></div>
<label></label> <label>Width:</label> <input
	name="<%= GENERNAL_APPERANCE_WIDTH%>"
	value="<%=opdObg.getGeneralAppearanceWeight() %>" maxlength="9"
	type="text">

<div class="clear"></div>
<label>Secondary Sexual Characters:</label> <label></label> <input
	name="<%=SECONDARY_SEXUAL_CHARACTERS %>"
	value="<%=opdObg.getSecondarySexualCharacters() %>" maxlength="20"
	type="text">

<div class="clear"></div>
<label>Neck Lymph Glands:</label> <label></label> <input
	name="<%=NECK_LYMPH_GLANDS %>"
	value="<%=opdObg.getNeckLymphGlands() %>" maxlength="20" type="text">

<div class="clear"></div>
<label>Thyroid:</label> <label></label> <input name="<%=THYROID %>"
	value="<%=opdObg.getThyroid() %>" maxlength="20" type="text">

<div class="clear"></div>
<label>C.V.S</label> <input name="<%=CVS %>"
	value="<%=opdObg.getCVS() %>" maxlength="20" type="text"> <label>B.P</label>
<input name="<%=B_P%>" value="<%=opdObg.getBP() %>" maxlength="6"
	type="text"> <label>Pulse</label> <input name="<%=PULSE %>"
	value="<%=opdObg.getPulse() %>" maxlength="9" type="text">

<div class="clear"></div>
<label>RS</label> <input name="<%=RS%>" value="<%=opdObg.getRs() %>"
	maxlength="20" type="text">

<div class="clear"></div>
<label>CNS</label> <input name="<%=CNS%>" value="<%=opdObg.getCns() %>"
	maxlength="20" type="text">

<div class="clear"></div></div>
<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">

<!--Block Five Ends-->


<div class="division"></div>
<div class="clear"></div>
<input name="prev" type="button" class="button" value="Prev"
	onclick="submitForm('viewObg','opd?method=viewOBGTWO&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewObg','opd?method=viewOBGTWO&flag=next');">
<input name="button" type="button" class="buttonActive" id="btn2"
	value="Page 2" /> <input name="Button" type="button" class="button"
	value="Page 3"
	onclick="submitForm('viewObg','opd?method=viewOBGTHREE&visitId=<%=currentVisitId %>');" />
<input name="Button" type="button" class="button" value="Back"
	onclick="submitForm('viewObg','opd?method=viewOBGONE&visitId=<%=currentVisitId %>');" />
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <%}%>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<%}else{%> <span>No Record Found!!</span> <input name="back" type="button"
	class="button" value="Back"
	onclick="submitForm('viewObg','opd?method=showOBGTWOJsp&visitId=<%=currentVisitId %>');">

<%} %>

<div class="division"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

<!--main content placeholder ends here-->

<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>