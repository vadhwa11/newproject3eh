<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<form name="patientSearch" action="" method="post">
	<script type="text/javascript" language="javascript">
	<% 
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>
	<script type="text/javascript">
	function forUnregister(val){
	if(val == "2"){
	 document.getElementById('hinId').disabled = true ;
	 document.getElementById('adId').disabled = true ;
	 document.getElementById('departmentId').disabled = true; 
              
	}else{
	document.getElementById('hinId').disabled = false;
	document.getElementById('adId').disabled = false;
	document.getElementById('departmentId').disabled = false; 
	}
	}
	</script>
	<%
		Box box = HMSUtil.getBox(request);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
	 	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
		 date = (String) utilMap.get("currentDate");
	 	Date toDate  = null;
		Date fromDate=null;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<DgResultEntryHeader>)patientMap.get("patientList");
			
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		String userName = "";
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		if(detailsMap.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
			}
		
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
			}
		
		String deptType="";
		if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
		}
	%>
	<script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	</script>
	<div class="titleBg">
		<h2>Pending For Result Validation</h2>
	</div>
	<div class="clear"></div>
	<h4>Patient Search</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>

		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input
			id="hinId" type="text" name="<%=HIN_NO %>" value="" maxlength="50" />
		<label><span>*</span> From Date</label> <input type="text"
			class="date" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

		<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
			readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

		<div class="clear"></div>

		<label>P Type</label> <select name="<%=PATIENT_TYPE%>"
			validate="P Type,string,no">
			<option value="">Select One</option>
			<option value="IP">IP</option>
			<option value="OP">OP</option>
		</select>
		<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
		<input id="adId" type="text" name="<%=AD_NO %>" value=""
			maxlength="30" />
		 <%-- <label>Sub Department</label> <select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>">
			<option value="0">Select</option>
			<%
			for(MasSubChargecode subChargecode : subChargeCodeList){
			%>
			<option value="<%=subChargecode.getId() %>"
				<%=HMSUtil.isSelected(subChargecode.getId(),Integer.valueOf(box.getInt(SUB_CHARGECODE_ID)))%>><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>
		</select> --%> <label>Ward</label><input type="text" name="<%=WARD_NAME%>" value=""
			MAXLENGTH="30" />
		<%-- <select id="departmentId"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
			for(MasDepartment masDepartment : departmentList){
			%>
	<option value="<%=masDepartment.getId() %>"
		<%=HMSUtil.isSelected(masDepartment.getId(),Integer.valueOf(box.getInt(DEPARTMENT_ID)))%>><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select> --%>
		<div class="clear"></div>

		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="" maxlength="30" /> 
			<label>Mobile No</label> <input type="text"
	name="<%=MOBILE_NO%>" value="" MAXLENGTH="30" />
		<div class="clear"></div>

		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<input type="button"
		onclick="submitForm('patientSearch','/hms/hms/investigation?method=searchPatientForResultValidationForQC','checkFromNTodata');"
		value="Search" class="button" accesskey="a" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>

<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />

<div class="clear"></div>

<div id="searchresults" tabindex="2">
	<div id="searchtable" tabindex="2"></div>
	<form name="pendingResultValidation" method="post" action="">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
		<script type="text/javascript">
	formFields = [
	[0, "<%=RESULT_ID%>", "id"],[1,"<%=SAMPLE_NO%>"],[2,"smpcDate"],[3,"time"],[4,"hin"], [5,"patName"], [6,"age"], [7,"sex"],[8,"pType"],[9,"orderBy"],[10,"doct"],[11,"<%=RESULT_ID%>"]];
	 statusTd = 11;
	</script>
	</form>
</div>
<div class="clear"></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Sample No"
	data_header[0][1] = "hide";
	data_header[0][2] = "7%";
	data_header[0][3] = "<%=SAMPLE_NO%>";
	
	data_header[1] = new Array;
	data_header[1][0] = "Result Date"
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "smpcDate";
	
    data_header[2] = new Array;
	data_header[2][0] = "Result Time"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "time";
	
	data_header[3] = new Array;
	data_header[3][0] = "Reg.No."
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "hin";
	
	data_header[4] = new Array;
	data_header[4][0] = "Patient Name"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "patName";
	
	data_header[5] = new Array;
	data_header[5][0] = "Age"
	data_header[5][1] = "data";
	data_header[5][2] = "10%";
	data_header[5][3] = "age";
		
	data_header[6] = new Array;
	data_header[6][0] = "Sex"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "sex";
	
	data_header[7] = new Array;
	data_header[7][0] = "P Type"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "pType";

	data_header[8] = new Array;
	data_header[8][0] = "Order By"
	data_header[8][1] = "data";
	data_header[8][2] = "10%";
	data_header[8][3] = "orderBy";
	
	data_header[9] = new Array;
	data_header[9][0] = "Doctor"
	data_header[9][1] = "data";
	data_header[9][2] = "14%";
	data_header[9][3] = "doct";
	
	data_header[10] = new Array;
	data_header[10][0] = "Id"
	data_header[10][1] = "hide";
	data_header[10][2] = "10%";
	data_header[10][3] = "<%=RESULT_ID%>";
	
	data_arr = new Array();
		<%
		String patientName = "";
		String age = "";
		String sex = "";
		String hinNo = "";
	  	int  counter=0;
		if (patientList != null && patientList.size() > 0) { 
	 	String DiagNo="";
		for(DgResultEntryHeader dgResultDetail : patientList){
			if(!RequestConstants.UHID_FOR_QUALITY_TESTING.equals(dgResultDetail.getHin().getHinNo())){
				continue;
			}
			Patient patient = dgResultDetail.getHin();
			Set<DgResultEntryDetail> sampleDet = new HashSet<DgResultEntryDetail>();
			sampleDet=	dgResultDetail.getDgResultEntryDetails();
		for(DgResultEntryDetail resultDetail :sampleDet){
			DiagNo = resultDetail.getSampleCollectionDetails().getDiagNo();
		}
		Set<DgOrderdt> set = new HashSet<DgOrderdt>();
		set = dgResultDetail.getSampleCollectionHeader().getOrder().getDgOrderdts();
			for(DgOrderdt orderDt : set){
				if(orderDt.getBill() != null){
					BlOpBillHeader  billHeader = orderDt.getBill();
					if(billHeader.getHin() != null ){
					patientName=billHeader.getHin().getPFirstName();
					age=billHeader.getHin().getAge();
					sex=billHeader.getHin().getSex().getAdministrativeSexName();
					hinNo=billHeader.getHin().getHinNo();
					}else {
						patientName=billHeader.getPatientName();
						age=billHeader.getAge();
						sex=billHeader.getSex().getAdministrativeSexName();
					}
					}else{
						DgOrderhd  orderhd = orderDt.getOrderhd();
						if(orderhd.getHin() != null){
							patientName=orderhd.getHin().getPFirstName();
							age=orderhd.getHin().getAge();
							sex=orderhd.getHin().getSex().getAdministrativeSexName();
							hinNo=orderhd.getHin().getHinNo();
						}
					}
				}
		%>
		  		data_arr[<%= counter%>] = new Array();
		  		data_arr[<%= counter%>][0] = "<%=dgResultDetail.getId()%>"
				data_arr[<%= counter%>][1] = "<%=dgResultDetail.getResultNo()%>"
				data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(dgResultDetail.getResultDate())%>"
				data_arr[<%= counter%>][3] = "<%=dgResultDetail.getResultTime()%>"
				
				<%try{%>
				data_arr[<%= counter%>][4] = "<%=hinNo%> "
				data_arr[<%= counter%>][5] = "<%=patientName%>"
				data_arr[<%= counter%>][6] = "<%=age%> "
				data_arr[<%= counter%>][7] = "<%=sex%> "
				<%if(dgResultDetail.getSampleCollectionHeader().getOrder()!= null){%>
				data_arr[<%= counter%>][8] = "<%=dgResultDetail.getSampleCollectionHeader().getOrder().getPatientType()%> "
				<%}else{%>
				data_arr[<%= counter%>][8] = "-"
				<%}%>
				<%if(dgResultDetail.getSampleCollectionHeader().getOrder()!= null){%>
				data_arr[<%= counter%>][9] = "<%=dgResultDetail.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%> "
				<%}else{%>
				data_arr[<%= counter%>][9] = "-"
				<%}%>
				<%if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy()!= null){
					String FirName="";String midName=""; String lastName="";
						if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName()!=null){
						FirName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName();
						}
						if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName()!=null){
							midName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName();
						}
						if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName()!=null){
							lastName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName();
						}
						String name =FirName+" "+midName+" "+lastName;
					
				%>
				data_arr[<%= counter%>][10] = "<%=name%>"
				<%}else{%>
				data_arr[<%= counter%>][10] = "-"
				<%}%>
				data_arr[<%= counter%>][11] = "<%=dgResultDetail.getId()%>"
				
				<%
				if(DiagNo != null){%>
				data_arr[<%= counter%>][12] = "<%=DiagNo%>"
				<%}else{%>
				data_arr[<%= counter%>][12] ="-"
				<%}%>
			<%	
				}catch(Exception e){
					e.printStackTrace();
				}
					     counter++;
			    	}
		}
			%>
	<%
	session.setAttribute("patientList",patientList);
	%>
	formName = "pendingResultValidation"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	makeTable(start,end);
	</script>
