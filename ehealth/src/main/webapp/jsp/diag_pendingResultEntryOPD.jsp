<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<form name="patientSearch" action="" method="post">

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>

	<script type="text/javascript" language="javascript">
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

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
	Map<String, Object> pendingData = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
	List<DgOrderdt> patientListForOutSideLab = new ArrayList<DgOrderdt>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> pendingMap = new HashMap<String, Object>();
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
	if(map.get("pendingData") !=null){
		pendingData=(Map<String, Object>)map.get("pendingData");
		}
	
	
	if(map.get("patientMap") != null){
		patientMap= (Map<String, Object>)map.get("patientMap");
	}
	
	if(map.get("pendingMap") != null){
		pendingMap= (Map<String, Object>)map.get("pendingMap");
	}
	
	
	if(patientMap.get("patientList") != null){
	patientList= (List<DgSampleCollectionDetails>)patientMap.get("patientList");
	}
	
	if(pendingMap.get("patientList") != null){
	 patientListForOutSideLab = (List<DgOrderdt>)pendingMap.get("patientList");
	}
	
	String message = "";
	if(map.get("message") != null){
	message= (String)map.get("message");
	}
	if (map.get("fromDate") != null) {
	fromDate =HMSUtil.getDateForm_yyyy_mm_dd(map.get("fromDate").toString());
	session.setAttribute("fromDate", fromDate);
	}
	if (map.get("toDate") != null) {
	toDate =HMSUtil.getDateForm_yyyy_mm_dd(map.get("toDate").toString());
	//toDate = (Date) map.get("toDate");
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
		<h2>Pending For Result Entry</h2>
	</div>
	
		

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
	<div id="searchtable" tabindex="2"></div>
	<form name="pendingResultForOPScreen" method="post" action="">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
		<script type="text/javascript">
formFields = [
[0, "<%= SAMPLE_COLLECTION_DETAIL_ID%>", "id"],[1,"smpcDate"],[2,"time"],[3,"hin"], [4,"patName"], [5,"age"], [6,"sex"],[7,"pType"],[8,"orderBy"],[9,"doct"],[10,"investigationId"],[11,"hinId"],[12,"outSideLab"]];
statusTd = 11;
</script>
	</form>

	<div class="clear"></div>
	<div class="bottom">
		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
			type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</div>
	
	<%
	  int hinId =0;
	  String RequisitionFrom = "NA";
	 if(request.getParameter("hinId") != null)
	 {
		 hinId = Integer.parseInt(request.getParameter("hinId"));
	 }
	 if(request.getParameter("RequisitionFrom") != null)
	 {
		 RequisitionFrom = request.getParameter("RequisitionFrom");
	 }
	
	%>
	
	<input type="hidden" value="<%out.print(hinId); %>" id="hinId" name="hinId" />
	<input type="hidden" value="<%out.print(RequisitionFrom); %>" id="RequisitionFrom" name="RequisitionFrom" />
	
	<% if(patientListForOutSideLab!=null && patientListForOutSideLab.size()>0){ %>
			<input type="hidden" value="<%=patientListForOutSideLab.get(0).getOrderhd().getId()%>" id="orderId" name="orderId" />
			<input type="hidden" value="<%=patientListForOutSideLab.get(0).getOrderhd().getDepartment().getId()%>" id="departmentId" name="departmentId" />
	<% } %>
	<div class="clear"></div>
	<script type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Order Date"
data_header[0][1] = "data";
data_header[0][2] = "10%";
data_header[0][3] = "smpcDate";

data_header[1] = new Array;
data_header[1][0] = "Order Time"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "time";

data_header[2] = new Array;
data_header[2][0] = "UHID "
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "hin";


data_header[3] = new Array;
data_header[3][0] = "Patient Name"
data_header[3][1] = "data";
data_header[3][2] = "20%";
data_header[3][3] = "patName";

data_header[4] = new Array;
data_header[4][0] = "Age"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "age";


data_header[5] = new Array;
data_header[5][0] = "Sex"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "sex";

data_header[6] = new Array;
data_header[6][0] = "P Type"
data_header[6][1] = "data";
data_header[6][2] = "10%";
data_header[6][3] = "pType";

data_header[7] = new Array;
data_header[7][0] = "Order By"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "orderBy";

data_header[8] = new Array;
data_header[8][0] = "Doctor"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "doct";

data_header[9] = new Array;
data_header[9][0] = "Test Name"
data_header[9][1] = "data";
data_header[9][2] = "14%";
data_header[9][3] = "investigationId";

data_header[10] = new Array;
data_header[10][0] = "hinId"
data_header[10][1] = "hide";
data_header[10][2] = "10%";
data_header[10][3] = "hinId";

data_header[11] = new Array;
data_header[11][0] = "outsideLab"
data_header[11][1] = "hide";
data_header[11][2] = "10%";
data_header[11][3] = "outsideLab";

data_arr = new Array();
<%
	int  counter=0;
	if (patientList != null && patientList.size() > 0) { 
 %>
<%
	String patientName = "";
	String age = "";
	String sex = "";
	String hinNo = "";
	for(DgSampleCollectionDetails dgsampleDetails : patientList){
		if(RequestConstants.UHID_FOR_QUALITY_TESTING.equals(dgsampleDetails.getSampleCollectionHeader().getHin().getHinNo())){
			continue;
		}
	
	Patient patient =dgsampleDetails.getSampleCollectionHeader().getHin();
	DgSampleCollectionHeader sampleHeader = dgsampleDetails.getSampleCollectionHeader();
	Set<DgOrderdt> set = new HashSet<DgOrderdt>();
	set = dgsampleDetails.getSampleCollectionHeader().getOrder().getDgOrderdts();
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
				hinNo="-";
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
	data_arr[<%= counter%>][0] = "<%=dgsampleDetails.getId()%>"
	data_arr[<%= counter%>][1] = "<%=HMSUtil.convertDateToStringWithoutTime(dgsampleDetails.getSampleCollectionHeader().getOrder().getOrderDate())%>"
	data_arr[<%= counter%>][2] = "<%=dgsampleDetails.getSampleCollectionHeader().getOrder().getOrderTime()%>"
	
	
	data_arr[<%= counter%>][3] = "<%=hinNo%> "
	
	data_arr[<%= counter%>][4] = "<%=patientName%>"
	data_arr[<%= counter%>][5] = "<%=age%> "
	
	data_arr[<%= counter%>][6] = "<%=sex%> "
	
	<%if(dgsampleDetails.getSampleCollectionHeader().getOrder() != null){%>
	data_arr[<%= counter%>][7] = "<%=dgsampleDetails.getSampleCollectionHeader().getOrder().getPatientType()%> "
	<%}else{%>
	data_arr[<%= counter%>][7] ="-"
	<%}%>
	
	<%if(dgsampleDetails.getSampleCollectionHeader().getOrder().getDepartment() != null){%>
	data_arr[<%= counter%>][8] = "<%=dgsampleDetails.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%> "
	<%}else{%>
	data_arr[<%= counter%>][8] = "-"
	<%}%>
	
	<%
	if(dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy()!= null){
	String FirName="";String midName=""; String lastName="";
	if(dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName()!=null){
	FirName=dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName();
	}
	if(dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName()!=null){
	midName=dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName();
	}
	if(dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName()!=null){
	lastName=dgsampleDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName();
	}
	String name =FirName+" "+midName+" "+lastName;
						
	%>
	
	data_arr[<%= counter%>][9] = "<%=name%>"
	<%}else{%>
	data_arr[<%= counter%>][9] = "-"
	<%}%>
	
	<%if (dgsampleDetails.getInvestigation() != null){%>
	data_arr[<%= counter%>][10] = "<%=dgsampleDetails.getInvestigation().getInvestigationName()%> "
	<%}else{%>
	data_arr[<%= counter%>][10] = "-"
	<%}%>
	
	<%if (dgsampleDetails.getSampleCollectionHeader().getOrder().getHin() != null){%>
	data_arr[<%= counter%>][11] = "<%=patient.getId()%> "
	<%}else {%>
	data_arr[<%= counter%>][11] = "-"
<%   } %>

	data_arr[<%= counter%>][12] = "n" // added by amit das on 31-08-2017
<%  }
}%>
<%
	if (patientListForOutSideLab != null && patientListForOutSideLab.size() > 0) { 
 %>
<%
	String patientName = "";
	String age = "";
	String sex = "";
	String hinNo = "";
	for(DgOrderdt dgOrderdT : patientListForOutSideLab){
		
	
	Patient patient =dgOrderdT.getOrderhd().getHin();
/* 	for(DgOrderdt orderDt : set){
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
				hinNo="-";
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
		} */
		
	patientName = patient.getPFirstName();
		age = patient.getAge();
		sex = patient.getSex().getAdministrativeSexName();
		hinNo = patient.getHinNo();

%>
data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = "<%=dgOrderdT.getId()%>"
	data_arr[<%= counter%>][1] = "<%=HMSUtil.convertDateToStringWithoutTime(dgOrderdT.getOrderhd().getOrderDate())%>"
	data_arr[<%= counter%>][2] = "<%=dgOrderdT.getOrderhd().getOrderTime()%>"
	
	
	data_arr[<%= counter%>][3] = "<%=hinNo%> "
	
	data_arr[<%= counter%>][4] = "<%=patientName%>"
	data_arr[<%= counter%>][5] = "<%=age%> "
	
	data_arr[<%= counter%>][6] = "<%=sex%> "
	
	<%if(dgOrderdT.getOrderhd().getPatientType()!= null){%>
	data_arr[<%= counter%>][7] = "<%=dgOrderdT.getOrderhd().getPatientType()%> "
	<%}else{%>
	data_arr[<%= counter%>][7] ="-"
	<%}%> 
	
	<%if(dgOrderdT.getOrderhd().getDepartment() != null){%>
	data_arr[<%= counter%>][8] = "<%=dgOrderdT.getOrderhd().getDepartment().getDepartmentName()%> "
	<%}else{%>
	data_arr[<%= counter%>][8] = "-"
	<%}%>
	
	<%
	if(dgOrderdT.getOrderhd().getPrescribedBy()!= null){
	String FirName="";String midName=""; String lastName="";
	if(dgOrderdT.getOrderhd().getPrescribedBy().getFirstName()!=null){
	FirName  = dgOrderdT.getOrderhd().getPrescribedBy().getFirstName();
	}
	if(dgOrderdT.getOrderhd().getPrescribedBy().getMiddleName()!=null){
	midName  = dgOrderdT.getOrderhd().getPrescribedBy().getMiddleName();
	}
	if(dgOrderdT.getOrderhd().getPrescribedBy().getLastName()!=null){
	lastName = dgOrderdT.getOrderhd().getPrescribedBy().getLastName();
	}
	String name =FirName+" "+midName+" "+lastName;
						
	%>
	
	data_arr[<%= counter%>][9] = "<%=name%>"
	<%}else{%>
	data_arr[<%= counter%>][9] = "-"
	<%}%>
	
	<%if (dgOrderdT.getChargeCode() != null){%>
	data_arr[<%= counter%>][10] = "<%=dgOrderdT.getChargeCode().getChargeCodeName()%> "
	<%}else{%>
	data_arr[<%= counter%>][10] = "-"
	<%}%>
	
	data_arr[<%= counter%>][11] = "<%=patient.getId()%> "
	data_arr[<%= counter%>][12] = "y"
	
		<%	counter++;
	}
	}%>
	<%
	session.setAttribute("patientList",patientList);
%>
	formName = "pendingResultForOPScreen"
	start = 0
	if(data_arr.length < rowsPerPage){
	end = data_arr.length;
	}
	else{
	end = rowsPerPage;
	}
	makeTable(start,end);
</script>	


<%-- 	<form name="pendingLabResult" method="post" action="">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
		<script type="text/javascript">
formFields = [
[0, "<%= SAMPLE_COLLECTION_DETAIL_ID%>", "id"],[1,"smpcDate"],[2,"time"],[3,"hin"], [4,"patName"], [5,"age"], [6,"sex"],[7,"pType"],[8,"orderBy"],[9,"doct"],[10,"investigationId"],[11,"hinId"]];
statusTd = 11;
</script>
	</form> --%>

<%-- 	<div class="clear"></div>
	<div class="bottom">
		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
			type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</div> --%>
	
	<%-- <%
	 
	 if(request.getParameter("hinId") != null)
	 {
		 hinId = Integer.parseInt(request.getParameter("hinId"));
	 }
	 if(request.getParameter("RequisitionFrom") != null)
	 {
		 RequisitionFrom = request.getParameter("RequisitionFrom");
	 }
	
	%> --%>
	
	<%-- <input type="hidden" value="<%out.print(hinId); %>" id="hinId" name="hinId" />
	<input type="hidden" value="<%out.print(RequisitionFrom); %>" id="RequisitionFrom" name="RequisitionFrom" />
	<div class="clear"></div> --%>
	<%-- <script type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Order Date"
data_header[0][1] = "data";
data_header[0][2] = "10%";
data_header[0][3] = "smpcDate";

data_header[1] = new Array;
data_header[1][0] = "Order Time"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "time";

data_header[2] = new Array;
data_header[2][0] = "UHID "
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "hin";


data_header[3] = new Array;
data_header[3][0] = "Patient Name"
data_header[3][1] = "data";
data_header[3][2] = "20%";
data_header[3][3] = "patName";

data_header[4] = new Array;
data_header[4][0] = "Age"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "age";


data_header[5] = new Array;
data_header[5][0] = "Sex"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "sex";

data_header[6] = new Array;
data_header[6][0] = "P Type"
data_header[6][1] = "data";
data_header[6][2] = "10%";
data_header[6][3] = "pType";

data_header[7] = new Array;
data_header[7][0] = "Order By"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "orderBy";

data_header[8] = new Array;
data_header[8][0] = "Doctor"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "doct";

data_header[9] = new Array;
data_header[9][0] = "Test Name"
data_header[9][1] = "data";
data_header[9][2] = "14%";
data_header[9][3] = "investigationId";

data_header[10] = new Array;
data_header[10][0] = "hinId"
data_header[10][1] = "hide";
data_header[10][2] = "10%";
data_header[10][3] = "hinId";

data_arr = new Array();	
	
<script>	
	
	
<%
int  ncounter=0;
	if (patientListForOutSideLab != null && patientListForOutSideLab.size() > 0) { 
 %>
<%
	String patientName = "";
	String age = "";
	String sex = "";
	String hinNo = "";
	for(DgOrderdt dgOrderdT : patientListForOutSideLab){
		
	
	Patient patient =dgOrderdT.getOrderhd().getHin();
/* 	for(DgOrderdt orderDt : set){
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
				hinNo="-";
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
		} */
		
	patientName = patient.getPFirstName();
		age = patient.getAge();
		sex = patient.getSex().getAdministrativeSexName();
		hinNo = patient.getHinNo();

%>
data_arr[<%= ncounter%>] = new Array();
	data_arr[<%= ncounter%>][0] = "<%=dgOrderdT.getId()%>"
	data_arr[<%= ncounter%>][1] = "<%=HMSUtil.convertDateToStringWithoutTime(dgOrderdT.getOrderhd().getOrderDate())%>"
	data_arr[<%= ncounter%>][2] = "<%=dgOrderdT.getOrderhd().getOrderTime()%>"
	
	
	data_arr[<%= ncounter%>][3] = "<%=hinNo%> "
	
	data_arr[<%= ncounter%>][4] = "<%=patientName%>"
	data_arr[<%= ncounter%>][5] = "<%=age%> "
	
	data_arr[<%= ncounter%>][6] = "<%=sex%> "
	
	<%if(dgOrderdT.getOrderhd().getPatientType()!= null){%>
	data_arr[<%= ncounter%>][7] = "<%=dgOrderdT.getOrderhd().getPatientType()%> "
	<%}else{%>
	data_arr[<%= ncounter%>][7] ="-"
	<%}%>
	
	<%if(dgOrderdT.getOrderhd().getDepartment() != null){%>
	data_arr[<%= ncounter%>][8] = "<%=dgOrderdT.getOrderhd().getDepartment().getDepartmentName()%> "
	<%}else{%>
	data_arr[<%= ncounter%>][8] = "-"
	<%}%>
	
	<%
	if(dgOrderdT.getOrderhd().getPrescribedBy()!= null){
	String FirName="";String midName=""; String lastName="";
	if(dgOrderdT.getOrderhd().getPrescribedBy().getFirstName()!=null){
	FirName  = dgOrderdT.getOrderhd().getPrescribedBy().getFirstName();
	}
	if(dgOrderdT.getOrderhd().getPrescribedBy().getMiddleName()!=null){
	midName  = dgOrderdT.getOrderhd().getPrescribedBy().getMiddleName();
	}
	if(dgOrderdT.getOrderhd().getPrescribedBy().getLastName()!=null){
	lastName = dgOrderdT.getOrderhd().getPrescribedBy().getLastName();
	}
	String name =FirName+" "+midName+" "+lastName;
						
	%>
	
	data_arr[<%= ncounter%>][9] = "<%=name%>"
	<%}else{%>
	data_arr[<%= ncounter%>][9] = "-"
	<%}%>
	
	<%if (dgOrderdT.getChargeCode() != null){%>
	data_arr[<%= ncounter%>][10] = "<%=dgOrderdT.getChargeCode().getChargeCodeName()%> "
	<%}else{%>
	data_arr[<%= ncounter%>][10] = "-"
	<%}%>
	
	data_arr[<%= ncounter%>][11] = "<%=patient.getId()%> "
	
<%	
	ncounter++;
	}
	}%>	
	
	
<%
	session.setAttribute("patientList",patientList);
%>
	formName = "pendingLabResult"
	start = 0
	if(data_arr.length < rowsPerPage){
	end = data_arr.length;
	}
	else{
	end = rowsPerPage;
	}
	makeTableForOutSideLab(start,end);
</script> --%>







</div>