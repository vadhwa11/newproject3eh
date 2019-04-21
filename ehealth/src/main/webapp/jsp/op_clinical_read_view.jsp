<%@page import="jkt.hms.masters.business.MasServiceCentreCounter"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
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
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20">  -->
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");

	String opdType = "";
	opdType =	(String)map.get("opdType");
	
	List<MasServiceCentreCounter> serviceCentreCounterList = null;
	MasHospital masHospital = null;
			
	List visitList = new ArrayList();
	int totalPatient=0;
	if(map.get("visitList") != null)
	{
		visitList=(List)map.get("visitList");
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
	
	String message1="";
	if (map.get("message1") != null) {
	deptName = (String) map.get("message1");
	}
	if (map.get("openMsg") != null) {
		message1 = (String) map.get("openMsg");
	}
	
	// added by amit das on 19-04-2017
		if(map.get("serviceCentreCounterList") != null)
		{
			serviceCentreCounterList=(List)map.get("serviceCentreCounterList");
		}

		// added by amit das on 19-04-2017
		if(map.get("masHospital") != null){
			masHospital =(MasHospital)map.get("masHospital");
		}
		
	
	%>

<div class="clear"></div>
<div class="Block">
<form name="opWaitingList" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="paddingTop25"></div>
<label class="auto">Token No</label>
<input type="text" name="tokenNo" id="tokenNo" validate="tokenNo,num,no" onkeypress="return searchKeyPress(event);" />
<label class="auto">Patient Name </label>
<input type="text" name="patientName" id="patientName" validate="patientName,alphanumeric,no" onkeypress="return searchKeyPress(event);"/>
<label class="auto">UHID</label>
<input type="text" name="uhid" id="uhid" validate="uhid,alphanumeric,no" onkeypress="return searchKeyPress(event);"/>
<input type="hidden" name="searchFlag" id="searchFlag" value="1"/>
<input type="button" class="buttonAuto"  id="search" name="search" value="Search" onClick="validate();" />
</form>

<form name="opd_OP_Clinic_Waiting_PatientList_forRecall" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<%
if(visitList.size()>0)
{
	totalPatient = visitList.size();
	 System.out.println("patientList in jsp "+visitList.size());
}%>
<div class="clear"></div>
<input type="hidden" value="<%=(opdType!=null)?opdType:""%>" id="opdType" name="opdType">
</form>
</div>

<div class="clear"></div>

<div class="floatleft">


<%-- <!-- added by amit das on 19-04-2017 -->
<% if(masHospital!=null &&  masHospital.getCounterWiseTokenDisplay()!=null && masHospital.getCounterWiseTokenDisplay().equalsIgnoreCase("y")) {%>
<!-- <h4>OP Clinic Counter</h4> -->

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="paddingTop5"></div>

<label style="font-size:15px;">OP Clinic Counter <span>*</span></label>
<select id="counterId" onchange="bookCounterForDoctor();">
<option value="0">Select Counter No</option>
 <% if(serviceCentreCounterList!=null) {
 	for(MasServiceCentreCounter masServiceCentreCounter : serviceCentreCounterList){
 	if(masServiceCentreCounter.getStatus()!=null && masServiceCentreCounter.getStatus().equalsIgnoreCase("b")){	
 %>
 <option value="<%=masServiceCentreCounter.getId()%>" selected="selected"><%=masServiceCentreCounter.getCounterNo()%></option>
 <%} else {%>
 <option value="<%=masServiceCentreCounter.getId()%>"><%=masServiceCentreCounter.getCounterNo()%></option>
 <% } 
 } }%>
</select>
<% } %> --%>

<!-- <div style="display:none"> -->
<jsp:include page="searchResultBlockForIPD.jsp" />
<!-- </div>
 -->
 </div>
<div class="clear"></div>	
<div id="test" class="">
<div id="searchresults" tabindex=2>
<div class="cmnTable"  id="searchtable" class="small" tabindex=2>

</div>
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
	data_header[1][0] =  "OP No.<b>&nbsp;/&nbsp;</b>Token No."
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
	data_header[6][0] = "Status"
	data_header[6][1] = "data";
	data_header[6][2] = "1%";
	
	data_header[7] = new Array;
	data_header[7][0] = "Priority"
	data_header[7][1] = "data";
	data_header[7][2] = "6%";
	
	data_arr = new Array();

	<%
	int  i=0;
	int j=1;
	try{
	String st="";
	//System.out.println("\tpatientList "+patientList.size());
	//Iterator iterator=parkVisitList.iterator();
	Iterator iterator=visitList.iterator();
	//System.out.println("parkVisitList "+parkVisitList.size());
	while(iterator.hasNext())
	{
		Visit visit= (Visit) iterator.next();
		if(visit!=null && visit.getVisitStatus().equalsIgnoreCase("c"))
		{
		Patient patientHin=(Patient)visit.getHin();
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
			if(visit.getDoctor().getFirstName()!=null && !visit.getDoctor().getFirstName().equals(" ")){
				doctorName= visit.getDoctor().getFirstName()+" ";
			}
			 if(visit.getDoctor().getMiddleName()!=null && !visit.getDoctor().getMiddleName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getMiddleName()+" ";
			}
			if(visit.getDoctor().getLastName()!=null && !visit.getDoctor().getLastName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getLastName();
			} 
		}
		String visitStatus="";
		
		Integer prioityNumber=3;
		MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
			String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		if(visit.getHin().getAge()!=null && !visit.getHin().getAge().equals("0")){
			age=visit.getHin().getAge();
		}
		if(visit.getPriorityNumber()!=null)
			prioityNumber=visit.getPriorityNumber();
		/* Added by Arbind on 03-05-2017 */
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
		data_arr[<%= i%>][2] = "<%=visit.getTotalHospitalVisit()+"/"+visit.getTokenNo()%> " 
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
		
		if(visit.getAge()!= null )
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
		
		if(visit.getVisitStatus()!= null)
		{%>
			data_arr[<%= i%>][7] = "<%=visitStatus%>"
		<%}else{%>
			data_arr[<%= i%>][7] = ""
		<%}%>
		
		data_arr[<%= i%>][8] ='<%=prioityNumber%>'
	<%	
		i++;
		}
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	%>

	formName = "opd_OP_Clinic_Waiting_PatientList_forRecall"

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
	function validate(){
		var patientName=document.getElementById("patientName").value;
		var opdType = document.getElementById("opdType").value;
		
		if(!chkInputLength(patientName))
			{alert("Patient Name should be 1 characher");}
		else if(opdType=='opdDeatail')
			submitForm('opWaitingList','/hms/hms/opd?method=getOPClinicalReadViewList&opdType=opdDeatail');
		else if(opdType=='opdLite')
			submitForm('opWaitingList','/hms/hms/opd?method=getOPClinicalReadViewList&opdType=opdLite');
		else
			submitForm('opWaitingList','/hms/hms/opd?method=getOPClinicalReadViewList');
	}
	function chkInputLength(strValue){
			if(strValue!="" && strValue.length<0){
				return false;
			}
			return true;
	}

	//window.moveTo(0,0);
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
	 newwindow=window.open(url,"","status=no,scrollbars=no,resizable=yes,height = 600, width = 800,fullscreen=yes");
	 newwindow.moveTo(1024,0);
	}
	
	function openSecondOpinion(deptId)
	{
	 var height=350;
	 var width=950;
	 var left = (screen.width/2)-(width/2);
	 var top = (screen.height/2)-(height/2);	
	 var url="/hms/hms/opd?method=showSecondOpnionListJsp&deptId="+deptId;
	 newwindow=window.open(url,"Second Opinion","status = no, height = "+height+", width =" +width+",top="+top+", left="+left);
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
	
	function searchKeyPress(e) {
		// look for window.event in case event isn't passed in
		e = e || window.event;
		if (e.keyCode == 13) {
			document.getElementById('search').click();
			return false;
		}
		return true;
	}
</script>

<%visitList=null;%>
