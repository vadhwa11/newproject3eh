<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
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

<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="patientHistory" method="post" action="">
<h2>Patient History</h26>
<div class="Clear"></div>
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
	List<OpdPatientHistory> patientHistoryList = new ArrayList<OpdPatientHistory>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
	}	
	if(map.get("patientHistoryList") != null){
		patientHistoryList=(List<OpdPatientHistory>)map.get("patientHistoryList");
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
	%> <!--Block One Starts-->

<h4>Service Personnel Details</h4>
<div class="Clear"></div>
<div class="Block">
<label class="class="auto">Service No. </label> 
<%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>HIN</label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="value"><%=visit.getHin().getHinNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Relation</label> <%if(visit.getHin().getRelation()!= null){ %>
<label class="value"><%=visit.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Patient Name. </label> <%if(patientName!= null){ %> <label
	class="value"><%=patientName %> </label> <%}else{ %> <label class="value">-
</label> <%} %> <label>Age</label> <%if(visit.getHin().getAge()!= null){ %> <label
	class="value"><%=visit.getHin().getAge() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Sex</label> <%if(visit.getHin().getSex()!= null){ %>
<label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Visit Date </label> <%if(visitDateInString != null){ %> <label
	class="value"><%=visitDateInString %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Visit No. </label> <%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Visit Time</label> <%if(visit.getVisitTime() != null){ %>
<label class="value"><%=visit.getVisitTime() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>

<div class="Clear"></div>
<label>Rank</label> <%if(visit.getHin().getRank()!= null){ %> <label
	class="value"><%=visit.getHin().getRank().getRankName() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Service Person Name </label>
<%if(visit.getHin().getServiceNo()!= null){ %> <label class="value"><%=visit.getHin().getSFirstName()%><%=visit.getHin().getSLastName()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Unit </label> <%if(visit.getHin().getUnit()!= null){ %>
<label class="value"><%=visit.getHin().getUnit().getUnitName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="Clear"></div>
<label>Service Type</label> <%if(visit.getHin().getServiceType()!= null){ %>
<label class="value"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Trade </label> <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
</div>
<div class="clear"></div>
<!--Block one Ends--> <%if(patientHistoryList.size() > 0){
    	
    	OpdPatientHistory patientHistory = new OpdPatientHistory();
    	patientHistory = patientHistoryList.get(0); %>
<div class="Clear"></div>
<label class="common"></label> <label class="common"></label> <label
	class="headings">Personal</label> <label class="fixed"></label> <label
	class="headings">Family</label>

<div class="division"></div>

<label class="common">Present History</label> <label class="common"></label>
<label class="valueLarge"> <%=patientHistory.getPersonalPresentHistory() %></label>
<label class="valueLarge"><%=patientHistory.getFamilyPresentHistory() %></label>

<div class="Clear"></div>

<label class="common">Past History</label> <label class="common"></label>
<label class="valueLarge"> <%=patientHistory.getPersonalPastHistory() %></label>
<label class="valueLarge"><%=patientHistory.getFamilyPastHistory() %></label>

<div class="Clear"></div>

<label class="common">Present Medication</label> <label class="common"></label>
<label class="valueLarge"><%=patientHistory.getPersonalPresentMedication() %></label>
<label class="valueLarge"><%=patientHistory.getFamilyPresentMedication() %></label>

<div class="Clear"></div>

<label class="common">Other Details</label> <label class="common"></label>
<label class="valueLarge"><%=patientHistory.getPersonalOtherDetails() %></label>
<label class="valueLarge"><%=patientHistory.getFamilyOtherDetails() %></label>

<div class="Clear"></div>
<div class="division"></div>

<!--Bottom labels starts-->
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label>

<div class="Clear"></div>
<input name="prev" type="button" class="button" value="Prev"
	onclick="submitForm('patientHistory','opd?method=viewPatientHistory&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('patientHistory','opd?method=viewPatientHistory&flag=next');">
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="history.go(-1);return false;" align="right" /></div>
<%}%>

</div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<%}else{%>
<h4> No Record Found!!</h4>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		