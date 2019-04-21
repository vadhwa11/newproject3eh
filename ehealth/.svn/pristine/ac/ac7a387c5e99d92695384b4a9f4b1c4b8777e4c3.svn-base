<%@page import="jkt.hms.masters.business.DgHistoSampleCollectionDetails"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.DgCollectionCenter"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgMasCollection"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgTemplate"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.math.BigDecimal"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-color.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-settings.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>


<%--For AutoComplete Through Ajax--%>
<%@page import="javax.swing.text.StyledEditorKit.BoldAction"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<% 
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<!-- 
Attach the editor on the textareas
-->
<script type="text/javascript">
// Use it to attach the editor to all textareas with full featured setup
//WYSIWYG.attach('all', full);

// Use it to attach the editor directly to a defined textarea

WYSIWYG.attach('abc', full); // full featured setup

// Use it to display an iframes instead of a textareas
//WYSIWYG.display('all', full);  
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
 
	   document.getElementById('abc').value="";
	   document.getElementById('additionalRemarks').value="";
	   
   }
function see()
{
document.sampleCollection.method="post";
  
				// alert(updatedtemplate);
				  var hinNo=document.getElementById("hinNo").value;
				  var inpatientId=document.getElementById("inpatientId").value;
				 var sampleCollectionDetailId= document.getElementById("sampleCollectionDetailId").value;
				 var departmentId=document.getElementById("departmentId").value;
fName=document.getElementById("upload").value;
var extension =fName.substring(fName.length-4);
if(fName !=""){
if( extension != '.txt' && extension != '.TXT' && extension !='.rtf')
{	
//alert("Uploaded Document can only be in .txt or .TXT format\n");
//return false;
}
var updatedtemplate=document.sampleCollection.test2.value;
 document.sampleCollection.browse.value="browse";

//window.location.href ='investigation?method=getFileName&sampleCollectionDetailId='+sampleCollectionDetailId+'&hinNo='+hinNo+'&inpatientId='+inpatientId+'&parameterName=fromResultEntry&formName=sampleCollection&test2='+updatedtemplate+'';
submitForm('sampleCollection','investigation?method=getFileName&browse=browse&sampleCollectionDetailId='+sampleCollectionDetailId+'&hinNo='+hinNo+'&inpatientId='+inpatientId+'&parameterName=fromResultEntry&formName=sampleCollection&test2='+updatedtemplate+''); 
}
return true;
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
	Map detailsMap = new HashMap();
	
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	
	Box box = HMSUtil.getBox(request);
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String appendedHtml = "";
	String userName = "";
	String deptName="";
	int deptId =0;
	String browse="";
	int sampleCollectionDetailId=0;
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("sampleCollectionDetailId")!=null){
		sampleCollectionDetailId=(Integer)map.get("sampleCollectionDetailId");
	}
	
	
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	if(map.get("appendedHtml")!=null){
		appendedHtml=(String)map.get("appendedHtml");
	}
	if(map.get("pageNo") != null){
	pageNo=(Integer)map.get("pageNo");
	}
	if(map.get("browse") != null){
		browse=(String)map.get("browse");
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
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	try{
	if(map.get("sampleCollectionList") != null){
	sampleCollectionList=(List)map.get("sampleCollectionList");
	}}catch(Exception e){
	e.printStackTrace();
	}
	DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
	Patient patient = new Patient();
	int hinId = 0;
	if(sampleCollectionList != null){
	dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
	patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
	
		if(dgDetails.getSampleCollectionHeader().getHin() != null){
			hinId=dgDetails.getSampleCollectionHeader().getHin().getId();
		}
	}
	
	DgSampleCollectionDetails dgsampleDetails=new DgSampleCollectionDetails();
	
	if(sampleCollectionList != null){
		dgsampleDetails = (DgSampleCollectionDetails) sampleCollectionList.get(0);
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
	String RequisitionFrom2="";
	
	if(map.get("RequisitionFrom")!=null){
		RequisitionFrom2=(String)map.get("RequisitionFrom");
	}
%>
<script type="text/javascript">
   history.forward();
</script>
<!--main content placeholder starts here-->

<form name="sampleCollection" method="post"
	enctype="multipart/form-data" action="">
	<div class="titleBg">
		<h2>Result Entry</h2>
	</div>
	<%
	String subDept = "";
	String dept="";
	int SubChargeId=0;
	int mainChargeId=0;
		
	String patientName = "";
	String age = "";
	String sex = "";
	String hinNo = "";
	String currentAge = "";
	String maritalStatus = "";
	if(sampleCollectionList!=null && sampleCollectionList.size()>0) {
	for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
	if(dgCollection.getInvestigation()!= null){
	subDept = dgCollection.getInvestigation().getSubChargecode().getSubChargecodeName();
	dept = dgCollection.getInvestigation().getMainChargecode().getMainChargecodeName();
	SubChargeId=dgCollection.getInvestigation().getSubChargecode().getId();
	mainChargeId=dgCollection.getInvestigation().getMainChargecode().getId();
	DgSampleCollectionHeader sampleHeader = dgCollection.getSampleCollectionHeader();
	Set<DgOrderdt> set = new HashSet<DgOrderdt>();
	set = dgCollection.getSampleCollectionHeader().getOrder().getDgOrderdts();
	for(DgOrderdt orderDt : set){
	if(orderDt.getBill() != null){
		BlOpBillHeader  billHeader = orderDt.getBill();
		if(billHeader.getHin() != null ){
		patientName=billHeader.getHin().getPFirstName();
		age=billHeader.getHin().getAge();
		sex=billHeader.getHin().getSex().getAdministrativeSexName();
		hinNo=billHeader.getHin().getHinNo();
		hinId=billHeader.getHin().getId();
		if(age!=null ){
		currentAge = HMSUtil.calculateAgeForADT(age, sampleHeader.getHin().getRegDate());
		
		}else if(sampleHeader.getHin().getDateOfBirth()!=null){
			currentAge = HMSUtil.calculateAge(sampleHeader.getHin().getDateOfBirth());
		}else{
			age="20 Years";
		}
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
		}
	else{
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
  } }%>
	<input name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>"
		type="hidden" value="<%=(Integer)session.getAttribute("deptId")%>" />
	<input name="<%= SAMPLE_COLLECTION_DETAIL_ID %>"
		id="<%= SAMPLE_COLLECTION_DETAIL_ID %>" type="hidden"
		value="<%=box.getInt( SAMPLE_COLLECTION_DETAIL_ID) %>" /><input
		name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
		type="hidden" value="<%=SubChargeId %>" /> <input
		name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
		type="hidden" value="<%=mainChargeId %>" /> <input type="hidden"
		id="browse" name="browse" value=""><input type="hidden"
		name="<%=SAMPLE_COLLECTION_ID %>" id="<%= SAMPLE_COLLECTION_ID%>"
		value="<%=dgDetails.getSampleCollectionHeader().getId() %>" /> <input
		type="hidden" name="<%=HIN_ID %>" value="<%=hinId %>"
		id="<%=HIN_ID %>" />
		
		
		
		
	<div class="clear"></div>

	<!--Block Two Starts-->
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
			class="value"><%=patient.getHinNo() %></label>
		<%					String middleName = "";
					String lastName = "";
					if(patient.getPMiddleName() != null){
						middleName = patient.getPMiddleName();
					}
					if(patient.getPLastName() != null){
						lastName = patient.getPLastName();
					}

%>
		<label>Patient Name</label> <label class="value"><%= patient.getPFirstName()+" "+middleName+" "+lastName%></label>

		<label>Gender</label> <label class="value"><%=patient.getSex().getAdministrativeSexName() %></label>
		<div class="clear"></div>
		<%
			if (dgDetails.getSampleCollectionHeader().getOrder().getInpatient() != null) {
		%>
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <label
			class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getInpatient().getAdNo()%></label>
		<label>Ward</label> <label class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
		<label>Bed</label> <label class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getInpatient().getBed().getBedNo()%></label>
		<div class="clear"></div>
		<%}

		String fName = "";  
		if (dgDetails.getSampleCollectionHeader().getOrder().getPrescribedBy()
				  != null) {
			fName = dgDetails.getSampleCollectionHeader().getOrder().getPrescribedBy()
					.getEmployeeName();
		} 
		String bloodGroup = "-";
		if (dgDetails.getSampleCollectionHeader().getOrder().getHin().getBloodGroup() != null
				&& dgDetails.getSampleCollectionHeader().getOrder().getHin()
						.getBloodGroup().getBloodGroupCode() != null) {
			bloodGroup = dgDetails.getSampleCollectionHeader().getOrder().getHin()
					.getBloodGroup().getBloodGroupCode();
		}
		String mobileNumber = "-";
		if (dgDetails.getSampleCollectionHeader().getOrder().getHin().getMobileNumber() != null && !"".equalsIgnoreCase(dgDetails.getSampleCollectionHeader().getOrder().getHin().getMobileNumber().trim())) {
			mobileNumber = dgDetails.getSampleCollectionHeader().getOrder().getHin()
					.getMobileNumber();
		} 
		
		%>
		<label>Blood Group</label> <label class="value"><%=bloodGroup%></label>
		<label>Mobile No</label> <label class="value"><%=mobileNumber%></label>
		<label>Unit</label> <label class="value">-</label>
		<div class="clear"></div>
		<label>Doctor Name</label> <label class="value"><%=fName%></label>
		<div class="clear"></div>
	</div>
	<input type="hidden" name="<%=DEPARTMENT_ID %>"
		value="<%=dgDetails.getSampleCollectionHeader().getDepartment().getId() %>" />
	<%if(dgDetails.getSampleCollectionHeader().getInpatient() != null){ %>
	<input type="hidden" id="<%=INPATIENT_ID %>" name="<%=INPATIENT_ID %>"
		value="<%=dgDetails.getSampleCollectionHeader().getInpatient().getId()%>" />
	<%}else{%>
	<input type="hidden" id="<%=INPATIENT_ID %>" name="<%=INPATIENT_ID %>"
		value="" />
	<%} %>
	<!--Block Two Ends-->
	<!-- Block Three Starts -->
	<h4>Sample Validation Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>

		
		<%-- <input type=hidden name="<%=RESULT_NO %>" value="<%=resultSeqNo %>"
			title="Result No." id="<%=RESULT_NO%>"/>  --%>

		<div class="clear"></div>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<label>Sample Validated Date</label>
		<%}else{ %>
		<label>Date</label>
		<%} %>
		<%if(dgDetails.getSampleCollectionHeader().getSampleValidationDate() != null){ %>
		<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getSampleValidationDate()) %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<label>Validated By</label>
		<%}else{ %>
		<label>Validated By</label>
		<%} %>
		<%if(dgDetails.getSampleCollectionHeader().getValidatedBy() != null) {%>
		<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
			value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getId() %>" />
		<label class="value"> <%middleName="";lastName=""; if(dgDetails.getSampleCollectionHeader().getValidatedBy().getMiddleName()!=null){middleName=dgDetails.getSampleCollectionHeader().getValidatedBy().getMiddleName();}if(dgDetails.getSampleCollectionHeader().getValidatedBy().getLastName()!=null){lastName=dgDetails.getSampleCollectionHeader().getValidatedBy().getLastName();}%>
			<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getFirstName()+" "+middleName +" "+ lastName %></label>
		<%}else { %>
		<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
			value="" /> <label class="value"> -</label>
		<%} %>
		<div class="clear"></div>
		<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
			name="pageNo" id="pageNo" value="<%=pageNo%>" />
		<div class="clear"></div>
	</div>
	<%-- <div class="Block">
		<label>Report Date</label> <label class="value"><%=date%></label> <label>Report
			Time</label> <label class="value"><%=time%></label> <input type="hidden"
			name="<%=SAMPLE_COLLECTION_DATE%>" id="<%=SAMPLE_COLLECTION_DATE %>"
			value="<%=date%>" /> <input type="hidden"
			name="<%=SAMPLE_COLLECTION_TIME %>" id="<%=SAMPLE_COLLECTION_TIME %>"
			value="<%=time%>" />
		<%
String resultSeqNo="";
if(map.get("resultSeqNo") != null){
resultSeqNo = (String)map.get("resultSeqNo");
}
%>
		<input type=hidden name="<%=RESULT_NO %>" id="<%=RESULT_NO %>"
			value="<%=resultSeqNo %>" /> <label><span>*</span> Report
			Prepared By</label> <select name="<%= RESULT_ENTERED_BY  %>"
			id="<%= RESULT_ENTERED_BY  %>"
			validate="Report Entered By,string,yes" tabindex=1>

			<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
			for (MasEmployee masEmployeecode : employeeList) {
				String employeeFirsName="";
				String employeeMiddleName="";
				String employeeLastName="";

				if(masEmployeecode.getEmpCategory() != null){
					//if(masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForParaMedical) || masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
						if(masEmployeecode.getFirstName()!=null)
						{
							employeeFirsName=masEmployeecode.getFirstName();
						}
						if(masEmployeecode.getMiddleName()!=null)
						{
							employeeMiddleName=masEmployeecode.getMiddleName();
						}
						if(masEmployeecode.getLastName()!=null)
						{
							employeeLastName=masEmployeecode.getLastName();
						}
				if (userId .equals(masEmployeecode.getId())) {
		%>
			<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
				-
				<%=employeeFirsName%>
				<%=employeeMiddleName%>
				<%=employeeLastName%></option>
			<%}else{ %>
			<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
				-
				<%=employeeFirsName%>
				<%=employeeMiddleName%>
				<%=employeeLastName%></option>
			<%	}	}}//}	%>
		</select>
		<div class="clear"></div>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<label>Sample Validated Date</label>
		<%}else{ %>
		<label>Report Collection Date</label>
		<%}%>
		<%if(dgDetails.getSampleCollectionHeader().getSampleValidationDate() != null){ %>
		<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getSampleValidationDate()) %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<label>Sample Validated Time</label>
		<%}else{ %>
		<label>Report Collection Time</label>
		<%} %>
		<%if(dgDetails.getSampleCollectionHeader().getSampleValidationTime() != null){ %>
		<label class="value"><%=dgDetails.getSampleCollectionHeader().getSampleValidationTime() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<label>Sample Validated By</label>
		<%}else{ %>
		<label>Report Collected By</label>
		<%} %>
		<%if(dgDetails.getSampleCollectionHeader().getValidatedBy() != null) {
%>
		<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
			value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getId() %>" />
		<label class="value"> <%=dgDetails.getSampleCollectionHeader().getValidatedBy().getFirstName()+" "+ dgDetails.getSampleCollectionHeader().getValidatedBy().getLastName() %></label>
		<%}else { %>
		<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
			value="" /> <label class="value">-</label>
		<%} %>
		<div class="clear"></div>
		<label>Brief Clinical Notes</label>
		<%if(dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
		<label class="valueAuto"><%=dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<div class="clear"></div>
		<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
			name="pageNo" id="pageNo" value="<%=pageNo%>" />
	</div> --%>
	<h4>Result Entry Details</h4> 
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<%
	 String resultSeqNo="";
		if(map.get("resultSeqNo") != null){
			resultSeqNo = (String)map.get("resultSeqNo");
		}
	%>
		<label>&nbsp;&nbsp;Date</label> <label class="value"><%=date%></label>
		<input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"
			value="<%=date%>" /> <input type="hidden"
			name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" /> <input
			type=hidden name="<%=RESULT_NO %>" value="<%=resultSeqNo %>"
			title="Result No." id="<%=RESULT_NO %>"/> <label><span>*</span>Entered By</label>
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
		<label class="valueAuto"><%=empFName+" "+empMName+" "+empLName%></label>
		<input type="hidden" name="<%=RESULT_ENTERED_BY%>" value="<%=empId%>" id="<%=RESULT_ENTERED_BY%>"/>
		<%-- <select
			name="<%= RESULT_ENTERED_BY %>" id="resultEnteredById"
			validate="Result Entered By,string,yes" tabindex=1>
			<option value="">Select</option>
			<%
		Users user = (Users)session.getAttribute("users");
		Integer userId =user.getEmployee().getId();
			for (MasEmployee masEmployeecode : employeeList) {
				String employeeFirsName="";
				String employeeMiddleName="";
				String employeeLastName="";

				if(masEmployeecode.getEmpCategory() != null){
					//if(masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForParaMedical) || masEmployeecode.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
						if(masEmployeecode.getFirstName()!=null)
						{
							employeeFirsName=masEmployeecode.getFirstName();
						}
						if(masEmployeecode.getMiddleName()!=null)
						{
							employeeMiddleName=masEmployeecode.getMiddleName();
						}
						if(masEmployeecode.getLastName()!=null)
						{
							employeeLastName=masEmployeecode.getLastName();
						}
				if (userId .equals(masEmployeecode.getId())) {
		%>
			<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
				-
				<%=employeeFirsName%>
				<%=employeeMiddleName%>
				<%=employeeLastName%></option>
			<%}else{ %>
			<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
				-
				<%=employeeFirsName%>
				<%=employeeMiddleName%>
				<%=employeeLastName%></option>
			<%	}	}}//}	%>
		</select> --%>
		<script type="text/javascript">
		var resultEnteredBy = document.getElementById('resultEnteredById');
		resultEnteredBy.setAttribute("validate","Result Prepared By,string,yes");
	</script>

		<div class="clear"></div>
		<div class="clear"></div>
		<label>Clinical Notes</label>
		<%if(dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
		<label class="valueAuto"><%=dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
			name="pageNo" id="pageNo" value="<%=pageNo%>" />
		<div class="clear"></div>
	</div>
	<div class="paddingTop15"></div>
	<!-- Block Three Ends -->
	<div class="clear"></div>
	<!-- Table Starts -->

	<div class="tableHolderAuto">
		<table border="0" cellspacing="0" width="100%" cellpadding="0">

			<tr>
				<th width=7%>S.No.</th>
				<th scope="col">Test Name</th>

				<%

Set<DgMasInvestigation> masSet= new HashSet<DgMasInvestigation>();
Set<DgTemplate> templateSet= new HashSet<DgTemplate>();
DgMasInvestigation masInv = new DgMasInvestigation();
String normalValue="";
String charge="";
int chargeId=0;
int investigationId=0;
String resultType="";
byte result[]=null;
int i =0;
for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
	masInv = dgCollection.getInvestigation();
	templateSet = masInv.getDgTemplates();

	if(dgCollection.getInvestigation().getChargeCode()!= null)
	{
		charge=dgCollection.getInvestigation().getChargeCode().getChargeCodeName();
		chargeId=dgCollection.getInvestigation().getChargeCode().getId();
		investigationId =dgCollection.getInvestigation().getId();
		resultType = dgCollection.getInvestigation().getInvestigationType();
	}
 	i++;

%>

				<tr>

					<td name="<%=SR_NO%>"><%=i%></td>

					<td><input name="<%=RESULT_TYPE %>" id="<%=RESULT_TYPE %>"
						value="t" type="hidden"><input
							name="<%=INVESTIGATION_ID %>" id="<%=INVESTIGATION_ID %>"
							value=<%= investigationId%> type="hidden"><input
								name="<%=CHARGE_CODE_ID %>" id="<%=CHARGE_CODE_ID %>"
								value=<%= chargeId%> type="hidden"> <input
									name="<%=DG_SAMPLE_DETAIL_ID %>" id="<%=DG_SAMPLE_DETAIL_ID %>"
									value=<%= dgCollection.getId()%> type="hidden"> <%if(dgCollection.getInvestigation().getInvestigationName() !=null){%>
										<label name="<%=INVESTIGATION_NAME %>" /><%=dgCollection.getInvestigation().getInvestigationName() %></label>
										<%}else { %> <label name="<%=INVESTIGATION_NAME %>" /></label> <%} %></td>
				</tr>
		</table>
	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<%
	Set<DgHistoSampleCollectionDetails> histoCollectionDetailsSet=sampleCollectionList.get(0).getSampleCollectionHeader().getDgHistoSampleCollectionDetails();
	if(histoCollectionDetailsSet.size()>0){int count=1;%>
	<div class="cmntable">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<th scope="col">S.No.</th>
				<th scope="col">Test Name</th>
				<th scope="col">Section Type</th>
				<th scope="col">Sample</th>
				<th scope="col">Container</th>
				<th scope="col">Remark</th>
				<th scope="col">Identification No.</th>
				<!-- <th scope="col">Reject</th> -->
				<th scope="col">&nbsp;</th>
			</tr>
			<%for(DgHistoSampleCollectionDetails histoObj:histoCollectionDetailsSet){%>
			<tr>
				<td><%=count%></td>
				<td><label><%=histoObj
						.getChargeCode().getChargeCodeName()%></label></td>
				<%if("S".equalsIgnoreCase(histoObj.getOrderStatus())){%>
				<td><label>Specimen</label></td>
				<%}else if("G".equalsIgnoreCase(histoObj.getOrderStatus())){%>
				<td><label>Gross</label></td>
				<%}else if("B".equalsIgnoreCase(histoObj.getOrderStatus())){%>
				<td><label>Block</label></td>
				<%}else{%>
				<td><label>Slide</label></td>
				<%}%>

				<td><label><%=histoObj
									.getSample().getSampleDescription()%></label></td>
				<td>1</td>
				<td><label><%=histoObj
									.getRemarks()%></td>
				<td><%=histoObj.getIdentificationNo()%></td>
				<!-- <td>//Rject To
				<select name="rejectTo" id="rejectToId">
				<option value="">Select</option>
				<option value="RG">ReGrossing</option>
				<option value="RB">ReBlocking</option>
				<option value="RS">ReSliding</option>
				<option value="RST">ReStaining</option>
				</select>
				</td> -->
				<td>
				<input type="button" value="Reject" onclick="rejectSample(<%=histoObj.getId()%>)" />
				
				</td>
				
			</tr>
			<%count++;}%>
		</table>
	</div>
	<%} %>

	<div class="clear"></div>
	<label class="auto">Result</label> <input type="file" name="<%=UPLOAD_FILENAME%>" id="fileNameId" class="browse" size="50" />
		
		<input type="hidden" name="fileName" id="fileName"/>
	<div class="clear"></div>
	<h4>
		<span>(Only Html Format Accepted !)</span>
	</h4>
	<div class="clear"></div>
	<div id="hiddenTextArea" style="display: none">
		<textarea id="appendedHtml" name="appendedHtml"><%=appendedHtml %></textarea>
	</div>
	<!--Rich text editor-->
	<div id="rtf">
		<%if(templateSet.size()>0){ 
  for(DgTemplate dgTemp : templateSet){
	result = dgTemp.getResult();
	
 %>
		<%if(dgTemp.getResult() != null&&browse.equals("")){
	 %>
		<textarea id="abc" name="<%=TEMP_RESULT %>"
			class="tableTextareaEditor"><%=new String(dgTemp.getResult())%>  </textarea>

		<%}else if(dgTemp.getResult() != null&&!browse.equals("")){ 
	
	%>
		<textarea value="" id="abc" name="<%=TEMP_RESULT %>"
			class="tableTextareaEditor"> </textarea>
		<%} %>
		<%} 
}if(templateSet.size()==0 && browse.equals("")) {
	%>
		<textarea value="" id="abc" name="<%=TEMP_RESULT %>"
			class="tableTextareaEditor">  </textarea>
		<% }
 if(templateSet.size()==0 && !browse.equals("")) {
	 %>
		<textarea value="" id="abc" name="<%=TEMP_RESULT %>"
			class="tableTextareaEditor"> </textarea>
		<% }%>
	</div>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<%if(RequisitionFrom2!=null && !RequisitionFrom2.equalsIgnoreCase("OPD")){ %>
	<label>Additional Remarks</label>
	<%if(dgCollection.getRemarks() != null){ %>
	<textarea id="<%=ADDITIONAL_REMARKS%>"
		value="<%=dgCollection.getRemarks()==null?"":dgCollection.getRemarks()%>"
		onkeyup="chkLength(this,100);" name="<%=ADDITIONAL_REMARKS %>"></textarea>
	<script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgCollection.getRemarks()%>"</script>
	<%}else{ %>
	<textarea value="" onkeyup="chkLength(this,100);"
		id="<%=ADDITIONAL_REMARKS %>" name="<%=ADDITIONAL_REMARKS %>"></textarea>
	<%} %>
	
	<script type="text/javascript">
	function getItemStock() { 
		var itemId = document
				.getElementById('filmSizeUsedResponse').value;
		
		submitProtoAjaxForStockItem('sampleCollection',
				'/hms/hms/investigation?method=getItemStock&itemId='
						+ itemId+'&'+csrfTokenName+'='+csrfTokenValue);
	}
	function submitProtoAjaxForStockItem(formName, action) {

		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.' + formName)
		obj.action = action;
		var url = action + "&" + getNameAndData(formName);

		new Ajax.Updater('testDivItem', url, {
			asynchronous : true,
			evalScripts : true
		});
		return true;
	}
	function checkFilmUsed() {
		var filmUsed = document.getElementById('filmSizeUsed').value;
		if (filmUsed != "") {
			return true;
		} else {
			//alert("Please Enter Film Size Used");
			return true;
		}
	}
	function checkStock() {

		var filmVal = document.getElementById('filmUsed').value;
		var totalStock = document.getElementById('totalStock').value;

		filmVal = parseInt(filmVal);
		totalStock = parseInt(totalStock);
		if (filmVal > totalStock) {
			alert("Film value is more than Stock Qty.")
			document.getElementById('filmUsed').value = 0;
		}

	}
</script>
	<%-- <label>Film Size Used</label> <select name="filmSizeUsed"
	id="filmSizeUsed" validate="Film Size Used,string,no" tabindex=1>
	<option value="None">Select</option>
	<option value="17X14">17"*14"</option>
	<option value="15X12">15"*12"</option>
	<option value="12X10">12"*10"</option>
	<option value="10X8">10"*8"</option>

</select>
--%>
	<label><span></span>Film Size Used</label> <input type="text"
		id="filmSizeUsed" name="filmSizeUsed"
		validate="Film Size Used,string,no" tabindex=1
		onblur="getItemStock();">
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('filmSizeUsed','ac2update','investigation?method=getItemList',{parameters:'requiredField=filmSizeUsed'});
			</script>
		<div id="testDivItem">
			<label>Film Used</label> <select id="filmUsed1" name="filmUsed1"
				id="filmUsed" validate="Film Used,string,no" tabindex=1">
				<option value="">Select</option>
				<%for(int k=1;k<=9;k++){ %>
				<option value=<%=k%>><%=k%></option>
				<%} %>
			</select>
		</div>
		<%} %><%} %>
		<div class="clear"></div> <!-- Table Ends -->
		<div class="division"></div> 
		
		<%if(RequisitionFrom2!=null && !RequisitionFrom2.equals("OPD")){ %>
		<input type="button" class="button"
		value="Submit" id="addbutton"
		onclick="if(checkFilmUsed()){formSubmission();window.close();}" align="right" /> 
		<%}else{ %>
		<input type="button" class="button"
		value="Submit" id="addbutton"
		onclick="formSubmission();window.close();" align="right" /> 
		<%} %>
		<input
		name="Reset" type="button" id="reset" class="buttonHighlight"
		value="Reset" onclick="resetResult();" /> <!--Bottom labels starts-->
		<div class="clear"></div>
		<div class="division"></div>
		<div class="bottom">
			<label>Changed By</label> <label class="value"><%=userName%></label>

			<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
				Time</label> <label class="value"><%=time%></label>
		</div>
		<%
	  int hinId_OPD =0;
	  String RequisitionFrom = "NA";
	 if(request.getParameter("hinId_OPD") != null)
	 {
		 hinId_OPD = Integer.parseInt(request.getParameter("hinId_OPD"));
	 }
	 if(request.getParameter("RequisitionFrom") != null)
	 {
		 RequisitionFrom = request.getParameter("RequisitionFrom");
	 }
	
	%>
	
	<input type="hidden" value="<%out.print(hinId_OPD); %>" id="hinId_OPD" name="hinId_OPD" />
	<input type="hidden" value="<%out.print(RequisitionFrom); %>" id="RequisitionFrom" name="RequisitionFrom" />
		<div class="clear"></div>
		<div class="paddingTop40"></div> <!--Bottom labels starts-->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>
function rejectSample(val){
	alert(val);
	alert(<%=sampleCollectionDetailId%>);
	submitForm('sampleCollection','/hms/hms/investigation?method=rejectSampleHisto&sampleDetailsId='+val+'&sampleHeaderId=<%=sampleCollectionDetailId%>&'+csrfTokenName+'='+csrfTokenValue);
	
}
</script>

<script language="Javascript">
function formSubmission(){ 
	
	if(document.getElementById('fileNameId').value != "")
		
	{
		var fname = document.getElementById('fileNameId').value;	
		var ind1 = fname.lastIndexOf("\\");
		var filename = fname.substring(ind1+1);
		document.getElementById("fileName").value=filename;
	}
	
	//alert("filename="+filename);
	
	
	
   WYSIWYG.updateTextArea("abc");
var DG_SAMPLE_DETAIL_ID=document.getElementById("<%=DG_SAMPLE_DETAIL_ID%>").value;
var RESULT_NO=document.getElementById("<%=RESULT_NO%>").value;
//var filmSizeUsedResponse=document.getElementById("filmSizeUsedResponse").value;
//var filmUsed=document.getElementById("filmUsed").value;

<%-- var REMARKS=document.getElementById("<%=REMARKS%>").value; --%>
var MAIN_CHARGECODE_ID=document.getElementById("<%=MAIN_CHARGECODE_ID%>").value;
var DEPARTMENT_ID=document.getElementById("<%=DEPARTMENT_ID%>").value;
var SUB_CHARGECODE_ID=document.getElementById("<%=SUB_CHARGECODE_ID%>").value;
var HIN_ID=document.getElementById("<%=HIN_ID%>").value;
var INPATIENT_ID=document.getElementById("<%=INPATIENT_ID%>").value;
var SAMPLE_COLLECTION_ID=document.getElementById("<%=SAMPLE_COLLECTION_ID%>").value;
var EMPLOYEE_ID=document.getElementById("<%=EMPLOYEE_ID%>").value;
var RESULT_ENTERED_BY=document.getElementById("<%=RESULT_ENTERED_BY%>").value;
var SAMPLE_COLLECTION_ID=document.getElementById("<%=SAMPLE_COLLECTION_ID%>").value;
var RESULT_TYPE=document.getElementById("<%=RESULT_TYPE%>").value;
var test2=document.getElementById("abc").value;
var ADDITIONAL_REMARKS="";
	if(document.getElementById("<%=ADDITIONAL_REMARKS%>")!=null){
		ADDITIONAL_REMARKS=document.getElementById("<%=ADDITIONAL_REMARKS%>").value;
	}
var INVESTIGATION_ID=document.getElementById("<%=INVESTIGATION_ID%>").value;

					submitForm("sampleCollection",
							"investigation?method=submitResultEntryForTempelate&dgSampleDetailId="
									+ DG_SAMPLE_DETAIL_ID + "&resultNo="
									+ RESULT_NO + "&filmSizeUsedResponse="
									+ 9597 + "&filmUsed="
									+ 1 + "&mainChargecodeId="
									+ MAIN_CHARGECODE_ID + "&departmentId="
									+ DEPARTMENT_ID + "&subChargeCodeId="
									+ SUB_CHARGECODE_ID + "&hinId=" + HIN_ID
									+ "&inpatientId=" + INPATIENT_ID
									+ "&sampleCollectionId="
									+ SAMPLE_COLLECTION_ID + "&employeeId="
									+ EMPLOYEE_ID + "&resultEnteredBy="
									+ RESULT_ENTERED_BY + "&resultType="
									+ RESULT_TYPE + "&fileName="+fileName+"&additionalRemarks="+ ADDITIONAL_REMARKS + "&investigationId="+ INVESTIGATION_ID + "&"+csrfTokenName+'='+csrfTokenValue)

				}
			</script>
<!--main content placeholder ends here-->
