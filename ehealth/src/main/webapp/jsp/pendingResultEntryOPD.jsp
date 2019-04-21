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

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
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
	String toDateStr  = null;
	String fromDateStr = null;
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
		fromDateStr = (String) map.get("fromDate");
		session.setAttribute("fromDate", fromDate);
	}
	if (map.get("toDate") != null) {
		toDateStr = (String) map.get("toDate");
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
	System.out.println("sampleList.size()---------->>"+sampleList.size());
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
	<div class="Block">
		<div class="clear"></div>
	
		
		

		<div class="clear"></div>

		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
	<div id="searchtable" tabindex="2"></div>
	<div class="clear"></div>

	<form name=pendingResultForLab method="post" action="">
		<div id="deletebutton"></div>
		<input type="hidden" name="edited" id="edited" value="" />
		<div class="paddingTop15"></div>
		<input type="hidden" name="Delete" value=""> <script
				type="text/javascript">
	formFields = [
		[0, "<%= SAMPLE_COLLECTION_DETAIL_ID%>", "id"],[1,"smpcDate"],[2,"time"], [3,"serNo"],[4,"sPerName"], [5,"hin"], [6,"ipNo"], [7,"patName"], [8,"age"], [9,"sex"],[10,"pType"],[11,"orderBy"],[12,"doct"],[13,"hinId"],[14,"sampleHeaderId"],[15,"subChargeName"],[16,"subChargeNameId"],[17,"wardNo"],[18,"status"],[19,"priority"]];
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
data_header[1][0] = "Order Time"
data_header[1][1] = "hide";
data_header[1][2] = "15%";
data_header[1][3] = "time";

data_header[2] = new Array;
data_header[2][0] = "Service no"
data_header[2][1] = "hide";
data_header[2][2] = "15%";
data_header[2][3] = "serNo";

data_header[3] = new Array;
data_header[3][0] = "S Person Name"
data_header[3][1] = "hide";
data_header[3][2] = "10%";
data_header[3][3] = "sPerName";


data_header[4] = new Array;
data_header[4][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
data_header[4][1] = "data";
data_header[4][2] = "20%";
data_header[4][3] = "hin";

data_header[5] = new Array;
data_header[5][0] = "IP No"
data_header[5][1] = "hide";
data_header[5][2] = "10%";
data_header[5][3] = "ipNo";

data_header[6] = new Array;
data_header[6][0] = "Patient Name"
data_header[6][1] = "data";
data_header[6][2] = "10%";
data_header[6][3] = "patName";

data_header[7] = new Array;
data_header[7][0] = "Age"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "age";

data_header[8] = new Array;
data_header[8][0] = "Gender"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "sex";

data_header[9] = new Array;
data_header[9][0] = "P Type"
data_header[9][1] = "hide";
data_header[9][2] = "10%";
data_header[9][3] = "pType";

data_header[10] = new Array;
data_header[10][0] = "Order By"
data_header[10][1] = "hide";
data_header[10][2] = "10%";
data_header[10][3] = "orderBy";

data_header[11] = new Array;
data_header[11][0] = "Doctor Name"
data_header[11][1] = "data";
data_header[11][2] = "14%";
data_header[11][3] = "doct";

data_header[12] = new Array;
data_header[12][0] = "hinId"
data_header[12][1] = "hide";
data_header[12][2] = "10%";
data_header[12][3] = "hinId";

data_header[13] = new Array;
data_header[13][0] = "SampleHeaderId"
data_header[13][1] = "hide";
data_header[13][2] = "10%";
data_header[13][3] = "sampleHeaderId";

data_header[14] = new Array;
data_header[14][0] = "Sub Department"
data_header[14][1] = "hide";
data_header[14][2] = "10%";
data_header[14][3] = "subChargeName";

data_header[15] = new Array;
data_header[15][0] = "Sub Department Id"
data_header[15][1] = "hide";
data_header[15][2] = "10%";
data_header[15][3] = "subChargeNameId";

data_header[16] = new Array;
data_header[16][0] = "Ward"
data_header[16][1] = "hide";
data_header[16][2] = "10%";
data_header[16][3] = "wardNo";

data_header[17] = new Array;
data_header[17][0] = "Status"
data_header[17][1] = "data";
data_header[17][2] = "10%";
data_header[17][3] = "status";

data_header[18] = new Array;
data_header[18][0] = "Priority"
data_header[18][1] = "data";
data_header[18][2] = "10%";
data_header[18][3] = "priority";

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
formName = "pendingResultForLab"
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


