<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>

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

<%--For AutoComplete Through Ajax--%>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script type="text/javascript">

function patientVisitPre()
{
	var visitNo =document.getElementById('visitId').value;
	var visitIdM =document.getElementById('min').value;
	if(visitNo==visitIdM)
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
function testResult()
{
	var parent =document.getElementById('parent').value;
	//alert(parent);
//	submitProtoAjaxWithDivName('opdMain','/hms/hms/lab?method=viewAllTestForOrderNo&dgOrderHdId='+parent,'gridResult');
	//submitForm('opdMain','/hms/hms/investigation?method=printResultValidationLab&&parent='+parent);
	 var url="/hms/hms/investigation?method=printResultValidationLab&&parent="+parent;
	window.open(url,'name',"height=1250,width=950,status=1, scrollbars=1" );
}
</script>
<%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);

		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");

		}



	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String consultationDate = (String)utilMap.get("currentDate");
	String consultationTime = (String)utilMap.get("currentTime");

	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	int visitNoForJsp=0;
	if(map.get("visitNoForJsp") != null){
		visitNoForJsp=(Integer)map.get("visitNoForJsp");
	}
	 List patientDiagnosisList= new ArrayList();
	if(map.get("patientDiagnosisList") != null){
		patientDiagnosisList=(List)map.get("patientDiagnosisList");
	}

	 List opdPatientHistoryList= new ArrayList();
		if(map.get("opdPatientHistoryList") != null){
			opdPatientHistoryList=(List)map.get("opdPatientHistoryList");
		}

	List patientPrescDList= new ArrayList();
	if(map.get("patientPrescDList") != null){
		patientPrescDList=(List)map.get("patientPrescDList");
	}
	List patientInvesDList=new ArrayList();
	if(map.get("patientInvesDList") != null){
		patientInvesDList=(List)map.get("patientInvesDList");
	}
	List deptList= new ArrayList();
	if(map.get("deptList") != null){
		deptList=(List)map.get("deptList");
	}
	List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
	int dgOrderhd_id=0;
	String order_no="";
	if(map.get("dgOrderhdList") != null){
		dgOrderhdList=(List)map.get("dgOrderhdList");
	}
	for(DgOrderhd dgOrderhd:dgOrderhdList)
	{
		dgOrderhd_id = dgOrderhd.getId();
		order_no=dgOrderhd.getOrderNo();
	}

	 List<OpdPatientDetails> patientVisitDataList= new ArrayList<OpdPatientDetails>();
		if(map.get("patientVisitDataList") != null){
			patientVisitDataList=(List)map.get("patientVisitDataList");
		}

		OpdPatientDetails opdPatientDetails=new OpdPatientDetails ();

		if((patientVisitDataList.size()>0) && patientDiagnosisList.size()>0){
			  opdPatientDetails=(OpdPatientDetails)patientVisitDataList.get(0);

		 OpdPatientHistory opdPatientHistory=new  OpdPatientHistory ();
		if(opdPatientHistoryList!=null&&opdPatientHistoryList.size()>0)
			opdPatientHistory=(OpdPatientHistory)opdPatientHistoryList.get(0);

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

Visit visit=(Visit)opdPatientDetails.getVisit();

	String patientName="";
	String firstName="";
	String middleName="";
	String lastName="";


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
	int deptId=visit.getDepartment().getId();

	int max=0;
	if(map.get("max") != null){
		max = (Integer)map.get("max");
	}
	int min=0;
	if(map.get("min") != null){
		min = (Integer)map.get("min");
	}
%>
<!--main content placeholder starts here-->

<form name="opdMain" action="" method="post" target="_blank">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(visit.getDepartment()!= null){ %>

<div class="titleBg">
<h2><%=visit.getDepartment().getDepartmentName() %></h2>
</div>
<div class="clear"></div>
<%} %> <script type="text/javascript">
   var icdArray=new Array();
</script> <!--Block One Starts-->


<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="value"><%=visit.getHin().getHinNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Patient Name</label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label>Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label class="value"><%=visit.getHin().getAge() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>

<div class="clear"></div>

<label>Visit Date </label> <%if(visitDateInString != null){ %> <label
	class="value"><%=visitDateInString %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label><%=prop.getProperty("com.jkt.hms.opd_no") %>  </label> <%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block"><label>Referred To Department</label> <%
				String departmentName=null;
					 for(int i=0;i<deptList.size();i++)
					 {
						 departmentName=(String)deptList.get(i);
					 }
					if(departmentName!=null )
					{
					%>
					 <label class="valueAuto"><%=departmentName %></label>
					 <%}else{ %>
					  <label class="valueAuto">-</label>
<%}%>

<%
		if(visit.getHin().getRelation() != null){
			if(visit.getHin().getRelation().getRelationName().equalsIgnoreCase("self")){
	%> <label>No. of Days</label> <input name="days" type="text"
	class="readOnlySmall " readonly="readonly"  /> <select name="" size="0" class="small">
	<option>select</option>
	<option>ED</option>
	<option>MD</option>
	<option>LD</option>

</select> <%}} %>

<%
	String doctName = visit.getDoctor().getFirstName();
	if(visit.getDoctor().getMiddleName()!=null)
	{
		doctName = doctName+" "+visit.getDoctor().getMiddleName();
	}
	if(visit.getDoctor().getLastName()!=null)
	{
		doctName = doctName+" "+visit.getDoctor().getLastName();
	}
	%>
<label>Consulting Doctor</label> <label class="valueAuto"><%=doctName%></label>


<div class="clear"></div>
</div>


<div class="clear"></div>

<!--tab content starts-->

<ul id="countrytabsIn" class="shadetabsIn">
<label><a href="#" rel="country1"  class="selected">Complaints</a></label>
<label><a href="#" rel="country2">Investigation/Other Services</a></label>
<label><a href="#" rel="country3">Drugs</a></label>
<label><a href="#" rel="country4">Examination</a></label>
</ul>
<div class="clear"></div>
<div class="tabcontainerIn">
<div id="country1" class="tabcontentIn">
<div class="Block">
<label>Present Complaint</label>
<%if(opdPatientHistory.getPresentComplain()!=null && !opdPatientHistory.getPresentComplain().equals("")){ %>
<label class="valueFixedWidth">&nbsp;<%=opdPatientHistory.getPresentComplain()%></label>
<%} else{%>
<label class="valueFixedWidth">&nbsp;-</label>
<%} %>
<label>Present Illness</label>
<%if(opdPatientHistory.getPresentIllness()!=null && !opdPatientHistory.getPresentIllness().equals("") ){ %>
<label class="valueFixedWidth">&nbsp;<%=opdPatientHistory.getPresentIllness()%></label>
<%} else{%>
<label class="valueFixedWidth">&nbsp;-</label>
<%} %>
<label>Past History</label>
<%if(opdPatientHistory.getPersonalPastHistory()!=null && !opdPatientHistory.getPersonalPastHistory().equals("")){ %>
<label class="valueFixedWidth">&nbsp;<%=opdPatientHistory.getPersonalPastHistory()%></label>
<%} else{%>
<label class="valueFixedWidth">&nbsp;-</label>
<%} %>
<label>Personal History</label>
<%if(opdPatientHistory.getPersonalPresentHistory()!=null && !opdPatientHistory.getPersonalPresentHistory().equals("")){ %>
<label class="valueFixedWidth"><%=opdPatientHistory.getPersonalPresentHistory()%></label>
<%} else{%>
<label class="valueFixedWidth">&nbsp;-</label>
<%} %>
<div class="clear"></div>
<label>Family History</label>
<%if(opdPatientHistory.getFamilyPresentHistory()!=null && !opdPatientHistory.getFamilyPresentHistory().equals("")){ %>
<label class="valueFixedWidth">&nbsp;<%=opdPatientHistory.getFamilyPresentHistory()%></label>
<%} else{%>
<label class="valueFixedWidth">-</label>
<%} %>
<label class="auto">Past: <span class="smallAuto">Short Summary Description</span></label>
<textarea	name="previousDesc" cols="0" rows="0" readonly>
Description for previous visit : <%if(opdPatientDetails.getAfmsDesc()!= null){ %><%=opdPatientDetails.getAfmsDesc() %>
<%}else{ %>-<%} %>
</textarea>

<div class="clear"></div>

<label>Height</label> <%if(opdPatientDetails.getHeight()!= null){ %> <label
	class="value"><%=opdPatientDetails.getHeight() %> cm</label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Weight</label> <%if(opdPatientDetails.getWeight()!= null){ %>
<label class="value"><%=opdPatientDetails.getWeight() %> kg</label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Pulse</label> <%if(opdPatientDetails.getPulse()!= null){ %>
<label class="value"><%=opdPatientDetails.getPulse() %> min</label> <%}else{ %>
<label class="value">-</label> <%} %>
<div class="clear"></div>
<label>Temperature</label> <%if(opdPatientDetails.getTemperature()!= null){ %>
<label class="value"><%=opdPatientDetails.getTemperature() %>
&deg;F</label> <%}else{ %> <label class="value">-</label> <%} %> <label>BP</label> <%if(opdPatientDetails.getBp()!= null){ %>
<label class="value"><%=opdPatientDetails.getBp() %> mm/hg</label> <%}else{ %>
<label class="value">-</label> <%} %>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%-- <input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opdMain','opd?method=showOPDMainJsp&visitId=<%=visit.getId() %>');" align="right" />--%>
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="history.go(-2);return false;");" align="right" />
<input type="button" class="button" value="Next"	onclick="submitForm('opdMain','opd?method=viewPreviousNextVisit&flag=next&visitId=<%=visit.getId() %>','patientVisitNext');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="country2" class="tabcontentIn">
<div class="Block">
<div id="gridview" class="tableForTab">
<table border="0" id="investigationGrid" cellspacing="0" cellpadding="0">
	<tr>
		<th>Test Name</th>
		<th>Test Code</th>
		<th>Rate</th>
		<th>Clinical Notes</th>
	</tr>
	<%
		     Iterator  patientInvesDListItr=patientInvesDList.iterator();
			int counter=1;
		    while(patientInvesDListItr.hasNext())
		    {
		   		PatientInvestigationDetails patientInvestigationDetails=(PatientInvestigationDetails)patientInvesDListItr.next();

		    %>
	    <tr>
		<td><input type="text"
			value="<%=patientInvestigationDetails.getChargeCode().getChargeCodeName() %>"
			name="chargeName" size="65" /></td>

		<td id="chargeCodeVal"><input type="text"
			value="<%=patientInvestigationDetails.getChargeCode().getChargeCodeCode() %>"
			name="chargeCode" size="10" /></td>

		<td><input type="text" name="qty"
			value="<%=patientInvestigationDetails.getRate()%>" size="10" /></td>
		<td><input type="text" name="clinicalNotes"
			value="<%=patientInvestigationDetails.getClinicalNotes() %>"
			size="10" /></td>
	</tr>

	<%
		counter++;
} %>
</table>
<div class="clear"></div>
<div id="gridResult">

</div>
<div class="clear"></div>

<label>Plan</label> <%if(opdPatientDetails.getPlan()!= null){ %>
<label class="valueFixedWidth"><%=opdPatientDetails.getPlan() %></label>
<%}else{ %>
<label class="valueFixedWidth">-</label> <%} %>
<label>Next Visit Date</label> <%if(opdPatientDetails.getNextVisitDate()!= null){ %>
<label	class="valueFixedWidth"><%=HMSUtil.changeDateToddMMyyyy(opdPatientDetails.getNextVisitDate()) %></label>
<%}else{ %>
<label class="valueFixedWidth">-</label> <%} %>
<div class="clear"></div>
</div>


<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%-- <input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opdMain','opd?method=showOPDMainJsp&visitId=<%=visit.getId() %>');" align="right" />--%>
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="history.go(-2);return false;");" align="right" />
<input type="button" class="button" value="Next"	onclick="submitForm('opdMain','opd?method=viewPreviousNextVisit&flag=next&visitId=<%=visit.getId() %>','patientVisitNext');" />
<input	type="button" class="button" value="Prev"	onclick="submitForm('opdMain','opd?method=viewPreviousNextVisit&flag=prev&visitId=<%=visit.getId() %>','patientVisitPre');" />
<input type="button" name="openButton" value="View Investigation Result"	class="buttonBig2" onclick="testResult()" target="_blank"    />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


</div>
<div id="country3" class="tabcontentIn">
<div class="Block">
<div id="testDiv" class="tableForTab">
<table id="grid" border="0" cellspacing="0" cellpadding="0">
	<tr>

		<th scope="col">Generic Name</th>
		<!-- <th scope="col">Brand Name</th>
		<th scope="col">Manufacturer</th> -->
		<th scope="col">Dosage</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Total</th>
	</tr>
	<%
	    int i=0;
	    	Iterator patientPresListItr= patientPrescDList.iterator();
	    	while(patientPresListItr.hasNext())
	    	{
	    		PatientPrescriptionDetails patientPrescriptionDetails=(PatientPrescriptionDetails)patientPresListItr.next();
	    %>
	<tr>
		<td><input type="text" name="nomenclature<%=i %>"
			id="nomenclature<%=i %>"
			value="<%=patientPrescriptionDetails.getItem().getNomenclature() %>"
			readonly size="43" /></td>

		 <!--<td><input type="text"
			value="<patientPrescriptionDetails.getBrand().getBrandName()%>"
			name="pvmsNo<i %>" id="pvmsNo<i %>" readonly size="10" /></td>

		<td><input type="text"
			value="<patientPrescriptionDetails.getManufacturer().getManufacturerName()%>"
			name="manufacturer<i %>" id="manufacturer<i %>" readonly size="10" /></td> -->

		<td><input type="text"
			value="<%=patientPrescriptionDetails.getDosage() %>"
			name="dosage<%=i %>" id="dosage<%=i %>" readonly size="10" /></td>
		<td><input type="text"
			value="<%=patientPrescriptionDetails.getFrequency().getFrequencyName() %>"
			name="frequency<%=i %>" id="frequency<%=i %>" readonly size="10" />
		</td>
		<td><input type="text"
			value="<%=patientPrescriptionDetails.getNoOfDays() %>"
			name="noOfDays<%=i %>" id="noOfDays<%=i %>" readonly size="10" /></td>
		<td><input type="text"
			value="<%=patientPrescriptionDetails.getTotal() %>"
			name="total<%=i %>" id="total<%=i %>" readonly size="10" /></td>
		<input type="hidden" name="hdb" value="1" id="hdb" />
	</tr>
	<%
	   i++;	}
	  %>

</table>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%-- <input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opdMain','opd?method=showOPDMainJsp&visitId=<%=visit.getId() %>');" align="right" />--%>
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="history.go(-2);return false;");" align="right" />
<input type="button" class="button" value="Next"	onclick="submitForm('opdMain','opd?method=viewPreviousNextVisit&flag=next&visitId=<%=visit.getId() %>','patientVisitNext');" />
<input	type="button" class="button" value="Prev"	onclick="submitForm('opdMain','opd?method=viewPreviousNextVisit&flag=prev&visitId=<%=visit.getId() %>','patientVisitPre');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</div>

<div id="country4" class="tabcontentIn">
<div class="Block">
<label class="auto">On Examination :</label>
<%if(opdPatientDetails.getOnExamination()!=null){ %>
	<label class="valueFixedWidth"><%=opdPatientDetails.getOnExamination()%></label>
<%}else{ %>
<label class="auto">-</label>
<%} %>

<div class="clear"></div>
<label>Diagnosis </label> <%

	   Iterator itr=patientDiagnosisList.iterator();
	   while(itr.hasNext())
	   {
		   DischargeIcdCode dischargeIcdCode=(DischargeIcdCode)itr.next();
		  String icdName=dischargeIcdCode.getIcd().getIcdName();
	%> <label class="valueAuto" value="<%=icdName%>"><%=icdName%></label>
<% }%>
<div class="clear"></div>


</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%-- <input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opdMain','opd?method=showOPDMainJsp&visitId=<%=visit.getId() %>');" align="right" />--%>
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="history.go(-2);return false;");" align="right" />
<input	type="button" class="button" value="Prev"	onclick="submitForm('opdMain','opd?method=viewPreviousNextVisit&flag=prev&visitId=<%=visit.getId() %>','patientVisitPre');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<!--Bottom labels starts-->
<input id="parent" name="parent"	type="hidden" value="<%=order_no%>" />
<input id="visitId" name="visitId"	type="hidden" value="<%=visit.getId()%>" />
<input name="hinId" id="hinId" type="hidden" value="<%=visit.getHin().getId()%>" />
<input name="hinNo" id="hinNo"	type="hidden" value="<%=visit.getHin().getHinNo()%>" />
<input	name="deptId" type="hidden" value="<%=visit.getDepartment().getId()%>" />
<input id="visitNo" name="visitNo" type="hidden"	value="<%=visitNoForJsp%>" />
<input name="hospitalId" type="hidden"	value="<%=hospitalId%>" />
<input name="empId" type="hidden"	value="<%=visit.getDoctor().getId()%>" />
<input	name="consultationDate" type="hidden" value="<%=consultationDate%>" />
<input name="consultationTime" type="hidden" value="<%=consultationTime%>" />
<input type="hidden" id="max"	name="max" value="<%=max %>" />
<input type="hidden" id="min"	name="min" value="<%=min %>" />
<div class="clear"></div>
</div>

