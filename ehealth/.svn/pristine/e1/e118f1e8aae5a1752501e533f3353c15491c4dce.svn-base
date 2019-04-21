<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgHistoSampleCollectionDetails"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.DgCollectionCenter"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>

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
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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
 
<!-- Mulipart  remove for sort period of time due to problem in multipart unexcepted error -->
<!-- <form name="resultValidationEntry" method="post"
	ENCTYPE="multipart/form-data" action="">-->
	
<form name="resultValidationEntry" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
	List<UploadDocuments> documentList = new ArrayList<UploadDocuments>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	///List<Patient> patientList = new ArrayList<Patient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
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
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	int deptId= 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}

	String deptName ="";
	String appendedHtml ="";
	
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		  // out.println(message);
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("appendedHtml") != null){
		
		appendedHtml = (String)map.get("appendedHtml");
		//System.out.println("appendedHtml in jsp "+appendedHtml);
	}
	
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	Map<String,Object> detailsMap = new HashMap<String,Object>();
	if(map.get("detailsMap") !=null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	
	if(map.get("documentList") != null){
		documentList=(List<UploadDocuments>)map.get("documentList");
	}
	try{
		if(map.get("resultList") != null){
			resultList=(List)map.get("resultList");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	//out.print("documentList="+documentList.size());
	
	Set<DgResultEntryDetail> dgResultDtSet = new HashSet<DgResultEntryDetail>();
	for(DgResultEntryHeader dgResultHeader : resultList){
		dgResultDtSet = dgResultHeader.getDgResultEntryDetails();
	}
	int hospitalId = 0;
	MasRelation masRelation = new MasRelation();
    DgResultEntryHeader dgResultEntryHeader= new DgResultEntryHeader();
	MasRank masRank = new MasRank();
	String admissionNumber = "";
	int departmentId =0;
	int inpatientId =0;
	int hinId = 0;
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	String number="";
	if(resultList != null)
	{
		dgResultEntryHeader = (DgResultEntryHeader) resultList.get(0);
		hinId =dgResultEntryHeader.getHin().getId();
		inpatientSet=dgResultEntryHeader.getHin().getInpatients();
	}
	    MasDepartment masDepartment=new MasDepartment();
		DgResultEntryHeader dgresultHeader=new DgResultEntryHeader();
		DgResultEntryDetail dgresultDetails=new DgResultEntryDetail();
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
	<%if(deptId == 49){ %>
	<div class="titleBg">
		<h2>Report Validation</h2>
	</div>
	<%}else{ %>
	<div class="titleBg">
		<h2>Result Validation</h2>
	</div>
	<%} %>
	<%
	String subDept = "";String dept="";
int SubChargeId=0;
int mainChargeId=0;
		for(DgResultEntryDetail dgDetail :dgResultDtSet){
			if(dgDetail.getInvestigation() != null){
			subDept = dgDetail.getInvestigation().getSubChargecode().getSubChargecodeName();
			dept = dgDetail.getInvestigation().getMainChargecode().getMainChargecodeName();
			SubChargeId=dgDetail.getInvestigation().getSubChargecode().getId();
			mainChargeId=dgDetail.getInvestigation().getMainChargecode().getId();
%>
	<%
 	}
 	}%><div class="Block">
		<input name="<%=SUB_CHARGECODE_ID %>" id="subChargeCodeId"
			type="hidden" value="<%=SubChargeId %>" /> <input
			name="<%=MAIN_CHARGECODE_ID %>" id="mainChargecodeId" type="hidden"
			value="<%=mainChargeId %>" />
		<div id="hiddenTextArea" style="display: none">
			<textarea id="appendedHtml" name="appendedHtml"><%=appendedHtml
 %></textarea>
			<input type="hidden" id="browse" name="browse" value="">
		</div>
		<div class="Clear"></div>
		<%-- <%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
		<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label class="NoWidth">Order Time</label>
		<%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
		<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label class="NoWidth">Order No.</label>
		<%if(dgresultHeader.getSampleCollectionHeader().getOrder() != null){ %>
		<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label class="NoWidth">Order By</label>
		<%if(dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
		<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %> --%>
	</div>
	<div class="Clear"></div>
	<input type="hidden" name="<%=RESULT_ID %>" id="resultId"
		value="<%=dgresultHeader.getId() %>" />
	<!--Block One Starts-->
	<!-- <h4>Service Personnel Details</h4> -->
	<%-- <div class="Block">
		<div class="Clear"></div>
		<label class="common">Service Type</label>
		<%
				if(dgResultEntryHeader.getHin().getServiceType() != null){
			%>
		<label class="value"><%=dgResultEntryHeader.getHin().getServiceType().getServiceTypeName()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<% }%>
		<label class="common">Service No</label>
		<%
				if(dgResultEntryHeader.getHin().getServiceNo() != null && !(dgResultEntryHeader.getHin().getServiceNo().equals(""))){
			%>
		<label class="value"><%=dgResultEntryHeader.getHin().getServiceNo()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<%}%>
		<label class="common">Service Status</label>
		<%if(dgResultEntryHeader.getHin().getServiceStatus() != null){
			%>
		<label class="value"><%= dgResultEntryHeader.getHin().getServiceStatus().getServiceStatusName()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<% }%>
		<label class="common">Relation</label>
		<%
				if(dgResultEntryHeader.getHin().getRelation() != null){
			%>
		<label class="value"><%=dgResultEntryHeader.getHin().getRelation().getRelationName()%></label>
		<%}else{ %>
		<label class="value">-</label>
		<% }%>
		<div class="Clear"></div>
		<label>Ser. Per. Name</label>
		<%
				if(dgResultEntryHeader.getHin().getSFirstName() != null  && !(dgResultEntryHeader.getHin().getSFirstName().equals(""))){
				
					String sMiddleName = "";
					String sLastName = "";
					if(dgResultEntryHeader.getHin().getSMiddleName() != null){
						sMiddleName = dgResultEntryHeader.getHin().getSMiddleName();
					}
					if(dgResultEntryHeader.getHin().getSLastName() != null){
						sLastName = dgResultEntryHeader.getHin().getSLastName();
					}
			 %>
		<label class="value"><%=dgResultEntryHeader.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName%></label>
		<%}else{ %>
		<label class="value">-</label>
		<% }%>
		<label class="common">Rank</label>
		<%
			if(dgResultEntryHeader.getHin().getRank() != null){
			%>
		<label class="value"><%=dgResultEntryHeader.getHin().getRank().getRankName()%></label>
		<%} else{ %>
		<label class="value">-</label>
		<% }%>
		<label class="common">Unit</label>
		<%
if(dgResultEntryHeader.getHin().getUnit() != null){
%>
		<label class="value"><%= dgResultEntryHeader.getHin().getUnit().getUnitName()%></label>
		<%} else{ %>
		<label class="value">-</label>
		<% }%>
		<label class="common">Trade</label>
		<%
if(dgResultEntryHeader.getHin().getTrade() != null){
%>
		<label class="value"><%=  dgResultEntryHeader.getHin().getTrade().getTradeName()%></label>
		<%} else{ %>
		<label class="value">-</label>
		<% }%>
		<div class="Clear"></div>
	</div> --%>

	<!--Block one Ends-->
	<!--Block Two Starts-->
	<div class="Clear"></div>
	<h4>Patient Details</h4>
	<%-- <div class="Block">
		<label class="NoWidth">UHID No.</label> <label class="value"><%=dgResultEntryHeader.getHin().getHinNo() %></label>

		<%
					String middleName = "";
					String lastName = "";
					if(dgResultEntryHeader.getHin().getPMiddleName() != null){
						middleName = dgResultEntryHeader.getHin().getPMiddleName();
					}
					if(dgResultEntryHeader.getHin().getPLastName() != null){
						lastName = dgResultEntryHeader.getHin().getPLastName();
					}
					
					%>
		<label class="NoWidth"> Patient Name</label> <label class="value"><%=dgResultEntryHeader.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>

		<label class="noWidth">Gender</label> <label class="value"><%=dgResultEntryHeader.getHin().getSex().getAdministrativeSexName() %></label>
		<div class="Clear"></div>
		<%
		String age = "";
		String currentAge = "";
		age = dgResultEntryHeader.getHin().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, dgResultEntryHeader.getHin().getRegDate());
		%>
		<label class="NoWidth">Age</label> <label class="value"><%=currentAge%></label>
		<div class="Clear"></div>
	</div> --%>
	<div class="Block">
		<div class="clear"></div>
		<label>UHID No.</label>
		<%
String patientName = "";
String age  = "";
String sex = "";
String departmentName = "";
if(dgResultEntryHeader.getHin() == null){
	Set<DgOrderdt> set = new HashSet<DgOrderdt>();
	DgOrderhd orderhd = dgResultEntryHeader.getSampleCollectionHeader().getOrder();
	set = orderhd.getDgOrderdts();
	
	if(orderhd.getDepartment() != null)
		departmentName = 	orderhd.getDepartment().getDepartmentName();
	
	BlOpBillHeader  billHeader = new BlOpBillHeader();
	for(DgOrderdt orderDt : set){
		if(orderDt.getBill() != null){
		  billHeader = orderDt.getBill();
		  	patientName=billHeader.getPatientName();
			age=billHeader.getAge();
			sex=billHeader.getSex().getAdministrativeSexName();
		}
	}
}



%>
		<%if(dgResultEntryHeader.getHin()!= null){ %>
		<label class="value"><%=dgResultEntryHeader.getHin().getHinNo() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<%
	if(dgResultEntryHeader.getHin()!= null){

			String middleName = "";
					String lastName = "";
					if(dgResultEntryHeader.getHin().getPMiddleName() != null){
						middleName = dgResultEntryHeader.getHin().getPMiddleName();
					}
					if(dgResultEntryHeader.getHin().getPLastName() != null){
						lastName = dgResultEntryHeader.getHin().getPLastName();
					}

					%>
		<label>Patient Name</label> <label class="value"><%=dgResultEntryHeader.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>
		<%}else{ %>
		<label>Patient Name</label> <label class="value"><%=patientName%></label>

		<%} %>
		<%if(dgResultEntryHeader.getHin()!= null){ %>
		<label>Gender</label> <label class="value"><%= dgResultEntryHeader.getHin().getSex().getAdministrativeSexName()%></label>
		<%}else{ %>
		<label>Gender</label> <label class="value"><%=sex%></label>
		<%} %>
		<div class="clear"></div>
		<label>Department</label> <label class="value"><%=departmentName %></label>
		<%-- <%
		String bloodGroup="-";
		if(dgResultEntryHeader.getHin().getBloodGroup()!=null && dgResultEntryHeader.getHin().getBloodGroup().getBloodGroupCode()!=null){
			bloodGroup=dgResultEntryHeader.getHin().getBloodGroup().getBloodGroupCode();
		}
		%>
		<label>Blood Group</label> <label class="value"><%=bloodGroup%></label> --%>
		<label>Mobile No</label>
		<%String mobileNumber="-"; 
			if(dgResultEntryHeader.getHin().getMobileNumber()!=null && !"".equalsIgnoreCase(dgResultEntryHeader.getHin().getMobileNumber().trim())){
				mobileNumber=dgResultEntryHeader.getHin().getMobileNumber();
			}
			String fName="";
			String lName="";
			String mName="";
			if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy()!=null){
			if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName()!=null){
				fName=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName();
			}if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName()!=null){
				lName=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName();
			}
			if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName()!=null){
				mName=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName();
			} }%>
		<label class="value"><%=mobileNumber%></label>
		<div class="clear"></div>
		<%  
			String ipNo="-";
			String ward="-";
			String bedNo="-";
			if(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getInpatient()!=null){
				ipNo=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getInpatient().getAdNo();
				ward=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getInpatient().getDepartment().getDepartmentName();
				bedNo=dgResultEntryHeader.getSampleCollectionHeader().getOrder().getInpatient().getBed().getBedNo();
			%>
		<label>IP No</label> <label class="value"><%=ipNo%></label> <label>Ward</label>
		<label class="value"><%=ward%></label> <label>Bed No</label> <label
			class="value"><%=bedNo%></label>
		<div class="clear"></div>
		<%}%>
		<label>Doctor Name</label> <label class="value"><%=fName+" "+mName+" "+lName %></label>
		<div class="clear"></div>
	</div>
	<%
	if(dgResultEntryHeader.getInpatient() != null){
	%>
	<input type="hidden" name="<%=INPATIENT_ID %>" id="inpatientId"
		value="<%=dgResultEntryHeader.getInpatient().getId()%>" />
	<%} else{%>
	<input type="hidden" name="<%=INPATIENT_ID %>" id="inpatientId"
		value="" />
	<%} %>
	<input type="hidden" name="<%=DEPARTMENT_ID %>" id="departmentId"
		value="<%=dgResultEntryHeader.getDepartment().getId()%>" /> <input
		type="hidden" name="<%=HIN_ID %>" id="hinId"
		value="<%=dgResultEntryHeader.getHin().getId() %>" /> <input
		type="hidden" name="<%=HIN_NO %>" id="hinNo"
		value="<%=dgResultEntryHeader.getHin().getHinNo() %>" />
	<!--Block Two Ends-->
	<!-- Block Three Starts -->
	<h4>Acceptance Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<label>Date</label>
		<%if(dgresultHeader.getResultDate() != null){ %>
		<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getResultDate()) %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label>Accepted By:</label>
		<%if(dgresultHeader.getEmployee() != null) {%>
		<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
			name="<%=RESULT_ENTERED_BY %>"
			value="<%=dgresultHeader.getEmployee().getFirstName() %>" />
		<%
			String VFName="";
			String VMName="";
			String VLName="";
			if(dgresultHeader.getEmployee().getFirstName()!=null){
				VFName=dgresultHeader.getEmployee().getFirstName();
			}if(dgResultEntryHeader.getEmployee().getMiddleName()!=null){
				VMName=dgResultEntryHeader.getEmployee().getMiddleName();
			}if( dgresultHeader.getEmployee().getLastName() !=null){
				 VLName=dgresultHeader.getEmployee().getLastName() ;
			}
			%>
		<label class="value"> <%=VFName+" "+ VMName+" "+ VLName %></label>
		<%}else { %>
		<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
			name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="value">
			-</label>
		<%} %>
		<div class="clear"></div>
	</div>
	<h4>Result Entry Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<label>Date</label>
		<%if(dgresultHeader.getResultDate() != null){ %>
		<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgresultHeader.getResultDate()) %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<label>Entered By:</label>
		<%if(dgresultHeader.getEmployee() != null) {%>
		<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
			name="<%=RESULT_ENTERED_BY %>"
			value="<%=dgresultHeader.getEmployee().getFirstName() %>" />
		<%
			String EFName="";
			String EMName="";
			String ELName="";
			if(dgresultHeader.getEmployee().getFirstName()!=null){
				EFName=dgresultHeader.getEmployee().getFirstName();
			}if(dgResultEntryHeader.getEmployee().getMiddleName()!=null){
				EMName=dgResultEntryHeader.getEmployee().getMiddleName();
			}if( dgresultHeader.getEmployee().getLastName() !=null){
				ELName=dgresultHeader.getEmployee().getLastName() ;
			}
			%>

		<label class="value"> <%=EFName+" "+EMName+" "+ELName%></label>
		<%}else { %>
		<input type="hidden" id="<%=RESULT_ENTERED_BY %>"
			name="<%=RESULT_ENTERED_BY %>" value="" /> <label class="value">
			-</label>
		<%} %>

		<div class="clear"></div>
	</div>
	<!-- <h4>Result Validation Details1</h4> -->
	<div class="clear"></div>
	 <div class="Block">
		<input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"
			id="sampleCollectionDate" value="<%=date%>" /> <input type="hidden"
			name="<%=SAMPLE_COLLECTION_TIME %>" id="sampleCollectionTime"
			value="<%=time%>" /> <input type="hidden" name="<%=RESULT_NO %>"
			id="resultNo" value="<%=dgResultEntryHeader.getResultNo() %>" />


	<div class="Clear"></div>
		<label class="noWidth">Report Validated Date</label> <label
			class="value"><%=date%></label> <label class="noWidth">Report
			Validated Time</label> <label class="value"><%=time%></label> <label
			class="noWidth"><span>*</span>Report Validated By</label>
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
		<input type="hidden" name="<%=RESULT_VALIDATED_BY %>"
			value="<%=empId%>" id="resultValidatedBy" /> 


		<%-- <select
			id="resultValidatedBy" name="<%= RESULT_VALIDATED_BY %>"
			validate="Report Validated By,string,yes" tabindex=1>
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
			<%	}	}}//}%>
		</select> --%>


	<%-- 	<div class="Clear"></div>
		<label class="noWidth">Brief Clinical Notes</label>
		<%if(dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
		<label class="value"><%=dgresultHeader.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
		<%}else{ %>
		<label class="value">-</label>
		<%} %>
		<div class="Clear"></div>
		<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
			name="pageNo" id="pageNo" value="<%=pageNo%>" />
	</div> --%>

	<!-- Block Three Ends -->
	<div class="Clear"></div>
	<!-- Table Starts -->
	<div class="Clear"></div>
	<h4>Result Validation</h4>
	<div class="tableHolderAuto" style="padding-top: 1px;">
		<table border="0" width="100%" cellpadding="0">

			<tr>
				<%if(deptType.equalsIgnoreCase("DIAG")){ %>
				<th width="7%">Diag. No.</th>
				<%}else{  %>
				<th width="7%">S No.</th>
				<%} %>
				<th width="7%">Service</th>
				<th width="4%">Validated</th>
				<th width="4%">SMS Abnormal Result</th>
			</tr>
			<% int i =0;
    for(DgResultEntryDetail dgDetail :dgResultDtSet){
    i++;
    %>
			<tr>
				<td>
					<%-- <%if(dgDetail.getSampleCollectionDetails() != null && dgDetail.getSampleCollectionDetails().getDiagNo()!=null){ %>
					<label name="<%=DIAGNOSIS_NO %>" id="diagnosisNo"><%=dgDetail.getSampleCollectionDetails().getDiagNo()%></label>
					<%}  %> --%>
					<%=i %>
				</td>
				<td width="7%"><input name="resultType" id="resultType"
					type="hidden" size="10" value="<%=dgDetail.getResultType() %>"
					readonly /> 
					
					<%if(dgDetail.getInvestigation() !=null){ %> <input
					name="<%=INVESTIGATION_ID %>" type="hidden" id="investigationId"
					size="5" value="<%=dgDetail.getInvestigation().getId() %>" readonly />
					<label name="chargeCode" type="text" size="10"</label><%=dgDetail.getInvestigation().getInvestigationName()%>
					<%}else { %> <label name="chargeCode" type="text" size="10"</label> <%} %></td>
				<td width="4%">
					<% if(dgDetail.getValidated() != null) {
              %> <input id="checkId" name="<%=VALIDATED%>"
					type="checkbox" checked="true" class="check" /> <%}else{ 
              System.out.println("in else"); %> <input id="checkId"
					name="<%=VALIDATED%>" type="checkbox" class="check" /> <%} %>
				</td>
				<td><input type="checkbox" name="sms"
					class="radioCheck" value="yes" id="smsButton" 
					align="right" /></td>
			</tr>
		</table>
	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<%
	Set<DgHistoSampleCollectionDetails> histoCollectionDetailsSet=dgresultHeader.getSampleCollectionHeader().getDgHistoSampleCollectionDetails();
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
				<td>-</td>
				<%if(histoObj.getRemarks()!=null && !"".equalsIgnoreCase(histoObj.getRemarks().trim())){%>
				<td><label><%=histoObj.getRemarks()%></td>
				<%}else{%>
				<td><label>-</td>
				<%}%>
				<td><%=histoObj.getIdentificationNo()%></td>
			</tr>
			<%count++;}%>
		</table>
	</div>
	<%} %>

	<div class="Clear"></div>
	
	
	<div id="rtf">
		<!--Rich text editor-->
		<%if(dgDetail.getResult() != null){ 
	  String templateData= new String  (dgDetail.getResult());
    %>
		<textarea id="abc" name="test2" class="tableTextareaEditor" value=""><%=templateData %></textarea>
		<%}else{ %>
		<textarea value="" id="abc" name="test2" class="tableTextareaEditor">  </textarea>
		<%} %>
	</div>

	<div class="Clear" style="padding-top: 12px;"></div>
	<label>View Upload Document</label>
	<%
	if(documentList.size() > 0){


	
		
			for(UploadDocuments uploadDocs : documentList){
	%>
		<a href="#" onclick="submitFormForButton('resultValidationEntry','investigation?method=viewUploadDocuments&uploadedDocumentId=<%=uploadDocs.getId()%>&filename=<%= uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%>')"><%=uploadDocs.getFileName()+"."+uploadDocs.getFileExtension()%>
	
		</a> 
		<input type="hidden" name="uploadId" value="<%=uploadDocs.getId()%>"/>
		
<input type="hidden" name="upload_filename" id="fileNameId" class="browse" tabindex=1/>
		
	<%}
	
		 %>

<%}%>
	<div class="division" style="padding-top: 12px;"></div>
	
	<label>Additional Remarks 2</label>
	
	<%if(dgDetail.getRemarks() != null){ %>
	<textarea value="<%=dgDetail.getRemarks() %>" maxlength="200"
		onkeyup="return ismaxlength(this)" id="additionalRemarks"
		name="<%=ADDITIONAL_REMARKS %>"></textarea>
	<script>document.resultValidationEntry.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgDetail.getRemarks()%>
		"
	</script>
	<%}else{ %>
	<textarea value="" maxlength="200" onkeyup="return ismaxlength(this)"
		id="additionalRemarks" name="<%=ADDITIONAL_REMARKS %>"></textarea>
	<%} %>
	<div class="clear"></div>
	<div class="division"></div>
	<input type="button" class="button" value="Submit"
		onclick="if(inputValidate()){formSubmission();};" align="right" /> <input
		name="Button" type="button" class="button" value="Reset"
		onclick="resetResult();" />
	<div class="Clear"></div>
	<div class="division" style="padding-top: 12px;"></div>
	<%}
    	%>
	<!-- Table Ends -->
	<!--Bottom labels starts-->
	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=date%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label>

		<div class="Clear"></div>

		<!-- <input type="button" class="button" value="Submit"
			onclick="if(inputValidate()){formSubmission();};" align="right" /> <input
			name="Button" type="button" class="button" value="Reset"
			onclick="resetResult();" /> -->

		<!--Bottom labels starts-->
		<!--main content placeholder ends here-->
	</div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>
</form>
<script>
function inputValidate(){

obj = document.getElementById('checkId');

if(!obj.checked){;
  alert("Please Validate The Report ")
 	}else{
			return true;
			}
				}
   
</script>
<script>

function resetResult(){
	document.getElementById('additionalRemarks').value="";
	document.getElementById('abc').value = "";
	}
</script>
<script language="javascript">
			function formSubmission() {
				var resultNo = document.getElementById("resultNo").value;
				var resultType = document.getElementById("resultType").value;
				var resultId = document.getElementById("resultId").value;
				var resultValidatedBy = document
						.getElementById("resultValidatedBy").value;
				var additionalRemarks = document
						.getElementById("additionalRemarks").value;
				var validated = document.getElementById("checkId").value;
				WYSIWYG.updateTextArea('abc');
				submitForm('resultValidationEntry',
						'investigation?method=submitResultValidationForTemplate&resultValidatedBy='
								+ resultValidatedBy + '&resultId=' + resultId
								+ '&resultType=' + resultType + '&resultNo='
								+ resultNo + '&additionalRemarks='
								+ additionalRemarks + '&validated=' + validated);

			}
		</script>
