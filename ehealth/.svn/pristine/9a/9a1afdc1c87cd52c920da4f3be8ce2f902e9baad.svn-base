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
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.PharmacyLabQueue"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
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
		
		List<Object[]> patientDeatilList = new ArrayList<Object[]>();
		List<DgSampleCollectionHeader>  radioQueuelList=new ArrayList<DgSampleCollectionHeader>();
		
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String userName = "";
		String message = "";
		String deptType = "";
		MasHospital masHospital = null;
		int currentLabId = 0;
		int userId = 0;
		
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		
				// added by amit das on 17-07-2017
				if(detailsMap.get("masHospital") != null){
					masHospital =(MasHospital)detailsMap.get("masHospital");
				}
				
				currentLabId = (Integer)detailsMap.get("currentLabId"); // added by amit das on 17-07-2017
				
				if (detailsMap.get("userId") != null) {
					userId = (Integer) detailsMap.get("userId");
				}
				
		
		if(patientMap.get("patientDeatilList") != null){
			patientDeatilList= (List<Object[]>)patientMap.get("patientDeatilList");
		}
		
		if(patientMap.get("radioQueuelList") != null){
			radioQueuelList= (List<DgSampleCollectionHeader>)patientMap.get("radioQueuelList");
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
		List<MasSample> sampleList = new ArrayList<MasSample>();
		if (detailsMap.get("sampleList") != null) {
			sampleList = (List<MasSample>) detailsMap.get("sampleList");
		}
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		if (detailsMap.get("investigationList") != null) {
			investigationList = (List<DgMasInvestigation>) detailsMap.get("investigationList");
		} 
		if(detailsMap.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
		}
		
		int subGroupId=0;
		if (map.get("subGroupId") != null) {
			subGroupId = (Integer) map.get("subGroupId");
		}
		 String pFirstName="",barcodetext="";
		 if(map.get("pFirstName") !=null){
			 pFirstName=(String)map.get("pFirstName");
			}
		
			if(map.get("barcodetext") !=null){
				barcodetext=(String)map.get("barcodetext");
			}
		
	%>
	
	<script type="text/javascript">
	<%
		if(null !=message && !message.equals("")){
			%>
			var msg = "<%=message%>";
			
		<%}
	%>
	
	</script>
	<div class="clear"></div>
	<% if(null !=deptType && deptType.equalsIgnoreCase("DIAG")){ %>
	<div class="titleBg">
		<h2>Pending for Sample Validation</h2>
	</div>
	<%}else if(null !=deptType && deptType.equalsIgnoreCase("RADIO")){ %>
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
			validate="Pick a date,date,no"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />
		<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
			readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date,date,no"
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
			id="hinId" type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" onkeypress="return searchKeyPress(event);"/>
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
			name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" onkeypress="return searchKeyPress(event);"/> <label>Mobile
			No</label> <input type="text" name="<%=MOBILE_NO%>" value="" MAXLENGTH="15" />
		<input type="hidden" name="<%=BARCODE%>" value="" MAXLENGTH="15"
			id="barcode" />
			<label>Sample</label>
		<select name="sampleName" id="sampleId">
		<option value="0">Select</option>
		<%for(MasSample sample:sampleList){ %>
		<option value="<%=sample.getId()%>"><%=sample.getSampleDescription() %></option>
		<%} %>
		</select> 
		<div class="clear"></div>
		
		<div style="width:364px;float:left;">
		<label>Investigation</label>
		<select name="invName" class="multiple" id="invId" multiple="multiple" size="8">
		<option value="0">Select</option>
		<%for(DgMasInvestigation inv:investigationList){ %>
		<option value="<%=inv.getId()%>"><%=inv.getInvestigationName() %></option>
		<%} %>
		</select>
		</div>
		
		<div style="width:745px;float:left;">
		<label>Modality</label> 
			
			<!-- added by amit das on 17-07-2017 -->
<% if(masHospital!=null &&  masHospital.getMultiLab()!=null && masHospital.getMultiLab().equalsIgnoreCase("y")) {%>
<select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>" onchange="bookLabForDoctor('sampleValidation');">
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
			<option selected="selected" value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<% if(subGroupId==subChargecode.getId()){%>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<% }else{%>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>
			<%}%>
</select>
<% } %>			
		
		<label>Priority</label> <select id="priorityId"
			name="priorityId">
			<option value="0">Select</option> 
			<option value="r">Routine</option>
			<option value="u">Urgent</option> 
		</select>
		<div class="clear"></div>
		<label>BarCode Scan</label> <input type="text" name="barcodetext" value="<%=!barcodetext.equals("")?barcodetext:"" %>" MAXLENGTH="25" onkeypress="return searchKeyPress(event);"/>
		<label>Sample ID</label> <input type="text" name="sampleId"  MAXLENGTH="25" onkeypress="return searchKeyPress(event);"/>
		
		</div> 
		
	</div>
	<div class="clear"></div>
	<input type="button" name="save" id="addbutton" onclick="getSamplePendingList();"
		value="Search" class="button" accesskey="a" />
		<!-- onclick="submitForm('patientSearch','/hms/hms/lab?method=searchPatientForValidation');" -->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" id="userId" value="<%=userId%>"/>
</form>

<div class="clear"></div>

<!-- <div class="Block" id="testDiv" style="height: 100px;">
</div> -->

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
	<form name="pendingSampleValidation" method="post" action="">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
		type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
		type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<script type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1,"diagDate"],[2,"diagTime"], [3,"hin"],[4,"ipNo"], [5,"patName"],[6,"orderBy"],
			[7,"age"],[8,"sex"],[9,"doctorName"],[10,"ward"],[11,"priority"],[12,"sampleId"]];
	 statusTd = 5;
	</script>

</form>
</div>

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
data_header[10][0] = "Token No."
data_header[10][1] = "hide";
data_header[10][2] = "20%";
data_header[10][3] = "priority";

data_header[11] = new Array;
data_header[11][0] = "SampleId"
data_header[11][1] = "data";
data_header[11][2] = "20%";
data_header[11][3] = "sampleId";

</script>

<script>	



var data_arr = '';

	function searchKeyPress(e) {
		// look for window.event in case event isn't passed in
		e = e || window.event;
		if (e.keyCode == 13) {
			document.getElementById('addbutton').click();
			return false;
		}
		return true;
	}
	
	function getSamplePendingList(){
		var url = '/hms/hms/lab?method=getPendingSampleValidationList';
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
		
	
	
	
	
	

	<!-- added by amit das on 17-07-2017 -->
<% if(masHospital!=null &&  masHospital.getMultiLab()!=null && masHospital.getMultiLab().equalsIgnoreCase("y")) {%>
	var e1 = document.getElementById("subChargeCodeId");
	var subChargeCodeId = e1.options[e1.selectedIndex].value;
	if(subChargeCodeId=='0')
		alert("Please choose modality !");
	else
		getSamplePendingList();
	
<%} else {%>
getSamplePendingList();
<% } %>
</script>



<script type="text/javascript">



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

// var data_arr = [[],[],[]];



function parseJsonToArray(data){
	
	for (var i = 0; i < data.length; i++) {
	    var obj = data[i];
	    var counter = 0;
	    for (var key in obj) {
	    	data_arr[i][counter] = obj[key];
	    	counter++;
	    }  
	}
	
	formName = "pendingSampleValidation";
	
    start = 0;
    if(data_arr.length < rowsPerPage){
    	end = data_arr.length;
    }
    else{
    	end = rowsPerPage;
    }
    makeTable(start,end);
}






	    
		

</script>
