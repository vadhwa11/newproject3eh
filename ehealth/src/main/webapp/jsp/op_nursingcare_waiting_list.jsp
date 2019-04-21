<%@page import="jkt.hms.masters.business.InjAppointmentHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js?n=1"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript">
	<%
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script> 
<%

	
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	int totalPatient=0;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");

	String depName="";
	if(session.getAttribute("deptName")!=null){
		depName=(String)session.getAttribute("deptName");	
	}
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	
	/* List<PatientPrescriptionHeader>nursingCareWaitingList=new ArrayList<PatientPrescriptionHeader>();
	if(map.get("nursingCareWaitingList") != null){
		nursingCareWaitingList=(List)map.get("nursingCareWaitingList");
	} */
	List<Visit>pendingNursingList=(List<Visit>)map.get("pendingNursingList");
	
	List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
	int searchDeptId=0;
	if (map.get("searchDeptId") != null) {
		searchDeptId = (Integer)map.get("searchDeptId");
	}
	if (map.get("departmentList") != null) {
			departmentList = (List<MasDepartment>) map.get("departmentList");
		}
	String FromDateId="",ToDateId="";
	if(map.get("FromDateId")!=null){
		FromDateId=HMSUtil.convertDateToStringWithoutTime((Date)map.get("FromDateId"));
	}
	if(map.get("ToDateId")!=null){
		ToDateId=HMSUtil.convertDateToStringWithoutTime((Date)map.get("ToDateId"));
	}
	if(FromDateId.equals("")){
		FromDateId=date;
	}
	if(ToDateId.equals("")){
		ToDateId=date;
	}
	
	Map<String,Integer> doctorMap=new HashMap<String, Integer>();
	if(map.get("doctorMap")!=null){
		doctorMap=(Map)map.get("doctorMap");
	}
	
	List<OpdPatientDetails> opdPatientList=new ArrayList<OpdPatientDetails>();
	if (map.get("opdPatientList") != null) {
		opdPatientList = (List<OpdPatientDetails>) map.get("opdPatientList");
	}
	Map<Integer, Integer> searchSelectedDeptIdlist = new HashMap<Integer, Integer>();
	if (map.get("searchSelectedDeptIdlist") != null) {
		searchSelectedDeptIdlist = (Map<Integer,Integer>)map.get("searchSelectedDeptIdlist");
	}
	List<MasInstituteDepartment>instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
	if (map.get("instituteDepartmentList") != null) {
		instituteDepartmentList = (List<MasInstituteDepartment>) map.get("instituteDepartmentList");
	}
	%>
	<h4><%=message %></h4>
	<div class="clear"></div>
<div class="titleBg">
<h2><%=depName %></h2>
</div>
<div class="Block">
<div class="clear"></div>
<h4>OP Nursing Care Waiting List</h4>
<form name="op_nursingcare_Waiting_List" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Service Center</label>
<select id="opd_Department" name="opd_Department" multiple="multiple" size="3" class="multiple" validate="opd_Department,alphanumeric,no">
	<option value="0">All</option>
	<%
	for(MasInstituteDepartment dept:instituteDepartmentList){
		if(searchSelectedDeptIdlist.containsKey(dept.getDepartment().getId())){ 
	%>
	<option value="<%=dept.getDepartment().getId()%>" selected="selected"><%=dept.getDepartment().getDepartmentName()%></option>
	<%}else{%>		
		<option value="<%=dept.getDepartment().getId()%>"><%=dept.getDepartment().getDepartmentName()%></option>
	
	<%}}%>
<%--<%
	for(MasDepartment dep:departmentList){
		//Service centre changed to multiple selection by Arbind on 17-05-2017
		/* if(dep.getId()==searchDeptId){ */
		if(searchSelectedDeptIdlist.containsKey(dep.getId())) { 
%>
	<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
<%		
		}
		else{%>
		
		<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
	<%}
	}
%> --%>
</select>
<div class="clear"></div>
<label>From Date</label>
<input type="text" id="FromDateId" name="FromDateId" class="dateTextSmall" value="<%=FromDateId%>" readonly="readonly">
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
	onclick="setdate('<%=date%>',document.op_nursingcare_Waiting_List.FromDateId,event);" />

