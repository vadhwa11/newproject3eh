<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<form name="patientSearch" action="" method="post">
	<script type="text/javascript" language="javascript">

checked=false;
function checkedAll () {
	if (document.getElementById('main').checked == true) { 	 
		for (var i =0; i < parseInt(document.getElementById('count').value); i++) 
		{
	   		document.getElementById('parent'+i).checked = true;
		}
      }
     if (document.getElementById('main').checked != true) { 	 
		for (var i =0; i < parseInt(document.getElementById('count').value); i++) 
		{
	   		document.getElementById('parent'+i).checked = false;
		}
      } 
  }     
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
	serverdate = '<%=date+"/"+month+"/"+year%>';
	</script>
	<%
		Box box = HMSUtil.getBox(request);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		MasHospital masHospital = null;
		int currentLabId = 0;
		int userId =0;
		//List<DgOrderhd> patientList = new ArrayList<DgOrderhd>();
		
		List<DgResultEntryHeader> patientListResult = new ArrayList<DgResultEntryHeader>();
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
		 date = (String) utilMap.get("currentDate");
	 	//Date toDate  = null;
		//Date fromDate=null;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("patientListResult") != null){
			patientListResult= (List<DgResultEntryHeader>)patientMap.get("patientListResult");
			
		}
		int fromAge = 0;
		int toAge = 0;
		if(map.get("toAge") != null && !request.getParameter("toAge").equals("") )
		{
			toAge = Integer.valueOf((String)map.get("toAge") );
			
		}
		if(map.get("fromAge") != null && !request.getParameter("fromAge").equals("") )
		{
			fromAge = Integer.valueOf((String)map.get("fromAge"));
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
	/*	if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}*/
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
				
				 String pFirstName="",barcodetext="";
				 if(map.get("pFirstName") !=null){
					 pFirstName=(String)map.get("pFirstName");
					}
				
					if(map.get("barcodetext") !=null){
						barcodetext=(String)map.get("barcodetext");
					}
					
				
		String mobilNo="";
		if(map.get("mobilNo") !=null){
			mobilNo=(String)map.get("mobilNo");
		} 	
		
		String adNo="";
		if(map.get(RequestConstants.AD_NO) !=null){
			adNo=(String)map.get(RequestConstants.AD_NO);
		} 
		
		String wardName="";
		if(map.get(RequestConstants.WARD_NAME) !=null){
			wardName=(String)map.get(RequestConstants.WARD_NAME);
		} 
		
		String patientType="";
		if(map.get(RequestConstants.PATIENT_TYPE) !=null){
			patientType=(String)map.get(RequestConstants.PATIENT_TYPE);
		} 
		String modality="";
		if(map.get(RequestConstants.SUB_CHARGECODE_ID) !=null){
			modality=(String)map.get(RequestConstants.SUB_CHARGECODE_ID);
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

		List<DgResultEntryHeader> ResultValidationList = new ArrayList<DgResultEntryHeader>();
		if(detailsMap.get("ResultValidationList") != null){
			ResultValidationList = (List<DgResultEntryHeader>)detailsMap.get("ResultValidationList");
			}
		int deptId=0;
		
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
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
	%>
	<%
		if(!message.equals("")){
			%>
	var msg = "<%=message%>"; alert(msg);
	<%}
	%>
	<%
int loginDeptId = 0;
if(session.getAttribute("deptId") != null){
	loginDeptId = (Integer)session.getAttribute("deptId");
}

//
%>
	<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 19 July 2010
 -->
	<%
		URL myURL = application
				.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);
		//out.println("name-jsp-" +p.getProperty("age") );
		String serverPath=application.getResource("/WEB-INF/").getPath();
	%>

	<div class="titleBg">
		<h2>Result Printing</h2>
	</div>
	<div class="clear"></div>
	<h4>Patient Search</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>

		<label><span>*</span>From Date</label> <input type="text" class="date"
			id="fromDateId" name="<%=FROM_DATE %>" value="<%=!fromDate.equals("")?fromDate:currentDate %>"
			readonly="readonly" MAXLENGTH="30" validate="fromDate,date,yes"/> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

		<label><span>*</span>To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=!toDate.equals("")?toDate:currentDate %>" class="date"
			readonly="readonly" validate="toDate,date,yes" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input
			id="hinId" type="text" name="<%=HIN_NO %>" value="<%=!hinNo.equals("")?hinNo:"" %>" maxlength="50" validate="hinNo,metachar,no" onkeypress="return searchKeyPress(event);"/>

		<div class="clear"></div>
		<label>P Type</label> <select name="<%=PATIENT_TYPE%>"
			validate="patientType,metachar,no"
			onChange=" submitProtoAjax('resultPrinting', '/hms/hms/investigation?method=showPaitentTestDetailInResultPrinting&orderNo=5')">
			<option value="">Select One</option>
			<option value="IP" <%=patientType!=null&& patientType.equalsIgnoreCase("IP")?"selected":"" %>>IP</option>
			<option value="OP" <%=patientType!=null&& patientType.equalsIgnoreCase("OP")?"selected":"" %>>OP</option>
		</select> 
				<label>Modality</label> 
<!-- added by amit das on 17-07-2017 -->
<% if(masHospital!=null &&  masHospital.getMultiLab()!=null && masHospital.getMultiLab().equalsIgnoreCase("y")) {%>
a<select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>" onchange="bookLabForDoctor('resultPrinting');">
			<option value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<% if(currentLabId==subChargecode.getId()){%>
			<option selected="selected" value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<% }else{%>
			<option value="<%=subChargecode.getId() %>" <%=!StringUtils.isBlank(modality) && Integer.parseInt(modality)==subChargecode.getId()?"selected":"" %>><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>
			<%}%>
</select>
<% } else { %>
<select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>">
			<option value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<% if(subGroupId==subChargecode.getId()){%>
			<option value="<%=subChargecode.getId() %>" <%=!StringUtils.isBlank(modality)&&  Integer.parseInt(modality)==subChargecode.getId()?"selected":"" %>><%=subChargecode.getSubChargecodeName() %></option>
			<% }else{%>
			<option value="<%=subChargecode.getId() %>" <%=!StringUtils.isBlank(modality)&&  Integer.parseInt(modality)==subChargecode.getId()?"selected":"" %>><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>
			<%}%>

<% } %>		
</select>
		<label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label> <input
			id="adId" type="text" name="<%=AD_NO %>" value="<%=adNo!=null?adNo:""%>" maxlength="30" validate="adNo,metachar,no"/>
			
		<div class="clear"></div>
		<label>Ward</label> <input type="text" name="<%=WARD_NAME%>" value="<%=wardName!=null?wardName:""%>"
			maxlength="30" validate="Ward,metachar,no"/>
		<%-- <label>Order No.</label> <input type="text" name="<%=ORDER_NO %>"
	value="" MAXLENGTH="30" /> <label>Sub Department</label> <select
	id="subChargeCodeId" name="<%=SUB_CHARGECODE_ID %>">
	<option value="0">Select</option>
	<%
			for(MasSubChargecode subChargecode : subChargeCodeList){
			%>
	<option value="<%=subChargecode.getId() %>"
		<%=HMSUtil.isSelected(subChargecode.getId(),Integer.valueOf(box.getInt(SUB_CHARGECODE_ID)))%>><%=subChargecode.getSubChargecodeName() %></option>
	<%}%>
</select> --%>
		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="<%=!pFirstName.equals("")?pFirstName:"" %>" maxlength="30" validate="pFirstName,metachar,no" onkeypress="return searchKeyPress(event);"/> <label>Mobile
			No</label> <input type="text" name="<%=MOBILE_NO%>" value="<%=mobilNo%>" maxlength="10" onkeypress="return isNumber(event);"/>
		<div class="clear"></div>
		 <label>Age From</label><select name="fromAge" validate="Age,int,no" id="fromAge"
			tabindex="2">
			<option value="">select</option>
			<%for (int i=0;i<150;i++){ if(fromAge==i && fromAge>0){%>

			<option value="<%=i%>" selected="selected"><%=i%></option>
			<%}else{%>
			<option value="<%=i%>"><%=i%></option>
				<%}}%>
			
		</select> <label>To</label> <select name="toAge" tabindex="2" validate="To Age,int,no" id="toAge">
			<option value="">select</option>
			<%for (int i=1;i<150;i++){if(toAge==i){%>
<option value="<%=i%>" selected="selected"><%=i%></option>
			<%}else{%>
			<option value="<%=i%>"><%=i%></option>
			<%}}%>
		</select>
		<label>Requisition By</label> <select id="departmentId"
			name="<%=DEPARTMENT_ID %>" validate="Requisition By,metachar,no">
			<option value="0">Select</option>
			<%
			for(MasDepartment masDepartment : departmentList){
			%>
			<option value="<%=masDepartment.getId() %>"
				<%=HMSUtil.isSelected(masDepartment.getId(),Integer.valueOf(box.getInt(DEPARTMENT_ID)))%>><%=masDepartment.getDepartmentName() %></option>
			<%}%>
		</select>

		<div class="clear"></div>
		<label>BarCode Scan</label> <input type="text" name="barcodetext" value="<%=!barcodetext.equals("")?barcodetext:"" %>" MAXLENGTH="25" onkeypress="return searchKeyPress(event);"/>
	</div>
	<div class="clear"></div>
	<input type="button"
		onclick="submitForm('patientSearch','/hms/hms/investigation?method=showResultOrderNoJsp','checkFromNTodata');"
		value="Search" class="button" accesskey="a" id="btnSearchLab"/>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" id="userId" value="<%=userId%>"/>
</form>
<%if(patientListResult.size()>0){ %>
<div class="clear"></div>

<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>

<div id="searchresults" tabindex="2">
	<div id="searchtable" tabindex="2"></div>

	<form name="resultPrinting" method="post" action="" target="_blank">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
		<script type="text/javascript">
	formFields = [
	[0, "<%=RESULT_ID%>", "id"],[1,"orderNo"],[2,"smpcDate"],[3,"time"], [4,"hin"],[5,"patName"],[6,"patName"], [7,"age"], [8,"sex"], [9,"pType"], [10,"orderBy"],[11,"doct"],[12,"<%=RESULT_TYPE%>"],[13,"<%=DIAGNOSIS_NO%>"]];
	 statusTd = 12;
	</script>
		<input type="hidden" name="<%=RESULT_TYPE %>" id="resultTypeId"			value="" />
		<script type="text/javascript">
		 	function setResultType(rstype){
	
	document.getElementById('resultTypeId').value = rstype;
	}
		</script>
		<div class="clear"></div>
		<div id="testDiv"></div>
		<span id="printSpan" style="display: none;">
		<input type="button" name="print" id="print" onclick="submitResultPrintAfterValidation();" target="_blank"		value="VIEW" class="button" accesskey="a" />
		<input type="button" name="PrintReport" id="printOut" onclick="submitResultPrintAfterValidationForReport();" target="_blank" value="PRINT" class="button" accesskey="a" /> 
		</span>
		<input	type="hidden" name="Delete" id="deletebutton" value="Activate"	class="button" style="display: none;"onClick="submitForm('title','generalMaster?method=deleteTitle&flag='+this.value)"
			accesskey="d" tabindex=1 />

	</form>
	<%} %>
</div>

<div class="clear"></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "<input type='hidden' name = 'checkall' id = 'main' value = 'just' onclick='checkedAll(this);'>";
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "orderNo";
	
	data_header[1] = new Array;
	data_header[1][0] = "Result Date"
	data_header[1][1] = "hide";
	data_header[1][2] = "7%";
	data_header[1][3] = "smpcDate";
	
    data_header[2] = new Array;
	data_header[2][0] = "Result Time"
	data_header[2][1] = "hide";
	data_header[2][2] = "15%";
	data_header[2][3] = "time";
	
	data_header[3] = new Array;
	data_header[3][0] = "<%=prop.getProperty("com.jkt.hms.registration_no")%>"
	data_header[3][1] = "data";
	data_header[3][2] = "15%";
	data_header[3][3] = "hin";
	
	data_header[4] = new Array;
	data_header[4][0] = "Patient Name"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "patName";
	
	data_header[5] = new Array;
	data_header[5][0] = "IP No"
	data_header[5][1] = "hide";
	data_header[5][2] = "20%";
	data_header[5][3] = "IpNo";
	
	data_header[6] = new Array;
	data_header[6][0] = "Age"
	data_header[6][1] = "data";
	data_header[6][2] = "20%";
	data_header[6][3] = "age";
	
	data_header[7] = new Array;
	data_header[7][0] = "Sex"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "sex";
	
	data_header[8] = new Array;
	data_header[8][0] = "Patient Type"
	data_header[8][1] = "hide";
	data_header[8][2] = "10%";
	data_header[8][3] = "pType";
		
	data_header[9] = new Array;
	data_header[9][0] = "Requisition By"
	data_header[9][1] = "hide";
	data_header[9][2] = "10%";
	data_header[9][3] = "orderBy";
	
	data_header[10] = new Array;
	data_header[10][0] = "Doctor"
	data_header[10][1] = "data";
	data_header[10][2] = "10%";
	data_header[10][3] = "doct";
	
	data_header[11] = new Array;
	data_header[11][0] = "resultType"
	data_header[11][1] = "hide";
	data_header[11][2] = "10%";
	data_header[11][3] = "<%=RESULT_TYPE%>";
	
	data_header[12] = new Array;
	data_header[12][0] = "Ward"
	data_header[12][1] = "hide";
	data_header[12][2] = "10%";
	data_header[12][3] = "orderNo";
	
	data_arr = '';

   /*  formName = "resultPrinting"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
    makeTable(start,end); */
   // intializeHover('searchresulttable', 'TR', ' tableover');  
   
   
   function validateRadioForOrderNo(){
			
		for(var i = 0; i < document.getElementsByName('parent').length; i++){
			if(document.getElementsByName('parent')[i].checked == true){
				return true;
			}		
  		}
  		alert("Please select one row");
		return false;
	}
   function submitResultPrintAfterValidationForReport1(){
	   var flag = validateRadioForOrderNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
		//	var printId = document.getElementById('print');
		//	printId.setAttribute("type","submit");
			for(var i = 0; i < document.getElementsByName('parent').length; i++){
				if(document.getElementsByName('parent')[i].checked == true){
					orderNo=document.getElementsByName('parent')[i].value;
					break;
				}		
 			}
 		//	var printId = document.getElementById('validationReportLink');
 		//	printId.setAttribute("target","_blank");
			//document.location.href = '/hms/hms/investigation?method=printResultValidation&parent='+orderNo;
			
			<% 
			
			if(loginDeptId == 46 ){ %>
					submitForm('resultPrinting','/hms/hms/investigation?method=printResultValidation222&parent='+orderNo);
			<% }else{ %>
					submitForm('resultPrinting','/hms/hms/investigation?method=printResultValidationLab333&parent='+orderNo);
			<% } %>
		}

	   }
   	function submitResultPrintAfterValidation(){
		var flag = validateRadioForOrderNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
		//	var printId = document.getElementById('print');
		//	printId.setAttribute("type","submit");
			for(var i = 0; i < document.getElementsByName('parent').length; i++){
				if(document.getElementsByName('parent')[i].checked == true){
					orderNo=document.getElementsByName('parent')[i].value;
					break;
				}		
  			}
  		//	var printId = document.getElementById('validationReportLink');
  		//	printId.setAttribute("target","_blank");
 			//document.location.href = '/hms/hms/investigation?method=printResultValidation&parent='+orderNo;
 			
 			<% if(loginDeptId == 46 ){ %>
 					submitForm('resultPrinting','/hms/hms/investigation?method=printResultValidation&parent='+orderNo);
 			<% }else{ %>
					submitForm('resultPrinting','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo);
			<% } %>
		}
		
	}
	
	function submitResultPrintAfterValidationForReport(){
		var flag = validateRadioForOrderNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
		//	var printId = document.getElementById('print');
		//	printId.setAttribute("type","submit");
			for(var i = 0; i < document.getElementsByName('parent').length; i++){
				if(document.getElementsByName('parent')[i].checked == true){
					orderNo=document.getElementsByName('parent')[i].value;
					break;
				}		
  			}
  		//	var printId = document.getElementById('validationReportLink');
  		//	printId.setAttribute("target","_blank");
 			//document.location.href = '/hms/hms/investigation?method=printResultValidation&parent='+orderNo;
 			
 			<% 
 			
 			
 			if(loginDeptId == 46 ){ %>
 			
 					submitForm('resultPrinting','/hms/hms/investigation?method=printResultValidationReport&parent='+orderNo);
 			<% }else{ %>
					submitForm('resultPrinting','/hms/hms/investigation?method=printResultValidationReport&parent='+orderNo);
			<% } %>
		}
		
	}
	 
	
	/* function showResultPrintingDetailByAJAX(value){
		alert(value.value); 
		$.ajax({
            url : '/hms/hms/investigation?method=showPaitentTestDetailInResultPrinting&orderNo='+value.value+'',
            success : function(data) {
            	alert(data);
                $('#result').html(data);
            }
        }); 
		
	} */
