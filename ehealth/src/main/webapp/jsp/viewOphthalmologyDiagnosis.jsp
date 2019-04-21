<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOphDiagnosisHeader"%>
<%@page import="jkt.hms.masters.business.OpdOphDiagnosisDetails"%>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<!--main content placeholder starts here-->
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
<form name="viewDiagnosis" method="post" action="">
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
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdOphDiagnosisHeader> ophDiagnosisList = new ArrayList<OpdOphDiagnosisHeader>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}	
		if(detailsMap.get("patientDataList") != null){
			patientDataList=(List<Visit>)detailsMap.get("patientDataList");
		}	
		if(map.get("ophDiagnosisList") != null){
			ophDiagnosisList=(List<OpdOphDiagnosisHeader>)map.get("ophDiagnosisList");
		}	
		int visitId = 0;
		int currentVisitId = 0;
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}
		if(map.get("currentVisitId") != null){
			currentVisitId = (Integer)map.get("currentVisitId");
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
%> <%

	if(ophDiagnosisList.size() >0){
		OpdOphDiagnosisHeader diagnosisHeader = ophDiagnosisList.get(0);
		Set<OpdOphDiagnosisDetails> detailsSet = diagnosisHeader.getOpdOphDiagnosisDetails();
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

<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %> </label> <%if(visit.getVisitNo()!= null){ %>
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

<!--Block Three Starts--> <a
	href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Diagnosis</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title1">

<div class="clear"></div>
<label>Ocular</label> <%
	if(diagnosisHeader.getOcular() != null){
%> <input name="<%=OCULAR %>" type="text" class="readOnly"
	value="<%= diagnosisHeader.getOcular()%>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=OCULAR %>"
	type="text" class="readOnly" value="" maxlength="20"
	readonly="readonly"> <%} %> <label>Systemic</label> <%
	if(diagnosisHeader.getSystemic() != null){
%> <input name="<%=SYSTEMIC %>" type="text" class="readOnly"
	value="<%=diagnosisHeader.getSystemic() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=SYSTEMIC %>"
	type="text" class="readOnly" value="" maxlength="20"
	readonly="readonly"> <%} %>
<div class="clear"></div>
<label>Plan</label> <%
	if(diagnosisHeader.getPlan1() != null){
%> <input name="<%=PLAN %>" type="text" class="readOnly"
	value="<%=diagnosisHeader.getPlan1() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=PLAN %>"
	type="text" class="readOnly" value="" maxlength="20"
	readonly="readonly"> <%} %>

<div class="clear"></div></div>

<div class="division"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>Counselling</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2">

<div class="clear"></div>
<h5>Advice</h5>
<div class="clear"></div>
<label>Sr.No.</label> <label class="center">Medicine</label> <label
	class="center">UOM</label> <label class="center">Frequency</label> <label
	class="center">Eye</label>
<div class="clear"></div>
<%
	int i = 1;
	String medicine = "";
	String uom = "";
	String eye = "";
	String frequency = "";
	for(OpdOphDiagnosisDetails detailsObj : detailsSet){
		medicine = detailsObj.getMedicine();
		uom = detailsObj.getDrugType();
		eye = detailsObj.getEye();
		if(detailsObj.getFrequency() != null){
			frequency = detailsObj.getFrequency().getFrequencyName();
		}
%> <label><%=i %>.</label> <input name="<%=MEDICINE %>" type="text"
	class="readOnly" value="<%=medicine %>" maxlength="20"
	readonly="readonly"> <input name="<%=UOM %>" type="text"
	class="readOnly" value="<%=uom %>" maxlength="20" readonly="readonly">
<input name="<%=FREQUENCY %>" type="text" class="readOnly"
	value="<%=eye %>" maxlength="20" readonly="readonly"> <input
	name="<%=MEDICINE %>" type="text" class="readOnly"
	value="<%=frequency %>" maxlength="20" readonly="readonly"> <% i++;
} %>
</div>
<div class="clear"></div>
<div class="division"></div>


<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>Surgery</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">

<div class="clear"></div>
<label>Right Eye</label> <%
	if(diagnosisHeader.getRightEyeSurgery() != null){
%> <input name="<%=RIGHT_EYE %>" type="text" class="readOnly"
	value="<%=diagnosisHeader.getRightEyeSurgery() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=RIGHT_EYE %>"
	type="text" class="readOnly" value="" maxlength="20"
	readonly="readonly"> <%} %> <label>Left Eye</label> <%
	if(diagnosisHeader.getLeftEyeSurgery() != null){
%> <input name="<%=LEFT_EYE%>" type="text" class="readOnly"
	value="<%=diagnosisHeader.getLeftEyeSurgery() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input name="<%=LEFT_EYE %>"
	type="text" class="readOnly" value="" maxlength="20"
	readonly="readonly"> <%} %>
<div class="clear"></div>
<label>Anesthesia Type</label> <%
	if(diagnosisHeader.getAnesthesia() != null){
%> <input name="<%=ANESTHESIA_ID%>" type="text" class="readOnly"
	value="<%=diagnosisHeader.getAnesthesia().getAnesthesiaName() %>"
	maxlength="20" readonly="readonly"> <%}else{ %> <input
	name="<%=ANESTHESIA_ID %>" type="text" class="readOnly" value=""
	maxlength="20" readonly="readonly"> <%} %> <label>Next
Review Date</label> <%
	if(diagnosisHeader.getNextReviewDate() != null){
%> <input name="<%=NEXT_REVIEW_DATE %>" type="text" class="readOnly"
	value="<%=diagnosisHeader.getNextReviewDate() %>" maxlength="20"
	readonly="readonly"> <%}else{ %> <input
	name="<%=NEXT_REVIEW_DATE %>" type="text" class="readOnly" value=""
	maxlength="20" readonly="readonly"> <%} %>
<div class="clear"></div></div>


<div class="division"></div>
<!--Bottom labels starts--> <input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('viewDiagnosis','opd?method=viewOphthalmologyDiagnosis&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewDiagnosis','opd?method=viewOphthalmologyDiagnosis&flag=next');">
<input name="back" type="button" class="button" value="Back"
	onclick="submitForm('viewDiagnosis','opd?method=showOphthalmologyDiagnosisJsp&visitId=<%=currentVisitId %>');">



<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=currentVisitId %>"> <!--Bottom labels ends-->
<%}else{ %> No Record Found!! <!--Bottom labels starts--> <input
	name="back" type="button" class="button" value="Back"
	onclick="submitForm('viewDiagnosis','opd?method=showOphthalmologyDiagnosisJsp&visitId=<%=currentVisitId %>');">


<!--Bottom labels ends--> <%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

<!--main content placeholder ends here-->
<script type="text/javascript">


function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>