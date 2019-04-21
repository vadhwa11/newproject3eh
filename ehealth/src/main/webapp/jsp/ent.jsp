<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>

<script type="text/javascript">
	ddaccordion.init({
		headerclass: "expandable", //Shared CSS class name of headers group that are expandable
		contentclass: "categoryitems", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
</script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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

<script type="text/javascript">

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script>
<script>
<%

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}
		String buttonFlag="";
		 List patientDataList = new ArrayList();
			
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}			

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	if(map.get("buttonFlag") != null)
	{
	buttonFlag=(String)map.get("buttonFlag");

	}
	
	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();
	
	
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

<!--main content placeholder starts here-->

<form name="ent" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="hidden"
	name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />


<%if(visit.getDepartment()!= null){ %>
<div class="titleBg">
<h2>ENT</h2>
</div>
<div class="clear"></div>
<%} %> <!--Block One Starts-->

<div class="clear"></div>

<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
 <%
 if(visit.getHin().getHinNo()!= null){ 
 %>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label> 
<%}else{ %>
<label class="valueMedium">-</label> 
<%} %> 
<label>Patient Name </label> 
<%
if(patientName!= null){
	%>
<label class="value"><%=patientName %> </label> 
<%}else{ %> 
<label	class="value">- </label> 
	<%} %> 
<label class="medium">Age</label> 
<%
if(visit.getHin().getAge()!= null)
{ 
%>
<label class="valueMedium"><%=visit.getHin().getAge() %></label>
 <%}else{ %>
<label class="valueMedium">-</label>
 <%} %> 
 <label class="medium">Visit Date </label> 
 <%if(visitDateInString != null)
 { %> 
 <label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> 
<label class="valueMedium">-</label> <%} %>
<div class="clear"></div>
<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %> </label> 
<%
if(visit.getVisitNo()!= null)
{ %>
<label class="valueMedium"><%=visit.getVisitNo() %></label> 
<%}else{ %> 
<label
	class="valueMedium">-</label> 
	<%} %> 
	<label>Token No. </label> 
	<%
	if(visit.getTokenNo()!= null)
	{ %>
<label class="value"><%=visit.getTokenNo() %></label> 
<%}else{ %> 
<label>-</label>
<%} %> 
<label class="medium">Prev. Diag </label> 
<%
if(visit.getDiagnosis()!= null)
{ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> 
<label class="value">-</label>
 <%} %>
<div class="clear"></div>
</div>
<!--Block one Ends-->
<div class="clear"></div>
<div class="division"></div>
<!--Block two Start-->
<h4>Brief History</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Otorrhoea</label> 
<input name="<%=OTORRHOEA %>" type="text"	maxlength="20" /> 
<label>Hearing Loss</label> 
<input	name="<%=HEARING_LOSS %>" type="text" maxlength="20" /> <label>Otalgia</label>
<input name="<%=OTALGIA %>" type="text" maxlength="20" />
<div class="clear"></div>
<label>Sneezing</label> 
<input name="<%=SNEEZING %>" type="text"	maxlength="20" /> 
	<label>Nasal Obstructions</label> 
	<input	name="<%=NASAL_OBSTRUCTIONS %>" type="text" maxlength="20" /> 
	<label>Rhinorrhoea</label>
<input name="<%=RHINORRHOEA %>" type="text" maxlength="20" />
<div class="clear"></div>
<label>Epistaxis</label> 
<input name="<%=EPISTAXIS %>" type="text"	maxlength="20" /> 
<label>Facial Pain</label> 
<input	name="<%=FACIAL_PAIN %>" type="text" maxlength="20" /> 
<label>Dysphagia</label>
<input name="<%=DYSPHAGIA %>" type="text" maxlength="20" />
<div class="clear"></div>
<label>Odynophagia</label> 
<input name="<%=ODYNOPHAGIA %>" type="text"	maxlength="20" /> 
<label>Hoarseness</label> 
<input	name="<%=HOARSENESS %>" type="text" maxlength="20" /> 
<label>Others</label>
<input name="<%=OTHERS_ENT %>" type="text" maxlength="20" />
<div class="clear"></div>
</div>
<div class="division"></div>
<label>General Examination</label> 
<input type="text" value="Normal" name="<%=GENERAL_EXAMINATION %>" maxlength="50" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<h4>ENT Examination</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>EAR</h5>
</a>
<div class="Block" id="title1">
<div class="paddLeft55">
<label>RE</label> <label></label> 
<label>LE</label>
</div>
<div class="clear"></div>
<label>Pre &amp; Post Auricular Pinna</label>
 <label></label> 
 <input	type="text" class="calDate" name="<%=PRE_POST_RE %>" maxlength="20" />