<%--  "<input type='radio' name='parent' value="+"<%=dgResultHeader.getOrderNo()%>"+" id=parent"+<%=counter%>+" onClick=\"submitProtoAjax('resultPrinting', '/hms/hms/investigation?method=showPaitentTestDetailInResultPrinting&orderNo="+"<%=dgResultHeader.getOrderNo()%>"+"');\" />"
 --%>
	</script>
<%-- <input type="hidden" name="count" id="count" value="<%=counter%>" validate="count,int,no"/> --%>

<script>
	function searchKeyPress(e) {
		// look for window.event in case event isn't passed in
		e = e || window.event;
		if (e.keyCode == 13) {
			document.getElementById('btnSearchLab').click();
			return false;
		}
		return true;
	}	
	
	function getResultPrintingList(){
		var url = '/hms/hms/investigation?method=getResultPrintingList';
		var jsonData = '';
		url = url+'&'+getNameAndData('patientSearch');
	   	url = url+'&'+csrfTokenName+'='+csrfTokenValue; 
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	jsonData = this.responseText;
		    	if(!jsonData.trim()==''){
		    		document.getElementById('printSpan').style.display="block";
		    		var data = JSON.parse(jsonData);
		    		data_arr =	MultiDimensionalArray(data.length, 2);
		    		parseJsonToArray(data);
		    	}else{
		    		
		    		if(document.getElementById('searchtable')){
		    			document.getElementById('searchtable').innerHTML  = 'No record found.';
		    			document.getElementById('printSpan').style.display="none";
		    			
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
	
	<%} else {%>
	getResultPrintingList();
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
		
		formName = "resultPrinting";
		
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
	function isNumber(evt) {
		var iKeyCode = (evt.which) ? evt.which : evt.keyCode
		if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
			return false;

		return true;
	}

</script>