<label>To Date</label>
<input type="text" id="ToDateId"name="ToDateId" class="dateTextSmall" value="<%=ToDateId%>" readonly="readonly">
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	
	onclick="setdate('<%=date%>',document.op_nursingcare_Waiting_List.ToDateId,event);" />

<!-- <input type="button" name="search" value="Search" class="button" -->
<!-- 	onClick="if(datevalidation()){submitForm('op_nursingcare_Waiting_List','/hms/hms/opd?method=getPendingInjectionList');}" /> -->
	<input type="button" name="search" value="Search" class="button"
	onClick="if(datevalidation()){submitForm('op_nursingcare_Waiting_List','/hms/hms/opd?method=getOPNursingCareWaitingList&searchDept=1');}" />
	
</form>
</div>
<div class="clear"></div>
<div class="floatleft">
<div>
<jsp:include page="searchResultBlockForIPD.jsp" />
</div>
</div>
<div class="clear"></div>	
<div  id="test">
<div id="searchresults" tabindex=2 >
<div class="Blockdiv1 floatLeft"  id="searchtable" class="small" tabindex=2></div>
</div>
<div id="edited"></div>
<div id="statusMessage"></div>
</div>

<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	
	data_header[1] = new Array;
	data_header[1][0] = "Token No"
	data_header[1][1] = "data";
	data_header[1][2] = "8%";
	
	data_header[2] = new Array;
	data_header[2][0] = "UHID"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";

	data_header[3] = new Array;
	data_header[3][0] = "OP Date"
	data_header[3][1] = "data";
	data_header[3][2] = "5%";
	
	data_header[4] = new Array;
	data_header[4][0] = "Patient Name"
	data_header[4][1] = "data";
	data_header[4][2] = "5%";

	data_header[5] = new Array;
	data_header[5][0] = "Age"
	data_header[5][1] = "data";
	data_header[5][2] = "6%";

	data_header[6] = new Array;
	data_header[6][0] = "Gender"
	data_header[6][1] = "data";
	data_header[6][2] = "5%";

	data_header[7] = new Array;
	data_header[7][0] = "Doctor Name"
	data_header[7][1] = "data";
	data_header[7][2] = "5%";
	
	data_header[8] = new Array;
