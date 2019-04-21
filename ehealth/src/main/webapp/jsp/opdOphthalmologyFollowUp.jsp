<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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

<form name="ophthalmologyFollowUp" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Ophthalmology Follow Up</h2>
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
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}	
		if(map.get("patientDataList") != null){
			patientDataList=(List<Visit>)map.get("patientDataList");
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
%> <!--Block One Starts-->

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


<!--Block Three Starts--> <input name="patient fast history3"
	type="button" class="buttonBig" value="Ophthalmology"
	onclick="submitForm('ophthalmologyFollowUp','opd?method=showOpdOphthamologyJsp');"><input
	name="patient fast history" type="button" class="button"
	value="Retinal"
	onclick="submitForm('ophthalmologyFollowUp','/hms/hms/opd?method=showOphthalmologyRetinalJsp');"><input
	name="patient fast history23" type="button" class="button"
	value="Diagnosis"
	onclick="submitForm('ophthalmologyFollowUp','opd?method=showOphthalmologyDiagnosisJsp');">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>System Functional Assesment</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title1">


<div class="clear"></div>
<h4>Vision</h4>
<div class="clear"></div>
<label>Ant Segment</label> <label class="valueNoWidth">RE</label> <input
	name="<%=ANT_SEGMENT_RE %>" type="text" value="" maxlength="20"><label
	class="valueNoWidth">LE</label> <input name="<%=ANT_SEGMENT_LE%>"
	type="text" value="" size="10" maxlength="20">
<div class="clear"></div>
<label>IOP</label> <label class="valueNoWidth">&nbsp;&nbsp;&nbsp;&nbsp;</label>
<input name="<%=IOP%>" type="text" value="" size="10" maxlength="20">
<div class="clear"></div>
<h4>Fundus</h4>
<div class="clear"></div>
<label>RE</label> <input name="<%=FUNDUS_RE %>" type="text" value=""
	size="10" maxlength="20"><label>LE</label> <input
	name="<%=FUNDUS_LE%>" type="text" value="" size="10" maxlength="20"><label>Adv</label>
<input name="<%=ADV%>" type="text" value="" size="10" maxlength="20">
<div class="clear"></div></div>

<!--Bottom labels starts-->
<div class="clear"></div>
<div class="division"></div>
<input name="Save" type="button" class="button" value="Submit"
	onclick="if(checkBlankForOphthalmology('ophthalmologyFollowUp')){submitForm('ophthalmologyFollowUp','opd?method=submitOphthalmologyFollowUp');}" />
<input name="view" type="button" class="button" value="View"
	onclick="submitForm('ophthalmologyFollowUp','opd?method=viewOphthalmologyFollowUp&flag=prev');" />
<input name="reset" type="reset" class="buttonHighlight" value="Reset" />
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"><input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"><input
	type="hidden" name="currentVisitId" value="<%=visit.getId() %>"><input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <!--Bottom labels ends--></form>

<!--main content placeholder ends here-->

<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>