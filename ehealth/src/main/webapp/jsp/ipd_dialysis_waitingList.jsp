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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
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
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	int totalPatient=0;

	List doctorList= new ArrayList();
	if(map.get("doctorList") != null){
		doctorList=(List)map.get("doctorList");
		}

	List<Object[]> visitPatientList = new ArrayList<Object[]>();

	if(map.get("patientList") != null){
		visitPatientList=(List<Object[]>)map.get("patientList");
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
	
	int inpatientId=0;
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
		}
		
	%>

<div class="titleBg">
<h2><%=deptName%></h2>
</div>
<div class="clear"></div>

<div class="search" id="threadsearch"><a href=""></a>
<script
	type="text/javascript"> vbmenu_register("threadsearch"); </script>
	</div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label><%=prop.getProperty("com.jkt.hms.registration_no") %>:</label>
<input type="text" name="<%= RequestConstants.HIN_NO %>" id="hinNo"	MAXLENGTH="30" tabindex=1 />

<input type="hidden" name="deptName"	id="deptName" value="<%=deptName %>" />
<input type="hidden"	name="date" id="date" value="<%=date %>" />
<div class="clear"></div>

	<label>Patient First Name : </label>
	<input type="text"	name="<%= RequestConstants.P_FIRST_NAME %>" id="patientFName"	MAXLENGTH="30" tabindex=1 />

<label>Patient Middle Name : </label>
<input type="text"	name="<%= RequestConstants.P_MIDDLE_NAME %>" id="patientMName"	MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>
<label>Patient Last Name : </label>
<input	type="text" name="<%= RequestConstants.P_LAST_NAME %>"	id="pateintLName" MAXLENGTH="30" tabindex=1 />

<input type="button" onClick="submitForm('search','opd?method=showPhysiotherapyPatientList&filter=true');"	class="button" /></form>
</div>
<%
	if(map.get("message") != null){
	String message = (String)map.get("message");
	%>
	<h4><span><%=message %></span></h4>
	<%}	%>

<form name="ipdDialysisList" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<%
if(visitPatientList.size()>0)
{
	totalPatient = visitPatientList.size();
%>
<input type="button" name="openButton" value="Open Token Display"	class="buttonBig" onclick="openTokenDisplay(<%=deptId%>)"/>
<input type="button" name="closeButton" value="Close Token Display" onclick="closeTokenDisplay()" class="buttonBig" />

<%}%>

<div class="clear"></div>
<div class="Block"><label class="auto">Consulting Doctor</label> <select
	name="consultingDoc">
	<option value="0">All</option>
	<%
	if(doctorList.size()>0){
				Iterator itr=doctorList.iterator();
				   while(itr.hasNext())
				   {
					   MasEmployee masEmployee=(MasEmployee)itr.next();
					   String empName="";
						   if(masEmployee.getFirstName() != null){
							   empName=masEmployee.getFirstName();
						   }
							if(masEmployee.getMiddleName()!= null){
								empName=empName+" "+masEmployee.getMiddleName();
							}
							if(masEmployee.getLastName() != null){
								empName=empName+""+masEmployee.getLastName();
							}
					int  empId=0;
					if(map.get("empId")!= null){
					  empId	=(Integer)map.get("empId");
					}
					  if(empId==masEmployee.getId()){
				%>
	<option value="<%=masEmployee.getId()%>" selected><%=empName%></option>
	<%
			   }else{
				   %>
	<option value="<%=masEmployee.getId()%>"><%=empName%></option>
	<%
				   }
			   }}
			%>
</select> <input type="button" name="Go" value="Go"
	onClick="submitForm('ipdDialysisList','opd?method=showPhysiotherapyPatientList&filter=true')"
	class="button" "/>
<div class="floatRight"><label>Total Waiting Patient : </label> <label
	class="valueAutoBold"><%=totalPatient%></label></div>
<div class="clear"></div>
</div>
</form>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>
<div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<div class="padingTop40"></div>
<script type="text/javascript" language="javascript">

	formFields = [
	[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.HIN_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"<%=RequestConstants.SILORDIL%>"] ];
	statusTd =12;

	</script></div>

