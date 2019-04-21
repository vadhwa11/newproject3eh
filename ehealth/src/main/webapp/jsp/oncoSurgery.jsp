<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/animatedcollapse.js"></script>

<%--For AutoComplete Through Ajax--%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
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
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
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
<form name="oncosurgery" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=visit.getDepartment().getId() %>" /> 
<%
if(visit.getDepartment()!= null){ 
%>
<div class="titleBg">
<h2>Onco Surgery</h2>
</div>
<div class="clear"></div>
<%} %> 
<!--Block One Starts-->
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<%
if(visit.getHin().getHinNo()!= null)
{
	%> 
	<label class="valueMedium"><%=visit.getHin().getHinNo() %></label>
<%
}else{
	%> 
	<label class="valueMedium">-</label> 
	<%} %> 
	<label>Patient Name </label> 
	<%if(patientName!= null){ 
	%> 
	<label class="value"><%=patientName %></label>
	 <%}else{ 
	 %> 
	 <label class="value">- </label> 
	 <%} %> 
	 <label class="medium">Age</label>
<%
if(visit.getHin().getAge()!= null){
	%>
	 <label class="valueMedium"><%=visit.getHin().getAge() %></label>
<%
}else{ 
%> <label class="valueMedium">-</label> 
<%} %> 
<label	class="medium">Visit Date </label>
 <%
 if(visitDateInString != null){
	 %> 
	 <label	class="valueMedium"><%=visitDateInString %></label> 
	 <%
	 }else{ 
	 %> 
	 <label	class="valueMedium">-</label> 
	 <%} %>
<div class="clear"></div>
<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %></label>
<%
if(visit.getVisitNo()!= null)
{ 
%> 
<label class="valueMedium"><%=visit.getVisitNo() %></label>
<%
}else{ 
%> 
<label class="valueMedium">-</label> 
<%} %> 
<label>Token No. </label> 
<%
if(visit.getTokenNo()!= null){ %> 
<label class="value"><%=visit.getTokenNo() %></label>
<%
}else{ %> 
<label>-</label> 
<%} %> 
<label class="medium">Prev. Diag </label> 
<%if(visit.getDiagnosis()!= null)
{ 
%> 
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> 
<label class="value">-</label> 
<%} %>
<div class="clear"></div>
</div>
<!--Block one Ends-->
<div class="clear"></div>
<h4>Stage</h4>
<!--Block two Start-->
<div class="Block">
<div class="clear"></div>
<label>T</label>
<div class="title"></div>
<label>1</label>
<input class="radioCheck" type="radio" value="1"	name="<%=STAGE_T %>">
	<label>2</label>
	<input class="radioCheck"	type="radio" value="2" name="<%=STAGE_T %>">
	<label>3</label>
	<input	class="radioCheck" type="radio" value="3" name="<%=STAGE_T %>">
	<label>4</label>
	<input	class="radioCheck" type="radio" value="4" name="<%=STAGE_T %>">
<div class="clear"></div>
<label>N</label>
<div class="title"></div>
<label>1</label>
<input class="radioCheck" type="radio" value="1"	name="<%=STAGE_N %>">
<label>2</label>
<input class="radioCheck"	type="radio" value="2" name="<%=STAGE_N %>">
	<label>3</label>
	<input	class="radioCheck" type="radio" value="3" name="<%=STAGE_N %>">
<div class="clear"></div>
<label>M</label>
<div class="title"></div>
<label>0</label>
<input class="radioCheck" type="radio" value="0"
	name="<%=STAGE_M %>">
	<label>1</label>
	<input class="radioCheck"	type="radio" value="1" name="<%=STAGE_M %>">
	<label>2</label>
	<input	class="radioCheck" type="radio" value="2" name="<%=STAGE_M %>">
<div class="clear"></div>
<label>NOR</label>
<div class="title"></div>
<label>I</label>
<input class="radioCheck" type="radio" value="1"	name="<%=STAGE_NOR%>">
	<label>II</label>
	<input	class="radioCheck" type="radio" value="2" name="<%=STAGE_NOR%>">
	<label>III</label>
	<input	class="radioCheck" type="radio" value="3" name="<%=STAGE_NOR%>">
	<label>IV</label>
	<input	class="radioCheck" type="radio" value="4" name="<%=STAGE_NOR%>">
<div class="clear"></div>
<label>A</label> 
<input type="text" name="<%=STAGE_A %>" maxlength="20">
<label>B</label>
<input type="text" name="<%=STAGE_B %>" maxlength="20">
<div class="clear"></div>
<label>Medical Oncology</label> 
<textarea id="b1" rows="" cols=""	maxlength="100" onkeyup="return ismaxlength(this)" class="large"	name="<%=MEDICAL %>"></textarea>
<div class="clear"></div>
<label>Surgery Oncology</label> 
<textarea id="b2" rows="" cols=""	maxlength="100" onkeyup="return ismaxlength(this)" class="large"	name="<%=SURGERY %>"></textarea>
<div class="clear"></div>
<label>RT</label> 
<textarea id="b3" rows="" cols="" maxlength="100"	onkeyup="return ismaxlength(this)" class="large" name="<%=RT%>"></textarea>
<div class="clear"></div>
<label>Remarks</label> 
<textarea id="b4" rows="" cols="" maxlength="100"	onkeyup="return ismaxlength(this)" class="large" name="<%=REMARKS %>"></textarea>
<div class="clear"></div></div>
<!--Block two Ends-->
<div class="clear"></div> 
<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>">
<input type="hidden"	name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input	type="hidden" name="<%=VISIT_NUMBER %>"	value="<%=visit.getVisitNo() %>">
<input type="hidden"	name="currentVisitId" value="<%=visit.getId() %>">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit"onclick="submitForm('oncosurgery','opd?method=addOncosurgery');" align="right" /> 
<input type="button" class="button" value="View"	onclick="submitForm('oncosurgery','opd?method=viewOncosurgery&flag=prev&viewScreen=no');" />
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName %></label>
<label>Changed Date</label> 
<label class="value"><%=date%></label> 
<label>Changed Time</label> 
<label class="value"><%=time%></label>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
</div>
</form>