<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%> 


<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script> 
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>

<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
	/***********************************************
	* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
	* This notice MUST stay intact for legal use
	* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
	***********************************************/
	</script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js">
	/***********************************************
	* Animated Collapsible DIV v2.0- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
	* This notice MUST stay intact for legal use
	* Visit Dynamic Drive at http://www.dynamicdrive.com/ for this script and 100s more
	***********************************************/
	</script>

<script type="text/javascript">
	animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets,persist=0,hide=1')
	animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets,hide=0')

	animatedcollapse.addDiv('title3', 'fade=0,speed=400,group=pets,persist=0,hide=0')
	animatedcollapse.addDiv('title4', 'fade=0,speed=400,group=pets,hide=0')
	animatedcollapse.addDiv('title5', 'fade=0,speed=400,group=pets,persist=0,hide=0')
	animatedcollapse.addDiv('title6', 'fade=0,speed=400,group=pets,persist=0,hide=0')
	animatedcollapse.addDiv('title7', 'fade=0,speed=400,group=pets,persist=0,hide=0')
	animatedcollapse.addDiv('title8', 'fade=0,speed=400,group=pets,persist=0,hide=0')
	animatedcollapse.init()
	</script>

<script>
	function changeClass(title,t)
	{
	animatedcollapse.toggle(title,t);
	}
	</script>

