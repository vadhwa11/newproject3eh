<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<script>
function inputValidate(){

	obj = document.getElementById('checkId');
	if(!obj.checked){;
  	alert("Please Validate The Result. ")
 	}else{
			return true;
		}
   }
function resetResult(){
	  document.getElementById('result').value="";
	   document.getElementById('additionalRemarks').value="";
	   
   }
</script>
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
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	String deptName ="";
	String deptType="";
	int hinId = 0;
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>) request.getAttribute("map");
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
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	try{
		if(map.get("resultList") != null){
			resultList=(List)map.get("resultList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
	DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
	Set<DgResultEntryDetail> dgResultDtSet = new HashSet<DgResultEntryDetail>();
	
	for(DgResultEntryHeader dgResultHeader : resultList){
		dgResultDtSet = dgResultHeader.getDgResultEntryDetails();
	}
	 if(resultList != null) {
		   dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
		   if(dgResultEntryHeader.getHin() !=null){
			hinId =dgResultEntryHeader.getHin().getId();
		   }
	}
	 if(resultList != null){
		 dgresultHeader = (DgResultEntryHeader) resultList.get(0);
	 }
	 session.setAttribute("dgResultEntryHeader",dgResultEntryHeader);
	 session.setAttribute("dgResultDtSet",dgResultDtSet);
	 
	 Properties properties = new Properties();
	 URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	 try {
	 	properties.load(resourcePath.openStream());
	 	} catch (Exception e) {
	 	e.printStackTrace();
	 }
	 String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
%>

<!--main content placeholder starts here-->

<form name="sampleCollection" method="post" action="">
<div class="titleBg">
<h2>Result Validation</h2>
</div>
<%
		String subDept = "";
		String dept="";
		int SubChargeId=0;
		int mainChargeId=0;
		for(DgResultEntryDetail dgDetail :dgResultDtSet){
			if(dgDetail.getInvestigation() != null){
			subDept = dgDetail.getInvestigation().getSubChargecode().getSubChargecodeName();
			dept = dgDetail.getInvestigation().getMainChargecode().getMainChargecodeName();
			SubChargeId=dgDetail.getInvestigation().getSubChargecode().getId();
			mainChargeId=dgDetail.getInvestigation().getMainChargecode().getId();
 	} 	}%>
<div class="clear"></div>
<div class="Block"><label class="common"> Department</label> <label
	class="value" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label> <label
	class="common">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="value"><%=subDept%></label> <input
	name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" /> <label class="NoWidth">Order
No.</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>

<label class="NoWidth">Order Date</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
Time</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="NoWidth">Order
By</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
</div>

<input type="hidden" name="<%=RESULT_ID %>" id="<%= RESULT_ID%>"
	value="<%=dgresultHeader.getId() %>" />
<div class="paddingTop15"></div>
<%
		
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
 %> <input type="hidden" name="<%=HIN_ID %>" value="<%=hinId %>" /> <!--Block Two Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>HIN</label> <label class="value"><%=hinNo%></label> <label>Patient
Name</label> <label class="value"><%=patientName%></label> <label
	class="noWidth">Sex</label> <label class="value"><%= sex%></label>
<div class="clear"></div>
<label>Age</label> <label class="value"><%=currentAge%></label> <label>Marital
Status</label> <label class="value"><%=maritalStatus%></label>
<div class="clear"></div>

</div>
<%if(dgResultEntryHeader.getInpatient() != null){%> <input type="hidden"
	name="<%=INPATIENT_ID %>"
	value="<%=dgResultEntryHeader.getInpatient().getId()%>" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgResultEntryHeader.getDepartment().getId()%>" /> <!--Block Two Ends-->
<div class="paddingTop15"></div>
<!-- Block Three Starts -->
<h4>Result Details</h4>
<div class="clear"></div>
<div class="Block"><label class="noWidth">&nbsp;&nbsp;Result
Date</label> <%if(dgresultHeader.getResultDate() != null){ %> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getResultDate()) %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="noWidth">Result
Time</label> <label class="value"><%=dgresultHeader.getResultTime() %></label> <label
	class="noWidth">Result Prepared By</label> <%if(dgresultHeader.getEmployee() != null) {%>
<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>"
	value="<%=dgresultHeader.getEmployee().getFirstName() %>" /> <label
	class="value"> <%=dgresultHeader.getEmployee().getFirstName()+" "+ dgresultHeader.getEmployee().getMiddleName()+" "+ dgresultHeader.getEmployee().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="value">
-</label> <%} %>


<div class="clear"></div>
<input type="hidden" name="<%=RESULT_NO %>"
	value="<%=dgResultEntryHeader.getResultNo() %>" /> <label
	class="noWidth">Result Validated Date</label> <label class="value"><%=date%></label>


<label class="noWidth">Result Validated Time</label> <label
	class="value"><%=time%></label> <label>Result Validated By</label> <select
	id="<%=RESULT_VALIDATED_BY %>" name="<%= RESULT_VALIDATED_BY %>"
	validate="Validated By,string,no" tabindex=1>
	<option value="">Select</option>
	<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
			for (MasEmployee masEmployeecode : employeeList) {
				if(masEmployeecode.getEmpCategory() != null){
					if( masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
				if (userId .equals(masEmployeecode.getId())) {
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}}	}}	%>
</select>
<div class="clear"></div>
<label>Brief Clinical Notes</label> <%if(dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueAuto"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueAuto">-</label> <%} %>
<div class="clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<div class="clear"></div>
<!-- Table Starts -->
<div class="clear"></div>
<div class="division"></div>
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">

	<tr>

		<th width="7%">Test Name</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="7%">Sample</th>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="10%">UOM</th>
		<%} %>
		<th width="10%">Result</th>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width="10%">Normal Range</th>
		<%} %>
		<th width="4%">Validated</th>

		<% for(DgResultEntryDetail dgDetail :dgResultDtSet){ %>

		<tr>
			<td width="7%">
			<%if(dgDetail.getInvestigation() !=null){ 
              
              %> <input name="resultType" type="hidden" size="10"
				value="<%=dgDetail.getResultType() %>" readonly class="readOnly" />
			<input name="<%=INVESTIGATION_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getInvestigation().getId() %>" readonly
				class="readOnly" /> <input type="text" class="readOnly"
				readonly="readonly" name="chargeCode"
				value="<%=dgDetail.getInvestigation().getInvestigationName()%>" />
			<%}else { %> <input type="text" class="readOnly" readonly="readonly"
				name="chargeCode" value="" /> <%} %>
			</td>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td width="7%">
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				type="text" class="readOnly" name="sample"
				value="<%=dgDetail.getSample().getSampleDescription() %>" /> <%}else { %>
			<input type="text" class="readOnly" name="sample" value="" /> <%} %>
			</td>
			<%} %>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td width="10%">
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				type="text" class="readOnly" name="<%=UNIT_OF_MEASUREMENT_ID %>"
				value="<%=dgDetail.getUom().getUomName() %>" /> <%}else { %> <input
				type="text" class="readOnly" name="<%=UNIT_OF_MEASUREMENT_ID %>"
				value="" /> <%} %>
			</td>
			<%} %>


			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
		
			/**third if **/		if(dgDetail.getInvestigation().getNormalValue() != null && !dgDetail.getInvestigation().getNormalValue().equals("")){
				try{
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getInvestigation().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" read /> <%}else {%> <input
				name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}} catch(Exception e){%> <input
				name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}}else if(dgDetail.getInvestigation().getMinNormalValue() != null && !dgDetail.getInvestigation().getMinNormalValue().equals("") || dgDetail.getInvestigation().getMaxNormalValue() != null && !dgDetail.getInvestigation().getMaxNormalValue().equals("")){
				try{
					
					if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getInvestigation().getMinNormalValue()) || Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
				%> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}%> <%} catch(Exception e){%> <input
				name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}} %> <!--  else of second if -->
			<%}	else{
				String [] minMax = dgDetail.getResult().split("-");
				try{
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getInvestigation().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getInvestigation().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }catch(Exception e){%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="<%=dgDetail.getResult() %>" /> <%}} %> <!--else of frst if  -->
			<% }else{%> <input name="<%=RESULT %>" id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td width="10%">
			<%if(dgDetail.getInvestigation().getNormalValue() != null || dgDetail.getInvestigation().getMinNormalValue() != null || dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getInvestigation().getNormalValue() != null ){ 
				if(!dgDetail.getInvestigation().getNormalValue().equals("")){
			%> <input name="normalValue" class="readOnly" type="text" size="8"
				value="<%=dgDetail.getInvestigation().getNormalValue()%>" readonly />
			<%}else if (dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
			<input name="normalValue" class="readOnly" type="text" size="8"
				value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>"
				readonly /> <%}
				} 
			else if(dgDetail.getInvestigation().getMinNormalValue()!= null && dgDetail.getInvestigation().getMaxNormalValue() != null){ %>
			<input name="normalValue" class="readOnly" type="text" size="8"
				value="<%=dgDetail.getInvestigation().getMinNormalValue()+" - "+dgDetail.getInvestigation().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalValue" class="readOnly"
				type="text" size="8" value="" /><label>-</label> <%} %>
			</td>
			<%} %>
			<td width="4%">
			<% if(dgDetail.getValidated() != null) {%> <input id="checkId"
				name="<%=VALIDATED %>" type="checkbox" checked="true" class="check" />
			<%}else{ %> <input id="checkId" name="<%=VALIDATED %>" type="checkbox"
				class="check" /> <%} %>
			</td>
		</tr>
</table>
<div class="clear"></div>

<label class="common">Additional Remarks</label> <%if(dgDetail.getRemarks() != null){
%> <textarea value="<%=dgDetail.getRemarks()%>" class="large"
	maxlength="200" id="<%=ADDITIONAL_REMARKS %>"
	name="<%=ADDITIONAL_REMARKS %>"></textarea> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDetail.getRemarks()%>"</script>
<%}else{ %> <textarea value="" maxlength="200" class="large"
	id="<%=ADDITIONAL_REMARKS %>" name="<%=ADDITIONAL_REMARKS %>"></textarea>
<%} %>
<div class="clear"></div>
<%}  %> <!-- Table Ends --> <input type="button" class="button"
	value="Submit"
	onclick="if(inputValidate()){submitForm('sampleCollection','investigation?method=submitResultValidationForSingleParameter')};"
	align="right" /> <input type="reset" name="Reset" value="Reset"
	class="buttonHighlight" onclick="resetResult();" />
<div class="clear"></div>
<!--Bottom labels starts-->
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="division"></div>

<div class="paddingTop40"></div>
<!--Bottom labels ends--> <!--Bottom labels starts-->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<!--main content placeholder ends here-->
