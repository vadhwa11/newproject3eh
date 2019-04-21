<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pendingResultValidationLab.jsp 
	 * Tables Used         : DgSampleCollectionHeader,DgSampleCollectionDetails,MasSample,Patient,MasSubChargecode
	 * Description         : 
	 * @author  Create Date: 21.07.2008    Name: Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream" %>
<%@page import="java.net.URL" %>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>



	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<form name="patientSearch" action="" method="post">

<script
	type="text/javascript" language="javascript">
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
	</script> <%
		Box box = HMSUtil.getBox(request);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		MasHospital masHospital = null;
		int currentLabId = 0;
		int userId =0;
		
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();
		List<String> stringOfIdsList = new ArrayList<String>();
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
		 date = (String) utilMap.get("currentDate");
	 //	Date toDate  = null;
	//	Date fromDate=null;
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
		if(patientMap.get("stringOfIdsList") != null){
			stringOfIdsList = (List<String>)patientMap.get("stringOfIdsList");
			
		}
		if(patientMap.get("stringOfSubDeptIdsList") != null){
			stringOfSubDeptIdsList = (List<String>)patientMap.get("stringOfSubDeptIdsList");
			
		}

		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		/*if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}*/
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
		
		List<DgResultEntryHeader> ResultValidationList = new ArrayList<DgResultEntryHeader>();
		if(detailsMap.get("ResultValidationList") != null){
			ResultValidationList = (List<DgResultEntryHeader>)detailsMap.get("ResultValidationList");
			}
		int deptId=0;
		
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		String deptType="";
		if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
		}
		
		 String fromDate="",toDate="";
		 if(map.get("fromDate") !=null){
			 fromDate=(String)map.get("fromDate");
			}
			if(map.get("toDate") !=null){
				toDate = (String)map.get("toDate");
			}
			
			 String hinNo="";
			 if(map.get("hinNo") !=null){
				 hinNo=(String)map.get("hinNo");
				} 
				
				 String pFirstName="",barcodetext="",sampleIdSearch="";
				 if(map.get("pFirstName") !=null){
					 pFirstName=(String)map.get("pFirstName");
					}
				
					if(map.get("barcodetext") !=null){
						barcodetext=(String)map.get("barcodetext");
					}
					if(map.get("sampleIdSearch") !=null){
						sampleIdSearch=(String)map.get("sampleIdSearch");
					}
					
					// added by amit das on 17-07-2017
					if(detailsMap.get("masHospital") != null){
						masHospital =(MasHospital)detailsMap.get("masHospital");
					}
					
					currentLabId = (Integer)detailsMap.get("currentLabId"); // added by amit das on 17-07-2017
					
					if (detailsMap.get("userId") != null) {
						userId = (Integer) detailsMap.get("userId");
					}
					int subGroupId=0;
					if (map.get("subGroupId") != null) {
					subGroupId = (Integer) map.get("subGroupId");
					}
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	</script> <%if(deptType.equalsIgnoreCase("Diag")){ %>
<div class="titleBg">
<h2>Pending For Result Validation</h2>
</div>
<%}else{ %>
<div class="titleBg">
<h2>Pending For Report Validation</h2>
</div>
<%} %>

<div class="clear"></div>
<h4>Patient Search</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>  

<label><span>*</span> From Date</label> <input type="text" class="date"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=!fromDate.equals("")?fromDate:currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label><span>*</span> To Date</label> <input type="text" id="ToDateId"

	name="<%=TO_DATE %>" value="<%=!toDate.equals("")?toDate:currentDate %>" class="date"
	readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text" name="<%=HIN_NO %>" value="<%=!hinNo.equals("")?hinNo:"" %>"
	MAXLENGTH="50" onkeypress="return searchKeyPress(event);"/> 
<div class="clear"></div>
<label>P Type</label> <select name="<%=PATIENT_TYPE%>"
	validate="P Type,string,no">
	<option value="">Select One</option>
	<option value="IP">IP</option>
	<option value="OP">OP</option>
