<%-- 
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* File Name           : pendingResultEntry.jsp 
* Tables Used         : DgOrderhd,DgSampleCollectionHeader,DgSampleCollectionDetails,MasSample,Patient,MasSubChargecode
* Description         : 
* @author  Create Date: 21.07.2008    Name: Shailesh
* Revision Date:      Revision By: 
* @version 1.0  

--%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>



<% 
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<form name="patientSearch" action="" method="post">
	<script src="/hms/jsp/js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script type="text/javascript" language="javascript"> 
$(document).ready(function() {   
   // var pressed = false; 
    var chars = []; 
    $(window).keypress(function(e) {  
    	console.log("Barcode Scanned: " + e.which);
        if (e.which >= 48 && e.which <= 57) { 
            chars.push(String.fromCharCode(e.which)); 
        } 
        if (e.which===13) { 
            setTimeout(function(){
                if (chars.length >= 1) {
                    var barcode = chars.join("");
                    console.log("Barcode Scanned: " + barcode);
                    // assign value to some input (or do whatever you want)
                    $("#barcode").val(barcode);
                    $("#submitButtonId").click();
                }
                chars = [];
               // pressed = false;
            },500); 
        }
       // pressed = true; 
    });
});
$("#barcode").keypress(function(e){  
    if ( e.which === 13 ) {
        console.log("Prevent form submit.");
        e.preventDefault();
    }
});

