<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pendingSampleValidation.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author    Name: Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
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
                    $("#addbutton").click();
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
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<form name="patientSearch" action="" method="post">
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
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<DgSampleCollectionHeader> patientDeatilList = new ArrayList<DgSampleCollectionHeader>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String userName = "";
		String message = "";
		String deptType = "";
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(patientMap.get("patientDeatilList") != null){
			patientDeatilList= (List<DgSampleCollectionHeader>)patientMap.get("patientDeatilList");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
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
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		if (map.get("deptType") != null) {
			deptType = (String) map.get("deptType");
		}
	%>
	<script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			
		<%}
	%>
	</script>
	<div class="clear"></div>
	<% if(deptType.equalsIgnoreCase("DIAG")){ %>
	<div class="titleBg">
		<h2> Pending for Sample Validation</h2>
	</div>
	<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
	<div class="titleBg">
		<h2>Acceptance for Radiological Investigations</h2>
	</div>
	<%} %>
	<div class="clear"></div>
	<h4>Patient Search</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<label><span>*</span> From Date</label> <input type="text"
			class="date" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />
		<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
			readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />
		<%-- <label>Order By</label> 
<select id="departmentId"	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
		for(MasDepartment masDepartment : departmentList){
			%>
	<option value="<%=masDepartment.getId() %>"
		<%=HMSUtil.isSelected(masDepartment.getId(),(Integer)(session.getAttribute("deptId")))%>><%=masDepartment.getDepartmentName() %></option>
	<% }%>
</select> --%>
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input
			id="hinId" type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" />
		<div class="clear"></div>
		<label>Patient Type</label> <select name="<%=PATIENT_TYPE%>">
			<option value="OP">OP</option>
			<option value="IP">IP</option>
		</select> <label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label> <input
			id="adId" type="text" name="<%=AD_NO %>" value=""
			class="textbox_size20" MAXLENGTH="50" /> <label>Ward</label> <input
			type="text" name="<%=WARD_NAME%>" value="" MAXLENGTH="15" />
		<div class="clear"></div>

		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" /> <label>Mobile
			No</label> <input type="text" name="<%=MOBILE_NO%>" value="" MAXLENGTH="15" />
		<input type="hidden" name="<%=BARCODE%>" value="" MAXLENGTH="15"
			id="barcode" /> <label>&nbsp;</label>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<input type="button" name="save" id="addbutton"
		onclick="submitForm('patientSearch','/hms/hms/lab?method=searchPatientForValidationForQC');"
		value="Search" class="button" accesskey="a" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
	<div id="searchtable" tabindex="2"></div>
	<form name="pendingSampleValidation" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
		type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
		type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<script type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1,"diagDate"],[2,"diagTime"], [3,"hin"],[4,"ipNo"], [5,"patName"],[6,"orderBy"],[7,"age"],[8,"sex"],[9,"doctorName"],[10,"ward"],[11,"priority"]];
	 statusTd = 5;
	</script>

</form></div>
<script type="text/javascript" language="javascript"> 
	
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Date"
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "diagDate"

data_header[1] = new Array;
data_header[1][0] = "Time"
data_header[1][1] = "hide";
data_header[1][2] = "7%";
data_header[1][3] = "diagTime"

data_header[2] = new Array;
data_header[2][0] = "<%=prop.getProperty("com.jkt.hms.registration_no")%>"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "hin";

data_header[3] = new Array;
data_header[3][0] = "IP No"
data_header[3][1] = "hide";
data_header[3][2] = "15%";
data_header[3][3] = "ipNo";

data_header[4] = new Array;
data_header[4][0] = "Patient Name"
data_header[4][1] = "data";
data_header[4][2] = "20%";
data_header[4][3] = "patName";

data_header[5] = new Array;
data_header[5][0] = "Order By"
data_header[5][1] = "hide";
data_header[5][2] = "20%";
data_header[5][3] = "orderBy"; 

data_header[6] = new Array;
data_header[6][0] = "Age"
data_header[6][1] = "data";
data_header[6][2] = "20%";
data_header[6][3] = "age";

