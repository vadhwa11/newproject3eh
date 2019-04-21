<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.DgHistoSampleCollectionDetails"%>
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
String hin=null;
String addType="";
%>

<form name="sampleGrossing" method="post" action="">

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
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	</script>
	<%
		int pageNo = 1;
		Map map = new HashMap();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		List<DgSampleCollectionHeader> samplehdList = new ArrayList<DgSampleCollectionHeader>();
		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();

		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		String date1 = (String) utilMap.get("dateTime");

		String userName = "";
		String deptType = "";
		String deptName = "";
		String patientType = "IP";
		String appId = "";
		String orderStatus = "";
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}

		int hinId = 0;
		try {
			if (map.get("samplehdList") != null) {
				samplehdList = (List) map.get("samplehdList");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (samplehdList != null) {
			dgSampleCollectionHeader = (DgSampleCollectionHeader) samplehdList
					.get(0);
			if (dgSampleCollectionHeader.getHin() != null) {
				hinId = dgSampleCollectionHeader.getHin().getId();
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
		Set<DgHistoSampleCollectionDetails> dgHistoSampleCollectionDetailsSet = new HashSet<DgHistoSampleCollectionDetails>();
		dgHistoSampleCollectionDetailsSet = dgSampleCollectionHeader
				.getDgHistoSampleCollectionDetails();
		appId = (String) session
				.getAttribute(RequestConstants.APP_ID_HISTO);
	%>

	<div class="titleBg">
		<%
			String validateType="";
			String sectionType = "";  
			if ("A1653".equalsIgnoreCase(appId)) {
				orderStatus = "S";
				sectionType = "Specimen";
				addType="Gross";
				validateType="Grossing By";
		%>
		<h2>Add Grossing</h2>
		<%
			} else if ("A1657".equalsIgnoreCase(appId)) {
				orderStatus = "G";
				sectionType = "Gross";
				addType="Block";
				validateType="Blocking By";
		%>
		<h2>Add Blocking</h2>
		<%
			} else if ("A1662".equalsIgnoreCase(appId)) {
				orderStatus = "B";
				sectionType = "Block";
				addType="Slide";
				validateType="Sliding By";
		%>
		<h2>Add Slides</h2>
		<%
			}
		%>

	</div>
	<!--main content placeholder starts here-->
	<div class="clear"></div>
	<div class="clear"></div>
	<%
		String patientName = "";
		String age = "";
		String sex = "";
		String hinNo = "";
		String currentAge = "";
		String maritalStatus = "";
		Set<DgOrderdt> set = new HashSet<DgOrderdt>();
		set = dgSampleCollectionHeader.getOrder().getDgOrderdts();
		for (DgOrderdt orderDt : set) {
			if (orderDt.getBill() != null) {
				BlOpBillHeader billHeader = orderDt.getBill();
				if (billHeader.getHin() != null) {
					patientName = billHeader.getHin().getPFirstName();
					age = billHeader.getHin().getAge();
					sex = billHeader.getHin().getSex()
							.getAdministrativeSexName();
					hinNo = billHeader.getHin().getHinNo();
					if(age==null){
						//age="20 Years";
						if(billHeader.getHin().getDateOfBirth()!=null){
						age =HMSUtil.calculateAge(billHeader.getHin().getDateOfBirth());
						}
						else {
							age="20 Years";
						}
					}
					currentAge = HMSUtil.calculateAgeForADT(age,
							dgSampleCollectionHeader.getHin().getRegDate());
					if (billHeader.getHin().getMaritalStatus() != null) {
						maritalStatus = billHeader.getHin()
								.getMaritalStatus().getMaritalStatusName();
					}
				} else {
					patientName = billHeader.getPatientName();
					age = billHeader.getAge();
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
					currentAge = HMSUtil.calculateAgeForADT(age, orderhd
							.getHin().getRegDate());
					if (orderhd.getHin().getMaritalStatus() != null) {
						maritalStatus = orderhd.getHin().getMaritalStatus()
								.getMaritalStatusName();
					} else {
						maritalStatus = "--";
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
			if (dgSampleCollectionHeader.getOrder().getInpatient() != null) {
		%>
		<label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label><label
			class="value"><%=dgSampleCollectionHeader.getOrder().getInpatient().getAdNo()%></label>
		<label>Ward</label><label class="value"><%=dgSampleCollectionHeader.getOrder().getDepartment().getDepartmentName()%></label>
		<label>Bed No</label> <label class="value"><%=dgSampleCollectionHeader.getOrder().getInpatient().getBed().getBedNo()%></label>
		<div class="clear"></div>
		<%
			}
		String fName = ""; 
		if (dgSampleCollectionHeader.getOrder().getPrescribedBy()!= null) {
			fName = dgSampleCollectionHeader.getOrder().getPrescribedBy()
					.getEmployeeName();
		}
		 
		String bloodGroup = "-";
		if (dgSampleCollectionHeader.getOrder().getHin().getBloodGroup() != null
				&& dgSampleCollectionHeader.getOrder().getHin()
						.getBloodGroup().getBloodGroupCode() != null) {
			bloodGroup = dgSampleCollectionHeader.getOrder().getHin()
					.getBloodGroup().getBloodGroupCode();
		}
		String mobileNumber = "-";
		if (dgSampleCollectionHeader.getOrder().getHin().getMobileNumber() != null && !"".equalsIgnoreCase(dgSampleCollectionHeader.getOrder().getHin().getMobileNumber().trim())) {
			mobileNumber = dgSampleCollectionHeader.getOrder().getHin()
					.getMobileNumber();
		}
		String unit="-";
		if(dgSampleCollectionHeader.getOrder().getHin().getUnit()!=null && !"".equalsIgnoreCase(dgSampleCollectionHeader.getOrder().getHin().getUnit().getUnitName().trim())){
			unit=dgSampleCollectionHeader.getOrder().getHin().getUnit().getUnitName();
		} 
		%>
		<label>Blood Group</label> <label class="value"><%=bloodGroup%></label>
		<label>Mobile No</label> <label class="value"><%=mobileNumber %></label>
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

		<div class="clear"></div>
		<label>Unit</label><label class="value"><%=unit%></label> <label>Doctor
			Name</label> <label class="value"><%=fName%></label>
	</div>
	<input type="hidden" name="<%=DEPARTMENT_ID%>"
		value="<%=dgSampleCollectionHeader.getDepartment().getId()%>" /> <input
		type="hidden" name="<%=ORDER_BOOKING_ID%>"
		value="<%=dgSampleCollectionHeader.getOrder().getId()%>" /> <input
		type="hidden" name="sampleCollectionHeaderId"
		value="<%=dgSampleCollectionHeader.getId()%>" />

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
	<h4>Report Details</h4>
	<%
		}
	%>
	<div class="clear"></div>
	<div class="Block">
		<%
			if (deptType.equalsIgnoreCase("DIAG")) {
		%>
		<label>&nbsp;&nbsp;Date</label> <label class="value"><%=(HMSUtil
						.changeDateToddMMyyyy(dgSampleCollectionHeader
								.getDiagnosisDate()))%></label>
		<%
			} else if (deptType.equalsIgnoreCase("RADIO")) {
		%>
		<label>&nbsp;&nbsp;Patient Report Date</label> <label
			class="value"><%=(HMSUtil
						.changeDateToddMMyyyy(dgSampleCollectionHeader
								.getDiagnosisDate()))%></label>
		<%
			}
		%>
		<%
			if (deptType.equalsIgnoreCase("DIAG")) {
		%>
		<label>Time</label> <label class="value"><%=time%></label>
		<%
			} else if (deptType.equalsIgnoreCase("RADIO")) {
		%>
		<label>&nbsp;&nbsp;Patient Report Time</label> <label
			class="value"><%=time%></label>
		<%
			}
		%>

		
		<!-- 
		<label>Collected By</label>
		<select	name="" class="" tabindex=1> -->
		<%-- <%
			Users user1 = (Users) session.getAttribute("users");
			Integer empId1 = user1.getEmployee().getId();
			for (MasEmployee obj : employeeCodeList) {

				if (obj.getEmpCategory() != null) {
					if (!(obj.getEmpCategory().getEmpCategoryCode()
							.equals(empCategoryCodeForDoctor))) {
						String doctorFirstName1 = "";
						String doctorMiddleName1 = "";
						String doctorLastName1 = "";
						if (obj.getFirstName() != null) {
							doctorFirstName1 = obj.getFirstName();
						}
						if (obj.getMiddleName() != null) {
							doctorMiddleName1 = obj.getMiddleName();
						}
						if (obj.getLastName() != null) {
							doctorLastName1 = obj.getLastName();
						}

						if (empId1.equals(obj.getId())) {
		%>
		<label class="valueAuto"><%=doctorFirstName1 + " "
									+ doctorMiddleName1 + " " + doctorLastName1%></label>
		<option value="<%=obj.getId()%>" selected="selected"><%=doctorFirstName1+" "+doctorMiddleName1+" "+doctorLastName1%></option>
		<%
			} else {
		%>
		<label class="valueAuto"><%=doctorFirstName1 + " "
									+ doctorMiddleName1 + " " + doctorLastName1%></label>
		<option value="<%=obj.getId()%>"><%=doctorFirstName1+" "+doctorMiddleName1+" "+doctorLastName1%></option>
		<%
			}
					}
				}
			}
		%> --%>
		<!-- </select> -->
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<!--Block First Ends-->
	<!-- Block Two Starts -->
	<%
		if (deptType.equalsIgnoreCase("DIAG")) {
	%>
	<h4>Sample Validation Details</h4>
	<%
		} else if (deptType.equalsIgnoreCase("RADIO")) {
	%>
	<h4>Report Details</h4>
	<%
		}
	%>
	<div class="clear"></div>
	<div class="Block">
		<%
			if (deptType.equalsIgnoreCase("DIAG")) {
		%>
		<label>&nbsp;&nbsp;Date</label> <label class="value"><%=date%></label>
		<%
			} else if (deptType.equalsIgnoreCase("RADIO")) {
		%>
		<label>&nbsp;&nbsp;Patient Report Date</label> <label
			class="value"><%=(HMSUtil
						.changeDateToddMMyyyy(dgSampleCollectionHeader
								.getDiagnosisDate()))%></label>
		<%
			}
		%>
		<input type="hidden" name="<%=SAMPLE_VALIDATION_DATE%>"
			value="<%=date%>" /> <input type="hidden"
			name="<%=SAMPLE_VALIDATION_TIME%>" value="<%=time%>" /> <label
			><%=validateType%></label>
		<%
				Users user = (Users) session.getAttribute("users");
				Integer empId = user.getEmployee().getId();
				MasEmployee obj=user.getEmployee();
				
							String doctorFirstName = "";
							String doctorMiddleName = "";
							String doctorLastName = "";
							if(obj!=null){
								if (obj.getFirstName() != null) {
									doctorFirstName = obj.getEmployeeName();
								} 
							}
							 
							 
			%>
		<label class="value"><%=doctorFirstName%></label>
		<input type="hidden" value="<%=empId%>" name="<%=EMPLOYEE_ID%>"></input>


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
		<div class="clear"></div>
		<label>Clinical Notes</label>
		<%
			if (dgSampleCollectionHeader.getOrder().getClinicalNote() != null) {
		%>
		<label class="value"><%=dgSampleCollectionHeader.getOrder().getClinicalNote()%></label>
		<%
			} else {
		%>
		<label class="value">-</label>
		<%
			}
		%>

		<div class="clear"></div>

		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<!-- Block two Ends -->
	<div class="paddingTop15"></div>

	<!-- Table Starts -->
	<div class="cmntable">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<th scope="col"></th>
				<th scope="col">Test Name</th>
				<th scope="col">Section Type</th>
				<th scope="col">Sample</th>
				<th scope="col">Container</th>
				<th scope="col">Remark</th>
				<th scope="col">Investigation No.</th>
				<th scope="col"></th>
			</tr>

			<%
				int detailCounter = 8;
				int temp = 0;
				int inc = 1;
				if (pageNo != 1) {
					temp = detailCounter * (pageNo - 1);
				}
				boolean loop = false;
				System.out.println("orderStatus----->>"+orderStatus);
				for (DgHistoSampleCollectionDetails dgHistoSampleCollectionDetails : dgHistoSampleCollectionDetailsSet) {
					if (orderStatus.equalsIgnoreCase(dgHistoSampleCollectionDetails
							.getOrderStatus())
							&& "N".equalsIgnoreCase(dgHistoSampleCollectionDetails
									.getLabStatus())) {
						loop = true;
			%>

			<tr>

				<td width="5%"><input type="text" size="2"
					value="<%=temp + inc%>" name="<%=SR_NO%>" readonly="readonly"
					class="readOnly" /></td>
				<td>
					<%
						if (dgHistoSampleCollectionDetails.getChargeCode() != null) {
					%> <label name="chargeName" style="font-weight: bold;"><%=dgHistoSampleCollectionDetails
								.getChargeCode().getChargeCodeName()%> </label> <%
 	} else {
 %> <label>-</label> <%
 	}
 %>
				</td>
				<td><%=sectionType%></td>
				<%
					if (dgHistoSampleCollectionDetails.getChargeCode() != null) {
				%>
				<input type="hidden" name="<%=CHARGE_CODE_ID%>"
					id="chargeCodeId<%=inc%>"
					value="<%=dgHistoSampleCollectionDetails
								.getChargeCode().getId()%>" />
				<input type="hidden" name="<%=SUB_CHARGECODE_ID%>"
					value="<%=dgHistoSampleCollectionDetails.getSubcharge()
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
						if (dgHistoSampleCollectionDetails.getSample() != null) {
					%> <label><%=dgHistoSampleCollectionDetails
									.getSample().getSampleDescription()%></label> <%
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
						if (dgHistoSampleCollectionDetails.getInvestigation() != null
											&& dgHistoSampleCollectionDetails
													.getInvestigation().getQuantity() != null) {
					%> <label name="<%=QUANTITY%>"><%=dgHistoSampleCollectionDetails
									.getInvestigation().getQuantity()%></label> <%
 	} else {
 %> <label name="<%=QUANTITY%>">-</label>
				</td>
				<%
					}
							}
				%>
				<td>
					<%if(dgHistoSampleCollectionDetails
						.getRemarks()!=null){%><%=dgHistoSampleCollectionDetails
							.getRemarks()%> 
							
							<input type="hidden" name="remarks" id="remarksId" />
							
							
							<%}else{ %>-<%}%>
				</td>
				<td><%=dgHistoSampleCollectionDetails
							.getIdentificationNo()%></td>

				<%
					if (dgHistoSampleCollectionDetails.getSample() != null) {
				%>
				<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc%>"
					value="<%=dgHistoSampleCollectionDetails.getSample()
								.getId()%>" />
				<%
					} else {
				%>
				<input type="hidden" name="<%=SAMPLE_ID%>" id="sampleId<%=inc%>"
					value="" />
				<%
					}
				%>
				<%
					if (dgHistoSampleCollectionDetails != null) {
				%>
				<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%>"
					id="sampleCollectionDetailId<%=inc%>"
					value="<%=dgHistoSampleCollectionDetails.getId()%>" />
				<%
					} else {
				%>
				<input type="hidden" name="<%=DG_SAMPLE_DETAIL_ID%>"
					id="sampleId<%=inc%>" value="" />
				<%
					}
				%>
				<td><input type="hidden"
					value="<%=dgHistoSampleCollectionDetails
							.getIdentificationNo()%>/1"
					name="defaultIdentificationNo<%=inc%>"
					id="defaultIdentificationNoId<%=inc%>" /> <input type="button"
					class="buttonAdd" style="float: none;"
					onclick="addRow('<%=dgHistoSampleCollectionDetails.getChargeCode()
							.getChargeCodeName()%>','<%=dgHistoSampleCollectionDetails.getSample()
							.getSampleDescription()%>','<%=inc%>','<%=dgHistoSampleCollectionDetails.getId()%>','<%=dgHistoSampleCollectionDetails.getRemarks()%>')" /></td>
				<%
					if (dgHistoSampleCollectionDetails.getRemarks() != null) {
				%>
				<input type="hidden" name="<%=REMARKS%>"
					value="<%=dgHistoSampleCollectionDetails.getRemarks()%>"
					maxlength="50" tabindex=1 size="40" />
				<%
					} else {
				%>
				<input name="<%=REMARKS%>" type="hidden" value="" maxlength="50"
					tabindex=1 size="40" />
				<%
					}
				%>


			</tr>
			<%
				inc++;
					}
				}
				if (!loop) {
			%>
			<tr>
				<td scope="col" colspan="7"><h6>Process done please click
						the submit button for next process</h6> <input type="hidden"
					name="loop" id="loopId" value="<%=loop%>" /></td>
			</tr>
			<%
				}
			%>
			<input type="hidden" name="counter" id="counter" value="<%=inc%>" />
			<input type="hidden" name="appId" value="<%=appId%>" />
			<input type="hidden" name="orderIdOfHeader"
				value="<%=map.get("orderId")%>" />
		</table>
	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div style="display: none;" id="chargeDetailsDiv">
		<input type="button" class="buttonDel" style="float: none;"
			onclick="removeRow();" />
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			id="chargeDetails">

			<tr>
				<th scope="col">S.No.</th>
				<th scope="col">Test Name</th>
				<th scope="col">Section Type</th>
				<th scope="col">Sample</th>
				<th scope="col">Container</th>
				<th scope="col">Investigation No.</th>
				<th scope="col">Description</th>
			</tr>
		</table>
		
	</div>
	<!-- Table Ends -->
	<!--Bottom labels starts-->
	<div class="clear"></div>
	<div class="division"></div>
	<input type="hidden" name="counter1" id="counter1" value="<%=inc%>" />
	<input type="hidden" name="totalRow" id="totalRowId" /> <input
			type="button" class="button" value="Save"
			onclick="setTotalRow();submitForm('sampleGrossing','lab?method=submitHistopatologyDetails','validateSampleValidation');"
			align="right" name="Submit11" />
	<input type="button" class="button" value="Submit"
		onclick="submitForm('sampleGrossing','lab?method=submitHistopatologyDetails&saveHeader=true','validateSampleValidation');"
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
<script type="text/javascript">
var increment=1;
function addRow(testName,sample,inc,histoId,remarks){ 
	document.getElementById('chargeDetailsDiv').show();
	var tbl = document.getElementById('chargeDetails');
	var lastRow = tbl.rows.length;
	//alert(""+remarks);
	var row = tbl.insertRow(lastRow); 
	var iteration = 1;  
	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name='selectedChrage'+ (increment);
	e0.id='selectedChrageId'+ (increment);
	e0.className = 'radioCheck';
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('label');
	var t1 = document.createTextNode(testName); 
	e1.appendChild(t1);  
   	cell1.appendChild(e1);
    
	var cell2 = row.insertCell(2);
	var e2 = document.createElement('label'); 
	var t2=document.createTextNode('<%=addType%>'); 
	e2.appendChild(t2);  
	cell2.appendChild(e2); 

	var cell3 = row.insertCell(3);
	var e3 = document.createElement('label'); 
	var t3=document.createTextNode(sample); 
	e3.appendChild(t3);  
	cell3.appendChild(e3); 


	var cell4 = row.insertCell(4); 
	var e4 = document.createElement('label'); 
	var t4=document.createTextNode('1'); 
	e4.appendChild(t4);  
	cell4.appendChild(e4); 

	var cell5 = row.insertCell(5);
	var e5 = document.createElement('label');
	var identificationNo=document.getElementById('defaultIdentificationNoId'+inc);
	var t5=document.createTextNode(identificationNo.value); 
	e5.appendChild(t5);
	cell5.appendChild(e5); 
	
	var cell6 = row.insertCell(6);
	var e6 = document.createElement('textarea');
//	e6.type = 'textarea';
	e6.maxlength="100";
	
	//alert("remarks ----- >>"+remarks)
	e6.name='<%=OTHERS_REMARKS%>'+ (increment); 
	e6.id='<%=OTHERS_REMARKS%>'+(increment); 
	//var rem1 = document.createTextNode(remarks);
	e6.onblur=function(){
		validateRemarksLength(this.value,increment);
	}
	//alert("remarks  ----  >>>"+remarks)
	if(remarks!='null')
	e6.value=remarks;
	
	var e7 = document.createElement('input');
	e7.type = 'hidden';
	e7.name='priviousHistoId'+ (increment); 
	e7.value=histoId;
	
	var e8 = document.createElement('input');
	e8.type = 'hidden';
	e8.name='identificationNo'+ (increment);  
	e8.value=identificationNo.value; 
	
	cell6.appendChild(e6); 
	cell6.appendChild(e7);
	cell6.appendChild(e8);
	
	var splitedString=identificationNo.value.split('/');
	if(splitedString.length===4){
		identificationNo.value=splitedString[0]+'/'+splitedString[1]+'/'+splitedString[2]+'/'+(Number(splitedString[3])+Number(1)); 
	}
	if(splitedString.length===5){
		identificationNo.value=splitedString[0]+'/'+splitedString[1]+'/'+splitedString[2]+'/'+splitedString[3]+'/'+(Number(splitedString[4])+Number(1)); 
	}
	if(splitedString.length===6){
		identificationNo.value=splitedString[0]+'/'+splitedString[1]+'/'+splitedString[2]+'/'+splitedString[3]+'/'+splitedString[4]+'/'+(Number(splitedString[5])+Number(1)); 
	}
	
	
	increment++;
	
}
function removeRow()
{	
	var tbl = document.getElementById('chargeDetails');
	 var tblRows  = tbl.getElementsByTagName("tr"); 
	for(counter=1;counter<tblRows.length;counter++)
	{
		if (document.getElementById('selectedChrageId'+counter).checked == true)
		{ 
			tbl.rows[counter].style.display='none';
		}
	}
}
function setTotalRow(){ 
	var tbl = document.getElementById('chargeDetails');
	 var tblRows  = tbl.getElementsByTagName("tr"); 
	document.getElementById('totalRowId').value=tblRows.length-1; 
	return true;
}
 
 
 function validateRemarksLength(value,iteration){
	
	 var val=value;
	 var a=val.length;
	// alert(iteration+"<<------a-------->>>"+a);
	 //int b=parseInt(iteration)-2;
	// alert("value  -->>S"+val.lenght);
	 if(a>100){
		 alert("You can not enter more than 100 character!!");
	 }
 }


</script>