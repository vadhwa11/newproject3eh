<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>

<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgFixedValue"%>
<%@page import="java.net.URL"%>

<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>

<form name="sampleCollection" method="post" action=""><script>
function inputValue(){
		for(var i = 0; i < document.getElementsByName('validated').length; i++){
			if(document.getElementsByName('validated')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please Validate The Result.")
		return false;
	}
function CheckAll(chk)
{
for (var i=0;i < document.sampleCollection.elements.length;i++)
	{
		var e = document.sampleCollection.elements[i];
		
		if (e.type == "checkbox")
		{
			e.checked = chk.checked;
		}
	}
}
</script> <script type="text/javascript">
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
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List inPatientDetailList = new ArrayList();
	Box box = HMSUtil.getBox(request);
	String userName = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
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
	
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	String deptName ="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
	if(map.get("dgResultdetailList") != null){
		dgResultdetailList = (List<DgResultEntryDetail>)map.get("dgResultdetailList");
	}
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	Map detailsMap = new HashMap();
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	
	List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
	try{
		if(map.get("fixedValList") != null){
			fixedValList=(List)map.get("fixedValList");
		}
		}catch(Exception e){
		e.printStackTrace();
		}
	Set<DgResultEntryDetail> dgResultDtSet = new TreeSet<DgResultEntryDetail>();
	for(DgResultEntryHeader dgResultHeader : resultList){
		dgResultDtSet = dgResultHeader.getDgResultEntryDetails();
	}
	int hospitalId = 0;
	MasRelation masRelation = new MasRelation();
	 DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
	MasRank masRank = new MasRank();
	int departmentId =0;
	int inpatientId =0;
	int hinId = 0;
	try{
		if(map.get("resultList") != null){
			resultList=(List)map.get("resultList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	String number="";int resultId=0;
	 if(resultList != null && resultList.size()>0)
	   {
			   dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
			   if(dgResultEntryHeader.getHin() !=null){
				hinId =dgResultEntryHeader.getHin().getId();
		}
		}
	 DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
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
%> <!-- main content placeholder starts here -->

<div class="titleBg">
<h2>Result Validation</h2>
</div>
<%
String subDept = "";
String dept="";
int SubChargeId=0;
int mainChargeId=0;

		for(DgResultEntryDetail dgDetail :dgResultDtSet){
			if(dgDetail.getInvestigation()!= null){
			subDept = dgDetail.getInvestigation().getSubChargecode().getSubChargecodeName();
			dept=dgDetail.getInvestigation().getMainChargecode().getMainChargecodeName();
			SubChargeId=dgDetail.getInvestigation().getSubChargecode().getId();
			mainChargeId=dgDetail.getInvestigation().getMainChargecode().getId();
			 }
 	}%>
<div class="clear"></div>
<div class="Block"><label class="common"> Department</label> <label
	class="value" name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label> <label
	class="common">Sub Department</label> <label
	name="<%=SUB_CHARGECODE_NAME %>" class="value"><%=subDept%> </label> <input
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
<input type="hidden" name="<%=RESULT_ID %>" id="<%= RESULT_ID%>"
	value="<%=dgResultEntryHeader.getId() %>" /></div>
<div class="clear"></div>
<div class="paddingTop15"></div>

<!--Block Two Starts--> <%
		
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
		currentAge = HMSUtil.calculateAgeForADT(age, dgResultEntryHeader.getHin().getRegDate());
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
 %> <input type="hidden" name="<%=HIN_ID %>" value="<%=hinId%>" /> <!--Block Two Starts-->
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
<div class="clear"></div>
<!-- Block Three Starts -->
<h4>Report Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label class="noWidth">&nbsp;&nbsp;Result Date:</label> <%if(dgResultEntryHeader.getResultDate() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgResultEntryHeader.getResultDate()) %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label class="noWidth">Result
Time:</label> <label class="value"><%=dgResultEntryHeader.getResultTime() %></label>

<label class="noWidth">Result Prepared By:</label> <%if(dgResultEntryHeader.getEmployee() != null) {%>
<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>"
	value="<%=dgResultEntryHeader.getEmployee().getFirstName() %>" /> <label
	class="value"> <%=dgResultEntryHeader.getEmployee().getFirstName()+" "+ dgResultEntryHeader.getEmployee().getMiddleName()+" "+ dgResultEntryHeader.getEmployee().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=RESULT_ENTERED_BY %>"
	name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="value">-</label>
<%} %> <input type="hidden" name="<%=RESULT_NO %>"
	value="<%=dgResultEntryHeader.getResultNo() %>" /> <label
	class="noWidth">Result Validated Date:</label> <label class="value"><%=date%></label>

<label class="noWidth">Result Validated Time:</label> <label
	class="value"><%=time%></label> <label class="noWidth">Result
Validated By</label> <select id="<%=RESULT_VALIDATED_BY %>"
	name="<%= RESULT_VALIDATED_BY %>" validate="Validated By,string,no"
	tabindex=1>
	<option value="0">Select</option>
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
	<%	}	}}}	%>
</select>



<div class="clear"></div>
<label>Brief Clinical Notes</label> <%if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueAuto"><%=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueAuto">-</label> <%} %>
<div class="clear"></div>