<label></label> <input type="text" class="calDate"	name="<%=PRE_POST_LE %>" maxlength="20" />
<div class="clear"></div>
<div class="Height10"></div>
<label> EAC </label> <label>
</label> <input type="text" class="calDate"	name="<%=EAC_RE %>" maxlength="20" /> 
	<label></label> 
	<input	type="text" class="calDate" name="<%=EAC_LE %>" maxlength="20" />
<div class="clear"></div>
<label> TM </label> 
<label></label> 
<input type="text" class="calDate" name="<%=TM_RE %>" maxlength="20" /> 
<label></label> 
<input	type="text" class="calDate" name="<%=TM_LE %>" maxlength="20" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>TFT</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2"><label>Rinne's</label>
<div class="clear"></div>
<label>256</label> 
<label></label> 
<select	name="<%=TFT_RE_TWO_FIVE_SIX %>">
<option value="0">Select one</option>
<option value="+">+</option>
<option value="-">-</option>
</select> 
<label></label> 
<select name="<%=TFT_LE_TWO_FIVE_SIX %>">
<option value="0">Select one</option>
<option value="+">+</option>
<option value="-">-</option>
</select>
<div class="clear"></div>
<label>512</label> 
<label></label> 
<select	name="<%=TFT_RE_FIVE_ONE_TWO %>">
<option value="0">Select one</option>
<option value="+">+</option>
<option value="-">-</option>
</select> 
<label></label> 
<select name="<%=TFT_LE_FIVE_ONE_TWO %>">
<option value="0">Select one</option>
<option value="+">+</option>
<option value="-">-</option>
</select>
<div class="clear"></div>
<label>1024</label> 
<label></label> 
<select	name="<%=TFT_RE_TEN_TWO_FOUR %>">
<option value="0">Select one</option>
<option value="+">+</option>
<option value="-">-</option>
</select>
 <label></label> 
 <select name="<%=TFT_LE_TEN_TWO_FOUR %>">
<option value="0">Select one</option>
<option value="+">+</option>
<option value="-">-</option>
</select>
<div class="clear"></div>
<label>Weber's</label> 
<label></label> 
<select name="<%=TFT_RE_WEDER %>">
<option value="0">Select one</option>
<option value="+">+</option>
<option value="-">-</option>
</select> 
<label></label> 
<select name="<%=TFT_LE_WEDER %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select>
<div class="clear"></div>
<label>ABC</label> 
<label></label> 
<input type="text"	name="<%=ABC_RE %>" maxlength="20" /> 
	<label></label> 
	<input	type="text" name="<%=ABC_LE %>" maxlength="20" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>FFH</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">
<label>CV</label> <label></label> 
<input	type="text" class="calDate" name="<%=FFH_CV_RE %>" maxlength="4"validate="CV Re,num,no" /> 
<label class="small">cm</label> 
<label></label>
<input type="text" class="calDate" name="<%=FFH_CV_LE %>" maxlength="4"	validate="CV Le,num,no" /> 
<label class="small">cm</label>
<div class="clear"></div>
<label>FW</label> 
<label></label> 
<input type="text" class="calDate"	name="<%=FFH_FW_RE %>" maxlength="4" validate="FW Re,num,no" /> 
<label	class="small">cm</label> 
<label></label> 
<input type="text"	class="calDate" name="<%=FFH_FW_LE %>" maxlength="4"	validate="FW Le,num,no" /> 
<label class="small">cm</label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<a href="javascript:changeClass('title4','t4')">
<h5 id='t4'>PTA</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title4">
<label>AC</label> 
<label></label> 
<input	type="text" class="calDate" name="<%=PTA_AC_RE %>" maxlength="3" validate="AC RE,num,no" /> 
	<label class="small">db</label> 
	<label></label>
<input type="text" class="calDate" name="<%=PTA_AC_LE %>" maxlength="3" validate="AC Le,num,no" /> 
<label class="small">db</label>
<div class="clear"></div>
<label>BC</label> 
<label></label> 
<input type="text" class="calDate"	name="<%=PTA_BC_RE %>" maxlength="3" validate="BC Re,num,no" /> 
<label	class="small">db</label> 
<label></label> <input type="text" class="calDate" name="<%=PTA_BC_LE %>" maxlength="3" validate="BC Le,num,no" /> <label class="small">db</label>
<div class="clear"></div>
<label>AB Gap </label> 
<label></label> 
<input type="text" class="calDate" name="<%=PTA_AB_GAP_RE %>" maxlength="3" validate="AB Gap Re,num,no" /> 
<label class="small">db</label> 
<label></label>
<input type="text" class="calDate" name="<%=PTA_AB_GAP_LE %>" maxlength="3" validate="AB Gap Le,num,no" /> 
<label class="small">db</label>
<div class="clear"></div>
<label>Impedance Audiometry</label> 
<label></label> 
<input type="text"	name="<%=IMPLEDANCE_AUDIOMEETRY_RE %>" maxlength="20" /> <label	class="small">
</label> <label></label>
<input type="text"	name="<%=IMPLEDANCE_AUDIOMEETRY_LE %>" maxlength="20" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<a href="javascript:changeClass('title5','t5')">
<h5 id='t5'>Otoneurological Exams</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title5">
<div class="clear"></div>
<label>No Spontaneous/ Induced Nystagmus</label> 
<label></label>
 <input	type="text" name="<%=NO_SPONTSNEOUS_RE %>" maxlength="20" /> 
 <label></label>