</select>
	<label>Modality</label> 
<!-- added by amit das on 17-07-2017 -->
<% if(masHospital!=null &&  masHospital.getMultiLab()!=null && masHospital.getMultiLab().equalsIgnoreCase("y")) {%>
<select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>" onchange="bookLabForDoctor('resultValidation');">
			<option value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<% if(currentLabId==subChargecode.getId()){%>
			<option selected="selected" value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<% }else{%>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>
			<%}%>
</select>
<% } else { %>
<select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>">
			<option value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<% if(subGroupId==subChargecode.getId()){%>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<% }else{%>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>
			<%}%>

<% } %>		
</select>
<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <input type="text"
	name="<%=AD_NO %>" value="" MAXLENGTH="30" onkeypress="return searchKeyPress(event);"/>
	
        <div class="clear"></div>
	<label>Ward</label> <input type="text"
	name="<%=WARD_NAME%>" value="" MAXLENGTH="30" onkeypress="return searchKeyPress(event);"/>
<%-- <label>Sub Department</label> <select id="subChargeCodeId"
	name="<%=SUB_CHARGECODE_ID %>">
	<option value="0">Select</option>
	<%
		for(MasSubChargecode subChargecode : subChargeCodeList){
		%>
	<option value="<%=subChargecode.getId() %>"
		<%=HMSUtil.isSelected(subChargecode.getId(),Integer.valueOf(box.getInt(SUB_CHARGECODE_ID)))%>><%=subChargecode.getSubChargecodeName() %></option>
	<%}%>