</div>
<div class="division"></div>
<!-- Block Three Ends -->
<div class="clear"></div>
<!-- Table Starts -->


<table border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Service</th>
		<th scope="col">Sample</th>
		<th scope="col">Result</th>
		<th scope="col">UOM</th>
		<th scope="col">Normal Range</th>
		<th scope="col">Validated <input type="checkbox" name="checkall"
			class="radioCheck" value="Collected All" id="addbutton"
			onclick="CheckAll(this);" align="right" /></th>
		<th scope="col">Additional Remarks</th>
		<% int i =0;
	    Set<DgNormalValue>normalSet = new HashSet<DgNormalValue>();
	    for(DgResultEntryDetail dgDetail :dgResultdetailList){
	    	i++;
	    %>
		<input name="resultType" type="hidden" size="10"
			value="<%=dgDetail.getResultType() %>" />
		<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition male  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
							%>

		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
							%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%}}
					}
					}
				} %>
		<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition female -->

		<!--  when result type is SINGLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition None  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%}}
					}
					}
				} %>
		<!--  when result type is SINGLE PARAMETER and comaprison type NORMAL VALUE and condition NoNe -->

		<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition male  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type MULTIPLE PARAMETER and comaprison type NORMAL VALUE and condition fEmale -->

		<!--  when result type is multiple PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition none  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is Multiple PARAMETER and comaprison type NORMAL VALUE and condition none -->

		<!--  when result type is MULTIPLE PARAMETER and comparison type is NORMAL VALUE  -->
		<!--  condition male  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
							%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is TEXT AREA  and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type TEXT AREA and comaprison type NORMAL VALUE and condition fEmale -->

		<!--  when result type is TEXT AREA and comparison type is NORMAL VALUE  -->
		<!--  condition none  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is TEXT AREA and comaprison type NORMAL VALUE and condition none -->

		<!--  when result type is Range and comparison type is NORMAL VALUE  -->
		<!--  condition male  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("male")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("m")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is Range and comaprison type NORMAL VALUE and condition male -->

		<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
		<!--  condition Female  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	
	    	 %>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("female")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("f")){
							%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type RANGE and comaprison type NORMAL VALUE and condition fEmale -->

		<!--  when result type is RANGE and comparison type is NORMAL VALUE  -->
		<!--  condition none  -->
		<%
			normalSet=dgDetail.getSubInvestigation().getDgNormalValues();
	    	%>

		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){
			if(dgResultEntryHeader.getHin().getSex().getAdministrativeSexName().equalsIgnoreCase("Not applicable")){ %>
		<% if(normalSet.size()>0){
					for(DgNormalValue nv :normalSet){
						if(nv != null && nv.getSex().equalsIgnoreCase("n")){
						%>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>

		<%
				}
					}
						}
				}
				} %>
		<!--  when result type is RANGE and comaprison type NORMAL VALUE and condition none -->

		<!--  when result type is HEADING and comparison type is NONE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
			<%}else { %> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"></label> <%} %>
			</td>
			<td><input name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=i %>"
				type="hidden" size="5" value="" readonly /> <label>-</label></td>
			<td><input name="result" id="result<%=i %>" type="hidden"
				value="" /><label>-</label></td>
			<td><input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="" readonly /> <label>-</label></td>
			<td><input name="normalId" type="hidden" id="normalId<%=i %>"
				size="5" value="" readonly /> <input name="fixedId" type="hidden"
				id="fixedId<%=i %>" size="5" value="" readonly /><label>-</label></td>
			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td><input name="<%=ADDITIONAL_REMARKS %>"
				id="<%=ADDITIONAL_REMARKS %><%=i %>" type="hidden" value="" /> <label>-</label>
			<input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!--  end when result type is HEADING and comparison type is NONE  -->
		<!--  when result type is HEADING and comparison type is FIXED VALUE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
			<%}else { %> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"></label> <%} %>
			</td>
			<td><input name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=i %>"
				type="hidden" size="5" value="" readonly /> <label>-</label></td>
			<td><input name="result" id="result<%=i %>" type="hidden"
				value="" /><label>-</label></td>
			<td><input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="" readonly /> <label>-</label></td>
			<td><input name="normalId" type="hidden" id="normalId<%=i %>"
				size="5" value="" readonly /> <input name="fixedId" type="hidden"
				id="fixedId<%=i %>" size="5" value="" readonly /><label>-</label></td>
			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td><input name="<%=ADDITIONAL_REMARKS %>"
				id="<%=ADDITIONAL_REMARKS %><%=i %>" type="hidden" value="" /> <label>-</label>
			<input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!--  end when result type is HEADING and comparison type is FIXED VALUE -->
		<!--  when result type is HEADING and comparison type is NORMAL VALUE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("h") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("v")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %></label>
			<%}else { %> <label name="<%=SUBTEST_NAME %>" class="heading"
				id="<%=SUBTEST_NAME %><%=i %>"></label> <%} %>
			</td>
			<td><input name="<%=SAMPLE_ID %>" id="<%=SAMPLE_ID %><%=i %>"
				type="hidden" size="5" value="" readonly /> <label>-</label></td>
			<td><input name="result" id="result<%=i %>" type="hidden"
				value="" /><label>-</label></td>
			<td><input name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="" readonly /> <label>-</label></td>
			<td><input name="normalId" type="hidden" id="normalId<%=i %>"
				size="5" value="" readonly /> <input name="fixedId" type="hidden"
				id="fixedId<%=i %>" size="5" value="" readonly /><label>-</label></td>
			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td><input name="<%=ADDITIONAL_REMARKS %>"
				id="<%=ADDITIONAL_REMARKS %><%=i %>" type="hidden" value="" /> <label>-</label>
			<input name="<%=RESULT_DETAIL_ID %>"
				id="<%=RESULT_DETAIL_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!--  end of when result type is HEADING and comparison type is NORMAL VALUE  -->
		<!--  when result type is SINGLE PARAMETER and COMPARISON TYPE is NONE  -->
		<%if((dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n"))){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!--  end when result type is SINGLE PARAMETER and COMAPRISON TYPE is NONE -->

		<!--  when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("s") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" id="<%=SUBTEST_ID %><%=i %>" type="hidden"
				size="5" value="<%=dgDetail.getSubInvestigation().getId()%>"
				readonly /> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>"><%=dgDetail.getSubInvestigation().getSubInvestigationName() %>
			<%}else { %> <label name="<%=SUBTEST_NAME %>"
				id="<%=SUBTEST_NAME %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id="<%=SAMPLE_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <label
				name="sample" id="sample<%=i%>"><%=dgDetail.getSample().getSampleDescription() %>
			<%}else { %> <label name="sample" id="sample<%=i%>">-</label> <%} %>
			</td>

			<td><!-- frst if --> <%if(dgDetail.getFixed() != null){%> <input
				name="<%=FIXED_ID %>" id="<%=FIXED_ID %>"
				value="<%=dgDetail.getFixed().getFixedValue() %>" /> <input
				type="hidden" name="<%=RESULT %>" id="" <%=RESULT %> value="" /> <%}else{
			%> <input name="<%=FIXED_ID %>" id="<%=FIXED_ID %>" value="" /> <input
				type="hidden" name="<%=RESULT %>" id="" <%=RESULT %> value="" /> <%} %>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <label
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>"><%=dgDetail.getUom().getUomName() %>
			<%}else { %> <label name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %><%=i %>">-</label> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getNormalValue()%>
			<%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<label name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue"><%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>
			<%}}else{ %> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <label
				name="normalValue" id="normalValue">-</label> <%}} %>
			</td>

			<td><input id="checkId<%=i %>" name="<%=VALIDATED %>"
				type="checkbox" class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!-- end of when result type is SINGLE PARAMAETER and comparison type is FIXED VALUE -->
		<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>

			<!-- frst if -->
			<%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" />
			<%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" />
			<%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%>
			<input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" />
			<%}else{%>
			<input name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" />
			<%}	} %>

			<!--  else if third if  -->
			<%}else{ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" />
			<!--  else of second if -->
			<%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" />
			<%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" />
			<%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" />
			<%  }
		                }
			/**else of frst if  **/ }else{%>
			<input name="<%=RESULT %>" id="<%=RESULT %>" value="" />
			<%}%><td></td>

			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>
			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>

			<td><input id="checkId" name="<%=VALIDATED %>" type="checkbox"
				class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!--  when result type is MULTIPLE PARAMETER and comparison type is NONE   -->
		<!--  when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("m") && dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f") ){ %>


		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>

			<td>
			<% if(dgDetail.getFixed() != null){	%> <input name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %>"
				value="<%=dgDetail.getFixed().getFixedValue() %>" /> <input
				type="hidden" name="<%=RESULT %>" id="<%=RESULT %>" value="" /> <%}%>
			</td>

			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>
			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>

			<td><input id="checkId" name="<%=VALIDATED %>" type="checkbox"
				class="check" /></td>
			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!-- end when result type is MULTIPLE PARAMETER and Comparison type is FIXED VALUE  -->

		<!--  when result type is TEXT AREA and comparison type is NONE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>


			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>



			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>

			<td><input id="checkId" name="<%=VALIDATED %>" type="checkbox"
				class="check" /></td>

			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>

		<!-- end when result type is TEXT AREA and comparison type is NONE -->
		<!--  when result type is TEXT AREA and comparison type is FIXED VALUE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("t")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>
		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>
			<td>
			<%if(dgDetail.getFixed() != null){ %> <input name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %>"
				value="<%=dgDetail.getFixed().getFixedValue() %>" /> <input
				type="hidden" name="<%=RESULT %>" id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>

			<td><input id="checkId" name="<%=VALIDATED %>" type="checkbox"
				class="check" /></td>

			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <%} %> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /></td>
		</tr>
		<%} %>
		<!-- end  when result type is TEXT AREA and comparison type is FIXED VALUE -->
		<!--  when result type is Range and comparison type is NONE -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("n")){ %>

		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>


			<td><!-- frst if --> <%if(dgDetail.getResult() != null){
		/**second if **/		if(!dgDetail.getResult().contains("-")){
			/**third if **/		if(dgDetail.getNormal() != null && !dgDetail.getNormal().equals("")){
			if(dgDetail.getNormal().getNormalValue() != null && !dgDetail.getNormal().getNormalValue().equals("")){
				if(Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getNormalValue())){
					 %> <input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}else if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getNormalValue())){%>
			<input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%} }if(dgDetail.getNormal().getMaxNormalValue()!= null && !dgDetail.getNormal().getMaxNormalValue().equals("") ){
		   			if(Integer.parseInt(dgDetail.getResult()) < Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())&& Integer.parseInt(dgDetail.getResult()) > Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){
				   		%> <input name="<%= RESULT %>" id="<%= RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <%}else{%> <input
				name="<%= RESULT %>" id="<%= RESULT %>" class="highlight"
				value="<%=dgDetail.getResult() %>" /> <%}	} %> <!--  else if third if  -->
			<%}else{ %> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=dgDetail.getResult() %>" /> <!--  else of second if --> <%}}	else{
				String [] minMax = dgDetail.getResult().split("-");
        		if(Integer.parseInt(minMax[0])< Integer.parseInt(dgDetail.getNormal().getMinNormalValue())){ %>
			<input name="<%=RESULT %>" id="<%=RESULT %>" class="highlight"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMaxNormalValue())){
		            	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				class="highlight" value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%		}
		            		else if(Integer.parseInt(minMax[1])> Integer.parseInt(dgDetail.getNormal().getMinNormalValue()) ||Integer.parseInt(minMax[0]) < Integer.parseInt(dgDetail.getInvestigation().getMaxNormalValue())){
		                    	%> <input name="<%=RESULT %>" id="<%=RESULT %>"
				value="<%=minMax[0] %>-<%=minMax[1] %>" /> <%  }
		                }
			/**else of frst if  **/ }else{%> <input name="<%=RESULT %>"
				id="<%=RESULT %>" value="" /> <%}%>
			</td>
			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>

			<td><input id="checkId" name="<%=VALIDATED %>" type="checkbox"
				class="check" /></td>

			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /> <%} %>
			</td>
		</tr>
		<%} %>

		<!-- when result type is RANGE and comparison type is FIXED VALUE  -->
		<%if(dgDetail.getSubInvestigation().getResultType().equalsIgnoreCase("r")&& dgDetail.getSubInvestigation().getComparisonType().equalsIgnoreCase("f")){ %>

		<tr>
			<td><%=i %></td>
			<td>
			<%if(dgDetail.getSubInvestigation() !=null){ %> <input
				name="<%=SUBTEST_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getSubInvestigation().getId()%>" readonly /> <input
				name="<%=SUBTEST_NAME %>" type="text" size="5"
				value="<%=dgDetail.getSubInvestigation().getSubInvestigationName() %>"
				readonly /> <%}else { %> <input name="<%=SUBTEST_NAME %>" type="text"
				size="2" value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgDetail.getSample() !=null){ %> <input name="<%=SAMPLE_ID %>"
				id=<%=SAMPLE_ID %> type="hidden" size="5"
				value="<%=dgDetail.getSample().getId() %>" readonly /> <input
				name="sample" type="text"
				value="<%=dgDetail.getSample().getSampleDescription() %>" readonly />
			<%}else { %> <input name="sample" type="text" value="" readonly /> <%} %>
			</td>


			<td>
			<%if(dgDetail.getFixed() != null){ %> <input name="<%=FIXED_ID %>"
				id="<%=FIXED_ID %>"
				value="<%=dgDetail.getFixed().getFixedValue() %>" /> <input
				type="hidden" name="<%=RESULT %>" id="<%=RESULT %>" value="" /> <%}%>
			</td>

			<td>
			<%if(dgDetail.getUom() !=null){ %> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>"
				id="<%=UNIT_OF_MEASUREMENT_ID %>" type="hidden" size="5"
				value="<%=dgDetail.getUom().getId()%>" readonly /> <input
				name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="5"
				value="<%=dgDetail.getUom().getUomName() %>" readonly /> <%}else { %>
			<input name="<%=UNIT_OF_MEASUREMENT_ID %>" type="text" size="2"
				value="" readonly /> <%} %>
			</td>

			<td>
			<%if(dgDetail.getNormal() != null){ %> <%if(dgDetail.getNormal().getNormalValue() != null || dgDetail.getNormal().getMinNormalValue() != null || dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<%if(dgDetail.getNormal().getNormalValue() != null ){ 
				if(!dgDetail.getNormal().getNormalValue().equals("")){
			%> <input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getNormalValue()%>" readonly /> <%}else if (dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <input name="normalId" type="hidden" id="normalId"
				size="5" value="<%=dgDetail.getNormal().getId() %>" readonly /> <%}
				} 
			else if(dgDetail.getNormal().getMinNormalValue()!= null && dgDetail.getNormal().getMaxNormalValue() != null){ %>
			<input name="normalId" type="hidden" id="normalId" size="5"
				value="<%=dgDetail.getNormal().getId() %>" readonly /> <input
				name="normalValue" type="text" size="8"
				value="<%= dgDetail.getNormal().getMinNormalValue()+" - "+ dgDetail.getNormal().getMaxNormalValue()%>"
				readonly /> <%}}else{ %> <input name="normalId" type="hidden"
				id="normalId" size="5" value="<%=dgDetail.getNormal().getId() %>"
				readonly /> <input name="normalValue" type="text" size="8" value=""
				readonly /><label>-</label> <%}} %>
			</td>

			<td><input id="checkId" name="<%=VALIDATED %>" type="checkbox"
				class="check" /></td>

			<td>
			<%if(dgDetail.getRemarks() !=null){ %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text"
				value="<%=dgDetail.getRemarks()%>" /> <%}else { %> <input
				name="<%=ADDITIONAL_REMARKS %>" type="text" value="" /> <input
				name="<%=RESULT_DETAIL_ID %>" id="<%=RESULT_DETAIL_ID %>"
				type="hidden" size="5" value="<%=dgDetail.getId()%>" readonly /> <%} %>
			</td>
		</tr>


		<%}
    	%>
		<%} %>
	
</table>

<!-- Table Ends -->
<div class="clear"></div>

<input type="button" class="button" value="Submit" id="addbutton"
	onclick="if(inputValue()){submitForm('sampleCollection','investigation?method=submitResultValidationForMultiple')};"
	align="right" /> <input type="reset" name="Reset" value="Reset"
	class="buttonHighlight" accesskey="r" />
<div class="clear"></div>
<!--Bottom labels starts-->
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<!--Bottom labels ends--> <!--main content placeholder ends here-->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
