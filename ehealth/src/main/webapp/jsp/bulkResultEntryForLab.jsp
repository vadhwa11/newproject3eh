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
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.Patient"%>
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
<form name="patientSearch" action="" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<!-- <script src="/hms/jsp/js/jquery-1.7.2.min.js" type="text/javascript"></script> -->
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
	List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	date = (String) utilMap.get("currentDate");
	String message = "";
	String toDate  = null;
	String fromDate=null;
	String patientFName =  null;
	String adNo = null;
	String hinNo = null;
	String orderType = null;
	String nameOfChargeCode = null;
	String wardName = null;
	String mobileNo = null;
	
	Box box = null;
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("detailsMap") !=null ){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	if (detailsMap.get("adNo") != null) {
		adNo = (String) detailsMap.get("adNo");
	}
	 System.out.println("adno"+adNo);
	if (detailsMap.get("hinNo") != null) {
		hinNo = (String) detailsMap.get("hinNo");
	}
	if (detailsMap.get("orderType") != null) {
		orderType = (String) detailsMap.get("orderType");
	}
	if (detailsMap.get("patientFName") != null) {
		patientFName = (String) detailsMap.get("patientFName");
	}
	if (detailsMap.get("toDate") != null &&  !detailsMap.get("toDate").toString().isEmpty()) {
		toDate = (String) detailsMap.get("toDate");
		session.setAttribute("toDate", toDate);
	}
	if (detailsMap.get("fromDate") != null &&  !detailsMap.get("fromDate").toString().isEmpty()) {
		session.setAttribute("fromDate", fromDate);
		fromDate = (String) detailsMap.get("fromDate");
	}
	if (detailsMap.get("nameOfChargeCode") != null) {
		nameOfChargeCode = (String) detailsMap.get("nameOfChargeCode");
	}
	
	if (detailsMap.get("wardName") != null) {
		wardName = (String) detailsMap.get("wardName");
	}

	if (detailsMap.get("mobileNo") != null) {
		mobileNo = (String) detailsMap.get("mobileNo");
	}
	if(map.get("patientMap") != null){
		patientMap= (Map<String, Object>)map.get("patientMap");
	}
	if(patientMap.get("patientList") != null){
		patientList= (List<DgSampleCollectionDetails>)patientMap.get("patientList");
	}
	if(map.get("message") != null){
		message= (String)map.get("message");
	}
/* 	if (map.get("fromDate") != null && !map.get("fromDate").toString().isEmpty()){
		fromDate = (Date) map.get("fromDate");
		session.setAttribute("fromDate", fromDate);
	}
	if (map.get("toDate") != null && !map.get("toDate").toString().isEmpty()) {
		toDate = (Date) map.get("toDate");
		session.setAttribute("toDate", toDate);
	} */
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
		<h2>Bulk Result Entry</h2>
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

		<label style=""><span>*</span>To Date</label> <input type="text"
			id="ToDateId" name="<%=TO_DATE %>"
			value="<%=box.getString(TO_DATE)%>" class="date" readonly="readonly"
			validate="To Date,date,yes" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

		<label>P Type</label> <select name="<%=PATIENT_TYPE%>"
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
		<label>Sub Department</label> <select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>">
			<option value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>
		</select>
		<script type="text/javascript">
			document.getElementById('<%=SUB_CHARGECODE_ID%>').value='<%=box.getString(SUB_CHARGECODE_ID)%>';
		</script>
		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input
			type="text" name="<%=HIN_NO %>" value="<%=hinNo!=null?hinNo:"" %>"
			MAXLENGTH="50" />
		<%}else{ %>
		<label><span>*</span> From Date</label> <input type="text"
			class="date" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=fromDate!=null?fromDate:currentDate%>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

		<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=toDate!=null?toDate:currentDate%>" class="date"
			readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%= currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

		<%} %>
		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input
			type="text" name="<%=HIN_NO %>" value="<%=hinNo!=null?hinNo:""%>" MAXLENGTH="50" />
		<div class="clear"></div>
		<label>P Type</label> <select name="<%=PATIENT_TYPE%>"
			id="patientType" validate="P Type,string,no">
			<option value="">Select One</option>
			<option value="OP" <%=orderType!=null && orderType.equalsIgnoreCase("OP")?"selected":"" %>>OP</option>
			<option value="IP"<%=orderType!=null && orderType.equalsIgnoreCase("IP")?"selected":"" %>>IP</option>
		</select> <label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <input
			type="text" name="<%=AD_NO %>"  MAXLENGTH="30" value="<%=adNo!=null?adNo:""%>"/> <label>Ward
		</label> <input type="text" name="<%=WARD_NAME %>" value="<%=wardName!=null?wardName:""%>" MAXLENGTH="15" />
		<div class="clear"></div>
		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="<%=patientFName!=null?patientFName:""%>" MAXLENGTH="30" /> <label>Mobile
			No</label> <input type="text" name="<%=MOBILE_NO %>"  MAXLENGTH="10" value="<%=mobileNo!=null?mobileNo:"" %>"/>
		<label>Test Name</label> <input type="text" id="chargeCode" onblur="validateTestName(this);"
			name="chargeCode" tabindex=1 value="<%=nameOfChargeCode!=null?nameOfChargeCode:"" %>">
			<div class="autocomplete" style="display: none;" id="ac2update"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('chargeCode','ac2update','lab?method=getChargeCodeForAutoComplete&mainChargeCodeId=17&subChargeCodeId=0',{parameters:'requiredField=chargeCode'});
		</script> <input type="hidden" name="<%=BARCODE%>" value="" MAXLENGTH="15"
			id="barcode" />
			<div class="clear"></div>


			<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<input type="button" value="Search" class="button"
		onclick="submitForm('patientSearch','/hms/hms/investigation?method=bulkSearchPatientForLab','checkFromNTodata','chkPatientTypeForBillno');"
		accesskey="a" id="submitButtonId" />
	