</script>
	<script type="text/javascript" language="javascript">
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
	<%
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	List<Object[]> patientList = new ArrayList<Object[]>();
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	date = (String) utilMap.get("currentDate");
	String message = "";
	Date toDate  = null;
	Date fromDate=null;
	Box box = null;
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
		patientList= (List<Object[]>)patientMap.get("patientList");
	}
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
	if(session.getAttribute("boxForResultEntry") != null){
		box = (Box)session.getAttribute("boxForResultEntry");
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
	List<DgSampleCollectionDetails> sampleDetailList = new ArrayList<DgSampleCollectionDetails>();
	if(detailsMap.get("sampleDetailList") != null){
		sampleDetailList = (List<DgSampleCollectionDetails>)detailsMap.get("sampleDetailList");
	}
	int deptId=0;
	if (map.get("deptId") != null) {
		deptId = (Integer) map.get("deptId");
	}
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	List<MasSample> sampleList = new ArrayList<MasSample>();
	if (detailsMap.get("sampleList") != null) {
		sampleList = (List<MasSample>) detailsMap.get("sampleList");
	}
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	System.out.println("sampleList.size()---------->> "+sampleList.size());
	if (detailsMap.get("investigationList") != null) {
		investigationList = (List<DgMasInvestigation>) detailsMap.get("investigationList");
	}
	
	//	List<String> orderBillList = new ArrayList<String>();
//	if(detailsMap.get("orderBillList") != null){
//		orderBillList = (List<String>)detailsMap.get("orderBillList");
//	}
	
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
	<%if(deptId == 49){ %>
	<div class="titleBg">
		<h2>Pending For Report Entry</h2>
	</div>
	<%}else{ %>
	<div class="titleBg">
		<h2>Pending For Result Entry</h2>
	</div>
	<%} %>
	<div class="clear"></div>
	<h4>Patient Search</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<%if(box != null) {%>
		<label><span>*</span> From Date</label> <input type="text"
			class="date" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=box.getString(FROM_DATE)%>" readonly="readonly"
			MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

		<label style=""><span>*</span>To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=box.getString(TO_DATE)%>" class="date"
			readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

		<label>Patient Type</label> <select name="<%=PATIENT_TYPE%>"
			id="<%=PATIENT_TYPE%>" validate="P Type,string,no">
			<option value="">Select One</option>
			<option value="IP">IP</option>
			<option value="OP">OP</option>
		</select>
		<script type="text/javascript">
			document.getElementById('<%=PATIENT_TYPE%>').value='<%=box.getString(PATIENT_TYPE)%>';
		</script>
		<div class="clear"></div>
		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="<%=box.getString(P_FIRST_NAME)%>"
			MAXLENGTH="30" /> <label>IP No.</label> <input type="text"
			name="<%=AD_NO %>" value="<%=box.getString(AD_NO)%>" MAXLENGTH="30" />
		<label>Order By</label> <select id="departmentId"
			name="<%=DEPARTMENT_ID %>">
			<option value="0">Select</option>
			<% for(MasDepartment masDepartment : departmentList){%>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
			<%}%>
		</select>
		<script type="text/javascript">
			document.getElementById('<%=DEPARTMENT_ID%>').value='<%=box.getString(DEPARTMENT_ID)%>';
		</script>
		<div class="clear"></div>
		<script type="text/javascript">
			document.getElementById('<%=SUB_CHARGECODE_ID%>').value='<%=box.getString(SUB_CHARGECODE_ID)%>';
		</script>
		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input
			type="text" name="<%=HIN_NO %>" value="<%=box.getString(HIN_NO)%>"
			MAXLENGTH="50" />
		<%}else{ %>
		<label><span>*</span> From Date</label> <input type="text"
			class="date" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

		<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
			readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

		<%} %>
		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input
			type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" />
		<div class="clear"></div>
		<label>Patient Type</label> <select name="<%=PATIENT_TYPE%>"
			id="patientType" validate="P Type,string,no">
			<option value="">Select One</option>
			<option value="OP">OP</option>
			<option value="IP">IP</option>
		</select> <label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <input
			type="text" name="<%=AD_NO %>" value="" MAXLENGTH="30" /> <label>Ward
		</label> <input type="text" name="<%=WARD_NAME %>" value="" MAXLENGTH="15" />
		<%-- <label>Order By</label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>


	<% for(MasDepartment masDepartment : departmentList){%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select> --%>
		<div class="clear"></div>
		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="30" />
		<%-- <label>Sub Department</label> <select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>">
			<option value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>
		</select> --%>
		<label>Mobile No</label> <input type="text" name="<%=MOBILE_NO %>"
			value="" MAXLENGTH="50" /> <input type="hidden" name="<%=BARCODE%>"
			value="" MAXLENGTH="15" id="barcode" />
		<label>Sample</label>
		<select name="sampleName" id="sampleId">
		<option value="0">Select</option>
		<%for(MasSample sample:sampleList){ %>
		<option value="<%=sample.getId()%>"><%=sample.getSampleDescription() %></option>
		<%} %>
		</select>
		<div class="clear"></div>
		<label>Investigation</label>
		<select name="invName" class="multiple" id="invId" multiple="multiple" size="8">
		<option value="0">Select</option>
		<%for(DgMasInvestigation inv:investigationList){ %>
		<option value="<%=inv.getId()%>"><%=inv.getInvestigationName() %></option>
		<%} %>
		</select>
		<label>Modality</label> <select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>">
			<option value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>
		</select>

		<div class="clear"></div>

		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<input type="button" value="Search" class="button"
		onclick="submitForm('patientSearch','/hms/hms/investigation?method=searchPatientForLabForEmpanelled','checkFromNTodata','chkPatientTypeForBillno');"
		accesskey="a" id="submitButtonId" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
	<div id="searchtable" tabindex="2"></div>
	<div class="clear"></div>

	<form name="pendingResultForLabForEmpanelled" method="post" action="">
		<div id="deletebutton"></div>
		<input type="hidden" name="edited" id="edited" value="" />
		<div class="paddingTop15"></div>
		<input type="hidden" name="Delete" value=""> <script
				type="text/javascript">
	formFields = [
		[0, "<%= SAMPLE_COLLECTION_DETAIL_ID%>", "id"],[1,"smpcDate"],[2,"sampleId"],[3,"time"], [4,"serNo"],[5,"patName"],[6,"sPerName"],
		[7,"hin"], [8,"ipNo"],[9,"age"], [10,"sex"],[11,"pType"],[12,"orderBy"],[13,"doct"],[14,"hinId"],[15,"sampleHeaderId"],
		[16,"subChargeName"],[17,"subChargeNameId"],[18,"wardNo"],[19,"status"],[20,"priority"]];
		statusTd = 15;
	</script>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
	</form>
</div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<script type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Date"
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "smpcDate";


data_header[1] = new Array;
data_header[1][0] = "Sample Id"
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "sampleId";

data_header[2] = new Array;
data_header[2][0] = "Order Time"
data_header[2][1] = "hide";
data_header[2][2] = "15%";
data_header[2][3] = "time";

data_header[3] = new Array;
data_header[3][0] = "Service no"
data_header[3][1] = "hide";
data_header[3][2] = "15%";
data_header[3][3] = "serNo";


data_header[4] = new Array;
data_header[4][0] = "Patient Name"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "patName";

data_header[5] = new Array;
data_header[5][0] = "S Person Name"
data_header[5][1] = "hide";
data_header[5][2] = "10%";
data_header[5][3] = "sPerName";


data_header[6] = new Array;
data_header[6][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
data_header[6][1] = "data";
data_header[6][2] = "20%";
data_header[6][3] = "hin";

data_header[7] = new Array;
data_header[7][0] = "IP No"
data_header[7][1] = "hide";
data_header[7][2] = "10%";
data_header[7][3] = "ipNo"; 

data_header[8] = new Array;
data_header[8][0] = "Age"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "age";

data_header[9] = new Array;
data_header[9][0] = "Gender"
data_header[9][1] = "data";
data_header[9][2] = "10%";
data_header[9][3] = "sex";

data_header[10] = new Array;
data_header[10][0] = "P Type"
data_header[10][1] = "hide";
data_header[10][2] = "10%";
data_header[10][3] = "pType";

data_header[11] = new Array;
data_header[11][0] = "Order By"
data_header[11][1] = "hide";
data_header[11][2] = "10%";
data_header[11][3] = "orderBy";

data_header[12] = new Array;
data_header[12][0] = "Doctor Name"
data_header[12][1] = "data";
data_header[12][2] = "14%";
data_header[12][3] = "doct";

data_header[13] = new Array;
data_header[13][0] = "hinId"
data_header[13][1] = "hide";
data_header[13][2] = "10%";
data_header[13][3] = "hinId";

data_header[14] = new Array;
data_header[14][0] = "SampleHeaderId"
data_header[14][1] = "hide";
data_header[14][2] = "10%";
data_header[14][3] = "sampleHeaderId";

data_header[15] = new Array;
data_header[15][0] = "Sub Department"
data_header[15][1] = "hide";
data_header[15][2] = "10%";
data_header[15][3] = "subChargeName";

data_header[16] = new Array;
data_header[16][0] = "Sub Department Id"
data_header[16][1] = "hide";
data_header[16][2] = "10%";
data_header[16][3] = "subChargeNameId";

data_header[17] = new Array;
data_header[17][0] = "Ward"
data_header[17][1] = "hide";
data_header[17][2] = "10%";
data_header[17][3] = "wardNo";

data_header[18] = new Array;
data_header[18][0] = "Status"
data_header[18][1] = "data";
data_header[18][2] = "10%";
data_header[18][3] = "status";

data_header[19] = new Array;
data_header[19][0] = "Priority"
data_header[19][1] = "data";
data_header[19][2] = "10%";
data_header[19][3] = "priority";


data_arr = new Array();
</script>
<%
	int  counter=0;
	List<String> combinedListAll = new ArrayList<String>();
	for(int ilop=0;ilop<patientList.size();ilop++) {
		if(RequestConstants.UHID_FOR_QUALITY_TESTING.equals(((DgSampleCollectionHeader)patientList.get(ilop)[0]).getHin().getHinNo())){
			 continue;
		}
		combinedListAll.add(((DgSampleCollectionHeader)patientList.get(ilop)[0]).getId()+","+((MasSubChargecode)patientList.get(ilop)[1]).getId());
		
		
		
		%>


<jsp:include page="pendingResultEntryLabGrid.jsp" flush="true">
	<jsp:param name="counter" value="<%=counter%>" />
	<jsp:param name="resultEntryIndex" value="<%=(ilop)%>" />
</jsp:include>
<% counter++;} %>


<%
	if(session.getAttribute("combinedListAll") != null){
		session.removeAttribute("combinedListAll");
		session.setAttribute("combinedListAll",combinedListAll);
	}else{
		session.setAttribute("combinedListAll",combinedListAll);
	}
	%>
	
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
	
	
<script type="text/javascript" language="javascript">
formName = "pendingResultForLabForEmpanelled"
start = 0
if(data_arr.length < rowsPerPage){
end = data_arr.length;
}
else{
end = rowsPerPage;

}

makeTable(start,end);


/* function chkPatientTypeForBillno(){
	if(document.getElementById('billNo').value != ""){
		if(document.getElementById('patientType').value == ""){
			alert("Please select P Type.");
			return false;
		}
	
	}
	return true;
} */

</script>


