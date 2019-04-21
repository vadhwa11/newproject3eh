
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
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL" %>
<%

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );

%>
<form name="patientTestResultPrint" action="" method="post"><script
	type="text/javascript" language="javascript">

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
</script> <script type="text/javascript" language="javascript">
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

		String userName = "";
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}


		int deptId=0;

		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
	%> <%
		if(!message.equals("")){
			%> var msg = "<%=message%>"; alert(msg); <%}
	%> <%
int loginDeptId = 0;
if(session.getAttribute("deptId") != null){
	loginDeptId = (Integer)session.getAttribute("deptId");
}

%>
<div class="titleBg">
<h2>Patient Test Result Print</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input id="hinId" type="text" name="<%=HIN_NO%>"/>
<label>P Type</label>
<select name="<%=PATIENT_TYPE%>" validate="P Type,string,no">
	<option value="">Select One</option>
	<option value="IP">IP</option>
	<option value="OP">OP</option>
</select>

 <label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
	  <input type="text" name="<%=AD_NO %>" value="" MAXLENGTH="30" />
	<div class="clear"></div>

<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button"onclick="submitForm('patientTestResultPrint','/hms/hms/lab?method=searchPatientTestResultPrint');"	value="Search" class="button" accesskey="a" />
<div class="paddingTop15"></div>
<div class="division"></div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="resultPrinting" method="post" action="" target="_blank">
<script type="text/javascript">
	formFields = [
	[0, "<%=RESULT_ID%>", "id"],[1,"orderNo"],[2,"smpcDate"],[3,"time"], [4,"hin"],[5,"patName"], [6,"age"], [7,"sex"], [8,"pType"], [9,"orderBy"],[10,"doct"],[11,"<%=RESULT_TYPE%>"],[12,"<%=DIAGNOSIS_NO%>"]];
	 statusTd = 12;
	</script> <input type="hidden" name="<%=RESULT_TYPE %>" id="resultTypeId"
	value="" /> <script type="text/javascript">
		 	function setResultType(rstype){

	document.getElementById('resultTypeId').value = rstype;
	}
		</script>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button"	name="PrintReport" id="printOut"	onclick="submitResultPrintAfterValidationForReport();" target="_blank"	value="Print" class="button" accesskey="a" />
<div class="paddingTop15"></div>
<div class="division"></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

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
	data_header[3][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[3][1] = "data";
	data_header[3][2] = "15%";
	data_header[3][3] = "hin";

	data_header[4] = new Array;
	data_header[4][0] = "Patient Name"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "patName";

	data_header[5] = new Array;
	data_header[5][0] = "Age"
	data_header[5][1] = "hide";
	data_header[5][2] = "20%";
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
	data_header[9][2] = "10%";
	data_header[9][3] = "doct";

	data_header[10] = new Array;
	data_header[10][0] = "resultType"
	data_header[10][1] = "hide";
	data_header[10][2] = "10%";
	data_header[10][3] = "<%=RESULT_TYPE%>";

	data_header[11] = new Array;
	data_header[11][0] = "Order No"
	data_header[11][1] = "data";
	data_header[11][2] = "10%";
	data_header[11][3] = "orderNo";

	data_arr = new Array();

	    <% int counter=0;
	   		if (patientList != null && patientList.size() > 0) {
			for(DgResultEntryHeader dgResultHeader : patientList){
			Patient patient = dgResultHeader.getHin();
	%>

		  		data_arr[<%= counter%>] = new Array();
		  		data_arr[<%= counter%>][0] = "<%=dgResultHeader.getId()%>"
				data_arr[<%= counter%>][1] = '<input type="radio" name="parent" value="<%=dgResultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%>" id="parent<%=counter%>"  />'
				data_arr[<%= counter%>][2] = "<%=HMSUtil.changeDateToddMMyyyy(dgResultHeader.getResultDate())%>"
				data_arr[<%= counter%>][3] = "<%=dgResultHeader.getResultTime()%>"
				<%try{%>
				data_arr[<%= counter%>][4] = "<%=patient.getHinNo()%> "
				<%
					if(patient.getPFirstName() != null  && !(patient.getPFirstName().equals(""))){

					String pMiddleName = "";
					String pLastName = "";
					if(patient.getPMiddleName() != null){
						pMiddleName = patient.getPMiddleName();
					}
					if(patient.getPLastName() != null){
						pLastName = patient.getPLastName();
					}
					String pName = patient.getPFirstName()+" "+pMiddleName+" "+pLastName;
				%>
					data_arr[<%= counter%>][5] = "<%=pName%>"
					<%}else{%>
					data_arr[<%= counter%>][5] = ""
				<%}%>

		      <%if(dgResultHeader.getHin() != null){
		    	  if(dgResultHeader.getHin().getAge() != null){
		      %>
					data_arr[<%= counter%>][6] = "<%=dgResultHeader.getHin().getAge()%> "
			  <%}}%>

			  <%if(dgResultHeader.getHin() != null){
				  if(dgResultHeader.getHin().getSex() != null){
				    if(dgResultHeader.getHin().getSex().getAdministrativeSexName() != null){
			  %>
			  	data_arr[<%= counter%>][7] = "<%=dgResultHeader.getHin().getSex().getAdministrativeSexName()%> "
			  <%}}}%>


			<%if(dgResultHeader.getSampleCollectionHeader() != null){
				 if(dgResultHeader.getSampleCollectionHeader().getOrder() != null){
					if(dgResultHeader.getSampleCollectionHeader().getOrder().getPatientType() != null){
			%>
					data_arr[<%= counter%>][8] = "<%=dgResultHeader.getSampleCollectionHeader().getOrder().getPatientType()%> "
			<%}}}%>



			<%if(dgResultHeader.getSampleCollectionHeader() != null){
				if(dgResultHeader.getSampleCollectionHeader().getOrder() != null){
					if(dgResultHeader.getSampleCollectionHeader().getOrder().getDepartment() != null){
						if(dgResultHeader.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName() != null){
			%>
			     	    data_arr[<%= counter%>][9] = "<%=dgResultHeader.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%> "
			<%}}}}%>


		<%
			if(dgResultHeader.getSampleCollectionHeader() != null){
				if(dgResultHeader.getSampleCollectionHeader().getOrder() != null){
					if(dgResultHeader.getSampleCollectionHeader().getOrder().getPrescribedBy() != null){
					   if(dgResultHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName() != null){
		%>
						data_arr[<%= counter%>][10] = "<%=dgResultHeader.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName()%> "
		<%}}}}%>


		data_arr[<%= counter%>][11] = '<%=dgResultHeader.getResultType()%>'


		<%if (dgResultHeader.getSampleCollectionHeader() != null){
		     if(dgResultHeader.getSampleCollectionHeader().getOrder() != null){
		    	if(dgResultHeader.getSampleCollectionHeader().getOrder().getOrderNo() != null){

		%>
				data_arr[<%= counter%>][12] = "<%=dgResultHeader.getSampleCollectionHeader().getOrder().getOrderNo()%> "
		<%}else{%>
			   data_arr[<%= counter%>][12] = ""
				<%}}}%>
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
	</script>
<input type="hidden" name="count" id="count" value="<%=counter%>" />