</form>

<div class="clear"></div>
<%if(patientList.size()>0){%>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div class="cmntable">
	<table border="0" cellspacing="0" width="100%" cellpadding="0">
		<tr>
			<th>Date</th>
			<th><%=prop.getProperty("com.jkt.hms.registration_no") %></th>
			<th>Patient Name</th>
			<th>Age</th>
			<th>Doctor Name</th>
			<th>Priority</th>
			<th>Test Name</th>
			<th>Add Result</th>
		</tr>
		<%
	Patient patient = new Patient(); 
	DgSampleCollectionHeader dgSampleCollHeader = new DgSampleCollectionHeader();
	MasSubChargecode subChargeCode = new MasSubChargecode();
	int  counter=0;
	List<String> combinedListAll = new ArrayList<String>();
	for(DgSampleCollectionDetails dgCollectionDetails:patientList) { 
		if(RequestConstants.UHID_FOR_QUALITY_TESTING.equals(dgCollectionDetails.getSampleCollectionHeader().getHin().getHinNo())){
			continue;
		}
		combinedListAll.add(dgCollectionDetails.getSampleCollectionHeader().getId()+","+dgCollectionDetails.getSubcharge().getId());	
		 %>
		<tr>
			<td><%=HMSUtil.convertDateToStringWithoutTime(dgCollectionDetails.getSampleCollectionHeader().getOrder().getOrderDate())%></td>
			<td><%=dgCollectionDetails.getSampleCollectionHeader().getHin().getHinNo()%></td>
			<%
		if(dgCollectionDetails.getSampleCollectionHeader().getHin().getPFirstName() != null  && !(dgCollectionDetails.getSampleCollectionHeader().getHin().getPFirstName().equals(""))){
		String pMiddleName = "";
		String pLastName = "";
		if(dgCollectionDetails.getSampleCollectionHeader().getHin().getPMiddleName() != null){
		pMiddleName = dgCollectionDetails.getSampleCollectionHeader().getHin().getPMiddleName();
		}
		if(dgCollectionDetails.getSampleCollectionHeader().getHin().getPLastName() != null){
		pLastName = dgCollectionDetails.getSampleCollectionHeader().getHin().getPLastName();
		}
		String pName = dgCollectionDetails.getSampleCollectionHeader().getHin().getPFirstName()+" "+pMiddleName+" "+pLastName;
		%>
			<td><%=pName%></td>
			<%}else{%>
			<td>-</td>
			<%}%>
			<td><%=dgCollectionDetails.getSampleCollectionHeader().getHin().getAge()%></td>
			<%if(dgCollectionDetails.getSampleCollectionHeader().getOrder().getPrescribedBy()!= null){
					String FirName="";String midName=""; String lastName="";
					if(dgCollectionDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName()!=null){
						FirName = dgCollectionDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName();
					}
					if(dgCollectionDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName()!=null){
						midName = dgCollectionDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName();
					}
					if(dgCollectionDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName()!=null){
						lastName = dgCollectionDetails.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName();
					}
					String name =FirName+" "+midName+" "+lastName;
			%>
			<td><%=name%></td>
			<%}else{%>
			<td>-</td>
			<%}%>
			<% 
			String status="";
			if("u".equalsIgnoreCase(dgCollectionDetails.getSampleCollectionHeader().getOrder().getRoutineUrgentStatus())){
			status="Urgent";
			}else{
			status="Routine";
			}
			%>
			<td><%=status%></td>
			<td><%=dgCollectionDetails.getChargeCode().getChargeCodeName() %></td>
			<td><input type="hidden" name="dgSampleCollectionHeader"
				id="dgSampleCollectionHeaderId<%=counter%>"
				value="<%=dgCollectionDetails.getSampleCollectionHeader().getId()%>"></input> <input
				type="hidden" name="subCharge"
				id="subChargeId<%=counter%>"
				value="<%=dgCollectionDetails.getSubcharge().getId()%>"></input> <input
				type="button" tabindex="1" onclick="normal(<%=counter%>);"
				class="buttonAdd" value="" name="add"></td>
		</tr>
		<% counter++;} %>
	</table>
</div>
<%

if(session.getAttribute("combinedListAll") != null){
	session.removeAttribute("combinedListAll");
	session.setAttribute("combinedListAll",combinedListAll);
}else{
	session.setAttribute("combinedListAll",combinedListAll);
}

} else {%>
No Record Found.
<%} %>
<div class="clear"></div>
<div id="searchresults" tabindex="2">
	<div id="searchtable" tabindex="2"></div>
	<div class="clear"></div>
</div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<script type="text/javascript" language="javascript">
function normal(rowNo,subTestId,chargeCodeId){ 
	get_value(rowNo,subTestId,chargeCodeId); 
	}
function get_value(rowNo,subTestId,chargeCodeId)
{
var sampleHeaderId;
sampleHeaderId =document.getElementById('dgSampleCollectionHeaderId'+rowNo).value
var subCarge;
subCarge =document.getElementById('subChargeId'+rowNo).value;
var url="/hms/hms/investigation?method=searchResultForBulk&sampleCollectionDetailId="+sampleHeaderId+','+subCarge; 
popwindow(url);
}
function popwindow(url)
{

newwindow=window.open(url,'name',"height=250,width=950,scrollbars=1,status=1");
if (window.focus)
{
newwindow.focus()
} 
}

function validateTestName(obj) {
	if (obj!=null && obj.value != "") {
		var val=obj.value;
		var index1 = val.lastIndexOf("[");
		var indexForBrandName = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvmsNo = val.substring(index1, index2);
		var indexForBrandName = indexForBrandName--;
		var brandName = val.substring(0, indexForBrandName);
		if (pvmsNo == "") {
			document.getElementById(obj.id).value = "";
			return;
		}
	}
}
</script>