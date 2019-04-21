<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdCardiologyDepartmentDetails"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>
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
<form name="cardiologyDepartmentDetails" method="post" action="">
<div class="titleBg">
<h2>Cardiology</h2>
</div>
<div class="clear"></div>

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
	List<OpdCardiologyDepartmentDetails> cardiologyDepartmentDetailsList = new ArrayList<OpdCardiologyDepartmentDetails>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
	}	
	if(map.get("opdCardiologyDepartmentDetailsList") != null){
		cardiologyDepartmentDetailsList=(List<OpdCardiologyDepartmentDetails>)map.get("opdCardiologyDepartmentDetailsList");
	}	
	int currentVisitId=0;
	if(map.get("currentVisitId") != null){
		currentVisitId = (Integer)map.get("currentVisitId");
	}
	int max=0;
	if(map.get("max") != null){
		max = (Integer)map.get("max");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
if(cardiologyDepartmentDetailsList.size() > 0){
	
	OpdCardiologyDepartmentDetails cardiologyDepartmentDetails = new OpdCardiologyDepartmentDetails();
	cardiologyDepartmentDetails = cardiologyDepartmentDetailsList.get(0);
	
	
	Visit visit = new Visit();
	if(patientDataList.size()> 0){
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
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium">HIN</label> 
<%
if(visit.getHin().getHinNo()!= null)
{
	%>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label> 
<%
}
else
{
	%>
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
 <label class="medium">Visit Date </label> 
 <%if(visitDateInString != null){ %> 
 <label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>
<div class="clear"></div>
<label class="medium">Visit No. </label>
 <%if(visit.getVisitNo()!= null){ %>
<label class="valueMedium"><%=visit.getVisitNo() %></label> 
<%}else{ %>
 <label	class="valueMedium">-</label> <%} %> 
 <label>Token No. </label> 
 <%
 if(visit.getTokenNo()!= null){ 
 %>
<label class="value"><%=visit.getTokenNo() %></label> 
<%}else{ %> 
<label>-</label>
<%} %> 
<label class="medium">Prev. Diag </label> 
<%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
</div>
<!--Block one Ends-->
<div class="clear"></div>
<div class="division"></div>
<label>TMT Report</label> 
<label></label> 
<textarea	class="readOnlySmall" readonly="readonly"><%=cardiologyDepartmentDetails.getTmtReport() %></textarea>
<div class="clear"></div>
<label>Echo cardiology</label> <label></label> 
<textarea	class="readOnlySmall" readonly="readonly"><%=cardiologyDepartmentDetails.getEchoCardiology() %></textarea>
<div class="clear"></div>
<label>Holter</label> 
<label></label> 
<textarea class="readOnlySmall"	readonly="readonly"><%=cardiologyDepartmentDetails.getHolter() %></textarea>
<div class="clear"></div>
<label>Cardiac Cathetization Data</label> 
<label></label> 
<textarea	class="readOnlySmall" readonly="readonly"><%=cardiologyDepartmentDetails.getCardiacCathetizationData() %></textarea>
<div class="clear"></div>
<label>Remarks</label> 
<label></label> 
<textarea class="readOnlySmall"	readonly="readonly"><%=cardiologyDepartmentDetails.getRemarks() %></textarea>
<div class="clear"></div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="clear"></div>
<input name="prev" type="button" class="button" value="Prev"	onclick="submitForm('cardiologyDepartmentDetails','opd?method=viewCardiologyDepartmentDetails&flag=prev','patientVisitPrev');"/>
<input name="next" type="button" class="button" value="Next"	onclick="submitForm('cardiologyDepartmentDetails','opd?method=viewCardiologyDepartmentDetails&flag=next','patientVisitNext');"/>
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> 
<input name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button"	onclick="submitForm('cardiologyDepartmentDetails','opd?method=showCardiologyDepartmentDetailsJsp&visitId=<%=visit.getId() %>');" align="right" />
<div class="clear"></div>
<div class="division"></div>
<%}%> 
<input type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>"> 
<input type="hidden"	id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" id="max" name="max" value="<%=max %>"> 
<input	type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> 
<input type="hidden"	id="currentVisitId" name="currentVisitId" value="<%=currentVisitId %>">
<input type="hidden" id="visitId" value="<%=visit.getId() %>"> <%}else{%>
<h4>No Record Found!! </h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Back" type="button" alt="Back"	value="Back" class="button" onclick="history.go(-1);return false;"	align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <%} %>
<div class="bottom">
<label>Changed By:</label> 
<label class="value"><%=userName %></label>
<label>Changed Date:</label> 
<label class="value"><%=date%></label> 
<label>Changed Time</label> 
<label class="value"><%=time%></label>
</div>
<!--Bottom labels ends-->
<div class="paddingTop40">
<div class="paddingTop40">
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>