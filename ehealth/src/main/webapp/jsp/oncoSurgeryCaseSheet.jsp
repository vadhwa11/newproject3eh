<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
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
<script type="text/javascript">
function blankSpace()
{
var b1 = document.getElementById('b1').value ;
var b2 = document.getElementById('b2').value ;
var b3= document.getElementById('b3').value ;
var b4 = document.getElementById('b4').value ;
var b5= document.getElementById('b5').value ;
var b6 = document.getElementById('b6').value ;
var b7 = document.getElementById('b7').value ;
var b8 = document.getElementById('b8').value ;
var b9 = document.getElementById('b9').value ;
var b10 = document.getElementById('b10').value ;
var b11= document.getElementById('b11').value ;

if((b1=="")&&(b2=="")&&(b3=="")&&(b4=="")&&(b5=="")&&(b6=="")&&(b7=="")&&(b8=="")&&(b9=="")&&(b11=="")&&(b10==""))
{
	alert("Please give some fields.");
	return false;
}
else
{
	return true;
}
}
</script>

<!--main content placeholder starts here-->

<form name="oncosurgeryCaseSheet" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=visit.getDepartment().getId() %>" /> 
	<%
	if(visit.getDepartment()!= null){ 
	%>
<div class="titleBg">
<h2>Oncosurgery Case Sheet</h2>
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
if(visit.getHin().getHinNo()!= null)
{
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
<%}else{ 
%> 
<label
	class="value">- </label>
	 <%} %> 
	 <label class="medium">Age</label> 
	 <%
	 if(visit.getHin().getAge()!= null){ 
	 %>
<label class="valueMedium"><%=visit.getHin().getAge() %></label>
 <%}else{ %>
<label class="valueMedium">-</label> 
<%} %> 
<label class="medium">Visit Date </label> 
<%
if(visitDateInString != null){ %> 
<label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>
<div class="clear"></div>
<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %></label> 
<%if(visit.getVisitNo()!= null)
{ %>
<label class="valueMedium"><%=visit.getVisitNo() %></label> 
<%}else{ %> 
<label	class="valueMedium">-</label> 
<%} %> 
<label>Token No. </label> 
<%
if(visit.getTokenNo()!= null){
	%>
<label class="value"><%=visit.getTokenNo() %></label> 
<%}else{ %> 
<label>-</label>
<%} %>
 <label class="medium">Prev. Diag </label> 
 <%
 if(visit.getDiagnosis()!= null){
	 %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
</div>
<!--Block one Ends-->
<div class="division"></div>
<!--Block two Start-->
<div class="Block">
<div class="clear"></div>
<label class="large">City Scan</label> 
<textarea id="b1" rows="" cols=""	maxlength="500" onkeyup="return ismaxlength(this)"	name="<%=CITY_SCAN %>"></textarea> 
<label>Others</label> 
<textarea	id="b2" rows="" cols="" maxlength="500"	onkeyup="return ismaxlength(this)" name="<%=OTHERS %>"></textarea>
<div class="clear"></div>
<div class="clear"></div>
<label class="large">FancoNo</label>
 <input id="b3" name="<%=FANC_NO%>"	type="text" maxlength="15" /> 
	<label>Biopsy No</label> 
	<input id="b4"	name="<%=BIOSPSY_NO %>" type="text" maxlength="20" />
<div class="clear"></div>
<label class="large">Clinical Diagnosis</label> 
<textarea id="b5"	rows="" cols="" maxlength="200" onkeyup="return ismaxlength(this)"	name="<%=CLINICAL_DIAGNOSIS %>"></textarea>
<div class="clear"></div>
</div>

<h4>Operation Finding</h4>
<div class="Block">
<div class="clear"></div>
<label class="large">Tumour</label> 
<textarea id="b6" rows="" cols=""	maxlength="200" onkeyup="return ismaxlength(this)" name="<%=TUMOUR %>"></textarea>
<label>Lx</label> 
<textarea id="b7" rows="" cols="" maxlength="200"	onkeyup="return ismaxlength(this)" name="<%=LX %>"></textarea>
<div class="clear"></div>
<label class="large">Mets</label> <textarea id="b8" rows="" cols=""	maxlength="200" onkeyup="return ismaxlength(this)" name="<%=METS %>"></textarea>
<label>Others</label> 
<textarea id="b9" rows="" cols="" maxlength="200"	onkeyup="return ismaxlength(this)"	name="<%=OPERATION_FINDINGS_OTHERS %>"></textarea>
<div class="clear"></div>
</div>
<h4>Operation Date / Procedure</h4>
<div class="Block">
<div class="clear"></div>
<label class="large">Operation Date / Procedure</label>
 <textarea	id="b10" rows="" cols="" maxlength="2000"	onkeyup="return ismaxlength(this)"	name="<%=OPERATION_DATE_PROCEDURE %>"></textarea> 
 <label>HPE</label> 
 <textarea	id="b11" rows="" cols="" maxlength="500"	onkeyup="return ismaxlength(this)" name="<%=HPE %>"></textarea>
<div class="clear"></div>
</div>
<!--Block two Ends-->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit"	onclick="submitForm('oncosurgeryCaseSheet','opd?method=addOncosurgeryCaseSheet','blankSpace');"	align="right" /> 
<input type="button" class="button" value="View"	onclick="submitForm('oncosurgeryCaseSheet','opd?method=viewOncosurgeryCaseSheet&flag=prev&viewScreen=no');" />
<input name="Back" type="button" src="images/phaseII/delete.gif"	alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="Height10"></div>
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

<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>">
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input	type="hidden" name="<%=VISIT_NUMBER %>"	value="<%=visit.getVisitNo() %>">
<input type="hidden" name="currentVisitId" value="<%=visit.getId() %>">
</form>