<script type="text/javascript">
function chkLength(field,maxLimit)
{
	if(field.value.length > maxLimit)
	{
	 alert('you crossed the maximum limit of '+maxLimit+' characters');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	 //alert(field.value);
	}
}
 function resetResult(){
	var flag = document.getElementById('singleValuePresentFlag').value;
 		if(flag == 'y'){
	   		document.getElementById('resultSingleValue').value="";
	   		document.getElementById('additionalRemarksSingleValue').value="";
		}
 }
 function goBack(){
 	window.location.href='/hms/hms/investigation?method=searchPatientByBackButtonLab';
 }
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
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
	List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<String> resultSeqNoList = new ArrayList<String>();

	List<Patient> patientList = new ArrayList<Patient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	String CombinedIds = "";
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
	if(map.get("CombinedIds") != null){
		CombinedIds = (String)map.get("CombinedIds");
	}

	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	String deptName ="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	int deptId =0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}

	if(map.get("resultSeqNoList") != null){
		resultSeqNoList = (List<String>)map.get("resultSeqNoList");
	}

	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	//List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
	List subListTemp = new ArrayList();
	if(map.get("subList") != null){
		subList = (ArrayList)map.get("subList");
	}
	/*
	* Code for display more than one multi paramenter test
	*/
	if(map.get("subListTemp") != null){
		subListTemp = (ArrayList)map.get("subListTemp");
	}
	/*
	* End of Code for display more than one multi paramenter test
	* This not completed on pregress Date 
	*/
	Map detailsMap = new HashMap();
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	if(detailsMap.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	try{
		if(map.get("sampleCollectionList") != null){
			sampleCollectionList=(List)map.get("sampleCollectionList");

		}
	}catch(Exception e){
		e.printStackTrace();
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
		} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForParaMedical = properties.getProperty("empCategoryCodeForParaMedical");
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	int hospitalId = 0;
	int departmentId =0;
	int inpatientId =0;
	int hinId = 0;

	DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
	Patient patient = new Patient();
	String admissionNumber = "";

	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	 if(sampleCollectionList != null && sampleCollectionList.size()>0)
	  {
		 dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
				patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
				inpatientSet=patient.getInpatients();
	 }
	 //session.setAttribute("dgDetails",dgDetails);
	    MasDepartment masDepartment=new MasDepartment();
		DgSampleCollectionDetails dgsampleDetails=new DgSampleCollectionDetails();


%>

<script>
function inputResult(){
	var result;
	var flag = document.getElementById('singleValuePresentFlag').value;
	if(flag == 'y'){
		result = document.getElementsByName('resultSingleValue').value;
		if(result == ""){;
	  		alert("Please Enter The Result. ")
	 	}else{
					return true;
		}
	}else{
		return true;
	}
}



function submitFormToViewHistory(investigationId){
	var resultEnteredBy = document.getElementById('resultEnteredById');
	resultEnteredBy.setAttribute("validate","Result Entered By,string,no");
	submitForm('sampleCollection','/hms/hms/investigation?method=showPatientHistory&investigationIdSingleValueSingleTest='+investigationId);
}
function openTemplatePopUp(c){
	//window.open('appointment?method=showExistingPatients&serviceNo='+document.getElementById("serviceNo"+inc).value+'&counter='+inc,'mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300');

	//var resultEnteredBy = document.getElementById('resultEnteredById').value;
	//if(resultEnteredBy != ''){
		var resultNoTemplate =document.getElementById('resultNoTemplate'+c).value;
		var dgSampleDetailIdForTemplate =document.getElementById('dgSampleDetailIdForTemplate'+c).value;
		var CombinedIds = document.getElementById('CombinedIds').value;
		submitForm('sampleCollection','investigation?method=searchForTemplateDetailsLab&resultNoTemplate='+resultNoTemplate+'&dgSampleDetailIdForTemplate='+dgSampleDetailIdForTemplate+'&CombinedIds='+CombinedIds+'');
		//window.open('investigation?method=searchForTemplateDetailsLab&resultNoTemplate='+resultNoTemplate+'&resultEnteredBy='+resultEnteredBy+'&dgSampleDetailIdForTemplate='+dgSampleDetailIdForTemplate+'&CombinedIds='+CombinedIds+'','mywindow','location=1,status=1,scrollbars=1,top=40,left=30,width=960,height=550');
	//}else{
	//	alert('Result Entered By can not be blank.');
	//	return false;
	//}
}
function openSensitivePopUp(c){
		var resultNoSensitive =document.getElementById('resultNoSensitive'+c).value;

		var testOrderNoSensitive =document.getElementById('<%=TEST_ORDER_NO_SENSITIVE_VALUE %>'+c).value;

		var dgSampleDetailIdForSensitive =document.getElementById('dgSampleDetailIdForSensitive'+c).value;
		var CombinedIds = document.getElementById('CombinedIds').value;
		submitForm('sampleCollection','investigation?method=searchForSensitiveDetailsLab&resultNoSensitive='+resultNoSensitive+'&dgSampleDetailIdForSensitive='+dgSampleDetailIdForSensitive+'&CombinedIds='+CombinedIds+'');
}

</script>
<!--main content placeholder starts here-->

<form name="sampleCollection" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div class="titleBg">
		<h2>Result Entry</h2>
	</div>
	<%
String subDept = "";
String dept="";
int SubChargeId=0;
int mainChargeId=0; 
String hinNo = "";
	for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
		if(dgCollection.getInvestigation()!= null){
			subDept = dgCollection.getInvestigation().getSubChargecode().getSubChargecodeName();
			dept = dgCollection.getInvestigation().getMainChargecode().getMainChargecodeName();
			SubChargeId=dgCollection.getSubcharge().getId();
			mainChargeId=dgCollection.getMaincharge().getId();
			hinNo = dgCollection.getSampleCollectionHeader().getHin().getHinNo(); 
		}
	}%>
	<input name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>"
		type="hidden" value="<%= deptId %>" /> <input
		name="<%= SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID %>"
		type="hidden" value="<%= SubChargeId %>" /> <input
		name="<%= MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID %>"
		type="hidden" value="<%= mainChargeId %>" /> <input type="hidden"
		name="<%=SAMPLE_COLLECTION_ID %>" id="<%= SAMPLE_COLLECTION_ID%>"
		value="<%=dgDetails.getSampleCollectionHeader().getId() %>" /> <input
		type="hidden" name="<%=DEPARTMENT_ID %>"
		value="<%=dgDetails.getSampleCollectionHeader().getDepartment().getId() %>" />
	<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" />
	<input type="hidden" name="<%=HIN_NO %>"
		value="<%=patient.getHinNo() %>" /> 
	<%if(dgDetails.getSampleCollectionHeader().getInpatient() != null){ %>
	<input type="hidden" name="<%=INPATIENT_ID %>"
		value="<%=dgDetails.getSampleCollectionHeader().getInpatient().getId()%>" />
	<%}else{ %>
	<input type="hidden" name="<%=INPATIENT_ID %>" value="" />
	<%} %>
	<%
	 String resultSeqNo="";
		if(map.get("resultSeqNo") != null){
			resultSeqNo = (String)map.get("resultSeqNo");
		}
	%>
	<input type=hidden name="<%=RESULT_NO %>" value="<%=resultSeqNo %>"
		title="Result No." /> 
	<%if(dgDetails.getSampleCollectionHeader().getValidatedBy() != null) {%>
	<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
		value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getId() %>" />
	<%}else { %>
	<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
		value="" />
	<%} %>
	<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
		name="pageNo" id="pageNo" value="<%=pageNo%>" /> 
		<input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"
			value="<%=date%>" /> <input type="hidden"
			name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" /> <input
			type=hidden name="<%=RESULT_NO %>" value="<%=resultSeqNo %>"
			title="Result No." /> 
		<%Users user = (Users)session.getAttribute("users");
		Integer empId =user.getEmployee().getId();
		String empFName="";
		String empMName="";
		String empLName=""; 
		if(user.getEmployee().getFirstName()!=null){
			empFName=user.getEmployee().getFirstName();
		}if(user.getEmployee().getMiddleName()!=null){
			empMName=user.getEmployee().getMiddleName();
		}
		if(user.getEmployee().getLastName()!=null){
			empLName=user.getEmployee().getLastName();
		} %> 
		<input type="hidden" name="<%=RESULT_ENTERED_BY%>" value="<%=empId%>" /> 
		<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
			name="pageNo" id="pageNo" value="<%=pageNo%>" />  
	<!-- Block Three Ends -->
	<!-- Table Starts -->
	<label class="auto"><span>(In Result Column: Special
			Characters like (,-,@ etc) are not allowed only numeric value can be
			entered.)</span></label>
	<div class="clear"></div>
	<div class="cmntable">
		<table border="0" cellspacing="0" width="100%" cellpadding="0">

			<tr>

				<th width=7%>S.No.</th>
				<th scope="col">Test Name</th>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<th scope="col">Sample</th>
				<%} %>
				<th scope="col">Result</th>
				<%if(RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase( patient.getHinNo())){%>
				<th scope="col">QC Result</th>
				<%} %>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<th scope="col">Unit</th>
				<%} %>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<th scope="col">Normal Range</th>
				<%} %>
				<th>Remarks</th>
				<th></th>
			</tr>
			<%
		Set<DgMasInvestigation> masSet= new HashSet<DgMasInvestigation>();
   		 DgMasInvestigation masInv = new DgMasInvestigation();
		String normalValue="";
		String charge="";
		int chargeId=0;
		int investigationId=0;
		String resultType="";
		int srNoCounter = 0;
		int indexForMultiple = 0;
		boolean singleValuePresentFlag = false;
       	int i =0;
       	int inc=0;
		for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
			masInv = dgCollection.getInvestigation();
			if(dgCollection.getInvestigation().getChargeCode()!= null)
			{
			charge=dgCollection.getInvestigation().getChargeCode().getChargeCodeName();
			chargeId=dgCollection.getInvestigation().getChargeCode().getId();
			resultType = dgCollection.getInvestigation().getInvestigationType();
			}
			i++;
			if(resultType.equalsIgnoreCase("m")){
				System.out.println("******************** line number 610 for multiple parameter test");
				srNoCounter++; 
				Set<DgSubMasInvestigation> dgSubMasInvestigationsList = DgSubMasInvestigationComparatorByOrderNo.getApplicationTreeSet();
				Set<DgSubMasInvestigation> dgSubMasInvestigationsSetTemp = new HashSet<DgSubMasInvestigation>();
				dgSubMasInvestigationsSetTemp = dgCollection.getInvestigation().getDgSubMasInvestigations();
				if(dgSubMasInvestigationsSetTemp.size()>0){
					
					for(DgSubMasInvestigation dgSubMasInvestigation:dgSubMasInvestigationsSetTemp){
						dgSubMasInvestigationsList.add(dgSubMasInvestigation);
					}
				}
				
				
				
				//Set<DgSubMasInvestigation> dgSubMasInvestigationsList=new TreeSet<DgSubMasInvestigation>();
				
				//dgSubMasInvestigationsList=dgCollection.getInvestigation().getDgSubMasInvestigations();
			
				//Collections.sort();
				%>
			<%@page
				import="jkt.hms.util.DgSubMasInvestigationComparatorByOrderNo"%>
			<tr>
				<td><label name="<%=SR_NO%>"><%=srNoCounter%></label> <input
					name="<%=SUBTEST_NAME %>" type="hidden" value="" /> <input
					type="hidden" name="investigationIdTempForMain"
					id="investigationIdTempForMain"
					value="<%=dgCollection.getInvestigation().getId() %>" /></td>
				<td><label name="<%=INVESTIGATION_NAME%>"
					style="font-weight: bold;"><%=dgCollection.getInvestigation().getInvestigationName() %>
				</label> <input type="hidden" name="<%=TEST_ORDER_NO_MULTIPLE_VALUE%>"
					value="<%=dgCollection.getInvestigation().getTestOrderNo()%>"></input>
				</td>
				<td><input type="hidden" name="HeaderCountFlag"
					id="HeaderCountFlag" value="HeaderCountFlag" /></td>
				<td><input type="hidden"
					name="<%=RESULT_NO_FOR_MULTIPLE_VALUE%>"
					value="<%=resultSeqNoList.get(i-1) %>" title="Result No." /></td>
				<%if(RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient.getHinNo())){%>
				<td></td>
				<%} %>
				<td><input type="hidden" name="<%=SUB_TEST_SIZE%>"
					id="<%=SUB_TEST_SIZE %>"
					value="<%=dgSubMasInvestigationsList.size()%>" /> <input
					type="hidden" name="<%=ADDITIONAL_REMARKS%>"
					id="<%=ADDITIONAL_REMARKS %>" value="" /> <input type="hidden"
					name="<%=SUBTEST_ID%>" id="<%=SUBTEST_ID %>" value="" /> <input
					type="hidden" name="<%=SAMPLE_ID%>" id="<%=SAMPLE_ID %>" value="" />
					<input type="hidden" name="<%=NORMAL_ID%>" id="<%=NORMAL_ID %>"
					value="" /> <input type="hidden" name="<%=FIXED_ID%>"
					id="<%=FIXED_ID %>" value="" /> <input type="hidden"
					name="<%=QC_FIXED_ID%>" id="<%=QC_FIXED_ID %>" value="" /> <input
					type="hidden" name="<%=UNIT_OF_MEASUREMENT_ID%>"
					id="<%=UNIT_OF_MEASUREMENT_ID %>" value="" /> <input type="hidden"
					name="<%=RESULT_TYPE%>" id="<%=RESULT_TYPE %>" value="m" /> <input
					type="hidden" name="<%=INVESTIGATION_ID%>"
					id="<%=INVESTIGATION_ID %>" value="" /> <input type="hidden"
					name="<%=DG_SAMPLE_DETAIL_ID%>" id="<%=DG_SAMPLE_DETAIL_ID %>"
					value="<%=dgCollection.getId() %>" /></td>
				<td><input type="hidden" name="<%=RESULT%>"
					id="<%=RESULT%><%=i%>" value="TestRowFlag" /> <input type="hidden"
					name="<%=QC_RESULT%>" id="<%=QC_RESULT%><%=i%>"
					value="QCTestRowFlag" /> <input type="hidden" value=""
					name="<%=FIXED_NORMAL_VALUE %>"
					id="<%=FIXED_NORMAL_VALUE %><%=inc %>" /></td>
				<td></td>
			</tr>

			<%int subCounter = 0;
	if(dgSubMasInvestigationsList.size()>0){
		for(DgSubMasInvestigation dgSubMasInvestigation1:subList){// new List
			for(DgSubMasInvestigation dgSubMasInvestigation:dgSubMasInvestigationsList){// Old List
				if(dgSubMasInvestigation1.getId().equals(dgSubMasInvestigation.getId())){
					break;
				}
			}
		}
	}
	for(DgSubMasInvestigation dgSubMasInvestigation1:dgSubMasInvestigationsList){
					if(dgSubMasInvestigation1.getResultType().equalsIgnoreCase("h")){ 
						request.setAttribute("dgCollection",dgSubMasInvestigation1);
						request.setAttribute("dgSubMasInvestigationsList",dgSubMasInvestigationsList);
						System.out.println("******************** line number 686");
						%>
			<jsp:include page="viewMultipleRecordTableForHeadingResultType.jsp"
				flush="true">
				<jsp:param name="srNoCounter" value="<%=srNoCounter%>" />
				<jsp:param name="resultEntryIndex" value="<%=i-1%>" />
				<jsp:param name="resultEntryIndexForMultiple"
					value="<%=indexForMultiple%>" />
				<jsp:param name="dgSubMasInvestigationId"
					value="<%=dgSubMasInvestigation1.getId()%>" />
				<jsp:param name="subCounter" value="<%=subCounter%>" />

			</jsp:include>
			<%
	subCounter++;
					} %>
			<%	if(dgSubMasInvestigation1.getResultType().equalsIgnoreCase("s")){
				System.out.println("******************** line number 702");
						%>

			<%request.setAttribute("dgCollection",dgSubMasInvestigation1); %>
			<%request.setAttribute("srNoCounter",srNoCounter); %>
			<jsp:include page="viewMultipleRecordTableForSingleResultType.jsp"
				flush="true">
				<jsp:param name="srNoCounter" value="<%=srNoCounter%>" />
				<jsp:param name="resultEntryIndex" value="<%=i-1%>" />
				<jsp:param name="resultEntryIndexForMultiple"
					value="<%=indexForMultiple%>" />
				<jsp:param name="dgSubMasInvestigationId"
					value="<%=dgSubMasInvestigation1.getId()%>" />
				<jsp:param name="subCounter" value="<%=subCounter%>" />

			</jsp:include>

			<%	
	subCounter++;
	}
					if(dgSubMasInvestigation1.getResultType().equalsIgnoreCase("t")){
						System.out.println("******************** line number 724");
						%>
			<%request.setAttribute("dgCollection",dgSubMasInvestigation1); %>
			<jsp:include page="ViewMultipleResultEntryForTextType.jsp"
				flush="true">
				<jsp:param name="srNoCounter" value="<%=srNoCounter%>" />
				<jsp:param name="resultEntryIndex" value="<%=i-1%>" />
				<jsp:param name="resultEntryIndexForMultiple"
					value="<%=indexForMultiple%>" />
				<jsp:param name="dgSubMasInvestigationId"
					value="<%=dgSubMasInvestigation1.getId()%>" />
				<jsp:param name="subCounter" value="<%=subCounter%>" />

			</jsp:include>

			<%		subCounter++;
	}
					if(dgSubMasInvestigation1.getResultType().equalsIgnoreCase("m")){
						System.out.println("******************** line number 742");
						%>
			<%request.setAttribute("dgCollection",dgSubMasInvestigation1); %>
			<jsp:include page="viewMultipleResultEntryForTextAreaType.jsp"
				flush="true">
				<jsp:param name="srNoCounter" value="<%=srNoCounter%>" />
				<jsp:param name="resultEntryIndex" value="<%=i-1%>" />
				<jsp:param name="resultEntryIndexForMultiple"
					value="<%=indexForMultiple%>" />
				<jsp:param name="dgSubMasInvestigationId"
					value="<%=dgSubMasInvestigation1.getId()%>" />
				<jsp:param name="subCounter" value="<%=subCounter%>" />

			</jsp:include>

			<%	subCounter++;	}

				if(dgSubMasInvestigation1.getResultType().equalsIgnoreCase("r")){
					System.out.println("******************** line number 760");
					%>
			<%request.setAttribute("dgCollection",dgSubMasInvestigation1); %>
			<jsp:include page="viewMultipleResultEntryForRangeType.jsp"
				flush="true">
				<jsp:param name="srNoCounter" value="<%=srNoCounter%>" />
				<jsp:param name="resultEntryIndex" value="<%=i-1%>" />
				<jsp:param name="resultEntryIndexForMultiple"
					value="<%=indexForMultiple%>" />
				<jsp:param name="dgSubMasInvestigationId"
					value="<%=dgSubMasInvestigation1.getId()%>" />
				<jsp:param name="subCounter" value="<%=subCounter%>" />

			</jsp:include>

			<%		subCounter++;} 
				if(dgSubMasInvestigation1.getResultType().equalsIgnoreCase("i")){
				System.out.println("******************** line number 777");
				%>
			<%request.setAttribute("dgCollection",dgSubMasInvestigation1); %>
			<jsp:include page="viewMultipleResultEntryForMultipleSelection.jsp"
				flush="true">
				<jsp:param name="srNoCounter" value="<%=srNoCounter%>" />
				<jsp:param name="resultEntryIndex" value="<%=i-1%>" />
				<jsp:param name="resultEntryIndexForMultiple"
					value="<%=indexForMultiple%>" />
				<jsp:param name="dgSubMasInvestigationId"
					value="<%=dgSubMasInvestigation1.getId()%>" />
				<jsp:param name="subCounter" value="<%=subCounter%>" />

			</jsp:include>

			<%		subCounter++;}  %>


			<%		}

				//	subCounter++;
				 %>
			<%
		  indexForMultiple = indexForMultiple + dgCollection.getInvestigation().getDgSubMasInvestigations().size()+1;
		  //break;
		  }else if(resultType.equalsIgnoreCase("s")){
			  srNoCounter++;
			  singleValuePresentFlag = true;
			  System.out.println("******************** line number 804 for single parameter test");
			  %>
			<tr>

				<input type="hidden" name="<%=RESULT_NO_SINGLE_VALUE %>"
					value="<%=resultSeqNoList.get(i-1) %>" title="Result No." />
				<td><label name="<%=SR_NO%>"><%=srNoCounter%></label></td>

				<td><input name="<%=RESULT_TYPE_SINGLE_VALUE %>"
					id="<%=RESULT_TYPE_SINGLE_VALUE %>" value="s" type="hidden">
						<input name="<%=INVESTIGATION_ID_SINGLE_VALUE %>"
						id="<%=INVESTIGATION_ID_SINGLE_VALUE %>"
						value=<%= dgCollection.getInvestigation().getId()%> type="hidden">
							<input name="chargeCodeCodeForPerticularTest"
							id="chargeCodeCodeForPerticularTest<%=srNoCounter%>"
							value=<%= dgCollection.getInvestigation().getChargeCode().getChargeCodeCode()%>
							type="hidden"> <input type="hidden"
								name="<%=TEST_ORDER_NO_SINGLE_VALUE%>"
								id="<%=TEST_ORDER_NO_SINGLE_VALUE %>"
								value="<%=dgCollection.getInvestigation().getTestOrderNo()%>" />
								<input name="<%=CHARGE_CODE_ID_SINGLE_VALUE %>"
								id="<%=CHARGE_CODE_ID %>" value=<%= chargeId%> type="hidden">
									<input name="<%=DG_SAMPLE_DETAIL_ID_SINGLE_VALUE %>"
									id="<%=DG_SAMPLE_DETAIL_ID %>" value=<%= dgCollection.getId()%>
									type="hidden"> <%if(dgCollection.getInvestigation().getInvestigationName() !=null){
            	        %> <label style="font-weight: bold;"> <%=dgCollection.getInvestigation().getInvestigationName() %>
									</label> <input name="<%=INVESTIGATION_NAME_SINGLE_VALUE %>"
										type="hidden" size="15"
										value="<%=dgCollection.getInvestigation().getInvestigationName() %>"
										readonly /> <%}else { %> <label style="font-weight: bold;"></label>
										<input name="<%=INVESTIGATION_NAME_SINGLE_VALUE %>"
										type="hidden" size="15" value="" readonly /> <%} %></td>

				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<td>
					<%if(dgCollection.getInvestigation().getSample() !=null){ %> <input
					type="hidden" name="<%=SAMPLE_ID_SINGLE_VALUE%>"
					id="<%=SAMPLE_ID_SINGLE_VALUE %>"
					value="<%=dgCollection.getInvestigation().getSample().getId() %>" />
					<input name="<%=SAMPLE_NAME_SINGLE_VALUE %>" type="text"
					class="readOnly" size="10"
					value="<%=dgCollection.getInvestigation().getSample().getSampleDescription() %>"
					readonly /> <%}else { %> <input name="<%=SAMPLE_ID_SINGLE_VALUE %>"
					type="text" size="10" value="" class="readOnly" readonly /> <%} %>
				</td>
				<%}%>
				<td><input type="text" name="<%=RESULT_SINGLE_VALUE %>"
					id="<%=RESULT_SINGLE_VALUE %><%=srNoCounter%>" value=""
					maxlength="50" /> <!-- onkeyup="submitAllExceptEnter(this,event,'','srNoCounter%>');" -->
					<script type="text/javascript">
				var chargeCodeToTest = document.getElementById('chargeCodeCodeForPerticularTest<%=srNoCounter%>').value;
				if(chargeCodeToTest == 'HA17'){
					document.getElementById('<%=RESULT_SINGLE_VALUE %><%=srNoCounter%>').value = 'Control 13 Sec,';
				}else if(chargeCodeToTest == 'HA18'){
					document.getElementById('<%=RESULT_SINGLE_VALUE %><%=srNoCounter%>').value = 'Control 28 Sec,';
				}
			</script></td>
				<%if(RequestConstants.UHID_FOR_QUALITY_TESTING.equalsIgnoreCase(patient.getHinNo())){%>
				<td><input type="text" name="<%=QC_RESULT_SINGLE_VALUE %>"
					id="<%=QC_RESULT_SINGLE_VALUE %><%=srNoCounter%>" value=""
					maxlength="50" /></td>
				<%} if(deptType.equalsIgnoreCase("DIAG")){ %>
				<td>
					<%if(dgCollection.getInvestigation().getUom() !=null){ %> <input
					type="hidden" name="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE%>"
					id="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE %>"
					value="<%=dgCollection.getInvestigation().getUom().getId() %>" />
					<input name="uomName" type="text" size="8"
					value="<%=dgCollection.getInvestigation().getUom().getUomName() %>"
					class="readOnly" readonly /> <%}else { %> <input
					name="<%=UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE%>" type="text"
					size="8" value="" class="readOnly" readonly /> <%} %>
				</td>
				<%} %>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<td>
					<%if(dgCollection.getInvestigation().getNormalValue() != null || dgCollection.getInvestigation().getMinNormalValue() != null || dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
					<%if(dgCollection.getInvestigation().getNormalValue() != null ){
						if(!dgCollection.getInvestigation().getNormalValue().equals("")){
					%> <input name="normalIdSingleValue" type="hidden" size="8"
					value="<%=dgCollection.getInvestigation().getId()%>" readonly /> <input
					name="normalValueSingleValue" type="text" size="8"
					value="<%=dgCollection.getInvestigation().getNormalValue()%>"
					class="readOnly" readonly /> <%}else if (dgCollection.getInvestigation().getMinNormalValue()!= null && dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
					<input name="normalIdSingleValue" type="hidden" size="8"
					value="<%=dgCollection.getInvestigation().getId()%>" readonly /> <input
					name="normalValueSingleValue" type="text" size="8"
					value="<%=dgCollection.getInvestigation().getMinNormalValue()+" - "+dgCollection.getInvestigation().getMaxNormalValue()%>"
					class="readOnly" readonly /> <%}
					}
					else if(dgCollection.getInvestigation().getMinNormalValue()!= null && dgCollection.getInvestigation().getMaxNormalValue() != null){ %>
					<input name="normalIdSingleValue" type="hidden" size="8"
					value="<%=dgCollection.getInvestigation().getId()%>"
					class="readOnly" readonly /> <input name="normalValueSingleValue"
					type="text" size="8"
					value="<%=dgCollection.getInvestigation().getMinNormalValue()+" - "+dgCollection.getInvestigation().getMaxNormalValue()%>"
					class="readOnly" readonly /> <%}}else{ %> <input
					name="normalIdSingleValue" type="hidden" size="8"
					value="<%=dgCollection.getInvestigation().getId()%>"
					class="readOnly" readonly /> <input name="normalValueSingleValue"
					type="text" size="8" value="" class="readOnly" readonly /> <%} %>
				</td>
				<%} %>

				<td>
					<%if(dgCollection.getRemarks() != null){ %> <input
					value="<%=dgCollection.getRemarks() %>" maxlength="200"
					onkeyup="chkLength(this,100);"
					name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"></input> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS_SINGLE_VALUE%>.innerHTML = "<%=dgCollection.getRemarks()%>"</script>
					<%}else{ %> <input value="" maxlength="200"
					onkeyup="chkLength(this,100);"
					name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"></input> <%} %>
				</td>
				<td>
					<!-- <input type="checkbox" /> --> <%-- <input type="button" name="patientHistoryButton"
					value="Patient History" class="buttonBig"
					onclick="submitFormToViewHistory('<%=dgCollection.getInvestigation().getId()%>');" /> --%>
				</td>
			</tr>

			<%	}else if(resultType.equalsIgnoreCase("t")){
			srNoCounter++;
			System.out.println("******************** line number 922 for template type test");
	%>
			<tr>
				<td><label name="<%=SR_NO%>"><%=srNoCounter%></label></td>
				<td><input name="<%=DG_SAMPLE_DETAIL_ID_TEMPLATE %>"
					id="<%=DG_SAMPLE_DETAIL_ID_TEMPLATE %><%=(i-1) %>"
					value="<%= dgCollection.getId()%>" type="hidden"> <input
						name="sampleDetailId" id="sampleDetailId<%=(i-1) %>"
						value="<%= dgCollection.getId()%>" type="hidden"><input
							type="hidden" name="<%=RESULT_NO_TEMPLATE%>"
							id="<%=RESULT_NO_TEMPLATE %><%=(i-1)%>"
							value="<%=resultSeqNoList.get(i-1) %>" title="Result No." /> <input
							type="hidden" name="<%=TEST_ORDER_NO_TEMPLATE_VALUE%>"
							id="<%=TEST_ORDER_NO_TEMPLATE_VALUE%><%=(i-1)%>"
							value="<%=dgCollection.getInvestigation().getTestOrderNo()%>" />
							<label name="<%=INVESTIGATION_NAME_FOR_TEMPLATE %>"
							style="font-weight: bold;"><%=dgCollection.getInvestigation().getInvestigationName() %>
						</label></td>

				<td>
					<div id="templateButtonDiv" style="display: block; width: auto;">

						<input type="button" class="buttonBig2"
							value="Click Here To Fill Result"
							onclick="openTemplatePopUp(<%=(i-1)%>);" align="right" />
					</div>
				</td>
				<td>
					<div id="resultEntryMessageDiv"
						style="color: red; display: none; width: 100%;">
						<label style="font-weight: bold; color: red;">Result
							Entered Successfully</label>
					</div>
				</td>
				<td><input type="checkbox" /></td>
			</tr>
			<%	}else if(resultType.equalsIgnoreCase("v")){
		srNoCounter++;
		System.out.println("******************** line number 960 for sensitive type test");
		%>
			<tr>
				<td><label name="srNo"><%=srNoCounter%></label> <input
					type="hidden" name="<%=SR_NO%>" value="<%= srNoCounter%>" /></td>

				<input name="<%=DG_SAMPLE_DETAIL_ID_SENSITIVE %>"
					id="<%=DG_SAMPLE_DETAIL_ID_SENSITIVE %><%=(i-1) %>"
					value="<%= dgCollection.getId()%>" type="hidden"> <input
					type="hidden" name="<%=RESULT_NO_SENSITIVE%>"
					id="<%=RESULT_NO_SENSITIVE %><%=(i-1)%>"
					value="<%=resultSeqNoList.get(i-1) %>" title="Result No." /> <input
					type="hidden" name="<%=TEST_ORDER_NO_SENSITIVE_VALUE%>"
					id="<%=TEST_ORDER_NO_SENSITIVE_VALUE %><%=(i-1)%>"
					value="<%=dgCollection.getInvestigation().getTestOrderNo()%>" />

					<td><input name="<%=RESULT_TYPE_FOR_SENSITIVE %>"
						id="<%=RESULT_TYPE_FOR_SENSITIVE %>" value="v" type="hidden">
							<input name="<%=INVESTIGATION_ID_FOR_SENSITIVE%>"
							id="<%=INVESTIGATION_ID_FOR_SENSITIVE %>"
							value=<%= dgCollection.getInvestigation().getId()%> type="hidden">
								<input type="hidden" name="<%=TEST_ORDER_NO_SENSITIVE%>"
								id="<%=TEST_ORDER_NO_SENSITIVE %>"
								value="<%=dgCollection.getInvestigation().getTestOrderNo()%>" />
								<input type="hidden" name="<%=RESULT_NO_SENSITIVE%>"
								id="<%=RESULT_NO_SENSITIVE %><%=(i-1)%>"
								value="<%=resultSeqNoList.get(i-1) %>" title="Result No." /> <input
								name="<%=DG_SAMPLE_DETAIL_ID_SINGLE_VALUE %>"
								id="<%=DG_SAMPLE_DETAIL_ID %>" value=<%= dgCollection.getId()%>
								type="hidden"> <label
									name="<%=INVESTIGATION_NAME_FOR_SENSITIVE %>"
									style="font-weight: bold;"><%=dgCollection.getInvestigation().getInvestigationName() %>
								</label></td>

					<td>
						<%-- %>
		<div id="templateButtonDiv" style="display: block; width: auto;">

		<input type="button" class="buttonBig2"
			value="Click Here To Fill Result"
			onclick="openSensitivePopUp(<%=(i-1)%>);" align="right" /></div>
			--%> <%if(dgCollection.getInvestigation().getSample() !=null){ %> <input
						type="hidden" name="<%=SAMPLE_ID_SINGLE_VALUE%>"
						id="<%=SAMPLE_ID_SINGLE_VALUE %>"
						value="<%=dgCollection.getInvestigation().getSample().getId() %>" />
						<%} %> <%if(dgCollection.getSample()!=null){ %> <label name=""
						style="font-weight: bold;"><%=dgCollection.getSample().getSampleDescription() %>
							<%}else{ %> <label name="" style="font-weight: bold;">-- <%} %>
				</td>
					<td>
						<%-- %><div id="resultEntryMessageDiv"
			style="color: red; display: none; width: 100%;"><label
			style="font-weight: bold; color: red;">Result Entered
		Successfully</label></div>--%> <select id=""
						name="<%=RESULT_SENSITIVE %>">
							<option value="">Select</option>
							<option value="Positive">Positive</option>
							<option value="Negative">Negative</option>
					</select>

				</td>
					<td></td>
					<td></td>
					<td>
						<%if(dgCollection.getRemarks() != null){ %> <input
						value="<%=dgCollection.getRemarks() %>" maxlength="200"
						onkeyup="chkLength(this,100);"
						name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"></input> <script>document.sampleCollection.<%=ADDITIONAL_REMARKS_SINGLE_VALUE%>.innerHTML = "<%=dgCollection.getRemarks()%>"</script>
						<%}else{ %> <input value="" maxlength="200"
						onkeyup="chkLength(this,100);"
						name="<%=ADDITIONAL_REMARKS_SINGLE_VALUE %>"></input> <%} %>

				</td>
					</td>
			</tr>
			<%	}

		} %>

		</table>
	</div>

	<div class="Height10"></div>
	<div class="division"></div>
	<!-- Table Ends -->
	<!--Bottom labels starts-->
	<input type="hidden" name="CombinedIds" id="CombinedIds"
		value="<%=CombinedIds%>" />
	<%if(singleValuePresentFlag) { %>
	<input type="hidden" name="singleValuePresentFlag"
		id="singleValuePresentFlag" value="y" />
	<% }else{ %>
	<input type="hidden" name="singleValuePresentFlag"
		id="singleValuePresentFlag" value="n" />
	<% } %>
	<div class="clear"></div>
	<div class="division"></div>
	<input type="button" name="Submit11" id="submitForDisable" tabindex="1"
		class="button" value="Submit"
		onclick="submitForm('sampleCollection','investigation?method=submitResultEntryForAllInvestigationType');"
		align="right" /> 
	<div class="clear"></div>
	<div class="division"></div>
	<div class="paddingTop15"></div>
	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=date%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label>
		<div class="clear"></div>
		<div class="paddingTop40"></div>
	</div>
	<!--Bottom labels starts-->