<script type="text/javascript">

var countries=new ddtabcontent("countrytabsIn")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()


function clearTestDivDown(flag,id,resultType,resultStatus,confidential,investigationId){
	document.getElementById('testDivDown').innerHTML = "";
	//alert("investigationId----->"+investigationId);
	
	if(investigationId==1081){
		window.open('lab?method=selectViewAccOrderStatusnew&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
		}else
	if(flag == 'rhLab'){
		window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
	}
	if(flag == 'rdRadio'){
		//window.showModalDialog('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','dialogHeight=120,dialogWidth=120','dialogLeft=100,dialogTop=160,dialogHeight=120,dialogWidth=120,,status=2,scrollbars=1,resizable=0,center=1');
		window.open('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
	}
	if(flag == 'rhSenLab'){
		window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=25,top=160,height=400,width=970,status=1,scrollbars=1,resizable=1');
		//submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'','testDivDown');
	}
	if(flag == 'rEntryDetailLab'){
		if(resultType == 's'){
			window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');
		}else{
			window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
		}
	}
}
</script>

<div class="arrowlistmenu">
<h3 class="menuheader expandable">OPD Management</h3>
<ul class="categoryitems">

	<li><a href="appointment?method=showAppointmentPatientJsp&hinId=<%=visit.getHin().getId()%>">Appointments</a></li>
	<li><a href="appointment?method=showAppointmentInvestigationJsp&hinId=<%=visit.getHin().getId()%>">Investigation Appt.</a></li>
	<li><a href="/hms/hms/opd?method=showPatientPreviousVisit&hinId=<%=visit.getHin().getId()%>&deptId=<%=visit.getDepartment().getId()%>&visitNo=<%=visit.getVisitNo() %>&visitId=<%=visit.getId()%>">Patient Previous Visit</a></li>
	<li><a
		href="/hms/hms/opd?method=viewPatientAllergicDrug&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Patient
	Allergic Drugs</a></li>
	<li><a href="registration?method=showVisitDetails&hinId=<%=visit.getHin().getId()%>">Admitted Patient</a></li>
	</ul>
	<%-- <li><a href="#">Print Prescription</a></li>
<li><a href="#">Print Investigation</a></li>
<li><a href="#">Print AFMSF- 7A</a></li>
<li><a href="opd?method=viewOpdTemplateDepartmentWisePreNext&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Opd Template Department Wise</a></li>

</ul>

<h3 class="menuheader expandable">opD Specification </h3>
<ul class="categoryitems">
<li><a href="/hms/hms/opd?method=viewPatientOphthalmologyDetails&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Ophthalmology</a></li>
<li><a href="opd?method=viewEnt&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">ENT</a></li>
<li><a href="opd?method=viewOBGONE&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">OBG</a></li>
<li><a href="opd?method=viewPediatricCaseSheet&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Prediatrics</a></li>
<li><a href="opd?method=viewOncosurgeryCaseSheet&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Onco Surgery Case Sheet</a></li>
<li><a href="opd?method=viewAntenatalCard&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Antenatal Card</a></li>
<li><a href="opd?method=viewCardiologyDepartmentDetails&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Cardiology</a></li>
<li><a href="opd?method=viewGastroEnterologyEndoscopy&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Gastro Enterology Endoscopy</a></li>
<li><a href="opd?method=viewGastroEnterologyColonoscopy&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Gastro Enterology Colonoscopy</a></li>
<li><a href="opd?method=viewOncosurgery&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Onco Surgery</a></li>
<li><a href="opd?method=viewOncosurgeryCaseSheet&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Onco Surgery Case Sheet</a></li>
<li><a href="opd?method=viewUrologyCaseSheet&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Urology Case Sheet </a></li>
<li><a href="opd?method=viewGynaecology&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&visitNoForJsp=<%=visitNoForJsp %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>">Labour Room   </a></li>
</ul>
--%>
</div>


<%}else{

	%>
<h4><span>No Record Found!</span></h4>
<div class="clear"></div>
<input name="Back" type="button" alt="Back" value="Back" class="button"
	onclick="history.go(-1);return false;" align="right" /> <%}%>
</form>

<!--main content placeholder ends here-->


<%
deptList.clear();
dgOrderhdList.clear();
opdPatientHistoryList.clear();
patientDiagnosisList.clear();
patientPrescDList.clear();
patientInvesDList.clear();
patientVisitDataList.clear();





%>