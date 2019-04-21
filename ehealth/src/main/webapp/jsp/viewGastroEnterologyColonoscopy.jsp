<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdGastroEnterologyColonoscopy"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


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
<!--main content placeholder starts here-->
<form name="gastroEnterologyColonoscopy" method="post" action="">
<div class="titleBg">
<h2>Gastro Enterology Colonoscopy</h2>
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
	List<OpdGastroEnterologyColonoscopy> gastroEnterologyColonoscopyList = new ArrayList<OpdGastroEnterologyColonoscopy>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
	}	
	if(map.get("opdGastroEnterologyColonoscopyList") != null){
		gastroEnterologyColonoscopyList=(List<OpdGastroEnterologyColonoscopy>)map.get("opdGastroEnterologyColonoscopyList");
	}	
	int currentVisitId=0;
	if(map.get("currentVisitId") != null){
		currentVisitId = (Integer)map.get("currentVisitId");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
if(gastroEnterologyColonoscopyList.size() > 0){
	
	OpdGastroEnterologyColonoscopy gastroEnterologyColonoscopy = new OpdGastroEnterologyColonoscopy();
	gastroEnterologyColonoscopy = gastroEnterologyColonoscopyList.get(0);
	
	
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
	 
	 String reportDateInString =HMSUtil.changeDateToddMMyyyy(gastroEnterologyColonoscopy.getReportDate());
	 
	 List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	 if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>) map.get("employeeList");
		}
	%> <!--Block One Starts-->
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium">HIN</label> 
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
 <label class="medium">Visit Date </label> 
 <%if(visitDateInString != null){ %>
  <label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>
<div class="clear"></div>
<label class="medium">Visit No. </label> <%if(visit.getVisitNo()!= null){ %>
<label class="valueMedium"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="valueMedium">-</label> <%} %> <label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> <%}else{ %> <label>-</label>
<%} %> <label class="medium">Prev. Diag </label> <%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<!--Block one Ends-->
<div class="Block"><label>Report No </label> <label class="value"><%=gastroEnterologyColonoscopy.getReportNo() %></label>
<label>Report Date</label> <label class="value"><%=reportDateInString %></label>
<div class="clear"></div>
<label>Refered By </label> <label class="value"><%=gastroEnterologyColonoscopy.getReferredBy().getFirstName() %><%=gastroEnterologyColonoscopy.getReferredBy().getMiddleName() %><%=gastroEnterologyColonoscopy.getReferredBy().getLastName() %></label>
<label>Diagnosis </label> <%if(visit.getDiagnosis()!= null){ %> <label
	class="value"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>

<label>AnalCanal</label> <%if(gastroEnterologyColonoscopy.getAnalCanal()==null){%>

<label class="value">-</label> <%} else{%> <label class="value"> <%=gastroEnterologyColonoscopy.getAnalCanal() %></label>
<%} %>

<div class="clear"></div>

<label>Rectum</label> <%if(gastroEnterologyColonoscopy.getRectum()==null){%>

<label class="value">-</label> <%} else{%> <label class="value"> <%=gastroEnterologyColonoscopy.getRectum() %></label>
<%} %>

<div class="clear"></div>

<label>Sigmoid</label> <%if(gastroEnterologyColonoscopy.getSigmoid()==null){%>

<label class="value">-</label> <%} else{%> <label class="value"><%=gastroEnterologyColonoscopy.getSigmoid() %></label>
<%} %>

<div class="clear"></div>

<label>Descending Colon</label> <%if(gastroEnterologyColonoscopy.getDescendingColon()==null){%>

<label class="value">-</label> <%} else{%> <label class="value"><%=gastroEnterologyColonoscopy.getDescendingColon() %></label>
<%} %>

<div class="clear"></div>

<label>Transverse Colon</label> <%if(gastroEnterologyColonoscopy.getTransverseColon()==null){%>

<label class="value">-</label> <%} else{%> <label class="value"><%=gastroEnterologyColonoscopy.getTransverseColon() %></label>
<%} %>


<div class="clear"></div>
<label>Cecum</label> <%if(gastroEnterologyColonoscopy.getCecum()==null){%>

<label class="value">-</label> <%} else{%> <label class="value"><%=gastroEnterologyColonoscopy.getCecum() %></label>
<%} %>

<div class="clear"></div>
<label>Biopsy</label> <%if(gastroEnterologyColonoscopy.getBiopsy()==null){%>

<label class="value">-</label> <%} else{%> <label class="value"><%=gastroEnterologyColonoscopy.getBiopsy() %></label>
<%} %>
<div class="clear"></div>

<label>Final diagnosis</label> <%if(gastroEnterologyColonoscopy.getFinalDiagnosis()==null){%>

<label class="value">-</label> <%} else{%> <label class="value"><%=gastroEnterologyColonoscopy.getFinalDiagnosis() %></label>
<%} %>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="clear"></div>
<input name="prev" type="button" class="button" value="Prev"
	onclick="submitForm('gastroEnterologyColonoscopy','opd?method=viewGastroEnterologyColonoscopy&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('gastroEnterologyColonoscopy','opd?method=viewGastroEnterologyColonoscopy&flag=next');">
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> 
<input name="Back" type="button" src="images/phaseII/delete.gif"	alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" align="right" />
<%}%>
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>"> 
<input type="hidden"	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> 
<input	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<%}else{%> 
<label class="value">
<h4>No Record Found!!</h4>
 </label>
<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label> 
<label class="value"><%=userName %></label>
<label>Changed Date:</label> 
<label class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label class="value"><%=time%></label>
<div class="clear"></div>
<div class="paddingTop40"></div>
<!--Bottom labels ends--> 
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>