<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"

	data_header[1] = new Array;
	data_header[1][0] = "Token No"
	data_header[1][1] = "hide";
	data_header[1][2] = "8%";
	data_header[1][3] = "<%= RequestConstants.TOKEN_NO%>"

	data_header[2] = new Array;
	data_header[2][0] = "Visit Number"
	data_header[2][1] = "hide";
	data_header[2][2] = "10%";
	data_header[2][3] = "<%= RequestConstants.VISIT_NUMBER %>";

	data_header[3] = new Array;
	data_header[3][0] = "Physio Date"
	data_header[3][1] = "data";
	data_header[3][2] = "5%";
	data_header[3][3] = "<%=RequestConstants.VISIT_DATE %>";

	data_header[4] = new Array;
	data_header[4][0] = "Visit Time"
	data_header[4][1] = "data";
	data_header[4][2] = "6%";
	data_header[4][3] = "<%=RequestConstants.VISIT_TIME %>";

	data_header[5] = new Array;
	data_header[5][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[5][1] = "data";
	data_header[5][2] = "5%";
	data_header[5][3] = "<%=RequestConstants.HIN_NO %>";

	data_header[6] = new Array;
	data_header[6][0] = "Appointment Type"
	data_header[6][1] = "hide";
	data_header[6][2] = "5%";
	data_header[6][3] = "<%=RequestConstants.APPOINTMENT_TYPE %>";

	data_header[7] = new Array;
	data_header[7][0] = "Patient Name"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "<%=RequestConstants.PATIENT_NAME %>";

	data_header[8] = new Array;
	data_header[8][0] = "Age"
	data_header[8][1] = "hide";
	data_header[8][2] = "6%";
	data_header[8][3] = "<%=RequestConstants.AGE %>";

	data_header[9] = new Array;
	data_header[9][0] = "Sex"
	data_header[9][1] = "hide";
	data_header[9][2] = "1%";
	data_header[9][3] = "<%=RequestConstants.SEX%>";

	data_header[10] = new Array;
	data_header[10][0] = "Diagnosis"
	data_header[10][1] = "data";
	data_header[10][2] = "10%";
	data_header[10][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";

	data_header[11] = new Array;
	data_header[11][0] = "I-Card Status"
	data_header[11][1] = "hide";
	data_header[11][2] = "1%";
	data_header[11][3] = "<%=RequestConstants.I_CARD_VERIFIED %>";

	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";
//	 Visit visit = new  Visit();
	for(Object[] object:visitPatientList)
	{
//		  = (Object[]).get(j);

	  //visit = (Visit)visitPatientList.get(j);
	%>

	data_arr[<%= i%>] = new Array();

	data_arr[<%= i%>][0] ="<%=object[0]%>"

	data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=object[0]%>" id="parent" />'

	<%
	if(object[0]!=null)
	{
	%>
	data_arr[<%= i%>][2] = "<%=object[0]%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][2] = ""
	<%
	}
	if(object[0]!=null)
	{
	%>
	data_arr[<%= i%>][3]="<%=object[0]%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][3]=""
	<%
	}
	if(object[4]!= null )
	{
	%>
	data_arr[<%= i%>][4] = "<%=object[4]%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][4] = ""
	<%
	}if(object[5]!= null && object[5]!= "")
	{
	%>
	data_arr[<%= i%>][5] = "<%=object[5]%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][5] = ""
	<%
	}
	if(object[0]!=null)
	{
	%>
	data_arr[<%= i%>][6] = "<%=object[2]%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][6] = ""
	<%
	}
	if(object[0]!=null)
	{
	%>
	data_arr[<%= i%>][7] = "<%=object[0]%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][7] = ""

	<%
	}
	//patientName = patientName.toString();
	if(object[1]!=null)
	{
	%>
	data_arr[<%= i%>][8] = "<%=object[1]%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][8] = ""
	<%}
	if(object[1]!= null)
	{
	%>

	data_arr[<%= i%>][9] = "<%=object[1]%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][9] = ""
	<%   }if(object[0]!=null){
	%>
	data_arr[<%= i%>][10] = "<%=object[0]%>"
	<%
	}else{
	%>
	data_arr[<%= i%>][10] = ""
	<%}
	if(object[0]!=null)
	{
	%>
	data_arr[<%= i%>][11] = "<%=object[0]%>"
	<%}else{%>
	data_arr[<%= i%>][11] =""
	<%}%>
	data_arr[<%=i%>][12] = '<input type="hidden" id="iCardStatus<%=i%>"  name="iCardStatus<%=i%>" value="<%=object[0]%>"  />'
	<%
	i++;
	}


	}catch(Exception e){
	e.printStackTrace();

	}
	%>

	formName = "ipdDialysisList"
	start = 0
	if(data_arr.length < rowsPerPage)
	end = data_arr.length;
	else
	end = rowsPerPage;
	makeGridForPatient(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>

<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=i %>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <input
	type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->
	</script> <script type="text/javascript">

	function validateICard(){
	var counter=document.getElementById("counter")
	for(var i = 0; i < document.getElementsByName('parent').length; i++){

	if(document.getElementsByName('parent')[i].checked == true)
	{
	var index=start+i;
	var status=document.getElementById('iCardStatus'+index).value
	if(status=="n")
	{
	alert("I-Card is not available with the patient.")
	return true;
	}
	//alert("I -Card Status for patient----:"+status)
	return true;
	}
	}
	alert("Please select the patient")
	return false;

	}

	function openTokenDisplay(deptId)
	{
	 var url="/hms/hms/opd?method=showPopupTokenJsp&deptId="+deptId;
	 newwindow=window.open(url,'name','_blank',"left=100,top=100,height=700,width=850,location=0,toolbar=0,menubar=0,status=no,scrollbars=yes,resizable=0");
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
	
	</script>

