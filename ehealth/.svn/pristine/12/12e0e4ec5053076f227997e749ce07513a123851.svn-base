<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>

<form name="sampleCollection" method="post" action=""><script
	type="text/javascript">

<%
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
</script> <%
    int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> detailsMap = new HashMap<String,Object>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	String deptName ="";
	String deptType="";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	if(map.get("relationList") != null){
		relationList=(List)map.get("relationList");
	}
	List<MasEmployee> prescribedByList = new ArrayList<MasEmployee>();
	if(map.get("prescribedByList") != null){
		prescribedByList=(List)map.get("prescribedByList");
	}
	
	try{
		if(map.get("resultList") != null){
			resultList=(List)map.get("resultList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	Set<DgResultEntryDetail> dgResultDtSet = new HashSet<DgResultEntryDetail>();
	for(DgResultEntryHeader dgResultHeader : resultList){
		dgResultDtSet = dgResultHeader.getDgResultEntryDetails();
	}
	 DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
	int hinId = 0;
	 if(resultList != null){
 		dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
		hinId =dgResultEntryHeader.getHin().getId();
	 }
		DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
		DgResultEntryDetail dgresultDetails=new DgResultEntryDetail();
		
	 if(resultList != null){
		 dgresultHeader = (DgResultEntryHeader) resultList.get(0);
	 }
%> <!--main content placeholder starts here--> <% if (deptType.equalsIgnoreCase("RADIO")){ %>
<div class="titleBg">
<h2>Report Delivery</h2>
</div>
<%}else{ %>
<div class="titleBg">
<h2>View Report</h2>
</div>
<%} %> <%
	String subDept = "";
	int SubChargeId=0;
	int mainChargeId=0;
	String dept="";
	String patientName = "";
	String age = "";
	String sex = "";
	String hinNo = "";
	String currentAge = "";
	String maritalStatus = "";
	Set<DgOrderdt> set = new HashSet<DgOrderdt>();
	for(DgResultEntryDetail dgResultEntryDetail :dgResultDtSet){
	set = dgResultEntryDetail.getSampleCollectionDetails().getSampleCollectionHeader().getOrder().getDgOrderdts();
	for(DgOrderdt orderDt : set){
	if(orderDt.getBill() != null){
		BlOpBillHeader  billHeader = orderDt.getBill();
		if(billHeader.getHin() != null ){
		patientName=billHeader.getHin().getPFirstName();
		age=billHeader.getHin().getAge();
		sex=billHeader.getHin().getSex().getAdministrativeSexName();
		hinNo=billHeader.getHin().getHinNo();
		hinId=billHeader.getHin().getId();
		currentAge = HMSUtil.calculateAgeForADT(age, dgresultHeader.getHin().getRegDate());
		if(billHeader.getHin().getMaritalStatus() != null){
		maritalStatus = billHeader.getHin().getMaritalStatus().getMaritalStatusName();
		}
		}else {
			patientName=billHeader.getPatientName();
			age=billHeader.getAge();
			sex=billHeader.getSex().getAdministrativeSexName();
			currentAge=billHeader.getAge();
			hinNo="--";
			maritalStatus="--";
		}
		}else{
			DgOrderhd  orderhd = orderDt.getOrderhd();
			if(orderhd.getHin() != null){
				patientName=orderhd.getHin().getPFirstName();
				age=orderhd.getHin().getAge();
				currentAge = HMSUtil.calculateAgeForADT(age, orderhd.getHin().getRegDate());
				if(orderhd.getHin().getMaritalStatus() != null){
				maritalStatus = orderhd.getHin().getMaritalStatus().getMaritalStatusName();
				}
				sex=orderhd.getHin().getSex().getAdministrativeSexName();
				hinNo=orderhd.getHin().getHinNo();
			}
		}
	}
	}
			for(DgResultEntryDetail dgDetail :dgResultDtSet){
				if(dgDetail.getInvestigation() != null){
				subDept = dgDetail.getInvestigation().getSubChargecode().getSubChargecodeName();
				dept=dgDetail.getInvestigation().getMainChargecode().getMainChargecodeName();
				SubChargeId=dgDetail.getInvestigation().getSubChargecode().getId();
				mainChargeId=dgDetail.getInvestigation().getMainChargecode().getId();
 	}
 	}%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="Block"><label class="common"> Department</label> <label
	class="value" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label> <label
	class="noWidth">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="value"><%=subDept%></label> <input
	name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" /> <label class="noWidth">Order
No.</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>

<label class="noWidth">Order Date</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="noWidth">Order
Time</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="noWidth">Order
By</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
</div>

<input type="hidden" name="<%=RESULT_ID %>" id="<%= RESULT_ID%>"
	value="<%=dgresultHeader.getId() %>" />
<div class="paddingTop15"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=hinId%>" /> <!--Block Two Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Reg No.</label> <label class="value"><%=hinNo%></label> <label>Patient
Name</label> <label class="value"><%=patientName%></label> <label
	class="noWidth">Sex</label> <label class="value"><%=sex%></label>
<div class="clear"></div>
<label>Age</label> <label class="value"><%=currentAge%></label> <label>Marital
Status</label> <label class="value"><%=maritalStatus%></label>

<div class="clear"></div>
<div>
<%if(dgResultEntryHeader.getInpatient() != null){%> <input type="hidden"
	name="<%=INPATIENT_ID %>"
	value="<%=dgResultEntryHeader.getInpatient().getId()%>" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgResultEntryHeader.getDepartment().getId()%>" /></div>
</div>
<!--Block Two Ends-->
<h4>Report Details</h4>
<div class="clear"></div>
<div class="Block"><label class="noWidth">&nbsp;&nbsp;Report
Date</label> <%if(dgresultHeader.getResultDate() != null){ %> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgResultEntryHeader.getResultDate()) %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="noWidth">Report
Time</label> <label class="value"><%=dgresultHeader.getResultTime()%></label> <label
	class="noWidth">Report Prepared By:</label> <%if(dgresultHeader.getEmployee() != null) {%>
<label class="value"> <%=dgresultHeader.getEmployee().getFirstName()+" "+ dgresultHeader.getEmployee().getMiddleName()+" "+ dgresultHeader.getEmployee().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="value">-</label>
<%} %> <input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"
	value="<%=date%>" /> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" />

<div class="clear"></div>
<label class="noWidth">&nbsp;&nbsp;Report Validated Date</label> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(dgResultEntryHeader.getVerifiedOn())  %></label>

<label class="noWidth">&nbsp;&nbsp;Report Validated Time</label> <%if(dgresultHeader.getVerifiedTime() != null){ %>
<label class="value"><%=dgresultHeader.getVerifiedTime() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Report Validated By</label> <%if(dgresultHeader.getEmployee() != null) {%>
<label class="value"> <%=dgresultHeader.getEmployee().getFirstName()+" "+ dgresultHeader.getEmployee().getMiddleName()+" "+ dgresultHeader.getEmployee().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=EMPLOYEE_ID %>"
	name="<%=EMPLOYEE_ID %>" value="" /> <label class="value"> -</label> <%} %>

<div class="clear"></div>
<label class="common">Brief Clinical Notes</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueAuto"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>

<div class="paddingTop15"></div>
<!-- Block Three Ends -->
<div class="clear"></div>
<!-- Table Starts -->
<div class="tableHolderAuto">
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">

	<tr>
		<th width="7%">Test Name</th>


		<% int i =0;
	    for(DgResultEntryDetail dgDetail :dgResultDtSet){
	    i++;
	    %>

		<tr>
			<td width="7%">
			<%if(dgDetail.getInvestigation() !=null){ %> <label
				name="<%=INVESTIGATION_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getInvestigation().getId() %>" readonly /> <label
				name="chargeCode" style="font-weight: bold;"><%=dgDetail.getInvestigation().getInvestigationName()%></label>
			<%}else { %> <label>-</label> <%} %>
			</td>

		</tr>
</table>
</div>


<div class="clear"></div>
<label>Additional Remarks</label> <%if(dgDetail.getRemarks() != null){ %>
<textarea class="large" value="<%=dgDetail.getRemarks() %>"
	maxlength="200" onkeyup="return ismaxlength(this)"
	name="<%=ADDITIONAL_REMARKS %>" readonly="readonly"></textarea> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDetail.getRemarks()%>"</script>
<%}else{ %> <textarea class="large" value="" maxlength="200"
	onkeyup="return ismaxlength(this)" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<%} %>
<div class="clear"></div>
<%}
	    	%> <!-- Table Ends --> <!--Bottom labels starts-->
<div class="division"></div>
<div class="clear"></div>
<div class="Block"><label><span>*</span>Received by</label> <%if(dgResultEntryHeader.getReceivedBy() != null){ %>
<input type="text" name="<%= RECEIVED_FROM%>"
	value="<%=dgResultEntryHeader.getReceivedBy() %>"
	id="<%= RECEIVED_FROM%>" validate="Received By,string,yes"
	maxlength="50" tabindex=1 /> <%}else{ %> <input type="text"
	name="<%= RECEIVED_FROM%>" value="" id="<%= RECEIVED_FROM%>"
	validate="Received By,string,yes" maxlength="50" tabindex=1 /> <%} %> <label><span>*</span>Relation</label>
<select id="relationId" name="<%=RELATION_ID %>"
	validate="Relation,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
	
	for (MasRelation masRel : relationList){
	if (dgResultEntryHeader.getRelation() != null && dgResultEntryHeader.getRelation().getId().equals(masRel.getId())) {
	%>
	<option value=<%=masRel.getId()%> selected="selected"><%=masRel.getRelationName()%></option>
	<%
	} else {
	%>
	<option value=<%=masRel.getId()%>><%=masRel.getRelationName()%></option>
	<%}}%>
</select> <label>Dispatched By</label> <select id="dispatchedBy"
	name="<%=DISPATCHED_BY %>" tabindex=1>
	<option value="0">Select</option>
	<%
		String firstName="";
		String middleName="";
		String lastName="";
		
		for (MasEmployee masEmp : prescribedByList){
		//if (dgResultEntryHeader.getPrescribedBy() != null && dgResultEntryHeader.getPrescribedBy().getId().equals(masEmp.getId())) {
	if(masEmp.getFirstName()!=null)
	{
		firstName=masEmp.getFirstName();
	}
	if(masEmp.getMiddleName()!=null)
	{
		middleName=masEmp.getMiddleName();
	}
	if(masEmp.getLastName()!=null)
	{
		lastName=masEmp.getLastName();
	}
	%>
	<option value=<%=masEmp.getId()%> selected="selected"><%=firstName+" "+middleName+" "+lastName%></option>
	
	<option value=<%=masEmp.getId()%>><%=firstName+" "+middleName+" "+lastName%></option>
	<%	 }	%>
</select>
<div class="clear"></div>

<div class="paddLeft25"><input type="button" class="button"
	value="Submit"
	onclick="submitForm('sampleCollection','investigation?method=updateReceivedDetails');"
	align="right" /></div>
<a href="/hms/hms/investigation?method=showReportCollectionJsp"><input
	type="button" class="button" value="Back"
	investigation?method=showReportCollectionJsp " align="right" /></a></div>

<div class="clear"></div>
<!-- Table Ends -->

<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="paddingTop40"></div>
<!--Bottom labels starts-->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