</select>  <label>Order By</label> <select id="departmentId"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
		for(MasDepartment masDepartment : departmentList){
		%>
	<option value="<%=masDepartment.getId() %>"
		<%=HMSUtil.isSelected(masDepartment.getId(),Integer.valueOf(box.getInt(DEPARTMENT_ID)))%>><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select> --%>
<label>Patient Name</label> <input type="text" name="<%=P_FIRST_NAME %>"
	value="<%=!pFirstName.equals("")?pFirstName:"" %>" MAXLENGTH="30" onkeypress="return searchKeyPress(event);"/><label>Mobile No</label> <input type="text"
	name="<%=MOBILE_NO%>" value="" MAXLENGTH="30" onkeypress="return searchKeyPress(event);"/>
	 <div class="clear"></div>
	<label>BarCode Scan</label> <input type="text" name="barcodetext" value="<%=!barcodetext.equals("")?barcodetext:"" %>" MAXLENGTH="25" onkeypress="return searchKeyPress(event);"/>
	<label>Sample ID</label> <input type="text" name="sampleId" value="<%=!sampleIdSearch.equals("")?sampleIdSearch:"" %>" MAXLENGTH="25" onkeypress="return searchKeyPress(event);"/>
	<div class="clear"></div>
	 <input
	type="button" name="search" id="addbutton" onclick="getResultValidationPendingList();"
	value="Search" class="button" accesskey="a" />
	<!-- onclick="submitForm('patientSearch','/hms/hms/investigation?method=searchPatientForResultValidationLab','checkFromNTodata');" -->
	
<div class="clear"></div>
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<input type="hidden" id="userId" value="<%=userId%>"/>
</form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<div class="clear"></div>
<form name="pendingResultValidationLab" method="post" action="">
<div id="deletebutton"></div>
<input type="hidden" name="edited" id="edited" value="" />
<div class="paddingTop15"></div>
<input type="hidden" name="Delete" value=""> <script
	type="text/javascript">
	formFields = [
	[0, "<%=RESULT_ID%>", "id"],[1,"<%=SAMPLE_NO%>"],[2,"smpcDate"],[3,"sampleId"],[4,"time"], [5,"serNo"], [6,"patName"], [7,"sPerName"],
	[8,"hin"], [9,"IpNo"],[10,"age"], [11,"sex"],[12,"pType"],[13,"orderBy"],[14,"doct"],
	[15,"<%=RESULT_ID%>"],[16,"<%=DIAGNOSIS_NO%>"],[17,"<%=SUB_CHARGE%>"],[18,"ward"],[19,"priority"]];
	 statusTd = 15;
	</script>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
</div>

<div class="clear"></div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Sample No"
	data_header[0][1] = "hide";
	data_header[0][2] = "7%";
	data_header[0][3] = "<%=SAMPLE_NO%>";
	
	data_header[1] = new Array;
	data_header[1][0] = "Date"
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "smpcDate";
	
	data_header[2] = new Array;
	data_header[2][0] = "Sample Id"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";
	data_header[2][3] = "sampleId";
	
    data_header[3] = new Array;
	data_header[3][0] = "Result Time"
	data_header[3][1] = "hide";
	data_header[3][2] = "15%";
	data_header[3][3] = "time";
	
	data_header[4] = new Array;
	data_header[4][0] = "Service no"
	data_header[4][1] = "hide";
	data_header[4][2] = "15%";
	data_header[4][3] = "serNo";
	
	data_header[5] = new Array;
	data_header[5][0] = "Patient Name"
	data_header[5][1] = "data";
	data_header[5][2] = "10%";
	data_header[5][3] = "patName";
	
	data_header[6] = new Array;
	data_header[6][0] = "S Person Name"
	data_header[6][1] = "hide";
	data_header[6][2] = "10%";
	data_header[6][3] = "sPerName";
	
	data_header[7] = new Array;
	data_header[7][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[7][1] = "data";
	data_header[7][2] = "20%";
	data_header[7][3] = "hin";
	
	data_header[8] = new Array;
	data_header[8][0] = "IP No"
	data_header[8][1] = "hide";
	data_header[8][2] = "10%";
	data_header[8][3] = "IpNo"; 
		
	data_header[9] = new Array;
	data_header[9][0] = "Age"
	data_header[9][1] = "data";
	data_header[9][2] = "10%";
	data_header[9][3] = "age";
	
	data_header[10] = new Array;
	data_header[10][0] = "Sex"
	data_header[10][1] = "hide";
	data_header[10][2] = "10%";
	data_header[10][3] = "sex";
	
	data_header[11] = new Array;
	data_header[11][0] = "P Type"
	data_header[11][1] = "hide";
	data_header[11][2] = "10%";
	data_header[11][3] = "pType";
	
	data_header[12] = new Array;
	data_header[12][0] = "Order By"
	data_header[12][1] = "hide";
	data_header[12][2] = "14%";
	data_header[12][3] = "orderBy";
	
	data_header[13] = new Array;
	data_header[13][0] = "Doctor"
	data_header[13][1] = "data";
	data_header[13][2] = "10%";
	data_header[13][3] = "doct";
	
	data_header[14] = new Array;
	data_header[14][0] = "Id"
	data_header[14][1] = "hide";
	data_header[14][2] = "10%";
	data_header[14][3] = "<%=RESULT_ID%>";
	
	data_header[15] = new Array;
	data_header[15][0] = "Diag/No."
	data_header[15][1] = "hide";
	data_header[15][2] = "10%";
	data_header[15][3] = "<%=DIAGNOSIS_NO%>";
	
	data_header[16] = new Array;
	data_header[16][0] = "Sub Department"
	data_header[16][1] = "hide";
	data_header[16][2] = "10%";
	data_header[16][3] = "<%=SUB_CHARGE%>";
	
	data_header[17] = new Array;
	data_header[17][0] = "Ward"
	data_header[17][1] = "hide";
	data_header[17][2] = "10%";
	data_header[17][3] = "ward";
	
	data_header[18] = new Array;
	data_header[18][0] = "Priority"
	data_header[18][1] = "data";
	data_header[18][2] = "10%";
	data_header[18][3] = "priority"; 

	
	data_arr = new Array();
	</script>
<div class="clear"></div>
<% // int  counter=0;%>

<%-- <%
		int  counter=0;
		List<String> pendingValidationListLabAll = new ArrayList<String>();

		String stringOfSubDeptIds = "";
		String stringOfIds = "";

			if (patientList.size() > 0){ 
			  for(int i = 0; i<patientList.size(); i++){
				  DgResultEntryHeader dgResultEntryHeader =patientList.get(i);
				 System.out.println(dgResultEntryHeader.getHin().getHinNo());  
				  if(RequestConstants.UHID_FOR_QUALITY_TESTING.equals(dgResultEntryHeader.getHin().getHinNo())){
					  continue;
				  }
					stringOfIds = stringOfIdsList.get(i);
					stringOfSubDeptIds = stringOfSubDeptIdsList.get(i);
					pendingValidationListLabAll.add(stringOfIds+"@"+stringOfSubDeptIds);
			  %>
<jsp:include page="pendingResultValidationLabGrid.jsp" flush="true">
	<jsp:param name="counter" value="<%=counter%>" />
	<jsp:param name="resultEntryIndex" value="<%=(i)%>" />
</jsp:include>
<%	counter++;	}
			}
				%>
<%

	if(session.getAttribute("pendingValidationListLabAll") != null){
		session.removeAttribute("pendingValidationListLabAll");
		session.setAttribute("pendingValidationListLabAll",pendingValidationListLabAll);
	}else{
		session.setAttribute("pendingValidationListLabAll",pendingValidationListLabAll);
	}
	%>
 --%>

<script type="text/javascript" language="javascript">

var data_arr = '';

	/* formName = "pendingResultValidationLab";
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end); */
	
	function searchKeyPress(e) {
		// look for window.event in case event isn't passed in
		e = e || window.event;
		if (e.keyCode == 13) {
			document.getElementById('addbutton').click();
			return false;
		}
		return true;
	}

	function getResultValidationPendingList(){
		var url = '/hms/hms/investigation?method=getPendingResultValidationList';
		var jsonData = '';
		url = url+'&'+getNameAndData('patientSearch');
	   	url = url+'&'+csrfTokenName+'='+csrfTokenValue; 
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	jsonData = this.responseText;
		    	if(!jsonData.trim()==''){
		    		var data = JSON.parse(jsonData);
		    		data_arr =	MultiDimensionalArray(data.length, 2);
		    		parseJsonToArray(data);
		    	}else{
		    		if(document.getElementById('searchtable')){
		    			document.getElementById('searchtable').innerHTML  = '';
		    		}
		    	}
		    }
		  };
		xhttp.open("POST", url, true);
		xhttp.send();
	}



	/* added by amit das on 17-07-2017 */ 
	<% if(masHospital!=null &&  masHospital.getMultiLab()!=null && masHospital.getMultiLab().equalsIgnoreCase("y")) {%>
	var e1 = document.getElementById("subChargeCodeId");
	var subChargeCodeId = e1.options[e1.selectedIndex].value;
	if(subChargeCodeId=='0')
		alert("Please choose modality !");
	else
		getResultValidationPendingList();
	  
	<%} else {%>
	getResultValidationPendingList();
	<% } %>




	function MultiDimensionalArray(iRows, iCols) {
	    var i;
	    var j;
	    var table = new Array(iRows);

	    for (i = 0; i < iRows; i++) {

	        table[i] = new Array(iCols);

	        for (j = 0; j < iCols; j++) {
	            table[i][j] = "";
	        }
	    }
	    return (table);
	} 

	function parseJsonToArray(data){
		
		for (var i = 0; i < data.length; i++) {
		    var obj = data[i];
		    var counter = 0;
		    for (var key in obj) {
		    	data_arr[i][counter] = obj[key];
		    	counter++;
		    }  
		}
		
		formName = "pendingResultValidationLab";
		
	    start = 0;
	    if(data_arr.length < rowsPerPage){
	    	end = data_arr.length;
	    }
	    else{
	    	end = rowsPerPage;
	    }
	    makeTable(start,end);
	    document.getElementById('searchtable').style = 'width:100%';
	}


	
	
</script>