</form>
<!--main content placeholder ends here-->

<script type="text/javascript">
function checkForNumericResult(obj,inc)
{
	if(obj.value != ''){
		var flag = validateNumeric(obj.value);
		if(flag == false){
			alert('\''+obj.value + '\' is not Accepted in Result Column at row ' + inc + '.\nOnly numeric value is allowed in Result.');
			return false;
		}
	}
	return true;
}
function submitAllExceptEnter(myfield,e,url,inc)
{
	var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e)
		keycode = e.which;
	else
		return true;
	if (keycode != 13) {
		var chargeCodeCode = document.getElementById('chargeCodeCodeForPerticularTest'+inc).value
		//if(chargeCodeCode != 'HA17' && chargeCodeCode != 'HA18'){

		///	if(checkForNumericResult(myfield,inc)){
		//		return true;
			//}else{
				document.getElementById('<%=RESULT_SINGLE_VALUE %>'+inc).value = '';
				return false;
		//	}
	//	}
	}
}
function checkForNumericResultMultiple(obj,inc,mainCount,subCount)
{
	if(obj.value != ''){
		var flag = validateNumeric(obj.value);
		if(flag == false){
			alert('\''+obj.value + '\' is not Accepted in Result Column at row ' + mainCount + '.' + subCount+ '.\nOnly numeric value is allowed in Result.');
			return false;
		}
	}
	return true;
}

function submitAllExceptEnterForMultiple(myfield,e,url,inc,mainCount,subCount)
{
	
	var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e)
		keycode = e.which;
	else
		return true;
	if (keycode != 13) {

		var chargeCodeCode = document.getElementById('chargeCodeCodeForPerticularTestForMultiple'+mainCount+subCount).value;
		//if(chargeCodeCode != 'HA25'){

		//	if(checkForNumericResultMultiple(myfield,inc,mainCount,subCount)){
		//		return true;
		//	}else{

				//document.getElementById('<%=RESULT%>'+inc).value = '';
				return false;
		//	}
		//}
	}
}
function concatAllValueOfMultipleSelection(objElement,value){ 
		  var result = [];
		  var options = value && value.options;
		  var opt=""; 
		  var flag=false;
		  for (var i=0;i<options.length; i++) {
		    options[i]; 
		   
		    if (options[i].selected) {
		    	 if(flag){
			    		opt=opt.concat("#");
			    	}
		    	opt=opt.concat(options[i].value);
		    	flag=true;
		    } 
		  }   
		 objElement.value=opt;
		 
}
</script>