<input type="text" name="<%=NO_SPONTSNEOUS_LE %>" maxlength="20" />
<div class="clear"></div>
<div class="Height10"></div>
<div class="clear"></div>
<label>Fistula Test </label> 
<label></label> <select
	name="<%=FISTULA_RE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <label></label> <select name="<%=FISTULA_LE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select>
<div class="clear"></div>
<label>Romberg's Test </label> <label></label> <select
	name="<%=ROMBERG_RE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select> <label></label> <select name="<%=ROMBERG_LE %>">
	<option value="0">Select one</option>
	<option value="+">+</option>
	<option value="-">-</option>
</select>
<div class="clear"></div>

<label>No Cerebellar</label> <label></label> <input
	name="<%=NO_CEREBELLAR %>" type="text" maxlength="100" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<a href="javascript:changeClass('title6','t6')">
<h5 id='t6'>Nose</h5>
</a>

<div class="Block" id="title6">
<div class="paddLeft55"><label>RE</label> <label></label> <label>LE</label>
</div>

<div class="clear"></div>
<label>External Nasal Framework</label><label></label> <select
	name="<%=EXTERNAL_NASAL_FRAMEWORK_RE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select> <label></label> <select name="<%=EXTERNAL_NASAL_FRAMEWORK_LE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select>
<div class="Height10"></div>
<div class="clear"></div>
<label>Ant Rhinoscopy </label> <label></label> <select
	name="<%=ANT_RHINOSCOPY_RE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select> <label></label> <select name="<%=ANT_RHINOSCOPY_LE %>">
	<option value="0">Select one</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select>



<div class="clear"></div>
<label>Post Rhinoscopy </label> <label></label> <input
	name="<%=POST_RHINOSCOPY_RE %>" type="text" maxlength="20" /> <label></label>
<input name="<%=POST_RHINOSCOPY_LE %>" type="text" maxlength="20" />
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title7','t7')">
<h5 id='t7'>Throat</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title7">
<label> Oral Cavity </label> 
<label></label>
<input name="<%=ORAL_CAVITY %>" type="text" value="Normal"	maxlength="20" />
<div class="clear"></div>
<label> OralPharynx </label> 
<label></label>
 <input	name="<%=ORAL_PHATYNX %>" type="text" value="Normal" maxlength="20" />
<div class="clear"></div>
<label> IDL </label> 
<label></label> 
<input name="<%=IDL %>" type="text"	value="Normal" maxlength="20" />
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title8','t8')">
<h5 id='t8'>Neck</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title8">
<div class="clear"></div>
<label> Neck </label> <label></label> <input name="<%=NECK %>" type="text" value="Normal" maxlength="20" />
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title9','t9')">
<h5 id='t9'>Diagnosis</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title9">
<div class="clear"></div>
<label> Surgery </label> 
<label></label> 
<input name="<%=SURGERY %>" type="text" value="Normal" maxlength="20" />
<div class="clear"></div>
<label> Post OP </label> 
<label></label> 
<input name="<%=POST_OP %>"	type="text" value="Normal" maxlength="20" />
<div class="clear"></div>
<label> Advice </label> 
<label></label> 
<textarea name="<%=ADVICE %>"	maxlength="40" onkeyup="return ismaxlength(this)" cols="" rows=""></textarea>
<div class="clear"></div>
</div>
</div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit"	onclick="submitForm('ent','opd?method=addEnt');" align="right" />
<input	type="button" class="button" value="View"	onclick="submitForm('ent','opd?method=viewEnt&flag=prev&viewScreen=no');" />
<input name="Back" type="button" src="images/phaseII/delete.gif"	alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" align="right" />
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName %></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>">
	<input type="hidden"	name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
	<input	type="hidden" name="<%=VISIT_NUMBER %>"	value="<%=visit.getVisitNo() %>">
	<input type="hidden"	name="currentVisitId" value="<%=visit.getId() %>"></form>
<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>