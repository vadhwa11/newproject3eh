
<%@page import="jkt.hms.masters.business.Department"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20">  -->
<script type="text/javascript">


<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	
	</script>
<%

	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	
	/*int sessionDepId=(Integer)request.getSession().getAttribute("deptId");*/
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");


	List doctorList= new ArrayList();
	List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
			
	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
		}
	
	List patientList = new ArrayList();
	int totalPatient=0;
	int searchDeptId=0;
	if(map.get("patientList") != null)
	{
		patientList=(List)map.get("patientList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	int deptId=0;

	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}

	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	
	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map.get("departmentList");
	}
	if (map.get("searchDeptId") != null) {
		searchDeptId = (Integer)map.get("searchDeptId");
	}
	
	%>

<div id="searchresults" tabindex=2 >
<div class="cmnTable"  id="searchtable" class="small" tabindex=2></div>
</div>

<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	/*data_header[0][3] = */<%--"<%= RequestConstants.RADIO_FOR_TABLE%>"--%>

	data_header[1] = new Array;
	data_header[1][0] = "Token No.<b>&nbsp;/&nbsp;</b>Queue No."
	data_header[1][1] = "data";
	data_header[1][2] = "8%";
	/*data_header[1][3] =*/ <%--"<%= RequestConstants.TOKEN_NO%>"--%>

	data_header[2] = new Array;
	data_header[2][0] = "UHID"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";
	/*data_header[2][3] = */<%--"<%=RequestConstants.HIN_NO %>";--%>

	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "5%";
	/*data_header[3][3] =*/ <%--"<%=RequestConstants.VISIT_DATE %>";--%>

	data_header[4] = new Array;
	data_header[4][0] = "Age"
	data_header[4][1] = "data";
	data_header[4][2] = "6%";
	/*data_header[4][3] = */<%--"<%=RequestConstants.VISIT_TIME %>";--%>

	data_header[5] = new Array;
	data_header[5][0] = "Gender"
	data_header[5][1] = "data";
	data_header[5][2] = "5%";
	/*data_header[5][3] =*/<%-- "<%=RequestConstants.HIN_NO %>";--%>

	data_header[6] = new Array;
	data_header[6][0] = "Doctor Name"
	data_header[6][1] = "data";
	data_header[6][2] = "5%";
	/*data_header[6][3] = */<%--"<%=RequestConstants.APPOINTMENT_TYPE %>";--%>
	
	/*if(document.getElementById('opd_Department').options[document.getElementById('opd_Department').selectedIndex].value==0){ commented by govind 13-02-2017*/
		data_header[7] = new Array;
		data_header[7][0] = "Service Center"
		data_header[7][1] = "data";
		data_header[7][2] = "5%";
		
		data_header[8] = new Array;
		data_header[8][0] = "Status"
		data_header[8][1] = "data";
		data_header[8][2] = "1%";
		
		data_header[9] = new Array;
		data_header[9][0] = "Priority"
		data_header[9][1] = "data";
		data_header[9][2] = "6%";
	/*}else{ commented by govind 13-02-2017
		
		data_header[7] = new Array;
		data_header[7][0] = "Status"
		data_header[7][1] = "data";
		data_header[7][2] = "1%";
		
		data_header[8] = new Array;
		data_header[8][0] = "Priority"
		data_header[8][1] = "data";
		data_header[8][2] = "6%";
	
	} */
	
	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";
	int opClinicId=Integer.parseInt(prop.getProperty("OP_CLINICAL_ID"));
	Iterator iterator=patientList.iterator();

	while(iterator.hasNext())
	{
		Visit visit= (Visit) iterator.next();
		if(visit.getDepartment()!=null && visit.getDepartment().getDepartmentType()!=null && visit.getDepartment().getDepartmentType().getId()!=opClinicId){
			continue;
		}
	//	if(visit.getDepartment().getId()!=81){
		if(visit.getVisitStatus().equalsIgnoreCase("w")||visit.getVisitStatus().equalsIgnoreCase("s"))
		{
		Patient patientHin=(Patient)visit.getHin();
		MasDepartment deptObj=(MasDepartment)visit.getDepartment();
		String patientName="";
		String age="";
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
		
		if(visit.getDoctor()!=null){
			if( !visit.getDoctor().getFirstName().equals(" ")){
				doctorName= visit.getDoctor().getFirstName()+" ";
			}
			if(visit.getDoctor().getMiddleName()!=null && !visit.getDoctor().getMiddleName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getMiddleName()+" ";
			}
			if(visit.getDoctor().getLastName()!=null && !visit.getDoctor().getLastName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getLastName();
			}
		}
		MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		Integer prioityNumber=3;
		if(visit.getHin().getAge()!= null && !visit.getHin().getAge().equals("0"))
			age=visit.getHin().getAge();
		if(visit.getPriorityNumber()!=null)
			prioityNumber=visit.getPriorityNumber();
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
	
		data_arr[<%= i%>][0] =<%=visit.getId()%>
		
		<%
		if(visit.getTokenNo()!=null)
		{
		%>
		data_arr[<%= i%>][2] = "<%=visit.getTotalHospitalVisit()%>/<%=visit.getTokenNo()%> " 
		<%
		}else{
		%>
		data_arr[<%= i%>][2] = ""
		<%
		}
		
		
		if(visit.getHin()!=null)
		{
		%>
		data_arr[<%= i%>][3]="<%=visit.getHin().getHinNo()%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][3]=""
		<%
		}
		
		
		if(visit.getHin()!= null )
		{
		%>
		data_arr[<%= i%>][4] = "<%=patientName%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][4] = ""
		<%
		}
		
		if(visit.getAge()!= null)
		{
		%>
		data_arr[<%= i%>][5] =  "<%=yearMonth%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][5] = ""
		<%
		}
		
		if(masAdministrativeSex!=null && (masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""))
		{
		%>
		data_arr[<%= i%>][6] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][6] = ""
		<%
		}
		
		if(visit.getDoctor() != null)
		{
		%>
		data_arr[<%= i%>][7] ="<%=doctorName%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][7] = ""
		<%
		}
		%>
		
		<%//if(visit.getDepartment().getId()!=searchDeptId){ commented by govind 13-02-2017
			if(visit.getDepartment()!= null)
			{
			%>
			data_arr[<%= i%>][8] = "<%=visit.getDepartment().getDepartmentName()%>"
			<%
			}else{
			%>
			data_arr[<%= i%>][8] = ""
			<% 
			}
			
			if(visit.getVisitStatus()!= null)
			{%>
				data_arr[<%= i%>][9] = "Waiting"
			<%}else{%>
				data_arr[<%= i%>][9] = ""
			<%}%>
			data_arr[<%= i%>][10] = '<%=prioityNumber%>'
			
<%-- 	<%}else{%> commented by govind 13-02-2017--%>
<%-- 			data_arr[<%= i%>][8] = "Waiting" --%>
<%-- 			data_arr[<%= i%>][9] ='<%=prioityNumber%>' --%>
<%-- 			<%}  %> --%>
	<%
		i++;
		}
	//	}
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	%>

	formName = "opd_nurse_waiting_PatientList"

	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	
	makeGridForPatient(start,end);

</script>
