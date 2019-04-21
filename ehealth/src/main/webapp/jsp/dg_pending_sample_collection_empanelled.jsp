<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pendingSampleCollection.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 20.01.2009    Name: Dipali
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
	
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
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String userName = "";
		String deptName="";
		String message = "";
		String patientType="";

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(patientMap.get("patientDetailList") != null){
			patientDetailList= (List<DgOrderhd>)patientMap.get("patientDetailList");
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
		if (map.get("patientType") != null) {
			patientType =(String) map.get("patientType");
	 		session.setAttribute("patientType", patientType);
	 	}
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
			}
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		String deptType ="";
		if(session.getAttribute("deptType") != null){
			deptType = (String)session.getAttribute("deptType");
		}
		
	%>
	<script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
		<%}	%>
</script>
	<script type="text/javascript">
	function check(){
		var FDate = document.patientSearch.<%= FROM_DATE%>.value;
		var TDate = document.patientSearch.<%= TO_DATE %>.value;


		var toDate =new Date(TDate.substring(6),(TDate.substring(3,5) - 1) ,TDate.substring(0,2))
		var fromDate =new Date(FDate.substring(6),(FDate.substring(3,5) - 1) ,FDate.substring(0,2))
	    if(fromDate > toDate)
		{
			alert("Please ensure that To Date is greater than or equal to the From Date.");
			document.calldate.next_day.focus();
			return false;
		}
	}
</script>
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
	<div class="titleBg">
		<h2>
			All Empanelled Sample Collection
		</h2>
	</div>
	<div class="clear"></div>
	<!-- <h4>Patient Search</h4> -->
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>


		<label><span>*</span> From Date</label> <input type="text"
			class="date" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=currentDate%>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.patientSearch.<%=FROM_DATE%>,event)" />

		<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
			readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input
			id="hinId" type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" />

		<div class="clear"></div>
		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" />
		<%if("IP".equalsIgnoreCase(patientType)){ %>
		<label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label> <input
			id="adId" type="text" name="<%=AD_NO %>" value="" MAXLENGTH="50" />
		<%}else{%>
		<label><%=prop.getProperty("com.jkt.hms.token_num")%></label> <input
			type="text" name="<%=VISIT_NUMBER %>" value="" MAXLENGTH="50" />
		<%}%>
		<label>Doctor Name</label> <input type="text" name="<%=DOCTOR_NAME %>"
			value="" MAXLENGTH="15" />
		<div class="clear"></div>
		<input type="hidden" name="patientType" value="<%=patientType%>" /> <label>&nbsp;</label>
		<div class="clear"></div>
		<input type="button" value="Search" class="button"
			onclick="submitForm('patientSearch','/hms/hms/lab?method=pendingEmpanelledLab','check()');"
			accesskey="a" /> <!-- <input type="button" value="Open Token Display"
			class="buttonBig" onclick="#" /> <input type="button"
			value="Close Token Display" class="buttonBig" onclick="#"
			accesskey="a" /> -->
		<div class="clear"></div>
	</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
	<div id="searchtable" tabindex="2"></div>
	<form name="pendingSampleEmpanelled" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
	<input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" />
	<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
		type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<script type="text/javascript">
	  formFields = [
			[0, "orderId", "id"],[1,"orderNo"],[2,"admissionDate"],[3,"ipNo"],[4,"orderDate"],[5,"orderTime"], [6,"hin"],
			[7,"patName"], [8,"age"], [9,"sex"],[10,"wardNo"],[11,"bedNo"], [12,"pType"],[13,"doctorName"],[14,"department"],
			[15,"departmentWard"],[15,"specialty"],[16,"Priority"]];
	  statusTd = 15;
	</script>
</div>
</form>
</div>
<script type="text/javascript" language="javascript">

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Token No"; 	 
data_header[0][1] = "data";   
data_header[0][2] = "7%";
data_header[0][3] = "orderNo"

data_header[1] = new Array;
data_header[1][0] = "Admission Date"; 
data_header[1][1] = "hide"; 
data_header[1][2] = "7%";
data_header[1][3] = "admissionDate"

data_header[2] = new Array;
data_header[2][0] = "IP No."; 	 
data_header[2][1] = "hide";  	 
data_header[2][2] = "15%";
data_header[2][3] = "ipNo";

data_header[3] = new Array;
data_header[3][0] = "Date";
data_header[3][1] = "data";  
data_header[3][2] = "15%";
data_header[3][3] = "orderDate";

data_header[4] = new Array;
data_header[4][0] = "Visit Time";
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "orderTime";

data_header[5] = new Array;
data_header[5][0] = "<%=prop.getProperty("com.jkt.hms.registration_no")%>";
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "hin";

data_header[6] = new Array;
data_header[6][0] = "Patient Name";
data_header[6][1] = "data";
data_header[6][2] = "10%";
data_header[6][3] = "patName";

data_header[7] = new Array;
data_header[7][0] = "Age"; 	 
data_header[7][1] = "data";   
data_header[7][2] = "10%";
data_header[7][3] = "age";