// 	data_header[8][0] = "Patient Category"
 	data_header[8][0] = "Department"
	data_header[8][1] = "data";
	data_header[8][2] = "5%";
	
	data_header[9] = new Array;
	data_header[9][0] = "Status"
	data_header[9][1] = "data";
	data_header[9][2] = "5%";
	
	data_header[10] = new Array;
	data_header[10][0] = "Priority"
	data_header[10][1] = "data";
	data_header[10][2] = "5%";
	
	
	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";
	if(pendingNursingList!=null && pendingNursingList.size()>0){
	Iterator iterator=pendingNursingList.iterator();
	
	while(iterator.hasNext())
	{	
		Visit visit=(Visit)iterator.next();
		int injHeaderId=0;
		
		String patientStatus="";
		Patient patientHin=(Patient)visit.getHin();
		String patientCategory="";
		String patientName="";
		String deptName="";
		String age="";
		String priority="";
	
			patientStatus="Pending";
		
			if(visit.getDepartment()!=null){
				deptName=visit.getDepartment().getDepartmentName();
			}
		if(patientHin.getPatientCategory()!=null){
			 patientCategory=patientHin.getPatientCategory().getPatientCategoryName();
		}
		if(patientHin.getAge()!=null && !patientHin.getAge().equals("")){
			age=patientHin.getAge();
		}
		if(visit.getHin().getPFirstName()!= null){
			patientName=visit.getHin().getPFirstName();
			
			if(visit.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+visit.getHin().getPMiddleName();
			}
			if(visit.getHin().getPLastName()!= null)
			{
			patientName=patientName+" "+visit.getHin().getPLastName();
			}
		
			
		}else if(visit.getHin().getFullName()!=null){
			patientName = visit.getHin().getFullName();
		}
		String doctorName="";		
		for(OpdPatientDetails doc:opdPatientList){
			if(visit.getId()==doc.getVisit().getId()){
				doctorName=doc.getEmployee().getFirstName();
			}
		}
		/*if(visit.getDoctor()!=null){
			if( !visit.getDoctor().getFirstName().equals(" ")){
				doctorName= visit.getDoctor().getFirstName()+" ";
			}
			if(visit.getDoctor().getMiddleName()!=null && !visit.getDoctor().getMiddleName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getMiddleName()+" ";
			}
			if(visit.getDoctor().getLastName()!=null && !visit.getDoctor().getLastName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getLastName();
			}
			if(doctorName.equals("")){
				if(visit.getDoctor().getEmployeeName()!=null && !visit.getDoctor().getEmployeeName().equals(" ")){
					doctorName=visit.getDoctor().getEmployeeName();
				}	
			}
		}*/
		/* String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate()); */
		String sex="";
		MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		if(masAdministrativeSex!=null && (masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""))
		sex = masAdministrativeSex.getAdministrativeSexName();
		priority=String.valueOf(visit.getPriorityNumber());
		/* Added by Arbind on 26-04-2017 */
		String yearMonth = "";
		if(visit.getHin().getDateOfBirth()!=null){
			Date dob=visit.getHin().getDateOfBirth();
			String ymd=HMSUtil.calculateYearMonthDay(dob);
			String d[]=ymd.split("&");
			int year1=Integer.parseInt(d[0].toString());
			int months1=Integer.parseInt(d[1].toString());
			int days1=Integer.parseInt(d[2].toString());
			yearMonth = year1 != 0 ? d[0] + " Y " : "";
			yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
			yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
		}
		%>
		data_arr[<%= i%>] = new Array();
		data_arr[<%= i%>][0] ="<%=injHeaderId%>"
		data_arr[<%= i%>][2] ="<%=visit.getTokenNo()%>"
		data_arr[<%= i%>][3] ="<%=visit.getHin().getHinNo()%>"
		data_arr[<%= i%>][4] = "<%=HMSUtil.changeDateToddMMyyyy(visit.getVisitDate())%>" 
		data_arr[<%= i%>][5] = "<%=patientName%> " 
		data_arr[<%= i%>][6]="<%=yearMonth%>"
		data_arr[<%= i%>][7] = "<%=sex%>"
		data_arr[<%= i%>][8] = "<%=doctorName%>"
 		//data_arr[<%= i%>][9] = "<%=patientCategory%>"
		data_arr[<%= i%>][9] = "<%=deptName%>"
		data_arr[<%= i%>][10] ="<%=patientStatus%>"
		data_arr[<%= i%>][11] ="<%=priority%>"
		data_arr[<%= i%>][12] ="<%=visit.getId()%>"
	<%
		i++;
	}
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	%>

	formName = "op_nursingcare_Waiting_List"

	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	
	makeGridForPatient(start,end);

	//intializeHover('searchresulttable', 'TR', ' tableover');
	
	
	function datevalidation(){
	
	
	var fdate = document.getElementById('FromDateId');
	var tdate = document.getElementById('ToDateId');
	
	frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
	todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));
	
	
	if(fdate.value != "" && todate.value != ""){
	 if(frdate > todate){
	  alert("To Date should be greater than or equal to the From Date.");
	   return false;
	  }
	}else{
	 return false;
	}
	return true;	
		
		}
	
	callOPNursingList(); //added by govind 13-02-2017
	function callOPNursingList(){
		var FromDateId=document.getElementById("FromDateId").value;
		var ToDateId=document.getElementById("ToDateId").value;
		//Department list Changed by Arbind on 17-05-2017 
		//var opd_Department=document.getElementById("opd_Department").value;
		var opd_Department=document.getElementById("opd_Department");
		var deptIdlist = [];
		for (var i = 0; i < opd_Department.options.length; i++) {
     		if(opd_Department.options[i].selected ==true){
     			deptIdlist.push(opd_Department.options[i].value);
			}
		}
	   	// alert("tokenNo "+tokenNo+" pName "+pName+" hinNo "+hinNo);
		submitProtoAjaxWithDivName('op_nursingcare_Waiting_List','/hms/hms/opd?method=getOPNursingCareWaitingListRefresh&FromDateId='+FromDateId+'&ToDateId='+ToDateId+'&opd_Departments='+deptIdlist,'test');
		setTimeout(callOPNursingList, 30000);
	}
	//added by govind 13-02-2017 end
</script>