data_header[7] = new Array;
data_header[7][0] = "Gender"
data_header[7][1] = "data";
data_header[7][2] = "20%";
data_header[7][3] = "sex";

data_header[8] = new Array;
data_header[8][0] = "Doctor Name"
data_header[8][1] = "data";
data_header[8][2] = "20%";
data_header[8][3] = "doctorName";

data_header[9] = new Array;
data_header[9][0] = "Ward"
data_header[9][1] = "hide";
data_header[9][2] = "20%";
data_header[9][3] = "ward";

data_header[10] = new Array;
data_header[10][0] = "Priority"
data_header[10][1] = "data";
data_header[10][2] = "20%";
data_header[10][3] = "priority";

data_arr = new Array();
	<%
	String patientName = "";
	String age = "";
	String sex = "";
	String hinNo = "";
	    int  counter=0;
		if (patientDeatilList != null && patientDeatilList.size() > 0) { 
			outerloop:	
			for(DgSampleCollectionHeader dgSampleCollectionHeader : patientDeatilList){
				Patient patient = dgSampleCollectionHeader.getHin();
				if(!RequestConstants.UHID_FOR_QUALITY_TESTING.equals(patient.getHinNo())){
					continue;
				} 
				Set<DgOrderdt> set = new HashSet<DgOrderdt>();
				set = dgSampleCollectionHeader.getOrder().getDgOrderdts();
				for(DgOrderdt orderDt : set){
					if("n".equalsIgnoreCase(orderDt.getPaymentMade()) && (!"IP".equalsIgnoreCase(orderDt.getOrderhd().getPatientType()))){
						
						continue outerloop;
					}
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
			data_arr[<%= counter%>][0] = <%= dgSampleCollectionHeader.getId()%>
			data_arr[<%= counter%>][1] = "<%= HMSUtil.convertDateToStringWithoutTime(dgSampleCollectionHeader.getDiagnosisDate())%>"
			data_arr[<%= counter%>][2] = "<%= dgSampleCollectionHeader.getDiagnosisTime()%>" 
			data_arr[<%= counter%>][3] = "<%=hinNo%>"
			
			data_arr[<%= counter%>][4] = "2154"
			data_arr[<%= counter%>][5] = "<%=patientName%>"
				<%
				if(dgSampleCollectionHeader.getDepartment().getDepartmentName() != null){
					
			%>
			data_arr[<%= counter%>][6] = "<%=dgSampleCollectionHeader.getDepartment().getDepartmentName()%> "
			<%}%>
			
			data_arr[<%= counter%>][7] = "<%= dgSampleCollectionHeader.getHin().getAge()%>"
			data_arr[<%= counter%>][8] = "<%= dgSampleCollectionHeader.getHin().getSex().getAdministrativeSexName()%>"
				<%String doctorName="";
			 if(dgSampleCollectionHeader.getOrder().getPrescribedBy() !=null){
				doctorName=doctorName.concat(dgSampleCollectionHeader.getOrder().getPrescribedBy().getEmployeeName()+" "); 
			} 
			/* if(dgSampleCollectionHeader.getOrder().getPrescribedBy().getMiddleName()!=null){
				doctorName=doctorName.concat(dgSampleCollectionHeader.getOrder().getPrescribedBy().getMiddleName()+" ");
			}if(dgSampleCollectionHeader.getOrder().getPrescribedBy().getLastName()!=null){
				doctorName=doctorName.concat(dgSampleCollectionHeader.getOrder().getPrescribedBy().getLastName());
			}   */
			%>
			data_arr[<%= counter%>][9] = "<%=doctorName%>"
			data_arr[<%= counter%>][10] = "Male Medical Ward" 
				<% 
				String status="";
				if("u".equalsIgnoreCase(dgSampleCollectionHeader.getOrder().getRoutineUrgentStatus())){
					status="Urgent";
				}else{
					status="Routine";
				}
				%>
			data_arr[<%= counter%>][11] = "<%=status%>" 
			<%
			     counter++;
	    	}	
		}
		%>
		<%session.setAttribute("patientDeatilList",patientDeatilList);%>
    formName = "pendingSampleValidation"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	makeTable(start,end);
		
	</script>
