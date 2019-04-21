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
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>
	<%
		Box box = HMSUtil.getBox(request);
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<DgOrderhd> patientList = new ArrayList<DgOrderhd>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
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
			patientList= (List<DgOrderhd>)patientMap.get("patientList");
			
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

		List<DgResultEntryHeader> ResultValidationList = new ArrayList<DgResultEntryHeader>();
		if(detailsMap.get("ResultValidationList") != null){
			ResultValidationList = (List<DgResultEntryHeader>)detailsMap.get("ResultValidationList");
			}
		int deptId=0;
		
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
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
<div class="Block">
<h4>Patient Search</h4>		
<label><span>*</span>From Date</label> <input type="text" class="date"
			id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>"
			readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

		<label><span>*</span>To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
			readonly="readonly" validate="To Date,date,yes" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input
			id="hinId" type="text" name="<%=HIN_NO %>" value="" maxlength="50" />

		<div class="clear"></div>
		<label>P Type</label> <select name="<%=PATIENT_TYPE%>"
			validate="P Type,string,no"
			onChange=" submitProtoAjax('resultPrinting', '/hms/hms/investigation?method=showPaitentTestDetailInResultPrinting&orderNo=5')">
			<option value="">Select One</option>
			<option value="IP">IP</option>
			<option value="OP">OP</option>
		</select> <label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label> <input
			id="adId" type="text" name="<%=AD_NO %>" value="" maxlength="30" />
		<label>Ward</label> <input type="text" name="<%=WARD_NAME%>" value=""
			maxlength="30" />
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
		<div class="clear"></div>
		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="" maxlength="30" /> <label>Mobile
			No</label> <input type="text" name="<%=MOBILE_NO%>" value="" maxlength="30" />
		<label>Requisition By</label> <select id="departmentId"
			name="<%=DEPARTMENT_ID %>">
			<option value="0">Select</option>
			<%
			for(MasDepartment masDepartment : departmentList){
			%>
			<option value="<%=masDepartment.getId() %>"
				<%=HMSUtil.isSelected(masDepartment.getId(),Integer.valueOf(box.getInt(DEPARTMENT_ID)))%>><%=masDepartment.getDepartmentName() %></option>
			<%}%>
		</select>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<input type="button"
		onclick="submitForm('patientSearch','/hms/hms/investigation?method=searchPatientForResultValidationOrderNoForQC','checkFromNTodata');"
		value="Search" class="button" accesskey="a" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
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
		<input type="hidden" name="<%=RESULT_TYPE %>" id="resultTypeId"
			value="" />
		<script type="text/javascript">
		 	function setResultType(rstype){
	
	document.getElementById('resultTypeId').value = rstype;
	}
		</script>
		<div class="clear"></div>
		<div id="testDiv"></div>
		<input type="button" name="print" id="print"
			onclick="submitResultPrintAfterValidation();" target="_blank"
			value="HTML" class="button" accesskey="a" /> <input type="button"
			name="PrintReport" id="printOut"
			onclick="submitResultPrintAfterValidationForReport();"
			target="_blank" value="PDF" class="button" accesskey="a" /> <input
			type="hidden" name="Delete" id="deletebutton" value="Activate"
			class="button" style="display: none;"
			onClick="submitForm('title','generalMaster?method=deleteTitle&flag='+this.value)"
			accesskey="d" tabindex=1 />

	</form>
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
	
	data_arr = new Array();
	
	    <% int counter=0;
	   		if (patientList != null && patientList.size() > 0) { 
			for(DgOrderhd dgResultHeader : patientList){
			Patient patient = dgResultHeader.getHin();
			if(!RequestConstants.UHID_FOR_QUALITY_TESTING.equals(patient.getHinNo())){
				continue;
			}
	%>
				
		  		data_arr[<%= counter%>] = new Array();
		  		data_arr[<%= counter%>][0] = "<%=dgResultHeader.getId()%>"
				data_arr[<%= counter%>][1] = "<input type='radio' name='parent' value="+"<%=dgResultHeader.getOrderNo()%>"+" id=parent"+<%=counter%>+" onClick=\"submitProtoAjax('resultPrinting', '/hms/hms/investigation?method=showPaitentTestDetailInResultPrinting&orderNo="+"<%=dgResultHeader.getOrderNo()%>"+"');\" />"
				data_arr[<%= counter%>][2] = "<%=HMSUtil.changeDateToddMMyyyy(dgResultHeader.getOrderDate())%>"
				data_arr[<%= counter%>][3] = "<%=dgResultHeader.getOrderTime()%>"
				<%try{%>
				data_arr[<%= counter%>][4] = "<%=dgResultHeader.getHin().getHinNo()%> "
				<%
					if(dgResultHeader.getHin().getPFirstName() != null  && !(dgResultHeader.getHin().getPFirstName().equals(""))){
					
					String pMiddleName = "";
					String pLastName = "";
					if(patient.getPMiddleName() != null){
						pMiddleName = dgResultHeader.getHin().getPMiddleName();
					}
					if(patient.getPLastName() != null){
						pLastName = dgResultHeader.getHin().getPLastName();
					}
					String pName = dgResultHeader.getHin().getPFirstName()+" "+pMiddleName+" "+pLastName;
				%>
					data_arr[<%= counter%>][5] = "<%=pName%>"
					<%}else{%>
					data_arr[<%= counter%>][5] = ""
				<%}%>
				data_arr[<%= counter%>][6] = "-"
		      <%if(dgResultHeader.getHin() != null){
		    	  if(dgResultHeader.getHin().getAge() != null){
		      %>
					data_arr[<%= counter%>][7] = "<%=dgResultHeader.getHin().getAge()%> "
			  <%}}%>
					
			  <%if(dgResultHeader.getHin() != null){
				  if(dgResultHeader.getHin().getSex() != null){
				    if(dgResultHeader.getHin().getSex().getAdministrativeSexName() != null){ 
			  %>
			  	data_arr[<%= counter%>][8] = "<%=dgResultHeader.getHin().getSex().getAdministrativeSexName()%> "
			  <%}}}%>
			
			
			<%
				 
					if(dgResultHeader.getPatientType() != null){ 			
			%>
					data_arr[<%= counter%>][9] = "<%=dgResultHeader.getPatientType()%> "
			<%}%>
				
				
				
			<%
						if(dgResultHeader.getDepartment().getDepartmentName() != null){	
			%>
			     	    data_arr[<%= counter%>][10] = "<%=dgResultHeader.getDepartment().getDepartmentName()%> "
			<%}%>
			
			
		<%
						String DFName="";
						String DMName="";
						String DLName="";
					   if(dgResultHeader.getPrescribedBy().getFirstName() != null){	
						   DFName=dgResultHeader.getPrescribedBy().getFirstName();
					  	 }
				 		if(dgResultHeader.getPrescribedBy().getMiddleName() != null){	
				 			DMName=dgResultHeader.getPrescribedBy().getMiddleName();
					  	 }
						 if(dgResultHeader.getPrescribedBy().getLastName() != null){	
							 DLName=dgResultHeader.getPrescribedBy().getLastName();
						 } 		   
		%>
		data_arr[<%= counter%>][11] = "<%=DFName+" "+DMName+" "+DLName%> "
		 
					
					
		data_arr[<%= counter%>][12] = '-'
		
		
		<%
		    	if(dgResultHeader.getOrderNo() != null){ 
		     
		%>
				data_arr[<%= counter%>][13] = "OP Clinic"
		<%}else{%>
			   data_arr[<%= counter%>][13] = ""
				<%}%>
  		<%	
				}catch(Exception e){
					e.printStackTrace();
				}
					     counter++;
			    	}
					}
			%>

    formName = "resultPrinting"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
    makeTable(start,end);
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
			
			<% if(loginDeptId == 46 ){ %>
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
 			
 			<% if(loginDeptId == 46 ){ %>
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
	
	</script>
<input type="hidden" name="count" id="count" value="<%=counter%>" />
