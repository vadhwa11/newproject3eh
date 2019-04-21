<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<form name="sampleAcceptance" method="post" action="">

	<script type="text/javascript">
	function CheckAll(checkall)
	{
		var c = document.getElementById('counter').value;
		if(checkall.checked ){
			for (var i=1;i < c;i++) {
	  			if(document.getElementById('acceptedCheck'+i)!=null && document.getElementById('acceptedCheck'+i).disabled == false){
	  				document.getElementById('acceptedCheck'+i).checked =true;
	  				
	  				
	 			//	document.getElementById("modifyOrderDivId"+i).style.display='none';
	 				
	  			}
	  			document.getElementById("rejectAllButton").checked=false;
	  			document.getElementById('rejected'+i).checked=false;
	  			document.getElementById("reason"+i).value="";
 				document.getElementById("reason"+i).type="hidden";
	 			//document.getElementById("reason"+i).style.display='none';
	 		}
		}else{
			checkall.checked == false ;
		 	var i=1;
		 	for (;i < c;i++) {
		 		if(document.getElementById('acceptedCheck'+i)!=null){
		 			document.getElementById("acceptedCheck"+i).checked =false;
		 		}
	  			
	 	 	}
	 	}
	}

	function checkAllReject(checkAllRejected)
	{

		var c = document.getElementById('counter').value;
		if(checkAllRejected.checked ){
			for (var i=1;i < c;i++) {
	  			if(document.getElementById('acceptedCheck'+i)!=null && document.getElementById('acceptedCheck'+i).disabled == false){
	  				
	  				document.getElementById('acceptedCheck'+i).checked=false;
	  				
	 				//document.getElementById("modifyOrderDivId"+i).style.display='block';
	 				document.getElementById("addbutton").checked=false;
	 				//var rejectedTextField = document.getElementById("reason"+i);
					//rejectedTextField.setAttribute('validate','Reason,string,yes');
	  			}
	  			document.getElementById('rejected'+i).checked =true;
	  			document.getElementById("reason"+i).value="";
 				document.getElementById("reason"+i).type="text";
	 			//document.getElementById("reason"+i).style.display='none';
	 		}
		}else{
			checkAllRejected.checked == false ;
		 	var i=1;
		 	for (;i < c;i++) {
	  			document.getElementById("rejected"+i).checked =false;
	  			document.getElementById("reason"+i).value="";
	 			document.getElementById("reason"+i).type="hidden";
	 			//document.getElementById("modifyOrderDivId"+i).style.display='none';
	 			//var rejectedTextField = document.getElementById("reason"+i);
				//rejectedTextField.setAttribute('validate','Reason,string,no');
	 	 	}
	 	}
	}

function  accepted(chkObj, inc)
{
	 if(chkObj.checked){
	 if(chkObj.id == "acceptedCheck"+inc){
	  	document.getElementById("reason"+inc).value="";
	 	document.getElementById("reason"+inc).readOnly=true;
	 	document.getElementById("reason"+inc).type="hidden";
	 	document.getElementById('rejected'+inc).checked=false;
	 }
	 }
}

 function  rejected(chkObj, inc)
	{
		 if(chkObj.checked){
		  if(chkObj.id == "rejected"+inc){
		 	document.getElementById("reason"+inc).type="text";
		 	document.getElementById("reason"+inc).readOnly=false;
		 	if(document.getElementById('acceptedCheck'+inc)!=null){
		 	   document.getElementById('acceptedCheck'+inc).checked=false;
		 	}
		 
	  }
	 }
	 if(!chkObj.checked){
	 if(chkObj.id == "rejected"+inc){
		 	document.getElementById("reason"+inc).type="hidden";
		  //  document.getElementById('acceptedCheck'+inc).checked=;
	  }
	 }
 }
 function fillRejectedReasonInAll()
	{
		var valueToCopy = document.getElementById('rejectedReasonForAll').value;
		if(valueToCopy == ''){
			alert('Fill Some Value To Copy.');
			return false;
		}
		var c = document.getElementById('counter').value;
		var rejectedFlag = false;

		for (var i=1;i < c;i++) {
	  		if(document.getElementById('rejected'+i).checked == true){
	  			document.getElementById('reason'+i).value = valueToCopy;
	  			rejectedFlag = true;
	  		}
	 	}
	 	if(rejectedFlag == false){
	 		alert('No Sample is Rejected to fill Reason.');
	 		return false;
	 	}
	 	return true;
	}