data_header[8] = new Array;
data_header[8][0] = "Gender";
data_header[8][1] = "data";  
data_header[8][2] = "10%";
data_header[8][3] = "sex";

data_header[9] = new Array;
data_header[9][0] = "Ward";
data_header[9][1] = "hide"; 	 
data_header[9][2] = "10%";
data_header[9][3] = "wardNo";

data_header[10] = new Array;
data_header[10][0] = "Bed No"; 
data_header[10][1] = "hide"; 	  
data_header[10][2] = "10%";
data_header[10][3] = "bedNo"; 

data_header[11] = new Array;
data_header[11][0] = "P Type";
data_header[11][1] = "hide";
data_header[11][2] = "10%";
data_header[11][3] = "pType";

data_header[12] = new Array;
data_header[12][0] = "Doctor Name";
data_header[12][1] = "data";
data_header[12][2] = "10%";
data_header[12][3] = "doctorName";

data_header[13] = new Array;
data_header[13][0] = "Department";
data_header[13][1] = "hide"; 
data_header[13][2] = "10%";
data_header[13][3] = "department";

data_header[14] = new Array;
data_header[14][0] = "Department"; 
data_header[14][1] = "hide";  
data_header[14][2] = "10%";
data_header[14][3] = "departmentWard";

	data_header[15] = new Array;
data_header[15][0] = "Specialty";
	<%if("OP".equalsIgnoreCase(patientType)){%>
	data_header[15][1] = "hide"; 
	<%}else{%>
	data_header[15][1] = "data"; 
	<%}%> 
data_header[15][2] = "10%";
data_header[15][3] = "specialty";

data_header[16] = new Array;
data_header[16][0] = "Priority"; 
data_header[16][1] = "data";  
data_header[16][2] = "10%";
data_header[16][3] = "priority";
   	
data_arr = new Array();
	<%
	    int  counter=0;
		if (patientDetailList != null && patientDetailList.size() > 0)
		{ %>

	<%
		String patientName = "";
		String age = "";
		String sex = "";
		String hinNo = "";

		for(DgOrderhd dgOrderhd: patientDetailList){
			String flag = "";
			if(deptType.equalsIgnoreCase("DIAG")){

				Set<DgOrderdt> set = new HashSet<DgOrderdt>();
				set = dgOrderhd.getDgOrderdts();
			for(DgOrderdt orderDt : set){
			//if(orderDt.getMainChargecode().getDepartment().getDepartmentType()==null){
//			}
				if((orderDt.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode()
						.equalsIgnoreCase("DIAG"))
						&& (orderDt.getOrderStatus().equalsIgnoreCase("P"))
						&& ("Y".equalsIgnoreCase(orderDt.getNotApplicable()))){
					flag = "lab" ;
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
			if(flag.equals("lab")){
			%> 
			  		data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= dgOrderhd.getId()%>
					data_arr[<%= counter%>][1] = "<%= dgOrderhd.getOrderNo()%>"
					data_arr[<%= counter%>][2] = "01/03/2015"
					data_arr[<%= counter%>][3] = "2136"
					data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(dgOrderhd.getOrderDate())%>"
					data_arr[<%= counter%>][5] = "<%=dgOrderhd.getOrderTime()%>"
					data_arr[<%= counter%>][6] = "<%=hinNo%>"
					data_arr[<%= counter%>][7] = "<%=patientName%>"
					data_arr[<%= counter%>][8] = "<%=age%>" 
					data_arr[<%= counter%>][9] = "<%=sex%>"
					data_arr[<%= counter%>][10] = "Male Medical Ward"
					data_arr[<%= counter%>][11] = "25"
					data_arr[<%= counter%>][12] = "<%=dgOrderhd.getPatientType()%>"
					<%String doctorName="";
					if(dgOrderhd.getPrescribedBy().getFirstName()!=null){
						doctorName=doctorName.concat(dgOrderhd.getPrescribedBy().getFirstName()+" ");
					}
					if(dgOrderhd.getPrescribedBy().getMiddleName()!=null){
						doctorName=doctorName.concat(dgOrderhd.getPrescribedBy().getMiddleName()+" ");
					}if(dgOrderhd.getPrescribedBy().getLastName()!=null){
						doctorName=doctorName.concat(dgOrderhd.getPrescribedBy().getLastName());
					}  
					%>
					data_arr[<%= counter%>][13] = "<%=doctorName%>"
					data_arr[<%= counter%>][14] = "<%=dgOrderhd.getDepartment().getDepartmentName()%> "
					data_arr[<%= counter%>][15] = "ICU"
					data_arr[<%= counter%>][16] = "Cardiology"
					<% 
					String status="";
					if("u".equalsIgnoreCase(dgOrderhd.getRoutineUrgentStatus())){
						status="Urgent";
					}else{
						status="Routine";
					}
					%>
					data_arr[<%= counter%>][17] = "<%=status%>"
						     <%
						     counter++;
					break;
		}	}	}%>
		<%}
		//patientDetailList.clear();	
		
		}%>
<%session.setAttribute("patientDetailList",patientDetailList);%>
    formName = "pendingSampleEmpanelled"
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}

	makeTable(start,end);

	</script>