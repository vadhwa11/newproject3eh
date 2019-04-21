<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOncosurgeryCaseSheet"%>


<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
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
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
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
<script type="text/javascript">

function patientVisitPrev()
{
	var visitNo =document.getElementById('visitNo').value;
	if(visitNo==1)
	{
		alert("Not Before Visit Number");
		return false;
	}
	return true;
}
function patientVisitNext()
{
	var visitId =document.getElementById('visitId').value;
	var visitIdM =document.getElementById('max').value;
	if(visitId==visitIdM)
	{
		alert("Not After Visit Number");
		return false;
	}
	return true;
	

}

</script>
<!--main content placeholder starts here-->
<div id="contentHolder">

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	List<Visit> patientDataList = new ArrayList<Visit>();
	List<OpdOncosurgeryCaseSheet> oncosurgeryCaseSheetList = new ArrayList<OpdOncosurgeryCaseSheet>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	int max=0;
	if(map.get("max") != null){
		max = (Integer)map.get("max");
	}
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
	}	
	if(map.get("oncosurgeryCaseSheetList") != null){
		oncosurgeryCaseSheetList=(List<OpdOncosurgeryCaseSheet>)map.get("oncosurgeryCaseSheetList");
	}	
	int currentVisitId=0;
	if(map.get("currentVisitId") != null){
		currentVisitId = (Integer)map.get("currentVisitId");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
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
</div>
<!--Block One Starts-->
<div class="clear"></div>
<form name="oncosurgeryCaseSheet" action="" method="post">
<h6>OPD Onco Surgery Case Sheet</h6>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
 <%if(visit.getHin().getHinNo()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label> 
<%}else{ %>
<label class="valueMedium">-</label>
 <%} %>
  <label>Patient Name </label>
   <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> 
<%}else{ %> 
<label	class="value">- </label> 
	<%} %> 
	<label class="medium">Age</label> 
	<%if(visit.getHin().getAge()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getAge() %></label> 
<%}else{ %>
<label class="valueMedium">-</label>
<%} %> 
<label class="medium">Visit Date </label> <%if(visitDateInString != null){ %> <label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>

<div class="clear"></div>

<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %></label> <%if(visit.getVisitNo()!= null){ %>
<label class="valueMedium"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="valueMedium">-</label> <%} %> <label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> <%}else{ %> <label>-</label>
<%} %> <label class="medium">Prev. Diag </label> <%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>
</div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
<!--Block one Ends--> <%
if(oncosurgeryCaseSheetList.size() > 0){
	
	OpdOncosurgeryCaseSheet oncosurgeryCaseSheet = new OpdOncosurgeryCaseSheet();
	oncosurgeryCaseSheet = oncosurgeryCaseSheetList.get(0);
%>
<div class="clear"></div>

<!--Block two Start-->

<div class="blockTitle"></div>
<div class="blockTitleCurve"></div>
<div class="clear"></div>



<div class="blockFrame">
<div class="clear"></div>

<label>City Scan</label> <%if(oncosurgeryCaseSheet.getCityScan() != ""){ %>
<label class="valueNoWidth"><%=oncosurgeryCaseSheet.getCityScan() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>
<div class="clear"></div>
<label>Others</label> <%if(oncosurgeryCaseSheet.getOthers() != ""){ %> <label
	class="valueNoWidth"><%=oncosurgeryCaseSheet.getOthers() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>
<div class="clear"></div>

<label>FancoNo</label> <%if(oncosurgeryCaseSheet.getFancNo() != ""){ %> <label
	class="valueNoWidth"><%=oncosurgeryCaseSheet.getFancNo() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %> <label>Biopsy No</label> <%if(oncosurgeryCaseSheet.getBiopsyNo() != ""){ %>
<label class="valueNoWidth"><%=oncosurgeryCaseSheet.getBiopsyNo() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>
<div class="clear"></div>

<label>Clinical Diagnosis</label> <%if(oncosurgeryCaseSheet.getClinicalDiagnosis() != ""){ %>
<label class="valueNoWidth"><%=oncosurgeryCaseSheet.getClinicalDiagnosis() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>
<div class="clear"></div>
</div>

<div class="blockTitle">Operation Finding</div>
<div class="blockTitleCurve"></div>
<div class="clear"></div>
<div class="blockFrame"><label>Tumour</label> <%if(oncosurgeryCaseSheet.getTumour() != ""){ %>
<label class="valueNoWidth"><%=oncosurgeryCaseSheet.getTumour() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>


<div class="clear"></div>

<label>Lx</label> <%if(oncosurgeryCaseSheet.getLx() != ""){ %> <label
	class="valueNoWidth"><%=oncosurgeryCaseSheet.getLx() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>


<div class="clear"></div>

<label>Mets</label> <%if(oncosurgeryCaseSheet.getMets() != ""){ %> <label
	class="valueNoWidth"><%=oncosurgeryCaseSheet.getMets() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>


<div class="clear"></div>

<label>Others</label> <%if(oncosurgeryCaseSheet.getOperationFindingsOthers() != ""){ %>
<label class="valueNoWidth"><%=oncosurgeryCaseSheet.getOperationFindingsOthers() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>


<div class="clear"></div>
</div>
<div class="blockTitle">Operation Date / Procedure</div>
<div class="blockTitleCurve"></div>
<div class="clear"></div>
<div class="blockFrame"><label class="valueNoWidth">Operation
Date / Procedure</label> <%if(oncosurgeryCaseSheet.getOperationDateProcedure() != ""){ %>
<label class="valueNoWidth"><%=oncosurgeryCaseSheet.getOperationDateProcedure() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>


<div class="clear"></div>

<label>HPE</label> <%if(oncosurgeryCaseSheet.getHpe() != ""){ %> <label
	class="valueNoWidth"><%=oncosurgeryCaseSheet.getHpe() %></label> <%}else{ %>
<label class="valueNoWidth">-</label> <%} %>
</div>
<div class="clear"></div>

<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>"> 
<input type="hidden"	name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />
<input type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>"	value="<%=visit.getVisitNo() %>"> 
<input type="hidden"	id="currentVisitId" name="currentVisitId" value="<%=currentVisitId %>">
<input type="hidden" id="max" name="max" value="<%=max %>"> 
<input	type="hidden" id="visitId" value="<%=visit.getId() %>"> 
<input name="prev" type="button" class="button" value="Prev"	onclick="submitForm('oncosurgeryCaseSheet','opd?method=viewOncosurgeryCaseSheet&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="button" value="Next"	onclick="submitForm('oncosurgeryCaseSheet','opd?method=viewOncosurgeryCaseSheet&flag=next','patientVisitNext');">
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> 
<input name="Back" type="button" src="images/phaseII/delete.gif"	alt="Back" value="Back" class="button"	onclick="submitForm('oncosurgeryCaseSheet','<%=url%>');" align="right" />

<%}%>
<%}else{%>
<label><span>No Record Found!!</span></label>
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>">
<input type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" id="currentVisitId" name="currentVisitId"	value="<%=currentVisitId %>"> 
<input type="hidden" id="visitId" value="<%=visit.getId() %>"> 
<input type="hidden" id="max"	name="max" value="<%=max %>"> 
<input name="prev" type="button" class="button" value="Prev" onclick="submitForm('oncosurgeryCaseSheet','opd?method=viewOncosurgeryCaseSheet&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="button" value="Next" onclick="submitForm('oncosurgeryCaseSheet','opd?method=viewOncosurgeryCaseSheet&flag=next','patientVisitNext');">
<input name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button"	onclick="submitForm('oncosurgeryCaseSheet','opd?method=showOncosurgeryCaseSheetJsp&visitId=<%=visit.getId() %>');" align="right" />
<div class="clear"></div>
<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>">
<input type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" id="currentVisitId" name="currentVisitId"	value="<%=currentVisitId %>"> 
<input type="hidden" id="visitId" value="<%=visit.getId() %>"> 
<input type="hidden" id="max"	name="max" value="<%=max %>"> 
<!--Bottom labels ends-->
<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By:</label> 
<label class="value"><%=userName%></label>
<label>Changed Date:</label>
<label class="value"><%=date%></label>
<label>Changed Time:</label> <label class="value"><%=time%></label> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div class="clear">
</div>
<div class="paddingTop40">
</div>