function validateSampleValidation(){
flag = true;
counter = document.getElementById('counter1').value;
directRadio = document.getElementById('directRadio').value;


if(directRadio == 0){
			 for(var i = 1; i < counter; i++){
			  if(document.getElementById('rejected'+i).checked ||(document.getElementById('acceptedCheck'+i)!=null && document.getElementById('acceptedCheck'+i).checked))
              {
              	flag = false;
     		  }
  		}
	}else{
		
		return true;
	}
  		if(flag == false)
  		{
			return true;
		}
		else{
			alert("Accept atleast one Test Name !!!!");
			return false;
		}
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
	
		int pageNo = 1;
		Map map = new HashMap();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		List<DgSampleCollectionDetails> sampleDtList = new ArrayList<DgSampleCollectionDetails>();
		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();

		List<DgSampleCollectionHeader> sampleHeaderList = new ArrayList<DgSampleCollectionHeader>();
		
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		String date1 = (String) utilMap.get("dateTime");

		String userName = "";
		String deptType = "";
		String deptName = "";
		
		String patientName = "";
		String age = "";
		String sex = "";
		String hinNo = "";
		String currentAge = "";
		String maritalStatus = "";
		String empName ="";
		if(session.getAttribute("empName")!=null){
			empName = (String)session.getAttribute("empName");	
		}
		int hospitalId=0;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
	    if(session.getAttribute("hospitalId")!=null){
	    	hospitalId=(Integer)session.getAttribute("hospitalId");
	    }
		int hinId = 0;
		
		if (map.get("sampleDtList") != null) {
			sampleDtList = (List) map.get("sampleDtList");
		}
		
		
		if (sampleDtList != null  && sampleDtList.size()>0 ) {
			dgSampleCollectionHeader = sampleDtList.get(0).getSampleCollectionHeader();
			if (dgSampleCollectionHeader.getHin() != null) {
				hinId = dgSampleCollectionHeader.getHin().getId();
			}
		}
		
		if (map.get("sampleHeaderList") != null) {
			sampleHeaderList = (List<DgSampleCollectionHeader>) map.get("sampleHeaderList");
		}
		int sampleHeaderSize=0;

		
		int dgSampleCollectionHeaderId=0;
		int dgOrderHdId=0;
		int dgSampleCollectionHeaderDept=0;
		if(sampleHeaderList.size()>0 && sampleDtList.size()==0)
		{
			System.out.println("dfgdg");
			sampleHeaderSize=sampleHeaderList.size();
		for(DgSampleCollectionHeader dgSampleCollectionHd:sampleHeaderList){
			System.out.println("asdfdsfsdff");
			dgSampleCollectionHeaderId=dgSampleCollectionHd.getId();
			dgOrderHdId=dgSampleCollectionHd.getOrder().getId();
			dgSampleCollectionHeaderDept=dgSampleCollectionHd.getDepartment().getId();
			
		patientName = dgSampleCollectionHd.getHin().getPFirstName();
		age = dgSampleCollectionHd.getHin().getAge();
		
		if (age != null && !age.trim().equalsIgnoreCase("")
				&& !age.equalsIgnoreCase("0")) {
			currentAge = HMSUtil.calculateAgeForADT(age,
					dgSampleCollectionHd.getHin().getRegDate());
		}

		if (dgSampleCollectionHd.getHin().getMaritalStatus() != null) {
			maritalStatus = dgSampleCollectionHd.getHin().getMaritalStatus()
					.getMaritalStatusName();
		} else {
			maritalStatus = "--";
		}
		if(age==null){
			age="";
		}
		sex = dgSampleCollectionHd.getHin().getSex()
				.getAdministrativeSexName();
		hinNo = dgSampleCollectionHd.getHin().getHinNo();
		}
		}
		if (map.get("pageNo") != null) {
			pageNo = (Integer) map.get("pageNo");
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (map.get("message") != null) {
			String message = (String) map.get("message");
			out.println(message);
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties
				.getProperty("empCategoryCodeForDoctor");
		List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
		employeeCodeList = (ArrayList) map.get("employeeCodeList");
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}
		//Set<DgSampleCollectionDetails> dgSampleCollectionDetailsSet = new HashSet<DgSampleCollectionDetails>();
		//dgSampleCollectionDetailsSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
		
		DgOrderhd dgOrderhd=dgSampleCollectionHeader.getOrder();
		Set<DgOrderdt> dgOrderdts=null;
		if(null!= dgOrderhd && null !=dgOrderhd.getDgOrderdts())
		 dgOrderdts=dgOrderhd.getDgOrderdts();
		
		Map<Integer,String> blockedChargeCodeMap=new HashMap<Integer,String>();
		if(map.get("blockedChargeCodeMap")!=null){
			blockedChargeCodeMap=(Map<Integer,String>)map.get("blockedChargeCodeMap");
		}
		
		//added by govind 28-04-2017
		int orderId=0,oderHId=0;
		if(request.getParameter("orderId")!=null){
			String orderIdStr=request.getParameter("orderId");
			String split[]=orderIdStr.split(",");
			orderId=Integer.parseInt(split[1]);
			oderHId=Integer.parseInt(split[0]);
		    System.out.println("jsp orderIdStr "+orderIdStr);
		    System.out.println("jsp orderId "+orderId+" oderHId "+oderHId);
		}else{
		if(map.get("orderIdP")!=null){
			orderId=(Integer)map.get("orderIdP");
		    System.out.println("jsp orderId "+orderId);
		}
		}
		//added by govind 28-04-2017
		
		int subGroupId=0;
		if (map.get("subGroupId") != null) {
			subGroupId = (Integer) map.get("subGroupId");
		}
		int modalityId=0;
		if (map.get("modalityId") != null) {
			modalityId = (Integer) map.get("modalityId");
		}
		
		/*if(modalityId==0 && subGroupId==0){
			if(orderId>0){
				modalityId=orderId;
			}
		}*/
		System.out.println("subGroupId "+subGroupId+" modalityId "+modalityId);
	%>
	<%
		if (deptType.equalsIgnoreCase("DIAG")) {
	%>
	<input type="hidden" name="modalityId" value="<%=modalityId%>"/>
	<div class="titleBg">
		<h2>Sample validation</h2>
	</div>
	<%
		} else if (deptType.equalsIgnoreCase("RADIO")) {
	%>
	<div class="titleBg">
		<h2>Acceptance for Radiological Investigations</h2>
	</div>
	<%
		}
	%>
	<!--main content placeholder starts here-->
	<div class="clear"></div>
	<%-- <div class="Block">
<div class="auto"><label class="NoWidth">Order Date</label></div>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgSampleCollectionHeader.getOrder().getOrderDate())%></label>
<label class="auto">Order Time</label> <label class="value"><%=dgSampleCollectionHeader.getOrder().getOrderTime()%></label>
<label class="auto">Order No.</label> <label class="value"><%=dgSampleCollectionHeader.getOrder().getOrderNo()%></label>
<label class="auto">Order By</label> <label class="valueAuto"><%=dgSampleCollectionHeader.getOrder().getDepartment().getDepartmentName()%></label>
<div class="clear"></div>
</div> --%>
	<div class="clear"></div>
	<%
	int detailCounter = 8;
	int temp = 0;
	int inc = 1;
	if (pageNo != 1) {
		temp = detailCounter * (pageNo - 1);
	}
	
		Set<DgOrderdt> set = new HashSet<DgOrderdt>();
		if(null !=dgSampleCollectionHeader && null != dgSampleCollectionHeader.getOrder() && null != dgSampleCollectionHeader.getOrder().getDgOrderdts())
		set = dgSampleCollectionHeader.getOrder().getDgOrderdts();
		for (DgOrderdt orderDt : set) {
			
			if (orderDt.getBill() != null) {
				BlOpBillHeader billHeader = orderDt.getBill();
				if (billHeader.getHin() != null) {
					patientName = billHeader.getHin().getPFirstName();
					age = billHeader.getHin().getAge();
					if(age==null){
						age="0";
					}
					sex = billHeader.getHin().getSex()
							.getAdministrativeSexName();
					hinNo = billHeader.getHin().getHinNo();
					currentAge = HMSUtil.calculateAgeForADT(age,
							dgSampleCollectionHeader.getHin().getRegDate());
					if (billHeader.getHin().getMaritalStatus() != null) {
						maritalStatus = billHeader.getHin()
								.getMaritalStatus().getMaritalStatusName();
					}
				} else {
					patientName = billHeader.getPatientName();
					age = billHeader.getAge();
					if(age==null){
						age="";
					}
					sex = billHeader.getSex().getAdministrativeSexName();
					currentAge = billHeader.getAge();
					hinNo = "--";
					maritalStatus = "--";
				}
			} else {
				DgOrderhd orderhd = orderDt.getOrderhd();
				if (orderhd.getHin() != null) {
					patientName = orderhd.getHin().getPFirstName();
					age = orderhd.getHin().getAge();
					
					if (age != null && !age.trim().equalsIgnoreCase("")
							&& !age.equalsIgnoreCase("0")) {
						currentAge = HMSUtil.calculateAgeForADT(age,
								orderhd.getHin().getRegDate());
					}

					if (orderhd.getHin().getMaritalStatus() != null) {
						maritalStatus = orderhd.getHin().getMaritalStatus()
								.getMaritalStatusName();
					} else {
						maritalStatus = "--";
					}
					if(age==null){
						age="";
					}
					sex = orderhd.getHin().getSex()
							.getAdministrativeSexName();
					hinNo = orderhd.getHin().getHinNo();
				}
				
			}
			
		}
		
	%>
	<!--Block First Starts-->
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<input type="hidden" name="<%=HIN_ID%>" value="<%=hinId%>" />
	<div class="Block">
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
		<%
			if (hinNo != null) {
		%>
		<label class="value"><%=hinNo%></label>
		<%
			} else {
		%>
		<label class="value">-</label>
		<%
			}
		%>
		<label>Patient Name</label> <label class="value"><%=patientName%></label>

		<label> Gender</label> <label class="value"><%=sex%></label>
		<div class="clear"></div>
		<%
			if (null !=dgSampleCollectionHeader && null !=dgSampleCollectionHeader.getOrder() && dgSampleCollectionHeader.getOrder().getInpatient() != null) {
		%>
		<label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label><label
			class="value"><%=dgSampleCollectionHeader.getOrder().getInpatient()
						.getAdNo()%></label>
		<label>Ward</label><label class="value"><%=dgSampleCollectionHeader.getOrder().getDepartment()
						.getDepartmentName()%></label>
		<label>Bed No</label> <label class="value"><%=dgSampleCollectionHeader.getOrder().getInpatient()
						.getBed().getBedNo()%></label>
		<div class="clear"></div>
		<%
			}

			String fName = ""; 
			if (null !=dgSampleCollectionHeader && null !=dgSampleCollectionHeader.getOrder() && dgSampleCollectionHeader.getOrder().getPrescribedBy()
					 != null && dgSampleCollectionHeader.getOrder().getPrescribedBy().getEmployeeName()!=null) {
				fName = dgSampleCollectionHeader.getOrder().getPrescribedBy()
						.getEmployeeName();
			} 
			String bloodGroup = "-";
			
			/* if(dgSampleCollectionHeader.getOrder().getHin().getConfirmedStatus()!=null && dgSampleCollectionHeader.getOrder().getHin().getConfirmedStatus().equalsIgnoreCase("y"))
				bloodGroup =dgSampleCollectionHeader.getOrder().getHin().getBloodGroupValue(); */
			
		 	if (null !=dgSampleCollectionHeader && dgSampleCollectionHeader.getHin().getConfirmedStatus()!=null && dgSampleCollectionHeader.getHin().getConfirmedStatus().equalsIgnoreCase("y") && dgSampleCollectionHeader.getOrder().getHin().getBloodGroup() != null
					) {
				bloodGroup = dgSampleCollectionHeader.getOrder().getHin()
						.getBloodGroup().getBloodGroupCode();
			} 
			String mobileNumber = "-";
			if (null !=dgSampleCollectionHeader && null !=dgSampleCollectionHeader.getOrder() && dgSampleCollectionHeader.getOrder().getHin().getMobileNumber() != null
					&& !"".equalsIgnoreCase(dgSampleCollectionHeader.getOrder()
							.getHin().getMobileNumber().trim())) {
				mobileNumber = dgSampleCollectionHeader.getOrder().getHin()
						.getMobileNumber();
			}
			String departmentName = "-";
			if(dgSampleCollectionHeader.getOrder().getDepartment()!=null){
				departmentName = dgSampleCollectionHeader.getOrder().getDepartment().getDepartmentName();
			}
		%>

		
		<label>Mobile No</label> <label class="value"><%=mobileNumber%></label>
		<label>Age</label>
		<%
			if (currentAge != null) {
		%>
		<label class="value"><%=currentAge%></label>
		<%
			} else {
		%>
		<label class="value">-</label>
		<%
			}
		%>
	     <label>Blood Group</label> <label class="value"><%=bloodGroup%></label>
		<div class="clear"></div>
		<label>Department</label><label class="value"><%=departmentName%></label> <%-- <label>Doctor
			Name</label> <label class="value"><%=fName%></label> --%>
			<label>Technician Name </label><label class="value"><%=empName%></label>
	</div>
	<%if(null !=dgSampleCollectionHeader.getDepartment()){ %>
	<input type="hidden" name="<%=DEPARTMENT_ID%>"
		value="<%=dgSampleCollectionHeader.getDepartment().getId()%>" />
		
		 <input
		type="hidden" name="<%=ORDER_BOOKING_ID%>"
		value="<%=dgSampleCollectionHeader.getOrder().getId()%>" /> <input
		type="hidden" name="sampleCollectionHeaderId"
		value="<%=dgSampleCollectionHeader.getId()%>" />
<%}else{ %>
<input type="hidden" name="<%=DEPARTMENT_ID%>"
		value="<%=dgSampleCollectionHeaderDept%>" />
		
		 <input
		type="hidden" name="<%=ORDER_BOOKING_ID%>"
		value="<%=dgOrderHdId%>" /> <input
		type="hidden" name="sampleCollectionHeaderId"
		value="<%=dgSampleCollectionHeaderId%>" />
<%} %>
	<div class="clear"></div>
	<!--Block First Ends-->
	<!-- Block Two Starts -->
	<%
		if (deptType.equalsIgnoreCase("DIAG")) {
	%>
	<h4>Sample Details</h4>
	<%
		} else if (deptType.equalsIgnoreCase("RADIO")) {
	%>
	<!-- <h4>Report Details</h4> -->
	<%
		}
	%>
	<div class="clear"></div>
	<%--<div class="Block">
		<%
			if (deptType.equalsIgnoreCase("DIAG") && null !=dgSampleCollectionHeader.getDiagnosisDate()) {
		%>
		<label class="auto">&nbsp;&nbsp;Date</label> <label class="value"><%=(HMSUtil
						.changeDateToddMMyyyy(dgSampleCollectionHeader
								.getDiagnosisDate()))%></label>
		<%
			} 
		%>	
			
		 <% if (deptType.equalsIgnoreCase("RADIO") && null !=dgSampleCollectionHeader.getDiagnosisDate()) {
		%>
		<label class="auto">&nbsp;&nbsp;Patient Report Date</label> <label
			class="value"><%=(HMSUtil
						.changeDateToddMMyyyy(dgSampleCollectionHeader
								.getDiagnosisDate()))%></label>
		<%
			}
		%> --%>
		<%--<%
			if (deptType.equalsIgnoreCase("DIAG")) {
		%>
		<label class="auto">Time</label> <label class="valueAuto"><%=time%></label>
		<%
			} else if (deptType.equalsIgnoreCase("RADIO")) {
		%>
		 <label class="auto">&nbsp;&nbsp;Patient Report Time</label> <label
			class="valueAuto"><%=time%></label> 
		<%
			}
		%> --%>
		<!-- </select> -->
		<div class="clear"></div>
	<!-- </div> -->
	<div class="clear"></div>
	<!--Block First Ends-->
	<!-- Block Two Starts -->
	<input type="hidden" name="orderIdP" value="<%=orderId %>"/>
	<%
		if (deptType.equalsIgnoreCase("DIAG")) {
	%>
	<h4>Sample Validation Details</h4>
	<%
		} else if (deptType.equalsIgnoreCase("RADIO")) {
	%>
	<!-- <h4>Report Details</h4> -->
	<%
		}
	%>
	<div class="clear"></div>
	<%-- <div class="Block">
		<%
			if (deptType.equalsIgnoreCase("DIAG")) {
		%>
		<label class="auto">&nbsp;&nbsp;Date</label> <label class="value"><%=date%></label>
		<%
			}  
		%>
		
		<% if (deptType.equalsIgnoreCase("RADIO") && null !=dgSampleCollectionHeader.getDiagnosisDate()) { %>
		<label class="auto">&nbsp;&nbsp;Patient Report Date</label> <label
			class="value"><%=(HMSUtil
						.changeDateToddMMyyyy(dgSampleCollectionHeader
								.getDiagnosisDate()))%></label>
		<%
			}
		%> --%>
		
		<%-- <input type="hidden" name="<%=SAMPLE_VALIDATION_DATE%>"
			value="<%=date%>" /> <input type="hidden"
			name="<%=SAMPLE_VALIDATION_TIME%>" value="<%=time%>" /> <label
			class="auto"><span>*</span> Validated By</label> --%>
		<%
			Users user = (Users) session.getAttribute("users");
			Integer empId = user.getEmployee().getId();
			String empFName = "";
			 
			if (user.getEmployee().getEmployeeName() != null) {
				empFName = user.getEmployee().getEmployeeName();
			}  
		%>
		<%--<label class="valueAuto"><%=empFName%></label> --%>
		<input type="hidden" name="<%=EMPLOYEE_ID%>" value="<%=empId%>" />


		<%-- <select
			name="<%=EMPLOYEE_ID%>" class="" validate="Validated By,string,yes"
			tabindex=1>
			<option value="">Select</option>
			<%
				Users user = (Users) session.getAttribute("users");
				Integer empId = user.getEmployee().getId();
				for (MasEmployee obj : employeeCodeList) {

					if (obj.getEmpCategory() != null) {
						if (obj.getEmpCategory().getEmpCategoryCode()
								.equals(empCategoryCodeForDoctor)) {
							String doctorFirstName = "";
							String doctorMiddleName = "";
							String doctorLastName = "";
							if (obj.getFirstName() != null) {
								doctorFirstName = obj.getFirstName();
							}
							if (obj.getMiddleName() != null) {
								doctorMiddleName = obj.getMiddleName();
							}
							if (obj.getLastName() != null) {
								doctorLastName = obj.getLastName();
							}

							if (empId.equals(obj.getId())) {
			%>
			<option value="<%=obj.getId()%>" selected="selected"><%=doctorFirstName + " " + doctorMiddleName
									+ " " + doctorLastName%></option>
			<%
				} else {
			%>
			<option value="<%=obj.getId()%>"><%=doctorFirstName + " " + doctorMiddleName
									+ " " + doctorLastName%></option>
			<%
				}
						}
					}
				}
			%>
		</select> --%>
		<%-- <div class="clear"></div>
		<label class="auto">Clinical Notes</label>
		<%
			if (null !=dgSampleCollectionHeader.getOrder() && dgSampleCollectionHeader.getOrder().getClinicalNote() != null) {
		%>
		<label class="valueAuto"><%=dgSampleCollectionHeader.getOrder().getClinicalNote()%></label>
		<%
			} else {
		%>
		<label class="valueAuto">-</label>
		<%
			}
		%> --%>

		<div class="clear"></div>

		<div class="clear"></div>
	<!-- </div> -->
	<div class="clear"></div>
	<!-- Block two Ends -->
	
	<!-- Table Starts -->
	<%if(sampleDtList != null  && sampleDtList.size()>0){
		%>
	<div class="cmntable">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<th scope="col">S.No.</th>
				<th scope="col">Investigation Name</th>
				<th scope="col">Sample Id</th>
				<%
					if (deptType.equalsIgnoreCase("DIAG")) {
				%>
				<th scope="col">Sample</th>
				<%
					}
				%>
				<%
					if (deptType.equalsIgnoreCase("DIAG")) {
				%>
				<th scope="col">Quantity</th>
				<%
					}
				%>
				<!-- <th scope="col">Date&Time</th> -->
				<th scope="col">Accepted <input type="checkbox" name="checkall"
					class="radioCheck" value="Collected All" id="addbutton"
					onclick="CheckAll(this);" align="right" /></th>
				<th scope="col">Rejected <input type="checkbox"
					name="checkAllRejected" class="radioCheck" value="Rejected All"
					id="rejectAllButton" onclick="checkAllReject(this);" align="right" />
				</th>
				<th scope="col">Reason</th>
				 <th scope="col">Collected By</th>
			</tr>

			<% 
			/* Map<Integer,String> dtPayment=new HashMap<Integer,String>();
			for(DgOrderdt dgOrderdt:dgOrderdts){
				
				 if("Y".equalsIgnoreCase(dgOrderdt.getPaymentMade())){
					dtPayment.put(dgOrderdt.getChargeCode().getId(), "Y");
				} 
			} */
				
				
				for (DgSampleCollectionDetails dgSampleCollectionDetails : sampleDtList) {
					if(oderHId==dgSampleCollectionDetails.getSampleCollectionHeader().getId()){//added by govind 30-06-2017
					if(dgSampleCollectionDetails.getRejected()!=null){//added by govind 20-06-2017
						
					}else{
					/* if(dtPayment.containsKey(dgSampleCollectionDetails.getChargeCode().getId())){  */
					
					if(dgSampleCollectionDetails.getSampleCollectionHeader().getReferHospital()!=null){ 
					//System.out.println(dgSampleCollectionDetails.getSampleCollectionHeader().getReferHospital().getId() +"<<======hospitalId --- >>"+hospitalId+"<<status>>>>"+dgSampleCollectionDetails.getReferStatus());
					if(hospitalId==dgSampleCollectionDetails.getSampleCollectionHeader().getReferHospital().getId() 
							&& dgSampleCollectionDetails.getReferStatus().equalsIgnoreCase("y")){
					if (dgSampleCollectionDetails.getOrderStatus()
							.equalsIgnoreCase("P")) {
			%>

			<tr>
				<td width="5%"><input type="text" size="2"
					value="<%=temp + inc%>" name="<%=SR_NO%>" readonly="readonly"
					class="readOnly" /></td>
				<td>
					<%
						if (dgSampleCollectionDetails.getChargeCode() != null) {
					%>
					
					 <label name="chargeName" style="font-weight: bold;"><%=dgSampleCollectionDetails.getChargeCode()
								.getChargeCodeName()%> </label> 
		<input type="hidden" value="<%=dgSampleCollectionDetails.getChargeCode().getId()%>"
		name="chargeCodeId<%=inc%>" readonly="readonly" class="readOnly" />	
								<%
 	} else {
 %> <label>-</label> <%
 	}
 %>
				</td>
				<td>
				<%if(dgSampleCollectionDetails.getSubcharge()!=null && dgSampleCollectionDetails.getDiagNo()!=null){%>
					<%=dgSampleCollectionDetails.getSubcharge().getSubChargecodeCode()+"/"+dgSampleCollectionDetails.getDiagNo()%>
					
				<%}%>
				</td>
				<%
					if (dgSampleCollectionDetails.getChargeCode() != null) {
				%>
				<input type="hidden" value="<%=dgSampleCollectionDetails.getChargeCode().getId()%>" 
		name="chargeCodeId<%=inc%>" readonly="readonly" class="readOnly" />	
				<input type="hidden" name="<%=CHARGE_CODE_ID%>"
					id="chargeCodeId<%=inc%>"
					value="<%=dgSampleCollectionDetails.getChargeCode()
								.getId()%>" />
				<input type="hidden" name="<%=SUB_CHARGECODE_ID%>"
					value="<%=dgSampleCollectionDetails.getSubcharge()
								.getId()%>" />
				<%
					} else {
				%>
				<input type="hidden" name="<%=CHARGE_CODE_ID%>"
					id="chargeCodeId<%=inc%>" value="" />
				<%
					}
				%>
				<%
					if (deptType.equalsIgnoreCase("DIAG")) {
				%>
				<td>
					<%
						if (dgSampleCollectionDetails.getSample() != null) {
					%> <label><%=dgSampleCollectionDetails.getSample()
									.getSampleDescription()%></label> <%
 	} else {
 %> <label>-</label>
				</td>
				<%
					}
							}
				%>
				<%
					if (deptType.equalsIgnoreCase("DIAG")) {
				%>
				<td>
					<%
						if (dgSampleCollectionDetails.getInvestigation() != null
											&& dgSampleCollectionDetails.getInvestigation()
													.getQuantity() != null) {
					%> <label name="<%=QUANTITY%>"><%=dgSampleCollectionDetails
									.getInvestigation().getQuantity()%></label> <%
 	} else {
 %> <label name="<%=QUANTITY%>">-</label>
				</td>
				<%
					}
							}
				%>

				<%
					if (dgSampleCollectionDetails.getSample() != null) {
				%>
				<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc%>"
					value="<%=dgSampleCollectionDetails.getSample().getId()%>" />
				<%
					} else {
				%>
				<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc%>"
					value="" />
				<%
					}
				%>
				<%
					if (dgSampleCollectionDetails != null) {
				%>
				<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>"
					id="sampleCollectionDetailId<%=inc%>"
					value="<%=dgSampleCollectionDetails.getId()%>" />
				<%
					} else {
				%>
				<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>"
					id="sampleId<%=inc%>" value="" />
				<%
					}
				%>


				<%-- <td>
					<%
						if (dgSampleCollectionDetails.getSampleCollDatetime() != null) {
					%> <input
					type="text" name="<%=DATE%>"
					value="<%=HMSUtil
								.convertDateToStringTypeDate(dgSampleCollectionDetails
										.getSampleCollDatetime())%>"
					size="20" maxlength="45" tabindex=1 readonly="readonly"
					class="readOnly" /> <%
 	} else {
 %> <input type="text" name="<%=DATE%>"
					value="" size="20" maxlength="45" tabindex=1 /> <%
 	}
 %>
				</td> --%>

				<td><input type="checkbox" id="acceptedCheck<%=inc%>"
					name="check<%=inc%>" value="y" onclick="accepted(this,<%=inc%>);" /></td>
				<td><input type="checkbox" id="rejected<%=inc%>"
					name="check1<%=inc%>" value="y" onclick="rejected(this,<%=inc%>);" /></td>
				<td>
					<%
						if (dgSampleCollectionDetails.getReason() != null) {
					%> <input id="reason<%=inc%>" type="text"
					name="<%=REASON%><%=inc%>"
					value="<%=dgSampleCollectionDetails.getReason()%>" size="40"
					maxlength="45" tabindex=1 /> <%
 	} else {
 %> <input id="reason<%=inc%>" type="hidden" name="<%=REASON%><%=inc%>"
					value="" size="40" maxlength="45" tabindex=1 /> <%
 	}
 %>
				</td>
				<%
					String CFName = "";
							String CMName = "";
							String CLName = "";
							if (dgSampleCollectionDetails.getCollectedBy() != null) {
								if (dgSampleCollectionDetails.getCollectedBy()
										.getFirstName() != null) {
									CFName = dgSampleCollectionDetails.getCollectedBy()
											.getFirstName();
								}
								if (dgSampleCollectionDetails.getCollectedBy()
										.getMiddleName() != null) {
									CMName = dgSampleCollectionDetails.getCollectedBy()
											.getMiddleName();
								}
								if (dgSampleCollectionDetails.getCollectedBy()
										.getLastName() != null) {
									CLName = dgSampleCollectionDetails.getCollectedBy()
											.getLastName();
								}
				%>
				<td><%=CFName + " " + CMName + " " + CLName%></td>
				<%
					} else {
				%>
				
				<%
					}
				%>


				<%
					if (dgSampleCollectionDetails.getRemarks() != null) {
				%>
				<input type="hidden" name="<%=REMARKS%><%=inc%>"
					value="<%=dgSampleCollectionDetails.getRemarks()%>" maxlength="50"
					tabindex=1 size="40" />
				<%
					} else {
				%>
				<input name="<%=REMARKS%><%=inc%>" type="hidden" value=""
					maxlength="50" tabindex=1 size="40" />
				<%
					} 
				%>


			</tr>
			<%
				inc++;
					}
					
					
					
					}
					else  if(hospitalId!=dgSampleCollectionDetails.getSampleCollectionHeader().getReferHospital().getId() 
							&& dgSampleCollectionDetails.getReferStatus().equalsIgnoreCase("n") 
							&& dgSampleCollectionDetails.getOrderStatus()
							.equalsIgnoreCase("P")){
						
				%>

				<tr>
					<td width="5%"><input type="text" size="2"
						value="<%=temp + inc%>" name="<%=SR_NO%>" readonly="readonly"
						class="readOnly" /></td>
					<td>
						<%
							if (dgSampleCollectionDetails.getChargeCode() != null) {
						%> <label name="chargeName" style="font-weight: bold;"><%=dgSampleCollectionDetails.getChargeCode()
									.getChargeCodeName()%> </label> <%
	 	} else {
	 %> <label>-</label> <%
	 	}
	 %>
					</td>
					<td><%if(dgSampleCollectionDetails.getSubcharge()!=null && dgSampleCollectionDetails.getDiagNo()!=null){%>
					<%=dgSampleCollectionDetails.getSubcharge().getSubChargecodeCode()+"/"+dgSampleCollectionDetails.getDiagNo()%>
					
					<%}%></td>
					<%
						if (dgSampleCollectionDetails.getChargeCode() != null) {
					%> 
					<input type="hidden" value="<%=dgSampleCollectionDetails.getChargeCode().getId()%>"
		name="chargeCodeId<%=inc%>" readonly="readonly" class="readOnly" />	
					<input type="hidden" name="<%=CHARGE_CODE_ID%>"
						id="chargeCodeId<%=inc%>"
						value="<%=dgSampleCollectionDetails.getChargeCode()
									.getId()%>" />
					<input type="hidden" name="<%=SUB_CHARGECODE_ID%>"
						value="<%=dgSampleCollectionDetails.getSubcharge()
									.getId()%>" />
					<%
						} else {
					%>
					<input type="hidden" name="<%=CHARGE_CODE_ID%>"
						id="chargeCodeId<%=inc%>" value="" />
					<%
						}
					%>
					<%
						if (deptType.equalsIgnoreCase("DIAG")) {
					%>
					<td>
						<%
							if (dgSampleCollectionDetails.getSample() != null) {
						%> <label><%=dgSampleCollectionDetails.getSample()
										.getSampleDescription()%></label> <%
	 	} else {
	 %> <label>-</label>
					</td>
					<%
						}
								}
					%>
					<%
						if (deptType.equalsIgnoreCase("DIAG")) {
					%>
					<td>
						<%
							if (dgSampleCollectionDetails.getInvestigation() != null
												&& dgSampleCollectionDetails.getInvestigation()
														.getQuantity() != null) {
						%> <label name="<%=QUANTITY%>"><%=dgSampleCollectionDetails
										.getInvestigation().getQuantity()%></label> <%
	 	} else {
	 %> <label name="<%=QUANTITY%>">-</label>
					</td>
					<%
						}
								}
					%>

					<%
						if (dgSampleCollectionDetails.getSample() != null) {
					%>
					<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc%>"
						value="<%=dgSampleCollectionDetails.getSample().getId()%>" />
					<%
						} else {
					%>
					<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc%>"
						value="" />
					<%
						}
					%>
					<%
						if (dgSampleCollectionDetails != null) {
					%>
					<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>"
						id="sampleCollectionDetailId<%=inc%>"
						value="<%=dgSampleCollectionDetails.getId()%>" />
					<%
						} else {
					%>
					<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>"
						id="sampleId<%=inc%>" value="" />
					<%
						}
					%>


					<%-- <td>
						<%
							if (dgSampleCollectionDetails.getSampleCollDatetime() != null) {
						%> <input
						type="text" name="<%=DATE%>"
						value="<%=HMSUtil
									.convertDateToStringTypeDate(dgSampleCollectionDetails
											.getSampleCollDatetime())%>"
						size="20" maxlength="45" tabindex=1 readonly="readonly"
						class="readOnly" /> <%
	 	} else {
	 %> <input type="text" name="<%=DATE%>"
						value="" size="20" maxlength="45" tabindex=1 /> <%
	 	}
	 %>
					</td> --%>


					<td><input type="checkbox" id="acceptedCheck<%=inc%>"
						name="check<%=inc%>" value="y" onclick="accepted(this,<%=inc%>);" /></td>
					<td><input type="checkbox" id="rejected<%=inc%>"
						name="check1<%=inc%>" value="y" onclick="rejected(this,<%=inc%>);" /></td>
					<td>
						<%
							if (dgSampleCollectionDetails.getReason() != null) {
						%> <input id="reason<%=inc%>" type="text"
						name="<%=REASON%><%=inc%>"
						value="<%=dgSampleCollectionDetails.getReason()%>" size="40"
						maxlength="45" tabindex=1 /> <%
	 	} else {
	 %> <input id="reason<%=inc%>" type="hidden" name="<%=REASON%><%=inc%>"
						value="" size="40" maxlength="45" tabindex=1 /> <%
	 	}
	 %>
					</td>
					<%
						String CFName = "";
								String CMName = "";
								String CLName = "";
								if (dgSampleCollectionDetails.getCollectedBy() != null) {
									if (dgSampleCollectionDetails.getCollectedBy()
											.getFirstName() != null) {
										CFName = dgSampleCollectionDetails.getCollectedBy()
												.getFirstName();
									}
									if (dgSampleCollectionDetails.getCollectedBy()
											.getMiddleName() != null) {
										CMName = dgSampleCollectionDetails.getCollectedBy()
												.getMiddleName();
									}
									if (dgSampleCollectionDetails.getCollectedBy()
											.getLastName() != null) {
										CLName = dgSampleCollectionDetails.getCollectedBy()
												.getLastName();
									}
					%>
					<td><%=CFName + " " + CMName + " " + CLName%></td>
					<%
						} else {
					%>
					
					<%
						}
					%>


					<%
						if (dgSampleCollectionDetails.getRemarks() != null) {
					%>
					<input type="hidden" name="<%=REMARKS%><%=inc%>"
						value="<%=dgSampleCollectionDetails.getRemarks()%>" maxlength="50"
						tabindex=1 size="40" />
					<%
						} else {
					%>
					<input name="<%=REMARKS%><%=inc%>" type="hidden" value=""
						maxlength="50" tabindex=1 size="40" />
					<%
						} 
					%>


				</tr>
				<%
					inc++;
						}}else if (dgSampleCollectionDetails.getOrderStatus()
								.equalsIgnoreCase("P")) {
							%>

							<tr>
								<td width="5%"><input type="text" size="2"
									value="<%=temp + inc%>" name="<%=SR_NO%>" readonly="readonly"
									class="readOnly" /></td>
								<td>
									<%
										if (dgSampleCollectionDetails.getChargeCode() != null) {
									%> <label name="chargeName" style="font-weight: bold;"><%=dgSampleCollectionDetails.getChargeCode()
												.getChargeCodeName()%> </label> <%
				 	} else {
				 %> <label>-</label> <%
				 	}
				 %>
								</td>
								<td><%if(dgSampleCollectionDetails.getSubcharge()!=null && dgSampleCollectionDetails.getDiagNo()!=null){%>
					<%=dgSampleCollectionDetails.getSubcharge().getSubChargecodeCode()+"/"+dgSampleCollectionDetails.getDiagNo()%>
					
				<%}%></td>
								<%
									if (dgSampleCollectionDetails.getChargeCode() != null) {
								%>
								<input type="hidden" value="<%=dgSampleCollectionDetails.getChargeCode().getId()%>"
		name="chargeCodeId<%=inc%>" readonly="readonly" class="readOnly" />	
								<input type="hidden" name="<%=CHARGE_CODE_ID%>"
									id="chargeCodeId<%=inc%>"
									value="<%=dgSampleCollectionDetails.getChargeCode()
												.getId()%>" />
								<input type="hidden" name="<%=SUB_CHARGECODE_ID%>"
									value="<%=dgSampleCollectionDetails.getSubcharge()
												.getId()%>" />
								<%
									} else {
								%>
								<input type="hidden" name="<%=CHARGE_CODE_ID%>"
									id="chargeCodeId<%=inc%>" value="" />
								<%
									}
								%>
								<%
									if (deptType.equalsIgnoreCase("DIAG")) {
								%>
								<td>
									<%
										if (dgSampleCollectionDetails.getSample() != null) {
									%> <label><%=dgSampleCollectionDetails.getSample()
													.getSampleDescription()%></label> <%
				 	} else {
				 %> <label>-</label>
								</td>
								<%
									}
											}
								%>
								<%
									if (deptType.equalsIgnoreCase("DIAG")) {
								%>
								<td>
									<%
										if (dgSampleCollectionDetails.getInvestigation() != null
															&& dgSampleCollectionDetails.getInvestigation()
																	.getQuantity() != null) {
									%> <label name="<%=QUANTITY%>"><%=dgSampleCollectionDetails
													.getInvestigation().getQuantity()%></label> <%
				 	} else {
				 %> <label name="<%=QUANTITY%>">-</label>
								</td>
								<%
									}
											}
								%>

								<%
									if (dgSampleCollectionDetails.getSample() != null) {
								%>
								<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc%>"
									value="<%=dgSampleCollectionDetails.getSample().getId()%>" />
								<%
									} else {
								%>
								<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc%>"
									value="" />
								<%
									}
								%>
								<%
									if (dgSampleCollectionDetails != null) {
								%>
								<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>"
									id="sampleCollectionDetailId<%=inc%>"
									value="<%=dgSampleCollectionDetails.getId()%>" />
								<%
									} else {
								%>
								<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%><%=inc%>"
									id="sampleId<%=inc%>" value="" />
								<%
									}
								%>


								<%-- <td>
									<%
										if (dgSampleCollectionDetails.getSampleCollDatetime() != null) {
									%> <input
									type="text" name="<%=DATE%>"
									value="<%=HMSUtil
												.convertDateToStringTypeDate(dgSampleCollectionDetails
														.getSampleCollDatetime())%>"
									size="20" maxlength="45" tabindex=1 readonly="readonly"
									class="readOnly" /> <%
				 	} else {
				 %> <input type="text" name="<%=DATE%>"
									value="" size="20" maxlength="45" tabindex=1 /> <%
				 	}
				 %>
								</td> --%>
								

								<td>
								
								<%if(blockedChargeCodeMap.get(dgSampleCollectionDetails.getChargeCode().getId())!=null){%>
				 						<input type="checkbox" id=""
										name="" value="y" onclick="accepted(this,<%=inc%>);" disabled="disabled"/>
								<%}else{%>
				 						<input type="checkbox" id="acceptedCheck<%=inc%>"
										name="check<%=inc%>" value="y" onclick="accepted(this,<%=inc%>);" />
								<%}%>
								
								
								<%-- <input type="checkbox" id="acceptedCheck<%=inc%>"
									name="check<%=inc%>" value="y" onclick="accepted(this,<%=inc%>);" /> --%></td>
								<td><input type="checkbox" id="rejected<%=inc%>"
									name="check1<%=inc%>" value="y" onclick="rejected(this,<%=inc%>);" /></td>
								<td>
									<%
										if (dgSampleCollectionDetails.getReason() != null) {
									%> <input id="reason<%=inc%>" type="text"
									name="<%=REASON%><%=inc%>"
									value="<%=dgSampleCollectionDetails.getReason()%>" size="40"
									maxlength="45" tabindex=1 /> <%
				 	} else {
				 %> <input id="reason<%=inc%>" type="hidden" name="<%=REASON%><%=inc%>"
									value="" size="40" maxlength="45" tabindex=1 /> <%
				 	}
				 %>
								</td>
								<%
									String CFName = "";
											String CMName = "";
											String CLName = "";
											if (dgSampleCollectionDetails.getCollectedBy() != null) {
												if (dgSampleCollectionDetails.getCollectedBy()
														.getFirstName() != null) {
													CFName = dgSampleCollectionDetails.getCollectedBy()
															.getFirstName();
												}
												if (dgSampleCollectionDetails.getCollectedBy()
														.getMiddleName() != null) {
													CMName = dgSampleCollectionDetails.getCollectedBy()
															.getMiddleName();
												}
												if (dgSampleCollectionDetails.getCollectedBy()
														.getLastName() != null) {
													CLName = dgSampleCollectionDetails.getCollectedBy()
															.getLastName();
												}
								%>
								<td><%=CFName + " " + CMName + " " + CLName%></td>
								<%
									} else {
								%>
								<!-- <td>-</td> -->
								
								<%
									}
								%>


								<%
									if (dgSampleCollectionDetails.getRemarks() != null) {
								%>
								<input type="hidden" name="<%=REMARKS%><%=inc%>"
									value="<%=dgSampleCollectionDetails.getRemarks()%>" maxlength="50"
									tabindex=1 size="40" />
								<%
									} else {
								%>
								<input name="<%=REMARKS%><%=inc%>" type="hidden" value=""
									maxlength="50" tabindex=1 size="40" />
								<%
									}
								%>


							</tr>
							<%
								inc++;
									}
						
						
						
						/* } */
						} }}%>
			<input type="hidden" name="counter" id="counter" value="<%=inc%>" />
		</table>
	</div>
	<%}else{ %><h3>No Investigation Prescribed</h3><%} %>
	<!-- Table Ends -->
	<!--Bottom labels starts-->
	<div class="clear"></div>
	<div class="division"></div>
	<input type="hidden" name="directRadio" id="directRadio" value="<%=sampleHeaderSize%>" />
	<input type="hidden" name="counter1" id="counter1" value="<%=inc%>" />
	<input type="button" class="button" value="Submit"
		onclick="submitForm('sampleAcceptance','lab?method=submitSampleAcceptance','validateSampleValidation');"
		align="right" name="Submit11" /> <input type="reset" name="Reset"
		id="reset" value="Reset" class="buttonHighlight"
		onclick="resetCheck();" accesskey="r" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="bottom">
		<div class="clear"></div>
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=date%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label>
		<div class="clear"></div>
	</div>
	<!--Bottom labels ends-->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>

<style>
.cmntable table th {background:#bdd6ee;}
</style>