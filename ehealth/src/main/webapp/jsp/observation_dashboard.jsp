<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
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
<%

	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	int totalPatient=0;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");

	List<OpdPatientDetails>observationWaitingList=new ArrayList<OpdPatientDetails>();
	if(map.get("observationWaitingList") != null){
		observationWaitingList=(List)map.get("observationWaitingList");
	}
	%>
<div class="titleBg">
<h2>General Medicine</h2>
</div>
<div class="clear"></div>

<h4>Observation Ward Admission Waiting List</h4>
<div class="Block" st>
<form name="observationWaitingList" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<label>Token No</label>
<input name="tokenNo" id="tokenNo" type="text"	   tabindex="1"/>

<label>UHID</label>
<input name="uhid" id="uhid" type="text"  tabindex="2"/>

<label>Patient Name</label>
<input name="patientName" id="patientName" type="text"	  tabindex="3"/>
<div class="clear"></div>

<label>Doctor Name</label>
<input name="doctorName" type="text"	 tabindex="4"/>

<label>Mobile No</label>
<input name="mobileno" id="mobileno" type="text"	 tabindex="5"/>


<input type="button" class="buttonAuto"  id="search" name="search" value="Search" 
			onClick="submitForm('observationWaitingList','/hms/hms/opd?method=getObservationDashboard');" />
</form>

<form name="observation_ward_dashboard_List" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
</div>
</form>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="floatleft">
<div style="display:none">
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
	data_header[2][0] = "VisitNo"
	data_header[2][1] = "data";
	data_header[2][2] = "8%";

	data_header[3] = new Array;
	data_header[3][0] = "Visit Date"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";

	data_header[4] = new Array;
	data_header[4][0] = "UHID"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";

	data_header[5] = new Array;
	data_header[5][0] = "Patient Name"
	data_header[5][1] = "data";
	data_header[5][2] = "5%";

	data_header[6] = new Array;
	data_header[6][0] = "Age"
	data_header[6][1] = "data";
	data_header[6][2] = "6%";

	data_header[7] = new Array;
	data_header[7][0] = "Gender"
	data_header[7][1] = "data";
	data_header[7][2] = "5%";

	data_header[8] = new Array;
	data_header[8][0] = "Doctor Name"
	data_header[8][1] = "data";
	data_header[8][2] = "5%";
	
	
	
	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";

	Iterator iterator=observationWaitingList.iterator();

	while(iterator.hasNext())
	{
		OpdPatientDetails wardPatient= (OpdPatientDetails) iterator.next();
		int opdId=wardPatient.getId();
		Visit visit=wardPatient.getVisit();
		Patient patientHin=(Patient)visit.getHin();
		MasDepartment deptObj=(MasDepartment)visit.getDepartment();
		String patientName="";
		String age="";
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
		String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		String sex="";
		MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		if(masAdministrativeSex!=null && (masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""))
		sex = masAdministrativeSex.getAdministrativeSexName();
		%>
		data_arr[<%= i%>] = new Array();
		data_arr[<%= i%>][0] ="<%=opdId%>"
		data_arr[<%= i%>][2] ="<%=visit.getTokenNo()%>"
		data_arr[<%= i%>][3] ="<%=visit.getVisitNo()%>"
		data_arr[<%= i%>][4] = "<%=visitDate%> " 
		data_arr[<%= i%>][5]="<%=visit.getHin().getHinNo()%>"
		data_arr[<%= i%>][6] = "<%=patientName%>"
		data_arr[<%= i%>][7] = "<%=age%>"
		data_arr[<%= i%>][8] = "<%=sex%>"
		data_arr[<%= i%>][9] ="<%=doctorName%>"
	<%
		i++;
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	%>

	formName = "observation_ward_dashboard_List"

	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	
	makeGridForPatient(start,end);

	//intializeHover('searchresulttable', 'TR', ' tableover');
	</script>
