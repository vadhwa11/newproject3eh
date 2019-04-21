
<%@page import="jkt.hms.masters.business.Department"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
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
	List<MasInstituteDepartment>instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
			
	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
		}
	
	List patientList = new ArrayList();
	int totalPatient=0;
	//int searchDeptId=0;
	Map<Integer, Integer> searchSelectedDeptIdlist = new HashMap<Integer, Integer>();
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
	if (map.get("instituteDepartmentList") != null) {
		instituteDepartmentList = (List<MasInstituteDepartment>) map.get("instituteDepartmentList");
	}
	/* if (map.get("searchDeptId") != null) {
		searchDeptId = (Integer)map.get("searchDeptId");
	} */
	if (map.get("searchSelectedDeptIdlist") != null) {
		searchSelectedDeptIdlist = (Map<Integer,Integer>)map.get("searchSelectedDeptIdlist");
	}
	int tokenNo=0;
	String patientName1="";
	String uhid="";
	if (map.get("patientName") != null) {
		patientName1 = (String) map.get("patientName");
		}
	if (map.get("uhid") != null) {
		uhid = (String) map.get("uhid");
		}
	if(map.get("tokeNo")!=null){
		tokenNo=Integer.parseInt(map.get("tokeNo").toString());
	}
	%>
<div class="titleBg">
<h2><%=deptName %></h2>
</div>	
<div class="Block">
<h4>Pre Consultation Assessment waiting list</h4>
<%
if(map.get("openMsg") != null){
	String openMsg = (String)map.get("openMsg");
	%>
	<h4><span><%=openMsg %></span></h4>
<%}%>
<%
if(map.get("message") != null){
	String message = (String)map.get("message");
	%>
	<h4><span><%=message %></span></h4>
<%}%>
<% 
if(request.getAttribute("savedName") != null && request.getAttribute("savedName") != null){%>
		<div class="clear"></div>
		<label class="large"><span>Pre-consultation is done for <B><%=request.getAttribute("savedName")%></B></span></label>
		<div class="clear"></div>
<%}%>
<form name="nurseWaitingList" action="" method="post">
<label>Service Center</label>
<select id="opd_Department" name="opd_Department" multiple="multiple" size='3' class="multiple" validate="opd_Department,alphanumeric,no">
	<option value="0">All</option>	
	<%
	for(MasInstituteDepartment dept:instituteDepartmentList){
		if(searchSelectedDeptIdlist.containsKey(dept.getDepartment().getId())){ 
	%>
	<option value="<%=dept.getDepartment().getId()%>" selected="selected"><%=dept.getDepartment().getDepartmentName()%></option>
	<%}else{%>		
		<option value="<%=dept.getDepartment().getId()%>"><%=dept.getDepartment().getDepartmentName()%></option>
	
	<%}
	}%>
<%--<%
	for(MasDepartment dep:departmentList){
		//Service centre changed to multiple selection by Arbind on 08-05-2017
		/* if(dep.getId()==searchDeptId){ */
		if(searchSelectedDeptIdlist.containsKey(dep.getId())){ 
			System.out.println("list dept "+searchSelectedDeptIdlist.containsKey(dep.getId()));
		
%>
	<option value="<%=dep.getId()%>" selected="selected"><%=dep.getDepartmentName()%></option>
<%		
		}
		else{%>
		
		<option value="<%=dep.getId()%>"><%=dep.getDepartmentName()%></option>
	<%}
	}
%>--%>
</select>
<div class="clear"></div>
<label>Token No</label>
<input type="text" name="tokenNo" id="tokenNo"  validate="tokenNo,num,no"  value="<%=tokenNo>0?tokenNo:""%>"/>
<label class="auto">Patient Name</label>
<input type="text" name="patientName" id="patientName" validate="patientName,alphanumeric,no" value="<%=patientName1%>"/>
<label class="auto">UHID</label>
<input type="text" name="uhid" id="uhid" validate="UHID,alphanumeric,no" value="<%=uhid%>"/>
<input type="hidden" name="searchFlag" id="searchFlag" value="1"/>
<input type="button" class="buttonAuto" id="search" name="search" value="Search" onClick="validate();" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>

<form name="opd_nurse_waiting_PatientList" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
if(patientList.size()>0)
{
	totalPatient = patientList.size();
%>
<div class="clear"></div>
<input type="button" name="openButton" value="Open Token Display"	class="buttonAuto" onclick="openTokenDisplay(<%=deptId%>)"/>
<input type="button" name="closeButton" value="Close Token Display" onclick="closeTokenDisplay()" class="buttonAuto" />

<%}%>
<!-- 
<div class="floatRight"><label>Total Waiting Patient : </label>
<label	class="valueAutoBold"><%--<%=totalPatient%>--%></label>
</div>
 -->
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
<div class="cmnTable"  id="searchtable" class="small" tabindex=2></div>
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
			
<%-- 	<%}else{%> commented by govind 13-02-2017 --%>
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

	//intializeHover('searchresulttable', 'TR', ' tableover');
	</script>

<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=i %>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <input
	type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />

	<script type="text/javascript">
	//window.moveTo(0,0);
	function validate(){
		var patientName=document.getElementById("patientName").value;
		if(!chkInputLength(patientName))
			{alert("Patient Name should be more than 3 characher");}
		else
			submitForm('nurseWaitingList','/hms/hms/opd?method=showWaitingPatientListJsp&searchDept=1');
	}
	function chkInputLength(strValue){
			if(strValue!="" && strValue.length<3){
				return false;
			}
			return true;
	}
	function openTokenDisplay(deptId)
	{
	 var url="/hms/hms/opd?method=showToeknDisplayForNurseJsp&deptId="+deptId+"&"+csrfTokenName+'='+csrfTokenValue;
	 //newwindow=window.open(url,'Token_Number','_blank',"left=100,top=100,height=700,width=850,location=0,toolbar=0,menubar=0,status=no,scrollbars=no,resizable=no");
	 newwindow=window.open(url,"","status=no,scrollbars=no,resizable=yes,height = 600, width = 800,fullscreen=yes");
	 newwindow.moveTo(1024,0);
	}

	function closeTokenDisplay(){

		if(false == newwindow.closed)
		{
			newwindow.close();
		}
		else
		{
		alert('Window already closed!');
		}
	}
	
	callPreConsultList(); //added by govind 13-02-2017
	function callPreConsultList(){
		//Department list Changed by Arbind on 08-05-2017 
		// var opd_Department=document.getElementById("opd_Department").value;
		var opd_Department=document.getElementById("opd_Department");
		var deptIdlist = [];
		for (var i = 0; i < opd_Department.options.length; i++) {
     		if(opd_Department.options[i].selected ==true){
     			deptIdlist.push(opd_Department.options[i].value);
			}
		}
		var tokenNo=document.getElementById("tokenNo").value;
		var patientName=document.getElementById("patientName").value;
		var uhid=document.getElementById("uhid").value;
		// alert("tokenNo "+tokenNo+" pName "+pName+" hinNo "+hinNo);
		submitProtoAjaxWithDivName('nurseWaitingList','/hms/hms/opd?method=getPreConsultingListRefresh&opd_Departments='+deptIdlist+'&tokenNo='+tokenNo+'&patientName='+patientName+'&uhid='+uhid,'test');
		setTimeout(callPreConsultList, 30000);
	}
	//added by govind 13-02-2017 end
</script>

<%patientList=null;

%>