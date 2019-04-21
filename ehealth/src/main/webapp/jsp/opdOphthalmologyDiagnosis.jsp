<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.MasAnesthesia"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!--main content placeholder starts here-->



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
<form name="ophthalmologyDiagnosis" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>OPD Ophthalmology Diagnosis</h2>
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
		
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}	
		if(map.get("patientDataList") != null){
			patientDataList=(List<Visit>)map.get("patientDataList");
		}	
		if(detailsMap.get("frequencyList") != null){
			frequencyList=(List<MasFrequency>)detailsMap.get("frequencyList");
		}	
		if(detailsMap.get("anesthesiaList") != null){
			anesthesiaList=(List<MasAnesthesia>)detailsMap.get("anesthesiaList");
		}
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
<div class="Block"><label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label> <%}else{ %>
<label class="valueMedium">-</label> <%} %> <label>Patient Name </label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label class="medium">Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getAge() %></label> <%}else{ %>
<label class="valueMedium">-</label> <%} %> <label class="medium">Visit
Date </label> <%if(visitDateInString != null){ %> <label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>

<div class="clear"></div>

<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no")%></label> <%if(visit.getVisitNo()!= null){ %>
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
<div class="division"></div>

<!--Block Two Starts--> <input name="patient fast history3"
	type="button" class="button" value="Retinal"
	onclick="submitForm('ophthalmologyDiagnosis','/hms/hms/opd?method=showOphthalmologyRetinalJsp');" />
<input name="patient fast history" type="button" class="button"
	value="Follow Up"
	onclick="submitForm('ophthalmologyDiagnosis','/hms/hms/opd?method=showOphthalmologyFollowUpJsp');" />
<input name="patient fast history23" type="button" class="buttonBig"
	value="Ophthalmology"
	onclick="submitForm('ophthalmologyDiagnosis','opd?method=showOpdOphthamologyJsp');" />

<div class="clear"></div>
<div class="division"></div>


<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Diagnosis</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title1">

<div class="clear"></div>
<label>Ocular</label> <input name="<%=OCULAR %>" type="text" value=""
	maxlength="20"><label>Systemic</label> <input
	name="<%=SYSTEMIC %>" type="text" value="" maxlength="20">
<div class="clear"></div>
<label>Plan</label> <input name="<%=PLAN %>" type="text" value=""
	maxlength="20">
<div class="clear"></div></div>

<div class="division"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>Counselling</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2">

<div class="clear"></div>
<h4>Advice</h4>
<div class="clear"></div>
<label>Sr.No.</label> <label class="center">Medicine</label> <label
	class="center">UOM</label> <label class="center">Frequency</label> <label
	class="center">Eye</label>
<div class="clear"></div>
<%
	for(int i=1;i<=8;i++){
%> <label><%=i %>.</label> <input name="<%=MEDICINE %>" type="text"
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
</div>
<div class="clear"></div>
<div class="division"></div>


<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>Surgery</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">

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
</select> <label>Next Review Date</label> <input name="<%=NEXT_REVIEW_DATE %>"
	type="text" value="" maxlength="20">
<div class="clear"></div></div>



<!--Bottom labels starts-->
<div class="clear"></div>
<div class="division"></div>
<input name="Save" type="button" class="button" value="Submit"
	onclick="if(checkBlankForOphthalmology('ophthalmologyDiagnosis')){submitForm('ophthalmologyDiagnosis','opd?method=submitOphthalmologyDiagnosis');}"><input
	name="view" type="button" class="button" value="View"
	onclick="submitForm('ophthalmologyDiagnosis','opd?method=viewOphthalmologyDiagnosis&flag=prev');"><input
	name="reset" type="reset" class="buttonHighlight" value="Reset">
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"><input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"><input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"><input type="hidden"
	name="currentVisitId" value="<%=visit.getId() %>"> <!--Bottom labels ends--></form>

<!--main content placeholder ends here-->
<script type="text/javascript">


function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>