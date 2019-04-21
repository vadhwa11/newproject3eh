<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );

%>
<script type="text/javascript">

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
</script>
<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> detailsMap = new HashMap<String,Object>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	String deptName ="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	if(map.get("pageNo") != null)
	{
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
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
	int hinId=0;
	 if(resultList != null)
	   {
		 dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
		 if(dgResultEntryHeader.getHin() != null){
		 hinId =dgResultEntryHeader.getHin().getId();
		 }
	   }
		DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
		if(resultList != null){
		 dgresultHeader = (DgResultEntryHeader) resultList.get(0);
		}
%>
<!--main content placeholder starts here-->

<form name="sampleCollection" method="post" action="">
	<% if (deptType.equalsIgnoreCase("RADIO")){ %>
	<div class="titleBg">
		<h2>Report Delivery</h2>
	</div>
	<%}else{ %>
	<div class="titleBg">
		<h2>Report Collection</h2>
	</div>
	<%} %>
	<%
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
%>
	<%
}
 }%>
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="Block">
		<label class="common"> Department</label> <label class="value"
			name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label>
		<%-- <label
	class="common">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="value"><%=subDept%></label> --%>
		<input name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
			type="hidden" value="<%=SubChargeId %>" /> <input
			name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
			type="hidden" value="<%=mainChargeId %>" /> <label class="noWidth">Requisition
			No.</label>
		<%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
		<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label class="noWidth">Requisition Date</label>
		<%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
		<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<div class="clear"></div>
		<label class="noWidth">Requisition Time</label>
		<%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
		<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label class="noWidth">Order By</label>
		<%if(dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
		<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>

		<div class="clear"></div>
	</div>

	<input type="hidden" name="<%=RESULT_ID %>" id="<%= RESULT_ID%>"
		value="<%=dgresultHeader.getId() %>" />
	<div class="clear"></div>
	<!--Block Two Starts-->
	<input type="hidden" name="<%=HIN_ID %>" value="<%=hinId %>" />
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
			class="value"><%=hinNo%></label> <label>Patient Name</label> <label
			class="value"><%=patientName%></label> <label class="noWidth">Gender</label>
		<label class="value"><%=sex%></label>
		<div class="clear"></div>
		<label>Age</label> <label class="value"><%=currentAge%></label>
		<%-- <label>Marital
Status</label> <label class="value"><%=maritalStatus%></label> --%>

		<div class="clear"></div>
		<div>
			<%if(dgResultEntryHeader.getInpatient() != null){%>
			<input type="hidden" name="<%=INPATIENT_ID %>"
				value="<%=dgResultEntryHeader.getInpatient().getId()%>" />
			<%} %>
			<input type="hidden" name="<%=DEPARTMENT_ID %>"
				value="<%=dgResultEntryHeader.getDepartment().getId()%>" />
		</div>
	</div>
	<!--Block Two Ends-->
	<!-- Block Three Starts -->
	<h4>Report Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<label class="noWidth">&nbsp;&nbsp;Result Date</label>
		<%if(dgresultHeader.getResultDate() != null){ %>
		<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getResultDate()) %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label class="noWidth">Result Time</label> <label class="value"><%=dgresultHeader.getResultTime()%></label>
		<label class="noWidth">Result Prepared By</label>
		<%
			if (dgresultHeader.getEmployee() != null) {
				String pFName = "";
				String pMName = "";
				String pLName = "";
				if (dgresultHeader.getEmployee().getFirstName() != null) {
					pFName = dgresultHeader.getEmployee().getFirstName();
				}
				if (dgresultHeader.getEmployee().getMiddleName() != null) {
					pMName = dgresultHeader.getEmployee().getMiddleName();
				}
				if (dgresultHeader.getEmployee().getLastName() != null) {
					pLName = dgresultHeader.getEmployee().getLastName();
				}
		%>
		<label class="value"> <%=pFName+" "+pMName+" "+pLName %></label>
		<%}else { %>
		<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
			name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="value">
			-</label>
		<%} %>
		<input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"
			value="<%=date%>" /> <input type="hidden"
			name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" />

		<div class="clear"></div>
		<label class="noWidth">Result Validated Date</label> <label
			class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getVerifiedOn())%></label>

		<label class="noWidth">Result Validated Time</label>
		<%if(dgresultHeader.getVerifiedTime() != null){ %>
		<label class="value"><%=dgresultHeader.getVerifiedTime() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label class="noWidth">Result Validated By</label>
		<%if(dgresultHeader.getResultVerifiedBy() != null) { 
				String vFName = "";
				String vMName = "";
				String vLName = "";
				if (dgresultHeader.getResultVerifiedBy().getFirstName() != null) {
					vFName = dgresultHeader.getResultVerifiedBy().getFirstName();
				}
				if (dgresultHeader.getResultVerifiedBy().getMiddleName() != null) {
					vMName = dgresultHeader.getResultVerifiedBy().getMiddleName();
				}
				if (dgresultHeader.getResultVerifiedBy().getLastName() != null) {
					vLName = dgresultHeader.getResultVerifiedBy().getLastName();
				}
		%>
		<input type="hidden" id="<%=RESULT_VALIDATED_BY %>"
			name="<%=RESULT_VALIDATED_BY %>"
			value="<%=dgresultHeader.getEmployee().getFirstName() %>" /> <label
			class="value"> <%=vFName+" "+vMName+""+vLName %></label>
		<%}else { %>
		<input type="hidden" id="<%=RESULT_VALIDATED_BY %>"
			name="<%=RESULT_VALIDATED_BY %>" value="" /> <label class="value">-</label>
		<%} %>

		<div class="clear"></div>
		<label class="common">Brief Clinical Notes</label>
		<%if(dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
		<label class="valueFixedWidth"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %>
		</label>
		<%}else{ %>
		<label class="valueFixedWidth">-</label>
		<%} %>
		<div class="clear"></div>
		<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
			name="pageNo" id="pageNo" value="<%=pageNo%>" />
	</div>
	<!-- Block Three Ends -->
	<div class="clear"></div>
	<div class="paddingTop15"></div>

	<!-- Table Starts -->
	<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0"
		hidden="true">
		<tr>
			<th width="7%">Test Name</th>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<th width="7%">Sample</th>
			<%} %>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<th width="10%">UOM</th>
			<%} %>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<th width="10%">Normal Range</th>
			<%} %>
			<%  
    for(DgResultEntryDetail dgDetail :dgResultDtSet){
    %>

			<tr>
				<td width="7%">
					<%if(dgDetail.getInvestigation() !=null){ 
              %> <input name="<%=INVESTIGATION_ID %>" type="hidden"
					size="5" value="<%=dgDetail.getInvestigation().getId() %>" readonly />
					<input type="text" name="chargeCode"
					" value="<%=dgDetail.getInvestigation().getInvestigationName()%>" />

					<%}else { %> <input type="text" name="chargeCode" value="" /> <%} %>
				</td>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<td width="7%">
					<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
					id=<%=SAMPLE_ID %> type="hidden" size="5"
					value="<%=dgDetail.getSample().getId() %>" readonly /> <input
					type="text" name="sample" readonly="readonly"
					value="<%=dgDetail.getSample().getSampleDescription() %>" /> <%}else { %>
					<input type="text" name="sample" readonly="readonly" value="" /> <%} %>
				</td>
				<%} %>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>

				<td width="10%">
					<%if(dgDetail.getUom() !=null){ %> <input
					name="<%=UNIT_OF_MEASUREMENT_ID %>"
					id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
					value="<%=dgDetail.getUom().getId()%>" readonly /> <input
					type="text" name="<%=UNIT_OF_MEASUREMENT_ID %>" readonly="readonly"
					value="<%=dgDetail.getUom().getUomName() %>" /> <%}else { %> <input
					type="text" name="<%=UNIT_OF_MEASUREMENT_ID %>" readonly="readonly"
					value="-" /> <%} %>
				</td>
				<%} %>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<td width="10%">
					<%if(dgDetail.getInvestigation().getNormalValue() != null || dgDetail.getInvestigation().getMinNormalValue() != null || dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
					<%if(dgDetail.getInvestigation().getNormalValue() != null ){ 
				if(!dgDetail.getInvestigation().getNormalValue().equals("")){
			%> <input name="normalValue" type="text" size="8"
					value="<%=dgDetail.getInvestigation().getNormalValue()%>"
					readonly="readonly" /> <%}else if (dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
					<input name="normalValue" type="text" size="8"
					value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>"
					readonly="readonly" /> <%}
				} 
			else if(dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
					<input name="normalValue" type="text" size="8"
					value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>"
					readonly="readonly" "/> <%}}else{ %> <input name="normalValue"
					type="text" size="8" value="" readonly="readonly" /> <%} %>
				</td>
				<%} %>
			</tr>
	</table>
	<div class="clear"></div>
	<label class="common">Additional Remarks</label>
	<%if(dgDetail.getRemarks() != null){ %>
	<textarea value="<%=dgDetail.getRemarks() %>" class="large"
		name="<%=ADDITIONAL_REMARKS %>"></textarea>
	<script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDetail.getRemarks()%>
		"
	</script>
	<%
		}
	%>
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<%
		}
	%>
	<div class="Block">
		<label class="big"> <span>*</span> Received by
		</label>
		<%
			if (dgResultEntryHeader.getReceivedBy() != null) {
		%>
		<input type="text" name="<%=RECEIVED_FROM%>"
			value="<%=dgResultEntryHeader.getReceivedBy()%>"
			id="<%=RECEIVED_FROM%>" validate="Received By,string,yes"
			maxlength="50" tabindex=1 />
		<%
			} else {
		%>
		<input type="text" name="<%=RECEIVED_FROM%>" value=""
			id="<%=RECEIVED_FROM%>" validate="Received By,string,yes"
			maxlength="50" tabindex=1 />
		<%
			}
		%>
		<label class="medium"><span>*</span> Relation</label> <select
			id="relationId" name="<%=RELATION_ID%>"
			validate="Relation,string,yes" tabindex=1>
			<option value="">Select</option>
			<%
				for (MasRelation masRel : relationList) {
					if (dgResultEntryHeader.getRelation() != null
							&& dgResultEntryHeader.getRelation().getId()
									.equals(masRel.getId())) {
			%>
			<option value=<%=masRel.getId()%> selected="selected"><%=masRel.getRelationName()%></option>
			<%
				} else {
			%>
			<option value=<%=masRel.getId()%>><%=masRel.getRelationName()%></option>
			<%
				}
				}
			%>
		</select> <label class="big">Dispatched By</label> <select id="dispatchedBy"
			name="<%=DISPATCHED_BY%>" tabindex=1>
			<option value="0">Select</option>
			<%
				String firstName = "";
				String middleName = "";
				String lastName = "";
				String empName = "";
				for (MasEmployee masEmp : prescribedByList) {
					if (dgResultEntryHeader.getPrescribedBy() != null
							&& dgResultEntryHeader.getPrescribedBy().getId()
									.equals(masEmp.getId())) {
			%>
			<option value=<%=masEmp.getId()%> selected="selected"><%=empName%></option>
			<%
				} else {
			%>
			<option value=<%=masEmp.getId()%>><%=masEmp.getFirstName() + " "
							+ masEmp.getLastName()%></option>
			<%
				}
				}
			%>
		</select>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<!-- Table Ends -->

	<div class="division"></div>
	<div class="paddLeft25">
		<input type="button" class="button" value="Add"
			onclick="submitForm('sampleCollection','investigation?method=updateReceivedDetails');"
			align="right" />
	</div>
	<a href="/hms/hms/investigation?method=showReportCollectionJsp"> <input
		type="button" class="button" value="Back"
		investigation?method=showReportCollectionJsp " align="right" /></a>
	<div class="clear"></div>
	<div class="division"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=date%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>
	<!--Bottom labels starts-->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<!--main content placeholder ends here-->
