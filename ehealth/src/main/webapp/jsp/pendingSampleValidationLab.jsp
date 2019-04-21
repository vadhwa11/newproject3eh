
<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pendingSampleValidationLab.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 11.08.2008    Name: Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>


<title>Patient Search</title>
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<div id="contentHolder">
<form name="patientSearch" action="" method="post"><script
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
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> patientDeatilList = new ArrayList<DgSampleCollectionDetails>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String userName = "";
		String deptName="";
		String message = "";
		String deptType = "";
		int deptId = 0;
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
			patientDeatilList= (List<DgSampleCollectionDetails>)patientMap.get("patientDeatilList");
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
		if (map.get("deptName") != null) {
		deptName= (String) map.get("deptName");
		}
		if (map.get("deptId") != null) {
			deptId= (Integer) map.get("deptId");
			}
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			
		<%}
	%>
	</script> <% if(deptType.equalsIgnoreCase("DIAG")){ %>
<h6>Pending for Sample Validation</h6>
<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<h6>Acceptance for Radiological Investigations</h6>
<%} %>
<div class="Clear"></div>
<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<label><font id="error">*</font>From Date</label> <input type="text"
	class="calDate" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />

<label>P Type</label> <select name="<%=PATIENT_TYPE%>">
	<option value="">Select One</option>
	<option value="IP">IP</option>
	<option value="OP">OP</option>
</select>
<div class="Clear"></div>

<label> Service No.</label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" /> <label>HIN</label> <input type="text"
	name="<%=HIN_NO %>" value="" MAXLENGTH="50" /> <label>Order By</label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
		for(MasDepartment masDepartment : departmentList){ %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%} %>
</select>
<div class="Clear"></div>
<label>Ser. Per. Name</label> <input type="text"
	name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="15" /> <label>Patient
Name</label> <input type="text" name="<%=P_FIRST_NAME %>" value=""
	MAXLENGTH="15" /> <label>IP No.</label> <input type="text"
	name="<%=AD_NO %>" value="" class="textbox_size20" MAXLENGTH="50" />
<div class="Clear"></div>
</div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="Clear"></div>

<input type="button" name="submit" id="addbutton"
	onclick="submitForm('patientSearch','/hms/hms/lab?method=searchPatientForSampleValidationLab');"
	value="Search" class="CmnButton" accesskey="a" />

<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="pendingSampleValidationLab" method="post" action="">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1,"diagDate"],[2,"diagTime"],[3,"serNo"], [4,"rank"], [5,"sPerson"], [6,"serviceType"], [7,"hin"], [8,"patName"], [9,"relation"], [10,"orderBy"], [10,"subDepartment"] ];
	 statusTd = 11;
	</script></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>
</div>
<script type="text/javascript" language="javascript">
	
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Diag Date"
data_header[0][1] = "data";
data_header[0][2] = "7%";
data_header[0][3] = "diagDate"

data_header[1] = new Array;
data_header[1][0] = "Diag Time"
data_header[1][1] = "data";
data_header[1][2] = "7%";
data_header[1][3] = "diagTime"

data_header[2] = new Array;
data_header[2][0] = "Service No."
data_header[2][1] = "data";
data_header[2][2] = "20%";
data_header[2][3] = "servNo";

data_header[3] = new Array;
data_header[3][0] = "Rank"
data_header[3][1] = "hide";
data_header[3][2] = "10%";
data_header[3][3] = "rank"

data_header[4] = new Array;
data_header[4][0] = "Service Person Name"
data_header[4][1] = "data";
data_header[4][2] = "10%";
data_header[4][3] = "sPerson"

data_header[5] = new Array;
data_header[5][0] = "Service Type"
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "serviceType";

data_header[6] = new Array;
data_header[6][0] = "HIN"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "hin";

data_header[7] = new Array;
data_header[7][0] = "Patient Name"
data_header[7][1] = "data";
data_header[7][2] = "20%";
data_header[7][3] = "patName";

data_header[8] = new Array;
data_header[8][0] = "Relation"
data_header[8][1] = "hide";
data_header[8][2] = "20%";
data_header[8][3] = "relation";

data_header[9] = new Array;
data_header[9][0] = "Order By"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "orderBy";

data_header[10] = new Array;
data_header[10][0] = "Sub Department"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "subDepartment";

data_arr = new Array();
</script>
<%
				List<String> combinedListAll = new ArrayList<String>();
			int counter = 0;
			if (patientDeatilList.size() > 0){
				int x = 0;	
				
				combinedListAll.add(patientDeatilList.get(0).getSampleCollectionHeader().getId()+","
						+patientDeatilList.get(0).getSubcharge().getId());
				%>

<jsp:include page="pendingSampleValidationLabGrid.jsp" flush="true">
	<jsp:param name="counter" value="<%=counter%>" />
	<jsp:param name="resultEntryIndex" value="<%=x%>" />
</jsp:include>
<%  for(int ilop=0;ilop<patientDeatilList.size()-1;ilop++)
				{
					if(!patientDeatilList.get(ilop).getSampleCollectionHeader().getId()
							.equals(patientDeatilList.get(ilop+1).getSampleCollectionHeader().getId())){
						counter++;

						
						combinedListAll.add(patientDeatilList.get(ilop+1).getSampleCollectionHeader().getId()+","
								+patientDeatilList.get(ilop+1).getSubcharge().getId());
						
						%>

<jsp:include page="pendingSampleValidationLabGrid.jsp" flush="true">
	<jsp:param name="counter" value="<%=counter%>" />
	<jsp:param name="resultEntryIndex" value="<%=(ilop+1)%>" />
</jsp:include>
<%  } else {
						if(!patientDeatilList.get(ilop).getInvestigation().getSubChargecode().getId()
								.equals(patientDeatilList.get(ilop+1).getInvestigation().getSubChargecode().getId())){
							counter++;

							
							combinedListAll.add(patientDeatilList.get(ilop+1).getSampleCollectionHeader().getId()+","
									+patientDeatilList.get(ilop+1).getSubcharge().getId());
							
							%>

<jsp:include page="pendingSampleValidationLabGrid.jsp" flush="true">
	<jsp:param name="counter" value="<%=counter%>" />
	<jsp:param name="resultEntryIndex" value="<%=(ilop+1)%>" />
</jsp:include>
<%	}					
					}
				}
			}
%>


<%
	if(session.getAttribute("combinedListSampleValidationAll") != null){
		session.removeAttribute("combinedListSampleValidationAll");
		session.setAttribute("combinedListSampleValidationAll",combinedListAll);
	}else{
		session.setAttribute("combinedListSampleValidationAll",combinedListAll);
	}
	%>

<script type="text/javascript" language="javascript">   
    formName = "pendingSampleValidationLab"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
		
	</script>
